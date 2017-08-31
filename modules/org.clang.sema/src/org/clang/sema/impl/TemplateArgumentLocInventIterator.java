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

package org.clang.sema.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.clang.ast.*;


/// \brief Iterator adaptor that invents template argument location information
/// for each of the template arguments in its underlying iterator.
/*template <typename Derived, typename InputIterator> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInventIterator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3793,
 FQN="clang::TemplateArgumentLocInventIterator", NM="_ZN5clang33TemplateArgumentLocInventIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang33TemplateArgumentLocInventIteratorE")
//</editor-fold>
public class TemplateArgumentLocInventIterator</*typename*/ Derived extends TreeTransform, /*typename*/ InputIterator extends type$iterator<?, TemplateArgument>> 
        implements  type$iterator<TemplateArgumentLocInventIterator, TemplateArgumentLoc> {
  private final TreeTransform<Derived> /*&*/ Self;
  private InputIterator Iter;
/*public:*/
  /*typedef TemplateArgumentLoc value_type*/
//  public final class value_type extends TemplateArgumentLoc{ };
  /*typedef TemplateArgumentLoc reference*/
//  public final class reference extends TemplateArgumentLoc{ };
  /*typedef typename std::iterator_traits<InputIterator>::difference_type difference_type*/
//  public final class difference_type extends  std.iterator_traits<InputIterator>.difference_type{ };
  /*typedef std::input_iterator_tag iterator_category*/
//  public final class iterator_category extends std.input_iterator_tag{ };

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInventIterator::pointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3805,
   FQN="clang::TemplateArgumentLocInventIterator::pointer", NM="_ZN5clang33TemplateArgumentLocInventIterator7pointerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang33TemplateArgumentLocInventIterator7pointerE")
  //</editor-fold>
  public static class pointer {
    private TemplateArgumentLoc Arg;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInventIterator::pointer::pointer">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3809,
     FQN="clang::TemplateArgumentLocInventIterator::pointer::pointer", NM="_ZN5clang33TemplateArgumentLocInventIterator7pointerC1ENS_19TemplateArgumentLocE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang33TemplateArgumentLocInventIterator7pointerC1ENS_19TemplateArgumentLocE")
    //</editor-fold>
    public /*explicit*/ pointer(TemplateArgumentLoc Arg) {
      // : Arg(Arg) 
      //START JInit
      this.Arg = new TemplateArgumentLoc(Arg);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInventIterator::pointer::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3811,
     FQN="clang::TemplateArgumentLocInventIterator::pointer::operator->", NM="_ZNK5clang33TemplateArgumentLocInventIterator7pointerptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang33TemplateArgumentLocInventIterator7pointerptEv")
    //</editor-fold>
    public /*const*/ TemplateArgumentLoc /*P*/ $arrow() /*const*/ {
      return Native.$addr(Arg);
    }

    
    @Override public String toString() {
      return "" + "Arg=" + Arg; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInventIterator::TemplateArgumentLocInventIterator<Derived, InputIterator>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3814,
   FQN="clang::TemplateArgumentLocInventIterator::TemplateArgumentLocInventIterator<Derived, InputIterator>", NM="_ZN5clang33TemplateArgumentLocInventIteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang33TemplateArgumentLocInventIteratorC1Ev")
  //</editor-fold>
  public TemplateArgumentLocInventIterator() {
    this.Self = null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInventIterator::TemplateArgumentLocInventIterator<Derived, InputIterator>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3816,
   FQN="clang::TemplateArgumentLocInventIterator::TemplateArgumentLocInventIterator<Derived, InputIterator>", NM="_ZN5clang33TemplateArgumentLocInventIteratorC1ERNS_13TreeTransformIT_EET0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang33TemplateArgumentLocInventIteratorC1ERNS_13TreeTransformIT_EET0_")
  //</editor-fold>
  public /*explicit*/ TemplateArgumentLocInventIterator(final TreeTransform<Derived> /*&*/ Self, 
      InputIterator Iter) {
    // : Self(Self), Iter(Iter) 
    //START JInit
    this./*&*/Self=/*&*//*ParenListExpr*/Self;
    this.Iter = /*ParenListExpr*//*new InputIterator(Iter)*/ $tryClone(Iter);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInventIterator::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3820,
   FQN="clang::TemplateArgumentLocInventIterator::operator++", NM="_ZN5clang33TemplateArgumentLocInventIteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang33TemplateArgumentLocInventIteratorppEv")
  //</editor-fold>
  public TemplateArgumentLocInventIterator<Derived, InputIterator> /*&*/ $preInc() {
    Iter.$preInc();
    return this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInventIterator::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3825,
   FQN="clang::TemplateArgumentLocInventIterator::operator++", NM="_ZN5clang33TemplateArgumentLocInventIteratorppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang33TemplateArgumentLocInventIteratorppEi")
  //</editor-fold>
  public TemplateArgumentLocInventIterator<Derived, InputIterator> $postInc(int $Prm0) {
    TemplateArgumentLocInventIterator<Derived, InputIterator> Old/*J*/= /*ParenList*/new TemplateArgumentLocInventIterator<Derived, InputIterator>(this);
    this.$preInc();
    return Old;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInventIterator::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3831,
   FQN="clang::TemplateArgumentLocInventIterator::operator*", NM="_ZNK5clang33TemplateArgumentLocInventIteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang33TemplateArgumentLocInventIteratordeEv")
  //</editor-fold>
  public TemplateArgumentLoc $star() /*const*/ {
    TemplateArgumentLoc Result/*J*/= new TemplateArgumentLoc();
    Self.InventTemplateArgumentLoc(Iter.$star(), Result);
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocInventIterator::operator->">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3837,
   FQN="clang::TemplateArgumentLocInventIterator::operator->", NM="_ZNK5clang33TemplateArgumentLocInventIteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang33TemplateArgumentLocInventIteratorptEv")
  //</editor-fold>
  public /*pointer*/ TemplateArgumentLoc $arrow() /*const*/ {
    return this.$star(); //new pointer(this.$star());
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3839,
   FQN="clang::operator==", NM="_ZN5clangeqERKNS_33TemplateArgumentLocInventIteratorIT_T0_EES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clangeqERKNS_33TemplateArgumentLocInventIteratorIT_T0_EES6_")
  //</editor-fold>
  public static </*typename*/ Derived extends TreeTransform, /*typename*/ InputIterator extends type$iterator<?, TemplateArgument>> boolean $eq_TemplateArgumentLocInventIterator$Derived$InputIterator$C(
          final /*const*/ TemplateArgumentLocInventIterator<Derived, InputIterator> /*&*/ X, 
          final /*const*/ TemplateArgumentLocInventIterator<Derived, InputIterator> /*&*/ Y) {
    return Native.$eq_iter(X.Iter, Y.Iter);
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 3844,
   FQN="clang::operator!=", NM="_ZN5clangneERKNS_33TemplateArgumentLocInventIteratorIT_T0_EES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clangneERKNS_33TemplateArgumentLocInventIteratorIT_T0_EES6_")
  //</editor-fold>
  public static </*typename*/ Derived extends TreeTransform, /*typename*/ InputIterator extends type$iterator<?, TemplateArgument>> boolean $noteq_TemplateArgumentLocInventIterator$Derived$InputIterator$C(
          final /*const*/ TemplateArgumentLocInventIterator<Derived, InputIterator> /*&*/ X, 
          final /*const*/ TemplateArgumentLocInventIterator<Derived, InputIterator> /*&*/ Y) {
    return Native.$noteq_iter(X.Iter, Y.Iter);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public TemplateArgumentLocInventIterator(TemplateArgumentLocInventIterator<Derived, InputIterator> other) {
    this.Self = other.Self;
    this.Iter = $tryClone(other.Iter);
  }
  @Override
  public type$ref<TemplateArgumentLoc> star$ref() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public TemplateArgumentLocInventIterator clone() {
    return new TemplateArgumentLocInventIterator(Self, Iter);
  }

  @Override
  public boolean $eq(Object other) {
    return $eq_TemplateArgumentLocInventIterator$Derived$InputIterator$C(this, (TemplateArgumentLocInventIterator) other);
  }

  @Override
  public boolean $noteq(Object other) {
    return $noteq_TemplateArgumentLocInventIterator$Derived$InputIterator$C(this, (TemplateArgumentLocInventIterator) other);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "Self=" + Self // NOI18N
              + ", Iter=" + Iter; // NOI18N
  }
}
