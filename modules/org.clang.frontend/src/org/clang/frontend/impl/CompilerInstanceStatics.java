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
package org.clang.frontend.impl;

import org.clang.driver.frontend.CodeGenOptions;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.basic.vfs.*;
import org.clang.lex.*;
import org.clang.lex.PreprocessorOptions.FailedModulesSet;
import org.clang.serialization.*;
import org.clang.frontend.*;
import org.llvm.support.sys.fs;
import static org.llvm.support.sys.fs.*;
import org.llvm.support.sys.path;

//<editor-fold defaultstate="collapsed" desc="static type CompilerInstanceStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZL16checkConfigMacroRN5clang12PreprocessorEN4llvm9StringRefEPNS_6ModuleENS_14SourceLocationE;_ZL16pruneModuleCacheRKN5clang19HeaderSearchOptionsE;_ZL17compileModuleImplRN5clang16CompilerInstanceENS_14SourceLocationEPNS_6ModuleEN4llvm9StringRefE;_ZL18SetUpDiagnosticLogPN5clang17DiagnosticOptionsEPKNS_14CodeGenOptionsERNS_17DiagnosticsEngineE;_ZL18writeTimestampFileN4llvm9StringRefE;_ZL20EnableCodeCompletionRN5clang12PreprocessorEN4llvm9StringRefEjj;_ZL20compileAndLoadModuleRN5clang16CompilerInstanceENS_14SourceLocationES2_PNS_6ModuleEN4llvm9StringRefE;_ZL23InitializeFileRemappingRN5clang17DiagnosticsEngineERNS_13SourceManagerERNS_11FileManagerERKNS_19PreprocessorOptionsE;_ZL26SetupSerializedDiagnosticsPN5clang17DiagnosticOptionsERNS_17DiagnosticsEngineEN4llvm9StringRefE;_ZL29getSourceInputKindFromOptionsRKN5clang11LangOptionsE; -static-type=CompilerInstanceStatics -package=org.clang.frontend.impl")
//</editor-fold>
public final class CompilerInstanceStatics {


// Diagnostics
//<editor-fold defaultstate="collapsed" desc="SetUpDiagnosticLog">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 144,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 142,
 FQN="SetUpDiagnosticLog", NM="_ZL18SetUpDiagnosticLogPN5clang17DiagnosticOptionsEPKNS_14CodeGenOptionsERNS_17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZL18SetUpDiagnosticLogPN5clang17DiagnosticOptionsEPKNS_14CodeGenOptionsERNS_17DiagnosticsEngineE")
//</editor-fold>
public static void SetUpDiagnosticLog(DiagnosticOptions /*P*/ DiagOpts, 
                  /*const*/ CodeGenOptions /*P*/ CodeGenOpts, 
                  DiagnosticsEngine /*&*/ Diags) {
  std.unique_ptr<raw_ostream> StreamOwner = null;
  unique_ptr<LogDiagnosticPrinter> Logger = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.error_code EC/*J*/= new std.error_code();
    StreamOwner/*J*/= new std.unique_ptr<raw_ostream>();
    raw_ostream /*P*/ OS = /*AddrOf*/llvm.errs();
    if ($noteq_string$C_T$C$P(DiagOpts.DiagnosticLogFile, /*KEEP_STR*/"-")) {
      unique_ptr<raw_fd_ostream> FileOS = null;
      try {
        // Create the output stream.
        FileOS = llvm.make_unique(new raw_fd_ostream(DiagOpts.DiagnosticLogFile, EC, 
            $bitor_OpenFlags(/*KEEP_ENUM*/fs.OpenFlags.F_Append, /*KEEP_ENUM*/fs.OpenFlags.F_Text)));
        if (EC.$bool()) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.warn_fe_cc_log_diagnostics_failure)), 
                  new StringRef(DiagOpts.DiagnosticLogFile)), new StringRef(EC.message())));
        } else {
          FileOS.$arrow().SetUnbuffered();
          OS = FileOS.get();
          StreamOwner.$assign$ConvertibleNotArray(std.move(FileOS));
        }
      } finally {
        if (FileOS != null) { FileOS.$destroy(); }
      }
    }
    
    // Chain in the diagnostic client which will log the diagnostics.
    Logger = llvm.make_unique(new LogDiagnosticPrinter(/*Deref*/OS, DiagOpts, 
        std.move(StreamOwner)));
    if ((CodeGenOpts != null)) {
      Logger.$arrow().setDwarfDebugFlags(new StringRef(CodeGenOpts.DwarfDebugFlags));
    }
    assert (Diags.ownsClient());
    Diags.setClient(new ChainedDiagnosticConsumer($c$.track(Diags.takeClient()), $c$.track(new std.unique_ptr<DiagnosticConsumer>(JD$Unique_ptr$_Up$_Ep.INSTANCE, std.move(Logger))))); $c$.clean();
  } finally {
    if (Logger != null) { Logger.$destroy(); }
    if (StreamOwner != null) { StreamOwner.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="SetupSerializedDiagnostics">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 175,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 173,
 FQN="SetupSerializedDiagnostics", NM="_ZL26SetupSerializedDiagnosticsPN5clang17DiagnosticOptionsERNS_17DiagnosticsEngineEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZL26SetupSerializedDiagnosticsPN5clang17DiagnosticOptionsERNS_17DiagnosticsEngineEN4llvm9StringRefE")
//</editor-fold>
public static void SetupSerializedDiagnostics(DiagnosticOptions /*P*/ DiagOpts, 
                          DiagnosticsEngine /*&*/ Diags, 
                          StringRef OutputFile) {
  unique_ptr<DiagnosticConsumer> SerializedConsumer = null;
  try {
    SerializedConsumer = serialized_diags.create(new StringRef(OutputFile), DiagOpts);
    if (Diags.ownsClient()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Diags.setClient(new ChainedDiagnosticConsumer($c$.track(Diags.takeClient()), $c$.track(new std.unique_ptr<DiagnosticConsumer>(JD$Move.INSTANCE, std.move(SerializedConsumer))))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Diags.setClient(new ChainedDiagnosticConsumer(Diags.getClient(), $c$.track(new std.unique_ptr<DiagnosticConsumer>(JD$Move.INSTANCE, std.move(SerializedConsumer))))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
  } finally {
    if (SerializedConsumer != null) { SerializedConsumer.$destroy(); }
  }
}


// Initialize the remapping of files to alternative contents, e.g.,
// those specified through other files.
//<editor-fold defaultstate="collapsed" desc="InitializeFileRemapping">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 248,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 246,
 FQN="InitializeFileRemapping", NM="_ZL23InitializeFileRemappingRN5clang17DiagnosticsEngineERNS_13SourceManagerERNS_11FileManagerERKNS_19PreprocessorOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZL23InitializeFileRemappingRN5clang17DiagnosticsEngineERNS_13SourceManagerERNS_11FileManagerERKNS_19PreprocessorOptionsE")
//</editor-fold>
public static void InitializeFileRemapping(DiagnosticsEngine /*&*/ Diags, 
                       SourceManager /*&*/ SourceMgr, 
                       FileManager /*&*/ FileMgr, 
                       /*const*/ PreprocessorOptions /*&*/ InitOpts) {
  // Remap files in the source manager (with buffers).
  for (/*const*/ pair<std.string, MemoryBuffer /*P*/ > /*&*/ RB : InitOpts.RemappedFileBuffers) {
    // Create the file entry for the file that we're mapping from.
    /*const*/ FileEntry /*P*/ FromFile = FileMgr.getVirtualFile(new StringRef(RB.first), RB.second.getBufferSize(), 0);
    if (!(FromFile != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_fe_remap_missing_from_file)), new StringRef(RB.first)));
        if (!InitOpts.RetainRemappedFileBuffers) {
          if (RB.second != null) { RB.second.$destroy();};
        }
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Override the contents of the "from" file with the contents of
    // the "to" file.
    SourceMgr.overrideFileContents(FromFile, RB.second, 
        InitOpts.RetainRemappedFileBuffers);
  }
  
  // Remap files in the source manager (with other files).
  for (/*const*/ pair<std.string, std.string> /*&*/ RF : InitOpts.RemappedFiles) {
    // Find the file that we're mapping to.
    /*const*/ FileEntry /*P*/ ToFile = FileMgr.getFile(new StringRef(RF.second));
    if (!(ToFile != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_fe_remap_missing_to_file)), new StringRef(RF.first)), new StringRef(RF.second)));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Create the file entry for the file that we're mapping from.
    /*const*/ FileEntry /*P*/ FromFile = FileMgr.getVirtualFile(new StringRef(RF.first), ToFile.getSize(), 0);
    if (!(FromFile != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_fe_remap_missing_from_file)), new StringRef(RF.first)));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Override the contents of the "from" file with the contents of
    // the "to" file.
    SourceMgr.overrideFileContents(FromFile, ToFile);
  }
  
  SourceMgr.setOverridenFilesKeepOriginalName(InitOpts.RemappedFilesKeepOriginalName);
}


// Code Completion
//<editor-fold defaultstate="collapsed" desc="EnableCodeCompletion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 475,
 FQN="EnableCodeCompletion", NM="_ZL20EnableCodeCompletionRN5clang12PreprocessorEN4llvm9StringRefEjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZL20EnableCodeCompletionRN5clang12PreprocessorEN4llvm9StringRefEjj")
//</editor-fold>
public static boolean EnableCodeCompletion(Preprocessor /*&*/ PP, 
                    StringRef Filename, 
                    /*uint*/int Line, 
                    /*uint*/int Column) {
  // Tell the source manager to chop off the given file at a specific
  // line and column.
  /*const*/ FileEntry /*P*/ Entry = PP.getFileManager().getFile(/*NO_COPY*/Filename);
  if (!(Entry != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(PP.getDiagnostics().Report(diag.err_fe_invalid_code_complete_file)), 
          /*NO_COPY*/Filename));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Truncate the named file at the given line/column.
  PP.SetCodeCompletionPoint(Entry, Line, Column);
  return false;
}


/// \brief Determine the appropriate source input kind based on language
/// options.
//<editor-fold defaultstate="collapsed" desc="getSourceInputKindFromOptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 901,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 874,
 FQN="getSourceInputKindFromOptions", NM="_ZL29getSourceInputKindFromOptionsRKN5clang11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZL29getSourceInputKindFromOptionsRKN5clang11LangOptionsE")
//</editor-fold>
public static InputKind getSourceInputKindFromOptions(/*const*/ LangOptions /*&*/ LangOpts) {
  if (LangOpts.OpenCL) {
    return InputKind.IK_OpenCL;
  }
  if (LangOpts.CUDA) {
    return InputKind.IK_CUDA;
  }
  if (LangOpts.ObjC1) {
    return LangOpts.CPlusPlus ? InputKind.IK_ObjCXX : InputKind.IK_ObjC;
  }
  return LangOpts.CPlusPlus ? InputKind.IK_CXX : InputKind.IK_C;
}


/// \brief Compile a module file for the given module, using the options 
/// provided by the importing compiler instance. Returns true if the module
/// was built without errors.
//<editor-fold defaultstate="collapsed" desc="compileModuleImpl">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 914,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 887,
 FQN="compileModuleImpl", NM="_ZL17compileModuleImplRN5clang16CompilerInstanceENS_14SourceLocationEPNS_6ModuleEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZL17compileModuleImplRN5clang16CompilerInstanceENS_14SourceLocationEPNS_6ModuleEN4llvm9StringRefE")
//</editor-fold>
public static boolean compileModuleImpl(CompilerInstance /*&*/ ImportingInstance, 
                 SourceLocation ImportLoc, 
                 Module /*P*/ Module, 
                 StringRef ModuleFileName) {
  IntrusiveRefCntPtr<CompilerInvocation> Invocation = null;
  CompilerInstance Instance = null;
  GenerateModuleAction CreateModuleAction = null;
  CrashRecoveryContext CRC = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    ModuleMap /*&*/ ModMap = ImportingInstance.getPreprocessor().getHeaderSearchInfo().getModuleMap();
    
    // Construct a compiler invocation for creating this module.
    Invocation/*J*/= new IntrusiveRefCntPtr<CompilerInvocation>(new CompilerInvocation(ImportingInstance.getInvocation()));
    
    PreprocessorOptions /*&*/ PPOpts = Invocation.$arrow().getPreprocessorOpts();
    
    // For any options that aren't intended to affect how a module is built,
    // reset them to their default values.
    Invocation.$arrow().getLangOpts().resetNonModularOptions();
    PPOpts.resetNonModularOptions();
    
    // Remove any macro definitions that are explicitly ignored by the module.
    // They aren't supposed to affect how the module is built anyway.
    /*const*/ HeaderSearchOptions /*&*/ HSOpts = Invocation.$arrow().getHeaderSearchOpts();
    PPOpts.Macros.erase(new std.vector.iterator<pairTypeBool<string>>(std.remove_if(PPOpts.Macros.begin(), PPOpts.Macros.end(), 
                 (def) -> 
                  {
                    StringRef MacroDef = new StringRef(def.first);
                    return $greater_uint(HSOpts.ModulesIgnoreMacros.count(MacroDef.split($$EQ).first.$string()), 0);
                  }
)), 
        new std.vector.iterator<pairTypeBool<string>>(PPOpts.Macros.end()));
    
    // Note the name of the module we're building.
    Invocation.$arrow().getLangOpts().CurrentModule.$assignMove(Module.getTopLevelModuleName().$string());
    
    // Make sure that the failed-module structure has been allocated in
    // the importing instance, and propagate the pointer to the newly-created
    // instance.
    PreprocessorOptions /*&*/ ImportingPPOpts = ImportingInstance.getInvocation().getPreprocessorOpts();
    if (!ImportingPPOpts.FailedModules.$bool()) {
      $c$.clean(ImportingPPOpts.FailedModules.$assign($c$.track(new IntrusiveRefCntPtr<FailedModulesSet>(new PreprocessorOptions.FailedModulesSet()))));
    }
    $c$.clean(PPOpts.FailedModules.$assign($c$.track(new IntrusiveRefCntPtr<FailedModulesSet>(ImportingPPOpts.FailedModules))));
    
    // If there is a module map file, build the module using the module map.
    // Set up the inputs/outputs so that we build the module from its umbrella
    // header.
    FrontendOptions /*&*/ FrontendOpts = Invocation.$arrow().getFrontendOpts();
    FrontendOpts.OutputFile.$assignMove(ModuleFileName.str());
    FrontendOpts.DisableFree = false;
    FrontendOpts.GenerateGlobalModuleIndex = false;
    FrontendOpts.BuildingImplicitModule = true;
    FrontendOpts.Inputs.clear();
    InputKind IK = getSourceInputKindFromOptions(/*Deref*/Invocation.$arrow().getLangOpts());
    
    // Don't free the remapped file buffers; they are owned by our caller.
    PPOpts.RetainRemappedFileBuffers = true;
    
    Invocation.$arrow().getDiagnosticOpts().VerifyDiagnostics = false;
    assert ($eq_str$C(ImportingInstance.getInvocation().getModuleHash(), Invocation.$arrow().getModuleHash())) : "Module hash mismatch!";
    
    // Construct a compiler instance that will be used to actually create the
    // module.
    Instance/*J*/= $c$.clean(new CompilerInstance($c$.track(ImportingInstance.getPCHContainerOperations()), 
        /*BuildingModule=*/ true));
    Instance.setInvocation(/*AddrOf*/Invocation.$star());
    
    Instance.createDiagnostics(new ForwardingDiagnosticConsumer(ImportingInstance.getDiagnosticClient()), 
        /*ShouldOwnClient=*/ true);
    
    Instance.setVirtualFileSystem($c$.track(new IntrusiveRefCntPtr<FileSystem>(/*AddrOf*/ImportingInstance.getVirtualFileSystem()))); $c$.clean();
    
    // Note that this module is part of the module build stack, so that we
    // can detect cycles in the module graph.
    Instance.setFileManager(/*AddrOf*/ImportingInstance.getFileManager());
    Instance.createSourceManager(Instance.getFileManager());
    SourceManager /*&*/ SourceMgr = Instance.getSourceManager();
    SourceMgr.setModuleBuildStack(ImportingInstance.getSourceManager().getModuleBuildStack());
    SourceMgr.pushModuleBuildStack(Module.getTopLevelModuleName(), 
        new FullSourceLoc(/*NO_COPY*/ImportLoc, ImportingInstance.getSourceManager()));
    
    // If we're collecting module dependencies, we need to share a collector
    // between all of the module CompilerInstances. Other than that, we don't
    // want to produce any dependency output from the module build.
    Instance.setModuleDepCollector($c$.track(ImportingInstance.getModuleDepCollector())); $c$.clean();
    $c$.clean(Invocation.$arrow().getDependencyOutputOpts().$assignMove($c$.track(new DependencyOutputOptions())));
    
    // Get or create the module map that we'll use to build this module.
    std.string InferredModuleMapContent/*J*/= new std.string();
    {
      /*const*/ FileEntry /*P*/ ModuleMapFile = ModMap.getContainingModuleMapFile(Module);
      if ((ModuleMapFile != null)) {
        // Use the module map where this module resides.
        FrontendOpts.Inputs.emplace_back(new FrontendInputFile(new StringRef(ModuleMapFile.getName()), IK));
      } else {
        raw_string_ostream OS = null;
        std.unique_ptr<MemoryBuffer> ModuleMapBuffer = null;
        try {
          SmallString/*128*/ FakeModuleMapFile/*J*/= new SmallString/*128*/(128, new StringRef(Module.Directory.getName()));
          path.append(FakeModuleMapFile, new Twine(/*KEEP_STR*/"__inferred_module.map"));
          FrontendOpts.Inputs.emplace_back(new FrontendInputFile(new StringRef(FakeModuleMapFile), IK));
          
          OS/*J*/= new raw_string_ostream(InferredModuleMapContent);
          Module.print(OS);
          OS.flush();
          
          ModuleMapBuffer = MemoryBuffer.getMemBuffer(new StringRef(InferredModuleMapContent));
          ModuleMapFile = Instance.getFileManager().getVirtualFile(FakeModuleMapFile.$StringRef(), InferredModuleMapContent.size(), 0);
          SourceMgr.overrideFileContents(ModuleMapFile, $c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(ModuleMapBuffer)))); $c$.clean();
        } finally {
          if (ModuleMapBuffer != null) { ModuleMapBuffer.$destroy(); }
          if (OS != null) { OS.$destroy(); }
        }
      }
    }
    
    // Construct a module-generating action. Passing through the module map is
    // safe because the FileManager is shared between the compiler instances.
    CreateModuleAction/*J*/= new GenerateModuleAction(ModMap.getModuleMapFileForUniquing(Module), Module.IsSystem);
    final GenerateModuleAction $CreateModuleAction = CreateModuleAction;
    final CompilerInstance $Instance = Instance;
    
    $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track((DiagnosticBuilder)ImportingInstance.getDiagnostics().Report(/*NO_COPY*/ImportLoc, 
                diag.remark_module_build)), 
            new StringRef(Module.Name)), /*NO_COPY*/ModuleFileName));
    
    // Execute the action to actually build the module in-place. Use a separate
    // thread so that we get a stack large enough.
    /*const*//*uint*/int ThreadStackSize = 8 << 20;
    CRC/*J*/= new CrashRecoveryContext();
    CRC.RunSafelyOnThread((Cookie) -> 
              {
                $Instance.ExecuteAction($CreateModuleAction);
              }
        , ThreadStackSize);
    
    $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(ImportingInstance.getDiagnostics().Report(/*NO_COPY*/ImportLoc, 
            diag.remark_module_build_done)), 
        new StringRef(Module.Name)));
    
    // Delete the temporary module map file.
    // FIXME: Even though we're executing under crash protection, it would still
    // be nice to do this with RemoveFileOnSignal when we can. However, that
    // doesn't make sense for all clients, so clean this up manually.
    Instance.clearOutputFiles(/*EraseFiles=*/ true);
    
    // We've rebuilt a module. If we're allowed to generate or update the global
    // module index, record that fact in the importing compiler instance.
    if (ImportingInstance.getFrontendOpts().GenerateGlobalModuleIndex) {
      ImportingInstance.setBuildGlobalModuleIndex(true);
    }
    
    return !Instance.getDiagnostics().hasErrorOccurred();
  } finally {
    if (CRC != null) { CRC.$destroy(); }
    if (CreateModuleAction != null) { CreateModuleAction.$destroy(); }
    if (Instance != null) { Instance.$destroy(); }
    if (Invocation != null) { Invocation.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="compileAndLoadModule">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 1058,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 1031,
 FQN="compileAndLoadModule", NM="_ZL20compileAndLoadModuleRN5clang16CompilerInstanceENS_14SourceLocationES2_PNS_6ModuleEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZL20compileAndLoadModuleRN5clang16CompilerInstanceENS_14SourceLocationES2_PNS_6ModuleEN4llvm9StringRefE")
//</editor-fold>
public static boolean compileAndLoadModule(CompilerInstance /*&*/ ImportingInstance, 
                    SourceLocation ImportLoc, 
                    SourceLocation ModuleNameLoc, Module /*P*/ Module, 
                    StringRef ModuleFileName) {
  DiagnosticsEngine /*&*/ Diags = ImportingInstance.getDiagnostics();
  
  // JAVA: fixed lambda
  Void2Void diagnoseBuildFailure = new Void2Void() {
    public void $call() {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/ModuleNameLoc, diag.err_module_not_built)), 
                new StringRef(Module.Name)), new SourceRange(/*NO_COPY*/ImportLoc, /*NO_COPY*/ModuleNameLoc)));
      } finally {
        $c$.$destroy();
      }
    }
  }
  ;
  
  // FIXME: have LockFileManager return an error_code so that we can
  // avoid the mkdir when the directory already exists.
  StringRef Dir = path.parent_path(/*NO_COPY*/ModuleFileName);
  fs.create_directories(new Twine(Dir));
  while (true) {
    LockFileManager Locked = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*uint*/int ModuleLoadCapabilities = ASTReader.LoadFailureCapabilities.ARR_Missing;
      Locked/*J*/= new LockFileManager(new StringRef(ModuleFileName));
      switch (Locked.$LockFileState()) {
       case LFS_Error:
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/ModuleNameLoc, diag.err_module_lock_failure)), 
                new StringRef(Module.Name)), new StringRef(Locked.getErrorMessage())));
        return false;
       case LFS_Owned:
        // We're responsible for building the module ourselves.
        if (!compileModuleImpl(ImportingInstance, new SourceLocation(ModuleNameLoc), Module, 
            new StringRef(ModuleFileName))) {
          diagnoseBuildFailure.$call();
          return false;
        }
        break;
       case LFS_Shared:
        // Someone else is responsible for building the module. Wait for them to
        // finish.
        switch (Locked.waitForUnlock()) {
         case Res_Success:
          ModuleLoadCapabilities |= ASTReader.LoadFailureCapabilities.ARR_OutOfDate;
          break;
         case Res_OwnerDied:
          continue; // try again to get the lock.
         case Res_Timeout:
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/ModuleNameLoc, diag.err_module_lock_timeout)), 
              new StringRef(Module.Name)));
          // Clear the lock file so that future invokations can make progress.
          Locked.unsafeRemoveLockFile();
          return false;
        }
        break;
      }
      
      // Try to read the module file, now that we've compiled it.
      ASTReader.ASTReadResult ReadResult = $c$.clean($c$.track(ImportingInstance.getModuleManager()).$arrow().ReadAST(new StringRef(ModuleFileName), ModuleKind.MK_ImplicitModule, new SourceLocation(ImportLoc), 
          ModuleLoadCapabilities));
      if (ReadResult == ASTReader.ASTReadResult.OutOfDate
         && Locked.$LockFileState() == LockFileManager.LockFileState.LFS_Shared) {
        // The module may be out of date in the presence of file system races,
        // or if one of its imports depends on header search paths that are not
        // consistent with this ImportingInstance.  Try again...
        continue;
      } else if (ReadResult == ASTReader.ASTReadResult.Missing) {
        diagnoseBuildFailure.$call();
      } else if (ReadResult != ASTReader.ASTReadResult.Success
         && !Diags.hasErrorOccurred()) {
        // The ASTReader didn't diagnose the error, so conservatively report it.
        diagnoseBuildFailure.$call();
      }
      return ReadResult == ASTReader.ASTReadResult.Success;
    } finally {
      if (Locked != null) { Locked.$destroy(); }
      $c$.$destroy();
    }
  }
}

/// \brief Diagnose differences between the current definition of the given
/// configuration macro and the definition provided on the command line.
//<editor-fold defaultstate="collapsed" desc="checkConfigMacro">
@Converted(kind = Converted.Kind.MANUAL,
 optimized = Converted.Optimization.VALUE_TYPE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 1136,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 1109,
 FQN="checkConfigMacro", NM="_ZL16checkConfigMacroRN5clang12PreprocessorEN4llvm9StringRefEPNS_6ModuleENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZL16checkConfigMacroRN5clang12PreprocessorEN4llvm9StringRefEPNS_6ModuleENS_14SourceLocationE")
//</editor-fold>
public static void checkConfigMacro(Preprocessor /*&*/ PP, std.string ConfigMacro, 
                Module /*P*/ Mod, SourceLocation ImportLoc) {
  IdentifierInfo /*P*/ Id = PP.getIdentifierInfo(ConfigMacro);
  SourceManager /*&*/ SourceMgr = PP.getSourceManager();
  
  // If this identifier has never had a macro definition, then it could
  // not have changed.
  if (!Id.hadMacroDefinition()) {
    return;
  }
  MacroDirective /*P*/ LatestLocalMD = PP.getLocalMacroDirectiveHistory(Id);
  
  // Find the macro definition from the command line.
  MacroInfo /*P*/ CmdLineDefinition = null;
  for (MacroDirective /*P*/ MD = LatestLocalMD; (MD != null); MD = MD.getPrevious()) {
    // We only care about the predefines buffer.
    FileID FID = SourceMgr.getFileID(MD.getLocation());
    if (FID.isInvalid() || FID.$noteq(PP.getPredefinesFileID())) {
      continue;
    }
    {
      DefMacroDirective /*P*/ DMD = dyn_cast(DefMacroDirective.class, MD);
      if ((DMD != null)) {
        CmdLineDefinition = DMD.getMacroInfo();
      }
    }
    break;
  }
  
  MacroInfo /*P*/ CurrentDefinition = PP.getMacroInfo(Id);
  if (CurrentDefinition == CmdLineDefinition) {
    // Macro matches. Nothing to do.
  } else if (!(CurrentDefinition != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // This macro was defined on the command line, then #undef'd later.
      // Complain.
      $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($out$Same2Bool($c$.track(PP.Diag(/*NO_COPY*/ImportLoc, diag.warn_module_config_macro_undef)), 
                  true), /*NO_COPY*/ConfigMacro), new StringRef(Mod.getFullModuleName())));
      MacroDirective.DefInfo LatestDef = LatestLocalMD.getDefinition();
      assert (LatestDef.isUndefined()) : "predefined macro went away with no #undef?";
      $c$.clean($out$Same2Bool($c$.track(PP.Diag(LatestDef.getUndefLocation(), diag.note_module_def_undef_here)), 
          true));
      return;
    } finally {
      $c$.$destroy();
    }
  } else if (!(CmdLineDefinition != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // There was no definition for this macro in the predefines buffer,
      // but there was a local definition. Complain.
      $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($out$Same2Bool($c$.track(PP.Diag(/*NO_COPY*/ImportLoc, diag.warn_module_config_macro_undef)), 
                  false), /*NO_COPY*/ConfigMacro), new StringRef(Mod.getFullModuleName())));
      $c$.clean($out$Same2Bool($c$.track(PP.Diag(CurrentDefinition.getDefinitionLoc(), 
              diag.note_module_def_undef_here)), 
          false));
    } finally {
      $c$.$destroy();
    }
  } else if (!CurrentDefinition.isIdenticalTo(/*Deref*/CmdLineDefinition, PP, 
      /*Syntactically=*/ true)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // The macro definitions differ.
      $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($out$Same2Bool($c$.track(PP.Diag(/*NO_COPY*/ImportLoc, diag.warn_module_config_macro_undef)), 
                  false), /*NO_COPY*/ConfigMacro), new StringRef(Mod.getFullModuleName())));
      $c$.clean($out$Same2Bool($c$.track(PP.Diag(CurrentDefinition.getDefinitionLoc(), 
              diag.note_module_def_undef_here)), 
          false));
    } finally {
      $c$.$destroy();
    }
  }
}


/// \brief Write a new timestamp file with the given path.
//<editor-fold defaultstate="collapsed" desc="writeTimestampFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 1193,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 1166,
 FQN="writeTimestampFile", NM="_ZL18writeTimestampFileN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZL18writeTimestampFileN4llvm9StringRefE")
//</editor-fold>
public static void writeTimestampFile(StringRef TimestampFile) {
  raw_fd_ostream Out = null;
  try {
    std.error_code EC/*J*/= new std.error_code();
    Out/*J*/= new raw_fd_ostream(new StringRef(TimestampFile.str()), EC, fs.OpenFlags.F_None);
  } finally {
    if (Out != null) { Out.$destroy(); }
  }
}


/// \brief Prune the module cache of modules that haven't been accessed in
/// a long time.
//<editor-fold defaultstate="collapsed" desc="pruneModuleCache">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 1200,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 1173,
 FQN="pruneModuleCache", NM="_ZL16pruneModuleCacheRKN5clang19HeaderSearchOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZL16pruneModuleCacheRKN5clang19HeaderSearchOptionsE")
//</editor-fold>
public static void pruneModuleCache(/*const*/ HeaderSearchOptions /*&*/ HSOpts) {
   stat StatBuf/*J*/= new  stat();
  SmallString/*128*/ TimestampFile/*J*/= new SmallString/*128*/(128);
  TimestampFile.$assign(new StringRef(HSOpts.ModuleCachePath));
  assert (!TimestampFile.empty());
  path.append(TimestampFile, new Twine(/*KEEP_STR*/"modules.timestamp"));
  
  // Try to stat() the timestamp file.
  if ((/*::*/stat(TimestampFile.c_str(), /*AddrOf*/StatBuf) != 0)) {
    // If the timestamp file wasn't there, create one now.
    if (errno() == ENOENT) {
      writeTimestampFile(TimestampFile.$StringRef());
    }
    return;
  }
  
  // Check whether the time stamp is older than our pruning interval.
  // If not, do nothing.
  long/*time_t*/ TimeStampModTime = StatBuf.st_mtim.tv_sec;
  long/*time_t*/ CurrentTime = time((long$ptr/*time_t*//*P*/ )null);
  if (CurrentTime - TimeStampModTime <= ((long/*time_t*/)(HSOpts.ModuleCachePruneInterval))) {
    return;
  }
  
  // Write a new timestamp file so that nobody else attempts to prune.
  // There is a benign race condition here, if two Clang instances happen to
  // notice at the same time that the timestamp is out-of-date.
  writeTimestampFile(TimestampFile.$StringRef());
  
  // Walk the entire module cache, looking for unused module files and module
  // indices.
  std.error_code EC/*J*/= new std.error_code();
  SmallString/*128*/ ModuleCachePathNative/*J*/= new SmallString/*128*/(128);
  path.__native(new Twine(HSOpts.ModuleCachePath), ModuleCachePathNative);
  fs.directory_iterator Dir = null;
  fs.directory_iterator DirEnd = null;
  try {
    for (Dir/*J*/= new fs.directory_iterator(new Twine(ModuleCachePathNative), EC), DirEnd/*J*/= new fs.directory_iterator();
         Dir.$noteq(DirEnd) && !EC.$bool(); Dir.increment(EC)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // If we don't have a directory, there's nothing to look into.
        if (!fs.is_directory(new Twine(Dir.$arrow().getPath()))) {
          continue;
        }
        fs.directory_iterator File = null;
        fs.directory_iterator FileEnd = null;
        try {
          
          // Walk all of the files within this directory.
          for (File/*J*/= new fs.directory_iterator(new Twine(Dir.$arrow().getPath()), EC), FileEnd/*J*/= new fs.directory_iterator();
               File.$noteq(FileEnd) && !EC.$bool(); File.increment(EC)) {
            // We only care about module and global module index files.
            StringRef Extension = path.extension(new StringRef(File.$arrow().getPath()));
            if ($noteq_StringRef(/*NO_COPY*/Extension, /*STRINGREF_STR*/".pcm") && $noteq_StringRef(/*NO_COPY*/Extension, /*STRINGREF_STR*/".timestamp")
               && $noteq_StringRef(path.filename(new StringRef(File.$arrow().getPath())), /*STRINGREF_STR*/"modules.idx")) {
              continue;
            }
            
            // Look at this file. If we can't stat it, there's nothing interesting
            // there.
            if ((/*::*/stat(File.$arrow().getPath().c_str(), /*AddrOf*/StatBuf) != 0)) {
              continue;
            }
            
            // If the file has been used recently enough, leave it there.
            long/*time_t*/ FileAccessTime = StatBuf.st_atim.tv_sec;
            if (CurrentTime - FileAccessTime
               <= ((long/*time_t*/)(HSOpts.ModuleCachePruneAfter))) {
              continue;
            }
            
            // Remove the file.
            fs.remove(new Twine(File.$arrow().getPath()));
            
            // Remove the timestamp file.
            std.string TimpestampFilename = $add_string$C_T$C$P(File.$arrow().getPath(), /*KEEP_STR*/".timestamp");
            fs.remove(new Twine(TimpestampFilename));
          }
        } finally {
          if (FileEnd != null) { FileEnd.$destroy(); }
          if (File != null) { File.$destroy(); }
        }
        
        // If we removed all of the files in the directory, remove the directory
        // itself.
        if ($c$.clean($c$.track(new fs.directory_iterator(new Twine(Dir.$arrow().getPath()), EC)).$eq(
            $c$.track(new fs.directory_iterator())
        ) && !EC.$bool())) {
          fs.remove(new Twine(Dir.$arrow().getPath()));
        }
      } finally {
        $c$.$destroy();
      }
    }
  } finally {
    if (DirEnd != null) { DirEnd.$destroy(); }
    if (Dir != null) { Dir.$destroy(); }
  }
}

} // END OF class CompilerInstanceStatics
