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
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TestAfterDivZeroChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 79,
 FQN="(anonymous namespace)::TestAfterDivZeroChecker", NM="_ZN12_GLOBAL__N_123TestAfterDivZeroCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZN12_GLOBAL__N_123TestAfterDivZeroCheckerE")
//</editor-fold>
public class TestAfterDivZeroChecker extends /*public*/ Checker/*<PreStmt<BinaryOperator>, BranchCondition, EndFunction>*/ 
        implements org.clang.staticanalyzer.java.PreStmtChecker, org.clang.staticanalyzer.java.EndFunctionChecker, org.clang.staticanalyzer.java.BranchConditionChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BuiltinBug> DivZeroBug;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TestAfterDivZeroChecker::reportBug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 169,
   FQN="(anonymous namespace)::TestAfterDivZeroChecker::reportBug", NM="_ZNK12_GLOBAL__N_123TestAfterDivZeroChecker9reportBugEN5clang4ento4SValERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZNK12_GLOBAL__N_123TestAfterDivZeroChecker9reportBugEN5clang4ento4SValERNS2_14CheckerContextE")
  //</editor-fold>
  private void reportBug(SVal Val, final CheckerContext /*&*/ C) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      {
        ExplodedNode /*P*/ N = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState()))));
        if ((N != null)) {
          unique_ptr<BugReport> R = null;
          try {
            if (!DivZeroBug.$bool()) {
              DivZeroBug.reset(new BuiltinBug(this, $("Division by zero")));
            }
            
            R = llvm.make_unique(new BugReport(DivZeroBug.$star(), $("Value being compared against zero has already been used for division"), 
                N));
            
            R.$arrow().addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new DivisionBRVisitor(Val.getAsSymbol(), 
                        C.getStackFrame())))))); $c$.clean();
            C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
          } finally {
            if (R != null) { R.$destroy(); }
          }
        }
      }
    } finally {
      $c$.$destroy();
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TestAfterDivZeroChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 203,
   FQN="(anonymous namespace)::TestAfterDivZeroChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_123TestAfterDivZeroChecker12checkPreStmtEPKN5clang14BinaryOperatorERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZNK12_GLOBAL__N_123TestAfterDivZeroChecker12checkPreStmtEPKN5clang14BinaryOperatorERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ BinaryOperator /*P*/ B, 
              final CheckerContext /*&*/ C) /*const*/ {
    BinaryOperatorKind Op = B.getOpcode();
    if (Op == BinaryOperatorKind.BO_Div || Op == BinaryOperatorKind.BO_Rem || Op == BinaryOperatorKind.BO_DivAssign
       || Op == BinaryOperatorKind.BO_RemAssign) {
      SVal S = C.getSVal(B.getRHS());
      if (!isZero(new SVal(S), C)) {
        setDivZeroMap(new SVal(S), C);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TestAfterDivZeroChecker::checkBranchCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 215,
   FQN="(anonymous namespace)::TestAfterDivZeroChecker::checkBranchCondition", NM="_ZNK12_GLOBAL__N_123TestAfterDivZeroChecker20checkBranchConditionEPKN5clang4StmtERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZNK12_GLOBAL__N_123TestAfterDivZeroChecker20checkBranchConditionEPKN5clang4StmtERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkBranchCondition(/*const*/ Stmt /*P*/ Condition, 
                      final CheckerContext /*&*/ C) /*const*/ {
    {
      /*const*/ BinaryOperator /*P*/ B = dyn_cast_BinaryOperator(Condition);
      if ((B != null)) {
        if (B.isComparisonOp()) {
          /*const*/ IntegerLiteral /*P*/ IntLiteral = dyn_cast_IntegerLiteral(B.getRHS());
          boolean LRHS = true;
          if (!(IntLiteral != null)) {
            IntLiteral = dyn_cast_IntegerLiteral(B.getLHS());
            LRHS = false;
          }
          if (!(IntLiteral != null) || IntLiteral.getValue().$noteq($int2ulong(0))) {
            return;
          }
          
          SVal Val = C.getSVal(LRHS ? B.getLHS() : B.getRHS());
          if (hasDivZeroMap(new SVal(Val), C)) {
            reportBug(new SVal(Val), C);
          }
        }
      } else {
        /*const*/ UnaryOperator /*P*/ U = dyn_cast_UnaryOperator(Condition);
        if ((U != null)) {
          if (U.getOpcode() == UnaryOperatorKind.UO_LNot) {
            SVal Val/*J*/= new SVal();
            {
              /*const*/ ImplicitCastExpr /*P*/ I = dyn_cast_ImplicitCastExpr(U.getSubExpr());
              if ((I != null)) {
                Val.$assignMove(C.getSVal(I.getSubExpr$Const()));
              }
            }
            if (hasDivZeroMap(new SVal(Val), C)) {
              reportBug(new SVal(Val), C);
            } else {
              Val.$assignMove(C.getSVal(U.getSubExpr()));
              if (hasDivZeroMap(new SVal(Val), C)) {
                reportBug(new SVal(Val), C);
              }
            }
          }
        } else {
          /*const*/ ImplicitCastExpr /*P*/ IE = dyn_cast_ImplicitCastExpr(Condition);
          if ((IE != null)) {
            SVal Val = C.getSVal(IE.getSubExpr$Const());
            if (hasDivZeroMap(new SVal(Val), C)) {
              reportBug(new SVal(Val), C);
            } else {
              SVal Val$1 = C.getSVal(Condition);
              if (hasDivZeroMap(new SVal(Val$1), C)) {
                reportBug(new SVal(Val$1), C);
              }
            }
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TestAfterDivZeroChecker::checkEndFunction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 185,
   FQN="(anonymous namespace)::TestAfterDivZeroChecker::checkEndFunction", NM="_ZNK12_GLOBAL__N_123TestAfterDivZeroChecker16checkEndFunctionERN5clang4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZNK12_GLOBAL__N_123TestAfterDivZeroChecker16checkEndFunctionERN5clang4ento14CheckerContextE")
  //</editor-fold>
  public void checkEndFunction(final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    ImmutableSet<ZeroState> DivZeroes = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      
      DivZeroes = State.$arrow().get(ProgramStateTraitDivZeroMap.$Instance);
      if (DivZeroes.isEmpty()) {
        return;
      }
      
      final ImmutableSet.Factory<ZeroState> /*&*/ F = State.$arrow().get_context(ProgramStateTraitDivZeroMap.$Instance);
      for (ImutAVLValueIteratorTypeBoolType<ZeroState> I = DivZeroes.begin(), 
          E = DivZeroes.end();
           I.$noteq(E); I.$preInc()) {
        ZeroState ZS = new ZeroState(I.$star());
        if (ZS.getStackFrameContext() == C.getStackFrame()) {
          $c$.clean(DivZeroes.$assign($c$.track(F.remove($c$.track(new ImmutableSet<ZeroState>(DivZeroes)), ZS))));
        }
      }
      $c$.clean(C.addTransition($c$.track(State.$arrow().set(ProgramStateTraitDivZeroMap.$Instance, $c$.track(new ImmutableSet<ZeroState>(DivZeroes))))));
    } finally {
      if (DivZeroes != null) { DivZeroes.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TestAfterDivZeroChecker::setDivZeroMap">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 148,
   FQN="(anonymous namespace)::TestAfterDivZeroChecker::setDivZeroMap", NM="_ZNK12_GLOBAL__N_123TestAfterDivZeroChecker13setDivZeroMapEN5clang4ento4SValERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZNK12_GLOBAL__N_123TestAfterDivZeroChecker13setDivZeroMapEN5clang4ento4SValERNS2_14CheckerContextE")
  //</editor-fold>
  public void setDivZeroMap(SVal Var, final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ SymExpr /*P*/ SR = Var.getAsSymbol();
      if (!(SR != null)) {
        return;
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      $c$.clean(State.$assign(
          $c$.track(State.$arrow().add(ProgramStateTraitDivZeroMap.$Instance, new ZeroState(SR, C.getBlockID(), C.getStackFrame())))
      ));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TestAfterDivZeroChecker::hasDivZeroMap">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 159,
   FQN="(anonymous namespace)::TestAfterDivZeroChecker::hasDivZeroMap", NM="_ZNK12_GLOBAL__N_123TestAfterDivZeroChecker13hasDivZeroMapEN5clang4ento4SValERKNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZNK12_GLOBAL__N_123TestAfterDivZeroChecker13hasDivZeroMapEN5clang4ento4SValERKNS2_14CheckerContextE")
  //</editor-fold>
  public boolean hasDivZeroMap(SVal Var, 
               final /*const*/ CheckerContext /*&*/ C) /*const*/ {
    /*const*/ SymExpr /*P*/ SR = Var.getAsSymbol();
    if (!(SR != null)) {
      return false;
    }
    
    ZeroState ZS/*J*/= new ZeroState(SR, C.getBlockID(), C.getStackFrame());
    return C.getState().$arrow().contains(ProgramStateTraitDivZeroMap.$Instance, new ZeroState(ZS));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TestAfterDivZeroChecker::isZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 138,
   FQN="(anonymous namespace)::TestAfterDivZeroChecker::isZero", NM="_ZNK12_GLOBAL__N_123TestAfterDivZeroChecker6isZeroEN5clang4ento4SValERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZNK12_GLOBAL__N_123TestAfterDivZeroChecker6isZeroEN5clang4ento4SValERNS2_14CheckerContextE")
  //</editor-fold>
  public boolean isZero(SVal S, final CheckerContext /*&*/ C) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Optional<DefinedSVal> DSV = S.getAs(DefinedSVal.class);
      if (!DSV.$bool()) {
        return false;
      }
      
      final ConstraintManager /*&*/ CM = C.getConstraintManager();
      return $c$.clean(!$c$.track(CM.assume($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState())), new DefinedSVal(DSV.$star()), true)).$bool());
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TestAfterDivZeroChecker::~TestAfterDivZeroChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 79,
   FQN="(anonymous namespace)::TestAfterDivZeroChecker::~TestAfterDivZeroChecker", NM="_ZN12_GLOBAL__N_123TestAfterDivZeroCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZN12_GLOBAL__N_123TestAfterDivZeroCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    DivZeroBug.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TestAfterDivZeroChecker::TestAfterDivZeroChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 79,
   FQN="(anonymous namespace)::TestAfterDivZeroChecker::TestAfterDivZeroChecker", NM="_ZN12_GLOBAL__N_123TestAfterDivZeroCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZN12_GLOBAL__N_123TestAfterDivZeroCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ TestAfterDivZeroChecker() {
    // : Checker<PreStmt<BinaryOperator>, BranchCondition, EndFunction>(), DivZeroBug() 
    //START JInit
    super();
    this.DivZeroBug = new std.unique_ptr<BuiltinBug>();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPreStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof BinaryOperator) {
      checkPreStmt((BinaryOperator) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PreStmt<BinaryOperator>(BinaryOperator.class),
    new BranchCondition(),
    new EndFunction()
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "DivZeroBug=" + DivZeroBug // NOI18N
              + super.toString(); // NOI18N
  }
}
