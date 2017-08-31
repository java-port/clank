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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.frontend.staticanalyzer.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerFunctionPointers.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::AnalysisManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/AnalysisManager.h", line = 31,
 FQN="clang::ento::AnalysisManager", NM="_ZN5clang4ento15AnalysisManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento15AnalysisManagerE")
//</editor-fold>
public class AnalysisManager extends /*public*/ BugReporterData implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnalysisManager::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp", line = 15,
   FQN="clang::ento::AnalysisManager::anchor", NM="_ZN5clang4ento15AnalysisManager6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento15AnalysisManager6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

  private AnalysisDeclContextManager AnaCtxMgr;
  
  private final ASTContext /*&*/ Ctx;
  private final DiagnosticsEngine /*&*/ Diags;
  private final /*const*/ LangOptions /*&*/ LangOpts;
  private std.vector<PathDiagnosticConsumer /*P*/ > PathConsumers;
  
  // Configurable components creators.
  private StoreManagerCreator CreateStoreMgr;
  private ConstraintManagerCreator CreateConstraintMgr;
  
  private CheckerManager /*P*/ CheckerMgr;
/*public:*/
  public final AnalyzerOptions /*&*/ options;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnalysisManager::AnalysisManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp", line = 17,
   FQN="clang::ento::AnalysisManager::AnalysisManager", NM="_ZN5clang4ento15AnalysisManagerC1ERNS_10ASTContextERNS_17DiagnosticsEngineERKNS_11LangOptionsERKSt6vectorIPNS0_22PathDiagnosticConsumerESaISB_EEPFSt10unique_ptrINS0_12StoreManagerESt14default_deleteISH_EERNS0_19ProgramStateManagerEEPFSG_INS0_17ConstraintManagerESI_ISP_EESM_PNS0_9SubEngineEEPNS0_14CheckerManagerERNS_15AnalyzerOptionsEPNS_12CodeInjectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento15AnalysisManagerC1ERNS_10ASTContextERNS_17DiagnosticsEngineERKNS_11LangOptionsERKSt6vectorIPNS0_22PathDiagnosticConsumerESaISB_EEPFSt10unique_ptrINS0_12StoreManagerESt14default_deleteISH_EERNS0_19ProgramStateManagerEEPFSG_INS0_17ConstraintManagerESI_ISP_EESM_PNS0_9SubEngineEEPNS0_14CheckerManagerERNS_15AnalyzerOptionsEPNS_12CodeInjectorE")
  //</editor-fold>
  public AnalysisManager(final ASTContext /*&*/ ctx, final DiagnosticsEngine /*&*/ diags, 
      final /*const*/ LangOptions /*&*/ lang, 
      final /*const*/std.vector<PathDiagnosticConsumer /*P*/ > /*&*/ PDC, 
      StoreManagerCreator storemgr, 
      ConstraintManagerCreator constraintmgr, 
      CheckerManager /*P*/ checkerMgr, 
      final AnalyzerOptions /*&*/ Options) {
    this(ctx, diags, 
      lang, 
      PDC, 
      storemgr, 
      constraintmgr, 
      checkerMgr, 
      Options, 
      (CodeInjector /*P*/ )null);
  }
  public AnalysisManager(final ASTContext /*&*/ ctx, final DiagnosticsEngine /*&*/ diags, 
      final /*const*/ LangOptions /*&*/ lang, 
      final /*const*/std.vector<PathDiagnosticConsumer /*P*/ > /*&*/ PDC, 
      StoreManagerCreator storemgr, 
      ConstraintManagerCreator constraintmgr, 
      CheckerManager /*P*/ checkerMgr, 
      final AnalyzerOptions /*&*/ Options, 
      CodeInjector /*P*/ injector/*= null*/) {
    // : BugReporterData(), AnaCtxMgr(Options.UnoptimizedCFG, /*AddImplicitDtors=*/ true, /*AddInitializers=*/ true, Options.includeTemporaryDtorsInCFG(), Options.shouldSynthesizeBodies(), Options.shouldConditionalizeStaticInitializers(), /*addCXXNewAllocator=*/ true, injector), Ctx(ctx), Diags(diags), LangOpts(lang), PathConsumers(PDC), CreateStoreMgr(storemgr), CreateConstraintMgr(constraintmgr), CheckerMgr(checkerMgr), options(Options) 
    //START JInit
    super();
    this.AnaCtxMgr = new AnalysisDeclContextManager(Options.UnoptimizedCFG, 
        true, 
        true, 
        Options.includeTemporaryDtorsInCFG(), 
        Options.shouldSynthesizeBodies(), 
        Options.shouldConditionalizeStaticInitializers(), 
        true, 
        injector);
    this./*&*/Ctx=/*&*/ctx;
    this./*&*/Diags=/*&*/diags;
    this./*&*/LangOpts=/*&*/lang;
    this.PathConsumers = new std.vector<PathDiagnosticConsumer /*P*/ >(PDC);
    this.CreateStoreMgr = storemgr;
    this.CreateConstraintMgr = constraintmgr;
    this.CheckerMgr = checkerMgr;
    this./*&*/options=/*&*/Options;
    //END JInit
    AnaCtxMgr.getCFGBuildOptions().setAllAlwaysAdd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnalysisManager::~AnalysisManager">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp", line = 43,
   FQN="clang::ento::AnalysisManager::~AnalysisManager", NM="_ZN5clang4ento15AnalysisManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento15AnalysisManagerD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    FlushDiagnostics();
    for (std.vector.iterator<PathDiagnosticConsumer /*P*/> I = PathConsumers.begin(), 
        E = PathConsumers.end(); $noteq___normal_iterator$C(I, E); I.$preInc()) {
      if (I.$star() != null) { I.$star().$destroy();};
    }
    //START JDestroy
    PathConsumers.$destroy();
    AnaCtxMgr.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnalysisManager::ClearContexts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/AnalysisManager.h", line = 60,
   FQN="clang::ento::AnalysisManager::ClearContexts", NM="_ZN5clang4ento15AnalysisManager13ClearContextsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento15AnalysisManager13ClearContextsEv")
  //</editor-fold>
  public void ClearContexts() {
    AnaCtxMgr.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnalysisManager::getAnalysisDeclContextManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/AnalysisManager.h", line = 64,
   FQN="clang::ento::AnalysisManager::getAnalysisDeclContextManager", NM="_ZN5clang4ento15AnalysisManager29getAnalysisDeclContextManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento15AnalysisManager29getAnalysisDeclContextManagerEv")
  //</editor-fold>
  public AnalysisDeclContextManager /*&*/ getAnalysisDeclContextManager() {
    return AnaCtxMgr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnalysisManager::getStoreManagerCreator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/AnalysisManager.h", line = 68,
   FQN="clang::ento::AnalysisManager::getStoreManagerCreator", NM="_ZN5clang4ento15AnalysisManager22getStoreManagerCreatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento15AnalysisManager22getStoreManagerCreatorEv")
  //</editor-fold>
  public StoreManagerCreator getStoreManagerCreator() {
    return CreateStoreMgr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnalysisManager::getAnalyzerOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/AnalysisManager.h", line = 72,
   FQN="clang::ento::AnalysisManager::getAnalyzerOptions", NM="_ZN5clang4ento15AnalysisManager18getAnalyzerOptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento15AnalysisManager18getAnalyzerOptionsEv")
  //</editor-fold>
  @Override public AnalyzerOptions /*&*/ getAnalyzerOptions()/* override*/ {
    return options;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnalysisManager::getConstraintManagerCreator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/AnalysisManager.h", line = 76,
   FQN="clang::ento::AnalysisManager::getConstraintManagerCreator", NM="_ZN5clang4ento15AnalysisManager27getConstraintManagerCreatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento15AnalysisManager27getConstraintManagerCreatorEv")
  //</editor-fold>
  public ConstraintManagerCreator getConstraintManagerCreator() {
    return CreateConstraintMgr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnalysisManager::getCheckerManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/AnalysisManager.h", line = 80,
   FQN="clang::ento::AnalysisManager::getCheckerManager", NM="_ZNK5clang4ento15AnalysisManager17getCheckerManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZNK5clang4ento15AnalysisManager17getCheckerManagerEv")
  //</editor-fold>
  public CheckerManager /*P*/ getCheckerManager() /*const*/ {
    return CheckerMgr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnalysisManager::getASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/AnalysisManager.h", line = 82,
   FQN="clang::ento::AnalysisManager::getASTContext", NM="_ZN5clang4ento15AnalysisManager13getASTContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento15AnalysisManager13getASTContextEv")
  //</editor-fold>
  @Override public ASTContext /*&*/ getASTContext()/* override*/ {
    return Ctx;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnalysisManager::getSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/AnalysisManager.h", line = 86,
   FQN="clang::ento::AnalysisManager::getSourceManager", NM="_ZN5clang4ento15AnalysisManager16getSourceManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento15AnalysisManager16getSourceManagerEv")
  //</editor-fold>
  @Override public SourceManager /*&*/ getSourceManager()/* override*/ {
    return getASTContext().getSourceManager();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnalysisManager::getDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/AnalysisManager.h", line = 90,
   FQN="clang::ento::AnalysisManager::getDiagnostic", NM="_ZN5clang4ento15AnalysisManager13getDiagnosticEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento15AnalysisManager13getDiagnosticEv")
  //</editor-fold>
  @Override public DiagnosticsEngine /*&*/ getDiagnostic()/* override*/ {
    return Diags;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnalysisManager::getLangOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/AnalysisManager.h", line = 94,
   FQN="clang::ento::AnalysisManager::getLangOpts", NM="_ZNK5clang4ento15AnalysisManager11getLangOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZNK5clang4ento15AnalysisManager11getLangOptsEv")
  //</editor-fold>
  public /*const*/ LangOptions /*&*/ getLangOpts() /*const*/ {
    return LangOpts;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnalysisManager::getPathDiagnosticConsumers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/AnalysisManager.h", line = 98,
   FQN="clang::ento::AnalysisManager::getPathDiagnosticConsumers", NM="_ZN5clang4ento15AnalysisManager26getPathDiagnosticConsumersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento15AnalysisManager26getPathDiagnosticConsumersEv")
  //</editor-fold>
  @Override public ArrayRef<PathDiagnosticConsumer /*P*/ > getPathDiagnosticConsumers()/* override*/ {
    return new ArrayRef<PathDiagnosticConsumer /*P*/ >(PathConsumers, true);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnalysisManager::FlushDiagnostics">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp", line = 51,
   FQN="clang::ento::AnalysisManager::FlushDiagnostics", NM="_ZN5clang4ento15AnalysisManager16FlushDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento15AnalysisManager16FlushDiagnosticsEv")
  //</editor-fold>
  public void FlushDiagnostics() {
    PathDiagnosticConsumer.FilesMade filesMade = null;
    try {
      filesMade/*J*/= new PathDiagnosticConsumer.FilesMade();
      for (std.vector.iterator<PathDiagnosticConsumer /*P*/> I = PathConsumers.begin(), 
          E = PathConsumers.end();
           $noteq___normal_iterator$C(I, E); I.$preInc()) {
        (I.$star()).FlushDiagnostics($AddrOf(filesMade));
      }
    } finally {
      if (filesMade != null) { filesMade.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnalysisManager::shouldVisualize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/AnalysisManager.h", line = 104,
   FQN="clang::ento::AnalysisManager::shouldVisualize", NM="_ZNK5clang4ento15AnalysisManager15shouldVisualizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZNK5clang4ento15AnalysisManager15shouldVisualizeEv")
  //</editor-fold>
  public boolean shouldVisualize() /*const*/ {
    return options.visualizeExplodedGraphWithGraphViz
       || options.visualizeExplodedGraphWithUbiGraph;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnalysisManager::shouldInlineCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/AnalysisManager.h", line = 109,
   FQN="clang::ento::AnalysisManager::shouldInlineCall", NM="_ZNK5clang4ento15AnalysisManager16shouldInlineCallEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZNK5clang4ento15AnalysisManager16shouldInlineCallEv")
  //</editor-fold>
  public boolean shouldInlineCall() /*const*/ {
    return options.getIPAMode() != IPAKind.IPAK_None;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnalysisManager::getCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/AnalysisManager.h", line = 113,
   FQN="clang::ento::AnalysisManager::getCFG", NM="_ZN5clang4ento15AnalysisManager6getCFGEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento15AnalysisManager6getCFGEPKNS_4DeclE")
  //</editor-fold>
  public CFG /*P*/ getCFG(/*const*/ Decl /*P*/ D) {
    return AnaCtxMgr.getContext(D).getCFG();
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnalysisManager::getAnalysis">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/AnalysisManager.h", line = 118,
   FQN="clang::ento::AnalysisManager::getAnalysis", NM="Tpl__ZN5clang4ento15AnalysisManager11getAnalysisEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=Tpl__ZN5clang4ento15AnalysisManager11getAnalysisEPKNS_4DeclE")
  //</editor-fold>
  public </*typename*/ T extends ManagedAnalysis> T /*P*/ getAnalysis(Class<T> clazz, /*const*/ Decl /*P*/ D) {
    return AnaCtxMgr.getContext(D).<T>getAnalysis(clazz);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnalysisManager::getParentMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/AnalysisManager.h", line = 122,
   FQN="clang::ento::AnalysisManager::getParentMap", NM="_ZN5clang4ento15AnalysisManager12getParentMapEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento15AnalysisManager12getParentMapEPKNS_4DeclE")
  //</editor-fold>
  public ParentMap /*&*/ getParentMap(/*const*/ Decl /*P*/ D) {
    return AnaCtxMgr.getContext(D).getParentMap();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnalysisManager::getAnalysisDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/AnalysisManager.h", line = 126,
   FQN="clang::ento::AnalysisManager::getAnalysisDeclContext", NM="_ZN5clang4ento15AnalysisManager22getAnalysisDeclContextEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento15AnalysisManager22getAnalysisDeclContextEPKNS_4DeclE")
  //</editor-fold>
  public AnalysisDeclContext /*P*/ getAnalysisDeclContext(/*const*/ Decl /*P*/ D) {
    return AnaCtxMgr.getContext(D);
  }

  
  @Override public String toString() {
    return "" + "AnaCtxMgr=" + "[AnalysisDeclContextManager]" // NOI18N
              + ", Ctx=" + "[ASTContext]" // NOI18N
              + ", Diags=" + "[DiagnosticsEngine]" // NOI18N
              + ", LangOpts=" + LangOpts // NOI18N
              + ", PathConsumers=" + "[Vector$PathDiagnosticConsumer]" // NOI18N
              + ", CreateStoreMgr=" + CreateStoreMgr // NOI18N
              + ", CreateConstraintMgr=" + CreateConstraintMgr // NOI18N
              + ", CheckerMgr=" + "[CheckerManager]" // NOI18N
              + ", options=" + options // NOI18N
              + super.toString(); // NOI18N
  }
}
