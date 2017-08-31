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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;


//===----------------------------------------------------------------------===//
//                           FuncletPadInst Class
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1121,
 FQN="llvm::FuncletPadInst", NM="_ZN4llvm14FuncletPadInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FuncletPadInstE")
//</editor-fold>
public class FuncletPadInst extends /*public*/ Instruction implements Destructors.ClassWithDestructor {
/*private:*/

  //===----------------------------------------------------------------------===//
  //                        FuncletPadInst Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::init">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1079,
   FQN="llvm::FuncletPadInst::init", NM="_ZN4llvm14FuncletPadInst4initEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FuncletPadInst4initEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineE")
  //</editor-fold>
  private void init(Value /*P*/ ParentPad, ArrayRef<Value /*P*/ > Args,
      final /*const*/ Twine /*&*/ NameStr) {
    assert (getNumOperands() == 1 + Args.size()) : "NumOperands not set up?";
    std.copy(Args.begin(), Args.end(), op_begin(), (source, dest)->dest.$star().$assign(source.$star()));
    setParentPad(ParentPad);
    setName(NameStr);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::FuncletPadInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1087,
   FQN="llvm::FuncletPadInst::FuncletPadInst", NM="_ZN4llvm14FuncletPadInstC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FuncletPadInstC1ERKS0_")
  //</editor-fold>
  /*friend*/protected/*private*/ FuncletPadInst(final /*const*/ FuncletPadInst /*&*/ FPI) {
    // : Instruction(FPI.getType(), FPI.getOpcode(), OperandTraits<FuncletPadInst>::op_end(this) - FPI.getNumOperands(), FPI.getNumOperands())
    super(FPI.getType(), FPI.getOpcode(),
        OperandTraitsFuncletPadInst.<FuncletPadInst>op_end(1, null/*this*/).$sub(FPI.getNumOperands()),
        FPI.getNumOperands());
    //END JInit
    std.copy(FPI.op_begin$Const(), FPI.op_end$Const(), op_begin());
    setParentPad(FPI.getParentPad());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::FuncletPadInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1096,
   FQN="llvm::FuncletPadInst::FuncletPadInst", NM="_ZN4llvm14FuncletPadInstC1ENS_11Instruction13FuncletPadOpsEPNS_5ValueENS_8ArrayRefIS4_EEjRKNS_5TwineEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FuncletPadInstC1ENS_11Instruction13FuncletPadOpsEPNS_5ValueENS_8ArrayRefIS4_EEjRKNS_5TwineEPS1_")
  //</editor-fold>
  /*friend*/protected/*private*/ FuncletPadInst(JD$FuncletPadOps_Value$P_ArrayRef$Value$P_UInt_Twine$C_Instruction$P _dparam, /*FuncletPadOps*/int Op, Value /*P*/ ParentPad,
      ArrayRef<Value /*P*/ > Args, /*uint*/int Values,
      final /*const*/ Twine /*&*/ NameStr, Instruction /*P*/ InsertBefore) {
    // : Instruction(ParentPad->getType(), Op, OperandTraits<FuncletPadInst>::op_end(this) - Values, Values, InsertBefore)
    //START JInit
    super(ParentPad.getType(), Op,
        OperandTraitsFuncletPadInst.<FuncletPadInst>op_end(1, null/*this*/).$sub(Values), Values,
        InsertBefore);
    //END JInit
    init(ParentPad, new ArrayRef<Value /*P*/ >(Args), NameStr);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::FuncletPadInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1105,
   FQN="llvm::FuncletPadInst::FuncletPadInst", NM="_ZN4llvm14FuncletPadInstC1ENS_11Instruction13FuncletPadOpsEPNS_5ValueENS_8ArrayRefIS4_EEjRKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FuncletPadInstC1ENS_11Instruction13FuncletPadOpsEPNS_5ValueENS_8ArrayRefIS4_EEjRKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  /*friend*/protected/*private*/ FuncletPadInst(JD$FuncletPadOps_Value$P_ArrayRef$Value$P_UInt_Twine$C_BasicBlock$P _dparam, /*FuncletPadOps*/int Op, Value /*P*/ ParentPad,
      ArrayRef<Value /*P*/ > Args, /*uint*/int Values,
      final /*const*/ Twine /*&*/ NameStr, BasicBlock /*P*/ InsertAtEnd) {
    // : Instruction(ParentPad->getType(), Op, OperandTraits<FuncletPadInst>::op_end(this) - Values, Values, InsertAtEnd)
    //START JInit
    super(ParentPad.getType(), Op,
        OperandTraitsFuncletPadInst.<FuncletPadInst>op_end(1, null/*this*/).$sub(Values), Values,
        InsertAtEnd);
    //END JInit
    init(ParentPad, new ArrayRef<Value /*P*/ >(Args), NameStr);
  }

/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  /*friend  class CatchPadInst*/
  /*friend  class CleanupPadInst*/
  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::cloneImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 4077,
   FQN="llvm::FuncletPadInst::cloneImpl", NM="_ZNK4llvm14FuncletPadInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14FuncletPadInst9cloneImplEv")
  //</editor-fold>
  protected FuncletPadInst /*P*/ cloneImpl() /*const*/ {
    return ((/*JCast*/FuncletPadInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (getNumOperands())*/ User.$new_FixedUses(getNumOperands(), (type$ptr<?> New$Mem)->{
        return new FuncletPadInst(/*Deref*/this);
     })));
  }

/*public:*/
/// Provide fast operand accessors
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1185,
   FQN="llvm::FuncletPadInst::getOperand", NM="_ZNK4llvm14FuncletPadInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14FuncletPadInst10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsFuncletPadInst.operands(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsFuncletPadInst.op_begin(((/*const_cast*/FuncletPadInst /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1185,
   FQN="llvm::FuncletPadInst::setOperand", NM="_ZN4llvm14FuncletPadInst10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FuncletPadInst10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsFuncletPadInst.operands(this))) : "setOperand() out of range!";
    OperandTraitsFuncletPadInst.op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1185,
   FQN="llvm::FuncletPadInst::op_begin", NM="_ZN4llvm14FuncletPadInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FuncletPadInst8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsFuncletPadInst.op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1185,
   FQN="llvm::FuncletPadInst::op_begin", NM="_ZNK4llvm14FuncletPadInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14FuncletPadInst8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsFuncletPadInst.op_begin(((/*const_cast*/FuncletPadInst /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1185,
   FQN="llvm::FuncletPadInst::op_end", NM="_ZN4llvm14FuncletPadInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FuncletPadInst6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsFuncletPadInst.op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1185,
   FQN="llvm::FuncletPadInst::op_end", NM="_ZNK4llvm14FuncletPadInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14FuncletPadInst6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsFuncletPadInst.op_end(((/*const_cast*/FuncletPadInst /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1185,
   FQN="llvm::FuncletPadInst::Op", NM="Tpl__ZN4llvm14FuncletPadInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm14FuncletPadInst2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1185,
   FQN="llvm::FuncletPadInst::Op", NM="Tpl__ZNK4llvm14FuncletPadInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm14FuncletPadInst2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1185,
   FQN="llvm::FuncletPadInst::getNumOperands", NM="_ZNK4llvm14FuncletPadInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14FuncletPadInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsFuncletPadInst.operands(this);
  }


  /// getNumArgOperands - Return the number of funcletpad arguments.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::getNumArgOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1147,
   FQN="llvm::FuncletPadInst::getNumArgOperands", NM="_ZNK4llvm14FuncletPadInst17getNumArgOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14FuncletPadInst17getNumArgOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumArgOperands() /*const*/ {
    return getNumOperands() - 1;
  }


  /// Convenience accessors

  /// \brief Return the outer EH-pad this funclet is nested within.
  ///
  /// Note: This returns the associated CatchSwitchInst if this FuncletPadInst
  /// is a CatchPadInst.
  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::getParentPad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1155,
   FQN="llvm::FuncletPadInst::getParentPad", NM="_ZNK4llvm14FuncletPadInst12getParentPadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14FuncletPadInst12getParentPadEv")
  //</editor-fold>
  public Value /*P*/ getParentPad() /*const*/ {
    return this./*<-1>*/Op$Const(-1).$Value$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::setParentPad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1156,
   FQN="llvm::FuncletPadInst::setParentPad", NM="_ZN4llvm14FuncletPadInst12setParentPadEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FuncletPadInst12setParentPadEPNS_5ValueE")
  //</editor-fold>
  public void setParentPad(Value /*P*/ ParentPad) {
    assert Native.$bool(ParentPad);
    this./*<-1>*/Op(-1).$assign(ParentPad);
  }


  /// getArgOperand/setArgOperand - Return/set the i-th funcletpad argument.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::getArgOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1163,
   FQN="llvm::FuncletPadInst::getArgOperand", NM="_ZNK4llvm14FuncletPadInst13getArgOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14FuncletPadInst13getArgOperandEj")
  //</editor-fold>
  public Value /*P*/ getArgOperand(/*uint*/int i) /*const*/ {
    return getOperand(i);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::setArgOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1164,
   FQN="llvm::FuncletPadInst::setArgOperand", NM="_ZN4llvm14FuncletPadInst13setArgOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FuncletPadInst13setArgOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setArgOperand(/*uint*/int i, Value /*P*/ v) {
    setOperand(i, v);
  }


  /// arg_operands - iteration adapter for range-for loops.
  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::arg_operands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1167,
   FQN="llvm::FuncletPadInst::arg_operands", NM="_ZN4llvm14FuncletPadInst12arg_operandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FuncletPadInst12arg_operandsEv")
  //</editor-fold>
  public iterator_range<Use> arg_operands() {
    return new iterator_range<Use>(op_begin(), op_end().$sub(1));
  }


  /// arg_operands - iteration adapter for range-for loops.
  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::arg_operands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1170,
   FQN="llvm::FuncletPadInst::arg_operands", NM="_ZNK4llvm14FuncletPadInst12arg_operandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14FuncletPadInst12arg_operandsEv")
  //</editor-fold>
  public iterator_range</*const*/ Use> arg_operands$Const() /*const*/ {
    return new iterator_range</*const*/ Use>(op_begin$Const(), op_end$Const().$sub(1));
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1175,
   FQN="llvm::FuncletPadInst::classof", NM="_ZN4llvm14FuncletPadInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FuncletPadInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.isFuncletPad();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1176,
   FQN="llvm::FuncletPadInst::classof", NM="_ZN4llvm14FuncletPadInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FuncletPadInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && FuncletPadInst.classof(cast_Instruction(V));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FuncletPadInst::~FuncletPadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1121,
   FQN="llvm::FuncletPadInst::~FuncletPadInst", NM="_ZN4llvm14FuncletPadInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FuncletPadInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
