/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import org.clank.java.stdimpl.aliases.StdVector;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.char$ptr;
import org.clank.support.aliases.type$ptr;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.StringRef;
import org.llvm.adt.aliases.DenseMap;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import static org.llvm.analysis.AnalysisLlvmGlobals.getWeightFromBranchProb;
import org.llvm.analysis.bfi_detail.*;


/// \brief Shared implementation for block frequency analysis.
///
/// This is a shared implementation of BlockFrequencyInfo and
/// MachineBlockFrequencyInfo, and calculates the relative frequencies of
/// blocks.
///
/// LoopInfo defines a loop as a "non-trivial" SCC dominated by a single block,
/// which is called the header.  A given loop, L, can have sub-loops, which are
/// loops within the subgraph of L that exclude its header.  (A "trivial" SCC
/// consists of a single block that does not have a self-edge.)
///
/// In addition to loops, this algorithm has limited support for irreducible
/// SCCs, which are SCCs with multiple entry blocks.  Irreducible SCCs are
/// discovered on they fly, and modelled as loops with multiple headers.
///
/// The headers of irreducible sub-SCCs consist of its entry blocks and all
/// nodes that are targets of a backedge within it (excluding backedges within
/// true sub-loops).  Block frequency calculations act as if a block is
/// inserted that intercepts all the edges to the headers.  All backedges and
/// entries point to this block.  Its successors are the headers, which split
/// the frequency evenly.
///
/// This algorithm leverages BlockMass and ScaledNumber to maintain precision,
/// separates mass distribution from loop scaling, and dithers to eliminate
/// probability mass loss.
///
/// The implementation is split between BlockFrequencyInfoImpl, which knows the
/// type of graph being modelled (BasicBlock vs. MachineBasicBlock), and
/// BlockFrequencyInfoImplBase, which doesn't.  The base class uses \a
/// BlockNode, a wrapper around a uint32_t.  BlockNode is numbered from 0 in
/// reverse-post order.  This gives two advantages:  it's easy to compare the
/// relative ordering of two nodes, and maps keyed on BlockT can be represented
/// by vectors.
///
/// This algorithm is O(V+E), unless there is irreducible control flow, in
/// which case it's O(V*E) in the worst case.
///
/// These are the main stages:
///
///  0. Reverse post-order traversal (\a initializeRPOT()).
///
///     Run a single post-order traversal and save it (in reverse) in RPOT.
///     All other stages make use of this ordering.  Save a lookup from BlockT
///     to BlockNode (the index into RPOT) in Nodes.
///
///  1. Loop initialization (\a initializeLoops()).
///
///     Translate LoopInfo/MachineLoopInfo into a form suitable for the rest of
///     the algorithm.  In particular, store the immediate members of each loop
///     in reverse post-order.
///
///  2. Calculate mass and scale in loops (\a computeMassInLoops()).
///
///     For each loop (bottom-up), distribute mass through the DAG resulting
///     from ignoring backedges and treating sub-loops as a single pseudo-node.
///     Track the backedge mass distributed to the loop header, and use it to
///     calculate the loop scale (number of loop iterations).  Immediate
///     members that represent sub-loops will already have been visited and
///     packaged into a pseudo-node.
///
///     Distributing mass in a loop is a reverse-post-order traversal through
///     the loop.  Start by assigning full mass to the Loop header.  For each
///     node in the loop:
///
///         - Fetch and categorize the weight distribution for its successors.
///           If this is a packaged-subloop, the weight distribution is stored
///           in \a LoopData::Exits.  Otherwise, fetch it from
///           BranchProbabilityInfo.
///
///         - Each successor is categorized as \a Weight::Local, a local edge
///           within the current loop, \a Weight::Backedge, a backedge to the
///           loop header, or \a Weight::Exit, any successor outside the loop.
///           The weight, the successor, and its category are stored in \a
///           Distribution.  There can be multiple edges to each successor.
///
///         - If there's a backedge to a non-header, there's an irreducible SCC.
///           The usual flow is temporarily aborted.  \a
///           computeIrreducibleMass() finds the irreducible SCCs within the
///           loop, packages them up, and restarts the flow.
///
///         - Normalize the distribution:  scale weights down so that their sum
///           is 32-bits, and coalesce multiple edges to the same node.
///
///         - Distribute the mass accordingly, dithering to minimize mass loss,
///           as described in \a distributeMass().
///
///     In the case of irreducible loops, instead of a single loop header,
///     there will be several. The computation of backedge masses is similar
///     but instead of having a single backedge mass, there will be one
///     backedge per loop header. In these cases, each backedge will carry
///     a mass proportional to the edge weights along the corresponding
///     path.
///
///     At the end of propagation, the full mass assigned to the loop will be
///     distributed among the loop headers proportionally according to the
///     mass flowing through their backedges.
///
///     Finally, calculate the loop scale from the accumulated backedge mass.
///
///  3. Distribute mass in the function (\a computeMassInFunction()).
///
///     Finally, distribute mass through the DAG resulting from packaging all
///     loops in the function.  This uses the same algorithm as distributing
///     mass in a loop, except that there are no exit or backedge edges.
///
///  4. Unpackage loops (\a unwrapLoops()).
///
///     Initialize each block's frequency to a floating point representation of
///     its mass.
///
///     Visit loops top-down, scaling the frequencies of its immediate members
///     by the loop's pseudo-node's frequency.
///
///  5. Convert frequencies to a 64-bit range (\a finalizeMetrics()).
///
///     Using the min and max frequencies as a guide, translate floating point
///     frequencies to an appropriate range in uint64_t.
///
/// It has some known flaws.
///
///   - The model of irreducible control flow is a rough approximation.
///
///     Modelling irreducible control flow exactly involves setting up and
///     solving a group of infinite geometric series.  Such precision is
///     unlikely to be worthwhile, since most of our algorithms give up on
///     irreducible control flow anyway.
///
///     Nevertheless, we might find that we need to get closer.  Here's a sort
///     of TODO list for the model with diminishing returns, to be completed as
///     necessary.
///
///       - The headers for the \a LoopData representing an irreducible SCC
///         include non-entry blocks.  When these extra blocks exist, they
///         indicate a self-contained irreducible sub-SCC.  We could treat them
///         as sub-loops, rather than arbitrarily shoving the problematic
///         blocks into the headers of the main irreducible SCC.
///
///       - Entry frequencies are assumed to be evenly split between the
///         headers of a given irreducible SCC, which is the only option if we
///         need to compute mass in the SCC before its parent loop.  Instead,
///         we could partially compute mass in the parent loop, and stop when
///         we get to the SCC.  Here, we have the correct ratio of entry
///         masses, which we can use to adjust their relative frequencies.
///         Compute mass in the SCC, and then continue propagation in the
///         parent.
///
///       - We can propagate mass iteratively through the SCC, for some fixed
///         number of iterations.  Each iteration starts by assigning the entry
///         blocks their backedge mass from the prior iteration.  The final
///         mass for each block (and each exit, and the total backedge mass
///         used for computing loop scale) is the sum of all iterations.
///         (Running this until fixed point would "solve" the geometric
///         series by simulation.)
/*template <class BT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 794,
 FQN="llvm::BlockFrequencyInfoImpl", NM="_ZN4llvm22BlockFrequencyInfoImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm22BlockFrequencyInfoImplE")
//</editor-fold>
public class BlockFrequencyInfoImpl</*class*/ BT>  extends /**/ BlockFrequencyInfoImplBase implements Destructors.ClassWithDestructor {
  // JAVA: typedef typename bfi_detail::TypeMap<BT>::BlockT BlockT
//  public final class BlockT extends  TypeMap.BlockT<BT>{ };
  // JAVA: typedef typename bfi_detail::TypeMap<BT>::FunctionT FunctionT
//  public final class FunctionT extends  TypeMap.FunctionT<BT>{ };
  // JAVA: typedef typename bfi_detail::TypeMap<BT>::BranchProbabilityInfoT BranchProbabilityInfoT
//  public final class BranchProbabilityInfoT extends  TypeMap.BranchProbabilityInfoT<BT>{ };
  // JAVA: typedef typename bfi_detail::TypeMap<BT>::LoopT LoopT
//  public final class LoopT extends  TypeMap.LoopT<BT>{ };
  // JAVA: typedef typename bfi_detail::TypeMap<BT>::LoopInfoT LoopInfoT
//  public final class LoopInfoT extends  TypeMap.LoopInfoT<BT>{ };
  
  // This is part of a workaround for a GCC 4.7 crash on lambdas.
  /*friend  struct bfi_detail::BlockEdgesAdder<BT>*/
  
  // JAVA: typedef GraphTraits<const BlockT *> Successor
//  public final class Successor extends GraphTraits</*const*/  TypeMap.BlockT<BT> /*P*/ >{ };
  // JAVA: typedef GraphTraits<Inverse<const BlockT *> > Predecessor
//  public final class Predecessor extends GraphTraits<Inverse</*const*/  TypeMap.BlockT<BT> /*P*/ > >{ };
  
  private /*const*/  BranchProbabilityInfo /*P*/ BPI;
  private /*const*/  LoopInfo /*P*/ LI;
  private /*const*/  Function /*P*/ F;
  
  // All blocks in reverse postorder.
  private std.vector</*const*/  BasicBlock /*P*/ > RPOT;
  private DenseMap</*const*/  BasicBlock /*P*/ , BlockFrequencyInfoImplBase.BlockNode> Nodes;
  
  // JAVA: typedef typename std::vector<const BlockT *>::const_iterator rpot_iterator
//  public final class rpot_iterator extends  std.vector.const_iterator</*const*/  TypeMap.BlockT<BT> /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::rpot_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 818,
   FQN="llvm::BlockFrequencyInfoImpl::rpot_begin", NM="_ZNK4llvm22BlockFrequencyInfoImpl10rpot_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm22BlockFrequencyInfoImpl10rpot_beginEv")
  //</editor-fold>
  private  StdVector.iterator</*const*/  BasicBlock /*P*/ > rpot_begin() /*const*/ {
    return RPOT.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::rpot_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 819,
   FQN="llvm::BlockFrequencyInfoImpl::rpot_end", NM="_ZNK4llvm22BlockFrequencyInfoImpl8rpot_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm22BlockFrequencyInfoImpl8rpot_endEv")
  //</editor-fold>
  private  StdVector.iterator</*const*/  BasicBlock /*P*/ > rpot_end() /*const*/ {
    return RPOT.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::getIndex">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 821,
   FQN="llvm::BlockFrequencyInfoImpl::getIndex", NM="_ZNK4llvm22BlockFrequencyInfoImpl8getIndexERKNSt6vectorIPKNS_10bfi_detail7TypeMapIT_E6BlockTESaIS8_EE14const_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm22BlockFrequencyInfoImpl8getIndexERKNSt6vectorIPKNS_10bfi_detail7TypeMapIT_E6BlockTESaIS8_EE14const_iteratorE")
  //</editor-fold>
  private /*size_t*/int getIndex(final /*const*/  StdVector.iterator</*const*/  BasicBlock /*P*/ > /*&*/ I) /*const*/ {
    return I.$sub(rpot_begin());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::getNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 823,
   FQN="llvm::BlockFrequencyInfoImpl::getNode", NM="_ZNK4llvm22BlockFrequencyInfoImpl7getNodeERKNSt6vectorIPKNS_10bfi_detail7TypeMapIT_E6BlockTESaIS8_EE14const_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm22BlockFrequencyInfoImpl7getNodeERKNSt6vectorIPKNS_10bfi_detail7TypeMapIT_E6BlockTESaIS8_EE14const_iteratorE")
  //</editor-fold>
  private BlockFrequencyInfoImplBase.BlockNode getNode(final /*const*/  StdVector.iterator</*const*/  BasicBlock /*P*/ > /*&*/ I) /*const*/ {
    return new BlockFrequencyInfoImplBase.BlockNode(getIndex(I));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::getNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 826,
   FQN="llvm::BlockFrequencyInfoImpl::getNode", NM="_ZNK4llvm22BlockFrequencyInfoImpl7getNodeEPKNS_10bfi_detail7TypeMapIT_E6BlockTE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm22BlockFrequencyInfoImpl7getNodeEPKNS_10bfi_detail7TypeMapIT_E6BlockTE")
  //</editor-fold>
  private BlockFrequencyInfoImplBase.BlockNode getNode(/*const*/  BasicBlock /*P*/ BB) /*const*/ {
    return Nodes.lookup(BB);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::getBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 828,
   FQN="llvm::BlockFrequencyInfoImpl::getBlock", NM="_ZNK4llvm22BlockFrequencyInfoImpl8getBlockERKNS_26BlockFrequencyInfoImplBase9BlockNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm22BlockFrequencyInfoImpl8getBlockERKNS_26BlockFrequencyInfoImplBase9BlockNodeE")
  //</editor-fold>
  private /*const*/  BasicBlock /*P*/ getBlock(final /*const*/ BlockFrequencyInfoImplBase.BlockNode /*&*/ Node) /*const*/ {
    assert Native.$bool(Native.$less(Node.Index, RPOT.size()));
    return RPOT.$at(Node.Index);
  }

  
  /// \brief Run (and save) a post-order traversal.
  ///
  /// Saves a reverse post-order traversal of all the nodes in \a F.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::initializeRPOT">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 998,
   FQN="llvm::BlockFrequencyInfoImpl::initializeRPOT", NM="_ZN4llvm22BlockFrequencyInfoImpl14initializeRPOTEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm22BlockFrequencyInfoImpl14initializeRPOTEv")
  //</editor-fold>
  private void initializeRPOT() {
    /*const*/  BasicBlock /*P*/ Entry = $AddrOf(F.front());
    RPOT.reserve(F.size());
    std.copy(AdtsupportLlvmGlobals.po_begin(GraphTraitsBasicBlock$P.$GTraits(), Entry), AdtsupportLlvmGlobals.po_end(GraphTraitsBasicBlock$P.$GTraits(), Entry), std.back_inserter(RPOT));
    std.reverse(RPOT.begin(), RPOT.end());
    assert Native.$bool(Native.$lesseq(RPOT.size()-1, BlockNode.getMaxIndex())) : "More nodes in function than Block Frequency Info supports";
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
        dbgs().$out(/*KEEP_STR*/"reverse-post-order-traversal\n");
      }
    } while (false);
    for ( StdVector.iterator<BasicBlock> I = rpot_begin(), E = rpot_end(); Native.$noteq_iter(I, E); I.$preInc()) {
      BlockFrequencyInfoImplBase.BlockNode Node = getNode(I);
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
          $out($out($out($out(dbgs().$out(/*KEEP_STR*/" - "), getIndex(I)), $(": ")), getBlockName(Node)), $LF);
        }
      } while (false);
      Nodes.$set(Native.$star(I), Node);
    }
    
    Working.reserve(RPOT.size());
    for (/*size_t*/int Index = 0; Native.$less(Index, RPOT.size()); ++Index)  {
      Working.emplace_back(new WorkingData(new BlockNode(Index)));
    }
    Freqs.resize(RPOT.size());
  }

  
  /// \brief Initialize loop data.
  ///
  /// Build up \a Loops using \a LoopInfo.  \a LoopInfo gives us a mapping from
  /// each block to the deepest loop it's in, but we need the inverse.  For each
  /// loop, we store in reverse post-order its "immediate" members, defined as
  /// the header, the headers of immediate sub-loops, and all other blocks in
  /// the loop that are not in sub-loops.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::initializeLoops">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 1020,
   FQN="llvm::BlockFrequencyInfoImpl::initializeLoops", NM="_ZN4llvm22BlockFrequencyInfoImpl15initializeLoopsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm22BlockFrequencyInfoImpl15initializeLoopsEv")
  //</editor-fold>
  private void initializeLoops() {
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
        dbgs().$out(/*KEEP_STR*/"loop-detection\n");
      }
    } while (false);
    if (LI.empty()) {
      return;
    }
    
    // Visit loops top down and assign them an index.
    std.deque<std.pair</*const*/  type$ptr<Loop /*P*/> , BlockFrequencyInfoImplBase.LoopData /*P*/ > > Q = new std.deque<std.pair</*const*/  type$ptr<Loop /*P*/> , BlockFrequencyInfoImplBase.LoopData /*P*/ > >(false);
    for (/*const*/  Loop /*P*/ L : Native.$star(LI))  {
      Q.emplace_back(make_pair_Ptr_Ptr(L, null));
    }
    while (Native.$not(Q.empty())) {
      /*const*/  type$ptr<Loop /*P*/> Loop = Q.front().first;
      BlockFrequencyInfoImplBase.LoopData /*P*/ Parent = Q.front().second;
      Q.pop_front();
      
      BlockFrequencyInfoImplBase.BlockNode Header = getNode(Loop.$star().getHeader());
      assert (Header.isValid());
      
      Loops.emplace_back(Parent, Header);
      Working.$at(Header.Index).Loop = $AddrOf(Loops.back());
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
          $out($out(dbgs().$out(/*KEEP_STR*/" - loop = "), getBlockName(Header)), $LF);
        }
      } while (false);
      
      for (/*const*/  Loop /*P*/ L : Loop.$array())  {
        Q.emplace_back(L, $AddrOf(Loops.back()));
      }
    }
    
    // Visit nodes in reverse post-order and add them to their deepest containing
    // loop.
    for (/*size_t*/int Index = 0; Native.$less(Index, RPOT.size()); ++Index) {
      // Loop headers have already been mostly mapped.
      if (Working.$at(Index).isLoopHeader()) {
        BlockFrequencyInfoImplBase.LoopData /*P*/ ContainingLoop = Working.$at(Index).getContainingLoop();
        if ((ContainingLoop != null)) {
          ContainingLoop.Nodes.push_back(new BlockFrequencyInfoImplBase.BlockNode(Index));
        }
        continue;
      }
      
      /*const*/  Loop /*P*/ Loop = LI.getLoopFor(RPOT.$at(Index));
      if (Native.$not(Loop)) {
        continue;
      }
      
      // Add this node to its containing loop's member list.
      BlockFrequencyInfoImplBase.BlockNode Header = getNode(Loop.getHeader());
      assert (Header.isValid());
      final WorkingData /*const*/ /*&*/ HeaderData = Working.$at(Header.Index);
      assert Native.$bool(HeaderData.isLoopHeader());
      
      Working.$at(Index).Loop = HeaderData.Loop;
      HeaderData.Loop.Nodes.push_back(new BlockNode(Index));
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
          $out($out($out($out(dbgs().$out(/*KEEP_STR*/" - loop = "), getBlockName(Header)), $(": member = ")), getBlockName(new BlockNode(Index))), $LF);
        }
      } while (false);
    }
  }

  
  /// \brief Propagate to a block's successors.
  ///
  /// In the context of distributing mass through \c OuterLoop, divide the mass
  /// currently assigned to \c Node between its successors.
  ///
  /// \return \c true unless there's an irreducible backedge.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::propagateMassToSuccessors">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 1193,
   FQN="llvm::BlockFrequencyInfoImpl::propagateMassToSuccessors", NM="_ZN4llvm22BlockFrequencyInfoImpl25propagateMassToSuccessorsEPNS_26BlockFrequencyInfoImplBase8LoopDataERKNS1_9BlockNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm22BlockFrequencyInfoImpl25propagateMassToSuccessorsEPNS_26BlockFrequencyInfoImplBase8LoopDataERKNS1_9BlockNodeE")
  //</editor-fold>
  private boolean propagateMassToSuccessors(BlockFrequencyInfoImplBase.LoopData /*P*/ OuterLoop, 
                           final /*const*/ BlockFrequencyInfoImplBase.BlockNode /*&*/ Node) {
    BlockFrequencyInfoImplBase.Distribution Dist = null;
    try {
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
          $out($out(dbgs().$out(/*KEEP_STR*/" - node: "), getBlockName(Node)), $LF);
        }
      } while (false);
      // Calculate probability for successors.
      Dist/*J*/= new BlockFrequencyInfoImplBase.Distribution();
      {
        LoopData /*P*/ Loop = Working.$at(Node.Index).getPackagedLoop();
        if (Loop != null) {
          assert Native.$bool(Native.$noteq(Loop, OuterLoop)) : "Cannot propagate mass in a packaged loop";
          if (Native.$not(addLoopSuccessorsToDist(OuterLoop, Native.$star(Loop), Dist))) {
            // Irreducible backedge.
            return false;
          }
        } else {
          /*const*/  BasicBlock /*P*/ BB = getBlock(Node);
          for (/*<dependent type>*/TerminatorInst.SuccIterator<TerminatorInst, BasicBlock> SI = GraphTraitsBasicBlock$P.$GTraits().child_begin(BB), SE = GraphTraitsBasicBlock$P.$GTraits().child_end(BB);
               Native.$noteq_iter(SI, SE); SI.$preInc())  {
            if (Native.$not(addToDist(Dist, OuterLoop, Node, getNode(Native.$star(SI)), 
                getWeightFromBranchProb(BPI.getEdgeProbability(BB, SI))))) {
              // Irreducible backedge.
              return false;
            }
          }
        }
      }
      
      // Distribute mass to successors, saving exit and backedge data in the
      // loop header.
      distributeMass(Node, OuterLoop, Dist);
      return true;
    } finally {
      if (Dist != null) { Dist.$destroy(); }
    }
  }

  
  /// \brief Compute mass in a particular loop.
  ///
  /// Assign mass to \c Loop's header, and then for each block in \c Loop in
  /// reverse post-order, distribute mass to its successors.  Only visits nodes
  /// that have not been packaged into sub-loops.
  ///
  /// \pre \a computeMassInLoop() has been called for each subloop of \c Loop.
  /// \return \c true unless there's an irreducible backedge.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::computeMassInLoop">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 1087,
   FQN="llvm::BlockFrequencyInfoImpl::computeMassInLoop", NM="_ZN4llvm22BlockFrequencyInfoImpl17computeMassInLoopERNS_26BlockFrequencyInfoImplBase8LoopDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm22BlockFrequencyInfoImpl17computeMassInLoopERNS_26BlockFrequencyInfoImplBase8LoopDataE")
  //</editor-fold>
  private boolean computeMassInLoop(final BlockFrequencyInfoImplBase.LoopData /*&*/ Loop) {
    // Compute mass in loop.
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
        $out($out(dbgs().$out(/*KEEP_STR*/"compute-mass-in-loop: "), getLoopName(Loop)), $LF);
      }
    } while (false);
    if (Loop.isIrreducible()) {
      BlockMass Remaining = BlockMass.getFull();
      for (/*uint32_t*/int H = 0; $less_uint(H, Loop.NumHeaders); ++H) {
        final BlockMass /*&*/ Mass = Working.$at(Loop.Nodes.$at(H).Index).getMass();
        Mass.$assign(Bfi_detailGlobals.$star_BlockMass_BranchProbability(/*NO_COPY*/Remaining, new BranchProbability(1, Loop.NumHeaders - H)));
        Remaining.$minusassign(Mass);
      }
      for (final /*const*/ BlockFrequencyInfoImplBase.BlockNode /*&*/ M : Loop.Nodes)  {
        if (Native.$not(propagateMassToSuccessors($AddrOf(Loop), M))) {
          throw new llvm_unreachable("unhandled irreducible control flow");
        }
      }
      
      adjustLoopHeaderMass(Loop);
    } else {
      Working.$at(Loop.getHeader().Index).getMass().$assign(BlockMass.getFull());
      if (Native.$not(propagateMassToSuccessors($AddrOf(Loop), Loop.getHeader()))) {
        throw new llvm_unreachable("irreducible control flow to loop header!?");
      }
      for (final /*const*/ BlockFrequencyInfoImplBase.BlockNode /*&*/ M : Loop.members())  {
        if (Native.$not(propagateMassToSuccessors($AddrOf(Loop), M))) {
          // Irreducible backedge.
          return false;
        }
      }
    }
    
    computeLoopScale(Loop);
    packageLoop(Loop);
    return true;
  }

  
  /// \brief Try to compute mass in the top-level function.
  ///
  /// Assign mass to the entry block, and then for each block in reverse
  /// post-order, distribute mass to its successors.  Skips nodes that have
  /// been packaged into loops.
  ///
  /// \pre \a computeMassInLoops() has been called.
  /// \return \c true unless there's an irreducible backedge.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::tryToComputeMassInFunction">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 1119,
   FQN="llvm::BlockFrequencyInfoImpl::tryToComputeMassInFunction", NM="_ZN4llvm22BlockFrequencyInfoImpl26tryToComputeMassInFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm22BlockFrequencyInfoImpl26tryToComputeMassInFunctionEv")
  //</editor-fold>
  private boolean tryToComputeMassInFunction() {
    // Compute mass in function.
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
        dbgs().$out(/*KEEP_STR*/"compute-mass-in-function\n");
      }
    } while (false);
    assert Native.$bool(Native.$not(Working.empty())) : "no blocks in function";
    assert Native.$bool(Native.$not(Working.$at(0).isLoopHeader())) : "entry block is a loop header";
    
    Working.$at(0).getMass().$assign(BlockMass.getFull());
    for ( StdVector.iterator</*const*/  BasicBlock /*P*/ > I = rpot_begin(), IE = rpot_end(); Native.$noteq_iter(I, IE); I.$preInc()) {
      // Check for nodes that have been packaged.
      BlockFrequencyInfoImplBase.BlockNode Node = getNode(I);
      if (Working.$at(Node.Index).isPackaged()) {
        continue;
      }
      if (Native.$not(propagateMassToSuccessors(null, Node))) {
        return false;
      }
    }
    return true;
  }

  
  /// \brief Compute mass in (and package up) irreducible SCCs.
  ///
  /// Find the irreducible SCCs in \c OuterLoop, add them to \a Loops (in front
  /// of \c Insert), and call \a computeMassInLoop() on each of them.
  ///
  /// If \c OuterLoop is \c nullptr, it refers to the top-level function.
  ///
  /// \pre \a computeMassInLoop() has been called for each subloop of \c
  /// OuterLoop.
  /// \pre \c Insert points at the last loop successfully processed by \a
  /// computeMassInLoop().
  /// \pre \c OuterLoop has irreducible SCCs.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::computeIrreducibleMass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 1167,
   FQN="llvm::BlockFrequencyInfoImpl::computeIrreducibleMass", NM="_ZN4llvm22BlockFrequencyInfoImpl22computeIrreducibleMassEPNS_26BlockFrequencyInfoImplBase8LoopDataESt14_List_iteratorIS2_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm22BlockFrequencyInfoImpl22computeIrreducibleMassEPNS_26BlockFrequencyInfoImplBase8LoopDataESt14_List_iteratorIS2_E")
  //</editor-fold>
  private void computeIrreducibleMass(BlockFrequencyInfoImplBase.LoopData /*P*/ OuterLoop, std.list.iterator<BlockFrequencyInfoImplBase.LoopData> Insert) {
    IrreducibleGraph G = null;
    try {
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
          dbgs().$out(/*KEEP_STR*/"analyze-irreducible-in-");
          if ((OuterLoop != null)) {
            $out($out(dbgs().$out(/*KEEP_STR*/"loop: "), getLoopName($Deref(OuterLoop))), $LF);
          } else {
            dbgs().$out(/*KEEP_STR*/"function\n");
          }
        }
      } while (false);
      
      //JAVA: using namespace bfi_detail;
      // Ideally, addBlockEdges() would be declared here as a lambda, but that
      // crashes GCC 4.7.
      BlockEdgesAdder<BT> addBlockEdges/*J*/= /*ParenList*/new BlockEdgesAdder<BT>(Native.$star(this));
      G/*J*/= /*ParenList*/new IrreducibleGraph(Native.$star(this), OuterLoop, addBlockEdges);
      
      for (final LoopData /*&*/ L : analyzeIrreducible(G, OuterLoop, Insert))  {
        computeMassInLoop(L);
      }
      if (!(OuterLoop != null)) {
        return;
      }
      updateLoopWithIrreducible($Deref(OuterLoop));
    } finally {
      if (G != null) { G.$destroy(); }
    }
  }

  
  /// \brief Compute mass in all loops.
  ///
  /// For each loop bottom-up, call \a computeMassInLoop().
  ///
  /// \a computeMassInLoop() aborts (and returns \c false) on loops that
  /// contain a irreducible sub-SCCs.  Use \a computeIrreducibleMass() and then
  /// re-enter \a computeMassInLoop().
  ///
  /// \post \a computeMassInLoop() has returned \c true for every loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::computeMassInLoops">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 1073,
   FQN="llvm::BlockFrequencyInfoImpl::computeMassInLoops", NM="_ZN4llvm22BlockFrequencyInfoImpl18computeMassInLoopsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm22BlockFrequencyInfoImpl18computeMassInLoopsEv")
  //</editor-fold>
  private void computeMassInLoops() {
    // Visit loops with the deepest first, and the top-level loops last.
    for (reverse_iterator<LoopData> L = Loops.rbegin(), E = Loops.rend(); Native.$noteq_iter(L, E); L.$preInc()) {
      if (computeMassInLoop(Native.$star(L))) {
        continue;
      }
      reverse_iterator<LoopData> Next = std.next(L);
      computeIrreducibleMass($AddrOf(Native.$star(L)), (std_list.list.iterator<LoopData>) L.base());
      L = std.prev(Next);
      if (computeMassInLoop(Native.$star(L))) {
        continue;
      }
      throw new llvm_unreachable("unhandled irreducible control flow");
    }
  }

  
  /// \brief Compute mass in the top-level function.
  ///
  /// Uses \a tryToComputeMassInFunction() and \a computeIrreducibleMass() to
  /// compute mass in the top-level function.
  ///
  /// \post \a tryToComputeMassInFunction() has returned \c true.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::computeMassInFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 1139,
   FQN="llvm::BlockFrequencyInfoImpl::computeMassInFunction", NM="_ZN4llvm22BlockFrequencyInfoImpl21computeMassInFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm22BlockFrequencyInfoImpl21computeMassInFunctionEv")
  //</editor-fold>
  private void computeMassInFunction() {
    if (tryToComputeMassInFunction()) {
      return;
    }
    computeIrreducibleMass(null, Loops.begin());
    if (tryToComputeMassInFunction()) {
      return;
    }
    throw new llvm_unreachable("unhandled irreducible control flow");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::getBlockName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 909,
   FQN="llvm::BlockFrequencyInfoImpl::getBlockName", NM="_ZNK4llvm22BlockFrequencyInfoImpl12getBlockNameERKNS_26BlockFrequencyInfoImplBase9BlockNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm22BlockFrequencyInfoImpl12getBlockNameERKNS_26BlockFrequencyInfoImplBase9BlockNodeE")
  //</editor-fold>
  @Override public/*private*/ std.string getBlockName(final /*const*/ BlockFrequencyInfoImplBase.BlockNode /*&*/ Node) /*const*//* override*/ {
    return Bfi_detailGlobals.getBlockName(getBlock(Node));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::getFunction">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 914,
   FQN="llvm::BlockFrequencyInfoImpl::getFunction", NM="_ZNK4llvm22BlockFrequencyInfoImpl11getFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm22BlockFrequencyInfoImpl11getFunctionEv")
  //</editor-fold>
  public /*const*/  Function /*P*/ getFunction() /*const*/ {
    return F;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::calculate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 955,
   FQN="llvm::BlockFrequencyInfoImpl::calculate", NM="_ZN4llvm22BlockFrequencyInfoImpl9calculateERKNS_10bfi_detail7TypeMapIT_E9FunctionTERKNS4_22BranchProbabilityInfoTERKNS4_9LoopInfoTE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm22BlockFrequencyInfoImpl9calculateERKNS_10bfi_detail7TypeMapIT_E9FunctionTERKNS4_22BranchProbabilityInfoTERKNS4_9LoopInfoTE")
  //</editor-fold>
  public void calculate(final /*const*/  Function /*&*/ F, 
           final /*const*/  BranchProbabilityInfo /*&*/ BPI, 
           final /*const*/  LoopInfo /*&*/ LI) {
    // Save the parameters.
    this.BPI = $AddrOf(BPI);
    this.LI = $AddrOf(LI);
    this.F = $AddrOf(F);
    
    // Clean up left-over data structures.
    super.clear();
    RPOT.clear();
    Nodes.clear();
    
    // Initialize.
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
        $out($out($out($out(dbgs().$out(/*KEEP_STR*/"\nblock-frequency: "), F.getName()), $("\n=================")), new std.string(F.getName().size(), $$EQ)), $LF);
      }
    } while (false);
    initializeRPOT();
    initializeLoops();
    
    // Visit loops in post-order to find the local mass distribution, and then do
    // the full function.
    computeMassInLoops();
    computeMassInFunction();
    unwrapLoops();
    finalizeMetrics();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::BlockFrequencyInfoImpl<BT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 918,
   FQN="llvm::BlockFrequencyInfoImpl::BlockFrequencyInfoImpl<BT>", NM="_ZN4llvm22BlockFrequencyInfoImplC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm22BlockFrequencyInfoImplC1Ev")
  //</editor-fold>
  public BlockFrequencyInfoImpl() {
    // : BPI(null), LI(null), F(null) 
    //START JInit
    this.BPI = /*ParenListExpr*/null;
    this.LI = /*ParenListExpr*/null;
    this.F = /*ParenListExpr*/null;
    //END JInit
  }

  
  //JAVA: using BlockFrequencyInfoImplBase::getEntryFreq;
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::getBlockFreq">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 921,
   FQN="llvm::BlockFrequencyInfoImpl::getBlockFreq", NM="_ZNK4llvm22BlockFrequencyInfoImpl12getBlockFreqEPKNS_10bfi_detail7TypeMapIT_E6BlockTE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm22BlockFrequencyInfoImpl12getBlockFreqEPKNS_10bfi_detail7TypeMapIT_E6BlockTE")
  //</editor-fold>
  public BlockFrequency getBlockFreq(/*const*/  BasicBlock /*P*/ BB) /*const*/ {
    return super.getBlockFreq(getNode(BB));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::getBlockProfileCount">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 924,
   FQN="llvm::BlockFrequencyInfoImpl::getBlockProfileCount", NM="_ZNK4llvm22BlockFrequencyInfoImpl20getBlockProfileCountERKNS_8FunctionEPKNS_10bfi_detail7TypeMapIT_E6BlockTE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm22BlockFrequencyInfoImpl20getBlockProfileCountERKNS_8FunctionEPKNS_10bfi_detail7TypeMapIT_E6BlockTE")
  //</editor-fold>
  public OptionalULong getBlockProfileCount(final /*const*/ Function /*&*/ F, 
                      /*const*/  BasicBlock /*P*/ BB) /*const*/ {
    return super.getBlockProfileCount(F, getNode(BB));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::setBlockFreq">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 983,
   FQN="llvm::BlockFrequencyInfoImpl::setBlockFreq", NM="_ZN4llvm22BlockFrequencyInfoImpl12setBlockFreqEPKNS_10bfi_detail7TypeMapIT_E6BlockTEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm22BlockFrequencyInfoImpl12setBlockFreqEPKNS_10bfi_detail7TypeMapIT_E6BlockTEy")
  //</editor-fold>
  public void setBlockFreq(/*const*/  BasicBlock /*P*/ BB, long/*uint64_t*/ Freq) {
    if (Nodes.count(BB) != 0) {
      super.setBlockFreq(getNode(BB), Freq);
    } else {
      // If BB is a newly added block after BFI is done, we need to create a new
      // BlockNode for it assigned with a new index. The index can be determined
      // by the size of Freqs.
      BlockFrequencyInfoImplBase.BlockNode NewNode/*J*/= /*ParenList*/new BlockFrequencyInfoImplBase.BlockNode(Freqs.size());
      Nodes.$set(BB, NewNode);
      Freqs.emplace_back();
      super.setBlockFreq(NewNode, Freq);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::getFloatingBlockFreq">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 929,
   FQN="llvm::BlockFrequencyInfoImpl::getFloatingBlockFreq", NM="_ZNK4llvm22BlockFrequencyInfoImpl20getFloatingBlockFreqEPKNS_10bfi_detail7TypeMapIT_E6BlockTE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm22BlockFrequencyInfoImpl20getFloatingBlockFreqEPKNS_10bfi_detail7TypeMapIT_E6BlockTE")
  //</editor-fold>
  public ScaledNumberULLong getFloatingBlockFreq(/*const*/  BasicBlock /*P*/ BB) /*const*/ {
    return super.getFloatingBlockFreq(getNode(BB));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::getBPI">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 933,
   FQN="llvm::BlockFrequencyInfoImpl::getBPI", NM="_ZNK4llvm22BlockFrequencyInfoImpl6getBPIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm22BlockFrequencyInfoImpl6getBPIEv")
  //</editor-fold>
  public /*const*/  BranchProbabilityInfo /*&*/ getBPI() /*const*/ {
    return Native.$star(BPI);
  }

  
  /// \brief Print the frequencies for the current function.
  ///
  /// Prints the frequencies for the blocks in the current function.
  ///
  /// Blocks are printed in the natural iteration order of the function, rather
  /// than reverse post-order.  This provides two advantages:  writing -analyze
  /// tests is easier (since blocks come out in source order), and even
  /// unreachable blocks are printed.
  ///
  /// \a BlockFrequencyInfoImplBase::print() only knows reverse post-order, so
  /// we need to override it here.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::print">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 1221,
   FQN="llvm::BlockFrequencyInfoImpl::print", NM="_ZNK4llvm22BlockFrequencyInfoImpl5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm22BlockFrequencyInfoImpl5printERNS_11raw_ostreamE")
  //</editor-fold>
  @Override public raw_ostream /*&*/ print(final raw_ostream /*&*/ OS) /*const*//* override*/ {
    if (Native.$not(F)) {
      return OS;
    }
    $out($out(OS.$out(/*KEEP_STR*/"block-frequency-info: "), F.getName()), $LF);
    for (final /*const*/  BasicBlock /*&*/ BB : Native.$star(F)) {
      $out($out(OS.$out(/*KEEP_STR*/" - "), Bfi_detailGlobals.getBlockName($AddrOf(BB))), $(": float = "));
      $out($out($out(getFloatingBlockFreq($AddrOf(BB)).print(OS, 5), 
                  $(", int = ")), getBlockFreq($AddrOf(BB)).getFrequency()), $LF);
    }
    
    // Add an extra newline for readability.
    OS.$out(/*KEEP_STR*/$LF);
    return OS;
  }

  //JAVA: using BlockFrequencyInfoImplBase::dump;
  
  //JAVA: using BlockFrequencyInfoImplBase::printBlockFreq;
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImpl::printBlockFreq">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 950,
   FQN="llvm::BlockFrequencyInfoImpl::printBlockFreq", NM="_ZNK4llvm22BlockFrequencyInfoImpl14printBlockFreqERNS_11raw_ostreamEPKNS_10bfi_detail7TypeMapIT_E6BlockTE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm22BlockFrequencyInfoImpl14printBlockFreqERNS_11raw_ostreamEPKNS_10bfi_detail7TypeMapIT_E6BlockTE")
  //</editor-fold>
  public raw_ostream /*&*/ printBlockFreq(final raw_ostream /*&*/ OS, /*const*/  BasicBlock /*P*/ BB) /*const*/ {
    return super.printBlockFreq(OS, getNode(BB));
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static raw_ostream $out(raw_ostream OS, StringRef Str) {
    return OS.$out(Str);
  }

  public static raw_ostream $out(raw_ostream OS, char$ptr Str) {
    return OS.$out(Str);
  }

  public static raw_ostream $out(raw_ostream OS, String Str) {
    return OS.$out(Str);
  }

  public static raw_ostream $out(raw_ostream OS, std.string Str) {
    return OS.$out(Str);
  }

  public static raw_ostream $out(raw_ostream OS, long Str) {
    return OS.$out(Str);
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BPI=" + BPI // NOI18N
              + ", LI=" + LI // NOI18N
              + ", F=" + F // NOI18N
              + ", RPOT=" + RPOT // NOI18N
              + ", Nodes=" + Nodes // NOI18N
              + super.toString(); // NOI18N
  }
}
