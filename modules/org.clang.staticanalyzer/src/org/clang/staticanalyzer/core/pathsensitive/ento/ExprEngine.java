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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
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
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.impl.*;
import org.clang.staticanalyzer.core.impl.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import org.clang.analysis.domainspecific.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.analysis.java.AnalysisRTTI.*;
import static org.clang.staticanalyzer.core.impl.ExprEngineStatics.*;
import static org.clang.staticanalyzer.core.impl.ExprEngineCXXStatics.canHaveDirectConstructor;
import static org.clang.staticanalyzer.core.impl.ExprEngineCXXStatics.makeZeroElementRegion;
import static org.clang.staticanalyzer.core.impl.ExprEngineCallAndReturnStatics.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import org.clang.staticanalyzer.checkers.ento.EntoGlobals;

//<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 48,
 FQN="clang::ento::ExprEngine", NM="_ZN5clang4ento10ExprEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngineE")
//</editor-fold>
public class ExprEngine extends /*public*/ SubEngine implements Destructors.ClassWithDestructor {
/*public:*/
  /// The modes of inlining, which override the default analysis-wide settings.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::InliningModes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 51,
   FQN="clang::ento::ExprEngine::InliningModes", NM="_ZN5clang4ento10ExprEngine13InliningModesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine13InliningModesE")
  //</editor-fold>
  public static final class/*enum*/ InliningModes {
    /// Follow the default settings for inlining callees.
    public static final /*uint*/int Inline_Regular = 0;
    /// Do minimal inlining of callees.
    public static final /*uint*/int Inline_Minimal = 0x1;
  };
/*private:*/
  private final AnalysisManager /*&*/ AMgr;
  
  private final AnalysisDeclContextManager /*&*/ AnalysisDeclContexts;
  
  private CoreEngine Engine;
  
  /// G - the simulation graph.
  private final ExplodedGraph /*&*/ G;
  
  /// StateMgr - Object that manages the data for all created states.
  private ProgramStateManager StateMgr;
  
  /// SymMgr - Object that manages the symbol information.
  private final SymbolManager /*&*/ SymMgr;
  
  /// svalBuilder - SValBuilder object that creates SVals from expressions.
  private final SValBuilder /*&*/ svalBuilder;
  
  private /*uint*/int currStmtIdx; // JAVA: see currStmtIdx$ref
  private /*const*/ NodeBuilderContext /*P*/ currBldrCtx; // JAVA: see currBldrCtx$ref
  
  /// Helper object to determine if an Objective-C message expression
  /// implicitly never returns.
  private ObjCNoReturn ObjCNoRet;
  
  /// Whether or not GC is enabled in this analysis.
  private boolean ObjCGCEnabled;
  
  /// The BugReporter associated with this engine.  It is important that
  ///  this object be placed at the very end of member variables so that its
  ///  destructor is called before the rest of the ExprEngine is destroyed.
  private GRBugReporter BR;
  
  /// The functions which have been analyzed through inlining. This is owned by
  /// AnalysisConsumer. It can be null.
  private DenseSet</*const*/ Decl /*P*/ > /*P*/ VisitedCallees;
  
  /// The flag, which specifies the mode of inlining for the engine.
  private /*InliningModes*//*uint*/int HowToInline;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::ExprEngine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 71,
   FQN="clang::ento::ExprEngine::ExprEngine", NM="_ZN5clang4ento10ExprEngineC1ERNS0_15AnalysisManagerEbPN4llvm8DenseSetIPKNS_4DeclENS4_12DenseMapInfoIS8_EEEEPNS0_19FunctionSummariesTyENS1_13InliningModesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngineC1ERNS0_15AnalysisManagerEbPN4llvm8DenseSetIPKNS_4DeclENS4_12DenseMapInfoIS8_EEEEPNS0_19FunctionSummariesTyENS1_13InliningModesE")
  //</editor-fold>
  public ExprEngine(final AnalysisManager /*&*/ mgr, boolean gcEnabled, 
      DenseSet</*const*/ Decl /*P*/ > /*P*/ VisitedCalleesIn, 
      FunctionSummariesTy /*P*/ FS, 
      /*InliningModes*//*uint*/int HowToInlineIn) {
    // : SubEngine(), AMgr(mgr), AnalysisDeclContexts(mgr.getAnalysisDeclContextManager()), Engine(*this, FS), G(Engine.getGraph()), StateMgr(getContext(), mgr.getStoreManagerCreator(), mgr.getConstraintManagerCreator(), G.getAllocator(), this), SymMgr(StateMgr.getSymbolManager()), svalBuilder(StateMgr.getSValBuilder()), currStmtIdx(0), currBldrCtx(null), ObjCNoRet(mgr.getASTContext()), ObjCGCEnabled(gcEnabled), BR(mgr, *this), VisitedCallees(VisitedCalleesIn), HowToInline(HowToInlineIn) 
    //START JInit
    super();
    this./*&*/AMgr=/*&*/mgr;
    this./*&*/AnalysisDeclContexts=/*&*/mgr.getAnalysisDeclContextManager();
    this.Engine = new CoreEngine(/*Deref*/this, FS);
    this./*&*/G=/*&*/Engine.getGraph();
    this.StateMgr = new ProgramStateManager(getContext(), mgr.getStoreManagerCreator(), 
        mgr.getConstraintManagerCreator(), G.getAllocator(), 
        this);
    this./*&*/SymMgr=/*&*/StateMgr.getSymbolManager();
    this./*&*/svalBuilder=/*&*/StateMgr.getSValBuilder();
    this.currStmtIdx = 0;
    this.currBldrCtx = null;
    this.ObjCNoRet = new ObjCNoReturn(mgr.getASTContext());
    this.ObjCGCEnabled = gcEnabled;
    this.BR = new GRBugReporter(mgr, /*Deref*/this);
    this.VisitedCallees = VisitedCalleesIn;
    this.HowToInline = HowToInlineIn;
    //END JInit
    /*uint*/int TrimInterval = mgr.options.getGraphTrimInterval();
    if (TrimInterval != 0) {
      // Enable eager node reclaimation when constructing the ExplodedGraph.
      G.enableNodeReclamation(TrimInterval);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::~ExprEngine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 97,
   FQN="clang::ento::ExprEngine::~ExprEngine", NM="_ZN5clang4ento10ExprEngineD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngineD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    BR.FlushReports();
    //START JDestroy
    BR.$destroy();
    StateMgr.$destroy();
    Engine.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  /// Returns true if there is still simulation state on the worklist.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::ExecuteWorkList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 108,
   FQN="clang::ento::ExprEngine::ExecuteWorkList", NM="_ZN5clang4ento10ExprEngine15ExecuteWorkListEPKNS_15LocationContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine15ExecuteWorkListEPKNS_15LocationContextEj")
  //</editor-fold>
  public boolean ExecuteWorkList(/*const*/ LocationContext /*P*/ L) {
    return ExecuteWorkList(L, 150000);
  }
  public boolean ExecuteWorkList(/*const*/ LocationContext /*P*/ L, /*uint*/int Steps/*= 150000*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(Engine.ExecuteWorkList(L, Steps, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null))));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Execute the work list with an initial state. Nodes that reaches the exit
  /// of the function are added into the Dst set, which represent the exit
  /// state of the function call. Returns true if there is still simulation
  /// state on the worklist.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::ExecuteWorkListWithInitialState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 116,
   FQN="clang::ento::ExprEngine::ExecuteWorkListWithInitialState", NM="_ZN5clang4ento10ExprEngine31ExecuteWorkListWithInitialStateEPKNS_15LocationContextEjN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine31ExecuteWorkListWithInitialStateEPKNS_15LocationContextEjN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public boolean ExecuteWorkListWithInitialState(/*const*/ LocationContext /*P*/ L, /*uint*/int Steps, 
                                 IntrusiveRefCntPtr</*const*/ ProgramState> InitState, 
                                 final ExplodedNodeSet /*&*/ Dst) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(Engine.ExecuteWorkListWithInitialState(L, Steps, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(InitState)), Dst));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// getContext - Return the ASTContext associated with this analysis.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 123,
   FQN="clang::ento::ExprEngine::getContext", NM="_ZNK5clang4ento10ExprEngine10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento10ExprEngine10getContextEv")
  //</editor-fold>
  public ASTContext /*&*/ getContext() /*const*/ {
    return AMgr.getASTContext();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::getAnalysisManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 125,
   FQN="clang::ento::ExprEngine::getAnalysisManager", NM="_ZN5clang4ento10ExprEngine18getAnalysisManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine18getAnalysisManagerEv")
  //</editor-fold>
  @Override public AnalysisManager /*&*/ getAnalysisManager()/* override*/ {
    return AMgr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::getCheckerManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 127,
   FQN="clang::ento::ExprEngine::getCheckerManager", NM="_ZNK5clang4ento10ExprEngine17getCheckerManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento10ExprEngine17getCheckerManagerEv")
  //</editor-fold>
  public CheckerManager /*&*/ getCheckerManager() /*const*/ {
    return $Deref(AMgr.getCheckerManager());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::getSValBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 131,
   FQN="clang::ento::ExprEngine::getSValBuilder", NM="_ZN5clang4ento10ExprEngine14getSValBuilderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine14getSValBuilderEv")
  //</editor-fold>
  public SValBuilder /*&*/ getSValBuilder() {
    return svalBuilder;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::getBugReporter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 133,
   FQN="clang::ento::ExprEngine::getBugReporter", NM="_ZN5clang4ento10ExprEngine14getBugReporterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine14getBugReporterEv")
  //</editor-fold>
  public BugReporter /*&*/ getBugReporter() {
    return BR;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::getBuilderContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 135,
   FQN="clang::ento::ExprEngine::getBuilderContext", NM="_ZN5clang4ento10ExprEngine17getBuilderContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine17getBuilderContextEv")
  //</editor-fold>
  public /*const*/ NodeBuilderContext /*&*/ getBuilderContext() {
    assert Native.$bool(currBldrCtx);
    return $Deref(currBldrCtx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::isObjCGCEnabled">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 140,
   FQN="clang::ento::ExprEngine::isObjCGCEnabled", NM="_ZN5clang4ento10ExprEngine15isObjCGCEnabledEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine15isObjCGCEnabledEv")
  //</editor-fold>
  public boolean isObjCGCEnabled() {
    return ObjCGCEnabled;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::getStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 142,
   FQN="clang::ento::ExprEngine::getStmt", NM="_ZNK5clang4ento10ExprEngine7getStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento10ExprEngine7getStmtEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getStmt() /*const*/ {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::GenerateAutoTransition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 144,
   FQN="clang::ento::ExprEngine::GenerateAutoTransition", NM="_ZN5clang4ento10ExprEngine22GenerateAutoTransitionEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine22GenerateAutoTransitionEPNS0_12ExplodedNodeE")
  //</editor-fold>
  public void GenerateAutoTransition(ExplodedNode /*P*/ N) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::enqueueEndOfPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 145,
   FQN="clang::ento::ExprEngine::enqueueEndOfPath", NM="_ZN5clang4ento10ExprEngine16enqueueEndOfPathERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine16enqueueEndOfPathERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void enqueueEndOfPath(final ExplodedNodeSet /*&*/ S) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::GenerateCallExitNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 146,
   FQN="clang::ento::ExprEngine::GenerateCallExitNode", NM="_ZN5clang4ento10ExprEngine20GenerateCallExitNodeEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine20GenerateCallExitNodeEPNS0_12ExplodedNodeE")
  //</editor-fold>
  public void GenerateCallExitNode(ExplodedNode /*P*/ N) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  /// Visualize the ExplodedGraph created by executing the simulation.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::ViewGraph">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2766,
   FQN="clang::ento::ExprEngine::ViewGraph", NM="_ZN5clang4ento10ExprEngine9ViewGraphEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine9ViewGraphEb")
  //</editor-fold>
  public void ViewGraph() {
    ViewGraph(false);
  }
  public void ViewGraph(boolean trim/*= false*/) {
    if (trim) {
      std.vector</*const*/ ExplodedNode /*P*/ > Src = null;
      try {
        Src/*J*/= new std.vector</*const*/ ExplodedNode /*P*/ >((/*const*/ ExplodedNode /*P*/ )null);
        
        // Flush any outstanding reports to make sure we cover all the nodes.
        // This does not cause them to get displayed.
        for (ImutAVLValueIteratorPtrBoolPtr<BugType /*P*/ > I = BR.begin(), E = BR.end(); I.$noteq(E); I.$preInc())  {
          ((/*const_cast*/BugType /*P*/ )(I.$star())).FlushReports(BR);
        }
        
        // Iterate through the reports and get their nodes.
        for (FoldingSetIterator<BugReportEquivClass> EI = BR.EQClasses_begin(), EE = BR.EQClasses_end(); EI.$noteq(EE); EI.$preInc()) {
          ExplodedNode /*P*/ N = ((/*const_cast*/ExplodedNode /*P*/ )(EI.$arrow().begin().$arrow().getErrorNode()));
          if ((N != null)) {
            Src.push_back_T$RR(N);
          }
        }
        
        ViewGraph(new ArrayRef</*const*/ ExplodedNode /*P*/ >(Src, true));
      } finally {
        if (Src != null) { Src.$destroy(); }
      }
    } else {
      GraphPrintCheckerState = this;
      GraphPrintSourceManager = $AddrOf(getContext().getSourceManager());
      
      AdtsupportLlvmGlobals.ViewGraph(G.roots_begin().$star(), new Twine(/*KEEP_STR*/"ExprEngine"));
      
      GraphPrintCheckerState = null;
      GraphPrintSourceManager = null;
    }
  }

  
  /// Visualize a trimmed ExplodedGraph that only contains paths to the given
  /// nodes.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::ViewGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2797,
   FQN="clang::ento::ExprEngine::ViewGraph", NM="_ZN5clang4ento10ExprEngine9ViewGraphEN4llvm8ArrayRefIPKNS0_12ExplodedNodeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine9ViewGraphEN4llvm8ArrayRefIPKNS0_12ExplodedNodeEEE")
  //</editor-fold>
  public void ViewGraph(ArrayRef</*const*/ ExplodedNode /*P*/ > Nodes) {
    std.unique_ptr<ExplodedGraph> TrimmedG = null;
    try {
      GraphPrintCheckerState = this;
      GraphPrintSourceManager = $AddrOf(getContext().getSourceManager());
      
      TrimmedG/*J*/= G.trim(new ArrayRef</*const*/ ExplodedNode /*P*/ >(Nodes));
      if (!(TrimmedG.get() != null)) {
        llvm.errs().$out(/*KEEP_STR*/"warning: Trimmed ExplodedGraph is empty.\n");
      } else {
        AdtsupportLlvmGlobals.ViewGraph(TrimmedG.$arrow().roots_begin().$star(), new Twine(/*KEEP_STR*/"TrimmedExprEngine"));
      }
      
      GraphPrintCheckerState = null;
      GraphPrintSourceManager = null;
    } finally {
      if (TrimmedG != null) { TrimmedG.$destroy(); }
    }
  }

  
  /// getInitialState - Return the initial state used for the root vertex
  ///  in the ExplodedGraph.
  
  //===----------------------------------------------------------------------===//
  // Utility methods.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::getInitialState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 105,
   FQN="clang::ento::ExprEngine::getInitialState", NM="_ZN5clang4ento10ExprEngine15getInitialStateEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine15getInitialStateEPKNS_15LocationContextE")
  //</editor-fold>
  @Override public IntrusiveRefCntPtr</*const*/ ProgramState> getInitialState(/*const*/ LocationContext /*P*/ InitLoc)/* override*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    try {
      state = StateMgr.getInitialState(InitLoc);
      /*const*/ Decl /*P*/ D = InitLoc.getDecl();
      
      // Preconditions.
      // FIXME: It would be nice if we had a more general mechanism to add
      // such preconditions.  Some day.
      do {
        {
          
          /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
          if ((FD != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // Precondition: the first argument of 'main' is an integer guaranteed
              //  to be > 0.
              /*const*/ IdentifierInfo /*P*/ II = FD.getIdentifier();
              if (!(II != null) || !($eq_StringRef(II.getName(), /*STRINGREF_STR*/"main") && $greater_uint(FD.getNumParams(), 0))) {
                break;
              }
              
              /*const*/ ParmVarDecl /*P*/ PD = FD.getParamDecl$Const(0);
              QualType T = PD.getType();
              /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(T);
              if (!(BT != null) || !BT.isInteger()) {
                break;
              }
              
              /*const*/ MemRegion /*P*/ R = state.$arrow().getRegion(PD, InitLoc);
              if (!(R != null)) {
                break;
              }
              
              SVal V = state.$arrow().getSVal(new Loc(JD$Move.INSTANCE, new NsLoc.MemRegionVal(R)));
              SVal Constraint_untested = $c$.clean(evalBinOp($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_GT, new SVal(V), 
                  new SVal(JD$Move.INSTANCE, svalBuilder.makeZeroVal(new QualType(T))), 
                  svalBuilder.getConditionType()));
              
              Optional<DefinedOrUnknownSVal> Constraint = Constraint_untested.getAs(DefinedOrUnknownSVal.class);
              if (!Constraint.$bool()) {
                break;
              }
              {
                IntrusiveRefCntPtr</*const*/ ProgramState> newState = null;
                try {
                  
                  newState = state.$arrow().assume(new DefinedOrUnknownSVal(Constraint.$star()), true);
                  if (newState.$bool()) {
                    $c$.clean(state.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(newState))));
                  }
                } finally {
                  if (newState != null) { newState.$destroy(); }
                }
              }
            } finally {
              $c$.$destroy();
            }
          }
        }
        break;
      } while (false);
      {
        
        /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(D);
        if ((MD != null)) {
          // Precondition: 'self' is always non-null upon entry to an Objective-C
          // method.
          /*const*/ ImplicitParamDecl /*P*/ SelfD = MD.getSelfDecl();
          /*const*/ MemRegion /*P*/ R = state.$arrow().getRegion(SelfD, InitLoc);
          SVal V = state.$arrow().getSVal(new Loc(JD$Move.INSTANCE, new NsLoc.MemRegionVal(R)));
          {
            
            Optional<Loc> LV = V.getAs(Loc.class);
            if (LV.$bool()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                // Assume that the pointer value in 'self' is non-null.
                $c$.clean(state.$assign($c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(LV.$star()), true))));
                assert (state.$bool()) : "'self' cannot be null";
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      }
      {
        
        /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(D);
        if ((MD != null)) {
          if (!MD.isStatic()) {
            // Precondition: 'this' is always non-null upon entry to the
            // top-level function.  This is our starting assumption for
            // analyzing an "open" program.
            /*const*/ StackFrameContext /*P*/ SFC = InitLoc.getCurrentStackFrame();
            if (SFC.getParent() == null) {
              NsLoc.MemRegionVal L = svalBuilder.getCXXThis(MD, SFC);
              SVal V = state.$arrow().getSVal(new Loc(L));
              {
                Optional<Loc> LV = V.getAs(Loc.class);
                if (LV.$bool()) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    $c$.clean(state.$assign($c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(LV.$star()), true))));
                    assert (state.$bool()) : "'this' cannot be null";
                  } finally {
                    $c$.$destroy();
                  }
                }
              }
            }
          }
        }
      }
      
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
    } finally {
      if (state != null) { state.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::getGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 159,
   FQN="clang::ento::ExprEngine::getGraph", NM="_ZN5clang4ento10ExprEngine8getGraphEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine8getGraphEv")
  //</editor-fold>
  public ExplodedGraph /*&*/ getGraph() {
    return G;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::getGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 160,
   FQN="clang::ento::ExprEngine::getGraph", NM="_ZNK5clang4ento10ExprEngine8getGraphEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento10ExprEngine8getGraphEv")
  //</editor-fold>
  public /*const*/ ExplodedGraph /*&*/ getGraph$Const() /*const*/ {
    return G;
  }

  
  /// \brief Run the analyzer's garbage collection - remove dead symbols and
  /// bindings from the state.
  ///
  /// Checkers can participate in this process with two callbacks:
  /// \c checkLiveSymbols and \c checkDeadSymbols. See the CheckerDocumentation
  /// class for more information.
  ///
  /// \param Node The predecessor node, from which the processing should start.
  /// \param Out The returned set of output nodes.
  /// \param ReferenceStmt The statement which is about to be processed.
  ///        Everything needed for this statement should be considered live.
  ///        A null statement means that everything in child LocationContexts
  ///        is dead.
  /// \param LC The location context of the \p ReferenceStmt. A null location
  ///        context means that we have reached the end of analysis and that
  ///        all statements and local variables should be considered dead.
  /// \param DiagnosticStmt Used as a location for any warnings that should
  ///        occur while removing the dead (e.g. leaks). By default, the
  ///        \p ReferenceStmt is used.
  /// \param K Denotes whether this is a pre- or post-statement purge. This
  ///        must only be ProgramPoint::PostStmtPurgeDeadSymbolsKind if an
  ///        entire location context is being cleared, in which case the
  ///        \p ReferenceStmt must either be a ReturnStmt or \c NULL. Otherwise,
  ///        it must be ProgramPoint::PreStmtPurgeDeadSymbolsKind (the default)
  ///        and \p ReferenceStmt must be valid (non-null).
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::removeDead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 343,
   FQN="clang::ento::ExprEngine::removeDead", NM="_ZN5clang4ento10ExprEngine10removeDeadEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetEPKNS_4StmtEPKNS_15LocationContextES8_NS_12ProgramPoint4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine10removeDeadEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetEPKNS_4StmtEPKNS_15LocationContextES8_NS_12ProgramPoint4KindE")
  //</editor-fold>
  public void removeDead(ExplodedNode /*P*/ Pred, final ExplodedNodeSet /*&*/ Out, 
            /*const*/ Stmt /*P*/ ReferenceStmt, 
            /*const*/ LocationContext /*P*/ LC) {
    removeDead(Pred, Out, 
            ReferenceStmt, 
            LC, 
            (/*const*/ Stmt /*P*/ )null, 
            ProgramPoint.Kind.PreStmtPurgeDeadSymbolsKind);
  }
  public void removeDead(ExplodedNode /*P*/ Pred, final ExplodedNodeSet /*&*/ Out, 
            /*const*/ Stmt /*P*/ ReferenceStmt, 
            /*const*/ LocationContext /*P*/ LC, 
            /*const*/ Stmt /*P*/ DiagnosticStmt/*= null*/) {
    removeDead(Pred, Out, 
            ReferenceStmt, 
            LC, 
            DiagnosticStmt, 
            ProgramPoint.Kind.PreStmtPurgeDeadSymbolsKind);
  }
  public void removeDead(ExplodedNode /*P*/ Pred, final ExplodedNodeSet /*&*/ Out, 
            /*const*/ Stmt /*P*/ ReferenceStmt, 
            /*const*/ LocationContext /*P*/ LC, 
            /*const*/ Stmt /*P*/ DiagnosticStmt/*= null*/, 
            ProgramPoint.Kind K/*= ProgramPoint::PreStmtPurgeDeadSymbolsKind*/) {
    IntrusiveRefCntPtr</*const*/ ProgramState> CleanedState = null;
    SymbolReaper SymReaper = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert ((K == ProgramPoint.Kind.PreStmtPurgeDeadSymbolsKind || ReferenceStmt == null || isa_ReturnStmt(ReferenceStmt))) : "PostStmt is not generally supported by the SymbolReaper yet";
      assert ((LC != null)) : "Must pass the current (or expiring) LocationContext";
      if (!(DiagnosticStmt != null)) {
        DiagnosticStmt = ReferenceStmt;
        assert ((DiagnosticStmt != null)) : "Required for clearing a LocationContext";
      }
      
      NumRemoveDeadBindings.$postInc(0);
      CleanedState = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      
      // LC is the location context being destroyed, but SymbolReaper wants a
      // location context that is still live. (If this is the top-level stack
      // frame, this will be null.)
      if (!(ReferenceStmt != null)) {
        assert (K == ProgramPoint.Kind.PostStmtPurgeDeadSymbolsKind) : "Use PostStmtPurgeDeadSymbolsKind for clearing a LocationContext";
        LC = LC.getParent();
      }
      
      /*const*/ StackFrameContext /*P*/ SFC = (LC != null) ? LC.getCurrentStackFrame() : null;
      SymReaper/*J*/= new SymbolReaper(SFC, ReferenceStmt, SymMgr, getStoreManager());
      
      getCheckerManager().runCheckersForLiveSymbols($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(CleanedState)), SymReaper); $c$.clean();
      
      // Create a state in which dead bindings are removed from the environment
      // and the store. TODO: The function should just return new env and store,
      // not a new state.
      $c$.clean(CleanedState.$assign($c$.track(StateMgr.removeDeadBindings($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(CleanedState)), SFC, SymReaper))));
      
      // Process any special transfer function for dead symbols.
      // A tag to track convenience transitions, which can be removed at cleanup.
      final/*static*/ SimpleProgramPointTag cleanupTag = removeDead$$.cleanupTag;
      if (!SymReaper.hasDeadSymbols()) {
        StmtNodeBuilder Bldr = null;
        try {
          // Generate a CleanedNode that has the environment and store cleaned
          // up. Since no symbols are dead, we can optimize and not clean out
          // the constraint manager.
          Bldr/*J*/= new StmtNodeBuilder(Pred, Out, $Deref(currBldrCtx));
          $c$.clean(Bldr.generateNode(DiagnosticStmt, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(CleanedState)), $AddrOf(cleanupTag), K));
        } finally {
          if (Bldr != null) { Bldr.$destroy(); }
        }
      } else {
        ExplodedNodeSet CheckedSet = null;
        StmtNodeBuilder Bldr = null;
        try {
          // Call checkers with the non-cleaned state so that they could query the
          // values of the soon to be dead symbols.
          CheckedSet/*J*/= new ExplodedNodeSet();
          getCheckerManager().runCheckersForDeadSymbols(CheckedSet, $c$.track(new ExplodedNodeSet(Pred)), SymReaper, 
              DiagnosticStmt, /*Deref*/this, K); $c$.clean();
          
          // For each node in CheckedSet, generate CleanedNodes that have the
          // environment, the store, and the constraints cleaned up but have the
          // user-supplied states as the predecessors.
          Bldr/*J*/= new StmtNodeBuilder(CheckedSet, Out, $Deref(currBldrCtx));
          for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = CheckedSet.begin(), E = CheckedSet.end(); I.$noteq(E); I.$preInc()) {
            IntrusiveRefCntPtr</*const*/ ProgramState> CheckerState = null;
            IntrusiveRefCntPtr</*const*/ ProgramState> CleanedCheckerSt = null;
            try {
              CheckerState = new IntrusiveRefCntPtr</*const*/ ProgramState>((I.$star()).getState());
              
              // The constraint manager has not been cleaned up yet, so clean up now.
              $c$.clean(CheckerState.$assign($c$.track(getConstraintManager().removeDeadBindings($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(CheckerState)), 
                      SymReaper))));
              assert (StateMgr.haveEqualEnvironments($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(CheckerState)), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState())))) : "Checkers are not allowed to modify the Environment as a part of checkDeadSymbols processing."; $c$.clean();
              assert (StateMgr.haveEqualStores($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(CheckerState)), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState())))) : "Checkers are not allowed to modify the Store as a part of checkDeadSymbols processing."; $c$.clean();
              
              // Create a state based on CleanedState with CheckerState GDM and
              // generate a transition to that state.
              CleanedCheckerSt = $c$.clean(StateMgr.getPersistentStateWithGDM($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(CleanedState)), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(CheckerState))));
              $c$.clean(Bldr.generateNode(DiagnosticStmt, I.$star(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(CleanedCheckerSt)), $AddrOf(cleanupTag), K));
            } finally {
              if (CleanedCheckerSt != null) { CleanedCheckerSt.$destroy(); }
              if (CheckerState != null) { CheckerState.$destroy(); }
            }
          }
        } finally {
          if (Bldr != null) { Bldr.$destroy(); }
          if (CheckedSet != null) { CheckedSet.$destroy(); }
        }
      }
    } finally {
      if (SymReaper != null) { SymReaper.$destroy(); }
      if (CleanedState != null) { CleanedState.$destroy(); }
      $c$.$destroy();
    }
  }
  private static final class removeDead$$ {
    static final/*static*/ SimpleProgramPointTag cleanupTag/*J*/= new SimpleProgramPointTag(new StringRef(TagProviderName), new StringRef(/*KEEP_STR*/"Clean Node"));
  }

  
  /// processCFGElement - Called by CoreEngine. Used to generate new successor
  ///  nodes by processing the 'effects' of a CFG element.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::processCFGElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 289,
   FQN="clang::ento::ExprEngine::processCFGElement", NM="_ZN5clang4ento10ExprEngine17processCFGElementENS_10CFGElementEPNS0_12ExplodedNodeEjPNS0_18NodeBuilderContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine17processCFGElementENS_10CFGElementEPNS0_12ExplodedNodeEjPNS0_18NodeBuilderContextE")
  //</editor-fold>
  @Override public void processCFGElement(/*const*/ CFGElement E, ExplodedNode /*P*/ Pred, 
                   /*uint*/int StmtIdx, NodeBuilderContext /*P*/ Ctx)/* override*/ {
    PrettyStackTraceLocationContext CrashInfo = null;
    try {
      CrashInfo/*J*/= new PrettyStackTraceLocationContext(Pred.getLocationContext());
      currStmtIdx = StmtIdx;
      currBldrCtx = Ctx;
      switch (E.getKind()) {
       case Statement:
        ProcessStmt(new CFGStmt(((/*const_cast*/Stmt /*P*/ )(E.castAs(CFGStmt.class).getStmt()))), Pred);
        return;
       case Initializer:
        ProcessInitializer(new CFGInitializer(E.castAs(CFGInitializer.class).getInitializer()), Pred);
        return;
       case NewAllocator:
        ProcessNewAllocator(E.castAs(CFGNewAllocator.class).getAllocatorExpr(), 
            Pred);
        return;
       case AutomaticObjectDtor:
       case DeleteDtor:
       case BaseDtor:
       case MemberDtor:
       case TemporaryDtor:
        ProcessImplicitDtor(E.castAs(CFGImplicitDtor.class), Pred);
        return;
      }
    } finally {
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::ProcessStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 425,
   FQN="clang::ento::ExprEngine::ProcessStmt", NM="_ZN5clang4ento10ExprEngine11ProcessStmtENS_7CFGStmtEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine11ProcessStmtENS_7CFGStmtEPNS0_12ExplodedNodeE")
  //</editor-fold>
  public void ProcessStmt(/*const*/ CFGStmt S, 
             ExplodedNode /*P*/ Pred) {
    PrettyStackTraceLoc CrashInfo = null;
    ExplodedNodeSet CleanedStates = null;
    ExplodedNodeSet Dst = null;
    try {
      // Reclaim any unnecessary nodes in the ExplodedGraph.
      G.reclaimRecentlyAllocatedNodes();
      
      /*const*/ Stmt /*P*/ currStmt = S.getStmt();
      CrashInfo/*J*/= new PrettyStackTraceLoc(getContext().getSourceManager(), 
          currStmt.getLocStart(), 
          $("Error evaluating statement"));
      
      // Remove dead bindings and symbols.
      CleanedStates/*J*/= new ExplodedNodeSet();
      if (ExprEngineStatics.shouldRemoveDeadBindings(AMgr, new CFGStmt(S), Pred, Pred.getLocationContext())) {
        removeDead(Pred, CleanedStates, currStmt, Pred.getLocationContext());
      } else {
        CleanedStates.Add(Pred);
      }
      
      // Visit the statement.
      Dst/*J*/= new ExplodedNodeSet();
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = CleanedStates.begin(), 
          E = CleanedStates.end(); I.$noteq(E); I.$preInc()) {
        ExplodedNodeSet DstI = null;
        try {
          DstI/*J*/= new ExplodedNodeSet();
          // Visit the statement.
          Visit(currStmt, I.$star(), DstI);
          Dst.insert(DstI);
        } finally {
          if (DstI != null) { DstI.$destroy(); }
        }
      }
      
      // Enqueue the new nodes onto the work list.
      Engine.enqueue(Dst, currBldrCtx.getBlock(), currStmtIdx);
    } finally {
      if (Dst != null) { Dst.$destroy(); }
      if (CleanedStates != null) { CleanedStates.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::ProcessInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 456,
   FQN="clang::ento::ExprEngine::ProcessInitializer", NM="_ZN5clang4ento10ExprEngine18ProcessInitializerENS_14CFGInitializerEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine18ProcessInitializerENS_14CFGInitializerEPNS0_12ExplodedNodeE")
  //</editor-fold>
  public void ProcessInitializer(/*const*/ CFGInitializer Init, 
                    ExplodedNode /*P*/ Pred) {
    PrettyStackTraceLoc CrashInfo = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    ExplodedNodeSet Tmp = null;
    ExplodedNodeSet Dst = null;
    NodeBuilder Bldr = null;
    try {
      /*const*/ CXXCtorInitializer /*P*/ BMI = Init.getInitializer();
      
      CrashInfo/*J*/= new PrettyStackTraceLoc(getContext().getSourceManager(), 
          BMI.getSourceLocation(), 
          $("Error evaluating initializer"));
      
      // We don't clean up dead bindings here.
      /*const*/ StackFrameContext /*P*/ stackFrame = cast_StackFrameContext(Pred.getLocationContext());
      /*const*/ CXXConstructorDecl /*P*/ decl = cast_CXXConstructorDecl(stackFrame.getDecl());
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      SVal thisVal = State.$arrow().getSVal(new Loc(JD$Move.INSTANCE, svalBuilder.getCXXThis(decl, stackFrame)));
      
      Tmp/*J*/= new ExplodedNodeSet(Pred);
      SVal FieldLoc/*J*/= new SVal();
      
      // Evaluate the initializer, if necessary
      if (BMI.isAnyMemberInitializer()) {
        {
          // Constructors build the object directly in the field,
          // but non-objects must be copied in from the initializer.
          /*const*/ CXXConstructExpr /*P*/ CtorExpr = findDirectConstructorForCurrentCFGElement();
          if ((CtorExpr != null)) {
            assert (BMI.getInit().IgnoreImplicit() == CtorExpr);
            ///*J:(void)*/CtorExpr;
            // The field was directly constructed, so there is no need to bind.
          } else {
            /*const*/ Expr /*P*/ Init$1 = BMI.getInit().IgnoreImplicit();
            /*const*/ ValueDecl /*P*/ Field;
            if (BMI.isIndirectMemberInitializer()) {
              Field = BMI.getIndirectMember();
              FieldLoc.$assignMove(State.$arrow().getLValue(BMI.getIndirectMember(), new SVal(thisVal)));
            } else {
              Field = BMI.getMember();
              FieldLoc.$assignMove(State.$arrow().getLValue(BMI.getMember(), new SVal(thisVal)));
            }
            
            SVal InitVal/*J*/= new SVal();
            if ($greater_uint(BMI.getNumArrayIndices(), 0)) {
              // Handle arrays of trivial type. We can represent this with a
              // primitive load/copy from the base array region.
              /*const*/ ArraySubscriptExpr /*P*/ ASE;
              while (((ASE = dyn_cast_ArraySubscriptExpr(Init$1)) != null)) {
                Init$1 = ASE.getBase$Const().IgnoreImplicit$Const();
              }
              
              SVal LValue = State.$arrow().getSVal(Init$1, stackFrame);
              {
                Optional<Loc> LValueLoc = LValue.getAs(Loc.class);
                if (LValueLoc.$bool()) {
                  InitVal.$assignMove(State.$arrow().getSVal(new Loc(LValueLoc.$star())));
                }
              }
              
              // If we fail to get the value for some reason, use a symbolic value.
              if (InitVal.isUnknownOrUndef$SVal()) {
                final SValBuilder /*&*/ SVB = getSValBuilder();
                InitVal.$assignMove(SVB.conjureSymbolVal(BMI.getInit(), stackFrame, 
                        Field.getType(), 
                        currBldrCtx.blockCount()));
              }
            } else {
              InitVal.$assignMove(State.$arrow().getSVal(BMI.getInit(), stackFrame));
            }
            assert (Tmp.size() == 1) : "have not generated any new nodes yet";
            assert (Tmp.begin().$star() == Pred) : "have not generated any new nodes yet";
            Tmp.clear();
            
            PostInitializer PP/*J*/= new PostInitializer(BMI, FieldLoc.getAsRegion(), stackFrame);
            evalBind(Tmp, Init$1, Pred, new SVal(FieldLoc), new SVal(InitVal), /*isInit=*/ true, $AddrOf(PP));
          }
        }
      } else {
        assert (BMI.isBaseInitializer() || BMI.isDelegatingInitializer());
        // We already did all the work when visiting the CXXConstructExpr.
      }
      
      // Construct PostInitializer nodes whether the state changed or not,
      // so that the diagnostics don't get confused.
      PostInitializer PP/*J*/= new PostInitializer(BMI, FieldLoc.getAsRegion(), stackFrame);
      Dst/*J*/= new ExplodedNodeSet();
      Bldr/*J*/= new NodeBuilder(Tmp, Dst, $Deref(currBldrCtx));
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = Tmp.begin(), E = Tmp.end(); I.$noteq(E); I.$preInc()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          ExplodedNode /*P*/ N = I.$star();
          $c$.clean(Bldr.generateNode(PP, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState())), N));
        } finally {
          $c$.$destroy();
        }
      }
      
      // Enqueue the new nodes onto the work list.
      Engine.enqueue(Dst, currBldrCtx.getBlock(), currStmtIdx);
    } finally {
      if (Bldr != null) { Bldr.$destroy(); }
      if (Dst != null) { Dst.$destroy(); }
      if (Tmp != null) { Tmp.$destroy(); }
      if (State != null) { State.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::ProcessImplicitDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 544,
   FQN="clang::ento::ExprEngine::ProcessImplicitDtor", NM="_ZN5clang4ento10ExprEngine19ProcessImplicitDtorENS_15CFGImplicitDtorEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine19ProcessImplicitDtorENS_15CFGImplicitDtorEPNS0_12ExplodedNodeE")
  //</editor-fold>
  public void ProcessImplicitDtor(/*const*/ CFGImplicitDtor D, 
                     ExplodedNode /*P*/ Pred) {
    ExplodedNodeSet Dst = null;
    try {
      Dst/*J*/= new ExplodedNodeSet();
      switch (D.getKind()) {
       case AutomaticObjectDtor:
        ProcessAutomaticObjDtor(D.castAs(CFGAutomaticObjDtor.class), Pred, Dst);
        break;
       case BaseDtor:
        ProcessBaseDtor(D.castAs(CFGBaseDtor.class), Pred, Dst);
        break;
       case MemberDtor:
        ProcessMemberDtor(D.castAs(CFGMemberDtor.class), Pred, Dst);
        break;
       case TemporaryDtor:
        ProcessTemporaryDtor(D.castAs(CFGTemporaryDtor.class), Pred, Dst);
        break;
       case DeleteDtor:
        ProcessDeleteDtor(D.castAs(CFGDeleteDtor.class), Pred, Dst);
        break;
       default:
        throw new llvm_unreachable("Unexpected dtor kind.");
      }
      
      // Enqueue the new nodes onto the work list.
      Engine.enqueue(Dst, currBldrCtx.getBlock(), currStmtIdx);
    } finally {
      if (Dst != null) { Dst.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::ProcessNewAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 571,
   FQN="clang::ento::ExprEngine::ProcessNewAllocator", NM="_ZN5clang4ento10ExprEngine19ProcessNewAllocatorEPKNS_10CXXNewExprEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine19ProcessNewAllocatorEPKNS_10CXXNewExprEPNS0_12ExplodedNodeE")
  //</editor-fold>
  public void ProcessNewAllocator(/*const*/ CXXNewExpr /*P*/ NE, 
                     ExplodedNode /*P*/ Pred) {
    ExplodedNodeSet Dst = null;
    try {
      Dst/*J*/= new ExplodedNodeSet();
      final AnalysisManager /*&*/ AMgr = getAnalysisManager();
      final AnalyzerOptions /*&*/ Opts = AMgr.options;
      // TODO: We're not evaluating allocators for all cases just yet as
      // we're not handling the return value correctly, which causes false
      // positives when the alpha.cplusplus.NewDeleteLeaks check is on.
      if (Opts.mayInlineCXXAllocator()) {
        VisitCXXNewAllocatorCall(NE, Pred, Dst);
      } else {
        NodeBuilder Bldr = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          Bldr/*J*/= new NodeBuilder(Pred, Dst, $Deref(currBldrCtx));
          /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
          PostImplicitCall PP/*J*/= new PostImplicitCall(NE.getOperatorNew(), NE.getLocStart(), LCtx);
          $c$.clean(Bldr.generateNode(PP, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState())), Pred));
        } finally {
          if (Bldr != null) { Bldr.$destroy(); }
          $c$.$destroy();
        }
      }
      Engine.enqueue(Dst, currBldrCtx.getBlock(), currStmtIdx);
    } finally {
      if (Dst != null) { Dst.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::ProcessAutomaticObjDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 590,
   FQN="clang::ento::ExprEngine::ProcessAutomaticObjDtor", NM="_ZN5clang4ento10ExprEngine23ProcessAutomaticObjDtorENS_19CFGAutomaticObjDtorEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine23ProcessAutomaticObjDtorENS_19CFGAutomaticObjDtorEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void ProcessAutomaticObjDtor(/*const*/ CFGAutomaticObjDtor Dtor, 
                         ExplodedNode /*P*/ Pred, 
                         final ExplodedNodeSet /*&*/ Dst) {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    try {
      /*const*/ VarDecl /*P*/ varDecl = Dtor.getVarDecl();
      QualType varType = varDecl.getType();

      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      SVal dest = new SVal(JD$Move.INSTANCE, state.$arrow().getLValue(varDecl, Pred.getLocationContext()));
      /*const*/ MemRegion /*P*/ Region = dest.castAs(NsLoc.MemRegionVal.class).getRegion();
      {

        /*const*/ ReferenceType /*P*/ refType = varType.$arrow().getAs(ReferenceType.class);
        if ((refType != null)) {
          varType.$assignMove(refType.getPointeeType());
          Region = state.$arrow().getSVal(Region).getAsRegion();
        }
      }

      VisitCXXDestructor(new QualType(varType), Region, Dtor.getTriggerStmt(), /*IsBase=*/ false, 
          Pred, Dst);
    } finally {
     if (state != null) { state.$destroy(); }
    } 
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::ProcessDeleteDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 609,
   FQN="clang::ento::ExprEngine::ProcessDeleteDtor", NM="_ZN5clang4ento10ExprEngine17ProcessDeleteDtorENS_13CFGDeleteDtorEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine17ProcessDeleteDtorENS_13CFGDeleteDtorEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void ProcessDeleteDtor(/*const*/ CFGDeleteDtor Dtor, 
                   ExplodedNode /*P*/ Pred, 
                   final ExplodedNodeSet /*&*/ Dst) {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
      /*const*/ CXXDeleteExpr /*P*/ DE = Dtor.getDeleteExpr();
      /*const*/ Stmt /*P*/ Arg = DE.getArgument$Const();
      SVal ArgVal = State.$arrow().getSVal(Arg, LCtx);
      
      // If the argument to delete is known to be a null value,
      // don't run destructor.
      if ($c$.clean($c$.track(State.$arrow().isNull(new SVal(ArgVal))).isConstrainedTrue())) {
        NodeBuilder Bldr = null;
        try {
          QualType DTy = DE.getDestroyedType();
          QualType BTy = getContext().getBaseElementType(new QualType(DTy));
          /*const*/ CXXRecordDecl /*P*/ RD = BTy.$arrow().getAsCXXRecordDecl();
          /*const*/ CXXDestructorDecl /*P*/ Dtor$1 = RD.getDestructor();
          
          PostImplicitCall PP/*J*/= new PostImplicitCall(Dtor$1, DE.getLocStart(), LCtx);
          Bldr/*J*/= new NodeBuilder(Pred, Dst, $Deref(currBldrCtx));
          $c$.clean(Bldr.generateNode(PP, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState())), Pred));
          return;
        } finally {
          if (Bldr != null) { Bldr.$destroy(); }
        }
      }
      
      VisitCXXDestructor(DE.getDestroyedType(), 
          ArgVal.getAsRegion(), 
          DE, /*IsBase=*/ false, 
          Pred, Dst);
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::ProcessBaseDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 638,
   FQN="clang::ento::ExprEngine::ProcessBaseDtor", NM="_ZN5clang4ento10ExprEngine15ProcessBaseDtorENS_11CFGBaseDtorEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine15ProcessBaseDtorENS_11CFGBaseDtorEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void ProcessBaseDtor(/*const*/ CFGBaseDtor D, 
                 ExplodedNode /*P*/ Pred, final ExplodedNodeSet /*&*/ Dst) {
    /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
    
    /*const*/ CXXDestructorDecl /*P*/ CurDtor = cast_CXXDestructorDecl(LCtx.getDecl());
    Loc ThisPtr = new Loc(JD$Move.INSTANCE, getSValBuilder().getCXXThis(CurDtor, 
            LCtx.getCurrentStackFrame()));
    SVal ThisVal = Pred.getState().$arrow().getSVal(new Loc(ThisPtr));
    
    // Create the base object region.
    /*const*/ CXXBaseSpecifier /*P*/ Base = D.getBaseSpecifier();
    QualType BaseTy = Base.getType();
    SVal BaseVal = getStoreManager().evalDerivedToBase(new SVal(ThisVal), new QualType(BaseTy), 
        Base.isVirtual());
    
    VisitCXXDestructor(new QualType(BaseTy), BaseVal.castAs(NsLoc.MemRegionVal.class).getRegion(), 
        CurDtor.getBody(), /*IsBase=*/ true, Pred, Dst);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::ProcessMemberDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 657,
   FQN="clang::ento::ExprEngine::ProcessMemberDtor", NM="_ZN5clang4ento10ExprEngine17ProcessMemberDtorENS_13CFGMemberDtorEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine17ProcessMemberDtorENS_13CFGMemberDtorEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void ProcessMemberDtor(/*const*/ CFGMemberDtor D, 
                   ExplodedNode /*P*/ Pred, final ExplodedNodeSet /*&*/ Dst) {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      /*const*/ FieldDecl /*P*/ Member = D.getFieldDecl();
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();

      /*const*/ CXXDestructorDecl /*P*/ CurDtor = cast_CXXDestructorDecl(LCtx.getDecl());
      Loc ThisVal = new Loc(JD$Move.INSTANCE, getSValBuilder().getCXXThis(CurDtor, 
              LCtx.getCurrentStackFrame()));
      SVal FieldVal = State.$arrow().getLValue(Member, new SVal(JD$Move.INSTANCE, State.$arrow().getSVal(new Loc(ThisVal)).castAs(Loc.class)));

      VisitCXXDestructor(Member.getType(), 
          FieldVal.castAs(NsLoc.MemRegionVal.class).getRegion(), 
          CurDtor.getBody(), /*IsBase=*/ false, Pred, Dst);
    } finally {
     if (State != null) { State.$destroy(); }
    } 
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::ProcessTemporaryDtor">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 674,
   FQN="clang::ento::ExprEngine::ProcessTemporaryDtor", NM="_ZN5clang4ento10ExprEngine20ProcessTemporaryDtorENS_16CFGTemporaryDtorEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine20ProcessTemporaryDtorENS_16CFGTemporaryDtorEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void ProcessTemporaryDtor(/*const*/ CFGTemporaryDtor D, 
                      ExplodedNode /*P*/ Pred, 
                      final ExplodedNodeSet /*&*/ Dst) {
    ExplodedNodeSet CleanDtorState = null;
    StmtNodeBuilder StmtBldr = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      CleanDtorState/*J*/= new ExplodedNodeSet();
      StmtBldr/*J*/= new StmtNodeBuilder(Pred, CleanDtorState, $Deref(currBldrCtx));
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      if (State.$arrow().contains(ProgramStateTraitInitializedTemporariesSet.$Instance, std.make_pair_Ptr_Ptr(D.getBindTemporaryExpr(), Pred.getStackFrame()))) {
        // FIXME: Currently we insert temporary destructors for default parameters,
        // but we don't insert the constructors.
        $c$.clean(State.$assign($c$.track(State.$arrow().remove(ProgramStateTraitInitializedTemporariesSet.$Instance, std.make_pair_Ptr_Ptr(D.getBindTemporaryExpr(), Pred.getStackFrame())))));
      }
      $c$.clean(StmtBldr.generateNode(D.getBindTemporaryExpr(), Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
      
      QualType varType = D.getBindTemporaryExpr().getSubExpr$Const().getType();
      // FIXME: Currently CleanDtorState can be empty here due to temporaries being
      // bound to default parameters.
      assert ($lesseq_uint(CleanDtorState.size(), 1));
      ExplodedNode /*P*/ CleanPred = CleanDtorState.empty() ? Pred : CleanDtorState.begin().$star();
      // FIXME: Inlining of temporary destructors is not supported yet anyway, so
      // we just put a NULL region for now. This will need to be changed later.
      VisitCXXDestructor(new QualType(varType), (/*const*/ MemRegion /*P*/ )null, D.getBindTemporaryExpr(), 
          /*IsBase=*/ false, CleanPred, Dst);
    } finally {
      if (State != null) { State.$destroy(); }
      if (StmtBldr != null) { StmtBldr.$destroy(); }
      if (CleanDtorState != null) { CleanDtorState.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Called by CoreEngine when processing the entrance of a CFGBlock.
  
  /// Block entrance.  (Update counters).
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::processCFGBlockEntrance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 1419,
   FQN="clang::ento::ExprEngine::processCFGBlockEntrance", NM="_ZN5clang4ento10ExprEngine23processCFGBlockEntranceERKNS_9BlockEdgeERNS0_20NodeBuilderWithSinksEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine23processCFGBlockEntranceERKNS_9BlockEdgeERNS0_20NodeBuilderWithSinksEPNS0_12ExplodedNodeE")
  //</editor-fold>
  @Override public void processCFGBlockEntrance(final /*const*/ BlockEdge /*&*/ L, 
                         final NodeBuilderWithSinks /*&*/ nodeBuilder, 
                         ExplodedNode /*P*/ Pred)/* override*/ {
    PrettyStackTraceLocationContext CrashInfo = null;
    try {
      CrashInfo/*J*/= new PrettyStackTraceLocationContext(Pred.getLocationContext());
      
      // If this block is terminated by a loop and it has already been visited the
      // maximum number of times, widen the loop.
      /*uint*/int BlockCount = nodeBuilder.getContext().blockCount();
      if (BlockCount == AMgr.options.maxBlockVisitOnPath - 1
         && AMgr.options.shouldWidenLoops()) {
        IntrusiveRefCntPtr</*const*/ ProgramState> WidenedState = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          /*const*/ Stmt /*P*/ Term = nodeBuilder.getContext().getBlock().getTerminator$Const().$Stmt$C$P();
          if (!((Term != null)
             && (isa_ForStmt(Term) || isa_WhileStmt(Term) || isa_DoStmt(Term)))) {
            return;
          }
          // Widen.
          /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
          WidenedState = $c$.clean(EntoGlobals.getWidenedLoopState($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState())), LCtx, BlockCount, Term));
          $c$.clean(nodeBuilder.generateNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(WidenedState)), Pred));
          return;
        } finally {
          if (WidenedState != null) { WidenedState.$destroy(); }
          $c$.$destroy();
        }
      }
      
      // FIXME: Refactor this into a checker.
      if ($greatereq_uint(BlockCount, AMgr.options.maxBlockVisitOnPath)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          final/*static*/ SimpleProgramPointTag tag = processCFGBlockEntrance$$.tag;
          /*const*/ ExplodedNode /*P*/ Sink = $c$.clean(nodeBuilder.generateSink($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState())), Pred, $AddrOf(tag)));
          
          // Check if we stopped at the top level function or not.
          // Root node should have the location context of the top most function.
          /*const*/ LocationContext /*P*/ CalleeLC = Pred.getLocation().getLocationContext();
          /*const*/ LocationContext /*P*/ CalleeSF = CalleeLC.getCurrentStackFrame();
          /*const*/ LocationContext /*P*/ RootLC = (G.roots_begin().$star()).getLocation().getLocationContext();
          if (RootLC.getCurrentStackFrame() != CalleeSF) {
            Engine.FunctionSummaries.markReachedMaxBlockCount(CalleeSF.getDecl());
            
            // Re-run the call evaluation without inlining it, by storing the
            // no-inlining policy in the state and enqueuing the new work item on
            // the list. Replay should almost never fail. Use the stats to catch it
            // if it does.
            if ((!AMgr.options.NoRetryExhausted
               && replayWithoutInlining(Pred, CalleeLC))) {
              return;
            }
            NumMaxBlockCountReachedInInlined.$postInc(0);
          } else {
            NumMaxBlockCountReached.$postInc(0);
          }
          
          // Make sink nodes as exhausted(for stats) only if retry failed.
          Engine.blocksExhausted.push_back_T$RR(std.make_pair_T_Ptr($Clone(L), Sink));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }
  private static final class processCFGBlockEntrance$$ {
    static final/*static*/ SimpleProgramPointTag tag/*J*/= new SimpleProgramPointTag(new StringRef(TagProviderName), new StringRef(/*KEEP_STR*/"Block count exceeded"));
  }

  
  /// ProcessBranch - Called by CoreEngine.  Used to generate successor
  ///  nodes by processing the 'effects' of a branch condition.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::processBranch">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*std::tie and destroy states*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 1579,
   FQN="clang::ento::ExprEngine::processBranch", NM="_ZN5clang4ento10ExprEngine13processBranchEPKNS_4StmtES4_RNS0_18NodeBuilderContextEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetEPKNS_8CFGBlockESD_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine13processBranchEPKNS_4StmtES4_RNS0_18NodeBuilderContextEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetEPKNS_8CFGBlockESD_")
  //</editor-fold>
  @Override public void processBranch(/*const*/ Stmt /*P*/ Condition, /*const*/ Stmt /*P*/ Term, 
               final NodeBuilderContext /*&*/ BldCtx, 
               ExplodedNode /*P*/ Pred, 
               final ExplodedNodeSet /*&*/ Dst, 
               /*const*/ CFGBlock /*P*/ DstT, 
               /*const*/ CFGBlock /*P*/ DstF)/* override*/ {
    PrettyStackTraceLocationContext StackCrashInfo = null;
    PrettyStackTraceLoc CrashInfo = null;
    ExplodedNodeSet CheckersOutSet = null;
    BranchNodeBuilder builder = null;
    try {
      assert ((!(Condition != null) || !isa_CXXBindTemporaryExpr(Condition))) : "CXXBindTemporaryExprs are handled by processBindTemporary.";
      /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
      StackCrashInfo/*J*/= new PrettyStackTraceLocationContext(LCtx);
      currBldrCtx = $AddrOf(BldCtx);
      
      // Check for NULL conditions; e.g. "for(;;)"
      if (!(Condition != null)) {
        BranchNodeBuilder NullCondBldr = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          NullCondBldr/*J*/= new BranchNodeBuilder(Pred, Dst, BldCtx, DstT, DstF);
          NullCondBldr.markInfeasible(false);
          $c$.clean(NullCondBldr.generateNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState())), true, Pred));
          return;
        } finally {
          if (NullCondBldr != null) { NullCondBldr.$destroy(); }
          $c$.$destroy();
        }
      }
      {
        
        /*const*/ Expr /*P*/ Ex = dyn_cast_Expr(Condition);
        if ((Ex != null)) {
          Condition = Ex.IgnoreParens$Const();
        }
      }
      
      Condition = ExprEngineStatics.ResolveCondition(Condition, BldCtx.getBlock());
      CrashInfo/*J*/= new PrettyStackTraceLoc(getContext().getSourceManager(), 
          Condition.getLocStart(), 
          $("Error evaluating branch"));
      
      CheckersOutSet/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForBranchCondition(Condition, CheckersOutSet, 
          Pred, /*Deref*/this);
      // We generated only sinks.
      if (CheckersOutSet.empty()) {
        return;
      }
      
      builder/*J*/= new BranchNodeBuilder(CheckersOutSet, Dst, BldCtx, DstT, DstF);
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = CheckersOutSet.begin(), 
          E = CheckersOutSet.end(); E.$noteq(I); I.$preInc()) {
        IntrusiveRefCntPtr</*const*/ ProgramState> PrevState = null;
        IntrusiveRefCntPtr</*const*/ ProgramState> StTrue = null;
        IntrusiveRefCntPtr</*const*/ ProgramState> StFalse = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          ExplodedNode /*P*/ PredI = I.$star();
          if (PredI.isSink()) {
            continue;
          }
          
          PrevState = new IntrusiveRefCntPtr</*const*/ ProgramState>(PredI.getState());
          SVal X = PrevState.$arrow().getSVal(Condition, PredI.getLocationContext());
          if (X.isUnknownOrUndef$SVal()) {
            {
              // Give it a chance to recover from unknown.
              /*const*/ Expr /*P*/ Ex = dyn_cast_Expr(Condition);
              if ((Ex != null)) {
                if (Ex.getType().$arrow().isIntegralOrEnumerationType()) {
                  // Try to recover some path-sensitivity.  Right now casts of symbolic
                  // integers that promote their values are currently not tracked well.
                  // If 'Condition' is such an expression, try and recover the
                  // underlying value and use that instead.
                  SVal recovered = $c$.clean(ExprEngineStatics.RecoverCastedSymbol(getStateManager(), 
                      $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(PrevState)), Condition, 
                      PredI.getLocationContext(), 
                      getContext()));
                  if (!recovered.isUnknown$SVal()) {
                    X.$assign(recovered);
                  }
                }
              }
            }
          }
          
          // If the condition is still unknown, give up.
          if (X.isUnknownOrUndef$SVal()) {
            $c$.clean(builder.generateNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(PrevState)), true, PredI));
            $c$.clean(builder.generateNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(PrevState)), false, PredI));
            continue;
          }
          
          DefinedSVal V = X.castAs(DefinedSVal.class);
          
//        JAVA:  $c$.clean(std.tie(StTrue, StFalse).$assign($c$.track(PrevState.$arrow().assume(new DefinedOrUnknownSVal(V)))));
          StTrue/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
          StFalse/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
          // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
          std.pairTypeType<IntrusiveRefCntPtr<ProgramState>, IntrusiveRefCntPtr<ProgramState>> $assume = $c$.track(PrevState.$arrow().assume(new DefinedOrUnknownSVal(V)));
          StTrue.$assign($assume.first);
          StFalse.$assign($assume.second);
          assert !$assume.first.$bool();
          assert !$assume.second.$bool();      
          $c$.clean();
          
          // Process the true branch.
          if (builder.isFeasible(true)) {
            if (StTrue.$bool()) {
              $c$.clean(builder.generateNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StTrue)), true, PredI));
            } else {
              builder.markInfeasible(true);
            }
          }
          
          // Process the false branch.
          if (builder.isFeasible(false)) {
            if (StFalse.$bool()) {
              $c$.clean(builder.generateNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StFalse)), false, PredI));
            } else {
              builder.markInfeasible(false);
            }
          }
        } finally {
          if (StFalse != null) { StFalse.$destroy(); }
          if (StTrue != null) { StTrue.$destroy(); }
          if (PrevState != null) { PrevState.$destroy(); }
          $c$.$destroy();
        }
      }
      currBldrCtx = null;
    } finally {
      if (builder != null) { builder.$destroy(); }
      if (CheckersOutSet != null) { CheckersOutSet.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
      if (StackCrashInfo != null) { StackCrashInfo.$destroy(); }
    }
  }

  
  /// Called by CoreEngine.
  /// Used to generate successor nodes for temporary destructors depending
  /// on whether the corresponding constructor was visited.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::processCleanupTemporaryBranch">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 701,
   FQN="clang::ento::ExprEngine::processCleanupTemporaryBranch", NM="_ZN5clang4ento10ExprEngine29processCleanupTemporaryBranchEPKNS_20CXXBindTemporaryExprERNS0_18NodeBuilderContextEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetEPKNS_8CFGBlockESD_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine29processCleanupTemporaryBranchEPKNS_20CXXBindTemporaryExprERNS0_18NodeBuilderContextEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetEPKNS_8CFGBlockESD_")
  //</editor-fold>
  @Override public void processCleanupTemporaryBranch(/*const*/ CXXBindTemporaryExpr /*P*/ BTE, 
                               final NodeBuilderContext /*&*/ BldCtx, 
                               ExplodedNode /*P*/ Pred, 
                               final ExplodedNodeSet /*&*/ Dst, 
                               /*const*/ CFGBlock /*P*/ DstT, 
                               /*const*/ CFGBlock /*P*/ DstF)/* override*/ {
    BranchNodeBuilder TempDtorBuilder = null;
    try {
      TempDtorBuilder/*J*/= new BranchNodeBuilder(Pred, Dst, BldCtx, DstT, DstF);
      if (Pred.getState().$arrow().contains(ProgramStateTraitInitializedTemporariesSet.$Instance, std.make_pair_Ptr_Ptr(BTE, Pred.getStackFrame()))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          TempDtorBuilder.markInfeasible(false);
          $c$.clean(TempDtorBuilder.generateNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState())), true, Pred));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          TempDtorBuilder.markInfeasible(true);
          $c$.clean(TempDtorBuilder.generateNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState())), false, Pred));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
      if (TempDtorBuilder != null) { TempDtorBuilder.$destroy(); }
    }
  }

  
  /// Called by CoreEngine.  Used to processing branching behavior
  /// at static initalizers.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::processStaticInitializer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 1681,
   FQN="clang::ento::ExprEngine::processStaticInitializer", NM="_ZN5clang4ento10ExprEngine24processStaticInitializerEPKNS_8DeclStmtERNS0_18NodeBuilderContextEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetEPKNS_8CFGBlockESD_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine24processStaticInitializerEPKNS_8DeclStmtERNS0_18NodeBuilderContextEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetEPKNS_8CFGBlockESD_")
  //</editor-fold>
  @Override public void processStaticInitializer(/*const*/ DeclStmt /*P*/ DS, 
                          final NodeBuilderContext /*&*/ BuilderCtx, 
                          ExplodedNode /*P*/ Pred, 
                          final ExplodedNodeSet /*&*/ Dst, 
                          /*const*/ CFGBlock /*P*/ DstT, 
                          /*const*/ CFGBlock /*P*/ DstF)/* override*/ {
    PrettyStackTraceLocationContext CrashInfo = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    BranchNodeBuilder builder = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      CrashInfo/*J*/= new PrettyStackTraceLocationContext(Pred.getLocationContext());
      currBldrCtx = $AddrOf(BuilderCtx);
      
      /*const*/ VarDecl /*P*/ VD = cast_VarDecl(DS.getSingleDecl$Const());
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      boolean initHasRun = state.$arrow().contains(ProgramStateTraitInitializedGlobalsSet.$Instance, VD);
      builder/*J*/= new BranchNodeBuilder(Pred, Dst, BuilderCtx, DstT, DstF);
      if (!initHasRun) {
        $c$.clean(state.$assign($c$.track(state.$arrow().add(ProgramStateTraitInitializedGlobalsSet.$Instance, VD))));
      }
      
      $c$.clean(builder.generateNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), initHasRun, Pred));
      builder.markInfeasible(!initHasRun);
      
      currBldrCtx = null;
    } finally {
      if (builder != null) { builder.$destroy(); }
      if (state != null) { state.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// processIndirectGoto - Called by CoreEngine.  Used to generate successor
  ///  nodes by processing the 'effects' of a computed goto jump.
  
  /// processIndirectGoto - Called by CoreEngine.  Used to generate successor
  ///  nodes by processing the 'effects' of a computed goto jump.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::processIndirectGoto">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 1707,
   FQN="clang::ento::ExprEngine::processIndirectGoto", NM="_ZN5clang4ento10ExprEngine19processIndirectGotoERNS0_23IndirectGotoNodeBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine19processIndirectGotoERNS0_23IndirectGotoNodeBuilderE")
  //</editor-fold>
  @Override public void processIndirectGoto(final IndirectGotoNodeBuilder /*&*/ builder)/* override*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      state = builder.getState();
      SVal V = state.$arrow().getSVal(builder.getTarget(), builder.getLocationContext());
      
      // Three possibilities:
      //
      //   (1) We know the computed label.
      //   (2) The label is NULL (or some other constant), or Undefined.
      //   (3) We have no clue about the label.  Dispatch to all targets.
      //
      // JAVA: typedef IndirectGotoNodeBuilder::iterator iterator
//      final class iterator extends IndirectGotoNodeBuilder.iterator{ };
      {
        
        Optional<NsLoc.GotoLabel> LV = V.getAs(NsLoc.GotoLabel.class);
        if (LV.$bool()) {
          /*const*/ LabelDecl /*P*/ L = LV.$arrow().getLabel();
          
          for (IndirectGotoNodeBuilder.iterator I = builder.begin(), E = builder.end(); I.$noteq(E); I.$preInc()) {
            if (I.getLabel() == L) {
              $c$.clean(builder.generateNode(I, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
              return;
            }
          }
          throw new llvm_unreachable("No block with label.");
        }
      }
      if (V.getAs(NsLoc.ConcreteInt.class).$bool() || V.getAs(UndefinedVal.class).$bool()) {
        // Dispatch to the first target and mark it as a sink.
        //ExplodedNode* N = builder.generateNode(builder.begin(), state, true);
        // FIXME: add checker visit.
        //    UndefBranches.insert(N);
        return;
      }
      
      // This is really a catch-all.  We don't support symbolics yet.
      // FIXME: Implement dispatch for symbolic pointers.
      for (IndirectGotoNodeBuilder.iterator I = builder.begin(), E = builder.end(); I.$noteq(E); I.$preInc())  {
        $c$.clean(builder.generateNode(I, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
      }
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// ProcessSwitch - Called by CoreEngine.  Used to generate successor
  ///  nodes by processing the 'effects' of a switch statement.
  
  /// ProcessSwitch - Called by CoreEngine.  Used to generate successor
  ///  nodes by processing the 'effects' of a switch statement.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::processSwitch">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 1803,
   FQN="clang::ento::ExprEngine::processSwitch", NM="_ZN5clang4ento10ExprEngine13processSwitchERNS0_17SwitchNodeBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine13processSwitchERNS0_17SwitchNodeBuilderE")
  //</editor-fold>
  @Override public void processSwitch(final SwitchNodeBuilder /*&*/ builder)/* override*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> DefaultSt = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // JAVA: typedef SwitchNodeBuilder::iterator iterator
//      final class iterator extends SwitchNodeBuilder.iterator{ };
      state = builder.getState();
      /*const*/ Expr /*P*/ CondE = builder.getCondition();
      SVal CondV_untested = state.$arrow().getSVal(CondE, builder.getLocationContext());
      if (CondV_untested.isUndef$SVal()) {
        //ExplodedNode* N = builder.generateDefaultCaseNode(state, true);
        // FIXME: add checker
        //UndefBranches.insert(N);
        return;
      }
      DefinedOrUnknownSVal CondV = CondV_untested.castAs(DefinedOrUnknownSVal.class);
      
      DefaultSt = new IntrusiveRefCntPtr</*const*/ ProgramState>(state);
      
      SwitchNodeBuilder.iterator I = builder.begin();
      SwitchNodeBuilder.iterator EI = builder.end();
      boolean defaultIsFeasible = I.$eq(EI);
      
      for (; I.$noteq(EI); I.$preInc()) {
        IntrusiveRefCntPtr</*const*/ ProgramState> StateCase = null;
        try {
          // Successor may be pruned out during CFG construction.
          if (!(I.getBlock() != null)) {
            continue;
          }
          
          /*const*/ CaseStmt /*P*/ Case = I.getCase();
          
          // Evaluate the LHS of the case value.
          APSInt V1 = Case.getLHS$Const().EvaluateKnownConstInt(getContext());
          assert ($uint2ullong(V1.getBitWidth()) == getContext().getTypeSize(CondE.getType()));
          
          // Get the RHS of the case, if it exists.
          APSInt V2/*J*/= new APSInt();
          {
            /*const*/ Expr /*P*/ E = Case.getRHS$Const();
            if ((E != null)) {
              V2.$assignMove(E.EvaluateKnownConstInt(getContext()));
            } else {
              V2.$assign(V1);
            }
          }
          
          StateCase/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
          {
            Optional<NonLoc> NL = CondV.getAs(NonLoc.class);
            if (NL.$bool()) {
//              $c$.clean(std.tie(StateCase, DefaultSt).$assign(
//                  $c$.track(DefaultSt.$arrow().assumeWithinInclusiveRange(new DefinedOrUnknownSVal(NL.$star()), V1, V2))
//              ));
              // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
              std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assumeWithinInclusiveRange = 
                      $c$.track(DefaultSt.$arrow().assumeWithinInclusiveRange(new DefinedOrUnknownSVal(NL.$star()), V1, V2));
              StateCase.$assign($assumeWithinInclusiveRange.first);
              DefaultSt.$assign($assumeWithinInclusiveRange.second);
              assert !$assumeWithinInclusiveRange.first.$bool();
              assert $assumeWithinInclusiveRange.second.$bool() : "we swapped with valid DefaultSt";
              $c$.clean();
              assert $assumeWithinInclusiveRange.second.test$isDestroyed() : "now have to be released";
              
            } else { // UnknownVal
              $c$.clean(StateCase.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(DefaultSt))));
            }
          }
          if (StateCase.$bool()) {
            $c$.clean(builder.generateCaseStmtNode(I, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StateCase))));
          }
          
          // Now "assume" that the case doesn't match.  Add this state
          // to the default state (if it is feasible).
          if (DefaultSt.$bool()) {
            defaultIsFeasible = true;
          } else {
            defaultIsFeasible = false;
            break;
          }
        } finally {
          if (StateCase != null) { StateCase.$destroy(); }
        }
      }
      if (!defaultIsFeasible) {
        return;
      }
      
      // If we have switch(enum value), the default branch is not
      // feasible if all of the enum constants not covered by 'case:' statements
      // are not feasible values for the switch condition.
      //
      // Note that this isn't as accurate as it could be.  Even if there isn't
      // a case for a particular enum value as long as that enum value isn't
      // feasible then it shouldn't be considered for making 'default:' reachable.
      /*const*/ SwitchStmt /*P*/ SS = builder.getSwitch();
      /*const*/ Expr /*P*/ CondExpr = SS.getCond$Const().IgnoreParenImpCasts$Const();
      if ((CondExpr.getType().$arrow().getAs$EnumType() != null)) {
        if (SS.isAllEnumCasesCovered()) {
          return;
        }
      }
      
      $c$.clean(builder.generateDefaultCaseNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(DefaultSt))));
    } finally {
      if (DefaultSt != null) { DefaultSt.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Called by CoreEngine.  Used to notify checkers that processing a
  /// function has begun. Called for both inlined and and top-level functions.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::processBeginOfFunction">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$ref to field*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 1765,
   FQN="clang::ento::ExprEngine::processBeginOfFunction", NM="_ZN5clang4ento10ExprEngine22processBeginOfFunctionERNS0_18NodeBuilderContextEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetERKNS_9BlockEdgeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine22processBeginOfFunctionERNS0_18NodeBuilderContextEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetERKNS_9BlockEdgeE")
  //</editor-fold>
  @Override public void processBeginOfFunction(final NodeBuilderContext /*&*/ BC, 
                        ExplodedNode /*P*/ Pred, 
                        final ExplodedNodeSet /*&*/ Dst, 
                        final /*const*/ BlockEdge /*&*/ L)/* override*/ {
    SaveAndRestore</*const*/ NodeBuilderContext /*P*/ > NodeContextRAII = null;
    try {
      NodeContextRAII/*J*/= new SaveAndRestore</*const*/ NodeBuilderContext /*P*/ >(currBldrCtx$ref, $AddrOf(BC), true);
      getCheckerManager().runCheckersForBeginFunction(Dst, L, Pred, /*Deref*/this);
    } finally {
      if (NodeContextRAII != null) { NodeContextRAII.$destroy(); }
    }
  }

  
  /// Called by CoreEngine.  Used to notify checkers that processing a
  /// function has ended. Called for both inlined and and top-level functions.
  
  /// ProcessEndPath - Called by CoreEngine.  Used to generate end-of-path
  ///  nodes when the control reaches the end of a function.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::processEndOfFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 1775,
   FQN="clang::ento::ExprEngine::processEndOfFunction", NM="_ZN5clang4ento10ExprEngine20processEndOfFunctionERNS0_18NodeBuilderContextEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine20processEndOfFunctionERNS0_18NodeBuilderContextEPNS0_12ExplodedNodeE")
  //</editor-fold>
  @Override public void processEndOfFunction(final NodeBuilderContext /*&*/ BC, 
                      ExplodedNode /*P*/ Pred)/* override*/ {
    PrettyStackTraceLocationContext CrashInfo = null;
    ExplodedNodeSet Dst = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // FIXME: Assert that stackFrameDoesNotContainInitializedTemporaries(*Pred)).
      // We currently cannot enable this assert, as lifetime extended temporaries
      // are not modelled correctly.
      CrashInfo/*J*/= new PrettyStackTraceLocationContext(Pred.getLocationContext());
      StateMgr.EndPath($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState()))); $c$.clean();
      
      Dst/*J*/= new ExplodedNodeSet();
      if (Pred.getLocationContext().inTopFrame()) {
        ExplodedNodeSet AfterRemovedDead = null;
        try {
          // Remove dead symbols.
          AfterRemovedDead/*J*/= new ExplodedNodeSet();
          removeDeadOnEndOfFunction(BC, Pred, AfterRemovedDead);
          
          // Notify checkers.
          for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = AfterRemovedDead.begin(), 
              E = AfterRemovedDead.end(); I.$noteq(E); I.$preInc()) {
            getCheckerManager().runCheckersForEndFunction(BC, Dst, I.$star(), /*Deref*/this);
          }
        } finally {
          if (AfterRemovedDead != null) { AfterRemovedDead.$destroy(); }
        }
      } else {
        getCheckerManager().runCheckersForEndFunction(BC, Dst, Pred, /*Deref*/this);
      }
      
      Engine.enqueueEndOfFunction(Dst);
    } finally {
      if (Dst != null) { Dst.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Remove dead bindings/symbols before exiting a function.
  
  /// Remove dead bindings/symbols before exiting a function.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::removeDeadOnEndOfFunction">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*std::tie and $ref to field*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 162,
   FQN="clang::ento::ExprEngine::removeDeadOnEndOfFunction", NM="_ZN5clang4ento10ExprEngine25removeDeadOnEndOfFunctionERNS0_18NodeBuilderContextEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang4ento10ExprEngine25removeDeadOnEndOfFunctionERNS0_18NodeBuilderContextEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void removeDeadOnEndOfFunction(final NodeBuilderContext /*&*/ BC, 
                           ExplodedNode /*P*/ Pred, 
                           final ExplodedNodeSet /*&*/ Dst) {
    SaveAndRestore</*const*/ NodeBuilderContext /*P*/ > NodeContextRAII = null;
    try {
      // Find the last statement in the function and the corresponding basic block.
      /*const*/ Stmt /*P*/ LastSt = null;
      /*const*/ CFGBlock /*P*/ Blk = null;
//    JAVA:   std.tie(LastSt, Blk).$assign(getLastStmt(Pred));
      std.pairPtrPtr</*const*/ Stmt /*P*/ , /*const*/ CFGBlock /*P*/ > $tie = getLastStmt(Pred);
      LastSt = $tie.first;
      Blk = $tie.second;
      if (!(Blk != null) || !(LastSt != null)) {
        Dst.Add(Pred);
        return;
      }
      
      // Here, we destroy the current location context. We use the current
      // function's entire body as a diagnostic statement, with which the program
      // point will be associated. However, we only want to use LastStmt as a
      // reference for what to clean up if it's a ReturnStmt; otherwise, everything
      // is dead.
      NodeContextRAII/*J*/= new SaveAndRestore</*const*/ NodeBuilderContext /*P*/ >(currBldrCtx$ref, $AddrOf(BC), true);
      /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
      removeDead(Pred, Dst, dyn_cast_ReturnStmt(LastSt), LCtx, 
          LCtx.getAnalysisDeclContext().getBody(), 
          ProgramPoint.Kind.PostStmtPurgeDeadSymbolsKind);
    } finally {
      if (NodeContextRAII != null) { NodeContextRAII.$destroy(); }
    }
  }


  
  /// Generate the entry node of the callee.
  
  /// Generate the entry node of the callee.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::processCallEnter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 40,
   FQN="clang::ento::ExprEngine::processCallEnter", NM="_ZN5clang4ento10ExprEngine16processCallEnterERNS0_18NodeBuilderContextENS_9CallEnterEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang4ento10ExprEngine16processCallEnterERNS0_18NodeBuilderContextENS_9CallEnterEPNS0_12ExplodedNodeE")
  //</editor-fold>
  @Override public void processCallEnter(final NodeBuilderContext /*&*/ BC, CallEnter CE, 
                  ExplodedNode /*P*/ Pred)/* override*/ {
    PrettyStackTraceLocationContext CrashInfo = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Get the entry block in the CFG of the callee.
      /*const*/ StackFrameContext /*P*/ calleeCtx = CE.getCalleeContext();
      CrashInfo/*J*/= new PrettyStackTraceLocationContext(calleeCtx);
      /*const*/ CFGBlock /*P*/ Entry = CE.getEntry();
      
      // Validate the CFG.
      assert (Entry.empty());
      assert (Entry.succ_size() == 1);
      
      // Get the solitary successor.
      /*const*/ CFGBlock /*P*/ Succ = (Entry.succ_begin$Const()).$star().$CFGBlock$P();
      
      // Construct an edge representing the starting location in the callee.
      BlockEdge Loc/*J*/= new BlockEdge(Entry, Succ, calleeCtx);
      
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      
      // Construct a new node, notify checkers that analysis of the function has
      // begun, and add the resultant nodes to the worklist.
      bool$ptr isNew = create_bool$ptr();
      ExplodedNode /*P*/ Node = $c$.clean(G.getNode(Loc, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), false, $AddrOf(isNew)));
      Node.addPredecessor(Pred, G);
      if (isNew.$star()) {
        ExplodedNodeSet DstBegin = null;
        try {
          DstBegin/*J*/= new ExplodedNodeSet();
          processBeginOfFunction(BC, Node, DstBegin, Loc);
          Engine.enqueue(DstBegin);
        } finally {
          if (DstBegin != null) { DstBegin.$destroy(); }
        }
      }
    } finally {
      if (state != null) { state.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
      $c$.$destroy();
    }
  }


  
  /// Generate the sequence of nodes that simulate the call exit and the post
  /// visit for CallExpr.
  
  /// Generate the sequence of nodes that simulate the call exit and the post
  /// visit for CallExpr.
  
  /// The call exit is simulated with a sequence of nodes, which occur between
  /// CallExitBegin and CallExitEnd. The following operations occur between the
  /// two program points:
  /// 1. CallExitBegin (triggers the start of call exit sequence)
  /// 2. Bind the return value
  /// 3. Run Remove dead bindings to clean up the dead symbols from the callee.
  /// 4. CallExitEnd (switch to the caller context)
  /// 5. PostStmt<CallExpr>
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::processCallExit">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 221,
   FQN="clang::ento::ExprEngine::processCallExit", NM="_ZN5clang4ento10ExprEngine15processCallExitEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang4ento10ExprEngine15processCallExitEPNS0_12ExplodedNodeE")
  //</editor-fold>
  @Override public void processCallExit(ExplodedNode /*P*/ CEBNode)/* override*/ {
    PrettyStackTraceLocationContext CrashInfo = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    CallEventRef<CallEvent> Call = null;
    ExplodedNodeSet CleanedNodes = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Step 1 CEBNode was generated before the call.
      CrashInfo/*J*/= new PrettyStackTraceLocationContext(CEBNode.getLocationContext());
      /*const*/ StackFrameContext /*P*/ calleeCtx = CEBNode.getLocationContext().getCurrentStackFrame();
      
      // The parent context might not be a stack frame, so make sure we
      // look up the first enclosing stack frame.
      /*const*/ StackFrameContext /*P*/ callerCtx = calleeCtx.getParent().getCurrentStackFrame();
      
      /*const*/ Stmt /*P*/ CE = calleeCtx.getCallSite();
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(CEBNode.getState());
      // Find the last statement in the function and the corresponding basic block.
      /*const*/ Stmt /*P*/ LastSt = null;
      /*const*/ CFGBlock /*P*/ Blk = null;
      // JAVA unfold std.tie
//      std.tie(LastSt, Blk).$assign(getLastStmt(CEBNode));
      std.pairPtrPtr</*const*/ Stmt /*P*/ , /*const*/ CFGBlock /*P*/ > $tie = getLastStmt(CEBNode);
      LastSt = $tie.first;
      Blk = $tie.second;
      
      // Generate a CallEvent /before/ cleaning the state, so that we can get the
      // correct value for 'this' (if necessary).
      final CallEventManager /*&*/ CEMgr = getStateManager().getCallEventManager();
      Call = $c$.clean(CEMgr.getCaller(calleeCtx, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
      
      // Step 2: generate node with bound return value: CEBNode -> BindedRetNode.
      
      // If the callee returns an expression, bind its value to CallExpr.
      if ((CE != null)) {
        {
          /*const*/ ReturnStmt /*P*/ RS = dyn_cast_or_null_ReturnStmt(LastSt);
          if ((RS != null)) {
            /*const*/ LocationContext /*P*/ LCtx = CEBNode.getLocationContext();
            SVal V = state.$arrow().getSVal(RS, LCtx);
            
            // Ensure that the return type matches the type of the returned Expr.
            if ($c$.clean(ExprEngineCallAndReturnStatics.wasDifferentDeclUsedForInlining($c$.track(new CallEventRef<CallEvent>(Call)), calleeCtx))) {
              QualType ReturnedTy = CallEvent.getDeclaredResultType(calleeCtx.getDecl());
              if (!ReturnedTy.isNull()) {
                {
                  /*const*/ Expr /*P*/ Ex = dyn_cast_Expr(CE);
                  if ((Ex != null)) {
                    V.$assignMove(ExprEngineCallAndReturnStatics.adjustReturnValue(new SVal(V), Ex.getType(), new QualType(ReturnedTy), 
                            getStoreManager()));
                  }
                }
              }
            }
            
            $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(CE, callerCtx, new SVal(V)))));
          }
        }
        {
          
          // Bind the constructed object value to CXXConstructExpr.
          /*const*/ CXXConstructExpr /*P*/ CCE = dyn_cast_CXXConstructExpr(CE);
          if ((CCE != null)) {
            NsLoc.MemRegionVal This = svalBuilder.getCXXThis(CCE.getConstructor().getParent(), calleeCtx);
            SVal ThisV = state.$arrow().getSVal(new Loc(This));
            
            // If the constructed object is a temporary prvalue, get its bindings.
            if (ExprEngineCallAndReturnStatics.isTemporaryPRValue(CCE, new SVal(ThisV))) {
              ThisV.$assignMove(state.$arrow().getSVal(ThisV.castAs(Loc.class)));
            }
            
            $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(CCE, callerCtx, new SVal(ThisV)))));
          }
        }
      }
      
      // Step 3: BindedRetNode -> CleanedNodes
      // If we can find a statement and a block in the inlined function, run remove
      // dead bindings before returning from the call. This is important to ensure
      // that we report the issues such as leaks in the stack contexts in which
      // they occurred.
      CleanedNodes/*J*/= new ExplodedNodeSet();
      if ((LastSt != null) && (Blk != null) && AMgr.options.AnalysisPurgeOpt != AnalysisPurgeMode.PurgeNone) {
        final/*static*/ SimpleProgramPointTag retValBind = processCallExit$$.retValBind;
        org.clang.analysis.PostStmt Loc/*J*/= new org.clang.analysis.PostStmt(LastSt, calleeCtx, $AddrOf(retValBind));
        bool$ptr isNew = create_bool$ptr();
        ExplodedNode /*P*/ BindedRetNode = $c$.clean(G.getNode(Loc, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), false, $AddrOf(isNew)));
        BindedRetNode.addPredecessor(CEBNode, G);
        if (!isNew.$star()) {
          return;
        }
        
        NodeBuilderContext Ctx/*J*/= new NodeBuilderContext(getCoreEngine(), Blk, BindedRetNode);
        currBldrCtx = $AddrOf(Ctx);
        // Here, we call the Symbol Reaper with 0 statement and callee location
        // context, telling it to clean up everything in the callee's context
        // (and its children). We use the callee's function body as a diagnostic
        // statement, with which the program point will be associated.
        removeDead(BindedRetNode, CleanedNodes, (/*const*/ Stmt /*P*/ )null, calleeCtx, 
            calleeCtx.getAnalysisDeclContext().getBody(), 
            ProgramPoint.Kind.PostStmtPurgeDeadSymbolsKind);
        currBldrCtx = null;
      } else {
        CleanedNodes.Add(CEBNode);
      }
      
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = CleanedNodes.begin(), 
          E = CleanedNodes.end(); I.$noteq(E); I.$preInc()) {
        IntrusiveRefCntPtr</*const*/ ProgramState> CEEState = null;
        SaveAndRestore</*const*/ NodeBuilderContext /*P*/ > NBCSave = null;
        SaveAndRestoreInt CBISave = null;
        CallEventRef<CallEvent> UpdatedCall = null;
        ExplodedNodeSet DstPostCall = null;
        ExplodedNodeSet Dst = null;
        try {
          
          // Step 4: Generate the CallExit and leave the callee's context.
          // CleanedNodes -> CEENode
          CallExitEnd Loc/*J*/= new CallExitEnd(calleeCtx, callerCtx);
          bool$ptr isNew = create_bool$ptr();
          CEEState = new IntrusiveRefCntPtr</*const*/ ProgramState>((I.$star() == CEBNode) ? state : (I.$star()).getState());
          ExplodedNode /*P*/ CEENode = $c$.clean(G.getNode(Loc, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(CEEState)), false, $AddrOf(isNew)));
          CEENode.addPredecessor(I.$star(), G);
          if (!isNew.$star()) {
            return;
          }
          
          // Step 5: Perform the post-condition check of the CallExpr and enqueue the
          // result onto the work list.
          // CEENode -> Dst -> WorkList
          NodeBuilderContext Ctx/*J*/= new NodeBuilderContext(Engine, calleeCtx.getCallSiteBlock(), CEENode);
          NBCSave/*J*/= new SaveAndRestore</*const*/ NodeBuilderContext /*P*/ >(currBldrCtx$ref, 
              $AddrOf(Ctx), true);
          CBISave/*J*/= new SaveAndRestoreInt(currStmtIdx$ref, calleeCtx.getIndex());
          
          UpdatedCall = $c$.clean(Call.$star().cloneWithState($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(CEEState))));
          
          DstPostCall/*J*/= new ExplodedNodeSet();
          getCheckerManager().runCheckersForPostCall(DstPostCall, $c$.track(new ExplodedNodeSet(CEENode)), 
              UpdatedCall.$star(), /*Deref*/this, 
              /*WasInlined=*/ true); $c$.clean();
          
          Dst/*J*/= new ExplodedNodeSet();
          {
            /*const*/ ObjCMethodCall /*P*/ Msg = dyn_cast_ObjCMethodCall(Call.$star());
            if ((Msg != null)) {
              getCheckerManager().runCheckersForPostObjCMessage(Dst, DstPostCall, $Deref(Msg), 
                  /*Deref*/this, 
                  /*WasInlined=*/ true);
            } else if ((CE != null)) {
              getCheckerManager().runCheckersForPostStmt(Dst, DstPostCall, CE, 
                  /*Deref*/this, /*WasInlined=*/ true);
            } else {
              Dst.insert(DstPostCall);
            }
          }
          
          // Enqueue the next element in the block.
          for (SmallPtrSetIterator<ExplodedNode /*P*/ > PSI = Dst.begin(), PSE = Dst.end();
               PSI.$noteq(PSE); PSI.$preInc()) {
            Engine.getWorkList().enqueue(PSI.$star(), calleeCtx.getCallSiteBlock(), 
                calleeCtx.getIndex() + 1);
          }
        } finally {
          if (Dst != null) { Dst.$destroy(); }
          if (DstPostCall != null) { DstPostCall.$destroy(); }
          if (UpdatedCall != null) { UpdatedCall.$destroy(); }
          if (CBISave != null) { CBISave.$destroy(); }
          if (NBCSave != null) { NBCSave.$destroy(); }
          if (CEEState != null) { CEEState.$destroy(); }
        }
      }
    } finally {
      if (CleanedNodes != null) { CleanedNodes.$destroy(); }
      if (Call != null) { Call.$destroy(); }
      if (state != null) { state.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
      $c$.$destroy();
    }
  }
  private static final class processCallExit$$ {
    static final/*static*/ SimpleProgramPointTag retValBind/*J*/= new SimpleProgramPointTag(new StringRef(/*KEEP_STR*/"ExprEngine"), new StringRef(/*KEEP_STR*/"Bind Return Value"));
  }


  
  /// Called by CoreEngine when the analysis worklist has terminated.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::processEndWorklist">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 285,
   FQN="clang::ento::ExprEngine::processEndWorklist", NM="_ZN5clang4ento10ExprEngine18processEndWorklistEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine18processEndWorklistEb")
  //</editor-fold>
  @Override public void processEndWorklist(boolean hasWorkRemaining)/* override*/ {
    getCheckerManager().runCheckersForEndAnalysis(G, BR, /*Deref*/this);
  }

  
  /// evalAssume - Callback function invoked by the ConstraintManager when
  ///  making assumptions about state values.
  
  //===----------------------------------------------------------------------===//
  // Top-level transfer function logic (Dispatcher).
  //===----------------------------------------------------------------------===//
  
  /// evalAssume - Called by ConstraintManager. Used to call checker-specific
  ///  logic for handling assumptions on symbolic values.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::processAssume">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 261,
   FQN="clang::ento::ExprEngine::processAssume", NM="_ZN5clang4ento10ExprEngine13processAssumeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine13processAssumeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValEb")
  //</editor-fold>
  @Override public IntrusiveRefCntPtr</*const*/ ProgramState> processAssume(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
               SVal cond, boolean assumption)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(getCheckerManager().runCheckersForEvalAssume($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(cond), assumption));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// wantsRegionChangeUpdate - Called by ProgramStateManager to determine if a
  ///  region change should trigger a processRegionChanges update.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::wantsRegionChangeUpdate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 266,
   FQN="clang::ento::ExprEngine::wantsRegionChangeUpdate", NM="_ZN5clang4ento10ExprEngine23wantsRegionChangeUpdateEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine23wantsRegionChangeUpdateEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
  //</editor-fold>
  @Override public boolean wantsRegionChangeUpdate(IntrusiveRefCntPtr</*const*/ ProgramState> state)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(getCheckerManager().wantsRegionChangeUpdate($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// processRegionChanges - Called by ProgramStateManager whenever a change is made
  ///  to the store. Used to update checkers that track region values.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::processRegionChanges">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 270,
   FQN="clang::ento::ExprEngine::processRegionChanges", NM="_ZN5clang4ento10ExprEngine20processRegionChangesEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISA_EEEENS2_8ArrayRefIPKNS0_9MemRegionEEESK_PKNS0_9CallEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine20processRegionChangesEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISA_EEEENS2_8ArrayRefIPKNS0_9MemRegionEEESK_PKNS0_9CallEventE")
  //</editor-fold>
  @Override public IntrusiveRefCntPtr</*const*/ ProgramState> processRegionChanges(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                      /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*P*/ invalidated, 
                      ArrayRef</*const*/ MemRegion /*P*/ > Explicits, 
                      ArrayRef</*const*/ MemRegion /*P*/ > Regions, 
                      /*const*/ CallEvent /*P*/ Call)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(getCheckerManager().runCheckersForRegionChanges($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), invalidated, 
          new ArrayRef</*const*/ MemRegion /*P*/ >(Explicits), new ArrayRef</*const*/ MemRegion /*P*/ >(Regions), Call));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// printState - Called by ProgramStateManager to print checker-specific data.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::printState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 280,
   FQN="clang::ento::ExprEngine::printState", NM="_ZN5clang4ento10ExprEngine10printStateERN4llvm11raw_ostreamENS2_18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKcSA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine10printStateERN4llvm11raw_ostreamENS2_18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKcSA_")
  //</editor-fold>
  @Override public void printState(final raw_ostream /*&*/ Out, IntrusiveRefCntPtr</*const*/ ProgramState> State, 
            /*const*/char$ptr/*char P*/ NL, /*const*/char$ptr/*char P*/ Sep)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      getCheckerManager().runCheckersForPrintState(Out, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), NL, Sep); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::getStateManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 305,
   FQN="clang::ento::ExprEngine::getStateManager", NM="_ZN5clang4ento10ExprEngine15getStateManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine15getStateManagerEv")
  //</editor-fold>
  @Override public ProgramStateManager /*&*/ getStateManager()/* override*/ {
    return StateMgr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::getStoreManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 307,
   FQN="clang::ento::ExprEngine::getStoreManager", NM="_ZN5clang4ento10ExprEngine15getStoreManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine15getStoreManagerEv")
  //</editor-fold>
  public StoreManager /*&*/ getStoreManager() {
    return StateMgr.getStoreManager();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::getConstraintManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 309,
   FQN="clang::ento::ExprEngine::getConstraintManager", NM="_ZN5clang4ento10ExprEngine20getConstraintManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine20getConstraintManagerEv")
  //</editor-fold>
  public ConstraintManager /*&*/ getConstraintManager() {
    return StateMgr.getConstraintManager();
  }

  
  // FIXME: Remove when we migrate over to just using SValBuilder.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::getBasicVals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 314,
   FQN="clang::ento::ExprEngine::getBasicVals", NM="_ZN5clang4ento10ExprEngine12getBasicValsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine12getBasicValsEv")
  //</editor-fold>
  public BasicValueFactory /*&*/ getBasicVals() {
    return StateMgr.getBasicVals();
  }

  
  // FIXME: Remove when we migrate over to just using ValueManager.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::getSymbolManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 319,
   FQN="clang::ento::ExprEngine::getSymbolManager", NM="_ZN5clang4ento10ExprEngine16getSymbolManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine16getSymbolManagerEv")
  //</editor-fold>
  public SymbolManager /*&*/ getSymbolManager() {
    return SymMgr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::getSymbolManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 320,
   FQN="clang::ento::ExprEngine::getSymbolManager", NM="_ZNK5clang4ento10ExprEngine16getSymbolManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento10ExprEngine16getSymbolManagerEv")
  //</editor-fold>
  public /*const*/ SymbolManager /*&*/ getSymbolManager$Const() /*const*/ {
    return SymMgr;
  }

  
  // Functions for external checking of whether we have unfinished work
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::wasBlocksExhausted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 323,
   FQN="clang::ento::ExprEngine::wasBlocksExhausted", NM="_ZNK5clang4ento10ExprEngine18wasBlocksExhaustedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento10ExprEngine18wasBlocksExhaustedEv")
  //</editor-fold>
  public boolean wasBlocksExhausted() /*const*/ {
    return Engine.wasBlocksExhausted();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::hasEmptyWorkList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 324,
   FQN="clang::ento::ExprEngine::hasEmptyWorkList", NM="_ZNK5clang4ento10ExprEngine16hasEmptyWorkListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento10ExprEngine16hasEmptyWorkListEv")
  //</editor-fold>
  public boolean hasEmptyWorkList() /*const*/ {
    return !Engine.getWorkList().hasWork();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::hasWorkRemaining">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 325,
   FQN="clang::ento::ExprEngine::hasWorkRemaining", NM="_ZNK5clang4ento10ExprEngine16hasWorkRemainingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento10ExprEngine16hasWorkRemainingEv")
  //</editor-fold>
  public boolean hasWorkRemaining() /*const*/ {
    return Engine.hasWorkRemaining();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::getCoreEngine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 327,
   FQN="clang::ento::ExprEngine::getCoreEngine", NM="_ZNK5clang4ento10ExprEngine13getCoreEngineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento10ExprEngine13getCoreEngineEv")
  //</editor-fold>
  public /*const*/ CoreEngine /*&*/ getCoreEngine() /*const*/ {
    return Engine;
  }

/*public:*/
  /// Visit - Transfer function logic for all statements.  Dispatches to
  ///  other functions that handle specific kinds of statements.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::Visit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 744,
   FQN="clang::ento::ExprEngine::Visit", NM="_ZN5clang4ento10ExprEngine5VisitEPKNS_4StmtEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine5VisitEPKNS_4StmtEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void Visit(/*const*/ Stmt /*P*/ S, ExplodedNode /*P*/ Pred, 
       final ExplodedNodeSet /*&*/ DstTop) {
    PrettyStackTraceLoc CrashInfo = null;
    ExplodedNodeSet Dst = null;
    StmtNodeBuilder Bldr = null;
    try {
      CrashInfo/*J*/= new PrettyStackTraceLoc(getContext().getSourceManager(), 
          S.getLocStart(), 
          $("Error evaluating statement"));
      Dst/*J*/= new ExplodedNodeSet();
      Bldr/*J*/= new StmtNodeBuilder(Pred, DstTop, $Deref(currBldrCtx));
      assert (!isa_Expr(S) || S == cast_Expr(S).IgnoreParens$Const());
      switch (S.getStmtClass()) {
       case ObjCIndirectCopyRestoreExprClass:
       case CXXDependentScopeMemberExprClass:
       case CXXInheritedCtorInitExprClass:
       case CXXTryStmtClass:
       case CXXTypeidExprClass:
       case CXXUuidofExprClass:
       case CXXFoldExprClass:
       case MSPropertyRefExprClass:
       case MSPropertySubscriptExprClass:
       case CXXUnresolvedConstructExprClass:
       case DependentScopeDeclRefExprClass:
       case ArrayTypeTraitExprClass:
       case ExpressionTraitExprClass:
       case UnresolvedLookupExprClass:
       case UnresolvedMemberExprClass:
       case TypoExprClass:
       case CXXNoexceptExprClass:
       case PackExpansionExprClass:
       case SubstNonTypeTemplateParmPackExprClass:
       case FunctionParmPackExprClass:
       case CoroutineBodyStmtClass:
       case CoawaitExprClass:
       case CoreturnStmtClass:
       case CoyieldExprClass:
       case SEHTryStmtClass:
       case SEHExceptStmtClass:
       case SEHLeaveStmtClass:
       case SEHFinallyStmtClass:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*const*/ ExplodedNode /*P*/ node = $c$.clean(Bldr.generateSink(S, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState()))));
            Engine.addAbortedBlock(node, currBldrCtx.getBlock());
            break;
          } finally {
            $c$.$destroy();
          }
        }
       case ParenExprClass:
        throw new llvm_unreachable("ParenExprs already handled.");
       case GenericSelectionExprClass:
        throw new llvm_unreachable("GenericSelectionExprs already handled.");
       case BreakStmtClass:
       case CaseStmtClass:
       case CompoundStmtClass:
       case ContinueStmtClass:
       case CXXForRangeStmtClass:
       case DefaultStmtClass:
       case DoStmtClass:
       case ForStmtClass:
       case GotoStmtClass:
       case IfStmtClass:
       case IndirectGotoStmtClass:
       case LabelStmtClass:
       case NoStmtClass:
       case NullStmtClass:
       case SwitchStmtClass:
       case WhileStmtClass:
       case MSDependentExistsStmtClass:
       case CapturedStmtClass:
       case OMPParallelDirectiveClass:
       case OMPSimdDirectiveClass:
       case OMPForDirectiveClass:
       case OMPForSimdDirectiveClass:
       case OMPSectionsDirectiveClass:
       case OMPSectionDirectiveClass:
       case OMPSingleDirectiveClass:
       case OMPMasterDirectiveClass:
       case OMPCriticalDirectiveClass:
       case OMPParallelForDirectiveClass:
       case OMPParallelForSimdDirectiveClass:
       case OMPParallelSectionsDirectiveClass:
       case OMPTaskDirectiveClass:
       case OMPTaskyieldDirectiveClass:
       case OMPBarrierDirectiveClass:
       case OMPTaskwaitDirectiveClass:
       case OMPTaskgroupDirectiveClass:
       case OMPFlushDirectiveClass:
       case OMPOrderedDirectiveClass:
       case OMPAtomicDirectiveClass:
       case OMPTargetDirectiveClass:
       case OMPTargetDataDirectiveClass:
       case OMPTargetEnterDataDirectiveClass:
       case OMPTargetExitDataDirectiveClass:
       case OMPTargetParallelDirectiveClass:
       case OMPTargetParallelForDirectiveClass:
       case OMPTargetUpdateDirectiveClass:
       case OMPTeamsDirectiveClass:
       case OMPCancellationPointDirectiveClass:
       case OMPCancelDirectiveClass:
       case OMPTaskLoopDirectiveClass:
       case OMPTaskLoopSimdDirectiveClass:
       case OMPDistributeDirectiveClass:
       case OMPDistributeParallelForDirectiveClass:
       case OMPDistributeParallelForSimdDirectiveClass:
       case OMPDistributeSimdDirectiveClass:
       case OMPTargetParallelForSimdDirectiveClass:
        // Cases that should never be evaluated simply because they shouldn't
        // appear in the CFG.
        throw new llvm_unreachable("Stmt should not be in analyzer evaluation loop");
       case ObjCSubscriptRefExprClass:
       case ObjCPropertyRefExprClass:
        throw new llvm_unreachable("These are handled by PseudoObjectExpr");
       case GNUNullExprClass:
        {
          IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // GNU __null is a pointer-width integer, not an actual pointer.
            state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
            $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(S, Pred.getLocationContext(), 
                    new SVal(JD$Move.INSTANCE, svalBuilder.makeIntValWithPtrWidth($int2ulong(0), false))))));
            $c$.clean(Bldr.generateNode(S, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
            break;
          } finally {
            if (state != null) { state.$destroy(); }
            $c$.$destroy();
          }
        }
       case ObjCAtSynchronizedStmtClass:
        Bldr.takeNodes(Pred);
        VisitObjCAtSynchronizedStmt(cast_ObjCAtSynchronizedStmt(S), Pred, Dst);
        Bldr.addNodes(Dst);
        break;
       case ExprWithCleanupsClass:
        // Handled due to fully linearised CFG.
        break;
       case CXXBindTemporaryExprClass:
        {
          ExplodedNodeSet PreVisit = null;
          ExplodedNodeSet Next = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            Bldr.takeNodes(Pred);
            PreVisit/*J*/= new ExplodedNodeSet();
            getCheckerManager().runCheckersForPreStmt(PreVisit, $c$.track(new ExplodedNodeSet(Pred)), S, /*Deref*/this); $c$.clean();
            Next/*J*/= new ExplodedNodeSet();
            VisitCXXBindTemporaryExpr(cast_CXXBindTemporaryExpr(S), PreVisit, Next);
            getCheckerManager().runCheckersForPostStmt(Dst, Next, S, /*Deref*/this);
            Bldr.addNodes(Dst);
            break;
          } finally {
            if (Next != null) { Next.$destroy(); }
            if (PreVisit != null) { PreVisit.$destroy(); }
            $c$.$destroy();
          }
        }
       case DesignatedInitExprClass:
       case DesignatedInitUpdateExprClass:
       case ExtVectorElementExprClass:
       case ImaginaryLiteralClass:
       case ObjCAtCatchStmtClass:
       case ObjCAtFinallyStmtClass:
       case ObjCAtTryStmtClass:
       case ObjCAutoreleasePoolStmtClass:
       case ObjCEncodeExprClass:
       case ObjCIsaExprClass:
       case ObjCProtocolExprClass:
       case ObjCSelectorExprClass:
       case ParenListExprClass:
       case ShuffleVectorExprClass:
       case ConvertVectorExprClass:
       case VAArgExprClass:
       case CUDAKernelCallExprClass:
       case OpaqueValueExprClass:
       case AsTypeExprClass:
       case PredefinedExprClass:
       case AddrLabelExprClass:
       case AttributedStmtClass:
       case IntegerLiteralClass:
       case CharacterLiteralClass:
       case ImplicitValueInitExprClass:
       case CXXScalarValueInitExprClass:
       case CXXBoolLiteralExprClass:
       case ObjCBoolLiteralExprClass:
       case ObjCAvailabilityCheckExprClass:
       case FloatingLiteralClass:
       case NoInitExprClass:
       case SizeOfPackExprClass:
       case StringLiteralClass:
       case ObjCStringLiteralClass:
       case CXXPseudoDestructorExprClass:
       case SubstNonTypeTemplateParmExprClass:
       case CXXNullPtrLiteralExprClass:
       case OMPArraySectionExprClass:
       case TypeTraitExprClass:
        {
          ExplodedNodeSet preVisit = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            Bldr.takeNodes(Pred);
            preVisit/*J*/= new ExplodedNodeSet();
            getCheckerManager().runCheckersForPreStmt(preVisit, $c$.track(new ExplodedNodeSet(Pred)), S, /*Deref*/this); $c$.clean();
            getCheckerManager().runCheckersForPostStmt(Dst, preVisit, S, /*Deref*/this);
            Bldr.addNodes(Dst);
            break;
          } finally {
            if (preVisit != null) { preVisit.$destroy(); }
            $c$.$destroy();
          }
        }
       case CXXDefaultArgExprClass:
       case CXXDefaultInitExprClass:
        {
          ExplodedNodeSet PreVisit = null;
          ExplodedNodeSet Tmp = null;
          StmtNodeBuilder Bldr2 = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            Bldr.takeNodes(Pred);
            PreVisit/*J*/= new ExplodedNodeSet();
            getCheckerManager().runCheckersForPreStmt(PreVisit, $c$.track(new ExplodedNodeSet(Pred)), S, /*Deref*/this); $c$.clean();
            
            Tmp/*J*/= new ExplodedNodeSet();
            Bldr2/*J*/= new StmtNodeBuilder(PreVisit, Tmp, $Deref(currBldrCtx));
            
            /*const*/ Expr /*P*/ ArgE;
            {
              /*const*/ CXXDefaultArgExpr /*P*/ DefE = dyn_cast_CXXDefaultArgExpr(S);
              if ((DefE != null)) {
                ArgE = DefE.getExpr$Const();
              } else {
                /*const*/ CXXDefaultInitExpr /*P*/ DefE$1 = dyn_cast_CXXDefaultInitExpr(S);
                if ((DefE$1 != null)) {
                  ArgE = DefE$1.getExpr$Const();
                } else {
                  throw new llvm_unreachable("unknown constant wrapper kind");
                }
              }
            }
            
            boolean IsTemporary = false;
            {
              /*const*/ MaterializeTemporaryExpr /*P*/ MTE = dyn_cast_MaterializeTemporaryExpr(ArgE);
              if ((MTE != null)) {
                ArgE = MTE.GetTemporaryExpr();
                IsTemporary = true;
              }
            }
            
            Optional<SVal> ConstantVal = svalBuilder.getConstantVal(ArgE);
            if (!ConstantVal.$bool()) {
              ConstantVal.$assign_T$RR(new UnknownVal());
            }
            
            /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
            for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = PreVisit.begin(), E = PreVisit.end();
                 I.$noteq(E); I.$preInc()) {
              IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
              try {
                State = new IntrusiveRefCntPtr</*const*/ ProgramState>((I.$star()).getState());
                $c$.clean(State.$assign($c$.track(State.$arrow().BindExpr(S, LCtx, new SVal(ConstantVal.$star())))));
                if (IsTemporary) {
                  $c$.clean(State.$assign($c$.track(createTemporaryRegionIfNeeded($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), LCtx, 
                          cast_Expr(S), 
                          cast_Expr(S)))));
                }
                $c$.clean(Bldr2.generateNode(S, I.$star(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
              } finally {
               if (State != null) { State.$destroy(); }
              } 
            }
            
            getCheckerManager().runCheckersForPostStmt(Dst, Tmp, S, /*Deref*/this);
            Bldr.addNodes(Dst);
            break;
          } finally {
            if (Bldr2 != null) { Bldr2.$destroy(); }
            if (Tmp != null) { Tmp.$destroy(); }
            if (PreVisit != null) { PreVisit.$destroy(); }
            $c$.$destroy();
          }
        }
       case CXXStdInitializerListExprClass:
       case ObjCArrayLiteralClass:
       case ObjCDictionaryLiteralClass:
       case ObjCBoxedExprClass:
        {
          ExplodedNodeSet preVisit = null;
          ExplodedNodeSet Tmp = null;
          StmtNodeBuilder Bldr2 = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            Bldr.takeNodes(Pred);
            
            preVisit/*J*/= new ExplodedNodeSet();
            getCheckerManager().runCheckersForPreStmt(preVisit, $c$.track(new ExplodedNodeSet(Pred)), S, /*Deref*/this); $c$.clean();
            
            Tmp/*J*/= new ExplodedNodeSet();
            Bldr2/*J*/= new StmtNodeBuilder(preVisit, Tmp, $Deref(currBldrCtx));
            
            /*const*/ Expr /*P*/ Ex = cast_Expr(S);
            QualType resultType = Ex.getType();
            
            for (SmallPtrSetIterator<ExplodedNode /*P*/ > it = preVisit.begin(), et = preVisit.end();
                 it.$noteq(et); it.$preInc()) {
              IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
              try {
                ExplodedNode /*P*/ N = it.$star();
                /*const*/ LocationContext /*P*/ LCtx = N.getLocationContext();
                SVal result = new SVal(JD$Move.INSTANCE, svalBuilder.conjureSymbolVal((/*const*/Object/*void P*/ )null, Ex, LCtx, 
                        new QualType(resultType), 
                        currBldrCtx.blockCount()));
                state = N.getState().$arrow().BindExpr(Ex, LCtx, new SVal(result));
                $c$.clean(Bldr2.generateNode(S, N, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
              } finally {
                if (state != null) { state.$destroy(); }
              }
            }
            
            getCheckerManager().runCheckersForPostStmt(Dst, Tmp, S, /*Deref*/this);
            Bldr.addNodes(Dst);
            break;
          } finally {
            if (Bldr2 != null) { Bldr2.$destroy(); }
            if (Tmp != null) { Tmp.$destroy(); }
            if (preVisit != null) { preVisit.$destroy(); }
            $c$.$destroy();
          }
        }
       case ArraySubscriptExprClass:
        Bldr.takeNodes(Pred);
        VisitLvalArraySubscriptExpr(cast_ArraySubscriptExpr(S), Pred, Dst);
        Bldr.addNodes(Dst);
        break;
       case GCCAsmStmtClass:
        Bldr.takeNodes(Pred);
        VisitGCCAsmStmt(cast_GCCAsmStmt(S), Pred, Dst);
        Bldr.addNodes(Dst);
        break;
       case MSAsmStmtClass:
        Bldr.takeNodes(Pred);
        VisitMSAsmStmt(cast_MSAsmStmt(S), Pred, Dst);
        Bldr.addNodes(Dst);
        break;
       case BlockExprClass:
        Bldr.takeNodes(Pred);
        VisitBlockExpr(cast_BlockExpr(S), Pred, Dst);
        Bldr.addNodes(Dst);
        break;
       case LambdaExprClass:
        if (AMgr.options.shouldInlineLambdas()) {
          Bldr.takeNodes(Pred);
          VisitLambdaExpr(cast_LambdaExpr(S), Pred, Dst);
          Bldr.addNodes(Dst);
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*const*/ ExplodedNode /*P*/ node = $c$.clean(Bldr.generateSink(S, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState()))));
            Engine.addAbortedBlock(node, currBldrCtx.getBlock());
          } finally {
            $c$.$destroy();
          }
        }
        break;
       case BinaryOperatorClass:
        {
          /*const*/ BinaryOperator /*P*/ B = cast_BinaryOperator(S);
          if (B.isLogicalOp()) {
            Bldr.takeNodes(Pred);
            VisitLogicalExpr(B, Pred, Dst);
            Bldr.addNodes(Dst);
            break;
          } else if (B.getOpcode() == BinaryOperatorKind.BO_Comma) {
            IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
              $c$.clean(Bldr.generateNode(B, Pred, 
                  $c$.track(state.$arrow().BindExpr(B, Pred.getLocationContext(), 
                      state.$arrow().getSVal(B.getRHS(), 
                          Pred.getLocationContext())))));
              break;
            } finally {
              if (state != null) { state.$destroy(); }
              $c$.$destroy();
            }
          }
          
          Bldr.takeNodes(Pred);
          if (AMgr.options.eagerlyAssumeBinOpBifurcation
             && (B.isRelationalOp() || B.isEqualityOp())) {
            ExplodedNodeSet Tmp = null;
            try {
              Tmp/*J*/= new ExplodedNodeSet();
              VisitBinaryOperator(cast_BinaryOperator(S), Pred, Tmp);
              evalEagerlyAssumeBinOpBifurcation(Dst, Tmp, cast_Expr(S));
            } finally {
              if (Tmp != null) { Tmp.$destroy(); }
            }
          } else {
            VisitBinaryOperator(cast_BinaryOperator(S), Pred, Dst);
          }
          
          Bldr.addNodes(Dst);
          break;
        }
       case CXXOperatorCallExprClass:
        {
          /*const*/ CXXOperatorCallExpr /*P*/ OCE = cast_CXXOperatorCallExpr(S);
          
          // For instance method operators, make sure the 'this' argument has a
          // valid region.
          /*const*/ Decl /*P*/ Callee = OCE.getCalleeDecl$Const();
          {
            /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_or_null_CXXMethodDecl(Callee);
            if ((MD != null)) {
              if (MD.isInstance()) {
                IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
                IntrusiveRefCntPtr</*const*/ ProgramState> NewState = null;
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
                  /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
                  NewState = $c$.clean(createTemporaryRegionIfNeeded($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), LCtx, OCE.getArg$Const(0)));
                  if ($noteq_IntrusiveRefCntPtr(NewState, State)) {
                    $c$.clean(Pred = Bldr.generateNode(OCE, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(NewState)), /*Tag=*/ (/*const*/ ProgramPointTag /*P*/ )null, 
                        ProgramPoint.Kind.PreStmtKind));
                    // Did we cache out?
                    if (!(Pred != null)) {
                      break;
                    }
                  }
                } finally {
                  if (NewState != null) { NewState.$destroy(); }
                  if (State != null) { State.$destroy(); }
                  $c$.$destroy();
                }
              }
            }
          }
          // FALLTHROUGH
        }
       case CallExprClass:
       case CXXMemberCallExprClass:
       case UserDefinedLiteralClass:
        {
          Bldr.takeNodes(Pred);
          VisitCallExpr(cast_CallExpr(S), Pred, Dst);
          Bldr.addNodes(Dst);
          break;
        }
       case CXXCatchStmtClass:
        {
          Bldr.takeNodes(Pred);
          VisitCXXCatchStmt(cast_CXXCatchStmt(S), Pred, Dst);
          Bldr.addNodes(Dst);
          break;
        }
       case CXXTemporaryObjectExprClass:
       case CXXConstructExprClass:
        {
          Bldr.takeNodes(Pred);
          VisitCXXConstructExpr(cast_CXXConstructExpr(S), Pred, Dst);
          Bldr.addNodes(Dst);
          break;
        }
       case CXXNewExprClass:
        {
          ExplodedNodeSet PostVisit = null;
          try {
            Bldr.takeNodes(Pred);
            PostVisit/*J*/= new ExplodedNodeSet();
            VisitCXXNewExpr(cast_CXXNewExpr(S), Pred, PostVisit);
            getCheckerManager().runCheckersForPostStmt(Dst, PostVisit, S, /*Deref*/this);
            Bldr.addNodes(Dst);
            break;
          } finally {
            if (PostVisit != null) { PostVisit.$destroy(); }
          }
        }
       case CXXDeleteExprClass:
        {
          ExplodedNodeSet PreVisit = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            Bldr.takeNodes(Pred);
            PreVisit/*J*/= new ExplodedNodeSet();
            /*const*/ CXXDeleteExpr /*P*/ CDE = cast_CXXDeleteExpr(S);
            getCheckerManager().runCheckersForPreStmt(PreVisit, $c$.track(new ExplodedNodeSet(Pred)), S, /*Deref*/this); $c$.clean();
            
            for (SmallPtrSetIterator<ExplodedNode /*P*/ > i = PreVisit.begin(), 
                e = PreVisit.end(); i.$noteq(e); i.$preInc())  {
              VisitCXXDeleteExpr(CDE, i.$star(), Dst);
            }
            
            Bldr.addNodes(Dst);
            break;
          } finally {
            if (PreVisit != null) { PreVisit.$destroy(); }
            $c$.$destroy();
          }
        }
       case ChooseExprClass:
        { // __builtin_choose_expr
          Bldr.takeNodes(Pred);
          /*const*/ ChooseExpr /*P*/ C = cast_ChooseExpr(S);
          VisitGuardedExpr(C, C.getLHS(), C.getRHS(), Pred, Dst);
          Bldr.addNodes(Dst);
          break;
        }
       case CompoundAssignOperatorClass:
        Bldr.takeNodes(Pred);
        VisitBinaryOperator(cast_BinaryOperator(S), Pred, Dst);
        Bldr.addNodes(Dst);
        break;
       case CompoundLiteralExprClass:
        Bldr.takeNodes(Pred);
        VisitCompoundLiteralExpr(cast_CompoundLiteralExpr(S), Pred, Dst);
        Bldr.addNodes(Dst);
        break;
       case BinaryConditionalOperatorClass:
       case ConditionalOperatorClass:
        { // '?' operator
          Bldr.takeNodes(Pred);
          /*const*/ AbstractConditionalOperator /*P*/ C = cast_AbstractConditionalOperator(S);
          VisitGuardedExpr(C, C.getTrueExpr(), C.getFalseExpr(), Pred, Dst);
          Bldr.addNodes(Dst);
          break;
        }
       case CXXThisExprClass:
        Bldr.takeNodes(Pred);
        VisitCXXThisExpr(cast_CXXThisExpr(S), Pred, Dst);
        Bldr.addNodes(Dst);
        break;
       case DeclRefExprClass:
        {
          Bldr.takeNodes(Pred);
          /*const*/ DeclRefExpr /*P*/ DE = cast_DeclRefExpr(S);
          VisitCommonDeclRefExpr(DE, DE.getDecl$Const(), Pred, Dst);
          Bldr.addNodes(Dst);
          break;
        }
       case DeclStmtClass:
        Bldr.takeNodes(Pred);
        VisitDeclStmt(cast_DeclStmt(S), Pred, Dst);
        Bldr.addNodes(Dst);
        break;
       case ImplicitCastExprClass:
       case CStyleCastExprClass:
       case CXXStaticCastExprClass:
       case CXXDynamicCastExprClass:
       case CXXReinterpretCastExprClass:
       case CXXConstCastExprClass:
       case CXXFunctionalCastExprClass:
       case ObjCBridgedCastExprClass:
        {
          ExplodedNodeSet dstPrevisit = null;
          ExplodedNodeSet dstExpr = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            Bldr.takeNodes(Pred);
            /*const*/ CastExpr /*P*/ C = cast_CastExpr(S);
            // Handle the previsit checks.
            dstPrevisit/*J*/= new ExplodedNodeSet();
            getCheckerManager().runCheckersForPreStmt(dstPrevisit, $c$.track(new ExplodedNodeSet(Pred)), C, /*Deref*/this); $c$.clean();
            
            // Handle the expression itself.
            dstExpr/*J*/= new ExplodedNodeSet();
            for (SmallPtrSetIterator<ExplodedNode /*P*/ > i = dstPrevisit.begin(), 
                e = dstPrevisit.end(); i.$noteq(e); i.$preInc()) {
              VisitCast(C, C.getSubExpr$Const(), i.$star(), dstExpr);
            }
            
            // Handle the postvisit checks.
            getCheckerManager().runCheckersForPostStmt(Dst, dstExpr, C, /*Deref*/this);
            Bldr.addNodes(Dst);
            break;
          } finally {
            if (dstExpr != null) { dstExpr.$destroy(); }
            if (dstPrevisit != null) { dstPrevisit.$destroy(); }
            $c$.$destroy();
          }
        }
       case MaterializeTemporaryExprClass:
        {
          Bldr.takeNodes(Pred);
          /*const*/ MaterializeTemporaryExpr /*P*/ MTE = cast_MaterializeTemporaryExpr(S);
          CreateCXXTemporaryObject(MTE, Pred, Dst);
          Bldr.addNodes(Dst);
          break;
        }
       case InitListExprClass:
        Bldr.takeNodes(Pred);
        VisitInitListExpr(cast_InitListExpr(S), Pred, Dst);
        Bldr.addNodes(Dst);
        break;
       case MemberExprClass:
        Bldr.takeNodes(Pred);
        VisitMemberExpr(cast_MemberExpr(S), Pred, Dst);
        Bldr.addNodes(Dst);
        break;
       case AtomicExprClass:
        Bldr.takeNodes(Pred);
        VisitAtomicExpr(cast_AtomicExpr(S), Pred, Dst);
        Bldr.addNodes(Dst);
        break;
       case ObjCIvarRefExprClass:
        Bldr.takeNodes(Pred);
        VisitLvalObjCIvarRefExpr(cast_ObjCIvarRefExpr(S), Pred, Dst);
        Bldr.addNodes(Dst);
        break;
       case ObjCForCollectionStmtClass:
        Bldr.takeNodes(Pred);
        VisitObjCForCollectionStmt(cast_ObjCForCollectionStmt(S), Pred, Dst);
        Bldr.addNodes(Dst);
        break;
       case ObjCMessageExprClass:
        Bldr.takeNodes(Pred);
        VisitObjCMessage(cast_ObjCMessageExpr(S), Pred, Dst);
        Bldr.addNodes(Dst);
        break;
       case ObjCAtThrowStmtClass:
       case CXXThrowExprClass:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // FIXME: This is not complete.  We basically treat @throw as
            // an abort.
            $c$.clean(Bldr.generateSink(S, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState()))));
            break;
          } finally {
            $c$.$destroy();
          }
        }
       case ReturnStmtClass:
        Bldr.takeNodes(Pred);
        VisitReturnStmt(cast_ReturnStmt(S), Pred, Dst);
        Bldr.addNodes(Dst);
        break;
       case OffsetOfExprClass:
        Bldr.takeNodes(Pred);
        VisitOffsetOfExpr(cast_OffsetOfExpr(S), Pred, Dst);
        Bldr.addNodes(Dst);
        break;
       case UnaryExprOrTypeTraitExprClass:
        Bldr.takeNodes(Pred);
        VisitUnaryExprOrTypeTraitExpr(cast_UnaryExprOrTypeTraitExpr(S), 
            Pred, Dst);
        Bldr.addNodes(Dst);
        break;
       case StmtExprClass:
        {
          /*const*/ StmtExpr /*P*/ SE = cast_StmtExpr(S);
          if (SE.getSubStmt$Const().body_empty()) {
            // Empty statement expression.
            assert (QualType.$eq_QualType$C(SE.getType(), getContext().VoidTy.$QualType())) : "Empty statement expression must have void type.";
            break;
          }
          {
            
            Expr /*P*/ LastExpr = dyn_cast_Expr(SE.getSubStmt$Const().body_rbegin$Const().$star());
            if ((LastExpr != null)) {
              IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
                $c$.clean(Bldr.generateNode(SE, Pred, 
                    $c$.track(state.$arrow().BindExpr(SE, Pred.getLocationContext(), 
                        state.$arrow().getSVal(LastExpr, 
                            Pred.getLocationContext())))));
              } finally {
                if (state != null) { state.$destroy(); }
                $c$.$destroy();
              }
            }
          }
          break;
        }
       case UnaryOperatorClass:
        {
          Bldr.takeNodes(Pred);
          /*const*/ UnaryOperator /*P*/ U = cast_UnaryOperator(S);
          if (AMgr.options.eagerlyAssumeBinOpBifurcation && (U.getOpcode() == UnaryOperatorKind.UO_LNot)) {
            ExplodedNodeSet Tmp = null;
            try {
              Tmp/*J*/= new ExplodedNodeSet();
              VisitUnaryOperator(U, Pred, Tmp);
              evalEagerlyAssumeBinOpBifurcation(Dst, Tmp, U);
            } finally {
              if (Tmp != null) { Tmp.$destroy(); }
            }
          } else {
            VisitUnaryOperator(U, Pred, Dst);
          }
          Bldr.addNodes(Dst);
          break;
        }
       case PseudoObjectExprClass:
        {
          IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
          try {
            Bldr.takeNodes(Pred);
            state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
            /*const*/ PseudoObjectExpr /*P*/ PE = cast_PseudoObjectExpr(S);
            {
              /*const*/ Expr /*P*/ Result = PE.getResultExpr$Const();
              if ((Result != null)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  SVal V = state.$arrow().getSVal(Result, Pred.getLocationContext());
                  $c$.clean(Bldr.generateNode(S, Pred, 
                      $c$.track(state.$arrow().BindExpr(S, Pred.getLocationContext(), new SVal(V)))));
                } finally {
                  $c$.$destroy();
                }
              } else {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean(Bldr.generateNode(S, Pred, 
                      $c$.track(state.$arrow().BindExpr(S, Pred.getLocationContext(), 
                          new SVal(JD$Move.INSTANCE, new UnknownVal())))));
                } finally {
                  $c$.$destroy();
                }
              }
            }

            Bldr.addNodes(Dst);
            break;
          } finally {
           if (state != null) { state.$destroy(); }
          } 
        }
      }
    } finally {
      if (Bldr != null) { Bldr.$destroy(); }
      if (Dst != null) { Dst.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }

  
  /// VisitArraySubscriptExpr - Transfer function for array accesses.
  
  /// VisitArraySubscriptExpr - Transfer function for array accesses
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitLvalArraySubscriptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 1971,
   FQN="clang::ento::ExprEngine::VisitLvalArraySubscriptExpr", NM="_ZN5clang4ento10ExprEngine27VisitLvalArraySubscriptExprEPKNS_18ArraySubscriptExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine27VisitLvalArraySubscriptExprEPKNS_18ArraySubscriptExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitLvalArraySubscriptExpr(/*const*/ ArraySubscriptExpr /*P*/ A, 
                             ExplodedNode /*P*/ Pred, 
                             final ExplodedNodeSet /*&*/ Dst) {
    ExplodedNodeSet checkerPreStmt = null;
    StmtNodeBuilder Bldr = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      /*const*/ Expr /*P*/ Base = A.getBase$Const().IgnoreParens$Const();
      /*const*/ Expr /*P*/ Idx = A.getIdx$Const().IgnoreParens$Const();
      
      checkerPreStmt/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForPreStmt(checkerPreStmt, $c$.track(new ExplodedNodeSet(Pred)), A, /*Deref*/this); $c$.clean();
      
      Bldr/*J*/= new StmtNodeBuilder(checkerPreStmt, Dst, $Deref(currBldrCtx));
      assert (A.isGLValue() || (!AMgr.getLangOpts().CPlusPlus && A.getType().isCForbiddenLValueType()));
      
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > it = checkerPreStmt.begin(), 
          ei = checkerPreStmt.end(); it.$noteq(ei); it.$preInc()) {
       IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
        try {
          /*const*/ LocationContext /*P*/ LCtx = (it.$star()).getLocationContext();
          state = new IntrusiveRefCntPtr</*const*/ ProgramState>((it.$star()).getState());
          SVal V = state.$arrow().getLValue(A.getType(), 
              state.$arrow().getSVal(Idx, LCtx), 
              state.$arrow().getSVal(Base, LCtx));
          $c$.clean(Bldr.generateNode(A, it.$star(), $c$.track(state.$arrow().BindExpr(A, LCtx, new SVal(V))), (/*const*/ ProgramPointTag /*P*/ )null, 
              ProgramPoint.Kind.PostLValueKind));
        } finally {
         if (state != null) { state.$destroy(); }
        }
      }
    } finally {
      if (Bldr != null) { Bldr.$destroy(); }
      if (checkerPreStmt != null) { checkerPreStmt.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// VisitGCCAsmStmt - Transfer function logic for inline asm.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitGCCAsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2477,
   FQN="clang::ento::ExprEngine::VisitGCCAsmStmt", NM="_ZN5clang4ento10ExprEngine15VisitGCCAsmStmtEPKNS_10GCCAsmStmtEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine15VisitGCCAsmStmtEPKNS_10GCCAsmStmtEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitGCCAsmStmt(/*const*/ GCCAsmStmt /*P*/ A, ExplodedNode /*P*/ Pred, 
                 final ExplodedNodeSet /*&*/ Dst) {
    StmtNodeBuilder Bldr = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Bldr/*J*/= new StmtNodeBuilder(Pred, Dst, $Deref(currBldrCtx));
      // We have processed both the inputs and the outputs.  All of the outputs
      // should evaluate to Locs.  Nuke all of their values.
      
      // FIXME: Some day in the future it would be nice to allow a "plug-in"
      // which interprets the inline asm and stores proper results in the
      // outputs.
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      
      for (/*const*/ Expr /*P*/ O : A.outputs$Const()) {
        SVal X = state.$arrow().getSVal(O, Pred.getLocationContext());
        assert (!X.getAs(NonLoc.class).$bool()); // Should be an Lval, or unknown, undef.
        {
          
          Optional<Loc> LV = X.getAs(Loc.class);
          if (LV.$bool()) {
            $c$.clean(state.$assign($c$.track(state.$arrow().bindLoc(new Loc(LV.$star()), new SVal(JD$Move.INSTANCE, new UnknownVal())))));
          }
        }
      }
      
      $c$.clean(Bldr.generateNode(A, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      if (state != null) { state.$destroy(); }
      if (Bldr != null) { Bldr.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// VisitMSAsmStmt - Transfer function logic for MS inline asm.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitMSAsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2500,
   FQN="clang::ento::ExprEngine::VisitMSAsmStmt", NM="_ZN5clang4ento10ExprEngine14VisitMSAsmStmtEPKNS_9MSAsmStmtEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine14VisitMSAsmStmtEPKNS_9MSAsmStmtEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitMSAsmStmt(/*const*/ MSAsmStmt /*P*/ A, ExplodedNode /*P*/ Pred, 
                final ExplodedNodeSet /*&*/ Dst) {
    StmtNodeBuilder Bldr = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Bldr/*J*/= new StmtNodeBuilder(Pred, Dst, $Deref(currBldrCtx));
      $c$.clean(Bldr.generateNode(A, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState()))));
    } finally {
      if (Bldr != null) { Bldr.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// VisitBlockExpr - Transfer function logic for BlockExprs.
  
  /// VisitBlockExpr - Transfer function logic for BlockExprs.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitBlockExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp", line = 187,
   FQN="clang::ento::ExprEngine::VisitBlockExpr", NM="_ZN5clang4ento10ExprEngine14VisitBlockExprEPKNS_9BlockExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp -nm=_ZN5clang4ento10ExprEngine14VisitBlockExprEPKNS_9BlockExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitBlockExpr(/*const*/ BlockExpr /*P*/ BE, ExplodedNode /*P*/ Pred, 
                final ExplodedNodeSet /*&*/ Dst) {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    ExplodedNodeSet Tmp = null;
    StmtNodeBuilder Bldr = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      CanQual<Type> T = getContext().getCanonicalType(BE.getType());
      
      /*const*/ BlockDecl /*P*/ BD = BE.getBlockDecl$Const();
      // Get the value of the block itself.
      SVal V = new SVal(JD$Move.INSTANCE, svalBuilder.getBlockPointer(BD, new CanQual<Type>(T), 
              Pred.getLocationContext(), 
              currBldrCtx.blockCount()));
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      {
        
        // If we created a new MemRegion for the block, we should explicitly bind
        // the captured variables.
        /*const*/ BlockDataRegion /*P*/ BDR = dyn_cast_or_null_BlockDataRegion(V.getAsRegion());
        if ((BDR != null)) {
          
          BlockDataRegion.referenced_vars_iterator I = BDR.referenced_vars_begin();
          BlockDataRegion.referenced_vars_iterator E = BDR.referenced_vars_end();
          
          type$ptr<BlockDecl.Capture> CI = $tryClone(BD.capture_begin());
          type$ptr<BlockDecl.Capture> CE = $tryClone(BD.capture_end());
          for (; I.$noteq(E); I.$preInc()) {
            /*const*/ VarRegion /*P*/ capturedR = I.getCapturedRegion();
            /*const*/ VarRegion /*P*/ originalR = I.getOriginalRegion();
            
            // If the capture had a copy expression, use the result of evaluating
            // that expression, otherwise use the original value.
            // We rely on the invariant that the block declaration's capture variables
            // are a prefix of the BlockDataRegion's referenced vars (which may include
            // referenced globals, etc.) to enable fast lookup of the capture for a
            // given referenced var.
            /*const*/ Expr /*P*/ copyExpr = null;
            if ($noteq_ptr(CI, CE)) {
              assert (CI./*->*/$star().getVariable() == capturedR.getDecl());
              copyExpr = CI./*->*/$star().getCopyExpr();
              CI.$postInc();
            }
            if (capturedR != originalR) {
              SVal originalV/*J*/= new SVal();
              if ((copyExpr != null)) {
                originalV.$assignMove(State.$arrow().getSVal(copyExpr, Pred.getLocationContext()));
              } else {
                originalV.$assignMove(State.$arrow().getSVal(new Loc(JD$Move.INSTANCE, new NsLoc.MemRegionVal(originalR))));
              }
              $c$.clean(State.$assign($c$.track(State.$arrow().bindLoc(new Loc(JD$Move.INSTANCE, new NsLoc.MemRegionVal(capturedR)), new SVal(originalV)))));
            }
          }
        }
      }
      
      Tmp/*J*/= new ExplodedNodeSet();
      Bldr/*J*/= new StmtNodeBuilder(Pred, Tmp, $Deref(currBldrCtx));
      $c$.clean(Bldr.generateNode(BE, Pred, 
          $c$.track(State.$arrow().BindExpr(BE, Pred.getLocationContext(), new SVal(V))), 
          (/*const*/ ProgramPointTag /*P*/ )null, ProgramPoint.Kind.PostLValueKind));
      
      // FIXME: Move all post/pre visits to ::Visit().
      getCheckerManager().runCheckersForPostStmt(Dst, Tmp, BE, /*Deref*/this);
    } finally {
      if (Bldr != null) { Bldr.$destroy(); }
      if (Tmp != null) { Tmp.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }


  
  /// VisitLambdaExpr - Transfer function logic for LambdaExprs.
  
  /// VisitLambdaExpr - Transfer function logic for LambdaExprs.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitLambdaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp", line = 573,
   FQN="clang::ento::ExprEngine::VisitLambdaExpr", NM="_ZN5clang4ento10ExprEngine15VisitLambdaExprEPKNS_10LambdaExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp -nm=_ZN5clang4ento10ExprEngine15VisitLambdaExprEPKNS_10LambdaExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitLambdaExpr(/*const*/ LambdaExpr /*P*/ LE, ExplodedNode /*P*/ Pred, 
                 final ExplodedNodeSet /*&*/ Dst) {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    ExplodedNodeSet Tmp = null;
    StmtNodeBuilder Bldr = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ LocationContext /*P*/ LocCtxt = Pred.getLocationContext();
      
      // Get the region of the lambda itself.
      /*const*/ MemRegion /*P*/ R = svalBuilder.getRegionManager().getCXXTempObjectRegion(LE, LocCtxt);
      SVal V = new SVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(R));
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      
      // If we created a new MemRegion for the lambda, we should explicitly bind
      // the captures.
      DeclContext.specific_decl_iterator<FieldDecl> CurField = LE.getLambdaClass().field_begin();
      for (type$ptr<Expr /*P*/ /*const*/ /*P*/> i = $tryClone(LE.capture_init_begin$Const()), 
          /*P*/ /*const*/ /*P*/ e = $tryClone(LE.capture_init_end$Const());
           $noteq_ptr(i, e); i.$preInc() , CurField.$preInc()) {
        FieldDecl /*P*/ FieldForCapture = CurField.$star();
        SVal FieldLoc = State.$arrow().getLValue(FieldForCapture, new SVal(V));
        
        SVal InitVal/*J*/= new SVal();
        if (!FieldForCapture.hasCapturedVLAType()) {
          Expr /*P*/ InitExpr = i.$star();
          assert ((InitExpr != null)) : "Capture missing initialization expression";
          InitVal.$assignMove(State.$arrow().getSVal(InitExpr, LocCtxt));
        } else {
          // The field stores the length of a captured variable-length array.
          // These captures don't have initialization expressions; instead we
          // get the length from the VLAType size expression.
          Expr /*P*/ SizeExpr = FieldForCapture.getCapturedVLAType().getSizeExpr();
          InitVal.$assignMove(State.$arrow().getSVal(SizeExpr, LocCtxt));
        }
        
        $c$.clean(State.$assign($c$.track(State.$arrow().bindLoc(new SVal(FieldLoc), new SVal(InitVal)))));
      }
      
      // Decay the Loc into an RValue, because there might be a
      // MaterializeTemporaryExpr node above this one which expects the bound value
      // to be an RValue.
      SVal LambdaRVal = State.$arrow().getSVal(R);
      
      Tmp/*J*/= new ExplodedNodeSet();
      Bldr/*J*/= new StmtNodeBuilder(Pred, Tmp, $Deref(currBldrCtx));
      // FIXME: is this the right program point kind?
      $c$.clean(Bldr.generateNode(LE, Pred, 
          $c$.track(State.$arrow().BindExpr(LE, LocCtxt, new SVal(LambdaRVal))), 
          (/*const*/ ProgramPointTag /*P*/ )null, ProgramPoint.Kind.PostLValueKind));
      
      // FIXME: Move all post/pre visits to ::Visit().
      getCheckerManager().runCheckersForPostStmt(Dst, Tmp, LE, /*Deref*/this);
    } finally {
      if (Bldr != null) { Bldr.$destroy(); }
      if (Tmp != null) { Tmp.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }


  
  /// VisitBinaryOperator - Transfer function logic for binary operators.
  
  /// VisitBinaryOperator - Transfer function logic for binary operators.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp", line = 22,
   FQN="clang::ento::ExprEngine::VisitBinaryOperator", NM="_ZN5clang4ento10ExprEngine19VisitBinaryOperatorEPKNS_14BinaryOperatorEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp -nm=_ZN5clang4ento10ExprEngine19VisitBinaryOperatorEPKNS_14BinaryOperatorEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitBinaryOperator(/*const*/ BinaryOperator /*P*/ B, 
                     ExplodedNode /*P*/ Pred, 
                     final ExplodedNodeSet /*&*/ Dst) {
    ExplodedNodeSet CheckedSet = null;
    ExplodedNodeSet Tmp2 = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      Expr /*P*/ LHS = B.getLHS().IgnoreParens();
      Expr /*P*/ RHS = B.getRHS().IgnoreParens();
      
      // FIXME: Prechecks eventually go in ::Visit().
      CheckedSet/*J*/= new ExplodedNodeSet();
      Tmp2/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForPreStmt(CheckedSet, $c$.track(new ExplodedNodeSet(Pred)), B, /*Deref*/this); $c$.clean();
      
      // With both the LHS and RHS evaluated, process the operation itself.
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > it = CheckedSet.begin(), ei = CheckedSet.end();
           it.$noteq(ei); it.$preInc()) {
        IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
        ExplodedNodeSet Tmp = null;
        try {
          
          state = new IntrusiveRefCntPtr</*const*/ ProgramState>((it.$star()).getState());
          /*const*/ LocationContext /*P*/ LCtx = (it.$star()).getLocationContext();
          SVal LeftV = state.$arrow().getSVal(LHS, LCtx);
          SVal RightV = state.$arrow().getSVal(RHS, LCtx);
          
          BinaryOperatorKind Op = B.getOpcode();
          if (Op == BinaryOperatorKind.BO_Assign) {
            // EXPERIMENTAL: "Conjured" symbols.
            // FIXME: Handle structs.
            if (RightV.isUnknown$SVal()) {
              /*uint*/int Count = currBldrCtx.blockCount();
              RightV.$assignMove(svalBuilder.conjureSymbolVal((/*const*/Object/*void P*/ )null, B.getRHS(), LCtx, 
                      Count));
            }
            // Simulate the effects of a "store":  bind the value of the RHS
            // to the L-Value represented by the LHS.
            SVal ExprVal = new SVal(B.isGLValue() ? LeftV : RightV);
            evalStore(Tmp2, B, LHS, it.$star(), $c$.track(state.$arrow().BindExpr(B, LCtx, new SVal(ExprVal))), 
                new SVal(LeftV), new SVal(RightV)); $c$.clean();
            continue;
          }
          if (!B.isAssignmentOp()) {
            StmtNodeBuilder Bldr = null;
            try {
              Bldr/*J*/= new StmtNodeBuilder(it.$star(), Tmp2, $Deref(currBldrCtx));
              if (B.isAdditiveOp()) {
                // If one of the operands is a location, conjure a symbol for the other
                // one (offset) if it's unknown so that memory arithmetic always
                // results in an ElementRegion.
                // TODO: This can be removed after we enable history tracking with
                // SymSymExpr.
                /*uint*/int Count = currBldrCtx.blockCount();
                if (LeftV.getAs(Loc.class).$bool()
                   && RHS.getType().$arrow().isIntegralOrEnumerationType()
                   && RightV.isUnknown$SVal()) {
                  RightV.$assignMove(svalBuilder.conjureSymbolVal(RHS, LCtx, RHS.getType(), 
                          Count));
                }
                if (RightV.getAs(Loc.class).$bool()
                   && LHS.getType().$arrow().isIntegralOrEnumerationType()
                   && LeftV.isUnknown$SVal()) {
                  LeftV.$assignMove(svalBuilder.conjureSymbolVal(LHS, LCtx, LHS.getType(), 
                          Count));
                }
              }
              
              // Although we don't yet model pointers-to-members, we do need to make
              // sure that the members of temporaries have a valid 'this' pointer for
              // other checks.
              if (B.getOpcode() == BinaryOperatorKind.BO_PtrMemD) {
                $c$.clean(state.$assign($c$.track(createTemporaryRegionIfNeeded($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), LCtx, LHS))));
              }
              
              // Process non-assignments except commas or short-circuited
              // logical expressions (LAnd and LOr).
              SVal Result = $c$.clean(evalBinOp($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Op, new SVal(LeftV), new SVal(RightV), B.getType()));
              if (Result.isUnknown$SVal()) {
                $c$.clean(Bldr.generateNode(B, it.$star(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
                continue;
              }
              
              $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(B, LCtx, new SVal(Result)))));
              $c$.clean(Bldr.generateNode(B, it.$star(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
              continue;
            } finally {
              if (Bldr != null) { Bldr.$destroy(); }
            }
          }
          assert (B.isCompoundAssignmentOp());
          switch (Op) {
           default:
            throw new llvm_unreachable("Invalid opcode for compound assignment.");
           case BO_MulAssign:
            Op = BinaryOperatorKind.BO_Mul;
            break;
           case BO_DivAssign:
            Op = BinaryOperatorKind.BO_Div;
            break;
           case BO_RemAssign:
            Op = BinaryOperatorKind.BO_Rem;
            break;
           case BO_AddAssign:
            Op = BinaryOperatorKind.BO_Add;
            break;
           case BO_SubAssign:
            Op = BinaryOperatorKind.BO_Sub;
            break;
           case BO_ShlAssign:
            Op = BinaryOperatorKind.BO_Shl;
            break;
           case BO_ShrAssign:
            Op = BinaryOperatorKind.BO_Shr;
            break;
           case BO_AndAssign:
            Op = BinaryOperatorKind.BO_And;
            break;
           case BO_XorAssign:
            Op = BinaryOperatorKind.BO_Xor;
            break;
           case BO_OrAssign:
            Op = BinaryOperatorKind.BO_Or;
            break;
          }
          
          // Perform a load (the LHS).  This performs the checks for
          // null dereferences, and so on.
          Tmp/*J*/= new ExplodedNodeSet();
          SVal location = new SVal(LeftV);
          evalLoad(Tmp, B, LHS, it.$star(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(location)); $c$.clean();
          
          for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = Tmp.begin(), E = Tmp.end(); I.$noteq(E);
               I.$preInc()) {
            
            $c$.clean(state.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>((I.$star()).getState()))));
            /*const*/ LocationContext /*P*/ LCtx$1 = (I.$star()).getLocationContext();
            SVal V = state.$arrow().getSVal(LHS, LCtx$1);
            
            // Get the computation type.
            QualType CTy = cast_CompoundAssignOperator(B).getComputationResultType();
            CTy.$assignMove(getContext().getCanonicalType(/*NO_COPY*/CTy).$QualType());
            
            QualType CLHSTy = cast_CompoundAssignOperator(B).getComputationLHSType();
            CLHSTy.$assignMove(getContext().getCanonicalType(/*NO_COPY*/CLHSTy).$QualType());
            
            QualType LTy = getContext().getCanonicalType(LHS.getType()).$QualType();
            
            // Promote LHS.
            V.$assignMove(svalBuilder.evalCast(new SVal(V), new QualType(CLHSTy), new QualType(LTy)));
            
            // Compute the result of the operation.
            SVal Result = $c$.clean(svalBuilder.evalCast(evalBinOp($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Op, new SVal(V), new SVal(RightV), new QualType(CTy)), 
                B.getType(), new QualType(CTy)));
            
            // EXPERIMENTAL: "Conjured" symbols.
            // FIXME: Handle structs.
            SVal LHSVal/*J*/= new SVal();
            if (Result.isUnknown$SVal()) {
              // The symbolic value is actually for the type of the left-hand side
              // expression, not the computation type, as this is the value the
              // LValue on the LHS will bind to.
              LHSVal.$assignMove(svalBuilder.conjureSymbolVal((/*const*/Object/*void P*/ )null, B.getRHS(), LCtx$1, new QualType(LTy), 
                      currBldrCtx.blockCount()));
              // However, we need to convert the symbol to the computation type.
              Result.$assignMove(svalBuilder.evalCast(new SVal(LHSVal), new QualType(CTy), new QualType(LTy)));
            } else {
              // The left-hand side may bind to a different value then the
              // computation type.
              LHSVal.$assignMove(svalBuilder.evalCast(new SVal(Result), new QualType(LTy), new QualType(CTy)));
            }
            
            // In C++, assignment and compound assignment operators return an
            // lvalue.
            if (B.isGLValue()) {
              $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(B, LCtx$1, new SVal(location)))));
            } else {
              $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(B, LCtx$1, new SVal(Result)))));
            }
            
            evalStore(Tmp2, B, LHS, I.$star(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(location), new SVal(LHSVal)); $c$.clean();
          }
        } finally {
          if (Tmp != null) { Tmp.$destroy(); }
          if (state != null) { state.$destroy(); }
        }
      }
      
      // FIXME: postvisits eventually go in ::Visit()
      getCheckerManager().runCheckersForPostStmt(Dst, Tmp2, B, /*Deref*/this);
    } finally {
      if (Tmp2 != null) { Tmp2.$destroy(); }
      if (CheckedSet != null) { CheckedSet.$destroy(); }
      $c$.$destroy();
    }
  }


  
  /// VisitCall - Transfer function for function calls.
  
  /// VisitCall - Transfer function for function calls.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 470,
   FQN="clang::ento::ExprEngine::VisitCallExpr", NM="_ZN5clang4ento10ExprEngine13VisitCallExprEPKNS_8CallExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang4ento10ExprEngine13VisitCallExprEPKNS_8CallExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitCallExpr(/*const*/ CallExpr /*P*/ CE, ExplodedNode /*P*/ Pred, 
               final ExplodedNodeSet /*&*/ dst) {
    ExplodedNodeSet dstPreVisit = null;
    CallEventRef<CallEvent> CallTemplate = null;
    ExplodedNodeSet dstCallEvaluated = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Perform the previsit of the CallExpr.
      dstPreVisit/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForPreStmt(dstPreVisit, $c$.track(new ExplodedNodeSet(Pred)), CE, /*Deref*/this); $c$.clean();
      
      // Get the call in its initial state. We use this as a template to perform
      // all the checks.
      final CallEventManager /*&*/ CEMgr = getStateManager().getCallEventManager();
      CallTemplate = $c$.clean(CEMgr.getSimpleCall(CE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState())), Pred.getLocationContext()));
      
      // Evaluate the function call.  We try each of the checkers
      // to see if the can evaluate the function call.
      dstCallEvaluated/*J*/= new ExplodedNodeSet();
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = dstPreVisit.begin(), E = dstPreVisit.end();
           I.$noteq(E); I.$preInc()) {
        evalCall(dstCallEvaluated, I.$star(), CallTemplate.$star());
      }
      
      // Finally, perform the post-condition check of the CallExpr and store
      // the created nodes in 'Dst'.
      // Note that if the call was inlined, dstCallEvaluated will be empty.
      // The post-CallExpr check will occur in processCallExit.
      getCheckerManager().runCheckersForPostStmt(dst, dstCallEvaluated, CE, 
          /*Deref*/this);
    } finally {
      if (dstCallEvaluated != null) { dstCallEvaluated.$destroy(); }
      if (CallTemplate != null) { CallTemplate.$destroy(); }
      if (dstPreVisit != null) { dstPreVisit.$destroy(); }
      $c$.$destroy();
    }
  }


  
  /// VisitCast - Transfer function logic for all casts (implicit and explicit).
  
  /// VisitCast - Transfer function logic for all casts (implicit and explicit).
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp", line = 249,
   FQN="clang::ento::ExprEngine::VisitCast", NM="_ZN5clang4ento10ExprEngine9VisitCastEPKNS_8CastExprEPKNS_4ExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp -nm=_ZN5clang4ento10ExprEngine9VisitCastEPKNS_8CastExprEPKNS_4ExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitCast(/*const*/ CastExpr /*P*/ CastE, /*const*/ Expr /*P*/ Ex, 
           ExplodedNode /*P*/ Pred, final ExplodedNodeSet /*&*/ Dst) {
    ExplodedNodeSet dstPreStmt = null;
    StmtNodeBuilder Bldr = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      dstPreStmt/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForPreStmt(dstPreStmt, $c$.track(new ExplodedNodeSet(Pred)), CastE, /*Deref*/this); $c$.clean();
      if (CastE.getCastKind() == CastKind.CK_LValueToRValue) {
        for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = dstPreStmt.begin(), E = dstPreStmt.end();
             I.$noteq(E); I.$preInc()) {
          IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
         try {
          ExplodedNode /*P*/ subExprNode = I.$star();
          state = new IntrusiveRefCntPtr</*const*/ ProgramState>(subExprNode.getState());
          /*const*/ LocationContext /*P*/ LCtx = subExprNode.getLocationContext();
          evalLoad(Dst, CastE, CastE, subExprNode, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), state.$arrow().getSVal(Ex, LCtx)); $c$.clean();
         } finally {
          if (state != null) { state.$destroy(); }
         }        
        }
        return;
      }
      
      // All other casts.
      QualType T = CastE.getType();
      QualType ExTy = Ex.getType();
      {
        
        /*const*/ ExplicitCastExpr /*P*/ ExCast = dyn_cast_or_null_ExplicitCastExpr(CastE);
        if ((ExCast != null)) {
          T.$assignMove(ExCast.getTypeAsWritten());
        }
      }
      
      Bldr/*J*/= new StmtNodeBuilder(dstPreStmt, Dst, $Deref(currBldrCtx));
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = dstPreStmt.begin(), E = dstPreStmt.end();
           I.$noteq(E); I.$preInc()) {
        IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
        try {
          
          Pred = I.$star();
          state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
          /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
          switch (CastE.getCastKind()) {
           case CK_LValueToRValue:
            throw new llvm_unreachable("LValueToRValue casts handled earlier.");
           case CK_ToVoid:
            continue;
           case CK_ARCProduceObject:
           case CK_ARCConsumeObject:
           case CK_ARCReclaimReturnedObject:
           case CK_ARCExtendBlockObject: // Fall-through.
           case CK_CopyAndAutoreleaseBlockObject:
           case CK_AtomicToNonAtomic:
           case CK_NonAtomicToAtomic:
           case CK_NoOp:
           case CK_ConstructorConversion:
           case CK_UserDefinedConversion:
           case CK_FunctionToPointerDecay:
           case CK_BuiltinFnToFnPtr:
            {
              IntrusiveRefCntPtr</*const*/ ProgramState> state$1 = null;
              try { 
                // Copy the SVal of Ex to CastE.
                state$1 = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
                /*const*/ LocationContext /*P*/ LCtx$1 = Pred.getLocationContext();
                SVal V = state$1.$arrow().getSVal(Ex, LCtx$1);
                $c$.clean(state$1.$assign($c$.track(state$1.$arrow().BindExpr(CastE, LCtx$1, new SVal(V)))));
                $c$.clean(Bldr.generateNode(CastE, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state$1))));
                continue;
              } finally {
               if (state$1 != null) { state$1.$destroy(); }
              } 
            }
           case CK_MemberPointerToBoolean:
           case CK_Dependent:
           case CK_ArrayToPointerDecay:
           case CK_BitCast:
           case CK_AddressSpaceConversion:
           case CK_BooleanToSignedIntegral:
           case CK_NullToPointer:
           case CK_IntegralToPointer:
           case CK_PointerToIntegral:
           case CK_PointerToBoolean:
           case CK_IntegralToBoolean:
           case CK_IntegralToFloating:
           case CK_FloatingToIntegral:
           case CK_FloatingToBoolean:
           case CK_FloatingCast:
           case CK_FloatingRealToComplex:
           case CK_FloatingComplexToReal:
           case CK_FloatingComplexToBoolean:
           case CK_FloatingComplexCast:
           case CK_FloatingComplexToIntegralComplex:
           case CK_IntegralRealToComplex:
           case CK_IntegralComplexToReal:
           case CK_IntegralComplexToBoolean:
           case CK_IntegralComplexCast:
           case CK_IntegralComplexToFloatingComplex:
           case CK_CPointerToObjCPointerCast:
           case CK_BlockPointerToObjCPointerCast:
           case CK_AnyPointerToBlockPointerCast:
           case CK_ObjCObjectLValueCast:
           case CK_ZeroToOCLEvent:
           case CK_LValueBitCast:
            {
              // Delegate to SValBuilder to process.
              SVal V = state.$arrow().getSVal(Ex, LCtx);
              V.$assignMove(svalBuilder.evalCast(new SVal(V), new QualType(T), new QualType(ExTy)));
              // Negate the result if we're treating the boolean as a signed i1
              if (CastE.getCastKind() == CastKind.CK_BooleanToSignedIntegral) {
                V.$assignMove(evalMinus(new SVal(V)));
              }
              $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(CastE, LCtx, new SVal(V)))));
              $c$.clean(Bldr.generateNode(CastE, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
              continue;
            }
           case CK_IntegralCast:
            {
              // Delegate to SValBuilder to process.
              SVal V = state.$arrow().getSVal(Ex, LCtx);
              $c$.clean(V.$assignMove(svalBuilder.evalIntegralCast($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(V), new QualType(T), new QualType(ExTy))));
              $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(CastE, LCtx, new SVal(V)))));
              $c$.clean(Bldr.generateNode(CastE, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
              continue;
            }
           case CK_DerivedToBase:
           case CK_UncheckedDerivedToBase:
            {
              // For DerivedToBase cast, delegate to the store manager.
              SVal val = state.$arrow().getSVal(Ex, LCtx);
              val.$assignMove(getStoreManager().evalDerivedToBase(new SVal(val), CastE));
              $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(CastE, LCtx, new SVal(val)))));
              $c$.clean(Bldr.generateNode(CastE, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
              continue;
            }
           case CK_Dynamic:
            {
              SVal val = state.$arrow().getSVal(Ex, LCtx);

              // Compute the type of the result.
              QualType resultType = CastE.getType();
              if (CastE.isGLValue()) {
                resultType.$assignMove(getContext().getPointerType(/*NO_COPY*/resultType));
              }

              bool$ref Failed = create_bool$ref(false);

              // Check if the value being cast evaluates to 0.
              if (val.isZeroConstant()) {
                Failed.$set(true);
              } else {
                // Else, evaluate the cast.
                val.$assignMove(getStoreManager().evalDynamicCast(new SVal(val), new QualType(T), Failed));
              }
              if (Failed.$deref()) {
                if (T.$arrow().isReferenceType()) {
                  // A bad_cast exception is thrown if input value is a reference.
                  // Currently, we model this, by generating a sink.
                  $c$.clean(Bldr.generateSink(CastE, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
                  continue;
                } else {
                  // If the cast fails on a pointer, bind to 0.
                  $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(CastE, LCtx, new SVal(JD$Move.INSTANCE, svalBuilder.makeNull())))));
                }
              } else {
                // If we don't know if the cast succeeded, conjure a new symbol.
                if (val.isUnknown$SVal()) {
                  DefinedOrUnknownSVal NewSym = svalBuilder.conjureSymbolVal((/*const*/Object/*void P*/ )null, CastE, LCtx, new QualType(resultType), 
                      currBldrCtx.blockCount());
                  $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(CastE, LCtx, new SVal(NewSym)))));
                } else {
                  // Else, bind to the derived region value.
                  $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(CastE, LCtx, new SVal(val)))));
                }
              }
              $c$.clean(Bldr.generateNode(CastE, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
              continue;
            }
           case CK_NullToMemberPointer:
            {
              // FIXME: For now, member pointers are represented by void *.
              SVal V = new SVal(JD$Move.INSTANCE, svalBuilder.makeNull());
              $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(CastE, LCtx, new SVal(V)))));
              $c$.clean(Bldr.generateNode(CastE, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
              continue;
            }
           case CK_ToUnion:
           case CK_BaseToDerived:
           case CK_BaseToDerivedMemberPointer:
           case CK_DerivedToBaseMemberPointer:
           case CK_ReinterpretMemberPointer:
           case CK_VectorSplat:
            {
              // Recover some path-sensitivty by conjuring a new value.
              QualType resultType = CastE.getType();
              if (CastE.isGLValue()) {
                resultType.$assignMove(getContext().getPointerType(/*NO_COPY*/resultType));
              }
              SVal result = new SVal(JD$Move.INSTANCE, svalBuilder.conjureSymbolVal((/*const*/Object/*void P*/ )null, CastE, LCtx, 
                      new QualType(resultType), 
                      currBldrCtx.blockCount()));
              $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(CastE, LCtx, new SVal(result)))));
              $c$.clean(Bldr.generateNode(CastE, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
              continue;
            }
          }
        } finally {
         if (state != null) { state.$destroy(); }
        } 
      }
    } finally {
      if (Bldr != null) { Bldr.$destroy(); }
      if (dstPreStmt != null) { dstPreStmt.$destroy(); }
      $c$.$destroy();
    }
  }


  
  /// VisitCompoundLiteralExpr - Transfer function logic for compound literals.
  
  /// VisitCompoundLiteralExpr - Transfer function logic for compound literals.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitCompoundLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp", line = 443,
   FQN="clang::ento::ExprEngine::VisitCompoundLiteralExpr", NM="_ZN5clang4ento10ExprEngine24VisitCompoundLiteralExprEPKNS_19CompoundLiteralExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp -nm=_ZN5clang4ento10ExprEngine24VisitCompoundLiteralExprEPKNS_19CompoundLiteralExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitCompoundLiteralExpr(/*const*/ CompoundLiteralExpr /*P*/ CL, 
                          ExplodedNode /*P*/ Pred, 
                          final ExplodedNodeSet /*&*/ Dst) {
    StmtNodeBuilder B = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      B/*J*/= new StmtNodeBuilder(Pred, Dst, $Deref(currBldrCtx));
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
      
      /*const*/ Expr /*P*/ Init = CL.getInitializer$Const();
      SVal V = State.$arrow().getSVal(CL.getInitializer$Const(), LCtx);
      if (isa_CXXConstructExpr(Init)) {
        // No work needed. Just pass the value up to this expression.
      } else {
        assert (isa_InitListExpr(Init));
        Loc CLLoc = State.$arrow().getLValue(CL, LCtx);
        $c$.clean(State.$assign($c$.track(State.$arrow().bindLoc(new Loc(CLLoc), new SVal(V)))));
        
        // Compound literal expressions are a GNU extension in C++.
        // Unlike in C, where CLs are lvalues, in C++ CLs are prvalues,
        // and like temporary objects created by the functional notation T()
        // CLs are destroyed at the end of the containing full-expression.
        // HOWEVER, an rvalue of array type is not something the analyzer can
        // reason about, since we expect all regions to be wrapped in Locs.
        // So we treat array CLs as lvalues as well, knowing that they will decay
        // to pointers as soon as they are used.
        if (CL.isGLValue() || CL.getType().$arrow().isArrayType()) {
          V.$assign(CLLoc);
        }
      }
      
      $c$.clean(B.generateNode(CL, Pred, $c$.track(State.$arrow().BindExpr(CL, LCtx, new SVal(V)))));
    } finally {
      if (State != null) { State.$destroy(); }
      if (B != null) { B.$destroy(); }
      $c$.$destroy();
    }
  }


  
  /// Transfer function logic for DeclRefExprs and BlockDeclRefExprs.
  
  //===----------------------------------------------------------------------===//
  // Transfer functions: Loads and stores.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitCommonDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 1885,
   FQN="clang::ento::ExprEngine::VisitCommonDeclRefExpr", NM="_ZN5clang4ento10ExprEngine22VisitCommonDeclRefExprEPKNS_4ExprEPKNS_9NamedDeclEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine22VisitCommonDeclRefExprEPKNS_4ExprEPKNS_9NamedDeclEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitCommonDeclRefExpr(/*const*/ Expr /*P*/ Ex, /*const*/ NamedDecl /*P*/ D, 
                        ExplodedNode /*P*/ Pred, 
                        final ExplodedNodeSet /*&*/ Dst) {
    StmtNodeBuilder Bldr = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    try {
      Bldr/*J*/= new StmtNodeBuilder(Pred, Dst, $Deref(currBldrCtx));
      
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
      {
        
        /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
        if ((VD != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // C permits "extern void v", and if you cast the address to a valid type,
            // you can even do things with it. We simply pretend
            assert (Ex.isGLValue() || VD.getType().$arrow().isVoidType());
            /*const*/ LocationContext /*P*/ LocCtxt = Pred.getLocationContext();
            /*const*/ Decl /*P*/ D$1 = LocCtxt.getDecl();
            /*const*/ CXXMethodDecl /*P*/ MD = (D$1 != null) ? dyn_cast_CXXMethodDecl(D$1) : null;
            /*const*/ DeclRefExpr /*P*/ DeclRefEx = dyn_cast_DeclRefExpr(Ex);
            SVal V/*J*/= new SVal();
            boolean IsReference;
            if (AMgr.options.shouldInlineLambdas() && (DeclRefEx != null)
               && DeclRefEx.refersToEnclosingVariableOrCapture() && (MD != null)
               && MD.getParent$Const().isLambda()) {
              // Lookup the field of the lambda.
              /*const*/ CXXRecordDecl /*P*/ CXXRec = MD.getParent$Const();
              DenseMap</*const*/ VarDecl /*P*/ , FieldDecl /*P*/ > LambdaCaptureFields/*J*/= new DenseMap</*const*/ VarDecl /*P*/ , FieldDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (FieldDecl /*P*/ )null);
              type$ref<FieldDecl /*P*/ > LambdaThisCaptureField = create_type$ref();
              CXXRec.getCaptureFields(LambdaCaptureFields, LambdaThisCaptureField);
              /*const*/ FieldDecl /*P*/ FD = LambdaCaptureFields.$at_T1$C$R(VD);
              if (!(FD != null)) {
                // When a constant is captured, sometimes no corresponding field is
                // created in the lambda object.
                assert (VD.getType().isConstQualified());
                V.$assignMove(state.$arrow().getLValue(VD, LocCtxt));
                IsReference = false;
              } else {
                Loc CXXThis = new Loc(JD$Move.INSTANCE, svalBuilder.getCXXThis(MD, LocCtxt.getCurrentStackFrame()));
                SVal CXXThisVal = state.$arrow().getSVal(new Loc(CXXThis));
                V.$assignMove(state.$arrow().getLValue(FD, new SVal(CXXThisVal)));
                IsReference = FD.getType().$arrow().isReferenceType();
              }
            } else {
              V.$assignMove(state.$arrow().getLValue(VD, LocCtxt));
              IsReference = VD.getType().$arrow().isReferenceType();
            }
            
            // For references, the 'lvalue' is the pointer address stored in the
            // reference region.
            if (IsReference) {
              {
                /*const*/ MemRegion /*P*/ R = V.getAsRegion();
                if ((R != null)) {
                  V.$assignMove(state.$arrow().getSVal(R));
                } else {
                  V.$assignMove(new UnknownVal());
                }
              }
            }
            
            $c$.clean(Bldr.generateNode(Ex, Pred, $c$.track(state.$arrow().BindExpr(Ex, LCtx, new SVal(V))), (/*const*/ ProgramPointTag /*P*/ )null, 
                ProgramPoint.Kind.PostLValueKind));
            return;
          } finally {
            $c$.$destroy();
          }
        }
      }
      {
        /*const*/ EnumConstantDecl /*P*/ ED = dyn_cast_EnumConstantDecl(D);
        if ((ED != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            assert (!Ex.isGLValue());
            SVal V = new SVal(JD$Move.INSTANCE, svalBuilder.makeIntVal(ED.getInitVal()));
            $c$.clean(Bldr.generateNode(Ex, Pred, $c$.track(state.$arrow().BindExpr(Ex, LCtx, new SVal(V)))));
            return;
          } finally {
            $c$.$destroy();
          }
        }
      }
      {
        /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
        if ((FD != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            SVal V = new SVal(JD$Move.INSTANCE, svalBuilder.getFunctionPointer(FD));
            $c$.clean(Bldr.generateNode(Ex, Pred, $c$.track(state.$arrow().BindExpr(Ex, LCtx, new SVal(V))), (/*const*/ ProgramPointTag /*P*/ )null, 
                ProgramPoint.Kind.PostLValueKind));
            return;
          } finally {
            $c$.$destroy();
          }
        }
      }
      if (isa_FieldDecl(D)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // FIXME: Compute lvalue of field pointers-to-member.
          // Right now we just use a non-null void pointer, so that it gives proper
          // results in boolean contexts.
          SVal V = new SVal(JD$Move.INSTANCE, svalBuilder.conjureSymbolVal(Ex, LCtx, getContext().VoidPtrTy.$QualType(), 
                  currBldrCtx.blockCount()));
          $c$.clean(state.$assign($c$.track(state.$arrow().assume(V.castAs(DefinedOrUnknownSVal.class), true))));
          $c$.clean(Bldr.generateNode(Ex, Pred, $c$.track(state.$arrow().BindExpr(Ex, LCtx, new SVal(V))), (/*const*/ ProgramPointTag /*P*/ )null, 
              ProgramPoint.Kind.PostLValueKind));
          return;
        } finally {
          $c$.$destroy();
        }
      }
      throw new llvm_unreachable("Support for this Decl not implemented.");
    } finally {
      if (state != null) { state.$destroy(); }
      if (Bldr != null) { Bldr.$destroy(); }
    }
  }

  
  /// VisitDeclStmt - Transfer function logic for DeclStmts.
  
  /// VisitDeclStmt - Transfer function logic for DeclStmts.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp", line = 476,
   FQN="clang::ento::ExprEngine::VisitDeclStmt", NM="_ZN5clang4ento10ExprEngine13VisitDeclStmtEPKNS_8DeclStmtEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp -nm=_ZN5clang4ento10ExprEngine13VisitDeclStmtEPKNS_8DeclStmtEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitDeclStmt(/*const*/ DeclStmt /*P*/ DS, ExplodedNode /*P*/ Pred, 
               final ExplodedNodeSet /*&*/ Dst) {
    ExplodedNodeSet dstPreVisit = null;
    ExplodedNodeSet dstEvaluated = null;
    StmtNodeBuilder B = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Assumption: The CFG has one DeclStmt per Decl.
      /*const*/ VarDecl /*P*/ VD = dyn_cast_or_null_VarDecl(DS.decl_begin$Const().$star());
      if (!(VD != null)) {
        //TODO:AZ: remove explicit insertion after refactoring is done.
        Dst.insert($c$.track(new ExplodedNodeSet(Pred))); $c$.clean();
        return;
      }
      
      // FIXME: all pre/post visits should eventually be handled by ::Visit().
      dstPreVisit/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForPreStmt(dstPreVisit, $c$.track(new ExplodedNodeSet(Pred)), DS, /*Deref*/this); $c$.clean();
      
      dstEvaluated/*J*/= new ExplodedNodeSet();
      B/*J*/= new StmtNodeBuilder(dstPreVisit, dstEvaluated, $Deref(currBldrCtx));
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = dstPreVisit.begin(), E = dstPreVisit.end();
           I.$noteq(E); I.$preInc()) {
        IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
        try {
          ExplodedNode /*P*/ N = I.$star();
          state = new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState());
          /*const*/ LocationContext /*P*/ LC = N.getLocationContext();
          {

            // Decls without InitExpr are not initialized explicitly.
            /*const*/ Expr /*P*/ InitEx = VD.getInit$Const();
            if ((InitEx != null)) {

              // Note in the state that the initialization has occurred.
              ExplodedNode /*P*/ UpdatedN = N;
              SVal InitVal = state.$arrow().getSVal(InitEx, LC);
              assert (DS.isSingleDecl());
              {
                /*const*/ CXXConstructExpr /*P*/ CtorExpr = findDirectConstructorForCurrentCFGElement();
                if ((CtorExpr != null)) {
                  assert (InitEx.IgnoreImplicit$Const() == CtorExpr);
                  ///*J:(void)*/CtorExpr;
                  // We constructed the object directly in the variable.
                  // No need to bind anything.
                  $c$.clean(B.generateNode(DS, UpdatedN, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
                } else {
                  ExplodedNodeSet Dst2 = null;
                  try {
                    // We bound the temp obj region to the CXXConstructExpr. Now recover
                    // the lazy compound value when the variable is not a reference.
                    if (AMgr.getLangOpts().CPlusPlus && VD.getType().$arrow().isRecordType()
                       && !VD.getType().$arrow().isReferenceType()) {
                      {
                        Optional<NsLoc.MemRegionVal> M = InitVal.getAs(NsLoc.MemRegionVal.class);
                        if (M.$bool()) {
                          InitVal.$assignMove(state.$arrow().getSVal(M.$arrow().getRegion()));
                          assert ((InitVal.getAs(NsNonloc.LazyCompoundVal.class)).$bool());
                        }
                      }
                    }

                    // Recover some path-sensitivity if a scalar value evaluated to
                    // UnknownVal.
                    if (InitVal.isUnknown$SVal()) {
                      QualType Ty = InitEx.getType();
                      if (InitEx.isGLValue()) {
                        Ty.$assignMove(getContext().getPointerType(/*NO_COPY*/Ty));
                      }

                      InitVal.$assignMove(svalBuilder.conjureSymbolVal((/*const*/Object/*void P*/ )null, InitEx, LC, new QualType(Ty), 
                              currBldrCtx.blockCount()));
                    }

                    B.takeNodes(UpdatedN);
                    Dst2/*J*/= new ExplodedNodeSet();
                    evalBind(Dst2, DS, UpdatedN, new SVal(JD$Move.INSTANCE, state.$arrow().getLValue(VD, LC)), new SVal(InitVal), true);
                    B.addNodes(Dst2);
                  } finally {
                    if (Dst2 != null) { Dst2.$destroy(); }
                  }
                }
              }
            } else {
              $c$.clean(B.generateNode(DS, N, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
            }
          }
        } finally {
         if (state != null) { state.$destroy(); }
        } 
      }
      
      getCheckerManager().runCheckersForPostStmt(Dst, B.getResults(), DS, /*Deref*/this);
    } finally {
      if (B != null) { B.$destroy(); }
      if (dstEvaluated != null) { dstEvaluated.$destroy(); }
      if (dstPreVisit != null) { dstPreVisit.$destroy(); }
      $c$.$destroy();
    }
  }


  
  /// VisitGuardedExpr - Transfer function logic for ?, __builtin_choose
  
  /// VisitGuardedExpr - Transfer function logic for ?, __builtin_choose
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitGuardedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp", line = 670,
   FQN="clang::ento::ExprEngine::VisitGuardedExpr", NM="_ZN5clang4ento10ExprEngine16VisitGuardedExprEPKNS_4ExprES4_S4_PNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp -nm=_ZN5clang4ento10ExprEngine16VisitGuardedExprEPKNS_4ExprES4_S4_PNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitGuardedExpr(/*const*/ Expr /*P*/ Ex, 
                  /*const*/ Expr /*P*/ L, 
                  /*const*/ Expr /*P*/ R, 
                  ExplodedNode /*P*/ Pred, 
                  final ExplodedNodeSet /*&*/ Dst) {
    StmtNodeBuilder B = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> SrcState = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert ((L != null) && (R != null));
      
      B/*J*/= new StmtNodeBuilder(Pred, Dst, $Deref(currBldrCtx));
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
      /*const*/ CFGBlock /*P*/ SrcBlock = null;
      
      // Find the predecessor block.
      SrcState = new IntrusiveRefCntPtr</*const*/ ProgramState>(state);
      for (/*const*/ ExplodedNode /*P*/ N = Pred; (N != null); N = N.pred_begin$Const().$star()) {
        ProgramPoint PP = N.getLocation();
        if (PP.getAs(PreStmtPurgeDeadSymbols.class).$bool() || PP.getAs(BlockEntrance.class).$bool()) {
          assert (N.pred_size() == 1);
          continue;
        }
        SrcBlock = PP.castAs(BlockEdge.class).getSrc();
        $c$.clean(SrcState.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState()))));
        break;
      }
      assert ((SrcBlock != null)) : "missing function entry";
      
      // Find the last expression in the predecessor block.  That is the
      // expression that is used for the value of the ternary expression.
      boolean hasValue = false;
      SVal V/*J*/= new SVal();
      
      for (CFGElement CE : llvm.reverse$NotHasRBegin($Deref(SrcBlock))) {
        {
          Optional<CFGStmt> CS = CE.getAs(CFGStmt.class);
          if (CS.$bool()) {
            /*const*/ Expr /*P*/ ValEx = cast_Expr(CS.$arrow().getStmt());
            ValEx = ValEx.IgnoreParens$Const();
            {
              
              // For GNU extension '?:' operator, the left hand side will be an
              // OpaqueValueExpr, so get the underlying expression.
              /*const*/ OpaqueValueExpr /*P*/ OpaqueEx = dyn_cast_OpaqueValueExpr(L);
              if ((OpaqueEx != null)) {
                L = OpaqueEx.getSourceExpr();
              }
            }
            
            // If the last expression in the predecessor block matches true or false
            // subexpression, get its the value.
            if (ValEx == L.IgnoreParens$Const() || ValEx == R.IgnoreParens$Const()) {
              hasValue = true;
              V.$assignMove(SrcState.$arrow().getSVal(ValEx, LCtx));
            }
            break;
          }
        }
      }
      if (!hasValue) {
        V.$assignMove(svalBuilder.conjureSymbolVal((/*const*/Object/*void P*/ )null, Ex, LCtx, 
                currBldrCtx.blockCount()));
      }
      
      // Generate a new node with the binding from the appropriate path.
      $c$.clean(B.generateNode(Ex, Pred, $c$.track(state.$arrow().BindExpr(Ex, LCtx, new SVal(V), true))));
    } finally {
      if (SrcState != null) { SrcState.$destroy(); }
      if (state != null) { state.$destroy(); }
      if (B != null) { B.$destroy(); }
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitInitListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp", line = 621,
   FQN="clang::ento::ExprEngine::VisitInitListExpr", NM="_ZN5clang4ento10ExprEngine17VisitInitListExprEPKNS_12InitListExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp -nm=_ZN5clang4ento10ExprEngine17VisitInitListExprEPKNS_12InitListExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitInitListExpr(/*const*/ InitListExpr /*P*/ IE, 
                   ExplodedNode /*P*/ Pred, 
                   final ExplodedNodeSet /*&*/ Dst) {
    StmtNodeBuilder B = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      B/*J*/= new StmtNodeBuilder(Pred, Dst, $Deref(currBldrCtx));
      
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
      QualType T = getContext().getCanonicalType(IE.getType()).$QualType();
      /*uint*/int NumInitElements = IE.getNumInits();
      if (!IE.isGLValue()
         && (T.$arrow().isArrayType() || T.$arrow().isRecordType() || T.$arrow().isVectorType()
         || T.$arrow().isAnyComplexType())) {
        ImmutableList<SVal> vals = getBasicVals().getEmptySValList();
        
        // Handle base case where the initializer has no elements.
        // e.g: static int* myArray[] = {};
        if (NumInitElements == 0) {
          SVal V = new SVal(JD$Move.INSTANCE, svalBuilder.makeCompoundVal(new QualType(T), new ImmutableList<SVal>(vals)));
          $c$.clean(B.generateNode(IE, Pred, $c$.track(state.$arrow().BindExpr(IE, LCtx, new SVal(V)))));
          return;
        }
        
        for (std.reverse_iterator<Stmt /*P*/ /*const*/> it = IE.rbegin$Const(), 
            ei = IE.rend$Const(); $noteq_reverse_iterator$C(it, ei); it.$preInc()) {
          SVal V = state.$arrow().getSVal(cast_Expr(it.$star()), LCtx);
          vals.$assignMove(getBasicVals().consVals(new SVal(V), new ImmutableList<SVal>(vals)));
        }
        
        $c$.clean(B.generateNode(IE, Pred, 
            $c$.track(state.$arrow().BindExpr(IE, LCtx, 
                new SVal(JD$Move.INSTANCE, svalBuilder.makeCompoundVal(new QualType(T), new ImmutableList<SVal>(vals)))))));
        return;
      }
      
      // Handle scalars: int{5} and int{} and GLvalues.
      // Note, if the InitListExpr is a GLvalue, it means that there is an address
      // representing it, so it must have a single init element.
      assert ($lesseq_uint(NumInitElements, 1));
      
      SVal V/*J*/= new SVal();
      if (NumInitElements == 0) {
        V.$assignMove(getSValBuilder().makeZeroVal(new QualType(T)));
      } else {
        V.$assignMove(state.$arrow().getSVal(IE.getInit$Const(0), LCtx));
      }
      
      $c$.clean(B.generateNode(IE, Pred, $c$.track(state.$arrow().BindExpr(IE, LCtx, new SVal(V)))));
    } finally {
      if (state != null) { state.$destroy(); }
      if (B != null) { B.$destroy(); }
      $c$.$destroy();
    }
  }


  
  /// VisitLogicalExpr - Transfer function logic for '&&', '||'
  
  /// VisitLogicalExpr - Transfer function logic for '&&', '||'
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitLogicalExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp", line = 552,
   FQN="clang::ento::ExprEngine::VisitLogicalExpr", NM="_ZN5clang4ento10ExprEngine16VisitLogicalExprEPKNS_14BinaryOperatorEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp -nm=_ZN5clang4ento10ExprEngine16VisitLogicalExprEPKNS_14BinaryOperatorEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitLogicalExpr(/*const*/ BinaryOperator /*P*/ B, ExplodedNode /*P*/ Pred, 
                  final ExplodedNodeSet /*&*/ Dst) {
    StmtNodeBuilder Bldr = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (B.getOpcode() == BinaryOperatorKind.BO_LAnd || B.getOpcode() == BinaryOperatorKind.BO_LOr);
      
      Bldr/*J*/= new StmtNodeBuilder(Pred, Dst, $Deref(currBldrCtx));
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      
      ExplodedNode /*P*/ N = Pred;
      while (!N.getLocation().getAs(BlockEntrance.class).$bool()) {
        ProgramPoint P = N.getLocation();
        assert (P.getAs(org.clang.analysis.PreStmt.class).$bool() || P.getAs(PreStmtPurgeDeadSymbols.class).$bool());
        ///*J:(void)*/P;
        assert (N.pred_size() == 1);
        N = N.pred_begin().$star();
      }
      assert (N.pred_size() == 1);
      N = N.pred_begin().$star();
      BlockEdge BE = N.getLocation().castAs(BlockEdge.class);
      SVal X/*J*/= new SVal();
      
      // Determine the value of the expression by introspecting how we
      // got this location in the CFG.  This requires looking at the previous
      // block we were in and what kind of control-flow transfer was involved.
      /*const*/ CFGBlock /*P*/ SrcBlock = BE.getSrc();
      // The only terminator (if there is one) that makes sense is a logical op.
      CFGTerminator T = SrcBlock.getTerminator$Const();
      {
        /*const*/ BinaryOperator /*P*/ Term = cast_or_null_BinaryOperator(T.getStmt());
        if ((Term != null)) {
          ///*J:(void)*/Term;
          assert (Term.isLogicalOp());
          assert (SrcBlock.succ_size() == 2);
          // Did we take the true or false branch?
          /*uint*/int constant = (SrcBlock.succ_begin$Const().$star().$CFGBlock$P() == BE.getDst()) ? 1 : 0;
          X.$assignMove(svalBuilder.makeIntVal($uint2ulong(constant), B.getType()));
        } else {
          // If there is no terminator, by construction the last statement
          // in SrcBlock is the value of the enclosing expression.
          // However, we still need to constrain that value to be 0 or 1.
          assert (!SrcBlock.empty());
          CFGStmt Elem = SrcBlock.rbegin$Const().$star().castAs(CFGStmt.class);
          /*const*/ Expr /*P*/ RHS = cast_Expr(Elem.getStmt());
          SVal RHSVal = N.getState().$arrow().getSVal(RHS, Pred.getLocationContext());
          if (RHSVal.isUndef$SVal()) {
            X.$assign(RHSVal);
          } else {
            IntrusiveRefCntPtr</*const*/ ProgramState> StTrue = null;
            IntrusiveRefCntPtr</*const*/ ProgramState> StFalse = null;
            try {
              DefinedOrUnknownSVal DefinedRHS = RHSVal.castAs(DefinedOrUnknownSVal.class);
              StTrue/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
              StFalse/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//              $c$.clean(std.tie(StTrue, StFalse).$assign($c$.track(N.getState().$arrow().assume(new DefinedOrUnknownSVal(DefinedRHS)))));
              // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
              std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
                      $c$.track(N.getState().$arrow().assume(new DefinedOrUnknownSVal(DefinedRHS)));
              StTrue.$assign($assume.first);
              StFalse.$assign($assume.second);
              assert !$assume.first.$bool();
              assert !$assume.second.$bool();
              $c$.clean();

              if (StTrue.$bool()) {
                if (StFalse.$bool()) {
                  // We can't constrain the value to 0 or 1.
                  // The best we can do is a cast.
                  X.$assignMove(getSValBuilder().evalCast(new SVal(RHSVal), B.getType(), RHS.getType()));
                } else {
                  // The value is known to be true.
                  X.$assignMove(getSValBuilder().makeIntVal($int2ulong(1), B.getType()));
                }
              } else {
                // The value is known to be false.
                assert (StFalse.$bool()) : "Infeasible path!";
                X.$assignMove(getSValBuilder().makeIntVal($int2ulong(0), B.getType()));
              }
            } finally {
              if (StFalse != null) { StFalse.$destroy(); }
              if (StTrue != null) { StTrue.$destroy(); }
            }
          }
        }
      }
      $c$.clean(Bldr.generateNode(B, Pred, $c$.track(state.$arrow().BindExpr(B, Pred.getLocationContext(), new SVal(X)))));
    } finally {
      if (state != null) { state.$destroy(); }
      if (Bldr != null) { Bldr.$destroy(); }
      $c$.$destroy();
    }
  }


  
  /// VisitMemberExpr - Transfer function for member expressions.
  
  /// VisitMemberExpr - Transfer function for member expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 1999,
   FQN="clang::ento::ExprEngine::VisitMemberExpr", NM="_ZN5clang4ento10ExprEngine15VisitMemberExprEPKNS_10MemberExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine15VisitMemberExprEPKNS_10MemberExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitMemberExpr(/*const*/ MemberExpr /*P*/ M, ExplodedNode /*P*/ Pred, 
                 final ExplodedNodeSet /*&*/ Dst) {
    ExplodedNodeSet CheckedSet = null;
    ExplodedNodeSet EvalSet = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      // FIXME: Prechecks eventually go in ::Visit().
      CheckedSet/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForPreStmt(CheckedSet, $c$.track(new ExplodedNodeSet(Pred)), M, /*Deref*/this); $c$.clean();
      
      EvalSet/*J*/= new ExplodedNodeSet();
      ValueDecl /*P*/ Member = M.getMemberDecl();
      
      // Handle static member variables and enum constants accessed via
      // member syntax.
      if (isa_VarDecl(Member) || isa_EnumConstantDecl(Member)) {
        ExplodedNodeSet Dst$1 = null;
        try {
          Dst$1/*J*/= new ExplodedNodeSet();
          for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = CheckedSet.begin(), E = CheckedSet.end();
               I.$noteq(E); I.$preInc()) {
            VisitCommonDeclRefExpr(M, Member, Pred, EvalSet);
          }
        } finally {
          if (Dst$1 != null) { Dst$1.$destroy(); }
        }
      } else {
        StmtNodeBuilder Bldr = null;
        ExplodedNodeSet Tmp = null;
        try {
          Bldr/*J*/= new StmtNodeBuilder(CheckedSet, EvalSet, $Deref(currBldrCtx));
          Tmp/*J*/= new ExplodedNodeSet();
          
          for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = CheckedSet.begin(), E = CheckedSet.end();
               I.$noteq(E); I.$preInc()) {
            IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
            try {
              state = new IntrusiveRefCntPtr</*const*/ ProgramState>((I.$star()).getState());
              /*const*/ LocationContext /*P*/ LCtx = (I.$star()).getLocationContext();
              Expr /*P*/ BaseExpr = M.getBase();
              {

                // Handle C++ method calls.
                /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(Member);
                if ((MD != null)) {
                  if (MD.isInstance()) {
                    $c$.clean(state.$assign($c$.track(createTemporaryRegionIfNeeded($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), LCtx, BaseExpr))));
                  }

                  SVal MDVal = new SVal(JD$Move.INSTANCE, svalBuilder.getFunctionPointer(MD));
                  $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(M, LCtx, new SVal(MDVal)))));

                  $c$.clean(Bldr.generateNode(M, I.$star(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
                  continue;
                }
              }

              // Handle regular struct fields / member variables.
              $c$.clean(state.$assign($c$.track(createTemporaryRegionIfNeeded($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), LCtx, BaseExpr))));
              SVal baseExprVal = state.$arrow().getSVal(BaseExpr, LCtx);

              FieldDecl /*P*/ field = cast_FieldDecl(Member);
              SVal L = state.$arrow().getLValue(field, new SVal(baseExprVal));
              if (M.isGLValue() || M.getType().$arrow().isArrayType()) {
                // We special-case rvalues of array type because the analyzer cannot
                // reason about them, since we expect all regions to be wrapped in Locs.
                // We instead treat these as lvalues and assume that they will decay to
                // pointers as soon as they are used.
                if (!M.isGLValue()) {
                  assert (M.getType().$arrow().isArrayType());
                  /*const*/ ImplicitCastExpr /*P*/ PE = dyn_cast_ImplicitCastExpr((I.$star()).getParentMap().getParent_Stmt$C$P(M));
                  if (!(PE != null) || PE.getCastKind() != CastKind.CK_ArrayToPointerDecay) {
                    throw new llvm_unreachable("should always be wrapped in ArrayToPointerDecay");
                  }
                }
                if (field.getType().$arrow().isReferenceType()) {
                  {
                    /*const*/ MemRegion /*P*/ R = L.getAsRegion();
                    if ((R != null)) {
                      L.$assignMove(state.$arrow().getSVal(R));
                    } else {
                      L.$assignMove(new UnknownVal());
                    }
                  }
                }

                $c$.clean(Bldr.generateNode(M, I.$star(), $c$.track(state.$arrow().BindExpr(M, LCtx, new SVal(L))), (/*const*/ ProgramPointTag /*P*/ )null, 
                    ProgramPoint.Kind.PostLValueKind));
              } else {
                Bldr.takeNodes(I.$star());
                evalLoad(Tmp, M, M, I.$star(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(L)); $c$.clean();
                Bldr.addNodes(Tmp);
              }
            } finally {
             if (state != null) { state.$destroy(); }
            }
          }
        } finally {
          if (Tmp != null) { Tmp.$destroy(); }
          if (Bldr != null) { Bldr.$destroy(); }
        }
      }
      
      getCheckerManager().runCheckersForPostStmt(Dst, EvalSet, M, /*Deref*/this);
    } finally {
      if (EvalSet != null) { EvalSet.$destroy(); }
      if (CheckedSet != null) { CheckedSet.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// VisitMemberExpr - Transfer function for builtin atomic expressions
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitAtomicExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2080,
   FQN="clang::ento::ExprEngine::VisitAtomicExpr", NM="_ZN5clang4ento10ExprEngine15VisitAtomicExprEPKNS_10AtomicExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine15VisitAtomicExprEPKNS_10AtomicExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitAtomicExpr(/*const*/ AtomicExpr /*P*/ AE, ExplodedNode /*P*/ Pred, 
                 final ExplodedNodeSet /*&*/ Dst) {
    ExplodedNodeSet AfterPreSet = null;
    ExplodedNodeSet AfterInvalidateSet = null;
    StmtNodeBuilder Bldr = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      AfterPreSet/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForPreStmt(AfterPreSet, $c$.track(new ExplodedNodeSet(Pred)), AE, /*Deref*/this); $c$.clean();
      
      // For now, treat all the arguments to C11 atomics as escaping.
      // FIXME: Ideally we should model the behavior of the atomics precisely here.
      AfterInvalidateSet/*J*/= new ExplodedNodeSet();
      Bldr/*J*/= new StmtNodeBuilder(AfterPreSet, AfterInvalidateSet, $Deref(currBldrCtx));
      
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = AfterPreSet.begin(), E = AfterPreSet.end();
           I.$noteq(E); I.$preInc()) {
        IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
        try {
          State = new IntrusiveRefCntPtr</*const*/ ProgramState>((I.$star()).getState());
          /*const*/ LocationContext /*P*/ LCtx = (I.$star()).getLocationContext();

          SmallVector<SVal> ValuesToInvalidate/*J*/= new SmallVector<SVal>(8, new SVal());
          for (/*uint*/int SI = 0, Count = AE.getNumSubExprs(); SI != Count; SI++) {
            /*const*/ Expr /*P*/ SubExpr = AE.getSubExprs$Const().$at(SI);
            SVal SubExprVal = State.$arrow().getSVal(SubExpr, LCtx);
            ValuesToInvalidate.push_back(SubExprVal);
          }

          $c$.clean(State.$assign($c$.track(State.$arrow().invalidateRegions_ArrayRef2(new ArrayRef<SVal>(ValuesToInvalidate, false), AE, 
                  currBldrCtx.blockCount(), 
                  LCtx, 
                  /*CausedByPointerEscape*/ true, 
                  /*Symbols=*/ (DenseSet</*const*/ SymExpr /*P*/ > /*P*/)null))));

          SVal ResultVal = new SVal(JD$Move.INSTANCE, new UnknownVal());
          $c$.clean(State.$assign($c$.track(State.$arrow().BindExpr(AE, LCtx, new SVal(ResultVal)))));
          $c$.clean(Bldr.generateNode(AE, I.$star(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), (/*const*/ ProgramPointTag /*P*/ )null, 
              ProgramPoint.Kind.PostStmtKind));
        } finally {
         if (State != null) { State.$destroy(); }
        } 
      }
      
      getCheckerManager().runCheckersForPostStmt(Dst, AfterInvalidateSet, AE, /*Deref*/this);
    } finally {
      if (Bldr != null) { Bldr.$destroy(); }
      if (AfterInvalidateSet != null) { AfterInvalidateSet.$destroy(); }
      if (AfterPreSet != null) { AfterPreSet.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Transfer function logic for ObjCAtSynchronizedStmts.
  
  /// Transfer function logic for ObjCAtSynchronizedStmts.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitObjCAtSynchronizedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineObjC.cpp", line = 39,
   FQN="clang::ento::ExprEngine::VisitObjCAtSynchronizedStmt", NM="_ZN5clang4ento10ExprEngine27VisitObjCAtSynchronizedStmtEPKNS_22ObjCAtSynchronizedStmtEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineObjC.cpp -nm=_ZN5clang4ento10ExprEngine27VisitObjCAtSynchronizedStmtEPKNS_22ObjCAtSynchronizedStmtEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitObjCAtSynchronizedStmt(/*const*/ ObjCAtSynchronizedStmt /*P*/ S, 
                             ExplodedNode /*P*/ Pred, 
                             final ExplodedNodeSet /*&*/ Dst) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      getCheckerManager().runCheckersForPreStmt(Dst, $c$.track(new ExplodedNodeSet(Pred)), S, /*Deref*/this); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }


  
  /// Transfer function logic for computing the lvalue of an Objective-C ivar.
  
  /// Transfer function logic for computing the lvalue of an Objective-C ivar.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitLvalObjCIvarRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineObjC.cpp", line = 22,
   FQN="clang::ento::ExprEngine::VisitLvalObjCIvarRefExpr", NM="_ZN5clang4ento10ExprEngine24VisitLvalObjCIvarRefExprEPKNS_15ObjCIvarRefExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineObjC.cpp -nm=_ZN5clang4ento10ExprEngine24VisitLvalObjCIvarRefExprEPKNS_15ObjCIvarRefExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitLvalObjCIvarRefExpr(/*const*/ ObjCIvarRefExpr /*P*/ Ex, 
                          ExplodedNode /*P*/ Pred, 
                          final ExplodedNodeSet /*&*/ Dst) {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    ExplodedNodeSet dstIvar = null;
    StmtNodeBuilder Bldr = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
      SVal baseVal = state.$arrow().getSVal(Ex.getBase$Const(), LCtx);
      SVal location = state.$arrow().getLValue(Ex.getDecl$Const(), new SVal(baseVal));
      
      dstIvar/*J*/= new ExplodedNodeSet();
      Bldr/*J*/= new StmtNodeBuilder(Pred, dstIvar, $Deref(currBldrCtx));
      $c$.clean(Bldr.generateNode(Ex, Pred, $c$.track(state.$arrow().BindExpr(Ex, LCtx, new SVal(location)))));
      
      // Perform the post-condition check of the ObjCIvarRefExpr and store
      // the created nodes in 'Dst'.
      getCheckerManager().runCheckersForPostStmt(Dst, dstIvar, Ex, /*Deref*/this);
    } finally {
      if (Bldr != null) { Bldr.$destroy(); }
      if (dstIvar != null) { dstIvar.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }


  
  /// VisitObjCForCollectionStmt - Transfer function logic for
  ///  ObjCForCollectionStmt.
  
  /// VisitObjCForCollectionStmt - Transfer function logic for
  ///  ObjCForCollectionStmt.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitObjCForCollectionStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineObjC.cpp", line = 45,
   FQN="clang::ento::ExprEngine::VisitObjCForCollectionStmt", NM="_ZN5clang4ento10ExprEngine26VisitObjCForCollectionStmtEPKNS_21ObjCForCollectionStmtEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineObjC.cpp -nm=_ZN5clang4ento10ExprEngine26VisitObjCForCollectionStmtEPKNS_21ObjCForCollectionStmtEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitObjCForCollectionStmt(/*const*/ ObjCForCollectionStmt /*P*/ S, 
                            ExplodedNode /*P*/ Pred, 
                            final ExplodedNodeSet /*&*/ Dst) {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    ExplodedNodeSet dstLocation = null;
    ExplodedNodeSet Tmp = null;
    StmtNodeBuilder Bldr = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      // ObjCForCollectionStmts are processed in two places.  This method
      // handles the case where an ObjCForCollectionStmt* occurs as one of the
      // statements within a basic block.  This transfer function does two things:
      //
      //  (1) binds the next container value to 'element'.  This creates a new
      //      node in the ExplodedGraph.
      //
      //  (2) binds the value 0/1 to the ObjCForCollectionStmt* itself, indicating
      //      whether or not the container has any more elements.  This value
      //      will be tested in ProcessBranch.  We need to explicitly bind
      //      this value because a container can contain nil elements.
      //
      // FIXME: Eventually this logic should actually do dispatches to
      //   'countByEnumeratingWithState:objects:count:' (NSFastEnumeration).
      //   This will require simulating a temporary NSFastEnumerationState, either
      //   through an SVal or through the use of MemRegions.  This value can
      //   be affixed to the ObjCForCollectionStmt* instead of 0/1; when the loop
      //   terminates we reclaim the temporary (it goes out of scope) and we
      //   we can test if the SVal is 0 or if the MemRegion is null (depending
      //   on what approach we take).
      //
      //  For now: simulate (1) by assigning either a symbol or nil if the
      //    container is empty.  Thus this transfer function will by default
      //    result in state splitting.
      /*const*/ Stmt /*P*/ elem = S.getElement$Const();
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      SVal elementV/*J*/= new SVal();
      {
        
        /*const*/ DeclStmt /*P*/ DS = dyn_cast_DeclStmt(elem);
        if ((DS != null)) {
          /*const*/ VarDecl /*P*/ elemD = cast_VarDecl(DS.getSingleDecl$Const());
          assert (elemD.getInit$Const() == null);
          elementV.$assignMove(state.$arrow().getLValue(elemD, Pred.getLocationContext()));
        } else {
          elementV.$assignMove(state.$arrow().getSVal(elem, Pred.getLocationContext()));
        }
      }
      
      dstLocation/*J*/= new ExplodedNodeSet();
      evalLocation(dstLocation, S, elem, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(elementV), (/*const*/ ProgramPointTag /*P*/ )null, false); $c$.clean();
      
      Tmp/*J*/= new ExplodedNodeSet();
      Bldr/*J*/= new StmtNodeBuilder(Pred, Tmp, $Deref(currBldrCtx));
      
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > NI = dstLocation.begin(), 
          NE = dstLocation.end(); NI.$noteq(NE); NI.$preInc()) {
        IntrusiveRefCntPtr</*const*/ ProgramState> state$1 = null;
        IntrusiveRefCntPtr</*const*/ ProgramState> hasElems = null;
        IntrusiveRefCntPtr</*const*/ ProgramState> noElems = null;
        try {
          Pred = NI.$star();
          state$1 = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
          /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
          
          // Handle the case where the container still has elements.
          SVal TrueV = new SVal(JD$Move.INSTANCE, svalBuilder.makeTruthVal(true));
          hasElems = state$1.$arrow().BindExpr(S, LCtx, new SVal(TrueV));
          
          // Handle the case where the container has no elements.
          SVal FalseV = new SVal(JD$Move.INSTANCE, svalBuilder.makeTruthVal(false));
          noElems = state$1.$arrow().BindExpr(S, LCtx, new SVal(FalseV));
          {
            
            Optional<NsLoc.MemRegionVal> MV = elementV.getAs(NsLoc.MemRegionVal.class);
            if (MV.$bool()) {
              {
                /*const*/ TypedValueRegion /*P*/ R = dyn_cast_TypedValueRegion(MV.$arrow().getRegion());
                if ((R != null)) {
                  // FIXME: The proper thing to do is to really iterate over the
                  //  container.  We will do this with dispatch logic to the store.
                  //  For now, just 'conjure' up a symbolic value.
                  QualType T = R.getValueType();
                  assert (Loc.isLocType(new QualType(T)));
                  /*const*/ SymExpr /*P*/ Sym = SymMgr.conjureSymbol(elem, LCtx, new QualType(T), 
                      currBldrCtx.blockCount());
                  SVal V = new SVal(JD$Move.INSTANCE, svalBuilder.makeLoc(Sym));
                  $c$.clean(hasElems.$assign($c$.track(hasElems.$arrow().bindLoc(new SVal(elementV), new SVal(V)))));
                  
                  // Bind the location to 'nil' on the false branch.
                  SVal nilV = new SVal(JD$Move.INSTANCE, svalBuilder.makeIntVal($int2ulong(0), new QualType(T)));
                  $c$.clean(noElems.$assign($c$.track(noElems.$arrow().bindLoc(new SVal(elementV), new SVal(nilV)))));
                }
              }
            }
          }
          
          // Create the new nodes.
          $c$.clean(Bldr.generateNode(S, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(hasElems))));
          $c$.clean(Bldr.generateNode(S, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(noElems))));
        } finally {
          if (noElems != null) { noElems.$destroy(); }
          if (hasElems != null) { hasElems.$destroy(); }
          if (state$1 != null) { state$1.$destroy(); }
        }
      }
      
      // Finally, run any custom checkers.
      // FIXME: Eventually all pre- and post-checks should live in VisitStmt.
      getCheckerManager().runCheckersForPostStmt(Dst, Tmp, S, /*Deref*/this);
    } finally {
      if (Bldr != null) { Bldr.$destroy(); }
      if (Tmp != null) { Tmp.$destroy(); }
      if (dstLocation != null) { dstLocation.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitObjCMessage">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineObjC.cpp", line = 135,
   FQN="clang::ento::ExprEngine::VisitObjCMessage", NM="_ZN5clang4ento10ExprEngine16VisitObjCMessageEPKNS_15ObjCMessageExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineObjC.cpp -nm=_ZN5clang4ento10ExprEngine16VisitObjCMessageEPKNS_15ObjCMessageExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitObjCMessage(/*const*/ ObjCMessageExpr /*P*/ ME, 
                  ExplodedNode /*P*/ Pred, 
                  final ExplodedNodeSet /*&*/ Dst) {
    CallEventRef<ObjCMethodCall> Msg = null;
    ExplodedNodeSet dstPrevisit = null;
    ExplodedNodeSet dstGenericPrevisit = null;
    ExplodedNodeSet dstEval = null;
    StmtNodeBuilder Bldr = null;
    ExplodedNodeSet dstPostvisit = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final CallEventManager /*&*/ CEMgr = getStateManager().getCallEventManager();
      Msg = $c$.clean(CEMgr.getObjCMethodCall(ME, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState())), Pred.getLocationContext()));
      
      // There are three cases for the receiver:
      //   (1) it is definitely nil,
      //   (2) it is definitely non-nil, and
      //   (3) we don't know.
      //
      // If the receiver is definitely nil, we skip the pre/post callbacks and
      // instead call the ObjCMessageNil callbacks and return.
      //
      // If the receiver is definitely non-nil, we call the pre- callbacks,
      // evaluate the call, and call the post- callbacks.
      //
      // If we don't know, we drop the potential nil flow and instead
      // continue from the assumed non-nil state as in (2). This approach
      // intentionally drops coverage in order to prevent false alarms
      // in the following scenario:
      //
      // id result = [o someMethod]
      // if (result) {
      //   if (!o) {
      //     // <-- This program point should be unreachable because if o is nil
      //     // it must the case that result is nil as well.
      //   }
      // }
      //
      // We could avoid dropping coverage by performing an explicit case split
      // on each method call -- but this would get very expensive. An alternative
      // would be to introduce lazy constraints.
      // FIXME: This ignores many potential bugs (<rdar://problem/11733396>).
      // Revisit once we have lazier constraints.
      if (Msg.$arrow().isInstanceMessage()) {
        SVal recVal = Msg.$arrow().getReceiverSVal();
        if (!recVal.isUndef$SVal()) {
          IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
          IntrusiveRefCntPtr</*const*/ ProgramState> notNilState = null;
          IntrusiveRefCntPtr</*const*/ ProgramState> nilState = null;
          ExplodedNodeSet dstNonNil = null;
          StmtNodeBuilder Bldr$1 = null;
          try {
            // Bifurcate the state into nil and non-nil ones.
            DefinedOrUnknownSVal receiverVal = recVal.castAs(DefinedOrUnknownSVal.class);
            State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
            
            notNilState/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
            nilState/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//            $c$.clean(std.tie(notNilState, nilState).$assign($c$.track(State.$arrow().assume(new DefinedOrUnknownSVal(receiverVal)))));
            // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
            std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
                    $c$.track(State.$arrow().assume(new DefinedOrUnknownSVal(receiverVal)));
            notNilState.$assign($assume.first);
            nilState.$assign($assume.second);
            assert !$assume.first.$bool();
            assert !$assume.second.$bool();
            $c$.clean();
            
            // Receiver is definitely nil, so run ObjCMessageNil callbacks and return.
            if (nilState.$bool() && !notNilState.$bool()) {
              StmtNodeBuilder Bldr$2 = null;
              try {
                Bldr$2/*J*/= new StmtNodeBuilder(Pred, Dst, $Deref(currBldrCtx));
                boolean HasTag = (Pred.getLocation().getTag() != null);
                $c$.clean(Pred = Bldr$2.generateNode(ME, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(nilState)), (/*const*/ ProgramPointTag /*P*/ )null, 
                    ProgramPoint.Kind.PreStmtKind));
                assert (((Pred != null) || HasTag)) : "Should have cached out already!";
                ///*J:(void)*/HasTag;
                if (!(Pred != null)) {
                  return;
                }
                getCheckerManager().runCheckersForObjCMessageNil(Dst, $c$.track(new ExplodedNodeSet(Pred)), 
                    Msg.$star(), /*Deref*/this); $c$.clean();
                return;
              } finally {
                if (Bldr$2 != null) { Bldr$2.$destroy(); }
              }
            }
            
            dstNonNil/*J*/= new ExplodedNodeSet();
            Bldr$1/*J*/= new StmtNodeBuilder(Pred, dstNonNil, $Deref(currBldrCtx));
            // Generate a transition to the non-nil state, dropping any potential
            // nil flow.
            if ($noteq_IntrusiveRefCntPtr(notNilState, State)) {
              boolean HasTag = (Pred.getLocation().getTag() != null);
              $c$.clean(Pred = Bldr$1.generateNode(ME, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(notNilState))));
              assert (((Pred != null) || HasTag)) : "Should have cached out already!";
              ///*J:(void)*/HasTag;
              if (!(Pred != null)) {
                return;
              }
            }
          } finally {
            if (Bldr$1 != null) { Bldr$1.$destroy(); }
            if (dstNonNil != null) { dstNonNil.$destroy(); }
            if (nilState != null) { nilState.$destroy(); }
            if (notNilState != null) { notNilState.$destroy(); }
            if (State != null) { State.$destroy(); }
          }
        }
      }
      
      // Handle the previsits checks.
      dstPrevisit/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForPreObjCMessage(dstPrevisit, $c$.track(new ExplodedNodeSet(Pred)), 
          Msg.$star(), /*Deref*/this); $c$.clean();
      dstGenericPrevisit/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForPreCall(dstGenericPrevisit, dstPrevisit, 
          Msg.$star(), /*Deref*/this);
      
      // Proceed with evaluate the message expression.
      dstEval/*J*/= new ExplodedNodeSet();
      Bldr/*J*/= new StmtNodeBuilder(dstGenericPrevisit, dstEval, $Deref(currBldrCtx));
      
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > DI = dstGenericPrevisit.begin(), 
          DE = dstGenericPrevisit.end(); DI.$noteq(DE); DI.$preInc()) {
        IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
        CallEventRef<ObjCMethodCall> UpdatedMsg = null;
        try {
          ExplodedNode /*P*/ Pred$1 = DI.$star();
          State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred$1.getState());
          UpdatedMsg = $c$.clean(Msg.cloneWithState(ObjCMethodCall.class, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
          if (UpdatedMsg.$arrow().isInstanceMessage()) {
            SVal recVal = UpdatedMsg.$arrow().getReceiverSVal();
            if (!recVal.isUndef$SVal()) {
              if (ObjCNoRet.isImplicitNoReturn(ME)) {
                // If we raise an exception, for now treat it as a sink.
                // Eventually we will want to handle exceptions properly.
                $c$.clean(Bldr.generateSink(ME, Pred$1, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
                continue;
              }
            }
          } else {
            // Check for special class methods that are known to not return
            // and that we should treat as a sink.
            if (ObjCNoRet.isImplicitNoReturn(ME)) {
              // If we raise an exception, for now treat it as a sink.
              // Eventually we will want to handle exceptions properly.
              $c$.clean(Bldr.generateSink(ME, Pred$1, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred$1.getState()))));
              continue;
            }
          }
          
          defaultEvalCall(Bldr, Pred$1, UpdatedMsg.$star());
        } finally {
          if (UpdatedMsg != null) { UpdatedMsg.$destroy(); }
          if (State != null) { State.$destroy(); }
        }
      }
      
      dstPostvisit/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForPostCall(dstPostvisit, dstEval, 
          Msg.$star(), /*Deref*/this);
      
      // Finally, perform the post-condition check of the ObjCMessageExpr and store
      // the created nodes in 'Dst'.
      getCheckerManager().runCheckersForPostObjCMessage(Dst, dstPostvisit, 
          Msg.$star(), /*Deref*/this);
    } finally {
      if (dstPostvisit != null) { dstPostvisit.$destroy(); }
      if (Bldr != null) { Bldr.$destroy(); }
      if (dstEval != null) { dstEval.$destroy(); }
      if (dstGenericPrevisit != null) { dstGenericPrevisit.$destroy(); }
      if (dstPrevisit != null) { dstPrevisit.$destroy(); }
      if (Msg != null) { Msg.$destroy(); }
      $c$.$destroy();
    }
  }


  
  /// VisitReturnStmt - Transfer function logic for return statements.
  
  /// VisitReturnStmt - Transfer function logic for return statements.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitReturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 979,
   FQN="clang::ento::ExprEngine::VisitReturnStmt", NM="_ZN5clang4ento10ExprEngine15VisitReturnStmtEPKNS_10ReturnStmtEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang4ento10ExprEngine15VisitReturnStmtEPKNS_10ReturnStmtEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitReturnStmt(/*const*/ ReturnStmt /*P*/ RS, ExplodedNode /*P*/ Pred, 
                 final ExplodedNodeSet /*&*/ Dst) {
    ExplodedNodeSet dstPreVisit = null;
    StmtNodeBuilder B = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      dstPreVisit/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForPreStmt(dstPreVisit, $c$.track(new ExplodedNodeSet(Pred)), RS, /*Deref*/this); $c$.clean();
      
      B/*J*/= new StmtNodeBuilder(dstPreVisit, Dst, $Deref(currBldrCtx));
      if ((RS.getRetValue$Const() != null)) {
        for (SmallPtrSetIterator<ExplodedNode /*P*/ > it = dstPreVisit.begin(), 
            ei = dstPreVisit.end(); it.$noteq(ei); it.$preInc()) {
          $c$.clean(B.generateNode(RS, it.$star(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>((it.$star()).getState()))));
        }
      }
    } finally {
      if (B != null) { B.$destroy(); }
      if (dstPreVisit != null) { dstPreVisit.$destroy(); }
      $c$.$destroy();
    }
  }


  
  /// VisitOffsetOfExpr - Transfer function for offsetof.
  
  /// VisitOffsetOfExpr - Transfer function for offsetof.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitOffsetOfExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp", line = 730,
   FQN="clang::ento::ExprEngine::VisitOffsetOfExpr", NM="_ZN5clang4ento10ExprEngine17VisitOffsetOfExprEPKNS_12OffsetOfExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp -nm=_ZN5clang4ento10ExprEngine17VisitOffsetOfExprEPKNS_12OffsetOfExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitOffsetOfExpr(/*const*/ OffsetOfExpr /*P*/ OOE, 
                   ExplodedNode /*P*/ Pred, final ExplodedNodeSet /*&*/ Dst) {
    StmtNodeBuilder B = null;
    try {
      B/*J*/= new StmtNodeBuilder(Pred, Dst, $Deref(currBldrCtx));
      APSInt IV/*J*/= new APSInt();
      if (OOE.EvaluateAsInt(IV, getContext())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          assert ($uint2ullong(IV.getBitWidth()) == getContext().getTypeSize(OOE.getType()));
          assert (OOE.getType().$arrow().isBuiltinType());
          assert (OOE.getType().$arrow().getAs$BuiltinType().isInteger());
          assert (IV.isSigned() == OOE.getType().$arrow().isSignedIntegerType());
          SVal X = new SVal(JD$Move.INSTANCE, svalBuilder.makeIntVal(IV));
          $c$.clean(B.generateNode(OOE, Pred, 
              $c$.track(Pred.getState().$arrow().BindExpr(OOE, Pred.getLocationContext(), 
                  new SVal(X)))));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
      if (B != null) { B.$destroy(); }
    }
    // FIXME: Handle the case where __builtin_offsetof is not a constant.
  }


  
  /// VisitUnaryExprOrTypeTraitExpr - Transfer function for sizeof.
  
  /// VisitUnaryExprOrTypeTraitExpr - Transfer function for sizeof.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitUnaryExprOrTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp", line = 749,
   FQN="clang::ento::ExprEngine::VisitUnaryExprOrTypeTraitExpr", NM="_ZN5clang4ento10ExprEngine29VisitUnaryExprOrTypeTraitExprEPKNS_24UnaryExprOrTypeTraitExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp -nm=_ZN5clang4ento10ExprEngine29VisitUnaryExprOrTypeTraitExprEPKNS_24UnaryExprOrTypeTraitExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitUnaryExprOrTypeTraitExpr(/*const*/ UnaryExprOrTypeTraitExpr /*P*/ Ex, 
                               ExplodedNode /*P*/ Pred, 
                               final ExplodedNodeSet /*&*/ Dst) {
    ExplodedNodeSet CheckedSet = null;
    ExplodedNodeSet EvalSet = null;
    StmtNodeBuilder Bldr = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // FIXME: Prechecks eventually go in ::Visit().
      CheckedSet/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForPreStmt(CheckedSet, $c$.track(new ExplodedNodeSet(Pred)), Ex, /*Deref*/this); $c$.clean();
      
      EvalSet/*J*/= new ExplodedNodeSet();
      Bldr/*J*/= new StmtNodeBuilder(CheckedSet, EvalSet, $Deref(currBldrCtx));
      
      QualType T = Ex.getTypeOfArgument();
      
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = CheckedSet.begin(), E = CheckedSet.end();
           I.$noteq(E); I.$preInc()) {
        IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
        try {
          if (Ex.getKind() == UnaryExprOrTypeTrait.UETT_SizeOf) {
            if (!T.$arrow().isIncompleteType() && !T.$arrow().isConstantSizeType()) {
              assert (T.$arrow().isVariableArrayType()) : "Unknown non-constant-sized type.";

              // FIXME: Add support for VLA type arguments and VLA expressions.
              // When that happens, we should probably refactor VLASizeChecker's code.
              continue;
            } else if ((T.$arrow().getAs(ObjCObjectType.class) != null)) {
              // Some code tries to take the sizeof an ObjCObjectType, relying that
              // the compiler has laid out its representation.  Just report Unknown
              // for these.
              continue;
            }
          }

          APSInt Value = Ex.EvaluateKnownConstInt(getContext());
          CharUnits amt = CharUnits.fromQuantity(Value.getZExtValue());

          state = new IntrusiveRefCntPtr</*const*/ ProgramState>((I.$star()).getState());
          $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(Ex, (I.$star()).getLocationContext(), 
                  new SVal(JD$Move.INSTANCE, svalBuilder.makeIntVal(amt.getQuantity(), 
                          Ex.getType()))))));
          $c$.clean(Bldr.generateNode(Ex, I.$star(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
        } finally {
         if (state != null) { state.$destroy(); }
        }
      }
      
      getCheckerManager().runCheckersForPostStmt(Dst, EvalSet, Ex, /*Deref*/this);
    } finally {
      if (Bldr != null) { Bldr.$destroy(); }
      if (EvalSet != null) { EvalSet.$destroy(); }
      if (CheckedSet != null) { CheckedSet.$destroy(); }
      $c$.$destroy();
    }
  }


  
  /// VisitUnaryOperator - Transfer function logic for unary operators.
  
  /// VisitUnaryOperator - Transfer function logic for unary operators.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitUnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp", line = 792,
   FQN="clang::ento::ExprEngine::VisitUnaryOperator", NM="_ZN5clang4ento10ExprEngine18VisitUnaryOperatorEPKNS_13UnaryOperatorEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp -nm=_ZN5clang4ento10ExprEngine18VisitUnaryOperatorEPKNS_13UnaryOperatorEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitUnaryOperator(/*const*/ UnaryOperator /*P*/ U, 
                    ExplodedNode /*P*/ Pred, 
                    final ExplodedNodeSet /*&*/ Dst) {
    ExplodedNodeSet CheckedSet = null;
    ExplodedNodeSet EvalSet = null;
    StmtNodeBuilder Bldr = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // FIXME: Prechecks eventually go in ::Visit().
      CheckedSet/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForPreStmt(CheckedSet, $c$.track(new ExplodedNodeSet(Pred)), U, /*Deref*/this); $c$.clean();
      
      EvalSet/*J*/= new ExplodedNodeSet();
      Bldr/*J*/= new StmtNodeBuilder(CheckedSet, EvalSet, $Deref(currBldrCtx));
      
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = CheckedSet.begin(), E = CheckedSet.end();
           I.$noteq(E); I.$preInc()) {
        switch (U.getOpcode()) {
         default:
          {
            ExplodedNodeSet Tmp = null;
            try {
              Bldr.takeNodes(I.$star());
              Tmp/*J*/= new ExplodedNodeSet();
              VisitIncrementDecrementOperator(U, I.$star(), Tmp);
              Bldr.addNodes(Tmp);
              break;
            } finally {
              if (Tmp != null) { Tmp.$destroy(); }
            }
          }
         case UO_Real:
          {
            IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
            try {
              /*const*/ Expr /*P*/ Ex = U.getSubExpr().IgnoreParens();
              
              // FIXME: We don't have complex SValues yet.
              if (Ex.getType().$arrow().isAnyComplexType()) {
                // Just report "Unknown."
                break;
              }
              
              // For all other types, UO_Real is an identity operation.
              assert (QualType.$eq_QualType$C(U.getType(), Ex.getType()));
              state = new IntrusiveRefCntPtr</*const*/ ProgramState>((I.$star()).getState());
              /*const*/ LocationContext /*P*/ LCtx = (I.$star()).getLocationContext();
              $c$.clean(Bldr.generateNode(U, I.$star(), $c$.track(state.$arrow().BindExpr(U, LCtx, 
                      state.$arrow().getSVal(Ex, LCtx)))));
              break;
            } finally {
              if (state != null) { state.$destroy(); }
            }
          }
         case UO_Imag:
          {
            IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
            try {
              /*const*/ Expr /*P*/ Ex = U.getSubExpr().IgnoreParens();
              // FIXME: We don't have complex SValues yet.
              if (Ex.getType().$arrow().isAnyComplexType()) {
                // Just report "Unknown."
                break;
              }
              // For all other types, UO_Imag returns 0.
              state = new IntrusiveRefCntPtr</*const*/ ProgramState>((I.$star()).getState());
              /*const*/ LocationContext /*P*/ LCtx = (I.$star()).getLocationContext();
              SVal X = new SVal(JD$Move.INSTANCE, svalBuilder.makeZeroVal(Ex.getType()));
              $c$.clean(Bldr.generateNode(U, I.$star(), $c$.track(state.$arrow().BindExpr(U, LCtx, new SVal(X)))));
              break;
            } finally {
              if (state != null) { state.$destroy(); }
            }
          }
         case UO_Plus:
          assert (!U.isGLValue());
         case UO_Deref:
         case UO_AddrOf:
         case UO_Extension:
          {
            IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
            try {
              // FIXME: We can probably just have some magic in Environment::getSVal()
              // that propagates values, instead of creating a new node here.
              //
              // Unary "+" is a no-op, similar to a parentheses.  We still have places
              // where it may be a block-level expression, so we need to
              // generate an extra node that just propagates the value of the
              // subexpression.
              /*const*/ Expr /*P*/ Ex = U.getSubExpr().IgnoreParens();
              state = new IntrusiveRefCntPtr</*const*/ ProgramState>((I.$star()).getState());
              /*const*/ LocationContext /*P*/ LCtx = (I.$star()).getLocationContext();
              $c$.clean(Bldr.generateNode(U, I.$star(), $c$.track(state.$arrow().BindExpr(U, LCtx, 
                      state.$arrow().getSVal(Ex, LCtx)))));
              break;
            } finally {
              if (state != null) { state.$destroy(); }
            }
          }
         case UO_LNot:
         case UO_Minus:
         case UO_Not:
          {
            IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
            try {
              assert (!U.isGLValue());
              /*const*/ Expr /*P*/ Ex = U.getSubExpr().IgnoreParens();
              state = new IntrusiveRefCntPtr</*const*/ ProgramState>((I.$star()).getState());
              /*const*/ LocationContext /*P*/ LCtx = (I.$star()).getLocationContext();
              
              // Get the value of the subexpression.
              SVal V = state.$arrow().getSVal(Ex, LCtx);
              if (V.isUnknownOrUndef$SVal()) {
                $c$.clean(Bldr.generateNode(U, I.$star(), $c$.track(state.$arrow().BindExpr(U, LCtx, new SVal(V)))));
                break;
              }
              switch (U.getOpcode()) {
               default:
                throw new llvm_unreachable("Invalid Opcode.");
               case UO_Not:
                // FIXME: Do we need to handle promotions?
                $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(U, LCtx, evalComplement(new SVal(JD$Move.INSTANCE, V.castAs(NonLoc.class)))))));
                break;
               case UO_Minus:
                // FIXME: Do we need to handle promotions?
                $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(U, LCtx, evalMinus(new SVal(JD$Move.INSTANCE, V.castAs(NonLoc.class)))))));
                break;
               case UO_LNot:
                // C99 6.5.3.3: "The expression !E is equivalent to (0==E)."
                //
                //  Note: technically we do "E == 0", but this is the same in the
                //    transfer functions as "0 == E".
                SVal Result/*J*/= new SVal();
                {
                  Optional<Loc> LV = V.getAs(Loc.class);
                  if (LV.$bool()) {
                    Loc X = svalBuilder.makeNull();
                    $c$.clean(Result.$assignMove(evalBinOp($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_EQ, new SVal(LV.$star()), new SVal(X), U.getType())));
                  } else if (Ex.getType().$arrow().isFloatingType()) {
                    // FIXME: handle floating point types.
                    Result.$assignMove(new UnknownVal());
                  } else {
                    NsNonloc.ConcreteInt X/*J*/= new NsNonloc.ConcreteInt(getBasicVals().getValue($int2ulong(0), Ex.getType()));
                    $c$.clean(Result.$assignMove(evalBinOp($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_EQ, V.castAs(NonLoc.class), new NonLoc(X), 
                            U.getType())));
                  }
                }
                
                $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(U, LCtx, new SVal(Result)))));
                break;
              }
              $c$.clean(Bldr.generateNode(U, I.$star(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
              break;
            } finally {
              if (state != null) { state.$destroy(); }
            }
          }
        }
      }
      
      getCheckerManager().runCheckersForPostStmt(Dst, EvalSet, U, /*Deref*/this);
    } finally {
      if (Bldr != null) { Bldr.$destroy(); }
      if (EvalSet != null) { EvalSet.$destroy(); }
      if (CheckedSet != null) { CheckedSet.$destroy(); }
      $c$.$destroy();
    }
  }


  
  /// Handle ++ and -- (both pre- and post-increment).
  
  /// Handle ++ and -- (both pre- and post-increment).
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitIncrementDecrementOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp", line = 924,
   FQN="clang::ento::ExprEngine::VisitIncrementDecrementOperator", NM="_ZN5clang4ento10ExprEngine31VisitIncrementDecrementOperatorEPKNS_13UnaryOperatorEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineC.cpp -nm=_ZN5clang4ento10ExprEngine31VisitIncrementDecrementOperatorEPKNS_13UnaryOperatorEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitIncrementDecrementOperator(/*const*/ UnaryOperator /*P*/ U, 
                                 ExplodedNode /*P*/ Pred, 
                                 final ExplodedNodeSet /*&*/ Dst) {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    ExplodedNodeSet Tmp = null;
    ExplodedNodeSet Dst2 = null;
    StmtNodeBuilder Bldr = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Handle ++ and -- (both pre- and post-increment).
      assert (U.isIncrementDecrementOp());
      /*const*/ Expr /*P*/ Ex = U.getSubExpr().IgnoreParens();
      
      /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      SVal loc = state.$arrow().getSVal(Ex, LCtx);
      
      // Perform a load.
      Tmp/*J*/= new ExplodedNodeSet();
      evalLoad(Tmp, U, Ex, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(loc)); $c$.clean();
      
      Dst2/*J*/= new ExplodedNodeSet();
      Bldr/*J*/= new StmtNodeBuilder(Tmp, Dst2, $Deref(currBldrCtx));
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = Tmp.begin(), E = Tmp.end(); I.$noteq(E); I.$preInc()) {
        ExplodedNodeSet Dst3 = null;
        try {
          
          $c$.clean(state.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>((I.$star()).getState()))));
          assert (LCtx == (I.$star()).getLocationContext());
          SVal V2_untested = state.$arrow().getSVal(Ex, LCtx);
          
          // Propagate unknown and undefined values.
          if (V2_untested.isUnknownOrUndef$SVal()) {
            $c$.clean(Bldr.generateNode(U, I.$star(), $c$.track(state.$arrow().BindExpr(U, LCtx, new SVal(V2_untested)))));
            continue;
          }
          DefinedSVal V2 = V2_untested.castAs(DefinedSVal.class);
          
          // Handle all other values.
          BinaryOperatorKind Op = U.isIncrementOp() ? BinaryOperatorKind.BO_Add : BinaryOperatorKind.BO_Sub;
          
          // If the UnaryOperator has non-location type, use its type to create the
          // constant value. If the UnaryOperator has location type, create the
          // constant with int type and pointer width.
          SVal RHS/*J*/= new SVal();
          if (U.getType().$arrow().isAnyPointerType()) {
            RHS.$assignMove(svalBuilder.makeArrayIndex($int2ulong(1)));
          } else if (U.getType().$arrow().isIntegralOrEnumerationType()) {
            RHS.$assignMove(svalBuilder.makeIntVal($int2ulong(1), U.getType()));
          } else {
            RHS.$assignMove(new UnknownVal());
          }
          
          SVal Result = $c$.clean(evalBinOp($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Op, new SVal(V2), new SVal(RHS), U.getType()));
          
          // Conjure a new symbol if necessary to recover precision.
          if (Result.isUnknown$SVal()) {
            DefinedOrUnknownSVal SymVal = svalBuilder.conjureSymbolVal((/*const*/Object/*void P*/ )null, Ex, LCtx, 
                currBldrCtx.blockCount());
            Result.$assign(SymVal);
            
            // If the value is a location, ++/-- should always preserve
            // non-nullness.  Check if the original value was non-null, and if so
            // propagate that constraint.
            if (Loc.isLocType(U.getType())) {
              DefinedOrUnknownSVal Constraint = $c$.clean(svalBuilder.evalEQ($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new DefinedOrUnknownSVal(V2), svalBuilder.makeZeroVal(U.getType())));
              if ($c$.clean(!$c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(Constraint), true)).$bool())) {
                // It isn't feasible for the original value to be null.
                // Propagate this constraint.
                $c$.clean(Constraint.$assignMove(svalBuilder.evalEQ($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new DefinedOrUnknownSVal(SymVal), 
                        svalBuilder.makeZeroVal(U.getType()))));
                
                $c$.clean(state.$assign($c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(Constraint), false))));
                assert ((state).$bool());
              }
            }
          }
          
          // Since the lvalue-to-rvalue conversion is explicit in the AST,
          // we bind an l-value if the operator is prefix and an lvalue (in C++).
          if (U.isGLValue()) {
            $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(U, LCtx, new SVal(loc)))));
          } else {
            $c$.clean(state.$assign($c$.track(state.$arrow().BindExpr(U, LCtx, new SVal(U.isPostfix() ? V2 : Result)))));
          }
          
          // Perform the store.
          Bldr.takeNodes(I.$star());
          Dst3/*J*/= new ExplodedNodeSet();
          evalStore(Dst3, U, U, I.$star(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(loc), new SVal(Result)); $c$.clean();
          Bldr.addNodes(Dst3);
        } finally {
          if (Dst3 != null) { Dst3.$destroy(); }
        }
      }
      Dst.insert(Dst2);
    } finally {
      if (Bldr != null) { Bldr.$destroy(); }
      if (Dst2 != null) { Dst2.$destroy(); }
      if (Tmp != null) { Tmp.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitCXXBindTemporaryExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 718,
   FQN="clang::ento::ExprEngine::VisitCXXBindTemporaryExpr", NM="_ZN5clang4ento10ExprEngine25VisitCXXBindTemporaryExprEPKNS_20CXXBindTemporaryExprERNS0_15ExplodedNodeSetES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine25VisitCXXBindTemporaryExprEPKNS_20CXXBindTemporaryExprERNS0_15ExplodedNodeSetES6_")
  //</editor-fold>
  public void VisitCXXBindTemporaryExpr(/*const*/ CXXBindTemporaryExpr /*P*/ BTE, 
                           final ExplodedNodeSet /*&*/ PreVisit, 
                           final ExplodedNodeSet /*&*/ Dst) {
    StmtNodeBuilder StmtBldr = null;
    try {
      if (!getAnalysisManager().options.includeTemporaryDtorsInCFG()) {
        // In case we don't have temporary destructors in the CFG, do not mark
        // the initialization - we would otherwise never clean it up.
        Dst.$assign(PreVisit);
        return;
      }
      StmtBldr/*J*/= new StmtNodeBuilder(PreVisit, Dst, $Deref(currBldrCtx));
      for (ExplodedNode /*P*/ Node : PreVisit) {
        IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Node.getState());
          if (!State.$arrow().contains(ProgramStateTraitInitializedTemporariesSet.$Instance, std.make_pair_Ptr_Ptr(BTE, Node.getStackFrame()))) {
            // FIXME: Currently the state might already contain the marker due to
            // incorrect handling of temporaries bound to default parameters; for
            // those, we currently skip the CXXBindTemporaryExpr but rely on adding
            // temporary destructor nodes.
            $c$.clean(State.$assign($c$.track(State.$arrow().add(ProgramStateTraitInitializedTemporariesSet.$Instance, std.make_pair_Ptr_Ptr(BTE, Node.getStackFrame())))));
          }
          $c$.clean(StmtBldr.generateNode(BTE, Node, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        } finally {
          if (State != null) { State.$destroy(); }
          $c$.$destroy();
        }
      }
    } finally {
      if (StmtBldr != null) { StmtBldr.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitCXXCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp", line = 538,
   FQN="clang::ento::ExprEngine::VisitCXXCatchStmt", NM="_ZN5clang4ento10ExprEngine17VisitCXXCatchStmtEPKNS_12CXXCatchStmtEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp -nm=_ZN5clang4ento10ExprEngine17VisitCXXCatchStmtEPKNS_12CXXCatchStmtEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitCXXCatchStmt(/*const*/ CXXCatchStmt /*P*/ CS, 
                   ExplodedNode /*P*/ Pred, 
                   final ExplodedNodeSet /*&*/ Dst) {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    StmtNodeBuilder Bldr = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ VarDecl /*P*/ VD = CS.getExceptionDecl();
      if (!(VD != null)) {
        Dst.Add(Pred);
        return;
      }
      
      /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
      SVal V = new SVal(JD$Move.INSTANCE, svalBuilder.conjureSymbolVal(CS, LCtx, VD.getType(), 
              currBldrCtx.blockCount()));
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      $c$.clean(state.$assign($c$.track(state.$arrow().bindLoc(state.$arrow().getLValue(VD, LCtx), new SVal(V)))));
      
      Bldr/*J*/= new StmtNodeBuilder(Pred, Dst, $Deref(currBldrCtx));
      $c$.clean(Bldr.generateNode(CS, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      if (Bldr != null) { Bldr.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitCXXThisExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp", line = 557,
   FQN="clang::ento::ExprEngine::VisitCXXThisExpr", NM="_ZN5clang4ento10ExprEngine16VisitCXXThisExprEPKNS_11CXXThisExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp -nm=_ZN5clang4ento10ExprEngine16VisitCXXThisExprEPKNS_11CXXThisExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitCXXThisExpr(/*const*/ CXXThisExpr /*P*/ TE, ExplodedNode /*P*/ Pred, 
                  final ExplodedNodeSet /*&*/ Dst) {
    StmtNodeBuilder Bldr = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Bldr/*J*/= new StmtNodeBuilder(Pred, Dst, $Deref(currBldrCtx));
      
      // Get the this object region from StoreManager.
      /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
      /*const*/ MemRegion /*P*/ R = svalBuilder.getRegionManager().getCXXThisRegion(getContext().getCanonicalType(TE.getType()).$QualType(), 
          LCtx);
      
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      SVal V = state.$arrow().getSVal(new Loc(JD$Move.INSTANCE, new NsLoc.MemRegionVal(R)));
      $c$.clean(Bldr.generateNode(TE, Pred, $c$.track(state.$arrow().BindExpr(TE, LCtx, new SVal(V)))));
    } finally {
      if (state != null) { state.$destroy(); }
      if (Bldr != null) { Bldr.$destroy(); }
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp", line = 233,
   FQN="clang::ento::ExprEngine::VisitCXXConstructExpr", NM="_ZN5clang4ento10ExprEngine21VisitCXXConstructExprEPKNS_16CXXConstructExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp -nm=_ZN5clang4ento10ExprEngine21VisitCXXConstructExprEPKNS_16CXXConstructExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitCXXConstructExpr(/*const*/ CXXConstructExpr /*P*/ CE, 
                       ExplodedNode /*P*/ Pred, 
                       final ExplodedNodeSet /*&*/ destNodes) {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    CallEventRef<CXXConstructorCall> Call = null;
    ExplodedNodeSet DstPreVisit = null;
    ExplodedNodeSet PreInitialized = null;
    ExplodedNodeSet DstPreCall = null;
    ExplodedNodeSet DstEvaluated = null;
    StmtNodeBuilder Bldr = null;
    ExplodedNodeSet DstPostCall = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      
      /*const*/ MemRegion /*P*/ Target = null;
      
      // FIXME: Handle arrays, which run the same constructor for every element.
      // For now, we just run the first constructor (which should still invalidate
      // the entire array).
      switch (CE.getConstructionKind()) {
       case CK_Complete:
        {
          Target = getRegionForConstructedObject(CE, Pred);
          break;
        }
       case CK_VirtualBase:
        {
          // Make sure we are not calling virtual base class initializers twice.
          // Only the most-derived object should initialize virtual base classes.
          /*const*/ Stmt /*P*/ Outer = LCtx.getCurrentStackFrame().getCallSite();
          if ((Outer != null)) {
            /*const*/ CXXConstructExpr /*P*/ OuterCtor = dyn_cast_CXXConstructExpr(Outer);
            if ((OuterCtor != null)) {
              switch (OuterCtor.getConstructionKind()) {
               case CK_NonVirtualBase:
               case CK_VirtualBase:
                // Bail out!
                destNodes.Add(Pred);
                return;
               case CK_Complete:
               case CK_Delegating:
                break;
              }
            }
          }
        }
       case CK_NonVirtualBase:
       case CK_Delegating:
        {
          /*const*/ CXXMethodDecl /*P*/ CurCtor = cast_CXXMethodDecl(LCtx.getDecl());
          Loc ThisPtr = new Loc(JD$Move.INSTANCE, getSValBuilder().getCXXThis(CurCtor, 
                  LCtx.getCurrentStackFrame()));
          SVal ThisVal = State.$arrow().getSVal(new Loc(ThisPtr));
          if (CE.getConstructionKind() == CXXConstructExpr.ConstructionKind.CK_Delegating) {
            Target = ThisVal.getAsRegion();
          } else {
            // Cast to the base type.
            boolean IsVirtual = (CE.getConstructionKind() == CXXConstructExpr.ConstructionKind.CK_VirtualBase);
            SVal BaseVal = getStoreManager().evalDerivedToBase(new SVal(ThisVal), CE.getType(), 
                IsVirtual);
            Target = BaseVal.getAsRegion();
          }
          break;
        }
      }
      
      final CallEventManager /*&*/ CEMgr = getStateManager().getCallEventManager();
      Call = $c$.clean(CEMgr.getCXXConstructorCall(CE, Target, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), LCtx));
      
      DstPreVisit/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForPreStmt(DstPreVisit, $c$.track(new ExplodedNodeSet(Pred)), CE, /*Deref*/this); $c$.clean();
      
      PreInitialized/*J*/= new ExplodedNodeSet();
      {
        StmtNodeBuilder Bldr$1 = null;
        try {
          Bldr$1/*J*/= new StmtNodeBuilder(DstPreVisit, PreInitialized, $Deref(currBldrCtx));
          if (CE.requiresZeroInitialization()) {
            // Type of the zero doesn't matter.
            SVal ZeroVal = new SVal(JD$Move.INSTANCE, svalBuilder.makeZeroVal(getContext().CharTy.$QualType()));
            
            for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = DstPreVisit.begin(), 
                E = DstPreVisit.end();
                 I.$noteq(E); I.$preInc()) {
              IntrusiveRefCntPtr</*const*/ ProgramState> State$1 = null;
              try { 
                State$1 = new IntrusiveRefCntPtr</*const*/ ProgramState>((I.$star()).getState());
                // FIXME: Once we properly handle constructors in new-expressions, we'll
                // need to invalidate the region before setting a default value, to make
                // sure there aren't any lingering bindings around. This probably needs
                // to happen regardless of whether or not the object is zero-initialized
                // to handle random fields of a placement-initialized object picking up
                // old bindings. We might only want to do it when we need to, though.
                // FIXME: This isn't actually correct for arrays -- we need to zero-
                // initialize the entire array, not just the first element -- but our
                // handling of arrays everywhere else is weak as well, so this shouldn't
                // actually make things worse. Placement new makes this tricky as well,
                // since it's then possible to be initializing one part of a multi-
                // dimensional array.
                $c$.clean(State$1.$assign($c$.track(State$1.$arrow().bindDefault(new SVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(Target)), new SVal(ZeroVal)))));
                $c$.clean(Bldr$1.generateNode(CE, I.$star(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State$1)), /*tag=*/ (/*const*/ ProgramPointTag /*P*/ )null, 
                    ProgramPoint.Kind.PreStmtKind));
              } finally {
               if (State$1 != null) { State$1.$destroy(); }
              } 
            }
          }
        } finally {
          if (Bldr$1 != null) { Bldr$1.$destroy(); }
        }
      }
      
      DstPreCall/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForPreCall(DstPreCall, PreInitialized, 
          Call.$star(), /*Deref*/this);
      
      DstEvaluated/*J*/= new ExplodedNodeSet();
      Bldr/*J*/= new StmtNodeBuilder(DstPreCall, DstEvaluated, $Deref(currBldrCtx));
      
      boolean IsArray = isa_ElementRegion(Target);
      if (CE.getConstructor().isTrivial()
         && CE.getConstructor().isCopyOrMoveConstructor()
         && !IsArray) {
        // FIXME: Handle other kinds of trivial constructors as well.
        for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = DstPreCall.begin(), E = DstPreCall.end();
             I.$noteq(E); I.$preInc())  {
          performTrivialCopy(Bldr, I.$star(), Call.$star());
        }
      } else {
        for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = DstPreCall.begin(), E = DstPreCall.end();
             I.$noteq(E); I.$preInc())  {
          defaultEvalCall(Bldr, I.$star(), Call.$star());
        }
      }
      
      DstPostCall/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForPostCall(DstPostCall, DstEvaluated, 
          Call.$star(), /*Deref*/this);
      getCheckerManager().runCheckersForPostStmt(destNodes, DstPostCall, CE, /*Deref*/this);
    } finally {
      if (DstPostCall != null) { DstPostCall.$destroy(); }
      if (Bldr != null) { Bldr.$destroy(); }
      if (DstEvaluated != null) { DstEvaluated.$destroy(); }
      if (DstPreCall != null) { DstPreCall.$destroy(); }
      if (PreInitialized != null) { PreInitialized.$destroy(); }
      if (DstPreVisit != null) { DstPreVisit.$destroy(); }
      if (Call != null) { Call.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitCXXDestructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp", line = 355,
   FQN="clang::ento::ExprEngine::VisitCXXDestructor", NM="_ZN5clang4ento10ExprEngine18VisitCXXDestructorENS_8QualTypeEPKNS0_9MemRegionEPKNS_4StmtEbPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp -nm=_ZN5clang4ento10ExprEngine18VisitCXXDestructorENS_8QualTypeEPKNS0_9MemRegionEPKNS_4StmtEbPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitCXXDestructor(QualType ObjectType, 
                    /*const*/ MemRegion /*P*/ Dest, 
                    /*const*/ Stmt /*P*/ S, 
                    boolean IsBaseDtor, 
                    ExplodedNode /*P*/ Pred, 
                    final ExplodedNodeSet /*&*/ Dst) {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    CallEventRef<CXXDestructorCall> Call = null;
    PrettyStackTraceLoc CrashInfo = null;
    ExplodedNodeSet DstPreCall = null;
    ExplodedNodeSet DstInvalidated = null;
    StmtNodeBuilder Bldr = null;
    ExplodedNodeSet DstPostCall = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      
      // FIXME: We need to run the same destructor on every element of the array.
      // This workaround will just run the first destructor (which will still
      // invalidate the entire array).
      SVal DestVal = new SVal(JD$Move.INSTANCE, new UnknownVal());
      if ((Dest != null)) {
        DestVal.$assignMove(new NsLoc.MemRegionVal(Dest));
      }
      $c$.clean(DestVal.$assignMove(ExprEngineCXXStatics.makeZeroElementRegion($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), new SVal(DestVal), ObjectType)));
      Dest = DestVal.getAsRegion();
      
      /*const*/ CXXRecordDecl /*P*/ RecordDecl = ObjectType.$arrow().getAsCXXRecordDecl();
      assert ((RecordDecl != null)) : "Only CXXRecordDecls should have destructors";
      /*const*/ CXXDestructorDecl /*P*/ DtorDecl = RecordDecl.getDestructor();
      
      final CallEventManager /*&*/ CEMgr = getStateManager().getCallEventManager();
      Call = $c$.clean(CEMgr.getCXXDestructorCall(DtorDecl, S, Dest, IsBaseDtor, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), LCtx));
      
      CrashInfo/*J*/= new PrettyStackTraceLoc(getContext().getSourceManager(), 
          Call.$arrow().getSourceRange().getBegin(), 
          $("Error evaluating destructor"));
      
      DstPreCall/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForPreCall(DstPreCall, $c$.track(new ExplodedNodeSet(Pred)), 
          Call.$star(), /*Deref*/this); $c$.clean();
      
      DstInvalidated/*J*/= new ExplodedNodeSet();
      Bldr/*J*/= new StmtNodeBuilder(DstPreCall, DstInvalidated, $Deref(currBldrCtx));
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = DstPreCall.begin(), E = DstPreCall.end();
           I.$noteq(E); I.$preInc())  {
        defaultEvalCall(Bldr, I.$star(), Call.$star());
      }
      
      DstPostCall/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForPostCall(Dst, DstInvalidated, 
          Call.$star(), /*Deref*/this);
    } finally {
      if (DstPostCall != null) { DstPostCall.$destroy(); }
      if (Bldr != null) { Bldr.$destroy(); }
      if (DstInvalidated != null) { DstInvalidated.$destroy(); }
      if (DstPreCall != null) { DstPreCall.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
      if (Call != null) { Call.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitCXXNewAllocatorCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp", line = 400,
   FQN="clang::ento::ExprEngine::VisitCXXNewAllocatorCall", NM="_ZN5clang4ento10ExprEngine24VisitCXXNewAllocatorCallEPKNS_10CXXNewExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp -nm=_ZN5clang4ento10ExprEngine24VisitCXXNewAllocatorCallEPKNS_10CXXNewExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitCXXNewAllocatorCall(/*const*/ CXXNewExpr /*P*/ CNE, 
                          ExplodedNode /*P*/ Pred, 
                          final ExplodedNodeSet /*&*/ Dst) {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    PrettyStackTraceLoc CrashInfo = null;
    CallEventRef<CXXAllocatorCall> Call = null;
    ExplodedNodeSet DstPreCall = null;
    ExplodedNodeSet DstInvalidated = null;
    StmtNodeBuilder Bldr = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
      CrashInfo/*J*/= new PrettyStackTraceLoc(getContext().getSourceManager(), 
          CNE.getStartLoc(), 
          $("Error evaluating New Allocator Call"));
      final CallEventManager /*&*/ CEMgr = getStateManager().getCallEventManager();
      Call = $c$.clean(CEMgr.getCXXAllocatorCall(CNE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), LCtx));
      
      DstPreCall/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForPreCall(DstPreCall, $c$.track(new ExplodedNodeSet(Pred)), 
          Call.$star(), /*Deref*/this); $c$.clean();
      
      DstInvalidated/*J*/= new ExplodedNodeSet();
      Bldr/*J*/= new StmtNodeBuilder(DstPreCall, DstInvalidated, $Deref(currBldrCtx));
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = DstPreCall.begin(), E = DstPreCall.end();
           I.$noteq(E); I.$preInc())  {
        defaultEvalCall(Bldr, I.$star(), Call.$star());
      }
      getCheckerManager().runCheckersForPostCall(Dst, DstInvalidated, 
          Call.$star(), /*Deref*/this);
    } finally {
      if (Bldr != null) { Bldr.$destroy(); }
      if (DstInvalidated != null) { DstInvalidated.$destroy(); }
      if (DstPreCall != null) { DstPreCall.$destroy(); }
      if (Call != null) { Call.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitCXXNewExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp", line = 426,
   FQN="clang::ento::ExprEngine::VisitCXXNewExpr", NM="_ZN5clang4ento10ExprEngine15VisitCXXNewExprEPKNS_10CXXNewExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp -nm=_ZN5clang4ento10ExprEngine15VisitCXXNewExprEPKNS_10CXXNewExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitCXXNewExpr(/*const*/ CXXNewExpr /*P*/ CNE, ExplodedNode /*P*/ Pred, 
                 final ExplodedNodeSet /*&*/ Dst) {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    CallEventRef<CXXAllocatorCall> Call = null;
    StmtNodeBuilder Bldr = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // FIXME: Much of this should eventually migrate to CXXAllocatorCall.
      // Also, we need to decide how allocators actually work -- they're not
      // really part of the CXXNewExpr because they happen BEFORE the
      // CXXConstructExpr subexpression. See PR12014 for some discussion.
      /*uint*/int blockCount = currBldrCtx.blockCount();
      /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
      DefinedOrUnknownSVal symVal = new DefinedOrUnknownSVal(JD$Move.INSTANCE, new UnknownVal());
      FunctionDecl /*P*/ FD = CNE.getOperatorNew();
      
      boolean IsStandardGlobalOpNewFunction = false;
      if ((FD != null) && !isa_CXXMethodDecl(FD) && !FD.isVariadic()) {
        if (FD.getNumParams() == 2) {
          QualType T = FD.getParamDecl(1).getType();
          {
            /*const*/ IdentifierInfo /*P*/ II = T.getBaseTypeIdentifier();
            if ((II != null)) {
              // NoThrow placement new behaves as a standard new.
              IsStandardGlobalOpNewFunction = II.getName().equals(/*STRINGREF_STR*/"nothrow_t");
            }
          }
        } else {
          // Placement forms are considered non-standard.
          IsStandardGlobalOpNewFunction = (FD.getNumParams() == 1);
        }
      }
      
      // We assume all standard global 'operator new' functions allocate memory in
      // heap. We realize this is an approximation that might not correctly model
      // a custom global allocator.
      if (IsStandardGlobalOpNewFunction) {
        symVal.$assignMove(svalBuilder.getConjuredHeapSymbolVal(CNE, LCtx, blockCount));
      } else {
        symVal.$assignMove(svalBuilder.conjureSymbolVal((/*const*/Object/*void P*/ )null, CNE, LCtx, CNE.getType(), 
                blockCount));
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      final CallEventManager /*&*/ CEMgr = getStateManager().getCallEventManager();
      Call = $c$.clean(CEMgr.getCXXAllocatorCall(CNE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), LCtx));
      
      // Invalidate placement args.
      // FIXME: Once we figure out how we want allocators to work,
      // we should be using the usual pre-/(default-)eval-/post-call checks here.
      $c$.clean(State.$assign($c$.track(Call.$arrow().invalidateRegions(blockCount))));
      if (!State.$bool()) {
        return;
      }
      
      // If this allocation function is not declared as non-throwing, failures
      // /must/ be signalled by exceptions, and thus the return value will never be
      // NULL. -fno-exceptions does not influence this semantics.
      // FIXME: GCC has a -fcheck-new option, which forces it to consider the case
      // where new can return NULL. If we end up supporting that option, we can
      // consider adding a check for it here.
      // C++11 [basic.stc.dynamic.allocation]p3.
      if ((FD != null)) {
        QualType Ty = FD.getType();
        {
          /*const*/ FunctionProtoType /*P*/ ProtoType = Ty.$arrow().getAs(FunctionProtoType.class);
          if ((ProtoType != null)) {
            if (!ProtoType.isNothrow(getContext())) {
              $c$.clean(State.$assign($c$.track(State.$arrow().assume(new DefinedOrUnknownSVal(symVal), true))));
            }
          }
        }
      }
      
      Bldr/*J*/= new StmtNodeBuilder(Pred, Dst, $Deref(currBldrCtx));
      if (CNE.isArray()) {
        // FIXME: allocating an array requires simulating the constructors.
        // For now, just return a symbolicated region.
        /*const*/ MemRegion /*P*/ NewReg = symVal.castAs(NsLoc.MemRegionVal.class).getRegion();
        QualType ObjTy = CNE.getType().$arrow().getAs(PointerType.class).getPointeeType();
        /*const*/ ElementRegion /*P*/ EleReg = getStoreManager().GetElementZeroRegion(NewReg, new QualType(ObjTy));
        $c$.clean(State.$assign($c$.track(State.$arrow().BindExpr(CNE, Pred.getLocationContext(), 
                new SVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(EleReg))))));
        $c$.clean(Bldr.generateNode(CNE, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        return;
      }
      
      // FIXME: Once we have proper support for CXXConstructExprs inside
      // CXXNewExpr, we need to make sure that the constructed object is not
      // immediately invalidated here. (The placement call should happen before
      // the constructor call anyway.)
      SVal Result = new SVal(symVal);
      if ((FD != null) && FD.isReservedGlobalPlacementOperator()) {
        // Non-array placement new should always return the placement location.
        SVal PlacementLoc = State.$arrow().getSVal(CNE.getPlacementArg$Const(0), LCtx);
        Result.$assignMove(svalBuilder.evalCast(new SVal(PlacementLoc), CNE.getType(), 
                CNE.getPlacementArg$Const(0).getType()));
      }
      
      // Bind the address of the object, then check to see if we cached out.
      $c$.clean(State.$assign($c$.track(State.$arrow().BindExpr(CNE, LCtx, new SVal(Result)))));
      ExplodedNode /*P*/ NewN = $c$.clean(Bldr.generateNode(CNE, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
      if (!(NewN != null)) {
        return;
      }
      {
        
        // If the type is not a record, we won't have a CXXConstructExpr as an
        // initializer. Copy the value over.
        /*const*/ Expr /*P*/ Init = CNE.getInitializer$Const();
        if ((Init != null)) {
          if (!isa_CXXConstructExpr(Init)) {
            assert (Bldr.getResults().size() == 1);
            Bldr.takeNodes(NewN);
            evalBind(Dst, CNE, NewN, new SVal(Result), State.$arrow().getSVal(Init, LCtx), 
                /*FirstInit=*/ IsStandardGlobalOpNewFunction);
          }
        }
      }
    } finally {
      if (Bldr != null) { Bldr.$destroy(); }
      if (Call != null) { Call.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::VisitCXXDeleteExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp", line = 531,
   FQN="clang::ento::ExprEngine::VisitCXXDeleteExpr", NM="_ZN5clang4ento10ExprEngine18VisitCXXDeleteExprEPKNS_13CXXDeleteExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp -nm=_ZN5clang4ento10ExprEngine18VisitCXXDeleteExprEPKNS_13CXXDeleteExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void VisitCXXDeleteExpr(/*const*/ CXXDeleteExpr /*P*/ CDE, 
                    ExplodedNode /*P*/ Pred, final ExplodedNodeSet /*&*/ Dst) {
    StmtNodeBuilder Bldr = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Bldr/*J*/= new StmtNodeBuilder(Pred, Dst, $Deref(currBldrCtx));
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      $c$.clean(Bldr.generateNode(CDE, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      if (state != null) { state.$destroy(); }
      if (Bldr != null) { Bldr.$destroy(); }
      $c$.$destroy();
    }
  }


  
  /// Create a C++ temporary object for an rvalue.
  
  /// Create a C++ temporary object for an rvalue.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::CreateCXXTemporaryObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp", line = 25,
   FQN="clang::ento::ExprEngine::CreateCXXTemporaryObject", NM="_ZN5clang4ento10ExprEngine24CreateCXXTemporaryObjectEPKNS_24MaterializeTemporaryExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp -nm=_ZN5clang4ento10ExprEngine24CreateCXXTemporaryObjectEPKNS_24MaterializeTemporaryExprEPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetE")
  //</editor-fold>
  public void CreateCXXTemporaryObject(/*const*/ MaterializeTemporaryExpr /*P*/ ME, 
                          ExplodedNode /*P*/ Pred, 
                          final ExplodedNodeSet /*&*/ Dst) {
    StmtNodeBuilder Bldr = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Bldr/*J*/= new StmtNodeBuilder(Pred, Dst, $Deref(currBldrCtx));
      /*const*/ Expr /*P*/ tempExpr = ME.GetTemporaryExpr().IgnoreParens();
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
      
      $c$.clean(state.$assign($c$.track(createTemporaryRegionIfNeeded($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), LCtx, tempExpr, ME))));
      $c$.clean(Bldr.generateNode(ME, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      if (state != null) { state.$destroy(); }
      if (Bldr != null) { Bldr.$destroy(); }
      $c$.$destroy();
    }
  }


  
  /// evalEagerlyAssumeBinOpBifurcation - Given the nodes in 'Src', eagerly assume symbolic
  ///  expressions of the form 'x != 0' and generate new nodes (stored in Dst)
  ///  with those assumptions.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::evalEagerlyAssumeBinOpBifurcation">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2435,
   FQN="clang::ento::ExprEngine::evalEagerlyAssumeBinOpBifurcation", NM="_ZN5clang4ento10ExprEngine33evalEagerlyAssumeBinOpBifurcationERNS0_15ExplodedNodeSetES3_PKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine33evalEagerlyAssumeBinOpBifurcationERNS0_15ExplodedNodeSetES3_PKNS_4ExprE")
  //</editor-fold>
  public void evalEagerlyAssumeBinOpBifurcation(final ExplodedNodeSet /*&*/ Dst, 
                                   final ExplodedNodeSet /*&*/ Src, 
                                   /*const*/ Expr /*P*/ Ex) {
    StmtNodeBuilder Bldr = null;
    try {
      Bldr/*J*/= new StmtNodeBuilder(Src, Dst, $Deref(currBldrCtx));
      
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = Src.begin(), E = Src.end(); I.$noteq(E); I.$preInc()) {
        IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
        try {
          ExplodedNode /*P*/ Pred = I.$star();
          // Test if the previous node was as the same expression.  This can happen
          // when the expression fails to evaluate to anything meaningful and
          // (as an optimization) we don't generate a node.
          ProgramPoint P = Pred.getLocation();
          if (!P.getAs(org.clang.analysis.PostStmt.class).$bool() || P.castAs(org.clang.analysis.PostStmt.class).getStmt() != Ex) {
            continue;
          }

          state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
          SVal V = state.$arrow().getSVal(Ex, Pred.getLocationContext());
          Optional<NsNonloc.SymbolVal> SEV = V.getAs(NsNonloc.SymbolVal.class);
          if (SEV.$bool() && SEV.$arrow().isExpression()) {
            IntrusiveRefCntPtr</*const*/ ProgramState> StateTrue = null;
            IntrusiveRefCntPtr</*const*/ ProgramState> StateFalse = null;
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              final /*const*/std.pairPtrPtr</*const*/ ProgramPointTag /*P*/ , /*const*/ ProgramPointTag /*P*/ > /*&*/ tags = geteagerlyAssumeBinOpBifurcationTags();

              StateTrue/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
              StateFalse/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
  //            $c$.clean(std.tie(StateTrue, StateFalse).$assign($c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(SEV.$star())))));
              // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
              std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
                      $c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(SEV.$star())));
              StateTrue.$assign($assume.first);
              StateFalse.$assign($assume.second);
              assert !$assume.first.$bool();
              assert !$assume.second.$bool();
              $c$.clean();

              // First assume that the condition is true.
              if (StateTrue.$bool()) {
                SVal Val = new SVal(JD$Move.INSTANCE, svalBuilder.makeIntVal($uint2ulong(1/*U*/), Ex.getType()));
                $c$.clean(StateTrue.$assign($c$.track(StateTrue.$arrow().BindExpr(Ex, Pred.getLocationContext(), new SVal(Val)))));
                $c$.clean(Bldr.generateNode(Ex, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StateTrue)), tags.first));
              }

              // Next, assume that the condition is false.
              if (StateFalse.$bool()) {
                SVal Val = new SVal(JD$Move.INSTANCE, svalBuilder.makeIntVal($uint2ulong(0/*U*/), Ex.getType()));
                $c$.clean(StateFalse.$assign($c$.track(StateFalse.$arrow().BindExpr(Ex, Pred.getLocationContext(), new SVal(Val)))));
                $c$.clean(Bldr.generateNode(Ex, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StateFalse)), tags.second));
              }
            } finally {
              if (StateFalse != null) { StateFalse.$destroy(); }
              if (StateTrue != null) { StateTrue.$destroy(); }
              $c$.$destroy();
            }
          }
       } finally {
        if (state != null) { state.$destroy(); }
       } 
      }
    } finally {
      if (Bldr != null) { Bldr.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::geteagerlyAssumeBinOpBifurcationTags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2424,
   FQN="clang::ento::ExprEngine::geteagerlyAssumeBinOpBifurcationTags", NM="_ZN5clang4ento10ExprEngine36geteagerlyAssumeBinOpBifurcationTagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine36geteagerlyAssumeBinOpBifurcationTagsEv")
  //</editor-fold>
  public std.pairPtrPtr</*const*/ ProgramPointTag /*P*/ , /*const*/ ProgramPointTag /*P*/ > geteagerlyAssumeBinOpBifurcationTags() {
    final/*static*/ SimpleProgramPointTag eagerlyAssumeBinOpBifurcationTrue = geteagerlyAssumeBinOpBifurcationTags$$.eagerlyAssumeBinOpBifurcationTrue;
    final/*static*/ SimpleProgramPointTag eagerlyAssumeBinOpBifurcationFalse = geteagerlyAssumeBinOpBifurcationTags$$.eagerlyAssumeBinOpBifurcationFalse;
    return new std.pairPtrPtr</*const*/ ProgramPointTag /*P*/ , /*const*/ ProgramPointTag /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/$AddrOf(eagerlyAssumeBinOpBifurcationTrue), /*Fwd2*//*Fwd*/$AddrOf(eagerlyAssumeBinOpBifurcationFalse));
  }
  private static final class geteagerlyAssumeBinOpBifurcationTags$$ {
    static final/*static*/ SimpleProgramPointTag eagerlyAssumeBinOpBifurcationTrue/*J*/= new SimpleProgramPointTag(new StringRef(TagProviderName), 
        new StringRef(/*KEEP_STR*/"Eagerly Assume True"));
    static final/*static*/ SimpleProgramPointTag eagerlyAssumeBinOpBifurcationFalse/*J*/= new SimpleProgramPointTag(new StringRef(TagProviderName), 
        new StringRef(/*KEEP_STR*/"Eagerly Assume False"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::evalMinus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 477,
   FQN="clang::ento::ExprEngine::evalMinus", NM="_ZN5clang4ento10ExprEngine9evalMinusENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine9evalMinusENS0_4SValE")
  //</editor-fold>
  public SVal evalMinus(SVal X) {
    return X.isValid$SVal() ? svalBuilder.evalMinus(X.castAs(NonLoc.class)) : new SVal(X);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::evalComplement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 481,
   FQN="clang::ento::ExprEngine::evalComplement", NM="_ZN5clang4ento10ExprEngine14evalComplementENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine14evalComplementENS0_4SValE")
  //</editor-fold>
  public SVal evalComplement(SVal X) {
    return X.isValid$SVal() ? svalBuilder.evalComplement(X.castAs(NonLoc.class)) : new SVal(X);
  }

/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::evalBinOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 487,
   FQN="clang::ento::ExprEngine::evalBinOp", NM="_ZN5clang4ento10ExprEngine9evalBinOpEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS_18BinaryOperatorKindENS0_6NonLocES8_NS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine9evalBinOpEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS_18BinaryOperatorKindENS0_6NonLocES8_NS_8QualTypeE")
  //</editor-fold>
  public SVal evalBinOp(IntrusiveRefCntPtr</*const*/ ProgramState> state, BinaryOperatorKind op, 
           NonLoc L, NonLoc R, QualType T) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {  
      return $c$.clean(svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), op, new NonLoc(L), new NonLoc(R), new QualType(T)));
    } finally {
     $c$.$destroy();
    } 
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::evalBinOp">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 492,
   FQN="clang::ento::ExprEngine::evalBinOp", NM="_ZN5clang4ento10ExprEngine9evalBinOpEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS_18BinaryOperatorKindENS0_6NonLocENS0_4SValENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine9evalBinOpEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS_18BinaryOperatorKindENS0_6NonLocENS0_4SValENS_8QualTypeE")
  //</editor-fold>
  public SVal evalBinOp(IntrusiveRefCntPtr</*const*/ ProgramState> state, BinaryOperatorKind op, 
           NonLoc L, SVal R, QualType T) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {  
      return $c$.clean(R.isValid$SVal() ? svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), op, new NonLoc(L), 
          R.castAs(NonLoc.class), new QualType(T)) : new SVal(R));
    } finally {
     $c$.$destroy();
    } 
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::evalBinOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExprEngine.h", line = 498,
   FQN="clang::ento::ExprEngine::evalBinOp", NM="_ZN5clang4ento10ExprEngine9evalBinOpEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS_18BinaryOperatorKindENS0_4SValES8_NS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine9evalBinOpEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS_18BinaryOperatorKindENS0_4SValES8_NS_8QualTypeE")
  //</editor-fold>
  public SVal evalBinOp(IntrusiveRefCntPtr</*const*/ ProgramState> ST, BinaryOperatorKind Op, 
           SVal LHS, SVal RHS, QualType T) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {  
      return $c$.clean(svalBuilder.evalBinOp($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(ST)), Op, new SVal(LHS), new SVal(RHS), new QualType(T)));
    } finally {
     $c$.$destroy();
    } 
  }

/*protected:*/
  /// evalBind - Handle the semantics of binding a value to a specific location.
  ///  This method is used by evalStore, VisitDeclStmt, and others.
  
  /// evalBind - Handle the semantics of binding a value to a specific location.
  ///  This method is used by evalStore and (soon) VisitDeclStmt, and others.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::evalBind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2229,
   FQN="clang::ento::ExprEngine::evalBind", NM="_ZN5clang4ento10ExprEngine8evalBindERNS0_15ExplodedNodeSetEPKNS_4StmtEPNS0_12ExplodedNodeENS0_4SValES9_bPKNS_12ProgramPointE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine8evalBindERNS0_15ExplodedNodeSetEPKNS_4StmtEPNS0_12ExplodedNodeENS0_4SValES9_bPKNS_12ProgramPointE")
  //</editor-fold>
  protected void evalBind(final ExplodedNodeSet /*&*/ Dst, /*const*/ Stmt /*P*/ StoreE, 
          ExplodedNode /*P*/ Pred, 
          SVal location, SVal Val) {
    evalBind(Dst, StoreE, 
          Pred, 
          location, Val, 
          false, (/*const*/ ProgramPoint /*P*/ )null);
  }
  protected void evalBind(final ExplodedNodeSet /*&*/ Dst, /*const*/ Stmt /*P*/ StoreE, 
          ExplodedNode /*P*/ Pred, 
          SVal location, SVal Val, 
          boolean atDeclInit/*= false*/) {
    evalBind(Dst, StoreE, 
          Pred, 
          location, Val, 
          atDeclInit, (/*const*/ ProgramPoint /*P*/ )null);
  }
  protected void evalBind(final ExplodedNodeSet /*&*/ Dst, /*const*/ Stmt /*P*/ StoreE, 
          ExplodedNode /*P*/ Pred, 
          SVal location, SVal Val, 
          boolean atDeclInit/*= false*/, /*const*/ ProgramPoint /*P*/ PP/*= null*/) {
    ExplodedNodeSet CheckedSet = null;
    StmtNodeBuilder Bldr = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      /*const*/ LocationContext /*P*/ LC = Pred.getLocationContext();
      org.clang.analysis.PostStmt PS/*J*/= new org.clang.analysis.PostStmt(StoreE, LC);
      if (!(PP != null)) {
        PP = $AddrOf(PS);
      }
      
      // Do a previsit of the bind.
      CheckedSet/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForBind(CheckedSet, $c$.track(new ExplodedNodeSet(Pred)), new SVal(location), new SVal(Val), 
          StoreE, /*Deref*/this, $Deref(PP)); $c$.clean();
      
      Bldr/*J*/= new StmtNodeBuilder(CheckedSet, Dst, $Deref(currBldrCtx));
      
      // If the location is not a 'Loc', it will already be handled by
      // the checkers.  There is nothing left to do.
      if (!location.getAs(Loc.class).$bool()) {
        IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
        try {
          /*const*/ ProgramPoint L = new ProgramPoint(JD$Move.INSTANCE, new PostStore(StoreE, LC, /*Loc*/ (/*const*/Object/*void P*/ )null, 
                  /*tag*/ (/*const*/ ProgramPointTag /*P*/ )null));
          state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
          $c$.clean(state.$assign($c$.track(processPointerEscapedOnBind($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(location), new SVal(Val)))));
          $c$.clean(Bldr.generateNode(L, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Pred));
          return;
        } finally {
         if (state != null) { state.$destroy(); }
        } 
      }
      
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = CheckedSet.begin(), E = CheckedSet.end();
           I.$noteq(E); I.$preInc()) {
        IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
        try {
          ExplodedNode /*P*/ PredI = I.$star();
          state = new IntrusiveRefCntPtr</*const*/ ProgramState>(PredI.getState());

          $c$.clean(state.$assign($c$.track(processPointerEscapedOnBind($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(location), new SVal(Val)))));

          // When binding the value, pass on the hint that this is a initialization.
          // For initializations, we do not need to inform clients of region
          // changes.
          $c$.clean(state.$assign($c$.track(state.$arrow().bindLoc(location.castAs(Loc.class), 
                  new SVal(Val), /* notifyChanges = */ !atDeclInit))));

          /*const*/ MemRegion /*P*/ LocReg = null;
          {
            Optional<NsLoc.MemRegionVal> LocRegVal = location.getAs(NsLoc.MemRegionVal.class);
            if (LocRegVal.$bool()) {
              LocReg = LocRegVal.$arrow().getRegion();
            }
          }

          /*const*/ ProgramPoint L = new ProgramPoint(JD$Move.INSTANCE, new PostStore(StoreE, LC, LocReg, (/*const*/ ProgramPointTag /*P*/ )null));
          $c$.clean(Bldr.generateNode(L, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), PredI));
        } finally {
         if (state != null) { state.$destroy(); }
        } 
      }
    } finally {
      if (Bldr != null) { Bldr.$destroy(); }
      if (CheckedSet != null) { CheckedSet.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Call PointerEscape callback when a value escapes as a result of bind.
  // end anonymous namespace
  
  // A value escapes in three possible cases:
  // (1) We are binding to something that is not a memory region.
  // (2) We are binding to a MemrRegion that does not have stack storage.
  // (3) We are binding to a MemRegion with stack storage that the store
  //     does not understand.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::processPointerEscapedOnBind">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2138,
   FQN="clang::ento::ExprEngine::processPointerEscapedOnBind", NM="_ZN5clang4ento10ExprEngine27processPointerEscapedOnBindEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine27processPointerEscapedOnBindEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValES7_")
  //</editor-fold>
  @Override public/*protected*/ IntrusiveRefCntPtr</*const*/ ProgramState> processPointerEscapedOnBind(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                             SVal Loc, SVal Val)/* override*/ {
    CollectReachableSymbolsCallback Scanner = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Are we storing to something that causes the value to "escape"?
      boolean escapes = true;
      {
        
        // TODO: Move to StoreManager.
        Optional<NsLoc.MemRegionVal> regionLoc = Loc.getAs(NsLoc.MemRegionVal.class);
        if (regionLoc.$bool()) {
          escapes = !regionLoc.$arrow().getRegion().hasStackStorage();
          if (!escapes) {
            // To test (3), generate a new state with the binding added.  If it is
            // the same state, then it escapes (since the store cannot represent
            // the binding).
            // Do this only if we know that the store is not supposed to generate the
            // same state.
            SVal StoredVal = State.$arrow().getSVal(regionLoc.$arrow().getRegion());
            if (StoredVal.$noteq(Val)) {
              $c$.clean(escapes = ($eq_IntrusiveRefCntPtr(State, ($c$.track(State.$arrow().bindLoc(new Loc(regionLoc.$star()), new SVal(Val)))))));
            }
          }
        }
      }
      
      // If our store can represent the binding and we aren't storing to something
      // that doesn't have local storage then just return and have the simulation
      // state continue as is.
      if (!escapes) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
      }
      
      // Otherwise, find all symbols referenced by 'val' that we are tracking
      // and stop tracking them.
      Scanner = State.$arrow().scanReachableSymbols$T(CollectReachableSymbolsCallback.class, new SVal(Val));
      final /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*&*/ EscapedSymbols = Scanner.getSymbols();
      $c$.clean(State.$assign($c$.track(getCheckerManager().runCheckersForPointerEscape($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), 
              EscapedSymbols, 
              /*CallEvent*/ (/*const*/ CallEvent /*P*/ )null, 
              PointerEscapeKind.PSK_EscapeOnBind, 
              (RegionAndSymbolInvalidationTraits /*P*/ )null))));
      
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
    } finally {
      if (Scanner != null) { Scanner.$destroy(); }
      $c$.$destroy();
    }
  }

  /// Call PointerEscape callback when a value escapes as a result of
  /// region invalidation.
  /// \param[in] ITraits Specifies invalidation traits for regions/symbols.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::notifyCheckersOfPointerEscape">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2179,
   FQN="clang::ento::ExprEngine::notifyCheckersOfPointerEscape", NM="_ZN5clang4ento10ExprEngine29notifyCheckersOfPointerEscapeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISA_EEEENS2_8ArrayRefIPKNS0_9MemRegionEEESK_PKNS0_9CallEventERNS0_33RegionAndSymbolInvalidationTraitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine29notifyCheckersOfPointerEscapeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISA_EEEENS2_8ArrayRefIPKNS0_9MemRegionEEESK_PKNS0_9CallEventERNS0_33RegionAndSymbolInvalidationTraitsE")
  //</editor-fold>
  @Override public/*protected*/ IntrusiveRefCntPtr</*const*/ ProgramState> notifyCheckersOfPointerEscape(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                               /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*P*/ Invalidated, 
                               ArrayRef</*const*/ MemRegion /*P*/ > ExplicitRegions, 
                               ArrayRef</*const*/ MemRegion /*P*/ > Regions, 
                               /*const*/ CallEvent /*P*/ Call, 
                               final RegionAndSymbolInvalidationTraits /*&*/ ITraits)/* override*/ {
    if (!(Invalidated != null) || Invalidated.empty()) {
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
    }
    if (!(Call != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(getCheckerManager().runCheckersForPointerEscape($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), 
            $Deref(Invalidated), 
            (/*const*/ CallEvent /*P*/ )null, 
            PointerEscapeKind.PSK_EscapeOther, 
            $AddrOf(ITraits)));
      } finally {
        $c$.$destroy();
      }
    }
    
    // If the symbols were invalidated by a call, we want to find out which ones
    // were invalidated directly due to being arguments to the call.
    DenseSet</*const*/ SymExpr /*P*/ > SymbolsDirectlyInvalidated/*J*/= new DenseSet</*const*/ SymExpr /*P*/ >(DenseMapInfo$LikePtr.$Info());
    for (type$ptr</*const*/ MemRegion /*P*/ /*P*/> I = $tryClone(ExplicitRegions.begin()), 
        /*P*/ E = $tryClone(ExplicitRegions.end()); $noteq_ptr(I, E); I.$preInc()) {
      {
        /*const*/ SymbolicRegion /*P*/ R = (I.$star()).StripCasts().getAs(SymbolicRegion.class);
        if ((R != null)) {
          SymbolsDirectlyInvalidated.insert(R.getSymbol());
        }
      }
    }
    
    DenseSet</*const*/ SymExpr /*P*/ > SymbolsIndirectlyInvalidated/*J*/= new DenseSet</*const*/ SymExpr /*P*/ >(DenseMapInfo$LikePtr.$Info());
    for (DenseSet.iterator<SymExpr> I = Invalidated.begin$Const(), 
        E = Invalidated.end$Const(); I.$noteq(E); I.$preInc()) {
      /*const*/ SymExpr /*P*/ sym = I.$star();
      if ((SymbolsDirectlyInvalidated.count(sym) != 0)) {
        continue;
      }
      SymbolsIndirectlyInvalidated.insert(sym);
    }
    if (!SymbolsDirectlyInvalidated.empty()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(State.$assign($c$.track(getCheckerManager().runCheckersForPointerEscape($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), 
                SymbolsDirectlyInvalidated, Call, PointerEscapeKind.PSK_DirectEscapeOnCall, $AddrOf(ITraits)))));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Notify about the symbols that get indirectly invalidated by the call.
    if (!SymbolsIndirectlyInvalidated.empty()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(State.$assign($c$.track(getCheckerManager().runCheckersForPointerEscape($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), 
                SymbolsIndirectlyInvalidated, Call, PointerEscapeKind.PSK_IndirectEscapeOnCall, $AddrOf(ITraits)))));
      } finally {
        $c$.$destroy();
      }
    }
    
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
  }

/*public:*/
  // FIXME: 'tag' should be removed, and a LocationContext should be used
  // instead.
  // FIXME: Comment on the meaning of the arguments, when 'St' may not
  // be the same as Pred->state, and when 'location' may not be the
  // same as state->getLValue(Ex).
  /// Simulate a read of the result of Ex.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::evalLoad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2312,
   FQN="clang::ento::ExprEngine::evalLoad", NM="_ZN5clang4ento10ExprEngine8evalLoadERNS0_15ExplodedNodeSetEPKNS_4ExprES6_PNS0_12ExplodedNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValEPKNS_15ProgramPointTagENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine8evalLoadERNS0_15ExplodedNodeSetEPKNS_4ExprES6_PNS0_12ExplodedNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValEPKNS_15ProgramPointTagENS_8QualTypeE")
  //</editor-fold>
  public void evalLoad(final ExplodedNodeSet /*&*/ Dst, 
          /*const*/ Expr /*P*/ NodeEx, 
          /*const*/ Expr /*P*/ BoundEx, 
          ExplodedNode /*P*/ Pred, 
          IntrusiveRefCntPtr</*const*/ ProgramState> state, 
          SVal location) {
    evalLoad(Dst, 
          NodeEx, 
          BoundEx, 
          Pred, 
          state, 
          location, 
          (/*const*/ ProgramPointTag /*P*/ )null, 
          new QualType());
  }
  public void evalLoad(final ExplodedNodeSet /*&*/ Dst, 
          /*const*/ Expr /*P*/ NodeEx, 
          /*const*/ Expr /*P*/ BoundEx, 
          ExplodedNode /*P*/ Pred, 
          IntrusiveRefCntPtr</*const*/ ProgramState> state, 
          SVal location, 
          /*const*/ ProgramPointTag /*P*/ tag/*= null*/) {
    evalLoad(Dst, 
          NodeEx, 
          BoundEx, 
          Pred, 
          state, 
          location, 
          tag, 
          new QualType());
  }
  public void evalLoad(final ExplodedNodeSet /*&*/ Dst, 
          /*const*/ Expr /*P*/ NodeEx, 
          /*const*/ Expr /*P*/ BoundEx, 
          ExplodedNode /*P*/ Pred, 
          IntrusiveRefCntPtr</*const*/ ProgramState> state, 
          SVal location, 
          /*const*/ ProgramPointTag /*P*/ tag/*= null*/, 
          QualType LoadTy/*= QualType()*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (!location.getAs(NonLoc.class).$bool()) : "location cannot be a NonLoc.";
      {
        
        // Are we loading from a region?  This actually results in two loads; one
        // to fetch the address of the referenced value and one to fetch the
        // referenced value.
        /*const*/ TypedValueRegion /*P*/ TR = dyn_cast_or_null_TypedValueRegion(location.getAsRegion());
        if ((TR != null)) {
          
          QualType ValTy = TR.getValueType();
          {
            /*const*/ ReferenceType /*P*/ RT = ValTy.$arrow().getAs(ReferenceType.class);
            if ((RT != null)) {
              ExplodedNodeSet Tmp = null;
              try {
                final/*static*/ SimpleProgramPointTag loadReferenceTag = evalLoad$$.loadReferenceTag;
                Tmp/*J*/= new ExplodedNodeSet();
                evalLoadCommon(Tmp, NodeEx, BoundEx, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), 
                    new SVal(location), $AddrOf(loadReferenceTag), 
                    getContext().getPointerType(RT.getPointeeType())); $c$.clean();
                
                // Perform the load from the referenced value.
                for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = Tmp.begin(), E = Tmp.end(); I.$noteq(E); I.$preInc()) {
                  $c$.clean(state.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>((I.$star()).getState()))));
                  location.$assignMove(state.$arrow().getSVal(BoundEx, (I.$star()).getLocationContext()));
                  evalLoadCommon(Dst, NodeEx, BoundEx, I.$star(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(location), tag, new QualType(LoadTy)); $c$.clean();
                }
                return;
              } finally {
                if (Tmp != null) { Tmp.$destroy(); }
              }
            }
          }
        }
      }
      
      evalLoadCommon(Dst, NodeEx, BoundEx, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(location), tag, new QualType(LoadTy)); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }
  private static final class evalLoad$$ {
    static final/*static*/ SimpleProgramPointTag loadReferenceTag/*J*/= new SimpleProgramPointTag(new StringRef(TagProviderName), new StringRef(/*KEEP_STR*/"Load Reference"));
  }

  
  // FIXME: 'tag' should be removed, and a LocationContext should be used
  // instead.
  
  /// evalStore - Handle the semantics of a store via an assignment.
  ///  @param Dst The node set to store generated state nodes
  ///  @param AssignE The assignment expression if the store happens in an
  ///         assignment.
  ///  @param LocationE The location expression that is stored to.
  ///  @param state The current simulation state
  ///  @param location The location to store the value
  ///  @param Val The value to be stored
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::evalStore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2289,
   FQN="clang::ento::ExprEngine::evalStore", NM="_ZN5clang4ento10ExprEngine9evalStoreERNS0_15ExplodedNodeSetEPKNS_4ExprES6_PNS0_12ExplodedNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValESE_PKNS_15ProgramPointTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine9evalStoreERNS0_15ExplodedNodeSetEPKNS_4ExprES6_PNS0_12ExplodedNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValESE_PKNS_15ProgramPointTagE")
  //</editor-fold>
  public void evalStore(final ExplodedNodeSet /*&*/ Dst, /*const*/ Expr /*P*/ AssignE, 
           /*const*/ Expr /*P*/ LocationE, 
           ExplodedNode /*P*/ Pred, 
           IntrusiveRefCntPtr</*const*/ ProgramState> state, SVal location, SVal Val) {
    evalStore(Dst, AssignE, 
           LocationE, 
           Pred, 
           state, location, Val, 
           (/*const*/ ProgramPointTag /*P*/ )null);
  }
  public void evalStore(final ExplodedNodeSet /*&*/ Dst, /*const*/ Expr /*P*/ AssignE, 
           /*const*/ Expr /*P*/ LocationE, 
           ExplodedNode /*P*/ Pred, 
           IntrusiveRefCntPtr</*const*/ ProgramState> state, SVal location, SVal Val, 
           /*const*/ ProgramPointTag /*P*/ tag/*= null*/) {
    ExplodedNodeSet Tmp = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Proceed with the store.  We use AssignE as the anchor for the PostStore
      // ProgramPoint if it is non-NULL, and LocationE otherwise.
      /*const*/ Expr /*P*/ StoreE = (AssignE != null) ? AssignE : LocationE;
      
      // Evaluate the location (checks for bad dereferences).
      Tmp/*J*/= new ExplodedNodeSet();
      evalLocation(Tmp, AssignE, LocationE, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(location), tag, false); $c$.clean();
      if (Tmp.empty()) {
        return;
      }
      if (location.isUndef$SVal()) {
        return;
      }
      
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > NI = Tmp.begin(), NE = Tmp.end(); NI.$noteq(NE); NI.$preInc())  {
        evalBind(Dst, StoreE, NI.$star(), new SVal(location), new SVal(Val), false);
      }
    } finally {
      if (Tmp != null) { Tmp.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// \brief Create a new state in which the call return value is binded to the
  /// call origin expression.
  
  /// \brief Create a new state in which the call return value is binded to the
  /// call origin expression.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::bindReturnValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 523,
   FQN="clang::ento::ExprEngine::bindReturnValue", NM="_ZN5clang4ento10ExprEngine15bindReturnValueERKNS0_9CallEventEPKNS_15LocationContextEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang4ento10ExprEngine15bindReturnValueERKNS0_9CallEventEPKNS_15LocationContextEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> bindReturnValue(final /*const*/ CallEvent /*&*/ Call, 
                 /*const*/ LocationContext /*P*/ LCtx, 
                 IntrusiveRefCntPtr</*const*/ ProgramState> State) {
    /*const*/ Expr /*P*/ E = Call.getOriginExpr();
    if (!(E != null)) {
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
    }
    {
      
      // Some method families have known return values.
      /*const*/ ObjCMethodCall /*P*/ Msg = dyn_cast_ObjCMethodCall($AddrOf(Call));
      if ((Msg != null)) {
        switch (Msg.getMethodFamily()) {
         default:
          break;
         case OMF_autorelease:
         case OMF_retain:
         case OMF_self:
          {
            // These methods return their receivers.
            return State.$arrow().BindExpr(E, LCtx, Msg.getReceiverSVal());
          }
        }
      } else {
        /*const*/ CXXConstructorCall /*P*/ C = dyn_cast_CXXConstructorCall($AddrOf(Call));
        if ((C != null)) {
          SVal ThisV = C.getCXXThisVal();
          
          // If the constructed object is a temporary prvalue, get its bindings.
          if (ExprEngineCallAndReturnStatics.isTemporaryPRValue(cast_CXXConstructExpr(E), new SVal(ThisV))) {
            ThisV.$assignMove(State.$arrow().getSVal(ThisV.castAs(Loc.class)));
          }
          
          return State.$arrow().BindExpr(E, LCtx, new SVal(ThisV));
        }
      }
    }
    
    // Conjure a symbol if the return value is unknown.
    QualType ResultTy = Call.getResultType();
    final SValBuilder /*&*/ SVB = getSValBuilder();
    /*uint*/int Count = currBldrCtx.blockCount();
    SVal R = new SVal(JD$Move.INSTANCE, SVB.conjureSymbolVal((/*const*/Object/*void P*/ )null, E, LCtx, new QualType(ResultTy), Count));
    return State.$arrow().BindExpr(E, LCtx, new SVal(R));
  }


  
  /// Evaluate a call, running pre- and post-call checks and allowing checkers
  /// to be responsible for handling the evaluation of the call itself.
  
  /// Evaluate a call, running pre- and post-call checks and allowing checkers
  /// to be responsible for handling the evaluation of the call itself.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::evalCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 498,
   FQN="clang::ento::ExprEngine::evalCall", NM="_ZN5clang4ento10ExprEngine8evalCallERNS0_15ExplodedNodeSetEPNS0_12ExplodedNodeERKNS0_9CallEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang4ento10ExprEngine8evalCallERNS0_15ExplodedNodeSetEPNS0_12ExplodedNodeERKNS0_9CallEventE")
  //</editor-fold>
  public void evalCall(final ExplodedNodeSet /*&*/ Dst, ExplodedNode /*P*/ Pred, 
          final /*const*/ CallEvent /*&*/ Call) {
    ExplodedNodeSet dstPreVisit = null;
    ExplodedNodeSet dstCallEvaluated = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // WARNING: At this time, the state attached to 'Call' may be older than the
      // state in 'Pred'. This is a minor optimization since CheckerManager will
      // use an updated CallEvent instance when calling checkers, but if 'Call' is
      // ever used directly in this function all callers should be updated to pass
      // the most recent state. (It is probably not worth doing the work here since
      // for some callers this will not be necessary.)
      
      // Run any pre-call checks using the generic call interface.
      dstPreVisit/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForPreCall(dstPreVisit, $c$.track(new ExplodedNodeSet(Pred)), Call, /*Deref*/this); $c$.clean();
      
      // Actually evaluate the function call.  We try each of the checkers
      // to see if the can evaluate the function call, and get a callback at
      // defaultEvalCall if all of them fail.
      dstCallEvaluated/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForEvalCall(dstCallEvaluated, dstPreVisit, 
          Call, /*Deref*/this);
      
      // Finally, run any post-call checks.
      getCheckerManager().runCheckersForPostCall(Dst, dstCallEvaluated, 
          Call, /*Deref*/this);
    } finally {
      if (dstCallEvaluated != null) { dstCallEvaluated.$destroy(); }
      if (dstPreVisit != null) { dstPreVisit.$destroy(); }
      $c$.$destroy();
    }
  }


  
  /// \brief Default implementation of call evaluation.
  
  /// \brief Default implementation of call evaluation.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::defaultEvalCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 890,
   FQN="clang::ento::ExprEngine::defaultEvalCall", NM="_ZN5clang4ento10ExprEngine15defaultEvalCallERNS0_11NodeBuilderEPNS0_12ExplodedNodeERKNS0_9CallEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang4ento10ExprEngine15defaultEvalCallERNS0_11NodeBuilderEPNS0_12ExplodedNodeERKNS0_9CallEventE")
  //</editor-fold>
  public void defaultEvalCall(final NodeBuilder /*&*/ Bldr, ExplodedNode /*P*/ Pred, 
                 final /*const*/ CallEvent /*&*/ CallTemplate) {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    CallEventRef<CallEvent> Call = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> InlinedFailedState = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Make sure we have the most recent state attached to the call.
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      Call = $c$.clean(CallTemplate.cloneWithState($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
      
      // Special-case trivial assignment operators.
      if (ExprEngineCallAndReturnStatics.isTrivialObjectAssignment(Call.$star())) {
        performTrivialCopy(Bldr, Pred, Call.$star());
        return;
      }
      
      // Try to inline the call.
      // The origin expression here is just used as a kind of checksum;
      // this should still be safe even for CallEvents that don't come from exprs.
      /*const*/ Expr /*P*/ E = Call.$arrow().getOriginExpr();
      
      InlinedFailedState = $c$.clean(ExprEngineCallAndReturnStatics.getInlineFailedState($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), E));
      if (InlinedFailedState.$bool()) {
        // If we already tried once and failed, make sure we don't retry later.
        $c$.clean(State.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(InlinedFailedState))));
      } else {
        RuntimeDefinition RD = Call.$arrow().getRuntimeDefinition();
        /*const*/ Decl /*P*/ D = RD.getDecl();
        if (shouldInlineCall(Call.$star(), D, Pred)) {
          if (RD.mayHaveOtherDefinitions()) {
            final AnalyzerOptions /*&*/ Options = getAnalysisManager().options;
            
            // Explore with and without inlining the call.
            if (Options.getIPAMode() == IPAKind.IPAK_DynamicDispatchBifurcate) {
              BifurcateCall(RD.getDispatchRegion(), Call.$star(), D, Bldr, Pred);
              return;
            }
            
            // Don't inline if we're not in any dynamic dispatch mode.
            if (Options.getIPAMode() != IPAKind.IPAK_DynamicDispatch) {
              conservativeEvalCall(Call.$star(), Bldr, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))); $c$.clean();
              return;
            }
          }
          
          // We are not bifurcating and we do have a Decl, so just inline.
          if ($c$.clean(inlineCall(Call.$star(), D, Bldr, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))) {
            return;
          }
        }
      }
      
      // If we can't inline it, handle the return value and invalidate the regions.
      conservativeEvalCall(Call.$star(), Bldr, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))); $c$.clean();
    } finally {
      if (InlinedFailedState != null) { InlinedFailedState.$destroy(); }
      if (Call != null) { Call.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }


/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::evalLoadCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2351,
   FQN="clang::ento::ExprEngine::evalLoadCommon", NM="_ZN5clang4ento10ExprEngine14evalLoadCommonERNS0_15ExplodedNodeSetEPKNS_4ExprES6_PNS0_12ExplodedNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValEPKNS_15ProgramPointTagENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine14evalLoadCommonERNS0_15ExplodedNodeSetEPKNS_4ExprES6_PNS0_12ExplodedNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValEPKNS_15ProgramPointTagENS_8QualTypeE")
  //</editor-fold>
  private void evalLoadCommon(final ExplodedNodeSet /*&*/ Dst, 
                /*const*/ Expr /*P*/ NodeEx, 
                /*const*/ Expr /*P*/ BoundEx, 
                ExplodedNode /*P*/ Pred, 
                IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                SVal location, 
                /*const*/ ProgramPointTag /*P*/ tag, 
                QualType LoadTy) {
    ExplodedNodeSet Tmp = null;
    StmtNodeBuilder Bldr = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert Native.$bool(NodeEx);
      assert Native.$bool(BoundEx);
      // Evaluate the location (checks for bad dereferences).
      Tmp/*J*/= new ExplodedNodeSet();
      evalLocation(Tmp, NodeEx, BoundEx, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(location), tag, true); $c$.clean();
      if (Tmp.empty()) {
        return;
      }
      
      Bldr/*J*/= new StmtNodeBuilder(Tmp, Dst, $Deref(currBldrCtx));
      if (location.isUndef$SVal()) {
        return;
      }
      
      // Proceed with the load.
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > NI = Tmp.begin(), NE = Tmp.end(); NI.$noteq(NE); NI.$preInc()) {
        $c$.clean(state.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>((NI.$star()).getState()))));
        /*const*/ LocationContext /*P*/ LCtx = (NI.$star()).getLocationContext();
        
        SVal V = new SVal(JD$Move.INSTANCE, new UnknownVal());
        if (location.isValid$SVal()) {
          if (LoadTy.isNull()) {
            LoadTy.$assignMove(BoundEx.getType());
          }
          V.$assignMove(state.$arrow().getSVal(location.castAs(Loc.class), new QualType(LoadTy)));
        }
        
        $c$.clean(Bldr.generateNode(NodeEx, NI.$star(), $c$.track(state.$arrow().BindExpr(BoundEx, LCtx, new SVal(V))), tag, 
            ProgramPoint.Kind.PostLoadKind));
      }
    } finally {
      if (Bldr != null) { Bldr.$destroy(); }
      if (Tmp != null) { Tmp.$destroy(); }
      $c$.$destroy();
    }
  }

  
  // FIXME: 'tag' should be removed, and a LocationContext should be used
  // instead.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::evalLocation">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2388,
   FQN="clang::ento::ExprEngine::evalLocation", NM="_ZN5clang4ento10ExprEngine12evalLocationERNS0_15ExplodedNodeSetEPKNS_4StmtES6_PNS0_12ExplodedNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValEPKNS_15ProgramPointTagEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine12evalLocationERNS0_15ExplodedNodeSetEPKNS_4StmtES6_PNS0_12ExplodedNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValEPKNS_15ProgramPointTagEb")
  //</editor-fold>
  private void evalLocation(final ExplodedNodeSet /*&*/ Dst, 
              /*const*/ Stmt /*P*/ NodeEx, 
              /*const*/ Stmt /*P*/ BoundEx, 
              ExplodedNode /*P*/ Pred, 
              IntrusiveRefCntPtr</*const*/ ProgramState> state, 
              SVal location, 
              /*const*/ ProgramPointTag /*P*/ tag, 
              boolean isLoad) {
    StmtNodeBuilder BldrTop = null;
    ExplodedNodeSet Src = null;
    StmtNodeBuilder Bldr = null;
    ExplodedNodeSet Tmp = null;
    try {
      BldrTop/*J*/= new StmtNodeBuilder(Pred, Dst, $Deref(currBldrCtx));
      // Early checks for performance reason.
      if (location.isUnknown$SVal()) {
        return;
      }
      
      Src/*J*/= new ExplodedNodeSet();
      BldrTop.takeNodes(Pred);
      Bldr/*J*/= new StmtNodeBuilder(Pred, Src, $Deref(currBldrCtx));
      if ($noteq_IntrusiveRefCntPtr(Pred.getState(), state)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Associate this new state with an ExplodedNode.
          // FIXME: If I pass null tag, the graph is incorrect, e.g for
          //   int *p;
          //   p = 0;
          //   *p = 0xDEADBEEF;
          // "p = 0" is not noted as "Null pointer value stored to 'p'" but
          // instead "int *p" is noted as
          // "Variable 'p' initialized to a null pointer value"
          final/*static*/ SimpleProgramPointTag tag$1 = evalLocation$$.tag$1;
          $c$.clean(Bldr.generateNode(NodeEx, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), $AddrOf(tag$1)));
        } finally {
          $c$.$destroy();
        }
      }
      Tmp/*J*/= new ExplodedNodeSet();
      getCheckerManager().runCheckersForLocation(Tmp, Src, new SVal(location), isLoad, 
          NodeEx, BoundEx, /*Deref*/this);
      BldrTop.addNodes(Tmp);
    } finally {
      if (Tmp != null) { Tmp.$destroy(); }
      if (Bldr != null) { Bldr.$destroy(); }
      if (Src != null) { Src.$destroy(); }
      if (BldrTop != null) { BldrTop.$destroy(); }
    }
  }
  private static final class evalLocation$$ {
    static final/*static*/ SimpleProgramPointTag tag$1/*J*/= new SimpleProgramPointTag(new StringRef(TagProviderName), new StringRef(/*KEEP_STR*/"Location"));
  }

  
  /// Count the stack depth and determine if the call is recursive.
  
  /// Count the stack depth and determine if the call is recursive.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::examineStackFrames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 359,
   FQN="clang::ento::ExprEngine::examineStackFrames", NM="_ZN5clang4ento10ExprEngine18examineStackFramesEPKNS_4DeclEPKNS_15LocationContextERbRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang4ento10ExprEngine18examineStackFramesEPKNS_4DeclEPKNS_15LocationContextERbRj")
  //</editor-fold>
  private void examineStackFrames(/*const*/ Decl /*P*/ D, /*const*/ LocationContext /*P*/ LCtx, 
                    final bool$ref/*bool &*/ IsRecursive, final uint$ref/*uint &*/ StackDepth) {
    IsRecursive.$set(false);
    StackDepth.$set(0);
    while ((LCtx != null)) {
      {
        /*const*/ StackFrameContext /*P*/ SFC = dyn_cast_StackFrameContext(LCtx);
        if ((SFC != null)) {
          /*const*/ Decl /*P*/ DI = SFC.getDecl();
          
          // Mark recursive (and mutually recursive) functions and always count
          // them when measuring the stack depth.
          if (DI == D) {
            IsRecursive.$set(true);
            StackDepth.$set$preInc();
            LCtx = LCtx.getParent();
            continue;
          }
          
          // Do not count the small functions when determining the stack depth.
          AnalysisDeclContext /*P*/ CalleeADC = AMgr.getAnalysisDeclContext(DI);
          /*const*/ CFG /*P*/ CalleeCFG = CalleeADC.getCFG();
          if ($greater_uint(CalleeCFG.getNumBlockIDs(), AMgr.options.getAlwaysInlineSize())) {
            StackDepth.$set$preInc();
          }
        }
      }
      LCtx = LCtx.getParent();
    }
  }


  
  /// Checks our policies and decides weither the given call should be inlined.
  
  /// Checks our policies and decides weither the given call should be inlined.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::shouldInlineCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 789,
   FQN="clang::ento::ExprEngine::shouldInlineCall", NM="_ZN5clang4ento10ExprEngine16shouldInlineCallERKNS0_9CallEventEPKNS_4DeclEPKNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang4ento10ExprEngine16shouldInlineCallERKNS0_9CallEventEPKNS_4DeclEPKNS0_12ExplodedNodeE")
  //</editor-fold>
  private boolean shouldInlineCall(final /*const*/ CallEvent /*&*/ Call, /*const*/ Decl /*P*/ D, 
                  /*const*/ ExplodedNode /*P*/ Pred) {
    if (!(D != null)) {
      return false;
    }
    
    final AnalysisManager /*&*/ AMgr = getAnalysisManager();
    final AnalyzerOptions /*&*/ Opts = AMgr.options;
    final AnalysisDeclContextManager /*&*/ ADCMgr = AMgr.getAnalysisDeclContextManager();
    AnalysisDeclContext /*P*/ CalleeADC = ADCMgr.getContext(D);
    
    // Temporary object destructor processing is currently broken, so we never
    // inline them.
    // FIXME: Remove this once temp destructors are working.
    if (isa_CXXDestructorCall(Call)) {
      if (($Deref(currBldrCtx.getBlock())).$at(currStmtIdx).getAs(CFGTemporaryDtor.class).$bool()) {
        return false;
      }
    }
    
    // The auto-synthesized bodies are essential to inline as they are
    // usually small and commonly used. Note: we should do this check early on to
    // ensure we always inline these calls.
    if (CalleeADC.isBodyAutosynthesized()) {
      return true;
    }
    if (!AMgr.shouldInlineCall()) {
      return false;
    }
    
    // Check if this function has been marked as non-inlinable.
    OptionalBool MayInline = Engine.FunctionSummaries.mayInline(D);
    if (MayInline.hasValue()) {
      if (!MayInline.getValue()) {
        return false;
      }
    } else {
      // We haven't actually checked the static properties of this function yet.
      // Do that now, and record our decision in the function summaries.
      if (ExprEngineCallAndReturnStatics.mayInlineDecl(CalleeADC, Opts)) {
        Engine.FunctionSummaries.markMayInline(D);
      } else {
        Engine.FunctionSummaries.markShouldNotInline(D);
        return false;
      }
    }
    
    // Check if we should inline a call based on its kind.
    // FIXME: this checks both static and dynamic properties of the call, which
    // means we're redoing a bit of work that could be cached in the function
    // summary.
    CallInlinePolicy CIP = ExprEngineCallAndReturnStatics.mayInlineCallKind(Call, Pred, Opts);
    if (CIP != CallInlinePolicy.CIP_Allowed) {
      if (CIP == CallInlinePolicy.CIP_DisallowedAlways) {
        assert (!MayInline.hasValue() || MayInline.getValue());
        Engine.FunctionSummaries.markShouldNotInline(D);
      }
      return false;
    }
    
    /*const*/ CFG /*P*/ CalleeCFG = CalleeADC.getCFG();
    
    // Do not inline if recursive or we've reached max stack frame count.
    bool$ref IsRecursive = create_bool$ref(false);
    uint$ref StackDepth = create_uint$ref(0);
    examineStackFrames(D, Pred.getLocationContext(), IsRecursive, StackDepth);
    if (($greatereq_uint(StackDepth.$deref(), Opts.InlineMaxStackDepth))
       && (($greater_uint(CalleeCFG.getNumBlockIDs(), Opts.getAlwaysInlineSize()))
       || IsRecursive.$deref())) {
      return false;
    }
    
    // Do not inline large functions too many times.
    if (($greater_uint(Engine.FunctionSummaries.getNumTimesInlined(D)
      , Opts.getMaxTimesInlineLarge()))
       && $greatereq_uint(CalleeCFG.getNumBlockIDs()
      , Opts.getMinCFGSizeTreatFunctionsAsLarge())) {
      NumReachedInlineCountMax.$postInc(0);
      return false;
    }
    if (HowToInline == InliningModes.Inline_Minimal
       && ($greater_uint(CalleeCFG.getNumBlockIDs(), Opts.getAlwaysInlineSize())
       || IsRecursive.$deref())) {
      return false;
    }
    
    Engine.FunctionSummaries.bumpNumTimesInlined(D);
    
    return true;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::inlineCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 404,
   FQN="clang::ento::ExprEngine::inlineCall", NM="_ZN5clang4ento10ExprEngine10inlineCallERKNS0_9CallEventEPKNS_4DeclERNS0_11NodeBuilderEPNS0_12ExplodedNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang4ento10ExprEngine10inlineCallERKNS0_9CallEventEPKNS_4DeclERNS0_11NodeBuilderEPNS0_12ExplodedNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
  //</editor-fold>
  private boolean inlineCall(final /*const*/ CallEvent /*&*/ Call, /*const*/ Decl /*P*/ D, 
            final NodeBuilder /*&*/ Bldr, ExplodedNode /*P*/ Pred, 
            IntrusiveRefCntPtr</*const*/ ProgramState> State) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert Native.$bool(D);
      
      /*const*/ LocationContext /*P*/ CurLC = Pred.getLocationContext();
      /*const*/ StackFrameContext /*P*/ CallerSFC = CurLC.getCurrentStackFrame();
      /*const*/ LocationContext /*P*/ ParentOfCallee = CallerSFC;
      if (Call.getKind() == CallEventKind.CE_Block
         && !cast_BlockCall(Call).isConversionFromLambda()) {
        /*const*/ BlockDataRegion /*P*/ BR = cast_BlockCall(Call).getBlockRegion();
        assert ((BR != null)) : "If we have the block definition we should have its region";
        AnalysisDeclContext /*P*/ BlockCtx = AMgr.getAnalysisDeclContext(D);
        ParentOfCallee = BlockCtx.getBlockInvocationContext(CallerSFC, 
            cast_BlockDecl(D), 
            BR);
      }
      
      // This may be NULL, but that's fine.
      /*const*/ Expr /*P*/ CallE = Call.getOriginExpr();
      
      // Construct a new stack frame for the callee.
      AnalysisDeclContext /*P*/ CalleeADC = AMgr.getAnalysisDeclContext(D);
      /*const*/ StackFrameContext /*P*/ CalleeSFC = CalleeADC.getStackFrame(ParentOfCallee, CallE, 
          currBldrCtx.getBlock(), 
          currStmtIdx);
      
      CallEnter Loc/*J*/= new CallEnter(CallE, CalleeSFC, CurLC);
      
      // Construct a new state which contains the mapping from actual to
      // formal arguments.
      $c$.clean(State.$assign($c$.track(State.$arrow().enterStackFrame(Call, CalleeSFC))));
      
      bool$ptr isNew = create_bool$ptr();
      {
        ExplodedNode /*P*/ N = $c$.clean(G.getNode(Loc, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), false, $AddrOf(isNew)));
        if ((N != null)) {
          N.addPredecessor(Pred, G);
          if (isNew.$star()) {
            Engine.getWorkList().enqueue(N);
          }
        }
      }
      
      // If we decided to inline the call, the successor has been manually
      // added onto the work list so remove it from the node builder.
      Bldr.takeNodes(Pred);
      
      NumInlinedCalls.$postInc(0);
      
      // Mark the decl as visited.
      if ((VisitedCallees != null)) {
        VisitedCallees.insert(D);
      }
      
      return true;
    } finally {
      $c$.$destroy();
    }
  }


  
  /// \brief Conservatively evaluate call by invalidating regions and binding
  /// a conjured return value.
  
  /// \brief Conservatively evaluate call by invalidating regions and binding
  /// a conjured return value.
  
  // Conservatively evaluate call by invalidating regions and binding
  // a conjured return value.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::conservativeEvalCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 562,
   FQN="clang::ento::ExprEngine::conservativeEvalCall", NM="_ZN5clang4ento10ExprEngine20conservativeEvalCallERKNS0_9CallEventERNS0_11NodeBuilderEPNS0_12ExplodedNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang4ento10ExprEngine20conservativeEvalCallERKNS0_9CallEventERNS0_11NodeBuilderEPNS0_12ExplodedNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
  //</editor-fold>
  private void conservativeEvalCall(final /*const*/ CallEvent /*&*/ Call, final NodeBuilder /*&*/ Bldr, 
                      ExplodedNode /*P*/ Pred, 
                      IntrusiveRefCntPtr</*const*/ ProgramState> State) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(State.$assign($c$.track(Call.invalidateRegions(currBldrCtx.blockCount(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
      $c$.clean(State.$assign($c$.track(bindReturnValue(Call, Pred.getLocationContext(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
      
      // And make the result node.
      $c$.clean(Bldr.generateNode(Call.getProgramPoint(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Pred));
    } finally {
      $c$.$destroy();
    }
  }


  
  /// \brief Either inline or process the call conservatively (or both), based
  /// on DynamicDispatchBifurcation data.
  
  /// \brief Either inline or process the call conservatively (or both), based
  /// on DynamicDispatchBifurcation data.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::BifurcateCall">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 941,
   FQN="clang::ento::ExprEngine::BifurcateCall", NM="_ZN5clang4ento10ExprEngine13BifurcateCallEPKNS0_9MemRegionERKNS0_9CallEventEPKNS_4DeclERNS0_11NodeBuilderEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang4ento10ExprEngine13BifurcateCallEPKNS0_9MemRegionERKNS0_9CallEventEPKNS_4DeclERNS0_11NodeBuilderEPNS0_12ExplodedNodeE")
  //</editor-fold>
  private void BifurcateCall(/*const*/ MemRegion /*P*/ BifurReg, 
               final /*const*/ CallEvent /*&*/ Call, /*const*/ Decl /*P*/ D, 
               final NodeBuilder /*&*/ Bldr, ExplodedNode /*P*/ Pred) {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> IState = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> NoIState = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert Native.$bool(BifurReg);
      BifurReg = BifurReg.StripCasts();
      
      // Check if we've performed the split already - note, we only want
      // to split the path once per memory region.
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      /*const*/uint$ptr/*uint P*/ BState = State.$arrow().get(ProgramStateTraitDynamicDispatchBifurcationMap.$Instance, BifurReg);
      if (/*JAVA*/(BState != null)) {
        // If we are on "inline path", keep inlining if possible.
        if (BState.$star() == DynamicDispatchMode.DynamicDispatchModeInlined.getValue()) {
          if ($c$.clean(inlineCall(Call, D, Bldr, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))) {
            return;
          }
        }
        // If inline failed, or we are on the path where we assume we
        // don't have enough info about the receiver to inline, conjure the
        // return value and invalidate the regions.
        conservativeEvalCall(Call, Bldr, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))); $c$.clean();
        return;
      }
      
      // If we got here, this is the first time we process a message to this
      // region, so split the path.
      IState = State.$arrow().set(ProgramStateTraitDynamicDispatchBifurcationMap.$Instance, BifurReg, 
          DynamicDispatchMode.DynamicDispatchModeInlined.getValue());
      $c$.clean(inlineCall(Call, D, Bldr, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(IState))));
      
      NoIState = State.$arrow().set(ProgramStateTraitDynamicDispatchBifurcationMap.$Instance, BifurReg, 
          DynamicDispatchMode.DynamicDispatchModeConservative.getValue());
      conservativeEvalCall(Call, Bldr, Pred, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(NoIState))); $c$.clean();
      
      NumOfDynamicDispatchPathSplits.$postInc(0);
    } finally {
      if (NoIState != null) { NoIState.$destroy(); }
      if (IState != null) { IState.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::replayWithoutInlining">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 1355,
   FQN="clang::ento::ExprEngine::replayWithoutInlining", NM="_ZN5clang4ento10ExprEngine21replayWithoutInliningEPNS0_12ExplodedNodeEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine21replayWithoutInliningEPNS0_12ExplodedNodeEPKNS_15LocationContextE")
  //</editor-fold>
  private boolean replayWithoutInlining(ExplodedNode /*P*/ N, 
                       /*const*/ LocationContext /*P*/ CalleeLC) {
    IntrusiveRefCntPtr</*const*/ ProgramState> NewNodeState = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ StackFrameContext /*P*/ CalleeSF = CalleeLC.getCurrentStackFrame();
      /*const*/ StackFrameContext /*P*/ CallerSF = CalleeSF.getParent().getCurrentStackFrame();
      assert ((CalleeSF != null) && (CallerSF != null));
      ExplodedNode /*P*/ BeforeProcessingCall = null;
      /*const*/ Stmt /*P*/ CE = CalleeSF.getCallSite();
      
      // Find the first node before we started processing the call expression.
      while ((N != null)) {
        ProgramPoint L = N.getLocation();
        BeforeProcessingCall = N;
        N = N.pred_empty() ? null : (N.pred_begin()).$star();
        
        // Skip the nodes corresponding to the inlined code.
        if (L.getLocationContext().getCurrentStackFrame() != CallerSF) {
          continue;
        }
        // We reached the caller. Find the node right before we started
        // processing the call.
        if (L.isPurgeKind()) {
          continue;
        }
        if (L.getAs(PreImplicitCall.class).$bool()) {
          continue;
        }
        if (L.getAs(CallEnter.class).$bool()) {
          continue;
        }
        {
          Optional<StmtPoint> SP = L.getAs(StmtPoint.class);
          if (SP.$bool()) {
            if (SP.$arrow().getStmt() == CE) {
              continue;
            }
          }
        }
        break;
      }
      if (!(BeforeProcessingCall != null)) {
        return false;
      }
      
      // TODO: Clean up the unneeded nodes.
      
      // Build an Epsilon node from which we will restart the analyzes.
      // Note that CE is permitted to be NULL!
      ProgramPoint NewNodeLoc = new ProgramPoint(JD$Move.INSTANCE, new EpsilonPoint(BeforeProcessingCall.getLocationContext(), CE));
      // Add the special flag to GDM to signal retrying with no inlining.
      // Note, changing the state ensures that we are not going to cache out.
      NewNodeState = new IntrusiveRefCntPtr</*const*/ ProgramState>(BeforeProcessingCall.getState());
      $c$.clean(NewNodeState.$assign(
          $c$.track(NewNodeState.$arrow().set(ProgramStateTraitReplayWithoutInlining.$Instance, ((/*const_cast*/Stmt /*P*/ )(CE))))
      ));
      
      // Make the new node a successor of BeforeProcessingCall.
      bool$ptr IsNew = create_bool$ptr(false);
      ExplodedNode /*P*/ NewNode = $c$.clean(G.getNode(NewNodeLoc, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(NewNodeState)), false, $AddrOf(IsNew)));
      // We cached out at this point. Caching out is common due to us backtracking
      // from the inlined function, which might spawn several paths.
      if (!IsNew.$star()) {
        return true;
      }
      
      NewNode.addPredecessor(BeforeProcessingCall, G);
      
      // Add the new node to the work list.
      Engine.enqueueStmtNode(NewNode, CalleeSF.getCallSiteBlock(), 
          CalleeSF.getIndex());
      NumTimesRetriedWithoutInlining.$postInc(0);
      return true;
    } finally {
      if (NewNodeState != null) { NewNodeState.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Models a trivial copy or move constructor or trivial assignment operator
  /// call with a simple bind.
  
  /// Models a trivial copy or move constructor or trivial assignment operator
  /// call with a simple bind.
  
  // FIXME: This is the sort of code that should eventually live in a Core
  // checker rather than as a special case in ExprEngine.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::performTrivialCopy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp", line = 39,
   FQN="clang::ento::ExprEngine::performTrivialCopy", NM="_ZN5clang4ento10ExprEngine18performTrivialCopyERNS0_11NodeBuilderEPNS0_12ExplodedNodeERKNS0_9CallEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp -nm=_ZN5clang4ento10ExprEngine18performTrivialCopyERNS0_11NodeBuilderEPNS0_12ExplodedNodeERKNS0_9CallEventE")
  //</editor-fold>
  private void performTrivialCopy(final NodeBuilder /*&*/ Bldr, ExplodedNode /*P*/ Pred, 
                    final /*const*/ CallEvent /*&*/ Call) {
    ExplodedNodeSet Dst = null;
    try {
      SVal ThisVal/*J*/= new SVal();
      boolean AlwaysReturnsLValue;
      {
        /*const*/ CXXConstructorCall /*P*/ Ctor = dyn_cast_CXXConstructorCall($AddrOf(Call));
        if ((Ctor != null)) {
          assert (Ctor.getDecl().isTrivial());
          assert (Ctor.getDecl().isCopyOrMoveConstructor());
          ThisVal.$assignMove(Ctor.getCXXThisVal());
          AlwaysReturnsLValue = false;
        } else {
          assert (cast_CXXMethodDecl(Call.getDecl()).isTrivial());
          assert (cast_CXXMethodDecl(Call.getDecl()).getOverloadedOperator() == OverloadedOperatorKind.OO_Equal);
          ThisVal.$assignMove(cast_CXXInstanceCall(Call).getCXXThisVal());
          AlwaysReturnsLValue = true;
        }
      }
      
      /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
      
      Dst/*J*/= new ExplodedNodeSet();
      Bldr.takeNodes(Pred);
      
      SVal V = Call.getArgSVal(0);
      {
        
        // If the value being copied is not unknown, load from its location to get
        // an aggregate rvalue.
        Optional<Loc> L = V.getAs(Loc.class);
        if (L.$bool()) {
          V.$assignMove(Pred.getState().$arrow().getSVal(new Loc(L.$star())));
        } else {
          assert (V.isUnknown$SVal());
        }
      }
      
      /*const*/ Expr /*P*/ CallExpr = Call.getOriginExpr();
      evalBind(Dst, CallExpr, Pred, new SVal(ThisVal), new SVal(V), true);
      
      org.clang.analysis.PostStmt PS/*J*/= new org.clang.analysis.PostStmt(CallExpr, LCtx);
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = Dst.begin(), E = Dst.end();
           I.$noteq(E); I.$preInc()) {
        IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          State = new IntrusiveRefCntPtr</*const*/ ProgramState>((I.$star()).getState());
          if (AlwaysReturnsLValue) {
            $c$.clean(State.$assign($c$.track(State.$arrow().BindExpr(CallExpr, LCtx, new SVal(ThisVal)))));
          } else {
            $c$.clean(State.$assign($c$.track(bindReturnValue(Call, LCtx, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))));
          }
          $c$.clean(Bldr.generateNode(PS, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), I.$star()));
        } finally {
          if (State != null) { State.$destroy(); }
          $c$.$destroy();
        }
      }
    } finally {
      if (Dst != null) { Dst.$destroy(); }
    }
  }


  
  /// If the value of the given expression is a NonLoc, copy it into a new
  /// temporary object region, and replace the value of the expression with
  /// that.
  ///
  /// If \p ResultE is provided, the new region will be bound to this expression
  /// instead of \p E.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::createTemporaryRegionIfNeeded">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 183,
   FQN="clang::ento::ExprEngine::createTemporaryRegionIfNeeded", NM="_ZN5clang4ento10ExprEngine29createTemporaryRegionIfNeededEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextEPKNS_4ExprESC_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento10ExprEngine29createTemporaryRegionIfNeededEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextEPKNS_4ExprESC_")
  //</editor-fold>
  private IntrusiveRefCntPtr</*const*/ ProgramState> createTemporaryRegionIfNeeded(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                               /*const*/ LocationContext /*P*/ LC, 
                               /*const*/ Expr /*P*/ Ex) {
    return createTemporaryRegionIfNeeded(State, 
                               LC, 
                               Ex, 
                               (/*const*/ Expr /*P*/ )null);
  }
  private IntrusiveRefCntPtr</*const*/ ProgramState> createTemporaryRegionIfNeeded(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                               /*const*/ LocationContext /*P*/ LC, 
                               /*const*/ Expr /*P*/ Ex, 
                               /*const*/ Expr /*P*/ Result/*= null*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SVal V = State.$arrow().getSVal(Ex, LC);
      if (!(Result != null)) {
        // If we don't have an explicit result expression, we're in "if needed"
        // mode. Only create a region if the current value is a NonLoc.
        if (!V.getAs(NonLoc.class).$bool()) {
          return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
        }
        Result = Ex;
      } else {
        // We need to create a region no matter what. For sanity, make sure we don't
        // try to stuff a Loc into a non-pointer temporary region.
        assert (!V.getAs(Loc.class).$bool() || Loc.isLocType(Result.getType()) || Result.getType().$arrow().isMemberPointerType());
      }
      
      final ProgramStateManager /*&*/ StateMgr = State.$arrow().getStateManager();
      final MemRegionManager /*&*/ MRMgr = StateMgr.getRegionManager();
      final StoreManager /*&*/ StoreMgr = StateMgr.getStoreManager();
      
      // We need to be careful about treating a derived type's value as
      // bindings for a base type. Unless we're creating a temporary pointer region,
      // start by stripping and recording base casts.
      SmallVector</*const*/ CastExpr /*P*/ > Casts/*J*/= new SmallVector</*const*/ CastExpr /*P*/ >(4, (/*const*/ CastExpr /*P*/ )null);
      /*const*/ Expr /*P*/ Inner = Ex.IgnoreParens$Const();
      if (!Loc.isLocType(Result.getType())) {
        {
          /*const*/ CastExpr /*P*/ CE;
          while (((/*P*/ CE = dyn_cast_CastExpr(Inner)) != null)) {
            if (CE.getCastKind() == CastKind.CK_DerivedToBase
               || CE.getCastKind() == CastKind.CK_UncheckedDerivedToBase) {
              Casts.push_back(CE);
            } else if (CE.getCastKind() != CastKind.CK_NoOp) {
              break;
            }
            
            Inner = CE.getSubExpr$Const().IgnoreParens$Const();
          }
        }
      }
      
      // Create a temporary object region for the inner expression (which may have
      // a more derived type) and bind the value into it.
      /*const*/ TypedValueRegion /*P*/ TR = null;
      {
        /*const*/ MaterializeTemporaryExpr /*P*/ MT = dyn_cast_MaterializeTemporaryExpr(Result);
        if ((MT != null)) {
          StorageDuration SD = MT.getStorageDuration();
          // If this object is bound to a reference with static storage duration, we
          // put it in a different region to prevent "address leakage" warnings.
          if (SD == StorageDuration.SD_Static || SD == StorageDuration.SD_Thread) {
            TR = MRMgr.getCXXStaticTempObjectRegion(Inner);
          }
        }
      }
      if (!(TR != null)) {
        TR = MRMgr.getCXXTempObjectRegion(Inner, LC);
      }
      
      SVal Reg = new SVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(TR));
      if (V.isUnknown$SVal()) {
        V.$assignMove(getSValBuilder().conjureSymbolVal(Result, LC, TR.getValueType(), 
                currBldrCtx.blockCount()));
      }
      $c$.clean(State.$assign($c$.track(State.$arrow().bindLoc(new SVal(Reg), new SVal(V)))));
      
      // Re-apply the casts (from innermost to outermost) for type sanity.
      for (std.reverse_iterator</*const*/ CastExpr /*P*/ > I = Casts.rbegin(), 
          E = Casts.rend();
           $noteq_reverse_iterator$C(I, E); I.$preInc()) {
        Reg.$assignMove(StoreMgr.evalDerivedToBase(new SVal(Reg), I.$star()));
      }
      
      $c$.clean(State.$assign($c$.track(State.$arrow().BindExpr(Result, LC, new SVal(Reg)))));
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
    } finally {
      $c$.$destroy();
    }
  }

  
  /// For a DeclStmt or CXXInitCtorInitializer, walk backward in the current CFG
  /// block to find the constructor expression that directly constructed into
  /// the storage for this statement. Returns null if the constructor for this
  /// statement created a temporary object region rather than directly
  /// constructing into an existing region.
  
  /// For a DeclStmt or CXXInitCtorInitializer, walk backward in the current CFG
  /// block to find the constructor expression that directly constructed into
  /// the storage for this statement. Returns null if the constructor for this
  /// statement created a temporary object region rather than directly
  /// constructing into an existing region.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::findDirectConstructorForCurrentCFGElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp", line = 203,
   FQN="clang::ento::ExprEngine::findDirectConstructorForCurrentCFGElement", NM="_ZN5clang4ento10ExprEngine41findDirectConstructorForCurrentCFGElementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp -nm=_ZN5clang4ento10ExprEngine41findDirectConstructorForCurrentCFGElementEv")
  //</editor-fold>
  private /*const*/ CXXConstructExpr /*P*/ findDirectConstructorForCurrentCFGElement() {
    // Go backward in the CFG to see if the previous element (ignoring
    // destructors) was a CXXConstructExpr. If so, that constructor
    // was constructed directly into an existing region.
    // This process is essentially the inverse of that performed in
    // findElementDirectlyInitializedByCurrentConstructor().
    if (currStmtIdx == 0) {
      return null;
    }
    
    /*const*/ CFGBlock /*P*/ B = getBuilderContext().getBlock();
    assert (ExprEngineCXXStatics.canHaveDirectConstructor(($Deref(B)).$at(currStmtIdx)));
    
    /*uint*/int PreviousStmtIdx = currStmtIdx - 1;
    CFGElement Previous = ($Deref(B)).$at(PreviousStmtIdx);
    while (Previous.getAs(CFGImplicitDtor.class).$bool() && $greater_uint(PreviousStmtIdx, 0)) {
      --PreviousStmtIdx;
      Previous.$assignMove(($Deref(B)).$at(PreviousStmtIdx));
    }
    {
      
      Optional<CFGStmt> PrevStmtElem = Previous.getAs(CFGStmt.class);
      if (PrevStmtElem.$bool()) {
        {
          /*const*/ CXXConstructExpr /*P*/ CtorExpr = dyn_cast_CXXConstructExpr(PrevStmtElem.$arrow().getStmt());
          if ((CtorExpr != null)) {
            return CtorExpr;
          }
        }
      }
    }
    
    return null;
  }


  
  /// For a CXXConstructExpr, walk forward in the current CFG block to find the
  /// CFGElement for the DeclStmt or CXXInitCtorInitializer for which is
  /// directly constructed by this constructor. Returns None if the current
  /// constructor expression did not directly construct into an existing
  /// region.
  
  /// For a CXXConstructExpr, walk forward in the current CFG block to find the
  /// CFGElement for the DeclStmt or CXXInitCtorInitializer for which is
  /// directly constructed by this constructor. Returns None if the current
  /// constructor expression did not directly construct into an existing
  /// region.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::findElementDirectlyInitializedByCurrentConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp", line = 177,
   FQN="clang::ento::ExprEngine::findElementDirectlyInitializedByCurrentConstructor", NM="_ZN5clang4ento10ExprEngine50findElementDirectlyInitializedByCurrentConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp -nm=_ZN5clang4ento10ExprEngine50findElementDirectlyInitializedByCurrentConstructorEv")
  //</editor-fold>
  private Optional<CFGElement> findElementDirectlyInitializedByCurrentConstructor() {
    final /*const*/ NodeBuilderContext /*&*/ CurrBldrCtx = getBuilderContext();
    // See if we're constructing an existing region by looking at the next
    // element in the CFG.
    /*const*/ CFGBlock /*P*/ B = CurrBldrCtx.getBlock();
    assert (isa_CXXConstructExpr((($Deref(B)).$at(currStmtIdx)).castAs(CFGStmt.class).getStmt()));
    /*uint*/int NextStmtIdx = currStmtIdx + 1;
    if ($greatereq_uint(NextStmtIdx, B.size())) {
      return new Optional<CFGElement>(None);
    }
    
    CFGElement Next = ($Deref(B)).$at(NextStmtIdx);
    
    // Is this a destructor? If so, we might be in the middle of an assignment
    // to a local or member: look ahead one more element to see what we find.
    while (Next.getAs(CFGImplicitDtor.class).$bool() && $less_uint(NextStmtIdx + 1, B.size())) {
      ++NextStmtIdx;
      Next.$assignMove(($Deref(B)).$at(NextStmtIdx));
    }
    if (ExprEngineCXXStatics.canHaveDirectConstructor(new CFGElement(Next))) {
      return new Optional<CFGElement>(JD$T$RR.INSTANCE, Next);
    }
    
    return new Optional<CFGElement>(None);
  }


  
  /// For a given constructor, look forward in the current CFG block to
  /// determine the region into which an object will be constructed by \p CE.
  /// Returns either a field or local variable region if the object will be
  /// directly constructed in an existing region or a temporary object region
  /// if not.
  
  /// For a given constructor, look forward in the current CFG block to
  /// determine the region into which an object will be constructed by \p CE.
  /// Returns either a field or local variable region if the object will be
  /// directly constructed in an existing region or a temporary object region
  /// if not.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExprEngine::getRegionForConstructedObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp", line = 106,
   FQN="clang::ento::ExprEngine::getRegionForConstructedObject", NM="_ZN5clang4ento10ExprEngine29getRegionForConstructedObjectEPKNS_16CXXConstructExprEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCXX.cpp -nm=_ZN5clang4ento10ExprEngine29getRegionForConstructedObjectEPKNS_16CXXConstructExprEPNS0_12ExplodedNodeE")
  //</editor-fold>
  private /*const*/ MemRegion /*P*/ getRegionForConstructedObject(/*const*/ CXXConstructExpr /*P*/ CE, 
                               ExplodedNode /*P*/ Pred) {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      /*const*/ LocationContext /*P*/ LCtx = Pred.getLocationContext();
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState());
      {

        // See if we're constructing an existing region by looking at the next
        // element in the CFG.
        Optional<CFGElement> Elem = findElementDirectlyInitializedByCurrentConstructor();
        if (Elem.$bool()) {
          {
            Optional<CFGStmt> StmtElem = Elem.$arrow().getAs(CFGStmt.class);
            if (StmtElem.$bool()) {
              /*const*/ DeclStmt /*P*/ DS = cast_DeclStmt(StmtElem.$arrow().getStmt());
              {
                /*const*/ VarDecl /*P*/ Var = dyn_cast_VarDecl(DS.getSingleDecl$Const());
                if ((Var != null)) {
                  if ((Var.getInit$Const() != null) && Var.getInit$Const().IgnoreImplicit$Const() == CE) {
                    JavaCleaner $c$ = $createJavaCleaner();
                    try {
                      SVal LValue = new SVal(JD$Move.INSTANCE, State.$arrow().getLValue(Var, LCtx));
                      QualType Ty = Var.getType();
                      $c$.clean(LValue.$assignMove(ExprEngineCXXStatics.makeZeroElementRegion($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), new SVal(LValue), Ty)));
                      return LValue.getAsRegion();
                    } finally {
                      $c$.$destroy();
                    }
                  }
                }
              }
            } else {
              Optional<CFGInitializer> InitElem = Elem.$arrow().getAs(CFGInitializer.class);
              if (InitElem.$bool()) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  /*const*/ CXXCtorInitializer /*P*/ Init = InitElem.$arrow().getInitializer();
                  assert (Init.isAnyMemberInitializer());
                  /*const*/ CXXMethodDecl /*P*/ CurCtor = cast_CXXMethodDecl(LCtx.getDecl());
                  Loc ThisPtr = new Loc(JD$Move.INSTANCE, getSValBuilder().getCXXThis(CurCtor, LCtx.getCurrentStackFrame()));
                  SVal ThisVal = State.$arrow().getSVal(new Loc(ThisPtr));

                  /*const*/ ValueDecl /*P*/ Field;
                  SVal FieldVal/*J*/= new SVal();
                  if (Init.isIndirectMemberInitializer()) {
                    Field = Init.getIndirectMember();
                    FieldVal.$assignMove(State.$arrow().getLValue(Init.getIndirectMember(), new SVal(ThisVal)));
                  } else {
                    Field = Init.getMember();
                    FieldVal.$assignMove(State.$arrow().getLValue(Init.getMember(), new SVal(ThisVal)));
                  }

                  QualType Ty = Field.getType();
                  $c$.clean(FieldVal.$assignMove(ExprEngineCXXStatics.makeZeroElementRegion($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), new SVal(FieldVal), Ty)));
                  return FieldVal.getAsRegion();
                } finally {
                  $c$.$destroy();
                }
              }
            }
          }
          // FIXME: This will eventually need to handle new-expressions as well.
          // Don't forget to update the pre-constructor initialization code in
          // ExprEngine::VisitCXXConstructExpr.
        }
      }
      // If we couldn't find an existing region to construct into, assume we're
      // constructing a temporary.
      final MemRegionManager /*&*/ MRMgr = getSValBuilder().getRegionManager();
      return MRMgr.getCXXTempObjectRegion(CE, LCtx);
    } finally {
     if (State != null) { State.$destroy(); }
    } 
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private final int$ref currStmtIdx$ref = new int$ref() {
    @Override
    public int $deref() {
      return currStmtIdx;
    }

    @Override
    public int $set(int value) {
      currStmtIdx = value;
      return currStmtIdx;
    }
  };  
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private final type$ref</*const*/ NodeBuilderContext /*P*/> currBldrCtx$ref = new type$ref</*const*/ NodeBuilderContext /*P*/>() {
    @Override
    public NodeBuilderContext $deref() {
      return currBldrCtx;
    }

    @Override
    public NodeBuilderContext $set(NodeBuilderContext value) {
      currBldrCtx = value;
      return currBldrCtx;
    }
  };
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "AMgr=" + "[AnalysisManager]" // NOI18N
              + ", AnalysisDeclContexts=" + "[AnalysisDeclContextManager]" // NOI18N
              + ", Engine=" + "[CoreEngine]" // NOI18N
              + ", G=" + G // NOI18N
              + ", StateMgr=" + "[ProgramStateManager]" // NOI18N
              + ", SymMgr=" + "[SymbolManager]" // NOI18N
              + ", svalBuilder=" + "[SValBuilder]" // NOI18N
              + ", currStmtIdx=" + currStmtIdx // NOI18N
              + ", currBldrCtx=" + "[NodeBuilderContext]" // NOI18N
              + ", ObjCNoRet=" + ObjCNoRet // NOI18N
              + ", ObjCGCEnabled=" + ObjCGCEnabled // NOI18N
              + ", BR=" + BR // NOI18N
              + ", VisitedCallees=" + "[DenseSet$Decl]" // NOI18N
              + ", HowToInline=" + HowToInline // NOI18N
              + super.toString(); // NOI18N
  }
}
