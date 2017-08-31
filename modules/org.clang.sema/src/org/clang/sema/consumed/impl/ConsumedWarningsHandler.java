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

package org.clang.sema.consumed.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.sema.*;
import org.clang.sema.impl.*;
import org.clang.analysis.analyses.consumed.ConsumedWarningsHandlerBase;
import org.clang.basic.java.OptionalNotes;
import org.clang.basic.java.PartialDiagList;

//<editor-fold defaultstate="collapsed" desc="clang::consumed::(anonymous namespace)::ConsumedWarningsHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1742,
 FQN="clang::consumed::(anonymous namespace)::ConsumedWarningsHandler", NM="_ZN5clang8consumed12_GLOBAL__N_123ConsumedWarningsHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed12_GLOBAL__N_123ConsumedWarningsHandlerE")
//</editor-fold>
public class ConsumedWarningsHandler extends /*public*/ ConsumedWarningsHandlerBase implements Destructors.ClassWithDestructor {
  
  private final Sema /*&*/ S;
  private PartialDiagList Warnings;
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::(anonymous namespace)::ConsumedWarningsHandler::ConsumedWarningsHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1749,
   FQN="clang::consumed::(anonymous namespace)::ConsumedWarningsHandler::ConsumedWarningsHandler", NM="_ZN5clang8consumed12_GLOBAL__N_123ConsumedWarningsHandlerC1ERNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed12_GLOBAL__N_123ConsumedWarningsHandlerC1ERNS_4SemaE")
  //</editor-fold>
  public ConsumedWarningsHandler(final Sema /*&*/ S) {
    // : ConsumedWarningsHandlerBase(), S(S), Warnings() 
    //START JInit
    super();
    this./*&*/S=/*&*/S;
    this.Warnings = new PartialDiagList();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::(anonymous namespace)::ConsumedWarningsHandler::emitDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1751,
   FQN="clang::consumed::(anonymous namespace)::ConsumedWarningsHandler::emitDiagnostics", NM="_ZN5clang8consumed12_GLOBAL__N_123ConsumedWarningsHandler15emitDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed12_GLOBAL__N_123ConsumedWarningsHandler15emitDiagnosticsEv")
  //</editor-fold>
  @Override public void emitDiagnostics()/* override*/ {
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

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::(anonymous namespace)::ConsumedWarningsHandler::warnLoopStateMismatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1760,
   FQN="clang::consumed::(anonymous namespace)::ConsumedWarningsHandler::warnLoopStateMismatch", NM="_ZN5clang8consumed12_GLOBAL__N_123ConsumedWarningsHandler21warnLoopStateMismatchENS_14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed12_GLOBAL__N_123ConsumedWarningsHandler21warnLoopStateMismatchENS_14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  @Override public void warnLoopStateMismatch(SourceLocation Loc, 
                       StringRef VariableName)/* override*/ {
    std.pairTypeType<SourceLocation, PartialDiagnostic> Warning = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Warning/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(/*Fwd*/Loc), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.warn_loop_state_mismatch)), 
    /*NO_COPY*/VariableName))));
      
      Warnings.emplace_back(new std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes>($Move(std.move(Warning)), $Move($c$.track(new OptionalNotes(1))))); $c$.clean();
    } finally {
      if (Warning != null) { Warning.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::(anonymous namespace)::ConsumedWarningsHandler::warnParamReturnTypestateMismatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1768,
   FQN="clang::consumed::(anonymous namespace)::ConsumedWarningsHandler::warnParamReturnTypestateMismatch", NM="_ZN5clang8consumed12_GLOBAL__N_123ConsumedWarningsHandler32warnParamReturnTypestateMismatchENS_14SourceLocationEN4llvm9StringRefES5_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed12_GLOBAL__N_123ConsumedWarningsHandler32warnParamReturnTypestateMismatchENS_14SourceLocationEN4llvm9StringRefES5_S5_")
  //</editor-fold>
  @Override public void warnParamReturnTypestateMismatch(SourceLocation Loc, 
                                  StringRef VariableName, 
                                  StringRef ExpectedState, 
                                  StringRef ObservedState)/* override*/ {
    std.pairTypeType<SourceLocation, PartialDiagnostic> Warning = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      Warning/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(/*Fwd*/Loc), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.warn_param_return_typestate_mismatch)), /*NO_COPY*/VariableName), 
        /*NO_COPY*/ExpectedState), /*NO_COPY*/ObservedState))));
      
      Warnings.emplace_back(new std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes>($Move(std.move(Warning)), $Move($c$.track(new OptionalNotes(1))))); $c$.clean();
    } finally {
      if (Warning != null) { Warning.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::(anonymous namespace)::ConsumedWarningsHandler::warnParamTypestateMismatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1780,
   FQN="clang::consumed::(anonymous namespace)::ConsumedWarningsHandler::warnParamTypestateMismatch", NM="_ZN5clang8consumed12_GLOBAL__N_123ConsumedWarningsHandler26warnParamTypestateMismatchENS_14SourceLocationEN4llvm9StringRefES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed12_GLOBAL__N_123ConsumedWarningsHandler26warnParamTypestateMismatchENS_14SourceLocationEN4llvm9StringRefES5_")
  //</editor-fold>
  @Override public void warnParamTypestateMismatch(SourceLocation Loc, StringRef ExpectedState, 
                            StringRef ObservedState)/* override*/ {
    std.pairTypeType<SourceLocation, PartialDiagnostic> Warning = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      Warning/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(/*Fwd*/Loc), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.warn_param_typestate_mismatch)), /*NO_COPY*/ExpectedState), /*NO_COPY*/ObservedState))));
      
      Warnings.emplace_back(new std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes>($Move(std.move(Warning)), $Move($c$.track(new OptionalNotes(1))))); $c$.clean();
    } finally {
      if (Warning != null) { Warning.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::(anonymous namespace)::ConsumedWarningsHandler::warnReturnTypestateForUnconsumableType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1789,
   FQN="clang::consumed::(anonymous namespace)::ConsumedWarningsHandler::warnReturnTypestateForUnconsumableType", NM="_ZN5clang8consumed12_GLOBAL__N_123ConsumedWarningsHandler38warnReturnTypestateForUnconsumableTypeENS_14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed12_GLOBAL__N_123ConsumedWarningsHandler38warnReturnTypestateForUnconsumableTypeENS_14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  @Override public void warnReturnTypestateForUnconsumableType(SourceLocation Loc, 
                                        StringRef TypeName)/* override*/ {
    std.pairTypeType<SourceLocation, PartialDiagnostic> Warning = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Warning/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(/*Fwd*/Loc), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.warn_return_typestate_for_unconsumable_type)), /*NO_COPY*/TypeName))));
      
      Warnings.emplace_back(new std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes>($Move(std.move(Warning)), $Move($c$.track(new OptionalNotes(1))))); $c$.clean();
    } finally {
      if (Warning != null) { Warning.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::(anonymous namespace)::ConsumedWarningsHandler::warnReturnTypestateMismatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1797,
   FQN="clang::consumed::(anonymous namespace)::ConsumedWarningsHandler::warnReturnTypestateMismatch", NM="_ZN5clang8consumed12_GLOBAL__N_123ConsumedWarningsHandler27warnReturnTypestateMismatchENS_14SourceLocationEN4llvm9StringRefES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed12_GLOBAL__N_123ConsumedWarningsHandler27warnReturnTypestateMismatchENS_14SourceLocationEN4llvm9StringRefES5_")
  //</editor-fold>
  @Override public void warnReturnTypestateMismatch(SourceLocation Loc, StringRef ExpectedState, 
                             StringRef ObservedState)/* override*/ {
    std.pairTypeType<SourceLocation, PartialDiagnostic> Warning = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      Warning/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(/*Fwd*/Loc), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.warn_return_typestate_mismatch)), /*NO_COPY*/ExpectedState), /*NO_COPY*/ObservedState))));
      
      Warnings.emplace_back(new std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes>($Move(std.move(Warning)), $Move($c$.track(new OptionalNotes(1))))); $c$.clean();
    } finally {
      if (Warning != null) { Warning.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::(anonymous namespace)::ConsumedWarningsHandler::warnUseOfTempInInvalidState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1806,
   FQN="clang::consumed::(anonymous namespace)::ConsumedWarningsHandler::warnUseOfTempInInvalidState", NM="_ZN5clang8consumed12_GLOBAL__N_123ConsumedWarningsHandler27warnUseOfTempInInvalidStateEN4llvm9StringRefES4_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed12_GLOBAL__N_123ConsumedWarningsHandler27warnUseOfTempInInvalidStateEN4llvm9StringRefES4_NS_14SourceLocationE")
  //</editor-fold>
  @Override public void warnUseOfTempInInvalidState(StringRef MethodName, StringRef State, 
                             SourceLocation Loc)/* override*/ {
    std.pairTypeType<SourceLocation, PartialDiagnostic> Warning = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      Warning/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(/*Fwd*/Loc), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.warn_use_of_temp_in_invalid_state)), /*NO_COPY*/MethodName), /*NO_COPY*/State))));
      
      Warnings.emplace_back(new std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes>($Move(std.move(Warning)), $Move($c$.track(new OptionalNotes(1))))); $c$.clean();
    } finally {
      if (Warning != null) { Warning.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::(anonymous namespace)::ConsumedWarningsHandler::warnUseInInvalidState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1815,
   FQN="clang::consumed::(anonymous namespace)::ConsumedWarningsHandler::warnUseInInvalidState", NM="_ZN5clang8consumed12_GLOBAL__N_123ConsumedWarningsHandler21warnUseInInvalidStateEN4llvm9StringRefES4_S4_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed12_GLOBAL__N_123ConsumedWarningsHandler21warnUseInInvalidStateEN4llvm9StringRefES4_S4_NS_14SourceLocationE")
  //</editor-fold>
  @Override public void warnUseInInvalidState(StringRef MethodName, StringRef VariableName, 
                       StringRef State, SourceLocation Loc)/* override*/ {
    std.pairTypeType<SourceLocation, PartialDiagnostic> Warning = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      Warning/*J*/= $c$.clean(new std.pairTypeType<SourceLocation, PartialDiagnostic>(JD$T$RR_T1$C$R.INSTANCE, new SourceLocation(/*Fwd*/Loc), new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.warn_use_in_invalid_state)), 
            /*NO_COPY*/MethodName), /*NO_COPY*/VariableName), /*NO_COPY*/State))));
      
      Warnings.emplace_back(new std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes>($Move(std.move(Warning)), $Move($c$.track(new OptionalNotes(1))))); $c$.clean();
    } finally {
      if (Warning != null) { Warning.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::(anonymous namespace)::ConsumedWarningsHandler::~ConsumedWarningsHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1742,
   FQN="clang::consumed::(anonymous namespace)::ConsumedWarningsHandler::~ConsumedWarningsHandler", NM="_ZN5clang8consumed12_GLOBAL__N_123ConsumedWarningsHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed12_GLOBAL__N_123ConsumedWarningsHandlerD0Ev")
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
              + super.toString(); // NOI18N
  }
}
