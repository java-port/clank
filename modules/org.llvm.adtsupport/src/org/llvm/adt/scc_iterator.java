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

package org.llvm.adt;

import org.clank.java.std;
import org.clank.support.Converted;
import org.clank.support.Destructors;
import org.clank.support.Native;
import static org.clank.support.Native.*;
import org.clank.support.aliases.type$iterator;
import org.llvm.adt.aliases.DenseMapInfo$LikePtr;
import org.llvm.adt.aliases.DenseMapIteratorTypeInt;
import org.llvm.adt.aliases.DenseMapTypeInt;
import org.llvm.adt.java.GraphTraits;


/// \brief Enumerate the SCCs of a directed graph in reverse topological order
/// of the SCC DAG.
///
/// This is implemented using Tarjan's DFS algorithm using an internal stack to
/// build up a vector of nodes in a particular SCC. Note that it is a forward
/// iterator and thus you cannot backtrack or re-visit nodes.
/*template <class GraphT, class GT = GraphTraits<GraphT>> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::scc_iterator">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/SCCIterator.h", line = 39,
 FQN="llvm::scc_iterator", NM="_ZN4llvm12scc_iteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm12scc_iteratorE")
//</editor-fold>
public class scc_iterator</*class*/ GraphT, /*class*/ /*GT = GraphTraits<GraphT>*/ NodeRef, ChildNodeType>
        extends /*public*/ iterator_facade_base<scc_iterator<GraphT, NodeRef, ChildNodeType>, 
        std.forward_iterator_tag, /*const*/ std.vector<NodeRef>, std.vector<NodeRef>>
        implements Destructors.ClassWithDestructor{
  // JAVA: typedef typename GT::NodeRef NodeRef
//  public final class NodeRef extends  NodeRef{ };
  // JAVA: typedef typename GT::ChildIteratorType ChildItTy
//  public final class ChildItTy extends  GT.ChildIteratorType{ };
  // JAVA: typedef std::vector<NodeRef> SccTy
//  public final class SccTy extends std.vector< NodeRef>{ };
  // JAVA: typedef typename scc_iterator<GraphT, GT>::reference reference
//  public final class reference extends  scc_iterator.reference<GraphT, GT>{ };

  /// Element of VisitStack during DFS.
  //<editor-fold defaultstate="collapsed" desc="llvm::scc_iterator::StackElement">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SCCIterator.h", line = 49,
   FQN="llvm::scc_iterator::StackElement", NM="_ZN4llvm12scc_iterator12StackElementE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm12scc_iterator12StackElementE")
  //</editor-fold>
  private class/*struct*/ StackElement implements Native.NativeComparable<StackElement> {
    public  NodeRef Node; ///< The current node pointer.
    public  /*GT.ChildIteratorType*/type$iterator<?, ChildNodeType> NextChild; ///< The next child, modified inplace during DFS.
    public /*uint*/int MinVisited; ///< Minimum uplink value of all children of Node.

    //<editor-fold defaultstate="collapsed" desc="llvm::scc_iterator::StackElement::StackElement">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/SCCIterator.h", line = 54,
     FQN="llvm::scc_iterator::StackElement::StackElement", NM="_ZN4llvm12scc_iterator12StackElementC1ENT0_7NodeRefERKNS2_17ChildIteratorTypeEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm12scc_iterator12StackElementC1ENT0_7NodeRefERKNS2_17ChildIteratorTypeEj")
    //</editor-fold>
    public StackElement( NodeRef Node, final /*const*/  type$iterator<? extends type$iterator, ChildNodeType> /*&*/ Child, /*uint*/int Min) {
      // : Node(Node), NextChild(Child), MinVisited(Min)
      //START JInit
      this.Node = /*ParenListExpr*/$tryClone(Node);
      this.NextChild = /*ParenListExpr*/$tryClone(Child);
      this.MinVisited = Min;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::scc_iterator::StackElement::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/SCCIterator.h", line = 57,
     FQN="llvm::scc_iterator::StackElement::operator==", NM="_ZNK4llvm12scc_iterator12StackElementeqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZNK4llvm12scc_iterator12StackElementeqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ StackElement /*&*/ Other) /*const*/ {
      return Native.$bool(Native.$bool(Native.$eq(Node, Other.Node))
         && Native.$bool(Native.$eq(NextChild, Other.NextChild)))
         && Native.$bool(Native.$eq(MinVisited, Other.MinVisited));
    }


    @Override public String toString() {
      return "" + "Node=" + Node // NOI18N
                + ", NextChild=" + NextChild // NOI18N
                + ", MinVisited=" + MinVisited; // NOI18N
    }
  };

  /// The visit counters used to detect when a complete SCC is on the stack.
  /// visitNum is the global counter.
  ///
  /// nodeVisitNumbers are per-node visit numbers, also used as DFS flags.
  private /*uint*/int visitNum;
  private final DenseMapTypeInt<NodeRef> nodeVisitNumbers = new DenseMapTypeInt<NodeRef>(DenseMapInfo$LikePtr.$Info(), 0);

  /// Stack holding nodes of the SCC.
  private final std.vector< NodeRef> SCCNodeStack = new std.vector((NodeRef) null);

  /// The current SCC, retrieved using operator*().
  private final std.vector< NodeRef> CurrentSCC = new std.vector((NodeRef) null);

  /// DFS stack, Used to maintain the ordering.  The top contains the current
  /// node, the next child to visit, and the minimum uplink value of all child
  private final std.vector<StackElement> VisitStack = new std.vector((StackElement) null);

  /// A single "visit" within the non-recursive DFS traversal.
  //<editor-fold defaultstate="collapsed" desc="llvm::scc_iterator::DFSVisitOne">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SCCIterator.h", line = 140,
   FQN="llvm::scc_iterator::DFSVisitOne", NM="_ZN4llvm12scc_iterator11DFSVisitOneENT0_7NodeRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm12scc_iterator11DFSVisitOneENT0_7NodeRefE")
  //</editor-fold>
  private void DFSVisitOne( NodeRef N) {
    ++visitNum;
    nodeVisitNumbers.ref$at(N).$assign(visitNum);
    SCCNodeStack.push_back(N);
    VisitStack.push_back(new StackElement(N, GT.child_begin(N), visitNum));
  }


  /// The stack-based DFS traversal; defined below.
  //<editor-fold defaultstate="collapsed" desc="llvm::scc_iterator::DFSVisitChildren">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SCCIterator.h", line = 152,
   FQN="llvm::scc_iterator::DFSVisitChildren", NM="_ZN4llvm12scc_iterator16DFSVisitChildrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm12scc_iterator16DFSVisitChildrenEv")
  //</editor-fold>
  private void DFSVisitChildren() {
    assert Native.$bool(Native.$not(VisitStack.empty()));
    while (Native.$noteq_iter(VisitStack.back().NextChild, GT.child_end(VisitStack.back().Node))) {
      // TOS has at least one more child so continue DFS
      NodeRef childN = (NodeRef)$Deref(VisitStack.back().NextChild.$postInc().$star());
      DenseMapIteratorTypeInt<NodeRef> Visited = nodeVisitNumbers.find(childN);
      if (Native.$eq_iter(Visited, nodeVisitNumbers.end())) {
        // this node has never been seen.
        DFSVisitOne(childN);
        continue;
      }

      /*uint*/int childNum = Visited.$star().second;
      if (Native.$greater(VisitStack.back().MinVisited, childNum)) {
        VisitStack.back().MinVisited = childNum;
      }
    }
  }


  /// Compute the next SCC using the DFS traversal.
  //<editor-fold defaultstate="collapsed" desc="llvm::scc_iterator::GetNextSCC">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SCCIterator.h", line = 172,
   FQN="llvm::scc_iterator::GetNextSCC", NM="_ZN4llvm12scc_iterator10GetNextSCCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm12scc_iterator10GetNextSCCEv")
  //</editor-fold>
  private void GetNextSCC() {
    CurrentSCC.clear(); // Prepare to compute the next SCC
    while (Native.$not(VisitStack.empty())) {
      DFSVisitChildren();

      // Pop the leaf on top of the VisitStack.
       NodeRef visitingN = VisitStack.back().Node;
      /*uint*/int minVisitNum = VisitStack.back().MinVisited;
      assert Native.$bool(Native.$eq_iter(VisitStack.back().NextChild, GT.child_end(visitingN)));
      VisitStack.pop_back();

      // Propagate MinVisitNum to parent so we can detect the SCC starting node.
      if (Native.$not(VisitStack.empty()) && Native.$bool(Native.$greater(VisitStack.back().MinVisited, minVisitNum))) {
        VisitStack.back().MinVisited = minVisitNum;
      }
      if (Native.$noteq(minVisitNum, nodeVisitNumbers.$at(visitingN))) {
        continue;
      }

      // A full SCC is on the SCCNodeStack!  It includes all nodes below
      // visitingN on the stack.  Copy those nodes to CurrentSCC,
      // reset their minVisit values, and return (this suspends
      // the DFS traversal till the next ++).
      do {
        CurrentSCC.push_back(SCCNodeStack.back());
        SCCNodeStack.pop_back();
        nodeVisitNumbers.ref$at(CurrentSCC.back()).$assign(~0/*U*/);
      } while (Native.$noteq(CurrentSCC.back(), visitingN));
      return;
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::scc_iterator::scc_iterator<GraphT, GT>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SCCIterator.h", line = 90,
   FQN="llvm::scc_iterator::scc_iterator<GraphT, GT>", NM="_ZN4llvm12scc_iteratorC1ENT0_7NodeRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm12scc_iteratorC1ENT0_7NodeRefE")
  //</editor-fold>
  private scc_iterator(GraphTraits<GraphT, NodeRef, ChildNodeType> $Traits, NodeRef entryN) {
    // : visitNum(0)
    //START JInit
    this.GT = $Traits;
    this.visitNum = 0;
    //END JInit
    DFSVisitOne(entryN);
    GetNextSCC();
  }


  /// End is when the DFS stack is empty.
  //<editor-fold defaultstate="collapsed" desc="llvm::scc_iterator::scc_iterator<GraphT, GT>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SCCIterator.h", line = 96,
   FQN="llvm::scc_iterator::scc_iterator<GraphT, GT>", NM="_ZN4llvm12scc_iteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm12scc_iteratorC1Ev")
  //</editor-fold>
  private scc_iterator(GraphTraits<GraphT, NodeRef, ChildNodeType> $Traits) {
    this.GT = $Traits;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::scc_iterator::begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SCCIterator.h", line = 99,
   FQN="llvm::scc_iterator::begin", NM="_ZN4llvm12scc_iterator5beginERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm12scc_iterator5beginERKT_")
  //</editor-fold>
  public static </*class*/ GraphT, /*class* GT = GraphTraits<GraphT>*/NodeRef, ChildNodeType> scc_iterator<GraphT, NodeRef, ChildNodeType> begin(
          GraphTraits<GraphT, NodeRef, ChildNodeType> GT, final /*const*/ GraphT /*&*/ G) {
    return new scc_iterator<GraphT, NodeRef, ChildNodeType>(GT, GT.getEntryNode(G));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::scc_iterator::end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SCCIterator.h", line = 102,
   FQN="llvm::scc_iterator::end", NM="_ZN4llvm12scc_iterator3endERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm12scc_iterator3endERKT_")
  //</editor-fold>
  public static </*class*/ GraphT, /*class* GT = GraphTraits<GraphT>*/NodeRef, ChildNodeType> scc_iterator<GraphT, NodeRef, ChildNodeType> end(
          GraphTraits<GraphT, NodeRef, ChildNodeType> GT, final /*const*/ GraphT /*&*/ $Prm0) {
    return new scc_iterator<GraphT, NodeRef, ChildNodeType>(GT);
  }


  /// \brief Direct loop termination test which is more efficient than
  /// comparison with \c end().
  //<editor-fold defaultstate="collapsed" desc="llvm::scc_iterator::isAtEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SCCIterator.h", line = 106,
   FQN="llvm::scc_iterator::isAtEnd", NM="_ZNK4llvm12scc_iterator7isAtEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZNK4llvm12scc_iterator7isAtEndEv")
  //</editor-fold>
  public boolean isAtEnd() /*const*/ {
    assert Native.$bool(Native.$not(CurrentSCC.empty()) || Native.$bool(VisitStack.empty()));
    return CurrentSCC.empty();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::scc_iterator::operator==">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SCCIterator.h", line = 111,
   FQN="llvm::scc_iterator::operator==", NM="_ZNK4llvm12scc_iteratoreqERKNS_12scc_iteratorIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZNK4llvm12scc_iteratoreqERKNS_12scc_iteratorIT_T0_EE")
  //</editor-fold>
  public boolean $eq(final /*const*/ scc_iterator<GraphT, NodeRef, ChildNodeType> /*&*/ x) /*const*/ {
    return Native.$bool(Native.$eq(VisitStack, x.VisitStack)) && Native.$bool(Native.$eq(CurrentSCC, x.CurrentSCC));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::scc_iterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SCCIterator.h", line = 115,
   FQN="llvm::scc_iterator::operator++", NM="_ZN4llvm12scc_iteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm12scc_iteratorppEv")
  //</editor-fold>
  public scc_iterator<GraphT, NodeRef, ChildNodeType> /*&*/ $preInc() {
    GetNextSCC();
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::scc_iterator::operator*">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SCCIterator.h", line = 120,
   FQN="llvm::scc_iterator::operator*", NM="_ZNK4llvm12scc_iteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZNK4llvm12scc_iteratordeEv")
  //</editor-fold>
  public  std.vector< NodeRef> $star() /*const*/ {
    assert Native.$bool(Native.$not(CurrentSCC.empty())) : "Dereferencing END SCC iterator!";
    return CurrentSCC;
  }


  /// \brief Test if the current SCC has a loop.
  ///
  /// If the SCC has more than one node, this is trivially true.  If not, it may
  /// still contain a loop if the node has an edge back to itself.
  //<editor-fold defaultstate="collapsed" desc="llvm::scc_iterator::hasLoop">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SCCIterator.h", line = 209,
   FQN="llvm::scc_iterator::hasLoop", NM="_ZNK4llvm12scc_iterator7hasLoopEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZNK4llvm12scc_iterator7hasLoopEv")
  //</editor-fold>
  public boolean hasLoop() /*const*/ {
    assert Native.$bool(Native.$not(CurrentSCC.empty())) : "Dereferencing END SCC iterator!";
    if (Native.$greater(CurrentSCC.size(), 1)) {
      return true;
    }
     NodeRef N = CurrentSCC.front();
    for ( type$iterator<? extends type$iterator, ChildNodeType> CI = GT.child_begin(N), CE = GT.child_end(N); Native.$noteq(CI, CE);
         CI.$preInc())  {
      if (Native.$eq(CI.$star(), N)) {
        return true;
      }
    }
    return false;
  }


  /// This informs the \c scc_iterator that the specified \c Old node
  /// has been deleted, and \c New is to be used in its place.
  //<editor-fold defaultstate="collapsed" desc="llvm::scc_iterator::ReplaceNode">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SCCIterator.h", line = 133,
   FQN="llvm::scc_iterator::ReplaceNode", NM="_ZN4llvm12scc_iterator11ReplaceNodeENT0_7NodeRefES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm12scc_iterator11ReplaceNodeENT0_7NodeRefES2_")
  //</editor-fold>
  public void ReplaceNode( NodeRef Old,  NodeRef New) {
    assert Native.$bool(nodeVisitNumbers.count(Old)) : "Old not in scc_iterator?";
    nodeVisitNumbers.ref$at(New).$assign(nodeVisitNumbers.$at(Old));
    nodeVisitNumbers.erase(Old);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final GraphTraits<GraphT, NodeRef, ChildNodeType> GT;

  @Override
  public scc_iterator<GraphT, NodeRef, ChildNodeType> clone() {
    return new scc_iterator<GraphT, NodeRef, ChildNodeType>(GT);
  }

  @Override
  public boolean $eq(Object other) {
    if (other instanceof scc_iterator) {
      return $eq((scc_iterator<GraphT, NodeRef, ChildNodeType>) other);
    }
    return false;
  }

  public GraphTraits<GraphT, NodeRef, ChildNodeType> $GT() {
    return GT;
  }

  public static </*class*/ GraphT, /*class* GT = GraphTraits<GraphT>*/NodeRef, ChildNodeType> scc_iterator<GraphT, NodeRef, ChildNodeType> scc_begin(
          GraphTraits<GraphT, NodeRef, ChildNodeType> GT, final /*const*/ GraphT /*&*/ G) {
    return scc_iterator.begin(GT, G);
  }

  public static </*class*/ GraphT, /*class* GT = GraphTraits<GraphT>*/NodeRef, ChildNodeType> scc_iterator<GraphT, NodeRef, ChildNodeType> scc_end(
          GraphTraits<GraphT, NodeRef, ChildNodeType> GT, final /*const*/ GraphT /*&*/ G) {
    return scc_iterator.end(GT, G);
  }

  @Override
  public void $destroy() {
    this.SCCNodeStack.$destroy();
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "visitNum=" + visitNum // NOI18N
              + ", nodeVisitNumbers=" + nodeVisitNumbers // NOI18N
              + ", SCCNodeStack=" + SCCNodeStack // NOI18N
              + ", CurrentSCC=" + CurrentSCC // NOI18N
              + ", VisitStack=" + VisitStack // NOI18N
              + super.toString(); // NOI18N
  }
}
