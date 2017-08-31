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
import static org.clank.support.Unsigned.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
//                               CatchReturnInst Class
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4208,
 FQN="llvm::CatchReturnInst", NM="_ZN4llvm15CatchReturnInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchReturnInstE")
//</editor-fold>
public class CatchReturnInst extends /*public*/ TerminatorInst implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::CatchReturnInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 948,
   FQN="llvm::CatchReturnInst::CatchReturnInst", NM="_ZN4llvm15CatchReturnInstC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchReturnInstC1ERKS0_")
  //</editor-fold>
  private CatchReturnInst(final /*const*/ CatchReturnInst /*&*/ CRI) {
    // : TerminatorInst(Type::getVoidTy(CRI.getContext()), Instruction::CatchRet, OperandTraits<CatchReturnInst>::op_begin(this), 2) 
    //START JInit
    super(Type.getVoidTy(CRI.getContext()), Instruction.TermOps.CatchRet, 
        OperandTraitsCatchReturnInst.<CatchReturnInst>op_begin(User.$BEING_CREATED()), 2);
    //END JInit
    this./*<0>*/Op(0).$assign(CRI./*<0>*/Op$Const(0));
    this./*<1>*/Op(1).$assign(CRI./*<1>*/Op$Const(1));
  }

  
  
  //===----------------------------------------------------------------------===//
  //                        CatchReturnInst Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 943,
   FQN="llvm::CatchReturnInst::init", NM="_ZN4llvm15CatchReturnInst4initEPNS_5ValueEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchReturnInst4initEPNS_5ValueEPNS_10BasicBlockE")
  //</editor-fold>
  private void init(Value /*P*/ CatchPad, BasicBlock /*P*/ BB) {
    this./*<0>*/Op(0).$assign(CatchPad);
    this./*<1>*/Op(1).$assign(BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::CatchReturnInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 955,
   FQN="llvm::CatchReturnInst::CatchReturnInst", NM="_ZN4llvm15CatchReturnInstC1EPNS_5ValueEPNS_10BasicBlockEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchReturnInstC1EPNS_5ValueEPNS_10BasicBlockEPNS_11InstructionE")
  //</editor-fold>
  private CatchReturnInst(Value /*P*/ CatchPad, BasicBlock /*P*/ BB, 
      Instruction /*P*/ InsertBefore) {
    // : TerminatorInst(Type::getVoidTy(BB->getContext()), Instruction::CatchRet, OperandTraits<CatchReturnInst>::op_begin(this), 2, InsertBefore) 
    //START JInit
    super(Type.getVoidTy(BB.getContext()), Instruction.TermOps.CatchRet, 
        OperandTraitsCatchReturnInst.<CatchReturnInst>op_begin(User.$BEING_CREATED()), 2, 
        InsertBefore);
    //END JInit
    init(CatchPad, BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::CatchReturnInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 963,
   FQN="llvm::CatchReturnInst::CatchReturnInst", NM="_ZN4llvm15CatchReturnInstC1EPNS_5ValueEPNS_10BasicBlockES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchReturnInstC1EPNS_5ValueEPNS_10BasicBlockES4_")
  //</editor-fold>
  private CatchReturnInst(Value /*P*/ CatchPad, BasicBlock /*P*/ BB, 
      BasicBlock /*P*/ InsertAtEnd) {
    // : TerminatorInst(Type::getVoidTy(BB->getContext()), Instruction::CatchRet, OperandTraits<CatchReturnInst>::op_begin(this), 2, InsertAtEnd) 
    //START JInit
    super(Type.getVoidTy(BB.getContext()), Instruction.TermOps.CatchRet, 
        OperandTraitsCatchReturnInst.<CatchReturnInst>op_begin(User.$BEING_CREATED()), 2,
        InsertAtEnd);
    //END JInit
    init(CatchPad, BB);
  }

/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::cloneImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 4069,
   FQN="llvm::CatchReturnInst::cloneImpl", NM="_ZNK4llvm15CatchReturnInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchReturnInst9cloneImplEv")
  //</editor-fold>
  protected CatchReturnInst /*P*/ cloneImpl() /*const*/ {
    return ((/*JCast*/CatchReturnInst /*P*/ )(/*NEW_EXPR [User::new]*/ /*new (getNumOperands())*/ User.$new_FixedUses(getNumOperands(), (type$ptr<?> New$Mem)->{
        return new CatchReturnInst(/*Deref*/this);
     })));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4221,
   FQN="llvm::CatchReturnInst::Create", NM="_ZN4llvm15CatchReturnInst6CreateEPNS_5ValueEPNS_10BasicBlockEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchReturnInst6CreateEPNS_5ValueEPNS_10BasicBlockEPNS_11InstructionE")
  //</editor-fold>
  public static CatchReturnInst /*P*/ Create(Value /*P*/ CatchPad, BasicBlock /*P*/ BB) {
    return Create(CatchPad, BB, 
        (Instruction /*P*/ )null);
  }
  public static CatchReturnInst /*P*/ Create(Value /*P*/ CatchPad, BasicBlock /*P*/ BB, 
        Instruction /*P*/ InsertBefore/*= null*/) {
    assert Native.$bool(CatchPad);
    assert Native.$bool(BB);
    return ((/*JCast*/CatchReturnInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (2)*/ User.$new_FixedUses(2, (type$ptr<?> New$Mem)->{
        return new CatchReturnInst(CatchPad, BB, InsertBefore);
     })));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4227,
   FQN="llvm::CatchReturnInst::Create", NM="_ZN4llvm15CatchReturnInst6CreateEPNS_5ValueEPNS_10BasicBlockES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchReturnInst6CreateEPNS_5ValueEPNS_10BasicBlockES4_")
  //</editor-fold>
  public static CatchReturnInst /*P*/ Create(Value /*P*/ CatchPad, BasicBlock /*P*/ BB, 
        BasicBlock /*P*/ InsertAtEnd) {
    assert Native.$bool(CatchPad);
    assert Native.$bool(BB);
    return ((/*JCast*/CatchReturnInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (2)*/ User.$new_FixedUses(2, (type$ptr<?> New$Mem)->{
        return new CatchReturnInst(CatchPad, BB, InsertAtEnd);
     })));
  }


  /// Provide fast operand accessors
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4275,
   FQN="llvm::CatchReturnInst::getOperand", NM="_ZNK4llvm15CatchReturnInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchReturnInst10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsCatchReturnInst.<CatchReturnInst>operands$FixedNumOperandTraits(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsCatchReturnInst.<CatchReturnInst>op_begin(((/*const_cast*/CatchReturnInst /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4275,
   FQN="llvm::CatchReturnInst::setOperand", NM="_ZN4llvm15CatchReturnInst10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchReturnInst10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsCatchReturnInst.<CatchReturnInst>operands$FixedNumOperandTraits(this))) : "setOperand() out of range!";
    OperandTraitsCatchReturnInst.<CatchReturnInst>op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4275,
   FQN="llvm::CatchReturnInst::op_begin", NM="_ZN4llvm15CatchReturnInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchReturnInst8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsCatchReturnInst.<CatchReturnInst>op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4275,
   FQN="llvm::CatchReturnInst::op_begin", NM="_ZNK4llvm15CatchReturnInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchReturnInst8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsCatchReturnInst.<CatchReturnInst>op_begin(((/*const_cast*/CatchReturnInst /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4275,
   FQN="llvm::CatchReturnInst::op_end", NM="_ZN4llvm15CatchReturnInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchReturnInst6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsCatchReturnInst.<CatchReturnInst>op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4275,
   FQN="llvm::CatchReturnInst::op_end", NM="_ZNK4llvm15CatchReturnInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchReturnInst6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsCatchReturnInst.<CatchReturnInst>op_end(((/*const_cast*/CatchReturnInst /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4275,
   FQN="llvm::CatchReturnInst::Op", NM="Tpl__ZN4llvm15CatchReturnInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm15CatchReturnInst2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this.OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4275,
   FQN="llvm::CatchReturnInst::Op", NM="Tpl__ZNK4llvm15CatchReturnInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm15CatchReturnInst2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this.OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4275,
   FQN="llvm::CatchReturnInst::getNumOperands", NM="_ZNK4llvm15CatchReturnInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchReturnInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsCatchReturnInst.<CatchReturnInst>operands$FixedNumOperandTraits(this);
  }

  
  /// Convenience accessors.
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::getCatchPad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4238,
   FQN="llvm::CatchReturnInst::getCatchPad", NM="_ZNK4llvm15CatchReturnInst11getCatchPadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchReturnInst11getCatchPadEv")
  //</editor-fold>
  public CatchPadInst /*P*/ getCatchPad() /*const*/ {
    return cast_CatchPadInst(this./*<0>*/Op$Const(0));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::setCatchPad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4239,
   FQN="llvm::CatchReturnInst::setCatchPad", NM="_ZN4llvm15CatchReturnInst11setCatchPadEPNS_12CatchPadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchReturnInst11setCatchPadEPNS_12CatchPadInstE")
  //</editor-fold>
  public void setCatchPad(CatchPadInst /*P*/ CatchPad) {
    assert Native.$bool(CatchPad);
    this./*<0>*/Op(0).$assign(CatchPad);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::getSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4244,
   FQN="llvm::CatchReturnInst::getSuccessor", NM="_ZNK4llvm15CatchReturnInst12getSuccessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchReturnInst12getSuccessorEv")
  //</editor-fold>
  public BasicBlock /*P*/ getSuccessor() /*const*/ {
    return cast_BasicBlock(this./*<1>*/Op$Const(1));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::setSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4245,
   FQN="llvm::CatchReturnInst::setSuccessor", NM="_ZN4llvm15CatchReturnInst12setSuccessorEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchReturnInst12setSuccessorEPNS_10BasicBlockE")
  //</editor-fold>
  public void setSuccessor(BasicBlock /*P*/ NewSucc) {
    assert Native.$bool(NewSucc);
    this./*<1>*/Op(1).$assign(NewSucc);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::getNumSuccessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4249,
   FQN="llvm::CatchReturnInst::getNumSuccessors", NM="_ZNK4llvm15CatchReturnInst16getNumSuccessorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchReturnInst16getNumSuccessorsEv")
  //</editor-fold>
  public /*uint*/int getNumSuccessors() /*const*/ {
    return 1;
  }

  
  /// Get the parentPad of this catchret's catchpad's catchswitch.
  /// The successor block is implicitly a member of this funclet.
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::getCatchSwitchParentPad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4253,
   FQN="llvm::CatchReturnInst::getCatchSwitchParentPad", NM="_ZNK4llvm15CatchReturnInst23getCatchSwitchParentPadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchReturnInst23getCatchSwitchParentPadEv")
  //</editor-fold>
  public Value /*P*/ getCatchSwitchParentPad() /*const*/ {
    return getCatchPad().getCatchSwitch().getParentPad();
  }

  
  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4258,
   FQN="llvm::CatchReturnInst::classof", NM="_ZN4llvm15CatchReturnInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchReturnInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return (I.getOpcode() == Instruction.TermOps.CatchRet);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4261,
   FQN="llvm::CatchReturnInst::classof", NM="_ZN4llvm15CatchReturnInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchReturnInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && CatchReturnInst.classof(cast_Instruction(V));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::getSuccessorV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 971,
   FQN="llvm::CatchReturnInst::getSuccessorV", NM="_ZNK4llvm15CatchReturnInst13getSuccessorVEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchReturnInst13getSuccessorVEj")
  //</editor-fold>
  @Override protected/*private*/ BasicBlock /*P*/ getSuccessorV(/*uint*/int Idx) /*const*//* override*/ {
    assert ($less_uint(Idx, getNumSuccessors())) : "Successor # out of range for catchret!";
    return getSuccessor();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::getNumSuccessorsV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 975,
   FQN="llvm::CatchReturnInst::getNumSuccessorsV", NM="_ZNK4llvm15CatchReturnInst17getNumSuccessorsVEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchReturnInst17getNumSuccessorsVEv")
  //</editor-fold>
  @Override protected/*private*/ /*uint*/int getNumSuccessorsV() /*const*//* override*/ {
    return getNumSuccessors();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::setSuccessorV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 978,
   FQN="llvm::CatchReturnInst::setSuccessorV", NM="_ZN4llvm15CatchReturnInst13setSuccessorVEjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchReturnInst13setSuccessorVEjPNS_10BasicBlockE")
  //</editor-fold>
  @Override protected/*private*/ void setSuccessorV(/*uint*/int Idx, BasicBlock /*P*/ B)/* override*/ {
    assert ($less_uint(Idx, getNumSuccessors())) : "Successor # out of range for catchret!";
    setSuccessor(B);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchReturnInst::~CatchReturnInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4208,
   FQN="llvm::CatchReturnInst::~CatchReturnInst", NM="_ZN4llvm15CatchReturnInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchReturnInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
