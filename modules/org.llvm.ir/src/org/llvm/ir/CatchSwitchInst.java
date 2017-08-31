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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
//                         CatchSwitchInst Class
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3944,
 FQN="llvm::CatchSwitchInst", NM="_ZN4llvm15CatchSwitchInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInstE")
//</editor-fold>
public class CatchSwitchInst extends /*public*/ TerminatorInst implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3945,
   FQN="llvm::CatchSwitchInst::operator new", NM="_ZN4llvm15CatchSwitchInstnwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInstnwEjj")
  //</editor-fold>
  protected/*private*/ static Object/*void P*/ $new_CatchSwitchInst(/*size_t*/int $Prm0, /*uint*/int $Prm1) { throw new UnsupportedOperationException("Deleted");}

  /// ReservedSpace - The number of operands actually allocated.  NumOperands is
  /// the number actually in use.
  private /*uint*/int ReservedSpace;
  // Operand[0] = Outer scope
  // Operand[1] = Unwind block destination
  // Operand[n] = BasicBlock to go to on match
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::CatchSwitchInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1010,
   FQN="llvm::CatchSwitchInst::CatchSwitchInst", NM="_ZN4llvm15CatchSwitchInstC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInstC1ERKS0_")
  //</editor-fold>
  private CatchSwitchInst(final /*const*/ CatchSwitchInst /*&*/ CSI) {
    // : TerminatorInst(CSI.getType(), Instruction::CatchSwitch, null, CSI.getNumOperands())
    //START JInit
    super(CSI.getType(), Instruction.TermOps.CatchSwitch, (type$ptr<Use /*P*/> )null,
        CSI.getNumOperands());
    //END JInit
    init(CSI.getParentPad(), CSI.getUnwindDest(), CSI.getNumOperands());
    setNumHungOffUseOperands(ReservedSpace);
    type$ptr<Use /*P*/> OL = $tryClone(getOperandList());
    /*const*/type$ptr<Use /*P*/> InOL = $tryClone(CSI.getOperandList$Const());
    for (/*uint*/int I = 1, E = ReservedSpace; I != E; ++I)  {
      OL.$at(I).$assign(InOL.$at(I));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1021,
   FQN="llvm::CatchSwitchInst::init", NM="_ZN4llvm15CatchSwitchInst4initEPNS_5ValueEPNS_10BasicBlockEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInst4initEPNS_5ValueEPNS_10BasicBlockEj")
  //</editor-fold>
  private void init(Value /*P*/ ParentPad, BasicBlock /*P*/ UnwindDest,
      /*uint*/int NumReservedValues) {
    assert ((ParentPad != null) && (NumReservedValues != 0));

    ReservedSpace = NumReservedValues;
    setNumHungOffUseOperands((UnwindDest != null) ? 2 : 1);
    allocHungoffUses(ReservedSpace);

    this./*<0>*/Op(0).$assign(ParentPad);
    if ((UnwindDest != null)) {
      setInstructionSubclassData($uint2ushort(getSubclassDataFromInstruction() | 1));
      setUnwindDest(UnwindDest);
    }
  }


  /// growOperands - grow operands - This grows the operand list in response to a
  /// push_back style of operation. This grows the number of ops by 2 times.
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::growOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1038,
   FQN="llvm::CatchSwitchInst::growOperands", NM="_ZN4llvm15CatchSwitchInst12growOperandsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInst12growOperandsEj")
  //</editor-fold>
  private void growOperands(/*uint*/int Size) {
    /*uint*/int NumOperands = getNumOperands();
    assert ($greatereq_uint(NumOperands, 1));
    if ($greatereq_uint(ReservedSpace, NumOperands + Size)) {
      return;
    }
    ReservedSpace = (NumOperands + $div_uint(Size, 2)) * 2;
    growHungoffUses(ReservedSpace);
  }

  // allocate space for exactly zero operands
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::operator new">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3956,
   FQN="llvm::CatchSwitchInst::operator new", NM="_ZN4llvm15CatchSwitchInstnwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInstnwEj")
  //</editor-fold>
  private static CatchSwitchInst/*void P*/ $new_CatchSwitchInst(/*size_t*/int s, New$ConstructorCallback<CatchSwitchInst> $Ctor) {
    return User.$new_HangOffUses(/*s,*/ $Ctor);
  }

  /// CatchSwitchInst ctor - Create a new switch instruction, specifying a
  /// default destination.  The number of additional handlers can be specified
  /// here to make memory allocation more efficient.
  /// This constructor can also autoinsert before another instruction.

  //===----------------------------------------------------------------------===//
  //                       CatchSwitchInst Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::CatchSwitchInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 987,
   FQN="llvm::CatchSwitchInst::CatchSwitchInst", NM="_ZN4llvm15CatchSwitchInstC1EPNS_5ValueEPNS_10BasicBlockEjRKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInstC1EPNS_5ValueEPNS_10BasicBlockEjRKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  private CatchSwitchInst(Value /*P*/ ParentPad, BasicBlock /*P*/ UnwindDest,
      /*uint*/int NumReservedValues,
      final /*const*/ Twine /*&*/ NameStr,
      Instruction /*P*/ InsertBefore) {
    // : TerminatorInst(ParentPad->getType(), Instruction::CatchSwitch, null, 0, InsertBefore)
    //START JInit
    super(ParentPad.getType(), Instruction.TermOps.CatchSwitch, (type$ptr<Use /*P*/> )null, 0,
        InsertBefore);
    //END JInit
    if ((UnwindDest != null)) {
      ++NumReservedValues;
    }
    init(ParentPad, UnwindDest, NumReservedValues + 1);
    setName(NameStr);
  }


  /// CatchSwitchInst ctor - Create a new switch instruction, specifying a
  /// default destination.  The number of additional handlers can be specified
  /// here to make memory allocation more efficient.
  /// This constructor also autoinserts at the end of the specified BasicBlock.
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::CatchSwitchInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 999,
   FQN="llvm::CatchSwitchInst::CatchSwitchInst", NM="_ZN4llvm15CatchSwitchInstC1EPNS_5ValueEPNS_10BasicBlockEjRKNS_5TwineES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInstC1EPNS_5ValueEPNS_10BasicBlockEjRKNS_5TwineES4_")
  //</editor-fold>
  private CatchSwitchInst(Value /*P*/ ParentPad, BasicBlock /*P*/ UnwindDest,
      /*uint*/int NumReservedValues,
      final /*const*/ Twine /*&*/ NameStr, BasicBlock /*P*/ InsertAtEnd) {
    // : TerminatorInst(ParentPad->getType(), Instruction::CatchSwitch, null, 0, InsertAtEnd)
    //START JInit
    super(ParentPad.getType(), Instruction.TermOps.CatchSwitch, (type$ptr<Use /*P*/> )null, 0,
        InsertAtEnd);
    //END JInit
    if ((UnwindDest != null)) {
      ++NumReservedValues;
    }
    init(ParentPad, UnwindDest, NumReservedValues + 1);
    setName(NameStr);
  }

/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::cloneImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 4073,
   FQN="llvm::CatchSwitchInst::cloneImpl", NM="_ZNK4llvm15CatchSwitchInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchSwitchInst9cloneImplEv")
  //</editor-fold>
  protected CatchSwitchInst /*P*/ cloneImpl() /*const*/ {
    return /*NEW_EXPR [CatchSwitchInst::new]*/CatchSwitchInst.$new_CatchSwitchInst(0, (type$ptr<?> New$Mem)->{
        return new CatchSwitchInst(/*Deref*/this);
     });
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3979,
   FQN="llvm::CatchSwitchInst::Create", NM="_ZN4llvm15CatchSwitchInst6CreateEPNS_5ValueEPNS_10BasicBlockEjRKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInst6CreateEPNS_5ValueEPNS_10BasicBlockEjRKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static CatchSwitchInst /*P*/ Create(Value /*P*/ ParentPad, BasicBlock /*P*/ UnwindDest,
        /*uint*/int NumHandlers) {
    return Create(ParentPad, UnwindDest,
        NumHandlers,
        new Twine(/*KEEP_STR*/$EMPTY),
        (Instruction /*P*/ )null);
  }
  public static CatchSwitchInst /*P*/ Create(Value /*P*/ ParentPad, BasicBlock /*P*/ UnwindDest,
        /*uint*/int NumHandlers,
        final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    return Create(ParentPad, UnwindDest,
        NumHandlers,
        NameStr,
        (Instruction /*P*/ )null);
  }
  public static CatchSwitchInst /*P*/ Create(Value /*P*/ ParentPad, BasicBlock /*P*/ UnwindDest,
        /*uint*/int NumHandlers,
        final /*const*/ Twine /*&*/ NameStr/*= ""*/,
        Instruction /*P*/ InsertBefore/*= null*/) {
    return /*NEW_EXPR [CatchSwitchInst::new]*/CatchSwitchInst.$new_CatchSwitchInst(0, (type$ptr<?> New$Mem)->{
        return new CatchSwitchInst(ParentPad, UnwindDest, NumHandlers, NameStr,
                InsertBefore);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3986,
   FQN="llvm::CatchSwitchInst::Create", NM="_ZN4llvm15CatchSwitchInst6CreateEPNS_5ValueEPNS_10BasicBlockEjRKNS_5TwineES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInst6CreateEPNS_5ValueEPNS_10BasicBlockEjRKNS_5TwineES4_")
  //</editor-fold>
  public static CatchSwitchInst /*P*/ Create(Value /*P*/ ParentPad, BasicBlock /*P*/ UnwindDest,
        /*uint*/int NumHandlers, final /*const*/ Twine /*&*/ NameStr,
        BasicBlock /*P*/ InsertAtEnd) {
    return /*NEW_EXPR [CatchSwitchInst::new]*/CatchSwitchInst.$new_CatchSwitchInst(0, (type$ptr<?> New$Mem)->{
        return new CatchSwitchInst(ParentPad, UnwindDest, NumHandlers, NameStr,
                InsertAtEnd);
     });
  }


  /// Provide fast operand accessors
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4113,
   FQN="llvm::CatchSwitchInst::getOperand", NM="_ZNK4llvm15CatchSwitchInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchSwitchInst10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsCatchSwitchInst.<CatchSwitchInst>operands(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsCatchSwitchInst.<CatchSwitchInst>op_begin(((/*const_cast*/CatchSwitchInst /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4113,
   FQN="llvm::CatchSwitchInst::setOperand", NM="_ZN4llvm15CatchSwitchInst10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInst10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsCatchSwitchInst.<CatchSwitchInst>operands(this))) : "setOperand() out of range!";
    OperandTraitsCatchSwitchInst.<CatchSwitchInst>op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4113,
   FQN="llvm::CatchSwitchInst::op_begin", NM="_ZN4llvm15CatchSwitchInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInst8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsCatchSwitchInst.<CatchSwitchInst>op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4113,
   FQN="llvm::CatchSwitchInst::op_begin", NM="_ZNK4llvm15CatchSwitchInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchSwitchInst8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsCatchSwitchInst.<CatchSwitchInst>op_begin(((/*const_cast*/CatchSwitchInst /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4113,
   FQN="llvm::CatchSwitchInst::op_end", NM="_ZN4llvm15CatchSwitchInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInst6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsCatchSwitchInst.<CatchSwitchInst>op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4113,
   FQN="llvm::CatchSwitchInst::op_end", NM="_ZNK4llvm15CatchSwitchInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchSwitchInst6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsCatchSwitchInst.<CatchSwitchInst>op_end(((/*const_cast*/CatchSwitchInst /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4113,
   FQN="llvm::CatchSwitchInst::Op", NM="Tpl__ZN4llvm15CatchSwitchInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm15CatchSwitchInst2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this.OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4113,
   FQN="llvm::CatchSwitchInst::Op", NM="Tpl__ZNK4llvm15CatchSwitchInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm15CatchSwitchInst2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this.OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4113,
   FQN="llvm::CatchSwitchInst::getNumOperands", NM="_ZNK4llvm15CatchSwitchInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchSwitchInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsCatchSwitchInst.<CatchSwitchInst>operands(this);
  }


  // Accessor Methods for CatchSwitch stmt
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::getParentPad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3997,
   FQN="llvm::CatchSwitchInst::getParentPad", NM="_ZNK4llvm15CatchSwitchInst12getParentPadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchSwitchInst12getParentPadEv")
  //</editor-fold>
  public Value /*P*/ getParentPad() /*const*/ {
    return getOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::setParentPad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3998,
   FQN="llvm::CatchSwitchInst::setParentPad", NM="_ZN4llvm15CatchSwitchInst12setParentPadEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInst12setParentPadEPNS_5ValueE")
  //</editor-fold>
  public void setParentPad(Value /*P*/ ParentPad) {
    setOperand(0, ParentPad);
  }


  // Accessor Methods for CatchSwitch stmt
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::hasUnwindDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4001,
   FQN="llvm::CatchSwitchInst::hasUnwindDest", NM="_ZNK4llvm15CatchSwitchInst13hasUnwindDestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchSwitchInst13hasUnwindDestEv")
  //</editor-fold>
  public boolean hasUnwindDest() /*const*/ {
    return ((getSubclassDataFromInstruction() & 1) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::unwindsToCaller">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4002,
   FQN="llvm::CatchSwitchInst::unwindsToCaller", NM="_ZNK4llvm15CatchSwitchInst15unwindsToCallerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchSwitchInst15unwindsToCallerEv")
  //</editor-fold>
  public boolean unwindsToCaller() /*const*/ {
    return !hasUnwindDest();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::getUnwindDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4003,
   FQN="llvm::CatchSwitchInst::getUnwindDest", NM="_ZNK4llvm15CatchSwitchInst13getUnwindDestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchSwitchInst13getUnwindDestEv")
  //</editor-fold>
  public BasicBlock /*P*/ getUnwindDest() /*const*/ {
    if (hasUnwindDest()) {
      return cast_BasicBlock(getOperand(1));
    }
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::setUnwindDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4008,
   FQN="llvm::CatchSwitchInst::setUnwindDest", NM="_ZN4llvm15CatchSwitchInst13setUnwindDestEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInst13setUnwindDestEPNS_10BasicBlockE")
  //</editor-fold>
  public void setUnwindDest(BasicBlock /*P*/ UnwindDest) {
    assert Native.$bool(UnwindDest);
    assert (hasUnwindDest());
    setOperand(1, UnwindDest);
  }


  /// getNumHandlers - return the number of 'handlers' in this catchswitch
  /// instruction, except the default handler
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::getNumHandlers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4016,
   FQN="llvm::CatchSwitchInst::getNumHandlers", NM="_ZNK4llvm15CatchSwitchInst14getNumHandlersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchSwitchInst14getNumHandlersEv")
  //</editor-fold>
  public /*uint*/int getNumHandlers() /*const*/ {
    if (hasUnwindDest()) {
      return getNumOperands() - 2;
    }
    return getNumOperands() - 1;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::handler_helper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4023,
   FQN="llvm::CatchSwitchInst::handler_helper", NM="_ZN4llvm15CatchSwitchInst14handler_helperEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInst14handler_helperEPNS_5ValueE")
  //</editor-fold>
  private static BasicBlock /*P*/ handler_helper_Value$P(Value /*P*/ V) {
    return cast_BasicBlock(V);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::handler_helper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4024,
   FQN="llvm::CatchSwitchInst::handler_helper", NM="_ZN4llvm15CatchSwitchInst14handler_helperEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInst14handler_helperEPKNS_5ValueE")
  //</editor-fold>
  private static /*const*/ BasicBlock /*P*/ handler_helper_Value$C$P(/*const*/ Value /*P*/ V) {
    return cast_BasicBlock(V);
  }

/*public:*/
  // JAVA: typedef std::pointer_to_unary_function<Value *, BasicBlock *> DerefFnTy
//  public final class DerefFnTy extends Value2BasicBlock{ };
  // JAVA: typedef mapped_iterator<op_iterator, DerefFnTy> handler_iterator
//  public final class handler_iterator extends mapped_iterator<type$ptr<Use /*P*/> , Value2BasicBlock>{ };
  // JAVA: typedef iterator_range<handler_iterator> handler_range
//  public final class handler_range extends iterator_range<BasicBlock>{ };

  // JAVA: typedef std::pointer_to_unary_function<const Value *, const BasicBlock *> ConstDerefFnTy
//  public final class ConstDerefFnTy extends Value2BasicBlock{ };
  // JAVA: typedef mapped_iterator<const_op_iterator, ConstDerefFnTy> const_handler_iterator
//  public final class const_handler_iterator extends mapped_iterator</*const*/type$ptr<Use /*P*/> , Value2BasicBlock>{ };
  // JAVA: typedef iterator_range<const_handler_iterator> const_handler_range
//  public final class const_handler_range extends iterator_range</*const*/ BasicBlock>{ };

  /// Returns an iterator that points to the first handler in CatchSwitchInst.
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::handler_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4040,
   FQN="llvm::CatchSwitchInst::handler_begin", NM="_ZN4llvm15CatchSwitchInst13handler_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInst13handler_beginEv")
  //</editor-fold>
  public mapped_iterator<Use /*P*/ , BasicBlock> handler_begin() {
    type$ptr<Use /*P*/> It = $tryClone(op_begin().$add(1));
    if (hasUnwindDest()) {
      It.$preInc();
    }
    return new mapped_iterator<Use /*P*/, BasicBlock>(It, /*FuncRef*/CatchSwitchInst::handler_helper_Value$Use$P);
  }

  /// Returns an iterator that points to the first handler in the
  /// CatchSwitchInst.
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::handler_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4048,
   FQN="llvm::CatchSwitchInst::handler_begin", NM="_ZNK4llvm15CatchSwitchInst13handler_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchSwitchInst13handler_beginEv")
  //</editor-fold>
  public mapped_iterator<Use /*P*/, BasicBlock> handler_begin$Const() /*const*/ {
    /*const*/type$ptr<Use /*P*/> It = $tryClone(op_begin$Const().$add(1));
    if (hasUnwindDest()) {
      It.$preInc();
    }
    return new mapped_iterator<Use /*P*/, BasicBlock>(It, CatchSwitchInst::handler_helper_Value$Use$P);
  }


  /// Returns a read-only iterator that points one past the last
  /// handler in the CatchSwitchInst.
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::handler_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4057,
   FQN="llvm::CatchSwitchInst::handler_end", NM="_ZN4llvm15CatchSwitchInst11handler_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInst11handler_endEv")
  //</editor-fold>
  public mapped_iterator<Use /*P*/ , BasicBlock> handler_end() {
    return new mapped_iterator<Use /*P*/ , BasicBlock>(op_end(), CatchSwitchInst::handler_helper_Value$Use$P);
  }

  /// Returns an iterator that points one past the last handler in the
  /// CatchSwitchInst.
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::handler_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4062,
   FQN="llvm::CatchSwitchInst::handler_end", NM="_ZNK4llvm15CatchSwitchInst11handler_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchSwitchInst11handler_endEv")
  //</editor-fold>
  public mapped_iterator</*const*/ Use /*P*/, BasicBlock> handler_end$Const() /*const*/ {
    return new mapped_iterator</*const*/Use /*P*/, BasicBlock>(op_end$Const(), CatchSwitchInst::handler_helper_Value$Use$P);
  }


  /// handlers - iteration adapter for range-for loops.
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::handlers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4067,
   FQN="llvm::CatchSwitchInst::handlers", NM="_ZN4llvm15CatchSwitchInst8handlersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInst8handlersEv")
  //</editor-fold>
  public iterator_range<BasicBlock> handlers() {
    return make_range(handler_begin(), handler_end());
  }


  /// handlers - iteration adapter for range-for loops.
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::handlers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4072,
   FQN="llvm::CatchSwitchInst::handlers", NM="_ZNK4llvm15CatchSwitchInst8handlersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchSwitchInst8handlersEv")
  //</editor-fold>
  public iterator_range</*const*/ BasicBlock> handlers$Const() /*const*/ {
    return make_range(handler_begin$Const(), handler_end$Const());
  }


  /// addHandler - Add an entry to the switch instruction...
  /// Note:
  /// This action invalidates handler_end(). Old handler_end() iterator will
  /// point to the added handler.
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::addHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1047,
   FQN="llvm::CatchSwitchInst::addHandler", NM="_ZN4llvm15CatchSwitchInst10addHandlerEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInst10addHandlerEPNS_10BasicBlockE")
  //</editor-fold>
  public void addHandler(BasicBlock /*P*/ Handler) {
    /*uint*/int OpNo = getNumOperands();
    growOperands(1);
    assert ($less_uint(OpNo, ReservedSpace)) : "Growing didn't work!";
    setNumHungOffUseOperands(getNumOperands() + 1);
    getOperandList().$at(OpNo).$assign(Handler);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::removeHandler">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1055,
   FQN="llvm::CatchSwitchInst::removeHandler", NM="_ZN4llvm15CatchSwitchInst13removeHandlerENS_15mapped_iteratorIPNS_3UseESt25pointer_to_unary_functionIPNS_5ValueEPNS_10BasicBlockEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInst13removeHandlerENS_15mapped_iteratorIPNS_3UseESt25pointer_to_unary_functionIPNS_5ValueEPNS_10BasicBlockEEEE")
  //</editor-fold>
  public void removeHandler(mapped_iterator<Use /*P*/, BasicBlock> HI) {
    // Move all subsequent handlers up one.
    type$ptr<Use /*P*/> EndDst = $tryClone(op_end().$sub(1));
    for (type$iterator<?, Use /*P*/> CurDst = $tryClone(HI.getCurrent()); $noteq_ptr(CurDst, EndDst); CurDst.$preInc())  {
      CurDst.$star().$assign(((type$iterator<?, Use /*P*/>)CurDst.$add(1)).$star());
    }
    // Null out the last handler use.
    EndDst.$star().$assign((Value /*P*/ )null);

    setNumHungOffUseOperands(getNumOperands() - 1);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::getNumSuccessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4084,
   FQN="llvm::CatchSwitchInst::getNumSuccessors", NM="_ZNK4llvm15CatchSwitchInst16getNumSuccessorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchSwitchInst16getNumSuccessorsEv")
  //</editor-fold>
  public /*uint*/int getNumSuccessors() /*const*/ {
    return getNumOperands() - 1;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::getSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4085,
   FQN="llvm::CatchSwitchInst::getSuccessor", NM="_ZNK4llvm15CatchSwitchInst12getSuccessorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchSwitchInst12getSuccessorEj")
  //</editor-fold>
  public BasicBlock /*P*/ getSuccessor(/*uint*/int Idx) /*const*/ {
    assert ($less_uint(Idx, getNumSuccessors())) : "Successor # out of range for catchswitch!";
    return cast_BasicBlock(getOperand(Idx + 1));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::setSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4090,
   FQN="llvm::CatchSwitchInst::setSuccessor", NM="_ZN4llvm15CatchSwitchInst12setSuccessorEjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInst12setSuccessorEjPNS_10BasicBlockE")
  //</editor-fold>
  public void setSuccessor(/*uint*/int Idx, BasicBlock /*P*/ NewSucc) {
    assert ($less_uint(Idx, getNumSuccessors())) : "Successor # out of range for catchswitch!";
    setOperand(Idx + 1, NewSucc);
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4097,
   FQN="llvm::CatchSwitchInst::classof", NM="_ZN4llvm15CatchSwitchInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.TermOps.CatchSwitch;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4100,
   FQN="llvm::CatchSwitchInst::classof", NM="_ZN4llvm15CatchSwitchInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && CatchSwitchInst.classof(cast_Instruction(V));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::getSuccessorV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1066,
   FQN="llvm::CatchSwitchInst::getSuccessorV", NM="_ZNK4llvm15CatchSwitchInst13getSuccessorVEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchSwitchInst13getSuccessorVEj")
  //</editor-fold>
  @Override protected/*private*/ BasicBlock /*P*/ getSuccessorV(/*uint*/int idx) /*const*//* override*/ {
    return getSuccessor(idx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::getNumSuccessorsV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1069,
   FQN="llvm::CatchSwitchInst::getNumSuccessorsV", NM="_ZNK4llvm15CatchSwitchInst17getNumSuccessorsVEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15CatchSwitchInst17getNumSuccessorsVEv")
  //</editor-fold>
  @Override protected/*private*/ /*uint*/int getNumSuccessorsV() /*const*//* override*/ {
    return getNumSuccessors();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::setSuccessorV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1072,
   FQN="llvm::CatchSwitchInst::setSuccessorV", NM="_ZN4llvm15CatchSwitchInst13setSuccessorVEjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInst13setSuccessorVEjPNS_10BasicBlockE")
  //</editor-fold>
  @Override protected/*private*/ void setSuccessorV(/*uint*/int idx, BasicBlock /*P*/ B)/* override*/ {
    setSuccessor(idx, B);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchSwitchInst::~CatchSwitchInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3944,
   FQN="llvm::CatchSwitchInst::~CatchSwitchInst", NM="_ZN4llvm15CatchSwitchInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15CatchSwitchInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static BasicBlock /*P*/ handler_helper_Value$Use$P(Use /*P*/ U) {
    return cast_BasicBlock(U.$Value$P());
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "ReservedSpace=" + ReservedSpace // NOI18N
              + super.toString(); // NOI18N
  }
}
