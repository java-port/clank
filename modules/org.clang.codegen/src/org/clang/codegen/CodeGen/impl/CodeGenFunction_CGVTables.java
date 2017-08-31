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
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.codegen.impl.CGVTablesStatics;
import static org.clang.codegen.impl.CGVTablesStatics.*;
import static org.clank.support.Native.$AddrOf;
import static org.clank.support.Native.$Deref;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.transforms.utils.TransformsLlvmGlobals;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_CGVTables">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_CGVTables",        
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_CGStmtOpenMP ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction10StartThunkEPN4llvm8FunctionENS_10GlobalDeclERKNS0_14CGFunctionInfoE;_ZN5clang7CodeGen15CodeGenFunction11FinishThunkEv;_ZN5clang7CodeGen15CodeGenFunction13generateThunkEPN4llvm8FunctionERKNS0_14CGFunctionInfoENS_10GlobalDeclERKNS_9ThunkInfoE;_ZN5clang7CodeGen15CodeGenFunction17EmitMustTailThunkEPKNS_13CXXMethodDeclEPN4llvm5ValueES7_;_ZN5clang7CodeGen15CodeGenFunction20GenerateVarArgsThunkEPN4llvm8FunctionERKNS0_14CGFunctionInfoENS_10GlobalDeclERKNS_9ThunkInfoE;_ZN5clang7CodeGen15CodeGenFunction25EmitCallAndReturnForThunkEPN4llvm5ValueEPKNS_9ThunkInfoE; -static-type=CodeGenFunction_CGVTables -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_CGVTables extends CodeGenFunction_CGStmtOpenMP {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_CGVTables(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::StartThunk">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 208,
 FQN="clang::CodeGen::CodeGenFunction::StartThunk", NM="_ZN5clang7CodeGen15CodeGenFunction10StartThunkEPN4llvm8FunctionENS_10GlobalDeclERKNS0_14CGFunctionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction10StartThunkEPN4llvm8FunctionENS_10GlobalDeclERKNS0_14CGFunctionInfoE")
//</editor-fold>
public final void StartThunk(Function /*P*/ Fn, GlobalDecl GD, 
          final /*const*/ CGFunctionInfo /*&*/ FnInfo) {
  FunctionArgList FunctionArgs = null;
  try {
    assert (!($this().CurGD.getDecl() != null)) : "CurGD was already set!";
    $this().CurGD.$assign(GD);
    $this().CurFuncIsThunk = true;
    
    // Build FunctionArgs.
    /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(GD.getDecl());
    QualType ThisType = MD.getThisType($this().getContext());
    /*const*/ FunctionProtoType /*P*/ FPT = MD.getType().$arrow().getAs(FunctionProtoType.class);
    QualType ResultType = $this().CGM.getCXXABI().HasThisReturn(new GlobalDecl(GD)) ? new QualType(ThisType) : $this().CGM.getCXXABI().hasMostDerivedReturn(new GlobalDecl(GD)) ? $this().CGM.getContext().VoidPtrTy.$QualType() : FPT.getReturnType();
    FunctionArgs/*J*/= new FunctionArgList();
    
    // Create the implicit 'this' parameter declaration.
    $this().CGM.getCXXABI().buildThisParam(/*Deref*/$this(), FunctionArgs);
    
    // Add the rest of the parameters.
    FunctionArgs.append_T(MD.param_begin$Const(), MD.param_end$Const());
    if (isa_CXXDestructorDecl(MD)) {
      $this().CGM.getCXXABI().addImplicitStructorParams(/*Deref*/$this(), ResultType, FunctionArgs);
    }
    
    // Start defining the function.
    $this().StartFunction(new GlobalDecl(), new QualType(ResultType), Fn, FnInfo, FunctionArgs, 
        MD.getLocation(), MD.getLocation());
    
    // Since we didn't pass a GlobalDecl to StartFunction, do this ourselves.
    $this().CGM.getCXXABI().EmitInstanceFunctionProlog(/*Deref*/$this());
    $this().CXXThisValue = $this().CXXABIThisValue;
    $this().CurCodeDecl = MD;
    $this().CurFuncDecl = MD;
  } finally {
    if (FunctionArgs != null) { FunctionArgs.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCallAndReturnForThunk">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 254,
 FQN="clang::CodeGen::CodeGenFunction::EmitCallAndReturnForThunk", NM="_ZN5clang7CodeGen15CodeGenFunction25EmitCallAndReturnForThunkEPN4llvm5ValueEPKNS_9ThunkInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25EmitCallAndReturnForThunkEPN4llvm5ValueEPKNS_9ThunkInfoE")
//</editor-fold>
public final void EmitCallAndReturnForThunk(Value /*P*/ Callee, 
                         /*const*/ ThunkInfo /*P*/ Thunk) {
  CallArgList CallArgs = null;
  try {
    assert (isa_CXXMethodDecl($this().CurGD.getDecl())) : "Please use a new CGF for this thunk";
    /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl($this().CurGD.getDecl());
    
    // Adjust the 'this' pointer if necessary
    Value /*P*/ AdjustedThisPtr = (Thunk != null) ? $this().CGM.getCXXABI().performThisAdjustment(/*Deref*/$this(), $this().LoadCXXThisAddress(), Thunk.This) : $this().LoadCXXThis();
    if ($this().CurFnInfo.usesInAlloca()) {
      // We don't handle return adjusting thunks, because they require us to call
      // the copy constructor.  For now, fall through and pretend the return
      // adjustment was empty so we don't crash.
      if ((Thunk != null) && !Thunk.Return.isEmpty()) {
        $this().CGM.ErrorUnsupported(MD, $("non-trivial argument copy for return-adjusting thunk"));
      }
      $this().EmitMustTailThunk(MD, AdjustedThisPtr, Callee);
      return;
    }
    
    // Start building CallArgs.
    CallArgs/*J*/= new CallArgList();
    QualType ThisType = MD.getThisType($this().getContext());
    CallArgs.add(RValue.get(AdjustedThisPtr), new QualType(ThisType));
    if (isa_CXXDestructorDecl(MD)) {
      $this().CGM.getCXXABI().adjustCallArgsForDestructorThunk(/*Deref*/$this(), new GlobalDecl($this().CurGD), CallArgs);
    }
    
    // Add the rest of the arguments.
    for (/*const*/ ParmVarDecl /*P*/ PD : MD.parameters$Const())  {
      $this().EmitDelegateCallArg(CallArgs, PD, PD.getLocStart());
    }
    
    /*const*/ FunctionProtoType /*P*/ FPT = MD.getType().$arrow().getAs(FunctionProtoType.class);
    final /*const*/ CGFunctionInfo /*&*/ CallFnInfo = $this().CGM.getTypes().arrangeCXXMethodCall(CallArgs, FPT, RequiredArgs.forPrototypePlus(FPT, 1, MD));
    assert (CallFnInfo.getRegParm() == $this().CurFnInfo.getRegParm() && CallFnInfo.isNoReturn() == $this().CurFnInfo.isNoReturn() && CallFnInfo.getCallingConvention() == $this().CurFnInfo.getCallingConvention());
    assert (isa_CXXDestructorDecl(MD) || CGVTablesStatics.similar(CallFnInfo.getReturnInfo$Const(), CallFnInfo.getReturnType(), $this().CurFnInfo.getReturnInfo$Const(), $this().CurFnInfo.getReturnType()));
    assert (CallFnInfo.arg_size() == $this().CurFnInfo.arg_size());
    for (/*uint*/int i = 0, e = $this().CurFnInfo.arg_size(); i != e; ++i)  {
      assert (CGVTablesStatics.similar(CallFnInfo.arg_begin$Const().$at(i).info, new CanQual<org.clang.ast.Type>(CallFnInfo.arg_begin$Const().$at(i).type), $this().CurFnInfo.arg_begin$Const().$at(i).info, new CanQual<org.clang.ast.Type>($this().CurFnInfo.arg_begin$Const().$at(i).type)));
    }
    
    // Determine whether we have a return value slot to use.
    QualType ResultType = $this().CGM.getCXXABI().HasThisReturn(new GlobalDecl($this().CurGD)) ? new QualType(ThisType) : $this().CGM.getCXXABI().hasMostDerivedReturn(new GlobalDecl($this().CurGD)) ? $this().CGM.getContext().VoidPtrTy.$QualType() : FPT.getReturnType();
    ReturnValueSlot Slot/*J*/= new ReturnValueSlot();
    if (!ResultType.$arrow().isVoidType()
       && $this().CurFnInfo.getReturnInfo$Const().getKind() == ABIArgInfo.Kind.Indirect
       && !CodeGenFunction.hasScalarEvaluationKind($this().CurFnInfo.getReturnType().$QualType())) {
      Slot.$assignMove(new ReturnValueSlot(new Address($this().ReturnValue), ResultType.isVolatileQualified()));
    }
    
    // Now emit our call.
    type$ptr<Instruction /*P*/ > CallOrInvoke = create_type$null$ptr();
    RValue RV = $this().EmitCall($Deref($this().CurFnInfo), Callee, new ReturnValueSlot(Slot), CallArgs, new CGCalleeInfo(MD), $AddrOf(CallOrInvoke));
    
    // Consider return adjustment if we have ThunkInfo.
    if ((Thunk != null) && !Thunk.Return.isEmpty()) {
      RV.$assignMove(CGVTablesStatics.PerformReturnAdjustment(/*Deref*/$this(), new QualType(ResultType), new RValue(RV), $Deref(Thunk)));
    } else {
      CallInst /*P*/ Call = dyn_cast_CallInst(CallOrInvoke.$star());
      if ((Call != null)) {
        Call.setTailCallKind(CallInst.TailCallKind.TCK_Tail);
      }
    }
    
    // Emit return.
    if (!ResultType.$arrow().isVoidType() && Slot.isNull()) {
      $this().CGM.getCXXABI().EmitReturnFromThunk(/*Deref*/$this(), new RValue(RV), new QualType(ResultType));
    }
    
    // Disable the final ARC autorelease.
    $this().AutoreleaseResult = false;
    
    $this().FinishThunk();
  } finally {
    if (CallArgs != null) { CallArgs.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::FinishThunk">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 245,
 FQN="clang::CodeGen::CodeGenFunction::FinishThunk", NM="_ZN5clang7CodeGen15CodeGenFunction11FinishThunkEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11FinishThunkEv")
//</editor-fold>
public final void FinishThunk() {
  // Clear these to restore the invariants expected by
  // StartFunction/FinishFunction.
  $this().CurCodeDecl = null;
  $this().CurFuncDecl = null;
  
  $this().FinishFunction();
}


/// Emit a musttail call for a thunk with a potentially adjusted this pointer.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitMustTailThunk">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 341,
 FQN="clang::CodeGen::CodeGenFunction::EmitMustTailThunk", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitMustTailThunkEPKNS_13CXXMethodDeclEPN4llvm5ValueES7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitMustTailThunkEPKNS_13CXXMethodDeclEPN4llvm5ValueES7_")
//</editor-fold>
public final void EmitMustTailThunk(/*const*/ CXXMethodDecl /*P*/ MD, 
                 Value /*P*/ AdjustedThisPtr, 
                 Value /*P*/ Callee) {
  // Emitting a musttail call thunk doesn't use any of the CGCall.cpp machinery
  // to translate AST arguments into LLVM IR arguments.  For thunks, we know
  // that the caller prototype more or less matches the callee prototype with
  // the exception of 'this'.
  SmallVector<Value /*P*/ > Args/*J*/= new SmallVector<Value /*P*/ >(8, (Value /*P*/ )null);
  for (final Argument /*&*/ A : $this().CurFn.args())  {
    Args.push_back($AddrOf(A));
  }
  
  // Set the adjusted 'this' pointer.
  final /*const*/ ABIArgInfo /*&*/ ThisAI = $this().CurFnInfo.arg_begin$Const().$star().info;
  if (ThisAI.isDirect()) {
    final /*const*/ ABIArgInfo /*&*/ RetAI = $this().CurFnInfo.getReturnInfo$Const();
    int ThisArgNo = RetAI.isIndirect() && !RetAI.isSRetAfterThis() ? 1 : 0;
    org.llvm.ir.Type /*P*/ ThisType = Args.$at(ThisArgNo).getType();
    if (ThisType != AdjustedThisPtr.getType()) {
      AdjustedThisPtr = $this().Builder.CreateBitCast(AdjustedThisPtr, ThisType);
    }
    Args.$set(ThisArgNo, AdjustedThisPtr);
  } else {
    assert (ThisAI.isInAlloca()) : "this is passed directly or inalloca";
    Address ThisAddr = $this().GetAddrOfLocalVar($this().CXXABIThisDecl);
    org.llvm.ir.Type /*P*/ ThisType = ThisAddr.getElementType();
    if (ThisType != AdjustedThisPtr.getType()) {
      AdjustedThisPtr = $this().Builder.CreateBitCast(AdjustedThisPtr, ThisType);
    }
    $this().Builder.CreateStore(AdjustedThisPtr, new Address(ThisAddr));
  }
  
  // Emit the musttail call manually.  Even if the prologue pushed cleanups, we
  // don't actually want to run them.
  CallInst /*P*/ Call = $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(Callee, new ArrayRef<Value /*P*/ >(Args, true));
  Call.setTailCallKind(CallInst.TailCallKind.TCK_MustTail);
  
  // Apply the standard set of call attributes.
  uint$ref CallingConv = create_uint$ref();
  SmallVector<AttributeSet> AttributeList/*J*/= new SmallVector<AttributeSet>(8, new AttributeSet());
  $this().CGM.ConstructAttributeList(Callee.getName(), $Deref($this().CurFnInfo), new CGCalleeInfo(MD), AttributeList, 
      CallingConv, /*AttrOnCallSite=*/ true);
  AttributeSet Attrs = AttributeSet.get_LLVMContext_ArrayRef$AttributeSet($this().getLLVMContext(), new ArrayRef<AttributeSet>(AttributeList, false));
  Call.setAttributes(Attrs);
  Call.setCallingConv(((/*static_cast*//*uint*/int)(CallingConv.$deref())));
  if (Call.getType().isVoidTy()) {
    $this().Builder.CreateRetVoid();
  } else {
    $this().Builder.CreateRet(Call);
  }
  
  // Finish the function to maintain CodeGenFunction invariants.
  // FIXME: Don't emit unreachable code.
  $this().EmitBlock($this().createBasicBlock());
  $this().FinishFunction();
}


/// Generate a thunk for the given method.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::generateThunk">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 396,
 FQN="clang::CodeGen::CodeGenFunction::generateThunk", NM="_ZN5clang7CodeGen15CodeGenFunction13generateThunkEPN4llvm8FunctionERKNS0_14CGFunctionInfoENS_10GlobalDeclERKNS_9ThunkInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13generateThunkEPN4llvm8FunctionERKNS0_14CGFunctionInfoENS_10GlobalDeclERKNS_9ThunkInfoE")
//</editor-fold>
public final void generateThunk(Function /*P*/ Fn, 
             final /*const*/ CGFunctionInfo /*&*/ FnInfo, 
             GlobalDecl GD, final /*const*/ ThunkInfo /*&*/ Thunk) {
  $this().StartThunk(Fn, new GlobalDecl(GD), FnInfo);
  
  // Get our callee.
  org.llvm.ir.Type /*P*/ Ty = $this().CGM.getTypes().GetFunctionType($this().CGM.getTypes().arrangeGlobalDeclaration(new GlobalDecl(GD)));
  Value /*P*/ Callee = $this().CGM.GetAddrOfFunction(new GlobalDecl(GD), Ty, /*ForVTable=*/ true);
  
  // Make the call and return the result.
  $this().EmitCallAndReturnForThunk(Callee, $AddrOf(Thunk));
}


// This function does roughly the same thing as GenerateThunk, but in a
// very different way, so that va_start and va_end work correctly.
// FIXME: This function assumes "this" is the first non-sret LLVM argument of
//        a function, and that there is an alloca built in the entry block
//        for all accesses to "this".
// FIXME: This function assumes there is only one "ret" statement per function.
// FIXME: Cloning isn't correct in the presence of indirect goto!
// FIXME: This implementation of thunks bloats codesize by duplicating the
//        function definition.  There are alternatives:
//        1. Add some sort of stub support to LLVM for cases where we can
//           do a this adjustment, then a sibcall.
//        2. We could transform the definition to take a va_list instead of an
//           actual variable argument list, then have the thunks (including a
//           no-op thunk for the regular definition) call va_start/va_end.
//           There's a bit of per-call overhead for this solution, but it's
//           better for codesize if the definition is long.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GenerateVarArgsThunk">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 143,
 FQN="clang::CodeGen::CodeGenFunction::GenerateVarArgsThunk", NM="_ZN5clang7CodeGen15CodeGenFunction20GenerateVarArgsThunkEPN4llvm8FunctionERKNS0_14CGFunctionInfoENS_10GlobalDeclERKNS_9ThunkInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20GenerateVarArgsThunkEPN4llvm8FunctionERKNS0_14CGFunctionInfoENS_10GlobalDeclERKNS_9ThunkInfoE")
//</editor-fold>
public final Function /*P*/ GenerateVarArgsThunk(Function /*P*/ Fn, 
                    final /*const*/ CGFunctionInfo /*&*/ FnInfo, 
                    GlobalDecl GD, final /*const*/ ThunkInfo /*&*/ Thunk) {
  ValueMap</*const*/ Value /*P*/ , WeakVH> VMap = null;
  try {
    /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(GD.getDecl());
    /*const*/ FunctionProtoType /*P*/ FPT = MD.getType().$arrow().getAs(FunctionProtoType.class);
    QualType ResultType = FPT.getReturnType();
    
    // Get the original function
    assert (FnInfo.isVariadic());
    org.llvm.ir.Type /*P*/ Ty = $this().CGM.getTypes().GetFunctionType(FnInfo);
    Value /*P*/ Callee = $this().CGM.GetAddrOfFunction(new GlobalDecl(GD), Ty, /*ForVTable=*/ true);
    Function /*P*/ BaseFn = cast_Function(Callee);
    
    // Clone to thunk.
    VMap/*J*/= new ValueMap</*const*/ Value /*P*/ , WeakVH>(new ValueMapConfig<Value>(Value.class), ()->new WeakVH());
    Function /*P*/ NewFn = TransformsLlvmGlobals.CloneFunction(BaseFn, VMap);
    Fn.replaceAllUsesWith(NewFn);
    NewFn.takeName(Fn);
    Fn.eraseFromParent();
    Fn = NewFn;
    
    // "Initialize" CGF (minimally).
    $this().CurFn = Fn;
    
    // Get the "this" value
    ilist_iterator<Argument> AI = Fn.arg_begin();
    if ($this().CGM.ReturnTypeUsesSRet(FnInfo)) {
      AI.$preInc();
    }
    
    // Find the first store of "this", which will be to the alloca associated
    // with "this".
    Address ThisPtr/*J*/= new Address($AddrOf(AI.$star()), $this().CGM.getClassPointerAlignment(MD.getParent$Const()));
    BasicBlock /*P*/ EntryBB = $AddrOf(Fn.front());
    ilist_iterator<Instruction> ThisStore = std.find_if(EntryBB.begin(), EntryBB.end(), /*[&, &ThisPtr]*/ (final Instruction /*&*/ I) -> {
              return isa_StoreInst(I)
                 && I.getOperand(0) == ThisPtr.getPointer();
            });
    assert (ThisStore.$noteq(EntryBB.end())) : "Store of this should be in entry block?";
    // Adjust "this", if necessary.
    $this().Builder.SetInsertPoint($AddrOf(ThisStore.$star()));
    Value /*P*/ AdjustedThisPtr = $this().CGM.getCXXABI().performThisAdjustment(/*Deref*/$this(), new Address(ThisPtr), Thunk.This);
    ThisStore.$arrow().setOperand(0, AdjustedThisPtr);
    if (!Thunk.Return.isEmpty()) {
      // Fix up the returned value, if necessary.
      for (final BasicBlock /*&*/ BB : $Deref(Fn)) {
        Instruction /*P*/ T = BB.getTerminator();
        if (isa_ReturnInst(T)) {
          RValue RV = RValue.get(T.getOperand(0));
          T.eraseFromParent();
          $this().Builder.SetInsertPoint($AddrOf(BB));
          RV.$assignMove(CGVTablesStatics.PerformReturnAdjustment(/*Deref*/$this(), new QualType(ResultType), new RValue(RV), Thunk));
          $this().Builder.CreateRet(RV.getScalarVal());
          break;
        }
      }
    }
    
    return Fn;
  } finally {
    if (VMap != null) { VMap.$destroy(); }
  }
}

} // END OF class CodeGenFunction_CGVTables
