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
package org.clang.codegen.CodeGen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.ir.*;
import org.llvm.ir.java.*;
import org.clang.codegen.CodeGen.*;
import org.clang.driver.frontend.CodeGenOptions;
import org.clang.basic.CallingConv;
import org.clang.ast.ArrayType;
import static org.clang.ast.AstClangGlobals.$out_DiagnosticBuilder$C_DeclarationName;
import org.llvm.ir.FunctionType;
import org.llvm.ir.PointerType;
import org.llvm.ir.Type;
import org.clang.ast.BinaryOperator;
import org.llvm.ir.intrinsic.ID;
import static org.clang.codegen.impl.CodeGenFunctionStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import org.clang.basic.codegenoptions.DebugInfoKind;
import org.clang.codegen.CodeGen.impl.EHScopeStack.stable_iterator;
import org.clang.codegen.impl.CodeGenFunctionStatics;
import static org.llvm.ir.intrinsic.IntrinsicGlobals.getDeclaration;
import org.llvm.transforms.utils.SanitizerStatKind;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_CodeGenFunction",        
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_CGVTables ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction10getVLASizeENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction10getVLASizeEPKNS_17VariableArrayTypeE;_ZN5clang7CodeGen15CodeGenFunction11ConvertTypeENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction12GenerateCodeENS_10GlobalDeclEPN4llvm8FunctionERKNS0_14CGFunctionInfoE;_ZN5clang7CodeGen15CodeGenFunction13ContainsLabelEPKNS_4StmtEb;_ZN5clang7CodeGen15CodeGenFunction13EmitVAListRefEPKNS_4ExprE;_ZN5clang7CodeGen15CodeGenFunction13StartFunctionENS_10GlobalDeclENS_8QualTypeEPN4llvm8FunctionERKNS0_14CGFunctionInfoERKNS0_15FunctionArgListENS_14SourceLocationESD_;_ZN5clang7CodeGen15CodeGenFunction13containsBreakEPKNS_4StmtE;_ZN5clang7CodeGen15CodeGenFunction14FinishFunctionENS_14SourceLocationE;_ZN5clang7CodeGen15CodeGenFunction14GetAddrOfLabelEPKNS_9LabelDeclE;_ZN5clang7CodeGen15CodeGenFunction15EmitMSVAListRefEPKNS_4ExprE;_ZN5clang7CodeGen15CodeGenFunction15EmitReturnBlockEv;_ZN5clang7CodeGen15CodeGenFunction15emitArrayLengthEPKNS_9ArrayTypeERNS_8QualTypeERNS0_7AddressE;_ZN5clang7CodeGen15CodeGenFunction16EmitFunctionBodyERNS0_15FunctionArgListEPKNS_4StmtE;_ZN5clang7CodeGen15CodeGenFunction16ErrorUnsupportedEPKNS_4StmtEPKc;_ZN5clang7CodeGen15CodeGenFunction17ConvertTypeForMemENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction17getEvaluationKindENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction18EmitAnnotationCallEPN4llvm5ValueES4_NS2_9StringRefENS_14SourceLocationE;_ZN5clang7CodeGen15CodeGenFunction18EmitVarAnnotationsEPKNS_7VarDeclEPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction19checkTargetFeaturesEPKNS_8CallExprEPKNS_12FunctionDeclE;_ZN5clang7CodeGen15CodeGenFunction20BuildFunctionArgListENS_10GlobalDeclERNS0_15FunctionArgListE;_ZN5clang7CodeGen15CodeGenFunction20EmitBranchOnBoolExprEPKNS_4ExprEPN4llvm10BasicBlockES7_y;_ZN5clang7CodeGen15CodeGenFunction20EmitFieldAnnotationsEPKNS_9FieldDeclENS0_7AddressE;_ZN5clang7CodeGen15CodeGenFunction20GetIndirectGotoBlockEv;_ZN5clang7CodeGen15CodeGenFunction20protectFromPeepholesENS0_6RValueE;_ZN5clang7CodeGen15CodeGenFunction22EmitNullInitializationENS0_7AddressENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction22unprotectFromPeepholesENS1_18PeepholeProtectionE;_ZN5clang7CodeGen15CodeGenFunction23EmitDeclRefExprDbgValueEPKNS_11DeclRefExprEPN4llvm8ConstantE;_ZN5clang7CodeGen15CodeGenFunction23EmitSanitizerStatReportEN4llvm17SanitizerStatKindE;_ZN5clang7CodeGen15CodeGenFunction23getNaturalTypeAlignmentENS_8QualTypeEPNS0_15AlignmentSourceEb;_ZN5clang7CodeGen15CodeGenFunction24EmitBlockWithFallThroughEPN4llvm10BasicBlockEPKNS_4StmtE;_ZN5clang7CodeGen15CodeGenFunction24EmitOpenCLKernelMetadataEPKNS_12FunctionDeclEPN4llvm8FunctionE;_ZN5clang7CodeGen15CodeGenFunction24EmitVariablyModifiedTypeENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction24ShouldInstrumentFunctionEv;_ZN5clang7CodeGen15CodeGenFunction25EmitMCountInstrumentationEv;_ZN5clang7CodeGen15CodeGenFunction26MakeNaturalAlignAddrLValueEPN4llvm5ValueENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction27EmitFunctionInstrumentationEPKc;_ZN5clang7CodeGen15CodeGenFunction28ConstantFoldsToSimpleIntegerEPKNS_4ExprERN4llvm6APSIntEb;_ZN5clang7CodeGen15CodeGenFunction28ConstantFoldsToSimpleIntegerEPKNS_4ExprERbb;_ZN5clang7CodeGen15CodeGenFunction30getNaturalPointeeTypeAlignmentENS_8QualTypeEPNS0_15AlignmentSourceE;_ZN5clang7CodeGen15CodeGenFunction33MakeNaturalAlignPointeeAddrLValueEPN4llvm5ValueENS_8QualTypeE;_ZNK5clang7CodeGen15CodeGenFunction12InsertHelperEPN4llvm11InstructionERKNS2_5TwineEPNS2_10BasicBlockENS2_14ilist_iteratorIS3_EE;_ZNK5clang7CodeGen15CodeGenFunction28ShouldXRayInstrumentFunctionEv; -static-type=CodeGenFunction_CodeGenFunction -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_CodeGenFunction extends CodeGenFunction_CGVTables {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_CodeGenFunction(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}


/// \brief CGBuilder insert helper. This function is called after an
/// instruction is created using Builder.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::InsertHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1908,
 FQN="clang::CodeGen::CodeGenFunction::InsertHelper", NM="_ZNK5clang7CodeGen15CodeGenFunction12InsertHelperEPN4llvm11InstructionERKNS2_5TwineEPNS2_10BasicBlockENS2_14ilist_iteratorIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction12InsertHelperEPN4llvm11InstructionERKNS2_5TwineEPNS2_10BasicBlockENS2_14ilist_iteratorIS3_EE")
//</editor-fold>
public final void InsertHelper(Instruction /*P*/ I, 
            final /*const*/ Twine /*&*/ Name, 
            BasicBlock /*P*/ BB, 
            ilist_iterator<Instruction> InsertPt) /*const*/ {
  $this().LoopStack.InsertHelper(I);
  if ($this().IsSanitizerScope) {
    $this().CGM.getSanitizerMetadata().disableSanitizerForInstruction(I);
  }
}


/// Add a kernel metadata node to the named metadata node 'opencl.kernels'.
/// In the kernel metadata node, reference the kernel function and metadata 
/// nodes for its optional attribute qualifiers (OpenCL 1.1 6.7.2):
/// - A node for the vec_type_hint(<type>) qualifier contains string
///   "vec_type_hint", an undefined value of the <type> data type,
///   and a Boolean that is true if the <type> is integer and signed.
/// - A node for the work_group_size_hint(X,Y,Z) qualifier contains string 
///   "work_group_size_hint", and three 32-bit integers X, Y and Z.
/// - A node for the reqd_work_group_size(X,Y,Z) qualifier contains string 
///   "reqd_work_group_size", and three 32-bit integers X, Y and Z.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOpenCLKernelMetadata">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 595,
 FQN="clang::CodeGen::CodeGenFunction::EmitOpenCLKernelMetadata", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitOpenCLKernelMetadataEPKNS_12FunctionDeclEPN4llvm8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitOpenCLKernelMetadataEPKNS_12FunctionDeclEPN4llvm8FunctionE")
//</editor-fold>
protected/*private*/ final void EmitOpenCLKernelMetadata(/*const*/ FunctionDecl /*P*/ FD, 
                        Function /*P*/ Fn) {
  if (!FD.hasAttr(OpenCLKernelAttr.class)) {
    return;
  }
  
  final LLVMContext /*&*/ Context = $this().getLLVMContext();
  
  CodeGenFunctionStatics.GenOpenCLArgMetadata(FD, Fn, $this().CGM, Context, $this().Builder, $this().getContext());
  {
    
    /*const*/ VecTypeHintAttr /*P*/ A = FD.getAttr(VecTypeHintAttr.class);
    if ((A != null)) {
      QualType hintQTy = A.getTypeHint();
      /*const*/ ExtVectorType /*P*/ hintEltQTy = hintQTy.$arrow().getAs(ExtVectorType.class);
      boolean isSignedInteger = hintQTy.$arrow().isSignedIntegerType()
         || ((hintEltQTy != null) && hintEltQTy.getElementType().$arrow().isSignedIntegerType());
      Metadata /*P*/ attrMDArgs[/*2*/] = new Metadata /*P*/  [/*2*/] {
        ConstantAsMetadata.get(UndefValue.get($this().CGM.getTypes().ConvertType(A.getTypeHint()))), 
        ConstantAsMetadata.get(ConstantInt.get(IntegerType.get(Context, 32), 
                new APInt(JD$UInt_ULong.INSTANCE, 32, (long/*uint64_t*/)$int2ulong((isSignedInteger ? 1 : 0)))))
      };
      Fn.setMetadata(new StringRef(/*KEEP_STR*/"vec_type_hint"), MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(attrMDArgs, true)));
    }
  }
  {
    
    /*const*/ WorkGroupSizeHintAttr /*P*/ A = FD.getAttr(WorkGroupSizeHintAttr.class);
    if ((A != null)) {
      Metadata /*P*/ attrMDArgs[/*3*/] = new Metadata /*P*/  [/*3*/] {
        ConstantAsMetadata.get($this().Builder.getInt32(A.getXDim())), 
        ConstantAsMetadata.get($this().Builder.getInt32(A.getYDim())), 
        ConstantAsMetadata.get($this().Builder.getInt32(A.getZDim()))};
      Fn.setMetadata(new StringRef(/*KEEP_STR*/"work_group_size_hint"), MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(attrMDArgs, true)));
    }
  }
  {
    
    /*const*/ ReqdWorkGroupSizeAttr /*P*/ A = FD.getAttr(ReqdWorkGroupSizeAttr.class);
    if ((A != null)) {
      Metadata /*P*/ attrMDArgs[/*3*/] = new Metadata /*P*/  [/*3*/] {
        ConstantAsMetadata.get($this().Builder.getInt32(A.getXDim())), 
        ConstantAsMetadata.get($this().Builder.getInt32(A.getYDim())), 
        ConstantAsMetadata.get($this().Builder.getInt32(A.getZDim()))};
      Fn.setMetadata(new StringRef(/*KEEP_STR*/"reqd_work_group_size"), MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(attrMDArgs, true)));
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::BuildFunctionArgList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 953,
 FQN="clang::CodeGen::CodeGenFunction::BuildFunctionArgList", NM="_ZN5clang7CodeGen15CodeGenFunction20BuildFunctionArgListENS_10GlobalDeclERNS0_15FunctionArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20BuildFunctionArgListENS_10GlobalDeclERNS0_15FunctionArgListE")
//</editor-fold>
public final QualType BuildFunctionArgList(GlobalDecl GD, 
                    final FunctionArgList /*&*/ Args) {
  /*const*/ FunctionDecl /*P*/ FD = cast_FunctionDecl(GD.getDecl());
  QualType ResTy = FD.getReturnType();
  
  /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(FD);
  if ((MD != null) && MD.isInstance()) {
    if ($this().CGM.getCXXABI().HasThisReturn(new GlobalDecl(GD))) {
      ResTy.$assignMove(MD.getThisType($this().getContext()));
    } else if ($this().CGM.getCXXABI().hasMostDerivedReturn(new GlobalDecl(GD))) {
      ResTy.$assignMove($this().CGM.getContext().VoidPtrTy.$QualType());
    }
    $this().CGM.getCXXABI().buildThisParam(/*Deref*/$this(), Args);
  }
  
  // The base version of an inheriting constructor whose constructed base is a
  // virtual base is not passed any arguments (because it doesn't actually call
  // the inherited constructor).
  boolean PassedParams = true;
  {
    /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(FD);
    if ((CD != null)) {
      {
        InheritedConstructor Inherited = CD.getInheritedConstructor();
        if (Inherited.$bool()) {
          PassedParams
             = $this().getTypes().inheritingCtorHasParams(Inherited, GD.getCtorType());
        }
      }
    }
  }
  if (PassedParams) {
    for (ParmVarDecl /*P*/ Param : FD.parameters$Const()) {
      Args.push_back(Param);
      if (!Param.hasAttr(PassObjectSizeAttr.class)) {
        continue;
      }
      
      IdentifierInfo /*P*/ NoID = null;
      ImplicitParamDecl /*P*/ Implicit = ImplicitParamDecl.Create($this().getContext(), Param.getDeclContext(), Param.getLocation(), NoID, 
          $this().getContext().getSizeType().$QualType());
      $this().SizeArguments.$set(Param, Implicit);
      Args.push_back(Implicit);
    }
  }
  if ((MD != null) && (isa_CXXConstructorDecl(MD) || isa_CXXDestructorDecl(MD))) {
    $this().CGM.getCXXABI().addImplicitStructorParams(/*Deref*/$this(), ResTy, Args);
  }
  
  return ResTy;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GenerateCode">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 997,
 FQN="clang::CodeGen::CodeGenFunction::GenerateCode", NM="_ZN5clang7CodeGen15CodeGenFunction12GenerateCodeENS_10GlobalDeclEPN4llvm8FunctionERKNS0_14CGFunctionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12GenerateCodeENS_10GlobalDeclEPN4llvm8FunctionERKNS0_14CGFunctionInfoE")
//</editor-fold>
public final void GenerateCode(GlobalDecl GD, Function /*P*/ Fn, 
            final /*const*/ CGFunctionInfo /*&*/ FnInfo) {
  FunctionArgList Args = null;
  try {
    /*const*/ FunctionDecl /*P*/ FD = cast_FunctionDecl(GD.getDecl());
    $this().CurGD.$assign(GD);
    
    Args/*J*/= new FunctionArgList();
    QualType ResTy = $this().BuildFunctionArgList(new GlobalDecl(GD), Args);
    
    // Check if we should generate debug info for this function.
    if (FD.hasAttr(NoDebugAttr.class)) {
      $this().DebugInfo = null; // disable debug info indefinitely for this function
    }
    
    SourceRange BodyRange/*J*/= new SourceRange();
    {
      Stmt /*P*/ Body = FD.getBody();
      if ((Body != null)) {
        BodyRange.$assignMove(Body.getSourceRange());
      }
    }
    $this().CurEHLocation.$assignMove(BodyRange.getEnd());
    
    // Use the location of the start of the function to determine where
    // the function definition is located. By default use the location
    // of the declaration as the location for the subprogram. A function
    // may lack a declaration in the source code if it is created by code
    // gen. (examples: _GLOBAL__I_a, __cxx_global_array_dtor, thunk).
    SourceLocation Loc = FD.getLocation();
    {
      
      // If this is a function specialization then use the pattern body
      // as the location for the function.
      type$ref</*const*/ FunctionDecl /*P*/ > SpecDecl = create_type$ref(FD.getTemplateInstantiationPattern());
      if ((SpecDecl.$deref() != null)) {
        if (SpecDecl.$deref().hasBody(SpecDecl)) {
          Loc.$assignMove(SpecDecl.$deref().getLocation());
        }
      }
    }
    
    // Emit the standard function prologue.
    $this().StartFunction(new GlobalDecl(GD), new QualType(ResTy), Fn, FnInfo, Args, new SourceLocation(Loc), BodyRange.getBegin());
    
    // Generate the body of the function.
    $this().PGO.assignRegionCounters(new GlobalDecl(GD), $this().CurFn);
    if (isa_CXXDestructorDecl(FD)) {
      $this().EmitDestructorBody(Args);
    } else if (isa_CXXConstructorDecl(FD)) {
      $this().EmitConstructorBody(Args);
    } else if ($this().getLangOpts().CUDA
       && !$this().getLangOpts().CUDAIsDevice
       && FD.hasAttr(CUDAGlobalAttr.class)) {
      $this().CGM.getCUDARuntime().emitDeviceStub(/*Deref*/$this(), Args);
    } else if (isa_CXXConversionDecl(FD)
       && cast_CXXConversionDecl(FD).isLambdaToBlockPointerConversion()) {
      // The lambda conversion to block pointer is special; the semantics can't be
      // expressed in the AST, so IRGen needs to special-case it.
      $this().EmitLambdaToBlockPointerBody(Args);
    } else if (isa_CXXMethodDecl(FD)
       && cast_CXXMethodDecl(FD).isLambdaStaticInvoker()) {
      // The lambda static invoker function is special, because it forwards or
      // clones the body of the function call operator (but is actually static).
      $this().EmitLambdaStaticInvokeFunction(cast_CXXMethodDecl(FD));
    } else if (FD.isDefaulted() && isa_CXXMethodDecl(FD)
       && (cast_CXXMethodDecl(FD).isCopyAssignmentOperator()
       || cast_CXXMethodDecl(FD).isMoveAssignmentOperator())) {
      // Implicit copy-assignment gets the same special treatment as implicit
      // copy-constructors.
      $this().emitImplicitAssignmentOperatorBody(Args);
    } else {
      Stmt /*P*/ Body = FD.getBody();
      if ((Body != null)) {
        $this().EmitFunctionBody(Args, Body);
      } else {
        throw new llvm_unreachable("no definition for emitted function");
      }
    }
    
    // C++11 [stmt.return]p2:
    //   Flowing off the end of a function [...] results in undefined behavior in
    //   a value-returning function.
    // C11 6.9.1p12:
    //   If the '}' that terminates a function is reached, and the value of the
    //   function call is used by the caller, the behavior is undefined.
    if ($this().getLangOpts().CPlusPlus && !FD.hasImplicitReturnZero() && !$this().SawAsmBlock
       && !FD.getReturnType().$arrow().isVoidType() && ($this().Builder.GetInsertBlock() != null)) {
      if ($this().SanOpts.has(SanitizerKind.Return)) {
        SanitizerScope SanScope = null;
        try {
          SanScope/*J*/= new SanitizerScope($this());
          Value /*P*/ IsFalse = $this().Builder.getFalse();
          $this().EmitCheck(new ArrayRef<std.pairPtrULong<Value /*P*/ >>(std.make_pair_Ptr_ulong(IsFalse, SanitizerKind.Return), false), 
              new StringRef(/*KEEP_STR*/"missing_return"), new ArrayRef<Constant /*P*/ >($this().EmitCheckSourceLocation(FD.getLocation()), true), 
              new ArrayRef<Value /*P*/ >(None, true));
        } finally {
          if (SanScope != null) { SanScope.$destroy(); }
        }
      } else if ($2bits_uint2uint($this().CGM.getCodeGenOpts().OptimizationLevel) == 0) {
        $this().EmitTrapCall(ID.trap);
      }
      $this().Builder.CreateUnreachable();
      $this().Builder.ClearInsertionPoint();
    }
    
    // Emit the standard function epilogue.
    $this().FinishFunction(BodyRange.getEnd());
    
    // If we haven't marked the function nothrow through other means, do
    // a quick pass now to see if we can.
    if (!$this().CurFn.doesNotThrow()) {
      CodeGenFunctionStatics.TryMarkNoThrow($this().CurFn);
    }
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}

/// \brief Emit code for the start of a function.
/// \param Loc       The location to be associated with the function.
/// \param StartLoc  The location of the function body.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::StartFunction">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 653,
 FQN="clang::CodeGen::CodeGenFunction::StartFunction", NM="_ZN5clang7CodeGen15CodeGenFunction13StartFunctionENS_10GlobalDeclENS_8QualTypeEPN4llvm8FunctionERKNS0_14CGFunctionInfoERKNS0_15FunctionArgListENS_14SourceLocationESD_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13StartFunctionENS_10GlobalDeclENS_8QualTypeEPN4llvm8FunctionERKNS0_14CGFunctionInfoERKNS0_15FunctionArgListENS_14SourceLocationESD_")
//</editor-fold>
public final void StartFunction(GlobalDecl GD, 
             QualType RetTy, 
             Function /*P*/ Fn, 
             final /*const*/ CGFunctionInfo /*&*/ FnInfo, 
             final /*const*/ FunctionArgList /*&*/ Args) {
  StartFunction(GD, 
             RetTy, 
             Fn, 
             FnInfo, 
             Args, 
             new SourceLocation(), 
             new SourceLocation());
}
public final void StartFunction(GlobalDecl GD, 
             QualType RetTy, 
             Function /*P*/ Fn, 
             final /*const*/ CGFunctionInfo /*&*/ FnInfo, 
             final /*const*/ FunctionArgList /*&*/ Args, 
             SourceLocation Loc/*= SourceLocation()*/) {
  StartFunction(GD, 
             RetTy, 
             Fn, 
             FnInfo, 
             Args, 
             Loc, 
             new SourceLocation());
}
public final void StartFunction(GlobalDecl GD, 
             QualType RetTy, 
             Function /*P*/ Fn, 
             final /*const*/ CGFunctionInfo /*&*/ FnInfo, 
             final /*const*/ FunctionArgList /*&*/ Args, 
             SourceLocation Loc/*= SourceLocation()*/, 
             SourceLocation StartLoc/*= SourceLocation()*/) {
  assert (!($this().CurFn != null)) : "Do not use a CodeGenFunction object for more than one function";
  
  /*const*/ Decl /*P*/ D = GD.getDecl();
  
  $this().DidCallStackSave = false;
  $this().CurCodeDecl = D;
  {
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(D);
    if ((FD != null)) {
      if (FD.usesSEHTry()) {
        $this().CurSEHParent = FD;
      }
    }
  }
  $this().CurFuncDecl = ((D != null) ? D.getNonClosureContext$Const() : null);
  $this().FnRetTy.$assign(RetTy);
  $this().CurFn = Fn;
  $this().CurFnInfo = $AddrOf(FnInfo);
  assert ($this().CurFn.isDeclaration()) : "Function already has body?";
  if ($this().CGM.isInSanitizerBlacklist(Fn, new SourceLocation(Loc))) {
    $this().SanOpts.clear();
  }
  if ((D != null)) {
    // Apply the no_sanitize* attributes to SanOpts.
    for (NoSanitizeAttr /*P*/ Attr : D.specific_attrs(NoSanitizeAttr.class))  {
      $this().SanOpts.Mask &= ~Attr.getMask();
    }
  }
  
  // Apply sanitizer attributes to the function.
  if ($this().SanOpts.hasOneOf(SanitizerKind.Address | SanitizerKind.KernelAddress)) {
    Fn.addFnAttr(Attribute.AttrKind.SanitizeAddress);
  }
  if ($this().SanOpts.has(SanitizerKind.Thread)) {
    Fn.addFnAttr(Attribute.AttrKind.SanitizeThread);
  }
  if ($this().SanOpts.has(SanitizerKind.Memory)) {
    Fn.addFnAttr(Attribute.AttrKind.SanitizeMemory);
  }
  if ($this().SanOpts.has(SanitizerKind.SafeStack)) {
    Fn.addFnAttr(Attribute.AttrKind.SafeStack);
  }
  
  // Apply xray attributes to the function (as a string, for now)
  if ((D != null) && $this().ShouldXRayInstrumentFunction()) {
    {
      /*const*/ XRayInstrumentAttr /*P*/ XRayAttr = D.getAttr(XRayInstrumentAttr.class);
      if ((XRayAttr != null)) {
        if (XRayAttr.alwaysXRayInstrument()) {
          Fn.addFnAttr(new StringRef(/*KEEP_STR*/"function-instrument"), new StringRef(/*KEEP_STR*/"xray-always"));
        }
        if (XRayAttr.neverXRayInstrument()) {
          Fn.addFnAttr(new StringRef(/*KEEP_STR*/"function-instrument"), new StringRef(/*KEEP_STR*/"xray-never"));
        }
      } else {
        Fn.addFnAttr(new StringRef(/*KEEP_STR*/"xray-instruction-threshold"), 
            new StringRef(llvm.itostr($uint2long($this().CGM.getCodeGenOpts().XRayInstructionThreshold))));
      }
    }
  }
  {
    
    // Pass inline keyword to optimizer if it appears explicitly on any
    // declaration. Also, in the case of -fno-inline attach NoInline
    // attribute to all functions that are not marked AlwaysInline, or
    // to all functions that are not marked inline or implicitly inline
    // in the case of -finline-hint-functions.
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(D);
    if ((FD != null)) {
      final /*const*/ CodeGenOptions /*&*/ CodeGenOpts = $this().CGM.getCodeGenOpts();
      if (!CodeGenOpts.NoInline) {
        for (FunctionDecl /*P*/ RI : FD.redeclarable_redecls())  {
          if (RI.isInlineSpecified()) {
            Fn.addFnAttr(Attribute.AttrKind.InlineHint);
            break;
          }
        }
        if (CodeGenOpts.getInlining() == CodeGenOptions.InliningMethod.OnlyHintInlining
           && !FD.isInlined() && !Fn.hasFnAttribute(Attribute.AttrKind.InlineHint)) {
          Fn.addFnAttr(Attribute.AttrKind.NoInline);
        }
      } else if (!FD.hasAttr(AlwaysInlineAttr.class)) {
        Fn.addFnAttr(Attribute.AttrKind.NoInline);
      }
      if (($this().CGM.getLangOpts().OpenMP != 0) && FD.hasAttr(OMPDeclareSimdDeclAttr.class)) {
        $this().CGM.getOpenMPRuntime().emitDeclareSimdFunction(FD, Fn);
      }
    }
  }
  
  // Add no-jump-tables value.
  Fn.addFnAttr(new StringRef(/*KEEP_STR*/"no-jump-tables"), 
      llvm.toStringRef($this().CGM.getCodeGenOpts().NoUseJumpTables));
  if ($this().getLangOpts().OpenCL) {
    {
      // Add metadata for a kernel function.
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(D);
      if ((FD != null)) {
        $this().EmitOpenCLKernelMetadata(FD, Fn);
      }
    }
  }
  
  // If we are checking function types, emit a function type signature as
  // prologue data.
  if ($this().getLangOpts().CPlusPlus && $this().SanOpts.has(SanitizerKind.Function)) {
    {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(D);
      if ((FD != null)) {
        {
          Constant /*P*/ PrologueSig = $this().CGM.getTargetCodeGenInfo().getUBSanFunctionSignature($this().CGM);
          if ((PrologueSig != null)) {
            Constant /*P*/ FTRTTIConst = $this().CGM.GetAddrOfRTTIDescriptor(FD.getType(), /*ForEH=*/ true);
            Constant /*P*/ PrologueStructElems[/*2*/] = new Constant /*P*/  [/*2*/] {PrologueSig, FTRTTIConst};
            Constant /*P*/ PrologueStructConst = ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(PrologueStructElems, true), /*Packed=*/ true);
            Fn.setPrologueData(PrologueStructConst);
          }
        }
      }
    }
  }
  
  // If we're in C++ mode and the function name is "main", it is guaranteed
  // to be norecurse by the standard (3.6.1.3 "The function main shall not be
  // used within a program").
  if ($this().getLangOpts().CPlusPlus) {
    {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(D);
      if ((FD != null)) {
        if (FD.isMain()) {
          Fn.addFnAttr(Attribute.AttrKind.NoRecurse);
        }
      }
    }
  }
  
  BasicBlock /*P*/ EntryBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"entry"), $this().CurFn);
  
  // Create a marker to make it easy to insert allocas into the entryblock
  // later.  Don't create this with the builder, because we don't want it
  // folded.
  Value /*P*/ Undef = UndefValue.get(Int32Ty);
  $this().AllocaInsertPt.$assign_ValueTy(/*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new BitCastInst(Undef, Int32Ty, new Twine(/*KEEP_STR*/"allocapt"), EntryBB);
       }));
  
  $this().ReturnBlock.$assignMove($this().getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/$return)));
  
  $this().Builder.SetInsertPoint(EntryBB);
  {
    
    // Emit subprogram debug descriptor.
    CGDebugInfo /*P*/ DI = $this().getDebugInfo();
    if ((DI != null)) {
      // Reconstruct the type from the argument list so that implicit parameters,
      // such as 'this' and 'vtt', show up in the debug info. Preserve the calling
      // convention.
      org.clang.basic.CallingConv CC = org.clang.basic.CallingConv.CC_C;
      {
        /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(D);
        if ((FD != null)) {
          {
            /*const*/ org.clang.ast.FunctionType /*P*/ SrcFnTy = FD.getType().$arrow().getAs(org.clang.ast.FunctionType.class);
            if ((SrcFnTy != null)) {
              CC = SrcFnTy.getCallConv();
            }
          }
        }
      }
      SmallVector<QualType> ArgTypes/*J*/= new SmallVector<QualType>(16, new QualType());
      for (/*const*/ VarDecl /*P*/ VD : Args)  {
        ArgTypes.push_back(VD.getType());
      }
      QualType FnType = $this().getContext().getFunctionType(new QualType(RetTy), new ArrayRef<QualType>(ArgTypes, false), new FunctionProtoType.ExtProtoInfo(CC));
      DI.EmitFunctionStart(new GlobalDecl(GD), new SourceLocation(Loc), new SourceLocation(StartLoc), new QualType(FnType), $this().CurFn, $this().Builder);
    }
  }
  if ($this().ShouldInstrumentFunction()) {
    $this().EmitFunctionInstrumentation($("__cyg_profile_func_enter"));
  }
  if ($this().CGM.getCodeGenOpts().InstrumentForProfiling) {
    $this().EmitMCountInstrumentation();
  }
  if (RetTy.$arrow().isVoidType()) {
    // Void type; nothing to return.
    $this().ReturnValue.$assignMove(Address.invalid());
    
    // Count the implicit return.
    if (!CodeGenFunctionStatics.endsWithReturn(D)) {
      ++$this().NumReturnExprs;
    }
  } else if ($this().CurFnInfo.getReturnInfo$Const().getKind() == ABIArgInfo.Kind.Indirect
     && !CodeGenFunction.hasScalarEvaluationKind($this().CurFnInfo.getReturnType().$QualType())) {
    // Indirect aggregate return; emit returned value directly into sret slot.
    // This reduces code size, and affects correctness in C++.
    ilist_iterator<Argument> AI = $this().CurFn.arg_begin();
    if ($this().CurFnInfo.getReturnInfo$Const().isSRetAfterThis()) {
      AI.$preInc();
    }
    $this().ReturnValue.$assignMove(new Address($AddrOf(AI.$star()), $this().CurFnInfo.getReturnInfo$Const().getIndirectAlign()));
  } else if ($this().CurFnInfo.getReturnInfo$Const().getKind() == ABIArgInfo.Kind.InAlloca
     && !CodeGenFunction.hasScalarEvaluationKind($this().CurFnInfo.getReturnType().$QualType())) {
    // Load the sret pointer from the argument struct and return into that.
    /*uint*/int Idx = $this().CurFnInfo.getReturnInfo$Const().getInAllocaFieldIndex();
    ilist_iterator<Argument> EI = $this().CurFn.arg_end();
    EI.$preDec();
    Value /*P*/ Addr = $this().Builder.CreateStructGEP((org.llvm.ir.Type /*P*/ )null, $AddrOf(EI.$star()), Idx);
    Addr = $this().Builder.CreateAlignedLoad(Addr, /*J:ToBase*/super.getPointerAlign(), $("agg.result"));
    $this().ReturnValue.$assignMove(new Address(Addr, $this().getNaturalTypeAlignment(new QualType(RetTy))));
  } else {
    $this().ReturnValue.$assignMove($this().CreateIRTemp(new QualType(RetTy), new Twine(/*KEEP_STR*/"retval")));
    
    // Tell the epilog emitter to autorelease the result.  We do this
    // now so that various specialized functions can suppress it
    // during their IR-generation.
    if ($this().getLangOpts().ObjCAutoRefCount
       && !$this().CurFnInfo.isReturnsRetained()
       && RetTy.$arrow().isObjCRetainableType()) {
      $this().AutoreleaseResult = true;
    }
  }
  
  $this().EmitStartEHSpec($this().CurCodeDecl);
  
  $this().PrologueCleanupDepth.$assignMove($this().EHStack.stable_begin());
  $this().EmitFunctionProlog($Deref($this().CurFnInfo), $this().CurFn, Args);
  if ((D != null) && isa_CXXMethodDecl(D) && cast_CXXMethodDecl(D).isInstance()) {
    $this().CGM.getCXXABI().EmitInstanceFunctionProlog(/*Deref*/$this());
    /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(D);
    if (MD.getParent$Const().isLambda()
       && MD.getOverloadedOperator() == OverloadedOperatorKind.OO_Call) {
      // We're in a lambda; figure out the captures.
      MD.getParent$Const().getCaptureFields($this().LambdaCaptureFields, 
          $this().LambdaThisCaptureField_ref);
      if (($this().LambdaThisCaptureField != null)) {
        // If the lambda captures the object referred to by '*this' - either by
        // value or by reference, make sure CXXThisValue points to the correct
        // object.
        
        // Get the lvalue for the field (which is a copy of the enclosing object
        // or contains the address of the enclosing object).
        LValue ThisFieldLValue = $this().EmitLValueForLambdaField($this().LambdaThisCaptureField);
        if (!$this().LambdaThisCaptureField.getType().$arrow().isPointerType()) {
          // If the enclosing object was captured by value, just use its address.
          $this().CXXThisValue = ThisFieldLValue.getAddress().getPointer();
        } else {
          // Load the lvalue pointed to by the field, since '*this' was captured
          // by reference.
          $this().CXXThisValue
             = $this().EmitLoadOfLValue(new LValue(ThisFieldLValue), new SourceLocation()).getScalarVal();
        }
      }
      for (FieldDecl /*P*/ FD : MD.getParent$Const().fields()) {
        if (FD.hasCapturedVLAType()) {
          Value /*P*/ ExprArg = $this().EmitLoadOfLValue($this().EmitLValueForLambdaField(FD), 
              new SourceLocation()).getScalarVal();
          /*const*/ VariableArrayType /*P*/ VAT = FD.getCapturedVLAType();
          $this().VLASizeMap.$set(VAT.getSizeExpr(), ExprArg);
        }
      }
    } else {
      // Not in a lambda; just use 'this' from the method.
      // FIXME: Should we generate a new load for each use of 'this'?  The
      // fast register allocator would be happier...
      $this().CXXThisValue = $this().CXXABIThisValue;
    }
  }
  
  // If any of the arguments have a variably modified type, make sure to
  // emit the type size.
  for (type$ptr</*const*/ VarDecl /*P*/ /*const*/ /*P*/> i = $tryClone(Args.begin$Const()), /*P*/ e = $tryClone(Args.end$Const());
       $noteq_ptr(i, e); i.$preInc()) {
    /*const*/ VarDecl /*P*/ VD = i.$star();
    
    // Dig out the type as written from ParmVarDecls; it's unclear whether
    // the standard (C99 6.9.1p10) requires this, but we're following the
    // precedent set by gcc.
    QualType Ty/*J*/= new QualType();
    {
      /*const*/ ParmVarDecl /*P*/ PVD = dyn_cast_ParmVarDecl(VD);
      if ((PVD != null)) {
        Ty.$assignMove(PVD.getOriginalType());
      } else {
        Ty.$assignMove(VD.getType());
      }
    }
    if (Ty.$arrow().isVariablyModifiedType()) {
      $this().EmitVariablyModifiedType(new QualType(Ty));
    }
  }
  {
    // Emit a location at the end of the prologue.
    CGDebugInfo /*P*/ DI = $this().getDebugInfo();
    if ((DI != null)) {
      DI.EmitLocation($this().Builder, new SourceLocation(StartLoc));
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitFunctionBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 906,
 FQN="clang::CodeGen::CodeGenFunction::EmitFunctionBody", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitFunctionBodyERNS0_15FunctionArgListEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitFunctionBodyERNS0_15FunctionArgListEPKNS_4StmtE")
//</editor-fold>
public final void EmitFunctionBody(final FunctionArgList /*&*/ Args, 
                /*const*/ Stmt /*P*/ Body) {
  $this().incrementProfileCounter(Body);
  {
    /*const*/ CompoundStmt /*P*/ S = dyn_cast_CompoundStmt(Body);
    if ((S != null)) {
      $this().EmitCompoundStmtWithoutScope($Deref(S));
    } else {
      $this().EmitStmt(Body);
    }
  }
}


/// When instrumenting to collect profile data, the counts for some blocks
/// such as switch cases need to not include the fall-through counts, so
/// emit a branch around the instrumentation code. When not instrumenting,
/// this just calls EmitBlock().
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitBlockWithFallThrough">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 919,
 FQN="clang::CodeGen::CodeGenFunction::EmitBlockWithFallThrough", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitBlockWithFallThroughEPN4llvm10BasicBlockEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitBlockWithFallThroughEPN4llvm10BasicBlockEPKNS_4StmtE")
//</editor-fold>
public final void EmitBlockWithFallThrough(BasicBlock /*P*/ BB, 
                        /*const*/ Stmt /*P*/ S) {
  BasicBlock /*P*/ SkipCountBB = null;
  if ($this().HaveInsertPoint() && $this().CGM.getCodeGenOpts().hasProfileClangInstr()) {
    // When instrumenting for profiling, the fallthrough to certain
    // statements needs to skip over the instrumentation code so that we
    // get an accurate count.
    SkipCountBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"skipcount"));
    $this().EmitBranch(SkipCountBB);
  }
  $this().EmitBlock(BB);
  long/*uint64_t*/ CurrentCount = $this().getCurrentProfileCount();
  $this().incrementProfileCounter(S);
  $this().setCurrentProfileCount($this().getCurrentProfileCount() + CurrentCount);
  if ((SkipCountBB != null)) {
    $this().EmitBlock(SkipCountBB);
  }
}


/// \brief Emit the unified return block, trying to avoid its emission when
/// possible.
/// \return The debug location of the user written return statement if the
/// return block is is avoided.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitReturnBlock">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 223,
 FQN="clang::CodeGen::CodeGenFunction::EmitReturnBlock", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitReturnBlockEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitReturnBlockEv")
//</editor-fold>
public final DebugLoc EmitReturnBlock() {
  // For cleanliness, we try to avoid emitting the return block for
  // simple cases.
  BasicBlock /*P*/ CurBB = $this().Builder.GetInsertBlock();
  if ((CurBB != null)) {
    assert (!(CurBB.getTerminator() != null)) : "Unexpected terminated block.";
    
    // We have a valid insert point, reuse it if it is empty or there are no
    // explicit jumps to the return block.
    if (CurBB.empty() || $this().ReturnBlock.getBlock().use_empty()) {
      $this().ReturnBlock.getBlock().replaceAllUsesWith(CurBB);
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)$this().ReturnBlock.getBlock());
    } else {
      $this().EmitBlock($this().ReturnBlock.getBlock());
    }
    return new DebugLoc();
  }
  
  // Otherwise, if the return block is the target of a single direct
  // branch then we can just put the code in that block instead. This
  // cleans up functions which started with a unified return block.
  if ($this().ReturnBlock.getBlock().hasOneUse()) {
    BranchInst /*P*/ BI = IrRTTI.dyn_cast_BranchInst($this().ReturnBlock.getBlock().user_begin().$star());
    if ((BI != null) && BI.isUnconditional()
       && BI.getSuccessor(0) == $this().ReturnBlock.getBlock()) {
      DebugLoc Loc = null;
      try {
        // Record/return the DebugLoc of the simple 'return' expression to be used
        // later by the actual 'ret' instruction.
        Loc = new DebugLoc(BI.getDebugLoc());
        $this().Builder.SetInsertPoint(BI.getParent());
        BI.eraseFromParent();
        /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)$this().ReturnBlock.getBlock());
        return new DebugLoc(JD$Move.INSTANCE, Loc);
      } finally {
        if (Loc != null) { Loc.$destroy(); }
      }
    }
  }
  
  // FIXME: We are at an unreachable point, there is no reason to emit the block
  // unless it has uses. However, we still need a place to put the debug
  // region.end for now.
  $this().EmitBlock($this().ReturnBlock.getBlock());
  return new DebugLoc();
}


/// FinishFunction - Complete IR generation of the current function. It is
/// legal to call this function even if there is no current insertion point.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::FinishFunction">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 274,
 FQN="clang::CodeGen::CodeGenFunction::FinishFunction", NM="_ZN5clang7CodeGen15CodeGenFunction14FinishFunctionENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14FinishFunctionENS_14SourceLocationE")
//</editor-fold>
public final void FinishFunction() {
  FinishFunction(new SourceLocation());
}
public final void FinishFunction(SourceLocation EndLoc/*= SourceLocation()*/) {
  DebugLoc Loc = null;
  ApplyDebugLocation AL = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert ($this().BreakContinueStack.empty()) : "mismatched push/pop in break/continue stack!";
    
    boolean OnlySimpleReturnStmts = $greater_uint($this().NumSimpleReturnExprs, 0)
       && $this().NumSimpleReturnExprs == $this().NumReturnExprs
       && $this().ReturnBlock.getBlock().use_empty();
    {
      // Usually the return expression is evaluated before the cleanup
      // code.  If the function contains only a simple return statement,
      // such as a constant, the location before the cleanup code becomes
      // the last useful breakpoint in the function, because the simple
      // return expression will be evaluated after the cleanup code. To be
      // safe, set the debug location for cleanup code to the location of
      // the return statement.  Otherwise the cleanup code should be at the
      // end of the function's lexical scope.
      //
      // If there are multiple branches to the return block, the branch
      // instructions will get the location of the return statements and
      // all will be fine.
      CGDebugInfo /*P*/ DI = $this().getDebugInfo();
      if ((DI != null)) {
        if (OnlySimpleReturnStmts) {
          DI.EmitLocation($this().Builder, new SourceLocation($this().LastStopPoint));
        } else {
          DI.EmitLocation($this().Builder, new SourceLocation(EndLoc));
        }
      }
    }
    
    // Pop any cleanups that might have been associated with the
    // parameters.  Do this in whatever block we're currently in; it's
    // important to do this before we enter the return block or return
    // edges will be *really* confused.
    boolean HasCleanups = stable_iterator.$noteq_stable_iterator($this().EHStack.stable_begin(), /*NO_COPY*/$this().PrologueCleanupDepth);
    boolean HasOnlyLifetimeMarkers = HasCleanups && $this().EHStack.containsOnlyLifetimeMarkers(new EHScopeStack.stable_iterator($this().PrologueCleanupDepth));
    boolean EmitRetDbgLoc = !HasCleanups || HasOnlyLifetimeMarkers;
    if (HasCleanups) {
      {
        // Make sure the line table doesn't jump back into the body for
        // the ret after it's been at EndLoc.
        CGDebugInfo /*P*/ DI = $this().getDebugInfo();
        if ((DI != null)) {
          if (OnlySimpleReturnStmts) {
            DI.EmitLocation($this().Builder, new SourceLocation(EndLoc));
          }
        }
      }
      
      $this().PopCleanupBlocks(new EHScopeStack.stable_iterator($this().PrologueCleanupDepth));
    }
    
    // Emit function epilog (to return).
    Loc = $this().EmitReturnBlock();
    if ($this().ShouldInstrumentFunction()) {
      $this().EmitFunctionInstrumentation($("__cyg_profile_func_exit"));
    }
    {
      
      // Emit debug descriptor for function end.
      CGDebugInfo /*P*/ DI = $this().getDebugInfo();
      if ((DI != null)) {
        DI.EmitFunctionEnd($this().Builder);
      }
    }
    
    // Reset the debug location to that of the simple 'return' expression, if any
    // rather than that of the end of the function's scope '}'.
    AL/*J*/= $c$.clean(new ApplyDebugLocation(/*Deref*/$this(), $c$.track(new DebugLoc(Loc))));
    $this().EmitFunctionEpilog($Deref($this().CurFnInfo), EmitRetDbgLoc, new SourceLocation(EndLoc));
    $this().EmitEndEHSpec($this().CurCodeDecl);
    assert ($this().EHStack.empty()) : "did not remove all scopes from cleanup stack!";
    
    // If someone did an indirect goto, emit the indirect goto block at the end of
    // the function.
    if (($this().IndirectBranch != null)) {
      $this().EmitBlock($this().IndirectBranch.getParent());
      $this().Builder.ClearInsertionPoint();
    }
    
    // If some of our locals escaped, insert a call to llvm.localescape in the
    // entry block.
    if (!$this().EscapedLocals.empty()) {
      // Invert the map from local to index into a simple vector. There should be
      // no holes.
      SmallVector<Value /*P*/ > EscapeArgs/*J*/= new SmallVector<Value /*P*/ >(4, (Value /*P*/ )null);
      EscapeArgs.resize($this().EscapedLocals.size());
      for (final pairTypeInt<AllocaInst /*P*/> /*&*/ Pair : $this().EscapedLocals)  {
        EscapeArgs.$set(Pair.second, Pair.first);
      }
      Function /*P*/ FrameEscapeFn = getDeclaration($AddrOf($this().CGM.getModule()), ID.localescape);
      $c$.clean($c$.track(new CGBuilderTy(/*Deref*/$this(), $this().AllocaInsertPt.$T$P())).CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(FrameEscapeFn, new ArrayRef<Value /*P*/ >(EscapeArgs, true)));
    }
    
    // Remove the AllocaInsertPt instruction, which is just a convenience for us.
    Instruction /*P*/ Ptr = $this().AllocaInsertPt.$T$P();
    $this().AllocaInsertPt.$assign_ValueTy((Instruction /*P*/ )null);
    Ptr.eraseFromParent();
    
    // If someone took the address of a label but never did an indirect goto, we
    // made a zero entry PHI node, which is illegal, zap it now.
    if (($this().IndirectBranch != null)) {
      PHINode /*P*/ PN = IrRTTI.cast_PHINode($this().IndirectBranch.getAddress());
      if (PN.getNumIncomingValues() == 0) {
        PN.replaceAllUsesWith(UndefValue.get(PN.getType()));
        PN.eraseFromParent();
      }
    }
    
    CodeGenFunctionStatics.EmitIfUsed(/*Deref*/$this(), $this().EHResumeBlock);
    CodeGenFunctionStatics.EmitIfUsed(/*Deref*/$this(), $this().TerminateLandingPad);
    CodeGenFunctionStatics.EmitIfUsed(/*Deref*/$this(), $this().TerminateHandler);
    CodeGenFunctionStatics.EmitIfUsed(/*Deref*/$this(), $this().UnreachableBlock);
    if ($this().CGM.getCodeGenOpts().EmitDeclMetadata) {
      $this().EmitDeclMetadata();
    }
    
    for (type$ptr<std.pair<Instruction /*P*/ , Value /*P*/ >> I = $tryClone($this().DeferredReplacements.begin()), 
        /*P*/ E = $tryClone($this().DeferredReplacements.end());
         $noteq_ptr(I, E); I.$preInc()) {
      I./*->*/$star().first.replaceAllUsesWith(I./*->*/$star().second);
      I./*->*/$star().first.eraseFromParent();
    }
  } finally {
    if (AL != null) { AL.$destroy(); }
    if (Loc != null) { Loc.$destroy(); }
    $c$.$destroy();
  }
}


/// ShouldInstrumentFunction - Return true if the current function should be
/// instrumented with __cyg_profile_func_* calls

/// ShouldInstrumentFunction - Return true if the current function should be
/// instrumented with __cyg_profile_func_* calls
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ShouldInstrumentFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 392,
 FQN="clang::CodeGen::CodeGenFunction::ShouldInstrumentFunction", NM="_ZN5clang7CodeGen15CodeGenFunction24ShouldInstrumentFunctionEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24ShouldInstrumentFunctionEv")
//</editor-fold>
public final boolean ShouldInstrumentFunction() {
  if (!$this().CGM.getCodeGenOpts().InstrumentFunctions) {
    return false;
  }
  if (!($this().CurFuncDecl != null) || $this().CurFuncDecl.hasAttr(NoInstrumentFunctionAttr.class)) {
    return false;
  }
  return true;
}


/// ShouldXRayInstrument - Return true if the current function should be
/// instrumented with XRay nop sleds.

/// ShouldXRayInstrument - Return true if the current function should be
/// instrumented with XRay nop sleds.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ShouldXRayInstrumentFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 402,
 FQN="clang::CodeGen::CodeGenFunction::ShouldXRayInstrumentFunction", NM="_ZNK5clang7CodeGen15CodeGenFunction28ShouldXRayInstrumentFunctionEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction28ShouldXRayInstrumentFunctionEv")
//</editor-fold>
public final boolean ShouldXRayInstrumentFunction() /*const*/ {
  return $this().CGM.getCodeGenOpts().XRayInstrumentFunctions;
}


/// EmitFunctionInstrumentation - Emit LLVM code to call the specified
/// instrumentation function with the current function and the call site, if
/// function instrumentation is enabled.

/// EmitFunctionInstrumentation - Emit LLVM code to call the specified
/// instrumentation function with the current function and the call site, if
/// function instrumentation is enabled.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitFunctionInstrumentation">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 409,
 FQN="clang::CodeGen::CodeGenFunction::EmitFunctionInstrumentation", NM="_ZN5clang7CodeGen15CodeGenFunction27EmitFunctionInstrumentationEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction27EmitFunctionInstrumentationEPKc")
//</editor-fold>
public final void EmitFunctionInstrumentation(/*const*/char$ptr/*char P*/ Fn) {
  ApplyDebugLocation NL = null;
  try {
    NL = ApplyDebugLocation.CreateArtificial(/*Deref*/$this());
    // void __cyg_profile_func_{enter,exit} (void *this_fn, void *call_site);
    org.llvm.ir.PointerType /*P*/ PointerTy = Unnamed_field9.Int8PtrTy;
    org.llvm.ir.Type /*P*/ ProfileFuncArgs[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {PointerTy, PointerTy};
    org.llvm.ir.FunctionType /*P*/ FunctionTy = org.llvm.ir.FunctionType.get(VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(ProfileFuncArgs, true), false);
    
    Constant /*P*/ F = $this().CGM.CreateRuntimeFunction(FunctionTy, new StringRef(Fn));
    CallInst /*P*/ CallSite = $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID.returnaddress), 
        new ArrayRef<Value /*P*/ >(ConstantInt.get(Int32Ty, $int2ulong(0)), true), 
        new Twine(/*KEEP_STR*/"callsite"));
    
    Value /*P*/ args[/*2*/] = new Value /*P*/  [/*2*/] {
      ConstantExpr.getBitCast($this().CurFn, PointerTy), 
      CallSite
    };
    
    $this().EmitNounwindRuntimeCall(F, new ArrayRef<Value /*P*/ >(args, true));
  } finally {
    if (NL != null) { NL.$destroy(); }
  }
}


/// EmitMCountInstrumentation - Emit call to .mcount.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitMCountInstrumentation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 431,
 FQN="clang::CodeGen::CodeGenFunction::EmitMCountInstrumentation", NM="_ZN5clang7CodeGen15CodeGenFunction25EmitMCountInstrumentationEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25EmitMCountInstrumentationEv")
//</editor-fold>
public final void EmitMCountInstrumentation() {
  org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(VoidTy, false);
  
  Constant /*P*/ MCountFn = $this().CGM.CreateRuntimeFunction(FTy, new StringRef($this().getTarget().getMCountName()));
  $this().EmitNounwindRuntimeCall(MCountFn);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ConvertTypeForMem">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 162,
 FQN="clang::CodeGen::CodeGenFunction::ConvertTypeForMem", NM="_ZN5clang7CodeGen15CodeGenFunction17ConvertTypeForMemENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17ConvertTypeForMemENS_8QualTypeE")
//</editor-fold>
public final org.llvm.ir.Type /*P*/ ConvertTypeForMem(QualType T) {
  return $this().CGM.getTypes().ConvertTypeForMem(new QualType(T));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ConvertType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 166,
 FQN="clang::CodeGen::CodeGenFunction::ConvertType", NM="_ZN5clang7CodeGen15CodeGenFunction11ConvertTypeENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11ConvertTypeENS_8QualTypeE")
//</editor-fold>
public final org.llvm.ir.Type /*P*/ ConvertType(QualType T) {
  return $this().CGM.getTypes().ConvertType(new QualType(T));
}


/// hasAggregateLLVMType - Return true if the specified AST type will map into
/// an aggregate LLVM type or is void.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getEvaluationKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 170,
 FQN="clang::CodeGen::CodeGenFunction::getEvaluationKind", NM="_ZN5clang7CodeGen15CodeGenFunction17getEvaluationKindENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17getEvaluationKindENS_8QualTypeE")
//</editor-fold>
public static TypeEvaluationKind getEvaluationKind(QualType type) {
  type.$assignMove(type.getCanonicalType());
  while (true) {
    switch (type.$arrow().getTypeClass()) {
     case DependentSizedArray:
     case DependentSizedExtVector:
     case UnresolvedUsing:
     case Paren:
     case Typedef:
     case Adjusted:
     case Decayed:
     case TypeOfExpr:
     case TypeOf:
     case Decltype:
     case UnaryTransform:
     case Elaborated:
     case Attributed:
     case TemplateTypeParm:
     case SubstTemplateTypeParm:
     case SubstTemplateTypeParmPack:
     case TemplateSpecialization:
     case InjectedClassName:
     case DependentName:
     case DependentTemplateSpecialization:
     case PackExpansion:
      throw new llvm_unreachable("non-canonical or dependent type in IR-generation");
     case Auto:
      throw new llvm_unreachable("undeduced auto type in IR-generation");
     case Builtin:
     case Pointer:
     case BlockPointer:
     case LValueReference:
     case RValueReference:
     case MemberPointer:
     case Vector:
     case ExtVector:
     case FunctionProto:
     case FunctionNoProto:
     case Enum:
     case ObjCObjectPointer:
     case Pipe:
      
      // Various scalar types.
      return TypeEvaluationKind.TEK_Scalar;
     case Complex:
      
      // Complexes.
      return TypeEvaluationKind.TEK_Complex;
     case ConstantArray:
     case IncompleteArray:
     case VariableArray:
     case Record:
     case ObjCObject:
     case ObjCInterface:
      
      // Arrays, records, and Objective-C objects.
      return TypeEvaluationKind.TEK_Aggregate;
     case Atomic:
      
      // We operate on atomic values according to their underlying type.
      type.$assignMove(cast_AtomicType(type).getValueType());
      continue;
    }
    throw new llvm_unreachable("unknown type kind!");
  }
}


/// ErrorUnsupported - Print out an error that codegen doesn't support the
/// specified stmt yet.

/// ErrorUnsupported - Print out an error that codegen doesn't support the
/// specified stmt yet.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ErrorUnsupported">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1383,
 FQN="clang::CodeGen::CodeGenFunction::ErrorUnsupported", NM="_ZN5clang7CodeGen15CodeGenFunction16ErrorUnsupportedEPKNS_4StmtEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16ErrorUnsupportedEPKNS_4StmtEPKc")
//</editor-fold>
public final void ErrorUnsupported(/*const*/ Stmt /*P*/ S, /*const*/char$ptr/*char P*/ Type) {
  $this().CGM.ErrorUnsupported(S, Type);
}


/// Given a value of type T* that may not be to a complete object,
/// construct an l-value with the natural pointee alignment of T.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::MakeNaturalAlignPointeeAddrLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 154,
 FQN="clang::CodeGen::CodeGenFunction::MakeNaturalAlignPointeeAddrLValue", NM="_ZN5clang7CodeGen15CodeGenFunction33MakeNaturalAlignPointeeAddrLValueEPN4llvm5ValueENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction33MakeNaturalAlignPointeeAddrLValueEPN4llvm5ValueENS_8QualTypeE")
//</editor-fold>
public final LValue MakeNaturalAlignPointeeAddrLValue(Value /*P*/ V, QualType T) {
  type$ptr<AlignmentSource> AlignSource = create_type$null$ptr();
  CharUnits Align = $this().getNaturalTypeAlignment(new QualType(T), $AddrOf(AlignSource), /*pointee*/ true);
  return $this().MakeAddrLValue(new Address(V, new CharUnits(Align)), new QualType(T), AlignSource.$star());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::MakeNaturalAlignAddrLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 145,
 FQN="clang::CodeGen::CodeGenFunction::MakeNaturalAlignAddrLValue", NM="_ZN5clang7CodeGen15CodeGenFunction26MakeNaturalAlignAddrLValueEPN4llvm5ValueENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26MakeNaturalAlignAddrLValueEPN4llvm5ValueENS_8QualTypeE")
//</editor-fold>
public final LValue MakeNaturalAlignAddrLValue(Value /*P*/ V, QualType T) {
  type$ptr<AlignmentSource> AlignSource = create_type$null$ptr();
  CharUnits Alignment = $this().getNaturalTypeAlignment(new QualType(T), $AddrOf(AlignSource));
  return LValue.MakeAddr(new Address(V, new CharUnits(Alignment)), new QualType(T), $this().getContext(), AlignSource.$star(), 
      $this().CGM.getTBAAInfo(new QualType(T)));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getNaturalTypeAlignment">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 105,
 FQN="clang::CodeGen::CodeGenFunction::getNaturalTypeAlignment", NM="_ZN5clang7CodeGen15CodeGenFunction23getNaturalTypeAlignmentENS_8QualTypeEPNS0_15AlignmentSourceEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23getNaturalTypeAlignmentENS_8QualTypeEPNS0_15AlignmentSourceEb")
//</editor-fold>
public final CharUnits getNaturalTypeAlignment(QualType T) {
  return getNaturalTypeAlignment(T, 
                       create_type$null$ptr(), 
                       false);
}
public final CharUnits getNaturalTypeAlignment(QualType T, 
                       type$ptr<AlignmentSource /*P*/> Source/*= null*/) {
  return getNaturalTypeAlignment(T, 
                       Source, 
                       false);
}
public final CharUnits getNaturalTypeAlignment(QualType T, 
                       type$ptr<AlignmentSource /*P*/> Source/*= null*/, 
                       boolean forPointeeType/*= false*/) {
  {
    // Honor alignment typedef attributes even on incomplete types.
    // We also honor them straight for C++ class types, even as pointees;
    // there's an expressivity gap here.
    /*const*/ TypedefType /*P*/ TT = T.$arrow().getAs$TypedefType();
    if ((TT != null)) {
      {
        /*uint*/int Align = TT.getDecl().getMaxAlignment();
        if ((Align != 0)) {
          if ((Source != null)) {
            Source.$set(AlignmentSource.AttributedType);
          }
          return $this().getContext().toCharUnitsFromBits($uint2long(Align));
        }
      }
    }
  }
  if ((Source != null)) {
    Source.$set(AlignmentSource.Type);
  }
  
  CharUnits Alignment/*J*/= new CharUnits();
  if (T.$arrow().isIncompleteType()) {
    Alignment.$assignMove(CharUnits.One()); // Shouldn't be used, but pessimistic is best.
  } else {
    // For C++ class pointees, we don't know whether we're pointing at a
    // base or a complete object, so we generally need to use the
    // non-virtual alignment.
    /*const*/ CXXRecordDecl /*P*/ RD;
    if (forPointeeType && ((RD = T.$arrow().getAsCXXRecordDecl()) != null)) {
      Alignment.$assignMove($this().CGM.getClassPointerAlignment(RD));
    } else {
      Alignment.$assignMove($this().getContext().getTypeAlignInChars(new QualType(T)));
    }
    {
      
      // Cap to the global maximum type alignment unless the alignment
      // was somehow explicit on the type.
      /*uint*/int MaxAlign = $this().getLangOpts().MaxTypeAlign;
      if ((MaxAlign != 0)) {
        if (Alignment.getQuantity() > $uint2llong(MaxAlign)
           && !$this().getContext().isAlignmentRequired(new QualType(T))) {
          Alignment.$assignMove(CharUnits.fromQuantity($uint2long(MaxAlign)));
        }
      }
    }
  }
  return Alignment;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getNaturalPointeeTypeAlignment">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 99,
 FQN="clang::CodeGen::CodeGenFunction::getNaturalPointeeTypeAlignment", NM="_ZN5clang7CodeGen15CodeGenFunction30getNaturalPointeeTypeAlignmentENS_8QualTypeEPNS0_15AlignmentSourceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction30getNaturalPointeeTypeAlignmentENS_8QualTypeEPNS0_15AlignmentSourceE")
//</editor-fold>
public final CharUnits getNaturalPointeeTypeAlignment(QualType T) {
  return getNaturalPointeeTypeAlignment(T, 
                              create_type$null$ptr());
}
public final CharUnits getNaturalPointeeTypeAlignment(QualType T, 
                              type$ptr<AlignmentSource /*P*/> Source/*= null*/) {
  return $this().getNaturalTypeAlignment(T.$arrow().getPointeeType(), Source, 
      /*forPointee*/ true);
}


// EmitVAListRef - Emit a "reference" to a va_list; this is either the address
// or the value of the expression, depending on how va_list is defined.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitVAListRef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1807,
 FQN="clang::CodeGen::CodeGenFunction::EmitVAListRef", NM="_ZN5clang7CodeGen15CodeGenFunction13EmitVAListRefEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13EmitVAListRefEPKNS_4ExprE")
//</editor-fold>
public final Address EmitVAListRef(/*const*/ Expr /*P*/ E) {
  if ($this().getContext().getBuiltinVaListType().$arrow().isArrayType()) {
    return $this().EmitPointerWithAlignment(E);
  }
  return $this().EmitLValue(E).getAddress();
}


/// Emit a "reference" to a __builtin_ms_va_list; this is
/// always the value of the expression, because a __builtin_ms_va_list is a
/// pointer to a char.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitMSVAListRef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1813,
 FQN="clang::CodeGen::CodeGenFunction::EmitMSVAListRef", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitMSVAListRefEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitMSVAListRefEPKNS_4ExprE")
//</editor-fold>
public final Address EmitMSVAListRef(/*const*/ Expr /*P*/ E) {
  return $this().EmitLValue(E).getAddress();
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GetAddrOfLabel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1514,
 FQN="clang::CodeGen::CodeGenFunction::GetAddrOfLabel", NM="_ZN5clang7CodeGen15CodeGenFunction14GetAddrOfLabelEPKNS_9LabelDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14GetAddrOfLabelEPKNS_9LabelDeclE")
//</editor-fold>
public final BlockAddress /*P*/ GetAddrOfLabel(/*const*/ LabelDecl /*P*/ L) {
  // Make sure that there is a block for the indirect goto.
  if (!($this().IndirectBranch != null)) {
    $this().GetIndirectGotoBlock();
  }
  
  BasicBlock /*P*/ BB = $this().getJumpDestForLabel(L).getBlock();
  
  // Make sure the indirect branch includes all of the address-taken blocks.
  $this().IndirectBranch.addDestination(BB);
  return BlockAddress.get($this().CurFn, BB);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GetIndirectGotoBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1526,
 FQN="clang::CodeGen::CodeGenFunction::GetIndirectGotoBlock", NM="_ZN5clang7CodeGen15CodeGenFunction20GetIndirectGotoBlockEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20GetIndirectGotoBlockEv")
//</editor-fold>
public final BasicBlock /*P*/ GetIndirectGotoBlock() {
  CGBuilderTy TmpBuilder = null;
  try {
    // If we already made the indirect branch for indirect goto, return its block.
    if (($this().IndirectBranch != null)) {
      return $this().IndirectBranch.getParent();
    }
    
    TmpBuilder/*J*/= new CGBuilderTy(/*Deref*/$this(), $this().createBasicBlock(new Twine(/*KEEP_STR*/"indirectgoto")));
    
    // Create the PHI node that indirect gotos will add entries to.
    Value /*P*/ DestVal = TmpBuilder.CreatePHI(Unnamed_field9.Int8PtrTy, 0, 
        new Twine(/*KEEP_STR*/"indirect.goto.dest"));
    
    // Create the indirect branch instruction.
    $this().IndirectBranch = TmpBuilder.CreateIndirectBr(DestVal);
    return $this().IndirectBranch.getParent();
  } finally {
    if (TmpBuilder != null) { TmpBuilder.$destroy(); }
  }
}


/// EmitNullInitialization - Generate code to set a value of the given type to
/// null, If the type contains data member pointers, they will be initialized
/// to -1 in accordance with the Itanium C++ ABI.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitNullInitialization">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1438,
 FQN="clang::CodeGen::CodeGenFunction::EmitNullInitialization", NM="_ZN5clang7CodeGen15CodeGenFunction22EmitNullInitializationENS0_7AddressENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22EmitNullInitializationENS0_7AddressENS_8QualTypeE")
//</editor-fold>
public final void EmitNullInitialization(Address DestPtr, QualType Ty) {
  // Ignore empty classes in C++.
  if ($this().getLangOpts().CPlusPlus) {
    {
      /*const*/ RecordType /*P*/ RT = Ty.$arrow().getAs$RecordType();
      if ((RT != null)) {
        if (cast_CXXRecordDecl(RT.getDecl()).isEmpty()) {
          return;
        }
      }
    }
  }
  
  // Cast the dest ptr to the appropriate i8 pointer type.
  if (DestPtr.getElementType() != Int8Ty) {
    DestPtr.$assignMove($this().Builder.CreateElementBitCast(new Address(DestPtr), Int8Ty));
  }
  
  // Get size and alignment info for this aggregate.
  CharUnits size = $this().getContext().getTypeSizeInChars(/*NO_COPY*/Ty);
  
  Value /*P*/ SizeVal;
  /*const*/ VariableArrayType /*P*/ vla;
  
  // Don't bother emitting a zero-byte memset.
  if (size.isZero()) {
    {
      // But note that getTypeInfo returns 0 for a VLA.
      /*const*/ VariableArrayType /*P*/ vlaType = dyn_cast_or_null_VariableArrayType($this().getContext().getAsArrayType(new QualType(Ty)));
      if ((vlaType != null)) {
        //std.tie(numElts, eltType).$assign($this().getVLASize(vlaType));
        pair<Value, QualType> tmp = $this().getVLASize(vlaType);
        QualType eltType/*J*/= tmp.second;
        Value /*P*/ numElts = tmp.first;
        
        SizeVal = numElts;
        CharUnits eltSize = $this().getContext().getTypeSizeInChars(/*NO_COPY*/eltType);
        if (!eltSize.isOne()) {
          SizeVal = $this().Builder.CreateNUWMul(SizeVal, $this().CGM.getSize(new CharUnits(eltSize)));
        }
        vla = vlaType;
      } else {
        return;
      }
    }
  } else {
    SizeVal = $this().CGM.getSize(new CharUnits(size));
    vla = null;
  }
  
  // If the type contains a pointer to data member we can't memset it to zero.
  // Instead, create a null constant and copy it to the destination.
  // TODO: there are other patterns besides zero that we can usefully memset,
  // like -1, which happens to be the pattern used by member-pointers.
  if (!$this().CGM.getTypes().isZeroInitializable(new QualType(Ty))) {
    // For a VLA, emit a single element, then splat that over the VLA.
    if ((vla != null)) {
      Ty.$assignMove($this().getContext().getBaseElementType(vla));
    }
    
    Constant /*P*/ NullConstant = $this().CGM.EmitNullConstant(new QualType(Ty));
    
    GlobalVariable /*P*/ NullVariable = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable($this().CGM.getModule(), NullConstant.getType(), 
                /*isConstant=*/ true, 
                GlobalVariable.LinkageTypes.PrivateLinkage, 
                NullConstant, new Twine());
     });
    CharUnits NullAlign = DestPtr.getAlignment();
    NullVariable.setAlignment($long2uint(NullAlign.getQuantity()));
    Address SrcPtr/*J*/= new Address($this().Builder.CreateBitCast(NullVariable, $this().Builder.getInt8PtrTy()), 
        new CharUnits(NullAlign));
    if ((vla != null)) {
      CodeGenFunctionStatics.emitNonZeroVLAInit(/*Deref*/$this(), new QualType(Ty), new Address(DestPtr), new Address(SrcPtr), SizeVal);
      /*JAVA:return*/return;
    }
    
    // Get and call the appropriate llvm.memcpy overload.
    $this().Builder.CreateMemCpy(new Address(DestPtr), new Address(SrcPtr), SizeVal, false);
    return;
  }
  
  // Otherwise, just memset the whole thing to zero.  This is legal
  // because in LLVM, all default initializers (other than the ones we just
  // handled above) are guaranteed to have a bit pattern of all zeros.
  $this().Builder.CreateMemSet(new Address(DestPtr), $this().Builder.getInt8($int2uchar(0)), SizeVal, false);
}


/// emitArrayLength - Compute the length of an array, even if it's a
/// VLA, and drill down to the base element type.

/// Computes the length of an array in elements, as well as the base
/// element type and a properly-typed first element pointer.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::emitArrayLength">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1543,
 FQN="clang::CodeGen::CodeGenFunction::emitArrayLength", NM="_ZN5clang7CodeGen15CodeGenFunction15emitArrayLengthEPKNS_9ArrayTypeERNS_8QualTypeERNS0_7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15emitArrayLengthEPKNS_9ArrayTypeERNS_8QualTypeERNS0_7AddressE")
//</editor-fold>
public final Value /*P*/ emitArrayLength(/*const*/ org.clang.ast.ArrayType /*P*/ origArrayType, 
               final QualType /*&*/ baseType, 
               final Address /*&*/ addr) {
  /*const*/ org.clang.ast.ArrayType /*P*/ arrayType = origArrayType;
  
  // If it's a VLA, we have to load the stored size.  Note that
  // this is the size of the VLA in bytes, not its size in elements.
  Value /*P*/ numVLAElements = null;
  if (isa_VariableArrayType(arrayType)) {
    numVLAElements = $this().getVLASize(cast_VariableArrayType(arrayType)).first;
    
    // Walk into all VLAs.  This doesn't require changes to addr,
    // which has type T* where T is the first non-VLA element type.
    do {
      QualType elementType = arrayType.getElementType();
      arrayType = $this().getContext().getAsArrayType(new QualType(elementType));
      
      // If we only have VLA components, 'addr' requires no adjustment.
      if (!(arrayType != null)) {
        baseType.$assign(elementType);
        return numVLAElements;
      }
    } while (isa_VariableArrayType(arrayType));
    // We get out here only if we find a constant array type
    // inside the VLA.
  }
  
  // We have some number of constant-length arrays, so addr should
  // have LLVM type [M x [N x [...]]]*.  Build a GEP that walks
  // down to the first element of addr.
  SmallVector<Value /*P*/ > gepIndices/*J*/= new SmallVector<Value /*P*/ >(8, (Value /*P*/ )null);
  
  // GEP down to the array type.
  ConstantInt /*P*/ zero = $this().Builder.getInt32(0);
  gepIndices.push_back(zero);
  
  long/*uint64_t*/ countFromCLAs = $int2ulong(1);
  QualType eltType/*J*/= new QualType();
  
  org.llvm.ir.ArrayType /*P*/ llvmArrayType = IrRTTI.dyn_cast_ArrayType(addr.getElementType());
  while ((llvmArrayType != null)) {
    assert (isa_ConstantArrayType(arrayType));
    assert (cast_ConstantArrayType(arrayType).getSize().getZExtValue() == llvmArrayType.getNumElements());
    
    gepIndices.push_back(zero);
    countFromCLAs *= llvmArrayType.getNumElements();
    eltType.$assignMove(arrayType.getElementType());
    
    llvmArrayType
       = IrRTTI.dyn_cast_ArrayType(llvmArrayType.getElementType());
    arrayType = $this().getContext().getAsArrayType(arrayType.getElementType());
    assert ((!(llvmArrayType != null) || (arrayType != null))) : "LLVM and Clang types are out-of-synch";
  }
  if ((arrayType != null)) {
    // From this point onwards, the Clang array type has been emitted
    // as some other type (probably a packed struct). Compute the array
    // size, and just emit the 'begin' expression as a bitcast.
    while ((arrayType != null)) {
      countFromCLAs *= cast_ConstantArrayType(arrayType).getSize().getZExtValue();
      eltType.$assignMove(arrayType.getElementType());
      arrayType = $this().getContext().getAsArrayType(new QualType(eltType));
    }
    
    org.llvm.ir.Type /*P*/ baseType$1 = $this().ConvertType(new QualType(eltType));
    addr.$assignMove($this().Builder.CreateElementBitCast(new Address(addr), baseType$1, new Twine(/*KEEP_STR*/"array.begin")));
  } else {
    // Create the actual GEP.
    addr.$assignMove(new Address($this().Builder.CreateInBoundsGEP(addr.getPointer(), 
                new ArrayRef<Value /*P*/ >(gepIndices, true), new Twine(/*KEEP_STR*/"array.begin")), 
            addr.getAlignment()));
  }
  
  baseType.$assign(eltType);
  
  Value /*P*/ numElements = ConstantInt.get(Unnamed_field8.SizeTy, countFromCLAs);
  
  // If we had any VLA dimensions, factor them in.
  if ((numVLAElements != null)) {
    numElements = $this().Builder.CreateNUWMul(numVLAElements, numElements);
  }
  
  return numElements;
}


/// EmitVLASize - Capture all the sizes for the VLA expressions in
/// the given variably-modified type and store them in the VLASizeMap.
///
/// This function can be called with a null (unreachable) insert point.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitVariablyModifiedType">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1664,
 FQN="clang::CodeGen::CodeGenFunction::EmitVariablyModifiedType", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitVariablyModifiedTypeENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitVariablyModifiedTypeENS_8QualTypeE")
//</editor-fold>
public final void EmitVariablyModifiedType(QualType type) {
  assert (type.$arrow().isVariablyModifiedType()) : "Must pass variably modified type to EmitVLASizes!";
  
  $this().EnsureInsertPoint();
  
  // We're going to walk down into the type and look for VLA
  // expressions.
  do {
    assert (type.$arrow().isVariablyModifiedType());
    
    /*const*/ org.clang.ast.Type /*P*/ ty = type.getTypePtr();
    switch (ty.getTypeClass()) {
     case DependentSizedArray:
     case DependentSizedExtVector:
     case UnresolvedUsing:
     case TemplateTypeParm:
     case SubstTemplateTypeParmPack:
     case InjectedClassName:
     case DependentName:
     case DependentTemplateSpecialization:
      throw new llvm_unreachable("unexpected dependent type!");
     case Builtin:
     case Complex:
     case Vector:
     case ExtVector:
     case Record:
     case Enum:
     case Elaborated:
     case TemplateSpecialization:
     case ObjCObject:
     case ObjCInterface:
     case ObjCObjectPointer:
      
      // These types are never variably-modified.
      throw new llvm_unreachable("type class is never variably-modified!");
     case Adjusted:
      type.$assignMove(cast_AdjustedType(ty).getAdjustedType());
      break;
     case Decayed:
      type.$assignMove(cast_DecayedType(ty).getPointeeType());
      break;
     case Pointer:
      type.$assignMove(cast_PointerType(ty).getPointeeType());
      break;
     case BlockPointer:
      type.$assignMove(cast_BlockPointerType(ty).getPointeeType());
      break;
     case LValueReference:
     case RValueReference:
      type.$assignMove(cast_ReferenceType(ty).getPointeeType());
      break;
     case MemberPointer:
      type.$assignMove(cast_MemberPointerType(ty).getPointeeType());
      break;
     case ConstantArray:
     case IncompleteArray:
      // Losing element qualification here is fine.
      type.$assignMove(cast_ArrayType(ty).getElementType());
      break;
     case VariableArray:
      {
        // Losing element qualification here is fine.
        /*const*/ VariableArrayType /*P*/ vat = cast_VariableArrayType(ty);
        {
          
          // Unknown size indication requires no size computation.
          // Otherwise, evaluate and record it.
          /*const*/ Expr /*P*/ size = vat.getSizeExpr();
          if ((size != null)) {
            // It's possible that we might have emitted this already,
            // e.g. with a typedef and a pointer to it.
            final type$ref<Value /*P*/ /*&*/> entry = $this().VLASizeMap.ref$at(size);
            if (!(entry.$deref() != null)) {
              Value /*P*/ Size = $this().EmitScalarExpr(size);
              
              // C11 6.7.6.2p5:
              //   If the size is an expression that is not an integer constant
              //   expression [...] each time it is evaluated it shall have a value
              //   greater than zero.
              if ($this().SanOpts.has(SanitizerKind.VLABound)
                 && size.getType().$arrow().isSignedIntegerType()) {
                SanitizerScope SanScope = null;
                try {
                  SanScope/*J*/= new SanitizerScope($this());
                  Value /*P*/ Zero = Constant.getNullValue(Size.getType());
                  Constant /*P*/ StaticArgs[/*2*/] = new Constant /*P*/  [/*2*/] {
                    $this().EmitCheckSourceLocation(size.getLocStart()), 
                    $this().EmitCheckTypeDescriptor(size.getType())
                  };
                  $this().EmitCheck(new ArrayRef<std.pairPtrULong<Value /*P*/ >>(std.make_pair_Ptr_ulong($this().Builder.CreateICmpSGT(Size, Zero), 
                              SanitizerKind.VLABound), false), 
                      new StringRef(/*KEEP_STR*/"vla_bound_not_positive"), new ArrayRef<Constant /*P*/ >(StaticArgs, true), new ArrayRef<Value /*P*/ >(Size, true));
                } finally {
                  if (SanScope != null) { SanScope.$destroy(); }
                }
              }
              
              // Always zexting here would be wrong if it weren't
              // undefined behavior to have a negative bound.
              entry.$set($this().Builder.CreateIntCast(Size, Unnamed_field8.SizeTy, /*signed*/ false));
            }
          }
        }
        type.$assignMove(vat.getElementType());
        break;
      }
     case FunctionProto:
     case FunctionNoProto:
      type.$assignMove(cast_FunctionType(ty).getReturnType());
      break;
     case Paren:
     case TypeOf:
     case UnaryTransform:
     case Attributed:
     case SubstTemplateTypeParm:
     case PackExpansion:
      // Keep walking after single level desugaring.
      type.$assignMove(type.getSingleStepDesugaredType($this().getContext()));
      break;
     case Typedef:
     case Decltype:
     case Auto:
      // Stop walking: nothing to do.
      return;
     case TypeOfExpr:
      // Stop walking: emit typeof expression.
      $this().EmitIgnoredExpr(cast_TypeOfExprType(ty).getUnderlyingExpr());
      return;
     case Atomic:
      type.$assignMove(cast_AtomicType(ty).getValueType());
      break;
     case Pipe:
      type.$assignMove(cast_PipeType(ty).getElementType());
      break;
    }
  } while (type.$arrow().isVariablyModifiedType());
}


/// getVLASize - Returns an LLVM value that corresponds to the size,
/// in non-variably-sized elements, of a variable length array type,
/// plus that largest non-variably-sized element type.  Assumes that
/// the type has already been emitted with EmitVariablyModifiedType.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getVLASize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1640,
 FQN="clang::CodeGen::CodeGenFunction::getVLASize", NM="_ZN5clang7CodeGen15CodeGenFunction10getVLASizeEPKNS_17VariableArrayTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction10getVLASizeEPKNS_17VariableArrayTypeE")
//</editor-fold>
public final std.pairPtrType<Value /*P*/ , QualType> getVLASize(/*const*/ VariableArrayType /*P*/ type) {
  // The number of elements so far; always size_t.
  Value /*P*/ numElements = null;
  
  QualType elementType/*J*/= new QualType();
  do {
    elementType.$assignMove(type.getElementType());
    Value /*P*/ vlaSize = $this().VLASizeMap.$at_T1$RR(type.getSizeExpr());
    assert ((vlaSize != null)) : "no size for VLA!";
    assert (vlaSize.getType() == Unnamed_field8.SizeTy);
    if (!(numElements != null)) {
      numElements = vlaSize;
    } else {
      // It's undefined behavior if this wraps around, so mark it that way.
      // FIXME: Teach -fsanitize=undefined to trap this.
      numElements = $this().Builder.CreateNUWMul(numElements, vlaSize);
    }
  } while (((type = $this().getContext().getAsVariableArrayType(new QualType(elementType))) != null));
  
  return new std.pairPtrType<Value /*P*/ , QualType>(JD$T$RR_T1$RR.INSTANCE, numElements, new QualType(/*Fwd*/elementType));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getVLASize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1633,
 FQN="clang::CodeGen::CodeGenFunction::getVLASize", NM="_ZN5clang7CodeGen15CodeGenFunction10getVLASizeENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction10getVLASizeENS_8QualTypeE")
//</editor-fold>
public final std.pairPtrType<Value /*P*/ , QualType> getVLASize(QualType type) {
  /*const*/ VariableArrayType /*P*/ vla = $this().getContext().getAsVariableArrayType(new QualType(type));
  assert ((vla != null)) : "type was not a variable array type!";
  return $this().getVLASize(vla);
}


/// protectFromPeepholes - Protect a value that we're intending to
/// store to the side, but which will probably be used later, from
/// aggressive peepholing optimizations that might delete it.
///
/// Pass the result to unprotectFromPeepholes to declare that
/// protection is no longer required.
///
/// There's no particular reason why this shouldn't apply to
/// l-values, it's just that no existing peepholes work on pointers.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::protectFromPeepholes">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1825,
 FQN="clang::CodeGen::CodeGenFunction::protectFromPeepholes", NM="_ZN5clang7CodeGen15CodeGenFunction20protectFromPeepholesENS0_6RValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20protectFromPeepholesENS0_6RValueE")
//</editor-fold>
public final CodeGenFunction.PeepholeProtection protectFromPeepholes(RValue rvalue) {
  // At the moment, the only aggressive peephole we do in IR gen
  // is trunc(zext) folding, but if we add more, we can easily
  // extend this protection.
  if (!rvalue.isScalar()) {
    return new PeepholeProtection();
  }
  Value /*P*/ value = rvalue.getScalarVal();
  if (!IrRTTI.isa_ZExtInst(value)) {
    return new PeepholeProtection();
  }
  
  // Just make an extra bitcast.
  assert ($this().HaveInsertPoint());
  Instruction /*P*/ inst = /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
      return new BitCastInst(value, value.getType(), new Twine(/*KEEP_STR*/$EMPTY), 
              $this().Builder.GetInsertBlock());
   });
  
  PeepholeProtection protection/*J*/= new PeepholeProtection();
  protection.Inst = inst;
  return protection;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::unprotectFromPeepholes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1845,
 FQN="clang::CodeGen::CodeGenFunction::unprotectFromPeepholes", NM="_ZN5clang7CodeGen15CodeGenFunction22unprotectFromPeepholesENS1_18PeepholeProtectionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22unprotectFromPeepholesENS1_18PeepholeProtectionE")
//</editor-fold>
public final void unprotectFromPeepholes(PeepholeProtection protection) {
  if (!(protection.Inst != null)) {
    return;
  }
  
  // In theory, we could try to duplicate the peepholes now, but whatever.
  protection.Inst.eraseFromParent();
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitDeclRefExprDbgValue">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1817,
 FQN="clang::CodeGen::CodeGenFunction::EmitDeclRefExprDbgValue", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitDeclRefExprDbgValueEPKNS_11DeclRefExprEPN4llvm8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitDeclRefExprDbgValueEPKNS_11DeclRefExprEPN4llvm8ConstantE")
//</editor-fold>
public final void EmitDeclRefExprDbgValue(/*const*/ DeclRefExpr /*P*/ E, 
                       Constant /*P*/ Init) {
  assert ((Init != null)) : "Invalid DeclRefExpr initializer!";
  {
    CGDebugInfo /*P*/ Dbg = $this().getDebugInfo();
    if ((Dbg != null)) {
      if ($this().CGM.getCodeGenOpts().getDebugInfo().getValue() >= DebugInfoKind.LimitedDebugInfo.getValue()) {
        Dbg.EmitGlobalVariable(E.getDecl$Const(), Init);
      }
    }
  }
}


// Emits an error if we don't have a valid set of target features for the
// called function.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::checkTargetFeatures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1956,
 FQN="clang::CodeGen::CodeGenFunction::checkTargetFeatures", NM="_ZN5clang7CodeGen15CodeGenFunction19checkTargetFeaturesEPKNS_8CallExprEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19checkTargetFeaturesEPKNS_8CallExprEPKNS_12FunctionDeclE")
//</editor-fold>
public final void checkTargetFeatures(/*const*/ CallExpr /*P*/ E, 
                   /*const*/ FunctionDecl /*P*/ TargetDecl) {
  // Early exit if this is an indirect call.
  if (!(TargetDecl != null)) {
    return;
  }
  
  // Get the current enclosing function if it exists. If it doesn't
  // we can't check the target features anyhow.
  /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl($this().CurFuncDecl);
  if (!(FD != null)) {
    return;
  }
  
  // Grab the required features for the call. For a builtin this is listed in
  // the td file with the default cpu, for an always_inline function this is any
  // listed cpu and any listed features.
  /*uint*/int BuiltinID = TargetDecl.getBuiltinID();
  std.string MissingFeature/*J*/= new std.string();
  if ((BuiltinID != 0)) {
    SmallVector<StringRef> ReqFeatures/*J*/= new SmallVector<StringRef>(1, new StringRef());
    /*const*/char$ptr/*char P*/ FeatureList = $tryClone($this().CGM.getContext().BuiltinInfo.getRequiredFeatures(BuiltinID));
    // Return if the builtin doesn't have any required features.
    if (!Native.$bool(FeatureList) || $eq_StringRef(/*STRINGREF_STR*/FeatureList, /*STRINGREF_STR*/"")) {
      return;
    }
    new StringRef(FeatureList).split(ReqFeatures, /*STRINGREF_STR*/",");
    if (!hasRequiredFeatures(ReqFeatures, $this().CGM, FD, MissingFeature)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_DeclarationName($c$.track($this().CGM.getDiags().Report(E.getLocStart(), diag.err_builtin_needs_feature)), 
                TargetDecl.getDeclName()), 
            $this().CGM.getContext().BuiltinInfo.getRequiredFeatures(BuiltinID)));
      } finally {
        $c$.$destroy();
      }
    }
  } else if (TargetDecl.hasAttr(TargetAttr.class)) {
    StringMapBool CalleeFeatureMap = null;
    try {
      // Get the required features for the callee.
      SmallVector<StringRef> ReqFeatures/*J*/= new SmallVector<StringRef>(1, new StringRef());
      CalleeFeatureMap/*J*/= new StringMapBool(false);
      $this().CGM.getFunctionFeatureMap(CalleeFeatureMap, TargetDecl);
      for (final /*const*/StringMapEntryBool/*&*/ F : CalleeFeatureMap) {
        // Only positive features are "required".
        if (F.getValue$Const()) {
          ReqFeatures.push_back(F.getKey());
        }
      }
      if (!hasRequiredFeatures(ReqFeatures, $this().CGM, FD, MissingFeature)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_DeclarationName($out_DiagnosticBuilder$C_DeclarationName($c$.track($this().CGM.getDiags().Report(E.getLocStart(), diag.err_function_needs_feature)), 
                      FD.getDeclName()), TargetDecl.getDeclName()), new StringRef(MissingFeature)));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
      if (CalleeFeatureMap != null) { CalleeFeatureMap.$destroy(); }
    }
  }
}


//===--------------------------------------------------------------------===//
//                         Annotations Emission
//===--------------------------------------------------------------------===//

/// Emit an annotation call (intrinsic or builtin).
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAnnotationCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1852,
 FQN="clang::CodeGen::CodeGenFunction::EmitAnnotationCall", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitAnnotationCallEPN4llvm5ValueES4_NS2_9StringRefENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitAnnotationCallEPN4llvm5ValueES4_NS2_9StringRefENS_14SourceLocationE")
//</editor-fold>
public final Value /*P*/ EmitAnnotationCall(Value /*P*/ AnnotationFn, 
                  Value /*P*/ AnnotatedVal, 
                  StringRef AnnotationStr, 
                  SourceLocation Location) {
  Value /*P*/ Args[/*4*/] = new Value /*P*/  [/*4*/] {
    AnnotatedVal, 
    $this().Builder.CreateBitCast($this().CGM.EmitAnnotationString(new StringRef(AnnotationStr)), Unnamed_field9.Int8PtrTy), 
    $this().Builder.CreateBitCast($this().CGM.EmitAnnotationUnit(new SourceLocation(Location)), Unnamed_field9.Int8PtrTy), 
    $this().CGM.EmitAnnotationLineNo(new SourceLocation(Location))
  };
  return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(AnnotationFn, new ArrayRef<Value /*P*/ >(Args, true));
}


/// Emit local annotations for the local variable V, declared by D.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitVarAnnotations">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1865,
 FQN="clang::CodeGen::CodeGenFunction::EmitVarAnnotations", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitVarAnnotationsEPKNS_7VarDeclEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitVarAnnotationsEPKNS_7VarDeclEPN4llvm5ValueE")
//</editor-fold>
public final void EmitVarAnnotations(/*const*/ VarDecl /*P*/ D, Value /*P*/ V) {
  assert (D.hasAttr(AnnotateAttr.class)) : "no annotate attribute";
  // FIXME We create a new bitcast for every annotation because that's what
  // llvm-gcc was doing.
  for (/*const*/ AnnotateAttr /*P*/ I : D.specific_attrs(AnnotateAttr.class))  {
    $this().EmitAnnotationCall($this().CGM.getIntrinsic(ID.var_annotation), 
        $this().Builder.CreateBitCast(V, $this().Unnamed_field9.Int8PtrTy, new Twine(V.getName())), 
        I.getAnnotation(), D.getLocation());
  }
}


/// Emit field annotations for the given field & value. Returns the
/// annotation result.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitFieldAnnotations">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1875,
 FQN="clang::CodeGen::CodeGenFunction::EmitFieldAnnotations", NM="_ZN5clang7CodeGen15CodeGenFunction20EmitFieldAnnotationsEPKNS_9FieldDeclENS0_7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20EmitFieldAnnotationsEPKNS_9FieldDeclENS0_7AddressE")
//</editor-fold>
public final Address EmitFieldAnnotations(/*const*/ FieldDecl /*P*/ D, 
                    Address Addr) {
  assert (D.hasAttr(AnnotateAttr.class)) : "no annotate attribute";
  Value /*P*/ V = Addr.getPointer();
  org.llvm.ir.Type /*P*/ VTy = V.getType();
  Value /*P*/ F = $this().CGM.getIntrinsic(ID.ptr_annotation, 
      new ArrayRef<org.llvm.ir.Type /*P*/ >($this().CGM.Unnamed_field9.Int8PtrTy, true));
  
  for (/*const*/ AnnotateAttr /*P*/ I : D.specific_attrs(AnnotateAttr.class)) {
    // FIXME Always emit the cast inst so we can differentiate between
    // annotation on the first field of a struct and annotation on the struct
    // itself.
    if (VTy != $this().CGM.Unnamed_field9.Int8PtrTy) {
      final Value /*P*/ L$V = V;
      V = $this().Builder.Insert$T(/*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
              return new BitCastInst(L$V, $this().CGM.Unnamed_field9.Int8PtrTy);
          }));
    }
    V = $this().EmitAnnotationCall(F, V, I.getAnnotation(), D.getLocation());
    V = $this().Builder.CreateBitCast(V, VTy);
  }
  
  return new Address(V, Addr.getAlignment());
}


//===--------------------------------------------------------------------===//
//                             Internal Helpers
//===--------------------------------------------------------------------===//

/// ContainsLabel - Return true if the statement contains a label in it.  If
/// this statement is not executed normally, it not containing a label means
/// that we can just remove the code.

/// ContainsLabel - Return true if the statement contains a label in it.  If
/// this statement is not executed normally, it not containing a label means
/// that we can just remove the code.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ContainsLabel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1093,
 FQN="clang::CodeGen::CodeGenFunction::ContainsLabel", NM="_ZN5clang7CodeGen15CodeGenFunction13ContainsLabelEPKNS_4StmtEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13ContainsLabelEPKNS_4StmtEb")
//</editor-fold>
public static boolean ContainsLabel(/*const*/ Stmt /*P*/ S) {
  return ContainsLabel(S, false);
}
public static boolean ContainsLabel(/*const*/ Stmt /*P*/ S, boolean IgnoreCaseStmts/*= false*/) {
  // Null statement, not a label!
  if (!(S != null)) {
    return false;
  }
  
  // If this is a label, we have to emit the code, consider something like:
  // if (0) {  ...  foo:  bar(); }  goto foo;
  //
  // TODO: If anyone cared, we could track __label__'s, since we know that you
  // can't jump to one from outside their declared region.
  if (isa_LabelStmt(S)) {
    return true;
  }
  
  // If this is a case/default statement, and we haven't seen a switch, we have
  // to emit the code.
  if (isa_SwitchCase(S) && !IgnoreCaseStmts) {
    return true;
  }
  
  // If this is a switch statement, we want to ignore cases below it.
  if (isa_SwitchStmt(S)) {
    IgnoreCaseStmts = true;
  }
  
  // Scan subexpressions for verboten labels.
  for (/*const*/ Stmt /*P*/ SubStmt : S.children$Const())  {
    if (ContainsLabel(SubStmt, IgnoreCaseStmts)) {
      return true;
    }
  }
  
  return false;
}


/// containsBreak - Return true if the statement contains a break out of it.
/// If the statement (recursively) contains a switch or loop with a break
/// inside of it, this is fine.

/// containsBreak - Return true if the statement contains a break out of it.
/// If the statement (recursively) contains a switch or loop with a break
/// inside of it, this is fine.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::containsBreak">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1125,
 FQN="clang::CodeGen::CodeGenFunction::containsBreak", NM="_ZN5clang7CodeGen15CodeGenFunction13containsBreakEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13containsBreakEPKNS_4StmtE")
//</editor-fold>
public static boolean containsBreak(/*const*/ Stmt /*P*/ S) {
  // Null statement, not a label!
  if (!(S != null)) {
    return false;
  }
  
  // If this is a switch or loop that defines its own break scope, then we can
  // include it and anything inside of it.
  if (isa_SwitchStmt(S) || isa_WhileStmt(S) || isa_DoStmt(S)
     || isa_ForStmt(S)) {
    return false;
  }
  if (isa_BreakStmt(S)) {
    return true;
  }
  
  // Scan subexpressions for verboten breaks.
  for (/*const*/ Stmt /*P*/ SubStmt : S.children$Const())  {
    if (containsBreak(SubStmt)) {
      return true;
    }
  }
  
  return false;
}


/// ConstantFoldsToSimpleInteger - If the specified expression does not fold
/// to a constant, or if it does but contains a label, return false.  If it
/// constant folds return true and set the boolean result in Result.

/// ConstantFoldsToSimpleInteger - If the specified expression does not fold
/// to a constant, or if it does but contains a label, return false.  If it
/// constant folds return true and set the boolean result in Result.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ConstantFoldsToSimpleInteger">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1150,
 FQN="clang::CodeGen::CodeGenFunction::ConstantFoldsToSimpleInteger", NM="_ZN5clang7CodeGen15CodeGenFunction28ConstantFoldsToSimpleIntegerEPKNS_4ExprERbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction28ConstantFoldsToSimpleIntegerEPKNS_4ExprERbb")
//</editor-fold>
public final boolean ConstantFoldsToSimpleInteger(/*const*/ Expr /*P*/ Cond, 
                            final bool$ref/*bool &*/ ResultBool) {
  return ConstantFoldsToSimpleInteger(Cond, 
                            ResultBool, 
                            false);
}
public final boolean ConstantFoldsToSimpleInteger(/*const*/ Expr /*P*/ Cond, 
                            final bool$ref/*bool &*/ ResultBool, 
                            boolean AllowLabels/*= false*/) {
  APSInt ResultInt/*J*/= new APSInt();
  if (!$this().ConstantFoldsToSimpleInteger(Cond, ResultInt, AllowLabels)) {
    return false;
  }
  
  ResultBool.$set(ResultInt.getBoolValue());
  return true;
}


/// ConstantFoldsToSimpleInteger - If the specified expression does not fold
/// to a constant, or if it does but contains a label, return false.  If it
/// constant folds return true and set the folded value.

/// ConstantFoldsToSimpleInteger - If the specified expression does not fold
/// to a constant, or if it does but contains a label, return false.  If it
/// constant folds return true and set the folded value.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ConstantFoldsToSimpleInteger">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1164,
 FQN="clang::CodeGen::CodeGenFunction::ConstantFoldsToSimpleInteger", NM="_ZN5clang7CodeGen15CodeGenFunction28ConstantFoldsToSimpleIntegerEPKNS_4ExprERN4llvm6APSIntEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction28ConstantFoldsToSimpleIntegerEPKNS_4ExprERN4llvm6APSIntEb")
//</editor-fold>
public final boolean ConstantFoldsToSimpleInteger(/*const*/ Expr /*P*/ Cond, 
                            final APSInt /*&*/ ResultInt) {
  return ConstantFoldsToSimpleInteger(Cond, 
                            ResultInt, 
                            false);
}
public final boolean ConstantFoldsToSimpleInteger(/*const*/ Expr /*P*/ Cond, 
                            final APSInt /*&*/ ResultInt, 
                            boolean AllowLabels/*= false*/) {
  // FIXME: Rename and handle conversion of other evaluatable things
  // to bool.
  APSInt Int/*J*/= new APSInt();
  if (!Cond.EvaluateAsInt(Int, $this().getContext())) {
    return false; // Not foldable, not integer or not fully evaluatable.
  }
  if (!AllowLabels && CodeGenFunction.ContainsLabel(Cond)) {
    return false; // Contains a label.
  }
  
  ResultInt.$assign(Int);
  return true;
}


/// EmitBranchOnBoolExpr - Emit a branch on a boolean condition (e.g. for an
/// if statement) to the specified blocks.  Based on the condition, this might
/// try to simplify the codegen of the conditional based on the branch.
/// TrueCount should be the number of times we expect the condition to
/// evaluate to true based on PGO data.

/// EmitBranchOnBoolExpr - Emit a branch on a boolean condition (e.g. for an if
/// statement) to the specified blocks.  Based on the condition, this might try
/// to simplify the codegen of the conditional based on the branch.
///
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitBranchOnBoolExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1186,
 FQN="clang::CodeGen::CodeGenFunction::EmitBranchOnBoolExpr", NM="_ZN5clang7CodeGen15CodeGenFunction20EmitBranchOnBoolExprEPKNS_4ExprEPN4llvm10BasicBlockES7_y",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20EmitBranchOnBoolExprEPKNS_4ExprEPN4llvm10BasicBlockES7_y")
//</editor-fold>
public final void EmitBranchOnBoolExpr(/*const*/ Expr /*P*/ Cond, 
                    BasicBlock /*P*/ TrueBlock, 
                    BasicBlock /*P*/ FalseBlock, 
                    long/*uint64_t*/ TrueCount) {
  Cond = Cond.IgnoreParens$Const();
  {
    
    /*const*/ org.clang.ast.BinaryOperator /*P*/ CondBOp = dyn_cast_BinaryOperator(Cond);
    if ((CondBOp != null)) {
      
      // Handle X && Y in a condition.
      if (CondBOp.getOpcode() == BinaryOperatorKind.BO_LAnd) {
        // If we have "1 && X", simplify the code.  "0 && X" would have constant
        // folded if the case was simple enough.
        bool$ref ConstantBool = create_bool$ref(false);
        if ($this().ConstantFoldsToSimpleInteger(CondBOp.getLHS(), ConstantBool)
           && ConstantBool.$deref()) {
          // br(1 && X) -> br(X).
          $this().incrementProfileCounter(CondBOp);
          $this().EmitBranchOnBoolExpr(CondBOp.getRHS(), TrueBlock, FalseBlock, 
              TrueCount);
          /*JAVA:return*/return;
        }
        
        // If we have "X && 1", simplify the code to use an uncond branch.
        // "X && 0" would have been constant folded to 0.
        if ($this().ConstantFoldsToSimpleInteger(CondBOp.getRHS(), ConstantBool)
           && ConstantBool.$deref()) {
          // br(X && 1) -> br(X).
          $this().EmitBranchOnBoolExpr(CondBOp.getLHS(), TrueBlock, FalseBlock, 
              TrueCount);
          /*JAVA:return*/return;
        }
        
        // Emit the LHS as a conditional.  If the LHS conditional is false, we
        // want to jump to the FalseBlock.
        BasicBlock /*P*/ LHSTrue = $this().createBasicBlock(new Twine(/*KEEP_STR*/"land.lhs.true"));
        // The counter tells us how often we evaluate RHS, and all of TrueCount
        // can be propagated to that branch.
        long/*uint64_t*/ RHSCount = $this().getProfileCount(CondBOp.getRHS());
        
        ConditionalEvaluation eval/*J*/= new ConditionalEvaluation(/*Deref*/$this());
        {
          ApplyDebugLocation DL = null;
          try {
            DL/*J*/= new ApplyDebugLocation(/*Deref*/$this(), Cond);
            $this().EmitBranchOnBoolExpr(CondBOp.getLHS(), LHSTrue, FalseBlock, RHSCount);
            $this().EmitBlock(LHSTrue);
          } finally {
            if (DL != null) { DL.$destroy(); }
          }
        }
        
        $this().incrementProfileCounter(CondBOp);
        $this().setCurrentProfileCount($this().getProfileCount(CondBOp.getRHS()));
        
        // Any temporaries created here are conditional.
        eval.begin(/*Deref*/$this());
        $this().EmitBranchOnBoolExpr(CondBOp.getRHS(), TrueBlock, FalseBlock, TrueCount);
        eval.end(/*Deref*/$this());
        
        return;
      }
      if (CondBOp.getOpcode() == BinaryOperatorKind.BO_LOr) {
        // If we have "0 || X", simplify the code.  "1 || X" would have constant
        // folded if the case was simple enough.
        bool$ref ConstantBool = create_bool$ref(false);
        if ($this().ConstantFoldsToSimpleInteger(CondBOp.getLHS(), ConstantBool)
           && !ConstantBool.$deref()) {
          // br(0 || X) -> br(X).
          $this().incrementProfileCounter(CondBOp);
          $this().EmitBranchOnBoolExpr(CondBOp.getRHS(), TrueBlock, FalseBlock, 
              TrueCount);
          /*JAVA:return*/return;
        }
        
        // If we have "X || 0", simplify the code to use an uncond branch.
        // "X || 1" would have been constant folded to 1.
        if ($this().ConstantFoldsToSimpleInteger(CondBOp.getRHS(), ConstantBool)
           && !ConstantBool.$deref()) {
          // br(X || 0) -> br(X).
          $this().EmitBranchOnBoolExpr(CondBOp.getLHS(), TrueBlock, FalseBlock, 
              TrueCount);
          /*JAVA:return*/return;
        }
        
        // Emit the LHS as a conditional.  If the LHS conditional is true, we
        // want to jump to the TrueBlock.
        BasicBlock /*P*/ LHSFalse = $this().createBasicBlock(new Twine(/*KEEP_STR*/"lor.lhs.false"));
        // We have the count for entry to the RHS and for the whole expression
        // being true, so we can divy up True count between the short circuit and
        // the RHS.
        long/*uint64_t*/ LHSCount = $this().getCurrentProfileCount() - $this().getProfileCount(CondBOp.getRHS());
        long/*uint64_t*/ RHSCount = TrueCount - LHSCount;
        
        ConditionalEvaluation eval/*J*/= new ConditionalEvaluation(/*Deref*/$this());
        {
          ApplyDebugLocation DL = null;
          try {
            DL/*J*/= new ApplyDebugLocation(/*Deref*/$this(), Cond);
            $this().EmitBranchOnBoolExpr(CondBOp.getLHS(), TrueBlock, LHSFalse, LHSCount);
            $this().EmitBlock(LHSFalse);
          } finally {
            if (DL != null) { DL.$destroy(); }
          }
        }
        
        $this().incrementProfileCounter(CondBOp);
        $this().setCurrentProfileCount($this().getProfileCount(CondBOp.getRHS()));
        
        // Any temporaries created here are conditional.
        eval.begin(/*Deref*/$this());
        $this().EmitBranchOnBoolExpr(CondBOp.getRHS(), TrueBlock, FalseBlock, RHSCount);
        
        eval.end(/*Deref*/$this());
        
        return;
      }
    }
  }
  {
    
    /*const*/ UnaryOperator /*P*/ CondUOp = dyn_cast_UnaryOperator(Cond);
    if ((CondUOp != null)) {
      // br(!x, t, f) -> br(x, f, t)
      if (CondUOp.getOpcode() == UnaryOperatorKind.UO_LNot) {
        // Negate the count.
        long/*uint64_t*/ FalseCount = $this().getCurrentProfileCount() - TrueCount;
        // Negate the condition and swap the destination blocks.
        $this().EmitBranchOnBoolExpr(CondUOp.getSubExpr(), FalseBlock, TrueBlock, 
            FalseCount);
        /*JAVA:return*/return;
      }
    }
  }
  {
    
    /*const*/ ConditionalOperator /*P*/ CondOp = dyn_cast_ConditionalOperator(Cond);
    if ((CondOp != null)) {
      // br(c ? x : y, t, f) -> br(c, br(x, t, f), br(y, t, f))
      BasicBlock /*P*/ LHSBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"cond.true"));
      BasicBlock /*P*/ RHSBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"cond.false"));
      
      ConditionalEvaluation cond/*J*/= new ConditionalEvaluation(/*Deref*/$this());
      $this().EmitBranchOnBoolExpr(CondOp.getCond(), LHSBlock, RHSBlock, 
          $this().getProfileCount(CondOp));
      
      // When computing PGO branch weights, we only know the overall count for
      // the true block. This code is essentially doing tail duplication of the
      // naive code-gen, introducing new edges for which counts are not
      // available. Divide the counts proportionally between the LHS and RHS of
      // the conditional operator.
      long/*uint64_t*/ LHSScaledTrueCount = $int2ulong(0);
      if ((TrueCount != 0)) {
        double LHSRatio = $this().getProfileCount(CondOp) / (double)$this().getCurrentProfileCount();
        LHSScaledTrueCount = (long)(TrueCount * LHSRatio);
      }
      
      cond.begin(/*Deref*/$this());
      $this().EmitBlock(LHSBlock);
      $this().incrementProfileCounter(CondOp);
      {
        ApplyDebugLocation DL = null;
        try {
          DL/*J*/= new ApplyDebugLocation(/*Deref*/$this(), Cond);
          $this().EmitBranchOnBoolExpr(CondOp.getLHS(), TrueBlock, FalseBlock, 
              LHSScaledTrueCount);
        } finally {
          if (DL != null) { DL.$destroy(); }
        }
      }
      cond.end(/*Deref*/$this());
      
      cond.begin(/*Deref*/$this());
      $this().EmitBlock(RHSBlock);
      $this().EmitBranchOnBoolExpr(CondOp.getRHS(), TrueBlock, FalseBlock, 
          TrueCount - LHSScaledTrueCount);
      cond.end(/*Deref*/$this());
      
      return;
    }
  }
  {
    
    /*const*/ CXXThrowExpr /*P*/ Throw = dyn_cast_CXXThrowExpr(Cond);
    if ((Throw != null)) {
      // Conditional operator handling can give us a throw expression as a
      // condition for a case like:
      //   br(c ? throw x : y, t, f) -> br(c, br(throw x, t, f), br(y, t, f)
      // Fold this to:
      //   br(c, throw x, br(y, t, f))
      $this().EmitCXXThrowExpr(Throw, /*KeepInsertionPoint*/ false);
      return;
    }
  }
  
  // If the branch has a condition wrapped by __builtin_unpredictable,
  // create metadata that specifies that the branch is unpredictable.
  // Don't bother if not optimizing because that metadata would not be used.
  MDNode /*P*/ Unpredictable = null;
  /*const*/ CallExpr /*P*/ Call = dyn_cast_CallExpr(Cond);
  if ((Call != null) && $2bits_uint2uint($this().CGM.getCodeGenOpts().OptimizationLevel) != 0) {
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(Call.getCalleeDecl$Const());
    if ((FD != null) && FD.getBuiltinID() == Builtin.ID.BI__builtin_unpredictable.getValue()) {
      MDBuilder MDHelper/*J*/= new MDBuilder($this().getLLVMContext());
      Unpredictable = MDHelper.createUnpredictable();
    }
  }
  
  // Create branch weights based on the number of times we get here and the
  // number of times the condition should be true.
  long/*uint64_t*/ CurrentCount = std.max($this().getCurrentProfileCount(), TrueCount);
  MDNode /*P*/ Weights = $this().createProfileWeights(TrueCount, CurrentCount - TrueCount);
  
  // Emit the code with the fully general case.
  Value /*P*/ CondV;
  {
    ApplyDebugLocation DL = null;
    try {
      DL/*J*/= new ApplyDebugLocation(/*Deref*/$this(), Cond);
      CondV = $this().EvaluateExprAsBool(Cond);
    } finally {
      if (DL != null) { DL.$destroy(); }
    }
  }
  $this().Builder.CreateCondBr(CondV, TrueBlock, FalseBlock, Weights, Unpredictable);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitSanitizerStatReport">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 2002,
 FQN="clang::CodeGen::CodeGenFunction::EmitSanitizerStatReport", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitSanitizerStatReportEN4llvm17SanitizerStatKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitSanitizerStatReportEN4llvm17SanitizerStatKindE")
//</editor-fold>
public final void EmitSanitizerStatReport(SanitizerStatKind SSK) {
  IRBuilder IRB = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (!$this().CGM.getCodeGenOpts().SanitizeStats) {
      return;
    }
    
    IRB/*J*/= new IRBuilder($this().Builder.GetInsertBlock(), $this().Builder.GetInsertPoint());
    IRB.SetCurrentDebugLocation($c$.track(new DebugLoc($this().Builder.getCurrentDebugLocation()))); $c$.clean();
    $this().CGM.getSanStats().create(IRB, SSK);
  } finally {
    if (IRB != null) { IRB.$destroy(); }
    $c$.$destroy();
  }
}

} // END OF class CodeGenFunction_CodeGenFunction
