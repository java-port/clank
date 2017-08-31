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
import org.clang.ast.*;
import org.clang.ast.java.*;


/// \brief Simple iterator that traverses the template arguments in a
/// container that provides a \c getArgLoc() member function.
///
/// This iterator is intended to be used with the iterator form of
/// \c TreeTransform<Derived>::TransformTemplateArguments().
/*template <typename ArgLocContainer> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocContainerIterator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5499,
 FQN="clang::TemplateArgumentLocContainerIterator", NM="_ZN5clang36TemplateArgumentLocContainerIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang36TemplateArgumentLocContainerIteratorE")
//</editor-fold>
public class TemplateArgumentLocContainerIterator</*typename*/ ArgLocContainer extends TemplateSpecializationTypeLocBase> implements type$iterator<TemplateArgumentLocContainerIterator, TemplateArgumentLoc>  {
  private ArgLocContainer /*P*/ Container;
  private /*uint*/int Index;
/*public:*/
  /*typedef TemplateArgumentLoc value_type*/
//  public final class value_type extends TemplateArgumentLoc{ };
  /*typedef TemplateArgumentLoc reference*/
//  public final class reference extends TemplateArgumentLoc{ };
  /*typedef int difference_type*/;
  /*typedef std::input_iterator_tag iterator_category*/
//  public final class iterator_category extends std.input_iterator_tag{ };
  
  // TODO: why did I need to add this manually???
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private TemplateArgumentLocContainerIterator(TemplateArgumentLocContainerIterator<ArgLocContainer> other) {
    this.Container = other.Container;
    this.Index = other.Index;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocContainerIterator::pointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5510,
   FQN="clang::TemplateArgumentLocContainerIterator::pointer", NM="_ZN5clang36TemplateArgumentLocContainerIterator7pointerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang36TemplateArgumentLocContainerIterator7pointerE")
  //</editor-fold>
  public static class pointer {
    private TemplateArgumentLoc Arg;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocContainerIterator::pointer::pointer">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5514,
     FQN="clang::TemplateArgumentLocContainerIterator::pointer::pointer", NM="_ZN5clang36TemplateArgumentLocContainerIterator7pointerC1ENS_19TemplateArgumentLocE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang36TemplateArgumentLocContainerIterator7pointerC1ENS_19TemplateArgumentLocE")
    //</editor-fold>
    public /*explicit*/ pointer(TemplateArgumentLoc Arg) {
      // : Arg(Arg) 
      //START JInit
      this.Arg = new TemplateArgumentLoc(Arg);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocContainerIterator::pointer::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5516,
     FQN="clang::TemplateArgumentLocContainerIterator::pointer::operator->", NM="_ZNK5clang36TemplateArgumentLocContainerIterator7pointerptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang36TemplateArgumentLocContainerIterator7pointerptEv")
    //</editor-fold>
    public /*const*/ TemplateArgumentLoc /*P*/ $arrow() /*const*/ {
      return Native.$addr(Arg);
    }

    
    @Override public String toString() {
      return "" + "Arg=" + Arg; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocContainerIterator::TemplateArgumentLocContainerIterator<ArgLocContainer>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5522,
   FQN="clang::TemplateArgumentLocContainerIterator::TemplateArgumentLocContainerIterator<ArgLocContainer>", NM="_ZN5clang36TemplateArgumentLocContainerIteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang36TemplateArgumentLocContainerIteratorC1Ev")
  //</editor-fold>
  public TemplateArgumentLocContainerIterator() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocContainerIterator::TemplateArgumentLocContainerIterator<ArgLocContainer>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5524,
   FQN="clang::TemplateArgumentLocContainerIterator::TemplateArgumentLocContainerIterator<ArgLocContainer>", NM="_ZN5clang36TemplateArgumentLocContainerIteratorC1ERT_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang36TemplateArgumentLocContainerIteratorC1ERT_j")
  //</editor-fold>
  public TemplateArgumentLocContainerIterator(final ArgLocContainer /*&*/ Container, 
      /*uint*/int Index) {
    // : Container(& Container), Index(Index) 
    //START JInit
    this.Container = /*ParenListExpr*/Container;
    this.Index = Index;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocContainerIterator::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5528,
   FQN="clang::TemplateArgumentLocContainerIterator::operator++", NM="_ZN5clang36TemplateArgumentLocContainerIteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang36TemplateArgumentLocContainerIteratorppEv")
  //</editor-fold>
  public TemplateArgumentLocContainerIterator<ArgLocContainer> /*&*/ $preInc() {
    ++Index;
    return this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocContainerIterator::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5533,
   FQN="clang::TemplateArgumentLocContainerIterator::operator++", NM="_ZN5clang36TemplateArgumentLocContainerIteratorppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang36TemplateArgumentLocContainerIteratorppEi")
  //</editor-fold>
  public TemplateArgumentLocContainerIterator<ArgLocContainer> $postInc(int $Prm0) {
    TemplateArgumentLocContainerIterator<ArgLocContainer> Old/*J*/= /*ParenList*/new TemplateArgumentLocContainerIterator<ArgLocContainer>(this);
    this.$preInc();
    return Old;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocContainerIterator::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5539,
   FQN="clang::TemplateArgumentLocContainerIterator::operator*", NM="_ZNK5clang36TemplateArgumentLocContainerIteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang36TemplateArgumentLocContainerIteratordeEv")
  //</editor-fold>
  public TemplateArgumentLoc $star() /*const*/ {
    return Container.getArgLoc(Index);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLocContainerIterator::operator->">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5543,
   FQN="clang::TemplateArgumentLocContainerIterator::operator->", NM="_ZNK5clang36TemplateArgumentLocContainerIteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang36TemplateArgumentLocContainerIteratorptEv")
  //</editor-fold>
//  public pointer $arrow() /*const*/ {
//    return new pointer(Container.getArgLoc(Index));
//  }
  public TemplateArgumentLoc $arrow() /*const*/ {
    return new TemplateArgumentLoc(Container.getArgLoc(Index));
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5547,
   FQN="clang::operator==", NM="_ZN5clangeqERKNS_36TemplateArgumentLocContainerIteratorIT_EES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clangeqERKNS_36TemplateArgumentLocContainerIteratorIT_EES5_")
  //</editor-fold>
  public static </*typename*/ ArgLocContainer extends TemplateSpecializationTypeLoc> boolean $eq_TemplateArgumentLocContainerIterator$ArgLocContainer$C(final /*const*/ TemplateArgumentLocContainerIterator<ArgLocContainer> /*&*/ X, 
                                                            final /*const*/ TemplateArgumentLocContainerIterator<ArgLocContainer> /*&*/ Y) {
    return Native.$bool(Native.$eq(X.Container, Y.Container)) && Native.$bool(Native.$eq(X.Index, Y.Index));
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 5552,
   FQN="clang::operator!=", NM="_ZN5clangneERKNS_36TemplateArgumentLocContainerIteratorIT_EES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clangneERKNS_36TemplateArgumentLocContainerIteratorIT_EES5_")
  //</editor-fold>
  public static </*typename*/ ArgLocContainer extends TemplateSpecializationTypeLoc> boolean $noteq_TemplateArgumentLocContainerIterator$ArgLocContainer$C(final /*const*/ TemplateArgumentLocContainerIterator<ArgLocContainer> /*&*/ X, 
                                                               final /*const*/ TemplateArgumentLocContainerIterator<ArgLocContainer> /*&*/ Y) {
    return Native.$not((Native.$eq(X, Y)));
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public type$ref<TemplateArgumentLoc> star$ref() {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
  @Override
  public TemplateArgumentLocContainerIterator clone() {
    return new TemplateArgumentLocContainerIterator(Container, Index);
  }

  @Override
  public boolean $eq(Object other) {
    return $eq_TemplateArgumentLocContainerIterator$ArgLocContainer$C(
            (TemplateArgumentLocContainerIterator)this, 
            (TemplateArgumentLocContainerIterator)other
           );
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Container=" + Container // NOI18N
              + ", Index=" + Index; // NOI18N
  }
}
