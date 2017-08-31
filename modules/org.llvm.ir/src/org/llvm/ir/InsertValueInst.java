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
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;


//===----------------------------------------------------------------------===//
//                                InsertValueInst Class
//===----------------------------------------------------------------------===//

/// InsertValueInst - This instruction inserts a struct field of array element
/// value into an aggregate value.
///
//<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2339,
 FQN="llvm::InsertValueInst", NM="_ZN4llvm15InsertValueInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15InsertValueInstE")
//</editor-fold>
public class InsertValueInst extends /*public*/ Instruction implements Destructors.ClassWithDestructor {
  private SmallVectorUInt Indices;

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2342,
   FQN="llvm::InsertValueInst::operator new", NM="_ZN4llvm15InsertValueInstnwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15InsertValueInstnwEjj")
  //</editor-fold>
  protected/*private*/ static Object/*void P*/ $new(/*size_t*/int $Prm0, /*uint*/int $Prm1) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::InsertValueInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1974,
   FQN="llvm::InsertValueInst::InsertValueInst", NM="_ZN4llvm15InsertValueInstC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15InsertValueInstC1ERKS0_")
  //</editor-fold>
  private InsertValueInst(final /*const*/ InsertValueInst /*&*/ IVI) {
    // : Instruction(IVI.getType(), InsertValue, OperandTraits<InsertValueInst>::op_begin(this), 2), Indices(IVI.Indices)
    //START JInit
    super(IVI.getType(), OtherOps.InsertValue,
        OperandTraitsInsertValueInst.<InsertValueInst>op_begin(User.$BEING_CREATED()), 2);
    this.Indices = new SmallVectorUInt(IVI.Indices);
    //END JInit
    this./*<0>*/Op(0).$assign(IVI.getOperand(0));
    this./*<1>*/Op(1).$assign(IVI.getOperand(1));
    SubclassOptionalData = $uchar2uchar_7bits($7bits_uchar2uchar(IVI.SubclassOptionalData));
  }


  //===----------------------------------------------------------------------===//
  //                             InsertValueInst Class
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1955,
   FQN="llvm::InsertValueInst::init", NM="_ZN4llvm15InsertValueInst4initEPNS_5ValueES2_NS_8ArrayRefIjEERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15InsertValueInst4initEPNS_5ValueES2_NS_8ArrayRefIjEERKNS_5TwineE")
  //</editor-fold>
  private void init(Value /*P*/ Agg, Value /*P*/ Val, ArrayRefUInt Idxs,
      final /*const*/ Twine /*&*/ Name) {
    assert (getNumOperands() == 2) : "NumOperands not initialized?";

    // There's no fundamental reason why we require at least one index
    // (other than weirdness with &*IdxBegin being invalid; see
    // getelementptr's init routine for example). But there's no
    // present need to support it.
    assert ($greater_uint(Idxs.size(), 0)) : "InsertValueInst must have at least one index";
    assert (ExtractValueInst.getIndexedType(Agg.getType(), new ArrayRefUInt(Idxs)) == Val.getType()) : "Inserted value must match indexed type!";
    this./*<0>*/Op(0).$assign(Agg);
    this./*<1>*/Op(1).$assign(Val);

    Indices.append_T(Idxs.begin(), Idxs.end());
    setName(Name);
  }


  /// Constructors - Create a insertvalue instruction with a base aggregate
  /// value, a value to insert, and a list of indices.  The first ctor can
  /// optionally insert before an existing instruction, the second appends
  /// the new instruction to the specified BasicBlock.
  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::InsertValueInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2447,
   FQN="llvm::InsertValueInst::InsertValueInst", NM="_ZN4llvm15InsertValueInstC1EPNS_5ValueES2_NS_8ArrayRefIjEERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15InsertValueInstC1EPNS_5ValueES2_NS_8ArrayRefIjEERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  private InsertValueInst(JD$Value$P_ArrayRefUInt_Twine$C_Instruction$P _dparam, Value /*P*/ Agg,
      Value /*P*/ Val,
      ArrayRefUInt Idxs,
      final /*const*/ Twine /*&*/ NameStr,
      Instruction /*P*/ InsertBefore) {
    // : Instruction(Agg->getType(), InsertValue, OperandTraits<InsertValueInst>::op_begin(this), 2, InsertBefore), Indices()
    //START JInit
    super(Agg.getType(), OtherOps.InsertValue,
        OperandTraitsInsertValueInst.<InsertValueInst>op_begin(User.$BEING_CREATED()),
        2, InsertBefore);
    this.Indices = new SmallVectorUInt(4, 0);
    //END JInit
    init(Agg, Val, new ArrayRefUInt(Idxs), NameStr);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::InsertValueInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2457,
   FQN="llvm::InsertValueInst::InsertValueInst", NM="_ZN4llvm15InsertValueInstC1EPNS_5ValueES2_NS_8ArrayRefIjEERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15InsertValueInstC1EPNS_5ValueES2_NS_8ArrayRefIjEERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  private InsertValueInst(JD$Value$P_ArrayRefUInt_Twine$C_BasicBlock$P _dparam, Value /*P*/ Agg,
      Value /*P*/ Val,
      ArrayRefUInt Idxs,
      final /*const*/ Twine /*&*/ NameStr,
      BasicBlock /*P*/ InsertAtEnd) {
    // : Instruction(Agg->getType(), InsertValue, OperandTraits<InsertValueInst>::op_begin(this), 2, InsertAtEnd), Indices()
    //START JInit
    super(Agg.getType(), OtherOps.InsertValue,
        OperandTraitsInsertValueInst.<InsertValueInst>op_begin(User.$BEING_CREATED()),
        2, InsertAtEnd);
    this.Indices = new SmallVectorUInt(4, 0);
    //END JInit
    init(Agg, Val, new ArrayRefUInt(Idxs), NameStr);
  }


  /// Constructors - These two constructors are convenience methods because one
  /// and two index insertvalue instructions are so common.
  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::InsertValueInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2361,
   FQN="llvm::InsertValueInst::InsertValueInst", NM="_ZN4llvm15InsertValueInstC1EPNS_5ValueES2_jRKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15InsertValueInstC1EPNS_5ValueES2_jRKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  private InsertValueInst(Value /*P*/ Agg, Value /*P*/ Val, /*uint*/int Idx,
      final /*const*/ Twine /*&*/ NameStr/*= ""*/,
      Instruction /*P*/ InsertBefore/*= null*/) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::InsertValueInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2364,
   FQN="llvm::InsertValueInst::InsertValueInst", NM="_ZN4llvm15InsertValueInstC1EPNS_5ValueES2_jRKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15InsertValueInstC1EPNS_5ValueES2_jRKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  private InsertValueInst(Value /*P*/ Agg, Value /*P*/ Val, /*uint*/int Idx, final /*const*/ Twine /*&*/ NameStr,
      BasicBlock /*P*/ InsertAtEnd) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3910,
   FQN="llvm::InsertValueInst::cloneImpl", NM="_ZNK4llvm15InsertValueInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15InsertValueInst9cloneImplEv")
  //</editor-fold>
  protected InsertValueInst /*P*/ cloneImpl() /*const*/ {
    return /*NEW_EXPR [InsertValueInst::new]*/InsertValueInst.$new_InsertValueInst((type$ptr<?> New$Mem)->{
        return new InsertValueInst(/*Deref*/this);
     });
  }

/*public:*/
  // allocate space for exactly two operands
  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::operator new">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2374,
   FQN="llvm::InsertValueInst::operator new", NM="_ZN4llvm15InsertValueInstnwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15InsertValueInstnwEj")
  //</editor-fold>  
  public static <T extends FenceInst> T/*void P*/ $new_FenceInst(New$ConstructorCallback<T> $Ctor) {
    return User.$new_FixedUses(/*s, */2, $Ctor);
  }
  public static <T extends InsertValueInst> T/*void P*/ $new_InsertValueInst(New$ConstructorCallback<T> $Ctor) {
    return User.$new_FixedUses(/*s, */2, $Ctor);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2378,
   FQN="llvm::InsertValueInst::Create", NM="_ZN4llvm15InsertValueInst6CreateEPNS_5ValueES2_NS_8ArrayRefIjEERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15InsertValueInst6CreateEPNS_5ValueES2_NS_8ArrayRefIjEERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static InsertValueInst /*P*/ Create_Value$P_ArrayRefUInt_Twine$C_Instruction$P(Value /*P*/ Agg, Value /*P*/ Val,
                                                   ArrayRefUInt Idxs) {
    return Create_Value$P_ArrayRefUInt_Twine$C_Instruction$P(Agg, Val,
                                                   Idxs,
                                                   new Twine(/*KEEP_STR*/$EMPTY),
                                                   (Instruction /*P*/ )null);
  }
  public static InsertValueInst /*P*/ Create_Value$P_ArrayRefUInt_Twine$C_Instruction$P(Value /*P*/ Agg, Value /*P*/ Val,
                                                   ArrayRefUInt Idxs,
                                                   final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    return Create_Value$P_ArrayRefUInt_Twine$C_Instruction$P(Agg, Val,
                                                   Idxs,
                                                   NameStr,
                                                   (Instruction /*P*/ )null);
  }
  public static InsertValueInst /*P*/ Create_Value$P_ArrayRefUInt_Twine$C_Instruction$P(Value /*P*/ Agg, Value /*P*/ Val,
                                                   ArrayRefUInt Idxs,
                                                   final /*const*/ Twine /*&*/ NameStr/*= ""*/,
                                                   Instruction /*P*/ InsertBefore/*= null*/) {
    return /*NEW_EXPR [InsertValueInst::new]*/InsertValueInst.$new_InsertValueInst((type$ptr<?> New$Mem)->{
        return new InsertValueInst(JD$Value$P_ArrayRefUInt_Twine$C_Instruction$P.INSTANCE, Agg, Val, new ArrayRefUInt(Idxs), NameStr, InsertBefore);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2384,
   FQN="llvm::InsertValueInst::Create", NM="_ZN4llvm15InsertValueInst6CreateEPNS_5ValueES2_NS_8ArrayRefIjEERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15InsertValueInst6CreateEPNS_5ValueES2_NS_8ArrayRefIjEERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static InsertValueInst /*P*/ Create_Value$P_ArrayRefUInt_Twine$C_BasicBlock$P(Value /*P*/ Agg, Value /*P*/ Val,
                                                  ArrayRefUInt Idxs,
                                                  final /*const*/ Twine /*&*/ NameStr,
                                                  BasicBlock /*P*/ InsertAtEnd) {
    return /*NEW_EXPR [InsertValueInst::new]*/InsertValueInst.$new_InsertValueInst((type$ptr<?> New$Mem)->{
        return new InsertValueInst(JD$Value$P_ArrayRefUInt_Twine$C_BasicBlock$P.INSTANCE, Agg, Val, new ArrayRefUInt(Idxs), NameStr, InsertAtEnd);
     });
  }


  /// Transparently provide more efficient getOperand methods.
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2468,
   FQN="llvm::InsertValueInst::getOperand", NM="_ZNK4llvm15InsertValueInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15InsertValueInst10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsInsertValueInst.<InsertValueInst>operands$FixedNumOperandTraits(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsInsertValueInst.<InsertValueInst>op_begin(((/*const_cast*/InsertValueInst /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2468,
   FQN="llvm::InsertValueInst::setOperand", NM="_ZN4llvm15InsertValueInst10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15InsertValueInst10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsInsertValueInst.<InsertValueInst>operands$FixedNumOperandTraits(this))) : "setOperand() out of range!";
    OperandTraitsInsertValueInst.<InsertValueInst>op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2468,
   FQN="llvm::InsertValueInst::op_begin", NM="_ZN4llvm15InsertValueInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15InsertValueInst8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsInsertValueInst.<InsertValueInst>op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2468,
   FQN="llvm::InsertValueInst::op_begin", NM="_ZNK4llvm15InsertValueInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15InsertValueInst8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsInsertValueInst.<InsertValueInst>op_begin(((/*const_cast*/InsertValueInst /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2468,
   FQN="llvm::InsertValueInst::op_end", NM="_ZN4llvm15InsertValueInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15InsertValueInst6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsInsertValueInst.<InsertValueInst>op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2468,
   FQN="llvm::InsertValueInst::op_end", NM="_ZNK4llvm15InsertValueInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15InsertValueInst6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsInsertValueInst.<InsertValueInst>op_end(((/*const_cast*/InsertValueInst /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2468,
   FQN="llvm::InsertValueInst::Op", NM="Tpl__ZN4llvm15InsertValueInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm15InsertValueInst2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this.OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2468,
   FQN="llvm::InsertValueInst::Op", NM="Tpl__ZNK4llvm15InsertValueInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm15InsertValueInst2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this.OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2468,
   FQN="llvm::InsertValueInst::getNumOperands", NM="_ZNK4llvm15InsertValueInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15InsertValueInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsInsertValueInst.<InsertValueInst>operands$FixedNumOperandTraits(this);
  }


  // JAVA: typedef const unsigned int *idx_iterator;
  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::idx_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2395,
   FQN="llvm::InsertValueInst::idx_begin", NM="_ZNK4llvm15InsertValueInst9idx_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15InsertValueInst9idx_beginEv")
  //</editor-fold>
  public /*inline*/ /*const*/uint$ptr/*uint P*/ idx_begin() /*const*/ {
    return Indices.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::idx_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2396,
   FQN="llvm::InsertValueInst::idx_end", NM="_ZNK4llvm15InsertValueInst7idx_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15InsertValueInst7idx_endEv")
  //</editor-fold>
  public /*inline*/ /*const*/uint$ptr/*uint P*/ idx_end() /*const*/ {
    return Indices.end$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::indices">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2397,
   FQN="llvm::InsertValueInst::indices", NM="_ZNK4llvm15InsertValueInst7indicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15InsertValueInst7indicesEv")
  //</editor-fold>
  public /*inline*/ iterator_rangeUInt indices() /*const*/ {
    return make_range(idx_begin(), idx_end());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::getAggregateOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2401,
   FQN="llvm::InsertValueInst::getAggregateOperand", NM="_ZN4llvm15InsertValueInst19getAggregateOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15InsertValueInst19getAggregateOperandEv")
  //</editor-fold>
  public Value /*P*/ getAggregateOperand() {
    return getOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::getAggregateOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2404,
   FQN="llvm::InsertValueInst::getAggregateOperand", NM="_ZNK4llvm15InsertValueInst19getAggregateOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15InsertValueInst19getAggregateOperandEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getAggregateOperand$Const() /*const*/ {
    return getOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::getAggregateOperandIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2407,
   FQN="llvm::InsertValueInst::getAggregateOperandIndex", NM="_ZN4llvm15InsertValueInst24getAggregateOperandIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15InsertValueInst24getAggregateOperandIndexEv")
  //</editor-fold>
  public static /*uint*/int getAggregateOperandIndex() {
    return 0/*U*/; // get index for modifying correct operand
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::getInsertedValueOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2411,
   FQN="llvm::InsertValueInst::getInsertedValueOperand", NM="_ZN4llvm15InsertValueInst23getInsertedValueOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15InsertValueInst23getInsertedValueOperandEv")
  //</editor-fold>
  public Value /*P*/ getInsertedValueOperand() {
    return getOperand(1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::getInsertedValueOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2414,
   FQN="llvm::InsertValueInst::getInsertedValueOperand", NM="_ZNK4llvm15InsertValueInst23getInsertedValueOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15InsertValueInst23getInsertedValueOperandEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getInsertedValueOperand$Const() /*const*/ {
    return getOperand(1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::getInsertedValueOperandIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2417,
   FQN="llvm::InsertValueInst::getInsertedValueOperandIndex", NM="_ZN4llvm15InsertValueInst28getInsertedValueOperandIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15InsertValueInst28getInsertedValueOperandIndexEv")
  //</editor-fold>
  public static /*uint*/int getInsertedValueOperandIndex() {
    return 1/*U*/; // get index for modifying correct operand
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::getIndices">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2421,
   FQN="llvm::InsertValueInst::getIndices", NM="_ZNK4llvm15InsertValueInst10getIndicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15InsertValueInst10getIndicesEv")
  //</editor-fold>
  public ArrayRefUInt getIndices() /*const*/ {
    return new ArrayRefUInt(Indices);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::getNumIndices">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2425,
   FQN="llvm::InsertValueInst::getNumIndices", NM="_ZNK4llvm15InsertValueInst13getNumIndicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15InsertValueInst13getNumIndicesEv")
  //</editor-fold>
  public /*uint*/int getNumIndices() /*const*/ {
    return (/*uint*/int)Indices.size();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::hasIndices">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2429,
   FQN="llvm::InsertValueInst::hasIndices", NM="_ZNK4llvm15InsertValueInst10hasIndicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15InsertValueInst10hasIndicesEv")
  //</editor-fold>
  public boolean hasIndices() /*const*/ {
    return true;
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2434,
   FQN="llvm::InsertValueInst::classof", NM="_ZN4llvm15InsertValueInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15InsertValueInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.OtherOps.InsertValue;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2437,
   FQN="llvm::InsertValueInst::classof", NM="_ZN4llvm15InsertValueInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15InsertValueInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && InsertValueInst.classof(cast_Instruction(V));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InsertValueInst::~InsertValueInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2339,
   FQN="llvm::InsertValueInst::~InsertValueInst", NM="_ZN4llvm15InsertValueInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15InsertValueInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Indices.$destroy();
    super.$destroy();
    //END JDestroy
  }

  @Override public String toString() {
    return "" + "Indices=" + Indices // NOI18N
              + super.toString(); // NOI18N
  }
}
