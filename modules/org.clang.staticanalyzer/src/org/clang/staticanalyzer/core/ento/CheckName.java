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

package org.clang.staticanalyzer.core.ento;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clang.staticanalyzer.core.ento.*;


// This wrapper is used to ensure that only StringRefs originating from the
// CheckerRegistry are used as check names. We want to make sure all check
// name strings have a lifetime that keeps them alive at least until the path
// diagnostics have been processed.
//<editor-fold defaultstate="collapsed" desc="clang::ento::CheckName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 87,
 FQN="clang::ento::CheckName", NM="_ZN5clang4ento9CheckNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento9CheckNameE")
//</editor-fold>
public class CheckName {
  private StringRef Name;
  /*friend  class ::clang::ento::CheckerRegistry*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckName::CheckName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 90,
   FQN="clang::ento::CheckName::CheckName", NM="_ZN5clang4ento9CheckNameC1EN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento9CheckNameC1EN4llvm9StringRefE")
  //</editor-fold>
  /*friend*/public/*private*/ /*explicit*/ CheckName(StringRef Name) {
    // : Name(Name) 
    //START JInit
    this.Name = new StringRef(Name);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckName::CheckName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 93,
   FQN="clang::ento::CheckName::CheckName", NM="_ZN5clang4ento9CheckNameC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento9CheckNameC1Ev")
  //</editor-fold>
  public CheckName() {
    // : Name()/* = default*/ 
    //START JInit
    this.Name = new StringRef();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckName::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 94,
   FQN="clang::ento::CheckName::getName", NM="_ZNK5clang4ento9CheckName7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZNK5clang4ento9CheckName7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return new StringRef(Name);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckName::CheckName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 87,
   FQN="clang::ento::CheckName::CheckName", NM="_ZN5clang4ento9CheckNameC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento9CheckNameC1ERKS1_")
  //</editor-fold>
  public /*inline*/ CheckName(final /*const*/ CheckName /*&*/ $Prm0) {
    // : Name(.Name) 
    //START JInit
    this.Name = new StringRef($Prm0.Name);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckName::CheckName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 87,
   FQN="clang::ento::CheckName::CheckName", NM="_ZN5clang4ento9CheckNameC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento9CheckNameC1EOS1_")
  //</editor-fold>
  public /*inline*/ CheckName(JD$Move _dparam, final CheckName /*&&*/$Prm0) {
    // : Name(static_cast<CheckName &&>().Name) 
    //START JInit
    this.Name = new StringRef(JD$Move.INSTANCE, $Prm0.Name);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckName::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 87,
   FQN="clang::ento::CheckName::operator=", NM="_ZN5clang4ento9CheckNameaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento9CheckNameaSERKS1_")
  //</editor-fold>
  public /*inline*/ CheckName /*&*/ $assign(final /*const*/ CheckName /*&*/ $Prm0) {
    this.Name.$assign($Prm0.Name);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckName::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 87,
   FQN="clang::ento::CheckName::operator=", NM="_ZN5clang4ento9CheckNameaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento9CheckNameaSEOS1_")
  //</editor-fold>
  public /*inline*/ CheckName /*&*/ $assignMove(final CheckName /*&&*/$Prm0) {
    this.Name.$assignMove($Prm0.Name);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Name=" + Name; // NOI18N
  }
}
