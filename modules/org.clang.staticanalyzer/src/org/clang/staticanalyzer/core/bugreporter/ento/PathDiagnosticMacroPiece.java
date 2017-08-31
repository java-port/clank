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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticMacroPiece">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 687,
 FQN="clang::ento::PathDiagnosticMacroPiece", NM="_ZN5clang4ento24PathDiagnosticMacroPieceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento24PathDiagnosticMacroPieceE")
//</editor-fold>
public class PathDiagnosticMacroPiece extends /*public*/ PathDiagnosticSpotPiece implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticMacroPiece::PathDiagnosticMacroPiece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 689,
   FQN="clang::ento::PathDiagnosticMacroPiece::PathDiagnosticMacroPiece", NM="_ZN5clang4ento24PathDiagnosticMacroPieceC1ERKNS0_22PathDiagnosticLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento24PathDiagnosticMacroPieceC1ERKNS0_22PathDiagnosticLocationE")
  //</editor-fold>
  public PathDiagnosticMacroPiece(final /*const*/ PathDiagnosticLocation /*&*/ pos) {
    // : PathDiagnosticSpotPiece(pos, "", Macro), subPieces() 
    //START JInit
    /*ExprWithCleanups*/super(pos, new StringRef(/*KEEP_STR*/$EMPTY), Kind.Macro);
    this.subPieces = new PathPieces();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticMacroPiece::~PathDiagnosticMacroPiece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 62,
   FQN="clang::ento::PathDiagnosticMacroPiece::~PathDiagnosticMacroPiece", NM="_ZN5clang4ento24PathDiagnosticMacroPieceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento24PathDiagnosticMacroPieceD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    subPieces.$destroy();
    super.$destroy();
    //END JDestroy
  }


  
  public PathPieces subPieces;
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticMacroPiece::containsEvent">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 31,
   FQN="clang::ento::PathDiagnosticMacroPiece::containsEvent", NM="_ZNK5clang4ento24PathDiagnosticMacroPiece13containsEventEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento24PathDiagnosticMacroPiece13containsEventEv")
  //</editor-fold>
  public boolean containsEvent() /*const*/ {
    for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = subPieces.begin$Const(), E = subPieces.end$Const();
         I.$noteq(E); I.$preInc()) {
      if (isa_PathDiagnosticEventPiece(I.$star().$arrow())) {
        return true;
      }
      {
        PathDiagnosticMacroPiece /*P*/ MP = dyn_cast_PathDiagnosticMacroPiece(I.$star().$arrow());
        if ((MP != null)) {
          if (MP.containsEvent()) {
            return true;
          }
        }
      }
    }
    return false;
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticMacroPiece::flattenLocations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 698,
   FQN="clang::ento::PathDiagnosticMacroPiece::flattenLocations", NM="_ZN5clang4ento24PathDiagnosticMacroPiece16flattenLocationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento24PathDiagnosticMacroPiece16flattenLocationsEv")
  //</editor-fold>
  @Override public void flattenLocations()/* override*/ {
    super.flattenLocations();
    for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = subPieces.begin(), 
        E = subPieces.end(); I.$noteq(E); I.$preInc())  {
      (I.$star()).$arrow().flattenLocations();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticMacroPiece::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 704,
   FQN="clang::ento::PathDiagnosticMacroPiece::classof", NM="_ZN5clang4ento24PathDiagnosticMacroPiece7classofEPKNS0_19PathDiagnosticPieceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento24PathDiagnosticMacroPiece7classofEPKNS0_19PathDiagnosticPieceE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ PathDiagnosticPiece /*P*/ P) {
    return P.getKind() == Kind.Macro;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticMacroPiece::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 3515,
   FQN="clang::ento::PathDiagnosticMacroPiece::dump", NM="_ZNK5clang4ento24PathDiagnosticMacroPiece4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento24PathDiagnosticMacroPiece4dumpEv")
  //</editor-fold>
  @Override public void dump() /*const*//* __attribute__((used)) __attribute__((noinline)) override*/ {
    llvm.errs().$out(/*KEEP_STR*/"MACRO\n--------------\n");
    // FIXME: Print which macro is being invoked.
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticMacroPiece::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 1094,
   FQN="clang::ento::PathDiagnosticMacroPiece::Profile", NM="_ZNK5clang4ento24PathDiagnosticMacroPiece7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento24PathDiagnosticMacroPiece7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    super.Profile(ID);
    for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = subPieces.begin$Const(), E = subPieces.end$Const();
         I.$noteq(E); I.$preInc())  {
      ID.Add(I.$star().$star());
    }
  }


  
  @Override public String toString() {
    return "" + "subPieces=" + subPieces // NOI18N
              + super.toString(); // NOI18N
  }
}
