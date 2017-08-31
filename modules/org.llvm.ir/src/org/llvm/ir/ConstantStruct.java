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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
// Constant Struct Declarations
//
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 423,
 FQN="llvm::ConstantStruct", NM="_ZN4llvm14ConstantStructE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm14ConstantStructE")
//</editor-fold>
public final class ConstantStruct extends /*public*/ ConstantAggregate implements Destructors.ClassWithDestructor {
  /*friend  struct ConstantAggrKeyType<ConstantStruct>*/
  /*friend  class Constant*/

  //---- ConstantStruct::get() implementation...
  //

  /// Remove the constant from the constant table.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantStruct::destroyConstantImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1287,
   FQN="llvm::ConstantStruct::destroyConstantImpl", NM="_ZN4llvm14ConstantStruct19destroyConstantImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm14ConstantStruct19destroyConstantImplEv")
  //</editor-fold>
  /*friend*//*package*//*private*/ void destroyConstantImpl() {
    getType().getContext().pImpl.StructConstants.remove(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantStruct::handleOperandChangeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2761,
   FQN="llvm::ConstantStruct::handleOperandChangeImpl", NM="_ZN4llvm14ConstantStruct23handleOperandChangeImplEPNS_5ValueES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm14ConstantStruct23handleOperandChangeImplEPNS_5ValueES2_")
  //</editor-fold>
  /*friend*//*package*//*private*/ Value /*P*/ handleOperandChangeImpl(Value /*P*/ From, Value /*P*/ To) {
    assert (isa_Constant(To)) : "Cannot make Constant refer to non-constant!";
    Constant /*P*/ ToC = cast_Constant(To);

    type$ptr<Use /*P*/> OperandList = $tryClone(getOperandList());

    SmallVector<Constant /*P*/ > Values/*J*/= new SmallVector<Constant /*P*/ >(8, (Constant /*P*/ )null);
    Values.reserve(getNumOperands()); // Build replacement struct.

    // Fill values with the modified operands of the constant struct.  Also,
    // compute whether this turns into an all-zeros struct.
    /*uint*/int NumUpdated = 0;
    boolean AllSame = true;
    /*uint*/int OperandNo = 0;
    for (type$ptr<Use /*P*/> O = $tryClone(OperandList), /*P*/ E = $tryClone(OperandList.$add(getNumOperands())); $noteq_ptr(O, E); O.$preInc()) {
      Constant /*P*/ Val = cast_Constant(O./*->*/$star().get());
      if (Val == From) {
        OperandNo = (O.$sub(OperandList));
        Val = ToC;
        ++NumUpdated;
      }
      Values.push_back(Val);
      AllSame &= Val == ToC;
    }
    if (AllSame && ToC.isNullValue()) {
      return ConstantAggregateZero.get(getType());
    }
    if (AllSame && isa_UndefValue(ToC)) {
      return UndefValue.get(getType());
    }

    // Update to the new value.
    return getContext().pImpl.StructConstants.replaceOperandsInPlace(new ArrayRef<Constant /*P*/ >(Values, true), this, From, ToC, NumUpdated, OperandNo);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantStruct::ConstantStruct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 946,
   FQN="llvm::ConstantStruct::ConstantStruct", NM="_ZN4llvm14ConstantStructC1EPNS_10StructTypeENS_8ArrayRefIPNS_8ConstantEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm14ConstantStructC1EPNS_10StructTypeENS_8ArrayRefIPNS_8ConstantEEE")
  //</editor-fold>
  /*friend*/public/*private*/ ConstantStruct(StructType /*P*/ T, ArrayRef<Constant /*P*/ > V) {
    // : ConstantAggregate(T, ConstantStructVal, V)
    //START JInit
    super(T, ValueTy.ConstantStructVal, new ArrayRef<Constant /*P*/ >(V));
    //END JInit
    assert ((T.isOpaque() || V.size() == T.getNumElements())) : "Invalid initializer for constant struct";
  }

/*public:*/
  // ConstantStruct accessors

  // ConstantStruct accessors.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantStruct::get">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 953,
   FQN="llvm::ConstantStruct::get", NM="_ZN4llvm14ConstantStruct3getEPNS_10StructTypeENS_8ArrayRefIPNS_8ConstantEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm14ConstantStruct3getEPNS_10StructTypeENS_8ArrayRefIPNS_8ConstantEEE")
  //</editor-fold>
  public static Constant /*P*/ get(StructType /*P*/ ST, ArrayRef<Constant /*P*/ > V) {
    assert ((ST.isOpaque() || ST.getNumElements() == V.size())) : "Incorrect # elements specified to ConstantStruct::get";

    // Create a ConstantAggregateZero value if all elements are zeros.
    boolean isZero = true;
    boolean isUndef = false;
    if (!V.empty()) {
      isUndef = isa_UndefValue(V.$at(0));
      isZero = V.$at(0).isNullValue();
      if (isUndef || isZero) {
        for (/*uint*/int i = 0, e = V.size(); i != e; ++i) {
          if (!V.$at(i).isNullValue()) {
            isZero = false;
          }
          if (!isa_UndefValue(V.$at(i))) {
            isUndef = false;
          }
        }
      }
    }
    if (isZero) {
      return ConstantAggregateZero.get(ST);
    }
    if (isUndef) {
      return UndefValue.get(ST);
    }

    return ST.getContext().pImpl.StructConstants.getOrCreate(ST, new ConstantAggrKeyType<ConstantStruct, StructType>(new ArrayRef<Constant /*P*/ >(V)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantStruct::get">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 981,
   FQN="llvm::ConstantStruct::get", NM="_ZN4llvm14ConstantStruct3getEPNS_10StructTypeEz",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm14ConstantStruct3getEPNS_10StructTypeEz")
  //</editor-fold>
  public static Constant /*P*/ get(StructType /*P*/ T, Object ... $VarArg)/* __attribute__((sentinel(0, 0)))*/ {
    type$ptr/*char P*/ ap = create_type$ptr();
    SmallVector<Constant /*P*/ > Values/*J*/= new SmallVector<Constant /*P*/ >(8, (Constant /*P*/ )null);
    __builtin_va_start($VarArg, ap, T);
    {
      Constant /*P*/ Val;
      while (((/*P*/ Val = __builtin_va_arg(ap, Constant /*P*/ .class)) != null)) {
        Values.push_back(Val);
      }
    }
    __builtin_va_end(ap);
    return get(T, new ArrayRef<Constant /*P*/ >(Values, true));
  }


  /// Return an anonymous struct that has the specified elements.
  /// If the struct is possibly empty, then you must specify a context.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantStruct::getAnon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 438,
   FQN="llvm::ConstantStruct::getAnon", NM="_ZN4llvm14ConstantStruct7getAnonENS_8ArrayRefIPNS_8ConstantEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm14ConstantStruct7getAnonENS_8ArrayRefIPNS_8ConstantEEEb")
  //</editor-fold>
  public static Constant /*P*/ getAnon(ArrayRef<Constant /*P*/ > V) {
    return getAnon(V, false);
  }
  public static Constant /*P*/ getAnon(ArrayRef<Constant /*P*/ > V, boolean Packed/*= false*/) {
    return ConstantStruct.get(ConstantStruct.getTypeForElements(new ArrayRef<Constant /*P*/ >(V), Packed), new ArrayRef<Constant /*P*/ >(V));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantStruct::getAnon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 441,
   FQN="llvm::ConstantStruct::getAnon", NM="_ZN4llvm14ConstantStruct7getAnonERNS_11LLVMContextENS_8ArrayRefIPNS_8ConstantEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm14ConstantStruct7getAnonERNS_11LLVMContextENS_8ArrayRefIPNS_8ConstantEEEb")
  //</editor-fold>
  public static Constant /*P*/ getAnon(final LLVMContext /*&*/ Ctx,
         ArrayRef<Constant /*P*/ > V) {
    return getAnon(Ctx,
         V, false);
  }
  public static Constant /*P*/ getAnon(final LLVMContext /*&*/ Ctx,
         ArrayRef<Constant /*P*/ > V, boolean Packed/*= false*/) {
    return ConstantStruct.get(ConstantStruct.getTypeForElements(Ctx, new ArrayRef<Constant /*P*/ >(V), Packed), new ArrayRef<Constant /*P*/ >(V));
  }


  /// Return an anonymous struct type to use for a constant with the specified
  /// set of elements. The list must not be empty.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantStruct::getTypeForElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 939,
   FQN="llvm::ConstantStruct::getTypeForElements", NM="_ZN4llvm14ConstantStruct18getTypeForElementsENS_8ArrayRefIPNS_8ConstantEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm14ConstantStruct18getTypeForElementsENS_8ArrayRefIPNS_8ConstantEEEb")
  //</editor-fold>
  public static StructType /*P*/ getTypeForElements(ArrayRef<Constant /*P*/ > V) {
    return getTypeForElements(V,
                    false);
  }
  public static StructType /*P*/ getTypeForElements(ArrayRef<Constant /*P*/ > V,
                    boolean Packed/*= false*/) {
    assert (!V.empty()) : "ConstantStruct::getTypeForElements cannot be called on empty list";
    return getTypeForElements(V.$at(0).getContext(), new ArrayRef<Constant /*P*/ >(V), Packed);
  }

  /// This version of the method allows an empty list.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantStruct::getTypeForElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 927,
   FQN="llvm::ConstantStruct::getTypeForElements", NM="_ZN4llvm14ConstantStruct18getTypeForElementsERNS_11LLVMContextENS_8ArrayRefIPNS_8ConstantEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm14ConstantStruct18getTypeForElementsERNS_11LLVMContextENS_8ArrayRefIPNS_8ConstantEEEb")
  //</editor-fold>
  public static StructType /*P*/ getTypeForElements(final LLVMContext /*&*/ Context,
                    ArrayRef<Constant /*P*/ > V) {
    return getTypeForElements(Context,
                    V,
                    false);
  }
  public static StructType /*P*/ getTypeForElements(final LLVMContext /*&*/ Context,
                    ArrayRef<Constant /*P*/ > V,
                    boolean Packed/*= false*/) {
    /*uint*/int VecSize = V.size();
    SmallVector<Type /*P*/ > EltTypes/*J*/= new SmallVector<Type /*P*/ >(JD$UInt_T$C$R.INSTANCE, 16, VecSize, (Type /*P*/ )null);
    for (/*uint*/int i = 0; i != VecSize; ++i)  {
      EltTypes.$set(i, V.$at(i).getType());
    }

    return StructType.get(Context, new ArrayRef<Type /*P*/ >(EltTypes, true), Packed);
  }


  /// Specialization - reduce amount of casting.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantStruct::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 456,
   FQN="llvm::ConstantStruct::getType", NM="_ZNK4llvm14ConstantStruct7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm14ConstantStruct7getTypeEv")
  //</editor-fold>
  public /*inline*/ StructType /*P*/ getType() /*const*/ {
    return cast_StructType(super.getType());
  }


  /// Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantStruct::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 461,
   FQN="llvm::ConstantStruct::classof", NM="_ZN4llvm14ConstantStruct7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm14ConstantStruct7classofEPKNS_5ValueE")
  //</editor-fold>
  public static boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == ValueTy.ConstantStructVal.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantStruct::~ConstantStruct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 423,
   FQN="llvm::ConstantStruct::~ConstantStruct", NM="_ZN4llvm14ConstantStructD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm14ConstantStructD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
