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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.impl.CGDeclCXXStatics;
import org.llvm.ir.FunctionType;
import org.llvm.ir.Type;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_CGDeclCXX">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_CGDeclCXX",        
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_CGDecl ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16createAtExitStubERKNS_7VarDeclEPN4llvm8ConstantES7_;_ZN5clang7CodeGen15CodeGenFunction18EmitCXXGuardedInitERKNS_7VarDeclEPN4llvm14GlobalVariableEb;_ZN5clang7CodeGen15CodeGenFunction21generateDestroyHelperENS0_7AddressENS_8QualTypeEPFvRS1_S2_S3_EbPKNS_7VarDeclE;_ZN5clang7CodeGen15CodeGenFunction24EmitCXXGlobalVarDeclInitERKNS_7VarDeclEPN4llvm8ConstantEb;_ZN5clang7CodeGen15CodeGenFunction25GenerateCXXGlobalInitFuncEPN4llvm8FunctionENS2_8ArrayRefIS4_EENS0_7AddressE;_ZN5clang7CodeGen15CodeGenFunction26GenerateCXXGlobalDtorsFuncEPN4llvm8FunctionERKSt6vectorISt4pairINS2_6WeakVHEPNS2_8ConstantEESaISA_EE;_ZN5clang7CodeGen15CodeGenFunction28registerGlobalDtorWithAtExitERKNS_7VarDeclEPN4llvm8ConstantES7_;_ZN5clang7CodeGen15CodeGenFunction32GenerateCXXGlobalVarDeclInitFuncEPN4llvm8FunctionEPKNS_7VarDeclEPNS2_14GlobalVariableEb; -static-type=CodeGenFunction_CGDeclCXX -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_CGDeclCXX extends CodeGenFunction_CGDecl {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_CGDeclCXX(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}


/// generateDestroyHelper - Generates a helper function which, when
/// invoked, destroys the given object.  The address of the object
/// should be in global memory.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::generateDestroyHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp", line = 601,
 FQN="clang::CodeGen::CodeGenFunction::generateDestroyHelper", NM="_ZN5clang7CodeGen15CodeGenFunction21generateDestroyHelperENS0_7AddressENS_8QualTypeEPFvRS1_S2_S3_EbPKNS_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21generateDestroyHelperENS0_7AddressENS_8QualTypeEPFvRS1_S2_S3_EbPKNS_7VarDeclE")
//</editor-fold>
public final Function /*P*/ generateDestroyHelper(Address addr, QualType type, CodeGenFunction.AddressQualType2Void destroyer, 
                     boolean useEHCleanupForArray, /*const*/ VarDecl /*P*/ VD) {
  FunctionArgList args = null;
  ImplicitParamDecl dst = null;
  try {
    args/*J*/= new FunctionArgList();
    dst/*J*/= new ImplicitParamDecl($this().getContext(), (DeclContext /*P*/ )null, new SourceLocation(), (IdentifierInfo /*P*/ )null, 
        $this().getContext().VoidPtrTy.$QualType());
    args.push_back($AddrOf(dst));
    
    final /*const*/ CGFunctionInfo /*&*/ FI = $this().CGM.getTypes().arrangeBuiltinFunctionDeclaration($this().getContext().VoidTy.$QualType(), args);
    org.llvm.ir.FunctionType /*P*/ FTy = $this().CGM.getTypes().GetFunctionType(FI);
    Function /*P*/ fn = $this().CGM.CreateGlobalInitOrDestructFunction(FTy, new Twine(/*KEEP_STR*/"__cxx_global_array_dtor"), FI, VD.getLocation());
    
    $this().CurEHLocation.$assignMove(VD.getLocStart());
    
    $this().StartFunction(new GlobalDecl(VD), $this().getContext().VoidTy.$QualType(), fn, FI, args);
    
    $this().emitDestroy(new Address(addr), new QualType(type), destroyer, useEHCleanupForArray);
    
    $this().FinishFunction();
    
    return fn;
  } finally {
    if (dst != null) { dst.$destroy(); }
    if (args != null) { args.$destroy(); }
  }
}


/// EmitCXXGlobalVarDeclInit - Create the initializer for a C++
/// variable with global storage.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXGlobalVarDeclInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp", line = 140,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXGlobalVarDeclInit", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitCXXGlobalVarDeclInitERKNS_7VarDeclEPN4llvm8ConstantEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitCXXGlobalVarDeclInitERKNS_7VarDeclEPN4llvm8ConstantEb")
//</editor-fold>
public final void EmitCXXGlobalVarDeclInit(final /*const*/ VarDecl /*&*/ D, 
                        Constant /*P*/ DeclPtr, 
                        boolean PerformInit) {
  
  /*const*/ Expr /*P*/ Init = D.getInit$Const();
  QualType T = D.getType();
  
  // The address space of a static local variable (DeclPtr) may be different
  // from the address space of the "this" argument of the constructor. In that
  // case, we need an addrspacecast before calling the constructor.
  //
  // struct StructWithCtor {
  //   __device__ StructWithCtor() {...}
  // };
  // __device__ void foo() {
  //   __shared__ StructWithCtor s;
  //   ...
  // }
  //
  // For example, in the above CUDA code, the static local variable s has a
  // "shared" address space qualifier, but the constructor of StructWithCtor
  // expects "this" in the "generic" address space.
  /*uint*/int ExpectedAddrSpace = $this().getContext().getTargetAddressSpace(new QualType(T));
  /*uint*/int ActualAddrSpace = DeclPtr.getType().getPointerAddressSpace();
  if (ActualAddrSpace != ExpectedAddrSpace) {
    org.llvm.ir.Type /*P*/ LTy = $this().CGM.getTypes().ConvertTypeForMem(new QualType(T));
    org.llvm.ir.PointerType /*P*/ PTy = org.llvm.ir.PointerType.get(LTy, ExpectedAddrSpace);
    DeclPtr = ConstantExpr.getAddrSpaceCast(DeclPtr, PTy);
  }
  
  ConstantAddress DeclAddr/*J*/= new ConstantAddress(DeclPtr, $this().getContext().getDeclAlign($AddrOf(D)));
  if (!T.$arrow().isReferenceType()) {
    if (($this().getLangOpts().OpenMP != 0) && D.hasAttr(OMPThreadPrivateDeclAttr.class)) {
      /*J:(void)*/$this().CGM.getOpenMPRuntime().emitThreadPrivateVarDefinition($AddrOf(D), new Address(DeclAddr), D.getAttr(OMPThreadPrivateDeclAttr.class).getLocation(), 
          PerformInit, $this());
    }
    if (PerformInit) {
      CGDeclCXXStatics.EmitDeclInit(/*Deref*/$this(), D, new ConstantAddress(DeclAddr));
    }
    if ($this().CGM.isTypeConstant(D.getType(), true)) {
      CGDeclCXXStatics.EmitDeclInvariant(/*Deref*/$this(), D, DeclPtr);
    } else {
      CGDeclCXXStatics.EmitDeclDestroy(/*Deref*/$this(), D, new ConstantAddress(DeclAddr));
    }
    return;
  }
  assert (PerformInit) : "cannot have constant initializer which needs destruction for reference";
  RValue RV = $this().EmitReferenceBindingToExpr(Init);
  $this().EmitStoreOfScalar(RV.getScalarVal(), new Address(DeclAddr), false, new QualType(T));
}


/// Create a stub function, suitable for being passed to atexit,
/// which passes the given address to the given destructor function.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::createAtExitStub">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp", line = 194,
 FQN="clang::CodeGen::CodeGenFunction::createAtExitStub", NM="_ZN5clang7CodeGen15CodeGenFunction16createAtExitStubERKNS_7VarDeclEPN4llvm8ConstantES7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16createAtExitStubERKNS_7VarDeclEPN4llvm8ConstantES7_")
//</editor-fold>
public final Constant /*P*/ createAtExitStub(final /*const*/ VarDecl /*&*/ VD, 
                Constant /*P*/ dtor, 
                Constant /*P*/ addr) {
  CodeGenFunction CGF = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Get the destructor function type, void(*)(void).
    org.llvm.ir.FunctionType /*P*/ ty = org.llvm.ir.FunctionType.get($this().CGM.VoidTy, false);
    SmallString/*<256>*/ FnName/*J*/= new SmallString/*<256>*/(256);
    {
      raw_svector_ostream Out = null;
      try {
        Out/*J*/= new raw_svector_ostream(FnName);
        $this().CGM.getCXXABI().getMangleContext().mangleDynamicAtExitDestructor($AddrOf(VD), Out);
      } finally {
        if (Out != null) { Out.$destroy(); }
      }
    }
    
    final /*const*/ CGFunctionInfo /*&*/ FI = $this().CGM.getTypes().arrangeNullaryFunction();
    Function /*P*/ fn = $this().CGM.CreateGlobalInitOrDestructFunction(ty, new Twine(FnName.str()), 
        FI, 
        VD.getLocation());
    
    CGF/*J*/= new CodeGenFunction($this().CGM);
    
    CGF.StartFunction(new GlobalDecl($AddrOf(VD)), $this().CGM.getContext().VoidTy.$QualType(), fn, FI, $c$.track(new FunctionArgList())); $c$.clean();
    
    CallInst /*P*/ call = CGF.Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(dtor, new ArrayRef<Value /*P*/ >(addr, true));
    {
      
      // Make sure the call and the callee agree on calling convention.
      Function /*P*/ dtorFn = dyn_cast_Function(dtor.stripPointerCasts());
      if ((dtorFn != null)) {
        call.setCallingConv(dtorFn.getCallingConv());
      }
    }
    
    CGF.FinishFunction();
    
    return fn;
  } finally {
    if (CGF != null) { CGF.$destroy(); }
    $c$.$destroy();
  }
}


/// Call atexit() with a function that passes the given argument to
/// the given function.

/// Register a global destructor using the C atexit runtime function.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::registerGlobalDtorWithAtExit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp", line = 227,
 FQN="clang::CodeGen::CodeGenFunction::registerGlobalDtorWithAtExit", NM="_ZN5clang7CodeGen15CodeGenFunction28registerGlobalDtorWithAtExitERKNS_7VarDeclEPN4llvm8ConstantES7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction28registerGlobalDtorWithAtExitERKNS_7VarDeclEPN4llvm8ConstantES7_")
//</editor-fold>
public final void registerGlobalDtorWithAtExit(final /*const*/ VarDecl /*&*/ VD, 
                            Constant /*P*/ dtor, 
                            Constant /*P*/ addr) {
  // Create a function which calls the destructor.
  Constant /*P*/ dtorStub = $this().createAtExitStub(VD, dtor, addr);
  
  // extern "C" int atexit(void (*f)(void));
  org.llvm.ir.FunctionType /*P*/ atexitTy = org.llvm.ir.FunctionType.get(IntTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(dtorStub.getType(), true), false);
  
  Constant /*P*/ atexit = $this().CGM.CreateRuntimeFunction(atexitTy, new StringRef(/*KEEP_STR*/"atexit"));
  {
    Function /*P*/ atexitFn = dyn_cast_Function(atexit);
    if ((atexitFn != null)) {
      atexitFn.setDoesNotThrow();
    }
  }
  
  $this().EmitNounwindRuntimeCall(atexit, new ArrayRef<Value /*P*/ >(dtorStub, true));
}


/// Emit code in this function to perform a guarded variable
/// initialization.  Guarded initializations are used when it's not
/// possible to prove that an initialization will be done exactly
/// once, e.g. with a static local variable or a static data member
/// of a class template.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXGuardedInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp", line = 245,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXGuardedInit", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitCXXGuardedInitERKNS_7VarDeclEPN4llvm14GlobalVariableEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitCXXGuardedInitERKNS_7VarDeclEPN4llvm14GlobalVariableEb")
//</editor-fold>
public final void EmitCXXGuardedInit(final /*const*/ VarDecl /*&*/ D, 
                  GlobalVariable /*P*/ DeclPtr, 
                  boolean PerformInit) {
  // If we've been asked to forbid guard variables, emit an error now.
  // This diagnostic is hard-coded for Darwin's use case;  we can find
  // better phrasing if someone else needs it.
  if ($this().CGM.getCodeGenOpts().ForbidGuardVariables) {
    $this().CGM.Error(D.getLocation(), 
        new StringRef(/*KEEP_STR*/"this initialization requires a guard variable, which the kernel does not support"));
  }
  
  $this().CGM.getCXXABI().EmitGuardedInit(/*Deref*/$this(), D, DeclPtr, PerformInit);
}


/// GenerateCXXGlobalInitFunc - Generates code for initializing global
/// variables.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GenerateCXXGlobalInitFunc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp", line = 522,
 FQN="clang::CodeGen::CodeGenFunction::GenerateCXXGlobalInitFunc", NM="_ZN5clang7CodeGen15CodeGenFunction25GenerateCXXGlobalInitFuncEPN4llvm8FunctionENS2_8ArrayRefIS4_EENS0_7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25GenerateCXXGlobalInitFuncEPN4llvm8FunctionENS2_8ArrayRefIS4_EENS0_7AddressE")
//</editor-fold>
public final void GenerateCXXGlobalInitFunc(Function /*P*/ Fn, 
                         ArrayRef<Function /*P*/ > Decls) {
  GenerateCXXGlobalInitFunc(Fn, 
                         Decls, 
                         Address.invalid());
}
public final void GenerateCXXGlobalInitFunc(Function /*P*/ Fn, 
                         ArrayRef<Function /*P*/ > Decls, 
                         Address Guard/*= Address::invalid()*/) {
  {
    ApplyDebugLocation NL = null;
    ApplyDebugLocation AL = null;
    RunCleanupsScope Scope = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      NL = ApplyDebugLocation.CreateEmpty(/*Deref*/$this());
      $this().StartFunction(new GlobalDecl(), $this().getContext().VoidTy.$QualType(), Fn, 
          $this().getTypes().arrangeNullaryFunction(), $c$.track(new FunctionArgList())); $c$.clean();
      // Emit an artificial location for this function.
      AL = ApplyDebugLocation.CreateArtificial(/*Deref*/$this());
      
      BasicBlock /*P*/ ExitBlock = null;
      if (Guard.isValid()) {
        // If we have a guard variable, check whether we've already performed
        // these initializations. This happens for TLS initialization functions.
        Value /*P*/ GuardVal = $this().Builder.CreateLoad(new Address(Guard));
        Value /*P*/ Uninit = $this().Builder.CreateIsNull(GuardVal, 
            new Twine(/*KEEP_STR*/"guard.uninitialized"));
        BasicBlock /*P*/ InitBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"init"));
        ExitBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"exit"));
        $this().Builder.CreateCondBr(Uninit, InitBlock, ExitBlock);
        $this().EmitBlock(InitBlock);
        // Mark as initialized before initializing anything else. If the
        // initializers use previously-initialized thread_local vars, that's
        // probably supposed to be OK, but the standard doesn't say.
        $this().Builder.CreateStore(ConstantInt.get(GuardVal.getType(), $int2ulong(1)), new Address(Guard));
      }
      
      Scope/*J*/= new RunCleanupsScope(/*Deref*/$this());
      
      // When building in Objective-C++ ARC mode, create an autorelease pool
      // around the global initializers.
      if ($this().getLangOpts().ObjCAutoRefCount && $this().getLangOpts().CPlusPlus) {
        Value /*P*/ token = $this().EmitObjCAutoreleasePoolPush();
        $this().EmitObjCAutoreleasePoolCleanup(token);
      }
      
      for (/*uint*/int i = 0, e = Decls.size(); i != e; ++i)  {
        if ((Decls.$at(i) != null)) {
          $this().EmitRuntimeCall(Decls.$at(i));
        }
      }
      
      Scope.ForceCleanup();
      if ((ExitBlock != null)) {
        $this().Builder.CreateBr(ExitBlock);
        $this().EmitBlock(ExitBlock);
      }
    } finally {
      if (Scope != null) { Scope.$destroy(); }
      if (AL != null) { AL.$destroy(); }
      if (NL != null) { NL.$destroy(); }
      $c$.$destroy();
    }
  }
  
  $this().FinishFunction();
}


/// GenerateCXXGlobalDtorsFunc - Generates code for destroying global
/// variables.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GenerateCXXGlobalDtorsFunc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp", line = 574,
 FQN="clang::CodeGen::CodeGenFunction::GenerateCXXGlobalDtorsFunc", NM="_ZN5clang7CodeGen15CodeGenFunction26GenerateCXXGlobalDtorsFuncEPN4llvm8FunctionERKSt6vectorISt4pairINS2_6WeakVHEPNS2_8ConstantEESaISA_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26GenerateCXXGlobalDtorsFuncEPN4llvm8FunctionERKSt6vectorISt4pairINS2_6WeakVHEPNS2_8ConstantEESaISA_EE")
//</editor-fold>
public final void GenerateCXXGlobalDtorsFunc(Function /*P*/ Fn, 
                          final /*const*/std.vector<std.pair<WeakVH, Constant /*P*/ >> /*&*/ DtorsAndObjects) {
  {
    ApplyDebugLocation NL = null;
    ApplyDebugLocation AL = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      NL = ApplyDebugLocation.CreateEmpty(/*Deref*/$this());
      $this().StartFunction(new GlobalDecl(), $this().getContext().VoidTy.$QualType(), Fn, 
          $this().getTypes().arrangeNullaryFunction(), $c$.track(new FunctionArgList())); $c$.clean();
      // Emit an artificial location for this function.
      AL = ApplyDebugLocation.CreateArtificial(/*Deref*/$this());
      
      // Emit the dtors, in reverse order from construction.
      for (/*uint*/int i = 0, e = DtorsAndObjects.size(); i != e; ++i) {
        Value /*P*/ Callee = DtorsAndObjects.$at$Const(e - i - 1).first.$Value$P();
        CallInst /*P*/ CI = $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(Callee, 
            new ArrayRef<Value /*P*/ >(DtorsAndObjects.$at$Const(e - i - 1).second, true));
        {
          // Make sure the call and the callee agree on calling convention.
          Function /*P*/ F = dyn_cast_Function(Callee);
          if ((F != null)) {
            CI.setCallingConv(F.getCallingConv());
          }
        }
      }
    } finally {
      if (AL != null) { AL.$destroy(); }
      if (NL != null) { NL.$destroy(); }
      $c$.$destroy();
    }
  }
  
  $this().FinishFunction();
}


/// Emit the code necessary to initialize the given global variable.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GenerateCXXGlobalVarDeclInitFunc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp", line = 495,
 FQN="clang::CodeGen::CodeGenFunction::GenerateCXXGlobalVarDeclInitFunc", NM="_ZN5clang7CodeGen15CodeGenFunction32GenerateCXXGlobalVarDeclInitFuncEPN4llvm8FunctionEPKNS_7VarDeclEPNS2_14GlobalVariableEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction32GenerateCXXGlobalVarDeclInitFuncEPN4llvm8FunctionEPKNS_7VarDeclEPNS2_14GlobalVariableEb")
//</editor-fold>
public final void GenerateCXXGlobalVarDeclInitFunc(Function /*P*/ Fn, 
                                /*const*/ VarDecl /*P*/ D, 
                                GlobalVariable /*P*/ Addr, 
                                boolean PerformInit) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Check if we need to emit debug info for variable initializer.
    if (D.hasAttr(NoDebugAttr.class)) {
      $this().DebugInfo = null; // disable debug info indefinitely for this function
    }
    
    $this().CurEHLocation.$assignMove(D.getLocStart());
    
    $this().StartFunction(new GlobalDecl(D), $this().getContext().VoidTy.$QualType(), Fn, 
        $this().getTypes().arrangeNullaryFunction(), 
        $c$.track(new FunctionArgList()), D.getLocation(), 
        D.getInit$Const().getExprLoc()); $c$.clean();
    
    // Use guarded initialization if the global variable is weak. This
    // occurs for, e.g., instantiated static data members and
    // definitions explicitly marked weak.
    if (Addr.hasWeakLinkage() || Addr.hasLinkOnceLinkage()) {
      $this().EmitCXXGuardedInit($Deref(D), Addr, PerformInit);
    } else {
      $this().EmitCXXGlobalVarDeclInit($Deref(D), Addr, PerformInit);
    }
    
    $this().FinishFunction();
  } finally {
    $c$.$destroy();
  }
}

} // END OF class CodeGenFunction_CGDeclCXX
