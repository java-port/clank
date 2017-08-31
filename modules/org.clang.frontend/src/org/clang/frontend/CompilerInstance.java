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

package org.clang.frontend;

import org.llvm.adt.java.ADTJavaDifferentiators.*;
import org.clang.driver.frontend.CodeGenOptions;
import org.clang.lex.llvm.ModuleIdPath;
import org.llvm.support.sys.sys;
import org.clang.basic.target.TargetOptions;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.frontend.FrontendClangGlobals.*;
import org.clang.basic.*;
import org.clang.basic.target.TargetInfo;
import org.clang.basic.vfs.*;
import org.clang.lex.*;
import org.clang.sema.*;
import org.clang.serialization.*;
import org.clang.serialization.GlobalModuleIndex;
import org.clang.frontend.*;
import org.clang.frontend.frontend;
import static org.clang.frontend.impl.CompilerInstanceStatics.EnableCodeCompletion;
import static org.clang.frontend.impl.CompilerInstanceStatics.InitializeFileRemapping;
import static org.clang.frontend.impl.CompilerInstanceStatics.SetUpDiagnosticLog;
import static org.clang.frontend.impl.CompilerInstanceStatics.SetupSerializedDiagnostics;
import static org.clang.frontend.impl.CompilerInstanceStatics.checkConfigMacro;
import static org.clang.frontend.impl.CompilerInstanceStatics.compileAndLoadModule;
import static org.clang.frontend.impl.CompilerInstanceStatics.pruneModuleCache;
import org.clang.frontend.staticanalyzer.AnalyzerOptions;
import org.clang.lex.llvm.SmallVectorPtrPairFileEntryDirectoryEntry;
import static org.clank.support.Unsigned.$greater_uint;
import org.llvm.support.sys.fs;
import org.llvm.support.sys.fs.file_status;
import org.llvm.support.sys.path;


/// CompilerInstance - Helper class for managing a single instance of the Clang
/// compiler.
///
/// The CompilerInstance serves two purposes:
///  (1) It manages the various objects which are necessary to run the compiler,
///      for example the preprocessor, the target information, and the AST
///      context.
///  (2) It provides utility routines for constructing and manipulating the
///      common Clang objects.
///
/// The compiler instance generally owns the instance of all the objects that it
/// manages. However, clients can still share objects by manually setting the
/// object and retaking ownership prior to destroying the CompilerInstance.
///
/// The compiler instance is intended to simplify clients, but not to lock them
/// in to the compiler instance for everything. When possible, utility functions
/// come in two forms; a short form that reuses the CompilerInstance objects,
/// and a long form that takes explicit instances of any required objects.
//<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 71,
 FQN="clang::CompilerInstance", NM="_ZN5clang16CompilerInstanceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstanceE")
//</editor-fold>
public class CompilerInstance extends /*public*/ ModuleLoader implements Destructors.ClassWithDestructor {
  /// The options used in this compiler instance.
  private IntrusiveRefCntPtr<CompilerInvocation> Invocation;
  
  /// The diagnostics engine instance.
  private IntrusiveRefCntPtr<DiagnosticsEngine> Diagnostics;
  
  /// The target being compiled for.
  private IntrusiveRefCntPtr<TargetInfo> Target;
  
  /// Auxiliary Target info.
  private IntrusiveRefCntPtr<TargetInfo> AuxTarget;
  
  /// The virtual file system.
  private IntrusiveRefCntPtr<FileSystem> VirtualFileSystem;
  
  /// The file manager.
  private IntrusiveRefCntPtr<FileManager> FileMgr;
  
  /// The source manager.
  private IntrusiveRefCntPtr<SourceManager> SourceMgr;
  
  /// The preprocessor.
  private IntrusiveRefCntPtr<Preprocessor> PP;
  
  /// The AST context.
  private IntrusiveRefCntPtr<ASTContext> Context;
  
  /// The AST consumer.
  private std.unique_ptr<ASTConsumer> Consumer;
  
  /// The code completion consumer.
  private std.unique_ptr<CodeCompleteConsumer> CompletionConsumer;
  
  /// \brief The semantic analysis object.
  private std.unique_ptr<Sema> TheSema;
  
  /// \brief The frontend timer group.
  private std.unique_ptr<TimerGroup> FrontendTimerGroup;
  
  /// \brief The frontend timer.
  private std.unique_ptr<Timer> FrontendTimer;
  
  /// \brief The ASTReader, if one exists.
  private IntrusiveRefCntPtr<ASTReader> ModuleManager;
  
  /// \brief The module dependency collector for crashdumps
  private std.shared_ptr<ModuleDependencyCollector> ModuleDepCollector;
  
  /// \brief The module provider.
  private std.shared_ptr<PCHContainerOperations> ThePCHContainerOperations;
  
  /// \brief The dependency file generator.
  private std.unique_ptr<DependencyFileGenerator> TheDependencyFileGenerator;
  
  private std.vector<std.shared_ptr<DependencyCollector>> DependencyCollectors;
  
  /// \brief The set of top-level modules that has already been loaded,
  /// along with the module map
  private DenseMap</*const*/ IdentifierInfo /*P*/ , Module /*P*/ > KnownModules;
  
  /// \brief The location of the module-import keyword for the last module
  /// import. 
  private SourceLocation LastModuleImportLoc;
  
  /// \brief The result of the last module import.
  ///
  private ModuleLoadResult LastModuleImportResult;
  
  /// \brief Whether we should (re)build the global module index once we
  /// have finished with this translation unit.
  private boolean BuildGlobalModuleIndex;
  
  /// \brief We have a full global module index, with all modules.
  private boolean HaveFullGlobalModuleIndex;
  
  /// \brief One or more modules failed to build.
  private boolean ModuleBuildFailed;
  
  /// \brief Holds information about the output file.
  ///
  /// If TempFilename is not empty we must rename it to Filename at the end.
  /// TempFilename may be empty and Filename non-empty if creating the temporary
  /// failed.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::OutputFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 155,
   FQN="clang::CompilerInstance::OutputFile", NM="_ZN5clang16CompilerInstance10OutputFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance10OutputFileE")
  //</editor-fold>
  private static class/*struct*/ OutputFile implements Destructors.ClassWithDestructor, NativeCloneable<OutputFile> {
    public std.string Filename;
    public std.string TempFilename;
    
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public OutputFile() {
      this.Filename = std.string.EMPTY;
      this.TempFilename = std.string.EMPTY;
    }
    
    //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::OutputFile::OutputFile">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 159,
     FQN="clang::CompilerInstance::OutputFile::OutputFile", NM="_ZN5clang16CompilerInstance10OutputFileC1ESsSs",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance10OutputFileC1ESsSs")
    //</editor-fold>
    public OutputFile(std.string filename, std.string tempFilename) {
      // : Filename(std::move(filename)), TempFilename(std::move(tempFilename)) 
      //START JInit
      this.Filename = new std.string(JD$Move.INSTANCE, std.move(filename));
      this.TempFilename = new std.string(JD$Move.INSTANCE, std.move(tempFilename));
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::OutputFile::OutputFile">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 155,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 164,
     FQN="clang::CompilerInstance::OutputFile::OutputFile", NM="_ZN5clang16CompilerInstance10OutputFileC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance10OutputFileC1EOS1_")
    //</editor-fold>
    public /*inline*/ OutputFile(JD$Move _dparam, OutputFile /*&&*/$Prm0) {
      // : Filename(static_cast<OutputFile &&>().Filename), TempFilename(static_cast<OutputFile &&>().TempFilename) 
      //START JInit
      this.Filename = new std.string(JD$Move.INSTANCE, $Prm0.Filename);
      this.TempFilename = new std.string(JD$Move.INSTANCE, $Prm0.TempFilename);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::OutputFile::~OutputFile">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 155,
     FQN="clang::CompilerInstance::OutputFile::~OutputFile", NM="_ZN5clang16CompilerInstance10OutputFileD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance10OutputFileD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      TempFilename.$destroy();
      Filename.$destroy();
      //END JDestroy
    }

    @Override public OutputFile clone() { 
      return new OutputFile(new std.string(this.Filename), new std.string(this.TempFilename));
    }
    
    @Override public String toString() {
      return "" + "Filename=" + Filename // NOI18N
                + ", TempFilename=" + TempFilename; // NOI18N
    }
  };
  
  /// If the output doesn't support seeking (terminal, pipe). we switch
  /// the stream to a buffer_ostream. These are the buffer and the original
  /// stream.
  private std.unique_ptr<raw_fd_ostream> NonSeekStream;
  
  /// The list of active output files.
  private std.list<OutputFile> OutputFiles;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::CompilerInstance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 172,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 177,
   FQN="clang::CompilerInstance::CompilerInstance", NM="_ZN5clang16CompilerInstanceC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstanceC1ERKS0_")
  //</editor-fold>
  private CompilerInstance(/*const*/ CompilerInstance /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 173,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 178,
   FQN="clang::CompilerInstance::operator=", NM="_ZN5clang16CompilerInstanceaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstanceaSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/ CompilerInstance /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::CompilerInstance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 55,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 54,
   FQN="clang::CompilerInstance::CompilerInstance", NM="_ZN5clang16CompilerInstanceC1ESt10shared_ptrINS_22PCHContainerOperationsEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstanceC1ESt10shared_ptrINS_22PCHContainerOperationsEEb")
  //</editor-fold>
  public CompilerInstance() {
    this(std.make_shared(new PCHContainerOperations()), 
      false);
  }
  public CompilerInstance(std.shared_ptr<PCHContainerOperations> PCHContainerOps/*= std::make_shared<PCHContainerOperations>()*/) {
    this(PCHContainerOps, 
      false);
  }
  public CompilerInstance(std.shared_ptr<PCHContainerOperations> PCHContainerOps/*= std::make_shared<PCHContainerOperations>()*/, 
      boolean BuildingModule/*= false*/) {
    // : ModuleLoader(BuildingModule), Invocation(new CompilerInvocation()), Diagnostics(), Target(), AuxTarget(), VirtualFileSystem(), FileMgr(), SourceMgr(), PP(), Context(), Consumer(), CompletionConsumer(), TheSema(), FrontendTimerGroup(), FrontendTimer(), ModuleManager(null), ModuleDepCollector(), ThePCHContainerOperations(std::move(PCHContainerOps)), TheDependencyFileGenerator(), DependencyCollectors(), KnownModules(), LastModuleImportLoc(), LastModuleImportResult(), BuildGlobalModuleIndex(false), HaveFullGlobalModuleIndex(false), ModuleBuildFailed(false), NonSeekStream(), OutputFiles() 
    //START JInit
    super(BuildingModule);
    this.Invocation = new IntrusiveRefCntPtr<CompilerInvocation>(new CompilerInvocation());
    this.Diagnostics = new IntrusiveRefCntPtr<DiagnosticsEngine>();
    this.Target = new IntrusiveRefCntPtr<TargetInfo>();
    this.AuxTarget = new IntrusiveRefCntPtr<TargetInfo>();
    this.VirtualFileSystem = new IntrusiveRefCntPtr<FileSystem>();
    this.FileMgr = new IntrusiveRefCntPtr<FileManager>();
    this.SourceMgr = new IntrusiveRefCntPtr<SourceManager>();
    this.PP = new IntrusiveRefCntPtr<Preprocessor>();
    this.Context = new IntrusiveRefCntPtr<ASTContext>();
    this.Consumer = new std.unique_ptr<ASTConsumer>();
    this.CompletionConsumer = new std.unique_ptr<CodeCompleteConsumer>();
    this.TheSema = new std.unique_ptr<Sema>();
    this.FrontendTimerGroup = new std.unique_ptr<TimerGroup>();
    this.FrontendTimer = new std.unique_ptr<Timer>();
    this.ModuleManager = new IntrusiveRefCntPtr<ASTReader>((ASTReader /*P*/ )null);
    this.ModuleDepCollector = new std.shared_ptr<ModuleDependencyCollector>();
    this.ThePCHContainerOperations = new std.shared_ptr<PCHContainerOperations>(JD$Move.INSTANCE, std.move(PCHContainerOps));
    this.TheDependencyFileGenerator = new std.unique_ptr<DependencyFileGenerator>();
    this.DependencyCollectors = new std.vector<std.shared_ptr<DependencyCollector>>(new std.shared_ptr<DependencyCollector>());
    this.KnownModules = new DenseMap</*const*/ IdentifierInfo /*P*/ , Module /*P*/ >(IdentifierInfo.DMI$IdentifierInfoPtr, (Module)null);
    this.LastModuleImportLoc = new SourceLocation();
    this.LastModuleImportResult = new ModuleLoadResult();
    this.BuildGlobalModuleIndex = false;
    this.HaveFullGlobalModuleIndex = false;
    this.ModuleBuildFailed = false;
    this.NonSeekStream = new std.unique_ptr<raw_fd_ostream>();
    this.OutputFiles = new std.list<OutputFile>(new OutputFile());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::~CompilerInstance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 64,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 62,
   FQN="clang::CompilerInstance::~CompilerInstance", NM="_ZN5clang16CompilerInstanceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstanceD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    assert (OutputFiles.empty()) : "Still output files in flight?";
    //START JDestroy
    OutputFiles.$destroy();
    NonSeekStream.$destroy();
    KnownModules.$destroy();
    DependencyCollectors.$destroy();
    TheDependencyFileGenerator.$destroy();
    ThePCHContainerOperations.$destroy();
    ModuleDepCollector.$destroy();
    ModuleManager.$destroy();
    FrontendTimer.$destroy();
    FrontendTimerGroup.$destroy();
    TheSema.$destroy();
    CompletionConsumer.$destroy();
    Consumer.$destroy();
    Context.$destroy();
    PP.$destroy();
    SourceMgr.$destroy();
    FileMgr.$destroy();
    VirtualFileSystem.$destroy();
    AuxTarget.$destroy();
    Target.$destroy();
    Diagnostics.$destroy();
    Invocation.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  /// @name High-Level Operations
  /// {
  
  /// ExecuteAction - Execute the provided action against the compiler's
  /// CompilerInvocation object.
  ///
  /// This function makes the following assumptions:
  ///
  ///  - The invocation options should be initialized. This function does not
  ///    handle the '-help' or '-version' options, clients should handle those
  ///    directly.
  ///
  ///  - The diagnostics engine should have already been created by the client.
  ///
  ///  - No other CompilerInstance state should have been initialized (this is
  ///    an unchecked error).
  ///
  ///  - Clients should have initialized any LLVM target features that may be
  ///    required.
  ///
  ///  - Clients should eventually call llvm_shutdown() upon the completion of
  ///    this routine to ensure that any managed objects are properly destroyed.
  ///
  /// Note that this routine may write output to 'stderr'.
  ///
  /// \param Act - The action to execute.
  /// \return - True on success.
  //
  // FIXME: This function should take the stream to write any debugging /
  // verbose output to as an argument.
  //
  // FIXME: Eliminate the llvm_shutdown requirement, that should either be part
  // of the context or else not CompilerInstance specific.
  
  // High-Level Operations
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::ExecuteAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 815,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 789,
   FQN="clang::CompilerInstance::ExecuteAction", NM="_ZN5clang16CompilerInstance13ExecuteActionERNS_14FrontendActionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance13ExecuteActionERNS_14FrontendActionE")
  //</editor-fold>
  public boolean ExecuteAction(FrontendAction /*&*/ Act) {
    assert (hasDiagnostics()) : "Diagnostics engine is not initialized!";
    assert (!getFrontendOpts().ShowHelp) : "Client must handle '-help'!";
    assert (!getFrontendOpts().ShowVersion) : "Client must handle '-version'!";
    
    // FIXME: Take this as an argument, once all the APIs we used have moved to
    // taking it as an input instead of hard-coding llvm::errs.
    raw_ostream /*&*/ OS = llvm.errs();
    
    // Create the target instance.
    setTarget(TargetInfo.CreateTargetInfo(getDiagnostics(), 
            getInvocation().TargetOpts));
    if (!hasTarget()) {
      return false;
    }
    
    // Create TargetInfo for the other side of CUDA compilation.
    if (getLangOpts().CUDA && !getFrontendOpts().AuxTriple.empty()) {
      shared_ptr<TargetOptions> TO = null;
      try {
        TO = std.make_shared(new TargetOptions());
        TO.$arrow().Triple.$assign(getFrontendOpts().AuxTriple);
        TO.$arrow().HostTriple.$assign(getTarget().getTriple().str());
        setAuxTarget(TargetInfo.CreateTargetInfo(getDiagnostics(), TO));
      } finally {
        if (TO != null) { TO.$destroy(); }
      }
    }
    
    // Inform the target of the language options.
    //
    // FIXME: We shouldn't need to do this, the target should be immutable once
    // created. This complexity should be lifted elsewhere.
    getTarget().adjust(getLangOpts());
    
    // rewriter project will change target built-in bool type from its default. 
    if (getFrontendOpts().ProgramAction == frontend.ActionKind.RewriteObjC) {
      getTarget().noSignedCharForObjCBool();
    }
    
    // Validate/process some options.
    if (getHeaderSearchOpts().Verbose) {
      OS.$out(/*KEEP_STR*/"clang -cc1 version 3.9.0").$out(
          /*KEEP_STR*/" based upon "
      ).$out(/*KEEP_STR*/"LLVM 3.9.0").$out(
          /*KEEP_STR*/" default target "
      ).$out(sys.getDefaultTargetTriple()).$out(/*KEEP_STR*/$LF);
    }
    if (getFrontendOpts().ShowTimers) {
      createFrontendTimer();
    }
    if (getFrontendOpts().ShowStats) {
      llvm.EnableStatistics();
    }
    
    for (/*const*/ FrontendInputFile /*&*/ FIF : getFrontendOpts().Inputs) {
      // Reset the ID tables if we are reusing the SourceManager and parsing
      // regular files.
      if (hasSourceManager() && !Act.isModelParsingAction()) {
        getSourceManager().clearIDTables();
      }
      if (Act.BeginSourceFile(/*Deref*/this, FIF)) {
        Act.Execute();
        Act.EndSourceFile();
      }
    }
    
    // Notify the diagnostic client that all files were processed.
    getDiagnostics().getClient().finish();
    if (getDiagnosticOpts().ShowCarets) {
      // We can have multiple diagnostics sharing one diagnostic client.
      // Get the total number of warnings/errors from the client.
      /*uint*/int NumWarnings = getDiagnostics().getClient().getNumWarnings();
      /*uint*/int NumErrors = getDiagnostics().getClient().getNumErrors();
      if ((NumWarnings != 0)) {
        OS.$out_uint(NumWarnings).$out(/*KEEP_STR*/" warning").$out((NumWarnings == 1 ? $EMPTY : $s));
      }
      if ((NumWarnings != 0) && (NumErrors != 0)) {
        OS.$out(/*KEEP_STR*/" and ");
      }
      if ((NumErrors != 0)) {
        OS.$out_uint(NumErrors).$out(/*KEEP_STR*/" error").$out((NumErrors == 1 ? $EMPTY : $s));
      }
      if ((NumWarnings != 0) || (NumErrors != 0)) {
        OS.$out(/*KEEP_STR*/" generated.\n");
      }
    }
    if (getFrontendOpts().ShowStats && hasFileManager()) {
      getFileManager().PrintStats();
      OS.$out(/*KEEP_STR*/$LF);
    }
    
    return !(getDiagnostics().getClient().getNumErrors() != 0);
  }

  
  /// }
  /// @name Compiler Invocation and Options
  /// {
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::hasInvocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 220,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 225,
   FQN="clang::CompilerInstance::hasInvocation", NM="_ZNK5clang16CompilerInstance13hasInvocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance13hasInvocationEv")
  //</editor-fold>
  public boolean hasInvocation() /*const*/ {
    return $noteq_IntrusiveRefCntPtr$T$C_nullptr_t(Invocation, null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getInvocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 222,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 227,
   FQN="clang::CompilerInstance::getInvocation", NM="_ZN5clang16CompilerInstance13getInvocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance13getInvocationEv")
  //</editor-fold>
  public CompilerInvocation /*&*/ getInvocation() {
    assert (Invocation.$bool()) : "Compiler instance has no invocation!";
    return Invocation.$star();
  }

  
  /// setInvocation - Replace the current invocation.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::setInvocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 68,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 66,
   FQN="clang::CompilerInstance::setInvocation", NM="_ZN5clang16CompilerInstance13setInvocationEPNS_18CompilerInvocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance13setInvocationEPNS_18CompilerInvocationE")
  //</editor-fold>
  public void setInvocation(CompilerInvocation /*P*/ Value) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(Invocation.$assign($c$.track(new IntrusiveRefCntPtr<CompilerInvocation>(Value))));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Indicates whether we should (re)build the global module index.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::shouldBuildGlobalModuleIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 72,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 70,
   FQN="clang::CompilerInstance::shouldBuildGlobalModuleIndex", NM="_ZNK5clang16CompilerInstance28shouldBuildGlobalModuleIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance28shouldBuildGlobalModuleIndexEv")
  //</editor-fold>
  public boolean shouldBuildGlobalModuleIndex() /*const*/ {
    return (BuildGlobalModuleIndex
       || (ModuleManager.$bool() && ModuleManager.$arrow().isGlobalIndexUnavailable()
       && getFrontendOpts$Const().GenerateGlobalModuleIndex))
       && !ModuleBuildFailed;
  }

  
  /// \brief Set the flag indicating whether we should (re)build the global
  /// module index.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::setBuildGlobalModuleIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 235,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 240,
   FQN="clang::CompilerInstance::setBuildGlobalModuleIndex", NM="_ZN5clang16CompilerInstance25setBuildGlobalModuleIndexEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance25setBuildGlobalModuleIndexEb")
  //</editor-fold>
  public void setBuildGlobalModuleIndex(boolean Build) {
    BuildGlobalModuleIndex = Build;
  }

  
  /// }
  /// @name Forwarding Methods
  /// {
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getAnalyzerOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 243,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 248,
   FQN="clang::CompilerInstance::getAnalyzerOpts", NM="_ZN5clang16CompilerInstance15getAnalyzerOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance15getAnalyzerOptsEv")
  //</editor-fold>
  public IntrusiveRefCntPtr<AnalyzerOptions> getAnalyzerOpts() {
    return Invocation.$arrow().getAnalyzerOpts();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getCodeGenOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 247,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 252,
   FQN="clang::CompilerInstance::getCodeGenOpts", NM="_ZN5clang16CompilerInstance14getCodeGenOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance14getCodeGenOptsEv")
  //</editor-fold>
  public CodeGenOptions /*&*/ getCodeGenOpts() {
    return Invocation.$arrow().getCodeGenOpts();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getCodeGenOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 250,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 255,
   FQN="clang::CompilerInstance::getCodeGenOpts", NM="_ZNK5clang16CompilerInstance14getCodeGenOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance14getCodeGenOptsEv")
  //</editor-fold>
  public /*const*/ CodeGenOptions /*&*/ getCodeGenOpts$Const() /*const*/ {
    return Invocation.$arrow().getCodeGenOpts();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getDependencyOutputOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 254,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 259,
   FQN="clang::CompilerInstance::getDependencyOutputOpts", NM="_ZN5clang16CompilerInstance23getDependencyOutputOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance23getDependencyOutputOptsEv")
  //</editor-fold>
  public DependencyOutputOptions /*&*/ getDependencyOutputOpts() {
    return Invocation.$arrow().getDependencyOutputOpts();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getDependencyOutputOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 257,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 262,
   FQN="clang::CompilerInstance::getDependencyOutputOpts", NM="_ZNK5clang16CompilerInstance23getDependencyOutputOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance23getDependencyOutputOptsEv")
  //</editor-fold>
  public /*const*/ DependencyOutputOptions /*&*/ getDependencyOutputOpts$Const() /*const*/ {
    return Invocation.$arrow().getDependencyOutputOpts();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getDiagnosticOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 261,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 266,
   FQN="clang::CompilerInstance::getDiagnosticOpts", NM="_ZN5clang16CompilerInstance17getDiagnosticOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance17getDiagnosticOptsEv")
  //</editor-fold>
  public DiagnosticOptions /*&*/ getDiagnosticOpts() {
    return Invocation.$arrow().getDiagnosticOpts();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getDiagnosticOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 264,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 269,
   FQN="clang::CompilerInstance::getDiagnosticOpts", NM="_ZNK5clang16CompilerInstance17getDiagnosticOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance17getDiagnosticOptsEv")
  //</editor-fold>
  public /*const*/ DiagnosticOptions /*&*/ getDiagnosticOpts$Const() /*const*/ {
    return Invocation.$arrow().getDiagnosticOpts();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getFileSystemOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 268,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 273,
   FQN="clang::CompilerInstance::getFileSystemOpts", NM="_ZN5clang16CompilerInstance17getFileSystemOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance17getFileSystemOptsEv")
  //</editor-fold>
  public FileSystemOptions /*&*/ getFileSystemOpts() {
    return Invocation.$arrow().getFileSystemOpts();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getFileSystemOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 271,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 276,
   FQN="clang::CompilerInstance::getFileSystemOpts", NM="_ZNK5clang16CompilerInstance17getFileSystemOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance17getFileSystemOptsEv")
  //</editor-fold>
  public /*const*/ FileSystemOptions /*&*/ getFileSystemOpts$Const() /*const*/ {
    return Invocation.$arrow().getFileSystemOpts();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getFrontendOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 275,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 280,
   FQN="clang::CompilerInstance::getFrontendOpts", NM="_ZN5clang16CompilerInstance15getFrontendOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance15getFrontendOptsEv")
  //</editor-fold>
  public FrontendOptions /*&*/ getFrontendOpts() {
    return Invocation.$arrow().getFrontendOpts();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getFrontendOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 278,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 283,
   FQN="clang::CompilerInstance::getFrontendOpts", NM="_ZNK5clang16CompilerInstance15getFrontendOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance15getFrontendOptsEv")
  //</editor-fold>
  public /*const*/ FrontendOptions /*&*/ getFrontendOpts$Const() /*const*/ {
    return Invocation.$arrow().getFrontendOpts();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getHeaderSearchOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 282,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 287,
   FQN="clang::CompilerInstance::getHeaderSearchOpts", NM="_ZN5clang16CompilerInstance19getHeaderSearchOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance19getHeaderSearchOptsEv")
  //</editor-fold>
  public HeaderSearchOptions /*&*/ getHeaderSearchOpts() {
    return Invocation.$arrow().getHeaderSearchOpts();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getHeaderSearchOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 285,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 290,
   FQN="clang::CompilerInstance::getHeaderSearchOpts", NM="_ZNK5clang16CompilerInstance19getHeaderSearchOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance19getHeaderSearchOptsEv")
  //</editor-fold>
  public /*const*/ HeaderSearchOptions /*&*/ getHeaderSearchOpts$Const() /*const*/ {
    return Invocation.$arrow().getHeaderSearchOpts();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getLangOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 289,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 294,
   FQN="clang::CompilerInstance::getLangOpts", NM="_ZN5clang16CompilerInstance11getLangOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance11getLangOptsEv")
  //</editor-fold>
  public LangOptions /*&*/ getLangOpts() {
    return /*Deref*/Invocation.$arrow().getLangOpts();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getLangOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 292,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 297,
   FQN="clang::CompilerInstance::getLangOpts", NM="_ZNK5clang16CompilerInstance11getLangOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance11getLangOptsEv")
  //</editor-fold>
  public /*const*/ LangOptions /*&*/ getLangOpts$Const() /*const*/ {
    return /*Deref*/Invocation.$arrow().getLangOpts();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getPreprocessorOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 296,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 301,
   FQN="clang::CompilerInstance::getPreprocessorOpts", NM="_ZN5clang16CompilerInstance19getPreprocessorOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance19getPreprocessorOptsEv")
  //</editor-fold>
  public PreprocessorOptions /*&*/ getPreprocessorOpts() {
    return Invocation.$arrow().getPreprocessorOpts();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getPreprocessorOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 299,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 304,
   FQN="clang::CompilerInstance::getPreprocessorOpts", NM="_ZNK5clang16CompilerInstance19getPreprocessorOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance19getPreprocessorOptsEv")
  //</editor-fold>
  public /*const*/ PreprocessorOptions /*&*/ getPreprocessorOpts$Const() /*const*/ {
    return Invocation.$arrow().getPreprocessorOpts();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getPreprocessorOutputOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 303,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 308,
   FQN="clang::CompilerInstance::getPreprocessorOutputOpts", NM="_ZN5clang16CompilerInstance25getPreprocessorOutputOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance25getPreprocessorOutputOptsEv")
  //</editor-fold>
  public PreprocessorOutputOptions /*&*/ getPreprocessorOutputOpts() {
    return Invocation.$arrow().getPreprocessorOutputOpts();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getPreprocessorOutputOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 306,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 311,
   FQN="clang::CompilerInstance::getPreprocessorOutputOpts", NM="_ZNK5clang16CompilerInstance25getPreprocessorOutputOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance25getPreprocessorOutputOptsEv")
  //</editor-fold>
  public /*const*/ PreprocessorOutputOptions /*&*/ getPreprocessorOutputOpts$Const() /*const*/ {
    return Invocation.$arrow().getPreprocessorOutputOpts();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getTargetOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 310,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 315,
   FQN="clang::CompilerInstance::getTargetOpts", NM="_ZN5clang16CompilerInstance13getTargetOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance13getTargetOptsEv")
  //</editor-fold>
  public TargetOptions /*&*/ getTargetOpts() {
    return Invocation.$arrow().getTargetOpts();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getTargetOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 313,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 318,
   FQN="clang::CompilerInstance::getTargetOpts", NM="_ZNK5clang16CompilerInstance13getTargetOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance13getTargetOptsEv")
  //</editor-fold>
  public /*const*/ TargetOptions /*&*/ getTargetOpts$Const() /*const*/ {
    return Invocation.$arrow().getTargetOpts();
  }

  
  /// }
  /// @name Diagnostics Engine
  /// {
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::hasDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 321,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 326,
   FQN="clang::CompilerInstance::hasDiagnostics", NM="_ZNK5clang16CompilerInstance14hasDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance14hasDiagnosticsEv")
  //</editor-fold>
  public boolean hasDiagnostics() /*const*/ {
    return $noteq_IntrusiveRefCntPtr$T$C_nullptr_t(Diagnostics, null);
  }

  
  /// Get the current diagnostics engine.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 324,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 329,
   FQN="clang::CompilerInstance::getDiagnostics", NM="_ZNK5clang16CompilerInstance14getDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance14getDiagnosticsEv")
  //</editor-fold>
  public DiagnosticsEngine /*&*/ getDiagnostics() /*const*/ {
    assert (Diagnostics.$bool()) : "Compiler instance has no diagnostics!";
    return Diagnostics.$star();
  }

  
  /// setDiagnostics - Replace the current diagnostics engine.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::setDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 79,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 77,
   FQN="clang::CompilerInstance::setDiagnostics", NM="_ZN5clang16CompilerInstance14setDiagnosticsEPNS_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance14setDiagnosticsEPNS_17DiagnosticsEngineE")
  //</editor-fold>
  public void setDiagnostics(DiagnosticsEngine /*P*/ Value) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(Diagnostics.$assign($c$.track(new IntrusiveRefCntPtr<DiagnosticsEngine>(Value))));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getDiagnosticClient">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 332,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 337,
   FQN="clang::CompilerInstance::getDiagnosticClient", NM="_ZNK5clang16CompilerInstance19getDiagnosticClientEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance19getDiagnosticClientEv")
  //</editor-fold>
  public DiagnosticConsumer /*&*/ getDiagnosticClient() /*const*/ {
    assert (Diagnostics.$bool() && (Diagnostics.$arrow().getClient() != null)) : "Compiler instance has no diagnostic client!";
    return /*Deref*/Diagnostics.$arrow().getClient();
  }

  
  /// }
  /// @name Target Info
  /// {
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::hasTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 342,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 347,
   FQN="clang::CompilerInstance::hasTarget", NM="_ZNK5clang16CompilerInstance9hasTargetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance9hasTargetEv")
  //</editor-fold>
  public boolean hasTarget() /*const*/ {
    return $noteq_IntrusiveRefCntPtr$T$C_nullptr_t(Target, null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 344,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 349,
   FQN="clang::CompilerInstance::getTarget", NM="_ZNK5clang16CompilerInstance9getTargetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance9getTargetEv")
  //</editor-fold>
  public TargetInfo /*&*/ getTarget() /*const*/ {
    assert (Target.$bool()) : "Compiler instance has no target!";
    return Target.$star();
  }

  
  /// Replace the current Target.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::setTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 83,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 81,
   FQN="clang::CompilerInstance::setTarget", NM="_ZN5clang16CompilerInstance9setTargetEPNS_10TargetInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance9setTargetEPNS_10TargetInfoE")
  //</editor-fold>
  public void setTarget(TargetInfo /*P*/ Value) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(Target.$assign($c$.track(new IntrusiveRefCntPtr<TargetInfo>(Value))));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// }
  /// @name AuxTarget Info
  /// {
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getAuxTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 356,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 361,
   FQN="clang::CompilerInstance::getAuxTarget", NM="_ZNK5clang16CompilerInstance12getAuxTargetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance12getAuxTargetEv")
  //</editor-fold>
  public TargetInfo /*P*/ getAuxTarget() /*const*/ {
    return AuxTarget.get();
  }

  
  /// Replace the current AuxTarget.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::setAuxTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 84,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 82,
   FQN="clang::CompilerInstance::setAuxTarget", NM="_ZN5clang16CompilerInstance12setAuxTargetEPNS_10TargetInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance12setAuxTargetEPNS_10TargetInfoE")
  //</editor-fold>
  public void setAuxTarget(TargetInfo /*P*/ Value) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(AuxTarget.$assign($c$.track(new IntrusiveRefCntPtr<TargetInfo>(Value))));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// }
  /// @name Virtual File System
  /// {
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::hasVirtualFileSystem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 365,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 370,
   FQN="clang::CompilerInstance::hasVirtualFileSystem", NM="_ZNK5clang16CompilerInstance20hasVirtualFileSystemEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance20hasVirtualFileSystemEv")
  //</editor-fold>
  public boolean hasVirtualFileSystem() /*const*/ {
    return $noteq_IntrusiveRefCntPtr$T$C_nullptr_t(VirtualFileSystem, null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getVirtualFileSystem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 367,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 372,
   FQN="clang::CompilerInstance::getVirtualFileSystem", NM="_ZNK5clang16CompilerInstance20getVirtualFileSystemEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance20getVirtualFileSystemEv")
  //</editor-fold>
  public FileSystem /*&*/ getVirtualFileSystem() /*const*/ {
    assert (hasVirtualFileSystem()) : "Compiler instance has no virtual file system";
    return VirtualFileSystem.$star();
  }

  
  /// \brief Replace the current virtual file system.
  ///
  /// \note Most clients should use setFileManager, which will implicitly reset
  /// the virtual file system to the one contained in the file manager.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::setVirtualFileSystem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 377,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 382,
   FQN="clang::CompilerInstance::setVirtualFileSystem", NM="_ZN5clang16CompilerInstance20setVirtualFileSystemEN4llvm18IntrusiveRefCntPtrINS_3vfs10FileSystemEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance20setVirtualFileSystemEN4llvm18IntrusiveRefCntPtrINS_3vfs10FileSystemEEE")
  //</editor-fold>
  public void setVirtualFileSystem(IntrusiveRefCntPtr<FileSystem> FS) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(VirtualFileSystem.$assign($c$.track(new IntrusiveRefCntPtr<FileSystem>(JD$Move.INSTANCE, std.move(FS)))));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// }
  /// @name File Manager
  /// {
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::hasFileManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 385,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 390,
   FQN="clang::CompilerInstance::hasFileManager", NM="_ZNK5clang16CompilerInstance14hasFileManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance14hasFileManagerEv")
  //</editor-fold>
  public boolean hasFileManager() /*const*/ {
    return $noteq_IntrusiveRefCntPtr$T$C_nullptr_t(FileMgr, null);
  }

  
  /// Return the current file manager to the caller.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getFileManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 388,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 393,
   FQN="clang::CompilerInstance::getFileManager", NM="_ZNK5clang16CompilerInstance14getFileManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance14getFileManagerEv")
  //</editor-fold>
  public FileManager /*&*/ getFileManager() /*const*/ {
    assert (FileMgr.$bool()) : "Compiler instance has no file manager!";
    return FileMgr.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::resetAndLeakFileManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 393,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 398,
   FQN="clang::CompilerInstance::resetAndLeakFileManager", NM="_ZN5clang16CompilerInstance23resetAndLeakFileManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance23resetAndLeakFileManagerEv")
  //</editor-fold>
  public void resetAndLeakFileManager() {
    BuryPointer(FileMgr.get());
    FileMgr.resetWithoutRelease();
  }

  
  /// \brief Replace the current file manager and virtual file system.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::setFileManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 86,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 84,
   FQN="clang::CompilerInstance::setFileManager", NM="_ZN5clang16CompilerInstance14setFileManagerEPNS_11FileManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance14setFileManagerEPNS_11FileManagerE")
  //</editor-fold>
  public void setFileManager(FileManager /*P*/ Value) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(FileMgr.$assign($c$.track(new IntrusiveRefCntPtr<FileManager>(Value))));
      if ((Value != null)) {
        $c$.clean(VirtualFileSystem.$assign($c$.track(Value.getVirtualFileSystem())));
      } else {
        VirtualFileSystem.reset();
      }
    } finally {
      $c$.$destroy();
    }
  }

  
  /// }
  /// @name Source Manager
  /// {
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::hasSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 405,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 410,
   FQN="clang::CompilerInstance::hasSourceManager", NM="_ZNK5clang16CompilerInstance16hasSourceManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance16hasSourceManagerEv")
  //</editor-fold>
  public boolean hasSourceManager() /*const*/ {
    return $noteq_IntrusiveRefCntPtr$T$C_nullptr_t(SourceMgr, null);
  }

  
  /// Return the current source manager.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 408,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 413,
   FQN="clang::CompilerInstance::getSourceManager", NM="_ZNK5clang16CompilerInstance16getSourceManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance16getSourceManagerEv")
  //</editor-fold>
  public SourceManager /*&*/ getSourceManager() /*const*/ {
    assert (SourceMgr.$bool()) : "Compiler instance has no source manager!";
    return SourceMgr.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::resetAndLeakSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 413,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 418,
   FQN="clang::CompilerInstance::resetAndLeakSourceManager", NM="_ZN5clang16CompilerInstance25resetAndLeakSourceManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance25resetAndLeakSourceManagerEv")
  //</editor-fold>
  public void resetAndLeakSourceManager() {
    BuryPointer(SourceMgr.get());
    SourceMgr.resetWithoutRelease();
  }

  
  /// setSourceManager - Replace the current source manager.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::setSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 94,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 92,
   FQN="clang::CompilerInstance::setSourceManager", NM="_ZN5clang16CompilerInstance16setSourceManagerEPNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance16setSourceManagerEPNS_13SourceManagerE")
  //</editor-fold>
  public void setSourceManager(SourceManager /*P*/ Value) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SourceMgr.$assign($c$.track(new IntrusiveRefCntPtr<SourceManager>(Value))));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// }
  /// @name Preprocessor
  /// {
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::hasPreprocessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 425,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 430,
   FQN="clang::CompilerInstance::hasPreprocessor", NM="_ZNK5clang16CompilerInstance15hasPreprocessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance15hasPreprocessorEv")
  //</editor-fold>
  public boolean hasPreprocessor() /*const*/ {
    return $noteq_IntrusiveRefCntPtr$T$C_nullptr_t(PP, null);
  }

  
  /// Return the current preprocessor.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getPreprocessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 428,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 433,
   FQN="clang::CompilerInstance::getPreprocessor", NM="_ZNK5clang16CompilerInstance15getPreprocessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance15getPreprocessorEv")
  //</editor-fold>
  public Preprocessor /*&*/ getPreprocessor() /*const*/ {
    assert (PP.$bool()) : "Compiler instance has no preprocessor!";
    return PP.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::resetAndLeakPreprocessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 433,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 438,
   FQN="clang::CompilerInstance::resetAndLeakPreprocessor", NM="_ZN5clang16CompilerInstance24resetAndLeakPreprocessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance24resetAndLeakPreprocessorEv")
  //</editor-fold>
  public void resetAndLeakPreprocessor() {
    BuryPointer(PP.get());
    PP.resetWithoutRelease();
  }

  
  /// Replace the current preprocessor.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::setPreprocessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 98,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 96,
   FQN="clang::CompilerInstance::setPreprocessor", NM="_ZN5clang16CompilerInstance15setPreprocessorEPNS_12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance15setPreprocessorEPNS_12PreprocessorE")
  //</editor-fold>
  public void setPreprocessor(Preprocessor /*P*/ Value) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(PP.$assign($c$.track(new IntrusiveRefCntPtr<Preprocessor>(Value))));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// }
  /// @name ASTContext
  /// {
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::hasASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 445,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 450,
   FQN="clang::CompilerInstance::hasASTContext", NM="_ZNK5clang16CompilerInstance13hasASTContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance13hasASTContextEv")
  //</editor-fold>
  public boolean hasASTContext() /*const*/ {
    return $noteq_IntrusiveRefCntPtr$T$C_nullptr_t(Context, null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 447,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 452,
   FQN="clang::CompilerInstance::getASTContext", NM="_ZNK5clang16CompilerInstance13getASTContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance13getASTContextEv")
  //</editor-fold>
  public ASTContext /*&*/ getASTContext() /*const*/ {
    assert (Context.$bool()) : "Compiler instance has no AST context!";
    return Context.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::resetAndLeakASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 452,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 457,
   FQN="clang::CompilerInstance::resetAndLeakASTContext", NM="_ZN5clang16CompilerInstance22resetAndLeakASTContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance22resetAndLeakASTContextEv")
  //</editor-fold>
  public void resetAndLeakASTContext() {
    BuryPointer(Context.get());
    Context.resetWithoutRelease();
  }

  
  /// setASTContext - Replace the current AST context.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::setASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 100,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 98,
   FQN="clang::CompilerInstance::setASTContext", NM="_ZN5clang16CompilerInstance13setASTContextEPNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance13setASTContextEPNS_10ASTContextE")
  //</editor-fold>
  public void setASTContext(ASTContext /*P*/ Value) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(Context.$assign($c$.track(new IntrusiveRefCntPtr<ASTContext>(Value))));
      if (Context.$bool() && Consumer.$bool()) {
        getASTConsumer().Initialize(getASTContext());
      }
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Replace the current Sema; the compiler instance takes ownership
  /// of S.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::setSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 107,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 105,
   FQN="clang::CompilerInstance::setSema", NM="_ZN5clang16CompilerInstance7setSemaEPNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance7setSemaEPNS_4SemaE")
  //</editor-fold>
  public void setSema(Sema /*P*/ S) {
    TheSema.reset(S);
  }

  
  /// }
  /// @name ASTConsumer
  /// {
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::hasASTConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 468,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 473,
   FQN="clang::CompilerInstance::hasASTConsumer", NM="_ZNK5clang16CompilerInstance14hasASTConsumerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance14hasASTConsumerEv")
  //</editor-fold>
  public boolean hasASTConsumer() /*const*/ {
    return (boolean)Consumer.$bool();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getASTConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 470,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 475,
   FQN="clang::CompilerInstance::getASTConsumer", NM="_ZNK5clang16CompilerInstance14getASTConsumerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance14getASTConsumerEv")
  //</editor-fold>
  public ASTConsumer /*&*/ getASTConsumer() /*const*/ {
    assert (Consumer.$bool()) : "Compiler instance has no AST consumer!";
    return Consumer.$star();
  }

  
  /// takeASTConsumer - Remove the current AST consumer and give ownership to
  /// the caller.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::takeASTConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 477,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 482,
   FQN="clang::CompilerInstance::takeASTConsumer", NM="_ZN5clang16CompilerInstance15takeASTConsumerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance15takeASTConsumerEv")
  //</editor-fold>
  public std.unique_ptr<ASTConsumer> takeASTConsumer() {
    return new std.unique_ptr<ASTConsumer>(JD$Move.INSTANCE, std.move(Consumer));
  }

  
  /// setASTConsumer - Replace the current AST consumer; the compiler instance
  /// takes ownership of \p Value.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::setASTConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 111,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 109,
   FQN="clang::CompilerInstance::setASTConsumer", NM="_ZN5clang16CompilerInstance14setASTConsumerESt10unique_ptrINS_11ASTConsumerESt14default_deleteIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance14setASTConsumerESt10unique_ptrINS_11ASTConsumerESt14default_deleteIS2_EE")
  //</editor-fold>
  public void setASTConsumer(std.unique_ptr<ASTConsumer> Value) {
    Consumer.$assignMove(std.move(Value));
    if (Context.$bool() && Consumer.$bool()) {
      getASTConsumer().Initialize(getASTContext());
    }
  }

  
  /// }
  /// @name Semantic analysis
  /// {
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::hasSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 486,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 491,
   FQN="clang::CompilerInstance::hasSema", NM="_ZNK5clang16CompilerInstance7hasSemaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance7hasSemaEv")
  //</editor-fold>
  public boolean hasSema() /*const*/ {
    return (boolean)TheSema.$bool();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 488,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 493,
   FQN="clang::CompilerInstance::getSema", NM="_ZNK5clang16CompilerInstance7getSemaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance7getSemaEv")
  //</editor-fold>
  public Sema /*&*/ getSema() /*const*/ {
    assert (TheSema.$bool()) : "Compiler instance has no Sema object!";
    return TheSema.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::takeSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 122,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 120,
   FQN="clang::CompilerInstance::takeSema", NM="_ZN5clang16CompilerInstance8takeSemaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance8takeSemaEv")
  //</editor-fold>
  public std.unique_ptr<Sema> takeSema() {
    return new std.unique_ptr<Sema>(JD$Move.INSTANCE, std.move(TheSema));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::resetAndLeakSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 1751,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 1732,
   FQN="clang::CompilerInstance::resetAndLeakSema", NM="_ZN5clang16CompilerInstance16resetAndLeakSemaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance16resetAndLeakSemaEv")
  //</editor-fold>
  public void resetAndLeakSema() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      BuryPointer$T($c$.track(takeSema())); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  /// }
  /// @name Module Management
  /// {
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getModuleManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 126,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 124,
   FQN="clang::CompilerInstance::getModuleManager", NM="_ZNK5clang16CompilerInstance16getModuleManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance16getModuleManagerEv")
  //</editor-fold>
  public IntrusiveRefCntPtr<ASTReader> getModuleManager() /*const*/ {
    return new IntrusiveRefCntPtr<ASTReader>(ModuleManager);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::setModuleManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 129,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 127,
   FQN="clang::CompilerInstance::setModuleManager", NM="_ZN5clang16CompilerInstance16setModuleManagerEN4llvm18IntrusiveRefCntPtrINS_9ASTReaderEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance16setModuleManagerEN4llvm18IntrusiveRefCntPtrINS_9ASTReaderEEE")
  //</editor-fold>
  public void setModuleManager(IntrusiveRefCntPtr<ASTReader> Reader) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(ModuleManager.$assign($c$.track(new IntrusiveRefCntPtr<ASTReader>(JD$Move.INSTANCE, std.move(Reader)))));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getModuleDepCollector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 133,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 131,
   FQN="clang::CompilerInstance::getModuleDepCollector", NM="_ZNK5clang16CompilerInstance21getModuleDepCollectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance21getModuleDepCollectorEv")
  //</editor-fold>
  public std.shared_ptr<ModuleDependencyCollector> getModuleDepCollector() /*const*/ {
    return new std.shared_ptr<ModuleDependencyCollector>(ModuleDepCollector);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::setModuleDepCollector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 138,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 136,
   FQN="clang::CompilerInstance::setModuleDepCollector", NM="_ZN5clang16CompilerInstance21setModuleDepCollectorESt10shared_ptrINS_25ModuleDependencyCollectorEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance21setModuleDepCollectorESt10shared_ptrINS_25ModuleDependencyCollectorEE")
  //</editor-fold>
  public void setModuleDepCollector(std.shared_ptr<ModuleDependencyCollector> Collector) {
    ModuleDepCollector.$assignMove(std.move(Collector));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getPCHContainerOperations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 507,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 512,
   FQN="clang::CompilerInstance::getPCHContainerOperations", NM="_ZNK5clang16CompilerInstance25getPCHContainerOperationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance25getPCHContainerOperationsEv")
  //</editor-fold>
  public std.shared_ptr<PCHContainerOperations> getPCHContainerOperations() /*const*/ {
    return new std.shared_ptr<PCHContainerOperations>(ThePCHContainerOperations);
  }

  
  /// Return the appropriate PCHContainerWriter depending on the
  /// current CodeGenOptions.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getPCHContainerWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 513,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 518,
   FQN="clang::CompilerInstance::getPCHContainerWriter", NM="_ZNK5clang16CompilerInstance21getPCHContainerWriterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance21getPCHContainerWriterEv")
  //</editor-fold>
  public /*const*/ PCHContainerWriter /*&*/ getPCHContainerWriter() /*const*/ {
    assert (Invocation.$bool()) : "cannot determine module format without invocation";
    StringRef Format = new StringRef(getHeaderSearchOpts$Const().ModuleFormat);
    /*const*/ PCHContainerWriter /*P*/ Writer = ThePCHContainerOperations.$arrow().getWriterOrNull(new StringRef(Format));
    if (!(Writer != null)) {
      if (Diagnostics.$bool()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diagnostics.$arrow().Report(diag.err_module_format_unhandled)), /*NO_COPY*/Format));
        } finally {
          $c$.$destroy();
        }
      }
      llvm.report_fatal_error($("unknown module format"));
    }
    return /*Deref*/Writer;
  }

  
  /// Return the appropriate PCHContainerReader depending on the
  /// current CodeGenOptions.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getPCHContainerReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 527,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 532,
   FQN="clang::CompilerInstance::getPCHContainerReader", NM="_ZNK5clang16CompilerInstance21getPCHContainerReaderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance21getPCHContainerReaderEv")
  //</editor-fold>
  public /*const*/ PCHContainerReader /*&*/ getPCHContainerReader() /*const*/ {
    assert (Invocation.$bool()) : "cannot determine module format without invocation";
    StringRef Format = new StringRef(getHeaderSearchOpts$Const().ModuleFormat);
    /*const*/ PCHContainerReader /*P*/ Reader = ThePCHContainerOperations.$arrow().getReaderOrNull(new StringRef(Format));
    if (!(Reader != null)) {
      if (Diagnostics.$bool()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diagnostics.$arrow().Report(diag.err_module_format_unhandled)), /*NO_COPY*/Format));
        } finally {
          $c$.$destroy();
        }
      }
      llvm.report_fatal_error($("unknown module format"));
    }
    return /*Deref*/Reader;
  }

  
  /// }
  /// @name Code Completion
  /// {
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::hasCodeCompletionConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 543,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 548,
   FQN="clang::CompilerInstance::hasCodeCompletionConsumer", NM="_ZNK5clang16CompilerInstance25hasCodeCompletionConsumerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance25hasCodeCompletionConsumerEv")
  //</editor-fold>
  public boolean hasCodeCompletionConsumer() /*const*/ {
    return (boolean)CompletionConsumer.$bool();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getCodeCompletionConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 545,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 550,
   FQN="clang::CompilerInstance::getCodeCompletionConsumer", NM="_ZNK5clang16CompilerInstance25getCodeCompletionConsumerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance25getCodeCompletionConsumerEv")
  //</editor-fold>
  public CodeCompleteConsumer /*&*/ getCodeCompletionConsumer() /*const*/ {
    assert (CompletionConsumer.$bool()) : "Compiler instance has no code completion consumer!";
    return CompletionConsumer.$star();
  }

  
  /// setCodeCompletionConsumer - Replace the current code completion consumer;
  /// the compiler instance takes ownership of \p Value.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::setCodeCompletionConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 118,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 116,
   FQN="clang::CompilerInstance::setCodeCompletionConsumer", NM="_ZN5clang16CompilerInstance25setCodeCompletionConsumerEPNS_20CodeCompleteConsumerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance25setCodeCompletionConsumerEPNS_20CodeCompleteConsumerE")
  //</editor-fold>
  public void setCodeCompletionConsumer(CodeCompleteConsumer /*P*/ Value) {
    CompletionConsumer.reset(Value);
  }

  
  /// }
  /// @name Frontend timer
  /// {
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::hasFrontendTimer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 559,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 564,
   FQN="clang::CompilerInstance::hasFrontendTimer", NM="_ZNK5clang16CompilerInstance16hasFrontendTimerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance16hasFrontendTimerEv")
  //</editor-fold>
  public boolean hasFrontendTimer() /*const*/ {
    return (boolean)FrontendTimer.$bool();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getFrontendTimer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 561,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 566,
   FQN="clang::CompilerInstance::getFrontendTimer", NM="_ZNK5clang16CompilerInstance16getFrontendTimerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance16getFrontendTimerEv")
  //</editor-fold>
  public Timer /*&*/ getFrontendTimer() /*const*/ {
    assert (FrontendTimer.$bool()) : "Compiler instance has no frontend timer!";
    return FrontendTimer.$star();
  }

  
  /// }
  /// @name Output Files
  /// {
  
  /// addOutputFile - Add an output file onto the list of tracked output files.
  ///
  /// \param OutFile - The output file info.
  
  // Output Files
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::addOutputFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 544,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 538,
   FQN="clang::CompilerInstance::addOutputFile", NM="_ZN5clang16CompilerInstance13addOutputFileEONS0_10OutputFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance13addOutputFileEONS0_10OutputFileE")
  //</editor-fold>
  public void addOutputFile(OutputFile /*&&*/OutFile) {
    OutputFiles.push_back_T$RR(std.move(OutFile));
  }

  
  /// clearOutputFiles - Clear the output file list. The underlying output
  /// streams must have been closed beforehand.
  ///
  /// \param EraseFiles - If true, attempt to erase the files from disk.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::clearOutputFiles">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 548,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 543,
   FQN="clang::CompilerInstance::clearOutputFiles", NM="_ZN5clang16CompilerInstance16clearOutputFilesEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance16clearOutputFilesEb")
  //</editor-fold>
  public void clearOutputFiles(boolean EraseFiles) {
    for (OutputFile /*&*/ OF : OutputFiles) {
      if (!OF.TempFilename.empty()) {
        if (EraseFiles) {
          fs.remove(new Twine(OF.TempFilename));
        } else {
          SmallString/*128*/ NewOutFile/*J*/= new SmallString/*128*/(new StringRef(OF.Filename), 128);
          
          // If '-working-directory' was passed, the output filename should be
          // relative to that.
          FileMgr.$arrow().FixupRelativePath(NewOutFile);
          {
            std.error_code ec = fs.rename(new Twine(OF.TempFilename), new Twine(NewOutFile));
            if (ec.$bool()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(getDiagnostics().Report(diag.err_unable_to_rename_temp)), 
                            new StringRef(OF.TempFilename)), new StringRef(OF.Filename)), new StringRef(ec.message())));
                
                fs.remove(new Twine(OF.TempFilename));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      } else if (!OF.Filename.empty() && EraseFiles) {
        fs.remove(new Twine(OF.Filename));
      }
    }
    OutputFiles.clear();
    NonSeekStream.reset();
  }

  
  /// }
  /// @name Construction Utility Methods
  /// {
  
  /// Create the diagnostics engine using the invocation's diagnostic options
  /// and replace any existing one with it.
  ///
  /// Note that this routine also replaces the diagnostic client,
  /// allocating one if one is not provided.
  ///
  /// \param Client If non-NULL, a diagnostic client that will be
  /// attached to (and, then, owned by) the DiagnosticsEngine inside this AST
  /// unit.
  ///
  /// \param ShouldOwnClient If Client is non-NULL, specifies whether 
  /// the diagnostic object should take ownership of the client.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::createDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 190,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 188,
   FQN="clang::CompilerInstance::createDiagnostics", NM="_ZN5clang16CompilerInstance17createDiagnosticsEPNS_18DiagnosticConsumerEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance17createDiagnosticsEPNS_18DiagnosticConsumerEb")
  //</editor-fold>
  public void createDiagnostics() {
    createDiagnostics((DiagnosticConsumer /*P*/ )null, 
                   true);
  }
  public void createDiagnostics(DiagnosticConsumer /*P*/ Client/*= null*/) {
    createDiagnostics(Client, 
                   true);
  }
  public void createDiagnostics(DiagnosticConsumer /*P*/ Client/*= null*/, 
                   boolean ShouldOwnClient/*= true*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(Diagnostics.$assign($c$.track(createDiagnostics(/*AddrOf*/getDiagnosticOpts(), Client, 
              ShouldOwnClient, /*AddrOf*/getCodeGenOpts()))));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Create a DiagnosticsEngine object with a the TextDiagnosticPrinter.
  ///
  /// If no diagnostic client is provided, this creates a
  /// DiagnosticConsumer that is owned by the returned diagnostic
  /// object, if using directly the caller is responsible for
  /// releasing the returned DiagnosticsEngine's client eventually.
  ///
  /// \param Opts - The diagnostic options; note that the created text
  /// diagnostic object contains a reference to these options.
  ///
  /// \param Client If non-NULL, a diagnostic client that will be
  /// attached to (and, then, owned by) the returned DiagnosticsEngine
  /// object.
  ///
  /// \param CodeGenOpts If non-NULL, the code gen options in use, which may be
  /// used by some diagnostics printers (for logging purposes only).
  ///
  /// \return The new object on success, or null on failure.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::createDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 196,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 194,
   FQN="clang::CompilerInstance::createDiagnostics", NM="_ZN5clang16CompilerInstance17createDiagnosticsEPNS_17DiagnosticOptionsEPNS_18DiagnosticConsumerEbPKNS_14CodeGenOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance17createDiagnosticsEPNS_17DiagnosticOptionsEPNS_18DiagnosticConsumerEbPKNS_14CodeGenOptionsE")
  //</editor-fold>
  public static IntrusiveRefCntPtr<DiagnosticsEngine> createDiagnostics(DiagnosticOptions /*P*/ Opts) {
    return createDiagnostics(Opts, 
                   (DiagnosticConsumer /*P*/ )null, 
                   true, 
                   (/*const*/ CodeGenOptions /*P*/ )null);
  }
  public static IntrusiveRefCntPtr<DiagnosticsEngine> createDiagnostics(DiagnosticOptions /*P*/ Opts, 
                   DiagnosticConsumer /*P*/ Client/*= null*/) {
    return createDiagnostics(Opts, 
                   Client, 
                   true, 
                   (/*const*/ CodeGenOptions /*P*/ )null);
  }
  public static IntrusiveRefCntPtr<DiagnosticsEngine> createDiagnostics(DiagnosticOptions /*P*/ Opts, 
                   DiagnosticConsumer /*P*/ Client/*= null*/, 
                   boolean ShouldOwnClient/*= true*/) {
    return createDiagnostics(Opts, 
                   Client, 
                   ShouldOwnClient, 
                   (/*const*/ CodeGenOptions /*P*/ )null);
  }
  public static IntrusiveRefCntPtr<DiagnosticsEngine> createDiagnostics(DiagnosticOptions /*P*/ Opts, 
                   DiagnosticConsumer /*P*/ Client/*= null*/, 
                   boolean ShouldOwnClient/*= true*/, 
                   /*const*/ CodeGenOptions /*P*/ CodeGenOpts/*= null*/) {
    IntrusiveRefCntPtr<DiagnosticIDs> DiagID = null;
    IntrusiveRefCntPtr<DiagnosticsEngine> Diags = null;
    try {
      DiagID/*J*/= new IntrusiveRefCntPtr<DiagnosticIDs>(new DiagnosticIDs());
      Diags/*J*/= new IntrusiveRefCntPtr<DiagnosticsEngine>(new DiagnosticsEngine(DiagID, Opts));
      
      // Create the diagnostic client for reporting errors or for
      // implementing -verify.
      if ((Client != null)) {
        Diags.$arrow().setClient(Client, ShouldOwnClient);
      } else {
        Diags.$arrow().setClient(new TextDiagnosticPrinter(llvm.errs(), Opts));
      }
      
      // Chain in -verify checker, if requested.
      if (Opts.VerifyDiagnostics) {
        Diags.$arrow().setClient(new VerifyDiagnosticConsumer(Diags.$star()));
      }
      
      // Chain in -diagnostic-log-file dumper, if requested.
      if (!Opts.DiagnosticLogFile.empty()) {
        SetUpDiagnosticLog(Opts, CodeGenOpts, Diags.$star());
      }
      if (!Opts.DiagnosticSerializationFile.empty()) {
        SetupSerializedDiagnostics(Opts, Diags.$star(), 
            new StringRef(Opts.DiagnosticSerializationFile));
      }
      
      // Configure our handling of diagnostics.
      ProcessWarningOptions(Diags.$star(), /*Deref*/Opts);
      
      return new IntrusiveRefCntPtr<DiagnosticsEngine>(JD$Move.INSTANCE, Diags);
    } finally {
      if (Diags != null) { Diags.$destroy(); }
      if (DiagID != null) { DiagID.$destroy(); }
    }
  }

  
  /// Create the file manager and replace any existing one with it.
  
  // File Manager
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::createFileManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 232,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 230,
   FQN="clang::CompilerInstance::createFileManager", NM="_ZN5clang16CompilerInstance17createFileManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance17createFileManagerEv")
  //</editor-fold>
  public void createFileManager() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!hasVirtualFileSystem()) {
        // TODO: choose the virtual file system based on the CompilerInvocation.
        setVirtualFileSystem($c$.track(VfsGlobals.getRealFileSystem())); $c$.clean();
      }
      $c$.clean(FileMgr.$assign($c$.track(new IntrusiveRefCntPtr<FileManager>(new FileManager(getFileSystemOpts(), $c$.track(new IntrusiveRefCntPtr<FileSystem>(VirtualFileSystem)))))));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Create the source manager and replace any existing one with it.
  
  // Source Manager
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::createSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 242,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 240,
   FQN="clang::CompilerInstance::createSourceManager", NM="_ZN5clang16CompilerInstance19createSourceManagerERNS_11FileManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance19createSourceManagerERNS_11FileManagerE")
  //</editor-fold>
  public void createSourceManager(FileManager /*&*/ FileMgr) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SourceMgr.$assign($c$.track(new IntrusiveRefCntPtr<SourceManager>(new SourceManager(getDiagnostics(), FileMgr)))));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Create the preprocessor, using the invocation, file, and source managers,
  /// and replace any existing one with it.
  
  // Preprocessor
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::createPreprocessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 298,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 296,
   FQN="clang::CompilerInstance::createPreprocessor", NM="_ZN5clang16CompilerInstance18createPreprocessorENS_19TranslationUnitKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance18createPreprocessorENS_19TranslationUnitKindE")
  //</editor-fold>
  public void createPreprocessor(TranslationUnitKind TUKind) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ PreprocessorOptions /*&*/ PPOpts = getPreprocessorOpts();
      
      // Create a PTH manager if we are using some form of a token cache.
      PTHManager /*P*/ PTHMgr = null;
      if (!PPOpts.TokenCache.empty()) {
        PTHMgr = PTHManager.Create(new StringRef(PPOpts.TokenCache), getDiagnostics());
      }
      
      // Create the Preprocessor.
      HeaderSearch /*P*/ HeaderInfo = $c$.clean(new HeaderSearch($c$.track(new IntrusiveRefCntPtr<HeaderSearchOptions>(/*AddrOf*/getHeaderSearchOpts())), 
          getSourceManager(), 
          getDiagnostics(), 
          getLangOpts(), 
          /*AddrOf*/getTarget()));
      $c$.clean(PP.$assign($c$.track(new IntrusiveRefCntPtr<Preprocessor>(new Preprocessor($c$.track(new IntrusiveRefCntPtr<PreprocessorOptions>(/*AddrOf*/getPreprocessorOpts())), getDiagnostics(), getLangOpts(), 
                  getSourceManager(), /*Deref*/HeaderInfo, /*Deref*/this, PTHMgr, 
                  /*OwnsHeaderSearch=*/ true, TUKind)))));
      PP.$arrow().Initialize(getTarget(), getAuxTarget());
      
      // Note that this is different then passing PTHMgr to Preprocessor's ctor.
      // That argument is used as the IdentifierInfoLookup argument to
      // IdentifierTable's ctor.
      if ((PTHMgr != null)) {
        PTHMgr.setPreprocessor(/*AddrOf*/PP.$star());
        PP.$arrow().setPTHManager(PTHMgr);
      }
      if (PPOpts.DetailedRecord) {
        PP.$arrow().createPreprocessingRecord();
      }
      
      // Apply remappings to the source manager.
      InitializeFileRemapping(PP.$arrow().getDiagnostics(), PP.$arrow().getSourceManager(), 
          PP.$arrow().getFileManager(), PPOpts);
      
      // Predefine macros and configure the preprocessor.
      InitializePreprocessor(PP.$star(), PPOpts, getPCHContainerReader(), 
          getFrontendOpts());
      
      // Initialize the header search object.
      ApplyHeaderSearchOptions(PP.$arrow().getHeaderSearchInfo(), getHeaderSearchOpts(), 
          PP.$arrow().getLangOpts(), PP.$arrow().getTargetInfo().getTriple());
      
      PP.$arrow().setPreprocessedOutput(getPreprocessorOutputOpts().ShowCPP);
      if (PP.$arrow().getLangOpts().Modules && PP.$arrow().getLangOpts().ImplicitModules) {
        PP.$arrow().getHeaderSearchInfo().setModuleCachePath(new StringRef(getSpecificModuleCachePath()));
      }
      
      // Handle generating dependencies, if requested.
      /*const*/ DependencyOutputOptions /*&*/ DepOpts = getDependencyOutputOpts();
      if (!DepOpts.OutputFile.empty()) {
        TheDependencyFileGenerator.reset(DependencyFileGenerator.CreateAndAttachToPreprocessor(PP.$star(), DepOpts));
      }
      if (!DepOpts.DOTOutputFile.empty()) {
        AttachDependencyGraphGen(PP.$star(), new StringRef(DepOpts.DOTOutputFile), 
            new StringRef(getHeaderSearchOpts().Sysroot));
      }
      
      // If we don't have a collector, but we are collecting module dependencies,
      // then we're the top level compiler instance and need to create one.
      if (!ModuleDepCollector.$bool() && !DepOpts.ModuleDependencyOutputDir.empty()) {
        $c$.clean(ModuleDepCollector.$assignMove($c$.track(std.make_shared(new ModuleDependencyCollector(DepOpts.ModuleDependencyOutputDir)))));
      }
      if (ModuleDepCollector.$bool()) {
        addDependencyCollector($c$.track(new std.shared_ptr<DependencyCollector>(JD$Shared_ptr$_Tp1$C.INSTANCE, ModuleDepCollector))); $c$.clean();
      }
      
      for (shared_ptr<DependencyCollector> /*&*/ Listener : DependencyCollectors)  {
        Listener.$arrow().attachToPreprocessor(PP.$star());
      }
      
      // Handle generating header include information, if requested.
      if (DepOpts.ShowHeaderIncludes) {
        AttachHeaderIncludeGen(PP.$star(), DepOpts);
      }
      if (!DepOpts.HeaderIncludeOutputFile.empty()) {
        StringRef OutputPath = new StringRef(DepOpts.HeaderIncludeOutputFile);
        if ($eq_StringRef(/*NO_COPY*/OutputPath, /*STRINGREF_STR*/"-")) {
          OutputPath.$assignMove(/*STRINGREF_STR*/$EMPTY);
        }
        AttachHeaderIncludeGen(PP.$star(), DepOpts, 
            /*ShowAllHeaders=*/ true, new StringRef(OutputPath), 
            /*ShowDepth=*/ false);
      }
      if (DepOpts.PrintShowIncludes) {
        AttachHeaderIncludeGen(PP.$star(), DepOpts, 
            /*ShowAllHeaders=*/ true, /*OutputPath=*/ new StringRef(/*KEEP_STR*/$EMPTY), 
            /*ShowDepth=*/ true, /*MSStyle=*/ true);
      }
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::getSpecificModuleCachePath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 386,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 380,
   FQN="clang::CompilerInstance::getSpecificModuleCachePath", NM="_ZN5clang16CompilerInstance26getSpecificModuleCachePathEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance26getSpecificModuleCachePathEv")
  //</editor-fold>
  public std.string getSpecificModuleCachePath() {
    // Set up the module path, including the hash for the
    // module-creation options.
    SmallString/*256*/ SpecificModuleCache/*J*/= new SmallString/*256*/(new StringRef(getHeaderSearchOpts().ModuleCachePath), 256);
    if (!SpecificModuleCache.empty() && !getHeaderSearchOpts().DisableModuleHash) {
      path.append(SpecificModuleCache, 
          new Twine(getInvocation().getModuleHash()));
    }
    return SpecificModuleCache.str().$string();
  }

  
  /// Create the AST context.
  
  // ASTContext
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::createASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 398,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 392,
   FQN="clang::CompilerInstance::createASTContext", NM="_ZN5clang16CompilerInstance16createASTContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance16createASTContextEv")
  //</editor-fold>
  public void createASTContext() {
    Preprocessor /*&*/ PP = getPreprocessor();
    ASTContext /*P*/ Context = new ASTContext(getLangOpts(), PP.getSourceManager(), 
        PP.getIdentifierTable(), PP.getSelectorTable(), 
        PP.getBuiltinInfo());
    Context.InitBuiltinTypes(getTarget(), getAuxTarget());
    setASTContext(Context);
  }

  
  /// Create an external AST source to read a PCH file and attach it to the AST
  /// context.
  
  // ExternalASTSource
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::createPCHExternalASTSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 409,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 403,
   FQN="clang::CompilerInstance::createPCHExternalASTSource", NM="_ZN5clang16CompilerInstance26createPCHExternalASTSourceEN4llvm9StringRefEbbPvb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance26createPCHExternalASTSourceEN4llvm9StringRefEbbPvb")
  //</editor-fold>
  public void createPCHExternalASTSource(StringRef Path, boolean DisablePCHValidation, boolean AllowPCHWithCompilerErrors, 
                            Object/*void P*/ DeserializationListener, boolean OwnDeserializationListener) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      boolean Preamble = getPreprocessorOpts().PrecompiledPreambleBytes.first != 0;
      $c$.clean(ModuleManager.$assign($c$.track(createPCHExternalASTSource(new StringRef(Path), new StringRef(getHeaderSearchOpts().Sysroot), DisablePCHValidation, 
              AllowPCHWithCompilerErrors, getPreprocessor(), getASTContext(), 
              getPCHContainerReader(), 
              new ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension> >(getFrontendOpts().ModuleFileExtensions), 
              DeserializationListener, 
              OwnDeserializationListener, Preamble, 
              getFrontendOpts().UseGlobalModuleIndex))));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Create an external AST source to read a PCH file.
  ///
  /// \return - The new object on success, or null on failure.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::createPCHExternalASTSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 423,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 417,
   FQN="clang::CompilerInstance::createPCHExternalASTSource", NM="_ZN5clang16CompilerInstance26createPCHExternalASTSourceEN4llvm9StringRefES2_bbRNS_12PreprocessorERNS_10ASTContextERKNS_18PCHContainerReaderENS1_8ArrayRefINS1_18IntrusiveRefCntPtrINS_19ModuleFileExtensionEEEEEPvbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance26createPCHExternalASTSourceEN4llvm9StringRefES2_bbRNS_12PreprocessorERNS_10ASTContextERKNS_18PCHContainerReaderENS1_8ArrayRefINS1_18IntrusiveRefCntPtrINS_19ModuleFileExtensionEEEEEPvbbb")
  //</editor-fold>
  public static IntrusiveRefCntPtr<ASTReader> createPCHExternalASTSource(StringRef Path, StringRef Sysroot, boolean DisablePCHValidation, 
                            boolean AllowPCHWithCompilerErrors, Preprocessor /*&*/ PP, ASTContext /*&*/ Context, 
                            /*const*/ PCHContainerReader /*&*/ PCHContainerRdr, 
                            ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension> > Extensions, 
                            Object/*void P*/ DeserializationListener, boolean OwnDeserializationListener, 
                            boolean Preamble, boolean UseGlobalModuleIndex) {
    IntrusiveRefCntPtr<ASTReader> Reader = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      HeaderSearchOptions /*&*/ HSOpts = PP.getHeaderSearchInfo().getHeaderSearchOpts();
      
      Reader/*J*/= new IntrusiveRefCntPtr<ASTReader>(new ASTReader(PP, Context, PCHContainerRdr, new ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension> >(Extensions), 
              new StringRef(Sysroot.empty() ? $EMPTY : Sysroot.data()), DisablePCHValidation, 
              AllowPCHWithCompilerErrors, /*AllowConfigurationMismatch*/ false, 
              HSOpts.ModulesValidateSystemHeaders, UseGlobalModuleIndex));
      
      // We need the external source to be set up before we read the AST, because
      // eagerly-deserialized declarations may use it.
      Context.setExternalSource($c$.track(new IntrusiveRefCntPtr<ExternalASTSource>(Reader.get()))); $c$.clean();
      
      Reader.$arrow().setDeserializationListener(((/*static_cast*/ASTDeserializationListener /*P*/ )(DeserializationListener)), 
          /*TakeOwnership=*/ OwnDeserializationListener);
      switch (Reader.$arrow().ReadAST(new StringRef(Path), 
          Preamble ? ModuleKind.MK_Preamble : ModuleKind.MK_PCH, 
          new SourceLocation(), 
          ASTReader.LoadFailureCapabilities.ARR_None)) {
       case Success:
        // Set the predefines buffer as suggested by the PCH reader. Typically, the
        // predefines buffer will be empty.
        PP.setPredefines(new StringRef(Reader.$arrow().getSuggestedPredefines()));
        return new IntrusiveRefCntPtr<ASTReader>(JD$Move.INSTANCE, Reader);
       case Failure:
        // Unrecoverable failure: don't even try to process the input file.
        break;
       case Missing:
       case OutOfDate:
       case VersionMismatch:
       case ConfigurationMismatch:
       case HadErrors:
        // No suitable PCH file could be found. Return an error.
        break;
      }
      
      Context.setExternalSource($c$.track(new IntrusiveRefCntPtr<ExternalASTSource>((ExternalASTSource /*P*/ )null))); $c$.clean();
      return new IntrusiveRefCntPtr<ASTReader>((ASTReader /*P*/ )null);
    } finally {
      if (Reader != null) { Reader.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Create a code completion consumer using the invocation; note that this
  /// will cause the source manager to truncate the input source file at the
  /// completion point.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::createCodeCompletionConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 493,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 487,
   FQN="clang::CompilerInstance::createCodeCompletionConsumer", NM="_ZN5clang16CompilerInstance28createCodeCompletionConsumerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance28createCodeCompletionConsumerEv")
  //</editor-fold>
  public void createCodeCompletionConsumer() {
    /*const*/ ParsedSourceLocation /*&*/ Loc = getFrontendOpts().CodeCompletionAt;
    if (!CompletionConsumer.$bool()) {
      setCodeCompletionConsumer(createCodeCompletionConsumer(getPreprocessor(), 
              new StringRef(Loc.FileName), Loc.Line, Loc.Column, 
              getFrontendOpts().CodeCompleteOpts, 
              llvm.outs()));
      if (!CompletionConsumer.$bool()) {
        return;
      }
    } else if (EnableCodeCompletion(getPreprocessor(), new StringRef(Loc.FileName), 
        Loc.Line, Loc.Column)) {
      setCodeCompletionConsumer((CodeCompleteConsumer /*P*/ )null);
      return;
    }
    if (CompletionConsumer.$arrow().isOutputBinary()
       && sys.ChangeStdoutToBinary().$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(getPreprocessor().getDiagnostics().Report(diag.err_fe_stdout_binary)));
        setCodeCompletionConsumer((CodeCompleteConsumer /*P*/ )null);
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  /// Create a code completion consumer to print code completion results, at
  /// \p Filename, \p Line, and \p Column, to the given output stream \p OS.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::createCodeCompletionConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 522,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 516,
   FQN="clang::CompilerInstance::createCodeCompletionConsumer", NM="_ZN5clang16CompilerInstance28createCodeCompletionConsumerERNS_12PreprocessorEN4llvm9StringRefEjjRKNS_19CodeCompleteOptionsERNS3_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance28createCodeCompletionConsumerERNS_12PreprocessorEN4llvm9StringRefEjjRKNS_19CodeCompleteOptionsERNS3_11raw_ostreamE")
  //</editor-fold>
  public static CodeCompleteConsumer /*P*/ createCodeCompletionConsumer(Preprocessor /*&*/ PP, 
                              StringRef Filename, 
                              /*uint*/int Line, 
                              /*uint*/int Column, 
                              /*const*/ CodeCompleteOptions /*&*/ Opts, 
                              raw_ostream /*&*/ OS) {
    if (EnableCodeCompletion(PP, new StringRef(Filename), Line, Column)) {
      return null;
    }
    
    // Set up the creation routine for code-completion.
    return new PrintingCodeCompleteConsumer(Opts, OS);
  }

  
  /// \brief Create the Sema object to be used for parsing.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::createSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 536,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 530,
   FQN="clang::CompilerInstance::createSema", NM="_ZN5clang16CompilerInstance10createSemaENS_19TranslationUnitKindEPNS_20CodeCompleteConsumerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance10createSemaENS_19TranslationUnitKindEPNS_20CodeCompleteConsumerE")
  //</editor-fold>
  public void createSema(TranslationUnitKind TUKind, 
            CodeCompleteConsumer /*P*/ CompletionConsumer) {
    TheSema.reset(new Sema(getPreprocessor(), getASTContext(), getASTConsumer(), 
            TUKind, CompletionConsumer));
  }

  
  /// Create the frontend timer and replace any existing one with it.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::createFrontendTimer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 516,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 510,
   FQN="clang::CompilerInstance::createFrontendTimer", NM="_ZN5clang16CompilerInstance19createFrontendTimerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance19createFrontendTimerEv")
  //</editor-fold>
  public void createFrontendTimer() {
    FrontendTimerGroup.reset(new TimerGroup(new StringRef(/*KEEP_STR*/"Clang front-end time report")));
    FrontendTimer.reset(new Timer(new StringRef(/*KEEP_STR*/"Clang front-end timer"), FrontendTimerGroup.$star()));
  }

  
  /// Create the default output file (from the invocation's options) and add it
  /// to the list of tracked output files.
  ///
  /// The files created by this function always use temporary files to write to
  /// their result (that is, the data is written to a temporary file which will
  /// atomically replace the target output on success).
  ///
  /// \return - Null on error.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::createDefaultOutputFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 574,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 573,
   FQN="clang::CompilerInstance::createDefaultOutputFile", NM="_ZN5clang16CompilerInstance23createDefaultOutputFileEbN4llvm9StringRefES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance23createDefaultOutputFileEbN4llvm9StringRefES2_")
  //</editor-fold>
  public std.unique_ptr<raw_pwrite_stream> createDefaultOutputFile() {
    return createDefaultOutputFile(true, new StringRef(/*KEEP_STR*/$EMPTY), 
                         new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public std.unique_ptr<raw_pwrite_stream> createDefaultOutputFile(boolean Binary/*= true*/) {
    return createDefaultOutputFile(Binary, new StringRef(/*KEEP_STR*/$EMPTY), 
                         new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public std.unique_ptr<raw_pwrite_stream> createDefaultOutputFile(boolean Binary/*= true*/, StringRef InFile/*= ""*/) {
    return createDefaultOutputFile(Binary, InFile, 
                         new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public std.unique_ptr<raw_pwrite_stream> createDefaultOutputFile(boolean Binary/*= true*/, StringRef InFile/*= ""*/, 
                         StringRef Extension/*= ""*/) {
    return createOutputFile(new StringRef(getFrontendOpts().OutputFile), Binary, 
        /*RemoveFileOnSignal=*/ true, new StringRef(InFile), new StringRef(Extension), 
        /*UseTemporary=*/ true);
  }

  
  /// Create a new output file and add it to the list of tracked output files,
  /// optionally deriving the output path name.
  ///
  /// \return - Null on error.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::createOutputFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 586,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 588,
   FQN="clang::CompilerInstance::createOutputFile", NM="_ZN5clang16CompilerInstance16createOutputFileEN4llvm9StringRefEbbS2_S2_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance16createOutputFileEN4llvm9StringRefEbbS2_S2_bb")
  //</editor-fold>
  public std.unique_ptr<raw_pwrite_stream> createOutputFile(StringRef OutputPath, boolean Binary, 
                  boolean RemoveFileOnSignal, StringRef InFile, 
                  StringRef Extension, boolean UseTemporary) {
    return createOutputFile(OutputPath, Binary, 
                  RemoveFileOnSignal, InFile, 
                  Extension, UseTemporary, 
                  false);
  }
  public std.unique_ptr<raw_pwrite_stream> createOutputFile(StringRef OutputPath, boolean Binary, 
                  boolean RemoveFileOnSignal, StringRef InFile, 
                  StringRef Extension, boolean UseTemporary, 
                  boolean CreateMissingDirectories/*= false*/) {
    std.unique_ptr<raw_pwrite_stream> OS = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      std.string OutputPathName/*J*/= new std.string(), TempPathName/*J*/= new std.string();
      std.error_code EC/*J*/= new std.error_code();
      OS = createOutputFile(new StringRef(OutputPath), EC, Binary, RemoveFileOnSignal, new StringRef(InFile), new StringRef(Extension), 
          UseTemporary, CreateMissingDirectories, /*AddrOf*/OutputPathName, /*AddrOf*/TempPathName);
      if (!OS.$bool()) {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(getDiagnostics().Report(diag.err_fe_unable_to_open_output)), /*NO_COPY*/OutputPath), 
            new StringRef(EC.message())));
        return new std.unique_ptr<raw_pwrite_stream>(JD$NullPtr.INSTANCE, null);
      }
      
      // Add the output file -- but don't try to remove "-", since this means we are
      // using stdin.
      addOutputFile($c$.track(new OutputFile(($noteq_string$C_T$C$P(OutputPathName, /*KEEP_STR*/"-")) ? new std.string(OutputPathName) : new std.string(/*KEEP_STR*/$EMPTY), new std.string(TempPathName)))); $c$.clean();
      
      return new std.unique_ptr<raw_pwrite_stream>(JD$Move.INSTANCE, OS);
    } finally {
      if (OS != null) { OS.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Create a new output file, optionally deriving the output path name.
  ///
  /// If \p OutputPath is empty, then createOutputFile will derive an output
  /// path location as \p BaseInput, with any suffix removed, and \p Extension
  /// appended. If \p OutputPath is not stdout and \p UseTemporary
  /// is true, createOutputFile will create a new temporary file that must be
  /// renamed to \p OutputPath in the end.
  ///
  /// \param OutputPath - If given, the path to the output file.
  /// \param Error [out] - On failure, the error.
  /// \param BaseInput - If \p OutputPath is empty, the input path name to use
  /// for deriving the output path.
  /// \param Extension - The extension to use for derived output names.
  /// \param Binary - The mode to open the file in.
  /// \param RemoveFileOnSignal - Whether the file should be registered with
  /// llvm::sys::RemoveFileOnSignal. Note that this is not safe for
  /// multithreaded use, as the underlying signal mechanism is not reentrant
  /// \param UseTemporary - Create a new temporary file that must be renamed to
  /// OutputPath in the end.
  /// \param CreateMissingDirectories - When \p UseTemporary is true, create
  /// missing directories in the output path.
  /// \param ResultPathName [out] - If given, the result path name will be
  /// stored here on success.
  /// \param TempPathName [out] - If given, the temporary file path name
  /// will be stored here on success.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::createOutputFile">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 610,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 613,
   FQN="clang::CompilerInstance::createOutputFile", NM="_ZN5clang16CompilerInstance16createOutputFileEN4llvm9StringRefERSt10error_codebbS2_S2_bbPSsS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance16createOutputFileEN4llvm9StringRefERSt10error_codebbS2_S2_bbPSsS5_")
  //</editor-fold>
  public std.unique_ptr<raw_pwrite_stream> createOutputFile(StringRef OutputPath, std.error_code /*&*/ Error, boolean Binary, 
                  boolean RemoveFileOnSignal, StringRef InFile, StringRef Extension, 
                  boolean UseTemporary, boolean CreateMissingDirectories, 
                  std.string/*P*/ ResultPathName, std.string/*P*/ TempPathName) {
    std.unique_ptr<raw_fd_ostream> OS = null;
    unique_ptr<buffer_ostream> B = null;
    try {
      assert ((!CreateMissingDirectories || UseTemporary)) : "CreateMissingDirectories is only allowed when using temporary files";
      
      std.string OutFile/*J*/= new std.string(), TempFile/*J*/= new std.string();
      if (!OutputPath.empty()) {
        OutFile.$assignMove(OutputPath.$string());
      } else if ($eq_StringRef(/*NO_COPY*/InFile, /*STRINGREF_STR*/"-")) {
        OutFile.$assign_T$C$P(/*KEEP_STR*/"-");
      } else if (!Extension.empty()) {
        SmallString/*128*/ Path/*J*/= new SmallString/*128*/(new StringRef(InFile), 128);
        path.replace_extension(Path, new Twine(Extension));
        OutFile.$assignMove(Path.str().$string());
      } else {
        OutFile.$assign_T$C$P(/*KEEP_STR*/"-");
      }
      
      OS/*J*/= new std.unique_ptr<raw_fd_ostream>();
      std.string OSFile/*J*/= new std.string();
      if (UseTemporary) {
        if ($eq_string$C_T$C$P(OutFile, /*KEEP_STR*/"-")) {
          UseTemporary = false;
        } else {
          fs.file_status Status/*J*/= new fs.file_status();
          fs.status(new Twine(OutputPath), Status);
          if (fs.exists(new file_status(Status))) {
            // Fail early if we can't write to the final destination.
            if (!fs.can_write(new Twine(OutputPath))) {
              Error.$assignMove(make_error_code(errc.operation_not_permitted));
              return new std.unique_ptr<raw_pwrite_stream>(JD$NullPtr.INSTANCE, null);
            }
            
            // Don't use a temporary if the output is a special file. This handles
            // things like '-o /dev/null'
            if (!fs.is_regular_file(new file_status(Status))) {
              UseTemporary = false;
            }
          }
        }
      }
      if (UseTemporary) {
        // Create a temporary file.
        SmallString/*128*/ TempPath/*J*/= new SmallString/*128*/(128);
        TempPath.$assign(new StringRef(OutFile));
        TempPath.$addassign(/*STRINGREF_STR*/"-%%%%%%%%");
        int$ref fd = create_int$ref();
        std.error_code EC = fs.createUniqueFile(new Twine(TempPath), fd, TempPath);
        if (CreateMissingDirectories
           && $eq_error_code$C(EC, new error_code(errc.no_such_file_or_directory))) {
          StringRef Parent = path.parent_path(/*NO_COPY*/OutputPath);
          EC.$assignMove(fs.create_directories(new Twine(Parent)));
          if (!EC.$bool()) {
            EC.$assignMove(fs.createUniqueFile(new Twine(TempPath), fd, TempPath));
          }
        }
        if (!EC.$bool()) {
          OS.reset(new raw_fd_ostream(fd.$deref(), /*shouldClose=*/ true));
          OSFile.$assign(TempFile.$assignMove(TempPath.str().$string()));
        }
        // If we failed to create the temporary, fallback to writing to the file
        // directly. This handles the corner case where we cannot write to the
        // directory, but can write to the file.
      }
      if (!OS.$bool()) {
        OSFile.$assign(OutFile);
        OS.reset(new raw_fd_ostream(new StringRef(OSFile), Error, 
                (Binary ? fs.OpenFlags.F_None : fs.OpenFlags.F_Text)));
        if (Error.$bool()) {
          return new std.unique_ptr<raw_pwrite_stream>(JD$NullPtr.INSTANCE, null);
        }
      }
      
      // Make sure the out stream file gets removed if we crash.
      if (RemoveFileOnSignal) {
        sys.RemoveFileOnSignal(new StringRef(OSFile));
      }
      if ((ResultPathName != null)) {
        /*Deref*/ResultPathName.$assign(OutFile);
      }
      if ((TempPathName != null)) {
        /*Deref*/TempPathName.$assign(TempFile);
      }
      if (!Binary || OS.$arrow().supportsSeeking()) {
        return new std.unique_ptr<raw_pwrite_stream>(JD$Unique_ptr$_Up$_Ep.INSTANCE, std.move(OS));
      }
      B = llvm.make_unique(new buffer_ostream(OS.$star()));
      assert (!NonSeekStream.$bool());
      NonSeekStream.$assignMove(std.move(OS));
      return new std.unique_ptr<raw_pwrite_stream>(JD$Unique_ptr$_Up$_Ep.INSTANCE, std.move(B));
    } finally {
      if (B != null) { B.$destroy(); }
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::createNullOutputFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 582,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 581,
   FQN="clang::CompilerInstance::createNullOutputFile", NM="_ZN5clang16CompilerInstance20createNullOutputFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance20createNullOutputFileEv")
  //</editor-fold>
  public std.unique_ptr<raw_pwrite_stream> createNullOutputFile() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(new std.unique_ptr<raw_pwrite_stream>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new raw_null_ostream()))));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// }
  /// @name Initialization Utility Methods
  /// {
  
  /// InitializeSourceManager - Initialize the source manager to set InputFile
  /// as the main file.
  ///
  /// \return True on success.
  
  // Initialization Utilities
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::InitializeSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 711,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 714,
   FQN="clang::CompilerInstance::InitializeSourceManager", NM="_ZN5clang16CompilerInstance23InitializeSourceManagerERKNS_17FrontendInputFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance23InitializeSourceManagerERKNS_17FrontendInputFileE")
  //</editor-fold>
  public boolean InitializeSourceManager(/*const*/ FrontendInputFile /*&*/ Input) {
    return InitializeSourceManager(Input, getDiagnostics(), getFileManager(), getSourceManager(), 
        hasPreprocessor() ? /*AddrOf*/getPreprocessor().getHeaderSearchInfo() : (HeaderSearch /*P*/ )null, 
        getDependencyOutputOpts(), getFrontendOpts());
  }

  
  /// InitializeSourceManager - Initialize the source manager to set InputFile
  /// as the main file.
  ///
  /// \return True on success.
  
  // static
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::InitializeSourceManager">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 719,
   FQN="clang::CompilerInstance::InitializeSourceManager", NM="_ZN5clang16CompilerInstance23InitializeSourceManagerERKNS_17FrontendInputFileERNS_17DiagnosticsEngineERNS_11FileManagerERNS_13SourceManagerEPNS_12HeaderSearchERNS_23DependencyOutputOptionsERKNS_15FrontendOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance23InitializeSourceManagerERKNS_17FrontendInputFileERNS_17DiagnosticsEngineERNS_11FileManagerERNS_13SourceManagerEPNS_12HeaderSearchERNS_23DependencyOutputOptionsERKNS_15FrontendOptionsE")
  //</editor-fold>
  public static boolean InitializeSourceManager(/*const*/ FrontendInputFile /*&*/ Input, DiagnosticsEngine /*&*/ Diags, 
                         FileManager /*&*/ FileMgr, SourceManager /*&*/ SourceMgr, HeaderSearch /*P*/ HS, 
                         DependencyOutputOptions /*&*/ DepOpts, /*const*/ FrontendOptions /*&*/ Opts) {
    SrcMgr.CharacteristicKind Kind = Input.isSystem() ? SrcMgr.CharacteristicKind.C_System : SrcMgr.CharacteristicKind.C_User;
    if (Input.isBuffer()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        SourceMgr.setMainFileID(SourceMgr.createFileID($c$.track(new std.unique_ptr<MemoryBuffer>(Input.getBuffer())), Kind)); $c$.clean();
        assert (SourceMgr.getMainFileID().isValid()) : "Couldn't establish MainFileID!";
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    StringRef InputFile = Input.getFile();
    
    // Figure out where to get and map in the main file.
    if ($noteq_StringRef(/*NO_COPY*/InputFile, /*STRINGREF_STR*/"-")) {
      /*const*/ FileEntry /*P*/ File;
      if (Opts.FindPchSource.empty()) {
        File = FileMgr.getFile(/*NO_COPY*/InputFile, /*OpenFile=*/ true);
      } else {
        // When building a pch file in clang-cl mode, the .h file is built as if
        // it was included by a cc file.  Since the driver doesn't know about
        // all include search directories, the frontend must search the input
        // file through HeaderSearch here, as if it had been included by the
        // cc file at Opts.FindPchSource.
        /*const*/ FileEntry /*P*/ FindFile = FileMgr.getFile(new StringRef(Opts.FindPchSource));
        if (!(FindFile != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_fe_error_reading)), new StringRef(Opts.FindPchSource)));
            return false;
          } finally {
            $c$.$destroy();
          }
        }
        // JAVA: check UnusedCurDir
        /*const*/type$ref<type$ptr<DirectoryLookup>> /*P*/ UnusedCurDir = create_type$ref(create_type$ptr((DirectoryLookup[]) null));
        SmallVector<std.pair</*const*/ FileEntry /*P*/ , /*const*/ DirectoryEntry /*P*/ >> Includers/*J*/= new SmallVector<std.pair</*const*/ FileEntry /*P*/ , /*const*/ DirectoryEntry /*P*/ >>(16, null);
        Includers.push_back(std.make_pair_Ptr_Ptr(FindFile, FindFile.getDir()));
        File = HS.LookupFile(/*NO_COPY*/InputFile, new SourceLocation(), /*isAngled=*/ false, 
            /*FromDir=*/ (/*const*/type$ptr<DirectoryLookup> /*P*/ )null, 
            /*CurDir=*/ UnusedCurDir, new SmallVectorPtrPairFileEntryDirectoryEntry(Includers), 
            /*SearchPath=*/ (SmallString/*P*/ )null, 
            /*RelativePath=*/ (SmallString/*P*/ )null, 
            /*RequestingModule=*/ (Module /*P*/ )null, 
            /*SuggestedModule=*/ (ModuleMap.KnownHeader /*P*/ )null, /*SkipCache=*/ true);
        // Also add the header to /showIncludes output.
        if ((File != null)) {
          DepOpts.ShowIncludesPretendHeader.$assign_T$C$P(File.getName());
        }
      }
      if (!(File != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_fe_error_reading)), /*NO_COPY*/InputFile));
          return false;
        } finally {
          $c$.$destroy();
        }
      }
      
      // The natural SourceManager infrastructure can't currently handle named
      // pipes, but we would at least like to accept them for the main
      // file. Detect them here, read them with the volatile flag so FileMgr will
      // pick up the correct size, and simply override their contents as we do for
      // STDIN.
      if (File.isNamedPipe()) {
        ErrorOr<unique_ptr<MemoryBuffer> > MB = null;
        try {
          MB = FileMgr.getBufferForFile(File, /*isVolatile=*/ true);
          if (MB.$bool()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // Create a new virtual file that will have the correct size.
              File = FileMgr.getVirtualFile(new StringRef(InputFile), (MB.$star()).$arrow().getBufferSize(), 0);
              SourceMgr.overrideFileContents(File, $c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(MB.$star())))); $c$.clean();
            } finally {
              $c$.$destroy();
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_cannot_open_file)), /*NO_COPY*/InputFile), 
                  new StringRef(MB.getError().message())));
              return false;
            } finally {
              $c$.$destroy();
            }
          }
        } finally {
          if (MB != null) { MB.$destroy(); }
        }
      }
      
      SourceMgr.setMainFileID(SourceMgr.createFileID(File, SourceLocation.getInvalid(), Kind));
    } else {
      ErrorOr<std.unique_ptr<MemoryBuffer> > SBOrErr = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        SBOrErr = MemoryBuffer.getSTDIN();
        {
          std.error_code EC = SBOrErr.getError();
          if (EC.$bool()) {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_fe_error_reading_stdin)), new StringRef(EC.message())));
            return false;
          }
        }
        std.unique_ptr<MemoryBuffer> SB = new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(SBOrErr.get()));
        
        /*const*/ FileEntry /*P*/ File = FileMgr.getVirtualFile(new StringRef(SB.$arrow().getBufferIdentifier()), 
            SB.$arrow().getBufferSize(), 0);
        SourceMgr.setMainFileID(SourceMgr.createFileID(File, SourceLocation.getInvalid(), Kind));
        SourceMgr.overrideFileContents(File, $c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(SB)))); $c$.clean();
      } finally {
        if (SBOrErr != null) { SBOrErr.$destroy(); }
        $c$.$destroy();
      }
    }
    assert (SourceMgr.getMainFileID().isValid()) : "Couldn't establish MainFileID!";
    return true;
  }

  
  /// }
  
  // Create module manager.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::createModuleManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 1276,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 1249,
   FQN="clang::CompilerInstance::createModuleManager", NM="_ZN5clang16CompilerInstance19createModuleManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance19createModuleManagerEv")
  //</editor-fold>
  public void createModuleManager() {
    if (!ModuleManager.$bool()) {
      std.unique_ptr<Timer> ReadTimer = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        if (!hasASTContext()) {
          createASTContext();
        }
        
        // If we're implicitly building modules but not currently recursively
        // building a module, check whether we need to prune the module cache.
        if (getSourceManager().getModuleBuildStack().empty()
           && !getPreprocessor().getHeaderSearchInfo().getModuleCachePath().empty()
           && $greater_uint(getHeaderSearchOpts().ModuleCachePruneInterval, 0)
           && $greater_uint(getHeaderSearchOpts().ModuleCachePruneAfter, 0)) {
          pruneModuleCache(getHeaderSearchOpts());
        }
        
        HeaderSearchOptions /*&*/ HSOpts = getHeaderSearchOpts();
        std.string Sysroot = new std.string(HSOpts.Sysroot);
        /*const*/ PreprocessorOptions /*&*/ PPOpts = getPreprocessorOpts();
        ReadTimer/*J*/= new std.unique_ptr<Timer>();
        if (FrontendTimerGroup.$bool()) {
          $c$.clean(ReadTimer.$assignMove($c$.track(llvm.make_unique(new Timer($("Reading modules"), 
                  FrontendTimerGroup.$star())))));
        }
        $c$.clean(ModuleManager.$assign($c$.track(new IntrusiveRefCntPtr<ASTReader>(new ASTReader(getPreprocessor(), getASTContext(), getPCHContainerReader(), 
                    new ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension> >(getFrontendOpts().ModuleFileExtensions), 
                    new StringRef(Sysroot.empty() ? $EMPTY : Sysroot.c_str()), PPOpts.DisablePCHValidation, 
                    /*AllowASTWithCompilerErrors=*/ false, 
                    /*AllowConfigurationMismatch=*/ false, 
                    HSOpts.ModulesValidateSystemHeaders, 
                    getFrontendOpts().UseGlobalModuleIndex, 
                    $c$.track(new std.unique_ptr<Timer>(JD$Move.INSTANCE, std.move(ReadTimer))))))));
        if (hasASTConsumer()) {
          ModuleManager.$arrow().setDeserializationListener(getASTConsumer().GetASTDeserializationListener());
          getASTContext().setASTMutationListener(getASTConsumer().GetASTMutationListener());
        }
        getASTContext().setExternalSource($c$.track(new IntrusiveRefCntPtr<ExternalASTSource>(JD$IntrusiveRefCntPtr$X$C.INSTANCE, ModuleManager))); $c$.clean();
        if (hasSema()) {
          ModuleManager.$arrow().InitializeSema(getSema());
        }
        if (hasASTConsumer()) {
          ModuleManager.$arrow().StartTranslationUnit(/*AddrOf*/getASTConsumer());
        }
        if (TheDependencyFileGenerator.$bool()) {
          TheDependencyFileGenerator.$arrow().AttachToASTReader(ModuleManager.$star());
        }
        for (shared_ptr<DependencyCollector> /*&*/ Listener : DependencyCollectors)  {
          Listener.$arrow().attachToASTReader(ModuleManager.$star());
        }
      } finally {
        if (ReadTimer != null) { ReadTimer.$destroy(); }
        $c$.$destroy();
      }
    }
  }

  // Helper to recursively read the module names for all modules we're adding.
  // We mark these as known and redirect any attempt to load that module to
  // the files we were handed.
  //<editor-fold defaultstate="collapsed" desc="ReadModuleNames">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*extracted from function*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 1334,
   FQN="ReadModuleNames", NM="_ZZN5clang16CompilerInstance14loadModuleFileEN4llvm9StringRefEE15ReadModuleNames",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZZN5clang16CompilerInstance14loadModuleFileEN4llvm9StringRefEE15ReadModuleNames")
  //</editor-fold>
  private final static class/*struct*/ ReadModuleNames extends /**/ ASTReaderListener implements Destructors.ClassWithDestructor {
    public CompilerInstance /*&*/ CI;
    public SmallVector<IdentifierInfo /*P*/> LoadedModules;

    //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::loadModuleFile(StringRef)::ReadModuleNames::ReadModuleNames">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 1338,
     FQN="clang::CompilerInstance::loadModuleFile(StringRef)::ReadModuleNames::ReadModuleNames", NM="_ZZN5clang16CompilerInstance14loadModuleFileEN4llvm9StringRefEEN15ReadModuleNamesC1ERS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZZN5clang16CompilerInstance14loadModuleFileEN4llvm9StringRefEEN15ReadModuleNamesC1ERS0_")
    //</editor-fold>
    public ReadModuleNames(CompilerInstance /*&*/ CI) {
      // : ASTReaderListener(), CI(CI), LoadedModules() 
      //START JInit
      super();
      this./*&*/CI=/*&*/CI;
      this.LoadedModules = new SmallVector<IdentifierInfo /*P*/>(8, (IdentifierInfo /*P*/)null);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::loadModuleFile(StringRef)::ReadModuleNames::ReadModuleName">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     optimized = Converted.Optimization.VALUE_TYPE,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 1340,
     FQN="clang::CompilerInstance::loadModuleFile(StringRef)::ReadModuleNames::ReadModuleName", NM="_ZZN5clang16CompilerInstance14loadModuleFileEN4llvm9StringRefEEN15ReadModuleNames14ReadModuleNameES2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZZN5clang16CompilerInstance14loadModuleFileEN4llvm9StringRefEEN15ReadModuleNames14ReadModuleNameES2_")
    //</editor-fold>
    @Override public void ReadModuleName(StringRef ModuleName)/* override*/ {
      char$ptr data = ModuleName.data();
      LoadedModules.push_back(CI.getPreprocessor().getIdentifierInfo(data.$array(), data.$index(), ModuleName.size()));
    }


    //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::loadModuleFile(StringRef)::ReadModuleNames::registerAll">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 1345,
     FQN="clang::CompilerInstance::loadModuleFile(StringRef)::ReadModuleNames::registerAll", NM="_ZZN5clang16CompilerInstance14loadModuleFileEN4llvm9StringRefEEN15ReadModuleNames11registerAllEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZZN5clang16CompilerInstance14loadModuleFileEN4llvm9StringRefEEN15ReadModuleNames11registerAllEv")
    //</editor-fold>
    public void registerAll() {
      for (IdentifierInfo /*P*/ II : LoadedModules) {
        CI.KnownModules.$set(II, CI.getPreprocessor().
            getHeaderSearchInfo().
            getModuleMap().
            findModule(II.getName()));
      }
      LoadedModules.clear();
    }


    //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::loadModuleFile(StringRef)::ReadModuleNames::markAllUnavailable">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 1355,
     FQN="clang::CompilerInstance::loadModuleFile(StringRef)::ReadModuleNames::markAllUnavailable", NM="_ZZN5clang16CompilerInstance14loadModuleFileEN4llvm9StringRefEEN15ReadModuleNames18markAllUnavailableEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZZN5clang16CompilerInstance14loadModuleFileEN4llvm9StringRefEEN15ReadModuleNames18markAllUnavailableEv")
    //</editor-fold>
    public void markAllUnavailable() {
      for (IdentifierInfo /*P*/ II : LoadedModules) {
        {
          Module /*P*/ M = CI.getPreprocessor().
              getHeaderSearchInfo().
              getModuleMap().
              findModule(II.getName());
          if ((M != null)) {
            M.HasIncompatibleModuleFile = true;
          }
        }
      }
      LoadedModules.clear();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::loadModuleFile(StringRef)::ReadModuleNames::~ReadModuleNames">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 1334,
     FQN="clang::CompilerInstance::loadModuleFile(StringRef)::ReadModuleNames::~ReadModuleNames", NM="_ZZN5clang16CompilerInstance14loadModuleFileEN4llvm9StringRefEEN15ReadModuleNamesD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZZN5clang16CompilerInstance14loadModuleFileEN4llvm9StringRefEEN15ReadModuleNamesD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      //START JDestroy
      LoadedModules.$destroy();
      super.$destroy();
      //END JDestroy
    }


    @Override public String toString() {
      return "" + "CI=" + CI // NOI18N
                + ", LoadedModules=" + LoadedModules // NOI18N
                + super.toString(); // NOI18N
    }
  };

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::loadModuleFile">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION/*extracted inner class*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 1325,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 1300,
   FQN="clang::CompilerInstance::loadModuleFile", NM="_ZN5clang16CompilerInstance14loadModuleFileEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance14loadModuleFileEN4llvm9StringRefE")
  //</editor-fold>
  public boolean loadModuleFile(StringRef FileName) {
    Timer Timer = null;
    TimeRegion TimeLoading = null;
    unique_ptr<ReadModuleNames> Listener = null;
    ASTReader.ListenerScope ReadModuleNamesListener = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Timer/*J*/= new Timer();
      if (FrontendTimerGroup.$bool()) {
        Timer.init(new StringRef($add_T$C$P_string(/*KEEP_STR*/"Preloading ", FileName.str())), FrontendTimerGroup.$star());
      }
      TimeLoading/*J*/= new TimeRegion(JD$Timer$P.INSTANCE, FrontendTimerGroup.$bool() ? /*AddrOf*/Timer : (Timer /*P*/ )null);
      
      // If we don't already have an ASTReader, create one now.
      if (!ModuleManager.$bool()) {
        createModuleManager();
      }
      
      Listener = llvm.make_unique(new ReadModuleNames(/*Deref*/this));
      ReadModuleNames /*&*/ ListenerRef = Listener.$star();
      ReadModuleNamesListener/*J*/= $c$.clean(new ASTReader.ListenerScope(ModuleManager.$star(), 
          $c$.track(new std.unique_ptr<ASTReaderListener>(JD$Unique_ptr$_Up$_Ep.INSTANCE, std.move(Listener)))));
      
      // Try to load the module file.
      switch (ModuleManager.$arrow().ReadAST(new StringRef(FileName), ModuleKind.MK_ExplicitModule, 
          new SourceLocation(), 
          ASTReader.LoadFailureCapabilities.ARR_ConfigurationMismatch)) {
       case Success:
        // We successfully loaded the module file; remember the set of provided
        // modules so that we don't try to load implicit modules for them.
        ListenerRef.registerAll();
        return true;
       case ConfigurationMismatch:
        // Ignore unusable module files.
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDiagnostics().Report(new SourceLocation(), diag.warn_module_config_mismatch)), 
            /*NO_COPY*/FileName));
        // All modules provided by any files we tried and failed to load are now
        // unavailable; includes of those modules should now be handled textually.
        ListenerRef.markAllUnavailable();
        return true;
       default:
        return false;
      }
    } finally {
      if (ReadModuleNamesListener != null) { ReadModuleNamesListener.$destroy(); }
      if (Listener != null) { Listener.$destroy(); }
      if (TimeLoading != null) { TimeLoading.$destroy(); }
      if (Timer != null) { Timer.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::loadModule">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 1400,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 1375,
   FQN="clang::CompilerInstance::loadModule", NM="_ZN5clang16CompilerInstance10loadModuleENS_14SourceLocationEN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoES1_EEENS_6Module18NameVisibilityKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance10loadModuleENS_14SourceLocationEN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoES1_EEENS_6Module18NameVisibilityKindEb")
  //</editor-fold>
  @Override public ModuleLoadResult loadModule(SourceLocation ImportLoc, 
            ModuleIdPath Path, 
            Module.NameVisibilityKind Visibility, 
            boolean IsInclusionDirective)/* override*/ {
    // Determine what file we're searching from.
    StringRef ModuleName = Path.$at(0).first.getName();
    SourceLocation ModuleNameLoc = new SourceLocation(Path.$at(0).second);
    
    // If we've already handled this import, just return the cached result.
    // This one-element cache is important to eliminate redundant diagnostics
    // when both the preprocessor and parser see the same import declaration.
    if (ImportLoc.isValid() && $eq_SourceLocation$C(LastModuleImportLoc, ImportLoc)) {
      // Make the named module visible.
      if (((LastModuleImportResult.$ModulePtr()) != null) && $noteq_StringRef(/*NO_COPY*/ModuleName, new StringRef(getLangOpts().CurrentModule))) {
        ModuleManager.$arrow().makeModuleVisible(LastModuleImportResult.$ModulePtr(), Visibility, 
            new SourceLocation(ImportLoc));
      }
      return new ModuleLoadResult(LastModuleImportResult);
    }
    
    Module /*P*/ Module = null;
    
    // If we don't already have information on this module, load the module now.
    DenseMapIterator</*const*/ IdentifierInfo /*P*/, Module /*P*/> Known = KnownModules.find(Path.$at(0).first);
    if (Known.$noteq(/*NO_ITER_COPY*/KnownModules.end())) {
      // Retrieve the cached top-level module.
      Module = Known.$arrow().second;
    } else if ($eq_StringRef(/*NO_COPY*/ModuleName, new StringRef(getLangOpts().CurrentModule))) {
      // This is the module we're building. 
      Module = PP.$arrow().getHeaderSearchInfo().lookupModule(new StringRef(ModuleName));
      Known.$assignMove(KnownModules.insert_pair$KeyT$ValueT(std.make_pair_Ptr_Ptr(Path.$at(0).first, Module)).first);
    } else {
      Timer Timer = null;
      TimeRegion TimeLoading = null;
      try {
        // Search for a module with the given name.
        Module = PP.$arrow().getHeaderSearchInfo().lookupModule(new StringRef(ModuleName));
        if (!(Module != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($c$.track(getDiagnostics().Report(/*NO_COPY*/ModuleNameLoc, diag.err_module_not_found)), 
                    /*NO_COPY*/ModuleName), 
                new SourceRange(/*NO_COPY*/ImportLoc, /*NO_COPY*/ModuleNameLoc)));
            ModuleBuildFailed = true;
            return new ModuleLoadResult();
          } finally {
            $c$.$destroy();
          }
        }
        
        std.string ModuleFileName = PP.$arrow().getHeaderSearchInfo().getModuleFileName(Module);
        if (ModuleFileName.empty()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            if (Module.HasIncompatibleModuleFile) {
              // We tried and failed to load a module file for this module. Fall
              // back to textual inclusion for its headers.
              return new ModuleLoadResult((Module /*P*/ )null, /*missingExpected*/ true);
            }
            
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDiagnostics().Report(/*NO_COPY*/ModuleNameLoc, diag.err_module_build_disabled)), 
                /*NO_COPY*/ModuleName));
            ModuleBuildFailed = true;
            return new ModuleLoadResult();
          } finally {
            $c$.$destroy();
          }
        }
        
        // If we don't already have an ASTReader, create one now.
        if (!ModuleManager.$bool()) {
          createModuleManager();
        }
        
        Timer/*J*/= new Timer();
        if (FrontendTimerGroup.$bool()) {
          Timer.init(new StringRef($add_T$C$P_string$C(/*KEEP_STR*/"Loading ", ModuleFileName)), FrontendTimerGroup.$star());
        }
        TimeLoading/*J*/= new TimeRegion(JD$Timer$P.INSTANCE, FrontendTimerGroup.$bool() ? /*AddrOf*/Timer : (Timer /*P*/ )null);
        
        // Try to load the module file.
        /*uint*/int ARRFlags = ASTReader.LoadFailureCapabilities.ARR_OutOfDate | ASTReader.LoadFailureCapabilities.ARR_Missing;
        switch (ModuleManager.$arrow().ReadAST(new StringRef(ModuleFileName), 
            ModuleKind.MK_ImplicitModule, 
            new SourceLocation(ImportLoc), ARRFlags)) {
         case Success:
          break;
         case OutOfDate:
         case Missing:
          {
            // The module file is missing or out-of-date. Build it.
            assert ((Module != null)) : "missing module file";
            // Check whether there is a cycle in the module graph.
            ArrayRef<std.pair<std.string, FullSourceLoc> > ModPath = getSourceManager().getModuleBuildStack();
            /*const*/type$ptr<pair<std.string, FullSourceLoc>> /*P*/ Pos = $tryClone(ModPath.begin()), /*P*/ PosEnd = ModPath.end();
            for (; Pos.$noteq(PosEnd); Pos.$preInc()) {
              if ($eq_StringRef(Pos.$star().first, /*NO_COPY*/ModuleName)) {
                break;
              }
            }
            if (Pos.$noteq(PosEnd)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                SmallString/*256*/ CyclePath/*J*/= new SmallString/*256*/(256);
                for (; Pos.$noteq(PosEnd); Pos.$preInc()) {
                  CyclePath.$addassign(new StringRef(Pos.$star().first));
                  CyclePath.$addassign(/*STRINGREF_STR*/" -> ");
                }
                CyclePath.$addassign(/*NO_COPY*/ModuleName);
                
                $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(getDiagnostics().Report(/*NO_COPY*/ModuleNameLoc, diag.err_module_cycle)), 
                        /*NO_COPY*/ModuleName), CyclePath.$StringRef()));
                return new ModuleLoadResult();
              } finally {
                $c$.$destroy();
              }
            }
            
            // Check whether we have already attempted to build this module (but
            // failed).
            if (getPreprocessorOpts().FailedModules.$bool()
               && getPreprocessorOpts().FailedModules.$arrow().hasAlreadyFailed(/*NO_COPY*/ModuleName)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($c$.track(getDiagnostics().Report(/*NO_COPY*/ModuleNameLoc, diag.err_module_not_built)), 
                        /*NO_COPY*/ModuleName), 
                    new SourceRange(/*NO_COPY*/ImportLoc, /*NO_COPY*/ModuleNameLoc)));
                ModuleBuildFailed = true;
                return new ModuleLoadResult();
              } finally {
                $c$.$destroy();
              }
            }
            
            // Try to compile and then load the module.
            if (!compileAndLoadModule(/*Deref*/this, new SourceLocation(ImportLoc), new SourceLocation(ModuleNameLoc), Module, 
                new StringRef(ModuleFileName))) {
              assert (getDiagnostics().hasErrorOccurred()) : "undiagnosed error in compileAndLoadModule";
              if (getPreprocessorOpts().FailedModules.$bool()) {
                getPreprocessorOpts().FailedModules.$arrow().addFailed(/*NO_COPY*/ModuleName);
              }
              KnownModules.$set(Path.$at(0).first, null);
              ModuleBuildFailed = true;
              return new ModuleLoadResult();
            }
            
            // Okay, we've rebuilt and now loaded the module.
            break;
          }
         case VersionMismatch:
         case ConfigurationMismatch:
         case HadErrors:
          super.HadFatalFailure = true;
          // FIXME: The ASTReader will already have complained, but can we shoehorn
          // that diagnostic information into a more useful form?
          KnownModules.$set(Path.$at(0).first, null);
          return new ModuleLoadResult();
         case Failure:
          super.HadFatalFailure = true;
          // Already complained, but note now that we failed.
          KnownModules.$set(Path.$at(0).first, null);
          ModuleBuildFailed = true;
          return new ModuleLoadResult();
        }
        
        // Cache the result of this top-level module lookup for later.
        Known.$assignMove(KnownModules.insert_pair$KeyT$ValueT(std.make_pair_Ptr_Ptr(Path.$at(0).first, Module)).first);
      } finally {
        if (TimeLoading != null) { TimeLoading.$destroy(); }
        if (Timer != null) { Timer.$destroy(); }
      }
    }
    
    // If we never found the module, fail.
    if (!(Module != null)) {
      return new ModuleLoadResult();
    }
    
    // Verify that the rest of the module path actually corresponds to
    // a submodule.
    if ($greater_uint(Path.size(), 1)) {
      for (/*uint*/int I = 1, N = Path.size(); I != N; ++I) {
        StringRef Name = Path.$at(I).first.getName();
        Module /*P*/ Sub = Module.findSubmodule(new StringRef(Name));
        if (!(Sub != null)) {
          // Attempt to perform typo correction to find a module name that works.
          SmallVector<StringRef> Best/*J*/= new SmallVector<StringRef>(2, new StringRef());
          /*uint*/int BestEditDistance = (std.numeric_limitsUInt.max());
          
          for (std.vector.iterator<Module /*P*/ > J = Module.submodule_begin(), 
              JEnd = Module.submodule_end();
               $noteq___normal_iterator$C(J, JEnd); J.$preInc()) {
            /*uint*/int ED = Name.edit_distance(new StringRef((J.$star()).Name), 
                /*AllowReplacements=*/ /*KEEP_BOOL*/true, 
                BestEditDistance);
            if ($lesseq_uint(ED, BestEditDistance)) {
              if ($less_uint(ED, BestEditDistance)) {
                Best.clear();
                BestEditDistance = ED;
              }
              
              Best.push_back(new StringRef((J.$star()).Name));
            }
          }
          
          // If there was a clear winner, user it.
          if (Best.size() == 1) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track(getDiagnostics().Report(/*NO_COPY*/Path.$at(I).second, 
                                      diag.err_no_submodule_suggest)), 
                                  Path.$at(I).first), new StringRef(Module.getFullModuleName())), /*NO_COPY*/Best.$at(0)), 
                      new SourceRange(/*NO_COPY*/Path.$at(0).second, /*NO_COPY*/Path.$at(I - 1).second)), 
                  FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/Path.$at(I).second), 
                      /*NO_COPY*/Best.$at(0))));
              
              Sub = Module.findSubmodule(new StringRef(Best.$at(0)));
            } finally {
              $c$.$destroy();
            }
          }
        }
        if (!(Sub != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // No submodule by this name. Complain, and don't look for further
            // submodules.
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track(getDiagnostics().Report(/*NO_COPY*/Path.$at(I).second, diag.err_no_submodule)), 
                        Path.$at(I).first), new StringRef(Module.getFullModuleName())), 
                new SourceRange(/*NO_COPY*/Path.$at(0).second, /*NO_COPY*/Path.$at(I - 1).second)));
            break;
          } finally {
            $c$.$destroy();
          }
        }
        
        Module = Sub;
      }
    }
    
    // Make the named module visible, if it's not already part of the module
    // we are parsing.
    if ($noteq_StringRef(/*NO_COPY*/ModuleName, new StringRef(getLangOpts().CurrentModule))) {
      Module.UnresolvedHeaderDirective MissingHeader = null;
      try {
        if (!Module.IsFromModuleFile) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // We have an umbrella header or directory that doesn't actually include
            // all of the headers within the directory it covers. Complain about
            // this missing submodule and recover by forgetting that we ever saw
            // this submodule.
            // FIXME: Should we detect this at module load time? It seems fairly
            // expensive (and rare).
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($c$.track(getDiagnostics().Report(/*NO_COPY*/ImportLoc, diag.warn_missing_submodule)), 
                    new StringRef(Module.getFullModuleName())), 
                new SourceRange(/*NO_COPY*/Path.front().second, /*NO_COPY*/Path.back().second)));
            
            return new ModuleLoadResult((Module /*P*/ )null, true);
          } finally {
            $c$.$destroy();
          }
        }
        
        // Check whether this module is available.
        std.pairTypeBool<std.string> Requirement/*J*/= new std.pairTypeBool<std.string>(new std.string(), false);
        MissingHeader/*J*/= new Module.UnresolvedHeaderDirective();
        if (!Module.isAvailable(getLangOpts(), getTarget(), Requirement, 
            MissingHeader)) {
          if (MissingHeader.FileNameLoc.isValid()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($out$Same2Bool($c$.track(getDiagnostics().Report(/*NO_COPY*/MissingHeader.FileNameLoc, 
                          diag.err_module_header_missing)), 
                      MissingHeader.IsUmbrella), new StringRef(MissingHeader.FileName)));
            } finally {
              $c$.$destroy();
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($out$Same2Bool($out_DiagnosticBuilder$C_StringRef($c$.track(getDiagnostics().Report(/*NO_COPY*/ImportLoc, diag.err_module_unavailable)), 
                              new StringRef(Module.getFullModuleName())), 
                          Requirement.second), new StringRef(Requirement.first)), 
                  new SourceRange(/*NO_COPY*/Path.front().second, /*NO_COPY*/Path.back().second)));
            } finally {
              $c$.$destroy();
            }
          }
          LastModuleImportLoc.$assign(ImportLoc);
          LastModuleImportResult.$assignMove(new ModuleLoadResult());
          return new ModuleLoadResult();
        }
        
        ModuleManager.$arrow().makeModuleVisible(Module, Visibility, new SourceLocation(ImportLoc));
      } finally {
        if (MissingHeader != null) { MissingHeader.$destroy(); }
      }
    }
    
    // Check for any configuration macros that have changed.
    Module /*P*/ TopModule = Module.getTopLevelModule();
    for (/*uint*/int I = 0, N = TopModule.ConfigMacros.size(); I != N; ++I) {
      checkConfigMacro(getPreprocessor(), /*JAVA: pass std.string*/TopModule.ConfigMacros.$at(I), 
          Module, new SourceLocation(ImportLoc));
    }
    
    LastModuleImportLoc.$assign(ImportLoc);
    LastModuleImportResult.$assignMove(new ModuleLoadResult(Module, false));
    return new ModuleLoadResult(LastModuleImportResult);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::makeModuleVisible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 1658,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 1639,
   FQN="clang::CompilerInstance::makeModuleVisible", NM="_ZN5clang16CompilerInstance17makeModuleVisibleEPNS_6ModuleENS1_18NameVisibilityKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance17makeModuleVisibleEPNS_6ModuleENS1_18NameVisibilityKindENS_14SourceLocationE")
  //</editor-fold>
  @Override public void makeModuleVisible(Module /*P*/ Mod, 
                   Module.NameVisibilityKind Visibility, 
                   SourceLocation ImportLoc)/* override*/ {
    if (!ModuleManager.$bool()) {
      createModuleManager();
    }
    if (!ModuleManager.$bool()) {
      return;
    }
    
    ModuleManager.$arrow().makeModuleVisible(Mod, Visibility, new SourceLocation(ImportLoc));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::hadModuleLoaderFatalFailure">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 766,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 770,
   FQN="clang::CompilerInstance::hadModuleLoaderFatalFailure", NM="_ZNK5clang16CompilerInstance27hadModuleLoaderFatalFailureEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang16CompilerInstance27hadModuleLoaderFatalFailureEv")
  //</editor-fold>
  public boolean hadModuleLoaderFatalFailure() /*const*/ {
    return super.HadFatalFailure;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::loadGlobalModuleIndex">
  @Converted(kind = Converted.Kind.MANUAL,
   optimized = Converted.Optimization.VALUE_TYPE,       
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 1669,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 1650,
   FQN="clang::CompilerInstance::loadGlobalModuleIndex", NM="_ZN5clang16CompilerInstance21loadGlobalModuleIndexENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance21loadGlobalModuleIndexENS_14SourceLocationE")
  //</editor-fold>
  @Override public GlobalModuleIndex /*P*/ loadGlobalModuleIndex(SourceLocation TriggerLoc)/* override*/ {
    if (getPreprocessor().getHeaderSearchInfo().getModuleCachePath().empty()) {
      return null;
    }
    if (!ModuleManager.$bool()) {
      createModuleManager();
    }
    // Can't do anything if we don't have the module manager.
    if (!ModuleManager.$bool()) {
      return null;
    }
    // Get an existing global index.  This loads it if not already
    // loaded.
    ModuleManager.$arrow().loadGlobalIndex();
    GlobalModuleIndex /*P*/ GlobalIndex = ModuleManager.$arrow().getGlobalIndex();
    // If the global index doesn't exist, create it.
    if (!(GlobalIndex != null) && shouldBuildGlobalModuleIndex() && hasFileManager()
       && hasPreprocessor()) {
      fs.create_directories(new Twine(getPreprocessor().getHeaderSearchInfo().getModuleCachePath()));
      GlobalModuleIndex.writeIndex(getFileManager(), getPCHContainerReader(), 
          getPreprocessor().getHeaderSearchInfo().getModuleCachePath());
      ModuleManager.$arrow().resetForReload();
      ModuleManager.$arrow().loadGlobalIndex();
      GlobalIndex = ModuleManager.$arrow().getGlobalIndex();
    }
    // For finding modules needing to be imported for fixit messages,
    // we need to make the global index cover all modules, so we do that here.
    if (!HaveFullGlobalModuleIndex && (GlobalIndex != null) && !buildingModule()) {
      ModuleMap /*&*/ MMap = getPreprocessor().getHeaderSearchInfo().getModuleMap();
      boolean RecreateIndex = false;
      for (StringMapIterator<Module /*P*//*, MallocAllocator*/> I = MMap.module_begin(), 
          E = MMap.module_end(); I.$noteq(E); I.$preInc()) {
        Module /*P*/ TheModule = I.$arrow().second;
        /*const*/ FileEntry /*P*/ Entry = TheModule.getASTFile();
        if (!(Entry != null)) {
          SmallVector<std.pair<IdentifierInfo /*P*/ , SourceLocation>> Path/*J*/= new SmallVector<std.pair<IdentifierInfo /*P*/ , SourceLocation>>(2, new std.pairPtrType<IdentifierInfo /*P*/ , SourceLocation>(null, new SourceLocation()));
          Path.push_back(std.make_pair_Ptr_T(getPreprocessor().getIdentifierInfo(/*JAVA: new StringRef*/(TheModule.Name)), TriggerLoc));
          std.reverse(Path.begin(), Path.end());
          // Load a module as hidden.  This also adds it to the global index.
          loadModule(new SourceLocation(TheModule.DefinitionLoc), new ModuleIdPath(Path), Module.NameVisibilityKind.Hidden, false);
          RecreateIndex = true;
        }
      }
      if (RecreateIndex) {
        GlobalModuleIndex.writeIndex(getFileManager(), getPCHContainerReader(), 
            getPreprocessor().getHeaderSearchInfo().getModuleCachePath());
        ModuleManager.$arrow().resetForReload();
        ModuleManager.$arrow().loadGlobalIndex();
        GlobalIndex = ModuleManager.$arrow().getGlobalIndex();
      }
      HaveFullGlobalModuleIndex = true;
    }
    return GlobalIndex;
  }

  
  
  // Check global module index for missing imports.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::lookupMissingImports">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 1727,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 1708,
   FQN="clang::CompilerInstance::lookupMissingImports", NM="_ZN5clang16CompilerInstance20lookupMissingImportsEN4llvm9StringRefENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance20lookupMissingImportsEN4llvm9StringRefENS_14SourceLocationE")
  //</editor-fold>
  @Override public boolean lookupMissingImports(StringRef Name, 
                      SourceLocation TriggerLoc)/* override*/ {
    // Look for the symbol in non-imported modules, but only if an error
    // actually occurred.
    if (!buildingModule()) {
      // Load global module index, or retrieve a previously loaded one.
      GlobalModuleIndex /*P*/ GlobalIndex = loadGlobalModuleIndex(new SourceLocation(TriggerLoc));
      
      // Only if we have a global index.
      if ((GlobalIndex != null)) {
        SmallPtrSet<ModuleFile /*P*/> FoundModules/*J*/= new SmallPtrSet<ModuleFile /*P*/>(DenseMapInfo$LikePtr.$Info(), 4);
        
        // Find the modules that reference the identifier.
        // Note that this only finds top-level modules.
        // We'll let diagnoseTypo find the actual declaration module.
        if (GlobalIndex.lookupIdentifier(new StringRef(Name), FoundModules)) {
          return true;
        }
      }
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInstance::addDependencyCollector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", line = 774,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInstance.h", old_line = 778,
   FQN="clang::CompilerInstance::addDependencyCollector", NM="_ZN5clang16CompilerInstance22addDependencyCollectorESt10shared_ptrINS_19DependencyCollectorEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang16CompilerInstance22addDependencyCollectorESt10shared_ptrINS_19DependencyCollectorEE")
  //</editor-fold>
  public void addDependencyCollector(std.shared_ptr<DependencyCollector> Listener) {
    DependencyCollectors.push_back_T$RR(std.move(Listener));
  }

  
  @Override public String toString() {
    return "" + "Invocation=" + Invocation // NOI18N
              + ", Diagnostics=" + Diagnostics // NOI18N
              + ", Target=" + Target // NOI18N
              + ", AuxTarget=" + AuxTarget // NOI18N
              + ", VirtualFileSystem=" + VirtualFileSystem // NOI18N
              + ", FileMgr=" + FileMgr // NOI18N
              + ", SourceMgr=" + SourceMgr // NOI18N
              + ", PP=" + PP // NOI18N
              + ", Context=" + Context // NOI18N
              + ", Consumer=" + Consumer // NOI18N
              + ", CompletionConsumer=" + CompletionConsumer // NOI18N
              + ", TheSema=" + TheSema // NOI18N
              + ", FrontendTimerGroup=" + FrontendTimerGroup // NOI18N
              + ", FrontendTimer=" + FrontendTimer // NOI18N
              + ", ModuleManager=" + ModuleManager // NOI18N
              + ", ModuleDepCollector=" + ModuleDepCollector // NOI18N
              + ", ThePCHContainerOperations=" + ThePCHContainerOperations // NOI18N
              + ", TheDependencyFileGenerator=" + TheDependencyFileGenerator // NOI18N
              + ", DependencyCollectors=" + DependencyCollectors // NOI18N
              + ", KnownModules=" + KnownModules // NOI18N
              + ", LastModuleImportLoc=" + LastModuleImportLoc // NOI18N
              + ", LastModuleImportResult=" + LastModuleImportResult // NOI18N
              + ", BuildGlobalModuleIndex=" + BuildGlobalModuleIndex // NOI18N
              + ", HaveFullGlobalModuleIndex=" + HaveFullGlobalModuleIndex // NOI18N
              + ", ModuleBuildFailed=" + ModuleBuildFailed // NOI18N
              + ", NonSeekStream=" + NonSeekStream // NOI18N
              + ", OutputFiles=" + OutputFiles // NOI18N
              + super.toString(); // NOI18N
  }
}
