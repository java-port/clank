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
//                               CleanupReturnInst Class
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4281,
 FQN="llvm::CleanupReturnInst", NM="_ZN4llvm17CleanupReturnInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17CleanupReturnInstE")
//</editor-fold>
public class CleanupReturnInst extends /*public*/ TerminatorInst implements Destructors.ClassWithDestructor {
/*private:*/

  //===----------------------------------------------------------------------===//
  //                        CleanupReturnInst Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::CleanupReturnInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 890,
   FQN="llvm::CleanupReturnInst::CleanupReturnInst", NM="_ZN4llvm17CleanupReturnInstC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17CleanupReturnInstC1ERKS0_")
  //</editor-fold>
  private CleanupReturnInst(final /*const*/ CleanupReturnInst /*&*/ CRI) {
    // : TerminatorInst(CRI.getType(), Instruction::CleanupRet, OperandTraits<CleanupReturnInst>::op_end(this) - CRI.getNumOperands(), CRI.getNumOperands())
    //START JInit
    super(CRI.getType(), Instruction.TermOps.CleanupRet,
        OperandTraitsCleanupReturnInst.<CleanupReturnInst>op_end(User.$BEING_CREATED()).$sub(CRI.getNumOperands()),
        CRI.getNumOperands());
    //END JInit
    setInstructionSubclassData_CleanupReturnInst($uint2ushort(CRI.getSubclassDataFromInstruction()));
    this./*<0>*/Op(0).$assign(CRI./*<0>*/Op$Const(0));
    if (CRI.hasUnwindDest()) {
      this./*<1>*/Op(1).$assign(CRI./*<1>*/Op$Const(1));
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 901,
   FQN="llvm::CleanupReturnInst::init", NM="_ZN4llvm17CleanupReturnInst4initEPNS_5ValueEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17CleanupReturnInst4initEPNS_5ValueEPNS_10BasicBlockE")
  //</editor-fold>
  private void init(Value /*P*/ CleanupPad, BasicBlock /*P*/ UnwindBB) {
    if ((UnwindBB != null)) {
      setInstructionSubclassData_CleanupReturnInst($uint2ushort(getSubclassDataFromInstruction() | 1));
    }

    this./*<0>*/Op(0).$assign(CleanupPad);
    if ((UnwindBB != null)) {
      this./*<1>*/Op(1).$assign(UnwindBB);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::CleanupReturnInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 910,
   FQN="llvm::CleanupReturnInst::CleanupReturnInst", NM="_ZN4llvm17CleanupReturnInstC1EPNS_5ValueEPNS_10BasicBlockEjPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17CleanupReturnInstC1EPNS_5ValueEPNS_10BasicBlockEjPNS_11InstructionE")
  //</editor-fold>
  private CleanupReturnInst(Value /*P*/ CleanupPad, BasicBlock /*P*/ UnwindBB,
      /*uint*/int Values) {
    this(CleanupPad, UnwindBB,
      Values, (Instruction /*P*/ )null);
  }
  private CleanupReturnInst(Value /*P*/ CleanupPad, BasicBlock /*P*/ UnwindBB,
      /*uint*/int Values, Instruction /*P*/ InsertBefore/*= null*/) {
    // : TerminatorInst(Type::getVoidTy(CleanupPad->getContext()), Instruction::CleanupRet, OperandTraits<CleanupReturnInst>::op_end(this) - Values, Values, InsertBefore)
    //START JInit
    super(Type.getVoidTy(CleanupPad.getContext()),
        Instruction.TermOps.CleanupRet,
        OperandTraitsCleanupReturnInst.<CleanupReturnInst>op_end(User.$BEING_CREATED()).$sub(Values),
        Values, InsertBefore);
    //END JInit
    init(CleanupPad, UnwindBB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::CleanupReturnInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 919,
   FQN="llvm::CleanupReturnInst::CleanupReturnInst", NM="_ZN4llvm17CleanupReturnInstC1EPNS_5ValueEPNS_10BasicBlockEjS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17CleanupReturnInstC1EPNS_5ValueEPNS_10BasicBlockEjS4_")
  //</editor-fold>
  private CleanupReturnInst(Value /*P*/ CleanupPad, BasicBlock /*P*/ UnwindBB,
      /*uint*/int Values, BasicBlock /*P*/ InsertAtEnd) {
    // : TerminatorInst(Type::getVoidTy(CleanupPad->getContext()), Instruction::CleanupRet, OperandTraits<CleanupReturnInst>::op_end(this) - Values, Values, InsertAtEnd)
    //START JInit
    super(Type.getVoidTy(CleanupPad.getContext()),
        Instruction.TermOps.CleanupRet,
        OperandTraitsCleanupReturnInst.<CleanupReturnInst>op_end(User.$BEING_CREATED()).$sub(Values),
        Values, InsertAtEnd);
    //END JInit
    init(CleanupPad, UnwindBB);
  }

/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::cloneImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 4065,
   FQN="llvm::CleanupReturnInst::cloneImpl", NM="_ZNK4llvm17CleanupReturnInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17CleanupReturnInst9cloneImplEv")
  //</editor-fold>
  protected CleanupReturnInst /*P*/ cloneImpl() /*const*/ {
    return ((/*JCast*/CleanupReturnInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (getNumOperands())*/ User.$new_FixedUses(getNumOperands(), (type$ptr<?> New$Mem)->{
        return new CleanupReturnInst(/*Deref*/this);
     })));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4297,
   FQN="llvm::CleanupReturnInst::Create", NM="_ZN4llvm17CleanupReturnInst6CreateEPNS_5ValueEPNS_10BasicBlockEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17CleanupReturnInst6CreateEPNS_5ValueEPNS_10BasicBlockEPNS_11InstructionE")
  //</editor-fold>
  public static CleanupReturnInst /*P*/ Create(Value /*P*/ CleanupPad) {
    return Create(CleanupPad,
        (BasicBlock /*P*/ )null,
        (Instruction /*P*/ )null);
  }
  public static CleanupReturnInst /*P*/ Create(Value /*P*/ CleanupPad,
        BasicBlock /*P*/ UnwindBB/*= null*/) {
    return Create(CleanupPad,
        UnwindBB,
        (Instruction /*P*/ )null);
  }
  public static CleanupReturnInst /*P*/ Create(Value /*P*/ CleanupPad,
        BasicBlock /*P*/ UnwindBB/*= null*/,
        Instruction /*P*/ InsertBefore/*= null*/) {
    assert Native.$bool(CleanupPad);
    /*uint*/int Values = 1;
    if ((UnwindBB != null)) {
      ++Values;
    }
    final int $Values = Values;
    return ((/*JCast*/CleanupReturnInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (Values)*/ User.$new_FixedUses($Values, (type$ptr<?> New$Mem)->{
        return new CleanupReturnInst(CleanupPad, UnwindBB, $Values, InsertBefore);
     })));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4307,
   FQN="llvm::CleanupReturnInst::Create", NM="_ZN4llvm17CleanupReturnInst6CreateEPNS_5ValueEPNS_10BasicBlockES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17CleanupReturnInst6CreateEPNS_5ValueEPNS_10BasicBlockES4_")
  //</editor-fold>
  public static CleanupReturnInst /*P*/ Create(Value /*P*/ CleanupPad, BasicBlock /*P*/ UnwindBB,
        BasicBlock /*P*/ InsertAtEnd) {
    assert Native.$bool(CleanupPad);
    /*uint*/int Values = 1;
    if ((UnwindBB != null)) {
      ++Values;
    }
    final int $Values = Values;
    return ((/*JCast*/CleanupReturnInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (Values)*/ User.$new_FixedUses($Values, (type$ptr<?> New$Mem)->{
        return new CleanupReturnInst(CleanupPad, UnwindBB, $Values, InsertAtEnd);
     })));
  }


  /// Provide fast operand accessors
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4367,
   FQN="llvm::CleanupReturnInst::getOperand", NM="_ZNK4llvm17CleanupReturnInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17CleanupReturnInst10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsCleanupReturnInst.<CleanupReturnInst>operands(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsCleanupReturnInst.<CleanupReturnInst>op_begin(((/*const_cast*/CleanupReturnInst /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4367,
   FQN="llvm::CleanupReturnInst::setOperand", NM="_ZN4llvm17CleanupReturnInst10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17CleanupReturnInst10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsCleanupReturnInst.<CleanupReturnInst>operands(this))) : "setOperand() out of range!";
    OperandTraitsCleanupReturnInst.<CleanupReturnInst>op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4367,
   FQN="llvm::CleanupReturnInst::op_begin", NM="_ZN4llvm17CleanupReturnInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17CleanupReturnInst8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsCleanupReturnInst.<CleanupReturnInst>op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4367,
   FQN="llvm::CleanupReturnInst::op_begin", NM="_ZNK4llvm17CleanupReturnInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17CleanupReturnInst8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsCleanupReturnInst.<CleanupReturnInst>op_begin(((/*const_cast*/CleanupReturnInst /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4367,
   FQN="llvm::CleanupReturnInst::op_end", NM="_ZN4llvm17CleanupReturnInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17CleanupReturnInst6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsCleanupReturnInst.<CleanupReturnInst>op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4367,
   FQN="llvm::CleanupReturnInst::op_end", NM="_ZNK4llvm17CleanupReturnInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17CleanupReturnInst6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsCleanupReturnInst.<CleanupReturnInst>op_end(((/*const_cast*/CleanupReturnInst /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4367,
   FQN="llvm::CleanupReturnInst::Op", NM="Tpl__ZN4llvm17CleanupReturnInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm17CleanupReturnInst2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this.OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4367,
   FQN="llvm::CleanupReturnInst::Op", NM="Tpl__ZNK4llvm17CleanupReturnInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm17CleanupReturnInst2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this.OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4367,
   FQN="llvm::CleanupReturnInst::getNumOperands", NM="_ZNK4llvm17CleanupReturnInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17CleanupReturnInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsCleanupReturnInst.<CleanupReturnInst>operands(this);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::hasUnwindDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4320,
   FQN="llvm::CleanupReturnInst::hasUnwindDest", NM="_ZNK4llvm17CleanupReturnInst13hasUnwindDestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17CleanupReturnInst13hasUnwindDestEv")
  //</editor-fold>
  public boolean hasUnwindDest() /*const*/ {
    return ((getSubclassDataFromInstruction() & 1) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::unwindsToCaller">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4321,
   FQN="llvm::CleanupReturnInst::unwindsToCaller", NM="_ZNK4llvm17CleanupReturnInst15unwindsToCallerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17CleanupReturnInst15unwindsToCallerEv")
  //</editor-fold>
  public boolean unwindsToCaller() /*const*/ {
    return !hasUnwindDest();
  }


  /// Convenience accessor.
  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::getCleanupPad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4324,
   FQN="llvm::CleanupReturnInst::getCleanupPad", NM="_ZNK4llvm17CleanupReturnInst13getCleanupPadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17CleanupReturnInst13getCleanupPadEv")
  //</editor-fold>
  public CleanupPadInst /*P*/ getCleanupPad() /*const*/ {
    return cast_CleanupPadInst(this./*<0>*/Op$Const(0));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::setCleanupPad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4327,
   FQN="llvm::CleanupReturnInst::setCleanupPad", NM="_ZN4llvm17CleanupReturnInst13setCleanupPadEPNS_14CleanupPadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17CleanupReturnInst13setCleanupPadEPNS_14CleanupPadInstE")
  //</editor-fold>
  public void setCleanupPad(CleanupPadInst /*P*/ CleanupPad) {
    assert Native.$bool(CleanupPad);
    this./*<0>*/Op(0).$assign(CleanupPad);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::getNumSuccessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4332,
   FQN="llvm::CleanupReturnInst::getNumSuccessors", NM="_ZNK4llvm17CleanupReturnInst16getNumSuccessorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17CleanupReturnInst16getNumSuccessorsEv")
  //</editor-fold>
  public /*uint*/int getNumSuccessors() /*const*/ {
    return hasUnwindDest() ? 1 : 0;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::getUnwindDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4334,
   FQN="llvm::CleanupReturnInst::getUnwindDest", NM="_ZNK4llvm17CleanupReturnInst13getUnwindDestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17CleanupReturnInst13getUnwindDestEv")
  //</editor-fold>
  public BasicBlock /*P*/ getUnwindDest() /*const*/ {
    return hasUnwindDest() ? cast_BasicBlock(this./*<1>*/Op$Const(1)) : null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::setUnwindDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4337,
   FQN="llvm::CleanupReturnInst::setUnwindDest", NM="_ZN4llvm17CleanupReturnInst13setUnwindDestEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17CleanupReturnInst13setUnwindDestEPNS_10BasicBlockE")
  //</editor-fold>
  public void setUnwindDest(BasicBlock /*P*/ NewDest) {
    assert Native.$bool(NewDest);
    assert (hasUnwindDest());
    this./*<1>*/Op(1).$assign(NewDest);
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4344,
   FQN="llvm::CleanupReturnInst::classof", NM="_ZN4llvm17CleanupReturnInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17CleanupReturnInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return (I.getOpcode() == Instruction.TermOps.CleanupRet);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4347,
   FQN="llvm::CleanupReturnInst::classof", NM="_ZN4llvm17CleanupReturnInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17CleanupReturnInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && CleanupReturnInst.classof(cast_Instruction(V));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::getSuccessorV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 928,
   FQN="llvm::CleanupReturnInst::getSuccessorV", NM="_ZNK4llvm17CleanupReturnInst13getSuccessorVEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17CleanupReturnInst13getSuccessorVEj")
  //</editor-fold>
  @Override protected/*private*/ BasicBlock /*P*/ getSuccessorV(/*uint*/int Idx) /*const*//* override*/ {
    assert (Idx == 0);
    return getUnwindDest();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::getNumSuccessorsV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 932,
   FQN="llvm::CleanupReturnInst::getNumSuccessorsV", NM="_ZNK4llvm17CleanupReturnInst17getNumSuccessorsVEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17CleanupReturnInst17getNumSuccessorsVEv")
  //</editor-fold>
  @Override protected/*private*/ /*uint*/int getNumSuccessorsV() /*const*//* override*/ {
    return getNumSuccessors();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::setSuccessorV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 935,
   FQN="llvm::CleanupReturnInst::setSuccessorV", NM="_ZN4llvm17CleanupReturnInst13setSuccessorVEjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17CleanupReturnInst13setSuccessorVEjPNS_10BasicBlockE")
  //</editor-fold>
  @Override protected/*private*/ void setSuccessorV(/*uint*/int Idx, BasicBlock /*P*/ B)/* override*/ {
    assert (Idx == 0);
    setUnwindDest(B);
  }


  // Shadow Instruction::setInstructionSubclassData with a private forwarding
  // method so that subclasses cannot accidentally use it.
  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::setInstructionSubclassData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4358,
   FQN="llvm::CleanupReturnInst::setInstructionSubclassData", NM="_ZN4llvm17CleanupReturnInst26setInstructionSubclassDataEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17CleanupReturnInst26setInstructionSubclassDataEt")
  //</editor-fold>
  private void setInstructionSubclassData_CleanupReturnInst(/*ushort*/char D) {
    super.setInstructionSubclassData(D);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupReturnInst::~CleanupReturnInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4281,
   FQN="llvm::CleanupReturnInst::~CleanupReturnInst", NM="_ZN4llvm17CleanupReturnInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17CleanupReturnInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
