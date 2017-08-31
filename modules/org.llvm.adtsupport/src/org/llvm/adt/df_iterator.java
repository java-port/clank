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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.java.GraphTraits;


// JAVA type mapping:
// GT -> GraphTraits<GraphT>
// GT::NodeType -> GraphT
// SetType -> SmallPtrSet<GraphT>
// GT::ChildIteratorType -> type$iterator<?, GraphT> 
// ChildItTy -> type$iterator<?, GraphT> 

// Generic Depth First Iterator
/*template <class GraphT, class SetType = llvm::SmallPtrSet<typename GraphTraits<GraphT>::NodeType *, 8>, bool ExtStorage = false, class GT = GraphTraits<GraphT>> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::df_iterator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, 
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 62,
 FQN="llvm::df_iterator", NM="_ZN4llvm11df_iteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZN4llvm11df_iteratorE")
//</editor-fold>
public class df_iterator</*class*/ GraphT, NodeType, ChildNodeType>  extends /*public*/ df_iterator_storage<SmallPtrSet<NodeType>> implements /*public*/ type$iterator<df_iterator, NodeType> {
  /*typedef std::iterator<std::forward_iterator_tag, typename GT::NodeType, ptrdiff_t> super*/
//  public final class super extends std.iterator<std.forward_iterator_tag,  GT.NodeType, int>{ };
  
  /*typedef typename GT::NodeType NodeType*/
//  public final class NodeType extends  GT.NodeType{ };
  /*typedef typename GT::ChildIteratorType ChildItTy*/
//  public final class ChildItTy extends  GT.ChildIteratorType{ };
  /*typedef PointerIntPair<NodeType *, 1> PointerIntTy*/
//  public final class PointerIntTy extends PointerIntPair< GT.NodeType /*P*/ , 1>{ };
  
  // VisitStack - Used to maintain the ordering.  Top = current block
  // First element is node pointer, second is the 'next child' to visit
  // if the int in PointerIntTy is 0, the 'next child' to visit is invalid
  private std.vector<std.pair<PointerIntPair<NodeType /*P*/>,  type$iterator<?, ChildNodeType>> > VisitStack;
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::df_iterator::df_iterator<GraphT, SetType, ExtStorage, GT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 81,
   FQN="llvm::df_iterator::df_iterator<GraphT, SetType, ExtStorage, GT>", NM="_ZN4llvm11df_iteratorC1EPNT2_8NodeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZN4llvm11df_iteratorC1EPNT2_8NodeTypeE")
  //</editor-fold>
  private /*inline*/ df_iterator(GraphTraits<GraphT, NodeType, ChildNodeType> GT_For_Node, NodeType/*P*/ Node) {
    this.GT = GT_For_Node;
    this.Visited.insert(Node);
    VisitStack.push_back(std.make_pair(new PointerIntPair(Node, 0), GT_For_Node.child_begin(Node)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::df_iterator::df_iterator<GraphT, SetType, ExtStorage, GT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 86,
   FQN="llvm::df_iterator::df_iterator<GraphT, SetType, ExtStorage, GT>", NM="_ZN4llvm11df_iteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZN4llvm11df_iteratorC1Ev")
  //</editor-fold>
  private /*inline*/ df_iterator(GraphTraits<GraphT, NodeType, ChildNodeType> GT) {
    // End is when stack is empty
    this.GT = GT;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::df_iterator::df_iterator<GraphT, SetType, ExtStorage, GT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 89,
   FQN="llvm::df_iterator::df_iterator<GraphT, SetType, ExtStorage, GT>", NM="_ZN4llvm11df_iteratorC1EPNT2_8NodeTypeERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZN4llvm11df_iteratorC1EPNT2_8NodeTypeERT0_")
  //</editor-fold>
  private /*inline*/ df_iterator(GraphTraits<GraphT, NodeType, ChildNodeType> GT_For_Node, NodeType /*P*/ Node, final SmallPtrSet<NodeType> /*&*/ S) {
    // : df_iterator_storage<SetType, ExtStorage>(S) 
    //START JInit
    /*ParenListExpr*/super(S);
    this.GT = GT_For_Node;
    //END JInit
    if (Native.$not(S.count(Node))) {
      VisitStack.push_back(std.make_pair(new PointerIntPair(Node, 0), GT_For_Node.child_begin(Node)));
      this.Visited.insert(Node);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::df_iterator::df_iterator<GraphT, SetType, ExtStorage, GT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 97,
   FQN="llvm::df_iterator::df_iterator<GraphT, SetType, ExtStorage, GT>", NM="_ZN4llvm11df_iteratorC1ERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZN4llvm11df_iteratorC1ERT0_")
  //</editor-fold>
  private /*inline*/ df_iterator(GraphTraits<GraphT, NodeType, ChildNodeType> GT, final SmallPtrSet<NodeType> /*&*/ S) {
    // : df_iterator_storage<SetType, ExtStorage>(S) 
    //START JInit
    /*ParenListExpr*/super(S);
    this.GT = GT;
    //END JInit
    // End is when stack is empty
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::df_iterator::toNext">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 102,
   FQN="llvm::df_iterator::toNext", NM="_ZN4llvm11df_iterator6toNextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZN4llvm11df_iterator6toNextEv")
  //</editor-fold>
  private /*inline*/ void toNext() {
    do {
      final std.pair<PointerIntPair<NodeType>,  type$iterator<?, ChildNodeType>> /*&*/ Top = VisitStack.back();
       NodeType /*P*/ Node = Top.first.getPointer();
      type$iterator<?, ChildNodeType> /*&*/ It = Top.second;
      if (Native.$not(Top.first.getInt())) {
        // now retrieve the real begin of the children before we dive in
        It = GT.child_begin(Node);
        Top.second = It;
        Top.first.setInt(1);
      }
      while (Native.$noteq(It, GT.child_end(Node))) {
         NodeType /*P*/ Next = ((type$iterator<?, NodeType>) It.$postInc()).$star();
        // Has our next sibling been visited?
        if (Native.$bool(Next) && Native.$bool(this.Visited.insert(Next).second)) {
          // No, do it now.
          VisitStack.push_back(std.make_pair(new PointerIntPair(Next, 0), GT.child_begin(Next)));
          return;
        }
      }
      
      // Oops, ran out of successors... go up a level on the stack.
      VisitStack.pop_back();
    } while (Native.$not(VisitStack.empty()));
  }

/*public:*/
  /*typedef typename super::pointer pointer*/
//  public final class pointer extends  std.iterator.<std.forward_iterator_tag,  GraphT, int>pointer{ };
  
  // Provide static begin and end methods as our public "constructors"
  //<editor-fold defaultstate="collapsed" desc="llvm::df_iterator::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 133,
   FQN="llvm::df_iterator::begin", NM="_ZN4llvm11df_iterator5beginERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZN4llvm11df_iterator5beginERKT_")
  //</editor-fold>
  public static </*class*/ GraphT, NodeType, ChildNodeType> df_iterator<GraphT, NodeType, ChildNodeType> begin(GraphTraits<GraphT, NodeType, ChildNodeType> GT, final /*const*/ GraphT /*&*/ G) {
    return new df_iterator(GT.getEntryNode$GTrait(G), GT.getEntryNode(G));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::df_iterator::end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 136,
   FQN="llvm::df_iterator::end", NM="_ZN4llvm11df_iterator3endERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZN4llvm11df_iterator3endERKT_")
  //</editor-fold>
  public static </*class*/ GraphT, NodeType, ChildNodeType> df_iterator<GraphT, NodeType, ChildNodeType> end(GraphTraits<GraphT, NodeType, ChildNodeType> GT, final /*const*/ GraphT /*&*/ G) {
    return new df_iterator(GT);
  }

  
  // Static begin and end methods as our public ctors for external iterators
  //<editor-fold defaultstate="collapsed" desc="llvm::df_iterator::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 139,
   FQN="llvm::df_iterator::begin", NM="_ZN4llvm11df_iterator5beginERKT_RT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZN4llvm11df_iterator5beginERKT_RT0_")
  //</editor-fold>
  public static </*class*/ GraphT, NodeType, ChildNodeType> df_iterator<GraphT, NodeType, ChildNodeType> begin(GraphTraits<GraphT, NodeType, ChildNodeType> GT, final /*const*/ GraphT /*&*/ G, final SmallPtrSet<NodeType> /*&*/ S) {
    return new df_iterator(GT.getEntryNode$GTrait(G), GT.getEntryNode(G), S);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::df_iterator::end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 142,
   FQN="llvm::df_iterator::end", NM="_ZN4llvm11df_iterator3endERKT_RT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZN4llvm11df_iterator3endERKT_RT0_")
  //</editor-fold>
  public static </*class*/ GraphT, NodeType, ChildNodeType> df_iterator<GraphT, NodeType, ChildNodeType> end(GraphTraits<GraphT, NodeType, ChildNodeType> GT, final /*const*/ GraphT /*&*/ G, final SmallPtrSet<NodeType> /*&*/ S) {
    return new df_iterator(GT, S);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::df_iterator::operator==">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 144,
   FQN="llvm::df_iterator::operator==", NM="_ZNK4llvm11df_iteratoreqERKNS_11df_iteratorIT_T0_XT1_ET2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZNK4llvm11df_iteratoreqERKNS_11df_iteratorIT_T0_XT1_ET2_EE")
  //</editor-fold>
  public boolean $eq(final /*const*/df_iterator<GraphT, NodeType, ChildNodeType>/*&*/ x) /*const*/ {
    return Native.$eq(VisitStack, x.VisitStack);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::df_iterator::operator!=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 147,
   FQN="llvm::df_iterator::operator!=", NM="_ZNK4llvm11df_iteratorneERKNS_11df_iteratorIT_T0_XT1_ET2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZNK4llvm11df_iteratorneERKNS_11df_iteratorIT_T0_XT1_ET2_EE")
  //</editor-fold>
  public boolean $noteq(final /*const*/ df_iterator<GraphT, NodeType, ChildNodeType> /*&*/ x) /*const*/ {
    return Native.$not((Native.$eq(/*Deref*/this, x)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::df_iterator::operator*">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 149,
   FQN="llvm::df_iterator::operator*", NM="_ZNK4llvm11df_iteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZNK4llvm11df_iteratordeEv")
  //</editor-fold>
  public  NodeType $star() /*const*/ {
    return VisitStack.back().first.getPointer();
  }

  
  // This is a nonstandard operator-> that dereferences the pointer an extra
  // time... so that you can actually call methods ON the Node, because
  // the contained type is a pointer.  This allows BBIt->getTerminator() f.e.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::df_iterator::operator->">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 155,
   FQN="llvm::df_iterator::operator->", NM="_ZNK4llvm11df_iteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZNK4llvm11df_iteratorptEv")
  //</editor-fold>
  public  NodeType /*P*/ $arrow() /*const*/ {
    return $star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::df_iterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 157,
   FQN="llvm::df_iterator::operator++", NM="_ZN4llvm11df_iteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZN4llvm11df_iteratorppEv")
  //</editor-fold>
  public df_iterator<GraphT, NodeType, ChildNodeType> /*&*/ $preInc() {
    // Preincrement
    toNext();
    return /*Deref*/this;
  }

  
  /// \brief Skips all children of the current node and traverses to next node
  ///
  /// Note: This function takes care of incrementing the iterator. If you
  /// always increment and call this function, you risk walking off the end.
  //<editor-fold defaultstate="collapsed" desc="llvm::df_iterator::skipChildren">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 166,
   FQN="llvm::df_iterator::skipChildren", NM="_ZN4llvm11df_iterator12skipChildrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZN4llvm11df_iterator12skipChildrenEv")
  //</editor-fold>
  public df_iterator<GraphT, NodeType, ChildNodeType> /*&*/ skipChildren() {
    VisitStack.pop_back();
    if (Native.$not(VisitStack.empty())) {
      toNext();
    }
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::df_iterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 173,
   FQN="llvm::df_iterator::operator++", NM="_ZN4llvm11df_iteratorppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZN4llvm11df_iteratorppEi")
  //</editor-fold>
  public df_iterator<GraphT, NodeType, ChildNodeType> $postInc(int $Prm0) {
    // Postincrement
    df_iterator<GraphT, NodeType, ChildNodeType> tmp = new df_iterator(/*Deref*/this);
    this.$preInc();
    return tmp;
  }

  
  // nodeVisited - return true if this iterator has already visited the
  // specified node.  This is public, and will probably be used to iterate over
  // nodes that a depth first iteration did not find: ie unreachable nodes.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::df_iterator::nodeVisited">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 183,
   FQN="llvm::df_iterator::nodeVisited", NM="_ZNK4llvm11df_iterator11nodeVisitedEPNT2_8NodeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZNK4llvm11df_iterator11nodeVisitedEPNT2_8NodeTypeE")
  //</editor-fold>
  public boolean nodeVisited( NodeType /*P*/ Node) /*const*/ {
    return Native.$noteq(this.Visited.count(Node), 0);
  }

  
  /// getPathLength - Return the length of the path from the entry node to the
  /// current node, counting both nodes.
  //<editor-fold defaultstate="collapsed" desc="llvm::df_iterator::getPathLength">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 189,
   FQN="llvm::df_iterator::getPathLength", NM="_ZNK4llvm11df_iterator13getPathLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZNK4llvm11df_iterator13getPathLengthEv")
  //</editor-fold>
  public /*uint*/int getPathLength() /*const*/ {
    return VisitStack.size();
  }

  
  /// getPath - Return the n'th node in the path from the entry node to the
  /// current node.
  //<editor-fold defaultstate="collapsed" desc="llvm::df_iterator::getPath">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 193,
   FQN="llvm::df_iterator::getPath", NM="_ZNK4llvm11df_iterator7getPathEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZNK4llvm11df_iterator7getPathEj")
  //</editor-fold>
  public  NodeType /*P*/ getPath(/*uint*/int n) /*const*/ {
    return VisitStack.$at(n).first.getPointer();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  private final GraphTraits<GraphT, NodeType, ChildNodeType> GT;
  
  private /*inline*/ df_iterator(df_iterator</*class*/ GraphT, NodeType, ChildNodeType> other) {
    this.GT = other.GT;
    this.VisitStack = new std.vector(other.VisitStack);
  }

  @Override
  public df_iterator clone() {
    return new df_iterator(this);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "VisitStack=" + VisitStack // NOI18N
              + super.toString(); // NOI18N
  }
}
