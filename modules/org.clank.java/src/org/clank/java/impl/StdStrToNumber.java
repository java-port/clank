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

package org.clank.java.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.errno_codes.ERANGE;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_defines.ULONG_MAX;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;


//<editor-fold defaultstate="collapsed" desc="static type StdStrToNumber">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-types-map=${SPUTNIK}/contrib/JConvert/llvmToClankType -java-imports=${SPUTNIK}/contrib/JConvert/llvmToClankImports -print /home/petrk/NetBeansProjects/CppApplication_31/main.cpp -file-filter=/home/petrk/NetBeansProjects/CppApplication_31/main.cpp; -static-type=StdStrToNumber")
//</editor-fold>
public final class StdStrToNumber {
  
  /*
  *----------------------------------------------------------------------
  *
  * strtoul --
  *
  *	Convert an ASCII string into an integer.
  * 
  * @param string - String of ASCII digits, possibly
  *                  preceded by white space.  For bases
  *                  greater than 10, either lower- or
  *                  upper-case digits may be used.
  * 
  * @param endPtr - Where to store address of terminating
  *                  character, or NULL.
  * 
  * @param base - Base for conversion.  Must be less
  *                than 37.  If 0, then the base is chosen
  *                from the leading characters of string:
  *                "0x" means hex, "0" means octal, anything
  *                else means decimal.
  *
  * Results:
  *	The return value is the integer equivalent of string.  If endPtr
  *	is non-NULL, then *endPtr is filled in with the character
  *	after the last one that was part of the integer.  If string
  *	doesn't contain a valid integer value, then zero is returned
  *	and *endPtr is set to string.
  *
  * Side effects:
  *	None.
  *
  *----------------------------------------------------------------------
  */
  //<editor-fold defaultstate="collapsed" desc="strtoul">
  @Converted(kind = Converted.Kind.DUMMY)
  //</editor-fold>
  public static /*ulong*/long strtoul(/*const*/char$ptr/*char P*/ string, type$ptr<char$ptr>/*char PP*/ endPtr, /*uint*/int base) {
    return str_to_long_impl(string, endPtr, base);
  }

  public static long strtol(/*const*/char$ptr/*char P*/ string, type$ptr<char$ptr>/*char PP*/ endPtr, /*uint*/int base) {
    return str_to_long_impl(string, endPtr, base);
  }
  
  private static /*ulong*/long str_to_long_impl(/*const*/char$ptr/*char P*/ string, type$ptr<char$ptr>/*char PP*/ endPtr, /*uint*/int base) {
    /*register*/ /*const*/char$ptr/*char P*/ p;
    /*register*/ /*ulong*/long result = 0;
    /*register*/ /*uint*/int digit;
    int anyDigits = 0;
    int negative = 0;
    int overflow = 0;
    setErrno(0);
    
    /*
    * Skip any leading blanks.
    */
    p = $tryClone(string);
    while (isspace(p.$star()) != 0) {
      p.$inc(1);
    }
    if (p.$star() == $('-')) {
      negative = 1;
      p.$inc(1);
    } else {
      if (p.$star() == $('+')) {
        p.$inc(1);
      }
    }

    /*
    * If no base was provided, pick one from the leading characters
    * of the string.
    */
    if (base == 0) {
      if (p.$star() == $('0')) {
        p.$inc(1);
        if ((p.$star() == $('x')) || (p.$star() == $('X'))) {
          p.$inc(1);
          base = 16;
        } else {

          /*
          * Must set anyDigits here, otherwise "0" produces a
          * "no digits" error.
          */
          anyDigits = 1;
          base = 8;
        }
      } else {
        base = 10;
      }
    } else if (base == 16) {

      /*
      * Skip a leading "0x" from hex numbers.
      */
      if ((p.$at(0) == $('0')) && ((p.$at(1) == $('x')) || (p.$at(1) == $('X')))) {
        p.$inc(2);
      }
    }

    /*
    * Sorry this code is so messy, but speed seems important.  Do
    * different things for base 8, 10, 16, and other.
    */
    if (base == 8) {
      /*ulong*/long maxres = ULONG_MAX >>> 3;
      for (;; p.$inc(1)) {
        digit = p.$star() - '0';
        if ($greater_uint(digit, 7)) {
          break;
        }
        if ($greater_ulong(result, maxres)) {
          overflow = 1;
        }
        result = (result << 3);
        if ($greater_uint_ulong(digit, (ULONG_MAX - result))) {
          overflow = 1;
        }
        result += digit;
        anyDigits = 1;
      }
    } else if (base == 10) {
      /*ulong*/long maxres = Unsigned.$div_ulong(ULONG_MAX, 10);
      for (;; p.$inc(1)) {
        digit = p.$star() - '0';
        if ($greater_uint(digit, 9)) {
          break;
        }
        if ($greater_ulong(result, maxres)) {
          overflow = 1;
        }
        result *= 10;
        if ($greater_uint_ulong(digit, (ULONG_MAX - result))) {
          overflow = 1;
        }
        result += digit;
        anyDigits = 1;
      }
    } else if (base == 16) {
      /*ulong*/long maxres = ULONG_MAX >>> 4;
      for (;; p.$inc(1)) {
        digit = p.$star() - '0';
        if ($greater_uint(digit, ('z' - '0'))) {
          break;
        }
        digit = cvtIn[(int)digit];
        if ($greater_uint(digit, 15)) {
          break;
        }
        if ($greater_ulong(result, maxres)) {
          overflow = 1;
        }
        result = (result << 4);
        if ($greater_uint_ulong(digit, (ULONG_MAX - result))) {
          overflow = 1;
        }
        result += digit;
        anyDigits = 1;
      }
    } else if (base >= 2 && base <= 36) {
      /*ulong*/long maxres = Unsigned.$div_ulong(ULONG_MAX, base);
      for (;; p.$inc(1)) {
        digit = p.$star() - '0';
        if ($greater_uint(digit, ('z' - '0'))) {
          break;
        }
        digit = cvtIn[(int)digit];
        if ($greatereq_uint(digit, base)) {
          break;
        }
        if ($greater_ulong(result, maxres)) {
          overflow = 1;
        }
        result *= base;
        if ($greater_uint_ulong(digit, (ULONG_MAX - result))) {
          overflow = 1;
        }
        result += digit;
        anyDigits = 1;
      }
    }

    /*
    * See if there were any digits at all.
    */
    if (!(anyDigits != 0)) {
      p = $tryClone(string);
    }
    if (endPtr != null) {
      /* unsafe, but required by the strtoul prototype */
      endPtr.$set($tryClone(p));
    }
    if ((overflow != 0)) {
      setErrno(ERANGE);
      return ULONG_MAX;
    }
    if ((negative != 0)) {
      return -result;
    }
    return result;
  }
  
  /*
  *----------------------------------------------------------------------
  *
  * strtod --
  *
  *	This procedure converts a floating-point number from an ASCII
  *	decimal representation to internal double-precision format.
  * 
  * @param string - A decimal ASCII floating-point number,
  *                  optionally preceded by white space.
  *                  Must have form "-I.FE-X", where I is the
  *                  integer part of the mantissa, F is the
  *                  fractional part of the mantissa, and X
  *                  is the exponent.  Either of the signs
  *                  may be "+", "-", or omitted.  Either I
  *                  or F may be omitted, or both.  The decimal
  *                  point isn't necessary unless F is present.
  *                  The "E" may actually be an "e".  E and X
  *                  may both be omitted (but not just one).
  * 
  * @param endPtr - If non-NULL, store terminating character's
  *                  address here
  * 	 
  * Results:
  *	The return value is the double-precision floating-point
  *	representation of the characters in string.  If endPtr isn't
  *	NULL, then *endPtr is filled in with the address of the
  *	next character after the last one that was part of the
  *	floating-point number.
  *
  * Side effects:
  *	None.
  *
  *----------------------------------------------------------------------
  */
  //<editor-fold defaultstate="collapsed" desc="strtod">
  @Converted(kind = Converted.Kind.DUMMY)
  //</editor-fold>
  public static double strtod(/*const*/char$ptr/*char P*/ string, type$ptr<char$ptr>/*char PP*/ endPtr) {
    boolean sign, expSign = FALSE;
    double fraction, dblExp;
    /*register*/ /*const*/char$ptr/*char P*/ p;
    /*register*/ int c;
    int exp = 0; /* Exponent read from "EX" field. */
    int fracExp = 0; /* Exponent that derives from the fractional
    * part.  Under normal circumstatnces, it is
    * the negative of the number of digits in F.
    * However, if I is very long, the last digits
    * of I get dropped (otherwise a long I with a
    * large negative exponent could cause an
    * unnecessary overflow on I alone).  In this
    * case, fracExp is incremented one for each
    * dropped digit. */
    int mantSize; /* Number of digits in mantissa. */
    int decPt; /* Number of mantissa digits BEFORE decimal
    * point. */
    /*const*/char$ptr/*char P*/ pExp; /* Temporarily holds location of exponent
    * in string. */

    boolean done = false;

    /*
    * Strip off leading blanks and check for a sign.
    */
    p = $tryClone(string);
    while ((isspace(((/*uchar*/short)(p.$star()))) != 0)) {
      p.$inc(1);
    }
    if (p.$star() == $('-')) {
      sign = TRUE;
      p.$inc(1);
    } else {
      if (p.$star() == $('+')) {
        p.$inc(1);
      }
      sign = FALSE;
    }

    /*
    * Count the number of digits in the mantissa (including the decimal
    * point), and also locate the decimal point.
    */
    decPt = -1;
    for (mantSize = 0;; mantSize += 1) {
      c = p.$star();
      if (!(isdigit(c) != 0)) {
        if ((c != $('.')) || (decPt >= 0)) {
          break;
        }
        decPt = mantSize;
      }
      p.$inc(1);
    }

    /*
    * Now suck up the digits in the mantissa.  Use two integers to
    * collect 9 digits each (this is faster than using floating-point).
    * If the mantissa has more than 18 digits, ignore the extras, since
    * they can't affect the value anyway.
    */
    pExp = $tryClone(p);
    p.$dec(mantSize);
    if (decPt < 0) {
      decPt = mantSize;
    } else {
      mantSize -= 1; /* One of the digits was the point. */
    }
    if (mantSize > 18) {
      fracExp = decPt - 18;
      mantSize = 18;
    } else {
      fracExp = decPt - mantSize;
    }
    if (mantSize == 0) {
      fraction = 0.;
      p = $tryClone(string);
      return done(p, sign, fraction, endPtr);
    } else {
      int frac1, frac2;
      frac1 = 0;
      for (; mantSize > 9; mantSize -= 1) {
        c = p.$star();
        p.$inc(1);
        if (c == $('.')) {
          c = p.$star();
          p.$inc(1);
        }
        frac1 = 10 * frac1 + (c - '0');
      }
      frac2 = 0;
      for (; mantSize > 0; mantSize -= 1) {
        c = p.$star();
        p.$inc(1);
        if (c == $('.')) {
          c = p.$star();
          p.$inc(1);
        }
        frac2 = 10 * frac2 + (c - '0');
      }
      fraction = (1.0E+9 * frac1) + frac2;
    }

    /*
    * Skim off the exponent.
    */
    p = $tryClone(pExp);
    if ((p.$star() == $('E')) || (p.$star() == $('e'))) {
      p.$inc(1);
      if (p.$star() == $('-')) {
        expSign = TRUE;
        p.$inc(1);
      } else {
        if (p.$star() == $('+')) {
          p.$inc(1);
        }
        expSign = FALSE;
      }
      if (!(isdigit(((/*uchar*/short)(p.$star()))) != 0)) {
        p = $tryClone(pExp);
        return done(p, sign, fraction, endPtr);
      }
      while ((isdigit(((/*uchar*/short)(p.$star()))) != 0)) {
        exp = exp * 10 + (p.$star() - '0');
        p.$inc(1);
      }
    }
    if (expSign) {
      exp = fracExp - exp;
    } else {
      exp = fracExp + exp;
    }

    /*
    * Generate a floating-point number that represents the exponent.
    * Do this by processing the exponent one bit at a time to combine
    * many powers of 2 of 10. Then combine the exponent with the
    * fraction.
    */
    if (exp < 0) {
      expSign = TRUE;
      exp = -exp;
    } else {
      expSign = FALSE;
    }
    if (exp > maxExponent) {
      exp = maxExponent;
      setErrno(ERANGE);
    }
    dblExp = 1.;
    for (int i = 0; exp != 0; exp >>= 1, i++) {
      double d = powersOf10[i];
      if (((exp & 01) != 0)) {
        dblExp *= d;
      }
    }
    if (expSign) {
      fraction /= dblExp;
    } else {
      fraction *= dblExp;
    }

    return done(p, sign, fraction, endPtr);
  }

  private static double done(char$ptr p, boolean sign, double fraction, type$ptr<char$ptr> endPtr) {
    if (endPtr != null) {
      endPtr.$set($tryClone(p));
    }
    if (sign) {
      return -fraction;
    }
    return fraction;  
  }

  /*
  * The table below is used to convert from ASCII digits to a
  * numerical equivalent.  It maps from '0' through 'z' to integers
  * (100 for non-digit characters).
  */
  //<editor-fold defaultstate="collapsed" desc="cvtIn">
  @Converted(kind = Converted.Kind.DUMMY)
  //</editor-fold>
  private static /*char*/byte cvtIn[/*75*/] = new /*char*/byte [/*75*/] {
    0, 1, 2, 3, 4, 5, 6, 7, 8, 9, /* '0' - '9' */
    100, 100, 100, 100, 100, 100, 100, /* punctuation */
    10, 11, 12, 13, 14, 15, 16, 17, 18, 19, /* 'A' - 'Z' */
    20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 
    30, 31, 32, 33, 34, 35, 
    100, 100, 100, 100, 100, 100, /* punctuation */
    10, 11, 12, 13, 14, 15, 16, 17, 18, 19, /* 'a' - 'z' */
    20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 
    30, 31, 32, 33, 34, 35};

  //<editor-fold defaultstate="collapsed" desc="maxExponent">
  @Converted(kind = Converted.Kind.DUMMY)
  //</editor-fold>
  private static int maxExponent = 511;
  /* Largest possible base 10 exponent.  Any
  * exponent larger than this will already
  * produce underflow or overflow, so there's
  * no need to worry about additional digits.
  */
  //<editor-fold defaultstate="collapsed" desc="powersOf10">
  @Converted(kind = Converted.Kind.DUMMY)
  //</editor-fold>
  private static double powersOf10[/*9*/] = new double [/*9*/] {
    /* Table giving binary powers of 10.  Entry */
    10., /* is 10^2^i.  Used to convert decimal */
    100., /* exponents into floating-point numbers. */
    1.0E+4, 
    1.0E+8, 
    1.0E+16, 
    1.0000000000000001E+32, 
    1.0E+64, 
    1.0000000000000001E+128, 
    1.0E+256
  };

} // END OF class StdStrToNumber
