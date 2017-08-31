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

package org.clang.staticanalyzer.checkers.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.staticanalyzer.java.*;
import static org.clang.staticanalyzer.checkers.impl.MallocOverflowSecurityCheckerStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocOverflowSecurityChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 44,
 FQN="(anonymous namespace)::MallocOverflowSecurityChecker", NM="_ZN12_GLOBAL__N_129MallocOverflowSecurityCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZN12_GLOBAL__N_129MallocOverflowSecurityCheckerE")
//</editor-fold>
public class MallocOverflowSecurityChecker extends /*public*/ Checker/*T<ASTCodeBody> */
        implements org.clang.staticanalyzer.java.ASTCodeBodyChecker, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocOverflowSecurityChecker::checkASTCodeBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 293,
   FQN="(anonymous namespace)::MallocOverflowSecurityChecker::checkASTCodeBody", NM="_ZNK12_GLOBAL__N_129MallocOverflowSecurityChecker16checkASTCodeBodyEPKN5clang4DeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZNK12_GLOBAL__N_129MallocOverflowSecurityChecker16checkASTCodeBodyEPKN5clang4DeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterE")
  //</editor-fold>
  public void checkASTCodeBody(/*const*/ Decl /*P*/ D, 
                  final AnalysisManager /*&*/ mgr, 
                  final BugReporter /*&*/ BR) /*const*/ {
    SmallVector<MallocOverflowCheck> PossibleMallocOverflows = null;
    try {
      
      CFG /*P*/ cfg = mgr.getCFG(D);
      if (!(cfg != null)) {
        return;
      }
      
      // A list of variables referenced in possibly overflowing malloc operands.
      PossibleMallocOverflows/*J*/= new SmallVector<MallocOverflowCheck>(2, new MallocOverflowCheck());
      
      for (type$ptr<CFGBlock /*P*/ /*P*/> it = $tryClone(cfg.begin()), /*P*/ ei = $tryClone(cfg.end()); $noteq_ptr(it, ei); it.$preInc()) {
        CFGBlock /*P*/ block = it.$star();
        for (std.reverse_iterator<CFGElement> bi = block.begin(), be = block.end();
             $noteq_reverse_iterator$C(bi, be); bi.$preInc()) {
          {
            Optional<CFGStmt> CS = bi.$arrow().getAs(CFGStmt.class);
            if (CS.$bool()) {
              {
                /*const*/ CallExpr /*P*/ TheCall = dyn_cast_CallExpr(CS.$arrow().getStmt());
                if ((TheCall != null)) {
                  // Get the callee.
                  /*const*/ FunctionDecl /*P*/ FD = TheCall.getDirectCallee$Const();
                  if (!(FD != null)) {
                    continue;
                  }
                  
                  // Get the name of the callee. If it's a builtin, strip off the prefix.
                  IdentifierInfo /*P*/ FnInfo = FD.getIdentifier();
                  if (!(FnInfo != null)) {
                    continue;
                  }
                  if (FnInfo.isStr(/*KEEP_STR*/"malloc") || FnInfo.isStr(/*KEEP_STR*/"_MALLOC")) {
                    if (TheCall.getNumArgs() == 1) {
                      CheckMallocArgument(PossibleMallocOverflows, TheCall.getArg$Const(0), 
                          mgr.getASTContext());
                    }
                  }
                }
              }
            }
          }
        }
      }
      
      OutputPossibleOverflows(PossibleMallocOverflows, D, BR, mgr);
    } finally {
      if (PossibleMallocOverflows != null) { PossibleMallocOverflows.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocOverflowSecurityChecker::CheckMallocArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 65,
   FQN="(anonymous namespace)::MallocOverflowSecurityChecker::CheckMallocArgument", NM="_ZNK12_GLOBAL__N_129MallocOverflowSecurityChecker19CheckMallocArgumentERN4llvm15SmallVectorImplINS_19MallocOverflowCheckEEEPKN5clang4ExprERNS6_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZNK12_GLOBAL__N_129MallocOverflowSecurityChecker19CheckMallocArgumentERN4llvm15SmallVectorImplINS_19MallocOverflowCheckEEEPKN5clang4ExprERNS6_10ASTContextE")
  //</editor-fold>
  public void CheckMallocArgument(final SmallVectorImpl<MallocOverflowCheck> /*&*/ PossibleMallocOverflows, 
                     /*const*/ Expr /*P*/ TheArgument, 
                     final ASTContext /*&*/ Context) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      /* Look for a linear combination with a single variable, and at least
      one multiplication.
      Reject anything that applies to the variable: an explicit cast,
      conditional expression, an operation that could reduce the range
      of the result, or anything too complicated :-).  */
      /*const*/ Expr /*P*/ e = TheArgument;
      /*const*/ BinaryOperator /*P*/ mulop = null;
      APSInt maxVal/*J*/= new APSInt();
      
      for (;;) {
        maxVal.$assign($int2ulong(0));
        e = e.IgnoreParenImpCasts$Const();
        {
          /*const*/ BinaryOperator /*P*/ binop = dyn_cast_BinaryOperator(e);
          if ((binop != null)) {
            BinaryOperatorKind opc = binop.getOpcode();
            // TODO: ignore multiplications by 1, reject if multiplied by 0.
            if (mulop == null && opc == BinaryOperatorKind.BO_Mul) {
              mulop = binop;
            }
            if (opc != BinaryOperatorKind.BO_Mul && opc != BinaryOperatorKind.BO_Add && opc != BinaryOperatorKind.BO_Sub && opc != BinaryOperatorKind.BO_Shl) {
              return;
            }
            
            /*const*/ Expr /*P*/ lhs = binop.getLHS();
            /*const*/ Expr /*P*/ rhs = binop.getRHS();
            if (rhs.isEvaluatable(Context)) {
              e = lhs;
              maxVal.$assignMove(rhs.EvaluateKnownConstInt(Context));
              if (EvaluatesToZero(maxVal, opc)) {
                return;
              }
            } else if ((opc == BinaryOperatorKind.BO_Add || opc == BinaryOperatorKind.BO_Mul)
               && lhs.isEvaluatable(Context)) {
              maxVal.$assignMove(lhs.EvaluateKnownConstInt(Context));
              if (EvaluatesToZero(maxVal, opc)) {
                return;
              }
              e = rhs;
            } else {
              return;
            }
          } else if (isa_DeclRefExpr(e) || isa_MemberExpr(e)) {
            break;
          } else {
            return;
          }
        }
      }
      if (mulop == null) {
        return;
      }
      
      //  We've found the right structure of malloc argument, now save
      // the data so when the body of the function is completely available
      // we can check for comparisons.
      
      // TODO: Could push this into the innermost scope where 'e' is
      // defined, rather than the whole function.
      PossibleMallocOverflows.push_back_T$RR($c$.track(new MallocOverflowCheck(mulop, e, new APSInt(maxVal)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  
  // OutputPossibleOverflows - We've found a possible overflow earlier,
  // now check whether Body might contain a comparison which might be
  // preventing the overflow.
  // This doesn't do flow analysis, range analysis, or points-to analysis; it's
  // just a dumb "is there a comparison" scan.  The aim here is to
  // detect the most blatent cases of overflow and educate the
  // programmer.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocOverflowSecurityChecker::OutputPossibleOverflows">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 267,
   FQN="(anonymous namespace)::MallocOverflowSecurityChecker::OutputPossibleOverflows", NM="_ZNK12_GLOBAL__N_129MallocOverflowSecurityChecker23OutputPossibleOverflowsERN4llvm15SmallVectorImplINS_19MallocOverflowCheckEEEPKN5clang4DeclERNS6_4ento11BugReporterERNSA_15AnalysisManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZNK12_GLOBAL__N_129MallocOverflowSecurityChecker23OutputPossibleOverflowsERN4llvm15SmallVectorImplINS_19MallocOverflowCheckEEEPKN5clang4DeclERNS6_4ento11BugReporterERNSA_15AnalysisManagerE")
  //</editor-fold>
  public void OutputPossibleOverflows(final SmallVectorImpl<MallocOverflowCheck> /*&*/ PossibleMallocOverflows, 
                         /*const*/ Decl /*P*/ D, final BugReporter /*&*/ BR, final AnalysisManager /*&*/ mgr) /*const*/ {
    // By far the most common case: nothing to check.
    if (PossibleMallocOverflows.empty()) {
      return;
    }
    
    // Delete any possible overflows which have a comparison.
    CheckOverflowOps c/*J*/= new CheckOverflowOps(PossibleMallocOverflows, BR.getContext());
    c.Visit(mgr.getAnalysisDeclContext(D).getBody());
    
    // Output warnings for all overflows that are left.
    for (type$ptr<MallocOverflowCheck /*P*/ > i = $tryClone(PossibleMallocOverflows.begin()), 
        /*P*/ e = $tryClone(PossibleMallocOverflows.end());
         $noteq_ptr(i, e);
         i.$preInc()) {
      BR.EmitBasicReport(D, this, new StringRef(/*KEEP_STR*/"malloc() size overflow"), new StringRef(categories.UnixAPI), 
          new StringRef(/*KEEP_STR*/"the computation of the size of the memory allocation may overflow"), 
          PathDiagnosticLocation.createOperatorLoc(i./*->*/$star().mulop, 
              BR.getSourceManager()), 
          new ArrayRef<SourceRange>(i./*->*/$star().mulop.getSourceRange(), false));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocOverflowSecurityChecker::~MallocOverflowSecurityChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 44,
   FQN="(anonymous namespace)::MallocOverflowSecurityChecker::~MallocOverflowSecurityChecker", NM="_ZN12_GLOBAL__N_129MallocOverflowSecurityCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZN12_GLOBAL__N_129MallocOverflowSecurityCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocOverflowSecurityChecker::MallocOverflowSecurityChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 44,
   FQN="(anonymous namespace)::MallocOverflowSecurityChecker::MallocOverflowSecurityChecker", NM="_ZN12_GLOBAL__N_129MallocOverflowSecurityCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZN12_GLOBAL__N_129MallocOverflowSecurityCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ MallocOverflowSecurityChecker() {
    // : Checker<ASTCodeBody>() 
    //START JInit
    super();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new ASTCodeBody()
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
