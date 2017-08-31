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

package org.clang.codegen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.lex.*;
import org.llvm.ir.*;
import org.llvm.ir.Module;
import org.llvm.ir.java.IRFunctionPointers.*;
import org.clang.codegen.*;
import org.clang.codegen.impl.*;
import org.clang.driver.frontend.CodeGenOptions;
import org.clang.basic.target.TargetOptions;
import static org.clang.codegen.CodegenClangGlobals.*;
import static org.clang.codegen.impl.CodeGenActionStatics.*;
import org.llvm.linker.Linker;
import org.llvm.pass.IrLlvmGlobals;
import org.llvm.adt.ADTFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;

//<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 42,
 FQN="clang::BackendConsumer", NM="_ZN5clang15BackendConsumerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumerE")
//</editor-fold>
public class BackendConsumer extends /*public*/ ASTConsumer implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 262,
   FQN="clang::BackendConsumer::anchor", NM="_ZN5clang15BackendConsumer6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

  private final DiagnosticsEngine /*&*/ Diags;
  private BackendAction Action;
  private final /*const*/ CodeGenOptions /*&*/ CodeGenOpts;
  private final /*const*/ TargetOptions /*&*/ TargetOpts;
  private final /*const*/ LangOptions /*&*/ LangOpts;
  private std.unique_ptr<raw_pwrite_stream> AsmOutStream;
  private ASTContext /*P*/ Context;
  
  private Timer LLVMIRGeneration;
  
  private std.unique_ptr<CodeGenerator> Gen;
  
  private SmallVector<std.pairUIntType<std.unique_ptr<Module>>> LinkModules;
  
  // This is here so that the diagnostic printer knows the module a diagnostic
  // refers to.
  private Module /*P*/ CurLinkModule/* = null*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::BackendConsumer">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 64,
   FQN="clang::BackendConsumer::BackendConsumer", NM="_ZN5clang15BackendConsumerC1ENS_13BackendActionERNS_17DiagnosticsEngineERKNS_19HeaderSearchOptionsERKNS_19PreprocessorOptionsERKNS_14CodeGenOptionsERKNS_13TargetOptionsERKNS_11LangOptionsEbRKSsRKN4llvm15SmallVectorImplISt4pairIjPNSL_6ModuleEEEESt10unique_ptrINSL_17raw_pwrite_streamESt14default_deleteISV_EERNSL_11LLVMContextEPNS_18CoverageSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumerC1ENS_13BackendActionERNS_17DiagnosticsEngineERKNS_19HeaderSearchOptionsERKNS_19PreprocessorOptionsERKNS_14CodeGenOptionsERKNS_13TargetOptionsERKNS_11LangOptionsEbRKSsRKN4llvm15SmallVectorImplISt4pairIjPNSL_6ModuleEEEESt10unique_ptrINSL_17raw_pwrite_streamESt14default_deleteISV_EERNSL_11LLVMContextEPNS_18CoverageSourceInfoE")
  //</editor-fold>
  public BackendConsumer(BackendAction Action, final DiagnosticsEngine /*&*/ Diags, 
      final /*const*/ HeaderSearchOptions /*&*/ HeaderSearchOpts, 
      final /*const*/ PreprocessorOptions /*&*/ PPOpts, final /*const*/ CodeGenOptions /*&*/ CodeGenOpts, 
      final /*const*/ TargetOptions /*&*/ TargetOpts, final /*const*/ LangOptions /*&*/ LangOpts, 
      boolean TimePasses, final /*const*/std.string/*&*/ InFile, 
      final /*const*/ SmallVectorImpl<std.pairUIntType<Module /*P*/ > > /*&*/ LinkModules, 
      std.unique_ptr<raw_pwrite_stream> OS, final LLVMContext /*&*/ C) {
    this(Action, Diags, 
      HeaderSearchOpts, 
      PPOpts, CodeGenOpts, 
      TargetOpts, LangOpts, 
      TimePasses, InFile, 
      LinkModules, 
      OS, C, 
      (CoverageSourceInfo /*P*/ )null);
  }
  public BackendConsumer(BackendAction Action, final DiagnosticsEngine /*&*/ Diags, 
      final /*const*/ HeaderSearchOptions /*&*/ HeaderSearchOpts, 
      final /*const*/ PreprocessorOptions /*&*/ PPOpts, final /*const*/ CodeGenOptions /*&*/ CodeGenOpts, 
      final /*const*/ TargetOptions /*&*/ TargetOpts, final /*const*/ LangOptions /*&*/ LangOpts, 
      boolean TimePasses, final /*const*/std.string/*&*/ InFile, 
      final /*const*/ SmallVectorImpl<std.pairUIntType<Module /*P*/ > > /*&*/ LinkModules, 
      std.unique_ptr<raw_pwrite_stream> OS, final LLVMContext /*&*/ C, 
      CoverageSourceInfo /*P*/ CoverageInfo/*= null*/) {
    // : ASTConsumer(), Diags(Diags), Action(Action), CodeGenOpts(CodeGenOpts), TargetOpts(TargetOpts), LangOpts(LangOpts), AsmOutStream(std::move(OS)), Context(null), LLVMIRGeneration("LLVM IR Generation Time"), Gen(CreateLLVMCodeGen(Diags, InFile, HeaderSearchOpts, PPOpts, CodeGenOpts, C, CoverageInfo)), LinkModules(), CurLinkModule(null) 
    //START JInit
    super();
    this./*&*/Diags=/*&*/Diags;
    this.Action = Action;
    this./*&*/CodeGenOpts=/*&*/CodeGenOpts;
    this./*&*/TargetOpts=/*&*/TargetOpts;
    this./*&*/LangOpts=/*&*/LangOpts;
    this.AsmOutStream = new std.unique_ptr<raw_pwrite_stream>(JD$Move.INSTANCE, std.move(OS));
    this.Context = null;
    this.LLVMIRGeneration = new Timer(new StringRef(/*KEEP_STR*/"LLVM IR Generation Time"));
    this.Gen = new std.unique_ptr<CodeGenerator>(CreateLLVMCodeGen(Diags, new StringRef(InFile), HeaderSearchOpts, PPOpts, 
            CodeGenOpts, C, CoverageInfo));
    this.LinkModules = new SmallVector<std.pairUIntType<std.unique_ptr<Module>>>(4, new std.pairUIntType<std.unique_ptr<Module>>(0, new std.unique_ptr<Module>()));
    /*InClass*/this.CurLinkModule = null;
    //END JInit
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      IrLlvmGlobals.TimePassesIsEnabled = TimePasses;
      for (final /*constconst*/std.pairUIntType<Module /*P*/ > /*&*/ I : LinkModules)  {
        this.LinkModules.push_back_T$RR($c$.track(std.make_pair_uint_T(I.first, $c$.track(new std.unique_ptr<Module>(I.second))))); $c$.clean();
      }
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::getModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 84,
   FQN="clang::BackendConsumer::getModule", NM="_ZNK5clang15BackendConsumer9getModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZNK5clang15BackendConsumer9getModuleEv")
  //</editor-fold>
  public Module /*P*/ getModule() /*const*/ {
    return Gen.$arrow().GetModule();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::takeModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 85,
   FQN="clang::BackendConsumer::takeModule", NM="_ZN5clang15BackendConsumer10takeModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer10takeModuleEv")
  //</editor-fold>
  public std.unique_ptr<Module> takeModule() {
    return new std.unique_ptr<Module>(Gen.$arrow().ReleaseModule());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::releaseLinkModules">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 88,
   FQN="clang::BackendConsumer::releaseLinkModules", NM="_ZN5clang15BackendConsumer18releaseLinkModulesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer18releaseLinkModulesEv")
  //</editor-fold>
  public void releaseLinkModules() {
    for (final std.pairUIntType<unique_ptr<Module>> /*&*/ I : LinkModules)  {
      I.second.release();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::HandleCXXStaticMemberVarInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 93,
   FQN="clang::BackendConsumer::HandleCXXStaticMemberVarInstantiation", NM="_ZN5clang15BackendConsumer37HandleCXXStaticMemberVarInstantiationEPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer37HandleCXXStaticMemberVarInstantiationEPNS_7VarDeclE")
  //</editor-fold>
  @Override public void HandleCXXStaticMemberVarInstantiation(VarDecl /*P*/ VD)/* override*/ {
    Gen.$arrow().HandleCXXStaticMemberVarInstantiation(VD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::Initialize">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 97,
   FQN="clang::BackendConsumer::Initialize", NM="_ZN5clang15BackendConsumer10InitializeERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer10InitializeERNS_10ASTContextE")
  //</editor-fold>
  @Override public void Initialize(final ASTContext /*&*/ Ctx)/* override*/ {
    assert (!(Context != null)) : "initialized multiple times";
    
    Context = /*AddrOf*/Ctx;
    if (IrLlvmGlobals.TimePassesIsEnabled) {
      LLVMIRGeneration.startTimer();
    }
    
    Gen.$arrow().Initialize(Ctx);
    if (IrLlvmGlobals.TimePassesIsEnabled) {
      LLVMIRGeneration.stopTimer();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::HandleTopLevelDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 111,
   FQN="clang::BackendConsumer::HandleTopLevelDecl", NM="_ZN5clang15BackendConsumer18HandleTopLevelDeclENS_12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer18HandleTopLevelDeclENS_12DeclGroupRefE")
  //</editor-fold>
  @Override public boolean HandleTopLevelDecl(DeclGroupRef D)/* override*/ {
    PrettyStackTraceDecl CrashInfo = null;
    try {
      CrashInfo/*J*/= new PrettyStackTraceDecl(D.begin().$star(), new SourceLocation(), 
          Context.getSourceManager(), 
          $("LLVM IR generation of declaration"));
      if (IrLlvmGlobals.TimePassesIsEnabled) {
        LLVMIRGeneration.startTimer();
      }
      
      Gen.$arrow().HandleTopLevelDecl(new DeclGroupRef(D));
      if (IrLlvmGlobals.TimePassesIsEnabled) {
        LLVMIRGeneration.stopTimer();
      }
      
      return true;
    } finally {
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::HandleInlineFunctionDefinition">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 127,
   FQN="clang::BackendConsumer::HandleInlineFunctionDefinition", NM="_ZN5clang15BackendConsumer30HandleInlineFunctionDefinitionEPNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer30HandleInlineFunctionDefinitionEPNS_12FunctionDeclE")
  //</editor-fold>
  @Override public void HandleInlineFunctionDefinition(FunctionDecl /*P*/ D)/* override*/ {
    PrettyStackTraceDecl CrashInfo = null;
    try {
      CrashInfo/*J*/= new PrettyStackTraceDecl(D, new SourceLocation(), 
          Context.getSourceManager(), 
          $("LLVM IR generation of inline function"));
      if (IrLlvmGlobals.TimePassesIsEnabled) {
        LLVMIRGeneration.startTimer();
      }
      
      Gen.$arrow().HandleInlineFunctionDefinition(D);
      if (IrLlvmGlobals.TimePassesIsEnabled) {
        LLVMIRGeneration.stopTimer();
      }
    } finally {
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::HandleTranslationUnit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 140,
   FQN="clang::BackendConsumer::HandleTranslationUnit", NM="_ZN5clang15BackendConsumer21HandleTranslationUnitERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer21HandleTranslationUnitERNS_10ASTContextE")
  //</editor-fold>
  @Override public void HandleTranslationUnit(final ASTContext /*&*/ C)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      {
        PrettyStackTraceString CrashInfo = null;
        try {
          CrashInfo/*J*/= new PrettyStackTraceString($("Per-file LLVM IR generation"));
          if (IrLlvmGlobals.TimePassesIsEnabled) {
            LLVMIRGeneration.startTimer();
          }
          
          Gen.$arrow().HandleTranslationUnit(C);
          if (IrLlvmGlobals.TimePassesIsEnabled) {
            LLVMIRGeneration.stopTimer();
          }
        } finally {
          if (CrashInfo != null) { CrashInfo.$destroy(); }
        }
      }
      
      // Silently ignore if we weren't initialized for some reason.
      if (!(getModule() != null)) {
        return;
      }
      
      // Install an inline asm handler so that diagnostics get printed through
      // our diagnostics hooks.
      final LLVMContext /*&*/ Ctx = getModule().getContext();
      SMDiagnosticHandler OldHandler = Ctx.getInlineAsmDiagnosticHandler();
      Object/*void P*/ OldContext = Ctx.getInlineAsmDiagnosticContext();
      Ctx.setInlineAsmDiagnosticHandler(/*FuncRef*/BackendConsumer::InlineAsmDiagHandler, this);
      
      DiagnosticInfoHandler OldDiagnosticHandler = Ctx.getDiagnosticHandler();
      Object/*void P*/ OldDiagnosticContext = Ctx.getDiagnosticContext();
      Ctx.setDiagnosticHandler(/*FuncRef*/BackendConsumer::DiagnosticHandler, this);
      
      // Link LinkModule into this module if present, preserving its validity.
      for (final std.pairUIntType<unique_ptr<Module>> /*&*/ I : LinkModules) {
        /*uint*/int LinkFlags = I.first;
        CurLinkModule = I.second.get();
        if ($c$.clean(Linker.linkModules(/*Deref*/getModule(), $c$.track(new std.unique_ptr<Module>(JD$Move.INSTANCE, std.move(I.second))), LinkFlags))) {
          return;
        }
      }
      
      EmbedBitcode(getModule(), CodeGenOpts, new MemoryBufferRef());
      
      EmitBackendOutput(Diags, CodeGenOpts, TargetOpts, LangOpts, 
          C.getTargetInfo().getDataLayout(), 
          getModule(), Action, $c$.track(new std.unique_ptr<raw_pwrite_stream>(JD$Move.INSTANCE, std.move(AsmOutStream)))); $c$.clean();
      
      Ctx.setInlineAsmDiagnosticHandler(OldHandler, OldContext);
      
      Ctx.setDiagnosticHandler(OldDiagnosticHandler, OldDiagnosticContext);
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::HandleTagDeclDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 188,
   FQN="clang::BackendConsumer::HandleTagDeclDefinition", NM="_ZN5clang15BackendConsumer23HandleTagDeclDefinitionEPNS_7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer23HandleTagDeclDefinitionEPNS_7TagDeclE")
  //</editor-fold>
  @Override public void HandleTagDeclDefinition(TagDecl /*P*/ D)/* override*/ {
    PrettyStackTraceDecl CrashInfo = null;
    try {
      CrashInfo/*J*/= new PrettyStackTraceDecl(D, new SourceLocation(), 
          Context.getSourceManager(), 
          $("LLVM IR generation of declaration"));
      Gen.$arrow().HandleTagDeclDefinition(D);
    } finally {
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::HandleTagDeclRequiredDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 195,
   FQN="clang::BackendConsumer::HandleTagDeclRequiredDefinition", NM="_ZN5clang15BackendConsumer31HandleTagDeclRequiredDefinitionEPKNS_7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer31HandleTagDeclRequiredDefinitionEPKNS_7TagDeclE")
  //</editor-fold>
  @Override public void HandleTagDeclRequiredDefinition(/*const*/ TagDecl /*P*/ D)/* override*/ {
    Gen.$arrow().HandleTagDeclRequiredDefinition(D);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::CompleteTentativeDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 199,
   FQN="clang::BackendConsumer::CompleteTentativeDefinition", NM="_ZN5clang15BackendConsumer27CompleteTentativeDefinitionEPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer27CompleteTentativeDefinitionEPNS_7VarDeclE")
  //</editor-fold>
  @Override public void CompleteTentativeDefinition(VarDecl /*P*/ D)/* override*/ {
    Gen.$arrow().CompleteTentativeDefinition(D);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::AssignInheritanceModel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 203,
   FQN="clang::BackendConsumer::AssignInheritanceModel", NM="_ZN5clang15BackendConsumer22AssignInheritanceModelEPNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer22AssignInheritanceModelEPNS_13CXXRecordDeclE")
  //</editor-fold>
  @Override public void AssignInheritanceModel(CXXRecordDecl /*P*/ RD)/* override*/ {
    Gen.$arrow().AssignInheritanceModel(RD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::HandleVTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 207,
   FQN="clang::BackendConsumer::HandleVTable", NM="_ZN5clang15BackendConsumer12HandleVTableEPNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer12HandleVTableEPNS_13CXXRecordDeclE")
  //</editor-fold>
  @Override public void HandleVTable(CXXRecordDecl /*P*/ RD)/* override*/ {
    Gen.$arrow().HandleVTable(RD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::InlineAsmDiagHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 211,
   FQN="clang::BackendConsumer::InlineAsmDiagHandler", NM="_ZN5clang15BackendConsumer20InlineAsmDiagHandlerERKN4llvm12SMDiagnosticEPvj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer20InlineAsmDiagHandlerERKN4llvm12SMDiagnosticEPvj")
  //</editor-fold>
  public static void InlineAsmDiagHandler(final /*const*/ SMDiagnostic /*&*/ SM, Object/*void P*/ Context, 
                      /*uint*/int LocCookie) {
    SourceLocation Loc = SourceLocation.getFromRawEncoding(LocCookie);
    ((BackendConsumer /*P*/ )Context).InlineAsmDiagHandler2(SM, new SourceLocation(Loc));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::DiagnosticHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 217,
   FQN="clang::BackendConsumer::DiagnosticHandler", NM="_ZN5clang15BackendConsumer17DiagnosticHandlerERKN4llvm14DiagnosticInfoEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer17DiagnosticHandlerERKN4llvm14DiagnosticInfoEPv")
  //</editor-fold>
  public static void DiagnosticHandler(final /*const*/ DiagnosticInfo /*&*/ DI, 
                   Object/*void P*/ Context) {
    ((BackendConsumer /*P*/ )Context).DiagnosticHandlerImpl(DI);
  }

  
  /// Get the best possible source location to represent a diagnostic that
  /// may have associated debug info.
  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::getBestLocationFromDebugLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 429,
   FQN="clang::BackendConsumer::getBestLocationFromDebugLoc", NM="_ZNK5clang15BackendConsumer27getBestLocationFromDebugLocERKN4llvm30DiagnosticInfoWithDebugLocBaseERbRNS1_9StringRefERjS8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZNK5clang15BackendConsumer27getBestLocationFromDebugLocERKN4llvm30DiagnosticInfoWithDebugLocBaseERbRNS1_9StringRefERjS8_")
  //</editor-fold>
  public /*const*/ FullSourceLoc getBestLocationFromDebugLoc(final /*const*/ DiagnosticInfoWithDebugLocBase /*&*/ D, final bool$ref/*bool &*/ BadDebugInfo, final StringRef /*&*/ Filename, 
                             final uint$ref/*uint &*/ Line, final uint$ref/*uint &*/ Column) /*const*/ {
    final SourceManager /*&*/ SourceMgr = Context.getSourceManager();
    final FileManager /*&*/ FileMgr = SourceMgr.getFileManager();
    SourceLocation DILoc/*J*/= new SourceLocation();
    if (D.isLocationAvailable()) {
      D.getLocation(/*AddrOf*/Filename, Line.deref$ptr(), Column.deref$ptr());
      /*const*/ FileEntry /*P*/ FE = FileMgr.getFile(/*NO_COPY*/Filename);
      if ((FE != null) && $greater_uint(Line.$deref(), 0)) {
        // If -gcolumn-info was not used, Column will be 0. This upsets the
        // source manager, so pass 1 if Column is not set.
        DILoc.$assignMove(SourceMgr.translateFileLineCol(FE, Line.$deref(), (Column.$deref() != 0) ? Column.$deref() : 1));
      }
      BadDebugInfo.$set(DILoc.isInvalid());
    }
    
    // If a location isn't available, try to approximate it using the associated
    // function definition. We use the definition's right brace to differentiate
    // from diagnostics that genuinely relate to the function itself.
    FullSourceLoc Loc/*J*/= new FullSourceLoc(/*NO_COPY*/DILoc, SourceMgr);
    if (Loc.isInvalid()) {
      {
        /*const*/ Decl /*P*/ FD = Gen.$arrow().GetDeclForMangledName(D.getFunction().getName());
        if ((FD != null)) {
          Loc.$assignMove(FD.getASTContext().getFullLoc(FD.getLocation()));
        }
      }
    }
    if (DILoc.isInvalid() && D.isLocationAvailable()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // If we were not able to translate the file:line:col information
        // back to a SourceLocation, at least emit a note stating that
        // we could not translate this location. This can happen in the
        // case of #line directives.
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/Loc, diag.note_fe_backend_invalid_loc)), 
                    /*NO_COPY*/Filename), Line.$deref()), Column.$deref()));
      } finally {
        $c$.$destroy();
      }
    }
    
    return Loc;
  }

  
  
  /// InlineAsmDiagHandler2 - This function is invoked when the backend hits an
  /// error parsing inline asm.  The SMDiagnostic indicates the error relative to
  /// the temporary memory buffer that the inline asm parser has set up.
  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::InlineAsmDiagHandler2">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 298,
   FQN="clang::BackendConsumer::InlineAsmDiagHandler2", NM="_ZN5clang15BackendConsumer21InlineAsmDiagHandler2ERKN4llvm12SMDiagnosticENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer21InlineAsmDiagHandler2ERKN4llvm12SMDiagnosticENS_14SourceLocationE")
  //</editor-fold>
  public void InlineAsmDiagHandler2(final /*const*/ SMDiagnostic /*&*/ D, 
                       SourceLocation LocCookie) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // There are a couple of different kinds of errors we could get here.  First,
      // we re-format the SMDiagnostic in terms of a clang diagnostic.
      
      // Strip "error: " off the start of the message string.
      StringRef Message = D.getMessage();
      if (Message.startswith(/*STRINGREF_STR*/"error: ")) {
        Message.$assignMove(Message.substr(7));
      }
      
      // If the SMDiagnostic has an inline asm source location, translate it.
      FullSourceLoc Loc/*J*/= new FullSourceLoc();
      if (D.getLoc().$noteq(new SMLoc())) {
        Loc.$assignMove(ConvertBackendLocation(D, Context.getSourceManager()));
      }
      
      /*uint*/int DiagID;
      switch (D.getKind()) {
       case DK_Error:
        DiagID = diag.err_fe_inline_asm;
        break;
       case DK_Warning:
        DiagID = diag.warn_fe_inline_asm;
        break;
       case DK_Note:
        DiagID = diag.note_fe_inline_asm;
        break;
       default:
        // JAVA
        assert false : "unexpected " + D.getKind();
        DiagID = -1;
        break;        
      }
      // If this problem has clang-level source location information, report the
      // issue in the source with a note showing the instantiated
      // code.
      if (LocCookie.isValid()) {
        $c$.track(Diags.Report(/*NO_COPY*/LocCookie, DiagID)).AddString(/*NO_COPY*/Message); $c$.clean();
        if (D.getLoc().isValid()) {
          DiagnosticBuilder B = null;
          try {
            B = Diags.Report(/*NO_COPY*/Loc, diag.note_fe_inline_asm_here);
            // Convert the SMDiagnostic ranges into SourceRange and attach them
            // to the diagnostic.
            for (final /*const*/std.pairUIntUInt/*&*/ Range : D.getRanges()) {
              /*uint*/int Column = D.getColumnNo();
              $out_DiagnosticBuilder$C_SourceRange(B, new SourceRange(Loc.getLocWithOffset(Range.first - Column), 
                      Loc.getLocWithOffset(Range.second - Column)));
            }
          } finally {
            if (B != null) { B.$destroy(); }
          }
        }
        return;
      }
      
      // Otherwise, report the backend issue as occurring in the generated .s file.
      // If Loc is invalid, we still need to report the issue, it just gets no
      // location info.
      $c$.track(Diags.Report(/*NO_COPY*/Loc, DiagID)).AddString(/*NO_COPY*/Message); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  
  /// \brief This function is invoked when the backend needs
  /// to report something to the user.
  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::DiagnosticHandlerImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 579,
   FQN="clang::BackendConsumer::DiagnosticHandlerImpl", NM="_ZN5clang15BackendConsumer21DiagnosticHandlerImplERKN4llvm14DiagnosticInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer21DiagnosticHandlerImplERKN4llvm14DiagnosticInfoE")
  //</editor-fold>
  public void DiagnosticHandlerImpl(final /*const*/ DiagnosticInfo /*&*/ DI) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*uint*/int DiagID = diag.err_fe_inline_asm;
      DiagnosticSeverity Severity = DI.getSeverity();
      // Get the diagnostic ID based.
      switch (DiagnosticKind.valueOf(DI.getKind())) {
       case DK_InlineAsm:
        if (InlineAsmDiagHandler(cast_DiagnosticInfoInlineAsm(DI))) {
          return;
        }
        do {
          switch (Severity) {
           case DS_Error:
            DiagID = diag.err_fe_inline_asm;
            break;
           case DS_Warning:
            DiagID = diag.warn_fe_inline_asm;
            break;
           case DS_Remark:
            throw new llvm_unreachable("'remark' severity not expected");
//            break;
           case DS_Note:
            DiagID = diag.note_fe_inline_asm;
            break;
          }
        } while (false);
        break;
       case DK_StackSize:
        if (StackSizeDiagHandler(cast_DiagnosticInfoStackSize(DI))) {
          return;
        }
        do {
          switch (Severity) {
           case DS_Error:
            DiagID = diag.err_fe_backend_frame_larger_than;
            break;
           case DS_Warning:
            DiagID = diag.warn_fe_backend_frame_larger_than;
            break;
           case DS_Remark:
            throw new llvm_unreachable("'remark' severity not expected");
//            break;
           case DS_Note:
            DiagID = diag.note_fe_backend_frame_larger_than;
            break;
          }
        } while (false);
        break;
       case DK_Linker:
        assert Native.$bool(CurLinkModule);
        // FIXME: stop eating the warnings and notes.
        if (Severity != DiagnosticSeverity.DS_Error) {
          return;
        }
        DiagID = diag.err_fe_cannot_link_module;
        break;
       case DK_OptimizationRemark:
        // Optimization remarks are always handled completely by this
        // handler. There is no generic way of emitting them.
        OptimizationRemarkHandler(cast_DiagnosticInfoOptimizationRemark(DI));
        return;
       case DK_OptimizationRemarkMissed:
        // Optimization remarks are always handled completely by this
        // handler. There is no generic way of emitting them.
        OptimizationRemarkHandler(cast_DiagnosticInfoOptimizationRemarkMissed(DI));
        return;
       case DK_OptimizationRemarkAnalysis:
        // Optimization remarks are always handled completely by this
        // handler. There is no generic way of emitting them.
        OptimizationRemarkHandler(cast_DiagnosticInfoOptimizationRemarkAnalysis(DI));
        return;
       case DK_OptimizationRemarkAnalysisFPCommute:
        // Optimization remarks are always handled completely by this
        // handler. There is no generic way of emitting them.
        OptimizationRemarkHandler(cast_DiagnosticInfoOptimizationRemarkAnalysisFPCommute(DI));
        return;
       case DK_OptimizationRemarkAnalysisAliasing:
        // Optimization remarks are always handled completely by this
        // handler. There is no generic way of emitting them.
        OptimizationRemarkHandler(cast_DiagnosticInfoOptimizationRemarkAnalysisAliasing(DI));
        return;
       case DK_OptimizationFailure:
        // Optimization failures are always handled completely by this
        // handler.
        OptimizationFailureHandler(cast_DiagnosticInfoOptimizationFailure(DI));
        return;
       case DK_Unsupported:
        UnsupportedDiagHandler(cast_DiagnosticInfoUnsupported(DI));
        return;
       default:
        // Plugin IDs are not bound to any value as they are set dynamically.
        do {
          switch (Severity) {
           case DS_Error:
            DiagID = diag.err_fe_backend_plugin;
            break;
           case DS_Warning:
            DiagID = diag.warn_fe_backend_plugin;
            break;
           case DS_Remark:
            DiagID = diag.remark_fe_backend_plugin;
            break;
           case DS_Note:
            DiagID = diag.note_fe_backend_plugin;
            break;
          }
        } while (false);
        break;
      }
      std.string MsgStorage/*J*/= new std.string();
      {
        raw_string_ostream Stream = null;
        DiagnosticPrinterRawOStream DP = null;
        try {
          Stream/*J*/= new raw_string_ostream(MsgStorage);
          DP/*J*/= new DiagnosticPrinterRawOStream(Stream);
          DI.print(DP);
        } finally {
          if (DP != null) { DP.$destroy(); }
          if (Stream != null) { Stream.$destroy(); }
        }
      }
      if (DiagID == diag.err_fe_cannot_link_module) {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_fe_cannot_link_module)), 
                new StringRef(CurLinkModule.getModuleIdentifier())), new StringRef(MsgStorage)));
        return;
      }
      
      // Report the backend message using the usual diagnostic mechanism.
      FullSourceLoc Loc/*J*/= new FullSourceLoc();
      $c$.track(Diags.Report(/*NO_COPY*/Loc, DiagID)).AddString(new StringRef(MsgStorage)); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  /// \brief Specialized handler for InlineAsm diagnostic.
  /// \return True if the diagnostic has been successfully reported, false
  /// otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::InlineAsmDiagHandler">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 386,
   FQN="clang::BackendConsumer::InlineAsmDiagHandler", NM="_ZN5clang15BackendConsumer20InlineAsmDiagHandlerERKN4llvm23DiagnosticInfoInlineAsmE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer20InlineAsmDiagHandlerERKN4llvm23DiagnosticInfoInlineAsmE")
  //</editor-fold>
  public boolean InlineAsmDiagHandler(final /*const*/ DiagnosticInfoInlineAsm /*&*/ D) {
    /*uint*/int DiagID;
    do {
      switch (D.getSeverity()) {
       case DS_Error:
        DiagID = diag.err_fe_inline_asm;
        break;
       case DS_Warning:
        DiagID = diag.warn_fe_inline_asm;
        break;
       case DS_Remark:
        throw new llvm_unreachable("'remark' severity not expected");
//        break;
       case DS_Note:
        DiagID = diag.note_fe_inline_asm;
        break;
       default:
        // JAVA
        assert false : "unexpected " + D.getKind();
        DiagID = -1;
        break;          
      }
    } while (false);
    std.string Message = D.getMsgStr().str();
    
    // If this problem has clang-level source location information, report the
    // issue as being a problem in the source with a note showing the instantiated
    // code.
    SourceLocation LocCookie = SourceLocation.getFromRawEncoding(D.getLocCookie());
    if (LocCookie.isValid()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.track(Diags.Report(/*NO_COPY*/LocCookie, DiagID)).AddString(new StringRef(Message)); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Otherwise, report the backend diagnostic as occurring in the generated
        // .s file.
        // If Loc is invalid, we still need to report the diagnostic, it just gets
        // no location info.
        FullSourceLoc Loc/*J*/= new FullSourceLoc();
        $c$.track(Diags.Report(/*NO_COPY*/Loc, DiagID)).AddString(new StringRef(Message)); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
    // We handled all the possible severities.
    return true;
  }

  /// \brief Specialized handler for StackSize diagnostic.
  /// \return True if the diagnostic has been successfully reported, false
  /// otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::StackSizeDiagHandler">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 411,
   FQN="clang::BackendConsumer::StackSizeDiagHandler", NM="_ZN5clang15BackendConsumer20StackSizeDiagHandlerERKN4llvm23DiagnosticInfoStackSizeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer20StackSizeDiagHandlerERKN4llvm23DiagnosticInfoStackSizeE")
  //</editor-fold>
  public boolean StackSizeDiagHandler(final /*const*/ DiagnosticInfoStackSize /*&*/ D) {
    if (D.getSeverity() != DiagnosticSeverity.DS_Warning) {
      // For now, the only support we have for StackSize diagnostic is warning.
      // We do not know how to format other severities.
      return false;
    }
    {
      
      /*const*/ Decl /*P*/ ND = Gen.$arrow().GetDeclForMangledName(D.getFunction().getName());
      if ((ND != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // FIXME: Shouldn't need to truncate to uint32_t
          $c$.clean($out$Same2DeclContext($out_DiagnosticBuilder$C_uint($c$.track(Diags.Report(/*NO_COPY*/ND.getASTContext().getFullLoc(ND.getLocation()), 
                      diag.warn_fe_frame_larger_than)), 
                  ((/*static_cast*//*uint32_t*/int)($ulong2uint(D.getStackSize())))), Decl.castToDeclContext(ND)));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    return false;
  }

  /// \brief Specialized handler for unsupported backend feature diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::UnsupportedDiagHandler">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 466,
   FQN="clang::BackendConsumer::UnsupportedDiagHandler", NM="_ZN5clang15BackendConsumer22UnsupportedDiagHandlerERKN4llvm25DiagnosticInfoUnsupportedE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer22UnsupportedDiagHandlerERKN4llvm25DiagnosticInfoUnsupportedE")
  //</editor-fold>
  public void UnsupportedDiagHandler(final /*const*/ DiagnosticInfoUnsupported /*&*/ D) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // We only support errors.
      assert (D.getSeverity() == DiagnosticSeverity.DS_Error);
      
      StringRef Filename/*J*/= new StringRef();
      uint$ref Line = create_uint$ref();
      uint$ref Column = create_uint$ref();
      bool$ref BadDebugInfo = create_bool$ref();
      FullSourceLoc Loc = getBestLocationFromDebugLoc(D, BadDebugInfo, Filename, 
          Line, Column);
      
      $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/Loc, diag.err_fe_backend_unsupported)), new StringRef(D.getMessage().str())));
      if (BadDebugInfo.$deref()) {
        // If we were not able to translate the file:line:col information
        // back to a SourceLocation, at least emit a note stating that
        // we could not translate this location. This can happen in the
        // case of #line directives.
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/Loc, diag.note_fe_backend_invalid_loc)), 
                    /*NO_COPY*/Filename), Line.$deref()), Column.$deref()));
      }
    } finally {
      $c$.$destroy();
    }
  }

  /// \brief Specialized handlers for optimization remarks.
  /// Note that these handlers only accept remarks and they always handle
  /// them.
  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::EmitOptimizationMessage">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 488,
   FQN="clang::BackendConsumer::EmitOptimizationMessage", NM="_ZN5clang15BackendConsumer23EmitOptimizationMessageERKN4llvm30DiagnosticInfoOptimizationBaseEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer23EmitOptimizationMessageERKN4llvm30DiagnosticInfoOptimizationBaseEj")
  //</editor-fold>
  public void EmitOptimizationMessage(final /*const*/ DiagnosticInfoOptimizationBase /*&*/ D, /*uint*/int DiagID) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // We only support warnings and remarks.
      assert (D.getSeverity() == DiagnosticSeverity.DS_Remark || D.getSeverity() == DiagnosticSeverity.DS_Warning);
      
      StringRef Filename/*J*/= new StringRef();
      uint$ref Line = create_uint$ref();
      uint$ref Column = create_uint$ref();
      bool$ref BadDebugInfo = create_bool$ref(false);
      FullSourceLoc Loc = getBestLocationFromDebugLoc(D, BadDebugInfo, Filename, 
          Line, Column);
      
      $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_AddFlagValue$C($c$.track(Diags.Report(/*NO_COPY*/Loc, DiagID)), 
              new AddFlagValue(new StringRef(Native.$bool(D.getPassName()) ? D.getPassName() : $EMPTY))), 
          new StringRef(D.getMsg().str())));
      if (BadDebugInfo.$deref()) {
        // If we were not able to translate the file:line:col information
        // back to a SourceLocation, at least emit a note stating that
        // we could not translate this location. This can happen in the
        // case of #line directives.
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/Loc, diag.note_fe_backend_invalid_loc)), 
                    /*NO_COPY*/Filename), Line.$deref()), Column.$deref()));
      }
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::OptimizationRemarkHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 513,
   FQN="clang::BackendConsumer::OptimizationRemarkHandler", NM="_ZN5clang15BackendConsumer25OptimizationRemarkHandlerERKN4llvm32DiagnosticInfoOptimizationRemarkE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer25OptimizationRemarkHandlerERKN4llvm32DiagnosticInfoOptimizationRemarkE")
  //</editor-fold>
  public void OptimizationRemarkHandler(final /*const*/ DiagnosticInfoOptimizationRemark /*&*/ D) {
    // Optimization remarks are active only if the -Rpass flag has a regular
    // expression that matches the name of the pass name in \p D.
    if (CodeGenOpts.OptimizationRemarkPattern.$bool()
       && CodeGenOpts.OptimizationRemarkPattern.$arrow().match(/*STRINGREF_STR*/D.getPassName())) {
      EmitOptimizationMessage(D, diag.remark_fe_backend_optimization_remark);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::OptimizationRemarkHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 522,
   FQN="clang::BackendConsumer::OptimizationRemarkHandler", NM="_ZN5clang15BackendConsumer25OptimizationRemarkHandlerERKN4llvm38DiagnosticInfoOptimizationRemarkMissedE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer25OptimizationRemarkHandlerERKN4llvm38DiagnosticInfoOptimizationRemarkMissedE")
  //</editor-fold>
  public void OptimizationRemarkHandler(final /*const*/ DiagnosticInfoOptimizationRemarkMissed /*&*/ D) {
    // Missed optimization remarks are active only if the -Rpass-missed
    // flag has a regular expression that matches the name of the pass
    // name in \p D.
    if (CodeGenOpts.OptimizationRemarkMissedPattern.$bool()
       && CodeGenOpts.OptimizationRemarkMissedPattern.$arrow().match(/*STRINGREF_STR*/D.getPassName())) {
      EmitOptimizationMessage(D, 
          diag.remark_fe_backend_optimization_remark_missed);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::OptimizationRemarkHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 533,
   FQN="clang::BackendConsumer::OptimizationRemarkHandler", NM="_ZN5clang15BackendConsumer25OptimizationRemarkHandlerERKN4llvm40DiagnosticInfoOptimizationRemarkAnalysisE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer25OptimizationRemarkHandlerERKN4llvm40DiagnosticInfoOptimizationRemarkAnalysisE")
  //</editor-fold>
  public void OptimizationRemarkHandler(final /*const*/ DiagnosticInfoOptimizationRemarkAnalysis /*&*/ D) {
    // Optimization analysis remarks are active if the pass name is set to
    // llvm::DiagnosticInfo::AlwasyPrint or if the -Rpass-analysis flag has a
    // regular expression that matches the name of the pass name in \p D.
    if (D.shouldAlwaysPrint()
       || (CodeGenOpts.OptimizationRemarkAnalysisPattern.$bool()
       && CodeGenOpts.OptimizationRemarkAnalysisPattern.$arrow().match(/*STRINGREF_STR*/D.getPassName()))) {
      EmitOptimizationMessage(D, diag.remark_fe_backend_optimization_remark_analysis);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::OptimizationRemarkHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 546,
   FQN="clang::BackendConsumer::OptimizationRemarkHandler", NM="_ZN5clang15BackendConsumer25OptimizationRemarkHandlerERKN4llvm49DiagnosticInfoOptimizationRemarkAnalysisFPCommuteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer25OptimizationRemarkHandlerERKN4llvm49DiagnosticInfoOptimizationRemarkAnalysisFPCommuteE")
  //</editor-fold>
  public void OptimizationRemarkHandler(final /*const*/ DiagnosticInfoOptimizationRemarkAnalysisFPCommute /*&*/ D) {
    // Optimization analysis remarks are active if the pass name is set to
    // llvm::DiagnosticInfo::AlwasyPrint or if the -Rpass-analysis flag has a
    // regular expression that matches the name of the pass name in \p D.
    if (D.shouldAlwaysPrint()
       || (CodeGenOpts.OptimizationRemarkAnalysisPattern.$bool()
       && CodeGenOpts.OptimizationRemarkAnalysisPattern.$arrow().match(/*STRINGREF_STR*/D.getPassName()))) {
      EmitOptimizationMessage(D, diag.remark_fe_backend_optimization_remark_analysis_fpcommute);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::OptimizationRemarkHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 559,
   FQN="clang::BackendConsumer::OptimizationRemarkHandler", NM="_ZN5clang15BackendConsumer25OptimizationRemarkHandlerERKN4llvm48DiagnosticInfoOptimizationRemarkAnalysisAliasingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer25OptimizationRemarkHandlerERKN4llvm48DiagnosticInfoOptimizationRemarkAnalysisAliasingE")
  //</editor-fold>
  public void OptimizationRemarkHandler(final /*const*/ DiagnosticInfoOptimizationRemarkAnalysisAliasing /*&*/ D) {
    // Optimization analysis remarks are active if the pass name is set to
    // llvm::DiagnosticInfo::AlwasyPrint or if the -Rpass-analysis flag has a
    // regular expression that matches the name of the pass name in \p D.
    if (D.shouldAlwaysPrint()
       || (CodeGenOpts.OptimizationRemarkAnalysisPattern.$bool()
       && CodeGenOpts.OptimizationRemarkAnalysisPattern.$arrow().match(/*STRINGREF_STR*/D.getPassName()))) {
      EmitOptimizationMessage(D, diag.remark_fe_backend_optimization_remark_analysis_aliasing);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::OptimizationFailureHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 572,
   FQN="clang::BackendConsumer::OptimizationFailureHandler", NM="_ZN5clang15BackendConsumer26OptimizationFailureHandlerERKN4llvm33DiagnosticInfoOptimizationFailureE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumer26OptimizationFailureHandlerERKN4llvm33DiagnosticInfoOptimizationFailureE")
  //</editor-fold>
  public void OptimizationFailureHandler(final /*const*/ DiagnosticInfoOptimizationFailure /*&*/ D) {
    EmitOptimizationMessage(D, diag.warn_fe_backend_optimization_failure);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BackendConsumer::~BackendConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp", line = 42,
   FQN="clang::BackendConsumer::~BackendConsumer", NM="_ZN5clang15BackendConsumerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15BackendConsumerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    LinkModules.$destroy();
    Gen.$destroy();
    LLVMIRGeneration.$destroy();
    AsmOutStream.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Diags=" + "[DiagnosticsEngine]" // NOI18N
              + ", Action=" + Action // NOI18N
              + ", CodeGenOpts=" + CodeGenOpts // NOI18N
              + ", TargetOpts=" + TargetOpts // NOI18N
              + ", LangOpts=" + LangOpts // NOI18N
              + ", AsmOutStream=" + AsmOutStream // NOI18N
              + ", Context=" + "[ASTContext]" // NOI18N
              + ", LLVMIRGeneration=" + LLVMIRGeneration // NOI18N
              + ", Gen=" + Gen // NOI18N
              + ", LinkModules=" + LinkModules // NOI18N
              + ", CurLinkModule=" + CurLinkModule // NOI18N
              + super.toString(); // NOI18N
  }
}
