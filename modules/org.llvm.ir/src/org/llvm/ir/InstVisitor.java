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
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.ir.intrinsic.*;


/// @brief Base class for instruction visitors
///
/// Instruction visitors are used when you want to perform different actions
/// for different kinds of instructions without having to use lots of casts
/// and a big switch statement (in your code, that is).
///
/// To define your own visitor, inherit from this class, specifying your
/// new type for the 'SubClass' template parameter, and "override" visitXXX
/// functions in your class. I say "override" because this class is defined
/// in terms of statically resolved overloading, not virtual functions.
///
/// For example, here is a visitor that counts the number of malloc
/// instructions processed:
///
///  /// Declare the class.  Note that we derive from InstVisitor instantiated
///  /// with _our new subclasses_ type.
///  ///
///  struct CountAllocaVisitor : public InstVisitor<CountAllocaVisitor> {
///    unsigned Count;
///    CountAllocaVisitor() : Count(0) {}
///
///    void visitAllocaInst(AllocaInst &AI) { ++Count; }
///  };
///
///  And this class would be used like this:
///    CountAllocaVisitor CAV;
///    CAV.visit(function);
///    NumAllocas = CAV.Count;
///
/// The defined has 'visit' methods for Instruction, and also for BasicBlock,
/// Function, and Module, which recursively process all contained instructions.
///
/// Note that if you don't implement visitXXX for some instruction type,
/// the visitXXX method for instruction superclass will be invoked. So
/// if instructions are added in the future, they will be automatically
/// supported, if you handle one of their superclasses.
///
/// The optional second template argument specifies the type that instruction
/// visitation functions should return. If you specify this, you *MUST* provide
/// an implementation of visitInstruction though!.
///
/// Note that this class is specifically designed as a template to avoid
/// virtual function call overhead.  Defining and using an InstVisitor is just
/// as efficient as having your own switch statement over the instruction
/// opcode.
/*template <typename SubClass, typename RetTy = void> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 80,
 FQN="llvm::InstVisitor", NM="_ZN4llvm11InstVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitorE")
//</editor-fold>
public interface/*class*/ InstVisitor</*typename*/ SubClass extends InstVisitor<SubClass, RetTy>, /*typename*/ RetTy/* = void*/>  {
//===--------------------------------------------------------------------===//
  // Interface code - This is the public interface of the InstVisitor that you
  // use to visit instructions...
  //
  /*public:*/
  // Generic visit method - Allow visitation to all instructions in a range
  /*template <class Iterator> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visit">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 90,
   FQN="llvm::InstVisitor::visit", NM="Tpl__ZN4llvm11InstVisitor5visitET_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=Tpl__ZN4llvm11InstVisitor5visitET_S1_")
  //</editor-fold>
  public default/*interface*/ </*class*/ Iterator extends ilist_iterator<Function>> void visit_Functions(Iterator Start, Iterator End) {
    while (Native.$noteq_iter(Start, End)) {
      ((/*static_cast*/SubClass /*P*/ )(this)).visit_Function($Deref(Start.$postInc()));
    }
  }
  public default/*interface*/ </*class*/ Iterator extends ilist_iterator<BasicBlock>> void visit_BasicBlocks(Iterator Start, Iterator End) {
    while (Native.$noteq_iter(Start, End)) {
      ((/*static_cast*/SubClass /*P*/ )(this)).visit_BasicBlock($Deref(Start.$postInc()));
    }
  }
  public default/*interface*/ </*class*/ Iterator extends ilist_iterator<Instruction>> void visit_Instructions(Iterator Start, Iterator End) {
    while (Native.$noteq_iter(Start, End)) {
      ((/*static_cast*/SubClass /*P*/ )(this)).visit_Instruction($Deref(Start.$postInc()));
    }
  }


  // Define visitors for functions and basic blocks...
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 97,
   FQN="llvm::InstVisitor::visit", NM="_ZN4llvm11InstVisitor5visitERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor5visitERNS_6ModuleE")
  //</editor-fold>
  public default/*interface*/ void visit_Module(final Module /*&*/ M) {
    ((/*static_cast*/SubClass /*P*/ )(this)).visitModule(M);
    visit_Functions(M.begin(), M.end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 101,
   FQN="llvm::InstVisitor::visit", NM="_ZN4llvm11InstVisitor5visitERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor5visitERNS_8FunctionE")
  //</editor-fold>
  public default/*interface*/ void visit_Function(final Function /*&*/ F) {
    ((/*static_cast*/SubClass /*P*/ )(this)).visitFunction(F);
    visit_BasicBlocks(F.begin(), F.end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 105,
   FQN="llvm::InstVisitor::visit", NM="_ZN4llvm11InstVisitor5visitERNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor5visitERNS_10BasicBlockE")
  //</editor-fold>
  public default/*interface*/ void visit_BasicBlock(final BasicBlock /*&*/ BB) {
    ((/*static_cast*/SubClass /*P*/ )(this)).visitBasicBlock(BB);
    visit_Instructions(BB.begin(), BB.end());
  }


  // Forwarding functions so that the user can visit with pointers AND refs.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 111,
   FQN="llvm::InstVisitor::visit", NM="_ZN4llvm11InstVisitor5visitEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor5visitEPNS_6ModuleE")
  //</editor-fold>
  public default/*interface*/ void visit_Module$P(Module /*P*/ M) {
    visit_Module($Deref(M));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 112,
   FQN="llvm::InstVisitor::visit", NM="_ZN4llvm11InstVisitor5visitEPNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor5visitEPNS_8FunctionE")
  //</editor-fold>
  public default/*interface*/ void visit_Function$P(Function /*P*/ F) {
    visit_Function($Deref(F));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 113,
   FQN="llvm::InstVisitor::visit", NM="_ZN4llvm11InstVisitor5visitEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor5visitEPNS_10BasicBlockE")
  //</editor-fold>
  public default/*interface*/ void visit_BasicBlock$P(BasicBlock /*P*/ BB) {
    visit_BasicBlock($Deref(BB));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 114,
   FQN="llvm::InstVisitor::visit", NM="_ZN4llvm11InstVisitor5visitEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor5visitEPNS_11InstructionE")
  //</editor-fold>
  public default/*interface*/ RetTy visit_Instruction$P(Instruction /*P*/ I) {
    return visit_Instruction($Deref(I));
  }


  // visit - Finally, code to visit an instruction...
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 118,
   FQN="llvm::InstVisitor::visit", NM="_ZN4llvm11InstVisitor5visitERNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor5visitERNS_11InstructionE")
  //</editor-fold>
  public default/*interface*/ RetTy visit_Instruction(final Instruction /*&*/ I) {
    switch (I.getOpcode()) {
     default:
      throw new llvm_unreachable("Unknown instruction type encountered!");
     case Instruction.TermOps.Ret:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitRet(((/*static_cast*/ReturnInst /*&*/ )(I)));
     case Instruction.TermOps.Br:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitBr(((/*static_cast*/BranchInst /*&*/ )(I)));
     case Instruction.TermOps.Switch:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitSwitch(((/*static_cast*/SwitchInst /*&*/ )(I)));
     case Instruction.TermOps.IndirectBr:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitIndirectBr(((/*static_cast*/IndirectBrInst /*&*/ )(I)));
     case Instruction.TermOps.Invoke:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitInvoke(((/*static_cast*/InvokeInst /*&*/ )(I)));
     case Instruction.TermOps.Resume:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitResume(((/*static_cast*/ResumeInst /*&*/ )(I)));
     case Instruction.TermOps.Unreachable:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitUnreachable(((/*static_cast*/UnreachableInst /*&*/ )(I)));
     case Instruction.TermOps.CleanupRet:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitCleanupRet(((/*static_cast*/CleanupReturnInst /*&*/ )(I)));
     case Instruction.TermOps.CatchRet:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitCatchRet(((/*static_cast*/CatchReturnInst /*&*/ )(I)));
     case Instruction.TermOps.CatchSwitch:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitCatchSwitch(((/*static_cast*/CatchSwitchInst /*&*/ )(I)));
     case Instruction.BinaryOps.Add:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitAdd(((/*static_cast*/BinaryOperator /*&*/ )(I)));
     case Instruction.BinaryOps.FAdd:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitFAdd(((/*static_cast*/BinaryOperator /*&*/ )(I)));
     case Instruction.BinaryOps.Sub:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitSub(((/*static_cast*/BinaryOperator /*&*/ )(I)));
     case Instruction.BinaryOps.FSub:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitFSub(((/*static_cast*/BinaryOperator /*&*/ )(I)));
     case Instruction.BinaryOps.Mul:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitMul(((/*static_cast*/BinaryOperator /*&*/ )(I)));
     case Instruction.BinaryOps.FMul:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitFMul(((/*static_cast*/BinaryOperator /*&*/ )(I)));
     case Instruction.BinaryOps.UDiv:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitUDiv(((/*static_cast*/BinaryOperator /*&*/ )(I)));
     case Instruction.BinaryOps.SDiv:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitSDiv(((/*static_cast*/BinaryOperator /*&*/ )(I)));
     case Instruction.BinaryOps.FDiv:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitFDiv(((/*static_cast*/BinaryOperator /*&*/ )(I)));
     case Instruction.BinaryOps.URem:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitURem(((/*static_cast*/BinaryOperator /*&*/ )(I)));
     case Instruction.BinaryOps.SRem:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitSRem(((/*static_cast*/BinaryOperator /*&*/ )(I)));
     case Instruction.BinaryOps.FRem:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitFRem(((/*static_cast*/BinaryOperator /*&*/ )(I)));
     case Instruction.BinaryOps.Shl: // Shift left  (logical)

      // Logical operators (integer operands)
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitShl(((/*static_cast*/BinaryOperator /*&*/ )(I)));
     case Instruction.BinaryOps.LShr: // Shift right (logical)
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitLShr(((/*static_cast*/BinaryOperator /*&*/ )(I)));
     case Instruction.BinaryOps.AShr: // Shift right (arithmetic)
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitAShr(((/*static_cast*/BinaryOperator /*&*/ )(I)));
     case Instruction.BinaryOps.And:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitAnd(((/*static_cast*/BinaryOperator /*&*/ )(I)));
     case Instruction.BinaryOps.Or:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitOr(((/*static_cast*/BinaryOperator /*&*/ )(I)));
     case Instruction.BinaryOps.Xor:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitXor(((/*static_cast*/BinaryOperator /*&*/ )(I)));
     case Instruction.MemoryOps.Alloca: // Stack management
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitAlloca(((/*static_cast*/AllocaInst /*&*/ )(I)));
     case Instruction.MemoryOps.Load: // Memory manipulation instrs
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitLoad(((/*static_cast*/LoadInst /*&*/ )(I)));
     case Instruction.MemoryOps.Store:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitStore(((/*static_cast*/StoreInst /*&*/ )(I)));
     case Instruction.MemoryOps.GetElementPtr:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitGetElementPtr(((/*static_cast*/GetElementPtrInst /*&*/ )(I)));
     case Instruction.MemoryOps.Fence:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitFence(((/*static_cast*/FenceInst /*&*/ )(I)));
     case Instruction.MemoryOps.AtomicCmpXchg:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitAtomicCmpXchg(((/*static_cast*/AtomicCmpXchgInst /*&*/ )(I)));
     case Instruction.MemoryOps.AtomicRMW:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitAtomicRMW(((/*static_cast*/AtomicRMWInst /*&*/ )(I)));
     case Instruction.CastOps.Trunc: // Truncate integers
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitTrunc(((/*static_cast*/TruncInst /*&*/ )(I)));
     case Instruction.CastOps.ZExt: // Zero extend integers
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitZExt(((/*static_cast*/ZExtInst /*&*/ )(I)));
     case Instruction.CastOps.SExt: // Sign extend integers
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitSExt(((/*static_cast*/SExtInst /*&*/ )(I)));
     case Instruction.CastOps.FPToUI: // floating point -> UInt
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitFPToUI(((/*static_cast*/FPToUIInst /*&*/ )(I)));
     case Instruction.CastOps.FPToSI: // floating point -> SInt
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitFPToSI(((/*static_cast*/FPToSIInst /*&*/ )(I)));
     case Instruction.CastOps.UIToFP: // UInt -> floating point
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitUIToFP(((/*static_cast*/UIToFPInst /*&*/ )(I)));
     case Instruction.CastOps.SIToFP: // SInt -> floating point
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitSIToFP(((/*static_cast*/SIToFPInst /*&*/ )(I)));
     case Instruction.CastOps.FPTrunc: // Truncate floating point
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitFPTrunc(((/*static_cast*/FPTruncInst /*&*/ )(I)));
     case Instruction.CastOps.FPExt: // Extend floating point
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitFPExt(((/*static_cast*/FPExtInst /*&*/ )(I)));
     case Instruction.CastOps.PtrToInt: // Pointer -> Integer
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitPtrToInt(((/*static_cast*/PtrToIntInst /*&*/ )(I)));
     case Instruction.CastOps.IntToPtr: // Integer -> Pointer
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitIntToPtr(((/*static_cast*/IntToPtrInst /*&*/ )(I)));
     case Instruction.CastOps.BitCast: // Type cast
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitBitCast(((/*static_cast*/BitCastInst /*&*/ )(I)));
     case Instruction.CastOps.AddrSpaceCast: // addrspace cast
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitAddrSpaceCast(((/*static_cast*/AddrSpaceCastInst /*&*/ )(I)));
     case Instruction.FuncletPadOps.CleanupPad:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitCleanupPad(((/*static_cast*/CleanupPadInst /*&*/ )(I)));
     case Instruction.FuncletPadOps.CatchPad:
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitCatchPad(((/*static_cast*/CatchPadInst /*&*/ )(I)));
     case Instruction.OtherOps.ICmp: // Integer comparison instruction
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitICmp(((/*static_cast*/ICmpInst /*&*/ )(I)));
     case Instruction.OtherOps.FCmp: // Floating point comparison instr.
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitFCmp(((/*static_cast*/FCmpInst /*&*/ )(I)));
     case Instruction.OtherOps.PHI: // PHI node instruction
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitPHI(((/*static_cast*/PHINode /*&*/ )(I)));
     case Instruction.OtherOps.Call: // Call a function
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitCall(((/*static_cast*/CallInst /*&*/ )(I)));
     case Instruction.OtherOps.Select: // select instruction
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitSelect(((/*static_cast*/SelectInst /*&*/ )(I)));
     case Instruction.OtherOps.UserOp1: // May be used internally in a pass
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitUserOp1(((/*static_cast*/Instruction /*&*/ )(I)));
     case Instruction.OtherOps.UserOp2: // Internal to passes only
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitUserOp2(((/*static_cast*/Instruction /*&*/ )(I)));
     case Instruction.OtherOps.VAArg: // vaarg instruction
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitVAArg(((/*static_cast*/VAArgInst /*&*/ )(I)));
     case Instruction.OtherOps.ExtractElement: // extract from vector
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitExtractElement(((/*static_cast*/ExtractElementInst /*&*/ )(I)));
     case Instruction.OtherOps.InsertElement: // insert into vector
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitInsertElement(((/*static_cast*/InsertElementInst /*&*/ )(I)));
     case Instruction.OtherOps.ShuffleVector: // shuffle two vectors.
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitShuffleVector(((/*static_cast*/ShuffleVectorInst /*&*/ )(I)));
     case Instruction.OtherOps.ExtractValue: // extract from aggregate
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitExtractValue(((/*static_cast*/ExtractValueInst /*&*/ )(I)));
     case Instruction.OtherOps.InsertValue: // insert into aggregate
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitInsertValue(((/*static_cast*/InsertValueInst /*&*/ )(I)));
     case Instruction.OtherOps.LandingPad: // Landing pad instruction.
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitLandingPad(((/*static_cast*/LandingPadInst /*&*/ )(I)));
    }
  }


  //===--------------------------------------------------------------------===//
  // Visitation functions... these functions provide default fallbacks in case
  // the user does not specify what to do for a particular instruction type.
  // The default behavior is to generalize the instruction type to its subtype
  // and try visiting the subtype.  All of this should be inlined perfectly,
  // because there are no virtual functions to get in the way.
  //

  // When visiting a module, function or basic block directly, these methods get
  // called to indicate when transitioning into a new unit.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 141,
   FQN="llvm::InstVisitor::visitModule", NM="_ZN4llvm11InstVisitor11visitModuleERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor11visitModuleERNS_6ModuleE")
  //</editor-fold>
  public default/*interface*/ void visitModule(final Module /*&*/ M) {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 142,
   FQN="llvm::InstVisitor::visitFunction", NM="_ZN4llvm11InstVisitor13visitFunctionERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor13visitFunctionERNS_8FunctionE")
  //</editor-fold>
  public default/*interface*/ void visitFunction(final Function /*&*/ F) {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitBasicBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 143,
   FQN="llvm::InstVisitor::visitBasicBlock", NM="_ZN4llvm11InstVisitor15visitBasicBlockERNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor15visitBasicBlockERNS_10BasicBlockE")
  //</editor-fold>
  public default/*interface*/ void visitBasicBlock(final BasicBlock /*&*/ BB) {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitRet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 110,
   FQN="llvm::InstVisitor::visitRet", NM="_ZN4llvm11InstVisitor8visitRetERNS_10ReturnInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor8visitRetERNS_10ReturnInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitRet(final ReturnInst /*&*/ I) {
    if (1 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitReturnInst(((/*static_cast*/ReturnInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitBr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 111,
   FQN="llvm::InstVisitor::visitBr", NM="_ZN4llvm11InstVisitor7visitBrERNS_10BranchInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor7visitBrERNS_10BranchInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitBr(final BranchInst /*&*/ I) {
    if (2 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitBranchInst(((/*static_cast*/BranchInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitSwitch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 112,
   FQN="llvm::InstVisitor::visitSwitch", NM="_ZN4llvm11InstVisitor11visitSwitchERNS_10SwitchInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor11visitSwitchERNS_10SwitchInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitSwitch(final SwitchInst /*&*/ I) {
    if (3 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitSwitchInst(((/*static_cast*/SwitchInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitIndirectBr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 113,
   FQN="llvm::InstVisitor::visitIndirectBr", NM="_ZN4llvm11InstVisitor15visitIndirectBrERNS_14IndirectBrInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor15visitIndirectBrERNS_14IndirectBrInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitIndirectBr(final IndirectBrInst /*&*/ I) {
    if (4 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitIndirectBrInst(((/*static_cast*/IndirectBrInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitInvoke">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 114,
   FQN="llvm::InstVisitor::visitInvoke", NM="_ZN4llvm11InstVisitor11visitInvokeERNS_10InvokeInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor11visitInvokeERNS_10InvokeInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitInvoke(final InvokeInst /*&*/ I) {
    if (5 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitInvokeInst(((/*static_cast*/InvokeInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitResume">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 115,
   FQN="llvm::InstVisitor::visitResume", NM="_ZN4llvm11InstVisitor11visitResumeERNS_10ResumeInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor11visitResumeERNS_10ResumeInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitResume(final ResumeInst /*&*/ I) {
    if (6 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitResumeInst(((/*static_cast*/ResumeInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitUnreachable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 116,
   FQN="llvm::InstVisitor::visitUnreachable", NM="_ZN4llvm11InstVisitor16visitUnreachableERNS_15UnreachableInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor16visitUnreachableERNS_15UnreachableInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitUnreachable(final UnreachableInst /*&*/ I) {
    if (7 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitUnreachableInst(((/*static_cast*/UnreachableInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitCleanupRet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 117,
   FQN="llvm::InstVisitor::visitCleanupRet", NM="_ZN4llvm11InstVisitor15visitCleanupRetERNS_17CleanupReturnInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor15visitCleanupRetERNS_17CleanupReturnInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitCleanupRet(final CleanupReturnInst /*&*/ I) {
    if (8 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitCleanupReturnInst(((/*static_cast*/CleanupReturnInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitCatchRet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 118,
   FQN="llvm::InstVisitor::visitCatchRet", NM="_ZN4llvm11InstVisitor13visitCatchRetERNS_15CatchReturnInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor13visitCatchRetERNS_15CatchReturnInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitCatchRet(final CatchReturnInst /*&*/ I) {
    if (9 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitCatchReturnInst(((/*static_cast*/CatchReturnInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitCatchSwitch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 119,
   FQN="llvm::InstVisitor::visitCatchSwitch", NM="_ZN4llvm11InstVisitor16visitCatchSwitchERNS_15CatchSwitchInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor16visitCatchSwitchERNS_15CatchSwitchInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitCatchSwitch(final CatchSwitchInst /*&*/ I) {
    if (10 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitCatchSwitchInst(((/*static_cast*/CatchSwitchInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 124,
   FQN="llvm::InstVisitor::visitAdd", NM="_ZN4llvm11InstVisitor8visitAddERNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor8visitAddERNS_14BinaryOperatorE")
  //</editor-fold>
  public default/*interface*/ RetTy visitAdd(final BinaryOperator /*&*/ I) {
    if (11 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitBinaryOperator(((/*static_cast*/BinaryOperator /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitFAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 125,
   FQN="llvm::InstVisitor::visitFAdd", NM="_ZN4llvm11InstVisitor9visitFAddERNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor9visitFAddERNS_14BinaryOperatorE")
  //</editor-fold>
  public default/*interface*/ RetTy visitFAdd(final BinaryOperator /*&*/ I) {
    if (12 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitBinaryOperator(((/*static_cast*/BinaryOperator /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 126,
   FQN="llvm::InstVisitor::visitSub", NM="_ZN4llvm11InstVisitor8visitSubERNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor8visitSubERNS_14BinaryOperatorE")
  //</editor-fold>
  public default/*interface*/ RetTy visitSub(final BinaryOperator /*&*/ I) {
    if (13 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitBinaryOperator(((/*static_cast*/BinaryOperator /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitFSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 127,
   FQN="llvm::InstVisitor::visitFSub", NM="_ZN4llvm11InstVisitor9visitFSubERNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor9visitFSubERNS_14BinaryOperatorE")
  //</editor-fold>
  public default/*interface*/ RetTy visitFSub(final BinaryOperator /*&*/ I) {
    if (14 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitBinaryOperator(((/*static_cast*/BinaryOperator /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 128,
   FQN="llvm::InstVisitor::visitMul", NM="_ZN4llvm11InstVisitor8visitMulERNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor8visitMulERNS_14BinaryOperatorE")
  //</editor-fold>
  public default/*interface*/ RetTy visitMul(final BinaryOperator /*&*/ I) {
    if (15 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitBinaryOperator(((/*static_cast*/BinaryOperator /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitFMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 129,
   FQN="llvm::InstVisitor::visitFMul", NM="_ZN4llvm11InstVisitor9visitFMulERNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor9visitFMulERNS_14BinaryOperatorE")
  //</editor-fold>
  public default/*interface*/ RetTy visitFMul(final BinaryOperator /*&*/ I) {
    if (16 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitBinaryOperator(((/*static_cast*/BinaryOperator /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitUDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 130,
   FQN="llvm::InstVisitor::visitUDiv", NM="_ZN4llvm11InstVisitor9visitUDivERNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor9visitUDivERNS_14BinaryOperatorE")
  //</editor-fold>
  public default/*interface*/ RetTy visitUDiv(final BinaryOperator /*&*/ I) {
    if (17 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitBinaryOperator(((/*static_cast*/BinaryOperator /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitSDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 131,
   FQN="llvm::InstVisitor::visitSDiv", NM="_ZN4llvm11InstVisitor9visitSDivERNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor9visitSDivERNS_14BinaryOperatorE")
  //</editor-fold>
  public default/*interface*/ RetTy visitSDiv(final BinaryOperator /*&*/ I) {
    if (18 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitBinaryOperator(((/*static_cast*/BinaryOperator /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitFDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 132,
   FQN="llvm::InstVisitor::visitFDiv", NM="_ZN4llvm11InstVisitor9visitFDivERNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor9visitFDivERNS_14BinaryOperatorE")
  //</editor-fold>
  public default/*interface*/ RetTy visitFDiv(final BinaryOperator /*&*/ I) {
    if (19 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitBinaryOperator(((/*static_cast*/BinaryOperator /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitURem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 133,
   FQN="llvm::InstVisitor::visitURem", NM="_ZN4llvm11InstVisitor9visitURemERNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor9visitURemERNS_14BinaryOperatorE")
  //</editor-fold>
  public default/*interface*/ RetTy visitURem(final BinaryOperator /*&*/ I) {
    if (20 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitBinaryOperator(((/*static_cast*/BinaryOperator /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitSRem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 134,
   FQN="llvm::InstVisitor::visitSRem", NM="_ZN4llvm11InstVisitor9visitSRemERNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor9visitSRemERNS_14BinaryOperatorE")
  //</editor-fold>
  public default/*interface*/ RetTy visitSRem(final BinaryOperator /*&*/ I) {
    if (21 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitBinaryOperator(((/*static_cast*/BinaryOperator /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitFRem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 135,
   FQN="llvm::InstVisitor::visitFRem", NM="_ZN4llvm11InstVisitor9visitFRemERNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor9visitFRemERNS_14BinaryOperatorE")
  //</editor-fold>
  public default/*interface*/ RetTy visitFRem(final BinaryOperator /*&*/ I) {
    if (22 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitBinaryOperator(((/*static_cast*/BinaryOperator /*&*/ )(I)));
    }
  }


  // Logical operators (integer operands)
  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitShl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 138,
   FQN="llvm::InstVisitor::visitShl", NM="_ZN4llvm11InstVisitor8visitShlERNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor8visitShlERNS_14BinaryOperatorE")
  //</editor-fold>
  public default/*interface*/ RetTy visitShl(final BinaryOperator /*&*/ I) {
    if (23 == Instruction.OtherOps.Call) { // Shift left  (logical)
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitBinaryOperator(((/*static_cast*/BinaryOperator /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitLShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 139,
   FQN="llvm::InstVisitor::visitLShr", NM="_ZN4llvm11InstVisitor9visitLShrERNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor9visitLShrERNS_14BinaryOperatorE")
  //</editor-fold>
  public default/*interface*/ RetTy visitLShr(final BinaryOperator /*&*/ I) {
    if (24 == Instruction.OtherOps.Call) { // Shift right (logical)
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitBinaryOperator(((/*static_cast*/BinaryOperator /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitAShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 140,
   FQN="llvm::InstVisitor::visitAShr", NM="_ZN4llvm11InstVisitor9visitAShrERNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor9visitAShrERNS_14BinaryOperatorE")
  //</editor-fold>
  public default/*interface*/ RetTy visitAShr(final BinaryOperator /*&*/ I) {
    if (25 == Instruction.OtherOps.Call) { // Shift right (arithmetic)
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitBinaryOperator(((/*static_cast*/BinaryOperator /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitAnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 141,
   FQN="llvm::InstVisitor::visitAnd", NM="_ZN4llvm11InstVisitor8visitAndERNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor8visitAndERNS_14BinaryOperatorE")
  //</editor-fold>
  public default/*interface*/ RetTy visitAnd(final BinaryOperator /*&*/ I) {
    if (26 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitBinaryOperator(((/*static_cast*/BinaryOperator /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitOr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 142,
   FQN="llvm::InstVisitor::visitOr", NM="_ZN4llvm11InstVisitor7visitOrERNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor7visitOrERNS_14BinaryOperatorE")
  //</editor-fold>
  public default/*interface*/ RetTy visitOr(final BinaryOperator /*&*/ I) {
    if (27 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitBinaryOperator(((/*static_cast*/BinaryOperator /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitXor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 143,
   FQN="llvm::InstVisitor::visitXor", NM="_ZN4llvm11InstVisitor8visitXorERNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor8visitXorERNS_14BinaryOperatorE")
  //</editor-fold>
  public default/*interface*/ RetTy visitXor(final BinaryOperator /*&*/ I) {
    if (28 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitBinaryOperator(((/*static_cast*/BinaryOperator /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitAlloca">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 148,
   FQN="llvm::InstVisitor::visitAlloca", NM="_ZN4llvm11InstVisitor11visitAllocaERNS_10AllocaInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor11visitAllocaERNS_10AllocaInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitAlloca(final AllocaInst /*&*/ I) {
    if (29 == Instruction.OtherOps.Call) { // Stack management
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitAllocaInst(((/*static_cast*/AllocaInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitLoad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 149,
   FQN="llvm::InstVisitor::visitLoad", NM="_ZN4llvm11InstVisitor9visitLoadERNS_8LoadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor9visitLoadERNS_8LoadInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitLoad(final LoadInst /*&*/ I) {
    if (30 == Instruction.OtherOps.Call) { // Memory manipulation instrs
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitLoadInst(((/*static_cast*/LoadInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitStore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 150,
   FQN="llvm::InstVisitor::visitStore", NM="_ZN4llvm11InstVisitor10visitStoreERNS_9StoreInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor10visitStoreERNS_9StoreInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitStore(final StoreInst /*&*/ I) {
    if (31 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitStoreInst(((/*static_cast*/StoreInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 151,
   FQN="llvm::InstVisitor::visitGetElementPtr", NM="_ZN4llvm11InstVisitor18visitGetElementPtrERNS_17GetElementPtrInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor18visitGetElementPtrERNS_17GetElementPtrInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitGetElementPtr(final GetElementPtrInst /*&*/ I) {
    if (32 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitGetElementPtrInst(((/*static_cast*/GetElementPtrInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitFence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 152,
   FQN="llvm::InstVisitor::visitFence", NM="_ZN4llvm11InstVisitor10visitFenceERNS_9FenceInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor10visitFenceERNS_9FenceInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitFence(final FenceInst /*&*/ I) {
    if (33 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitFenceInst(((/*static_cast*/FenceInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitAtomicCmpXchg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 153,
   FQN="llvm::InstVisitor::visitAtomicCmpXchg", NM="_ZN4llvm11InstVisitor18visitAtomicCmpXchgERNS_17AtomicCmpXchgInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor18visitAtomicCmpXchgERNS_17AtomicCmpXchgInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitAtomicCmpXchg(final AtomicCmpXchgInst /*&*/ I) {
    if (34 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitAtomicCmpXchgInst(((/*static_cast*/AtomicCmpXchgInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitAtomicRMW">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 154,
   FQN="llvm::InstVisitor::visitAtomicRMW", NM="_ZN4llvm11InstVisitor14visitAtomicRMWERNS_13AtomicRMWInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor14visitAtomicRMWERNS_13AtomicRMWInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitAtomicRMW(final AtomicRMWInst /*&*/ I) {
    if (35 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitAtomicRMWInst(((/*static_cast*/AtomicRMWInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitTrunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 161,
   FQN="llvm::InstVisitor::visitTrunc", NM="_ZN4llvm11InstVisitor10visitTruncERNS_9TruncInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor10visitTruncERNS_9TruncInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitTrunc(final TruncInst /*&*/ I) {
    if (36 == Instruction.OtherOps.Call) { // Truncate integers
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitTruncInst(((/*static_cast*/TruncInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitZExt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 162,
   FQN="llvm::InstVisitor::visitZExt", NM="_ZN4llvm11InstVisitor9visitZExtERNS_8ZExtInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor9visitZExtERNS_8ZExtInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitZExt(final ZExtInst /*&*/ I) {
    if (37 == Instruction.OtherOps.Call) { // Zero extend integers
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitZExtInst(((/*static_cast*/ZExtInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitSExt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 163,
   FQN="llvm::InstVisitor::visitSExt", NM="_ZN4llvm11InstVisitor9visitSExtERNS_8SExtInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor9visitSExtERNS_8SExtInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitSExt(final SExtInst /*&*/ I) {
    if (38 == Instruction.OtherOps.Call) { // Sign extend integers
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitSExtInst(((/*static_cast*/SExtInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitFPToUI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 164,
   FQN="llvm::InstVisitor::visitFPToUI", NM="_ZN4llvm11InstVisitor11visitFPToUIERNS_10FPToUIInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor11visitFPToUIERNS_10FPToUIInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitFPToUI(final FPToUIInst /*&*/ I) {
    if (39 == Instruction.OtherOps.Call) { // floating point -> UInt
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitFPToUIInst(((/*static_cast*/FPToUIInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitFPToSI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 165,
   FQN="llvm::InstVisitor::visitFPToSI", NM="_ZN4llvm11InstVisitor11visitFPToSIERNS_10FPToSIInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor11visitFPToSIERNS_10FPToSIInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitFPToSI(final FPToSIInst /*&*/ I) {
    if (40 == Instruction.OtherOps.Call) { // floating point -> SInt
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitFPToSIInst(((/*static_cast*/FPToSIInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitUIToFP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 166,
   FQN="llvm::InstVisitor::visitUIToFP", NM="_ZN4llvm11InstVisitor11visitUIToFPERNS_10UIToFPInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor11visitUIToFPERNS_10UIToFPInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitUIToFP(final UIToFPInst /*&*/ I) {
    if (41 == Instruction.OtherOps.Call) { // UInt -> floating point
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitUIToFPInst(((/*static_cast*/UIToFPInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitSIToFP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 167,
   FQN="llvm::InstVisitor::visitSIToFP", NM="_ZN4llvm11InstVisitor11visitSIToFPERNS_10SIToFPInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor11visitSIToFPERNS_10SIToFPInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitSIToFP(final SIToFPInst /*&*/ I) {
    if (42 == Instruction.OtherOps.Call) { // SInt -> floating point
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitSIToFPInst(((/*static_cast*/SIToFPInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitFPTrunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 168,
   FQN="llvm::InstVisitor::visitFPTrunc", NM="_ZN4llvm11InstVisitor12visitFPTruncERNS_11FPTruncInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor12visitFPTruncERNS_11FPTruncInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitFPTrunc(final FPTruncInst /*&*/ I) {
    if (43 == Instruction.OtherOps.Call) { // Truncate floating point
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitFPTruncInst(((/*static_cast*/FPTruncInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitFPExt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 169,
   FQN="llvm::InstVisitor::visitFPExt", NM="_ZN4llvm11InstVisitor10visitFPExtERNS_9FPExtInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor10visitFPExtERNS_9FPExtInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitFPExt(final FPExtInst /*&*/ I) {
    if (44 == Instruction.OtherOps.Call) { // Extend floating point
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitFPExtInst(((/*static_cast*/FPExtInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitPtrToInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 170,
   FQN="llvm::InstVisitor::visitPtrToInt", NM="_ZN4llvm11InstVisitor13visitPtrToIntERNS_12PtrToIntInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor13visitPtrToIntERNS_12PtrToIntInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitPtrToInt(final PtrToIntInst /*&*/ I) {
    if (45 == Instruction.OtherOps.Call) { // Pointer -> Integer
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitPtrToIntInst(((/*static_cast*/PtrToIntInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitIntToPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 171,
   FQN="llvm::InstVisitor::visitIntToPtr", NM="_ZN4llvm11InstVisitor13visitIntToPtrERNS_12IntToPtrInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor13visitIntToPtrERNS_12IntToPtrInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitIntToPtr(final IntToPtrInst /*&*/ I) {
    if (46 == Instruction.OtherOps.Call) { // Integer -> Pointer
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitIntToPtrInst(((/*static_cast*/IntToPtrInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 172,
   FQN="llvm::InstVisitor::visitBitCast", NM="_ZN4llvm11InstVisitor12visitBitCastERNS_11BitCastInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor12visitBitCastERNS_11BitCastInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitBitCast(final BitCastInst /*&*/ I) {
    if (47 == Instruction.OtherOps.Call) { // Type cast
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitBitCastInst(((/*static_cast*/BitCastInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitAddrSpaceCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 173,
   FQN="llvm::InstVisitor::visitAddrSpaceCast", NM="_ZN4llvm11InstVisitor18visitAddrSpaceCastERNS_17AddrSpaceCastInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor18visitAddrSpaceCastERNS_17AddrSpaceCastInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitAddrSpaceCast(final AddrSpaceCastInst /*&*/ I) {
    if (48 == Instruction.OtherOps.Call) { // addrspace cast
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitAddrSpaceCastInst(((/*static_cast*/AddrSpaceCastInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitCleanupPad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 177,
   FQN="llvm::InstVisitor::visitCleanupPad", NM="_ZN4llvm11InstVisitor15visitCleanupPadERNS_14CleanupPadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor15visitCleanupPadERNS_14CleanupPadInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitCleanupPad(final CleanupPadInst /*&*/ I) {
    if (49 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitCleanupPadInst(((/*static_cast*/CleanupPadInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitCatchPad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 178,
   FQN="llvm::InstVisitor::visitCatchPad", NM="_ZN4llvm11InstVisitor13visitCatchPadERNS_12CatchPadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor13visitCatchPadERNS_12CatchPadInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitCatchPad(final CatchPadInst /*&*/ I) {
    if (50 == Instruction.OtherOps.Call) {
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitCatchPadInst(((/*static_cast*/CatchPadInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitICmp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 183,
   FQN="llvm::InstVisitor::visitICmp", NM="_ZN4llvm11InstVisitor9visitICmpERNS_8ICmpInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor9visitICmpERNS_8ICmpInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitICmp(final ICmpInst /*&*/ I) {
    if (51 == Instruction.OtherOps.Call) { // Integer comparison instruction
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitICmpInst(((/*static_cast*/ICmpInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitFCmp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 184,
   FQN="llvm::InstVisitor::visitFCmp", NM="_ZN4llvm11InstVisitor9visitFCmpERNS_8FCmpInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor9visitFCmpERNS_8FCmpInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitFCmp(final FCmpInst /*&*/ I) {
    if (52 == Instruction.OtherOps.Call) { // Floating point comparison instr.
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitFCmpInst(((/*static_cast*/FCmpInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitPHI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 185,
   FQN="llvm::InstVisitor::visitPHI", NM="_ZN4llvm11InstVisitor8visitPHIERNS_7PHINodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor8visitPHIERNS_7PHINodeE")
  //</editor-fold>
  public default/*interface*/ RetTy visitPHI(final PHINode /*&*/ I) {
    if (53 == Instruction.OtherOps.Call) { // PHI node instruction
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitPHINode(((/*static_cast*/PHINode /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 186,
   FQN="llvm::InstVisitor::visitCall", NM="_ZN4llvm11InstVisitor9visitCallERNS_8CallInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor9visitCallERNS_8CallInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitCall(final CallInst /*&*/ I) {
    if (54 == Instruction.OtherOps.Call) { // Call a function
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitCallInst(((/*static_cast*/CallInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitSelect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 187,
   FQN="llvm::InstVisitor::visitSelect", NM="_ZN4llvm11InstVisitor11visitSelectERNS_10SelectInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor11visitSelectERNS_10SelectInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitSelect(final SelectInst /*&*/ I) {
    if (55 == Instruction.OtherOps.Call) { // select instruction
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitSelectInst(((/*static_cast*/SelectInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitUserOp1">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 188,
   FQN="llvm::InstVisitor::visitUserOp1", NM="_ZN4llvm11InstVisitor12visitUserOp1ERNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor12visitUserOp1ERNS_11InstructionE")
  //</editor-fold>
  public default/*interface*/ RetTy visitUserOp1(final Instruction /*&*/ I) {
    if (56 == Instruction.OtherOps.Call) { // May be used internally in a pass
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitInstruction(((/*static_cast*/Instruction /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitUserOp2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 189,
   FQN="llvm::InstVisitor::visitUserOp2", NM="_ZN4llvm11InstVisitor12visitUserOp2ERNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor12visitUserOp2ERNS_11InstructionE")
  //</editor-fold>
  public default/*interface*/ RetTy visitUserOp2(final Instruction /*&*/ I) {
    if (57 == Instruction.OtherOps.Call) { // Internal to passes only
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitInstruction(((/*static_cast*/Instruction /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitVAArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 190,
   FQN="llvm::InstVisitor::visitVAArg", NM="_ZN4llvm11InstVisitor10visitVAArgERNS_9VAArgInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor10visitVAArgERNS_9VAArgInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitVAArg(final VAArgInst /*&*/ I) {
    if (58 == Instruction.OtherOps.Call) { // vaarg instruction
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitVAArgInst(((/*static_cast*/VAArgInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitExtractElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 191,
   FQN="llvm::InstVisitor::visitExtractElement", NM="_ZN4llvm11InstVisitor19visitExtractElementERNS_18ExtractElementInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor19visitExtractElementERNS_18ExtractElementInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitExtractElement(final ExtractElementInst /*&*/ I) {
    if (59 == Instruction.OtherOps.Call) { // extract from vector
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitExtractElementInst(((/*static_cast*/ExtractElementInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitInsertElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 192,
   FQN="llvm::InstVisitor::visitInsertElement", NM="_ZN4llvm11InstVisitor18visitInsertElementERNS_17InsertElementInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor18visitInsertElementERNS_17InsertElementInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitInsertElement(final InsertElementInst /*&*/ I) {
    if (60 == Instruction.OtherOps.Call) { // insert into vector
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitInsertElementInst(((/*static_cast*/InsertElementInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitShuffleVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 193,
   FQN="llvm::InstVisitor::visitShuffleVector", NM="_ZN4llvm11InstVisitor18visitShuffleVectorERNS_17ShuffleVectorInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor18visitShuffleVectorERNS_17ShuffleVectorInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitShuffleVector(final ShuffleVectorInst /*&*/ I) {
    if (61 == Instruction.OtherOps.Call) { // shuffle two vectors.
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitShuffleVectorInst(((/*static_cast*/ShuffleVectorInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitExtractValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 194,
   FQN="llvm::InstVisitor::visitExtractValue", NM="_ZN4llvm11InstVisitor17visitExtractValueERNS_16ExtractValueInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor17visitExtractValueERNS_16ExtractValueInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitExtractValue(final ExtractValueInst /*&*/ I) {
    if (62 == Instruction.OtherOps.Call) { // extract from aggregate
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitExtractValueInst(((/*static_cast*/ExtractValueInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitInsertValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 195,
   FQN="llvm::InstVisitor::visitInsertValue", NM="_ZN4llvm11InstVisitor16visitInsertValueERNS_15InsertValueInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor16visitInsertValueERNS_15InsertValueInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitInsertValue(final InsertValueInst /*&*/ I) {
    if (63 == Instruction.OtherOps.Call) { // insert into aggregate
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitInsertValueInst(((/*static_cast*/InsertValueInst /*&*/ )(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitLandingPad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instruction.def", line = 196,
   FQN="llvm::InstVisitor::visitLandingPad", NM="_ZN4llvm11InstVisitor15visitLandingPadERNS_14LandingPadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor15visitLandingPadERNS_14LandingPadInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitLandingPad(final LandingPadInst /*&*/ I) {
    if (64 == Instruction.OtherOps.Call) { // Landing pad instruction.
      return delegateCallInst(I);
    } else {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitLandingPadInst(((/*static_cast*/LandingPadInst /*&*/ )(I)));
    }
  }


  // Specific Instruction type classes... note that all of the casts are
  // necessary because we use the instruction classes as opaque types...
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitReturnInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 166,
   FQN="llvm::InstVisitor::visitReturnInst", NM="_ZN4llvm11InstVisitor15visitReturnInstERNS_10ReturnInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor15visitReturnInstERNS_10ReturnInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitReturnInst(final ReturnInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitTerminatorInst(((/*static_cast*/TerminatorInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitBranchInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 167,
   FQN="llvm::InstVisitor::visitBranchInst", NM="_ZN4llvm11InstVisitor15visitBranchInstERNS_10BranchInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor15visitBranchInstERNS_10BranchInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitBranchInst(final BranchInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitTerminatorInst(((/*static_cast*/TerminatorInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitSwitchInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 168,
   FQN="llvm::InstVisitor::visitSwitchInst", NM="_ZN4llvm11InstVisitor15visitSwitchInstERNS_10SwitchInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor15visitSwitchInstERNS_10SwitchInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitSwitchInst(final SwitchInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitTerminatorInst(((/*static_cast*/TerminatorInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitIndirectBrInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 169,
   FQN="llvm::InstVisitor::visitIndirectBrInst", NM="_ZN4llvm11InstVisitor19visitIndirectBrInstERNS_14IndirectBrInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor19visitIndirectBrInstERNS_14IndirectBrInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitIndirectBrInst(final IndirectBrInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitTerminatorInst(((/*static_cast*/TerminatorInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitResumeInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 170,
   FQN="llvm::InstVisitor::visitResumeInst", NM="_ZN4llvm11InstVisitor15visitResumeInstERNS_10ResumeInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor15visitResumeInstERNS_10ResumeInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitResumeInst(final ResumeInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitTerminatorInst(((/*static_cast*/TerminatorInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitUnreachableInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 171,
   FQN="llvm::InstVisitor::visitUnreachableInst", NM="_ZN4llvm11InstVisitor20visitUnreachableInstERNS_15UnreachableInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor20visitUnreachableInstERNS_15UnreachableInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitUnreachableInst(final UnreachableInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitTerminatorInst(((/*static_cast*/TerminatorInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitCleanupReturnInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 172,
   FQN="llvm::InstVisitor::visitCleanupReturnInst", NM="_ZN4llvm11InstVisitor22visitCleanupReturnInstERNS_17CleanupReturnInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor22visitCleanupReturnInstERNS_17CleanupReturnInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitCleanupReturnInst(final CleanupReturnInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitTerminatorInst(((/*static_cast*/TerminatorInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitCatchReturnInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 173,
   FQN="llvm::InstVisitor::visitCatchReturnInst", NM="_ZN4llvm11InstVisitor20visitCatchReturnInstERNS_15CatchReturnInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor20visitCatchReturnInstERNS_15CatchReturnInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitCatchReturnInst(final CatchReturnInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitTerminatorInst(((/*static_cast*/TerminatorInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitCatchSwitchInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 174,
   FQN="llvm::InstVisitor::visitCatchSwitchInst", NM="_ZN4llvm11InstVisitor20visitCatchSwitchInstERNS_15CatchSwitchInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor20visitCatchSwitchInstERNS_15CatchSwitchInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitCatchSwitchInst(final CatchSwitchInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitTerminatorInst(((/*static_cast*/TerminatorInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitICmpInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 175,
   FQN="llvm::InstVisitor::visitICmpInst", NM="_ZN4llvm11InstVisitor13visitICmpInstERNS_8ICmpInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor13visitICmpInstERNS_8ICmpInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitICmpInst(final ICmpInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitCmpInst(((/*static_cast*/CmpInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitFCmpInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 176,
   FQN="llvm::InstVisitor::visitFCmpInst", NM="_ZN4llvm11InstVisitor13visitFCmpInstERNS_8FCmpInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor13visitFCmpInstERNS_8FCmpInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitFCmpInst(final FCmpInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitCmpInst(((/*static_cast*/CmpInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitAllocaInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 177,
   FQN="llvm::InstVisitor::visitAllocaInst", NM="_ZN4llvm11InstVisitor15visitAllocaInstERNS_10AllocaInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor15visitAllocaInstERNS_10AllocaInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitAllocaInst(final AllocaInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitUnaryInstruction(((/*static_cast*/UnaryInstruction /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitLoadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 178,
   FQN="llvm::InstVisitor::visitLoadInst", NM="_ZN4llvm11InstVisitor13visitLoadInstERNS_8LoadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor13visitLoadInstERNS_8LoadInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitLoadInst(final LoadInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitUnaryInstruction(((/*static_cast*/UnaryInstruction /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitStoreInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 179,
   FQN="llvm::InstVisitor::visitStoreInst", NM="_ZN4llvm11InstVisitor14visitStoreInstERNS_9StoreInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor14visitStoreInstERNS_9StoreInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitStoreInst(final StoreInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitInstruction(((/*static_cast*/Instruction /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitAtomicCmpXchgInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 180,
   FQN="llvm::InstVisitor::visitAtomicCmpXchgInst", NM="_ZN4llvm11InstVisitor22visitAtomicCmpXchgInstERNS_17AtomicCmpXchgInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor22visitAtomicCmpXchgInstERNS_17AtomicCmpXchgInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitAtomicCmpXchgInst(final AtomicCmpXchgInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitInstruction(((/*static_cast*/Instruction /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitAtomicRMWInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 181,
   FQN="llvm::InstVisitor::visitAtomicRMWInst", NM="_ZN4llvm11InstVisitor18visitAtomicRMWInstERNS_13AtomicRMWInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor18visitAtomicRMWInstERNS_13AtomicRMWInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitAtomicRMWInst(final AtomicRMWInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitInstruction(((/*static_cast*/Instruction /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitFenceInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 182,
   FQN="llvm::InstVisitor::visitFenceInst", NM="_ZN4llvm11InstVisitor14visitFenceInstERNS_9FenceInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor14visitFenceInstERNS_9FenceInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitFenceInst(final FenceInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitInstruction(((/*static_cast*/Instruction /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitGetElementPtrInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 183,
   FQN="llvm::InstVisitor::visitGetElementPtrInst", NM="_ZN4llvm11InstVisitor22visitGetElementPtrInstERNS_17GetElementPtrInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor22visitGetElementPtrInstERNS_17GetElementPtrInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitGetElementPtrInst(final GetElementPtrInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitInstruction(((/*static_cast*/Instruction /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitPHINode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 184,
   FQN="llvm::InstVisitor::visitPHINode", NM="_ZN4llvm11InstVisitor12visitPHINodeERNS_7PHINodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor12visitPHINodeERNS_7PHINodeE")
  //</editor-fold>
  public default/*interface*/ RetTy visitPHINode(final PHINode /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitInstruction(((/*static_cast*/Instruction /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitTruncInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 185,
   FQN="llvm::InstVisitor::visitTruncInst", NM="_ZN4llvm11InstVisitor14visitTruncInstERNS_9TruncInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor14visitTruncInstERNS_9TruncInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitTruncInst(final TruncInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitCastInst(((/*static_cast*/CastInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitZExtInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 186,
   FQN="llvm::InstVisitor::visitZExtInst", NM="_ZN4llvm11InstVisitor13visitZExtInstERNS_8ZExtInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor13visitZExtInstERNS_8ZExtInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitZExtInst(final ZExtInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitCastInst(((/*static_cast*/CastInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitSExtInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 187,
   FQN="llvm::InstVisitor::visitSExtInst", NM="_ZN4llvm11InstVisitor13visitSExtInstERNS_8SExtInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor13visitSExtInstERNS_8SExtInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitSExtInst(final SExtInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitCastInst(((/*static_cast*/CastInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitFPTruncInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 188,
   FQN="llvm::InstVisitor::visitFPTruncInst", NM="_ZN4llvm11InstVisitor16visitFPTruncInstERNS_11FPTruncInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor16visitFPTruncInstERNS_11FPTruncInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitFPTruncInst(final FPTruncInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitCastInst(((/*static_cast*/CastInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitFPExtInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 189,
   FQN="llvm::InstVisitor::visitFPExtInst", NM="_ZN4llvm11InstVisitor14visitFPExtInstERNS_9FPExtInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor14visitFPExtInstERNS_9FPExtInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitFPExtInst(final FPExtInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitCastInst(((/*static_cast*/CastInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitFPToUIInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 190,
   FQN="llvm::InstVisitor::visitFPToUIInst", NM="_ZN4llvm11InstVisitor15visitFPToUIInstERNS_10FPToUIInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor15visitFPToUIInstERNS_10FPToUIInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitFPToUIInst(final FPToUIInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitCastInst(((/*static_cast*/CastInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitFPToSIInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 191,
   FQN="llvm::InstVisitor::visitFPToSIInst", NM="_ZN4llvm11InstVisitor15visitFPToSIInstERNS_10FPToSIInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor15visitFPToSIInstERNS_10FPToSIInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitFPToSIInst(final FPToSIInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitCastInst(((/*static_cast*/CastInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitUIToFPInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 192,
   FQN="llvm::InstVisitor::visitUIToFPInst", NM="_ZN4llvm11InstVisitor15visitUIToFPInstERNS_10UIToFPInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor15visitUIToFPInstERNS_10UIToFPInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitUIToFPInst(final UIToFPInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitCastInst(((/*static_cast*/CastInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitSIToFPInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 193,
   FQN="llvm::InstVisitor::visitSIToFPInst", NM="_ZN4llvm11InstVisitor15visitSIToFPInstERNS_10SIToFPInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor15visitSIToFPInstERNS_10SIToFPInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitSIToFPInst(final SIToFPInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitCastInst(((/*static_cast*/CastInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitPtrToIntInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 194,
   FQN="llvm::InstVisitor::visitPtrToIntInst", NM="_ZN4llvm11InstVisitor17visitPtrToIntInstERNS_12PtrToIntInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor17visitPtrToIntInstERNS_12PtrToIntInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitPtrToIntInst(final PtrToIntInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitCastInst(((/*static_cast*/CastInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitIntToPtrInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 195,
   FQN="llvm::InstVisitor::visitIntToPtrInst", NM="_ZN4llvm11InstVisitor17visitIntToPtrInstERNS_12IntToPtrInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor17visitIntToPtrInstERNS_12IntToPtrInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitIntToPtrInst(final IntToPtrInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitCastInst(((/*static_cast*/CastInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitBitCastInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 196,
   FQN="llvm::InstVisitor::visitBitCastInst", NM="_ZN4llvm11InstVisitor16visitBitCastInstERNS_11BitCastInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor16visitBitCastInstERNS_11BitCastInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitBitCastInst(final BitCastInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitCastInst(((/*static_cast*/CastInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitAddrSpaceCastInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 197,
   FQN="llvm::InstVisitor::visitAddrSpaceCastInst", NM="_ZN4llvm11InstVisitor22visitAddrSpaceCastInstERNS_17AddrSpaceCastInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor22visitAddrSpaceCastInstERNS_17AddrSpaceCastInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitAddrSpaceCastInst(final AddrSpaceCastInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitCastInst(((/*static_cast*/CastInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitSelectInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 198,
   FQN="llvm::InstVisitor::visitSelectInst", NM="_ZN4llvm11InstVisitor15visitSelectInstERNS_10SelectInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor15visitSelectInstERNS_10SelectInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitSelectInst(final SelectInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitInstruction(((/*static_cast*/Instruction /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitVAArgInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 199,
   FQN="llvm::InstVisitor::visitVAArgInst", NM="_ZN4llvm11InstVisitor14visitVAArgInstERNS_9VAArgInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor14visitVAArgInstERNS_9VAArgInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitVAArgInst(final VAArgInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitUnaryInstruction(((/*static_cast*/UnaryInstruction /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitExtractElementInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 200,
   FQN="llvm::InstVisitor::visitExtractElementInst", NM="_ZN4llvm11InstVisitor23visitExtractElementInstERNS_18ExtractElementInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor23visitExtractElementInstERNS_18ExtractElementInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitExtractElementInst(final ExtractElementInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitInstruction(((/*static_cast*/Instruction /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitInsertElementInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 201,
   FQN="llvm::InstVisitor::visitInsertElementInst", NM="_ZN4llvm11InstVisitor22visitInsertElementInstERNS_17InsertElementInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor22visitInsertElementInstERNS_17InsertElementInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitInsertElementInst(final InsertElementInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitInstruction(((/*static_cast*/Instruction /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitShuffleVectorInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 202,
   FQN="llvm::InstVisitor::visitShuffleVectorInst", NM="_ZN4llvm11InstVisitor22visitShuffleVectorInstERNS_17ShuffleVectorInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor22visitShuffleVectorInstERNS_17ShuffleVectorInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitShuffleVectorInst(final ShuffleVectorInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitInstruction(((/*static_cast*/Instruction /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitExtractValueInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 203,
   FQN="llvm::InstVisitor::visitExtractValueInst", NM="_ZN4llvm11InstVisitor21visitExtractValueInstERNS_16ExtractValueInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor21visitExtractValueInstERNS_16ExtractValueInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitExtractValueInst(final ExtractValueInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitUnaryInstruction(((/*static_cast*/UnaryInstruction /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitInsertValueInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 204,
   FQN="llvm::InstVisitor::visitInsertValueInst", NM="_ZN4llvm11InstVisitor20visitInsertValueInstERNS_15InsertValueInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor20visitInsertValueInstERNS_15InsertValueInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitInsertValueInst(final InsertValueInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitInstruction(((/*static_cast*/Instruction /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitLandingPadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 205,
   FQN="llvm::InstVisitor::visitLandingPadInst", NM="_ZN4llvm11InstVisitor19visitLandingPadInstERNS_14LandingPadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor19visitLandingPadInstERNS_14LandingPadInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitLandingPadInst(final LandingPadInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitInstruction(((/*static_cast*/Instruction /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitFuncletPadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 206,
   FQN="llvm::InstVisitor::visitFuncletPadInst", NM="_ZN4llvm11InstVisitor19visitFuncletPadInstERNS_14FuncletPadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor19visitFuncletPadInstERNS_14FuncletPadInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitFuncletPadInst(final FuncletPadInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitInstruction(((/*static_cast*/Instruction /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitCleanupPadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 207,
   FQN="llvm::InstVisitor::visitCleanupPadInst", NM="_ZN4llvm11InstVisitor19visitCleanupPadInstERNS_14CleanupPadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor19visitCleanupPadInstERNS_14CleanupPadInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitCleanupPadInst(final CleanupPadInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitFuncletPadInst(((/*static_cast*/FuncletPadInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitCatchPadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 208,
   FQN="llvm::InstVisitor::visitCatchPadInst", NM="_ZN4llvm11InstVisitor17visitCatchPadInstERNS_12CatchPadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor17visitCatchPadInstERNS_12CatchPadInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitCatchPadInst(final CatchPadInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitFuncletPadInst(((/*static_cast*/FuncletPadInst /*&*/ )(I)));
  }


  // Handle the special instrinsic instruction classes.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitDbgDeclareInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 211,
   FQN="llvm::InstVisitor::visitDbgDeclareInst", NM="_ZN4llvm11InstVisitor19visitDbgDeclareInstERNS_14DbgDeclareInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor19visitDbgDeclareInstERNS_14DbgDeclareInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitDbgDeclareInst(final DbgDeclareInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitDbgInfoIntrinsic(((/*static_cast*/DbgInfoIntrinsic /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitDbgValueInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 212,
   FQN="llvm::InstVisitor::visitDbgValueInst", NM="_ZN4llvm11InstVisitor17visitDbgValueInstERNS_12DbgValueInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor17visitDbgValueInstERNS_12DbgValueInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitDbgValueInst(final DbgValueInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitDbgInfoIntrinsic(((/*static_cast*/DbgInfoIntrinsic /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitDbgInfoIntrinsic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 213,
   FQN="llvm::InstVisitor::visitDbgInfoIntrinsic", NM="_ZN4llvm11InstVisitor21visitDbgInfoIntrinsicERNS_16DbgInfoIntrinsicE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor21visitDbgInfoIntrinsicERNS_16DbgInfoIntrinsicE")
  //</editor-fold>
  public default/*interface*/ RetTy visitDbgInfoIntrinsic(final DbgInfoIntrinsic /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitIntrinsicInst(((/*static_cast*/IntrinsicInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitMemSetInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 214,
   FQN="llvm::InstVisitor::visitMemSetInst", NM="_ZN4llvm11InstVisitor15visitMemSetInstERNS_10MemSetInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor15visitMemSetInstERNS_10MemSetInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitMemSetInst(final MemSetInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitMemIntrinsic(((/*static_cast*/MemIntrinsic /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitMemCpyInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 215,
   FQN="llvm::InstVisitor::visitMemCpyInst", NM="_ZN4llvm11InstVisitor15visitMemCpyInstERNS_10MemCpyInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor15visitMemCpyInstERNS_10MemCpyInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitMemCpyInst(final MemCpyInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitMemTransferInst(((/*static_cast*/MemTransferInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitMemMoveInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 216,
   FQN="llvm::InstVisitor::visitMemMoveInst", NM="_ZN4llvm11InstVisitor16visitMemMoveInstERNS_11MemMoveInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor16visitMemMoveInstERNS_11MemMoveInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitMemMoveInst(final MemMoveInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitMemTransferInst(((/*static_cast*/MemTransferInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitMemTransferInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 217,
   FQN="llvm::InstVisitor::visitMemTransferInst", NM="_ZN4llvm11InstVisitor20visitMemTransferInstERNS_15MemTransferInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor20visitMemTransferInstERNS_15MemTransferInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitMemTransferInst(final MemTransferInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitMemIntrinsic(((/*static_cast*/MemIntrinsic /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitMemIntrinsic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 218,
   FQN="llvm::InstVisitor::visitMemIntrinsic", NM="_ZN4llvm11InstVisitor17visitMemIntrinsicERNS_12MemIntrinsicE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor17visitMemIntrinsicERNS_12MemIntrinsicE")
  //</editor-fold>
  public default/*interface*/ RetTy visitMemIntrinsic(final MemIntrinsic /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitIntrinsicInst(((/*static_cast*/IntrinsicInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitVAStartInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 219,
   FQN="llvm::InstVisitor::visitVAStartInst", NM="_ZN4llvm11InstVisitor16visitVAStartInstERNS_11VAStartInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor16visitVAStartInstERNS_11VAStartInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitVAStartInst(final VAStartInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitIntrinsicInst(((/*static_cast*/IntrinsicInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitVAEndInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 220,
   FQN="llvm::InstVisitor::visitVAEndInst", NM="_ZN4llvm11InstVisitor14visitVAEndInstERNS_9VAEndInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor14visitVAEndInstERNS_9VAEndInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitVAEndInst(final VAEndInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitIntrinsicInst(((/*static_cast*/IntrinsicInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitVACopyInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 221,
   FQN="llvm::InstVisitor::visitVACopyInst", NM="_ZN4llvm11InstVisitor15visitVACopyInstERNS_10VACopyInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor15visitVACopyInstERNS_10VACopyInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitVACopyInst(final VACopyInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitIntrinsicInst(((/*static_cast*/IntrinsicInst /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitIntrinsicInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 222,
   FQN="llvm::InstVisitor::visitIntrinsicInst", NM="_ZN4llvm11InstVisitor18visitIntrinsicInstERNS_13IntrinsicInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor18visitIntrinsicInstERNS_13IntrinsicInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitIntrinsicInst(final IntrinsicInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitCallInst(((/*static_cast*/CallInst /*&*/ )(I)));
  }


  // Call and Invoke are slightly different as they delegate first through
  // a generic CallSite visitor.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitCallInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 226,
   FQN="llvm::InstVisitor::visitCallInst", NM="_ZN4llvm11InstVisitor13visitCallInstERNS_8CallInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor13visitCallInstERNS_8CallInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitCallInst(final CallInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitCallSite($AddrOf(new CallSite(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitInvokeInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 229,
   FQN="llvm::InstVisitor::visitInvokeInst", NM="_ZN4llvm11InstVisitor15visitInvokeInstERNS_10InvokeInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor15visitInvokeInstERNS_10InvokeInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitInvokeInst(final InvokeInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitCallSite($AddrOf(new CallSite(I)));
  }


  // Next level propagators: If the user does not overload a specific
  // instruction type, they can overload one of these to get the whole class
  // of instructions...
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitCastInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 237,
   FQN="llvm::InstVisitor::visitCastInst", NM="_ZN4llvm11InstVisitor13visitCastInstERNS_8CastInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor13visitCastInstERNS_8CastInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitCastInst(final CastInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitUnaryInstruction(((/*static_cast*/UnaryInstruction /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 238,
   FQN="llvm::InstVisitor::visitBinaryOperator", NM="_ZN4llvm11InstVisitor19visitBinaryOperatorERNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor19visitBinaryOperatorERNS_14BinaryOperatorE")
  //</editor-fold>
  public default/*interface*/ RetTy visitBinaryOperator(final BinaryOperator /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitInstruction(((/*static_cast*/Instruction /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitCmpInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 239,
   FQN="llvm::InstVisitor::visitCmpInst", NM="_ZN4llvm11InstVisitor12visitCmpInstERNS_7CmpInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor12visitCmpInstERNS_7CmpInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitCmpInst(final CmpInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitInstruction(((/*static_cast*/Instruction /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitTerminatorInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 240,
   FQN="llvm::InstVisitor::visitTerminatorInst", NM="_ZN4llvm11InstVisitor19visitTerminatorInstERNS_14TerminatorInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor19visitTerminatorInstERNS_14TerminatorInstE")
  //</editor-fold>
  public default/*interface*/ RetTy visitTerminatorInst(final TerminatorInst /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitInstruction(((/*static_cast*/Instruction /*&*/ )(I)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitUnaryInstruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 241,
   FQN="llvm::InstVisitor::visitUnaryInstruction", NM="_ZN4llvm11InstVisitor21visitUnaryInstructionERNS_16UnaryInstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor21visitUnaryInstructionERNS_16UnaryInstructionE")
  //</editor-fold>
  public default/*interface*/ RetTy visitUnaryInstruction(final UnaryInstruction /*&*/ I) {
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitInstruction(((/*static_cast*/Instruction /*&*/ )(I)));
  }


  // Provide a special visitor for a 'callsite' that visits both calls and
  // invokes. When unimplemented, properly delegates to either the terminator or
  // regular instruction visitor.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitCallSite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 246,
   FQN="llvm::InstVisitor::visitCallSite", NM="_ZN4llvm11InstVisitor13visitCallSiteENS_8CallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor13visitCallSiteENS_8CallSiteE")
  //</editor-fold>
  public default/*interface*/ RetTy visitCallSite(CallSite CS) {
    assert ((CS).$bool());
    final Instruction /*&*/ I = $Deref(CS.getInstruction());
    if (CS.isCall()) {
      return ((/*static_cast*/SubClass /*P*/ )(this)).visitInstruction(((/*static_cast*/Instruction /*&*/ )(I)));
    }
    assert (CS.isInvoke());
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitTerminatorInst(((/*static_cast*/TerminatorInst /*&*/ )(I)));
  }


  // If the user wants a 'default' case, they can choose to override this
  // function.  If this function is not overloaded in the user's subclass, then
  // this instruction just gets ignored.
  //
  // Note that you MUST override this function if your return type is not void.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::visitInstruction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 262,
   FQN="llvm::InstVisitor::visitInstruction", NM="_ZN4llvm11InstVisitor16visitInstructionERNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor16visitInstructionERNS_11InstructionE")
  //</editor-fold>
  public default/*interface*/ RetTy visitInstruction(final Instruction /*&*/ I) {
    return null;
  } // Ignore unhandled instructions

/*private:*/
  // Special helper function to delegate to CallInst subclass visitors.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::delegateCallInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 266,
   FQN="llvm::InstVisitor::delegateCallInst", NM="_ZN4llvm11InstVisitor16delegateCallInstERNS_8CallInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor16delegateCallInstERNS_8CallInstE")
  //</editor-fold>
  public/*private*/ default/*interface*/ RetTy delegateCallInst(final CallInst /*&*/ I) {
    {
      /*const*/ Function /*P*/ F = I.getCalledFunction();
      if ((F != null)) {
        switch (F.getIntrinsicID()) {
         default:
          return ((/*static_cast*/SubClass /*P*/ )(this)).visitIntrinsicInst(((/*static_cast*/IntrinsicInst /*&*/ )(I)));
         case ID.dbg_declare:
          return ((/*static_cast*/SubClass /*P*/ )(this)).visitDbgDeclareInst(((/*static_cast*/DbgDeclareInst /*&*/ )(I)));
         case ID.dbg_value:
          return ((/*static_cast*/SubClass /*P*/ )(this)).visitDbgValueInst(((/*static_cast*/DbgValueInst /*&*/ )(I)));
         case ID.memcpy:
          return ((/*static_cast*/SubClass /*P*/ )(this)).visitMemCpyInst(((/*static_cast*/MemCpyInst /*&*/ )(I)));
         case ID.memmove:
          return ((/*static_cast*/SubClass /*P*/ )(this)).visitMemMoveInst(((/*static_cast*/MemMoveInst /*&*/ )(I)));
         case ID.memset:
          return ((/*static_cast*/SubClass /*P*/ )(this)).visitMemSetInst(((/*static_cast*/MemSetInst /*&*/ )(I)));
         case ID.vastart:
          return ((/*static_cast*/SubClass /*P*/ )(this)).visitVAStartInst(((/*static_cast*/VAStartInst /*&*/ )(I)));
         case ID.vaend:
          return ((/*static_cast*/SubClass /*P*/ )(this)).visitVAEndInst(((/*static_cast*/VAEndInst /*&*/ )(I)));
         case ID.vacopy:
          return ((/*static_cast*/SubClass /*P*/ )(this)).visitVACopyInst(((/*static_cast*/VACopyInst /*&*/ )(I)));
         case ID.not_intrinsic:
          break;
        }
      }
    }
    return ((/*static_cast*/SubClass /*P*/ )(this)).visitCallInst(((/*static_cast*/CallInst /*&*/ )(I)));
  }


  // An overload that will never actually be called, it is used only from dead
  // code in the dispatching from opcodes to instruction subclasses.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstVisitor::delegateCallInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstVisitor.h", line = 286,
   FQN="llvm::InstVisitor::delegateCallInst", NM="_ZN4llvm11InstVisitor16delegateCallInstERNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm11InstVisitor16delegateCallInstERNS_11InstructionE")
  //</editor-fold>
  public/*private*/ default/*interface*/ RetTy delegateCallInst(final Instruction /*&*/ I) {
    throw new llvm_unreachable("delegateCallInst called for non-CallInst");
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public default void $InstVisitor() {}

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
}
