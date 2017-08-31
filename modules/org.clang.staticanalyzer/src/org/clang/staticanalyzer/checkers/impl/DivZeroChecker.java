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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DivZeroChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DivZeroChecker.cpp", line = 25,
 FQN="(anonymous namespace)::DivZeroChecker", NM="_ZN12_GLOBAL__N_114DivZeroCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DivZeroChecker.cpp -nm=_ZN12_GLOBAL__N_114DivZeroCheckerE")
//</editor-fold>
public class DivZeroChecker extends /*public*/ Checker/*T<PreStmt<BinaryOperator> > */
        implements org.clang.staticanalyzer.java.PreStmtChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BuiltinBug> BT;
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DivZeroChecker::reportBug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DivZeroChecker.cpp", line = 35,
   FQN="(anonymous namespace)::DivZeroChecker::reportBug", NM="_ZNK12_GLOBAL__N_114DivZeroChecker9reportBugEPKcN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERNS6_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DivZeroChecker.cpp -nm=_ZNK12_GLOBAL__N_114DivZeroChecker9reportBugEPKcN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERNS6_14CheckerContextE")
  //</editor-fold>
  private void reportBug(/*const*/char$ptr/*char P*/ Msg, 
           IntrusiveRefCntPtr</*const*/ ProgramState> StateZero, 
           final CheckerContext /*&*/ C) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      {
        ExplodedNode /*P*/ N = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StateZero))));
        if ((N != null)) {
          unique_ptr<BugReport> R = null;
          try {
            if (!BT.$bool()) {
              BT.reset(new BuiltinBug(this, $("Division by zero")));
            }
            
            R = llvm.make_unique(new BugReport(BT.$star(), Msg, N));
            NsBugreporter.trackNullOrUndefValue(N, NsBugreporter.GetDenomExpr(N), R.$star());
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
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DivZeroChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DivZeroChecker.cpp", line = 48,
   FQN="(anonymous namespace)::DivZeroChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_114DivZeroChecker12checkPreStmtEPKN5clang14BinaryOperatorERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DivZeroChecker.cpp -nm=_ZNK12_GLOBAL__N_114DivZeroChecker12checkPreStmtEPKN5clang14BinaryOperatorERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ BinaryOperator /*P*/ B, 
              final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> stateNotZero = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> stateZero = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      BinaryOperatorKind Op = B.getOpcode();
      if (Op != BinaryOperatorKind.BO_Div
         && Op != BinaryOperatorKind.BO_Rem
         && Op != BinaryOperatorKind.BO_DivAssign
         && Op != BinaryOperatorKind.BO_RemAssign) {
        return;
      }
      if (!B.getRHS().getType().$arrow().isScalarType()) {
        return;
      }
      
      SVal Denom = C.getState().$arrow().getSVal(B.getRHS(), C.getLocationContext());
      Optional<DefinedSVal> DV = Denom.getAs(DefinedSVal.class);
      
      // Divide-by-undefined handled in the generic checking for uses of
      // undefined values.
      if (!DV.$bool()) {
        return;
      }
      
      // Check for divide by zero.
      final ConstraintManager /*&*/ CM = C.getConstraintManager();
      stateNotZero/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      stateZero/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(stateNotZero, stateZero).$assign($c$.track(CM.assumeDual($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState())), new DefinedSVal(DV.$star())))));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assumeDual = 
              $c$.track(CM.assumeDual($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState())), new DefinedSVal(DV.$star())));
      stateNotZero.$assign($assumeDual.first);
      stateZero.$assign($assumeDual.second);
      assert !$assumeDual.first.$bool();
      assert !$assumeDual.second.$bool();
      $c$.clean();
      
      if (!stateNotZero.$bool()) {
        assert ((stateZero).$bool());
        reportBug($("Division by zero"), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateZero)), C); $c$.clean();
        return;
      }
      
      boolean TaintedD = C.getState().$arrow().isTainted(new SVal(DV.$star()));
      if ((stateNotZero.$bool() && stateZero.$bool() && TaintedD)) {
        reportBug($("Division by a tainted value, possibly zero"), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateZero)), C); $c$.clean();
        return;
      }
      
      // If we get here, then the denom should not be zero. We abandon the implicit
      // zero denom case for now.
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateNotZero))));
    } finally {
      if (stateZero != null) { stateZero.$destroy(); }
      if (stateNotZero != null) { stateNotZero.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DivZeroChecker::~DivZeroChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DivZeroChecker.cpp", line = 25,
   FQN="(anonymous namespace)::DivZeroChecker::~DivZeroChecker", NM="_ZN12_GLOBAL__N_114DivZeroCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DivZeroChecker.cpp -nm=_ZN12_GLOBAL__N_114DivZeroCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DivZeroChecker::DivZeroChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DivZeroChecker.cpp", line = 25,
   FQN="(anonymous namespace)::DivZeroChecker::DivZeroChecker", NM="_ZN12_GLOBAL__N_114DivZeroCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DivZeroChecker.cpp -nm=_ZN12_GLOBAL__N_114DivZeroCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ DivZeroChecker() {
    // : Checker<PreStmt<BinaryOperator> >(), BT() 
    //START JInit
    super();
    this.BT = new std.unique_ptr<BuiltinBug>();
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
    new org.clang.staticanalyzer.core.ento.check.PreStmt<BinaryOperator>(BinaryOperator.class)
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
