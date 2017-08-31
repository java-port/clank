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

package org.clang.codegen;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.lex.*;
import org.llvm.ir.*;
import org.llvm.ir.Module;
import org.clang.codegen.*;
import org.clang.codegen.impl.*;
import static org.clang.codegen.CodegenClangGlobals.*;
import static org.clang.codegen.impl.CodeGenActionStatics.*;
import org.clang.frontend.*;
import org.clang.basic.target.TargetOptions;
import static org.llvm.irreader.IRReaderLlvmGlobals.parseIR;
import static org.llvm.bitcode.BitcodeLlvmGlobals.*;

//<editor-fold defaultstate="collapsed" desc="clang::CodeGenAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CodeGenAction.h", line = 24,
 FQN="clang::CodeGenAction", NM="_ZN5clang13CodeGenActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang13CodeGenActionE")
//</editor-fold>
public class CodeGenAction extends /*public*/ ASTFrontendAction implements Destructors.ClassWithDestructor {
/*private:*/
  private /*uint*/int Act;
  private std.unique_ptr<Module> TheModule;
  // Vector of {Linker::Flags, Module*} pairs to specify bitcode
  // modules to link in using corresponding linker flags.
  private SmallVector<std.pairUIntType<Module /*P*/ >> LinkModules;
  private LLVMContext /*P*/ VMContext;
  private boolean OwnsVMContext;
/*protected:*/
  /// Create a new code generation action.  If the optional \p _VMContext
  /// parameter is supplied, the action uses it without taking ownership,
  /// otherwise it creates a fresh LLVM context and takes ownership.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenAction::CodeGenAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 661,
   FQN="clang::CodeGenAction::CodeGenAction", NM="_ZN5clang13CodeGenActionC1EjPN4llvm11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang13CodeGenActionC1EjPN4llvm11LLVMContextE")
  //</editor-fold>
  protected CodeGenAction(/*uint*/int _Act) {
    this(_Act, (LLVMContext /*P*/ )null);
  }
  protected CodeGenAction(/*uint*/int _Act, LLVMContext /*P*/ _VMContext/*= null*/) {
    // : ASTFrontendAction(), Act(_Act), TheModule(), LinkModules(), VMContext(_VMContext ? _VMContext : new LLVMContext), OwnsVMContext(!_VMContext) 
    //START JInit
    super();
    this.Act = _Act;
    this.TheModule = new std.unique_ptr<Module>();
    this.LinkModules = new SmallVector<std.pairUIntType<Module /*P*/ >>(4, new std.pairUIntPtr<Module /*P*/ >());
    this.VMContext = (_VMContext != null) ? _VMContext : new LLVMContext();
    this.OwnsVMContext = !(_VMContext != null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenAction::hasIRSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 671,
   FQN="clang::CodeGenAction::hasIRSupport", NM="_ZNK5clang13CodeGenAction12hasIRSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZNK5clang13CodeGenAction12hasIRSupportEv")
  //</editor-fold>
  @Override public/*protected*/ boolean hasIRSupport() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenAction::CreateASTConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 715,
   FQN="clang::CodeGenAction::CreateASTConsumer", NM="_ZN5clang13CodeGenAction17CreateASTConsumerERNS_16CompilerInstanceEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang13CodeGenAction17CreateASTConsumerERNS_16CompilerInstanceEN4llvm9StringRefE")
  //</editor-fold>
  @Override protected std.unique_ptr<ASTConsumer> CreateASTConsumer(final CompilerInstance /*&*/ CI, StringRef InFile)/* override*/ {
    std.unique_ptr<raw_pwrite_stream> OS = null;
    std.unique_ptr<BackendConsumer> Result = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      BackendAction BA = /*static_cast*/BackendAction.valueOf(Act);
      OS = GetOutputStream(CI, new StringRef(InFile), BA);
      if (BA != BackendAction.Backend_EmitNothing && !OS.$bool()) {
        return new std.unique_ptr<ASTConsumer>(JD$NullPtr.INSTANCE, null);
      }
      
      // Load bitcode modules to link with, if we need to.
      if (LinkModules.empty()) {
        for (final std.pairUIntType<std.string> /*&*/ I : CI.getCodeGenOpts().LinkBitcodeFiles) {
          ErrorOr<unique_ptr<MemoryBuffer> > BCBuf = null;
          ErrorOr<std.unique_ptr<Module> > ModuleOrErr = null;
          try {
            final /*const*/std.string/*&*/ LinkBCFile = I.second;
            
            BCBuf = CI.getFileManager().getBufferForFile(new StringRef(LinkBCFile));
            if (!BCBuf.$bool()) {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(CI.getDiagnostics().Report(diag.err_cannot_open_file)), 
                      new StringRef(LinkBCFile)), new StringRef(BCBuf.getError().message())));
              LinkModules.clear();
              return new std.unique_ptr<ASTConsumer>(JD$NullPtr.INSTANCE, null);
            }
            
            ModuleOrErr = getLazyBitcodeModule(std.move(BCBuf.$star()), /*Deref*/VMContext);
            {
              std.error_code EC = ModuleOrErr.getError();
              if (EC.$bool()) {
                $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(CI.getDiagnostics().Report(diag.err_cannot_open_file)), new StringRef(LinkBCFile)), 
                    new StringRef(EC.message())));
                LinkModules.clear();
                return new std.unique_ptr<ASTConsumer>(JD$NullPtr.INSTANCE, null);
              }
            }
            addLinkModule(ModuleOrErr.get().release(), I.first);
          } finally {
            if (ModuleOrErr != null) { ModuleOrErr.$destroy(); }
            if (BCBuf != null) { BCBuf.$destroy(); }
          }
        }
      }
      
      CoverageSourceInfo /*P*/ CoverageInfo = null;
      // Add the preprocessor callback only when the coverage mapping is generated.
      if (CI.getCodeGenOpts().CoverageMapping) {
        CoverageInfo = new CoverageSourceInfo();
        CI.getPreprocessor().addPPCallbacks($c$.track(new std.unique_ptr<PPCallbacks>(CoverageInfo))); $c$.clean();
      }
      
      Result/*J*/= $c$.clean(new std.unique_ptr<BackendConsumer>(new BackendConsumer(BA, CI.getDiagnostics(), CI.getHeaderSearchOpts(), 
              CI.getPreprocessorOpts(), CI.getCodeGenOpts(), CI.getTargetOpts(), 
              CI.getLangOpts(), CI.getFrontendOpts().ShowTimers, InFile.$string(), LinkModules, 
              $c$.track(new std.unique_ptr<raw_pwrite_stream>(JD$Move.INSTANCE, std.move(OS))), /*Deref*/VMContext, CoverageInfo)));
      BEConsumer = Result.get();
      return new std.unique_ptr<ASTConsumer>(JD$Unique_ptr$_Up$_Ep.INSTANCE, std.move(Result));
    } finally {
      if (Result != null) { Result.$destroy(); }
      if (OS != null) { OS.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenAction::ExecuteAction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 785,
   FQN="clang::CodeGenAction::ExecuteAction", NM="_ZN5clang13CodeGenAction13ExecuteActionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang13CodeGenAction13ExecuteActionEv")
  //</editor-fold>
  @Override protected void ExecuteAction()/* override*/ {
    // If this is an IR file, we have to treat it specially.
    if (getCurrentFileKind() == InputKind.IK_LLVM_IR) {
      std.unique_ptr<raw_pwrite_stream> OS = null;
      SMDiagnostic Err = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        BackendAction BA = /*static_cast*/BackendAction.valueOf(Act);
        final CompilerInstance /*&*/ CI = getCompilerInstance();
        OS = GetOutputStream(CI, getCurrentFile(), BA);
        if (BA != BackendAction.Backend_EmitNothing && !OS.$bool()) {
          return;
        }
        
        bool$ptr Invalid = create_bool$ptr();
        final SourceManager /*&*/ SM = CI.getSourceManager();
        FileID FID = SM.getMainFileID();
        MemoryBuffer /*P*/ MainFile = SM.getBuffer(/*NO_COPY*/FID, /*AddrOf*/Invalid);
        if (Invalid.$star()) {
          return;
        }
        
        // For ThinLTO backend invocations, ensure that the context
        // merges types based on ODR identifiers.
        if (!CI.getCodeGenOpts().ThinLTOIndexFile.empty()) {
          VMContext.enableDebugTypeODRUniquing();
        }
        
        Err/*J*/= new SMDiagnostic();
        $c$.clean(TheModule.$assignMove($c$.track(parseIR(MainFile.getMemBufferRef(), Err, /*Deref*/VMContext))));
        if (!TheModule.$bool()) {
          // Translate from the diagnostic info to the SourceManager location if
          // available.
          // TODO: Unify this with ConvertBackendLocation()
          SourceLocation Loc/*J*/= new SourceLocation();
          if (Err.getLineNo() > 0) {
            assert (Err.getColumnNo() >= 0);
            Loc.$assignMove(SM.translateFileLineCol(SM.getFileEntryForID(/*NO_COPY*/FID), 
                    Err.getLineNo(), Err.getColumnNo() + 1));
          }
          
          // Strip off a leading diagnostic code if there is one.
          StringRef Msg = Err.getMessage();
          if (Msg.startswith(/*STRINGREF_STR*/"error: ")) {
            Msg.$assignMove(Msg.substr(7));
          }
          
          /*uint*/int DiagID = CI.getDiagnostics().getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, /*KEEP_STR*/"%0");
          
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(CI.getDiagnostics().Report(/*NO_COPY*/Loc, DiagID)), /*NO_COPY*/Msg));
          return;
        }
        final /*const*/ TargetOptions /*&*/ TargetOpts = CI.getTargetOpts();
        if ($noteq_string$C(TheModule.$arrow().getTargetTriple(), TargetOpts.Triple)) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(CI.getDiagnostics().Report(new SourceLocation(), 
                  diag.warn_fe_override_module)), 
              new StringRef(TargetOpts.Triple)));
          TheModule.$arrow().setTargetTriple(new StringRef(TargetOpts.Triple));
        }
        
        EmbedBitcode(TheModule.get(), CI.getCodeGenOpts(), 
            MainFile.getMemBufferRef());
        
        final LLVMContext /*&*/ Ctx = TheModule.$arrow().getContext();
        Ctx.setInlineAsmDiagnosticHandler(/*FuncRef*/CodeGenActionStatics::BitcodeInlineAsmDiagHandler, 
            /*AddrOf*/CI.getDiagnostics());
        
        EmitBackendOutput(CI.getDiagnostics(), CI.getCodeGenOpts(), TargetOpts, 
            CI.getLangOpts(), CI.getTarget().getDataLayout(), 
            TheModule.get(), BA, $c$.track(new std.unique_ptr<raw_pwrite_stream>(JD$Move.INSTANCE, std.move(OS)))); $c$.clean();
        return;
      } finally {
        if (Err != null) { Err.$destroy(); }
        if (OS != null) { OS.$destroy(); }
        $c$.$destroy();
      }
    }
    
    // Otherwise follow the normal AST path.
    /*J:ToBase*/super.ExecuteAction();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenAction::EndSourceFileAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 673,
   FQN="clang::CodeGenAction::EndSourceFileAction", NM="_ZN5clang13CodeGenAction19EndSourceFileActionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang13CodeGenAction19EndSourceFileActionEv")
  //</editor-fold>
  @Override protected void EndSourceFileAction()/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // If the consumer creation failed, do nothing.
      if (!getCompilerInstance().hasASTConsumer()) {
        return;
      }
      
      // Take back ownership of link modules we passed to consumer.
      if (!LinkModules.empty()) {
        BEConsumer.releaseLinkModules();
      }
      
      // Steal the module from the consumer.
      $c$.clean(TheModule.$assignMove($c$.track(BEConsumer.takeModule())));
    } finally {
      $c$.$destroy();
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenAction::~CodeGenAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 665,
   FQN="clang::CodeGenAction::~CodeGenAction", NM="_ZN5clang13CodeGenActionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang13CodeGenActionD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    TheModule.reset();
    if (OwnsVMContext) {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)VMContext);
    }
    //START JDestroy
    LinkModules.$destroy();
    TheModule.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  /// setLinkModule - Set the link module to be used by this action.  If a link
  /// module is not provided, and CodeGenOptions::LinkBitcodeFile is non-empty,
  /// the action will load it from the specified file.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenAction::addLinkModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CodeGenAction.h", line = 55,
   FQN="clang::CodeGenAction::addLinkModule", NM="_ZN5clang13CodeGenAction13addLinkModuleEPN4llvm6ModuleEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang13CodeGenAction13addLinkModuleEPN4llvm6ModuleEj")
  //</editor-fold>
  public void addLinkModule(Module /*P*/ Mod, /*uint*/int LinkFlags) {
    LinkModules.push_back(std.make_pair_uint_Ptr(LinkFlags, Mod));
  }

  
  /// Take the generated LLVM module, for use after the action has been run.
  /// The result may be null on failure.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenAction::takeModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 686,
   FQN="clang::CodeGenAction::takeModule", NM="_ZN5clang13CodeGenAction10takeModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang13CodeGenAction10takeModuleEv")
  //</editor-fold>
  public std.unique_ptr<Module> takeModule() {
    return new std.unique_ptr<Module>(JD$Move.INSTANCE, std.move(TheModule));
  }

  
  /// Take the LLVM context used by this action.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenAction::takeLLVMContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 690,
   FQN="clang::CodeGenAction::takeLLVMContext", NM="_ZN5clang13CodeGenAction15takeLLVMContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang13CodeGenAction15takeLLVMContextEv")
  //</editor-fold>
  public LLVMContext /*P*/ takeLLVMContext() {
    OwnsVMContext = false;
    return VMContext;
  }

  
  public BackendConsumer /*P*/ BEConsumer;
  
  @Override public String toString() {
    return "" + "Act=" + Act // NOI18N
              + ", TheModule=" + TheModule // NOI18N
              + ", LinkModules=" + LinkModules // NOI18N
              + ", VMContext=" + "[LLVMContext]" // NOI18N
              + ", OwnsVMContext=" + OwnsVMContext // NOI18N
              + ", BEConsumer=" + "[BackendConsumer]" // NOI18N
              + super.toString(); // NOI18N
  }
}
