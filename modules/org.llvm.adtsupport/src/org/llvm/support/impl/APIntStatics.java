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
package org.llvm.support.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;


//<editor-fold defaultstate="collapsed" desc="static type APIntStatics">
@Converted(kind = Converted.Kind.MANUAL,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZL16getClearedMemoryj;_ZL3addPyPKyS1_j;_ZL3mulPyS_jS_j;_ZL3subPyPKyS1_j;_ZL5add_1PyS_jy;_ZL5mul_1PyS_jy;_ZL5sub_1Pyjy;_ZL8KnuthDivPjS_S_S_jj;_ZL8getDigitch;_ZL8lshrNearPyS_jj;_ZL9getMemoryj;_ZN12_GLOBAL__N_1L10lowBitMaskEj;_ZN12_GLOBAL__N_1L7lowHalfEy;_ZN12_GLOBAL__N_1L7partLSBEy;_ZN12_GLOBAL__N_1L7partMSBEy;_ZN12_GLOBAL__N_1L8highHalfEy; -static-type=APIntStatics -package=org.llvm.support.impl")
//</editor-fold>
public final class APIntStatics {


/// A utility function for allocating memory, checking for allocation failures,
/// and ensuring the contents are zeroed.
//<editor-fold defaultstate="collapsed" desc="getClearedMemory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 35,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 34,
 FQN="getClearedMemory", NM="_ZL16getClearedMemoryj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZL16getClearedMemoryj")
//</editor-fold>
public static /*inline*/ ulong$ptr/*uint64_t P*/ getClearedMemory(/*uint*/int numWords) {
  assert numWords >= 0 : "must be non negative " + numWords;
  ulong$ptr/*uint64_t P*/ result = create_ulong$ptr(new$ulong(numWords));
  assert (Native.$bool(result)) : "APInt memory allocation fails!";
  memset(result, 0, numWords * $sizeof_ULong());
  return result;
}


/// A utility function for allocating memory and checking for allocation
/// failure.  The content is not zeroed.
//<editor-fold defaultstate="collapsed" desc="getMemory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 44,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 43,
 FQN="getMemory", NM="_ZL9getMemoryj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZL9getMemoryj")
//</editor-fold>
public static /*inline*/ ulong$ptr/*uint64_t P*/ getMemory(/*uint*/int numWords) {
  assert numWords >= 0 : "must be non negative " + numWords;
  ulong$ptr/*uint64_t P*/ result = create_ulong$ptr(new$ulong(numWords));
  assert (Native.$bool(result)) : "APInt memory allocation fails!";
  return result;
}


/// A utility function that converts a character to a digit.
//<editor-fold defaultstate="collapsed" desc="getDigit">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 51,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 50,
 FQN="getDigit", NM="_ZL8getDigitch",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZL8getDigitch")
//</editor-fold>
public static /*inline*/ /*uint*/int getDigit(/*char*/byte cdigit, int/*uint8_t*/ radix) {
  assert radix >= 0 : "must be non negative " + radix;
  /*uint*/int r;
  if (radix == 16 || radix == 36) {
    r = cdigit - $$0;
    if (r <= 9) {
      return r;
    }
    
    r = cdigit - $$A;
    if (r <= radix - 11/*U*/) {
      return r + 10;
    }
    
    r = cdigit - $$a;
    if (r <= radix - 11/*U*/) {
      return r + 10;
    }
    
    radix = 10;
  }
  
  r = cdigit - $$0;
  if (r < radix) {
    return r;
  }
  
  return -1/*U*/;
}


/// This function adds a single "digit" integer, y, to the multiple
/// "digit" integer array,  x[]. x[] is modified to reflect the addition and
/// 1 is returned if there is a carry out, otherwise 0 is returned.
/// @returns the carry of the addition.
//<editor-fold defaultstate="collapsed" desc="add_1">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 184,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 183,
 FQN="add_1", NM="_ZL5add_1PyS_jy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZL5add_1PyS_jy")
//</editor-fold>
public static boolean add_1(ulong$ptr/*uint64_t*/ dest, ulong$ptr/*uint64_t*/ x, /*uint*/int len, long/*uint64_t*/ y) {
  assert len >= 0 : "must be non negative " + len;
  for (/*uint*/int i = 0; $less_uint(i, len); ++i) {
    dest.$set(i, y + x.$at(i));
    if ($less_ulong(dest.$at(i), y)) {
      y = 1; // Carry one to next digit.
    } else {
      y = 0; // No need to carry so exit early
      break;
    }
  }
  return (y != 0);
}


/// This function subtracts a single "digit" (64-bit word), y, from
/// the multi-digit integer array, x[], propagating the borrowed 1 value until
/// no further borrowing is neeeded or it runs out of "digits" in x.  The result
/// is 1 if "borrowing" exhausted the digits in x, or 0 if x was not exhausted.
/// In other words, if y > x then this function returns 1, otherwise 0.
/// @returns the borrow out of the subtraction
//<editor-fold defaultstate="collapsed" desc="sub_1">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 212,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 211,
 FQN="sub_1", NM="_ZL5sub_1Pyjy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZL5sub_1Pyjy")
//</editor-fold>
public static boolean sub_1(ulong$ptr/*uint64_t*/ x, /*uint*/int len, long/*uint64_t*/ y) {
  assert len >= 0 : "must be non negative " + len;
  for (/*uint*/int i = 0; $less_uint(i, len); ++i) {
    long/*uint64_t*/ X = x.$at(i);
    x.$set$minusassign(i, y);
    if ($greater_ulong(y, X)) {
      y = 1; // We have to "borrow 1" from next "digit"
    } else {
      y = 0; // No need to borrow
      break; // Remaining digits are unchanged so exit early
    }
  }
  return ((boolean)((y != 0)));
}


/// This function adds the integer array x to the integer array Y and
/// places the result in dest.
/// @returns the carry out from the addition
/// @brief General addition of 64-bit integer arrays
//<editor-fold defaultstate="collapsed" desc="add">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 239,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 238,
 FQN="add", NM="_ZL3addPyPKyS1_j",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZL3addPyPKyS1_j")
//</editor-fold>
public static boolean add(ulong$ptr/*uint64_t P*/ dest, /*const*/ulong$ptr/*uint64_t P*/ x, /*const*/ulong$ptr/*uint64_t P*/ y,
        /*uint*/int len) {
  assert len >= 0 : "must be non negative " + len;
  boolean carry = false;
  for (/*uint*/int i = 0; $less_uint(i, len); ++i) {
    long/*uint64_t*/ limit = std.min(x.$at(i), y.$at(i)); // must come first in case dest == x
    dest.$set(i, x.$at(i) + y.$at(i) + (carry ? 1 : 0));
    carry = $less_ulong(dest.$at(i), limit) || (carry && dest.$at(i) == limit);
  }
  return carry;
}


/// Subtracts the integer array y from the integer array x
/// @returns returns the borrow out.
/// @brief Generalized subtraction of 64-bit integer arrays.
//<editor-fold defaultstate="collapsed" desc="sub">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 266,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 265,
 FQN="sub", NM="_ZL3subPyPKyS1_j",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZL3subPyPKyS1_j")
//</editor-fold>
public static boolean sub(ulong$ptr/*uint64_t P*/ dest, /*const*/ulong$ptr/*uint64_t P*/ x, /*const*/ulong$ptr/*uint64_t P*/ y, 
        /*uint*/int len) {
  assert len >= 0 : "must be non negative " + len;
  boolean borrow = false;
  for (/*uint*/int i = 0; $less_uint(i, len); ++i) {
    long/*uint64_t*/ x_tmp = borrow ? x.$at(i) - $int2ullong(1) : x.$at(i);
    borrow = $greater_ulong(y.$at(i), x_tmp) || (borrow && x.$at(i) == $int2ullong(0));
    dest.$set(i, x_tmp - y.$at(i));
  }
  return borrow;
}


/// Multiplies an integer array, x, by a uint64_t integer and places the result
/// into dest.
/// @returns the carry out of the multiplication.
/// @brief Multiply a multi-digit APInt by a single digit (64-bit) integer.
//<editor-fold defaultstate="collapsed" desc="mul_1">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 293,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 292,
 FQN="mul_1", NM="_ZL5mul_1PyS_jy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZL5mul_1PyS_jy")
//</editor-fold>
public static long/*uint64_t*/ mul_1(ulong$ptr/*uint64_t*/ dest, ulong$ptr/*uint64_t*/ x, /*uint*/int len, long/*uint64_t*/ y) {
  assert len >= 0 : "must be non negative " + len;
  // Split y into high 32-bit part (hy)  and low 32-bit part (ly)
  long/*uint64_t*/ ly = y & 0xffffffffL/*ULL*/;
  long/*uint64_t*/ hy = y >>> 32;
  long/*uint64_t*/ carry = $int2ulong(0);
  
  // For each digit of x.
  for (/*uint*/int i = 0; i < len; ++i) {
    // Split x into high and low words
    long/*uint64_t*/ lx = x.$at(i) & 0xffffffffL/*ULL*/;
    long/*uint64_t*/ hx = x.$at(i) >>> 32;
    // hasCarry - A flag to indicate if there is a carry to the next digit.
    // hasCarry == 0, no carry
    // hasCarry == 1, has carry
    // hasCarry == 2, no carry and the calculation result == 0.
    byte/*uint8_t*/ hasCarry = 0;
    dest.$set(i, carry + lx * ly);
    // Determine if the add above introduces carry.
    hasCarry = (byte) (($less_ulong(dest.$at(i), carry)) ? 1 : 0);
    carry = hx * ly + (dest.$at(i) >>> 32) + ((hasCarry != 0) ? (1L/*ULL*/ << 32) : 0);
    // The upper limit of carry can be (2^32 - 1)(2^32 - 1) +
    // (2^32 - 1) + 2^32 = 2^64.
    hasCarry = (byte) ((!(carry != 0) && (hasCarry != 0)) ? 1 : (!(carry != 0) ? 2 : 0));
    
    carry += (lx * hy) & 0xffffffffL/*ULL*/;
    dest.$set(i, (carry << 32) | (dest.$at(i) & 0xffffffffL/*ULL*/));
    carry = (((!(carry != 0) && $uchar2int(hasCarry) != 2) || $uchar2int(hasCarry) == 1) ? (1L/*ULL*/ << 32) : $int2ullong(0))
       + (carry >>> 32) + ((lx * hy) >>> 32) + hx * hy;
  }
  return carry;
}


/// Multiplies integer array x by integer array y and stores the result into
/// the integer array dest. Note that dest's size must be >= xlen + ylen.
/// @brief Generalized multiplicate of integer arrays.
//<editor-fold defaultstate="collapsed" desc="mul">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 327,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 326,
 FQN="mul", NM="_ZL3mulPyS_jS_j",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZL3mulPyS_jS_j")
//</editor-fold>
public static void mul(ulong$ptr/*uint64_t*/ dest, ulong$ptr/*uint64_t*/ x, /*uint*/int xlen, ulong$ptr/*uint64_t*/ y, 
        /*uint*/int ylen) {
  assert xlen >= 0 : "must be non negative " + xlen;
  assert ylen >= 0 : "must be non negative " + ylen;
  dest.$set(xlen, mul_1(dest, x, xlen, y.$at(0)));
  for (/*uint*/int i = 1; $less_uint(i, ylen); ++i) {
    long/*uint64_t*/ ly = y.$at(i) & 0xffffffffL/*ULL*/;
    long/*uint64_t*/ hy = y.$at(i) >>> 32;
    long/*uint64_t*/ carry = $int2ulong(0);
    long/*uint64_t*/ lx = $int2ulong(0);
    long/*uint64_t*/ hx = $int2ulong(0);
    for (/*uint*/int j = 0; $less_uint(j, xlen); ++j) {
      lx = x.$at(j) & 0xffffffffL/*ULL*/;
      hx = x.$at(j) >>> 32;
      // hasCarry - A flag to indicate if has carry.
      // hasCarry == 0, no carry
      // hasCarry == 1, has carry
      // hasCarry == 2, no carry and the calculation result == 0.
      byte/*uint8_t*/ hasCarry = 0;
      long/*uint64_t*/ resul = carry + lx * ly;
      hasCarry = (byte) (($less_ulong(resul, carry)) ? 1 : 0);
      carry = ((hasCarry != 0) ? (1L/*ULL*/ << 32) : 0) + hx * ly + (resul >>> 32);
      hasCarry = (byte) ((!(carry != 0) && (hasCarry != 0)) ? 1 : (!(carry != 0) ? 2 : 0));
      
      carry += (lx * hy) & 0xffffffffL/*ULL*/;
      resul = (carry << 32) | (resul & 0xffffffffL/*ULL*/);
      dest.$set$addassign(i + j, resul);
      carry = (((!(carry != 0) && $uchar2int(hasCarry) != 2) || $uchar2int(hasCarry) == 1) ? (1L/*ULL*/ << 32) : $int2ullong(0))
         + (carry >>> 32) + $int2ullong(($less_ulong(dest.$at(i + j), resul) ? 1 : 0))
         + ((lx * hy) >>> 32) + hx * hy;
    }
    dest.$set(i + xlen, carry);
  }
}


/// Perform a logical right-shift from Src to Dst, which must be equal or
/// non-overlapping, of Words words, by Shift, which must be less than 64.
//<editor-fold defaultstate="collapsed" desc="lshrNear">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 756,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 780,
 FQN="lshrNear", NM="_ZL8lshrNearPyS_jj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZL8lshrNearPyS_jj")
//</editor-fold>
public static void lshrNear(ulong$ptr/*uint64_t P*/ Dst, ulong$ptr/*uint64_t P*/ Src, /*uint*/int Words, 
        /*uint*/int Shift) {
  assert Words >= 0 : "must be non negative " + Words;
  assert Shift >= 0 : "must be non negative " + Shift;  
  long/*uint64_t*/ Carry = 0;
  for (int I = Words - 1; I >= 0; --I) {
    long/*uint64_t*/ Tmp = Src.$at(I);
    Dst.$set(I, (Tmp >>> Shift) | Carry);
    Carry = Tmp << (64 - Shift);
  }
}


/// Implementation of Knuth's Algorithm D (Division of nonnegative integers)
/// from "Art of Computer Programming, Volume 2", section 4.3.1, p. 272. The
/// variables here have the same names as in the algorithm. Comments explain
/// the algorithm and any deviation from it.
//<editor-fold defaultstate="collapsed" desc="KnuthDiv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 1515,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 1509,
 FQN="KnuthDiv", NM="_ZL8KnuthDivPjS_S_S_jj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZL8KnuthDivPjS_S_S_jj")
//</editor-fold>
public static void KnuthDiv(uint$ptr/*uint P*/ u, uint$ptr/*uint P*/ v, uint$ptr/*uint P*/ q, uint$ptr/*uint P*/ r, 
        /*uint*/int m, /*uint*/int n) {
  assert m >= 0 : "must be non negative " + m;
  assert n >= 0 : "must be non negative " + n;    
  assert (Native.$bool(u)) : "Must provide dividend";
  assert (Native.$bool(v)) : "Must provide divisor";
  assert (Native.$bool(q)) : "Must provide quotient";
  assert ($noteq_ptr(u, v) && $noteq_ptr(u, q) && $noteq_ptr(v, q)) : "Must use different memory";
  assert ($greater_uint(n, 1)) : "n must be > 1";

  // b denotes the base of the number system. In our case b is 2^32.
  /*const*/long/*uint64_t*/ b = ((long/*uint64_t*/)1) << 32;
  
  if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        dbgs().$out(/*KEEP_STR*/"KnuthDiv: m=").$out_uint(m).$out(/*KEEP_STR*/" n=").$out_uint(n).$out_char($$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        dbgs().$out(/*KEEP_STR*/"KnuthDiv: original:");
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        for (int i = m + n; i >= 0; i--)  {
          dbgs().$out(/*KEEP_STR*/$SPACE).$out_uint(u.$at(i));
        }
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        dbgs().$out(/*KEEP_STR*/" by");
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        for (int i = n; i > 0; i--)  {
          dbgs().$out(/*KEEP_STR*/$SPACE).$out_uint(v.$at(i - 1));
        }
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        dbgs().$out_char($$LF);
      }
    } while (false);
  }
  // D1. [Normalize.] Set d = b / (v[n-1] + 1) and multiply all the digits of
  // u and v by d. Note that we have taken Knuth's advice here to use a power
  // of 2 value for d such that d * v[n-1] >= b/2 (b is the base). A power of
  // 2 allows us to shift instead of multiply and it is easy to determine the
  // shift amount from the leading zeros.  We are basically normalizing the u
  // and v so that its high bits are shifted to the top of v's range without
  // overflow. Note that this can require an extra word in u so that u must
  // be of length m+n+1.
  /*uint*/int shift = countLeadingZeros(v.$at(n - 1));
  /*uint*/int v_carry = 0;
  /*uint*/int u_carry = 0;
  if ((shift != 0)) {
    for (/*uint*/int i = 0; $less_uint(i, m + n); ++i) {
      /*uint*/int u_tmp = u.$at(i) >>> (32 - shift);
      u.$set(i, (u.$at(i) << shift) | u_carry);
      u_carry = u_tmp;
    }
    for (/*uint*/int i = 0; $less_uint(i, n); ++i) {
      /*uint*/int v_tmp = v.$at(i) >>> (32 - shift);
      v.$set(i, (v.$at(i) << shift) | v_carry);
      v_carry = v_tmp;
    }
  }
  u.$set(m + n, u_carry);

  if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        dbgs().$out(/*KEEP_STR*/"KnuthDiv:   normal:");
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        for (int i = m + n; i >= 0; i--)  {
          dbgs().$out(/*KEEP_STR*/$SPACE).$out_uint(u.$at(i));
        }
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        dbgs().$out(/*KEEP_STR*/" by");
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        for (int i = n; i > 0; i--)  {
          dbgs().$out(/*KEEP_STR*/$SPACE).$out_uint(v.$at(i - 1));
        }
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        dbgs().$out_char($$LF);
      }
    } while (false);    
  }
  
  // D2. [Initialize j.]  Set j to m. This is the loop counter over the places.
  int j = m;
  do {
    if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        dbgs().$out(/*KEEP_STR*/"KnuthDiv: quotient digit #").$out_int(j).$out_char($$LF);
      }
    } while (false);
    }
    // D3. [Calculate q'.].
    //     Set qp = (u[j+n]*b + u[j+n-1]) / v[n-1]. (qp=qprime=q')
    //     Set rp = (u[j+n]*b + u[j+n-1]) % v[n-1]. (rp=rprime=r')
    // Now test if qp == b or qp*v[n-2] > b*rp + u[j+n-2]; if so, decrease
    // qp by 1, inrease rp by v[n-1], and repeat this test if rp < b. The test
    // on v[n-2] determines at high speed most of the cases in which the trial
    // value qp is one too large, and it eliminates all cases where qp is two
    // too large.
    long/*uint64_t*/ dividend = ((((long/*uint64_t*/)($uint2ulong(u.$at(j + n)))) << 32) + $uint2ullong(u.$at(j + n - 1)));
    if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        dbgs().$out(/*KEEP_STR*/"KnuthDiv: dividend == ").$out_ullong(dividend).$out_char($$LF);
      }
    } while (false);
    }
    long/*uint64_t*/ qp = $div_ulong_uint(dividend, v.$at(n - 1));
    long/*uint64_t*/ rp = $rem_ulong_uint(dividend, v.$at(n - 1));
    if (qp == b || $greater_ullong(qp * $uint2ullong(v.$at(n - 2)), b * rp + $uint2ullong(u.$at(j + n - 2)))) {
      qp--;
      rp += $uint2ullong(v.$at(n - 1));
      if ($less_ulong(rp, b) && (qp == b || $greater_ullong(qp * $uint2ullong(v.$at(n - 2)), b * rp + $uint2ullong(u.$at(j + n - 2))))) {
        qp--;
      }
    }
    if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        dbgs().$out(/*KEEP_STR*/"KnuthDiv: qp == ").$out_ullong(qp).$out(/*KEEP_STR*/", rp == ").$out_ullong(rp).$out_char($$LF);
      }
    } while (false);
    }
    
    // D4. [Multiply and subtract.] Replace (u[j+n]u[j+n-1]...u[j]) with
    // (u[j+n]u[j+n-1]..u[j]) - qp * (v[n-1]...v[1]v[0]). This computation
    // consists of a simple multiplication by a one-place number, combined with
    // a subtraction.
    // The digits (u[j+n]...u[j]) should be kept positive; if the result of
    // this step is actually negative, (u[j+n]...u[j]) should be left as the
    // true value plus b**(n+1), namely as the b's complement of
    // the true value, and a "borrow" to the left should be remembered.
    long/*int64_t*/ borrow = 0;
    for (/*uint*/int i = 0; $less_uint(i, n); ++i) {
      long/*uint64_t*/ p = ((long/*uint64_t*/)(qp)) * ((long/*uint64_t*/)($uint2ulong(v.$at(i))));
      long/*int64_t*/ subres = ((long/*int64_t*/)($uint2long(u.$at(j + i)))) - borrow - $uint2llong((/*uint*/int)/*JAVA: SHRINK $ulong2uint*/(p));
      u.$set(j + i, (/*uint*/int)/*JAVA: SHRINK $long2uint*/(subres));
      borrow = (p >>> 32) - (subres >> 32);
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
          dbgs().$out(/*KEEP_STR*/"KnuthDiv: u[j+i] = ").$out_uint(u.$at(j + i)).$out(/*KEEP_STR*/", borrow = ").$out_llong(borrow).$out_char($$LF);
        }
      } while (false);
      }
    }
    
    boolean isNeg = $uint2llong(u.$at(j + n)) < borrow;
    u.$set$minusassign(j + n, (/*uint*/int)/*JAVA: SHRINK $long2uint*/(borrow));
    
    if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        dbgs().$out(/*KEEP_STR*/"KnuthDiv: after subtraction:");
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        for (int i = m + n; i >= 0; i--)  {
          dbgs().$out(/*KEEP_STR*/$SPACE).$out_uint(u.$at(i));
        }
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        dbgs().$out_char($$LF);
      }
    } while (false);
    }
    
    // D5. [Test remainder.] Set q[j] = qp. If the result of step D4 was
    // negative, go to step D6; otherwise go on to step D7.
    q.$set(j, (/*uint*/int)/*JAVA: SHRINK $ulong2uint*/(qp));
    if (isNeg) {
      // D6. [Add back]. The probability that this step is necessary is very
      // small, on the order of only 2/b. Make sure that test data accounts for
      // this possibility. Decrease q[j] by 1
      q.$set$postDec(j);
      // and add (0v[n-1]...v[1]v[0]) to (u[j+n]u[j+n-1]...u[j+1]u[j]).
      // A carry will occur to the left of u[j+n], and it should be ignored
      // since it cancels with the borrow that occurred in D4.
      boolean carry = false;
      for (/*uint*/int i = 0; $less_uint(i, n); i++) {
        /*uint*/int limit = std.min_uint(u.$at(j + i), v.$at(i));
        u.$set$addassign(j + i, v.$at(i) + (carry ? 1 : 0));
        carry = $less_uint(u.$at(j + i), limit) || (carry && u.$at(j + i) == limit);
      }
      u.$set$addassign(j + n, (carry ? 1 : 0));
    }
    
    if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        dbgs().$out(/*KEEP_STR*/"KnuthDiv: after correction:");
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        for (int i = m + n; i >= 0; i--)  {
          dbgs().$out(/*KEEP_STR*/$SPACE).$out_uint(u.$at(i));
        }
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        dbgs().$out(/*KEEP_STR*/"\nKnuthDiv: digit result = ").$out_uint(q.$at(j)).$out_char($$LF);
      }
    } while (false);
    }
    
    // D7. [Loop on j.]  Decrease j by one. Now if j >= 0, go back to D3.
  } while (--j >= 0);
  
  if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
  do {
    if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
      dbgs().$out(/*KEEP_STR*/"KnuthDiv: quotient:");
    }
  } while (false);
  do {
    if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
      for (int i = m; i >= 0; i--)  {
        dbgs().$out(/*KEEP_STR*/$SPACE).$out_uint(q.$at(i));
      }
    }
  } while (false);
  do {
    if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
      dbgs().$out_char($$LF);
    }
  } while (false);
  }
  
  // D8. [Unnormalize]. Now q[...] is the desired quotient, and the desired
  // remainder may be obtained by dividing u[...] by d. If r is non-null we
  // compute the remainder (urem uses this).
  if (Native.$bool(r)) {
    // The value d is expressed by the "shift" value above since we avoided
    // multiplication by d by using a shift left. So, all we have to do is
    // shift right here. In order to mak
    if ((shift != 0)) {
      /*uint*/int carry = 0;
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
          dbgs().$out(/*KEEP_STR*/"KnuthDiv: remainder:");
        }
      } while (false);
      }
      for (int i = n - 1; i >= 0; i--) {
        r.$set(i, (u.$at(i) >>> shift) | carry);
        carry = u.$at(i) << (32 - shift);
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
            dbgs().$out(/*KEEP_STR*/$SPACE).$out_uint(r.$at(i));
          }
        } while (false);
        }
      }
    } else {
      for (int i = n - 1; i >= 0; i--) {
        r.$set(i, u.$at(i));
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
            dbgs().$out(/*KEEP_STR*/$SPACE).$out_uint(r.$at(i));
          }
        } while (false);
        }
      }
    }
    if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
        dbgs().$out_char($$LF);
      }
    } while (false);
    }
  }
  if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
  do {
    if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"apint")) {
      dbgs().$out_char($$LF);
    }
  } while (false);
  }
}


/* Returns the integer part with the least significant BITS set.
BITS cannot be zero.  */
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::lowBitMask">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2301,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2297,
 FQN="(anonymous namespace)::lowBitMask", NM="_ZN12_GLOBAL__N_1L10lowBitMaskEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN12_GLOBAL__N_1L10lowBitMaskEj")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ lowBitMask(/*uint*/int bits) {
  assert bits >= 0 : "must be non negative " + bits;
  assert (bits != 0 && $lesseq_uint(bits, integerPartWidth));
  
  return ~(long/*uint64_t*/)0 >>> (integerPartWidth - bits);
}


/* Returns the value of the lower half of PART.  */
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::lowHalf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2310,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2306,
 FQN="(anonymous namespace)::lowHalf", NM="_ZN12_GLOBAL__N_1L7lowHalfEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN12_GLOBAL__N_1L7lowHalfEy")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ lowHalf(long/*uint64_t*/ part) {
  return part & lowBitMask($div_uint(integerPartWidth, 2));
}


/* Returns the value of the upper half of PART.  */
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::highHalf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2317,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2313,
 FQN="(anonymous namespace)::highHalf", NM="_ZN12_GLOBAL__N_1L8highHalfEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN12_GLOBAL__N_1L8highHalfEy")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ highHalf(long/*uint64_t*/ part) {
  return part >>> ($div_uint(integerPartWidth, 2));
}


/* Returns the bit number of the most significant set bit of a part.
If the input number has no bits set -1U is returned.  */
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::partMSB">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2325,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2321,
 FQN="(anonymous namespace)::partMSB", NM="_ZN12_GLOBAL__N_1L7partMSBEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN12_GLOBAL__N_1L7partMSBEy")
//</editor-fold>
public static /*uint*/int partMSB(long/*uint64_t*/ value) {
  return findLastSet(value, ZeroBehavior.ZB_Max);
}


/* Returns the bit number of the least significant set bit of a
part.  If the input number has no bits set -1U is returned.  */
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::partLSB">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 2333,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 2329,
 FQN="(anonymous namespace)::partLSB", NM="_ZN12_GLOBAL__N_1L7partLSBEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN12_GLOBAL__N_1L7partLSBEy")
//</editor-fold>
public static /*uint*/int partLSB(long/*uint64_t*/ value) {
  return findFirstSet(value, ZeroBehavior.ZB_Max);
}

} // END OF class APIntStatics
