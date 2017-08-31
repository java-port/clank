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
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.llvm.ir.java.IrRTTI.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGNVCUDARuntime">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp", line = 29,
 FQN="(anonymous namespace)::CGNVCUDARuntime", NM="_ZN12_GLOBAL__N_115CGNVCUDARuntimeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN12_GLOBAL__N_115CGNVCUDARuntimeE")
//</editor-fold>
public class CGNVCUDARuntime extends /*public*/ CGCUDARuntime implements Destructors.ClassWithDestructor {
/*private:*/
  private org.llvm.ir.Type /*P*/ IntTy;
  private org.llvm.ir.Type /*P*/ SizeTy;
  private org.llvm.ir.Type /*P*/ VoidTy;
  private org.llvm.ir.PointerType /*P*/ CharPtrTy;
  private org.llvm.ir.PointerType /*P*/ VoidPtrTy;
  private org.llvm.ir.PointerType /*P*/ VoidPtrPtrTy;
  
  /// Convenience reference to LLVM Context
  private final LLVMContext /*&*/ Context;
  /// Convenience reference to the current module
  private final org.llvm.ir.Module /*&*/ TheModule;
  /// Keeps track of kernel launch stubs emitted in this module
  private SmallVector<Function /*P*/ > EmittedKernels;
  private SmallVector<std.pairPtrUInt<GlobalVariable /*P*/ >> DeviceVars;
  /// Keeps track of variables containing handles of GPU binaries. Populated by
  /// ModuleCtorFunction() and used to create corresponding cleanup calls in
  /// ModuleDtorFunction()
  private SmallVector<GlobalVariable /*P*/ > GpuBinaryHandles;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGNVCUDARuntime::getSetupArgumentFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp", line = 99,
   FQN="(anonymous namespace)::CGNVCUDARuntime::getSetupArgumentFn", NM="_ZNK12_GLOBAL__N_115CGNVCUDARuntime18getSetupArgumentFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZNK12_GLOBAL__N_115CGNVCUDARuntime18getSetupArgumentFnEv")
  //</editor-fold>
  private Constant /*P*/ getSetupArgumentFn() /*const*/ {
    // cudaError_t cudaSetupArgument(void *, size_t, size_t)
    org.llvm.ir.Type /*P*/ Params[/*3*/] = new org.llvm.ir.Type /*P*/  [/*3*/] {VoidPtrTy, SizeTy, SizeTy};
    return CGM.CreateRuntimeFunction(org.llvm.ir.FunctionType.get(IntTy, 
            new ArrayRef<org.llvm.ir.Type /*P*/ >(Params, true), false), 
        new StringRef(/*KEEP_STR*/"cudaSetupArgument"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGNVCUDARuntime::getLaunchFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp", line = 107,
   FQN="(anonymous namespace)::CGNVCUDARuntime::getLaunchFn", NM="_ZNK12_GLOBAL__N_115CGNVCUDARuntime11getLaunchFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZNK12_GLOBAL__N_115CGNVCUDARuntime11getLaunchFnEv")
  //</editor-fold>
  private Constant /*P*/ getLaunchFn() /*const*/ {
    // cudaError_t cudaLaunch(char *)
    return CGM.CreateRuntimeFunction(org.llvm.ir.FunctionType.get(IntTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(CharPtrTy, true), false), new StringRef(/*KEEP_STR*/"cudaLaunch"));
  }

  
  /// Creates a function to register all kernel stubs generated in this module.
  
  /// Creates a function that sets up state on the host side for CUDA objects that
  /// have a presence on both the host and device sides. Specifically, registers
  /// the host side of kernel functions and device global variables with the CUDA
  /// runtime.
  /// \code
  /// void __cuda_register_globals(void** GpuBinaryHandle) {
  ///    __cudaRegisterFunction(GpuBinaryHandle,Kernel0,...);
  ///    ...
  ///    __cudaRegisterFunction(GpuBinaryHandle,KernelM,...);
  ///    __cudaRegisterVar(GpuBinaryHandle, GlobalVar0, ...);
  ///    ...
  ///    __cudaRegisterVar(GpuBinaryHandle, GlobalVarN, ...);
  /// }
  /// \endcode
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGNVCUDARuntime::makeRegisterGlobalsFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp", line = 177,
   FQN="(anonymous namespace)::CGNVCUDARuntime::makeRegisterGlobalsFn", NM="_ZN12_GLOBAL__N_115CGNVCUDARuntime21makeRegisterGlobalsFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN12_GLOBAL__N_115CGNVCUDARuntime21makeRegisterGlobalsFnEv")
  //</editor-fold>
  private Function /*P*/ makeRegisterGlobalsFn() {
    CGBuilderTy Builder = null;
    try {
      // No need to register anything
      if (EmittedKernels.empty() && DeviceVars.empty()) {
        return null;
      }
      
      Function /*P*/ RegisterKernelsFunc = Function.Create(org.llvm.ir.FunctionType.get(VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(VoidPtrPtrTy, true), false), 
          GlobalValue.LinkageTypes.InternalLinkage, new Twine(/*KEEP_STR*/"__cuda_register_globals"), $AddrOf(TheModule));
      BasicBlock /*P*/ EntryBB = BasicBlock.Create(Context, new Twine(/*KEEP_STR*/"entry"), RegisterKernelsFunc);
      Builder/*J*/= new CGBuilderTy(CGM, Context);
      Builder.SetInsertPoint(EntryBB);
      
      // void __cudaRegisterFunction(void **, const char *, char *, const char *,
      //                             int, uint3*, uint3*, dim3*, dim3*, int*)
      org.llvm.ir.Type /*P*/ RegisterFuncParams[/*10*/] = new org.llvm.ir.Type /*P*/  [/*10*/] {
        VoidPtrPtrTy, CharPtrTy, CharPtrTy, CharPtrTy, IntTy, 
        VoidPtrTy, VoidPtrTy, VoidPtrTy, VoidPtrTy, IntTy.getPointerTo()};
      Constant /*P*/ RegisterFunc = CGM.CreateRuntimeFunction(org.llvm.ir.FunctionType.get(IntTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(RegisterFuncParams, true), false), 
          new StringRef(/*KEEP_STR*/"__cudaRegisterFunction"));
      
      // Extract GpuBinaryHandle passed as the first argument passed to
      // __cuda_register_globals() and generate __cudaRegisterFunction() call for
      // each emitted kernel.
      final Argument /*&*/ GpuBinaryHandlePtr = RegisterKernelsFunc.arg_begin().$star();
      for (Function /*P*/ Kernel : EmittedKernels) {
        Constant /*P*/ KernelName = makeConstantString(Kernel.getName().$string());
        Constant /*P*/ NullPtr = ConstantPointerNull.get(VoidPtrTy);
        Value /*P*/ Args[/*10*/] = new Value /*P*/  [/*10*/] {
          $AddrOf(GpuBinaryHandlePtr), Builder.CreateBitCast(Kernel, VoidPtrTy), 
          KernelName, KernelName, ConstantInt.get(IntTy, $int2ulong(-1)), NullPtr, 
          NullPtr, NullPtr, NullPtr, 
          ConstantPointerNull.get(IntTy.getPointerTo())};
        Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(RegisterFunc, new ArrayRef<Value /*P*/ >(Args, true));
      }
      
      // void __cudaRegisterVar(void **, char *, char *, const char *,
      //                        int, int, int, int)
      org.llvm.ir.Type /*P*/ RegisterVarParams[/*8*/] = new org.llvm.ir.Type /*P*/  [/*8*/] {
        VoidPtrPtrTy, CharPtrTy, CharPtrTy, 
        CharPtrTy, IntTy, IntTy, 
        IntTy, IntTy};
      Constant /*P*/ RegisterVar = CGM.CreateRuntimeFunction(org.llvm.ir.FunctionType.get(IntTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(RegisterVarParams, true), false), 
          new StringRef(/*KEEP_STR*/"__cudaRegisterVar"));
      for (final std.pairPtrUInt<GlobalVariable /*P*/ > /*&*/ Pair : DeviceVars) {
        GlobalVariable /*P*/ Var = Pair.first;
        /*uint*/int Flags = Pair.second;
        Constant /*P*/ VarName = makeConstantString(Var.getName().$string());
        long/*uint64_t*/ VarSize = CGM.getDataLayout().getTypeAllocSize(Var.getValueType());
        Value /*P*/ Args[/*8*/] = new Value /*P*/  [/*8*/] {
          $AddrOf(GpuBinaryHandlePtr), 
          Builder.CreateBitCast(Var, VoidPtrTy), 
          VarName, 
          VarName, 
          ConstantInt.get(IntTy, $int2ulong(((Flags & DeviceVarFlags.ExternDeviceVar) != 0) ? 1 : 0)), 
          ConstantInt.get(IntTy, VarSize), 
          ConstantInt.get(IntTy, $int2ulong(((Flags & DeviceVarFlags.ConstantDeviceVar) != 0) ? 1 : 0)), 
          ConstantInt.get(IntTy, $int2ulong(0))};
        Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(RegisterVar, new ArrayRef<Value /*P*/ >(Args, true));
      }
      
      Builder.CreateRetVoid();
      return RegisterKernelsFunc;
    } finally {
      if (Builder != null) { Builder.$destroy(); }
    }
  }

  
  /// Helper function that generates a constant string and returns a pointer to
  /// the start of the string.  The result of this function can be used anywhere
  /// where the C code specifies const char*.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGNVCUDARuntime::makeConstantString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp", line = 56,
   FQN="(anonymous namespace)::CGNVCUDARuntime::makeConstantString", NM="_ZN12_GLOBAL__N_115CGNVCUDARuntime18makeConstantStringERKSsS2_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN12_GLOBAL__N_115CGNVCUDARuntime18makeConstantStringERKSsS2_j")
  //</editor-fold>
  private Constant /*P*/ makeConstantString(final /*const*/std.string/*&*/ Str) {
    return makeConstantString(Str, 
                    new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY), 
                    0);
  }
  private Constant /*P*/ makeConstantString(final /*const*/std.string/*&*/ Str, 
                    final /*const*/std.string/*&*/ Name/*= ""*/) {
    return makeConstantString(Str, 
                    Name, 
                    0);
  }
  private Constant /*P*/ makeConstantString(final /*const*/std.string/*&*/ Str, 
                    final /*const*/std.string/*&*/ Name/*= ""*/, 
                    /*uint*/int Alignment/*= 0*/) {
    Constant /*P*/ Zeros[/*2*/] = new Constant /*P*/  [/*2*/] {
      ConstantInt.get(SizeTy, $int2ulong(0)), 
      ConstantInt.get(SizeTy, $int2ulong(0))};
    ConstantAddress ConstStr = CGM.GetAddrOfConstantCString(Str, Name.c_str());
    return ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P(ConstStr.getElementType(), 
        ConstStr.getPointer(), new ArrayRef<Constant /*P*/ >(Zeros, true));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGNVCUDARuntime::emitDeviceStubBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp", line = 119,
   FQN="(anonymous namespace)::CGNVCUDARuntime::emitDeviceStubBody", NM="_ZN12_GLOBAL__N_115CGNVCUDARuntime18emitDeviceStubBodyERN5clang7CodeGen15CodeGenFunctionERNS2_15FunctionArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN12_GLOBAL__N_115CGNVCUDARuntime18emitDeviceStubBodyERN5clang7CodeGen15CodeGenFunctionERNS2_15FunctionArgListE")
  //</editor-fold>
  private void emitDeviceStubBody(final CodeGenFunction /*&*/ CGF, 
                    final FunctionArgList /*&*/ Args) {
    std.vector<org.llvm.ir.Type /*P*/ > ArgTypes = null;
    try {
      // Build the argument value list and the argument stack struct type.
      SmallVector<Value /*P*/ > ArgValues/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
      ArgTypes/*J*/= new std.vector<org.llvm.ir.Type /*P*/ >((org.llvm.ir.Type /*P*/ )null);
      for (type$ptr</*const*/ VarDecl /*P*/ /*const*/ /*P*/> I = $tryClone(Args.begin()), /*P*/ E = $tryClone(Args.end());
           $noteq_ptr(I, E); I.$preInc()) {
        Value /*P*/ V = CGF.GetAddrOfLocalVar(I.$star()).getPointer();
        ArgValues.push_back(V);
        assert (isa_PointerType(V.getType())) : "Arg type not PointerType";
        ArgTypes.push_back_T$RR(cast_PointerType(V.getType()).getElementType());
      }
      StructType /*P*/ ArgStackTy = StructType.get(Context, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgTypes, true));
      
      BasicBlock /*P*/ EndBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"setup.end"));
      
      // Emit the calls to cudaSetupArgument
      Constant /*P*/ cudaSetupArgFn = getSetupArgumentFn();
      for (/*uint*/int I = 0, E = Args.size(); I != E; ++I) {
        Value /*P*/ Args$1[/*3*/] = new Value /*P*/  [3];
        BasicBlock /*P*/ NextBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"setup.next"));
        Args$1[0] = CGF.Builder.CreatePointerCast(ArgValues.$at(I), VoidPtrTy);
        Args$1[1] = CGF.Builder.CreateIntCast(ConstantExpr.getSizeOf(ArgTypes.$at(I)), 
            SizeTy, false);
        Args$1[2] = CGF.Builder.CreateIntCast(ConstantExpr.getOffsetOf(ArgStackTy, I), 
            SizeTy, false);
        CallSite CS = CGF.EmitRuntimeCallOrInvoke(cudaSetupArgFn, new ArrayRef<Value /*P*/ >(Args$1, true));
        Constant /*P*/ Zero = ConstantInt.get(IntTy, $int2ulong(0));
        Value /*P*/ CSZero = CGF.Builder.CreateICmpEQ(CS.getInstruction(), Zero);
        CGF.Builder.CreateCondBr(CSZero, NextBlock, EndBlock);
        CGF.EmitBlock(NextBlock);
      }
      
      // Emit the call to cudaLaunch
      Constant /*P*/ cudaLaunchFn = getLaunchFn();
      Value /*P*/ Arg = CGF.Builder.CreatePointerCast(CGF.CurFn, CharPtrTy);
      CGF.EmitRuntimeCallOrInvoke(cudaLaunchFn, new ArrayRef<Value /*P*/ >(Arg, true));
      CGF.EmitBranch(EndBlock);
      
      CGF.EmitBlock(EndBlock);
    } finally {
      if (ArgTypes != null) { ArgTypes.$destroy(); }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGNVCUDARuntime::CGNVCUDARuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp", line = 84,
   FQN="(anonymous namespace)::CGNVCUDARuntime::CGNVCUDARuntime", NM="_ZN12_GLOBAL__N_115CGNVCUDARuntimeC1ERN5clang7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN12_GLOBAL__N_115CGNVCUDARuntimeC1ERN5clang7CodeGen13CodeGenModuleE")
  //</editor-fold>
  public CGNVCUDARuntime(final CodeGenModule /*&*/ CGM) {
    // : CGCUDARuntime(CGM), Context(CGM.getLLVMContext()), TheModule(CGM.getModule()), EmittedKernels(), DeviceVars(), GpuBinaryHandles() 
    //START JInit
    super(CGM);
    this./*&*/Context=/*&*/CGM.getLLVMContext();
    this./*&*/TheModule=/*&*/CGM.getModule();
    this.EmittedKernels = new SmallVector<Function /*P*/ >(16, (Function /*P*/ )null);
    this.DeviceVars = new SmallVector<std.pairPtrUInt<GlobalVariable /*P*/ >>(16, new std.pairPtrUInt<GlobalVariable /*P*/ >());
    this.GpuBinaryHandles = new SmallVector<GlobalVariable /*P*/ >(16, (GlobalVariable /*P*/ )null);
    //END JInit
    final CodeGenTypes /*&*/ Types = CGM.getTypes();
    final ASTContext /*&*/ Ctx = CGM.getContext();
    
    IntTy = Types.ConvertType(Ctx.IntTy.$QualType());
    SizeTy = Types.ConvertType(Ctx.getSizeType().$QualType());
    VoidTy = org.llvm.ir.Type.getVoidTy(Context);
    
    CharPtrTy = org.llvm.ir.PointerType.getUnqual(Types.ConvertType(Ctx.CharTy.$QualType()));
    VoidPtrTy = cast_PointerType(Types.ConvertType(Ctx.VoidPtrTy.$QualType()));
    VoidPtrPtrTy = VoidPtrTy.getPointerTo();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGNVCUDARuntime::emitDeviceStub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp", line = 113,
   FQN="(anonymous namespace)::CGNVCUDARuntime::emitDeviceStub", NM="_ZN12_GLOBAL__N_115CGNVCUDARuntime14emitDeviceStubERN5clang7CodeGen15CodeGenFunctionERNS2_15FunctionArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN12_GLOBAL__N_115CGNVCUDARuntime14emitDeviceStubERN5clang7CodeGen15CodeGenFunctionERNS2_15FunctionArgListE")
  //</editor-fold>
  @Override public void emitDeviceStub(final CodeGenFunction /*&*/ CGF, 
                final FunctionArgList /*&*/ Args)/* override*/ {
    EmittedKernels.push_back(CGF.CurFn);
    emitDeviceStubBody(CGF, Args);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGNVCUDARuntime::registerDeviceVar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp", line = 72,
   FQN="(anonymous namespace)::CGNVCUDARuntime::registerDeviceVar", NM="_ZN12_GLOBAL__N_115CGNVCUDARuntime17registerDeviceVarERN4llvm14GlobalVariableEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN12_GLOBAL__N_115CGNVCUDARuntime17registerDeviceVarERN4llvm14GlobalVariableEj")
  //</editor-fold>
  @Override public void registerDeviceVar(final GlobalVariable /*&*/ Var, /*uint*/int Flags)/* override*/ {
    DeviceVars.push_back(std.make_pair_Ptr_uint($AddrOf(Var), Flags));
  }

  
  /// Creates module constructor function
  
  /// Creates a global constructor function for the module:
  /// \code
  /// void __cuda_module_ctor(void*) {
  ///     Handle0 = __cudaRegisterFatBinary(GpuBinaryBlob0);
  ///     __cuda_register_globals(Handle0);
  ///     ...
  ///     HandleN = __cudaRegisterFatBinary(GpuBinaryBlobN);
  ///     __cuda_register_globals(HandleN);
  /// }
  /// \endcode
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGNVCUDARuntime::makeModuleCtorFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp", line = 254,
   FQN="(anonymous namespace)::CGNVCUDARuntime::makeModuleCtorFunction", NM="_ZN12_GLOBAL__N_115CGNVCUDARuntime22makeModuleCtorFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN12_GLOBAL__N_115CGNVCUDARuntime22makeModuleCtorFunctionEv")
  //</editor-fold>
  @Override public Function /*P*/ makeModuleCtorFunction()/* override*/ {
    CGBuilderTy CtorBuilder = null;
    try {
      // No need to generate ctors/dtors if there are no GPU binaries.
      if (CGM.getCodeGenOpts().CudaGpuBinaryFileNames.empty()) {
        return null;
      }
      
      // void __cuda_register_globals(void* handle);
      Function /*P*/ RegisterGlobalsFunc = makeRegisterGlobalsFn();
      // void ** __cudaRegisterFatBinary(void *);
      Constant /*P*/ RegisterFatbinFunc = CGM.CreateRuntimeFunction(org.llvm.ir.FunctionType.get(VoidPtrPtrTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(VoidPtrTy, true), false), 
          new StringRef(/*KEEP_STR*/"__cudaRegisterFatBinary"));
      // struct { int magic, int version, void * gpu_binary, void * dont_care };
      StructType /*P*/ FatbinWrapperTy = StructType.get(IntTy, IntTy, VoidPtrTy, VoidPtrTy, null);
      
      Function /*P*/ ModuleCtorFunc = Function.Create(org.llvm.ir.FunctionType.get(VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(VoidPtrTy, true), false), 
          GlobalValue.LinkageTypes.InternalLinkage, new Twine(/*KEEP_STR*/"__cuda_module_ctor"), $AddrOf(TheModule));
      BasicBlock /*P*/ CtorEntryBB = BasicBlock.Create(Context, new Twine(/*KEEP_STR*/"entry"), ModuleCtorFunc);
      CtorBuilder/*J*/= new CGBuilderTy(CGM, Context);
      
      CtorBuilder.SetInsertPoint(CtorEntryBB);
      
      // For each GPU binary, register it with the CUDA runtime and store returned
      // handle in a global variable and save the handle in GpuBinaryHandles vector
      // to be cleaned up in destructor on exit. Then associate all known kernels
      // with the GPU binary handle so CUDA runtime can figure out what to call on
      // the GPU side.
      for (final /*const*/std.string/*&*/ GpuBinaryFileName : CGM.getCodeGenOpts().CudaGpuBinaryFileNames) {
        ErrorOr<std.unique_ptr<MemoryBuffer> > GpuBinaryOrErr = null;
        try {
          GpuBinaryOrErr = MemoryBuffer.getFileOrSTDIN(new Twine(GpuBinaryFileName));
          {
            std.error_code EC = GpuBinaryOrErr.getError();
            if (EC.$bool()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(CGM.getDiags().Report(diag.err_cannot_open_file)), new StringRef(GpuBinaryFileName)), 
                    new StringRef(EC.message())));
                continue;
              } finally {
                $c$.$destroy();
              }
            }
          }
          
          // Create initialized wrapper structure that points to the loaded GPU binary
          Constant /*P*/ Values[/*4*/] = new Constant /*P*/  [/*4*/] {
            ConstantInt.get(IntTy, $int2ulong(0x466243b1)),  // Fatbin wrapper magic.
            ConstantInt.get(IntTy, $int2ulong(1)),  // Fatbin version.
            makeConstantString(GpuBinaryOrErr.get().$arrow().getBuffer().$string(), new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY), 16),  // Data.
            ConstantPointerNull.get(VoidPtrTy)}; // Unused in fatbin v1.
          GlobalVariable /*P*/ FatbinWrapper = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
              return new GlobalVariable(TheModule, FatbinWrapperTy, true, GlobalValue.LinkageTypes.InternalLinkage, 
              ConstantStruct.get(FatbinWrapperTy, new ArrayRef<Constant /*P*/ >(Values, true)), 
              new Twine(/*KEEP_STR*/"__cuda_fatbin_wrapper"));
           });
          // NVIDIA's cuobjdump looks for fatbins in this section.
          FatbinWrapper.setSection(new StringRef(/*KEEP_STR*/".nvFatBinSegment"));
          
          // GpuBinaryHandle = __cudaRegisterFatBinary(&FatbinWrapper);
          CallInst /*P*/ RegisterFatbinCall = CtorBuilder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(RegisterFatbinFunc, 
              new ArrayRef<Value /*P*/ >(CtorBuilder.CreateBitCast(FatbinWrapper, VoidPtrTy), true));
          GlobalVariable /*P*/ GpuBinaryHandle = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
              return new GlobalVariable(TheModule, VoidPtrPtrTy, false, GlobalValue.LinkageTypes.InternalLinkage, 
              ConstantPointerNull.get(VoidPtrPtrTy), new Twine(/*KEEP_STR*/"__cuda_gpubin_handle"));
           });
          CtorBuilder.CreateAlignedStore(RegisterFatbinCall, GpuBinaryHandle, 
              CGM.getPointerAlign());
          
          // Call __cuda_register_globals(GpuBinaryHandle);
          if ((RegisterGlobalsFunc != null)) {
            CtorBuilder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(RegisterGlobalsFunc, new ArrayRef<Value /*P*/ >(RegisterFatbinCall, true));
          }
          
          // Save GpuBinaryHandle so we can unregister it in destructor.
          GpuBinaryHandles.push_back(GpuBinaryHandle);
        } finally {
          if (GpuBinaryOrErr != null) { GpuBinaryOrErr.$destroy(); }
        }
      }
      
      CtorBuilder.CreateRetVoid();
      return ModuleCtorFunc;
    } finally {
      if (CtorBuilder != null) { CtorBuilder.$destroy(); }
    }
  }

  /// Creates module destructor function
  
  /// Creates a global destructor function that unregisters all GPU code blobs
  /// registered by constructor.
  /// \code
  /// void __cuda_module_dtor(void*) {
  ///     __cudaUnregisterFatBinary(Handle0);
  ///     ...
  ///     __cudaUnregisterFatBinary(HandleN);
  /// }
  /// \endcode
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGNVCUDARuntime::makeModuleDtorFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp", line = 337,
   FQN="(anonymous namespace)::CGNVCUDARuntime::makeModuleDtorFunction", NM="_ZN12_GLOBAL__N_115CGNVCUDARuntime22makeModuleDtorFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN12_GLOBAL__N_115CGNVCUDARuntime22makeModuleDtorFunctionEv")
  //</editor-fold>
  @Override public Function /*P*/ makeModuleDtorFunction()/* override*/ {
    CGBuilderTy DtorBuilder = null;
    try {
      // No need for destructor if we don't have handles to unregister.
      if (GpuBinaryHandles.empty()) {
        return null;
      }
      
      // void __cudaUnregisterFatBinary(void ** handle);
      Constant /*P*/ UnregisterFatbinFunc = CGM.CreateRuntimeFunction(org.llvm.ir.FunctionType.get(VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(VoidPtrPtrTy, true), false), 
          new StringRef(/*KEEP_STR*/"__cudaUnregisterFatBinary"));
      
      Function /*P*/ ModuleDtorFunc = Function.Create(org.llvm.ir.FunctionType.get(VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(VoidPtrTy, true), false), 
          GlobalValue.LinkageTypes.InternalLinkage, new Twine(/*KEEP_STR*/"__cuda_module_dtor"), $AddrOf(TheModule));
      BasicBlock /*P*/ DtorEntryBB = BasicBlock.Create(Context, new Twine(/*KEEP_STR*/"entry"), ModuleDtorFunc);
      DtorBuilder/*J*/= new CGBuilderTy(CGM, Context);
      DtorBuilder.SetInsertPoint(DtorEntryBB);
      
      for (GlobalVariable /*P*/ GpuBinaryHandle : GpuBinaryHandles) {
        LoadInst /*P*/ HandleValue = DtorBuilder.CreateAlignedLoad(GpuBinaryHandle, CGM.getPointerAlign());
        DtorBuilder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(UnregisterFatbinFunc, new ArrayRef<Value /*P*/ >(HandleValue, true));
      }
      
      DtorBuilder.CreateRetVoid();
      return ModuleDtorFunc;
    } finally {
      if (DtorBuilder != null) { DtorBuilder.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGNVCUDARuntime::~CGNVCUDARuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp", line = 29,
   FQN="(anonymous namespace)::CGNVCUDARuntime::~CGNVCUDARuntime", NM="_ZN12_GLOBAL__N_115CGNVCUDARuntimeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN12_GLOBAL__N_115CGNVCUDARuntimeD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    GpuBinaryHandles.$destroy();
    DeviceVars.$destroy();
    EmittedKernels.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "IntTy=" + IntTy // NOI18N
              + ", SizeTy=" + SizeTy // NOI18N
              + ", VoidTy=" + VoidTy // NOI18N
              + ", CharPtrTy=" + CharPtrTy // NOI18N
              + ", VoidPtrTy=" + VoidPtrTy // NOI18N
              + ", VoidPtrPtrTy=" + VoidPtrPtrTy // NOI18N
              + ", Context=" + "[LLVMContext]" // NOI18N
              + ", TheModule=" + TheModule // NOI18N
              + ", EmittedKernels=" + EmittedKernels // NOI18N
              + ", DeviceVars=" + DeviceVars // NOI18N
              + ", GpuBinaryHandles=" + GpuBinaryHandles // NOI18N
              + super.toString(); // NOI18N
  }
}
