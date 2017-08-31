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
import static org.clank.java.built_in.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.checkers.ento.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerMemberPointers.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.staticanalyzer.checkers.impl.ExprInspectionCheckerStatics.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprInspectionChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp", line = 21,
 FQN="(anonymous namespace)::ExprInspectionChecker", NM="_ZN12_GLOBAL__N_121ExprInspectionCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN12_GLOBAL__N_121ExprInspectionCheckerE")
//</editor-fold>
public class ExprInspectionChecker extends /*public*/ Checker/*<eval.Call, DeadSymbols> */
        implements org.clang.staticanalyzer.java.EvalCallChecker, org.clang.staticanalyzer.java.DeadSymbolsChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BugType> BT;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprInspectionChecker::analyzerEval">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp", line = 113,
   FQN="(anonymous namespace)::ExprInspectionChecker::analyzerEval", NM="_ZNK12_GLOBAL__N_121ExprInspectionChecker12analyzerEvalEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZNK12_GLOBAL__N_121ExprInspectionChecker12analyzerEvalEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private void analyzerEval(/*const*/ CallExpr /*P*/ CE, 
              final CheckerContext /*&*/ C) /*const*/ {
    /*const*/ LocationContext /*P*/ LC = C.getPredecessor().getLocationContext();
    
    // A specific instantiation of an inlined function may have more constrained
    // values than can generally be assumed. Skip the check.
    if (LC.getCurrentStackFrame().getParent() != null) {
      return;
    }
    
    reportBug(new StringRef(ExprInspectionCheckerStatics.getArgumentValueString(CE, C)), C);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprInspectionChecker::analyzerCheckInlined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp", line = 130,
   FQN="(anonymous namespace)::ExprInspectionChecker::analyzerCheckInlined", NM="_ZNK12_GLOBAL__N_121ExprInspectionChecker20analyzerCheckInlinedEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZNK12_GLOBAL__N_121ExprInspectionChecker20analyzerCheckInlinedEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private void analyzerCheckInlined(/*const*/ CallExpr /*P*/ CE, 
                      final CheckerContext /*&*/ C) /*const*/ {
    /*const*/ LocationContext /*P*/ LC = C.getPredecessor().getLocationContext();
    
    // An inlined function could conceivably also be analyzed as a top-level
    // function. We ignore this case and only emit a message (TRUE or FALSE)
    // when we are analyzing it as an inlined function. This means that
    // clang_analyzer_checkInlined(true) should always print TRUE, but
    // clang_analyzer_checkInlined(false) should never actually print anything.
    if (LC.getCurrentStackFrame().getParent() == null) {
      return;
    }
    
    reportBug(new StringRef(ExprInspectionCheckerStatics.getArgumentValueString(CE, C)), C);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprInspectionChecker::analyzerWarnIfReached">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp", line = 125,
   FQN="(anonymous namespace)::ExprInspectionChecker::analyzerWarnIfReached", NM="_ZNK12_GLOBAL__N_121ExprInspectionChecker21analyzerWarnIfReachedEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZNK12_GLOBAL__N_121ExprInspectionChecker21analyzerWarnIfReachedEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private void analyzerWarnIfReached(/*const*/ CallExpr /*P*/ CE, 
                       final CheckerContext /*&*/ C) /*const*/ {
    reportBug(new StringRef(/*KEEP_STR*/"REACHABLE"), C);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprInspectionChecker::analyzerCrash">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp", line = 199,
   FQN="(anonymous namespace)::ExprInspectionChecker::analyzerCrash", NM="_ZNK12_GLOBAL__N_121ExprInspectionChecker13analyzerCrashEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZNK12_GLOBAL__N_121ExprInspectionChecker13analyzerCrashEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private void analyzerCrash(/*const*/ CallExpr /*P*/ CE, 
               final CheckerContext /*&*/ C) /*const*/ {
    __builtin_trap();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprInspectionChecker::analyzerWarnOnDeadSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp", line = 170,
   FQN="(anonymous namespace)::ExprInspectionChecker::analyzerWarnOnDeadSymbol", NM="_ZNK12_GLOBAL__N_121ExprInspectionChecker24analyzerWarnOnDeadSymbolEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZNK12_GLOBAL__N_121ExprInspectionChecker24analyzerWarnOnDeadSymbolEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private void analyzerWarnOnDeadSymbol(/*const*/ CallExpr /*P*/ CE, 
                          final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (CE.getNumArgs() == 0) {
        return;
      }
      SVal Val = C.getSVal(CE.getArg$Const(0));
      /*const*/ SymExpr /*P*/ Sym = Val.getAsSymbol();
      if (!(Sym != null)) {
        return;
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      $c$.clean(State.$assign($c$.track(State.$arrow().add(ProgramStateTraitMarkedSymbols.$Instance, Sym))));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprInspectionChecker::analyzerExplain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp", line = 145,
   FQN="(anonymous namespace)::ExprInspectionChecker::analyzerExplain", NM="_ZNK12_GLOBAL__N_121ExprInspectionChecker15analyzerExplainEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZNK12_GLOBAL__N_121ExprInspectionChecker15analyzerExplainEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private void analyzerExplain(/*const*/ CallExpr /*P*/ CE, 
                 final CheckerContext /*&*/ C) /*const*/ {
    if (CE.getNumArgs() == 0) {
      reportBug(new StringRef(/*KEEP_STR*/"Missing argument for explaining"), C);
    }
    
    SVal V = C.getSVal(CE.getArg$Const(0));
    SValExplainer Ex/*J*/= new SValExplainer(C.getASTContext());
    reportBug(new StringRef(Ex.Visit(new SVal(V))), C);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprInspectionChecker::analyzerGetExtent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp", line = 155,
   FQN="(anonymous namespace)::ExprInspectionChecker::analyzerGetExtent", NM="_ZNK12_GLOBAL__N_121ExprInspectionChecker17analyzerGetExtentEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZNK12_GLOBAL__N_121ExprInspectionChecker17analyzerGetExtentEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private void analyzerGetExtent(/*const*/ CallExpr /*P*/ CE, 
                   final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (CE.getNumArgs() == 0) {
        reportBug(new StringRef(/*KEEP_STR*/"Missing region for obtaining extent"), C);
      }
      
      /*const*/ SubRegion /*P*/ MR = dyn_cast_or_null_SubRegion(C.getSVal(CE.getArg$Const(0)).getAsRegion());
      if (!(MR != null)) {
        reportBug(new StringRef(/*KEEP_STR*/"Obtaining extent of a non-region"), C);
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      $c$.clean(State.$assign($c$.track(State.$arrow().BindExpr(CE, C.getLocationContext(), 
              new SVal(JD$Move.INSTANCE, MR.getExtent(C.getSValBuilder()))))));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  // JAVA: typedef void (ExprInspectionChecker::*FnCheck)(const CallExpr *, CheckerContext &) const
//  public final class FnCheck extends ExprInspectionChecker$FnCheck{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprInspectionChecker::reportBug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp", line = 101,
   FQN="(anonymous namespace)::ExprInspectionChecker::reportBug", NM="_ZNK12_GLOBAL__N_121ExprInspectionChecker9reportBugEN4llvm9StringRefERN5clang4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZNK12_GLOBAL__N_121ExprInspectionChecker9reportBugEN4llvm9StringRefERN5clang4ento14CheckerContextE")
  //</editor-fold>
  private void reportBug(StringRef Msg, 
           final CheckerContext /*&*/ C) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!BT.$bool()) {
        BT.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Checking analyzer assumptions"), new StringRef(/*KEEP_STR*/"debug")));
      }
      
      ExplodedNode /*P*/ N = C.generateNonFatalErrorNode();
      if (!(N != null)) {
        return;
      }
      
      C.emitReport($c$.track(llvm.make_unique(new BugReport(BT.$star(), Msg, N)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprInspectionChecker::evalCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp", line = 45,
   FQN="(anonymous namespace)::ExprInspectionChecker::evalCall", NM="_ZNK12_GLOBAL__N_121ExprInspectionChecker8evalCallEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZNK12_GLOBAL__N_121ExprInspectionChecker8evalCallEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public boolean evalCall(/*const*/ CallExpr /*P*/ CE, 
          final CheckerContext /*&*/ C) /*const*/ {
    // These checks should have no effect on the surrounding environment
    // (globals should not be invalidated, etc), hence the use of evalCall.
    ExprInspectionChecker$FnCheck Handler = new StringSwitch<ExprInspectionChecker$FnCheck>(C.getCalleeName(CE)).
        Case(/*KEEP_STR*/"clang_analyzer_eval", /*AddrOf*//*FPtr*/ExprInspectionChecker::analyzerEval).
        Case(/*KEEP_STR*/"clang_analyzer_checkInlined", 
        /*AddrOf*//*FPtr*/ExprInspectionChecker::analyzerCheckInlined).
        Case(/*KEEP_STR*/"clang_analyzer_crash", /*AddrOf*//*FPtr*/ExprInspectionChecker::analyzerCrash).
        Case(/*KEEP_STR*/"clang_analyzer_warnIfReached", 
        /*AddrOf*//*FPtr*/ExprInspectionChecker::analyzerWarnIfReached).
        Case(/*KEEP_STR*/"clang_analyzer_warnOnDeadSymbol", 
        /*AddrOf*//*FPtr*/ExprInspectionChecker::analyzerWarnOnDeadSymbol).
        Case(/*KEEP_STR*/"clang_analyzer_explain", /*AddrOf*//*FPtr*/ExprInspectionChecker::analyzerExplain).
        Case(/*KEEP_STR*/"clang_analyzer_getExtent", /*AddrOf*//*FPtr*/ExprInspectionChecker::analyzerGetExtent).
        Default((ExprInspectionChecker$FnCheck)null);
    if (!(Handler != null)) {
      return false;
    }
    
    Handler.$call(/*PtrMemI*/this, CE, C);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprInspectionChecker::checkDeadSymbols">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp", line = 184,
   FQN="(anonymous namespace)::ExprInspectionChecker::checkDeadSymbols", NM="_ZNK12_GLOBAL__N_121ExprInspectionChecker16checkDeadSymbolsERN5clang4ento12SymbolReaperERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZNK12_GLOBAL__N_121ExprInspectionChecker16checkDeadSymbolsERN5clang4ento12SymbolReaperERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkDeadSymbols(final SymbolReaper /*&*/ SymReaper, 
                  final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    /*const*/ImmutableSetPtr</*const*/ SymExpr /*P*/ > /*&*/ Syms = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*final */ Syms = State.$arrow()./*<MarkedSymbols>*/get(ProgramStateTraitMarkedSymbols.$Instance);
      for (ImutAVLValueIteratorPtrBoolPtr</*const*/ SymExpr /*P*/ > I = Syms.begin(), E = Syms.end(); I.$noteq(E); I.$preInc()) {
          /*const*/ SymExpr /*P*/ Sym = I.$star();
          if (!SymReaper.isDead(Sym)) {
            continue;
          }
          
          reportBug(new StringRef(/*KEEP_STR*/"SYMBOL DEAD"), C);
        $c$.clean(State.$assign($c$.track(State.$arrow()./*<MarkedSymbols>*/remove(ProgramStateTraitMarkedSymbols.$Instance, Sym))));
        }
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (Syms != null) { Syms.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprInspectionChecker::~ExprInspectionChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp", line = 21,
   FQN="(anonymous namespace)::ExprInspectionChecker::~ExprInspectionChecker", NM="_ZN12_GLOBAL__N_121ExprInspectionCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN12_GLOBAL__N_121ExprInspectionCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprInspectionChecker::ExprInspectionChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp", line = 21,
   FQN="(anonymous namespace)::ExprInspectionChecker::ExprInspectionChecker", NM="_ZN12_GLOBAL__N_121ExprInspectionCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN12_GLOBAL__N_121ExprInspectionCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ ExprInspectionChecker() {
    // : Checker<eval::Call, DeadSymbols>(), BT() 
    //START JInit
    super();
    this.BT = new std.unique_ptr<BugType>();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new eval.Call(),
    new DeadSymbols()
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
