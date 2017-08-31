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
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.ir.impl.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
/// This is the shared class of boolean and integer constants. This class
/// represents both boolean and integral constants.
/// @brief Class for constant integers.
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 75,
 FQN="llvm::ConstantInt", NM="_ZN4llvm11ConstantIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm11ConstantIntE")
//</editor-fold>
public final class ConstantInt extends /*public*/ ConstantData implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  //                                ConstantInt
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 501,
   FQN="llvm::ConstantInt::anchor", NM="_ZN4llvm11ConstantInt6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm11ConstantInt6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::ConstantInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 77,
   FQN="llvm::ConstantInt::ConstantInt", NM="_ZN4llvm11ConstantIntC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm11ConstantIntC1ERKS0_")
  //</editor-fold>
  protected/*private*/ ConstantInt(final /*const*/ ConstantInt /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::ConstantInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 503,
   FQN="llvm::ConstantInt::ConstantInt", NM="_ZN4llvm11ConstantIntC1EPNS_11IntegerTypeERKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm11ConstantIntC1EPNS_11IntegerTypeERKNS_5APIntE")
  //</editor-fold>
  private ConstantInt(IntegerType /*P*/ Ty, final /*const*/ APInt /*&*/ V) {
    // : ConstantData(Ty, ConstantIntVal), Val(V) 
    //START JInit
    super(Ty, ValueTy.ConstantIntVal);
    this.Val = new APInt(V);
    //END JInit
    assert (V.getBitWidth() == Ty.getBitWidth()) : "Invalid constant for type";
  }

  private APInt Val;
  
  /*friend  class Constant*/
  
  /// Remove the constant from the constant table.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::destroyConstantImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 599,
   FQN="llvm::ConstantInt::destroyConstantImpl", NM="_ZN4llvm11ConstantInt19destroyConstantImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm11ConstantInt19destroyConstantImplEv")
  //</editor-fold>
  /*friend*//*package*/ void destroyConstantImpl() {
    throw new llvm_unreachable("You can't ConstantInt->destroyConstantImpl()!");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::getTrue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 508,
   FQN="llvm::ConstantInt::getTrue", NM="_ZN4llvm11ConstantInt7getTrueERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm11ConstantInt7getTrueERNS_11LLVMContextE")
  //</editor-fold>
  public static ConstantInt /*P*/ getTrue(final LLVMContext /*&*/ Context) {
    LLVMContextImpl /*P*/ pImpl = Context.pImpl;
    if (!(pImpl.TheTrueVal != null)) {
      pImpl.TheTrueVal = ConstantInt.get(Type.getInt1Ty(Context), $int2ulong(1));
    }
    return pImpl.TheTrueVal;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::getFalse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 515,
   FQN="llvm::ConstantInt::getFalse", NM="_ZN4llvm11ConstantInt8getFalseERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm11ConstantInt8getFalseERNS_11LLVMContextE")
  //</editor-fold>
  public static ConstantInt /*P*/ getFalse(final LLVMContext /*&*/ Context) {
    LLVMContextImpl /*P*/ pImpl = Context.pImpl;
    if (!(pImpl.TheFalseVal != null)) {
      pImpl.TheFalseVal = ConstantInt.get(Type.getInt1Ty(Context), $int2ulong(0));
    }
    return pImpl.TheFalseVal;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::getTrue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 522,
   FQN="llvm::ConstantInt::getTrue", NM="_ZN4llvm11ConstantInt7getTrueEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm11ConstantInt7getTrueEPNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ getTrue(Type /*P*/ Ty) {
    VectorType /*P*/ VTy = dyn_cast_VectorType(Ty);
    if (!(VTy != null)) {
      assert (Ty.isIntegerTy(1)) : "True must be i1 or vector of i1.";
      return ConstantInt.getTrue(Ty.getContext());
    }
    assert (VTy.getElementType().isIntegerTy(1)) : "True must be vector of i1 or i1.";
    return ConstantVector.getSplat(VTy.getNumElements(), 
        ConstantInt.getTrue(Ty.getContext()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::getFalse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 534,
   FQN="llvm::ConstantInt::getFalse", NM="_ZN4llvm11ConstantInt8getFalseEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm11ConstantInt8getFalseEPNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ getFalse(Type /*P*/ Ty) {
    VectorType /*P*/ VTy = dyn_cast_VectorType(Ty);
    if (!(VTy != null)) {
      assert (Ty.isIntegerTy(1)) : "False must be i1 or vector of i1.";
      return ConstantInt.getFalse(Ty.getContext());
    }
    assert (VTy.getElementType().isIntegerTy(1)) : "False must be vector of i1 or i1.";
    return ConstantVector.getSplat(VTy.getNumElements(), 
        ConstantInt.getFalse(Ty.getContext()));
  }

  
  /// If Ty is a vector type, return a Constant with a splat of the given
  /// value. Otherwise return a ConstantInt for the given value.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 560,
   FQN="llvm::ConstantInt::get", NM="_ZN4llvm11ConstantInt3getEPNS_4TypeEyb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm11ConstantInt3getEPNS_4TypeEyb")
  //</editor-fold>
  public static Constant /*P*/ get(Type /*P*/ Ty, long/*uint64_t*/ V) {
    return get(Ty, V, false);
  }
  public static Constant /*P*/ get(Type /*P*/ Ty, long/*uint64_t*/ V, boolean isSigned/*= false*/) {
    Constant /*P*/ C = ConstantInt.get(cast_IntegerType(Ty.getScalarType()), V, isSigned);
    {
      
      // For vectors, broadcast the value.
      VectorType /*P*/ VTy = dyn_cast_VectorType(Ty);
      if ((VTy != null)) {
        return ConstantVector.getSplat(VTy.getNumElements(), C);
      }
    }
    
    return C;
  }

  
  /// Return a ConstantInt with the specified integer value for the specified
  /// type. If the type is wider than 64 bits, the value will be zero-extended
  /// to fit the type, unless isSigned is true, in which case the value will
  /// be interpreted as a 64-bit signed integer and sign-extended to fit
  /// the type.
  /// @brief Get a ConstantInt for a specific value.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 570,
   FQN="llvm::ConstantInt::get", NM="_ZN4llvm11ConstantInt3getEPNS_11IntegerTypeEyb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm11ConstantInt3getEPNS_11IntegerTypeEyb")
  //</editor-fold>
  public static ConstantInt /*P*/ get(IntegerType /*P*/ Ty, long/*uint64_t*/ V) {
    return get(Ty, V, false);
  }
  public static ConstantInt /*P*/ get(IntegerType /*P*/ Ty, long/*uint64_t*/ V, boolean isSigned/*= false*/) {
    return get(Ty.getContext(), new APInt(JD$UInt_ULong.INSTANCE, Ty.getBitWidth(), V, isSigned));
  }

  
  /// Return a ConstantInt with the specified value for the specified type. The
  /// value V will be canonicalized to a an unsigned APInt. Accessing it with
  /// either getSExtValue() or getZExtValue() will yield a correctly sized and
  /// signed value for the type Ty.
  /// @brief Get a ConstantInt for a specific signed value.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::getSigned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 574,
   FQN="llvm::ConstantInt::getSigned", NM="_ZN4llvm11ConstantInt9getSignedEPNS_11IntegerTypeEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm11ConstantInt9getSignedEPNS_11IntegerTypeEx")
  //</editor-fold>
  public static ConstantInt /*P*/ getSigned(IntegerType /*P*/ Ty, long/*int64_t*/ V) {
    return get(Ty, V, true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::getSigned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 578,
   FQN="llvm::ConstantInt::getSigned", NM="_ZN4llvm11ConstantInt9getSignedEPNS_4TypeEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm11ConstantInt9getSignedEPNS_4TypeEx")
  //</editor-fold>
  public static Constant /*P*/ getSigned(Type /*P*/ Ty, long/*int64_t*/ V) {
    return get(Ty, V, true);
  }

  
  /// Return a ConstantInt with the specified value and an implied Type. The
  /// type is the integer type that corresponds to the bit width of the value.
  
  // Get a ConstantInt from an APInt.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 547,
   FQN="llvm::ConstantInt::get", NM="_ZN4llvm11ConstantInt3getERNS_11LLVMContextERKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm11ConstantInt3getERNS_11LLVMContextERKNS_5APIntE")
  //</editor-fold>
  public static ConstantInt /*P*/ get(final LLVMContext /*&*/ Context, final /*const*/ APInt /*&*/ V) {
    // get an existing value or the insertion position
    LLVMContextImpl /*P*/ pImpl = Context.pImpl;
    final type$ref<ConstantInt /*P*/ /*&*/> Slot = pImpl.IntConstants.ref$at(V);
    if (!(Slot.$deref() != null)) {
      // Get the corresponding integer type for the bit width of the value.
      IntegerType /*P*/ ITy = IntegerType.get(Context, V.getBitWidth());
      Slot.$set(/*NEW_EXPR [ConstantData::new]*/ConstantData.$new_ConstantData((type$ptr<?> New$Mem)->{
          return new ConstantInt(ITy, V);
       }));
    }
    assert (Slot.$deref().getType() == IntegerType.get(Context, V.getBitWidth()));
    return Slot.$deref();
  }

  
  /// Return a ConstantInt constructed from the string strStart with the given
  /// radix.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 594,
   FQN="llvm::ConstantInt::get", NM="_ZN4llvm11ConstantInt3getEPNS_11IntegerTypeENS_9StringRefEh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm11ConstantInt3getEPNS_11IntegerTypeENS_9StringRefEh")
  //</editor-fold>
  public static ConstantInt /*P*/ get(IntegerType /*P*/ Ty, StringRef Str, byte/*uint8_t*/ radix) {
    return get(Ty.getContext(), new APInt(Ty.getBitWidth(), new StringRef(Str), radix));
  }

  
  /// If Ty is a vector type, return a Constant with a splat of the given
  /// value. Otherwise return a ConstantInt for the given value.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 582,
   FQN="llvm::ConstantInt::get", NM="_ZN4llvm11ConstantInt3getEPNS_4TypeERKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm11ConstantInt3getEPNS_4TypeERKNS_5APIntE")
  //</editor-fold>
  public static Constant /*P*/ get(Type /*P*/ Ty, final /*const*/ APInt /*&*/ V) {
    ConstantInt /*P*/ C = get(Ty.getContext(), V);
    assert (C.getType() == Ty.getScalarType()) : "ConstantInt type doesn't match the type implied by its value!";
    {
      
      // For vectors, broadcast the value.
      VectorType /*P*/ VTy = dyn_cast_VectorType(Ty);
      if ((VTy != null)) {
        return ConstantVector.getSplat(VTy.getNumElements(), C);
      }
    }
    
    return C;
  }

  
  /// Return the constant as an APInt value reference. This allows clients to
  /// obtain a copy of the value, with all its precision in tact.
  /// @brief Return the constant's value.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 127,
   FQN="llvm::ConstantInt::getValue", NM="_ZNK4llvm11ConstantInt8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm11ConstantInt8getValueEv")
  //</editor-fold>
  public /*inline*/ /*const*/ APInt /*&*/ getValue() /*const*/ {
    return Val;
  }

  
  /// getBitWidth - Return the bitwidth of this constant.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::getBitWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 132,
   FQN="llvm::ConstantInt::getBitWidth", NM="_ZNK4llvm11ConstantInt11getBitWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm11ConstantInt11getBitWidthEv")
  //</editor-fold>
  public /*uint*/int getBitWidth() /*const*/ {
    return Val.getBitWidth();
  }

  
  /// Return the constant as a 64-bit unsigned integer value after it
  /// has been zero extended as appropriate for the type of this constant. Note
  /// that this method can assert if the value does not fit in 64 bits.
  /// @brief Return the zero extended value.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::getZExtValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 138,
   FQN="llvm::ConstantInt::getZExtValue", NM="_ZNK4llvm11ConstantInt12getZExtValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm11ConstantInt12getZExtValueEv")
  //</editor-fold>
  public /*inline*/ long/*uint64_t*/ getZExtValue() /*const*/ {
    return Val.getZExtValue();
  }

  
  /// Return the constant as a 64-bit integer value after it has been sign
  /// extended as appropriate for the type of this constant. Note that
  /// this method can assert if the value does not fit in 64 bits.
  /// @brief Return the sign extended value.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::getSExtValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 146,
   FQN="llvm::ConstantInt::getSExtValue", NM="_ZNK4llvm11ConstantInt12getSExtValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm11ConstantInt12getSExtValueEv")
  //</editor-fold>
  public /*inline*/ long/*int64_t*/ getSExtValue() /*const*/ {
    return Val.getSExtValue();
  }

  
  /// A helper method that can be used to determine if the constant contained
  /// within is equal to a constant.  This only works for very small values,
  /// because this is all that can be represented with all types.
  /// @brief Determine if this constant's value is same as an unsigned char.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::equalsInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 154,
   FQN="llvm::ConstantInt::equalsInt", NM="_ZNK4llvm11ConstantInt9equalsIntEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm11ConstantInt9equalsIntEy")
  //</editor-fold>
  public boolean equalsInt(long/*uint64_t*/ V) /*const*/ {
    return Val.$eq(V);
  }

  
  /// getType - Specialize the getType() method to always return an IntegerType,
  /// which reduces the amount of casting needed in parts of the compiler.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 161,
   FQN="llvm::ConstantInt::getType", NM="_ZNK4llvm11ConstantInt7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm11ConstantInt7getTypeEv")
  //</editor-fold>
  public /*inline*/ IntegerType /*P*/ getType() /*const*/ {
    return cast_IntegerType(super.getType());
  }

  
  /// This static method returns true if the type Ty is big enough to
  /// represent the value V. This can be used to avoid having the get method
  /// assert when V is larger than Ty can represent. Note that there are two
  /// versions of this method, one for unsigned and one for signed integers.
  /// Although ConstantInt canonicalizes everything to an unsigned integer,
  /// the signed version avoids callers having to convert a signed quantity
  /// to the appropriate unsigned type before calling the method.
  /// @returns true if V is a valid value for type Ty
  /// @brief Determine if the value is in range for the given type.
  
  //===----------------------------------------------------------------------===//
  //                      isValueValidForType implementations
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::isValueValidForType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1189,
   FQN="llvm::ConstantInt::isValueValidForType", NM="_ZN4llvm11ConstantInt19isValueValidForTypeEPNS_4TypeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm11ConstantInt19isValueValidForTypeEPNS_4TypeEy")
  //</editor-fold>
  public static boolean isValueValidForType_Type$P_ulong(Type /*P*/ Ty, long/*uint64_t*/ Val) {
    /*uint*/int NumBits = Ty.getIntegerBitWidth(); // assert okay
    if (Ty.isIntegerTy(1)) {
      return Val == $int2ullong(0) || Val == $int2ullong(1);
    }
    if ($greatereq_uint(NumBits, 64)) {
      return true; // always true, has to fit in largest type
    }
    long/*uint64_t*/ Max = (1L/*LL*/ << NumBits) - 1;
    return $lesseq_ulong(Val, Max);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::isValueValidForType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1199,
   FQN="llvm::ConstantInt::isValueValidForType", NM="_ZN4llvm11ConstantInt19isValueValidForTypeEPNS_4TypeEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm11ConstantInt19isValueValidForTypeEPNS_4TypeEx")
  //</editor-fold>
  public static boolean isValueValidForType_Type$P_long(Type /*P*/ Ty, long/*int64_t*/ Val) {
    /*uint*/int NumBits = Ty.getIntegerBitWidth();
    if (Ty.isIntegerTy(1)) {
      return Val == 0 || Val == 1 || Val == -1;
    }
    if ($greatereq_uint(NumBits, 64)) {
      return true; // always true, has to fit in largest type
    }
    long/*int64_t*/ Min = -(1L/*LL*/ << (NumBits - 1));
    long/*int64_t*/ Max = (1L/*LL*/ << (NumBits - 1)) - 1;
    return (Val >= Min && Val <= Max);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::isNegative">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 177,
   FQN="llvm::ConstantInt::isNegative", NM="_ZNK4llvm11ConstantInt10isNegativeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm11ConstantInt10isNegativeEv")
  //</editor-fold>
  public boolean isNegative() /*const*/ {
    return Val.isNegative();
  }

  
  /// This is just a convenience method to make client code smaller for a
  /// common code. It also correctly performs the comparison without the
  /// potential for an assertion from getZExtValue().
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::isZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 182,
   FQN="llvm::ConstantInt::isZero", NM="_ZNK4llvm11ConstantInt6isZeroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm11ConstantInt6isZeroEv")
  //</editor-fold>
  public boolean isZero() /*const*/ {
    return Val.$eq($int2ulong(0));
  }

  
  /// This is just a convenience method to make client code smaller for a
  /// common case. It also correctly performs the comparison without the
  /// potential for an assertion from getZExtValue().
  /// @brief Determine if the value is one.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::isOne">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 190,
   FQN="llvm::ConstantInt::isOne", NM="_ZNK4llvm11ConstantInt5isOneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm11ConstantInt5isOneEv")
  //</editor-fold>
  public boolean isOne() /*const*/ {
    return Val.$eq($int2ulong(1));
  }

  
  /// This function will return true iff every bit in this constant is set
  /// to true.
  /// @returns true iff this constant's bits are all set to true.
  /// @brief Determine if the value is all ones.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::isMinusOne">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 198,
   FQN="llvm::ConstantInt::isMinusOne", NM="_ZNK4llvm11ConstantInt10isMinusOneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm11ConstantInt10isMinusOneEv")
  //</editor-fold>
  public boolean isMinusOne() /*const*/ {
    return Val.isAllOnesValue();
  }

  
  /// This function will return true iff this constant represents the largest
  /// value that may be represented by the constant's type.
  /// @returns true iff this is the largest value that may be represented
  /// by this type.
  /// @brief Determine if the value is maximal.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::isMaxValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 207,
   FQN="llvm::ConstantInt::isMaxValue", NM="_ZNK4llvm11ConstantInt10isMaxValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm11ConstantInt10isMaxValueEb")
  //</editor-fold>
  public boolean isMaxValue(boolean isSigned) /*const*/ {
    if (isSigned) {
      return Val.isMaxSignedValue();
    } else {
      return Val.isMaxValue();
    }
  }

  
  /// This function will return true iff this constant represents the smallest
  /// value that may be represented by this constant's type.
  /// @returns true if this is the smallest value that may be represented by
  /// this type.
  /// @brief Determine if the value is minimal.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::isMinValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 219,
   FQN="llvm::ConstantInt::isMinValue", NM="_ZNK4llvm11ConstantInt10isMinValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm11ConstantInt10isMinValueEb")
  //</editor-fold>
  public boolean isMinValue(boolean isSigned) /*const*/ {
    if (isSigned) {
      return Val.isMinSignedValue();
    } else {
      return Val.isMinValue();
    }
  }

  
  /// This function will return true iff this constant represents a value with
  /// active bits bigger than 64 bits or a value greater than the given uint64_t
  /// value.
  /// @returns true iff this constant is greater or equal to the given number.
  /// @brief Determine if the value is greater or equal to the given number.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::uge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 231,
   FQN="llvm::ConstantInt::uge", NM="_ZNK4llvm11ConstantInt3ugeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm11ConstantInt3ugeEy")
  //</editor-fold>
  public boolean uge(long/*uint64_t*/ Num) /*const*/ {
    return $greater_uint(Val.getActiveBits(), 64) || $greatereq_ulong(Val.getZExtValue(), Num);
  }

  
  /// getLimitedValue - If the value is smaller than the specified limit,
  /// return it, otherwise return the limit value.  This causes the value
  /// to saturate to the limit.
  /// @returns the min of the value of the constant and the specified value
  /// @brief Get the constant's value with a saturation limit
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::getLimitedValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 240,
   FQN="llvm::ConstantInt::getLimitedValue", NM="_ZNK4llvm11ConstantInt15getLimitedValueEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm11ConstantInt15getLimitedValueEy")
  //</editor-fold>
  public long/*uint64_t*/ getLimitedValue() /*const*/ {
    return getLimitedValue(~0L/*ULL*/);
  }
  public long/*uint64_t*/ getLimitedValue(long/*uint64_t*/ Limit/*= ~0ULLULL*/) /*const*/ {
    return Val.getLimitedValue(Limit);
  }

  
  /// @brief Methods to support type inquiry through isa, cast, and dyn_cast.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 245,
   FQN="llvm::ConstantInt::classof", NM="_ZN4llvm11ConstantInt7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm11ConstantInt7classofEPKNS_5ValueE")
  //</editor-fold>
  public static boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == ValueTy.ConstantIntVal.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantInt::~ConstantInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 75,
   FQN="llvm::ConstantInt::~ConstantInt", NM="_ZN4llvm11ConstantIntD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm11ConstantIntD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Val.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Val=" + Val // NOI18N
              + super.toString(); // NOI18N
  }
}
