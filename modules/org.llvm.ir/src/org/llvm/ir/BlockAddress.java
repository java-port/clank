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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


/// The address of a basic block.
///
//<editor-fold defaultstate="collapsed" desc="llvm::BlockAddress">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 786,
 FQN="llvm::BlockAddress", NM="_ZN4llvm12BlockAddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12BlockAddressE")
//</editor-fold>
public final class BlockAddress extends /*public*/ Constant implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockAddress::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 787,
   FQN="llvm::BlockAddress::operator new", NM="_ZN4llvm12BlockAddressnwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12BlockAddressnwEjj")
  //</editor-fold>
  protected/*private*/ static Object/*void P*/ $new_BlockAddress(/*size_t*/int $Prm0, /*uint*/int $Prm1) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockAddress::operator new">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 788,
   FQN="llvm::BlockAddress::operator new", NM="_ZN4llvm12BlockAddressnwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12BlockAddressnwEj")
  //</editor-fold>
  private static BlockAddress/*void P*/ $new_BlockAddress(New$ConstructorCallback<BlockAddress> $Ctor) {
    return User.$new_FixedUses(/*s, */2, $Ctor);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockAddress::BlockAddress">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1371,
   FQN="llvm::BlockAddress::BlockAddress", NM="_ZN4llvm12BlockAddressC1EPNS_8FunctionEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12BlockAddressC1EPNS_8FunctionEPNS_10BasicBlockE")
  //</editor-fold>
  private BlockAddress(Function /*P*/ F, BasicBlock /*P*/ BB) {
    // : Constant(Type::getInt8PtrTy(F->getContext()), Value::BlockAddressVal, &Op<0>(), 2)
    //START JInit
    super(Type.getInt8PtrTy(F.getContext()), Value.ValueTy.BlockAddressVal,
        OpFrom$Addr(0, User.$BEING_CREATED(), BlockAddress.class), 2);
    //END JInit
    setOperand(0, F);
    setOperand(1, BB);
    BB.AdjustBlockAddressRefCount(1);
  }


  /*friend  class Constant*/

  /// Remove the constant from the constant table.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockAddress::destroyConstantImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1392,
   FQN="llvm::BlockAddress::destroyConstantImpl", NM="_ZN4llvm12BlockAddress19destroyConstantImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12BlockAddress19destroyConstantImplEv")
  //</editor-fold>
  /*friend*//*package*/ void destroyConstantImpl() {
    getFunction().getType().getContext().pImpl.
        BlockAddresses.erase(new std.pairPtrPtr</*const*/ Function /*P*/ , /*const*/ BasicBlock /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/getFunction(), /*Fwd2*//*Fwd*/getBasicBlock()));
    getBasicBlock().AdjustBlockAddressRefCount(-1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockAddress::handleOperandChangeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1398,
   FQN="llvm::BlockAddress::handleOperandChangeImpl", NM="_ZN4llvm12BlockAddress23handleOperandChangeImplEPNS_5ValueES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12BlockAddress23handleOperandChangeImplEPNS_5ValueES2_")
  //</editor-fold>
  /*friend*//*package*/ Value /*P*/ handleOperandChangeImpl(Value /*P*/ From, Value /*P*/ To) {
    // This could be replacing either the Basic Block or the Function.  In either
    // case, we have to remove the map entry.
    Function /*P*/ NewF = getFunction();
    BasicBlock /*P*/ NewBB = getBasicBlock();
    if (From == NewF) {
      NewF = cast_Function(To.stripPointerCasts());
    } else {
      assert (From == NewBB) : "From does not match any operand";
      NewBB = cast_BasicBlock(To);
    }

    // See if the 'new' entry already exists, if not, just update this in place
    // and return early.
    final type$ref<BlockAddress /*P*/ /*&*/> NewBA = getContext().pImpl.BlockAddresses.ref$at(new std.pairPtrPtr</*const*/ Function /*P*/ , /*const*/ BasicBlock /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/NewF, /*Fwd2*//*Fwd*/NewBB));
    if ((NewBA.$deref() != null)) {
      return NewBA.$deref();
    }

    getBasicBlock().AdjustBlockAddressRefCount(-1);

    // Remove the old entry, this can't cause the map to rehash (just a
    // tombstone will get added).
    getContext().pImpl.BlockAddresses.erase(new std.pairPtrPtr</*const*/ Function /*P*/ , /*const*/ BasicBlock /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/getFunction(), /*Fwd2*//*Fwd*/getBasicBlock()));
    NewBA.$set(this);
    setOperand(0, NewF);
    setOperand(1, NewBB);
    getBasicBlock().AdjustBlockAddressRefCount(1);

    // If we just want to keep the existing value, then return null.
    // Callers know that this means we shouldn't delete this value.
    return null;
  }

/*public:*/
  /// Return a BlockAddress for the specified function and basic block.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockAddress::get">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1361,
   FQN="llvm::BlockAddress::get", NM="_ZN4llvm12BlockAddress3getEPNS_8FunctionEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12BlockAddress3getEPNS_8FunctionEPNS_10BasicBlockE")
  //</editor-fold>
  public static BlockAddress /*P*/ get(Function /*P*/ F, BasicBlock /*P*/ BB) {
    final type$ref<BlockAddress /*P*/ /*&*/> BA = F.getContext().pImpl.BlockAddresses.ref$at(new std.pairPtrPtr</*const*/ Function /*P*/ , /*const*/ BasicBlock /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/F, /*Fwd2*//*Fwd*/BB));
    if (!(BA.$deref() != null)) {
      BA.$set(/*NEW_EXPR [BlockAddress::new]*/BlockAddress.$new_BlockAddress((type$ptr<?> New$Mem)->{
          return new BlockAddress(F, BB);
       }));
    }
    assert (BA.$deref().getFunction() == F) : "Basic block moved between functions";
    return BA.$deref();
  }


  /// Return a BlockAddress for the specified basic block.  The basic
  /// block must be embedded into a function.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockAddress::get">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1356,
   FQN="llvm::BlockAddress::get", NM="_ZN4llvm12BlockAddress3getEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12BlockAddress3getEPNS_10BasicBlockE")
  //</editor-fold>
  public static BlockAddress /*P*/ get(BasicBlock /*P*/ BB) {
    assert ((BB.getParent() != null)) : "Block must have a parent";
    return BlockAddress.get(BB.getParent(), BB);
  }


  /// Lookup an existing \c BlockAddress constant for the given BasicBlock.
  ///
  /// \returns 0 if \c !BB->hasAddressTaken(), otherwise the \c BlockAddress.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockAddress::lookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1379,
   FQN="llvm::BlockAddress::lookup", NM="_ZN4llvm12BlockAddress6lookupEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12BlockAddress6lookupEPKNS_10BasicBlockE")
  //</editor-fold>
  public static BlockAddress /*P*/ lookup(/*const*/ BasicBlock /*P*/ BB) {
    if (!BB.hasAddressTaken()) {
      return null;
    }

    /*const*/ Function /*P*/ F = BB.getParent$Const();
    assert ((F != null)) : "Block must have a parent";
    BlockAddress /*P*/ BA = F.getContext().pImpl.BlockAddresses.lookup(std.make_pair_Ptr_Ptr(F, BB));
    assert ((BA != null)) : "Refcount and block address map disagree!";
    return BA;
  }


  /// Transparently provide more efficient getOperand methods.
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockAddress::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 825,
   FQN="llvm::BlockAddress::getOperand", NM="_ZNK4llvm12BlockAddress10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm12BlockAddress10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsBlockAddress.<BlockAddress>operands$FixedNumOperandTraits(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsBlockAddress.<BlockAddress>op_begin(((/*const_cast*/BlockAddress /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockAddress::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 825,
   FQN="llvm::BlockAddress::setOperand", NM="_ZN4llvm12BlockAddress10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12BlockAddress10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsBlockAddress.<BlockAddress>operands$FixedNumOperandTraits(this))) : "setOperand() out of range!";
    OperandTraitsBlockAddress.<BlockAddress>op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockAddress::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 825,
   FQN="llvm::BlockAddress::op_begin", NM="_ZN4llvm12BlockAddress8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12BlockAddress8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsBlockAddress.<BlockAddress>op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockAddress::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 825,
   FQN="llvm::BlockAddress::op_begin", NM="_ZNK4llvm12BlockAddress8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm12BlockAddress8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsBlockAddress.<BlockAddress>op_begin(((/*const_cast*/BlockAddress /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockAddress::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 825,
   FQN="llvm::BlockAddress::op_end", NM="_ZN4llvm12BlockAddress6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12BlockAddress6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsBlockAddress.<BlockAddress>op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockAddress::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 825,
   FQN="llvm::BlockAddress::op_end", NM="_ZNK4llvm12BlockAddress6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm12BlockAddress6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsBlockAddress.<BlockAddress>op_end(((/*const_cast*/BlockAddress /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockAddress::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 825,
   FQN="llvm::BlockAddress::Op", NM="Tpl__ZN4llvm12BlockAddress2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=Tpl__ZN4llvm12BlockAddress2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this.OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockAddress::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 825,
   FQN="llvm::BlockAddress::Op", NM="Tpl__ZNK4llvm12BlockAddress2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=Tpl__ZNK4llvm12BlockAddress2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this.OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockAddress::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 825,
   FQN="llvm::BlockAddress::getNumOperands", NM="_ZNK4llvm12BlockAddress14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm12BlockAddress14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsBlockAddress.<BlockAddress>operands$FixedNumOperandTraits(this);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BlockAddress::getFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 811,
   FQN="llvm::BlockAddress::getFunction", NM="_ZNK4llvm12BlockAddress11getFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm12BlockAddress11getFunctionEv")
  //</editor-fold>
  public Function /*P*/ getFunction() /*const*/ {
    return (Function /*P*/ )this./*<0>*/Op$Const(0).get();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockAddress::getBasicBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 812,
   FQN="llvm::BlockAddress::getBasicBlock", NM="_ZNK4llvm12BlockAddress13getBasicBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm12BlockAddress13getBasicBlockEv")
  //</editor-fold>
  public BasicBlock /*P*/ getBasicBlock() /*const*/ {
    return (BasicBlock /*P*/ )this./*<1>*/Op$Const(1).get();
  }


  /// Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockAddress::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 815,
   FQN="llvm::BlockAddress::classof", NM="_ZN4llvm12BlockAddress7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12BlockAddress7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == ValueTy.BlockAddressVal.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockAddress::~BlockAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 786,
   FQN="llvm::BlockAddress::~BlockAddress", NM="_ZN4llvm12BlockAddressD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12BlockAddressD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
