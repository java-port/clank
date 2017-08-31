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
import static org.clank.support.Native.*;
import org.clang.analysis.CFGCallback;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


/// \brief Warn on logical operator errors in CFGBuilder
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LogicalErrorHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 121,
 FQN="(anonymous namespace)::LogicalErrorHandler", NM="_ZN12_GLOBAL__N_119LogicalErrorHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_119LogicalErrorHandlerE")
//</editor-fold>
public class LogicalErrorHandler extends /*public*/ CFGCallback implements Destructors.ClassWithDestructor {
  private final Sema /*&*/ S;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LogicalErrorHandler::LogicalErrorHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 125,
   FQN="(anonymous namespace)::LogicalErrorHandler::LogicalErrorHandler", NM="_ZN12_GLOBAL__N_119LogicalErrorHandlerC1ERN5clang4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_119LogicalErrorHandlerC1ERN5clang4SemaE")
  //</editor-fold>
  public LogicalErrorHandler(final Sema /*&*/ S) {
    // : CFGCallback(), S(S) 
    //START JInit
    super();
    this./*&*/S=/*&*/S;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LogicalErrorHandler::HasMacroID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 127,
   FQN="(anonymous namespace)::LogicalErrorHandler::HasMacroID", NM="_ZN12_GLOBAL__N_119LogicalErrorHandler10HasMacroIDEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_119LogicalErrorHandler10HasMacroIDEPKN5clang4ExprE")
  //</editor-fold>
  public static boolean HasMacroID(/*const*/ Expr /*P*/ E) {
    if (E.getExprLoc().isMacroID()) {
      return true;
    }
    
    // Recurse to children.
    for (/*const*/ Stmt /*P*/ SubStmt : E.children$Const())  {
      {
        /*const*/ Expr /*P*/ SubExpr = dyn_cast_or_null_Expr(SubStmt);
        if ((SubExpr != null)) {
          if (HasMacroID(SubExpr)) {
            return true;
          }
        }
      }
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LogicalErrorHandler::compareAlwaysTrue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 140,
   FQN="(anonymous namespace)::LogicalErrorHandler::compareAlwaysTrue", NM="_ZN12_GLOBAL__N_119LogicalErrorHandler17compareAlwaysTrueEPKN5clang14BinaryOperatorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_119LogicalErrorHandler17compareAlwaysTrueEPKN5clang14BinaryOperatorEb")
  //</editor-fold>
  @Override public void compareAlwaysTrue(/*const*/ BinaryOperator /*P*/ B, boolean isAlwaysTrue)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (HasMacroID(B)) {
        return;
      }
      
      SourceRange DiagRange = B.getSourceRange();
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(B.getExprLoc(), diag.warn_tautological_overlap_comparison)), 
              DiagRange), isAlwaysTrue));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LogicalErrorHandler::compareBitwiseEquality">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 149,
   FQN="(anonymous namespace)::LogicalErrorHandler::compareBitwiseEquality", NM="_ZN12_GLOBAL__N_119LogicalErrorHandler22compareBitwiseEqualityEPKN5clang14BinaryOperatorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_119LogicalErrorHandler22compareBitwiseEqualityEPKN5clang14BinaryOperatorEb")
  //</editor-fold>
  @Override public void compareBitwiseEquality(/*const*/ BinaryOperator /*P*/ B, 
                        boolean isAlwaysTrue)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (HasMacroID(B)) {
        return;
      }
      
      SourceRange DiagRange = B.getSourceRange();
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(B.getExprLoc(), diag.warn_comparison_bitwise_always)), 
              DiagRange), isAlwaysTrue));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LogicalErrorHandler::~LogicalErrorHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 121,
   FQN="(anonymous namespace)::LogicalErrorHandler::~LogicalErrorHandler", NM="_ZN12_GLOBAL__N_119LogicalErrorHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_119LogicalErrorHandlerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + super.toString(); // NOI18N
  }
}
