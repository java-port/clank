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
import org.llvm.adt.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;

//<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIndirectSymbol.h", line = 24,
 FQN="llvm::GlobalIndirectSymbol", NM="_ZN4llvm20GlobalIndirectSymbolE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm20GlobalIndirectSymbolE")
//</editor-fold>
public abstract class GlobalIndirectSymbol extends /*public*/ GlobalValue implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIndirectSymbol.h", line = 25,
   FQN="llvm::GlobalIndirectSymbol::operator=", NM="_ZN4llvm20GlobalIndirectSymbolaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm20GlobalIndirectSymbolaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ GlobalIndirectSymbol /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol::GlobalIndirectSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIndirectSymbol.h", line = 26,
   FQN="llvm::GlobalIndirectSymbol::GlobalIndirectSymbol", NM="_ZN4llvm20GlobalIndirectSymbolC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm20GlobalIndirectSymbolC1ERKS0_")
  //</editor-fold>
  protected/*private*/ GlobalIndirectSymbol(final /*const*/ GlobalIndirectSymbol /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

/*protected:*/

  //===----------------------------------------------------------------------===//
  // GlobalIndirectSymbol Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol::GlobalIndirectSymbol">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 312,
   FQN="llvm::GlobalIndirectSymbol::GlobalIndirectSymbol", NM="_ZN4llvm20GlobalIndirectSymbolC1EPNS_4TypeENS_5Value7ValueTyEjNS_11GlobalValue12LinkageTypesERKNS_5TwineEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm20GlobalIndirectSymbolC1EPNS_4TypeENS_5Value7ValueTyEjNS_11GlobalValue12LinkageTypesERKNS_5TwineEPNS_8ConstantE")
  //</editor-fold>
  protected GlobalIndirectSymbol(Type /*P*/ Ty, Value.ValueTy VTy,
      /*uint*/int AddressSpace, GlobalValue.LinkageTypes Linkage, final /*const*/ Twine /*&*/ Name,
      Constant /*P*/ Symbol) {
    // : GlobalValue(Ty, VTy, &Op<0>(), 1, Linkage, Name, AddressSpace)
    //START JInit
    super(Ty, VTy, $AddrOf(OpFrom$Addr(0, User.$BEING_CREATED(), GlobalIndirectSymbol.class)), 1, Linkage, Name, AddressSpace);
    //END JInit
    this./*<0>*/Op(0).$assign(Symbol);
  }

/*public:*/
  // allocate space for exactly one operand
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol::operator new">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIndirectSymbol.h", line = 34,
   FQN="llvm::GlobalIndirectSymbol::operator new", NM="_ZN4llvm20GlobalIndirectSymbolnwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm20GlobalIndirectSymbolnwEj")
  //</editor-fold>
  public static <T extends GlobalIndirectSymbol> T/*void P*/ $new_GlobalIndirectSymbol(New$ConstructorCallback<T> $Ctor) {
    return User.$new_FixedUses(/*s, */1, $Ctor);
  }


  /// Provide fast operand accessors
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIndirectSymbol.h", line = 80,
   FQN="llvm::GlobalIndirectSymbol::getOperand", NM="_ZNK4llvm20GlobalIndirectSymbol10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm20GlobalIndirectSymbol10getOperandEj")
  //</editor-fold>
  public Constant /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsGlobalIndirectSymbol.<GlobalIndirectSymbol>operands$FixedNumOperandTraits(this))) : "getOperand() out of range!";
    return cast_or_null_Constant(OperandTraitsGlobalIndirectSymbol.<GlobalIndirectSymbol>op_begin(((/*const_cast*/GlobalIndirectSymbol /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIndirectSymbol.h", line = 80,
   FQN="llvm::GlobalIndirectSymbol::setOperand", NM="_ZN4llvm20GlobalIndirectSymbol10setOperandEjPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm20GlobalIndirectSymbol10setOperandEjPNS_8ConstantE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Constant /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsGlobalIndirectSymbol.<GlobalIndirectSymbol>operands$FixedNumOperandTraits(this))) : "setOperand() out of range!";
    OperandTraitsGlobalIndirectSymbol.<GlobalIndirectSymbol>op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIndirectSymbol.h", line = 80,
   FQN="llvm::GlobalIndirectSymbol::op_begin", NM="_ZN4llvm20GlobalIndirectSymbol8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm20GlobalIndirectSymbol8op_beginEv")
  //</editor-fold>
  public type$ptr<Use/*P*/> op_begin() {
    return OperandTraitsGlobalIndirectSymbol.<GlobalIndirectSymbol>op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIndirectSymbol.h", line = 80,
   FQN="llvm::GlobalIndirectSymbol::op_begin", NM="_ZNK4llvm20GlobalIndirectSymbol8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm20GlobalIndirectSymbol8op_beginEv")
  //</editor-fold>
  public type$ptr<Use/*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsGlobalIndirectSymbol.<GlobalIndirectSymbol>op_begin(((/*const_cast*/GlobalIndirectSymbol /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIndirectSymbol.h", line = 80,
   FQN="llvm::GlobalIndirectSymbol::op_end", NM="_ZN4llvm20GlobalIndirectSymbol6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm20GlobalIndirectSymbol6op_endEv")
  //</editor-fold>
  public type$ptr<Use/*P*/> op_end() {
    return OperandTraitsGlobalIndirectSymbol.<GlobalIndirectSymbol>op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIndirectSymbol.h", line = 80,
   FQN="llvm::GlobalIndirectSymbol::op_end", NM="_ZNK4llvm20GlobalIndirectSymbol6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm20GlobalIndirectSymbol6op_endEv")
  //</editor-fold>
  public type$ptr<Use/*P*/> op_end$Const() /*const*/ {
    return OperandTraitsGlobalIndirectSymbol.<GlobalIndirectSymbol>op_end(((/*const_cast*/GlobalIndirectSymbol /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIndirectSymbol.h", line = 80,
   FQN="llvm::GlobalIndirectSymbol::Op", NM="Tpl__ZN4llvm20GlobalIndirectSymbol2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=Tpl__ZN4llvm20GlobalIndirectSymbol2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this.OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIndirectSymbol.h", line = 80,
   FQN="llvm::GlobalIndirectSymbol::Op", NM="Tpl__ZNK4llvm20GlobalIndirectSymbol2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=Tpl__ZNK4llvm20GlobalIndirectSymbol2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this.OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIndirectSymbol.h", line = 80,
   FQN="llvm::GlobalIndirectSymbol::getNumOperands", NM="_ZNK4llvm20GlobalIndirectSymbol14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm20GlobalIndirectSymbol14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsGlobalIndirectSymbol.<GlobalIndirectSymbol>operands$FixedNumOperandTraits(this);
  }


  /// These methods set and retrieve indirect symbol.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol::setIndirectSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIndirectSymbol.h", line = 42,
   FQN="llvm::GlobalIndirectSymbol::setIndirectSymbol", NM="_ZN4llvm20GlobalIndirectSymbol17setIndirectSymbolEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm20GlobalIndirectSymbol17setIndirectSymbolEPNS_8ConstantE")
  //</editor-fold>
  public void setIndirectSymbol(Constant /*P*/ Symbol) {
    setOperand(0, Symbol);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol::getIndirectSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIndirectSymbol.h", line = 45,
   FQN="llvm::GlobalIndirectSymbol::getIndirectSymbol", NM="_ZNK4llvm20GlobalIndirectSymbol17getIndirectSymbolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm20GlobalIndirectSymbol17getIndirectSymbolEv")
  //</editor-fold>
  public /*const*/ Constant /*P*/ getIndirectSymbol$Const() /*const*/ {
    return ((/*const_cast*/GlobalIndirectSymbol /*P*/ )(this)).getIndirectSymbol();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol::getIndirectSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIndirectSymbol.h", line = 48,
   FQN="llvm::GlobalIndirectSymbol::getIndirectSymbol", NM="_ZN4llvm20GlobalIndirectSymbol17getIndirectSymbolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm20GlobalIndirectSymbol17getIndirectSymbolEv")
  //</editor-fold>
  public Constant /*P*/ getIndirectSymbol() {
    return getOperand(0);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol::getBaseObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIndirectSymbol.h", line = 52,
   FQN="llvm::GlobalIndirectSymbol::getBaseObject", NM="_ZNK4llvm20GlobalIndirectSymbol13getBaseObjectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm20GlobalIndirectSymbol13getBaseObjectEv")
  //</editor-fold>
  public /*const*/ GlobalObject /*P*/ getBaseObject$Const() /*const*/ {
    return ((/*const_cast*/GlobalIndirectSymbol /*P*/ )(this)).getBaseObject();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol::getBaseObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIndirectSymbol.h", line = 55,
   FQN="llvm::GlobalIndirectSymbol::getBaseObject", NM="_ZN4llvm20GlobalIndirectSymbol13getBaseObjectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm20GlobalIndirectSymbol13getBaseObjectEv")
  //</editor-fold>
  public GlobalObject /*P*/ getBaseObject() {
    return dyn_cast_GlobalObject(getIndirectSymbol().stripInBoundsOffsets());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol::getBaseObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIndirectSymbol.h", line = 59,
   FQN="llvm::GlobalIndirectSymbol::getBaseObject", NM="_ZNK4llvm20GlobalIndirectSymbol13getBaseObjectERKNS_10DataLayoutERNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm20GlobalIndirectSymbol13getBaseObjectERKNS_10DataLayoutERNS_5APIntE")
  //</editor-fold>
  public /*const*/ GlobalObject /*P*/ getBaseObject$Const(final /*const*/ DataLayout /*&*/ DL, final APInt /*&*/ Offset) /*const*/ {
    return ((/*const_cast*/GlobalIndirectSymbol /*P*/ )(this)).getBaseObject(DL, Offset);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol::getBaseObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIndirectSymbol.h", line = 62,
   FQN="llvm::GlobalIndirectSymbol::getBaseObject", NM="_ZN4llvm20GlobalIndirectSymbol13getBaseObjectERKNS_10DataLayoutERNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm20GlobalIndirectSymbol13getBaseObjectERKNS_10DataLayoutERNS_5APIntE")
  //</editor-fold>
  public GlobalObject /*P*/ getBaseObject(final /*const*/ DataLayout /*&*/ DL, final APInt /*&*/ Offset) {
    return dyn_cast_GlobalObject(getIndirectSymbol().stripAndAccumulateInBoundsConstantOffsets(DL,
    Offset));
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIndirectSymbol.h", line = 69,
   FQN="llvm::GlobalIndirectSymbol::classof", NM="_ZN4llvm20GlobalIndirectSymbol7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm20GlobalIndirectSymbol7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == Value.ValueTy.GlobalAliasVal.getValue()
       || V.getValueID() == Value.ValueTy.GlobalIFuncVal.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIndirectSymbol::~GlobalIndirectSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIndirectSymbol.h", line = 24,
   FQN="llvm::GlobalIndirectSymbol::~GlobalIndirectSymbol", NM="_ZN4llvm20GlobalIndirectSymbolD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm20GlobalIndirectSymbolD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected GlobalIndirectSymbol() {}

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
