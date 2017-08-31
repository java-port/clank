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

package org.clang.sema.threadSafety.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import org.clang.sema.impl.*;
import org.clang.analysis.analyses.threadSafety.*;
import static org.clang.analysis.analyses.threadSafety.ThreadSafetyGlobals.getLockKindFromAccessKind;
import org.clang.basic.java.OptionalNotes;
import org.clang.basic.java.PartialDiagList;

//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1472,
 FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter", NM="_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporterE")
//</editor-fold>
public class ThreadSafetyReporter extends /*public*/ ThreadSafetyHandler implements Destructors.ClassWithDestructor {
  private final Sema /*&*/ S;
  private PartialDiagList Warnings;
  private SourceLocation FunLocation;
  private SourceLocation FunEndLocation;
  
  private /*const*/ FunctionDecl /*P*/ CurrentFunction;
  private boolean Verbose;
  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::getNotes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1480,
   FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::getNotes", NM="_ZNK5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter8getNotesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZNK5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter8getNotesEv")
  //</editor-fold>
  private OptionalNotes getNotes() /*const*/ {
    if (Verbose && (CurrentFunction != null)) {
      std.pairTypeType<SourceLocation, PartialDiagnostic> FNote = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        FNote/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(JD$Move.INSTANCE, /*Fwd*/CurrentFunction.getBody().getLocStart()), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.note_thread_warning_in_fun)), 
    new StringRef(CurrentFunction.getNameAsString())))
            ));
        return new OptionalNotes(JD$UInt_T$C$R.INSTANCE, 1, 1, FNote);
      } finally {
        if (FNote != null) { FNote.$destroy(); }
        $c$.$destroy();
      }
    }
    return new OptionalNotes(1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::getNotes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1490,
   FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::getNotes", NM="_ZNK5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter8getNotesERKSt4pairINS_14SourceLocationENS_17PartialDiagnosticEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZNK5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter8getNotesERKSt4pairINS_14SourceLocationENS_17PartialDiagnosticEE")
  //</editor-fold>
  private OptionalNotes getNotes(final /*const*/std.pairTypeType<SourceLocation, PartialDiagnostic> /*&*/ Note) /*const*/ {
    OptionalNotes ONS = null;
    try {
      ONS/*J*/= new OptionalNotes(JD$UInt_T$C$R.INSTANCE, 1, 1, Note);
      if (Verbose && (CurrentFunction != null)) {
        std.pairTypeType<SourceLocation, PartialDiagnostic> FNote = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          FNote/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(JD$Move.INSTANCE, /*Fwd*/CurrentFunction.getBody().getLocStart()), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.note_thread_warning_in_fun)), 
    new StringRef(CurrentFunction.getNameAsString())))
              ));
          ONS.push_back_T$RR(std.move(FNote));
        } finally {
          if (FNote != null) { FNote.$destroy(); }
          $c$.$destroy();
        }
      }
      return new OptionalNotes(JD$Move.INSTANCE, ONS);
    } finally {
      if (ONS != null) { ONS.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::getNotes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1501,
   FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::getNotes", NM="_ZNK5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter8getNotesERKSt4pairINS_14SourceLocationENS_17PartialDiagnosticEES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZNK5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter8getNotesERKSt4pairINS_14SourceLocationENS_17PartialDiagnosticEES8_")
  //</editor-fold>
  private OptionalNotes getNotes(final /*const*/std.pairTypeType<SourceLocation, PartialDiagnostic> /*&*/ Note1, 
          final /*const*/std.pairTypeType<SourceLocation, PartialDiagnostic> /*&*/ Note2) /*const*/ {
    OptionalNotes ONS = null;
    try {
      ONS/*J*/= new OptionalNotes(1);
      ONS.push_back_T$C$R(Note1);
      ONS.push_back_T$C$R(Note2);
      if (Verbose && (CurrentFunction != null)) {
        std.pairTypeType<SourceLocation, PartialDiagnostic> FNote = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          FNote/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(JD$Move.INSTANCE, /*Fwd*/CurrentFunction.getBody().getLocStart()), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.note_thread_warning_in_fun)), 
    new StringRef(CurrentFunction.getNameAsString())))
              ));
          ONS.push_back_T$RR(std.move(FNote));
        } finally {
          if (FNote != null) { FNote.$destroy(); }
          $c$.$destroy();
        }
      }
      return new OptionalNotes(JD$Move.INSTANCE, ONS);
    } finally {
      if (ONS != null) { ONS.$destroy(); }
    }
  }

  
  // Helper functions
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::warnLockMismatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1516,
   FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::warnLockMismatch", NM="_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter16warnLockMismatchEjN4llvm9StringRefES4_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter16warnLockMismatchEjN4llvm9StringRefES4_NS_14SourceLocationE")
  //</editor-fold>
  private void warnLockMismatch(/*uint*/int DiagID, StringRef Kind, StringRef LockName, 
                  SourceLocation Loc) {
    std.pairTypeType<SourceLocation, PartialDiagnostic> Warning = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Gracefully handle rare cases when the analysis can't get a more
      // precise source location.
      if (!Loc.isValid()) {
        Loc.$assign(FunLocation);
      }
      Warning/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(/*Fwd*/Loc), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(DiagID)), /*NO_COPY*/Kind), /*NO_COPY*/LockName))));
      Warnings.emplace_back(new std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes>($Move(std.move(Warning)), $Move($c$.track(getNotes())))); $c$.clean();
    } finally {
      if (Warning != null) { Warning.$destroy(); }
      $c$.$destroy();
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::ThreadSafetyReporter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1527,
   FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::ThreadSafetyReporter", NM="_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporterC1ERNS_4SemaENS_14SourceLocationES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporterC1ERNS_4SemaENS_14SourceLocationES5_")
  //</editor-fold>
  public ThreadSafetyReporter(final Sema /*&*/ S, SourceLocation FL, SourceLocation FEL) {
    // : ThreadSafetyHandler(), S(S), Warnings(), FunLocation(FL), FunEndLocation(FEL), CurrentFunction(null), Verbose(false) 
    //START JInit
    super();
    this./*&*/S=/*&*/S;
    this.Warnings = new PartialDiagList();
    this.FunLocation = new SourceLocation(FL);
    this.FunEndLocation = new SourceLocation(FEL);
    this.CurrentFunction = null;
    this.Verbose = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::setVerbose">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1531,
   FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::setVerbose", NM="_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter10setVerboseEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter10setVerboseEb")
  //</editor-fold>
  public void setVerbose(boolean b) {
    Verbose = b;
  }

  
  /// \brief Emit all buffered diagnostics in order of sourcelocation.
  /// We need to output diagnostics produced while iterating through
  /// the lockset in deterministic order, so this function orders diagnostics
  /// and outputs them.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::emitDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1537,
   FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::emitDiagnostics", NM="_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter15emitDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter15emitDiagnosticsEv")
  //</editor-fold>
  public void emitDiagnostics() {
    Warnings.sort$T(new SortDiagBySourceLocation(S.getSourceManager()));
    for (final /*const*/std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes> /*&*/ Diag : Warnings) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(new SourceLocation(Diag.first.first), Diag.first.second)));
        for (final /*const*/std.pairTypeType<SourceLocation, PartialDiagnostic> /*&*/ Note : Diag.second)  {
          $c$.clean($c$.track(S.Diag(new SourceLocation(Note.first), Note.second)));
        }
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleInvalidLockExp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1546,
   FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleInvalidLockExp", NM="_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter20handleInvalidLockExpEN4llvm9StringRefENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter20handleInvalidLockExpEN4llvm9StringRefENS_14SourceLocationE")
  //</editor-fold>
  @Override public void handleInvalidLockExp(StringRef Kind, SourceLocation Loc)/* override*/ {
    std.pairTypeType<SourceLocation, PartialDiagnostic> Warning = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Warning/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(/*Fwd*/Loc), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_SourceRange($c$.track(S.PDiag(diag.warn_cannot_resolve_lock)), 
    new SourceRange(/*NO_COPY*/Loc)))));
      Warnings.emplace_back(new std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes>($Move(std.move(Warning)), $Move($c$.track(getNotes())))); $c$.clean();
    } finally {
      if (Warning != null) { Warning.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleUnmatchedUnlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1552,
   FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleUnmatchedUnlock", NM="_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter21handleUnmatchedUnlockEN4llvm9StringRefES4_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter21handleUnmatchedUnlockEN4llvm9StringRefES4_NS_14SourceLocationE")
  //</editor-fold>
  @Override public void handleUnmatchedUnlock(StringRef Kind, StringRef LockName, 
                       SourceLocation Loc)/* override*/ {
    warnLockMismatch(diag.warn_unlock_but_no_lock, new StringRef(Kind), new StringRef(LockName), new SourceLocation(Loc));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleIncorrectUnlockKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1557,
   FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleIncorrectUnlockKind", NM="_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter25handleIncorrectUnlockKindEN4llvm9StringRefES4_NS0_8LockKindES5_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter25handleIncorrectUnlockKindEN4llvm9StringRefES4_NS0_8LockKindES5_NS_14SourceLocationE")
  //</editor-fold>
  @Override public void handleIncorrectUnlockKind(StringRef Kind, StringRef LockName, 
                           LockKind Expected, LockKind Received, 
                           SourceLocation Loc)/* override*/ {
    std.pairTypeType<SourceLocation, PartialDiagnostic> Warning = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (Loc.isInvalid()) {
        Loc.$assign(FunLocation);
      }
      Warning/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(/*Fwd*/Loc), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_int(PartialDiagnostic.$out_PartialDiagnostic$C_int(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.warn_unlock_kind_mismatch)), 
                /*NO_COPY*/Kind), /*NO_COPY*/LockName), Received.getValue()), 
    Expected.getValue()))));
      Warnings.emplace_back(new std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes>($Move(std.move(Warning)), $Move($c$.track(getNotes())))); $c$.clean();
    } finally {
      if (Warning != null) { Warning.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleDoubleLock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1568,
   FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleDoubleLock", NM="_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter16handleDoubleLockEN4llvm9StringRefES4_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter16handleDoubleLockEN4llvm9StringRefES4_NS_14SourceLocationE")
  //</editor-fold>
  @Override public void handleDoubleLock(StringRef Kind, StringRef LockName, SourceLocation Loc)/* override*/ {
    warnLockMismatch(diag.warn_double_lock, new StringRef(Kind), new StringRef(LockName), new SourceLocation(Loc));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleMutexHeldEndOfScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1572,
   FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleMutexHeldEndOfScope", NM="_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter25handleMutexHeldEndOfScopeEN4llvm9StringRefES4_NS_14SourceLocationES5_NS0_13LockErrorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter25handleMutexHeldEndOfScopeEN4llvm9StringRefES4_NS_14SourceLocationES5_NS0_13LockErrorKindE")
  //</editor-fold>
  @Override public void handleMutexHeldEndOfScope(StringRef Kind, StringRef LockName, 
                           SourceLocation LocLocked, 
                           SourceLocation LocEndOfScope, 
                           LockErrorKind LEK)/* override*/ {
    std.pairTypeType<SourceLocation, PartialDiagnostic> Warning = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*uint*/int DiagID = 0;
      switch (LEK) {
       case LEK_LockedSomePredecessors:
        DiagID = diag.warn_lock_some_predecessors;
        break;
       case LEK_LockedSomeLoopIterations:
        DiagID = diag.warn_expecting_lock_held_on_loop;
        break;
       case LEK_LockedAtEndOfFunction:
        DiagID = diag.warn_no_unlock;
        break;
       case LEK_NotLockedAtEndOfFunction:
        DiagID = diag.warn_expecting_locked;
        break;
      }
      if (LocEndOfScope.isInvalid()) {
        LocEndOfScope.$assign(FunEndLocation);
      }
      
      Warning/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(/*Fwd*/LocEndOfScope), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(DiagID)), /*NO_COPY*/Kind), 
    /*NO_COPY*/LockName))));
      if (LocLocked.isValid()) {
        std.pairTypeType<SourceLocation, PartialDiagnostic> Note = null;
        try {
          Note/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(/*Fwd*/LocLocked), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.note_locked_here)), 
    /*NO_COPY*/Kind))));
          Warnings.emplace_back(new std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes>($Move(std.move(Warning)), $Move($c$.track(getNotes(Note))))); $c$.clean();
          return;
        } finally {
          if (Note != null) { Note.$destroy(); }
        }
      }
      Warnings.emplace_back(new std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes>($Move(std.move(Warning)), $Move($c$.track(getNotes())))); $c$.clean();
    } finally {
      if (Warning != null) { Warning.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleExclusiveAndShared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1605,
   FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleExclusiveAndShared", NM="_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter24handleExclusiveAndSharedEN4llvm9StringRefES4_NS_14SourceLocationES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter24handleExclusiveAndSharedEN4llvm9StringRefES4_NS_14SourceLocationES5_")
  //</editor-fold>
  @Override public void handleExclusiveAndShared(StringRef Kind, StringRef LockName, 
                          SourceLocation Loc1, 
                          SourceLocation Loc2)/* override*/ {
    std.pairTypeType<SourceLocation, PartialDiagnostic> Warning = null;
    std.pairTypeType<SourceLocation, PartialDiagnostic> Note = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Warning/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(/*Fwd*/Loc1), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.warn_lock_exclusive_and_shared)), 
        /*NO_COPY*/Kind), /*NO_COPY*/LockName))
          ));
      Note/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(/*Fwd*/Loc2), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.note_lock_exclusive_and_shared)), 
        /*NO_COPY*/Kind), /*NO_COPY*/LockName))));
      Warnings.emplace_back(new std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes>($Move(std.move(Warning)), $Move($c$.track(getNotes(Note))))); $c$.clean();
    } finally {
      if (Note != null) { Note.$destroy(); }
      if (Warning != null) { Warning.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleNoMutexHeld">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1616,
   FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleNoMutexHeld", NM="_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter17handleNoMutexHeldEN4llvm9StringRefEPKNS_9NamedDeclENS0_22ProtectedOperationKindENS0_10AccessKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter17handleNoMutexHeldEN4llvm9StringRefEPKNS_9NamedDeclENS0_22ProtectedOperationKindENS0_10AccessKindENS_14SourceLocationE")
  //</editor-fold>
  @Override public void handleNoMutexHeld(StringRef Kind, /*const*/ NamedDecl /*P*/ D, 
                   ProtectedOperationKind POK, AccessKind AK, 
                   SourceLocation Loc)/* override*/ {
    std.pairTypeType<SourceLocation, PartialDiagnostic> Warning = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert ((POK == ProtectedOperationKind.POK_VarAccess || POK == ProtectedOperationKind.POK_VarDereference)) : "Only works for variables";
      /*uint*/int DiagID = POK == ProtectedOperationKind.POK_VarAccess ? diag.warn_variable_requires_any_lock : diag.warn_var_deref_requires_any_lock;
      Warning/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(/*Fwd*/Loc), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_int(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(DiagID)), 
        new StringRef(D.getNameAsString())), getLockKindFromAccessKind(AK).getValue()))));
      Warnings.emplace_back(new std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes>($Move(std.move(Warning)), $Move($c$.track(getNotes())))); $c$.clean();
    } finally {
      if (Warning != null) { Warning.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleMutexNotHeld">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1629,
   FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleMutexNotHeld", NM="_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter18handleMutexNotHeldEN4llvm9StringRefEPKNS_9NamedDeclENS0_22ProtectedOperationKindES4_NS0_8LockKindENS_14SourceLocationEPS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter18handleMutexNotHeldEN4llvm9StringRefEPKNS_9NamedDeclENS0_22ProtectedOperationKindES4_NS0_8LockKindENS_14SourceLocationEPS4_")
  //</editor-fold>
  @Override public void handleMutexNotHeld(StringRef Kind, /*const*/ NamedDecl /*P*/ D, 
                    ProtectedOperationKind POK, StringRef LockName, 
                    LockKind LK, SourceLocation Loc, 
                    StringRef /*P*/ PossibleMatch)/* override*/ {
    /*uint*/int DiagID = 0;
    if ((PossibleMatch != null)) {
      std.pairTypeType<SourceLocation, PartialDiagnostic> Warning = null;
      std.pairTypeType<SourceLocation, PartialDiagnostic> Note = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        switch (POK) {
         case POK_VarAccess:
          DiagID = diag.warn_variable_requires_lock_precise;
          break;
         case POK_VarDereference:
          DiagID = diag.warn_var_deref_requires_lock_precise;
          break;
         case POK_FunctionCall:
          DiagID = diag.warn_fun_requires_lock_precise;
          break;
         case POK_PassByRef:
          DiagID = diag.warn_guarded_pass_by_reference;
          break;
         case POK_PtPassByRef:
          DiagID = diag.warn_pt_guarded_pass_by_reference;
          break;
        }
        Warning/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(/*Fwd*/Loc), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_int(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(DiagID)), /*NO_COPY*/Kind), 
            new StringRef(D.getNameAsString())), 
        /*NO_COPY*/LockName), LK.getValue()))));
        Note/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(/*Fwd*/Loc), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.note_found_mutex_near_match)), 
    /*NO_COPY*/$Deref(PossibleMatch)))));
        if (Verbose && POK == ProtectedOperationKind.POK_VarAccess) {
          std.pairTypeType<SourceLocation, PartialDiagnostic> VNote = null;
          try {
            VNote/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(JD$Move.INSTANCE, /*Fwd*/D.getLocation()), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.note_guarded_by_declared_here)), 
    new StringRef(D.getNameAsString())))
                ));
            Warnings.emplace_back(new std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes>($Move(std.move(Warning)), $Move($c$.track(getNotes(Note, VNote))))); $c$.clean();
          } finally {
            if (VNote != null) { VNote.$destroy(); }
          }
        } else {
          Warnings.emplace_back(new std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes>($Move(std.move(Warning)), $Move($c$.track(getNotes(Note))))); $c$.clean();
        }
      } finally {
        if (Note != null) { Note.$destroy(); }
        if (Warning != null) { Warning.$destroy(); }
        $c$.$destroy();
      }
    } else {
      std.pairTypeType<SourceLocation, PartialDiagnostic> Warning = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        switch (POK) {
         case POK_VarAccess:
          DiagID = diag.warn_variable_requires_lock;
          break;
         case POK_VarDereference:
          DiagID = diag.warn_var_deref_requires_lock;
          break;
         case POK_FunctionCall:
          DiagID = diag.warn_fun_requires_lock;
          break;
         case POK_PassByRef:
          DiagID = diag.warn_guarded_pass_by_reference;
          break;
         case POK_PtPassByRef:
          DiagID = diag.warn_pt_guarded_pass_by_reference;
          break;
        }
        Warning/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(/*Fwd*/Loc), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_int(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(DiagID)), /*NO_COPY*/Kind), 
            new StringRef(D.getNameAsString())), 
        /*NO_COPY*/LockName), LK.getValue()))));
        if (Verbose && POK == ProtectedOperationKind.POK_VarAccess) {
          std.pairTypeType<SourceLocation, PartialDiagnostic> Note = null;
          try {
            Note/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(JD$Move.INSTANCE, /*Fwd*/D.getLocation()), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.note_guarded_by_declared_here)), 
    new StringRef(D.getNameAsString())))
                ));
            Warnings.emplace_back(new std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes>($Move(std.move(Warning)), $Move($c$.track(getNotes(Note))))); $c$.clean();
          } finally {
            if (Note != null) { Note.$destroy(); }
          }
        } else {
          Warnings.emplace_back(new std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes>($Move(std.move(Warning)), $Move($c$.track(getNotes())))); $c$.clean();
        }
      } finally {
        if (Warning != null) { Warning.$destroy(); }
        $c$.$destroy();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleNegativeNotHeld">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1695,
   FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleNegativeNotHeld", NM="_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter21handleNegativeNotHeldEN4llvm9StringRefES4_S4_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter21handleNegativeNotHeldEN4llvm9StringRefES4_S4_NS_14SourceLocationE")
  //</editor-fold>
  @Override public void handleNegativeNotHeld(StringRef Kind, StringRef LockName, StringRef Neg, 
                       SourceLocation Loc)/* override*/ {
    std.pairTypeType<SourceLocation, PartialDiagnostic> Warning = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Warning/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(/*Fwd*/Loc), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.warn_acquire_requires_negative_cap)), 
            /*NO_COPY*/Kind), /*NO_COPY*/LockName), /*NO_COPY*/Neg))
          ));
      Warnings.emplace_back(new std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes>($Move(std.move(Warning)), $Move($c$.track(getNotes())))); $c$.clean();
    } finally {
      if (Warning != null) { Warning.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleFunExcludesLock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1703,
   FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleFunExcludesLock", NM="_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter21handleFunExcludesLockEN4llvm9StringRefES4_S4_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter21handleFunExcludesLockEN4llvm9StringRefES4_S4_NS_14SourceLocationE")
  //</editor-fold>
  @Override public void handleFunExcludesLock(StringRef Kind, StringRef FunName, StringRef LockName, 
                       SourceLocation Loc)/* override*/ {
    std.pairTypeType<SourceLocation, PartialDiagnostic> Warning = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Warning/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(/*Fwd*/Loc), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.warn_fun_excludes_mutex)), 
            /*NO_COPY*/Kind), /*NO_COPY*/FunName), /*NO_COPY*/LockName))));
      Warnings.emplace_back(new std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes>($Move(std.move(Warning)), $Move($c$.track(getNotes())))); $c$.clean();
    } finally {
      if (Warning != null) { Warning.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleLockAcquiredBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1710,
   FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleLockAcquiredBefore", NM="_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter24handleLockAcquiredBeforeEN4llvm9StringRefES4_S4_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter24handleLockAcquiredBeforeEN4llvm9StringRefES4_S4_NS_14SourceLocationE")
  //</editor-fold>
  @Override public void handleLockAcquiredBefore(StringRef Kind, StringRef L1Name, StringRef L2Name, 
                          SourceLocation Loc)/* override*/ {
    std.pairTypeType<SourceLocation, PartialDiagnostic> Warning = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Warning/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(/*Fwd*/Loc), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.warn_acquired_before)), /*NO_COPY*/Kind), /*NO_COPY*/L1Name), /*NO_COPY*/L2Name))
          ));
      Warnings.emplace_back(new std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes>($Move(std.move(Warning)), $Move($c$.track(getNotes())))); $c$.clean();
    } finally {
      if (Warning != null) { Warning.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleBeforeAfterCycle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1717,
   FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::handleBeforeAfterCycle", NM="_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter22handleBeforeAfterCycleEN4llvm9StringRefENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter22handleBeforeAfterCycleEN4llvm9StringRefENS_14SourceLocationE")
  //</editor-fold>
  @Override public void handleBeforeAfterCycle(StringRef L1Name, SourceLocation Loc)/* override*/ {
    std.pairTypeType<SourceLocation, PartialDiagnostic> Warning = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Warning/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(/*Fwd*/Loc), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.warn_acquired_before_after_cycle)), /*NO_COPY*/L1Name))
          ));
      Warnings.emplace_back(new std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes>($Move(std.move(Warning)), $Move($c$.track(getNotes())))); $c$.clean();
    } finally {
      if (Warning != null) { Warning.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::enterFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1723,
   FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::enterFunction", NM="_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter13enterFunctionEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter13enterFunctionEPKNS_12FunctionDeclE")
  //</editor-fold>
  @Override public void enterFunction(/*const*/ FunctionDecl /*P*/ FD)/* override*/ {
    CurrentFunction = FD;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::leaveFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1727,
   FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::leaveFunction", NM="_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter13leaveFunctionEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporter13leaveFunctionEPKNS_12FunctionDeclE")
  //</editor-fold>
  @Override public void leaveFunction(/*const*/ FunctionDecl /*P*/ FD)/* override*/ {
    CurrentFunction = null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::~ThreadSafetyReporter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1472,
   FQN="clang::threadSafety::(anonymous namespace)::ThreadSafetyReporter::~ThreadSafetyReporter", NM="_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12threadSafety12_GLOBAL__N_120ThreadSafetyReporterD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Warnings.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", Warnings=" + Warnings // NOI18N
              + ", FunLocation=" + FunLocation // NOI18N
              + ", FunEndLocation=" + FunEndLocation // NOI18N
              + ", CurrentFunction=" + "[FunctionDecl]" // NOI18N
              + ", Verbose=" + Verbose // NOI18N
              + super.toString(); // NOI18N
  }
}
