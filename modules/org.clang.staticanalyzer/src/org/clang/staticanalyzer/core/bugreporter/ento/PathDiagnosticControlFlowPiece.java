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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerJavaDifferentiators.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticControlFlowPiece">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 621,
 FQN="clang::ento::PathDiagnosticControlFlowPiece", NM="_ZN5clang4ento30PathDiagnosticControlFlowPieceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento30PathDiagnosticControlFlowPieceE")
//</editor-fold>
public class PathDiagnosticControlFlowPiece extends /*public*/ PathDiagnosticPiece implements Destructors.ClassWithDestructor {
  private std.vector<PathDiagnosticLocationPair> LPairs;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticControlFlowPiece::PathDiagnosticControlFlowPiece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 624,
   FQN="clang::ento::PathDiagnosticControlFlowPiece::PathDiagnosticControlFlowPiece", NM="_ZN5clang4ento30PathDiagnosticControlFlowPieceC1ERKNS0_22PathDiagnosticLocationES4_N4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento30PathDiagnosticControlFlowPieceC1ERKNS0_22PathDiagnosticLocationES4_N4llvm9StringRefE")
  //</editor-fold>
  public PathDiagnosticControlFlowPiece(final /*const*/ PathDiagnosticLocation /*&*/ startPos, 
      final /*const*/ PathDiagnosticLocation /*&*/ endPos, 
      StringRef s) {
    // : PathDiagnosticPiece(s, ControlFlow), LPairs() 
    //START JInit
    super(JD$StringRef_Kind_DisplayHint.INSTANCE, new StringRef(s), Kind.ControlFlow);
    this.LPairs = new std.vector<PathDiagnosticLocationPair>(new PathDiagnosticLocationPair());
    //END JInit
    LPairs.push_back_T$RR(new PathDiagnosticLocationPair(startPos, endPos));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticControlFlowPiece::PathDiagnosticControlFlowPiece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 631,
   FQN="clang::ento::PathDiagnosticControlFlowPiece::PathDiagnosticControlFlowPiece", NM="_ZN5clang4ento30PathDiagnosticControlFlowPieceC1ERKNS0_22PathDiagnosticLocationES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento30PathDiagnosticControlFlowPieceC1ERKNS0_22PathDiagnosticLocationES4_")
  //</editor-fold>
  public PathDiagnosticControlFlowPiece(final /*const*/ PathDiagnosticLocation /*&*/ startPos, 
      final /*const*/ PathDiagnosticLocation /*&*/ endPos) {
    // : PathDiagnosticPiece(ControlFlow), LPairs() 
    //START JInit
    super(JD$Kind_DisplayHint.INSTANCE, Kind.ControlFlow);
    this.LPairs = new std.vector<PathDiagnosticLocationPair>(new PathDiagnosticLocationPair());
    //END JInit
    LPairs.push_back_T$RR(new PathDiagnosticLocationPair(startPos, endPos));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticControlFlowPiece::~PathDiagnosticControlFlowPiece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 61,
   FQN="clang::ento::PathDiagnosticControlFlowPiece::~PathDiagnosticControlFlowPiece", NM="_ZN5clang4ento30PathDiagnosticControlFlowPieceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento30PathDiagnosticControlFlowPieceD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    LPairs.$destroy();
    super.$destroy();
    //END JDestroy
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticControlFlowPiece::getStartLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 639,
   FQN="clang::ento::PathDiagnosticControlFlowPiece::getStartLocation", NM="_ZNK5clang4ento30PathDiagnosticControlFlowPiece16getStartLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento30PathDiagnosticControlFlowPiece16getStartLocationEv")
  //</editor-fold>
  public PathDiagnosticLocation getStartLocation() /*const*/ {
    assert (!LPairs.empty()) : "PathDiagnosticControlFlowPiece needs at least one location.";
    return new PathDiagnosticLocation(LPairs.$at$Const(0).getStart());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticControlFlowPiece::getEndLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 645,
   FQN="clang::ento::PathDiagnosticControlFlowPiece::getEndLocation", NM="_ZNK5clang4ento30PathDiagnosticControlFlowPiece14getEndLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento30PathDiagnosticControlFlowPiece14getEndLocationEv")
  //</editor-fold>
  public PathDiagnosticLocation getEndLocation() /*const*/ {
    assert (!LPairs.empty()) : "PathDiagnosticControlFlowPiece needs at least one location.";
    return new PathDiagnosticLocation(LPairs.$at$Const(0).getEnd());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticControlFlowPiece::setStartLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 651,
   FQN="clang::ento::PathDiagnosticControlFlowPiece::setStartLocation", NM="_ZN5clang4ento30PathDiagnosticControlFlowPiece16setStartLocationERKNS0_22PathDiagnosticLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento30PathDiagnosticControlFlowPiece16setStartLocationERKNS0_22PathDiagnosticLocationE")
  //</editor-fold>
  public void setStartLocation(final /*const*/ PathDiagnosticLocation /*&*/ L) {
    LPairs.$at(0).setStart(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticControlFlowPiece::setEndLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 655,
   FQN="clang::ento::PathDiagnosticControlFlowPiece::setEndLocation", NM="_ZN5clang4ento30PathDiagnosticControlFlowPiece14setEndLocationERKNS0_22PathDiagnosticLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento30PathDiagnosticControlFlowPiece14setEndLocationERKNS0_22PathDiagnosticLocationE")
  //</editor-fold>
  public void setEndLocation(final /*const*/ PathDiagnosticLocation /*&*/ L) {
    LPairs.$at(0).setEnd(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticControlFlowPiece::push_back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 659,
   FQN="clang::ento::PathDiagnosticControlFlowPiece::push_back", NM="_ZN5clang4ento30PathDiagnosticControlFlowPiece9push_backERKNS0_26PathDiagnosticLocationPairE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento30PathDiagnosticControlFlowPiece9push_backERKNS0_26PathDiagnosticLocationPairE")
  //</editor-fold>
  public void push_back(final /*const*/ PathDiagnosticLocationPair /*&*/ X) {
    LPairs.push_back_T$C$R(X);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticControlFlowPiece::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 661,
   FQN="clang::ento::PathDiagnosticControlFlowPiece::getLocation", NM="_ZNK5clang4ento30PathDiagnosticControlFlowPiece11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento30PathDiagnosticControlFlowPiece11getLocationEv")
  //</editor-fold>
  @Override public PathDiagnosticLocation getLocation() /*const*//* override*/ {
    return getStartLocation();
  }

  
  /*typedef std::vector<PathDiagnosticLocationPair>::iterator iterator*/
//  public final class iterator extends std.vector.iterator<PathDiagnosticLocationPair /*P*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticControlFlowPiece::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 666,
   FQN="clang::ento::PathDiagnosticControlFlowPiece::begin", NM="_ZN5clang4ento30PathDiagnosticControlFlowPiece5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento30PathDiagnosticControlFlowPiece5beginEv")
  //</editor-fold>
  public std.vector.iterator<PathDiagnosticLocationPair /*P*/ > begin() {
    return LPairs.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticControlFlowPiece::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 667,
   FQN="clang::ento::PathDiagnosticControlFlowPiece::end", NM="_ZN5clang4ento30PathDiagnosticControlFlowPiece3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento30PathDiagnosticControlFlowPiece3endEv")
  //</editor-fold>
  public std.vector.iterator<PathDiagnosticLocationPair /*P*/ > end() {
    return LPairs.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticControlFlowPiece::flattenLocations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 669,
   FQN="clang::ento::PathDiagnosticControlFlowPiece::flattenLocations", NM="_ZN5clang4ento30PathDiagnosticControlFlowPiece16flattenLocationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento30PathDiagnosticControlFlowPiece16flattenLocationsEv")
  //</editor-fold>
  @Override public void flattenLocations()/* override*/ {
    for (std.vector.iterator<PathDiagnosticLocationPair /*P*/ > I = begin(), E = end(); $noteq___normal_iterator$C(I, E); I.$preInc())  {
      I.$arrow().flatten();
    }
  }

  
  /*typedef std::vector<PathDiagnosticLocationPair>::const_iterator const_iterator*/
//  public final class const_iterator extends std.vector.iterator</*const*/ PathDiagnosticLocationPair /*P*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticControlFlowPiece::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 675,
   FQN="clang::ento::PathDiagnosticControlFlowPiece::begin", NM="_ZNK5clang4ento30PathDiagnosticControlFlowPiece5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento30PathDiagnosticControlFlowPiece5beginEv")
  //</editor-fold>
  public std.vector.iterator</*const*/ PathDiagnosticLocationPair /*P*/ > begin$Const() /*const*/ {
    return LPairs.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticControlFlowPiece::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 676,
   FQN="clang::ento::PathDiagnosticControlFlowPiece::end", NM="_ZNK5clang4ento30PathDiagnosticControlFlowPiece3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento30PathDiagnosticControlFlowPiece3endEv")
  //</editor-fold>
  public std.vector.iterator</*const*/ PathDiagnosticLocationPair /*P*/ > end$Const() /*const*/ {
    return LPairs.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticControlFlowPiece::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 678,
   FQN="clang::ento::PathDiagnosticControlFlowPiece::classof", NM="_ZN5clang4ento30PathDiagnosticControlFlowPiece7classofEPKNS0_19PathDiagnosticPieceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento30PathDiagnosticControlFlowPiece7classofEPKNS0_19PathDiagnosticPieceE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ PathDiagnosticPiece /*P*/ P) {
    return P.getKind() == Kind.ControlFlow;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticControlFlowPiece::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 3508,
   FQN="clang::ento::PathDiagnosticControlFlowPiece::dump", NM="_ZNK5clang4ento30PathDiagnosticControlFlowPiece4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento30PathDiagnosticControlFlowPiece4dumpEv")
  //</editor-fold>
  @Override public void dump() /*const*//* __attribute__((used)) __attribute__((noinline)) override*/ {
    llvm.errs().$out(/*KEEP_STR*/"CONTROL\n--------------\n");
    getStartLocation().dump();
    llvm.errs().$out(/*KEEP_STR*/" ---- to ----\n");
    getEndLocation().dump();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticControlFlowPiece::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 1088,
   FQN="clang::ento::PathDiagnosticControlFlowPiece::Profile", NM="_ZNK5clang4ento30PathDiagnosticControlFlowPiece7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento30PathDiagnosticControlFlowPiece7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    super.Profile(ID);
    for (std.vector.iterator</*const*/ PathDiagnosticLocationPair /*P*/ > I = begin$Const(), E = end$Const(); $noteq___normal_iterator$C(I, E); I.$preInc())  {
      ID.Add(I.$star());
    }
  }


  
  @Override public String toString() {
    return "" + "LPairs=" + LPairs // NOI18N
              + super.toString(); // NOI18N
  }
}
