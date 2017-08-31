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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
/// Constant Vector Declarations
///
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantVector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 470,
 FQN="llvm::ConstantVector", NM="_ZN4llvm14ConstantVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm14ConstantVectorE")
//</editor-fold>
public final class ConstantVector extends /*public*/ ConstantAggregate implements Destructors.ClassWithDestructor {
  /*friend  struct ConstantAggrKeyType<ConstantVector>*/
  /*friend  class Constant*/

  /// Remove the constant from the constant table.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantVector::destroyConstantImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1292,
   FQN="llvm::ConstantVector::destroyConstantImpl", NM="_ZN4llvm14ConstantVector19destroyConstantImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm14ConstantVector19destroyConstantImplEv")
  //</editor-fold>
  /*friend*//*package*//*private*/ void destroyConstantImpl() {
    getType().getContext().pImpl.VectorConstants.remove(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantVector::handleOperandChangeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2797,
   FQN="llvm::ConstantVector::handleOperandChangeImpl", NM="_ZN4llvm14ConstantVector23handleOperandChangeImplEPNS_5ValueES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm14ConstantVector23handleOperandChangeImplEPNS_5ValueES2_")
  //</editor-fold>
  /*friend*//*package*//*private*/ Value /*P*/ handleOperandChangeImpl(Value /*P*/ From, Value /*P*/ To) {
    assert (isa_Constant(To)) : "Cannot make Constant refer to non-constant!";
    Constant /*P*/ ToC = cast_Constant(To);

    SmallVector<Constant /*P*/ > Values/*J*/= new SmallVector<Constant /*P*/ >(8, (Constant /*P*/ )null);
    Values.reserve(getNumOperands()); // Build replacement array...
    /*uint*/int NumUpdated = 0;
    /*uint*/int OperandNo = 0;
    for (/*uint*/int i = 0, e = getNumOperands(); i != e; ++i) {
      Constant /*P*/ Val = getOperand(i);
      if (Val == From) {
        OperandNo = i;
        ++NumUpdated;
        Val = ToC;
      }
      Values.push_back(Val);
    }
    {

      Constant /*P*/ C = getImpl(new ArrayRef<Constant /*P*/ >(Values, true));
      if ((C != null)) {
        return C;
      }
    }

    // Update to the new value.
    return getContext().pImpl.VectorConstants.replaceOperandsInPlace(new ArrayRef<Constant /*P*/ >(Values, true), this, From, ToC, NumUpdated, OperandNo);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantVector::ConstantVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 991,
   FQN="llvm::ConstantVector::ConstantVector", NM="_ZN4llvm14ConstantVectorC1EPNS_10VectorTypeENS_8ArrayRefIPNS_8ConstantEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm14ConstantVectorC1EPNS_10VectorTypeENS_8ArrayRefIPNS_8ConstantEEE")
  //</editor-fold>
  /*friend*/public/*private*/ ConstantVector(VectorType /*P*/ T, ArrayRef<Constant /*P*/ > V) {
    // : ConstantAggregate(T, ConstantVectorVal, V)
    //START JInit
    super(T, ValueTy.ConstantVectorVal, new ArrayRef<Constant /*P*/ >(V));
    //END JInit
    assert (V.size() == T.getNumElements()) : "Invalid initializer for constant vector";
  }

/*public:*/
  // ConstantVector accessors

  // ConstantVector accessors.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantVector::get">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 998,
   FQN="llvm::ConstantVector::get", NM="_ZN4llvm14ConstantVector3getENS_8ArrayRefIPNS_8ConstantEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm14ConstantVector3getENS_8ArrayRefIPNS_8ConstantEEE")
  //</editor-fold>
  public static Constant /*P*/ get(ArrayRef<Constant /*P*/ > V) {
    {
      Constant /*P*/ C = ConstantVector.getImpl(new ArrayRef<Constant /*P*/ >(V));
      if ((C != null)) {
        return C;
      }
    }
    VectorType /*P*/ Ty = VectorType.get(V.front().getType(), V.size());
    return Ty.getContext().pImpl.VectorConstants.getOrCreate(Ty, new ConstantAggrKeyType<ConstantVector, VectorType>(new ArrayRef<Constant /*P*/ >(V)));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantVector::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1005,
   FQN="llvm::ConstantVector::getImpl", NM="_ZN4llvm14ConstantVector7getImplENS_8ArrayRefIPNS_8ConstantEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm14ConstantVector7getImplENS_8ArrayRefIPNS_8ConstantEEE")
  //</editor-fold>
  private static Constant /*P*/ getImpl(ArrayRef<Constant /*P*/ > V) {
    assert (!V.empty()) : "Vectors can't be empty";
    VectorType /*P*/ T = VectorType.get(V.front().getType(), V.size());

    // If this is an all-undef or all-zero vector, return a
    // ConstantAggregateZero or UndefValue.
    Constant /*P*/ C = V.$at(0);
    boolean isZero = C.isNullValue();
    boolean isUndef = isa_UndefValue(C);
    if (isZero || isUndef) {
      for (/*uint*/int i = 1, e = V.size(); i != e; ++i)  {
        if (V.$at(i) != C) {
          isZero = isUndef = false;
          break;
        }
      }
    }
    if (isZero) {
      return ConstantAggregateZero.get(T);
    }
    if (isUndef) {
      return UndefValue.get(T);
    }

    // Check to see if all of the elements are ConstantFP or ConstantInt and if
    // the element type is compatible with ConstantDataVector.  If so, use it.
    if (ConstantDataSequential.isElementTypeCompatible(C.getType())) {
      return ConstantsStatics.<ConstantDataVector>getSequenceIfElementsMatch(C, new ArrayRef<Constant /*P*/ >(V));
    }

    // Otherwise, the element type isn't compatible with ConstantDataVector, or
    // the operand list constants a ConstantExpr or something else strange.
    return null;
  }

/*public:*/
  /// Return a ConstantVector with the specified constant in each element.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantVector::getSplat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1038,
   FQN="llvm::ConstantVector::getSplat", NM="_ZN4llvm14ConstantVector8getSplatEjPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm14ConstantVector8getSplatEjPNS_8ConstantE")
  //</editor-fold>
  public static Constant /*P*/ getSplat(/*uint*/int NumElts, Constant /*P*/ V) {
    // If this splat is compatible with ConstantDataVector, use it instead of
    // ConstantVector.
    if ((isa_ConstantFP(V) || isa_ConstantInt(V))
       && ConstantDataSequential.isElementTypeCompatible(V.getType())) {
      return ConstantDataVector.getSplat(NumElts, V);
    }

    SmallVector<Constant /*P*/ > Elts/*J*/= new SmallVector<Constant /*P*/ >(JD$UInt_T$C$R.INSTANCE, 32, NumElts, V, (Constant /*P*/ )null);
    return get(new ArrayRef<Constant /*P*/ >(Elts, true));
  }


  /// Specialize the getType() method to always return a VectorType,
  /// which reduces the amount of casting needed in parts of the compiler.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantVector::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 491,
   FQN="llvm::ConstantVector::getType", NM="_ZNK4llvm14ConstantVector7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm14ConstantVector7getTypeEv")
  //</editor-fold>
  public /*inline*/ VectorType /*P*/ getType() /*const*/ {
    return cast_VectorType(super.getType());
  }


  /// If this is a splat constant, meaning that all of the elements have the
  /// same value, return that value. Otherwise return NULL.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantVector::getSplatValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1307,
   FQN="llvm::ConstantVector::getSplatValue", NM="_ZNK4llvm14ConstantVector13getSplatValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm14ConstantVector13getSplatValueEv")
  //</editor-fold>
  public Constant /*P*/ getSplatValue() /*const*/ {
    // Check out first element.
    Constant /*P*/ Elt = getOperand(0);
    // Then make sure all remaining elements point to the same value.
    for (/*uint*/int I = 1, E = getNumOperands(); $less_uint(I, E); ++I)  {
      if (getOperand(I) != Elt) {
        return null;
      }
    }
    return Elt;
  }


  /// Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantVector::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 500,
   FQN="llvm::ConstantVector::classof", NM="_ZN4llvm14ConstantVector7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm14ConstantVector7classofEPKNS_5ValueE")
  //</editor-fold>
  public static boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == ValueTy.ConstantVectorVal.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantVector::~ConstantVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 470,
   FQN="llvm::ConstantVector::~ConstantVector", NM="_ZN4llvm14ConstantVectorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm14ConstantVectorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
