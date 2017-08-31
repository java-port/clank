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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.support.impl.*;


//<editor-fold defaultstate="collapsed" desc="static type APFloatStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL10HUerrBoundbjj;_ZL10shiftRightPyjj;_ZL12readExponentPKcS0_;_ZL13decDigitValuej;_ZL13totalExponentPKcS0_i;_ZL14hexDigitsLower;_ZL14hexDigitsUpper;_ZL16interpretDecimalPKcS0_P11decimalInfo;_ZL16partCountForBitsj;_ZL16ulpsFromBoundaryPKyjb;_ZL18writeSignedDecimalPci;_ZL20combineLostFractionsN4llvm12lostFractionES0_;_ZL20writeUnsignedDecimalPcj;_ZL26skipLeadingZeroesAndAnyDotPKcS0_PS0_;_ZL27trailingHexadecimalFractionPKcS0_j;_ZL29lostFractionThroughTruncationPKyjj;_ZL4NaNL;_ZL4NaNU;_ZL8powerOf5Pyj;_ZL9infinityL;_ZL9infinityU;_ZL9partAsHexPcyjPKc;_ZN12_GLOBAL__N_117AdjustToPrecisionERN4llvm15SmallVectorImplIcEERij;_ZN12_GLOBAL__N_117AdjustToPrecisionERN4llvm5APIntERij;_ZN12_GLOBAL__N_16appendERN4llvm15SmallVectorImplIcEENS0_9StringRefE; -static-type=APFloatStatics -package=org.llvm.support.impl -empty-body")
//</editor-fold>
public final class APFloatStatics {


/* A bunch of private, handy routines.  */
//<editor-fold defaultstate="collapsed" desc="partCountForBits">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 101,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 100,
 FQN="partCountForBits", NM="_ZL16partCountForBitsj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL16partCountForBitsj")
//</editor-fold>
public static /*inline*/ /*uint*/int partCountForBits(/*uint*/int bits) {
  return $div_uint(((bits) + integerPartWidth - 1), integerPartWidth);
}


/* Returns 0U-9U.  Return values >= 10U are not digits.  */
//<editor-fold defaultstate="collapsed" desc="decDigitValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 108,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 107,
 FQN="decDigitValue", NM="_ZL13decDigitValuej",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL13decDigitValuej")
//</editor-fold>
public static /*inline*/ /*uint*/int decDigitValue(/*uint*/int c) {
  return c - $char2uint($$0);
}


/* Return the value of a decimal exponent of the form
[+-]ddddddd.

If the exponent overflows, returns a large exponent with the
appropriate sign.  */
//<editor-fold defaultstate="collapsed" desc="readExponent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 119,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 118,
 FQN="readExponent", NM="_ZL12readExponentPKcS0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL12readExponentPKcS0_")
//</editor-fold>
public static int readExponent(char$ptr begin, char$ptr end) {
  boolean isNegative;
  /*uint*/int absExponent;
  /*const*//*uint*/int overlargeExponent = 24000; /* FIXME.  */
  char$ptr p = $tryClone(begin);
  assert ($noteq_ptr(p, end)) : "Exponent has no digits";
  
  isNegative = (p.$star() == $$MINUS);
  if (p.$star() == $$MINUS || p.$star() == $$PLUS) {
    p.$postInc();
    assert ($noteq_ptr(p, end)) : "Exponent has no digits";
  }

  absExponent = decDigitValue($char2uint(p.$postInc().$star()));
  assert ($less_uint(absExponent, 10/*U*/)) : "Invalid character in exponent";

  for (; $noteq_ptr(p, end); p.$preInc()) {
    /*uint*/int value;
    
    value = decDigitValue($char2uint(p.$star()));
    assert ($less_uint(value, 10/*U*/)) : "Invalid character in exponent";
    
    value += absExponent * 10;
    if ($greatereq_uint(absExponent, overlargeExponent)) {
      absExponent = overlargeExponent;
      p = $tryClone(end); /* outwit assert below */
      break;
    }
    absExponent = value;
  }
  assert ($eq_ptr(p, end)) : "Invalid exponent in exponent";
  if (isNegative) {
    return -(int)absExponent;
  } else {
    return (int)absExponent;
  }
}


/* This is ugly and needs cleaning up, but I don't immediately see
how whilst remaining safe.  */
//<editor-fold defaultstate="collapsed" desc="totalExponent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 163,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 162,
 FQN="totalExponent", NM="_ZL13totalExponentPKcS0_i",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL13totalExponentPKcS0_i")
//</editor-fold>
public static int totalExponent(char$ptr p, char$ptr end, 
             int exponentAdjustment) {
  int unsignedExponent;
  boolean negative;
  boolean overflow;
  int exponent = 0;
  assert ($noteq_ptr(p, end)) : "Exponent has no digits";
  
  negative = p.$star() == $$MINUS;
  if (p.$star() == $$MINUS || p.$star() == $$PLUS) {
    p.$postInc();
    assert ($noteq_ptr(p, end)) : "Exponent has no digits";
  }
  
  unsignedExponent = 0;
  overflow = false;
  for (; $noteq_ptr(p, end); p.$preInc()) {
    /*uint*/int value;
    
    value = decDigitValue($char2uint(p.$star()));
    assert ($less_uint(value, 10/*U*/)) : "Invalid character in exponent";
    
    unsignedExponent = unsignedExponent * 10 + value;
    if (unsignedExponent > 32767) {
      overflow = true;
      break;
    }
  }
  if (exponentAdjustment > 32767 || exponentAdjustment < -32768) {
    overflow = true;
  }
  if (!overflow) {
    exponent = unsignedExponent;
    if (negative) {
      exponent = -exponent;
    }
    exponent += exponentAdjustment;
    if (exponent > 32767 || exponent < -32768) {
      overflow = true;
    }
  }
  if (overflow) {
    exponent = negative ? -32768 : 32767;
  }
  
  return exponent;
}

//<editor-fold defaultstate="collapsed" desc="skipLeadingZeroesAndAnyDot">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$set vs. $assign*/,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 212,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 211,
 FQN="skipLeadingZeroesAndAnyDot", NM="_ZL26skipLeadingZeroesAndAnyDotPKcS0_PS0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL26skipLeadingZeroesAndAnyDotPKcS0_PS0_")
//</editor-fold>
public static char$ptr skipLeadingZeroesAndAnyDot(char$ptr begin, char$ptr end, 
                          final char$ptr/*P*/ dot) {
  char$ptr p = $tryClone(begin);
  // JAVA: replace $set to $assign
  dot.$assign(end);
  while ($noteq_ptr(p, end) && p.$star() == $$0) {
    p.$postInc();
  }
  if ($noteq_ptr(p, end) && p.$star() == $$DOT) {
    // JAVA: replace $set to $assign
    dot.$assign(p.$postInc());
    assert (end.$sub(begin) != 1) : "Significand has no digits";
    while ($noteq_ptr(p, end) && p.$star() == $$0) {
      p.$postInc();
    }
  }
  
  return p;
}

//<editor-fold defaultstate="collapsed" desc="interpretDecimal">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 253,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 252,
 FQN="interpretDecimal", NM="_ZL16interpretDecimalPKcS0_P11decimalInfo",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL16interpretDecimalPKcS0_P11decimalInfo")
//</editor-fold>
public static void interpretDecimal(char$ptr begin, char$ptr end, 
                decimalInfo /*P*/ D) {
  char$ptr dot = $tryClone(end);
  char$ptr p = $tryClone(skipLeadingZeroesAndAnyDot(begin, end, dot/*.$addr()*/));
  
  D.firstSigDigit = $tryClone(p);
  D.exponent = 0;
  D.normalizedExponent = 0;
  
  for (; $noteq_ptr(p, end); p.$preInc()) {
    if (p.$star() == $$DOT) {
      assert ($eq_ptr(dot, end)) : "String contains multiple dots";
      dot = $tryClone(p.$postInc());
      if ($eq_ptr(p, end)) {
        break;
      }
    }
    if ($greatereq_uint(decDigitValue($char2uint(p.$star())), 10/*U*/)) {
      break;
    }
  }
  if ($noteq_ptr(p, end)) {
    assert ((p.$star() == $$e || p.$star() == $$E)) : "Invalid character in significand";
    assert ($noteq_ptr(p, begin)) : "Significand has no digits";
    assert (($eq_ptr(dot, end) || p.$sub(begin) != 1)) : "Significand has no digits";
    
    /* p points to the first non-digit in the string */
    D.exponent = readExponent(p.$add(1), end);
    
    /* Implied decimal point?  */
    if ($eq_ptr(dot, end)) {
      dot = $tryClone(p);
    }
  }
  
  /* If number is all zeroes accept any exponent.  */
  if ($noteq_ptr(p, D.firstSigDigit)) {
    /* Drop insignificant trailing zeroes.  */
    if ($noteq_ptr(p, begin)) {
      do  {
        do  {
          p.$postDec();
        } while ($noteq_ptr(p, begin) && p.$star() == $$0);
      } while ($noteq_ptr(p, begin) && p.$star() == $$DOT);
    }
    
    /* Adjust the exponents for any decimal point.  */
    D.exponent += ((/*static_cast*/short)((dot.$sub(p)) - ((dot.$greater(p)) ? 1 : 0)));
    D.normalizedExponent = (D.exponent
       + ((/*static_cast*/short)((p.$sub(D.firstSigDigit))
       - ((dot.$greater(D.firstSigDigit) && dot.$less(p)) ? 1 : 0))));
  }
  
  D.lastSigDigit = $tryClone(p);
}


/* Return the trailing fraction of a hexadecimal number.
DIGITVALUE is the first hex digit of the fraction, P points to
the next digit.  */
//<editor-fold defaultstate="collapsed" desc="trailingHexadecimalFraction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 312,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 311,
 FQN="trailingHexadecimalFraction", NM="_ZL27trailingHexadecimalFractionPKcS0_j",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL27trailingHexadecimalFractionPKcS0_j")
//</editor-fold>
public static lostFraction trailingHexadecimalFraction(char$ptr p, char$ptr end, 
                           /*uint*/int digitValue) {
  /*uint*/int hexDigit;
  
  /* If the first trailing digit isn't 0 or 8 we can work out the
  fraction immediately.  */
  if ($greater_uint(digitValue, 8)) {
    return lostFraction.lfMoreThanHalf;
  } else if ($less_uint(digitValue, 8) && $greater_uint(digitValue, 0)) {
    return lostFraction.lfLessThanHalf;
  }

  // Otherwise we need to find the first non-zero digit.
  while ($noteq_ptr(p, end) && (p.$star() == $$0 || p.$star() == $$DOT)) {
    p.$postInc();
  }
  assert ($noteq_ptr(p, end)) : "Invalid trailing hexadecimal fraction!";

  hexDigit = hexDigitValue(p.$star());
  
  /* If we ran off the end it is exactly zero or one-half, otherwise
  a little more.  */
  if (hexDigit == -1/*U*/) {
    return digitValue == 0 ? lostFraction.lfExactlyZero : lostFraction.lfExactlyHalf;
  } else {
    return digitValue == 0 ? lostFraction.lfLessThanHalf : lostFraction.lfMoreThanHalf;
  }
}


/* Return the fraction lost were a bignum truncated losing the least
significant BITS bits.  */
//<editor-fold defaultstate="collapsed" desc="lostFractionThroughTruncation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 343,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 342,
 FQN="lostFractionThroughTruncation", NM="_ZL29lostFractionThroughTruncationPKyjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL29lostFractionThroughTruncationPKyjj")
//</editor-fold>
public static lostFraction lostFractionThroughTruncation(/*const*/ulong$ptr/*uint64_t P*/ parts, 
                             /*uint*/int partCount, 
                             /*uint*/int bits) {
  /*uint*/int lsb;
  
  lsb = APInt.tcLSB(parts, partCount);
  
  /* Note this is guaranteed true if bits == 0, or LSB == -1U.  */
  if ($lesseq_uint(bits, lsb)) {
    return lostFraction.lfExactlyZero;
  }
  if (bits == lsb + 1) {
    return lostFraction.lfExactlyHalf;
  }
  if ($lesseq_uint(bits, partCount * integerPartWidth)
     && (APInt.tcExtractBit(parts, bits - 1) != 0)) {
    return lostFraction.lfMoreThanHalf;
  }
  
  return lostFraction.lfLessThanHalf;
}


/* Shift DST right BITS bits noting lost fraction.  */
//<editor-fold defaultstate="collapsed" desc="shiftRight">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 365,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 364,
 FQN="shiftRight", NM="_ZL10shiftRightPyjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL10shiftRightPyjj")
//</editor-fold>
public static lostFraction shiftRight(ulong$ptr/*uint64_t P*/ dst, /*uint*/int parts, /*uint*/int bits) {
  lostFraction lost_fraction;
  
  lost_fraction = lostFractionThroughTruncation(dst, parts, bits);
  
  APInt.tcShiftRight(dst, parts, bits);
  
  return lost_fraction;
}


/* Combine the effect of two lost fractions.  */
//<editor-fold defaultstate="collapsed" desc="combineLostFractions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 378,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 377,
 FQN="combineLostFractions", NM="_ZL20combineLostFractionsN4llvm12lostFractionES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL20combineLostFractionsN4llvm12lostFractionES0_")
//</editor-fold>
public static lostFraction combineLostFractions(lostFraction moreSignificant, 
                    lostFraction lessSignificant) {
  if (lessSignificant != lostFraction.lfExactlyZero) {
    if (moreSignificant == lostFraction.lfExactlyZero) {
      moreSignificant = lostFraction.lfLessThanHalf;
    } else if (moreSignificant == lostFraction.lfExactlyHalf) {
      moreSignificant = lostFraction.lfMoreThanHalf;
    }
  }
  
  return moreSignificant;
}


/* The error from the true value, in half-ulps, on multiplying two
floating point numbers, which differ from the value they
approximate by at most HUE1 and HUE2 half-ulps, is strictly less
than the returned value.

See "How to Read Floating Point Numbers Accurately" by William D
Clinger.  */
//<editor-fold defaultstate="collapsed" desc="HUerrBound">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 399,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 398,
 FQN="HUerrBound", NM="_ZL10HUerrBoundbjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL10HUerrBoundbjj")
//</editor-fold>
public static /*uint*/int HUerrBound(boolean inexactMultiply, /*uint*/int HUerr1, /*uint*/int HUerr2) {
  assert ($less_uint(HUerr1, 2) || $less_uint(HUerr2, 2) || ($less_uint(HUerr1 + HUerr2, 8)));
  if (HUerr1 + HUerr2 == 0) {
    return $bool2uint(inexactMultiply) * 2; /* <= inexactMultiply half-ulps.  */
  } else {
    return $bool2uint(inexactMultiply) + 2 * (HUerr1 + HUerr2);
  }
}


/* The number of ulps from the boundary (zero, or half if ISNEAREST)
when the least significant BITS are truncated.  BITS cannot be
zero.  */
//<editor-fold defaultstate="collapsed" desc="ulpsFromBoundary">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 413,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 412,
 FQN="ulpsFromBoundary", NM="_ZL16ulpsFromBoundaryPKyjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL16ulpsFromBoundaryPKyjb")
//</editor-fold>
public static long/*uint64_t*/ ulpsFromBoundary(/*const*/ulong$ptr/*uint64_t P*/ parts, /*uint*/int bits, boolean isNearest) {
  /*uint*/int count;
  /*uint*/int partBits;
  long/*uint64_t*/ part;
  long/*uint64_t*/ boundary;
  assert (bits != 0);
  
  bits--;
  count = $div_uint(bits, integerPartWidth);
  partBits = $rem_uint(bits, integerPartWidth) + 1;
  
  part = parts.$at(count) & (~(long/*uint64_t*/)$int2ulong(0) >>> (integerPartWidth - partBits));
  if (isNearest) {
    boundary = (long/*uint64_t*/)$int2ulong(1) << (partBits - 1);
  } else {
    boundary = $int2ulong(0);
  }
  if (count == 0) {
    if ($lesseq_ullong(part - boundary, boundary - part)) {
      return part - boundary;
    } else {
      return boundary - part;
    }
  }
  if (part == boundary) {
    while ((--count != 0)) {
      if ((parts.$at(count) != 0)) {
        return ~(long/*uint64_t*/)$int2ulong(0); /* A lot.  */
      }
    }

    return parts.$at(0);
  } else if (part == boundary - $int2ullong(1)) {
    while ((--count != 0)) {
      if (((~parts.$at(count)) != 0)) {
        return ~(long/*uint64_t*/)$int2ulong(0); /* A lot.  */
      }
    }

    return -parts.$at(0);
  }
  
  return ~(long/*uint64_t*/)$int2ulong(0); /* A lot.  */
}


/* Place pow(5, power) in DST, and return the number of parts used.
DST must be at least one part larger than size of the answer.  */
//<editor-fold defaultstate="collapsed" desc="powerOf5">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*fixed array initalization*/,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 458,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 457,
 FQN="powerOf5", NM="_ZL8powerOf5Pyj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL8powerOf5Pyj")
//</editor-fold>
public static /*uint*/int powerOf5(ulong$ptr/*uint64_t P*/ dst, /*uint*/int power) {
  final/*static*/ /*const*/long/*uint64_t*/ firstEightPowers[/*8*/] = powerOf5$$.firstEightPowers;
  long/*uint64_t*/ pow5s[/*1205*/] = new$ulong(1205);
  pow5s[0] = $int2ulong(78125 * 5);
  
  // JAVA: fixed array initialization
  /*uint*/int partsCount[/*16*/] = new$uint(16, 1);
  long/*uint64_t*/ scratch[/*600*/] = new$ulong(600);
  ulong$ptr/*uint64_t P*/ p1 = create_ulong$ptr();
  ulong$ptr/*uint64_t P*/ p2 = create_ulong$ptr();
  ulong$ptr/*uint64_t P*/ pow5 = create_ulong$ptr();
  /*uint*/int result;
  assert ($lesseq_uint(power, maxExponent));
  
  p1 = $tryClone(dst);
  p2 = $tryClone(create_ulong$ptr(scratch));
  
  p1.$set(firstEightPowers[power & 7]);
  power >>>= 3;
  
  result = 1;
  pow5 = $tryClone(create_ulong$ptr(pow5s));
  
  for (/*uint*/int n = 0; (power != 0); power >>>= 1 , n++) {
    /*uint*/int pc;
    
    pc = partsCount[n];
    
    /* Calculate pow(5,pow(2,n+3)) if we haven't yet.  */
    if (pc == 0) {
      pc = partsCount[n - 1];
      APInt.tcFullMultiply(pow5, pow5.$sub(pc), pow5.$sub(pc), pc, pc);
      pc *= 2;
      if (pow5.$at(pc - 1) == $int2ullong(0)) {
        pc--;
      }
      partsCount[n] = pc;
    }
    if (((power & 1) != 0)) {
      ulong$ptr/*uint64_t P*/ tmp = create_ulong$ptr();
      
      APInt.tcFullMultiply(p2, p1, pow5, result, pc);
      result += pc;
      if (p2.$at(result - 1) == $int2ullong(0)) {
        result--;
      }
      
      /* Now result is in p1 with partsCount parts and p2 is scratch
      space.  */
      tmp = $tryClone(p1);
      p1 = $tryClone(p2);
      p2 = $tryClone(tmp);
    }
    
    pow5.$inc(pc);
  }
  if ($noteq_ptr(p1, dst)) {
    APInt.tcAssign(dst, p1, result);
  }
  
  return result;
}
private static final class powerOf5$$ {
  static final/*static*/ /*const*/long/*uint64_t*/ firstEightPowers[/*8*/] = new$ulong(8, 
    $int2ulong(1), $int2ulong(5), $int2ulong(25), $int2ulong(125), $int2ulong(625), $int2ulong(3125), 
    $int2ulong(15625), $int2ulong(78125));
}


/* Zero at the end to avoid modular arithmetic when adding one; used
when rounding up during hexadecimal output.  */
//<editor-fold defaultstate="collapsed" desc="hexDigitsLower">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 521,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 518,
 FQN="hexDigitsLower", NM="_ZL14hexDigitsLower",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL14hexDigitsLower")
//</editor-fold>
public static /*const*//*char*/char$ptr hexDigitsLower/*[18]*/ = $("0123456789abcdef0");
//<editor-fold defaultstate="collapsed" desc="hexDigitsUpper">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 522,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 519,
 FQN="hexDigitsUpper", NM="_ZL14hexDigitsUpper",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL14hexDigitsUpper")
//</editor-fold>
public static /*const*//*char*/char$ptr hexDigitsUpper/*[18]*/ = $("0123456789ABCDEF0");
//<editor-fold defaultstate="collapsed" desc="infinityL">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 523,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 520,
 FQN="infinityL", NM="_ZL9infinityL",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL9infinityL")
//</editor-fold>
public static /*const*//*char*/char$ptr infinityL/*[9]*/ = $("infinity");
//<editor-fold defaultstate="collapsed" desc="infinityU">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 524,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 521,
 FQN="infinityU", NM="_ZL9infinityU",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL9infinityU")
//</editor-fold>
public static /*const*//*char*/char$ptr infinityU/*[9]*/ = $("INFINITY");
//<editor-fold defaultstate="collapsed" desc="NaNL">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 525,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 522,
 FQN="NaNL", NM="_ZL4NaNL",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL4NaNL")
//</editor-fold>
public static /*const*//*char*/char$ptr NaNL/*[4]*/ = $("nan");
//<editor-fold defaultstate="collapsed" desc="NaNU">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 526,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 523,
 FQN="NaNU", NM="_ZL4NaNU",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL4NaNU")
//</editor-fold>
public static /*const*//*char*/char$ptr NaNU/*[4]*/ = $("NAN");

/* Write out an integerPart in hexadecimal, starting with the most
significant nibble.  Write out exactly COUNT hexdigits, return
COUNT.  */
//<editor-fold defaultstate="collapsed" desc="partAsHex">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 531,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 528,
 FQN="partAsHex", NM="_ZL9partAsHexPcyjPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL9partAsHexPcyjPKc")
//</editor-fold>
public static /*uint*/int partAsHex(char$ptr/*char P*/ dst, long/*uint64_t*/ part, /*uint*/int count, 
         /*const*/char$ptr/*char P*/ hexDigitChars) {
  /*uint*/int result = count;
  assert (count != 0 && $lesseq_uint(count, $div_uint(integerPartWidth, 4)));
  
  part >>>= (integerPartWidth - 4 * count);
  while (((count--) != 0)) {
    dst.$set(count, hexDigitChars.$at($ulong2uint(part & $int2ullong(0xf))));
    part >>>= 4;
  }

  return result;
}


/* Write out an unsigned decimal integer.  */
//<editor-fold defaultstate="collapsed" desc="writeUnsignedDecimal">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 549,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 546,
 FQN="writeUnsignedDecimal", NM="_ZL20writeUnsignedDecimalPcj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL20writeUnsignedDecimalPcj")
//</editor-fold>
public static char$ptr/*char P*/ writeUnsignedDecimal(char$ptr/*char P*/ dst, /*uint*/int n) {
  /*char*/byte buff[/*40*/] = new$char(40);
  char$ptr/*char P*/ p = create_char$ptr();
  
  p = create_char$ptr(buff);
  do  {
    p.$postInc().$set($uint2char($char2uint($$0) + $rem_uint(n, 10)));
  } while ((n = $div_uint(n, 10)) != 0);
  
  do  {
    dst.$postInc().$set(p.$preDec().$star());
  } while ($noteq_ptr(p, buff));
  
  return dst;
}


/* Write out a signed decimal integer.  */
//<editor-fold defaultstate="collapsed" desc="writeSignedDecimal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 567,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 564,
 FQN="writeSignedDecimal", NM="_ZL18writeSignedDecimalPci",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZL18writeSignedDecimalPci")
//</editor-fold>
public static char$ptr/*char P*/ writeSignedDecimal(char$ptr/*char P*/ dst, int value) {
  if (value < 0) {
    dst.$postInc().$set($$MINUS);
    dst = $tryClone(writeUnsignedDecimal(dst, -(/*uint*/int)value));
  } else {
    dst = $tryClone(writeUnsignedDecimal(dst, value));
  }

  return dst;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::append">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3489,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3486,
 FQN="(anonymous namespace)::append", NM="_ZN12_GLOBAL__N_16appendERN4llvm15SmallVectorImplIcEENS0_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN12_GLOBAL__N_16appendERN4llvm15SmallVectorImplIcEENS0_9StringRefE")
//</editor-fold>
public static void append(final SmallString/*&*/ Buffer, StringRef Str) {
  Buffer.append_T(Str.begin(), Str.end());
}


/// Removes data from the given significand until it is no more
/// precise than is required for the desired precision.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AdjustToPrecision">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3495,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3492,
 FQN="(anonymous namespace)::AdjustToPrecision", NM="_ZN12_GLOBAL__N_117AdjustToPrecisionERN4llvm5APIntERij",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN12_GLOBAL__N_117AdjustToPrecisionERN4llvm5APIntERij")
//</editor-fold>
public static void AdjustToPrecision(final APInt /*&*/ significand, 
                 final int$ref/*int &*/ exp, /*uint*/int FormatPrecision) {
  /*uint*/int bits = significand.getActiveBits();
  
  // 196/59 is a very slight overestimate of lg_2(10).
  /*uint*/int bitsRequired = $div_uint((FormatPrecision * 196 + 58), 59);
  if ($lesseq_uint(bits, bitsRequired)) {
    return;
  }

  /*uint*/int tensRemovable = $div_uint((bits - bitsRequired) * 59, 196);
  if (!(tensRemovable != 0)) {
    return;
  }
  
  exp.$set$addassign(tensRemovable);
  
  APInt divisor/*J*/= new APInt(significand.getBitWidth(), $int2ulong(1));
  APInt powten/*J*/= new APInt(significand.getBitWidth(), $int2ulong(10));
  while (true) {
    if (((tensRemovable & 1) != 0)) {
      divisor.$starassign(powten);
    }
    tensRemovable >>>= 1;
    if (!(tensRemovable != 0)) {
      break;
    }
    powten.$starassign(powten);
  }
  
  significand.$assignMove(significand.udiv(divisor));
  
  // Truncate the significand down to its active bit count.
  significand.$assignMove(significand.trunc(significand.getActiveBits()));
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AdjustToPrecision">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3526,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3523,
 FQN="(anonymous namespace)::AdjustToPrecision", NM="_ZN12_GLOBAL__N_117AdjustToPrecisionERN4llvm15SmallVectorImplIcEERij",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN12_GLOBAL__N_117AdjustToPrecisionERN4llvm15SmallVectorImplIcEERij")
//</editor-fold>
public static void AdjustToPrecision(final SmallString/*&*/ buffer, 
                 final int$ref/*int &*/ exp, /*uint*/int FormatPrecision) {
  /*uint*/int N = buffer.size();
  if ($lesseq_uint(N, FormatPrecision)) {
    return;
  }

  // The most significant figures are the last ones in the buffer.
  /*uint*/int FirstSignificant = N - FormatPrecision;
  
  // Round.
  // FIXME: this probably shouldn't use 'round half up'.
  
  // Rounding down is just a truncation, except we also want to drop
  // trailing zeros from the new result.
  if (buffer.$at(FirstSignificant - 1) < $$5) {
    while ($less_uint(FirstSignificant, N) && buffer.$at(FirstSignificant) == $$0) {
      FirstSignificant++;
    }
    
    exp.$set$addassign(FirstSignificant);
    buffer.erase($AddrOf(buffer.ptr$at(0)), $AddrOf(buffer.ptr$at(FirstSignificant)));
    return;
  }
  
  // Rounding up requires a decimal add-with-carry.  If we continue
  // the carry, the newly-introduced zeros will just be truncated.
  for (/*uint*/int I = FirstSignificant; I != N; ++I) {
    if (buffer.$at(I) == $$9) {
      FirstSignificant++;
    } else {
      buffer.ref$at(I).$set$postInc();
      break;
    }
  }
  
  // If we carried through, we have exactly one digit of precision.
  if (FirstSignificant == N) {
    exp.$set$addassign(FirstSignificant);
    buffer.clear();
    buffer.push_back($$1);
    return;
  }
  
  exp.$set$addassign(FirstSignificant);
  buffer.erase($AddrOf(buffer.ptr$at(0)), $AddrOf(buffer.ptr$at(FirstSignificant)));
}

} // END OF class APFloatStatics
