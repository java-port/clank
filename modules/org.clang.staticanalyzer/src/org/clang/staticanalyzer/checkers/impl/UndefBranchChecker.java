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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UndefBranchChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefBranchChecker.cpp", line = 27,
 FQN="(anonymous namespace)::UndefBranchChecker", NM="_ZN12_GLOBAL__N_118UndefBranchCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefBranchChecker.cpp -nm=_ZN12_GLOBAL__N_118UndefBranchCheckerE")
//</editor-fold>
public class UndefBranchChecker extends /*public*/ Checker/*T<BranchCondition> */
        implements org.clang.staticanalyzer.java.BranchConditionChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BuiltinBug> BT;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UndefBranchChecker::FindUndefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefBranchChecker.cpp", line = 30,
   FQN="(anonymous namespace)::UndefBranchChecker::FindUndefExpr", NM="_ZN12_GLOBAL__N_118UndefBranchChecker13FindUndefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefBranchChecker.cpp -nm=_ZN12_GLOBAL__N_118UndefBranchChecker13FindUndefExprE")
  //</editor-fold>
  private static class/*struct*/ FindUndefExpr implements Destructors.ClassWithDestructor {
    public IntrusiveRefCntPtr</*const*/ ProgramState> St;
    public /*const*/ LocationContext /*P*/ LCtx;
    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UndefBranchChecker::FindUndefExpr::FindUndefExpr">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefBranchChecker.cpp", line = 34,
     FQN="(anonymous namespace)::UndefBranchChecker::FindUndefExpr::FindUndefExpr", NM="_ZN12_GLOBAL__N_118UndefBranchChecker13FindUndefExprC1EN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_15LocationContextE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefBranchChecker.cpp -nm=_ZN12_GLOBAL__N_118UndefBranchChecker13FindUndefExprC1EN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_15LocationContextE")
    //</editor-fold>
    public FindUndefExpr(IntrusiveRefCntPtr</*const*/ ProgramState> S, /*const*/ LocationContext /*P*/ L) {
      // : St(std::move(S)), LCtx(L) 
      //START JInit
      this.St = new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, std.move(S));
      this.LCtx = L;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UndefBranchChecker::FindUndefExpr::FindExpr">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefBranchChecker.cpp", line = 37,
     FQN="(anonymous namespace)::UndefBranchChecker::FindUndefExpr::FindExpr", NM="_ZN12_GLOBAL__N_118UndefBranchChecker13FindUndefExpr8FindExprEPKN5clang4ExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefBranchChecker.cpp -nm=_ZN12_GLOBAL__N_118UndefBranchChecker13FindUndefExpr8FindExprEPKN5clang4ExprE")
    //</editor-fold>
    public /*const*/ Expr /*P*/ FindExpr(/*const*/ Expr /*P*/ Ex) {
      if (!MatchesCriteria(Ex)) {
        return null;
      }
      
      for (/*const*/ Stmt /*P*/ SubStmt : Ex.children$Const())  {
        {
          /*const*/ Expr /*P*/ ExI = dyn_cast_or_null_Expr(SubStmt);
          if ((ExI != null)) {
            {
              /*const*/ Expr /*P*/ E2 = FindExpr(ExI);
              if ((E2 != null)) {
                return E2;
              }
            }
          }
        }
      }
      
      return Ex;
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UndefBranchChecker::FindUndefExpr::MatchesCriteria">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefBranchChecker.cpp", line = 49,
     FQN="(anonymous namespace)::UndefBranchChecker::FindUndefExpr::MatchesCriteria", NM="_ZN12_GLOBAL__N_118UndefBranchChecker13FindUndefExpr15MatchesCriteriaEPKN5clang4ExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefBranchChecker.cpp -nm=_ZN12_GLOBAL__N_118UndefBranchChecker13FindUndefExpr15MatchesCriteriaEPKN5clang4ExprE")
    //</editor-fold>
    public boolean MatchesCriteria(/*const*/ Expr /*P*/ Ex) {
      return St.$arrow().getSVal(Ex, LCtx).isUndef$SVal();
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UndefBranchChecker::FindUndefExpr::~FindUndefExpr">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefBranchChecker.cpp", line = 30,
     FQN="(anonymous namespace)::UndefBranchChecker::FindUndefExpr::~FindUndefExpr", NM="_ZN12_GLOBAL__N_118UndefBranchChecker13FindUndefExprD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefBranchChecker.cpp -nm=_ZN12_GLOBAL__N_118UndefBranchChecker13FindUndefExprD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      St.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "St=" + St // NOI18N
                + ", LCtx=" + "[LocationContext]"; // NOI18N
    }
  };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UndefBranchChecker::checkBranchCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefBranchChecker.cpp", line = 60,
   FQN="(anonymous namespace)::UndefBranchChecker::checkBranchCondition", NM="_ZNK12_GLOBAL__N_118UndefBranchChecker20checkBranchConditionEPKN5clang4StmtERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefBranchChecker.cpp -nm=_ZNK12_GLOBAL__N_118UndefBranchChecker20checkBranchConditionEPKN5clang4StmtERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkBranchCondition(/*const*/ Stmt /*P*/ Condition, 
                      final CheckerContext /*&*/ Ctx) /*const*/ {
    SVal X = Ctx.getState().$arrow().getSVal(Condition, Ctx.getLocationContext());
    if (X.isUndef$SVal()) {
      // Generate a sink node, which implicitly marks both outgoing branches as
      // infeasible.
      ExplodedNode /*P*/ N = Ctx.generateErrorNode();
      if ((N != null)) {
        IntrusiveRefCntPtr</*const*/ ProgramState> St = null;
        FindUndefExpr FindIt = null;
        unique_ptr<BugReport> R = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if (!BT.$bool()) {
            BT.reset(new BuiltinBug(this, $("Branch condition evaluates to a garbage value")));
          }
          
          // What's going on here: we want to highlight the subexpression of the
          // condition that is the most likely source of the "uninitialized
          // branch condition."  We do a recursive walk of the condition's
          // subexpressions and roughly look for the most nested subexpression
          // that binds to Undefined.  We then highlight that expression's range.
          
          // Get the predecessor node and check if is a PostStmt with the Stmt
          // being the terminator condition.  We want to inspect the state
          // of that node instead because it will contain main information about
          // the subexpressions.
          
          // Note: any predecessor will do.  They should have identical state,
          // since all the BlockEdge did was act as an error sink since the value
          // had to already be undefined.
          assert (!N.pred_empty());
          /*const*/ Expr /*P*/ Ex = cast_Expr(Condition);
          ExplodedNode /*P*/ PrevN = N.pred_begin().$star();
          ProgramPoint P = PrevN.getLocation();
          St = new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState());
          {
            
            Optional<org.clang.analysis.PostStmt> PS = P.getAs(org.clang.analysis.PostStmt.class);
            if (PS.$bool()) {
              if (PS.$arrow().getStmt() == Ex) {
                $c$.clean(St.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(PrevN.getState()))));
              }
            }
          }
          
          FindIt/*J*/= $c$.clean(new FindUndefExpr($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), Ctx.getLocationContext()));
          Ex = FindIt.FindExpr(Ex);
          
          // Emit the bug report.
          R = llvm.make_unique(new BugReport(BT.$star(), BT.$arrow().getDescription(), N));
          NsBugreporter.trackNullOrUndefValue(N, Ex, R.$star());
          R.$arrow().addRange(Ex.getSourceRange());
          
          Ctx.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
        } finally {
          if (R != null) { R.$destroy(); }
          if (FindIt != null) { FindIt.$destroy(); }
          if (St != null) { St.$destroy(); }
          $c$.$destroy();
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UndefBranchChecker::~UndefBranchChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefBranchChecker.cpp", line = 27,
   FQN="(anonymous namespace)::UndefBranchChecker::~UndefBranchChecker", NM="_ZN12_GLOBAL__N_118UndefBranchCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefBranchChecker.cpp -nm=_ZN12_GLOBAL__N_118UndefBranchCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UndefBranchChecker::UndefBranchChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefBranchChecker.cpp", line = 27,
   FQN="(anonymous namespace)::UndefBranchChecker::UndefBranchChecker", NM="_ZN12_GLOBAL__N_118UndefBranchCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefBranchChecker.cpp -nm=_ZN12_GLOBAL__N_118UndefBranchCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ UndefBranchChecker() {
    // : Checker<BranchCondition>(), BT() 
    //START JInit
    super();
    this.BT = new std.unique_ptr<BuiltinBug>();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new BranchCondition()
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT=" + BT // NOI18N
              + super.toString(); // NOI18N
  }
}
