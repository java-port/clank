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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.adt.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
//                           BinaryOperator Class
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 328,
 FQN="llvm::BinaryOperator", NM="_ZN4llvm14BinaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperatorE")
//</editor-fold>
public class BinaryOperator extends /*public*/ Instruction implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 329,
   FQN="llvm::BinaryOperator::operator new", NM="_ZN4llvm14BinaryOperatornwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperatornwEjj")
  //</editor-fold>
  protected/*private*/ static Object/*void P*/ $new_BinaryOperator(/*size_t*/int $Prm0, /*uint*/int $Prm1) { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2066,
   FQN="llvm::BinaryOperator::init", NM="_ZN4llvm14BinaryOperator4initENS_11Instruction9BinaryOpsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator4initENS_11Instruction9BinaryOpsE")
  //</editor-fold>
  protected void init(/*BinaryOps*/int iType) {
    Value /*P*/ LHS = getOperand(0);
    Value /*P*/ RHS = getOperand(1);
    ///*J:(void)*/LHS;
    ///*J:(void)*/RHS; // Silence warnings.
    assert (LHS.getType() == RHS.getType()) : "Binary operator operand types must match!";
    switch (iType) {
     case BinaryOps.Add:
     case BinaryOps.Sub:
     case BinaryOps.Mul:
      assert (getType() == LHS.getType()) : "Arithmetic operation should return same type as operands!";
      assert (getType().isIntOrIntVectorTy()) : "Tried to create an integer operation on a non-integer type!";
      break;
     case BinaryOps.FAdd:
     case BinaryOps.FSub:
     case BinaryOps.FMul:
      assert (getType() == LHS.getType()) : "Arithmetic operation should return same type as operands!";
      assert (getType().isFPOrFPVectorTy()) : "Tried to create a floating-point operation on a non-floating-point type!";
      break;
     case BinaryOps.UDiv:
     case BinaryOps.SDiv:
      assert (getType() == LHS.getType()) : "Arithmetic operation should return same type as operands!";
      assert ((getType().isIntegerTy() || (getType().isVectorTy() && cast_VectorType(getType()).getElementType().isIntegerTy()))) : "Incorrect operand type (not integer) for S/UDIV";
      break;
     case BinaryOps.FDiv:
      assert (getType() == LHS.getType()) : "Arithmetic operation should return same type as operands!";
      assert (getType().isFPOrFPVectorTy()) : "Incorrect operand type (not floating point) for FDIV";
      break;
     case BinaryOps.URem:
     case BinaryOps.SRem:
      assert (getType() == LHS.getType()) : "Arithmetic operation should return same type as operands!";
      assert ((getType().isIntegerTy() || (getType().isVectorTy() && cast_VectorType(getType()).getElementType().isIntegerTy()))) : "Incorrect operand type (not integer) for S/UREM";
      break;
     case BinaryOps.FRem:
      assert (getType() == LHS.getType()) : "Arithmetic operation should return same type as operands!";
      assert (getType().isFPOrFPVectorTy()) : "Incorrect operand type (not floating point) for FREM";
      break;
     case BinaryOps.Shl:
     case BinaryOps.LShr:
     case BinaryOps.AShr:
      assert (getType() == LHS.getType()) : "Shift operation should return same type as operands!";
      assert ((getType().isIntegerTy() || (getType().isVectorTy() && cast_VectorType(getType()).getElementType().isIntegerTy()))) : "Tried to create a shift operation on a non-integral type!";
      break;
     case BinaryOps.And:
     case BinaryOps.Or:
     case BinaryOps.Xor:
      assert (getType() == LHS.getType()) : "Logical operation should return same type as operands!";
      assert ((getType().isIntegerTy() || (getType().isVectorTy() && cast_VectorType(getType()).getElementType().isIntegerTy()))) : "Tried to create a logical operation on a non-integral type!";
      break;
     default:
      break;
    }
  }

  
  //===----------------------------------------------------------------------===//
  //                             BinaryOperator Class
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::BinaryOperator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2039,
   FQN="llvm::BinaryOperator::BinaryOperator", NM="_ZN4llvm14BinaryOperatorC1ENS_11Instruction9BinaryOpsEPNS_5ValueES4_PNS_4TypeERKNS_5TwineEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperatorC1ENS_11Instruction9BinaryOpsEPNS_5ValueES4_PNS_4TypeERKNS_5TwineEPS1_")
  //</editor-fold>
  protected BinaryOperator(/*BinaryOps*/int iType, Value /*P*/ S1, Value /*P*/ S2, 
      Type /*P*/ Ty, final /*const*/ Twine /*&*/ Name, 
      Instruction /*P*/ InsertBefore) {
    // : Instruction(Ty, iType, OperandTraits<BinaryOperator>::op_begin(this), OperandTraits<BinaryOperator>::operands(this), InsertBefore) 
    //START JInit
    super(Ty, iType,
        OperandTraitsBinaryOperator.<BinaryOperator>op_begin(User.$BEING_CREATED()),
        OperandTraitsBinaryOperator.<BinaryOperator>operands$FixedNumOperandTraits(User.$BEING_CREATED()),
        InsertBefore);
    //END JInit
    this./*<0>*/Op(0).$assign(S1);
    this./*<1>*/Op(1).$assign(S2);
    init(iType);
    setName(Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::BinaryOperator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2052,
   FQN="llvm::BinaryOperator::BinaryOperator", NM="_ZN4llvm14BinaryOperatorC1ENS_11Instruction9BinaryOpsEPNS_5ValueES4_PNS_4TypeERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperatorC1ENS_11Instruction9BinaryOpsEPNS_5ValueES4_PNS_4TypeERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  protected BinaryOperator(/*BinaryOps*/int iType, Value /*P*/ S1, Value /*P*/ S2, 
      Type /*P*/ Ty, final /*const*/ Twine /*&*/ Name, 
      BasicBlock /*P*/ InsertAtEnd) {
    // : Instruction(Ty, iType, OperandTraits<BinaryOperator>::op_begin(this), OperandTraits<BinaryOperator>::operands(this), InsertAtEnd) 
    //START JInit
    super(Ty, iType,
        OperandTraitsBinaryOperator.<BinaryOperator>op_begin(User.$BEING_CREATED()),
        OperandTraitsBinaryOperator.<BinaryOperator>operands$FixedNumOperandTraits(User.$BEING_CREATED()),
        InsertAtEnd);
    //END JInit
    this./*<0>*/Op(0).$assign(S1);
    this./*<1>*/Op(1).$assign(S2);
    init(iType);
    setName(Name);
  }

  
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3894,
   FQN="llvm::BinaryOperator::cloneImpl", NM="_ZNK4llvm14BinaryOperator9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14BinaryOperator9cloneImplEv")
  //</editor-fold>
  protected BinaryOperator /*P*/ cloneImpl() /*const*/ {
    return Create(getOpcode(), this./*<0>*/Op$Const(0).$Value$P(), this./*<1>*/Op$Const(1).$Value$P());
  }

/*public:*/
  // allocate space for exactly two operands
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::operator new">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 344,
   FQN="llvm::BinaryOperator::operator new", NM="_ZN4llvm14BinaryOperatornwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperatornwEj")
  //</editor-fold>
  public static BinaryOperator/*void P*/ $new_BinaryOperator(New$ConstructorCallback<BinaryOperator> $Ctor) {
    return User.$new_FixedUses(/*s, */2, $Ctor);
  }


  /// Transparently provide more efficient getOperand methods.
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 552,
   FQN="llvm::BinaryOperator::getOperand", NM="_ZNK4llvm14BinaryOperator10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14BinaryOperator10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsBinaryOperator.operands$FixedNumOperandTraits(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsBinaryOperator.op_begin(((/*const_cast*/BinaryOperator /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 552,
   FQN="llvm::BinaryOperator::setOperand", NM="_ZN4llvm14BinaryOperator10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsBinaryOperator.operands$FixedNumOperandTraits(this))) : "setOperand() out of range!";
    OperandTraitsBinaryOperator.op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 552,
   FQN="llvm::BinaryOperator::op_begin", NM="_ZN4llvm14BinaryOperator8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsBinaryOperator.op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 552,
   FQN="llvm::BinaryOperator::op_begin", NM="_ZNK4llvm14BinaryOperator8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14BinaryOperator8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsBinaryOperator.op_begin(((/*const_cast*/BinaryOperator /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 552,
   FQN="llvm::BinaryOperator::op_end", NM="_ZN4llvm14BinaryOperator6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsBinaryOperator.op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 552,
   FQN="llvm::BinaryOperator::op_end", NM="_ZNK4llvm14BinaryOperator6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14BinaryOperator6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsBinaryOperator.op_end(((/*const_cast*/BinaryOperator /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::Op">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 552,
   FQN="llvm::BinaryOperator::Op", NM="Tpl__ZN4llvm14BinaryOperator2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm14BinaryOperator2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::Op">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 552,
   FQN="llvm::BinaryOperator::Op", NM="Tpl__ZNK4llvm14BinaryOperator2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm14BinaryOperator2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 552,
   FQN="llvm::BinaryOperator::getNumOperands", NM="_ZNK4llvm14BinaryOperator14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14BinaryOperator14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsBinaryOperator.operands$FixedNumOperandTraits(this);
  }

  
  /// Construct a binary instruction, given the opcode and the two
  /// operands.  Optionally (if InstBefore is specified) insert the instruction
  /// into a BasicBlock right before the specified instruction.  The specified
  /// Instruction is allowed to be a dereferenced end iterator.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2141,
   FQN="llvm::BinaryOperator::Create", NM="_ZN4llvm14BinaryOperator6CreateENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator6CreateENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineEPS1_")
  //</editor-fold>
  public static BinaryOperator /*P*/ Create(/*BinaryOps*/int Op, Value /*P*/ S1, Value /*P*/ S2) {
    return Create(Op, S1, S2, 
        new Twine(), 
        (Instruction /*P*/ )null);
  }
  public static BinaryOperator /*P*/ Create(/*BinaryOps*/int Op, Value /*P*/ S1, Value /*P*/ S2, 
        final /*const*/ Twine /*&*/ Name/*= Twine()*/) {
    return Create(Op, S1, S2, 
        Name, 
        (Instruction /*P*/ )null);
  }
  public static BinaryOperator /*P*/ Create(/*BinaryOps*/int Op, Value /*P*/ S1, Value /*P*/ S2, 
        final /*const*/ Twine /*&*/ Name/*= Twine()*/, 
        Instruction /*P*/ InsertBefore/*= null*/) {
    assert (S1.getType() == S2.getType()) : "Cannot create binary operator with two operands of differing type!";
    return /*NEW_EXPR [BinaryOperator::new]*/BinaryOperator.$new_BinaryOperator((type$ptr<?> New$Mem)->{
        return new BinaryOperator(Op, S1, S2, S1.getType(), Name, InsertBefore);
     });
  }

  
  /// Construct a binary instruction, given the opcode and the two
  /// operands.  Also automatically insert this instruction to the end of the
  /// BasicBlock specified.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2149,
   FQN="llvm::BinaryOperator::Create", NM="_ZN4llvm14BinaryOperator6CreateENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator6CreateENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ Create(/*BinaryOps*/int Op, Value /*P*/ S1, Value /*P*/ S2, 
        final /*const*/ Twine /*&*/ Name, 
        BasicBlock /*P*/ InsertAtEnd) {
    BinaryOperator /*P*/ Res = Create(Op, S1, S2, Name);
    InsertAtEnd.getInstList().push_back(Res);
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 124,
   FQN="llvm::BinaryOperator::CreateAdd", NM="_ZN4llvm14BinaryOperator9CreateAddEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateAddEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateAdd(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateAdd(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateAdd(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Create(Instruction.BinaryOps.Add, V1, V2, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateFAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 125,
   FQN="llvm::BinaryOperator::CreateFAdd", NM="_ZN4llvm14BinaryOperator10CreateFAddEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateFAddEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateFAdd(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateFAdd(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateFAdd(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Create(Instruction.BinaryOps.FAdd, V1, V2, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 126,
   FQN="llvm::BinaryOperator::CreateSub", NM="_ZN4llvm14BinaryOperator9CreateSubEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateSubEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateSub(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateSub(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateSub(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Create(Instruction.BinaryOps.Sub, V1, V2, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateFSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 127,
   FQN="llvm::BinaryOperator::CreateFSub", NM="_ZN4llvm14BinaryOperator10CreateFSubEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateFSubEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateFSub(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateFSub(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateFSub(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Create(Instruction.BinaryOps.FSub, V1, V2, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 128,
   FQN="llvm::BinaryOperator::CreateMul", NM="_ZN4llvm14BinaryOperator9CreateMulEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateMulEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateMul(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateMul(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateMul(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Create(Instruction.BinaryOps.Mul, V1, V2, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateFMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 129,
   FQN="llvm::BinaryOperator::CreateFMul", NM="_ZN4llvm14BinaryOperator10CreateFMulEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateFMulEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateFMul(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateFMul(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateFMul(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Create(Instruction.BinaryOps.FMul, V1, V2, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateUDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 130,
   FQN="llvm::BinaryOperator::CreateUDiv", NM="_ZN4llvm14BinaryOperator10CreateUDivEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateUDivEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateUDiv(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateUDiv(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateUDiv(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Create(Instruction.BinaryOps.UDiv, V1, V2, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateSDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 131,
   FQN="llvm::BinaryOperator::CreateSDiv", NM="_ZN4llvm14BinaryOperator10CreateSDivEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateSDivEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateSDiv(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateSDiv(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateSDiv(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Create(Instruction.BinaryOps.SDiv, V1, V2, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateFDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 132,
   FQN="llvm::BinaryOperator::CreateFDiv", NM="_ZN4llvm14BinaryOperator10CreateFDivEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateFDivEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateFDiv(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateFDiv(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateFDiv(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Create(Instruction.BinaryOps.FDiv, V1, V2, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateURem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 133,
   FQN="llvm::BinaryOperator::CreateURem", NM="_ZN4llvm14BinaryOperator10CreateURemEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateURemEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateURem(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateURem(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateURem(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Create(Instruction.BinaryOps.URem, V1, V2, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateSRem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 134,
   FQN="llvm::BinaryOperator::CreateSRem", NM="_ZN4llvm14BinaryOperator10CreateSRemEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateSRemEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateSRem(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateSRem(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateSRem(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Create(Instruction.BinaryOps.SRem, V1, V2, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateFRem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 135,
   FQN="llvm::BinaryOperator::CreateFRem", NM="_ZN4llvm14BinaryOperator10CreateFRemEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateFRemEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateFRem(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateFRem(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateFRem(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Create(Instruction.BinaryOps.FRem, V1, V2, Name);
  }

  
  // Logical operators (integer operands)
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateShl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 138,
   FQN="llvm::BinaryOperator::CreateShl", NM="_ZN4llvm14BinaryOperator9CreateShlEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateShlEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateShl(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateShl(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateShl(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Create(Instruction.BinaryOps.Shl, V1, V2, Name); // Shift left  (logical)
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateLShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 139,
   FQN="llvm::BinaryOperator::CreateLShr", NM="_ZN4llvm14BinaryOperator10CreateLShrEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateLShrEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateLShr(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateLShr(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateLShr(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Create(Instruction.BinaryOps.LShr, V1, V2, Name); // Shift right (logical)
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateAShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 140,
   FQN="llvm::BinaryOperator::CreateAShr", NM="_ZN4llvm14BinaryOperator10CreateAShrEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateAShrEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateAShr(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateAShr(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateAShr(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Create(Instruction.BinaryOps.AShr, V1, V2, Name); // Shift right (arithmetic)
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateAnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 141,
   FQN="llvm::BinaryOperator::CreateAnd", NM="_ZN4llvm14BinaryOperator9CreateAndEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateAndEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateAnd(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateAnd(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateAnd(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Create(Instruction.BinaryOps.And, V1, V2, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateOr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 142,
   FQN="llvm::BinaryOperator::CreateOr", NM="_ZN4llvm14BinaryOperator8CreateOrEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator8CreateOrEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateOr(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateOr(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateOr(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Create(Instruction.BinaryOps.Or, V1, V2, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateXor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 143,
   FQN="llvm::BinaryOperator::CreateXor", NM="_ZN4llvm14BinaryOperator9CreateXorEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateXorEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateXor(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateXor(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateXor(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Create(Instruction.BinaryOps.Xor, V1, V2, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 124,
   FQN="llvm::BinaryOperator::CreateAdd", NM="_ZN4llvm14BinaryOperator9CreateAddEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateAddEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateAdd(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return Create(Instruction.BinaryOps.Add, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateFAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 125,
   FQN="llvm::BinaryOperator::CreateFAdd", NM="_ZN4llvm14BinaryOperator10CreateFAddEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateFAddEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateFAdd(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return Create(Instruction.BinaryOps.FAdd, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 126,
   FQN="llvm::BinaryOperator::CreateSub", NM="_ZN4llvm14BinaryOperator9CreateSubEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateSubEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateSub(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return Create(Instruction.BinaryOps.Sub, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateFSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 127,
   FQN="llvm::BinaryOperator::CreateFSub", NM="_ZN4llvm14BinaryOperator10CreateFSubEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateFSubEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateFSub(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return Create(Instruction.BinaryOps.FSub, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 128,
   FQN="llvm::BinaryOperator::CreateMul", NM="_ZN4llvm14BinaryOperator9CreateMulEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateMulEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateMul(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return Create(Instruction.BinaryOps.Mul, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateFMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 129,
   FQN="llvm::BinaryOperator::CreateFMul", NM="_ZN4llvm14BinaryOperator10CreateFMulEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateFMulEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateFMul(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return Create(Instruction.BinaryOps.FMul, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateUDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 130,
   FQN="llvm::BinaryOperator::CreateUDiv", NM="_ZN4llvm14BinaryOperator10CreateUDivEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateUDivEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateUDiv(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return Create(Instruction.BinaryOps.UDiv, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateSDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 131,
   FQN="llvm::BinaryOperator::CreateSDiv", NM="_ZN4llvm14BinaryOperator10CreateSDivEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateSDivEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateSDiv(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return Create(Instruction.BinaryOps.SDiv, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateFDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 132,
   FQN="llvm::BinaryOperator::CreateFDiv", NM="_ZN4llvm14BinaryOperator10CreateFDivEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateFDivEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateFDiv(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return Create(Instruction.BinaryOps.FDiv, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateURem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 133,
   FQN="llvm::BinaryOperator::CreateURem", NM="_ZN4llvm14BinaryOperator10CreateURemEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateURemEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateURem(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return Create(Instruction.BinaryOps.URem, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateSRem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 134,
   FQN="llvm::BinaryOperator::CreateSRem", NM="_ZN4llvm14BinaryOperator10CreateSRemEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateSRemEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateSRem(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return Create(Instruction.BinaryOps.SRem, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateFRem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 135,
   FQN="llvm::BinaryOperator::CreateFRem", NM="_ZN4llvm14BinaryOperator10CreateFRemEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateFRemEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateFRem(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return Create(Instruction.BinaryOps.FRem, V1, V2, Name, BB);
  }

  
  // Logical operators (integer operands)
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateShl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 138,
   FQN="llvm::BinaryOperator::CreateShl", NM="_ZN4llvm14BinaryOperator9CreateShlEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateShlEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateShl(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return Create(Instruction.BinaryOps.Shl, V1, V2, Name, BB); // Shift left  (logical)
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateLShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 139,
   FQN="llvm::BinaryOperator::CreateLShr", NM="_ZN4llvm14BinaryOperator10CreateLShrEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateLShrEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateLShr(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return Create(Instruction.BinaryOps.LShr, V1, V2, Name, BB); // Shift right (logical)
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateAShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 140,
   FQN="llvm::BinaryOperator::CreateAShr", NM="_ZN4llvm14BinaryOperator10CreateAShrEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateAShrEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateAShr(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return Create(Instruction.BinaryOps.AShr, V1, V2, Name, BB); // Shift right (arithmetic)
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateAnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 141,
   FQN="llvm::BinaryOperator::CreateAnd", NM="_ZN4llvm14BinaryOperator9CreateAndEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateAndEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateAnd(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return Create(Instruction.BinaryOps.And, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateOr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 142,
   FQN="llvm::BinaryOperator::CreateOr", NM="_ZN4llvm14BinaryOperator8CreateOrEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator8CreateOrEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateOr(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return Create(Instruction.BinaryOps.Or, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateXor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 143,
   FQN="llvm::BinaryOperator::CreateXor", NM="_ZN4llvm14BinaryOperator9CreateXorEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateXorEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateXor(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return Create(Instruction.BinaryOps.Xor, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 124,
   FQN="llvm::BinaryOperator::CreateAdd", NM="_ZN4llvm14BinaryOperator9CreateAddEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateAddEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateAdd(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return Create(Instruction.BinaryOps.Add, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateFAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 125,
   FQN="llvm::BinaryOperator::CreateFAdd", NM="_ZN4llvm14BinaryOperator10CreateFAddEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateFAddEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateFAdd(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return Create(Instruction.BinaryOps.FAdd, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 126,
   FQN="llvm::BinaryOperator::CreateSub", NM="_ZN4llvm14BinaryOperator9CreateSubEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateSubEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateSub(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return Create(Instruction.BinaryOps.Sub, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateFSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 127,
   FQN="llvm::BinaryOperator::CreateFSub", NM="_ZN4llvm14BinaryOperator10CreateFSubEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateFSubEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateFSub(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return Create(Instruction.BinaryOps.FSub, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 128,
   FQN="llvm::BinaryOperator::CreateMul", NM="_ZN4llvm14BinaryOperator9CreateMulEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateMulEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateMul(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return Create(Instruction.BinaryOps.Mul, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateFMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 129,
   FQN="llvm::BinaryOperator::CreateFMul", NM="_ZN4llvm14BinaryOperator10CreateFMulEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateFMulEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateFMul(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return Create(Instruction.BinaryOps.FMul, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateUDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 130,
   FQN="llvm::BinaryOperator::CreateUDiv", NM="_ZN4llvm14BinaryOperator10CreateUDivEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateUDivEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateUDiv(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return Create(Instruction.BinaryOps.UDiv, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateSDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 131,
   FQN="llvm::BinaryOperator::CreateSDiv", NM="_ZN4llvm14BinaryOperator10CreateSDivEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateSDivEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateSDiv(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return Create(Instruction.BinaryOps.SDiv, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateFDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 132,
   FQN="llvm::BinaryOperator::CreateFDiv", NM="_ZN4llvm14BinaryOperator10CreateFDivEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateFDivEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateFDiv(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return Create(Instruction.BinaryOps.FDiv, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateURem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 133,
   FQN="llvm::BinaryOperator::CreateURem", NM="_ZN4llvm14BinaryOperator10CreateURemEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateURemEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateURem(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return Create(Instruction.BinaryOps.URem, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateSRem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 134,
   FQN="llvm::BinaryOperator::CreateSRem", NM="_ZN4llvm14BinaryOperator10CreateSRemEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateSRemEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateSRem(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return Create(Instruction.BinaryOps.SRem, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateFRem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 135,
   FQN="llvm::BinaryOperator::CreateFRem", NM="_ZN4llvm14BinaryOperator10CreateFRemEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateFRemEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateFRem(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return Create(Instruction.BinaryOps.FRem, V1, V2, Name, I);
  }

  
  // Logical operators (integer operands)
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateShl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 138,
   FQN="llvm::BinaryOperator::CreateShl", NM="_ZN4llvm14BinaryOperator9CreateShlEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateShlEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateShl(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return Create(Instruction.BinaryOps.Shl, V1, V2, Name, I); // Shift left  (logical)
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateLShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 139,
   FQN="llvm::BinaryOperator::CreateLShr", NM="_ZN4llvm14BinaryOperator10CreateLShrEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateLShrEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateLShr(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return Create(Instruction.BinaryOps.LShr, V1, V2, Name, I); // Shift right (logical)
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateAShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 140,
   FQN="llvm::BinaryOperator::CreateAShr", NM="_ZN4llvm14BinaryOperator10CreateAShrEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateAShrEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateAShr(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return Create(Instruction.BinaryOps.AShr, V1, V2, Name, I); // Shift right (arithmetic)
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateAnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 141,
   FQN="llvm::BinaryOperator::CreateAnd", NM="_ZN4llvm14BinaryOperator9CreateAndEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateAndEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateAnd(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return Create(Instruction.BinaryOps.And, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateOr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 142,
   FQN="llvm::BinaryOperator::CreateOr", NM="_ZN4llvm14BinaryOperator8CreateOrEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator8CreateOrEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateOr(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return Create(Instruction.BinaryOps.Or, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateXor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 143,
   FQN="llvm::BinaryOperator::CreateXor", NM="_ZN4llvm14BinaryOperator9CreateXorEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateXorEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateXor(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return Create(Instruction.BinaryOps.Xor, V1, V2, Name, I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateWithCopiedFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 389,
   FQN="llvm::BinaryOperator::CreateWithCopiedFlags", NM="_ZN4llvm14BinaryOperator21CreateWithCopiedFlagsENS_11Instruction9BinaryOpsEPNS_5ValueES4_PS0_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator21CreateWithCopiedFlagsENS_11Instruction9BinaryOpsEPNS_5ValueES4_PS0_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateWithCopiedFlags(/*BinaryOps*/int Opc, 
                       Value /*P*/ V1, Value /*P*/ V2, 
                       BinaryOperator /*P*/ CopyBO) {
    return CreateWithCopiedFlags(Opc, 
                       V1, V2, 
                       CopyBO, 
                       new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateWithCopiedFlags(/*BinaryOps*/int Opc, 
                       Value /*P*/ V1, Value /*P*/ V2, 
                       BinaryOperator /*P*/ CopyBO, 
                       final /*const*/ Twine /*&*/ Name/*= ""*/) {
    BinaryOperator /*P*/ BO = Create(Opc, V1, V2, Name);
    BO.copyIRFlags(CopyBO);
    return BO;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNSW">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 398,
   FQN="llvm::BinaryOperator::CreateNSW", NM="_ZN4llvm14BinaryOperator9CreateNSWENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateNSWENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNSW(/*BinaryOps*/int Opc, Value /*P*/ V1, Value /*P*/ V2) {
    return CreateNSW(Opc, V1, V2, 
           new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateNSW(/*BinaryOps*/int Opc, Value /*P*/ V1, Value /*P*/ V2, 
           final /*const*/ Twine /*&*/ Name/*= ""*/) {
    BinaryOperator /*P*/ BO = Create(Opc, V1, V2, Name);
    BO.setHasNoSignedWrap(true);
    return BO;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNSW">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 404,
   FQN="llvm::BinaryOperator::CreateNSW", NM="_ZN4llvm14BinaryOperator9CreateNSWENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateNSWENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNSW(/*BinaryOps*/int Opc, Value /*P*/ V1, Value /*P*/ V2, 
           final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    BinaryOperator /*P*/ BO = Create(Opc, V1, V2, Name, BB);
    BO.setHasNoSignedWrap(true);
    return BO;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNSW">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 410,
   FQN="llvm::BinaryOperator::CreateNSW", NM="_ZN4llvm14BinaryOperator9CreateNSWENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateNSWENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineEPS1_")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNSW(/*BinaryOps*/int Opc, Value /*P*/ V1, Value /*P*/ V2, 
           final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    BinaryOperator /*P*/ BO = Create(Opc, V1, V2, Name, I);
    BO.setHasNoSignedWrap(true);
    return BO;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNUW">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 417,
   FQN="llvm::BinaryOperator::CreateNUW", NM="_ZN4llvm14BinaryOperator9CreateNUWENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateNUWENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNUW(/*BinaryOps*/int Opc, Value /*P*/ V1, Value /*P*/ V2) {
    return CreateNUW(Opc, V1, V2, 
           new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateNUW(/*BinaryOps*/int Opc, Value /*P*/ V1, Value /*P*/ V2, 
           final /*const*/ Twine /*&*/ Name/*= ""*/) {
    BinaryOperator /*P*/ BO = Create(Opc, V1, V2, Name);
    BO.setHasNoUnsignedWrap(true);
    return BO;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNUW">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 423,
   FQN="llvm::BinaryOperator::CreateNUW", NM="_ZN4llvm14BinaryOperator9CreateNUWENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateNUWENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNUW(/*BinaryOps*/int Opc, Value /*P*/ V1, Value /*P*/ V2, 
           final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    BinaryOperator /*P*/ BO = Create(Opc, V1, V2, Name, BB);
    BO.setHasNoUnsignedWrap(true);
    return BO;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNUW">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 429,
   FQN="llvm::BinaryOperator::CreateNUW", NM="_ZN4llvm14BinaryOperator9CreateNUWENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateNUWENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineEPS1_")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNUW(/*BinaryOps*/int Opc, Value /*P*/ V1, Value /*P*/ V2, 
           final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    BinaryOperator /*P*/ BO = Create(Opc, V1, V2, Name, I);
    BO.setHasNoUnsignedWrap(true);
    return BO;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateExact">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 436,
   FQN="llvm::BinaryOperator::CreateExact", NM="_ZN4llvm14BinaryOperator11CreateExactENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator11CreateExactENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateExact(/*BinaryOps*/int Opc, Value /*P*/ V1, Value /*P*/ V2) {
    return CreateExact(Opc, V1, V2, 
             new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateExact(/*BinaryOps*/int Opc, Value /*P*/ V1, Value /*P*/ V2, 
             final /*const*/ Twine /*&*/ Name/*= ""*/) {
    BinaryOperator /*P*/ BO = Create(Opc, V1, V2, Name);
    BO.setIsExact(true);
    return BO;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateExact">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 442,
   FQN="llvm::BinaryOperator::CreateExact", NM="_ZN4llvm14BinaryOperator11CreateExactENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator11CreateExactENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateExact(/*BinaryOps*/int Opc, Value /*P*/ V1, Value /*P*/ V2, 
             final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    BinaryOperator /*P*/ BO = Create(Opc, V1, V2, Name, BB);
    BO.setIsExact(true);
    return BO;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateExact">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 448,
   FQN="llvm::BinaryOperator::CreateExact", NM="_ZN4llvm14BinaryOperator11CreateExactENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator11CreateExactENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineEPS1_")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateExact(/*BinaryOps*/int Opc, Value /*P*/ V1, Value /*P*/ V2, 
             final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    BinaryOperator /*P*/ BO = Create(Opc, V1, V2, Name, I);
    BO.setIsExact(true);
    return BO;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNSWAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 469,
   FQN="llvm::BinaryOperator::CreateNSWAdd", NM="_ZN4llvm14BinaryOperator12CreateNSWAddEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNSWAddEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNSWAdd(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateNSWAdd(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateNSWAdd(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return BinaryOperator.CreateNSW(Instruction.BinaryOps.Add, V1, V2, Name); // CreateNSWAdd
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNSWAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 469,
   FQN="llvm::BinaryOperator::CreateNSWAdd", NM="_ZN4llvm14BinaryOperator12CreateNSWAddEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNSWAddEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNSWAdd(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return BinaryOperator.CreateNSW(Instruction.BinaryOps.Add, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNSWAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 469,
   FQN="llvm::BinaryOperator::CreateNSWAdd", NM="_ZN4llvm14BinaryOperator12CreateNSWAddEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNSWAddEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNSWAdd(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return BinaryOperator.CreateNSW(Instruction.BinaryOps.Add, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNUWAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 470,
   FQN="llvm::BinaryOperator::CreateNUWAdd", NM="_ZN4llvm14BinaryOperator12CreateNUWAddEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNUWAddEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNUWAdd(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateNUWAdd(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateNUWAdd(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return BinaryOperator.CreateNUW(Instruction.BinaryOps.Add, V1, V2, Name); // CreateNUWAdd
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNUWAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 470,
   FQN="llvm::BinaryOperator::CreateNUWAdd", NM="_ZN4llvm14BinaryOperator12CreateNUWAddEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNUWAddEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNUWAdd(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return BinaryOperator.CreateNUW(Instruction.BinaryOps.Add, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNUWAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 470,
   FQN="llvm::BinaryOperator::CreateNUWAdd", NM="_ZN4llvm14BinaryOperator12CreateNUWAddEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNUWAddEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNUWAdd(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return BinaryOperator.CreateNUW(Instruction.BinaryOps.Add, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNSWSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 471,
   FQN="llvm::BinaryOperator::CreateNSWSub", NM="_ZN4llvm14BinaryOperator12CreateNSWSubEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNSWSubEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNSWSub(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateNSWSub(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateNSWSub(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return BinaryOperator.CreateNSW(Instruction.BinaryOps.Sub, V1, V2, Name); // CreateNSWSub
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNSWSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 471,
   FQN="llvm::BinaryOperator::CreateNSWSub", NM="_ZN4llvm14BinaryOperator12CreateNSWSubEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNSWSubEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNSWSub(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return BinaryOperator.CreateNSW(Instruction.BinaryOps.Sub, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNSWSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 471,
   FQN="llvm::BinaryOperator::CreateNSWSub", NM="_ZN4llvm14BinaryOperator12CreateNSWSubEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNSWSubEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNSWSub(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return BinaryOperator.CreateNSW(Instruction.BinaryOps.Sub, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNUWSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 472,
   FQN="llvm::BinaryOperator::CreateNUWSub", NM="_ZN4llvm14BinaryOperator12CreateNUWSubEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNUWSubEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNUWSub(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateNUWSub(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateNUWSub(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return BinaryOperator.CreateNUW(Instruction.BinaryOps.Sub, V1, V2, Name); // CreateNUWSub
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNUWSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 472,
   FQN="llvm::BinaryOperator::CreateNUWSub", NM="_ZN4llvm14BinaryOperator12CreateNUWSubEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNUWSubEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNUWSub(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return BinaryOperator.CreateNUW(Instruction.BinaryOps.Sub, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNUWSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 472,
   FQN="llvm::BinaryOperator::CreateNUWSub", NM="_ZN4llvm14BinaryOperator12CreateNUWSubEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNUWSubEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNUWSub(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return BinaryOperator.CreateNUW(Instruction.BinaryOps.Sub, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNSWMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 473,
   FQN="llvm::BinaryOperator::CreateNSWMul", NM="_ZN4llvm14BinaryOperator12CreateNSWMulEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNSWMulEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNSWMul(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateNSWMul(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateNSWMul(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return BinaryOperator.CreateNSW(Instruction.BinaryOps.Mul, V1, V2, Name); // CreateNSWMul
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNSWMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 473,
   FQN="llvm::BinaryOperator::CreateNSWMul", NM="_ZN4llvm14BinaryOperator12CreateNSWMulEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNSWMulEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNSWMul(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return BinaryOperator.CreateNSW(Instruction.BinaryOps.Mul, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNSWMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 473,
   FQN="llvm::BinaryOperator::CreateNSWMul", NM="_ZN4llvm14BinaryOperator12CreateNSWMulEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNSWMulEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNSWMul(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return BinaryOperator.CreateNSW(Instruction.BinaryOps.Mul, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNUWMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 474,
   FQN="llvm::BinaryOperator::CreateNUWMul", NM="_ZN4llvm14BinaryOperator12CreateNUWMulEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNUWMulEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNUWMul(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateNUWMul(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateNUWMul(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return BinaryOperator.CreateNUW(Instruction.BinaryOps.Mul, V1, V2, Name); // CreateNUWMul
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNUWMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 474,
   FQN="llvm::BinaryOperator::CreateNUWMul", NM="_ZN4llvm14BinaryOperator12CreateNUWMulEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNUWMulEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNUWMul(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return BinaryOperator.CreateNUW(Instruction.BinaryOps.Mul, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNUWMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 474,
   FQN="llvm::BinaryOperator::CreateNUWMul", NM="_ZN4llvm14BinaryOperator12CreateNUWMulEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNUWMulEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNUWMul(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return BinaryOperator.CreateNUW(Instruction.BinaryOps.Mul, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNSWShl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 475,
   FQN="llvm::BinaryOperator::CreateNSWShl", NM="_ZN4llvm14BinaryOperator12CreateNSWShlEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNSWShlEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNSWShl(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateNSWShl(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateNSWShl(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return BinaryOperator.CreateNSW(Instruction.BinaryOps.Shl, V1, V2, Name); // CreateNSWShl
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNSWShl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 475,
   FQN="llvm::BinaryOperator::CreateNSWShl", NM="_ZN4llvm14BinaryOperator12CreateNSWShlEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNSWShlEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNSWShl(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return BinaryOperator.CreateNSW(Instruction.BinaryOps.Shl, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNSWShl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 475,
   FQN="llvm::BinaryOperator::CreateNSWShl", NM="_ZN4llvm14BinaryOperator12CreateNSWShlEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNSWShlEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNSWShl(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return BinaryOperator.CreateNSW(Instruction.BinaryOps.Shl, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNUWShl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 476,
   FQN="llvm::BinaryOperator::CreateNUWShl", NM="_ZN4llvm14BinaryOperator12CreateNUWShlEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNUWShlEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNUWShl(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateNUWShl(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateNUWShl(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return BinaryOperator.CreateNUW(Instruction.BinaryOps.Shl, V1, V2, Name); // CreateNUWShl
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNUWShl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 476,
   FQN="llvm::BinaryOperator::CreateNUWShl", NM="_ZN4llvm14BinaryOperator12CreateNUWShlEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNUWShlEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNUWShl(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return BinaryOperator.CreateNUW(Instruction.BinaryOps.Shl, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNUWShl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 476,
   FQN="llvm::BinaryOperator::CreateNUWShl", NM="_ZN4llvm14BinaryOperator12CreateNUWShlEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNUWShlEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNUWShl(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return BinaryOperator.CreateNUW(Instruction.BinaryOps.Shl, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateExactSDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 478,
   FQN="llvm::BinaryOperator::CreateExactSDiv", NM="_ZN4llvm14BinaryOperator15CreateExactSDivEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator15CreateExactSDivEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateExactSDiv(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateExactSDiv(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateExactSDiv(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return BinaryOperator.CreateExact(Instruction.BinaryOps.SDiv, V1, V2, Name); // CreateExactSDiv
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateExactSDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 478,
   FQN="llvm::BinaryOperator::CreateExactSDiv", NM="_ZN4llvm14BinaryOperator15CreateExactSDivEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator15CreateExactSDivEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateExactSDiv(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return BinaryOperator.CreateExact(Instruction.BinaryOps.SDiv, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateExactSDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 478,
   FQN="llvm::BinaryOperator::CreateExactSDiv", NM="_ZN4llvm14BinaryOperator15CreateExactSDivEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator15CreateExactSDivEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateExactSDiv(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return BinaryOperator.CreateExact(Instruction.BinaryOps.SDiv, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateExactUDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 479,
   FQN="llvm::BinaryOperator::CreateExactUDiv", NM="_ZN4llvm14BinaryOperator15CreateExactUDivEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator15CreateExactUDivEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateExactUDiv(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateExactUDiv(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateExactUDiv(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return BinaryOperator.CreateExact(Instruction.BinaryOps.UDiv, V1, V2, Name); // CreateExactUDiv
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateExactUDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 479,
   FQN="llvm::BinaryOperator::CreateExactUDiv", NM="_ZN4llvm14BinaryOperator15CreateExactUDivEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator15CreateExactUDivEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateExactUDiv(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return BinaryOperator.CreateExact(Instruction.BinaryOps.UDiv, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateExactUDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 479,
   FQN="llvm::BinaryOperator::CreateExactUDiv", NM="_ZN4llvm14BinaryOperator15CreateExactUDivEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator15CreateExactUDivEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateExactUDiv(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return BinaryOperator.CreateExact(Instruction.BinaryOps.UDiv, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateExactAShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 480,
   FQN="llvm::BinaryOperator::CreateExactAShr", NM="_ZN4llvm14BinaryOperator15CreateExactAShrEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator15CreateExactAShrEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateExactAShr(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateExactAShr(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateExactAShr(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return BinaryOperator.CreateExact(Instruction.BinaryOps.AShr, V1, V2, Name); // CreateExactAShr
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateExactAShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 480,
   FQN="llvm::BinaryOperator::CreateExactAShr", NM="_ZN4llvm14BinaryOperator15CreateExactAShrEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator15CreateExactAShrEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateExactAShr(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return BinaryOperator.CreateExact(Instruction.BinaryOps.AShr, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateExactAShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 480,
   FQN="llvm::BinaryOperator::CreateExactAShr", NM="_ZN4llvm14BinaryOperator15CreateExactAShrEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator15CreateExactAShrEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateExactAShr(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return BinaryOperator.CreateExact(Instruction.BinaryOps.AShr, V1, V2, Name, I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateExactLShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 481,
   FQN="llvm::BinaryOperator::CreateExactLShr", NM="_ZN4llvm14BinaryOperator15CreateExactLShrEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator15CreateExactLShrEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateExactLShr(Value /*P*/ V1, Value /*P*/ V2) {
    return CreateExactLShr(V1, V2, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static BinaryOperator /*P*/ CreateExactLShr(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return BinaryOperator.CreateExact(Instruction.BinaryOps.LShr, V1, V2, Name); // CreateExactLShr
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateExactLShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 481,
   FQN="llvm::BinaryOperator::CreateExactLShr", NM="_ZN4llvm14BinaryOperator15CreateExactLShrEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator15CreateExactLShrEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateExactLShr(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB) {
    return BinaryOperator.CreateExact(Instruction.BinaryOps.LShr, V1, V2, Name, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateExactLShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 481,
   FQN="llvm::BinaryOperator::CreateExactLShr", NM="_ZN4llvm14BinaryOperator15CreateExactLShrEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator15CreateExactLShrEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateExactLShr(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ I) {
    return BinaryOperator.CreateExact(Instruction.BinaryOps.LShr, V1, V2, Name, I);
  }

  
  /// Helper functions to construct and inspect unary operations (NEG and NOT)
  /// via binary operators SUB and XOR:
  ///
  /// Create the NEG and NOT instructions out of SUB and XOR instructions.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNeg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2157,
   FQN="llvm::BinaryOperator::CreateNeg", NM="_ZN4llvm14BinaryOperator9CreateNegEPNS_5ValueERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateNegEPNS_5ValueERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNeg(Value /*P*/ Op) {
    return CreateNeg(Op, new Twine(/*KEEP_STR*/$EMPTY), 
           (Instruction /*P*/ )null);
  }
  public static BinaryOperator /*P*/ CreateNeg(Value /*P*/ Op, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateNeg(Op, Name, 
           (Instruction /*P*/ )null);
  }
  public static BinaryOperator /*P*/ CreateNeg(Value /*P*/ Op, final /*const*/ Twine /*&*/ Name/*= ""*/, 
           Instruction /*P*/ InsertBefore/*= null*/) {
    Value /*P*/ zero = ConstantFP.getZeroValueForNegation(Op.getType());
    return /*NEW_EXPR [BinaryOperator::new]*/BinaryOperator.$new_BinaryOperator((type$ptr<?> New$Mem)->{
        return new BinaryOperator(Instruction.BinaryOps.Sub, 
                zero, Op, 
                Op.getType(), Name, InsertBefore);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNeg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2165,
   FQN="llvm::BinaryOperator::CreateNeg", NM="_ZN4llvm14BinaryOperator9CreateNegEPNS_5ValueERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateNegEPNS_5ValueERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNeg(Value /*P*/ Op, final /*const*/ Twine /*&*/ Name, 
           BasicBlock /*P*/ InsertAtEnd) {
    Value /*P*/ zero = ConstantFP.getZeroValueForNegation(Op.getType());
    return /*NEW_EXPR [BinaryOperator::new]*/BinaryOperator.$new_BinaryOperator((type$ptr<?> New$Mem)->{
        return new BinaryOperator(Instruction.BinaryOps.Sub, 
                zero, Op, 
                Op.getType(), Name, InsertAtEnd);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNSWNeg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2173,
   FQN="llvm::BinaryOperator::CreateNSWNeg", NM="_ZN4llvm14BinaryOperator12CreateNSWNegEPNS_5ValueERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNSWNegEPNS_5ValueERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNSWNeg(Value /*P*/ Op) {
    return CreateNSWNeg(Op, new Twine(/*KEEP_STR*/$EMPTY), 
              (Instruction /*P*/ )null);
  }
  public static BinaryOperator /*P*/ CreateNSWNeg(Value /*P*/ Op, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateNSWNeg(Op, Name, 
              (Instruction /*P*/ )null);
  }
  public static BinaryOperator /*P*/ CreateNSWNeg(Value /*P*/ Op, final /*const*/ Twine /*&*/ Name/*= ""*/, 
              Instruction /*P*/ InsertBefore/*= null*/) {
    Value /*P*/ zero = ConstantFP.getZeroValueForNegation(Op.getType());
    return BinaryOperator.CreateNSWSub(zero, Op, Name, InsertBefore);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNSWNeg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2179,
   FQN="llvm::BinaryOperator::CreateNSWNeg", NM="_ZN4llvm14BinaryOperator12CreateNSWNegEPNS_5ValueERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNSWNegEPNS_5ValueERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNSWNeg(Value /*P*/ Op, final /*const*/ Twine /*&*/ Name, 
              BasicBlock /*P*/ InsertAtEnd) {
    Value /*P*/ zero = ConstantFP.getZeroValueForNegation(Op.getType());
    return BinaryOperator.CreateNSWSub(zero, Op, Name, InsertAtEnd);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNUWNeg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2185,
   FQN="llvm::BinaryOperator::CreateNUWNeg", NM="_ZN4llvm14BinaryOperator12CreateNUWNegEPNS_5ValueERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNUWNegEPNS_5ValueERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNUWNeg(Value /*P*/ Op) {
    return CreateNUWNeg(Op, new Twine(/*KEEP_STR*/$EMPTY), 
              (Instruction /*P*/ )null);
  }
  public static BinaryOperator /*P*/ CreateNUWNeg(Value /*P*/ Op, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateNUWNeg(Op, Name, 
              (Instruction /*P*/ )null);
  }
  public static BinaryOperator /*P*/ CreateNUWNeg(Value /*P*/ Op, final /*const*/ Twine /*&*/ Name/*= ""*/, 
              Instruction /*P*/ InsertBefore/*= null*/) {
    Value /*P*/ zero = ConstantFP.getZeroValueForNegation(Op.getType());
    return BinaryOperator.CreateNUWSub(zero, Op, Name, InsertBefore);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNUWNeg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2191,
   FQN="llvm::BinaryOperator::CreateNUWNeg", NM="_ZN4llvm14BinaryOperator12CreateNUWNegEPNS_5ValueERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12CreateNUWNegEPNS_5ValueERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNUWNeg(Value /*P*/ Op, final /*const*/ Twine /*&*/ Name, 
              BasicBlock /*P*/ InsertAtEnd) {
    Value /*P*/ zero = ConstantFP.getZeroValueForNegation(Op.getType());
    return BinaryOperator.CreateNUWSub(zero, Op, Name, InsertAtEnd);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateFNeg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2197,
   FQN="llvm::BinaryOperator::CreateFNeg", NM="_ZN4llvm14BinaryOperator10CreateFNegEPNS_5ValueERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateFNegEPNS_5ValueERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateFNeg(Value /*P*/ Op) {
    return CreateFNeg(Op, new Twine(/*KEEP_STR*/$EMPTY), 
            (Instruction /*P*/ )null);
  }
  public static BinaryOperator /*P*/ CreateFNeg(Value /*P*/ Op, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFNeg(Op, Name, 
            (Instruction /*P*/ )null);
  }
  public static BinaryOperator /*P*/ CreateFNeg(Value /*P*/ Op, final /*const*/ Twine /*&*/ Name/*= ""*/, 
            Instruction /*P*/ InsertBefore/*= null*/) {
    Value /*P*/ zero = ConstantFP.getZeroValueForNegation(Op.getType());
    return /*NEW_EXPR [BinaryOperator::new]*/BinaryOperator.$new_BinaryOperator((type$ptr<?> New$Mem)->{
        return new BinaryOperator(Instruction.BinaryOps.FSub, zero, Op, 
                Op.getType(), Name, InsertBefore);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateFNeg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2204,
   FQN="llvm::BinaryOperator::CreateFNeg", NM="_ZN4llvm14BinaryOperator10CreateFNegEPNS_5ValueERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator10CreateFNegEPNS_5ValueERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateFNeg(Value /*P*/ Op, final /*const*/ Twine /*&*/ Name, 
            BasicBlock /*P*/ InsertAtEnd) {
    Value /*P*/ zero = ConstantFP.getZeroValueForNegation(Op.getType());
    return /*NEW_EXPR [BinaryOperator::new]*/BinaryOperator.$new_BinaryOperator((type$ptr<?> New$Mem)->{
        return new BinaryOperator(Instruction.BinaryOps.FSub, zero, Op, 
                Op.getType(), Name, InsertAtEnd);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2211,
   FQN="llvm::BinaryOperator::CreateNot", NM="_ZN4llvm14BinaryOperator9CreateNotEPNS_5ValueERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateNotEPNS_5ValueERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNot(Value /*P*/ Op) {
    return CreateNot(Op, new Twine(/*KEEP_STR*/$EMPTY), 
           (Instruction /*P*/ )null);
  }
  public static BinaryOperator /*P*/ CreateNot(Value /*P*/ Op, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateNot(Op, Name, 
           (Instruction /*P*/ )null);
  }
  public static BinaryOperator /*P*/ CreateNot(Value /*P*/ Op, final /*const*/ Twine /*&*/ Name/*= ""*/, 
           Instruction /*P*/ InsertBefore/*= null*/) {
    Constant /*P*/ C = Constant.getAllOnesValue(Op.getType());
    return /*NEW_EXPR [BinaryOperator::new]*/BinaryOperator.$new_BinaryOperator((type$ptr<?> New$Mem)->{
        return new BinaryOperator(Instruction.BinaryOps.Xor, Op, C, 
                Op.getType(), Name, InsertBefore);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::CreateNot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2218,
   FQN="llvm::BinaryOperator::CreateNot", NM="_ZN4llvm14BinaryOperator9CreateNotEPNS_5ValueERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator9CreateNotEPNS_5ValueERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static BinaryOperator /*P*/ CreateNot(Value /*P*/ Op, final /*const*/ Twine /*&*/ Name, 
           BasicBlock /*P*/ InsertAtEnd) {
    Constant /*P*/ AllOnes = Constant.getAllOnesValue(Op.getType());
    return /*NEW_EXPR [BinaryOperator::new]*/BinaryOperator.$new_BinaryOperator((type$ptr<?> New$Mem)->{
        return new BinaryOperator(Instruction.BinaryOps.Xor, Op, AllOnes, 
                Op.getType(), Name, InsertAtEnd);
     });
  }

  
  /// Check if the given Value is a NEG, FNeg, or NOT instruction.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::isNeg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2233,
   FQN="llvm::BinaryOperator::isNeg", NM="_ZN4llvm14BinaryOperator5isNegEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator5isNegEPKNS_5ValueE")
  //</editor-fold>
  public static boolean isNeg(/*const*/ Value /*P*/ V) {
    {
      /*const*/ BinaryOperator /*P*/ Bop = dyn_cast_BinaryOperator(V);
      if ((Bop != null)) {
        if (Bop.getOpcode() == Instruction.BinaryOps.Sub) {
          {
            Constant /*P*/ C = dyn_cast_Constant(Bop.getOperand(0));
            if ((C != null)) {
              return C.isNegativeZeroValue();
            }
          }
        }
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::isFNeg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2241,
   FQN="llvm::BinaryOperator::isFNeg", NM="_ZN4llvm14BinaryOperator6isFNegEPKNS_5ValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator6isFNegEPKNS_5ValueEb")
  //</editor-fold>
  public static boolean isFNeg(/*const*/ Value /*P*/ V) {
    return isFNeg(V, false);
  }
  public static boolean isFNeg(/*const*/ Value /*P*/ V, boolean IgnoreZeroSign/*= false*/) {
    {
      /*const*/ BinaryOperator /*P*/ Bop = dyn_cast_BinaryOperator(V);
      if ((Bop != null)) {
        if (Bop.getOpcode() == Instruction.BinaryOps.FSub) {
          {
            Constant /*P*/ C = dyn_cast_Constant(Bop.getOperand(0));
            if ((C != null)) {
              if (!IgnoreZeroSign) {
                IgnoreZeroSign = cast_Instruction(V).hasNoSignedZeros();
              }
              return !IgnoreZeroSign ? C.isNegativeZeroValue() : C.isZeroValue();
            }
          }
        }
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::isNot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2252,
   FQN="llvm::BinaryOperator::isNot", NM="_ZN4llvm14BinaryOperator5isNotEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator5isNotEPKNS_5ValueE")
  //</editor-fold>
  public static boolean isNot(/*const*/ Value /*P*/ V) {
    {
      /*const*/ BinaryOperator /*P*/ Bop = dyn_cast_BinaryOperator(V);
      if ((Bop != null)) {
        return (Bop.getOpcode() == Instruction.BinaryOps.Xor
           && (InstructionsStatics.isConstantAllOnes(Bop.getOperand(1))
           || InstructionsStatics.isConstantAllOnes(Bop.getOperand(0))));
      }
    }
    return false;
  }

  
  /// Helper functions to extract the unary argument of a NEG, FNEG or NOT
  /// operation implemented via Sub, FSub, or Xor.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::getNegArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2264,
   FQN="llvm::BinaryOperator::getNegArgument", NM="_ZN4llvm14BinaryOperator14getNegArgumentEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator14getNegArgumentEPKNS_5ValueE")
  //</editor-fold>
  public static /*const*/ Value /*P*/ getNegArgument_Value$C$P(/*const*/ Value /*P*/ BinOp) {
    return getNegArgument_Value$P(((/*const_cast*/Value /*P*/ )(BinOp)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::getNegArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2260,
   FQN="llvm::BinaryOperator::getNegArgument", NM="_ZN4llvm14BinaryOperator14getNegArgumentEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator14getNegArgumentEPNS_5ValueE")
  //</editor-fold>
  public static Value /*P*/ getNegArgument_Value$P(Value /*P*/ BinOp) {
    return cast_BinaryOperator(BinOp).getOperand(1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::getFNegArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2272,
   FQN="llvm::BinaryOperator::getFNegArgument", NM="_ZN4llvm14BinaryOperator15getFNegArgumentEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator15getFNegArgumentEPKNS_5ValueE")
  //</editor-fold>
  public static /*const*/ Value /*P*/ getFNegArgument_Value$C$P(/*const*/ Value /*P*/ BinOp) {
    return getFNegArgument_Value$P(((/*const_cast*/Value /*P*/ )(BinOp)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::getFNegArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2268,
   FQN="llvm::BinaryOperator::getFNegArgument", NM="_ZN4llvm14BinaryOperator15getFNegArgumentEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator15getFNegArgumentEPNS_5ValueE")
  //</editor-fold>
  public static Value /*P*/ getFNegArgument_Value$P(Value /*P*/ BinOp) {
    return cast_BinaryOperator(BinOp).getOperand(1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::getNotArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2287,
   FQN="llvm::BinaryOperator::getNotArgument", NM="_ZN4llvm14BinaryOperator14getNotArgumentEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator14getNotArgumentEPKNS_5ValueE")
  //</editor-fold>
  public static /*const*/ Value /*P*/ getNotArgument_Value$C$P(/*const*/ Value /*P*/ BinOp) {
    return getNotArgument_Value$P(((/*const_cast*/Value /*P*/ )(BinOp)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::getNotArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2276,
   FQN="llvm::BinaryOperator::getNotArgument", NM="_ZN4llvm14BinaryOperator14getNotArgumentEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator14getNotArgumentEPNS_5ValueE")
  //</editor-fold>
  public static Value /*P*/ getNotArgument_Value$P(Value /*P*/ BinOp) {
    assert (isNot(BinOp)) : "getNotArgument on non-'not' instruction!";
    BinaryOperator /*P*/ BO = cast_BinaryOperator(BinOp);
    Value /*P*/ Op0 = BO.getOperand(0);
    Value /*P*/ Op1 = BO.getOperand(1);
    if (InstructionsStatics.isConstantAllOnes(Op0)) {
      return Op1;
    }
    assert (InstructionsStatics.isConstantAllOnes(Op1));
    return Op0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::getOpcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 527,
   FQN="llvm::BinaryOperator::getOpcode", NM="_ZNK4llvm14BinaryOperator9getOpcodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14BinaryOperator9getOpcodeEv")
  //</editor-fold>
  public /*BinaryOps*/int getOpcode() /*const*/ {
    return ((/*static_cast*//*BinaryOps*/int)(super.getOpcode()));
  }

  
  /// Exchange the two operands to this instruction.
  /// This instruction is safe to use on any binary instruction and
  /// does not modify the semantics of the instruction.  If the instruction
  /// cannot be reversed (ie, it's a Div), then return true.
  ///
  
  // swapOperands - Exchange the two operands to this instruction.  This
  // instruction is safe to use on any binary instruction and does not
  // modify the semantics of the instruction.  If the instruction is
  // order dependent (SetLT f.e.) the opcode is changed.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::swapOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2297,
   FQN="llvm::BinaryOperator::swapOperands", NM="_ZN4llvm14BinaryOperator12swapOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator12swapOperandsEv")
  //</editor-fold>
  public boolean swapOperands() {
    if (!isCommutative()) {
      return true; // Can't commute operands
    }
    this./*<0>*/Op(0).swap(this./*<1>*/Op(1));
    return false;
  }

  
  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 539,
   FQN="llvm::BinaryOperator::classof", NM="_ZN4llvm14BinaryOperator7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.isBinaryOp();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 542,
   FQN="llvm::BinaryOperator::classof", NM="_ZN4llvm14BinaryOperator7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperator7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && BinaryOperator.classof(cast_Instruction(V));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BinaryOperator::~BinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 328,
   FQN="llvm::BinaryOperator::~BinaryOperator", NM="_ZN4llvm14BinaryOperatorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14BinaryOperatorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
