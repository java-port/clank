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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;


//===----------------------------------------------------------------------===//
// ilist_iterator<Node> - Iterator for intrusive list.
//
/*template <typename NodeTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 191,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 144,
 FQN="llvm::ilist_iterator", NM="_ZN4llvm14ilist_iteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN4llvm14ilist_iteratorE")
//</editor-fold>
public class ilist_iterator</*typename*/ NodeTy extends ilist_node<NodeTy>>  implements type$iterator<ilist_iterator<NodeTy>, NodeTy>,
        /*public*/ std.iterator<std.bidirectional_iterator_tag, NodeTy/*, ptrdiff_t*/> {
/*public:*/
  /*typedef ilist_traits<NodeTy> Traits*/
//  public final class Traits extends ilist_traits<NodeTy>{ };
  /*typedef std::iterator<std::bidirectional_iterator_tag, NodeTy, ptrdiff_t> super*/
//  public final class super extends std.iterator<std.bidirectional_iterator_tag, NodeTy/*, ptrdiff_t*/>{ };
  
  /*typedef typename super::value_type value_type*/
//  public final class value_type extends  std.iterator<std.bidirectional_iterator_tag, NodeTy/*, ptrdiff_t*/>.value_type{ };
  /*typedef typename super::difference_type difference_type*/
//  public final class difference_type extends  /*uint*/int{ };
  /*typedef typename super::pointer pointer*/
//  public final class pointer extends  NodeTy/*P*/{ };
  /*typedef typename super::reference reference*/
//  public final class reference extends  NodeTy/*&*/{ };
/*private:*/
  private  NodeTy/*P*/ NodePtr;
  
  // ilist_iterator is not a random-access iterator, but it has an
  // implicit conversion to pointer-type, which is. Declare (but
  // don't define) these functions as private to help catch
  // accidental misuse.
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::operator[]">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 211,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 164,
   FQN="llvm::ilist_iterator::operator[]", NM="_ZNK4llvm14ilist_iteratorixENSt8iteratorISt26bidirectional_iterator_tagT_iPS3_RS3_E15difference_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK4llvm14ilist_iteratorixENSt8iteratorISt26bidirectional_iterator_tagT_iPS3_RS3_E15difference_typeE")
  //</editor-fold>
  private void $at( /*uint*/int $Prm0) /*const*/ {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::operator+">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 212,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 165,
   FQN="llvm::ilist_iterator::operator+", NM="_ZNK4llvm14ilist_iteratorplENSt8iteratorISt26bidirectional_iterator_tagT_iPS3_RS3_E15difference_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK4llvm14ilist_iteratorplENSt8iteratorISt26bidirectional_iterator_tagT_iPS3_RS3_E15difference_typeE")
  //</editor-fold>
  public ilist_iterator<NodeTy> $add( /*uint*/int $Prm0) /*const*/ {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::operator-">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 213,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 166,
   FQN="llvm::ilist_iterator::operator-", NM="_ZNK4llvm14ilist_iteratormiENSt8iteratorISt26bidirectional_iterator_tagT_iPS3_RS3_E15difference_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK4llvm14ilist_iteratormiENSt8iteratorISt26bidirectional_iterator_tagT_iPS3_RS3_E15difference_typeE")
  //</editor-fold>
  public ilist_iterator<NodeTy> $sub( /*uint*/int $Prm0) /*const*/ {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::operator+=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 214,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 167,
   FQN="llvm::ilist_iterator::operator+=", NM="_ZNK4llvm14ilist_iteratorpLENSt8iteratorISt26bidirectional_iterator_tagT_iPS3_RS3_E15difference_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK4llvm14ilist_iteratorpLENSt8iteratorISt26bidirectional_iterator_tagT_iPS3_RS3_E15difference_typeE")
  //</editor-fold>
  private void $addassign( /*uint*/int $Prm0) /*const*/ {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::operator-=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 215,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 168,
   FQN="llvm::ilist_iterator::operator-=", NM="_ZNK4llvm14ilist_iteratormIENSt8iteratorISt26bidirectional_iterator_tagT_iPS3_RS3_E15difference_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK4llvm14ilist_iteratormIENSt8iteratorISt26bidirectional_iterator_tagT_iPS3_RS3_E15difference_typeE")
  //</editor-fold>
  private void $minusassign( /*uint*/int $Prm0) /*const*/ {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::operator<">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 216,
   FQN="llvm::ilist_iterator::operator<", NM="_ZNK4llvm14ilist_iteratorltET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK4llvm14ilist_iteratorltET_")
  //</editor-fold>
  private </*class*/ T> void $less(T $Prm0) /*const*/ {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }

  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::operator<=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 217,
   FQN="llvm::ilist_iterator::operator<=", NM="_ZNK4llvm14ilist_iteratorleET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK4llvm14ilist_iteratorleET_")
  //</editor-fold>
  private </*class*/ T> void $lesseq(T $Prm0) /*const*/ {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }

  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::operator>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 218,
   FQN="llvm::ilist_iterator::operator>", NM="_ZNK4llvm14ilist_iteratorgtET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK4llvm14ilist_iteratorgtET_")
  //</editor-fold>
  private </*class*/ T> void $greater(T $Prm0) /*const*/ {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }

  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::operator>=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 219,
   FQN="llvm::ilist_iterator::operator>=", NM="_ZNK4llvm14ilist_iteratorgeET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK4llvm14ilist_iteratorgeET_")
  //</editor-fold>
  private </*class*/ T> void $greatereq(T $Prm0) /*const*/ {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }

  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::operator-">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 220,
   FQN="llvm::ilist_iterator::operator-", NM="_ZNK4llvm14ilist_iteratormiET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK4llvm14ilist_iteratormiET_")
  //</editor-fold>
  private </*class*/ T> void $minus$T(T $Prm0) /*const*/ {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }

/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::ilist_iterator<NodeTy>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 223,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 176,
   FQN="llvm::ilist_iterator::ilist_iterator<NodeTy>", NM="_ZN4llvm14ilist_iteratorC1ENSt8iteratorISt26bidirectional_iterator_tagT_iPS3_RS3_E7pointerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN4llvm14ilist_iteratorC1ENSt8iteratorISt26bidirectional_iterator_tagT_iPS3_RS3_E7pointerE")
  //</editor-fold>
  public /*explicit*/ ilist_iterator( NodeTy/*P*/ NP, ilist_traits<NodeTy> $traits) {
    /* : NodePtr(NP)*/ 
    //START JInit
    this.NodePtr = /*ParenListExpr*/$noClone(NP);
    this.$traits = $changeTraitsToDefaultIfNeed($traits);
    //END JInit
  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::ilist_iterator<NodeTy>">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 224,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 177,
//   FQN="llvm::ilist_iterator::ilist_iterator<NodeTy>", NM="_ZN4llvm14ilist_iteratorC1ENSt8iteratorISt26bidirectional_iterator_tagT_iPS3_RS3_E9referenceE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN4llvm14ilist_iteratorC1ENSt8iteratorISt26bidirectional_iterator_tagT_iPS3_RS3_E9referenceE")
//  //</editor-fold>
//  public /*explicit*/ ilist_iterator( NodeTy/*&*/ NR) {
//    /* : NodePtr(&NR)*/ 
//    //START JInit
//    this.NodePtr = /*ParenListExpr*/$tryClone(NR);
//    //END JInit
//  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::ilist_iterator<NodeTy>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 225,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 178,
   FQN="llvm::ilist_iterator::ilist_iterator<NodeTy>", NM="_ZN4llvm14ilist_iteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN4llvm14ilist_iteratorC1Ev")
  //</editor-fold>
  public ilist_iterator(ilist_traits<NodeTy> $traits) {
    /* : NodePtr(null)*/ 
    //START JInit
    this.NodePtr = /*ParenListExpr*/null;
    this.$traits = $changeTraitsToDefaultIfNeed($traits);
    //END JInit
  }

  
  // This is templated so that we can allow constructing a const iterator from
  // a nonconst iterator...
  /*template <class node_ty> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::ilist_iterator<NodeTy>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 230,
   FQN="llvm::ilist_iterator::ilist_iterator<NodeTy>", NM="_ZN4llvm14ilist_iteratorC1ERKNS_14ilist_iteratorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN4llvm14ilist_iteratorC1ERKNS_14ilist_iteratorIT_EE")
  //</editor-fold>
  public /*<class node_ty>*/ ilist_iterator(/*const*/ ilist_iterator</*node_ty*/NodeTy> /*&*/ RHS) {
    /* : NodePtr(RHS.getNodePtrUnchecked())*/ 
    //START JInit
    this.NodePtr = /*ParenListExpr*/$noClone((NodeTy)RHS.getNodePtrUnchecked());
    this.$traits = /*ParenListExpr*/$changeTraitsToDefaultIfNeed(RHS.$traits);
    //END JInit
  }

  
  // This is templated so that we can allow assigning to a const iterator from
  // a nonconst iterator...
  /*template <class node_ty> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::operator=">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 236,
   FQN="llvm::ilist_iterator::operator=", NM="_ZN4llvm14ilist_iteratoraSERKNS_14ilist_iteratorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN4llvm14ilist_iteratoraSERKNS_14ilist_iteratorIT_EE")
  //</editor-fold>
  public </*class*/ node_ty extends ilist_node<node_ty>> /*const*/ ilist_iterator<NodeTy> /*&*/ $assign(/*const*/ ilist_iterator<node_ty> /*&*/ RHS) {
    NodePtr = (NodeTy)RHS.getNodePtrUnchecked();
    return this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::reset">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 241,
   FQN="llvm::ilist_iterator::reset", NM="_ZN4llvm14ilist_iterator5resetENSt8iteratorISt26bidirectional_iterator_tagT_iPS3_RS3_E7pointerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN4llvm14ilist_iterator5resetENSt8iteratorISt26bidirectional_iterator_tagT_iPS3_RS3_E7pointerE")
  //</editor-fold>
  public void reset( NodeTy/*P*/ NP) {
    NodePtr = $tryClone(NP);
  }

  
  // Accessors...
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::operator  iterator<bidirectional_iterator_tag, type-parameter-0-0, int, type-parameter-0-0 * , type-parameter-0-0 & >::pointer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 244,
   FQN="llvm::ilist_iterator::operator  iterator<bidirectional_iterator_tag, type-parameter-0-0, int, type-parameter-0-0 * , type-parameter-0-0 & >::pointer", NM="_ZNK4llvm14ilist_iteratorcvNSt8iteratorISt26bidirectional_iterator_tagT_iPS3_RS3_E7pointerEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK4llvm14ilist_iteratorcvNSt8iteratorISt26bidirectional_iterator_tagT_iPS3_RS3_E7pointerEEv")
  //</editor-fold>
  public  NodeTy/*P*/ $ptr() /*const*/ {
    return NodePtr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::operator*">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 248,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 199,
   FQN="llvm::ilist_iterator::operator*", NM="_ZNK4llvm14ilist_iteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK4llvm14ilist_iteratordeEv")
  //</editor-fold>
  public  NodeTy/*&*/ $star() /*const*/ {
    return NodePtr;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::operator->">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 251,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 202,
   FQN="llvm::ilist_iterator::operator->", NM="_ZNK4llvm14ilist_iteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK4llvm14ilist_iteratorptEv")
  //</editor-fold>
  public  NodeTy/*P*/ $arrow() /*const*/ {
    return $AddrOf($star());
  }

  
  // Comparison operators
  /*template <class Y> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::operator==">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 254,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 205,
   FQN="llvm::ilist_iterator::operator==", NM="_ZNK4llvm14ilist_iteratoreqERKNS_14ilist_iteratorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK4llvm14ilist_iteratoreqERKNS_14ilist_iteratorIT_EE")
  //</editor-fold>
  //public </*class*/ Y extends ilist_node<Y>> boolean $eq(/*const*/ ilist_iterator<Y> /*&*/ RHS) /*const*/ {
  public </*class*/ Y extends ilist_node<Y>> boolean $eq(/*const*/ ilist_iterator<Y> /*&*/ RHS) /*const*/ {
    return Native.$eq_ptr(NodePtr, RHS.getNodePtrUnchecked());
  }

  /*template <class Y> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::operator!=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 257,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 208,
   FQN="llvm::ilist_iterator::operator!=", NM="_ZNK4llvm14ilist_iteratorneERKNS_14ilist_iteratorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK4llvm14ilist_iteratorneERKNS_14ilist_iteratorIT_EE")
  //</editor-fold>
  public </*class*/ Y extends ilist_node<Y>> boolean $noteq(/*const*/ ilist_iterator<Y> /*&*/ RHS) /*const*/ {
    return Native.$noteq_ptr(NodePtr, RHS.getNodePtrUnchecked());
  }

  
  // Increment and decrement operators...
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::operator--">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 242,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 262,
   FQN="llvm::ilist_iterator::operator--", NM="_ZN4llvm14ilist_iteratormmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm14ilist_iteratormmEv")
  //</editor-fold>
  public ilist_iterator<NodeTy> /*&*/ $preDec() {
    NodePtr = $traits.getPrev(NodePtr);
    assert Native.$bool(NodePtr) : "--'d off the beginning of an ilist!";
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 247,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 267,
   FQN="llvm::ilist_iterator::operator++", NM="_ZN4llvm14ilist_iteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN4llvm14ilist_iteratorppEv")
  //</editor-fold>
  public ilist_iterator<NodeTy> /*&*/ $preInc() {
    NodePtr = $traits.getNext(NodePtr);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::operator--">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 251,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 271,
   FQN="llvm::ilist_iterator::operator--", NM="_ZN4llvm14ilist_iteratormmEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN4llvm14ilist_iteratormmEi")
  //</editor-fold>
  public ilist_iterator<NodeTy> $postDec(int $Prm0) {
    ilist_iterator<NodeTy> tmp = /*Deref*/$Clone(this);
    /*Deref*/this.$preDec();
    return tmp;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 256,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 276,
   FQN="llvm::ilist_iterator::operator++", NM="_ZN4llvm14ilist_iteratorppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN4llvm14ilist_iteratorppEi")
  //</editor-fold>
  public ilist_iterator<NodeTy> $postInc(int $Prm0) {
    ilist_iterator<NodeTy> tmp = /*Deref*/$Clone(this);
    /*Deref*/this.$preInc();
    return tmp;
  }

  
  // Internal interface, do not use...
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_iterator::getNodePtrUnchecked">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 283,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 234,
   FQN="llvm::ilist_iterator::getNodePtrUnchecked", NM="_ZNK4llvm14ilist_iterator19getNodePtrUncheckedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZNK4llvm14ilist_iterator19getNodePtrUncheckedEv")
  //</editor-fold>
  public  NodeTy/*P*/ getNodePtrUnchecked() /*const*/ {
    return NodePtr;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public ilist_iterator<NodeTy> $inc(int amount) {
    if (amount > 0) {
      while(amount-- > 0) {
        NodePtr = this.$traits.getNext(NodePtr);
      }
    } else if (amount < 0) {
      while (amount++ < 0) {
        NodePtr = this.$traits.getPrev(NodePtr);
      }      
    }
    return this;
  }

  @Override
  public int $sub(ilist_iterator<NodeTy> iter) {
    if( $eq(iter) ) {
      return 0;
    } else {    
      int distance = 0;
      NodeTy p;
      for(p = iter.NodePtr; p != null && p != NodePtr /*&& p != iter.NodePtr*/; p = p.getNext()) {
        distance++;
      }
      if (p == NodePtr) {
        return distance;
      } else {
        return Integer.MAX_VALUE;
      }
    }
  }

  @Override
  public boolean $eq(Object other) {
    return $eq((ilist_iterator)other);
  }
  
  @Override
  public ilist_iterator<NodeTy> clone() {
    return new ilist_iterator<>(this);
  }
  
  public ilist_iterator(JavaDifferentiators.JD$Move INSTANCE, ilist_iterator<NodeTy> Tok) {
    this.$traits = $changeTraitsToDefaultIfNeed(Tok.$traits);
    this.NodePtr = Tok.NodePtr;
    Tok.NodePtr = null;
  }
  
  public void $assignMove(ilist_iterator<NodeTy> Tok) {
    this.NodePtr = Tok.NodePtr;
    //this.$traits = Tok.$traits;
    Tok.NodePtr = null;
  }
  
  private final ilist_traits<NodeTy> $changeTraitsToDefaultIfNeed(ilist_traits<NodeTy> traits) {
    if (traits == null) {
      traits = new ilist_traits_default_impl<NodeTy>() {
        @Override
        public NodeTy createSentinel() {
          throw new UnsupportedOperationException("Not supported yet. Should be overridden in descendant.");
        }
      };
    }
    return traits;
  }
  
  private final ilist_traits<NodeTy> $traits;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "NodePtr=" + NodePtr // NOI18N
              + super.toString(); // NOI18N
  }

}
