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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.llvm.ir.*;
import org.clang.codegen.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.driver.frontend.CodeGenOptions;
import static org.clang.ast.java.AstDeclarationsRTTI.dyn_cast_FunctionDecl;
import static org.clang.ast.java.AstDeclarationsRTTI.dyn_cast_TagDecl;
import static org.clang.ast.java.AstDeclarationsRTTI.dyn_cast_RecordDecl;
import static org.clang.ast.java.AstDeclarationsRTTI.dyn_cast_OMPDeclareReductionDecl;
import static org.clang.ast.java.AstDeclarationsRTTI.dyn_cast_VarDecl;
import static org.clang.ast.java.AstDeclarationsRTTI.cast_CXXMethodDecl;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CodeGeneratorImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 33,
 FQN="(anonymous namespace)::CodeGeneratorImpl", NM="_ZN12_GLOBAL__N_117CodeGeneratorImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN12_GLOBAL__N_117CodeGeneratorImplE")
//</editor-fold>
public class CodeGeneratorImpl extends /*public*/ CodeGenerator implements Destructors.ClassWithDestructor {
  private final DiagnosticsEngine /*&*/ Diags;
  private ASTContext /*P*/ Ctx;
  private final /*const*/ HeaderSearchOptions /*&*/ HeaderSearchOpts; // Only used for debug info.
  private final /*const*/ PreprocessorOptions /*&*/ PreprocessorOpts; // Only used for debug info.
  private /*const*/ CodeGenOptions CodeGenOpts; // Intentionally copied in.
  
  private /*uint*/int HandlingTopLevelDecls;
  
  /// Use this when emitting decls to block re-entrant decl emission. It will
  /// emit all deferred decls on scope exit. Set EmitDeferred to false if decl
  /// emission must be deferred longer, like at the end of a tag definition.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CodeGeneratorImpl::HandlingTopLevelDeclRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 45,
   FQN="(anonymous namespace)::CodeGeneratorImpl::HandlingTopLevelDeclRAII", NM="_ZN12_GLOBAL__N_117CodeGeneratorImpl24HandlingTopLevelDeclRAIIE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN12_GLOBAL__N_117CodeGeneratorImpl24HandlingTopLevelDeclRAIIE")
  //</editor-fold>
  private static class/*struct*/ HandlingTopLevelDeclRAII implements Destructors.ClassWithDestructor {
    public final CodeGeneratorImpl /*&*/ Self;
    public boolean EmitDeferred;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CodeGeneratorImpl::HandlingTopLevelDeclRAII::HandlingTopLevelDeclRAII">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 48,
     FQN="(anonymous namespace)::CodeGeneratorImpl::HandlingTopLevelDeclRAII::HandlingTopLevelDeclRAII", NM="_ZN12_GLOBAL__N_117CodeGeneratorImpl24HandlingTopLevelDeclRAIIC1ERS0_b",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN12_GLOBAL__N_117CodeGeneratorImpl24HandlingTopLevelDeclRAIIC1ERS0_b")
    //</editor-fold>
    public HandlingTopLevelDeclRAII(final CodeGeneratorImpl /*&*/ Self) {
      this(Self, 
        true);
    }
    public HandlingTopLevelDeclRAII(final CodeGeneratorImpl /*&*/ Self, 
        boolean EmitDeferred/*= true*/) {
      // : Self(Self), EmitDeferred(EmitDeferred) 
      //START JInit
      this./*&*/Self=/*&*/Self;
      this.EmitDeferred = EmitDeferred;
      //END JInit
      ++Self.HandlingTopLevelDecls;
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CodeGeneratorImpl::HandlingTopLevelDeclRAII::~HandlingTopLevelDeclRAII">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 53,
     FQN="(anonymous namespace)::CodeGeneratorImpl::HandlingTopLevelDeclRAII::~HandlingTopLevelDeclRAII", NM="_ZN12_GLOBAL__N_117CodeGeneratorImpl24HandlingTopLevelDeclRAIID0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN12_GLOBAL__N_117CodeGeneratorImpl24HandlingTopLevelDeclRAIID0Ev")
    //</editor-fold>
    public void $destroy() {
      /*uint*/int Level = --Self.HandlingTopLevelDecls;
      if (Level == 0 && EmitDeferred) {
        Self.EmitDeferredDecls();
      }
    }

    
    @Override public String toString() {
      return "" + "Self=" + Self // NOI18N
                + ", EmitDeferred=" + EmitDeferred; // NOI18N
    }
  };
  
  private CoverageSourceInfo /*P*/ CoverageInfo;
/*protected:*/
  protected std.unique_ptr<org.llvm.ir.Module> M;
  protected std.unique_ptr<CodeGenModule> Builder;
/*private:*/
  private SmallVector<CXXMethodDecl /*P*/ > DeferredInlineMethodDefinitions;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CodeGeneratorImpl::CodeGeneratorImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 70,
   FQN="(anonymous namespace)::CodeGeneratorImpl::CodeGeneratorImpl", NM="_ZN12_GLOBAL__N_117CodeGeneratorImplC1ERN5clang17DiagnosticsEngineEN4llvm9StringRefERKNS1_19HeaderSearchOptionsERKNS1_19PreprocessorOptionsERKNS1_14CodeGenOptionsERNS4_11LLVMContextEPNS1_18CoverageSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN12_GLOBAL__N_117CodeGeneratorImplC1ERN5clang17DiagnosticsEngineEN4llvm9StringRefERKNS1_19HeaderSearchOptionsERKNS1_19PreprocessorOptionsERKNS1_14CodeGenOptionsERNS4_11LLVMContextEPNS1_18CoverageSourceInfoE")
  //</editor-fold>
  public CodeGeneratorImpl(final DiagnosticsEngine /*&*/ diags, StringRef ModuleName, 
      final /*const*/ HeaderSearchOptions /*&*/ HSO, 
      final /*const*/ PreprocessorOptions /*&*/ PPO, final /*const*/ CodeGenOptions /*&*/ CGO, 
      final LLVMContext /*&*/ C) {
    this(diags, ModuleName, 
      HSO, 
      PPO, CGO, 
      C, 
      (CoverageSourceInfo /*P*/ )null);
  }
  public CodeGeneratorImpl(final DiagnosticsEngine /*&*/ diags, StringRef ModuleName, 
      final /*const*/ HeaderSearchOptions /*&*/ HSO, 
      final /*const*/ PreprocessorOptions /*&*/ PPO, final /*const*/ CodeGenOptions /*&*/ CGO, 
      final LLVMContext /*&*/ C, 
      CoverageSourceInfo /*P*/ CoverageInfo/*= null*/) {
    // : CodeGenerator(), Diags(diags), Ctx(null), HeaderSearchOpts(HSO), PreprocessorOpts(PPO), CodeGenOpts(CGO), HandlingTopLevelDecls(0), CoverageInfo(CoverageInfo), M(new Module(ModuleName, C)), Builder(), DeferredInlineMethodDefinitions() 
    //START JInit
    super();
    this./*&*/Diags=/*&*/diags;
    this.Ctx = null;
    this./*&*/HeaderSearchOpts=/*&*/HSO;
    this./*&*/PreprocessorOpts=/*&*/PPO;
    this.CodeGenOpts = new CodeGenOptions(CGO);
    this.HandlingTopLevelDecls = 0;
    this.CoverageInfo = CoverageInfo;
    this.M = new std.unique_ptr<org.llvm.ir.Module>(new org.llvm.ir.Module(new StringRef(ModuleName), C));
    this.Builder = new std.unique_ptr<CodeGenModule>();
    this.DeferredInlineMethodDefinitions = new SmallVector<CXXMethodDecl /*P*/ >(8, (CXXMethodDecl /*P*/ )null);
    //END JInit
    C.setDiscardValueNames(CGO.DiscardValueNames);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CodeGeneratorImpl::~CodeGeneratorImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 81,
   FQN="(anonymous namespace)::CodeGeneratorImpl::~CodeGeneratorImpl", NM="_ZN12_GLOBAL__N_117CodeGeneratorImplD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN12_GLOBAL__N_117CodeGeneratorImplD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    // There should normally not be any leftover inline method definitions.
    assert (DeferredInlineMethodDefinitions.empty() || Diags.hasErrorOccurred());
    //START JDestroy
    DeferredInlineMethodDefinitions.$destroy();
    Builder.$destroy();
    M.$destroy();
    CodeGenOpts.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CodeGeneratorImpl::CGM">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 87,
   FQN="(anonymous namespace)::CodeGeneratorImpl::CGM", NM="_ZN12_GLOBAL__N_117CodeGeneratorImpl3CGMEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN12_GLOBAL__N_117CodeGeneratorImpl3CGMEv")
  //</editor-fold>
  public CodeGenModule /*&*/ CGM() {
    return Builder.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CodeGeneratorImpl::GetModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 91,
   FQN="(anonymous namespace)::CodeGeneratorImpl::GetModule", NM="_ZN12_GLOBAL__N_117CodeGeneratorImpl9GetModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN12_GLOBAL__N_117CodeGeneratorImpl9GetModuleEv")
  //</editor-fold>
  public org.llvm.ir.Module /*P*/ GetModule() {
    return M.get();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CodeGeneratorImpl::ReleaseModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 95,
   FQN="(anonymous namespace)::CodeGeneratorImpl::ReleaseModule", NM="_ZN12_GLOBAL__N_117CodeGeneratorImpl13ReleaseModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN12_GLOBAL__N_117CodeGeneratorImpl13ReleaseModuleEv")
  //</editor-fold>
  public org.llvm.ir.Module /*P*/ ReleaseModule() {
    return M.release();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CodeGeneratorImpl::GetDeclForMangledName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 99,
   FQN="(anonymous namespace)::CodeGeneratorImpl::GetDeclForMangledName", NM="_ZN12_GLOBAL__N_117CodeGeneratorImpl21GetDeclForMangledNameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN12_GLOBAL__N_117CodeGeneratorImpl21GetDeclForMangledNameEN4llvm9StringRefE")
  //</editor-fold>
  public /*const*/ Decl /*P*/ GetDeclForMangledName(StringRef MangledName) {
    GlobalDecl Result/*J*/= new GlobalDecl();
    if (!Builder.$arrow().lookupRepresentativeDecl(new StringRef(MangledName), Result)) {
      return null;
    }
    /*const*/ Decl /*P*/ D = Result.getCanonicalDecl().getDecl();
    {
      type$ref</*const*/ FunctionDecl /*P*/ > FD = create_type$ref(dyn_cast_FunctionDecl(D));
      if ((FD.$deref() != null)) {
        if (FD.$deref().hasBody(FD)) {
          return FD.$deref();
        }
      } else {
        /*const*/ TagDecl /*P*/ TD = dyn_cast_TagDecl(D);
        if ((TD != null)) {
          {
            TagDecl /*P*/ Def = TD.getDefinition();
            if ((Def != null)) {
              return Def;
            }
          }
        }
      }
    }
    return D;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CodeGeneratorImpl::GetAddrOfGlobal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 114,
   FQN="(anonymous namespace)::CodeGeneratorImpl::GetAddrOfGlobal", NM="_ZN12_GLOBAL__N_117CodeGeneratorImpl15GetAddrOfGlobalEN5clang10GlobalDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN12_GLOBAL__N_117CodeGeneratorImpl15GetAddrOfGlobalEN5clang10GlobalDeclEb")
  //</editor-fold>
  public Constant /*P*/ GetAddrOfGlobal(GlobalDecl global, boolean isForDefinition) {
    return Builder.$arrow().GetAddrOfGlobal(new GlobalDecl(global), isForDefinition);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CodeGeneratorImpl::Initialize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 118,
   FQN="(anonymous namespace)::CodeGeneratorImpl::Initialize", NM="_ZN12_GLOBAL__N_117CodeGeneratorImpl10InitializeERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN12_GLOBAL__N_117CodeGeneratorImpl10InitializeERN5clang10ASTContextE")
  //</editor-fold>
  @Override public void Initialize(final ASTContext /*&*/ Context)/* override*/ {
    Ctx = $AddrOf(Context);
    
    M.$arrow().setTargetTriple(new StringRef(Ctx.getTargetInfo().getTriple().getTriple()));
    M.$arrow().setDataLayout(Ctx.getTargetInfo().getDataLayout());
    Builder.reset(new CodeGenModule(Context, HeaderSearchOpts, 
            PreprocessorOpts, CodeGenOpts, 
            M.$star(), Diags, CoverageInfo));
    
    for (final /*const*/std.string/*&*/ /*&*/ Lib : CodeGenOpts.DependentLibraries)  {
      Builder.$arrow().AddDependentLib(new StringRef(Lib));
    }
    for (final /*const*/std.string/*&*/ /*&*/ Opt : CodeGenOpts.LinkerOptions)  {
      Builder.$arrow().AppendLinkerOptions(new StringRef(Opt));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CodeGeneratorImpl::HandleCXXStaticMemberVarInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 133,
   FQN="(anonymous namespace)::CodeGeneratorImpl::HandleCXXStaticMemberVarInstantiation", NM="_ZN12_GLOBAL__N_117CodeGeneratorImpl37HandleCXXStaticMemberVarInstantiationEPN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN12_GLOBAL__N_117CodeGeneratorImpl37HandleCXXStaticMemberVarInstantiationEPN5clang7VarDeclE")
  //</editor-fold>
  @Override public void HandleCXXStaticMemberVarInstantiation(VarDecl /*P*/ VD)/* override*/ {
    if (Diags.hasErrorOccurred()) {
      return;
    }
    
    Builder.$arrow().HandleCXXStaticMemberVarInstantiation(VD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CodeGeneratorImpl::HandleTopLevelDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 140,
   FQN="(anonymous namespace)::CodeGeneratorImpl::HandleTopLevelDecl", NM="_ZN12_GLOBAL__N_117CodeGeneratorImpl18HandleTopLevelDeclEN5clang12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN12_GLOBAL__N_117CodeGeneratorImpl18HandleTopLevelDeclEN5clang12DeclGroupRefE")
  //</editor-fold>
  @Override public boolean HandleTopLevelDecl(DeclGroupRef DG)/* override*/ {
    HandlingTopLevelDeclRAII HandlingDecl = null;
    try {
      if (Diags.hasErrorOccurred()) {
        return true;
      }
      
      HandlingDecl/*J*/= new HandlingTopLevelDeclRAII(/*Deref*/this);
      
      // Make sure to emit all elements of a Decl.
      for (type$ptr<Decl/*P*/>/*iterator*/ I = $tryClone(DG.begin()), /*P*/ /*P*/ E = $tryClone(DG.end()); $noteq_ptr(I, E); I.$preInc())  {
        Builder.$arrow().EmitTopLevelDecl(I.$star());
      }
      
      return true;
    } finally {
      if (HandlingDecl != null) { HandlingDecl.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CodeGeneratorImpl::EmitDeferredDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 153,
   FQN="(anonymous namespace)::CodeGeneratorImpl::EmitDeferredDecls", NM="_ZN12_GLOBAL__N_117CodeGeneratorImpl17EmitDeferredDeclsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN12_GLOBAL__N_117CodeGeneratorImpl17EmitDeferredDeclsEv")
  //</editor-fold>
  public void EmitDeferredDecls() {
    HandlingTopLevelDeclRAII HandlingDecl = null;
    try {
      if (DeferredInlineMethodDefinitions.empty()) {
        return;
      }
      
      // Emit any deferred inline method definitions. Note that more deferred
      // methods may be added during this loop, since ASTConsumer callbacks
      // can be invoked if AST inspection results in declarations being added.
      HandlingDecl/*J*/= new HandlingTopLevelDeclRAII(/*Deref*/this);
      for (/*uint*/int I = 0; I != DeferredInlineMethodDefinitions.size(); ++I)  {
        Builder.$arrow().EmitTopLevelDecl(DeferredInlineMethodDefinitions.$at(I));
      }
      DeferredInlineMethodDefinitions.clear();
    } finally {
      if (HandlingDecl != null) { HandlingDecl.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CodeGeneratorImpl::HandleInlineFunctionDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 166,
   FQN="(anonymous namespace)::CodeGeneratorImpl::HandleInlineFunctionDefinition", NM="_ZN12_GLOBAL__N_117CodeGeneratorImpl30HandleInlineFunctionDefinitionEPN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN12_GLOBAL__N_117CodeGeneratorImpl30HandleInlineFunctionDefinitionEPN5clang12FunctionDeclE")
  //</editor-fold>
  @Override public void HandleInlineFunctionDefinition(FunctionDecl /*P*/ D)/* override*/ {
    if (Diags.hasErrorOccurred()) {
      return;
    }
    assert (D.doesThisDeclarationHaveABody());
    
    // Handle friend functions.
    if (D.isInIdentifierNamespace(Decl.IdentifierNamespace.IDNS_OrdinaryFriend)) {
      if (Ctx.getTargetInfo().getCXXABI().isMicrosoft()
         && !D.getLexicalDeclContext().isDependentContext()) {
        Builder.$arrow().EmitTopLevelDecl(D);
      }
      return;
    }
    
    // Otherwise, must be a method.
    CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(D);
    
    // We may want to emit this definition. However, that decision might be
    // based on computing the linkage, and we have to defer that in case we
    // are inside of something that will change the method's final linkage,
    // e.g.
    //   typedef struct {
    //     void bar();
    //     void foo() { bar(); }
    //   } A;
    DeferredInlineMethodDefinitions.push_back(MD);
    
    // Provide some coverage mapping even for methods that aren't emitted.
    // Don't do this for templated classes though, as they may not be
    // instantiable.
    if (!(MD.getParent().getDescribedClassTemplate() != null)) {
      Builder.$arrow().AddDeferredUnusedCoverageMapping(MD);
    }
  }

  
  /// HandleTagDeclDefinition - This callback is invoked each time a TagDecl
  /// to (e.g. struct, union, enum, class) is completed. This allows the
  /// client hack on the type, which can occur at any point in the file
  /// (because these can be defined in declspecs).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CodeGeneratorImpl::HandleTagDeclDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 204,
   FQN="(anonymous namespace)::CodeGeneratorImpl::HandleTagDeclDefinition", NM="_ZN12_GLOBAL__N_117CodeGeneratorImpl23HandleTagDeclDefinitionEPN5clang7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN12_GLOBAL__N_117CodeGeneratorImpl23HandleTagDeclDefinitionEPN5clang7TagDeclE")
  //</editor-fold>
  @Override public void HandleTagDeclDefinition(TagDecl /*P*/ D)/* override*/ {
    HandlingTopLevelDeclRAII HandlingDecl = null;
    try {
      if (Diags.hasErrorOccurred()) {
        return;
      }
      
      // Don't allow re-entrant calls to CodeGen triggered by PCH
      // deserialization to emit deferred decls.
      HandlingDecl/*J*/= new HandlingTopLevelDeclRAII(/*Deref*/this, /*EmitDeferred=*/ false);
      
      Builder.$arrow().UpdateCompletedType(D);
      
      // For MSVC compatibility, treat declarations of static data members with
      // inline initializers as definitions.
      if (Ctx.getTargetInfo().getCXXABI().isMicrosoft()) {
        for (Decl /*P*/ Member : D.decls()) {
          {
            VarDecl /*P*/ VD = dyn_cast_VarDecl(Member);
            if ((VD != null)) {
              if (Ctx.isMSStaticDataMemberInlineDefinition(VD)
                 && Ctx.DeclMustBeEmitted(VD)) {
                Builder.$arrow().EmitGlobal(new GlobalDecl(VD));
              }
            }
          }
        }
      }
      // For OpenMP emit declare reduction functions, if required.
      if ((Ctx.getLangOpts().OpenMP != 0)) {
        for (Decl /*P*/ Member : D.decls()) {
          {
            OMPDeclareReductionDecl /*P*/ DRD = dyn_cast_OMPDeclareReductionDecl(Member);
            if ((DRD != null)) {
              if (Ctx.DeclMustBeEmitted(DRD)) {
                Builder.$arrow().EmitGlobal(new GlobalDecl(DRD));
              }
            }
          }
        }
      }
    } finally {
      if (HandlingDecl != null) { HandlingDecl.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CodeGeneratorImpl::HandleTagDeclRequiredDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 237,
   FQN="(anonymous namespace)::CodeGeneratorImpl::HandleTagDeclRequiredDefinition", NM="_ZN12_GLOBAL__N_117CodeGeneratorImpl31HandleTagDeclRequiredDefinitionEPKN5clang7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN12_GLOBAL__N_117CodeGeneratorImpl31HandleTagDeclRequiredDefinitionEPKN5clang7TagDeclE")
  //</editor-fold>
  @Override public void HandleTagDeclRequiredDefinition(/*const*/ TagDecl /*P*/ D)/* override*/ {
    HandlingTopLevelDeclRAII HandlingDecl = null;
    try {
      if (Diags.hasErrorOccurred()) {
        return;
      }
      
      // Don't allow re-entrant calls to CodeGen triggered by PCH
      // deserialization to emit deferred decls.
      HandlingDecl/*J*/= new HandlingTopLevelDeclRAII(/*Deref*/this, /*EmitDeferred=*/ false);
      {
        
        CGDebugInfo /*P*/ DI = Builder.$arrow().getModuleDebugInfo();
        if ((DI != null)) {
          {
            /*const*/ RecordDecl /*P*/ RD = dyn_cast_RecordDecl(D);
            if ((RD != null)) {
              DI.completeRequiredType(RD);
            }
          }
        }
      }
    } finally {
      if (HandlingDecl != null) { HandlingDecl.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CodeGeneratorImpl::HandleTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 250,
   FQN="(anonymous namespace)::CodeGeneratorImpl::HandleTranslationUnit", NM="_ZN12_GLOBAL__N_117CodeGeneratorImpl21HandleTranslationUnitERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN12_GLOBAL__N_117CodeGeneratorImpl21HandleTranslationUnitERN5clang10ASTContextE")
  //</editor-fold>
  @Override public void HandleTranslationUnit(final ASTContext /*&*/ Ctx)/* override*/ {
    // Release the Builder when there is no error.
    if (!Diags.hasErrorOccurred() && Builder.$bool()) {
      Builder.$arrow().Release();
    }
    
    // If there are errors before or when releasing the Builder, reset
    // the module to stop here before invoking the backend.
    if (Diags.hasErrorOccurred()) {
      if (Builder.$bool()) {
        Builder.$arrow().clear();
      }
      M.reset();
      return;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CodeGeneratorImpl::AssignInheritanceModel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 265,
   FQN="(anonymous namespace)::CodeGeneratorImpl::AssignInheritanceModel", NM="_ZN12_GLOBAL__N_117CodeGeneratorImpl22AssignInheritanceModelEPN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN12_GLOBAL__N_117CodeGeneratorImpl22AssignInheritanceModelEPN5clang13CXXRecordDeclE")
  //</editor-fold>
  @Override public void AssignInheritanceModel(CXXRecordDecl /*P*/ RD)/* override*/ {
    if (Diags.hasErrorOccurred()) {
      return;
    }
    
    Builder.$arrow().RefreshTypeCacheForClass(RD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CodeGeneratorImpl::CompleteTentativeDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 272,
   FQN="(anonymous namespace)::CodeGeneratorImpl::CompleteTentativeDefinition", NM="_ZN12_GLOBAL__N_117CodeGeneratorImpl27CompleteTentativeDefinitionEPN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN12_GLOBAL__N_117CodeGeneratorImpl27CompleteTentativeDefinitionEPN5clang7VarDeclE")
  //</editor-fold>
  @Override public void CompleteTentativeDefinition(VarDecl /*P*/ D)/* override*/ {
    if (Diags.hasErrorOccurred()) {
      return;
    }
    
    Builder.$arrow().EmitTentativeDefinition(D);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CodeGeneratorImpl::HandleVTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 279,
   FQN="(anonymous namespace)::CodeGeneratorImpl::HandleVTable", NM="_ZN12_GLOBAL__N_117CodeGeneratorImpl12HandleVTableEPN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN12_GLOBAL__N_117CodeGeneratorImpl12HandleVTableEPN5clang13CXXRecordDeclE")
  //</editor-fold>
  @Override public void HandleVTable(CXXRecordDecl /*P*/ RD)/* override*/ {
    if (Diags.hasErrorOccurred()) {
      return;
    }
    
    Builder.$arrow().EmitVTable(RD);
  }

  
  @Override public String toString() {
    return "" + "Diags=" + "[DiagnosticsEngine]" // NOI18N
              + ", Ctx=" + "[ASTContext]" // NOI18N
              + ", HeaderSearchOpts=" + HeaderSearchOpts // NOI18N
              + ", PreprocessorOpts=" + PreprocessorOpts // NOI18N
              + ", CodeGenOpts=" + CodeGenOpts // NOI18N
              + ", HandlingTopLevelDecls=" + HandlingTopLevelDecls // NOI18N
              + ", CoverageInfo=" + CoverageInfo // NOI18N
              + ", M=" + M // NOI18N
              + ", Builder=" + Builder // NOI18N
              + ", DeferredInlineMethodDefinitions=" + "[SmallVector$CXXMethodDecl]" // NOI18N
              + super.toString(); // NOI18N
  }
}
