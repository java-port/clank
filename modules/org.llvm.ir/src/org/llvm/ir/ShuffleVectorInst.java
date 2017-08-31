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
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
//                           ShuffleVectorInst Class
//===----------------------------------------------------------------------===//

/// ShuffleVectorInst - This instruction constructs a fixed permutation of two
/// input vectors.
///
//<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2149,
 FQN="llvm::ShuffleVectorInst", NM="_ZN4llvm17ShuffleVectorInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17ShuffleVectorInstE")
//</editor-fold>
public class ShuffleVectorInst extends /*public*/ Instruction implements Destructors.ClassWithDestructor {
/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 4031,
   FQN="llvm::ShuffleVectorInst::cloneImpl", NM="_ZNK4llvm17ShuffleVectorInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17ShuffleVectorInst9cloneImplEv")
  //</editor-fold>
  protected ShuffleVectorInst /*P*/ cloneImpl() /*const*/ {
    return /*NEW_EXPR [ShuffleVectorInst::new]*/ShuffleVectorInst.$new_ShuffleVectorInst((type$ptr<?> New$Mem)->{
        return new ShuffleVectorInst(getOperand(0), getOperand(1), getOperand(2));
     });
  }

/*public:*/
  // allocate space for exactly three operands
  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::operator new">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2157,
   FQN="llvm::ShuffleVectorInst::operator new", NM="_ZN4llvm17ShuffleVectorInstnwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17ShuffleVectorInstnwEj")
  //</editor-fold>
  public static <T extends ShuffleVectorInst> T/*void P*/ $new_ShuffleVectorInst(/*size_tint s, */New$ConstructorCallback<T> $Ctor) {
    return User.$new_FixedUses(/*s, */3, $Ctor);
  }


  //===----------------------------------------------------------------------===//
  //                      ShuffleVectorInst Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::ShuffleVectorInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1836,
   FQN="llvm::ShuffleVectorInst::ShuffleVectorInst", NM="_ZN4llvm17ShuffleVectorInstC1EPNS_5ValueES2_S2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17ShuffleVectorInstC1EPNS_5ValueES2_S2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public ShuffleVectorInst(Value /*P*/ V1, Value /*P*/ V2, Value /*P*/ Mask) {
    this(V1, V2, Mask,
      new Twine(/*KEEP_STR*/$EMPTY),
      (Instruction /*P*/ )null);
  }
  public ShuffleVectorInst(Value /*P*/ V1, Value /*P*/ V2, Value /*P*/ Mask,
      final /*const*/ Twine /*&*/ Name/*= ""*/) {
    this(V1, V2, Mask,
      Name,
      (Instruction /*P*/ )null);
  }
  public ShuffleVectorInst(Value /*P*/ V1, Value /*P*/ V2, Value /*P*/ Mask,
      final /*const*/ Twine /*&*/ Name/*= ""*/,
      Instruction /*P*/ InsertBefore/*= null*/) {
    // : Instruction(VectorType::get(cast<VectorType>(V1->getType())->getElementType(), cast<VectorType>(Mask->getType())->getNumElements()), ShuffleVector, OperandTraits<ShuffleVectorInst>::op_begin(this), OperandTraits<ShuffleVectorInst>::operands(this), InsertBefore)
    //START JInit
    super(VectorType.get(cast_VectorType(V1.getType()).getElementType(),
            cast_VectorType(Mask.getType()).getNumElements()),
        OtherOps.ShuffleVector,
        OperandTraitsShuffleVectorInst.<ShuffleVectorInst>op_begin(User.$BEING_CREATED()),
        OperandTraitsShuffleVectorInst.<ShuffleVectorInst>operands$FixedNumOperandTraits(User.$BEING_CREATED()),
        InsertBefore);
    //END JInit
    assert (ShuffleVectorInst.isValidOperands(V1, V2, Mask)) : "Invalid shuffle vector instruction operands!";
    this./*<0>*/Op(0).$assign(V1);
    this./*<1>*/Op(1).$assign(V2);
    this./*<2>*/Op(2).$assign(Mask);
    setName(Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::ShuffleVectorInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1853,
   FQN="llvm::ShuffleVectorInst::ShuffleVectorInst", NM="_ZN4llvm17ShuffleVectorInstC1EPNS_5ValueES2_S2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17ShuffleVectorInstC1EPNS_5ValueES2_S2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public ShuffleVectorInst(Value /*P*/ V1, Value /*P*/ V2, Value /*P*/ Mask,
      final /*const*/ Twine /*&*/ Name,
      BasicBlock /*P*/ InsertAtEnd) {
    // : Instruction(VectorType::get(cast<VectorType>(V1->getType())->getElementType(), cast<VectorType>(Mask->getType())->getNumElements()), ShuffleVector, OperandTraits<ShuffleVectorInst>::op_begin(this), OperandTraits<ShuffleVectorInst>::operands(this), InsertAtEnd)
    //START JInit
    super(VectorType.get(cast_VectorType(V1.getType()).getElementType(),
            cast_VectorType(Mask.getType()).getNumElements()),
        OtherOps.ShuffleVector,
        OperandTraitsShuffleVectorInst.<ShuffleVectorInst>op_begin(User.$BEING_CREATED()),
        OperandTraitsShuffleVectorInst.<ShuffleVectorInst>operands$FixedNumOperandTraits(User.$BEING_CREATED()),
        InsertAtEnd);
    //END JInit
    assert (ShuffleVectorInst.isValidOperands(V1, V2, Mask)) : "Invalid shuffle vector instruction operands!";

    this./*<0>*/Op(0).$assign(V1);
    this./*<1>*/Op(1).$assign(V2);
    this./*<2>*/Op(2).$assign(Mask);
    setName(Name);
  }


  /// isValidOperands - Return true if a shufflevector instruction can be
  /// formed with the specified operands.
  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::isValidOperands">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1871,
   FQN="llvm::ShuffleVectorInst::isValidOperands", NM="_ZN4llvm17ShuffleVectorInst15isValidOperandsEPKNS_5ValueES3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17ShuffleVectorInst15isValidOperandsEPKNS_5ValueES3_S3_")
  //</editor-fold>
  public static boolean isValidOperands(/*const*/ Value /*P*/ V1, /*const*/ Value /*P*/ V2,
                 /*const*/ Value /*P*/ Mask) {
    // V1 and V2 must be vectors of the same type.
    if (!V1.getType().isVectorTy() || V1.getType() != V2.getType()) {
      return false;
    }

    // Mask must be vector of i32.
    VectorType /*P*/ MaskTy = dyn_cast_VectorType(Mask.getType());
    if (!(MaskTy != null) || !MaskTy.getElementType().isIntegerTy(32)) {
      return false;
    }

    // Check to see if Mask is valid.
    if (isa_UndefValue(Mask) || isa_ConstantAggregateZero(Mask)) {
      return true;
    }
    {

      /*const*/ ConstantVector /*P*/ MV = dyn_cast_ConstantVector(Mask);
      if ((MV != null)) {
        /*uint*/int V1Size = cast_VectorType(V1.getType()).getNumElements();
        //for (Value /*P*/ Op : MV.operands$Const()) {
        for (Use U : MV.operands$Const()) {
          {
            Value /*P*/ Op = U.$Value$P();
            ConstantInt /*P*/ CI = dyn_cast_ConstantInt(Op);
            if ((CI != null)) {
              if (CI.uge($uint2ulong(V1Size * 2))) {
                return false;
              }
            } else if (!isa_UndefValue(Op)) {
              return false;
            }
          }
        }
        return true;
      }
    }
    {

      /*const*/ ConstantDataSequential /*P*/ CDS = dyn_cast_ConstantDataSequential(Mask);
      if ((CDS != null)) {
        /*uint*/int V1Size = cast_VectorType(V1.getType()).getNumElements();
        for (/*uint*/int i = 0, e = MaskTy.getNumElements(); i != e; ++i)  {
          if ($greatereq_ulong_uint(CDS.getElementAsInteger(i), V1Size * 2)) {
            return false;
          }
        }
        return true;
      }
    }
    {

      // The bitcode reader can create a place holder for a forward reference
      // used as the shuffle mask. When this occurs, the shuffle mask will
      // fall into this case and fail. To avoid this error, do this bit of
      // ugliness to allow such a mask pass.
      /*const*/ ConstantExpr /*P*/ CE = dyn_cast_ConstantExpr(Mask);
      if ((CE != null)) {
        if (CE.getOpcode() == Instruction.OtherOps.UserOp1) {
          return true;
        }
      }
    }

    return false;
  }


  /// getType - Overload to return most specific vector type.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2173,
   FQN="llvm::ShuffleVectorInst::getType", NM="_ZNK4llvm17ShuffleVectorInst7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17ShuffleVectorInst7getTypeEv")
  //</editor-fold>
  public VectorType /*P*/ getType() /*const*/ {
    return cast_VectorType(super.getType());
  }


  /// Transparently provide more efficient getOperand methods.
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2221,
   FQN="llvm::ShuffleVectorInst::getOperand", NM="_ZNK4llvm17ShuffleVectorInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17ShuffleVectorInst10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsShuffleVectorInst.<ShuffleVectorInst>operands$FixedNumOperandTraits(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsShuffleVectorInst.<ShuffleVectorInst>op_begin(((/*const_cast*/ShuffleVectorInst /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2221,
   FQN="llvm::ShuffleVectorInst::setOperand", NM="_ZN4llvm17ShuffleVectorInst10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17ShuffleVectorInst10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsShuffleVectorInst.<ShuffleVectorInst>operands$FixedNumOperandTraits(this))) : "setOperand() out of range!";
    OperandTraitsShuffleVectorInst.<ShuffleVectorInst>op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2221,
   FQN="llvm::ShuffleVectorInst::op_begin", NM="_ZN4llvm17ShuffleVectorInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17ShuffleVectorInst8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsShuffleVectorInst.<ShuffleVectorInst>op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2221,
   FQN="llvm::ShuffleVectorInst::op_begin", NM="_ZNK4llvm17ShuffleVectorInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17ShuffleVectorInst8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsShuffleVectorInst.<ShuffleVectorInst>op_begin(((/*const_cast*/ShuffleVectorInst /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2221,
   FQN="llvm::ShuffleVectorInst::op_end", NM="_ZN4llvm17ShuffleVectorInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17ShuffleVectorInst6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsShuffleVectorInst.<ShuffleVectorInst>op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2221,
   FQN="llvm::ShuffleVectorInst::op_end", NM="_ZNK4llvm17ShuffleVectorInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17ShuffleVectorInst6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsShuffleVectorInst.<ShuffleVectorInst>op_end(((/*const_cast*/ShuffleVectorInst /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2221,
   FQN="llvm::ShuffleVectorInst::Op", NM="Tpl__ZN4llvm17ShuffleVectorInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm17ShuffleVectorInst2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this.OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2221,
   FQN="llvm::ShuffleVectorInst::Op", NM="Tpl__ZNK4llvm17ShuffleVectorInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm17ShuffleVectorInst2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this.OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2221,
   FQN="llvm::ShuffleVectorInst::getNumOperands", NM="_ZNK4llvm17ShuffleVectorInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17ShuffleVectorInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsShuffleVectorInst.<ShuffleVectorInst>operands$FixedNumOperandTraits(this);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::getMask">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2180,
   FQN="llvm::ShuffleVectorInst::getMask", NM="_ZNK4llvm17ShuffleVectorInst7getMaskEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17ShuffleVectorInst7getMaskEv")
  //</editor-fold>
  public Constant /*P*/ getMask() /*const*/ {
    return cast_Constant(getOperand(2));
  }


  /// getMaskValue - Return the index from the shuffle mask for the specified
  /// output result.  This is either -1 if the element is undef or a number less
  /// than 2*numelements.

  /// getMaskValue - Return the index from the shuffle mask for the specified
  /// output result.  This is either -1 if the element is undef or a number less
  /// than 2*numelements.
  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::getMaskValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1922,
   FQN="llvm::ShuffleVectorInst::getMaskValue", NM="_ZN4llvm17ShuffleVectorInst12getMaskValueEPNS_8ConstantEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17ShuffleVectorInst12getMaskValueEPNS_8ConstantEj")
  //</editor-fold>
  public static int getMaskValue(Constant /*P*/ Mask, /*uint*/int i) {
    assert ($less_uint(i, Mask.getType().getVectorNumElements())) : "Index out of range";
    {
      ConstantDataSequential /*P*/ CDS = dyn_cast_ConstantDataSequential(Mask);
      if ((CDS != null)) {
        return $ulong2int(CDS.getElementAsInteger(i));
      }
    }
    Constant /*P*/ C = Mask.getAggregateElement(i);
    if (isa_UndefValue(C)) {
      return -1;
    }
    return $ulong2int(cast_ConstantInt(C).getZExtValue());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::getMaskValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2189,
   FQN="llvm::ShuffleVectorInst::getMaskValue", NM="_ZNK4llvm17ShuffleVectorInst12getMaskValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17ShuffleVectorInst12getMaskValueEj")
  //</editor-fold>
  public int getMaskValue(/*uint*/int i) /*const*/ {
    return ShuffleVectorInst.getMaskValue(getMask(), i);
  }


  /// getShuffleMask - Return the full mask for this instruction, where each
  /// element is the element number and undef's are returned as -1.

  /// getShuffleMask - Return the full mask for this instruction, where each
  /// element is the element number and undef's are returned as -1.
  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::getShuffleMask">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1934,
   FQN="llvm::ShuffleVectorInst::getShuffleMask", NM="_ZN4llvm17ShuffleVectorInst14getShuffleMaskEPNS_8ConstantERNS_15SmallVectorImplIiEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17ShuffleVectorInst14getShuffleMaskEPNS_8ConstantERNS_15SmallVectorImplIiEE")
  //</editor-fold>
  public static void getShuffleMask(Constant /*P*/ Mask,
                final SmallVectorImplInt /*&*/ Result) {
    /*uint*/int NumElts = Mask.getType().getVectorNumElements();
    {

      ConstantDataSequential /*P*/ CDS = dyn_cast_ConstantDataSequential(Mask);
      if ((CDS != null)) {
        for (/*uint*/int i = 0; i != NumElts; ++i)  {
          Result.push_back($ulong2int(CDS.getElementAsInteger(i)));
        }
        return;
      }
    }
    for (/*uint*/int i = 0; i != NumElts; ++i) {
      Constant /*P*/ C = Mask.getAggregateElement(i);
      Result.push_back($ullong2int(isa_UndefValue(C) ? $int2ullong(-1) : cast_ConstantInt(C).getZExtValue()));
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::getShuffleMask">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2197,
   FQN="llvm::ShuffleVectorInst::getShuffleMask", NM="_ZNK4llvm17ShuffleVectorInst14getShuffleMaskERNS_15SmallVectorImplIiEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17ShuffleVectorInst14getShuffleMaskERNS_15SmallVectorImplIiEE")
  //</editor-fold>
  public void getShuffleMask(final SmallVectorImplInt /*&*/ Result) /*const*/ {
    ShuffleVectorInst.getShuffleMask(getMask(), Result);
    /*JAVA:return*/return;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::getShuffleMask">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2201,
   FQN="llvm::ShuffleVectorInst::getShuffleMask", NM="_ZNK4llvm17ShuffleVectorInst14getShuffleMaskEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17ShuffleVectorInst14getShuffleMaskEv")
  //</editor-fold>
  public SmallVectorInt/*16*/ getShuffleMask() /*const*/ {
    SmallVectorInt/*16*/ Mask/*J*/= new SmallVectorInt/*16*/(16);
    getShuffleMask(Mask);
    return Mask;
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2208,
   FQN="llvm::ShuffleVectorInst::classof", NM="_ZN4llvm17ShuffleVectorInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17ShuffleVectorInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.OtherOps.ShuffleVector;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2211,
   FQN="llvm::ShuffleVectorInst::classof", NM="_ZN4llvm17ShuffleVectorInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17ShuffleVectorInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && ShuffleVectorInst.classof(cast_Instruction(V));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ShuffleVectorInst::~ShuffleVectorInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2149,
   FQN="llvm::ShuffleVectorInst::~ShuffleVectorInst", NM="_ZN4llvm17ShuffleVectorInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17ShuffleVectorInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
