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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;


/// StringMapEntryBase - Shared base class of StringMapEntry instances.
//<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryBase">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 31,
 FQN = "llvm::StringMapEntryBase", NM = "_ZN4llvm18StringMapEntryBaseE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZN4llvm18StringMapEntryBaseE")
//</editor-fold>
public abstract class StringMapEntryBaseCharArray extends StringMapEntryBase {

  private static final int IDENTIFIER_HAS_LEN_BITS = 1 << 31;
  private static final int IDENTIFIER_HAS_LEN_MASK = ~IDENTIFIER_HAS_LEN_BITS;
//  private static final int IDENTIFIER_LEN_BITS;
  private static final int IDENTIFIER_LEN_SHIFT_BITS;
  private static final int MAX_IDENTIFIER_SLAB_SIZE;
  private static final int IDENTIFIER_LEN_MAX;
  private static final int IDENTIFIER_INDEX_MASK;
  static {
    assert (NativeMemory.Allocator.MaxPageSize & (NativeMemory.Allocator.MaxPageSize-1)) == 0 : 
            "Must be power of two " + NativeTrace.formatNumber(NativeMemory.Allocator.MaxPageSize);
    int numberOfLeadingZeros = Integer.numberOfLeadingZeros(NativeMemory.Allocator.MaxPageSize-1);
    // we'd like to have at least 8 bits for len 
    if (numberOfLeadingZeros < 8) {
      numberOfLeadingZeros = 8;
    }
//    IDENTIFIER_LEN_BITS = numberOfLeadingZeros-1;
    IDENTIFIER_LEN_SHIFT_BITS = Integer.SIZE - numberOfLeadingZeros;
    MAX_IDENTIFIER_SLAB_SIZE = (1 << IDENTIFIER_LEN_SHIFT_BITS);
    IDENTIFIER_LEN_MAX = (1 << (numberOfLeadingZeros-1)) - 1;
    IDENTIFIER_INDEX_MASK = MAX_IDENTIFIER_SLAB_SIZE - 1;
    assert Integer.numberOfLeadingZeros(IDENTIFIER_INDEX_MASK) == numberOfLeadingZeros : numberOfLeadingZeros + " vs. " + Integer.numberOfLeadingZeros(IDENTIFIER_INDEX_MASK);
    if (NativeTrace.STATISTICS) {
      System.err.printf("IdentifierInfo constants: 1-High-Bit+%d empty bits (%d max len); %d shift; %s B MaxSlab (%s B MaxPage); index %s mask (%d leading zeros) %n", 
              numberOfLeadingZeros-1, IDENTIFIER_LEN_MAX,
              IDENTIFIER_LEN_SHIFT_BITS, 
              NativeTrace.formatNumber(MAX_IDENTIFIER_SLAB_SIZE), NativeTrace.formatNumber(NativeMemory.Allocator.MaxPageSize),
              Integer.toBinaryString(IDENTIFIER_INDEX_MASK), Integer.numberOfLeadingZeros(IDENTIFIER_INDEX_MASK));
    }
  }
  
  public static int MaxSlabSize() {
    return MAX_IDENTIFIER_SLAB_SIZE;
  }
  
  static int get_index(int value) {    
    int unmasked = value & IDENTIFIER_HAS_LEN_MASK;
    if (value == unmasked) {
      // we don't have cached Len
      return unmasked;
    } else {
      return (unmasked & IDENTIFIER_INDEX_MASK);
    }
  }
  
  static boolean no_length(int value) {
    return (value & IDENTIFIER_HAS_LEN_BITS) == 0; 
  }
  static int get_length(int value) {
    int unmasked = value & IDENTIFIER_HAS_LEN_MASK;
    if (value == unmasked) {
      // we don't have cached Len
      return 0;
    } else {
      return (unmasked >>> IDENTIFIER_LEN_SHIFT_BITS);
    }
  }
  
  static int wrap_length_index_pair(int Len, int Index) {
   if (Len <= IDENTIFIER_LEN_MAX && Index < MAX_IDENTIFIER_SLAB_SIZE) {
      // can pack into one field
      int out = IDENTIFIER_HAS_LEN_BITS | (Len << IDENTIFIER_LEN_SHIFT_BITS) | Index;
      assert get_length(out) == Len : "incorrectly cached Len:" + Len + " vs. " + get_length(out);
      assert get_index(out) == Index : "incorrectly cached Index:" + Index + " vs. " + get_index(out);
      return out;
    } else {
      assert Index <= IDENTIFIER_HAS_LEN_MASK : "not enough space for Index " + Index;
      assert get_length(Index) == 0 : "must be not cached " + get_length(Index) + " vs. " + Index;
      assert get_index(Index) == Index : "must be not cached " + get_index(Index) + " vs. " + Index;
      return Index;
    }
  }
  
//  private final /*uint*/int StrLen;
//  private final char$ptr Str;
  private final byte[] StrArray;
  private final int    ArrayStartIndex; 
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryBase::StringMapEntryBase">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 35,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", old_line = 34,
   FQN = "llvm::StringMapEntryBase::StringMapEntryBase", NM = "_ZN4llvm18StringMapEntryBaseC1Ej",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZN4llvm18StringMapEntryBaseC1Ej")
  //</editor-fold>
  public /*explicit*/ StringMapEntryBaseCharArray(/*uint*/int Len) {
    this(createDummyCharPtr(Len), Len);
  }
  public /*explicit*/ StringMapEntryBaseCharArray(char$ptr Str, /*uint*/int Len) {
    /* : StrLen(Len)*/ 
    super(Str, Len);
    //START JInit
//    this.StrLen = $long2uint(Len);
    assert Str instanceof char$ptr$array : "unexpected class " + Str;
    this.StrArray = Str.$array();
    this.ArrayStartIndex = wrap_length_index_pair((int)Len, Str.$index());
//    this.Str = Str;
    //END JInit
    assert getKeyLength() == Len : Len + " vs. " + getKeyLength();
  }
  public /*explicit*/ StringMapEntryBaseCharArray(byte Str[], int fromIdx, /*uint*/int Len) {
    /* : StrLen(Len)*/ 
    super(Str, fromIdx, Len);
    //START JInit
//    this.StrLen = $long2uint(Len);
    this.StrArray = Str;
    this.ArrayStartIndex = wrap_length_index_pair((int)Len, fromIdx);
//    this.Str = Str;
    //END JInit
    assert getKeyLength() == Len : Len + " vs. " + getKeyLength();
  }
  public /*explicit*/ StringMapEntryBaseCharArray(byte Str[], int fromIdx, /*uint*/int Len, int FullHashValue) {
    /* : StrLen(Len)*/ 
    super(Str, fromIdx, Len, FullHashValue);
    //START JInit
//    this.StrLen = $long2uint(Len);
    this.StrArray = Str;
    this.ArrayStartIndex = wrap_length_index_pair((int)Len, fromIdx);
//    this.Str = Str;
    //END JInit
    assert getKeyLength() == Len : Len + " vs. " + getKeyLength();
  }
  
  public /*explicit*/ StringMapEntryBaseCharArray(StringMapEntryBaseCharArray other) {
    /* : StrLen(Len)*/ 
    super(other);
    //START JInit
//    this.StrLen = other.StrLen;
    this.StrArray = other.StrArray;    
    this.ArrayStartIndex = other.ArrayStartIndex;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryBase::getKeyLength">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 37,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", old_line = 36,
   FQN = "llvm::StringMapEntryBase::getKeyLength", NM = "_ZNK4llvm18StringMapEntryBase12getKeyLengthEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZNK4llvm18StringMapEntryBase12getKeyLengthEv")
  //</editor-fold>
  @Override public final /*uint*/int getKeyLength() /*const*/ {
    if (no_length(ArrayStartIndex)) {
      return strlen(StrArray, ArrayStartIndex);
    } else {
      return get_length(ArrayStartIndex);
    }
  }
  
  @Override
  public final char$ptr getKeyStr() {
    return create_const_char$ptr(StrArray, getKeyArrayIndex());
  }

  @Override
  public byte[] getKeyArray() {
    return StrArray;
  }

  @Override
  public int getKeyArrayIndex() {
    return get_index(ArrayStartIndex);
  }
      
  protected static int $sizeof_StringMapEntryBaseCharArray_Fields() {
    return NativeType.BYTES_IN_UINT + NativeType.BYTES_IN_JAVA_OBJECT_REF + $sizeof_StringMapEntryBase_Fields();
  }
}
