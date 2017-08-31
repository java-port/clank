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
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.driver.frontend.CodeGenOptions;
import org.llvm.ir.intrinsic.ID;
import static org.clang.ast.java.AstRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CGExprScalarStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZL10getAsInt32PN4llvm11ConstantIntEPNS_4TypeE;_ZL10getMaskEltPN4llvm17ShuffleVectorInstEjjPNS_4TypeE;_ZL12GetIntrinsic13IntrinsicTypeN5clang11BuiltinType4KindE;_ZL12buildFMulAddPN4llvm14BinaryOperatorEPNS_5ValueERKN5clang7CodeGen15CodeGenFunctionERNS5_11CGBuilderTyEbb;_ZL14tryEmitFMulAddRKN12_GLOBAL__N_19BinOpInfoERKN5clang7CodeGen15CodeGenFunctionERNS4_11CGBuilderTyEb;_ZL18ConvertVec3AndVec4RN5clang7CodeGen11CGBuilderTyERNS0_15CodeGenFunctionEPN4llvm5ValueEj;_ZL21emitPointerArithmeticRN5clang7CodeGen15CodeGenFunctionERKN12_GLOBAL__N_19BinOpInfoEb;_ZL25createBinOpInfoFromIncDecPKN5clang13UnaryOperatorEPN4llvm5ValueEb;_ZL38isCheapEnoughToEvaluateUnconditionallyPKN5clang4ExprERNS_7CodeGen15CodeGenFunctionE;_ZN12_GLOBAL__N_1L18MustVisitNullValueEPKN5clang4ExprE; -static-type=CGExprScalarStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGExprScalarStatics {

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MustVisitNullValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 53,
 FQN="(anonymous namespace)::MustVisitNullValue", NM="_ZN12_GLOBAL__N_1L18MustVisitNullValueEPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_1L18MustVisitNullValueEPKN5clang4ExprE")
//</editor-fold>
public static boolean MustVisitNullValue(/*const*/ Expr /*P*/ E) {
  // If a null pointer expression's type is the C++0x nullptr_t, then
  // it's not necessarily a simple constant and it must be evaluated
  // for its potential side effects.
  return E.getType().$arrow().isNullPtrType();
}

//<editor-fold defaultstate="collapsed" desc="getMaskElt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 1149,
 FQN="getMaskElt", NM="_ZL10getMaskEltPN4llvm17ShuffleVectorInstEjjPNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZL10getMaskEltPN4llvm17ShuffleVectorInstEjjPNS_4TypeE")
//</editor-fold>
public static Constant /*P*/ getMaskElt(ShuffleVectorInst /*P*/ SVI, /*uint*/int Idx, 
          /*uint*/int Off, org.llvm.ir.Type /*P*/ I32Ty) {
  int MV = SVI.getMaskValue(Idx);
  if (MV == -1) {
    return UndefValue.get(I32Ty);
  }
  return ConstantInt.get(I32Ty, $uint2ulong(Off + MV));
}

//<editor-fold defaultstate="collapsed" desc="getAsInt32">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 1157,
 FQN="getAsInt32", NM="_ZL10getAsInt32PN4llvm11ConstantIntEPNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZL10getAsInt32PN4llvm11ConstantIntEPNS_4TypeE")
//</editor-fold>
public static Constant /*P*/ getAsInt32(ConstantInt /*P*/ C, org.llvm.ir.Type /*P*/ I32Ty) {
  if (C.getBitWidth() != 32) {
    assert (ConstantInt.isValueValidForType_Type$P_ulong(I32Ty, C.getZExtValue())) : "Index operand too large for shufflevector mask!";
    return ConstantInt.get(I32Ty, C.getZExtValue());
  }
  return C;
}


//===----------------------------------------------------------------------===//
//                             Unary Operators
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="createBinOpInfoFromIncDec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 1595,
 FQN="createBinOpInfoFromIncDec", NM="_ZL25createBinOpInfoFromIncDecPKN5clang13UnaryOperatorEPN4llvm5ValueEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZL25createBinOpInfoFromIncDecPKN5clang13UnaryOperatorEPN4llvm5ValueEb")
//</editor-fold>
public static BinOpInfo createBinOpInfoFromIncDec(/*const*/ UnaryOperator /*P*/ E, 
                         Value /*P*/ InVal, boolean IsInc) {
  BinOpInfo BinOp/*J*/= new BinOpInfo();
  BinOp.LHS = InVal;
  BinOp.RHS = ConstantInt.get(InVal.getType(), $int2ulong(1), false);
  BinOp.Ty.$assignMove(E.getType());
  BinOp.Opcode = IsInc ? BinaryOperatorKind.BO_Add : BinaryOperatorKind.BO_Sub;
  BinOp.FPContractable = false;
  BinOp.E = E;
  return BinOp;
}


/// Emit pointer + index arithmetic.
//<editor-fold defaultstate="collapsed" desc="emitPointerArithmetic">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 2413,
 FQN="emitPointerArithmetic", NM="_ZL21emitPointerArithmeticRN5clang7CodeGen15CodeGenFunctionERKN12_GLOBAL__N_19BinOpInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZL21emitPointerArithmeticRN5clang7CodeGen15CodeGenFunctionERKN12_GLOBAL__N_19BinOpInfoEb")
//</editor-fold>
public static Value /*P*/ emitPointerArithmetic(final CodeGenFunction /*&*/ CGF, 
                     final /*const*/ BinOpInfo /*&*/ op, 
                     boolean isSubtraction) {
  // Must have binary (not unary) expr here.  Unary pointer
  // increment/decrement doesn't use this path.
  /*const*/ org.clang.ast.BinaryOperator /*P*/ expr = cast_BinaryOperator(op.E);
  
  type$ref<Value /*P*/ > pointer = create_type$ref(op.LHS);
  type$ref<Expr /*P*/ > pointerOperand = create_type$ref(expr.getLHS());
  type$ref<Value /*P*/ > index = create_type$ref(op.RHS);
  type$ref<Expr /*P*/ > indexOperand = create_type$ref(expr.getRHS());
  
  // In a subtraction, the LHS is always the pointer.
  if (!isSubtraction && !pointer.$deref().getType().isPointerTy()) {
    std.swap(pointer, index);
    std.swap(pointerOperand, indexOperand);
  }
  
  /*uint*/int width = cast_IntegerType(index.$deref().getType()).getBitWidth();
  if (width != $uchar2uint(CGF.PointerWidthInBits)) {
    // Zero-extend or sign-extend the pointer value according to
    // whether the index is signed or not.
    boolean isSigned = indexOperand.$deref().getType().$arrow().isSignedIntegerOrEnumerationType();
    index.$set(CGF.Builder.CreateIntCast(index.$deref(), CGF.Unnamed_field8.PtrDiffTy, isSigned, 
        new Twine(/*KEEP_STR*/"idx.ext")));
  }
  
  // If this is subtraction, negate the index.
  if (isSubtraction) {
    index.$set(CGF.Builder.CreateNeg(index.$deref(), new Twine(/*KEEP_STR*/"idx.neg")));
  }
  if (CGF.SanOpts.has(SanitizerKind.ArrayBounds)) {
    CGF.EmitBoundsCheck(op.E, pointerOperand.$deref(), index.$deref(), indexOperand.$deref().getType(), 
        /*Accessed*/ false);
  }
  
  /*const*/ org.clang.ast.PointerType /*P*/ pointerType = pointerOperand.$deref().getType().$arrow().getAs(org.clang.ast.PointerType.class);
  if (!(pointerType != null)) {
    QualType objectType = pointerOperand.$deref().getType().$arrow().castAs(ObjCObjectPointerType.class).
        getPointeeType();
    Value /*P*/ objectSize = CGF.CGM.getSize(CGF.getContext().getTypeSizeInChars(/*NO_COPY*/objectType));
    
    index.$set(CGF.Builder.CreateMul(index.$deref(), objectSize));
    
    Value /*P*/ result = CGF.Builder.CreateBitCast(pointer.$deref(), CGF.Unnamed_field9.VoidPtrTy);
    result = CGF.Builder.CreateGEP(result, index.$deref(), new Twine(/*KEEP_STR*/"add.ptr"));
    return CGF.Builder.CreateBitCast(result, pointer.$deref().getType());
  }
  
  QualType elementType = pointerType.getPointeeType();
  {
    /*const*/ VariableArrayType /*P*/ vla = CGF.getContext().getAsVariableArrayType(new QualType(elementType));
    if ((vla != null)) {
      // The element count here is the total number of non-VLA elements.
      Value /*P*/ numElements = CGF.getVLASize(vla).first;
      
      // Effectively, the multiply by the VLA size is part of the GEP.
      // GEP indexes are signed, and scaling an index isn't permitted to
      // signed-overflow, so we use the same semantics for our explicit
      // multiply.  We suppress this if overflow is not undefined behavior.
      if (CGF.getLangOpts().isSignedOverflowDefined()) {
        index.$set(CGF.Builder.CreateMul(index.$deref(), numElements, new Twine(/*KEEP_STR*/"vla.index")));
        pointer.$set(CGF.Builder.CreateGEP(pointer.$deref(), index.$deref(), new Twine(/*KEEP_STR*/"add.ptr")));
      } else {
        index.$set(CGF.Builder.CreateNSWMul(index.$deref(), numElements, new Twine(/*KEEP_STR*/"vla.index")));
        pointer.$set(CGF.Builder.CreateInBoundsGEP(pointer.$deref(), new ArrayRef<Value /*P*/ >(index.$deref(), true), new Twine(/*KEEP_STR*/"add.ptr")));
      }
      return pointer.$deref();
    }
  }
  
  // Explicitly handle GNU void* and function pointer arithmetic extensions. The
  // GNU void* casts amount to no-ops since our void* type is i8*, but this is
  // future proof.
  if (elementType.$arrow().isVoidType() || elementType.$arrow().isFunctionType()) {
    Value /*P*/ result = CGF.Builder.CreateBitCast(pointer.$deref(), CGF.Unnamed_field9.VoidPtrTy);
    result = CGF.Builder.CreateGEP(result, index.$deref(), new Twine(/*KEEP_STR*/"add.ptr"));
    return CGF.Builder.CreateBitCast(result, pointer.$deref().getType());
  }
  if (CGF.getLangOpts().isSignedOverflowDefined()) {
    return CGF.Builder.CreateGEP(pointer.$deref(), index.$deref(), new Twine(/*KEEP_STR*/"add.ptr"));
  }
  
  return CGF.Builder.CreateInBoundsGEP(pointer.$deref(), new ArrayRef<Value /*P*/ >(index.$deref(), true), new Twine(/*KEEP_STR*/"add.ptr"));
}


// Construct an fmuladd intrinsic to represent a fused mul-add of MulOp and
// Addend. Use negMul and negAdd to negate the first operand of the Mul or
// the add operand respectively. This allows fmuladd to represent a*b-c, or
// c-a*b. Patterns in LLVM should catch the negated forms and translate them to
// efficient operations.
//<editor-fold defaultstate="collapsed" desc="buildFMulAdd">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 2504,
 FQN="buildFMulAdd", NM="_ZL12buildFMulAddPN4llvm14BinaryOperatorEPNS_5ValueERKN5clang7CodeGen15CodeGenFunctionERNS5_11CGBuilderTyEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZL12buildFMulAddPN4llvm14BinaryOperatorEPNS_5ValueERKN5clang7CodeGen15CodeGenFunctionERNS5_11CGBuilderTyEbb")
//</editor-fold>
public static Value /*P*/ buildFMulAdd(org.llvm.ir.BinaryOperator /*P*/ MulOp, Value /*P*/ Addend, 
            final /*const*/ CodeGenFunction /*&*/ CGF, final CGBuilderTy /*&*/ Builder, 
            boolean negMul, boolean negAdd) {
  assert (!(negMul && negAdd)) : "Only one of negMul and negAdd should be set.";
  
  Value /*P*/ MulOp0 = MulOp.getOperand(0);
  Value /*P*/ MulOp1 = MulOp.getOperand(1);
  if (negMul) {
    MulOp0
       = Builder.CreateFSub(ConstantFP.getZeroValueForNegation(MulOp0.getType()), MulOp0, 
        new Twine(/*KEEP_STR*/"neg"));
  } else if (negAdd) {
    Addend
       = Builder.CreateFSub(ConstantFP.getZeroValueForNegation(Addend.getType()), Addend, 
        new Twine(/*KEEP_STR*/"neg"));
  }
  
  Value /*P*/ FMulAdd = Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(CGF.CGM.getIntrinsic(ID.fmuladd, new ArrayRef<org.llvm.ir.Type /*P*/ >(Addend.getType(), true)), 
      /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {MulOp0, MulOp1, Addend}, true)/* }*/);
  MulOp.eraseFromParent();
  
  return FMulAdd;
}


// Check whether it would be legal to emit an fmuladd intrinsic call to
// represent op and if so, build the fmuladd.
//
// Checks that (a) the operation is fusable, and (b) -ffp-contract=on.
// Does NOT check the type of the operation - it's assumed that this function
// will be called from contexts where it's known that the type is contractable.
//<editor-fold defaultstate="collapsed" desc="tryEmitFMulAdd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 2537,
 FQN="tryEmitFMulAdd", NM="_ZL14tryEmitFMulAddRKN12_GLOBAL__N_19BinOpInfoERKN5clang7CodeGen15CodeGenFunctionERNS4_11CGBuilderTyEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZL14tryEmitFMulAddRKN12_GLOBAL__N_19BinOpInfoERKN5clang7CodeGen15CodeGenFunctionERNS4_11CGBuilderTyEb")
//</editor-fold>
public static Value /*P*/ tryEmitFMulAdd(final /*const*/ BinOpInfo /*&*/ op, 
              final /*const*/ CodeGenFunction /*&*/ CGF, final CGBuilderTy /*&*/ Builder) {
  return tryEmitFMulAdd(op, 
              CGF, Builder, 
              false);
}
public static Value /*P*/ tryEmitFMulAdd(final /*const*/ BinOpInfo /*&*/ op, 
              final /*const*/ CodeGenFunction /*&*/ CGF, final CGBuilderTy /*&*/ Builder, 
              boolean isSub/*= false*/) {
  assert ((op.Opcode == BinaryOperatorKind.BO_Add || op.Opcode == BinaryOperatorKind.BO_AddAssign || op.Opcode == BinaryOperatorKind.BO_Sub || op.Opcode == BinaryOperatorKind.BO_SubAssign)) : "Only fadd/fsub can be the root of an fmuladd.";
  
  // Check whether this op is marked as fusable.
  if (!op.FPContractable) {
    return null;
  }
  
  // Check whether -ffp-contract=on. (If -ffp-contract=off/fast, fusing is
  // either disabled, or handled entirely by the LLVM backend).
  if (CGF.CGM.getCodeGenOpts().getFPContractMode() != CodeGenOptions.FPContractModeKind.FPC_On) {
    return null;
  }
  {
    
    // We have a potentially fusable op. Look for a mul on one of the operands.
    // Also, make sure that the mul result isn't used directly. In that case,
    // there's no point creating a muladd operation.
    org.llvm.ir.BinaryOperator /*P*/ LHSBinOp = dyn_cast_BinaryOperator(op.LHS);
    if ((LHSBinOp != null)) {
      if (LHSBinOp.getOpcode() == Instruction.BinaryOps.FMul
         && LHSBinOp.use_empty()) {
        return buildFMulAdd(LHSBinOp, op.RHS, CGF, Builder, false, isSub);
      }
    }
  }
  {
    org.llvm.ir.BinaryOperator /*P*/ RHSBinOp = dyn_cast_BinaryOperator(op.RHS);
    if ((RHSBinOp != null)) {
      if (RHSBinOp.getOpcode() == Instruction.BinaryOps.FMul
         && RHSBinOp.use_empty()) {
        return buildFMulAdd(RHSBinOp, op.LHS, CGF, Builder, isSub, false);
      }
    }
  }
  
  return null;
}

// return corresponding comparison intrinsic for given vector type
//<editor-fold defaultstate="collapsed" desc="GetIntrinsic">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 2792,
 FQN="GetIntrinsic", NM="_ZL12GetIntrinsic13IntrinsicTypeN5clang11BuiltinType4KindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZL12GetIntrinsic13IntrinsicTypeN5clang11BuiltinType4KindE")
//</editor-fold>
public static /*ID*/int GetIntrinsic(IntrinsicType IT, 
            BuiltinType.Kind ElemKind) {
  switch (ElemKind) {
   default:
    throw new llvm_unreachable("unexpected element type");
   case Char_U:
   case UChar:
    return (IT == IntrinsicType.VCMPEQ) ? ID.ppc_altivec_vcmpequb_p : ID.ppc_altivec_vcmpgtub_p;
   case Char_S:
   case SChar:
    return (IT == IntrinsicType.VCMPEQ) ? ID.ppc_altivec_vcmpequb_p : ID.ppc_altivec_vcmpgtsb_p;
   case UShort:
    return (IT == IntrinsicType.VCMPEQ) ? ID.ppc_altivec_vcmpequh_p : ID.ppc_altivec_vcmpgtuh_p;
   case Short:
    return (IT == IntrinsicType.VCMPEQ) ? ID.ppc_altivec_vcmpequh_p : ID.ppc_altivec_vcmpgtsh_p;
   case UInt:
   case ULong:
    return (IT == IntrinsicType.VCMPEQ) ? ID.ppc_altivec_vcmpequw_p : ID.ppc_altivec_vcmpgtuw_p;
   case Int:
   case Long:
    return (IT == IntrinsicType.VCMPEQ) ? ID.ppc_altivec_vcmpequw_p : ID.ppc_altivec_vcmpgtsw_p;
   case Float:
    return (IT == IntrinsicType.VCMPEQ) ? ID.ppc_altivec_vcmpeqfp_p : ID.ppc_altivec_vcmpgtfp_p;
  }
}


//===----------------------------------------------------------------------===//
//                             Other Operators
//===----------------------------------------------------------------------===//

/// isCheapEnoughToEvaluateUnconditionally - Return true if the specified
/// expression is cheap enough and side-effect-free enough to evaluate
/// unconditionally instead of conditionally.  This is used to convert control
/// flow into selects in some cases.
//<editor-fold defaultstate="collapsed" desc="isCheapEnoughToEvaluateUnconditionally">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 3199,
 FQN="isCheapEnoughToEvaluateUnconditionally", NM="_ZL38isCheapEnoughToEvaluateUnconditionallyPKN5clang4ExprERNS_7CodeGen15CodeGenFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZL38isCheapEnoughToEvaluateUnconditionallyPKN5clang4ExprERNS_7CodeGen15CodeGenFunctionE")
//</editor-fold>
public static boolean isCheapEnoughToEvaluateUnconditionally(/*const*/ Expr /*P*/ E, 
                                      final CodeGenFunction /*&*/ CGF) {
  // Anything that is an integer or floating point constant is fine.
  return E.IgnoreParens$Const().isEvaluatable(CGF.getContext());
  // Even non-volatile automatic variables can't be evaluated unconditionally.
  // Referencing a thread_local may cause non-trivial initialization work to
  // occur. If we're inside a lambda and one of the variables is from the scope
  // outside the lambda, that function may have returned already. Reading its
  // locals is a bad idea. Also, these reads may introduce races there didn't
  // exist in the source-level program.
}


// Convert a vec3 to vec4, or vice versa.
//<editor-fold defaultstate="collapsed" desc="ConvertVec3AndVec4">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 3387,
 FQN="ConvertVec3AndVec4", NM="_ZL18ConvertVec3AndVec4RN5clang7CodeGen11CGBuilderTyERNS0_15CodeGenFunctionEPN4llvm5ValueEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZL18ConvertVec3AndVec4RN5clang7CodeGen11CGBuilderTyERNS0_15CodeGenFunctionEPN4llvm5ValueEj")
//</editor-fold>
public static Value /*P*/ ConvertVec3AndVec4(final CGBuilderTy /*&*/ Builder, final CodeGenFunction /*&*/ CGF, 
                  Value /*P*/ Src, /*uint*/int NumElementsDst) {
  Value /*P*/ UnV = UndefValue.get(Src.getType());
  SmallVector<Constant /*P*/ > Args/*J*/= new SmallVector<Constant /*P*/ >(4, (Constant /*P*/ )null);
  Args.push_back(Builder.getInt32(0));
  Args.push_back(Builder.getInt32(1));
  Args.push_back(Builder.getInt32(2));
  if (NumElementsDst == 4) {
    Args.push_back(UndefValue.get(CGF.Int32Ty));
  }
  Constant /*P*/ Mask = ConstantVector.get(new ArrayRef<Constant /*P*/ >(Args, true));
  return Builder.CreateShuffleVector(Src, UnV, Mask);
}

} // END OF class CGExprScalarStatics
