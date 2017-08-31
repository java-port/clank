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

package org.clang.serialization.impl;

import org.clank.support.*;
import org.clang.ast.*;
import org.clank.support.aliases.type$iterator;

/// Iterator over the redeclarations of a declaration that have already
/// been merged into the same redeclaration chain.
/*template <typename DeclT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MergedRedeclIterator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 407,
 FQN="(anonymous namespace)::MergedRedeclIterator", NM="_ZN12_GLOBAL__N_120MergedRedeclIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN12_GLOBAL__N_120MergedRedeclIteratorE")
//</editor-fold>
public class MergedRedeclIterator</*typename*/ DeclT extends Redeclarable>  implements type$iterator<MergedRedeclIterator, DeclT> {
  private DeclT /*P*/ Start;
  private DeclT /*P*/ Canonical;
  private DeclT /*P*/ Current;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MergedRedeclIterator::MergedRedeclIterator<DeclT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 411,
   FQN="(anonymous namespace)::MergedRedeclIterator::MergedRedeclIterator<DeclT>", NM="_ZN12_GLOBAL__N_120MergedRedeclIteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN12_GLOBAL__N_120MergedRedeclIteratorC1Ev")
  //</editor-fold>
  public MergedRedeclIterator() {
    // : Current(null) 
    //START JInit
    this.Current = /*ParenListExpr*/null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MergedRedeclIterator::MergedRedeclIterator<DeclT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 412,
   FQN="(anonymous namespace)::MergedRedeclIterator::MergedRedeclIterator<DeclT>", NM="_ZN12_GLOBAL__N_120MergedRedeclIteratorC1EPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN12_GLOBAL__N_120MergedRedeclIteratorC1EPT_")
  //</editor-fold>
  public MergedRedeclIterator(DeclT /*P*/ Start) {
    // : Start(Start), Canonical(null), Current(Start) 
    //START JInit
    this.Start = /*ParenListExpr*/Start;
    this.Canonical = /*ParenListExpr*/null;
    this.Current = /*ParenListExpr*/Start;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MergedRedeclIterator::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 415,
   FQN="(anonymous namespace)::MergedRedeclIterator::operator*", NM="_ZN12_GLOBAL__N_120MergedRedeclIteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN12_GLOBAL__N_120MergedRedeclIteratordeEv")
  //</editor-fold>
  public DeclT /*P*/ $star() {
    return Current;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MergedRedeclIterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 417,
   FQN="(anonymous namespace)::MergedRedeclIterator::operator++", NM="_ZN12_GLOBAL__N_120MergedRedeclIteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN12_GLOBAL__N_120MergedRedeclIteratorppEv")
  //</editor-fold>
  public MergedRedeclIterator/*<DeclT>*/ /*&*/ $preInc() {
    if (Current.isFirstDecl()) {
      Canonical = Current;
      Current = (DeclT)Current.getMostRecentDecl();
    } else {
      Current = (DeclT)Current.getPreviousDecl();
    }
    
    // If we started in the merged portion, we'll reach our start position
    // eventually. Otherwise, we'll never reach it, but the second declaration
    // we reached was the canonical declaration, so stop when we see that one
    // again.
    if (Native.$bool((Current == Start)) || Native.$bool((Current == Canonical))) {
      Current = null;
    }
    return this;
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::operator!=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 433,
   FQN="(anonymous namespace)::operator!=", NM="_ZN12_GLOBAL__N_1neERKNS_20MergedRedeclIteratorIT_EES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN12_GLOBAL__N_1neERKNS_20MergedRedeclIteratorIT_EES5_")
  //</editor-fold>
  public static </*typename*/ DeclT extends Redeclarable> boolean $noteq_MergedRedeclIterator$DeclT$C(final /*const*/ MergedRedeclIterator<DeclT> /*&*/ A, 
                                     final /*const*/ MergedRedeclIterator<DeclT> /*&*/ B) {
    return A.Current != B.Current;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public MergedRedeclIterator(MergedRedeclIterator<DeclT> other) {
    this.Start = other.Start;
    this.Canonical = other.Canonical;
    this.Current = other.Current;
  }

  @Override
  public MergedRedeclIterator clone() {
    return new MergedRedeclIterator(this);
  }

  @Override
  public boolean $noteq(Object RHS) {
    return $noteq_MergedRedeclIterator$DeclT$C(this, (MergedRedeclIterator<DeclT>)RHS);
  }

  @Override
  public boolean $eq(Object RHS) {
    return this.Current == ((MergedRedeclIterator<DeclT>)RHS).Current;
  }

  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Start=" + Start // NOI18N
              + ", Canonical=" + Canonical // NOI18N
              + ", Current=" + Current; // NOI18N
  }
}
