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
import org.llvm.adt.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocationPair">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 308,
 FQN="clang::ento::PathDiagnosticLocationPair", NM="_ZN5clang4ento26PathDiagnosticLocationPairE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento26PathDiagnosticLocationPairE")
//</editor-fold>
public class PathDiagnosticLocationPair implements NativeCloneable<PathDiagnosticLocationPair>, FoldingSetTrait.Profilable {
/*private:*/
  private PathDiagnosticLocation Start;
  private PathDiagnosticLocation End;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocationPair::PathDiagnosticLocationPair">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 312,
   FQN="clang::ento::PathDiagnosticLocationPair::PathDiagnosticLocationPair", NM="_ZN5clang4ento26PathDiagnosticLocationPairC1ERKNS0_22PathDiagnosticLocationES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento26PathDiagnosticLocationPairC1ERKNS0_22PathDiagnosticLocationES4_")
  //</editor-fold>
  public PathDiagnosticLocationPair(final /*const*/ PathDiagnosticLocation /*&*/ start, 
      final /*const*/ PathDiagnosticLocation /*&*/ end) {
    // : Start(start), End(end) 
    //START JInit
    this.Start = new PathDiagnosticLocation(start);
    this.End = new PathDiagnosticLocation(end);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocationPair::getStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 316,
   FQN="clang::ento::PathDiagnosticLocationPair::getStart", NM="_ZNK5clang4ento26PathDiagnosticLocationPair8getStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento26PathDiagnosticLocationPair8getStartEv")
  //</editor-fold>
  public /*const*/ PathDiagnosticLocation /*&*/ getStart() /*const*/ {
    return Start;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocationPair::getEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 317,
   FQN="clang::ento::PathDiagnosticLocationPair::getEnd", NM="_ZNK5clang4ento26PathDiagnosticLocationPair6getEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento26PathDiagnosticLocationPair6getEndEv")
  //</editor-fold>
  public /*const*/ PathDiagnosticLocation /*&*/ getEnd() /*const*/ {
    return End;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocationPair::setStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 319,
   FQN="clang::ento::PathDiagnosticLocationPair::setStart", NM="_ZN5clang4ento26PathDiagnosticLocationPair8setStartERKNS0_22PathDiagnosticLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento26PathDiagnosticLocationPair8setStartERKNS0_22PathDiagnosticLocationE")
  //</editor-fold>
  public void setStart(final /*const*/ PathDiagnosticLocation /*&*/ L) {
    Start.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocationPair::setEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 320,
   FQN="clang::ento::PathDiagnosticLocationPair::setEnd", NM="_ZN5clang4ento26PathDiagnosticLocationPair6setEndERKNS0_22PathDiagnosticLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento26PathDiagnosticLocationPair6setEndERKNS0_22PathDiagnosticLocationE")
  //</editor-fold>
  public void setEnd(final /*const*/ PathDiagnosticLocation /*&*/ L) {
    End.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocationPair::flatten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 322,
   FQN="clang::ento::PathDiagnosticLocationPair::flatten", NM="_ZN5clang4ento26PathDiagnosticLocationPair7flattenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento26PathDiagnosticLocationPair7flattenEv")
  //</editor-fold>
  public void flatten() {
    Start.flatten();
    End.flatten();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocationPair::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 327,
   FQN="clang::ento::PathDiagnosticLocationPair::Profile", NM="_ZNK5clang4ento26PathDiagnosticLocationPair7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento26PathDiagnosticLocationPair7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    Start.Profile(ID);
    End.Profile(ID);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocationPair::PathDiagnosticLocationPair">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 308,
   FQN="clang::ento::PathDiagnosticLocationPair::PathDiagnosticLocationPair", NM="_ZN5clang4ento26PathDiagnosticLocationPairC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento26PathDiagnosticLocationPairC1ERKS1_")
  //</editor-fold>
  public /*inline*/ PathDiagnosticLocationPair(final /*const*/ PathDiagnosticLocationPair /*&*/ $Prm0) {
    // : Start(.Start), End(.End) 
    //START JInit
    this.Start = new PathDiagnosticLocation($Prm0.Start);
    this.End = new PathDiagnosticLocation($Prm0.End);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocationPair::PathDiagnosticLocationPair">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 308,
   FQN="clang::ento::PathDiagnosticLocationPair::PathDiagnosticLocationPair", NM="_ZN5clang4ento26PathDiagnosticLocationPairC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento26PathDiagnosticLocationPairC1EOS1_")
  //</editor-fold>
  public /*inline*/ PathDiagnosticLocationPair(JD$Move _dparam, final PathDiagnosticLocationPair /*&&*/$Prm0) {
    // : Start(static_cast<PathDiagnosticLocationPair &&>().Start), End(static_cast<PathDiagnosticLocationPair &&>().End) 
    //START JInit
    this.Start = new PathDiagnosticLocation(JD$Move.INSTANCE, $Prm0.Start);
    this.End = new PathDiagnosticLocation(JD$Move.INSTANCE, $Prm0.End);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public PathDiagnosticLocationPair() {
    this.Start = new PathDiagnosticLocation();
    this.End = new PathDiagnosticLocation();
  }

  @Override public PathDiagnosticLocationPair clone() {
    return new PathDiagnosticLocationPair(this);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Start=" + Start // NOI18N
              + ", End=" + End; // NOI18N
  }
}
