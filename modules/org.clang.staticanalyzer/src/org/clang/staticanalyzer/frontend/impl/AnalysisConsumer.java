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

package org.clang.staticanalyzer.frontend.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.lex.*;
import org.clang.basic.*;
import org.clang.frontend.staticanalyzer.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.impl.*;
import org.clang.staticanalyzer.frontend.ento.*;
import static org.clang.staticanalyzer.checkers.ento.EntoGlobals.*;
import org.clang.staticanalyzer.java.StaticAnalyzerFunctionPointers.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.analysis.analyses.*;
import org.clang.analysis.llvm.*;
import static org.clang.staticanalyzer.frontend.impl.AnalysisConsumerStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 143,
 FQN="(anonymous namespace)::AnalysisConsumer", NM="_ZN12_GLOBAL__N_116AnalysisConsumerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_116AnalysisConsumerE")
//</editor-fold>
public class AnalysisConsumer extends /*public*/ AnalysisASTConsumer implements /*public*/ RecursiveASTVisitor<AnalysisConsumer>, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 145,
   FQN="(anonymous namespace)::AnalysisConsumer::(anonymous)", NM="_ZN12_GLOBAL__N_116AnalysisConsumerE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_116AnalysisConsumerE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int AM_None = 0;
    public static final /*uint*/int AM_Syntax = 0x1;
    public static final /*uint*/int AM_Path = 0x2;
  /*}*/;
  // JAVA: typedef unsigned int AnalysisMode;
  
  /// Mode of the analyzes while recursively visiting Decls.
  private /*uint*/int RecVisitorMode;
  /// Bug Reporter to use while recursively visiting Decls.
  private BugReporter /*P*/ RecVisitorBR;
/*public:*/
  public ASTContext /*P*/ Ctx;
  public final /*const*/ Preprocessor /*&*/ PP;
  public /*const*/std.string OutDir;
  public IntrusiveRefCntPtr<AnalyzerOptions> Opts;
  public ArrayRef<std.string> Plugins;
  public CodeInjector /*P*/ Injector;
  
  /// \brief Stores the declarations from the local translation unit.
  /// Note, we pre-compute the local declarations at parse time as an
  /// optimization to make sure we do not deserialize everything from disk.
  /// The local declaration to all declarations ratio might be very small when
  /// working with a PCH file.
  public std.deque<Decl /*P*/ > LocalTUDecls;
  
  // Set of PathDiagnosticConsumers.  Owned by AnalysisManager.
  public std.vector<PathDiagnosticConsumer /*P*/ > PathConsumers;
  
  public StoreManagerCreator CreateStoreMgr;
  public ConstraintManagerCreator CreateConstraintMgr;
  
  public std.unique_ptr<CheckerManager> checkerMgr;
  public std.unique_ptr<AnalysisManager> Mgr;
  
  /// Time the analyzes time of each translation unit.
  // end anonymous namespace
  
  //===----------------------------------------------------------------------===//
  // AnalysisConsumer implementation.
  //===----------------------------------------------------------------------===//
  public static Timer /*P*/ TUTotalTimer = null;
  
  /// The information about analyzed functions shared throughout the
  /// translation unit.
  public FunctionSummariesTy FunctionSummaries;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer::AnalysisConsumer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 188,
   FQN="(anonymous namespace)::AnalysisConsumer::AnalysisConsumer", NM="_ZN12_GLOBAL__N_116AnalysisConsumerC1ERKN5clang12PreprocessorERKSsN4llvm18IntrusiveRefCntPtrINS1_15AnalyzerOptionsEEENS7_8ArrayRefISsEEPNS1_12CodeInjectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_116AnalysisConsumerC1ERKN5clang12PreprocessorERKSsN4llvm18IntrusiveRefCntPtrINS1_15AnalyzerOptionsEEENS7_8ArrayRefISsEEPNS1_12CodeInjectorE")
  //</editor-fold>
  public AnalysisConsumer(final /*const*/ Preprocessor /*&*/ pp, final /*const*/std.string/*&*/ outdir, 
      IntrusiveRefCntPtr<AnalyzerOptions> opts, ArrayRef<std.string> plugins, 
      CodeInjector /*P*/ injector) {
    // : AnalysisASTConsumer(), RecursiveASTVisitor<AnalysisConsumer>(), RecVisitorMode(0), RecVisitorBR(null), Ctx(null), PP(pp), OutDir(outdir), Opts(std::move(opts)), Plugins(plugins), Injector(injector), LocalTUDecls(), PathConsumers(), checkerMgr(), Mgr(), FunctionSummaries() 
    //START JInit
    super();
    $RecursiveASTVisitor();
    this.RecVisitorMode = 0;
    this.RecVisitorBR = null;
    this.Ctx = null;
    this./*&*/PP=/*&*/pp;
    this.OutDir = new std.string(outdir);
    this.Opts = new IntrusiveRefCntPtr<AnalyzerOptions>(JD$Move.INSTANCE, std.move(opts));
    this.Plugins = new ArrayRef<std.string>(plugins);
    this.Injector = injector;
    this.LocalTUDecls = new std.deque<Decl /*P*/ >(true);
    this.PathConsumers = new std.vector<PathDiagnosticConsumer /*P*/ >((PathDiagnosticConsumer /*P*/ )null);
    this.checkerMgr = new std.unique_ptr<CheckerManager>();
    this.Mgr = new std.unique_ptr<AnalysisManager>();
    this.FunctionSummaries = new FunctionSummariesTy();
    //END JInit
    DigestAnalyzerOptions();
    // JAVA: force double destroy to have exception to see where it was created
    if (TUTotalTimer != null && NativeTrace.isUnitTestMode()) {
      TUTotalTimer.$destroy();
      TUTotalTimer.$destroy();
    }
    if (Opts.$arrow().PrintStats) {
      llvm.EnableStatistics();
      TUTotalTimer = new Timer(new StringRef(/*KEEP_STR*/"Analyzer Total Time"));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer::~AnalysisConsumer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*clear timer from static field*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 201,
   FQN="(anonymous namespace)::AnalysisConsumer::~AnalysisConsumer", NM="_ZN12_GLOBAL__N_116AnalysisConsumerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_116AnalysisConsumerD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    if (Opts.$arrow().PrintStats) {
      // JAVA: make sure to clear static field and then destroy using local var
      if (TUTotalTimer != null) { 
        Timer /*P*/ $tmp = TUTotalTimer;
        TUTotalTimer = null;
        $tmp.$destroy();
      }
    }
    //START JDestroy
    FunctionSummaries.$destroy();
    Mgr.$destroy();
    checkerMgr.$destroy();
    PathConsumers.$destroy();
    LocalTUDecls.$destroy();
    Opts.$destroy();
    OutDir.$destroy();
    super.$destroy();
    RecursiveASTVisitor.super.$destroy$RecursiveASTVisitor();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer::DigestAnalyzerOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 206,
   FQN="(anonymous namespace)::AnalysisConsumer::DigestAnalyzerOptions", NM="_ZN12_GLOBAL__N_116AnalysisConsumer21DigestAnalyzerOptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_116AnalysisConsumer21DigestAnalyzerOptionsEv")
  //</editor-fold>
  public void DigestAnalyzerOptions() {
    if (Opts.$arrow().AnalysisDiagOpt != AnalysisDiagClients.PD_NONE) {
      // Create the PathDiagnosticConsumer.
      ClangDiagPathDiagConsumer /*P*/ clangDiags = new ClangDiagPathDiagConsumer(PP.getDiagnostics());
      PathConsumers.push_back_T$RR(clangDiags);
      if (Opts.$arrow().AnalysisDiagOpt == AnalysisDiagClients.PD_TEXT) {
        clangDiags.enablePaths();
      } else if (!OutDir.empty()) {
        switch (Opts.$arrow().AnalysisDiagOpt) {
         default:
         case PD_HTML:
          createHTMLDiagnosticConsumer($Deref(Opts.get()), PathConsumers, OutDir, PP);
          break;
         case PD_PLIST:
          createPlistDiagnosticConsumer($Deref(Opts.get()), PathConsumers, OutDir, PP);
          break;
         case PD_PLIST_MULTI_FILE:
          createPlistMultiFileDiagnosticConsumer($Deref(Opts.get()), PathConsumers, OutDir, PP);
          break;
         case PD_PLIST_HTML:
          createPlistHTMLDiagnosticConsumer($Deref(Opts.get()), PathConsumers, OutDir, PP);
          break;
         case PD_TEXT:
          createTextPathDiagnosticConsumer($Deref(Opts.get()), PathConsumers, OutDir, PP);
          break;
        }
      }
    }
    
    // Create the analyzer component creators.
    switch (Opts.$arrow().AnalysisStoreOpt) {
     default:
      throw new llvm_unreachable("Unknown store manager.");
     case RegionStoreModel:
      CreateStoreMgr = /*FuncRef*/RegionStoreEntoGlobals::CreateRegionStoreManager;
      break;
    }
    switch (Opts.$arrow().AnalysisConstraintsOpt) {
     default:
      throw new llvm_unreachable("Unknown constraint manager.");
     case RangeConstraintsModel:
      CreateConstraintMgr = /*FuncRef*/RangeConstraintManagerEntoGlobals::CreateRangeConstraintManager;
      break;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer::DisplayFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 246,
   FQN="(anonymous namespace)::AnalysisConsumer::DisplayFunction", NM="_ZN12_GLOBAL__N_116AnalysisConsumer15DisplayFunctionEPKN5clang4DeclEjNS1_4ento10ExprEngine13InliningModesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_116AnalysisConsumer15DisplayFunctionEPKN5clang4DeclEjNS1_4ento10ExprEngine13InliningModesE")
  //</editor-fold>
  public void DisplayFunction(/*const*/ Decl /*P*/ D, /*uint*/int Mode, 
                 /*ExprEngine::InliningModes*//*uint*/int IMode) {
    if (!Opts.$arrow().AnalyzerDisplayProgress) {
      return;
    }
    
    final SourceManager /*&*/ SM = Mgr.$arrow().getASTContext().getSourceManager();
    PresumedLoc Loc = SM.getPresumedLoc(D.getLocation());
    if (Loc.isValid()) {
      llvm.errs().$out(/*KEEP_STR*/"ANALYZE");
      if (Mode == AM_Syntax) {
        llvm.errs().$out(/*KEEP_STR*/" (Syntax)");
      } else if (Mode == AM_Path) {
        llvm.errs().$out(/*KEEP_STR*/" (Path, ");
        switch (IMode) {
         case ExprEngine.InliningModes.Inline_Minimal:
          llvm.errs().$out(/*KEEP_STR*/" Inline_Minimal");
          break;
         case ExprEngine.InliningModes.Inline_Regular:
          llvm.errs().$out(/*KEEP_STR*/" Inline_Regular");
          break;
        }
        llvm.errs().$out(/*KEEP_STR*/$RPAREN);
      } else {
        assert (Mode == (AM_Syntax | AM_Path)) : "Unexpected mode!";
      }
      
      llvm.errs().$out(/*KEEP_STR*/": ").$out(Loc.getFilename());
      if (isa_FunctionDecl(D) || isa_ObjCMethodDecl(D)) {
        /*const*/ NamedDecl /*P*/ ND = cast_NamedDecl(D);
        llvm.errs().$out_char($$SPACE).$out(ND.getQualifiedNameAsString()).$out_char($$LF);
      } else if (isa_BlockDecl(D)) {
        llvm.errs().$out_char($$SPACE).$out(/*KEEP_STR*/"block(line:").$out_uint(Loc.getLine()).$out(/*KEEP_STR*/",col:").$out_uint(
            Loc.getColumn()
        ).$out_char($$LF);
      } else {
        /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(D);
        if ((MD != null)) {
          Selector S = MD.getSelector();
          llvm.errs().$out_char($$SPACE).$out(S.getAsString());
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer::Initialize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 289,
   FQN="(anonymous namespace)::AnalysisConsumer::Initialize", NM="_ZN12_GLOBAL__N_116AnalysisConsumer10InitializeERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_116AnalysisConsumer10InitializeERN5clang10ASTContextE")
  //</editor-fold>
  @Override public void Initialize(final ASTContext /*&*/ Context)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Ctx = $AddrOf(Context);
      $c$.clean(checkerMgr.$assignMove($c$.track(createCheckerManager(Opts.$star(), PP.getLangOpts(), new ArrayRef<std.string>(Plugins), 
              PP.getDiagnostics()))));
      
      $c$.clean(Mgr.$assignMove($c$.track(llvm.make_unique(new AnalysisManager($Deref(Ctx), PP.getDiagnostics(), PP.getLangOpts(), PathConsumers, 
              CreateStoreMgr, CreateConstraintMgr, checkerMgr.get(), Opts.$star(), Injector)))));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Store the top level decls in the set to be processed later on.
  /// (Doing this pre-processing avoids deserialization of data from PCH.)
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer::HandleTopLevelDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 398,
   FQN="(anonymous namespace)::AnalysisConsumer::HandleTopLevelDecl", NM="_ZN12_GLOBAL__N_116AnalysisConsumer18HandleTopLevelDeclEN5clang12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_116AnalysisConsumer18HandleTopLevelDeclEN5clang12DeclGroupRefE")
  //</editor-fold>
  @Override public boolean HandleTopLevelDecl(DeclGroupRef DG)/* override*/ {
    storeTopLevelDecls(new DeclGroupRef(DG));
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer::HandleTopLevelDeclInObjCContainer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 403,
   FQN="(anonymous namespace)::AnalysisConsumer::HandleTopLevelDeclInObjCContainer", NM="_ZN12_GLOBAL__N_116AnalysisConsumer33HandleTopLevelDeclInObjCContainerEN5clang12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_116AnalysisConsumer33HandleTopLevelDeclInObjCContainerEN5clang12DeclGroupRefE")
  //</editor-fold>
  @Override public void HandleTopLevelDeclInObjCContainer(DeclGroupRef DG)/* override*/ {
    storeTopLevelDecls(new DeclGroupRef(DG));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer::HandleTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 507,
   FQN="(anonymous namespace)::AnalysisConsumer::HandleTranslationUnit", NM="_ZN12_GLOBAL__N_116AnalysisConsumer21HandleTranslationUnitERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_116AnalysisConsumer21HandleTranslationUnitERN5clang10ASTContextE")
  //</editor-fold>
  @Override public void HandleTranslationUnit(final ASTContext /*&*/ C)/* override*/ {
    // Don't run the actions if an error has occurred with parsing the file.
    final DiagnosticsEngine /*&*/ Diags = PP.getDiagnostics();
    if (Diags.hasErrorOccurred() || Diags.hasFatalErrorOccurred()) {
      return;
    }
    
    // Don't analyze if the user explicitly asked for no checks to be performed
    // on this file.
    if (Opts.$arrow().DisableAllChecks) {
      return;
    }
    {
      BugReporter BR = null;
      try {
        if ((TUTotalTimer != null)) {
          TUTotalTimer.startTimer();
        }
        
        // Introduce a scope to destroy BR before Mgr.
        BR/*J*/= new BugReporter(Mgr.$star());
        TranslationUnitDecl /*P*/ TU = C.getTranslationUnitDecl();
        checkerMgr.$arrow().runCheckersOnASTDecl(TU, Mgr.$star(), BR);
        
        // Run the AST-only checks using the order in which functions are defined.
        // If inlining is not turned on, use the simplest function order for path
        // sensitive analyzes as well.
        RecVisitorMode = AM_Syntax;
        if (!Mgr.$arrow().shouldInlineCall()) {
          RecVisitorMode |= AM_Path;
        }
        RecVisitorBR = $AddrOf(BR);
        
        // Process all the top level declarations.
        //
        // Note: TraverseDecl may modify LocalTUDecls, but only by appending more
        // entries.  Thus we don't use an iterator, but rely on LocalTUDecls
        // random access.  By doing so, we automatically compensate for iterators
        // possibly being invalidated, although this is a bit slower.
        /*const*//*uint*/int LocalTUDeclsSize = LocalTUDecls.size();
        for (/*uint*/int i = 0; $less_uint(i, LocalTUDeclsSize); ++i) {
          TraverseDecl(LocalTUDecls.$at(i));
        }
        if (Mgr.$arrow().shouldInlineCall()) {
          HandleDeclsCallGraph(LocalTUDeclsSize);
        }
        
        // After all decls handled, run checkers on the entire TranslationUnit.
        checkerMgr.$arrow().runCheckersOnEndOfTranslationUnit(TU, Mgr.$star(), BR);
        
        RecVisitorBR = null;
      } finally {
        if (BR != null) { BR.$destroy(); }
      }
    }
    
    // Explicitly destroy the PathDiagnosticConsumer.  This will flush its output.
    // FIXME: This should be replaced with something that doesn't rely on
    // side-effects in PathDiagnosticConsumer's destructor. This is required when
    // used with option -disable-free.
    Mgr.reset();
    if ((TUTotalTimer != null)) {
      TUTotalTimer.stopTimer();
    }
    
    // Count how many basic blocks we have not covered.
    NumBlocksInAnalyzedFunctions.$assign(FunctionSummaries.getTotalNumBasicBlocks());
    if ($greater_uint(NumBlocksInAnalyzedFunctions.$uint(), 0)) {
      PercentReachableBlocks.$assign(
          $div_uint((FunctionSummaries.getTotalNumVisitedBasicBlocks() * 100)
            , NumBlocksInAnalyzedFunctions.$uint())
      );
    }
  }

  
  /// \brief Determine which inlining mode should be used when this function is
  /// analyzed. This allows to redefine the default inlining policies when
  /// analyzing a given function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer::getInliningModeForFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 439,
   FQN="(anonymous namespace)::AnalysisConsumer::getInliningModeForFunction", NM="_ZN12_GLOBAL__N_116AnalysisConsumer26getInliningModeForFunctionEPKN5clang4DeclERKN4llvm8DenseSetIS4_NS5_12DenseMapInfoIS4_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_116AnalysisConsumer26getInliningModeForFunctionEPKN5clang4DeclERKN4llvm8DenseSetIS4_NS5_12DenseMapInfoIS4_EEEE")
  //</editor-fold>
  public /*ExprEngine::InliningModes*//*uint*/int getInliningModeForFunction(/*const*/ Decl /*P*/ D, 
                            final /*const*/DenseSet</*const*/ Decl /*P*/ > /*&*/ Visited) {
    // We want to reanalyze all ObjC methods as top level to report Retain
    // Count naming convention errors more aggressively. But we should tune down
    // inlining when reanalyzing an already inlined function.
    if ((Visited.count(D) != 0)) {
      assert (isa_ObjCMethodDecl(D)) : "We are only reanalyzing ObjCMethods.";
      /*const*/ ObjCMethodDecl /*P*/ ObjCM = cast_ObjCMethodDecl(D);
      if (ObjCM.getMethodFamily() != ObjCMethodFamily.OMF_init) {
        return ExprEngine.InliningModes.Inline_Minimal;
      }
    }
    
    return ExprEngine.InliningModes.Inline_Regular;
  }

  
  /// \brief Build the call graph for all the top level decls of this TU and
  /// use it to define the order in which the functions should be visited.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer::HandleDeclsCallGraph">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 456,
   FQN="(anonymous namespace)::AnalysisConsumer::HandleDeclsCallGraph", NM="_ZN12_GLOBAL__N_116AnalysisConsumer20HandleDeclsCallGraphEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_116AnalysisConsumer20HandleDeclsCallGraphEj")
  //</editor-fold>
  public void HandleDeclsCallGraph(/*const*//*uint*/int LocalTUDeclsSize) {
    CallGraph CG = null;
    ReversePostOrderTraversal<CallGraph /*P*/, CallGraphNode /*&*/ > RPOT = null;
    try {
      // Build the Call Graph by adding all the top level declarations to the graph.
      // Note: CallGraph can trigger deserialization of more items from a pch
      // (though HandleInterestingDecl); triggering additions to LocalTUDecls.
      // We rely on random access to add the initially processed Decls to CG.
      CG/*J*/= new CallGraph();
      for (/*uint*/int i = 0; $less_uint(i, LocalTUDeclsSize); ++i) {
        CG.addToCallGraph(LocalTUDecls.$at(i));
      }
      
      // Walk over all of the call graph nodes in topological order, so that we
      // analyze parents before the children. Skip the functions inlined into
      // the previously processed functions. Use external Visited set to identify
      // inlined functions. The topological order allows the "do not reanalyze
      // previously inlined function" performance heuristic to be triggered more
      // often.
      DenseSet</*const*/ Decl /*P*/ > Visited/*J*/= new DenseSet</*const*/ Decl /*P*/ >(DenseMapInfo$LikePtr.$Info());
      DenseSet</*const*/ Decl /*P*/ > VisitedAsTopLevel/*J*/= new DenseSet</*const*/ Decl /*P*/ >(DenseMapInfo$LikePtr.$Info());
      RPOT/*J*/= new ReversePostOrderTraversal<CallGraph /*P*/, CallGraphNode /*&*/ >(GraphTraitsCallGraph$P.$GTraits(), $AddrOf(CG));
      for (std.reverse_iterator<CallGraphNode /*&*/ > I = RPOT.begin(), E = RPOT.end(); $noteq_reverse_iterator$C(I, E); I.$preInc()) {
        NumFunctionTopLevel.$postInc(0);
        
        CallGraphNode /*P*/ N = I.$star();
        Decl /*P*/ D = N.getDecl();
        
        // Skip the abstract root node.
        if (!(D != null)) {
          continue;
        }
        
        // Skip the functions which have been processed already or previously
        // inlined.
        if (AnalysisConsumerStatics.shouldSkipFunction(D, Visited, VisitedAsTopLevel)) {
          continue;
        }
        
        // Analyze the function.
        DenseSet</*const*/ Decl /*P*/ > VisitedCallees/*J*/= new DenseSet</*const*/ Decl /*P*/ >(DenseMapInfo$LikePtr.$Info());
        
        HandleCode(D, AM_Path, getInliningModeForFunction(D, Visited), 
            (Mgr.$arrow().options.InliningMode == AnalysisInliningMode.All ? (DenseSet</*const*/ Decl /*P*/ > /*P*/)null : $AddrOf(VisitedCallees)));
        
        // Add the visited callees to the global visited set.
        for (/*const*/ Decl /*P*/ Callee : VisitedCallees)  {
          // Decls from CallGraph are already canonical. But Decls coming from
          // CallExprs may be not. We should canonicalize them manually.
          Visited.insert(isa_ObjCMethodDecl(Callee) ? Callee : Callee.getCanonicalDecl$Const());
        }
        VisitedAsTopLevel.insert(D);
      }
    } finally {
      if (RPOT != null) { RPOT.$destroy(); }
      if (CG != null) { CG.$destroy(); }
    }
  }

  
  /// \brief Run analyzes(syntax or path sensitive) on the given function.
  /// \param Mode - determines if we are requesting syntax only or path
  /// sensitive only analysis.
  /// \param VisitedCallees - The output parameter, which is populated with the
  /// set of functions which should be considered analyzed after analyzing the
  /// given root function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer::HandleCode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 608,
   FQN="(anonymous namespace)::AnalysisConsumer::HandleCode", NM="_ZN12_GLOBAL__N_116AnalysisConsumer10HandleCodeEPN5clang4DeclEjNS1_4ento10ExprEngine13InliningModesEPN4llvm8DenseSetIPKS2_NS7_12DenseMapInfoISA_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_116AnalysisConsumer10HandleCodeEPN5clang4DeclEjNS1_4ento10ExprEngine13InliningModesEPN4llvm8DenseSetIPKS2_NS7_12DenseMapInfoISA_EEEE")
  //</editor-fold>
  public void HandleCode(Decl /*P*/ D, /*uint*/int Mode) {
    HandleCode(D, Mode, 
            ExprEngine.InliningModes.Inline_Minimal, 
            (DenseSet</*const*/ Decl /*P*/ > /*P*/)null);
  }
  public void HandleCode(Decl /*P*/ D, /*uint*/int Mode, 
            /*ExprEngine::InliningModes*//*uint*/int IMode/*= ExprEngine::Inline_Minimal*/) {
    HandleCode(D, Mode, 
            IMode, 
            (DenseSet</*const*/ Decl /*P*/ > /*P*/)null);
  }
  public void HandleCode(Decl /*P*/ D, /*uint*/int Mode, 
            /*ExprEngine::InliningModes*//*uint*/int IMode/*= ExprEngine::Inline_Minimal*/, 
            DenseSet</*const*/ Decl /*P*/ > /*P*/ VisitedCallees/*= null*/) {
    BugReporter BR = null;
    try {
      if (!D.hasBody()) {
        return;
      }
      Mode = getModeForDecl(D, Mode);
      if (Mode == AM_None) {
        return;
      }
      
      DisplayFunction(D, Mode, IMode);
      CFG /*P*/ DeclCFG = Mgr.$arrow().getCFG(D);
      if ((DeclCFG != null)) {
        /*uint*/int CFGSize = DeclCFG.size();
        MaxCFGSize.$assign($less_uint(MaxCFGSize.$uint(), CFGSize) ? CFGSize : MaxCFGSize.$uint());
      }
      
      // Clear the AnalysisManager of old AnalysisDeclContexts.
      Mgr.$arrow().ClearContexts();
      BR/*J*/= new BugReporter(Mgr.$star());
      if (((Mode & AM_Syntax) != 0)) {
        checkerMgr.$arrow().runCheckersOnASTBody(D, Mgr.$star(), BR);
      }
      if (((Mode & AM_Path) != 0) && checkerMgr.$arrow().hasPathSensitiveCheckers()) {
        RunPathSensitiveChecks(D, IMode, VisitedCallees);
        if (IMode != ExprEngine.InliningModes.Inline_Minimal) {
          NumFunctionsAnalyzed.$postInc(0);
        }
      }
    } finally {
      if (BR != null) { BR.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer::RunPathSensitiveChecks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 678,
   FQN="(anonymous namespace)::AnalysisConsumer::RunPathSensitiveChecks", NM="_ZN12_GLOBAL__N_116AnalysisConsumer22RunPathSensitiveChecksEPN5clang4DeclENS1_4ento10ExprEngine13InliningModesEPN4llvm8DenseSetIPKS2_NS7_12DenseMapInfoISA_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_116AnalysisConsumer22RunPathSensitiveChecksEPN5clang4DeclENS1_4ento10ExprEngine13InliningModesEPN4llvm8DenseSetIPKS2_NS7_12DenseMapInfoISA_EEEE")
  //</editor-fold>
  public void RunPathSensitiveChecks(Decl /*P*/ D, 
                        /*ExprEngine::InliningModes*//*uint*/int IMode, 
                        DenseSet</*const*/ Decl /*P*/ > /*P*/ Visited) {
    switch (Mgr.$arrow().getLangOpts().getGC()) {
     case NonGC:
      ActionExprEngine(D, false, IMode, Visited);
      break;
     case GCOnly:
      ActionExprEngine(D, true, IMode, Visited);
      break;
     case HybridGC:
      ActionExprEngine(D, false, IMode, Visited);
      ActionExprEngine(D, true, IMode, Visited);
      break;
    }
  }

  
  //===----------------------------------------------------------------------===//
  // Path-sensitive checking.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer::ActionExprEngine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 641,
   FQN="(anonymous namespace)::AnalysisConsumer::ActionExprEngine", NM="_ZN12_GLOBAL__N_116AnalysisConsumer16ActionExprEngineEPN5clang4DeclEbNS1_4ento10ExprEngine13InliningModesEPN4llvm8DenseSetIPKS2_NS7_12DenseMapInfoISA_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_116AnalysisConsumer16ActionExprEngineEPN5clang4DeclEbNS1_4ento10ExprEngine13InliningModesEPN4llvm8DenseSetIPKS2_NS7_12DenseMapInfoISA_EEEE")
  //</editor-fold>
  public void ActionExprEngine(Decl /*P*/ D, boolean ObjCGCEnabled, 
                  /*ExprEngine::InliningModes*//*uint*/int IMode, 
                  DenseSet</*const*/ Decl /*P*/ > /*P*/ VisitedCallees) {
    ExprEngine Eng = null;
    std.unique_ptr<ExplodedNode.Auditor> Auditor = null;
    try {
      // Construct the analysis engine.  First check if the CFG is valid.
      // FIXME: Inter-procedural analysis will need to handle invalid CFGs.
      if (!(Mgr.$arrow().getCFG(D) != null)) {
        return;
      }
      
      // See if the LiveVariables analysis scales.
      if (!(Mgr.$arrow().getAnalysisDeclContext(D).<RelaxedLiveVariables>getAnalysis(RelaxedLiveVariables.class) != null)) {
        return;
      }
      
      Eng/*J*/= new ExprEngine(Mgr.$star(), ObjCGCEnabled, VisitedCallees, $AddrOf(FunctionSummaries), IMode);
      
      // Set the graph auditor.
      Auditor/*J*/= new std.unique_ptr<ExplodedNode.Auditor>();
      if (Mgr.$arrow().options.visualizeExplodedGraphWithUbiGraph) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(Auditor.$assignMove($c$.track(AnalysisConsumerStatics.CreateUbiViz())));
          ExplodedNode.SetAuditor(Auditor.get());
        } finally {
          $c$.$destroy();
        }
      }
      
      // Execute the worklist algorithm.
      Eng.ExecuteWorkList(Mgr.$arrow().getAnalysisDeclContextManager().getStackFrame(D), 
          Mgr.$arrow().options.getMaxNodesPerTopLevelFunction());
      
      // Release the auditor (if any) so that it doesn't monitor the graph
      // created BugReporter.
      ExplodedNode.SetAuditor((ExplodedNode.Auditor /*P*/ )null);
      
      // Visualize the exploded graph.
      if (Mgr.$arrow().options.visualizeExplodedGraphWithGraphViz) {
        Eng.ViewGraph(Mgr.$arrow().options.TrimGraph);
      }
      
      // Display warnings.
      Eng.getBugReporter().FlushReports();
    } finally {
      if (Auditor != null) { Auditor.$destroy(); }
      if (Eng != null) { Eng.$destroy(); }
    }
  }

  
  /// Visitors for the RecursiveASTVisitor.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer::shouldWalkTypesOfTypeLocs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 334,
   FQN="(anonymous namespace)::AnalysisConsumer::shouldWalkTypesOfTypeLocs", NM="_ZNK12_GLOBAL__N_116AnalysisConsumer25shouldWalkTypesOfTypeLocsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK12_GLOBAL__N_116AnalysisConsumer25shouldWalkTypesOfTypeLocsEv")
  //</editor-fold>
  public boolean shouldWalkTypesOfTypeLocs() /*const*/ {
    return false;
  }

  
  /// Handle callbacks for arbitrary Decls.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer::VisitDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 337,
   FQN="(anonymous namespace)::AnalysisConsumer::VisitDecl", NM="_ZN12_GLOBAL__N_116AnalysisConsumer9VisitDeclEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_116AnalysisConsumer9VisitDeclEPN5clang4DeclE")
  //</editor-fold>
  public boolean VisitDecl(Decl /*P*/ D) {
    /*uint*/int Mode = getModeForDecl(D, RecVisitorMode);
    if (((Mode & AM_Syntax) != 0)) {
      checkerMgr.$arrow().runCheckersOnASTDecl(D, Mgr.$star(), $Deref(RecVisitorBR));
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer::VisitFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 344,
   FQN="(anonymous namespace)::AnalysisConsumer::VisitFunctionDecl", NM="_ZN12_GLOBAL__N_116AnalysisConsumer17VisitFunctionDeclEPN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_116AnalysisConsumer17VisitFunctionDeclEPN5clang12FunctionDeclE")
  //</editor-fold>
  public boolean VisitFunctionDecl(FunctionDecl /*P*/ FD) {
    IdentifierInfo /*P*/ II = FD.getIdentifier();
    if ((II != null) && II.getName().startswith(/*STRINGREF_STR*/"__inline")) {
      return true;
    }
    
    // We skip function template definitions, as their semantics is
    // only determined when they are instantiated.
    if (FD.isThisDeclarationADefinition()
       && !FD.isDependentContext()) {
      assert (RecVisitorMode == AM_Syntax || Mgr.$arrow().shouldInlineCall() == false);
      HandleCode(FD, RecVisitorMode);
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer::VisitObjCMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 359,
   FQN="(anonymous namespace)::AnalysisConsumer::VisitObjCMethodDecl", NM="_ZN12_GLOBAL__N_116AnalysisConsumer19VisitObjCMethodDeclEPN5clang14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_116AnalysisConsumer19VisitObjCMethodDeclEPN5clang14ObjCMethodDeclE")
  //</editor-fold>
  public boolean VisitObjCMethodDecl(ObjCMethodDecl /*P*/ MD) {
    if (MD.isThisDeclarationADefinition()) {
      assert (RecVisitorMode == AM_Syntax || Mgr.$arrow().shouldInlineCall() == false);
      HandleCode(MD, RecVisitorMode);
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer::VisitBlockDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 367,
   FQN="(anonymous namespace)::AnalysisConsumer::VisitBlockDecl", NM="_ZN12_GLOBAL__N_116AnalysisConsumer14VisitBlockDeclEPN5clang9BlockDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_116AnalysisConsumer14VisitBlockDeclEPN5clang9BlockDeclE")
  //</editor-fold>
  public boolean VisitBlockDecl(BlockDecl /*P*/ BD) {
    if (BD.hasBody()) {
      assert (RecVisitorMode == AM_Syntax || Mgr.$arrow().shouldInlineCall() == false);
      // Since we skip function template definitions, we should skip blocks
      // declared in those functions as well.
      if (!BD.isDependentContext()) {
        HandleCode(BD, RecVisitorMode);
      }
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer::AddDiagnosticConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 379,
   FQN="(anonymous namespace)::AnalysisConsumer::AddDiagnosticConsumer", NM="_ZN12_GLOBAL__N_116AnalysisConsumer21AddDiagnosticConsumerEPN5clang4ento22PathDiagnosticConsumerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_116AnalysisConsumer21AddDiagnosticConsumerEPN5clang4ento22PathDiagnosticConsumerE")
  //</editor-fold>
  @Override public void AddDiagnosticConsumer(PathDiagnosticConsumer /*P*/ Consumer)/* override*/ {
    PathConsumers.push_back_T$C$R(Consumer);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer::storeTopLevelDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 407,
   FQN="(anonymous namespace)::AnalysisConsumer::storeTopLevelDecls", NM="_ZN12_GLOBAL__N_116AnalysisConsumer18storeTopLevelDeclsEN5clang12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_116AnalysisConsumer18storeTopLevelDeclsEN5clang12DeclGroupRefE")
  //</editor-fold>
  private void storeTopLevelDecls(DeclGroupRef DG) {
    for (type$ptr<Decl/*P*/>/*iterator*/ I = $tryClone(DG.begin()), /*P*/ /*P*/ E = $tryClone(DG.end()); $noteq_ptr(I, E); I.$preInc()) {
      
      // Skip ObjCMethodDecl, wait for the objc container to avoid
      // analyzing twice.
      if (isa_ObjCMethodDecl(I.$star())) {
        continue;
      }
      
      LocalTUDecls.push_back_T$C$R(I.$star());
    }
  }

  
  /// \brief Check if we should skip (not analyze) the given function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalysisConsumer::getModeForDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 583,
   FQN="(anonymous namespace)::AnalysisConsumer::getModeForDecl", NM="_ZN12_GLOBAL__N_116AnalysisConsumer14getModeForDeclEPN5clang4DeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_116AnalysisConsumer14getModeForDeclEPN5clang4DeclEj")
  //</editor-fold>
  private /*uint*/int getModeForDecl(Decl /*P*/ D, /*uint*/int Mode) {
    if (!Opts.$arrow().AnalyzeSpecificFunction.empty()
       && $noteq_string$C(getFunctionName(D), Opts.$arrow().AnalyzeSpecificFunction)) {
      return AM_None;
    }
    
    // Unless -analyze-all is specified, treat decls differently depending on
    // where they came from:
    // - Main source file: run both path-sensitive and non-path-sensitive checks.
    // - Header files: run non-path-sensitive checks only.
    // - System headers: don't run any checks.
    final SourceManager /*&*/ SM = Ctx.getSourceManager();
    /*const*/ Stmt /*P*/ Body = D.getBody();
    SourceLocation SL = (Body != null) ? Body.getLocStart() : D.getLocation();
    SL.$assignMove(SM.getExpansionLoc(/*NO_COPY*/SL));
    if (!Opts.$arrow().AnalyzeAll && !SM.isWrittenInMainFile(/*NO_COPY*/SL)) {
      if (SL.isInvalid() || SM.isInSystemHeader(/*NO_COPY*/SL)) {
        return AM_None;
      }
      return Mode & ~AM_Path;
    }
    
    return Mode;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public boolean has_overridden_traverse_with_queue_method(String MethodName) {
    return false;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "RecVisitorMode=" + RecVisitorMode // NOI18N
              + ", RecVisitorBR=" + RecVisitorBR // NOI18N
              + ", Ctx=" + "[ASTContext]" // NOI18N
              + ", PP=" + "[Preprocessor]" // NOI18N
              + ", OutDir=" + OutDir // NOI18N
              + ", Opts=" + Opts // NOI18N
              + ", Plugins=" + Plugins // NOI18N
              + ", Injector=" + Injector // NOI18N
              + ", LocalTUDecls=" + LocalTUDecls // NOI18N
              + ", PathConsumers=" + "[Vector$PathDiagnosticConsumer]" // NOI18N
              + ", CreateStoreMgr=" + CreateStoreMgr // NOI18N
              + ", CreateConstraintMgr=" + CreateConstraintMgr // NOI18N
              + ", checkerMgr=" + "[Unique_ptr$CheckerManager]" // NOI18N
              + ", Mgr=" + "[Unique_ptr$AnalysisManager]" // NOI18N
              + ", FunctionSummaries=" + FunctionSummaries // NOI18N
              + super.toString(); // NOI18N
  }
}
