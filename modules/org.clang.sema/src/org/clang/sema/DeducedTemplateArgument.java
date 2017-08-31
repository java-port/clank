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

package org.clang.sema;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clang.ast.*;


/// \brief Captures a template argument whose value has been deduced
/// via c++ template argument deduction.
//<editor-fold defaultstate="collapsed" desc="clang::DeducedTemplateArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 139,
 FQN="clang::DeducedTemplateArgument", NM="_ZN5clang23DeducedTemplateArgumentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang23DeducedTemplateArgumentE")
//</editor-fold>
public class DeducedTemplateArgument extends /*public*/ TemplateArgument {
  /// \brief For a non-type template argument, whether the value was
  /// deduced from an array bound.
  private boolean DeducedFromArrayBound;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DeducedTemplateArgument::DeducedTemplateArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 145,
   FQN="clang::DeducedTemplateArgument::DeducedTemplateArgument", NM="_ZN5clang23DeducedTemplateArgumentC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang23DeducedTemplateArgumentC1Ev")
  //</editor-fold>
  public DeducedTemplateArgument() {
    // : TemplateArgument(), DeducedFromArrayBound(false) 
    //START JInit
    super();
    this.DeducedFromArrayBound = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeducedTemplateArgument::DeducedTemplateArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 148,
   FQN="clang::DeducedTemplateArgument::DeducedTemplateArgument", NM="_ZN5clang23DeducedTemplateArgumentC1ERKNS_16TemplateArgumentEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang23DeducedTemplateArgumentC1ERKNS_16TemplateArgumentEb")
  //</editor-fold>
  public DeducedTemplateArgument(final /*const*/ TemplateArgument /*&*/ Arg) {
    this(Arg, 
      false);
  }
  public DeducedTemplateArgument(final /*const*/ TemplateArgument /*&*/ Arg, 
      boolean DeducedFromArrayBound/*= false*/) {
    // : TemplateArgument(Arg), DeducedFromArrayBound(DeducedFromArrayBound) 
    //START JInit
    super(Arg);
    this.DeducedFromArrayBound = DeducedFromArrayBound;
    //END JInit
  }

  
  /// \brief Construct an integral non-type template argument that
  /// has been deduced, possibly from an array bound.
  //<editor-fold defaultstate="collapsed" desc="clang::DeducedTemplateArgument::DeducedTemplateArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 154,
   FQN="clang::DeducedTemplateArgument::DeducedTemplateArgument", NM="_ZN5clang23DeducedTemplateArgumentC1ERNS_10ASTContextERKN4llvm6APSIntENS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang23DeducedTemplateArgumentC1ERNS_10ASTContextERKN4llvm6APSIntENS_8QualTypeEb")
  //</editor-fold>
  public DeducedTemplateArgument(final ASTContext /*&*/ Ctx, 
      final /*const*/ APSInt /*&*/ Value, 
      QualType ValueType, 
      boolean DeducedFromArrayBound) {
    // : TemplateArgument(Ctx, Value, ValueType), DeducedFromArrayBound(DeducedFromArrayBound) 
    //START JInit
    super(Ctx, Value, new QualType(ValueType));
    this.DeducedFromArrayBound = DeducedFromArrayBound;
    //END JInit
  }

  
  /// \brief For a non-type template argument, determine whether the
  /// template argument was deduced from an array bound.
  //<editor-fold defaultstate="collapsed" desc="clang::DeducedTemplateArgument::wasDeducedFromArrayBound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 163,
   FQN="clang::DeducedTemplateArgument::wasDeducedFromArrayBound", NM="_ZNK5clang23DeducedTemplateArgument24wasDeducedFromArrayBoundEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZNK5clang23DeducedTemplateArgument24wasDeducedFromArrayBoundEv")
  //</editor-fold>
  public boolean wasDeducedFromArrayBound() /*const*/ {
    return DeducedFromArrayBound;
  }

  
  /// \brief Specify whether the given non-type template argument
  /// was deduced from an array bound.
  //<editor-fold defaultstate="collapsed" desc="clang::DeducedTemplateArgument::setDeducedFromArrayBound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 167,
   FQN="clang::DeducedTemplateArgument::setDeducedFromArrayBound", NM="_ZN5clang23DeducedTemplateArgument24setDeducedFromArrayBoundEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang23DeducedTemplateArgument24setDeducedFromArrayBoundEb")
  //</editor-fold>
  public void setDeducedFromArrayBound(boolean Deduced) {
    DeducedFromArrayBound = Deduced;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeducedTemplateArgument::DeducedTemplateArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 139,
   FQN="clang::DeducedTemplateArgument::DeducedTemplateArgument", NM="_ZN5clang23DeducedTemplateArgumentC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang23DeducedTemplateArgumentC1ERKS0_")
  //</editor-fold>
  public /*inline*/ DeducedTemplateArgument(final /*const*/ DeducedTemplateArgument /*&*/ $Prm0) {
    // : TemplateArgument(), DeducedFromArrayBound(.DeducedFromArrayBound) 
    //START JInit
    super($Prm0);
    this.DeducedFromArrayBound = $Prm0.DeducedFromArrayBound;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeducedTemplateArgument::DeducedTemplateArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 139,
   FQN="clang::DeducedTemplateArgument::DeducedTemplateArgument", NM="_ZN5clang23DeducedTemplateArgumentC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang23DeducedTemplateArgumentC1EOS0_")
  //</editor-fold>
  public /*inline*/ DeducedTemplateArgument(JD$Move _dparam, final DeducedTemplateArgument /*&&*/$Prm0) {
    // : TemplateArgument(static_cast<DeducedTemplateArgument &&>()), DeducedFromArrayBound(static_cast<DeducedTemplateArgument &&>().DeducedFromArrayBound) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    this.DeducedFromArrayBound = $Prm0.DeducedFromArrayBound;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeducedTemplateArgument::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 139,
   FQN="clang::DeducedTemplateArgument::operator=", NM="_ZN5clang23DeducedTemplateArgumentaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang23DeducedTemplateArgumentaSERKS0_")
  //</editor-fold>
  @Override public /*inline*/ DeducedTemplateArgument /*&*/ $assign(final /*const*/ TemplateArgument /*&*/ $Prm0) {
    /*Deref*/super.$assign($Prm0);
    this.DeducedFromArrayBound = ((DeducedTemplateArgument)$Prm0).DeducedFromArrayBound;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeducedTemplateArgument::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 139,
   FQN="clang::DeducedTemplateArgument::operator=", NM="_ZN5clang23DeducedTemplateArgumentaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang23DeducedTemplateArgumentaSEOS0_")
  //</editor-fold>
  @Override public /*inline*/ DeducedTemplateArgument /*&*/ $assignMove(final TemplateArgument /*&&*/$Prm0) {
    /*Deref*/super.$assignMove($Prm0);
    this.DeducedFromArrayBound = ((DeducedTemplateArgument)$Prm0).DeducedFromArrayBound;
    return /*Deref*/this;
  }

  @Override public DeducedTemplateArgument clone() { return new DeducedTemplateArgument(this); }
  
  @Override public String toString() {
    return "" + "DeducedFromArrayBound=" + DeducedFromArrayBound // NOI18N
              + super.toString(); // NOI18N
  }
}
