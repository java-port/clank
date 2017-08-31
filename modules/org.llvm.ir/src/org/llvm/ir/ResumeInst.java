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
import org.llvm.support.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
//                              ResumeInst Class
//===----------------------------------------------------------------------===//

//===---------------------------------------------------------------------------
/// ResumeInst - Resume the propagation of an exception.
///
//<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3893,
 FQN="llvm::ResumeInst", NM="_ZN4llvm10ResumeInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ResumeInstE")
//</editor-fold>
public class ResumeInst extends /*public*/ TerminatorInst implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  //                        ResumeInst Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::ResumeInst">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 856,
   FQN="llvm::ResumeInst::ResumeInst", NM="_ZN4llvm10ResumeInstC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ResumeInstC1ERKS0_")
  //</editor-fold>
  private ResumeInst(final /*const*/ ResumeInst /*&*/ RI) {
    // : TerminatorInst(Type::getVoidTy(RI.getContext()), Instruction::Resume, OperandTraits<ResumeInst>::op_begin(this), 1) 
    //START JInit
    super(Type.getVoidTy(RI.getContext()), Instruction.TermOps.Resume, 
        OperandTraitsResumeInst.op_begin(User.$BEING_CREATED()/*this*/), 1);
    //END JInit
    this./*<0>*/Op(0).$assign(RI./*<0>*/Op$Const(0));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::ResumeInst">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 862,
   FQN="llvm::ResumeInst::ResumeInst", NM="_ZN4llvm10ResumeInstC1EPNS_5ValueEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ResumeInstC1EPNS_5ValueEPNS_11InstructionE")
  //</editor-fold>
  private ResumeInst(Value /*P*/ Exn) {
    this(Exn, (Instruction /*P*/ )null);
  }
  private ResumeInst(Value /*P*/ Exn, Instruction /*P*/ InsertBefore/*= null*/) {
    // : TerminatorInst(Type::getVoidTy(Exn->getContext()), Instruction::Resume, OperandTraits<ResumeInst>::op_begin(this), 1, InsertBefore) 
    //START JInit
    super(Type.getVoidTy(Exn.getContext()), Instruction.TermOps.Resume, 
        OperandTraitsResumeInst.op_begin(User.$BEING_CREATED()/*this*/), 1, InsertBefore);
    //END JInit
    this./*<0>*/Op(0).$assign(Exn);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::ResumeInst">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 868,
   FQN="llvm::ResumeInst::ResumeInst", NM="_ZN4llvm10ResumeInstC1EPNS_5ValueEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ResumeInstC1EPNS_5ValueEPNS_10BasicBlockE")
  //</editor-fold>
  private ResumeInst(Value /*P*/ Exn, BasicBlock /*P*/ InsertAtEnd) {
    // : TerminatorInst(Type::getVoidTy(Exn->getContext()), Instruction::Resume, OperandTraits<ResumeInst>::op_begin(this), 1, InsertAtEnd) 
    //START JInit
    super(Type.getVoidTy(Exn.getContext()), Instruction.TermOps.Resume, 
        OperandTraitsResumeInst.op_begin(User.$BEING_CREATED()/*this*/), 1, InsertAtEnd);
    //END JInit
    this./*<0>*/Op(0).$assign(Exn);
  }

/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::cloneImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 4063,
   FQN="llvm::ResumeInst::cloneImpl", NM="_ZNK4llvm10ResumeInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10ResumeInst9cloneImplEv")
  //</editor-fold>
  protected ResumeInst /*P*/ cloneImpl() /*const*/ {
    return ((/*JCast*/ResumeInst /*P*/ )(/*NEW_EXPR [User::new]*//*1 = *//*new (1)*/ User.$new_FixedUses(1, (type$ptr<?> New$Mem)->{
        return new ResumeInst(/*Deref*/this);
     })));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3905,
   FQN="llvm::ResumeInst::Create", NM="_ZN4llvm10ResumeInst6CreateEPNS_5ValueEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ResumeInst6CreateEPNS_5ValueEPNS_11InstructionE")
  //</editor-fold>
  public static ResumeInst /*P*/ Create(Value /*P*/ Exn) {
    return Create(Exn, (Instruction /*P*/ )null);
  }
  public static ResumeInst /*P*/ Create(Value /*P*/ Exn, Instruction /*P*/ InsertBefore/*= null*/) {
    return ((/*JCast*/ResumeInst /*P*/ )(/*NEW_EXPR [User::new]*//*1 = *//*new (1)*/ User.$new_FixedUses(1, (type$ptr<?> New$Mem)->{
        return new ResumeInst(Exn, InsertBefore);
     })));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3908,
   FQN="llvm::ResumeInst::Create", NM="_ZN4llvm10ResumeInst6CreateEPNS_5ValueEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ResumeInst6CreateEPNS_5ValueEPNS_10BasicBlockE")
  //</editor-fold>
  public static ResumeInst /*P*/ Create(Value /*P*/ Exn, BasicBlock /*P*/ InsertAtEnd) {
    return ((/*JCast*/ResumeInst /*P*/ )(/*NEW_EXPR [User::new]*//*1 = *//*new (1)*/ User.$new_FixedUses(1, (type$ptr<?> New$Mem)->{
        return new ResumeInst(Exn, InsertAtEnd);
     })));
  }


  /// Provide fast operand accessors
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3939,
   FQN="llvm::ResumeInst::getOperand", NM="_ZNK4llvm10ResumeInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10ResumeInst10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsResumeInst.operands$FixedNumOperandTraits(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsResumeInst.op_begin(((/*const_cast*/ResumeInst /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3939,
   FQN="llvm::ResumeInst::setOperand", NM="_ZN4llvm10ResumeInst10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ResumeInst10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsResumeInst.operands$FixedNumOperandTraits(this))) : "setOperand() out of range!";
    OperandTraitsResumeInst.op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3939,
   FQN="llvm::ResumeInst::op_begin", NM="_ZN4llvm10ResumeInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ResumeInst8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsResumeInst.op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3939,
   FQN="llvm::ResumeInst::op_begin", NM="_ZNK4llvm10ResumeInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10ResumeInst8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsResumeInst.op_begin(((/*const_cast*/ResumeInst /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3939,
   FQN="llvm::ResumeInst::op_end", NM="_ZN4llvm10ResumeInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ResumeInst6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsResumeInst.op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3939,
   FQN="llvm::ResumeInst::op_end", NM="_ZNK4llvm10ResumeInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10ResumeInst6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsResumeInst.op_end(((/*const_cast*/ResumeInst /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::Op">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3939,
   FQN="llvm::ResumeInst::Op", NM="Tpl__ZN4llvm10ResumeInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm10ResumeInst2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::Op">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3939,
   FQN="llvm::ResumeInst::Op", NM="Tpl__ZNK4llvm10ResumeInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm10ResumeInst2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3939,
   FQN="llvm::ResumeInst::getNumOperands", NM="_ZNK4llvm10ResumeInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10ResumeInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsResumeInst.operands$FixedNumOperandTraits(this);
  }

  
  /// Convenience accessor.
  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3916,
   FQN="llvm::ResumeInst::getValue", NM="_ZNK4llvm10ResumeInst8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10ResumeInst8getValueEv")
  //</editor-fold>
  public Value /*P*/ getValue() /*const*/ {
    return this./*<0>*/Op$Const(0).$Value$P();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::getNumSuccessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3918,
   FQN="llvm::ResumeInst::getNumSuccessors", NM="_ZNK4llvm10ResumeInst16getNumSuccessorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10ResumeInst16getNumSuccessorsEv")
  //</editor-fold>
  public /*uint*/int getNumSuccessors() /*const*/ {
    return 0;
  }

  
  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3921,
   FQN="llvm::ResumeInst::classof", NM="_ZN4llvm10ResumeInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ResumeInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.TermOps.Resume;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3924,
   FQN="llvm::ResumeInst::classof", NM="_ZN4llvm10ResumeInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ResumeInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && ResumeInst.classof(cast_Instruction(V));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::getSuccessorV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 882,
   FQN="llvm::ResumeInst::getSuccessorV", NM="_ZNK4llvm10ResumeInst13getSuccessorVEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10ResumeInst13getSuccessorVEj")
  //</editor-fold>
  @Override protected/*private*/ BasicBlock /*P*/ getSuccessorV(/*uint*/int idx) /*const*//* override*/ {
    throw new llvm_unreachable("ResumeInst has no successors!");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::getNumSuccessorsV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 874,
   FQN="llvm::ResumeInst::getNumSuccessorsV", NM="_ZNK4llvm10ResumeInst17getNumSuccessorsVEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10ResumeInst17getNumSuccessorsVEv")
  //</editor-fold>
  @Override protected/*private*/ /*uint*/int getNumSuccessorsV() /*const*//* override*/ {
    return getNumSuccessors();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::setSuccessorV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 878,
   FQN="llvm::ResumeInst::setSuccessorV", NM="_ZN4llvm10ResumeInst13setSuccessorVEjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ResumeInst13setSuccessorVEjPNS_10BasicBlockE")
  //</editor-fold>
  @Override protected/*private*/ void setSuccessorV(/*uint*/int idx, BasicBlock /*P*/ NewSucc)/* override*/ {
    throw new llvm_unreachable("ResumeInst has no successors!");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ResumeInst::~ResumeInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3893,
   FQN="llvm::ResumeInst::~ResumeInst", NM="_ZN4llvm10ResumeInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ResumeInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
