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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.cast_ImportDecl;
import static org.clang.ast.java.AstDeclarationsRTTI.dyn_cast_RecordDecl;
import static org.clang.ast.java.AstDeclarationsRTTI.dyn_cast_TagDecl;
import static org.clang.ast.java.AstDeclarationsRTTI.isa_CXXMethodDecl;
import org.clang.basic.*;
import org.clang.lex.*;
import org.llvm.ir.*;
import org.clang.codegen.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.frontend.*;
import org.clang.driver.frontend.CodeGenOptions;
import org.clang.basic.codegenoptions.DebugInfoKind;
import org.clang.basic.target.TargetOptions;
import static org.clang.codegen.CodegenClangGlobals.EmitBackendOutput;
import org.llvm.support.sys.path;
import org.llvm.support.target.TargetRegistry;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PCHContainerGenerator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp", line = 44,
 FQN="(anonymous namespace)::PCHContainerGenerator", NM="_ZN12_GLOBAL__N_121PCHContainerGeneratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN12_GLOBAL__N_121PCHContainerGeneratorE")
//</editor-fold>
public class PCHContainerGenerator extends /*public*/ ASTConsumer implements Destructors.ClassWithDestructor {
  private final DiagnosticsEngine /*&*/ Diags;
  private /*const*/std.string MainFileName;
  private /*const*/std.string OutputFileName;
  private ASTContext /*P*/ Ctx;
  private final ModuleMap /*&*/ MMap;
  private final /*const*/ HeaderSearchOptions /*&*/ HeaderSearchOpts;
  private final /*const*/ PreprocessorOptions /*&*/ PreprocessorOpts;
  private CodeGenOptions CodeGenOpts;
  private /*const*/ TargetOptions TargetOpts;
  private /*const*/ LangOptions LangOpts;
  private std.unique_ptr<LLVMContext> VMContext;
  private std.unique_ptr<org.llvm.ir.Module> M;
  private std.unique_ptr<CodeGenModule> Builder;
  private std.unique_ptr<raw_pwrite_stream> OS;
  private std.shared_ptr<PCHBuffer> Buffer;
  
  /// Visit every type and emit debug info for it.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PCHContainerGenerator::DebugTypeVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp", line = 62,
   FQN="(anonymous namespace)::PCHContainerGenerator::DebugTypeVisitor", NM="_ZN12_GLOBAL__N_121PCHContainerGenerator16DebugTypeVisitorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN12_GLOBAL__N_121PCHContainerGenerator16DebugTypeVisitorE")
  //</editor-fold>
  private static class/*struct*/ DebugTypeVisitor implements /*public*/ RecursiveASTVisitor<DebugTypeVisitor> {
    public final CGDebugInfo /*&*/ DI;
    public final ASTContext /*&*/ Ctx;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PCHContainerGenerator::DebugTypeVisitor::DebugTypeVisitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp", line = 65,
     FQN="(anonymous namespace)::PCHContainerGenerator::DebugTypeVisitor::DebugTypeVisitor", NM="_ZN12_GLOBAL__N_121PCHContainerGenerator16DebugTypeVisitorC1ERN5clang7CodeGen11CGDebugInfoERNS2_10ASTContextE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN12_GLOBAL__N_121PCHContainerGenerator16DebugTypeVisitorC1ERN5clang7CodeGen11CGDebugInfoERNS2_10ASTContextE")
    //</editor-fold>
    public DebugTypeVisitor(final CGDebugInfo /*&*/ DI, final ASTContext /*&*/ Ctx) {
      // : RecursiveASTVisitor<DebugTypeVisitor>(), DI(DI), Ctx(Ctx) 
      //START JInit
      $RecursiveASTVisitor();
      this./*&*/DI=/*&*/DI;
      this./*&*/Ctx=/*&*/Ctx;
      //END JInit
    }

    
    /// Determine whether this type can be represented in DWARF.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PCHContainerGenerator::DebugTypeVisitor::CanRepresent">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp", line = 69,
     FQN="(anonymous namespace)::PCHContainerGenerator::DebugTypeVisitor::CanRepresent", NM="_ZN12_GLOBAL__N_121PCHContainerGenerator16DebugTypeVisitor12CanRepresentEPKN5clang4TypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN12_GLOBAL__N_121PCHContainerGenerator16DebugTypeVisitor12CanRepresentEPKN5clang4TypeE")
    //</editor-fold>
    public static boolean CanRepresent(/*const*/ org.clang.ast.Type /*P*/ Ty) {
      return !Ty.isDependentType() && !Ty.isUndeducedType();
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PCHContainerGenerator::DebugTypeVisitor::VisitImportDecl">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp", line = 73,
     FQN="(anonymous namespace)::PCHContainerGenerator::DebugTypeVisitor::VisitImportDecl", NM="_ZN12_GLOBAL__N_121PCHContainerGenerator16DebugTypeVisitor15VisitImportDeclEPN5clang10ImportDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN12_GLOBAL__N_121PCHContainerGenerator16DebugTypeVisitor15VisitImportDeclEPN5clang10ImportDeclE")
    //</editor-fold>
    public boolean VisitImportDecl(ImportDecl /*P*/ D) {
      ImportDecl /*P*/ Import = cast_ImportDecl(D);
      if (!(Import.getImportedOwningModule() != null)) {
        DI.EmitImportDecl($Deref(Import));
      }
      return true;
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PCHContainerGenerator::DebugTypeVisitor::VisitTypeDecl">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp", line = 80,
     FQN="(anonymous namespace)::PCHContainerGenerator::DebugTypeVisitor::VisitTypeDecl", NM="_ZN12_GLOBAL__N_121PCHContainerGenerator16DebugTypeVisitor13VisitTypeDeclEPN5clang8TypeDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN12_GLOBAL__N_121PCHContainerGenerator16DebugTypeVisitor13VisitTypeDeclEPN5clang8TypeDeclE")
    //</editor-fold>
    public boolean VisitTypeDecl(TypeDecl /*P*/ D) {
      {
        // TagDecls may be deferred until after all decls have been merged and we
        // know the complete type. Pure forward declarations will be skipped, but
        // they don't need to be emitted into the module anyway.
        TagDecl /*P*/ TD = dyn_cast_TagDecl(D);
        if ((TD != null)) {
          if (!TD.isCompleteDefinition()) {
            return true;
          }
        }
      }
      
      QualType QualTy = Ctx.getTypeDeclType(D);
      if (!QualTy.isNull() && DebugTypeVisitor.CanRepresent(QualTy.getTypePtr())) {
        DI.getOrCreateStandaloneType(new QualType(QualTy), D.getLocation());
      }
      return true;
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PCHContainerGenerator::DebugTypeVisitor::VisitObjCInterfaceDecl">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp", line = 94,
     FQN="(anonymous namespace)::PCHContainerGenerator::DebugTypeVisitor::VisitObjCInterfaceDecl", NM="_ZN12_GLOBAL__N_121PCHContainerGenerator16DebugTypeVisitor22VisitObjCInterfaceDeclEPN5clang17ObjCInterfaceDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN12_GLOBAL__N_121PCHContainerGenerator16DebugTypeVisitor22VisitObjCInterfaceDeclEPN5clang17ObjCInterfaceDeclE")
    //</editor-fold>
    public boolean VisitObjCInterfaceDecl(ObjCInterfaceDecl /*P*/ D) {
      QualType QualTy/*J*/= new QualType(D.getTypeForDecl(), 0);
      if (!QualTy.isNull() && DebugTypeVisitor.CanRepresent(QualTy.getTypePtr())) {
        DI.getOrCreateStandaloneType(new QualType(QualTy), D.getLocation());
      }
      return true;
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PCHContainerGenerator::DebugTypeVisitor::VisitFunctionDecl">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp", line = 101,
     FQN="(anonymous namespace)::PCHContainerGenerator::DebugTypeVisitor::VisitFunctionDecl", NM="_ZN12_GLOBAL__N_121PCHContainerGenerator16DebugTypeVisitor17VisitFunctionDeclEPN5clang12FunctionDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN12_GLOBAL__N_121PCHContainerGenerator16DebugTypeVisitor17VisitFunctionDeclEPN5clang12FunctionDeclE")
    //</editor-fold>
    public boolean VisitFunctionDecl(FunctionDecl /*P*/ D) {
      if (isa_CXXMethodDecl(D)) {
        // This is not yet supported. Constructing the `this' argument
        // mandates a CodeGenFunction.
        return true;
      }
      
      SmallVector<QualType> ArgTypes/*J*/= new SmallVector<QualType>(16, new QualType());
      for (ParmVarDecl /*P*/ i : D.parameters())  {
        ArgTypes.push_back(i.getType());
      }
      QualType RetTy = D.getReturnType();
      QualType FnTy = Ctx.getFunctionType(new QualType(RetTy), new ArrayRef<QualType>(ArgTypes, false), 
          new FunctionProtoType.ExtProtoInfo());
      if (DebugTypeVisitor.CanRepresent(FnTy.getTypePtr())) {
        DI.EmitFunctionDecl(new GlobalDecl(D), D.getLocation(), new QualType(FnTy));
      }
      return true;
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PCHContainerGenerator::DebugTypeVisitor::VisitObjCMethodDecl">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp", line = 118,
     FQN="(anonymous namespace)::PCHContainerGenerator::DebugTypeVisitor::VisitObjCMethodDecl", NM="_ZN12_GLOBAL__N_121PCHContainerGenerator16DebugTypeVisitor19VisitObjCMethodDeclEPN5clang14ObjCMethodDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN12_GLOBAL__N_121PCHContainerGenerator16DebugTypeVisitor19VisitObjCMethodDeclEPN5clang14ObjCMethodDeclE")
    //</editor-fold>
    public boolean VisitObjCMethodDecl(ObjCMethodDecl /*P*/ D) {
      if (!(D.getClassInterface() != null)) {
        return true;
      }
      
      bool$ref selfIsPseudoStrong = create_bool$ref();
      bool$ref selfIsConsumed = create_bool$ref();
      SmallVector<QualType> ArgTypes/*J*/= new SmallVector<QualType>(16, new QualType());
      ArgTypes.push_back(D.getSelfType(Ctx, D.getClassInterface(), 
              selfIsPseudoStrong, selfIsConsumed));
      ArgTypes.push_back(Ctx.getObjCSelType());
      for (ParmVarDecl /*P*/ i : D.parameters())  {
        ArgTypes.push_back(i.getType());
      }
      QualType RetTy = D.getReturnType();
      QualType FnTy = Ctx.getFunctionType(new QualType(RetTy), new ArrayRef<QualType>(ArgTypes, false), 
          new FunctionProtoType.ExtProtoInfo());
      if (DebugTypeVisitor.CanRepresent(FnTy.getTypePtr())) {
        DI.EmitFunctionDecl(new GlobalDecl(D), D.getLocation(), new QualType(FnTy));
      }
      return true;
    }

    
    @Override public String toString() {
      return "" + "DI=" + DI // NOI18N
                + ", Ctx=" + "[ASTContext]" // NOI18N
                + super.toString(); // NOI18N
    }
  };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PCHContainerGenerator::PCHContainerGenerator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp", line = 139,
   FQN="(anonymous namespace)::PCHContainerGenerator::PCHContainerGenerator", NM="_ZN12_GLOBAL__N_121PCHContainerGeneratorC1ERN5clang16CompilerInstanceERKSsS5_St10unique_ptrIN4llvm17raw_pwrite_streamESt14default_deleteIS8_EESt10shared_ptrINS1_9PCHBufferEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN12_GLOBAL__N_121PCHContainerGeneratorC1ERN5clang16CompilerInstanceERKSsS5_St10unique_ptrIN4llvm17raw_pwrite_streamESt14default_deleteIS8_EESt10shared_ptrINS1_9PCHBufferEE")
  //</editor-fold>
  public PCHContainerGenerator(final CompilerInstance /*&*/ CI, final /*const*/std.string/*&*/ MainFileName, 
      final /*const*/std.string/*&*/ OutputFileName, 
      std.unique_ptr<raw_pwrite_stream> OS, 
      std.shared_ptr<PCHBuffer> Buffer) {
    // : ASTConsumer(), Diags(CI.getDiagnostics()), MainFileName(MainFileName), OutputFileName(OutputFileName), Ctx(null), MMap(CI.getPreprocessor().getHeaderSearchInfo().getModuleMap()), HeaderSearchOpts(CI.getHeaderSearchOpts()), PreprocessorOpts(CI.getPreprocessorOpts()), CodeGenOpts(), TargetOpts(CI.getTargetOpts()), LangOpts(CI.getLangOpts()), VMContext(), M(), Builder(), OS(std::move(OS)), Buffer(std::move(Buffer)) 
    //START JInit
    super();
    this./*&*/Diags=/*&*/CI.getDiagnostics();
    this.MainFileName = new std.string(MainFileName);
    this.OutputFileName = new std.string(OutputFileName);
    this.Ctx = null;
    this./*&*/MMap=/*&*/CI.getPreprocessor().getHeaderSearchInfo().getModuleMap();
    this./*&*/HeaderSearchOpts=/*&*/CI.getHeaderSearchOpts();
    this./*&*/PreprocessorOpts=/*&*/CI.getPreprocessorOpts();
    this.CodeGenOpts = new CodeGenOptions();
    this.TargetOpts = new TargetOptions(CI.getTargetOpts());
    this.LangOpts = new LangOptions(CI.getLangOpts());
    this.VMContext = new std.unique_ptr<LLVMContext>();
    this.M = new std.unique_ptr<org.llvm.ir.Module>();
    this.Builder = new std.unique_ptr<CodeGenModule>();
    this.OS = new std.unique_ptr<raw_pwrite_stream>(JD$Move.INSTANCE, std.move(OS));
    this.Buffer = new std.shared_ptr<PCHBuffer>(JD$Move.INSTANCE, std.move(Buffer));
    //END JInit
    // The debug info output isn't affected by CodeModel and
    // ThreadModel, but the backend expects them to be nonempty.
    CodeGenOpts.CodeModel.$assign_T$C$P(/*KEEP_STR*/"default");
    CodeGenOpts.ThreadModel.$assign_T$C$P(/*KEEP_STR*/"single");
    CodeGenOpts.DebugTypeExtRefs = true;
    CodeGenOpts.setDebugInfo(DebugInfoKind.FullDebugInfo);
    CodeGenOpts.setDebuggerTuning(CI.getCodeGenOpts().getDebuggerTuning());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PCHContainerGenerator::~PCHContainerGenerator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp", line = 159,
   FQN="(anonymous namespace)::PCHContainerGenerator::~PCHContainerGenerator", NM="_ZN12_GLOBAL__N_121PCHContainerGeneratorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN12_GLOBAL__N_121PCHContainerGeneratorD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*//* = default*/ {
    //START JDestroy
    Buffer.$destroy();
    OS.$destroy();
    Builder.$destroy();
    M.$destroy();
    VMContext.$destroy();
    LangOpts.$destroy();
    TargetOpts.$destroy();
    CodeGenOpts.$destroy();
    OutputFileName.$destroy();
    MainFileName.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PCHContainerGenerator::Initialize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp", line = 161,
   FQN="(anonymous namespace)::PCHContainerGenerator::Initialize", NM="_ZN12_GLOBAL__N_121PCHContainerGenerator10InitializeERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN12_GLOBAL__N_121PCHContainerGenerator10InitializeERN5clang10ASTContextE")
  //</editor-fold>
  @Override public void Initialize(final ASTContext /*&*/ Context)/* override*/ {
    assert (!(Ctx != null)) : "initialized multiple times";
    
    Ctx = $AddrOf(Context);
    VMContext.reset(new LLVMContext());
    M.reset(new org.llvm.ir.Module(new StringRef(MainFileName), VMContext.$star()));
    M.$arrow().setDataLayout(Ctx.getTargetInfo().getDataLayout());
    Builder.reset(new CodeGenModule($Deref(Ctx), HeaderSearchOpts, PreprocessorOpts, CodeGenOpts, M.$star(), Diags));
    
    // Prepare CGDebugInfo to emit debug info for a clang module.
    CGDebugInfo /*P*/ DI = Builder.$arrow().getModuleDebugInfo();
    StringRef ModuleName = path.filename(new StringRef(MainFileName));
    DI.setPCHDescriptor(/*{ */new ExternalASTSource.ASTSourceDescriptor(new StringRef(ModuleName), new StringRef(/*KEEP_STR*/$EMPTY), new StringRef(OutputFileName), ~1L/*ULL*/)/* }*/);
    DI.setModuleMap(MMap);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PCHContainerGenerator::HandleTopLevelDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp", line = 178,
   FQN="(anonymous namespace)::PCHContainerGenerator::HandleTopLevelDecl", NM="_ZN12_GLOBAL__N_121PCHContainerGenerator18HandleTopLevelDeclEN5clang12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN12_GLOBAL__N_121PCHContainerGenerator18HandleTopLevelDeclEN5clang12DeclGroupRefE")
  //</editor-fold>
  @Override public boolean HandleTopLevelDecl(DeclGroupRef D)/* override*/ {
    if (Diags.hasErrorOccurred()) {
      return true;
    }
    
    // Collect debug info for all decls in this group.
    for (Decl /*P*/ I : D)  {
      if (!I.isFromASTFile()) {
        DebugTypeVisitor DTV/*J*/= new DebugTypeVisitor($Deref(Builder.$arrow().getModuleDebugInfo()), $Deref(Ctx));
        DTV.TraverseDecl(I);
      }
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PCHContainerGenerator::HandleTopLevelDeclInObjCContainer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp", line = 191,
   FQN="(anonymous namespace)::PCHContainerGenerator::HandleTopLevelDeclInObjCContainer", NM="_ZN12_GLOBAL__N_121PCHContainerGenerator33HandleTopLevelDeclInObjCContainerEN5clang12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN12_GLOBAL__N_121PCHContainerGenerator33HandleTopLevelDeclInObjCContainerEN5clang12DeclGroupRefE")
  //</editor-fold>
  @Override public void HandleTopLevelDeclInObjCContainer(DeclGroupRef D)/* override*/ {
    HandleTopLevelDecl(new DeclGroupRef(D));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PCHContainerGenerator::HandleTagDeclDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp", line = 195,
   FQN="(anonymous namespace)::PCHContainerGenerator::HandleTagDeclDefinition", NM="_ZN12_GLOBAL__N_121PCHContainerGenerator23HandleTagDeclDefinitionEPN5clang7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN12_GLOBAL__N_121PCHContainerGenerator23HandleTagDeclDefinitionEPN5clang7TagDeclE")
  //</editor-fold>
  @Override public void HandleTagDeclDefinition(TagDecl /*P*/ D)/* override*/ {
    if (Diags.hasErrorOccurred()) {
      return;
    }
    if (D.isFromASTFile()) {
      return;
    }
    
    // Anonymous tag decls are deferred until we are building their declcontext.
    if (D.getName().empty()) {
      return;
    }
    
    // Defer tag decls until their declcontext is complete.
    DeclContext /*P*/ DeclCtx = D.getDeclContext();
    while ((DeclCtx != null)) {
      {
        TagDecl /*P*/ D$1 = dyn_cast_TagDecl(DeclCtx);
        if ((D$1 != null)) {
          if (!D$1.isCompleteDefinition()) {
            return;
          }
        }
      }
      DeclCtx = DeclCtx.getParent();
    }
    
    DebugTypeVisitor DTV/*J*/= new DebugTypeVisitor($Deref(Builder.$arrow().getModuleDebugInfo()), $Deref(Ctx));
    DTV.TraverseDecl(D);
    Builder.$arrow().UpdateCompletedType(D);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PCHContainerGenerator::HandleTagDeclRequiredDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp", line = 220,
   FQN="(anonymous namespace)::PCHContainerGenerator::HandleTagDeclRequiredDefinition", NM="_ZN12_GLOBAL__N_121PCHContainerGenerator31HandleTagDeclRequiredDefinitionEPKN5clang7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN12_GLOBAL__N_121PCHContainerGenerator31HandleTagDeclRequiredDefinitionEPKN5clang7TagDeclE")
  //</editor-fold>
  @Override public void HandleTagDeclRequiredDefinition(/*const*/ TagDecl /*P*/ D)/* override*/ {
    if (Diags.hasErrorOccurred()) {
      return;
    }
    {
      
      /*const*/ RecordDecl /*P*/ RD = dyn_cast_RecordDecl(D);
      if ((RD != null)) {
        Builder.$arrow().getModuleDebugInfo().completeRequiredType(RD);
      }
    }
  }

  
  /// Emit a container holding the serialized AST.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PCHContainerGenerator::HandleTranslationUnit">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp", line = 229,
   FQN="(anonymous namespace)::PCHContainerGenerator::HandleTranslationUnit", NM="_ZN12_GLOBAL__N_121PCHContainerGenerator21HandleTranslationUnitERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN12_GLOBAL__N_121PCHContainerGenerator21HandleTranslationUnitERN5clang10ASTContextE")
  //</editor-fold>
  @Override public void HandleTranslationUnit(final ASTContext /*&*/ Ctx)/* override*/ {
    std.unique_ptr<LLVMContext> VMContext = null;
    std.unique_ptr<org.llvm.ir.Module> M = null;
    std.unique_ptr<CodeGenModule> Builder = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (M.$bool() && VMContext.$bool() && Builder.$bool());
      // Delete these on function exit.
      VMContext = new std.unique_ptr<LLVMContext>(JD$Move.INSTANCE, std.move(this.VMContext));
      M = new std.unique_ptr<org.llvm.ir.Module>(JD$Move.INSTANCE, std.move(this.M));
      Builder = new std.unique_ptr<CodeGenModule>(JD$Move.INSTANCE, std.move(this.Builder));
      if (Diags.hasErrorOccurred()) {
        return;
      }
      
      M.$arrow().setTargetTriple(new StringRef(Ctx.getTargetInfo().getTriple().getTriple()));
      M.$arrow().setDataLayout(Ctx.getTargetInfo().getDataLayout());
      
      // PCH files don't have a signature field in the control block,
      // but LLVM detects DWO CUs by looking for a non-zero DWO id.
      long/*uint64_t*/ Signature = (Buffer.$arrow().Signature != 0) ? Buffer.$arrow().Signature : ~1L/*ULL*/;
      Builder.$arrow().getModuleDebugInfo().setDwoId(Signature);
      
      // Finalize the Builder.
      if (Builder.$bool()) {
        Builder.$arrow().Release();
      }
      
      // Ensure the target exists.
      std.string Error/*J*/= new std.string();
      Triple $Triple = new Triple(Ctx.getTargetInfo().getTriple());
      if (!(TargetRegistry.lookupTarget($Triple.getTriple(), Error) != null)) {
        llvm.report_fatal_error(Error);
      }
      
      // Emit the serialized Clang AST into its own section.
      assert (Buffer.$arrow().IsComplete) : "serialization did not complete";
      final SmallString /*&*/ SerializedAST = Buffer.$arrow().Data;
      /*size_t*/int Size = SerializedAST.size();
      IntegerType /*P*/ Int8Ty = org.llvm.ir.Type.getInt8Ty(VMContext.$star());
      org.llvm.ir.ArrayType /*P*/ Ty = org.llvm.ir.ArrayType.get(Int8Ty, $uint2ulong(Size));
      Constant /*P*/ Data = ConstantDataArray.getString(VMContext.$star(), new StringRef(SerializedAST.data(), Size), 
          /*AddNull=*/ false);
      std.unique_ptr<org.llvm.ir.Module> M_final = M;
      GlobalVariable /*P*/ ASTSym = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(M_final.$star(), Ty, /*constant*/ true, GlobalVariable.LinkageTypes.InternalLinkage, Data, 
          new Twine(/*KEEP_STR*/"__clang_ast"));
       });
      // The on-disk hashtable needs to be aligned.
      ASTSym.setAlignment(8);
      
      // Mach-O also needs a segment name.
      if ($Triple.isOSBinFormatMachO()) {
        ASTSym.setSection(new StringRef(/*KEEP_STR*/"__CLANG,__clangast"));
      } else // COFF has an eight character length limit.
      if ($Triple.isOSBinFormatCOFF()) {
        ASTSym.setSection(new StringRef(/*KEEP_STR*/"clangast"));
      } else {
        ASTSym.setSection(new StringRef(/*KEEP_STR*/"__clangast"));
      }
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"pchcontainer")) {
          {
            SmallString/*<0>*/ Buffer/*J*/= new SmallString/*<0>*/(0);
            EmitBackendOutput(Diags, CodeGenOpts, TargetOpts, LangOpts, Ctx.getTargetInfo().getDataLayout(), M.get(), BackendAction.Backend_EmitLL, $c$.track(new std.unique_ptr<raw_pwrite_stream>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new raw_svector_ostream(Buffer)))))); $c$.clean();
            llvm.dbgs().$out(Buffer);
          }
          ;
        }
      } while (false);
      
      // Use the LLVM backend to emit the pch container.
      EmitBackendOutput(Diags, CodeGenOpts, TargetOpts, LangOpts, 
          Ctx.getTargetInfo().getDataLayout(), M.get(), 
          BackendAction.Backend_EmitObj, $c$.track(new std.unique_ptr<raw_pwrite_stream>(JD$Move.INSTANCE, std.move(OS)))); $c$.clean();
      
      // Free the memory for the temporary buffer.
      SmallString Empty/*J*/= new SmallString(0);
      SerializedAST.$assignMove(std.move(Empty));
    } finally {
      if (Builder != null) { Builder.$destroy(); }
      if (M != null) { M.$destroy(); }
      if (VMContext != null) { VMContext.$destroy(); }
      $c$.$destroy();
    }
  }

  
  @Override public String toString() {
    return "" + "Diags=" + "[DiagnosticsEngine]" // NOI18N
              + ", MainFileName=" + MainFileName // NOI18N
              + ", OutputFileName=" + OutputFileName // NOI18N
              + ", Ctx=" + "[ASTContext]" // NOI18N
              + ", MMap=" + MMap // NOI18N
              + ", HeaderSearchOpts=" + HeaderSearchOpts // NOI18N
              + ", PreprocessorOpts=" + PreprocessorOpts // NOI18N
              + ", CodeGenOpts=" + CodeGenOpts // NOI18N
              + ", TargetOpts=" + TargetOpts // NOI18N
              + ", LangOpts=" + LangOpts // NOI18N
              + ", VMContext=" + "[Unique_ptr$LLVMContext]" // NOI18N
              + ", M=" + M // NOI18N
              + ", Builder=" + Builder // NOI18N
              + ", OS=" + OS // NOI18N
              + ", Buffer=" + Buffer // NOI18N
              + super.toString(); // NOI18N
  }
}
