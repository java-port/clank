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
import org.llvm.adt.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
//                               SelectInst Class
//===----------------------------------------------------------------------===//

/// SelectInst - This class represents the LLVM 'select' instruction.
///
//<editor-fold defaultstate="collapsed" desc="llvm::SelectInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1904,
 FQN="llvm::SelectInst", NM="_ZN4llvm10SelectInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SelectInstE")
//</editor-fold>
public class SelectInst extends /*public*/ Instruction implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1905,
   FQN="llvm::SelectInst::init", NM="_ZN4llvm10SelectInst4initEPNS_5ValueES2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SelectInst4initEPNS_5ValueES2_S2_")
  //</editor-fold>
  private void init(Value /*P*/ C, Value /*P*/ S1, Value /*P*/ S2) {
    assert (!Native.$bool(areInvalidOperands(C, S1, S2))) : "Invalid operands for select";
    this./*<0>*/Op(0).$assign(C);
    this./*<1>*/Op(1).$assign(S1);
    this./*<2>*/Op(2).$assign(S2);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::SelectInst">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1912,
   FQN="llvm::SelectInst::SelectInst", NM="_ZN4llvm10SelectInstC1EPNS_5ValueES2_S2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SelectInstC1EPNS_5ValueES2_S2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  private SelectInst(Value /*P*/ C, Value /*P*/ S1, Value /*P*/ S2, final /*const*/ Twine /*&*/ NameStr, 
      Instruction /*P*/ InsertBefore) {
    // : Instruction(S1->getType(), Instruction::Select, &Op<0>(), 3, InsertBefore) 
    //START JInit
    super(S1.getType(), Instruction.OtherOps.Select, 
        OpFrom$Addr(0, User.$BEING_CREATED(), SelectInst.class),//$AddrOf(this./*<0>*/Op(0)),
        3, InsertBefore);
    //END JInit
    init(C, S1, S2);
    setName(NameStr);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::SelectInst">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1919,
   FQN="llvm::SelectInst::SelectInst", NM="_ZN4llvm10SelectInstC1EPNS_5ValueES2_S2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SelectInstC1EPNS_5ValueES2_S2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  private SelectInst(Value /*P*/ C, Value /*P*/ S1, Value /*P*/ S2, final /*const*/ Twine /*&*/ NameStr, 
      BasicBlock /*P*/ InsertAtEnd) {
    // : Instruction(S1->getType(), Instruction::Select, &Op<0>(), 3, InsertAtEnd) 
    //START JInit
    super(S1.getType(), Instruction.OtherOps.Select, 
        OpFrom$Addr(0, User.$BEING_CREATED(), SelectInst.class),//$AddrOf(this./*<0>*/Op(0)),
        3, InsertAtEnd);
    //END JInit
    init(C, S1, S2);
    setName(NameStr);
  }

/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 4015,
   FQN="llvm::SelectInst::cloneImpl", NM="_ZNK4llvm10SelectInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10SelectInst9cloneImplEv")
  //</editor-fold>
  protected SelectInst /*P*/ cloneImpl() /*const*/ {
    return SelectInst.Create(getOperand(0), getOperand(1), getOperand(2));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1933,
   FQN="llvm::SelectInst::Create", NM="_ZN4llvm10SelectInst6CreateEPNS_5ValueES2_S2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SelectInst6CreateEPNS_5ValueES2_S2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static SelectInst /*P*/ Create(Value /*P*/ C, Value /*P*/ S1, Value /*P*/ S2) {
    return Create(C, S1, S2, 
        new Twine(/*KEEP_STR*/$EMPTY), 
        (Instruction /*P*/ )null);
  }
  public static SelectInst /*P*/ Create(Value /*P*/ C, Value /*P*/ S1, Value /*P*/ S2, 
        final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    return Create(C, S1, S2, 
        NameStr, 
        (Instruction /*P*/ )null);
  }
  public static SelectInst /*P*/ Create(Value /*P*/ C, Value /*P*/ S1, Value /*P*/ S2, 
        final /*const*/ Twine /*&*/ NameStr/*= ""*/, 
        Instruction /*P*/ InsertBefore/*= null*/) {
    return ((/*JCast*/SelectInst /*P*/ )(/*NEW_EXPR [User::new]3 = /*new (3)*/ User.$new_FixedUses(3, (type$ptr<?> New$Mem)->{
        return new SelectInst(C, S1, S2, NameStr, InsertBefore);
     })));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1938,
   FQN="llvm::SelectInst::Create", NM="_ZN4llvm10SelectInst6CreateEPNS_5ValueES2_S2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SelectInst6CreateEPNS_5ValueES2_S2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static SelectInst /*P*/ Create(Value /*P*/ C, Value /*P*/ S1, Value /*P*/ S2, 
        final /*const*/ Twine /*&*/ NameStr, 
        BasicBlock /*P*/ InsertAtEnd) {
    return ((/*JCast*/SelectInst /*P*/ )(/*NEW_EXPR [User::new]3 = /*new (3)*/ User.$new_FixedUses(3, (type$ptr<?> New$Mem)->{
        return new SelectInst(C, S1, S2, NameStr, InsertAtEnd);
     })));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::getCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1944,
   FQN="llvm::SelectInst::getCondition", NM="_ZNK4llvm10SelectInst12getConditionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10SelectInst12getConditionEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getCondition$Const() /*const*/ {
    return this./*<0>*/Op$Const(0).$Value$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::getTrueValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1945,
   FQN="llvm::SelectInst::getTrueValue", NM="_ZNK4llvm10SelectInst12getTrueValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10SelectInst12getTrueValueEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getTrueValue$Const() /*const*/ {
    return this./*<1>*/Op$Const(1).$Value$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::getFalseValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1946,
   FQN="llvm::SelectInst::getFalseValue", NM="_ZNK4llvm10SelectInst13getFalseValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10SelectInst13getFalseValueEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getFalseValue$Const() /*const*/ {
    return this./*<2>*/Op$Const(2).$Value$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::getCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1947,
   FQN="llvm::SelectInst::getCondition", NM="_ZN4llvm10SelectInst12getConditionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SelectInst12getConditionEv")
  //</editor-fold>
  public Value /*P*/ getCondition() {
    return this./*<0>*/Op(0).$Value$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::getTrueValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1948,
   FQN="llvm::SelectInst::getTrueValue", NM="_ZN4llvm10SelectInst12getTrueValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SelectInst12getTrueValueEv")
  //</editor-fold>
  public Value /*P*/ getTrueValue() {
    return this./*<1>*/Op(1).$Value$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::getFalseValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1949,
   FQN="llvm::SelectInst::getFalseValue", NM="_ZN4llvm10SelectInst13getFalseValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SelectInst13getFalseValueEv")
  //</editor-fold>
  public Value /*P*/ getFalseValue() {
    return this./*<2>*/Op(2).$Value$P();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::setCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1951,
   FQN="llvm::SelectInst::setCondition", NM="_ZN4llvm10SelectInst12setConditionEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SelectInst12setConditionEPNS_5ValueE")
  //</editor-fold>
  public void setCondition(Value /*P*/ V) {
    this./*<0>*/Op(0).$assign(V);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::setTrueValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1952,
   FQN="llvm::SelectInst::setTrueValue", NM="_ZN4llvm10SelectInst12setTrueValueEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SelectInst12setTrueValueEPNS_5ValueE")
  //</editor-fold>
  public void setTrueValue(Value /*P*/ V) {
    this./*<1>*/Op(1).$assign(V);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::setFalseValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1953,
   FQN="llvm::SelectInst::setFalseValue", NM="_ZN4llvm10SelectInst13setFalseValueEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SelectInst13setFalseValueEPNS_5ValueE")
  //</editor-fold>
  public void setFalseValue(Value /*P*/ V) {
    this./*<2>*/Op(2).$assign(V);
  }

  
  /// areInvalidOperands - Return a string if the specified operands are invalid
  /// for a select operation, otherwise return null.
  
  //===----------------------------------------------------------------------===//
  //                              SelectInst Class
  //===----------------------------------------------------------------------===//
  
  /// areInvalidOperands - Return a string if the specified operands are invalid
  /// for a select operation, otherwise return null.
  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::areInvalidOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 62,
   FQN="llvm::SelectInst::areInvalidOperands", NM="_ZN4llvm10SelectInst18areInvalidOperandsEPNS_5ValueES2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SelectInst18areInvalidOperandsEPNS_5ValueES2_S2_")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ areInvalidOperands(Value /*P*/ Op0, Value /*P*/ Op1, Value /*P*/ Op2) {
    if (Op1.getType() != Op2.getType()) {
      return $("both values to select must have same type");
    }
    if (Op1.getType().isTokenTy()) {
      return $("select values cannot have token type");
    }
    {
      
      VectorType /*P*/ VT = dyn_cast_VectorType(Op0.getType());
      if ((VT != null)) {
        // Vector select.
        if (VT.getElementType() != Type.getInt1Ty(Op0.getContext())) {
          return $("vector select condition element type must be i1");
        }
        VectorType /*P*/ ET = dyn_cast_VectorType(Op1.getType());
        if (!(ET != null)) {
          return $("selected values for vector select must be vectors");
        }
        if (ET.getNumElements() != VT.getNumElements()) {
          return $("vector select requires selected vectors to have the same vector length as select condition");
        }
      } else if (Op0.getType() != Type.getInt1Ty(Op0.getContext())) {
        return $("select condition must be i1 or <n x i1>");
      }
    }
    return null;
  }


  /// Transparently provide more efficient getOperand methods.
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1979,
   FQN="llvm::SelectInst::getOperand", NM="_ZNK4llvm10SelectInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10SelectInst10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsSelectInst.operands$FixedNumOperandTraits(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsSelectInst.op_begin(((/*const_cast*/SelectInst /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1979,
   FQN="llvm::SelectInst::setOperand", NM="_ZN4llvm10SelectInst10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SelectInst10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsSelectInst.operands$FixedNumOperandTraits(this))) : "setOperand() out of range!";
    OperandTraitsSelectInst.op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1979,
   FQN="llvm::SelectInst::op_begin", NM="_ZN4llvm10SelectInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SelectInst8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsSelectInst.op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1979,
   FQN="llvm::SelectInst::op_begin", NM="_ZNK4llvm10SelectInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10SelectInst8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsSelectInst.op_begin(((/*const_cast*/SelectInst /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1979,
   FQN="llvm::SelectInst::op_end", NM="_ZN4llvm10SelectInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SelectInst6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsSelectInst.op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1979,
   FQN="llvm::SelectInst::op_end", NM="_ZNK4llvm10SelectInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10SelectInst6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsSelectInst.op_end(((/*const_cast*/SelectInst /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::Op">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1979,
   FQN="llvm::SelectInst::Op", NM="Tpl__ZN4llvm10SelectInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm10SelectInst2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::Op">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1979,
   FQN="llvm::SelectInst::Op", NM="Tpl__ZNK4llvm10SelectInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm10SelectInst2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1979,
   FQN="llvm::SelectInst::getNumOperands", NM="_ZNK4llvm10SelectInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10SelectInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsSelectInst.operands$FixedNumOperandTraits(this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::getOpcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1962,
   FQN="llvm::SelectInst::getOpcode", NM="_ZNK4llvm10SelectInst9getOpcodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10SelectInst9getOpcodeEv")
  //</editor-fold>
  public /*OtherOps*/int getOpcode$SelectInst() /*const*/ {
    return ((/*static_cast*//*OtherOps*/int)(super.getOpcode()));
  }

  
  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1967,
   FQN="llvm::SelectInst::classof", NM="_ZN4llvm10SelectInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SelectInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.OtherOps.Select;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1970,
   FQN="llvm::SelectInst::classof", NM="_ZN4llvm10SelectInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SelectInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && SelectInst.classof(cast_Instruction(V));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SelectInst::~SelectInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1904,
   FQN="llvm::SelectInst::~SelectInst", NM="_ZN4llvm10SelectInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SelectInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
