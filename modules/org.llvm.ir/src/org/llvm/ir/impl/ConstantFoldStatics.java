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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type ConstantFoldStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.ConstantFoldStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=Tpl__ZL17isInBoundsIndicesN4llvm8ArrayRefIT_EE;Tpl__ZL29ConstantFoldGetElementPtrImplPN4llvm4TypeEPNS_8ConstantEbNS_8ArrayRefIT_EE;_ZL10IdxComparePN4llvm8ConstantES1_PNS_4TypeE;_ZL11FoldBitCastPN4llvm8ConstantEPNS_4TypeE;_ZL15getFoldedSizeOfPN4llvm4TypeES1_b;_ZL16getFoldedAlignOfPN4llvm4TypeES1_b;_ZL17getFoldedOffsetOfPN4llvm4TypeEPNS_8ConstantES1_b;_ZL20ExtractConstantBytesPN4llvm8ConstantEjj;_ZL20evaluateFCmpRelationPN4llvm8ConstantES1_;_ZL20evaluateICmpRelationPN4llvm8ConstantES1_b;_ZL20foldConstantCastPairjPN4llvm12ConstantExprEPNS_4TypeE;_ZL20isMaybeZeroSizedTypePN4llvm4TypeE;_ZL21BitCastConstantVectorPN4llvm8ConstantEPNS_10VectorTypeE;_ZL26areGlobalsPotentiallyEqualPKN4llvm11GlobalValueES2_;_ZL30isIndexInRangeOfSequentialTypePN4llvm14SequentialTypeEPKNS_11ConstantIntE; -static-type=ConstantFoldStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class ConstantFoldStatics {


//===----------------------------------------------------------------------===//
//                ConstantFold*Instruction Implementations
//===----------------------------------------------------------------------===//

/// Convert the specified vector Constant node to the specified vector type.
/// At this point, we know that the elements of the input vector constant are
/// all simple integer or FP values.
//<editor-fold defaultstate="collapsed" desc="BitCastConstantVector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 44,
 FQN="BitCastConstantVector", NM="_ZL21BitCastConstantVectorPN4llvm8ConstantEPNS_10VectorTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZL21BitCastConstantVectorPN4llvm8ConstantEPNS_10VectorTypeE")
//</editor-fold>
public static Constant /*P*/ BitCastConstantVector(Constant /*P*/ CV, VectorType /*P*/ DstTy) {
  if (CV.isAllOnesValue()) {
    return Constant.getAllOnesValue(DstTy);
  }
  if (CV.isNullValue()) {
    return Constant.getNullValue(DstTy);
  }
  
  // If this cast changes element count then we can't handle it here:
  // doing so requires endianness information.  This should be handled by
  // Analysis/ConstantFolding.cpp
  /*uint*/int NumElts = DstTy.getNumElements();
  if (NumElts != CV.getType().getVectorNumElements()) {
    return null;
  }
  
  Type /*P*/ DstEltTy = DstTy.getElementType();
  
  SmallVector<Constant /*P*/ > Result/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
  Type /*P*/ Ty = IntegerType.get(CV.getContext(), 32);
  for (/*uint*/int i = 0; i != NumElts; ++i) {
    Constant /*P*/ C = ConstantExpr.getExtractElement(CV, ConstantInt.get(Ty, $uint2ulong(i)));
    C = ConstantExpr.getBitCast(C, DstEltTy);
    Result.push_back(C);
  }
  
  return ConstantVector.get(new ArrayRef<Constant /*P*/ >(Result, true));
}


/// This function determines which opcode to use to fold two constant cast
/// expressions together. It uses CastInst::isEliminableCastPair to determine
/// the opcode. Consequently its just a wrapper around that function.
/// @brief Determine if it is valid to fold a cast of a cast
//<editor-fold defaultstate="collapsed" desc="foldConstantCastPair">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 74,
 FQN="foldConstantCastPair", NM="_ZL20foldConstantCastPairjPN4llvm12ConstantExprEPNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZL20foldConstantCastPairjPN4llvm12ConstantExprEPNS_4TypeE")
//</editor-fold>
public static /*uint*/int foldConstantCastPair(/*uint*/int opc,  ///< opcode of the second cast constant expression
                    ConstantExpr /*P*/ Op,  ///< the first cast constant expression
                    Type /*P*/ DstTy) {
  assert ((Op != null) && Op.isCast()) : "Can't fold cast of cast without a cast!";
  assert ((DstTy != null) && DstTy.isFirstClassType()) : "Invalid cast destination type";
  assert (CastInst.isCast(opc)) : "Invalid cast opcode";
  
  // The types and opcodes for the two Cast constant expressions
  Type /*P*/ SrcTy = Op.getOperand_Constant(0).getType();
  Type /*P*/ MidTy = Op.getType();
  /*CastOps*/int firstOp = ((/*CastOps*/int)(Op.getOpcode()));
  /*CastOps*/int secondOp = ((/*CastOps*/int)(opc));
  
  // Assume that pointers are never more than 64 bits wide, and only use this
  // for the middle type. Otherwise we could end up folding away illegal
  // bitcasts between address spaces with different sizes.
  IntegerType /*P*/ FakeIntPtrTy = Type.getInt64Ty(DstTy.getContext());
  
  // Let CastInst::isEliminableCastPair do the heavy lifting.
  return CastInst.isEliminableCastPair(firstOp, secondOp, SrcTy, MidTy, DstTy, 
      (Type /*P*/ )null, FakeIntPtrTy, (Type /*P*/ )null);
}

//<editor-fold defaultstate="collapsed" desc="FoldBitCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 100,
 FQN="FoldBitCast", NM="_ZL11FoldBitCastPN4llvm8ConstantEPNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZL11FoldBitCastPN4llvm8ConstantEPNS_4TypeE")
//</editor-fold>
public static Constant /*P*/ FoldBitCast(Constant /*P*/ V, Type /*P*/ DestTy) {
  Type /*P*/ SrcTy = V.getType();
  if (SrcTy == DestTy) {
    return V; // no-op cast
  }
  {
    
    // Check to see if we are casting a pointer to an aggregate to a pointer to
    // the first element.  If so, return the appropriate GEP instruction.
    PointerType /*P*/ PTy = dyn_cast_PointerType(V.getType());
    if ((PTy != null)) {
      {
        PointerType /*P*/ DPTy = dyn_cast_PointerType(DestTy);
        if ((DPTy != null)) {
          if (PTy.getAddressSpace() == DPTy.getAddressSpace()
             && PTy.getElementType().isSized()) {
            SmallVector<Value /*P*/ > IdxList/*J*/= new SmallVector<Value /*P*/ >(8, (Value /*P*/ )null);
            Value /*P*/ Zero = Constant.getNullValue(Type.getInt32Ty(DPTy.getContext()));
            IdxList.push_back(Zero);
            Type /*P*/ ElTy = PTy.getElementType();
            while (ElTy != DPTy.getElementType()) {
              {
                StructType /*P*/ STy = dyn_cast_StructType(ElTy);
                if ((STy != null)) {
                  if (STy.getNumElements() == 0) {
                    break;
                  }
                  ElTy = STy.getElementType(0);
                  IdxList.push_back(Zero);
                } else {
                  SequentialType /*P*/ STy$1 = dyn_cast_SequentialType(ElTy);
                  if ((STy$1 != null)) {
                    if (ElTy.isPointerTy()) {
                      break; // Can't index into pointers!
                    }
                    ElTy = STy$1.getElementType();
                    IdxList.push_back(Zero);
                  } else {
                    break;
                  }
                }
              }
            }
            if (ElTy == DPTy.getElementType()) {
              // This GEP is inbounds because all indices are zero.
              return ConstantExpr.getInBoundsGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P(PTy.getElementType(), 
                  V, new ArrayRef<Value /*P*/ >(IdxList, true));
            }
          }
        }
      }
    }
  }
  {
    
    // Handle casts from one vector constant to another.  We know that the src
    // and dest type have the same size (otherwise its an illegal cast).
    VectorType /*P*/ DestPTy = dyn_cast_VectorType(DestTy);
    if ((DestPTy != null)) {
      {
        VectorType /*P*/ SrcTy$1 = dyn_cast_VectorType(V.getType());
        if ((SrcTy$1 != null)) {
          assert (DestPTy.getBitWidth() == SrcTy$1.getBitWidth()) : "Not cast between same sized vectors!";
          SrcTy$1 = null;
          // First, check for null.  Undef is already handled.
          if (isa_ConstantAggregateZero(V)) {
            return Constant.getNullValue(DestTy);
          }
          
          // Handle ConstantVector and ConstantAggregateVector.
          return BitCastConstantVector(V, DestPTy);
        }
      }
      
      // Canonicalize scalar-to-vector bitcasts into vector-to-vector bitcasts
      // This allows for other simplifications (although some of them
      // can only be handled by Analysis/ConstantFolding.cpp).
      if (isa_ConstantInt(V) || isa_ConstantFP(V)) {
        return ConstantExpr.getBitCast(ConstantVector.get(new ArrayRef<Constant /*P*/ >(V, true)), DestPTy);
      }
    }
  }
  
  // Finally, implement bitcast folding now.   The code below doesn't handle
  // bitcast right.
  if (isa_ConstantPointerNull(V)) { // ptr->ptr cast.
    return ConstantPointerNull.get(cast_PointerType(DestTy));
  }
  {
    
    // Handle integral constant input.
    ConstantInt /*P*/ CI = dyn_cast_ConstantInt(V);
    if ((CI != null)) {
      if (DestTy.isIntegerTy()) {
        // Integral -> Integral. This is a no-op because the bit widths must
        // be the same. Consequently, we just fold to V.
        return V;
      }
      
      // See note below regarding the PPC_FP128 restriction.
      if (DestTy.isFloatingPointTy() && !DestTy.isPPC_FP128Ty()) {
        return ConstantFP.get(DestTy.getContext(), 
            new APFloat(DestTy.getFltSemantics(), 
                CI.getValue()));
      }
      
      // Otherwise, can't fold this (vector?)
      return null;
    }
  }
  {
    
    // Handle ConstantFP input: FP -> Integral.
    ConstantFP /*P*/ FP = dyn_cast_ConstantFP(V);
    if ((FP != null)) {
      // PPC_FP128 is really the sum of two consecutive doubles, where the first
      // double is always stored first in memory, regardless of the target
      // endianness. The memory layout of i128, however, depends on the target
      // endianness, and so we can't fold this without target endianness
      // information. This should instead be handled by
      // Analysis/ConstantFolding.cpp
      if (FP.getType().isPPC_FP128Ty()) {
        return null;
      }
      
      // Make sure dest type is compatible with the folded integer constant.
      if (!DestTy.isIntegerTy()) {
        return null;
      }
      
      return ConstantInt.get(FP.getContext(), 
          FP.getValueAPF().bitcastToAPInt());
    }
  }
  
  return null;
}


/// V is an integer constant which only has a subset of its bytes used.
/// The bytes used are indicated by ByteStart (which is the first byte used,
/// counting from the least significant byte) and ByteSize, which is the number
/// of bytes used.
///
/// This function analyzes the specified constant to see if the specified byte
/// range can be returned as a simplified constant.  If so, the constant is
/// returned, otherwise null is returned.
//<editor-fold defaultstate="collapsed" desc="ExtractConstantBytes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 212,
 FQN="ExtractConstantBytes", NM="_ZL20ExtractConstantBytesPN4llvm8ConstantEjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZL20ExtractConstantBytesPN4llvm8ConstantEjj")
//</editor-fold>
public static Constant /*P*/ ExtractConstantBytes(Constant /*P*/ C, /*uint*/int ByteStart, 
                    /*uint*/int ByteSize) {
  assert (C.getType().isIntegerTy() && (cast_IntegerType(C.getType()).getBitWidth() & 7) == 0) : "Non-byte sized integer input";
  /*uint*/int CSize = $div_uint(cast_IntegerType(C.getType()).getBitWidth(), 8);
  assert ((ByteSize != 0)) : "Must be accessing some piece";
  assert ($lesseq_uint(ByteStart + ByteSize, CSize)) : "Extracting invalid piece from input";
  assert (ByteSize != CSize) : "Should not extract everything";
  {
    
    // Constant Integers are simple.
    ConstantInt /*P*/ CI = dyn_cast_ConstantInt(C);
    if ((CI != null)) {
      APInt V = new APInt(CI.getValue());
      if ((ByteStart != 0)) {
        V.$assignMove(V.lshr(ByteStart * 8));
      }
      V.$assignMove(V.trunc(ByteSize * 8));
      return ConstantInt.get(CI.getContext(), V);
    }
  }
  
  // In the input is a constant expr, we might be able to recursively simplify.
  // If not, we definitely can't do anything.
  ConstantExpr /*P*/ CE = dyn_cast_ConstantExpr(C);
  if (!(CE != null)) {
    return null;
  }
  switch (CE.getOpcode()) {
   default:
    return null;
   case Instruction.BinaryOps.Or:
    {
      Constant /*P*/ RHS = ExtractConstantBytes(CE.getOperand_Constant(1), ByteStart, ByteSize);
      if (!(RHS != null)) {
        return null;
      }
      {
        
        // X | -1 -> -1.
        ConstantInt /*P*/ RHSC = dyn_cast_ConstantInt(RHS);
        if ((RHSC != null)) {
          if (RHSC.isAllOnesValue()) {
            return RHSC;
          }
        }
      }
      
      Constant /*P*/ LHS = ExtractConstantBytes(CE.getOperand_Constant(0), ByteStart, ByteSize);
      if (!(LHS != null)) {
        return null;
      }
      return ConstantExpr.getOr(LHS, RHS);
    }
   case Instruction.BinaryOps.And:
    {
      Constant /*P*/ RHS = ExtractConstantBytes(CE.getOperand_Constant(1), ByteStart, ByteSize);
      if (!(RHS != null)) {
        return null;
      }
      
      // X & 0 -> 0.
      if (RHS.isNullValue()) {
        return RHS;
      }
      
      Constant /*P*/ LHS = ExtractConstantBytes(CE.getOperand_Constant(0), ByteStart, ByteSize);
      if (!(LHS != null)) {
        return null;
      }
      return ConstantExpr.getAnd(LHS, RHS);
    }
   case Instruction.BinaryOps.LShr:
    {
      ConstantInt /*P*/ Amt = dyn_cast_ConstantInt(CE.getOperand_Constant(1));
      if (!(Amt != null)) {
        return null;
      }
      /*uint*/int ShAmt = $ulong2uint(Amt.getZExtValue());
      // Cannot analyze non-byte shifts.
      if ((ShAmt & 7) != 0) {
        return null;
      }
      ShAmt >>>= 3;
      
      // If the extract is known to be all zeros, return zero.
      if ($greatereq_uint(ByteStart, CSize - ShAmt)) {
        return Constant.getNullValue(IntegerType.get(CE.getContext(), 
                ByteSize * 8));
      }
      // If the extract is known to be fully in the input, extract it.
      if ($lesseq_uint(ByteStart + ByteSize + ShAmt, CSize)) {
        return ExtractConstantBytes(CE.getOperand_Constant(0), ByteStart + ShAmt, ByteSize);
      }
      
      // TODO: Handle the 'partially zero' case.
      return null;
    }
   case Instruction.BinaryOps.Shl:
    {
      ConstantInt /*P*/ Amt = dyn_cast_ConstantInt(CE.getOperand_Constant(1));
      if (!(Amt != null)) {
        return null;
      }
      /*uint*/int ShAmt = $ulong2uint(Amt.getZExtValue());
      // Cannot analyze non-byte shifts.
      if ((ShAmt & 7) != 0) {
        return null;
      }
      ShAmt >>>= 3;
      
      // If the extract is known to be all zeros, return zero.
      if ($lesseq_uint(ByteStart + ByteSize, ShAmt)) {
        return Constant.getNullValue(IntegerType.get(CE.getContext(), 
                ByteSize * 8));
      }
      // If the extract is known to be fully in the input, extract it.
      if ($greatereq_uint(ByteStart, ShAmt)) {
        return ExtractConstantBytes(CE.getOperand_Constant(0), ByteStart - ShAmt, ByteSize);
      }
      
      // TODO: Handle the 'partially zero' case.
      return null;
    }
   case Instruction.CastOps.ZExt:
    {
      /*uint*/int SrcBitSize = cast_IntegerType(CE.getOperand_Constant(0).getType()).getBitWidth();
      
      // If extracting something that is completely zero, return 0.
      if ($greatereq_uint(ByteStart * 8, SrcBitSize)) {
        return Constant.getNullValue(IntegerType.get(CE.getContext(), 
                ByteSize * 8));
      }
      
      // If exactly extracting the input, return it.
      if (ByteStart == 0 && ByteSize * 8 == SrcBitSize) {
        return CE.getOperand_Constant(0);
      }
      
      // If extracting something completely in the input, if if the input is a
      // multiple of 8 bits, recurse.
      if ((SrcBitSize & 7) == 0 && $lesseq_uint((ByteStart + ByteSize) * 8, SrcBitSize)) {
        return ExtractConstantBytes(CE.getOperand_Constant(0), ByteStart, ByteSize);
      }
      
      // Otherwise, if extracting a subset of the input, which is not multiple of
      // 8 bits, do a shift and trunc to get the bits.
      if ($less_uint((ByteStart + ByteSize) * 8, SrcBitSize)) {
        assert (((SrcBitSize & 7) != 0)) : "Shouldn't get byte sized case here";
        Constant /*P*/ Res = CE.getOperand_Constant(0);
        if ((ByteStart != 0)) {
          Res = ConstantExpr.getLShr(Res, 
              ConstantInt.get(Res.getType(), $uint2ulong(ByteStart * 8)));
        }
        return ConstantExpr.getTrunc(Res, IntegerType.get(C.getContext(), 
                ByteSize * 8));
      }
      
      // TODO: Handle the 'partially zero' case.
      return null;
    }
  }
}


/// Return a ConstantExpr with type DestTy for sizeof on Ty, with any known
/// factors factored out. If Folded is false, return null if no factoring was
/// possible, to avoid endlessly bouncing an unfoldable expression back into the
/// top-level folder.
//<editor-fold defaultstate="collapsed" desc="getFoldedSizeOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 351,
 FQN="getFoldedSizeOf", NM="_ZL15getFoldedSizeOfPN4llvm4TypeES1_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZL15getFoldedSizeOfPN4llvm4TypeES1_b")
//</editor-fold>
public static Constant /*P*/ getFoldedSizeOf(Type /*P*/ Ty, Type /*P*/ DestTy, 
               boolean Folded) {
  {
    ArrayType /*P*/ ATy = dyn_cast_ArrayType(Ty);
    if ((ATy != null)) {
      Constant /*P*/ N = ConstantInt.get(DestTy, ATy.getNumElements());
      Constant /*P*/ E = getFoldedSizeOf(ATy.getElementType(), DestTy, true);
      return ConstantExpr.getNUWMul(E, N);
    }
  }
  {
    
    StructType /*P*/ STy = dyn_cast_StructType(Ty);
    if ((STy != null)) {
      if (!STy.isPacked()) {
        /*uint*/int NumElems = STy.getNumElements();
        // An empty struct has size zero.
        if (NumElems == 0) {
          return ConstantExpr.getNullValue(DestTy);
        }
        // Check for a struct with all members having the same size.
        Constant /*P*/ MemberSize = getFoldedSizeOf(STy.getElementType(0), DestTy, true);
        boolean AllSame = true;
        for (/*uint*/int i = 1; i != NumElems; ++i)  {
          if (MemberSize
             != getFoldedSizeOf(STy.getElementType(i), DestTy, true)) {
            AllSame = false;
            break;
          }
        }
        if (AllSame) {
          Constant /*P*/ N = ConstantInt.get(DestTy, $uint2ulong(NumElems));
          return ConstantExpr.getNUWMul(MemberSize, N);
        }
      }
    }
  }
  {
    
    // Pointer size doesn't depend on the pointee type, so canonicalize them
    // to an arbitrary pointee.
    PointerType /*P*/ PTy = dyn_cast_PointerType(Ty);
    if ((PTy != null)) {
      if (!PTy.getElementType().isIntegerTy(1)) {
        return getFoldedSizeOf(PointerType.get(IntegerType.get(PTy.getContext(), 1), 
                PTy.getAddressSpace()), 
            DestTy, true);
      }
    }
  }
  
  // If there's no interesting folding happening, bail so that we don't create
  // a constant that looks like it needs folding but really doesn't.
  if (!Folded) {
    return null;
  }
  
  // Base case: Get a regular sizeof expression.
  Constant /*P*/ C = ConstantExpr.getSizeOf(Ty);
  C = ConstantExpr.getCast(CastInst.getCastOpcode(C, false, 
          DestTy, false), 
      C, DestTy);
  return C;
}


/// Return a ConstantExpr with type DestTy for alignof on Ty, with any known
/// factors factored out. If Folded is false, return null if no factoring was
/// possible, to avoid endlessly bouncing an unfoldable expression back into the
/// top-level folder.
//<editor-fold defaultstate="collapsed" desc="getFoldedAlignOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 407,
 FQN="getFoldedAlignOf", NM="_ZL16getFoldedAlignOfPN4llvm4TypeES1_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZL16getFoldedAlignOfPN4llvm4TypeES1_b")
//</editor-fold>
public static Constant /*P*/ getFoldedAlignOf(Type /*P*/ Ty, Type /*P*/ DestTy, 
                boolean Folded) {
  {
    // The alignment of an array is equal to the alignment of the
    // array element. Note that this is not always true for vectors.
    ArrayType /*P*/ ATy = dyn_cast_ArrayType(Ty);
    if ((ATy != null)) {
      Constant /*P*/ C = ConstantExpr.getAlignOf(ATy.getElementType());
      C = ConstantExpr.getCast(CastInst.getCastOpcode(C, false, 
              DestTy, 
              false), 
          C, DestTy);
      return C;
    }
  }
  {
    
    StructType /*P*/ STy = dyn_cast_StructType(Ty);
    if ((STy != null)) {
      // Packed structs always have an alignment of 1.
      if (STy.isPacked()) {
        return ConstantInt.get(DestTy, $int2ulong(1));
      }
      
      // Otherwise, struct alignment is the maximum alignment of any member.
      // Without target data, we can't compare much, but we can check to see
      // if all the members have the same alignment.
      /*uint*/int NumElems = STy.getNumElements();
      // An empty struct has minimal alignment.
      if (NumElems == 0) {
        return ConstantInt.get(DestTy, $int2ulong(1));
      }
      // Check for a struct with all members having the same alignment.
      Constant /*P*/ MemberAlign = getFoldedAlignOf(STy.getElementType(0), DestTy, true);
      boolean AllSame = true;
      for (/*uint*/int i = 1; i != NumElems; ++i)  {
        if (MemberAlign != getFoldedAlignOf(STy.getElementType(i), DestTy, true)) {
          AllSame = false;
          break;
        }
      }
      if (AllSame) {
        return MemberAlign;
      }
    }
  }
  {
    
    // Pointer alignment doesn't depend on the pointee type, so canonicalize them
    // to an arbitrary pointee.
    PointerType /*P*/ PTy = dyn_cast_PointerType(Ty);
    if ((PTy != null)) {
      if (!PTy.getElementType().isIntegerTy(1)) {
        return getFoldedAlignOf(PointerType.get(IntegerType.get(PTy.getContext(), 
                    1), 
                PTy.getAddressSpace()), 
            DestTy, true);
      }
    }
  }
  
  // If there's no interesting folding happening, bail so that we don't create
  // a constant that looks like it needs folding but really doesn't.
  if (!Folded) {
    return null;
  }
  
  // Base case: Get a regular alignof expression.
  Constant /*P*/ C = ConstantExpr.getAlignOf(Ty);
  C = ConstantExpr.getCast(CastInst.getCastOpcode(C, false, 
          DestTy, false), 
      C, DestTy);
  return C;
}


/// Return a ConstantExpr with type DestTy for offsetof on Ty and FieldNo, with
/// any known factors factored out. If Folded is false, return null if no
/// factoring was possible, to avoid endlessly bouncing an unfoldable expression
/// back into the top-level folder.
//<editor-fold defaultstate="collapsed" desc="getFoldedOffsetOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 472,
 FQN="getFoldedOffsetOf", NM="_ZL17getFoldedOffsetOfPN4llvm4TypeEPNS_8ConstantES1_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZL17getFoldedOffsetOfPN4llvm4TypeEPNS_8ConstantES1_b")
//</editor-fold>
public static Constant /*P*/ getFoldedOffsetOf(Type /*P*/ Ty, Constant /*P*/ FieldNo, 
                 Type /*P*/ DestTy, 
                 boolean Folded) {
  {
    ArrayType /*P*/ ATy = dyn_cast_ArrayType(Ty);
    if ((ATy != null)) {
      Constant /*P*/ N = ConstantExpr.getCast(CastInst.getCastOpcode(FieldNo, false, 
              DestTy, false), 
          FieldNo, DestTy);
      Constant /*P*/ E = getFoldedSizeOf(ATy.getElementType(), DestTy, true);
      return ConstantExpr.getNUWMul(E, N);
    }
  }
  {
    
    StructType /*P*/ STy = dyn_cast_StructType(Ty);
    if ((STy != null)) {
      if (!STy.isPacked()) {
        /*uint*/int NumElems = STy.getNumElements();
        // An empty struct has no members.
        if (NumElems == 0) {
          return null;
        }
        // Check for a struct with all members having the same size.
        Constant /*P*/ MemberSize = getFoldedSizeOf(STy.getElementType(0), DestTy, true);
        boolean AllSame = true;
        for (/*uint*/int i = 1; i != NumElems; ++i)  {
          if (MemberSize
             != getFoldedSizeOf(STy.getElementType(i), DestTy, true)) {
            AllSame = false;
            break;
          }
        }
        if (AllSame) {
          Constant /*P*/ N = ConstantExpr.getCast(CastInst.getCastOpcode(FieldNo, 
                  false, 
                  DestTy, 
                  false), 
              FieldNo, DestTy);
          return ConstantExpr.getNUWMul(MemberSize, N);
        }
      }
    }
  }
  
  // If there's no interesting folding happening, bail so that we don't create
  // a constant that looks like it needs folding but really doesn't.
  if (!Folded) {
    return null;
  }
  
  // Base case: Get a regular offsetof expression.
  Constant /*P*/ C = ConstantExpr.getOffsetOf(Ty, FieldNo);
  C = ConstantExpr.getCast(CastInst.getCastOpcode(C, false, 
          DestTy, false), 
      C, DestTy);
  return C;
}


/// This type is zero-sized if it's an array or structure of zero-sized types.
/// The only leaf zero-sized type is an empty structure.
//<editor-fold defaultstate="collapsed" desc="isMaybeZeroSizedType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 1277,
 FQN="isMaybeZeroSizedType", NM="_ZL20isMaybeZeroSizedTypePN4llvm4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZL20isMaybeZeroSizedTypePN4llvm4TypeE")
//</editor-fold>
public static boolean isMaybeZeroSizedType(Type /*P*/ Ty) {
  {
    StructType /*P*/ STy = dyn_cast_StructType(Ty);
    if ((STy != null)) {
      if (STy.isOpaque()) {
        return true; // Can't say.
      }
      
      // If all of elements have zero size, this does too.
      for (/*uint*/int i = 0, e = STy.getNumElements(); i != e; ++i)  {
        if (!isMaybeZeroSizedType(STy.getElementType(i))) {
          return false;
        }
      }
      return true;
    } else {
      ArrayType /*P*/ ATy = dyn_cast_ArrayType(Ty);
      if ((ATy != null)) {
        return isMaybeZeroSizedType(ATy.getElementType());
      }
    }
  }
  return false;
}


/// Compare the two constants as though they were getelementptr indices.
/// This allows coercion of the types to be the same thing.
///
/// If the two constants are the "same" (after coercion), return 0.  If the
/// first is less than the second, return -1, if the second is less than the
/// first, return 1.  If the constants are not integral, return -2.
///
//<editor-fold defaultstate="collapsed" desc="IdxCompare">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 1299,
 FQN="IdxCompare", NM="_ZL10IdxComparePN4llvm8ConstantES1_PNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZL10IdxComparePN4llvm8ConstantES1_PNS_4TypeE")
//</editor-fold>
public static int IdxCompare(Constant /*P*/ C1, Constant /*P*/ C2, Type /*P*/ ElTy) {
  if (C1 == C2) {
    return 0;
  }
  
  // Ok, we found a different index.  If they are not ConstantInt, we can't do
  // anything with them.
  if (!isa_ConstantInt(C1) || !isa_ConstantInt(C2)) {
    return -2; // don't know!
  }
  
  // We cannot compare the indices if they don't fit in an int64_t.
  if ($greater_uint(cast_ConstantInt(C1).getValue().getActiveBits(), 64)
     || $greater_uint(cast_ConstantInt(C2).getValue().getActiveBits(), 64)) {
    return -2; // don't know!
  }
  
  // Ok, we have two differing integer indices.  Sign extend them to be the same
  // type.
  long/*int64_t*/ C1Val = cast_ConstantInt(C1).getSExtValue();
  long/*int64_t*/ C2Val = cast_ConstantInt(C2).getSExtValue();
  if (C1Val == C2Val) {
    return 0; // They are equal
  }
  
  // If the type being indexed over is really just a zero sized type, there is
  // no pointer difference being made here.
  if (isMaybeZeroSizedType(ElTy)) {
    return -2; // dunno.
  }
  
  // If they are really different, now that they are the same type, then we
  // found a difference!
  if (C1Val < C2Val) {
    return -1;
  } else {
    return 1;
  }
}


/// This function determines if there is anything we can decide about the two
/// constants provided. This doesn't need to handle simple things like
/// ConstantFP comparisons, but should instead handle ConstantExprs.
/// If we can determine that the two constants have a particular relation to
/// each other, we should return the corresponding FCmpInst predicate,
/// otherwise return FCmpInst::BAD_FCMP_PREDICATE. This is used below in
/// ConstantFoldCompareInstruction.
///
/// To simplify this code we canonicalize the relation so that the first
/// operand is always the most "complex" of the two.  We consider ConstantFP
/// to be the simplest, and ConstantExprs to be the most complex.
//<editor-fold defaultstate="collapsed" desc="evaluateFCmpRelation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 1343,
 FQN="evaluateFCmpRelation", NM="_ZL20evaluateFCmpRelationPN4llvm8ConstantES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZL20evaluateFCmpRelationPN4llvm8ConstantES1_")
//</editor-fold>
public static FCmpInst.Predicate evaluateFCmpRelation(Constant /*P*/ V1, Constant /*P*/ V2) {
  assert (V1.getType() == V2.getType()) : "Cannot compare values of different types!";
  
  // Handle degenerate case quickly
  if (V1 == V2) {
    return FCmpInst.Predicate.FCMP_OEQ;
  }
  if (!isa_ConstantExpr(V1)) {
    if (!isa_ConstantExpr(V2)) {
      // Simple case, use the standard constant folder.
      ConstantInt /*P*/ R = null;
      R = dyn_cast_ConstantInt(ConstantExpr.getFCmp(FCmpInst.Predicate.FCMP_OEQ.getValue(), V1, V2));
      if ((R != null) && !R.isZero()) {
        return FCmpInst.Predicate.FCMP_OEQ;
      }
      R = dyn_cast_ConstantInt(ConstantExpr.getFCmp(FCmpInst.Predicate.FCMP_OLT.getValue(), V1, V2));
      if ((R != null) && !R.isZero()) {
        return FCmpInst.Predicate.FCMP_OLT;
      }
      R = dyn_cast_ConstantInt(ConstantExpr.getFCmp(FCmpInst.Predicate.FCMP_OGT.getValue(), V1, V2));
      if ((R != null) && !R.isZero()) {
        return FCmpInst.Predicate.FCMP_OGT;
      }
      
      // Nothing more we can do
      return FCmpInst.Predicate.BAD_FCMP_PREDICATE;
    }
    
    // If the first operand is simple and second is ConstantExpr, swap operands.
    FCmpInst.Predicate SwappedRelation = evaluateFCmpRelation(V2, V1);
    if (SwappedRelation != FCmpInst.Predicate.BAD_FCMP_PREDICATE) {
      return FCmpInst.getSwappedPredicate(SwappedRelation);
    }
  } else {
    // Ok, the LHS is known to be a constantexpr.  The RHS can be any of a
    // constantexpr or a simple constant.
    ConstantExpr /*P*/ CE1 = cast_ConstantExpr(V1);
    switch (CE1.getOpcode()) {
     case Instruction.CastOps.FPTrunc:
     case Instruction.CastOps.FPExt:
     case Instruction.CastOps.UIToFP:
     case Instruction.CastOps.SIToFP:
      // We might be able to do something with these but we don't right now.
      break;
     default:
      break;
    }
  }
  // There are MANY other foldings that we could perform here.  They will
  // probably be added on demand, as they seem needed.
  return FCmpInst.Predicate.BAD_FCMP_PREDICATE;
}

//<editor-fold defaultstate="collapsed" desc="areGlobalsPotentiallyEqual">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 1395,
 FQN="areGlobalsPotentiallyEqual", NM="_ZL26areGlobalsPotentiallyEqualPKN4llvm11GlobalValueES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZL26areGlobalsPotentiallyEqualPKN4llvm11GlobalValueES2_")
//</editor-fold>
public static ICmpInst.Predicate areGlobalsPotentiallyEqual(/*const*/ GlobalValue /*P*/ GV1, 
                          /*const*/ GlobalValue /*P*/ GV2) {
  GlobalValue2Bool isGlobalUnsafeForEquality = /*[]*/ (/*const*/ GlobalValue /*P*/ GV) -> {
        if (GV.hasExternalWeakLinkage() || GV.hasWeakAnyLinkage()) {
          return true;
        }
        {
          /*const*/ GlobalVariable /*P*/ GVar = dyn_cast_GlobalVariable(GV);
          if ((GVar != null)) {
            Type /*P*/ Ty = GVar.getValueType();
            // A global with opaque type might end up being zero sized.
            if (!Ty.isSized()) {
              return true;
            }
            // A global with an empty type might lie at the address of any other
            // global.
            if (Ty.isEmptyTy()) {
              return true;
            }
          }
        }
        return false;
      };
  // Don't try to decide equality of aliases.
  if (!isa_GlobalAlias(GV1) && !isa_GlobalAlias(GV2)) {
    if (!isGlobalUnsafeForEquality.$call(GV1) && !isGlobalUnsafeForEquality.$call(GV2)) {
      return ICmpInst.Predicate.ICMP_NE;
    }
  }
  return ICmpInst.Predicate.BAD_ICMP_PREDICATE;
}


/// This function determines if there is anything we can decide about the two
/// constants provided. This doesn't need to handle simple things like integer
/// comparisons, but should instead handle ConstantExprs and GlobalValues.
/// If we can determine that the two constants have a particular relation to
/// each other, we should return the corresponding ICmp predicate, otherwise
/// return ICmpInst::BAD_ICMP_PREDICATE.
///
/// To simplify this code we canonicalize the relation so that the first
/// operand is always the most "complex" of the two.  We consider simple
/// constants (like ConstantInt) to be the simplest, followed by
/// GlobalValues, followed by ConstantExpr's (the most complex).
///
//<editor-fold defaultstate="collapsed" desc="evaluateICmpRelation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 1431,
 FQN="evaluateICmpRelation", NM="_ZL20evaluateICmpRelationPN4llvm8ConstantES1_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZL20evaluateICmpRelationPN4llvm8ConstantES1_b")
//</editor-fold>
public static ICmpInst.Predicate evaluateICmpRelation(Constant /*P*/ V1, Constant /*P*/ V2, 
                    boolean isSigned) {
  assert (V1.getType() == V2.getType()) : "Cannot compare different types of values!";
  if (V1 == V2) {
    return ICmpInst.Predicate.ICMP_EQ;
  }
  if (!isa_ConstantExpr(V1) && !isa_GlobalValue(V1)
     && !isa_BlockAddress(V1)) {
    if (!isa_GlobalValue(V2) && !isa_ConstantExpr(V2)
       && !isa_BlockAddress(V2)) {
      // We distilled this down to a simple case, use the standard constant
      // folder.
      ConstantInt /*P*/ R = null;
      ICmpInst.Predicate pred = ICmpInst.Predicate.ICMP_EQ;
      R = dyn_cast_ConstantInt(ConstantExpr.getICmp(pred.getValue(), V1, V2));
      if ((R != null) && !R.isZero()) {
        return pred;
      }
      pred = isSigned ? ICmpInst.Predicate.ICMP_SLT : ICmpInst.Predicate.ICMP_ULT;
      R = dyn_cast_ConstantInt(ConstantExpr.getICmp(pred.getValue(), V1, V2));
      if ((R != null) && !R.isZero()) {
        return pred;
      }
      pred = isSigned ? ICmpInst.Predicate.ICMP_SGT : ICmpInst.Predicate.ICMP_UGT;
      R = dyn_cast_ConstantInt(ConstantExpr.getICmp(pred.getValue(), V1, V2));
      if ((R != null) && !R.isZero()) {
        return pred;
      }
      
      // If we couldn't figure it out, bail.
      return ICmpInst.Predicate.BAD_ICMP_PREDICATE;
    }
    
    // If the first operand is simple, swap operands.
    ICmpInst.Predicate SwappedRelation = evaluateICmpRelation(V2, V1, isSigned);
    if (SwappedRelation != ICmpInst.Predicate.BAD_ICMP_PREDICATE) {
      return ICmpInst.getSwappedPredicate(SwappedRelation);
    }
  } else {
    /*const*/ GlobalValue /*P*/ GV = dyn_cast_GlobalValue(V1);
    if ((GV != null)) {
      if (isa_ConstantExpr(V2)) { // Swap as necessary.
        ICmpInst.Predicate SwappedRelation = evaluateICmpRelation(V2, V1, isSigned);
        if (SwappedRelation != ICmpInst.Predicate.BAD_ICMP_PREDICATE) {
          return ICmpInst.getSwappedPredicate(SwappedRelation);
        }
        return ICmpInst.Predicate.BAD_ICMP_PREDICATE;
      }
      {
        
        // Now we know that the RHS is a GlobalValue, BlockAddress or simple
        // constant (which, since the types must match, means that it's a
        // ConstantPointerNull).
        /*const*/ GlobalValue /*P*/ GV2 = dyn_cast_GlobalValue(V2);
        if ((GV2 != null)) {
          return areGlobalsPotentiallyEqual(GV, GV2);
        } else if (isa_BlockAddress(V2)) {
          return ICmpInst.Predicate.ICMP_NE; // Globals never equal labels.
        } else {
          assert (isa_ConstantPointerNull(V2)) : "Canonicalization guarantee!";
          // GlobalVals can never be null unless they have external weak linkage.
          // We don't try to evaluate aliases here.
          if (!GV.hasExternalWeakLinkage() && !isa_GlobalAlias(GV)) {
            return ICmpInst.Predicate.ICMP_NE;
          }
        }
      }
    } else {
      /*const*/ BlockAddress /*P*/ BA = dyn_cast_BlockAddress(V1);
      if ((BA != null)) {
        if (isa_ConstantExpr(V2)) { // Swap as necessary.
          ICmpInst.Predicate SwappedRelation = evaluateICmpRelation(V2, V1, isSigned);
          if (SwappedRelation != ICmpInst.Predicate.BAD_ICMP_PREDICATE) {
            return ICmpInst.getSwappedPredicate(SwappedRelation);
          }
          return ICmpInst.Predicate.BAD_ICMP_PREDICATE;
        }
        {
          
          // Now we know that the RHS is a GlobalValue, BlockAddress or simple
          // constant (which, since the types must match, means that it is a
          // ConstantPointerNull).
          /*const*/ BlockAddress /*P*/ BA2 = dyn_cast_BlockAddress(V2);
          if ((BA2 != null)) {
            // Block address in another function can't equal this one, but block
            // addresses in the current function might be the same if blocks are
            // empty.
            if (BA2.getFunction() != BA.getFunction()) {
              return ICmpInst.Predicate.ICMP_NE;
            }
          } else {
            // Block addresses aren't null, don't equal the address of globals.
            assert ((isa_ConstantPointerNull(V2) || isa_GlobalValue(V2))) : "Canonicalization guarantee!";
            return ICmpInst.Predicate.ICMP_NE;
          }
        }
      } else {
        // Ok, the LHS is known to be a constantexpr.  The RHS can be any of a
        // constantexpr, a global, block address, or a simple constant.
        ConstantExpr /*P*/ CE1 = cast_ConstantExpr(V1);
        Constant /*P*/ CE1Op0 = CE1.getOperand_Constant(0);
        switch (CE1.getOpcode()) {
         case Instruction.CastOps.Trunc:
         case Instruction.CastOps.FPTrunc:
         case Instruction.CastOps.FPExt:
         case Instruction.CastOps.FPToUI:
         case Instruction.CastOps.FPToSI:
          break; // We can't evaluate floating point casts or truncations.
         case Instruction.CastOps.UIToFP:
         case Instruction.CastOps.SIToFP:
         case Instruction.CastOps.BitCast:
         case Instruction.CastOps.ZExt:
         case Instruction.CastOps.SExt:
          // We can't evaluate floating point casts or truncations.
          if (CE1Op0.getType().isFloatingPointTy()) {
            break;
          }
          
          // If the cast is not actually changing bits, and the second operand is a
          // null pointer, do the comparison with the pre-casted value.
          if (V2.isNullValue()
             && (CE1.getType().isPointerTy() || CE1.getType().isIntegerTy())) {
            if (CE1.getOpcode() == Instruction.CastOps.ZExt) {
              isSigned = false;
            }
            if (CE1.getOpcode() == Instruction.CastOps.SExt) {
              isSigned = true;
            }
            return evaluateICmpRelation(CE1Op0, 
                Constant.getNullValue(CE1Op0.getType()), 
                isSigned);
          }
          break;
         case Instruction.MemoryOps.GetElementPtr:
          {
            GEPOperator /*P*/ CE1GEP = cast_GEPOperator(CE1);
            // Ok, since this is a getelementptr, we know that the constant has a
            // pointer type.  Check the various cases.
            if (isa_ConstantPointerNull(V2)) {
              {
                // If we are comparing a GEP to a null pointer, check to see if the base
                // of the GEP equals the null pointer.
                /*const*/ GlobalValue /*P*/ GV$1 = dyn_cast_GlobalValue(CE1Op0);
                if ((GV$1 != null)) {
                  if (GV$1.hasExternalWeakLinkage()) {
                    // Weak linkage GVals could be zero or not. We're comparing that
                    // to null pointer so its greater-or-equal
                    return isSigned ? ICmpInst.Predicate.ICMP_SGE : ICmpInst.Predicate.ICMP_UGE;
                  } else {
                    // If its not weak linkage, the GVal must have a non-zero address
                    // so the result is greater-than
                    return isSigned ? ICmpInst.Predicate.ICMP_SGT : ICmpInst.Predicate.ICMP_UGT;
                  }
                } else if (isa_ConstantPointerNull(CE1Op0)) {
                  // If we are indexing from a null pointer, check to see if we have any
                  // non-zero indices.
                  for (/*uint*/int i = 1, e = CE1.getNumOperands(); i != e; ++i)  {
                    if (!CE1.getOperand_Constant(i).isNullValue()) {
                      // Offsetting from null, must not be equal.
                      return isSigned ? ICmpInst.Predicate.ICMP_SGT : ICmpInst.Predicate.ICMP_UGT;
                    }
                  }
                  // Only zero indexes from null, must still be zero.
                  return ICmpInst.Predicate.ICMP_EQ;
                }
              }
              // Otherwise, we can't really say if the first operand is null or not.
            } else {
              /*const*/ GlobalValue /*P*/ GV2 = dyn_cast_GlobalValue(V2);
              if ((GV2 != null)) {
                if (isa_ConstantPointerNull(CE1Op0)) {
                  if (GV2.hasExternalWeakLinkage()) {
                    // Weak linkage GVals could be zero or not. We're comparing it to
                    // a null pointer, so its less-or-equal
                    return isSigned ? ICmpInst.Predicate.ICMP_SLE : ICmpInst.Predicate.ICMP_ULE;
                  } else {
                    // If its not weak linkage, the GVal must have a non-zero address
                    // so the result is less-than
                    return isSigned ? ICmpInst.Predicate.ICMP_SLT : ICmpInst.Predicate.ICMP_ULT;
                  }
                } else {
                  /*const*/ GlobalValue /*P*/ GV$1 = dyn_cast_GlobalValue(CE1Op0);
                  if ((GV$1 != null)) {
                    if (GV$1 == GV2) {
                      // If this is a getelementptr of the same global, then it must be
                      // different.  Because the types must match, the getelementptr could
                      // only have at most one index, and because we fold getelementptr's
                      // with a single zero index, it must be nonzero.
                      assert (CE1.getNumOperands() == 2 && !CE1.getOperand_Constant(1).isNullValue()) : "Surprising getelementptr!";
                      return isSigned ? ICmpInst.Predicate.ICMP_SGT : ICmpInst.Predicate.ICMP_UGT;
                    } else {
                      if (CE1GEP.hasAllZeroIndices()) {
                        return areGlobalsPotentiallyEqual(GV$1, GV2);
                      }
                      return ICmpInst.Predicate.BAD_ICMP_PREDICATE;
                    }
                  }
                }
              } else {
                ConstantExpr /*P*/ CE2 = cast_ConstantExpr(V2);
                Constant /*P*/ CE2Op0 = CE2.getOperand_Constant(0);
                
                // There are MANY other foldings that we could perform here.  They will
                // probably be added on demand, as they seem needed.
                switch (CE2.getOpcode()) {
                 default:
                  break;
                 case Instruction.MemoryOps.GetElementPtr:
                  // By far the most common case to handle is when the base pointers are
                  // obviously to the same global.
                  if (isa_GlobalValue(CE1Op0) && isa_GlobalValue(CE2Op0)) {
                    // Don't know relative ordering, but check for inequality.
                    if (CE1Op0 != CE2Op0) {
                      GEPOperator /*P*/ CE2GEP = cast_GEPOperator(CE2);
                      if (CE1GEP.hasAllZeroIndices() && CE2GEP.hasAllZeroIndices()) {
                        return areGlobalsPotentiallyEqual(cast_GlobalValue(CE1Op0), 
                            cast_GlobalValue(CE2Op0));
                      }
                      return ICmpInst.Predicate.BAD_ICMP_PREDICATE;
                    }
                    // Ok, we know that both getelementptr instructions are based on the
                    // same global.  From this, we can precisely determine the relative
                    // ordering of the resultant pointers.
                    /*uint*/int i = 1;
                    
                    // The logic below assumes that the result of the comparison
                    // can be determined by finding the first index that differs.
                    // This doesn't work if there is over-indexing in any
                    // subsequent indices, so check for that case first.
                    if (!CE1.isGEPWithNoNotionalOverIndexing()
                       || !CE2.isGEPWithNoNotionalOverIndexing()) {
                      return ICmpInst.Predicate.BAD_ICMP_PREDICATE; // Might be equal.
                    }
                    
                    // Compare all of the operands the GEP's have in common.
                    generic_gep_type_iterator GTI = IrLlvmGlobals.gep_type_begin_User$C$P(CE1);
                    for (; i != CE1.getNumOperands() && i != CE2.getNumOperands();
                         ++i , GTI.$preInc())  {
                      switch (IdxCompare(CE1.getOperand_Constant(i), 
                          CE2.getOperand_Constant(i), GTI.getIndexedType())) {
                       case -1:
                        return isSigned ? ICmpInst.Predicate.ICMP_SLT : ICmpInst.Predicate.ICMP_ULT;
                       case 1:
                        return isSigned ? ICmpInst.Predicate.ICMP_SGT : ICmpInst.Predicate.ICMP_UGT;
                       case -2:
                        return ICmpInst.Predicate.BAD_ICMP_PREDICATE;
                      }
                    }
                    
                    // Ok, we ran out of things they have in common.  If any leftovers
                    // are non-zero then we have a difference, otherwise we are equal.
                    for (; $less_uint(i, CE1.getNumOperands()); ++i)  {
                      if (!CE1.getOperand_Constant(i).isNullValue()) {
                        if (isa_ConstantInt(CE1.getOperand_Constant(i))) {
                          return isSigned ? ICmpInst.Predicate.ICMP_SGT : ICmpInst.Predicate.ICMP_UGT;
                        } else {
                          return ICmpInst.Predicate.BAD_ICMP_PREDICATE; // Might be equal.
                        }
                      }
                    }
                    
                    for (; $less_uint(i, CE2.getNumOperands()); ++i)  {
                      if (!CE2.getOperand_Constant(i).isNullValue()) {
                        if (isa_ConstantInt(CE2.getOperand_Constant(i))) {
                          return isSigned ? ICmpInst.Predicate.ICMP_SLT : ICmpInst.Predicate.ICMP_ULT;
                        } else {
                          return ICmpInst.Predicate.BAD_ICMP_PREDICATE; // Might be equal.
                        }
                      }
                    }
                    return ICmpInst.Predicate.ICMP_EQ;
                  }
                }
              }
            }
          }
         default:
          break;
        }
      }
    }
  }
  
  return ICmpInst.Predicate.BAD_ICMP_PREDICATE;
}


/// Test whether the given sequence of *normalized* indices is "inbounds".
/*template <typename IndexTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="isInBoundsIndices">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 2001,
 FQN="isInBoundsIndices", NM="Tpl__ZL17isInBoundsIndicesN4llvm8ArrayRefIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=Tpl__ZL17isInBoundsIndicesN4llvm8ArrayRefIT_EE")
//</editor-fold>
public static </*typename*/ IndexTy extends Value> boolean isInBoundsIndices(ArrayRef<IndexTy> Idxs) {
  // No indices means nothing that could be out of bounds.
  if (Idxs.empty()) {
    return true;
  }
  
  // If the first index is zero, it's in bounds.
  if (cast_Constant(Idxs.$at(0)).isNullValue()) {
    return true;
  }
  
  // If the first index is one and all the rest are zero, it's in bounds,
  // by the one-past-the-end rule.
  if (Native.$not(cast_ConstantInt(Idxs.$at(0)).isOne())) {
    return false;
  }
  for (/*uint*/int i = 1, e = Idxs.size(); i != e; ++i)  {
    if (Native.$not(cast_Constant(Idxs.$at(i)).isNullValue())) {
      return false;
    }
  }
  return true;
}


/// Test whether a given ConstantInt is in-range for a SequentialType.
//<editor-fold defaultstate="collapsed" desc="isIndexInRangeOfSequentialType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 2019,
 FQN="isIndexInRangeOfSequentialType", NM="_ZL30isIndexInRangeOfSequentialTypePN4llvm14SequentialTypeEPKNS_11ConstantIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=_ZL30isIndexInRangeOfSequentialTypePN4llvm14SequentialTypeEPKNS_11ConstantIntE")
//</editor-fold>
public static boolean isIndexInRangeOfSequentialType(SequentialType /*P*/ STy, 
                              /*const*/ ConstantInt /*P*/ CI) {
  // And indices are valid when indexing along a pointer
  if (isa_PointerType(STy)) {
    return true;
  }
  
  long/*uint64_t*/ NumElements = $int2ulong(0);
  {
    // Determine the number of elements in our sequential type.
    ArrayType /*P*/ ATy = dyn_cast_ArrayType(STy);
    if ((ATy != null)) {
      NumElements = ATy.getNumElements();
    } else {
      VectorType /*P*/ VTy = dyn_cast_VectorType(STy);
      if ((VTy != null)) {
        NumElements = $uint2ulong(VTy.getNumElements());
      }
    }
  }
  assert ((isa_ArrayType(STy) || $greater_ulong_ullong(NumElements, $int2ullong(0)))) : "didn't expect non-array type to have zero elements!";
  
  // We cannot bounds check the index if it doesn't fit in an int64_t.
  if ($greater_uint(CI.getValue().getActiveBits(), 64)) {
    return false;
  }
  
  // A negative index or an index past the end of our sequential type is
  // considered out-of-range.
  long/*int64_t*/ IndexVal = CI.getSExtValue();
  if (IndexVal < 0 || ($greater_ulong_ullong(NumElements, $int2ullong(0)) && $greatereq_ulong((long/*uint64_t*/)IndexVal, NumElements))) {
    return false;
  }
  
  // Otherwise, it is in-range.
  return true;
}

/*template <typename IndexTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="ConstantFoldGetElementPtrImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp", line = 2050,
 FQN="ConstantFoldGetElementPtrImpl", NM="Tpl__ZL29ConstantFoldGetElementPtrImplPN4llvm4TypeEPNS_8ConstantEbNS_8ArrayRefIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantFold.cpp -nm=Tpl__ZL29ConstantFoldGetElementPtrImplPN4llvm4TypeEPNS_8ConstantEbNS_8ArrayRefIT_EE")
//</editor-fold>
public static </*typename*/ IndexTy extends Value> Constant /*P*/ ConstantFoldGetElementPtrImpl(Type /*P*/ PointeeTy, Constant /*P*/ C, 
                             boolean inBounds, 
                             ArrayRef<IndexTy> Idxs) {
  if (Idxs.empty()) {
    return C;
  }
  Constant /*P*/ Idx0 = cast_Constant(Idxs.$at(0));
  if ((Native.$bool(Native.$eq(Idxs.size(), 1)) && Idx0.isNullValue())) {
    return C;
  }
  if (isa_UndefValue(C)) {
    PointerType /*P*/ PtrTy = cast_PointerType(C.getType().getScalarType());
    Type /*P*/ Ty = GetElementPtrInst.getIndexedType_Type$P_ArrayRef$Value$P(PointeeTy, (ArrayRef<Value>) Idxs);
    assert ((Ty != null)) : "Invalid indices for GEP!";
    Type /*P*/ GEPTy = PointerType.get(Ty, PtrTy.getAddressSpace());
    {
      VectorType /*P*/ VT = dyn_cast_VectorType(C.getType());
      if ((VT != null)) {
        GEPTy = VectorType.get(GEPTy, VT.getNumElements());
      }
    }
    return UndefValue.get(GEPTy);
  }
  if (C.isNullValue()) {
    boolean isNull = true;
    for (/*uint*/int i = 0, e = Idxs.size(); i != e; ++i)  {
      if (Native.$not(cast_Constant(Idxs.$at(i)).isNullValue())) {
        isNull = false;
        break;
      }
    }
    if (isNull) {
      PointerType /*P*/ PtrTy = cast_PointerType(C.getType().getScalarType());
      Type /*P*/ Ty = GetElementPtrInst.getIndexedType_Type$P_ArrayRef$Value$P(PointeeTy, (ArrayRef<Value>) Idxs);
      assert ((Ty != null)) : "Invalid indices for GEP!";
      Type /*P*/ GEPTy = PointerType.get(Ty, PtrTy.getAddressSpace());
      {
        VectorType /*P*/ VT = dyn_cast_VectorType(C.getType());
        if ((VT != null)) {
          GEPTy = VectorType.get(GEPTy, VT.getNumElements());
        }
      }
      return Constant.getNullValue(GEPTy);
    }
  }
  {
    
    ConstantExpr /*P*/ CE = dyn_cast_ConstantExpr(C);
    if ((CE != null)) {
      // Combine Indices - If the source pointer to this getelementptr instruction
      // is a getelementptr instruction, combine the indices of the two
      // getelementptr instructions into a single instruction.
      //
      if (CE.getOpcode() == Instruction.MemoryOps.GetElementPtr) {
        Type /*P*/ LastTy = null;
        for (generic_gep_type_iterator I = IrLlvmGlobals.gep_type_begin_User$C$P(CE), E = IrLlvmGlobals.gep_type_end_User$C$P(CE);
             I.$noteq(E); I.$preInc())  {
          LastTy = I.$star();
        }
        
        // We cannot combine indices if doing so would take us outside of an
        // array or vector.  Doing otherwise could trick us if we evaluated such a
        // GEP as part of a load.
        //
        // e.g. Consider if the original GEP was:
        // i8* getelementptr ({ [2 x i8], i32, i8, [3 x i8] }* @main.c,
        //                    i32 0, i32 0, i64 0)
        //
        // If we then tried to offset it by '8' to get to the third element,
        // an i8, we should *not* get:
        // i8* getelementptr ({ [2 x i8], i32, i8, [3 x i8] }* @main.c,
        //                    i32 0, i32 0, i64 8)
        //
        // This GEP tries to index array element '8  which runs out-of-bounds.
        // Subsequent evaluation would get confused and produce erroneous results.
        //
        // The following prohibits such a GEP from being formed by checking to see
        // if the index is in-range with respect to an array or vector.
        boolean PerformFold = false;
        if (Idx0.isNullValue()) {
          PerformFold = true;
        } else {
          SequentialType /*P*/ STy = dyn_cast_or_null_SequentialType(LastTy);
          if ((STy != null)) {
            {
              ConstantInt /*P*/ CI = dyn_cast_ConstantInt(Idx0);
              if ((CI != null)) {
                PerformFold = isIndexInRangeOfSequentialType(STy, CI);
              }
            }
          }
        }
        if (PerformFold) {
          SmallVector<Value /*P*/ > NewIndices/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
          NewIndices.reserve(Native.$add(Idxs.size(), CE.getNumOperands()));
          NewIndices.append_T(CE.op_begin().$add(1), CE.op_end().$sub(1), (Use from) -> from.get());
          
          // Add the last index of the source with the first index of the new GEP.
          // Make sure to handle the case when they are actually different types.
          Constant /*P*/ Combined = CE.getOperand_Constant(CE.getNumOperands() - 1);
          // Otherwise it must be an array.
          if (!Idx0.isNullValue()) {
            Type /*P*/ IdxTy = Combined.getType();
            if (IdxTy != Idx0.getType()) {
              /*uint*/int CommonExtendedWidth = std.max(IdxTy.getIntegerBitWidth(), 
                  Idx0.getType().getIntegerBitWidth());
              CommonExtendedWidth = std.max(CommonExtendedWidth, 64/*U*/);
              
              Type /*P*/ CommonTy = Type.getIntNTy(IdxTy.getContext(), CommonExtendedWidth);
              Constant /*P*/ C1 = ConstantExpr.getSExtOrBitCast(Idx0, CommonTy);
              Constant /*P*/ C2 = ConstantExpr.getSExtOrBitCast(Combined, CommonTy);
              Combined = ConstantExpr.get(Instruction.BinaryOps.Add, C1, C2);
            } else {
              Combined
                 = ConstantExpr.get(Instruction.BinaryOps.Add, Idx0, Combined);
            }
          }
          
          NewIndices.push_back(Combined);
          NewIndices.append_T(Native.$add(Idxs.begin(), 1), Idxs.end());
          return ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P_bool_Type$P(cast_GEPOperator(CE).getSourceElementType(), CE.getOperand_Constant(0), 
              new ArrayRef<Value /*P*/ >(NewIndices, true), inBounds && cast_GEPOperator(CE).isInBounds());
        }
      }
      
      // Attempt to fold casts to the same type away.  For example, folding:
      //
      //   i32* getelementptr ([2 x i32]* bitcast ([3 x i32]* %X to [2 x i32]*),
      //                       i64 0, i64 0)
      // into:
      //
      //   i32* getelementptr ([3 x i32]* %X, i64 0, i64 0)
      //
      // Don't fold if the cast is changing address spaces.
      if (Native.$bool(CE.isCast() && Native.$greater(Idxs.size(), 1)) && Idx0.isNullValue()) {
        PointerType /*P*/ SrcPtrTy = dyn_cast_PointerType(CE.getOperand_Constant(0).getType());
        PointerType /*P*/ DstPtrTy = dyn_cast_PointerType(CE.getType());
        if ((SrcPtrTy != null) && (DstPtrTy != null)) {
          ArrayType /*P*/ SrcArrayTy = dyn_cast_ArrayType(SrcPtrTy.getElementType());
          ArrayType /*P*/ DstArrayTy = dyn_cast_ArrayType(DstPtrTy.getElementType());
          if ((SrcArrayTy != null) && (DstArrayTy != null)
             && SrcArrayTy.getElementType() == DstArrayTy.getElementType()
             && SrcPtrTy.getAddressSpace() == DstPtrTy.getAddressSpace()) {
            return ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P_bool_Type$P(SrcArrayTy, (Constant /*P*/ )CE.getOperand_Constant(0), (ArrayRef<Value>) Idxs, inBounds);
          }
        }
      }
    }
  }
  
  // Check to see if any array indices are not within the corresponding
  // notional array or vector bounds. If so, try to determine if they can be
  // factored out into preceding dimensions.
  SmallVector<Constant /*P*/ > NewIdxs/*J*/= new SmallVector<Constant /*P*/ >(8, (Constant /*P*/ )null);
  Type /*P*/ Ty = PointeeTy;
  Type /*P*/ Prev = C.getType();
  boolean Unknown = Native.$not(isa_ConstantInt(Idxs.$at(0)));
  for (/*uint*/int i = 1, e = Idxs.size(); i != e;
       Prev = Ty , Ty = cast_CompositeType(Ty).getTypeAtIndex(Idxs.$at(i)) , ++i) {
    ConstantInt /*P*/ CI = dyn_cast_ConstantInt(Idxs.$at(i));
    if (Native.$not(CI)) {
      // We don't know if it's in range or not.
      Unknown = true;
      continue;
    }
    if (isa_StructType(Ty)) {
      // The verify makes sure that GEPs into a struct are in range.
      continue;
    }
    SequentialType /*P*/ STy = cast_SequentialType(Ty);
    if (isa_PointerType(STy)) {
      // We don't know if it's in range or not.
      Unknown = true;
      continue;
    }
    if (isa_VectorType(STy)) {
      // There can be awkward padding in after a non-power of two vector.
      Unknown = true;
      continue;
    }
    if (isIndexInRangeOfSequentialType(STy, CI)) {
      // It's in range, skip to the next index.
      continue;
    }
    if (!isa_SequentialType(Prev)) {
      // It's out of range, but the prior dimension is a struct
      // so we can't do anything about it.
      Unknown = true;
      continue;
    }
    if (Native.$less(CI.getSExtValue(), 0)) {
      // It's out of range and negative, don't try to factor it.
      Unknown = true;
      continue;
    }
    // It's out of range, but we can factor it into the prior
    // dimension.
    NewIdxs.resize(Idxs.size());
    // Determine the number of elements in our sequential type.
    long/*uint64_t*/ NumElements = STy.getArrayNumElements();
    
    ConstantInt /*P*/ Factor = ConstantInt.get(CI.getType(), NumElements);
    NewIdxs.$set(i, ConstantExpr.getSRem(CI, Factor));
    
    Constant /*P*/ PrevIdx = cast_Constant(Idxs.$at(i - 1));
    Constant /*P*/ Div = ConstantExpr.getSDiv(CI, Factor);
    
    /*uint*/int CommonExtendedWidth = std.max(PrevIdx.getType().getIntegerBitWidth(), 
        Div.getType().getIntegerBitWidth());
    CommonExtendedWidth = std.max(CommonExtendedWidth, 64/*U*/);
    
    // Before adding, extend both operands to i64 to avoid
    // overflow trouble.
    if (!PrevIdx.getType().isIntegerTy(CommonExtendedWidth)) {
      PrevIdx = ConstantExpr.getSExt(PrevIdx, Type.getIntNTy(Div.getContext(), CommonExtendedWidth));
    }
    if (!Div.getType().isIntegerTy(CommonExtendedWidth)) {
      Div = ConstantExpr.getSExt(Div, Type.getIntNTy(Div.getContext(), CommonExtendedWidth));
    }
    
    NewIdxs.$set(i - 1, ConstantExpr.getAdd(PrevIdx, Div));
  }
  
  // If we did any factoring, start over with the adjusted indices.
  if (!NewIdxs.empty()) {
    for (/*uint*/int i = 0, e = Idxs.size(); i != e; ++i)  {
      if (!(NewIdxs.$at(i) != null)) {
        NewIdxs.$set(i, cast_Constant(Idxs.$at(i)));
      }
    }
    return ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P(PointeeTy, C, new ArrayRef<Constant /*P*/ >(NewIdxs, true), inBounds);
  }
  
  // If all indices are known integers and normalized, we can do a simple
  // check for the "inbounds" property.
  if (!Unknown && !inBounds) {
    {
      GlobalVariable /*P*/ GV = dyn_cast_GlobalVariable(C);
      if ((GV != null)) {
        if (!GV.hasExternalWeakLinkage() && isInBoundsIndices(Idxs)) {
          return ConstantExpr.getInBoundsGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P(PointeeTy, C, (ArrayRef<Value>) Idxs);
        }
      }
    }
  }
  
  return null;
}

} // END OF class ConstantFoldStatics
