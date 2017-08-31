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
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
//                               BranchInst Class
//===----------------------------------------------------------------------===//

//===---------------------------------------------------------------------------
/// BranchInst - Conditional or Unconditional Branch instruction.
///
//<editor-fold defaultstate="collapsed" desc="llvm::BranchInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2879,
 FQN="llvm::BranchInst", NM="_ZN4llvm10BranchInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10BranchInstE")
//</editor-fold>
public class BranchInst extends /*public*/ TerminatorInst implements Destructors.ClassWithDestructor {
  /// Ops list - Branches are strange.  The operands are ordered:
  ///  [Cond, FalseDest,] TrueDest.  This makes some accessors faster because
  /// they don't have to check for cond/uncond branchness. These are mostly
  /// accessed relative from op_end().
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::BranchInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1192,
   FQN="llvm::BranchInst::BranchInst", NM="_ZN4llvm10BranchInstC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10BranchInstC1ERKS0_")
  //</editor-fold>
  private BranchInst(final /*const*/ BranchInst /*&*/ BI) {
    // : TerminatorInst(Type::getVoidTy(BI.getContext()), Instruction::Br, OperandTraits<BranchInst>::op_end(this) - BI.getNumOperands(), BI.getNumOperands())
    //START JInit
    super(Type.getVoidTy(BI.getContext()), Instruction.TermOps.Br,
        OperandTraitsBranchInst.<BranchInst>op_end(User.$BEING_CREATED()).$sub(BI.getNumOperands()),
        BI.getNumOperands());
    //END JInit
    this./*<-1>*/Op(-1).$assign(BI./*<-1>*/Op$Const(-1));
    if (BI.getNumOperands() != 1) {
      assert (BI.getNumOperands() == 3) : "BR can have 1 or 3 operands!";
      this./*<-3>*/Op(-3).$assign(BI./*<-3>*/Op$Const(-3));
      this./*<-2>*/Op(-2).$assign(BI./*<-2>*/Op$Const(-2));
    }
    SubclassOptionalData = $uchar2uchar_7bits($7bits_uchar2uchar(BI.SubclassOptionalData));
  }


  //===----------------------------------------------------------------------===//
  //                        BranchInst Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::AssertOK">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1144,
   FQN="llvm::BranchInst::AssertOK", NM="_ZN4llvm10BranchInst8AssertOKEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10BranchInst8AssertOKEv")
  //</editor-fold>
  private void AssertOK() {
    if (isConditional()) {
      assert (getCondition().getType().isIntegerTy(1)) : "May only branch on boolean predicates!";
    }
  }

  // BranchInst constructors (where {B, T, F} are blocks, and C is a condition):
  // BranchInst(BB *B)                           - 'br B'
  // BranchInst(BB* T, BB *F, Value *C)          - 'br C, T, F'
  // BranchInst(BB* B, Inst *I)                  - 'br B'        insert before I
  // BranchInst(BB* T, BB *F, Value *C, Inst *I) - 'br C, T, F', insert before I
  // BranchInst(BB* B, BB *I)                    - 'br B'        insert at end
  // BranchInst(BB* T, BB *F, Value *C, BB *I)   - 'br C, T, F', insert at end
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::BranchInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1150,
   FQN="llvm::BranchInst::BranchInst", NM="_ZN4llvm10BranchInstC1EPNS_10BasicBlockEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10BranchInstC1EPNS_10BasicBlockEPNS_11InstructionE")
  //</editor-fold>
  private BranchInst(BasicBlock /*P*/ IfTrue) {
    this(IfTrue, (Instruction /*P*/ )null);
  }
  private BranchInst(BasicBlock /*P*/ IfTrue, Instruction /*P*/ InsertBefore/*= null*/) {
    // : TerminatorInst(Type::getVoidTy(IfTrue->getContext()), Instruction::Br, OperandTraits<BranchInst>::op_end(this) - 1, 1, InsertBefore)
    //START JInit
    super(Type.getVoidTy(IfTrue.getContext()), Instruction.TermOps.Br,
        OperandTraitsBranchInst.<BranchInst>op_end(User.$BEING_CREATED()).$sub(1),
        1, InsertBefore);
    //END JInit
    assert ((IfTrue != null)) : "Branch destination may not be null!";
    this./*<-1>*/Op(-1).$assign(IfTrue);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::BranchInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1157,
   FQN="llvm::BranchInst::BranchInst", NM="_ZN4llvm10BranchInstC1EPNS_10BasicBlockES2_PNS_5ValueEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10BranchInstC1EPNS_10BasicBlockES2_PNS_5ValueEPNS_11InstructionE")
  //</editor-fold>
  private BranchInst(BasicBlock /*P*/ IfTrue, BasicBlock /*P*/ IfFalse, Value /*P*/ Cond) {
    this(IfTrue, IfFalse, Cond,
      (Instruction /*P*/ )null);
  }
  private BranchInst(BasicBlock /*P*/ IfTrue, BasicBlock /*P*/ IfFalse, Value /*P*/ Cond,
      Instruction /*P*/ InsertBefore/*= null*/) {
    // : TerminatorInst(Type::getVoidTy(IfTrue->getContext()), Instruction::Br, OperandTraits<BranchInst>::op_end(this) - 3, 3, InsertBefore)
    //START JInit
    super(Type.getVoidTy(IfTrue.getContext()), Instruction.TermOps.Br,
        OperandTraitsBranchInst.<BranchInst>op_end(User.$BEING_CREATED()).$sub(3),
        3, InsertBefore);
    //END JInit
    this./*<-1>*/Op(-1).$assign(IfTrue);
    this./*<-2>*/Op(-2).$assign(IfFalse);
    this./*<-3>*/Op(-3).$assign(Cond);
    AssertOK();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::BranchInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1170,
   FQN="llvm::BranchInst::BranchInst", NM="_ZN4llvm10BranchInstC1EPNS_10BasicBlockES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10BranchInstC1EPNS_10BasicBlockES2_")
  //</editor-fold>
  private BranchInst(BasicBlock /*P*/ IfTrue, BasicBlock /*P*/ InsertAtEnd) {
    // : TerminatorInst(Type::getVoidTy(IfTrue->getContext()), Instruction::Br, OperandTraits<BranchInst>::op_end(this) - 1, 1, InsertAtEnd)
    //START JInit
    super(Type.getVoidTy(IfTrue.getContext()), Instruction.TermOps.Br,
        OperandTraitsBranchInst.<BranchInst>op_end(User.$BEING_CREATED()).$sub(1),
        1, InsertAtEnd);
    //END JInit
    assert ((IfTrue != null)) : "Branch destination may not be null!";
    this./*<-1>*/Op(-1).$assign(IfTrue);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::BranchInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1178,
   FQN="llvm::BranchInst::BranchInst", NM="_ZN4llvm10BranchInstC1EPNS_10BasicBlockES2_PNS_5ValueES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10BranchInstC1EPNS_10BasicBlockES2_PNS_5ValueES2_")
  //</editor-fold>
  private BranchInst(BasicBlock /*P*/ IfTrue, BasicBlock /*P*/ IfFalse, Value /*P*/ Cond,
      BasicBlock /*P*/ InsertAtEnd) {
    // : TerminatorInst(Type::getVoidTy(IfTrue->getContext()), Instruction::Br, OperandTraits<BranchInst>::op_end(this) - 3, 3, InsertAtEnd)
    //START JInit
    super(Type.getVoidTy(IfTrue.getContext()), Instruction.TermOps.Br,
        OperandTraitsBranchInst.<BranchInst>op_end(User.$BEING_CREATED()).$sub(3),
        3, InsertAtEnd);
    //END JInit
    this./*<-1>*/Op(-1).$assign(IfTrue);
    this./*<-2>*/Op(-2).$assign(IfFalse);
    this./*<-3>*/Op(-3).$assign(Cond);
    AssertOK();
  }

/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::cloneImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 4045,
   FQN="llvm::BranchInst::cloneImpl", NM="_ZNK4llvm10BranchInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10BranchInst9cloneImplEv")
  //</editor-fold>
  protected BranchInst /*P*/ cloneImpl() /*const*/ {
    return ((/*JCast*/BranchInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (getNumOperands())*/ User.$new_FixedUses(getNumOperands(), (type$ptr<?> New$Mem)->{
        return new BranchInst(/*Deref*/this);
     })));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2906,
   FQN="llvm::BranchInst::Create", NM="_ZN4llvm10BranchInst6CreateEPNS_10BasicBlockEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10BranchInst6CreateEPNS_10BasicBlockEPNS_11InstructionE")
  //</editor-fold>
  public static BranchInst /*P*/ Create(BasicBlock /*P*/ IfTrue) {
    return Create(IfTrue,
        (Instruction /*P*/ )null);
  }
  public static BranchInst /*P*/ Create(BasicBlock /*P*/ IfTrue,
        Instruction /*P*/ InsertBefore/*= null*/) {
    return ((/*JCast*/BranchInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (1)*/ User.$new_FixedUses(1, (type$ptr<?> New$Mem)->{
        return new BranchInst(IfTrue, InsertBefore);
     })));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2910,
   FQN="llvm::BranchInst::Create", NM="_ZN4llvm10BranchInst6CreateEPNS_10BasicBlockES2_PNS_5ValueEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10BranchInst6CreateEPNS_10BasicBlockES2_PNS_5ValueEPNS_11InstructionE")
  //</editor-fold>
  public static BranchInst /*P*/ Create(BasicBlock /*P*/ IfTrue, BasicBlock /*P*/ IfFalse,
        Value /*P*/ Cond) {
    return Create(IfTrue, IfFalse,
        Cond, (Instruction /*P*/ )null);
  }
  public static BranchInst /*P*/ Create(BasicBlock /*P*/ IfTrue, BasicBlock /*P*/ IfFalse,
        Value /*P*/ Cond, Instruction /*P*/ InsertBefore/*= null*/) {
    return ((/*JCast*/BranchInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (3)*/ User.$new_FixedUses(3, (type$ptr<?> New$Mem)->{
        return new BranchInst(IfTrue, IfFalse, Cond, InsertBefore);
     })));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2914,
   FQN="llvm::BranchInst::Create", NM="_ZN4llvm10BranchInst6CreateEPNS_10BasicBlockES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10BranchInst6CreateEPNS_10BasicBlockES2_")
  //</editor-fold>
  public static BranchInst /*P*/ Create(BasicBlock /*P*/ IfTrue, BasicBlock /*P*/ InsertAtEnd) {
    return ((/*JCast*/BranchInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (1)*/ User.$new_FixedUses(1, (type$ptr<?> New$Mem)->{
        return new BranchInst(IfTrue, InsertAtEnd);
     })));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2917,
   FQN="llvm::BranchInst::Create", NM="_ZN4llvm10BranchInst6CreateEPNS_10BasicBlockES2_PNS_5ValueES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10BranchInst6CreateEPNS_10BasicBlockES2_PNS_5ValueES2_")
  //</editor-fold>
  public static BranchInst /*P*/ Create(BasicBlock /*P*/ IfTrue, BasicBlock /*P*/ IfFalse,
        Value /*P*/ Cond, BasicBlock /*P*/ InsertAtEnd) {
    return ((/*JCast*/BranchInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (3)*/ User.$new_FixedUses(3, (type$ptr<?> New$Mem)->{
        return new BranchInst(IfTrue, IfFalse, Cond, InsertAtEnd);
     })));
  }


  /// Transparently provide more efficient getOperand methods.
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2975,
   FQN="llvm::BranchInst::getOperand", NM="_ZNK4llvm10BranchInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10BranchInst10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsBranchInst.<BranchInst>operands(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsBranchInst.<BranchInst>op_begin(((/*const_cast*/BranchInst /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2975,
   FQN="llvm::BranchInst::setOperand", NM="_ZN4llvm10BranchInst10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10BranchInst10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsBranchInst.<BranchInst>operands(this))) : "setOperand() out of range!";
    OperandTraitsBranchInst.<BranchInst>op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2975,
   FQN="llvm::BranchInst::op_begin", NM="_ZN4llvm10BranchInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10BranchInst8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsBranchInst.<BranchInst>op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2975,
   FQN="llvm::BranchInst::op_begin", NM="_ZNK4llvm10BranchInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10BranchInst8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsBranchInst.<BranchInst>op_begin(((/*const_cast*/BranchInst /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2975,
   FQN="llvm::BranchInst::op_end", NM="_ZN4llvm10BranchInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10BranchInst6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsBranchInst.<BranchInst>op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2975,
   FQN="llvm::BranchInst::op_end", NM="_ZNK4llvm10BranchInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10BranchInst6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsBranchInst.<BranchInst>op_end(((/*const_cast*/BranchInst /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2975,
   FQN="llvm::BranchInst::Op", NM="Tpl__ZN4llvm10BranchInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm10BranchInst2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this.OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2975,
   FQN="llvm::BranchInst::Op", NM="Tpl__ZNK4llvm10BranchInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm10BranchInst2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this.OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2975,
   FQN="llvm::BranchInst::getNumOperands", NM="_ZNK4llvm10BranchInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10BranchInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsBranchInst.<BranchInst>operands(this);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::isUnconditional">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2925,
   FQN="llvm::BranchInst::isUnconditional", NM="_ZNK4llvm10BranchInst15isUnconditionalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10BranchInst15isUnconditionalEv")
  //</editor-fold>
  public boolean isUnconditional() /*const*/ {
    return getNumOperands() == 1;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::isConditional">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2926,
   FQN="llvm::BranchInst::isConditional", NM="_ZNK4llvm10BranchInst13isConditionalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10BranchInst13isConditionalEv")
  //</editor-fold>
  public boolean isConditional() /*const*/ {
    return getNumOperands() == 3;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::getCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2928,
   FQN="llvm::BranchInst::getCondition", NM="_ZNK4llvm10BranchInst12getConditionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10BranchInst12getConditionEv")
  //</editor-fold>
  public Value /*P*/ getCondition() /*const*/ {
    assert (isConditional()) : "Cannot get condition of an uncond branch!";
    return this./*<-3>*/Op$Const(-3).$Value$P();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::setCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2933,
   FQN="llvm::BranchInst::setCondition", NM="_ZN4llvm10BranchInst12setConditionEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10BranchInst12setConditionEPNS_5ValueE")
  //</editor-fold>
  public void setCondition(Value /*P*/ V) {
    assert (isConditional()) : "Cannot set condition of unconditional branch!";
    this./*<-3>*/Op(-3).$assign(V);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::getNumSuccessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2938,
   FQN="llvm::BranchInst::getNumSuccessors", NM="_ZNK4llvm10BranchInst16getNumSuccessorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10BranchInst16getNumSuccessorsEv")
  //</editor-fold>
  public /*uint*/int getNumSuccessors() /*const*/ {
    return 1 + (isConditional() ? 1 : 0);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::getSuccessor">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2940,
   FQN="llvm::BranchInst::getSuccessor", NM="_ZNK4llvm10BranchInst12getSuccessorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10BranchInst12getSuccessorEj")
  //</editor-fold>
  public BasicBlock /*P*/ getSuccessor(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, getNumSuccessors())) : "Successor # out of range for Branch!";
    //return cast_or_null_BasicBlock(($AddrOf(this./*<-1>*/Op$Const(-1)).$sub(i)).get());
    return cast_or_null_BasicBlock(OpFrom$Addr(-1, this).$sub(i).$star().get());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::setSuccessor">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2945,
   FQN="llvm::BranchInst::setSuccessor", NM="_ZN4llvm10BranchInst12setSuccessorEjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10BranchInst12setSuccessorEjPNS_10BasicBlockE")
  //</editor-fold>
  public void setSuccessor(/*uint*/int idx, BasicBlock /*P*/ NewSucc) {
    assert ($less_uint(idx, getNumSuccessors())) : "Successor # out of range for Branch!";
    //($AddrOf(this./*<-1>*/Op(-1)).$sub(idx)).$star().$assign(NewSucc);
    OpFrom$Addr(-1, this).$sub(idx).$star().$assign(NewSucc);
  }


  /// \brief Swap the successors of this branch instruction.
  ///
  /// Swaps the successors of the branch instruction. This also swaps any
  /// branch weight metadata associated with the instruction so that it
  /// continues to map correctly to each operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::swapSuccessors">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1205,
   FQN="llvm::BranchInst::swapSuccessors", NM="_ZN4llvm10BranchInst14swapSuccessorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10BranchInst14swapSuccessorsEv")
  //</editor-fold>
  public void swapSuccessors() {
    assert (isConditional()) : "Cannot swap successors of an unconditional branch";
    this./*<-1>*/Op(-1).swap(this./*<-2>*/Op(-2));

    // Update profile metadata if present and it matches our structural
    // expectations.
    MDNode /*P*/ ProfileData = getMetadata(LLVMContext.Unnamed_enum.MD_prof.getValue());
    if (!(ProfileData != null) || ProfileData.getNumOperands() != 3) {
      return;
    }

    // The first operand is the name. Fetch them backwards and build a new one.
    Metadata /*P*/ Ops[/*3*/] = new Metadata /*P*/  [/*3*/] {
      ProfileData.getOperand(0).$Metadata$P(),
      ProfileData.getOperand(2).$Metadata$P(),
      ProfileData.getOperand(1).$Metadata$P()};
    setMetadata(LLVMContext.Unnamed_enum.MD_prof.getValue(),
        MDNode.get(ProfileData.getContext(), new ArrayRef<Metadata /*P*/ >(Ops, 3, true)));
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2958,
   FQN="llvm::BranchInst::classof", NM="_ZN4llvm10BranchInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10BranchInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return (I.getOpcode() == Instruction.TermOps.Br);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2961,
   FQN="llvm::BranchInst::classof", NM="_ZN4llvm10BranchInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10BranchInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && BranchInst.classof(cast_Instruction(V));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::getSuccessorV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1223,
   FQN="llvm::BranchInst::getSuccessorV", NM="_ZNK4llvm10BranchInst13getSuccessorVEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10BranchInst13getSuccessorVEj")
  //</editor-fold>
  @Override protected/*private*/ BasicBlock /*P*/ getSuccessorV(/*uint*/int idx) /*const*//* override*/ {
    return getSuccessor(idx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::getNumSuccessorsV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1226,
   FQN="llvm::BranchInst::getNumSuccessorsV", NM="_ZNK4llvm10BranchInst17getNumSuccessorsVEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10BranchInst17getNumSuccessorsVEv")
  //</editor-fold>
  @Override protected/*private*/ /*uint*/int getNumSuccessorsV() /*const*//* override*/ {
    return getNumSuccessors();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::setSuccessorV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1229,
   FQN="llvm::BranchInst::setSuccessorV", NM="_ZN4llvm10BranchInst13setSuccessorVEjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10BranchInst13setSuccessorVEjPNS_10BasicBlockE")
  //</editor-fold>
  @Override protected/*private*/ void setSuccessorV(/*uint*/int idx, BasicBlock /*P*/ B)/* override*/ {
    setSuccessor(idx, B);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchInst::~BranchInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2879,
   FQN="llvm::BranchInst::~BranchInst", NM="_ZN4llvm10BranchInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10BranchInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
