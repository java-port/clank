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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.serialization.*;
import org.clang.frontend.*;
import static org.clang.frontend.impl.FrontendActionsStatics.*;

//<editor-fold defaultstate="collapsed" desc="clang::GenerateModuleAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 93,
 FQN="clang::GenerateModuleAction", NM="_ZN5clang20GenerateModuleActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN5clang20GenerateModuleActionE")
//</editor-fold>
public class GenerateModuleAction extends /*public*/ ASTFrontendAction implements Destructors.ClassWithDestructor {
  private Module /*P*/ Module;
  private /*const*/ FileEntry /*P*/ ModuleMapForUniquing;
  private boolean IsSystem;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::GenerateModuleAction::CreateASTConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 131,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 125,
   FQN="clang::GenerateModuleAction::CreateASTConsumer", NM="_ZN5clang20GenerateModuleAction17CreateASTConsumerERNS_16CompilerInstanceEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN5clang20GenerateModuleAction17CreateASTConsumerERNS_16CompilerInstanceEN4llvm9StringRefE")
  //</editor-fold>
  @Override protected std.unique_ptr<ASTConsumer> CreateASTConsumer(CompilerInstance /*&*/ CI, 
                   StringRef InFile)/* override*/ {
    std.unique_ptr<raw_pwrite_stream> OS = null;
    shared_ptr<PCHBuffer> Buffer = null;
    std.vector<std.unique_ptr<ASTConsumer>> Consumers = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      std.string Sysroot/*J*/= new std.string();
      std.string OutputFile/*J*/= new std.string();
      OS = ComputeASTConsumerArguments(CI, new StringRef(InFile), Sysroot, OutputFile);
      if (!OS.$bool()) {
        return new std.unique_ptr<ASTConsumer>(JD$NullPtr.INSTANCE, null);
      }
      
      Buffer = std.make_shared(new PCHBuffer());
      Consumers/*J*/= new std.vector<std.unique_ptr<ASTConsumer>>(new std.unique_ptr<ASTConsumer>());
      
      Consumers.push_back_T$RR($c$.track(new unique_ptr<ASTConsumer>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new PCHGenerator(CI.getPreprocessor(), new StringRef(OutputFile), Module, new StringRef(Sysroot), 
                  Buffer, new ArrayRef(CI.getFrontendOpts().ModuleFileExtensions), 
                  /*AllowASTWithErrors=*/ false, 
                  /*IncludeTimestamps=*/
                  /*+*/CI.getFrontendOpts().BuildingImplicitModule)))))); $c$.clean();
      Consumers.push_back_T$RR($c$.track(CI.getPCHContainerWriter().CreatePCHContainerGenerator(CI, InFile.$string(), OutputFile, $c$.track(new std.unique_ptr<raw_pwrite_stream>(JD$Move.INSTANCE, std.move(OS))), $c$.track(new std.shared_ptr<PCHBuffer>(Buffer))))); $c$.clean();
      return $c$.clean(new std.unique_ptr<ASTConsumer>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new MultiplexConsumer(std.move(Consumers))))));
    } finally {
      if (Consumers != null) { Consumers.$destroy(); }
      if (Buffer != null) { Buffer.$destroy(); }
      if (OS != null) { OS.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GenerateModuleAction::getTranslationUnitKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 102,
   FQN="clang::GenerateModuleAction::getTranslationUnitKind", NM="_ZN5clang20GenerateModuleAction22getTranslationUnitKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN5clang20GenerateModuleAction22getTranslationUnitKindEv")
  //</editor-fold>
  @Override public/*protected*/ TranslationUnitKind getTranslationUnitKind()/* override*/ {
    return TranslationUnitKind.TU_Module;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GenerateModuleAction::hasASTFileSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 106,
   FQN="clang::GenerateModuleAction::hasASTFileSupport", NM="_ZNK5clang20GenerateModuleAction17hasASTFileSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZNK5clang20GenerateModuleAction17hasASTFileSupportEv")
  //</editor-fold>
  @Override public/*protected*/ boolean hasASTFileSupport() /*const*//* override*/ {
    return false;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::GenerateModuleAction::GenerateModuleAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 109,
   FQN="clang::GenerateModuleAction::GenerateModuleAction", NM="_ZN5clang20GenerateModuleActionC1EPKNS_9FileEntryEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN5clang20GenerateModuleActionC1EPKNS_9FileEntryEb")
  //</editor-fold>
  public GenerateModuleAction() {
    this((/*const*/ FileEntry /*P*/ )null, 
      false);
  }
  public GenerateModuleAction(/*const*/ FileEntry /*P*/ ModuleMap/*= null*/) {
    this(ModuleMap, 
      false);
  }
  public GenerateModuleAction(/*const*/ FileEntry /*P*/ ModuleMap/*= null*/, 
      boolean IsSystem/*= false*/) {
    // : ASTFrontendAction(), ModuleMapForUniquing(ModuleMap), IsSystem(IsSystem) 
    //START JInit
    super();
    this.ModuleMapForUniquing = ModuleMap;
    this.IsSystem = IsSystem;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GenerateModuleAction::BeginSourceFileAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 270,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 271,
   FQN="clang::GenerateModuleAction::BeginSourceFileAction", NM="_ZN5clang20GenerateModuleAction21BeginSourceFileActionERNS_16CompilerInstanceEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN5clang20GenerateModuleAction21BeginSourceFileActionERNS_16CompilerInstanceEN4llvm9StringRefE")
  //</editor-fold>
  @Override public boolean BeginSourceFileAction(CompilerInstance /*&*/ CI, 
                       StringRef Filename)/* override*/ {
    Module.UnresolvedHeaderDirective MissingHeader = null;
    std.unique_ptr<MemoryBuffer> InputBuffer = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      CI.getLangOpts().CompilingModule = true;
      
      // Find the module map file.
      /*const*/ FileEntry /*P*/ ModuleMap = CI.getFileManager().getFile(/*NO_COPY*/Filename, /*openFile*/ true);
      if (!(ModuleMap != null)) {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(CI.getDiagnostics().Report(diag.err_module_map_not_found)), 
            /*NO_COPY*/Filename));
        return false;
      }
      
      // Set up embedding for any specified files. Do this before we load any
      // source files, including the primary module map for the compilation.
      for (/*const*/std.string/*&*/ F : CI.getFrontendOpts().ModulesEmbedFiles) {
        {
          /*const*/ FileEntry /*P*/ FE = CI.getFileManager().getFile(new StringRef(F), /*openFile*/ true);
          if ((FE != null)) {
            CI.getSourceManager().setFileIsTransient(FE);
          } else {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(CI.getDiagnostics().Report(diag.err_modules_embed_file_not_found)), new StringRef(F)));
          }
        }
      }
      if (CI.getFrontendOpts().ModulesEmbedAllFiles) {
        CI.getSourceManager().setAllFilesAreTransient(true);
      }
      
      // Parse the module map file.
      HeaderSearch /*&*/ HS = CI.getPreprocessor().getHeaderSearchInfo();
      if (HS.loadModuleMapFile(ModuleMap, IsSystem)) {
        return false;
      }
      if (CI.getLangOpts().CurrentModule.empty()) {
        $c$.clean($c$.track(CI.getDiagnostics().Report(diag.err_missing_module_name)));
        
        // FIXME: Eventually, we could consider asking whether there was just
        // a single module described in the module map, and use that as a 
        // default. Then it would be fairly trivial to just "compile" a module
        // map with a single module (the common case).
        return false;
      }
      
      // If we're being run from the command-line, the module build stack will not
      // have been filled in yet, so complete it now in order to allow us to detect
      // module cycles.
      SourceManager /*&*/ SourceMgr = CI.getSourceManager();
      if (SourceMgr.getModuleBuildStack().empty()) {
        SourceMgr.pushModuleBuildStack(new StringRef(CI.getLangOpts().CurrentModule), 
            new FullSourceLoc(new SourceLocation(), SourceMgr));
      }
      
      // Dig out the module definition.
      Module = HS.lookupModule(new StringRef(CI.getLangOpts().CurrentModule), 
          /*AllowSearch=*/ false);
      if (!(Module != null)) {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(CI.getDiagnostics().Report(diag.err_missing_module)), 
                new StringRef(CI.getLangOpts().CurrentModule)), /*NO_COPY*/Filename));
        
        return false;
      }
      
      // Check whether we can build this module at all.
      std.pairTypeBool<std.string> Requirement/*J*/= new std.pairTypeBool<std.string>(new std.string(), false);
      MissingHeader/*J*/= new Module.UnresolvedHeaderDirective();
      if (!Module.isAvailable(CI.getLangOpts(), CI.getTarget(), Requirement, 
          MissingHeader)) {
        if (MissingHeader.FileNameLoc.isValid()) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out$Same2Bool($c$.track(CI.getDiagnostics().Report(/*NO_COPY*/MissingHeader.FileNameLoc, 
                      diag.err_module_header_missing)), 
                  MissingHeader.IsUmbrella), new StringRef(MissingHeader.FileName)));
        } else {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out$Same2Bool($out_DiagnosticBuilder$C_StringRef($c$.track(CI.getDiagnostics().Report(diag.err_module_unavailable)), 
                      new StringRef(Module.getFullModuleName())), 
                  Requirement.second), new StringRef(Requirement.first)));
        }
        
        return false;
      }
      if ((ModuleMapForUniquing != null) && ModuleMapForUniquing != ModuleMap) {
        Module.IsInferred = true;
        HS.getModuleMap().setInferredModuleAllowedBy(Module, ModuleMapForUniquing);
      } else {
        ModuleMapForUniquing = ModuleMap;
      }
      
      FileManager /*&*/ FileMgr = CI.getFileManager();
      
      // Collect the set of #includes we need to build the module.
      SmallString/*256*/ HeaderContents/*J*/= new SmallString/*256*/(256);
      std.error_code Err = new std.error_code();
      {
        Module.Header UmbrellaHeader = null;
        try {
          UmbrellaHeader = Module.getUmbrellaHeader();
          if (UmbrellaHeader.$bool()) {
            addHeaderInclude(new StringRef(UmbrellaHeader.NameAsWritten), HeaderContents, 
                CI.getLangOpts(), Module.IsExternC);
          }
        } finally {
          if (UmbrellaHeader != null) { UmbrellaHeader.$destroy(); }
        }
      }
      Err.$assignMove(collectModuleHeaderIncludes(CI.getLangOpts(), FileMgr, 
              CI.getPreprocessor().getHeaderSearchInfo().getModuleMap(), Module, 
              HeaderContents));
      if (Err.$bool()) {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(CI.getDiagnostics().Report(diag.err_module_cannot_create_includes)), 
                new StringRef(Module.getFullModuleName())), new StringRef(Err.message())));
        return false;
      }
      
      // Inform the preprocessor that includes from within the input buffer should
      // be resolved relative to the build directory of the module map file.
      CI.getPreprocessor().setMainFileDir(Module.Directory);
      
      InputBuffer = MemoryBuffer.getMemBufferCopy(HeaderContents.$StringRef(), 
          new Twine(Module.getModuleInputBufferName()));
      // Ownership of InputBuffer will be transferred to the SourceManager.
      setCurrentInput($c$.track(new FrontendInputFile(InputBuffer.release(), getCurrentFileKind(), 
              Module.IsSystem))); $c$.clean();
      return true;
    } finally {
      if (InputBuffer != null) { InputBuffer.$destroy(); }
      if (MissingHeader != null) { MissingHeader.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// \brief Compute the AST consumer arguments that will be used to
  /// create the PCHGenerator instance returned by CreateASTConsumer.
  ///
  /// \returns true if an error occurred, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::GenerateModuleAction::ComputeASTConsumerArguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 384,
   FQN="clang::GenerateModuleAction::ComputeASTConsumerArguments", NM="_ZN5clang20GenerateModuleAction27ComputeASTConsumerArgumentsERNS_16CompilerInstanceEN4llvm9StringRefERSsS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN5clang20GenerateModuleAction27ComputeASTConsumerArgumentsERNS_16CompilerInstanceEN4llvm9StringRefERSsS5_")
  //</editor-fold>
  public std.unique_ptr<raw_pwrite_stream> ComputeASTConsumerArguments(CompilerInstance /*&*/ CI, 
                             StringRef InFile, 
                             std.string/*&*/ Sysroot, 
                             std.string/*&*/ OutputFile) {
    std.unique_ptr<raw_pwrite_stream> OS = null;
    try {
      // If no output file was provided, figure out where this module would go
      // in the module cache.
      if (CI.getFrontendOpts().OutputFile.empty()) {
        HeaderSearch /*&*/ HS = CI.getPreprocessor().getHeaderSearchInfo();
        CI.getFrontendOpts().OutputFile.$assignMove(
            HS.getModuleFileName(new StringRef(CI.getLangOpts().CurrentModule), 
                new StringRef(ModuleMapForUniquing.getName()))
        );
      }
      
      // We use createOutputFile here because this is exposed via libclang, and we
      // must disable the RemoveFileOnSignal behavior.
      // We use a temporary to avoid race conditions.
      OS = CI.createOutputFile(new StringRef(CI.getFrontendOpts().OutputFile), /*Binary=*/ true, 
          /*RemoveFileOnSignal=*/ false, new StringRef(InFile), 
          /*Extension=*/ new StringRef(/*KEEP_STR*/$EMPTY), /*useTemporary=*/ true, 
          /*CreateMissingDirectories=*/ true);
      if (!OS.$bool()) {
        return new std.unique_ptr<raw_pwrite_stream>(JD$NullPtr.INSTANCE, null);
      }
      
      OutputFile.$assign(CI.getFrontendOpts().OutputFile);
      return new std.unique_ptr<raw_pwrite_stream>(JD$Move.INSTANCE, OS);
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GenerateModuleAction::~GenerateModuleAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 93,
   FQN="clang::GenerateModuleAction::~GenerateModuleAction", NM="_ZN5clang20GenerateModuleActionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN5clang20GenerateModuleActionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Module=" + Module // NOI18N
              + ", ModuleMapForUniquing=" + ModuleMapForUniquing // NOI18N
              + ", IsSystem=" + IsSystem // NOI18N
              + super.toString(); // NOI18N
  }
}
