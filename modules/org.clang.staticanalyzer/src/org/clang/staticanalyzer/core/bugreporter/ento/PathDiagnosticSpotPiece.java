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
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerJavaDifferentiators.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticSpotPiece">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 435,
 FQN="clang::ento::PathDiagnosticSpotPiece", NM="_ZN5clang4ento23PathDiagnosticSpotPieceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento23PathDiagnosticSpotPieceE")
//</editor-fold>
public abstract class PathDiagnosticSpotPiece extends /*public*/ PathDiagnosticPiece implements Destructors.ClassWithDestructor {
/*private:*/
  private PathDiagnosticLocation Pos;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticSpotPiece::PathDiagnosticSpotPiece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 439,
   FQN="clang::ento::PathDiagnosticSpotPiece::PathDiagnosticSpotPiece", NM="_ZN5clang4ento23PathDiagnosticSpotPieceC1ERKNS0_22PathDiagnosticLocationEN4llvm9StringRefENS0_19PathDiagnosticPiece4KindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento23PathDiagnosticSpotPieceC1ERKNS0_22PathDiagnosticLocationEN4llvm9StringRefENS0_19PathDiagnosticPiece4KindEb")
  //</editor-fold>
  public PathDiagnosticSpotPiece(final /*const*/ PathDiagnosticLocation /*&*/ pos, 
      StringRef s, 
      PathDiagnosticPiece.Kind k) {
    this(pos, 
      s, 
      k, 
      true);
  }
  public PathDiagnosticSpotPiece(final /*const*/ PathDiagnosticLocation /*&*/ pos, 
      StringRef s, 
      PathDiagnosticPiece.Kind k, 
      boolean addPosRange/*= true*/) {
    // : PathDiagnosticPiece(s, k), Pos(pos) 
    //START JInit
    super(JD$StringRef_Kind_DisplayHint.INSTANCE, new StringRef(s), k);
    this.Pos = new PathDiagnosticLocation(pos);
    //END JInit
    assert (Pos.isValid() && Pos.asLocation().isValid()) : "PathDiagnosticSpotPiece's must have a valid location.";
    if (addPosRange && Pos.hasRange()) {
      addRange(new SourceRange(JD$Move.INSTANCE, Pos.asRange()));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticSpotPiece::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 449,
   FQN="clang::ento::PathDiagnosticSpotPiece::getLocation", NM="_ZNK5clang4ento23PathDiagnosticSpotPiece11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento23PathDiagnosticSpotPiece11getLocationEv")
  //</editor-fold>
  @Override public PathDiagnosticLocation getLocation() /*const*//* override*/ {
    return new PathDiagnosticLocation(Pos);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticSpotPiece::flattenLocations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 450,
   FQN="clang::ento::PathDiagnosticSpotPiece::flattenLocations", NM="_ZN5clang4ento23PathDiagnosticSpotPiece16flattenLocationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento23PathDiagnosticSpotPiece16flattenLocationsEv")
  //</editor-fold>
  @Override public void flattenLocations()/* override*/ {
    Pos.flatten();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticSpotPiece::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 1083,
   FQN="clang::ento::PathDiagnosticSpotPiece::Profile", NM="_ZNK5clang4ento23PathDiagnosticSpotPiece7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento23PathDiagnosticSpotPiece7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    super.Profile(ID);
    ID.Add(Pos);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticSpotPiece::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 454,
   FQN="clang::ento::PathDiagnosticSpotPiece::classof", NM="_ZN5clang4ento23PathDiagnosticSpotPiece7classofEPKNS0_19PathDiagnosticPieceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento23PathDiagnosticSpotPiece7classofEPKNS0_19PathDiagnosticPieceE")
  //</editor-fold>
  public static boolean classof(/*const*/ PathDiagnosticPiece /*P*/ P) {
    return P.getKind() == Kind.Event || P.getKind() == Kind.Macro;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticSpotPiece::~PathDiagnosticSpotPiece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 435,
   FQN="clang::ento::PathDiagnosticSpotPiece::~PathDiagnosticSpotPiece", NM="_ZN5clang4ento23PathDiagnosticSpotPieceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento23PathDiagnosticSpotPieceD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Pos=" + Pos // NOI18N
              + super.toString(); // NOI18N
  }
}
