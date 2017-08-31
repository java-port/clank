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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type InstructionsStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.InstructionsStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZL22getIndexedTypeInternalPN4llvm4TypeENS_8ArrayRefIT_EE;_ZL10createFreePN4llvm5ValueENS_8ArrayRefINS_17OperandBundleDefTIS1_EEEEPNS_11InstructionEPNS_10BasicBlockE;_ZL12createMallocPN4llvm11InstructionEPNS_10BasicBlockEPNS_4TypeES5_PNS_5ValueES7_NS_8ArrayRefINS_17OperandBundleDefTIS7_EEEEPNS_8FunctionERKNS_5TwineE;_ZL13IsConstantOnePN4llvm5ValueE;_ZL17isConstantAllOnesPKN4llvm5ValueE;_ZL9getAISizeRN4llvm11LLVMContextEPNS_5ValueE; -static-type=InstructionsStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class InstructionsStatics {


/// IsConstantOne - Return true only if val is constant int 1
//<editor-fold defaultstate="collapsed" desc="IsConstantOne">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 435,
 FQN="IsConstantOne", NM="_ZL13IsConstantOnePN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZL13IsConstantOnePN4llvm5ValueE")
//</editor-fold>
public static boolean IsConstantOne(Value /*P*/ val) {
  assert ((val != null)) : "IsConstantOne does not work with nullptr val";
  /*const*/ ConstantInt /*P*/ CVal = dyn_cast_ConstantInt(val);
  return (CVal != null) && CVal.isOne();
}

//<editor-fold defaultstate="collapsed" desc="createMalloc">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 441,
 FQN="createMalloc", NM="_ZL12createMallocPN4llvm11InstructionEPNS_10BasicBlockEPNS_4TypeES5_PNS_5ValueES7_NS_8ArrayRefINS_17OperandBundleDefTIS7_EEEEPNS_8FunctionERKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZL12createMallocPN4llvm11InstructionEPNS_10BasicBlockEPNS_4TypeES5_PNS_5ValueES7_NS_8ArrayRefINS_17OperandBundleDefTIS7_EEEEPNS_8FunctionERKNS_5TwineE")
//</editor-fold>
public static Instruction /*P*/ createMalloc(Instruction /*P*/ InsertBefore, 
            BasicBlock /*P*/ InsertAtEnd, Type /*P*/ IntPtrTy, 
            Type /*P*/ AllocTy, Value /*P*/ AllocSize, 
            Value /*P*/ ArraySize, 
            ArrayRef<OperandBundleDefT<Value /*P*/ >> OpB, 
            Function /*P*/ MallocF, final /*const*/ Twine /*&*/ Name) {
  assert (((!(InsertBefore != null) && (InsertAtEnd != null)) || ((InsertBefore != null) && !(InsertAtEnd != null)))) : "createMalloc needs either InsertBefore or InsertAtEnd";
  
  // malloc(type) becomes: 
  //       bitcast (i8* malloc(typeSize)) to type*
  // malloc(type, arraySize) becomes:
  //       bitcast (i8* malloc(typeSize*arraySize)) to type*
  if (!(ArraySize != null)) {
    ArraySize = ConstantInt.get(IntPtrTy, $int2ulong(1));
  } else if (ArraySize.getType() != IntPtrTy) {
    if ((InsertBefore != null)) {
      ArraySize = CastInst.CreateIntegerCast(ArraySize, IntPtrTy, false, 
          new Twine(/*KEEP_STR*/$EMPTY), InsertBefore);
    } else {
      ArraySize = CastInst.CreateIntegerCast(ArraySize, IntPtrTy, false, 
          new Twine(/*KEEP_STR*/$EMPTY), InsertAtEnd);
    }
  }
  if (!IsConstantOne(ArraySize)) {
    if (IsConstantOne(AllocSize)) {
      AllocSize = ArraySize; // Operand * 1 = Operand
    } else {
      Constant /*P*/ CO = dyn_cast_Constant(ArraySize);
      if ((CO != null)) {
        Constant /*P*/ Scale = ConstantExpr.getIntegerCast(CO, IntPtrTy, 
            false/*ZExt*/);
        // Malloc arg is constant product of type size and array size
        AllocSize = ConstantExpr.getMul(Scale, cast_Constant(AllocSize));
      } else {
        // Multiply type size by the array size...
        if ((InsertBefore != null)) {
          AllocSize = BinaryOperator.CreateMul(ArraySize, AllocSize, 
              new Twine(/*KEEP_STR*/"mallocsize"), InsertBefore);
        } else {
          AllocSize = BinaryOperator.CreateMul(ArraySize, AllocSize, 
              new Twine(/*KEEP_STR*/"mallocsize"), InsertAtEnd);
        }
      }
    }
  }
  assert (AllocSize.getType() == IntPtrTy) : "malloc arg is wrong size";
  // Create the call to Malloc.
  BasicBlock /*P*/ BB = (InsertBefore != null) ? InsertBefore.getParent() : InsertAtEnd;
  Module /*P*/ M = BB.getParent().getParent();
  Type /*P*/ BPTy = Type.getInt8PtrTy(BB.getContext());
  Value /*P*/ MallocFunc = MallocF;
  if (!(MallocFunc != null)) {
    // prototype malloc as "void *malloc(size_t)"
    MallocFunc = M.getOrInsertFunction(new StringRef(/*KEEP_STR*/"malloc"), BPTy, IntPtrTy, null);
  }
  PointerType /*P*/ AllocPtrType = PointerType.getUnqual(AllocTy);
  CallInst /*P*/ MCall = null;
  Instruction /*P*/ Result = null;
  if ((InsertBefore != null)) {
    MCall = CallInst.Create_Value1(MallocFunc, new ArrayRef<Value /*P*/ >(AllocSize, true), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(OpB), new Twine(/*KEEP_STR*/"malloccall"), 
        InsertBefore);
    Result = MCall;
    if (Result.getType() != AllocPtrType) {
      // Create a cast instruction to convert to the right type...
      CallInst /*P*/ MCall_final = MCall;
      Result = /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new BitCastInst(MCall_final, AllocPtrType, Name, InsertBefore);
       });
    }
  } else {
    MCall = CallInst.Create_Value1(MallocFunc, new ArrayRef<Value /*P*/ >(AllocSize, true), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(OpB), new Twine(/*KEEP_STR*/"malloccall"));
    Result = MCall;
    if (Result.getType() != AllocPtrType) {
      InsertAtEnd.getInstList().push_back(MCall);
      // Create a cast instruction to convert to the right type...
      CallInst /*P*/ MCall_final = MCall;
      Result = /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new BitCastInst(MCall_final, AllocPtrType, Name);
       });
    }
  }
  MCall.setTailCall();
  {
    Function /*P*/ F = dyn_cast_Function(MallocFunc);
    if ((F != null)) {
      MCall.setCallingConv(F.getCallingConv());
      if (!F.doesNotAlias(0)) {
        F.setDoesNotAlias(0);
      }
    }
  }
  assert (!MCall.getType().isVoidTy()) : "Malloc has void return type";
  
  return Result;
}

//<editor-fold defaultstate="collapsed" desc="createFree">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 571,
 FQN="createFree", NM="_ZL10createFreePN4llvm5ValueENS_8ArrayRefINS_17OperandBundleDefTIS1_EEEEPNS_11InstructionEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZL10createFreePN4llvm5ValueENS_8ArrayRefINS_17OperandBundleDefTIS1_EEEEPNS_11InstructionEPNS_10BasicBlockE")
//</editor-fold>
public static Instruction /*P*/ createFree(Value /*P*/ Source, 
          ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles, 
          Instruction /*P*/ InsertBefore, 
          BasicBlock /*P*/ InsertAtEnd) {
  assert (((!(InsertBefore != null) && (InsertAtEnd != null)) || ((InsertBefore != null) && !(InsertAtEnd != null)))) : "createFree needs either InsertBefore or InsertAtEnd";
  assert (Source.getType().isPointerTy()) : "Can not free something of nonpointer type!";
  
  BasicBlock /*P*/ BB = (InsertBefore != null) ? InsertBefore.getParent() : InsertAtEnd;
  Module /*P*/ M = BB.getParent().getParent();
  
  Type /*P*/ VoidTy = Type.getVoidTy(M.getContext());
  Type /*P*/ IntPtrTy = Type.getInt8PtrTy(M.getContext());
  // prototype free as "void free(void*)"
  Value /*P*/ FreeFunc = M.getOrInsertFunction(new StringRef(/*KEEP_STR*/"free"), VoidTy, IntPtrTy, null);
  CallInst /*P*/ Result = null;
  Value /*P*/ PtrCast = Source;
  if ((InsertBefore != null)) {
    if (Source.getType() != IntPtrTy) {
      PtrCast = /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new BitCastInst(Source, IntPtrTy, new Twine(/*KEEP_STR*/$EMPTY), InsertBefore);
       });
    }
    Result = CallInst.Create_Value1(FreeFunc, new ArrayRef<Value /*P*/ >(PtrCast, true), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles), new Twine(/*KEEP_STR*/$EMPTY), InsertBefore);
  } else {
    if (Source.getType() != IntPtrTy) {
      PtrCast = /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
          return new BitCastInst(Source, IntPtrTy, new Twine(/*KEEP_STR*/$EMPTY), InsertAtEnd);
       });
    }
    Result = CallInst.Create_Value1(FreeFunc, new ArrayRef<Value /*P*/ >(PtrCast, true), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles), new Twine(/*KEEP_STR*/$EMPTY));
  }
  Result.setTailCall();
  {
    Function /*P*/ F = dyn_cast_Function(FreeFunc);
    if ((F != null)) {
      Result.setCallingConv(F.getCallingConv());
    }
  }
  
  return Result;
}


//===----------------------------------------------------------------------===//
//                        AllocaInst Implementation
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="getAISize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1238,
 FQN="getAISize", NM="_ZL9getAISizeRN4llvm11LLVMContextEPNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZL9getAISizeRN4llvm11LLVMContextEPNS_5ValueE")
//</editor-fold>
public static Value /*P*/ getAISize(final LLVMContext /*&*/ Context, Value /*P*/ Amt) {
  if (!(Amt != null)) {
    Amt = ConstantInt.get(Type.getInt32Ty(Context), $int2ulong(1));
  } else {
    assert (!isa_BasicBlock(Amt)) : "Passed basic block into allocation size parameter! Use other ctor";
    assert (Amt.getType().isIntegerTy()) : "Allocation array size is not an integer!";
  }
  return Amt;
}


/// getIndexedType - Returns the type of the element that would be accessed with
/// a gep instruction with the specified parameters.
///
/// The Idxs pointer should point to a continuous piece of memory containing the
/// indices, either as Value* or uint64_t.
///
/// A null type is returned if the indices are invalid for the specified
/// pointer type.
///
/*template <typename IndexTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="getIndexedTypeInternal">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1671,
 FQN="getIndexedTypeInternal", NM="Tpl__ZL22getIndexedTypeInternalPN4llvm4TypeENS_8ArrayRefIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZL22getIndexedTypeInternalPN4llvm4TypeENS_8ArrayRefIT_EE")
//</editor-fold>
public static </*typename*/ IndexTy extends Value> Type /*P*/ getIndexedTypeInternal(Type /*P*/ Agg, ArrayRef<IndexTy> IdxList) {
  // Handle the special case of the empty set index set, which is always valid.
  if (IdxList.empty()) {
    return Agg;
  }
  
  // If there is at least one index, the top level type must be sized, otherwise
  // it cannot be 'stepped over'.
  if (!Agg.isSized()) {
    return null;
  }
  
  /*uint*/int CurIdx = 1;
  for (; Native.$noteq(CurIdx, IdxList.size()); ++CurIdx) {
    CompositeType /*P*/ CT = dyn_cast_CompositeType(Agg);
    if (!(CT != null) || CT.isPointerTy()) {
      return null;
    }
    IndexTy Index = IdxList.$at(CurIdx);
    if (Native.$not(CT.indexValid(Index))) {
      return null;
    }
    Agg = CT.getTypeAtIndex(Index);
  }
  return Native.$eq(CurIdx, IdxList.size()) ? Agg : null;
}
//template <typename IndexTy = unsigned long long> 
//<editor-fold defaultstate="collapsed" desc="getIndexedTypeInternal">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1671,
 FQN="getIndexedTypeInternal", NM="_ZL22getIndexedTypeInternalIyEPN4llvm4TypeES2_NS0_8ArrayRefIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZL22getIndexedTypeInternalIyEPN4llvm4TypeES2_NS0_8ArrayRefIT_EE")
//</editor-fold>
public static Type /*P*/ getIndexedTypeInternal$ULLong(Type /*P*/ Agg, ArrayRefULong IdxList) {
  if (IdxList.empty()) {
    return Agg;
  }
  if (!Agg.isSized()) {
    return null;
  }
  
  /*uint*/int CurIdx = 1;
  for (; CurIdx != IdxList.size(); ++CurIdx) {
    CompositeType /*P*/ CT = dyn_cast_CompositeType(Agg);
    if (!(CT != null) || CT.isPointerTy()) {
      return null;
    }
    /*ullong*/long Index = IdxList.$at(CurIdx);
    if (!CT.indexValid($ullong2uint(Index))) {
      return null;
    }
    Agg = CT.getTypeAtIndex($ullong2uint(Index));
  }
  return CurIdx == IdxList.size() ? Agg : null;
}

// isConstantAllOnes - Helper function for several functions below
//<editor-fold defaultstate="collapsed" desc="isConstantAllOnes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2227,
 FQN="isConstantAllOnes", NM="_ZL17isConstantAllOnesPKN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZL17isConstantAllOnesPKN4llvm5ValueE")
//</editor-fold>
public static /*inline*/ boolean isConstantAllOnes(/*const*/ Value /*P*/ V) {
  {
    /*const*/ Constant /*P*/ C = dyn_cast_Constant(V);
    if ((C != null)) {
      return C.isAllOnesValue();
    }
  }
  return false;
}

} // END OF class InstructionsStatics
