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
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::PathPieces">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 421,
 FQN="clang::ento::PathPieces", NM="_ZN5clang4ento10PathPiecesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento10PathPiecesE")
//</editor-fold>
public class PathPieces extends /*public*/ std.list<IntrusiveRefCntPtr<PathDiagnosticPiece>> implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathPieces::flattenTo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 64,
   FQN="clang::ento::PathPieces::flattenTo", NM="_ZNK5clang4ento10PathPieces9flattenToERS1_S2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento10PathPieces9flattenToERS1_S2_b")
  //</editor-fold>
  private void flattenTo(final PathPieces /*&*/ Primary, final PathPieces /*&*/ Current, 
           boolean ShouldFlattenMacros) /*const*/ {
    for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = begin$Const(), E = end$Const(); I.$noteq(E); I.$preInc()) {
      PathDiagnosticPiece /*P*/ Piece = I.$arrow().get();
      switch (Piece.getKind()) {
       case Call:
        {
          IntrusiveRefCntPtr<PathDiagnosticEventPiece> CallEnter = null;
          IntrusiveRefCntPtr<PathDiagnosticEventPiece> callExit = null;
          try {
            PathDiagnosticCallPiece /*P*/ Call = cast_PathDiagnosticCallPiece(Piece);
            CallEnter = Call.getCallEnterEvent();
            if (CallEnter.$bool()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                Current.push_back_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(JD$IntrusiveRefCntPtr$X$C.INSTANCE, CallEnter))); $c$.clean();
              } finally {
                $c$.$destroy();
              }
            }
            Call._path.flattenTo(Primary, Primary, ShouldFlattenMacros);
            callExit = Call.getCallExitEvent();
            if (callExit.$bool()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                Current.push_back_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(JD$IntrusiveRefCntPtr$X$C.INSTANCE, callExit))); $c$.clean();
              } finally {
                $c$.$destroy();
              }
            }
            break;
          } finally {
            if (callExit != null) { callExit.$destroy(); }
            if (CallEnter != null) { CallEnter.$destroy(); }
          }
        }
       case Macro:
        {
          PathDiagnosticMacroPiece /*P*/ Macro = cast_PathDiagnosticMacroPiece(Piece);
          if (ShouldFlattenMacros) {
            Macro.subPieces.flattenTo(Primary, Primary, ShouldFlattenMacros);
          } else {
            PathPieces NewPath = null;
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              Current.push_back_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(Piece))); $c$.clean();
              NewPath/*J*/= new PathPieces();
              Macro.subPieces.flattenTo(Primary, NewPath, ShouldFlattenMacros);
              // FIXME: This probably shouldn't mutate the original path piece.
              Macro.subPieces.$assign(NewPath);
            } finally {
              if (NewPath != null) { NewPath.$destroy(); }
              $c$.$destroy();
            }
          }
          break;
        }
       case Event:
       case ControlFlow:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            Current.push_back_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(Piece))); $c$.clean();
            break;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }


/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathPieces::flatten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 426,
   FQN="clang::ento::PathPieces::flatten", NM="_ZNK5clang4ento10PathPieces7flattenEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento10PathPieces7flattenEb")
  //</editor-fold>
  public PathPieces flatten(boolean ShouldFlattenMacros) /*const*/ {
    PathPieces Result = null;
    try {
      Result/*J*/= new PathPieces();
      flattenTo(Result, Result, ShouldFlattenMacros);
      return new PathPieces(JD$Move.INSTANCE, Result);
    } finally {
      if (Result != null) { Result.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathPieces::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 3481,
   FQN="clang::ento::PathPieces::dump", NM="_ZNK5clang4ento10PathPieces4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento10PathPieces4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    /*uint*/int index = 0;
    for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = begin$Const(), E = end$Const(); I.$noteq(E); I.$preInc()) {
      llvm.errs().$out(/*KEEP_STR*/$LSQUARE).$out_uint(index++).$out(/*KEEP_STR*/"]  ");
      (I.$star()).$arrow().dump();
      llvm.errs().$out(/*KEEP_STR*/$LF);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathPieces::PathPieces">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 421,
   FQN="clang::ento::PathPieces::PathPieces", NM="_ZN5clang4ento10PathPiecesC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento10PathPiecesC1EOS1_")
  //</editor-fold>
  public /*inline*/ PathPieces(JD$Move _dparam, final PathPieces /*&&*/$Prm0) {
    // : std::list<IntrusiveRefCntPtr<PathDiagnosticPiece> >(static_cast<PathPieces &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathPieces::PathPieces">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 421,
   FQN="clang::ento::PathPieces::PathPieces", NM="_ZN5clang4ento10PathPiecesC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento10PathPiecesC1Ev")
  //</editor-fold>
  public /*inline*/ PathPieces() {
    // : std::list<IntrusiveRefCntPtr<PathDiagnosticPiece> >() 
    //START JInit
    super(new IntrusiveRefCntPtr<PathDiagnosticPiece>());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathPieces::PathPieces">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 421,
   FQN="clang::ento::PathPieces::PathPieces", NM="_ZN5clang4ento10PathPiecesC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento10PathPiecesC1ERKS1_")
  //</editor-fold>
  public /*inline*/ PathPieces(final /*const*/ PathPieces /*&*/ $Prm0) {
    // : std::list<IntrusiveRefCntPtr<PathDiagnosticPiece> >() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathPieces::~PathPieces">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 421,
   FQN="clang::ento::PathPieces::~PathPieces", NM="_ZN5clang4ento10PathPiecesD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento10PathPiecesD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathPieces::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 421,
   FQN="clang::ento::PathPieces::operator=", NM="_ZN5clang4ento10PathPiecesaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento10PathPiecesaSERKS1_")
  //</editor-fold>
  public /*inline*/ PathPieces /*&*/ $assign(final /*const*/ PathPieces /*&*/ $Prm0) {
    /*J:ToBase*/super.$assign($Prm0);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void push_back_T$RR(IntrusiveRefCntPtr<PathDiagnosticPiece> val) {
    // T$RR must move our input
    super.push_back_T$RR(val);
    assert !val.$bool() : "push_back above had to release input val " + val;
  }

  @Override
  public void push_front_T$RR(IntrusiveRefCntPtr<PathDiagnosticPiece> val) {
    // T$RR must move our input
    super.push_front_T$RR(val);
    assert !val.$bool() : "push_front above had to release input val " + val;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
