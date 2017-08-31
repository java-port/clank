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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.intrinsic.ID;
import static org.clang.ast.java.AstRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.clang.basic.target.*;


//<editor-fold defaultstate="collapsed" desc="static type CGBuiltinStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_CGBuiltin_cpp_Unnamed_enum;_ZL11EmitFromIntRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS_8QualTypeEPNS3_4TypeE;_ZL11EmitSignBitRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE;_ZL11GetNeonTypePN5clang7CodeGen15CodeGenFunctionENS_13NeonTypeFlagsEb;_ZL13EmitX86SelectRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueES5_S5_;_ZL15emitLibraryCallRN5clang7CodeGen15CodeGenFunctionEPKNS_12FunctionDeclEPKNS_8CallExprEPN4llvm5ValueE;_ZL15getMaskVecValueRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueEj;_ZL16EmitBinaryAtomicRN5clang7CodeGen15CodeGenFunctionEN4llvm13AtomicRMWInst5BinOpEPKNS_8CallExprE;_ZL16GetFloatNeonTypePN5clang7CodeGen15CodeGenFunctionENS_13NeonTypeFlagsE;_ZL16emitFPIntBuiltinRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprEj;_ZL16emitUnaryBuiltinRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprEj;_ZL17EmitX86MaskedLoadRN5clang7CodeGen15CodeGenFunctionERN4llvm15SmallVectorImplIPNS3_5ValueEEEj;_ZL17emitBinaryBuiltinRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprEj;_ZL17emitRangedBuiltinRN5clang7CodeGen15CodeGenFunctionEjii;_ZL18EmitX86MaskedStoreRN5clang7CodeGen15CodeGenFunctionERN4llvm15SmallVectorImplIPNS3_5ValueEEEj;_ZL18emitTernaryBuiltinRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprEj;_ZL18packTBLDVectorListRN5clang7CodeGen15CodeGenFunctionEN4llvm8ArrayRefIPNS3_5ValueEEES6_S6_PNS3_4TypeEjPKc;_ZL19ARMSIMDIntrinsicMap;_ZL19EmitNontemporalLoadRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprE;_ZL20EmitBinaryAtomicPostRN5clang7CodeGen15CodeGenFunctionEN4llvm13AtomicRMWInst5BinOpEPKNS_8CallExprENS3_11Instruction9BinaryOpsEb;_ZL20EmitNontemporalStoreRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprE;_ZL20EmitX86MaskedCompareRN5clang7CodeGen15CodeGenFunctionEjbRN4llvm15SmallVectorImplIPNS3_5ValueEEE;_ZL20HasExtraNeonArgumentj;_ZL21EmitOverflowIntrinsicRN5clang7CodeGen15CodeGenFunctionEN4llvm9Intrinsic2IDEPNS3_5ValueES7_RS7_;_ZL21MakeBinaryAtomicValueRN5clang7CodeGen15CodeGenFunctionEN4llvm13AtomicRMWInst5BinOpEPKNS_8CallExprE;_ZL21areBOSTypesCompatibleii;_ZL22MakeAtomicCmpXchgValueRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprEb;_ZL22findNeonIntrinsicInMapN4llvm8ArrayRefIN12_GLOBAL__N_117NeonIntrinsicInfoEEEjRb;_ZL23AArch64SIMDIntrinsicMap;_ZL23AArch64SISDIntrinsicMap;_ZL23EncompassingIntegerTypeN4llvm8ArrayRefIN12_GLOBAL__N_118WidthAndSignednessEEE;_ZL25EmitAArch64TblBuiltinExprRN5clang7CodeGen15CodeGenFunctionEjPKNS_8CallExprERN4llvm15SmallVectorImplIPNS6_5ValueEEE;_ZL25EmitTargetArchBuiltinExprPN5clang7CodeGen15CodeGenFunctionEjPKNS_8CallExprEN4llvm6Triple8ArchTypeE;_ZL26EmitSpecialRegisterBuiltinRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprEPN4llvm4TypeES8_bNS6_9StringRefE;_ZL26EmitSystemZIntrinsicWithCCRN5clang7CodeGen15CodeGenFunctionEjPKNS_8CallExprE;_ZL28getIntegerWidthAndSignednessRKN5clang10ASTContextENS_8QualTypeE;_ZL29EmitCommonNeonSISDBuiltinExprRN5clang7CodeGen15CodeGenFunctionERKN12_GLOBAL__N_117NeonIntrinsicInfoERN4llvm15SmallVectorImplIPNS7_5ValueEEEPKNS_8CallExprE;_ZL30NEONSIMDIntrinsicsProvenSorted;_ZL33AArch64SIMDIntrinsicsProvenSorted;_ZL33AArch64SISDIntrinsicsProvenSorted;_ZL33getDefaultBuiltinObjectSizeResultjPN4llvm11IntegerTypeE;_ZL8EmitFAbsRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE;_ZL9EmitToIntRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS_8QualTypeEPNS3_11IntegerTypeE; -static-type=CGBuiltinStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGBuiltinStatics {


/// Emit the conversions required to turn the given value into an
/// integer of the given size.
//<editor-fold defaultstate="collapsed" desc="EmitToInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 62,
 FQN="EmitToInt", NM="_ZL9EmitToIntRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS_8QualTypeEPNS3_11IntegerTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL9EmitToIntRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS_8QualTypeEPNS3_11IntegerTypeE")
//</editor-fold>
public static Value /*P*/ EmitToInt(final CodeGenFunction /*&*/ CGF, Value /*P*/ V, 
         QualType T, IntegerType /*P*/ IntType) {
  V = CGF.EmitToMemory(V, new QualType(T));
  if (V.getType().isPointerTy()) {
    return CGF.Builder.CreatePtrToInt(V, IntType);
  }
  assert (V.getType() == IntType);
  return V;
}

//<editor-fold defaultstate="collapsed" desc="EmitFromInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 73,
 FQN="EmitFromInt", NM="_ZL11EmitFromIntRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS_8QualTypeEPNS3_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL11EmitFromIntRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS_8QualTypeEPNS3_4TypeE")
//</editor-fold>
public static Value /*P*/ EmitFromInt(final CodeGenFunction /*&*/ CGF, Value /*P*/ V, 
           QualType T, org.llvm.ir.Type /*P*/ ResultType) {
  V = CGF.EmitFromMemory(V, new QualType(T));
  if (ResultType.isPointerTy()) {
    return CGF.Builder.CreateIntToPtr(V, ResultType);
  }
  assert (V.getType() == ResultType);
  return V;
}


/// Utility to insert an atomic instruction based on Instrinsic::ID
/// and the expression node.
//<editor-fold defaultstate="collapsed" desc="MakeBinaryAtomicValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 86,
 FQN="MakeBinaryAtomicValue", NM="_ZL21MakeBinaryAtomicValueRN5clang7CodeGen15CodeGenFunctionEN4llvm13AtomicRMWInst5BinOpEPKNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL21MakeBinaryAtomicValueRN5clang7CodeGen15CodeGenFunctionEN4llvm13AtomicRMWInst5BinOpEPKNS_8CallExprE")
//</editor-fold>
public static Value /*P*/ MakeBinaryAtomicValue(final CodeGenFunction /*&*/ CGF, 
                     AtomicRMWInst.BinOp Kind, 
                     /*const*/ CallExpr /*P*/ E) {
  QualType T = E.getType();
  assert (E.getArg$Const(0).getType().$arrow().isPointerType());
  assert (CGF.getContext().hasSameUnqualifiedType(new QualType(T), E.getArg$Const(0).getType().$arrow().getPointeeType()));
  assert (CGF.getContext().hasSameUnqualifiedType(new QualType(T), E.getArg$Const(1).getType()));
  
  Value /*P*/ DestPtr = CGF.EmitScalarExpr(E.getArg$Const(0));
  /*uint*/int AddrSpace = DestPtr.getType().getPointerAddressSpace();
  
  IntegerType /*P*/ IntType = IntegerType.get(CGF.getLLVMContext(), 
      $ulong2uint(CGF.getContext().getTypeSize(new QualType(T))));
  org.llvm.ir.Type /*P*/ IntPtrType = IntType.getPointerTo(AddrSpace);
  
  Value /*P*/ Args[/*2*/] = new Value /*P*/  [2];
  Args[0] = CGF.Builder.CreateBitCast(DestPtr, IntPtrType);
  Args[1] = CGF.EmitScalarExpr(E.getArg$Const(1));
  org.llvm.ir.Type /*P*/ ValueType = Args[1].getType();
  Args[1] = EmitToInt(CGF, Args[1], new QualType(T), IntType);
  
  Value /*P*/ Result = CGF.Builder.CreateAtomicRMW(Kind, Args[0], Args[1], AtomicOrdering.SequentiallyConsistent);
  return EmitFromInt(CGF, Result, new QualType(T), ValueType);
}

//<editor-fold defaultstate="collapsed" desc="EmitNontemporalStore">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 114,
 FQN="EmitNontemporalStore", NM="_ZL20EmitNontemporalStoreRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL20EmitNontemporalStoreRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprE")
//</editor-fold>
public static Value /*P*/ EmitNontemporalStore(final CodeGenFunction /*&*/ CGF, /*const*/ CallExpr /*P*/ E) {
  Value /*P*/ Val = CGF.EmitScalarExpr(E.getArg$Const(0));
  Value /*P*/ Address = CGF.EmitScalarExpr(E.getArg$Const(1));
  
  // Convert the type of the pointer to a pointer to the stored type.
  Val = CGF.EmitToMemory(Val, E.getArg$Const(0).getType());
  Value /*P*/ BC = CGF.Builder.CreateBitCast(Address, org.llvm.ir.PointerType.getUnqual(Val.getType()), new Twine(/*KEEP_STR*/"cast"));
  LValue LV = CGF.MakeNaturalAlignAddrLValue(BC, E.getArg$Const(0).getType());
  LV.setNontemporal(true);
  CGF.EmitStoreOfScalar(Val, new LValue(LV), false);
  return null;
}

//<editor-fold defaultstate="collapsed" desc="EmitNontemporalLoad">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 128,
 FQN="EmitNontemporalLoad", NM="_ZL19EmitNontemporalLoadRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL19EmitNontemporalLoadRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprE")
//</editor-fold>
public static Value /*P*/ EmitNontemporalLoad(final CodeGenFunction /*&*/ CGF, /*const*/ CallExpr /*P*/ E) {
  Value /*P*/ Address = CGF.EmitScalarExpr(E.getArg$Const(0));
  
  LValue LV = CGF.MakeNaturalAlignAddrLValue(Address, E.getType());
  LV.setNontemporal(true);
  return CGF.EmitLoadOfScalar(new LValue(LV), E.getExprLoc());
}

//<editor-fold defaultstate="collapsed" desc="EmitBinaryAtomic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 136,
 FQN="EmitBinaryAtomic", NM="_ZL16EmitBinaryAtomicRN5clang7CodeGen15CodeGenFunctionEN4llvm13AtomicRMWInst5BinOpEPKNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL16EmitBinaryAtomicRN5clang7CodeGen15CodeGenFunctionEN4llvm13AtomicRMWInst5BinOpEPKNS_8CallExprE")
//</editor-fold>
public static RValue EmitBinaryAtomic(final CodeGenFunction /*&*/ CGF, 
                AtomicRMWInst.BinOp Kind, 
                /*const*/ CallExpr /*P*/ E) {
  return RValue.get(MakeBinaryAtomicValue(CGF, Kind, E));
}


/// Utility to insert an atomic instruction based Instrinsic::ID and
/// the expression node, where the return value is the result of the
/// operation.
//<editor-fold defaultstate="collapsed" desc="EmitBinaryAtomicPost">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 145,
 FQN="EmitBinaryAtomicPost", NM="_ZL20EmitBinaryAtomicPostRN5clang7CodeGen15CodeGenFunctionEN4llvm13AtomicRMWInst5BinOpEPKNS_8CallExprENS3_11Instruction9BinaryOpsEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL20EmitBinaryAtomicPostRN5clang7CodeGen15CodeGenFunctionEN4llvm13AtomicRMWInst5BinOpEPKNS_8CallExprENS3_11Instruction9BinaryOpsEb")
//</editor-fold>
public static RValue EmitBinaryAtomicPost(final CodeGenFunction /*&*/ CGF, 
                    AtomicRMWInst.BinOp Kind, 
                    /*const*/ CallExpr /*P*/ E, 
                    /*BinaryOps*/int Op) {
  return EmitBinaryAtomicPost(CGF, 
                    Kind, 
                    E, 
                    Op, 
                    false);
}
public static RValue EmitBinaryAtomicPost(final CodeGenFunction /*&*/ CGF, 
                    AtomicRMWInst.BinOp Kind, 
                    /*const*/ CallExpr /*P*/ E, 
                    /*BinaryOps*/int Op, 
                    boolean Invert/*= false*/) {
  QualType T = E.getType();
  assert (E.getArg$Const(0).getType().$arrow().isPointerType());
  assert (CGF.getContext().hasSameUnqualifiedType(new QualType(T), E.getArg$Const(0).getType().$arrow().getPointeeType()));
  assert (CGF.getContext().hasSameUnqualifiedType(new QualType(T), E.getArg$Const(1).getType()));
  
  Value /*P*/ DestPtr = CGF.EmitScalarExpr(E.getArg$Const(0));
  /*uint*/int AddrSpace = DestPtr.getType().getPointerAddressSpace();
  
  IntegerType /*P*/ IntType = IntegerType.get(CGF.getLLVMContext(), 
      $ulong2uint(CGF.getContext().getTypeSize(new QualType(T))));
  org.llvm.ir.Type /*P*/ IntPtrType = IntType.getPointerTo(AddrSpace);
  
  Value /*P*/ Args[/*2*/] = new Value /*P*/  [2];
  Args[1] = CGF.EmitScalarExpr(E.getArg$Const(1));
  org.llvm.ir.Type /*P*/ ValueType = Args[1].getType();
  Args[1] = EmitToInt(CGF, Args[1], new QualType(T), IntType);
  Args[0] = CGF.Builder.CreateBitCast(DestPtr, IntPtrType);
  
  Value /*P*/ Result = CGF.Builder.CreateAtomicRMW(Kind, Args[0], Args[1], AtomicOrdering.SequentiallyConsistent);
  Result = CGF.Builder.CreateBinOp(Op, Result, Args[1]);
  if (Invert) {
    Result = CGF.Builder.CreateBinOp(Instruction.BinaryOps.Xor, Result, 
        ConstantInt.get(IntType, $int2ulong(-1)));
  }
  Result = EmitFromInt(CGF, Result, new QualType(T), ValueType);
  return RValue.get(Result);
}


/// @brief Utility to insert an atomic cmpxchg instruction.
///
/// @param CGF The current codegen function.
/// @param E   Builtin call expression to convert to cmpxchg.
///            arg0 - address to operate on
///            arg1 - value to compare with
///            arg2 - new value
/// @param ReturnBool Specifies whether to return success flag of
///                   cmpxchg result or the old value.
///
/// @returns result of cmpxchg, according to ReturnBool
//<editor-fold defaultstate="collapsed" desc="MakeAtomicCmpXchgValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 191,
 FQN="MakeAtomicCmpXchgValue", NM="_ZL22MakeAtomicCmpXchgValueRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL22MakeAtomicCmpXchgValueRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprEb")
//</editor-fold>
public static Value /*P*/ MakeAtomicCmpXchgValue(final CodeGenFunction /*&*/ CGF, /*const*/ CallExpr /*P*/ E, 
                      boolean ReturnBool) {
  QualType T = ReturnBool ? E.getArg$Const(1).getType() : E.getType();
  Value /*P*/ DestPtr = CGF.EmitScalarExpr(E.getArg$Const(0));
  /*uint*/int AddrSpace = DestPtr.getType().getPointerAddressSpace();
  
  IntegerType /*P*/ IntType = IntegerType.get(CGF.getLLVMContext(), $ulong2uint(CGF.getContext().getTypeSize(new QualType(T))));
  org.llvm.ir.Type /*P*/ IntPtrType = IntType.getPointerTo(AddrSpace);
  
  Value /*P*/ Args[/*3*/] = new Value /*P*/  [3];
  Args[0] = CGF.Builder.CreateBitCast(DestPtr, IntPtrType);
  Args[1] = CGF.EmitScalarExpr(E.getArg$Const(1));
  org.llvm.ir.Type /*P*/ ValueType = Args[1].getType();
  Args[1] = EmitToInt(CGF, Args[1], new QualType(T), IntType);
  Args[2] = EmitToInt(CGF, CGF.EmitScalarExpr(E.getArg$Const(2)), new QualType(T), IntType);
  
  Value /*P*/ Pair = CGF.Builder.CreateAtomicCmpXchg(Args[0], Args[1], Args[2], AtomicOrdering.SequentiallyConsistent, 
      AtomicOrdering.SequentiallyConsistent);
  if (ReturnBool) {
    // Extract boolean success flag and zext it to int.
    return CGF.Builder.CreateZExt(CGF.Builder.CreateExtractValue(Pair, new ArrayRefUInt(1)), 
        CGF.ConvertType(E.getType()));
  } else {
    // Extract old value and emit it using the same type as compare value.
    return EmitFromInt(CGF, CGF.Builder.CreateExtractValue(Pair, new ArrayRefUInt(0)), new QualType(T), 
        ValueType);
  }
}


// Emit a simple mangled intrinsic that has 1 argument and a return type
// matching the argument type.
//<editor-fold defaultstate="collapsed" desc="emitUnaryBuiltin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 223,
 FQN="emitUnaryBuiltin", NM="_ZL16emitUnaryBuiltinRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL16emitUnaryBuiltinRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprEj")
//</editor-fold>
public static Value /*P*/ emitUnaryBuiltin(final CodeGenFunction /*&*/ CGF, 
                /*const*/ CallExpr /*P*/ E, 
                /*uint*/int IntrinsicID) {
  Value /*P*/ Src0 = CGF.EmitScalarExpr(E.getArg$Const(0));
  
  Value /*P*/ F = CGF.CGM.getIntrinsic(IntrinsicID, new ArrayRef<org.llvm.ir.Type /*P*/ >(Src0.getType(), true));
  return CGF.Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(Src0, true));
}


// Emit an intrinsic that has 2 operands of the same type as its result.
//<editor-fold defaultstate="collapsed" desc="emitBinaryBuiltin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 233,
 FQN="emitBinaryBuiltin", NM="_ZL17emitBinaryBuiltinRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL17emitBinaryBuiltinRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprEj")
//</editor-fold>
public static Value /*P*/ emitBinaryBuiltin(final CodeGenFunction /*&*/ CGF, 
                 /*const*/ CallExpr /*P*/ E, 
                 /*uint*/int IntrinsicID) {
  Value /*P*/ Src0 = CGF.EmitScalarExpr(E.getArg$Const(0));
  Value /*P*/ Src1 = CGF.EmitScalarExpr(E.getArg$Const(1));
  
  Value /*P*/ F = CGF.CGM.getIntrinsic(IntrinsicID, new ArrayRef<org.llvm.ir.Type /*P*/ >(Src0.getType(), true));
  return CGF.Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Src0, Src1}, true)/* }*/);
}


// Emit an intrinsic that has 3 operands of the same type as its result.
//<editor-fold defaultstate="collapsed" desc="emitTernaryBuiltin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 244,
 FQN="emitTernaryBuiltin", NM="_ZL18emitTernaryBuiltinRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL18emitTernaryBuiltinRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprEj")
//</editor-fold>
public static Value /*P*/ emitTernaryBuiltin(final CodeGenFunction /*&*/ CGF, 
                  /*const*/ CallExpr /*P*/ E, 
                  /*uint*/int IntrinsicID) {
  Value /*P*/ Src0 = CGF.EmitScalarExpr(E.getArg$Const(0));
  Value /*P*/ Src1 = CGF.EmitScalarExpr(E.getArg$Const(1));
  Value /*P*/ Src2 = CGF.EmitScalarExpr(E.getArg$Const(2));
  
  Value /*P*/ F = CGF.CGM.getIntrinsic(IntrinsicID, new ArrayRef<org.llvm.ir.Type /*P*/ >(Src0.getType(), true));
  return CGF.Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {Src0, Src1, Src2}, true)/* }*/);
}


// Emit an intrinsic that has 1 float or double operand, and 1 integer.
//<editor-fold defaultstate="collapsed" desc="emitFPIntBuiltin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 256,
 FQN="emitFPIntBuiltin", NM="_ZL16emitFPIntBuiltinRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL16emitFPIntBuiltinRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprEj")
//</editor-fold>
public static Value /*P*/ emitFPIntBuiltin(final CodeGenFunction /*&*/ CGF, 
                /*const*/ CallExpr /*P*/ E, 
                /*uint*/int IntrinsicID) {
  Value /*P*/ Src0 = CGF.EmitScalarExpr(E.getArg$Const(0));
  Value /*P*/ Src1 = CGF.EmitScalarExpr(E.getArg$Const(1));
  
  Value /*P*/ F = CGF.CGM.getIntrinsic(IntrinsicID, new ArrayRef<org.llvm.ir.Type /*P*/ >(Src0.getType(), true));
  return CGF.Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Src0, Src1}, true)/* }*/);
}


/// EmitFAbs - Emit a call to @llvm.fabs().
//<editor-fold defaultstate="collapsed" desc="EmitFAbs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 267,
 FQN="EmitFAbs", NM="_ZL8EmitFAbsRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL8EmitFAbsRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE")
//</editor-fold>
public static Value /*P*/ EmitFAbs(final CodeGenFunction /*&*/ CGF, Value /*P*/ V) {
  Value /*P*/ F = CGF.CGM.getIntrinsic(ID.fabs, new ArrayRef<org.llvm.ir.Type /*P*/ >(V.getType(), true));
  CallInst /*P*/ Call = CGF.Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(V, true));
  Call.setDoesNotAccessMemory();
  return Call;
}


/// Emit the computation of the sign bit for a floating point value. Returns
/// the i1 sign bit value.
//<editor-fold defaultstate="collapsed" desc="EmitSignBit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 276,
 FQN="EmitSignBit", NM="_ZL11EmitSignBitRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL11EmitSignBitRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE")
//</editor-fold>
public static Value /*P*/ EmitSignBit(final CodeGenFunction /*&*/ CGF, Value /*P*/ V) {
  final LLVMContext /*&*/ C = CGF.CGM.getLLVMContext();
  
  org.llvm.ir.Type /*P*/ Ty = V.getType();
  int Width = Ty.getPrimitiveSizeInBits();
  org.llvm.ir.Type /*P*/ IntTy = IntegerType.get(C, Width);
  V = CGF.Builder.CreateBitCast(V, IntTy);
  if (Ty.isPPC_FP128Ty()) {
    // We want the sign bit of the higher-order double. The bitcast we just
    // did works as if the double-double was stored to memory and then
    // read as an i128. The "store" will put the higher-order double in the
    // lower address in both little- and big-Endian modes, but the "load"
    // will treat those bits as a different part of the i128: the low bits in
    // little-Endian, the high bits in big-Endian. Therefore, on big-Endian
    // we need to shift the high bits down to the low before truncating.
    Width >>= 1;
    if (CGF.getTarget().isBigEndian()) {
      Value /*P*/ ShiftCst = ConstantInt.get(IntTy, $int2ulong(Width));
      V = CGF.Builder.CreateLShr(V, ShiftCst);
    }
    // We are truncating value in order to extract the higher-order
    // double, which we will be using to extract the sign from.
    IntTy = IntegerType.get(C, Width);
    V = CGF.Builder.CreateTrunc(V, IntTy);
  }
  Value /*P*/ Zero = Constant.getNullValue(IntTy);
  return CGF.Builder.CreateICmpSLT(V, Zero);
}

//<editor-fold defaultstate="collapsed" desc="emitLibraryCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 305,
 FQN="emitLibraryCall", NM="_ZL15emitLibraryCallRN5clang7CodeGen15CodeGenFunctionEPKNS_12FunctionDeclEPKNS_8CallExprEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL15emitLibraryCallRN5clang7CodeGen15CodeGenFunctionEPKNS_12FunctionDeclEPKNS_8CallExprEPN4llvm5ValueE")
//</editor-fold>
public static RValue emitLibraryCall(final CodeGenFunction /*&*/ CGF, /*const*/ FunctionDecl /*P*/ Fn, 
               /*const*/ CallExpr /*P*/ E, Value /*P*/ calleeValue) {
  return CGF.EmitCall(E.getCallee$Const().getType(), calleeValue, E, 
      new ReturnValueSlot(), new CGCalleeInfo(Fn));
}


/// \brief Emit a call to llvm.{sadd,uadd,ssub,usub,smul,umul}.with.overflow.*
/// depending on IntrinsicID.
///
/// \arg CGF The current codegen function.
/// \arg IntrinsicID The ID for the Intrinsic we wish to generate.
/// \arg X The first argument to the llvm.*.with.overflow.*.
/// \arg Y The second argument to the llvm.*.with.overflow.*.
/// \arg Carry The carry returned by the llvm.*.with.overflow.*.
/// \returns The result (i.e. sum/product) returned by the intrinsic.
//<editor-fold defaultstate="collapsed" desc="EmitOverflowIntrinsic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 320,
 FQN="EmitOverflowIntrinsic", NM="_ZL21EmitOverflowIntrinsicRN5clang7CodeGen15CodeGenFunctionEN4llvm9Intrinsic2IDEPNS3_5ValueES7_RS7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL21EmitOverflowIntrinsicRN5clang7CodeGen15CodeGenFunctionEN4llvm9Intrinsic2IDEPNS3_5ValueES7_RS7_")
//</editor-fold>
public static Value /*P*/ EmitOverflowIntrinsic(final CodeGenFunction /*&*/ CGF, 
                     /*Intrinsic.ID*/int IntrinsicID, 
                     Value /*P*/ X, Value /*P*/ Y, 
                     final type$ref<Value /*P*/ /*&*/> Carry) {
  // Make sure we have integers of the same width.
  assert (X.getType() == Y.getType()) : "Arguments must be the same type. (Did you forget to make sure both arguments have the same integer width?)";
  
  Value /*P*/ Callee = CGF.CGM.getIntrinsic(IntrinsicID, new ArrayRef<org.llvm.ir.Type /*P*/ >(X.getType(), true));
  Value /*P*/ Tmp = CGF.Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(Callee, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {X, Y}, true)/* }*/);
  Carry.$set(CGF.Builder.CreateExtractValue(Tmp, new ArrayRefUInt(1)));
  return CGF.Builder.CreateExtractValue(Tmp, new ArrayRefUInt(0));
}

//<editor-fold defaultstate="collapsed" desc="emitRangedBuiltin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 335,
 FQN="emitRangedBuiltin", NM="_ZL17emitRangedBuiltinRN5clang7CodeGen15CodeGenFunctionEjii",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL17emitRangedBuiltinRN5clang7CodeGen15CodeGenFunctionEjii")
//</editor-fold>
public static Value /*P*/ emitRangedBuiltin(final CodeGenFunction /*&*/ CGF, 
                 /*uint*/int IntrinsicID, 
                 int low, int high) {
  MDBuilder MDHelper/*J*/= new MDBuilder(CGF.getLLVMContext());
  MDNode /*P*/ RNode = MDHelper.createRange(new APInt(32, $int2ulong(low)), new APInt(32, $int2ulong(high)));
  Value /*P*/ F = CGF.CGM.getIntrinsic(IntrinsicID, /*{ */new ArrayRef<org.llvm.ir.Type /*P*/ >(true)/* }*/);
  Instruction /*P*/ Call = CGF.Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F);
  Call.setMetadata(LLVMContext.Unnamed_enum.MD_range.getValue(), RNode);
  return Call;
}

//<editor-fold defaultstate="collapsed" desc="getIntegerWidthAndSignedness">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 353,
 FQN="getIntegerWidthAndSignedness", NM="_ZL28getIntegerWidthAndSignednessRKN5clang10ASTContextENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL28getIntegerWidthAndSignednessRKN5clang10ASTContextENS_8QualTypeE")
//</editor-fold>
public static WidthAndSignedness getIntegerWidthAndSignedness(final /*const*/ ASTContext /*&*/ context, 
                            /*const*/ QualType Type) {
  assert (Type.$arrow().isIntegerType()) : "Given type is not an integer.";
  /*uint*/int Width = $ullong2uint(Type.$arrow().isBooleanType() ? $int2ullong(1) : context.getTypeInfo(new QualType(Type)).Width);
  boolean Signed = Type.$arrow().isSignedIntegerType();
  return /*JAVA:InitListExpr*/new WidthAndSignedness(Width, Signed);
}


// Given one or more integer types, this function produces an integer type that
// encompasses them: any value in one of the given types could be expressed in
// the encompassing type.
//<editor-fold defaultstate="collapsed" desc="EncompassingIntegerType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 365,
 FQN="EncompassingIntegerType", NM="_ZL23EncompassingIntegerTypeN4llvm8ArrayRefIN12_GLOBAL__N_118WidthAndSignednessEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL23EncompassingIntegerTypeN4llvm8ArrayRefIN12_GLOBAL__N_118WidthAndSignednessEEE")
//</editor-fold>
public static  WidthAndSignedness EncompassingIntegerType(ArrayRef< WidthAndSignedness> Types) {
  assert ($greater_uint(Types.size(), 0)) : "Empty list of types.";
  
  // If any of the given types is signed, we must return a signed type.
  boolean Signed = false;
  for (final /*const*/ WidthAndSignedness /*&*/ Type : Types) {
    Signed |= Type.Signed;
  }
  
  // The encompassing type must have a width greater than or equal to the width
  // of the specified types.  Aditionally, if the encompassing type is signed,
  // its width must be strictly greater than the width of any unsigned types
  // given.
  /*uint*/int Width = 0;
  for (final /*const*/ WidthAndSignedness /*&*/ Type : Types) {
    /*uint*/int MinWidth = Type.Width + ((Signed && !Type.Signed) ? 1 : 0);
    if ($less_uint(Width, MinWidth)) {
      Width = MinWidth;
    }
  }
  
  return /*JAVA:InitListExpr*/new  WidthAndSignedness(Width, Signed);
}


/// Checks if using the result of __builtin_object_size(p, @p From) in place of
/// __builtin_object_size(p, @p To) is correct
//<editor-fold defaultstate="collapsed" desc="areBOSTypesCompatible">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 402,
 FQN="areBOSTypesCompatible", NM="_ZL21areBOSTypesCompatibleii",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL21areBOSTypesCompatibleii")
//</editor-fold>
public static boolean areBOSTypesCompatible(int From, int To) {
  // Note: Our __builtin_object_size implementation currently treats Type=0 and
  // Type=2 identically. Encoding this implementation detail here may make
  // improving __builtin_object_size difficult in the future, so it's omitted.
  return From == To || (From == 0 && To == 1) || (From == 3 && To == 2);
}

//<editor-fold defaultstate="collapsed" desc="getDefaultBuiltinObjectSizeResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 409,
 FQN="getDefaultBuiltinObjectSizeResult", NM="_ZL33getDefaultBuiltinObjectSizeResultjPN4llvm11IntegerTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL33getDefaultBuiltinObjectSizeResultjPN4llvm11IntegerTypeE")
//</editor-fold>
public static Value /*P*/ getDefaultBuiltinObjectSizeResult(/*uint*/int Type, IntegerType /*P*/ ResType) {
  return ConstantInt.get(ResType, $int2ulong(((Type & 2) != 0) ? 0 : -1), /*isSigned=*/ true);
}

//<editor-fold defaultstate="collapsed" desc="EmitTargetArchBuiltinExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 2476,
 FQN="EmitTargetArchBuiltinExpr", NM="_ZL25EmitTargetArchBuiltinExprPN5clang7CodeGen15CodeGenFunctionEjPKNS_8CallExprEN4llvm6Triple8ArchTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL25EmitTargetArchBuiltinExprPN5clang7CodeGen15CodeGenFunctionEjPKNS_8CallExprEN4llvm6Triple8ArchTypeE")
//</editor-fold>
public static Value /*P*/ EmitTargetArchBuiltinExpr(CodeGenFunction /*P*/ CGF, 
                         /*uint*/int BuiltinID, /*const*/ CallExpr /*P*/ E, 
                         Triple.ArchType Arch) {
  switch (Arch) {
   case arm:
   case armeb:
   case thumb:
   case thumbeb:
    return CGF.EmitARMBuiltinExpr(BuiltinID, E);
   case aarch64:
   case aarch64_be:
    return CGF.EmitAArch64BuiltinExpr(BuiltinID, E);
   case x86:
   case x86_64:
    return CGF.EmitX86BuiltinExpr(BuiltinID, E);
   case ppc:
   case ppc64:
   case ppc64le:
    return CGF.EmitPPCBuiltinExpr(BuiltinID, E);
   case r600:
   case amdgcn:
    return CGF.EmitAMDGPUBuiltinExpr(BuiltinID, E);
   case systemz:
    return CGF.EmitSystemZBuiltinExpr(BuiltinID, E);
   case nvptx:
   case nvptx64:
    return CGF.EmitNVPTXBuiltinExpr(BuiltinID, E);
   case wasm32:
   case wasm64:
    return CGF.EmitWebAssemblyBuiltinExpr(BuiltinID, E);
   default:
    return null;
  }
}

//<editor-fold defaultstate="collapsed" desc="GetNeonType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 2524,
 FQN="GetNeonType", NM="_ZL11GetNeonTypePN5clang7CodeGen15CodeGenFunctionENS_13NeonTypeFlagsEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL11GetNeonTypePN5clang7CodeGen15CodeGenFunctionENS_13NeonTypeFlagsEb")
//</editor-fold>
public static org.llvm.ir.VectorType /*P*/ GetNeonType(CodeGenFunction /*P*/ CGF, 
           NeonTypeFlags TypeFlags) {
  return GetNeonType(CGF, 
           TypeFlags, 
           false);
}
public static org.llvm.ir.VectorType /*P*/ GetNeonType(CodeGenFunction /*P*/ CGF, 
           NeonTypeFlags TypeFlags, 
           boolean V1Ty/*= false*/) {
  int IsQuad = (TypeFlags.isQuad() ? 1 : 0);
  switch (TypeFlags.getEltType()) {
   case Int8:
   case Poly8:
    return org.llvm.ir.VectorType.get(CGF.Int8Ty, V1Ty ? 1 : (8 << IsQuad));
   case Int16:
   case Poly16:
   case Float16:
    return org.llvm.ir.VectorType.get(CGF.Int16Ty, V1Ty ? 1 : (4 << IsQuad));
   case Int32:
    return org.llvm.ir.VectorType.get(CGF.Int32Ty, V1Ty ? 1 : (2 << IsQuad));
   case Int64:
   case Poly64:
    return org.llvm.ir.VectorType.get(CGF.Int64Ty, V1Ty ? 1 : (1 << IsQuad));
   case Poly128:
    // FIXME: i128 and f128 doesn't get fully support in Clang and llvm.
    // There is a lot of i128 and f128 API missing.
    // so we use v16i8 to represent poly128 and get pattern matched.
    return org.llvm.ir.VectorType.get(CGF.Int8Ty, 16);
   case Float32:
    return org.llvm.ir.VectorType.get(CGF.FloatTy, V1Ty ? 1 : (2 << IsQuad));
   case Float64:
    return org.llvm.ir.VectorType.get(CGF.DoubleTy, V1Ty ? 1 : (1 << IsQuad));
  }
  throw new llvm_unreachable("Unknown vector element type!");
}

//<editor-fold defaultstate="collapsed" desc="GetFloatNeonType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 2554,
 FQN="GetFloatNeonType", NM="_ZL16GetFloatNeonTypePN5clang7CodeGen15CodeGenFunctionENS_13NeonTypeFlagsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL16GetFloatNeonTypePN5clang7CodeGen15CodeGenFunctionENS_13NeonTypeFlagsE")
//</editor-fold>
public static org.llvm.ir.VectorType /*P*/ GetFloatNeonType(CodeGenFunction /*P*/ CGF, 
                NeonTypeFlags IntTypeFlags) {
  int IsQuad = (IntTypeFlags.isQuad() ? 1 : 0);
  switch (IntTypeFlags.getEltType()) {
   case Int32:
    return org.llvm.ir.VectorType.get(CGF.FloatTy, (2 << IsQuad));
   case Int64:
    return org.llvm.ir.VectorType.get(CGF.DoubleTy, (1 << IsQuad));
   default:
    throw new llvm_unreachable("Type can't be converted to floating-point!");
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 2625,
 FQN="(anonymous)", NM="_CGBuiltin_cpp_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_CGBuiltin_cpp_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int AddRetType = (1 << 0);
  public static final /*uint*/int Add1ArgType = (1 << 1);
  public static final /*uint*/int Add2ArgTypes = (1 << 2);
  
  public static final /*uint*/int VectorizeRetType = (1 << 3);
  public static final /*uint*/int VectorizeArgTypes = (1 << 4);
  
  public static final /*uint*/int InventFloatType = (1 << 5);
  public static final /*uint*/int UnsignedAlts = (1 << 6);
  
  public static final /*uint*/int Use64BitVectors = (1 << 7);
  public static final /*uint*/int Use128BitVectors = (1 << 8);
  
  public static final /*uint*/int Vectorize1ArgType = Add1ArgType | VectorizeArgTypes;
  public static final /*uint*/int VectorRet = AddRetType | VectorizeRetType;
  public static final /*uint*/int VectorRetGetArgs01 = AddRetType | Add2ArgTypes | VectorizeRetType | VectorizeArgTypes;
  public static final /*uint*/int FpCmpzModifiers = AddRetType | VectorizeRetType | Add1ArgType | InventFloatType;
/*}*/
//<editor-fold defaultstate="collapsed" desc="ARMSIMDIntrinsicMap">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 2676,
 FQN="ARMSIMDIntrinsicMap", NM="_ZL19ARMSIMDIntrinsicMap",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL19ARMSIMDIntrinsicMap")
//</editor-fold>
public static /*const*/ NeonIntrinsicInfo ARMSIMDIntrinsicMap[/*214*/] = new /*const*/ NeonIntrinsicInfo [/*214*/] {
  new NeonIntrinsicInfo($("vabd_v"), NEON.BI__builtin_neon_vabd_v, ID.arm_neon_vabdu, ID.arm_neon_vabds, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vabdq_v"), NEON.BI__builtin_neon_vabdq_v, ID.arm_neon_vabdu, ID.arm_neon_vabds, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vabs_v"), NEON.BI__builtin_neon_vabs_v, ID.arm_neon_vabs, 0, 0), 
  new NeonIntrinsicInfo($("vabsq_v"), NEON.BI__builtin_neon_vabsq_v, ID.arm_neon_vabs, 0, 0), 
  new NeonIntrinsicInfo($("vaddhn_v"), NEON.BI__builtin_neon_vaddhn_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vaesdq_v"), NEON.BI__builtin_neon_vaesdq_v, ID.arm_neon_aesd, 0, 0), 
  new NeonIntrinsicInfo($("vaeseq_v"), NEON.BI__builtin_neon_vaeseq_v, ID.arm_neon_aese, 0, 0), 
  new NeonIntrinsicInfo($("vaesimcq_v"), NEON.BI__builtin_neon_vaesimcq_v, ID.arm_neon_aesimc, 0, 0), 
  new NeonIntrinsicInfo($("vaesmcq_v"), NEON.BI__builtin_neon_vaesmcq_v, ID.arm_neon_aesmc, 0, 0), 
  new NeonIntrinsicInfo($("vbsl_v"), NEON.BI__builtin_neon_vbsl_v, ID.arm_neon_vbsl, 0, AddRetType), 
  new NeonIntrinsicInfo($("vbslq_v"), NEON.BI__builtin_neon_vbslq_v, ID.arm_neon_vbsl, 0, AddRetType), 
  new NeonIntrinsicInfo($("vcage_v"), NEON.BI__builtin_neon_vcage_v, ID.arm_neon_vacge, 0, 0), 
  new NeonIntrinsicInfo($("vcageq_v"), NEON.BI__builtin_neon_vcageq_v, ID.arm_neon_vacge, 0, 0), 
  new NeonIntrinsicInfo($("vcagt_v"), NEON.BI__builtin_neon_vcagt_v, ID.arm_neon_vacgt, 0, 0), 
  new NeonIntrinsicInfo($("vcagtq_v"), NEON.BI__builtin_neon_vcagtq_v, ID.arm_neon_vacgt, 0, 0), 
  new NeonIntrinsicInfo($("vcale_v"), NEON.BI__builtin_neon_vcale_v, ID.arm_neon_vacge, 0, 0), 
  new NeonIntrinsicInfo($("vcaleq_v"), NEON.BI__builtin_neon_vcaleq_v, ID.arm_neon_vacge, 0, 0), 
  new NeonIntrinsicInfo($("vcalt_v"), NEON.BI__builtin_neon_vcalt_v, ID.arm_neon_vacgt, 0, 0), 
  new NeonIntrinsicInfo($("vcaltq_v"), NEON.BI__builtin_neon_vcaltq_v, ID.arm_neon_vacgt, 0, 0), 
  new NeonIntrinsicInfo($("vcls_v"), NEON.BI__builtin_neon_vcls_v, ID.arm_neon_vcls, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vclsq_v"), NEON.BI__builtin_neon_vclsq_v, ID.arm_neon_vcls, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vclz_v"), NEON.BI__builtin_neon_vclz_v, ID.ctlz, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vclzq_v"), NEON.BI__builtin_neon_vclzq_v, ID.ctlz, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vcnt_v"), NEON.BI__builtin_neon_vcnt_v, ID.ctpop, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vcntq_v"), NEON.BI__builtin_neon_vcntq_v, ID.ctpop, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vcvt_f16_f32"), NEON.BI__builtin_neon_vcvt_f16_f32, ID.arm_neon_vcvtfp2hf, 0, 0), 
  new NeonIntrinsicInfo($("vcvt_f32_f16"), NEON.BI__builtin_neon_vcvt_f32_f16, ID.arm_neon_vcvthf2fp, 0, 0), 
  new NeonIntrinsicInfo($("vcvt_f32_v"), NEON.BI__builtin_neon_vcvt_f32_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vcvt_n_f32_v"), NEON.BI__builtin_neon_vcvt_n_f32_v, ID.arm_neon_vcvtfxu2fp, ID.arm_neon_vcvtfxs2fp, 0), 
  new NeonIntrinsicInfo($("vcvt_n_s32_v"), NEON.BI__builtin_neon_vcvt_n_s32_v, ID.arm_neon_vcvtfp2fxs, 0, 0), 
  new NeonIntrinsicInfo($("vcvt_n_s64_v"), NEON.BI__builtin_neon_vcvt_n_s64_v, ID.arm_neon_vcvtfp2fxs, 0, 0), 
  new NeonIntrinsicInfo($("vcvt_n_u32_v"), NEON.BI__builtin_neon_vcvt_n_u32_v, ID.arm_neon_vcvtfp2fxu, 0, 0), 
  new NeonIntrinsicInfo($("vcvt_n_u64_v"), NEON.BI__builtin_neon_vcvt_n_u64_v, ID.arm_neon_vcvtfp2fxu, 0, 0), 
  new NeonIntrinsicInfo($("vcvt_s32_v"), NEON.BI__builtin_neon_vcvt_s32_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vcvt_s64_v"), NEON.BI__builtin_neon_vcvt_s64_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vcvt_u32_v"), NEON.BI__builtin_neon_vcvt_u32_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vcvt_u64_v"), NEON.BI__builtin_neon_vcvt_u64_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vcvta_s32_v"), NEON.BI__builtin_neon_vcvta_s32_v, ID.arm_neon_vcvtas, 0, 0), 
  new NeonIntrinsicInfo($("vcvta_s64_v"), NEON.BI__builtin_neon_vcvta_s64_v, ID.arm_neon_vcvtas, 0, 0), 
  new NeonIntrinsicInfo($("vcvta_u32_v"), NEON.BI__builtin_neon_vcvta_u32_v, ID.arm_neon_vcvtau, 0, 0), 
  new NeonIntrinsicInfo($("vcvta_u64_v"), NEON.BI__builtin_neon_vcvta_u64_v, ID.arm_neon_vcvtau, 0, 0), 
  new NeonIntrinsicInfo($("vcvtaq_s32_v"), NEON.BI__builtin_neon_vcvtaq_s32_v, ID.arm_neon_vcvtas, 0, 0), 
  new NeonIntrinsicInfo($("vcvtaq_s64_v"), NEON.BI__builtin_neon_vcvtaq_s64_v, ID.arm_neon_vcvtas, 0, 0), 
  new NeonIntrinsicInfo($("vcvtaq_u32_v"), NEON.BI__builtin_neon_vcvtaq_u32_v, ID.arm_neon_vcvtau, 0, 0), 
  new NeonIntrinsicInfo($("vcvtaq_u64_v"), NEON.BI__builtin_neon_vcvtaq_u64_v, ID.arm_neon_vcvtau, 0, 0), 
  new NeonIntrinsicInfo($("vcvtm_s32_v"), NEON.BI__builtin_neon_vcvtm_s32_v, ID.arm_neon_vcvtms, 0, 0), 
  new NeonIntrinsicInfo($("vcvtm_s64_v"), NEON.BI__builtin_neon_vcvtm_s64_v, ID.arm_neon_vcvtms, 0, 0), 
  new NeonIntrinsicInfo($("vcvtm_u32_v"), NEON.BI__builtin_neon_vcvtm_u32_v, ID.arm_neon_vcvtmu, 0, 0), 
  new NeonIntrinsicInfo($("vcvtm_u64_v"), NEON.BI__builtin_neon_vcvtm_u64_v, ID.arm_neon_vcvtmu, 0, 0), 
  new NeonIntrinsicInfo($("vcvtmq_s32_v"), NEON.BI__builtin_neon_vcvtmq_s32_v, ID.arm_neon_vcvtms, 0, 0), 
  new NeonIntrinsicInfo($("vcvtmq_s64_v"), NEON.BI__builtin_neon_vcvtmq_s64_v, ID.arm_neon_vcvtms, 0, 0), 
  new NeonIntrinsicInfo($("vcvtmq_u32_v"), NEON.BI__builtin_neon_vcvtmq_u32_v, ID.arm_neon_vcvtmu, 0, 0), 
  new NeonIntrinsicInfo($("vcvtmq_u64_v"), NEON.BI__builtin_neon_vcvtmq_u64_v, ID.arm_neon_vcvtmu, 0, 0), 
  new NeonIntrinsicInfo($("vcvtn_s32_v"), NEON.BI__builtin_neon_vcvtn_s32_v, ID.arm_neon_vcvtns, 0, 0), 
  new NeonIntrinsicInfo($("vcvtn_s64_v"), NEON.BI__builtin_neon_vcvtn_s64_v, ID.arm_neon_vcvtns, 0, 0), 
  new NeonIntrinsicInfo($("vcvtn_u32_v"), NEON.BI__builtin_neon_vcvtn_u32_v, ID.arm_neon_vcvtnu, 0, 0), 
  new NeonIntrinsicInfo($("vcvtn_u64_v"), NEON.BI__builtin_neon_vcvtn_u64_v, ID.arm_neon_vcvtnu, 0, 0), 
  new NeonIntrinsicInfo($("vcvtnq_s32_v"), NEON.BI__builtin_neon_vcvtnq_s32_v, ID.arm_neon_vcvtns, 0, 0), 
  new NeonIntrinsicInfo($("vcvtnq_s64_v"), NEON.BI__builtin_neon_vcvtnq_s64_v, ID.arm_neon_vcvtns, 0, 0), 
  new NeonIntrinsicInfo($("vcvtnq_u32_v"), NEON.BI__builtin_neon_vcvtnq_u32_v, ID.arm_neon_vcvtnu, 0, 0), 
  new NeonIntrinsicInfo($("vcvtnq_u64_v"), NEON.BI__builtin_neon_vcvtnq_u64_v, ID.arm_neon_vcvtnu, 0, 0), 
  new NeonIntrinsicInfo($("vcvtp_s32_v"), NEON.BI__builtin_neon_vcvtp_s32_v, ID.arm_neon_vcvtps, 0, 0), 
  new NeonIntrinsicInfo($("vcvtp_s64_v"), NEON.BI__builtin_neon_vcvtp_s64_v, ID.arm_neon_vcvtps, 0, 0), 
  new NeonIntrinsicInfo($("vcvtp_u32_v"), NEON.BI__builtin_neon_vcvtp_u32_v, ID.arm_neon_vcvtpu, 0, 0), 
  new NeonIntrinsicInfo($("vcvtp_u64_v"), NEON.BI__builtin_neon_vcvtp_u64_v, ID.arm_neon_vcvtpu, 0, 0), 
  new NeonIntrinsicInfo($("vcvtpq_s32_v"), NEON.BI__builtin_neon_vcvtpq_s32_v, ID.arm_neon_vcvtps, 0, 0), 
  new NeonIntrinsicInfo($("vcvtpq_s64_v"), NEON.BI__builtin_neon_vcvtpq_s64_v, ID.arm_neon_vcvtps, 0, 0), 
  new NeonIntrinsicInfo($("vcvtpq_u32_v"), NEON.BI__builtin_neon_vcvtpq_u32_v, ID.arm_neon_vcvtpu, 0, 0), 
  new NeonIntrinsicInfo($("vcvtpq_u64_v"), NEON.BI__builtin_neon_vcvtpq_u64_v, ID.arm_neon_vcvtpu, 0, 0), 
  new NeonIntrinsicInfo($("vcvtq_f32_v"), NEON.BI__builtin_neon_vcvtq_f32_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vcvtq_n_f32_v"), NEON.BI__builtin_neon_vcvtq_n_f32_v, ID.arm_neon_vcvtfxu2fp, ID.arm_neon_vcvtfxs2fp, 0), 
  new NeonIntrinsicInfo($("vcvtq_n_s32_v"), NEON.BI__builtin_neon_vcvtq_n_s32_v, ID.arm_neon_vcvtfp2fxs, 0, 0), 
  new NeonIntrinsicInfo($("vcvtq_n_s64_v"), NEON.BI__builtin_neon_vcvtq_n_s64_v, ID.arm_neon_vcvtfp2fxs, 0, 0), 
  new NeonIntrinsicInfo($("vcvtq_n_u32_v"), NEON.BI__builtin_neon_vcvtq_n_u32_v, ID.arm_neon_vcvtfp2fxu, 0, 0), 
  new NeonIntrinsicInfo($("vcvtq_n_u64_v"), NEON.BI__builtin_neon_vcvtq_n_u64_v, ID.arm_neon_vcvtfp2fxu, 0, 0), 
  new NeonIntrinsicInfo($("vcvtq_s32_v"), NEON.BI__builtin_neon_vcvtq_s32_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vcvtq_s64_v"), NEON.BI__builtin_neon_vcvtq_s64_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vcvtq_u32_v"), NEON.BI__builtin_neon_vcvtq_u32_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vcvtq_u64_v"), NEON.BI__builtin_neon_vcvtq_u64_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vext_v"), NEON.BI__builtin_neon_vext_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vextq_v"), NEON.BI__builtin_neon_vextq_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vfma_v"), NEON.BI__builtin_neon_vfma_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vfmaq_v"), NEON.BI__builtin_neon_vfmaq_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vhadd_v"), NEON.BI__builtin_neon_vhadd_v, ID.arm_neon_vhaddu, ID.arm_neon_vhadds, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vhaddq_v"), NEON.BI__builtin_neon_vhaddq_v, ID.arm_neon_vhaddu, ID.arm_neon_vhadds, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vhsub_v"), NEON.BI__builtin_neon_vhsub_v, ID.arm_neon_vhsubu, ID.arm_neon_vhsubs, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vhsubq_v"), NEON.BI__builtin_neon_vhsubq_v, ID.arm_neon_vhsubu, ID.arm_neon_vhsubs, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vld1_dup_v"), NEON.BI__builtin_neon_vld1_dup_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vld1_v"), NEON.BI__builtin_neon_vld1_v, ID.arm_neon_vld1, 0, 0), 
  new NeonIntrinsicInfo($("vld1q_dup_v"), NEON.BI__builtin_neon_vld1q_dup_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vld1q_v"), NEON.BI__builtin_neon_vld1q_v, ID.arm_neon_vld1, 0, 0), 
  new NeonIntrinsicInfo($("vld2_lane_v"), NEON.BI__builtin_neon_vld2_lane_v, ID.arm_neon_vld2lane, 0, 0), 
  new NeonIntrinsicInfo($("vld2_v"), NEON.BI__builtin_neon_vld2_v, ID.arm_neon_vld2, 0, 0), 
  new NeonIntrinsicInfo($("vld2q_lane_v"), NEON.BI__builtin_neon_vld2q_lane_v, ID.arm_neon_vld2lane, 0, 0), 
  new NeonIntrinsicInfo($("vld2q_v"), NEON.BI__builtin_neon_vld2q_v, ID.arm_neon_vld2, 0, 0), 
  new NeonIntrinsicInfo($("vld3_lane_v"), NEON.BI__builtin_neon_vld3_lane_v, ID.arm_neon_vld3lane, 0, 0), 
  new NeonIntrinsicInfo($("vld3_v"), NEON.BI__builtin_neon_vld3_v, ID.arm_neon_vld3, 0, 0), 
  new NeonIntrinsicInfo($("vld3q_lane_v"), NEON.BI__builtin_neon_vld3q_lane_v, ID.arm_neon_vld3lane, 0, 0), 
  new NeonIntrinsicInfo($("vld3q_v"), NEON.BI__builtin_neon_vld3q_v, ID.arm_neon_vld3, 0, 0), 
  new NeonIntrinsicInfo($("vld4_lane_v"), NEON.BI__builtin_neon_vld4_lane_v, ID.arm_neon_vld4lane, 0, 0), 
  new NeonIntrinsicInfo($("vld4_v"), NEON.BI__builtin_neon_vld4_v, ID.arm_neon_vld4, 0, 0), 
  new NeonIntrinsicInfo($("vld4q_lane_v"), NEON.BI__builtin_neon_vld4q_lane_v, ID.arm_neon_vld4lane, 0, 0), 
  new NeonIntrinsicInfo($("vld4q_v"), NEON.BI__builtin_neon_vld4q_v, ID.arm_neon_vld4, 0, 0), 
  new NeonIntrinsicInfo($("vmax_v"), NEON.BI__builtin_neon_vmax_v, ID.arm_neon_vmaxu, ID.arm_neon_vmaxs, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vmaxnm_v"), NEON.BI__builtin_neon_vmaxnm_v, ID.arm_neon_vmaxnm, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vmaxnmq_v"), NEON.BI__builtin_neon_vmaxnmq_v, ID.arm_neon_vmaxnm, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vmaxq_v"), NEON.BI__builtin_neon_vmaxq_v, ID.arm_neon_vmaxu, ID.arm_neon_vmaxs, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vmin_v"), NEON.BI__builtin_neon_vmin_v, ID.arm_neon_vminu, ID.arm_neon_vmins, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vminnm_v"), NEON.BI__builtin_neon_vminnm_v, ID.arm_neon_vminnm, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vminnmq_v"), NEON.BI__builtin_neon_vminnmq_v, ID.arm_neon_vminnm, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vminq_v"), NEON.BI__builtin_neon_vminq_v, ID.arm_neon_vminu, ID.arm_neon_vmins, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vmovl_v"), NEON.BI__builtin_neon_vmovl_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vmovn_v"), NEON.BI__builtin_neon_vmovn_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vmul_v"), NEON.BI__builtin_neon_vmul_v, ID.arm_neon_vmulp, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vmull_v"), NEON.BI__builtin_neon_vmull_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vmulq_v"), NEON.BI__builtin_neon_vmulq_v, ID.arm_neon_vmulp, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vpadal_v"), NEON.BI__builtin_neon_vpadal_v, ID.arm_neon_vpadalu, ID.arm_neon_vpadals, UnsignedAlts), 
  new NeonIntrinsicInfo($("vpadalq_v"), NEON.BI__builtin_neon_vpadalq_v, ID.arm_neon_vpadalu, ID.arm_neon_vpadals, UnsignedAlts), 
  new NeonIntrinsicInfo($("vpadd_v"), NEON.BI__builtin_neon_vpadd_v, ID.arm_neon_vpadd, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vpaddl_v"), NEON.BI__builtin_neon_vpaddl_v, ID.arm_neon_vpaddlu, ID.arm_neon_vpaddls, UnsignedAlts), 
  new NeonIntrinsicInfo($("vpaddlq_v"), NEON.BI__builtin_neon_vpaddlq_v, ID.arm_neon_vpaddlu, ID.arm_neon_vpaddls, UnsignedAlts), 
  new NeonIntrinsicInfo($("vpaddq_v"), NEON.BI__builtin_neon_vpaddq_v, ID.arm_neon_vpadd, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vpmax_v"), NEON.BI__builtin_neon_vpmax_v, ID.arm_neon_vpmaxu, ID.arm_neon_vpmaxs, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vpmin_v"), NEON.BI__builtin_neon_vpmin_v, ID.arm_neon_vpminu, ID.arm_neon_vpmins, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vqabs_v"), NEON.BI__builtin_neon_vqabs_v, ID.arm_neon_vqabs, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqabsq_v"), NEON.BI__builtin_neon_vqabsq_v, ID.arm_neon_vqabs, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqadd_v"), NEON.BI__builtin_neon_vqadd_v, ID.arm_neon_vqaddu, ID.arm_neon_vqadds, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vqaddq_v"), NEON.BI__builtin_neon_vqaddq_v, ID.arm_neon_vqaddu, ID.arm_neon_vqadds, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vqdmlal_v"), NEON.BI__builtin_neon_vqdmlal_v, ID.arm_neon_vqdmull, ID.arm_neon_vqadds, 0), 
  new NeonIntrinsicInfo($("vqdmlsl_v"), NEON.BI__builtin_neon_vqdmlsl_v, ID.arm_neon_vqdmull, ID.arm_neon_vqsubs, 0), 
  new NeonIntrinsicInfo($("vqdmulh_v"), NEON.BI__builtin_neon_vqdmulh_v, ID.arm_neon_vqdmulh, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqdmulhq_v"), NEON.BI__builtin_neon_vqdmulhq_v, ID.arm_neon_vqdmulh, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqdmull_v"), NEON.BI__builtin_neon_vqdmull_v, ID.arm_neon_vqdmull, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqmovn_v"), NEON.BI__builtin_neon_vqmovn_v, ID.arm_neon_vqmovnu, ID.arm_neon_vqmovns, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vqmovun_v"), NEON.BI__builtin_neon_vqmovun_v, ID.arm_neon_vqmovnsu, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqneg_v"), NEON.BI__builtin_neon_vqneg_v, ID.arm_neon_vqneg, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqnegq_v"), NEON.BI__builtin_neon_vqnegq_v, ID.arm_neon_vqneg, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqrdmulh_v"), NEON.BI__builtin_neon_vqrdmulh_v, ID.arm_neon_vqrdmulh, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqrdmulhq_v"), NEON.BI__builtin_neon_vqrdmulhq_v, ID.arm_neon_vqrdmulh, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqrshl_v"), NEON.BI__builtin_neon_vqrshl_v, ID.arm_neon_vqrshiftu, ID.arm_neon_vqrshifts, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vqrshlq_v"), NEON.BI__builtin_neon_vqrshlq_v, ID.arm_neon_vqrshiftu, ID.arm_neon_vqrshifts, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vqshl_n_v"), NEON.BI__builtin_neon_vqshl_n_v, ID.arm_neon_vqshiftu, ID.arm_neon_vqshifts, UnsignedAlts), 
  new NeonIntrinsicInfo($("vqshl_v"), NEON.BI__builtin_neon_vqshl_v, ID.arm_neon_vqshiftu, ID.arm_neon_vqshifts, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vqshlq_n_v"), NEON.BI__builtin_neon_vqshlq_n_v, ID.arm_neon_vqshiftu, ID.arm_neon_vqshifts, UnsignedAlts), 
  new NeonIntrinsicInfo($("vqshlq_v"), NEON.BI__builtin_neon_vqshlq_v, ID.arm_neon_vqshiftu, ID.arm_neon_vqshifts, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vqshlu_n_v"), NEON.BI__builtin_neon_vqshlu_n_v, ID.arm_neon_vqshiftsu, 0, 0), 
  new NeonIntrinsicInfo($("vqshluq_n_v"), NEON.BI__builtin_neon_vqshluq_n_v, ID.arm_neon_vqshiftsu, 0, 0), 
  new NeonIntrinsicInfo($("vqsub_v"), NEON.BI__builtin_neon_vqsub_v, ID.arm_neon_vqsubu, ID.arm_neon_vqsubs, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vqsubq_v"), NEON.BI__builtin_neon_vqsubq_v, ID.arm_neon_vqsubu, ID.arm_neon_vqsubs, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vraddhn_v"), NEON.BI__builtin_neon_vraddhn_v, ID.arm_neon_vraddhn, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrecpe_v"), NEON.BI__builtin_neon_vrecpe_v, ID.arm_neon_vrecpe, ID.arm_neon_vrecpe, 0), 
  new NeonIntrinsicInfo($("vrecpeq_v"), NEON.BI__builtin_neon_vrecpeq_v, ID.arm_neon_vrecpe, ID.arm_neon_vrecpe, 0), 
  new NeonIntrinsicInfo($("vrecps_v"), NEON.BI__builtin_neon_vrecps_v, ID.arm_neon_vrecps, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrecpsq_v"), NEON.BI__builtin_neon_vrecpsq_v, ID.arm_neon_vrecps, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrhadd_v"), NEON.BI__builtin_neon_vrhadd_v, ID.arm_neon_vrhaddu, ID.arm_neon_vrhadds, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vrhaddq_v"), NEON.BI__builtin_neon_vrhaddq_v, ID.arm_neon_vrhaddu, ID.arm_neon_vrhadds, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vrnd_v"), NEON.BI__builtin_neon_vrnd_v, ID.arm_neon_vrintz, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrnda_v"), NEON.BI__builtin_neon_vrnda_v, ID.arm_neon_vrinta, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrndaq_v"), NEON.BI__builtin_neon_vrndaq_v, ID.arm_neon_vrinta, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrndm_v"), NEON.BI__builtin_neon_vrndm_v, ID.arm_neon_vrintm, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrndmq_v"), NEON.BI__builtin_neon_vrndmq_v, ID.arm_neon_vrintm, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrndn_v"), NEON.BI__builtin_neon_vrndn_v, ID.arm_neon_vrintn, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrndnq_v"), NEON.BI__builtin_neon_vrndnq_v, ID.arm_neon_vrintn, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrndp_v"), NEON.BI__builtin_neon_vrndp_v, ID.arm_neon_vrintp, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrndpq_v"), NEON.BI__builtin_neon_vrndpq_v, ID.arm_neon_vrintp, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrndq_v"), NEON.BI__builtin_neon_vrndq_v, ID.arm_neon_vrintz, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrndx_v"), NEON.BI__builtin_neon_vrndx_v, ID.arm_neon_vrintx, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrndxq_v"), NEON.BI__builtin_neon_vrndxq_v, ID.arm_neon_vrintx, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrshl_v"), NEON.BI__builtin_neon_vrshl_v, ID.arm_neon_vrshiftu, ID.arm_neon_vrshifts, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vrshlq_v"), NEON.BI__builtin_neon_vrshlq_v, ID.arm_neon_vrshiftu, ID.arm_neon_vrshifts, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vrshr_n_v"), NEON.BI__builtin_neon_vrshr_n_v, ID.arm_neon_vrshiftu, ID.arm_neon_vrshifts, UnsignedAlts), 
  new NeonIntrinsicInfo($("vrshrq_n_v"), NEON.BI__builtin_neon_vrshrq_n_v, ID.arm_neon_vrshiftu, ID.arm_neon_vrshifts, UnsignedAlts), 
  new NeonIntrinsicInfo($("vrsqrte_v"), NEON.BI__builtin_neon_vrsqrte_v, ID.arm_neon_vrsqrte, ID.arm_neon_vrsqrte, 0), 
  new NeonIntrinsicInfo($("vrsqrteq_v"), NEON.BI__builtin_neon_vrsqrteq_v, ID.arm_neon_vrsqrte, ID.arm_neon_vrsqrte, 0), 
  new NeonIntrinsicInfo($("vrsqrts_v"), NEON.BI__builtin_neon_vrsqrts_v, ID.arm_neon_vrsqrts, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrsqrtsq_v"), NEON.BI__builtin_neon_vrsqrtsq_v, ID.arm_neon_vrsqrts, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrsubhn_v"), NEON.BI__builtin_neon_vrsubhn_v, ID.arm_neon_vrsubhn, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vsha1su0q_v"), NEON.BI__builtin_neon_vsha1su0q_v, ID.arm_neon_sha1su0, 0, 0), 
  new NeonIntrinsicInfo($("vsha1su1q_v"), NEON.BI__builtin_neon_vsha1su1q_v, ID.arm_neon_sha1su1, 0, 0), 
  new NeonIntrinsicInfo($("vsha256h2q_v"), NEON.BI__builtin_neon_vsha256h2q_v, ID.arm_neon_sha256h2, 0, 0), 
  new NeonIntrinsicInfo($("vsha256hq_v"), NEON.BI__builtin_neon_vsha256hq_v, ID.arm_neon_sha256h, 0, 0), 
  new NeonIntrinsicInfo($("vsha256su0q_v"), NEON.BI__builtin_neon_vsha256su0q_v, ID.arm_neon_sha256su0, 0, 0), 
  new NeonIntrinsicInfo($("vsha256su1q_v"), NEON.BI__builtin_neon_vsha256su1q_v, ID.arm_neon_sha256su1, 0, 0), 
  new NeonIntrinsicInfo($("vshl_n_v"), NEON.BI__builtin_neon_vshl_n_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vshl_v"), NEON.BI__builtin_neon_vshl_v, ID.arm_neon_vshiftu, ID.arm_neon_vshifts, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vshll_n_v"), NEON.BI__builtin_neon_vshll_n_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vshlq_n_v"), NEON.BI__builtin_neon_vshlq_n_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vshlq_v"), NEON.BI__builtin_neon_vshlq_v, ID.arm_neon_vshiftu, ID.arm_neon_vshifts, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vshr_n_v"), NEON.BI__builtin_neon_vshr_n_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vshrn_n_v"), NEON.BI__builtin_neon_vshrn_n_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vshrq_n_v"), NEON.BI__builtin_neon_vshrq_n_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vst1_v"), NEON.BI__builtin_neon_vst1_v, ID.arm_neon_vst1, 0, 0), 
  new NeonIntrinsicInfo($("vst1q_v"), NEON.BI__builtin_neon_vst1q_v, ID.arm_neon_vst1, 0, 0), 
  new NeonIntrinsicInfo($("vst2_lane_v"), NEON.BI__builtin_neon_vst2_lane_v, ID.arm_neon_vst2lane, 0, 0), 
  new NeonIntrinsicInfo($("vst2_v"), NEON.BI__builtin_neon_vst2_v, ID.arm_neon_vst2, 0, 0), 
  new NeonIntrinsicInfo($("vst2q_lane_v"), NEON.BI__builtin_neon_vst2q_lane_v, ID.arm_neon_vst2lane, 0, 0), 
  new NeonIntrinsicInfo($("vst2q_v"), NEON.BI__builtin_neon_vst2q_v, ID.arm_neon_vst2, 0, 0), 
  new NeonIntrinsicInfo($("vst3_lane_v"), NEON.BI__builtin_neon_vst3_lane_v, ID.arm_neon_vst3lane, 0, 0), 
  new NeonIntrinsicInfo($("vst3_v"), NEON.BI__builtin_neon_vst3_v, ID.arm_neon_vst3, 0, 0), 
  new NeonIntrinsicInfo($("vst3q_lane_v"), NEON.BI__builtin_neon_vst3q_lane_v, ID.arm_neon_vst3lane, 0, 0), 
  new NeonIntrinsicInfo($("vst3q_v"), NEON.BI__builtin_neon_vst3q_v, ID.arm_neon_vst3, 0, 0), 
  new NeonIntrinsicInfo($("vst4_lane_v"), NEON.BI__builtin_neon_vst4_lane_v, ID.arm_neon_vst4lane, 0, 0), 
  new NeonIntrinsicInfo($("vst4_v"), NEON.BI__builtin_neon_vst4_v, ID.arm_neon_vst4, 0, 0), 
  new NeonIntrinsicInfo($("vst4q_lane_v"), NEON.BI__builtin_neon_vst4q_lane_v, ID.arm_neon_vst4lane, 0, 0), 
  new NeonIntrinsicInfo($("vst4q_v"), NEON.BI__builtin_neon_vst4q_v, ID.arm_neon_vst4, 0, 0), 
  new NeonIntrinsicInfo($("vsubhn_v"), NEON.BI__builtin_neon_vsubhn_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vtrn_v"), NEON.BI__builtin_neon_vtrn_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vtrnq_v"), NEON.BI__builtin_neon_vtrnq_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vtst_v"), NEON.BI__builtin_neon_vtst_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vtstq_v"), NEON.BI__builtin_neon_vtstq_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vuzp_v"), NEON.BI__builtin_neon_vuzp_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vuzpq_v"), NEON.BI__builtin_neon_vuzpq_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vzip_v"), NEON.BI__builtin_neon_vzip_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vzipq_v"), NEON.BI__builtin_neon_vzipq_v, 0, 0, 0)
};
//<editor-fold defaultstate="collapsed" desc="AArch64SIMDIntrinsicMap">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 2893,
 FQN="AArch64SIMDIntrinsicMap", NM="_ZL23AArch64SIMDIntrinsicMap",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL23AArch64SIMDIntrinsicMap")
//</editor-fold>
public static /*const*/ NeonIntrinsicInfo AArch64SIMDIntrinsicMap[/*112*/] = new /*const*/ NeonIntrinsicInfo [/*112*/] {
  new NeonIntrinsicInfo($("vabs_v"), NEON.BI__builtin_neon_vabs_v, ID.aarch64_neon_abs, 0, 0), 
  new NeonIntrinsicInfo($("vabsq_v"), NEON.BI__builtin_neon_vabsq_v, ID.aarch64_neon_abs, 0, 0), 
  new NeonIntrinsicInfo($("vaddhn_v"), NEON.BI__builtin_neon_vaddhn_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vaesdq_v"), NEON.BI__builtin_neon_vaesdq_v, ID.aarch64_crypto_aesd, 0, 0), 
  new NeonIntrinsicInfo($("vaeseq_v"), NEON.BI__builtin_neon_vaeseq_v, ID.aarch64_crypto_aese, 0, 0), 
  new NeonIntrinsicInfo($("vaesimcq_v"), NEON.BI__builtin_neon_vaesimcq_v, ID.aarch64_crypto_aesimc, 0, 0), 
  new NeonIntrinsicInfo($("vaesmcq_v"), NEON.BI__builtin_neon_vaesmcq_v, ID.aarch64_crypto_aesmc, 0, 0), 
  new NeonIntrinsicInfo($("vcage_v"), NEON.BI__builtin_neon_vcage_v, ID.aarch64_neon_facge, 0, 0), 
  new NeonIntrinsicInfo($("vcageq_v"), NEON.BI__builtin_neon_vcageq_v, ID.aarch64_neon_facge, 0, 0), 
  new NeonIntrinsicInfo($("vcagt_v"), NEON.BI__builtin_neon_vcagt_v, ID.aarch64_neon_facgt, 0, 0), 
  new NeonIntrinsicInfo($("vcagtq_v"), NEON.BI__builtin_neon_vcagtq_v, ID.aarch64_neon_facgt, 0, 0), 
  new NeonIntrinsicInfo($("vcale_v"), NEON.BI__builtin_neon_vcale_v, ID.aarch64_neon_facge, 0, 0), 
  new NeonIntrinsicInfo($("vcaleq_v"), NEON.BI__builtin_neon_vcaleq_v, ID.aarch64_neon_facge, 0, 0), 
  new NeonIntrinsicInfo($("vcalt_v"), NEON.BI__builtin_neon_vcalt_v, ID.aarch64_neon_facgt, 0, 0), 
  new NeonIntrinsicInfo($("vcaltq_v"), NEON.BI__builtin_neon_vcaltq_v, ID.aarch64_neon_facgt, 0, 0), 
  new NeonIntrinsicInfo($("vcls_v"), NEON.BI__builtin_neon_vcls_v, ID.aarch64_neon_cls, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vclsq_v"), NEON.BI__builtin_neon_vclsq_v, ID.aarch64_neon_cls, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vclz_v"), NEON.BI__builtin_neon_vclz_v, ID.ctlz, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vclzq_v"), NEON.BI__builtin_neon_vclzq_v, ID.ctlz, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vcnt_v"), NEON.BI__builtin_neon_vcnt_v, ID.ctpop, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vcntq_v"), NEON.BI__builtin_neon_vcntq_v, ID.ctpop, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vcvt_f16_f32"), NEON.BI__builtin_neon_vcvt_f16_f32, ID.aarch64_neon_vcvtfp2hf, 0, 0), 
  new NeonIntrinsicInfo($("vcvt_f32_f16"), NEON.BI__builtin_neon_vcvt_f32_f16, ID.aarch64_neon_vcvthf2fp, 0, 0), 
  new NeonIntrinsicInfo($("vcvt_f32_v"), NEON.BI__builtin_neon_vcvt_f32_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vcvt_n_f32_v"), NEON.BI__builtin_neon_vcvt_n_f32_v, ID.aarch64_neon_vcvtfxu2fp, ID.aarch64_neon_vcvtfxs2fp, 0), 
  new NeonIntrinsicInfo($("vcvt_n_f64_v"), NEON.BI__builtin_neon_vcvt_n_f64_v, ID.aarch64_neon_vcvtfxu2fp, ID.aarch64_neon_vcvtfxs2fp, 0), 
  new NeonIntrinsicInfo($("vcvt_n_s32_v"), NEON.BI__builtin_neon_vcvt_n_s32_v, ID.aarch64_neon_vcvtfp2fxs, 0, 0), 
  new NeonIntrinsicInfo($("vcvt_n_s64_v"), NEON.BI__builtin_neon_vcvt_n_s64_v, ID.aarch64_neon_vcvtfp2fxs, 0, 0), 
  new NeonIntrinsicInfo($("vcvt_n_u32_v"), NEON.BI__builtin_neon_vcvt_n_u32_v, ID.aarch64_neon_vcvtfp2fxu, 0, 0), 
  new NeonIntrinsicInfo($("vcvt_n_u64_v"), NEON.BI__builtin_neon_vcvt_n_u64_v, ID.aarch64_neon_vcvtfp2fxu, 0, 0), 
  new NeonIntrinsicInfo($("vcvtq_f32_v"), NEON.BI__builtin_neon_vcvtq_f32_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vcvtq_n_f32_v"), NEON.BI__builtin_neon_vcvtq_n_f32_v, ID.aarch64_neon_vcvtfxu2fp, ID.aarch64_neon_vcvtfxs2fp, 0), 
  new NeonIntrinsicInfo($("vcvtq_n_f64_v"), NEON.BI__builtin_neon_vcvtq_n_f64_v, ID.aarch64_neon_vcvtfxu2fp, ID.aarch64_neon_vcvtfxs2fp, 0), 
  new NeonIntrinsicInfo($("vcvtq_n_s32_v"), NEON.BI__builtin_neon_vcvtq_n_s32_v, ID.aarch64_neon_vcvtfp2fxs, 0, 0), 
  new NeonIntrinsicInfo($("vcvtq_n_s64_v"), NEON.BI__builtin_neon_vcvtq_n_s64_v, ID.aarch64_neon_vcvtfp2fxs, 0, 0), 
  new NeonIntrinsicInfo($("vcvtq_n_u32_v"), NEON.BI__builtin_neon_vcvtq_n_u32_v, ID.aarch64_neon_vcvtfp2fxu, 0, 0), 
  new NeonIntrinsicInfo($("vcvtq_n_u64_v"), NEON.BI__builtin_neon_vcvtq_n_u64_v, ID.aarch64_neon_vcvtfp2fxu, 0, 0), 
  new NeonIntrinsicInfo($("vcvtx_f32_v"), NEON.BI__builtin_neon_vcvtx_f32_v, ID.aarch64_neon_fcvtxn, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vext_v"), NEON.BI__builtin_neon_vext_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vextq_v"), NEON.BI__builtin_neon_vextq_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vfma_v"), NEON.BI__builtin_neon_vfma_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vfmaq_v"), NEON.BI__builtin_neon_vfmaq_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vhadd_v"), NEON.BI__builtin_neon_vhadd_v, ID.aarch64_neon_uhadd, ID.aarch64_neon_shadd, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vhaddq_v"), NEON.BI__builtin_neon_vhaddq_v, ID.aarch64_neon_uhadd, ID.aarch64_neon_shadd, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vhsub_v"), NEON.BI__builtin_neon_vhsub_v, ID.aarch64_neon_uhsub, ID.aarch64_neon_shsub, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vhsubq_v"), NEON.BI__builtin_neon_vhsubq_v, ID.aarch64_neon_uhsub, ID.aarch64_neon_shsub, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vmovl_v"), NEON.BI__builtin_neon_vmovl_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vmovn_v"), NEON.BI__builtin_neon_vmovn_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vmul_v"), NEON.BI__builtin_neon_vmul_v, ID.aarch64_neon_pmul, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vmulq_v"), NEON.BI__builtin_neon_vmulq_v, ID.aarch64_neon_pmul, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vpadd_v"), NEON.BI__builtin_neon_vpadd_v, ID.aarch64_neon_addp, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vpaddl_v"), NEON.BI__builtin_neon_vpaddl_v, ID.aarch64_neon_uaddlp, ID.aarch64_neon_saddlp, UnsignedAlts), 
  new NeonIntrinsicInfo($("vpaddlq_v"), NEON.BI__builtin_neon_vpaddlq_v, ID.aarch64_neon_uaddlp, ID.aarch64_neon_saddlp, UnsignedAlts), 
  new NeonIntrinsicInfo($("vpaddq_v"), NEON.BI__builtin_neon_vpaddq_v, ID.aarch64_neon_addp, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqabs_v"), NEON.BI__builtin_neon_vqabs_v, ID.aarch64_neon_sqabs, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqabsq_v"), NEON.BI__builtin_neon_vqabsq_v, ID.aarch64_neon_sqabs, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqadd_v"), NEON.BI__builtin_neon_vqadd_v, ID.aarch64_neon_uqadd, ID.aarch64_neon_sqadd, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vqaddq_v"), NEON.BI__builtin_neon_vqaddq_v, ID.aarch64_neon_uqadd, ID.aarch64_neon_sqadd, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vqdmlal_v"), NEON.BI__builtin_neon_vqdmlal_v, ID.aarch64_neon_sqdmull, ID.aarch64_neon_sqadd, 0), 
  new NeonIntrinsicInfo($("vqdmlsl_v"), NEON.BI__builtin_neon_vqdmlsl_v, ID.aarch64_neon_sqdmull, ID.aarch64_neon_sqsub, 0), 
  new NeonIntrinsicInfo($("vqdmulh_v"), NEON.BI__builtin_neon_vqdmulh_v, ID.aarch64_neon_sqdmulh, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqdmulhq_v"), NEON.BI__builtin_neon_vqdmulhq_v, ID.aarch64_neon_sqdmulh, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqdmull_v"), NEON.BI__builtin_neon_vqdmull_v, ID.aarch64_neon_sqdmull, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqmovn_v"), NEON.BI__builtin_neon_vqmovn_v, ID.aarch64_neon_uqxtn, ID.aarch64_neon_sqxtn, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vqmovun_v"), NEON.BI__builtin_neon_vqmovun_v, ID.aarch64_neon_sqxtun, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqneg_v"), NEON.BI__builtin_neon_vqneg_v, ID.aarch64_neon_sqneg, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqnegq_v"), NEON.BI__builtin_neon_vqnegq_v, ID.aarch64_neon_sqneg, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqrdmulh_v"), NEON.BI__builtin_neon_vqrdmulh_v, ID.aarch64_neon_sqrdmulh, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqrdmulhq_v"), NEON.BI__builtin_neon_vqrdmulhq_v, ID.aarch64_neon_sqrdmulh, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqrshl_v"), NEON.BI__builtin_neon_vqrshl_v, ID.aarch64_neon_uqrshl, ID.aarch64_neon_sqrshl, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vqrshlq_v"), NEON.BI__builtin_neon_vqrshlq_v, ID.aarch64_neon_uqrshl, ID.aarch64_neon_sqrshl, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vqshl_n_v"), NEON.BI__builtin_neon_vqshl_n_v, ID.aarch64_neon_uqshl, ID.aarch64_neon_sqshl, UnsignedAlts), 
  new NeonIntrinsicInfo($("vqshl_v"), NEON.BI__builtin_neon_vqshl_v, ID.aarch64_neon_uqshl, ID.aarch64_neon_sqshl, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vqshlq_n_v"), NEON.BI__builtin_neon_vqshlq_n_v, ID.aarch64_neon_uqshl, ID.aarch64_neon_sqshl, UnsignedAlts), 
  new NeonIntrinsicInfo($("vqshlq_v"), NEON.BI__builtin_neon_vqshlq_v, ID.aarch64_neon_uqshl, ID.aarch64_neon_sqshl, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vqshlu_n_v"), NEON.BI__builtin_neon_vqshlu_n_v, ID.aarch64_neon_sqshlu, 0, 0), 
  new NeonIntrinsicInfo($("vqshluq_n_v"), NEON.BI__builtin_neon_vqshluq_n_v, ID.aarch64_neon_sqshlu, 0, 0), 
  new NeonIntrinsicInfo($("vqsub_v"), NEON.BI__builtin_neon_vqsub_v, ID.aarch64_neon_uqsub, ID.aarch64_neon_sqsub, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vqsubq_v"), NEON.BI__builtin_neon_vqsubq_v, ID.aarch64_neon_uqsub, ID.aarch64_neon_sqsub, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vraddhn_v"), NEON.BI__builtin_neon_vraddhn_v, ID.aarch64_neon_raddhn, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrecpe_v"), NEON.BI__builtin_neon_vrecpe_v, ID.aarch64_neon_frecpe, ID.aarch64_neon_urecpe, 0), 
  new NeonIntrinsicInfo($("vrecpeq_v"), NEON.BI__builtin_neon_vrecpeq_v, ID.aarch64_neon_frecpe, ID.aarch64_neon_urecpe, 0), 
  new NeonIntrinsicInfo($("vrecps_v"), NEON.BI__builtin_neon_vrecps_v, ID.aarch64_neon_frecps, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrecpsq_v"), NEON.BI__builtin_neon_vrecpsq_v, ID.aarch64_neon_frecps, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrhadd_v"), NEON.BI__builtin_neon_vrhadd_v, ID.aarch64_neon_urhadd, ID.aarch64_neon_srhadd, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vrhaddq_v"), NEON.BI__builtin_neon_vrhaddq_v, ID.aarch64_neon_urhadd, ID.aarch64_neon_srhadd, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vrshl_v"), NEON.BI__builtin_neon_vrshl_v, ID.aarch64_neon_urshl, ID.aarch64_neon_srshl, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vrshlq_v"), NEON.BI__builtin_neon_vrshlq_v, ID.aarch64_neon_urshl, ID.aarch64_neon_srshl, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vrshr_n_v"), NEON.BI__builtin_neon_vrshr_n_v, ID.aarch64_neon_urshl, ID.aarch64_neon_srshl, UnsignedAlts), 
  new NeonIntrinsicInfo($("vrshrq_n_v"), NEON.BI__builtin_neon_vrshrq_n_v, ID.aarch64_neon_urshl, ID.aarch64_neon_srshl, UnsignedAlts), 
  new NeonIntrinsicInfo($("vrsqrte_v"), NEON.BI__builtin_neon_vrsqrte_v, ID.aarch64_neon_frsqrte, ID.aarch64_neon_ursqrte, 0), 
  new NeonIntrinsicInfo($("vrsqrteq_v"), NEON.BI__builtin_neon_vrsqrteq_v, ID.aarch64_neon_frsqrte, ID.aarch64_neon_ursqrte, 0), 
  new NeonIntrinsicInfo($("vrsqrts_v"), NEON.BI__builtin_neon_vrsqrts_v, ID.aarch64_neon_frsqrts, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrsqrtsq_v"), NEON.BI__builtin_neon_vrsqrtsq_v, ID.aarch64_neon_frsqrts, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrsubhn_v"), NEON.BI__builtin_neon_vrsubhn_v, ID.aarch64_neon_rsubhn, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vsha1su0q_v"), NEON.BI__builtin_neon_vsha1su0q_v, ID.aarch64_crypto_sha1su0, 0, 0), 
  new NeonIntrinsicInfo($("vsha1su1q_v"), NEON.BI__builtin_neon_vsha1su1q_v, ID.aarch64_crypto_sha1su1, 0, 0), 
  new NeonIntrinsicInfo($("vsha256h2q_v"), NEON.BI__builtin_neon_vsha256h2q_v, ID.aarch64_crypto_sha256h2, 0, 0), 
  new NeonIntrinsicInfo($("vsha256hq_v"), NEON.BI__builtin_neon_vsha256hq_v, ID.aarch64_crypto_sha256h, 0, 0), 
  new NeonIntrinsicInfo($("vsha256su0q_v"), NEON.BI__builtin_neon_vsha256su0q_v, ID.aarch64_crypto_sha256su0, 0, 0), 
  new NeonIntrinsicInfo($("vsha256su1q_v"), NEON.BI__builtin_neon_vsha256su1q_v, ID.aarch64_crypto_sha256su1, 0, 0), 
  new NeonIntrinsicInfo($("vshl_n_v"), NEON.BI__builtin_neon_vshl_n_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vshl_v"), NEON.BI__builtin_neon_vshl_v, ID.aarch64_neon_ushl, ID.aarch64_neon_sshl, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vshll_n_v"), NEON.BI__builtin_neon_vshll_n_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vshlq_n_v"), NEON.BI__builtin_neon_vshlq_n_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vshlq_v"), NEON.BI__builtin_neon_vshlq_v, ID.aarch64_neon_ushl, ID.aarch64_neon_sshl, Add1ArgType | UnsignedAlts), 
  new NeonIntrinsicInfo($("vshr_n_v"), NEON.BI__builtin_neon_vshr_n_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vshrn_n_v"), NEON.BI__builtin_neon_vshrn_n_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vshrq_n_v"), NEON.BI__builtin_neon_vshrq_n_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vsubhn_v"), NEON.BI__builtin_neon_vsubhn_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vtst_v"), NEON.BI__builtin_neon_vtst_v, 0, 0, 0), 
  new NeonIntrinsicInfo($("vtstq_v"), NEON.BI__builtin_neon_vtstq_v, 0, 0, 0)
};
//<editor-fold defaultstate="collapsed" desc="AArch64SISDIntrinsicMap">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 3008,
 FQN="AArch64SISDIntrinsicMap", NM="_ZL23AArch64SISDIntrinsicMap",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL23AArch64SISDIntrinsicMap")
//</editor-fold>
public static /*const*/ NeonIntrinsicInfo AArch64SISDIntrinsicMap[/*192*/] = new /*const*/ NeonIntrinsicInfo [/*192*/] {
  new NeonIntrinsicInfo($("vabdd_f64"), NEON.BI__builtin_neon_vabdd_f64, ID.aarch64_sisd_fabd, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vabds_f32"), NEON.BI__builtin_neon_vabds_f32, ID.aarch64_sisd_fabd, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vabsd_s64"), NEON.BI__builtin_neon_vabsd_s64, ID.aarch64_neon_abs, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vaddlv_s32"), NEON.BI__builtin_neon_vaddlv_s32, ID.aarch64_neon_saddlv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vaddlv_u32"), NEON.BI__builtin_neon_vaddlv_u32, ID.aarch64_neon_uaddlv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vaddlvq_s32"), NEON.BI__builtin_neon_vaddlvq_s32, ID.aarch64_neon_saddlv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vaddlvq_u32"), NEON.BI__builtin_neon_vaddlvq_u32, ID.aarch64_neon_uaddlv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vaddv_f32"), NEON.BI__builtin_neon_vaddv_f32, ID.aarch64_neon_faddv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vaddv_s32"), NEON.BI__builtin_neon_vaddv_s32, ID.aarch64_neon_saddv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vaddv_u32"), NEON.BI__builtin_neon_vaddv_u32, ID.aarch64_neon_uaddv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vaddvq_f32"), NEON.BI__builtin_neon_vaddvq_f32, ID.aarch64_neon_faddv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vaddvq_f64"), NEON.BI__builtin_neon_vaddvq_f64, ID.aarch64_neon_faddv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vaddvq_s32"), NEON.BI__builtin_neon_vaddvq_s32, ID.aarch64_neon_saddv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vaddvq_s64"), NEON.BI__builtin_neon_vaddvq_s64, ID.aarch64_neon_saddv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vaddvq_u32"), NEON.BI__builtin_neon_vaddvq_u32, ID.aarch64_neon_uaddv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vaddvq_u64"), NEON.BI__builtin_neon_vaddvq_u64, ID.aarch64_neon_uaddv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcaged_f64"), NEON.BI__builtin_neon_vcaged_f64, ID.aarch64_neon_facge, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcages_f32"), NEON.BI__builtin_neon_vcages_f32, ID.aarch64_neon_facge, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcagtd_f64"), NEON.BI__builtin_neon_vcagtd_f64, ID.aarch64_neon_facgt, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcagts_f32"), NEON.BI__builtin_neon_vcagts_f32, ID.aarch64_neon_facgt, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcaled_f64"), NEON.BI__builtin_neon_vcaled_f64, ID.aarch64_neon_facge, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcales_f32"), NEON.BI__builtin_neon_vcales_f32, ID.aarch64_neon_facge, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcaltd_f64"), NEON.BI__builtin_neon_vcaltd_f64, ID.aarch64_neon_facgt, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcalts_f32"), NEON.BI__builtin_neon_vcalts_f32, ID.aarch64_neon_facgt, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvtad_s64_f64"), NEON.BI__builtin_neon_vcvtad_s64_f64, ID.aarch64_neon_fcvtas, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvtad_u64_f64"), NEON.BI__builtin_neon_vcvtad_u64_f64, ID.aarch64_neon_fcvtau, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvtas_s32_f32"), NEON.BI__builtin_neon_vcvtas_s32_f32, ID.aarch64_neon_fcvtas, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvtas_u32_f32"), NEON.BI__builtin_neon_vcvtas_u32_f32, ID.aarch64_neon_fcvtau, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvtd_n_f64_s64"), NEON.BI__builtin_neon_vcvtd_n_f64_s64, ID.aarch64_neon_vcvtfxs2fp, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvtd_n_f64_u64"), NEON.BI__builtin_neon_vcvtd_n_f64_u64, ID.aarch64_neon_vcvtfxu2fp, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvtd_n_s64_f64"), NEON.BI__builtin_neon_vcvtd_n_s64_f64, ID.aarch64_neon_vcvtfp2fxs, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvtd_n_u64_f64"), NEON.BI__builtin_neon_vcvtd_n_u64_f64, ID.aarch64_neon_vcvtfp2fxu, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvtmd_s64_f64"), NEON.BI__builtin_neon_vcvtmd_s64_f64, ID.aarch64_neon_fcvtms, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvtmd_u64_f64"), NEON.BI__builtin_neon_vcvtmd_u64_f64, ID.aarch64_neon_fcvtmu, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvtms_s32_f32"), NEON.BI__builtin_neon_vcvtms_s32_f32, ID.aarch64_neon_fcvtms, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvtms_u32_f32"), NEON.BI__builtin_neon_vcvtms_u32_f32, ID.aarch64_neon_fcvtmu, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvtnd_s64_f64"), NEON.BI__builtin_neon_vcvtnd_s64_f64, ID.aarch64_neon_fcvtns, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvtnd_u64_f64"), NEON.BI__builtin_neon_vcvtnd_u64_f64, ID.aarch64_neon_fcvtnu, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvtns_s32_f32"), NEON.BI__builtin_neon_vcvtns_s32_f32, ID.aarch64_neon_fcvtns, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvtns_u32_f32"), NEON.BI__builtin_neon_vcvtns_u32_f32, ID.aarch64_neon_fcvtnu, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvtpd_s64_f64"), NEON.BI__builtin_neon_vcvtpd_s64_f64, ID.aarch64_neon_fcvtps, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvtpd_u64_f64"), NEON.BI__builtin_neon_vcvtpd_u64_f64, ID.aarch64_neon_fcvtpu, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvtps_s32_f32"), NEON.BI__builtin_neon_vcvtps_s32_f32, ID.aarch64_neon_fcvtps, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvtps_u32_f32"), NEON.BI__builtin_neon_vcvtps_u32_f32, ID.aarch64_neon_fcvtpu, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvts_n_f32_s32"), NEON.BI__builtin_neon_vcvts_n_f32_s32, ID.aarch64_neon_vcvtfxs2fp, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvts_n_f32_u32"), NEON.BI__builtin_neon_vcvts_n_f32_u32, ID.aarch64_neon_vcvtfxu2fp, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvts_n_s32_f32"), NEON.BI__builtin_neon_vcvts_n_s32_f32, ID.aarch64_neon_vcvtfp2fxs, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvts_n_u32_f32"), NEON.BI__builtin_neon_vcvts_n_u32_f32, ID.aarch64_neon_vcvtfp2fxu, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vcvtxd_f32_f64"), NEON.BI__builtin_neon_vcvtxd_f32_f64, ID.aarch64_sisd_fcvtxn, 0, 0), 
  new NeonIntrinsicInfo($("vmaxnmv_f32"), NEON.BI__builtin_neon_vmaxnmv_f32, ID.aarch64_neon_fmaxnmv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vmaxnmvq_f32"), NEON.BI__builtin_neon_vmaxnmvq_f32, ID.aarch64_neon_fmaxnmv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vmaxnmvq_f64"), NEON.BI__builtin_neon_vmaxnmvq_f64, ID.aarch64_neon_fmaxnmv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vmaxv_f32"), NEON.BI__builtin_neon_vmaxv_f32, ID.aarch64_neon_fmaxv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vmaxv_s32"), NEON.BI__builtin_neon_vmaxv_s32, ID.aarch64_neon_smaxv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vmaxv_u32"), NEON.BI__builtin_neon_vmaxv_u32, ID.aarch64_neon_umaxv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vmaxvq_f32"), NEON.BI__builtin_neon_vmaxvq_f32, ID.aarch64_neon_fmaxv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vmaxvq_f64"), NEON.BI__builtin_neon_vmaxvq_f64, ID.aarch64_neon_fmaxv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vmaxvq_s32"), NEON.BI__builtin_neon_vmaxvq_s32, ID.aarch64_neon_smaxv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vmaxvq_u32"), NEON.BI__builtin_neon_vmaxvq_u32, ID.aarch64_neon_umaxv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vminnmv_f32"), NEON.BI__builtin_neon_vminnmv_f32, ID.aarch64_neon_fminnmv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vminnmvq_f32"), NEON.BI__builtin_neon_vminnmvq_f32, ID.aarch64_neon_fminnmv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vminnmvq_f64"), NEON.BI__builtin_neon_vminnmvq_f64, ID.aarch64_neon_fminnmv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vminv_f32"), NEON.BI__builtin_neon_vminv_f32, ID.aarch64_neon_fminv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vminv_s32"), NEON.BI__builtin_neon_vminv_s32, ID.aarch64_neon_sminv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vminv_u32"), NEON.BI__builtin_neon_vminv_u32, ID.aarch64_neon_uminv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vminvq_f32"), NEON.BI__builtin_neon_vminvq_f32, ID.aarch64_neon_fminv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vminvq_f64"), NEON.BI__builtin_neon_vminvq_f64, ID.aarch64_neon_fminv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vminvq_s32"), NEON.BI__builtin_neon_vminvq_s32, ID.aarch64_neon_sminv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vminvq_u32"), NEON.BI__builtin_neon_vminvq_u32, ID.aarch64_neon_uminv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vmull_p64"), NEON.BI__builtin_neon_vmull_p64, ID.aarch64_neon_pmull64, 0, 0), 
  new NeonIntrinsicInfo($("vmulxd_f64"), NEON.BI__builtin_neon_vmulxd_f64, ID.aarch64_neon_fmulx, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vmulxs_f32"), NEON.BI__builtin_neon_vmulxs_f32, ID.aarch64_neon_fmulx, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vpaddd_s64"), NEON.BI__builtin_neon_vpaddd_s64, ID.aarch64_neon_uaddv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vpaddd_u64"), NEON.BI__builtin_neon_vpaddd_u64, ID.aarch64_neon_uaddv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vpmaxnmqd_f64"), NEON.BI__builtin_neon_vpmaxnmqd_f64, ID.aarch64_neon_fmaxnmv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vpmaxnms_f32"), NEON.BI__builtin_neon_vpmaxnms_f32, ID.aarch64_neon_fmaxnmv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vpmaxqd_f64"), NEON.BI__builtin_neon_vpmaxqd_f64, ID.aarch64_neon_fmaxv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vpmaxs_f32"), NEON.BI__builtin_neon_vpmaxs_f32, ID.aarch64_neon_fmaxv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vpminnmqd_f64"), NEON.BI__builtin_neon_vpminnmqd_f64, ID.aarch64_neon_fminnmv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vpminnms_f32"), NEON.BI__builtin_neon_vpminnms_f32, ID.aarch64_neon_fminnmv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vpminqd_f64"), NEON.BI__builtin_neon_vpminqd_f64, ID.aarch64_neon_fminv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vpmins_f32"), NEON.BI__builtin_neon_vpmins_f32, ID.aarch64_neon_fminv, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vqabsb_s8"), NEON.BI__builtin_neon_vqabsb_s8, ID.aarch64_neon_sqabs, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqabsd_s64"), NEON.BI__builtin_neon_vqabsd_s64, ID.aarch64_neon_sqabs, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqabsh_s16"), NEON.BI__builtin_neon_vqabsh_s16, ID.aarch64_neon_sqabs, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqabss_s32"), NEON.BI__builtin_neon_vqabss_s32, ID.aarch64_neon_sqabs, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqaddb_s8"), NEON.BI__builtin_neon_vqaddb_s8, ID.aarch64_neon_sqadd, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqaddb_u8"), NEON.BI__builtin_neon_vqaddb_u8, ID.aarch64_neon_uqadd, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqaddd_s64"), NEON.BI__builtin_neon_vqaddd_s64, ID.aarch64_neon_sqadd, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqaddd_u64"), NEON.BI__builtin_neon_vqaddd_u64, ID.aarch64_neon_uqadd, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqaddh_s16"), NEON.BI__builtin_neon_vqaddh_s16, ID.aarch64_neon_sqadd, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqaddh_u16"), NEON.BI__builtin_neon_vqaddh_u16, ID.aarch64_neon_uqadd, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqadds_s32"), NEON.BI__builtin_neon_vqadds_s32, ID.aarch64_neon_sqadd, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqadds_u32"), NEON.BI__builtin_neon_vqadds_u32, ID.aarch64_neon_uqadd, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqdmulhh_s16"), NEON.BI__builtin_neon_vqdmulhh_s16, ID.aarch64_neon_sqdmulh, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqdmulhs_s32"), NEON.BI__builtin_neon_vqdmulhs_s32, ID.aarch64_neon_sqdmulh, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqdmullh_s16"), NEON.BI__builtin_neon_vqdmullh_s16, ID.aarch64_neon_sqdmull, 0, VectorRet | Use128BitVectors), 
  new NeonIntrinsicInfo($("vqdmulls_s32"), NEON.BI__builtin_neon_vqdmulls_s32, ID.aarch64_neon_sqdmulls_scalar, 0, 0), 
  new NeonIntrinsicInfo($("vqmovnd_s64"), NEON.BI__builtin_neon_vqmovnd_s64, ID.aarch64_neon_scalar_sqxtn, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vqmovnd_u64"), NEON.BI__builtin_neon_vqmovnd_u64, ID.aarch64_neon_scalar_uqxtn, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vqmovnh_s16"), NEON.BI__builtin_neon_vqmovnh_s16, ID.aarch64_neon_sqxtn, 0, VectorRet | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqmovnh_u16"), NEON.BI__builtin_neon_vqmovnh_u16, ID.aarch64_neon_uqxtn, 0, VectorRet | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqmovns_s32"), NEON.BI__builtin_neon_vqmovns_s32, ID.aarch64_neon_sqxtn, 0, VectorRet | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqmovns_u32"), NEON.BI__builtin_neon_vqmovns_u32, ID.aarch64_neon_uqxtn, 0, VectorRet | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqmovund_s64"), NEON.BI__builtin_neon_vqmovund_s64, ID.aarch64_neon_scalar_sqxtun, 0, AddRetType | Add1ArgType), 
  new NeonIntrinsicInfo($("vqmovunh_s16"), NEON.BI__builtin_neon_vqmovunh_s16, ID.aarch64_neon_sqxtun, 0, VectorRet | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqmovuns_s32"), NEON.BI__builtin_neon_vqmovuns_s32, ID.aarch64_neon_sqxtun, 0, VectorRet | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqnegb_s8"), NEON.BI__builtin_neon_vqnegb_s8, ID.aarch64_neon_sqneg, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqnegd_s64"), NEON.BI__builtin_neon_vqnegd_s64, ID.aarch64_neon_sqneg, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqnegh_s16"), NEON.BI__builtin_neon_vqnegh_s16, ID.aarch64_neon_sqneg, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqnegs_s32"), NEON.BI__builtin_neon_vqnegs_s32, ID.aarch64_neon_sqneg, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqrdmulhh_s16"), NEON.BI__builtin_neon_vqrdmulhh_s16, ID.aarch64_neon_sqrdmulh, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqrdmulhs_s32"), NEON.BI__builtin_neon_vqrdmulhs_s32, ID.aarch64_neon_sqrdmulh, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqrshlb_s8"), NEON.BI__builtin_neon_vqrshlb_s8, ID.aarch64_neon_sqrshl, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqrshlb_u8"), NEON.BI__builtin_neon_vqrshlb_u8, ID.aarch64_neon_uqrshl, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqrshld_s64"), NEON.BI__builtin_neon_vqrshld_s64, ID.aarch64_neon_sqrshl, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqrshld_u64"), NEON.BI__builtin_neon_vqrshld_u64, ID.aarch64_neon_uqrshl, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqrshlh_s16"), NEON.BI__builtin_neon_vqrshlh_s16, ID.aarch64_neon_sqrshl, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqrshlh_u16"), NEON.BI__builtin_neon_vqrshlh_u16, ID.aarch64_neon_uqrshl, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqrshls_s32"), NEON.BI__builtin_neon_vqrshls_s32, ID.aarch64_neon_sqrshl, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqrshls_u32"), NEON.BI__builtin_neon_vqrshls_u32, ID.aarch64_neon_uqrshl, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqrshrnd_n_s64"), NEON.BI__builtin_neon_vqrshrnd_n_s64, ID.aarch64_neon_sqrshrn, 0, AddRetType), 
  new NeonIntrinsicInfo($("vqrshrnd_n_u64"), NEON.BI__builtin_neon_vqrshrnd_n_u64, ID.aarch64_neon_uqrshrn, 0, AddRetType), 
  new NeonIntrinsicInfo($("vqrshrnh_n_s16"), NEON.BI__builtin_neon_vqrshrnh_n_s16, ID.aarch64_neon_sqrshrn, 0, VectorRet | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqrshrnh_n_u16"), NEON.BI__builtin_neon_vqrshrnh_n_u16, ID.aarch64_neon_uqrshrn, 0, VectorRet | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqrshrns_n_s32"), NEON.BI__builtin_neon_vqrshrns_n_s32, ID.aarch64_neon_sqrshrn, 0, VectorRet | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqrshrns_n_u32"), NEON.BI__builtin_neon_vqrshrns_n_u32, ID.aarch64_neon_uqrshrn, 0, VectorRet | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqrshrund_n_s64"), NEON.BI__builtin_neon_vqrshrund_n_s64, ID.aarch64_neon_sqrshrun, 0, AddRetType), 
  new NeonIntrinsicInfo($("vqrshrunh_n_s16"), NEON.BI__builtin_neon_vqrshrunh_n_s16, ID.aarch64_neon_sqrshrun, 0, VectorRet | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqrshruns_n_s32"), NEON.BI__builtin_neon_vqrshruns_n_s32, ID.aarch64_neon_sqrshrun, 0, VectorRet | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqshlb_n_s8"), NEON.BI__builtin_neon_vqshlb_n_s8, ID.aarch64_neon_sqshl, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqshlb_n_u8"), NEON.BI__builtin_neon_vqshlb_n_u8, ID.aarch64_neon_uqshl, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqshlb_s8"), NEON.BI__builtin_neon_vqshlb_s8, ID.aarch64_neon_sqshl, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqshlb_u8"), NEON.BI__builtin_neon_vqshlb_u8, ID.aarch64_neon_uqshl, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqshld_s64"), NEON.BI__builtin_neon_vqshld_s64, ID.aarch64_neon_sqshl, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqshld_u64"), NEON.BI__builtin_neon_vqshld_u64, ID.aarch64_neon_uqshl, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqshlh_n_s16"), NEON.BI__builtin_neon_vqshlh_n_s16, ID.aarch64_neon_sqshl, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqshlh_n_u16"), NEON.BI__builtin_neon_vqshlh_n_u16, ID.aarch64_neon_uqshl, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqshlh_s16"), NEON.BI__builtin_neon_vqshlh_s16, ID.aarch64_neon_sqshl, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqshlh_u16"), NEON.BI__builtin_neon_vqshlh_u16, ID.aarch64_neon_uqshl, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqshls_n_s32"), NEON.BI__builtin_neon_vqshls_n_s32, ID.aarch64_neon_sqshl, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqshls_n_u32"), NEON.BI__builtin_neon_vqshls_n_u32, ID.aarch64_neon_uqshl, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqshls_s32"), NEON.BI__builtin_neon_vqshls_s32, ID.aarch64_neon_sqshl, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqshls_u32"), NEON.BI__builtin_neon_vqshls_u32, ID.aarch64_neon_uqshl, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqshlub_n_s8"), NEON.BI__builtin_neon_vqshlub_n_s8, ID.aarch64_neon_sqshlu, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqshluh_n_s16"), NEON.BI__builtin_neon_vqshluh_n_s16, ID.aarch64_neon_sqshlu, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqshlus_n_s32"), NEON.BI__builtin_neon_vqshlus_n_s32, ID.aarch64_neon_sqshlu, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqshrnd_n_s64"), NEON.BI__builtin_neon_vqshrnd_n_s64, ID.aarch64_neon_sqshrn, 0, AddRetType), 
  new NeonIntrinsicInfo($("vqshrnd_n_u64"), NEON.BI__builtin_neon_vqshrnd_n_u64, ID.aarch64_neon_uqshrn, 0, AddRetType), 
  new NeonIntrinsicInfo($("vqshrnh_n_s16"), NEON.BI__builtin_neon_vqshrnh_n_s16, ID.aarch64_neon_sqshrn, 0, VectorRet | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqshrnh_n_u16"), NEON.BI__builtin_neon_vqshrnh_n_u16, ID.aarch64_neon_uqshrn, 0, VectorRet | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqshrns_n_s32"), NEON.BI__builtin_neon_vqshrns_n_s32, ID.aarch64_neon_sqshrn, 0, VectorRet | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqshrns_n_u32"), NEON.BI__builtin_neon_vqshrns_n_u32, ID.aarch64_neon_uqshrn, 0, VectorRet | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqshrund_n_s64"), NEON.BI__builtin_neon_vqshrund_n_s64, ID.aarch64_neon_sqshrun, 0, AddRetType), 
  new NeonIntrinsicInfo($("vqshrunh_n_s16"), NEON.BI__builtin_neon_vqshrunh_n_s16, ID.aarch64_neon_sqshrun, 0, VectorRet | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqshruns_n_s32"), NEON.BI__builtin_neon_vqshruns_n_s32, ID.aarch64_neon_sqshrun, 0, VectorRet | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqsubb_s8"), NEON.BI__builtin_neon_vqsubb_s8, ID.aarch64_neon_sqsub, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqsubb_u8"), NEON.BI__builtin_neon_vqsubb_u8, ID.aarch64_neon_uqsub, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqsubd_s64"), NEON.BI__builtin_neon_vqsubd_s64, ID.aarch64_neon_sqsub, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqsubd_u64"), NEON.BI__builtin_neon_vqsubd_u64, ID.aarch64_neon_uqsub, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqsubh_s16"), NEON.BI__builtin_neon_vqsubh_s16, ID.aarch64_neon_sqsub, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqsubh_u16"), NEON.BI__builtin_neon_vqsubh_u16, ID.aarch64_neon_uqsub, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vqsubs_s32"), NEON.BI__builtin_neon_vqsubs_s32, ID.aarch64_neon_sqsub, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vqsubs_u32"), NEON.BI__builtin_neon_vqsubs_u32, ID.aarch64_neon_uqsub, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrecped_f64"), NEON.BI__builtin_neon_vrecped_f64, ID.aarch64_neon_frecpe, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrecpes_f32"), NEON.BI__builtin_neon_vrecpes_f32, ID.aarch64_neon_frecpe, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrecpxd_f64"), NEON.BI__builtin_neon_vrecpxd_f64, ID.aarch64_neon_frecpx, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrecpxs_f32"), NEON.BI__builtin_neon_vrecpxs_f32, ID.aarch64_neon_frecpx, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrshld_s64"), NEON.BI__builtin_neon_vrshld_s64, ID.aarch64_neon_srshl, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrshld_u64"), NEON.BI__builtin_neon_vrshld_u64, ID.aarch64_neon_urshl, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrsqrted_f64"), NEON.BI__builtin_neon_vrsqrted_f64, ID.aarch64_neon_frsqrte, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrsqrtes_f32"), NEON.BI__builtin_neon_vrsqrtes_f32, ID.aarch64_neon_frsqrte, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrsqrtsd_f64"), NEON.BI__builtin_neon_vrsqrtsd_f64, ID.aarch64_neon_frsqrts, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vrsqrtss_f32"), NEON.BI__builtin_neon_vrsqrtss_f32, ID.aarch64_neon_frsqrts, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vsha1cq_u32"), NEON.BI__builtin_neon_vsha1cq_u32, ID.aarch64_crypto_sha1c, 0, 0), 
  new NeonIntrinsicInfo($("vsha1h_u32"), NEON.BI__builtin_neon_vsha1h_u32, ID.aarch64_crypto_sha1h, 0, 0), 
  new NeonIntrinsicInfo($("vsha1mq_u32"), NEON.BI__builtin_neon_vsha1mq_u32, ID.aarch64_crypto_sha1m, 0, 0), 
  new NeonIntrinsicInfo($("vsha1pq_u32"), NEON.BI__builtin_neon_vsha1pq_u32, ID.aarch64_crypto_sha1p, 0, 0), 
  new NeonIntrinsicInfo($("vshld_s64"), NEON.BI__builtin_neon_vshld_s64, ID.aarch64_neon_sshl, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vshld_u64"), NEON.BI__builtin_neon_vshld_u64, ID.aarch64_neon_ushl, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vslid_n_s64"), NEON.BI__builtin_neon_vslid_n_s64, ID.aarch64_neon_vsli, 0, Vectorize1ArgType), 
  new NeonIntrinsicInfo($("vslid_n_u64"), NEON.BI__builtin_neon_vslid_n_u64, ID.aarch64_neon_vsli, 0, Vectorize1ArgType), 
  new NeonIntrinsicInfo($("vsqaddb_u8"), NEON.BI__builtin_neon_vsqaddb_u8, ID.aarch64_neon_usqadd, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vsqaddd_u64"), NEON.BI__builtin_neon_vsqaddd_u64, ID.aarch64_neon_usqadd, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vsqaddh_u16"), NEON.BI__builtin_neon_vsqaddh_u16, ID.aarch64_neon_usqadd, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vsqadds_u32"), NEON.BI__builtin_neon_vsqadds_u32, ID.aarch64_neon_usqadd, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vsrid_n_s64"), NEON.BI__builtin_neon_vsrid_n_s64, ID.aarch64_neon_vsri, 0, Vectorize1ArgType), 
  new NeonIntrinsicInfo($("vsrid_n_u64"), NEON.BI__builtin_neon_vsrid_n_u64, ID.aarch64_neon_vsri, 0, Vectorize1ArgType), 
  new NeonIntrinsicInfo($("vuqaddb_s8"), NEON.BI__builtin_neon_vuqaddb_s8, ID.aarch64_neon_suqadd, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vuqaddd_s64"), NEON.BI__builtin_neon_vuqaddd_s64, ID.aarch64_neon_suqadd, 0, Add1ArgType), 
  new NeonIntrinsicInfo($("vuqaddh_s16"), NEON.BI__builtin_neon_vuqaddh_s16, ID.aarch64_neon_suqadd, 0, Vectorize1ArgType | Use64BitVectors), 
  new NeonIntrinsicInfo($("vuqadds_s32"), NEON.BI__builtin_neon_vuqadds_s32, ID.aarch64_neon_suqadd, 0, Add1ArgType)
};
//<editor-fold defaultstate="collapsed" desc="NEONSIMDIntrinsicsProvenSorted">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 3207,
 FQN="NEONSIMDIntrinsicsProvenSorted", NM="_ZL30NEONSIMDIntrinsicsProvenSorted",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL30NEONSIMDIntrinsicsProvenSorted")
//</editor-fold>
public static boolean NEONSIMDIntrinsicsProvenSorted = false;
@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static bool$ref NEONSIMDIntrinsicsProvenSorted_ref = new bool$ref(){
  @Override
  public boolean $deref() {
    return NEONSIMDIntrinsicsProvenSorted;
  }

  @Override
  public boolean $set(boolean value) {
    NEONSIMDIntrinsicsProvenSorted = value;
    return NEONSIMDIntrinsicsProvenSorted;
  }
};

//<editor-fold defaultstate="collapsed" desc="AArch64SIMDIntrinsicsProvenSorted">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 3209,
 FQN="AArch64SIMDIntrinsicsProvenSorted", NM="_ZL33AArch64SIMDIntrinsicsProvenSorted",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL33AArch64SIMDIntrinsicsProvenSorted")
//</editor-fold>
public static boolean AArch64SIMDIntrinsicsProvenSorted = false;
@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static bool$ref AArch64SIMDIntrinsicsProvenSorted_ref = new bool$ref(){
  @Override
  public boolean $deref() {
    return AArch64SIMDIntrinsicsProvenSorted;
  }

  @Override
  public boolean $set(boolean value) {
    AArch64SIMDIntrinsicsProvenSorted = value;
    return AArch64SIMDIntrinsicsProvenSorted;
  }
};

//<editor-fold defaultstate="collapsed" desc="AArch64SISDIntrinsicsProvenSorted">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 3210,
 FQN="AArch64SISDIntrinsicsProvenSorted", NM="_ZL33AArch64SISDIntrinsicsProvenSorted",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL33AArch64SISDIntrinsicsProvenSorted")
//</editor-fold>
public static boolean AArch64SISDIntrinsicsProvenSorted = false;
@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static bool$ref AArch64SISDIntrinsicsProvenSorted_ref = new bool$ref(){
  @Override
  public boolean $deref() {
    return AArch64SISDIntrinsicsProvenSorted;
  }

  @Override
  public boolean $set(boolean value) {
    AArch64SISDIntrinsicsProvenSorted = value;
    return AArch64SISDIntrinsicsProvenSorted;
  }
};

//<editor-fold defaultstate="collapsed" desc="findNeonIntrinsicInMap">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 3213,
 FQN="findNeonIntrinsicInMap", NM="_ZL22findNeonIntrinsicInMapN4llvm8ArrayRefIN12_GLOBAL__N_117NeonIntrinsicInfoEEEjRb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL22findNeonIntrinsicInMapN4llvm8ArrayRefIN12_GLOBAL__N_117NeonIntrinsicInfoEEEjRb")
//</editor-fold>
public static /*const*/ NeonIntrinsicInfo /*P*/ findNeonIntrinsicInMap(ArrayRef<NeonIntrinsicInfo> IntrinsicMap, 
                      /*uint*/int BuiltinID, final bool$ref/*bool &*/ MapProvenSorted) {
  if (!MapProvenSorted.$deref()) {
    assert (std.is_sorted(std.begin(IntrinsicMap), std.end(IntrinsicMap)));
    MapProvenSorted.$set(true);
  }
  
  /*const*/
  type$ptr<NeonIntrinsicInfo> /*P*/ Builtin = std.lower_bound(IntrinsicMap.begin(), IntrinsicMap.end(), BuiltinID);
  if (Builtin.$noteq(IntrinsicMap.end()) && Builtin.$star().BuiltinID == BuiltinID) {
    return Builtin.$star();
  }
  
  return null;
}

//<editor-fold defaultstate="collapsed" desc="EmitCommonNeonSISDBuiltinExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 3272,
 FQN="EmitCommonNeonSISDBuiltinExpr", NM="_ZL29EmitCommonNeonSISDBuiltinExprRN5clang7CodeGen15CodeGenFunctionERKN12_GLOBAL__N_117NeonIntrinsicInfoERN4llvm15SmallVectorImplIPNS7_5ValueEEEPKNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL29EmitCommonNeonSISDBuiltinExprRN5clang7CodeGen15CodeGenFunctionERKN12_GLOBAL__N_117NeonIntrinsicInfoERN4llvm15SmallVectorImplIPNS7_5ValueEEEPKNS_8CallExprE")
//</editor-fold>
public static Value /*P*/ EmitCommonNeonSISDBuiltinExpr(final CodeGenFunction /*&*/ CGF, 
                             final /*const*/ NeonIntrinsicInfo /*&*/ SISDInfo, 
                             final SmallVectorImpl<Value /*P*/ > /*&*/ Ops, 
                             /*const*/ CallExpr /*P*/ E) {
  /*uint*/int BuiltinID = SISDInfo.BuiltinID;
  /*uint*/int Int = SISDInfo.LLVMIntrinsic;
  /*uint*/int Modifier = SISDInfo.TypeModifier;
  /*const*/char$ptr/*char P*/ s = $tryClone(SISDInfo.NameHint);
  switch (BuiltinID) {
   case NEON.BI__builtin_neon_vcled_s64:
   case NEON.BI__builtin_neon_vcled_u64:
   case NEON.BI__builtin_neon_vcles_f32:
   case NEON.BI__builtin_neon_vcled_f64:
   case NEON.BI__builtin_neon_vcltd_s64:
   case NEON.BI__builtin_neon_vcltd_u64:
   case NEON.BI__builtin_neon_vclts_f32:
   case NEON.BI__builtin_neon_vcltd_f64:
   case NEON.BI__builtin_neon_vcales_f32:
   case NEON.BI__builtin_neon_vcaled_f64:
   case NEON.BI__builtin_neon_vcalts_f32:
   case NEON.BI__builtin_neon_vcaltd_f64:
    // Only one direction of comparisons actually exist, cmle is actually a cmge
    // with swapped operands. The table gives us the right intrinsic but we
    // still need to do the swap.
    std.swap(Ops.ref$at(0), Ops.ref$at(1));
    break;
  }
  assert ((Int != 0)) : "Generic code assumes a valid intrinsic";
  
  // Determine the type(s) of this overloaded AArch64 intrinsic.
  /*const*/ Expr /*P*/ Arg = E.getArg$Const(0);
  org.llvm.ir.Type /*P*/ ArgTy = CGF.ConvertType(Arg.getType());
  Function /*P*/ F = CGF.LookupNeonLLVMIntrinsic(Int, Modifier, ArgTy, E);
  
  int j = 0;
  ConstantInt /*P*/ C0 = ConstantInt.get(CGF.Unnamed_field8.SizeTy, $int2ulong(0));
  for (ilist_iterator</*const*/ Argument> ai = new ilist_iterator</*const*/ Argument>(F.arg_begin()), ae = new ilist_iterator</*const*/ Argument>(F.arg_end());
       ai.$noteq(ae); ai.$preInc() , ++j) {
    org.llvm.ir.Type /*P*/ ArgTy$1 = ai.$arrow().getType();
    if (Ops.$at(j).getType().getPrimitiveSizeInBits()
       == ArgTy$1.getPrimitiveSizeInBits()) {
      continue;
    }
    assert (ArgTy$1.isVectorTy() && !Ops.$at(j).getType().isVectorTy());
    // The constant argument to an _n_ intrinsic always has Int32Ty, so truncate
    // it before inserting.
    Ops.$set(j, 
      CGF.Builder.CreateTruncOrBitCast(Ops.$at(j), ArgTy$1.getVectorElementType()));
    Ops.$set(j, 
      CGF.Builder.CreateInsertElement(UndefValue.get(ArgTy$1), Ops.$at(j), C0));
  }
  
  Value /*P*/ Result = CGF.EmitNeonCall(F, Ops, s);
  org.llvm.ir.Type /*P*/ ResultType = CGF.ConvertType(E.getType());
  if ($less_uint(ResultType.getPrimitiveSizeInBits()
    , Result.getType().getPrimitiveSizeInBits())) {
    return CGF.Builder.CreateExtractElement(Result, C0);
  }
  
  return CGF.Builder.CreateBitCast(Result, ResultType, new Twine(s));
}

//<editor-fold defaultstate="collapsed" desc="packTBLDVectorList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 3782,
 FQN="packTBLDVectorList", NM="_ZL18packTBLDVectorListRN5clang7CodeGen15CodeGenFunctionEN4llvm8ArrayRefIPNS3_5ValueEEES6_S6_PNS3_4TypeEjPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL18packTBLDVectorListRN5clang7CodeGen15CodeGenFunctionEN4llvm8ArrayRefIPNS3_5ValueEEES6_S6_PNS3_4TypeEjPKc")
//</editor-fold>
public static Value /*P*/ packTBLDVectorList(final CodeGenFunction /*&*/ CGF, ArrayRef<Value /*P*/ > Ops, 
                  Value /*P*/ ExtOp, Value /*P*/ IndexOp, 
                  org.llvm.ir.Type /*P*/ ResTy, /*uint*/int IntID, 
                  /*const*/char$ptr/*char P*/ Name) {
  SmallVector<Value /*P*/ > TblOps/*J*/= new SmallVector<Value /*P*/ >(2, (Value /*P*/ )null);
  if ((ExtOp != null)) {
    TblOps.push_back(ExtOp);
  }
  
  // Build a vector containing sequential number like (0, 1, 2, ..., 15)
  SmallVectorUInt Indices/*J*/= new SmallVectorUInt(16, (/*uint32_t*/int)0);
  org.llvm.ir.VectorType /*P*/ TblTy = cast_VectorType(Ops.$at(0).getType());
  for (/*uint*/int i = 0, e = TblTy.getNumElements(); i != e; ++i) {
    Indices.push_back(2 * i);
    Indices.push_back(2 * i + 1);
  }
  
  int PairPos = 0;
  int End = Ops.size() - 1;
  while (PairPos < End) {
    TblOps.push_back(CGF.Builder.CreateShuffleVector(Ops.$at(PairPos), 
            Ops.$at(PairPos + 1), new ArrayRefUInt(Indices), 
            new Twine(Name)));
    PairPos += 2;
  }
  
  // If there's an odd number of 64-bit lookup table, fill the high 64-bit
  // of the 128-bit lookup table with zero.
  if (PairPos == End) {
    Value /*P*/ ZeroTbl = ConstantAggregateZero.get(TblTy);
    TblOps.push_back(CGF.Builder.CreateShuffleVector(Ops.$at(PairPos), 
            ZeroTbl, new ArrayRefUInt(Indices), new Twine(Name)));
  }
  
  Function /*P*/ TblF;
  TblOps.push_back(IndexOp);
  TblF = CGF.CGM.getIntrinsic(IntID, new ArrayRef<org.llvm.ir.Type /*P*/ >(ResTy, true));
  
  return CGF.EmitNeonCall(TblF, TblOps, Name);
}


// Generates the IR for the read/write special register builtin,
// ValueType is the type of the value that is to be written or read,
// RegisterType is the type of the register being written to or read from.
//<editor-fold defaultstate="collapsed" desc="EmitSpecialRegisterBuiltin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 3858,
 FQN="EmitSpecialRegisterBuiltin", NM="_ZL26EmitSpecialRegisterBuiltinRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprEPN4llvm4TypeES8_bNS6_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL26EmitSpecialRegisterBuiltinRN5clang7CodeGen15CodeGenFunctionEPKNS_8CallExprEPN4llvm4TypeES8_bNS6_9StringRefE")
//</editor-fold>
public static Value /*P*/ EmitSpecialRegisterBuiltin(final CodeGenFunction /*&*/ CGF, 
                          /*const*/ CallExpr /*P*/ E, 
                          org.llvm.ir.Type /*P*/ RegisterType, 
                          org.llvm.ir.Type /*P*/ ValueType, 
                          boolean IsRead) {
  return EmitSpecialRegisterBuiltin(CGF, 
                          E, 
                          RegisterType, 
                          ValueType, 
                          IsRead, 
                          new StringRef(/*KEEP_STR*/$EMPTY));
}
public static Value /*P*/ EmitSpecialRegisterBuiltin(final CodeGenFunction /*&*/ CGF, 
                          /*const*/ CallExpr /*P*/ E, 
                          org.llvm.ir.Type /*P*/ RegisterType, 
                          org.llvm.ir.Type /*P*/ ValueType, 
                          boolean IsRead, 
                          StringRef SysReg/*= ""*/) {
  // write and register intrinsics only support 32 and 64 bit operations.
  assert ((RegisterType.isIntegerTy(32) || RegisterType.isIntegerTy(64))) : "Unsupported size for register.";
  
  final CGBuilderTy /*&*/ Builder = CGF.Builder;
  final CodeGenModule /*&*/ CGM = CGF.CGM;
  final LLVMContext /*&*/ Context = CGM.getLLVMContext();
  if (SysReg.empty()) {
    /*const*/ Expr /*P*/ SysRegStrExpr = E.getArg$Const(0).IgnoreParenCasts$Const();
    SysReg.$assignMove(cast_StringLiteral(SysRegStrExpr).getString());
  }
  
  Metadata /*P*/ Ops[/*1*/] = new Metadata /*P*/  [/*1*/] {MDString.get(Context, new StringRef(SysReg))};
  MDNode /*P*/ RegName = MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(Ops, true));
  Value /*P*/ Metadata = MetadataAsValue.get(Context, RegName);
  
  org.llvm.ir.Type /*P*/ Types[/*1*/] = new org.llvm.ir.Type /*P*/  [/*1*/] {RegisterType};
  
  boolean MixedTypes = RegisterType.isIntegerTy(64) && ValueType.isIntegerTy(32);
  assert (!(RegisterType.isIntegerTy(32) && ValueType.isIntegerTy(64))) : "Can't fit 64-bit value in 32-bit register";
  if (IsRead) {
    Value /*P*/ F = CGM.getIntrinsic(ID.read_register, new ArrayRef<org.llvm.ir.Type /*P*/ >(Types, true));
    Value /*P*/ Call = Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(Metadata, true));
    if (MixedTypes) {
      // Read into 64 bit register and then truncate result to 32 bit.
      return Builder.CreateTrunc(Call, ValueType);
    }
    if (ValueType.isPointerTy()) {
      // Have i32/i64 result (Call) but want to return a VoidPtrTy (i8*).
      return Builder.CreateIntToPtr(Call, ValueType);
    }
    
    return Call;
  }
  
  Value /*P*/ F = CGM.getIntrinsic(ID.write_register, new ArrayRef<org.llvm.ir.Type /*P*/ >(Types, true));
  Value /*P*/ ArgValue = CGF.EmitScalarExpr(E.getArg$Const(1));
  if (MixedTypes) {
    // Extend 32 bit write value to 64 bit to pass to write.
    ArgValue = Builder.CreateZExt(ArgValue, RegisterType);
    return Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Metadata, ArgValue}, true)/* }*/);
  }
  if (ValueType.isPointerTy()) {
    // Have VoidPtrTy ArgValue but want to return an i32/i64.
    ArgValue = Builder.CreatePtrToInt(ArgValue, RegisterType);
    return Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Metadata, ArgValue}, true)/* }*/);
  }
  
  return Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Metadata, ArgValue}, true)/* }*/);
}


/// Return true if BuiltinID is an overloaded Neon intrinsic with an extra
/// argument that specifies the vector type.
//<editor-fold defaultstate="collapsed" desc="HasExtraNeonArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 3921,
 FQN="HasExtraNeonArgument", NM="_ZL20HasExtraNeonArgumentj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL20HasExtraNeonArgumentj")
//</editor-fold>
public static boolean HasExtraNeonArgument(/*uint*/int BuiltinID) {
  switch (BuiltinID) {
   default:
    break;
   case NEON.BI__builtin_neon_vget_lane_i8:
   case NEON.BI__builtin_neon_vget_lane_i16:
   case NEON.BI__builtin_neon_vget_lane_i32:
   case NEON.BI__builtin_neon_vget_lane_i64:
   case NEON.BI__builtin_neon_vget_lane_f32:
   case NEON.BI__builtin_neon_vgetq_lane_i8:
   case NEON.BI__builtin_neon_vgetq_lane_i16:
   case NEON.BI__builtin_neon_vgetq_lane_i32:
   case NEON.BI__builtin_neon_vgetq_lane_i64:
   case NEON.BI__builtin_neon_vgetq_lane_f32:
   case NEON.BI__builtin_neon_vset_lane_i8:
   case NEON.BI__builtin_neon_vset_lane_i16:
   case NEON.BI__builtin_neon_vset_lane_i32:
   case NEON.BI__builtin_neon_vset_lane_i64:
   case NEON.BI__builtin_neon_vset_lane_f32:
   case NEON.BI__builtin_neon_vsetq_lane_i8:
   case NEON.BI__builtin_neon_vsetq_lane_i16:
   case NEON.BI__builtin_neon_vsetq_lane_i32:
   case NEON.BI__builtin_neon_vsetq_lane_i64:
   case NEON.BI__builtin_neon_vsetq_lane_f32:
   case NEON.BI__builtin_neon_vsha1h_u32:
   case NEON.BI__builtin_neon_vsha1cq_u32:
   case NEON.BI__builtin_neon_vsha1pq_u32:
   case NEON.BI__builtin_neon_vsha1mq_u32:
   case ARM.BI_MoveToCoprocessor:
   case ARM.BI_MoveToCoprocessor2:
    return false;
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="EmitAArch64TblBuiltinExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 4629,
 FQN="EmitAArch64TblBuiltinExpr", NM="_ZL25EmitAArch64TblBuiltinExprRN5clang7CodeGen15CodeGenFunctionEjPKNS_8CallExprERN4llvm15SmallVectorImplIPNS6_5ValueEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL25EmitAArch64TblBuiltinExprRN5clang7CodeGen15CodeGenFunctionEjPKNS_8CallExprERN4llvm15SmallVectorImplIPNS6_5ValueEEE")
//</editor-fold>
public static Value /*P*/ EmitAArch64TblBuiltinExpr(final CodeGenFunction /*&*/ CGF, /*uint*/int BuiltinID, 
                         /*const*/ CallExpr /*P*/ E, 
                         final SmallVectorImpl<Value /*P*/ > /*&*/ Ops) {
  /*uint*/int Int = 0;
  /*const*/char$ptr/*char P*/ s = null;
  switch (BuiltinID) {
   default:
    return null;
   case NEON.BI__builtin_neon_vtbl1_v:
   case NEON.BI__builtin_neon_vqtbl1_v:
   case NEON.BI__builtin_neon_vqtbl1q_v:
   case NEON.BI__builtin_neon_vtbl2_v:
   case NEON.BI__builtin_neon_vqtbl2_v:
   case NEON.BI__builtin_neon_vqtbl2q_v:
   case NEON.BI__builtin_neon_vtbl3_v:
   case NEON.BI__builtin_neon_vqtbl3_v:
   case NEON.BI__builtin_neon_vqtbl3q_v:
   case NEON.BI__builtin_neon_vtbl4_v:
   case NEON.BI__builtin_neon_vqtbl4_v:
   case NEON.BI__builtin_neon_vqtbl4q_v:
    break;
   case NEON.BI__builtin_neon_vtbx1_v:
   case NEON.BI__builtin_neon_vqtbx1_v:
   case NEON.BI__builtin_neon_vqtbx1q_v:
   case NEON.BI__builtin_neon_vtbx2_v:
   case NEON.BI__builtin_neon_vqtbx2_v:
   case NEON.BI__builtin_neon_vqtbx2q_v:
   case NEON.BI__builtin_neon_vtbx3_v:
   case NEON.BI__builtin_neon_vqtbx3_v:
   case NEON.BI__builtin_neon_vqtbx3q_v:
   case NEON.BI__builtin_neon_vtbx4_v:
   case NEON.BI__builtin_neon_vqtbx4_v:
   case NEON.BI__builtin_neon_vqtbx4q_v:
    break;
  }
  assert ($greatereq_uint(E.getNumArgs(), 3));
  
  // Get the last argument, which specifies the vector type.
  APSInt Result/*J*/= new APSInt();
  /*const*/ Expr /*P*/ Arg = E.getArg$Const(E.getNumArgs() - 1);
  if (!Arg.isIntegerConstantExpr(Result, CGF.getContext())) {
    return null;
  }
  
  // Determine the type of this overloaded NEON intrinsic.
  NeonTypeFlags Type/*J*/= new NeonTypeFlags($ulong2uint(Result.getZExtValue()));
  org.llvm.ir.VectorType /*P*/ Ty = GetNeonType(/*AddrOf*/CGF, new NeonTypeFlags(Type));
  if (!(Ty != null)) {
    return null;
  }
  
  final CGBuilderTy /*&*/ Builder = CGF.Builder;
  
  // AArch64 scalar builtins are not overloaded, they do not have an extra
  // argument that specifies the vector type, need to handle each case.
  switch (BuiltinID) {
   case NEON.BI__builtin_neon_vtbl1_v:
    {
      return packTBLDVectorList(CGF, makeArrayRef(Ops).slice(0, 1), (Value /*P*/ )null, 
          Ops.$at(1), Ty, ID.aarch64_neon_tbl1, 
          $("vtbl1"));
    }
   case NEON.BI__builtin_neon_vtbl2_v:
    {
      return packTBLDVectorList(CGF, makeArrayRef(Ops).slice(0, 2), (Value /*P*/ )null, 
          Ops.$at(2), Ty, ID.aarch64_neon_tbl1, 
          $("vtbl1"));
    }
   case NEON.BI__builtin_neon_vtbl3_v:
    {
      return packTBLDVectorList(CGF, makeArrayRef(Ops).slice(0, 3), (Value /*P*/ )null, 
          Ops.$at(3), Ty, ID.aarch64_neon_tbl2, 
          $("vtbl2"));
    }
   case NEON.BI__builtin_neon_vtbl4_v:
    {
      return packTBLDVectorList(CGF, makeArrayRef(Ops).slice(0, 4), (Value /*P*/ )null, 
          Ops.$at(4), Ty, ID.aarch64_neon_tbl2, 
          $("vtbl2"));
    }
   case NEON.BI__builtin_neon_vtbx1_v:
    {
      Value /*P*/ TblRes = packTBLDVectorList(CGF, makeArrayRef(Ops).slice(1, 1), (Value /*P*/ )null, Ops.$at(2), 
          Ty, ID.aarch64_neon_tbl1, $("vtbl1"));
      
      Constant /*P*/ EightV = ConstantInt.get(Ty, $int2ulong(8));
      Value /*P*/ CmpRes = Builder.CreateICmp(ICmpInst.Predicate.ICMP_UGE, Ops.$at(2), EightV);
      CmpRes = Builder.CreateSExt(CmpRes, Ty);
      
      Value /*P*/ EltsFromInput = Builder.CreateAnd(CmpRes, Ops.$at(0));
      Value /*P*/ EltsFromTbl = Builder.CreateAnd(Builder.CreateNot(CmpRes), TblRes);
      return Builder.CreateOr(EltsFromInput, EltsFromTbl, new Twine(/*KEEP_STR*/"vtbx"));
    }
   case NEON.BI__builtin_neon_vtbx2_v:
    {
      return packTBLDVectorList(CGF, makeArrayRef(Ops).slice(1, 2), Ops.$at(0), 
          Ops.$at(3), Ty, ID.aarch64_neon_tbx1, 
          $("vtbx1"));
    }
   case NEON.BI__builtin_neon_vtbx3_v:
    {
      Value /*P*/ TblRes = packTBLDVectorList(CGF, makeArrayRef(Ops).slice(1, 3), (Value /*P*/ )null, Ops.$at(4), 
          Ty, ID.aarch64_neon_tbl2, $("vtbl2"));
      
      Constant /*P*/ TwentyFourV = ConstantInt.get(Ty, $int2ulong(24));
      Value /*P*/ CmpRes = Builder.CreateICmp(ICmpInst.Predicate.ICMP_UGE, Ops.$at(4), 
          TwentyFourV);
      CmpRes = Builder.CreateSExt(CmpRes, Ty);
      
      Value /*P*/ EltsFromInput = Builder.CreateAnd(CmpRes, Ops.$at(0));
      Value /*P*/ EltsFromTbl = Builder.CreateAnd(Builder.CreateNot(CmpRes), TblRes);
      return Builder.CreateOr(EltsFromInput, EltsFromTbl, new Twine(/*KEEP_STR*/"vtbx"));
    }
   case NEON.BI__builtin_neon_vtbx4_v:
    {
      return packTBLDVectorList(CGF, makeArrayRef(Ops).slice(1, 4), Ops.$at(0), 
          Ops.$at(5), Ty, ID.aarch64_neon_tbx2, 
          $("vtbx2"));
    }
   case NEON.BI__builtin_neon_vqtbl1_v:
   case NEON.BI__builtin_neon_vqtbl1q_v:
    Int = ID.aarch64_neon_tbl1;
    s = $tryClone($("vtbl1"));
    break;
   case NEON.BI__builtin_neon_vqtbl2_v:
   case NEON.BI__builtin_neon_vqtbl2q_v:
    // { JAVA does not undersatand such constructs
      Int = ID.aarch64_neon_tbl2;
      s = $tryClone($("vtbl2"));
      break;
     case NEON.BI__builtin_neon_vqtbl3q_v:
      Int = ID.aarch64_neon_tbl3;
      s = $tryClone($("vtbl3"));
      break;
     case NEON.BI__builtin_neon_vqtbl4_v:
     case NEON.BI__builtin_neon_vqtbl4q_v:
      Int = ID.aarch64_neon_tbl4;
      s = $tryClone($("vtbl4"));
      break;
     case NEON.BI__builtin_neon_vqtbx1_v:
     case NEON.BI__builtin_neon_vqtbx1q_v:
      Int = ID.aarch64_neon_tbx1;
      s = $tryClone($("vtbx1"));
      break;
     case NEON.BI__builtin_neon_vqtbx2_v:
     case NEON.BI__builtin_neon_vqtbx2q_v:
      Int = ID.aarch64_neon_tbx2;
      s = $tryClone($("vtbx2"));
      break;
     case NEON.BI__builtin_neon_vqtbx3_v:
     case NEON.BI__builtin_neon_vqtbx3q_v:
      Int = ID.aarch64_neon_tbx3;
      s = $tryClone($("vtbx3"));
      break;
     case NEON.BI__builtin_neon_vqtbx4_v:
     case NEON.BI__builtin_neon_vqtbx4q_v:
      Int = ID.aarch64_neon_tbx4;
      s = $tryClone($("vtbx4"));
      break;
    // } JAVA does not undersatand such constructs
  }
  if (!(Int != 0)) {
    return null;
  }
  
  Function /*P*/ F = CGF.CGM.getIntrinsic(Int, new ArrayRef<org.llvm.ir.Type /*P*/ >(Ty, true));
  return CGF.EmitNeonCall(F, Ops, s);
}


// Convert the mask from an integer type to a vector of i1.
//<editor-fold defaultstate="collapsed" desc="getMaskVecValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 6568,
 FQN="getMaskVecValue", NM="_ZL15getMaskVecValueRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL15getMaskVecValueRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueEj")
//</editor-fold>
public static Value /*P*/ getMaskVecValue(final CodeGenFunction /*&*/ CGF, Value /*P*/ Mask, 
               /*uint*/int NumElts) {
  
  org.llvm.ir.VectorType /*P*/ MaskTy = org.llvm.ir.VectorType.get(CGF.Builder.getInt1Ty(), 
      cast_IntegerType(Mask.getType()).getBitWidth());
  Value /*P*/ MaskVec = CGF.Builder.CreateBitCast(Mask, MaskTy);
  
  // If we have less than 8 elements, then the starting mask was an i8 and
  // we need to extract down to the right number of elements.
  if ($less_uint(NumElts, 8)) {
    /*uint32_t*/int Indices[/*4*/] = new$uint(4);
    for (/*uint*/int i = 0; i != NumElts; ++i)  {
      Indices[i] = i;
    }
    MaskVec = CGF.Builder.CreateShuffleVector(MaskVec, MaskVec, 
        makeArrayRef(Indices, NumElts), 
        new Twine(/*KEEP_STR*/"extract"));
  }
  return MaskVec;
}

//<editor-fold defaultstate="collapsed" desc="EmitX86MaskedStore">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 6588,
 FQN="EmitX86MaskedStore", NM="_ZL18EmitX86MaskedStoreRN5clang7CodeGen15CodeGenFunctionERN4llvm15SmallVectorImplIPNS3_5ValueEEEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL18EmitX86MaskedStoreRN5clang7CodeGen15CodeGenFunctionERN4llvm15SmallVectorImplIPNS3_5ValueEEEj")
//</editor-fold>
public static Value /*P*/ EmitX86MaskedStore(final CodeGenFunction /*&*/ CGF, 
                  final SmallVectorImpl<Value /*P*/ > /*&*/ Ops, 
                  /*uint*/int Align) {
  // Cast the pointer to right type.
  Ops.$set(0, CGF.Builder.CreateBitCast(Ops.$at(0), 
      org.llvm.ir.PointerType.getUnqual(Ops.$at(1).getType())));
  {
    
    // If the mask is all ones just emit a regular store.
    /*const*/ Constant /*P*/ C = dyn_cast_Constant(Ops.$at(2));
    if ((C != null)) {
      if (C.isAllOnesValue()) {
        return CGF.Builder.CreateAlignedStore(Ops.$at(1), Ops.$at(0), Align);
      }
    }
  }
  
  Value /*P*/ MaskVec = getMaskVecValue(CGF, Ops.$at(2), 
      Ops.$at(1).getType().getVectorNumElements());
  
  return CGF.Builder.CreateMaskedStore(Ops.$at(1), Ops.$at(0), Align, MaskVec);
}

//<editor-fold defaultstate="collapsed" desc="EmitX86MaskedLoad">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 6606,
 FQN="EmitX86MaskedLoad", NM="_ZL17EmitX86MaskedLoadRN5clang7CodeGen15CodeGenFunctionERN4llvm15SmallVectorImplIPNS3_5ValueEEEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL17EmitX86MaskedLoadRN5clang7CodeGen15CodeGenFunctionERN4llvm15SmallVectorImplIPNS3_5ValueEEEj")
//</editor-fold>
public static Value /*P*/ EmitX86MaskedLoad(final CodeGenFunction /*&*/ CGF, 
                 final SmallVectorImpl<Value /*P*/ > /*&*/ Ops, /*uint*/int Align) {
  // Cast the pointer to right type.
  Ops.$set(0, CGF.Builder.CreateBitCast(Ops.$at(0), 
      org.llvm.ir.PointerType.getUnqual(Ops.$at(1).getType())));
  {
    
    // If the mask is all ones just emit a regular store.
    /*const*/ Constant /*P*/ C = dyn_cast_Constant(Ops.$at(2));
    if ((C != null)) {
      if (C.isAllOnesValue()) {
        return CGF.Builder.CreateAlignedLoad(Ops.$at(0), Align);
      }
    }
  }
  
  Value /*P*/ MaskVec = getMaskVecValue(CGF, Ops.$at(2), 
      Ops.$at(1).getType().getVectorNumElements());
  
  return CGF.Builder.CreateMaskedLoad(Ops.$at(0), Align, MaskVec, Ops.$at(1));
}

//<editor-fold defaultstate="collapsed" desc="EmitX86Select">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 6623,
 FQN="EmitX86Select", NM="_ZL13EmitX86SelectRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueES5_S5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL13EmitX86SelectRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueES5_S5_")
//</editor-fold>
public static Value /*P*/ EmitX86Select(final CodeGenFunction /*&*/ CGF, 
             Value /*P*/ Mask, Value /*P*/ Op0, Value /*P*/ Op1) {
  {
    
    // If the mask is all ones just return first argument.
    /*const*/ Constant /*P*/ C = dyn_cast_Constant(Mask);
    if ((C != null)) {
      if (C.isAllOnesValue()) {
        return Op0;
      }
    }
  }
  
  Mask = getMaskVecValue(CGF, Mask, Op0.getType().getVectorNumElements());
  
  return CGF.Builder.CreateSelect(Mask, Op0, Op1);
}

//<editor-fold defaultstate="collapsed" desc="EmitX86MaskedCompare">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 6636,
 FQN="EmitX86MaskedCompare", NM="_ZL20EmitX86MaskedCompareRN5clang7CodeGen15CodeGenFunctionEjbRN4llvm15SmallVectorImplIPNS3_5ValueEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL20EmitX86MaskedCompareRN5clang7CodeGen15CodeGenFunctionEjbRN4llvm15SmallVectorImplIPNS3_5ValueEEE")
//</editor-fold>
public static Value /*P*/ EmitX86MaskedCompare(final CodeGenFunction /*&*/ CGF, /*uint*/int CC, 
                    boolean Signed, final SmallVectorImpl<Value /*P*/ > /*&*/ Ops) {
  /*uint*/int NumElts = Ops.$at(0).getType().getVectorNumElements();
  Value /*P*/ Cmp;
  if (CC == 3) {
    Cmp = Constant.getNullValue(org.llvm.ir.VectorType.get(CGF.Builder.getInt1Ty(), NumElts));
  } else if (CC == 7) {
    Cmp = Constant.getAllOnesValue(org.llvm.ir.VectorType.get(CGF.Builder.getInt1Ty(), NumElts));
  } else {
    ICmpInst.Predicate Pred;
    switch (CC) {
     default:
      throw new llvm_unreachable("Unknown condition code");
     case 0:
      Pred = ICmpInst.Predicate.ICMP_EQ;
      break;
     case 1:
      Pred = Signed ? ICmpInst.Predicate.ICMP_SLT : ICmpInst.Predicate.ICMP_ULT;
      break;
     case 2:
      Pred = Signed ? ICmpInst.Predicate.ICMP_SLE : ICmpInst.Predicate.ICMP_ULE;
      break;
     case 4:
      Pred = ICmpInst.Predicate.ICMP_NE;
      break;
     case 5:
      Pred = Signed ? ICmpInst.Predicate.ICMP_SGE : ICmpInst.Predicate.ICMP_UGE;
      break;
     case 6:
      Pred = Signed ? ICmpInst.Predicate.ICMP_SGT : ICmpInst.Predicate.ICMP_UGT;
      break;
    }
    Cmp = CGF.Builder.CreateICmp(Pred, Ops.$at(0), Ops.$at(1));
  }
  
  /*const*/ Constant /*P*/ C = dyn_cast_Constant(Ops.back());
  if (!(C != null) || !C.isAllOnesValue()) {
    Cmp = CGF.Builder.CreateAnd(Cmp, getMaskVecValue(CGF, Ops.back(), NumElts));
  }
  if ($less_uint(NumElts, 8)) {
    /*uint32_t*/int Indices[/*8*/] = new$uint(8);
    for (/*uint*/int i = 0; i != NumElts; ++i)  {
      Indices[i] = i;
    }
    for (/*uint*/int i = NumElts; i != 8; ++i)  {
      Indices[i] = $rem_uint(i, NumElts) + NumElts;
    }
    Cmp = CGF.Builder.CreateShuffleVector(Cmp, Constant.getNullValue(Cmp.getType()), new ArrayRefUInt(Indices));
  }
  return CGF.Builder.CreateBitCast(Cmp, 
      IntegerType.get(CGF.getLLVMContext(), 
          std.max(NumElts, 8/*U*/)));
}


/// Handle a SystemZ function in which the final argument is a pointer
/// to an int that receives the post-instruction CC value.  At the LLVM level
/// this is represented as a function that returns a {result, cc} pair.
//<editor-fold defaultstate="collapsed" desc="EmitSystemZIntrinsicWithCC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 7702,
 FQN="EmitSystemZIntrinsicWithCC", NM="_ZL26EmitSystemZIntrinsicWithCCRN5clang7CodeGen15CodeGenFunctionEjPKNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZL26EmitSystemZIntrinsicWithCCRN5clang7CodeGen15CodeGenFunctionEjPKNS_8CallExprE")
//</editor-fold>
public static Value /*P*/ EmitSystemZIntrinsicWithCC(final CodeGenFunction /*&*/ CGF, 
                          /*uint*/int IntrinsicID, 
                          /*const*/ CallExpr /*P*/ E) {
  /*uint*/int NumArgs = E.getNumArgs() - 1;
  SmallVector<Value /*P*/ > Args/*J*/= new SmallVector<Value /*P*/ >(JD$UInt_T$C$R.INSTANCE, 8, NumArgs, (Value /*P*/ )null);
  for (/*uint*/int I = 0; $less_uint(I, NumArgs); ++I)  {
    Args.$set(I, CGF.EmitScalarExpr(E.getArg$Const(I)));
  }
  Address CCPtr = CGF.EmitPointerWithAlignment(E.getArg$Const(NumArgs));
  Value /*P*/ F = CGF.CGM.getIntrinsic(IntrinsicID);
  Value /*P*/ Call = CGF.Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(Args, true));
  Value /*P*/ CC = CGF.Builder.CreateExtractValue(Call, new ArrayRefUInt(1));
  CGF.Builder.CreateStore(CC, new Address(CCPtr));
  return CGF.Builder.CreateExtractValue(Call, new ArrayRefUInt(0));
}

} // END OF class CGBuiltinStatics
