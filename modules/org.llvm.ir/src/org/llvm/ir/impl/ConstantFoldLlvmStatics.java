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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.ir.patternmatch.PatternMatchGlobals;


//<editor-fold defaultstate="collapsed" desc="static type ConstantFoldLlvmStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.ConstantFoldLlvmStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZN4llvm25ConstantFoldGetElementPtrEPNS_4TypeEPNS_8ConstantEbNS_8ArrayRefIPNS_5ValueEEE;_ZN4llvm25ConstantFoldGetElementPtrEPNS_4TypeEPNS_8ConstantEbNS_8ArrayRefIS3_EE;_ZN4llvm27ConstantFoldCastInstructionEjPNS_8ConstantEPNS_4TypeE;_ZN4llvm29ConstantFoldBinaryInstructionEjPNS_8ConstantES1_;_ZN4llvm29ConstantFoldSelectInstructionEPNS_8ConstantES1_S1_;_ZN4llvm30ConstantFoldCompareInstructionEtPNS_8ConstantES1_;_ZN4llvm34ConstantFoldInsertValueInstructionEPNS_8ConstantES1_NS_8ArrayRefIjEE;_ZN4llvm35ConstantFoldExtractValueInstructionEPNS_8ConstantENS_8ArrayRefIjEE;_ZN4llvm36ConstantFoldInsertElementInstructionEPNS_8ConstantES1_S1_;_ZN4llvm36ConstantFoldShuffleVectorInstructionEPNS_8ConstantES1_S1_;_ZN4llvm37ConstantFoldExtractElementInstructionEPNS_8ConstantES1_; -static-type=ConstantFoldLlvmStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class ConstantFoldLlvmStatics {


// Constant fold various types of instruction...
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldCastInstruction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 522,
 FQN="llvm::ConstantFoldCastInstruction", NM="_ZN4llvm27ConstantFoldCastInstructionEjPNS_8ConstantEPNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZN4llvm27ConstantFoldCastInstructionEjPNS_8ConstantEPNS_4TypeE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldCastInstruction(/*uint*/int opc, Constant /*P*/ V, 
                           Type /*P*/ DestTy) {
  if (isa_UndefValue(V)) {
    // zext(undef) = 0, because the top bits will be zero.
    // sext(undef) = 0, because the top bits will all be the same.
    // [us]itofp(undef) = 0, because the result value is bounded.
    if (opc == Instruction.CastOps.ZExt || opc == Instruction.CastOps.SExt
       || opc == Instruction.CastOps.UIToFP || opc == Instruction.CastOps.SIToFP) {
      return Constant.getNullValue(DestTy);
    }
    return UndefValue.get(DestTy);
  }
  if (V.isNullValue() && !DestTy.isX86_MMXTy()
     && opc != Instruction.CastOps.AddrSpaceCast) {
    return Constant.getNullValue(DestTy);
  }
  {
    
    // If the cast operand is a constant expression, there's a few things we can
    // do to try to simplify it.
    ConstantExpr /*P*/ CE = dyn_cast_ConstantExpr(V);
    if ((CE != null)) {
      if (CE.isCast()) {
        {
          // Try hard to fold cast of cast because they are often eliminable.
          /*uint*/int newOpc = ConstantFoldStatics.foldConstantCastPair(opc, CE, DestTy);
          if ((newOpc != 0)) {
            return ConstantExpr.getCast(newOpc, CE.getOperand_Constant(0), DestTy);
          }
        }
      } else if (CE.getOpcode() == Instruction.MemoryOps.GetElementPtr
        // Do not fold addrspacecast (gep 0, .., 0). It might make the
        // addrspacecast uncanonicalized.
         && opc != Instruction.CastOps.AddrSpaceCast) {
        // If all of the indexes in the GEP are null values, there is no pointer
        // adjustment going on.  We might as well cast the source pointer.
        boolean isAllNull = true;
        for (/*uint*/int i = 1, e = CE.getNumOperands(); i != e; ++i)  {
          if (!CE.getOperand_Constant(i).isNullValue()) {
            isAllNull = false;
            break;
          }
        }
        if (isAllNull) {
          // This is casting one pointer type to another, always BitCast
          return ConstantExpr.getPointerCast(CE.getOperand_Constant(0), DestTy);
        }
      }
    }
  }
  
  // If the cast operand is a constant vector, perform the cast by
  // operating on each element. In the cast of bitcasts, the element
  // count may be mismatched; don't attempt to handle that here.
  if ((isa_ConstantVector(V) || isa_ConstantDataVector(V))
     && DestTy.isVectorTy()
     && DestTy.getVectorNumElements() == V.getType().getVectorNumElements()) {
    SmallVector<Constant /*P*/ > res/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
    VectorType /*P*/ DestVecTy = cast_VectorType(DestTy);
    Type /*P*/ DstEltTy = DestVecTy.getElementType();
    Type /*P*/ Ty = IntegerType.get(V.getContext(), 32);
    for (/*uint*/int i = 0, e = V.getType().getVectorNumElements(); i != e; ++i) {
      Constant /*P*/ C = ConstantExpr.getExtractElement(V, ConstantInt.get(Ty, $uint2ulong(i)));
      res.push_back(ConstantExpr.getCast(opc, C, DstEltTy));
    }
    return ConstantVector.get(new ArrayRef<Constant /*P*/ >(res, true));
  }
  
  // We actually have to do a cast now. Perform the cast according to the
  // opcode specified.
  switch (opc) {
   default:
    throw new llvm_unreachable("Failed to cast constant expression");
   case Instruction.CastOps.FPTrunc:
   case Instruction.CastOps.FPExt:
    {
      ConstantFP /*P*/ FPC = dyn_cast_ConstantFP(V);
      if ((FPC != null)) {
        bool$ptr ignored = create_bool$ptr();
        APFloat Val = new APFloat(FPC.getValueAPF());
        Val.convert(DestTy.isHalfTy() ? APFloat.IEEEhalf : DestTy.isFloatTy() ? APFloat.IEEEsingle : DestTy.isDoubleTy() ? APFloat.IEEEdouble : DestTy.isX86_FP80Ty() ? APFloat.x87DoubleExtended : DestTy.isFP128Ty() ? APFloat.IEEEquad : DestTy.isPPC_FP128Ty() ? APFloat.PPCDoubleDouble : APFloat.Bogus, 
            APFloat.roundingMode.rmNearestTiesToEven, $AddrOf(ignored));
        return ConstantFP.get(V.getContext(), Val);
      }
    }
    return null; // Can't fold.
   case Instruction.CastOps.FPToUI:
   case Instruction.CastOps.FPToSI:
    {
      ConstantFP /*P*/ FPC = dyn_cast_ConstantFP(V);
      if ((FPC != null)) {
        final /*const*/ APFloat /*&*/ V$1 = FPC.getValueAPF();
        bool$ptr ignored = create_bool$ptr();
        long/*uint64_t*/ x[/*2*/] = new$ulong(2);
        /*uint32_t*/int DestBitWidth = cast_IntegerType(DestTy).getBitWidth();
        if (APFloat.opStatus.opInvalidOp
           == V$1.convertToInteger(create_ulong$ptr(x), DestBitWidth, opc == Instruction.CastOps.FPToSI, 
            APFloat.roundingMode.rmTowardZero, $AddrOf(ignored))) {
          // Undefined behavior invoked - the destination type can't represent
          // the input constant.
          return UndefValue.get(DestTy);
        }
        APInt Val/*J*/= new APInt(DestBitWidth, new ArrayRefULong(x));
        return ConstantInt.get(FPC.getContext(), Val);
      }
    }
    return null; // Can't fold.
   case Instruction.CastOps.IntToPtr: //always treated as unsigned
    if (V.isNullValue()) { // Is it an integral null value?
      return ConstantPointerNull.get(cast_PointerType(DestTy));
    }
    return null; // Other pointer types cannot be casted
   case Instruction.CastOps.PtrToInt: // always treated as unsigned
    // Is it a null pointer value?
    if (V.isNullValue()) {
      return ConstantInt.get(DestTy, $int2ulong(0));
    }
    {
      // If this is a sizeof-like expression, pull out multiplications by
      // known factors to expose them to subsequent folding. If it's an
      // alignof-like expression, factor out known factors.
      ConstantExpr /*P*/ CE = dyn_cast_ConstantExpr(V);
      if ((CE != null)) {
        if (CE.getOpcode() == Instruction.MemoryOps.GetElementPtr
           && CE.getOperand_Constant(0).isNullValue()) {
          GEPOperator /*P*/ GEPO = cast_GEPOperator(CE);
          Type /*P*/ Ty = GEPO.getSourceElementType();
          if (CE.getNumOperands() == 2) {
            // Handle a sizeof-like expression.
            Constant /*P*/ Idx = CE.getOperand_Constant(1);
            boolean isOne = isa_ConstantInt(Idx) && cast_ConstantInt(Idx).isOne();
            {
              Constant /*P*/ C = ConstantFoldStatics.getFoldedSizeOf(Ty, DestTy, !isOne);
              if ((C != null)) {
                Idx = ConstantExpr.getCast(CastInst.getCastOpcode(Idx, true, 
                        DestTy, false), 
                    Idx, DestTy);
                return ConstantExpr.getMul(C, Idx);
              }
            }
          } else if (CE.getNumOperands() == 3
             && CE.getOperand_Constant(1).isNullValue()) {
            {
              // Handle an alignof-like expression.
              StructType /*P*/ STy = dyn_cast_StructType(Ty);
              if ((STy != null)) {
                if (!STy.isPacked()) {
                  ConstantInt /*P*/ CI = cast_ConstantInt(CE.getOperand_Constant(2));
                  if (CI.isOne()
                     && STy.getNumElements() == 2
                     && STy.getElementType(0).isIntegerTy(1)) {
                    return ConstantFoldStatics.getFoldedAlignOf(STy.getElementType(1), DestTy, false);
                  }
                }
              }
            }
            // Handle an offsetof-like expression.
            if (Ty.isStructTy() || Ty.isArrayTy()) {
              {
                Constant /*P*/ C = ConstantFoldStatics.getFoldedOffsetOf(Ty, CE.getOperand_Constant(2), 
                    DestTy, false);
                if ((C != null)) {
                  return C;
                }
              }
            }
          }
        }
      }
    }
    // Other pointer types cannot be casted
    return null;
   case Instruction.CastOps.UIToFP:
   case Instruction.CastOps.SIToFP:
    {
      ConstantInt /*P*/ CI = dyn_cast_ConstantInt(V);
      if ((CI != null)) {
        final /*const*/ APInt /*&*/ api = CI.getValue();
        APFloat apf/*J*/= new APFloat(DestTy.getFltSemantics(), 
            APInt.getNullValue(DestTy.getPrimitiveSizeInBits()));
        if (((APFloat.opStatus.opOverflow
           & apf.convertFromAPInt(api, opc == Instruction.CastOps.SIToFP, 
            APFloat.roundingMode.rmNearestTiesToEven)) != 0)) {
          // Undefined behavior invoked - the destination type can't represent
          // the input constant.
          return UndefValue.get(DestTy);
        }
        return ConstantFP.get(V.getContext(), apf);
      }
    }
    return null;
   case Instruction.CastOps.ZExt:
    {
      ConstantInt /*P*/ CI = dyn_cast_ConstantInt(V);
      if ((CI != null)) {
        /*uint32_t*/int BitWidth = cast_IntegerType(DestTy).getBitWidth();
        return ConstantInt.get(V.getContext(), 
            CI.getValue().zext(BitWidth));
      }
    }
    return null;
   case Instruction.CastOps.SExt:
    {
      ConstantInt /*P*/ CI = dyn_cast_ConstantInt(V);
      if ((CI != null)) {
        /*uint32_t*/int BitWidth = cast_IntegerType(DestTy).getBitWidth();
        return ConstantInt.get(V.getContext(), 
            CI.getValue().sext(BitWidth));
      }
    }
    return null;
   case Instruction.CastOps.Trunc:
    {
      if (V.getType().isVectorTy()) {
        return null;
      }
      
      /*uint32_t*/int DestBitWidth = cast_IntegerType(DestTy).getBitWidth();
      {
        ConstantInt /*P*/ CI = dyn_cast_ConstantInt(V);
        if ((CI != null)) {
          return ConstantInt.get(V.getContext(), 
              CI.getValue().trunc(DestBitWidth));
        }
      }
      
      // The input must be a constantexpr.  See if we can simplify this based on
      // the bytes we are demanding.  Only do this if the source and dest are an
      // even multiple of a byte.
      if ((DestBitWidth & 7) == 0
         && (cast_IntegerType(V.getType()).getBitWidth() & 7) == 0) {
        {
          Constant /*P*/ Res = ConstantFoldStatics.ExtractConstantBytes(V, 0, $div_uint(DestBitWidth, 8));
          if ((Res != null)) {
            return Res;
          }
        }
      }
      
      return null;
    }
   case Instruction.CastOps.BitCast:
    return ConstantFoldStatics.FoldBitCast(V, DestTy);
   case Instruction.CastOps.AddrSpaceCast:
    return null;
  }
}

//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldSelectInstruction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 725,
 FQN="llvm::ConstantFoldSelectInstruction", NM="_ZN4llvm29ConstantFoldSelectInstructionEPNS_8ConstantES1_S1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZN4llvm29ConstantFoldSelectInstructionEPNS_8ConstantES1_S1_")
//</editor-fold>
public static Constant /*P*/ ConstantFoldSelectInstruction(Constant /*P*/ Cond, 
                             Constant /*P*/ V1, Constant /*P*/ V2) {
  // Check for i1 and vector true/false conditions.
  if (Cond.isNullValue()) {
    return V2;
  }
  if (Cond.isAllOnesValue()) {
    return V1;
  }
  {
    
    // If the condition is a vector constant, fold the result elementwise.
    ConstantVector /*P*/ CondV = dyn_cast_ConstantVector(Cond);
    if ((CondV != null)) {
      SmallVector<Constant /*P*/ > Result/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
      Type /*P*/ Ty = IntegerType.get(CondV.getContext(), 32);
      for (/*uint*/int i = 0, e = V1.getType().getVectorNumElements(); i != e; ++i) {
        Constant /*P*/ V;
        Constant /*P*/ V1Element = ConstantExpr.getExtractElement(V1, 
            ConstantInt.get(Ty, $uint2ulong(i)));
        Constant /*P*/ V2Element = ConstantExpr.getExtractElement(V2, 
            ConstantInt.get(Ty, $uint2ulong(i)));
        Constant /*P*/ Cond$1 = dyn_cast_Constant(CondV.getOperand(i));
        if (V1Element == V2Element) {
          V = V1Element;
        } else if (isa_UndefValue(Cond$1)) {
          V = isa_UndefValue(V1Element) ? V1Element : V2Element;
        } else {
          if (!isa_ConstantInt(Cond$1)) {
            break;
          }
          V = Cond$1.isNullValue() ? V2Element : V1Element;
        }
        Result.push_back(V);
      }
      
      // If we were able to build the vector, return it.
      if (Result.size() == V1.getType().getVectorNumElements()) {
        return ConstantVector.get(new ArrayRef<Constant /*P*/ >(Result, true));
      }
    }
  }
  if (isa_UndefValue(Cond)) {
    if (isa_UndefValue(V1)) {
      return V1;
    }
    return V2;
  }
  if (isa_UndefValue(V1)) {
    return V2;
  }
  if (isa_UndefValue(V2)) {
    return V1;
  }
  if (V1 == V2) {
    return V1;
  }
  {
    
    ConstantExpr /*P*/ TrueVal = dyn_cast_ConstantExpr(V1);
    if ((TrueVal != null)) {
      if (TrueVal.getOpcode() == Instruction.OtherOps.Select) {
        if (TrueVal.getOperand_Constant(0) == Cond) {
          return ConstantExpr.getSelect(Cond, TrueVal.getOperand_Constant(1), V2);
        }
      }
    }
  }
  {
    ConstantExpr /*P*/ FalseVal = dyn_cast_ConstantExpr(V2);
    if ((FalseVal != null)) {
      if (FalseVal.getOpcode() == Instruction.OtherOps.Select) {
        if (FalseVal.getOperand_Constant(0) == Cond) {
          return ConstantExpr.getSelect(Cond, V1, FalseVal.getOperand_Constant(2));
        }
      }
    }
  }
  
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldExtractElementInstruction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 780,
 FQN="llvm::ConstantFoldExtractElementInstruction", NM="_ZN4llvm37ConstantFoldExtractElementInstructionEPNS_8ConstantES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZN4llvm37ConstantFoldExtractElementInstructionEPNS_8ConstantES1_")
//</editor-fold>
public static Constant /*P*/ ConstantFoldExtractElementInstruction(Constant /*P*/ Val, 
                                     Constant /*P*/ Idx) {
  if (isa_UndefValue(Val)) { // ee(undef, x) -> undef
    return UndefValue.get(Val.getType().getVectorElementType());
  }
  if (Val.isNullValue()) { // ee(zero, x) -> zero
    return Constant.getNullValue(Val.getType().getVectorElementType());
  }
  // ee({w,x,y,z}, undef) -> undef
  if (isa_UndefValue(Idx)) {
    return UndefValue.get(Val.getType().getVectorElementType());
  }
  {
    
    ConstantInt /*P*/ CIdx = dyn_cast_ConstantInt(Idx);
    if ((CIdx != null)) {
      // ee({w,x,y,z}, wrong_value) -> undef
      if (CIdx.uge($uint2ulong(Val.getType().getVectorNumElements()))) {
        return UndefValue.get(Val.getType().getVectorElementType());
      }
      return Val.getAggregateElement($ulong2uint(CIdx.getZExtValue()));
    }
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldInsertElementInstruction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 799,
 FQN="llvm::ConstantFoldInsertElementInstruction", NM="_ZN4llvm36ConstantFoldInsertElementInstructionEPNS_8ConstantES1_S1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZN4llvm36ConstantFoldInsertElementInstructionEPNS_8ConstantES1_S1_")
//</editor-fold>
public static Constant /*P*/ ConstantFoldInsertElementInstruction(Constant /*P*/ Val, 
                                    Constant /*P*/ Elt, 
                                    Constant /*P*/ Idx) {
  if (isa_UndefValue(Idx)) {
    return UndefValue.get(Val.getType());
  }
  
  ConstantInt /*P*/ CIdx = dyn_cast_ConstantInt(Idx);
  if (!(CIdx != null)) {
    return null;
  }
  
  /*uint*/int NumElts = Val.getType().getVectorNumElements();
  if (CIdx.uge($uint2ulong(NumElts))) {
    return UndefValue.get(Val.getType());
  }
  
  SmallVector<Constant /*P*/ > Result/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
  Result.reserve(NumElts);
  IntegerType /*P*/ Ty = Type.getInt32Ty(Val.getContext());
  long/*uint64_t*/ IdxVal = CIdx.getZExtValue();
  for (/*uint*/int i = 0; i != NumElts; ++i) {
    if ($uint2ullong(i) == IdxVal) {
      Result.push_back(Elt);
      continue;
    }
    
    Constant /*P*/ C = ConstantExpr.getExtractElement(Val, ConstantInt.get(Ty, $uint2ulong(i)));
    Result.push_back(C);
  }
  
  return ConstantVector.get(new ArrayRef<Constant /*P*/ >(Result, true));
}

//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldShuffleVectorInstruction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 829,
 FQN="llvm::ConstantFoldShuffleVectorInstruction", NM="_ZN4llvm36ConstantFoldShuffleVectorInstructionEPNS_8ConstantES1_S1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZN4llvm36ConstantFoldShuffleVectorInstructionEPNS_8ConstantES1_S1_")
//</editor-fold>
public static Constant /*P*/ ConstantFoldShuffleVectorInstruction(Constant /*P*/ V1, 
                                    Constant /*P*/ V2, 
                                    Constant /*P*/ Mask) {
  /*uint*/int MaskNumElts = Mask.getType().getVectorNumElements();
  Type /*P*/ EltTy = V1.getType().getVectorElementType();
  
  // Undefined shuffle mask -> undefined value.
  if (isa_UndefValue(Mask)) {
    return UndefValue.get(VectorType.get(EltTy, MaskNumElts));
  }
  
  // Don't break the bitcode reader hack.
  if (isa_ConstantExpr(Mask)) {
    return null;
  }
  
  /*uint*/int SrcNumElts = V1.getType().getVectorNumElements();
  
  // Loop over the shuffle mask, evaluating each element.
  SmallVector<Constant /*P*/ > Result/*J*/= new SmallVector<Constant /*P*/ >(32, (Constant /*P*/ )null);
  for (/*uint*/int i = 0; i != MaskNumElts; ++i) {
    int Elt = ShuffleVectorInst.getMaskValue(Mask, i);
    if (Elt == -1) {
      Result.push_back(UndefValue.get(EltTy));
      continue;
    }
    Constant /*P*/ InElt;
    if ($greatereq_uint(((/*uint*/int)(Elt)), SrcNumElts * 2)) {
      InElt = UndefValue.get(EltTy);
    } else if ($greatereq_uint(((/*uint*/int)(Elt)), SrcNumElts)) {
      Type /*P*/ Ty = IntegerType.get(V2.getContext(), 32);
      InElt
         = ConstantExpr.getExtractElement(V2, 
          ConstantInt.get(Ty, $uint2ulong(Elt - SrcNumElts)));
    } else {
      Type /*P*/ Ty = IntegerType.get(V1.getContext(), 32);
      InElt = ConstantExpr.getExtractElement(V1, ConstantInt.get(Ty, $int2ulong(Elt)));
    }
    Result.push_back(InElt);
  }
  
  return ConstantVector.get(new ArrayRef<Constant /*P*/ >(Result, true));
}

//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldExtractValueInstruction">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 870,
 FQN="llvm::ConstantFoldExtractValueInstruction", NM="_ZN4llvm35ConstantFoldExtractValueInstructionEPNS_8ConstantENS_8ArrayRefIjEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZN4llvm35ConstantFoldExtractValueInstructionEPNS_8ConstantENS_8ArrayRefIjEE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldExtractValueInstruction(Constant /*P*/ Agg, 
                                   ArrayRefUInt Idxs) {
  // Base case: no indices, so return the entire value.
  if (Idxs.empty()) {
    return Agg;
  }
  {
    
    Constant /*P*/ C = Agg.getAggregateElement(Idxs.$at(0));
    if ((C != null)) {
      return ConstantFoldExtractValueInstruction(C, Idxs.slice(1));
    }
  }
  
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldInsertValueInstruction">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 882,
 FQN="llvm::ConstantFoldInsertValueInstruction", NM="_ZN4llvm34ConstantFoldInsertValueInstructionEPNS_8ConstantES1_NS_8ArrayRefIjEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZN4llvm34ConstantFoldInsertValueInstructionEPNS_8ConstantES1_NS_8ArrayRefIjEE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldInsertValueInstruction(Constant /*P*/ Agg, 
                                  Constant /*P*/ Val, 
                                  ArrayRefUInt Idxs) {
  // Base case: no indices, so replace the entire value.
  if (Idxs.empty()) {
    return Val;
  }
  
  /*uint*/int NumElts;
  {
    StructType /*P*/ ST = dyn_cast_StructType(Agg.getType());
    if ((ST != null)) {
      NumElts = ST.getNumElements();
    } else {
      ArrayType /*P*/ AT = dyn_cast_ArrayType(Agg.getType());
      if ((AT != null)) {
        NumElts = $ulong2uint(AT.getNumElements());
      } else {
        NumElts = Agg.getType().getVectorNumElements();
      }
    }
  }
  
  SmallVector<Constant /*P*/ > Result/*J*/= new SmallVector<Constant /*P*/ >(32, (Constant /*P*/ )null);
  for (/*uint*/int i = 0; i != NumElts; ++i) {
    Constant /*P*/ C = Agg.getAggregateElement(i);
    if (!(C != null)) {
      return null;
    }
    if (Idxs.$at(0) == i) {
      C = ConstantFoldInsertValueInstruction(C, Val, Idxs.slice(1));
    }
    
    Result.push_back(C);
  }
  {
    
    StructType /*P*/ ST = dyn_cast_StructType(Agg.getType());
    if ((ST != null)) {
      return ConstantStruct.get(ST, new ArrayRef<Constant /*P*/ >(Result, true));
    }
  }
  {
    ArrayType /*P*/ AT = dyn_cast_ArrayType(Agg.getType());
    if ((AT != null)) {
      return ConstantArray.get(AT, new ArrayRef<Constant /*P*/ >(Result, true));
    }
  }
  return ConstantVector.get(new ArrayRef<Constant /*P*/ >(Result, true));
}

//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldBinaryInstruction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 916,
 FQN="llvm::ConstantFoldBinaryInstruction", NM="_ZN4llvm29ConstantFoldBinaryInstructionEjPNS_8ConstantES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZN4llvm29ConstantFoldBinaryInstructionEjPNS_8ConstantES1_")
//</editor-fold>
public static Constant /*P*/ ConstantFoldBinaryInstruction(/*uint*/int Opcode, 
                             Constant /*P*/ C1, Constant /*P*/ C2) {
  assert (Instruction.isBinaryOp(Opcode)) : "Non-binary instruction detected";
  
  // Handle UndefValue up front.
  if (isa_UndefValue(C1) || isa_UndefValue(C2)) {
    switch (((/*static_cast*//*BinaryOps*/int)(Opcode))) {
     case Instruction.BinaryOps.Xor:
      if (isa_UndefValue(C1) && isa_UndefValue(C2)) {
        // Handle undef ^ undef -> 0 special case. This is a common
        // idiom (misuse).
        return Constant.getNullValue(C1.getType());
      }
     case Instruction.BinaryOps.Add:
     case Instruction.BinaryOps.Sub:
      // Fallthrough
      return UndefValue.get(C1.getType());
     case Instruction.BinaryOps.And:
      if (isa_UndefValue(C1) && isa_UndefValue(C2)) { // undef & undef -> undef
        return C1;
      }
      return Constant.getNullValue(C1.getType()); // undef & X -> 0
     case Instruction.BinaryOps.Mul:
      {
        // undef * undef -> undef
        if (isa_UndefValue(C1) && isa_UndefValue(C2)) {
          return C1;
        }
        type$ref</*const*/ APInt /*P*/ > CV = create_type$ref();
        // X * undef -> undef   if X is odd
        if (PatternMatchGlobals.match(C1, PatternMatchGlobals.m_APInt(CV)) || PatternMatchGlobals.match(C2, PatternMatchGlobals.m_APInt(CV))) {
          if (($Deref(CV.$deref())).$at(0)) {
            return UndefValue.get(C1.getType());
          }
        }
        
        // X * undef -> 0       otherwise
        return Constant.getNullValue(C1.getType());
      }
     case Instruction.BinaryOps.SDiv:
     case Instruction.BinaryOps.UDiv:
      // X / undef -> undef
      if (isa_UndefValue(C2)) {
        return C2;
      }
      // undef / 0 -> undef
      // undef / 1 -> undef
      if (PatternMatchGlobals.match(C2, PatternMatchGlobals.m_Zero()) || PatternMatchGlobals.match(C2, PatternMatchGlobals.m_One())) {
        return C1;
      }
      // undef / X -> 0       otherwise
      return Constant.getNullValue(C1.getType());
     case Instruction.BinaryOps.URem:
     case Instruction.BinaryOps.SRem:
      // X % undef -> undef
      if (PatternMatchGlobals.match(C2, PatternMatchGlobals.m_Undef())) {
        return C2;
      }
      // undef % 0 -> undef
      if (PatternMatchGlobals.match(C2, PatternMatchGlobals.m_Zero())) {
        return C1;
      }
      // undef % X -> 0       otherwise
      return Constant.getNullValue(C1.getType());
     case Instruction.BinaryOps.Or: // X | undef -> -1
      if (isa_UndefValue(C1) && isa_UndefValue(C2)) { // undef | undef -> undef
        return C1;
      }
      return Constant.getAllOnesValue(C1.getType()); // undef | X -> ~0
     case Instruction.BinaryOps.LShr:
      // X >>l undef -> undef
      if (isa_UndefValue(C2)) {
        return C2;
      }
      // undef >>l 0 -> undef
      if (PatternMatchGlobals.match(C2, PatternMatchGlobals.m_Zero())) {
        return C1;
      }
      // undef >>l X -> 0
      return Constant.getNullValue(C1.getType());
     case Instruction.BinaryOps.AShr:
      // X >>a undef -> undef
      if (isa_UndefValue(C2)) {
        return C2;
      }
      // undef >>a 0 -> undef
      if (PatternMatchGlobals.match(C2, PatternMatchGlobals.m_Zero())) {
        return C1;
      }
      // TODO: undef >>a X -> undef if the shift is exact
      // undef >>a X -> 0
      return Constant.getNullValue(C1.getType());
     case Instruction.BinaryOps.Shl:
      // X << undef -> undef
      if (isa_UndefValue(C2)) {
        return C2;
      }
      // undef << 0 -> undef
      if (PatternMatchGlobals.match(C2, PatternMatchGlobals.m_Zero())) {
        return C1;
      }
      // undef << X -> 0
      return Constant.getNullValue(C1.getType());
     case Instruction.BinaryOps.FAdd:
     case Instruction.BinaryOps.FSub:
     case Instruction.BinaryOps.FMul:
     case Instruction.BinaryOps.FDiv:
     case Instruction.BinaryOps.FRem:
      // TODO: UNDEF handling for binary float instructions.
      return null;
     case Instruction.BinaryOps.BinaryOpsEnd:
      throw new llvm_unreachable("Invalid BinaryOp");
    }
  }
  
  // At this point neither constant should be an UndefValue.
  assert (!isa_UndefValue(C1) && !isa_UndefValue(C2)) : "Unexpected UndefValue";
  {
    
    // Handle simplifications when the RHS is a constant int.
    ConstantInt /*P*/ CI2 = dyn_cast_ConstantInt(C2);
    if ((CI2 != null)) {
      switch (Opcode) {
       case Instruction.BinaryOps.Add:
        if (CI2.equalsInt($int2ulong(0))) {
          return C1; // X + 0 == X
        }
        break;
       case Instruction.BinaryOps.Sub:
        if (CI2.equalsInt($int2ulong(0))) {
          return C1; // X - 0 == X
        }
        break;
       case Instruction.BinaryOps.Mul:
        if (CI2.equalsInt($int2ulong(0))) {
          return C2; // X * 0 == 0
        }
        if (CI2.equalsInt($int2ulong(1))) {
          return C1; // X * 1 == X
        }
        break;
       case Instruction.BinaryOps.UDiv:
       case Instruction.BinaryOps.SDiv:
        if (CI2.equalsInt($int2ulong(1))) {
          return C1; // X / 1 == X
        }
        if (CI2.equalsInt($int2ulong(0))) {
          return UndefValue.get(CI2.getType()); // X / 0 == undef
        }
        break;
       case Instruction.BinaryOps.URem:
       case Instruction.BinaryOps.SRem:
        if (CI2.equalsInt($int2ulong(1))) {
          return Constant.getNullValue(CI2.getType()); // X % 1 == 0
        }
        if (CI2.equalsInt($int2ulong(0))) {
          return UndefValue.get(CI2.getType()); // X % 0 == undef
        }
        break;
       case Instruction.BinaryOps.And:
        if (CI2.isZero()) {
          return C2; // X & 0 == 0
        }
        if (CI2.isAllOnesValue()) {
          return C1; // X & -1 == X
        }
        {
          
          ConstantExpr /*P*/ CE1 = dyn_cast_ConstantExpr(C1);
          if ((CE1 != null)) {
            // (zext i32 to i64) & 4294967295 -> (zext i32 to i64)
            if (CE1.getOpcode() == Instruction.CastOps.ZExt) {
              /*uint*/int DstWidth = CI2.getType().getBitWidth();
              /*uint*/int SrcWidth = CE1.getOperand_Constant(0).getType().getPrimitiveSizeInBits();
              APInt PossiblySetBits/*J*/= APInt.getLowBitsSet(DstWidth, SrcWidth);
              if ((PossiblySetBits.$bitand(CI2.getValue())).$eq(PossiblySetBits)) {
                return C1;
              }
            }
            
            // If and'ing the address of a global with a constant, fold it.
            if (CE1.getOpcode() == Instruction.CastOps.PtrToInt
               && isa_GlobalValue(CE1.getOperand_Constant(0))) {
              GlobalValue /*P*/ GV = cast_GlobalValue(CE1.getOperand_Constant(0));
              
              // Functions are at least 4-byte aligned.
              /*uint*/int GVAlign = GV.getAlignment();
              if (isa_Function(GV)) {
                GVAlign = std.max(GVAlign, 4/*U*/);
              }
              if ($greater_uint(GVAlign, 1)) {
                /*uint*/int DstWidth = CI2.getType().getBitWidth();
                /*uint*/int SrcWidth = std.min_uint(DstWidth, Log2_32(GVAlign));
                APInt BitsNotSet/*J*/= APInt.getLowBitsSet(DstWidth, SrcWidth);
                
                // If checking bits we know are clear, return zero.
                if ((CI2.getValue().$bitand(BitsNotSet)).$eq(CI2.getValue())) {
                  return Constant.getNullValue(CI2.getType());
                }
              }
            }
          }
        }
        break;
       case Instruction.BinaryOps.Or:
        if (CI2.equalsInt($int2ulong(0))) {
          return C1; // X | 0 == X
        }
        if (CI2.isAllOnesValue()) {
          return C2; // X | -1 == -1
        }
        break;
       case Instruction.BinaryOps.Xor:
        if (CI2.equalsInt($int2ulong(0))) {
          return C1; // X ^ 0 == X
        }
        {
          
          ConstantExpr /*P*/ CE1 = dyn_cast_ConstantExpr(C1);
          if ((CE1 != null)) {
            switch (CE1.getOpcode()) {
             default:
              break;
             case Instruction.OtherOps.ICmp:
             case Instruction.OtherOps.FCmp:
              // cmp pred ^ true -> cmp !pred
              assert (CI2.equalsInt($int2ulong(1)));
              CmpInst.Predicate pred = CmpInst.Predicate.valueOf(CE1.getPredicate());
              pred = CmpInst.getInversePredicate(pred);
              return ConstantExpr.getCompare(pred.getValue(), CE1.getOperand_Constant(0), 
                  CE1.getOperand_Constant(1));
            }
          }
        }
        break;
       case Instruction.BinaryOps.AShr:
        {
          // ashr (zext C to Ty), C2 -> lshr (zext C, CSA), C2
          ConstantExpr /*P*/ CE1 = dyn_cast_ConstantExpr(C1);
          if ((CE1 != null)) {
            if (CE1.getOpcode() == Instruction.CastOps.ZExt) { // Top bits known zero.
              return ConstantExpr.getLShr(C1, C2);
            }
          }
        }
        break;
      }
    } else if (isa_ConstantInt(C1)) {
      // If C1 is a ConstantInt and C2 is not, swap the operands.
      if (Instruction.isCommutative(Opcode)) {
        return ConstantExpr.get(Opcode, C2, C1);
      }
    }
  }
  {
    
    ConstantInt /*P*/ CI1 = dyn_cast_ConstantInt(C1);
    if ((CI1 != null)) {
      {
        ConstantInt /*P*/ CI2 = dyn_cast_ConstantInt(C2);
        if ((CI2 != null)) {
          final /*const*/ APInt /*&*/ C1V = CI1.getValue();
          final /*const*/ APInt /*&*/ C2V = CI2.getValue();
          switch (Opcode) {
           default:
            break;
           case Instruction.BinaryOps.Add:
            return ConstantInt.get(CI1.getContext(), C1V.$add(C2V));
           case Instruction.BinaryOps.Sub:
            return ConstantInt.get(CI1.getContext(), C1V.$sub(C2V));
           case Instruction.BinaryOps.Mul:
            return ConstantInt.get(CI1.getContext(), C1V.$star(C2V));
           case Instruction.BinaryOps.UDiv:
            assert (!CI2.isNullValue()) : "Div by zero handled above";
            return ConstantInt.get(CI1.getContext(), C1V.udiv(C2V));
           case Instruction.BinaryOps.SDiv:
            assert (!CI2.isNullValue()) : "Div by zero handled above";
            if (C2V.isAllOnesValue() && C1V.isMinSignedValue()) {
              return UndefValue.get(CI1.getType()); // MIN_INT / -1 -> undef
            }
            return ConstantInt.get(CI1.getContext(), C1V.sdiv(C2V));
           case Instruction.BinaryOps.URem:
            assert (!CI2.isNullValue()) : "Div by zero handled above";
            return ConstantInt.get(CI1.getContext(), C1V.urem(C2V));
           case Instruction.BinaryOps.SRem:
            assert (!CI2.isNullValue()) : "Div by zero handled above";
            if (C2V.isAllOnesValue() && C1V.isMinSignedValue()) {
              return UndefValue.get(CI1.getType()); // MIN_INT % -1 -> undef
            }
            return ConstantInt.get(CI1.getContext(), C1V.srem(C2V));
           case Instruction.BinaryOps.And:
            return ConstantInt.get(CI1.getContext(), C1V.$bitand(C2V));
           case Instruction.BinaryOps.Or:
            return ConstantInt.get(CI1.getContext(), C1V.$bitor(C2V));
           case Instruction.BinaryOps.Xor:
            return ConstantInt.get(CI1.getContext(), C1V.$bitxor(C2V));
           case Instruction.BinaryOps.Shl:
            if (C2V.ult($uint2ulong(C1V.getBitWidth()))) {
              return ConstantInt.get(CI1.getContext(), C1V.shl(C2V));
            }
            return UndefValue.get(C1.getType()); // too big shift is undef
           case Instruction.BinaryOps.LShr:
            if (C2V.ult($uint2ulong(C1V.getBitWidth()))) {
              return ConstantInt.get(CI1.getContext(), C1V.lshr(C2V));
            }
            return UndefValue.get(C1.getType()); // too big shift is undef
           case Instruction.BinaryOps.AShr:
            if (C2V.ult($uint2ulong(C1V.getBitWidth()))) {
              return ConstantInt.get(CI1.getContext(), C1V.ashr(C2V));
            }
            return UndefValue.get(C1.getType()); // too big shift is undef
          }
        }
      }
      switch (Opcode) {
       case Instruction.BinaryOps.SDiv:
       case Instruction.BinaryOps.UDiv:
       case Instruction.BinaryOps.URem:
       case Instruction.BinaryOps.SRem:
       case Instruction.BinaryOps.LShr:
       case Instruction.BinaryOps.AShr:
       case Instruction.BinaryOps.Shl:
        if (CI1.equalsInt($int2ulong(0))) {
          return C1;
        }
        break;
       default:
        break;
      }
    } else {
      ConstantFP /*P*/ CFP1 = dyn_cast_ConstantFP(C1);
      if ((CFP1 != null)) {
        {
          ConstantFP /*P*/ CFP2 = dyn_cast_ConstantFP(C2);
          if ((CFP2 != null)) {
            final /*const*/ APFloat /*&*/ C1V = CFP1.getValueAPF();
            final /*const*/ APFloat /*&*/ C2V = CFP2.getValueAPF();
            APFloat C3V = new APFloat(C1V); // copy for modification
            switch (Opcode) {
             default:
              break;
             case Instruction.BinaryOps.FAdd:
              /*J:(void)*/C3V.add(C2V, APFloat.roundingMode.rmNearestTiesToEven);
              return ConstantFP.get(C1.getContext(), C3V);
             case Instruction.BinaryOps.FSub:
              /*J:(void)*/C3V.subtract(C2V, APFloat.roundingMode.rmNearestTiesToEven);
              return ConstantFP.get(C1.getContext(), C3V);
             case Instruction.BinaryOps.FMul:
              /*J:(void)*/C3V.multiply(C2V, APFloat.roundingMode.rmNearestTiesToEven);
              return ConstantFP.get(C1.getContext(), C3V);
             case Instruction.BinaryOps.FDiv:
              /*J:(void)*/C3V.divide(C2V, APFloat.roundingMode.rmNearestTiesToEven);
              return ConstantFP.get(C1.getContext(), C3V);
             case Instruction.BinaryOps.FRem:
              /*J:(void)*/C3V.mod(C2V);
              return ConstantFP.get(C1.getContext(), C3V);
            }
          }
        }
      } else {
        VectorType /*P*/ VTy = dyn_cast_VectorType(C1.getType());
        if ((VTy != null)) {
          // Perform elementwise folding.
          SmallVector<Constant /*P*/ > Result/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
          Type /*P*/ Ty = IntegerType.get(VTy.getContext(), 32);
          for (/*uint*/int i = 0, e = VTy.getNumElements(); i != e; ++i) {
            Constant /*P*/ LHS = ConstantExpr.getExtractElement(C1, ConstantInt.get(Ty, $uint2ulong(i)));
            Constant /*P*/ RHS = ConstantExpr.getExtractElement(C2, ConstantInt.get(Ty, $uint2ulong(i)));
            
            Result.push_back(ConstantExpr.get(Opcode, LHS, RHS));
          }
          
          return ConstantVector.get(new ArrayRef<Constant /*P*/ >(Result, true));
        }
      }
    }
  }
  {
    
    ConstantExpr /*P*/ CE1 = dyn_cast_ConstantExpr(C1);
    if ((CE1 != null)) {
      // There are many possible foldings we could do here.  We should probably
      // at least fold add of a pointer with an integer into the appropriate
      // getelementptr.  This will improve alias analysis a bit.
      
      // Given ((a + b) + c), if (b + c) folds to something interesting, return
      // (a + (b + c)).
      if (Instruction.isAssociative(Opcode) && CE1.getOpcode() == Opcode) {
        Constant /*P*/ T = ConstantExpr.get(Opcode, CE1.getOperand_Constant(1), C2);
        if (!isa_ConstantExpr(T) || cast_ConstantExpr(T).getOpcode() != Opcode) {
          return ConstantExpr.get(Opcode, CE1.getOperand_Constant(0), T);
        }
      }
    } else if (isa_ConstantExpr(C2)) {
      // If C2 is a constant expr and C1 isn't, flop them around and fold the
      // other way if possible.
      if (Instruction.isCommutative(Opcode)) {
        return ConstantFoldBinaryInstruction(Opcode, C2, C1);
      }
    }
  }
  
  // i1 can be simplified in many cases.
  if (C1.getType().isIntegerTy(1)) {
    switch (Opcode) {
     case Instruction.BinaryOps.Add:
     case Instruction.BinaryOps.Sub:
      return ConstantExpr.getXor(C1, C2);
     case Instruction.BinaryOps.Mul:
      return ConstantExpr.getAnd(C1, C2);
     case Instruction.BinaryOps.Shl:
     case Instruction.BinaryOps.LShr:
     case Instruction.BinaryOps.AShr:
      // We can assume that C2 == 0.  If it were one the result would be
      // undefined because the shift value is as large as the bitwidth.
      return C1;
     case Instruction.BinaryOps.SDiv:
     case Instruction.BinaryOps.UDiv:
      // We can assume that C2 == 1.  If it were zero the result would be
      // undefined through division by zero.
      return C1;
     case Instruction.BinaryOps.URem:
     case Instruction.BinaryOps.SRem:
      // We can assume that C2 == 1.  If it were zero the result would be
      // undefined through division by zero.
      return ConstantInt.getFalse(C1.getContext());
     default:
      break;
    }
  }
  
  // We don't know how to fold this.
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldCompareInstruction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 1676,
 FQN="llvm::ConstantFoldCompareInstruction", NM="_ZN4llvm30ConstantFoldCompareInstructionEtPNS_8ConstantES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZN4llvm30ConstantFoldCompareInstructionEtPNS_8ConstantES1_")
//</editor-fold>
public static Constant /*P*/ ConstantFoldCompareInstruction(/*ushort*/char pred, 
                              Constant /*P*/ C1, Constant /*P*/ C2) {
  Type /*P*/ ResultTy;
  {
    VectorType /*P*/ VT = dyn_cast_VectorType(C1.getType());
    if ((VT != null)) {
      ResultTy = VectorType.get(Type.getInt1Ty(C1.getContext()), 
          VT.getNumElements());
    } else {
      ResultTy = Type.getInt1Ty(C1.getContext());
    }
  }
  
  // Fold FCMP_FALSE/FCMP_TRUE unconditionally.
  if ($ushort2int(pred) == FCmpInst.Predicate.FCMP_FALSE.getValue()) {
    return Constant.getNullValue(ResultTy);
  }
  if ($ushort2int(pred) == FCmpInst.Predicate.FCMP_TRUE.getValue()) {
    return Constant.getAllOnesValue(ResultTy);
  }
  
  // Handle some degenerate cases first
  if (isa_UndefValue(C1) || isa_UndefValue(C2)) {
    CmpInst.Predicate Predicate = CmpInst.Predicate.valueOf(pred);
    boolean isIntegerPredicate = ICmpInst.isIntPredicate(Predicate);
    // For EQ and NE, we can always pick a value for the undef to make the
    // predicate pass or fail, so we can return undef.
    // Also, if both operands are undef, we can return undef for int comparison.
    if (ICmpInst.isEquality(Predicate) || (isIntegerPredicate && C1 == C2)) {
      return UndefValue.get(ResultTy);
    }
    
    // Otherwise, for integer compare, pick the same value as the non-undef
    // operand, and fold it to true or false.
    if (isIntegerPredicate) {
      return ConstantInt.get(ResultTy, (CmpInst.isTrueWhenEqual(Predicate) ? 1 : 0));
    }
    
    // Choosing NaN for the undef will always make unordered comparison succeed
    // and ordered comparison fails.
    return ConstantInt.get(ResultTy, (CmpInst.isUnordered(Predicate) ? 1 : 0));
  }
  
  // icmp eq/ne(null,GV) -> false/true
  if (C1.isNullValue()) {
    {
      /*const*/ GlobalValue /*P*/ GV = dyn_cast_GlobalValue(C2);
      if ((GV != null)) {
        // Don't try to evaluate aliases.  External weak GV can be null.
        if (!isa_GlobalAlias(GV) && !GV.hasExternalWeakLinkage()) {
          if ($ushort2int(pred) == ICmpInst.Predicate.ICMP_EQ.getValue()) {
            return ConstantInt.getFalse(C1.getContext());
          } else if ($ushort2int(pred) == ICmpInst.Predicate.ICMP_NE.getValue()) {
            return ConstantInt.getTrue(C1.getContext());
          }
        }
      }
    }
    // icmp eq/ne(GV,null) -> false/true
  } else if (C2.isNullValue()) {
    {
      /*const*/ GlobalValue /*P*/ GV = dyn_cast_GlobalValue(C1);
      if ((GV != null)) {
        // Don't try to evaluate aliases.  External weak GV can be null.
        if (!isa_GlobalAlias(GV) && !GV.hasExternalWeakLinkage()) {
          if ($ushort2int(pred) == ICmpInst.Predicate.ICMP_EQ.getValue()) {
            return ConstantInt.getFalse(C1.getContext());
          } else if ($ushort2int(pred) == ICmpInst.Predicate.ICMP_NE.getValue()) {
            return ConstantInt.getTrue(C1.getContext());
          }
        }
      }
    }
  }
  
  // If the comparison is a comparison between two i1's, simplify it.
  if (C1.getType().isIntegerTy(1)) {
    switch (CmpInst.Predicate.valueOf($ushort2int(pred))) {
     case ICMP_EQ:
      if (isa_ConstantInt(C2)) {
        return ConstantExpr.getXor(C1, ConstantExpr.getNot(C2));
      }
      return ConstantExpr.getXor(ConstantExpr.getNot(C1), C2);
     case ICMP_NE:
      return ConstantExpr.getXor(C1, C2);
     default:
      break;
    }
  }
  if (isa_ConstantInt(C1) && isa_ConstantInt(C2)) {
    final /*const*/ APInt /*&*/ V1 = cast_ConstantInt(C1).getValue();
    final /*const*/ APInt /*&*/ V2 = cast_ConstantInt(C2).getValue();
    switch (CmpInst.Predicate.valueOf($ushort2int(pred))) {
     default:
      throw new llvm_unreachable("Invalid ICmp Predicate");
     case ICMP_EQ:
      return ConstantInt.get(ResultTy, (V1.$eq(V2) ? 1 : 0));
     case ICMP_NE:
      return ConstantInt.get(ResultTy, (V1.$noteq(V2) ? 1 : 0));
     case ICMP_SLT:
      return ConstantInt.get(ResultTy, (V1.slt(V2) ? 1 : 0));
     case ICMP_SGT:
      return ConstantInt.get(ResultTy, (V1.sgt(V2) ? 1 : 0));
     case ICMP_SLE:
      return ConstantInt.get(ResultTy, (V1.sle(V2) ? 1 : 0));
     case ICMP_SGE:
      return ConstantInt.get(ResultTy, (V1.sge(V2) ? 1 : 0));
     case ICMP_ULT:
      return ConstantInt.get(ResultTy, (V1.ult(V2) ? 1 : 0));
     case ICMP_UGT:
      return ConstantInt.get(ResultTy, (V1.ugt(V2) ? 1 : 0));
     case ICMP_ULE:
      return ConstantInt.get(ResultTy, (V1.ule(V2) ? 1 : 0));
     case ICMP_UGE:
      return ConstantInt.get(ResultTy, (V1.uge(V2) ? 1 : 0));
    }
  } else if (isa_ConstantFP(C1) && isa_ConstantFP(C2)) {
    final /*const*/ APFloat /*&*/ C1V = cast_ConstantFP(C1).getValueAPF();
    final /*const*/ APFloat /*&*/ C2V = cast_ConstantFP(C2).getValueAPF();
    APFloat.cmpResult R = C1V.compare(C2V);
    switch (CmpInst.Predicate.valueOf($ushort2int(pred))) {
     default:
      throw new llvm_unreachable("Invalid FCmp Predicate");
     case FCMP_FALSE:
      return Constant.getNullValue(ResultTy);
     case FCMP_TRUE:
      return Constant.getAllOnesValue(ResultTy);
     case FCMP_UNO:
      return ConstantInt.get(ResultTy, ((R == APFloat.cmpResult.cmpUnordered) ? 1 : 0));
     case FCMP_ORD:
      return ConstantInt.get(ResultTy, ((R != APFloat.cmpResult.cmpUnordered) ? 1 : 0));
     case FCMP_UEQ:
      return ConstantInt.get(ResultTy, ((R == APFloat.cmpResult.cmpUnordered
             || R == APFloat.cmpResult.cmpEqual) ? 1 : 0));
     case FCMP_OEQ:
      return ConstantInt.get(ResultTy, ((R == APFloat.cmpResult.cmpEqual) ? 1 : 0));
     case FCMP_UNE:
      return ConstantInt.get(ResultTy, ((R != APFloat.cmpResult.cmpEqual) ? 1 : 0));
     case FCMP_ONE:
      return ConstantInt.get(ResultTy, ((R == APFloat.cmpResult.cmpLessThan
             || R == APFloat.cmpResult.cmpGreaterThan) ? 1 : 0));
     case FCMP_ULT:
      return ConstantInt.get(ResultTy, ((R == APFloat.cmpResult.cmpUnordered
             || R == APFloat.cmpResult.cmpLessThan) ? 1 : 0));
     case FCMP_OLT:
      return ConstantInt.get(ResultTy, ((R == APFloat.cmpResult.cmpLessThan) ? 1 : 0));
     case FCMP_UGT:
      return ConstantInt.get(ResultTy, ((R == APFloat.cmpResult.cmpUnordered
             || R == APFloat.cmpResult.cmpGreaterThan) ? 1 : 0));
     case FCMP_OGT:
      return ConstantInt.get(ResultTy, ((R == APFloat.cmpResult.cmpGreaterThan) ? 1 : 0));
     case FCMP_ULE:
      return ConstantInt.get(ResultTy, ((R != APFloat.cmpResult.cmpGreaterThan) ? 1 : 0));
     case FCMP_OLE:
      return ConstantInt.get(ResultTy, ((R == APFloat.cmpResult.cmpLessThan
             || R == APFloat.cmpResult.cmpEqual) ? 1 : 0));
     case FCMP_UGE:
      return ConstantInt.get(ResultTy, ((R != APFloat.cmpResult.cmpLessThan) ? 1 : 0));
     case FCMP_OGE:
      return ConstantInt.get(ResultTy, ((R == APFloat.cmpResult.cmpGreaterThan
             || R == APFloat.cmpResult.cmpEqual) ? 1 : 0));
    }
  } else if (C1.getType().isVectorTy()) {
    // If we can constant fold the comparison of each element, constant fold
    // the whole vector comparison.
    SmallVector<Constant /*P*/ > ResElts/*J*/= new SmallVector<Constant /*P*/ >(4, (Constant /*P*/ )null);
    Type /*P*/ Ty = IntegerType.get(C1.getContext(), 32);
    // Compare the elements, producing an i1 result or constant expr.
    for (/*uint*/int i = 0, e = C1.getType().getVectorNumElements(); i != e; ++i) {
      Constant /*P*/ C1E = ConstantExpr.getExtractElement(C1, ConstantInt.get(Ty, $uint2ulong(i)));
      Constant /*P*/ C2E = ConstantExpr.getExtractElement(C2, ConstantInt.get(Ty, $uint2ulong(i)));
      
      ResElts.push_back(ConstantExpr.getCompare(pred, C1E, C2E));
    }
    
    return ConstantVector.get(new ArrayRef<Constant /*P*/ >(ResElts, true));
  }
  if (C1.getType().isFloatingPointTy()
    // Only call evaluateFCmpRelation if we have a constant expr to avoid
    // infinite recursive loop
     && (isa_ConstantExpr(C1) || isa_ConstantExpr(C2))) {
    int Result = -1; // -1 = unknown, 0 = known false, 1 = known true.
    switch (ConstantFoldStatics.evaluateFCmpRelation(C1, C2)) {
     default:
      throw new llvm_unreachable("Unknown relation!");
     case FCMP_UNO:
     case FCMP_ORD:
     case FCMP_UEQ:
     case FCMP_UNE:
     case FCMP_ULT:
     case FCMP_UGT:
     case FCMP_ULE:
     case FCMP_UGE:
     case FCMP_TRUE:
     case FCMP_FALSE:
     case BAD_FCMP_PREDICATE:
      break; // Couldn't determine anything about these constants.
     case FCMP_OEQ: // We know that C1 == C2
      Result = (($ushort2int(pred) == FCmpInst.Predicate.FCMP_UEQ.getValue() || $ushort2int(pred) == FCmpInst.Predicate.FCMP_OEQ.getValue()
         || $ushort2int(pred) == FCmpInst.Predicate.FCMP_ULE.getValue() || $ushort2int(pred) == FCmpInst.Predicate.FCMP_OLE.getValue()
         || $ushort2int(pred) == FCmpInst.Predicate.FCMP_UGE.getValue() || $ushort2int(pred) == FCmpInst.Predicate.FCMP_OGE.getValue()) ? 1 : 0);
      break;
     case FCMP_OLT: // We know that C1 < C2
      Result = (($ushort2int(pred) == FCmpInst.Predicate.FCMP_UNE.getValue() || $ushort2int(pred) == FCmpInst.Predicate.FCMP_ONE.getValue()
         || $ushort2int(pred) == FCmpInst.Predicate.FCMP_ULT.getValue() || $ushort2int(pred) == FCmpInst.Predicate.FCMP_OLT.getValue()
         || $ushort2int(pred) == FCmpInst.Predicate.FCMP_ULE.getValue() || $ushort2int(pred) == FCmpInst.Predicate.FCMP_OLE.getValue()) ? 1 : 0);
      break;
     case FCMP_OGT: // We know that C1 > C2
      Result = (($ushort2int(pred) == FCmpInst.Predicate.FCMP_UNE.getValue() || $ushort2int(pred) == FCmpInst.Predicate.FCMP_ONE.getValue()
         || $ushort2int(pred) == FCmpInst.Predicate.FCMP_UGT.getValue() || $ushort2int(pred) == FCmpInst.Predicate.FCMP_OGT.getValue()
         || $ushort2int(pred) == FCmpInst.Predicate.FCMP_UGE.getValue() || $ushort2int(pred) == FCmpInst.Predicate.FCMP_OGE.getValue()) ? 1 : 0);
      break;
     case FCMP_OLE: // We know that C1 <= C2
      // We can only partially decide this relation.
      if ($ushort2int(pred) == FCmpInst.Predicate.FCMP_UGT.getValue() || $ushort2int(pred) == FCmpInst.Predicate.FCMP_OGT.getValue()) {
        Result = 0;
      } else if ($ushort2int(pred) == FCmpInst.Predicate.FCMP_ULT.getValue() || $ushort2int(pred) == FCmpInst.Predicate.FCMP_OLT.getValue()) {
        Result = 1;
      }
      break;
     case FCMP_OGE: // We known that C1 >= C2
      // We can only partially decide this relation.
      if ($ushort2int(pred) == FCmpInst.Predicate.FCMP_ULT.getValue() || $ushort2int(pred) == FCmpInst.Predicate.FCMP_OLT.getValue()) {
        Result = 0;
      } else if ($ushort2int(pred) == FCmpInst.Predicate.FCMP_UGT.getValue() || $ushort2int(pred) == FCmpInst.Predicate.FCMP_OGT.getValue()) {
        Result = 1;
      }
      break;
     case FCMP_ONE: // We know that C1 != C2
      // We can only partially decide this relation.
      if ($ushort2int(pred) == FCmpInst.Predicate.FCMP_OEQ.getValue() || $ushort2int(pred) == FCmpInst.Predicate.FCMP_UEQ.getValue()) {
        Result = 0;
      } else if ($ushort2int(pred) == FCmpInst.Predicate.FCMP_ONE.getValue() || $ushort2int(pred) == FCmpInst.Predicate.FCMP_UNE.getValue()) {
        Result = 1;
      }
      break;
    }
    
    // If we evaluated the result, return it now.
    if (Result != -1) {
      return ConstantInt.get(ResultTy, $int2ulong(Result));
    }
  } else {
    // Evaluate the relation between the two constants, per the predicate.
    int Result = -1; // -1 = unknown, 0 = known false, 1 = known true.
    switch (ConstantFoldStatics.evaluateICmpRelation(C1, C2, 
        CmpInst.isSigned(CmpInst.Predicate.valueOf(pred)))) {
     default:
      throw new llvm_unreachable("Unknown relational!");
     case BAD_ICMP_PREDICATE:
      break; // Couldn't determine anything about these constants.
     case ICMP_EQ: // We know the constants are equal!
      // If we know the constants are equal, we can decide the result of this
      // computation precisely.
      Result = (ICmpInst.isTrueWhenEqual(ICmpInst.Predicate.valueOf(pred)) ? 1 : 0);
      break;
     case ICMP_ULT:
      switch (CmpInst.Predicate.valueOf($ushort2int(pred))) {
       case ICMP_ULT:
       case ICMP_NE:
       case ICMP_ULE:
        Result = 1;
        break;
       case ICMP_UGT:
       case ICMP_EQ:
       case ICMP_UGE:
        Result = 0;
        break;
      }
      break;
     case ICMP_SLT:
      switch (CmpInst.Predicate.valueOf($ushort2int(pred))) {
       case ICMP_SLT:
       case ICMP_NE:
       case ICMP_SLE:
        Result = 1;
        break;
       case ICMP_SGT:
       case ICMP_EQ:
       case ICMP_SGE:
        Result = 0;
        break;
      }
      break;
     case ICMP_UGT:
      switch (CmpInst.Predicate.valueOf($ushort2int(pred))) {
       case ICMP_UGT:
       case ICMP_NE:
       case ICMP_UGE:
        Result = 1;
        break;
       case ICMP_ULT:
       case ICMP_EQ:
       case ICMP_ULE:
        Result = 0;
        break;
      }
      break;
     case ICMP_SGT:
      switch (CmpInst.Predicate.valueOf($ushort2int(pred))) {
       case ICMP_SGT:
       case ICMP_NE:
       case ICMP_SGE:
        Result = 1;
        break;
       case ICMP_SLT:
       case ICMP_EQ:
       case ICMP_SLE:
        Result = 0;
        break;
      }
      break;
     case ICMP_ULE:
      if ($ushort2int(pred) == ICmpInst.Predicate.ICMP_UGT.getValue()) {
        Result = 0;
      }
      if ($ushort2int(pred) == ICmpInst.Predicate.ICMP_ULT.getValue() || $ushort2int(pred) == ICmpInst.Predicate.ICMP_ULE.getValue()) {
        Result = 1;
      }
      break;
     case ICMP_SLE:
      if ($ushort2int(pred) == ICmpInst.Predicate.ICMP_SGT.getValue()) {
        Result = 0;
      }
      if ($ushort2int(pred) == ICmpInst.Predicate.ICMP_SLT.getValue() || $ushort2int(pred) == ICmpInst.Predicate.ICMP_SLE.getValue()) {
        Result = 1;
      }
      break;
     case ICMP_UGE:
      if ($ushort2int(pred) == ICmpInst.Predicate.ICMP_ULT.getValue()) {
        Result = 0;
      }
      if ($ushort2int(pred) == ICmpInst.Predicate.ICMP_UGT.getValue() || $ushort2int(pred) == ICmpInst.Predicate.ICMP_UGE.getValue()) {
        Result = 1;
      }
      break;
     case ICMP_SGE:
      if ($ushort2int(pred) == ICmpInst.Predicate.ICMP_SLT.getValue()) {
        Result = 0;
      }
      if ($ushort2int(pred) == ICmpInst.Predicate.ICMP_SGT.getValue() || $ushort2int(pred) == ICmpInst.Predicate.ICMP_SGE.getValue()) {
        Result = 1;
      }
      break;
     case ICMP_NE:
      if ($ushort2int(pred) == ICmpInst.Predicate.ICMP_EQ.getValue()) {
        Result = 0;
      }
      if ($ushort2int(pred) == ICmpInst.Predicate.ICMP_NE.getValue()) {
        Result = 1;
      }
      break;
    }
    
    // If we evaluated the result, return it now.
    if (Result != -1) {
      return ConstantInt.get(ResultTy, $int2ulong(Result));
    }
    {
      
      // If the right hand side is a bitcast, try using its inverse to simplify
      // it by moving it to the left hand side.  We can't do this if it would turn
      // a vector compare into a scalar compare or visa versa.
      ConstantExpr /*P*/ CE2 = dyn_cast_ConstantExpr(C2);
      if ((CE2 != null)) {
        Constant /*P*/ CE2Op0 = CE2.getOperand_Constant(0);
        if (CE2.getOpcode() == Instruction.CastOps.BitCast
           && CE2.getType().isVectorTy() == CE2Op0.getType().isVectorTy()) {
          Constant /*P*/ Inverse = ConstantExpr.getBitCast(C1, CE2Op0.getType());
          return ConstantExpr.getICmp(pred, Inverse, CE2Op0);
        }
      }
    }
    {
      
      // If the left hand side is an extension, try eliminating it.
      ConstantExpr /*P*/ CE1 = dyn_cast_ConstantExpr(C1);
      if ((CE1 != null)) {
        if ((CE1.getOpcode() == Instruction.CastOps.SExt
           && ICmpInst.isSigned(ICmpInst.Predicate.valueOf(pred)))
           || (CE1.getOpcode() == Instruction.CastOps.ZExt
           && !ICmpInst.isSigned(ICmpInst.Predicate.valueOf(pred)))) {
          Constant /*P*/ CE1Op0 = CE1.getOperand_Constant(0);
          Constant /*P*/ CE1Inverse = ConstantExpr.getTrunc(CE1, CE1Op0.getType());
          if (CE1Inverse == CE1Op0) {
            // Check whether we can safely truncate the right hand side.
            Constant /*P*/ C2Inverse = ConstantExpr.getTrunc(C2, CE1Op0.getType());
            if (ConstantExpr.getCast(CE1.getOpcode(), C2Inverse, 
                C2.getType()) == C2) {
              return ConstantExpr.getICmp(pred, CE1Inverse, C2Inverse);
            }
          }
        }
      }
    }
    if ((!isa_ConstantExpr(C1) && isa_ConstantExpr(C2))
       || (C1.isNullValue() && !C2.isNullValue())) {
      // If C2 is a constant expr and C1 isn't, flip them around and fold the
      // other way if possible.
      // Also, if C1 is null and C2 isn't, flip them around.
      pred = ICmpInst.getSwappedPredicate(ICmpInst.Predicate.valueOf(pred)).getValue();
      return ConstantExpr.getICmp(pred, C2, C1);
    }
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldGetElementPtr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 2276,
 FQN="llvm::ConstantFoldGetElementPtr", NM="_ZN4llvm25ConstantFoldGetElementPtrEPNS_4TypeEPNS_8ConstantEbNS_8ArrayRefIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZN4llvm25ConstantFoldGetElementPtrEPNS_4TypeEPNS_8ConstantEbNS_8ArrayRefIS3_EE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldGetElementPtr_Type$P_Constant$P_bool_ArrayRef$Constant$P(Type /*P*/ Ty, Constant /*P*/ C, 
                                                                    boolean inBounds, 
                                                                    ArrayRef<Constant /*P*/ > Idxs) {
  return ConstantFoldStatics.ConstantFoldGetElementPtrImpl(Ty, C, inBounds, new ArrayRef<Constant /*P*/ >(Idxs));
}

//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldGetElementPtr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 2282,
 FQN="llvm::ConstantFoldGetElementPtr", NM="_ZN4llvm25ConstantFoldGetElementPtrEPNS_4TypeEPNS_8ConstantEbNS_8ArrayRefIPNS_5ValueEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZN4llvm25ConstantFoldGetElementPtrEPNS_4TypeEPNS_8ConstantEbNS_8ArrayRefIPNS_5ValueEEE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldGetElementPtr_Type$P_Constant$P_bool_ArrayRef$Value$P(Type /*P*/ Ty, Constant /*P*/ C, 
                                                                 boolean inBounds, 
                                                                 ArrayRef<Value /*P*/ > Idxs) {
  return ConstantFoldStatics.ConstantFoldGetElementPtrImpl(Ty, C, inBounds, new ArrayRef<Value /*P*/ >(Idxs));
}

} // END OF class ConstantFoldLlvmStatics
