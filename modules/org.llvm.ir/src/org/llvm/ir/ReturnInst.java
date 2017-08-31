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
//                               ReturnInst Class
//===----------------------------------------------------------------------===//

//===---------------------------------------------------------------------------
/// ReturnInst - Return a value (possibly void), from a function.  Execution
/// does not continue in this function any longer.
///
//<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2803,
 FQN="llvm::ReturnInst", NM="_ZN4llvm10ReturnInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ReturnInstE")
//</editor-fold>
public class ReturnInst extends /*public*/ TerminatorInst implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  //                        ReturnInst Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::ReturnInst">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 806,
   FQN="llvm::ReturnInst::ReturnInst", NM="_ZN4llvm10ReturnInstC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ReturnInstC1ERKS0_")
  //</editor-fold>
  private ReturnInst(final /*const*/ ReturnInst /*&*/ RI) {
    // : TerminatorInst(Type::getVoidTy(RI.getContext()), Instruction::Ret, OperandTraits<ReturnInst>::op_end(this) - RI.getNumOperands(), RI.getNumOperands()) 
    //START JInit
    super(Type.getVoidTy(RI.getContext()), Instruction.TermOps.Ret, 
        OperandTraitsReturnInst.op_end(User.$BEING_CREATED()/*this*/).$sub(RI.getNumOperands()), 
        RI.getNumOperands());
    //END JInit
    if ((RI.getNumOperands() != 0)) {
      this./*<0>*/Op(0).$assign(RI./*<0>*/Op$Const(0));
    }
    SubclassOptionalData = $uchar2uchar_7bits($7bits_uchar2uchar(RI.SubclassOptionalData));
  }

/*private:*/
  // ReturnInst constructors:
  // ReturnInst()                  - 'ret void' instruction
  // ReturnInst(    null)          - 'ret void' instruction
  // ReturnInst(Value* X)          - 'ret X'    instruction
  // ReturnInst(    null, Inst *I) - 'ret void' instruction, insert before I
  // ReturnInst(Value* X, Inst *I) - 'ret X'    instruction, insert before I
  // ReturnInst(    null, BB *B)   - 'ret void' instruction, insert @ end of B
  // ReturnInst(Value* X, BB *B)   - 'ret X'    instruction, insert @ end of B
  //
  // NOTE: If the Value* passed is of type void then the constructor behaves as
  // if it was passed NULL.
  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::ReturnInst">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 816,
   FQN="llvm::ReturnInst::ReturnInst", NM="_ZN4llvm10ReturnInstC1ERNS_11LLVMContextEPNS_5ValueEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ReturnInstC1ERNS_11LLVMContextEPNS_5ValueEPNS_11InstructionE")
  //</editor-fold>
  private ReturnInst(final LLVMContext /*&*/ C) {
    this(C, (Value /*P*/ )null, (Instruction /*P*/ )null);
  }
  private ReturnInst(final LLVMContext /*&*/ C, Value /*P*/ retVal/*= null*/) {
    this(C, retVal, (Instruction /*P*/ )null);
  }
  private ReturnInst(final LLVMContext /*&*/ C, Value /*P*/ retVal/*= null*/, Instruction /*P*/ InsertBefore/*= null*/) {
    // : TerminatorInst(Type::getVoidTy(C), Instruction::Ret, OperandTraits<ReturnInst>::op_end(this) - !!retVal, !!retVal, InsertBefore) 
    //START JInit
    super(Type.getVoidTy(C), Instruction.TermOps.Ret, 
        OperandTraitsReturnInst.op_end(User.$BEING_CREATED()/*this*/).$sub(((!!(retVal != null)) ? 1 : 0)), ((!!(retVal != null)) ? 1 : 0), 
        InsertBefore);
    //END JInit
    if ((retVal != null)) {
      this./*<0>*/Op(0).$assign(retVal);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::ReturnInst">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 823,
   FQN="llvm::ReturnInst::ReturnInst", NM="_ZN4llvm10ReturnInstC1ERNS_11LLVMContextEPNS_5ValueEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ReturnInstC1ERNS_11LLVMContextEPNS_5ValueEPNS_10BasicBlockE")
  //</editor-fold>
  private ReturnInst(final LLVMContext /*&*/ C, Value /*P*/ retVal, BasicBlock /*P*/ InsertAtEnd) {
    // : TerminatorInst(Type::getVoidTy(C), Instruction::Ret, OperandTraits<ReturnInst>::op_end(this) - !!retVal, !!retVal, InsertAtEnd) 
    //START JInit
    super(Type.getVoidTy(C), Instruction.TermOps.Ret, 
        OperandTraitsReturnInst.op_end(User.$BEING_CREATED()/*this*/).$sub(((!!(retVal != null)) ? 1 : 0)), ((!!(retVal != null)) ? 1 : 0), 
        InsertAtEnd);
    //END JInit
    if ((retVal != null)) {
      this./*<0>*/Op(0).$assign(retVal);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::ReturnInst">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 830,
   FQN="llvm::ReturnInst::ReturnInst", NM="_ZN4llvm10ReturnInstC1ERNS_11LLVMContextEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ReturnInstC1ERNS_11LLVMContextEPNS_10BasicBlockE")
  //</editor-fold>
  private ReturnInst(final LLVMContext /*&*/ Context, BasicBlock /*P*/ InsertAtEnd) {
    // : TerminatorInst(Type::getVoidTy(Context), Instruction::Ret, OperandTraits<ReturnInst>::op_end(this), 0, InsertAtEnd) 
    //START JInit
    super(Type.getVoidTy(Context), Instruction.TermOps.Ret, 
        OperandTraitsReturnInst.op_end(User.$BEING_CREATED()/*this*/), 0, InsertAtEnd);
    //END JInit
  }

/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::cloneImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 4041,
   FQN="llvm::ReturnInst::cloneImpl", NM="_ZNK4llvm10ReturnInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10ReturnInst9cloneImplEv")
  //</editor-fold>
  protected ReturnInst /*P*/ cloneImpl() /*const*/ {
    return ((/*JCast*/ReturnInst /*P*/ )(/*NEW_EXPR [User::new]*//*getNumOperands() = *//*new (getNumOperands())*/ User.$new_FixedUses(getNumOperands(), (type$ptr<?> New$Mem)->{
        return new ReturnInst(/*Deref*/this);
     })));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2829,
   FQN="llvm::ReturnInst::Create", NM="_ZN4llvm10ReturnInst6CreateERNS_11LLVMContextEPNS_5ValueEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ReturnInst6CreateERNS_11LLVMContextEPNS_5ValueEPNS_11InstructionE")
  //</editor-fold>
  public static ReturnInst /*P*/ Create(final LLVMContext /*&*/ C) {
    return Create(C, (Value /*P*/ )null, 
        (Instruction /*P*/ )null);
  }
  public static ReturnInst /*P*/ Create(final LLVMContext /*&*/ C, Value /*P*/ retVal/*= null*/) {
    return Create(C, retVal, 
        (Instruction /*P*/ )null);
  }
  public static ReturnInst /*P*/ Create(final LLVMContext /*&*/ C, Value /*P*/ retVal/*= null*/, 
        Instruction /*P*/ InsertBefore/*= null*/) {
    return ((/*JCast*/ReturnInst /*P*/ )(/*NEW_EXPR [User::new]*//*((!!(retVal != null)) ? 1 : 0) = *//*new (!!retVal)*/ User.$new_FixedUses(((!!(retVal != null)) ? 1 : 0), (type$ptr<?> New$Mem)->{
        return new ReturnInst(C, retVal, InsertBefore);
     })));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2833,
   FQN="llvm::ReturnInst::Create", NM="_ZN4llvm10ReturnInst6CreateERNS_11LLVMContextEPNS_5ValueEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ReturnInst6CreateERNS_11LLVMContextEPNS_5ValueEPNS_10BasicBlockE")
  //</editor-fold>
  public static ReturnInst /*P*/ Create(final LLVMContext /*&*/ C, Value /*P*/ retVal, 
        BasicBlock /*P*/ InsertAtEnd) {
    return ((/*JCast*/ReturnInst /*P*/ )(/*NEW_EXPR [User::new]*//*((!!(retVal != null)) ? 1 : 0) = *//*new (!!retVal)*/ User.$new_FixedUses(((!!(retVal != null)) ? 1 : 0), (type$ptr<?> New$Mem)->{
        return new ReturnInst(C, retVal, InsertAtEnd);
     })));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2837,
   FQN="llvm::ReturnInst::Create", NM="_ZN4llvm10ReturnInst6CreateERNS_11LLVMContextEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ReturnInst6CreateERNS_11LLVMContextEPNS_10BasicBlockE")
  //</editor-fold>
  public static ReturnInst /*P*/ Create(final LLVMContext /*&*/ C, BasicBlock /*P*/ InsertAtEnd) {
    return ((/*JCast*/ReturnInst /*P*/ )(/*NEW_EXPR [User::new]*//*0 = *//*new (0)*/ User.$new_FixedUses(0, (type$ptr<?> New$Mem)->{
        return new ReturnInst(C, InsertAtEnd);
     })));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::~ReturnInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 849,
   FQN="llvm::ReturnInst::~ReturnInst", NM="_ZN4llvm10ReturnInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ReturnInstD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
  }


  /// Provide fast operand accessors
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2870,
   FQN="llvm::ReturnInst::getOperand", NM="_ZNK4llvm10ReturnInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10ReturnInst10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsReturnInst.operands(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsReturnInst.op_begin(((/*const_cast*/ReturnInst /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2870,
   FQN="llvm::ReturnInst::setOperand", NM="_ZN4llvm10ReturnInst10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ReturnInst10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsReturnInst.operands(this))) : "setOperand() out of range!";
    OperandTraitsReturnInst.op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2870,
   FQN="llvm::ReturnInst::op_begin", NM="_ZN4llvm10ReturnInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ReturnInst8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsReturnInst.op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2870,
   FQN="llvm::ReturnInst::op_begin", NM="_ZNK4llvm10ReturnInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10ReturnInst8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsReturnInst.op_begin(((/*const_cast*/ReturnInst /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2870,
   FQN="llvm::ReturnInst::op_end", NM="_ZN4llvm10ReturnInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ReturnInst6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsReturnInst.op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2870,
   FQN="llvm::ReturnInst::op_end", NM="_ZNK4llvm10ReturnInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10ReturnInst6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsReturnInst.op_end(((/*const_cast*/ReturnInst /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::Op">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2870,
   FQN="llvm::ReturnInst::Op", NM="Tpl__ZN4llvm10ReturnInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm10ReturnInst2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::Op">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2870,
   FQN="llvm::ReturnInst::Op", NM="Tpl__ZNK4llvm10ReturnInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm10ReturnInst2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2870,
   FQN="llvm::ReturnInst::getNumOperands", NM="_ZNK4llvm10ReturnInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10ReturnInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsReturnInst.operands(this);
  }

  
  /// Convenience accessor. Returns null if there is no return value.
  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::getReturnValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2846,
   FQN="llvm::ReturnInst::getReturnValue", NM="_ZNK4llvm10ReturnInst14getReturnValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10ReturnInst14getReturnValueEv")
  //</editor-fold>
  public Value /*P*/ getReturnValue() /*const*/ {
    return getNumOperands() != 0 ? getOperand(0) : null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::getNumSuccessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2850,
   FQN="llvm::ReturnInst::getNumSuccessors", NM="_ZNK4llvm10ReturnInst16getNumSuccessorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10ReturnInst16getNumSuccessorsEv")
  //</editor-fold>
  public /*uint*/int getNumSuccessors() /*const*/ {
    return 0;
  }

  
  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2853,
   FQN="llvm::ReturnInst::classof", NM="_ZN4llvm10ReturnInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ReturnInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return (I.getOpcode() == Instruction.TermOps.Ret);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2856,
   FQN="llvm::ReturnInst::classof", NM="_ZN4llvm10ReturnInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ReturnInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && ReturnInst.classof(cast_Instruction(V));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::getSuccessorV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 845,
   FQN="llvm::ReturnInst::getSuccessorV", NM="_ZNK4llvm10ReturnInst13getSuccessorVEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10ReturnInst13getSuccessorVEj")
  //</editor-fold>
  @Override protected/*private*/ BasicBlock /*P*/ getSuccessorV(/*uint*/int idx) /*const*//* override*/ {
    throw new llvm_unreachable("ReturnInst has no successors!");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::getNumSuccessorsV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 835,
   FQN="llvm::ReturnInst::getNumSuccessorsV", NM="_ZNK4llvm10ReturnInst17getNumSuccessorsVEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10ReturnInst17getNumSuccessorsVEv")
  //</editor-fold>
  @Override protected/*private*/ /*uint*/int getNumSuccessorsV() /*const*//* override*/ {
    return getNumSuccessors();
  }

  
  /// Out-of-line ReturnInst method, put here so the C++ compiler can choose to
  /// emit the vtable for the class in this translation unit.
  //<editor-fold defaultstate="collapsed" desc="llvm::ReturnInst::setSuccessorV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 841,
   FQN="llvm::ReturnInst::setSuccessorV", NM="_ZN4llvm10ReturnInst13setSuccessorVEjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10ReturnInst13setSuccessorVEjPNS_10BasicBlockE")
  //</editor-fold>
  @Override protected/*private*/ void setSuccessorV(/*uint*/int idx, BasicBlock /*P*/ NewSucc)/* override*/ {
    throw new llvm_unreachable("ReturnInst has no successors!");
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
