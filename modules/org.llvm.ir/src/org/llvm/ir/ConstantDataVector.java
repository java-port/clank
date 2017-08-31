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
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
/// A vector constant whose element type is a simple 1/2/4/8-byte integer or
/// float/double, and whose elements are just simple data values
/// (i.e. ConstantInt/ConstantFP). This Constant node has no operands because it
/// stores all of the elements of the constant as densely packed data, instead
/// of as Value*'s.
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataVector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 709,
 FQN="llvm::ConstantDataVector", NM="_ZN4llvm18ConstantDataVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm18ConstantDataVectorE")
//</editor-fold>
public final class ConstantDataVector extends /*public*/ ConstantDataSequential implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataVector::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 710,
   FQN="llvm::ConstantDataVector::operator new", NM="_ZN4llvm18ConstantDataVectornwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm18ConstantDataVectornwEjj")
  //</editor-fold>
  protected/*private*/ static Object/*void P*/ $new_ConstantDataVector(/*size_t*/int $Prm0, /*uint*/int $Prm1) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataVector::ConstantDataVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 711,
   FQN="llvm::ConstantDataVector::ConstantDataVector", NM="_ZN4llvm18ConstantDataVectorC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm18ConstantDataVectorC1ERKS0_")
  //</editor-fold>
  protected/*private*/ ConstantDataVector(final /*const*/ ConstantDataVector /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataVector::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2289,
   FQN="llvm::ConstantDataVector::anchor", NM="_ZN4llvm18ConstantDataVector6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm18ConstantDataVector6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  /*friend  class ConstantDataSequential*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataVector::ConstantDataVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 714,
   FQN="llvm::ConstantDataVector::ConstantDataVector", NM="_ZN4llvm18ConstantDataVectorC1EPNS_4TypeEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm18ConstantDataVectorC1EPNS_4TypeEPKc")
  //</editor-fold>
  /*friend*//*private*/ /*explicit*/ ConstantDataVector(Type /*P*/ ty, /*const*/char$ptr/*char P*/ Data) {
    // : ConstantDataSequential(ty, ConstantDataVectorVal, Data)
    //START JInit
    super(ty, ValueTy.ConstantDataVectorVal, Data);
    //END JInit
  }

  // allocate space for exactly zero operands.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataVector::operator new">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 717,
   FQN="llvm::ConstantDataVector::operator new", NM="_ZN4llvm18ConstantDataVectornwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm18ConstantDataVectornwEj")
  //</editor-fold>
  /*friend*//*private*/ static ConstantDataVector/*void P*/ $new_ConstantDataVector(New$ConstructorCallback<ConstantDataVector> $Ctor) {
    return User.$new_FixedUses(/*s, */0, $Ctor);
  }

/*public:*/
  /// get() constructors - Return a constant with vector type with an element
  /// count and element type matching the ArrayRef passed in.  Note that this
  /// can return a ConstantAggregateZero object.

  /// get() constructors - Return a constant with vector type with an element
  /// count and element type matching the ArrayRef passed in.  Note that this
  /// can return a ConstantAggregateZero object.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataVector::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2488,
   FQN="llvm::ConstantDataVector::get", NM="_ZN4llvm18ConstantDataVector3getERNS_11LLVMContextENS_8ArrayRefIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm18ConstantDataVector3getERNS_11LLVMContextENS_8ArrayRefIhEE")
  //</editor-fold>
  public static Constant /*P*/ get_LLVMContext_ArrayRefUChar(final LLVMContext /*&*/ Context, ArrayRefUChar Elts) {
    Type /*P*/ Ty = VectorType.get(Type.getInt8Ty(Context), Elts.size());
    /*const*/char$ptr/*char P*/ Data = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, Elts.data()));
    return getImpl(new StringRef(((/*const_cast*/char$ptr/*char P*/ )(Data)), Elts.size() * 1), Ty);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataVector::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2493,
   FQN="llvm::ConstantDataVector::get", NM="_ZN4llvm18ConstantDataVector3getERNS_11LLVMContextENS_8ArrayRefItEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm18ConstantDataVector3getERNS_11LLVMContextENS_8ArrayRefItEE")
  //</editor-fold>
  public static Constant /*P*/ get_LLVMContext_ArrayRefUShort(final LLVMContext /*&*/ Context, ArrayRefUShort Elts) {
    Type /*P*/ Ty = VectorType.get(Type.getInt16Ty(Context), Elts.size());
    /*const*/char$ptr/*char P*/ Data = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, Elts.data()));
    return getImpl(new StringRef(((/*const_cast*/char$ptr/*char P*/ )(Data)), Elts.size() * 2), Ty);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataVector::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2498,
   FQN="llvm::ConstantDataVector::get", NM="_ZN4llvm18ConstantDataVector3getERNS_11LLVMContextENS_8ArrayRefIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm18ConstantDataVector3getERNS_11LLVMContextENS_8ArrayRefIjEE")
  //</editor-fold>
  public static Constant /*P*/ get_LLVMContext_ArrayRefUInt(final LLVMContext /*&*/ Context, ArrayRefUInt Elts) {
    Type /*P*/ Ty = VectorType.get(Type.getInt32Ty(Context), Elts.size());
    /*const*/char$ptr/*char P*/ Data = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, Elts.data()));
    return getImpl(new StringRef(((/*const_cast*/char$ptr/*char P*/ )(Data)), Elts.size() * 4), Ty);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataVector::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2503,
   FQN="llvm::ConstantDataVector::get", NM="_ZN4llvm18ConstantDataVector3getERNS_11LLVMContextENS_8ArrayRefIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm18ConstantDataVector3getERNS_11LLVMContextENS_8ArrayRefIyEE")
  //</editor-fold>
  public static Constant /*P*/ get_LLVMContext_ArrayRefULong(final LLVMContext /*&*/ Context, ArrayRefULong Elts) {
    Type /*P*/ Ty = VectorType.get(Type.getInt64Ty(Context), Elts.size());
    /*const*/char$ptr/*char P*/ Data = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, Elts.data()));
    return getImpl(new StringRef(((/*const_cast*/char$ptr/*char P*/ )(Data)), Elts.size() * 8), Ty);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataVector::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2508,
   FQN="llvm::ConstantDataVector::get", NM="_ZN4llvm18ConstantDataVector3getERNS_11LLVMContextENS_8ArrayRefIfEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm18ConstantDataVector3getERNS_11LLVMContextENS_8ArrayRefIfEE")
  //</editor-fold>
  public static Constant /*P*/ get_LLVMContext_ArrayRefFloat(final LLVMContext /*&*/ Context, ArrayRefFloat Elts) {
    Type /*P*/ Ty = VectorType.get(Type.getFloatTy(Context), Elts.size());
    /*const*/char$ptr/*char P*/ Data = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, Elts.data()));
    return getImpl(new StringRef(((/*const_cast*/char$ptr/*char P*/ )(Data)), Elts.size() * 4), Ty);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataVector::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2513,
   FQN="llvm::ConstantDataVector::get", NM="_ZN4llvm18ConstantDataVector3getERNS_11LLVMContextENS_8ArrayRefIdEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm18ConstantDataVector3getERNS_11LLVMContextENS_8ArrayRefIdEE")
  //</editor-fold>
  public static Constant /*P*/ get_LLVMContext_ArrayRefDouble(final LLVMContext /*&*/ Context, ArrayRefDouble Elts) {
    Type /*P*/ Ty = VectorType.get(Type.getDoubleTy(Context), Elts.size());
    /*const*/char$ptr/*char P*/ Data = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, Elts.data()));
    return getImpl(new StringRef(((/*const_cast*/char$ptr/*char P*/ )(Data)), Elts.size() * 8), Ty);
  }


  /// getFP() constructors - Return a constant with vector type with an element
  /// count and element type of float with the precision matching the number of
  /// bits in the ArrayRef passed in.  (i.e. half for 16bits, float for 32bits,
  /// double for 64bits) Note that this can return a ConstantAggregateZero
  /// object.

  /// getFP() constructors - Return a constant with vector type with an element
  /// count and element type of float with the precision matching the number of
  /// bits in the ArrayRef passed in.  (i.e. half for 16bits, float for 32bits,
  /// double for 64bits) Note that this can return a ConstantAggregateZero
  /// object.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataVector::getFP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2524,
   FQN="llvm::ConstantDataVector::getFP", NM="_ZN4llvm18ConstantDataVector5getFPERNS_11LLVMContextENS_8ArrayRefItEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm18ConstantDataVector5getFPERNS_11LLVMContextENS_8ArrayRefItEE")
  //</editor-fold>
  public static Constant /*P*/ getFP_LLVMContext_ArrayRefUShort(final LLVMContext /*&*/ Context,
                                  ArrayRefUShort Elts) {
    Type /*P*/ Ty = VectorType.get(Type.getHalfTy(Context), Elts.size());
    /*const*/char$ptr/*char P*/ Data = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, Elts.data()));
    return getImpl(new StringRef(((/*const_cast*/char$ptr/*char P*/ )(Data)), Elts.size() * 2), Ty);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataVector::getFP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2530,
   FQN="llvm::ConstantDataVector::getFP", NM="_ZN4llvm18ConstantDataVector5getFPERNS_11LLVMContextENS_8ArrayRefIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm18ConstantDataVector5getFPERNS_11LLVMContextENS_8ArrayRefIjEE")
  //</editor-fold>
  public static Constant /*P*/ getFP_LLVMContext_ArrayRefUInt(final LLVMContext /*&*/ Context,
                                ArrayRefUInt Elts) {
    Type /*P*/ Ty = VectorType.get(Type.getFloatTy(Context), Elts.size());
    /*const*/char$ptr/*char P*/ Data = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, Elts.data()));
    return getImpl(new StringRef(((/*const_cast*/char$ptr/*char P*/ )(Data)), Elts.size() * 4), Ty);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataVector::getFP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2536,
   FQN="llvm::ConstantDataVector::getFP", NM="_ZN4llvm18ConstantDataVector5getFPERNS_11LLVMContextENS_8ArrayRefIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm18ConstantDataVector5getFPERNS_11LLVMContextENS_8ArrayRefIyEE")
  //</editor-fold>
  public static Constant /*P*/ getFP_LLVMContext_ArrayRefULong(final LLVMContext /*&*/ Context,
                                 ArrayRefULong Elts) {
    Type /*P*/ Ty = VectorType.get(Type.getDoubleTy(Context), Elts.size());
    /*const*/char$ptr/*char P*/ Data = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, Elts.data()));
    return getImpl(new StringRef(((/*const_cast*/char$ptr/*char P*/ )(Data)), Elts.size() * 8), Ty);
  }


  /// Return a ConstantVector with the specified constant in each element.
  /// The specified constant has to be a of a compatible type (i8/i16/
  /// i32/i64/float/double) and must be a ConstantFP or ConstantInt.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataVector::getSplat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2543,
   FQN="llvm::ConstantDataVector::getSplat", NM="_ZN4llvm18ConstantDataVector8getSplatEjPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm18ConstantDataVector8getSplatEjPNS_8ConstantE")
  //</editor-fold>
  public static Constant /*P*/ getSplat(/*uint*/int NumElts, Constant /*P*/ V) {
    assert (isElementTypeCompatible(V.getType())) : "Element type not compatible with ConstantData";
    {
      ConstantInt /*P*/ CI = dyn_cast_ConstantInt(V);
      if ((CI != null)) {
        if (CI.getType().isIntegerTy(8)) {
          SmallVectorUChar Elts/*J*/= new SmallVectorUChar(JD$UInt_T$C$R.INSTANCE, 16, NumElts, $ulong2uchar(CI.getZExtValue()), (byte/*uint8_t*/)0);
          return get_LLVMContext_ArrayRefUChar(V.getContext(), new ArrayRefUChar(Elts));
        }
        if (CI.getType().isIntegerTy(16)) {
          SmallVectorUShort Elts/*J*/= new SmallVectorUShort(JD$UInt_T$C$R.INSTANCE, 16, NumElts, $ulong2ushort(CI.getZExtValue()), (/*uint16_t*/char)0);
          return get_LLVMContext_ArrayRefUShort(V.getContext(), new ArrayRefUShort(Elts));
        }
        if (CI.getType().isIntegerTy(32)) {
          SmallVectorUInt Elts/*J*/= new SmallVectorUInt(JD$UInt_T$C$R.INSTANCE, 16, NumElts, $ulong2uint(CI.getZExtValue()), (/*uint32_t*/int)0);
          return get_LLVMContext_ArrayRefUInt(V.getContext(), new ArrayRefUInt(Elts));
        }
        assert (CI.getType().isIntegerTy(64)) : "Unsupported ConstantData type";
        SmallVectorULong Elts/*J*/= new SmallVectorULong(JD$UInt_T$C$R.INSTANCE, 16, NumElts, CI.getZExtValue(), (long/*uint64_t*/)0);
        return get_LLVMContext_ArrayRefULong(V.getContext(), new ArrayRefULong(Elts));
      }
    }
    {

      ConstantFP /*P*/ CFP = dyn_cast_ConstantFP(V);
      if ((CFP != null)) {
        if (CFP.getType().isHalfTy()) {
          SmallVectorUShort Elts/*J*/= new SmallVectorUShort(JD$UInt_T$C$R.INSTANCE, 16, NumElts, $ulong2ushort(CFP.getValueAPF().bitcastToAPInt().getLimitedValue()), (/*uint16_t*/char)0);
          return getFP_LLVMContext_ArrayRefUShort(V.getContext(), new ArrayRefUShort(Elts));
        }
        if (CFP.getType().isFloatTy()) {
          SmallVectorUInt Elts/*J*/= new SmallVectorUInt(JD$UInt_T$C$R.INSTANCE, 16, NumElts, $ulong2uint(CFP.getValueAPF().bitcastToAPInt().getLimitedValue()), (/*uint32_t*/int)0);
          return getFP_LLVMContext_ArrayRefUInt(V.getContext(), new ArrayRefUInt(Elts));
        }
        if (CFP.getType().isDoubleTy()) {
          SmallVectorULong Elts/*J*/= new SmallVectorULong(JD$UInt_T$C$R.INSTANCE, 16, NumElts, CFP.getValueAPF().bitcastToAPInt().getLimitedValue(), (long/*uint64_t*/)0);
          return getFP_LLVMContext_ArrayRefULong(V.getContext(), new ArrayRefULong(Elts));
        }
      }
    }
    return ConstantVector.getSplat(NumElts, V);
  }


  /// If this is a splat constant, meaning that all of the elements have the
  /// same value, return that value. Otherwise return NULL.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataVector::getSplatValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2666,
   FQN="llvm::ConstantDataVector::getSplatValue", NM="_ZNK4llvm18ConstantDataVector13getSplatValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm18ConstantDataVector13getSplatValueEv")
  //</editor-fold>
  public Constant /*P*/ getSplatValue() /*const*/ {
    /*const*/char$ptr/*char P*/ Base = $tryClone(getRawDataValues().data());

    // Compare elements 1+ to the 0'th element.
    /*uint*/int EltSize = $ulong2uint(getElementByteSize());
    for (/*uint*/int i = 1, e = getNumElements(); i != e; ++i)  {
      if ((memcmp(Base, Base.$add(i * EltSize), EltSize) != 0)) {
        return null;
      }
    }

    // If they're all the same, return the 0th one as a representative.
    return getElementAsConstant(0);
  }


  /// Specialize the getType() method to always return a VectorType,
  /// which reduces the amount of casting needed in parts of the compiler.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataVector::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 752,
   FQN="llvm::ConstantDataVector::getType", NM="_ZNK4llvm18ConstantDataVector7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm18ConstantDataVector7getTypeEv")
  //</editor-fold>
  public /*inline*/ VectorType /*P*/ getType() /*const*/ {
    return cast_VectorType(super.getType());
  }


  /// Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataVector::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 757,
   FQN="llvm::ConstantDataVector::classof", NM="_ZN4llvm18ConstantDataVector7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm18ConstantDataVector7classofEPKNS_5ValueE")
  //</editor-fold>
  public static boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == ValueTy.ConstantDataVectorVal.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataVector::~ConstantDataVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 709,
   FQN="llvm::ConstantDataVector::~ConstantDataVector", NM="_ZN4llvm18ConstantDataVectorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm18ConstantDataVectorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
