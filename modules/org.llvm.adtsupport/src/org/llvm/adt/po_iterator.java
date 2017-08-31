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

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.java.GraphTraits;
import org.llvm.adt.java.Insertable;

/*template <class GraphT, class SetType = llvm::SmallPtrSet<typename GraphTraits<GraphT>::NodeType *, 8>, bool ExtStorage = false, class GT = GraphTraits<GraphT>> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::po_iterator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 89,
 FQN="llvm::po_iterator", NM="_ZN4llvm11po_iteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN4llvm11po_iteratorE")
//</editor-fold>
public class po_iterator</*class*/ GraphT, /*class*/ NodeType, ChildNodeType>  extends /*public*/ po_iterator_storage<NodeType> 
        implements type$iterator<po_iterator</*class*/ GraphT, /*class*/ NodeType, ChildNodeType>, NodeType> {
  /*typedef std::iterator<std::forward_iterator_tag, typename GT::NodeType, ptrdiff_t> super*/
//  public final class super extends std.iterator<std.forward_iterator_tag,  NodeType, int>{ };
  /*typedef typename GT::NodeType NodeType*/
//  public final class NodeType extends  NodeType{ };
  /*typedef typename GT::ChildIteratorType ChildItTy*/
//  public final class ChildItTy extends  GT.ChildIteratorType{ };
  
  // VisitStack - Used to maintain the ordering.  Top = current block
  // First element is basic block pointer, second is the 'next child' to visit
  private final std.vector<std.pair<NodeType /*P*/ ,  type$iterator<?, ChildNodeType>>> VisitStack; //JAVA: not sure about type$iterator<?, GraphT>
  
  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator::traverseChild">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 105,
   FQN="llvm::po_iterator::traverseChild", NM="_ZN4llvm11po_iterator13traverseChildEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN4llvm11po_iterator13traverseChildEv")
  //</editor-fold>
  private void traverseChild() {
    while ($noteq_iter(VisitStack.back().second, GT.child_end(VisitStack.back().first))) {
      final type$iterator<?, ChildNodeType> second = /*&*/VisitStack.back().second;
      NodeType /*P*/ BB = GT.$ChildNodeTypeToNodeType(second.$star()); second.$preInc();
      if (this.insertEdge(VisitStack.back().first, BB)) {
        // If the block is not visited...
        VisitStack.push_back(std.make_pair(BB, $tryClone(GT.child_begin(BB))));
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator::po_iterator<GraphT, SetType, ExtStorage, GT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 115,
   FQN="llvm::po_iterator::po_iterator<GraphT, SetType, ExtStorage, GT>", NM="_ZN4llvm11po_iteratorC1EPNT2_8NodeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN4llvm11po_iteratorC1EPNT2_8NodeTypeE")
  //</editor-fold>
  private po_iterator(GraphTraits<GraphT, NodeType, ChildNodeType> GT_For_BB, NodeType /*P*/ BB, final Insertable<?, NodeType> Set) {
    super(false, Set);   
    VisitStack = new std.vector((std.pair)null);
    this.GT = GT_For_BB;
    this.insertEdge(( NodeType /*P*/ )null, BB);
    VisitStack.push_back(std.make_pair(BB, $tryClone(GT_For_BB.child_begin(BB))));
    traverseChild();
  }

// JAVA: no more such ctor: in Java, passing Insertable<NodeType> is obligatory
// (otherwise we don't know which DenseMapInfo to use to construct it
//  
//  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator::po_iterator<GraphT, SetType, ExtStorage, GT>">
//  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 120,
//   FQN="llvm::po_iterator::po_iterator<GraphT, SetType, ExtStorage, GT>", NM="_ZN4llvm11po_iteratorC1Ev",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN4llvm11po_iteratorC1Ev")
//  //</editor-fold>
//  private po_iterator(boolean External) {
//    super(External);
//    throw new UnsupportedOperationException("EmptyBody");
//  }
 // End is when stack is empty.
  
  // End is when stack is empty.
  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator::po_iterator<GraphT, SetType, ExtStorage, GT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 122,
   FQN="llvm::po_iterator::po_iterator<GraphT, SetType, ExtStorage, GT>", NM="_ZN4llvm11po_iteratorC1EPNT2_8NodeTypeERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN4llvm11po_iteratorC1EPNT2_8NodeTypeERT0_")
  //</editor-fold>
  private po_iterator(GraphTraits<GraphT, NodeType, ChildNodeType> GT_For_BB, boolean External, NodeType /*P*/ BB, final Insertable<?, NodeType> /*&*/ Set) {
    // : po_iterator_storage<SetType, ExtStorage>(S) 
    //START JInit
    /*ParenListExpr*/super(External, Set);
    //END JInit
    VisitStack = new std.vector((std.pair)null);
    this.GT = GT_For_BB;
    if (this.insertEdge(( NodeType /*P*/ )null, BB)) {
      VisitStack.push_back(std.make_pair(BB, $tryClone(GT_For_BB.child_begin(BB))));
      traverseChild();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator::po_iterator<GraphT, SetType, ExtStorage, GT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 130,
   FQN="llvm::po_iterator::po_iterator<GraphT, SetType, ExtStorage, GT>", NM="_ZN4llvm11po_iteratorC1ERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN4llvm11po_iteratorC1ERT0_")
  //</editor-fold>
  private po_iterator(GraphTraits<GraphT, NodeType, ChildNodeType> GT, boolean External, final Insertable<?, NodeType> /*&*/ Set) {
    // : po_iterator_storage<SetType, ExtStorage>(S) 
    //START JInit
    /*ParenListExpr*/super(External, Set);
    VisitStack = new std.vector((std.pair)null);
    this.GT = GT;
    //END JInit
  } // End is when stack is empty.
 // End is when stack is empty.
/*public:*/
  /*typedef typename super::pointer pointer*/
//  public final class pointer extends  std.iterator.<std.forward_iterator_tag, NodeType, int>pointer{ };
  
  // Provide static "constructors"...
  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator::begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 137,
   FQN="llvm::po_iterator::begin", NM="_ZN4llvm11po_iterator5beginET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN4llvm11po_iterator5beginET_")
  //</editor-fold>
  public static </*class*/ GraphT, /*class*/ NodeType, ChildNodeType> 
        po_iterator</*class*/ GraphT, /*class*/ NodeType, ChildNodeType> 
        begin(GraphTraits<GraphT, NodeType, ChildNodeType> GT, GraphT G) {
    return new po_iterator(GT, G, GT.createSetToInsert());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator::end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 140,
   FQN="llvm::po_iterator::end", NM="_ZN4llvm11po_iterator3endET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN4llvm11po_iterator3endET_")
  //</editor-fold>
  public static </*class*/ GraphT, /*class*/ NodeType, ChildNodeType> 
        po_iterator</*class*/ GraphT, /*class*/ NodeType, ChildNodeType>
        end(GraphTraits<GraphT, NodeType, ChildNodeType> GT, GraphT G) {
    return new po_iterator(GT, false, GT.createSetToInsert());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 142,
   FQN="llvm::po_iterator::begin", NM="_ZN4llvm11po_iterator5beginET_RT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN4llvm11po_iterator5beginET_RT0_")
  //</editor-fold>
  public static </*class*/ GraphT, /*class*/ NodeType, ChildNodeType> 
        po_iterator</*class*/ GraphT, /*class*/ NodeType, ChildNodeType> 
        begin(GraphTraits<GraphT, NodeType, ChildNodeType> GT, GraphT G, final Insertable<?, NodeType> /*&*/ S) {
    return new po_iterator(GT.getEntryNode$GTrait(G), GT.getEntryNode(G), S);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator::end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 145,
   FQN="llvm::po_iterator::end", NM="_ZN4llvm11po_iterator3endET_RT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN4llvm11po_iterator3endET_RT0_")
  //</editor-fold>
  public static </*class*/ GraphT, /*class*/ NodeType, ChildNodeType> 
        po_iterator</*class*/ GraphT, /*class*/ NodeType, ChildNodeType> 
        end(GraphTraits<GraphT, NodeType, ChildNodeType> GT, GraphT G, final Insertable<?, NodeType> /*&*/ S) {
    return new po_iterator(GT, false, S);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator::operator==">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 147,
   FQN="llvm::po_iterator::operator==", NM="_ZNK4llvm11po_iteratoreqERKNS_11po_iteratorIT_T0_XT1_ET2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZNK4llvm11po_iteratoreqERKNS_11po_iteratorIT_T0_XT1_ET2_EE")
  //</editor-fold>
  public boolean $eq(final /*const*/ po_iterator<GraphT, NodeType, ChildNodeType> /*&*/ x) /*const*/ {
    // unfold VisitStack.$eq(x.VisitStack), because not clear how pairs will compare to each other
    // with internal iterators
    int size = VisitStack.size();
    boolean res = false;
    if (size == x.VisitStack.size()) {
      res = true;
      for (int i = 0; i < size; i++) {
        pair<NodeType/*P*/, type$iterator<?, ChildNodeType>> thisElem = VisitStack.$at(i);
        pair<NodeType/*P*/, type$iterator<?, ChildNodeType>> otherElem = x.VisitStack.$at(i);
        if ((thisElem.first != otherElem.first) ||
           ($noteq_iter(thisElem.second, otherElem.second))) {     
          res = false;
          break;
        }
      }
    }
    return res;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator::operator!=">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 150,
   FQN="llvm::po_iterator::operator!=", NM="_ZNK4llvm11po_iteratorneERKNS_11po_iteratorIT_T0_XT1_ET2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZNK4llvm11po_iteratorneERKNS_11po_iteratorIT_T0_XT1_ET2_EE")
  //</editor-fold>
  public boolean $noteq(final /*const*/ po_iterator<GraphT, NodeType, ChildNodeType> /*&*/ x) /*const*/ {
    return !$eq(x);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator::operator*">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 152,
   FQN="llvm::po_iterator::operator*", NM="_ZNK4llvm11po_iteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZNK4llvm11po_iteratordeEv")
  //</editor-fold>
  public  NodeType $star() /*const*/ {
    return VisitStack.back().first;  
  }

  
  // This is a nonstandard operator-> that dereferences the pointer an extra
  // time... so that you can actually call methods ON the BasicBlock, because
  // the contained type is a pointer.  This allows BBIt->getTerminator() f.e.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator::operator->">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 158,
   FQN="llvm::po_iterator::operator->", NM="_ZNK4llvm11po_iteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZNK4llvm11po_iteratorptEv")
  //</editor-fold>
  public  NodeType /*P*/ $arrow() /*const*/ {
    return $Deref($Deref(this.$star()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 160,
   FQN="llvm::po_iterator::operator++", NM="_ZN4llvm11po_iteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN4llvm11po_iteratorppEv")
  //</editor-fold>
  public po_iterator<GraphT, NodeType, ChildNodeType> /*&*/ $preInc() {
    // Preincrement
    this.finishPostorder(VisitStack.back().first);
    VisitStack.pop_back();
    if (Native.$not(VisitStack.empty())) {
      traverseChild();
    }
    return /*Deref*/this;    
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 168,
   FQN="llvm::po_iterator::operator++", NM="_ZN4llvm11po_iteratorppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN4llvm11po_iteratorppEi")
  //</editor-fold>
  public po_iterator<GraphT, NodeType, ChildNodeType> $postInc(int $Prm0) {
    // Postincrement
    po_iterator<GraphT, NodeType, ChildNodeType> tmp = /*Deref*/this;
    $Deref(this.$preInc());
    return tmp;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final GraphTraits<GraphT, /*class*/ NodeType, ChildNodeType> GT;
  
  protected po_iterator(po_iterator<GraphT, NodeType, ChildNodeType> other) {
    super(other);
    GT = $tryClone(other.GT);
    this.VisitStack = new vector(other.VisitStack);
    // we need full copy, not shadow for VisitStack
    int size = this.VisitStack.size();
    for (int i = 0; i < size; i++) {
      pair<NodeType, type$iterator<?, ChildNodeType>> at$Idx = this.VisitStack.$at(i);
      this.VisitStack.$set(i, std.make_pair(at$Idx.first, $tryClone(at$Idx.second)));
    }
    assert this.$eq(other);
  }
  
  public void $destroy() {
    // should we destroy VisitStack? I don't think so
  }

  @Override public boolean $eq(Object $Prm0) {
    return $eq((po_iterator<GraphT, NodeType, ChildNodeType>)$Prm0);
  }
  
  @Override public po_iterator clone() {
    assert this.getClass() == po_iterator.class : "must be overridden in " + this.getClass();
    return new po_iterator(this);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "VisitStack=" + VisitStack // NOI18N
              + super.toString(); // NOI18N
  }
}
