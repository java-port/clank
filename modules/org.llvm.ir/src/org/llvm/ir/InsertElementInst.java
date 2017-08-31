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
//                                InsertElementInst Class
//===----------------------------------------------------------------------===//

/// InsertElementInst - This instruction inserts a single (scalar)
/// element into a VectorType value
///
//<editor-fold defaultstate="collapsed" desc="llvm::InsertElementInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2088,
 FQN="llvm::InsertElementInst", NM="_ZN4llvm17InsertElementInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17InsertElementInstE")
//</editor-fold>
public class InsertElementInst extends /*public*/ Instruction implements Destructors.ClassWithDestructor {

  //===----------------------------------------------------------------------===//
  //                           InsertElementInst Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::InsertElementInst::InsertElementInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1789,
   FQN="llvm::InsertElementInst::InsertElementInst", NM="_ZN4llvm17InsertElementInstC1EPNS_5ValueES2_S2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17InsertElementInstC1EPNS_5ValueES2_S2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  private InsertElementInst(Value /*P*/ Vec, Value /*P*/ Elt, Value /*P*/ Index) {
    this(Vec, Elt, Index,
      new Twine(/*KEEP_STR*/$EMPTY),
      (Instruction /*P*/ )null);
  }
  private InsertElementInst(Value /*P*/ Vec, Value /*P*/ Elt, Value /*P*/ Index,
      final /*const*/ Twine /*&*/ Name/*= ""*/) {
    this(Vec, Elt, Index,
      Name,
      (Instruction /*P*/ )null);
  }
  private InsertElementInst(Value /*P*/ Vec, Value /*P*/ Elt, Value /*P*/ Index,
      final /*const*/ Twine /*&*/ Name/*= ""*/,
      Instruction /*P*/ InsertBef/*= null*/) {
    // : Instruction(Vec->getType(), InsertElement, OperandTraits<InsertElementInst>::op_begin(this), 3, InsertBef)
    //START JInit
    super(Vec.getType(), OtherOps.InsertElement,
        OperandTraitsInsertElementInst.<InsertElementInst>op_begin(User.$BEING_CREATED()/*this*/),
        3, InsertBef);
    //END JInit
    assert (isValidOperands(Vec, Elt, Index)) : "Invalid insertelement instruction operands!";
    this./*<0>*/Op(0).$assign(Vec);
    this./*<1>*/Op(1).$assign(Elt);
    this./*<2>*/Op(2).$assign(Index);
    setName(Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertElementInst::InsertElementInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1803,
   FQN="llvm::InsertElementInst::InsertElementInst", NM="_ZN4llvm17InsertElementInstC1EPNS_5ValueES2_S2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17InsertElementInstC1EPNS_5ValueES2_S2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  private InsertElementInst(Value /*P*/ Vec, Value /*P*/ Elt, Value /*P*/ Index,
      final /*const*/ Twine /*&*/ Name,
      BasicBlock /*P*/ InsertAE) {
    // : Instruction(Vec->getType(), InsertElement, OperandTraits<InsertElementInst>::op_begin(this), 3, InsertAE)
    //START JInit
    super(Vec.getType(), OtherOps.InsertElement,
        OperandTraitsInsertElementInst.<InsertElementInst>op_begin(User.$BEING_CREATED()/*this*/),
        3, InsertAE);
    //END JInit
    assert (isValidOperands(Vec, Elt, Index)) : "Invalid insertelement instruction operands!";

    this./*<0>*/Op(0).$assign(Vec);
    this./*<1>*/Op(1).$assign(Elt);
    this./*<2>*/Op(2).$assign(Index);
    setName(Name);
  }

/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InsertElementInst::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 4027,
   FQN="llvm::InsertElementInst::cloneImpl", NM="_ZNK4llvm17InsertElementInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17InsertElementInst9cloneImplEv")
  //</editor-fold>
  protected InsertElementInst /*P*/ cloneImpl() /*const*/ {
    return InsertElementInst.Create(getOperand(0), getOperand(1), getOperand(2));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InsertElementInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2101,
   FQN="llvm::InsertElementInst::Create", NM="_ZN4llvm17InsertElementInst6CreateEPNS_5ValueES2_S2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17InsertElementInst6CreateEPNS_5ValueES2_S2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static InsertElementInst /*P*/ Create(Value /*P*/ Vec, Value /*P*/ NewElt, Value /*P*/ Idx) {
    return Create(Vec, NewElt, Idx,
        new Twine(/*KEEP_STR*/$EMPTY),
        (Instruction /*P*/ )null);
  }
  public static InsertElementInst /*P*/ Create(Value /*P*/ Vec, Value /*P*/ NewElt, Value /*P*/ Idx,
        final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    return Create(Vec, NewElt, Idx,
        NameStr,
        (Instruction /*P*/ )null);
  }
  public static InsertElementInst /*P*/ Create(Value /*P*/ Vec, Value /*P*/ NewElt, Value /*P*/ Idx,
        final /*const*/ Twine /*&*/ NameStr/*= ""*/,
        Instruction /*P*/ InsertBefore/*= null*/) {
    return ((/*JCast*/InsertElementInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (3)*/ User.$new_FixedUses(3, (type$ptr<?> New$Mem)->{
        return new InsertElementInst(Vec, NewElt, Idx, NameStr, InsertBefore);
     })));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertElementInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2106,
   FQN="llvm::InsertElementInst::Create", NM="_ZN4llvm17InsertElementInst6CreateEPNS_5ValueES2_S2_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17InsertElementInst6CreateEPNS_5ValueES2_S2_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static InsertElementInst /*P*/ Create(Value /*P*/ Vec, Value /*P*/ NewElt, Value /*P*/ Idx,
        final /*const*/ Twine /*&*/ NameStr,
        BasicBlock /*P*/ InsertAtEnd) {
    return ((/*JCast*/InsertElementInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (3)*/ User.$new_FixedUses(3, (type$ptr<?> New$Mem)->{
        return new InsertElementInst(Vec, NewElt, Idx, NameStr, InsertAtEnd);
     })));
  }


  /// isValidOperands - Return true if an insertelement instruction can be
  /// formed with the specified operands.
  //<editor-fold defaultstate="collapsed" desc="llvm::InsertElementInst::isValidOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1818,
   FQN="llvm::InsertElementInst::isValidOperands", NM="_ZN4llvm17InsertElementInst15isValidOperandsEPKNS_5ValueES3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17InsertElementInst15isValidOperandsEPKNS_5ValueES3_S3_")
  //</editor-fold>
  public static boolean isValidOperands(/*const*/ Value /*P*/ Vec, /*const*/ Value /*P*/ Elt,
                 /*const*/ Value /*P*/ Index) {
    if (!Vec.getType().isVectorTy()) {
      return false; // First operand of insertelement must be vector type.
    }
    if (Elt.getType() != cast_VectorType(Vec.getType()).getElementType()) {
      return false; // Second operand of insertelement must be vector element type.
    }
    if (!Index.getType().isIntegerTy()) {
      return false; // Third operand of insertelement must be i32.
    }
    return true;
  }


  /// getType - Overload to return most specific vector type.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::InsertElementInst::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2119,
   FQN="llvm::InsertElementInst::getType", NM="_ZNK4llvm17InsertElementInst7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17InsertElementInst7getTypeEv")
  //</editor-fold>
  public VectorType /*P*/ getType() /*const*/ {
    return cast_VectorType(super.getType());
  }


  /// Transparently provide more efficient getOperand methods.
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InsertElementInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2140,
   FQN="llvm::InsertElementInst::getOperand", NM="_ZNK4llvm17InsertElementInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17InsertElementInst10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsInsertElementInst.operands$FixedNumOperandTraits(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsInsertElementInst.op_begin(((/*const_cast*/InsertElementInst /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertElementInst::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2140,
   FQN="llvm::InsertElementInst::setOperand", NM="_ZN4llvm17InsertElementInst10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17InsertElementInst10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsInsertElementInst.operands$FixedNumOperandTraits(this))) : "setOperand() out of range!";
    OperandTraitsInsertElementInst.op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertElementInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2140,
   FQN="llvm::InsertElementInst::op_begin", NM="_ZN4llvm17InsertElementInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17InsertElementInst8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsInsertElementInst.op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertElementInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2140,
   FQN="llvm::InsertElementInst::op_begin", NM="_ZNK4llvm17InsertElementInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17InsertElementInst8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsInsertElementInst.op_begin(((/*const_cast*/InsertElementInst /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertElementInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2140,
   FQN="llvm::InsertElementInst::op_end", NM="_ZN4llvm17InsertElementInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17InsertElementInst6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsInsertElementInst.op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertElementInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2140,
   FQN="llvm::InsertElementInst::op_end", NM="_ZNK4llvm17InsertElementInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17InsertElementInst6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsInsertElementInst.op_end(((/*const_cast*/InsertElementInst /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InsertElementInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2140,
   FQN="llvm::InsertElementInst::Op", NM="Tpl__ZN4llvm17InsertElementInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm17InsertElementInst2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InsertElementInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2140,
   FQN="llvm::InsertElementInst::Op", NM="Tpl__ZNK4llvm17InsertElementInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm17InsertElementInst2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InsertElementInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2140,
   FQN="llvm::InsertElementInst::getNumOperands", NM="_ZNK4llvm17InsertElementInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17InsertElementInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsInsertElementInst.operands$FixedNumOperandTraits(this);
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::InsertElementInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2127,
   FQN="llvm::InsertElementInst::classof", NM="_ZN4llvm17InsertElementInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17InsertElementInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.OtherOps.InsertElement;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertElementInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2130,
   FQN="llvm::InsertElementInst::classof", NM="_ZN4llvm17InsertElementInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17InsertElementInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && InsertElementInst.classof(cast_Instruction(V));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertElementInst::~InsertElementInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2088,
   FQN="llvm::InsertElementInst::~InsertElementInst", NM="_ZN4llvm17InsertElementInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17InsertElementInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
