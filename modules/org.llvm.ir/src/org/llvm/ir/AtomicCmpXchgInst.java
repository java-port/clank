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
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.support.AdtsupportLlvmGlobals.isStrongerThan;


//===----------------------------------------------------------------------===//
//                                AtomicCmpXchgInst Class
//===----------------------------------------------------------------------===//

/// AtomicCmpXchgInst - an instruction that atomically checks whether a
/// specified value is in a memory location, and, if it is, stores a new value
/// there.  Returns the value that was loaded.
///
//<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 509,
 FQN="llvm::AtomicCmpXchgInst", NM="_ZN4llvm17AtomicCmpXchgInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInstE")
//</editor-fold>
public class AtomicCmpXchgInst extends /*public*/ Instruction implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 510,
   FQN="llvm::AtomicCmpXchgInst::operator new", NM="_ZN4llvm17AtomicCmpXchgInstnwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInstnwEjj")
  //</editor-fold>
  protected/*private*/ static Object/*void P*/ $new_AtomicCmpXchgInst(/*size_t*/int $Prm0, /*uint*/int $Prm1) { throw new UnsupportedOperationException("Deleted");}


  //===----------------------------------------------------------------------===//
  //                       AtomicCmpXchgInst Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::Init">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1510,
   FQN="llvm::AtomicCmpXchgInst::Init", NM="_ZN4llvm17AtomicCmpXchgInst4InitEPNS_5ValueES2_S2_NS_14AtomicOrderingES3_NS_20SynchronizationScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInst4InitEPNS_5ValueES2_S2_NS_14AtomicOrderingES3_NS_20SynchronizationScopeE")
  //</editor-fold>
  private void Init(Value /*P*/ Ptr, Value /*P*/ Cmp, Value /*P*/ NewVal,
      AtomicOrdering SuccessOrdering,
      AtomicOrdering FailureOrdering,
      SynchronizationScope SynchScope) {
    this.Op(0).$assign(Ptr);
    this.Op(1).$assign(Cmp);
    this.Op(2).$assign(NewVal);
    setSuccessOrdering(SuccessOrdering);
    setFailureOrdering(FailureOrdering);
    setSynchScope(SynchScope);
    assert ((getOperand(0) != null) && (getOperand(1) != null) && (getOperand(2) != null)) : "All operands must be non-null!";
    assert (getOperand(0).getType().isPointerTy()) : "Ptr must have pointer type!";
    assert (getOperand(1).getType() == cast_PointerType(getOperand(0).getType()).getElementType()) : "Ptr must be a pointer to Cmp type!";
    assert (getOperand(2).getType() == cast_PointerType(getOperand(0).getType()).getElementType()) : "Ptr must be a pointer to NewVal type!";
    assert (SuccessOrdering != AtomicOrdering.NotAtomic) : "AtomicCmpXchg instructions must be atomic!";
    assert (FailureOrdering != AtomicOrdering.NotAtomic) : "AtomicCmpXchg instructions must be atomic!";
    assert (!isStrongerThan(FailureOrdering, SuccessOrdering)) : "AtomicCmpXchg failure argument shall be no stronger than the success argument";
    assert (FailureOrdering != AtomicOrdering.Release && FailureOrdering != AtomicOrdering.AcquireRelease) : "AtomicCmpXchg failure ordering cannot include release semantics";
  }

/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::cloneImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3933,
   FQN="llvm::AtomicCmpXchgInst::cloneImpl", NM="_ZNK4llvm17AtomicCmpXchgInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17AtomicCmpXchgInst9cloneImplEv")
  //</editor-fold>
  protected AtomicCmpXchgInst /*P*/ cloneImpl() /*const*/ {
    AtomicCmpXchgInst /*P*/ Result = /*NEW_EXPR [AtomicCmpXchgInst::new]*/AtomicCmpXchgInst.$new_AtomicCmpXchgInst((type$ptr<?> New$Mem)->{
        return new AtomicCmpXchgInst(getOperand(0), getOperand(1), getOperand(2),
                getSuccessOrdering(), getFailureOrdering(),
                getSynchScope());
     });
    Result.setVolatile(isVolatile());
    Result.setWeak(isWeak());
    return Result;
  }

/*public:*/
  // allocate space for exactly three operands
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::operator new">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 522,
   FQN="llvm::AtomicCmpXchgInst::operator new", NM="_ZN4llvm17AtomicCmpXchgInstnwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInstnwEj")
  //</editor-fold>
  public static <T extends AtomicCmpXchgInst> T/*void P*/ $new_AtomicCmpXchgInst(New$ConstructorCallback<T> $Ctor) {
    return User.$new_FixedUses(/*s, */3, $Ctor);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::AtomicCmpXchgInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1543,
   FQN="llvm::AtomicCmpXchgInst::AtomicCmpXchgInst", NM="_ZN4llvm17AtomicCmpXchgInstC1EPNS_5ValueES2_S2_NS_14AtomicOrderingES3_NS_20SynchronizationScopeEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInstC1EPNS_5ValueES2_S2_NS_14AtomicOrderingES3_NS_20SynchronizationScopeEPNS_11InstructionE")
  //</editor-fold>
  public AtomicCmpXchgInst(Value /*P*/ Ptr, Value /*P*/ Cmp, Value /*P*/ NewVal,
      AtomicOrdering SuccessOrdering,
      AtomicOrdering FailureOrdering,
      SynchronizationScope SynchScope) {
    this(Ptr, Cmp, NewVal,
      SuccessOrdering,
      FailureOrdering,
      SynchScope,
      (Instruction /*P*/ )null);
  }
  public AtomicCmpXchgInst(Value /*P*/ Ptr, Value /*P*/ Cmp, Value /*P*/ NewVal,
      AtomicOrdering SuccessOrdering,
      AtomicOrdering FailureOrdering,
      SynchronizationScope SynchScope,
      Instruction /*P*/ InsertBefore/*= null*/) {
    // : Instruction(StructType::get(Cmp->getType(), Type::getInt1Ty(Cmp->getContext()), null), AtomicCmpXchg, OperandTraits<AtomicCmpXchgInst>::op_begin(this), OperandTraits<AtomicCmpXchgInst>::operands(this), InsertBefore)
    //START JInit
    super(StructType.get(Cmp.getType(), Type.getInt1Ty(Cmp.getContext()),
            null),
        MemoryOps.AtomicCmpXchg, OperandTraitsAtomicCmpXchgInst.<AtomicCmpXchgInst>op_begin(User.$BEING_CREATED()/*this*/),
        OperandTraitsAtomicCmpXchgInst.<AtomicCmpXchgInst>operands$FixedNumOperandTraits(User.$BEING_CREATED()/*this*/), InsertBefore);
    //END JInit
    Init(Ptr, Cmp, NewVal, SuccessOrdering, FailureOrdering, SynchScope);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::AtomicCmpXchgInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1556,
   FQN="llvm::AtomicCmpXchgInst::AtomicCmpXchgInst", NM="_ZN4llvm17AtomicCmpXchgInstC1EPNS_5ValueES2_S2_NS_14AtomicOrderingES3_NS_20SynchronizationScopeEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInstC1EPNS_5ValueES2_S2_NS_14AtomicOrderingES3_NS_20SynchronizationScopeEPNS_10BasicBlockE")
  //</editor-fold>
  public AtomicCmpXchgInst(Value /*P*/ Ptr, Value /*P*/ Cmp, Value /*P*/ NewVal,
      AtomicOrdering SuccessOrdering,
      AtomicOrdering FailureOrdering,
      SynchronizationScope SynchScope,
      BasicBlock /*P*/ InsertAtEnd) {
    // : Instruction(StructType::get(Cmp->getType(), Type::getInt1Ty(Cmp->getContext()), null), AtomicCmpXchg, OperandTraits<AtomicCmpXchgInst>::op_begin(this), OperandTraits<AtomicCmpXchgInst>::operands(this), InsertAtEnd)
    //START JInit
    super(StructType.get(Cmp.getType(), Type.getInt1Ty(Cmp.getContext()),
            null),
        MemoryOps.AtomicCmpXchg, OperandTraitsAtomicCmpXchgInst.<AtomicCmpXchgInst>op_begin(User.$BEING_CREATED()/*this*/),
        OperandTraitsAtomicCmpXchgInst.<AtomicCmpXchgInst>operands$FixedNumOperandTraits(User.$BEING_CREATED()/*this*/), InsertAtEnd);
    //END JInit
    Init(Ptr, Cmp, NewVal, SuccessOrdering, FailureOrdering, SynchScope);
  }


  /// isVolatile - Return true if this is a cmpxchg from a volatile memory
  /// location.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::isVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 539,
   FQN="llvm::AtomicCmpXchgInst::isVolatile", NM="_ZNK4llvm17AtomicCmpXchgInst10isVolatileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17AtomicCmpXchgInst10isVolatileEv")
  //</editor-fold>
  public boolean isVolatile() /*const*/ {
    return ((getSubclassDataFromInstruction() & 1) != 0);
  }


  /// setVolatile - Specify whether this is a volatile cmpxchg.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::setVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 545,
   FQN="llvm::AtomicCmpXchgInst::setVolatile", NM="_ZN4llvm17AtomicCmpXchgInst11setVolatileEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInst11setVolatileEb")
  //</editor-fold>
  public void setVolatile(boolean V) {
    setInstructionSubclassData_AtomicCmpXchgInst($uint2ushort((getSubclassDataFromInstruction() & ~1)
           | (/*uint*/int)(V ? 1 : 0)));
  }


  /// Return true if this cmpxchg may spuriously fail.
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::isWeak">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 551,
   FQN="llvm::AtomicCmpXchgInst::isWeak", NM="_ZNK4llvm17AtomicCmpXchgInst6isWeakEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17AtomicCmpXchgInst6isWeakEv")
  //</editor-fold>
  public boolean isWeak() /*const*/ {
    return ((getSubclassDataFromInstruction() & 0x100) != 0);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::setWeak">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 555,
   FQN="llvm::AtomicCmpXchgInst::setWeak", NM="_ZN4llvm17AtomicCmpXchgInst7setWeakEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInst7setWeakEb")
  //</editor-fold>
  public void setWeak(boolean IsWeak) {
    setInstructionSubclassData_AtomicCmpXchgInst($uint2ushort((getSubclassDataFromInstruction() & ~0x100)
           | (IsWeak ? 1 : 0 << 8)));
  }


  /// Transparently provide more efficient getOperand methods.
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 661,
   FQN="llvm::AtomicCmpXchgInst::getOperand", NM="_ZNK4llvm17AtomicCmpXchgInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17AtomicCmpXchgInst10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsAtomicCmpXchgInst.<AtomicCmpXchgInst>operands$FixedNumOperandTraits(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsAtomicCmpXchgInst.<AtomicCmpXchgInst>op_begin(((/*const_cast*/AtomicCmpXchgInst /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 661,
   FQN="llvm::AtomicCmpXchgInst::setOperand", NM="_ZN4llvm17AtomicCmpXchgInst10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInst10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsAtomicCmpXchgInst.<AtomicCmpXchgInst>operands$FixedNumOperandTraits(this))) : "setOperand() out of range!";
    OperandTraitsAtomicCmpXchgInst.<AtomicCmpXchgInst>op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 661,
   FQN="llvm::AtomicCmpXchgInst::op_begin", NM="_ZN4llvm17AtomicCmpXchgInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInst8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsAtomicCmpXchgInst.<AtomicCmpXchgInst>op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 661,
   FQN="llvm::AtomicCmpXchgInst::op_begin", NM="_ZNK4llvm17AtomicCmpXchgInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17AtomicCmpXchgInst8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsAtomicCmpXchgInst.<AtomicCmpXchgInst>op_begin(((/*const_cast*/AtomicCmpXchgInst /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 661,
   FQN="llvm::AtomicCmpXchgInst::op_end", NM="_ZN4llvm17AtomicCmpXchgInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInst6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsAtomicCmpXchgInst.<AtomicCmpXchgInst>op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 661,
   FQN="llvm::AtomicCmpXchgInst::op_end", NM="_ZNK4llvm17AtomicCmpXchgInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17AtomicCmpXchgInst6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsAtomicCmpXchgInst.<AtomicCmpXchgInst>op_end(((/*const_cast*/AtomicCmpXchgInst /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 661,
   FQN="llvm::AtomicCmpXchgInst::Op", NM="Tpl__ZN4llvm17AtomicCmpXchgInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm17AtomicCmpXchgInst2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this.OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 661,
   FQN="llvm::AtomicCmpXchgInst::Op", NM="Tpl__ZNK4llvm17AtomicCmpXchgInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm17AtomicCmpXchgInst2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this.OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 661,
   FQN="llvm::AtomicCmpXchgInst::getNumOperands", NM="_ZNK4llvm17AtomicCmpXchgInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17AtomicCmpXchgInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsAtomicCmpXchgInst.<AtomicCmpXchgInst>operands$FixedNumOperandTraits(this);
  }


  /// Set the ordering constraint on this cmpxchg.
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::setSuccessOrdering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 564,
   FQN="llvm::AtomicCmpXchgInst::setSuccessOrdering", NM="_ZN4llvm17AtomicCmpXchgInst18setSuccessOrderingENS_14AtomicOrderingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInst18setSuccessOrderingENS_14AtomicOrderingE")
  //</editor-fold>
  public void setSuccessOrdering(AtomicOrdering Ordering) {
    assert (Ordering != AtomicOrdering.NotAtomic) : "CmpXchg instructions can only be atomic.";
    setInstructionSubclassData_AtomicCmpXchgInst($uint2ushort((getSubclassDataFromInstruction() & ~0x1c)
           | (((/*uint*/int)Ordering.getValue()) << 2)));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::setFailureOrdering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 571,
   FQN="llvm::AtomicCmpXchgInst::setFailureOrdering", NM="_ZN4llvm17AtomicCmpXchgInst18setFailureOrderingENS_14AtomicOrderingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInst18setFailureOrderingENS_14AtomicOrderingE")
  //</editor-fold>
  public void setFailureOrdering(AtomicOrdering Ordering) {
    assert (Ordering != AtomicOrdering.NotAtomic) : "CmpXchg instructions can only be atomic.";
    setInstructionSubclassData_AtomicCmpXchgInst($uint2ushort((getSubclassDataFromInstruction() & ~0xe0)
           | (((/*uint*/int)Ordering.getValue()) << 5)));
  }


  /// Specify whether this cmpxchg is atomic and orders other operations with
  /// respect to all concurrently executing threads, or only with respect to
  /// signal handlers executing in the same thread.
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::setSynchScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 581,
   FQN="llvm::AtomicCmpXchgInst::setSynchScope", NM="_ZN4llvm17AtomicCmpXchgInst13setSynchScopeENS_20SynchronizationScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInst13setSynchScopeENS_20SynchronizationScopeE")
  //</editor-fold>
  public void setSynchScope(SynchronizationScope SynchScope) {
    setInstructionSubclassData_AtomicCmpXchgInst($uint2ushort((getSubclassDataFromInstruction() & ~2)
           | (SynchScope.getValue() << 1)));
  }


  /// Returns the ordering constraint on this cmpxchg.
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::getSuccessOrdering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 587,
   FQN="llvm::AtomicCmpXchgInst::getSuccessOrdering", NM="_ZNK4llvm17AtomicCmpXchgInst18getSuccessOrderingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17AtomicCmpXchgInst18getSuccessOrderingEv")
  //</editor-fold>
  public AtomicOrdering getSuccessOrdering() /*const*/ {
    return AtomicOrdering.valueOf((getSubclassDataFromInstruction() >>> 2) & 7);
  }


  /// Returns the ordering constraint on this cmpxchg.
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::getFailureOrdering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 592,
   FQN="llvm::AtomicCmpXchgInst::getFailureOrdering", NM="_ZNK4llvm17AtomicCmpXchgInst18getFailureOrderingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17AtomicCmpXchgInst18getFailureOrderingEv")
  //</editor-fold>
  public AtomicOrdering getFailureOrdering() /*const*/ {
    return AtomicOrdering.valueOf((getSubclassDataFromInstruction() >>> 5) & 7);
  }


  /// Returns whether this cmpxchg is atomic between threads or only within a
  /// single thread.
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::getSynchScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 598,
   FQN="llvm::AtomicCmpXchgInst::getSynchScope", NM="_ZNK4llvm17AtomicCmpXchgInst13getSynchScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17AtomicCmpXchgInst13getSynchScopeEv")
  //</editor-fold>
  public SynchronizationScope getSynchScope() /*const*/ {
    return SynchronizationScope.valueOf((getSubclassDataFromInstruction() & 2) >>> 1);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::getPointerOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 602,
   FQN="llvm::AtomicCmpXchgInst::getPointerOperand", NM="_ZN4llvm17AtomicCmpXchgInst17getPointerOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInst17getPointerOperandEv")
  //</editor-fold>
  public Value /*P*/ getPointerOperand() {
    return getOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::getPointerOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 603,
   FQN="llvm::AtomicCmpXchgInst::getPointerOperand", NM="_ZNK4llvm17AtomicCmpXchgInst17getPointerOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17AtomicCmpXchgInst17getPointerOperandEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getPointerOperand$Const() /*const*/ {
    return getOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::getPointerOperandIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 604,
   FQN="llvm::AtomicCmpXchgInst::getPointerOperandIndex", NM="_ZN4llvm17AtomicCmpXchgInst22getPointerOperandIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInst22getPointerOperandIndexEv")
  //</editor-fold>
  public static /*uint*/int getPointerOperandIndex() {
    return 0/*U*/;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::getCompareOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 606,
   FQN="llvm::AtomicCmpXchgInst::getCompareOperand", NM="_ZN4llvm17AtomicCmpXchgInst17getCompareOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInst17getCompareOperandEv")
  //</editor-fold>
  public Value /*P*/ getCompareOperand() {
    return getOperand(1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::getCompareOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 607,
   FQN="llvm::AtomicCmpXchgInst::getCompareOperand", NM="_ZNK4llvm17AtomicCmpXchgInst17getCompareOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17AtomicCmpXchgInst17getCompareOperandEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getCompareOperand$Const() /*const*/ {
    return getOperand(1);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::getNewValOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 609,
   FQN="llvm::AtomicCmpXchgInst::getNewValOperand", NM="_ZN4llvm17AtomicCmpXchgInst16getNewValOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInst16getNewValOperandEv")
  //</editor-fold>
  public Value /*P*/ getNewValOperand() {
    return getOperand(2);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::getNewValOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 610,
   FQN="llvm::AtomicCmpXchgInst::getNewValOperand", NM="_ZNK4llvm17AtomicCmpXchgInst16getNewValOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17AtomicCmpXchgInst16getNewValOperandEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getNewValOperand$Const() /*const*/ {
    return getOperand(2);
  }


  /// \brief Returns the address space of the pointer operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::getPointerAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 613,
   FQN="llvm::AtomicCmpXchgInst::getPointerAddressSpace", NM="_ZNK4llvm17AtomicCmpXchgInst22getPointerAddressSpaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17AtomicCmpXchgInst22getPointerAddressSpaceEv")
  //</editor-fold>
  public /*uint*/int getPointerAddressSpace() /*const*/ {
    return getPointerOperand$Const().getType().getPointerAddressSpace();
  }


  /// \brief Returns the strongest permitted ordering on failure, given the
  /// desired ordering on success.
  ///
  /// If the comparison in a cmpxchg operation fails, there is no atomic store
  /// so release semantics cannot be provided. So this function drops explicit
  /// Release requests from the AtomicOrdering. A SequentiallyConsistent
  /// operation would remain SequentiallyConsistent.
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::getStrongestFailureOrdering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 624,
   FQN="llvm::AtomicCmpXchgInst::getStrongestFailureOrdering", NM="_ZN4llvm17AtomicCmpXchgInst27getStrongestFailureOrderingENS_14AtomicOrderingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInst27getStrongestFailureOrderingENS_14AtomicOrderingE")
  //</editor-fold>
  public static AtomicOrdering getStrongestFailureOrdering(AtomicOrdering SuccessOrdering) {
    switch (SuccessOrdering) {
     default:
      throw new llvm_unreachable("invalid cmpxchg success ordering");
     case Release:
     case Monotonic:
      return AtomicOrdering.Monotonic;
     case AcquireRelease:
     case Acquire:
      return AtomicOrdering.Acquire;
     case SequentiallyConsistent:
      return AtomicOrdering.SequentiallyConsistent;
    }
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 641,
   FQN="llvm::AtomicCmpXchgInst::classof", NM="_ZN4llvm17AtomicCmpXchgInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.MemoryOps.AtomicCmpXchg;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 644,
   FQN="llvm::AtomicCmpXchgInst::classof", NM="_ZN4llvm17AtomicCmpXchgInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && AtomicCmpXchgInst.classof(cast_Instruction(V));
  }

/*private:*/
  // Shadow Instruction::setInstructionSubclassData with a private forwarding
  // method so that subclasses cannot accidentally use it.
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::setInstructionSubclassData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 651,
   FQN="llvm::AtomicCmpXchgInst::setInstructionSubclassData", NM="_ZN4llvm17AtomicCmpXchgInst26setInstructionSubclassDataEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInst26setInstructionSubclassDataEt")
  //</editor-fold>
  private void setInstructionSubclassData_AtomicCmpXchgInst(/*ushort*/char D) {
    super.setInstructionSubclassData(D);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicCmpXchgInst::~AtomicCmpXchgInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 509,
   FQN="llvm::AtomicCmpXchgInst::~AtomicCmpXchgInst", NM="_ZN4llvm17AtomicCmpXchgInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AtomicCmpXchgInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
