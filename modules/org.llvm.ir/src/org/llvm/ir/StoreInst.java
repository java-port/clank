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
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
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
//                                StoreInst Class
//===----------------------------------------------------------------------===//

/// StoreInst - an instruction for storing to memory
///
//<editor-fold defaultstate="collapsed" desc="llvm::StoreInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 305,
 FQN="llvm::StoreInst", NM="_ZN4llvm9StoreInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInstE")
//</editor-fold>
public class StoreInst extends /*public*/ Instruction implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 306,
   FQN="llvm::StoreInst::operator new", NM="_ZN4llvm9StoreInstnwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInstnwEjj")
  //</editor-fold>
  protected/*private*/ static Object/*void P*/ $new_StoreInst(/*size_t*/int $Prm0, /*uint*/int $Prm1) { throw new UnsupportedOperationException("Deleted");}


  //===----------------------------------------------------------------------===//
  //                           StoreInst Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::AssertOK">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1430,
   FQN="llvm::StoreInst::AssertOK", NM="_ZN4llvm9StoreInst8AssertOKEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInst8AssertOKEv")
  //</editor-fold>
  private void AssertOK() {
    assert ((getOperand(0) != null) && (getOperand(1) != null)) : "Both operands must be non-null!";
    assert (getOperand(1).getType().isPointerTy()) : "Ptr must have pointer type!";
    assert (getOperand(0).getType() == cast_PointerType(getOperand(1).getType()).getElementType()) : "Ptr must be a pointer to Val type!";
    assert (!(isAtomic() && getAlignment() == 0)) : "Alignment required for atomic store";
  }

/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3927,
   FQN="llvm::StoreInst::cloneImpl", NM="_ZNK4llvm9StoreInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm9StoreInst9cloneImplEv")
  //</editor-fold>
  protected StoreInst /*P*/ cloneImpl() /*const*/ {
    return /*NEW_EXPR [StoreInst::new]*/StoreInst.$new_StoreInst((type$ptr<?> New$Mem)->{
        return new StoreInst(getOperand(0), getOperand(1), isVolatile(),
                getAlignment(), getOrdering(), getSynchScope());
     });
  }

/*public:*/
  // allocate space for exactly two operands
  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::operator new">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 316,
   FQN="llvm::StoreInst::operator new", NM="_ZN4llvm9StoreInstnwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInstnwEj")
  //</editor-fold>
  public static <T extends StoreInst> T/*void P*/ $new_StoreInst(New$ConstructorCallback<T> $Ctor) {
    return User.$new_FixedUses(/*s, */2, $Ctor);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::StoreInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1441,
   FQN="llvm::StoreInst::StoreInst", NM="_ZN4llvm9StoreInstC1EPNS_5ValueES2_PNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInstC1EPNS_5ValueES2_PNS_11InstructionE")
  //</editor-fold>
  public StoreInst(Value /*P*/ val, Value /*P*/ addr, Instruction /*P*/ InsertBefore) {
    // : StoreInst(val, addr, /*isVolatile=*/ false, InsertBefore)
    //START JInit
    this(val, addr, false, InsertBefore);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::StoreInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1444,
   FQN="llvm::StoreInst::StoreInst", NM="_ZN4llvm9StoreInstC1EPNS_5ValueES2_PNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInstC1EPNS_5ValueES2_PNS_10BasicBlockE")
  //</editor-fold>
  public StoreInst(Value /*P*/ val, Value /*P*/ addr, BasicBlock /*P*/ InsertAtEnd) {
    // : StoreInst(val, addr, /*isVolatile=*/ false, InsertAtEnd)
    //START JInit
    this(val, addr, false, InsertAtEnd);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::StoreInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1447,
   FQN="llvm::StoreInst::StoreInst", NM="_ZN4llvm9StoreInstC1EPNS_5ValueES2_bPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInstC1EPNS_5ValueES2_bPNS_11InstructionE")
  //</editor-fold>
  public StoreInst(Value /*P*/ val, Value /*P*/ addr) {
    this(val, addr, false,
      (Instruction /*P*/ )null);
  }
  public StoreInst(Value /*P*/ val, Value /*P*/ addr, boolean isVolatile/*= false*/) {
    this(val, addr, isVolatile,
      (Instruction /*P*/ )null);
  }
  public StoreInst(Value /*P*/ val, Value /*P*/ addr, boolean isVolatile/*= false*/,
      Instruction /*P*/ InsertBefore/*= null*/) {
    // : StoreInst(val, addr, isVolatile, /*Align=*/ 0, InsertBefore)
    //START JInit
    this(val, addr, isVolatile, 0, InsertBefore);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::StoreInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1451,
   FQN="llvm::StoreInst::StoreInst", NM="_ZN4llvm9StoreInstC1EPNS_5ValueES2_bPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInstC1EPNS_5ValueES2_bPNS_10BasicBlockE")
  //</editor-fold>
  public StoreInst(Value /*P*/ val, Value /*P*/ addr, boolean isVolatile,
      BasicBlock /*P*/ InsertAtEnd) {
    // : StoreInst(val, addr, isVolatile, /*Align=*/ 0, InsertAtEnd)
    //START JInit
    this(val, addr, isVolatile, 0, InsertAtEnd);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::StoreInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1455,
   FQN="llvm::StoreInst::StoreInst", NM="_ZN4llvm9StoreInstC1EPNS_5ValueES2_bjPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInstC1EPNS_5ValueES2_bjPNS_11InstructionE")
  //</editor-fold>
  public StoreInst(Value /*P*/ val, Value /*P*/ addr, boolean isVolatile, /*uint*/int Align) {
    this(val, addr, isVolatile, Align,
      (Instruction /*P*/ )null);
  }
  public StoreInst(Value /*P*/ val, Value /*P*/ addr, boolean isVolatile, /*uint*/int Align,
      Instruction /*P*/ InsertBefore/*= null*/) {
    // : StoreInst(val, addr, isVolatile, Align, AtomicOrdering::NotAtomic, CrossThread, InsertBefore)
    //START JInit
    this(val, addr, isVolatile, Align, AtomicOrdering.NotAtomic,
        SynchronizationScope.CrossThread, InsertBefore);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::StoreInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1460,
   FQN="llvm::StoreInst::StoreInst", NM="_ZN4llvm9StoreInstC1EPNS_5ValueES2_bjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInstC1EPNS_5ValueES2_bjPNS_10BasicBlockE")
  //</editor-fold>
  public StoreInst(Value /*P*/ val, Value /*P*/ addr, boolean isVolatile, /*uint*/int Align,
      BasicBlock /*P*/ InsertAtEnd) {
    // : StoreInst(val, addr, isVolatile, Align, AtomicOrdering::NotAtomic, CrossThread, InsertAtEnd)
    //START JInit
    this(val, addr, isVolatile, Align, AtomicOrdering.NotAtomic,
        SynchronizationScope.CrossThread, InsertAtEnd);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::StoreInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1465,
   FQN="llvm::StoreInst::StoreInst", NM="_ZN4llvm9StoreInstC1EPNS_5ValueES2_bjNS_14AtomicOrderingENS_20SynchronizationScopeEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInstC1EPNS_5ValueES2_bjNS_14AtomicOrderingENS_20SynchronizationScopeEPNS_11InstructionE")
  //</editor-fold>
  public StoreInst(Value /*P*/ val, Value /*P*/ addr, boolean isVolatile,
      /*uint*/int Align, AtomicOrdering Order) {
    this(val, addr, isVolatile,
      Align, Order,
      SynchronizationScope.CrossThread,
      (Instruction /*P*/ )null);
  }
  public StoreInst(Value /*P*/ val, Value /*P*/ addr, boolean isVolatile,
      /*uint*/int Align, AtomicOrdering Order,
      SynchronizationScope SynchScope/*= CrossThread*/) {
    this(val, addr, isVolatile,
      Align, Order,
      SynchScope,
      (Instruction /*P*/ )null);
  }
  public StoreInst(Value /*P*/ val, Value /*P*/ addr, boolean isVolatile,
      /*uint*/int Align, AtomicOrdering Order,
      SynchronizationScope SynchScope/*= CrossThread*/,
      Instruction /*P*/ InsertBefore/*= null*/) {
    // : Instruction(Type::getVoidTy(val->getContext()), Store, OperandTraits<StoreInst>::op_begin(this), OperandTraits<StoreInst>::operands(this), InsertBefore)
    //START JInit
    super(Type.getVoidTy(val.getContext()), MemoryOps.Store,
        OperandTraitsStoreInst.op_begin(User.$BEING_CREATED()),
        OperandTraitsStoreInst.operands$FixedNumOperandTraits(User.$BEING_CREATED()),
        InsertBefore);
    //END JInit
    this./*<0>*/Op(0).$assign(val);
    this./*<1>*/Op(1).$assign(addr);
    setVolatile(isVolatile);
    setAlignment(Align);
    setAtomic(Order, SynchScope);
    AssertOK();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::StoreInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1481,
   FQN="llvm::StoreInst::StoreInst", NM="_ZN4llvm9StoreInstC1EPNS_5ValueES2_bjNS_14AtomicOrderingENS_20SynchronizationScopeEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInstC1EPNS_5ValueES2_bjNS_14AtomicOrderingENS_20SynchronizationScopeEPNS_10BasicBlockE")
  //</editor-fold>
  public StoreInst(Value /*P*/ val, Value /*P*/ addr, boolean isVolatile,
      /*uint*/int Align, AtomicOrdering Order,
      SynchronizationScope SynchScope,
      BasicBlock /*P*/ InsertAtEnd) {
    // : Instruction(Type::getVoidTy(val->getContext()), Store, OperandTraits<StoreInst>::op_begin(this), OperandTraits<StoreInst>::operands(this), InsertAtEnd)
    //START JInit
    super(Type.getVoidTy(val.getContext()), MemoryOps.Store,
        OperandTraitsStoreInst.op_begin(User.$BEING_CREATED()),
        OperandTraitsStoreInst.operands$FixedNumOperandTraits(User.$BEING_CREATED()),
        InsertAtEnd);
    //END JInit
    this./*<0>*/Op(0).$assign(val);
    this./*<1>*/Op(1).$assign(addr);
    setVolatile(isVolatile);
    setAlignment(Align);
    setAtomic(Order, SynchScope);
    AssertOK();
  }


  /// isVolatile - Return true if this is a store to a volatile memory
  /// location.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::isVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 340,
   FQN="llvm::StoreInst::isVolatile", NM="_ZNK4llvm9StoreInst10isVolatileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm9StoreInst10isVolatileEv")
  //</editor-fold>
  public boolean isVolatile() /*const*/ {
    return ((getSubclassDataFromInstruction() & 1) != 0);
  }


  /// setVolatile - Specify whether this is a volatile store or not.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::setVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 344,
   FQN="llvm::StoreInst::setVolatile", NM="_ZN4llvm9StoreInst11setVolatileEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInst11setVolatileEb")
  //</editor-fold>
  public void setVolatile(boolean V) {
    setInstructionSubclassData($uint2ushort((getSubclassDataFromInstruction() & ~1)
           | (V ? 1 : 0)));
  }


  /// Transparently provide more efficient getOperand methods.
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 429,
   FQN="llvm::StoreInst::getOperand", NM="_ZNK4llvm9StoreInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm9StoreInst10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsStoreInst.operands$FixedNumOperandTraits(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsStoreInst.op_begin(((/*const_cast*/StoreInst /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 429,
   FQN="llvm::StoreInst::setOperand", NM="_ZN4llvm9StoreInst10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInst10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsStoreInst.operands$FixedNumOperandTraits(this))) : "setOperand() out of range!";
    OperandTraitsStoreInst.op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 429,
   FQN="llvm::StoreInst::op_begin", NM="_ZN4llvm9StoreInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInst8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsStoreInst.op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 429,
   FQN="llvm::StoreInst::op_begin", NM="_ZNK4llvm9StoreInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm9StoreInst8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsStoreInst.op_begin(((/*const_cast*/StoreInst /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 429,
   FQN="llvm::StoreInst::op_end", NM="_ZN4llvm9StoreInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInst6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsStoreInst.op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 429,
   FQN="llvm::StoreInst::op_end", NM="_ZNK4llvm9StoreInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm9StoreInst6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsStoreInst.op_end(((/*const_cast*/StoreInst /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 429,
   FQN="llvm::StoreInst::Op", NM="Tpl__ZN4llvm9StoreInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm9StoreInst2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 429,
   FQN="llvm::StoreInst::Op", NM="Tpl__ZNK4llvm9StoreInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm9StoreInst2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 429,
   FQN="llvm::StoreInst::getNumOperands", NM="_ZNK4llvm9StoreInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm9StoreInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsStoreInst.operands$FixedNumOperandTraits(this);
  }


  /// getAlignment - Return the alignment of the access that is being performed
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 354,
   FQN="llvm::StoreInst::getAlignment", NM="_ZNK4llvm9StoreInst12getAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm9StoreInst12getAlignmentEv")
  //</editor-fold>
  public /*uint*/int getAlignment() /*const*/ {
    return (1 << ((getSubclassDataFromInstruction() >>> 1) & 31)) >> 1;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::setAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1497,
   FQN="llvm::StoreInst::setAlignment", NM="_ZN4llvm9StoreInst12setAlignmentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInst12setAlignmentEj")
  //</editor-fold>
  public void setAlignment(/*uint*/int Align) {
    assert ((Align & (Align - 1)) == 0) : "Alignment is not a power of 2!";
    assert ($lesseq_uint(Align, Value.MaximumAlignment)) : "Alignment is greater than MaximumAlignment!";
    setInstructionSubclassData($uint2ushort((getSubclassDataFromInstruction() & ~(31 << 1))
           | ((Log2_32(Align) + 1) << 1)));
    assert (getAlignment() == Align) : "Alignment representation error!";
  }


  /// Returns the ordering effect of this store.
  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::getOrdering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 361,
   FQN="llvm::StoreInst::getOrdering", NM="_ZNK4llvm9StoreInst11getOrderingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm9StoreInst11getOrderingEv")
  //</editor-fold>
  public AtomicOrdering getOrdering() /*const*/ {
    return AtomicOrdering.valueOf((getSubclassDataFromInstruction() >>> 7) & 7);
  }


  /// Set the ordering constraint on this store.  May not be Acquire or
  /// AcquireRelease.
  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::setOrdering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 367,
   FQN="llvm::StoreInst::setOrdering", NM="_ZN4llvm9StoreInst11setOrderingENS_14AtomicOrderingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInst11setOrderingENS_14AtomicOrderingE")
  //</editor-fold>
  public void setOrdering(AtomicOrdering Ordering) {
    setInstructionSubclassData($uint2ushort((getSubclassDataFromInstruction() & ~(7 << 7))
           | (((/*uint*/int)Ordering.getValue()) << 7)));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::getSynchScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 372,
   FQN="llvm::StoreInst::getSynchScope", NM="_ZNK4llvm9StoreInst13getSynchScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm9StoreInst13getSynchScopeEv")
  //</editor-fold>
  public SynchronizationScope getSynchScope() /*const*/ {
    return SynchronizationScope.valueOf((getSubclassDataFromInstruction() >>> 6) & 1);
  }


  /// Specify whether this store instruction is ordered with respect to all
  /// concurrently executing threads, or only with respect to signal handlers
  /// executing in the same thread.
  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::setSynchScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 379,
   FQN="llvm::StoreInst::setSynchScope", NM="_ZN4llvm9StoreInst13setSynchScopeENS_20SynchronizationScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInst13setSynchScopeENS_20SynchronizationScopeE")
  //</editor-fold>
  public void setSynchScope(SynchronizationScope xthread) {
    setInstructionSubclassData($uint2ushort((getSubclassDataFromInstruction() & ~(1 << 6))
           | (xthread.getValue() << 6)));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::setAtomic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 384,
   FQN="llvm::StoreInst::setAtomic", NM="_ZN4llvm9StoreInst9setAtomicENS_14AtomicOrderingENS_20SynchronizationScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInst9setAtomicENS_14AtomicOrderingENS_20SynchronizationScopeE")
  //</editor-fold>
  public void setAtomic(AtomicOrdering Ordering) {
    setAtomic(Ordering,
           SynchronizationScope.CrossThread);
  }
  public void setAtomic(AtomicOrdering Ordering,
           SynchronizationScope SynchScope/*= CrossThread*/) {
    setOrdering(Ordering);
    setSynchScope(SynchScope);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::isSimple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 390,
   FQN="llvm::StoreInst::isSimple", NM="_ZNK4llvm9StoreInst8isSimpleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm9StoreInst8isSimpleEv")
  //</editor-fold>
  public boolean isSimple() /*const*/ {
    return !isAtomic() && !isVolatile();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::isUnordered">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 391,
   FQN="llvm::StoreInst::isUnordered", NM="_ZNK4llvm9StoreInst11isUnorderedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm9StoreInst11isUnorderedEv")
  //</editor-fold>
  public boolean isUnordered() /*const*/ {
    return (getOrdering() == AtomicOrdering.NotAtomic
       || getOrdering() == AtomicOrdering.Unordered)
       && !isVolatile();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::getValueOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 397,
   FQN="llvm::StoreInst::getValueOperand", NM="_ZN4llvm9StoreInst15getValueOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInst15getValueOperandEv")
  //</editor-fold>
  public Value /*P*/ getValueOperand() {
    return getOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::getValueOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 398,
   FQN="llvm::StoreInst::getValueOperand", NM="_ZNK4llvm9StoreInst15getValueOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm9StoreInst15getValueOperandEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getValueOperand$Const() /*const*/ {
    return getOperand(0);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::getPointerOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 400,
   FQN="llvm::StoreInst::getPointerOperand", NM="_ZN4llvm9StoreInst17getPointerOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInst17getPointerOperandEv")
  //</editor-fold>
  public Value /*P*/ getPointerOperand() {
    return getOperand(1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::getPointerOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 401,
   FQN="llvm::StoreInst::getPointerOperand", NM="_ZNK4llvm9StoreInst17getPointerOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm9StoreInst17getPointerOperandEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getPointerOperand$Const() /*const*/ {
    return getOperand(1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::getPointerOperandIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 402,
   FQN="llvm::StoreInst::getPointerOperandIndex", NM="_ZN4llvm9StoreInst22getPointerOperandIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInst22getPointerOperandIndexEv")
  //</editor-fold>
  public static /*uint*/int getPointerOperandIndex() {
    return 1/*U*/;
  }


  /// \brief Returns the address space of the pointer operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::getPointerAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 405,
   FQN="llvm::StoreInst::getPointerAddressSpace", NM="_ZNK4llvm9StoreInst22getPointerAddressSpaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm9StoreInst22getPointerAddressSpaceEv")
  //</editor-fold>
  public /*uint*/int getPointerAddressSpace() /*const*/ {
    return getPointerOperand$Const().getType().getPointerAddressSpace();
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 410,
   FQN="llvm::StoreInst::classof", NM="_ZN4llvm9StoreInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.MemoryOps.Store;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 413,
   FQN="llvm::StoreInst::classof", NM="_ZN4llvm9StoreInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && StoreInst.classof(cast_Instruction(V));
  }

/*private:*/
  // Shadow Instruction::setInstructionSubclassData with a private forwarding
  // method so that subclasses cannot accidentally use it.
  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::setInstructionSubclassData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 420,
   FQN="llvm::StoreInst::setInstructionSubclassData", NM="_ZN4llvm9StoreInst26setInstructionSubclassDataEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInst26setInstructionSubclassDataEt")
  //</editor-fold>
  /*shadow*/protected/*private*/ void setInstructionSubclassData(/*ushort*/char D) {
    super.setInstructionSubclassData(D);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StoreInst::~StoreInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 305,
   FQN="llvm::StoreInst::~StoreInst", NM="_ZN4llvm9StoreInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9StoreInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
