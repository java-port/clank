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

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.support.AdtsupportLlvmGlobals.isStrongerThan;


//<editor-fold defaultstate="collapsed" desc="static type CGAtomicStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZL12EmitAtomicOpRN5clang7CodeGen15CodeGenFunctionEPNS_10AtomicExprENS0_7AddressES5_S5_S5_PN4llvm5ValueES8_yNS6_14AtomicOrderingE;_ZL13EmitValToTempRN5clang7CodeGen15CodeGenFunctionEPNS_4ExprE;_ZL14isFullSizeTypeRN5clang7CodeGen13CodeGenModuleEPN4llvm4TypeEy;_ZL17AddDirectArgumentRN5clang7CodeGen15CodeGenFunctionERNS0_11CallArgListEbPN4llvm5ValueENS_8QualTypeENS_14SourceLocationENS_9CharUnitsE;_ZL17emitAtomicCmpXchgRN5clang7CodeGen15CodeGenFunctionEPNS_10AtomicExprEbNS0_7AddressES5_S5_S5_yN4llvm14AtomicOrderingES7_;_ZL17emitAtomicLibcallRN5clang7CodeGen15CodeGenFunctionEN4llvm9StringRefENS_8QualTypeERNS0_11CallArgListE;_ZL21EmitAtomicUpdateValueRN5clang7CodeGen15CodeGenFunctionERN12_GLOBAL__N_110AtomicInfoENS0_6RValueENS0_7AddressE;_ZL21EmitAtomicUpdateValueRN5clang7CodeGen15CodeGenFunctionERN12_GLOBAL__N_110AtomicInfoENS0_6RValueERKN4llvm12function_refIFS6_S6_EEENS0_7AddressE;_ZL27emitAtomicCmpXchgFailureSetRN5clang7CodeGen15CodeGenFunctionEPNS_10AtomicExprEbNS0_7AddressES5_S5_S5_PN4llvm5ValueEyNS6_14AtomicOrderingE; -static-type=CGAtomicStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGAtomicStatics {

//<editor-fold defaultstate="collapsed" desc="emitAtomicLibcall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 303,
 FQN="emitAtomicLibcall", NM="_ZL17emitAtomicLibcallRN5clang7CodeGen15CodeGenFunctionEN4llvm9StringRefENS_8QualTypeERNS0_11CallArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZL17emitAtomicLibcallRN5clang7CodeGen15CodeGenFunctionEN4llvm9StringRefENS_8QualTypeERNS0_11CallArgListE")
//</editor-fold>
public static RValue emitAtomicLibcall(final CodeGenFunction /*&*/ CGF, 
                 StringRef fnName, 
                 QualType resultType, 
                 final CallArgList /*&*/ args) {
  final /*const*/ CGFunctionInfo /*&*/ fnInfo = CGF.CGM.getTypes().arrangeBuiltinFunctionCall(new QualType(resultType), args);
  org.llvm.ir.FunctionType /*P*/ fnTy = CGF.CGM.getTypes().GetFunctionType(fnInfo);
  Constant /*P*/ fn = CGF.CGM.CreateRuntimeFunction(fnTy, new StringRef(fnName));
  return CGF.EmitCall(fnInfo, fn, new ReturnValueSlot(), args);
}


/// Does a store of the given IR type modify the full expected width?
//<editor-fold defaultstate="collapsed" desc="isFullSizeType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 315,
 FQN="isFullSizeType", NM="_ZL14isFullSizeTypeRN5clang7CodeGen13CodeGenModuleEPN4llvm4TypeEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZL14isFullSizeTypeRN5clang7CodeGen13CodeGenModuleEPN4llvm4TypeEy")
//</editor-fold>
public static boolean isFullSizeType(final CodeGenModule /*&*/ CGM, org.llvm.ir.Type /*P*/ type, 
              long/*uint64_t*/ expectedSize) {
  return (CGM.getDataLayout().getTypeStoreSize(type) * $int2ullong(8) == expectedSize);
}

//<editor-fold defaultstate="collapsed" desc="emitAtomicCmpXchg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 357,
 FQN="emitAtomicCmpXchg", NM="_ZL17emitAtomicCmpXchgRN5clang7CodeGen15CodeGenFunctionEPNS_10AtomicExprEbNS0_7AddressES5_S5_S5_yN4llvm14AtomicOrderingES7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZL17emitAtomicCmpXchgRN5clang7CodeGen15CodeGenFunctionEPNS_10AtomicExprEbNS0_7AddressES5_S5_S5_yN4llvm14AtomicOrderingES7_")
//</editor-fold>
public static void emitAtomicCmpXchg(final CodeGenFunction /*&*/ CGF, AtomicExpr /*P*/ E, boolean IsWeak, 
                 Address Dest, Address Ptr, 
                 Address Val1, Address Val2, 
                 long/*uint64_t*/ Size, 
                 AtomicOrdering SuccessOrder, 
                 AtomicOrdering FailureOrder) {
  // Note that cmpxchg doesn't support weak cmpxchg, at least at the moment.
  Value /*P*/ Expected = CGF.Builder.CreateLoad(new Address(Val1));
  Value /*P*/ Desired = CGF.Builder.CreateLoad(new Address(Val2));
  
  AtomicCmpXchgInst /*P*/ Pair = CGF.Builder.CreateAtomicCmpXchg(Ptr.getPointer(), Expected, Desired, SuccessOrder, FailureOrder);
  Pair.setVolatile(E.isVolatile());
  Pair.setWeak(IsWeak);
  
  // Cmp holds the result of the compare-exchange operation: true on success,
  // false on failure.
  Value /*P*/ Old = CGF.Builder.CreateExtractValue(Pair, new ArrayRefUInt(0));
  Value /*P*/ Cmp = CGF.Builder.CreateExtractValue(Pair, new ArrayRefUInt(1));
  
  // This basic block is used to hold the store instruction if the operation
  // failed.
  BasicBlock /*P*/ StoreExpectedBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"cmpxchg.store_expected"), CGF.CurFn);
  
  // This basic block is the exit point of the operation, we should end up
  // here regardless of whether or not the operation succeeded.
  BasicBlock /*P*/ ContinueBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"cmpxchg.continue"), CGF.CurFn);
  
  // Update Expected if Expected isn't equal to Old, otherwise branch to the
  // exit point.
  CGF.Builder.CreateCondBr(Cmp, ContinueBB, StoreExpectedBB);
  
  CGF.Builder.SetInsertPoint(StoreExpectedBB);
  // Update the memory at Expected with Old's value.
  CGF.Builder.CreateStore(Old, new Address(Val1));
  // Finally, branch to the exit point.
  CGF.Builder.CreateBr(ContinueBB);
  
  CGF.Builder.SetInsertPoint(ContinueBB);
  // Update the memory at Dest with Cmp's value.
  CGF.EmitStoreOfScalar(Cmp, CGF.MakeAddrLValue(new Address(Dest), E.getType()));
}


/// Given an ordering required on success, emit all possible cmpxchg
/// instructions to cope with the provided (but possibly only dynamically known)
/// FailureOrder.
//<editor-fold defaultstate="collapsed" desc="emitAtomicCmpXchgFailureSet">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 405,
 FQN="emitAtomicCmpXchgFailureSet", NM="_ZL27emitAtomicCmpXchgFailureSetRN5clang7CodeGen15CodeGenFunctionEPNS_10AtomicExprEbNS0_7AddressES5_S5_S5_PN4llvm5ValueEyNS6_14AtomicOrderingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZL27emitAtomicCmpXchgFailureSetRN5clang7CodeGen15CodeGenFunctionEPNS_10AtomicExprEbNS0_7AddressES5_S5_S5_PN4llvm5ValueEyNS6_14AtomicOrderingE")
//</editor-fold>
public static void emitAtomicCmpXchgFailureSet(final CodeGenFunction /*&*/ CGF, AtomicExpr /*P*/ E, 
                           boolean IsWeak, Address Dest, Address Ptr, 
                           Address Val1, Address Val2, 
                           Value /*P*/ FailureOrderVal, 
                           long/*uint64_t*/ Size, 
                           AtomicOrdering SuccessOrder) {
  AtomicOrdering FailureOrder = AtomicOrdering.NotAtomic;
  {
    ConstantInt /*P*/ FO = dyn_cast_ConstantInt(FailureOrderVal);
    if ((FO != null)) {
      long/*int64_t*/ FOS = FO.getSExtValue();
      if (!llvm.isValidAtomicOrderingCABI(FOS)) {
        FailureOrder = AtomicOrdering.Monotonic;
      } else {
        switch (AtomicOrderingCABI.valueOf(FOS)) {
         case relaxed:
         case release:
         case acq_rel:
          FailureOrder = AtomicOrdering.Monotonic;
          break;
         case consume:
         case acquire:
          FailureOrder = AtomicOrdering.Acquire;
          break;
         case seq_cst:
          FailureOrder = AtomicOrdering.SequentiallyConsistent;
          break;
        }
      }
      if (isStrongerThan(FailureOrder, SuccessOrder)) {
        // Don't assert on undefined behavior "failure argument shall be no
        // stronger than the success argument".
        FailureOrder
           = AtomicCmpXchgInst.getStrongestFailureOrdering(SuccessOrder);
      }
      emitAtomicCmpXchg(CGF, E, IsWeak, new Address(Dest), new Address(Ptr), new Address(Val1), new Address(Val2), Size, SuccessOrder, 
          FailureOrder);
      return;
    }
  }
  
  // Create all the relevant BB's
  BasicBlock /*P*/ MonotonicBB = null;
  BasicBlock /*P*/ AcquireBB = null;
  BasicBlock /*P*/ SeqCstBB = null;
  MonotonicBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"monotonic_fail"), CGF.CurFn);
  if (SuccessOrder != AtomicOrdering.Monotonic
     && SuccessOrder != AtomicOrdering.Release) {
    AcquireBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"acquire_fail"), CGF.CurFn);
  }
  if (SuccessOrder == AtomicOrdering.SequentiallyConsistent) {
    SeqCstBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"seqcst_fail"), CGF.CurFn);
  }
  
  BasicBlock /*P*/ ContBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"atomic.continue"), CGF.CurFn);
  
  SwitchInst /*P*/ SI = CGF.Builder.CreateSwitch(FailureOrderVal, MonotonicBB);
  
  // Emit all the different atomics
  
  // MonotonicBB is arbitrarily chosen as the default case; in practice, this
  // doesn't matter unless someone is crazy enough to use something that
  // doesn't fold to a constant for the ordering.
  CGF.Builder.SetInsertPoint(MonotonicBB);
  emitAtomicCmpXchg(CGF, E, IsWeak, new Address(Dest), new Address(Ptr), new Address(Val1), new Address(Val2), 
      Size, SuccessOrder, AtomicOrdering.Monotonic);
  CGF.Builder.CreateBr(ContBB);
  if ((AcquireBB != null)) {
    CGF.Builder.SetInsertPoint(AcquireBB);
    emitAtomicCmpXchg(CGF, E, IsWeak, new Address(Dest), new Address(Ptr), new Address(Val1), new Address(Val2), 
        Size, SuccessOrder, AtomicOrdering.Acquire);
    CGF.Builder.CreateBr(ContBB);
    SI.addCase(CGF.Builder.getInt32(((int)AtomicOrderingCABI.consume.getValue())), 
        AcquireBB);
    SI.addCase(CGF.Builder.getInt32(((int)AtomicOrderingCABI.acquire.getValue())), 
        AcquireBB);
  }
  if ((SeqCstBB != null)) {
    CGF.Builder.SetInsertPoint(SeqCstBB);
    emitAtomicCmpXchg(CGF, E, IsWeak, new Address(Dest), new Address(Ptr), new Address(Val1), new Address(Val2), Size, SuccessOrder, 
        AtomicOrdering.SequentiallyConsistent);
    CGF.Builder.CreateBr(ContBB);
    SI.addCase(CGF.Builder.getInt32(((int)AtomicOrderingCABI.seq_cst.getValue())), 
        SeqCstBB);
  }
  
  CGF.Builder.SetInsertPoint(ContBB);
}

//<editor-fold defaultstate="collapsed" desc="EmitAtomicOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 488,
 FQN="EmitAtomicOp", NM="_ZL12EmitAtomicOpRN5clang7CodeGen15CodeGenFunctionEPNS_10AtomicExprENS0_7AddressES5_S5_S5_PN4llvm5ValueES8_yNS6_14AtomicOrderingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZL12EmitAtomicOpRN5clang7CodeGen15CodeGenFunctionEPNS_10AtomicExprENS0_7AddressES5_S5_S5_PN4llvm5ValueES8_yNS6_14AtomicOrderingE")
//</editor-fold>
public static void EmitAtomicOp(final CodeGenFunction /*&*/ CGF, AtomicExpr /*P*/ E, Address Dest, 
            Address Ptr, Address Val1, Address Val2, 
            Value /*P*/ IsWeak, Value /*P*/ FailureOrder, 
            long/*uint64_t*/ Size, AtomicOrdering Order) {
  AtomicRMWInst.BinOp Op = AtomicRMWInst.BinOp.Add;
  /*BinaryOps*/int PostOp = (0);
  switch (E.getOp()) {
   case AO__c11_atomic_init:
    throw new llvm_unreachable("Already handled!");
   case AO__c11_atomic_compare_exchange_strong:
    emitAtomicCmpXchgFailureSet(CGF, E, false, new Address(Dest), new Address(Ptr), new Address(Val1), new Address(Val2), 
        FailureOrder, Size, Order);
    return;
   case AO__c11_atomic_compare_exchange_weak:
    emitAtomicCmpXchgFailureSet(CGF, E, true, new Address(Dest), new Address(Ptr), new Address(Val1), new Address(Val2), 
        FailureOrder, Size, Order);
    return;
   case AO__atomic_compare_exchange:
   case AO__atomic_compare_exchange_n:
    {
      {
        ConstantInt /*P*/ IsWeakC = dyn_cast_ConstantInt(IsWeak);
        if ((IsWeakC != null)) {
          emitAtomicCmpXchgFailureSet(CGF, E, (IsWeakC.getZExtValue() != 0), new Address(Dest), new Address(Ptr), 
              new Address(Val1), new Address(Val2), FailureOrder, Size, Order);
        } else {
          // Create all the relevant BB's
          BasicBlock /*P*/ StrongBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"cmpxchg.strong"), CGF.CurFn);
          BasicBlock /*P*/ WeakBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"cmxchg.weak"), CGF.CurFn);
          BasicBlock /*P*/ ContBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"cmpxchg.continue"), CGF.CurFn);
          
          SwitchInst /*P*/ SI = CGF.Builder.CreateSwitch(IsWeak, WeakBB);
          SI.addCase(CGF.Builder.getInt1(false), StrongBB);
          
          CGF.Builder.SetInsertPoint(StrongBB);
          emitAtomicCmpXchgFailureSet(CGF, E, false, new Address(Dest), new Address(Ptr), new Address(Val1), new Address(Val2), 
              FailureOrder, Size, Order);
          CGF.Builder.CreateBr(ContBB);
          
          CGF.Builder.SetInsertPoint(WeakBB);
          emitAtomicCmpXchgFailureSet(CGF, E, true, new Address(Dest), new Address(Ptr), new Address(Val1), new Address(Val2), 
              FailureOrder, Size, Order);
          CGF.Builder.CreateBr(ContBB);
          
          CGF.Builder.SetInsertPoint(ContBB);
        }
      }
      return;
    }
   case AO__c11_atomic_load:
   case AO__atomic_load_n:
   case AO__atomic_load:
    {
      LoadInst /*P*/ Load = CGF.Builder.CreateLoad(new Address(Ptr));
      Load.setAtomic(Order);
      Load.setVolatile(E.isVolatile());
      CGF.Builder.CreateStore(Load, new Address(Dest));
      return;
    }
   case AO__c11_atomic_store:
   case AO__atomic_store:
   case AO__atomic_store_n:
    {
      Value /*P*/ LoadVal1 = CGF.Builder.CreateLoad(new Address(Val1));
      StoreInst /*P*/ Store = CGF.Builder.CreateStore(LoadVal1, new Address(Ptr));
      Store.setAtomic(Order);
      Store.setVolatile(E.isVolatile());
      return;
    }
   case AO__c11_atomic_exchange:
   case AO__atomic_exchange_n:
   case AO__atomic_exchange:
    Op = AtomicRMWInst.BinOp.Xchg;
    break;
   case AO__atomic_add_fetch:
    PostOp = Instruction.BinaryOps.Add;
   case AO__c11_atomic_fetch_add:
   case AO__atomic_fetch_add:
    // Fall through.
    Op = AtomicRMWInst.BinOp.Add;
    break;
   case AO__atomic_sub_fetch:
    PostOp = Instruction.BinaryOps.Sub;
   case AO__c11_atomic_fetch_sub:
   case AO__atomic_fetch_sub:
    // Fall through.
    Op = AtomicRMWInst.BinOp.Sub;
    break;
   case AO__atomic_and_fetch:
    PostOp = Instruction.BinaryOps.And;
   case AO__c11_atomic_fetch_and:
   case AO__atomic_fetch_and:
    // Fall through.
    Op = AtomicRMWInst.BinOp.And;
    break;
   case AO__atomic_or_fetch:
    PostOp = Instruction.BinaryOps.Or;
   case AO__c11_atomic_fetch_or:
   case AO__atomic_fetch_or:
    // Fall through.
    Op = AtomicRMWInst.BinOp.Or;
    break;
   case AO__atomic_xor_fetch:
    PostOp = Instruction.BinaryOps.Xor;
   case AO__c11_atomic_fetch_xor:
   case AO__atomic_fetch_xor:
    // Fall through.
    Op = AtomicRMWInst.BinOp.Xor;
    break;
   case AO__atomic_nand_fetch:
    PostOp = Instruction.BinaryOps.And; // the NOT is special cased below
   case AO__atomic_fetch_nand:
    // Fall through.
    Op = AtomicRMWInst.BinOp.Nand;
    break;
  }
  
  Value /*P*/ LoadVal1 = CGF.Builder.CreateLoad(new Address(Val1));
  AtomicRMWInst /*P*/ RMWI = CGF.Builder.CreateAtomicRMW(Op, Ptr.getPointer(), LoadVal1, Order);
  RMWI.setVolatile(E.isVolatile());
  
  // For __atomic_*_fetch operations, perform the operation again to
  // determine the value which was written.
  Value /*P*/ Result = RMWI;
  if ((PostOp != 0)) {
    Result = CGF.Builder.CreateBinOp(PostOp, RMWI, LoadVal1);
  }
  if (E.getOp() == AtomicExpr.AtomicOp.AO__atomic_nand_fetch) {
    Result = CGF.Builder.CreateNot(Result);
  }
  CGF.Builder.CreateStore(Result, new Address(Dest));
}


// This function emits any expression (scalar, complex, or aggregate)
// into a temporary alloca.
//<editor-fold defaultstate="collapsed" desc="EmitValToTemp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 628,
 FQN="EmitValToTemp", NM="_ZL13EmitValToTempRN5clang7CodeGen15CodeGenFunctionEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZL13EmitValToTempRN5clang7CodeGen15CodeGenFunctionEPNS_4ExprE")
//</editor-fold>
public static Address EmitValToTemp(final CodeGenFunction /*&*/ CGF, Expr /*P*/ E) {
  Address DeclPtr = CGF.CreateMemTemp(E.getType(), new Twine(/*KEEP_STR*/".atomictmp"));
  CGF.EmitAnyExprToMem(E, new Address(DeclPtr), E.getType().getQualifiers(), 
      /*Init*/ true);
  return DeclPtr;
}

//<editor-fold defaultstate="collapsed" desc="AddDirectArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 636,
 FQN="AddDirectArgument", NM="_ZL17AddDirectArgumentRN5clang7CodeGen15CodeGenFunctionERNS0_11CallArgListEbPN4llvm5ValueENS_8QualTypeENS_14SourceLocationENS_9CharUnitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZL17AddDirectArgumentRN5clang7CodeGen15CodeGenFunctionERNS0_11CallArgListEbPN4llvm5ValueENS_8QualTypeENS_14SourceLocationENS_9CharUnitsE")
//</editor-fold>
public static void AddDirectArgument(final CodeGenFunction /*&*/ CGF, final CallArgList /*&*/ Args, 
                 boolean UseOptimizedLibcall, Value /*P*/ Val, QualType ValTy, 
                 SourceLocation Loc, CharUnits SizeInChars) {
  if (UseOptimizedLibcall) {
    // Load value and pass it to the function directly.
    CharUnits Align = CGF.getContext().getTypeAlignInChars(new QualType(ValTy));
    long/*int64_t*/ SizeInBits = CGF.getContext().toBits(new CharUnits(SizeInChars));
    ValTy.$assignMove(
        CGF.getContext().getIntTypeForBitwidth($long2uint(SizeInBits), /*Signed=*/ /*false*/0)
    );
    org.llvm.ir.Type /*P*/ IPtrTy = IntegerType.get(CGF.getLLVMContext(), 
        $long2uint(SizeInBits)).getPointerTo();
    Address Ptr = new Address(CGF.Builder.CreateBitCast(Val, IPtrTy), new CharUnits(Align));
    Val = CGF.EmitLoadOfScalar(new Address(Ptr), false, 
        CGF.getContext().getPointerType(/*NO_COPY*/ValTy), 
        new SourceLocation(Loc));
    // Coerce the value into an appropriately sized integer type.
    Args.add(RValue.get(Val), new QualType(ValTy));
  } else {
    // Non-optimized functions always take a reference.
    Args.add(RValue.get(CGF.EmitCastToVoidPtr(Val)), 
        CGF.getContext().VoidPtrTy.$QualType());
  }
}

//<editor-fold defaultstate="collapsed" desc="EmitAtomicUpdateValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1491,
 FQN="EmitAtomicUpdateValue", NM="_ZL21EmitAtomicUpdateValueRN5clang7CodeGen15CodeGenFunctionERN12_GLOBAL__N_110AtomicInfoENS0_6RValueERKN4llvm12function_refIFS6_S6_EEENS0_7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZL21EmitAtomicUpdateValueRN5clang7CodeGen15CodeGenFunctionERN12_GLOBAL__N_110AtomicInfoENS0_6RValueERKN4llvm12function_refIFS6_S6_EEENS0_7AddressE")
//</editor-fold>
public static void EmitAtomicUpdateValue(final CodeGenFunction /*&*/ CGF, final AtomicInfo /*&*/ Atomics, RValue OldRVal, 
                     final /*const*/Type2Type<RValue> /*&*/ UpdateOp, 
                     Address DesiredAddr) {
  RValue UpRVal/*J*/= new RValue();
  LValue AtomicLVal = new LValue(Atomics.getAtomicLValue());
  LValue DesiredLVal/*J*/= new LValue();
  if (AtomicLVal.isSimple()) {
    UpRVal.$assign(OldRVal);
    DesiredLVal.$assignMove(CGF.MakeAddrLValue(new Address(DesiredAddr), AtomicLVal.getType()));
  } else {
    // Build new lvalue for temp address
    Address Ptr = Atomics.materializeRValue(new RValue(OldRVal));
    LValue UpdateLVal/*J*/= new LValue();
    if (AtomicLVal.isBitField()) {
      UpdateLVal.$assignMove(
          LValue.MakeBitfield(new Address(Ptr), AtomicLVal.getBitFieldInfo(), 
              AtomicLVal.getType(), 
              AtomicLVal.getAlignmentSource())
      );
      DesiredLVal.$assignMove(
          LValue.MakeBitfield(new Address(DesiredAddr), AtomicLVal.getBitFieldInfo(), 
              AtomicLVal.getType(), 
              AtomicLVal.getAlignmentSource())
      );
    } else if (AtomicLVal.isVectorElt()) {
      UpdateLVal.$assignMove(LValue.MakeVectorElt(new Address(Ptr), AtomicLVal.getVectorIdx(), 
              AtomicLVal.getType(), 
              AtomicLVal.getAlignmentSource()));
      DesiredLVal.$assignMove(LValue.MakeVectorElt(new Address(DesiredAddr), AtomicLVal.getVectorIdx(), AtomicLVal.getType(), 
              AtomicLVal.getAlignmentSource()));
    } else {
      assert (AtomicLVal.isExtVectorElt());
      UpdateLVal.$assignMove(LValue.MakeExtVectorElt(new Address(Ptr), AtomicLVal.getExtVectorElts(), 
              AtomicLVal.getType(), 
              AtomicLVal.getAlignmentSource()));
      DesiredLVal.$assignMove(LValue.MakeExtVectorElt(new Address(DesiredAddr), AtomicLVal.getExtVectorElts(), AtomicLVal.getType(), 
              AtomicLVal.getAlignmentSource()));
    }
    UpdateLVal.setTBAAInfo(AtomicLVal.getTBAAInfo());
    DesiredLVal.setTBAAInfo(AtomicLVal.getTBAAInfo());
    UpRVal.$assignMove(CGF.EmitLoadOfLValue(new LValue(UpdateLVal), new SourceLocation()));
  }
  // Store new value in the corresponding memory area
  RValue NewRVal = UpdateOp.$call(new RValue(UpRVal));
  if (NewRVal.isScalar()) {
    CGF.EmitStoreThroughLValue(new RValue(NewRVal), new LValue(DesiredLVal));
  } else {
    assert (NewRVal.isComplex());
    CGF.EmitStoreOfComplex(NewRVal.getComplexVal(), new LValue(DesiredLVal), 
        /*isInit=*/ false);
  }
}

//<editor-fold defaultstate="collapsed" desc="EmitAtomicUpdateValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1606,
 FQN="EmitAtomicUpdateValue", NM="_ZL21EmitAtomicUpdateValueRN5clang7CodeGen15CodeGenFunctionERN12_GLOBAL__N_110AtomicInfoENS0_6RValueENS0_7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZL21EmitAtomicUpdateValueRN5clang7CodeGen15CodeGenFunctionERN12_GLOBAL__N_110AtomicInfoENS0_6RValueENS0_7AddressE")
//</editor-fold>
public static void EmitAtomicUpdateValue(final CodeGenFunction /*&*/ CGF, final AtomicInfo /*&*/ Atomics, 
                     RValue UpdateRVal, Address DesiredAddr) {
  LValue AtomicLVal = new LValue(Atomics.getAtomicLValue());
  LValue DesiredLVal/*J*/= new LValue();
  // Build new lvalue for temp address
  if (AtomicLVal.isBitField()) {
    DesiredLVal.$assignMove(
        LValue.MakeBitfield(new Address(DesiredAddr), AtomicLVal.getBitFieldInfo(), 
            AtomicLVal.getType(), 
            AtomicLVal.getAlignmentSource())
    );
  } else if (AtomicLVal.isVectorElt()) {
    DesiredLVal.$assignMove(
        LValue.MakeVectorElt(new Address(DesiredAddr), AtomicLVal.getVectorIdx(), 
            AtomicLVal.getType(), 
            AtomicLVal.getAlignmentSource())
    );
  } else {
    assert (AtomicLVal.isExtVectorElt());
    DesiredLVal.$assignMove(LValue.MakeExtVectorElt(new Address(DesiredAddr), AtomicLVal.getExtVectorElts(), AtomicLVal.getType(), 
            AtomicLVal.getAlignmentSource()));
  }
  DesiredLVal.setTBAAInfo(AtomicLVal.getTBAAInfo());
  // Store new value in the corresponding memory area
  assert (UpdateRVal.isScalar());
  CGF.EmitStoreThroughLValue(new RValue(UpdateRVal), new LValue(DesiredLVal));
}

} // END OF class CGAtomicStatics
