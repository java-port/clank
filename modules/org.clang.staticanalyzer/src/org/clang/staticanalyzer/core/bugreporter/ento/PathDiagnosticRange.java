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

package org.clang.staticanalyzer.core.bugreporter.ento;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;


//===----------------------------------------------------------------------===//
// Path-sensitive diagnostics.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 121,
 FQN="clang::ento::PathDiagnosticRange", NM="_ZN5clang4ento19PathDiagnosticRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento19PathDiagnosticRangeE")
//</editor-fold>
public class PathDiagnosticRange extends /*public*/ SourceRange {
/*public:*/
  public boolean isPoint;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticRange::PathDiagnosticRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 125,
   FQN="clang::ento::PathDiagnosticRange::PathDiagnosticRange", NM="_ZN5clang4ento19PathDiagnosticRangeC1ENS_11SourceRangeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento19PathDiagnosticRangeC1ENS_11SourceRangeEb")
  //</editor-fold>
  public PathDiagnosticRange(SourceRange R) {
    this(R, false);
  }
  public PathDiagnosticRange(SourceRange R, boolean isP/*= false*/) {
    // : SourceRange(R), isPoint(isP) 
    //START JInit
    super(R);
    this.isPoint = isP;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticRange::PathDiagnosticRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 128,
   FQN="clang::ento::PathDiagnosticRange::PathDiagnosticRange", NM="_ZN5clang4ento19PathDiagnosticRangeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento19PathDiagnosticRangeC1Ev")
  //</editor-fold>
  public PathDiagnosticRange() {
    // : SourceRange(), isPoint(false) 
    //START JInit
    super();
    this.isPoint = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticRange::PathDiagnosticRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 121,
   FQN="clang::ento::PathDiagnosticRange::PathDiagnosticRange", NM="_ZN5clang4ento19PathDiagnosticRangeC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento19PathDiagnosticRangeC1ERKS1_")
  //</editor-fold>
  public /*inline*/ PathDiagnosticRange(final /*const*/ PathDiagnosticRange /*&*/ $Prm0) {
    // : SourceRange(), isPoint(.isPoint) 
    //START JInit
    super($Prm0);
    this.isPoint = $Prm0.isPoint;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticRange::PathDiagnosticRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 121,
   FQN="clang::ento::PathDiagnosticRange::PathDiagnosticRange", NM="_ZN5clang4ento19PathDiagnosticRangeC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento19PathDiagnosticRangeC1EOS1_")
  //</editor-fold>
  public /*inline*/ PathDiagnosticRange(JD$Move _dparam, final PathDiagnosticRange /*&&*/$Prm0) {
    // : SourceRange(static_cast<PathDiagnosticRange &&>()), isPoint(static_cast<PathDiagnosticRange &&>().isPoint) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    this.isPoint = $Prm0.isPoint;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticRange::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 121,
   FQN="clang::ento::PathDiagnosticRange::operator=", NM="_ZN5clang4ento19PathDiagnosticRangeaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento19PathDiagnosticRangeaSERKS1_")
  //</editor-fold>
  public /*inline*/ PathDiagnosticRange /*&*/ $assign(final /*const*/ PathDiagnosticRange /*&*/ $Prm0) {
    /*J:ToBase*/super.$assign($Prm0);
    this.isPoint = $Prm0.isPoint;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticRange::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 121,
   FQN="clang::ento::PathDiagnosticRange::operator=", NM="_ZN5clang4ento19PathDiagnosticRangeaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento19PathDiagnosticRangeaSEOS1_")
  //</editor-fold>
  public /*inline*/ PathDiagnosticRange /*&*/ $assignMove(final PathDiagnosticRange /*&&*/$Prm0) {
    /*J:ToBase*/super.$assignMove($Prm0);
    this.isPoint = $Prm0.isPoint;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "isPoint=" + isPoint // NOI18N
              + super.toString(); // NOI18N
  }
}
