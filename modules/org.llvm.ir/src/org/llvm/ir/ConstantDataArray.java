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
import static org.clank.support.Casts.*;
import static org.clank.support.Native.*;
import org.clank.support.NativeCallback.New$ConstructorCallback;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
/// An array constant whose element type is a simple 1/2/4/8-byte integer or
/// float/double, and whose elements are just simple data values
/// (i.e. ConstantInt/ConstantFP). This Constant node has no operands because it
/// stores all of the elements of the constant as densely packed data, instead
/// of as Value*'s.
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataArray">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 651,
 FQN="llvm::ConstantDataArray", NM="_ZN4llvm17ConstantDataArrayE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantDataArrayE")
//</editor-fold>
public final class ConstantDataArray extends /*public*/ ConstantDataSequential implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataArray::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 652,
   FQN="llvm::ConstantDataArray::operator new", NM="_ZN4llvm17ConstantDataArraynwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantDataArraynwEjj")
  //</editor-fold>
  protected/*private*/ static Object/*void P*/ $new_ConstantDataArray(/*size_t*/int $Prm0, /*uint*/int $Prm1) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataArray::ConstantDataArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 653,
   FQN="llvm::ConstantDataArray::ConstantDataArray", NM="_ZN4llvm17ConstantDataArrayC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantDataArrayC1ERKS0_")
  //</editor-fold>
  protected/*private*/ ConstantDataArray(final /*const*/ ConstantDataArray /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  
  //===----------------------------------------------------------------------===//
  //                       ConstantData* implementations
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataArray::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2288,
   FQN="llvm::ConstantDataArray::anchor", NM="_ZN4llvm17ConstantDataArray6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantDataArray6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  /*friend  class ConstantDataSequential*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataArray::ConstantDataArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 656,
   FQN="llvm::ConstantDataArray::ConstantDataArray", NM="_ZN4llvm17ConstantDataArrayC1EPNS_4TypeEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantDataArrayC1EPNS_4TypeEPKc")
  //</editor-fold>
  /*friend*//*private*/ /*explicit*/ ConstantDataArray(Type /*P*/ ty, /*const*/char$ptr/*char P*/ Data) {
    // : ConstantDataSequential(ty, ConstantDataArrayVal, Data) 
    //START JInit
    super(ty, ValueTy.ConstantDataArrayVal, Data);
    //END JInit
  }

  /// Allocate space for exactly zero operands.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataArray::operator new">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 659,
   FQN="llvm::ConstantDataArray::operator new", NM="_ZN4llvm17ConstantDataArraynwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantDataArraynwEj")
  //</editor-fold>
  /*friend*//*private*/ static ConstantDataArray/*void P*/ $new_ConstantDataArray(/*size_t s*/New$ConstructorCallback<ConstantDataArray> $Ctor) {
    return User.$new_FixedUses(/*s, */0, $Ctor);
  }

/*public:*/
  /// get() constructors - Return a constant with array type with an element
  /// count and element type matching the ArrayRef passed in.  Note that this
  /// can return a ConstantAggregateZero object.
  
  /// get() constructors - Return a constant with array type with an element
  /// count and element type matching the ArrayRef passed in.  Note that this
  /// can return a ConstantAggregateZero object.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataArray::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2416,
   FQN="llvm::ConstantDataArray::get", NM="_ZN4llvm17ConstantDataArray3getERNS_11LLVMContextENS_8ArrayRefIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantDataArray3getERNS_11LLVMContextENS_8ArrayRefIhEE")
  //</editor-fold>
  public static Constant /*P*/ get_LLVMContext_ArrayRefUChar(final LLVMContext /*&*/ Context, ArrayRefUChar Elts) {
    Type /*P*/ Ty = ArrayType.get(Type.getInt8Ty(Context), $uint2ulong(Elts.size()));
    /*const*/char$ptr/*char P*/ Data = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, Elts.data()));
    return getImpl(new StringRef(((/*const_cast*/char$ptr/*char P*/ )(Data)), Elts.size() * 1), Ty);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataArray::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2421,
   FQN="llvm::ConstantDataArray::get", NM="_ZN4llvm17ConstantDataArray3getERNS_11LLVMContextENS_8ArrayRefItEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantDataArray3getERNS_11LLVMContextENS_8ArrayRefItEE")
  //</editor-fold>
  public static Constant /*P*/ get_LLVMContext_ArrayRefUShort(final LLVMContext /*&*/ Context, ArrayRefUShort Elts) {
    Type /*P*/ Ty = ArrayType.get(Type.getInt16Ty(Context), $uint2ulong(Elts.size()));
    /*const*/char$ptr/*char P*/ Data = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, Elts.data()));
    return getImpl(new StringRef(((/*const_cast*/char$ptr/*char P*/ )(Data)), Elts.size() * 2), Ty);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataArray::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2426,
   FQN="llvm::ConstantDataArray::get", NM="_ZN4llvm17ConstantDataArray3getERNS_11LLVMContextENS_8ArrayRefIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantDataArray3getERNS_11LLVMContextENS_8ArrayRefIjEE")
  //</editor-fold>
  public static Constant /*P*/ get_LLVMContext_ArrayRefUInt(final LLVMContext /*&*/ Context, ArrayRefUInt Elts) {
    Type /*P*/ Ty = ArrayType.get(Type.getInt32Ty(Context), $uint2ulong(Elts.size()));
    /*const*/char$ptr/*char P*/ Data = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, Elts.data()));
    return getImpl(new StringRef(((/*const_cast*/char$ptr/*char P*/ )(Data)), Elts.size() * 4), Ty);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataArray::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2431,
   FQN="llvm::ConstantDataArray::get", NM="_ZN4llvm17ConstantDataArray3getERNS_11LLVMContextENS_8ArrayRefIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantDataArray3getERNS_11LLVMContextENS_8ArrayRefIyEE")
  //</editor-fold>
  public static Constant /*P*/ get_LLVMContext_ArrayRefULong(final LLVMContext /*&*/ Context, ArrayRefULong Elts) {
    Type /*P*/ Ty = ArrayType.get(Type.getInt64Ty(Context), $uint2ulong(Elts.size()));
    /*const*/char$ptr/*char P*/ Data = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, Elts.data()));
    return getImpl(new StringRef(((/*const_cast*/char$ptr/*char P*/ )(Data)), Elts.size() * 8), Ty);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataArray::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2436,
   FQN="llvm::ConstantDataArray::get", NM="_ZN4llvm17ConstantDataArray3getERNS_11LLVMContextENS_8ArrayRefIfEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantDataArray3getERNS_11LLVMContextENS_8ArrayRefIfEE")
  //</editor-fold>
  public static Constant /*P*/ get_LLVMContext_ArrayRefFloat(final LLVMContext /*&*/ Context, ArrayRefFloat Elts) {
    Type /*P*/ Ty = ArrayType.get(Type.getFloatTy(Context), $uint2ulong(Elts.size()));
    /*const*/char$ptr/*char P*/ Data = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, Elts.data()));
    return getImpl(new StringRef(((/*const_cast*/char$ptr/*char P*/ )(Data)), Elts.size() * 4), Ty);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataArray::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2441,
   FQN="llvm::ConstantDataArray::get", NM="_ZN4llvm17ConstantDataArray3getERNS_11LLVMContextENS_8ArrayRefIdEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantDataArray3getERNS_11LLVMContextENS_8ArrayRefIdEE")
  //</editor-fold>
  public static Constant /*P*/ get_LLVMContext_ArrayRefDouble(final LLVMContext /*&*/ Context, ArrayRefDouble Elts) {
    Type /*P*/ Ty = ArrayType.get(Type.getDoubleTy(Context), $uint2ulong(Elts.size()));
    /*const*/char$ptr/*char P*/ Data = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, Elts.data()));
    return getImpl(new StringRef(((/*const_cast*/char$ptr/*char P*/ )(Data)), Elts.size() * 8), Ty);
  }

  
  /// getFP() constructors - Return a constant with array type with an element
  /// count and element type of float with precision matching the number of
  /// bits in the ArrayRef passed in. (i.e. half for 16bits, float for 32bits,
  /// double for 64bits) Note that this can return a ConstantAggregateZero
  /// object.
  
  /// getFP() constructors - Return a constant with array type with an element
  /// count and element type of float with precision matching the number of
  /// bits in the ArrayRef passed in. (i.e. half for 16bits, float for 32bits,
  /// double for 64bits) Note that this can return a ConstantAggregateZero
  /// object.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataArray::getFP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2452,
   FQN="llvm::ConstantDataArray::getFP", NM="_ZN4llvm17ConstantDataArray5getFPERNS_11LLVMContextENS_8ArrayRefItEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantDataArray5getFPERNS_11LLVMContextENS_8ArrayRefItEE")
  //</editor-fold>
  public static Constant /*P*/ getFP_LLVMContext_ArrayRefUShort(final LLVMContext /*&*/ Context, 
       ArrayRefUShort Elts) {
    Type /*P*/ Ty = ArrayType.get(Type.getHalfTy(Context), $uint2ulong(Elts.size()));
    /*const*/char$ptr/*char P*/ Data = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, Elts.data()));
    return getImpl(new StringRef(((/*const_cast*/char$ptr/*char P*/ )(Data)), Elts.size() * 2), Ty);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataArray::getFP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2458,
   FQN="llvm::ConstantDataArray::getFP", NM="_ZN4llvm17ConstantDataArray5getFPERNS_11LLVMContextENS_8ArrayRefIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantDataArray5getFPERNS_11LLVMContextENS_8ArrayRefIjEE")
  //</editor-fold>
  public static Constant /*P*/ getFP_LLVMContext_ArrayRefUInt(final LLVMContext /*&*/ Context, 
       ArrayRefUInt Elts) {
    Type /*P*/ Ty = ArrayType.get(Type.getFloatTy(Context), $uint2ulong(Elts.size()));
    /*const*/char$ptr/*char P*/ Data = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, Elts.data()));
    return getImpl(new StringRef(((/*const_cast*/char$ptr/*char P*/ )(Data)), Elts.size() * 4), Ty);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataArray::getFP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2464,
   FQN="llvm::ConstantDataArray::getFP", NM="_ZN4llvm17ConstantDataArray5getFPERNS_11LLVMContextENS_8ArrayRefIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantDataArray5getFPERNS_11LLVMContextENS_8ArrayRefIyEE")
  //</editor-fold>
  public static Constant /*P*/ getFP_LLVMContext_ArrayRefULong(final LLVMContext /*&*/ Context, 
       ArrayRefULong Elts) {
    Type /*P*/ Ty = ArrayType.get(Type.getDoubleTy(Context), $uint2ulong(Elts.size()));
    /*const*/char$ptr/*char P*/ Data = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, Elts.data()));
    return getImpl(new StringRef(((/*const_cast*/char$ptr/*char P*/ )(Data)), Elts.size() * 8), Ty);
  }

  
  /// This method constructs a CDS and initializes it with a text string.
  /// The default behavior (AddNull==true) causes a null terminator to
  /// be placed at the end of the array (increasing the length of the string by
  /// one more than the StringRef would normally indicate.  Pass AddNull=false
  /// to disable this behavior.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataArray::getString">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2471,
   FQN="llvm::ConstantDataArray::getString", NM="_ZN4llvm17ConstantDataArray9getStringERNS_11LLVMContextENS_9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantDataArray9getStringERNS_11LLVMContextENS_9StringRefEb")
  //</editor-fold>
  public static Constant /*P*/ getString(final LLVMContext /*&*/ Context, 
           StringRef Str) {
    return getString(Context, 
           Str, true);
  }
  public static Constant /*P*/ getString(final LLVMContext /*&*/ Context, 
           StringRef Str, boolean AddNull/*= true*/) {
    if (!AddNull) {
      /*const*/uchar$ptr/*uint8_t*//*P*/ Data = $tryClone(reinterpret_cast(/*const*/uchar$ptr/*uint8_t*//*P*/ .class, Str.data()));
      return get_LLVMContext_ArrayRefUChar(Context, makeArrayRef$UChar(((/*const_cast*/uchar$ptr/*uint8_t*//*P*/ )(Data)), 
              Str.size(), false));
    }
    
    SmallVectorUChar ElementVals/*J*/= new SmallVectorUChar(64, (byte/*uint8_t*/)0);
    ElementVals.append_T(reinterpret_cast(uchar$ptr.class, Str.begin()), reinterpret_cast(uchar$ptr.class, Str.end()));
    ElementVals.push_back($int2uchar(0));
    return get_LLVMContext_ArrayRefUChar(Context, new ArrayRefUChar(ElementVals));
  }

  
  /// Specialize the getType() method to always return an ArrayType,
  /// which reduces the amount of casting needed in parts of the compiler.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataArray::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 693,
   FQN="llvm::ConstantDataArray::getType", NM="_ZNK4llvm17ConstantDataArray7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm17ConstantDataArray7getTypeEv")
  //</editor-fold>
  public /*inline*/ ArrayType /*P*/ getType() /*const*/ {
    return cast_ArrayType(super.getType());
  }

  
  /// Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataArray::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 698,
   FQN="llvm::ConstantDataArray::classof", NM="_ZN4llvm17ConstantDataArray7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantDataArray7classofEPKNS_5ValueE")
  //</editor-fold>
  public static boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == ValueTy.ConstantDataArrayVal.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantDataArray::~ConstantDataArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 651,
   FQN="llvm::ConstantDataArray::~ConstantDataArray", NM="_ZN4llvm17ConstantDataArrayD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm17ConstantDataArrayD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
