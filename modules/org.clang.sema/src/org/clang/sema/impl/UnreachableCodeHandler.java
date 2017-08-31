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

package org.clang.sema.impl;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.sema.*;
import org.clang.analysis.analyses.reachable_code.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnreachableCodeHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 62,
 FQN="(anonymous namespace)::UnreachableCodeHandler", NM="_ZN12_GLOBAL__N_122UnreachableCodeHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_122UnreachableCodeHandlerE")
//</editor-fold>
public class UnreachableCodeHandler extends /*public*/ Callback implements Destructors.ClassWithDestructor {
  private final Sema /*&*/ S;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnreachableCodeHandler::UnreachableCodeHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 65,
   FQN="(anonymous namespace)::UnreachableCodeHandler::UnreachableCodeHandler", NM="_ZN12_GLOBAL__N_122UnreachableCodeHandlerC1ERN5clang4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_122UnreachableCodeHandlerC1ERN5clang4SemaE")
  //</editor-fold>
  public UnreachableCodeHandler(final Sema /*&*/ s) {
    // : Callback(), S(s) 
    //START JInit
    super();
    this./*&*/S=/*&*/s;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnreachableCodeHandler::HandleUnreachable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 67,
   FQN="(anonymous namespace)::UnreachableCodeHandler::HandleUnreachable", NM="_ZN12_GLOBAL__N_122UnreachableCodeHandler17HandleUnreachableEN5clang14reachable_code15UnreachableKindENS1_14SourceLocationENS1_11SourceRangeES5_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_122UnreachableCodeHandler17HandleUnreachableEN5clang14reachable_code15UnreachableKindENS1_14SourceLocationENS1_11SourceRangeES5_S5_")
  //</editor-fold>
  @Override public void HandleUnreachable(UnreachableKind UK, 
                   SourceLocation L, 
                   SourceRange SilenceableCondVal, 
                   SourceRange R1, 
                   SourceRange R2)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*uint*/int _diag = diag.warn_unreachable;
      switch (UK) {
       case UK_Break:
        _diag = diag.warn_unreachable_break;
        break;
       case UK_Return:
        _diag = diag.warn_unreachable_return;
        break;
       case UK_Loop_Increment:
        _diag = diag.warn_unreachable_loop_increment;
        break;
       case UK_Other:
        break;
      }
      
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(L), _diag)), R1), R2));
      
      SourceLocation Open = SilenceableCondVal.getBegin();
      if (Open.isValid()) {
        SourceLocation Close = SilenceableCondVal.getEnd();
        Close.$assignMove(S.getLocForEndOfToken(new SourceLocation(Close)));
        if (Close.isValid()) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Open), diag.note_unreachable_silence)), 
                  FixItHint.CreateInsertion(/*NO_COPY*/Open, new StringRef(/*KEEP_STR*/"/* DISABLES CODE */ ("))), 
              FixItHint.CreateInsertion(/*NO_COPY*/Close, new StringRef(/*KEEP_STR*/$RPAREN))));
        }
      }
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnreachableCodeHandler::~UnreachableCodeHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 62,
   FQN="(anonymous namespace)::UnreachableCodeHandler::~UnreachableCodeHandler", NM="_ZN12_GLOBAL__N_122UnreachableCodeHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_122UnreachableCodeHandlerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + super.toString(); // NOI18N
  }
}
