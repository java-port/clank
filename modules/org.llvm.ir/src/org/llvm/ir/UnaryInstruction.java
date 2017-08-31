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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
//                          UnaryInstruction Class
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="llvm::UnaryInstruction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 278,
 FQN="llvm::UnaryInstruction", NM="_ZN4llvm16UnaryInstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16UnaryInstructionE")
//</editor-fold>
public class UnaryInstruction extends /*public*/ Instruction implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::UnaryInstruction::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 279,
   FQN="llvm::UnaryInstruction::operator new", NM="_ZN4llvm16UnaryInstructionnwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16UnaryInstructionnwEjj")
  //</editor-fold>
  protected/*private*/ static Object/*void P*/ $new(/*size_t*/int $Prm0, /*uint*/int $Prm1) { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::UnaryInstruction::UnaryInstruction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 282,
   FQN="llvm::UnaryInstruction::UnaryInstruction", NM="_ZN4llvm16UnaryInstructionC1EPNS_4TypeEjPNS_5ValueEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16UnaryInstructionC1EPNS_4TypeEjPNS_5ValueEPNS_11InstructionE")
  //</editor-fold>
  protected UnaryInstruction(Type /*P*/ Ty, /*uint*/int iType, Value /*P*/ V) {
    this(Ty, iType, V,
      (Instruction /*P*/ )null);
  }
  protected UnaryInstruction(Type /*P*/ Ty, /*uint*/int iType, Value /*P*/ V,
      Instruction /*P*/ IB/*= null*/) {
    // : Instruction(Ty, iType, &Op<0>(), 1, IB)
    //START JInit
    super(Ty, iType, $AddrOf(OpFrom$Addr(0, User.$BEING_CREATED(), UnaryInstruction.class)), 1, IB);
    //END JInit
    this./*<0>*/Op(0).$assign(V);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::UnaryInstruction::UnaryInstruction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 287,
   FQN="llvm::UnaryInstruction::UnaryInstruction", NM="_ZN4llvm16UnaryInstructionC1EPNS_4TypeEjPNS_5ValueEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16UnaryInstructionC1EPNS_4TypeEjPNS_5ValueEPNS_10BasicBlockE")
  //</editor-fold>
  protected UnaryInstruction(Type /*P*/ Ty, /*uint*/int iType, Value /*P*/ V, BasicBlock /*P*/ IAE) {
    // : Instruction(Ty, iType, &Op<0>(), 1, IAE)
    //START JInit
    super(Ty, iType, $AddrOf(OpFrom$Addr(0, User.$BEING_CREATED(), UnaryInstruction.class)), 1, IAE);
    //END JInit
    this./*<0>*/Op(0).$assign(V);
  }

/*public:*/
  // allocate space for exactly one operand
  //<editor-fold defaultstate="collapsed" desc="llvm::UnaryInstruction::operator new">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 294,
   FQN="llvm::UnaryInstruction::operator new", NM="_ZN4llvm16UnaryInstructionnwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16UnaryInstructionnwEj")
  //</editor-fold>
  public static <T extends UnaryInstruction> T/*void P*/ $new_UnaryInstruction(New$ConstructorCallback<T> $Ctor) {
    return User.$new_FixedUses(/*s, */1, $Ctor);
  }


  // Out of line virtual method, so the vtable, etc has a home.

  //===----------------------------------------------------------------------===//
  //                           UnaryInstruction Class
  //===----------------------------------------------------------------------===//

  // Out of line virtual method, so the vtable, etc has a home.
  //<editor-fold defaultstate="collapsed" desc="llvm::UnaryInstruction::~UnaryInstruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 53,
   FQN="llvm::UnaryInstruction::~UnaryInstruction", NM="_ZN4llvm16UnaryInstructionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16UnaryInstructionD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
  }


  /// Transparently provide more efficient getOperand methods.
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::UnaryInstruction::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 322,
   FQN="llvm::UnaryInstruction::getOperand", NM="_ZNK4llvm16UnaryInstruction10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm16UnaryInstruction10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsUnaryInstruction.<UnaryInstruction>operands$FixedNumOperandTraits(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsUnaryInstruction.<UnaryInstruction>op_begin(((/*const_cast*/UnaryInstruction /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::UnaryInstruction::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 322,
   FQN="llvm::UnaryInstruction::setOperand", NM="_ZN4llvm16UnaryInstruction10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16UnaryInstruction10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsUnaryInstruction.<UnaryInstruction>operands$FixedNumOperandTraits(this))) : "setOperand() out of range!";
    OperandTraitsUnaryInstruction.<UnaryInstruction>op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::UnaryInstruction::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 322,
   FQN="llvm::UnaryInstruction::op_begin", NM="_ZN4llvm16UnaryInstruction8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16UnaryInstruction8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsUnaryInstruction.<UnaryInstruction>op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::UnaryInstruction::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 322,
   FQN="llvm::UnaryInstruction::op_begin", NM="_ZNK4llvm16UnaryInstruction8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm16UnaryInstruction8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsUnaryInstruction.<UnaryInstruction>op_begin(((/*const_cast*/UnaryInstruction /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::UnaryInstruction::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 322,
   FQN="llvm::UnaryInstruction::op_end", NM="_ZN4llvm16UnaryInstruction6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16UnaryInstruction6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsUnaryInstruction.<UnaryInstruction>op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::UnaryInstruction::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 322,
   FQN="llvm::UnaryInstruction::op_end", NM="_ZNK4llvm16UnaryInstruction6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm16UnaryInstruction6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsUnaryInstruction.<UnaryInstruction>op_end(((/*const_cast*/UnaryInstruction /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::UnaryInstruction::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 322,
   FQN="llvm::UnaryInstruction::Op", NM="Tpl__ZN4llvm16UnaryInstruction2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm16UnaryInstruction2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this.OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::UnaryInstruction::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 322,
   FQN="llvm::UnaryInstruction::Op", NM="Tpl__ZNK4llvm16UnaryInstruction2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm16UnaryInstruction2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this.OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::UnaryInstruction::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 322,
   FQN="llvm::UnaryInstruction::getNumOperands", NM="_ZNK4llvm16UnaryInstruction14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm16UnaryInstruction14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsUnaryInstruction.<UnaryInstruction>operands$FixedNumOperandTraits(this);
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::UnaryInstruction::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 305,
   FQN="llvm::UnaryInstruction::classof", NM="_ZN4llvm16UnaryInstruction7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16UnaryInstruction7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.MemoryOps.Alloca
       || I.getOpcode() == Instruction.MemoryOps.Load
       || I.getOpcode() == Instruction.OtherOps.VAArg
       || I.getOpcode() == Instruction.OtherOps.ExtractValue
       || ($greatereq_uint(I.getOpcode(), CastOps.CastOpsBegin) && $less_uint(I.getOpcode(), CastOps.CastOpsEnd));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::UnaryInstruction::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 312,
   FQN="llvm::UnaryInstruction::classof", NM="_ZN4llvm16UnaryInstruction7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16UnaryInstruction7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && UnaryInstruction.classof(cast_Instruction(V));
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
