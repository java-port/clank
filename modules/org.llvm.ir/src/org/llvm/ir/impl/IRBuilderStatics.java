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
package org.llvm.ir.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type IRBuilderStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.IRBuilderStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=Tpl__ZL17getStatepointArgsRN4llvm13IRBuilderBaseEyjPNS_5ValueEjNS_8ArrayRefIT_EENS4_IT0_EENS4_IT1_EENS4_IT2_EE;Tpl__ZL28CreateGCStatepointCallCommonPN4llvm13IRBuilderBaseEyjPNS_5ValueEjNS_8ArrayRefIT_EENS4_IT0_EENS4_IT1_EENS4_IT2_EERKNS_5TwineE;Tpl__ZL30CreateGCStatepointInvokeCommonPN4llvm13IRBuilderBaseEyjPNS_5ValueEPNS_10BasicBlockES5_jNS_8ArrayRefIT_EENS6_IT0_EENS6_IT1_EENS6_IT2_EERKNS_5TwineE;_ZL16createCallHelperPN4llvm5ValueENS_8ArrayRefIS1_EEPNS_13IRBuilderBaseERKNS_5TwineE;_ZL18createInvokeHelperPN4llvm5ValueEPNS_10BasicBlockES3_NS_8ArrayRefIS1_EEPNS_13IRBuilderBaseERKNS_5TwineE; -static-type=IRBuilderStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class IRBuilderStatics {

//<editor-fold defaultstate="collapsed" desc="createCallHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 59,
 FQN="createCallHelper", NM="_ZL16createCallHelperPN4llvm5ValueENS_8ArrayRefIS1_EEPNS_13IRBuilderBaseERKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZL16createCallHelperPN4llvm5ValueENS_8ArrayRefIS1_EEPNS_13IRBuilderBaseERKNS_5TwineE")
//</editor-fold>
public static CallInst /*P*/ createCallHelper(Value /*P*/ Callee, ArrayRef<Value /*P*/ > Ops, 
                IRBuilderBase /*P*/ Builder) {
  return createCallHelper(Callee, Ops, 
                Builder, 
                new Twine(/*KEEP_STR*/$EMPTY));
}
public static CallInst /*P*/ createCallHelper(Value /*P*/ Callee, ArrayRef<Value /*P*/ > Ops, 
                IRBuilderBase /*P*/ Builder, 
                final /*const*/ Twine /*&*/ Name/*= ""*/) {
  CallInst /*P*/ CI = CallInst.Create_Value2(Callee, new ArrayRef<Value /*P*/ >(Ops), Name);
  Builder.GetInsertBlock().getInstList().insert_ilist_iterator$NodeTy_T$P(Builder.GetInsertPoint(), CI);
  Builder.SetInstDebugLocation(CI);
  return CI;
}

//<editor-fold defaultstate="collapsed" desc="createInvokeHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 68,
 FQN="createInvokeHelper", NM="_ZL18createInvokeHelperPN4llvm5ValueEPNS_10BasicBlockES3_NS_8ArrayRefIS1_EEPNS_13IRBuilderBaseERKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZL18createInvokeHelperPN4llvm5ValueEPNS_10BasicBlockES3_NS_8ArrayRefIS1_EEPNS_13IRBuilderBaseERKNS_5TwineE")
//</editor-fold>
public static InvokeInst /*P*/ createInvokeHelper(Value /*P*/ Invokee, BasicBlock /*P*/ NormalDest, 
                  BasicBlock /*P*/ UnwindDest, 
                  ArrayRef<Value /*P*/ > Ops, 
                  IRBuilderBase /*P*/ Builder) {
  return createInvokeHelper(Invokee, NormalDest, 
                  UnwindDest, 
                  Ops, 
                  Builder, 
                  new Twine(/*KEEP_STR*/$EMPTY));
}
public static InvokeInst /*P*/ createInvokeHelper(Value /*P*/ Invokee, BasicBlock /*P*/ NormalDest, 
                  BasicBlock /*P*/ UnwindDest, 
                  ArrayRef<Value /*P*/ > Ops, 
                  IRBuilderBase /*P*/ Builder, 
                  final /*const*/ Twine /*&*/ Name/*= ""*/) {
  InvokeInst /*P*/ II = InvokeInst.Create1(Invokee, NormalDest, UnwindDest, new ArrayRef<Value /*P*/ >(Ops), Name);
  Builder.GetInsertBlock().getInstList().insert_ilist_iterator$NodeTy_T$P(Builder.GetInsertPoint(), 
      II);
  Builder.SetInstDebugLocation(II);
  return II;
}

//template <typename T0 = Value *, typename T1 = Value *, typename T2 = Value *, typename T3 = Value *> 
//<editor-fold defaultstate="collapsed" desc="getStatepointArgs">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 312,
 FQN="getStatepointArgs", NM="_ZL17getStatepointArgsIPN4llvm5ValueES2_S2_S2_ESt6vectorIS2_SaIS2_EERNS0_13IRBuilderBaseEyjS2_jNS0_8ArrayRefIT_EENS8_IT0_EENS8_IT1_EENS8_IT2_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZL17getStatepointArgsIPN4llvm5ValueES2_S2_S2_ESt6vectorIS2_SaIS2_EERNS0_13IRBuilderBaseEyjS2_jNS0_8ArrayRefIT_EENS8_IT0_EENS8_IT1_EENS8_IT2_EE")
//</editor-fold>
public static std.vector<Value /*P*/ > getStatepointArgs$Value(final IRBuilderBase /*&*/ B, long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, 
                 Value /*P*/ ActualCallee, /*uint32_t*/int Flags, ArrayRef<Value /*P*/ > CallArgs, 
                 ArrayRef<Value /*P*/ > TransitionArgs, ArrayRef<Value /*P*/ > DeoptArgs, 
                 ArrayRef<Value /*P*/ > GCArgs) {
  std.vector<Value /*P*/ > Args = null;
  try {
    Args/*J*/= new std.vector<Value /*P*/ >((Value /*P*/ )null);
    Args.push_back_T$RR(B.getInt64(ID));
    Args.push_back_T$RR(B.getInt32(NumPatchBytes));
    Args.push_back_T$C$R(ActualCallee);
    Args.push_back_T$RR(B.getInt32(CallArgs.size()));
    Args.push_back_T$RR(B.getInt32(Flags));
    Args.insert$T(new std.vector.iterator</*const*/ Value /*P*/ >(Args.end()), CallArgs.begin(), CallArgs.end());
    Args.push_back_T$RR(B.getInt32(TransitionArgs.size()));
    Args.insert$T(new std.vector.iterator</*const*/ Value /*P*/ >(Args.end()), TransitionArgs.begin(), TransitionArgs.end());
    Args.push_back_T$RR(B.getInt32(DeoptArgs.size()));
    Args.insert$T(new std.vector.iterator</*const*/ Value /*P*/ >(Args.end()), DeoptArgs.begin(), DeoptArgs.end());
    Args.insert$T(new std.vector.iterator</*const*/ Value /*P*/ >(Args.end()), GCArgs.begin(), GCArgs.end());
    
    return new std.vector<Value /*P*/ >(JD$Move.INSTANCE, Args);
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}
//template <typename T0 = Use, typename T1 = Use, typename T2 = Use, typename T3 = Value *> 
//<editor-fold defaultstate="collapsed" desc="getStatepointArgs">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 312,
 FQN="getStatepointArgs", NM="_ZL17getStatepointArgsIN4llvm3UseES1_S1_PNS0_5ValueEESt6vectorIS3_SaIS3_EERNS0_13IRBuilderBaseEyjS3_jNS0_8ArrayRefIT_EENS9_IT0_EENS9_IT1_EENS9_IT2_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZL17getStatepointArgsIN4llvm3UseES1_S1_PNS0_5ValueEESt6vectorIS3_SaIS3_EERNS0_13IRBuilderBaseEyjS3_jNS0_8ArrayRefIT_EENS9_IT0_EENS9_IT1_EENS9_IT2_EE")
//</editor-fold>
public static std.vector<Value /*P*/ > getStatepointArgs$Use(final IRBuilderBase /*&*/ B, long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, 
                 Value /*P*/ ActualCallee, /*uint32_t*/int Flags, ArrayRef<Use> CallArgs, 
                 ArrayRef<Use> TransitionArgs, ArrayRef<Use> DeoptArgs, 
                 ArrayRef<Value /*P*/ > GCArgs) {
  std.vector<Value /*P*/ > Args = null;
  try {
    Args/*J*/= new std.vector<Value /*P*/ >((Value /*P*/ )null);
    Args.push_back_T$RR(B.getInt64(ID));
    Args.push_back_T$RR(B.getInt32(NumPatchBytes));
    Args.push_back_T$C$R(ActualCallee);
    Args.push_back_T$RR(B.getInt32(CallArgs.size()));
    Args.push_back_T$RR(B.getInt32(Flags));
    Args.insert$T(new std.vector.iterator</*const*/ Value /*P*/ >(Args.end()), CallArgs.begin(), CallArgs.end(), (Use u)->u.get());
    Args.push_back_T$RR(B.getInt32(TransitionArgs.size()));
    Args.insert$T(new std.vector.iterator</*const*/ Value /*P*/ >(Args.end()), TransitionArgs.begin(), TransitionArgs.end(), (Use u)->u.get());
    Args.push_back_T$RR(B.getInt32(DeoptArgs.size()));
    Args.insert$T(new std.vector.iterator</*const*/ Value /*P*/ >(Args.end()), DeoptArgs.begin(), DeoptArgs.end(), (Use u)->u.get());
    Args.insert$T(new std.vector.iterator</*const*/ Value /*P*/ >(Args.end()), GCArgs.begin(), GCArgs.end());
    
    return new std.vector<Value /*P*/ >(JD$Move.INSTANCE, Args);
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}
//template <typename T0 = Use, typename T1 = Value *, typename T2 = Value *, typename T3 = Value *> 
//<editor-fold defaultstate="collapsed" desc="getStatepointArgs">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 312,
 FQN="getStatepointArgs", NM="_ZL17getStatepointArgsIN4llvm3UseEPNS0_5ValueES3_S3_ESt6vectorIS3_SaIS3_EERNS0_13IRBuilderBaseEyjS3_jNS0_8ArrayRefIT_EENS9_IT0_EENS9_IT1_EENS9_IT2_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZL17getStatepointArgsIN4llvm3UseEPNS0_5ValueES3_S3_ESt6vectorIS3_SaIS3_EERNS0_13IRBuilderBaseEyjS3_jNS0_8ArrayRefIT_EENS9_IT0_EENS9_IT1_EENS9_IT2_EE")
//</editor-fold>
public static std.vector<Value /*P*/ > getStatepointArgs$UseValue(final IRBuilderBase /*&*/ B, long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, 
                 Value /*P*/ ActualCallee, /*uint32_t*/int Flags, ArrayRef<Use> CallArgs, 
                 ArrayRef<Value /*P*/ > TransitionArgs, ArrayRef<Value /*P*/ > DeoptArgs, 
                 ArrayRef<Value /*P*/ > GCArgs) {
  std.vector<Value /*P*/ > Args = null;
  try {
    Args/*J*/= new std.vector<Value /*P*/ >((Value /*P*/ )null);
    Args.push_back_T$RR(B.getInt64(ID));
    Args.push_back_T$RR(B.getInt32(NumPatchBytes));
    Args.push_back_T$C$R(ActualCallee);
    Args.push_back_T$RR(B.getInt32(CallArgs.size()));
    Args.push_back_T$RR(B.getInt32(Flags));
    Args.insert$T(new std.vector.iterator</*const*/ Value /*P*/ >(Args.end()), CallArgs.begin(), CallArgs.end(), (Use u)->u.get());
    Args.push_back_T$RR(B.getInt32(TransitionArgs.size()));
    Args.insert$T(new std.vector.iterator</*const*/ Value /*P*/ >(Args.end()), TransitionArgs.begin(), TransitionArgs.end());
    Args.push_back_T$RR(B.getInt32(DeoptArgs.size()));
    Args.insert$T(new std.vector.iterator</*const*/ Value /*P*/ >(Args.end()), DeoptArgs.begin(), DeoptArgs.end());
    Args.insert$T(new std.vector.iterator</*const*/ Value /*P*/ >(Args.end()), GCArgs.begin(), GCArgs.end());
    
    return new std.vector<Value /*P*/ >(JD$Move.INSTANCE, Args);
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}
///*template <typename T0, typename T1, typename T2, typename T3> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="getStatepointArgs">
//@Converted(kind = Converted.Kind.DELETED,
// source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 312,
// FQN="getStatepointArgs", NM="Tpl__ZL17getStatepointArgsRN4llvm13IRBuilderBaseEyjPNS_5ValueEjNS_8ArrayRefIT_EENS4_IT0_EENS4_IT1_EENS4_IT2_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=Tpl__ZL17getStatepointArgsRN4llvm13IRBuilderBaseEyjPNS_5ValueEjNS_8ArrayRefIT_EENS4_IT0_EENS4_IT1_EENS4_IT2_EE")
////</editor-fold>
//public static </*typename*/ T0, /*typename*/ T1, /*typename*/ T2, /*typename*/ T3> std.vector<Value /*P*/ > getStatepointArgs(final IRBuilderBase /*&*/ B, long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, 
//                 Value /*P*/ ActualCallee, /*uint32_t*/int Flags, ArrayRef<T0> CallArgs, 
//                 ArrayRef<T1> TransitionArgs, ArrayRef<T2> DeoptArgs, 
//                 ArrayRef<T3> GCArgs) {
//  std.vector<Value /*P*/ > Args = null;
//  try {
//    Args/*J*/= new std.vector<Value /*P*/ >((Value /*P*/ )null);
//    Args.push_back_T$RR(B.getInt64(ID));
//    Args.push_back_T$RR(B.getInt32(NumPatchBytes));
//    Args.push_back_T$C$R(ActualCallee);
//    Args.push_back(B.getInt32(CallArgs.size()));
//    Args.push_back_T$RR(B.getInt32(Flags));
//    Args.insert(Args.end(), CallArgs.begin(), CallArgs.end());
//    Args.push_back(B.getInt32(TransitionArgs.size()));
//    Args.insert(Args.end(), TransitionArgs.begin(), TransitionArgs.end());
//    Args.push_back(B.getInt32(DeoptArgs.size()));
//    Args.insert(Args.end(), DeoptArgs.begin(), DeoptArgs.end());
//    Args.insert(Args.end(), GCArgs.begin(), GCArgs.end());
//    
//    return new std.vector<Value /*P*/ >(JD$Move.INSTANCE, Args);
//  } finally {
//    if (Args != null) { Args.$destroy(); }
//  }
//}

//template <typename T0 = Value *, typename T1 = Value *, typename T2 = Value *, typename T3 = Value *> 
//<editor-fold defaultstate="collapsed" desc="CreateGCStatepointCallCommon">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 334,
 FQN="CreateGCStatepointCallCommon", NM="_ZL28CreateGCStatepointCallCommonIPN4llvm5ValueES2_S2_S2_EPNS0_8CallInstEPNS0_13IRBuilderBaseEyjS2_jNS0_8ArrayRefIT_EENS7_IT0_EENS7_IT1_EENS7_IT2_EERKNS0_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZL28CreateGCStatepointCallCommonIPN4llvm5ValueES2_S2_S2_EPNS0_8CallInstEPNS0_13IRBuilderBaseEyjS2_jNS0_8ArrayRefIT_EENS7_IT0_EENS7_IT1_EENS7_IT2_EERKNS0_5TwineE")
//</editor-fold>
public static CallInst /*P*/ CreateGCStatepointCallCommon$Value(IRBuilderBase /*P*/ Builder, long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, 
                            Value /*P*/ ActualCallee, /*uint32_t*/int Flags, ArrayRef<Value /*P*/ > CallArgs, 
                            ArrayRef<Value /*P*/ > TransitionArgs, ArrayRef<Value /*P*/ > DeoptArgs, ArrayRef<Value /*P*/ > GCArgs, 
                            final /*const*/ Twine /*&*/ Name) {
  std.vector<Value /*P*/ > Args = null;
  try {
    // Extract out the type of the callee.
    PointerType /*P*/ FuncPtrType = cast_PointerType(ActualCallee.getType());
    assert (isa_FunctionType(FuncPtrType.getElementType())) : "actual callee must be a callable value";
    
    Module /*P*/ M = Builder.GetInsertBlock().getParent().getParent();
    // Fill in the one generic type'd argument (the function is also vararg)
    Type /*P*/ ArgTypes[/*1*/] = new Type /*P*/  [/*1*/] {FuncPtrType};
    Function /*P*/ FnStatepoint = IntrinsicGlobals.getDeclaration(M, org.llvm.ir.intrinsic.ID.experimental_gc_statepoint, 
        new ArrayRef<Type /*P*/ >(ArgTypes, true));
    
    Args = IRBuilderStatics.getStatepointArgs$Value($Deref(Builder), ID, NumPatchBytes, ActualCallee, Flags, 
        new ArrayRef<Value /*P*/ >(CallArgs), new ArrayRef<Value /*P*/ >(TransitionArgs), new ArrayRef<Value /*P*/ >(DeoptArgs), new ArrayRef<Value /*P*/ >(GCArgs));
    return IRBuilderStatics.createCallHelper(FnStatepoint, new ArrayRef<Value /*P*/ >(Args, true), Builder, Name);
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}
//template <typename T0 = Use, typename T1 = Use, typename T2 = Use, typename T3 = Value *> 
//<editor-fold defaultstate="collapsed" desc="CreateGCStatepointCallCommon">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 334,
 FQN="CreateGCStatepointCallCommon", NM="_ZL28CreateGCStatepointCallCommonIN4llvm3UseES1_S1_PNS0_5ValueEEPNS0_8CallInstEPNS0_13IRBuilderBaseEyjS3_jNS0_8ArrayRefIT_EENS8_IT0_EENS8_IT1_EENS8_IT2_EERKNS0_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZL28CreateGCStatepointCallCommonIN4llvm3UseES1_S1_PNS0_5ValueEEPNS0_8CallInstEPNS0_13IRBuilderBaseEyjS3_jNS0_8ArrayRefIT_EENS8_IT0_EENS8_IT1_EENS8_IT2_EERKNS0_5TwineE")
//</editor-fold>
public static CallInst /*P*/ CreateGCStatepointCallCommon$Use(IRBuilderBase /*P*/ Builder, long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, 
                            Value /*P*/ ActualCallee, /*uint32_t*/int Flags, ArrayRef<Use> CallArgs, 
                            ArrayRef<Use> TransitionArgs, ArrayRef<Use> DeoptArgs, ArrayRef<Value /*P*/ > GCArgs, 
                            final /*const*/ Twine /*&*/ Name) {
  std.vector<Value /*P*/ > Args = null;
  try {
    PointerType /*P*/ FuncPtrType = cast_PointerType(ActualCallee.getType());
    assert (isa_FunctionType(FuncPtrType.getElementType())) : "actual callee must be a callable value";
    
    Module /*P*/ M = Builder.GetInsertBlock().getParent().getParent();
    Type /*P*/ ArgTypes[/*1*/] = new Type /*P*/  [/*1*/] {FuncPtrType};
    Function /*P*/ FnStatepoint = IntrinsicGlobals.getDeclaration(M, org.llvm.ir.intrinsic.ID.experimental_gc_statepoint, 
        new ArrayRef<Type /*P*/ >(ArgTypes, true));
    
    Args = IRBuilderStatics.getStatepointArgs$Use($Deref(Builder), ID, NumPatchBytes, ActualCallee, Flags, 
        new ArrayRef<Use>(CallArgs), new ArrayRef<Use>(TransitionArgs), new ArrayRef<Use>(DeoptArgs), new ArrayRef<Value /*P*/ >(GCArgs));
    return IRBuilderStatics.createCallHelper(FnStatepoint, new ArrayRef<Value /*P*/ >(Args, true), Builder, Name);
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}
//template <typename T0 = Use, typename T1 = Value *, typename T2 = Value *, typename T3 = Value *> 
//<editor-fold defaultstate="collapsed" desc="CreateGCStatepointCallCommon">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 334,
 FQN="CreateGCStatepointCallCommon", NM="_ZL28CreateGCStatepointCallCommonIN4llvm3UseEPNS0_5ValueES3_S3_EPNS0_8CallInstEPNS0_13IRBuilderBaseEyjS3_jNS0_8ArrayRefIT_EENS8_IT0_EENS8_IT1_EENS8_IT2_EERKNS0_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZL28CreateGCStatepointCallCommonIN4llvm3UseEPNS0_5ValueES3_S3_EPNS0_8CallInstEPNS0_13IRBuilderBaseEyjS3_jNS0_8ArrayRefIT_EENS8_IT0_EENS8_IT1_EENS8_IT2_EERKNS0_5TwineE")
//</editor-fold>
public static CallInst /*P*/ CreateGCStatepointCallCommon$UseValue(IRBuilderBase /*P*/ Builder, long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, 
                            Value /*P*/ ActualCallee, /*uint32_t*/int Flags, ArrayRef<Use> CallArgs, 
                            ArrayRef<Value /*P*/ > TransitionArgs, ArrayRef<Value /*P*/ > DeoptArgs, ArrayRef<Value /*P*/ > GCArgs, 
                            final /*const*/ Twine /*&*/ Name) {
  std.vector<Value /*P*/ > Args = null;
  try {
    PointerType /*P*/ FuncPtrType = cast_PointerType(ActualCallee.getType());
    assert (isa_FunctionType(FuncPtrType.getElementType())) : "actual callee must be a callable value";
    
    Module /*P*/ M = Builder.GetInsertBlock().getParent().getParent();
    Type /*P*/ ArgTypes[/*1*/] = new Type /*P*/  [/*1*/] {FuncPtrType};
    Function /*P*/ FnStatepoint = IntrinsicGlobals.getDeclaration(M, org.llvm.ir.intrinsic.ID.experimental_gc_statepoint, 
        new ArrayRef<Type /*P*/ >(ArgTypes, true));
    
    Args = IRBuilderStatics.getStatepointArgs$UseValue($Deref(Builder), ID, NumPatchBytes, ActualCallee, Flags, 
        new ArrayRef<Use>(CallArgs), new ArrayRef<Value /*P*/ >(TransitionArgs), new ArrayRef<Value /*P*/ >(DeoptArgs), new ArrayRef<Value /*P*/ >(GCArgs));
    return IRBuilderStatics.createCallHelper(FnStatepoint, new ArrayRef<Value /*P*/ >(Args, true), Builder, Name);
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}
///*template <typename T0, typename T1, typename T2, typename T3> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="CreateGCStatepointCallCommon">
//@Converted(kind = Converted.Kind.DELETED,
// source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 334,
// FQN="CreateGCStatepointCallCommon", NM="Tpl__ZL28CreateGCStatepointCallCommonPN4llvm13IRBuilderBaseEyjPNS_5ValueEjNS_8ArrayRefIT_EENS4_IT0_EENS4_IT1_EENS4_IT2_EERKNS_5TwineE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=Tpl__ZL28CreateGCStatepointCallCommonPN4llvm13IRBuilderBaseEyjPNS_5ValueEjNS_8ArrayRefIT_EENS4_IT0_EENS4_IT1_EENS4_IT2_EERKNS_5TwineE")
////</editor-fold>
//public static </*typename*/ T0, /*typename*/ T1, /*typename*/ T2, /*typename*/ T3> CallInst /*P*/ CreateGCStatepointCallCommon(IRBuilderBase /*P*/ Builder, long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, 
//                            Value /*P*/ ActualCallee, /*uint32_t*/int Flags, ArrayRef<T0> CallArgs, 
//                            ArrayRef<T1> TransitionArgs, ArrayRef<T2> DeoptArgs, ArrayRef<T3> GCArgs, 
//                            final /*const*/ Twine /*&*/ Name) {
//  PointerType /*P*/ FuncPtrType = cast_PointerType(ActualCallee.getType());
//  assert (isa_FunctionType(FuncPtrType.getElementType())) : "actual callee must be a callable value";
//  
//  Module /*P*/ M = Builder.GetInsertBlock().getParent().getParent();
//  Type /*P*/ ArgTypes[/*1*/] = new Type /*P*/  [/*1*/] {FuncPtrType};
//  Function /*P*/ FnStatepoint = Intrinsic.getDeclaration(M, Intrinsic.ID.experimental_gc_statepoint, 
//      new ArrayRef<Type /*P*/ >(ArgTypes, true));
//  
//  std.vector<Value /*P*/ > Args = getStatepointArgs($Deref(Builder), ID, NumPatchBytes, ActualCallee, Flags, 
//      CallArgs, TransitionArgs, DeoptArgs, GCArgs);
//  return IRBuilderStatics.createCallHelper(FnStatepoint, new ArrayRef<Value /*P*/ >(Args, true), Builder, Name);
//}

//template <typename T0 = Value *, typename T1 = Value *, typename T2 = Value *, typename T3 = Value *> 
//<editor-fold defaultstate="collapsed" desc="CreateGCStatepointInvokeCommon">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 385,
 FQN="CreateGCStatepointInvokeCommon", NM="_ZL30CreateGCStatepointInvokeCommonIPN4llvm5ValueES2_S2_S2_EPNS0_10InvokeInstEPNS0_13IRBuilderBaseEyjS2_PNS0_10BasicBlockES8_jNS0_8ArrayRefIT_EENS9_IT0_EENS9_IT1_EENS9_IT2_EERKNS0_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZL30CreateGCStatepointInvokeCommonIPN4llvm5ValueES2_S2_S2_EPNS0_10InvokeInstEPNS0_13IRBuilderBaseEyjS2_PNS0_10BasicBlockES8_jNS0_8ArrayRefIT_EENS9_IT0_EENS9_IT1_EENS9_IT2_EERKNS0_5TwineE")
//</editor-fold>
public static InvokeInst /*P*/ CreateGCStatepointInvokeCommon$Value(IRBuilderBase /*P*/ Builder, long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, 
                              Value /*P*/ ActualInvokee, BasicBlock /*P*/ NormalDest, BasicBlock /*P*/ UnwindDest, 
                              /*uint32_t*/int Flags, ArrayRef<Value /*P*/ > InvokeArgs, ArrayRef<Value /*P*/ > TransitionArgs, 
                              ArrayRef<Value /*P*/ > DeoptArgs, ArrayRef<Value /*P*/ > GCArgs, final /*const*/ Twine /*&*/ Name) {
  std.vector<Value /*P*/ > Args = null;
  try {
    // Extract out the type of the callee.
    PointerType /*P*/ FuncPtrType = cast_PointerType(ActualInvokee.getType());
    assert (isa_FunctionType(FuncPtrType.getElementType())) : "actual callee must be a callable value";
    
    Module /*P*/ M = Builder.GetInsertBlock().getParent().getParent();
    // Fill in the one generic type'd argument (the function is also vararg)
    Function /*P*/ FnStatepoint = IntrinsicGlobals.getDeclaration(M, org.llvm.ir.intrinsic.ID.experimental_gc_statepoint, /*{ */new ArrayRef<Type /*P*/ >(new Type /*P*/ /*const*/ [/*1*/] {FuncPtrType}, true)/* }*/);
    
    Args = IRBuilderStatics.getStatepointArgs$Value($Deref(Builder), ID, NumPatchBytes, ActualInvokee, Flags, 
        new ArrayRef<Value /*P*/ >(InvokeArgs), new ArrayRef<Value /*P*/ >(TransitionArgs), new ArrayRef<Value /*P*/ >(DeoptArgs), new ArrayRef<Value /*P*/ >(GCArgs));
    return IRBuilderStatics.createInvokeHelper(FnStatepoint, NormalDest, UnwindDest, new ArrayRef<Value /*P*/ >(Args, true), Builder, 
        Name);
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}
//template <typename T0 = Use, typename T1 = Use, typename T2 = Use, typename T3 = Value *> 
//<editor-fold defaultstate="collapsed" desc="CreateGCStatepointInvokeCommon">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 385,
 FQN="CreateGCStatepointInvokeCommon", NM="_ZL30CreateGCStatepointInvokeCommonIN4llvm3UseES1_S1_PNS0_5ValueEEPNS0_10InvokeInstEPNS0_13IRBuilderBaseEyjS3_PNS0_10BasicBlockES9_jNS0_8ArrayRefIT_EENSA_IT0_EENSA_IT1_EENSA_IT2_EERKNS0_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZL30CreateGCStatepointInvokeCommonIN4llvm3UseES1_S1_PNS0_5ValueEEPNS0_10InvokeInstEPNS0_13IRBuilderBaseEyjS3_PNS0_10BasicBlockES9_jNS0_8ArrayRefIT_EENSA_IT0_EENSA_IT1_EENSA_IT2_EERKNS0_5TwineE")
//</editor-fold>
public static InvokeInst /*P*/ CreateGCStatepointInvokeCommon$Use(IRBuilderBase /*P*/ Builder, long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, 
                              Value /*P*/ ActualInvokee, BasicBlock /*P*/ NormalDest, BasicBlock /*P*/ UnwindDest, 
                              /*uint32_t*/int Flags, ArrayRef<Use> InvokeArgs, ArrayRef<Use> TransitionArgs, 
                              ArrayRef<Use> DeoptArgs, ArrayRef<Value /*P*/ > GCArgs, final /*const*/ Twine /*&*/ Name) {
  std.vector<Value /*P*/ > Args = null;
  try {
    PointerType /*P*/ FuncPtrType = cast_PointerType(ActualInvokee.getType());
    assert (isa_FunctionType(FuncPtrType.getElementType())) : "actual callee must be a callable value";
    
    Module /*P*/ M = Builder.GetInsertBlock().getParent().getParent();
    Function /*P*/ FnStatepoint = IntrinsicGlobals.getDeclaration(M, org.llvm.ir.intrinsic.ID.experimental_gc_statepoint, /*{ */new ArrayRef<Type /*P*/ >(new Type /*P*/ /*const*/ [/*1*/] {FuncPtrType}, true)/* }*/);
    
    Args = IRBuilderStatics.getStatepointArgs$Use($Deref(Builder), ID, NumPatchBytes, ActualInvokee, Flags, 
        new ArrayRef<Use>(InvokeArgs), new ArrayRef<Use>(TransitionArgs), new ArrayRef<Use>(DeoptArgs), new ArrayRef<Value /*P*/ >(GCArgs));
    return IRBuilderStatics.createInvokeHelper(FnStatepoint, NormalDest, UnwindDest, new ArrayRef<Value /*P*/ >(Args, true), Builder, 
        Name);
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}
//template <typename T0 = Use, typename T1 = Value *, typename T2 = Value *, typename T3 = Value *> 
//<editor-fold defaultstate="collapsed" desc="CreateGCStatepointInvokeCommon">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 385,
 FQN="CreateGCStatepointInvokeCommon", NM="_ZL30CreateGCStatepointInvokeCommonIN4llvm3UseEPNS0_5ValueES3_S3_EPNS0_10InvokeInstEPNS0_13IRBuilderBaseEyjS3_PNS0_10BasicBlockES9_jNS0_8ArrayRefIT_EENSA_IT0_EENSA_IT1_EENSA_IT2_EERKNS0_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZL30CreateGCStatepointInvokeCommonIN4llvm3UseEPNS0_5ValueES3_S3_EPNS0_10InvokeInstEPNS0_13IRBuilderBaseEyjS3_PNS0_10BasicBlockES9_jNS0_8ArrayRefIT_EENSA_IT0_EENSA_IT1_EENSA_IT2_EERKNS0_5TwineE")
//</editor-fold>
public static InvokeInst /*P*/ CreateGCStatepointInvokeCommon$UseValue(IRBuilderBase /*P*/ Builder, long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, 
                              Value /*P*/ ActualInvokee, BasicBlock /*P*/ NormalDest, BasicBlock /*P*/ UnwindDest, 
                              /*uint32_t*/int Flags, ArrayRef<Use> InvokeArgs, ArrayRef<Value /*P*/ > TransitionArgs, 
                              ArrayRef<Value /*P*/ > DeoptArgs, ArrayRef<Value /*P*/ > GCArgs, final /*const*/ Twine /*&*/ Name) {
  std.vector<Value /*P*/ > Args = null;
  try {
    PointerType /*P*/ FuncPtrType = cast_PointerType(ActualInvokee.getType());
    assert (isa_FunctionType(FuncPtrType.getElementType())) : "actual callee must be a callable value";
    
    Module /*P*/ M = Builder.GetInsertBlock().getParent().getParent();
    Function /*P*/ FnStatepoint = IntrinsicGlobals.getDeclaration(M, org.llvm.ir.intrinsic.ID.experimental_gc_statepoint, /*{ */new ArrayRef<Type /*P*/ >(new Type /*P*/ /*const*/ [/*1*/] {FuncPtrType}, true)/* }*/);
    
    Args = IRBuilderStatics.getStatepointArgs$UseValue($Deref(Builder), ID, NumPatchBytes, ActualInvokee, Flags, 
        new ArrayRef<Use>(InvokeArgs), new ArrayRef<Value /*P*/ >(TransitionArgs), new ArrayRef<Value /*P*/ >(DeoptArgs), new ArrayRef<Value /*P*/ >(GCArgs));
    return IRBuilderStatics.createInvokeHelper(FnStatepoint, NormalDest, UnwindDest, new ArrayRef<Value /*P*/ >(Args, true), Builder, 
        Name);
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}
///*template <typename T0, typename T1, typename T2, typename T3> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="CreateGCStatepointInvokeCommon">
//@Converted(kind = Converted.Kind.DELETED,
// source = "${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp", line = 385,
// FQN="CreateGCStatepointInvokeCommon", NM="Tpl__ZL30CreateGCStatepointInvokeCommonPN4llvm13IRBuilderBaseEyjPNS_5ValueEPNS_10BasicBlockES5_jNS_8ArrayRefIT_EENS6_IT0_EENS6_IT1_EENS6_IT2_EERKNS_5TwineE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=Tpl__ZL30CreateGCStatepointInvokeCommonPN4llvm13IRBuilderBaseEyjPNS_5ValueEPNS_10BasicBlockES5_jNS_8ArrayRefIT_EENS6_IT0_EENS6_IT1_EENS6_IT2_EERKNS_5TwineE")
////</editor-fold>
//public static </*typename*/ T0, /*typename*/ T1, /*typename*/ T2, /*typename*/ T3> InvokeInst /*P*/ CreateGCStatepointInvokeCommon(IRBuilderBase /*P*/ Builder, long/*uint64_t*/ ID, /*uint32_t*/int NumPatchBytes, 
//                              Value /*P*/ ActualInvokee, BasicBlock /*P*/ NormalDest, BasicBlock /*P*/ UnwindDest, 
//                              /*uint32_t*/int Flags, ArrayRef<T0> InvokeArgs, ArrayRef<T1> TransitionArgs, 
//                              ArrayRef<T2> DeoptArgs, ArrayRef<T3> GCArgs, final /*const*/ Twine /*&*/ Name) {
//  PointerType /*P*/ FuncPtrType = cast_PointerType(ActualInvokee.getType());
//  assert (isa_FunctionType(FuncPtrType.getElementType())) : "actual callee must be a callable value";
//  
//  Module /*P*/ M = Builder.GetInsertBlock().getParent().getParent();
//  Function /*P*/ FnStatepoint = Intrinsic.getDeclaration(M, Intrinsic.ID.experimental_gc_statepoint, /*{ */new ArrayRef<Type /*P*/ >(new Type /*P*/ /*const*/ [/*1*/] {FuncPtrType}, true)/* }*/);
//  
//  std.vector<Value /*P*/ > Args = getStatepointArgs($Deref(Builder), ID, NumPatchBytes, ActualInvokee, Flags, 
//      InvokeArgs, TransitionArgs, DeoptArgs, GCArgs);
//  return IRBuilderStatics.createInvokeHelper(FnStatepoint, NormalDest, UnwindDest, new ArrayRef<Value /*P*/ >(Args, true), Builder, 
//      Name);
//}

} // END OF class IRBuilderStatics
