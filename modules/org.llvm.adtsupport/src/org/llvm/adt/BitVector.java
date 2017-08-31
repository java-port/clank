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

import static org.clank.support.Native.$AddrOf;
import java.util.Arrays;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;

//<editor-fold defaultstate="collapsed" desc="llvm::BitVector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 27,
 FQN="llvm::BitVector", NM="_ZN4llvm9BitVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVectorE")
//</editor-fold>
public class BitVector implements BitVectorTy<BitVector>, Destructors.ClassWithDestructor, Native.NativeComparable<BitVector>, NativeSwappable {
  /*typedef unsigned long BitWord*/;
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 30,
   FQN="llvm::BitVector::(anonymous)", NM="_ZN4llvm9BitVectorE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVectorE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int BITWORD_SIZE = (/*uint*/int)$sizeof_ULong() * CHAR_BIT;
  /*}*/;
  
  static { static_assert(BITWORD_SIZE == 64 || BITWORD_SIZE == 32, $("Unsupported word size")); };
  
  private /*ulong*/long[]/*P*/ Bits; // Actual bits.
  private /*uint*/int Size; // Size of bitvector in bits.
  private /*uint*/int Capacity; // Number of BitWords allocated in the Bits array.
/*public:*/
  /*typedef unsigned int size_type*/;
  // Encapsulation of a single bit.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::reference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 42,
   FQN="llvm::BitVector::reference", NM="_ZN4llvm9BitVector9referenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector9referenceE")
  //</editor-fold>
  public static class reference implements BitVectorTy.reference, Native.Native$Bool  {
    /*friend  class BitVector*/
    
    private final /*ulong*/long[]/*P*/ WordRef;
    private final int WordRefOffset;
    private /*uint*/int BitPos;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::reference::reference">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 48,
     FQN="llvm::BitVector::reference::reference", NM="_ZN4llvm9BitVector9referenceC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector9referenceC1Ev")
    //</editor-fold>
    private reference() {
      throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
    }
 // Undefined

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::reference::reference">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 51,
     FQN="llvm::BitVector::reference::reference", NM="_ZN4llvm9BitVector9referenceC1ERS0_j",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector9referenceC1ERS0_j")
    //</editor-fold>
    public reference(BitVector /*&*/ b, /*uint*/int Idx) {
      WordRef = b.Bits;
      WordRefOffset = Idx / BITWORD_SIZE;
      BitPos = Idx % BITWORD_SIZE;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::reference::reference">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 56,
     FQN="llvm::BitVector::reference::reference", NM="_ZN4llvm9BitVector9referenceC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector9referenceC1ERKS1_")
    //</editor-fold>
    public reference(/*const*/ reference /*&*/ $Prm0) {
      // : WordRef(.WordRef), BitPos(.BitPos)/* = default*/ 
      //START JInit
      this.WordRef = $Prm0.WordRef;
      this.WordRefOffset = $Prm0.WordRefOffset;
      this.BitPos = $Prm0.BitPos;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::reference::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 58,
     FQN="llvm::BitVector::reference::operator=", NM="_ZN4llvm9BitVector9referenceaSES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector9referenceaSES1_")
    //</editor-fold>
    public reference /*&*/ $assign(reference t) {
      /*Deref*/this.$assign(/*KEEP_BOOL*/((boolean)(t.$bool())));
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::reference::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 63,
     FQN="llvm::BitVector::reference::operator=", NM="_ZN4llvm9BitVector9referenceaSEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector9referenceaSEb")
    //</editor-fold>
    public reference /*&*/ $assign(boolean t) {
      if (t) {
        WordRef[WordRefOffset] |= ((/*ulong*/long)(1)) << BitPos;
      } else {
        WordRef[WordRefOffset] &= ~(((/*ulong*/long)(1)) << BitPos);
      }
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::reference::operator bool">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 71,
     FQN="llvm::BitVector::reference::operator bool", NM="_ZNK4llvm9BitVector9referencecvbEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZNK4llvm9BitVector9referencecvbEv")
    //</editor-fold>
    public boolean $bool() /*const*/ {
      return ((WordRef[WordRefOffset]) & (((/*ulong*/long)(1)) << BitPos)) != 0;
    }

    
    @Override public String toString() {
      return "" + "WordRef=" + WordRef // NOI18N
                + ", BitPos=" + BitPos; // NOI18N
    }
  };
  
  /// BitVector default ctor - Creates an empty bitvector.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::BitVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 78,
   FQN="llvm::BitVector::BitVector", NM="_ZN4llvm9BitVectorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVectorC1Ev")
  //</editor-fold>
  public BitVector() {
    // : Size(0), Capacity(0) 
    //START JInit
    this.Size = 0;
    this.Capacity = 0;
    //END JInit
    Bits = null;
  }

  
  /// BitVector ctor - Creates a bitvector of specified number of bits. All
  /// bits are initialized to the specified value.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::BitVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 84,
   FQN="llvm::BitVector::BitVector", NM="_ZN4llvm9BitVectorC1Ejb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVectorC1Ejb")
  //</editor-fold>
  public /*explicit*/ BitVector(/*uint*/int s) {
    this(s, false);
  }
  public /*explicit*/ BitVector(/*uint*/int s, boolean t/*= false*/) {
    // : Size(s) 
    //START JInit
    this.Size = s;
    //END JInit
    Capacity = NumBitWords(s);
    Bits = new long[Capacity];
    init_words(Bits, t);
    if (t) {
      clear_unused_bits();
    }
  }

  
  /// BitVector copy ctor.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::BitVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 93,
   FQN="llvm::BitVector::BitVector", NM="_ZN4llvm9BitVectorC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVectorC1ERKS0_")
  //</editor-fold>
  public BitVector(/*const*/ BitVector /*&*/ RHS) {
    // : Size(RHS.size()) 
    //START JInit
    this.Size = RHS.size();
    //END JInit
    if (Size == 0) {
      Bits = null;
      Capacity = 0;
      return;
    }
    
    Capacity = NumBitWords(RHS.size());
    Bits = new long[Capacity];
    NativePointer.copy$Object(RHS.Bits, 0, Bits, 0, Capacity);
    //std.memcpy(Bits, RHS.Bits, Capacity * $sizeof_ULong());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::BitVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 105,
   FQN="llvm::BitVector::BitVector", NM="_ZN4llvm9BitVectorC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVectorC1EOS0_")
  //</editor-fold>
  public BitVector(JD$Move _dparam, BitVector /*&&*/RHS) {
    // : Bits(RHS.Bits), Size(RHS.Size), Capacity(RHS.Capacity) 
    //START JInit
    this.Bits = RHS.Bits;
    this.Size = RHS.Size;
    this.Capacity = RHS.Capacity;
    //END JInit
    RHS.Bits = null;
    RHS.Size = RHS.Capacity = 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::~BitVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 111,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 110,
   FQN="llvm::BitVector::~BitVector", NM="_ZN4llvm9BitVectorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVectorD0Ev")
  //</editor-fold>
  public void $destroy() {
    std.free(Bits);
  }

  
  /// empty - Tests whether there are no bits in this bitvector.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 116,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 115,
   FQN="llvm::BitVector::empty", NM="_ZNK4llvm9BitVector5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZNK4llvm9BitVector5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Size == 0;
  }

  
  /// size - Returns the number of bits in this bitvector.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 119,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 118,
   FQN="llvm::BitVector::size", NM="_ZNK4llvm9BitVector4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZNK4llvm9BitVector4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return Size;
  }

  
  /// count - Returns the number of bits which are set.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::count">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 122,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 121,
   FQN="llvm::BitVector::count", NM="_ZNK4llvm9BitVector5countEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZNK4llvm9BitVector5countEv")
  //</editor-fold>
  public /*uint*/int count() /*const*/ {
    /*uint*/int NumBits = 0;
    for (/*uint*/int i = 0; $less_uint(i, NumBitWords(size())); ++i)  {
      NumBits += CountPopulation_64(Bits[i]);
    }
    return NumBits;
  }

  
  /// any - Returns true if any bit is set.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::any">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 130,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 129,
   FQN="llvm::BitVector::any", NM="_ZNK4llvm9BitVector3anyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZNK4llvm9BitVector3anyEv")
  //</editor-fold>
  public boolean any() /*const*/ {
    for (/*uint*/int i = 0; $less_uint(i, NumBitWords(size())); ++i)  {
      if (Bits[i] != 0) {
        return true;
      }
    }
    return false;
  }

  
  /// all - Returns true if all bits are set.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::all">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 138,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 137,
   FQN="llvm::BitVector::all", NM="_ZNK4llvm9BitVector3allEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZNK4llvm9BitVector3allEv")
  //</editor-fold>
  public boolean all() /*const*/ {
    for (/*uint*/int i = 0; $less_uint(i, Size / BITWORD_SIZE); ++i)  {
      if (Bits[i] != ~0L/*UL*/) {
        return false;
      }
    }
    {
      
      // If bits remain check that they are ones. The unused bits are always zero.
      /*uint*/int Remainder = Size % BITWORD_SIZE;
      if ((Remainder != 0)) {
        return Bits[Size / BITWORD_SIZE] == (1L/*UL*/ << Remainder) - 1;
      }
    }
    
    return true;
  }

  
  /// none - Returns true if none of the bits are set.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::none">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 151,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 150,
   FQN="llvm::BitVector::none", NM="_ZNK4llvm9BitVector4noneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZNK4llvm9BitVector4noneEv")
  //</editor-fold>
  public boolean none() /*const*/ {
    return !any();
  }

  
  /// find_first - Returns the index of the first set bit, -1 if none
  /// of the bits are set.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::find_first">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use appropriate countTrailingZeros*/,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 157,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 156,
   FQN="llvm::BitVector::find_first", NM="_ZNK4llvm9BitVector10find_firstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZNK4llvm9BitVector10find_firstEv")
  //</editor-fold>
  public int find_first() /*const*/ {
    for (/*uint*/int i = 0; $less_uint(i, NumBitWords(size())); ++i)  {
      if (Bits[i] != 0) {
        return i * BITWORD_SIZE + countTrailingZeros_uint64_t_ZeroBehavior(Bits[i]);
      }
    }
    return -1;
  }

  
  /// find_next - Returns the index of the next set bit following the
  /// "Prev" bit. Returns -1 if the next set bit is not found.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::find_next">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use appropriate countTrailingZeros*/,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 166,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 165,
   FQN="llvm::BitVector::find_next", NM="_ZNK4llvm9BitVector9find_nextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZNK4llvm9BitVector9find_nextEj")
  //</editor-fold>
  public int find_next(/*uint*/int Prev) /*const*/ {
    ++Prev;
    if ($greatereq_uint(Prev, Size)) {
      return -1;
    }
    
    /*uint*/int WordPos = Prev / BITWORD_SIZE;
    /*uint*/int BitPos = Prev % BITWORD_SIZE;
    /*ulong*/long Copy = Bits[WordPos];
    // Mask off previous bits.
    Copy &= ~0L/*UL*/ << BitPos;
    if (Copy != 0) {
      return WordPos * BITWORD_SIZE + countTrailingZeros_uint64_t_ZeroBehavior(Copy);
    }
    
    // Check subsequent words.
    for (/*uint*/int i = WordPos + 1; $less_uint(i, NumBitWords(size())); ++i)  {
      if (Bits[i] != 0) {
        return i * BITWORD_SIZE + countTrailingZeros_uint64_t_ZeroBehavior(Bits[i]);
      }
    }
    return -1;
  }

  
  /// clear - Clear all bits.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 188,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 187,
   FQN="llvm::BitVector::clear", NM="_ZN4llvm9BitVector5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector5clearEv")
  //</editor-fold>
  public void clear() {
    Size = 0;
  }

  
  /// resize - Grow or shrink the bitvector.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::resize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 193,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 192,
   FQN="llvm::BitVector::resize", NM="_ZN4llvm9BitVector6resizeEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector6resizeEjb")
  //</editor-fold>
  public void resize(/*uint*/int N) {
    resize(N, false);
  }
  public void resize(/*uint*/int N, boolean t/*= false*/) {
    if ($greater_uint(N, Capacity * BITWORD_SIZE)) {
      /*uint*/int OldCapacity = Capacity;
      grow(N);
      init_words(Bits, OldCapacity, (Capacity-OldCapacity), t);
    }
    
    // Set any old unused bits that are now included in the BitVector. This
    // may set bits that are not included in the new vector, but we will clear
    // them back out below.
    if ($greater_uint(N, Size)) {
      set_unused_bits(t);
    }
    
    // Update the size, and clear out any bits that are now unused
    /*uint*/int OldSize = Size;
    Size = N;
    if (t || $less_uint(N, OldSize)) {
      clear_unused_bits();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::reserve">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 213,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 212,
   FQN="llvm::BitVector::reserve", NM="_ZN4llvm9BitVector7reserveEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector7reserveEj")
  //</editor-fold>
  public void reserve(/*uint*/int N) {
    if ($greater_uint(N, Capacity * BITWORD_SIZE)) {
      grow(N);
    }
  }

  
  // Set, reset, flip
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::set">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 219,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 218,
   FQN="llvm::BitVector::set", NM="_ZN4llvm9BitVector3setEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector3setEv")
  //</editor-fold>
  public BitVector /*&*/ set() {
    init_words(Bits, true);
    clear_unused_bits();
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::set">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 225,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 224,
   FQN="llvm::BitVector::set", NM="_ZN4llvm9BitVector3setEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector3setEj")
  //</editor-fold>
  public BitVector /*&*/ set(/*uint*/int Idx) {
    assert ((Bits != null)) : "Bits never allocated";
    Bits[Idx / BITWORD_SIZE] |= ((/*ulong*/long)(1)) << (Idx % BITWORD_SIZE);
    return /*Deref*/this;
  }

  
  /// set - Efficiently set a range of bits in [I, E)
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::set">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 232,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 231,
   FQN="llvm::BitVector::set", NM="_ZN4llvm9BitVector3setEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector3setEjj")
  //</editor-fold>
  public BitVector /*&*/ set(/*uint*/int I, /*uint*/int E) {
    assert ($lesseq_uint(I, E)) : "Attempted to set backwards range!";
    assert ($lesseq_uint(E, size())) : "Attempted to set out-of-bounds range!";
    if (I == E) {
      return /*Deref*/this;
    }
    if (I / BITWORD_SIZE == E / BITWORD_SIZE) {
      /*ulong*/long EMask = 1L/*UL*/ << (E % BITWORD_SIZE);
      /*ulong*/long IMask = 1L/*UL*/ << (I % BITWORD_SIZE);
      /*ulong*/long Mask = EMask - IMask;
      Bits[I / BITWORD_SIZE] |= Mask;
      return /*Deref*/this;
    }
    
    /*ulong*/long PrefixMask = ~0L/*UL*/ << (I % BITWORD_SIZE);
    Bits[I / BITWORD_SIZE] |= PrefixMask;
    I = $ulong2uint(alignTo($uint2ulong(I), $uint2ulong(BITWORD_SIZE)));
    
    for (; $lesseq_uint(I + BITWORD_SIZE, E); I += BITWORD_SIZE)  {
      Bits [I / BITWORD_SIZE] = ~0L/*UL*/;
    }
    
    /*ulong*/long PostfixMask = (1L/*UL*/ << (E % BITWORD_SIZE)) - 1;
    if ($less_uint(I, E)) {
      Bits[I / BITWORD_SIZE] |= PostfixMask;
    }
    
    return /*Deref*/this;
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 260,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 259,
   FQN="llvm::BitVector::reset", NM="_ZN4llvm9BitVector5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector5resetEv")
  //</editor-fold>
  public BitVector /*&*/ reset() {
    init_words(Bits, false);
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 265,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 264,
   FQN="llvm::BitVector::reset", NM="_ZN4llvm9BitVector5resetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector5resetEj")
  //</editor-fold>
  public BitVector /*&*/ reset(/*uint*/int Idx) {
    Bits[Idx / BITWORD_SIZE] &= ~(((/*ulong*/long)(1)) << (Idx % BITWORD_SIZE));
    return /*Deref*/this;
  }

  
  /// reset - Efficiently reset a range of bits in [I, E)
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 271,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 270,
   FQN="llvm::BitVector::reset", NM="_ZN4llvm9BitVector5resetEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector5resetEjj")
  //</editor-fold>
  public BitVector /*&*/ reset(/*uint*/int I, /*uint*/int E) {
    assert ($lesseq_uint(I, E)) : "Attempted to reset backwards range!";
    assert ($lesseq_uint(E, size())) : "Attempted to reset out-of-bounds range!";
    if (I == E) {
      return /*Deref*/this;
    }
    if (I / BITWORD_SIZE == E / BITWORD_SIZE) {
      /*ulong*/long EMask = 1L/*UL*/ << (E % BITWORD_SIZE);
      /*ulong*/long IMask = 1L/*UL*/ << (I % BITWORD_SIZE);
      /*ulong*/long Mask = EMask - IMask;
      Bits[I / BITWORD_SIZE] &= ~Mask;
      return /*Deref*/this;
    }
    
    /*ulong*/long PrefixMask = ~0L/*UL*/ << (I % BITWORD_SIZE);
    Bits[I / BITWORD_SIZE] &= ~PrefixMask;
    I = $ulong2uint(alignTo($uint2ulong(I), $uint2ulong(BITWORD_SIZE)));
    
    for (; $lesseq_uint(I + BITWORD_SIZE, E); I += BITWORD_SIZE)  {
      Bits[I / BITWORD_SIZE] = 0L/*UL*/;
    }
    
    /*ulong*/long PostfixMask = (1L/*UL*/ << (E % BITWORD_SIZE)) - 1;
    if ($less_uint(I, E)) {
      Bits[I / BITWORD_SIZE] &= ~PostfixMask;
    }
    
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::flip">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 299,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 298,
   FQN="llvm::BitVector::flip", NM="_ZN4llvm9BitVector4flipEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector4flipEv")
  //</editor-fold>
  public BitVector /*&*/ flip() {
    for (/*uint*/int i = 0; $less_uint(i, NumBitWords(size())); ++i)  {
      Bits[i] = ~Bits[i];
    }
    clear_unused_bits();
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::flip">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 306,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 305,
   FQN="llvm::BitVector::flip", NM="_ZN4llvm9BitVector4flipEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector4flipEj")
  //</editor-fold>
  public BitVector /*&*/ flip(/*uint*/int Idx) {
    Bits[Idx / BITWORD_SIZE] ^= ((/*ulong*/long)(1)) << (Idx % BITWORD_SIZE);
    return /*Deref*/this;
  }

  
  // Indexing.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 312,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 311,
   FQN="llvm::BitVector::operator[]", NM="_ZN4llvm9BitVectorixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVectorixEj")
  //</editor-fold>
  public reference $at(/*uint*/int Idx) {
    assert ($less_uint(Idx, Size)) : "Out-of-bounds Bit access.";
    return new reference(/*Deref*/this, Idx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 317,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 316,
   FQN="llvm::BitVector::operator[]", NM="_ZNK4llvm9BitVectorixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZNK4llvm9BitVectorixEj")
  //</editor-fold>
  public boolean $at$Const(/*uint*/int Idx) /*const*/ {
    assert ($less_uint(Idx, Size)) : "Out-of-bounds Bit access.";
    /*ulong*/long Mask = ((/*ulong*/long)(1)) << (Idx % BITWORD_SIZE);
    return (Bits[Idx / BITWORD_SIZE] & Mask) != 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::test">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 323,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 322,
   FQN="llvm::BitVector::test", NM="_ZNK4llvm9BitVector4testEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZNK4llvm9BitVector4testEj")
  //</editor-fold>
  public boolean test(/*uint*/int Idx) /*const*/ {
    return (/*Deref*/this).$at$Const(Idx);
  }

  
  /// Test if any common bits are set.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::anyCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 328,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 327,
   FQN="llvm::BitVector::anyCommon", NM="_ZNK4llvm9BitVector9anyCommonERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZNK4llvm9BitVector9anyCommonERKS0_")
  //</editor-fold>
  public boolean anyCommon(/*const*/ BitVector /*&*/ RHS) /*const*/ {
    /*uint*/int ThisWords = NumBitWords(size());
    /*uint*/int RHSWords = NumBitWords(RHS.size());
    for (/*uint*/int i = 0, e = std.min(ThisWords, RHSWords); i != e; ++i)  {
      if (((Bits[i] & RHS.Bits[i]) != 0)) {
        return true;
      }
    }
    return false;
  }

  
  // Comparison operators.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 338,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 337,
   FQN="llvm::BitVector::operator==", NM="_ZNK4llvm9BitVectoreqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZNK4llvm9BitVectoreqERKS0_")
  //</editor-fold>
  public boolean $eq(/*const*/ BitVector /*&*/ RHS) /*const*/ {
    /*uint*/int ThisWords = NumBitWords(size());
    /*uint*/int RHSWords = NumBitWords(RHS.size());
    /*uint*/int i;
    for (i = 0; i != std.min(ThisWords, RHSWords); ++i)  {
      if (Bits[i] != RHS.Bits[i]) {
        return false;
      }
    }
    
    // Verify that any extra words are all zeros.
    if (i != ThisWords) {
      for (; i != ThisWords; ++i)  {
        if ((Bits[i] != 0)) {
          return false;
        }
      }
    } else if (i != RHSWords) {
      for (; i != RHSWords; ++i)  {
        if ((RHS.Bits[i] != 0)) {
          return false;
        }
      }
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 359,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 358,
   FQN="llvm::BitVector::operator!=", NM="_ZNK4llvm9BitVectorneERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZNK4llvm9BitVectorneERKS0_")
  //</editor-fold>
  public boolean $noteq(/*const*/ BitVector /*&*/ RHS) /*const*/ {
    return !(/*Deref*/this.$eq(RHS));
  }

  
  /// Intersection, union, disjoint union.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::operator&=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 364,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 363,
   FQN="llvm::BitVector::operator&=", NM="_ZN4llvm9BitVectoraNERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVectoraNERKS0_")
  //</editor-fold>
  public BitVector /*&*/ $andassign(/*const*/ BitVector /*&*/ RHS) {
    /*uint*/int ThisWords = NumBitWords(size());
    /*uint*/int RHSWords = NumBitWords(RHS.size());
    /*uint*/int i;
    for (i = 0; i != std.min(ThisWords, RHSWords); ++i)  {
      Bits[i] &= RHS.Bits[i];
    }
    
    // Any bits that are just in this bitvector become zero, because they aren't
    // in the RHS bit vector.  Any words only in RHS are ignored because they
    // are already zero in the LHS.
    for (; i != ThisWords; ++i)  {
      Bits[i] = 0;
    }
    
    return /*Deref*/this;
  }

  
  /// reset - Reset bits that are set in RHS. Same as *this &= ~RHS.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 381,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 380,
   FQN="llvm::BitVector::reset", NM="_ZN4llvm9BitVector5resetERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector5resetERKS0_")
  //</editor-fold>
  public BitVector /*&*/ reset(/*const*/ BitVector /*&*/ RHS) {
    /*uint*/int ThisWords = NumBitWords(size());
    /*uint*/int RHSWords = NumBitWords(RHS.size());
    /*uint*/int i;
    for (i = 0; i != std.min(ThisWords, RHSWords); ++i)  {
      Bits[i] &= ~RHS.Bits[i];
    }
    return /*Deref*/this;
  }

  
  /// test - Check if (This - RHS) is zero.
  /// This is the same as reset(RHS) and any().
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::test">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 392,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 391,
   FQN="llvm::BitVector::test", NM="_ZNK4llvm9BitVector4testERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZNK4llvm9BitVector4testERKS0_")
  //</editor-fold>
  public boolean test(/*const*/ BitVector /*&*/ RHS) /*const*/ {
    /*uint*/int ThisWords = NumBitWords(size());
    /*uint*/int RHSWords = NumBitWords(RHS.size());
    /*uint*/int i;
    for (i = 0; i != std.min(ThisWords, RHSWords); ++i)  {
      if ((Bits[i] & ~RHS.Bits[i]) != 0) {
        return true;
      }
    }
    
    for (; i != ThisWords; ++i)  {
      if (Bits[i] != 0) {
        return true;
      }
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::operator|=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 407,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 406,
   FQN="llvm::BitVector::operator|=", NM="_ZN4llvm9BitVectoroRERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVectoroRERKS0_")
  //</editor-fold>
  public BitVector /*&*/ $orassign(/*const*/ BitVector /*&*/ RHS) {
    if ($less_uint(size(), RHS.size())) {
      resize(RHS.size());
    }
    for (/*size_t*/int i = 0, e = NumBitWords(RHS.size()); i != e; ++i)  {
      Bits[i] |= RHS.Bits[i];
    }
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::operator^=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 415,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 414,
   FQN="llvm::BitVector::operator^=", NM="_ZN4llvm9BitVectoreOERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVectoreOERKS0_")
  //</editor-fold>
  public BitVector /*&*/ $xorassign(/*const*/ BitVector /*&*/ RHS) {
    if ($less_uint(size(), RHS.size())) {
      resize(RHS.size());
    }
    for (/*size_t*/int i = 0, e = NumBitWords(RHS.size()); i != e; ++i)  {
      Bits[i] ^= RHS.Bits[i];
    }
    return /*Deref*/this;
  }

  
  // Assignment operator.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 424,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 423,
   FQN="llvm::BitVector::operator=", NM="_ZN4llvm9BitVectoraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVectoraSERKS0_")
  //</editor-fold>
  public /*const*/ BitVector /*&*/ $assign(/*const*/ BitVector /*&*/ RHS) {
    if (this == $AddrOf(RHS)) {
      return /*Deref*/this;
    }
    
    Size = RHS.size();
    /*uint*/int RHSWords = NumBitWords(Size);
    if ($lesseq_uint(Size, Capacity * BITWORD_SIZE)) {
      if ((Size != 0)) {
        std.memcpy(Bits, RHS.Bits, RHSWords * $sizeof_ULong());
      }
      clear_unused_bits();
      return /*Deref*/this;
    }
    
    // Grow the bitvector to have enough elements.
    Capacity = RHSWords;
    assert ($greater_uint(Capacity, 0)) : "negative capacity?";
    /*ulong*/long[]/*P*/ NewBits = new long[Capacity];
    NativePointer.copy$Object(RHS.Bits, 0, NewBits, 0, Capacity);
    //std.memcpy(NewBits, RHS.Bits, Capacity * $sizeof_ULong());
    
    // Destroy the old bits.
    std.free(Bits);
    Bits = NewBits;
    
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 449,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 448,
   FQN="llvm::BitVector::operator=", NM="_ZN4llvm9BitVectoraSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVectoraSEOS0_")
  //</editor-fold>
  public /*const*/ BitVector /*&*/ $assignMove(BitVector /*&&*/RHS) {
    if (this == $AddrOf(RHS)) {
      return /*Deref*/this;
    }
    
    std.free(Bits);
    Bits = $tryClone(RHS.Bits);
    Size = RHS.Size;
    Capacity = RHS.Capacity;
    
    RHS.Bits = null;
    RHS.Size = RHS.Capacity = 0;
    
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::swap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 463,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 461,
   FQN="llvm::BitVector::swap", NM="_ZN4llvm9BitVector4swapERS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector4swapERS0_")
  //</editor-fold>
  @Override
  public void swap(NativeSwappable /*&*/ _RHS) {    
    BitVector RHS = (BitVector) _RHS;
    //std.swap(Bits, RHS.Bits);
    long[] myBits = Bits;
    Bits = RHS.Bits;
    RHS.Bits = myBits;
    //std.swap(Size, RHS.Size);
    int mySize = Size;
    Size = RHS.Size;
    RHS.Size = mySize;    
    //std.swap(Capacity, RHS.Capacity);
    int myCapacity = Capacity;
    Capacity = RHS.Capacity;
    RHS.Capacity = myCapacity;
  }

  
  //===--------------------------------------------------------------------===//
  // Portable bit mask operations.
  //===--------------------------------------------------------------------===//
  //
  // These methods all operate on arrays of uint32_t, each holding 32 bits. The
  // fixed word size makes it easier to work with literal bit vector constants
  // in portable code.
  //
  // The LSB in each word is the lowest numbered bit.  The size of a portable
  // bit mask is always a whole multiple of 32 bits.  If no bit mask size is
  // given, the bit mask is assumed to cover the entire BitVector.
  
  /// setBitsInMask - Add '1' bits from Mask to this vector. Don't resize.
  /// This computes "*this |= Mask".
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::setBitsInMask">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 483,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 481,
   FQN="llvm::BitVector::setBitsInMask", NM="_ZN4llvm9BitVector13setBitsInMaskEPKjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector13setBitsInMaskEPKjj")
  //</editor-fold>
  public void setBitsInMask(/*const*//*uint32_t P*/uint$ptr Mask) {
    setBitsInMask(Mask, ~0/*U*/);
  }
  public void setBitsInMask(/*const*//*uint32_t P*/uint$ptr Mask, /*uint*/int MaskWords/*= ~0uU*/) {
    applyMask(true, false, Mask, MaskWords);
  }

  
  /// clearBitsInMask - Clear any bits in this vector that are set in Mask.
  /// Don't resize. This computes "*this &= ~Mask".
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::clearBitsInMask">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 489,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 487,
   FQN="llvm::BitVector::clearBitsInMask", NM="_ZN4llvm9BitVector15clearBitsInMaskEPKjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector15clearBitsInMaskEPKjj")
  //</editor-fold>
  public void clearBitsInMask(/*const*//*uint32_t P*/uint$ptr Mask) {
    clearBitsInMask(Mask, ~0/*U*/);
  }
  public void clearBitsInMask(/*const*//*uint32_t P*/uint$ptr Mask, /*uint*/int MaskWords/*= ~0uU*/) {
    applyMask(false, false, Mask, MaskWords);
  }

  
  /// setBitsNotInMask - Add a bit to this vector for every '0' bit in Mask.
  /// Don't resize.  This computes "*this |= ~Mask".
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::setBitsNotInMask">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 495,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 493,
   FQN="llvm::BitVector::setBitsNotInMask", NM="_ZN4llvm9BitVector16setBitsNotInMaskEPKjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector16setBitsNotInMaskEPKjj")
  //</editor-fold>
  public void setBitsNotInMask(/*const*//*uint32_t P*/uint$ptr Mask) {
    setBitsNotInMask(Mask, ~0/*U*/);
  }
  public void setBitsNotInMask(/*const*//*uint32_t P*/uint$ptr Mask, /*uint*/int MaskWords/*= ~0uU*/) {
    applyMask(true, true, Mask, MaskWords);
  }

  
  /// clearBitsNotInMask - Clear a bit in this vector for every '0' bit in Mask.
  /// Don't resize.  This computes "*this &= Mask".
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::clearBitsNotInMask">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 501,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 499,
   FQN="llvm::BitVector::clearBitsNotInMask", NM="_ZN4llvm9BitVector18clearBitsNotInMaskEPKjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector18clearBitsNotInMaskEPKjj")
  //</editor-fold>
  public void clearBitsNotInMask(/*const*//*uint32_t P*/uint$ptr Mask) {
    clearBitsNotInMask(Mask, ~0/*U*/);
  }
  public void clearBitsNotInMask(/*const*//*uint32_t P*/uint$ptr Mask, /*uint*/int MaskWords/*= ~0uU*/) {
    applyMask(false, true, Mask, MaskWords);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::NumBitWords">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 506,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 504,
   FQN="llvm::BitVector::NumBitWords", NM="_ZNK4llvm9BitVector11NumBitWordsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZNK4llvm9BitVector11NumBitWordsEj")
  //</editor-fold>
  private /*uint*/int NumBitWords(/*uint*/int S) /*const*/ {
    return (S + BITWORD_SIZE - 1) / BITWORD_SIZE;
  }

  
  // Set the unused bits in the high words.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::set_unused_bits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 511,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 509,
   FQN="llvm::BitVector::set_unused_bits", NM="_ZN4llvm9BitVector15set_unused_bitsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector15set_unused_bitsEb")
  //</editor-fold>
  private void set_unused_bits() {
    set_unused_bits(true);
  }
  private void set_unused_bits(boolean t/*= true*/) {
    //  Set high words first.
    /*uint*/int UsedWords = NumBitWords(Size);
    if ($greater_uint(Capacity, UsedWords)) {
      init_words(Bits, UsedWords, (Capacity - UsedWords), t);
    }
    
    //  Then set any stray high bits of the last used word.
    /*uint*/int ExtraBits = $rem_uint(Size, BITWORD_SIZE);
    if ((ExtraBits != 0)) {
      /*ulong*/long ExtraBitMask = ~0L/*UL*/ << ExtraBits;
      if (t) {
        Bits[UsedWords-1] |= ExtraBitMask;
      } else {
        Bits[UsedWords-1] &= ~ExtraBitMask;
      }
    }
  }

  
  // Clear the unused bits in the high words.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::clear_unused_bits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 529,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 527,
   FQN="llvm::BitVector::clear_unused_bits", NM="_ZN4llvm9BitVector17clear_unused_bitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector17clear_unused_bitsEv")
  //</editor-fold>
  private void clear_unused_bits() {
    set_unused_bits(false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::grow">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 533,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 531,
   FQN="llvm::BitVector::grow", NM="_ZN4llvm9BitVector4growEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector4growEj")
  //</editor-fold>
  private void grow(/*uint*/int NewSize) {
    Capacity = std.max(NumBitWords(NewSize), Capacity * 2);
    assert ($greater_uint(Capacity, 0)) : "realloc-ing zero space";
    //Bits = std.realloc(Bits, Capacity * $sizeof_ULong()));
    long[] newBits = new long[Capacity];
    if (Bits != null) {
      NativePointer.copy$Object(Bits, 0, newBits, 0, Bits.length);    
    }
    Bits = newBits;
    clear_unused_bits();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::init_words">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 541,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 539,
   FQN="llvm::BitVector::init_words", NM="_ZN4llvm9BitVector10init_wordsEPmjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm9BitVector10init_wordsEPmjb")
  //</editor-fold>
  private void init_words(long[] B, boolean t) {
    Arrays.fill(B, 0 - (int)(t ? 1 : 0));
  }
  private void init_words(long[] B, int From, int NumWords, boolean t) {
    Arrays.fill(B, From, From + NumWords, 0 - (int)(t ? 1 : 0));
  }

  
  /*template <bool AddBits, bool InvertMask> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::applyMask">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 546,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 543,
   FQN="llvm::BitVector::applyMask", NM="Tpl__ZN4llvm9BitVector9applyMaskEPKjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=Tpl__ZN4llvm9BitVector9applyMaskEPKjj")
  //</editor-fold>
  private void applyMask(boolean AddBits, boolean InvertMask, /*const*//*uint32_t P*/uint$ptr Mask, /*uint*/int MaskWords) {
    static_assert(BITWORD_SIZE % 32 == 0, $("Unsupported BitWord size."));
    Mask = $Clone(Mask);
    MaskWords = std.min(MaskWords, (size() + 31) / 32);
    /*const*//*uint*/int Scale = BITWORD_SIZE / 32;
    /*uint*/int i;
    for (i = 0; $greatereq_uint(MaskWords, Scale); ++i , MaskWords -= Scale) {
      /*ulong*/long BW = Bits[i];
      // This inner loop should unroll completely when BITWORD_SIZE > 32.
      for (/*uint*/int b = 0; b != BITWORD_SIZE; b += 32) {
        /*uint32_t*/int M = Mask.$postInc().$star();
        if (InvertMask) {
          M = ~M;
        }
        if (AddBits) {
          BW |= ($uint2ulong(M)) << b;
        } else {
          BW &= ~(($uint2ulong(M)) << b);
        }
      }
      Bits[i] = BW;
    }
    for (/*uint*/int b = 0; (MaskWords != 0); b += 32 , --MaskWords) {
      /*uint32_t*/int M = Mask.$postInc().$star();
      if (InvertMask) {
        M = ~M;
      }
      if (AddBits) {
        Bits[i] |= ($uint2ulong(M)) << b;
      } else {
        Bits[i] &= ~(($uint2ulong(M)) << b);
      }
    }
    if (AddBits) {
      clear_unused_bits();
    }
  }
  
/*public:*/
  /// Return the size (in bytes) of the bit vector.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitVector::getMemorySize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 574,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 572,
   FQN="llvm::BitVector::getMemorySize", NM="_ZNK4llvm9BitVector13getMemorySizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZNK4llvm9BitVector13getMemorySizeEv")
  //</editor-fold>
  public /*size_t*/int getMemorySize() /*const*/ {
    return Capacity * $sizeof_ULong();
  }

  @Override public BitVector clone() { return new BitVector(this); }
  
  @Override public String toString() {
    StringBuilder str = new StringBuilder();
    str.append("Size=").append(Size).append(":");
    for (int i = 0; i < Size; i++) {
      str.append("\n").append(NativeTrace.formatNumber(i, 3)).append(":").append($at$Const(i)?" true":" false");
    }
    return this.getClass().getSimpleName() + str.toString();
  }
}
