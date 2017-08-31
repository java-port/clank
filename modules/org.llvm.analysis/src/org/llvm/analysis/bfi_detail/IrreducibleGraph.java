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

package org.llvm.analysis.bfi_detail;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.DenseMapIteratorUIntType;
import org.llvm.adt.aliases.SmallDenseMapUIntType;
import org.llvm.analysis.*;


/// \brief Graph of irreducible control flow.
///
/// This graph is used for determining the SCCs in a loop (or top-level
/// function) that has irreducible control flow.
///
/// During the block frequency algorithm, the local graphs are defined in a
/// light-weight way, deferring to the \a BasicBlock or \a MachineBasicBlock
/// graphs for most edges, but getting others from \a LoopData::ExitMap.  The
/// latter only has successor information.
///
/// \a IrreducibleGraph makes this graph explicit.  It's in a form that can use
/// \a GraphTraits (so that \a analyzeIrreducible() can use \a scc_iterator),
/// and it explicitly lists predecessors and successors.  The initialization
/// that relies on \c MachineBasicBlock is defined in the header.
//<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::IrreducibleGraph">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 554,
 FQN="llvm::bfi_detail::IrreducibleGraph", NM="_ZN4llvm10bfi_detail16IrreducibleGraphE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm10bfi_detail16IrreducibleGraphE")
//</editor-fold>
public class/*struct*/ IrreducibleGraph implements Destructors.ClassWithDestructor {
  // JAVA: typedef BlockFrequencyInfoImplBase BFIBase
//  public final class BFIBase extends BlockFrequencyInfoImplBase{ };
  
  public final BlockFrequencyInfoImplBase /*&*/ BFI;
  
  // JAVA: typedef BFIBase::BlockNode BlockNode
//  public final class BlockNode extends BlockFrequencyInfoImplBase.BlockNode{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::IrreducibleGraph::IrrNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 560,
   FQN="llvm::bfi_detail::IrreducibleGraph::IrrNode", NM="_ZN4llvm10bfi_detail16IrreducibleGraph7IrrNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm10bfi_detail16IrreducibleGraph7IrrNodeE")
  //</editor-fold>
  public static class/*struct*/ IrrNode implements Destructors.ClassWithDestructor {
    public BlockFrequencyInfoImplBase.BlockNode Node;
    public /*uint*/int NumIn;
    public std.deque</*const*/ IrrNode /*P*/ > Edges;
    //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::IrreducibleGraph::IrrNode::IrrNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 564,
     FQN="llvm::bfi_detail::IrreducibleGraph::IrrNode::IrrNode", NM="_ZN4llvm10bfi_detail16IrreducibleGraph7IrrNodeC1ERKNS_26BlockFrequencyInfoImplBase9BlockNodeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm10bfi_detail16IrreducibleGraph7IrrNodeC1ERKNS_26BlockFrequencyInfoImplBase9BlockNodeE")
    //</editor-fold>
    public IrrNode(final /*const*/ BlockFrequencyInfoImplBase.BlockNode /*&*/ Node) {
      // : Node(Node), NumIn(0), Edges() 
      //START JInit
      this.Node = new BlockFrequencyInfoImplBase.BlockNode(Node);
      this.NumIn = 0;
      this.Edges = new std.deque</*const*/ IrrNode /*P*/ >(true);
      //END JInit
    }

    
    // JAVA: typedef std::deque<const IrrNode *>::const_iterator iterator
//    public final class iterator extends std._Deque_iterator</*const*/ IrrNode /*P*/ , /*const*/ IrrNode /*P*/ /*const*/ /*&*/ , type$ptr</*const*/ IrrNode /*P*/ /*const*/ /*P*/> >{ };
    //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::IrreducibleGraph::IrrNode::pred_begin">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 567,
     FQN="llvm::bfi_detail::IrreducibleGraph::IrrNode::pred_begin", NM="_ZNK4llvm10bfi_detail16IrreducibleGraph7IrrNode10pred_beginEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm10bfi_detail16IrreducibleGraph7IrrNode10pred_beginEv")
    //</editor-fold>
    public std.deque.iterator</*const*/ IrrNode /*P*/> pred_begin() /*const*/ {
      return Edges.begin$Const();
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::IrreducibleGraph::IrrNode::succ_begin">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 568,
     FQN="llvm::bfi_detail::IrreducibleGraph::IrrNode::succ_begin", NM="_ZNK4llvm10bfi_detail16IrreducibleGraph7IrrNode10succ_beginEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm10bfi_detail16IrreducibleGraph7IrrNode10succ_beginEv")
    //</editor-fold>
    public std.deque.iterator</*const*/ IrrNode /*P*/> succ_begin() /*const*/ {
      return Edges.begin$Const().$add(NumIn);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::IrreducibleGraph::IrrNode::pred_end">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 569,
     FQN="llvm::bfi_detail::IrreducibleGraph::IrrNode::pred_end", NM="_ZNK4llvm10bfi_detail16IrreducibleGraph7IrrNode8pred_endEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm10bfi_detail16IrreducibleGraph7IrrNode8pred_endEv")
    //</editor-fold>
    public std.deque.iterator</*const*/ IrrNode /*P*/> pred_end() /*const*/ {
      return succ_begin();
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::IrreducibleGraph::IrrNode::succ_end">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 570,
     FQN="llvm::bfi_detail::IrreducibleGraph::IrrNode::succ_end", NM="_ZNK4llvm10bfi_detail16IrreducibleGraph7IrrNode8succ_endEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm10bfi_detail16IrreducibleGraph7IrrNode8succ_endEv")
    //</editor-fold>
    public std.deque.iterator</*const*/ IrrNode /*P*/> succ_end() /*const*/ {
      return Edges.end$Const();
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::IrreducibleGraph::IrrNode::~IrrNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 560,
     FQN="llvm::bfi_detail::IrreducibleGraph::IrrNode::~IrrNode", NM="_ZN4llvm10bfi_detail16IrreducibleGraph7IrrNodeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm10bfi_detail16IrreducibleGraph7IrrNodeD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Edges.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::IrreducibleGraph::IrrNode::IrrNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 560,
     FQN="llvm::bfi_detail::IrreducibleGraph::IrrNode::IrrNode", NM="_ZN4llvm10bfi_detail16IrreducibleGraph7IrrNodeC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm10bfi_detail16IrreducibleGraph7IrrNodeC1ERKS2_")
    //</editor-fold>
    public /*inline*/ IrrNode(final /*const*/ IrrNode /*&*/ $Prm0) {
      // : Node(.Node), NumIn(.NumIn), Edges(.Edges) 
      //START JInit
      this.Node = new BlockFrequencyInfoImplBase.BlockNode($Prm0.Node);
      this.NumIn = $Prm0.NumIn;
      this.Edges = new std.deque</*const*/ IrrNode /*P*/ >($Prm0.Edges);
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Node=" + Node // NOI18N
                + ", NumIn=" + NumIn // NOI18N
                + ", Edges=" + Edges; // NOI18N
    }
  };
  public BlockFrequencyInfoImplBase.BlockNode Start;
  public /*const*/ IrrNode /*P*/ StartIrr;
  public std.vector<IrrNode> Nodes;
  public SmallDenseMapUIntType<IrrNode /*P*/ >/*<4>*/ Lookup;
  
  /// \brief Construct an explicit graph containing irreducible control flow.
  ///
  /// Construct an explicit graph of the control flow in \c OuterLoop (or the
  /// top-level function, if \c OuterLoop is \c nullptr).  Uses \c
  /// addBlockEdges to add block successors that have not been packaged into
  /// loops.
  ///
  /// \a BlockFrequencyInfoImpl::computeIrreducibleMass() is the only expected
  /// user of this.
  /*template <class BlockEdgesAdder> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::IrreducibleGraph::IrreducibleGraph">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 587,
   FQN="llvm::bfi_detail::IrreducibleGraph::IrreducibleGraph", NM="Tpl__ZN4llvm10bfi_detail16IrreducibleGraphC1ERNS_26BlockFrequencyInfoImplBaseEPKNS2_8LoopDataET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=Tpl__ZN4llvm10bfi_detail16IrreducibleGraphC1ERNS_26BlockFrequencyInfoImplBaseEPKNS2_8LoopDataET_")
  //</editor-fold>
  public IrreducibleGraph(final BlockFrequencyInfoImplBase /*&*/ BFI, /*const*/ BlockFrequencyInfoImplBase.LoopData /*P*/ OuterLoop, 
      BlockEdgesAdder addBlockEdges) {
    // : BFI(BFI), StartIrr(null) 
    //START JInit
    this./*&*/BFI=/*&*/BFI;
    this.StartIrr = null;
    //END JInit
    initialize(OuterLoop, addBlockEdges);
  }

  
  /*template <class BlockEdgesAdder> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::IrreducibleGraph::initialize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 610,
   FQN="llvm::bfi_detail::IrreducibleGraph::initialize", NM="Tpl__ZN4llvm10bfi_detail16IrreducibleGraph10initializeEPKNS_26BlockFrequencyInfoImplBase8LoopDataET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=Tpl__ZN4llvm10bfi_detail16IrreducibleGraph10initializeEPKNS_26BlockFrequencyInfoImplBase8LoopDataET_")
  //</editor-fold>
  public void initialize(/*const*/ BlockFrequencyInfoImplBase.LoopData /*P*/ OuterLoop, 
            BlockEdgesAdder addBlockEdges) {
    if ((OuterLoop != null)) {
      addNodesInLoop($Deref(OuterLoop));
      for (BlockFrequencyInfoImplBase.BlockNode N : OuterLoop.Nodes)  {
        addEdges(N, OuterLoop, addBlockEdges);
      }
    } else {
      addNodesInFunction();
      for (/*uint32_t*/int Index = 0; $less_uint(Index, BFI.Working.size()); ++Index)  {
        addEdges(new BlockFrequencyInfoImplBase.BlockNode(Index), OuterLoop, addBlockEdges);
      }
    }
    StartIrr = Lookup.$at_T1$C$R(Start.Index);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::IrreducibleGraph::addNodesInLoop">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 587,
   FQN="llvm::bfi_detail::IrreducibleGraph::addNodesInLoop", NM="_ZN4llvm10bfi_detail16IrreducibleGraph14addNodesInLoopERKNS_26BlockFrequencyInfoImplBase8LoopDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm10bfi_detail16IrreducibleGraph14addNodesInLoopERKNS_26BlockFrequencyInfoImplBase8LoopDataE")
  //</editor-fold>
  public void addNodesInLoop(final /*const*/ BlockFrequencyInfoImplBase.LoopData /*&*/ OuterLoop) {
    Start.$assignMove(OuterLoop.getHeader());
    Nodes.reserve(OuterLoop.Nodes.size());
    for (BlockFrequencyInfoImplBase.BlockNode N : OuterLoop.Nodes)  {
      addNode(N);
    }
    indexNodes();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::IrreducibleGraph::addNodesInFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 595,
   FQN="llvm::bfi_detail::IrreducibleGraph::addNodesInFunction", NM="_ZN4llvm10bfi_detail16IrreducibleGraph18addNodesInFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm10bfi_detail16IrreducibleGraph18addNodesInFunctionEv")
  //</editor-fold>
  public void addNodesInFunction() {
    Start.$assignMove(new BlockFrequencyInfoImplBase.BlockNode(0));
    for (/*uint32_t*/int Index = 0; $less_uint(Index, BFI.Working.size()); ++Index)  {
      if (!BFI.Working.$at(Index).isPackaged()) {
        addNode(new BlockFrequencyInfoImplBase.BlockNode(Index));
      }
    }
    indexNodes();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::IrreducibleGraph::addNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 598,
   FQN="llvm::bfi_detail::IrreducibleGraph::addNode", NM="_ZN4llvm10bfi_detail16IrreducibleGraph7addNodeERKNS_26BlockFrequencyInfoImplBase9BlockNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm10bfi_detail16IrreducibleGraph7addNodeERKNS_26BlockFrequencyInfoImplBase9BlockNodeE")
  //</editor-fold>
  public void addNode(final /*const*/ BlockFrequencyInfoImplBase.BlockNode /*&*/ Node) {
    Nodes.emplace_back(new IrrNode(Node));
    BFI.Working.$at(Node.Index).getMass().$assignMove(BlockMass.getEmpty());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::IrreducibleGraph::indexNodes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 603,
   FQN="llvm::bfi_detail::IrreducibleGraph::indexNodes", NM="_ZN4llvm10bfi_detail16IrreducibleGraph10indexNodesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm10bfi_detail16IrreducibleGraph10indexNodesEv")
  //</editor-fold>
  public void indexNodes() {
    for (final IrrNode /*&*/ I : Nodes)  {
      Lookup.$set(I.Node.Index, $AddrOf(I));
    }
  }


  /*template <class BlockEdgesAdder> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::IrreducibleGraph::addEdges">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 624,
   FQN="llvm::bfi_detail::IrreducibleGraph::addEdges", NM="Tpl__ZN4llvm10bfi_detail16IrreducibleGraph8addEdgesERKNS_26BlockFrequencyInfoImplBase9BlockNodeEPKNS2_8LoopDataET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=Tpl__ZN4llvm10bfi_detail16IrreducibleGraph8addEdgesERKNS_26BlockFrequencyInfoImplBase9BlockNodeEPKNS2_8LoopDataET_")
  //</editor-fold>
  public void addEdges(final /*const*/ BlockFrequencyInfoImplBase.BlockNode /*&*/ Node, 
          /*const*/ BlockFrequencyInfoImplBase.LoopData /*P*/ OuterLoop, 
          BlockEdgesAdder addBlockEdges) {
    DenseMapIteratorUIntType<IrrNode> L = Lookup.find(Node.Index);
    if (L.$eq(/*NO_ITER_COPY*/Lookup.end())) {
      return;
    }
    final IrrNode /*&*/ Irr = $Deref(L.$arrow().second);
    final /*const*/ BlockFrequencyInfoImplBase.WorkingData /*&*/ Working = BFI.Working.$at(Node.Index);
    if (Working.isAPackage()) {
      for (final /*const*/std.pairTypeType<BlockFrequencyInfoImplBase.BlockNode, BlockMass> /*&*/ I : Working.Loop.Exits)  {
        addEdge(Irr, I.first, OuterLoop);
      }
    } else {
      addBlockEdges.$call(/*Deref*/this, Irr, OuterLoop);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::IrreducibleGraph::addEdge">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 608,
   FQN="llvm::bfi_detail::IrreducibleGraph::addEdge", NM="_ZN4llvm10bfi_detail16IrreducibleGraph7addEdgeERNS1_7IrrNodeERKNS_26BlockFrequencyInfoImplBase9BlockNodeEPKNS4_8LoopDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm10bfi_detail16IrreducibleGraph7addEdgeERNS1_7IrrNodeERKNS_26BlockFrequencyInfoImplBase9BlockNodeEPKNS4_8LoopDataE")
  //</editor-fold>
  public void addEdge(final IrrNode /*&*/ Irr, final /*const*/ BlockFrequencyInfoImplBase.BlockNode /*&*/ Succ, 
         /*const*/ BlockFrequencyInfoImplBase.LoopData /*P*/ OuterLoop) {
    if ((OuterLoop != null) && OuterLoop.isHeader(Succ)) {
      return;
    }
    DenseMapIteratorUIntType<IrrNode> L = Lookup.find(Succ.Index);
    if (L.$eq(/*NO_ITER_COPY*/Lookup.end())) {
      return;
    }
    final IrrNode /*&*/ SuccIrr = $Deref(L.$arrow().second);
    Irr.Edges.push_back_T$RR($AddrOf(SuccIrr));
    SuccIrr.Edges.push_front_T$RR($AddrOf(Irr));
    ++SuccIrr.NumIn;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::IrreducibleGraph::~IrreducibleGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 554,
   FQN="llvm::bfi_detail::IrreducibleGraph::~IrreducibleGraph", NM="_ZN4llvm10bfi_detail16IrreducibleGraphD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm10bfi_detail16IrreducibleGraphD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Lookup.$destroy();
    Nodes.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "BFI=" + BFI // NOI18N
              + ", Start=" + Start // NOI18N
              + ", StartIrr=" + StartIrr // NOI18N
              + ", Nodes=" + Nodes // NOI18N
              + ", Lookup=" + Lookup; // NOI18N
  }
}
