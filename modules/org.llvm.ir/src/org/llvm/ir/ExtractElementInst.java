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
//                                ExtractElementInst Class
//===----------------------------------------------------------------------===//

/// ExtractElementInst - This instruction extracts a single (scalar)
/// element from a VectorType value
///
//<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2026,
 FQN="llvm::ExtractElementInst", NM="_ZN4llvm18ExtractElementInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm18ExtractElementInstE")
//</editor-fold>
public class ExtractElementInst extends /*public*/ Instruction implements Destructors.ClassWithDestructor {

  //===----------------------------------------------------------------------===//
  //                           ExtractElementInst Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::ExtractElementInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1748,
   FQN="llvm::ExtractElementInst::ExtractElementInst", NM="_ZN4llvm18ExtractElementInstC1EPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm18ExtractElementInstC1EPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  private ExtractElementInst(Value /*P*/ Val, Value /*P*/ Index) {
    this(Val, Index,
      new Twine(/*KEEP_STR*/$EMPTY),
      (Instruction /*P*/ )null);
  }
  private ExtractElementInst(Value /*P*/ Val, Value /*P*/ Index,
      final /*const*/ Twine /*&*/ Name/*= ""*/) {
    this(Val, Index,
      Name,
      (Instruction /*P*/ )null);
  }
  private ExtractElementInst(Value /*P*/ Val, Value /*P*/ Index,
      final /*const*/ Twine /*&*/ Name/*= ""*/,
      Instruction /*P*/ InsertBef/*= null*/) {
    // : Instruction(cast<VectorType>(Val->getType())->getElementType(), ExtractElement, OperandTraits<ExtractElementInst>::op_begin(this), 2, InsertBef)
    //START JInit
    super(cast_VectorType(Val.getType()).getElementType(),
        OtherOps.ExtractElement,
        OperandTraitsExtractElementInst.op_begin(User.$BEING_CREATED()),
        2, InsertBef);
    //END JInit
    assert (isValidOperands(Val, Index)) : "Invalid extractelement instruction operands!";
    this./*<0>*/Op(0).$assign(Val);
    this./*<1>*/Op(1).$assign(Index);
    setName(Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::ExtractElementInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1762,
   FQN="llvm::ExtractElementInst::ExtractElementInst", NM="_ZN4llvm18ExtractElementInstC1EPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm18ExtractElementInstC1EPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  private ExtractElementInst(Value /*P*/ Val, Value /*P*/ Index,
      final /*const*/ Twine /*&*/ Name,
      BasicBlock /*P*/ InsertAE) {
    // : Instruction(cast<VectorType>(Val->getType())->getElementType(), ExtractElement, OperandTraits<ExtractElementInst>::op_begin(this), 2, InsertAE)
    //START JInit
    super(cast_VectorType(Val.getType()).getElementType(),
        OtherOps.ExtractElement,
        OperandTraitsExtractElementInst.op_begin(User.$BEING_CREATED()),
        2, InsertAE);
    //END JInit
    assert (isValidOperands(Val, Index)) : "Invalid extractelement instruction operands!";

    this./*<0>*/Op(0).$assign(Val);
    this./*<1>*/Op(1).$assign(Index);
    setName(Name);
  }

/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 4023,
   FQN="llvm::ExtractElementInst::cloneImpl", NM="_ZNK4llvm18ExtractElementInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm18ExtractElementInst9cloneImplEv")
  //</editor-fold>
  protected ExtractElementInst /*P*/ cloneImpl() /*const*/ {
    return ExtractElementInst.Create(getOperand(0), getOperand(1));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2038,
   FQN="llvm::ExtractElementInst::Create", NM="_ZN4llvm18ExtractElementInst6CreateEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm18ExtractElementInst6CreateEPNS_5ValueES2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static ExtractElementInst /*P*/ Create(Value /*P*/ Vec, Value /*P*/ Idx) {
    return Create(Vec, Idx,
        new Twine(/*KEEP_STR*/$EMPTY),
        (Instruction /*P*/ )null);
  }
  public static ExtractElementInst /*P*/ Create(Value /*P*/ Vec, Value /*P*/ Idx,
        final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    return Create(Vec, Idx,
        NameStr,
        (Instruction /*P*/ )null);
  }
  public static ExtractElementInst /*P*/ Create(Value /*P*/ Vec, Value /*P*/ Idx,
        final /*const*/ Twine /*&*/ NameStr/*= ""*/,
        Instruction /*P*/ InsertBefore/*= null*/) {
    return ((/*JCast*/ExtractElementInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (2)*/ User.$new_FixedUses(2, (type$ptr<?> New$Mem)->{
        return new ExtractElementInst(Vec, Idx, NameStr, InsertBefore);
     })));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2043,
   FQN="llvm::ExtractElementInst::Create", NM="_ZN4llvm18ExtractElementInst6CreateEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm18ExtractElementInst6CreateEPNS_5ValueES2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static ExtractElementInst /*P*/ Create(Value /*P*/ Vec, Value /*P*/ Idx,
        final /*const*/ Twine /*&*/ NameStr,
        BasicBlock /*P*/ InsertAtEnd) {
    return ((/*JCast*/ExtractElementInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (2)*/ User.$new_FixedUses(2, (type$ptr<?> New$Mem)->{
        return new ExtractElementInst(Vec, Idx, NameStr, InsertAtEnd);
     })));
  }


  /// isValidOperands - Return true if an extractelement instruction can be
  /// formed with the specified operands.
  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::isValidOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1778,
   FQN="llvm::ExtractElementInst::isValidOperands", NM="_ZN4llvm18ExtractElementInst15isValidOperandsEPKNS_5ValueES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm18ExtractElementInst15isValidOperandsEPKNS_5ValueES3_")
  //</editor-fold>
  public static boolean isValidOperands(/*const*/ Value /*P*/ Val, /*const*/ Value /*P*/ Index) {
    if (!Val.getType().isVectorTy() || !Index.getType().isIntegerTy()) {
      return false;
    }
    return true;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::getVectorOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2053,
   FQN="llvm::ExtractElementInst::getVectorOperand", NM="_ZN4llvm18ExtractElementInst16getVectorOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm18ExtractElementInst16getVectorOperandEv")
  //</editor-fold>
  public Value /*P*/ getVectorOperand() {
    return this./*<0>*/Op(0).$Value$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::getIndexOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2054,
   FQN="llvm::ExtractElementInst::getIndexOperand", NM="_ZN4llvm18ExtractElementInst15getIndexOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm18ExtractElementInst15getIndexOperandEv")
  //</editor-fold>
  public Value /*P*/ getIndexOperand() {
    return this./*<1>*/Op(1).$Value$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::getVectorOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2055,
   FQN="llvm::ExtractElementInst::getVectorOperand", NM="_ZNK4llvm18ExtractElementInst16getVectorOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm18ExtractElementInst16getVectorOperandEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getVectorOperand$Const() /*const*/ {
    return this./*<0>*/Op$Const(0).$Value$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::getIndexOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2056,
   FQN="llvm::ExtractElementInst::getIndexOperand", NM="_ZNK4llvm18ExtractElementInst15getIndexOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm18ExtractElementInst15getIndexOperandEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getIndexOperand$Const() /*const*/ {
    return this./*<1>*/Op$Const(1).$Value$P();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::getVectorOperandType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2058,
   FQN="llvm::ExtractElementInst::getVectorOperandType", NM="_ZNK4llvm18ExtractElementInst20getVectorOperandTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm18ExtractElementInst20getVectorOperandTypeEv")
  //</editor-fold>
  public VectorType /*P*/ getVectorOperandType() /*const*/ {
    return cast_VectorType(getVectorOperand$Const().getType());
  }


  /// Transparently provide more efficient getOperand methods.
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2079,
   FQN="llvm::ExtractElementInst::getOperand", NM="_ZNK4llvm18ExtractElementInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm18ExtractElementInst10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsExtractElementInst.operands$FixedNumOperandTraits(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsExtractElementInst.op_begin(((/*const_cast*/ExtractElementInst /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2079,
   FQN="llvm::ExtractElementInst::setOperand", NM="_ZN4llvm18ExtractElementInst10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm18ExtractElementInst10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsExtractElementInst.operands$FixedNumOperandTraits(this))) : "setOperand() out of range!";
    OperandTraitsExtractElementInst.op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2079,
   FQN="llvm::ExtractElementInst::op_begin", NM="_ZN4llvm18ExtractElementInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm18ExtractElementInst8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsExtractElementInst.op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2079,
   FQN="llvm::ExtractElementInst::op_begin", NM="_ZNK4llvm18ExtractElementInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm18ExtractElementInst8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsExtractElementInst.op_begin(((/*const_cast*/ExtractElementInst /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2079,
   FQN="llvm::ExtractElementInst::op_end", NM="_ZN4llvm18ExtractElementInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm18ExtractElementInst6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsExtractElementInst.op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2079,
   FQN="llvm::ExtractElementInst::op_end", NM="_ZNK4llvm18ExtractElementInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm18ExtractElementInst6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsExtractElementInst.op_end(((/*const_cast*/ExtractElementInst /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2079,
   FQN="llvm::ExtractElementInst::Op", NM="Tpl__ZN4llvm18ExtractElementInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm18ExtractElementInst2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2079,
   FQN="llvm::ExtractElementInst::Op", NM="Tpl__ZNK4llvm18ExtractElementInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm18ExtractElementInst2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2079,
   FQN="llvm::ExtractElementInst::getNumOperands", NM="_ZNK4llvm18ExtractElementInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm18ExtractElementInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsExtractElementInst.operands$FixedNumOperandTraits(this);
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2066,
   FQN="llvm::ExtractElementInst::classof", NM="_ZN4llvm18ExtractElementInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm18ExtractElementInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.OtherOps.ExtractElement;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2069,
   FQN="llvm::ExtractElementInst::classof", NM="_ZN4llvm18ExtractElementInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm18ExtractElementInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && ExtractElementInst.classof(cast_Instruction(V));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractElementInst::~ExtractElementInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2026,
   FQN="llvm::ExtractElementInst::~ExtractElementInst", NM="_ZN4llvm18ExtractElementInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm18ExtractElementInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
