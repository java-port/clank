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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.impl.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.pass.*;


//===----------------------------------------------------------------------===//
/// A constant value that is initialized with an expression using
/// other constant values.
///
/// This class uses the standard Instruction opcodes to define the various
/// constant expressions.  The Opcode field for the ConstantExpr class is
/// maintained in the Value::SubclassData field.
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 835,
 FQN="llvm::ConstantExpr", NM="_ZN4llvm12ConstantExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExprE")
//</editor-fold>
public class ConstantExpr extends /*public*/ Constant implements Destructors.ClassWithDestructor {
  /*friend  struct ConstantExprKeyType*/
  
  /*friend  class Constant*/
  
  /// Remove the constant from the constant table.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::destroyConstantImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2255,
   FQN="llvm::ConstantExpr::destroyConstantImpl", NM="_ZN4llvm12ConstantExpr19destroyConstantImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr19destroyConstantImplEv")
  //</editor-fold>
  /*friend*//*package*//*private*/ void destroyConstantImpl() {
    getType().getContext().pImpl.ExprConstants.remove(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::handleOperandChangeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2823,
   FQN="llvm::ConstantExpr::handleOperandChangeImpl", NM="_ZN4llvm12ConstantExpr23handleOperandChangeImplEPNS_5ValueES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr23handleOperandChangeImplEPNS_5ValueES2_")
  //</editor-fold>
  /*friend*//*package*//*private*/ Value /*P*/ handleOperandChangeImpl(Value /*P*/ From, Value /*P*/ ToV) {
    assert (isa_Constant(ToV)) : "Cannot make Constant refer to non-constant!";
    Constant /*P*/ To = cast_Constant(ToV);
    
    SmallVector<Constant /*P*/ > NewOps/*J*/= new SmallVector<Constant /*P*/ >(8, (Constant /*P*/ )null);
    /*uint*/int NumUpdated = 0;
    /*uint*/int OperandNo = 0;
    for (/*uint*/int i = 0, e = getNumOperands(); i != e; ++i) {
      Constant /*P*/ Op = getOperand_Constant(i);
      if (Op == From) {
        OperandNo = i;
        ++NumUpdated;
        Op = To;
      }
      NewOps.push_back(Op);
    }
    assert ((NumUpdated != 0)) : "I didn't contain From!";
    {
      
      Constant /*P*/ C = getWithOperands(new ArrayRef<Constant /*P*/ >(NewOps, true), getType(), true);
      if ((C != null)) {
        return C;
      }
    }
    
    // Update to the new value.
    return getContext().pImpl.ExprConstants.replaceOperandsInPlace(new ArrayRef<Constant /*P*/ >(NewOps, true), this, From, To, NumUpdated, OperandNo);
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::ConstantExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 843,
   FQN="llvm::ConstantExpr::ConstantExpr", NM="_ZN4llvm12ConstantExprC1EPNS_4TypeEjPNS_3UseEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExprC1EPNS_4TypeEjPNS_3UseEj")
  //</editor-fold>
  protected ConstantExpr(Type /*P*/ ty, /*uint*/int Opcode, type$ptr<Use /*P*/> Ops, /*uint*/int NumOps) {
    // : Constant(ty, ConstantExprVal, Ops, NumOps) 
    //START JInit
    super(ty, ValueTy.ConstantExprVal, Ops, NumOps);
    //END JInit
    // Operation type (an Instruction opcode) is stored as the SubclassData.
    setValueSubclassData($uint2ushort(Opcode));
  }

/*public:*/
  // Static methods to construct a ConstantExpr of different kinds.  Note that
  // these methods may return a object that is not an instance of the
  // ConstantExpr class, because they will attempt to fold the constant
  // expression into something simpler if possible.
  
  /// getAlignOf constant expr - computes the alignment of a type in a target
  /// independent way (Note: the return type is an i64).
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getAlignOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1823,
   FQN="llvm::ConstantExpr::getAlignOf", NM="_ZN4llvm12ConstantExpr10getAlignOfEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr10getAlignOfEPNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ getAlignOf(Type /*P*/ Ty) {
    // alignof is implemented as: (i64) gep ({i1,Ty}*)null, 0, 1
    // Note that a non-inbounds gep is used, as null isn't within any object.
    Type /*P*/ AligningTy = StructType.get(Type.getInt1Ty(Ty.getContext()), Ty, null);
    Constant /*P*/ NullPtr = Constant.getNullValue(AligningTy.getPointerTo(0));
    Constant /*P*/ Zero = ConstantInt.get(Type.getInt64Ty(Ty.getContext()), $int2ulong(0));
    Constant /*P*/ One = ConstantInt.get(Type.getInt32Ty(Ty.getContext()), $int2ulong(1));
    Constant /*P*/ Indices[/*2*/] = new Constant /*P*/  [/*2*/] {Zero, One};
    Constant /*P*/ GEP = ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P(AligningTy, NullPtr, new ArrayRef<Constant /*P*/ >(Indices, true));
    return getPtrToInt(GEP, 
        Type.getInt64Ty(Ty.getContext()));
  }

  
  /// getSizeOf constant expr - computes the (alloc) size of a type (in
  /// address-units, not bits) in a target independent way (Note: the return
  /// type is an i64).
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getSizeOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1813,
   FQN="llvm::ConstantExpr::getSizeOf", NM="_ZN4llvm12ConstantExpr9getSizeOfEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr9getSizeOfEPNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ getSizeOf(Type /*P*/ Ty) {
    // sizeof is implemented as: (i64) gep (Ty*)null, 1
    // Note that a non-inbounds gep is used, as null isn't within any object.
    Constant /*P*/ GEPIdx = ConstantInt.get(Type.getInt32Ty(Ty.getContext()), $int2ulong(1));
    Constant /*P*/ GEP = ConstantExpr.getGetElementPtr(Ty, Constant.getNullValue(PointerType.getUnqual(Ty)), GEPIdx);
    return getPtrToInt(GEP, 
        Type.getInt64Ty(Ty.getContext()));
  }

  
  /// getOffsetOf constant expr - computes the offset of a struct field in a
  /// target independent way (Note: the return type is an i64).
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getOffsetOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1837,
   FQN="llvm::ConstantExpr::getOffsetOf", NM="_ZN4llvm12ConstantExpr11getOffsetOfEPNS_10StructTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr11getOffsetOfEPNS_10StructTypeEj")
  //</editor-fold>
  public static Constant /*P*/ getOffsetOf(StructType /*P*/ STy, /*uint*/int FieldNo) {
    return getOffsetOf(STy, ConstantInt.get(Type.getInt32Ty(STy.getContext()), 
            $uint2ulong(FieldNo)));
  }

  
  /// getOffsetOf constant expr - This is a generalized form of getOffsetOf,
  /// which supports any aggregate type, and any Constant index.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getOffsetOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1842,
   FQN="llvm::ConstantExpr::getOffsetOf", NM="_ZN4llvm12ConstantExpr11getOffsetOfEPNS_4TypeEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr11getOffsetOfEPNS_4TypeEPNS_8ConstantE")
  //</editor-fold>
  public static Constant /*P*/ getOffsetOf(Type /*P*/ Ty, Constant /*P*/ FieldNo) {
    // offsetof is implemented as: (i64) gep (Ty*)null, 0, FieldNo
    // Note that a non-inbounds gep is used, as null isn't within any object.
    Constant /*P*/ GEPIdx[/*2*/] = new Constant /*P*/  [/*2*/] {
      ConstantInt.get(Type.getInt64Ty(Ty.getContext()), $int2ulong(0)), 
      FieldNo
    };
    Constant /*P*/ GEP = ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P(Ty, Constant.getNullValue(PointerType.getUnqual(Ty)), new ArrayRef<Constant /*P*/ >(GEPIdx, true));
    return getPtrToInt(GEP, 
        Type.getInt64Ty(Ty.getContext()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getNeg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2113,
   FQN="llvm::ConstantExpr::getNeg", NM="_ZN4llvm12ConstantExpr6getNegEPNS_8ConstantEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr6getNegEPNS_8ConstantEbb")
  //</editor-fold>
  public static Constant /*P*/ getNeg(Constant /*P*/ C) {
    return getNeg(C, false, false);
  }
  public static Constant /*P*/ getNeg(Constant /*P*/ C, boolean HasNUW/*= false*/) {
    return getNeg(C, HasNUW, false);
  }
  public static Constant /*P*/ getNeg(Constant /*P*/ C, boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) {
    assert (C.getType().isIntOrIntVectorTy()) : "Cannot NEG a nonintegral value!";
    return getSub(ConstantFP.getZeroValueForNegation(C.getType()), 
        C, HasNUW, HasNSW);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getFNeg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2120,
   FQN="llvm::ConstantExpr::getFNeg", NM="_ZN4llvm12ConstantExpr7getFNegEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr7getFNegEPNS_8ConstantE")
  //</editor-fold>
  public static Constant /*P*/ getFNeg(Constant /*P*/ C) {
    assert (C.getType().isFPOrFPVectorTy()) : "Cannot FNEG a non-floating-point value!";
    return getFSub(ConstantFP.getZeroValueForNegation(C.getType()), C);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getNot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2126,
   FQN="llvm::ConstantExpr::getNot", NM="_ZN4llvm12ConstantExpr6getNotEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr6getNotEPNS_8ConstantE")
  //</editor-fold>
  public static Constant /*P*/ getNot(Constant /*P*/ C) {
    assert (C.getType().isIntOrIntVectorTy()) : "Cannot NOT a nonintegral value!";
    return get(Instruction.BinaryOps.Xor, C, Constant.getAllOnesValue(C.getType()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2132,
   FQN="llvm::ConstantExpr::getAdd", NM="_ZN4llvm12ConstantExpr6getAddEPNS_8ConstantES2_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr6getAddEPNS_8ConstantES2_bb")
  //</editor-fold>
  public static Constant /*P*/ getAdd(Constant /*P*/ C1, Constant /*P*/ C2) {
    return getAdd(C1, C2, 
        false, false);
  }
  public static Constant /*P*/ getAdd(Constant /*P*/ C1, Constant /*P*/ C2, 
        boolean HasNUW/*= false*/) {
    return getAdd(C1, C2, 
        HasNUW, false);
  }
  public static Constant /*P*/ getAdd(Constant /*P*/ C1, Constant /*P*/ C2, 
        boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) {
    /*uint*/int Flags = (HasNUW ? OverflowingBinaryOperator.NoUnsignedWrap : 0)
       | (HasNSW ? OverflowingBinaryOperator.NoSignedWrap : 0);
    return get(Instruction.BinaryOps.Add, C1, C2, Flags);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getFAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2139,
   FQN="llvm::ConstantExpr::getFAdd", NM="_ZN4llvm12ConstantExpr7getFAddEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr7getFAddEPNS_8ConstantES2_")
  //</editor-fold>
  public static Constant /*P*/ getFAdd(Constant /*P*/ C1, Constant /*P*/ C2) {
    return get(Instruction.BinaryOps.FAdd, C1, C2);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2143,
   FQN="llvm::ConstantExpr::getSub", NM="_ZN4llvm12ConstantExpr6getSubEPNS_8ConstantES2_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr6getSubEPNS_8ConstantES2_bb")
  //</editor-fold>
  public static Constant /*P*/ getSub(Constant /*P*/ C1, Constant /*P*/ C2) {
    return getSub(C1, C2, 
        false, false);
  }
  public static Constant /*P*/ getSub(Constant /*P*/ C1, Constant /*P*/ C2, 
        boolean HasNUW/*= false*/) {
    return getSub(C1, C2, 
        HasNUW, false);
  }
  public static Constant /*P*/ getSub(Constant /*P*/ C1, Constant /*P*/ C2, 
        boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) {
    /*uint*/int Flags = (HasNUW ? OverflowingBinaryOperator.NoUnsignedWrap : 0)
       | (HasNSW ? OverflowingBinaryOperator.NoSignedWrap : 0);
    return get(Instruction.BinaryOps.Sub, C1, C2, Flags);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getFSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2150,
   FQN="llvm::ConstantExpr::getFSub", NM="_ZN4llvm12ConstantExpr7getFSubEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr7getFSubEPNS_8ConstantES2_")
  //</editor-fold>
  public static Constant /*P*/ getFSub(Constant /*P*/ C1, Constant /*P*/ C2) {
    return get(Instruction.BinaryOps.FSub, C1, C2);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2154,
   FQN="llvm::ConstantExpr::getMul", NM="_ZN4llvm12ConstantExpr6getMulEPNS_8ConstantES2_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr6getMulEPNS_8ConstantES2_bb")
  //</editor-fold>
  public static Constant /*P*/ getMul(Constant /*P*/ C1, Constant /*P*/ C2) {
    return getMul(C1, C2, 
        false, false);
  }
  public static Constant /*P*/ getMul(Constant /*P*/ C1, Constant /*P*/ C2, 
        boolean HasNUW/*= false*/) {
    return getMul(C1, C2, 
        HasNUW, false);
  }
  public static Constant /*P*/ getMul(Constant /*P*/ C1, Constant /*P*/ C2, 
        boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) {
    /*uint*/int Flags = (HasNUW ? OverflowingBinaryOperator.NoUnsignedWrap : 0)
       | (HasNSW ? OverflowingBinaryOperator.NoSignedWrap : 0);
    return get(Instruction.BinaryOps.Mul, C1, C2, Flags);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getFMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2161,
   FQN="llvm::ConstantExpr::getFMul", NM="_ZN4llvm12ConstantExpr7getFMulEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr7getFMulEPNS_8ConstantES2_")
  //</editor-fold>
  public static Constant /*P*/ getFMul(Constant /*P*/ C1, Constant /*P*/ C2) {
    return get(Instruction.BinaryOps.FMul, C1, C2);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getUDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2165,
   FQN="llvm::ConstantExpr::getUDiv", NM="_ZN4llvm12ConstantExpr7getUDivEPNS_8ConstantES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr7getUDivEPNS_8ConstantES2_b")
  //</editor-fold>
  public static Constant /*P*/ getUDiv(Constant /*P*/ C1, Constant /*P*/ C2) {
    return getUDiv(C1, C2, false);
  }
  public static Constant /*P*/ getUDiv(Constant /*P*/ C1, Constant /*P*/ C2, boolean isExact/*= false*/) {
    return get(Instruction.BinaryOps.UDiv, C1, C2, 
        isExact ? PossiblyExactOperator.IsExact : 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getSDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2170,
   FQN="llvm::ConstantExpr::getSDiv", NM="_ZN4llvm12ConstantExpr7getSDivEPNS_8ConstantES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr7getSDivEPNS_8ConstantES2_b")
  //</editor-fold>
  public static Constant /*P*/ getSDiv(Constant /*P*/ C1, Constant /*P*/ C2) {
    return getSDiv(C1, C2, false);
  }
  public static Constant /*P*/ getSDiv(Constant /*P*/ C1, Constant /*P*/ C2, boolean isExact/*= false*/) {
    return get(Instruction.BinaryOps.SDiv, C1, C2, 
        isExact ? PossiblyExactOperator.IsExact : 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getFDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2175,
   FQN="llvm::ConstantExpr::getFDiv", NM="_ZN4llvm12ConstantExpr7getFDivEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr7getFDivEPNS_8ConstantES2_")
  //</editor-fold>
  public static Constant /*P*/ getFDiv(Constant /*P*/ C1, Constant /*P*/ C2) {
    return get(Instruction.BinaryOps.FDiv, C1, C2);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getURem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2179,
   FQN="llvm::ConstantExpr::getURem", NM="_ZN4llvm12ConstantExpr7getURemEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr7getURemEPNS_8ConstantES2_")
  //</editor-fold>
  public static Constant /*P*/ getURem(Constant /*P*/ C1, Constant /*P*/ C2) {
    return get(Instruction.BinaryOps.URem, C1, C2);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getSRem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2183,
   FQN="llvm::ConstantExpr::getSRem", NM="_ZN4llvm12ConstantExpr7getSRemEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr7getSRemEPNS_8ConstantES2_")
  //</editor-fold>
  public static Constant /*P*/ getSRem(Constant /*P*/ C1, Constant /*P*/ C2) {
    return get(Instruction.BinaryOps.SRem, C1, C2);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getFRem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2187,
   FQN="llvm::ConstantExpr::getFRem", NM="_ZN4llvm12ConstantExpr7getFRemEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr7getFRemEPNS_8ConstantES2_")
  //</editor-fold>
  public static Constant /*P*/ getFRem(Constant /*P*/ C1, Constant /*P*/ C2) {
    return get(Instruction.BinaryOps.FRem, C1, C2);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getAnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2191,
   FQN="llvm::ConstantExpr::getAnd", NM="_ZN4llvm12ConstantExpr6getAndEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr6getAndEPNS_8ConstantES2_")
  //</editor-fold>
  public static Constant /*P*/ getAnd(Constant /*P*/ C1, Constant /*P*/ C2) {
    return get(Instruction.BinaryOps.And, C1, C2);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getOr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2195,
   FQN="llvm::ConstantExpr::getOr", NM="_ZN4llvm12ConstantExpr5getOrEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr5getOrEPNS_8ConstantES2_")
  //</editor-fold>
  public static Constant /*P*/ getOr(Constant /*P*/ C1, Constant /*P*/ C2) {
    return get(Instruction.BinaryOps.Or, C1, C2);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getXor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2199,
   FQN="llvm::ConstantExpr::getXor", NM="_ZN4llvm12ConstantExpr6getXorEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr6getXorEPNS_8ConstantES2_")
  //</editor-fold>
  public static Constant /*P*/ getXor(Constant /*P*/ C1, Constant /*P*/ C2) {
    return get(Instruction.BinaryOps.Xor, C1, C2);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getShl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2203,
   FQN="llvm::ConstantExpr::getShl", NM="_ZN4llvm12ConstantExpr6getShlEPNS_8ConstantES2_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr6getShlEPNS_8ConstantES2_bb")
  //</editor-fold>
  public static Constant /*P*/ getShl(Constant /*P*/ C1, Constant /*P*/ C2) {
    return getShl(C1, C2, 
        false, false);
  }
  public static Constant /*P*/ getShl(Constant /*P*/ C1, Constant /*P*/ C2, 
        boolean HasNUW/*= false*/) {
    return getShl(C1, C2, 
        HasNUW, false);
  }
  public static Constant /*P*/ getShl(Constant /*P*/ C1, Constant /*P*/ C2, 
        boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) {
    /*uint*/int Flags = (HasNUW ? OverflowingBinaryOperator.NoUnsignedWrap : 0)
       | (HasNSW ? OverflowingBinaryOperator.NoSignedWrap : 0);
    return get(Instruction.BinaryOps.Shl, C1, C2, Flags);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getLShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2210,
   FQN="llvm::ConstantExpr::getLShr", NM="_ZN4llvm12ConstantExpr7getLShrEPNS_8ConstantES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr7getLShrEPNS_8ConstantES2_b")
  //</editor-fold>
  public static Constant /*P*/ getLShr(Constant /*P*/ C1, Constant /*P*/ C2) {
    return getLShr(C1, C2, false);
  }
  public static Constant /*P*/ getLShr(Constant /*P*/ C1, Constant /*P*/ C2, boolean isExact/*= false*/) {
    return get(Instruction.BinaryOps.LShr, C1, C2, 
        isExact ? PossiblyExactOperator.IsExact : 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getAShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2215,
   FQN="llvm::ConstantExpr::getAShr", NM="_ZN4llvm12ConstantExpr7getAShrEPNS_8ConstantES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr7getAShrEPNS_8ConstantES2_b")
  //</editor-fold>
  public static Constant /*P*/ getAShr(Constant /*P*/ C1, Constant /*P*/ C2) {
    return getAShr(C1, C2, false);
  }
  public static Constant /*P*/ getAShr(Constant /*P*/ C1, Constant /*P*/ C2, boolean isExact/*= false*/) {
    return get(Instruction.BinaryOps.AShr, C1, C2, 
        isExact ? PossiblyExactOperator.IsExact : 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getTrunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1564,
   FQN="llvm::ConstantExpr::getTrunc", NM="_ZN4llvm12ConstantExpr8getTruncEPNS_8ConstantEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr8getTruncEPNS_8ConstantEPNS_4TypeEb")
  //</editor-fold>
  public static Constant /*P*/ getTrunc(Constant /*P*/ C, Type /*P*/ Ty) {
    return getTrunc(C, Ty, false);
  }
  public static Constant /*P*/ getTrunc(Constant /*P*/ C, Type /*P*/ Ty, boolean OnlyIfReduced/*= false*/) {
    boolean fromVec = C.getType().getTypeID() == Type.TypeID.VectorTyID;
    boolean toVec = Ty.getTypeID() == Type.TypeID.VectorTyID;
    assert ((fromVec == toVec)) : "Cannot convert from scalar to/from vector";
    assert (C.getType().isIntOrIntVectorTy()) : "Trunc operand must be integer";
    assert (Ty.isIntOrIntVectorTy()) : "Trunc produces only integral";
    assert ($greater_uint(C.getType().getScalarSizeInBits(), Ty.getScalarSizeInBits())) : "SrcTy must be larger than DestTy for Trunc!";
    
    return ConstantsStatics.getFoldedCast(Instruction.CastOps.Trunc, C, Ty, OnlyIfReduced);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getSExt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1578,
   FQN="llvm::ConstantExpr::getSExt", NM="_ZN4llvm12ConstantExpr7getSExtEPNS_8ConstantEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr7getSExtEPNS_8ConstantEPNS_4TypeEb")
  //</editor-fold>
  public static Constant /*P*/ getSExt(Constant /*P*/ C, Type /*P*/ Ty) {
    return getSExt(C, Ty, false);
  }
  public static Constant /*P*/ getSExt(Constant /*P*/ C, Type /*P*/ Ty, boolean OnlyIfReduced/*= false*/) {
    boolean fromVec = C.getType().getTypeID() == Type.TypeID.VectorTyID;
    boolean toVec = Ty.getTypeID() == Type.TypeID.VectorTyID;
    assert ((fromVec == toVec)) : "Cannot convert from scalar to/from vector";
    assert (C.getType().isIntOrIntVectorTy()) : "SExt operand must be integral";
    assert (Ty.isIntOrIntVectorTy()) : "SExt produces only integer";
    assert ($less_uint(C.getType().getScalarSizeInBits(), Ty.getScalarSizeInBits())) : "SrcTy must be smaller than DestTy for SExt!";
    
    return ConstantsStatics.getFoldedCast(Instruction.CastOps.SExt, C, Ty, OnlyIfReduced);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getZExt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1592,
   FQN="llvm::ConstantExpr::getZExt", NM="_ZN4llvm12ConstantExpr7getZExtEPNS_8ConstantEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr7getZExtEPNS_8ConstantEPNS_4TypeEb")
  //</editor-fold>
  public static Constant /*P*/ getZExt(Constant /*P*/ C, Type /*P*/ Ty) {
    return getZExt(C, Ty, false);
  }
  public static Constant /*P*/ getZExt(Constant /*P*/ C, Type /*P*/ Ty, boolean OnlyIfReduced/*= false*/) {
    boolean fromVec = C.getType().getTypeID() == Type.TypeID.VectorTyID;
    boolean toVec = Ty.getTypeID() == Type.TypeID.VectorTyID;
    assert ((fromVec == toVec)) : "Cannot convert from scalar to/from vector";
    assert (C.getType().isIntOrIntVectorTy()) : "ZEXt operand must be integral";
    assert (Ty.isIntOrIntVectorTy()) : "ZExt produces only integer";
    assert ($less_uint(C.getType().getScalarSizeInBits(), Ty.getScalarSizeInBits())) : "SrcTy must be smaller than DestTy for ZExt!";
    
    return ConstantsStatics.getFoldedCast(Instruction.CastOps.ZExt, C, Ty, OnlyIfReduced);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getFPTrunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1606,
   FQN="llvm::ConstantExpr::getFPTrunc", NM="_ZN4llvm12ConstantExpr10getFPTruncEPNS_8ConstantEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr10getFPTruncEPNS_8ConstantEPNS_4TypeEb")
  //</editor-fold>
  public static Constant /*P*/ getFPTrunc(Constant /*P*/ C, Type /*P*/ Ty) {
    return getFPTrunc(C, Ty, false);
  }
  public static Constant /*P*/ getFPTrunc(Constant /*P*/ C, Type /*P*/ Ty, boolean OnlyIfReduced/*= false*/) {
    boolean fromVec = C.getType().getTypeID() == Type.TypeID.VectorTyID;
    boolean toVec = Ty.getTypeID() == Type.TypeID.VectorTyID;
    assert ((fromVec == toVec)) : "Cannot convert from scalar to/from vector";
    assert (C.getType().isFPOrFPVectorTy() && Ty.isFPOrFPVectorTy() && $greater_uint(C.getType().getScalarSizeInBits(), Ty.getScalarSizeInBits())) : "This is an illegal floating point truncation!";
    return ConstantsStatics.getFoldedCast(Instruction.CastOps.FPTrunc, C, Ty, OnlyIfReduced);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getFPExtend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1618,
   FQN="llvm::ConstantExpr::getFPExtend", NM="_ZN4llvm12ConstantExpr11getFPExtendEPNS_8ConstantEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr11getFPExtendEPNS_8ConstantEPNS_4TypeEb")
  //</editor-fold>
  public static Constant /*P*/ getFPExtend(Constant /*P*/ C, Type /*P*/ Ty) {
    return getFPExtend(C, Ty, false);
  }
  public static Constant /*P*/ getFPExtend(Constant /*P*/ C, Type /*P*/ Ty, boolean OnlyIfReduced/*= false*/) {
    boolean fromVec = C.getType().getTypeID() == Type.TypeID.VectorTyID;
    boolean toVec = Ty.getTypeID() == Type.TypeID.VectorTyID;
    assert ((fromVec == toVec)) : "Cannot convert from scalar to/from vector";
    assert (C.getType().isFPOrFPVectorTy() && Ty.isFPOrFPVectorTy() && $less_uint(C.getType().getScalarSizeInBits(), Ty.getScalarSizeInBits())) : "This is an illegal floating point extension!";
    return ConstantsStatics.getFoldedCast(Instruction.CastOps.FPExt, C, Ty, OnlyIfReduced);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getUIToFP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1630,
   FQN="llvm::ConstantExpr::getUIToFP", NM="_ZN4llvm12ConstantExpr9getUIToFPEPNS_8ConstantEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr9getUIToFPEPNS_8ConstantEPNS_4TypeEb")
  //</editor-fold>
  public static Constant /*P*/ getUIToFP(Constant /*P*/ C, Type /*P*/ Ty) {
    return getUIToFP(C, Ty, false);
  }
  public static Constant /*P*/ getUIToFP(Constant /*P*/ C, Type /*P*/ Ty, boolean OnlyIfReduced/*= false*/) {
    boolean fromVec = C.getType().getTypeID() == Type.TypeID.VectorTyID;
    boolean toVec = Ty.getTypeID() == Type.TypeID.VectorTyID;
    assert ((fromVec == toVec)) : "Cannot convert from scalar to/from vector";
    assert (C.getType().isIntOrIntVectorTy() && Ty.isFPOrFPVectorTy()) : "This is an illegal uint to floating point cast!";
    return ConstantsStatics.getFoldedCast(Instruction.CastOps.UIToFP, C, Ty, OnlyIfReduced);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getSIToFP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1641,
   FQN="llvm::ConstantExpr::getSIToFP", NM="_ZN4llvm12ConstantExpr9getSIToFPEPNS_8ConstantEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr9getSIToFPEPNS_8ConstantEPNS_4TypeEb")
  //</editor-fold>
  public static Constant /*P*/ getSIToFP(Constant /*P*/ C, Type /*P*/ Ty) {
    return getSIToFP(C, Ty, false);
  }
  public static Constant /*P*/ getSIToFP(Constant /*P*/ C, Type /*P*/ Ty, boolean OnlyIfReduced/*= false*/) {
    boolean fromVec = C.getType().getTypeID() == Type.TypeID.VectorTyID;
    boolean toVec = Ty.getTypeID() == Type.TypeID.VectorTyID;
    assert ((fromVec == toVec)) : "Cannot convert from scalar to/from vector";
    assert (C.getType().isIntOrIntVectorTy() && Ty.isFPOrFPVectorTy()) : "This is an illegal sint to floating point cast!";
    return ConstantsStatics.getFoldedCast(Instruction.CastOps.SIToFP, C, Ty, OnlyIfReduced);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getFPToUI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1652,
   FQN="llvm::ConstantExpr::getFPToUI", NM="_ZN4llvm12ConstantExpr9getFPToUIEPNS_8ConstantEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr9getFPToUIEPNS_8ConstantEPNS_4TypeEb")
  //</editor-fold>
  public static Constant /*P*/ getFPToUI(Constant /*P*/ C, Type /*P*/ Ty) {
    return getFPToUI(C, Ty, false);
  }
  public static Constant /*P*/ getFPToUI(Constant /*P*/ C, Type /*P*/ Ty, boolean OnlyIfReduced/*= false*/) {
    boolean fromVec = C.getType().getTypeID() == Type.TypeID.VectorTyID;
    boolean toVec = Ty.getTypeID() == Type.TypeID.VectorTyID;
    assert ((fromVec == toVec)) : "Cannot convert from scalar to/from vector";
    assert (C.getType().isFPOrFPVectorTy() && Ty.isIntOrIntVectorTy()) : "This is an illegal floating point to uint cast!";
    return ConstantsStatics.getFoldedCast(Instruction.CastOps.FPToUI, C, Ty, OnlyIfReduced);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getFPToSI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1663,
   FQN="llvm::ConstantExpr::getFPToSI", NM="_ZN4llvm12ConstantExpr9getFPToSIEPNS_8ConstantEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr9getFPToSIEPNS_8ConstantEPNS_4TypeEb")
  //</editor-fold>
  public static Constant /*P*/ getFPToSI(Constant /*P*/ C, Type /*P*/ Ty) {
    return getFPToSI(C, Ty, false);
  }
  public static Constant /*P*/ getFPToSI(Constant /*P*/ C, Type /*P*/ Ty, boolean OnlyIfReduced/*= false*/) {
    boolean fromVec = C.getType().getTypeID() == Type.TypeID.VectorTyID;
    boolean toVec = Ty.getTypeID() == Type.TypeID.VectorTyID;
    assert ((fromVec == toVec)) : "Cannot convert from scalar to/from vector";
    assert (C.getType().isFPOrFPVectorTy() && Ty.isIntOrIntVectorTy()) : "This is an illegal floating point to sint cast!";
    return ConstantsStatics.getFoldedCast(Instruction.CastOps.FPToSI, C, Ty, OnlyIfReduced);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getPtrToInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1674,
   FQN="llvm::ConstantExpr::getPtrToInt", NM="_ZN4llvm12ConstantExpr11getPtrToIntEPNS_8ConstantEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr11getPtrToIntEPNS_8ConstantEPNS_4TypeEb")
  //</editor-fold>
  public static Constant /*P*/ getPtrToInt(Constant /*P*/ C, Type /*P*/ DstTy) {
    return getPtrToInt(C, DstTy, 
             false);
  }
  public static Constant /*P*/ getPtrToInt(Constant /*P*/ C, Type /*P*/ DstTy, 
             boolean OnlyIfReduced/*= false*/) {
    assert (C.getType().getScalarType().isPointerTy()) : "PtrToInt source must be pointer or pointer vector";
    assert (DstTy.getScalarType().isIntegerTy()) : "PtrToInt destination must be integer or integer vector";
    assert (isa_VectorType(C.getType()) == isa_VectorType(DstTy));
    if (isa_VectorType(C.getType())) {
      assert (C.getType().getVectorNumElements() == DstTy.getVectorNumElements()) : "Invalid cast between a different number of vector elements";
    }
    return ConstantsStatics.getFoldedCast(Instruction.CastOps.PtrToInt, C, DstTy, OnlyIfReduced);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getIntToPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1687,
   FQN="llvm::ConstantExpr::getIntToPtr", NM="_ZN4llvm12ConstantExpr11getIntToPtrEPNS_8ConstantEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr11getIntToPtrEPNS_8ConstantEPNS_4TypeEb")
  //</editor-fold>
  public static Constant /*P*/ getIntToPtr(Constant /*P*/ C, Type /*P*/ DstTy) {
    return getIntToPtr(C, DstTy, 
             false);
  }
  public static Constant /*P*/ getIntToPtr(Constant /*P*/ C, Type /*P*/ DstTy, 
             boolean OnlyIfReduced/*= false*/) {
    assert (C.getType().getScalarType().isIntegerTy()) : "IntToPtr source must be integer or integer vector";
    assert (DstTy.getScalarType().isPointerTy()) : "IntToPtr destination must be a pointer or pointer vector";
    assert (isa_VectorType(C.getType()) == isa_VectorType(DstTy));
    if (isa_VectorType(C.getType())) {
      assert (C.getType().getVectorNumElements() == DstTy.getVectorNumElements()) : "Invalid cast between a different number of vector elements";
    }
    return ConstantsStatics.getFoldedCast(Instruction.CastOps.IntToPtr, C, DstTy, OnlyIfReduced);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1700,
   FQN="llvm::ConstantExpr::getBitCast", NM="_ZN4llvm12ConstantExpr10getBitCastEPNS_8ConstantEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr10getBitCastEPNS_8ConstantEPNS_4TypeEb")
  //</editor-fold>
  public static Constant /*P*/ getBitCast(Constant /*P*/ C, Type /*P*/ DstTy) {
    return getBitCast(C, DstTy, 
            false);
  }
  public static Constant /*P*/ getBitCast(Constant /*P*/ C, Type /*P*/ DstTy, 
            boolean OnlyIfReduced/*= false*/) {
    assert (CastInst.castIsValid(Instruction.CastOps.BitCast, C, DstTy)) : "Invalid constantexpr bitcast!";
    
    // It is common to ask for a bitcast of a value to its own type, handle this
    // speedily.
    if (C.getType() == DstTy) {
      return C;
    }
    
    return ConstantsStatics.getFoldedCast(Instruction.CastOps.BitCast, C, DstTy, OnlyIfReduced);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getAddrSpaceCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1712,
   FQN="llvm::ConstantExpr::getAddrSpaceCast", NM="_ZN4llvm12ConstantExpr16getAddrSpaceCastEPNS_8ConstantEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr16getAddrSpaceCastEPNS_8ConstantEPNS_4TypeEb")
  //</editor-fold>
  public static Constant /*P*/ getAddrSpaceCast(Constant /*P*/ C, Type /*P*/ DstTy) {
    return getAddrSpaceCast(C, DstTy, 
                  false);
  }
  public static Constant /*P*/ getAddrSpaceCast(Constant /*P*/ C, Type /*P*/ DstTy, 
                  boolean OnlyIfReduced/*= false*/) {
    assert (CastInst.castIsValid(Instruction.CastOps.AddrSpaceCast, C, DstTy)) : "Invalid constantexpr addrspacecast!";
    
    // Canonicalize addrspacecasts between different pointer types by first
    // bitcasting the pointer type and then converting the address space.
    PointerType /*P*/ SrcScalarTy = cast_PointerType(C.getType().getScalarType());
    PointerType /*P*/ DstScalarTy = cast_PointerType(DstTy.getScalarType());
    Type /*P*/ DstElemTy = DstScalarTy.getElementType();
    if (SrcScalarTy.getElementType() != DstElemTy) {
      Type /*P*/ MidTy = PointerType.get(DstElemTy, SrcScalarTy.getAddressSpace());
      {
        VectorType /*P*/ VT = dyn_cast_VectorType(DstTy);
        if ((VT != null)) {
          // Handle vectors of pointers.
          MidTy = VectorType.get(MidTy, VT.getNumElements());
        }
      }
      C = getBitCast(C, MidTy);
    }
    return ConstantsStatics.getFoldedCast(Instruction.CastOps.AddrSpaceCast, C, DstTy, OnlyIfReduced);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getNSWNeg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 920,
   FQN="llvm::ConstantExpr::getNSWNeg", NM="_ZN4llvm12ConstantExpr9getNSWNegEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr9getNSWNegEPNS_8ConstantE")
  //</editor-fold>
  public static Constant /*P*/ getNSWNeg(Constant /*P*/ C) {
    return getNeg(C, false, true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getNUWNeg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 921,
   FQN="llvm::ConstantExpr::getNUWNeg", NM="_ZN4llvm12ConstantExpr9getNUWNegEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr9getNUWNegEPNS_8ConstantE")
  //</editor-fold>
  public static Constant /*P*/ getNUWNeg(Constant /*P*/ C) {
    return getNeg(C, true, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getNSWAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 922,
   FQN="llvm::ConstantExpr::getNSWAdd", NM="_ZN4llvm12ConstantExpr9getNSWAddEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr9getNSWAddEPNS_8ConstantES2_")
  //</editor-fold>
  public static Constant /*P*/ getNSWAdd(Constant /*P*/ C1, Constant /*P*/ C2) {
    return getAdd(C1, C2, false, true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getNUWAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 925,
   FQN="llvm::ConstantExpr::getNUWAdd", NM="_ZN4llvm12ConstantExpr9getNUWAddEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr9getNUWAddEPNS_8ConstantES2_")
  //</editor-fold>
  public static Constant /*P*/ getNUWAdd(Constant /*P*/ C1, Constant /*P*/ C2) {
    return getAdd(C1, C2, true, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getNSWSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 928,
   FQN="llvm::ConstantExpr::getNSWSub", NM="_ZN4llvm12ConstantExpr9getNSWSubEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr9getNSWSubEPNS_8ConstantES2_")
  //</editor-fold>
  public static Constant /*P*/ getNSWSub(Constant /*P*/ C1, Constant /*P*/ C2) {
    return getSub(C1, C2, false, true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getNUWSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 931,
   FQN="llvm::ConstantExpr::getNUWSub", NM="_ZN4llvm12ConstantExpr9getNUWSubEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr9getNUWSubEPNS_8ConstantES2_")
  //</editor-fold>
  public static Constant /*P*/ getNUWSub(Constant /*P*/ C1, Constant /*P*/ C2) {
    return getSub(C1, C2, true, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getNSWMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 934,
   FQN="llvm::ConstantExpr::getNSWMul", NM="_ZN4llvm12ConstantExpr9getNSWMulEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr9getNSWMulEPNS_8ConstantES2_")
  //</editor-fold>
  public static Constant /*P*/ getNSWMul(Constant /*P*/ C1, Constant /*P*/ C2) {
    return getMul(C1, C2, false, true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getNUWMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 937,
   FQN="llvm::ConstantExpr::getNUWMul", NM="_ZN4llvm12ConstantExpr9getNUWMulEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr9getNUWMulEPNS_8ConstantES2_")
  //</editor-fold>
  public static Constant /*P*/ getNUWMul(Constant /*P*/ C1, Constant /*P*/ C2) {
    return getMul(C1, C2, true, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getNSWShl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 940,
   FQN="llvm::ConstantExpr::getNSWShl", NM="_ZN4llvm12ConstantExpr9getNSWShlEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr9getNSWShlEPNS_8ConstantES2_")
  //</editor-fold>
  public static Constant /*P*/ getNSWShl(Constant /*P*/ C1, Constant /*P*/ C2) {
    return getShl(C1, C2, false, true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getNUWShl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 943,
   FQN="llvm::ConstantExpr::getNUWShl", NM="_ZN4llvm12ConstantExpr9getNUWShlEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr9getNUWShlEPNS_8ConstantES2_")
  //</editor-fold>
  public static Constant /*P*/ getNUWShl(Constant /*P*/ C1, Constant /*P*/ C2) {
    return getShl(C1, C2, true, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getExactSDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 946,
   FQN="llvm::ConstantExpr::getExactSDiv", NM="_ZN4llvm12ConstantExpr12getExactSDivEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr12getExactSDivEPNS_8ConstantES2_")
  //</editor-fold>
  public static Constant /*P*/ getExactSDiv(Constant /*P*/ C1, Constant /*P*/ C2) {
    return getSDiv(C1, C2, true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getExactUDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 949,
   FQN="llvm::ConstantExpr::getExactUDiv", NM="_ZN4llvm12ConstantExpr12getExactUDivEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr12getExactUDivEPNS_8ConstantES2_")
  //</editor-fold>
  public static Constant /*P*/ getExactUDiv(Constant /*P*/ C1, Constant /*P*/ C2) {
    return getUDiv(C1, C2, true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getExactAShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 952,
   FQN="llvm::ConstantExpr::getExactAShr", NM="_ZN4llvm12ConstantExpr12getExactAShrEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr12getExactAShrEPNS_8ConstantES2_")
  //</editor-fold>
  public static Constant /*P*/ getExactAShr(Constant /*P*/ C1, Constant /*P*/ C2) {
    return getAShr(C1, C2, true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getExactLShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 955,
   FQN="llvm::ConstantExpr::getExactLShr", NM="_ZN4llvm12ConstantExpr12getExactLShrEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr12getExactLShrEPNS_8ConstantES2_")
  //</editor-fold>
  public static Constant /*P*/ getExactLShr(Constant /*P*/ C1, Constant /*P*/ C2) {
    return getLShr(C1, C2, true);
  }

  
  /// Return the identity for the given binary operation,
  /// i.e. a constant C such that X op C = X and C op X = X for every X.  It
  /// returns null if the operator doesn't have an identity.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getBinOpIdentity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2220,
   FQN="llvm::ConstantExpr::getBinOpIdentity", NM="_ZN4llvm12ConstantExpr16getBinOpIdentityEjPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr16getBinOpIdentityEjPNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ getBinOpIdentity(/*uint*/int Opcode, Type /*P*/ Ty) {
    switch (Opcode) {
     default:
      // Doesn't have an identity.
      return null;
     case Instruction.BinaryOps.Add:
     case Instruction.BinaryOps.Or:
     case Instruction.BinaryOps.Xor:
      return Constant.getNullValue(Ty);
     case Instruction.BinaryOps.Mul:
      return ConstantInt.get(Ty, $int2ulong(1));
     case Instruction.BinaryOps.And:
      return Constant.getAllOnesValue(Ty);
    }
  }

  
  /// Return the absorbing element for the given binary
  /// operation, i.e. a constant C such that X op C = C and C op X = C for
  /// every X.  For example, this returns zero for integer multiplication.
  /// It returns null if the operator doesn't have an absorbing element.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getBinOpAbsorber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2239,
   FQN="llvm::ConstantExpr::getBinOpAbsorber", NM="_ZN4llvm12ConstantExpr16getBinOpAbsorberEjPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr16getBinOpAbsorberEjPNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ getBinOpAbsorber(/*uint*/int Opcode, Type /*P*/ Ty) {
    switch (Opcode) {
     default:
      // Doesn't have an absorber.
      return null;
     case Instruction.BinaryOps.Or:
      return Constant.getAllOnesValue(Ty);
     case Instruction.BinaryOps.And:
     case Instruction.BinaryOps.Mul:
      return Constant.getNullValue(Ty);
    }
  }


  /// Transparently provide more efficient getOperand methods.
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1191,
   FQN="llvm::ConstantExpr::getOperand", NM="_ZNK4llvm12ConstantExpr10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm12ConstantExpr10getOperandEj")
  //</editor-fold>
  public Constant /*P*/ getOperand_Constant(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsConstantExpr.operands(this))) : "getOperand() out of range!";
    return cast_or_null_Constant(OperandTraitsConstantExpr.op_begin(((/*const_cast*/ConstantExpr /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1191,
   FQN="llvm::ConstantExpr::setOperand", NM="_ZN4llvm12ConstantExpr10setOperandEjPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr10setOperandEjPNS_8ConstantE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Constant /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsConstantExpr.operands(this))) : "setOperand() out of range!";
    OperandTraitsConstantExpr.op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1191,
   FQN="llvm::ConstantExpr::op_begin", NM="_ZN4llvm12ConstantExpr8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr8op_beginEv")
  //</editor-fold>
  public type$ptr<Use/*P*/> op_begin() {
    return OperandTraitsConstantExpr.op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1191,
   FQN="llvm::ConstantExpr::op_begin", NM="_ZNK4llvm12ConstantExpr8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm12ConstantExpr8op_beginEv")
  //</editor-fold>
  public type$ptr<Use/*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsConstantExpr.op_begin(((/*const_cast*/ConstantExpr /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1191,
   FQN="llvm::ConstantExpr::op_end", NM="_ZN4llvm12ConstantExpr6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr6op_endEv")
  //</editor-fold>
  public type$ptr<Use/*P*/> op_end() {
    return OperandTraitsConstantExpr.op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1191,
   FQN="llvm::ConstantExpr::op_end", NM="_ZNK4llvm12ConstantExpr6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm12ConstantExpr6op_endEv")
  //</editor-fold>
  public type$ptr<Use/*P*/> op_end$Const() /*const*/ {
    return OperandTraitsConstantExpr.op_end(((/*const_cast*/ConstantExpr /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::Op">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1191,
   FQN="llvm::ConstantExpr::Op", NM="Tpl__ZN4llvm12ConstantExpr2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=Tpl__ZN4llvm12ConstantExpr2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::Op">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1191,
   FQN="llvm::ConstantExpr::Op", NM="Tpl__ZNK4llvm12ConstantExpr2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=Tpl__ZNK4llvm12ConstantExpr2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1191,
   FQN="llvm::ConstantExpr::getNumOperands", NM="_ZNK4llvm12ConstantExpr14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm12ConstantExpr14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsConstantExpr.operands(this);
  }

  
  /// \brief Convenience function for getting a Cast operation.
  ///
  /// \param ops The opcode for the conversion
  /// \param C  The constant to be converted
  /// \param Ty The type to which the constant is converted
  /// \param OnlyIfReduced see \a getWithOperands() docs.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1457,
   FQN="llvm::ConstantExpr::getCast", NM="_ZN4llvm12ConstantExpr7getCastEjPNS_8ConstantEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr7getCastEjPNS_8ConstantEPNS_4TypeEb")
  //</editor-fold>
  public static Constant /*P*/ getCast(/*uint*/int oc, Constant /*P*/ C, Type /*P*/ Ty) {
    return getCast(oc, C, Ty, 
         false);
  }
  public static Constant /*P*/ getCast(/*uint*/int oc, Constant /*P*/ C, Type /*P*/ Ty, 
         boolean OnlyIfReduced/*= false*/) {
    /*CastOps*/int opc = ((/*CastOps*/int)(oc));
    assert (Instruction.isCast(opc)) : "opcode out of range";
    assert ((C != null) && (Ty != null)) : "Null arguments to getCast";
    assert (CastInst.castIsValid(opc, C, Ty)) : "Invalid constantexpr cast!";
    switch (opc) {
     default:
      throw new llvm_unreachable("Invalid cast opcode");
     case Instruction.CastOps.Trunc:
      return getTrunc(C, Ty, OnlyIfReduced);
     case Instruction.CastOps.ZExt:
      return getZExt(C, Ty, OnlyIfReduced);
     case Instruction.CastOps.SExt:
      return getSExt(C, Ty, OnlyIfReduced);
     case Instruction.CastOps.FPTrunc:
      return getFPTrunc(C, Ty, OnlyIfReduced);
     case Instruction.CastOps.FPExt:
      return getFPExtend(C, Ty, OnlyIfReduced);
     case Instruction.CastOps.UIToFP:
      return getUIToFP(C, Ty, OnlyIfReduced);
     case Instruction.CastOps.SIToFP:
      return getSIToFP(C, Ty, OnlyIfReduced);
     case Instruction.CastOps.FPToUI:
      return getFPToUI(C, Ty, OnlyIfReduced);
     case Instruction.CastOps.FPToSI:
      return getFPToSI(C, Ty, OnlyIfReduced);
     case Instruction.CastOps.PtrToInt:
      return getPtrToInt(C, Ty, OnlyIfReduced);
     case Instruction.CastOps.IntToPtr:
      return getIntToPtr(C, Ty, OnlyIfReduced);
     case Instruction.CastOps.BitCast:
      return getBitCast(C, Ty, OnlyIfReduced);
     case Instruction.CastOps.AddrSpaceCast:
      return getAddrSpaceCast(C, Ty, OnlyIfReduced);
    }
  }

  
  // @brief Create a ZExt or BitCast cast constant expression
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getZExtOrBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1496,
   FQN="llvm::ConstantExpr::getZExtOrBitCast", NM="_ZN4llvm12ConstantExpr16getZExtOrBitCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr16getZExtOrBitCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ getZExtOrBitCast(Constant /*P*/ C, Type /*P*/ Ty) {
    if (C.getType().getScalarSizeInBits() == Ty.getScalarSizeInBits()) {
      return getBitCast(C, Ty);
    }
    return getZExt(C, Ty);
  }

  
  // @brief Create a SExt or BitCast cast constant expression
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getSExtOrBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1502,
   FQN="llvm::ConstantExpr::getSExtOrBitCast", NM="_ZN4llvm12ConstantExpr16getSExtOrBitCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr16getSExtOrBitCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ getSExtOrBitCast(Constant /*P*/ C, Type /*P*/ Ty) {
    if (C.getType().getScalarSizeInBits() == Ty.getScalarSizeInBits()) {
      return getBitCast(C, Ty);
    }
    return getSExt(C, Ty);
  }

  
  // @brief Create a Trunc or BitCast cast constant expression
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getTruncOrBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1508,
   FQN="llvm::ConstantExpr::getTruncOrBitCast", NM="_ZN4llvm12ConstantExpr17getTruncOrBitCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr17getTruncOrBitCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ getTruncOrBitCast(Constant /*P*/ C, Type /*P*/ Ty) {
    if (C.getType().getScalarSizeInBits() == Ty.getScalarSizeInBits()) {
      return getBitCast(C, Ty);
    }
    return getTrunc(C, Ty);
  }

  
  /// @brief Create a BitCast, AddrSpaceCast, or a PtrToInt cast constant
  /// expression.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getPointerCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1514,
   FQN="llvm::ConstantExpr::getPointerCast", NM="_ZN4llvm12ConstantExpr14getPointerCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr14getPointerCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ getPointerCast(Constant /*P*/ S, Type /*P*/ Ty) {
    assert (S.getType().isPtrOrPtrVectorTy()) : "Invalid cast";
    assert ((Ty.isIntOrIntVectorTy() || Ty.isPtrOrPtrVectorTy())) : "Invalid cast";
    if (Ty.isIntOrIntVectorTy()) {
      return getPtrToInt(S, Ty);
    }
    
    /*uint*/int SrcAS = S.getType().getPointerAddressSpace();
    if (Ty.isPtrOrPtrVectorTy() && SrcAS != Ty.getPointerAddressSpace()) {
      return getAddrSpaceCast(S, Ty);
    }
    
    return getBitCast(S, Ty);
  }

  
  /// @brief Create a BitCast or AddrSpaceCast for a pointer type depending on
  /// the address space.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getPointerBitCastOrAddrSpaceCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1529,
   FQN="llvm::ConstantExpr::getPointerBitCastOrAddrSpaceCast", NM="_ZN4llvm12ConstantExpr32getPointerBitCastOrAddrSpaceCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr32getPointerBitCastOrAddrSpaceCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ getPointerBitCastOrAddrSpaceCast(Constant /*P*/ S, 
                                  Type /*P*/ Ty) {
    assert (S.getType().isPtrOrPtrVectorTy()) : "Invalid cast";
    assert (Ty.isPtrOrPtrVectorTy()) : "Invalid cast";
    if (S.getType().getPointerAddressSpace() != Ty.getPointerAddressSpace()) {
      return getAddrSpaceCast(S, Ty);
    }
    
    return getBitCast(S, Ty);
  }

  
  /// @brief Create a ZExt, Bitcast or Trunc for integer -> integer casts
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getIntegerCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1540,
   FQN="llvm::ConstantExpr::getIntegerCast", NM="_ZN4llvm12ConstantExpr14getIntegerCastEPNS_8ConstantEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr14getIntegerCastEPNS_8ConstantEPNS_4TypeEb")
  //</editor-fold>
  public static Constant /*P*/ getIntegerCast(Constant /*P*/ C, Type /*P*/ Ty, boolean isSigned) {
    assert (C.getType().isIntOrIntVectorTy() && Ty.isIntOrIntVectorTy()) : "Invalid cast";
    /*uint*/int SrcBits = C.getType().getScalarSizeInBits();
    /*uint*/int DstBits = Ty.getScalarSizeInBits();
    /*CastOps*/int opcode = (SrcBits == DstBits ? Instruction.CastOps.BitCast : ($greater_uint(SrcBits, DstBits) ? Instruction.CastOps.Trunc : (isSigned ? Instruction.CastOps.SExt : Instruction.CastOps.ZExt)));
    return getCast(opcode, C, Ty);
  }

  
  /// @brief Create a FPExt, Bitcast or FPTrunc for fp -> fp casts
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getFPCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1552,
   FQN="llvm::ConstantExpr::getFPCast", NM="_ZN4llvm12ConstantExpr9getFPCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr9getFPCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ getFPCast(Constant /*P*/ C, Type /*P*/ Ty) {
    assert (C.getType().isFPOrFPVectorTy() && Ty.isFPOrFPVectorTy()) : "Invalid cast";
    /*uint*/int SrcBits = C.getType().getScalarSizeInBits();
    /*uint*/int DstBits = Ty.getScalarSizeInBits();
    if (SrcBits == DstBits) {
      return C; // Avoid a useless cast
    }
    /*CastOps*/int opcode = ($greater_uint(SrcBits, DstBits) ? Instruction.CastOps.FPTrunc : Instruction.CastOps.FPExt);
    return getCast(opcode, C, Ty);
  }

  
  /// @brief Return true if this is a convert constant expression
  
  // Utility function for determining if a ConstantExpr is a CastOp or not. This
  // can't be inline because we don't want to #include Instruction.h into
  // Constant.h
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::isCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1064,
   FQN="llvm::ConstantExpr::isCast", NM="_ZNK4llvm12ConstantExpr6isCastEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm12ConstantExpr6isCastEv")
  //</editor-fold>
  public boolean isCast() /*const*/ {
    return Instruction.isCast(getOpcode());
  }

  
  /// @brief Return true if this is a compare constant expression
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::isCompare">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1068,
   FQN="llvm::ConstantExpr::isCompare", NM="_ZNK4llvm12ConstantExpr9isCompareEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm12ConstantExpr9isCompareEv")
  //</editor-fold>
  public boolean isCompare() /*const*/ {
    return getOpcode() == Instruction.OtherOps.ICmp || getOpcode() == Instruction.OtherOps.FCmp;
  }

  
  /// @brief Return true if this is an insertvalue or extractvalue expression,
  /// and the getIndices() method may be used.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::hasIndices">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1097,
   FQN="llvm::ConstantExpr::hasIndices", NM="_ZNK4llvm12ConstantExpr10hasIndicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm12ConstantExpr10hasIndicesEv")
  //</editor-fold>
  public boolean hasIndices() /*const*/ {
    return getOpcode() == Instruction.OtherOps.ExtractValue
       || getOpcode() == Instruction.OtherOps.InsertValue;
  }

  
  /// @brief Return true if this is a getelementptr expression and all
  /// the index operands are compile-time known integers within the
  /// corresponding notional static array extents. Note that this is
  /// not equivalant to, a subset of, or a superset of the "inbounds"
  /// property.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::isGEPWithNoNotionalOverIndexing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1072,
   FQN="llvm::ConstantExpr::isGEPWithNoNotionalOverIndexing", NM="_ZNK4llvm12ConstantExpr31isGEPWithNoNotionalOverIndexingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm12ConstantExpr31isGEPWithNoNotionalOverIndexingEv")
  //</editor-fold>
  public boolean isGEPWithNoNotionalOverIndexing() /*const*/ {
    if (getOpcode() != Instruction.MemoryOps.GetElementPtr) {
      return false;
    }
    
    generic_gep_type_iterator GEPI = IrLlvmGlobals.gep_type_begin_User$C$P(this);
    generic_gep_type_iterator E = IrLlvmGlobals.gep_type_end_User$C$P(this);
    /*const*/type$ptr<Use /*P*/> OI = $tryClone(std.next(this.op_begin$Const()));
    
    // Skip the first index, as it has no static limit.
    GEPI.$preInc();
    OI.$preInc();
    
    // The remaining indices must be compile-time known integers within the
    // bounds of the corresponding notional static array types.
    for (; GEPI.$noteq(E); GEPI.$preInc() , OI.$preInc()) {
      ConstantInt /*P*/ CI = dyn_cast_ConstantInt(OI.$star());
      if (!(CI != null)) {
        return false;
      }
      {
        ArrayType /*P*/ ATy = dyn_cast_ArrayType(GEPI.$star());
        if ((ATy != null)) {
          if ($greater_uint(CI.getValue().getActiveBits(), 64)
             || $greatereq_ulong(CI.getZExtValue(), ATy.getNumElements())) {
            return false;
          }
        }
      }
    }
    
    // All the indices checked out.
    return true;
  }

  
  /// Select constant expr
  ///
  /// \param OnlyIfReducedTy see \a getWithOperands() docs.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getSelect">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1877,
   FQN="llvm::ConstantExpr::getSelect", NM="_ZN4llvm12ConstantExpr9getSelectEPNS_8ConstantES2_S2_PNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr9getSelectEPNS_8ConstantES2_S2_PNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ getSelect(Constant /*P*/ C, Constant /*P*/ V1, Constant /*P*/ V2) {
    return getSelect(C, V1, V2, 
           (Type /*P*/ )null);
  }
  public static Constant /*P*/ getSelect(Constant /*P*/ C, Constant /*P*/ V1, Constant /*P*/ V2, 
           Type /*P*/ OnlyIfReducedTy/*= null*/) {
    assert (!Native.$bool(SelectInst.areInvalidOperands(C, V1, V2))) : "Invalid select operands";
    {
      
      Constant /*P*/ SC = ConstantFoldLlvmStatics.ConstantFoldSelectInstruction(C, V1, V2);
      if ((SC != null)) {
        return SC; // Fold common cases
      }
    }
    if (OnlyIfReducedTy == V1.getType()) {
      return null;
    }
    
    Constant /*P*/ ArgVec[/*3*/] = new Constant /*P*/  [/*3*/] {C, V1, V2};
    ConstantExprKeyType Key/*J*/= new ConstantExprKeyType(Instruction.OtherOps.Select, new ArrayRef<Constant /*P*/ >(ArgVec, true));
    
    LLVMContextImpl /*P*/ pImpl = C.getContext().pImpl;
    return pImpl.ExprConstants.getOrCreate(V1.getType(), new ConstantExprKeyType(Key));
  }

  
  /// get - Return a binary or shift operator constant expression,
  /// folding if possible.
  ///
  /// \param OnlyIfReducedTy see \a getWithOperands() docs.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::get">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1733,
   FQN="llvm::ConstantExpr::get", NM="_ZN4llvm12ConstantExpr3getEjPNS_8ConstantES2_jPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr3getEjPNS_8ConstantES2_jPNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ get(/*uint*/int Opcode, Constant /*P*/ C1, Constant /*P*/ C2) {
    return get(Opcode, C1, C2, 
     0, (Type /*P*/ )null);
  }
  public static Constant /*P*/ get(/*uint*/int Opcode, Constant /*P*/ C1, Constant /*P*/ C2, 
     /*uint*/int Flags/*= 0*/) {
    return get(Opcode, C1, C2, 
     Flags, (Type /*P*/ )null);
  }
  public static Constant /*P*/ get(/*uint*/int Opcode, Constant /*P*/ C1, Constant /*P*/ C2, 
     /*uint*/int Flags/*= 0*/, Type /*P*/ OnlyIfReducedTy/*= null*/) {
    // Check the operands for consistency first.
    assert ($greatereq_uint_int(Opcode, Instruction.BinaryOps.BinaryOpsBegin) && $less_uint_int(Opcode, Instruction.BinaryOps.BinaryOpsEnd)) : "Invalid opcode in binary constant expression";
    assert (C1.getType() == C2.getType()) : "Operand types in binary constant expression should match";
    switch (Opcode) {
     case Instruction.BinaryOps.Add:
     case Instruction.BinaryOps.Sub:
     case Instruction.BinaryOps.Mul:
      assert (C1.getType() == C2.getType()) : "Op types should be identical!";
      assert (C1.getType().isIntOrIntVectorTy()) : "Tried to create an integer operation on a non-integer type!";
      break;
     case Instruction.BinaryOps.FAdd:
     case Instruction.BinaryOps.FSub:
     case Instruction.BinaryOps.FMul:
      assert (C1.getType() == C2.getType()) : "Op types should be identical!";
      assert (C1.getType().isFPOrFPVectorTy()) : "Tried to create a floating-point operation on a non-floating-point type!";
      break;
     case Instruction.BinaryOps.UDiv:
     case Instruction.BinaryOps.SDiv:
      assert (C1.getType() == C2.getType()) : "Op types should be identical!";
      assert (C1.getType().isIntOrIntVectorTy()) : "Tried to create an arithmetic operation on a non-arithmetic type!";
      break;
     case Instruction.BinaryOps.FDiv:
      assert (C1.getType() == C2.getType()) : "Op types should be identical!";
      assert (C1.getType().isFPOrFPVectorTy()) : "Tried to create an arithmetic operation on a non-arithmetic type!";
      break;
     case Instruction.BinaryOps.URem:
     case Instruction.BinaryOps.SRem:
      assert (C1.getType() == C2.getType()) : "Op types should be identical!";
      assert (C1.getType().isIntOrIntVectorTy()) : "Tried to create an arithmetic operation on a non-arithmetic type!";
      break;
     case Instruction.BinaryOps.FRem:
      assert (C1.getType() == C2.getType()) : "Op types should be identical!";
      assert (C1.getType().isFPOrFPVectorTy()) : "Tried to create an arithmetic operation on a non-arithmetic type!";
      break;
     case Instruction.BinaryOps.And:
     case Instruction.BinaryOps.Or:
     case Instruction.BinaryOps.Xor:
      assert (C1.getType() == C2.getType()) : "Op types should be identical!";
      assert (C1.getType().isIntOrIntVectorTy()) : "Tried to create a logical operation on a non-integral type!";
      break;
     case Instruction.BinaryOps.Shl:
     case Instruction.BinaryOps.LShr:
     case Instruction.BinaryOps.AShr:
      assert (C1.getType() == C2.getType()) : "Op types should be identical!";
      assert (C1.getType().isIntOrIntVectorTy()) : "Tried to create a shift operation on a non-integer type!";
      break;
     default:
      break;
    }
    {
      
      Constant /*P*/ FC = ConstantFoldLlvmStatics.ConstantFoldBinaryInstruction(Opcode, C1, C2);
      if ((FC != null)) {
        return FC; // Fold a few common cases.
      }
    }
    if (OnlyIfReducedTy == C1.getType()) {
      return null;
    }
    
    Constant /*P*/ ArgVec[/*2*/] = new Constant /*P*/  [/*2*/] {C1, C2};
    ConstantExprKeyType Key/*J*/= new ConstantExprKeyType(Opcode, new ArrayRef<Constant /*P*/ >(ArgVec, true), $int2ushort(0), $uint2ushort(Flags));
    
    LLVMContextImpl /*P*/ pImpl = C1.getContext().pImpl;
    return pImpl.ExprConstants.getOrCreate(C1.getType(), new ConstantExprKeyType(Key));
  }

  
  /// \brief Return an ICmp or FCmp comparison operator constant expression.
  ///
  /// \param OnlyIfReduced see \a getWithOperands() docs.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getCompare">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1855,
   FQN="llvm::ConstantExpr::getCompare", NM="_ZN4llvm12ConstantExpr10getCompareEtPNS_8ConstantES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr10getCompareEtPNS_8ConstantES2_b")
  //</editor-fold>
  public static Constant /*P*/ getCompare(/*ushort*/char Predicate, Constant /*P*/ C1, 
            Constant /*P*/ C2) {
    return getCompare(Predicate, C1, 
            C2, false);
  }
  public static Constant /*P*/ getCompare(/*ushort*/char Predicate, Constant /*P*/ C1, 
            Constant /*P*/ C2, boolean OnlyIfReduced/*= false*/) {
    assert (C1.getType() == C2.getType()) : "Op types should be identical!";
    switch (CmpInst.Predicate.valueOf($ushort2int(Predicate))) {
     default:
      throw new llvm_unreachable("Invalid CmpInst predicate");
     case FCMP_FALSE:
     case FCMP_OEQ:
     case FCMP_OGT:
     case FCMP_OGE:
     case FCMP_OLT:
     case FCMP_OLE:
     case FCMP_ONE:
     case FCMP_ORD:
     case FCMP_UNO:
     case FCMP_UEQ:
     case FCMP_UGT:
     case FCMP_UGE:
     case FCMP_ULT:
     case FCMP_ULE:
     case FCMP_UNE:
     case FCMP_TRUE:
      return getFCmp(Predicate, C1, C2, OnlyIfReduced);
     case ICMP_EQ:
     case ICMP_NE:
     case ICMP_UGT:
     case ICMP_UGE:
     case ICMP_ULT:
     case ICMP_ULE:
     case ICMP_SGT:
     case ICMP_SGE:
     case ICMP_SLT:
     case ICMP_SLE:
      return getICmp(Predicate, C1, C2, OnlyIfReduced);
    }
  }

  
  /// get* - Return some common constants without having to
  /// specify the full Instruction::OPCODE identifier.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getICmp">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1948,
   FQN="llvm::ConstantExpr::getICmp", NM="_ZN4llvm12ConstantExpr7getICmpEtPNS_8ConstantES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr7getICmpEtPNS_8ConstantES2_b")
  //</editor-fold>
  public static Constant /*P*/ getICmp(/*ushort*/char pred, Constant /*P*/ LHS, 
         Constant /*P*/ RHS) {
    return getICmp(pred, LHS, 
         RHS, false);
  }
  public static Constant /*P*/ getICmp(/*ushort*/char pred, Constant /*P*/ LHS, 
         Constant /*P*/ RHS, boolean OnlyIfReduced/*= false*/) {
    assert (LHS.getType() == RHS.getType());
    assert ($ushort2int(pred) >= ICmpInst.Predicate.FIRST_ICMP_PREDICATE.getValue() && $ushort2int(pred) <= ICmpInst.Predicate.LAST_ICMP_PREDICATE.getValue()) : "Invalid ICmp Predicate";
    {
      
      Constant /*P*/ FC = ConstantFoldLlvmStatics.ConstantFoldCompareInstruction(pred, LHS, RHS);
      if ((FC != null)) {
        return FC; // Fold a few common cases...
      }
    }
    if (OnlyIfReduced) {
      return null;
    }
    
    // Look up the constant in the table first to ensure uniqueness
    Constant /*P*/ ArgVec[/*2*/] = new Constant /*P*/  [/*2*/] {LHS, RHS};
    // Get the key type with both the opcode and predicate
    /*const*/ ConstantExprKeyType Key/*J*/= new ConstantExprKeyType(Instruction.OtherOps.ICmp, new ArrayRef<Constant /*P*/ >(ArgVec, true), pred);
    
    Type /*P*/ ResultTy = Type.getInt1Ty(LHS.getContext());
    {
      VectorType /*P*/ VT = dyn_cast_VectorType(LHS.getType());
      if ((VT != null)) {
        ResultTy = VectorType.get(ResultTy, VT.getNumElements());
      }
    }
    
    LLVMContextImpl /*P*/ pImpl = LHS.getType().getContext().pImpl;
    return pImpl.ExprConstants.getOrCreate(ResultTy, new ConstantExprKeyType(Key));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getFCmp">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1973,
   FQN="llvm::ConstantExpr::getFCmp", NM="_ZN4llvm12ConstantExpr7getFCmpEtPNS_8ConstantES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr7getFCmpEtPNS_8ConstantES2_b")
  //</editor-fold>
  public static Constant /*P*/ getFCmp(/*ushort*/char pred, Constant /*P*/ LHS, 
         Constant /*P*/ RHS) {
    return getFCmp(pred, LHS, 
         RHS, false);
  }
  public static Constant /*P*/ getFCmp(/*ushort*/char pred, Constant /*P*/ LHS, 
         Constant /*P*/ RHS, boolean OnlyIfReduced/*= false*/) {
    assert (LHS.getType() == RHS.getType());
    assert ($ushort2int(pred) <= FCmpInst.Predicate.LAST_FCMP_PREDICATE.getValue()) : "Invalid FCmp Predicate";
    {
      
      Constant /*P*/ FC = ConstantFoldLlvmStatics.ConstantFoldCompareInstruction(pred, LHS, RHS);
      if ((FC != null)) {
        return FC; // Fold a few common cases...
      }
    }
    if (OnlyIfReduced) {
      return null;
    }
    
    // Look up the constant in the table first to ensure uniqueness
    Constant /*P*/ ArgVec[/*2*/] = new Constant /*P*/  [/*2*/] {LHS, RHS};
    // Get the key type with both the opcode and predicate
    /*const*/ ConstantExprKeyType Key/*J*/= new ConstantExprKeyType(Instruction.OtherOps.FCmp, new ArrayRef<Constant /*P*/ >(ArgVec, true), pred);
    
    Type /*P*/ ResultTy = Type.getInt1Ty(LHS.getContext());
    {
      VectorType /*P*/ VT = dyn_cast_VectorType(LHS.getType());
      if ((VT != null)) {
        ResultTy = VectorType.get(ResultTy, VT.getNumElements());
      }
    }
    
    LLVMContextImpl /*P*/ pImpl = LHS.getType().getContext().pImpl;
    return pImpl.ExprConstants.getOrCreate(ResultTy, new ConstantExprKeyType(Key));
  }

  
  /// Getelementptr form.  Value* is only accepted for convenience;
  /// all elements must be Constants.
  ///
  /// \param OnlyIfReducedTy see \a getWithOperands() docs.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getGetElementPtr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1075,
   FQN="llvm::ConstantExpr::getGetElementPtr", NM="_ZN4llvm12ConstantExpr16getGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIS4_EEbS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr16getGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIS4_EEbS2_")
  //</editor-fold>
  public static Constant /*P*/ getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P(Type /*P*/ Ty, Constant /*P*/ C, 
                                                                    ArrayRef<Constant /*P*/ > IdxList) {
    return getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P(Ty, C, 
                                                                    IdxList, 
                                                                    false, 
                                                                    (Type /*P*/ )null);
  }
  public static Constant /*P*/ getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P(Type /*P*/ Ty, Constant /*P*/ C, 
                                                                    ArrayRef<Constant /*P*/ > IdxList, 
                                                                    boolean InBounds/*= false*/) {
    return getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P(Ty, C, 
                                                                    IdxList, 
                                                                    InBounds, 
                                                                    (Type /*P*/ )null);
  }
  public static Constant /*P*/ getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P(Type /*P*/ Ty, Constant /*P*/ C, 
                                                                    ArrayRef<Constant /*P*/ > IdxList, 
                                                                    boolean InBounds/*= false*/, 
                                                                    Type /*P*/ OnlyIfReducedTy/*= null*/) {
    return getGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P_bool_Type$P(Ty, C, makeArrayRef((type$ptr<Value /*P*/ /*const*/ /*P*/>)(type$ptr)IdxList.data(), IdxList.size(), true), 
        InBounds, OnlyIfReducedTy);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1083,
   FQN="llvm::ConstantExpr::getGetElementPtr", NM="_ZN4llvm12ConstantExpr16getGetElementPtrEPNS_4TypeEPNS_8ConstantES4_bS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr16getGetElementPtrEPNS_4TypeEPNS_8ConstantES4_bS2_")
  //</editor-fold>
  public static Constant /*P*/ getGetElementPtr(Type /*P*/ Ty, Constant /*P*/ C, Constant /*P*/ Idx) {
    return getGetElementPtr(Ty, C, Idx, 
                  false, 
                  (Type /*P*/ )null);
  }
  public static Constant /*P*/ getGetElementPtr(Type /*P*/ Ty, Constant /*P*/ C, Constant /*P*/ Idx, 
                  boolean InBounds/*= false*/) {
    return getGetElementPtr(Ty, C, Idx, 
                  InBounds, 
                  (Type /*P*/ )null);
  }
  public static Constant /*P*/ getGetElementPtr(Type /*P*/ Ty, Constant /*P*/ C, Constant /*P*/ Idx, 
                  boolean InBounds/*= false*/, 
                  Type /*P*/ OnlyIfReducedTy/*= null*/) {
    // This form of the function only exists to avoid ambiguous overload
    // warnings about whether to convert Idx to ArrayRef<Constant *> or
    // ArrayRef<Value *>.
    return getGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P_bool_Type$P(Ty, C, new ArrayRef<Value /*P*/ >(cast_Value(Idx), true), InBounds, OnlyIfReducedTy);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getGetElementPtr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1894,
   FQN="llvm::ConstantExpr::getGetElementPtr", NM="_ZN4llvm12ConstantExpr16getGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIPNS_5ValueEEEbS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr16getGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIPNS_5ValueEEEbS2_")
  //</editor-fold>
  public static Constant /*P*/ getGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P_bool_Type$P(Type /*P*/ Ty, Constant /*P*/ C, 
                                                                 ArrayRef<Value /*P*/ > Idxs) {
    return getGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P_bool_Type$P(Ty, C, 
                                                                 Idxs, false, 
                                                                 (Type /*P*/ )null);
  }
  public static Constant /*P*/ getGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P_bool_Type$P(Type /*P*/ Ty, Constant /*P*/ C, 
                                                                 ArrayRef<Value /*P*/ > Idxs, boolean InBounds/*= false*/) {
    return getGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P_bool_Type$P(Ty, C, 
                                                                 Idxs, InBounds, 
                                                                 (Type /*P*/ )null);
  }
  public static Constant /*P*/ getGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P_bool_Type$P(Type /*P*/ Ty, Constant /*P*/ C, 
                                                                 ArrayRef<Value /*P*/ > Idxs, boolean InBounds/*= false*/, 
                                                                 Type /*P*/ OnlyIfReducedTy/*= null*/) {
    std.vector<Constant /*P*/ > ArgVec = null;
    try {
      if (!(Ty != null)) {
        Ty = cast_PointerType(C.getType().getScalarType()).getElementType();
      } else {
        assert (Ty == cast_PointerType(C.getType().getScalarType()).getContainedType(0/*U*/));
      }
      {
        
        Constant /*P*/ FC = ConstantFoldLlvmStatics.ConstantFoldGetElementPtr_Type$P_Constant$P_bool_ArrayRef$Value$P(Ty, C, InBounds, new ArrayRef<Value /*P*/ >(Idxs));
        if ((FC != null)) {
          return FC; // Fold a few common cases.
        }
      }
      
      // Get the result type of the getelementptr!
      Type /*P*/ DestTy = GetElementPtrInst.getIndexedType_Type$P_ArrayRef$Value$P(Ty, new ArrayRef<Value /*P*/ >(Idxs));
      assert ((DestTy != null)) : "GEP indices invalid!";
      /*uint*/int AS = C.getType().getPointerAddressSpace();
      Type /*P*/ ReqTy = DestTy.getPointerTo(AS);
      
      /*uint*/int NumVecElts = 0;
      if (C.getType().isVectorTy()) {
        NumVecElts = C.getType().getVectorNumElements();
      } else {
        for (Value /*P*/ Idx : Idxs)  {
          if (Idx.getType().isVectorTy()) {
            NumVecElts = Idx.getType().getVectorNumElements();
          }
        }
      }
      if ((NumVecElts != 0)) {
        ReqTy = VectorType.get(ReqTy, NumVecElts);
      }
      if (OnlyIfReducedTy == ReqTy) {
        return null;
      }
      
      // Look up the constant in the table first to ensure uniqueness
      ArgVec/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      ArgVec.reserve(1 + Idxs.size());
      ArgVec.push_back_T$C$R(C);
      for (/*uint*/int i = 0, e = Idxs.size(); i != e; ++i) {
        assert ((!Idxs.$at(i).getType().isVectorTy() || Idxs.$at(i).getType().getVectorNumElements() == NumVecElts)) : "getelementptr index type missmatch";
        
        Constant /*P*/ Idx = cast_Constant(Idxs.$at(i));
        if ((NumVecElts != 0) && !Idxs.$at(i).getType().isVectorTy()) {
          Idx = ConstantVector.getSplat(NumVecElts, Idx);
        }
        ArgVec.push_back_T$C$R(Idx);
      }
      /*const*/ ConstantExprKeyType Key/*J*/= new ConstantExprKeyType(Instruction.MemoryOps.GetElementPtr, new ArrayRef<Constant /*P*/ >(ArgVec, true), $int2ushort(0), 
          $int2ushort(InBounds ? GEPOperator.IsInBounds : 0), new ArrayRefUInt(None), 
          Ty);
      
      LLVMContextImpl /*P*/ pImpl = C.getContext().pImpl;
      return pImpl.ExprConstants.getOrCreate(ReqTy, new ConstantExprKeyType(Key));
    } finally {
      if (ArgVec != null) { ArgVec.$destroy(); }
    }
  }

  
  /// Create an "inbounds" getelementptr. See the documentation for the
  /// "inbounds" flag in LangRef.html for details.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getInBoundsGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1098,
   FQN="llvm::ConstantExpr::getInBoundsGetElementPtr", NM="_ZN4llvm12ConstantExpr24getInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr24getInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIS4_EE")
  //</editor-fold>
  public static Constant /*P*/ getInBoundsGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P(Type /*P*/ Ty, Constant /*P*/ C, 
                                                                ArrayRef<Constant /*P*/ > IdxList) {
    return ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P(Ty, C, new ArrayRef<Constant /*P*/ >(IdxList), true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getInBoundsGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1102,
   FQN="llvm::ConstantExpr::getInBoundsGetElementPtr", NM="_ZN4llvm12ConstantExpr24getInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr24getInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantES4_")
  //</editor-fold>
  public static Constant /*P*/ getInBoundsGetElementPtr(Type /*P*/ Ty, Constant /*P*/ C, 
                          Constant /*P*/ Idx) {
    // This form of the function only exists to avoid ambiguous overload
    // warnings about whether to convert Idx to ArrayRef<Constant *> or
    // ArrayRef<Value *>.
    return ConstantExpr.getGetElementPtr(Ty, C, Idx, true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getInBoundsGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1109,
   FQN="llvm::ConstantExpr::getInBoundsGetElementPtr", NM="_ZN4llvm12ConstantExpr24getInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIPNS_5ValueEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr24getInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIPNS_5ValueEEE")
  //</editor-fold>
  public static Constant /*P*/ getInBoundsGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P(Type /*P*/ Ty, Constant /*P*/ C, 
                                                             ArrayRef<Value /*P*/ > IdxList) {
    return getGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P_bool_Type$P(Ty, C, new ArrayRef<Value /*P*/ >(IdxList), true);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getExtractElement">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1997,
   FQN="llvm::ConstantExpr::getExtractElement", NM="_ZN4llvm12ConstantExpr17getExtractElementEPNS_8ConstantES2_PNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr17getExtractElementEPNS_8ConstantES2_PNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ getExtractElement(Constant /*P*/ Val, Constant /*P*/ Idx) {
    return getExtractElement(Val, Idx, 
                   (Type /*P*/ )null);
  }
  public static Constant /*P*/ getExtractElement(Constant /*P*/ Val, Constant /*P*/ Idx, 
                   Type /*P*/ OnlyIfReducedTy/*= null*/) {
    assert (Val.getType().isVectorTy()) : "Tried to create extractelement operation on non-vector type!";
    assert (Idx.getType().isIntegerTy()) : "Extractelement index must be an integer type!";
    {
      
      Constant /*P*/ FC = ConstantFoldLlvmStatics.ConstantFoldExtractElementInstruction(Val, Idx);
      if ((FC != null)) {
        return FC; // Fold a few common cases.
      }
    }
    
    Type /*P*/ ReqTy = Val.getType().getVectorElementType();
    if (OnlyIfReducedTy == ReqTy) {
      return null;
    }
    
    // Look up the constant in the table first to ensure uniqueness
    Constant /*P*/ ArgVec[/*2*/] = new Constant /*P*/  [/*2*/] {Val, Idx};
    /*const*/ ConstantExprKeyType Key/*J*/= new ConstantExprKeyType(Instruction.OtherOps.ExtractElement, new ArrayRef<Constant /*P*/ >(ArgVec, true));
    
    LLVMContextImpl /*P*/ pImpl = Val.getContext().pImpl;
    return pImpl.ExprConstants.getOrCreate(ReqTy, new ConstantExprKeyType(Key));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getInsertElement">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2019,
   FQN="llvm::ConstantExpr::getInsertElement", NM="_ZN4llvm12ConstantExpr16getInsertElementEPNS_8ConstantES2_S2_PNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr16getInsertElementEPNS_8ConstantES2_S2_PNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ getInsertElement(Constant /*P*/ Val, Constant /*P*/ Elt, 
                  Constant /*P*/ Idx) {
    return getInsertElement(Val, Elt, 
                  Idx, (Type /*P*/ )null);
  }
  public static Constant /*P*/ getInsertElement(Constant /*P*/ Val, Constant /*P*/ Elt, 
                  Constant /*P*/ Idx, Type /*P*/ OnlyIfReducedTy/*= null*/) {
    assert (Val.getType().isVectorTy()) : "Tried to create insertelement operation on non-vector type!";
    assert (Elt.getType() == Val.getType().getVectorElementType()) : "Insertelement types must match!";
    assert (Idx.getType().isIntegerTy()) : "Insertelement index must be i32 type!";
    {
      
      Constant /*P*/ FC = ConstantFoldLlvmStatics.ConstantFoldInsertElementInstruction(Val, Elt, Idx);
      if ((FC != null)) {
        return FC; // Fold a few common cases.
      }
    }
    if (OnlyIfReducedTy == Val.getType()) {
      return null;
    }
    
    // Look up the constant in the table first to ensure uniqueness
    Constant /*P*/ ArgVec[/*3*/] = new Constant /*P*/  [/*3*/] {Val, Elt, Idx};
    /*const*/ ConstantExprKeyType Key/*J*/= new ConstantExprKeyType(Instruction.OtherOps.InsertElement, new ArrayRef<Constant /*P*/ >(ArgVec, true));
    
    LLVMContextImpl /*P*/ pImpl = Val.getContext().pImpl;
    return pImpl.ExprConstants.getOrCreate(Val.getType(), new ConstantExprKeyType(Key));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getShuffleVector">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2042,
   FQN="llvm::ConstantExpr::getShuffleVector", NM="_ZN4llvm12ConstantExpr16getShuffleVectorEPNS_8ConstantES2_S2_PNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr16getShuffleVectorEPNS_8ConstantES2_S2_PNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ getShuffleVector(Constant /*P*/ V1, Constant /*P*/ V2, 
                  Constant /*P*/ Mask) {
    return getShuffleVector(V1, V2, 
                  Mask, (Type /*P*/ )null);
  }
  public static Constant /*P*/ getShuffleVector(Constant /*P*/ V1, Constant /*P*/ V2, 
                  Constant /*P*/ Mask, Type /*P*/ OnlyIfReducedTy/*= null*/) {
    assert (ShuffleVectorInst.isValidOperands(V1, V2, Mask)) : "Invalid shuffle vector constant expr operands!";
    {
      
      Constant /*P*/ FC = ConstantFoldLlvmStatics.ConstantFoldShuffleVectorInstruction(V1, V2, Mask);
      if ((FC != null)) {
        return FC; // Fold a few common cases.
      }
    }
    
    /*uint*/int NElts = Mask.getType().getVectorNumElements();
    Type /*P*/ EltTy = V1.getType().getVectorElementType();
    Type /*P*/ ShufTy = VectorType.get(EltTy, NElts);
    if (OnlyIfReducedTy == ShufTy) {
      return null;
    }
    
    // Look up the constant in the table first to ensure uniqueness
    Constant /*P*/ ArgVec[/*3*/] = new Constant /*P*/  [/*3*/] {V1, V2, Mask};
    /*const*/ ConstantExprKeyType Key/*J*/= new ConstantExprKeyType(Instruction.OtherOps.ShuffleVector, new ArrayRef<Constant /*P*/ >(ArgVec, true));
    
    LLVMContextImpl /*P*/ pImpl = ShufTy.getContext().pImpl;
    return pImpl.ExprConstants.getOrCreate(ShufTy, new ConstantExprKeyType(Key));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getExtractValue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2089,
   FQN="llvm::ConstantExpr::getExtractValue", NM="_ZN4llvm12ConstantExpr15getExtractValueEPNS_8ConstantENS_8ArrayRefIjEEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr15getExtractValueEPNS_8ConstantENS_8ArrayRefIjEEPNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ getExtractValue(Constant /*P*/ Agg, ArrayRefUInt Idxs) {
    return getExtractValue(Agg, Idxs, 
                 (Type /*P*/ )null);
  }
  public static Constant /*P*/ getExtractValue(Constant /*P*/ Agg, ArrayRefUInt Idxs, 
                 Type /*P*/ OnlyIfReducedTy/*= null*/) {
    assert (Agg.getType().isFirstClassType()) : "Tried to create extractelement operation on non-first-class type!";
    
    Type /*P*/ ReqTy = ExtractValueInst.getIndexedType(Agg.getType(), new ArrayRefUInt(Idxs));
    ///*J:(void)*/ReqTy;
    assert ((ReqTy != null)) : "extractvalue indices invalid!";
    assert (Agg.getType().isFirstClassType()) : "Non-first-class type for constant extractvalue expression";
    {
      Constant /*P*/ FC = ConstantFoldLlvmStatics.ConstantFoldExtractValueInstruction(Agg, new ArrayRefUInt(Idxs));
      if ((FC != null)) {
        return FC;
      }
    }
    if (OnlyIfReducedTy == ReqTy) {
      return null;
    }
    
    Constant /*P*/ ArgVec[/*1*/] = new Constant /*P*/  [/*1*/] {Agg};
    /*const*/ ConstantExprKeyType Key/*J*/= new ConstantExprKeyType(Instruction.OtherOps.ExtractValue, new ArrayRef<Constant /*P*/ >(ArgVec, true), $int2ushort(0), $int2ushort(0), new ArrayRefUInt(Idxs));
    
    LLVMContextImpl /*P*/ pImpl = Agg.getContext().pImpl;
    return pImpl.ExprConstants.getOrCreate(ReqTy, new ConstantExprKeyType(Key));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getInsertValue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2065,
   FQN="llvm::ConstantExpr::getInsertValue", NM="_ZN4llvm12ConstantExpr14getInsertValueEPNS_8ConstantES2_NS_8ArrayRefIjEEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr14getInsertValueEPNS_8ConstantES2_NS_8ArrayRefIjEEPNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ getInsertValue(Constant /*P*/ Agg, Constant /*P*/ Val, 
                ArrayRefUInt Idxs) {
    return getInsertValue(Agg, Val, 
                Idxs, 
                (Type /*P*/ )null);
  }
  public static Constant /*P*/ getInsertValue(Constant /*P*/ Agg, Constant /*P*/ Val, 
                ArrayRefUInt Idxs, 
                Type /*P*/ OnlyIfReducedTy/*= null*/) {
    assert (Agg.getType().isFirstClassType()) : "Non-first-class type for constant insertvalue expression";
    assert (ExtractValueInst.getIndexedType(Agg.getType(), new ArrayRefUInt(Idxs)) == Val.getType()) : "insertvalue indices invalid!";
    Type /*P*/ ReqTy = Val.getType();
    {
      
      Constant /*P*/ FC = ConstantFoldLlvmStatics.ConstantFoldInsertValueInstruction(Agg, Val, new ArrayRefUInt(Idxs));
      if ((FC != null)) {
        return FC;
      }
    }
    if (OnlyIfReducedTy == ReqTy) {
      return null;
    }
    
    Constant /*P*/ ArgVec[/*2*/] = new Constant /*P*/  [/*2*/] {Agg, Val};
    /*const*/ ConstantExprKeyType Key/*J*/= new ConstantExprKeyType(Instruction.OtherOps.InsertValue, new ArrayRef<Constant /*P*/ >(ArgVec, true), $int2ushort(0), $int2ushort(0), new ArrayRefUInt(Idxs));
    
    LLVMContextImpl /*P*/ pImpl = Agg.getContext().pImpl;
    return pImpl.ExprConstants.getOrCreate(ReqTy, new ConstantExprKeyType(Key));
  }

  
  /// Return the opcode at the root of this constant expression
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getOpcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1127,
   FQN="llvm::ConstantExpr::getOpcode", NM="_ZNK4llvm12ConstantExpr9getOpcodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm12ConstantExpr9getOpcodeEv")
  //</editor-fold>
  public /*uint*/int getOpcode() /*const*/ {
    return $ushort2uint(getSubclassDataFromValue());
  }

  
  /// Return the ICMP or FCMP predicate value. Assert if this is not an ICMP or
  /// FCMP constant expression.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getPredicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1110,
   FQN="llvm::ConstantExpr::getPredicate", NM="_ZNK4llvm12ConstantExpr12getPredicateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm12ConstantExpr12getPredicateEv")
  //</editor-fold>
  public /*uint*/int getPredicate() /*const*/ {
    return $ushort2uint(cast_CompareConstantExpr(this).predicate);
  }

  
  /// Assert that this is an insertvalue or exactvalue
  /// expression and return the list of indices.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getIndices">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1102,
   FQN="llvm::ConstantExpr::getIndices", NM="_ZNK4llvm12ConstantExpr10getIndicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm12ConstantExpr10getIndicesEv")
  //</editor-fold>
  public ArrayRefUInt getIndices() /*const*/ {
    {
      /*const*/ ExtractValueConstantExpr /*P*/ EVCE = dyn_cast_ExtractValueConstantExpr(this);
      if ((EVCE != null)) {
        return new ArrayRefUInt(EVCE.Indices);
      }
    }
    
    return new ArrayRefUInt(cast_InsertValueConstantExpr(this).Indices);
  }

  
  /// Return a string representation for an opcode.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getOpcodeName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2259,
   FQN="llvm::ConstantExpr::getOpcodeName", NM="_ZNK4llvm12ConstantExpr13getOpcodeNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm12ConstantExpr13getOpcodeNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getOpcodeName() /*const*/ {
    return Instruction.getOpcodeName(getOpcode());
  }

  
  /// Return a constant expression identical to this one, but with the specified
  /// operand set to the specified value.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getWithOperandReplaced">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1114,
   FQN="llvm::ConstantExpr::getWithOperandReplaced", NM="_ZNK4llvm12ConstantExpr22getWithOperandReplacedEjPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm12ConstantExpr22getWithOperandReplacedEjPNS_8ConstantE")
  //</editor-fold>
  public Constant /*P*/ getWithOperandReplaced(/*uint*/int OpNo, Constant /*P*/ Op) /*const*/ {
    assert (Op.getType() == getOperand_Constant(OpNo).getType()) : "Replacing operand with value of different type!";
    if (getOperand_Constant(OpNo) == Op) {
      return ((/*const_cast*/ConstantExpr /*P*/ )(this));
    }
    
    SmallVector<Constant /*P*/ > NewOps/*J*/= new SmallVector<Constant /*P*/ >(8, (Constant /*P*/ )null);
    for (/*uint*/int i = 0, e = getNumOperands(); i != e; ++i)  {
      NewOps.push_back(i == OpNo ? Op : getOperand_Constant(i));
    }
    
    return getWithOperands(new ArrayRef<Constant /*P*/ >(NewOps, true));
  }

  
  /// This returns the current constant expression with the operands replaced
  /// with the specified values. The specified array must have the same number
  /// of operands as our current one.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getWithOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1147,
   FQN="llvm::ConstantExpr::getWithOperands", NM="_ZNK4llvm12ConstantExpr15getWithOperandsENS_8ArrayRefIPNS_8ConstantEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm12ConstantExpr15getWithOperandsENS_8ArrayRefIPNS_8ConstantEEE")
  //</editor-fold>
  public Constant /*P*/ getWithOperands(ArrayRef<Constant /*P*/ > Ops) /*const*/ {
    return getWithOperands(new ArrayRef<Constant /*P*/ >(Ops), getType());
  }

  
  /// Get the current expression with the operands replaced.
  ///
  /// Return the current constant expression with the operands replaced with \c
  /// Ops and the type with \c Ty.  The new operands must have the same number
  /// as the current ones.
  ///
  /// If \c OnlyIfReduced is \c true, nullptr will be returned unless something
  /// gets constant-folded, the type changes, or the expression is otherwise
  /// canonicalized.  This parameter should almost always be \c false.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getWithOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1128,
   FQN="llvm::ConstantExpr::getWithOperands", NM="_ZNK4llvm12ConstantExpr15getWithOperandsENS_8ArrayRefIPNS_8ConstantEEEPNS_4TypeEbS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm12ConstantExpr15getWithOperandsENS_8ArrayRefIPNS_8ConstantEEEPNS_4TypeEbS6_")
  //</editor-fold>
  public Constant /*P*/ getWithOperands(ArrayRef<Constant /*P*/ > Ops, Type /*P*/ Ty) /*const*/ {
    return getWithOperands(Ops, Ty, 
                 false, (Type /*P*/ )null);
  }
  public Constant /*P*/ getWithOperands(ArrayRef<Constant /*P*/ > Ops, Type /*P*/ Ty, 
                 boolean OnlyIfReduced/*= false*/) /*const*/ {
    return getWithOperands(Ops, Ty, 
                 OnlyIfReduced, (Type /*P*/ )null);
  }
  public Constant /*P*/ getWithOperands(ArrayRef<Constant /*P*/ > Ops, Type /*P*/ Ty, 
                 boolean OnlyIfReduced/*= false*/, Type /*P*/ SrcTy/*= null*/) /*const*/ {
    assert (Ops.size() == getNumOperands()) : "Operand count mismatch!";
    
    // If no operands changed return self.
    if (Ty == getType() && std.equal(Ops.begin(), Ops.end(), op_begin$Const())) {
      return ((/*const_cast*/ConstantExpr /*P*/ )(this));
    }
    
    Type /*P*/ OnlyIfReducedTy = OnlyIfReduced ? Ty : null;
    switch (getOpcode()) {
     case Instruction.CastOps.Trunc:
     case Instruction.CastOps.ZExt:
     case Instruction.CastOps.SExt:
     case Instruction.CastOps.FPTrunc:
     case Instruction.CastOps.FPExt:
     case Instruction.CastOps.UIToFP:
     case Instruction.CastOps.SIToFP:
     case Instruction.CastOps.FPToUI:
     case Instruction.CastOps.FPToSI:
     case Instruction.CastOps.PtrToInt:
     case Instruction.CastOps.IntToPtr:
     case Instruction.CastOps.BitCast:
     case Instruction.CastOps.AddrSpaceCast:
      return ConstantExpr.getCast(getOpcode(), Ops.$at(0), Ty, OnlyIfReduced);
     case Instruction.OtherOps.Select:
      return ConstantExpr.getSelect(Ops.$at(0), Ops.$at(1), Ops.$at(2), OnlyIfReducedTy);
     case Instruction.OtherOps.InsertElement:
      return ConstantExpr.getInsertElement(Ops.$at(0), Ops.$at(1), Ops.$at(2), 
          OnlyIfReducedTy);
     case Instruction.OtherOps.ExtractElement:
      return ConstantExpr.getExtractElement(Ops.$at(0), Ops.$at(1), OnlyIfReducedTy);
     case Instruction.OtherOps.InsertValue:
      return ConstantExpr.getInsertValue(Ops.$at(0), Ops.$at(1), getIndices(), 
          OnlyIfReducedTy);
     case Instruction.OtherOps.ExtractValue:
      return ConstantExpr.getExtractValue(Ops.$at(0), getIndices(), OnlyIfReducedTy);
     case Instruction.OtherOps.ShuffleVector:
      return ConstantExpr.getShuffleVector(Ops.$at(0), Ops.$at(1), Ops.$at(2), 
          OnlyIfReducedTy);
     case Instruction.MemoryOps.GetElementPtr:
      {
        /*const*/ GEPOperator /*P*/ GEPO = cast_GEPOperator(this);
        assert ((SrcTy != null) || (Ops.$at(0).getType() == getOperand_Constant(0).getType()));
        return ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P((SrcTy != null) ? SrcTy : GEPO.getSourceElementType(), Ops.$at(0), Ops.slice(1), 
            GEPO.isInBounds(), OnlyIfReducedTy);
      }
     case Instruction.OtherOps.ICmp:
     case Instruction.OtherOps.FCmp:
      return ConstantExpr.getCompare($uint2ushort(getPredicate()), Ops.$at(0), Ops.$at(1), 
          (OnlyIfReducedTy != null));
     default:
      assert (getNumOperands() == 2) : "Must be binary operator?";
      return ConstantExpr.get(getOpcode(), Ops.$at(0), Ops.$at(1), $uchar2uint($7bits_uchar2uchar(SubclassOptionalData)), 
          OnlyIfReducedTy);
    }
  }

  
  /// Returns an Instruction which implements the same operation as this
  /// ConstantExpr. The instruction is not linked to any basic block.
  ///
  /// A better approach to this could be to have a constructor for Instruction
  /// which would take a ConstantExpr parameter, but that would have spread
  /// implementation details of ConstantExpr outside of Constants.cpp, which
  /// would make it harder to remove ConstantExprs altogether.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::getAsInstruction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2849,
   FQN="llvm::ConstantExpr::getAsInstruction", NM="_ZN4llvm12ConstantExpr16getAsInstructionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr16getAsInstructionEv")
  //</editor-fold>
  public Instruction /*P*/ getAsInstruction() {
    SmallVector<Value /*P*/ > ValueOperands/*J*/= new SmallVector<Value /*P*/ >(JD$T.INSTANCE, 4, op_begin(), op_end(), (Value /*P*/ )null, (Use a) -> a.$Value$P());
    ArrayRef<Value /*P*/ > Ops/*J*/= new ArrayRef<Value /*P*/ >(ValueOperands, true);
    switch (getOpcode()) {
     case Instruction.CastOps.Trunc:
     case Instruction.CastOps.ZExt:
     case Instruction.CastOps.SExt:
     case Instruction.CastOps.FPTrunc:
     case Instruction.CastOps.FPExt:
     case Instruction.CastOps.UIToFP:
     case Instruction.CastOps.SIToFP:
     case Instruction.CastOps.FPToUI:
     case Instruction.CastOps.FPToSI:
     case Instruction.CastOps.PtrToInt:
     case Instruction.CastOps.IntToPtr:
     case Instruction.CastOps.BitCast:
     case Instruction.CastOps.AddrSpaceCast:
      return CastInst.Create((/*CastOps*/int)getOpcode(), 
          Ops.$at(0), getType());
     case Instruction.OtherOps.Select:
      return SelectInst.Create(Ops.$at(0), Ops.$at(1), Ops.$at(2));
     case Instruction.OtherOps.InsertElement:
      return InsertElementInst.Create(Ops.$at(0), Ops.$at(1), Ops.$at(2));
     case Instruction.OtherOps.ExtractElement:
      return ExtractElementInst.Create(Ops.$at(0), Ops.$at(1));
     case Instruction.OtherOps.InsertValue:
      return InsertValueInst.Create_Value$P_ArrayRefUInt_Twine$C_Instruction$P(Ops.$at(0), Ops.$at(1), getIndices());
     case Instruction.OtherOps.ExtractValue:
      return ExtractValueInst.Create_Value1(Ops.$at(0), getIndices());
     case Instruction.OtherOps.ShuffleVector:
      return /*NEW_EXPR [ShuffleVectorInst::new]*/ShuffleVectorInst.$new_ShuffleVectorInst((type$ptr<?> New$Mem)->{
          return new ShuffleVectorInst(Ops.$at(0), Ops.$at(1), Ops.$at(2));
       });
     case Instruction.MemoryOps.GetElementPtr:
      {
        /*const*/ GEPOperator /*P*/ GO = cast_GEPOperator(this);
        if (GO.isInBounds()) {
          return GetElementPtrInst.CreateInBounds2(GO.getSourceElementType(), 
              Ops.$at(0), Ops.slice(1));
        }
        return GetElementPtrInst.Create1(GO.getSourceElementType(), Ops.$at(0), 
            Ops.slice(1));
      }
     case Instruction.OtherOps.ICmp:
     case Instruction.OtherOps.FCmp:
      return CmpInst.Create((/*OtherOps*/int)getOpcode(), 
          CmpInst.Predicate.valueOf(getPredicate()), Ops.$at(0), Ops.$at(1));
     default:
      assert (getNumOperands() == 2) : "Must be binary operator?";
      BinaryOperator /*P*/ BO = BinaryOperator.Create((/*BinaryOps*/int)getOpcode(), 
          Ops.$at(0), Ops.$at(1));
      if (isa_OverflowingBinaryOperator(BO)) {
        BO.setHasNoUnsignedWrap((($uchar2int($7bits_uchar2uchar(SubclassOptionalData))
               & OverflowingBinaryOperator.NoUnsignedWrap) != 0));
        BO.setHasNoSignedWrap((($uchar2int($7bits_uchar2uchar(SubclassOptionalData))
               & OverflowingBinaryOperator.NoSignedWrap) != 0));
      }
      if (isa_PossiblyExactOperator(BO)) {
        BO.setIsExact((($uchar2int($7bits_uchar2uchar(SubclassOptionalData)) & PossiblyExactOperator.IsExact) != 0));
      }
      return BO;
    }
  }

  
  /// Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1174,
   FQN="llvm::ConstantExpr::classof", NM="_ZN4llvm12ConstantExpr7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == ValueTy.ConstantExprVal.getValue();
  }

/*private:*/
  // Shadow Value::setValueSubclassData with a private forwarding method so that
  // subclasses cannot accidentally use it.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::setValueSubclassData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1181,
   FQN="llvm::ConstantExpr::setValueSubclassData", NM="_ZN4llvm12ConstantExpr20setValueSubclassDataEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExpr20setValueSubclassDataEt")
  //</editor-fold>
  protected/*private*/ void setValueSubclassData(/*ushort*/char D) {
    super.setValueSubclassData(D);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantExpr::~ConstantExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 835,
   FQN="llvm::ConstantExpr::~ConstantExpr", NM="_ZN4llvm12ConstantExprD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantExprD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static Constant /*P*/ getCompare(/*uint*/int Predicate, Constant /*P*/ C1, 
            Constant /*P*/ C2) {
    return getCompare(Predicate, C1, 
            C2, false);
  }
  public static Constant /*P*/ getCompare(/*uint*/int Predicate, Constant /*P*/ C1, 
            Constant /*P*/ C2, boolean OnlyIfReduced/*= false*/) {
    return getCompare($uint2ushort(Predicate), C1, 
            C2, OnlyIfReduced);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
