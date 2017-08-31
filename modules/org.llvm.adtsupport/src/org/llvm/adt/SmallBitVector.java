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

package org.llvm.adt;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;


/// This is a 'bitvector' (really, a variable-sized bit array), optimized for
/// the case when the array is small. It contains one pointer-sized field, which
/// is directly used as a plain collection of bits when possible, or as a
/// pointer to a larger heap-allocated array when necessary. This allows normal
/// "small" cases to be fast without losing generality for large inputs.
//<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*only small mode is implemented now*/,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 28,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 31,
 FQN="llvm::SmallBitVector", NM="_ZN4llvm14SmallBitVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVectorE")
//</editor-fold>
public class SmallBitVector implements BitVectorTy<SmallBitVector>, NativeSwappable, Destructors.ClassWithDestructor, Native.NativeComparable<SmallBitVector> {
  // TODO: In "large" mode, a pointer to a BitVector is used, leading to an
  // unnecessary level of indirection. It would be more efficient to use a
  // pointer to memory containing size, allocation size, and the array of bits.
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*only small mode is implemented now*/)
  private /*uintptr_t*/long X;
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 34,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 37,
   FQN="llvm::SmallBitVector::(anonymous)", NM="_ZN4llvm14SmallBitVectorE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVectorE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    // The number of bits in this class.
    public static final int NumBaseBits = /*JAVA*/ true ? 64 : $sizeof_UIntptr_t() * CHAR_BIT;
    
    // One bit is used to discriminate between small and large mode. The
    // remaining bits are used for the small-mode representation.
    public static final int SmallNumRawBits = NumBaseBits - 1;
    
    // A few more bits are used to store the size of the bit set in small mode.
    // Theoretically this is a ceil-log2. These bits are encoded in the most
    // significant bits of the raw bits.
    public static final int SmallNumSizeBits = (NumBaseBits == 32 ? 5 : NumBaseBits == 64 ? 6 : SmallNumRawBits);
    
    // The remaining bits are used to store the actual set in small mode.
    public static final int SmallNumDataBits = SmallNumRawBits - SmallNumSizeBits;
  /*}*/;
  
  static { static_assert(NumBaseBits == 64 || NumBaseBits == 32, $("Unsupported word size")); };
/*public:*/
  /*typedef unsigned int size_type*/;
  // Encapsulation of a single bit.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::reference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 59,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 62,
   FQN="llvm::SmallBitVector::reference", NM="_ZN4llvm14SmallBitVector9referenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector9referenceE")
  //</editor-fold>
  public static class reference implements Native.Native$Bool, BitVectorTy.reference {
    private final SmallBitVector /*&*/ TheVector;
    private /*uint*/int BitPos;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::reference::reference">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 64,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 67,
     FQN="llvm::SmallBitVector::reference::reference", NM="_ZN4llvm14SmallBitVector9referenceC1ERS0_j",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector9referenceC1ERS0_j")
    //</editor-fold>
    public reference(final SmallBitVector /*&*/ b, /*uint*/int Idx) {
      // : TheVector(b), BitPos(Idx) 
      //START JInit
      this./*&*/TheVector=/*&*/b;
      this.BitPos = Idx;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::reference::reference">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 66,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 69,
     FQN="llvm::SmallBitVector::reference::reference", NM="_ZN4llvm14SmallBitVector9referenceC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector9referenceC1ERKS1_")
    //</editor-fold>
    public reference(final /*const*/ reference /*&*/ $Prm0) {
      // : TheVector(.TheVector), BitPos(.BitPos)/* = default*/ 
      //START JInit
      this./*&*/TheVector=/*&*/$Prm0.TheVector;
      this.BitPos = $Prm0.BitPos;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::reference::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 68,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 71,
     FQN="llvm::SmallBitVector::reference::operator=", NM="_ZN4llvm14SmallBitVector9referenceaSES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector9referenceaSES1_")
    //</editor-fold>
    public reference /*&*/ $assign(reference t) {
      /*Deref*/this.$assign(/*KEEP_BOOL*/((boolean)(t.$bool())));
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::reference::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 73,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 76,
     FQN="llvm::SmallBitVector::reference::operator=", NM="_ZN4llvm14SmallBitVector9referenceaSEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector9referenceaSEb")
    //</editor-fold>
    public reference /*&*/ $assign(boolean t) {
      if (t) {
        TheVector.set(BitPos);
      } else {
        TheVector.reset(BitPos);
      }
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::reference::operator bool">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 81,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 84,
     FQN="llvm::SmallBitVector::reference::operator bool", NM="_ZNK4llvm14SmallBitVector9referencecvbEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14SmallBitVector9referencecvbEv")
    //</editor-fold>
    public boolean $bool() /*const*/ {
      return ((/*const_cast*//*const*/ SmallBitVector /*&*/ )(TheVector)).$at$Const(BitPos);
    }

    
    @Override public String toString() {
      return "" + "TheVector=" + TheVector // NOI18N
                + ", BitPos=" + BitPos; // NOI18N
    }
  };
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::isSmall">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 87,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 90,
   FQN="llvm::SmallBitVector::isSmall", NM="_ZNK4llvm14SmallBitVector7isSmallEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14SmallBitVector7isSmallEv")
  //</editor-fold>
  private boolean isSmall() /*const*/ {
    return ((X & ((/*uintptr_t*/long)(1L))) != 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::getPointer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 91,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 94,
   FQN="llvm::SmallBitVector::getPointer", NM="_ZNK4llvm14SmallBitVector10getPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14SmallBitVector10getPointerEv")
  //</editor-fold>
  private BitVector /*P*/ getPointer() /*const*/ {
    assert (!isSmall()) : "to have only one field X we support only Small mode, use BitVector instead or complete this implementation";
    return reinterpret_cast(BitVector /*P*/ .class, X);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::switchToSmall">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 96,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 99,
   FQN="llvm::SmallBitVector::switchToSmall", NM="_ZN4llvm14SmallBitVector13switchToSmallEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector13switchToSmallEjj")
  //</editor-fold>
  private void switchToSmall(/*uintptr_t*/long NewSmallBits, /*size_t*/int NewSize) {
    X = 1;
    setSmallSize(NewSize);
    setSmallBits(NewSmallBits);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::switchToLarge">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 102,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 105,
   FQN="llvm::SmallBitVector::switchToLarge", NM="_ZN4llvm14SmallBitVector13switchToLargeEPNS_9BitVectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector13switchToLargeEPNS_9BitVectorE")
  //</editor-fold>
  private void switchToLarge(BitVector /*P*/ BV) {
    assert false : "not yet supported";
//    X = reinterpret_cast_Object/*uintptr_t*/(BV);
    assert (!isSmall()) : "Tried to use an unaligned pointer";
  }

  
  // Return all the bits used for the "small" representation; this includes
  // bits for the size as well as the element bits.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::getSmallRawBits">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 109,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 112,
   FQN="llvm::SmallBitVector::getSmallRawBits", NM="_ZNK4llvm14SmallBitVector15getSmallRawBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14SmallBitVector15getSmallRawBitsEv")
  //</editor-fold>
  private /*uintptr_t*/long getSmallRawBits() /*const*/ {
    assert (isSmall());
    return X >>> 1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::setSmallRawBits">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 114,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 117,
   FQN="llvm::SmallBitVector::setSmallRawBits", NM="_ZN4llvm14SmallBitVector15setSmallRawBitsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector15setSmallRawBitsEj")
  //</editor-fold>
  private void setSmallRawBits(/*uintptr_t*/long NewRawBits) {
    assert (isSmall());
    X = (NewRawBits << 1) | ((/*uintptr_t*/long)(1));
  }

  
  // Return the size.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::getSmallSize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 120,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 123,
   FQN="llvm::SmallBitVector::getSmallSize", NM="_ZNK4llvm14SmallBitVector12getSmallSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14SmallBitVector12getSmallSizeEv")
  //</editor-fold>
  private /*size_t*/int getSmallSize() /*const*/ {
    return $ulong2uint(getSmallRawBits() >>> SmallNumDataBits);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::setSmallSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 124,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 127,
   FQN="llvm::SmallBitVector::setSmallSize", NM="_ZN4llvm14SmallBitVector12setSmallSizeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector12setSmallSizeEj")
  //</editor-fold>
  private void setSmallSize(/*size_t*/long Size) {
    setSmallRawBits(getSmallBits() | (Size << SmallNumDataBits));
  }

  
  // Return the element bits.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::getSmallBits">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 129,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 132,
   FQN="llvm::SmallBitVector::getSmallBits", NM="_ZNK4llvm14SmallBitVector12getSmallBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14SmallBitVector12getSmallBitsEv")
  //</editor-fold>
  private /*uintptr_t*/long getSmallBits() /*const*/ {
    return getSmallRawBits() & ~(~((/*uintptr_t*/long)(0)) << getSmallSize());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::setSmallBits">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 133,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 136,
   FQN="llvm::SmallBitVector::setSmallBits", NM="_ZN4llvm14SmallBitVector12setSmallBitsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector12setSmallBitsEj")
  //</editor-fold>
  private void setSmallBits(/*uintptr_t*/long NewBits) {
    setSmallRawBits((NewBits & ~(~((/*uintptr_t*/long)(0)) << getSmallSize()))
           | (((long) getSmallSize()) << SmallNumDataBits));
  }

/*public:*/
  /// Creates an empty bitvector.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::SmallBitVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 140,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 143,
   FQN="llvm::SmallBitVector::SmallBitVector", NM="_ZN4llvm14SmallBitVectorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVectorC1Ev")
  //</editor-fold>
  public SmallBitVector() {
    // : X(1) 
    //START JInit
    this.X = 1;
    //END JInit
  }

  
  /// Creates a bitvector of specified number of bits. All bits are initialized
  /// to the specified value.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::SmallBitVector">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 144,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 147,
   FQN="llvm::SmallBitVector::SmallBitVector", NM="_ZN4llvm14SmallBitVectorC1Ejb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVectorC1Ejb")
  //</editor-fold>
  public /*explicit*/ SmallBitVector(/*uint*/int s) {
    this(s, false);
  }
  public /*explicit*/ SmallBitVector(/*uint*/int s, boolean t/*= false*/) {
    if ($lesseq_uint_int(s, SmallNumDataBits)) {
      switchToSmall(t ? ~((/*uintptr_t*/long)(0)) : 0, s);
    } else {
      switchToLarge(new BitVector(s, t));
    }
  }

  
  /// SmallBitVector copy ctor.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::SmallBitVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 152,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 155,
   FQN="llvm::SmallBitVector::SmallBitVector", NM="_ZN4llvm14SmallBitVectorC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVectorC1ERKS0_")
  //</editor-fold>
  public SmallBitVector(final /*const*/ SmallBitVector /*&*/ RHS) {
    if (RHS.isSmall()) {
      X = RHS.X;
    } else {
      switchToLarge(new BitVector($Deref(RHS.getPointer())));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::SmallBitVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 159,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 162,
   FQN="llvm::SmallBitVector::SmallBitVector", NM="_ZN4llvm14SmallBitVectorC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVectorC1EOS0_")
  //</editor-fold>
  public SmallBitVector(JD$Move _dparam, final SmallBitVector /*&&*/RHS) {
    // : X(RHS.X) 
    //START JInit
    this.X = RHS.X;
    //END JInit
    RHS.X = 1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::~SmallBitVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 163,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 166,
   FQN="llvm::SmallBitVector::~SmallBitVector", NM="_ZN4llvm14SmallBitVectorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVectorD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (!isSmall()) {
      if (getPointer() != null) { getPointer().$destroy();};
    }
  }

  
  /// Tests whether there are no bits in this bitvector.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 169,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 172,
   FQN="llvm::SmallBitVector::empty", NM="_ZNK4llvm14SmallBitVector5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14SmallBitVector5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return isSmall() ? getSmallSize() == 0 : getPointer().empty();
  }

  
  /// Returns the number of bits in this bitvector.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 174,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 177,
   FQN="llvm::SmallBitVector::size", NM="_ZNK4llvm14SmallBitVector4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14SmallBitVector4sizeEv")
  //</editor-fold>
  public /*size_t*/int size() /*const*/ {
    return isSmall() ? getSmallSize() : getPointer().size();
  }

  
  /// Returns the number of bits which are set.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::count">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 179,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 182,
   FQN="llvm::SmallBitVector::count", NM="_ZNK4llvm14SmallBitVector5countEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14SmallBitVector5countEv")
  //</editor-fold>
  public /*uint*/int count() /*const*/ {
    if (isSmall()) {
      /*uintptr_t*/long Bits = getSmallBits();
      return llvm.CountPopulation_64(Bits);
    }
    return getPointer().count();
  }

  
  /// Returns true if any bit is set.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::any">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 188,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 191,
   FQN="llvm::SmallBitVector::any", NM="_ZNK4llvm14SmallBitVector3anyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14SmallBitVector3anyEv")
  //</editor-fold>
  public boolean any() /*const*/ {
    if (isSmall()) {
      return getSmallBits() != 0;
    }
    return getPointer().any();
  }

  
  /// Returns true if all bits are set.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::all">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 195,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 198,
   FQN="llvm::SmallBitVector::all", NM="_ZNK4llvm14SmallBitVector3allEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14SmallBitVector3allEv")
  //</editor-fold>
  public boolean all() /*const*/ {
    if (isSmall()) {
      return getSmallBits() == (((/*uintptr_t*/long)(1)) << getSmallSize()) - 1;
    }
    return getPointer().all();
  }

  
  /// Returns true if none of the bits are set.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::none">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 202,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 205,
   FQN="llvm::SmallBitVector::none", NM="_ZNK4llvm14SmallBitVector4noneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14SmallBitVector4noneEv")
  //</editor-fold>
  public boolean none() /*const*/ {
    if (isSmall()) {
      return getSmallBits() == 0;
    }
    return getPointer().none();
  }

  
  /// Returns the index of the first set bit, -1 if none of the bits are set.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::find_first">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 209,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 213,
   FQN="llvm::SmallBitVector::find_first", NM="_ZNK4llvm14SmallBitVector10find_firstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14SmallBitVector10find_firstEv")
  //</editor-fold>
  public int find_first() /*const*/ {
    if (isSmall()) {
      /*uintptr_t*/long Bits = getSmallBits();
      if (Bits == 0) {
        return -1;
      }
      return countTrailingZeros_uint64_t_ZeroBehavior(Bits);
    }
    return getPointer().find_first();
  }

  
  /// Returns the index of the next set bit following the "Prev" bit.
  /// Returns -1 if the next set bit is not found.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::find_next">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 221,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 225,
   FQN="llvm::SmallBitVector::find_next", NM="_ZNK4llvm14SmallBitVector9find_nextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14SmallBitVector9find_nextEj")
  //</editor-fold>
  public int find_next(/*uint*/int Prev) /*const*/ {
    if (isSmall()) {
      /*uintptr_t*/long Bits = getSmallBits();
      // Mask off previous bits.
      Bits &= ~((/*uintptr_t*/long)(0)) << (Prev + 1);
      if (Bits == 0 || $greatereq_uint(Prev + 1, getSmallSize())) {
        return -1;
      }
      return countTrailingZeros_uint64_t_ZeroBehavior(Bits);
    }
    return getPointer().find_next(Prev);
  }

  
  /// Clear all bits.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 234,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 238,
   FQN="llvm::SmallBitVector::clear", NM="_ZN4llvm14SmallBitVector5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector5clearEv")
  //</editor-fold>
  public void clear() {
    if (!isSmall()) {
      if (getPointer() != null) { getPointer().$destroy();};
    }
    switchToSmall(0, 0);
  }

  
  /// Grow or shrink the bitvector.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::resize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 241,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 245,
   FQN="llvm::SmallBitVector::resize", NM="_ZN4llvm14SmallBitVector6resizeEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector6resizeEjb")
  //</editor-fold>
  public void resize(/*uint*/int N) {
    resize(N, false);
  }
  public void resize(/*uint*/int N, boolean t/*= false*/) {
    if (!isSmall()) {
      getPointer().resize(N, t);
    } else if ($greatereq_int_uint(SmallNumDataBits, N)) {
      /*uintptr_t*/long NewBits = t ? ~((/*uintptr_t*/long)(0)) << getSmallSize() : 0;
      setSmallSize(N);
      setSmallBits(NewBits | getSmallBits());
    } else {
      BitVector /*P*/ BV = new BitVector(N, t);
      /*uintptr_t*/long OldBits = getSmallBits();
      for (/*size_t*/int i = 0, e = getSmallSize(); i != e; ++i)  {
        ($Deref(BV)).$at(i).$assign(/*KEEP_BOOL*/((OldBits >>> i) & 1L) != 0);
      }
      switchToLarge(BV);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::reserve">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 257,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 261,
   FQN="llvm::SmallBitVector::reserve", NM="_ZN4llvm14SmallBitVector7reserveEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector7reserveEj")
  //</editor-fold>
  public void reserve(/*uint*/int N) {
    if (isSmall()) {
      if ($greater_uint_int(N, SmallNumDataBits)) {
        /*uintptr_t*/long OldBits = getSmallRawBits();
        /*size_t*/int SmallSize = getSmallSize();
        BitVector /*P*/ BV = new BitVector(SmallSize);
        for (/*size_t*/int i = 0; $less_uint(i, SmallSize); ++i)  {
          if ((((OldBits >>> i) & 1L) != 0)) {
            BV.set(i);
          }
        }
        BV.reserve(N);
        switchToLarge(BV);
      }
    } else {
      getPointer().reserve(N);
    }
  }

  
  // Set, reset, flip
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::set">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 275,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 279,
   FQN="llvm::SmallBitVector::set", NM="_ZN4llvm14SmallBitVector3setEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector3setEv")
  //</editor-fold>
  public SmallBitVector /*&*/ set() {
    if (isSmall()) {
      setSmallBits(~((/*uintptr_t*/long)(0)));
    } else {
      getPointer().set();
    }
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::set">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 283,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 287,
   FQN="llvm::SmallBitVector::set", NM="_ZN4llvm14SmallBitVector3setEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector3setEj")
  //</editor-fold>
  public SmallBitVector /*&*/ set(/*uint*/int Idx) {
    if (isSmall()) {
      assert ($lesseq_uint(Idx, ((/*static_cast*//*uint*/int)(std.numeric_limitsULong.digits)))) : "undefined behavior";
      setSmallBits(getSmallBits() | (((/*uintptr_t*/long)(1)) << Idx));
    } else {
      getPointer().set(Idx);
    }
    return /*Deref*/this;
  }

  
  /// Efficiently set a range of bits in [I, E)
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::set">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 296,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 300,
   FQN="llvm::SmallBitVector::set", NM="_ZN4llvm14SmallBitVector3setEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector3setEjj")
  //</editor-fold>
  public SmallBitVector /*&*/ set(/*uint*/int I, /*uint*/int E) {
    assert ($lesseq_uint(I, E)) : "Attempted to set backwards range!";
    assert ($lesseq_uint(E, size())) : "Attempted to set out-of-bounds range!";
    if (I == E) {
      return /*Deref*/this;
    }
    if (isSmall()) {
      /*uintptr_t*/long EMask = ((/*uintptr_t*/long)1) << E;
      /*uintptr_t*/long IMask = ((/*uintptr_t*/long)1) << I;
      /*uintptr_t*/long Mask = EMask - IMask;
      setSmallBits(getSmallBits() | Mask);
    } else {
      getPointer().set(I, E);
    }
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 310,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 314,
   FQN="llvm::SmallBitVector::reset", NM="_ZN4llvm14SmallBitVector5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector5resetEv")
  //</editor-fold>
  public SmallBitVector /*&*/ reset() {
    if (isSmall()) {
      setSmallBits(0);
    } else {
      getPointer().reset();
    }
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::reset">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 318,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 322,
   FQN="llvm::SmallBitVector::reset", NM="_ZN4llvm14SmallBitVector5resetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector5resetEj")
  //</editor-fold>
  public SmallBitVector /*&*/ reset(/*uint*/int Idx) {
    if (isSmall()) {
      setSmallBits(getSmallBits() & ~(((/*uintptr_t*/long)(1)) << Idx));
    } else {
      getPointer().reset(Idx);
    }
    return /*Deref*/this;
  }

  
  /// Efficiently reset a range of bits in [I, E)
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::reset">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 327,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 331,
   FQN="llvm::SmallBitVector::reset", NM="_ZN4llvm14SmallBitVector5resetEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector5resetEjj")
  //</editor-fold>
  public SmallBitVector /*&*/ reset(/*uint*/int I, /*uint*/int E) {
    assert ($lesseq_uint(I, E)) : "Attempted to reset backwards range!";
    assert ($lesseq_uint(E, size())) : "Attempted to reset out-of-bounds range!";
    if (I == E) {
      return /*Deref*/this;
    }
    if (isSmall()) {
      /*uintptr_t*/long EMask = ((/*uintptr_t*/long)1) << E;
      /*uintptr_t*/long IMask = ((/*uintptr_t*/long)1) << I;
      /*uintptr_t*/long Mask = EMask - IMask;
      setSmallBits(getSmallBits() & ~Mask);
    } else {
      getPointer().reset(I, E);
    }
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::flip">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 341,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 345,
   FQN="llvm::SmallBitVector::flip", NM="_ZN4llvm14SmallBitVector4flipEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector4flipEv")
  //</editor-fold>
  public SmallBitVector /*&*/ flip() {
    if (isSmall()) {
      setSmallBits(~getSmallBits());
    } else {
      getPointer().flip();
    }
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::flip">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 349,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 353,
   FQN="llvm::SmallBitVector::flip", NM="_ZN4llvm14SmallBitVector4flipEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector4flipEj")
  //</editor-fold>
  public SmallBitVector /*&*/ flip(/*uint*/int Idx) {
    if (isSmall()) {
      setSmallBits(getSmallBits() ^ (((/*uintptr_t*/long)(1)) << Idx));
    } else {
      getPointer().flip(Idx);
    }
    return /*Deref*/this;
  }

  
  // No argument flip.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::operator~">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 358,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 362,
   FQN="llvm::SmallBitVector::operator~", NM="_ZNK4llvm14SmallBitVectorcoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14SmallBitVectorcoEv")
  //</editor-fold>
  public SmallBitVector $bitnot() /*const*/ {
    return new SmallBitVector(/*Deref*/this).flip();
  }

  
  // Indexing.

  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 363,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 367,
   FQN="llvm::SmallBitVector::operator[]", NM="_ZN4llvm14SmallBitVectorixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVectorixEj")
  //</editor-fold>
  public reference $at(/*uint*/int Idx) {
    assert ($less_uint(Idx, size())) : "Out-of-bounds Bit access.";
    return new reference(/*Deref*/this, Idx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::operator[]">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 368,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 372,
   FQN="llvm::SmallBitVector::operator[]", NM="_ZNK4llvm14SmallBitVectorixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14SmallBitVectorixEj")
  //</editor-fold>
  public boolean $at$Const(/*uint*/int Idx) /*const*/ {
    assert ($less_uint(Idx, size())) : "Out-of-bounds Bit access.";
    if (isSmall()) {
      return ((getSmallBits() >>> Idx) & 1L) != 0L;
    }
    return getPointer().$at(Idx).$bool();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::test">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 375,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 379,
   FQN="llvm::SmallBitVector::test", NM="_ZNK4llvm14SmallBitVector4testEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14SmallBitVector4testEj")
  //</editor-fold>
  public boolean test(/*uint*/int Idx) /*const*/ {
    return (/*Deref*/this).$at$Const(Idx);
  }

  
  /// Test if any common bits are set.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::anyCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 380,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 384,
   FQN="llvm::SmallBitVector::anyCommon", NM="_ZNK4llvm14SmallBitVector9anyCommonERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14SmallBitVector9anyCommonERKS0_")
  //</editor-fold>
  public boolean anyCommon(final /*const*/ SmallBitVector /*&*/ RHS) /*const*/ {
    if (isSmall() && RHS.isSmall()) {
      return (getSmallBits() & RHS.getSmallBits()) != 0;
    }
    if (!isSmall() && !RHS.isSmall()) {
      return getPointer().anyCommon($Deref(RHS.getPointer()));
    }
    
    for (/*uint*/int i = 0, e = std.min_uint(size(), RHS.size()); i != e; ++i)  {
      if (test(i) && RHS.test(i)) {
        return true;
      }
    }
    return false;
  }

  
  // Comparison operators.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 393,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 397,
   FQN="llvm::SmallBitVector::operator==", NM="_ZNK4llvm14SmallBitVectoreqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14SmallBitVectoreqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ SmallBitVector /*&*/ RHS) /*const*/ {
    if (size() != RHS.size()) {
      return false;
    }
    if (isSmall()) {
      return getSmallBits() == RHS.getSmallBits();
    } else {
      return /*Deref*/getPointer().$eq($Deref(RHS.getPointer()));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 402,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 406,
   FQN="llvm::SmallBitVector::operator!=", NM="_ZNK4llvm14SmallBitVectorneERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14SmallBitVectorneERKS0_")
  //</editor-fold>
  public boolean $noteq(final /*const*/ SmallBitVector /*&*/ RHS) /*const*/ {
    return !(/*Deref*/this.$eq(RHS));
  }

  
  // Intersection, union, disjoint union.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::operator&=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 407,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 411,
   FQN="llvm::SmallBitVector::operator&=", NM="_ZN4llvm14SmallBitVectoraNERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVectoraNERKS0_")
  //</editor-fold>
  public SmallBitVector /*&*/ $andassign(final /*const*/ SmallBitVector /*&*/ RHS) {
    resize(std.max(size(), RHS.size()));
    if (isSmall()) {
      setSmallBits(getSmallBits() & RHS.getSmallBits());
    } else if (!RHS.isSmall()) {
      getPointer().$andassign($Deref(RHS.getPointer()));
    } else {
      SmallBitVector Copy = new SmallBitVector(RHS);
      Copy.resize(size());
      getPointer().$andassign($Deref(Copy.getPointer()));
    }
    return /*Deref*/this;
  }

  
  /// Reset bits that are set in RHS. Same as *this &= ~RHS.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 422,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 426,
   FQN="llvm::SmallBitVector::reset", NM="_ZN4llvm14SmallBitVector5resetERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector5resetERKS0_")
  //</editor-fold>
  public SmallBitVector /*&*/ reset(final /*const*/ SmallBitVector /*&*/ RHS) {
    if (isSmall() && RHS.isSmall()) {
      setSmallBits(getSmallBits() & ~RHS.getSmallBits());
    } else if (!isSmall() && !RHS.isSmall()) {
      getPointer().reset($Deref(RHS.getPointer()));
    } else {
      for (/*uint*/int i = 0, e = std.min_uint(size(), RHS.size()); i != e; ++i)  {
        if (RHS.test(i)) {
          reset(i);
        }
      }
    }
    
    return /*Deref*/this;
  }

  
  /// Check if (This - RHS) is zero. This is the same as reset(RHS) and any().
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::test">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 436,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 441,
   FQN="llvm::SmallBitVector::test", NM="_ZNK4llvm14SmallBitVector4testERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14SmallBitVector4testERKS0_")
  //</editor-fold>
  public boolean test(final /*const*/ SmallBitVector /*&*/ RHS) /*const*/ {
    if (isSmall() && RHS.isSmall()) {
      return (getSmallBits() & ~RHS.getSmallBits()) != 0;
    }
    if (!isSmall() && !RHS.isSmall()) {
      return getPointer().test($Deref(RHS.getPointer()));
    }
    
    /*uint*/int i;
    /*uint*/int e;
    for (i = 0 , e = std.min_uint(size(), RHS.size()); i != e; ++i)  {
      if (test(i) && !RHS.test(i)) {
        return true;
      }
    }
    
    for (e = size(); i != e; ++i)  {
      if (test(i)) {
        return true;
      }
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::operator|=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 454,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 459,
   FQN="llvm::SmallBitVector::operator|=", NM="_ZN4llvm14SmallBitVectoroRERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVectoroRERKS0_")
  //</editor-fold>
  public SmallBitVector /*&*/ $orassign(final /*const*/ SmallBitVector /*&*/ RHS) {
    resize(std.max(size(), RHS.size()));
    if (isSmall()) {
      setSmallBits(getSmallBits() | RHS.getSmallBits());
    } else if (!RHS.isSmall()) {
      getPointer().$orassign($Deref(RHS.getPointer()));
    } else {
      SmallBitVector Copy = new SmallBitVector(RHS);
      Copy.resize(size());
      getPointer().$orassign($Deref(Copy.getPointer()));
    }
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::operator^=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 468,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 473,
   FQN="llvm::SmallBitVector::operator^=", NM="_ZN4llvm14SmallBitVectoreOERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVectoreOERKS0_")
  //</editor-fold>
  public SmallBitVector /*&*/ $xorassign(final /*const*/ SmallBitVector /*&*/ RHS) {
    resize(std.max(size(), RHS.size()));
    if (isSmall()) {
      setSmallBits(getSmallBits() ^ RHS.getSmallBits());
    } else if (!RHS.isSmall()) {
      getPointer().$xorassign($Deref(RHS.getPointer()));
    } else {
      SmallBitVector Copy = new SmallBitVector(RHS);
      Copy.resize(size());
      getPointer().$xorassign($Deref(Copy.getPointer()));
    }
    return /*Deref*/this;
  }

  
  // Assignment operator.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 483,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 488,
   FQN="llvm::SmallBitVector::operator=", NM="_ZN4llvm14SmallBitVectoraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVectoraSERKS0_")
  //</editor-fold>
  public /*const*/ SmallBitVector /*&*/ $assign(final /*const*/ SmallBitVector /*&*/ RHS) {
    if (isSmall()) {
      if (RHS.isSmall()) {
        X = RHS.X;
      } else {
        switchToLarge(new BitVector($Deref(RHS.getPointer())));
      }
    } else {
      if (!RHS.isSmall()) {
        /*Deref*/getPointer().$assign($Deref(RHS.getPointer()));
      } else {
        if (getPointer() != null) { getPointer().$destroy();};
        X = RHS.X;
      }
    }
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 500,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 505,
   FQN="llvm::SmallBitVector::operator=", NM="_ZN4llvm14SmallBitVectoraSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVectoraSEOS0_")
  //</editor-fold>
  public /*const*/ SmallBitVector /*&*/ $assignMove(final SmallBitVector /*&&*/RHS) {
    if (this != $AddrOf(RHS)) {
      clear();
      swap(RHS);
    }
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::swap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 508,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 513,
   FQN="llvm::SmallBitVector::swap", NM="_ZN4llvm14SmallBitVector4swapERS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector4swapERS0_")
  //</editor-fold>
  public void swap(final SmallBitVector /*&*/ RHS) {
    std.swap(X, RHS.X);
  }

  
  /// Add '1' bits from Mask to this vector. Don't resize.
  /// This computes "*this |= Mask".
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::setBitsInMask">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 514,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 519,
   FQN="llvm::SmallBitVector::setBitsInMask", NM="_ZN4llvm14SmallBitVector13setBitsInMaskEPKjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector13setBitsInMaskEPKjj")
  //</editor-fold>
  public void setBitsInMask(/*const*//*uint32_t P*/uint$ptr Mask) {
    setBitsInMask(Mask, ~0/*U*/);
  }
  public void setBitsInMask(/*const*//*uint32_t P*/uint$ptr Mask, /*uint*/int MaskWords/*= ~0uU*/) {
    if (isSmall()) {
      this.applyMask(true, false, Mask, MaskWords);
    } else {
      getPointer().setBitsInMask(Mask, MaskWords);
    }
  }

  
  /// Clear any bits in this vector that are set in Mask. Don't resize.
  /// This computes "*this &= ~Mask".
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::clearBitsInMask">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 523,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 528,
   FQN="llvm::SmallBitVector::clearBitsInMask", NM="_ZN4llvm14SmallBitVector15clearBitsInMaskEPKjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector15clearBitsInMaskEPKjj")
  //</editor-fold>
  public void clearBitsInMask(/*const*//*uint32_t P*/uint$ptr Mask) {
    clearBitsInMask(Mask, ~0/*U*/);
  }
  public void clearBitsInMask(/*const*//*uint32_t P*/uint$ptr Mask, /*uint*/int MaskWords/*= ~0uU*/) {
    if (isSmall()) {
      this.applyMask(false, false, Mask, MaskWords);
    } else {
      getPointer().clearBitsInMask(Mask, MaskWords);
    }
  }

  
  /// Add a bit to this vector for every '0' bit in Mask. Don't resize.
  /// This computes "*this |= ~Mask".
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::setBitsNotInMask">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 532,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 537,
   FQN="llvm::SmallBitVector::setBitsNotInMask", NM="_ZN4llvm14SmallBitVector16setBitsNotInMaskEPKjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector16setBitsNotInMaskEPKjj")
  //</editor-fold>
  public void setBitsNotInMask(/*const*//*uint32_t P*/uint$ptr Mask) {
    setBitsNotInMask(Mask, ~0/*U*/);
  }
  public void setBitsNotInMask(/*const*//*uint32_t P*/uint$ptr Mask, /*uint*/int MaskWords/*= ~0uU*/) {
    if (isSmall()) {
      this.applyMask(true, true, Mask, MaskWords);
    } else {
      getPointer().setBitsNotInMask(Mask, MaskWords);
    }
  }

  
  /// Clear a bit in this vector for every '0' bit in Mask. Don't resize.
  /// This computes "*this &= Mask".
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::clearBitsNotInMask">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 541,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 546,
   FQN="llvm::SmallBitVector::clearBitsNotInMask", NM="_ZN4llvm14SmallBitVector18clearBitsNotInMaskEPKjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14SmallBitVector18clearBitsNotInMaskEPKjj")
  //</editor-fold>
  public void clearBitsNotInMask(/*const*//*uint32_t P*/uint$ptr Mask) {
    clearBitsNotInMask(Mask, ~0/*U*/);
  }
  public void clearBitsNotInMask(/*const*//*uint32_t P*/uint$ptr Mask, /*uint*/int MaskWords/*= ~0uU*/) {
    if (isSmall()) {
      this.applyMask(false, true, Mask, MaskWords);
    } else {
      getPointer().clearBitsNotInMask(Mask, MaskWords);
    }
  }

/*private:*/
  /*template <bool AddBits, bool InvertMask> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallBitVector::applyMask">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 550,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 554,
   FQN="llvm::SmallBitVector::applyMask", NM="Tpl__ZN4llvm14SmallBitVector9applyMaskEPKjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=Tpl__ZN4llvm14SmallBitVector9applyMaskEPKjj")
  //</editor-fold>
  private void applyMask(boolean AddBits, boolean InvertMask, /*const*//*uint32_t P*/uint$ptr Mask, /*uint*/int MaskWords) {
    assert ($lesseq_uint(MaskWords, $sizeof_UIntptr_t())) : "Mask is larger than base!";
    /*uintptr_t*/long M = Mask.$at(0);
    if (NumBaseBits == 64) {
      M |= ((long/*uint64_t*/)($uint2ulong(Mask.$at(1)))) << 32;
    }
    if (InvertMask) {
      M = ~M;
    }
    if (AddBits) {
      setSmallBits(getSmallBits() | M);
    } else {
      setSmallBits(getSmallBits() & ~M);
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public void swap(NativeSwappable RHS) { swap((SmallBitVector)RHS); }

  @Override public SmallBitVector clone() { return new SmallBitVector(this); }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "X=" + X; // NOI18N
  }
}
