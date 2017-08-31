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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import org.clang.staticanalyzer.java.*;
import static org.clang.staticanalyzer.checkers.impl.BoolAssignmentCheckerStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BoolAssignmentChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BoolAssignmentChecker.cpp", line = 25,
 FQN="(anonymous namespace)::BoolAssignmentChecker", NM="_ZN12_GLOBAL__N_121BoolAssignmentCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BoolAssignmentChecker.cpp -nm=_ZN12_GLOBAL__N_121BoolAssignmentCheckerE")
//</editor-fold>
public class BoolAssignmentChecker extends /*public*/ Checker/*T<Bind> */
        implements org.clang.staticanalyzer.java.BindChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BuiltinBug> BT;
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BoolAssignmentChecker::emitReport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BoolAssignmentChecker.cpp", line = 33,
   FQN="(anonymous namespace)::BoolAssignmentChecker::emitReport", NM="_ZNK12_GLOBAL__N_121BoolAssignmentChecker10emitReportEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERNS4_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BoolAssignmentChecker.cpp -nm=_ZNK12_GLOBAL__N_121BoolAssignmentChecker10emitReportEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERNS4_14CheckerContextE")
  //</editor-fold>
  private void emitReport(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
            final CheckerContext /*&*/ C) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      {
        ExplodedNode /*P*/ N = $c$.clean(C.generateNonFatalErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
        if ((N != null)) {
          if (!BT.$bool()) {
            BT.reset(new BuiltinBug(this, $("Assignment of a non-Boolean value")));
          }
          C.emitReport($c$.track(llvm.make_unique(new BugReport(BT.$star(), BT.$arrow().getDescription(), N)))); $c$.clean();
        }
      }
    } finally {
      $c$.$destroy();
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BoolAssignmentChecker::checkBind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*std.tie*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BoolAssignmentChecker.cpp", line = 54,
   FQN="(anonymous namespace)::BoolAssignmentChecker::checkBind", NM="_ZNK12_GLOBAL__N_121BoolAssignmentChecker9checkBindEN5clang4ento4SValES3_PKNS1_4StmtERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BoolAssignmentChecker.cpp -nm=_ZNK12_GLOBAL__N_121BoolAssignmentChecker9checkBindEN5clang4ento4SValES3_PKNS1_4StmtERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkBind(SVal loc, SVal val, /*const*/ Stmt /*P*/ S, 
           final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> stateLT = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> stateGE = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> stateGT = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> stateLE = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      // We are only interested in stores into Booleans.
      /*const*/ TypedValueRegion /*P*/ TR = dyn_cast_or_null_TypedValueRegion(loc.getAsRegion());
      if (!(TR != null)) {
        return;
      }
      
      QualType valTy = TR.getValueType();
      if (!BoolAssignmentCheckerStatics.isBooleanType(new QualType(valTy))) {
        return;
      }
      
      // Get the value of the right-hand side.  We only care about values
      // that are defined (UnknownVals and UndefinedVals are handled by other
      // checkers).
      Optional<DefinedSVal> DV = val.getAs(DefinedSVal.class);
      if (!DV.$bool()) {
        return;
      }
      
      // Check if the assigned value meets our criteria for correctness.  It must
      // be a value that is either 0 or 1.  One way to check this is to see if
      // the value is possibly < 0 (for a negative value) or greater than 1.
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      final SValBuilder /*&*/ svalBuilder = C.getSValBuilder();
      final ConstraintManager /*&*/ CM = C.getConstraintManager();
      
      // First, ensure that the value is >= 0.
      DefinedSVal zeroVal = svalBuilder.makeIntVal($int2ulong(0), new QualType(valTy));
      SVal greaterThanOrEqualToZeroVal = $c$.clean(svalBuilder.evalBinOp($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_GE, new SVal(DV.$star()), new SVal(zeroVal), 
          svalBuilder.getConditionType()));
      
      Optional<DefinedSVal> greaterThanEqualToZero = greaterThanOrEqualToZeroVal.getAs(DefinedSVal.class);
      if (!greaterThanEqualToZero.$bool()) {
        // The SValBuilder cannot construct a valid SVal for this condition.
        // This means we cannot properly reason about it.
        return;
      }
      
      stateLT/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      stateGE/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(stateGE, stateLT).$assign($c$.track(CM.assumeDual($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new DefinedSVal(greaterThanEqualToZero.$star())))));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assumeDual = 
              $c$.track(CM.assumeDual($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new DefinedSVal(greaterThanEqualToZero.$star())));
      stateGE.$assign($assumeDual.first);
      stateLT.$assign($assumeDual.second);
      assert !$assumeDual.first.$bool();
      assert !$assumeDual.second.$bool();
      $c$.clean();
      
      // Is it possible for the value to be less than zero?
      if (stateLT.$bool()) {
        // It is possible for the value to be less than zero.  We only
        // want to emit a warning, however, if that value is fully constrained.
        // If it it possible for the value to be >= 0, then essentially the
        // value is underconstrained and there is nothing left to be done.
        if (!stateGE.$bool()) {
          emitReport($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateLT)), C); $c$.clean();
        }
        
        // In either case, we are done.
        return;
      }
      
      // If we reach here, it must be the case that the value is constrained
      // to only be >= 0.
      assert ($eq_IntrusiveRefCntPtr(stateGE, state));
      
      // At this point we know that the value is >= 0.
      // Now check to ensure that the value is <= 1.
      DefinedSVal OneVal = svalBuilder.makeIntVal($int2ulong(1), new QualType(valTy));
      SVal lessThanEqToOneVal = $c$.clean(svalBuilder.evalBinOp($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_LE, new SVal(DV.$star()), new SVal(OneVal), 
          svalBuilder.getConditionType()));
      
      Optional<DefinedSVal> lessThanEqToOne = lessThanEqToOneVal.getAs(DefinedSVal.class);
      if (!lessThanEqToOne.$bool()) {
        // The SValBuilder cannot construct a valid SVal for this condition.
        // This means we cannot properly reason about it.
        return;
      }
      
      stateGT/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      stateLE/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(stateLE, stateGT).$assign($c$.track(CM.assumeDual($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new DefinedSVal(lessThanEqToOne.$star())))));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assumeDual$1 = 
              $c$.track(CM.assumeDual($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new DefinedSVal(lessThanEqToOne.$star())));
      stateLE.$assign($assumeDual$1.first);
      stateGT.$assign($assumeDual$1.second);
      assert !$assumeDual$1.first.$bool();
      assert !$assumeDual$1.second.$bool();
      $c$.clean();
      
      // Is it possible for the value to be greater than one?
      if (stateGT.$bool()) {
        // It is possible for the value to be greater than one.  We only
        // want to emit a warning, however, if that value is fully constrained.
        // If it is possible for the value to be <= 1, then essentially the
        // value is underconstrained and there is nothing left to be done.
        if (!stateLE.$bool()) {
          emitReport($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateGT)), C); $c$.clean();
        }
        
        // In either case, we are done.
        return;
      }
      
      // If we reach here, it must be the case that the value is constrained
      // to only be <= 1.
      assert ($eq_IntrusiveRefCntPtr(stateLE, state));
    } finally {
      if (stateLE != null) { stateLE.$destroy(); }
      if (stateGT != null) { stateGT.$destroy(); }
      if (stateGE != null) { stateGE.$destroy(); }
      if (stateLT != null) { stateLT.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BoolAssignmentChecker::~BoolAssignmentChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BoolAssignmentChecker.cpp", line = 25,
   FQN="(anonymous namespace)::BoolAssignmentChecker::~BoolAssignmentChecker", NM="_ZN12_GLOBAL__N_121BoolAssignmentCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BoolAssignmentChecker.cpp -nm=_ZN12_GLOBAL__N_121BoolAssignmentCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BoolAssignmentChecker::BoolAssignmentChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BoolAssignmentChecker.cpp", line = 25,
   FQN="(anonymous namespace)::BoolAssignmentChecker::BoolAssignmentChecker", NM="_ZN12_GLOBAL__N_121BoolAssignmentCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BoolAssignmentChecker.cpp -nm=_ZN12_GLOBAL__N_121BoolAssignmentCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ BoolAssignmentChecker() {
    // : Checker<Bind>(), BT() 
    //START JInit
    super();
    this.BT = new std.unique_ptr<BuiltinBug>();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new Bind()
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT=" + BT // NOI18N
              + super.toString(); // NOI18N
  }
}
