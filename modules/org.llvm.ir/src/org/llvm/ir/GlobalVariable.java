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
import org.llvm.adt.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.ir.java.*;

//<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 34,
 FQN="llvm::GlobalVariable", NM="_ZN4llvm14GlobalVariableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm14GlobalVariableE")
//</editor-fold>
public class GlobalVariable extends /*public*/ GlobalObject implements /*public*/ ilist_node<GlobalVariable>, IChild<Module>, Destructors.ClassWithDestructor {
  /*friend  class SymbolTableListTraits<GlobalVariable>*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 36,
   FQN="llvm::GlobalVariable::operator new", NM="_ZN4llvm14GlobalVariablenwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm14GlobalVariablenwEjj")
  //</editor-fold>
  protected/*private*/ static Object/*void P*/ $new(/*size_t*/int $Prm0, /*uint*/int $Prm1) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 37,
   FQN="llvm::GlobalVariable::operator=", NM="_ZN4llvm14GlobalVariableaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm14GlobalVariableaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ GlobalVariable /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::GlobalVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 38,
   FQN="llvm::GlobalVariable::GlobalVariable", NM="_ZN4llvm14GlobalVariableC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm14GlobalVariableC1ERKS0_")
  //</editor-fold>
  protected/*private*/ GlobalVariable(final /*const*/ GlobalVariable /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}


  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::setParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 260,
   FQN="llvm::GlobalVariable::setParent", NM="_ZN4llvm14GlobalVariable9setParentEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm14GlobalVariable9setParentEPNS_6ModuleE")
  //</editor-fold>
  public /*friend*//*private*/ void setParent(Module /*P*/ parent) {
    Parent = parent;
  }


  private /*JBIT bool*/ boolean isConstantGlobal /*: 1*/; // Is this a global constant?
  private /*JBIT bool*/ boolean isExternallyInitializedConstant /*: 1*/; // Is this a global whose value
  // can change from its initial
  // value before global
  // initializers are run?
/*public:*/
  // allocate space for exactly one operand
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::operator new">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 49,
   FQN="llvm::GlobalVariable::operator new", NM="_ZN4llvm14GlobalVariablenwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm14GlobalVariablenwEj")
  //</editor-fold>
  public static <T extends GlobalVariable> T/*void P*/ $new_GlobalVariable(New$ConstructorCallback<T> $Ctor) {
    return User.$new_FixedUses(/*s, */1, $Ctor);
  }


  /// GlobalVariable ctor - If a parent module is specified, the global is
  /// automatically inserted into the end of the specified modules global list.

  //===----------------------------------------------------------------------===//
  // GlobalVariable Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::GlobalVariable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 220,
   FQN="llvm::GlobalVariable::GlobalVariable", NM="_ZN4llvm14GlobalVariableC1EPNS_4TypeEbNS_11GlobalValue12LinkageTypesEPNS_8ConstantERKNS_5TwineENS3_15ThreadLocalModeEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm14GlobalVariableC1EPNS_4TypeEbNS_11GlobalValue12LinkageTypesEPNS_8ConstantERKNS_5TwineENS3_15ThreadLocalModeEjb")
  //</editor-fold>
  public GlobalVariable(Type /*P*/ Ty, boolean constant, GlobalValue.LinkageTypes Link) {
    this(Ty, constant, Link,
      (Constant /*P*/ )null, new Twine(/*KEEP_STR*/$EMPTY),
      ThreadLocalMode.NotThreadLocal, 0,
      false);
  }
  public GlobalVariable(Type /*P*/ Ty, boolean constant, GlobalValue.LinkageTypes Link,
      Constant /*P*/ InitVal/*= null*/) {
    this(Ty, constant, Link,
      InitVal, new Twine(/*KEEP_STR*/$EMPTY),
      ThreadLocalMode.NotThreadLocal, 0,
      false);
  }
  public GlobalVariable(Type /*P*/ Ty, boolean constant, GlobalValue.LinkageTypes Link,
      Constant /*P*/ InitVal/*= null*/, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    this(Ty, constant, Link,
      InitVal, Name,
      ThreadLocalMode.NotThreadLocal, 0,
      false);
  }
  public GlobalVariable(Type /*P*/ Ty, boolean constant, GlobalValue.LinkageTypes Link,
      Constant /*P*/ InitVal/*= null*/, final /*const*/ Twine /*&*/ Name/*= ""*/,
      GlobalValue.ThreadLocalMode TLMode/*= NotThreadLocal*/) {
    this(Ty, constant, Link,
      InitVal, Name,
      TLMode, 0,
      false);
  }
  public GlobalVariable(Type /*P*/ Ty, boolean constant, GlobalValue.LinkageTypes Link,
      Constant /*P*/ InitVal/*= null*/, final /*const*/ Twine /*&*/ Name/*= ""*/,
      GlobalValue.ThreadLocalMode TLMode/*= NotThreadLocal*/, /*uint*/int AddressSpace/*= 0*/) {
    this(Ty, constant, Link,
      InitVal, Name,
      TLMode, AddressSpace,
      false);
  }
  public GlobalVariable(Type /*P*/ Ty, boolean constant, GlobalValue.LinkageTypes Link,
      Constant /*P*/ InitVal/*= null*/, final /*const*/ Twine /*&*/ Name/*= ""*/,
      GlobalValue.ThreadLocalMode TLMode/*= NotThreadLocal*/, /*uint*/int AddressSpace/*= 0*/,
      boolean isExternallyInitialized/*= false*/) {
    // : GlobalObject(Ty, Value::GlobalVariableVal, OperandTraits<GlobalVariable>::op_begin(this), InitVal != null, Link, Name, AddressSpace), ilist_node<GlobalVariable>(), isConstantGlobal(constant), isExternallyInitializedConstant(isExternallyInitialized)
    //START JInit
    super(Ty, Value.ValueTy.GlobalVariableVal,
        OperandTraitsGlobalVariable.<GlobalVariable>op_begin(User.$BEING_CREATED()),
        ((InitVal != (Constant /*P*/ )null) ? 1 : 0), Link, Name, AddressSpace);
    this.ilist_node$Flds = $ilist_node();
    this.isConstantGlobal = constant;
    this.isExternallyInitializedConstant = isExternallyInitialized;
    //END JInit
    setThreadLocalMode(TLMode);
    if ((InitVal != null)) {
      assert (InitVal.getType() == Ty) : "Initializer should be the same type as the GlobalVariable!";
      this./*<0>*/Op(0).$assign(InitVal);
    }
  }

  /// GlobalVariable ctor - This creates a global and inserts it before the
  /// specified other global.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::GlobalVariable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 237,
   FQN="llvm::GlobalVariable::GlobalVariable", NM="_ZN4llvm14GlobalVariableC1ERNS_6ModuleEPNS_4TypeEbNS_11GlobalValue12LinkageTypesEPNS_8ConstantERKNS_5TwineEPS0_NS5_15ThreadLocalModeEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm14GlobalVariableC1ERNS_6ModuleEPNS_4TypeEbNS_11GlobalValue12LinkageTypesEPNS_8ConstantERKNS_5TwineEPS0_NS5_15ThreadLocalModeEjb")
  //</editor-fold>
  public GlobalVariable(final Module /*&*/ M, Type /*P*/ Ty, boolean constant,
      GlobalValue.LinkageTypes Link, Constant /*P*/ InitVal) {
    this(M, Ty, constant,
      Link, InitVal,
      new Twine(/*KEEP_STR*/$EMPTY), (GlobalVariable /*P*/ )null,
      ThreadLocalMode.NotThreadLocal, 0,
      false);
  }
  public GlobalVariable(final Module /*&*/ M, Type /*P*/ Ty, boolean constant,
      GlobalValue.LinkageTypes Link, Constant /*P*/ InitVal,
      final /*const*/ Twine /*&*/ Name/*= ""*/) {
    this(M, Ty, constant,
      Link, InitVal,
      Name, (GlobalVariable /*P*/ )null,
      ThreadLocalMode.NotThreadLocal, 0,
      false);
  }
  public GlobalVariable(final Module /*&*/ M, Type /*P*/ Ty, boolean constant,
      GlobalValue.LinkageTypes Link, Constant /*P*/ InitVal,
      final /*const*/ Twine /*&*/ Name/*= ""*/, GlobalVariable /*P*/ Before/*= null*/) {
    this(M, Ty, constant,
      Link, InitVal,
      Name, Before,
      ThreadLocalMode.NotThreadLocal, 0,
      false);
  }
  public GlobalVariable(final Module /*&*/ M, Type /*P*/ Ty, boolean constant,
      GlobalValue.LinkageTypes Link, Constant /*P*/ InitVal,
      final /*const*/ Twine /*&*/ Name/*= ""*/, GlobalVariable /*P*/ Before/*= null*/,
      GlobalValue.ThreadLocalMode TLMode/*= NotThreadLocal*/) {
    this(M, Ty, constant,
      Link, InitVal,
      Name, Before,
      TLMode, 0,
      false);
  }
  public GlobalVariable(final Module /*&*/ M, Type /*P*/ Ty, boolean constant,
      GlobalValue.LinkageTypes Link, Constant /*P*/ InitVal,
      final /*const*/ Twine /*&*/ Name/*= ""*/, GlobalVariable /*P*/ Before/*= null*/,
      GlobalValue.ThreadLocalMode TLMode/*= NotThreadLocal*/, /*uint*/int AddressSpace/*= 0*/) {
    this(M, Ty, constant,
      Link, InitVal,
      Name, Before,
      TLMode, AddressSpace,
      false);
  }
  public GlobalVariable(final Module /*&*/ M, Type /*P*/ Ty, boolean constant,
      GlobalValue.LinkageTypes Link, Constant /*P*/ InitVal,
      final /*const*/ Twine /*&*/ Name/*= ""*/, GlobalVariable /*P*/ Before/*= null*/,
      GlobalValue.ThreadLocalMode TLMode/*= NotThreadLocal*/, /*uint*/int AddressSpace/*= 0*/,
      boolean isExternallyInitialized/*= false*/) {
    // : GlobalObject(Ty, Value::GlobalVariableVal, OperandTraits<GlobalVariable>::op_begin(this), InitVal != null, Link, Name, AddressSpace), ilist_node<GlobalVariable>(), isConstantGlobal(constant), isExternallyInitializedConstant(isExternallyInitialized)
    //START JInit
    super(Ty, Value.ValueTy.GlobalVariableVal,
        OperandTraitsGlobalVariable.<GlobalVariable>op_begin(User.$BEING_CREATED()),
        ((InitVal != (Constant /*P*/ )null) ? 1 : 0), Link, Name, AddressSpace);
    this.ilist_node$Flds = $ilist_node();
    this.isConstantGlobal = constant;
    this.isExternallyInitializedConstant = isExternallyInitialized;
    //END JInit
    setThreadLocalMode(TLMode);
    if ((InitVal != null)) {
      assert (InitVal.getType() == Ty) : "Initializer should be the same type as the GlobalVariable!";
      this./*<0>*/Op(0).$assign(InitVal);
    }
    if ((Before != null)) {
      Before.getParent().getGlobalList().insert_ilist_iterator$NodeTy_T$P(Before.getIterator(), this);
    } else {
      M.getGlobalList().push_back(this);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::~GlobalVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 67,
   FQN="llvm::GlobalVariable::~GlobalVariable", NM="_ZN4llvm14GlobalVariableD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm14GlobalVariableD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    dropAllReferences();

    // FIXME: needed by operator delete
    setGlobalVariableNumOperands(1);
    super.$destroy();
    ilist_node.super.$destroy$ilist_node();
  }


  /// Provide fast operand accessors
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 179,
   FQN="llvm::GlobalVariable::getOperand", NM="_ZNK4llvm14GlobalVariable10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm14GlobalVariable10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsGlobalVariable.<GlobalVariable>operands$OptionalOperandTraits(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsGlobalVariable.<GlobalVariable>op_begin(((/*const_cast*/GlobalVariable /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 179,
   FQN="llvm::GlobalVariable::setOperand", NM="_ZN4llvm14GlobalVariable10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm14GlobalVariable10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsGlobalVariable.<GlobalVariable>operands$FixedNumOperandTraits(this))) : "setOperand() out of range!";
    OperandTraitsGlobalVariable.<GlobalVariable>op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 179,
   FQN="llvm::GlobalVariable::op_begin", NM="_ZN4llvm14GlobalVariable8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm14GlobalVariable8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsGlobalVariable.<GlobalVariable>op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 179,
   FQN="llvm::GlobalVariable::op_begin", NM="_ZNK4llvm14GlobalVariable8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm14GlobalVariable8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsGlobalVariable.<GlobalVariable>op_begin(((/*const_cast*/GlobalVariable /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 179,
   FQN="llvm::GlobalVariable::op_end", NM="_ZN4llvm14GlobalVariable6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm14GlobalVariable6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsGlobalVariable.<GlobalVariable>op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 179,
   FQN="llvm::GlobalVariable::op_end", NM="_ZNK4llvm14GlobalVariable6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm14GlobalVariable6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsGlobalVariable.<GlobalVariable>op_end(((/*const_cast*/GlobalVariable /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 179,
   FQN="llvm::GlobalVariable::Op", NM="Tpl__ZN4llvm14GlobalVariable2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=Tpl__ZN4llvm14GlobalVariable2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this.OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 179,
   FQN="llvm::GlobalVariable::Op", NM="Tpl__ZNK4llvm14GlobalVariable2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=Tpl__ZNK4llvm14GlobalVariable2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this.OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 179,
   FQN="llvm::GlobalVariable::getNumOperands", NM="_ZNK4llvm14GlobalVariable14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm14GlobalVariable14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsGlobalVariable.<GlobalVariable>operands$OptionalOperandTraits(this);
  }


  /// Definitions have initializers, declarations don't.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::hasInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 79,
   FQN="llvm::GlobalVariable::hasInitializer", NM="_ZNK4llvm14GlobalVariable14hasInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm14GlobalVariable14hasInitializerEv")
  //</editor-fold>
  public /*inline*/ boolean hasInitializer() /*const*/ {
    return !isDeclaration();
  }


  /// hasDefinitiveInitializer - Whether the global variable has an initializer,
  /// and any other instances of the global (this can happen due to weak
  /// linkage) are guaranteed to have the same initializer.
  ///
  /// Note that if you want to transform a global, you must use
  /// hasUniqueInitializer() instead, because of the *_odr linkage type.
  ///
  /// Example:
  ///
  /// @a = global SomeType* null - Initializer is both definitive and unique.
  ///
  /// @b = global weak SomeType* null - Initializer is neither definitive nor
  /// unique.
  ///
  /// @c = global weak_odr SomeType* null - Initializer is definitive, but not
  /// unique.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::hasDefinitiveInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 97,
   FQN="llvm::GlobalVariable::hasDefinitiveInitializer", NM="_ZNK4llvm14GlobalVariable24hasDefinitiveInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm14GlobalVariable24hasDefinitiveInitializerEv")
  //</editor-fold>
  public /*inline*/ boolean hasDefinitiveInitializer() /*const*/ {
    return hasInitializer()
      // The initializer of a global variable may change to something arbitrary
      // at link time.
       && !isInterposable()
      // The initializer of a global variable with the externally_initialized
      // marker may change at runtime before C++ initializers are evaluated.
       && !isExternallyInitialized();
  }


  /// hasUniqueInitializer - Whether the global variable has an initializer, and
  /// any changes made to the initializer will turn up in the final executable.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::hasUniqueInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 109,
   FQN="llvm::GlobalVariable::hasUniqueInitializer", NM="_ZNK4llvm14GlobalVariable20hasUniqueInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm14GlobalVariable20hasUniqueInitializerEv")
  //</editor-fold>
  public /*inline*/ boolean hasUniqueInitializer() /*const*/ {
    return // We need to be sure this is the definition that will actually be used
        isStrongDefinitionForLinker()
      // It is not safe to modify initializers of global variables with the
      // external_initializer marker since the value may be changed at runtime
      // before C++ initializers are evaluated.
       && !isExternallyInitialized();
  }


  /// getInitializer - Return the initializer for this global variable.  It is
  /// illegal to call this method if the global is external, because we cannot
  /// tell what the value is initialized to!
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::getInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 123,
   FQN="llvm::GlobalVariable::getInitializer", NM="_ZNK4llvm14GlobalVariable14getInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm14GlobalVariable14getInitializerEv")
  //</editor-fold>
  public /*inline*/ /*const*/ Constant /*P*/ getInitializer$Const() /*const*/ {
    assert (hasInitializer()) : "GV doesn't have initializer!";
    return ((/*static_cast*/Constant /*P*/ )(this./*<0>*/Op$Const(0).get()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::getInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 127,
   FQN="llvm::GlobalVariable::getInitializer", NM="_ZN4llvm14GlobalVariable14getInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm14GlobalVariable14getInitializerEv")
  //</editor-fold>
  public /*inline*/ Constant /*P*/ getInitializer() {
    assert (hasInitializer()) : "GV doesn't have initializer!";
    return ((/*static_cast*/Constant /*P*/ )(this./*<0>*/Op(0).get()));
  }

  /// setInitializer - Sets the initializer for this global variable, removing
  /// any existing initializer if InitVal==NULL.  If this GV has type T*, the
  /// initializer must have type T.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::setInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 272,
   FQN="llvm::GlobalVariable::setInitializer", NM="_ZN4llvm14GlobalVariable14setInitializerEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm14GlobalVariable14setInitializerEPNS_8ConstantE")
  //</editor-fold>
  public void setInitializer(Constant /*P*/ InitVal) {
    if (!(InitVal != null)) {
      if (hasInitializer()) {
        // Note, the num operands is used to compute the offset of the operand, so
        // the order here matters.  Clearing the operand then clearing the num
        // operands ensures we have the correct offset to the operand.
        this./*<0>*/Op(0).set((Value /*P*/ )null);
        setGlobalVariableNumOperands(0);
      }
    } else {
      assert (InitVal.getType() == getValueType()) : "Initializer type must match GlobalVariable type";
      // Note, the num operands is used to compute the offset of the operand, so
      // the order here matters.  We need to set num operands to 1 first so that
      // we get the correct offset to the first operand when we set it.
      if (!hasInitializer()) {
        setGlobalVariableNumOperands(1);
      }
      this./*<0>*/Op(0).set(InitVal);
    }
  }


  /// If the value is a global constant, its value is immutable throughout the
  /// runtime execution of the program.  Assigning a value into the constant
  /// leads to undefined behavior.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::isConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 140,
   FQN="llvm::GlobalVariable::isConstant", NM="_ZNK4llvm14GlobalVariable10isConstantEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm14GlobalVariable10isConstantEv")
  //</editor-fold>
  public boolean isConstant() /*const*/ {
    return isConstantGlobal;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::setConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 141,
   FQN="llvm::GlobalVariable::setConstant", NM="_ZN4llvm14GlobalVariable11setConstantEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm14GlobalVariable11setConstantEb")
  //</editor-fold>
  public void setConstant(boolean Val) {
    isConstantGlobal = Val;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::isExternallyInitialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 143,
   FQN="llvm::GlobalVariable::isExternallyInitialized", NM="_ZNK4llvm14GlobalVariable23isExternallyInitializedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm14GlobalVariable23isExternallyInitializedEv")
  //</editor-fold>
  public boolean isExternallyInitialized() /*const*/ {
    return isExternallyInitializedConstant;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::setExternallyInitialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 146,
   FQN="llvm::GlobalVariable::setExternallyInitialized", NM="_ZN4llvm14GlobalVariable24setExternallyInitializedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm14GlobalVariable24setExternallyInitializedEb")
  //</editor-fold>
  public void setExternallyInitialized(boolean Val) {
    isExternallyInitializedConstant = Val;
  }


  /// copyAttributesFrom - copy all additional attributes (those not needed to
  /// create a GlobalVariable) from the GlobalVariable Src to this one.

  /// Copy all additional attributes (those not needed to create a GlobalVariable)
  /// from the GlobalVariable Src to this one.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::copyAttributesFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 295,
   FQN="llvm::GlobalVariable::copyAttributesFrom", NM="_ZN4llvm14GlobalVariable18copyAttributesFromEPKNS_11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm14GlobalVariable18copyAttributesFromEPKNS_11GlobalValueE")
  //</editor-fold>
  @Override public void copyAttributesFrom(/*const*/ GlobalValue /*P*/ Src)/* override*/ {
    super.copyAttributesFrom(Src);
    {
      /*const*/ GlobalVariable /*P*/ SrcVar = dyn_cast_GlobalVariable(Src);
      if ((SrcVar != null)) {
        setThreadLocalMode(SrcVar.getThreadLocalMode());
        setExternallyInitialized(SrcVar.isExternallyInitialized());
      }
    }
  }


  /// removeFromParent - This method unlinks 'this' from the containing module,
  /// but does not delete it.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::removeFromParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 264,
   FQN="llvm::GlobalVariable::removeFromParent", NM="_ZN4llvm14GlobalVariable16removeFromParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm14GlobalVariable16removeFromParentEv")
  //</editor-fold>
  @Override public void removeFromParent()/* override*/ {
    getParent().getGlobalList().remove_ilist_iterator$NodeTy$C(getIterator());
  }


  /// eraseFromParent - This method unlinks 'this' from the containing module
  /// and deletes it.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::eraseFromParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 268,
   FQN="llvm::GlobalVariable::eraseFromParent", NM="_ZN4llvm14GlobalVariable15eraseFromParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm14GlobalVariable15eraseFromParentEv")
  //</editor-fold>
  @Override public void eraseFromParent()/* override*/ {
    getParent().getGlobalList().erase(getIterator());
  }


  /// Drop all references in preparation to destroy the GlobalVariable. This
  /// drops not only the reference to the initializer but also to any metadata.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::dropAllReferences">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 303,
   FQN="llvm::GlobalVariable::dropAllReferences", NM="_ZN4llvm14GlobalVariable17dropAllReferencesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm14GlobalVariable17dropAllReferencesEv")
  //</editor-fold>
  public void dropAllReferences() {
    super.dropAllReferences();
    clearMetadata();
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalVariable::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalVariable.h", line = 169,
   FQN="llvm::GlobalVariable::classof", NM="_ZN4llvm14GlobalVariable7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm14GlobalVariable7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == Value.ValueTy.GlobalVariableVal.getValue();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private GlobalVariable() {
    this.ilist_node$Flds = $ilist_node();
  }

  public static GlobalVariable $CreateSentinel() {
    return User.<GlobalVariable>$new_FixedUses(0, (type$ptr<?> New$Mem)-> new GlobalVariable());
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  private final ilist_node$Fields ilist_node$Flds;// use return value of $ilist_node();
  @Override public final ilist_node$Fields $ilist_node$Fields() { return ilist_node$Flds; }

  @Override public String toString() {
    if ($isSentinel()) {
      return "Sentinel " + this.getClass().getSimpleName();
    }    
    return "" + "isConstantGlobal=" + isConstantGlobal // NOI18N
              + ", isExternallyInitializedConstant=" + isExternallyInitializedConstant // NOI18N
              + super.toString(); // NOI18N
  }
}
