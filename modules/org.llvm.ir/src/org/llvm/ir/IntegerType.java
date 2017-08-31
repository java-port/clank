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
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.support.llvm.*;


/// Class to represent integer types. Note that this class is also used to
/// represent the built-in integer types: Int1Ty, Int8Ty, Int16Ty, Int32Ty and
/// Int64Ty.
/// @brief Integer representation type
//<editor-fold defaultstate="collapsed" desc="llvm::IntegerType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 37,
 FQN="llvm::IntegerType", NM="_ZN4llvm11IntegerTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm11IntegerTypeE")
//</editor-fold>
public class IntegerType extends /*public*/ Type {
  /*friend  class LLVMContextImpl*/
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IntegerType::IntegerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 41,
   FQN="llvm::IntegerType::IntegerType", NM="_ZN4llvm11IntegerTypeC1ERNS_11LLVMContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm11IntegerTypeC1ERNS_11LLVMContextEj")
  //</editor-fold>
  /*friend*/public/*protected*/ /*explicit*/ IntegerType(final LLVMContext /*&*/ C, /*uint*/int NumBits) {
    // : Type(C, IntegerTyID) 
    //START JInit
    super(C, TypeID.IntegerTyID);
    //END JInit
    setSubclassData(NumBits);
  }

/*public:*/
  /// This enum is just used to hold constants we need for IntegerType.
  //<editor-fold defaultstate="collapsed" desc="llvm::IntegerType::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 47,
   FQN="llvm::IntegerType::(anonymous)", NM="_ZN4llvm11IntegerTypeE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm11IntegerTypeE_Unnamed_enum")
  //</editor-fold>
  public enum Unnamed_enum implements Native.NativeUIntEnum {
    MIN_INT_BITS(1), ///< Minimum number of bits that can be specified
    MAX_INT_BITS((1 << 23) - 1); ///< Maximum number of bits that can be specified
    ///< Note that bit width is stored in the Type classes SubclassData field
    ///< which has 23 bits. This yields a maximum bit width of 8,388,607 bits.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum valueOf(int val) {
      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum[] VALUES;
      private static final Unnamed_enum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// This static method is the primary way of constructing an IntegerType.
  /// If an IntegerType with the same NumBits value was previously instantiated,
  /// that instance will be returned. Otherwise a new one will be created. Only
  /// one instance with a given NumBits value is ever created.
  /// @brief Get or create an IntegerType instance.
  
  /// This static method is the primary way of constructing an IntegerType.
  /// If an IntegerType with the same NumBits value was previously instantiated,
  /// that instance will be returned. Otherwise a new one will be created. Only
  /// one instance with a given NumBits value is ever created.
  /// @brief Get or create an IntegerType instance.
  
  //===----------------------------------------------------------------------===//
  //                       IntegerType Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::IntegerType::get">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 234,
   FQN="llvm::IntegerType::get", NM="_ZN4llvm11IntegerType3getERNS_11LLVMContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm11IntegerType3getERNS_11LLVMContextEj")
  //</editor-fold>
  public static IntegerType /*P*/ get(final LLVMContext /*&*/ C, /*uint*/int NumBits) {
    assert ($greatereq_uint(NumBits, Unnamed_enum.MIN_INT_BITS.getValue())) : "bitwidth too small";
    assert ($lesseq_uint(NumBits, Unnamed_enum.MAX_INT_BITS.getValue())) : "bitwidth too large";
    
    // Check for the built-in integer types
    switch (NumBits) {
     case 1:
      return cast_IntegerType(Type.getInt1Ty(C));
     case 8:
      return cast_IntegerType(Type.getInt8Ty(C));
     case 16:
      return cast_IntegerType(Type.getInt16Ty(C));
     case 32:
      return cast_IntegerType(Type.getInt32Ty(C));
     case 64:
      return cast_IntegerType(Type.getInt64Ty(C));
     case 128:
      return cast_IntegerType(Type.getInt128Ty(C));
     default:
      break;
    }
    
    final type$ref<IntegerType /*P*/ /*&*/> Entry = C.pImpl.IntegerTypes.ref$at(NumBits);
    if (!(Entry.$deref() != null)) {
      Entry.$set(((/*JCast*/IntegerType /*P*/ )(/*NEW_EXPR [operator new] NM=_ZnwIN4llvm15MallocAllocatorELj4096ELj4096EEPvjRNS0_20BumpPtrAllocatorImplIT_XT0_EXT1_EEE*/
              /*new (C.pImpl->TypeAllocator)*/ $new_uint_BumpPtrAllocatorImpl$AllocatorT$SlabSize$SizeThreshold(C.pImpl.TypeAllocator, (type$ptr<?> New$Mem)->{
              return new IntegerType(C, NumBits);
            })
      )));
    }
    
    return Entry.$deref();
  }


  
  /// @brief Get the number of bits in this IntegerType
  //<editor-fold defaultstate="collapsed" desc="llvm::IntegerType::getBitWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 62,
   FQN="llvm::IntegerType::getBitWidth", NM="_ZNK4llvm11IntegerType11getBitWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZNK4llvm11IntegerType11getBitWidthEv")
  //</editor-fold>
  public /*uint*/int getBitWidth() /*const*/ {
    return getSubclassData();
  }

  
  /// Return a bitmask with ones set for all of the bits that can be set by an
  /// unsigned version of this type. This is 0xFF for i8, 0xFFFF for i16, etc.
  //<editor-fold defaultstate="collapsed" desc="llvm::IntegerType::getBitMask">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 66,
   FQN="llvm::IntegerType::getBitMask", NM="_ZNK4llvm11IntegerType10getBitMaskEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZNK4llvm11IntegerType10getBitMaskEv")
  //</editor-fold>
  public long/*uint64_t*/ getBitMask() /*const*/ {
    return ~((long/*uint64_t*/)(0L/*UL*/)) >>> (64 - getBitWidth());
  }

  
  /// Return a uint64_t with just the most significant bit set (the sign bit, if
  /// the value is treated as a signed number).
  //<editor-fold defaultstate="collapsed" desc="llvm::IntegerType::getSignBit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 72,
   FQN="llvm::IntegerType::getSignBit", NM="_ZNK4llvm11IntegerType10getSignBitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZNK4llvm11IntegerType10getSignBitEv")
  //</editor-fold>
  public long/*uint64_t*/ getSignBit() /*const*/ {
    return 1L/*ULL*/ << (getBitWidth() - 1);
  }

  
  /// For example, this is 0xFF for an 8 bit integer, 0xFFFF for i16, etc.
  /// @returns a bit mask with ones set for all the bits of this type.
  /// @brief Get a bit mask for this type.
  
  /// For example, this is 0xFF for an 8 bit integer, 0xFFFF for i16, etc.
  /// @returns a bit mask with ones set for all the bits of this type.
  /// @brief Get a bit mask for this type.
  //<editor-fold defaultstate="collapsed" desc="llvm::IntegerType::getMask">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 263,
   FQN="llvm::IntegerType::getMask", NM="_ZNK4llvm11IntegerType7getMaskEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm11IntegerType7getMaskEv")
  //</editor-fold>
  public APInt getMask() /*const*/ {
    return APInt.getAllOnesValue(getBitWidth());
  }


  
  /// This method determines if the width of this IntegerType is a power-of-2
  /// in terms of 8 bit bytes.
  /// @returns true if this is a power-of-2 byte width.
  /// @brief Is this a power-of-2 byte-width IntegerType ?
  
  /// This method determines if the width of this IntegerType is a power-of-2
  /// in terms of 8 bit bytes.
  /// @returns true if this is a power-of-2 byte width.
  /// @brief Is this a power-of-2 byte-width IntegerType ?
  //<editor-fold defaultstate="collapsed" desc="llvm::IntegerType::isPowerOf2ByteWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 258,
   FQN="llvm::IntegerType::isPowerOf2ByteWidth", NM="_ZNK4llvm11IntegerType19isPowerOf2ByteWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm11IntegerType19isPowerOf2ByteWidthEv")
  //</editor-fold>
  public boolean isPowerOf2ByteWidth() /*const*/ {
    /*uint*/int BitWidth = getBitWidth();
    return ($greater_uint(BitWidth, 7)) && isPowerOf2_32(BitWidth);
  }


  
  /// Methods for support type inquiry through isa, cast, and dyn_cast.
  //<editor-fold defaultstate="collapsed" desc="llvm::IntegerType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 88,
   FQN="llvm::IntegerType::classof", NM="_ZN4llvm11IntegerType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm11IntegerType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeID() == TypeID.IntegerTyID;
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
