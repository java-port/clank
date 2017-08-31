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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.impl.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.ir.java.*;
import org.llvm.ir.mdconst.MdconstGlobals;

//<editor-fold defaultstate="collapsed" desc="llvm::Instruction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 36,
 FQN="llvm::Instruction", NM="_ZN4llvm11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11InstructionE")
//</editor-fold>
public class Instruction extends /*public*/ User implements /*public*/ ilist_node_with_parent<Instruction, BasicBlock>, IChild<BasicBlock>, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 38,
   FQN="llvm::Instruction::operator=", NM="_ZN4llvm11InstructionaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11InstructionaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ Instruction /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::Instruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 39,
   FQN="llvm::Instruction::Instruction", NM="_ZN4llvm11InstructionC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11InstructionC1ERKS0_")
  //</editor-fold>
  protected/*private*/ Instruction(final /*const*/ Instruction /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  
  private BasicBlock /*P*/ Parent;
  private DebugLoc DbgLoc; // 'dbg' Metadata cache.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 44,
   FQN="llvm::Instruction::(anonymous)", NM="_ZN4llvm11InstructionE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11InstructionE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    /// This is a bit stored in the SubClassData field which indicates whether
    /// this instruction has metadata attached to it or not.
    public static final /*uint*/int HasMetadataBit = 1 << 15;
  /*}*/;
/*public:*/
  // Out of line virtual method, so the vtable, etc has a home.
  
  // Out of line virtual method, so the vtable, etc has a home.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::~Instruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 46,
   FQN="llvm::Instruction::~Instruction", NM="_ZN4llvm11InstructionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11InstructionD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    assert (!(Parent != null)) : "Instruction still linked in the program!";
    if (hasMetadataHashEntry()) {
      clearMetadataHashEntries();
    }
    //START JDestroy
    DbgLoc.$destroy();
    super.$destroy();
    ilist_node_with_parent.super.$destroy$ilist_node_with_parent();
    //END JDestroy
  }

  
  /// Specialize the methods defined in Value, as we know that an instruction
  /// can only be used by other instructions.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::user_back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 55,
   FQN="llvm::Instruction::user_back", NM="_ZN4llvm11Instruction9user_backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction9user_backEv")
  //</editor-fold>
  public final/*public*/ Instruction /*P*/ user_back$Instruction() {
    return cast_Instruction(user_begin().$star());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::user_back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 56,
   FQN="llvm::Instruction::user_back", NM="_ZNK4llvm11Instruction9user_backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction9user_backEv")
  //</editor-fold>
  public final/*public*/ /*const*/ Instruction /*P*/ user_back$Instruction$Const() /*const*/ {
    return cast_Instruction(user_begin$Const().$star());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 58,
   FQN="llvm::Instruction::getParent", NM="_ZNK4llvm11Instruction9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction9getParentEv")
  //</editor-fold>
  public /*inline*/ /*const*/ BasicBlock /*P*/ getParent$Const() /*const*/ {
    return Parent;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 59,
   FQN="llvm::Instruction::getParent", NM="_ZN4llvm11Instruction9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction9getParentEv")
  //</editor-fold>
  public /*inline*/ BasicBlock /*P*/ getParent() {
    return Parent;
  }

  
  /// Return the module owning the function this instruction belongs to
  /// or nullptr it the function does not have a module.
  ///
  /// Note: this is undefined behavior if the instruction does not have a
  /// parent, or the parent basic block does not have a parent function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::getModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 57,
   FQN="llvm::Instruction::getModule", NM="_ZNK4llvm11Instruction9getModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction9getModuleEv")
  //</editor-fold>
  public /*const*/ Module /*P*/ getModule$Const() /*const*/ {
    return getParent$Const().getModule$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::getModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 61,
   FQN="llvm::Instruction::getModule", NM="_ZN4llvm11Instruction9getModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction9getModuleEv")
  //</editor-fold>
  public Module /*P*/ getModule() {
    return getParent().getModule();
  }

  
  /// Return the function this instruction belongs to.
  ///
  /// Note: it is undefined behavior to call this on an instruction not
  /// currently inserted into a function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::getFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 67,
   FQN="llvm::Instruction::getFunction", NM="_ZNK4llvm11Instruction11getFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction11getFunctionEv")
  //</editor-fold>
  public /*const*/ Function /*P*/ getFunction$Const() /*const*/ {
    return getParent$Const().getParent$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::getFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 65,
   FQN="llvm::Instruction::getFunction", NM="_ZN4llvm11Instruction11getFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction11getFunctionEv")
  //</editor-fold>
  public Function /*P*/ getFunction() {
    return getParent().getParent();
  }

  
  /// This method unlinks 'this' from the containing basic block, but does not
  /// delete it.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::removeFromParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 71,
   FQN="llvm::Instruction::removeFromParent", NM="_ZN4llvm11Instruction16removeFromParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction16removeFromParentEv")
  //</editor-fold>
  public void removeFromParent() {
    getParent().getInstList().remove_ilist_iterator$NodeTy$C(getIterator());
  }

  
  /// This method unlinks 'this' from the containing basic block and deletes it.
  ///
  /// \returns an iterator pointing to the element after the erased one
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::eraseFromParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 75,
   FQN="llvm::Instruction::eraseFromParent", NM="_ZN4llvm11Instruction15eraseFromParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction15eraseFromParentEv")
  //</editor-fold>
  public ilist_iterator<Instruction> eraseFromParent() {
    return getParent().getInstList().erase(getIterator());
  }

  
  /// Insert an unlinked instruction into a basic block immediately before
  /// the specified instruction.
  
  /// Insert an unlinked instruction into a basic block immediately before the
  /// specified instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::insertBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 81,
   FQN="llvm::Instruction::insertBefore", NM="_ZN4llvm11Instruction12insertBeforeEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction12insertBeforeEPS0_")
  //</editor-fold>
  public void insertBefore(Instruction /*P*/ InsertPos) {
    InsertPos.getParent().getInstList().insert_ilist_iterator$NodeTy_T$P(InsertPos.getIterator(), this);
  }

  
  /// Insert an unlinked instruction into a basic block immediately after the
  /// specified instruction.
  
  /// Insert an unlinked instruction into a basic block immediately after the
  /// specified instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::insertAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 87,
   FQN="llvm::Instruction::insertAfter", NM="_ZN4llvm11Instruction11insertAfterEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction11insertAfterEPS0_")
  //</editor-fold>
  public void insertAfter(Instruction /*P*/ InsertPos) {
    InsertPos.getParent().getInstList().insertAfter(InsertPos.getIterator(), 
        this);
  }

  
  /// Unlink this instruction from its current basic block and insert it into
  /// the basic block that MovePos lives in, right before MovePos.
  
  /// Unlink this instruction from its current basic block and insert it into the
  /// basic block that MovePos lives in, right before MovePos.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::moveBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 94,
   FQN="llvm::Instruction::moveBefore", NM="_ZN4llvm11Instruction10moveBeforeEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction10moveBeforeEPS0_")
  //</editor-fold>
  public void moveBefore(Instruction /*P*/ MovePos) {
    MovePos.getParent().getInstList().splice(MovePos.getIterator(), getParent().getInstList(), getIterator());
  }

  
  //===--------------------------------------------------------------------===//
  // Subclass classification.
  //===--------------------------------------------------------------------===//
  
  /// Returns a member of one of the enums like Instruction::Add.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::getOpcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 102,
   FQN="llvm::Instruction::getOpcode", NM="_ZNK4llvm11Instruction9getOpcodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction9getOpcodeEv")
  //</editor-fold>
  public /*uint*/int getOpcode() /*const*/ {
    return getValueID() - ValueTy.InstructionVal.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::getOpcodeName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 104,
   FQN="llvm::Instruction::getOpcodeName", NM="_ZNK4llvm11Instruction13getOpcodeNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction13getOpcodeNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getOpcodeName() /*const*/ {
    return getOpcodeName(getOpcode());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isTerminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 105,
   FQN="llvm::Instruction::isTerminator", NM="_ZNK4llvm11Instruction12isTerminatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction12isTerminatorEv")
  //</editor-fold>
  public boolean isTerminator() /*const*/ {
    return Instruction.isTerminator(getOpcode());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isBinaryOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 106,
   FQN="llvm::Instruction::isBinaryOp", NM="_ZNK4llvm11Instruction10isBinaryOpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction10isBinaryOpEv")
  //</editor-fold>
  public boolean isBinaryOp() /*const*/ {
    return Instruction.isBinaryOp(getOpcode());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isShift">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 107,
   FQN="llvm::Instruction::isShift", NM="_ZN4llvm11Instruction7isShiftEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction7isShiftEv")
  //</editor-fold>
  public boolean isShift() {
    return Instruction.isShift(getOpcode());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 108,
   FQN="llvm::Instruction::isCast", NM="_ZNK4llvm11Instruction6isCastEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction6isCastEv")
  //</editor-fold>
  public boolean isCast() /*const*/ {
    return Instruction.isCast(getOpcode());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isFuncletPad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 109,
   FQN="llvm::Instruction::isFuncletPad", NM="_ZNK4llvm11Instruction12isFuncletPadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction12isFuncletPadEv")
  //</editor-fold>
  public boolean isFuncletPad() /*const*/ {
    return Instruction.isFuncletPad(getOpcode());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::getOpcodeName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 266,
   FQN="llvm::Instruction::getOpcodeName", NM="_ZN4llvm11Instruction13getOpcodeNameEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction13getOpcodeNameEj")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getOpcodeName(/*uint*/int OpCode) {
    switch (OpCode) {
     case TermOps.Ret:
      // Terminators
      return $("ret");
     case TermOps.Br:
      return $("br");
     case TermOps.Switch:
      return $switch;
     case TermOps.IndirectBr:
      return $("indirectbr");
     case TermOps.Invoke:
      return $("invoke");
     case TermOps.Resume:
      return $("resume");
     case TermOps.Unreachable:
      return $("unreachable");
     case TermOps.CleanupRet:
      return $("cleanupret");
     case TermOps.CatchRet:
      return $("catchret");
     case FuncletPadOps.CatchPad:
      return $("catchpad");
     case TermOps.CatchSwitch:
      return $("catchswitch");
     case BinaryOps.Add:
      
      // Standard binary operators...
      return $("add");
     case BinaryOps.FAdd:
      return $("fadd");
     case BinaryOps.Sub:
      return $("sub");
     case BinaryOps.FSub:
      return $("fsub");
     case BinaryOps.Mul:
      return $("mul");
     case BinaryOps.FMul:
      return $("fmul");
     case BinaryOps.UDiv:
      return $("udiv");
     case BinaryOps.SDiv:
      return $("sdiv");
     case BinaryOps.FDiv:
      return $("fdiv");
     case BinaryOps.URem:
      return $("urem");
     case BinaryOps.SRem:
      return $("srem");
     case BinaryOps.FRem:
      return $("frem");
     case BinaryOps.And:
      
      // Logical operators...
      return $("and");
     case BinaryOps.Or:
      return $("or");
     case BinaryOps.Xor:
      return $("xor");
     case MemoryOps.Alloca:
      
      // Memory instructions...
      return $("alloca");
     case MemoryOps.Load:
      return $("load");
     case MemoryOps.Store:
      return $("store");
     case MemoryOps.AtomicCmpXchg:
      return $("cmpxchg");
     case MemoryOps.AtomicRMW:
      return $("atomicrmw");
     case MemoryOps.Fence:
      return $("fence");
     case MemoryOps.GetElementPtr:
      return $("getelementptr");
     case CastOps.Trunc:
      
      // Convert instructions...
      return $("trunc");
     case CastOps.ZExt:
      return $("zext");
     case CastOps.SExt:
      return $("sext");
     case CastOps.FPTrunc:
      return $("fptrunc");
     case CastOps.FPExt:
      return $("fpext");
     case CastOps.FPToUI:
      return $("fptoui");
     case CastOps.FPToSI:
      return $("fptosi");
     case CastOps.UIToFP:
      return $("uitofp");
     case CastOps.SIToFP:
      return $("sitofp");
     case CastOps.IntToPtr:
      return $("inttoptr");
     case CastOps.PtrToInt:
      return $("ptrtoint");
     case CastOps.BitCast:
      return $("bitcast");
     case CastOps.AddrSpaceCast:
      return $("addrspacecast");
     case OtherOps.ICmp:
      
      // Other instructions...
      return $("icmp");
     case OtherOps.FCmp:
      return $("fcmp");
     case OtherOps.PHI:
      return $("phi");
     case OtherOps.Select:
      return $("select");
     case OtherOps.Call:
      return $("call");
     case BinaryOps.Shl:
      return $("shl");
     case BinaryOps.LShr:
      return $("lshr");
     case BinaryOps.AShr:
      return $("ashr");
     case OtherOps.VAArg:
      return $("va_arg");
     case OtherOps.ExtractElement:
      return $("extractelement");
     case OtherOps.InsertElement:
      return $("insertelement");
     case OtherOps.ShuffleVector:
      return $("shufflevector");
     case OtherOps.ExtractValue:
      return $("extractvalue");
     case OtherOps.InsertValue:
      return $("insertvalue");
     case OtherOps.LandingPad:
      return $("landingpad");
     case FuncletPadOps.CleanupPad:
      return $("cleanuppad");
     default:
      return $("<Invalid operator> ");
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isTerminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 113,
   FQN="llvm::Instruction::isTerminator", NM="_ZN4llvm11Instruction12isTerminatorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction12isTerminatorEj")
  //</editor-fold>
  public static /*inline*/ boolean isTerminator(/*uint*/int OpCode) {
    return $greatereq_uint_int(OpCode, TermOps.TermOpsBegin) && $less_uint_int(OpCode, TermOps.TermOpsEnd);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isBinaryOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 117,
   FQN="llvm::Instruction::isBinaryOp", NM="_ZN4llvm11Instruction10isBinaryOpEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction10isBinaryOpEj")
  //</editor-fold>
  public static /*inline*/ boolean isBinaryOp(/*uint*/int Opcode) {
    return $greatereq_uint_int(Opcode, BinaryOps.BinaryOpsBegin) && $less_uint_int(Opcode, BinaryOps.BinaryOpsEnd);
  }

  
  /// Determine if the Opcode is one of the shift instructions.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isShift">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 122,
   FQN="llvm::Instruction::isShift", NM="_ZN4llvm11Instruction7isShiftEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction7isShiftEj")
  //</editor-fold>
  public static /*inline*/ boolean isShift(/*uint*/int Opcode) {
    return $greatereq_uint_int(Opcode, BinaryOps.Shl) && $lesseq_uint_int(Opcode, BinaryOps.AShr);
  }

  
  /// Return true if this is a logical shift left or a logical shift right.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isLogicalShift">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 127,
   FQN="llvm::Instruction::isLogicalShift", NM="_ZNK4llvm11Instruction14isLogicalShiftEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction14isLogicalShiftEv")
  //</editor-fold>
  public /*inline*/ boolean isLogicalShift() /*const*/ {
    return getOpcode() == BinaryOps.Shl || getOpcode() == BinaryOps.LShr;
  }

  
  /// Return true if this is an arithmetic shift right.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isArithmeticShift">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 132,
   FQN="llvm::Instruction::isArithmeticShift", NM="_ZNK4llvm11Instruction17isArithmeticShiftEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction17isArithmeticShiftEv")
  //</editor-fold>
  public /*inline*/ boolean isArithmeticShift() /*const*/ {
    return getOpcode() == BinaryOps.AShr;
  }

  
  /// Determine if the OpCode is one of the CastInst instructions.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 137,
   FQN="llvm::Instruction::isCast", NM="_ZN4llvm11Instruction6isCastEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction6isCastEj")
  //</editor-fold>
  public static /*inline*/ boolean isCast(/*uint*/int OpCode) {
    return $greatereq_uint_int(OpCode, CastOps.CastOpsBegin) && $less_uint_int(OpCode, CastOps.CastOpsEnd);
  }

  
  /// Determine if the OpCode is one of the FuncletPadInst instructions.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isFuncletPad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 142,
   FQN="llvm::Instruction::isFuncletPad", NM="_ZN4llvm11Instruction12isFuncletPadEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction12isFuncletPadEj")
  //</editor-fold>
  public static /*inline*/ boolean isFuncletPad(/*uint*/int OpCode) {
    return $greatereq_uint_int(OpCode, FuncletPadOps.FuncletPadOpsBegin) && $less_uint_int(OpCode, FuncletPadOps.FuncletPadOpsEnd);
  }

  
  //===--------------------------------------------------------------------===//
  // Metadata manipulation.
  //===--------------------------------------------------------------------===//
  
  /// Return true if this instruction has any metadata attached to it.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::hasMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 151,
   FQN="llvm::Instruction::hasMetadata", NM="_ZNK4llvm11Instruction11hasMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction11hasMetadataEv")
  //</editor-fold>
  public boolean hasMetadata() /*const*/ {
    return DbgLoc.$bool() || hasMetadataHashEntry();
  }

  
  /// Return true if this instruction has metadata attached to it other than a
  /// debug location.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::hasMetadataOtherThanDebugLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 155,
   FQN="llvm::Instruction::hasMetadataOtherThanDebugLoc", NM="_ZNK4llvm11Instruction28hasMetadataOtherThanDebugLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction28hasMetadataOtherThanDebugLocEv")
  //</editor-fold>
  public boolean hasMetadataOtherThanDebugLoc() /*const*/ {
    return hasMetadataHashEntry();
  }

  
  /// Get the metadata of given kind attached to this Instruction.
  /// If the metadata is not found then return null.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::getMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 161,
   FQN="llvm::Instruction::getMetadata", NM="_ZNK4llvm11Instruction11getMetadataEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction11getMetadataEj")
  //</editor-fold>
  public MDNode /*P*/ getMetadata(/*uint*/int KindID) /*const*/ {
    if (!hasMetadata()) {
      return null;
    }
    return getMetadataImpl(KindID);
  }

  
  /// Get the metadata of given kind attached to this Instruction.
  /// If the metadata is not found then return null.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::getMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 168,
   FQN="llvm::Instruction::getMetadata", NM="_ZNK4llvm11Instruction11getMetadataENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction11getMetadataENS_9StringRefE")
  //</editor-fold>
  public MDNode /*P*/ getMetadata(StringRef Kind) /*const*/ {
    if (!hasMetadata()) {
      return null;
    }
    return getMetadataImpl(new StringRef(Kind));
  }

  
  /// Get all metadata attached to this Instruction. The first element of each
  /// pair returned is the KindID, the second element is the metadata value.
  /// This list is returned sorted by the KindID.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::getAllMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 176,
   FQN="llvm::Instruction::getAllMetadata", NM="_ZNK4llvm11Instruction14getAllMetadataERNS_15SmallVectorImplISt4pairIjPNS_6MDNodeEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction14getAllMetadataERNS_15SmallVectorImplISt4pairIjPNS_6MDNodeEEEE")
  //</editor-fold>
  public void getAllMetadata(final SmallVectorImpl<std.pairUIntPtr<MDNode /*P*/ > > /*&*/ MDs) /*const*/ {
    if (hasMetadata()) {
      getAllMetadataImpl(MDs);
    }
  }

  
  /// This does the same thing as getAllMetadata, except that it filters out the
  /// debug location.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::getAllMetadataOtherThanDebugLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 184,
   FQN="llvm::Instruction::getAllMetadataOtherThanDebugLoc", NM="_ZNK4llvm11Instruction31getAllMetadataOtherThanDebugLocERNS_15SmallVectorImplISt4pairIjPNS_6MDNodeEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction31getAllMetadataOtherThanDebugLocERNS_15SmallVectorImplISt4pairIjPNS_6MDNodeEEEE")
  //</editor-fold>
  public void getAllMetadataOtherThanDebugLoc(final SmallVectorImpl<std.pairUIntPtr<MDNode /*P*/ > > /*&*/ MDs) /*const*/ {
    if (hasMetadataOtherThanDebugLoc()) {
      getAllMetadataOtherThanDebugLocImpl(MDs);
    }
  }

  
  /// Fills the AAMDNodes structure with AA metadata from this instruction.
  /// When Merge is true, the existing AA metadata is merged with that from this
  /// instruction providing the most-general result.
  
  /// Fills the AAMDNodes structure with AA metadata from this instruction.
  /// When Merge is true, the existing AA metadata is merged with that from this
  /// instruction providing the most-general result.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::getAAMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 458,
   FQN="llvm::Instruction::getAAMetadata", NM="_ZNK4llvm11Instruction13getAAMetadataERNS_9AAMDNodesEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZNK4llvm11Instruction13getAAMetadataERNS_9AAMDNodesEb")
  //</editor-fold>
  public void getAAMetadata(final AAMDNodes /*&*/ N) /*const*/ {
    getAAMetadata(N, false);
  }
  public void getAAMetadata(final AAMDNodes /*&*/ N, boolean Merge/*= false*/) /*const*/ {
    if (Merge) {
      N.TBAA
         = MDNode.getMostGenericTBAA(N.TBAA, getMetadata(LLVMContext.Unnamed_enum.MD_tbaa.getValue()));
    } else {
      N.TBAA = getMetadata(LLVMContext.Unnamed_enum.MD_tbaa.getValue());
    }
    if (Merge) {
      N.Scope = MDNode.getMostGenericAliasScope(N.Scope, getMetadata(LLVMContext.Unnamed_enum.MD_alias_scope.getValue()));
    } else {
      N.Scope = getMetadata(LLVMContext.Unnamed_enum.MD_alias_scope.getValue());
    }
    if (Merge) {
      N.NoAlias
         = MDNode.intersect(N.NoAlias, getMetadata(LLVMContext.Unnamed_enum.MD_noalias.getValue()));
    } else {
      N.NoAlias = getMetadata(LLVMContext.Unnamed_enum.MD_noalias.getValue());
    }
  }


  
  /// Set the metadata of the specified kind to the specified node. This updates
  /// or replaces metadata if already present, or removes it if Node is null.
  
  /// Set the metadata of the specified kind to the specified node. This updates
  /// or replaces metadata if already present, or removes it if Node is null.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::setMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1203,
   FQN="llvm::Instruction::setMetadata", NM="_ZN4llvm11Instruction11setMetadataEjPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm11Instruction11setMetadataEjPNS_6MDNodeE")
  //</editor-fold>
  public void setMetadata(/*uint*/int KindID, MDNode /*P*/ Node) {
    if (!(Node != null) && !hasMetadata()) {
      return;
    }
    
    // Handle 'dbg' as a special case since it is not stored in the hash table.
    if (KindID == LLVMContext.Unnamed_enum.MD_dbg.getValue()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(DbgLoc.$assignMove($c$.track(new DebugLoc(Node))));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Handle the case when we're adding/updating metadata on an instruction.
    if ((Node != null)) {
      final MDAttachmentMap /*&*/ Info = getContext().pImpl.InstructionMetadata.$at_T1$RR(this);
      assert (!Info.empty() == hasMetadataHashEntry()) : "HasMetadata bit is wonked";
      if (Info.empty()) {
        setHasMetadataHashEntry(true);
      }
      Info.set(KindID, $Deref(Node));
      return;
    }
    
    // Otherwise, we're removing metadata from an instruction.
    assert ((hasMetadataHashEntry() == ($greater_uint(getContext().pImpl.InstructionMetadata.count(this), 0)))) : "HasMetadata bit out of date!";
    if (!hasMetadataHashEntry()) {
      return; // Nothing to remove!
    }
    final MDAttachmentMap /*&*/ Info = getContext().pImpl.InstructionMetadata.$at_T1$RR(this);
    
    // Handle removal of an existing value.
    Info.erase(KindID);
    if (!Info.empty()) {
      return;
    }
    
    getContext().pImpl.InstructionMetadata.erase(this);
    setHasMetadataHashEntry(false);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::setMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1165,
   FQN="llvm::Instruction::setMetadata", NM="_ZN4llvm11Instruction11setMetadataENS_9StringRefEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm11Instruction11setMetadataENS_9StringRefEPNS_6MDNodeE")
  //</editor-fold>
  public void setMetadata(StringRef Kind, MDNode /*P*/ Node) {
    if (!(Node != null) && !hasMetadata()) {
      return;
    }
    setMetadata(getContext().getMDKindID(new StringRef(Kind)), Node);
  }


  
  /// Drop all unknown metadata except for debug locations.
  /// @{
  /// Passes are required to drop metadata they don't understand. This is a
  /// convenience method for passes to do so.
  
  /// Drop all unknown metadata except for debug locations.
  /// @{
  /// Passes are required to drop metadata they don't understand. This is a
  /// convenience method for passes to do so.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::dropUnknownNonDebugMetadata">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1175,
   FQN="llvm::Instruction::dropUnknownNonDebugMetadata", NM="_ZN4llvm11Instruction27dropUnknownNonDebugMetadataENS_8ArrayRefIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm11Instruction27dropUnknownNonDebugMetadataENS_8ArrayRefIjEE")
  //</editor-fold>
  public void dropUnknownNonDebugMetadata(ArrayRefUInt KnownIDs) {
    SmallSetUInt KnownSet = null;
    try {
      KnownSet/*J*/= new SmallSetUInt(5);
      KnownSet.insert$T(KnownIDs.begin(), KnownIDs.end());
      if (!hasMetadataHashEntry()) {
        return; // Nothing to remove!
      }
      
      final DenseMap</*const*/ Instruction /*P*/ , MDAttachmentMap> /*&*/ InstructionMetadata = getContext().pImpl.InstructionMetadata;
      if (KnownSet.empty()) {
        // Just drop our entry at the store.
        InstructionMetadata.erase(this);
        setHasMetadataHashEntry(false);
        return;
      }
      
      final MDAttachmentMap /*&*/ Info = InstructionMetadata.$at_T1$RR(this);
      SmallSetUInt KnownSet$Final = KnownSet;
      Info.remove_if(/*[&KnownSet]*/ (final /*const*/std.pairUIntType<TypedTrackingMDRef<MDNode>> /*&*/ I) -> {
                return !(KnownSet$Final.count(I.first) != 0);
              });
      if (Info.empty()) {
        // Drop our entry at the store.
        InstructionMetadata.erase(this);
        setHasMetadataHashEntry(false);
      }
    } finally {
      if (KnownSet != null) { KnownSet.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::dropUnknownNonDebugMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 205,
   FQN="llvm::Instruction::dropUnknownNonDebugMetadata", NM="_ZN4llvm11Instruction27dropUnknownNonDebugMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction27dropUnknownNonDebugMetadataEv")
  //</editor-fold>
  public void dropUnknownNonDebugMetadata() {
    dropUnknownNonDebugMetadata(new ArrayRefUInt(None));
    /*JAVA:return*/return;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::dropUnknownNonDebugMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 208,
   FQN="llvm::Instruction::dropUnknownNonDebugMetadata", NM="_ZN4llvm11Instruction27dropUnknownNonDebugMetadataEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction27dropUnknownNonDebugMetadataEj")
  //</editor-fold>
  public void dropUnknownNonDebugMetadata(/*uint*/int ID1) {
    dropUnknownNonDebugMetadata(makeArrayRef$UInt(ID1, false));
    /*JAVA:return*/return;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::dropUnknownNonDebugMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 211,
   FQN="llvm::Instruction::dropUnknownNonDebugMetadata", NM="_ZN4llvm11Instruction27dropUnknownNonDebugMetadataEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction27dropUnknownNonDebugMetadataEjj")
  //</editor-fold>
  public void dropUnknownNonDebugMetadata(/*uint*/int ID1, /*uint*/int ID2) {
    /*uint*/int IDs[/*2*/] = new /*uint*/int [/*2*/] {ID1, ID2};
    dropUnknownNonDebugMetadata(new ArrayRefUInt(IDs));
    /*JAVA:return*/return;
  }

  /// @}
  
  /// Sets the metadata on this instruction from the AAMDNodes structure.
  /// @}
  
  /// Sets the metadata on this instruction from the AAMDNodes structure.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::setAAMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1242,
   FQN="llvm::Instruction::setAAMetadata", NM="_ZN4llvm11Instruction13setAAMetadataERKNS_9AAMDNodesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm11Instruction13setAAMetadataERKNS_9AAMDNodesE")
  //</editor-fold>
  public void setAAMetadata(final /*const*/ AAMDNodes /*&*/ N) {
    setMetadata(LLVMContext.Unnamed_enum.MD_tbaa.getValue(), N.TBAA);
    setMetadata(LLVMContext.Unnamed_enum.MD_alias_scope.getValue(), N.Scope);
    setMetadata(LLVMContext.Unnamed_enum.MD_noalias.getValue(), N.NoAlias);
  }


  
  /// Retrieve the raw weight values of a conditional branch or select.
  /// Returns true on success with profile weights filled in.
  /// Returns false if no metadata or invalid metadata was found.
  
  /// Retrieve the raw weight values of a conditional branch or select.
  /// Returns true on success with profile weights filled in.
  /// Returns false if no metadata or invalid metadata was found.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::extractProfMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1291,
   FQN="llvm::Instruction::extractProfMetadata", NM="_ZN4llvm11Instruction19extractProfMetadataERyS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm11Instruction19extractProfMetadataERyS1_")
  //</editor-fold>
  public boolean extractProfMetadata(final ulong$ref/*uint64_t &*/ TrueVal, final ulong$ref/*uint64_t &*/ FalseVal) {
    assert ((getOpcode() == Instruction.TermOps.Br || getOpcode() == Instruction.OtherOps.Select)) : "Looking for branch weights on something besides branch or select";
    
    MDNode /*P*/ ProfileData = getMetadata(LLVMContext.Unnamed_enum.MD_prof.getValue());
    if (!(ProfileData != null) || ProfileData.getNumOperands() != 3) {
      return false;
    }
    
    MDString /*P*/ ProfDataName = dyn_cast_MDString(ProfileData.getOperand(0));
    if (!(ProfDataName != null) || !ProfDataName.getString().equals(/*STRINGREF_STR*/"branch_weights")) {
      return false;
    }
    
    ConstantInt /*P*/ CITrue = MdconstGlobals.<ConstantInt, /*const*/ MDOperand /*&*/ >dyn_extract$ValidPointer(ConstantInt.class, ProfileData.getOperand(1));
    ConstantInt /*P*/ CIFalse = MdconstGlobals.<ConstantInt, /*const*/ MDOperand /*&*/ >dyn_extract$ValidPointer(ConstantInt.class, ProfileData.getOperand(2));
    if (!(CITrue != null) || !(CIFalse != null)) {
      return false;
    }
    
    TrueVal.$set(CITrue.getValue().getZExtValue());
    FalseVal.$set(CIFalse.getValue().getZExtValue());
    
    return true;
  }


  
  /// Retrieve total raw weight values of a branch.
  /// Returns true on success with profile total weights filled in.
  /// Returns false if no metadata was found.
  
  /// Retrieve total raw weight values of a branch.
  /// Returns true on success with profile total weights filled in.
  /// Returns false if no metadata was found.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::extractProfTotalWeight">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1315,
   FQN="llvm::Instruction::extractProfTotalWeight", NM="_ZN4llvm11Instruction22extractProfTotalWeightERy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm11Instruction22extractProfTotalWeightERy")
  //</editor-fold>
  public boolean extractProfTotalWeight(final ulong$ref/*uint64_t &*/ TotalVal) {
    assert ((getOpcode() == Instruction.TermOps.Br || getOpcode() == Instruction.OtherOps.Select || getOpcode() == Instruction.OtherOps.Call || getOpcode() == Instruction.TermOps.Invoke)) : "Looking for branch weights on something besides branch";
    
    TotalVal.$set($int2ulong(0));
    MDNode /*P*/ ProfileData = getMetadata(LLVMContext.Unnamed_enum.MD_prof.getValue());
    if (!(ProfileData != null)) {
      return false;
    }
    
    MDString /*P*/ ProfDataName = dyn_cast_MDString(ProfileData.getOperand(0));
    if (!(ProfDataName != null) || !ProfDataName.getString().equals(/*STRINGREF_STR*/"branch_weights")) {
      return false;
    }
    
    TotalVal.$set($int2ulong(0));
    for (/*uint*/int i = 1; $less_uint(i, ProfileData.getNumOperands()); i++) {
      ConstantInt /*P*/ V = MdconstGlobals.<ConstantInt, /*const*/ MDOperand /*&*/ >dyn_extract$ValidPointer(ConstantInt.class, ProfileData.getOperand(i));
      if (!(V != null)) {
        return false;
      }
      TotalVal.$set$addassign(V.getValue().getZExtValue());
    }
    return true;
  }


  
  /// Set the debug location information for this instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::setDebugLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 231,
   FQN="llvm::Instruction::setDebugLoc", NM="_ZN4llvm11Instruction11setDebugLocENS_8DebugLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction11setDebugLocENS_8DebugLocE")
  //</editor-fold>
  public void setDebugLoc(DebugLoc Loc) {
    DbgLoc.$assignMove(std.move(Loc));
  }

  
  /// Return the debug location for this node as a DebugLoc.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::getDebugLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 234,
   FQN="llvm::Instruction::getDebugLoc", NM="_ZNK4llvm11Instruction11getDebugLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction11getDebugLocEv")
  //</editor-fold>
  public /*const*/ DebugLoc /*&*/ getDebugLoc() /*const*/ {
    return DbgLoc;
  }

  
  /// Set or clear the nsw flag on this instruction, which must be an operator
  /// which supports this flag. See LangRef.html for the meaning of this flag.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::setHasNoUnsignedWrap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 99,
   FQN="llvm::Instruction::setHasNoUnsignedWrap", NM="_ZN4llvm11Instruction20setHasNoUnsignedWrapEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction20setHasNoUnsignedWrapEb")
  //</editor-fold>
  public void setHasNoUnsignedWrap() {
    setHasNoUnsignedWrap(true);
  }
  public void setHasNoUnsignedWrap(boolean b/*= true*/) {
    cast_OverflowingBinaryOperator(this).setHasNoUnsignedWrap(b);
  }

  
  /// Set or clear the nsw flag on this instruction, which must be an operator
  /// which supports this flag. See LangRef.html for the meaning of this flag.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::setHasNoSignedWrap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 103,
   FQN="llvm::Instruction::setHasNoSignedWrap", NM="_ZN4llvm11Instruction18setHasNoSignedWrapEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction18setHasNoSignedWrapEb")
  //</editor-fold>
  public void setHasNoSignedWrap() {
    setHasNoSignedWrap(true);
  }
  public void setHasNoSignedWrap(boolean b/*= true*/) {
    cast_OverflowingBinaryOperator(this).setHasNoSignedWrap(b);
  }

  
  /// Set or clear the exact flag on this instruction, which must be an operator
  /// which supports this flag. See LangRef.html for the meaning of this flag.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::setIsExact">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 107,
   FQN="llvm::Instruction::setIsExact", NM="_ZN4llvm11Instruction10setIsExactEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction10setIsExactEb")
  //</editor-fold>
  public void setIsExact() {
    setIsExact(true);
  }
  public void setIsExact(boolean b/*= true*/) {
    cast_PossiblyExactOperator(this).setIsExact(b);
  }

  
  /// Determine whether the no unsigned wrap flag is set.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::hasNoUnsignedWrap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 111,
   FQN="llvm::Instruction::hasNoUnsignedWrap", NM="_ZNK4llvm11Instruction17hasNoUnsignedWrapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction17hasNoUnsignedWrapEv")
  //</editor-fold>
  public boolean hasNoUnsignedWrap() /*const*/ {
    return cast_OverflowingBinaryOperator(this).hasNoUnsignedWrap();
  }

  
  /// Determine whether the no signed wrap flag is set.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::hasNoSignedWrap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 115,
   FQN="llvm::Instruction::hasNoSignedWrap", NM="_ZNK4llvm11Instruction15hasNoSignedWrapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction15hasNoSignedWrapEv")
  //</editor-fold>
  public boolean hasNoSignedWrap() /*const*/ {
    return cast_OverflowingBinaryOperator(this).hasNoSignedWrap();
  }

  
  /// Determine whether the exact flag is set.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isExact">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 119,
   FQN="llvm::Instruction::isExact", NM="_ZNK4llvm11Instruction7isExactEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction7isExactEv")
  //</editor-fold>
  public boolean isExact() /*const*/ {
    return cast_PossiblyExactOperator(this).isExact();
  }

  
  /// Set or clear the unsafe-algebra flag on this instruction, which must be an
  /// operator which supports this flag. See LangRef.html for the meaning of
  /// this flag.
  
  /// Set or clear the unsafe-algebra flag on this instruction, which must be an
  /// operator which supports this flag. See LangRef.html for the meaning of this
  /// flag.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::setHasUnsafeAlgebra">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 126,
   FQN="llvm::Instruction::setHasUnsafeAlgebra", NM="_ZN4llvm11Instruction19setHasUnsafeAlgebraEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction19setHasUnsafeAlgebraEb")
  //</editor-fold>
  public void setHasUnsafeAlgebra(boolean B) {
    assert (isa_FPMathOperator(this)) : "setting fast-math flag on invalid op";
    cast_FPMathOperator(this).setHasUnsafeAlgebra(B);
  }

  
  /// Set or clear the no-nans flag on this instruction, which must be an
  /// operator which supports this flag. See LangRef.html for the meaning of
  /// this flag.
  
  /// Set or clear the NoNaNs flag on this instruction, which must be an operator
  /// which supports this flag. See LangRef.html for the meaning of this flag.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::setHasNoNaNs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 133,
   FQN="llvm::Instruction::setHasNoNaNs", NM="_ZN4llvm11Instruction12setHasNoNaNsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction12setHasNoNaNsEb")
  //</editor-fold>
  public void setHasNoNaNs(boolean B) {
    assert (isa_FPMathOperator(this)) : "setting fast-math flag on invalid op";
    cast_FPMathOperator(this).setHasNoNaNs(B);
  }

  
  /// Set or clear the no-infs flag on this instruction, which must be an
  /// operator which supports this flag. See LangRef.html for the meaning of
  /// this flag.
  
  /// Set or clear the no-infs flag on this instruction, which must be an operator
  /// which supports this flag. See LangRef.html for the meaning of this flag.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::setHasNoInfs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 140,
   FQN="llvm::Instruction::setHasNoInfs", NM="_ZN4llvm11Instruction12setHasNoInfsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction12setHasNoInfsEb")
  //</editor-fold>
  public void setHasNoInfs(boolean B) {
    assert (isa_FPMathOperator(this)) : "setting fast-math flag on invalid op";
    cast_FPMathOperator(this).setHasNoInfs(B);
  }

  
  /// Set or clear the no-signed-zeros flag on this instruction, which must be
  /// an operator which supports this flag. See LangRef.html for the meaning of
  /// this flag.
  
  /// Set or clear the no-signed-zeros flag on this instruction, which must be an
  /// operator which supports this flag. See LangRef.html for the meaning of this
  /// flag.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::setHasNoSignedZeros">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 148,
   FQN="llvm::Instruction::setHasNoSignedZeros", NM="_ZN4llvm11Instruction19setHasNoSignedZerosEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction19setHasNoSignedZerosEb")
  //</editor-fold>
  public void setHasNoSignedZeros(boolean B) {
    assert (isa_FPMathOperator(this)) : "setting fast-math flag on invalid op";
    cast_FPMathOperator(this).setHasNoSignedZeros(B);
  }

  
  /// Set or clear the allow-reciprocal flag on this instruction, which must be
  /// an operator which supports this flag. See LangRef.html for the meaning of
  /// this flag.
  
  /// Set or clear the allow-reciprocal flag on this instruction, which must be an
  /// operator which supports this flag. See LangRef.html for the meaning of this
  /// flag.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::setHasAllowReciprocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 156,
   FQN="llvm::Instruction::setHasAllowReciprocal", NM="_ZN4llvm11Instruction21setHasAllowReciprocalEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction21setHasAllowReciprocalEb")
  //</editor-fold>
  public void setHasAllowReciprocal(boolean B) {
    assert (isa_FPMathOperator(this)) : "setting fast-math flag on invalid op";
    cast_FPMathOperator(this).setHasAllowReciprocal(B);
  }

  
  /// Convenience function for setting multiple fast-math flags on this
  /// instruction, which must be an operator which supports these flags. See
  /// LangRef.html for the meaning of these flags.
  
  /// Convenience function for setting all the fast-math flags on this
  /// instruction, which must be an operator which supports these flags. See
  /// LangRef.html for the meaning of these flats.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::setFastMathFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 164,
   FQN="llvm::Instruction::setFastMathFlags", NM="_ZN4llvm11Instruction16setFastMathFlagsENS_13FastMathFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction16setFastMathFlagsENS_13FastMathFlagsE")
  //</editor-fold>
  public void setFastMathFlags(FastMathFlags FMF) {
    assert (isa_FPMathOperator(this)) : "setting fast-math flag on invalid op";
    cast_FPMathOperator(this).setFastMathFlags(new FastMathFlags(FMF));
  }

  
  /// Convenience function for transferring all fast-math flag values to this
  /// instruction, which must be an operator which supports these flags. See
  /// LangRef.html for the meaning of these flags.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::copyFastMathFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 169,
   FQN="llvm::Instruction::copyFastMathFlags", NM="_ZN4llvm11Instruction17copyFastMathFlagsENS_13FastMathFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction17copyFastMathFlagsENS_13FastMathFlagsE")
  //</editor-fold>
  public void copyFastMathFlags(FastMathFlags FMF) {
    assert (isa_FPMathOperator(this)) : "copying fast-math flag on invalid op";
    cast_FPMathOperator(this).copyFastMathFlags(new FastMathFlags(FMF));
  }

  
  /// Determine whether the unsafe-algebra flag is set.
  
  /// Determine whether the unsafe-algebra flag is set.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::hasUnsafeAlgebra">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 175,
   FQN="llvm::Instruction::hasUnsafeAlgebra", NM="_ZNK4llvm11Instruction16hasUnsafeAlgebraEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction16hasUnsafeAlgebraEv")
  //</editor-fold>
  public boolean hasUnsafeAlgebra() /*const*/ {
    assert (isa_FPMathOperator(this)) : "getting fast-math flag on invalid op";
    return cast_FPMathOperator(this).hasUnsafeAlgebra();
  }

  
  /// Determine whether the no-NaNs flag is set.
  
  /// Determine whether the no-NaNs flag is set.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::hasNoNaNs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 181,
   FQN="llvm::Instruction::hasNoNaNs", NM="_ZNK4llvm11Instruction9hasNoNaNsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction9hasNoNaNsEv")
  //</editor-fold>
  public boolean hasNoNaNs() /*const*/ {
    assert (isa_FPMathOperator(this)) : "getting fast-math flag on invalid op";
    return cast_FPMathOperator(this).hasNoNaNs();
  }

  
  /// Determine whether the no-infs flag is set.
  
  /// Determine whether the no-infs flag is set.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::hasNoInfs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 187,
   FQN="llvm::Instruction::hasNoInfs", NM="_ZNK4llvm11Instruction9hasNoInfsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction9hasNoInfsEv")
  //</editor-fold>
  public boolean hasNoInfs() /*const*/ {
    assert (isa_FPMathOperator(this)) : "getting fast-math flag on invalid op";
    return cast_FPMathOperator(this).hasNoInfs();
  }

  
  /// Determine whether the no-signed-zeros flag is set.
  
  /// Determine whether the no-signed-zeros flag is set.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::hasNoSignedZeros">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 193,
   FQN="llvm::Instruction::hasNoSignedZeros", NM="_ZNK4llvm11Instruction16hasNoSignedZerosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction16hasNoSignedZerosEv")
  //</editor-fold>
  public boolean hasNoSignedZeros() /*const*/ {
    assert (isa_FPMathOperator(this)) : "getting fast-math flag on invalid op";
    return cast_FPMathOperator(this).hasNoSignedZeros();
  }

  
  /// Determine whether the allow-reciprocal flag is set.
  
  /// Determine whether the allow-reciprocal flag is set.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::hasAllowReciprocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 199,
   FQN="llvm::Instruction::hasAllowReciprocal", NM="_ZNK4llvm11Instruction18hasAllowReciprocalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction18hasAllowReciprocalEv")
  //</editor-fold>
  public boolean hasAllowReciprocal() /*const*/ {
    assert (isa_FPMathOperator(this)) : "getting fast-math flag on invalid op";
    return cast_FPMathOperator(this).hasAllowReciprocal();
  }

  
  /// Convenience function for getting all the fast-math flags, which must be an
  /// operator which supports these flags. See LangRef.html for the meaning of
  /// these flags.
  
  /// Convenience function for getting all the fast-math flags, which must be an
  /// operator which supports these flags. See LangRef.html for the meaning of
  /// these flags.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::getFastMathFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 207,
   FQN="llvm::Instruction::getFastMathFlags", NM="_ZNK4llvm11Instruction16getFastMathFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction16getFastMathFlagsEv")
  //</editor-fold>
  public FastMathFlags getFastMathFlags() /*const*/ {
    assert (isa_FPMathOperator(this)) : "getting fast-math flag on invalid op";
    return cast_FPMathOperator(this).getFastMathFlags();
  }

  
  /// Copy I's fast-math flags
  
  /// Copy I's fast-math flags
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::copyFastMathFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 213,
   FQN="llvm::Instruction::copyFastMathFlags", NM="_ZN4llvm11Instruction17copyFastMathFlagsEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction17copyFastMathFlagsEPKS0_")
  //</editor-fold>
  public void copyFastMathFlags(/*const*/ Instruction /*P*/ I) {
    copyFastMathFlags(I.getFastMathFlags());
  }

  
  /// Convenience method to copy supported wrapping, exact, and fast-math flags
  /// from V to this instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::copyIRFlags">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 217,
   FQN="llvm::Instruction::copyIRFlags", NM="_ZN4llvm11Instruction11copyIRFlagsEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction11copyIRFlagsEPKNS_5ValueE")
  //</editor-fold>
  public void copyIRFlags(/*const*/ Value /*P*/ V) {
    {
      // Copy the wrapping flags.
      /*const*/ OverflowingBinaryOperator /*P*/ OB = dyn_cast_OverflowingBinaryOperator(V);
      if ((OB != null)) {
        if (isa_OverflowingBinaryOperator(this)) {
          setHasNoSignedWrap(OB.hasNoSignedWrap());
          setHasNoUnsignedWrap(OB.hasNoUnsignedWrap());
        }
      }
    }
    {
      
      // Copy the exact flag.
      /*const*/ PossiblyExactOperator /*P*/ PE = dyn_cast_PossiblyExactOperator(V);
      if ((PE != null)) {
        if (isa_PossiblyExactOperator(this)) {
          setIsExact(PE.isExact());
        }
      }
    }
    {
      
      // Copy the fast-math flags.
      /*const*/ FPMathOperator /*P*/ FP = dyn_cast_FPMathOperator(V);
      if ((FP != null)) {
        if (isa_FPMathOperator(this)) {
          copyFastMathFlags(FP.getFastMathFlags());
        }
      }
    }
    {
      
      /*const*/ GetElementPtrInst /*P*/ SrcGEP = dyn_cast_GetElementPtrInst(V);
      if ((SrcGEP != null)) {
        {
          GetElementPtrInst /*P*/ DestGEP = dyn_cast_GetElementPtrInst(this);
          if ((DestGEP != null)) {
            DestGEP.setIsInBounds(($bool2uint(SrcGEP.isInBounds()) | $bool2uint(DestGEP.isInBounds())) != 0);
          }
        }
      }
    }
  }

  
  /// Logical 'and' of any supported wrapping, exact, and fast-math flags of
  /// V and this instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::andIRFlags">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 241,
   FQN="llvm::Instruction::andIRFlags", NM="_ZN4llvm11Instruction10andIRFlagsEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction10andIRFlagsEPKNS_5ValueE")
  //</editor-fold>
  public void andIRFlags(/*const*/ Value /*P*/ V) {
    {
      /*const*/ OverflowingBinaryOperator /*P*/ OB = dyn_cast_OverflowingBinaryOperator(V);
      if ((OB != null)) {
        if (isa_OverflowingBinaryOperator(this)) {
          setHasNoSignedWrap(($bool2uint(hasNoSignedWrap()) & $bool2uint(OB.hasNoSignedWrap())) != 0);
          setHasNoUnsignedWrap(($bool2uint(hasNoUnsignedWrap()) & $bool2uint(OB.hasNoUnsignedWrap())) != 0);
        }
      }
    }
    {
      
      /*const*/ PossiblyExactOperator /*P*/ PE = dyn_cast_PossiblyExactOperator(V);
      if ((PE != null)) {
        if (isa_PossiblyExactOperator(this)) {
          setIsExact(($bool2uint(isExact()) & $bool2uint(PE.isExact())) != 0);
        }
      }
    }
    {
      
      /*const*/ FPMathOperator /*P*/ FP = dyn_cast_FPMathOperator(V);
      if ((FP != null)) {
        if (isa_FPMathOperator(this)) {
          FastMathFlags FM = getFastMathFlags();
          FM.$andassign(FP.getFastMathFlags());
          copyFastMathFlags(new FastMathFlags(FM));
        }
      }
    }
    {
      
      /*const*/ GetElementPtrInst /*P*/ SrcGEP = dyn_cast_GetElementPtrInst(V);
      if ((SrcGEP != null)) {
        {
          GetElementPtrInst /*P*/ DestGEP = dyn_cast_GetElementPtrInst(this);
          if ((DestGEP != null)) {
            DestGEP.setIsInBounds(($bool2uint(SrcGEP.isInBounds()) & $bool2uint(DestGEP.isInBounds())) != 0);
          }
        }
      }
    }
  }

/*private:*/
  /// Return true if we have an entry in the on-the-side metadata hash.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::hasMetadataHashEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 325,
   FQN="llvm::Instruction::hasMetadataHashEntry", NM="_ZNK4llvm11Instruction20hasMetadataHashEntryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction20hasMetadataHashEntryEv")
  //</editor-fold>
  private boolean hasMetadataHashEntry() /*const*/ {
    return ($ushort2int(getSubclassDataFromValue_Instruction()) & HasMetadataBit) != 0;
  }

  
  // These are all implemented in Metadata.cpp.
  
  // These are all implemented in Metadata.cpp.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::getMetadataImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1248,
   FQN="llvm::Instruction::getMetadataImpl", NM="_ZNK4llvm11Instruction15getMetadataImplEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm11Instruction15getMetadataImplEj")
  //</editor-fold>
  private MDNode /*P*/ getMetadataImpl(/*uint*/int KindID) /*const*/ {
    // Handle 'dbg' as a special case since it is not stored in the hash table.
    if (KindID == LLVMContext.Unnamed_enum.MD_dbg.getValue()) {
      return DbgLoc.getAsMDNode();
    }
    if (!hasMetadataHashEntry()) {
      return null;
    }
    final MDAttachmentMap /*&*/ Info = getContext().pImpl.InstructionMetadata.$at_T1$RR(this);
    assert (!Info.empty()) : "bit out of sync with hash table";
    
    return Info.lookup(KindID);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::getMetadataImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1171,
   FQN="llvm::Instruction::getMetadataImpl", NM="_ZNK4llvm11Instruction15getMetadataImplENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm11Instruction15getMetadataImplENS_9StringRefE")
  //</editor-fold>
  private MDNode /*P*/ getMetadataImpl(StringRef Kind) /*const*/ {
    return getMetadataImpl(getContext().getMDKindID(new StringRef(Kind)));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::getAllMetadataImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1261,
   FQN="llvm::Instruction::getAllMetadataImpl", NM="_ZNK4llvm11Instruction18getAllMetadataImplERNS_15SmallVectorImplISt4pairIjPNS_6MDNodeEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm11Instruction18getAllMetadataImplERNS_15SmallVectorImplISt4pairIjPNS_6MDNodeEEEE")
  //</editor-fold>
  private void getAllMetadataImpl(final SmallVectorImpl<std.pairUIntPtr<MDNode /*P*/ > > /*&*/ Result) /*const*/ {
    Result.clear();
    
    // Handle 'dbg' as a special case since it is not stored in the hash table.
    if (DbgLoc.$bool()) {
      Result.push_back(std.make_pair_uint_Ptr((/*uint*/int)LLVMContext.Unnamed_enum.MD_dbg.getValue(), DbgLoc.getAsMDNode()));
      if (!hasMetadataHashEntry()) {
        return;
      }
    }
    assert (hasMetadataHashEntry() && (getContext().pImpl.InstructionMetadata.count(this) != 0)) : "Shouldn't have called this";
    final /*const*/ MDAttachmentMap /*&*/ Info = getContext().pImpl.InstructionMetadata.find(this).$arrow().second;
    assert (!Info.empty()) : "Shouldn't have called this";
    Info.getAll(Result);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::getAllMetadataOtherThanDebugLocImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1280,
   FQN="llvm::Instruction::getAllMetadataOtherThanDebugLocImpl", NM="_ZNK4llvm11Instruction35getAllMetadataOtherThanDebugLocImplERNS_15SmallVectorImplISt4pairIjPNS_6MDNodeEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm11Instruction35getAllMetadataOtherThanDebugLocImplERNS_15SmallVectorImplISt4pairIjPNS_6MDNodeEEEE")
  //</editor-fold>
  private void getAllMetadataOtherThanDebugLocImpl(final SmallVectorImpl<std.pairUIntPtr<MDNode /*P*/ > > /*&*/ Result) /*const*/ {
    Result.clear();
    assert (hasMetadataHashEntry() && (getContext().pImpl.InstructionMetadata.count(this) != 0)) : "Shouldn't have called this";
    final /*const*/ MDAttachmentMap /*&*/ Info = getContext().pImpl.InstructionMetadata.find(this).$arrow().second;
    assert (!Info.empty()) : "Shouldn't have called this";
    Info.getAll(Result);
  }


  /// Clear all hashtable-based metadata from this instruction.
  /// Clear all hashtable-based metadata from this instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::clearMetadataHashEntries">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1341,
   FQN="llvm::Instruction::clearMetadataHashEntries", NM="_ZN4llvm11Instruction24clearMetadataHashEntriesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm11Instruction24clearMetadataHashEntriesEv")
  //</editor-fold>
  private void clearMetadataHashEntries() {
    assert (hasMetadataHashEntry()) : "Caller should check";
    getContext().pImpl.InstructionMetadata.erase(this);
    setHasMetadataHashEntry(false);
  }


/*public:*/
  //===--------------------------------------------------------------------===//
  // Predicates and helper methods.
  //===--------------------------------------------------------------------===//
  
  /// Return true if the instruction is associative:
  ///
  ///   Associative operators satisfy:  x op (y op z) === (x op y) op z
  ///
  /// In LLVM, the Add, Mul, And, Or, and Xor operators are associative.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isAssociative">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 567,
   FQN="llvm::Instruction::isAssociative", NM="_ZNK4llvm11Instruction13isAssociativeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction13isAssociativeEv")
  //</editor-fold>
  public boolean isAssociative() /*const*/ {
    /*uint*/int Opcode = getOpcode();
    if (isAssociative(Opcode)) {
      return true;
    }
    switch (Opcode) {
     case BinaryOps.FMul:
     case BinaryOps.FAdd:
      return cast_FPMathOperator(this).hasUnsafeAlgebra();
     default:
      return false;
    }
  }

  
  /// isAssociative - Return true if the instruction is associative:
  ///
  ///   Associative operators satisfy:  x op (y op z) === (x op y) op z
  ///
  /// In LLVM, the Add, Mul, And, Or, and Xor operators are associative.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isAssociative">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 562,
   FQN="llvm::Instruction::isAssociative", NM="_ZN4llvm11Instruction13isAssociativeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction13isAssociativeEj")
  //</editor-fold>
  public static boolean isAssociative(/*uint*/int Opcode) {
    return Opcode == BinaryOps.And || Opcode == BinaryOps.Or || Opcode == BinaryOps.Xor
       || Opcode == BinaryOps.Add || Opcode == BinaryOps.Mul;
  }

  
  /// Return true if the instruction is commutative:
  ///
  ///   Commutative operators satisfy: (x op y) === (y op x)
  ///
  /// In LLVM, these are the associative operators, plus SetEQ and SetNE, when
  /// applied to any type.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isCommutative">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 360,
   FQN="llvm::Instruction::isCommutative", NM="_ZNK4llvm11Instruction13isCommutativeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction13isCommutativeEv")
  //</editor-fold>
  public boolean isCommutative() /*const*/ {
    return isCommutative(getOpcode());
  }

  
  /// isCommutative - Return true if the instruction is commutative:
  ///
  ///   Commutative operators satisfy: (x op y) === (y op x)
  ///
  /// In LLVM, these are the associative operators, plus SetEQ and SetNE, when
  /// applied to any type.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isCommutative">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 588,
   FQN="llvm::Instruction::isCommutative", NM="_ZN4llvm11Instruction13isCommutativeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction13isCommutativeEj")
  //</editor-fold>
  public static boolean isCommutative(/*uint*/int op) {
    switch (op) {
     case BinaryOps.Add:
     case BinaryOps.FAdd:
     case BinaryOps.Mul:
     case BinaryOps.FMul:
     case BinaryOps.And:
     case BinaryOps.Or:
     case BinaryOps.Xor:
      return true;
     default:
      return false;
    }
  }

  
  /// Return true if the instruction is idempotent:
  ///
  ///   Idempotent operators satisfy:  x op x === x
  ///
  /// In LLVM, the And and Or operators are idempotent.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isIdempotent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 369,
   FQN="llvm::Instruction::isIdempotent", NM="_ZNK4llvm11Instruction12isIdempotentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction12isIdempotentEv")
  //</editor-fold>
  public boolean isIdempotent() /*const*/ {
    return isIdempotent(getOpcode());
  }

  
  /// isIdempotent - Return true if the instruction is idempotent:
  ///
  ///   Idempotent operators satisfy:  x op x === x
  ///
  /// In LLVM, the And and Or operators are idempotent.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isIdempotent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 609,
   FQN="llvm::Instruction::isIdempotent", NM="_ZN4llvm11Instruction12isIdempotentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction12isIdempotentEj")
  //</editor-fold>
  public static boolean isIdempotent(/*uint*/int Opcode) {
    return Opcode == BinaryOps.And || Opcode == BinaryOps.Or;
  }

  
  /// Return true if the instruction is nilpotent:
  ///
  ///   Nilpotent operators satisfy:  x op x === Id,
  ///
  ///   where Id is the identity for the operator, i.e. a constant such that
  ///     x op Id === x and Id op x === x for all x.
  ///
  /// In LLVM, the Xor operator is nilpotent.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isNilpotent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 381,
   FQN="llvm::Instruction::isNilpotent", NM="_ZNK4llvm11Instruction11isNilpotentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction11isNilpotentEv")
  //</editor-fold>
  public boolean isNilpotent() /*const*/ {
    return isNilpotent(getOpcode());
  }

  
  /// isNilpotent - Return true if the instruction is nilpotent:
  ///
  ///   Nilpotent operators satisfy:  x op x === Id,
  ///
  ///   where Id is the identity for the operator, i.e. a constant such that
  ///     x op Id === x and Id op x === x for all x.
  ///
  /// In LLVM, the Xor operator is nilpotent.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isNilpotent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 622,
   FQN="llvm::Instruction::isNilpotent", NM="_ZN4llvm11Instruction11isNilpotentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction11isNilpotentEj")
  //</editor-fold>
  public static boolean isNilpotent(/*uint*/int Opcode) {
    return Opcode == BinaryOps.Xor;
  }

  
  /// Return true if this instruction may modify memory.
  
  /// mayWriteToMemory - Return true if this instruction may modify memory.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::mayWriteToMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 511,
   FQN="llvm::Instruction::mayWriteToMemory", NM="_ZNK4llvm11Instruction16mayWriteToMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction16mayWriteToMemoryEv")
  //</editor-fold>
  public boolean mayWriteToMemory() /*const*/ {
    switch (getOpcode()) {
     default:
      return false;
     case Instruction.MemoryOps.Fence: // FIXME: refine definition of mayWriteToMemory
     case Instruction.MemoryOps.Store:
     case Instruction.OtherOps.VAArg:
     case Instruction.MemoryOps.AtomicCmpXchg:
     case Instruction.MemoryOps.AtomicRMW:
     case Instruction.FuncletPadOps.CatchPad:
     case Instruction.TermOps.CatchRet:
      return true;
     case Instruction.OtherOps.Call:
      return !cast_CallInst(this).onlyReadsMemory();
     case Instruction.TermOps.Invoke:
      return !cast_InvokeInst(this).onlyReadsMemory();
     case Instruction.MemoryOps.Load:
      return !cast_LoadInst(this).isUnordered();
    }
  }

  
  /// Return true if this instruction may read memory.
  
  /// mayReadFromMemory - Return true if this instruction may read memory.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::mayReadFromMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 489,
   FQN="llvm::Instruction::mayReadFromMemory", NM="_ZNK4llvm11Instruction17mayReadFromMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction17mayReadFromMemoryEv")
  //</editor-fold>
  public boolean mayReadFromMemory() /*const*/ {
    switch (getOpcode()) {
     default:
      return false;
     case Instruction.OtherOps.VAArg:
     case Instruction.MemoryOps.Load:
     case Instruction.MemoryOps.Fence: // FIXME: refine definition of mayReadFromMemory
     case Instruction.MemoryOps.AtomicCmpXchg:
     case Instruction.MemoryOps.AtomicRMW:
     case Instruction.FuncletPadOps.CatchPad:
     case Instruction.TermOps.CatchRet:
      return true;
     case Instruction.OtherOps.Call:
      return !cast_CallInst(this).doesNotAccessMemory();
     case Instruction.TermOps.Invoke:
      return !cast_InvokeInst(this).doesNotAccessMemory();
     case Instruction.MemoryOps.Store:
      return !cast_StoreInst(this).isUnordered();
    }
  }

  
  /// Return true if this instruction may read or write memory.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::mayReadOrWriteMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 391,
   FQN="llvm::Instruction::mayReadOrWriteMemory", NM="_ZNK4llvm11Instruction20mayReadOrWriteMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction20mayReadOrWriteMemoryEv")
  //</editor-fold>
  public boolean mayReadOrWriteMemory() /*const*/ {
    return mayReadFromMemory() || mayWriteToMemory();
  }

  
  /// Return true if this instruction has an AtomicOrdering of unordered or
  /// higher.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isAtomic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 531,
   FQN="llvm::Instruction::isAtomic", NM="_ZNK4llvm11Instruction8isAtomicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction8isAtomicEv")
  //</editor-fold>
  public boolean isAtomic() /*const*/ {
    switch (getOpcode()) {
     default:
      return false;
     case Instruction.MemoryOps.AtomicCmpXchg:
     case Instruction.MemoryOps.AtomicRMW:
     case Instruction.MemoryOps.Fence:
      return true;
     case Instruction.MemoryOps.Load:
      return cast_LoadInst(this).getOrdering() != AtomicOrdering.NotAtomic;
     case Instruction.MemoryOps.Store:
      return cast_StoreInst(this).getOrdering() != AtomicOrdering.NotAtomic;
    }
  }

  
  /// Return true if this instruction may throw an exception.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::mayThrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 546,
   FQN="llvm::Instruction::mayThrow", NM="_ZNK4llvm11Instruction8mayThrowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction8mayThrowEv")
  //</editor-fold>
  public boolean mayThrow() /*const*/ {
    {
      /*const*/ CallInst /*P*/ CI = dyn_cast_CallInst(this);
      if ((CI != null)) {
        return !CI.doesNotThrow();
      }
    }
    {
      /*const*/ CleanupReturnInst /*P*/ CRI = dyn_cast_CleanupReturnInst(this);
      if ((CRI != null)) {
        return CRI.unwindsToCaller();
      }
    }
    {
      /*const*/ CatchSwitchInst /*P*/ CatchSwitch = dyn_cast_CatchSwitchInst(this);
      if ((CatchSwitch != null)) {
        return CatchSwitch.unwindsToCaller();
      }
    }
    return isa_ResumeInst(this);
  }

  
  /// Return true if this instruction behaves like a memory fence: it can load
  /// or store to memory location without being given a memory location.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isFenceLike">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 404,
   FQN="llvm::Instruction::isFenceLike", NM="_ZNK4llvm11Instruction11isFenceLikeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction11isFenceLikeEv")
  //</editor-fold>
  public boolean isFenceLike() /*const*/ {
    switch (getOpcode()) {
     default:
      return false;
     case Instruction.MemoryOps.Fence:
     case Instruction.FuncletPadOps.CatchPad:
     case Instruction.TermOps.CatchRet:
     case Instruction.OtherOps.Call:
     case Instruction.TermOps.Invoke:
      // This list should be kept in sync with the list in mayWriteToMemory for
      // all opcodes which don't have a memory location.
      return true;
    }
  }

  
  /// Return true if the instruction may have side effects.
  ///
  /// Note that this does not consider malloc and alloca to have side
  /// effects because the newly allocated memory is completely invisible to
  /// instructions which don't use the returned value.  For cases where this
  /// matters, isSafeToSpeculativelyExecute may be more appropriate.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::mayHaveSideEffects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 425,
   FQN="llvm::Instruction::mayHaveSideEffects", NM="_ZNK4llvm11Instruction18mayHaveSideEffectsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction18mayHaveSideEffectsEv")
  //</editor-fold>
  public boolean mayHaveSideEffects() /*const*/ {
    return mayWriteToMemory() || mayThrow();
  }

  
  /// Return true if the instruction is a variety of EH-block.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isEHPad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 428,
   FQN="llvm::Instruction::isEHPad", NM="_ZNK4llvm11Instruction7isEHPadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction7isEHPadEv")
  //</editor-fold>
  public boolean isEHPad() /*const*/ {
    switch (getOpcode()) {
     case Instruction.TermOps.CatchSwitch:
     case Instruction.FuncletPadOps.CatchPad:
     case Instruction.FuncletPadOps.CleanupPad:
     case Instruction.OtherOps.LandingPad:
      return true;
     default:
      return false;
    }
  }

  
  /// Create a copy of 'this' instruction that is identical in all ways except
  /// the following:
  ///   * The instruction has no parent
  ///   * The instruction has no name
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 630,
   FQN="llvm::Instruction::clone", NM="_ZNK4llvm11Instruction5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction5cloneEv")
  //</editor-fold>
  public Instruction /*P*/ clone() /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Instruction /*P*/ New = null;
      switch (getOpcode()) {
       default:
        throw new llvm_unreachable("Unhandled Opcode.");
       case Instruction.TermOps.Ret:
        New = cast_ReturnInst(this).cloneImpl();
        break;
       case Instruction.TermOps.Br:
        New = cast_BranchInst(this).cloneImpl();
        break;
       case Instruction.TermOps.Switch:
        New = cast_SwitchInst(this).cloneImpl();
        break;
       case Instruction.TermOps.IndirectBr:
        New = cast_IndirectBrInst(this).cloneImpl();
        break;
       case Instruction.TermOps.Invoke:
        New = cast_InvokeInst(this).cloneImpl();
        break;
       case Instruction.TermOps.Resume:
        New = cast_ResumeInst(this).cloneImpl();
        break;
       case Instruction.TermOps.Unreachable:
        New = cast_UnreachableInst(this).cloneImpl();
        break;
       case Instruction.TermOps.CleanupRet:
        New = cast_CleanupReturnInst(this).cloneImpl();
        break;
       case Instruction.TermOps.CatchRet:
        New = cast_CatchReturnInst(this).cloneImpl();
        break;
       case Instruction.TermOps.CatchSwitch:
        New = cast_CatchSwitchInst(this).cloneImpl();
        break;
       case Instruction.BinaryOps.Add:
        New = cast_BinaryOperator(this).cloneImpl();
        break;
       case Instruction.BinaryOps.FAdd:
        New = cast_BinaryOperator(this).cloneImpl();
        break;
       case Instruction.BinaryOps.Sub:
        New = cast_BinaryOperator(this).cloneImpl();
        break;
       case Instruction.BinaryOps.FSub:
        New = cast_BinaryOperator(this).cloneImpl();
        break;
       case Instruction.BinaryOps.Mul:
        New = cast_BinaryOperator(this).cloneImpl();
        break;
       case Instruction.BinaryOps.FMul:
        New = cast_BinaryOperator(this).cloneImpl();
        break;
       case Instruction.BinaryOps.UDiv:
        New = cast_BinaryOperator(this).cloneImpl();
        break;
       case Instruction.BinaryOps.SDiv:
        New = cast_BinaryOperator(this).cloneImpl();
        break;
       case Instruction.BinaryOps.FDiv:
        New = cast_BinaryOperator(this).cloneImpl();
        break;
       case Instruction.BinaryOps.URem:
        New = cast_BinaryOperator(this).cloneImpl();
        break;
       case Instruction.BinaryOps.SRem:
        New = cast_BinaryOperator(this).cloneImpl();
        break;
       case Instruction.BinaryOps.FRem:
        New = cast_BinaryOperator(this).cloneImpl();
        break;
       case Instruction.BinaryOps.Shl: // Shift left  (logical)
        
        // Logical operators (integer operands)
        New = cast_BinaryOperator(this).cloneImpl();
        break;
       case Instruction.BinaryOps.LShr: // Shift right (logical)
        New = cast_BinaryOperator(this).cloneImpl();
        break;
       case Instruction.BinaryOps.AShr: // Shift right (arithmetic)
        New = cast_BinaryOperator(this).cloneImpl();
        break;
       case Instruction.BinaryOps.And:
        New = cast_BinaryOperator(this).cloneImpl();
        break;
       case Instruction.BinaryOps.Or:
        New = cast_BinaryOperator(this).cloneImpl();
        break;
       case Instruction.BinaryOps.Xor:
        New = cast_BinaryOperator(this).cloneImpl();
        break;
       case Instruction.MemoryOps.Alloca: // Stack management
        New = cast_AllocaInst(this).cloneImpl();
        break;
       case Instruction.MemoryOps.Load: // Memory manipulation instrs
        New = cast_LoadInst(this).cloneImpl();
        break;
       case Instruction.MemoryOps.Store:
        New = cast_StoreInst(this).cloneImpl();
        break;
       case Instruction.MemoryOps.GetElementPtr:
        New = cast_GetElementPtrInst(this).cloneImpl();
        break;
       case Instruction.MemoryOps.Fence:
        New = cast_FenceInst(this).cloneImpl();
        break;
       case Instruction.MemoryOps.AtomicCmpXchg:
        New = cast_AtomicCmpXchgInst(this).cloneImpl();
        break;
       case Instruction.MemoryOps.AtomicRMW:
        New = cast_AtomicRMWInst(this).cloneImpl();
        break;
       case Instruction.CastOps.Trunc: // Truncate integers
        New = cast_TruncInst(this).cloneImpl();
        break;
       case Instruction.CastOps.ZExt: // Zero extend integers
        New = cast_ZExtInst(this).cloneImpl();
        break;
       case Instruction.CastOps.SExt: // Sign extend integers
        New = cast_SExtInst(this).cloneImpl();
        break;
       case Instruction.CastOps.FPToUI: // floating point -> UInt
        New = cast_FPToUIInst(this).cloneImpl();
        break;
       case Instruction.CastOps.FPToSI: // floating point -> SInt
        New = cast_FPToSIInst(this).cloneImpl();
        break;
       case Instruction.CastOps.UIToFP: // UInt -> floating point
        New = cast_UIToFPInst(this).cloneImpl();
        break;
       case Instruction.CastOps.SIToFP: // SInt -> floating point
        New = cast_SIToFPInst(this).cloneImpl();
        break;
       case Instruction.CastOps.FPTrunc: // Truncate floating point
        New = cast_FPTruncInst(this).cloneImpl();
        break;
       case Instruction.CastOps.FPExt: // Extend floating point
        New = cast_FPExtInst(this).cloneImpl();
        break;
       case Instruction.CastOps.PtrToInt: // Pointer -> Integer
        New = cast_PtrToIntInst(this).cloneImpl();
        break;
       case Instruction.CastOps.IntToPtr: // Integer -> Pointer
        New = cast_IntToPtrInst(this).cloneImpl();
        break;
       case Instruction.CastOps.BitCast: // Type cast
        New = cast_BitCastInst(this).cloneImpl();
        break;
       case Instruction.CastOps.AddrSpaceCast: // addrspace cast
        New = cast_AddrSpaceCastInst(this).cloneImpl();
        break;
       case Instruction.FuncletPadOps.CleanupPad:
        New = cast_CleanupPadInst(this).cloneImpl();
        break;
       case Instruction.FuncletPadOps.CatchPad:
        New = cast_CatchPadInst(this).cloneImpl();
        break;
       case Instruction.OtherOps.ICmp: // Integer comparison instruction
        New = cast_ICmpInst(this).cloneImpl();
        break;
       case Instruction.OtherOps.FCmp: // Floating point comparison instr.
        New = cast_FCmpInst(this).cloneImpl();
        break;
       case Instruction.OtherOps.PHI: // PHI node instruction
        New = cast_PHINode(this).cloneImpl();
        break;
       case Instruction.OtherOps.Call: // Call a function
        New = cast_CallInst(this).cloneImpl();
        break;
       case Instruction.OtherOps.Select: // select instruction
        New = cast_SelectInst(this).cloneImpl();
        break;
       case Instruction.OtherOps.UserOp1: // May be used internally in a pass
        New = cast_Instruction(this).cloneImpl();
        break;
       case Instruction.OtherOps.UserOp2: // Internal to passes only
        New = cast_Instruction(this).cloneImpl();
        break;
       case Instruction.OtherOps.VAArg: // vaarg instruction
        New = cast_VAArgInst(this).cloneImpl();
        break;
       case Instruction.OtherOps.ExtractElement: // extract from vector
        New = cast_ExtractElementInst(this).cloneImpl();
        break;
       case Instruction.OtherOps.InsertElement: // insert into vector
        New = cast_InsertElementInst(this).cloneImpl();
        break;
       case Instruction.OtherOps.ShuffleVector: // shuffle two vectors.
        New = cast_ShuffleVectorInst(this).cloneImpl();
        break;
       case Instruction.OtherOps.ExtractValue: // extract from aggregate
        New = cast_ExtractValueInst(this).cloneImpl();
        break;
       case Instruction.OtherOps.InsertValue: // insert into aggregate
        New = cast_InsertValueInst(this).cloneImpl();
        break;
       case Instruction.OtherOps.LandingPad: // Landing pad instruction.
        New = cast_LandingPadInst(this).cloneImpl();
        break;
      }
      
      New.SubclassOptionalData = $uchar2uchar_7bits($7bits_uchar2uchar(SubclassOptionalData));
      if (!hasMetadata()) {
        return New;
      }
      
      // Otherwise, enumerate and copy over metadata from the old instruction to the
      // new one.
      SmallVector<std.pairUIntPtr<MDNode /*P*/ >> TheMDs/*J*/= new SmallVector<std.pairUIntPtr<MDNode /*P*/ >>(4, new std.pairUIntPtr<MDNode /*P*/ >());
      getAllMetadataOtherThanDebugLoc(TheMDs);
      for (final /*const*/std.pairUIntPtr<MDNode /*P*/ > /*&*/ MD : TheMDs)  {
        New.setMetadata(MD.first, MD.second);
      }
      
      New.setDebugLoc($c$.track(new DebugLoc(getDebugLoc()))); $c$.clean();
      return New;
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Return true if the specified instruction is exactly identical to the
  /// current one. This means that all operands match and any extra information
  /// (e.g. load is volatile) agree.
  
  /// isIdenticalTo - Return true if the specified instruction is exactly
  /// identical to the current one.  This means that all operands match and any
  /// extra information (e.g. load is volatile) agree.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isIdenticalTo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 408,
   FQN="llvm::Instruction::isIdenticalTo", NM="_ZNK4llvm11Instruction13isIdenticalToEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction13isIdenticalToEPKS0_")
  //</editor-fold>
  public boolean isIdenticalTo(/*const*/ Instruction /*P*/ I) /*const*/ {
    return isIdenticalToWhenDefined(I)
       && $uchar2int($7bits_uchar2uchar(SubclassOptionalData)) == $uchar2int($7bits_uchar2uchar(I.SubclassOptionalData));
  }

  
  /// This is like isIdenticalTo, except that it ignores the
  /// SubclassOptionalData flags, which specify conditions under which the
  /// instruction's result is undefined.
  
  /// isIdenticalToWhenDefined - This is like isIdenticalTo, except that it
  /// ignores the SubclassOptionalData flags, which specify conditions
  /// under which the instruction's result is undefined.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isIdenticalToWhenDefined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 416,
   FQN="llvm::Instruction::isIdenticalToWhenDefined", NM="_ZNK4llvm11Instruction24isIdenticalToWhenDefinedEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction24isIdenticalToWhenDefinedEPKS0_")
  //</editor-fold>
  public boolean isIdenticalToWhenDefined(/*const*/ Instruction /*P*/ I) /*const*/ {
    if (getOpcode() != I.getOpcode()
       || getNumOperands() != I.getNumOperands()
       || getType() != I.getType()) {
      return false;
    }
    
    // If both instructions have no operands, they are identical.
    if (getNumOperands() == 0 && I.getNumOperands() == 0) {
      return InstructionStatics.haveSameSpecialState(this, I);
    }
    
    // We have two instructions of identical opcode and #operands.  Check to see
    // if all operands are the same.
    if (!std.equal(op_begin$Const(), op_end$Const(), I.op_begin$Const())) {
      return false;
    }
    {
      
      /*const*/ PHINode /*P*/ thisPHI = dyn_cast_PHINode(this);
      if ((thisPHI != null)) {
        /*const*/ PHINode /*P*/ otherPHI = cast_PHINode(I);
        return std.equal(thisPHI.block_begin$Const(), thisPHI.block_end$Const(), 
            otherPHI.block_begin$Const());
      }
    }
    
    return InstructionStatics.haveSameSpecialState(this, I);
  }

  
  /// When checking for operation equivalence (using isSameOperationAs) it is
  /// sometimes useful to ignore certain attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::OperationEquivalenceFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 459,
   FQN="llvm::Instruction::OperationEquivalenceFlags", NM="_ZN4llvm11Instruction25OperationEquivalenceFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction25OperationEquivalenceFlagsE")
  //</editor-fold>
  public static final class/*enum*/ OperationEquivalenceFlags {
    /// Check for equivalence ignoring load/store alignment.
    public static final /*uint*/int CompareIgnoringAlignment = 1 << 0;
    /// Check for equivalence treating a type and a vector of that type
    /// as equivalent.
    public static final /*uint*/int CompareUsingScalarTypes = 1 << 1;
  };
  
  /// This function determines if the specified instruction executes the same
  /// operation as the current one. This means that the opcodes, type, operand
  /// types and any other factors affecting the operation must be the same. This
  /// is similar to isIdenticalTo except the operands themselves don't have to
  /// be identical.
  /// @returns true if the specified instruction is the same operation as
  /// the current one.
  /// @brief Determine if one instruction is the same operation as another.
  
  // Keep this in sync with FunctionComparator::cmpOperations in
  // lib/Transforms/IPO/MergeFunctions.cpp.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isSameOperationAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 442,
   FQN="llvm::Instruction::isSameOperationAs", NM="_ZNK4llvm11Instruction17isSameOperationAsEPKS0_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction17isSameOperationAsEPKS0_j")
  //</editor-fold>
  public boolean isSameOperationAs(/*const*/ Instruction /*P*/ I) /*const*/ {
    return isSameOperationAs(I, 
                   0);
  }
  public boolean isSameOperationAs(/*const*/ Instruction /*P*/ I, 
                   /*uint*/int flags/*= 0*/) /*const*/ {
    boolean IgnoreAlignment = ((flags & OperationEquivalenceFlags.CompareIgnoringAlignment) != 0);
    boolean UseScalarTypes = ((flags & OperationEquivalenceFlags.CompareUsingScalarTypes) != 0);
    if (getOpcode() != I.getOpcode()
       || getNumOperands() != I.getNumOperands()
       || (UseScalarTypes ? getType().getScalarType() != I.getType().getScalarType() : getType() != I.getType())) {
      return false;
    }
    
    // We have two instructions of identical opcode and #operands.  Check to see
    // if all operands are the same type
    for (/*uint*/int i = 0, e = getNumOperands(); i != e; ++i)  {
      if (UseScalarTypes ? getOperand(i).getType().getScalarType()
         != I.getOperand(i).getType().getScalarType() : getOperand(i).getType() != I.getOperand(i).getType()) {
        return false;
      }
    }
    
    return InstructionStatics.haveSameSpecialState(this, I, IgnoreAlignment);
  }

  
  /// Return true if there are any uses of this instruction in blocks other than
  /// the specified block. Note that PHI nodes are considered to evaluate their
  /// operands in the corresponding predecessor block.
  
  /// isUsedOutsideOfBlock - Return true if there are any uses of I outside of the
  /// specified block.  Note that PHI nodes are considered to evaluate their
  /// operands in the corresponding predecessor block.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::isUsedOutsideOfBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 469,
   FQN="llvm::Instruction::isUsedOutsideOfBlock", NM="_ZNK4llvm11Instruction20isUsedOutsideOfBlockEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction20isUsedOutsideOfBlockEPKNS_10BasicBlockE")
  //</editor-fold>
  public boolean isUsedOutsideOfBlock(/*const*/ BasicBlock /*P*/ BB) /*const*/ {
    for (final /*const*/ Use /*&*/ U : uses$Const()) {
      // PHI nodes uses values in the corresponding predecessor block.  For other
      // instructions, just check to see whether the parent of the use matches up.
      /*const*/ Instruction /*P*/ I = cast_Instruction(U.getUser());
      /*const*/ PHINode /*P*/ PN = dyn_cast_PHINode(I);
      if (!(PN != null)) {
        if (I.getParent$Const() != BB) {
          return true;
        }
        continue;
      }
      if (PN.getIncomingBlock(U) != BB) {
        return true;
      }
    }
    return false;
  }

  
  /// Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 484,
   FQN="llvm::Instruction::classof", NM="_ZN4llvm11Instruction7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return $greatereq_uint(V.getValueID(), Value.ValueTy.InstructionVal.getValue());
  }

  
  //----------------------------------------------------------------------
  // Exported enumerations.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::TermOps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 491,
   FQN="llvm::Instruction::TermOps", NM="_ZN4llvm11Instruction7TermOpsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction7TermOpsE")
  //</editor-fold>
  public static final class/*enum*/ TermOps {
    
    // Terminator Instructions - These instructions are used to terminate a basic
    // block of the program.   Every basic block must end with one of these
    // instructions for it to be a well formed basic block.
    //
    public static final int TermOpsBegin = 1;
    public static final int Ret = 1;
    public static final int Br = 2;
    public static final int Switch = 3;
    public static final int IndirectBr = 4;
    public static final int Invoke = 5;
    public static final int Resume = 6;
    public static final int Unreachable = 7;
    public static final int CleanupRet = 8;
    public static final int CatchRet = 9;
    public static final int CatchSwitch = 10;
    public static final int TermOpsEnd = 10 + 1;
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::BinaryOps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 498,
   FQN="llvm::Instruction::BinaryOps", NM="_ZN4llvm11Instruction9BinaryOpsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction9BinaryOpsE")
  //</editor-fold>
  public static final class/*enum*/ BinaryOps {
    
    // Standard binary operators...
    public static final int BinaryOpsBegin = 11;
    public static final int Add = 11;
    public static final int FAdd = 12;
    public static final int Sub = 13;
    public static final int FSub = 14;
    public static final int Mul = 15;
    public static final int FMul = 16;
    public static final int UDiv = 17;
    public static final int SDiv = 18;
    public static final int FDiv = 19;
    public static final int URem = 20;
    public static final int SRem = 21;
    public static final int FRem = 22;
    
    // Logical operators (integer operands)
    public static final int Shl = 23;
    // Shift left  (logical)
    public static final int LShr = 24;
    // Shift right (logical)
    public static final int AShr = 25;
    // Shift right (arithmetic)
    public static final int And = 26;
    public static final int Or = 27;
    public static final int Xor = 28;
    public static final int BinaryOpsEnd = 28 + 1;
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::MemoryOps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 505,
   FQN="llvm::Instruction::MemoryOps", NM="_ZN4llvm11Instruction9MemoryOpsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction9MemoryOpsE")
  //</editor-fold>
  public static final class/*enum*/ MemoryOps {
    
    // Memory operators...
    public static final int MemoryOpsBegin = 29;
    public static final int Alloca = 29;
    // Stack management
    public static final int Load = 30;
    // Memory manipulation instrs
    public static final int Store = 31;
    public static final int GetElementPtr = 32;
    public static final int Fence = 33;
    public static final int AtomicCmpXchg = 34;
    public static final int AtomicRMW = 35;
    public static final int MemoryOpsEnd = 35 + 1;
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::CastOps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 512,
   FQN="llvm::Instruction::CastOps", NM="_ZN4llvm11Instruction7CastOpsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction7CastOpsE")
  //</editor-fold>
  public static final class/*enum*/ CastOps {
    
    // Cast operators ...
    // NOTE: The order matters here because CastInst::isEliminableCastPair
    // NOTE: (see Instructions.cpp) encodes a table based on this ordering.
    public static final int CastOpsBegin = 36;
    public static final int Trunc = 36;
    // Truncate integers
    public static final int ZExt = 37;
    // Zero extend integers
    public static final int SExt = 38;
    // Sign extend integers
    public static final int FPToUI = 39;
    // floating point -> UInt
    public static final int FPToSI = 40;
    // floating point -> SInt
    public static final int UIToFP = 41;
    // UInt -> floating point
    public static final int SIToFP = 42;
    // SInt -> floating point
    public static final int FPTrunc = 43;
    // Truncate floating point
    public static final int FPExt = 44;
    // Extend floating point
    public static final int PtrToInt = 45;
    // Pointer -> Integer
    public static final int IntToPtr = 46;
    // Integer -> Pointer
    public static final int BitCast = 47;
    // Type cast
    public static final int AddrSpaceCast = 48;
    // addrspace cast
    public static final int CastOpsEnd = 48 + 1;
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::FuncletPadOps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 519,
   FQN="llvm::Instruction::FuncletPadOps", NM="_ZN4llvm11Instruction13FuncletPadOpsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction13FuncletPadOpsE")
  //</editor-fold>
  public static final class/*enum*/ FuncletPadOps {
    public static final int FuncletPadOpsBegin = 49;
    public static final int CleanupPad = 49;
    public static final int CatchPad = 50;
    public static final int FuncletPadOpsEnd = 50 + 1;
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::OtherOps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 526,
   FQN="llvm::Instruction::OtherOps", NM="_ZN4llvm11Instruction8OtherOpsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction8OtherOpsE")
  //</editor-fold>
  public static final class/*enum*/ OtherOps {
    
    // Other operators...
    public static final int OtherOpsBegin = 51;
    public static final int ICmp = 51;
    // Integer comparison instruction
    public static final int FCmp = 52;
    // Floating point comparison instr.
    public static final int PHI = 53;
    // PHI node instruction
    public static final int Call = 54;
    // Call a function
    public static final int Select = 55;
    // select instruction
    public static final int UserOp1 = 56;
    // May be used internally in a pass
    public static final int UserOp2 = 57;
    // Internal to passes only
    public static final int VAArg = 58;
    // vaarg instruction
    public static final int ExtractElement = 59;
    // extract from vector
    public static final int InsertElement = 60;
    // insert into vector
    public static final int ShuffleVector = 61;
    // shuffle two vectors.
    public static final int ExtractValue = 62;
    // extract from aggregate
    public static final int InsertValue = 63;
    // insert into aggregate
    public static final int LandingPad = 64;
    // Landing pad instruction.
    public static final int OtherOpsEnd = 64 + 1;
  };
/*private:*/
  // Shadow Value::setValueSubclassData with a private forwarding method so that
  // subclasses cannot accidentally use it.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::setValueSubclassData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 535,
   FQN="llvm::Instruction::setValueSubclassData", NM="_ZN4llvm11Instruction20setValueSubclassDataEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction20setValueSubclassDataEt")
  //</editor-fold>
  private void setValueSubclassData_Instruction(/*ushort*/char D) {
    super.setValueSubclassData(D);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::getSubclassDataFromValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 538,
   FQN="llvm::Instruction::getSubclassDataFromValue", NM="_ZNK4llvm11Instruction24getSubclassDataFromValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction24getSubclassDataFromValueEv")
  //</editor-fold>
  private /*ushort*/char getSubclassDataFromValue_Instruction() /*const*/ {
    return super.getSubclassDataFromValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::setHasMetadataHashEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 542,
   FQN="llvm::Instruction::setHasMetadataHashEntry", NM="_ZN4llvm11Instruction23setHasMetadataHashEntryEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction23setHasMetadataHashEntryEb")
  //</editor-fold>
  private void setHasMetadataHashEntry(boolean V) {
    setValueSubclassData_Instruction($int2ushort(($ushort2int(getSubclassDataFromValue_Instruction()) & ~HasMetadataBit)
           | (V ? HasMetadataBit : 0)));
  }

  
  /*friend  class SymbolTableListTraits<Instruction>*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::setParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 53,
   FQN="llvm::Instruction::setParent", NM="_ZN4llvm11Instruction9setParentEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction9setParentEPNS_10BasicBlockE")
  //</editor-fold>
  public /*friend*//*private*/ void setParent(BasicBlock /*P*/ P) {
    Parent = P;
  }

/*protected:*/
  // Instruction subclasses can stick up to 15 bits of stuff into the
  // SubclassData field of instruction with these members.
  
  // Verify that only the low 15 bits are used.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::setInstructionSubclassData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 554,
   FQN="llvm::Instruction::setInstructionSubclassData", NM="_ZN4llvm11Instruction26setInstructionSubclassDataEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11Instruction26setInstructionSubclassDataEt")
  //</editor-fold>
  protected void setInstructionSubclassData(/*ushort*/char D) {
    assert (($ushort2int(D) & HasMetadataBit) == 0) : "Out of range value put into field";
    setValueSubclassData_Instruction($int2ushort(($ushort2int(getSubclassDataFromValue_Instruction()) & HasMetadataBit) | $ushort2int(D)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::getSubclassDataFromInstruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.h", line = 559,
   FQN="llvm::Instruction::getSubclassDataFromInstruction", NM="_ZNK4llvm11Instruction30getSubclassDataFromInstructionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction30getSubclassDataFromInstructionEv")
  //</editor-fold>
  protected /*uint*/int getSubclassDataFromInstruction() /*const*/ {
    return $ushort2int(getSubclassDataFromValue_Instruction()) & ~HasMetadataBit;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::Instruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 23,
   FQN="llvm::Instruction::Instruction", NM="_ZN4llvm11InstructionC1EPNS_4TypeEjPNS_3UseEjPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11InstructionC1EPNS_4TypeEjPNS_3UseEjPS0_")
  //</editor-fold>
  protected Instruction(Type /*P*/ ty, /*uint*/int it, type$ptr<Use /*P*/> Ops, /*uint*/int NumOps) {
    this(ty, it, Ops, NumOps, 
      (Instruction /*P*/ )null);
  }
  protected Instruction(Type /*P*/ ty, /*uint*/int it, type$ptr<Use /*P*/> Ops, /*uint*/int NumOps, 
      Instruction /*P*/ InsertBefore/*= null*/) {
    // : User(ty, Value::InstructionVal + it, Ops, NumOps), ilist_node_with_parent<Instruction, BasicBlock>(), Parent(null), DbgLoc() 
    //START JInit
    super(ty, Value.ValueTy.InstructionVal.getValue() + it, Ops, NumOps);
    this.ilist_node$Flds = $ilist_node_with_parent();
    this.Parent = null;
    this.DbgLoc = new DebugLoc();
    //END JInit
    
    // If requested, insert this instruction into a basic block...
    if ((InsertBefore != null)) {
      BasicBlock /*P*/ BB = InsertBefore.getParent();
      assert ((BB != null)) : "Instruction to insert before is not in a basic block!";
      BB.getInstList().insert_ilist_iterator$NodeTy_T$P(InsertBefore.getIterator(), this);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::Instruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 35,
   FQN="llvm::Instruction::Instruction", NM="_ZN4llvm11InstructionC1EPNS_4TypeEjPNS_3UseEjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZN4llvm11InstructionC1EPNS_4TypeEjPNS_3UseEjPNS_10BasicBlockE")
  //</editor-fold>
  protected Instruction(Type /*P*/ ty, /*uint*/int it, type$ptr<Use /*P*/> Ops, /*uint*/int NumOps, 
      BasicBlock /*P*/ InsertAtEnd) {
    // : User(ty, Value::InstructionVal + it, Ops, NumOps), ilist_node_with_parent<Instruction, BasicBlock>(), Parent(null), DbgLoc() 
    //START JInit
    super(ty, Value.ValueTy.InstructionVal.getValue() + it, Ops, NumOps);
    this.ilist_node$Flds = $ilist_node_with_parent();
    this.Parent = null;
    this.DbgLoc = new DebugLoc();
    //END JInit
    
    // append this instruction into the basic block
    assert ((InsertAtEnd != null)) : "Basic block to append to may not be NULL!";
    InsertAtEnd.getInstList().push_back(this);
  }

/*private:*/
  /// Create a copy of this instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::Instruction::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 626,
   FQN="llvm::Instruction::cloneImpl", NM="_ZNK4llvm11Instruction9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZNK4llvm11Instruction9cloneImplEv")
  //</editor-fold>
  private Instruction /*P*/ cloneImpl() /*const*/ {
    throw new llvm_unreachable("Subclass of Instruction failed to implement cloneImpl");
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected Instruction() {
    this.ilist_node$Flds = $ilist_node_with_parent();
  }
  
  public static Instruction $createSentinel() {
    return User.<Instruction>$new_FixedUses(0, (type$ptr<?> New$Mem)-> new Instruction());
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  private final ilist_node$Fields ilist_node$Flds;// use return value of $ilist_node_with_parent();
  @Override public final ilist_node$Fields $ilist_node$Fields() { return ilist_node$Flds; }
  
  @Override public String toString() {
    return "" + "Parent=" + Parent // NOI18N
              + ", DbgLoc=" + DbgLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
