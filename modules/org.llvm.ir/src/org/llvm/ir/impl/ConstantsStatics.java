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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.impl.ConstantsStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type ConstantsStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.ConstantsStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=Tpl__ZL17rangeOnlyContainsT_S_T0_;Tpl__ZL26getSequenceIfElementsMatchPN4llvm8ConstantENS_8ArrayRefIS1_EE;Tpl__ZL28getFPSequenceIfElementsMatchN4llvm8ArrayRefIPNS_8ConstantEEE;Tpl__ZL29getIntSequenceIfElementsMatchN4llvm8ArrayRefIPNS_8ConstantEEE;_ZL10isAllZerosN4llvm9StringRefE;_ZL11canTrapImplPKN4llvm8ConstantERNS_15SmallPtrSetImplIPKNS_12ConstantExprEEE;_ZL13getFoldedCastN4llvm11Instruction7CastOpsEPNS_8ConstantEPNS_4TypeEb;_ZL20TypeToFloatSemanticsPN4llvm4TypeE;_ZL25removeDeadUsersOfConstantPKN4llvm8ConstantE;_ZL28ConstHasGlobalValuePredicatePKN4llvm8ConstantEPFbPKNS_11GlobalValueEE; -static-type=ConstantsStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class ConstantsStatics {

//<editor-fold defaultstate="collapsed" desc="canTrapImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 328,
 FQN="canTrapImpl", NM="_ZL11canTrapImplPKN4llvm8ConstantERNS_15SmallPtrSetImplIPKNS_12ConstantExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZL11canTrapImplPKN4llvm8ConstantERNS_15SmallPtrSetImplIPKNS_12ConstantExprEEE")
//</editor-fold>
public static boolean canTrapImpl(/*const*/ Constant /*P*/ C, 
           final SmallPtrSetImpl</*const*/ ConstantExpr /*P*/ > /*&*/ NonTrappingOps) {
  assert (C.getType().isFirstClassType()) : "Cannot evaluate aggregate vals!";
  // The only thing that could possibly trap are constant exprs.
  /*const*/ ConstantExpr /*P*/ CE = dyn_cast_ConstantExpr(C);
  if (!(CE != null)) {
    return false;
  }
  
  // ConstantExpr traps if any operands can trap.
  for (/*uint*/int i = 0, e = C.getNumOperands(); i != e; ++i) {
    {
      ConstantExpr /*P*/ Op = dyn_cast_ConstantExpr(CE.getOperand_Constant(i));
      if ((Op != null)) {
        if (NonTrappingOps.insert(Op).second && canTrapImpl(Op, NonTrappingOps)) {
          return true;
        }
      }
    }
  }
  
  // Otherwise, only specific operations can trap.
  switch (CE.getOpcode()) {
   default:
    return false;
   case Instruction.BinaryOps.UDiv:
   case Instruction.BinaryOps.SDiv:
   case Instruction.BinaryOps.FDiv:
   case Instruction.BinaryOps.URem:
   case Instruction.BinaryOps.SRem:
   case Instruction.BinaryOps.FRem:
    // Div and rem can trap if the RHS is not known to be non-zero.
    if (!isa_ConstantInt(CE.getOperand_Constant(1)) || CE.getOperand_Constant(1).isNullValue()) {
      return true;
    }
    return false;
  }
}


/// Check if C contains a GlobalValue for which Predicate is true.
//<editor-fold defaultstate="collapsed" desc="ConstHasGlobalValuePredicate">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 367,
 FQN="ConstHasGlobalValuePredicate", NM="_ZL28ConstHasGlobalValuePredicatePKN4llvm8ConstantEPFbPKNS_11GlobalValueEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZL28ConstHasGlobalValuePredicatePKN4llvm8ConstantEPFbPKNS_11GlobalValueEE")
//</editor-fold>
public static boolean ConstHasGlobalValuePredicate(/*const*/ Constant /*P*/ C, 
                            BoolPredicate<GlobalValue> Predicate) {
  SmallPtrSet</*const*/ Constant /*P*/ > Visited/*J*/= new SmallPtrSet</*const*/ Constant /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
  SmallVector</*const*/ Constant /*P*/ > WorkList/*J*/= new SmallVector</*const*/ Constant /*P*/ >(8, (/*const*/ Constant /*P*/ )null);
  WorkList.push_back(C);
  Visited.insert(C);
  while (!WorkList.empty()) {
    /*const*/ Constant /*P*/ WorkItem = WorkList.pop_back_val();
    {
      /*const*/ GlobalValue /*P*/ GV = dyn_cast_GlobalValue(WorkItem);
      if ((GV != null)) {
        if (Predicate.$call(GV)) {
          return true;
        }
      }
    }
    for (/*const*/ Use /*P*/ U : WorkItem.operands$Const()) {
      /*const*/ Value /*P*/ Op = U.get();
      /*const*/ Constant /*P*/ ConstOp = dyn_cast_Constant(Op);
      if (!(ConstOp != null)) {
        continue;
      }
      if (Visited.insert(ConstOp).second) {
        WorkList.push_back(ConstOp);
      }
    }
  }
  return false;
}


/// If the specified constantexpr is dead, remove it. This involves recursively
/// eliminating any dead users of the constantexpr.
//<editor-fold defaultstate="collapsed" desc="removeDeadUsersOfConstant">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 450,
 FQN="removeDeadUsersOfConstant", NM="_ZL25removeDeadUsersOfConstantPKN4llvm8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZL25removeDeadUsersOfConstantPKN4llvm8ConstantE")
//</editor-fold>
public static boolean removeDeadUsersOfConstant(/*const*/ Constant /*P*/ C) {
  if (isa_GlobalValue(C)) {
    return false; // Cannot remove this
  }
  while (!C.use_empty()) {
    /*const*/ Constant /*P*/ User = dyn_cast_Constant(C.user_back$Value$Const());
    if (!(User != null)) {
      return false; // Non-constant usage;
    }
    if (!removeDeadUsersOfConstant(User)) {
      return false; // Constant wasn't dead
    }
  }
  
  ((/*const_cast*/Constant /*P*/ )(C)).destroyConstant();
  return true;
}


//===----------------------------------------------------------------------===//
//                                ConstantFP
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="TypeToFloatSemantics">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 607,
 FQN="TypeToFloatSemantics", NM="_ZL20TypeToFloatSemanticsPN4llvm4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZL20TypeToFloatSemanticsPN4llvm4TypeE")
//</editor-fold>
public static /*const*/ fltSemantics /*P*/ TypeToFloatSemantics(Type /*P*/ Ty) {
  if (Ty.isHalfTy()) {
    return $AddrOf(APFloat.IEEEhalf);
  }
  if (Ty.isFloatTy()) {
    return $AddrOf(APFloat.IEEEsingle);
  }
  if (Ty.isDoubleTy()) {
    return $AddrOf(APFloat.IEEEdouble);
  }
  if (Ty.isX86_FP80Ty()) {
    return $AddrOf(APFloat.x87DoubleExtended);
  } else if (Ty.isFP128Ty()) {
    return $AddrOf(APFloat.IEEEquad);
  }
  assert (Ty.isPPC_FP128Ty()) : "Unknown FP format";
  return $AddrOf(APFloat.PPCDoubleDouble);
}


//===----------------------------------------------------------------------===//
//                            ConstantXXX Classes
//===----------------------------------------------------------------------===//
//template <typename ItTy = Constant *const *, typename EltTy = Constant *> 
//<editor-fold defaultstate="collapsed" desc="rangeOnlyContains">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 811,
 FQN="rangeOnlyContains", NM="_ZL17rangeOnlyContainsIPKPN4llvm8ConstantES2_EbT_S5_T0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZL17rangeOnlyContainsIPKPN4llvm8ConstantES2_EbT_S5_T0_")
//</editor-fold>
public static boolean rangeOnlyContains(type$ptr<Constant /*P*/ /*const*/ /*P*/> Start, type$ptr<Constant /*P*/ /*const*/ /*P*/> End, Constant /*P*/ Elt) {
  for (/*JAVA:Clone*/Start=$Clone(Start); $noteq_ptr(Start, End); Start.$preInc())  {
    if (Start.$star() != Elt) {
      return false;
    }
  }
  return true;
}
///*template <typename ItTy, typename EltTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="rangeOnlyContains">
//@Converted(kind = Converted.Kind.DELETED,
// source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 811,
// FQN="rangeOnlyContains", NM="Tpl__ZL17rangeOnlyContainsT_S_T0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=Tpl__ZL17rangeOnlyContainsT_S_T0_")
////</editor-fold>
//public static </*typename*/ ItTy, /*typename*/ EltTy> boolean rangeOnlyContains(ItTy Start, ItTy End, EltTy Elt) {
//  for (; Native.$noteq(Start, End); ++Start)  {
//    if (Native.$noteq($Deref(Start), Elt)) {
//      return false;
//    }
//  }
//  return true;
//}

//template <typename SequentialTy = ConstantDataArray, typename ElementTy = unsigned char> 
//<editor-fold defaultstate="collapsed" desc="getIntSequenceIfElementsMatch">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 819,
 FQN="getIntSequenceIfElementsMatch", NM="_ZL29getIntSequenceIfElementsMatchIN4llvm17ConstantDataArrayEhEPNS0_8ConstantENS0_8ArrayRefIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZL29getIntSequenceIfElementsMatchIN4llvm17ConstantDataArrayEhEPNS0_8ConstantENS0_8ArrayRefIS3_EE")
//</editor-fold>
public static Constant /*P*/ getIntSequenceIfElementsMatch$UChar(ArrayRef<Constant /*P*/ > V) {
  assert (!V.empty()) : "Cannot get empty int sequence.";
  
  SmallVectorUChar Elts/*J*/= new SmallVectorUChar(16, (/*uchar*/byte)0);
  for (Constant /*P*/ C : V)  {
    {
      ConstantInt /*P*/ CI = dyn_cast_ConstantInt(C);
      if ((CI != null)) {
        Elts.push_back($ulong2uchar(CI.getZExtValue()));
      } else {
        return null;
      }
    }
  }
  return ConstantDataArray.get_LLVMContext_ArrayRefUChar(V.$at(0).getContext(), new ArrayRefUChar(Elts));
}
//template <typename SequentialTy = ConstantDataArray, typename ElementTy = unsigned short> 
//<editor-fold defaultstate="collapsed" desc="getIntSequenceIfElementsMatch">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 819,
 FQN="getIntSequenceIfElementsMatch", NM="_ZL29getIntSequenceIfElementsMatchIN4llvm17ConstantDataArrayEtEPNS0_8ConstantENS0_8ArrayRefIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZL29getIntSequenceIfElementsMatchIN4llvm17ConstantDataArrayEtEPNS0_8ConstantENS0_8ArrayRefIS3_EE")
//</editor-fold>
public static Constant /*P*/ getIntSequenceIfElementsMatch$UShort(ArrayRef<Constant /*P*/ > V) {
  assert (!V.empty()) : "Cannot get empty int sequence.";
  
  SmallVectorUShort Elts/*J*/= new SmallVectorUShort(16, (/*ushort*/char)0);
  for (Constant /*P*/ C : V)  {
    {
      ConstantInt /*P*/ CI = dyn_cast_ConstantInt(C);
      if ((CI != null)) {
        Elts.push_back($ulong2ushort(CI.getZExtValue()));
      } else {
        return null;
      }
    }
  }
  return ConstantDataArray.get_LLVMContext_ArrayRefUShort(V.$at(0).getContext(), new ArrayRefUShort(Elts));
}
//template <typename SequentialTy = ConstantDataArray, typename ElementTy = unsigned int> 
//<editor-fold defaultstate="collapsed" desc="getIntSequenceIfElementsMatch">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 819,
 FQN="getIntSequenceIfElementsMatch", NM="_ZL29getIntSequenceIfElementsMatchIN4llvm17ConstantDataArrayEjEPNS0_8ConstantENS0_8ArrayRefIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZL29getIntSequenceIfElementsMatchIN4llvm17ConstantDataArrayEjEPNS0_8ConstantENS0_8ArrayRefIS3_EE")
//</editor-fold>
public static Constant /*P*/ getIntSequenceIfElementsMatch$UInt(ArrayRef<Constant /*P*/ > V) {
  assert (!V.empty()) : "Cannot get empty int sequence.";
  
  SmallVectorUInt Elts/*J*/= new SmallVectorUInt(16, 0);
  for (Constant /*P*/ C : V)  {
    {
      ConstantInt /*P*/ CI = dyn_cast_ConstantInt(C);
      if ((CI != null)) {
        Elts.push_back($ulong2uint(CI.getZExtValue()));
      } else {
        return null;
      }
    }
  }
  return ConstantDataArray.get_LLVMContext_ArrayRefUInt(V.$at(0).getContext(), new ArrayRefUInt(Elts));
}
//template <typename SequentialTy = ConstantDataArray, typename ElementTy = unsigned long long> 
//<editor-fold defaultstate="collapsed" desc="getIntSequenceIfElementsMatch">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 819,
 FQN="getIntSequenceIfElementsMatch", NM="_ZL29getIntSequenceIfElementsMatchIN4llvm17ConstantDataArrayEyEPNS0_8ConstantENS0_8ArrayRefIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZL29getIntSequenceIfElementsMatchIN4llvm17ConstantDataArrayEyEPNS0_8ConstantENS0_8ArrayRefIS3_EE")
//</editor-fold>
public static Constant /*P*/ getIntSequenceIfElementsMatch$ULLong(ArrayRef<Constant /*P*/ > V) {
  assert (!V.empty()) : "Cannot get empty int sequence.";
  
  SmallVectorULong Elts/*J*/= new SmallVectorULong(16, (/*ullong*/long)0);
  for (Constant /*P*/ C : V)  {
    {
      ConstantInt /*P*/ CI = dyn_cast_ConstantInt(C);
      if ((CI != null)) {
        Elts.push_back(CI.getZExtValue());
      } else {
        return null;
      }
    }
  }
  return ConstantDataArray.get_LLVMContext_ArrayRefULong(V.$at(0).getContext(), new ArrayRefULong(Elts));
}
///*template <typename SequentialTy, typename ElementTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="getIntSequenceIfElementsMatch">
//@Converted(kind = Converted.Kind.DELETED,
// source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 819,
// FQN="getIntSequenceIfElementsMatch", NM="Tpl__ZL29getIntSequenceIfElementsMatchN4llvm8ArrayRefIPNS_8ConstantEEE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=Tpl__ZL29getIntSequenceIfElementsMatchN4llvm8ArrayRefIPNS_8ConstantEEE")
////</editor-fold>
//public static </*typename*/ SequentialTy, /*typename*/ ElementTy> Constant /*P*/ getIntSequenceIfElementsMatch(ArrayRef<Constant /*P*/ > V) {
//  assert (!V.empty()) : "Cannot get empty int sequence.";
//  
//  SmallVector<ElementTy>/*<16>*/ Elts;
//  for (Constant /*P*/ C : V)  {
//    {
//      ConstantInt /*P*/ CI = dyn_cast_ConstantInt(C);
//      if ((CI != null)) {
//        Elts.push_back(CI.getZExtValue());
//      } else {
//        return null;
//      }
//    }
//  }
//  return SequentialTy.get(V.$at(0).getContext(), Elts);
//}

//template <typename SequentialTy = ConstantDataArray, typename ElementTy = unsigned short> 
//<editor-fold defaultstate="collapsed" desc="getFPSequenceIfElementsMatch">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 832,
 FQN="getFPSequenceIfElementsMatch", NM="_ZL28getFPSequenceIfElementsMatchIN4llvm17ConstantDataArrayEtEPNS0_8ConstantENS0_8ArrayRefIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZL28getFPSequenceIfElementsMatchIN4llvm17ConstantDataArrayEtEPNS0_8ConstantENS0_8ArrayRefIS3_EE")
//</editor-fold>
public static Constant /*P*/ getFPSequenceIfElementsMatch$UShort(ArrayRef<Constant /*P*/ > V) {
  assert (!V.empty()) : "Cannot get empty FP sequence.";
  
  SmallVectorUShort Elts/*J*/= new SmallVectorUShort(16, (/*ushort*/char)0);
  for (Constant /*P*/ C : V)  {
    {
      ConstantFP /*P*/ CFP = dyn_cast_ConstantFP(C);
      if ((CFP != null)) {
        Elts.push_back($ulong2ushort(CFP.getValueAPF().bitcastToAPInt().getLimitedValue()));
      } else {
        return null;
      }
    }
  }
  return ConstantDataArray.getFP_LLVMContext_ArrayRefUShort(V.$at(0).getContext(), new ArrayRefUShort(Elts));
}
//template <typename SequentialTy = ConstantDataArray, typename ElementTy = unsigned int> 
//<editor-fold defaultstate="collapsed" desc="getFPSequenceIfElementsMatch">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 832,
 FQN="getFPSequenceIfElementsMatch", NM="_ZL28getFPSequenceIfElementsMatchIN4llvm17ConstantDataArrayEjEPNS0_8ConstantENS0_8ArrayRefIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZL28getFPSequenceIfElementsMatchIN4llvm17ConstantDataArrayEjEPNS0_8ConstantENS0_8ArrayRefIS3_EE")
//</editor-fold>
public static Constant /*P*/ getFPSequenceIfElementsMatch$UInt(ArrayRef<Constant /*P*/ > V) {
  assert (!V.empty()) : "Cannot get empty FP sequence.";
  
  SmallVectorUInt Elts/*J*/= new SmallVectorUInt(16, 0);
  for (Constant /*P*/ C : V)  {
    {
      ConstantFP /*P*/ CFP = dyn_cast_ConstantFP(C);
      if ((CFP != null)) {
        Elts.push_back($ulong2uint(CFP.getValueAPF().bitcastToAPInt().getLimitedValue()));
      } else {
        return null;
      }
    }
  }
  return ConstantDataArray.getFP_LLVMContext_ArrayRefUInt(V.$at(0).getContext(), new ArrayRefUInt(Elts));
}
//template <typename SequentialTy = ConstantDataArray, typename ElementTy = unsigned long long> 
//<editor-fold defaultstate="collapsed" desc="getFPSequenceIfElementsMatch">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 832,
 FQN="getFPSequenceIfElementsMatch", NM="_ZL28getFPSequenceIfElementsMatchIN4llvm17ConstantDataArrayEyEPNS0_8ConstantENS0_8ArrayRefIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZL28getFPSequenceIfElementsMatchIN4llvm17ConstantDataArrayEyEPNS0_8ConstantENS0_8ArrayRefIS3_EE")
//</editor-fold>
public static Constant /*P*/ getFPSequenceIfElementsMatch$ULLong(ArrayRef<Constant /*P*/ > V) {
  assert (!V.empty()) : "Cannot get empty FP sequence.";
  
  SmallVectorULong Elts/*J*/= new SmallVectorULong(16, (/*ullong*/long)0);
  for (Constant /*P*/ C : V)  {
    {
      ConstantFP /*P*/ CFP = dyn_cast_ConstantFP(C);
      if ((CFP != null)) {
        Elts.push_back(CFP.getValueAPF().bitcastToAPInt().getLimitedValue());
      } else {
        return null;
      }
    }
  }
  return ConstantDataArray.getFP_LLVMContext_ArrayRefULong(V.$at(0).getContext(), new ArrayRefULong(Elts));
}
///*template <typename SequentialTy, typename ElementTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="getFPSequenceIfElementsMatch">
//@Converted(kind = Converted.Kind.DELETED,
// source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 832,
// FQN="getFPSequenceIfElementsMatch", NM="Tpl__ZL28getFPSequenceIfElementsMatchN4llvm8ArrayRefIPNS_8ConstantEEE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=Tpl__ZL28getFPSequenceIfElementsMatchN4llvm8ArrayRefIPNS_8ConstantEEE")
////</editor-fold>
//public static </*typename*/ SequentialTy, /*typename*/ ElementTy> Constant /*P*/ getFPSequenceIfElementsMatch(ArrayRef<Constant /*P*/ > V) {
//  assert (!V.empty()) : "Cannot get empty FP sequence.";
//  
//  SmallVector<ElementTy>/*<16>*/ Elts;
//  for (Constant /*P*/ C : V)  {
//    {
//      ConstantFP /*P*/ CFP = dyn_cast_ConstantFP(C);
//      if ((CFP != null)) {
//        Elts.push_back(CFP.getValueAPF().bitcastToAPInt().getLimitedValue());
//      } else {
//        return null;
//      }
//    }
//  }
//  return SequentialTy.getFP(V.$at(0).getContext(), Elts);
//}


/*template <typename SequenceTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="getSequenceIfElementsMatch">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 845,
 FQN="getSequenceIfElementsMatch", NM="Tpl__ZL26getSequenceIfElementsMatchPN4llvm8ConstantENS_8ArrayRefIS1_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=Tpl__ZL26getSequenceIfElementsMatchPN4llvm8ConstantENS_8ArrayRefIS1_EE")
//</editor-fold>
public static </*typename*/ SequenceTy> Constant /*P*/ getSequenceIfElementsMatch(Constant /*P*/ C, 
                          ArrayRef<Constant /*P*/ > V) {
  {
    // We speculatively build the elements here even if it turns out that there is
    // a constantexpr or something else weird, since it is so uncommon for that to
    // happen.
    ConstantInt /*P*/ CI = dyn_cast_ConstantInt(C);
    if ((CI != null)) {
      if (CI.getType().isIntegerTy(8)) {
        return getIntSequenceIfElementsMatch$UChar(V);//<SequenceTy, byte/*uint8_t*/>(V);
      } else if (CI.getType().isIntegerTy(16)) {
        return getIntSequenceIfElementsMatch$UShort(V);//<SequenceTy, /*uint16_t*/char>(V);
      } else if (CI.getType().isIntegerTy(32)) {
        return getIntSequenceIfElementsMatch$UInt(V);//<SequenceTy, /*uint32_t*/int>(V);
      } else if (CI.getType().isIntegerTy(64)) {
        return getIntSequenceIfElementsMatch$ULLong(V);//<SequenceTy, long/*uint64_t*/>(V);
      }
    } else {
      ConstantFP /*P*/ CFP = dyn_cast_ConstantFP(C);
      if ((CFP != null)) {
        if (CFP.getType().isHalfTy()) {
          return getFPSequenceIfElementsMatch$UShort(V);//<SequenceTy, /*uint16_t*/char>(V);
        } else if (CFP.getType().isFloatTy()) {
          return getFPSequenceIfElementsMatch$UInt(V);//<SequenceTy, /*uint32_t*/int>(V);
        } else if (CFP.getType().isDoubleTy()) {
          return getFPSequenceIfElementsMatch$ULLong(V);//<SequenceTy, long/*uint64_t*/>(V);
        }
      }
    }
  }
  
  return null;
}


//---- ConstantExpr::get() implementations.
//

/// This is a utility function to handle folding of casts and lookup of the
/// cast in the ExprConstants map. It is used by the various get* methods below.
//<editor-fold defaultstate="collapsed" desc="getFoldedCast">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1439,
 FQN="getFoldedCast", NM="_ZL13getFoldedCastN4llvm11Instruction7CastOpsEPNS_8ConstantEPNS_4TypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZL13getFoldedCastN4llvm11Instruction7CastOpsEPNS_8ConstantEPNS_4TypeEb")
//</editor-fold>
public static Constant /*P*/ getFoldedCast(/*CastOps*/int opc, Constant /*P*/ C, Type /*P*/ Ty) {
  return getFoldedCast(opc, C, Ty, 
             false);
}
public static Constant /*P*/ getFoldedCast(/*CastOps*/int opc, Constant /*P*/ C, Type /*P*/ Ty, 
             boolean OnlyIfReduced/*= false*/) {
  assert (Ty.isFirstClassType()) : "Cannot cast to an aggregate type!";
  {
    // Fold a few common cases
    Constant /*P*/ FC = ConstantFoldLlvmStatics.ConstantFoldCastInstruction(opc, C, Ty);
    if ((FC != null)) {
      return FC;
    }
  }
  if (OnlyIfReduced) {
    return null;
  }
  
  LLVMContextImpl /*P*/ pImpl = Ty.getContext().pImpl;
  
  // Look up the constant in the table first to ensure uniqueness.
  ConstantExprKeyType Key/*J*/= new ConstantExprKeyType(opc, new ArrayRef<Constant /*P*/ >(C, true));
  
  return pImpl.ExprConstants.getOrCreate(Ty, new ConstantExprKeyType(Key));
}


/// Return true if the array is empty or all zeros.
//<editor-fold defaultstate="collapsed" desc="isAllZeros">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2333,
 FQN="isAllZeros", NM="_ZL10isAllZerosN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZL10isAllZerosN4llvm9StringRefE")
//</editor-fold>
public static boolean isAllZeros(StringRef Arr) {
  for (/*char*/byte I : Arr)  {
    if (I != 0) {
      return false;
    }
  }
  return true;
}

} // END OF class ConstantsStatics
