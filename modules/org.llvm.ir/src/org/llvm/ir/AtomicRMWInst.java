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


//===----------------------------------------------------------------------===//
//                                AtomicRMWInst Class
//===----------------------------------------------------------------------===//

/// AtomicRMWInst - an instruction that atomically reads a memory location,
/// combines it with another value, and then stores the result back.  Returns
/// the old value.
///
//<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 671,
 FQN="llvm::AtomicRMWInst", NM="_ZN4llvm13AtomicRMWInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm13AtomicRMWInstE")
//</editor-fold>
public class AtomicRMWInst extends /*public*/ Instruction implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 672,
   FQN="llvm::AtomicRMWInst::operator new", NM="_ZN4llvm13AtomicRMWInstnwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm13AtomicRMWInstnwEjj")
  //</editor-fold>
  protected/*private*/ static Object/*void P*/ $new_AtomicRMWInst(/*size_t*/int $Prm0, /*uint*/int $Prm1) { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::cloneImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3943,
   FQN="llvm::AtomicRMWInst::cloneImpl", NM="_ZNK4llvm13AtomicRMWInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm13AtomicRMWInst9cloneImplEv")
  //</editor-fold>
  protected AtomicRMWInst /*P*/ cloneImpl() /*const*/ {
    AtomicRMWInst /*P*/ Result = /*NEW_EXPR [AtomicRMWInst::new]*/AtomicRMWInst.$new_AtomicRMWInst((type$ptr<?> New$Mem)->{
        return new AtomicRMWInst(getOperation(), getOperand(0), getOperand(1),
                getOrdering(), getSynchScope());
     });
    Result.setVolatile(isVolatile());
    return Result;
  }

/*public:*/
  /// This enumeration lists the possible modifications atomicrmw can make.  In
  /// the descriptions, 'p' is the pointer to the instruction's memory location,
  /// 'old' is the initial value of *p, and 'v' is the other value passed to the
  /// instruction.  These instructions always return 'old'.
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::BinOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 684,
   FQN="llvm::AtomicRMWInst::BinOp", NM="_ZN4llvm13AtomicRMWInst5BinOpE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm13AtomicRMWInst5BinOpE")
  //</editor-fold>
  public enum BinOp implements Native.NativeUIntEnum {
    /// *p = v
    Xchg(0),
    /// *p = old + v
    Add(Xchg.getValue() + 1),
    /// *p = old - v
    Sub(Add.getValue() + 1),
    /// *p = old & v
    And(Sub.getValue() + 1),
    /// *p = ~(old & v)
    Nand(And.getValue() + 1),
    /// *p = old | v
    Or(Nand.getValue() + 1),
    /// *p = old ^ v
    Xor(Or.getValue() + 1),
    /// *p = old >signed v ? old : v
    Max(Xor.getValue() + 1),
    /// *p = old <signed v ? old : v
    Min(Max.getValue() + 1),
    /// *p = old >unsigned v ? old : v
    UMax(Min.getValue() + 1),
    /// *p = old <unsigned v ? old : v
    UMin(UMax.getValue() + 1),

    FIRST_BINOP(BinOp.Xchg.getValue()),
    LAST_BINOP(BinOp.UMin.getValue()),
    BAD_BINOP(LAST_BINOP.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static BinOp valueOf(int val) {
      BinOp out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final BinOp[] VALUES;
      private static final BinOp[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (BinOp kind : BinOp.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new BinOp[min < 0 ? (1-min) : 0];
        VALUES = new BinOp[max >= 0 ? (1+max) : 0];
        for (BinOp kind : BinOp.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private BinOp(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };

  // allocate space for exactly two operands
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::operator new">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 714,
   FQN="llvm::AtomicRMWInst::operator new", NM="_ZN4llvm13AtomicRMWInstnwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm13AtomicRMWInstnwEj")
  //</editor-fold>
  public static <T extends AtomicRMWInst> /*void P*/ T $new_AtomicRMWInst(New$ConstructorCallback<T> $Ctor) {
    return User.$new_FixedUses(/*s, */2, $Ctor);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::AtomicRMWInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1593,
   FQN="llvm::AtomicRMWInst::AtomicRMWInst", NM="_ZN4llvm13AtomicRMWInstC1ENS0_5BinOpEPNS_5ValueES3_NS_14AtomicOrderingENS_20SynchronizationScopeEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm13AtomicRMWInstC1ENS0_5BinOpEPNS_5ValueES3_NS_14AtomicOrderingENS_20SynchronizationScopeEPNS_11InstructionE")
  //</editor-fold>
  public AtomicRMWInst(BinOp Operation, Value /*P*/ Ptr, Value /*P*/ Val,
      AtomicOrdering Ordering,
      SynchronizationScope SynchScope) {
    this(Operation, Ptr, Val,
      Ordering,
      SynchScope,
      (Instruction /*P*/ )null);
  }
  public AtomicRMWInst(BinOp Operation, Value /*P*/ Ptr, Value /*P*/ Val,
      AtomicOrdering Ordering,
      SynchronizationScope SynchScope,
      Instruction /*P*/ InsertBefore/*= null*/) {
    // : Instruction(Val->getType(), AtomicRMW, OperandTraits<AtomicRMWInst>::op_begin(this), OperandTraits<AtomicRMWInst>::operands(this), InsertBefore)
    //START JInit
    super(Val.getType(), MemoryOps.AtomicRMW,
        OperandTraitsAtomicRMWInst.<AtomicRMWInst>op_begin(User.$BEING_CREATED()/*this*/),
        OperandTraitsAtomicRMWInst.<AtomicRMWInst>operands$FixedNumOperandTraits(User.$BEING_CREATED()/*this*/),
        InsertBefore);
    //END JInit
    Init(Operation, Ptr, Val, Ordering, SynchScope);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::AtomicRMWInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1604,
   FQN="llvm::AtomicRMWInst::AtomicRMWInst", NM="_ZN4llvm13AtomicRMWInstC1ENS0_5BinOpEPNS_5ValueES3_NS_14AtomicOrderingENS_20SynchronizationScopeEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm13AtomicRMWInstC1ENS0_5BinOpEPNS_5ValueES3_NS_14AtomicOrderingENS_20SynchronizationScopeEPNS_10BasicBlockE")
  //</editor-fold>
  public AtomicRMWInst(BinOp Operation, Value /*P*/ Ptr, Value /*P*/ Val,
      AtomicOrdering Ordering,
      SynchronizationScope SynchScope,
      BasicBlock /*P*/ InsertAtEnd) {
    // : Instruction(Val->getType(), AtomicRMW, OperandTraits<AtomicRMWInst>::op_begin(this), OperandTraits<AtomicRMWInst>::operands(this), InsertAtEnd)
    //START JInit
    super(Val.getType(), MemoryOps.AtomicRMW,
        OperandTraitsAtomicRMWInst.<AtomicRMWInst>op_begin(User.$BEING_CREATED()/*this*/),
        OperandTraitsAtomicRMWInst.<AtomicRMWInst>operands$FixedNumOperandTraits(User.$BEING_CREATED()/*this*/),
        InsertAtEnd);
    //END JInit
    Init(Operation, Ptr, Val, Ordering, SynchScope);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::getOperation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 724,
   FQN="llvm::AtomicRMWInst::getOperation", NM="_ZNK4llvm13AtomicRMWInst12getOperationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm13AtomicRMWInst12getOperationEv")
  //</editor-fold>
  public BinOp getOperation() /*const*/ {
    return /*static_cast*/BinOp.valueOf(getSubclassDataFromInstruction() >>> 5);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::setOperation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 728,
   FQN="llvm::AtomicRMWInst::setOperation", NM="_ZN4llvm13AtomicRMWInst12setOperationENS0_5BinOpE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm13AtomicRMWInst12setOperationENS0_5BinOpE")
  //</editor-fold>
  public void setOperation(BinOp Operation) {
    /*ushort*/char SubclassData = $uint2ushort(getSubclassDataFromInstruction());
    setInstructionSubclassData_AtomicRMWInst($int2ushort(($ushort2int(SubclassData) & 31)
           | (Operation.getValue() << 5)));
  }


  /// isVolatile - Return true if this is a RMW on a volatile memory location.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::isVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 736,
   FQN="llvm::AtomicRMWInst::isVolatile", NM="_ZNK4llvm13AtomicRMWInst10isVolatileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm13AtomicRMWInst10isVolatileEv")
  //</editor-fold>
  public boolean isVolatile() /*const*/ {
    return ((getSubclassDataFromInstruction() & 1) != 0);
  }


  /// setVolatile - Specify whether this is a volatile RMW or not.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::setVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 742,
   FQN="llvm::AtomicRMWInst::setVolatile", NM="_ZN4llvm13AtomicRMWInst11setVolatileEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm13AtomicRMWInst11setVolatileEb")
  //</editor-fold>
  public void setVolatile(boolean V) {
    setInstructionSubclassData_AtomicRMWInst($uint2ushort((getSubclassDataFromInstruction() & ~1)
           | (/*uint*/int)(V ? 1 : 0)));
  }


  /// Transparently provide more efficient getOperand methods.
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 812,
   FQN="llvm::AtomicRMWInst::getOperand", NM="_ZNK4llvm13AtomicRMWInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm13AtomicRMWInst10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsAtomicRMWInst.<AtomicRMWInst>operands$FixedNumOperandTraits(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsAtomicRMWInst.<AtomicRMWInst>op_begin(((/*const_cast*/AtomicRMWInst /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 812,
   FQN="llvm::AtomicRMWInst::setOperand", NM="_ZN4llvm13AtomicRMWInst10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm13AtomicRMWInst10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsAtomicRMWInst.<AtomicRMWInst>operands$FixedNumOperandTraits(this))) : "setOperand() out of range!";
    OperandTraitsAtomicRMWInst.<AtomicRMWInst>op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 812,
   FQN="llvm::AtomicRMWInst::op_begin", NM="_ZN4llvm13AtomicRMWInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm13AtomicRMWInst8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsAtomicRMWInst.<AtomicRMWInst>op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 812,
   FQN="llvm::AtomicRMWInst::op_begin", NM="_ZNK4llvm13AtomicRMWInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm13AtomicRMWInst8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsAtomicRMWInst.<AtomicRMWInst>op_begin(((/*const_cast*/AtomicRMWInst /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 812,
   FQN="llvm::AtomicRMWInst::op_end", NM="_ZN4llvm13AtomicRMWInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm13AtomicRMWInst6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsAtomicRMWInst.<AtomicRMWInst>op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 812,
   FQN="llvm::AtomicRMWInst::op_end", NM="_ZNK4llvm13AtomicRMWInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm13AtomicRMWInst6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsAtomicRMWInst.<AtomicRMWInst>op_end(((/*const_cast*/AtomicRMWInst /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 812,
   FQN="llvm::AtomicRMWInst::Op", NM="Tpl__ZN4llvm13AtomicRMWInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm13AtomicRMWInst2OpEv")
  //</editor-fold>
  protected /*<int Idx_nocapture>*/ Use /*&*/ Op(int Idx_nocapture) {
    return this.OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 812,
   FQN="llvm::AtomicRMWInst::Op", NM="Tpl__ZNK4llvm13AtomicRMWInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm13AtomicRMWInst2OpEv")
  //</editor-fold>
  protected /*<int Idx_nocapture>*/ /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this.OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 812,
   FQN="llvm::AtomicRMWInst::getNumOperands", NM="_ZNK4llvm13AtomicRMWInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm13AtomicRMWInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsAtomicRMWInst.<AtomicRMWInst>operands$FixedNumOperandTraits(this);
  }


  /// Set the ordering constraint on this RMW.
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::setOrdering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 751,
   FQN="llvm::AtomicRMWInst::setOrdering", NM="_ZN4llvm13AtomicRMWInst11setOrderingENS_14AtomicOrderingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm13AtomicRMWInst11setOrderingENS_14AtomicOrderingE")
  //</editor-fold>
  public void setOrdering(AtomicOrdering Ordering) {
    assert (Ordering != AtomicOrdering.NotAtomic) : "atomicrmw instructions can only be atomic.";
    setInstructionSubclassData_AtomicRMWInst($uint2ushort((getSubclassDataFromInstruction() & ~(7 << 2))
           | (((/*uint*/int)Ordering.getValue()) << 2)));
  }


  /// Specify whether this RMW orders other operations with respect to all
  /// concurrently executing threads, or only with respect to signal handlers
  /// executing in the same thread.
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::setSynchScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 761,
   FQN="llvm::AtomicRMWInst::setSynchScope", NM="_ZN4llvm13AtomicRMWInst13setSynchScopeENS_20SynchronizationScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm13AtomicRMWInst13setSynchScopeENS_20SynchronizationScopeE")
  //</editor-fold>
  public void setSynchScope(SynchronizationScope SynchScope) {
    setInstructionSubclassData_AtomicRMWInst($uint2ushort((getSubclassDataFromInstruction() & ~2)
           | (SynchScope.getValue() << 1)));
  }


  /// Returns the ordering constraint on this RMW.
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::getOrdering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 767,
   FQN="llvm::AtomicRMWInst::getOrdering", NM="_ZNK4llvm13AtomicRMWInst11getOrderingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm13AtomicRMWInst11getOrderingEv")
  //</editor-fold>
  public AtomicOrdering getOrdering() /*const*/ {
    return AtomicOrdering.valueOf((getSubclassDataFromInstruction() >>> 2) & 7);
  }


  /// Returns whether this RMW is atomic between threads or only within a
  /// single thread.
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::getSynchScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 773,
   FQN="llvm::AtomicRMWInst::getSynchScope", NM="_ZNK4llvm13AtomicRMWInst13getSynchScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm13AtomicRMWInst13getSynchScopeEv")
  //</editor-fold>
  public SynchronizationScope getSynchScope() /*const*/ {
    return SynchronizationScope.valueOf((getSubclassDataFromInstruction() & 2) >>> 1);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::getPointerOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 777,
   FQN="llvm::AtomicRMWInst::getPointerOperand", NM="_ZN4llvm13AtomicRMWInst17getPointerOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm13AtomicRMWInst17getPointerOperandEv")
  //</editor-fold>
  public Value /*P*/ getPointerOperand() {
    return getOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::getPointerOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 778,
   FQN="llvm::AtomicRMWInst::getPointerOperand", NM="_ZNK4llvm13AtomicRMWInst17getPointerOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm13AtomicRMWInst17getPointerOperandEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getPointerOperand$Const() /*const*/ {
    return getOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::getPointerOperandIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 779,
   FQN="llvm::AtomicRMWInst::getPointerOperandIndex", NM="_ZN4llvm13AtomicRMWInst22getPointerOperandIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm13AtomicRMWInst22getPointerOperandIndexEv")
  //</editor-fold>
  public static /*uint*/int getPointerOperandIndex() {
    return 0/*U*/;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::getValOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 781,
   FQN="llvm::AtomicRMWInst::getValOperand", NM="_ZN4llvm13AtomicRMWInst13getValOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm13AtomicRMWInst13getValOperandEv")
  //</editor-fold>
  public Value /*P*/ getValOperand() {
    return getOperand(1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::getValOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 782,
   FQN="llvm::AtomicRMWInst::getValOperand", NM="_ZNK4llvm13AtomicRMWInst13getValOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm13AtomicRMWInst13getValOperandEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getValOperand$Const() /*const*/ {
    return getOperand(1);
  }


  /// \brief Returns the address space of the pointer operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::getPointerAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 785,
   FQN="llvm::AtomicRMWInst::getPointerAddressSpace", NM="_ZNK4llvm13AtomicRMWInst22getPointerAddressSpaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm13AtomicRMWInst22getPointerAddressSpaceEv")
  //</editor-fold>
  public /*uint*/int getPointerAddressSpace() /*const*/ {
    return getPointerOperand$Const().getType().getPointerAddressSpace();
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 790,
   FQN="llvm::AtomicRMWInst::classof", NM="_ZN4llvm13AtomicRMWInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm13AtomicRMWInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.MemoryOps.AtomicRMW;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 793,
   FQN="llvm::AtomicRMWInst::classof", NM="_ZN4llvm13AtomicRMWInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm13AtomicRMWInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && AtomicRMWInst.classof(cast_Instruction(V));
  }

/*private:*/

  //===----------------------------------------------------------------------===//
  //                       AtomicRMWInst Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::Init">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1573,
   FQN="llvm::AtomicRMWInst::Init", NM="_ZN4llvm13AtomicRMWInst4InitENS0_5BinOpEPNS_5ValueES3_NS_14AtomicOrderingENS_20SynchronizationScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm13AtomicRMWInst4InitENS0_5BinOpEPNS_5ValueES3_NS_14AtomicOrderingENS_20SynchronizationScopeE")
  //</editor-fold>
  private void Init(BinOp Operation, Value /*P*/ Ptr, Value /*P*/ Val,
      AtomicOrdering Ordering,
      SynchronizationScope SynchScope) {
    this.Op(0).$assign(Ptr);
    this.Op(1).$assign(Val);
    setOperation(Operation);
    setOrdering(Ordering);
    setSynchScope(SynchScope);
    assert ((getOperand(0) != null) && (getOperand(1) != null)) : "All operands must be non-null!";
    assert (getOperand(0).getType().isPointerTy()) : "Ptr must have pointer type!";
    assert (getOperand(1).getType() == cast_PointerType(getOperand(0).getType()).getElementType()) : "Ptr must be a pointer to Val type!";
    assert (Ordering != AtomicOrdering.NotAtomic) : "AtomicRMW instructions must be atomic!";
  }

  // Shadow Instruction::setInstructionSubclassData with a private forwarding
  // method so that subclasses cannot accidentally use it.
  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::setInstructionSubclassData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 802,
   FQN="llvm::AtomicRMWInst::setInstructionSubclassData", NM="_ZN4llvm13AtomicRMWInst26setInstructionSubclassDataEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm13AtomicRMWInst26setInstructionSubclassDataEt")
  //</editor-fold>
  private void setInstructionSubclassData_AtomicRMWInst(/*ushort*/char D) {
    super.setInstructionSubclassData(D);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AtomicRMWInst::~AtomicRMWInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 671,
   FQN="llvm::AtomicRMWInst::~AtomicRMWInst", NM="_ZN4llvm13AtomicRMWInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm13AtomicRMWInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
