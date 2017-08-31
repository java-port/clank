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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.frontend.staticanalyzer.*;
import org.clang.staticanalyzer.checkers.ento.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.checkers.ento.objc_retain.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.staticanalyzer.checkers.impl.RetainCountCheckerStatics.*;
import org.clang.staticanalyzer.java.*;
import org.clang.analysis.domainspecific.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.llvm.StaticanalyzerLlvmGlobals;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2462,
 FQN="(anonymous namespace)::RetainCountChecker", NM="_ZN12_GLOBAL__N_118RetainCountCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_118RetainCountCheckerE")
//</editor-fold>
public class RetainCountChecker extends /*public*/ Checker/*<Bind, DeadSymbols, EndAnalysis, EndFunction, PostStmt<BlockExpr>, PostStmt<CastExpr>, PostStmt<ObjCArrayLiteral>, PostStmt<ObjCDictionaryLiteral>, PostStmt<ObjCBoxedExpr>, PostStmt<ObjCIvarRefExpr>, PostCall, PreStmt<ReturnStmt>, RegionChanges, eval.Assume, eval.Call>*/ 
         implements org.clang.staticanalyzer.java.EvalAssumeChecker, org.clang.staticanalyzer.java.EvalCallChecker, org.clang.staticanalyzer.java.RegionChangesChecker, org.clang.staticanalyzer.java.PreStmtChecker, org.clang.staticanalyzer.java.PostStmtChecker, org.clang.staticanalyzer.java.PostCallChecker, org.clang.staticanalyzer.java.EndFunctionChecker, org.clang.staticanalyzer.java.EndAnalysisChecker, org.clang.staticanalyzer.java.DeadSymbolsChecker, org.clang.staticanalyzer.java.BindChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<CFRefBug> useAfterRelease;
  private /*mutable */std.unique_ptr<CFRefBug> releaseNotOwned;
  private /*mutable */std.unique_ptr<CFRefBug> deallocGC;
  private /*mutable */std.unique_ptr<CFRefBug> deallocNotOwned;
  private /*mutable */std.unique_ptr<CFRefBug> overAutorelease;
  private /*mutable */std.unique_ptr<CFRefBug> returnNotOwnedForOwned;
  private /*mutable */std.unique_ptr<CFRefBug> leakWithinFunction;
  private /*mutable */std.unique_ptr<CFRefBug> leakAtReturn;
  private /*mutable */std.unique_ptr<CFRefBug> leakWithinFunctionGC;
  private /*mutable */std.unique_ptr<CFRefBug> leakAtReturnGC;
  
  // JAVA: typedef llvm::DenseMap<SymbolRef, const CheckerProgramPointTag *> SymbolTagMap
//  public final class SymbolTagMap extends DenseMap</*const*/ SymExpr /*P*/ , /*const*/ CheckerProgramPointTag /*P*/ >{ };
  
  // This map is only used to ensure proper deletion of any allocated tags.
  private /*mutable */DenseMap</*const*/ SymExpr /*P*/ , /*const*/ CheckerProgramPointTag /*P*/ > DeadSymbolTags;
  
  private /*mutable */std.unique_ptr<RetainSummaryManager> Summaries;
  private /*mutable */std.unique_ptr<RetainSummaryManager> SummariesGC;
  private /*mutable */DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ RetainSummary /*P*/ > SummaryLog;
  private /*mutable */boolean ShouldResetSummaryLog;
  
  /// Optional setting to indicate if leak reports should include
  /// the allocation line.
  private /*mutable */boolean IncludeAllocationLine;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::RetainCountChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2499,
   FQN="(anonymous namespace)::RetainCountChecker::RetainCountChecker", NM="_ZN12_GLOBAL__N_118RetainCountCheckerC1ERN5clang15AnalyzerOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_118RetainCountCheckerC1ERN5clang15AnalyzerOptionsE")
  //</editor-fold>
  public RetainCountChecker(final AnalyzerOptions /*&*/ AO) {
    // : Checker<Bind, DeadSymbols, EndAnalysis, EndFunction, PostStmt<BlockExpr>, PostStmt<CastExpr>, PostStmt<ObjCArrayLiteral>, PostStmt<ObjCDictionaryLiteral>, PostStmt<ObjCBoxedExpr>, PostStmt<ObjCIvarRefExpr>, PostCall, PreStmt<ReturnStmt>, RegionChanges, eval::Assume, eval::Call>(), useAfterRelease(), releaseNotOwned(), deallocGC(), deallocNotOwned(), overAutorelease(), returnNotOwnedForOwned(), leakWithinFunction(), leakAtReturn(), leakWithinFunctionGC(), leakAtReturnGC(), DeadSymbolTags(), Summaries(), SummariesGC(), SummaryLog(), ShouldResetSummaryLog(false), IncludeAllocationLine(shouldIncludeAllocationSiteInLeakDiagnostics(AO)) 
    //START JInit
    super();
    this.useAfterRelease = new std.unique_ptr<CFRefBug>();
    this.releaseNotOwned = new std.unique_ptr<CFRefBug>();
    this.deallocGC = new std.unique_ptr<CFRefBug>();
    this.deallocNotOwned = new std.unique_ptr<CFRefBug>();
    this.overAutorelease = new std.unique_ptr<CFRefBug>();
    this.returnNotOwnedForOwned = new std.unique_ptr<CFRefBug>();
    this.leakWithinFunction = new std.unique_ptr<CFRefBug>();
    this.leakAtReturn = new std.unique_ptr<CFRefBug>();
    this.leakWithinFunctionGC = new std.unique_ptr<CFRefBug>();
    this.leakAtReturnGC = new std.unique_ptr<CFRefBug>();
    this.DeadSymbolTags = new DenseMap</*const*/ SymExpr /*P*/ , /*const*/ CheckerProgramPointTag /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ CheckerProgramPointTag /*P*/ )null);
    this.Summaries = new std.unique_ptr<RetainSummaryManager>();
    this.SummariesGC = new std.unique_ptr<RetainSummaryManager>();
    this.SummaryLog = new DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ RetainSummary /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ RetainSummary /*P*/ )null);
    this.ShouldResetSummaryLog = false;
    this.IncludeAllocationLine = EntoStatics.shouldIncludeAllocationSiteInLeakDiagnostics(AO);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::~RetainCountChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2503,
   FQN="(anonymous namespace)::RetainCountChecker::~RetainCountChecker", NM="_ZN12_GLOBAL__N_118RetainCountCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_118RetainCountCheckerD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    DeleteContainerSeconds(DeadSymbolTags);
    //START JDestroy
    SummaryLog.$destroy();
    SummariesGC.$destroy();
    Summaries.$destroy();
    DeadSymbolTags.$destroy();
    leakAtReturnGC.$destroy();
    leakWithinFunctionGC.$destroy();
    leakAtReturn.$destroy();
    leakWithinFunction.$destroy();
    returnNotOwnedForOwned.$destroy();
    overAutorelease.$destroy();
    deallocNotOwned.$destroy();
    deallocGC.$destroy();
    releaseNotOwned.$destroy();
    useAfterRelease.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::checkEndAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2505,
   FQN="(anonymous namespace)::RetainCountChecker::checkEndAnalysis", NM="_ZNK12_GLOBAL__N_118RetainCountChecker16checkEndAnalysisERN5clang4ento13ExplodedGraphERNS2_11BugReporterERNS2_10ExprEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker16checkEndAnalysisERN5clang4ento13ExplodedGraphERNS2_11BugReporterERNS2_10ExprEngineE")
  //</editor-fold>
  public void checkEndAnalysis(final ExplodedGraph /*&*/ G, final BugReporter /*&*/ BR, 
                  final ExprEngine /*&*/ Eng) /*const*/ {
    // FIXME: This is a hack to make sure the summary log gets cleared between
    // analyses of different code bodies.
    //
    // Why is this necessary? Because a checker's lifetime is tied to a
    // translation unit, but an ExplodedGraph's lifetime is just a code body.
    // Once in a blue moon, a new ExplodedNode will have the same address as an
    // old one with an associated summary, and the bug report visitor gets very
    // confused. (To make things worse, the summary lifetime is currently also
    // tied to a code body, so we get a crash instead of incorrect results.)
    //
    // Why is this a bad solution? Because if the lifetime of the ExplodedGraph
    // changes, things will start going wrong again. Really the lifetime of this
    // log needs to be tied to either the specific nodes in it or the entire
    // ExplodedGraph, not to a specific part of the code being analyzed.
    //
    // (Also, having stateful local data means that the same checker can't be
    // used from multiple threads, but a lot of checkers have incorrect
    // assumptions about that anyway. So that wasn't a priority at the time of
    // this fix.)
    //
    // This happens at the end of analysis, but bug reports are emitted /after/
    // this point. So we can't just clear the summary log now. Instead, we mark
    // that the next time we access the summary log, it should be cleared.
    
    // If we never reset the summary log during /this/ code body analysis,
    // there were no new summaries. There might still have been summaries from
    // the /last/ analysis, so clear them out to make sure the bug report
    // visitors don't get confused.
    if (ShouldResetSummaryLog) {
      SummaryLog.clear();
    }
    
    ShouldResetSummaryLog = !SummaryLog.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::getLeakWithinFunctionBug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2541,
   FQN="(anonymous namespace)::RetainCountChecker::getLeakWithinFunctionBug", NM="_ZNK12_GLOBAL__N_118RetainCountChecker24getLeakWithinFunctionBugERKN5clang11LangOptionsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker24getLeakWithinFunctionBugERKN5clang11LangOptionsEb")
  //</editor-fold>
  public CFRefBug /*P*/ getLeakWithinFunctionBug(final /*const*/ LangOptions /*&*/ LOpts, 
                          boolean GCEnabled) /*const*/ {
    if (GCEnabled) {
      if (!leakWithinFunctionGC.$bool()) {
        leakWithinFunctionGC.reset(new Leak(this, new StringRef(/*KEEP_STR*/"Leak of object when using garbage collection")));
      }
      return leakWithinFunctionGC.get();
    } else {
      if (!leakWithinFunction.$bool()) {
        if (LOpts.getGC() == LangOptions.GCMode.HybridGC) {
          leakWithinFunction.reset(new Leak(this, 
                  new StringRef(/*KEEP_STR*/"Leak of object when not using garbage collection (GC) in dual GC/non-GC code")));
        } else {
          leakWithinFunction.reset(new Leak(this, new StringRef(/*KEEP_STR*/"Leak")));
        }
      }
      return leakWithinFunction.get();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::getLeakAtReturnBug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2563,
   FQN="(anonymous namespace)::RetainCountChecker::getLeakAtReturnBug", NM="_ZNK12_GLOBAL__N_118RetainCountChecker18getLeakAtReturnBugERKN5clang11LangOptionsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker18getLeakAtReturnBugERKN5clang11LangOptionsEb")
  //</editor-fold>
  public CFRefBug /*P*/ getLeakAtReturnBug(final /*const*/ LangOptions /*&*/ LOpts, boolean GCEnabled) /*const*/ {
    if (GCEnabled) {
      if (!leakAtReturnGC.$bool()) {
        leakAtReturnGC.reset(new Leak(this, 
                new StringRef(/*KEEP_STR*/"Leak of returned object when using garbage collection")));
      }
      return leakAtReturnGC.get();
    } else {
      if (!leakAtReturn.$bool()) {
        if (LOpts.getGC() == LangOptions.GCMode.HybridGC) {
          leakAtReturn.reset(new Leak(this, 
                  new StringRef(/*KEEP_STR*/"Leak of returned object when not using garbage collection (GC) in dual GC/non-GC code")));
        } else {
          leakAtReturn.reset(new Leak(this, new StringRef(/*KEEP_STR*/"Leak of returned object")));
        }
      }
      return leakAtReturn.get();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::getSummaryManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2585,
   FQN="(anonymous namespace)::RetainCountChecker::getSummaryManager", NM="_ZNK12_GLOBAL__N_118RetainCountChecker17getSummaryManagerERN5clang10ASTContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker17getSummaryManagerERN5clang10ASTContextEb")
  //</editor-fold>
  public RetainSummaryManager /*&*/ getSummaryManager(final ASTContext /*&*/ Ctx, 
                   boolean GCEnabled) /*const*/ {
    // FIXME: We don't support ARC being turned on and off during one analysis.
    // (nor, for that matter, do we support changing ASTContexts)
    boolean ARCEnabled = (boolean)Ctx.getLangOpts().ObjCAutoRefCount;
    if (GCEnabled) {
      if (!SummariesGC.$bool()) {
        SummariesGC.reset(new RetainSummaryManager(Ctx, true, ARCEnabled));
      } else {
        assert (SummariesGC.$arrow().isARCEnabled() == ARCEnabled);
      }
      return SummariesGC.$star();
    } else {
      if (!Summaries.$bool()) {
        Summaries.reset(new RetainSummaryManager(Ctx, false, ARCEnabled));
      } else {
        assert (Summaries.$arrow().isARCEnabled() == ARCEnabled);
      }
      return Summaries.$star();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::getSummaryManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2605,
   FQN="(anonymous namespace)::RetainCountChecker::getSummaryManager", NM="_ZNK12_GLOBAL__N_118RetainCountChecker17getSummaryManagerERN5clang4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker17getSummaryManagerERN5clang4ento14CheckerContextE")
  //</editor-fold>
  public RetainSummaryManager /*&*/ getSummaryManager(final CheckerContext /*&*/ C) /*const*/ {
    return getSummaryManager(C.getASTContext(), C.isObjCGCEnabled());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::printState">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 3960,
   FQN="(anonymous namespace)::RetainCountChecker::printState", NM="_ZNK12_GLOBAL__N_118RetainCountChecker10printStateERN4llvm11raw_ostreamENS1_18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKcSB_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker10printStateERN4llvm11raw_ostreamENS1_18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKcSB_")
  //</editor-fold>
  @Override public void printState(final raw_ostream /*&*/ Out, IntrusiveRefCntPtr</*const*/ ProgramState> State, 
            /*const*/char$ptr/*char P*/ NL, /*const*/char$ptr/*char P*/ Sep) /*const*//* override*/ {
    ImmutableMapPtrType</*const*/ SymExpr /*P*/ , RefVal> B = null;
    try {
      
      B = State.$arrow().get(ProgramStateTraitRefBindings.$Instance);
      if (B.isEmpty()) {
        return;
      }
      
      Out.$out(Sep).$out(NL);
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , RefVal> I = null;
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , RefVal> E = null;
      try {
        
        for (I = B.begin(), E = B.end(); I.$noteq(E); I.$preInc()) {
          StaticanalyzerLlvmGlobals.$out_raw_ostream_SymExpr$C$P(Out, I.$arrow().first).$out(/*KEEP_STR*/" : ");
          I.$arrow().second.print(Out);
          Out.$out(NL);
        }
      } finally {
        if (E != null) { E.$destroy(); }
        if (I != null) { I.$destroy(); }
      }
    } finally {
      if (B != null) { B.$destroy(); }
    }
  }

  
  
  //===----------------------------------------------------------------------===//
  // Check various ways a symbol can be invalidated.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::checkBind">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 3607,
   FQN="(anonymous namespace)::RetainCountChecker::checkBind", NM="_ZNK12_GLOBAL__N_118RetainCountChecker9checkBindEN5clang4ento4SValES3_PKNS1_4StmtERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker9checkBindEN5clang4ento4SValES3_PKNS1_4StmtERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkBind(SVal loc, SVal val, /*const*/ Stmt /*P*/ S, 
           final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Are we storing to something that causes the value to "escape"?
      boolean escapes = true;
      
      // A value escapes in three possible cases (this may change):
      //
      // (1) we are binding to something that is not a memory region.
      // (2) we are binding to a memregion that does not have stack storage
      // (3) we are binding to a memregion with stack storage that the store
      //     does not understand.
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      {
        
        Optional<NsLoc.MemRegionVal> regionLoc = loc.getAs(NsLoc.MemRegionVal.class);
        if (regionLoc.$bool()) {
          escapes = !regionLoc.$arrow().getRegion().hasStackStorage();
          if (!escapes) {
            // To test (3), generate a new state with the binding added.  If it is
            // the same state, then it escapes (since the store cannot represent
            // the binding).
            // Do this only if we know that the store is not supposed to generate the
            // same state.
            SVal StoredVal = state.$arrow().getSVal(regionLoc.$arrow().getRegion());
            if (StoredVal.$noteq(val)) {
              $c$.clean(escapes = ($eq_IntrusiveRefCntPtr(state, ($c$.track(state.$arrow().bindLoc(new Loc(regionLoc.$star()), new SVal(val)))))));
            }
          }
          if (!escapes) {
            // Case 4: We do not currently model what happens when a symbol is
            // assigned to a struct field, so be conservative here and let the symbol
            // go. TODO: This could definitely be improved upon.
            escapes = !isa_VarRegion(regionLoc.$arrow().getRegion());
          }
        }
      }
      {
        
        // If we are storing the value into an auto function scope variable annotated
        // with (__attribute__((cleanup))), stop tracking the value to avoid leak
        // false positives.
        /*const*/ VarRegion /*P*/ LVR = dyn_cast_or_null_VarRegion(loc.getAsRegion());
        if ((LVR != null)) {
          /*const*/ VarDecl /*P*/ VD = LVR.getDecl();
          if (VD.hasAttr(CleanupAttr.class)) {
            escapes = true;
          }
        }
      }
      
      // If our store can represent the binding and we aren't storing to something
      // that doesn't have local storage then just return and have the simulation
      // state continue as is.
      if (!escapes) {
        return;
      }
      
      // Otherwise, find all symbols referenced by 'val' that we are tracking
      // and stop tracking them.
      $c$.clean(state.$assign($c$.track($c$.track(state.$arrow().scanReachableSymbols$T(StopTrackingCallback.class, new SVal(val))).getState())));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  // end anonymous namespace
  
  //===----------------------------------------------------------------------===//
  // Handle statements that may have an effect on refcounts.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2701,
   FQN="(anonymous namespace)::RetainCountChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_118RetainCountChecker13checkPostStmtEPKN5clang9BlockExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker13checkPostStmtEPKN5clang9BlockExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ BlockExpr /*P*/ BE, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      // Scan the BlockDecRefExprs for any object the retain count checker
      // may be tracking.
      if (!BE.getBlockDecl$Const().hasCaptures()) {
        return;
      }
      
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ BlockDataRegion /*P*/ R = cast_BlockDataRegion(state.$arrow().getSVal(BE, 
    C.getLocationContext()).getAsRegion());
      
      BlockDataRegion.referenced_vars_iterator I = R.referenced_vars_begin();
      BlockDataRegion.referenced_vars_iterator E = R.referenced_vars_end();
      if (I.$eq(E)) {
        return;
      }
      
      // FIXME: For now we invalidate the tracking of all symbols passed to blocks
      // via captured variables, even though captured variables result in a copy
      // and in implicit increment/decrement of a retain count.
      SmallVector</*const*/ MemRegion /*P*/ > Regions/*J*/= new SmallVector</*const*/ MemRegion /*P*/ >(10, (/*const*/ MemRegion /*P*/ )null);
      /*const*/ LocationContext /*P*/ LC = C.getLocationContext();
      final MemRegionManager /*&*/ MemMgr = C.getSValBuilder().getRegionManager();
      
      for (; I.$noteq(E); I.$preInc()) {
        /*const*/ VarRegion /*P*/ VR = I.getCapturedRegion();
        if (VR.getSuperRegion() == R) {
          VR = MemMgr.getVarRegion(VR.getDecl(), LC);
        }
        Regions.push_back(VR);
      }
      
      $c$.clean(state.$assign(
          $c$.track($c$.track(state.$arrow().scanReachableSymbols$T2(StopTrackingCallback.class, Regions.data(), 
              Regions.data().$add(Regions.size()))).getState())
      ));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2741,
   FQN="(anonymous namespace)::RetainCountChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_118RetainCountChecker13checkPostStmtEPKN5clang8CastExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker13checkPostStmtEPKN5clang8CastExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ CastExpr /*P*/ CE, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ ObjCBridgedCastExpr /*P*/ BE = dyn_cast_ObjCBridgedCastExpr(CE);
      if (!(BE != null)) {
        return;
      }
      
      objc_retain.ArgEffect AE = ArgEffect.IncRef;
      switch (BE.getBridgeKind()) {
       case OBC_Bridge:
        // Do nothing.
        return;
       case OBC_BridgeRetained:
        AE = ArgEffect.IncRef;
        break;
       case OBC_BridgeTransfer:
        AE = ArgEffect.DecRefBridgedTransferred;
        break;
      }
      
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ SymExpr /*P*/ Sym = state.$arrow().getSVal(CE, C.getLocationContext()).getAsLocSymbol();
      if (!(Sym != null)) {
        return;
      }
      /*const*/ RefVal /*P*/ T = $c$.clean(RetainCountCheckerStatics.getRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym));
      if (!(T != null)) {
        return;
      }
      
      type$ref<RefVal.Kind> hasErr = create_type$ref(RefVal.Kind.valueOf(0));
      $c$.clean(state.$assign($c$.track(updateSymbol($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym, new RefVal($Deref(T)), AE, hasErr, C))));
      if ((hasErr.$deref().getValue() != 0)) {
        // FIXME: If we get an error during a bridge cast, should we report it?
        return;
      }
      
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2809,
   FQN="(anonymous namespace)::RetainCountChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_118RetainCountChecker13checkPostStmtEPKN5clang16ObjCArrayLiteralERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker13checkPostStmtEPKN5clang16ObjCArrayLiteralERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ ObjCArrayLiteral /*P*/ AL, 
               final CheckerContext /*&*/ C) /*const*/ {
    // Apply the 'MayEscape' to all values.
    processObjCLiterals(C, AL);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2815,
   FQN="(anonymous namespace)::RetainCountChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_118RetainCountChecker13checkPostStmtEPKN5clang21ObjCDictionaryLiteralERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker13checkPostStmtEPKN5clang21ObjCDictionaryLiteralERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ ObjCDictionaryLiteral /*P*/ DL, 
               final CheckerContext /*&*/ C) /*const*/ {
    // Apply the 'MayEscape' to all keys and values.
    processObjCLiterals(C, DL);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2821,
   FQN="(anonymous namespace)::RetainCountChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_118RetainCountChecker13checkPostStmtEPKN5clang13ObjCBoxedExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker13checkPostStmtEPKN5clang13ObjCBoxedExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ ObjCBoxedExpr /*P*/ Ex, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ ExplodedNode /*P*/ Pred = C.getPredecessor();
      /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      {
        
        /*const*/ SymExpr /*P*/ Sym = State.$arrow().getSVal(Ex, LCtx).getAsSymbol();
        if ((Sym != null)) {
          QualType ResultTy = Ex.getType();
          $c$.clean(State.$assign($c$.track(RetainCountCheckerStatics.setRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Sym, 
                  RefVal.makeNotOwned(RetEffect.ObjKind.ObjC, new QualType(ResultTy))))));
        }
      }
      
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2836,
   FQN="(anonymous namespace)::RetainCountChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_118RetainCountChecker13checkPostStmtEPKN5clang15ObjCIvarRefExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker13checkPostStmtEPKN5clang15ObjCIvarRefExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ ObjCIvarRefExpr /*P*/ IRE, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Optional<Loc> IVarLoc = C.getSVal(IRE).getAs(Loc.class);
      if (!IVarLoc.$bool()) {
        return;
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ SymExpr /*P*/ Sym = State.$arrow().getSVal(new Loc(IVarLoc.$star())).getAsSymbol();
      if (!(Sym != null) || !(dyn_cast_or_null_ObjCIvarRegion(Sym.getOriginRegion()) != null)) {
        return;
      }
      
      // Accessing an ivar directly is unusual. If we've done that, be more
      // forgiving about what the surrounding code is allowed to do.
      QualType Ty = Sym.getType();
      RetEffect.ObjKind Kind;
      if (Ty.$arrow().isObjCRetainableType()) {
        Kind = RetEffect.ObjKind.ObjC;
      } else if (coreFoundation.isCFObjectRef(new QualType(Ty))) {
        Kind = RetEffect.ObjKind.CF;
      } else {
        return;
      }
      
      // If the value is already known to be nil, don't bother tracking it.
      final ConstraintManager /*&*/ CMgr = State.$arrow().getConstraintManager();
      if ($c$.clean($c$.track(CMgr.isNull($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Sym)).isConstrainedTrue())) {
        return;
      }
      {
        
        /*const*/ RefVal /*P*/ RV = $c$.clean(RetainCountCheckerStatics.getRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Sym));
        if ((RV != null)) {
          // If we've seen this symbol before, or we're only seeing it now because
          // of something the analyzer has synthesized, don't do anything.
          if (RV.getIvarAccessHistory() != RefVal.IvarAccessHistory.None
             || RetainCountCheckerStatics.isSynthesizedAccessor(C.getStackFrame())) {
            return;
          }
          
          // Note that this value has been loaded from an ivar.
          $c$.clean(C.addTransition($c$.track(RetainCountCheckerStatics.setRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Sym, RV.withIvarAccess()))));
          return;
        }
      }
      
      RefVal PlusZero = RefVal.makeNotOwned(Kind, new QualType(Ty));
      
      // In a synthesized accessor, the effective retain count is +0.
      if (RetainCountCheckerStatics.isSynthesizedAccessor(C.getStackFrame())) {
        $c$.clean(C.addTransition($c$.track(RetainCountCheckerStatics.setRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Sym, new RefVal(PlusZero)))));
        return;
      }
      
      $c$.clean(State.$assign($c$.track(RetainCountCheckerStatics.setRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Sym, PlusZero.withIvarAccess()))));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::checkPostCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2889,
   FQN="(anonymous namespace)::RetainCountChecker::checkPostCall", NM="_ZNK12_GLOBAL__N_118RetainCountChecker13checkPostCallERKN5clang4ento9CallEventERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker13checkPostCallERKN5clang4ento9CallEventERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPostCall(final /*const*/ CallEvent /*&*/ Call, 
               final CheckerContext /*&*/ C) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final RetainSummaryManager /*&*/ Summaries = getSummaryManager(C);
      /*const*/ RetainSummary /*P*/ Summ = $c$.clean(Summaries.getSummary(Call, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState()))));
      if (C.wasInlined) {
        processSummaryOfInlined($Deref(Summ), Call, C);
        return;
      }
      checkSummary($Deref(Summ), Call, C);
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::checkSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 3002,
   FQN="(anonymous namespace)::RetainCountChecker::checkSummary", NM="_ZNK12_GLOBAL__N_118RetainCountChecker12checkSummaryERKNS_13RetainSummaryERKN5clang4ento9CallEventERNS5_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker12checkSummaryERKNS_13RetainSummaryERKN5clang4ento9CallEventERNS5_14CheckerContextE")
  //</editor-fold>
  public void checkSummary(final /*const*/ RetainSummary /*&*/ Summ, 
              final /*const*/ CallEvent /*&*/ CallOrMsg, 
              final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());

      // Evaluate the effect of the arguments.
      type$ref<RefVal.Kind> hasErr = create_type$ref(RefVal.Kind.valueOf(0));
      SourceRange ErrorRange/*J*/= new SourceRange();
      /*const*/ SymExpr /*P*/ ErrorSym = null;

      for (/*uint*/int idx = 0, e = CallOrMsg.getNumArgs(); idx != e; ++idx) {
        SVal V = CallOrMsg.getArgSVal(idx);

        objc_retain.ArgEffect Effect = Summ.getArg(idx);
        if (Effect == ArgEffect.RetainedOutParameter || Effect == ArgEffect.UnretainedOutParameter) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(state.$assign($c$.track(RetainCountCheckerStatics.updateOutParameter($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(V), Effect))));
          } finally {
            $c$.$destroy();
          }
        } else {
          /*const*/ SymExpr /*P*/ Sym = V.getAsLocSymbol();
          if ((Sym != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              {
                /*const*/ RefVal /*P*/ T = $c$.clean(RetainCountCheckerStatics.getRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym));
                if ((T != null)) {
                  $c$.clean(state.$assign($c$.track(updateSymbol($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym, new RefVal($Deref(T)), Effect, hasErr, C))));
                  if ((hasErr.$deref().getValue() != 0)) {
                    ErrorRange.$assignMove(CallOrMsg.getArgSourceRange(idx));
                    ErrorSym = Sym;
                    break;
                  }
                }
              }
            } finally {
              $c$.$destroy();
            }
          }
        }
      }

      // Evaluate the effect on the message receiver.
      boolean ReceiverIsTracked = false;
      if (!(hasErr.$deref().getValue() != 0)) {
        /*const*/ ObjCMethodCall /*P*/ MsgInvocation = dyn_cast_ObjCMethodCall($AddrOf(CallOrMsg));
        if ((MsgInvocation != null)) {
          {
            /*const*/ SymExpr /*P*/ Sym = MsgInvocation.getReceiverSVal().getAsLocSymbol();
            if ((Sym != null)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                {
                  /*const*/ RefVal /*P*/ T = $c$.clean(RetainCountCheckerStatics.getRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym));
                  if ((T != null)) {
                    ReceiverIsTracked = true;
                    $c$.clean(state.$assign($c$.track(updateSymbol($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym, new RefVal($Deref(T)), Summ.getReceiverEffect(), 
                            hasErr, C))));
                    if ((hasErr.$deref().getValue() != 0)) {
                      ErrorRange.$assignMove(MsgInvocation.getOriginExpr().getReceiverRange());
                      ErrorSym = Sym;
                    }
                  }
                }
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      }

      // Process any errors.
      if ((hasErr.$deref().getValue() != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          processNonLeakError($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SourceRange(ErrorRange), hasErr.$deref(), ErrorSym, C); $c$.clean();
          return;
        } finally {
          $c$.$destroy();
        }
      }

      // Consult the summary for the return value.
      objc_retain.RetEffect RE = Summ.getRetEffect();
      if (RE.getKind() == RetEffect.Kind.OwnedWhenTrackedReceiver) {
        if (ReceiverIsTracked) {
          RE.$assignMove(getSummaryManager(C).getObjAllocRetEffect());
        } else {
          RE.$assignMove(RetEffect.MakeNoRet());
        }
      }
      switch (RE.getKind()) {
       default:
        throw new llvm_unreachable("Unhandled RetEffect.");
       case NoRet:
       case NoRetHard:
        // No work necessary.
        break;
       case OwnedAllocatedSymbol:
       case OwnedSymbol:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*const*/ SymExpr /*P*/ Sym = CallOrMsg.getReturnValue().getAsSymbol();
            if (!(Sym != null)) {
              break;
            }

            // Use the result type from the CallEvent as it automatically adjusts
            // for methods/functions that return references.
            QualType ResultTy = CallOrMsg.getResultType();
            $c$.clean(state.$assign($c$.track(RetainCountCheckerStatics.setRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym, RefVal.makeOwned(RE.getObjKind(), 
                        new QualType(ResultTy))))));

            // FIXME: Add a flag to the checker where allocations are assumed to
            // *not* fail.
            break;
          } finally {
            $c$.$destroy();
          }
        }
       case GCNotOwnedSymbol:
       case NotOwnedSymbol:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*const*/ Expr /*P*/ Ex = CallOrMsg.getOriginExpr();
            /*const*/ SymExpr /*P*/ Sym = CallOrMsg.getReturnValue().getAsSymbol();
            if (!(Sym != null)) {
              break;
            }
            assert Native.$bool(Ex);
            // Use GetReturnType in order to give [NSFoo alloc] the type NSFoo *.
            QualType ResultTy = RetainCountCheckerStatics.GetReturnType(Ex, C.getASTContext());
            $c$.clean(state.$assign($c$.track(RetainCountCheckerStatics.setRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym, RefVal.makeNotOwned(RE.getObjKind(), 
                        new QualType(ResultTy))))));
            break;
          } finally {
            $c$.$destroy();
          }
        }
      }

      // This check is actually necessary; otherwise the statement builder thinks
      // we've hit a previously-found path.
      // Normally addTransition takes care of this, but we want the node pointer.
      ExplodedNode /*P*/ NewNode;
      if ($eq_IntrusiveRefCntPtr(state, C.getState())) {
        NewNode = C.getPredecessor();
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(NewNode = C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
        } finally {
          $c$.$destroy();
        }
      }

      // Annotate the node with summary we used.
      if ((NewNode != null)) {
        // FIXME: This is ugly. See checkEndAnalysis for why it's necessary.
        if (ShouldResetSummaryLog) {
          SummaryLog.clear();
          ShouldResetSummaryLog = false;
        }
        SummaryLog.$set(NewNode, $AddrOf(Summ));
      }
    } finally {
     if (state != null) { state.$destroy(); }
    } 
  }

  
  
  // We don't always get the exact modeling of the function with regards to the
  // retain count checker even when the function is inlined. For example, we need
  // to stop tracking the symbols which were marked with StopTrackingHard.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::processSummaryOfInlined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2932,
   FQN="(anonymous namespace)::RetainCountChecker::processSummaryOfInlined", NM="_ZNK12_GLOBAL__N_118RetainCountChecker23processSummaryOfInlinedERKNS_13RetainSummaryERKN5clang4ento9CallEventERNS5_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker23processSummaryOfInlinedERKNS_13RetainSummaryERKN5clang4ento9CallEventERNS5_14CheckerContextE")
  //</editor-fold>
  public void processSummaryOfInlined(final /*const*/ RetainSummary /*&*/ Summ, 
                         final /*const*/ CallEvent /*&*/ CallOrMsg, 
                         final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      
      // Evaluate the effect of the arguments.
      for (/*uint*/int idx = 0, e = CallOrMsg.getNumArgs(); idx != e; ++idx) {
        if (Summ.getArg(idx) == ArgEffect.StopTrackingHard) {
          SVal V = CallOrMsg.getArgSVal(idx);
          {
            /*const*/ SymExpr /*P*/ Sym = V.getAsLocSymbol();
            if ((Sym != null)) {
              $c$.clean(state.$assign($c$.track(RetainCountCheckerStatics.removeRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym))));
            }
          }
        }
      }
      
      // Evaluate the effect on the message receiver.
      /*const*/ ObjCMethodCall /*P*/ MsgInvocation = dyn_cast_ObjCMethodCall($AddrOf(CallOrMsg));
      if ((MsgInvocation != null)) {
        {
          /*const*/ SymExpr /*P*/ Sym = MsgInvocation.getReceiverSVal().getAsLocSymbol();
          if ((Sym != null)) {
            if (Summ.getReceiverEffect() == ArgEffect.StopTrackingHard) {
              $c$.clean(state.$assign($c$.track(RetainCountCheckerStatics.removeRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym))));
            }
          }
        }
      }
      
      // Consult the summary for the return value.
      objc_retain.RetEffect RE = Summ.getRetEffect();
      if (RE.getKind() == RetEffect.Kind.NoRetHard) {
        /*const*/ SymExpr /*P*/ Sym = CallOrMsg.getReturnValue().getAsSymbol();
        if ((Sym != null)) {
          $c$.clean(state.$assign($c$.track(RetainCountCheckerStatics.removeRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym))));
        }
      }
      
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  
  
  //===----------------------------------------------------------------------===//
  // Handle the return values of retain-count-related functions.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::evalCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 3345,
   FQN="(anonymous namespace)::RetainCountChecker::evalCall", NM="_ZNK12_GLOBAL__N_118RetainCountChecker8evalCallEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker8evalCallEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public boolean evalCall(/*const*/ CallExpr /*P*/ CE, final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Get the callee. We're only interested in simple C functions.
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ FunctionDecl /*P*/ FD = C.getCalleeDecl(CE);
      if (!(FD != null)) {
        return false;
      }
      
      IdentifierInfo /*P*/ II = FD.getIdentifier();
      if (!(II != null)) {
        return false;
      }
      
      // For now, we're only handling the functions that return aliases of their
      // arguments: CFRetain and CFMakeCollectable (and their families).
      // Eventually we should add other functions we can model entirely,
      // such as CFRelease, which don't invalidate their arguments or globals.
      if (CE.getNumArgs() != 1) {
        return false;
      }
      
      // Get the name of the function.
      StringRef FName = II.getName();
      FName.$assignMove(FName.substr(FName.find_first_not_of($$UNDERSCORE)));
      
      // See if it's one of the specific functions we know how to eval.
      boolean canEval = false;
      
      QualType ResultTy = CE.getCallReturnType(C.getASTContext());
      if (ResultTy.$arrow().isObjCIdType()) {
        // Handle: id NSMakeCollectable(CFTypeRef)
        canEval = II.isStr(/*KEEP_STR*/"NSMakeCollectable");
      } else if (ResultTy.$arrow().isPointerType()) {
        // Handle: (CF|CG)Retain
        //         CFAutorelease
        //         CFMakeCollectable
        // It's okay to be a little sloppy here (CGMakeCollectable doesn't exist).
        if (cocoa.isRefType(new QualType(ResultTy), new StringRef(/*KEEP_STR*/"CF"), new StringRef(FName))
           || cocoa.isRefType(new QualType(ResultTy), new StringRef(/*KEEP_STR*/"CG"), new StringRef(FName))) {
          canEval = RetainCountCheckerStatics.isRetain(FD, new StringRef(FName)) || RetainCountCheckerStatics.isAutorelease(FD, new StringRef(FName))
             || RetainCountCheckerStatics.isMakeCollectable(FD, new StringRef(FName));
        }
      }
      if (!canEval) {
        return false;
      }
      
      // Bind the return value.
      /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
      SVal RetVal = state.$arrow().getSVal(CE.getArg$Const(0), LCtx);
      if (RetVal.isUnknown$SVal()) {
        // If the receiver is unknown, conjure a return value.
        final SValBuilder /*&*/ SVB = C.getSValBuilder();
        RetVal.$assignMove(SVB.conjureSymbolVal((/*const*/Object/*void P*/ )null, CE, LCtx, new QualType(ResultTy), C.blockCount()));
      }
      $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(CE, LCtx, new SVal(RetVal), false))));
      {
        
        // FIXME: This should not be necessary, but otherwise the argument seems to be
        // considered alive during the next statement.
        /*const*/ MemRegion /*P*/ ArgRegion = RetVal.getAsRegion();
        if ((ArgRegion != null)) {
          // Save the refcount status of the argument.
          /*const*/ SymExpr /*P*/ Sym = RetVal.getAsLocSymbol();
          /*const*/ RefVal /*P*/ Binding = null;
          if ((Sym != null)) {
            $c$.clean(Binding = RetainCountCheckerStatics.getRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym));
          }
          
          // Invalidate the argument region.
          $c$.clean(state.$assign($c$.track(state.$arrow().invalidateRegions_ArrayRef1(new ArrayRef</*const*/ MemRegion /*P*/ >(ArgRegion, true), CE, C.blockCount(), LCtx, 
                  /*CausesPointerEscape*/ false))));
          
          // Restore the refcount status of the argument.
          if ((Binding != null)) {
            $c$.clean(state.$assign($c$.track(RetainCountCheckerStatics.setRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym, new RefVal($Deref(Binding))))));
          }
        }
      }
      
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
      return true;
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::evalAssume">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 3663,
   FQN="(anonymous namespace)::RetainCountChecker::evalAssume", NM="_ZNK12_GLOBAL__N_118RetainCountChecker10evalAssumeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS4_4SValEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker10evalAssumeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS4_4SValEb")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> evalAssume(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
            SVal Cond, 
            boolean Assumption) /*const*/ {
    ImmutableMapPtrType</*const*/ SymExpr /*P*/ , RefVal> B = null;
    try {
      // FIXME: We may add to the interface of evalAssume the list of symbols
      //  whose assumptions have changed.  For now we just iterate through the
      //  bindings and check if any of the tracked symbols are NULL.  This isn't
      //  too bad since the number of symbols we will track in practice are
      //  probably small and evalAssume is only called at branches and a few
      //  other places.
      B = state.$arrow().get(ProgramStateTraitRefBindings.$Instance);
      if (B.isEmpty()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
      }
      
      boolean changed = false;
      final ImmutableMapPtrType.Factory</*const*/ SymExpr /*P*/ , RefVal> /*&*/ RefBFactory = state.$arrow().get_context(ProgramStateTraitRefBindings.$Instance);
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , RefVal> I = null;
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , RefVal> E = null;
      try {
        
        for (I = B.begin(), E = B.end(); I.$noteq(E); I.$preInc()) {
          ConditionTruthVal AllocFailed = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Check if the symbol is null stop tracking the symbol.
            final ConstraintManager /*&*/ CMgr = state.$arrow().getConstraintManager();
            AllocFailed = $c$.clean(CMgr.isNull($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), I.getKey()));
            if (AllocFailed.isConstrainedTrue()) {
              changed = true;
              $c$.clean(B.$assign($c$.track(RefBFactory.remove($c$.track(new ImmutableMapPtrType</*const*/ SymExpr /*P*/ , RefVal>(B)), I.getKey()))));
            }
          } finally {
            if (AllocFailed != null) { AllocFailed.$destroy(); }
            $c$.$destroy();
          }
        }
      } finally {
        if (E != null) { E.$destroy(); }
        if (I != null) { I.$destroy(); }
      }
      if (changed) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(state.$assign($c$.track(state.$arrow().set(ProgramStateTraitRefBindings.$Instance, $c$.track(new ImmutableMapPtrType</*const*/ SymExpr /*P*/ , RefVal>(B))))));
        } finally {
          $c$.$destroy();
        }
      }
      
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
    } finally {
      if (B != null) { B.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::checkRegionChanges">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 3696,
   FQN="(anonymous namespace)::RetainCountChecker::checkRegionChanges", NM="_ZNK12_GLOBAL__N_118RetainCountChecker18checkRegionChangesEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS1_8DenseSetIPKNS4_7SymExprENS1_12DenseMapInfoISB_EEEENS1_8ArrayRefIPKNS4_9MemRegionEEESL_PKNS4_9CallEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker18checkRegionChangesEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS1_8DenseSetIPKNS4_7SymExprENS1_12DenseMapInfoISB_EEEENS1_8ArrayRefIPKNS4_9MemRegionEEESL_PKNS4_9CallEventE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> checkRegionChanges(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                    /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*P*/ invalidated, 
                    ArrayRef</*const*/ MemRegion /*P*/ > ExplicitRegions, 
                    ArrayRef</*const*/ MemRegion /*P*/ > Regions, 
                    /*const*/ CallEvent /*P*/ Call) /*const*/ {
    if (!(invalidated != null)) {
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
    }
    
    SmallPtrSet</*const*/ SymExpr /*P*/ > WhitelistedSymbols/*J*/= new SmallPtrSet</*const*/ SymExpr /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    for (type$ptr</*const*/ MemRegion /*P*/ /*P*/> I = $tryClone(ExplicitRegions.begin()), 
        /*P*/ E = $tryClone(ExplicitRegions.end()); $noteq_ptr(I, E); I.$preInc()) {
      {
        /*const*/ SymbolicRegion /*P*/ SR = (I.$star()).StripCasts().getAs(SymbolicRegion.class);
        if ((SR != null)) {
          WhitelistedSymbols.insert(SR.getSymbol());
        }
      }
    }
    
    for (DenseSet.iterator<SymExpr> I = invalidated.begin$Const(), 
        E = invalidated.end$Const(); I.$noteq(E); I.$preInc()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*const*/ SymExpr /*P*/ sym = I.$star();
        if ((WhitelistedSymbols.count(sym) != 0)) {
          continue;
        }
        // Remove any existing reference-count binding.
        $c$.clean(state.$assign($c$.track(RetainCountCheckerStatics.removeRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), sym))));
      } finally {
        $c$.$destroy();
      }
    }
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::wantsRegionChangeUpdate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2643,
   FQN="(anonymous namespace)::RetainCountChecker::wantsRegionChangeUpdate", NM="_ZNK12_GLOBAL__N_118RetainCountChecker23wantsRegionChangeUpdateEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker23wantsRegionChangeUpdateEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEE")
  //</editor-fold>
  public boolean wantsRegionChangeUpdate(IntrusiveRefCntPtr</*const*/ ProgramState> state) /*const*/ {
    return true;
  }

  

  //===----------------------------------------------------------------------===//
  // Handle return statements.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*AutoreleaseTag is context dependent*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 3425,
   FQN="(anonymous namespace)::RetainCountChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_118RetainCountChecker12checkPreStmtEPKN5clang10ReturnStmtERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker12checkPreStmtEPKN5clang10ReturnStmtERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ ReturnStmt /*P*/ S, 
              final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      // Only adjust the reference count if this is the top-level call frame,
      // and not the result of inlining.  In the future, we should do
      // better checking even for inlined calls, and see if they match
      // with their expected semantics (e.g., the method should return a retained
      // object, etc.).
      if (!C.inTopFrame()) {
        return;
      }
      
      /*const*/ Expr /*P*/ RetE = S.getRetValue$Const();
      if (!(RetE != null)) {
        return;
      }
      
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ SymExpr /*P*/ Sym = state.$arrow().getSValAsScalarOrLoc(RetE, C.getLocationContext()).getAsLocSymbol();
      if (!(Sym != null)) {
        return;
      }
      
      // Get the reference count binding (if any).
      /*const*/ RefVal /*P*/ T = $c$.clean(RetainCountCheckerStatics.getRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym));
      if (!(T != null)) {
        return;
      }
      
      // Change the reference count.
      RefVal X = new RefVal($Deref(T));
      switch (X.getKind()) {
       case Owned:
        {
          /*uint*/int cnt = X.getCount();
          assert ($greater_uint(cnt, 0));
          X.setCount(cnt - 1);
          X.$assignMove(X.$bitxor(/*KEEP_ENUM*/RefVal.Kind.ReturnedOwned));
          break;
        }
       case NotOwned:
        {
          /*uint*/int cnt = X.getCount();
          if ((cnt != 0)) {
            X.setCount(cnt - 1);
            X.$assignMove(X.$bitxor(/*KEEP_ENUM*/RefVal.Kind.ReturnedOwned));
          } else {
            X.$assignMove(X.$bitxor(/*KEEP_ENUM*/RefVal.Kind.ReturnedNotOwned));
          }
          break;
        }
       default:
        return;
      }
      
      // Update the binding.
      $c$.clean(state.$assign($c$.track(RetainCountCheckerStatics.setRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym, new RefVal(X)))));
      ExplodedNode /*P*/ Pred = $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
      
      // At this point we have updated the state properly.
      // Everything after this is merely checking to see if the return value has
      // been over- or under-retained.
      
      // Did we cache out?
      if (!(Pred != null)) {
        return;
      }
      
      // Update the autorelease counts.
      // JAVA: need to use accessor
      final/*static*/ CheckerProgramPointTag AutoreleaseTag = checkPreStmt$$.AutoreleaseTag();
      $c$.clean(state.$assign($c$.track(handleAutoreleaseCounts($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Pred, $AddrOf(AutoreleaseTag), C, Sym, new RefVal(X)))));
      
      // Did we cache out?
      if (!state.$bool()) {
        return;
      }
      
      // Get the updated binding.
      $c$.clean(T = RetainCountCheckerStatics.getRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym));
      assert /*JAVA*/(T != null);
      X.$assign($Deref(T));
      
      // Consult the summary of the enclosing method.
      final RetainSummaryManager /*&*/ Summaries = getSummaryManager(C);
      /*const*/ Decl /*P*/ CD = $AddrOf(Pred.getCodeDecl());
      objc_retain.RetEffect RE = RetEffect.MakeNoRet();
      {
        
        // FIXME: What is the convention for blocks? Is there one?
        /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(CD);
        if ((MD != null)) {
          /*const*/ RetainSummary /*P*/ Summ = Summaries.getMethodSummary(MD);
          RE.$assignMove(Summ.getRetEffect());
        } else {
          /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(CD);
          if ((FD != null)) {
            if (!isa_CXXMethodDecl(FD)) {
              /*const*/ RetainSummary /*P*/ Summ = Summaries.getFunctionSummary(FD);
              RE.$assignMove(Summ.getRetEffect());
            }
          }
        }
      }
      
      checkReturnWithRetEffect(S, C, Pred, new objc_retain.RetEffect(RE), new RefVal(X), Sym, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))); $c$.clean();
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }
  // MANUAL: moved below in extra members
//  private static final class checkPreStmt$$ {
//    // JAVA: must not be static
//    // JAVA: can not initialize statically since "this" is used in initialisation
//    final static /*static*/ CheckerProgramPointTag AutoreleaseTag = new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"Autorelease"));; 
//  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::checkReturnWithRetEffect">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION/*Tags are context dependent*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 3523,
   FQN="(anonymous namespace)::RetainCountChecker::checkReturnWithRetEffect", NM="_ZNK12_GLOBAL__N_118RetainCountChecker24checkReturnWithRetEffectEPKN5clang10ReturnStmtERNS1_4ento14CheckerContextEPNS5_12ExplodedNodeENS5_11objc_retain9RetEffectENS_6RefValEPKNS5_7SymExprEN4llvm18IntrusiveRefCntPtrIKNS5_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker24checkReturnWithRetEffectEPKN5clang10ReturnStmtERNS1_4ento14CheckerContextEPNS5_12ExplodedNodeENS5_11objc_retain9RetEffectENS_6RefValEPKNS5_7SymExprEN4llvm18IntrusiveRefCntPtrIKNS5_12ProgramStateEEE")
  //</editor-fold>
  public void checkReturnWithRetEffect(/*const*/ ReturnStmt /*P*/ S, 
                          final CheckerContext /*&*/ C, 
                          ExplodedNode /*P*/ Pred, 
                          objc_retain.RetEffect RE, RefVal X, 
                          /*const*/ SymExpr /*P*/ Sym, 
                          IntrusiveRefCntPtr</*const*/ ProgramState> state) /*const*/ {
    // HACK: Ignore retain-count issues on values accessed through ivars,
    // because of cases like this:
    //   [_contentView retain];
    //   [_contentView removeFromSuperview];
    //   [self addSubview:_contentView]; // invalidates 'self'
    //   [_contentView release];
    if (X.getIvarAccessHistory() != RefVal.IvarAccessHistory.None) {
      return;
    }
    
    // Any leaks or other errors?
    if (X.isReturnedOwned() && X.getCount() == 0) {
      if (RE.getKind() != RetEffect.Kind.NoRet) {
        boolean hasError = false;
        if (C.isObjCGCEnabled() && RE.getObjKind() == RetEffect.ObjKind.ObjC) {
          // Things are more complicated with garbage collection.  If the
          // returned object is suppose to be an Objective-C object, we have
          // a leak (as the caller expects a GC'ed object) because no
          // method should return ownership unless it returns a CF object.
          hasError = true;
          X.$assignMove(X.$bitxor(/*KEEP_ENUM*/RefVal.Kind.ErrorGCLeakReturned));
        } else if (!RE.isOwned()) {
          // Either we are using GC and the returned object is a CF type
          // or we aren't using GC.  In either case, we expect that the
          // enclosing method is expected to return ownership.
          hasError = true;
          X.$assignMove(X.$bitxor(/*KEEP_ENUM*/RefVal.Kind.ErrorLeakReturned));
        }
        if (hasError) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Generate an error node.
            $c$.clean(state.$assign($c$.track(RetainCountCheckerStatics.setRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym, new RefVal(X)))));
            // JAVA: need to use accessor
            final/*static*/ CheckerProgramPointTag ReturnOwnLeakTag = checkReturnWithRetEffect$$.ReturnOwnLeakTag();
            ExplodedNode /*P*/ N = $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Pred, $AddrOf(ReturnOwnLeakTag)));
            if ((N != null)) {
              final /*const*/ LangOptions /*&*/ LOpts = C.getASTContext().getLangOpts();
              boolean GCEnabled = C.isObjCGCEnabled();
              C.emitReport($c$.track(new std.unique_ptr<BugReport>(new CFRefLeakReport($Deref(getLeakAtReturnBug(LOpts, GCEnabled)), LOpts, GCEnabled, 
                          SummaryLog, N, Sym, C, IncludeAllocationLine)))); $c$.clean();
            }
          } finally {
            $c$.$destroy();
          }
        }
      }
    } else if (X.isReturnedNotOwned()) {
      if (RE.isOwned()) {
        if (X.getIvarAccessHistory()
           == RefVal.IvarAccessHistory.AccessedDirectly) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Assume the method was trying to transfer a +1 reference from a
            // strong ivar to the caller.
            $c$.clean(state.$assign($c$.track(RetainCountCheckerStatics.setRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym, 
                    X.releaseViaIvar().$bitxor(/*KEEP_ENUM*/RefVal.Kind.ReturnedOwned)))));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Trying to return a not owned object to a caller expecting an
            // owned object.
            $c$.clean(state.$assign($c$.track(RetainCountCheckerStatics.setRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym, X.$bitxor(/*KEEP_ENUM*/RefVal.Kind.ErrorReturnedNotOwned)))));

            // JAVA: need to use accessor
            final/*static*/ CheckerProgramPointTag ReturnNotOwnedTag = checkReturnWithRetEffect$$.ReturnNotOwnedTag();
            
            ExplodedNode /*P*/ N = $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Pred, $AddrOf(ReturnNotOwnedTag)));
            if ((N != null)) {
              if (!returnNotOwnedForOwned.$bool()) {
                returnNotOwnedForOwned.reset(new ReturnedNotOwnedForOwned(this));
              }
              
              C.emitReport($c$.track(new std.unique_ptr<BugReport>(new CFRefReport(returnNotOwnedForOwned.$star(), C.getASTContext().getLangOpts(), 
                          C.isObjCGCEnabled(), SummaryLog, N, Sym)))); $c$.clean();
            }
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  // MANUAL: moved below in extra members
//  private static final class checkReturnWithRetEffect$$ {
//    // JAVA: must not be static
//    // JAVA: can not initialize statically since "this" is used in initialisation
//    final static /*static*/ CheckerProgramPointTag ReturnOwnLeakTag/*J*/= new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"ReturnsOwnLeak"));
//    final static /*static*/ CheckerProgramPointTag ReturnNotOwnedTag/*J*/= new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"ReturnNotOwnedForOwned"));
//  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::checkDeadSymbols">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 3909,
   FQN="(anonymous namespace)::RetainCountChecker::checkDeadSymbols", NM="_ZNK12_GLOBAL__N_118RetainCountChecker16checkDeadSymbolsERN5clang4ento12SymbolReaperERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker16checkDeadSymbolsERN5clang4ento12SymbolReaperERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkDeadSymbols(final SymbolReaper /*&*/ SymReaper, 
                  final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    ImmutableMapPtrType</*const*/ SymExpr /*P*/ , RefVal> B = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ExplodedNode /*P*/ Pred = C.getPredecessor();
      
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      B = state.$arrow().get(ProgramStateTraitRefBindings.$Instance);
      SmallVector</*const*/ SymExpr /*P*/ > Leaked/*J*/= new SmallVector</*const*/ SymExpr /*P*/ >(10, (/*const*/ SymExpr /*P*/ )null);
      
      // Update counts from autorelease pools
      for (DenseSet.iterator<SymExpr> I = SymReaper.dead_begin(), 
          E = SymReaper.dead_end(); I.$noteq(E); I.$preInc()) {
        /*const*/ SymExpr /*P*/ Sym = I.$star();
        {
          /*const*/ type$ptr<RefVal> /*P*/ T = B.lookup(Sym);
          if ((T != null)) {
            // Use the symbol as the tag.
            // FIXME: This might not be as unique as we would like.
            /*const*/ ProgramPointTag /*P*/ Tag = getDeadSymbolTag(Sym);
            $c$.clean(state.$assign($c$.track(handleAutoreleaseCounts($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Pred, Tag, C, Sym, new RefVal($Deref(T))))));
            if (!state.$bool()) {
              return;
            }
            
            // Fetch the new reference count from the state, and use it to handle
            // this symbol.
            $c$.clean(state.$assign($c$.track(handleSymbolDeath($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), I.$star(), new RefVal($Deref(RetainCountCheckerStatics.getRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym))), Leaked))));
          }
        }
      }
      if (Leaked.empty()) {
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
        return;
      }
      
      $c$.clean(Pred = processLeaks($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Leaked, C, Pred));
      
      // Did we cache out?
      if (!(Pred != null)) {
        return;
      }
      
      // Now generate a new node that nukes the old bindings.
      // The only bindings left at this point are the leaked symbols.
      final ImmutableMapPtrType.Factory</*const*/ SymExpr /*P*/ , RefVal> /*&*/ F = state.$arrow().get_context(ProgramStateTraitRefBindings.$Instance);
      $c$.clean(B.$assign($c$.track(state.$arrow().get(ProgramStateTraitRefBindings.$Instance))));
      
      for (type$ptr</*const*/ SymExpr /*P*/ /*P*/> I = $tryClone(Leaked.begin()), 
          /*P*/ E = $tryClone(Leaked.end());
           $noteq_ptr(I, E); I.$preInc())  {
        $c$.clean(B.$assign($c$.track(F.remove($c$.track(new ImmutableMapPtrType</*const*/ SymExpr /*P*/ , RefVal>(B)), I.$star()))));
      }
      
      $c$.clean(state.$assign($c$.track(state.$arrow().set(ProgramStateTraitRefBindings.$Instance, $c$.track(new ImmutableMapPtrType</*const*/ SymExpr /*P*/ , RefVal>(B))))));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Pred));
    } finally {
      if (B != null) { B.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::checkEndFunction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 3861,
   FQN="(anonymous namespace)::RetainCountChecker::checkEndFunction", NM="_ZNK12_GLOBAL__N_118RetainCountChecker16checkEndFunctionERN5clang4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker16checkEndFunctionERN5clang4ento14CheckerContextE")
  //</editor-fold>
  public void checkEndFunction(final CheckerContext /*&*/ Ctx) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    ImmutableMapPtrType</*const*/ SymExpr /*P*/ , RefVal> B = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Ctx.getState());
      B = state.$arrow().get(ProgramStateTraitRefBindings.$Instance);
      ExplodedNode /*P*/ Pred = Ctx.getPredecessor();
      
      // Don't process anything within synthesized bodies.
      /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
      if (LCtx.getAnalysisDeclContext().isBodyAutosynthesized()) {
        assert Native.$bool(LCtx.getParent());
        return;
      }
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , RefVal> I = null;
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , RefVal> E = null;
      try {
        
        for (I = B.begin(), E = B.end(); I.$noteq(E); I.$preInc()) {
          $c$.clean(state.$assign($c$.track(handleAutoreleaseCounts($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Pred, /*Tag=*/ (/*const*/ ProgramPointTag /*P*/ )null, Ctx, 
                  I.$arrow().first, new RefVal(I.$arrow().second)))));
          if (!state.$bool()) {
            return;
          }
        }
      } finally {
        if (E != null) { E.$destroy(); }
        if (I != null) { I.$destroy(); }
      }
      
      // If the current LocationContext has a parent, don't check for leaks.
      // We will do that later.
      // FIXME: we should instead check for imbalances of the retain/releases,
      // and suggest annotations.
      if ((LCtx.getParent() != null)) {
        return;
      }
      
      $c$.clean(B.$assign($c$.track(state.$arrow().get(ProgramStateTraitRefBindings.$Instance))));
      SmallVector</*const*/ SymExpr /*P*/ > Leaked/*J*/= new SmallVector</*const*/ SymExpr /*P*/ >(10, (/*const*/ SymExpr /*P*/ )null);
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , RefVal> I2 = null;
      ImmutableMapPtrType.iterator</*const*/ SymExpr /*P*/ , RefVal> E2 = null;
      try {
        
        for (I2 = B.begin(), E2 = B.end(); I2.$noteq(E2); I2.$preInc())  {
          $c$.clean(state.$assign($c$.track(handleSymbolDeath($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), I2.$arrow().first, new RefVal(I2.$arrow().second), Leaked))));
        }
      } finally {
        if (E2 != null) { E2.$destroy(); }
        if (I2 != null) { I2.$destroy(); }
      }
      
      $c$.clean(processLeaks($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Leaked, Ctx, Pred));
    } finally {
      if (B != null) { B.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::updateSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 3127,
   FQN="(anonymous namespace)::RetainCountChecker::updateSymbol", NM="_ZNK12_GLOBAL__N_118RetainCountChecker12updateSymbolEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprENS_6RefValENS4_11objc_retain9ArgEffectERNSB_4KindERNS4_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker12updateSymbolEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprENS_6RefValENS4_11objc_retain9ArgEffectERNSB_4KindERNS4_14CheckerContextE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> updateSymbol(IntrusiveRefCntPtr</*const*/ ProgramState> state, /*const*/ SymExpr /*P*/ sym, 
              RefVal V, objc_retain.ArgEffect E, final type$ref<RefVal.Kind /*&*/> hasErr, 
              final CheckerContext /*&*/ C) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // In GC mode [... release] and [... retain] do nothing.
      // In ARC mode they shouldn't exist at all, but we just ignore them.
      boolean IgnoreRetainMsg = C.isObjCGCEnabled();
      if (!IgnoreRetainMsg) {
        IgnoreRetainMsg = (boolean)C.getASTContext().getLangOpts().ObjCAutoRefCount;
      }
      switch (E) {
       default:
        break;
       case IncRefMsg:
        E = IgnoreRetainMsg ? ArgEffect.DoNothing : ArgEffect.IncRef;
        break;
       case DecRefMsg:
        E = IgnoreRetainMsg ? ArgEffect.DoNothing : ArgEffect.DecRef;
        break;
       case DecRefMsgAndStopTrackingHard:
        E = IgnoreRetainMsg ? ArgEffect.StopTracking : ArgEffect.DecRefAndStopTrackingHard;
        break;
       case MakeCollectable:
        E = C.isObjCGCEnabled() ? ArgEffect.DecRef : ArgEffect.DoNothing;
        break;
      }
      
      // Handle all use-after-releases.
      if (!C.isObjCGCEnabled() && V.getKind() == RefVal.Kind.Released) {
        V.$assignMove(V.$bitxor(/*KEEP_ENUM*/RefVal.Kind.ErrorUseAfterRelease));
        hasErr.$set(V.getKind());
        return $c$.clean(RetainCountCheckerStatics.setRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), sym, new RefVal(V)));
      }
      switch (E) {
       case DecRefMsg:
       case IncRefMsg:
       case MakeCollectable:
       case DecRefMsgAndStopTrackingHard:
        throw new llvm_unreachable("DecRefMsg/IncRefMsg/MakeCollectable already converted");
       case UnretainedOutParameter:
       case RetainedOutParameter:
        throw new llvm_unreachable("Applies to pointer-to-pointer parameters, which should not have ref state.");
       case Dealloc:
        // Any use of -dealloc in GC is *bad*.
        if (C.isObjCGCEnabled()) {
          V.$assignMove(V.$bitxor(/*KEEP_ENUM*/RefVal.Kind.ErrorDeallocGC));
          hasErr.$set(V.getKind());
          break;
        }
        switch (V.getKind()) {
         default:
          throw new llvm_unreachable("Invalid RefVal state for an explicit dealloc.");
         case Owned:
          // The object immediately transitions to the released state.
          V.$assignMove(V.$bitxor(/*KEEP_ENUM*/RefVal.Kind.Released));
          V.clearCounts();
          return $c$.clean(RetainCountCheckerStatics.setRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), sym, new RefVal(V)));
         case NotOwned:
          V.$assignMove(V.$bitxor(/*KEEP_ENUM*/RefVal.Kind.ErrorDeallocNotOwned));
          hasErr.$set(V.getKind());
          break;
        }
        break;
       case MayEscape:
        if (V.getKind() == RefVal.Kind.Owned) {
          V.$assignMove(V.$bitxor(/*KEEP_ENUM*/RefVal.Kind.NotOwned));
          break;
        }
       case DoNothing:
        
        // Fall-through.
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
       case Autorelease:
        if (C.isObjCGCEnabled()) {
          return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
        }
        // Update the autorelease counts.
        V.$assignMove(V.autorelease());
        break;
       case StopTracking:
       case StopTrackingHard:
        return $c$.clean(RetainCountCheckerStatics.removeRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), sym));
       case IncRef:
        switch (V.getKind()) {
         default:
          throw new llvm_unreachable("Invalid RefVal state for a retain.");
         case Owned:
         case NotOwned:
          V.$assignMove(V.$add(1));
          break;
         case Released:
          // Non-GC cases are handled above.
          assert (C.isObjCGCEnabled());
          V.$assignMove((V.$bitxor(/*KEEP_ENUM*/RefVal.Kind.Owned)).$add(1));
          break;
        }
        break;
       case DecRef:
       case DecRefBridgedTransferred:
       case DecRefAndStopTrackingHard:
        switch (V.getKind()) {
         default:
          // case 'RefVal::Released' handled above.
          throw new llvm_unreachable("Invalid RefVal state for a release.");
         case Owned:
          assert ($greater_uint(V.getCount(), 0));
          if (V.getCount() == 1) {
            if (E == ArgEffect.DecRefBridgedTransferred
               || V.getIvarAccessHistory()
               == RefVal.IvarAccessHistory.AccessedDirectly) {
              V.$assignMove(V.$bitxor(/*KEEP_ENUM*/RefVal.Kind.NotOwned));
            } else {
              V.$assignMove(V.$bitxor(/*KEEP_ENUM*/RefVal.Kind.Released));
            }
          } else if (E == ArgEffect.DecRefAndStopTrackingHard) {
            return $c$.clean(RetainCountCheckerStatics.removeRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), sym));
          }
          
          V.$assignMove(V.$sub(1));
          break;
         case NotOwned:
          if ($greater_uint(V.getCount(), 0)) {
            if (E == ArgEffect.DecRefAndStopTrackingHard) {
              return $c$.clean(RetainCountCheckerStatics.removeRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), sym));
            }
            V.$assignMove(V.$sub(1));
          } else if (V.getIvarAccessHistory()
             == RefVal.IvarAccessHistory.AccessedDirectly) {
            // Assume that the instance variable was holding on the object at
            // +1, and we just didn't know.
            if (E == ArgEffect.DecRefAndStopTrackingHard) {
              return $c$.clean(RetainCountCheckerStatics.removeRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), sym));
            }
            V.$assignMove(V.releaseViaIvar().$bitxor(/*KEEP_ENUM*/RefVal.Kind.Released));
          } else {
            V.$assignMove(V.$bitxor(/*KEEP_ENUM*/RefVal.Kind.ErrorReleaseNotOwned));
            hasErr.$set(V.getKind());
          }
          break;
         case Released:
          // Non-GC cases are handled above.
          assert (C.isObjCGCEnabled());
          V.$assignMove(V.$bitxor(/*KEEP_ENUM*/RefVal.Kind.ErrorUseAfterRelease));
          hasErr.$set(V.getKind());
          break;
        }
        break;
      }
      return $c$.clean(RetainCountCheckerStatics.setRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), sym, new RefVal(V)));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::processNonLeakError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 3288,
   FQN="(anonymous namespace)::RetainCountChecker::processNonLeakError", NM="_ZNK12_GLOBAL__N_118RetainCountChecker19processNonLeakErrorEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS3_11SourceRangeENS_6RefVal4KindEPKNS4_7SymExprERNS4_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker19processNonLeakErrorEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS3_11SourceRangeENS_6RefVal4KindEPKNS4_7SymExprERNS4_14CheckerContextE")
  //</editor-fold>
  public void processNonLeakError(IntrusiveRefCntPtr</*const*/ ProgramState> St, 
                     SourceRange ErrorRange, 
                     RefVal.Kind ErrorKind, 
                     /*const*/ SymExpr /*P*/ Sym, 
                     final CheckerContext /*&*/ C) /*const*/ {
    unique_ptr<BugReport> report = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      {
        // HACK: Ignore retain-count issues on values accessed through ivars,
        // because of cases like this:
        //   [_contentView retain];
        //   [_contentView removeFromSuperview];
        //   [self addSubview:_contentView]; // invalidates 'self'
        //   [_contentView release];
        /*const*/ RefVal /*P*/ RV = $c$.clean(RetainCountCheckerStatics.getRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), Sym));
        if ((RV != null)) {
          if (RV.getIvarAccessHistory() != RefVal.IvarAccessHistory.None) {
            return;
          }
        }
      }
      
      ExplodedNode /*P*/ N = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St))));
      if (!(N != null)) {
        return;
      }
      
      CFRefBug /*P*/ BT;
      switch (ErrorKind) {
       default:
        throw new llvm_unreachable("Unhandled error.");
       case ErrorUseAfterRelease:
        if (!useAfterRelease.$bool()) {
          useAfterRelease.reset(new UseAfterRelease(this));
        }
        BT = useAfterRelease.get();
        break;
       case ErrorReleaseNotOwned:
        if (!releaseNotOwned.$bool()) {
          releaseNotOwned.reset(new BadRelease(this));
        }
        BT = releaseNotOwned.get();
        break;
       case ErrorDeallocGC:
        if (!deallocGC.$bool()) {
          deallocGC.reset(new DeallocGC(this));
        }
        BT = deallocGC.get();
        break;
       case ErrorDeallocNotOwned:
        if (!deallocNotOwned.$bool()) {
          deallocNotOwned.reset(new DeallocNotOwned(this));
        }
        BT = deallocNotOwned.get();
        break;
      }
      assert Native.$bool(BT);
      report = new std.unique_ptr<BugReport>(new CFRefReport($Deref(BT), C.getASTContext().getLangOpts(), C.isObjCGCEnabled(), 
              SummaryLog, N, Sym));
      report.$arrow().addRange(new SourceRange(ErrorRange));
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
    } finally {
      if (report != null) { report.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::processObjCLiterals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2780,
   FQN="(anonymous namespace)::RetainCountChecker::processObjCLiterals", NM="_ZNK12_GLOBAL__N_118RetainCountChecker19processObjCLiteralsERN5clang4ento14CheckerContextEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker19processObjCLiteralsERN5clang4ento14CheckerContextEPKNS1_4ExprE")
  //</editor-fold>
  public void processObjCLiterals(final CheckerContext /*&*/ C, 
                     /*const*/ Expr /*P*/ Ex) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ ExplodedNode /*P*/ pred = C.getPredecessor();
      for (/*const*/ Stmt /*P*/ Child : Ex.children$Const()) {
        SVal V = state.$arrow().getSVal(Child, pred.getLocationContext());
        {
          /*const*/ SymExpr /*P*/ sym = V.getAsSymbol();
          if ((sym != null)) {
            {
              /*const*/ RefVal /*P*/ T = $c$.clean(RetainCountCheckerStatics.getRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), sym));
              if ((T != null)) {
                type$ref<RefVal.Kind> hasErr = create_type$ref(RefVal.Kind.valueOf(0));
                $c$.clean(state.$assign($c$.track(updateSymbol($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), sym, new RefVal($Deref(T)), ArgEffect.MayEscape, hasErr, C))));
                if ((hasErr.$deref().getValue() != 0)) {
                  processNonLeakError($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Child.getSourceRange(), hasErr.$deref(), sym, C); $c$.clean();
                  return;
                }
              }
            }
          }
        }
      }
      {
        
        // Return the object as autoreleased.
        //  RetEffect RE = RetEffect::MakeNotOwned(RetEffect::ObjC);
        /*const*/ SymExpr /*P*/ sym = state.$arrow().getSVal(Ex, pred.getLocationContext()).getAsSymbol();
        if ((sym != null)) {
          QualType ResultTy = Ex.getType();
          $c$.clean(state.$assign($c$.track(RetainCountCheckerStatics.setRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), sym, 
                  RefVal.makeNotOwned(RetEffect.ObjKind.ObjC, new QualType(ResultTy))))));
        }
      }
      
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::getDeadSymbolTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 3896,
   FQN="(anonymous namespace)::RetainCountChecker::getDeadSymbolTag", NM="_ZNK12_GLOBAL__N_118RetainCountChecker16getDeadSymbolTagEPKN5clang4ento7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker16getDeadSymbolTagEPKN5clang4ento7SymExprE")
  //</editor-fold>
  public /*const*/ ProgramPointTag /*P*/ getDeadSymbolTag(/*const*/ SymExpr /*P*/ sym) /*const*/ {
    final type$ref</*const*/ CheckerProgramPointTag /*P*/ /*&*/> tag = DeadSymbolTags.ref$at(sym);
    if (!(tag.$deref() != null)) {
      raw_svector_ostream out = null;
      try {
        SmallString/*<64>*/ buf/*J*/= new SmallString/*<64>*/(64);
        out/*J*/= new raw_svector_ostream(buf);
        out.$out(/*KEEP_STR*/"Dead Symbol : ");
        sym.dumpToStream(out);
        tag.$set(new CheckerProgramPointTag(this, out.str()));
      } finally {
        if (out != null) { out.$destroy(); }
      }
    }
    return tag.$deref();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::handleSymbolDeath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 3806,
   FQN="(anonymous namespace)::RetainCountChecker::handleSymbolDeath", NM="_ZNK12_GLOBAL__N_118RetainCountChecker17handleSymbolDeathEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprENS_6RefValERNS1_15SmallVectorImplISA_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker17handleSymbolDeathEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_7SymExprENS_6RefValERNS1_15SmallVectorImplISA_EE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> handleSymbolDeath(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                   /*const*/ SymExpr /*P*/ sid, RefVal V, 
                   final SmallVectorImpl</*const*/ SymExpr /*P*/ > /*&*/ Leaked) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      boolean hasLeak;
      
      // HACK: Ignore retain-count issues on values accessed through ivars,
      // because of cases like this:
      //   [_contentView retain];
      //   [_contentView removeFromSuperview];
      //   [self addSubview:_contentView]; // invalidates 'self'
      //   [_contentView release];
      if (V.getIvarAccessHistory() != RefVal.IvarAccessHistory.None) {
        hasLeak = false;
      } else if (V.isOwned()) {
        hasLeak = true;
      } else if (V.isNotOwned() || V.isReturnedOwned()) {
        hasLeak = ($greater_uint(V.getCount(), 0));
      } else {
        hasLeak = false;
      }
      if (!hasLeak) {
        return $c$.clean(RetainCountCheckerStatics.removeRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), sid));
      }
      
      Leaked.push_back(sid);
      return $c$.clean(RetainCountCheckerStatics.setRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), sid, V.$bitxor(/*KEEP_ENUM*/RefVal.Kind.ErrorLeak)));
    } finally {
      $c$.$destroy();
    }
  }

  
  
  //===----------------------------------------------------------------------===//
  // Handle dead symbols and end-of-path.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::handleAutoreleaseCounts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 3727,
   FQN="(anonymous namespace)::RetainCountChecker::handleAutoreleaseCounts", NM="_ZNK12_GLOBAL__N_118RetainCountChecker23handleAutoreleaseCountsEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPNS4_12ExplodedNodeEPKNS3_15ProgramPointTagERNS4_14CheckerContextEPKNS4_7SymExprENS_6RefValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker23handleAutoreleaseCountsEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPNS4_12ExplodedNodeEPKNS3_15ProgramPointTagERNS4_14CheckerContextEPKNS4_7SymExprENS_6RefValE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> handleAutoreleaseCounts(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                         ExplodedNode /*P*/ Pred, 
                         /*const*/ ProgramPointTag /*P*/ Tag, 
                         final CheckerContext /*&*/ Ctx, 
                         /*const*/ SymExpr /*P*/ Sym, RefVal V) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*uint*/int ACnt = V.getAutoreleaseCount();
      
      // No autorelease counts?  Nothing to be done.
      if (!(ACnt != 0)) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
      }
      assert (!Ctx.isObjCGCEnabled()) : "Autorelease counts in GC mode?";
      /*uint*/int Cnt = V.getCount();
      
      // FIXME: Handle sending 'autorelease' to already released object.
      if (V.getKind() == RefVal.Kind.ReturnedOwned) {
        ++Cnt;
      }
      
      // If we would over-release here, but we know the value came from an ivar,
      // assume it was a strong ivar that's just been relinquished.
      if ($greater_uint(ACnt, Cnt)
         && V.getIvarAccessHistory() == RefVal.IvarAccessHistory.AccessedDirectly) {
        V.$assignMove(V.releaseViaIvar());
        --ACnt;
      }
      if ($lesseq_uint(ACnt, Cnt)) {
        if (ACnt == Cnt) {
          V.clearCounts();
          if (V.getKind() == RefVal.Kind.ReturnedOwned) {
            V.$assignMove(V.$bitxor(/*KEEP_ENUM*/RefVal.Kind.ReturnedNotOwned));
          } else {
            V.$assignMove(V.$bitxor(/*KEEP_ENUM*/RefVal.Kind.NotOwned));
          }
        } else {
          V.setCount(V.getCount() - ACnt);
          V.setAutoreleaseCount(0);
        }
        return $c$.clean(RetainCountCheckerStatics.setRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym, new RefVal(V)));
      }
      
      // HACK: Ignore retain-count issues on values accessed through ivars,
      // because of cases like this:
      //   [_contentView retain];
      //   [_contentView removeFromSuperview];
      //   [self addSubview:_contentView]; // invalidates 'self'
      //   [_contentView release];
      if (V.getIvarAccessHistory() != RefVal.IvarAccessHistory.None) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
      }
      
      // Woah!  More autorelease counts then retain counts left.
      // Emit hard error.
      V.$assignMove(V.$bitxor(/*KEEP_ENUM*/RefVal.Kind.ErrorOverAutorelease));
      $c$.clean(state.$assign($c$.track(RetainCountCheckerStatics.setRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym, new RefVal(V)))));
      
      ExplodedNode /*P*/ N = $c$.clean(Ctx.generateSink($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Pred, Tag));
      if ((N != null)) {
        raw_svector_ostream os = null;
        try {
          SmallString/*<128>*/ sbuf/*J*/= new SmallString/*<128>*/(128);
          os/*J*/= new raw_svector_ostream(sbuf);
          os.$out(/*KEEP_STR*/"Object was autoreleased ");
          if ($greater_uint(V.getAutoreleaseCount(), 1)) {
            os.$out_uint(V.getAutoreleaseCount()).$out(/*KEEP_STR*/" times but the object ");
          } else {
            os.$out(/*KEEP_STR*/"but ");
          }
          os.$out(/*KEEP_STR*/"has a +").$out_uint(V.getCount()).$out(/*KEEP_STR*/" retain count");
          if (!overAutorelease.$bool()) {
            overAutorelease.reset(new OverAutorelease(this));
          }
          
          final /*const*/ LangOptions /*&*/ LOpts = Ctx.getASTContext().getLangOpts();
          Ctx.emitReport($c$.track(new std.unique_ptr<BugReport>(new CFRefReport(overAutorelease.$star(), LOpts, /* GCEnabled = */ false, 
                      SummaryLog, N, Sym, os.str())))); $c$.clean();
        } finally {
          if (os != null) { os.$destroy(); }
        }
      }
      
      return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainCountChecker::processLeaks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 3834,
   FQN="(anonymous namespace)::RetainCountChecker::processLeaks", NM="_ZNK12_GLOBAL__N_118RetainCountChecker12processLeaksEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERNS1_15SmallVectorImplIPKNS4_7SymExprEEERNS4_14CheckerContextEPNS4_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_118RetainCountChecker12processLeaksEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERNS1_15SmallVectorImplIPKNS4_7SymExprEEERNS4_14CheckerContextEPNS4_12ExplodedNodeE")
  //</editor-fold>
  public ExplodedNode /*P*/ processLeaks(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
              final SmallVectorImpl</*const*/ SymExpr /*P*/ > /*&*/ Leaked, 
              final CheckerContext /*&*/ Ctx) /*const*/ {
    return processLeaks(state, 
              Leaked, 
              Ctx, 
              (ExplodedNode /*P*/ )null);
  }
  public ExplodedNode /*P*/ processLeaks(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
              final SmallVectorImpl</*const*/ SymExpr /*P*/ > /*&*/ Leaked, 
              final CheckerContext /*&*/ Ctx, 
              ExplodedNode /*P*/ Pred/*= null*/) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Generate an intermediate node representing the leak point.
      ExplodedNode /*P*/ N = $c$.clean(Ctx.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Pred));
      if ((N != null)) {
        for (type$ptr</*const*/ SymExpr /*P*/ /*P*/> I = $tryClone(Leaked.begin()), /*P*/ E = $tryClone(Leaked.end()); $noteq_ptr(I, E); I.$preInc()) {
          
          final /*const*/ LangOptions /*&*/ LOpts = Ctx.getASTContext().getLangOpts();
          boolean GCEnabled = Ctx.isObjCGCEnabled();
          CFRefBug /*P*/ BT = (Pred != null) ? getLeakWithinFunctionBug(LOpts, GCEnabled) : getLeakAtReturnBug(LOpts, GCEnabled);
          assert ((BT != null)) : "BugType not initialized.";
          
          Ctx.emitReport($c$.track(new std.unique_ptr<BugReport>(new CFRefLeakReport($Deref(BT), LOpts, GCEnabled, SummaryLog, N, I.$star(), Ctx,
                      IncludeAllocationLine)))); $c$.clean();
        }
      }
      
      return N;
    } finally {
      $c$.$destroy();
    }
   }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public void $checkPreStmt(Stmt stmt, CheckerContext C) { if (stmt instanceof ReturnStmt) { checkPreStmt((ReturnStmt) stmt, C); } }
  
  @Override public void $checkPostStmt(Stmt stmt, CheckerContext C) { if (stmt instanceof BlockExpr) { checkPostStmt((BlockExpr) stmt, C); } else if (stmt instanceof CastExpr) { checkPostStmt((CastExpr) stmt, C); } else if (stmt instanceof ObjCArrayLiteral) { checkPostStmt((ObjCArrayLiteral) stmt, C); } else if (stmt instanceof ObjCDictionaryLiteral) { checkPostStmt((ObjCDictionaryLiteral) stmt, C); } else if (stmt instanceof ObjCDictionaryLiteral) { checkPostStmt((ObjCDictionaryLiteral) stmt, C); } else if (stmt instanceof ObjCIvarRefExpr) { checkPostStmt((ObjCIvarRefExpr) stmt, C); } }

  private final CheckBase $CHECKS[] = {
    new Bind(),
    new DeadSymbols(),
    new EndAnalysis(),
    new EndFunction(),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<BlockExpr>(BlockExpr.class),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<CastExpr>(CastExpr.class),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCArrayLiteral>(ObjCArrayLiteral.class),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCDictionaryLiteral>(ObjCDictionaryLiteral.class),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCBoxedExpr>(ObjCBoxedExpr.class),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCIvarRefExpr>(ObjCIvarRefExpr.class),
    new PostCall(),
    new org.clang.staticanalyzer.core.ento.check.PreStmt<ReturnStmt>(ReturnStmt.class),
    new RegionChanges(),
    new eval.Assume(),
    new eval.Call()
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }

  // MANUAL: we need to remove static but keep delay of initialization
  private static final class checkPreStmt$$ {
    private final RetainCountChecker $this;
    private checkPreStmt$$(RetainCountChecker owner) {
      this.$this = owner;
    }   
    // JAVA: must not be static!
    CheckerProgramPointTag $AutoreleaseTag;// = new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"Autorelease"));
    
    CheckerProgramPointTag AutoreleaseTag() {
      if ($AutoreleaseTag == null) {
        $AutoreleaseTag/*J*/ = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"Autorelease"));
      }
      return $AutoreleaseTag;
    }
  }
  private final checkPreStmt$$ checkPreStmt$$ = new checkPreStmt$$(this);
  
  private static final class checkReturnWithRetEffect$$ {
    private final RetainCountChecker $this;
    private checkReturnWithRetEffect$$(RetainCountChecker owner) {
      this.$this = owner;
    }       
    // JAVA: must not be static
    // JAVA: can not initialize statically since "this" is used in initialisation
    /*static*/ CheckerProgramPointTag $ReturnOwnLeakTag/*J*/;//= new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"ReturnsOwnLeak"));
    /*static*/ CheckerProgramPointTag $ReturnNotOwnedTag/*J*/;//= new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"ReturnNotOwnedForOwned"));
    CheckerProgramPointTag ReturnOwnLeakTag() {
      if ($ReturnOwnLeakTag == null) {
        $ReturnOwnLeakTag/*J*/ = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"ReturnsOwnLeak"));
      }
      return $ReturnOwnLeakTag;
    }  
    
    CheckerProgramPointTag ReturnNotOwnedTag() {
      if ($ReturnNotOwnedTag == null) {
        $ReturnNotOwnedTag/*J*/ = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"ReturnNotOwnedForOwned"));
      }
      return $ReturnNotOwnedTag;
    }    
  }
  private final checkReturnWithRetEffect$$ checkReturnWithRetEffect$$ = new checkReturnWithRetEffect$$(this);
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "useAfterRelease=" + useAfterRelease // NOI18N
              + ", releaseNotOwned=" + releaseNotOwned // NOI18N
              + ", deallocGC=" + deallocGC // NOI18N
              + ", deallocNotOwned=" + deallocNotOwned // NOI18N
              + ", overAutorelease=" + overAutorelease // NOI18N
              + ", returnNotOwnedForOwned=" + returnNotOwnedForOwned // NOI18N
              + ", leakWithinFunction=" + leakWithinFunction // NOI18N
              + ", leakAtReturn=" + leakAtReturn // NOI18N
              + ", leakWithinFunctionGC=" + leakWithinFunctionGC // NOI18N
              + ", leakAtReturnGC=" + leakAtReturnGC // NOI18N
              + ", DeadSymbolTags=" + DeadSymbolTags // NOI18N
              + ", Summaries=" + "[Unique_ptr$RetainSummaryManager]" // NOI18N
              + ", SummariesGC=" + "[Unique_ptr$RetainSummaryManager]" // NOI18N
              + ", SummaryLog=" + SummaryLog // NOI18N
              + ", ShouldResetSummaryLog=" + ShouldResetSummaryLog // NOI18N
              + ", IncludeAllocationLine=" + IncludeAllocationLine // NOI18N
              + super.toString(); // NOI18N
  }
}
