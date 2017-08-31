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

package org.clang.ast;

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;


/// specific_attr_iterator - Iterates over a subrange of an AttrVec, only
/// providing attributes that are of a specific type.
/*template <typename SpecificAttr, typename Container = AttrVec> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::specific_attr_iterator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*a lot of changes*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/AttrIterator.h", line = 47,
 FQN="clang::specific_attr_iterator", NM="_ZN5clang22specific_attr_iteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang22specific_attr_iteratorE")
//</editor-fold>
public class specific_attr_iterator</*typename*/ SpecificAttr/*, typename Container = AttrVec*/>  implements type$iterator<specific_attr_iterator, SpecificAttr> {
  /*typedef typename Container::const_iterator Iterator*/
//  public final class Iterator extends type$iterator<?, ? extends Attr>{ };
  
  /// Current - The current, underlying iterator.
  /// In order to ensure we don't dereference an invalid iterator unless
  /// specifically requested, we don't necessarily advance this all the
  /// way. Instead, we advance it when an operation is requested; if the
  /// operation is acting on what should be a past-the-end iterator,
  /// then we offer no guarantees, but this way we do not dereference a
  /// past-the-end iterator when we move to a past-the-end position.
  private /*mutable */type$iterator<?, ? extends Attr> Current;
  
  //<editor-fold defaultstate="collapsed" desc="clang::specific_attr_iterator::AdvanceToNext">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/AttrIterator.h", line = 60,
   FQN="clang::specific_attr_iterator::AdvanceToNext", NM="_ZNK5clang22specific_attr_iterator13AdvanceToNextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZNK5clang22specific_attr_iterator13AdvanceToNextEv")
  //</editor-fold>
  private void AdvanceToNext() /*const*/ {
    while (Native.$not(isa(clazz, $Deref(Current)))) {
      Current.$preInc();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::specific_attr_iterator::AdvanceToNext">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/AttrIterator.h", line = 65,
   FQN="clang::specific_attr_iterator::AdvanceToNext", NM="_ZNK5clang22specific_attr_iterator13AdvanceToNextENT0_14const_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZNK5clang22specific_attr_iterator13AdvanceToNextENT0_14const_iteratorE")
  //</editor-fold>
  private void AdvanceToNext(type$iterator<?, ? extends Attr> I) /*const*/ {
    while (Native.$noteq_iter(Current, I) && Native.$not(isa(clazz, $Deref(Current)))) {
      Current.$preInc();
    }
  }

/*public:*/
  /*typedef SpecificAttr *value_type*/
//  public final class value_type extends SpecificAttr /*P*/ { };
  /*typedef SpecificAttr *reference*/
//  public final class reference extends SpecificAttr /*P*/ { };
  /*typedef SpecificAttr *pointer*/
//  public final class pointer extends SpecificAttr /*P*/ { };
  /*typedef std::forward_iterator_tag iterator_category*/
//  public final class iterator_category extends std.forward_iterator_tag{ };
  /*typedef std::ptrdiff_t difference_type*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::specific_attr_iterator::specific_attr_iterator<SpecificAttr, Container>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/AttrIterator.h", line = 77,
   FQN="clang::specific_attr_iterator::specific_attr_iterator<SpecificAttr, Container>", NM="_ZN5clang22specific_attr_iteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang22specific_attr_iteratorC1Ev")
  //</editor-fold>
  public specific_attr_iterator(Class<SpecificAttr> clazz) {
    // : Current() 
    //START JInit
//    this.Current = /*ParenListExpr*/new type$iterator<?, ? extends Attr>();
    this.Current = /*ParenListExpr*/null;
    //END JInit
    this.clazz = clazz;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::specific_attr_iterator::specific_attr_iterator<SpecificAttr, Container>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/AttrIterator.h", line = 78,
   FQN="clang::specific_attr_iterator::specific_attr_iterator<SpecificAttr, Container>", NM="_ZN5clang22specific_attr_iteratorC1ENT0_14const_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang22specific_attr_iteratorC1ENT0_14const_iteratorE")
  //</editor-fold>
  public /*explicit*/ specific_attr_iterator(Class<SpecificAttr> clazz, type$iterator<?, ? extends Attr> i) {
    // : Current(i) 
    //START JInit
//    this.Current = /*ParenListExpr*/new type$iterator<?, ? extends Attr>(i);
    this.Current = /*ParenListExpr*/$tryClone(i);
    //END JInit
    this.clazz = clazz;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::specific_attr_iterator::operator*">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/AttrIterator.h", line = 80,
   FQN="clang::specific_attr_iterator::operator*", NM="_ZNK5clang22specific_attr_iteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZNK5clang22specific_attr_iteratordeEv")
  //</editor-fold>
  public SpecificAttr /*P*/ $star() /*const*/ {
    AdvanceToNext();
    return cast(clazz, $Deref(Current));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::specific_attr_iterator::operator->">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/AttrIterator.h", line = 84,
   FQN="clang::specific_attr_iterator::operator->", NM="_ZNK5clang22specific_attr_iteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZNK5clang22specific_attr_iteratorptEv")
  //</editor-fold>
  public SpecificAttr /*P*/ $arrow() /*const*/ {
    AdvanceToNext();
    return cast(clazz, $Deref(Current));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::specific_attr_iterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/AttrIterator.h", line = 89,
   FQN="clang::specific_attr_iterator::operator++", NM="_ZN5clang22specific_attr_iteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang22specific_attr_iteratorppEv")
  //</editor-fold>
  public specific_attr_iterator<SpecificAttr>/*&*/ $preInc() {
    Current.$preInc();
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::specific_attr_iterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/AttrIterator.h", line = 93,
   FQN="clang::specific_attr_iterator::operator++", NM="_ZN5clang22specific_attr_iteratorppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang22specific_attr_iteratorppEi")
  //</editor-fold>
  public specific_attr_iterator<SpecificAttr> $postInc(int $Prm0) {
    specific_attr_iterator<SpecificAttr> Tmp/*J*/= /*ParenList*/new specific_attr_iterator<SpecificAttr>(/*Deref*/this);
    (/*Deref*/this).$preInc();
    return Tmp;
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/AttrIterator.h", line = 99,
   FQN="clang::operator==", NM="_ZN5clangeqENS_22specific_attr_iteratorIT_T0_EES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clangeqENS_22specific_attr_iteratorIT_T0_EES4_")
  //</editor-fold>
  public static <SpecificAttr> boolean $eq_specific_attr_iterator$SpecificAttr(specific_attr_iterator<SpecificAttr> Left, 
                                         specific_attr_iterator<SpecificAttr> Right) {
    assert (Left.Current == null) == (Right.Current == null);
    // postpone but clone input parameters when needed
    if (Native.$less(Left.Current, Right.Current)) {
      Left = Left.clone();
      Left.AdvanceToNext(Right.Current);
    } else {
      Right = Right.clone();
      Right.AdvanceToNext(Left.Current);
    }
    return Native.$eq_iter(Left.Current, Right.Current);
  }

  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/AttrIterator.h", line = 108,
   FQN="clang::operator!=", NM="_ZN5clangneENS_22specific_attr_iteratorIT_T0_EES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clangneENS_22specific_attr_iteratorIT_T0_EES4_")
  //</editor-fold>
  public static <SpecificAttr> boolean $noteq_specific_attr_iterator$SpecificAttr(specific_attr_iterator<SpecificAttr> Left, 
                                            specific_attr_iterator<SpecificAttr> Right) {
    return !$eq_specific_attr_iterator$SpecificAttr(Left, Right);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final Class<SpecificAttr> clazz;   
  
  public specific_attr_iterator(specific_attr_iterator<SpecificAttr>  C) {
    // : Current(C) 
    this.Current = $tryClone(C.Current);
    this.clazz = C.clazz;
  }

  @Override
  public boolean $eq(Object other) {
    return $eq_specific_attr_iterator$SpecificAttr(this, (specific_attr_iterator)other);
  }
  
  @Override
  public specific_attr_iterator<SpecificAttr> clone() {
    return new specific_attr_iterator(this);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Current=" + Current; // NOI18N
  }
}
