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
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
/// ConstantArray - Constant Array Declarations
///
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantArray">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 392,
 FQN="llvm::ConstantArray", NM="_ZN4llvm13ConstantArrayE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm13ConstantArrayE")
//</editor-fold>
public final class ConstantArray extends /*public*/ ConstantAggregate implements Destructors.ClassWithDestructor {
  /*friend  struct ConstantAggrKeyType<ConstantArray>*/
  /*friend  class Constant*/

  /// Remove the constant from the constant table.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantArray::destroyConstantImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1278,
   FQN="llvm::ConstantArray::destroyConstantImpl", NM="_ZN4llvm13ConstantArray19destroyConstantImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm13ConstantArray19destroyConstantImplEv")
  //</editor-fold>
  /*friend*//*package*//*private*/ void destroyConstantImpl() {
    getType().getContext().pImpl.ArrayConstants.remove(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantArray::handleOperandChangeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2720,
   FQN="llvm::ConstantArray::handleOperandChangeImpl", NM="_ZN4llvm13ConstantArray23handleOperandChangeImplEPNS_5ValueES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm13ConstantArray23handleOperandChangeImplEPNS_5ValueES2_")
  //</editor-fold>
  /*friend*//*package*//*private*/ Value /*P*/ handleOperandChangeImpl(Value /*P*/ From, Value /*P*/ To) {
    assert (isa_Constant(To)) : "Cannot make Constant refer to non-constant!";
    Constant /*P*/ ToC = cast_Constant(To);

    SmallVector<Constant /*P*/ > Values/*J*/= new SmallVector<Constant /*P*/ >(8, (Constant /*P*/ )null);
    Values.reserve(getNumOperands()); // Build replacement array.

    // Fill values with the modified operands of the constant array.  Also,
    // compute whether this turns into an all-zeros array.
    /*uint*/int NumUpdated = 0;

    // Keep track of whether all the values in the array are "ToC".
    boolean AllSame = true;
    type$ptr<Use /*P*/> OperandList = $tryClone(getOperandList());
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
    {

      // Check for any other type of constant-folding.
      Constant /*P*/ C = getImpl(getType(), new ArrayRef<Constant /*P*/ >(Values, true));
      if ((C != null)) {
        return C;
      }
    }

    // Update to the new value.
    return getContext().pImpl.ArrayConstants.replaceOperandsInPlace(new ArrayRef<Constant /*P*/ >(Values, true), this, From, ToC, NumUpdated, OperandNo);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantArray::ConstantArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 886,
   FQN="llvm::ConstantArray::ConstantArray", NM="_ZN4llvm13ConstantArrayC1EPNS_9ArrayTypeENS_8ArrayRefIPNS_8ConstantEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm13ConstantArrayC1EPNS_9ArrayTypeENS_8ArrayRefIPNS_8ConstantEEE")
  //</editor-fold>
  /*friend*/public/*private*/ ConstantArray(ArrayType /*P*/ T, ArrayRef<Constant /*P*/ > V) {
    // : ConstantAggregate(T, ConstantArrayVal, V)
    //START JInit
    super(T, ValueTy.ConstantArrayVal, new ArrayRef<Constant /*P*/ >(V));
    //END JInit
    assert ($uint2ullong(V.size()) == T.getNumElements()) : "Invalid initializer for constant array";
  }

/*public:*/
  // ConstantArray accessors
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantArray::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 892,
   FQN="llvm::ConstantArray::get", NM="_ZN4llvm13ConstantArray3getEPNS_9ArrayTypeENS_8ArrayRefIPNS_8ConstantEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm13ConstantArray3getEPNS_9ArrayTypeENS_8ArrayRefIPNS_8ConstantEEE")
  //</editor-fold>
  public static Constant /*P*/ get(ArrayType /*P*/ Ty, ArrayRef<Constant /*P*/ > V) {
    {
      Constant /*P*/ C = ConstantArray.getImpl(Ty, new ArrayRef<Constant /*P*/ >(V));
      if ((C != null)) {
        return C;
      }
    }
    return Ty.getContext().pImpl.ArrayConstants.getOrCreate(Ty, new ConstantAggrKeyType<ConstantArray, ArrayType>(new ArrayRef<Constant /*P*/ >(V)));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantArray::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 898,
   FQN="llvm::ConstantArray::getImpl", NM="_ZN4llvm13ConstantArray7getImplEPNS_9ArrayTypeENS_8ArrayRefIPNS_8ConstantEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm13ConstantArray7getImplEPNS_9ArrayTypeENS_8ArrayRefIPNS_8ConstantEEE")
  //</editor-fold>
  private static Constant /*P*/ getImpl(ArrayType /*P*/ Ty, ArrayRef<Constant /*P*/ > V) {
    // Empty arrays are canonicalized to ConstantAggregateZero.
    if (V.empty()) {
      return ConstantAggregateZero.get(Ty);
    }

    for (/*uint*/int i = 0, e = V.size(); i != e; ++i) {
      assert (V.$at(i).getType() == Ty.getElementType()) : "Wrong type in array element initializer";
    }

    // If this is an all-zero array, return a ConstantAggregateZero object.  If
    // all undef, return an UndefValue, if "all simple", then return a
    // ConstantDataArray.
    Constant /*P*/ C = V.$at(0);
    if (isa_UndefValue(C) && ConstantsStatics.rangeOnlyContains(V.begin(), V.end(), C)) {
      return UndefValue.get(Ty);
    }
    if (C.isNullValue() && ConstantsStatics.rangeOnlyContains(V.begin(), V.end(), C)) {
      return ConstantAggregateZero.get(Ty);
    }

    // Check to see if all of the elements are ConstantFP or ConstantInt and if
    // the element type is compatible with ConstantDataVector.  If so, use it.
    if (ConstantDataSequential.isElementTypeCompatible(C.getType())) {
      return ConstantsStatics.<ConstantDataArray>getSequenceIfElementsMatch(C, new ArrayRef<Constant /*P*/ >(V));
    }

    // Otherwise, we really do want to create a ConstantArray.
    return null;
  }

/*public:*/
  /// Specialize the getType() method to always return an ArrayType,
  /// which reduces the amount of casting needed in parts of the compiler.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantArray::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 410,
   FQN="llvm::ConstantArray::getType", NM="_ZNK4llvm13ConstantArray7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm13ConstantArray7getTypeEv")
  //</editor-fold>
  public /*inline*/ ArrayType /*P*/ getType() /*const*/ {
    return cast_ArrayType(super.getType());
  }


  /// Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantArray::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 415,
   FQN="llvm::ConstantArray::classof", NM="_ZN4llvm13ConstantArray7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm13ConstantArray7classofEPKNS_5ValueE")
  //</editor-fold>
  public static boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == ValueTy.ConstantArrayVal.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantArray::~ConstantArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 392,
   FQN="llvm::ConstantArray::~ConstantArray", NM="_ZN4llvm13ConstantArrayD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm13ConstantArrayD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
