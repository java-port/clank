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
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.llvm.support.impl.APIntStatics.*;


//===----------------------------------------------------------------------===//
//                              APInt Class
//===----------------------------------------------------------------------===//

/// \brief Class for arbitrary precision integers.
///
/// APInt is a functional replacement for common case unsigned integer type like
/// "unsigned", "unsigned long" or "uint64_t", but also allows non-byte-width
/// integer sizes and large integer value types such as 3-bits, 15-bits, or more
/// than 64-bits of precision. APInt provides a variety of arithmetic operators
/// and methods to manipulate integer values of any bit-width. It supports both
/// the typical integer arithmetic and comparison operations as well as bitwise
/// manipulation.
///
/// The class has several invariants worth noting:
///   * All bit, byte, and word positions are zero-based.
///   * Once the bit width is set, it doesn't change except by the Truncate,
///     SignExtend, or ZeroExtend operations.
///   * All binary operators must be on APInt instances of the same bit width.
///     Attempting to use these operators on instances with different bit
///     widths will yield an assertion.
///   * The value is stored canonically as an unsigned value. For operations
///     where it makes a difference, there are both signed and unsigned variants
///     of the operation. For example, sdiv and udiv. However, because the bit
///     widths must be the same, operations such as Mul and Add produce the same
///     results regardless of whether the values are interpreted as signed or
///     not.
///   * In general, the class tries to follow the style of computation that LLVM
///     uses in its IR. This simplifies its use for LLVM.
///
//<editor-fold defaultstate="collapsed" desc="llvm::APInt">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 73,
 FQN="llvm::APInt", NM="_ZN4llvm5APIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntE")
//</editor-fold>
public class APInt<T extends APInt> implements FoldingSetTrait.Profilable, Destructors.ClassWithDestructor, Native.NativePOD<T>, NativeMoveable<T> {
  private /*uint*/int BitWidth; ///< The number of bits in this APInt.
    
  /// This union is used to store the integer value. When the
  /// integer bit-width <= 64, it uses VAL, otherwise it uses pVal.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 78,
   FQN="llvm::APInt::(anonymous)", NM="_ZN4llvm5APIntE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntE_Unnamed_union1")
  //</editor-fold>
//  private static class/*union*/ Unnamed_union1 {  
    public long/*uint64_t*/ VAL; ///< Used to store the <= 64 bits integer value.
    public ulong$ptr/*uint64_t P*/ pVal; ///< Used to store the >64 bits integer value.

//    @Override
//    public String toString() {
//      return "{" + "VAL=" + VAL + ", pVal=" + pVal + '}';
//    }
//  };
//  private final Unnamed_union1 Unnamed_field1 = new Unnamed_union1();
  
  /// This enum is used to hold the constants we needed for APInt.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 84,
   FQN="llvm::APInt::(anonymous)", NM="_ZN4llvm5APIntE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_HEX_CONSTANTS {*/
    /// Bits in a word
    public static final /*size_t*/int APINT_BITS_PER_WORD = ((/*static_cast*//*uint*/int)(sizeof$uint64())) * CHAR_BIT;
    /// Byte size of a word
    public static final /*size_t*/int APINT_WORD_SIZE = ((/*static_cast*//*uint*/int)(sizeof$uint64()));
  /*}*/;
  
  /*friend  struct DenseMapAPIntKeyInfo*/
  
  /// \brief Fast internal constructor
  ///
  /// This constructor is used only internally for speed of construction of
  /// temporaries. It is unsafe for general use so it is not public.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::APInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 98,
   FQN="llvm::APInt::APInt", NM="_ZN4llvm5APIntC1EPyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntC1EPyj")
  //</editor-fold>
  /*friend*/public/*private*/ APInt(ulong$ptr/*uint64_t P*/ val, /*uint*/int bits) {
    // : BitWidth(bits), pVal(val) 
    //START JInit
    this.BitWidth = bits;
    this.pVal = val;
    //END JInit
  }

  // JAVA: changed visibility to protected
  /// \brief Determine if this APInt just has one word to store value.
  ///
  /// \returns true if the number of bits <= 64, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::isSingleWord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 103,
   FQN="llvm::APInt::isSingleWord", NM="_ZNK4llvm5APInt12isSingleWordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt12isSingleWordEv")
  //</editor-fold>
  public/*protected*/ boolean isSingleWord() /*const*/ {
    return $lesseq_uint_int(BitWidth, APINT_BITS_PER_WORD);
  }

  
  /// \brief Determine which word a bit is in.
  ///
  /// \returns the word position for the specified bit position.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::whichWord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 108,
   FQN="llvm::APInt::whichWord", NM="_ZN4llvm5APInt9whichWordEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt9whichWordEj")
  //</editor-fold>
  private static /*uint*/int whichWord(/*uint*/int bitPosition) {
    return $div_uint_int(bitPosition, APINT_BITS_PER_WORD);
  }

  
  /// \brief Determine which bit in a word a bit is in.
  ///
  /// \returns the bit position in a word for the specified bit position
  /// in the APInt.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::whichBit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 116,
   FQN="llvm::APInt::whichBit", NM="_ZN4llvm5APInt8whichBitEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt8whichBitEj")
  //</editor-fold>
  private static /*uint*/int whichBit(/*uint*/int bitPosition) {
    return $rem_uint_int(bitPosition, APINT_BITS_PER_WORD);
  }

  
  /// \brief Get a single bit mask.
  ///
  /// \returns a uint64_t with only bit at "whichBit(bitPosition)" set
  /// This method generates and returns a uint64_t (word) mask for a single
  /// bit at a specific bit position. This is used to mask the bit in the
  /// corresponding word.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::maskBit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 126,
   FQN="llvm::APInt::maskBit", NM="_ZN4llvm5APInt7maskBitEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt7maskBitEj")
  //</editor-fold>
  private static long/*uint64_t*/ maskBit(/*uint*/int bitPosition) {
    return 1L/*ULL*/ << whichBit(bitPosition);
  }

  
  /// \brief Clear unused high order bits
  ///
  /// This method is used internally to clear the top "N" bits in the high order
  /// word that are not used by the APInt. This is needed after the most
  /// significant word is assigned a value to ensure that those bits are
  /// zero'd out.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::clearUnusedBits">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 136,
   FQN="llvm::APInt::clearUnusedBits", NM="_ZN4llvm5APInt15clearUnusedBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt15clearUnusedBitsEv")
  //</editor-fold>
  private APInt /*&*/ clearUnusedBits() {
    // Compute how many bits are used in the final word
    /*uint*/int wordBits = $rem_uint_int(BitWidth, APINT_BITS_PER_WORD);
    if (wordBits == 0) {
      // If all bits are used, we want to leave the value alone. This also
      // avoids the undefined behavior of >> when the shift is the same size as
      // the word size (64).
      return /*Deref*/this;
    }
    
    // Mask out the high bits.
    long/*uint64_t*/ mask = ~((long/*uint64_t*/)(0L/*ULL*/)) >>> (APINT_BITS_PER_WORD - wordBits);
    if (isSingleWord()) {
      this.VAL &= mask;
    } else {
      this.pVal.$set$andassign(getNumWords() - 1, mask);
    }
    return /*Deref*/this;
  }

  
  /// \brief Get the word corresponding to a bit position
  /// \returns the corresponding word for the specified bit position.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getWord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 156,
   FQN="llvm::APInt::getWord", NM="_ZNK4llvm5APInt7getWordEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt7getWordEj")
  //</editor-fold>
  private long/*uint64_t*/ getWord(/*uint*/int bitPosition) /*const*/ {
    return isSingleWord() ? this.VAL : this.pVal.$at(whichWord(bitPosition));
  }

  
  /// \brief Convert a char array into an APInt
  ///
  /// \param radix 2, 8, 10, 16, or 36
  /// Converts a string into a number.  The string must be non-empty
  /// and well-formed as a number of the given base. The bit-width
  /// must be sufficient to hold the result.
  ///
  /// This is used by the constructors that take string arguments.
  ///
  /// StringRef::getAsInteger is superficially similar but (1) does
  /// not assume that the string is well-formed and (2) grows the
  /// result to hold the input.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::fromString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2087,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2083,
   FQN="llvm::APInt::fromString", NM="_ZN4llvm5APInt10fromStringEjNS_9StringRefEh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt10fromStringEjNS_9StringRefEh")
  //</editor-fold>
  private void fromString(/*uint*/int numbits, StringRef str, byte/*uint8_t*/ radix) {
    // Check our assumptions here
    assert (!str.empty()) : "Invalid string length";
    assert (($uchar2int(radix) == 10 || $uchar2int(radix) == 8 || $uchar2int(radix) == 16 || $uchar2int(radix) == 2 || $uchar2int(radix) == 36)) : "Radix should be 2, 8, 10, 16, or 36!";
    
    char$ptr p = $tryClone(str.begin());
    /*size_t*/int slen = str.size();
    boolean isNeg = p.$star() == $$MINUS;
    if (p.$star() == $$MINUS || p.$star() == $$PLUS) {
      p.$postInc();
      slen--;
      assert ((slen != 0)) : "String is only a sign, needs a value.";
    }
    assert (($lesseq_uint(slen, numbits) || $uchar2int(radix) != 2)) : "Insufficient bit width";
    assert (($lesseq_uint((slen - 1) * 3, numbits) || $uchar2int(radix) != 8)) : "Insufficient bit width";
    assert (($lesseq_uint((slen - 1) * 4, numbits) || $uchar2int(radix) != 16)) : "Insufficient bit width";
    assert (($lesseq_uint($div_uint(((slen - 1) * 64), 22), numbits) || $uchar2int(radix) != 10)) : "Insufficient bit width";
    
    // Allocate memory
    if (!isSingleWord()) {
      this.pVal = $tryClone(getClearedMemory(getNumWords()));
    }
    
    // Figure out if we can shift instead of multiply
    /*uint*/int shift = ($uchar2int(radix) == 16 ? 4 : $uchar2int(radix) == 8 ? 3 : $uchar2int(radix) == 2 ? 1 : 0);
    
    // Set up an APInt for the digit to add outside the loop so we don't
    // constantly construct/destruct it.
    APInt apdigit/*J*/= new APInt(getBitWidth(), 0);
    APInt apradix/*J*/= new APInt(getBitWidth(), $uchar2ulong(radix));
    
    // Enter digit traversal loop
    for (char$ptr e = $tryClone(str.end()); $noteq_ptr(p, e); p.$preInc()) {
      /*uint*/int digit = getDigit(p.$star(), radix);
      assert ($less_uint_uchar(digit, radix)) : "Invalid character in digit string";
      
      // Shift or multiply the value by the radix
      if ($greater_uint(slen, 1)) {
        if ((shift != 0)) {
          $Deref(this.$lshiftassign(shift));
        } else {
          $Deref(this.$starassign(apradix));
        }
      }
      
      // Add in the digit we just interpreted
      if (apdigit.isSingleWord()) {
        apdigit.VAL = $uint2ulong(digit);
      } else {
        apdigit.pVal.$set(0, $uint2ulong(digit));
      }
      $Deref(this.$addassign(apdigit));
    }
    // If its negative, put it in two's complement form
    if (isNeg) {
      (/*Deref*/this).$preDec();
      this.flipAllBits();
    }
  }

  
  /// \brief An internal division function for dividing APInts.
  ///
  /// This is used by the toString method to divide by the radix. It simply
  /// provides a more convenient form of divide for internal use since KnuthDiv
  /// has specific constraints on its inputs. If those constraints are not met
  /// then it provides a simpler form of divide.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::divide">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1667,
   FQN="llvm::APInt::divide", NM="_ZN4llvm5APInt6divideERKS0_jS2_jPS0_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt6divideERKS0_jS2_jPS0_S3_")
  //</editor-fold>
  private static void divide(final /*const*/ APInt /*&*/ LHS, /*uint*/int lhsWords, final /*const*/ APInt /*&*/ RHS, 
        /*uint*/int rhsWords, APInt /*P*/ Quotient, APInt /*P*/ Remainder) {
    assert ($greatereq_uint(lhsWords, rhsWords)) : "Fractional result";

    // First, compose the values into an array of 32-bit words instead of
    // 64-bit words. This is a necessity of both the "short division" algorithm
    // and the Knuth "classical algorithm" which requires there to be native
    // operations for +, -, and * on an m bit value with an m*2 bit result. We
    // can't use 64-bit operands here because we don't have native results of
    // 128-bits. Furthermore, casting the 64-bit values to 32-bit values won't
    // work on large-endian machines.
    long/*uint64_t*/ mask = ~0L/*ULL*/ >>> (sizeof$uint32() * CHAR_BIT);
    /*uint*/int n = rhsWords * 2;
    /*uint*/int m = (lhsWords * 2) - n;

    // Allocate space for the temporary values we need either on the stack, if
    // it will fit, or on the heap if it won't.
    /*uint*/uint$ptr SPACE = create_uint$ptr(new$uint(128));
    uint$ptr/*uint P*/ U = null;
    uint$ptr/*uint P*/ V = null;
    uint$ptr/*uint P*/ Q = null;
    uint$ptr/*uint P*/ R = null;
    if ($lesseq_uint(((Remainder != null) ? 4 : 3) * n + 2 * m + 1, 128)) {
      U = $AddrOf(SPACE.$add(0));
      V = $AddrOf(SPACE.$add((int)m + n + 1));
      Q = $AddrOf(SPACE.$add((int)(m + n + 1) + n));
      if ((Remainder != null)) {
        R = $AddrOf(SPACE.$add((int)(m + n + 1) + n + (m + n)));
      }
    } else {
      U = create_uint$ptr(new$uint(m + n + 1));
      V = create_uint$ptr(new$uint(n));
      Q = create_uint$ptr(new$uint(m + n));
      if ((Remainder != null)) {
        R = create_uint$ptr(new$uint(n));
      }
    }

    // Initialize the dividend
    memset(U, 0, (m + n + 1) * sizeof$uint32());
    for (/*uint*/int i = 0; $less_uint(i, lhsWords); ++i) {
      long/*uint64_t*/ tmp = (LHS.getNumWords() == 1 ? LHS.VAL : LHS.pVal.$at(i));
      U.$set(i * 2, (/*uint*/int)$ullong2uint((tmp & mask)));
      U.$set(i * 2 + 1, (/*uint*/int)$ulong2uint((tmp >>> (sizeof$uint32() * CHAR_BIT))));
    }
    U.$set(m + n, 0); // this extra word is for "spill" in the Knuth algorithm.

    // Initialize the divisor
    memset(V, 0, (n) * sizeof$uint32());
    for (/*uint*/int i = 0; $less_uint(i, rhsWords); ++i) {
      long/*uint64_t*/ tmp = (RHS.getNumWords() == 1 ? RHS.VAL : RHS.pVal.$at(i));
      V.$set(i * 2, (/*uint*/int)$ullong2uint((tmp & mask)));
      V.$set(i * 2 + 1, (/*uint*/int)$ulong2uint((tmp >>> (sizeof$uint32() * CHAR_BIT))));
    }

    // initialize the quotient and remainder
    memset(Q, 0, (m + n) * sizeof$uint32());
    if ((Remainder != null)) {
      memset(R, 0, n * sizeof$uint32());
    }

    // Now, adjust m and n for the Knuth division. n is the number of words in
    // the divisor. m is the number of words by which the dividend exceeds the
    // divisor (i.e. m+n is the length of the dividend). These sizes must not
    // contain any zero words or the Knuth algorithm fails.
    for (/*uint*/int i = n; $greater_uint(i, 0) && V.$at(i - 1) == 0; i--) {
      n--;
      m++;
    }
    for (/*uint*/int i = m + n; $greater_uint(i, 0) && U.$at(i - 1) == 0; i--)  {
      m--;
    }

    // If we're left with only a single word for the divisor, Knuth doesn't work
    // so we implement the short division algorithm here. This is much simpler
    // and faster because we are certain that we can divide a 64-bit quantity
    // by a 32-bit quantity at hardware speed and short division is simply a
    // series of such operations. This is just like doing short division but we
    // are using base 2^32 instead of base 10.
    assert (n != 0) : "Divide by zero?";
    if (n == 1) {
      /*uint*/int divisor = V.$at(0);
      /*uint*/int remainder = 0;
      for (int i = m + n - 1; i >= 0; i--) {
        long/*uint64_t*/ partial_dividend = ((long/*uint64_t*/)($uint2ulong(remainder))) << 32 | $uint2ullong(U.$at(i));
        if (partial_dividend == 0) {
          Q.$set(i, 0);
          remainder = 0;
        } else if ($less_ulong_uint(partial_dividend, divisor)) {
          Q.$set(i, 0);
          remainder = (/*uint*/int)(partial_dividend);
        } else if (partial_dividend == $uint2ullong(divisor)) {
          Q.$set(i, 1);
          remainder = 0;
        } else {
          Q.$set(i, (/*uint*/int)(($div_ulong_uint(partial_dividend, divisor))));
          remainder = (/*uint*/int)((partial_dividend - $uint2ullong((Q.$at(i) * divisor))));
        }
      }
      if ((R != null)) {
        R.$set(0, remainder);
      }
    } else {
      // Now we're ready to invoke the Knuth classical divide algorithm. In this
      // case n > 1.
      KnuthDiv(U, V, Q, R, m, n);
    }

    // If the caller wants the quotient
    if ((Quotient != null)) {
      // Set up the Quotient value's memory.
      if (Quotient.BitWidth != LHS.BitWidth) {
        if (Quotient.isSingleWord()) {
          Quotient.VAL = 0;
        } else {
          /*delete[]*/Destructors.$destroyArray(Quotient.pVal);
        }
        Quotient.BitWidth = LHS.BitWidth;
        if (!Quotient.isSingleWord()) {
          Quotient.pVal = $tryClone(getClearedMemory(Quotient.getNumWords()));
        }
      } else {
        Quotient.clearAllBits();
      }

      // The quotient is in Q. Reconstitute the quotient into Quotient's low
      // order words.
      // This case is currently dead as all users of divide() handle trivial cases
      // earlier.
      if (lhsWords == 1) {
        long/*uint64_t*/ tmp = ((long/*uint64_t*/)($uint2ulong(Q.$at(0)))) | (((long/*uint64_t*/)($uint2ulong(Q.$at(1)))) << (APINT_BITS_PER_WORD / 2));
        if (Quotient.isSingleWord()) {
          Quotient.VAL = tmp;
        } else {
          Quotient.pVal.$set(0, tmp);
        }
      } else {
        assert (!Quotient.isSingleWord()) : "Quotient APInt not large enough";
        for (/*uint*/int i = 0; $less_uint(i, lhsWords); ++i)  {
          Quotient.pVal.$set(i, 
            ((long/*uint64_t*/)($uint2ulong(Q.$at(i * 2)))) | (((long/*uint64_t*/)($uint2ulong(Q.$at(i * 2 + 1)))) << (APINT_BITS_PER_WORD / 2)));
        }
      }
    }

    // If the caller wants the remainder
    if ((Remainder != null)) {
      // Set up the Remainder value's memory.
      if (Remainder.BitWidth != RHS.BitWidth) {
        if (Remainder.isSingleWord()) {
          Remainder.VAL = 0;
        } else {
          /*delete[]*/Destructors.$destroyArray(Remainder.pVal);
        }
        Remainder.BitWidth = RHS.BitWidth;
        if (!Remainder.isSingleWord()) {
          Remainder.pVal = $tryClone(getClearedMemory(Remainder.getNumWords()));
        }
      } else {
        Remainder.clearAllBits();
      }

      // The remainder is in R. Reconstitute the remainder into Remainder's low
      // order words.
      if (rhsWords == 1) {
        long/*uint64_t*/ tmp = ((long/*uint64_t*/)($uint2ulong(R.$at(0)))) | (((long/*uint64_t*/)($uint2ulong(R.$at(1)))) << (APINT_BITS_PER_WORD / 2));
        if (Remainder.isSingleWord()) {
          Remainder.VAL = tmp;
        } else {
          Remainder.pVal.$set(0, tmp);
        }
      } else {
        assert (!Remainder.isSingleWord()) : "Remainder APInt not large enough";
        for (/*uint*/int i = 0; $less_uint(i, rhsWords); ++i)  {
          Remainder.pVal.$set(i, 
            ((long/*uint64_t*/)($uint2ulong(R.$at(i * 2)))) | (((long/*uint64_t*/)($uint2ulong(R.$at(i * 2 + 1)))) << (APINT_BITS_PER_WORD / 2)));
        }
      }
    }

    // Clean up the memory we allocated.
    if ($noteq_ptr(U, $AddrOf(SPACE))) {
      /*delete[]*/Destructors.$destroyArray(U);
      /*delete[]*/Destructors.$destroyArray(V);
      /*delete[]*/Destructors.$destroyArray(Q);
      /*delete[]*/Destructors.$destroyArray(R);
    }
  }

  
  /// out-of-line slow case for inline constructor
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::initSlowCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 78,
   FQN="llvm::APInt::initSlowCase", NM="_ZN4llvm5APInt12initSlowCaseEyb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt12initSlowCaseEyb")
  //</editor-fold>
  private void initSlowCase(/*uint*/int numBits, long/*uint64_t*/ val, boolean isSigned) {
    this.pVal = $tryClone(getClearedMemory(getNumWords(numBits)));
    this.pVal.$set(0, val);
    if (isSigned && ((long/*int64_t*/)(val)) < 0L) {
      for (/*uint*/int i = 1; i < getNumWords(numBits); ++i)  {
        this.pVal.$set(i, -1L/*ULL*/);
      }
    }
  }

  
  /// shared code between two array constructors
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::initFromArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 91,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 90,
   FQN="llvm::APInt::initFromArray", NM="_ZN4llvm5APInt13initFromArrayENS_8ArrayRefIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt13initFromArrayENS_8ArrayRefIyEE")
  //</editor-fold>
  private void initFromArray(ArrayRefULong bigVal) {
    assert ((BitWidth != 0)) : "Bitwidth too small";
    assert ((bigVal.data() != null)) : "Null pointer detected!";
    if (isSingleWord()) {
      this.VAL = bigVal.$at(0);
    } else {
      // Get memory, cleared to 0
      this.pVal = $tryClone(getClearedMemory(getNumWords()));
      // Calculate the number of words to copy
      /*uint*/int words = std.min(bigVal.size(), getNumWords());
      // Copy the words from bigVal to pVal
      memcpy(this.pVal, bigVal.data(), words * APINT_WORD_SIZE);
    }
    // Make sure unused high bits are cleared
    clearUnusedBits();
  }

  
  /// out-of-line slow case for inline copy constructor
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::initSlowCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 86,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 85,
   FQN="llvm::APInt::initSlowCase", NM="_ZN4llvm5APInt12initSlowCaseERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt12initSlowCaseERKS0_")
  //</editor-fold>
  private void initSlowCase(final /*const*/ APInt /*&*/ that) {
    this.pVal = $tryClone(getMemory(getNumWords()));
    memcpy(this.pVal, that.pVal, getNumWords() * APINT_WORD_SIZE);
  }

  
  /// out-of-line slow case for shl
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::shlSlowCase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1217,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1211,
   FQN="llvm::APInt::shlSlowCase", NM="_ZNK4llvm5APInt11shlSlowCaseEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt11shlSlowCaseEj")
  //</editor-fold>
  private APInt shlSlowCase(/*uint*/int shiftAmt) /*const*/ {
    // If all the bits were shifted out, the result is 0. This avoids issues
    // with shifting by the size of the integer type, which produces undefined
    // results. We define these "undefined results" to always be 0.
    if (shiftAmt == BitWidth) {
      return new APInt(JD$UInt_ULong.INSTANCE, BitWidth, 0);
    }
    
    // If none of the bits are shifted out, the result is *this. This avoids a
    // lshr by the words size in the loop below which can produce incorrect
    // results. It also avoids the expensive computation below for a common case.
    if (shiftAmt == 0) {
      return new APInt(/*Deref*/this);
    }
    
    // Create some space for the result.
    ulong$ptr/*uint64_t P*/ val = create_ulong$ptr(/*uint64_t*/new$ulong(getNumWords()));
    
    // If we are shifting less than a word, do it the easy way
    if ($less_uint_int(shiftAmt, APINT_BITS_PER_WORD)) {
      long/*uint64_t*/ carry = 0;
      for (/*uint*/int i = 0; $less_uint(i, getNumWords()); i++) {
        val.$set(i, (this.pVal.$at(i) << shiftAmt) | carry);
        carry = this.pVal.$at(i) >>> (APINT_BITS_PER_WORD - shiftAmt);
      }
      APInt Result/*J*/= new APInt(val, BitWidth);
      Result.clearUnusedBits();
      return Result;
    }
    
    // Compute some values needed by the remaining shift algorithms
    /*uint*/int wordShift = $rem_uint_int(shiftAmt, APINT_BITS_PER_WORD);
    /*uint*/int offset = $div_uint_int(shiftAmt, APINT_BITS_PER_WORD);
    
    // If we are shifting whole words, just move whole words
    if (wordShift == 0) {
      for (/*uint*/int i = 0; $less_uint(i, offset); i++)  {
        val.$set(i, 0);
      }
      for (/*uint*/int i = offset; $less_uint(i, getNumWords()); i++)  {
        val.$set(i, this.pVal.$at(i - offset));
      }
      APInt Result = new APInt(val, BitWidth);
      Result.clearUnusedBits();
      return Result;
    }
    
    // Copy whole words from this to Result.
    /*uint*/int i = getNumWords() - 1;
    for (; $greater_uint(i, offset); --i)  {
      val.$set(i, this.pVal.$at(i - offset) << wordShift
         | this.pVal.$at(i - offset - 1) >>> (APINT_BITS_PER_WORD - wordShift));
    }
    val.$set(offset, this.pVal.$at(0) << wordShift);
    for (i = 0; $less_uint(i, offset); ++i)  {
      val.$set(i, 0);
    }
    APInt Result/*J*/= new APInt(val, BitWidth);
    Result.clearUnusedBits();
    return Result;
  }

  
  /// out-of-line slow case for operator&
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::AndSlowCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 436,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 435,
   FQN="llvm::APInt::AndSlowCase", NM="_ZNK4llvm5APInt11AndSlowCaseERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt11AndSlowCaseERKS0_")
  //</editor-fold>
  private APInt AndSlowCase(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    /*uint*/int numWords = getNumWords();
    ulong$ptr/*uint64_t P*/ val = $tryClone(getMemory(numWords));
    for (/*uint*/int i = 0; $less_uint(i, numWords); ++i)  {
      val.$set(i, this.pVal.$at(i) & RHS.pVal.$at(i));
    }
    return new APInt(val, getBitWidth());
  }

  
  /// out-of-line slow case for operator|
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::OrSlowCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 444,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 443,
   FQN="llvm::APInt::OrSlowCase", NM="_ZNK4llvm5APInt10OrSlowCaseERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt10OrSlowCaseERKS0_")
  //</editor-fold>
  private APInt OrSlowCase(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    /*uint*/int numWords = getNumWords();
    ulong$ptr/*uint64_t P*/ val = $tryClone(getMemory(numWords));
    for (/*uint*/int i = 0; $less_uint(i, numWords); ++i)  {
      val.$set(i, this.pVal.$at(i) | RHS.pVal.$at(i));
    }
    return new APInt(val, getBitWidth());
  }

  
  /// out-of-line slow case for operator^
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::XorSlowCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 452,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 451,
   FQN="llvm::APInt::XorSlowCase", NM="_ZNK4llvm5APInt11XorSlowCaseERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt11XorSlowCaseERKS0_")
  //</editor-fold>
  private APInt XorSlowCase(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    /*uint*/int numWords = getNumWords();
    ulong$ptr/*uint64_t P*/ val = $tryClone(getMemory(numWords));
    for (/*uint*/int i = 0; $less_uint(i, numWords); ++i)  {
      val.$set(i, this.pVal.$at(i) ^ RHS.pVal.$at(i));
    }

    APInt Result/*J*/= new APInt(val, getBitWidth());
    // 0^0==1 so clear the high bits in case they got set.
    Result.clearUnusedBits();
    return Result;
  }


  /// out-of-line slow case for operator=
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::AssignSlowCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 124,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 123,
   FQN="llvm::APInt::AssignSlowCase", NM="_ZN4llvm5APInt14AssignSlowCaseERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt14AssignSlowCaseERKS0_")
  //</editor-fold>
  private APInt /*&*/ AssignSlowCase(final /*const*/ APInt /*&*/ RHS) {
    // Don't do anything for X = X
    if (this == $AddrOf(RHS)) {
      return /*Deref*/this;
    }
    if (BitWidth == RHS.getBitWidth()) {
      // assume same bit-width single-word case is already handled
      assert (!isSingleWord());
      memcpy(this.pVal, RHS.pVal, getNumWords() * APINT_WORD_SIZE);
      return /*Deref*/this;
    }
    if (isSingleWord()) {
      // assume case where both are single words is already handled
      assert (!RHS.isSingleWord());
      this.VAL = 0;
      this.pVal = $tryClone(getMemory(RHS.getNumWords()));
      memcpy(this.pVal, RHS.pVal, RHS.getNumWords() * APINT_WORD_SIZE);
    } else if (getNumWords() == RHS.getNumWords()) {
      memcpy(this.pVal, RHS.pVal, RHS.getNumWords() * APINT_WORD_SIZE);
    } else if (RHS.isSingleWord()) {
      /*delete[]*/Destructors.$destroyArray(this.pVal);
      this.VAL = RHS.VAL;
    } else {
      /*delete[]*/Destructors.$destroyArray(this.pVal);
      this.pVal = $tryClone(getMemory(RHS.getNumWords()));
      memcpy(this.pVal, RHS.pVal, RHS.getNumWords() * APINT_WORD_SIZE);
    }
    BitWidth = RHS.BitWidth;
    return clearUnusedBits();
  }

  
  /// out-of-line slow case for operator==
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::EqualSlowCase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 511,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 492,
   FQN="llvm::APInt::EqualSlowCase", NM="_ZNK4llvm5APInt13EqualSlowCaseERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt13EqualSlowCaseERKS0_")
  //</editor-fold>
  private boolean EqualSlowCase(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    // Get some facts about the number of bits used in the two operands.
    /*uint*/int n1 = getActiveBits();
    /*uint*/int n2 = RHS.getActiveBits();
    
    // If the number of bits isn't the same, they aren't equal
    if (n1 != n2) {
      return false;
    }
    
    // If the number of bits fits in a word, we only need to compare the low word.
    if (n1 <= APINT_BITS_PER_WORD) {
      return this.pVal.$at(0) == RHS.pVal.$at(0);
    }
    
    // Otherwise, compare everything
    for (int i = whichWord(n1 - 1); i >= 0; --i)  {
      if (this.pVal.$at(i) != RHS.pVal.$at(i)) {
        return false;
      }
    }
    return true;
  }

  
  /// out-of-line slow case for operator==
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::EqualSlowCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 515,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 512,
   FQN="llvm::APInt::EqualSlowCase", NM="_ZNK4llvm5APInt13EqualSlowCaseEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt13EqualSlowCaseEy")
  //</editor-fold>
  private boolean EqualSlowCase(long/*uint64_t*/ Val) /*const*/ {
    /*uint*/int n = getActiveBits();
    if ($lesseq_uint_int(n, APINT_BITS_PER_WORD)) {
      return this.pVal.$at(0) == Val;
    } else {
      return false;
    }
  }

  
  /// out-of-line slow case for countLeadingZeros
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::countLeadingZerosSlowCase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 681,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 694,
   FQN="llvm::APInt::countLeadingZerosSlowCase", NM="_ZNK4llvm5APInt25countLeadingZerosSlowCaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt25countLeadingZerosSlowCaseEv")
  //</editor-fold>
  private /*uint*/int countLeadingZerosSlowCase() /*const*/ {
    // Treat the most significand word differently because it might have
    // meaningless bits set beyond the precision.
    /*uint*/int BitsInMSW = BitWidth % APINT_BITS_PER_WORD;
    long/*uint64_t*/ MSWMask;
    if ((BitsInMSW != 0)) {
      MSWMask = (((long/*uint64_t*/)(1)) << BitsInMSW) - 1;
    } else {
      MSWMask = ~((long/*uint64_t*/)(0));
      BitsInMSW = APINT_BITS_PER_WORD;
    }
    
    /*uint*/int i = getNumWords();
    long/*uint64_t*/ MSW = this.pVal.$at(i - 1) & MSWMask;
    /*uint*/int Count;
    if ((MSW != 0)) {
      Count = llvm.countLeadingZeros(MSW) - (APINT_BITS_PER_WORD - BitsInMSW);
    } else {
      Count = BitsInMSW;
      for (--i; i > 0/*U*/; --i) {
        if (this.pVal.$at(i - 1) == 0) {
          Count += APINT_BITS_PER_WORD;
        } else {
          Count += llvm.countLeadingZeros(this.pVal.$at(i - 1));
          break;
        }
      }
    }
    return Count;
  }

  
  /// out-of-line slow case for countTrailingOnes
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::countTrailingOnesSlowCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 737,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 761,
   FQN="llvm::APInt::countTrailingOnesSlowCase", NM="_ZNK4llvm5APInt25countTrailingOnesSlowCaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt25countTrailingOnesSlowCaseEv")
  //</editor-fold>
  private /*uint*/int countTrailingOnesSlowCase() /*const*/ {
    /*uint*/int Count = 0;
    /*uint*/int i = 0;
    for (; $less_uint(i, getNumWords()) && this.pVal.$at(i) == -1L/*ULL*/; ++i)  {
      Count += APINT_BITS_PER_WORD;
    }
    if ($less_uint(i, getNumWords())) {
      Count += CountTrailingOnes_64(this.pVal.$at(i));
    }
    return std.min_uint(Count, BitWidth);
  }

  
  /// out-of-line slow case for countPopulation
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::countPopulationSlowCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 747,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 771,
   FQN="llvm::APInt::countPopulationSlowCase", NM="_ZNK4llvm5APInt23countPopulationSlowCaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt23countPopulationSlowCaseEv")
  //</editor-fold>
  private /*uint*/int countPopulationSlowCase() /*const*/ {
    /*uint*/int Count = 0;
    for (/*uint*/int i = 0; $less_uint(i, getNumWords()); ++i)  {
      Count += CountPopulation_64(this.pVal.$at(i));
    }
    return Count;
  }

/*public:*/
  /// \name Constructors
  /// @{
  
  /// \brief Create a new APInt of numBits width, initialized as val.
  ///
  /// If isSigned is true then val is treated as if it were a signed value
  /// (i.e. as an int64_t) and the appropriate sign extension to the bit width
  /// will be done. Otherwise, no sign extension occurs (high order bits beyond
  /// the range of val are zero filled).
  ///
  /// \param numBits the bit width of the constructed APInt
  /// \param val the initial value of the APInt
  /// \param isSigned how to treat signedness of val
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::APInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 236,
   FQN="llvm::APInt::APInt", NM="_ZN4llvm5APIntC1Ejyb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntC1Ejyb")
  //</editor-fold>
  public APInt(JD$UInt_ULong _dparam,/*uint*/int numBits, long/*uint64_t*/ val) {
    this(_dparam, numBits, val, false);
  }
  public APInt(JD$UInt_ULong _dparam, /*uint*/int numBits, long/*uint64_t*/ val, boolean isSigned/*= false*/) {
    // : BitWidth(numBits), VAL(0)
    //START JInit
    this.BitWidth = numBits;
    /*Indirect*/this.VAL = 0;
    //END JInit
    assert ((BitWidth != 0)) : "bitwidth too small " + BitWidth;
    if (isSingleWord()) {
      this.VAL = val;
    } else {
      initSlowCase(numBits, val, isSigned);
    }
    clearUnusedBits();
  }
  @Converted(kind = Converted.Kind.DEPRECATED)
  public APInt(/*uint*/int numBits, long/*uint64_t*/ val) {
    this(JD$UInt_ULong.INSTANCE, numBits, val);
  }
  
  
  /// \brief Construct an APInt of numBits width, initialized as bigVal[].
  ///
  /// Note that bigVal.size() can be smaller or larger than the corresponding
  /// bit width but any extraneous bits will be dropped.
  ///
  /// \param numBits the bit width of the constructed APInt
  /// \param bigVal a sequence of words to form the initial value of the APInt
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::APInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 108,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 107,
   FQN="llvm::APInt::APInt", NM="_ZN4llvm5APIntC1EjNS_8ArrayRefIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntC1EjNS_8ArrayRefIyEE")
  //</editor-fold>
  public APInt(/*uint*/int numBits, ArrayRefULong bigVal) {
    /* : BitWidth(numBits), VAL(0)*/ 
    //START JInit
    assert numBits >= 0 : "BitWidth must not be negatove: " + numBits;
    this.BitWidth = numBits;
    /*Indirect*/this.VAL = 0;
    //END JInit
    initFromArray(bigVal);
  }
  public APInt(int numBits, int NumWords, ulong$ptr $bigVal) {
    this(numBits, makeArrayRef$ULong($bigVal, NumWords));
  }
  
  /// Equivalent to APInt(numBits, ArrayRef<uint64_t>(bigVal, numWords)), but
  /// deprecated because this constructor is prone to ambiguity with the
  /// APInt(unsigned, uint64_t, bool) constructor.
  ///
  /// If this overload is ever deleted, care should be taken to prevent calls
  /// from being incorrectly captured by the APInt(unsigned, uint64_t, bool)
  /// constructor.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::APInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 113,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 112,
   FQN="llvm::APInt::APInt", NM="_ZN4llvm5APIntC1EjjPKy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntC1EjjPKy")
  //</editor-fold>
  public APInt(JD$UInt_UInt _dparam, /*uint*/int numBits, /*uint*/int numWords, /*const*/long/*uint64_t*/ bigVal[]) {
    /* : BitWidth(numBits), VAL(0)*/ 
    assert numBits >= 0 : "must be non negative " + numBits;
    assert numWords >= 0 : "must be non negative " + numWords;
    //START JInit
    this.BitWidth = numBits;
    /*Indirect*/this.VAL = 0;
    //END JInit
    initFromArray(makeArrayRef$ULong(bigVal, numWords));
  }
  @Converted(kind = Converted.Kind.DEPRECATED)
  public APInt(/*uint*/int numBits, /*uint*/int numWords, /*const*/long/*uint64_t*/ bigVal[]) {
    this(JD$UInt_UInt.INSTANCE, numBits, numWords, bigVal);
  }

  
  /// \brief Construct an APInt from a string representation.
  ///
  /// This constructor interprets the string \p str in the given radix. The
  /// interpretation stops when the first character that is not suitable for the
  /// radix is encountered, or the end of the string. Acceptable radix values
  /// are 2, 8, 10, 16, and 36. It is an error for the value implied by the
  /// string to require more bits than numBits.
  ///
  /// \param numBits the bit width of the constructed APInt
  /// \param str the string to be interpreted
  /// \param radix the radix to use for the conversion
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::APInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 118,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 117,
   FQN="llvm::APInt::APInt", NM="_ZN4llvm5APIntC1EjNS_9StringRefEh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntC1EjNS_9StringRefEh")
  //</editor-fold>
  public APInt(/*uint*/int numbits, StringRef Str, byte/*uint8_t*/ radix) {
    // : BitWidth(numbits), VAL(0) 
    //START JInit
    this.BitWidth = numbits;
    /*Indirect*/this.VAL = 0;
    //END JInit
    assert ((BitWidth != 0)) : "Bitwidth too small";
    fromString(numbits, Str, radix);
  }
  
  // JAVA: convenient construtors 
  public APInt(/*uint*/int numbits, StringRef Str, int/*uint8_t*/ radix) {
    this(numbits, Str, $uint2uchar(radix));
  }
  public APInt(/*uint*/int numbits, String Str, int/*uint8_t*/ radix) {
    this(numbits, new StringRef(Str), $uint2uchar(radix));
  }
  
  /// Simply makes *this a copy of that.
  /// @brief Copy Constructor.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::APInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 279,
   FQN="llvm::APInt::APInt", NM="_ZN4llvm5APIntC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntC1ERKS0_")
  //</editor-fold>
  public APInt(final /*const*/ APInt /*&*/ that) {
    // : BitWidth(that.BitWidth), VAL(0) 
    //START JInit
    this.BitWidth = that.BitWidth;
    /*Indirect*/this.VAL = 0;
    //END JInit
    if (isSingleWord()) {
      this.VAL = that.VAL;
    } else {
      initSlowCase(that);
    }
  }

  
  /// \brief Move Constructor.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::APInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 287,
   FQN="llvm::APInt::APInt", NM="_ZN4llvm5APIntC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntC1EOS0_")
  //</editor-fold>
  public APInt(JD$Move _dparam, final APInt /*&&*/that) {
    // : BitWidth(that.BitWidth), VAL(that..VAL) 
    //START JInit
    this.BitWidth = that.BitWidth;
    /*Indirect*/this.VAL = that.VAL;
    /*Indirect*/this.pVal = that.pVal;
    //END JInit
    that.BitWidth = 0;
    that.pVal = null;
  }

  
  /// \brief Destructor.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::~APInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 292,
   FQN="llvm::APInt::~APInt", NM="_ZN4llvm5APIntD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (needsCleanup()) {
      /*delete[]*/Destructors.$destroyArray(this.pVal);
    }
  }

  
  /// \brief Default constructor that creates an uninteresting APInt
  /// representing a 1-bit zero value.
  ///
  /// This is useful for object deserialization (pair this with the static
  ///  method Read).
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::APInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 302,
   FQN="llvm::APInt::APInt", NM="_ZN4llvm5APIntC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntC1Ev")
  //</editor-fold>
  public /*explicit*/ APInt() {
    // : BitWidth(1), VAL(0) 
    //START JInit
    this.BitWidth = 1;
    /*Indirect*/this.VAL = 0;
    //END JInit
  }

  
  /// \brief Returns whether this instance allocated memory.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::needsCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 305,
   FQN="llvm::APInt::needsCleanup", NM="_ZNK4llvm5APInt12needsCleanupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt12needsCleanupEv")
  //</editor-fold>
  public boolean needsCleanup() /*const*/ {
    return !isSingleWord();
  }

  
  /// Used to insert APInt objects, or objects that contain APInt objects, into
  ///  FoldingSets.
  
  /// This method 'profiles' an APInt for use with FoldingSet.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 167,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 166,
   FQN="llvm::APInt::Profile", NM="_ZNK4llvm5APInt7ProfileERNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt7ProfileERNS_16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddInteger_uint(BitWidth);
    if (isSingleWord()) {
      ID.AddInteger_ullong(this.VAL);
      return;
    }
    
    /*uint*/int NumWords = getNumWords();
    for (/*uint*/int i = 0; $less_uint(i, NumWords); ++i)  {
      ID.AddInteger_ullong(this.pVal.$at(i));
    }
  }

  
  /// @}
  /// \name Value Tests
  /// @{
  
  /// \brief Determine sign of this APInt.
  ///
  /// This tests the high bit of this APInt to determine if it is set.
  ///
  /// \returns true if this APInt is negative, false otherwise
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::isNegative">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 320,
   FQN="llvm::APInt::isNegative", NM="_ZNK4llvm5APInt10isNegativeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt10isNegativeEv")
  //</editor-fold>
  public boolean isNegative() /*const*/ {
    return (/*Deref*/this).$at(BitWidth - 1);
  }

  
  /// \brief Determine if this APInt Value is non-negative (>= 0)
  ///
  /// This tests the high bit of the APInt to determine if it is unset.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::isNonNegative">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 325,
   FQN="llvm::APInt::isNonNegative", NM="_ZNK4llvm5APInt13isNonNegativeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt13isNonNegativeEv")
  //</editor-fold>
  public boolean isNonNegative() /*const*/ {
    return !isNegative();
  }

  
  /// \brief Determine if this APInt Value is positive.
  ///
  /// This tests if the value of this APInt is positive (> 0). Note
  /// that 0 is not a positive value.
  ///
  /// \returns true if this APInt is positive.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::isStrictlyPositive">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 333,
   FQN="llvm::APInt::isStrictlyPositive", NM="_ZNK4llvm5APInt18isStrictlyPositiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt18isStrictlyPositiveEv")
  //</editor-fold>
  public boolean isStrictlyPositive() /*const*/ {
    return isNonNegative() && !$Deref(this.$not());
  }

  
  /// \brief Determine if all bits are set
  ///
  /// This checks to see if the value has all bits of the APInt are set or not.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::isAllOnesValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 338,
   FQN="llvm::APInt::isAllOnesValue", NM="_ZNK4llvm5APInt14isAllOnesValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt14isAllOnesValueEv")
  //</editor-fold>
  public boolean isAllOnesValue() /*const*/ {
    if (isSingleWord()) {
      return this.VAL == ~((long/*uint64_t*/)(0)) >>> (APINT_BITS_PER_WORD - BitWidth);
    }
    return countPopulationSlowCase() == BitWidth;
  }

  
  /// \brief Determine if this is the largest unsigned value.
  ///
  /// This checks to see if the value of this APInt is the maximum unsigned
  /// value for the APInt's bit width.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::isMaxValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 348,
   FQN="llvm::APInt::isMaxValue", NM="_ZNK4llvm5APInt10isMaxValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt10isMaxValueEv")
  //</editor-fold>
  public boolean isMaxValue() /*const*/ {
    return isAllOnesValue();
  }

  
  /// \brief Determine if this is the largest signed value.
  ///
  /// This checks to see if the value of this APInt is the maximum signed
  /// value for the APInt's bit width.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::isMaxSignedValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 354,
   FQN="llvm::APInt::isMaxSignedValue", NM="_ZNK4llvm5APInt16isMaxSignedValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt16isMaxSignedValueEv")
  //</editor-fold>
  public boolean isMaxSignedValue() /*const*/ {
    return BitWidth == 1 ? this.VAL == 0 : !isNegative() && countPopulation() == BitWidth - 1;
  }

  
  /// \brief Determine if this is the smallest unsigned value.
  ///
  /// This checks to see if the value of this APInt is the minimum unsigned
  /// value for the APInt's bit width.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::isMinValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 362,
   FQN="llvm::APInt::isMinValue", NM="_ZNK4llvm5APInt10isMinValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt10isMinValueEv")
  //</editor-fold>
  public boolean isMinValue() /*const*/ {
    return $Deref(this.$not());
  }

  
  /// \brief Determine if this is the smallest signed value.
  ///
  /// This checks to see if the value of this APInt is the minimum signed
  /// value for the APInt's bit width.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::isMinSignedValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 368,
   FQN="llvm::APInt::isMinSignedValue", NM="_ZNK4llvm5APInt16isMinSignedValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt16isMinSignedValueEv")
  //</editor-fold>
  public boolean isMinSignedValue() /*const*/ {
    return BitWidth == 1 ? this.VAL == 1 : isNegative() && isPowerOf2();
  }

  
  /// \brief Check if this APInt has an N-bits unsigned integer value.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::isIntN">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 373,
   FQN="llvm::APInt::isIntN", NM="_ZNK4llvm5APInt6isIntNEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt6isIntNEj")
  //</editor-fold>
  public boolean isIntN(/*uint*/int N) /*const*/ {
    assert ((N != 0)) : "N == 0 ???";
    return $lesseq_uint(getActiveBits(), N);
  }

  
  /// \brief Check if this APInt has an N-bits signed integer value.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::isSignedIntN">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 379,
   FQN="llvm::APInt::isSignedIntN", NM="_ZNK4llvm5APInt12isSignedIntNEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt12isSignedIntNEj")
  //</editor-fold>
  public boolean isSignedIntN(/*uint*/int N) /*const*/ {
    assert ((N != 0)) : "N == 0 ???";
    return $lesseq_uint(getMinSignedBits(), N);
  }

  
  /// \brief Check if this APInt's value is a power of two greater than zero.
  ///
  /// \returns true if the argument APInt value is a power of two > 0.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::isPowerOf2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 387,
   FQN="llvm::APInt::isPowerOf2", NM="_ZNK4llvm5APInt10isPowerOf2Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt10isPowerOf2Ev")
  //</editor-fold>
  public boolean isPowerOf2() /*const*/ {
    if (isSingleWord()) {
      return isPowerOf2_64(this.VAL);
    }
    return countPopulationSlowCase() == 1;
  }

  
  /// \brief Check if the APInt's value is returned by getSignBit.
  ///
  /// \returns true if this is the value returned by getSignBit.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::isSignBit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 396,
   FQN="llvm::APInt::isSignBit", NM="_ZNK4llvm5APInt9isSignBitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt9isSignBitEv")
  //</editor-fold>
  public boolean isSignBit() /*const*/ {
    return isMinSignedValue();
  }

  
  /// \brief Convert APInt to a boolean value.
  ///
  /// This converts the APInt to a boolean value as a test against zero.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getBoolValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 401,
   FQN="llvm::APInt::getBoolValue", NM="_ZNK4llvm5APInt12getBoolValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt12getBoolValueEv")
  //</editor-fold>
  public boolean getBoolValue() /*const*/ {
    return !$Deref(this.$not());
  }

  
  /// If this value is smaller than the specified limit, return it, otherwise
  /// return the limit value.  This causes the value to saturate to the limit.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getLimitedValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 405,
   FQN="llvm::APInt::getLimitedValue", NM="_ZNK4llvm5APInt15getLimitedValueEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt15getLimitedValueEy")
  //</editor-fold>
  public long/*uint64_t*/ getLimitedValue() /*const*/ {
    return getLimitedValue(~0L/*ULL*/);
  }
  public long/*uint64_t*/ getLimitedValue(long/*uint64_t*/ Limit/*= ~0ULLULL*/) /*const*/ {
    return ($greater_uint(getActiveBits(), 64) || $greater_ulong(getZExtValue(), Limit)) ? Limit : getZExtValue();
  }

  
  /// \brief Check if the APInt consists of a repeated bit pattern.
  ///
  /// e.g. 0x01010101 satisfies isSplat(8).
  /// \param SplatSizeInBits The size of the pattern in bits. Must divide bit
  /// width without remainder.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::isSplat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 662,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 675,
   FQN="llvm::APInt::isSplat", NM="_ZNK4llvm5APInt7isSplatEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt7isSplatEj")
  //</editor-fold>
  public boolean isSplat(/*uint*/int SplatSizeInBits) /*const*/ {
    assert ($rem_uint(getBitWidth(), SplatSizeInBits) == 0) : "SplatSizeInBits must divide width!";
    // We can check that all parts of an integer are equal by making use of a
    // little trick: rotate and check if it's still the same value.
    return /*Deref*/this.$eq(rotl(SplatSizeInBits));
  }

  
  /// @}
  /// \name Value Generators
  /// @{
  
  /// \brief Gets maximum unsigned value of APInt for specific bit width.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getMaxValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 422,
   FQN="llvm::APInt::getMaxValue", NM="_ZN4llvm5APInt11getMaxValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt11getMaxValueEj")
  //</editor-fold>
  public static APInt getMaxValue(/*uint*/int numBits) {
    return getAllOnesValue(numBits);
  }

  
  /// \brief Gets maximum signed value of APInt for a specific bit width.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getSignedMaxValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 427,
   FQN="llvm::APInt::getSignedMaxValue", NM="_ZN4llvm5APInt17getSignedMaxValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt17getSignedMaxValueEj")
  //</editor-fold>
  public static APInt getSignedMaxValue(/*uint*/int numBits) {
    APInt API = getAllOnesValue(numBits);
    API.clearBit(numBits - 1);
    return API;
  }

  
  /// \brief Gets minimum unsigned value of APInt for a specific bit width.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getMinValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 434,
   FQN="llvm::APInt::getMinValue", NM="_ZN4llvm5APInt11getMinValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt11getMinValueEj")
  //</editor-fold>
  public static APInt getMinValue(/*uint*/int numBits) {
    return new APInt(JD$UInt_ULong.INSTANCE, numBits, 0);
  }

  
  /// \brief Gets minimum signed value of APInt for a specific bit width.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getSignedMinValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 437,
   FQN="llvm::APInt::getSignedMinValue", NM="_ZN4llvm5APInt17getSignedMinValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt17getSignedMinValueEj")
  //</editor-fold>
  public static APInt getSignedMinValue(/*uint*/int numBits) {
    APInt API/*J*/= new APInt(JD$UInt_ULong.INSTANCE, numBits, 0);
    API.setBit(numBits - 1);
    return API;
  }

  
  /// \brief Get the SignBit for a specific bit width.
  ///
  /// This is just a wrapper function of getSignedMinValue(), and it helps code
  /// readability when we want to get a SignBit.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getSignBit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 447,
   FQN="llvm::APInt::getSignBit", NM="_ZN4llvm5APInt10getSignBitEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt10getSignBitEj")
  //</editor-fold>
  public static APInt getSignBit(/*uint*/int BitWidth) {
    return getSignedMinValue(BitWidth);
  }

  
  /// \brief Get the all-ones value.
  ///
  /// \returns the all-ones value for an APInt of the specified bit-width.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getAllOnesValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 454,
   FQN="llvm::APInt::getAllOnesValue", NM="_ZN4llvm5APInt15getAllOnesValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt15getAllOnesValueEj")
  //</editor-fold>
  public static APInt getAllOnesValue(/*uint*/int numBits) {
    return new APInt(JD$UInt_ULong.INSTANCE, numBits, UINT64_MAX, true);
  }

  
  /// \brief Get the '0' value.
  ///
  /// \returns the '0' value for an APInt of the specified bit-width.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getNullValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 461,
   FQN="llvm::APInt::getNullValue", NM="_ZN4llvm5APInt12getNullValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt12getNullValueEj")
  //</editor-fold>
  public static APInt getNullValue(/*uint*/int numBits) {
    return new APInt(JD$UInt_ULong.INSTANCE, numBits, 0);
  }

  
  /// \brief Compute an APInt containing numBits highbits from this APInt.
  ///
  /// Get an APInt with the same BitWidth as this APInt, just zero mask
  /// the low bits and right shift to the least significant bit.
  ///
  /// \returns the high "numBits" bits of this APInt.
  
  /// This function returns the high "numBits" bits of this APInt.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getHiBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 671,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 684,
   FQN="llvm::APInt::getHiBits", NM="_ZNK4llvm5APInt9getHiBitsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt9getHiBitsEj")
  //</editor-fold>
  public APInt getHiBits(/*uint*/int numBits) /*const*/ {
    return APIntOps.lshr(/*Deref*/this, BitWidth - numBits);
  }

  
  /// \brief Compute an APInt containing numBits lowbits from this APInt.
  ///
  /// Get an APInt with the same BitWidth as this APInt, just zero mask
  /// the high bits.
  ///
  /// \returns the low "numBits" bits of this APInt.
  
  /// This function returns the low "numBits" bits of this APInt.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getLoBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 676,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 689,
   FQN="llvm::APInt::getLoBits", NM="_ZNK4llvm5APInt9getLoBitsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt9getLoBitsEj")
  //</editor-fold>
  public APInt getLoBits(/*uint*/int numBits) /*const*/ {
    return APIntOps.lshr(APIntOps.shl(/*Deref*/this, BitWidth - numBits), 
        BitWidth - numBits);
  }

  
  /// \brief Return an APInt with exactly one bit set in the result.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getOneBitSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 480,
   FQN="llvm::APInt::getOneBitSet", NM="_ZN4llvm5APInt12getOneBitSetEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt12getOneBitSetEjj")
  //</editor-fold>
  public static APInt getOneBitSet(/*uint*/int numBits, /*uint*/int BitNo) {
    APInt Res/*J*/= new APInt(JD$UInt_ULong.INSTANCE, numBits, 0);
    Res.setBit(BitNo);
    return Res;
  }

  
  /// \brief Get a value with a block of bits set.
  ///
  /// Constructs an APInt value that has a contiguous range of bits set. The
  /// bits from loBit (inclusive) to hiBit (exclusive) will be set. All other
  /// bits will be zero. For example, with parameters(32, 0, 16) you would get
  /// 0x0000FFFF. If hiBit is less than loBit then the set bits "wrap". For
  /// example, with parameters (32, 28, 4), you would get 0xF000000F.
  ///
  /// \param numBits the intended bit width of the result
  /// \param loBit the index of the lowest bit set.
  /// \param hiBit the index of the highest bit set.
  ///
  /// \returns An APInt value with the requested bits set.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getBitsSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 499,
   FQN="llvm::APInt::getBitsSet", NM="_ZN4llvm5APInt10getBitsSetEjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt10getBitsSetEjjj")
  //</editor-fold>
  public static APInt getBitsSet(/*uint*/int numBits, /*uint*/int loBit, /*uint*/int hiBit) {
    assert ($lesseq_uint(hiBit, numBits)) : "hiBit out of range";
    assert ($less_uint(loBit, numBits)) : "loBit out of range";
    if ($less_uint(hiBit, loBit)) {
      return getLowBitsSet(numBits, hiBit).$bitor(
              getHighBitsSet(numBits, numBits - loBit)
      );
    }
    return getLowBitsSet(numBits, hiBit - loBit).shl(loBit);
  }

  
  /// \brief Get a value with high bits set
  ///
  /// Constructs an APInt value that has the top hiBitsSet bits set.
  ///
  /// \param numBits the bitwidth of the result
  /// \param hiBitsSet the number of high-order bits set in the result.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getHighBitsSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 514,
   FQN="llvm::APInt::getHighBitsSet", NM="_ZN4llvm5APInt14getHighBitsSetEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt14getHighBitsSetEjj")
  //</editor-fold>
  public static APInt getHighBitsSet(/*uint*/int numBits, /*uint*/int hiBitsSet) {
    assert ($lesseq_uint(hiBitsSet, numBits)) : "Too many bits to set!";
    // Handle a degenerate case, to avoid shifting by word size
    if (hiBitsSet == 0) {
      return new APInt(JD$UInt_ULong.INSTANCE, numBits, 0);
    }
    /*uint*/int shiftAmt = numBits - hiBitsSet;
    // For small values, return quickly
    if ($lesseq_uint_int(numBits, APINT_BITS_PER_WORD)) {
      return new APInt(JD$UInt_ULong.INSTANCE, numBits, ~0L/*ULL*/ << shiftAmt);
    }
    return getAllOnesValue(numBits).shl(shiftAmt);
  }

  
  /// \brief Get a value with low bits set
  ///
  /// Constructs an APInt value that has the bottom loBitsSet bits set.
  ///
  /// \param numBits the bitwidth of the result
  /// \param loBitsSet the number of low-order bits set in the result.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getLowBitsSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 532,
   FQN="llvm::APInt::getLowBitsSet", NM="_ZN4llvm5APInt13getLowBitsSetEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt13getLowBitsSetEjj")
  //</editor-fold>
  public static APInt getLowBitsSet(/*uint*/int numBits, /*uint*/int loBitsSet) {
    assert ($lesseq_uint(loBitsSet, numBits)) : "Too many bits to set!";
    // Handle a degenerate case, to avoid shifting by word size
    if (loBitsSet == 0) {
      return new APInt(JD$UInt_ULong.INSTANCE, numBits, 0);
    }
    if (loBitsSet == APINT_BITS_PER_WORD) {
      return new APInt(JD$UInt_ULong.INSTANCE, numBits, std.UINT64_MAX);
    }
    // For small values, return quickly.
    if ($lesseq_uint_int(loBitsSet, APINT_BITS_PER_WORD)) {
      return new APInt(JD$UInt_ULong.INSTANCE, numBits, std.UINT64_MAX >>> (APINT_BITS_PER_WORD - loBitsSet));
    }
    return getAllOnesValue(numBits).lshr(numBits - loBitsSet);
  }

  
  /// \brief Return a value containing V broadcasted over NewLen bits.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getSplat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 546,
   FQN="llvm::APInt::getSplat", NM="_ZN4llvm5APInt8getSplatEjRKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt8getSplatEjRKS0_")
  //</editor-fold>
  public static APInt getSplat(/*uint*/int NewLen, final /*const*/ APInt /*&*/ V) {
    assert ($greatereq_uint(NewLen, V.getBitWidth())) : "Can't splat to smaller bit width!";
    
    APInt Val = V.zextOrSelf(NewLen);
    for (/*uint*/int I = V.getBitWidth(); $less_uint(I, NewLen); I <<= 1)  {
      Val.$orassign(Val.$out(I));
    }
    
    return Val;
  }

  
  /// \brief Determine if two APInts have the same value, after zero-extending
  /// one of them (if needed!) to ensure that the bit-widths match.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::isSameValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 558,
   FQN="llvm::APInt::isSameValue", NM="_ZN4llvm5APInt11isSameValueERKS0_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt11isSameValueERKS0_S2_")
  //</editor-fold>
  public static boolean isSameValue(final /*const*/ APInt /*&*/ I1, final /*const*/ APInt /*&*/ I2) {
    if (I1.getBitWidth() == I2.getBitWidth()) {
      return I1.$eq(I2);
    }
    if ($greater_uint(I1.getBitWidth(), I2.getBitWidth())) {
      return I1.$eq(I2.zext(I1.getBitWidth()));
    }
    
    return I1.zext(I2.getBitWidth()).$eq(I2);
  }

  
  /// \brief Overload to compute a hash_code for an APInt value.
  /*friend hash_code hash_value(const APInt &Arg)*/
  
  /// This function returns a pointer to the internal storage of the APInt.
  /// This is useful for writing out the APInt in binary form without any
  /// conversions.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getRawData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 574,
   FQN="llvm::APInt::getRawData", NM="_ZNK4llvm5APInt10getRawDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt10getRawDataEv")
  //</editor-fold>
  public /*const*/ulong$ptr/*uint64_t P*/ getRawData() /*const*/ {
    if (isSingleWord()) {
      // JAVA: return as address
      return new ulong$ptr$inout(APInt.this) {
        @Override protected /*ulong*/long $star$impl() { return APInt.this.VAL; }

        @Override protected /*ulong*/long $set$impl(/*ulong*/long value) { 
          return APInt.this.VAL = value;
        }
      };      
    }
    return this.pVal.$add(0);
  }

  
  /// @}
  /// \name Unary Operators
  /// @{
  
  /// \brief Postfix increment operator.
  ///
  /// \returns a new APInt value representing *this incremented by one
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 587,
   FQN="llvm::APInt::operator++", NM="_ZN4llvm5APIntppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntppEi")
  //</editor-fold>
  public /*const*/ APInt $postInc(int $Prm0) {
    APInt API/*J*/= new APInt(/*Deref*/this);
    (/*Deref*/this).$preInc();
    return API;
  }

  
  /// \brief Prefix increment operator.
  ///
  /// \returns *this incremented by one
  
  /// @brief Prefix increment operator. Increments the APInt by one.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 198,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 197,
   FQN="llvm::APInt::operator++", NM="_ZN4llvm5APIntppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntppEv")
  //</editor-fold>
  public APInt /*&*/ $preInc() {
    if (isSingleWord()) {
      ++this.VAL;
    } else {
      add_1(this.pVal, this.pVal, getNumWords(), 1);
    }
    return clearUnusedBits();
  }

  
  /// \brief Postfix decrement operator.
  ///
  /// \returns a new APInt representing *this decremented by one.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator--">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 601,
   FQN="llvm::APInt::operator--", NM="_ZN4llvm5APIntmmEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntmmEi")
  //</editor-fold>
  public /*const*/ APInt $postDec(int $Prm0) {
    APInt API/*J*/= new APInt(/*Deref*/this);
    (/*Deref*/this).$preDec();
    return API;
  }

  
  /// \brief Prefix decrement operator.
  ///
  /// \returns *this decremented by one.
  
  /// @brief Prefix decrement operator. Decrements the APInt by one.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator--">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 227,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 226,
   FQN="llvm::APInt::operator--", NM="_ZN4llvm5APIntmmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntmmEv")
  //</editor-fold>
  public APInt /*&*/ $preDec() {
    if (isSingleWord()) {
      --this.VAL;
    } else {
      sub_1(this.pVal, getNumWords(), 1);
    }
    return clearUnusedBits();
  }

  
  /// \brief Unary bitwise complement operator.
  ///
  /// Performs a bitwise complement operation on this APInt.
  ///
  /// \returns an APInt that is the bitwise complement of *this
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator~">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 617,
   FQN="llvm::APInt::operator~", NM="_ZNK4llvm5APIntcoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APIntcoEv")
  //</editor-fold>
  public APInt $bitnot() /*const*/ {
    APInt Result/*J*/= new APInt(/*Deref*/this);
    Result.flipAllBits();
    return Result;
  }

  
  /// \brief Unary negation operator
  ///
  /// Negates *this using two's complement logic.
  ///
  /// \returns An APInt value representing the negation of *this.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator-">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 628,
   FQN="llvm::APInt::operator-", NM="_ZNK4llvm5APIntngEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APIntngEv")
  //</editor-fold>
  public APInt $sub() /*const*/ {
    APInt Result/*J*/= new APInt(/*Deref*/this);
    Result.flipAllBits();
    Result.$preInc();
    return Result;
  }

  
  /// \brief Logical negation operator.
  ///
  /// Performs logical negation operation on this APInt.
  ///
  /// \returns true if *this is zero, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator!">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 640,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 635,
   FQN="llvm::APInt::operator!", NM="_ZNK4llvm5APIntntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APIntntEv")
  //</editor-fold>
  public boolean $not() /*const*/ {
    if (isSingleWord()) {
      return !(this.VAL != 0);
    }
    
    for (/*uint*/int i = 0; i != getNumWords(); ++i)  {
      if ((this.pVal.$at(i) != 0)) {
        return false;
      }
    }
    return true;
  }

  
  /// @}
  /// \name Assignment Operators
  /// @{
  
  /// \brief Copy assignment operator.
  ///
  /// \returns *this after assignment of RHS.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 657,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 652,
   FQN="llvm::APInt::operator=", NM="_ZN4llvm5APIntaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntaSERKS0_")
  //</editor-fold>
  public APInt /*&*/ $assign(final /*const*/ APInt /*&*/ RHS) {
    // If the bitwidths are the same, we can avoid mucking with memory
    if (isSingleWord() && RHS.isSingleWord()) {
      this.VAL = RHS.VAL;
      BitWidth = RHS.BitWidth;
      return clearUnusedBits();
    }
    
    return AssignSlowCase(RHS);
  }

  
  /// @brief Move assignment operator.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator=">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 669,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 664,
   FQN="llvm::APInt::operator=", NM="_ZN4llvm5APIntaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntaSEOS0_")
  //</editor-fold>
  public APInt /*&*/ $assignMove(final APInt /*&&*/that) {
    if (!isSingleWord()) {
      // The MSVC STL shipped in 2013 requires that self move assignment be a
      // no-op.  Otherwise algorithms like stable_sort will produce answers
      // where half of the output is left in a moved-from state.
      if (this == $AddrOf(that)) {
        return /*Deref*/this;
      }
      /*delete[]*/Destructors.$destroyArray(pVal);
    }
    
    // Use memcpy so that type based alias analysis sees both VAL and pVal
    // as modified.
    VAL = that.VAL;
    pVal = that.pVal;
    that.pVal = null;
    //memcpy(/*AddrOf*/Unnamed_field1.VAL, /*AddrOf*/that.Unnamed_field1.VAL, sizeof$uint64());
    
    // If 'this == &that', avoid zeroing our own bitwidth by storing to 'that'
    // first.
    /*uint*/int ThatBitWidth = that.BitWidth;
    that.BitWidth = 0;
    BitWidth = ThatBitWidth;
    
    return /*Deref*/this;
  }
  
  
  /// \brief Assignment operator.
  ///
  /// The RHS value is assigned to *this. If the significant bits in RHS exceed
  /// the bit width, the excess bits are truncated. If the bit width is larger
  /// than 64, the value is zero filled in the unspecified high order bits.
  ///
  /// \returns *this after assignment of RHS value.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 156,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 155,
   FQN="llvm::APInt::operator=", NM="_ZN4llvm5APIntaSEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntaSEy")
  //</editor-fold>
  public APInt /*&*/ $assign(long/*uint64_t*/ RHS) {
    if (isSingleWord()) {
      this.VAL = RHS;
    } else {
      this.pVal.$set(0, RHS);
      memset(this.pVal.$add(1), 0, (getNumWords() - 1) * APINT_WORD_SIZE);
    }
    return clearUnusedBits();
  }

  public APInt /*&*/ $assign(boolean RHS) {
    return /*Deref*/$assign(RHS ? 1 : 0);
  }
  
  /// \brief Bitwise AND assignment operator.
  ///
  /// Performs a bitwise AND operation on this APInt and RHS. The result is
  /// assigned to *this.
  ///
  /// \returns *this after ANDing with RHS.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator&=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 399,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 398,
   FQN="llvm::APInt::operator&=", NM="_ZN4llvm5APIntaNERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntaNERKS0_")
  //</editor-fold>
  public APInt /*&*/ $andassign(final /*const*/ APInt /*&*/ RHS) {
    assert (BitWidth == RHS.BitWidth) : "Bit widths must be the same";
    if (isSingleWord()) {
      this.VAL &= RHS.VAL;
      return /*Deref*/this;
    }
    /*uint*/int numWords = getNumWords();
    for (/*uint*/int i = 0; $less_uint(i, numWords); ++i)  {
      this.pVal.$set$andassign(i, RHS.pVal.$at(i));
    }
    return /*Deref*/this;
  }

  
  /// \brief Bitwise OR assignment operator.
  ///
  /// Performs a bitwise OR operation on this APInt and RHS. The result is
  /// assigned *this;
  ///
  /// \returns *this after ORing with RHS.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator|=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 411,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 410,
   FQN="llvm::APInt::operator|=", NM="_ZN4llvm5APIntoRERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntoRERKS0_")
  //</editor-fold>
  public APInt /*&*/ $orassign(final /*const*/ APInt /*&*/ RHS) {
    assert (BitWidth == RHS.BitWidth) : "Bit widths must be the same";
    if (isSingleWord()) {
      this.VAL |= RHS.VAL;
      return /*Deref*/this;
    }
    /*uint*/int numWords = getNumWords();
    for (/*uint*/int i = 0; $less_uint(i, numWords); ++i)  {
      this.pVal.$set$orassign(i, RHS.pVal.$at(i));
    }
    return /*Deref*/this;
  }

  
  /// \brief Bitwise OR assignment operator.
  ///
  /// Performs a bitwise OR operation on this APInt and RHS. RHS is
  /// logically zero-extended or truncated to match the bit-width of
  /// the LHS.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator|=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 722,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 717,
   FQN="llvm::APInt::operator|=", NM="_ZN4llvm5APIntoREy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntoREy")
  //</editor-fold>
  public APInt /*&*/ $orassign(long/*uint64_t*/ RHS) {
    if (isSingleWord()) {
      this.VAL |= RHS;
      clearUnusedBits();
    } else {
      this.pVal.$set$orassign(0, RHS);
    }
    return /*Deref*/this;
  }

  
  /// \brief Bitwise XOR assignment operator.
  ///
  /// Performs a bitwise XOR operation on this APInt and RHS. The result is
  /// assigned to *this.
  ///
  /// \returns *this after XORing with RHS.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator^=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 423,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 422,
   FQN="llvm::APInt::operator^=", NM="_ZN4llvm5APInteOERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInteOERKS0_")
  //</editor-fold>
  public APInt /*&*/ $xorassign(final /*const*/ APInt /*&*/ RHS) {
    assert (BitWidth == RHS.BitWidth) : "Bit widths must be the same";
    if (isSingleWord()) {
      this.VAL ^= RHS.VAL;
      this.clearUnusedBits();
      return /*Deref*/this;
    }
    /*uint*/int numWords = getNumWords();
    for (/*uint*/int i = 0; $less_uint(i, numWords); ++i)  {
      this.pVal.$set$xorassign(i, RHS.pVal.$at(i));
    }
    return clearUnusedBits();
  }

  
  /// \brief Multiplication assignment operator.
  ///
  /// Multiplies this APInt by RHS and assigns the result to *this.
  ///
  /// \returns *this
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator*=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 357,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 356,
   FQN="llvm::APInt::operator*=", NM="_ZN4llvm5APIntmLERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntmLERKS0_")
  //</editor-fold>
  public APInt /*&*/ $starassign(final /*const*/ APInt /*&*/ RHS) {
    assert (BitWidth == RHS.BitWidth) : "Bit widths must be the same";
    if (isSingleWord()) {
      this.VAL *= RHS.VAL;
      clearUnusedBits();
      return /*Deref*/this;
    }
    
    // Get some bit facts about LHS and check for zero
    /*uint*/int lhsBits = getActiveBits();
    /*uint*/int lhsWords = !(lhsBits != 0) ? 0 : whichWord(lhsBits - 1) + 1;
    if (!(lhsWords != 0)) {
      // 0 * X ===> 0
      return /*Deref*/this;
    }
    
    // Get some bit facts about RHS and check for zero
    /*uint*/int rhsBits = RHS.getActiveBits();
    /*uint*/int rhsWords = !(rhsBits != 0) ? 0 : whichWord(rhsBits - 1) + 1;
    if (!(rhsWords != 0)) {
      // X * 0 ===> 0
      clearAllBits();
      return /*Deref*/this;
    }
    
    // Allocate space for the result
    /*uint*/int destWords = rhsWords + lhsWords;
    ulong$ptr/*uint64_t P*/ dest = $tryClone(getMemory(destWords));
    
    // Perform the long multiply
    mul(dest, this.pVal, lhsWords, RHS.pVal, rhsWords);
    
    // Copy result back into *this
    clearAllBits();
    /*uint*/int wordsToCopy = $greatereq_uint(destWords, getNumWords()) ? getNumWords() : destWords;
    memcpy(this.pVal, dest, wordsToCopy * APINT_WORD_SIZE);
    clearUnusedBits();
    
    // delete dest array and return
    /*delete[]*/Destructors.$destroyArray(dest);
    return /*Deref*/this;
  }

  
  /// \brief Addition assignment operator.
  ///
  /// Adds RHS to *this and assigns the result to *this.
  ///
  /// \returns *this
  
  /// Adds the RHS APint to this APInt.
  /// @returns this, after addition of RHS.
  /// @brief Addition assignment operator.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator+=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 253,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 252,
   FQN="llvm::APInt::operator+=", NM="_ZN4llvm5APIntpLERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntpLERKS0_")
  //</editor-fold>
  public APInt /*&*/ $addassign(final /*const*/ APInt /*&*/ RHS) {
    assert (BitWidth == RHS.BitWidth) : "Bit widths must be the same";
    if (isSingleWord()) {
      this.VAL += RHS.VAL;
    } else {
      add(this.pVal, this.pVal, RHS.pVal, getNumWords());
    }
    return clearUnusedBits();
  }

  
  /// \brief Subtraction assignment operator.
  ///
  /// Subtracts RHS from *this and assigns the result to *this.
  ///
  /// \returns *this
  
  /// Subtracts the RHS APInt from this APInt
  /// @returns this, after subtraction
  /// @brief Subtraction assignment operator.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator-=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 280,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 279,
   FQN="llvm::APInt::operator-=", NM="_ZN4llvm5APIntmIERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntmIERKS0_")
  //</editor-fold>
  public APInt /*&*/ $minusassign(final /*const*/ APInt /*&*/ RHS) {
    assert (BitWidth == RHS.BitWidth) : "Bit widths must be the same";
    if (isSingleWord()) {
      this.VAL -= RHS.VAL;
    } else {
      sub(this.pVal, this.pVal, RHS.pVal, getNumWords());
    }
    return clearUnusedBits();
  }

  
  /// \brief Left-shift assignment function.
  ///
  /// Shifts *this left by shiftAmt and assigns the result to *this.
  ///
  /// \returns *this after shifting left by shiftAmt
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator<<=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 766,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 761,
   FQN="llvm::APInt::operator<<=", NM="_ZN4llvm5APIntlSEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APIntlSEj")
  //</editor-fold>
  public APInt /*&*/ $lshiftassign(/*uint*/int shiftAmt) {
    /*Deref*/this.$assignMove(shl(shiftAmt));
    return /*Deref*/this;
  }

  
  /// @}
  /// \name Binary Operators
  /// @{
  
  /// \brief Bitwise AND operator.
  ///
  /// Performs a bitwise AND operation on *this and RHS.
  ///
  /// \returns An APInt value representing the bitwise AND of *this and RHS.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator&">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 780,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 775,
   FQN="llvm::APInt::operator&", NM="_ZNK4llvm5APIntanERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APIntanERKS0_")
  //</editor-fold>
  public APInt $bitand(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    assert (BitWidth == RHS.BitWidth) : "Bit widths must be the same";
    if (isSingleWord()) {
      return new APInt(getBitWidth(), this.VAL & RHS.VAL);
    }
    return AndSlowCase(RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::And">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 786,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 781,
   FQN="llvm::APInt::And", NM="_ZNK4llvm5APInt3AndERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt3AndERKS0_")
  //</editor-fold>
  public APInt And(final /*const*/ APInt /*&*/ RHS) /*const*//* __attribute__((warn_unused_result))*/ {
    return this.$bitand(RHS);
  }

  
  /// \brief Bitwise OR operator.
  ///
  /// Performs a bitwise OR operation on *this and RHS.
  ///
  /// \returns An APInt value representing the bitwise OR of *this and RHS.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator|">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 795,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 790,
   FQN="llvm::APInt::operator|", NM="_ZNK4llvm5APIntorERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APIntorERKS0_")
  //</editor-fold>
  public APInt $bitor(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    assert (BitWidth == RHS.BitWidth) : "Bit widths must be the same";
    if (isSingleWord()) {
      return new APInt(getBitWidth(), this.VAL | RHS.VAL);
    }
    return OrSlowCase(RHS);
  }

  
  /// \brief Bitwise OR function.
  ///
  /// Performs a bitwise or on *this and RHS. This is implemented by simply
  /// calling operator|.
  ///
  /// \returns An APInt value representing the bitwise OR of *this and RHS.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::Or">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 808,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 803,
   FQN="llvm::APInt::Or", NM="_ZNK4llvm5APInt2OrERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt2OrERKS0_")
  //</editor-fold>
  public APInt Or(final /*const*/ APInt /*&*/ RHS) /*const*//* __attribute__((warn_unused_result))*/ {
    return this.$bitor(RHS);
  }

  
  /// \brief Bitwise XOR operator.
  ///
  /// Performs a bitwise XOR operation on *this and RHS.
  ///
  /// \returns An APInt value representing the bitwise XOR of *this and RHS.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator^">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 817,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 812,
   FQN="llvm::APInt::operator^", NM="_ZNK4llvm5APInteoERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInteoERKS0_")
  //</editor-fold>
  public APInt $bitxor(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    assert (BitWidth == RHS.BitWidth) : "Bit widths must be the same";
    if (isSingleWord()) {
      return new APInt(BitWidth, this.VAL ^ RHS.VAL);
    }
    return XorSlowCase(RHS);
  }

  
  /// \brief Bitwise XOR function.
  ///
  /// Performs a bitwise XOR operation on *this and RHS. This is implemented
  /// through the usage of operator^.
  ///
  /// \returns An APInt value representing the bitwise XOR of *this and RHS.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::Xor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 830,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 825,
   FQN="llvm::APInt::Xor", NM="_ZNK4llvm5APInt3XorERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt3XorERKS0_")
  //</editor-fold>
  public APInt Xor(final /*const*/ APInt /*&*/ RHS) /*const*//* __attribute__((warn_unused_result))*/ {
    return this.$bitxor(RHS);
  }

  
  /// \brief Multiplication operator.
  ///
  /// Multiplies this APInt by RHS and returns the result.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 464,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 463,
   FQN="llvm::APInt::operator*", NM="_ZNK4llvm5APIntmlERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APIntmlERKS0_")
  //</editor-fold>
  public APInt $star(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    assert (BitWidth == RHS.BitWidth) : "Bit widths must be the same";
    if (isSingleWord()) {
      return new APInt(BitWidth, this.VAL * RHS.VAL);
    }
    APInt Result/*J*/= new APInt(/*Deref*/this);
    Result.$starassign(RHS);
    return Result;
  }

  
  /// \brief Addition operator.
  ///
  /// Adds RHS to this APInt and returns the result.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator+">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 473,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 472,
   FQN="llvm::APInt::operator+", NM="_ZNK4llvm5APIntplERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APIntplERKS0_")
  //</editor-fold>
  public APInt $add(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    assert (BitWidth == RHS.BitWidth) : "Bit widths must be the same";
    if (isSingleWord()) {
      return new APInt(BitWidth, this.VAL + RHS.VAL);
    }
    APInt Result/*J*/= new APInt(BitWidth, 0);
    add(Result.pVal, this.pVal, RHS.pVal, getNumWords());
    Result.clearUnusedBits();
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator+">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 483,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 838,
   FQN="llvm::APInt::operator+", NM="_ZNK4llvm5APIntplEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APIntplEy")
  //</editor-fold>
  public APInt $add(long/*uint64_t*/ RHS) /*const*/ {
    if (isSingleWord()) {
      return new APInt(BitWidth, this.VAL + RHS);
    }
    APInt Result/*J*/= new APInt(/*Deref*/this);
    add_1(Result.pVal, Result.pVal, getNumWords(), RHS);
    Result.clearUnusedBits();
    return Result;
  }

  
  /// \brief Subtraction operator.
  ///
  /// Subtracts RHS from this APInt and returns the result.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator-">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 492,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 482,
   FQN="llvm::APInt::operator-", NM="_ZNK4llvm5APIntmiERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APIntmiERKS0_")
  //</editor-fold>
  public APInt $sub(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    assert (BitWidth == RHS.BitWidth) : "Bit widths must be the same";
    if (isSingleWord()) {
      return new APInt(BitWidth, this.VAL - RHS.VAL);
    }
    APInt Result/*J*/= new APInt(BitWidth, 0);
    sub(Result.pVal, this.pVal, RHS.pVal, getNumWords());
    Result.clearUnusedBits();
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator-">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 502,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 844,
   FQN="llvm::APInt::operator-", NM="_ZNK4llvm5APIntmiEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APIntmiEy")
  //</editor-fold>
  public APInt $sub(long/*uint64_t*/ RHS) /*const*/ {
    if (isSingleWord()) {
      return new APInt(BitWidth, this.VAL - RHS);
    }
    APInt Result/*J*/= new APInt(/*Deref*/this);
    sub_1(Result.pVal, getNumWords(), RHS);
    Result.clearUnusedBits();
    return Result;
  }

  
  /// \brief Left logical shift operator.
  ///
  /// Shifts this APInt left by \p Bits and returns the result.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 854,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 849,
   FQN="llvm::APInt::operator<<", NM="_ZNK4llvm5APIntlsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APIntlsEj")
  //</editor-fold>
  public APInt $out(/*uint*/int Bits) /*const*/ {
    return shl(Bits);
  }

  
  /// \brief Left logical shift operator.
  ///
  /// Shifts this APInt left by \p Bits and returns the result.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 859,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 854,
   FQN="llvm::APInt::operator<<", NM="_ZNK4llvm5APIntlsERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APIntlsERKS0_")
  //</editor-fold>
  public APInt $out(final /*const*/ APInt /*&*/ Bits) /*const*/ {
    return shl(Bits);
  }

  
  /// \brief Arithmetic right-shift function.
  ///
  /// Arithmetic right-shift this APInt by shiftAmt.
  
  /// Arithmetic right-shift this APInt by shiftAmt.
  /// @brief Arithmetic right-shift function.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::ashr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1057,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1051,
   FQN="llvm::APInt::ashr", NM="_ZNK4llvm5APInt4ashrEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt4ashrEj")
  //</editor-fold>
  public APInt ashr(/*uint*/int shiftAmt) /*const*//* __attribute__((warn_unused_result))*/ {
    assert ($lesseq_uint(shiftAmt, BitWidth)) : "Invalid shift amount";
    // Handle a degenerate case
    if (shiftAmt == 0) {
      return /*Deref*/this;
    }

    // Handle single word shifts with built-in ashr
    if (isSingleWord()) {
      if (shiftAmt == BitWidth) {
        return new APInt(JD$UInt_ULong.INSTANCE, BitWidth, 0); // undefined
      } else {
        /*uint*/int SignBit = APINT_BITS_PER_WORD - BitWidth;
        return new APInt(JD$UInt_ULong.INSTANCE, BitWidth, 
            (((((long/*int64_t*/)(this.VAL)) << SignBit) >>> SignBit) >>> shiftAmt));
      }
    }

    // If all the bits were shifted out, the result is, technically, undefined.
    // We return -1 if it was negative, 0 otherwise. We check this early to avoid
    // issues in the algorithm below.
    if (shiftAmt == BitWidth) {
      if (isNegative()) {
        return new APInt(JD$UInt_ULong.INSTANCE, BitWidth, -1L/*ULL*/, true);
      } else {
        return new APInt(JD$UInt_ULong.INSTANCE, BitWidth, 0);
      }
    }

    // Create some space for the result.
    ulong$ptr/*uint64_t P*/ val = create_ulong$ptr(/*uint64_t*/new$ulong(getNumWords()));

    // Compute some values needed by the following shift algorithms
    /*uint*/int wordShift = $rem_uint_int(shiftAmt, APINT_BITS_PER_WORD); // bits to shift per word
    /*uint*/int offset = $div_uint_int(shiftAmt, APINT_BITS_PER_WORD); // word offset for shift
    /*uint*/int breakWord = getNumWords() - 1 - offset; // last word affected
    /*uint*/int bitsInWord = whichBit(BitWidth); // how many bits in last word?
    if (bitsInWord == 0) {
      bitsInWord = APINT_BITS_PER_WORD;
    }

    // If we are shifting whole words, just move whole words
    if (wordShift == 0) {
      // Move the words containing significant bits
      for (/*uint*/int i = 0; $lesseq_uint(i, breakWord); ++i)  {
        val.$set(i, this.pVal.$at(i + offset)); // move whole word
      }

      // Adjust the top significant word for sign bit fill, if negative
      if (isNegative()) {
        if ($less_uint_int(bitsInWord, APINT_BITS_PER_WORD)) {
          val.$set$orassign(breakWord, ~0L/*ULL*/ << bitsInWord); // set high bits
        }
      }
    } else {
      // Shift the low order words
      for (/*uint*/int i = 0; $less_uint(i, breakWord); ++i) {
        // This combines the shifted corresponding word with the low bits from
        // the next word (shifted into this word's high bits).
        val.$set(i, (this.pVal.$at(i + offset) >>> wordShift) 
           | (this.pVal.$at(i + offset + 1) << (APINT_BITS_PER_WORD - wordShift)));
      }

      // Shift the break word. In this case there are no bits from the next word
      // to include in this word.
      val.$set(breakWord, this.pVal.$at(breakWord + offset) >>> wordShift);

      // Deal with sign extension in the break word, and possibly the word before
      // it.
      if (isNegative()) {
        if ($greater_uint(wordShift, bitsInWord)) {
          if ($greater_uint(breakWord, 0)) {
            val.$set$orassign(breakWord - 1, ~0L/*ULL*/ << (APINT_BITS_PER_WORD - (wordShift - bitsInWord)));
          }
          val.$set$orassign(breakWord, ~0L/*ULL*/);
        } else {
          val.$set$orassign(breakWord, (~0L/*ULL*/ << (bitsInWord - wordShift)));
        }
      }
    }

    // Remaining words are 0 or -1, just assign them.
    long/*uint64_t*/ fillValue = (isNegative() ? -1L/*ULL*/ : 0);
    for (/*uint*/int i = breakWord + 1; $less_uint(i, getNumWords()); ++i)  {
      val.$set(i, fillValue);
    }
    APInt Result/*J*/= new APInt(val, BitWidth);
    Result.clearUnusedBits();
    return Result;
  }

  
  /// \brief Logical right-shift function.
  ///
  /// Logical right-shift this APInt by shiftAmt.

  /// Logical right-shift this APInt by shiftAmt.
  /// @brief Logical right-shift function.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::lshr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1148,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1142,
   FQN="llvm::APInt::lshr", NM="_ZNK4llvm5APInt4lshrEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt4lshrEj")
  //</editor-fold>
  public APInt lshr(/*uint*/int shiftAmt) /*const*//* __attribute__((warn_unused_result))*/ {
    if (isSingleWord()) {
      if ($greatereq_uint(shiftAmt, BitWidth)) {
        return new APInt(BitWidth, 0);
      } else {
        return new APInt(BitWidth, this.VAL >>> shiftAmt);
      }
    }

    // If all the bits were shifted out, the result is 0. This avoids issues
    // with shifting by the size of the integer type, which produces undefined
    // results. We define these "undefined results" to always be 0.
    if ($greatereq_uint(shiftAmt, BitWidth)) {
      return new APInt(BitWidth, 0);
    }

    // If none of the bits are shifted out, the result is *this. This avoids
    // issues with shifting by the size of the integer type, which produces
    // undefined results in the code below. This is also an optimization.
    if (shiftAmt == 0) {
      return new APInt(/*Deref*/this);
    }

    // Create some space for the result.
    ulong$ptr/*uint64_t P*/ val = create_ulong$ptr(new$ulong/*uint64_t*/ (getNumWords()));

    // If we are shifting less than a word, compute the shift with a simple carry
    if ($less_uint_int(shiftAmt, APINT_BITS_PER_WORD)) {
      lshrNear(val, this.pVal, getNumWords(), shiftAmt);
      APInt Result/*J*/= new APInt(val, BitWidth);
      Result.clearUnusedBits();
      return Result;
    }

    // Compute some values needed by the remaining shift algorithms
    /*uint*/int wordShift = $rem_uint_int(shiftAmt, APINT_BITS_PER_WORD);
    /*uint*/int offset = $div_uint_int(shiftAmt, APINT_BITS_PER_WORD);

    // If we are shifting whole words, just move whole words
    if (wordShift == 0) {
      for (/*uint*/int i = 0; $less_uint(i, getNumWords() - offset); ++i)  {
        val.$set(i, this.pVal.$at(i + offset));
      }
      for (/*uint*/int i = getNumWords() - offset; $less_uint(i, getNumWords()); i++)  {
        val.$set(i, 0);
      }
      APInt Result/*J*/= new APInt(val, BitWidth);
      Result.clearUnusedBits();
      return Result;
    }

    // Shift the low order words
    /*uint*/int breakWord = getNumWords() - offset - 1;
    for (/*uint*/int i = 0; $less_uint(i, breakWord); ++i)  {
      val.$set(i, (this.pVal.$at(i + offset) >>> wordShift)
         | (this.pVal.$at(i + offset + 1) << (APINT_BITS_PER_WORD - wordShift)));
    }
    // Shift the break word.
    val.$set(breakWord, this.pVal.$at(breakWord + offset) >>> wordShift);

    // Remaining words are 0
    for (/*uint*/int i = breakWord + 1; $less_uint(i, getNumWords()); ++i)  {
      val.$set(i, 0);
    }
    APInt Result/*J*/= new APInt(val, BitWidth);
    Result.clearUnusedBits();
    return Result;
  }

  
  /// \brief Left-shift function.
  ///
  /// Left-shift this APInt by shiftAmt.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::shl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 874,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 869,
   FQN="llvm::APInt::shl", NM="_ZNK4llvm5APInt3shlEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt3shlEj")
  //</editor-fold>
  public APInt shl(/*uint*/int shiftAmt) /*const*//* __attribute__((warn_unused_result))*/ {
    assert ($lesseq_uint(shiftAmt, BitWidth)) : "Invalid shift amount";
    if (isSingleWord()) {
      if ($greatereq_uint(shiftAmt, BitWidth)) {
        return new APInt(BitWidth, 0); // avoid undefined shift results
      }
      return new APInt(BitWidth, this.VAL << shiftAmt);
    }
    return shlSlowCase(shiftAmt);
  }

  
  /// \brief Rotate left by rotateAmt.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::rotl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1277,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1271,
   FQN="llvm::APInt::rotl", NM="_ZNK4llvm5APInt4rotlEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt4rotlEj")
  //</editor-fold>
  public APInt rotl(/*uint*/int rotateAmt) /*const*//* __attribute__((warn_unused_result))*/ {
    rotateAmt = $rem_uint(rotateAmt, BitWidth);
    if (rotateAmt == 0) {
      return new APInt(/*Deref*/this);
    }
    return shl(rotateAmt).$bitor(lshr(BitWidth - rotateAmt));
  }

  
  /// \brief Rotate right by rotateAmt.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::rotr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1288,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1282,
   FQN="llvm::APInt::rotr", NM="_ZNK4llvm5APInt4rotrEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt4rotrEj")
  //</editor-fold>
  public APInt rotr(/*uint*/int rotateAmt) /*const*//* __attribute__((warn_unused_result))*/ {
    rotateAmt = $rem_uint(rotateAmt, BitWidth);
    if (rotateAmt == 0) {
      return new APInt(/*Deref*/this);
    }
    return lshr(rotateAmt).$bitor(shl(BitWidth - rotateAmt));
  }

  
  /// \brief Arithmetic right-shift function.
  ///
  /// Arithmetic right-shift this APInt by shiftAmt.
  
  /// Arithmetic right-shift this APInt by shiftAmt.
  /// @brief Arithmetic right-shift function.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::ashr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1051,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1045,
   FQN="llvm::APInt::ashr", NM="_ZNK4llvm5APInt4ashrERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt4ashrERKS0_")
  //</editor-fold>
  public APInt ashr(final /*const*/ APInt /*&*/ shiftAmt) /*const*//* __attribute__((warn_unused_result))*/ {
    return ashr((/*uint*/int)shiftAmt.getLimitedValue($uint2ulong(BitWidth)));
  }

  
  /// \brief Logical right-shift function.
  ///
  /// Logical right-shift this APInt by shiftAmt.
  
  /// Logical right-shift this APInt by shiftAmt.
  /// @brief Logical right-shift function.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::lshr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1142,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1136,
   FQN="llvm::APInt::lshr", NM="_ZNK4llvm5APInt4lshrERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt4lshrERKS0_")
  //</editor-fold>
  public APInt lshr(final /*const*/ APInt /*&*/ shiftAmt) /*const*//* __attribute__((warn_unused_result))*/ {
    return lshr((/*uint*/int)shiftAmt.getLimitedValue($uint2ulong(BitWidth)));
  }

  
  /// \brief Left-shift function.
  ///
  /// Left-shift this APInt by shiftAmt.
  
  /// Left-shift this APInt by shiftAmt.
  /// @brief Left-shift function.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::shl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1212,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1206,
   FQN="llvm::APInt::shl", NM="_ZNK4llvm5APInt3shlERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt3shlERKS0_")
  //</editor-fold>
  public APInt shl(final /*const*/ APInt /*&*/ shiftAmt) /*const*//* __attribute__((warn_unused_result))*/ {
    // It's undefined behavior in C to shift by BitWidth or greater.
    return shl((/*uint*/int)shiftAmt.getLimitedValue($uint2ulong(BitWidth)));
  }

  
  /// \brief Rotate left by rotateAmt.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::rotl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1273,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1267,
   FQN="llvm::APInt::rotl", NM="_ZNK4llvm5APInt4rotlERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt4rotlERKS0_")
  //</editor-fold>
  public APInt rotl(final /*const*/ APInt /*&*/ rotateAmt) /*const*//* __attribute__((warn_unused_result))*/ {
    return rotl((/*uint*/int)rotateAmt.getLimitedValue($uint2ulong(BitWidth)));
  }

  
  /// \brief Rotate right by rotateAmt.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::rotr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1284,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1278,
   FQN="llvm::APInt::rotr", NM="_ZNK4llvm5APInt4rotrERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt4rotrERKS0_")
  //</editor-fold>
  public APInt rotr(final /*const*/ APInt /*&*/ rotateAmt) /*const*//* __attribute__((warn_unused_result))*/ {
    return rotr((/*uint*/int)rotateAmt.getLimitedValue($uint2ulong(BitWidth)));
  }

  
  /// \brief Unsigned division operation.
  ///
  /// Perform an unsigned divide operation on this APInt by RHS. Both this and
  /// RHS are treated as unsigned quantities for purposes of this division.
  ///
  /// \returns a new APInt value containing the division result
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::udiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1843,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1839,
   FQN="llvm::APInt::udiv", NM="_ZNK4llvm5APInt4udivERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt4udivERKS0_")
  //</editor-fold>
  public APInt udiv(final /*const*/ APInt /*&*/ RHS) /*const*//* __attribute__((warn_unused_result))*/ {
    assert (BitWidth == RHS.BitWidth) : "Bit widths must be the same";

    // First, deal with the easy case
    if (isSingleWord()) {
      assert (RHS.VAL != 0) : "Divide by zero?";
      return new APInt(BitWidth, $div_ulong(this.VAL, RHS.VAL));
    }

    // Get some facts about the LHS and RHS number of bits and words
    /*uint*/int rhsBits = RHS.getActiveBits();
    /*uint*/int rhsWords = !(rhsBits != 0) ? 0 : (APInt.whichWord(rhsBits - 1) + 1);
    assert ((rhsWords != 0)) : "Divided by zero???";
    /*uint*/int lhsBits = this.getActiveBits();
    /*uint*/int lhsWords = !(lhsBits != 0) ? 0 : (APInt.whichWord(lhsBits - 1) + 1);

    // Deal with some degenerate cases
    if (!(lhsWords != 0)) {
      // 0 / X ===> 0
      return new APInt(BitWidth, 0);
    } else if ($less_uint(lhsWords, rhsWords) || this.ult(RHS)) {
      // X / Y ===> 0, iff X < Y
      return new APInt(BitWidth, 0);
    } else if (/*Deref*/this.$eq(RHS)) {
      // X / X ===> 1
      return new APInt(BitWidth, 1);
    } else if (lhsWords == 1 && rhsWords == 1) {
      // All high words are zero, just use native divide
      return new APInt(BitWidth, $div_ulong(this.pVal.$at(0), RHS.pVal.$at(0)));
    }

    // We have to compute it the hard way. Invoke the Knuth divide algorithm.
    APInt Quotient/*J*/= new APInt(1, 0); // to hold result.
    divide(/*Deref*/this, lhsWords, RHS, rhsWords, $AddrOf(Quotient), (APInt /*P*/ )null);
    return Quotient;
  }

  
  /// \brief Signed division function for APInt.
  ///
  /// Signed divide this APInt by APInt RHS.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::sdiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1880,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1876,
   FQN="llvm::APInt::sdiv", NM="_ZNK4llvm5APInt4sdivERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt4sdivERKS0_")
  //</editor-fold>
  public APInt sdiv(final /*const*/ APInt /*&*/ RHS) /*const*//* __attribute__((warn_unused_result))*/ {
    if (isNegative()) {
      if (RHS.isNegative()) {
        return ((/*Deref*/this).$sub()).udiv(RHS.$sub());
      }
      return (((/*Deref*/this).$sub()).udiv(RHS)).$sub();
    }
    if (RHS.isNegative()) {
      return (this.udiv(RHS.$sub())).$sub();
    }
    return this.udiv(RHS);
  }

  
  /// \brief Unsigned remainder operation.
  ///
  /// Perform an unsigned remainder operation on this APInt with RHS being the
  /// divisor. Both this and RHS are treated as unsigned quantities for purposes
  /// of this operation. Note that this is a true remainder operation and not a
  /// modulo operation because the sign follows the sign of the dividend which
  /// is *this.
  ///
  /// \returns a new APInt value containing the remainder result
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::urem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1891,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1887,
   FQN="llvm::APInt::urem", NM="_ZNK4llvm5APInt4uremERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt4uremERKS0_")
  //</editor-fold>
  public APInt urem(final /*const*/ APInt /*&*/ RHS) /*const*//* __attribute__((warn_unused_result))*/ {
    assert (BitWidth == RHS.BitWidth) : "Bit widths must be the same";
    if (isSingleWord()) {
      assert (RHS.VAL != 0) : "Remainder by zero?";
      return new APInt(BitWidth, $rem_ulong(this.VAL, RHS.VAL));
    }

    // Get some facts about the LHS
    /*uint*/int lhsBits = getActiveBits();
    /*uint*/int lhsWords = !(lhsBits != 0) ? 0 : (whichWord(lhsBits - 1) + 1);

    // Get some facts about the RHS
    /*uint*/int rhsBits = RHS.getActiveBits();
    /*uint*/int rhsWords = !(rhsBits != 0) ? 0 : (APInt.whichWord(rhsBits - 1) + 1);
    assert ((rhsWords != 0)) : "Performing remainder operation by zero ???";

    // Check the degenerate cases
    if (lhsWords == 0) {
      // 0 % Y ===> 0
      return new APInt(BitWidth, 0);
    } else if ($less_uint(lhsWords, rhsWords) || this.ult(RHS)) {
      // X % Y ===> X, iff X < Y
      return new APInt(/*Deref*/this);
    } else if (/*Deref*/this.$eq(RHS)) {
      // X % X == 0;
      return new APInt(BitWidth, 0);
    } else if (lhsWords == 1) {
      // All high words are zero, just use native remainder
      return new APInt(BitWidth, $rem_ulong(this.pVal.$at(0), RHS.pVal.$at(0)));
    }

    // We have to compute it the hard way. Invoke the Knuth divide algorithm.
    APInt Remainder/*J*/= new APInt(1, 0);
    divide(/*Deref*/this, lhsWords, RHS, rhsWords, (APInt /*P*/ )null, $AddrOf(Remainder));
    return Remainder;
  }

  
  /// \brief Function for signed remainder operation.
  ///
  /// Signed remainder operation on APInt.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::srem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1928,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1924,
   FQN="llvm::APInt::srem", NM="_ZNK4llvm5APInt4sremERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt4sremERKS0_")
  //</editor-fold>
  public APInt srem(final /*const*/ APInt /*&*/ RHS) /*const*//* __attribute__((warn_unused_result))*/ {
    if (isNegative()) {
      if (RHS.isNegative()) {
        return (((/*Deref*/this).$sub()).urem(RHS.$sub())).$sub();
      }
      return (((/*Deref*/this).$sub()).urem(RHS)).$sub();
    }
    if (RHS.isNegative()) {
      return this.urem(RHS.$sub());
    }
    return this.urem(RHS);
  }

  
  /// \brief Dual division/remainder interface.
  ///
  /// Sometimes it is convenient to divide two APInt values and obtain both the
  /// quotient and remainder. This function does both operations in the same
  /// computation making it a little more efficient. The pair of input arguments
  /// may overlap with the pair of output arguments. It is safe to call
  /// udivrem(X, Y, X, Y), for example.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::udivrem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1939,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1935,
   FQN="llvm::APInt::udivrem", NM="_ZN4llvm5APInt7udivremERKS0_S2_RS0_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt7udivremERKS0_S2_RS0_S3_")
  //</editor-fold>
  public static void udivrem(final /*const*/ APInt /*&*/ LHS, final /*const*/ APInt /*&*/ RHS, 
         final APInt /*&*/ Quotient, final APInt /*&*/ Remainder) {
    assert (LHS.BitWidth == RHS.BitWidth) : "Bit widths must be the same";

    // First, deal with the easy case
    if (LHS.isSingleWord()) {
      assert (RHS.VAL != 0) : "Divide by zero?";
      long/*uint64_t*/ QuotVal = $div_ulong(LHS.VAL, RHS.VAL);
      long/*uint64_t*/ RemVal = $rem_ulong(LHS.VAL, RHS.VAL);
      Quotient.$assignMove(new APInt(LHS.BitWidth, QuotVal));
      Remainder.$assignMove(new APInt(LHS.BitWidth, RemVal));
      return;
    }

    // Get some size facts about the dividend and divisor
    /*uint*/int lhsBits = LHS.getActiveBits();
    /*uint*/int lhsWords = !(lhsBits != 0) ? 0 : (APInt.whichWord(lhsBits - 1) + 1);
    /*uint*/int rhsBits = RHS.getActiveBits();
    /*uint*/int rhsWords = !(rhsBits != 0) ? 0 : (APInt.whichWord(rhsBits - 1) + 1);

    // Check the degenerate cases
    if (lhsWords == 0) {
      Quotient.$assign(0); // 0 / Y ===> 0
      Remainder.$assign(0); // 0 % Y ===> 0
      return;
    }
    if ($less_uint(lhsWords, rhsWords) || LHS.ult(RHS)) {
      Remainder.$assign(LHS); // X % Y ===> X, iff X < Y
      Quotient.$assign(0); // X / Y ===> 0, iff X < Y
      return;
    }
    if (LHS.$eq(RHS)) {
      Quotient.$assign(1); // X / X ===> 1
      Remainder.$assign(0); // X % X ===> 0;
      return;
    }
    if (lhsWords == 1 && rhsWords == 1) {
      // There is only one word to consider so use the native versions.
      long/*uint64_t*/ lhsValue = LHS.isSingleWord() ? LHS.VAL : LHS.pVal.$at(0);
      long/*uint64_t*/ rhsValue = RHS.isSingleWord() ? RHS.VAL : RHS.pVal.$at(0);
      Quotient.$assignMove(new APInt(LHS.getBitWidth(), $div_ulong(lhsValue, rhsValue)));
      Remainder.$assignMove(new APInt(LHS.getBitWidth(), $rem_ulong(lhsValue, rhsValue)));
      return;
    }

    // Okay, lets do it the long way
    divide(LHS, lhsWords, RHS, rhsWords, $AddrOf(Quotient), $AddrOf(Remainder));
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::sdivrem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1991,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1987,
   FQN="llvm::APInt::sdivrem", NM="_ZN4llvm5APInt7sdivremERKS0_S2_RS0_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt7sdivremERKS0_S2_RS0_S3_")
  //</editor-fold>
  public static void sdivrem(final /*const*/ APInt /*&*/ LHS, final /*const*/ APInt /*&*/ RHS, 
         final APInt /*&*/ Quotient, final APInt /*&*/ Remainder) {
    if (LHS.isNegative()) {
      if (RHS.isNegative()) {
        APInt.udivrem(LHS.$sub(), RHS.$sub(), Quotient, Remainder);
      } else {
        APInt.udivrem(LHS.$sub(), RHS, Quotient, Remainder);
        Quotient.$assignMove(Quotient.$sub());
      }
      Remainder.$assignMove(Remainder.$sub());
    } else if (RHS.isNegative()) {
      APInt.udivrem(LHS, RHS.$sub(), Quotient, Remainder);
      Quotient.$assignMove(Quotient.$sub());
    } else {
      APInt.udivrem(LHS, RHS, Quotient, Remainder);
    }
  }

  
  // Operations that return overflow indicators.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::sadd_ov">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2009,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2005,
   FQN="llvm::APInt::sadd_ov", NM="_ZNK4llvm5APInt7sadd_ovERKS0_Rb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt7sadd_ovERKS0_Rb")
  //</editor-fold>
  public APInt sadd_ov(final /*const*/ APInt /*&*/ RHS, final bool$ref/*bool &*/ Overflow) /*const*/ {
    APInt Res = $Deref(this.$add(RHS));
    Overflow.$set(isNonNegative() == RHS.isNonNegative() 
       && Res.isNonNegative() != isNonNegative());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::uadd_ov">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2016,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2012,
   FQN="llvm::APInt::uadd_ov", NM="_ZNK4llvm5APInt7uadd_ovERKS0_Rb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt7uadd_ovERKS0_Rb")
  //</editor-fold>
  public APInt uadd_ov(final /*const*/ APInt /*&*/ RHS, final bool$ref/*bool &*/ Overflow) /*const*/ {
    APInt Res = $Deref(this.$add(RHS));
    Overflow.$set(Res.ult(RHS));
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::ssub_ov">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2022,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2018,
   FQN="llvm::APInt::ssub_ov", NM="_ZNK4llvm5APInt7ssub_ovERKS0_Rb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt7ssub_ovERKS0_Rb")
  //</editor-fold>
  public APInt ssub_ov(final /*const*/ APInt /*&*/ RHS, final bool$ref/*bool &*/ Overflow) /*const*/ {
    APInt Res = $Deref(this.$sub(RHS));
    Overflow.$set(isNonNegative() != RHS.isNonNegative() 
       && Res.isNonNegative() != isNonNegative());
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::usub_ov">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2029,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2025,
   FQN="llvm::APInt::usub_ov", NM="_ZNK4llvm5APInt7usub_ovERKS0_Rb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt7usub_ovERKS0_Rb")
  //</editor-fold>
  public APInt usub_ov(final /*const*/ APInt /*&*/ RHS, final bool$ref/*bool &*/ Overflow) /*const*/ {
    APInt Res = $Deref(this.$sub(RHS));
    Overflow.$set(Res.ugt(/*Deref*/this));
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::sdiv_ov">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2035,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2031,
   FQN="llvm::APInt::sdiv_ov", NM="_ZNK4llvm5APInt7sdiv_ovERKS0_Rb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt7sdiv_ovERKS0_Rb")
  //</editor-fold>
  public APInt sdiv_ov(final /*const*/ APInt /*&*/ RHS, final bool$ref/*bool &*/ Overflow) /*const*/ {
    // MININT/-1  -->  overflow.
    Overflow.$set(isMinSignedValue() && RHS.isAllOnesValue());
    return sdiv(RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::smul_ov">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2041,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2037,
   FQN="llvm::APInt::smul_ov", NM="_ZNK4llvm5APInt7smul_ovERKS0_Rb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt7smul_ovERKS0_Rb")
  //</editor-fold>
  public APInt smul_ov(final /*const*/ APInt /*&*/ RHS, final bool$ref/*bool &*/ Overflow) /*const*/ {
    APInt Res = $Deref(this.$star(RHS));
    if (/*Deref*/this.$noteq(0) && RHS.$noteq(0)) {
      Overflow.$set(Res.sdiv(RHS).$noteq(/*Deref*/this) || Res.sdiv(/*Deref*/this).$noteq(RHS));
    } else {
      Overflow.$set(false);
    }
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::umul_ov">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2051,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2047,
   FQN="llvm::APInt::umul_ov", NM="_ZNK4llvm5APInt7umul_ovERKS0_Rb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt7umul_ovERKS0_Rb")
  //</editor-fold>
  public APInt umul_ov(final /*const*/ APInt /*&*/ RHS, final bool$ref/*bool &*/ Overflow) /*const*/ {
    APInt Res = $Deref(this.$star(RHS));
    if (/*Deref*/this.$noteq(0) && RHS.$noteq(0)) {
      Overflow.$set(Res.udiv(RHS).$noteq(/*Deref*/this) || Res.udiv(/*Deref*/this).$noteq(RHS));
    } else {
      Overflow.$set(false);
    }
    return Res;
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::sshl_ov">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2061,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2057,
   FQN="llvm::APInt::sshl_ov", NM="_ZNK4llvm5APInt7sshl_ovERKS0_Rb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt7sshl_ovERKS0_Rb")
    //</editor-fold>
  public APInt sshl_ov(final /*const*/ APInt /*&*/ ShAmt, final bool$ref/*bool &*/ Overflow) /*const*/ {
    Overflow.$set(ShAmt.uge($uint2ulong(getBitWidth())));
    if (Overflow.$deref()) {
      return new APInt(BitWidth, 0);
    }
    if (isNonNegative()) { // Don't allow sign change.
      Overflow.$set(ShAmt.uge($uint2ulong(countLeadingZeros())));
    } else {
      Overflow.$set(ShAmt.uge($uint2ulong(countLeadingOnes())));
    }

    return $Deref(this.$out(ShAmt));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::ushl_ov">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2074,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2070,
   FQN="llvm::APInt::ushl_ov", NM="_ZNK4llvm5APInt7ushl_ovERKS0_Rb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt7ushl_ovERKS0_Rb")
  //</editor-fold>
  public APInt ushl_ov(final /*const*/ APInt /*&*/ ShAmt, final bool$ref/*bool &*/ Overflow) /*const*/ {
    Overflow.$set(ShAmt.uge($uint2ulong(getBitWidth())));
    if (Overflow.$deref()) {
      return new APInt(BitWidth, 0);
    }

    Overflow.$set(ShAmt.ugt($uint2ulong(countLeadingZeros())));

    return $Deref(this.$out(ShAmt));
  }

  
  /// \brief Array-indexing support.
  ///
  /// \returns the bit value at bitPosition
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 967,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 962,
   FQN="llvm::APInt::operator[]", NM="_ZNK4llvm5APIntixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APIntixEj")
  //</editor-fold>
  public boolean $at(/*uint*/int bitPosition) /*const*/ {
    assert ($less_uint(bitPosition, getBitWidth())) : "Bit position out of bounds!";
    return (maskBit(bitPosition) 
       & (isSingleWord() ? this.VAL : this.pVal.$at(whichWord(bitPosition)))) 
       != 0;
  }

  
  /// @}
  /// \name Comparison Operators
  /// @{
  
  /// \brief Equality operator.
  ///
  /// Compares this APInt with RHS for the validity of the equality
  /// relationship.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 982,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 977,
   FQN="llvm::APInt::operator==", NM="_ZNK4llvm5APInteqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInteqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    assert (BitWidth == RHS.BitWidth) : "Comparison requires equal bit widths";
    if (isSingleWord()) {
      return this.VAL == RHS.VAL;
    }
    return EqualSlowCase(RHS);
  }

  
  /// \brief Equality operator.
  ///
  /// Compares this APInt with a uint64_t for the validity of the equality
  /// relationship.
  ///
  /// \returns true if *this == Val
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 995,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 990,
   FQN="llvm::APInt::operator==", NM="_ZNK4llvm5APInteqEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInteqEy")
  //</editor-fold>
  public boolean $eq(long/*uint64_t*/ Val) /*const*/ {
    if (isSingleWord()) {
      return this.VAL == Val;
    }
    return EqualSlowCase(Val);
  }

  
  /// \brief Equality comparison.
  ///
  /// Compares this APInt with RHS for the validity of the equality
  /// relationship.
  ///
  /// \returns true if *this == Val
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::eq">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1007,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1002,
   FQN="llvm::APInt::eq", NM="_ZNK4llvm5APInt2eqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt2eqERKS0_")
  //</editor-fold>
  public boolean eq(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    return (/*Deref*/this).$eq(RHS);
  }

  
  /// \brief Inequality operator.
  ///
  /// Compares this APInt with RHS for the validity of the inequality
  /// relationship.
  ///
  /// \returns true if *this != Val
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1015,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1010,
   FQN="llvm::APInt::operator!=", NM="_ZNK4llvm5APIntneERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APIntneERKS0_")
  //</editor-fold>
  public boolean $noteq(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    return !((/*Deref*/this).$eq(RHS));
  }

  
  /// \brief Inequality operator.
  ///
  /// Compares this APInt with a uint64_t for the validity of the inequality
  /// relationship.
  ///
  /// \returns true if *this != Val
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1023,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1018,
   FQN="llvm::APInt::operator!=", NM="_ZNK4llvm5APIntneEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APIntneEy")
  //</editor-fold>
  public boolean $noteq(long/*uint64_t*/ Val) /*const*/ {
    return !((/*Deref*/this).$eq(Val));
  }

  
  /// \brief Inequality comparison
  ///
  /// Compares this APInt with RHS for the validity of the inequality
  /// relationship.
  ///
  /// \returns true if *this != Val
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::ne">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1031,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1026,
   FQN="llvm::APInt::ne", NM="_ZNK4llvm5APInt2neERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt2neERKS0_")
  //</editor-fold>
  public boolean ne(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    return !((/*Deref*/this).$eq(RHS));
  }

  
  /// \brief Unsigned less than comparison
  ///
  /// Regards both *this and RHS as unsigned quantities and compares them for
  /// the validity of the less-than relationship.
  ///
  /// \returns true if *this < RHS when both are considered unsigned.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::ult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 523,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 520,
   FQN="llvm::APInt::ult", NM="_ZNK4llvm5APInt3ultERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt3ultERKS0_")
  //</editor-fold>
  public boolean ult(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    assert (BitWidth == RHS.BitWidth) : "Bit widths must be same for comparison";
    if (isSingleWord()) {
      return $less_ulong(this.VAL, RHS.VAL);
    }
    
    // Get active bit length of both operands
    /*uint*/int n1 = getActiveBits();
    /*uint*/int n2 = RHS.getActiveBits();
    
    // If magnitude of LHS is less than RHS, return true.
    if ($less_uint(n1, n2)) {
      return true;
    }
    
    // If magnitude of RHS is greather than LHS, return false.
    if ($less_uint(n2, n1)) {
      return false;
    }
    
    // If they bot fit in a word, just compare the low order word
    if ($lesseq_uint_int(n1, APINT_BITS_PER_WORD) && $lesseq_uint_int(n2, APINT_BITS_PER_WORD)) {
      return $less_ulong(this.pVal.$at(0), RHS.pVal.$at(0));
    }
    
    // Otherwise, compare all words
    /*uint*/int topWord = whichWord(std.max(n1, n2) - 1);
    for (int i = topWord; i >= 0; --i) {
      if ($greater_ulong(this.pVal.$at(i), RHS.pVal.$at(i))) {
        return false;
      }
      if ($less_ulong(this.pVal.$at(i), RHS.pVal.$at(i))) {
        return true;
      }
    }
    return false;
  }

  
  /// \brief Unsigned less than comparison
  ///
  /// Regards both *this as an unsigned quantity and compares it with RHS for
  /// the validity of the less-than relationship.
  ///
  /// \returns true if *this < RHS when considered unsigned.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::ult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1047,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1042,
   FQN="llvm::APInt::ult", NM="_ZNK4llvm5APInt3ultEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt3ultEy")
  //</editor-fold>
  public boolean ult(long/*uint64_t*/ RHS) /*const*/ {
    return $greater_uint(getActiveBits(), 64) ? false : $less_ulong(getZExtValue(), RHS);
  }

  
  /// \brief Signed less than comparison
  ///
  /// Regards both *this and RHS as signed quantities and compares them for
  /// validity of the less-than relationship.
  ///
  /// \returns true if *this < RHS when both are considered signed.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::slt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 555,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 552,
   FQN="llvm::APInt::slt", NM="_ZNK4llvm5APInt3sltERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt3sltERKS0_")
  //</editor-fold>
  public boolean slt(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    assert (BitWidth == RHS.BitWidth) : "Bit widths must be same for comparison";
    if (isSingleWord()) {
      long/*int64_t*/ lhsSext = SignExtend64(this.VAL, BitWidth);
      long/*int64_t*/ rhsSext = SignExtend64(RHS.VAL, BitWidth);
      return lhsSext < rhsSext;
    }
    
    boolean lhsNeg = isNegative();
    boolean rhsNeg = RHS.isNegative();
    
    // If the sign bits don't match, then (LHS < RHS) if LHS is negative
    if (lhsNeg != rhsNeg) {
      return lhsNeg;
    }
    
    // Otherwise we can just use an unsigned comparision, because even negative
    // numbers compare correctly this way if both have the same signed-ness.
    return ult(RHS);
  }

  
  /// \brief Signed less than comparison
  ///
  /// Regards both *this as a signed quantity and compares it with RHS for
  /// the validity of the less-than relationship.
  ///
  /// \returns true if *this < RHS when considered signed.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::slt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1065,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1060,
   FQN="llvm::APInt::slt", NM="_ZNK4llvm5APInt3sltEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt3sltEx")
  //</editor-fold>
  public boolean slt(long/*int64_t*/ RHS) /*const*/ {
    return $greater_uint(getMinSignedBits(), 64) ? isNegative() : getSExtValue() < RHS;
  }

  
  /// \brief Unsigned less or equal comparison
  ///
  /// Regards both *this and RHS as unsigned quantities and compares them for
  /// validity of the less-or-equal relationship.
  ///
  /// \returns true if *this <= RHS when both are considered unsigned.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::ule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1075,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1070,
   FQN="llvm::APInt::ule", NM="_ZNK4llvm5APInt3uleERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt3uleERKS0_")
  //</editor-fold>
  public boolean ule(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    return ult(RHS) || eq(RHS);
  }

  
  /// \brief Unsigned less or equal comparison
  ///
  /// Regards both *this as an unsigned quantity and compares it with RHS for
  /// the validity of the less-or-equal relationship.
  ///
  /// \returns true if *this <= RHS when considered unsigned.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::ule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1083,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1078,
   FQN="llvm::APInt::ule", NM="_ZNK4llvm5APInt3uleEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt3uleEy")
  //</editor-fold>
  public boolean ule(long/*uint64_t*/ RHS) /*const*/ {
    return !ugt(RHS);
  }

  
  /// \brief Signed less or equal comparison
  ///
  /// Regards both *this and RHS as signed quantities and compares them for
  /// validity of the less-or-equal relationship.
  ///
  /// \returns true if *this <= RHS when both are considered signed.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::sle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1091,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1086,
   FQN="llvm::APInt::sle", NM="_ZNK4llvm5APInt3sleERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt3sleERKS0_")
  //</editor-fold>
  public boolean sle(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    return slt(RHS) || eq(RHS);
  }

  
  /// \brief Signed less or equal comparison
  ///
  /// Regards both *this as a signed quantity and compares it with RHS for the
  /// validity of the less-or-equal relationship.
  ///
  /// \returns true if *this <= RHS when considered signed.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::sle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1099,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1094,
   FQN="llvm::APInt::sle", NM="_ZNK4llvm5APInt3sleEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt3sleEy")
  //</editor-fold>
  public boolean sle(long/*uint64_t*/ RHS) /*const*/ {
    return !sgt(RHS);
  }

  
  /// \brief Unsigned greather than comparison
  ///
  /// Regards both *this and RHS as unsigned quantities and compares them for
  /// the validity of the greater-than relationship.
  ///
  /// \returns true if *this > RHS when both are considered unsigned.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::ugt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1107,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1102,
   FQN="llvm::APInt::ugt", NM="_ZNK4llvm5APInt3ugtERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt3ugtERKS0_")
  //</editor-fold>
  public boolean ugt(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    return !ult(RHS) && !eq(RHS);
  }

  
  /// \brief Unsigned greater than comparison
  ///
  /// Regards both *this as an unsigned quantity and compares it with RHS for
  /// the validity of the greater-than relationship.
  ///
  /// \returns true if *this > RHS when considered unsigned.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::ugt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1115,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1110,
   FQN="llvm::APInt::ugt", NM="_ZNK4llvm5APInt3ugtEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt3ugtEy")
  //</editor-fold>
  public boolean ugt(long/*uint64_t*/ RHS) /*const*/ {
    return $greater_uint(getActiveBits(), 64) ? true : $greater_ulong(getZExtValue(), RHS);
  }

  
  /// \brief Signed greather than comparison
  ///
  /// Regards both *this and RHS as signed quantities and compares them for the
  /// validity of the greater-than relationship.
  ///
  /// \returns true if *this > RHS when both are considered signed.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::sgt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1125,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1120,
   FQN="llvm::APInt::sgt", NM="_ZNK4llvm5APInt3sgtERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt3sgtERKS0_")
  //</editor-fold>
  public boolean sgt(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    return !slt(RHS) && !eq(RHS);
  }

  
  /// \brief Signed greater than comparison
  ///
  /// Regards both *this as a signed quantity and compares it with RHS for
  /// the validity of the greater-than relationship.
  ///
  /// \returns true if *this > RHS when considered signed.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::sgt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1133,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1128,
   FQN="llvm::APInt::sgt", NM="_ZNK4llvm5APInt3sgtEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt3sgtEx")
  //</editor-fold>
  public boolean sgt(long/*int64_t*/ RHS) /*const*/ {
    return $greater_uint(getMinSignedBits(), 64) ? !isNegative() : getSExtValue() > RHS;
  }

  
  /// \brief Unsigned greater or equal comparison
  ///
  /// Regards both *this and RHS as unsigned quantities and compares them for
  /// validity of the greater-or-equal relationship.
  ///
  /// \returns true if *this >= RHS when both are considered unsigned.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::uge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1143,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1138,
   FQN="llvm::APInt::uge", NM="_ZNK4llvm5APInt3ugeERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt3ugeERKS0_")
  //</editor-fold>
  public boolean uge(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    return !ult(RHS);
  }

  
  /// \brief Unsigned greater or equal comparison
  ///
  /// Regards both *this as an unsigned quantity and compares it with RHS for
  /// the validity of the greater-or-equal relationship.
  ///
  /// \returns true if *this >= RHS when considered unsigned.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::uge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1151,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1146,
   FQN="llvm::APInt::uge", NM="_ZNK4llvm5APInt3ugeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt3ugeEy")
  //</editor-fold>
  public boolean uge(long/*uint64_t*/ RHS) /*const*/ {
    return !ult(RHS);
  }

  
  /// \brief Signed greather or equal comparison
  ///
  /// Regards both *this and RHS as signed quantities and compares them for
  /// validity of the greater-or-equal relationship.
  ///
  /// \returns true if *this >= RHS when both are considered signed.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::sge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1159,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1154,
   FQN="llvm::APInt::sge", NM="_ZNK4llvm5APInt3sgeERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt3sgeERKS0_")
  //</editor-fold>
  public boolean sge(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    return !slt(RHS);
  }

  
  /// \brief Signed greater or equal comparison
  ///
  /// Regards both *this as a signed quantity and compares it with RHS for
  /// the validity of the greater-or-equal relationship.
  ///
  /// \returns true if *this >= RHS when considered signed.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::sge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1167,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1162,
   FQN="llvm::APInt::sge", NM="_ZNK4llvm5APInt3sgeEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt3sgeEx")
  //</editor-fold>
  public boolean sge(long/*int64_t*/ RHS) /*const*/ {
    return !slt(RHS);
  }

  
  /// This operation tests if there are any pairs of corresponding bits
  /// between this APInt and RHS that are both set.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::intersects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1171,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1166,
   FQN="llvm::APInt::intersects", NM="_ZNK4llvm5APInt10intersectsERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt10intersectsERKS0_")
  //</editor-fold>
  public boolean intersects(final /*const*/ APInt /*&*/ RHS) /*const*/ {
    return (/*Deref*/this.$bitand(RHS)).$noteq(0);
  }

  
  /// @}
  /// \name Resizing Operators
  /// @{
  
  /// \brief Truncate to new width.
  ///
  /// Truncate the APInt to a specified width. It is an error to specify a width
  /// that is greater than or equal to the current width.
  
  // Truncate to new width.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::trunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 938,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 932,
   FQN="llvm::APInt::trunc", NM="_ZNK4llvm5APInt5truncEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt5truncEj")
  //</editor-fold>
  public APInt trunc(/*uint*/int width) /*const*//* __attribute__((warn_unused_result))*/ {
    assert ($less_uint(width, BitWidth)) : "Invalid APInt Truncate request";
    assert ((width != 0)) : "Can't truncate to 0 bits";
    if ($lesseq_uint_int(width, APINT_BITS_PER_WORD)) {
      return new APInt(width, getRawData().$at(0));
    }
    
    APInt Result/*J*/= new APInt(getMemory(getNumWords(width)), width);
    
    // Copy full words.
    /*uint*/int i;
    for (i = 0; i != $div_uint_int(width, APINT_BITS_PER_WORD); i++)  {
      Result.pVal.$set(i, this.pVal.$at(i));
    }
    
    // Truncate and copy any partial word.
    /*uint*/int bits = $rem_uint_int((0 - width), APINT_BITS_PER_WORD);
    if (bits != 0) {
      Result.pVal.$set(i, this.pVal.$at(i) << bits >>> bits);
    }
    
    return Result;
  }

  
  /// \brief Sign extend to a new width.
  ///
  /// This operation sign extends the APInt to a new width. If the high order
  /// bit is set, the fill on the left will be done with 1 bits, otherwise zero.
  /// It is an error to specify a width that is less than or equal to the
  /// current width.
  
  // Sign extend to a new width.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::sext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 961,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 955,
   FQN="llvm::APInt::sext", NM="_ZNK4llvm5APInt4sextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt4sextEj")
  //</editor-fold>
  public APInt sext(/*uint*/int width) /*const*//* __attribute__((warn_unused_result))*/ {
    assert ($greater_uint(width, BitWidth)) : "Invalid APInt SignExtend request";
    if ($lesseq_uint_int(width, APINT_BITS_PER_WORD)) {
      long/*uint64_t*/ val = this.VAL << (APINT_BITS_PER_WORD - BitWidth);
      val = (long/*int64_t*/)val >> (width - BitWidth);
      return new APInt(width, val >>> (APINT_BITS_PER_WORD - width));
    }
    
    APInt Result/*J*/= new APInt(getMemory(getNumWords(width)), width);
    
    // Copy full words.
    /*uint*/int i;
    long/*uint64_t*/ word = 0;
    for (i = 0; i != $div_uint_int(BitWidth, APINT_BITS_PER_WORD); i++) {
      word = getRawData().$at(i);
      Result.pVal.$set(i, word);
    }
    
    // Read and sign-extend any partial word.
    /*uint*/int bits = $rem_uint_int((0 - BitWidth), APINT_BITS_PER_WORD);
    if (bits != 0) {
      word = (long/*int64_t*/)getRawData().$at(i) << bits >> bits;
    } else {
      word = (long/*int64_t*/)word >> (APINT_BITS_PER_WORD - 1);
    }
    
    // Write remaining full words.
    for (; i != $div_uint_int(width, APINT_BITS_PER_WORD); i++) {
      Result.pVal.$set(i, word);
      word = (long/*int64_t*/)word >> (APINT_BITS_PER_WORD - 1);
    }
    
    // Write any partial word.
    bits = $rem_uint_int((0 - width), APINT_BITS_PER_WORD);
    if (bits != 0) {
      Result.pVal.$set(i, word << bits >>> bits);
    }
    
    return Result;
  }

  
  /// \brief Zero extend to a new width.
  ///
  /// This operation zero extends the APInt to a new width. The high order bits
  /// are filled with 0 bits.  It is an error to specify a width that is less
  /// than or equal to the current width.
  
  //  Zero extend to a new width.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::zext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1002,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 996,
   FQN="llvm::APInt::zext", NM="_ZNK4llvm5APInt4zextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt4zextEj")
  //</editor-fold>
  public APInt zext(/*uint*/int width) /*const*//* __attribute__((warn_unused_result))*/ {
    assert ($greater_uint(width, BitWidth)) : "Invalid APInt ZeroExtend request";
    if ($lesseq_uint_int(width, APINT_BITS_PER_WORD)) {
      return new APInt(width, this.VAL);
    }
    
    APInt Result/*J*/= new APInt(getMemory(getNumWords(width)), width);
    
    // Copy words.
    /*uint*/int i;
    for (i = 0; i != getNumWords(); i++)  {
      Result.pVal.$set(i, getRawData().$at(i));
    }
    
    // Zero remaining words.
    memset(Result.pVal.$add(i), 0, (Result.getNumWords() - i) * APINT_WORD_SIZE);
    
    return Result;
  }

  
  /// \brief Sign extend or truncate to width
  ///
  /// Make this APInt have the bit width given by \p width. The value is sign
  /// extended, truncated, or left alone to make it that width.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::sextOrTrunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1029,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1023,
   FQN="llvm::APInt::sextOrTrunc", NM="_ZNK4llvm5APInt11sextOrTruncEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt11sextOrTruncEj")
  //</editor-fold>
  public APInt sextOrTrunc(/*uint*/int width) /*const*//* __attribute__((warn_unused_result))*/ {
    if ($less_uint(BitWidth, width)) {
      return sext(width);
    }
    if ($greater_uint(BitWidth, width)) {
      return trunc(width);
    }
    return new APInt(/*Deref*/this);
  }

  
  /// \brief Zero extend or truncate to width
  ///
  /// Make this APInt have the bit width given by \p width. The value is zero
  /// extended, truncated, or left alone to make it that width.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::zextOrTrunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1021,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1015,
   FQN="llvm::APInt::zextOrTrunc", NM="_ZNK4llvm5APInt11zextOrTruncEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt11zextOrTruncEj")
  //</editor-fold>
  public APInt zextOrTrunc(/*uint*/int width) /*const*//* __attribute__((warn_unused_result))*/ {
    if ($less_uint(BitWidth, width)) {
      return zext(width);
    }
    if ($greater_uint(BitWidth, width)) {
      return trunc(width);
    }
    return new APInt(/*Deref*/this);
  }

  
  /// \brief Sign extend or truncate to width
  ///
  /// Make this APInt have the bit width given by \p width. The value is sign
  /// extended, or left alone to make it that width.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::sextOrSelf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1043,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1037,
   FQN="llvm::APInt::sextOrSelf", NM="_ZNK4llvm5APInt10sextOrSelfEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt10sextOrSelfEj")
  //</editor-fold>
  public APInt sextOrSelf(/*uint*/int width) /*const*//* __attribute__((warn_unused_result))*/ {
    if ($less_uint(BitWidth, width)) {
      return sext(width);
    }
    return new APInt(/*Deref*/this);
  }

  
  /// \brief Zero extend or truncate to width
  ///
  /// Make this APInt have the bit width given by \p width. The value is zero
  /// extended, or left alone to make it that width.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::zextOrSelf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1037,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1031,
   FQN="llvm::APInt::zextOrSelf", NM="_ZNK4llvm5APInt10zextOrSelfEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt10zextOrSelfEj")
  //</editor-fold>
  public APInt zextOrSelf(/*uint*/int width) /*const*//* __attribute__((warn_unused_result))*/ {
    if ($less_uint(BitWidth, width)) {
      return zext(width);
    }
    return new APInt(/*Deref*/this);
  }

  
  /// @}
  /// \name Bit Manipulation Operators
  /// @{
  
  /// \brief Set every bit to 1.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::setAllBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1227,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1222,
   FQN="llvm::APInt::setAllBits", NM="_ZN4llvm5APInt10setAllBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt10setAllBitsEv")
  //</editor-fold>
  public void setAllBits() {
    if (isSingleWord()) {
      this.VAL = std.UINT64_MAX;
    } else {
      // Set all the bits in all the words.
      for (/*uint*/int i = 0; $less_uint(i, getNumWords()); ++i)  {
        this.pVal.$set(i, std.UINT64_MAX);
      }
    }
    // Clear the unused ones
    clearUnusedBits();
  }

  
  /// \brief Set a given bit to 1.
  ///
  /// Set the given bit to 1 whose position is given as "bitPosition".
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::setBit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 575,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 588,
   FQN="llvm::APInt::setBit", NM="_ZN4llvm5APInt6setBitEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt6setBitEj")
  //</editor-fold>
  public void setBit(/*uint*/int bitPosition) {
    if (isSingleWord()) {
      this.VAL |= maskBit(bitPosition);
    } else {
      this.pVal.$set$orassign(whichWord(bitPosition), maskBit(bitPosition));
    }
  }

  
  /// \brief Set every bit to 0.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::clearAllBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1245,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1240,
   FQN="llvm::APInt::clearAllBits", NM="_ZN4llvm5APInt12clearAllBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt12clearAllBitsEv")
  //</editor-fold>
  public void clearAllBits() {
    if (isSingleWord()) {
      this.VAL = 0;
    } else {
      memset(this.pVal, 0, getNumWords() * APINT_WORD_SIZE);
    }
  }

  
  /// \brief Set a given bit to 0.
  ///
  /// Set the given bit to 0 whose position is given as "bitPosition".
  
  /// Set the given bit to 0 whose position is given as "bitPosition".
  /// @brief Set a given bit to 0.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::clearBit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 584,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 597,
   FQN="llvm::APInt::clearBit", NM="_ZN4llvm5APInt8clearBitEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt8clearBitEj")
  //</editor-fold>
  public void clearBit(/*uint*/int bitPosition) {
    if (isSingleWord()) {
      this.VAL &= ~maskBit(bitPosition);
    } else {
      this.pVal.$set$andassign(whichWord(bitPosition), ~maskBit(bitPosition));
    }
  }

  
  /// \brief Toggle every bit to its opposite value.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::flipAllBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1258,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1253,
   FQN="llvm::APInt::flipAllBits", NM="_ZN4llvm5APInt11flipAllBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt11flipAllBitsEv")
  //</editor-fold>
  public void flipAllBits() {
    if (isSingleWord()) {
      this.VAL ^= std.UINT64_MAX;
    } else {
      for (/*uint*/int i = 0; $less_uint(i, getNumWords()); ++i)  {
        this.pVal.$set$xorassign(i, std.UINT64_MAX);
      }
    }
    clearUnusedBits();
  }

  
  /// \brief Toggles a given bit to its opposite value.
  ///
  /// Toggle a given bit to its opposite value whose position is given
  /// as "bitPosition".
  
  /// @brief Toggle every bit to its opposite value.
  
  /// Toggle a given bit to its opposite value whose position is given
  /// as "bitPosition".
  /// @brief Toggles a given bit to its opposite value.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::flipBit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 596,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 609,
   FQN="llvm::APInt::flipBit", NM="_ZN4llvm5APInt7flipBitEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt7flipBitEj")
  //</editor-fold>
  public void flipBit(/*uint*/int bitPosition) {
    assert ($less_uint(bitPosition, BitWidth)) : "Out of the bit-width range!";
    if ((/*Deref*/this).$at(bitPosition)) {
      clearBit(bitPosition);
    } else {
      setBit(bitPosition);
    }
  }

  
  /// @}
  /// \name Value Characterization Functions
  /// @{
  
  /// \brief Return the number of bits in the APInt.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getBitWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1279,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1274,
   FQN="llvm::APInt::getBitWidth", NM="_ZNK4llvm5APInt11getBitWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt11getBitWidthEv")
  //</editor-fold>
  public /*uint*/int getBitWidth() /*const*/ {
    return BitWidth;
  }

  
  /// \brief Get the number of words.
  ///
  /// Here one word's bitwidth equals to that of uint64_t.
  ///
  /// \returns the number of words to hold the integer value of this APInt.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getNumWords">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1286,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1281,
   FQN="llvm::APInt::getNumWords", NM="_ZNK4llvm5APInt11getNumWordsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt11getNumWordsEv")
  //</editor-fold>
  public /*uint*/int getNumWords() /*const*/ {
    return getNumWords(BitWidth);
  }

  
  /// \brief Get the number of words.
  ///
  /// *NOTE* Here one word's bitwidth equals to that of uint64_t.
  ///
  /// \returns the number of words to hold the integer value with a given bit
  /// width.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getNumWords">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1294,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1289,
   FQN="llvm::APInt::getNumWords", NM="_ZN4llvm5APInt11getNumWordsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt11getNumWordsEj")
  //</editor-fold>
  public static /*uint*/int getNumWords(/*uint*/int BitWidth) {
    return $ullong2uint($div_ullong_int(((long/*uint64_t*/)$uint2ulong(BitWidth) + $uint2ullong(APINT_BITS_PER_WORD) - 1), APINT_BITS_PER_WORD));
  }
  
  
  /// \brief Compute the number of active bits in the value
  ///
  /// This function returns the number of active bits which is defined as the
  /// bit width minus the number of leading zeros. This is used in several
  /// computations to see how "wide" the value is.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getActiveBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1303,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1298,
   FQN="llvm::APInt::getActiveBits", NM="_ZNK4llvm5APInt13getActiveBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt13getActiveBitsEv")
  //</editor-fold>
  public /*uint*/int getActiveBits() /*const*/ {
    return BitWidth - countLeadingZeros();
  }

  
  /// \brief Compute the number of active words in the value of this APInt.
  ///
  /// This is used in conjunction with getActiveData to extract the raw value of
  /// the APInt.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getActiveWords">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1309,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1304,
   FQN="llvm::APInt::getActiveWords", NM="_ZNK4llvm5APInt14getActiveWordsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt14getActiveWordsEv")
  //</editor-fold>
  public /*uint*/int getActiveWords() /*const*/ {
    /*uint*/int numActiveBits = getActiveBits();
    return (numActiveBits != 0) ? whichWord(numActiveBits - 1) + 1 : 1;
  }

  
  /// \brief Get the minimum bit size for this signed APInt
  ///
  /// Computes the minimum bit width for this APInt while considering it to be a
  /// signed (and probably negative) value. If the value is not negative, this
  /// function returns the same value as getActiveBits()+1. Otherwise, it
  /// returns the smallest bit width that will retain the negative value. For
  /// example, -1 can be written as 0b1 or 0xFFFFFFFFFF. 0b1 is shorter and so
  /// for -1, this function will always return 1.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getMinSignedBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1322,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1317,
   FQN="llvm::APInt::getMinSignedBits", NM="_ZNK4llvm5APInt16getMinSignedBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt16getMinSignedBitsEv")
  //</editor-fold>
  public /*uint*/int getMinSignedBits() /*const*/ {
    if (isNegative()) {
      return BitWidth - countLeadingOnes() + 1;
    }
    return getActiveBits() + 1;
  }

  
  /// \brief Get zero extended value
  ///
  /// This method attempts to return the value of this APInt as a zero extended
  /// uint64_t. The bitwidth must be <= 64 or the value must fit within a
  /// uint64_t. Otherwise an assertion will result.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getZExtValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1333,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1328,
   FQN="llvm::APInt::getZExtValue", NM="_ZNK4llvm5APInt12getZExtValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt12getZExtValueEv")
  //</editor-fold>
  public long/*uint64_t*/ getZExtValue() /*const*/ {
    if (isSingleWord()) {
      return this.VAL;
    }
    assert ($lesseq_uint(getActiveBits(), 64)) : "Too many bits for uint64_t";
    return this.pVal.$at(0);
  }

  
  /// \brief Get sign extended value
  ///
  /// This method attempts to return the value of this APInt as a sign extended
  /// int64_t. The bit width must be <= 64 or the value must fit within an
  /// int64_t. Otherwise an assertion will result.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getSExtValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1345,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1340,
   FQN="llvm::APInt::getSExtValue", NM="_ZNK4llvm5APInt12getSExtValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt12getSExtValueEv")
  //</editor-fold>
  public long/*int64_t*/ getSExtValue() /*const*/ {
    if (isSingleWord()) {
      return ((long/*int64_t*/)(this.VAL << (APINT_BITS_PER_WORD - BitWidth))) 
         >> (APINT_BITS_PER_WORD - BitWidth);
    }
    assert ($lesseq_uint(getMinSignedBits(), 64)) : "Too many bits for int64_t";
    return ((long/*int64_t*/)(this.pVal.$at(0)));
  }

  
  /// \brief Get bits required for string value.
  ///
  /// This method determines how many bits are required to hold the APInt
  /// equivalent of the string given by \p str.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getBitsNeeded">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 602,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 615,
   FQN="llvm::APInt::getBitsNeeded", NM="_ZN4llvm5APInt13getBitsNeededENS_9StringRefEh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt13getBitsNeededENS_9StringRefEh")
  //</editor-fold>
  public static /*uint*/int getBitsNeeded(String str, int/*uint8_t*/ radix) {
    return getBitsNeeded(new StringRef(str), $uint2char(radix));
  }  
  public static /*uint*/int getBitsNeeded(StringRef str, byte/*uint8_t*/ radix) {
    return getBitsNeededImpl(str, radix);
  }
  private static /*uint*/int getBitsNeededImpl(StringRef str, byte/*uint8_t*/ radix) {
    assert (!str.empty()) : "Invalid string length";
    assert (($uchar2int(radix) == 10 || $uchar2int(radix) == 8 || $uchar2int(radix) == 16 || $uchar2int(radix) == 2 || $uchar2int(radix) == 36)) : "Radix should be 2, 8, 10, 16, or 36!";
    
    /*size_t*/int slen = str.size();
    
    // Each computation below needs to know if it's negative.
    char$ptr p = $tryClone(str.begin());
    /*uint*/int isNegative = ((p.$star() == $$MINUS) ? 1 : 0);
    if (p.$star() == $$MINUS || p.$star() == $$PLUS) {
      p.$postInc();
      slen--;
      assert ((slen != 0)) : "String is only a sign, needs a value.";
    }
    
    // For radixes of power-of-two values, the bits required is accurately and
    // easily computed
    if ($uchar2int(radix) == 2) {
      return slen + isNegative;
    }
    if ($uchar2int(radix) == 8) {
      return slen * 3 + isNegative;
    }
    if ($uchar2int(radix) == 16) {
      return slen * 4 + isNegative;
    }
    
    // FIXME: base 36
    
    // This is grossly inefficient but accurate. We could probably do something
    // with a computation of roughly slen*64/20 and then adjust by the value of
    // the first few digits. But, I'm not sure how accurate that could be.
    
    // Compute a sufficient number of bits that is always large enough but might
    // be too large. This avoids the assertion in the constructor. This
    // calculation doesn't work appropriately for the numbers 0-9, so just use 4
    // bits in that case.
    /*uint*/int sufficient = $uchar2int(radix) == 10 ? (slen == 1 ? 4 : $div_uint(slen * 64, 18)) : (slen == 1 ? 7 : $div_uint(slen * 16, 3));
    
    // Convert to the actual binary value.
    APInt tmp/*J*/= new APInt(sufficient, new StringRef(p, slen), radix);
    
    // Compute how many bits are required. If the log is infinite, assume we need
    // just bit.
    /*uint*/int log = tmp.logBase2();
    if (log == (/*uint*/int)-1) {
      return isNegative + 1;
    } else {
      return isNegative + log + 1;
    }
  }

  
  /// \brief The APInt version of the countLeadingZeros functions in
  ///   MathExtras.h.
  ///
  /// It counts the number of zeros from the most significant bit to the first
  /// one bit.
  ///
  /// \returns BitWidth if the value is zero, otherwise returns the number of
  ///   zeros from the most significant bit to the first one bits.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::countLeadingZeros">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1367,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1362,
   FQN="llvm::APInt::countLeadingZeros", NM="_ZNK4llvm5APInt17countLeadingZerosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt17countLeadingZerosEv")
  //</editor-fold>
  public /*uint*/int countLeadingZeros() /*const*/ {
    if (isSingleWord()) {
      /*uint*/int unusedBits = APINT_BITS_PER_WORD - BitWidth;
      return llvm.countLeadingZeros(this.VAL) - unusedBits;
    }
    return countLeadingZerosSlowCase();
  }

  
  /// \brief Count the number of leading one bits.
  ///
  /// This function is an APInt version of the countLeadingOnes_{32,64}
  /// functions in MathExtras.h. It counts the number of ones from the most
  /// significant bit to the first zero bit.
  ///
  /// \returns 0 if the high order bit is not set, otherwise returns the number
  /// of 1 bits from the most significant to the least
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::countLeadingOnes">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 698,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 722,
   FQN="llvm::APInt::countLeadingOnes", NM="_ZNK4llvm5APInt16countLeadingOnesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt16countLeadingOnesEv")
  //</editor-fold>
  public /*uint*/int countLeadingOnes() /*const*/ {
    if (isSingleWord()) {
      return CountLeadingOnes_64(this.VAL << (APINT_BITS_PER_WORD - BitWidth));
    }
    
    /*uint*/int highWordBits = $rem_uint_int(BitWidth, APINT_BITS_PER_WORD);
    /*uint*/int shift;
    if (!(highWordBits != 0)) {
      highWordBits = APINT_BITS_PER_WORD;
      shift = 0;
    } else {
      shift = APINT_BITS_PER_WORD - highWordBits;
    }
    int i = getNumWords() - 1;
    /*uint*/int Count = CountLeadingOnes_64(this.pVal.$at(i) << shift);
    if (Count == highWordBits) {
      for (i--; i >= 0; --i) {
        if (this.pVal.$at(i) == -1L/*ULL*/) {
          Count += APINT_BITS_PER_WORD;
        } else {
          Count += CountLeadingOnes_64(this.pVal.$at(i));
          break;
        }
      }
    }
    return Count;
  }

  
  /// Computes the number of leading bits of this APInt that are equal to its
  /// sign bit.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::getNumSignBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1387,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1382,
   FQN="llvm::APInt::getNumSignBits", NM="_ZNK4llvm5APInt14getNumSignBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt14getNumSignBitsEv")
  //</editor-fold>
  public /*uint*/int getNumSignBits() /*const*/ {
    return isNegative() ? countLeadingOnes() : countLeadingZeros();
  }

  
  /// \brief Count the number of trailing zero bits.
  ///
  /// This function is an APInt version of the countTrailingZeros_{32,64}
  /// functions in MathExtras.h. It counts the number of zeros from the least
  /// significant bit to the first set bit.
  ///
  /// \returns BitWidth if the value is zero, otherwise returns the number of
  /// zeros from the least significant bit to the first one bit.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::countTrailingZeros">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 725,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 749,
   FQN="llvm::APInt::countTrailingZeros", NM="_ZNK4llvm5APInt18countTrailingZerosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt18countTrailingZerosEv")
  //</editor-fold>
  public /*uint*/int countTrailingZeros() /*const*/ {
    if (isSingleWord()) {
      return std.min_uint(((/*uint*/int)(llvm.countTrailingZeros_uint64_t_ZeroBehavior(this.VAL))), BitWidth);
    }
    /*uint*/int Count = 0;
    /*uint*/int i = 0;
    for (; $less_uint(i, getNumWords()) && this.pVal.$at(i) == 0; ++i)  {
      Count += APINT_BITS_PER_WORD;
    }
    if ($less_uint(i, getNumWords())) {
      Count += llvm.countTrailingZeros_uint64_t_ZeroBehavior(this.pVal.$at(i));
    }
    return std.min_uint(Count, BitWidth);
  }

  
  /// \brief Count the number of trailing one bits.
  ///
  /// This function is an APInt version of the countTrailingOnes_{32,64}
  /// functions in MathExtras.h. It counts the number of ones from the least
  /// significant bit to the first zero bit.
  ///
  /// \returns BitWidth if the value is all ones, otherwise returns the number
  /// of ones from the least significant bit to the first zero bit.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::countTrailingOnes">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1409,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1404,
   FQN="llvm::APInt::countTrailingOnes", NM="_ZNK4llvm5APInt17countTrailingOnesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt17countTrailingOnesEv")
  //</editor-fold>
  public /*uint*/int countTrailingOnes() /*const*/ {
    if (isSingleWord()) {
      return CountTrailingOnes_64(this.VAL);
    }
    return countTrailingOnesSlowCase();
  }

  
  /// \brief Count the number of bits set.
  ///
  /// This function is an APInt version of the countPopulation_{32,64} functions
  /// in MathExtras.h. It counts the number of 1 bits in the APInt value.
  ///
  /// \returns 0 if the value is zero, otherwise returns the number of set bits.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::countPopulation">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1421,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1416,
   FQN="llvm::APInt::countPopulation", NM="_ZNK4llvm5APInt15countPopulationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt15countPopulationEv")
  //</editor-fold>
  public /*uint*/int countPopulation() /*const*/ {
    if (isSingleWord()) {
      return CountPopulation_64(this.VAL);
    }
    return countPopulationSlowCase();
  }

  
  /// @}
  /// \name Conversion Functions
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2283,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2279,
   FQN="llvm::APInt::print", NM="_ZNK4llvm5APInt5printERNS_11raw_ostreamEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt5printERNS_11raw_ostreamEb")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS, boolean isSigned) /*const*/ {
    SmallString/*40*/ S/*J*/= new SmallString/*40*/(40);
    this.__toString(S, 10, isSigned, /* formatAsCLiteral = */ false);
    OS.$out(S);
  }

  
  /// Converts an APInt to a string and append it to Str.  Str is commonly a
  /// SmallString.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::toString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2147,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2143,
   FQN="llvm::APInt::toString", NM="_ZNK4llvm5APInt8toStringERNS_15SmallVectorImplIcEEjbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt8toStringERNS_15SmallVectorImplIcEEjbb")
  //</editor-fold>
  public void __toString(final SmallString/*&*/ Str, /*uint*/int Radix, 
            boolean Signed) /*const*/ {
    __toString(Str, Radix, 
            Signed, false);
  }
  public void __toString(final SmallString/*&*/ Str, /*uint*/int Radix, 
            boolean Signed, boolean formatAsCLiteral/*= false*/) /*const*/ {
    assert ((Radix == 10 || Radix == 8 || Radix == 16 || Radix == 2 || Radix == 36)) : "Radix should be 2, 8, 10, 16, or 36!";

    /*const*/char$ptr/*char P*/ Prefix = $EMPTY;
    if (formatAsCLiteral) {
      switch (Radix) {
       case 2:
        // Binary literals are a non-standard extension added in gcc 4.3:
        // http://gcc.gnu.org/onlinedocs/gcc-4.3.0/gcc/Binary-constants.html
        Prefix = $tryClone($("0b"));
        break;
       case 8:
        Prefix = $tryClone($0);
        break;
       case 10:
        break; // No prefix
       case 16:
        Prefix = $tryClone($("0x"));
        break;
       default:
        throw new llvm_unreachable("Invalid radix!");
      }
    }

    // First, check for a zero value and just short circuit the logic below.
    if (/*Deref*/this.$eq(0)) {
      while ((Prefix.$star() != 0)) {
        Str.push_back(Prefix.$star());
        Prefix.$preInc();
      }
      ;
      Str.push_back($$0);
      return;
    }

    final/*static*/ /*const*//*char*/byte Digits[/*37*/] = __toString$$.Digits;
    if (isSingleWord()) {
      // we have problems with LONG_MIN_VAL which stay negative, so use own version
      if (false/*JAVA*/) {
        // JAVA: use toString utils
        while ((Prefix.$star() != 0)) {
          Str.push_back(Prefix.$star());
          Prefix.$preInc();
        }     
        long/*uint64_t*/ N = Signed ? getSExtValue() : getZExtValue();
        String strOut = Signed ? ULongToSignedString(N, Radix) : ULongToUnsignedString(N, Radix);
        Str.append(strOut);
        return;
      }
      /*char*/char$ptr Buffer = create_char$ptr(new$char(65));
      char$ptr/*char P*/ BufPtr = Buffer.$add(65);

      long/*uint64_t*/ N;
      if (!Signed) {
        N = getZExtValue();
      } else {
        long/*int64_t*/ I = getSExtValue();
        if (I >= 0) {
          N = I;
        } else {
          Str.push_back($$MINUS);
          N = -(long/*uint64_t*/)I;
        }
      }      
      while ((Prefix.$star() != 0)) {
        Str.push_back(Prefix.$star());
        Prefix.$preInc();
      }
      ;
      while ((N != 0)) {
        // (N % $uint2ullong(Radix))
        /*ulong*/long Digit = $rem_ulong_uint(N, Radix);
        BufPtr.$preDec().$set(Digits[(/*uint*/int)Digit]);
//        N /= $uint2ullong(Radix);
        N = $div_ulong_uint(N, Radix);
      }
      Str.append(BufPtr, /*count till the end of Buffer*/ 65-BufPtr.$index());
      return;
    }

    APInt Tmp/*J*/= new APInt(/*Deref*/this);
    if (Signed && isNegative()) {
      // They want to print the signed version and it is a negative value
      // Flip the bits and add one to turn it into the equivalent positive
      // value and put a '-' in the result.
      Tmp.flipAllBits();
      Tmp.$preInc();
      Str.push_back($$MINUS);
    }
    while ((Prefix.$star() != 0)) {
      Str.push_back(Prefix.$star());
      Prefix.$preInc();
    }
    ;

    // We insert the digits backward, then reverse them to get the right order.
    /*uint*/int StartDig = Str.size();

    // For the 2, 8 and 16 bit cases, we can just shift instead of divide
    // because the number of bits per digit (1, 3 and 4 respectively) divides
    // equaly.  We just shift until the value is zero.
    if (Radix == 2 || Radix == 8 || Radix == 16) {
      // Just shift tmp right for each digit width until it becomes zero
      /*uint*/int ShiftAmt = (Radix == 16 ? 4 : (Radix == 8 ? 3 : 1));
      /*uint*/int MaskAmt = Radix - 1;
      while (Tmp.$noteq(0)) {
        /*uint*/int Digit = ((/*uint*/int)((Tmp.getRawData().$at(0)))) & MaskAmt;
        Str.push_back(Digits[Digit]);
        Tmp.$assignMove(Tmp.lshr(ShiftAmt));
      }
    } else {
      APInt divisor/*J*/= new APInt(JD$UInt_ULong.INSTANCE, Radix == 10 ? 4 : 8, $uint2ulong(Radix));
      while (Tmp.$noteq(0)) {
        APInt APdigit/*J*/= new APInt(JD$UInt_ULong.INSTANCE, 1, 0);
        APInt tmp2/*J*/= new APInt(JD$UInt_ULong.INSTANCE, Tmp.getBitWidth(), 0);
        divide(Tmp, Tmp.getNumWords(), divisor, divisor.getNumWords(), $AddrOf(tmp2), 
            $AddrOf(APdigit));
        /*uint*/int Digit = (/*uint*/int)$ulong2uint(APdigit.getZExtValue());
        assert ($less_uint(Digit, Radix)) : "divide failed";
        Str.push_back(Digits[Digit]);
        Tmp.$assign(tmp2);
      }
    }

    // Reverse the digits before returning.
    std.reverse(Str.begin().$add(StartDig), Str.end());
  }
  private static final class __toString$$ {
    static final/*static*/ /*const*//*char*/byte Digits[/*37*/];
    static {
      byte aDigits[];
      try {
        aDigits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".getBytes("ascii");
      } catch (UnsupportedEncodingException ex) {
        aDigits = new byte[0];
        Logger.getLogger(APInt.class.getName()).log(Level.SEVERE, null, ex);
      }
      Digits = aDigits;
      assert NativeTrace.registerArrayWithImmutableContent(Digits, "APInt.Digits");
    }
  }

  
  /// Considers the APInt to be unsigned and converts it into a string in the
  /// radix given. The radix can be 2, 8, 10 16, or 36.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::toStringUnsigned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1439,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1434,
   FQN="llvm::APInt::toStringUnsigned", NM="_ZNK4llvm5APInt16toStringUnsignedERNS_15SmallVectorImplIcEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt16toStringUnsignedERNS_15SmallVectorImplIcEEj")
  //</editor-fold>
  public void toStringUnsigned(final SmallString/*&*/ Str) /*const*/ {
    toStringUnsigned(Str, 10);
  }
  public void toStringUnsigned(final SmallString/*&*/ Str, /*uint*/int Radix/*= 10*/) /*const*/ {
    __toString(Str, Radix, false, false);
  }

  
  /// Considers the APInt to be signed and converts it into a string in the
  /// radix given. The radix can be 2, 8, 10, 16, or 36.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::toStringSigned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1445,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1440,
   FQN="llvm::APInt::toStringSigned", NM="_ZNK4llvm5APInt14toStringSignedERNS_15SmallVectorImplIcEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt14toStringSignedERNS_15SmallVectorImplIcEEj")
  //</editor-fold>
  public void toStringSigned(final SmallString/*&*/ Str) /*const*/ {
    toStringSigned(Str, 10);
  }
  public void toStringSigned(final SmallString/*&*/ Str, /*uint*/int Radix/*= 10*/) /*const*/ {
    __toString(Str, Radix, true, false);
  }

  
  /// \brief Return the APInt as a std::string.
  ///
  /// Note that this is an inefficient method.  It is better to pass in a
  /// SmallVector/SmallString to the methods above to avoid thrashing the heap
  /// for the string.
  
  /// Returns the APInt as a std::string. Note that this is an inefficient method.
  /// It is better to pass in a SmallVector/SmallString to the methods above.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::toString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2268,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2264,
   FQN="llvm::APInt::toString", NM="_ZNK4llvm5APInt8toStringEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt8toStringEjb")
  //</editor-fold>
  public std.string __toString() /*const*/ {
    return __toString(10, true);
  }
  public std.string __toString(/*uint*/int Radix/*= 10*/) /*const*/ {
    return __toString(Radix, true);
  }
  public std.string __toString(/*uint*/int Radix/*= 10*/, boolean Signed/*= true*/) /*const*/ {
    SmallString/*40*/ S/*J*/= new SmallString/*40*/(40);
    __toString(S, Radix, Signed, /* formatAsCLiteral = */ false);
    return S.str().$string();
  }

  
  /// \returns a byte-swapped representation of this APInt Value.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::byteSwap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 766,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 790,
   FQN="llvm::APInt::byteSwap", NM="_ZNK4llvm5APInt8byteSwapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt8byteSwapEv")
  //</editor-fold>
  public APInt byteSwap() /*const*//* __attribute__((warn_unused_result))*/ {
    assert ($greatereq_uint(BitWidth, 16) && $rem_uint(BitWidth, 16) == 0) : "Cannot byteswap!";
    if (BitWidth == 16) {
      return new APInt(BitWidth, $ushort2ulong(ByteSwap_16(((/*uint16_t*/char)($ulong2ushort(this.VAL))))));
    }
    if (BitWidth == 32) {
      return new APInt(BitWidth, $uint2ulong(ByteSwap_32(((/*uint*/int)($ulong2uint(this.VAL))))));
    }
    if (BitWidth == 48) {
      /*uint*/int Tmp1 = ((/*uint*/int)($ulong2uint(this.VAL >>> 16)));
      Tmp1 = ByteSwap_32(Tmp1);
      /*uint16_t*/char Tmp2 = ((/*uint16_t*/char)($ulong2ushort(this.VAL)));
      Tmp2 = ByteSwap_16(Tmp2);
      return new APInt(BitWidth, (((long/*uint64_t*/)($ushort2ulong(Tmp2))) << 32) | $uint2ullong(Tmp1));
    }
    if (BitWidth == 64) {
      return new APInt(BitWidth, ByteSwap_64(this.VAL));
    }
    
    APInt Result/*J*/= new APInt(getNumWords() * APINT_BITS_PER_WORD, 0);
    for (/*uint*/int I = 0, N = getNumWords(); I != N; ++I)  {
      Result.pVal.$set(I, ByteSwap_64(this.pVal.$at(N - I - 1)));
    }
    if (Result.BitWidth != BitWidth) {
      lshrNear(Result.pVal, Result.pVal, getNumWords(), 
          Result.BitWidth - BitWidth);
      Result.BitWidth = BitWidth;
    }
    return Result;
  }


  /// \returns the value with the bit representation reversed of this APInt
  /// Value.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::reverseBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 793,
   FQN="llvm::APInt::reverseBits", NM="_ZNK4llvm5APInt11reverseBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt11reverseBitsEv")
  //</editor-fold>
  public APInt reverseBits() /*const*//* __attribute__((warn_unused_result))*/ {
    throw new UnsupportedOperationException("EmptyBody");
//    switch (BitWidth) {
//     case 64:
//      return new APInt(BitWidth, llvm.<long/*uint64_t*/>reverseBits(this.VAL));
//     case 32:
//      return new APInt(BitWidth, $uint2ulong(llvm.</*uint32_t*/int>reverseBits($ulong2uint(this.VAL))));
//     case 16:
//      return new APInt(BitWidth, $ushort2ulong(llvm.</*uint16_t*/char>reverseBits($ulong2ushort(this.VAL))));
//     case 8:
//      return new APInt(BitWidth, $uchar2ulong(llvm.<byte/*uint8_t*/>reverseBits($ulong2uchar(this.VAL))));
//     default:
//      break;
//    }
//    
//    APInt Val/*J*/= new APInt(/*Deref*/this);
//    APInt Reversed/*J*/= new APInt(/*Deref*/this);
//    int S = BitWidth - 1;
//    
//    /*const*/ APInt One/*J*/= new APInt(BitWidth, 1);
//    
//    for ((Val.$assignMove(Val.lshr(1))); Val.$noteq(0); (Val.$assignMove(Val.lshr(1)))) {
//      Reversed.$lshiftassign(1);
//      Reversed.$orassign((Val.$bitand(One)));
//      --S;
//    }
//    
//    Reversed.$lshiftassign(S);
//    return Reversed;
  }

    
  /// \brief Converts this APInt to a double value.
  
  /// This function converts this APInt to a double.
  /// The layout for double is as following (IEEE Standard 754):
  ///  --------------------------------------
  /// |  Sign    Exponent    Fraction    Bias |
  /// |-------------------------------------- |
  /// |  1[63]   11[62-52]   52[51-00]   1023 |
  ///  --------------------------------------
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::roundToDouble">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 877,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 871,
   FQN="llvm::APInt::roundToDouble", NM="_ZNK4llvm5APInt13roundToDoubleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt13roundToDoubleEb")
  //</editor-fold>
  public double roundToDouble(boolean isSigned) /*const*/ {
    
    // Handle the simple case where the value is contained in one uint64_t.
    // It is wrong to optimize getWord(0) to VAL; there might be more than one word.
    if (isSingleWord() || $lesseq_uint_int(getActiveBits(), APINT_BITS_PER_WORD)) {
      if (isSigned) {
        long/*int64_t*/ sext = SignExtend64(getWord(0), BitWidth);
        return ((double)(sext));
      } else {
        return ((double)(getWord(0)));
      }
    }

    // Determine if the value is negative.
    boolean isNeg = isSigned ? (/*Deref*/this).$at(BitWidth - 1) : false;

    // Construct the absolute value if we're negative.
    APInt Tmp/*J*/= isNeg ? (/*Deref*/this).$sub() : new APInt((/*Deref*/this));

    // Figure out how many bits we're using.
    /*uint*/int n = Tmp.getActiveBits();

    // The exponent (without bias normalization) is just the number of bits
    // we are using. Note that the sign bit is gone since we constructed the
    // absolute value.
    long/*uint64_t*/ exp = $uint2ulong(n);

    // Return infinity for exponent overflow
    if ($greater_ulong_ullong(exp, 1023)) {
      if (!isSigned || !isNeg) {
        return std.numeric_limitsDouble.infinity();
      } else {
        return -std.numeric_limitsDouble.infinity();
      }
    }
    exp += 1023; // Increment for 1023 bias

    // Number of bits in mantissa is 52. To obtain the mantissa value, we must
    // extract the high 52 bits from the correct words in pVal.
    long/*uint64_t*/ mantissa;
    /*uint*/int hiWord = whichWord(n - 1);
    if (hiWord == 0) {
      mantissa = Tmp.pVal.$at(0);
      if ($greater_uint(n, 52)) {
        mantissa >>>= n - 52; // shift down, we want the top 52 bits.
      }
    } else {
      assert ($greater_uint(hiWord, 0)) : "huh?";
      long/*uint64_t*/ hibits = Tmp.pVal.$at(hiWord) << (52 - $rem_uint_int(n, APINT_BITS_PER_WORD));
      long/*uint64_t*/ lobits = Tmp.pVal.$at(hiWord - 1) >>> (11 + $rem_uint_int(n, APINT_BITS_PER_WORD));
      mantissa = hibits | lobits;
    }

    // The leading bit of mantissa is implicit, so get rid of it.
    long/*uint64_t*/ sign = isNeg ? (1L/*ULL*/ << (APINT_BITS_PER_WORD - 1)) : 0;
    //<editor-fold defaultstate="collapsed" desc="">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 929,
     FQN="", NM="_ZNK4llvm5APInt13roundToDoubleEb_Unnamed_union",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt13roundToDoubleEb_Unnamed_union")
    //</editor-fold>
     class/*union*/ Unnamed_union {
      public double D;
      public long/*uint64_t*/ I;
      //<editor-fold defaultstate="collapsed" desc="llvm::APInt::roundToDouble(bool)::(anonymous union)::">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 929,
       FQN="llvm::APInt::roundToDouble(bool)::(anonymous union)::", NM="_ZZNK4llvm5APInt13roundToDoubleEbEN3$_0C1Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZZNK4llvm5APInt13roundToDoubleEbEN3$_0C1Ev")
      //</editor-fold>
      public /*inline*/ Unnamed_union() {
      }

      
      @Override public String toString() {
        return "" + "D=" + D // NOI18N
                  + ", I=" + I; // NOI18N
      }
    }Unnamed_union T/*J*/= new Unnamed_union();
    T.I = sign | (exp << 52) | mantissa;
    return T.D;
  }

  
  /// \brief Converts this unsigned APInt to a double value.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::roundToDouble">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1467,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1458,
   FQN="llvm::APInt::roundToDouble", NM="_ZNK4llvm5APInt13roundToDoubleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt13roundToDoubleEv")
  //</editor-fold>
  public double roundToDouble() /*const*/ {
    return roundToDouble(false);
  }

  
  /// \brief Converts this signed APInt to a double value.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::signedRoundToDouble">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1470,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1461,
   FQN="llvm::APInt::signedRoundToDouble", NM="_ZNK4llvm5APInt19signedRoundToDoubleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt19signedRoundToDoubleEv")
  //</editor-fold>
  public double signedRoundToDouble() /*const*/ {
    return roundToDouble(true);
  }

  
  /// \brief Converts APInt bits to a double
  ///
  /// The conversion does not do a translation from integer to double, it just
  /// re-interprets the bits as a double. Note that it is valid to do this on
  /// any bit width. Exactly 64 bits will be translated.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::bitsToDouble">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1477,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1468,
   FQN="llvm::APInt::bitsToDouble", NM="_ZNK4llvm5APInt12bitsToDoubleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt12bitsToDoubleEv")
  //</editor-fold>
  public double bitsToDouble() /*const*/ {
//    //<editor-fold defaultstate="collapsed" desc="">
//    @Converted(kind = Converted.Kind.AUTO,
//     source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1478,
//     FQN="", NM="_ZNK4llvm5APInt12bitsToDoubleEv_Unnamed_union",
//     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt12bitsToDoubleEv_Unnamed_union")
//    //</editor-fold>
//     class/*union*/ Unnamed_union {
//      public long/*uint64_t*/ I;
//      public double D;
//      //<editor-fold defaultstate="collapsed" desc="llvm::APInt::bitsToDouble()::(anonymous union)::">
//      @Converted(kind = Converted.Kind.AUTO,
//       source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1478,
//       FQN="llvm::APInt::bitsToDouble()::(anonymous union)::", NM="_ZZNK4llvm5APInt12bitsToDoubleEvENUt_C1Ev",
//       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZZNK4llvm5APInt12bitsToDoubleEvENUt_C1Ev")
//      //</editor-fold>
//      public /*inline*/ Unnamed_union() {
//      }
//
//      
//      @Override public String toString() {
//        return "" + "I=" + I // NOI18N
//                  + ", D=" + D; // NOI18N
//      }
//    }Unnamed_union T/*J*/= new Unnamed_union();
//    T.I = (isSingleWord() ? this.VAL : this.pVal.$at(0));
    long/*uint64_t*/ I = (isSingleWord() ? this.VAL : this.pVal.$at(0));
    double D = Double.longBitsToDouble(I);
    return D;
  }

  
  /// \brief Converts APInt bits to a double
  ///
  /// The conversion does not do a translation from integer to float, it just
  /// re-interprets the bits as a float. Note that it is valid to do this on
  /// any bit width. Exactly 32 bits will be translated.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::bitsToFloat">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1491,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1482,
   FQN="llvm::APInt::bitsToFloat", NM="_ZNK4llvm5APInt11bitsToFloatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt11bitsToFloatEv")
  //</editor-fold>
  public float bitsToFloat() /*const*/ {
//    //<editor-fold defaultstate="collapsed" desc="">
//    @Converted(kind = Converted.Kind.AUTO,
//     source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1492,
//     FQN="", NM="_ZNK4llvm5APInt11bitsToFloatEv_Unnamed_union",
//     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt11bitsToFloatEv_Unnamed_union")
//    //</editor-fold>
//     class/*union*/ Unnamed_union {
//      public /*uint*/int I;
//      public float F;
//      //<editor-fold defaultstate="collapsed" desc="llvm::APInt::bitsToFloat()::(anonymous union)::">
//      @Converted(kind = Converted.Kind.AUTO,
//       source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1492,
//       FQN="llvm::APInt::bitsToFloat()::(anonymous union)::", NM="_ZZNK4llvm5APInt11bitsToFloatEvENUt_C1Ev",
//       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZZNK4llvm5APInt11bitsToFloatEvENUt_C1Ev")
//      //</editor-fold>
//      public /*inline*/ Unnamed_union() {
//      }
//
//      
//      @Override public String toString() {
//        return "" + "I=" + I // NOI18N
//                  + ", F=" + F; // NOI18N
//      }
//    }Unnamed_union T/*J*/= new Unnamed_union();
//    T.I = ((/*uint*/int)($ulong2uint((isSingleWord() ? this.VAL : this.pVal.$at(0)))));
    /*uint*/int I = ((/*uint*/int)($ulong2uint((isSingleWord() ? this.VAL : this.pVal.$at(0)))));
    float F = Float.intBitsToFloat(I);
    return F;
  }

  
  /// \brief Converts a double to APInt bits.
  ///
  /// The conversion does not do a translation from double to integer, it just
  /// re-interprets the bits of the double.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::doubleToBits">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*sizeof(union)*/,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1504,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1495,
   FQN="llvm::APInt::doubleToBits", NM="_ZN4llvm5APInt12doubleToBitsEd",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt12doubleToBitsEd")
  //</editor-fold>
  public static APInt doubleToBits(double V)/* __attribute__((warn_unused_result))*/ {
//    //<editor-fold defaultstate="collapsed" desc="">
//    @Converted(kind = Converted.Kind.AUTO,
//     source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1505,
//     FQN="", NM="_ZN4llvm5APInt12doubleToBitsEd_Unnamed_union",
//     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt12doubleToBitsEd_Unnamed_union")
//    //</editor-fold>
//     class/*union*/ Unnamed_union {
//      public long/*uint64_t*/ I;
//      public double D;
//      //<editor-fold defaultstate="collapsed" desc="llvm::APInt::doubleToBits(double)::(anonymous union)::">
//      @Converted(kind = Converted.Kind.AUTO,
//       source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1505,
//       FQN="llvm::APInt::doubleToBits(double)::(anonymous union)::", NM="_ZZN4llvm5APInt12doubleToBitsEdENUt_C1Ev",
//       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZZN4llvm5APInt12doubleToBitsEdENUt_C1Ev")
//      //</editor-fold>
//      public /*inline*/ Unnamed_union() {
//      }
//
//      
//      @Override public String toString() {
//        return "" + "I=" + I // NOI18N
//                  + ", D=" + D; // NOI18N
//      }
//    }Unnamed_union T/*J*/= new Unnamed_union();
//    T.D = V;
    // JAVA: emulate union where double is written and long is read
    long/*uint64_t*/ I = Double.doubleToRawLongBits(V);
    return new APInt(sizeof(double.class) * CHAR_BIT, I);
  }

  
  /// \brief Converts a float to APInt bits.
  ///
  /// The conversion does not do a translation from float to integer, it just
  /// re-interprets the bits of the float.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::floatToBits">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1517,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1508,
   FQN="llvm::APInt::floatToBits", NM="_ZN4llvm5APInt11floatToBitsEf",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt11floatToBitsEf")
  //</editor-fold>
  public static APInt floatToBits(float V)/* __attribute__((warn_unused_result))*/ {
//    //<editor-fold defaultstate="collapsed" desc="">
//    @Converted(kind = Converted.Kind.AUTO,
//     source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1518,
//     FQN="", NM="_ZN4llvm5APInt11floatToBitsEf_Unnamed_union",
//     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt11floatToBitsEf_Unnamed_union")
//    //</editor-fold>
//     class/*union*/ Unnamed_union {
//      public /*uint*/int I;
//      public float F;
//      //<editor-fold defaultstate="collapsed" desc="llvm::APInt::floatToBits(float)::(anonymous union)::">
//      @Converted(kind = Converted.Kind.AUTO,
//       source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1518,
//       FQN="llvm::APInt::floatToBits(float)::(anonymous union)::", NM="_ZZN4llvm5APInt11floatToBitsEfENUt_C1Ev",
//       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZZN4llvm5APInt11floatToBitsEfENUt_C1Ev")
//      //</editor-fold>
//      public /*inline*/ Unnamed_union() {
//      }
//
//      
//      @Override public String toString() {
//        return "" + "I=" + I // NOI18N
//                  + ", F=" + F; // NOI18N
//      }
//    }Unnamed_union T/*J*/= new Unnamed_union();
//    T.F = V;
    // JAVA: emulate union where float is written and uint is read
    /*uint*/int I = Float.floatToRawIntBits(V);
    return new APInt(sizeof(float.class) * CHAR_BIT, $uint2ulong(I));
  }

  
  /// @}
  /// \name Mathematics Operations
  /// @{
  
  /// \returns the floor log base 2 of this APInt.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::logBase2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1531,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1522,
   FQN="llvm::APInt::logBase2", NM="_ZNK4llvm5APInt8logBase2Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt8logBase2Ev")
  //</editor-fold>
  public /*uint*/int logBase2() /*const*/ {
    return BitWidth - 1 - countLeadingZeros();
  }

  
  /// \returns the ceil log base 2 of this APInt.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::ceilLogBase2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1534,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1525,
   FQN="llvm::APInt::ceilLogBase2", NM="_ZNK4llvm5APInt12ceilLogBase2Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt12ceilLogBase2Ev")
  //</editor-fold>
  public /*uint*/int ceilLogBase2() /*const*/ {
    return BitWidth - (/*Deref*/this.$sub(1)).countLeadingZeros();
  }
  
  
  /// \returns the nearest log base 2 of this APInt. Ties round up.
  ///
  /// NOTE: When we have a BitWidth of 1, we define:
  /// 
  ///   log2(0) = UINT32_MAX
  ///   log2(1) = 0
  ///
  /// to get around any mathematical concerns resulting from
  /// referencing 2 in a space where 2 does no exist.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::nearestLogBase2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1547,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1538,
   FQN="llvm::APInt::nearestLogBase2", NM="_ZNK4llvm5APInt15nearestLogBase2Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt15nearestLogBase2Ev")
  //</editor-fold>
  public /*uint*/int nearestLogBase2() /*const*/ {
    // Special case when we have a bitwidth of 1. If VAL is 1, then we
    // get 0. If VAL is 0, we get UINT64_MAX which gets truncated to
    // UINT32_MAX.
    if (BitWidth == 1) {
      return (/*uint*/int)(VAL - 1L);
    }

    // Handle the zero case.
    if (!getBoolValue()) {
      return UINT32_MAX;
    }

    // The non-zero case is handled by computing:
    //
    //   nearestLogBase2(x) = logBase2(x) + x[logBase2(x)-1].
    //
    // where x[i] is referring to the value of the ith bit of x.
    /*uint*/int lg = logBase2();
    return lg + ((/*uint*/int)(((/*Deref*/this).$at(lg - 1) ? 1 : 0)));
  }
  
  
  /// \returns the log base 2 of this APInt if its an exact power of two, -1
  /// otherwise
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::exactLogBase2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1569,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1560,
   FQN="llvm::APInt::exactLogBase2", NM="_ZNK4llvm5APInt13exactLogBase2Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt13exactLogBase2Ev")
  //</editor-fold>
  public int/*int32_t*/ exactLogBase2() /*const*/ {
    if (!isPowerOf2()) {
      return -1;
    }
    return logBase2();
  }

  
  /// \brief Compute the square root
  
  // Square Root - this method computes and returns the square root of "this".
  // Three mechanisms are used for computation. For small values (<= 5 bits),
  // a table lookup is done. This gets some performance for common cases. For
  // values using less than 52 bits, the value is converted to double and then
  // the libc sqrt function is called. The result is rounded and then converted
  // back to a uint64_t which is then used to construct the result. Finally,
  // the Babylonian method for computing square roots is used.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::sqrt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1302,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1296,
   FQN="llvm::APInt::sqrt", NM="_ZNK4llvm5APInt4sqrtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt4sqrtEv")
  //</editor-fold>
  public APInt sqrt() /*const*//* __attribute__((warn_unused_result))*/ {
    
    // Determine the magnitude of the value.
    /*uint*/int magnitude = getActiveBits();
    
    // Use a fast table for some small values. This also gets rid of some
    // rounding errors in libc sqrt for small values.
    if ($lesseq_uint(magnitude, 5)) {
      final/*static*/ /*const*/byte/*uint8_t*/ results[/*32*/] = sqrt$$.results;
      return new APInt(BitWidth, $uchar2ulong(results[(int)(isSingleWord() ? this.VAL : this.pVal.$at(0))]));
    }
    
    // If the magnitude of the value fits in less than 52 bits (the precision of
    // an IEEE double precision floating point value), then we can use the
    // libc sqrt function which will probably use a hardware sqrt computation.
    // This should be faster than the algorithm below.
    if ($less_uint(magnitude, 52)) {
      return new APInt(BitWidth, 
          ((long/*uint64_t*/)(/*::*/std.round(/*::*/std.sqrt(((double)(isSingleWord() ? this.VAL : this.pVal.$at(0))))))));
    }
    
    // Okay, all the short cuts are exhausted. We must compute it. The following
    // is a classical Babylonian method for computing the square root. This code
    // was adapted to APInt from a wikipedia article on such computations.
    // See http://www.wikipedia.org/ and go to the page named
    // Calculate_an_integer_square_root.
    /*uint*/int nbits = BitWidth, i = 4;
    APInt testy/*J*/= new APInt(BitWidth, 16);
    APInt x_old/*J*/= new APInt(BitWidth, 1);
    APInt x_new/*J*/= new APInt(BitWidth, 0);
    APInt two/*J*/= new APInt(BitWidth, 2);
    
    // Select a good starting value using binary logarithms.
    for (;; i += 2 , testy.$assignMove(testy.shl(2)))  {
      if ($greatereq_uint(i, nbits) || this.ule(testy)) {
        x_old.$assignMove(x_old.shl($div_uint(i, 2)));
        break;
      }
    }
    
    // Use the Babylonian method to arrive at the integer square root:
    for (;;) {
      x_new.$assignMove((this.udiv(x_old).$add(x_old)).udiv(two));
      if (x_old.ule(x_new)) {
        break;
      }
      x_old.$assign(x_new);
    }
    
    // Make sure we return the closest approximation
    // NOTE: The rounding calculation below is correct. It will produce an
    // off-by-one discrepancy with results from pari/gp. That discrepancy has been
    // determined to be a rounding issue with pari/gp as it begins to use a
    // floating point representation after 192 bits. There are no discrepancies
    // between this algorithm and pari/gp for bit widths < 192 bits.
    APInt square/*J*/= x_old.$star(x_old);
    APInt nextSquare/*J*/= (x_old.$add(1)).$star((x_old.$add(1)));
    if (this.ult(square)) {
      return x_old;
    }
    assert (this.ule(nextSquare)) : "Error in APInt::sqrt computation";
    APInt midpoint/*J*/= (nextSquare.$sub(square)).udiv(two);
    APInt offset/*J*/= $Deref(this.$sub(square));
    if (offset.ult(midpoint)) {
      return x_old;
    }
    return x_old.$add(1);
  }
  private static final class sqrt$$ {
    static final/*static*/ /*const*/byte/*uint8_t*/ results[/*32*/] = new /*const*/byte/*uint8_t*/ [/*32*/] {
  /*     0 */ 0, 
  /*  1- 2 */ 1, 1, 
  /*  3- 6 */ 2, 2, 2, 2, 
  /*  7-12 */ 3, 3, 3, 3, 3, 3, 
  /* 13-20 */ 4, 4, 4, 4, 4, 4, 4, 4, 
  /* 21-30 */ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 
  /*    31 */ 6
  };
  }
  
  
  /// \brief Get the absolute value;
  ///
  /// If *this is < 0 then return -(*this), otherwise *this;
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::abs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1581,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1572,
   FQN="llvm::APInt::abs", NM="_ZNK4llvm5APInt3absEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt3absEv")
  //</editor-fold>
  public APInt abs() /*const*//* __attribute__((warn_unused_result))*/ {
    if (isNegative()) {
      return (/*Deref*/this).$sub();
    }
    return new APInt(/*Deref*/this);
  }

  
  /// \returns the multiplicative inverse for a given modulo.
  
  /// Computes the multiplicative inverse of this APInt for a given modulo. The
  /// iterative extended Euclidean algorithm is used to solve for this value,
  /// however we simplify it to speed up calculating only the inverse, and take
  /// advantage of div+rem calculations. We also use some tricks to avoid copying
  /// (potentially large) APInts around.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::multiplicativeInverse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1380,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1374,
   FQN="llvm::APInt::multiplicativeInverse", NM="_ZNK4llvm5APInt21multiplicativeInverseERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt21multiplicativeInverseERKS0_")
  //</editor-fold>
  public APInt multiplicativeInverse(final /*const*/ APInt /*&*/ modulo) /*const*/ {
    assert (ult(modulo)) : "This APInt must be smaller than the modulo";
    
    // Using the properties listed at the following web page (accessed 06/21/08):
    //   http://www.numbertheory.org/php/euclid.html
    // (especially the properties numbered 3, 4 and 9) it can be proved that
    // BitWidth bits suffice for all the computations in the algorithm implemented
    // below. More precisely, this number of bits suffice if the multiplicative
    // inverse exists, but may not suffice for the general extended Euclidean
    // algorithm.
    APInt r[/*2*/] = new APInt [/*2*/] {modulo, /*Deref*/this};
    APInt t[/*2*/] = new APInt [/*2*/] {new APInt(BitWidth, 0), new APInt(BitWidth, 1)};
    APInt q/*J*/= new APInt(BitWidth, 0);
    
    /*uint*/int i;
    for (i = 0; r[i ^ 1].$noteq(0); i ^= 1) {
      // An overview of the math without the confusing bit-flipping:
      // q = r[i-2] / r[i-1]
      // r[i] = r[i-2] % r[i-1]
      // t[i] = t[i-2] - t[i-1] * q
      udivrem(r[i], r[i ^ 1], q, r[i]);
      t[i].$minusassign(t[i ^ 1].$star(q));
    }
    
    // If this APInt and the modulo are not coprime, there is no multiplicative
    // inverse, so return 0. We check this by looking at the next-to-last
    // remainder, which is the gcd(*this,modulo) as calculated by the Euclidean
    // algorithm.
    if (r[i].$noteq(1)) {
      return new APInt(BitWidth, 0);
    }
    
    // The next-to-last t is the multiplicative inverse.  However, we are
    // interested in a positive inverse. Calcuate a positive one from a negative
    // one if necessary. A simple addition of the modulo suffices because
    // abs(t[i]) is known to be less than *this/2 (see the link above).
    return t[i].isNegative() ? t[i].$add(modulo) : new APInt(t[i]);
  }

  
  /// @}
  /// \name Support for division by constant
  /// @{
  
  /// Calculate the magic number for signed division by a constant.
  
  /// Magic data for optimising signed division by a constant.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::ms">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1732,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1586,
   FQN="llvm::APInt::ms", NM="_ZN4llvm5APInt2msE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt2msE")
  //</editor-fold>
  public static class/*struct*/ ms implements Destructors.ClassWithDestructor {
    public APInt m; ///< magic number
    public /*uint*/int s; ///< shift amount
    //<editor-fold defaultstate="collapsed" desc="llvm::APInt::ms::ms">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1732,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1723,
     FQN="llvm::APInt::ms::ms", NM="_ZN4llvm5APInt2msC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt2msC1EOS1_")
    //</editor-fold>
    public /*inline*/ ms(JD$Move _dparam, final ms /*&&*/$Prm0) {
      // : m(static_cast<ms &&>().m), s(static_cast<ms &&>().s) 
      //START JInit
      this.m = new APInt(JD$Move.INSTANCE, $Prm0.m);
      this.s = $Prm0.s;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::APInt::ms::~ms">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1732,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1723,
     FQN="llvm::APInt::ms::~ms", NM="_ZN4llvm5APInt2msD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt2msD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      m.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::APInt::ms::ms">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1732,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1723,
     FQN="llvm::APInt::ms::ms", NM="_ZN4llvm5APInt2msC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt2msC1Ev")
    //</editor-fold>
    public /*inline*/ ms() {
      // : m() 
      //START JInit
      this.m = new APInt();
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "m=" + m // NOI18N
                + ", s=" + s; // NOI18N
    }
    
    //<editor-fold defaultstate="collapsed" desc="llvm::APInt::ms::ms">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1573,
     FQN = "llvm::APInt::ms", NM = "_ZN4llvm5APInt2msE",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -filter=llvm::APInt::ms::ms",
     notes = Converted.Notes.FAILED)
    //</editor-fold>
    public /*inline*/ ms(/*const*/ms /*&*/ $Prm0) {
      /* : m(.m), s(.s)*/ 
      //START JInit
      this.m = new APInt($Prm0.m);
      this.s = $Prm0.s;
      //END JInit
    }

  };
  
  /// Calculate the magic numbers required to implement a signed integer division
  /// by a constant as a sequence of multiplies, adds and shifts.  Requires that
  /// the divisor not be 0, 1, or -1.  Taken from "Hacker's Delight", Henry S.
  /// Warren, Jr., chapter 10.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::magic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1423,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1417,
   FQN="llvm::APInt::magic", NM="_ZNK4llvm5APInt5magicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt5magicEv")
  //</editor-fold>
  public APInt.ms magic() /*const*/ {
     ms mag = null;
    try {
      final /*const*/ APInt /*&*/ d = /*Deref*/this;
      /*uint*/int p;
      APInt ad/*J*/= new APInt(), anc/*J*/= new APInt(), delta/*J*/= new APInt(), q1/*J*/= new APInt(), r1/*J*/= new APInt(), q2/*J*/= new APInt(), r2/*J*/= new APInt(), t/*J*/= new APInt();
      APInt signedMin = APInt.getSignedMinValue(d.getBitWidth());
      mag/*J*/= new  ms();
      
      ad.$assignMove(d.abs());
      t.$assignMove(signedMin.$add((d.lshr(d.getBitWidth() - 1))));
      anc.$assignMove(t.$sub(1).$sub(t.urem(ad))); // absolute value of nc
      p = d.getBitWidth() - 1; // initialize p
      q1.$assignMove(signedMin.udiv(anc)); // initialize q1 = 2p/abs(nc)
      r1.$assignMove(signedMin.$sub(q1.$star(anc))); // initialize r1 = rem(2p,abs(nc))
      q2.$assignMove(signedMin.udiv(ad)); // initialize q2 = 2p/abs(d)
      r2.$assignMove(signedMin.$sub(q2.$star(ad))); // initialize r2 = rem(2p,abs(d))
      do {
        p = p + 1;
        q1.$assignMove(q1.$out(1)); // update q1 = 2p/abs(nc)
        r1.$assignMove(r1.$out(1)); // update r1 = rem(2p/abs(nc))
        if (r1.uge(anc)) { // must be unsigned comparison
          q1.$assignMove(q1.$add(1));
          r1.$assignMove(r1.$sub(anc));
        }
        q2.$assignMove(q2.$out(1)); // update q2 = 2p/abs(d)
        r2.$assignMove(r2.$out(1)); // update r2 = rem(2p/abs(d))
        if (r2.uge(ad)) { // must be unsigned comparison
          q2.$assignMove(q2.$add(1));
          r2.$assignMove(r2.$sub(ad));
        }
        delta.$assignMove(ad.$sub(r2));
      } while (q1.ult(delta) || (q1.$eq(delta) && r1.$eq(0)));
      
      mag.m.$assignMove(q2.$add(1));
      if (d.isNegative()) {
        mag.m.$assignMove(mag.m.$sub()); // resulting magic number
      }
      mag.s = p - d.getBitWidth(); // resulting shift
      return new APInt.ms(JD$Move.INSTANCE, mag);
    } finally {
      if (mag != null) { mag.$destroy(); }
    }
  }

  
  /// Calculate the magic number for unsigned division by a constant.
  
  /// Magic data for optimising unsigned division by a constant.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::mu">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1738,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1590,
   FQN="llvm::APInt::mu", NM="_ZN4llvm5APInt2muE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt2muE")
  //</editor-fold>
  public static class/*struct*/ mu implements Destructors.ClassWithDestructor {
    public APInt m; ///< magic number
    public boolean a; ///< add indicator
    public /*uint*/int s; ///< shift amount
    //<editor-fold defaultstate="collapsed" desc="llvm::APInt::mu::mu">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1738,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1729,
     FQN="llvm::APInt::mu::mu", NM="_ZN4llvm5APInt2muC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt2muC1EOS1_")
    //</editor-fold>
    public /*inline*/ mu(JD$Move _dparam, final mu /*&&*/$Prm0) {
      // : m(static_cast<mu &&>().m), a(static_cast<mu &&>().a), s(static_cast<mu &&>().s) 
      //START JInit
      this.m = new APInt(JD$Move.INSTANCE, $Prm0.m);
      this.a = $Prm0.a;
      this.s = $Prm0.s;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::APInt::mu::~mu">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1738,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1729,
     FQN="llvm::APInt::mu::~mu", NM="_ZN4llvm5APInt2muD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt2muD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      m.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::APInt::mu::mu">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1738,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1729,
     FQN="llvm::APInt::mu::mu", NM="_ZN4llvm5APInt2muC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt2muC1Ev")
    //</editor-fold>
    public /*inline*/ mu() {
      // : m() 
      //START JInit
      this.m = new APInt();
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "m=" + m // NOI18N
                + ", a=" + a // NOI18N
                + ", s=" + s; // NOI18N
    }
    
    //<editor-fold defaultstate="collapsed" desc="llvm::APInt::mu::mu">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1577,
     FQN = "llvm::APInt::mu", NM = "_ZN4llvm5APInt2muE",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -filter=llvm::APInt::mu::mu",
     notes = Converted.Notes.FAILED)
    //</editor-fold>
    public /*inline*/ mu(/*const*/mu /*&*/ $Prm0) {
      /* : m(.m), a(.a), s(.s)*/ 
      //START JInit
      this.m = new APInt($Prm0.m);
      this.a = $Prm0.a;
      this.s = $Prm0.s;
      //END JInit
    }

  };
  
  /// Calculate the magic numbers required to implement an unsigned integer
  /// division by a constant as a sequence of multiplies, adds and shifts.
  /// Requires that the divisor not be 0.  Taken from "Hacker's Delight", Henry
  /// S. Warren, Jr., chapter 10.
  /// LeadingZeros can be used to simplify the calculation if the upper bits
  /// of the divided value are known zero.
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::magicu">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1467,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1461,
   FQN="llvm::APInt::magicu", NM="_ZNK4llvm5APInt6magicuEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt6magicuEj")
  //</editor-fold>
  public APInt.mu magicu() /*const*/ {
    return magicu(0);
  }
  public APInt.mu magicu(/*uint*/int LeadingZeros/*= 0*/) /*const*/ {
     mu magu = null;
    try {
      final /*const*/ APInt /*&*/ d = /*Deref*/this;
      /*uint*/int p;
      APInt nc/*J*/= new APInt(), delta/*J*/= new APInt(), q1/*J*/= new APInt(), r1/*J*/= new APInt(), q2/*J*/= new APInt(), r2/*J*/= new APInt();
      magu/*J*/= new  mu();
      magu.a = false; // initialize "add" indicator
      APInt allOnes = APInt.getAllOnesValue(d.getBitWidth()).lshr(LeadingZeros);
      APInt signedMin = APInt.getSignedMinValue(d.getBitWidth());
      APInt signedMax = APInt.getSignedMaxValue(d.getBitWidth());
      
      nc.$assignMove(allOnes.$sub((allOnes.$sub(d)).urem(d)));
      p = d.getBitWidth() - 1; // initialize p
      q1.$assignMove(signedMin.udiv(nc)); // initialize q1 = 2p/nc
      r1.$assignMove(signedMin.$sub(q1.$star(nc))); // initialize r1 = rem(2p,nc)
      q2.$assignMove(signedMax.udiv(d)); // initialize q2 = (2p-1)/d
      r2.$assignMove(signedMax.$sub(q2.$star(d))); // initialize r2 = rem((2p-1),d)
      do {
        p = p + 1;
        if (r1.uge(nc.$sub(r1))) {
          q1.$assignMove(q1.$add(q1).$add(1)); // update q1
          r1.$assignMove(r1.$add(r1).$sub(nc)); // update r1
        } else {
          q1.$assignMove(q1.$add(q1)); // update q1
          r1.$assignMove(r1.$add(r1)); // update r1
        }
        if ((r2.$add(1)).uge(d.$sub(r2))) {
          if (q2.uge(signedMax)) {
            magu.a = true;
          }
          q2.$assignMove(q2.$add(q2).$add(1)); // update q2
          r2.$assignMove(r2.$add(r2).$add(1).$sub(d)); // update r2
        } else {
          if (q2.uge(signedMin)) {
            magu.a = true;
          }
          q2.$assignMove(q2.$add(q2)); // update q2
          r2.$assignMove(r2.$add(r2).$add(1)); // update r2
        }
        delta.$assignMove(d.$sub(1).$sub(r2));
      } while ($less_uint(p, d.getBitWidth() * 2)
         && (q1.ult(delta) || (q1.$eq(delta) && r1.$eq(0))));
      magu.m.$assignMove(q2.$add(1)); // resulting magic number
      magu.s = p - d.getBitWidth(); // resulting shift
      return new APInt.mu(JD$Move.INSTANCE, magu);
    } finally {
      if (magu != null) { magu.$destroy(); }
    }
  }

  
  /// @}
  /// \name Building-block Operations for APInt and APFloat
  /// @{
  
  // These building block operations operate on a representation of arbitrary
  // precision, two's-complement, bignum integer values. They should be
  // sufficient to implement APInt and APFloat bignum requirements. Inputs are
  // generally a pointer to the base of an array of integer parts, representing
  // an unsigned bignum, and a count of how many parts there are.
  
  /// Sets the least significant part of a bignum to the input value, and zeroes
  /// out higher parts.
  
  /* Sets the least significant part of a bignum to the input value, and
  zeroes out higher parts.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2342,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2338,
   FQN="llvm::APInt::tcSet", NM="_ZN4llvm5APInt5tcSetEPyyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt5tcSetEPyyj")
  //</editor-fold>
  public static void tcSet(ulong$ptr/*uint64_t P*/ dst, long/*uint64_t*/ part, /*uint*/int parts) {
    /*uint*/int i;
    assert ($greater_uint(parts, 0));
    
    dst.$set(0, part);
    for (i = 1; $less_uint(i, parts); i++)  {
      dst.$set(i, 0);
    }
  }

  
  /// Assign one bignum to another.
  
  /* Assign one bignum to another.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2355,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2351,
   FQN="llvm::APInt::tcAssign", NM="_ZN4llvm5APInt8tcAssignEPyPKyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt8tcAssignEPyPKyj")
  //</editor-fold>
  public static void tcAssign(ulong$ptr/*uint64_t P*/ dst, /*const*/ulong$ptr/*uint64_t P*/ src, /*uint*/int parts) {
    /*uint*/int i;
    
    for (i = 0; $less_uint(i, parts); i++)  {
      dst.$set(i, src.$at(i));
    }
  }

  
  /// Returns true if a bignum is zero, false otherwise.
  
  /* Returns true if a bignum is zero, false otherwise.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcIsZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2365,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2361,
   FQN="llvm::APInt::tcIsZero", NM="_ZN4llvm5APInt8tcIsZeroEPKyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt8tcIsZeroEPKyj")
  //</editor-fold>
  public static boolean tcIsZero(/*const*/ulong$ptr/*uint64_t P*/ src, /*uint*/int parts) {
    /*uint*/int i;
    
    for (i = 0; $less_uint(i, parts); i++)  {
      if ((src.$at(i) != 0)) {
        return false;
      }
    }
    
    return true;
  }

  
  /// Extract the given bit of a bignum; returns 0 or 1.  Zero-based.
  
  /* Extract the given bit of a bignum; returns 0 or 1.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcExtractBit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2378,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2374,
   FQN="llvm::APInt::tcExtractBit", NM="_ZN4llvm5APInt12tcExtractBitEPKyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt12tcExtractBitEPKyj")
  //</editor-fold>
  public static int tcExtractBit(/*const*/ulong$ptr/*uint64_t P*/ parts, /*uint*/int bit) {
    return (((parts.$at($div_uint(bit, integerPartWidth))
       & ((long/*uint64_t*/)1 << $rem_uint(bit, integerPartWidth))) != 0) ? 1 : 0);
  }

  
  /// Copy the bit vector of width srcBITS from SRC, starting at bit srcLSB, to
  /// DST, of dstCOUNT parts, such that the bit srcLSB becomes the least
  /// significant bit of DST.  All high bits above srcBITS in DST are
  /// zero-filled.
  
  /* Copy the bit vector of width srcBITS from SRC, starting at bit
  srcLSB, to DST, of dstCOUNT parts, such that the bit srcLSB becomes
  the least significant bit of DST.  All high bits above srcBITS in
  DST are zero-filled.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcExtract">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2442,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2438,
   FQN="llvm::APInt::tcExtract", NM="_ZN4llvm5APInt9tcExtractEPyjPKyjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt9tcExtractEPyjPKyjj")
  //</editor-fold>
  public static void tcExtract(ulong$ptr/*uint64_t P*/ dst, /*uint*/int dstCount, /*const*/ulong$ptr/*uint64_t P*/ src, 
           /*uint*/int srcBits, /*uint*/int srcLSB) {
    /*uint*/int firstSrcPart, dstParts, shift, n;
    
    dstParts = $div_uint((srcBits + integerPartWidth - 1), integerPartWidth);
    assert ($lesseq_uint(dstParts, dstCount));
    
    firstSrcPart = $div_uint(srcLSB, integerPartWidth);
    tcAssign(dst, src.$add(firstSrcPart), dstParts);
    
    shift = $rem_uint(srcLSB, integerPartWidth);
    tcShiftRight(dst, dstParts, shift);
    
    /* We now have (dstParts * integerPartWidth - shift) bits from SRC
    in DST.  If this is less that srcBits, append the rest, else
    clear the high bits.  */
    n = dstParts * integerPartWidth - shift;
    if ($less_uint(n, srcBits)) {
      long/*uint64_t*/ mask = lowBitMask(srcBits - n);
      dst.$set$orassign(dstParts - 1, ((src.$at(firstSrcPart + dstParts) & mask)
         << $rem_uint(n, integerPartWidth)));
    } else if ($greater_uint(n, srcBits)) {
      if ((($rem_uint(srcBits, integerPartWidth)) != 0)) {
        dst.$set$andassign(dstParts - 1, lowBitMask($rem_uint(srcBits, integerPartWidth)));
      }
    }
    
    /* Clear high parts.  */
    while ($less_uint(dstParts, dstCount)) {
      dst.$set(dstParts++, 0);
    }
  }

  
  /// Set the given bit of a bignum.  Zero-based.
  
  /* Set the given bit of a bignum. */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcSetBit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2386,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2382,
   FQN="llvm::APInt::tcSetBit", NM="_ZN4llvm5APInt8tcSetBitEPyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt8tcSetBitEPyj")
  //</editor-fold>
  public static void tcSetBit(ulong$ptr/*uint64_t P*/ parts, /*uint*/int bit) {
    parts.$set$orassign($div_uint(bit, integerPartWidth), (long/*uint64_t*/)1 << ($rem_uint(bit, integerPartWidth)));
  }

  
  /// Clear the given bit of a bignum.  Zero-based.
  
  /* Clears the given bit of a bignum. */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcClearBit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2393,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2389,
   FQN="llvm::APInt::tcClearBit", NM="_ZN4llvm5APInt10tcClearBitEPyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt10tcClearBitEPyj")
  //</editor-fold>
  public static void tcClearBit(ulong$ptr/*uint64_t P*/ parts, /*uint*/int bit) {
    parts.$set$andassign($div_uint(bit, integerPartWidth), ~((long/*uint64_t*/)1 << ($rem_uint(bit, integerPartWidth))));
  }

  
  /// Returns the bit number of the least or most significant set bit of a
  /// number.  If the input number has no bits set -1U is returned.
  
  /* Returns the bit number of the least significant set bit of a
  number.  If the input number has no bits set -1U is returned.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcLSB">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2402,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2398,
   FQN="llvm::APInt::tcLSB", NM="_ZN4llvm5APInt5tcLSBEPKyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt5tcLSBEPKyj")
  //</editor-fold>
  public static /*uint*/int tcLSB(/*const*/ulong$ptr/*uint64_t P*/ parts, /*uint*/int n) {
    /*uint*/int i, lsb;
    
    for (i = 0; $less_uint(i, n); i++) {
      if (parts.$at(i) != 0) {
        lsb = partLSB(parts.$at(i));
        
        return lsb + i * integerPartWidth;
      }
    }
    
    return -1/*U*/;
  }

  
  /* Returns the bit number of the most significant set bit of a number.
  If the input number has no bits set -1U is returned.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcMSB">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2420,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2416,
   FQN="llvm::APInt::tcMSB", NM="_ZN4llvm5APInt5tcMSBEPKyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt5tcMSBEPKyj")
  //</editor-fold>
  public static /*uint*/int tcMSB(/*const*/ulong$ptr/*uint64_t P*/ parts, /*uint*/int n) {
    /*uint*/int msb;
    
    do {
      --n;
      if (parts.$at(n) != 0) {
        msb = partMSB(parts.$at(n));
        
        return msb + n * integerPartWidth;
      }
    } while ((n != 0));
    
    return -1/*U*/;
  }

  
  /// Negate a bignum in-place.
  
  /* Negate a bignum in-place.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcNegate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2526,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2522,
   FQN="llvm::APInt::tcNegate", NM="_ZN4llvm5APInt8tcNegateEPyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt8tcNegateEPyj")
  //</editor-fold>
  public static void tcNegate(ulong$ptr/*uint64_t P*/ dst, /*uint*/int parts) {
    tcComplement(dst, parts);
    tcIncrement(dst, parts);
  }

  
  /// DST += RHS + CARRY where CARRY is zero or one.  Returns the carry flag.
  
  /* DST += RHS + C where C is zero or one.  Returns the carry flag.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2476,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2472,
   FQN="llvm::APInt::tcAdd", NM="_ZN4llvm5APInt5tcAddEPyPKyyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt5tcAddEPyPKyyj")
  //</editor-fold>
  public static long/*uint64_t*/ tcAdd(ulong$ptr/*uint64_t P*/ dst, /*const*/ulong$ptr/*uint64_t P*/ rhs, 
       long/*uint64_t*/ c, /*uint*/int parts) {
    /*uint*/int i;
    assert ($lesseq_ulong_ullong(c, 1));
    
    for (i = 0; $less_uint(i, parts); i++) {
      long/*uint64_t*/ l;
      
      l = dst.$at(i);
      if ((c != 0)) {
        dst.$set$addassign(i, rhs.$at(i) + 1);
        c = (($lesseq_ulong(dst.$at(i), l)) ? 1 : 0);
      } else {
        dst.$set$addassign(i, rhs.$at(i));
        c = (($less_ulong(dst.$at(i), l)) ? 1 : 0);
      }
    }
    
    return c;
  }

  
  /// DST -= RHS + CARRY where CARRY is zero or one. Returns the carry flag.
  
  /* DST -= RHS + C where C is zero or one.  Returns the carry flag.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcSubtract">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2501,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2497,
   FQN="llvm::APInt::tcSubtract", NM="_ZN4llvm5APInt10tcSubtractEPyPKyyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt10tcSubtractEPyPKyyj")
  //</editor-fold>
  public static long/*uint64_t*/ tcSubtract(ulong$ptr/*uint64_t P*/ dst, /*const*/ulong$ptr/*uint64_t P*/ rhs, 
            long/*uint64_t*/ c, /*uint*/int parts) {
    /*uint*/int i;
    assert ($lesseq_ulong_ullong(c, 1));
    
    for (i = 0; $less_uint(i, parts); i++) {
      long/*uint64_t*/ l;
      
      l = dst.$at(i);
      if ((c != 0)) {
        dst.$set$minusassign(i, rhs.$at(i) + 1);
        c = (($greatereq_ulong(dst.$at(i), l)) ? 1 : 0);
      } else {
        dst.$set$minusassign(i, rhs.$at(i));
        c = (($greater_ulong(dst.$at(i), l)) ? 1 : 0);
      }
    }
    
    return c;
  }

  
  /// DST += SRC * MULTIPLIER + PART   if add is true
  /// DST  = SRC * MULTIPLIER + PART   if add is false
  ///
  /// Requires 0 <= DSTPARTS <= SRCPARTS + 1.  If DST overlaps SRC they must
  /// start at the same point, i.e. DST == SRC.
  ///
  /// If DSTPARTS == SRC_PARTS + 1 no overflow occurs and zero is returned.
  /// Otherwise DST is filled with the least significant DSTPARTS parts of the
  /// result, and if all of the omitted higher parts were zero return zero,
  /// otherwise overflow occurred and return one.
  
  /*  DST += SRC * MULTIPLIER + CARRY   if add is true
  DST  = SRC * MULTIPLIER + CARRY   if add is false
  
  Requires 0 <= DSTPARTS <= SRCPARTS + 1.  If DST overlaps SRC
  they must start at the same point, i.e. DST == SRC.
  
  If DSTPARTS == SRCPARTS + 1 no overflow occurs and zero is
  returned.  Otherwise DST is filled with the least significant
  DSTPARTS parts of the result, and if all of the omitted higher
  parts were zero return zero, otherwise overflow occurred and
  return one.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcMultiplyPart">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*isComparableTo*/,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2544,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2540,
   FQN="llvm::APInt::tcMultiplyPart", NM="_ZN4llvm5APInt14tcMultiplyPartEPyPKyyyjjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt14tcMultiplyPartEPyPKyyyjjb")
  //</editor-fold>
  public static int tcMultiplyPart(ulong$ptr/*uint64_t P*/ dst, /*const*/ulong$ptr/*uint64_t P*/ src, 
                long/*uint64_t*/ multiplier, long/*uint64_t*/ carry, 
                /*uint*/int srcParts, /*uint*/int dstParts, 
                boolean add) {
    /*uint*/int i, n;
    
    /* Otherwise our writes of DST kill our later reads of SRC.  */
    // JAVA: our dst could be out of src address space, add java-specific check
    assert (/*JAVA*/!dst.isComparableTo(src)) || (dst.$lesseq(src) || dst.$greatereq(src.$add(srcParts)));
    assert ($lesseq_uint(dstParts, srcParts + 1));
    
    /* N loops; minimum of dstParts and srcParts.  */
    n = $less_uint(dstParts, srcParts) ? dstParts : srcParts;
    
    for (i = 0; $less_uint(i, n); i++) {
      long/*uint64_t*/ low, mid, high, srcPart;
      
      /* [ LOW, HIGH ] = MULTIPLIER * SRC[i] + DST[i] + CARRY.
      
      This cannot overflow, because
      
      (n - 1) * (n - 1) + 2 (n - 1) = (n - 1) * (n + 1)
      
      which is less than n^2.  */
      srcPart = src.$at(i);
      if (multiplier == 0 || srcPart == 0) {
        low = carry;
        high = 0;
      } else {
        low = lowHalf(srcPart) * lowHalf(multiplier);
        high = highHalf(srcPart) * highHalf(multiplier);
        
        mid = lowHalf(srcPart) * highHalf(multiplier);
        high += highHalf(mid);
        mid <<= $div_uint(integerPartWidth, 2);
        if ($less_ullong_ulong(low + mid, low)) {
          high++;
        }
        low += mid;
        
        mid = highHalf(srcPart) * lowHalf(multiplier);
        high += highHalf(mid);
        mid <<= $div_uint(integerPartWidth, 2);
        if ($less_ullong_ulong(low + mid, low)) {
          high++;
        }
        low += mid;
        
        /* Now add carry.  */
        if ($less_ullong_ulong(low + carry, low)) {
          high++;
        }
        low += carry;
      }
      if (add) {
        /* And now DST[i], and store the new low part there.  */
        if ($less_ullong_ulong(low + dst.$at(i), low)) {
          high++;
        }
        dst.$set$addassign(i, low);
      } else {
        dst.$set(i, low);
      }
      
      carry = high;
    }
    if ($less_uint(i, dstParts)) {
      /* Full multiplication, there is no overflow.  */
      assert (i + 1 == dstParts);
      dst.$set(i, carry);
      return 0;
    } else {
      /* We overflowed if there is carry.  */
      if ((carry != 0)) {
        return 1;
      }
      
      /* We would overflow if any significant unwritten parts would be
      non-zero.  This is true if any remaining src parts are non-zero
      and the multiplier is non-zero.  */
      if ((multiplier != 0)) {
        for (; $less_uint(i, srcParts); i++)  {
          if ((src.$at(i) != 0)) {
            return 1;
          }
        }
      }
      
      /* We fitted in the narrow destination.  */
      return 0;
    }
  }

  
  /// DST = LHS * RHS, where DST has the same width as the operands and is
  /// filled with the least significant parts of the result.  Returns one if
  /// overflow occurred, otherwise zero.  DST must be disjoint from both
  /// operands.
  
  /* DST = LHS * RHS, where DST has the same width as the operands and
  is filled with the least significant parts of the result.  Returns
  one if overflow occurred, otherwise zero.  DST must be disjoint
  from both operands.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcMultiply">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2637,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2633,
   FQN="llvm::APInt::tcMultiply", NM="_ZN4llvm5APInt10tcMultiplyEPyPKyS3_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt10tcMultiplyEPyPKyS3_j")
  //</editor-fold>
  public static int tcMultiply(ulong$ptr/*uint64_t P*/ dst, /*const*/ulong$ptr/*uint64_t P*/ lhs, 
            /*const*/ulong$ptr/*uint64_t P*/ rhs, /*uint*/int parts) {
    /*uint*/int i;
    int overflow;
    assert ($noteq_ptr(dst, lhs) && $noteq_ptr(dst, rhs));
    
    overflow = 0;
    tcSet(dst, 0, parts);
    
    for (i = 0; $less_uint(i, parts); i++)  {
      overflow |= tcMultiplyPart(dst.$add(i), lhs, rhs.$at(i), 0, parts, 
          parts - i, true);
    }
    
    return overflow;
  }

  
  /// DST = LHS * RHS, where DST has width the sum of the widths of the
  /// operands.  No overflow occurs.  DST must be disjoint from both
  /// operands. Returns the number of parts required to hold the result.
  
  /* DST = LHS * RHS, where DST has width the sum of the widths of the
  operands.  No overflow occurs.  DST must be disjoint from both
  operands.  Returns the number of parts required to hold the
  result.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcFullMultiply">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2660,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2656,
   FQN="llvm::APInt::tcFullMultiply", NM="_ZN4llvm5APInt14tcFullMultiplyEPyPKyS3_jj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt14tcFullMultiplyEPyPKyS3_jj")
  //</editor-fold>
  public static /*uint*/int tcFullMultiply(ulong$ptr/*uint64_t P*/ dst, /*const*/ulong$ptr/*uint64_t P*/ lhs, 
                /*const*/ulong$ptr/*uint64_t P*/ rhs, /*uint*/int lhsParts, 
                /*uint*/int rhsParts) {
    /* Put the narrower number on the LHS for less loops below.  */
    if ($greater_uint(lhsParts, rhsParts)) {
      return tcFullMultiply(dst, rhs, lhs, rhsParts, lhsParts);
    } else {
      /*uint*/int n;
      assert ($noteq_ptr(dst, lhs) && $noteq_ptr(dst, rhs));
      
      tcSet(dst, 0, rhsParts);
      
      for (n = 0; $less_uint(n, lhsParts); n++)  {
        tcMultiplyPart(dst.$add(n), rhs, lhs.$at(n), 0, rhsParts, rhsParts + 1, true);
      }
      
      n = lhsParts + rhsParts;
      
      return n - ((dst.$at(n - 1) == 0) ? 1 : 0);
    }
  }

  
  /// If RHS is zero LHS and REMAINDER are left unchanged, return one.
  /// Otherwise set LHS to LHS / RHS with the fractional part discarded, set
  /// REMAINDER to the remainder, return zero.  i.e.
  ///
  ///  OLD_LHS = RHS * LHS + REMAINDER
  ///
  /// SCRATCH is a bignum of the same size as the operands and result for use by
  /// the routine; its contents need not be initialized and are destroyed.  LHS,
  /// REMAINDER and SCRATCH must be distinct.
  
  /* If RHS is zero LHS and REMAINDER are left unchanged, return one.
  Otherwise set LHS to LHS / RHS with the fractional part discarded,
  set REMAINDER to the remainder, return zero.  i.e.
  
  OLD_LHS = RHS * LHS + REMAINDER
  
  SCRATCH is a bignum of the same size as the operands and result for
  use by the routine; its contents need not be initialized and are
  destroyed.  LHS, REMAINDER and SCRATCH must be distinct.
  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcDivide">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2694,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2690,
   FQN="llvm::APInt::tcDivide", NM="_ZN4llvm5APInt8tcDivideEPyPKyS1_S1_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt8tcDivideEPyPKyS1_S1_j")
  //</editor-fold>
  public static int tcDivide(ulong$ptr/*uint64_t P*/ lhs, /*const*/ulong$ptr/*uint64_t P*/ rhs, 
          ulong$ptr/*uint64_t P*/ remainder, ulong$ptr/*uint64_t P*/ srhs, 
          /*uint*/int parts) {
    /*uint*/int n, shiftCount;
    long/*uint64_t*/ mask;
    assert ($noteq_ptr(lhs, remainder) && $noteq_ptr(lhs, srhs) && $noteq_ptr(remainder, srhs));
    
    shiftCount = tcMSB(rhs, parts) + 1;
    if (shiftCount == 0) {
      return /*true*/1;
    }
    
    shiftCount = parts * integerPartWidth - shiftCount;
    n = $div_uint(shiftCount, integerPartWidth);
    mask = (long/*uint64_t*/)1 << ($rem_uint(shiftCount, integerPartWidth));
    
    tcAssign(srhs, rhs, parts);
    tcShiftLeft(srhs, parts, shiftCount);
    tcAssign(remainder, lhs, parts);
    tcSet(lhs, 0, parts);
    
    /* Loop, subtracting SRHS if REMAINDER is greater and adding that to
    the total.  */
    for (;;) {
      int compare;
      
      compare = tcCompare(remainder, srhs, parts);
      if (compare >= 0) {
        tcSubtract(remainder, srhs, 0, parts);
        lhs.$set$orassign(n, mask);
      }
      if (shiftCount == 0) {
        break;
      }
      shiftCount--;
      tcShiftRight(srhs, parts, 1);
      if ((mask >>>= 1) == 0) {
        mask = (long/*uint64_t*/)1 << (integerPartWidth - 1);
        n--;
      }
    }
    
    return /*false*/0;
  }

  
  /// Shift a bignum left COUNT bits.  Shifted in bits are zero.  There are no
  /// restrictions on COUNT.
  
  /* Shift a bignum left COUNT bits in-place.  Shifted in bits are zero.
  There are no restrictions on COUNT.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcShiftLeft">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2743,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2737,
   FQN="llvm::APInt::tcShiftLeft", NM="_ZN4llvm5APInt11tcShiftLeftEPyjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt11tcShiftLeftEPyjj")
  //</editor-fold>
  public static void tcShiftLeft(ulong$ptr/*uint64_t P*/ dst, /*uint*/int parts, /*uint*/int count) {
    if ((count != 0)) {
      /*uint*/int jump, shift;
      
      /* Jump is the inter-part jump; shift is is intra-part shift.  */
      jump = $div_uint(count, integerPartWidth);
      shift = $rem_uint(count, integerPartWidth);
      while ($greater_uint(parts, jump)) {
        long/*uint64_t*/ part;
        
        parts--;
        
        /* dst[i] comes from the two parts src[i - jump] and, if we have
        an intra-part shift, src[i - jump - 1].  */
        part = dst.$at(parts - jump);
        if ((shift != 0)) {
          part <<= shift;
          if ($greatereq_uint(parts, jump + 1)) {
            part |= dst.$at(parts - jump - 1) >>> (integerPartWidth - shift);
          }
        }
        
        dst.$set(parts, part);
      }
      while ($greater_uint(parts, 0)) {
        dst.$set(--parts, 0);
      }
    }
  }

  
  /// Shift a bignum right COUNT bits.  Shifted in bits are zero.  There are no
  /// restrictions on COUNT.
  
  /* Shift a bignum right COUNT bits in-place.  Shifted in bits are
  zero.  There are no restrictions on COUNT.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcShiftRight">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2777,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2771,
   FQN="llvm::APInt::tcShiftRight", NM="_ZN4llvm5APInt12tcShiftRightEPyjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt12tcShiftRightEPyjj")
  //</editor-fold>
  public static void tcShiftRight(ulong$ptr/*uint64_t P*/ dst, /*uint*/int parts, /*uint*/int count) {
    if ((count != 0)) {
      /*uint*/int i, jump, shift;
      
      /* Jump is the inter-part jump; shift is is intra-part shift.  */
      jump = $div_uint(count, integerPartWidth);
      shift = $rem_uint(count, integerPartWidth);
      
      /* Perform the shift.  This leaves the most significant COUNT bits
      of the result at zero.  */
      for (i = 0; $less_uint(i, parts); i++) {
        long/*uint64_t*/ part;
        if ($greatereq_uint(i + jump, parts)) {
          part = 0;
        } else {
          part = dst.$at(i + jump);
          if ((shift != 0)) {
            part >>>= shift;
            if ($less_uint(i + jump + 1, parts)) {
              part |= dst.$at(i + jump + 1) << (integerPartWidth - shift);
            }
          }
        }
        
        dst.$set(i, part);
      }
    }
  }

  
  /// The obvious AND, OR and XOR and complement operations.
  
  /* Bitwise and of two bignums.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcAnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2809,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2803,
   FQN="llvm::APInt::tcAnd", NM="_ZN4llvm5APInt5tcAndEPyPKyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt5tcAndEPyPKyj")
  //</editor-fold>
  public static void tcAnd(ulong$ptr/*uint64_t P*/ dst, /*const*/ulong$ptr/*uint64_t P*/ rhs, /*uint*/int parts) {
    /*uint*/int i;
    
    for (i = 0; $less_uint(i, parts); i++)  {
      dst.$set$andassign(i, rhs.$at(i));
    }
  }

  
  /* Bitwise inclusive or of two bignums.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcOr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2819,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2813,
   FQN="llvm::APInt::tcOr", NM="_ZN4llvm5APInt4tcOrEPyPKyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt4tcOrEPyPKyj")
  //</editor-fold>
  public static void tcOr(ulong$ptr/*uint64_t P*/ dst, /*const*/ulong$ptr/*uint64_t P*/ rhs, /*uint*/int parts) {
    /*uint*/int i;
    
    for (i = 0; $less_uint(i, parts); i++)  {
      dst.$set$orassign(i, rhs.$at(i));
    }
  }

  
  /* Bitwise exclusive or of two bignums.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcXor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2829,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2823,
   FQN="llvm::APInt::tcXor", NM="_ZN4llvm5APInt5tcXorEPyPKyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt5tcXorEPyPKyj")
  //</editor-fold>
  public static void tcXor(ulong$ptr/*uint64_t P*/ dst, /*const*/ulong$ptr/*uint64_t P*/ rhs, /*uint*/int parts) {
    /*uint*/int i;
    
    for (i = 0; $less_uint(i, parts); i++)  {
      dst.$set$xorassign(i, rhs.$at(i));
    }
  }

  
  /* Complement a bignum in-place.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcComplement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2839,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2833,
   FQN="llvm::APInt::tcComplement", NM="_ZN4llvm5APInt12tcComplementEPyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt12tcComplementEPyj")
  //</editor-fold>
  public static void tcComplement(ulong$ptr/*uint64_t P*/ dst, /*uint*/int parts) {
    /*uint*/int i;
    
    for (i = 0; $less_uint(i, parts); i++)  {
      dst.$set(i, ~dst.$at(i));
    }
  }
  
  
  /// Comparison (unsigned) of two bignums.
  
  /* Comparison (unsigned) of two bignums.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcCompare">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2849,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2843,
   FQN="llvm::APInt::tcCompare", NM="_ZN4llvm5APInt9tcCompareEPKyS2_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt9tcCompareEPKyS2_j")
  //</editor-fold>
  public static int tcCompare(/*const*/ulong$ptr/*uint64_t P*/ lhs, /*const*/ulong$ptr/*uint64_t P*/ rhs, 
           /*uint*/int parts) {
    while ((parts != 0)) {
      parts--;
      if (lhs.$at(parts) == rhs.$at(parts)) {
        continue;
      }
      if ($greater_ulong(lhs.$at(parts), rhs.$at(parts))) {
        return 1;
      } else {
        return -1;
      }
    }
    
    return 0;
  }

  
  /// Increment a bignum in-place.  Return the carry flag.
  
  /* Increment a bignum in-place, return the carry flag.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcIncrement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2868,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2862,
   FQN="llvm::APInt::tcIncrement", NM="_ZN4llvm5APInt11tcIncrementEPyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt11tcIncrementEPyj")
  //</editor-fold>
  public static long/*uint64_t*/ tcIncrement(ulong$ptr/*uint64_t P*/ dst, /*uint*/int parts) {
    /*uint*/int i;
    
    for (i = 0; $less_uint(i, parts); i++)  {
      if (dst.$set$preInc(i) != 0) {
        break;
      }
    }
    
    return ((i == parts) ? 1 : 0);
  }

  
  /// Decrement a bignum in-place.  Return the borrow flag.
  
  /* Decrement a bignum in-place, return the borrow flag.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcDecrement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2881,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2875,
   FQN="llvm::APInt::tcDecrement", NM="_ZN4llvm5APInt11tcDecrementEPyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt11tcDecrementEPyj")
  //</editor-fold>
  public static long/*uint64_t*/ tcDecrement(ulong$ptr/*uint64_t P*/ dst, /*uint*/int parts) {
    for (/*uint*/int i = 0; $less_uint(i, parts); i++) {
      // If the current word is non-zero, then the decrement has no effect on the
      // higher-order words of the integer and no borrow can occur. Exit early.
      if (((dst.$set$postDec(i)) != 0)) {
        return 0;
      }
    }
    // If every word was zero, then there is a borrow.
    return 1;
  }

  
  /// Set the least significant BITS and clear the rest.
  
  /* Set the least significant BITS bits of a bignum, clear the
  rest.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::tcSetLeastSignificantBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2896,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2890,
   FQN="llvm::APInt::tcSetLeastSignificantBits", NM="_ZN4llvm5APInt25tcSetLeastSignificantBitsEPyjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm5APInt25tcSetLeastSignificantBitsEPyjj")
  //</editor-fold>
  public static void tcSetLeastSignificantBits(ulong$ptr/*uint64_t P*/ dst, /*uint*/int parts, 
                           /*uint*/int bits) {
    /*uint*/int i;
    
    i = 0;
    while ($greater_uint(bits, integerPartWidth)) {
      dst.$set(i++, ~(long/*uint64_t*/)0);
      bits -= integerPartWidth;
    }
    if ((bits != 0)) {
      dst.$set(i++, ~(long/*uint64_t*/)0 >>> (integerPartWidth - bits));
    }
    while ($less_uint(i, parts)) {
      dst.$set(i++, 0);
    }
  }

  
  /// \brief debug method
  //<editor-fold defaultstate="collapsed" desc="llvm::APInt::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2275,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2271,
   FQN="llvm::APInt::dump", NM="_ZNK4llvm5APInt4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZNK4llvm5APInt4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    SmallString/*40*/ S/*J*/= new SmallString/*40*/(40), U/*J*/= new SmallString/*40*/(40);
    this.toStringUnsigned(U);
    this.toStringSigned(S);
    dbgs().$out(/*KEEP_STR*/"APInt(").$out_uint(BitWidth).$out(/*KEEP_STR*/"b, ").$out(
        U
    ).$out(/*KEEP_STR*/"u ").$out(S).$out(/*KEEP_STR*/"s)");
  }

  @Override
  public T clone() {
    assert this.getClass() == APInt.class : "why not overridden in " + this.getClass();
    return (T)new APInt(this);
  }

  @Override
  public T move() {
    assert this.getClass() == APInt.class : "why not overridden in " + this.getClass();
    return (T)new APInt(JD$Move.INSTANCE, this);
  }

  @Override public String toString() {
    String txtDecSigned = "";
    try {
      txtDecSigned = __toString(10, true).toJavaString();
    } catch (Throwable e) {
      txtDecSigned = "<ERROR-10Signed>";
    }
    String txtDecUnSigned = "";
    try {
      txtDecUnSigned = __toString(10, false).toJavaString();
    } catch (Throwable e) {
      txtDecUnSigned = "<ERROR-10Unsigned>";
    }
    String txtHex = "";
    try {
      txtHex = __toString(16, false).toJavaString();
    } catch (Throwable e) {
      txtHex = "<ERROR-HEXUnsigned>";
    }
    return "\nSgnd[" + txtDecSigned + "]\nUSgn[" + txtDecUnSigned + "]\nUHex[" + txtHex + "]" +  "\n[BitWidth=" + BitWidth + "[" + (pVal != null ? pVal : VAL) + "]]";
  }
/// @}
}
