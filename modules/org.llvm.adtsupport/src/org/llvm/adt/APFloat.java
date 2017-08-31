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
import org.llvm.support.impl.*;
import static org.llvm.support.impl.APFloatStatics.*;


/// \brief A self-contained host- and target-independent arbitrary-precision
/// floating-point software implementation.
///
/// APFloat uses bignum integer arithmetic as provided by static functions in
/// the APInt class.  The library will work with bignum integers whose parts are
/// any unsigned type at least 16 bits wide, but 64 bits is recommended.
///
/// Written for clarity rather than speed, in particular with a view to use in
/// the front-end of a cross compiler so that target arithmetic can be correctly
/// performed on the host.  Performance should nonetheless be reasonable,
/// particularly for its intended use.  It may be useful as a base
/// implementation for a run-time library during development of a faster
/// target-specific one.
///
/// All 5 rounding modes in the IEEE-754R draft are handled correctly for all
/// implemented operations.  Currently implemented operations are add, subtract,
/// multiply, divide, fused-multiply-add, conversion-to-float,
/// conversion-to-integer and conversion-from-integer.  New rounding modes
/// (e.g. away from zero) can be added with three or four lines of code.
///
/// Four formats are built-in: IEEE single precision, double precision,
/// quadruple precision, and x87 80-bit extended double (when operating with
/// full extended precision).  Adding a new format that obeys IEEE semantics
/// only requires adding two lines of code: a declaration and definition of the
/// format.
///
/// All operations return the status of that operation as an exception bit-mask,
/// so multiple operations can be done consecutively with their results or-ed
/// together.  The returned status can be useful for compiler diagnostics; e.g.,
/// inexact, underflow and overflow can be easily diagnosed on constant folding,
/// and compiler optimizers can determine what exceptions would be raised by
/// folding operations and optimize, or perhaps not optimize, accordingly.
///
/// At present, underflow tininess is detected after rounding; it should be
/// straight forward to add support for the before-rounding case too.
///
/// The library reads hexadecimal floating point numbers as per C99, and
/// correctly rounds if necessary according to the specified rounding mode.
/// Syntax is required to have been validated by the caller.  It also converts
/// floating point numbers to hexadecimal text as per the C99 %a and %A
/// conversions.  The output precision (or alternatively the natural minimal
/// precision) can be specified; if the requested precision is less than the
/// natural precision the output is correctly rounded for the specified rounding
/// mode.
///
/// It also reads decimal floating point numbers and correctly rounds according
/// to the specified rounding mode.
///
/// Conversion to decimal text is not currently implemented.
///
/// Non-zero finite numbers are represented internally as a sign bit, a 16-bit
/// signed exponent, and the significand as an array of integer parts.  After
/// normalization of a number of precision P the exponent is within the range of
/// the format, and if the number is not denormal the P-th bit of the
/// significand is set as an explicit integer bit.  For denormals the most
/// significant bit is shifted right so that the exponent is maintained at the
/// format's minimum, so that the smallest denormal has just the least
/// significant bit of the significand set.  The sign of zeroes and infinities
/// is significant; the exponent and significand of such numbers is not stored,
/// but has a known implicit (deterministic) value: 0 for the significands, 0
/// for zero exponent, all 1 bits for infinity exponent.  For NaNs the sign and
/// significand are deterministic, although not really meaningful, and preserved
/// in non-conversion operations.  The exponent is implicitly all 1 bits.
///
/// APFloat does not provide any exception handling beyond default exception
/// handling. We represent Signaling NaNs via IEEE-754R 2008 6.2.1 should clause
/// by encoding Signaling NaNs with the first bit of its trailing significand as
/// 0.
///
/// TODO
/// ====
///
/// Some features that may or may not be worth adding:
///
/// Binary to decimal conversion (hard).
///
/// Optional ability to detect underflow tininess before rounding.
///
/// New formats: x87 in single and double precision mode (IEEE apart from
/// extended exponent range) (hard).
///
/// New operations: sqrt, IEEE remainder, C90 fmod, nexttoward.
///
//<editor-fold defaultstate="collapsed" desc="llvm::APFloat">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 122,
 FQN = "llvm::APFloat", NM = "_ZN4llvm7APFloatE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloatE")
//</editor-fold>
public class APFloat implements FoldingSetTrait.Profilable, NativeMoveable<APFloat>, Destructors.ClassWithDestructor, Native.NativeComparable<APFloat> {
/*public:*/
  
  /// A signed type to represent a floating point numbers unbiased exponent.
  /*typedef short ExponentType*/;
  
  /// \name Floating Point Semantics.
  /// @{
  public static /*const*/ fltSemantics IEEEhalf = new fltSemantics(15, -14, 11, 16);
  public static /*const*/ fltSemantics IEEEsingle = new fltSemantics(127, -126, 24, 32);
  public static /*const*/ fltSemantics IEEEdouble = new fltSemantics(1023, -1022, 53, 64);
  public static /*const*/ fltSemantics IEEEquad = new fltSemantics(16383, -16382, 113, 128);
  
  /* The PowerPC format consists of two doubles.  It does not map cleanly
  onto the usual format above.  It is approximated using twice the
  mantissa bits.  Note that for exponents near the double minimum,
  we no longer can represent the full 106 mantissa bits, so those
  will be treated as denormal numbers.
  
  FIXME: While this approximation is equivalent to what GCC uses for
  compile-time arithmetic on PPC double-double numbers, it is not able
  to represent all possible values held by a PPC double-double number,
  for example: (long double) 1.0 + (long double) 0x1p-106
  Should this be replaced by a full emulation of PPC double-double?  */
  public static /*const*/ fltSemantics PPCDoubleDouble = new fltSemantics(1023, -1022 + 53, 53 + 53, 128);
  public static /*const*/ fltSemantics x87DoubleExtended = new fltSemantics(16383, -16382, 64, 80);
  
  /// A Pseudo fltsemantic used to construct APFloats that cannot conflict with
  /// anything real.
  public static /*const*/ fltSemantics Bogus = new fltSemantics(0, 0, 0, 0);
  
  /// @}
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::semanticsPrecision">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 851,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 848,
   FQN="llvm::APFloat::semanticsPrecision", NM="_ZN4llvm7APFloat18semanticsPrecisionERKNS_12fltSemanticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat18semanticsPrecisionERKNS_12fltSemanticsE")
  //</editor-fold>
  public static /*uint*/int semanticsPrecision(final /*const*/ fltSemantics /*&*/ semantics) {
    return semantics.precision;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::semanticsMinExponent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 861,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 858,
   FQN="llvm::APFloat::semanticsMinExponent", NM="_ZN4llvm7APFloat20semanticsMinExponentERKNS_12fltSemanticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat20semanticsMinExponentERKNS_12fltSemanticsE")
  //</editor-fold>
  public static short semanticsMinExponent(final /*const*/ fltSemantics /*&*/ semantics) {
    return semantics.minExponent;
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::semanticsMaxExponent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 856,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 853,
   FQN="llvm::APFloat::semanticsMaxExponent", NM="_ZN4llvm7APFloat20semanticsMaxExponentERKNS_12fltSemanticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat20semanticsMaxExponentERKNS_12fltSemanticsE")
  //</editor-fold>
  public static short semanticsMaxExponent(final /*const*/ fltSemantics /*&*/ semantics) {
    return semantics.maxExponent;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::semanticsSizeInBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 866,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 863,
   FQN="llvm::APFloat::semanticsSizeInBits", NM="_ZN4llvm7APFloat19semanticsSizeInBitsERKNS_12fltSemanticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat19semanticsSizeInBitsERKNS_12fltSemanticsE")
  //</editor-fold>
  public static /*uint*/int semanticsSizeInBits(final /*const*/ fltSemantics /*&*/ semantics) {
    return semantics.sizeInBits;
  }

  
  /// IEEE-754R 5.11: Floating Point Comparison Relations.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::cmpResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 152,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 150,
   FQN="llvm::APFloat::cmpResult", NM="_ZN4llvm7APFloat9cmpResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat9cmpResultE")
  //</editor-fold>
  public enum cmpResult implements Native.ComparableLower {
    cmpLessThan(0),
    cmpEqual(cmpLessThan.getValue() + 1),
    cmpGreaterThan(cmpEqual.getValue() + 1),
    cmpUnordered(cmpGreaterThan.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static cmpResult valueOf(int val) {
      cmpResult out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final cmpResult[] VALUES;
      private static final cmpResult[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (cmpResult kind : cmpResult.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new cmpResult[min < 0 ? (1-min) : 0];
        VALUES = new cmpResult[max >= 0 ? (1+max) : 0];
        for (cmpResult kind : cmpResult.values()) {
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
    private cmpResult(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((cmpResult)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((cmpResult)obj).value);}
    //</editor-fold>
  };
  
  /// IEEE-754R 4.3: Rounding-direction attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::roundingMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 160,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 158,
   FQN="llvm::APFloat::roundingMode", NM="_ZN4llvm7APFloat12roundingModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat12roundingModeE")
  //</editor-fold>
  public enum roundingMode implements Native.ComparableLower {
    rmNearestTiesToEven(0),
    rmTowardPositive(rmNearestTiesToEven.getValue() + 1),
    rmTowardNegative(rmTowardPositive.getValue() + 1),
    rmTowardZero(rmTowardNegative.getValue() + 1),
    rmNearestTiesToAway(rmTowardZero.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static roundingMode valueOf(int val) {
      roundingMode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final roundingMode[] VALUES;
      private static final roundingMode[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (roundingMode kind : roundingMode.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new roundingMode[min < 0 ? (1-min) : 0];
        VALUES = new roundingMode[max >= 0 ? (1+max) : 0];
        for (roundingMode kind : roundingMode.values()) {
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
    private roundingMode(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((roundingMode)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((roundingMode)obj).value);}
    //</editor-fold>
  };
  
  /// IEEE-754R 7: Default exception handling.
  ///
  /// opUnderflow or opOverflow are always returned or-ed with opInexact.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::opStatus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 171,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 169,
   FQN="llvm::APFloat::opStatus", NM="_ZN4llvm7APFloat8opStatusE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat8opStatusE")
  //</editor-fold>
  public static final class/*enum*/ opStatus {
    public static final /*uint*/int opOK = 0x00;
    public static final /*uint*/int opInvalidOp = 0x01;
    public static final /*uint*/int opDivByZero = 0x02;
    public static final /*uint*/int opOverflow = 0x04;
    public static final /*uint*/int opUnderflow = 0x08;
    public static final /*uint*/int opInexact = 0x10;
  };
  
  /// Category of internally-represented number.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::fltCategory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 181,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 179,
   FQN="llvm::APFloat::fltCategory", NM="_ZN4llvm7APFloat11fltCategoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat11fltCategoryE")
  //</editor-fold>
  public enum fltCategory implements Native.ComparableLower {
    fcInfinity(0),
    fcNaN(fcInfinity.getValue() + 1),
    fcNormal(fcNaN.getValue() + 1),
    fcZero(fcNormal.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static fltCategory valueOf(int val) {
      fltCategory out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final fltCategory[] VALUES;
      private static final fltCategory[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (fltCategory kind : fltCategory.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new fltCategory[min < 0 ? (1-min) : 0];
        VALUES = new fltCategory[max >= 0 ? (1+max) : 0];
        for (fltCategory kind : fltCategory.values()) {
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
    private fltCategory(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((fltCategory)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((fltCategory)obj).value);}
    //</editor-fold>
  };
    // JAVA: introduce constants to allow arithmetics in case
  private static final int fcInfinity = 0; 
  private static final int fcNaN = 1; 
  private static final int fcNormal = 2; 
  private static final int fcZero = 3;
  static {
    assert fltCategory.fcInfinity.value == fcInfinity;
    assert fltCategory.fcNaN.value == fcNaN;
    assert fltCategory.fcNormal.value == fcNormal;
    assert fltCategory.fcZero.value == fcZero;
  }    
  
  /// Convenience enum used to construct an uninitialized APFloat.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::uninitializedTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 189,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 187,
   FQN="llvm::APFloat::uninitializedTag", NM="_ZN4llvm7APFloat16uninitializedTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat16uninitializedTagE")
  //</editor-fold>
  public enum uninitializedTag implements Native.ComparableLower {
    uninitialized(0);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static uninitializedTag valueOf(int val) {
      uninitializedTag out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final uninitializedTag[] VALUES;
      private static final uninitializedTag[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (uninitializedTag kind : uninitializedTag.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new uninitializedTag[min < 0 ? (1-min) : 0];
        VALUES = new uninitializedTag[max >= 0 ? (1+max) : 0];
        for (uninitializedTag kind : uninitializedTag.values()) {
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
    private uninitializedTag(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((uninitializedTag)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((uninitializedTag)obj).value);}
    //</editor-fold>
  };
  
  /// \name Constructors
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::APFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 810,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 807,
   FQN="llvm::APFloat::APFloat", NM="_ZN4llvm7APFloatC1ERKNS_12fltSemanticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloatC1ERKNS_12fltSemanticsE")
  //</editor-fold>
  public APFloat(final /*const*/ fltSemantics /*&*/ ourSemantics) {
    // : significand() 
    //START JInit
    this.significand = new  Significand();
    //END JInit
    initialize($AddrOf(ourSemantics));
    category = fltCategory.fcZero;
    sign = false;
  }
 // Default construct to 0.0
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::APFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 821,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 818,
   FQN="llvm::APFloat::APFloat", NM="_ZN4llvm7APFloatC1ERKNS_12fltSemanticsENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloatC1ERKNS_12fltSemanticsENS_9StringRefE")
  //</editor-fold>
  public APFloat(final /*const*/ fltSemantics /*&*/ ourSemantics, StringRef text) {
    // : significand() 
    //START JInit
    this.significand = new  Significand();
    //END JInit
    initialize($AddrOf(ourSemantics));
    convertFromString(/*NO_COPY*/text, roundingMode.rmNearestTiesToEven);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::APFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 800,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 797,
   FQN="llvm::APFloat::APFloat", NM="_ZN4llvm7APFloatC1ERKNS_12fltSemanticsEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloatC1ERKNS_12fltSemanticsEy")
  //</editor-fold>
  public APFloat(final /*const*/ fltSemantics /*&*/ ourSemantics, long/*uint64_t*/ value) {
    // : significand() 
    //START JInit
    this.significand = new  Significand();
    //END JInit
    initialize($AddrOf(ourSemantics));
    sign = false;
    category = fltCategory.fcNormal;
    zeroSignificand();
    exponent = $uint2short(ourSemantics.precision - 1);
    significandParts().$set(0, value);
    normalize(roundingMode.rmNearestTiesToEven, lostFraction.lfExactlyZero);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::APFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 816,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 813,
   FQN="llvm::APFloat::APFloat", NM="_ZN4llvm7APFloatC1ERKNS_12fltSemanticsENS0_16uninitializedTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloatC1ERKNS_12fltSemanticsENS0_16uninitializedTagE")
  //</editor-fold>
  public APFloat(final /*const*/ fltSemantics /*&*/ ourSemantics, uninitializedTag tag) {
    // : significand() 
    //START JInit
    this.significand = new  Significand();
    //END JInit
    // Allocates storage if necessary but does not initialize it.
    initialize($AddrOf(ourSemantics));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::APFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3476,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3473,
   FQN="llvm::APFloat::APFloat", NM="_ZN4llvm7APFloatC1ERKNS_12fltSemanticsERKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloatC1ERKNS_12fltSemanticsERKNS_5APIntE")
  //</editor-fold>
  public APFloat(final /*const*/ fltSemantics /*&*/ Sem, final /*const*/ APInt /*&*/ API) {
    // : significand() 
    //START JInit
    this.significand = new  Significand();
    //END JInit
    initFromAPInt($AddrOf(Sem), API);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::APFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3484,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3481,
   FQN="llvm::APFloat::APFloat", NM="_ZN4llvm7APFloatC1Ed",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloatC1Ed")
  //</editor-fold>
  public APFloat(double d) {
    // : significand() 
    //START JInit
    this.significand = new  Significand();
    //END JInit
    initFromAPInt($AddrOf(IEEEdouble), APInt.doubleToBits(d));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::APFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3480,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3477,
   FQN="llvm::APFloat::APFloat", NM="_ZN4llvm7APFloatC1Ef",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloatC1Ef")
  //</editor-fold>
  public APFloat(float f) {
    // : significand() 
    //START JInit
    this.significand = new  Significand();
    //END JInit
    initFromAPInt($AddrOf(IEEEsingle), APInt.floatToBits(f));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::APFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 826,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 823,
   FQN="llvm::APFloat::APFloat", NM="_ZN4llvm7APFloatC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloatC1ERKS0_")
  //</editor-fold>
  public APFloat(final /*const*/ APFloat /*&*/ rhs) {
    // : significand() 
    //START JInit
    this.significand = new  Significand();
    //END JInit
    initialize(rhs.semantics);
    assign(rhs);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::APFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 831,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 828,
   FQN="llvm::APFloat::APFloat", NM="_ZN4llvm7APFloatC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloatC1EOS0_")
  //</editor-fold>
  public APFloat(JD$Move _dparam, final APFloat /*&&*/rhs) {
    // : semantics(&Bogus), significand() 
    //START JInit
    this.semantics = $AddrOf(Bogus);
    this.significand = new  Significand();
    //END JInit
    /*Deref*/this.$assignMove(std.move(rhs));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::~APFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 835,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 832,
   FQN="llvm::APFloat::~APFloat", NM="_ZN4llvm7APFloatD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloatD0Ev")
  //</editor-fold>
  public void $destroy() {
    freeSignificand();
  }

  
  /// @}

  /// \brief Returns whether this instance allocated memory.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::needsCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 210,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 208,
   FQN="llvm::APFloat::needsCleanup", NM="_ZNK4llvm7APFloat12needsCleanupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat12needsCleanupEv")
  //</editor-fold>
  public boolean needsCleanup() /*const*/ {
    return $greater_uint(partCount(), 1);
  }

  
  /// \name Convenience "constructors"
  /// @{
  
  /// Factory for Positive and Negative Zero.
  ///
  /// \param Negative True iff the number should be negative.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::getZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 218,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 216,
   FQN="llvm::APFloat::getZero", NM="_ZN4llvm7APFloat7getZeroERKNS_12fltSemanticsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat7getZeroERKNS_12fltSemanticsEb")
  //</editor-fold>
  public static APFloat getZero(final /*const*/ fltSemantics /*&*/ Sem) {
    return getZero(Sem, false);
  }
  public static APFloat getZero(final /*const*/ fltSemantics /*&*/ Sem, boolean Negative/*= false*/) {
    APFloat Val/*J*/= new APFloat(Sem, uninitializedTag.uninitialized);
    Val.makeZero(Negative);
    return Val;
  }

  
  /// Factory for Positive and Negative Infinity.
  ///
  /// \param Negative True iff the number should be negative.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::getInf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 227,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 225,
   FQN="llvm::APFloat::getInf", NM="_ZN4llvm7APFloat6getInfERKNS_12fltSemanticsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat6getInfERKNS_12fltSemanticsEb")
  //</editor-fold>
  public static APFloat getInf(final /*const*/ fltSemantics /*&*/ Sem) {
    return getInf(Sem, false);
  }
  public static APFloat getInf(final /*const*/ fltSemantics /*&*/ Sem, boolean Negative/*= false*/) {
    APFloat Val/*J*/= new APFloat(Sem, uninitializedTag.uninitialized);
    Val.makeInf(Negative);
    return Val;
  }

  
  /// Factory for QNaN values.
  ///
  /// \param Negative - True iff the NaN generated should be negative.
  /// \param type - The unspecified fill bits for creating the NaN, 0 by
  /// default.  The value is truncated as necessary.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::getNaN">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 238,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 236,
   FQN="llvm::APFloat::getNaN", NM="_ZN4llvm7APFloat6getNaNERKNS_12fltSemanticsEbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat6getNaNERKNS_12fltSemanticsEbj")
  //</editor-fold>
  public static APFloat getNaN(final /*const*/ fltSemantics /*&*/ Sem) {
    return getNaN(Sem, false, 
        0);
  }
  public static APFloat getNaN(final /*const*/ fltSemantics /*&*/ Sem, boolean Negative/*= false*/) {
    return getNaN(Sem, Negative, 
        0);
  }
  public static APFloat getNaN(final /*const*/ fltSemantics /*&*/ Sem, boolean Negative/*= false*/, 
        /*uint*/int type/*= 0*/) {
    if ((type != 0)) {
      APInt fill/*J*/= new APInt(64, $uint2ulong(type));
      return getQNaN(Sem, Negative, $AddrOf(fill));
    } else {
      return getQNaN(Sem, Negative, (/*const*/ APInt /*P*/ )null);
    }
  }

  
  /// Factory for QNaN values.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::getQNaN">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 249,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 247,
   FQN="llvm::APFloat::getQNaN", NM="_ZN4llvm7APFloat7getQNaNERKNS_12fltSemanticsEbPKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat7getQNaNERKNS_12fltSemanticsEbPKNS_5APIntE")
  //</editor-fold>
  public static APFloat getQNaN(final /*const*/ fltSemantics /*&*/ Sem) {
    return getQNaN(Sem, false, 
         (/*const*/ APInt /*P*/ )null);
  }
  public static APFloat getQNaN(final /*const*/ fltSemantics /*&*/ Sem, boolean Negative/*= false*/) {
    return getQNaN(Sem, Negative, 
         (/*const*/ APInt /*P*/ )null);
  }
  public static APFloat getQNaN(final /*const*/ fltSemantics /*&*/ Sem, boolean Negative/*= false*/, 
         /*const*/ APInt /*P*/ payload/*= null*/) {
    return makeNaN(Sem, false, Negative, payload);
  }

  
  /// Factory for SNaN values.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::getSNaN">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 255,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 253,
   FQN="llvm::APFloat::getSNaN", NM="_ZN4llvm7APFloat7getSNaNERKNS_12fltSemanticsEbPKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat7getSNaNERKNS_12fltSemanticsEbPKNS_5APIntE")
  //</editor-fold>
  public static APFloat getSNaN(final /*const*/ fltSemantics /*&*/ Sem) {
    return getSNaN(Sem, false, 
         (/*const*/ APInt /*P*/ )null);
  }
  public static APFloat getSNaN(final /*const*/ fltSemantics /*&*/ Sem, boolean Negative/*= false*/) {
    return getSNaN(Sem, Negative, 
         (/*const*/ APInt /*P*/ )null);
  }
  public static APFloat getSNaN(final /*const*/ fltSemantics /*&*/ Sem, boolean Negative/*= false*/, 
         /*const*/ APInt /*P*/ payload/*= null*/) {
    return makeNaN(Sem, true, Negative, payload);
  }

  
  /// Returns the largest finite number in the given semantics.
  ///
  /// \param Negative - True iff the number should be negative
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::getLargest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3438,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3435,
   FQN="llvm::APFloat::getLargest", NM="_ZN4llvm7APFloat10getLargestERKNS_12fltSemanticsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat10getLargestERKNS_12fltSemanticsEb")
  //</editor-fold>
  public static APFloat getLargest(final /*const*/ fltSemantics /*&*/ Sem) {
    return getLargest(Sem, false);
  }
  public static APFloat getLargest(final /*const*/ fltSemantics /*&*/ Sem, boolean Negative/*= false*/) {
    // We want (in interchange format):
    //   sign = {Negative}
    //   exponent = 1..10
    //   significand = 1..1
    APFloat Val/*J*/= new APFloat(Sem, uninitializedTag.uninitialized);
    Val.makeLargest(Negative);
    return Val;
  }

  
  /// Returns the smallest (by magnitude) finite number in the given semantics.
  /// Might be denormalized, which implies a relative loss of precision.
  ///
  /// \param Negative - True iff the number should be negative
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::getSmallest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3448,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3445,
   FQN="llvm::APFloat::getSmallest", NM="_ZN4llvm7APFloat11getSmallestERKNS_12fltSemanticsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat11getSmallestERKNS_12fltSemanticsEb")
  //</editor-fold>
  public static APFloat getSmallest(final /*const*/ fltSemantics /*&*/ Sem) {
    return getSmallest(Sem, false);
  }
  public static APFloat getSmallest(final /*const*/ fltSemantics /*&*/ Sem, boolean Negative/*= false*/) {
    // We want (in interchange format):
    //   sign = {Negative}
    //   exponent = 0..0
    //   significand = 0..01
    APFloat Val/*J*/= new APFloat(Sem, uninitializedTag.uninitialized);
    Val.makeSmallest(Negative);
    return Val;
  }

  
  /// Returns the smallest (by magnitude) normalized finite number in the given
  /// semantics.
  ///
  /// \param Negative - True iff the number should be negative
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::getSmallestNormalized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3458,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3455,
   FQN="llvm::APFloat::getSmallestNormalized", NM="_ZN4llvm7APFloat21getSmallestNormalizedERKNS_12fltSemanticsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat21getSmallestNormalizedERKNS_12fltSemanticsEb")
  //</editor-fold>
  public static APFloat getSmallestNormalized(final /*const*/ fltSemantics /*&*/ Sem) {
    return getSmallestNormalized(Sem, false);
  }
  public static APFloat getSmallestNormalized(final /*const*/ fltSemantics /*&*/ Sem, boolean Negative/*= false*/) {
    APFloat Val/*J*/= new APFloat(Sem, uninitializedTag.uninitialized);
    
    // We want (in interchange format):
    //   sign = {Negative}
    //   exponent = 0..0
    //   significand = 10..0
    Val.category = fltCategory.fcNormal;
    Val.zeroSignificand();
    Val.sign = Negative;
    Val.exponent = Sem.minExponent;
    Val.significandParts().$set$orassign(partCountForBits(Sem.precision) - 1, (((long/*uint64_t*/)$int2ulong(1)) << ($rem_uint((Sem.precision - 1), integerPartWidth))));
    
    return Val;
  }

  
  /// Returns a float which is bitcasted from an all one value int.
  ///
  /// \param BitWidth - Select float type
  /// \param isIEEE   - If 128 bit number, select between PPC and IEEE
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::getAllOnesValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3374,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3371,
   FQN="llvm::APFloat::getAllOnesValue", NM="_ZN4llvm7APFloat15getAllOnesValueEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat15getAllOnesValueEjb")
  //</editor-fold>
  public static APFloat getAllOnesValue(/*uint*/int BitWidth) {
    return getAllOnesValue(BitWidth, false);
  }
  public static APFloat getAllOnesValue(/*uint*/int BitWidth, boolean isIEEE/*= false*/) {
    switch (BitWidth) {
     case 16:
      return new APFloat(IEEEhalf, APInt.getAllOnesValue(BitWidth));
     case 32:
      return new APFloat(IEEEsingle, APInt.getAllOnesValue(BitWidth));
     case 64:
      return new APFloat(IEEEdouble, APInt.getAllOnesValue(BitWidth));
     case 80:
      return new APFloat(x87DoubleExtended, APInt.getAllOnesValue(BitWidth));
     case 128:
      if (isIEEE) {
        return new APFloat(IEEEquad, APInt.getAllOnesValue(BitWidth));
  }
      return new APFloat(PPCDoubleDouble, APInt.getAllOnesValue(BitWidth));
     default:
      throw new llvm_unreachable("Unknown floating bit width");
    }
  }

  
  /// Returns the size of the floating point number (in bits) in the given
  /// semantics.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::getSizeInBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3395,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3392,
   FQN="llvm::APFloat::getSizeInBits", NM="_ZN4llvm7APFloat13getSizeInBitsERKNS_12fltSemanticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat13getSizeInBitsERKNS_12fltSemanticsE")
  //</editor-fold>
  public static /*uint*/int getSizeInBits(final /*const*/ fltSemantics /*&*/ Sem) {
    return Sem.sizeInBits;
  }

  
  /// @}
  
  /// Used to insert APFloat objects, or objects that contain APFloat objects,
  /// into FoldingSets.
  
  // Profile - This method 'profiles' an APFloat for use with FoldingSet.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 841,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 838,
   FQN="llvm::APFloat::Profile", NM="_ZNK4llvm7APFloat7ProfileERNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat7ProfileERNS_16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.Add(bitcastToAPInt());
  }  
  
  
  /// \name Arithmetic
  /// @{
  
  /* Normalized addition.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1696,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1693,
   FQN="llvm::APFloat::add", NM="_ZN4llvm7APFloat3addERKS0_NS0_12roundingModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat3addERKS0_NS0_12roundingModeE")
  //</editor-fold>
  public /*APFloat::opStatus*//*uint*/int add(final /*const*/ APFloat /*&*/ rhs, roundingMode rounding_mode) {
    return addOrSubtract(rhs, rounding_mode, false);
  }

  
  /* Normalized subtraction.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::subtract">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1703,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1700,
   FQN="llvm::APFloat::subtract", NM="_ZN4llvm7APFloat8subtractERKS0_NS0_12roundingModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat8subtractERKS0_NS0_12roundingModeE")
  //</editor-fold>
  public /*APFloat::opStatus*//*uint*/int subtract(final /*const*/ APFloat /*&*/ rhs, roundingMode rounding_mode) {
    return addOrSubtract(rhs, rounding_mode, true);
  }

  
  /* Normalized multiply.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::multiply">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1710,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1707,
   FQN="llvm::APFloat::multiply", NM="_ZN4llvm7APFloat8multiplyERKS0_NS0_12roundingModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat8multiplyERKS0_NS0_12roundingModeE")
  //</editor-fold>
  public /*APFloat::opStatus*//*uint*/int multiply(final /*const*/ APFloat /*&*/ rhs, roundingMode rounding_mode) {
    /*opStatus*//*uint*/int fs;
    
    sign ^= rhs.sign;
    fs = multiplySpecials(rhs);
    if (isFiniteNonZero()) {
      lostFraction lost_fraction = multiplySignificand(rhs, (/*const*/ APFloat /*P*/ )null);
      fs = normalize(rounding_mode, lost_fraction);
      if (lost_fraction != lostFraction.lfExactlyZero) {
        fs = (/*opStatus*//*uint*/int)(fs | opStatus.opInexact);
      }
    }

    return fs;
  }
  
  
  /* Normalized divide.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::divide">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1729,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1726,
   FQN="llvm::APFloat::divide", NM="_ZN4llvm7APFloat6divideERKS0_NS0_12roundingModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat6divideERKS0_NS0_12roundingModeE")
  //</editor-fold>
  public /*APFloat::opStatus*//*uint*/int divide(final /*const*/ APFloat /*&*/ rhs, roundingMode rounding_mode) {
    /*opStatus*//*uint*/int fs;
    
    sign ^= rhs.sign;
    fs = divideSpecials(rhs);
    if (isFiniteNonZero()) {
      lostFraction lost_fraction = divideSignificand(rhs);
      fs = normalize(rounding_mode, lost_fraction);
      if (lost_fraction != lostFraction.lfExactlyZero) {
        fs = (/*opStatus*//*uint*/int)(fs | opStatus.opInexact);
      }
    }

    return fs;
  }

  /// IEEE remainder.
  
  /* Normalized remainder.  This is not currently correct in all cases.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::remainder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1748,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1745,
   FQN="llvm::APFloat::remainder", NM="_ZN4llvm7APFloat9remainderERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat9remainderERKS0_")
  //</editor-fold>
  public /*APFloat::opStatus*//*uint*/int remainder(final /*const*/ APFloat /*&*/ rhs) {
    /*opStatus*//*uint*/int fs;
    APFloat V = new APFloat(/*Deref*/this);
    /*uint*/int origSign = $bool2uint(sign);
    
    fs = V.divide(rhs, roundingMode.rmNearestTiesToEven);
    if (fs == opStatus.opDivByZero) {
      return fs;
    }

    int parts = partCount();
    ulong$ptr/*uint64_t P*/ x = create_ulong$ptr(new$ulong(parts));
    bool$ptr ignored = create_bool$ptr();
    fs = V.convertToInteger(x, parts * integerPartWidth, true, 
        roundingMode.rmNearestTiesToEven, $AddrOf(ignored));
    if (fs == opStatus.opInvalidOp) {
      return fs;
    }
    
    fs = V.convertFromZeroExtendedInteger(x, parts * integerPartWidth, true, 
        roundingMode.rmNearestTiesToEven);
    assert (fs == opStatus.opOK); // should always work
    
    fs = V.multiply(rhs, roundingMode.rmNearestTiesToEven);
    assert (fs == opStatus.opOK || fs == opStatus.opInexact); // should not overflow or underflow
    
    fs = subtract(V, roundingMode.rmNearestTiesToEven);
    assert (fs == opStatus.opOK || fs == opStatus.opInexact); // likewise
    if (isZero()) {
      sign = $uint2uint_1bit(origSign); // IEEE754 requires this
    }
    /*delete[]*/Destructors.$destroyArray(x);
    return fs;
  }

  /// C fmod, or llvm frem.
  
  /* Normalized llvm frem (C fmod).
  This is not currently correct in all cases.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::mod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1785,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1782,
   FQN="llvm::APFloat::mod", NM="_ZN4llvm7APFloat3modERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat3modERKS0_")
  //</editor-fold>
  public /*APFloat::opStatus*//*uint*/int mod(final /*const*/ APFloat /*&*/ rhs) {
    /*opStatus*//*uint*/int fs;
    fs = modSpecials(rhs);
    if (isFiniteNonZero() && rhs.isFiniteNonZero()) {
      APFloat V = new APFloat(/*Deref*/this);
      /*uint*/int origSign = $bool2uint(sign);
      
      fs = V.divide(rhs, roundingMode.rmNearestTiesToEven);
      if (fs == opStatus.opDivByZero) {
        return fs;
      }

      int parts = partCount();
      ulong$ptr/*uint64_t P*/ x = create_ulong$ptr(new$ulong(parts));
      bool$ptr ignored = create_bool$ptr();
      fs = V.convertToInteger(x, parts * integerPartWidth, true, 
          roundingMode.rmTowardZero, $AddrOf(ignored));
      if (fs == opStatus.opInvalidOp) {
        return fs;
      }
  
      fs = V.convertFromZeroExtendedInteger(x, parts * integerPartWidth, true, 
          roundingMode.rmNearestTiesToEven);
      assert (fs == opStatus.opOK); // should always work
      
      fs = V.multiply(rhs, roundingMode.rmNearestTiesToEven);
      assert (fs == opStatus.opOK || fs == opStatus.opInexact); // should not overflow or underflow
      
      fs = subtract(V, roundingMode.rmNearestTiesToEven);
      assert (fs == opStatus.opOK || fs == opStatus.opInexact); // likewise
      if (isZero()) {
        sign = $uint2uint_1bit(origSign); // IEEE754 requires this
      }
      /*delete[]*/Destructors.$destroyArray(x);
    }
    return fs;
  }

  
  /* Normalized fused-multiply-add.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::fusedMultiplyAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1825,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1822,
   FQN="llvm::APFloat::fusedMultiplyAdd", NM="_ZN4llvm7APFloat16fusedMultiplyAddERKS0_S2_NS0_12roundingModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat16fusedMultiplyAddERKS0_S2_NS0_12roundingModeE")
  //</editor-fold>
  public /*APFloat::opStatus*//*uint*/int fusedMultiplyAdd(final /*const*/ APFloat /*&*/ multiplicand, 
                  final /*const*/ APFloat /*&*/ addend, 
                  roundingMode rounding_mode) {
    /*opStatus*//*uint*/int fs;
    
    /* Post-multiplication sign, before addition.  */
    sign ^= multiplicand.sign;
    
    /* If and only if all arguments are normal do we need to do an
    extended-precision calculation.  */
    if (isFiniteNonZero()
       && multiplicand.isFiniteNonZero()
       && addend.isFinite()) {
      lostFraction lost_fraction;
      
      lost_fraction = multiplySignificand(multiplicand, $AddrOf(addend));
      fs = normalize(rounding_mode, lost_fraction);
      if (lost_fraction != lostFraction.lfExactlyZero) {
        fs = (/*opStatus*//*uint*/int)(fs | opStatus.opInexact);
      }

      /* If two numbers add (exactly) to zero, IEEE 754 decrees it is a
      positive zero unless rounding to minus infinity, except that
      adding two like-signed zeroes gives that zero.  */
      if (category == fltCategory.fcZero && !((fs & opStatus.opUnderflow) != 0) && sign != addend.sign) {
        sign = (rounding_mode == roundingMode.rmTowardNegative);
      }
    } else {
      fs = multiplySpecials(multiplicand);
  
      /* FS can only be opOK or opInvalidOp.  There is no more work
      to do in the latter case.  The IEEE-754R standard says it is
      implementation-defined in this case whether, if ADDEND is a
      quiet NaN, we raise invalid op; this implementation does so.
      
      If we need to do the addition we can do so with normal
      precision.  */
      if (fs == opStatus.opOK) {
        fs = addOrSubtract(addend, rounding_mode, false);
      }
    }
    
    return fs;
  }

  
  /* Rounding-mode corrrect round to integral value.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::roundToIntegral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1870,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1867,
   FQN="llvm::APFloat::roundToIntegral", NM="_ZN4llvm7APFloat15roundToIntegralENS0_12roundingModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat15roundToIntegralENS0_12roundingModeE")
  //</editor-fold>
  public /*APFloat::opStatus*//*uint*/int roundToIntegral(roundingMode rounding_mode) {
    /*opStatus*//*uint*/int fs;
    
    // If the exponent is large enough, we know that this value is already
    // integral, and the arithmetic below would potentially cause it to saturate
    // to +/-Inf.  Bail out early instead.
    if (isFiniteNonZero() && exponent + 1 >= (int)semanticsPrecision($Deref(semantics))) {
      return opStatus.opOK;
    }

    // The algorithm here is quite simple: we add 2^(p-1), where p is the
    // precision of our format, and then subtract it back off again.  The choice
    // of rounding modes for the addition/subtraction determines the rounding mode
    // for our integral rounding as well.
    // NOTE: When the input value is negative, we do subtraction followed by
    // addition instead.
    APInt IntegerConstant/*J*/= new APInt($ulong2uint(NextPowerOf2($uint2ulong(semanticsPrecision($Deref(semantics))))), $int2ulong(1));
    IntegerConstant.$lshiftassign(semanticsPrecision($Deref(semantics)) - 1);
    APFloat MagicConstant/*J*/= new APFloat($Deref(semantics));
    fs = MagicConstant.convertFromAPInt(IntegerConstant, false, 
        roundingMode.rmNearestTiesToEven);
    MagicConstant.copySign(/*Deref*/this);
    if (fs != opStatus.opOK) {
      return fs;
    }
    
    // Preserve the input sign so that we can handle 0.0/-0.0 cases correctly.
    boolean inputSign = isNegative();
    
    fs = add(MagicConstant, rounding_mode);
    if (fs != opStatus.opOK && fs != opStatus.opInexact) {
      return fs;
    }
    
    fs = subtract(MagicConstant, rounding_mode);
    
    // Restore the input sign.
    if (inputSign != isNegative()) {
      changeSign();
    }
    
    return fs;
  }

  /// IEEE-754R 5.3.1: nextUp/nextDown.
  
  /// IEEE-754R 2008 5.3.1: nextUp/nextDown.
  ///
  /// *NOTE* since nextDown(x) = -nextUp(-x), we only implement nextUp with
  /// appropriate sign switching before/after the computation.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::next">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3817,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3814,
   FQN="llvm::APFloat::next", NM="_ZN4llvm7APFloat4nextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat4nextEb")
  //</editor-fold>
  public /*APFloat::opStatus*//*uint*/int next(boolean nextDown) {
    // If we are performing nextDown, swap sign so we have -x.
    if (nextDown) {
      changeSign();
    }

    // Compute nextUp(x)
    /*opStatus*//*uint*/int result = opStatus.opOK;
  
    // Handle each float category separately.
    switch (category) {
     case fcInfinity:
      // nextUp(+inf) = +inf
      if (!isNegative()) {
        break;
      }
      // nextUp(-inf) = -getLargest()
      makeLargest(true);
      break;
     case fcNaN:
      // IEEE-754R 2008 6.2 Par 2: nextUp(sNaN) = qNaN. Set Invalid flag.
      // IEEE-754R 2008 6.2: nextUp(qNaN) = qNaN. Must be identity so we do not
      //                     change the payload.
      if (isSignaling()) {
        result = opStatus.opInvalidOp;
        // For consistency, propagate the sign of the sNaN to the qNaN.
        makeNaN(false, isNegative(), (/*const*/ APInt /*P*/ )null);
      }
      break;
     case fcZero:
      // nextUp(pm 0) = +getSmallest()
      makeSmallest(false);
      break;
     case fcNormal:
      // nextUp(-getSmallest()) = -0
      if (isSmallest() && isNegative()) {
        APInt.tcSet(significandParts(), $int2ulong(0), partCount());
        category = fltCategory.fcZero;
        exponent = 0;
        break;
      }
      
      // nextUp(getLargest()) == INFINITY
      if (isLargest() && !isNegative()) {
        APInt.tcSet(significandParts(), $int2ulong(0), partCount());
        category = fltCategory.fcInfinity;
        exponent = $uint2short($short2uint(semantics.maxExponent) + 1);
        break;
      }
      
      // nextUp(normal) == normal + inc.
      if (isNegative()) {
        // If we are negative, we need to decrement the significand.
        
        // We only cross a binade boundary that requires adjusting the exponent
        // if:
        //   1. exponent != semantics->minExponent. This implies we are not in the
        //   smallest binade or are dealing with denormals.
        //   2. Our significand excluding the integral bit is all zeros.
        boolean WillCrossBinadeBoundary = exponent != semantics.minExponent && isSignificandAllZeros();
        
        // Decrement the significand.
        //
        // We always do this since:
        //   1. If we are dealing with a non-binade decrement, by definition we
        //   just decrement the significand.
        //   2. If we are dealing with a normal -> normal binade decrement, since
        //   we have an explicit integral bit the fact that all bits but the
        //   integral bit are zero implies that subtracting one will yield a
        //   significand with 0 integral bit and 1 in all other spots. Thus we
        //   must just adjust the exponent and set the integral bit to 1.
        //   3. If we are dealing with a normal -> denormal binade decrement,
        //   since we set the integral bit to 0 when we represent denormals, we
        //   just decrement the significand.
        ulong$ptr/*uint64_t P*/ Parts = $tryClone(significandParts());
        APInt.tcDecrement(Parts, partCount());
        if (WillCrossBinadeBoundary) {
          // Our result is a normal number. Do the following:
          // 1. Set the integral bit to 1.
          // 2. Decrement the exponent.
          APInt.tcSetBit(Parts, semantics.precision - 1);
          exponent--;
        }
      } else {
        // If we are positive, we need to increment the significand.
        
        // We only cross a binade boundary that requires adjusting the exponent if
        // the input is not a denormal and all of said input's significand bits
        // are set. If all of said conditions are true: clear the significand, set
        // the integral bit to 1, and increment the exponent. If we have a
        // denormal always increment since moving denormals and the numbers in the
        // smallest normal binade have the same exponent in our representation.
        boolean WillCrossBinadeBoundary = !isDenormal() && isSignificandAllOnes();
        if (WillCrossBinadeBoundary) {
          ulong$ptr/*uint64_t P*/ Parts = $tryClone(significandParts());
          APInt.tcSet(Parts, $int2ulong(0), partCount());
          APInt.tcSetBit(Parts, semantics.precision - 1);
          assert (exponent != semantics.maxExponent) : "We can not increment an exponent beyond the maxExponent allowed by the given floating point semantics.";
          exponent++;
        } else {
          incrementSignificand();
        }
      }
      break;
    }
    
    // If we are performing nextDown, swap sign so we have -nextUp(-x)
    if (nextDown) {
      changeSign();
    }
    
    return result;
  }

  
  /// \brief Operator+ overload which provides the default
  /// \c nmNearestTiesToEven rounding mode and *no* error checking.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::operator+">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 312,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 310,
   FQN="llvm::APFloat::operator+", NM="_ZNK4llvm7APFloatplERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloatplERKS0_")
  //</editor-fold>
  public APFloat $add(final /*const*/ APFloat /*&*/ RHS) /*const*/ {
    APFloat Result = new APFloat(/*Deref*/this);
    Result.add(RHS, roundingMode.rmNearestTiesToEven);
    return Result;
  }

  
  /// \brief Operator- overload which provides the default
  /// \c nmNearestTiesToEven rounding mode and *no* error checking.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::operator-">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 320,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 318,
   FQN="llvm::APFloat::operator-", NM="_ZNK4llvm7APFloatmiERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloatmiERKS0_")
  //</editor-fold>
  public APFloat $sub(final /*const*/ APFloat /*&*/ RHS) /*const*/ {
    APFloat Result = new APFloat(/*Deref*/this);
    Result.subtract(RHS, roundingMode.rmNearestTiesToEven);
    return Result;
  }

  
  /// \brief Operator* overload which provides the default
  /// \c nmNearestTiesToEven rounding mode and *no* error checking.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 328,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 326,
   FQN="llvm::APFloat::operator*", NM="_ZNK4llvm7APFloatmlERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloatmlERKS0_")
  //</editor-fold>
  public APFloat $star(final /*const*/ APFloat /*&*/ RHS) /*const*/ {
    APFloat Result = new APFloat(/*Deref*/this);
    Result.multiply(RHS, roundingMode.rmNearestTiesToEven);
    return Result;
  }

  
  /// \brief Operator/ overload which provides the default
  /// \c nmNearestTiesToEven rounding mode and *no* error checking.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::operator/">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 336,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 334,
   FQN="llvm::APFloat::operator/", NM="_ZNK4llvm7APFloatdvERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloatdvERKS0_")
  //</editor-fold>
  public APFloat $slash(final /*const*/ APFloat /*&*/ RHS) /*const*/ {
    APFloat Result = new APFloat(/*Deref*/this);
    Result.divide(RHS, roundingMode.rmNearestTiesToEven);
    return Result;
  }

  
  /// @}
  
  /// \name Sign operations.
  /// @{
  
  /* Change sign.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::changeSign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1643,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1640,
   FQN="llvm::APFloat::changeSign", NM="_ZN4llvm7APFloat10changeSignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat10changeSignEv")
  //</editor-fold>
  public void changeSign() {
    /* Look mummy, this one's easy.  */
    sign = !sign;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::clearSign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1650,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1647,
   FQN="llvm::APFloat::clearSign", NM="_ZN4llvm7APFloat9clearSignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat9clearSignEv")
  //</editor-fold>
  public void clearSign() {
    /* So is this one. */
    sign = false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::copySign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1657,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1654,
   FQN="llvm::APFloat::copySign", NM="_ZN4llvm7APFloat8copySignERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat8copySignERKS0_")
  //</editor-fold>
  public void copySign(final /*const*/ APFloat /*&*/ rhs) {
    /* And this one. */
    sign = rhs.sign;
  }

  
  /// \brief A static helper to produce a copy of an APFloat value with its sign
  /// copied from some other APFloat.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::copySign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 353,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 351,
   FQN="llvm::APFloat::copySign", NM="_ZN4llvm7APFloat8copySignES0_RKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat8copySignES0_RKS0_")
  //</editor-fold>
  public static APFloat copySign(APFloat Value, final /*const*/ APFloat /*&*/ Sign) {
    Value.copySign(Sign);
    return new APFloat(JD$Move.INSTANCE, Value);
  }

  
  /// @}
  
  /// \name Conversions
  /// @{
  
  /// APFloat::convert - convert a value of one floating point type to another.
  /// The return value corresponds to the IEEE754 exceptions.  *losesInfo
  /// records whether the transformation lost information, i.e. whether
  /// converting the result back to the original type will produce the
  /// original value (this is almost the same as return value==fsOK, but there
  /// are edge cases where this is not so).
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::convert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1992,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1989,
   FQN="llvm::APFloat::convert", NM="_ZN4llvm7APFloat7convertERKNS_12fltSemanticsENS0_12roundingModeEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat7convertERKNS_12fltSemanticsENS0_12roundingModeEPb")
  //</editor-fold>
  public /*APFloat::opStatus*//*uint*/int convert(final /*const*/ fltSemantics /*&*/ toSemantics, 
         roundingMode rounding_mode, bool$ptr/*bool P*/ losesInfo) {
    lostFraction $lostFraction;
    /*uint*/int newPartCount;
    /*uint*/int oldPartCount;
    /*opStatus*//*uint*/int fs;
    int shift;
    final /*const*/ fltSemantics /*&*/ fromSemantics = $Deref(semantics);
    
    $lostFraction = lostFraction.lfExactlyZero;
    newPartCount = partCountForBits(toSemantics.precision + 1);
    oldPartCount = partCount();
    shift = toSemantics.precision - fromSemantics.precision;
    
    boolean X86SpecialNan = false;
    if ($AddrOf(fromSemantics) == $AddrOf(APFloat.x87DoubleExtended)
       && $AddrOf(toSemantics) != $AddrOf(APFloat.x87DoubleExtended) && category == fltCategory.fcNaN
       && (!((significandParts().$star() & 0x8000000000000000L/*ULL*/) != 0)
       || !((significandParts().$star() & 0x4000000000000000L/*ULL*/) != 0))) {
      // x86 has some unusual NaNs which cannot be represented in any other
      // format; note them here.
      X86SpecialNan = true;
    }

    // If this is a truncation of a denormal number, and the target semantics
    // has larger exponent range than the source semantics (this can happen
    // when truncating from PowerPC double-double to double format), the
    // right shift could lose result mantissa bits.  Adjust exponent instead
    // of performing excessive shift.
    if (shift < 0 && isFiniteNonZero()) {
      int exponentChange = significandMSB() + 1 - fromSemantics.precision;
      if (exponent + exponentChange < toSemantics.minExponent) {
        exponentChange = toSemantics.minExponent - exponent;
      }
      if (exponentChange < shift) {
        exponentChange = shift;
      }
      if (exponentChange < 0) {
        shift -= exponentChange;
        exponent += exponentChange;
      }
    }
  
    // If this is a truncation, perform the shift before we narrow the storage.
    if (shift < 0 && (isFiniteNonZero() || category == fltCategory.fcNaN)) {
      $lostFraction = shiftRight(significandParts(), oldPartCount, -shift);
    }
    
    // Fix the storage so it can hold to new value.
    if ($greater_uint(newPartCount, oldPartCount)) {
      // The new type requires more storage; make it available.
      ulong$ptr/*uint64_t P*/ newParts = create_ulong$ptr();
      newParts = create_ulong$ptr(new$ulong(newPartCount));
      APInt.tcSet(newParts, $int2ulong(0), newPartCount);
      if (isFiniteNonZero() || category == fltCategory.fcNaN) {
        APInt.tcAssign(newParts, significandParts(), oldPartCount);
      }
      freeSignificand();
      significand.parts = $tryClone(newParts);
    } else if (newPartCount == 1 && oldPartCount != 1) {
      // Switch to built-in storage for a single part.
      long/*uint64_t*/ newPart = $int2ulong(0);
      if (isFiniteNonZero() || category == fltCategory.fcNaN) {
        newPart = significandParts().$at(0);
      }
      freeSignificand();
      significand.part = newPart;
    }
    
    // Now that we have the right storage, switch the semantics.
    semantics = $AddrOf(toSemantics);
    
    // If this is an extension, perform the shift now that the storage is
    // available.
    if (shift > 0 && (isFiniteNonZero() || category == fltCategory.fcNaN)) {
      APInt.tcShiftLeft(significandParts(), newPartCount, shift);
    }
    if (isFiniteNonZero()) {
      fs = normalize(rounding_mode, $lostFraction);
      losesInfo.$set((fs != opStatus.opOK));
    } else if (category == fltCategory.fcNaN) {
      losesInfo.$set($lostFraction != lostFraction.lfExactlyZero || X86SpecialNan);
      
      // For x87 extended precision, we want to make a NaN, not a special NaN if
      // the input wasn't special either.
      if (!X86SpecialNan && semantics == $AddrOf(APFloat.x87DoubleExtended)) {
        APInt.tcSetBit(significandParts(), semantics.precision - 1);
      }
      
      // gcc forces the Quiet bit on, which means (float)(double)(float_sNan)
      // does not give you back the same bits.  This is dubious, and we
      // don't currently do it.  You're really supposed to get
      // an invalid operation signal at runtime, but nobody does that.
      fs = opStatus.opOK;
    } else {
      losesInfo.$set(false);
      fs = opStatus.opOK;
    }
    
    return fs;
  }

  
  /* Same as convertToSignExtendedInteger, except we provide
  deterministic values in case of an invalid operation exception,
  namely zero for NaNs and the minimal or maximal value respectively
  for underflow or overflow.
  The *isExact output tells whether the result is exact, in the sense
  that converting it back to the original floating point type produces
  the original value.  This is almost equivalent to result==opOK,
  except for negative zeroes.
  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::convertToInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 2211,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 2208,
   FQN="llvm::APFloat::convertToInteger", NM="_ZNK4llvm7APFloat16convertToIntegerEPyjbNS0_12roundingModeEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat16convertToIntegerEPyjbNS0_12roundingModeEPb")
  //</editor-fold>
  public /*APFloat::opStatus*//*uint*/int convertToInteger(ulong$ptr/*uint64_t P*/ parts, /*uint*/int width, 
                  boolean isSigned, 
                  roundingMode rounding_mode, bool$ptr/*bool P*/ isExact) /*const*/ {
    /*opStatus*//*uint*/int fs;
    
    fs = convertToSignExtendedInteger(parts, width, isSigned, rounding_mode, 
        isExact);
    if (fs == opStatus.opInvalidOp) {
      /*uint*/int bits;
      /*uint*/int dstPartsCount;
      
      dstPartsCount = partCountForBits(width);
      if (category == fltCategory.fcNaN) {
        bits = 0;
      } else if (sign) {
        bits = (isSigned ? 1 : 0);
      } else {
        bits = width - (isSigned ? 1 : 0);
      }

      APInt.tcSetLeastSignificantBits(parts, dstPartsCount, bits);
      if (sign && isSigned) {
        APInt.tcShiftLeft(parts, dstPartsCount, width - 1);
      }
    }
  
    return fs;
  }

  
  /* Same as convertToInteger(integerPart*, ...), except the result is returned in
  an APSInt, whose initial bit-width and signed-ness are used to determine the
  precision of the conversion.
  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::convertToInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 2245,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 2242,
   FQN="llvm::APFloat::convertToInteger", NM="_ZNK4llvm7APFloat16convertToIntegerERNS_6APSIntENS0_12roundingModeEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat16convertToIntegerERNS_6APSIntENS0_12roundingModeEPb")
  //</editor-fold>
  public /*APFloat::opStatus*//*uint*/int convertToInteger(final APSInt /*&*/ result, 
                  roundingMode rounding_mode, bool$ptr/*bool P*/ isExact) /*const*/ {
    /*uint*/int bitWidth = result.getBitWidth();
    SmallVectorULong parts/*J*/= new SmallVectorULong(JD$UInt_T$C$R.INSTANCE, 4, result.getNumWords(), 0);
    /*opStatus*//*uint*/int status = convertToInteger(parts.data(), bitWidth, result.isSigned(), rounding_mode, isExact);
    // Keeps the original signed-ness.
    result.$assign(new APInt(bitWidth, new ArrayRefULong(parts)));
    return status;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::convertFromAPInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 2292,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 2289,
   FQN="llvm::APFloat::convertFromAPInt", NM="_ZN4llvm7APFloat16convertFromAPIntERKNS_5APIntEbNS0_12roundingModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat16convertFromAPIntERKNS_5APIntEbNS0_12roundingModeE")
  //</editor-fold>
  public /*APFloat::opStatus*//*uint*/int convertFromAPInt(final /*const*/ APInt /*&*/ Val, 
                  boolean isSigned, 
                  roundingMode rounding_mode) {
    /*uint*/int partCount = Val.getNumWords();
    APInt api = new APInt(Val);
    
    sign = false;
    if (isSigned && api.isNegative()) {
      sign = true;
      api.$assignMove(api.$sub());
    }

    return convertFromUnsignedParts(api.getRawData(), partCount, rounding_mode);
  }
  
  
  /* Convert a two's complement integer SRC to a floating point number,
  rounding according to ROUNDING_MODE.  ISSIGNED is true if the
  integer is signed, in which case it must be sign-extended.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::convertFromSignExtendedInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 2312,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 2309,
   FQN="llvm::APFloat::convertFromSignExtendedInteger", NM="_ZN4llvm7APFloat30convertFromSignExtendedIntegerEPKyjbNS0_12roundingModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat30convertFromSignExtendedIntegerEPKyjbNS0_12roundingModeE")
  //</editor-fold>
  public /*APFloat::opStatus*//*uint*/int convertFromSignExtendedInteger(/*const*/ulong$ptr/*uint64_t P*/ src, 
                                /*uint*/int srcCount, 
                                boolean isSigned, 
                                roundingMode rounding_mode) {
    /*opStatus*//*uint*/int status;
    if (isSigned
       && (APInt.tcExtractBit(src, srcCount * integerPartWidth - 1) != 0)) {
      ulong$ptr/*uint64_t P*/ copy = create_ulong$ptr();
      
      /* If we're signed and negative negate a copy.  */
      sign = true;
      copy = create_ulong$ptr(new$ulong(srcCount));
      APInt.tcAssign(copy, src, srcCount);
      APInt.tcNegate(copy, srcCount);
      status = convertFromUnsignedParts(copy, srcCount, rounding_mode);
      /*delete[]*/Destructors.$destroyArray(copy);
    } else {
      sign = false;
      status = convertFromUnsignedParts(src, srcCount, rounding_mode);
    }

    return status;
  }
  
  
  /* FIXME: should this just take a const APInt reference?  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::convertFromZeroExtendedInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 2340,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 2337,
   FQN="llvm::APFloat::convertFromZeroExtendedInteger", NM="_ZN4llvm7APFloat30convertFromZeroExtendedIntegerEPKyjbNS0_12roundingModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat30convertFromZeroExtendedIntegerEPKyjbNS0_12roundingModeE")
  //</editor-fold>
  public /*APFloat::opStatus*//*uint*/int convertFromZeroExtendedInteger(/*const*/ulong$ptr/*uint64_t P*/ parts, 
                                /*uint*/int width, boolean isSigned, 
                                roundingMode rounding_mode) {
    /*uint*/int partCount = partCountForBits(width);
    APInt api = new APInt(width, makeArrayRef(parts, partCount));
    
    sign = false;
    if (isSigned && (APInt.tcExtractBit(parts, width - 1) != 0)) {
      sign = true;
      api.$assignMove(api.$sub());
    }

    return convertFromUnsignedParts(api.getRawData(), partCount, rounding_mode);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::convertFromString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 2665,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 2662,
   FQN="llvm::APFloat::convertFromString", NM="_ZN4llvm7APFloat17convertFromStringENS_9StringRefENS0_12roundingModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat17convertFromStringENS_9StringRefENS0_12roundingModeE")
  //</editor-fold>
  public /*APFloat::opStatus*//*uint*/int convertFromString(StringRef str, roundingMode rounding_mode) {
    assert (!str.empty()) : "Invalid string length";
    
    // Handle special cases.
    if (convertFromStringSpecials(new StringRef(str))) {
      return opStatus.opOK;
    }
    
    /* Handle a leading minus sign.  */
    char$ptr p = $tryClone(str.begin());
    /*size_t*/int slen = str.size();
    sign = $uint2uint_1bit(p.$star() == $$MINUS ? 1 : 0);
    if (p.$star() == $$MINUS || p.$star() == $$PLUS) {
      p.$postInc();
      slen--;
      assert ((slen != 0)) : "String has no digits";
    }
    if ($greatereq_uint(slen, 2) && p.$at(0) == $$0 && (p.$at(1) == $$x || p.$at(1) == $$X)) {
      assert (((slen - 2) != 0)) : "Invalid string";
      return convertFromHexadecimalString(new StringRef(p.$add(2), slen - 2), 
          rounding_mode);
    }
    
    return convertFromDecimalString(new StringRef(p, slen), rounding_mode);
  }

  
  // This function creates an APInt that is just a bit map of the floating
  // point constant as it would appear in memory.  It is not a conversion,
  // and treating the result as a normal integer is unlikely to be useful.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::bitcastToAPInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3104,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3101,
   FQN="llvm::APFloat::bitcastToAPInt", NM="_ZNK4llvm7APFloat14bitcastToAPIntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat14bitcastToAPIntEv")
  //</editor-fold>
  public APInt bitcastToAPInt() /*const*/ {
    if (semantics == (/*const*/ fltSemantics /*P*/ )$AddrOf(IEEEhalf)) {
      return convertHalfAPFloatToAPInt();
    }
    if (semantics == (/*const*/ fltSemantics /*P*/ )$AddrOf(IEEEsingle)) {
      return convertFloatAPFloatToAPInt();
    }
    if (semantics == (/*const*/ fltSemantics /*P*/ )$AddrOf(IEEEdouble)) {
      return convertDoubleAPFloatToAPInt();
    }
    if (semantics == (/*const*/ fltSemantics /*P*/ )$AddrOf(IEEEquad)) {
      return convertQuadrupleAPFloatToAPInt();
    }
    if (semantics == (/*const*/ fltSemantics /*P*/ )$AddrOf(PPCDoubleDouble)) {
      return convertPPCDoubleDoubleAPFloatToAPInt();
    }
    assert (semantics == (/*const*/ fltSemantics /*P*/ )$AddrOf(x87DoubleExtended)) : "unknown format!";
    return convertF80LongDoubleAPFloatToAPInt();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::convertToDouble">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3136,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3133,
   FQN="llvm::APFloat::convertToDouble", NM="_ZNK4llvm7APFloat15convertToDoubleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat15convertToDoubleEv")
  //</editor-fold>
  public double convertToDouble() /*const*/ {
    assert (semantics == (/*const*/ fltSemantics /*P*/ )$AddrOf(IEEEdouble)) : "Float semantics are not IEEEdouble";
    APInt api = bitcastToAPInt();
    return api.bitsToDouble();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::convertToFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3127,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3124,
   FQN="llvm::APFloat::convertToFloat", NM="_ZNK4llvm7APFloat14convertToFloatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat14convertToFloatEv")
  //</editor-fold>
  public float convertToFloat() /*const*/ {
    assert (semantics == (/*const*/ fltSemantics /*P*/ )$AddrOf(IEEEsingle)) : "Float semantics are not IEEEsingle";
    APInt api = bitcastToAPInt();
    return api.bitsToFloat();
  }

  
  /// @}
  
  /// The definition of equality is not straightforward for floating point, so
  /// we won't use operator==.  Use one of the following, or write whatever it
  /// is you really mean.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 382,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 380,
   FQN="llvm::APFloat::operator==", NM="_ZNK4llvm7APFloateqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloateqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ APFloat /*&*/ $Prm0) /*const*/ { throw new UnsupportedOperationException("Deleted");}

  /// IEEE comparison with another floating point number (NaNs compare
  /// unordered, 0==-0).
  
  /* Comparison requires normalized numbers.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::compare">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1913,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1910,
   FQN="llvm::APFloat::compare", NM="_ZNK4llvm7APFloat7compareERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat7compareERKS0_")
  //</editor-fold>
  public APFloat.cmpResult compare(final /*const*/ APFloat /*&*/ rhs) /*const*/ {
    cmpResult result;
    assert (semantics == rhs.semantics);
    
    switch (((category).getValue() * 4 + (rhs.category).getValue())) {
     default:
      throw new llvm_unreachable(null);
     case fcNaN * 4 + fcZero:
     case fcNaN * 4 + fcNormal:
     case fcNaN * 4 + fcInfinity:
     case fcNaN * 4 + fcNaN:
     case fcZero * 4 + fcNaN:
     case fcNormal * 4 + fcNaN:
     case fcInfinity * 4 + fcNaN:
      return cmpResult.cmpUnordered;
     case fcInfinity * 4 + fcNormal:
     case fcInfinity * 4 + fcZero:
     case fcNormal * 4 + fcZero:
      if (sign) {
        return cmpResult.cmpLessThan;
      } else {
        return cmpResult.cmpGreaterThan;
      }
     case fcNormal * 4 + fcInfinity:
     case fcZero * 4 + fcInfinity:
     case fcZero * 4 + fcNormal:
      if (rhs.sign) {
        return cmpResult.cmpGreaterThan;
      } else {
        return cmpResult.cmpLessThan;
      }
     case fcInfinity * 4 + fcInfinity:
      if (sign == rhs.sign) {
        return cmpResult.cmpEqual;
      } else if (sign) {
        return cmpResult.cmpLessThan;
      } else {
        return cmpResult.cmpGreaterThan;
      }
     case fcZero * 4 + fcZero:
      return cmpResult.cmpEqual;
     case fcNormal * 4 + fcNormal:
      break;
    }

    /* Two normal numbers.  Do they have the same sign?  */
    if (sign != rhs.sign) {
      if (sign) {
        result = cmpResult.cmpLessThan;
      } else {
        result = cmpResult.cmpGreaterThan;
      }
    } else {
      /* Compare absolute values; invert result if negative.  */
      result = compareAbsoluteValue(rhs);
      if (sign) {
        if (result == cmpResult.cmpLessThan) {
          result = cmpResult.cmpGreaterThan;
        } else if (result == cmpResult.cmpGreaterThan) {
          result = cmpResult.cmpLessThan;
        }
      }
    }
  
    return result;
  }

  
  /// Bitwise comparison for equality (QNaNs compare equal, 0!=-0).
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::bitwiseIsEqual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 782,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 779,
   FQN="llvm::APFloat::bitwiseIsEqual", NM="_ZNK4llvm7APFloat14bitwiseIsEqualERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat14bitwiseIsEqualERKS0_")
  //</editor-fold>
  public boolean bitwiseIsEqual(final /*const*/ APFloat /*&*/ rhs) /*const*/ {
    if (this == $AddrOf(rhs)) {
      return true;
    }
    if (semantics != rhs.semantics
       || category != rhs.category
       || sign != rhs.sign) {
      return false;
    }
    if (category == fltCategory.fcZero || category == fltCategory.fcInfinity) {
      return true;
    }
    if (isFiniteNonZero() && exponent != rhs.exponent) {
      return false;
    }

    return std.equal(significandParts$Const(), significandParts$Const().$add(partCount()), 
        rhs.significandParts$Const());
  }
  
  
  /// Write out a hexadecimal representation of the floating point value to DST,
  /// which must be of sufficient size, in the C99 form [-]0xh.hhhhp[+-]d.
  /// Return the number of characters written, excluding the terminating NUL.
  
  /* Write out a hexadecimal representation of the floating point value
  to DST, which must be of sufficient size, in the C99 form
  [-]0xh.hhhhp[+-]d.  Return the number of characters written,
  excluding the terminating NUL.
  
  If UPPERCASE, the output is in upper case, otherwise in lower case.
  
  HEXDIGITS digits appear altogether, rounding the value if
  necessary.  If HEXDIGITS is 0, the minimal precision to display the
  number precisely is used instead.  If nothing would appear after
  the decimal point it is suppressed.
  
  The decimal exponent is always printed and has at least one digit.
  Zero values display an exponent of zero.  Infinities and NaNs
  appear as "infinity" or "nan" respectively.
  
  The above rules are as specified by C99.  There is ambiguity about
  what the leading hexadecimal digit should be.  This implementation
  uses whatever is necessary so that the exponent is displayed as
  stored.  This implies the exponent will fall within the IEEE format
  range, and the leading hexadecimal digit will be 0 (for denormals),
  1 (normal numbers) or 2 (normal numbers rounded-away-from-zero with
  any other digits zero).
  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::convertToHexString">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 2717,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 2714,
   FQN="llvm::APFloat::convertToHexString", NM="_ZNK4llvm7APFloat18convertToHexStringEPcjbNS0_12roundingModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat18convertToHexStringEPcjbNS0_12roundingModeE")
  //</editor-fold>
  public /*uint*/int convertToHexString(char$ptr/*char P*/ dst, /*uint*/int hexDigits, 
                    boolean upperCase, roundingMode rounding_mode) /*const*/ {
    char$ptr/*char P*/ p = create_char$ptr();
    
    p = $tryClone(dst);
    if (sign) {
      dst.$postInc().$set($$MINUS);
    }
    switch (category) {
     case fcInfinity:
      memcpy(dst, upperCase ? infinityU : infinityL, sizeof(infinityU) - 1);
      dst.$inc(sizeof(infinityL) - 1);
      break;
     case fcNaN:
      memcpy(dst, upperCase ? NaNU : NaNL, sizeof(NaNU) - 1);
      dst.$inc(sizeof(NaNU) - 1);
      break;
     case fcZero:
      dst.$postInc().$set($$0);
      dst.$postInc().$set(upperCase ? $$X : $$x);
      dst.$postInc().$set($$0);
      if ($greater_uint(hexDigits, 1)) {
        dst.$postInc().$set($$DOT);
        memset(dst, $$0, hexDigits - 1);
        dst.$inc(hexDigits - 1);
      }
      dst.$postInc().$set(upperCase ? $$P : $$p);
      dst.$postInc().$set($$0);
      break;
     case fcNormal:
      dst = $tryClone(convertNormalToHexString(dst, hexDigits, upperCase, rounding_mode));
      break;
    }

    dst.$set($uint2uchar(0));
  
    return ((/*static_cast*//*uint*/int)(dst.$sub(p)));
  }

  
  /// \name IEEE-754R 5.7.2 General operations.
  /// @{
  
  /// IEEE-754R isSignMinus: Returns true if and only if the current value is
  /// negative.
  ///
  /// This applies to zeros and NaNs as well.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::isNegative">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 404,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 402,
   FQN="llvm::APFloat::isNegative", NM="_ZNK4llvm7APFloat10isNegativeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat10isNegativeEv")
  //</editor-fold>
  public boolean isNegative() /*const*/ {
    return sign;
  }

  
  /// IEEE-754R isNormal: Returns true if and only if the current value is normal.
  ///
  /// This implies that the current value of the float is not zero, subnormal,
  /// infinite, or NaN following the definition of normality from IEEE-754R.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::isNormal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 410,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 408,
   FQN="llvm::APFloat::isNormal", NM="_ZNK4llvm7APFloat8isNormalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat8isNormalEv")
  //</editor-fold>
  public boolean isNormal() /*const*/ {
    return !isDenormal() && isFiniteNonZero();
  }

  
  /// Returns true if and only if the current value is zero, subnormal, or
  /// normal.
  ///
  /// This means that the value is not infinite or NaN.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::isFinite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 416,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 414,
   FQN="llvm::APFloat::isFinite", NM="_ZNK4llvm7APFloat8isFiniteEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat8isFiniteEv")
  //</editor-fold>
  public boolean isFinite() /*const*/ {
    return !isNaN() && !isInfinity();
  }

  
  /// Returns true if and only if the float is plus or minus zero.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::isZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 419,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 417,
   FQN="llvm::APFloat::isZero", NM="_ZNK4llvm7APFloat6isZeroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat6isZeroEv")
  //</editor-fold>
  public boolean isZero() /*const*/ {
    return category == fltCategory.fcZero;
  }

  
  /// IEEE-754R isSubnormal(): Returns true if and only if the float is a
  /// denormal.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::isDenormal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 705,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 702,
   FQN="llvm::APFloat::isDenormal", NM="_ZNK4llvm7APFloat10isDenormalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat10isDenormalEv")
  //</editor-fold>
  public boolean isDenormal() /*const*/ {
    return isFiniteNonZero() && (exponent == semantics.minExponent)
       && (APInt.tcExtractBit(significandParts$Const(), 
        semantics.precision - 1) == 0);
  }

  
  /// IEEE-754R isInfinite(): Returns true if and only if the float is infinity.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::isInfinity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 426,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 424,
   FQN="llvm::APFloat::isInfinity", NM="_ZNK4llvm7APFloat10isInfinityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat10isInfinityEv")
  //</editor-fold>
  public boolean isInfinity() /*const*/ {
    return category == fltCategory.fcInfinity;
  }

  
  /// Returns true if and only if the float is a quiet or signaling NaN.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::isNaN">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 429,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 427,
   FQN="llvm::APFloat::isNaN", NM="_ZNK4llvm7APFloat5isNaNEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat5isNaNEv")
  //</editor-fold>
  public boolean isNaN() /*const*/ {
    return category == fltCategory.fcNaN;
  }

  
  /// Returns true if and only if the float is a signaling NaN.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::isSignaling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3804,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3801,
   FQN="llvm::APFloat::isSignaling", NM="_ZNK4llvm7APFloat11isSignalingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat11isSignalingEv")
  //</editor-fold>
  public boolean isSignaling() /*const*/ {
    if (!isNaN()) {
      return false;
    }
    
    // IEEE-754R 2008 6.2.1: A signaling NaN bit string should be encoded with the
    // first bit of the trailing significand being 0.
    return !(APInt.tcExtractBit(significandParts$Const(), semantics.precision - 2) != 0);
  }

  
  /// @}
  
  /// \name Simple Queries
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::getCategory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 439,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 437,
   FQN="llvm::APFloat::getCategory", NM="_ZNK4llvm7APFloat11getCategoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat11getCategoryEv")
  //</editor-fold>
  public fltCategory getCategory() /*const*/ {
    return category;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::getSemantics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 440,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 438,
   FQN="llvm::APFloat::getSemantics", NM="_ZNK4llvm7APFloat12getSemanticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat12getSemanticsEv")
  //</editor-fold>
  public /*const*/ fltSemantics /*&*/ getSemantics() /*const*/ {
    return $Deref(semantics);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::isNonZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 441,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 439,
   FQN="llvm::APFloat::isNonZero", NM="_ZNK4llvm7APFloat9isNonZeroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat9isNonZeroEv")
  //</editor-fold>
  public boolean isNonZero() /*const*/ {
    return category != fltCategory.fcZero;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::isFiniteNonZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 442,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 440,
   FQN="llvm::APFloat::isFiniteNonZero", NM="_ZNK4llvm7APFloat15isFiniteNonZeroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat15isFiniteNonZeroEv")
  //</editor-fold>
  public boolean isFiniteNonZero() /*const*/ {
    return isFinite() && !isZero();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::isPosZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 443,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 441,
   FQN="llvm::APFloat::isPosZero", NM="_ZNK4llvm7APFloat9isPosZeroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat9isPosZeroEv")
  //</editor-fold>
  public boolean isPosZero() /*const*/ {
    return isZero() && !isNegative();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::isNegZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 444,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 442,
   FQN="llvm::APFloat::isNegZero", NM="_ZNK4llvm7APFloat9isNegZeroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat9isNegZeroEv")
  //</editor-fold>
  public boolean isNegZero() /*const*/ {
    return isZero() && isNegative();
  }

  
  /// Returns true if and only if the number has the smallest possible non-zero
  /// magnitude in the current semantics.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::isSmallest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 712,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 709,
   FQN="llvm::APFloat::isSmallest", NM="_ZNK4llvm7APFloat10isSmallestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat10isSmallestEv")
  //</editor-fold>
  public boolean isSmallest() /*const*/ {
    // The smallest number by magnitude in our format will be the smallest
    // denormal, i.e. the floating point number with exponent being minimum
    // exponent and significand bitwise equal to 1 (i.e. with MSB equal to 0).
    return isFiniteNonZero() && exponent == semantics.minExponent
       && significandMSB() == 0;
  }

  
  /// Returns true if and only if the number has the largest possible finite
  /// magnitude in the current semantics.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::isLargest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 765,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 762,
   FQN="llvm::APFloat::isLargest", NM="_ZNK4llvm7APFloat9isLargestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat9isLargestEv")
  //</editor-fold>
  public boolean isLargest() /*const*/ {
    // The largest number by magnitude in our format will be the floating point
    // number with maximum exponent and with significand that is all ones.
    return isFiniteNonZero() && exponent == semantics.maxExponent
       && isSignificandAllOnes();
  }
  
  
  /// Returns true if and only if the number is an exact integer.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::isInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 773,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 770,
   FQN="llvm::APFloat::isInteger", NM="_ZNK4llvm7APFloat9isIntegerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat9isIntegerEv")
  //</editor-fold>
  public boolean isInteger() /*const*/ {
    // This could be made more efficient; I'm going for obviously correct.
    if (!isFinite()) {
      return false;
  }
    APFloat truncated = new APFloat(/*Deref*/this);
    truncated.roundToIntegral(roundingMode.rmTowardZero);
    return compare(truncated) == cmpResult.cmpEqual;
  }
  
  
  /// @}
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 677,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 674,
   FQN="llvm::APFloat::operator=", NM="_ZN4llvm7APFloataSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloataSERKS0_")
  //</editor-fold>
  public APFloat /*&*/ $assign(final /*const*/ APFloat /*&*/ rhs) {
    if (this != $AddrOf(rhs)) {
      if (semantics != rhs.semantics) {
        freeSignificand();
        initialize(rhs.semantics);
      }
      assign(rhs);
    }
    
    return /*Deref*/this;
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::operator=">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 691,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 688,
   FQN="llvm::APFloat::operator=", NM="_ZN4llvm7APFloataSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloataSEOS0_")
  //</editor-fold>
  public APFloat /*&*/ $assignMove(final APFloat /*&&*/rhs) {
    assert this != rhs;
    freeSignificand();
    
    semantics = rhs.semantics;
    significand.$assign(rhs.significand);
    exponent = rhs.exponent;
    category = rhs.category;
    sign = rhs.sign;
    
    rhs.semantics = $AddrOf(Bogus);
    return /*Deref*/this;
  }

  
  /// \brief Overload to compute a hash code for an APFloat value.
  ///
  /// Note that the use of hash codes for floating point values is in general
  /// frought with peril. Equality is hard to define for these values. For
  /// example, should negative and positive zero hash to different codes? Are
  /// they equal or not? This hash value implementation specifically
  /// emphasizes producing different codes for different inputs in order to
  /// be used in canonicalization and memoization. As such, equality is
  /// bitwiseIsEqual, and 0 != -0.
  /*friend hash_code hash_value(const APFloat &Arg)*/
  
  /// Converts this value into a decimal string.
  ///
  /// \param FormatPrecision The maximum number of digits of
  ///   precision to output.  If there are fewer digits available,
  ///   zero padding will not be used unless the value is
  ///   integral and small enough to be expressed in
  ///   FormatPrecision digits.  0 means to use the natural
  ///   precision of the number.
  /// \param FormatMaxPadding The maximum number of zeros to
  ///   consider inserting before falling back to scientific
  ///   notation.  0 means to always use scientific notation.
  ///
  /// Number       Precision    MaxPadding      Result
  /// ------       ---------    ----------      ------
  /// 1.01E+4              5             2       10100
  /// 1.01E+4              4             2       1.01E+4
  /// 1.01E+4              5             1       1.01E+4
  /// 1.01E-2              5             2       0.0101
  /// 1.01E-2              4             2       0.0101
  /// 1.01E-2              4             1       1.01E-2
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::toString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3572,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3569,
   FQN="llvm::APFloat::toString", NM="_ZNK4llvm7APFloat8toStringERNS_15SmallVectorImplIcEEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat8toStringERNS_15SmallVectorImplIcEEjj")
  //</editor-fold>
  public void __toString(final SmallString/*&*/ Str) /*const*/ {
    __toString(Str, 
            0, 
            3);
  }
  public void __toString(final SmallString/*&*/ Str, 
            /*uint*/int FormatPrecision/*= 0*/) /*const*/ {
    __toString(Str, 
            FormatPrecision, 
            3);
  }
  public void __toString(final SmallString/*&*/ Str, 
            /*uint*/int FormatPrecision/*= 0*/, 
            /*uint*/int FormatMaxPadding/*= 3*/) /*const*/ {
    switch (category) {
     case fcInfinity:
      if (isNegative()) {
        append(Str, new StringRef(/*KEEP_STR*/"-Inf"));
        /*JAVA:return*/return;
      } else {
        append(Str, new StringRef(/*KEEP_STR*/"+Inf"));
        /*JAVA:return*/return;
      }
     case fcNaN:
      append(Str, new StringRef(/*KEEP_STR*/"NaN"));
      /*JAVA:return*/return;
     case fcZero:
      if (isNegative()) {
        Str.push_back($$MINUS);
      }
      if (!(FormatMaxPadding != 0)) {
        append(Str, new StringRef(/*KEEP_STR*/"0.0E+0"));
      } else {
        Str.push_back($$0);
      }
      return;
     case fcNormal:
      break;
    }
    if (isNegative()) {
      Str.push_back($$MINUS);
    }

    // Decompose the number into an APInt and an exponent.
    int$ref exp = create_int$ref(exponent - ((int)semantics.precision - 1));
    APInt significand/*J*/= new APInt(semantics.precision, 
        makeArrayRef(significandParts$Const(), 
            partCountForBits(semantics.precision)));
  
    // Set FormatPrecision if zero.  We want to do this before we
    // truncate trailing zeros, as those are part of the precision.
    if (!(FormatPrecision != 0)) {
      // We use enough digits so the number can be round-tripped back to an
      // APFloat. The formula comes from "How to Print Floating-Point Numbers
      // Accurately" by Steele and White.
      // FIXME: Using a formula based purely on the precision is conservative;
      // we can print fewer digits depending on the actual value being printed.
      
      // FormatPrecision = 2 + floor(significandBits / lg_2(10))
      FormatPrecision = 2 + $div_uint(semantics.precision * 59, 196);
    }
    
    // Ignore trailing binary zeros.
    int trailingZeros = significand.countTrailingZeros();
    exp.$set$addassign(trailingZeros);
    significand.$assignMove(significand.lshr(trailingZeros));
    
    // Change the exponent from 2^e to 10^e.
    if (exp.$deref() == 0) {
      // Nothing to do.
    } else if (exp.$deref() > 0) {
      // Just shift left.
      significand.$assignMove(significand.zext(semantics.precision + exp.$deref()));
      significand.$lshiftassign(exp.$deref());
      exp.$set(0);
    } else { /* exp < 0 */
      int texp = -exp.$deref();
      
      // We transform this using the identity:
      //   (N)(2^-e) == (N)(5^e)(10^-e)
      // This means we have to multiply N (the significand) by 5^e.
      // To avoid overflow, we have to operate on numbers large
      // enough to store N * 5^e:
      //   log2(N * 5^e) == log2(N) + e * log2(5)
      //                 <= semantics->precision + e * 137 / 59
      //   (log_2(5) ~ 2.321928 < 2.322034 ~ 137/59)
      /*uint*/int precision = semantics.precision + (137 * texp + 136) / 59;
      
      // Multiply significand by 5^e.
      //   N * 5^0101 == N * 5^(1*1) * 5^(0*2) * 5^(1*4) * 5^(0*8)
      significand.$assignMove(significand.zext(precision));
      APInt five_to_the_i/*J*/= new APInt(precision, $int2ulong(5));
      while (true) {
        if (((texp & 1) != 0)) {
          significand.$starassign(five_to_the_i);
        }
        
        texp >>= 1;
        if (!(texp != 0)) {
          break;
        }
        five_to_the_i.$starassign(five_to_the_i);
      }
    }
    
    AdjustToPrecision(significand, exp, FormatPrecision);
    
    SmallString buffer/*J*/= new SmallString(256);
    
    // Fill the buffer.
    /*uint*/int precision = significand.getBitWidth();
    APInt ten/*J*/= new APInt(precision, $int2ulong(10));
    APInt digit/*J*/= new APInt(precision, $int2ulong(0));
    
    boolean inTrail = true;
    while (significand.$noteq($int2ulong(0))) {
      // digit <- significand % 10
      // significand <- significand / 10
      APInt.udivrem(significand, ten, significand, digit);
      
      /*uint*/int d = $ulong2uint(digit.getZExtValue());
      
      // Drop trailing zeros.
      if (inTrail && !(d != 0)) {
        exp.$set$postInc();
      } else {
        buffer.push_back((/*char*/byte)$uint2char(($char2uint($$0) + d)));
        inTrail = false;
      }
    }
    assert (!buffer.empty()) : "no characters in buffer!";
    
    // Drop down to FormatPrecision.
    // TODO: don't do more precise calculations above than are required.
    AdjustToPrecision(buffer, exp, FormatPrecision);
    
    /*uint*/int NDigits = buffer.size();
    
    // Check whether we should use scientific notation.
    boolean FormatScientific;
    if (!(FormatMaxPadding != 0)) {
      FormatScientific = true;
    } else {
      if (exp.$deref() >= 0) {
        // 765e3 --> 765000
        //              ^^^
        // But we shouldn't make the number look more precise than it is.
        FormatScientific = ($greater_uint((/*uint*/int)exp.$deref(), FormatMaxPadding)
           || $greater_uint(NDigits + (/*uint*/int)exp.$deref(), FormatPrecision));
      } else {
        // Power of the most significant digit.
        int MSD = exp.$deref() + (int)(NDigits - 1);
        if (MSD >= 0) {
          // 765e-2 == 7.65
          FormatScientific = false;
        } else {
          // 765e-5 == 0.00765
          //           ^ ^^
          FormatScientific = $greater_uint(((/*uint*/int)-MSD), FormatMaxPadding);
        }
      }
    }
    
    // Scientific formatting is pretty straightforward.
    if (FormatScientific) {
      exp.$set$addassign((NDigits - 1));
      
      Str.push_back(buffer.$at(NDigits - 1));
      Str.push_back($$DOT);
      if (NDigits == 1) {
        Str.push_back($$0);
      } else {
        for (/*uint*/int I = 1; I != NDigits; ++I)  {
          Str.push_back(buffer.$at(NDigits - 1 - I));
        }
      }
      Str.push_back($$E);
      
      Str.push_back(exp.$deref() >= 0 ? $$PLUS : $$MINUS);
      if (exp.$deref() < 0) {
        exp.$set(-exp.$deref());
      }
      SmallString expbuf/*J*/= new SmallString(6);
      do {
        expbuf.push_back((/*char*/byte)($$0 + (exp.$deref() % 10)));
        exp.$set$slashassign(10);
      } while ((exp.$deref() != 0));
      for (/*uint*/int I = 0, E = expbuf.size(); I != E; ++I)  {
        Str.push_back(expbuf.$at(E - 1 - I));
      }
      return;
    }
    
    // Non-scientific, positive exponents.
    if (exp.$deref() >= 0) {
      for (/*uint*/int I = 0; I != NDigits; ++I)  {
        Str.push_back(buffer.$at(NDigits - 1 - I));
      }
      for (/*uint*/int I = 0; I != (/*uint*/int)exp.$deref(); ++I)  {
        Str.push_back($$0);
      }
      return;
    }
    
    // Non-scientific, negative exponents.
    
    // The number of digits to the left of the decimal point.
    int NWholeDigits = exp.$deref() + (int)NDigits;
    
    /*uint*/int I = 0;
    if (NWholeDigits > 0) {
      for (; I != (/*uint*/int)NWholeDigits; ++I)  {
        Str.push_back(buffer.$at(NDigits - I - 1));
      }
      Str.push_back($$DOT);
    } else {
      /*uint*/int NZeros = 1 + (/*uint*/int)-NWholeDigits;
      
      Str.push_back($$0);
      Str.push_back($$DOT);
      for (/*uint*/int Z = 1; Z != NZeros; ++Z)  {
        Str.push_back($$0);
      }
    }
    
    for (; I != NDigits; ++I)  {
      Str.push_back(buffer.$at(NDigits - I - 1));
    }
  }

  
  /// If this value has an exact multiplicative inverse, store it in inv and
  /// return true.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::getExactInverse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3775,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3772,
   FQN="llvm::APFloat::getExactInverse", NM="_ZNK4llvm7APFloat15getExactInverseEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat15getExactInverseEPS0_")
  //</editor-fold>
  public boolean getExactInverse(APFloat /*P*/ inv) /*const*/ {
    // Special floats and denormals have no exact inverse.
    if (!isFiniteNonZero()) {
      return false;
    }

    // Check that the number is a power of two by making sure that only the
    // integer bit is set in the significand.
    if (significandLSB() != semantics.precision - 1) {
      return false;
    }
    
    // Get the inverse.
    APFloat reciprocal/*J*/= new APFloat($Deref(semantics), 1L/*ULL*/);
    if (reciprocal.divide(/*Deref*/this, roundingMode.rmNearestTiesToEven) != opStatus.opOK) {
      return false;
    }
    
    // Avoid multiplication with a denormal, it is not safe on all platforms and
    // may be slower than a normal division.
    if (reciprocal.isDenormal()) {
      return false;
    }
    assert (reciprocal.isFiniteNonZero() && reciprocal.significandLSB() == reciprocal.semantics.precision - 1);
    if ((inv != null)) {
      /*Deref*/inv.$assign(reciprocal);
    }
    
    return true;
  }

  
  /// \brief Enumeration of \c ilogb error results.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::IlogbErrorKinds">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 501,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 499,
   FQN="llvm::APFloat::IlogbErrorKinds", NM="_ZN4llvm7APFloat15IlogbErrorKindsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat15IlogbErrorKindsE")
  //</editor-fold>
  public enum IlogbErrorKinds implements Native.ComparableLower {
    IEK_Zero(INT_MIN + 1),
    IEK_NaN(INT_MIN),
    IEK_Inf(INT_MAX);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static IlogbErrorKinds valueOf(int val) {
      IlogbErrorKinds out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final IlogbErrorKinds[] VALUES;
      private static final IlogbErrorKinds[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (IlogbErrorKinds kind : IlogbErrorKinds.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new IlogbErrorKinds[min < 0 ? (1-min) : 0];
        VALUES = new IlogbErrorKinds[max >= 0 ? (1+max) : 0];
        for (IlogbErrorKinds kind : IlogbErrorKinds.values()) {
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

    private final int value;
    private IlogbErrorKinds(int val) { this.value = (int)val;}
    public int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_int(value, ((IlogbErrorKinds)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_int(value, ((IlogbErrorKinds)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Returns the exponent of the internal representation of the APFloat.
  ///
  /// Because the radix of APFloat is 2, this is equivalent to floor(log2(x)).
  /// For special APFloat values, this returns special error codes:
  ///
  ///   NaN -> \c IEK_NaN
  ///   0   -> \c IEK_Zero
  ///   Inf -> \c IEK_Inf
  ///
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public static int ilogb(/*const*/ APFloat /*&*/Arg) {
    if (Arg.isNaN())
      return IlogbErrorKinds.IEK_NaN.getValue();
    if (Arg.isZero())
      return IlogbErrorKinds.IEK_Zero.getValue();
    if (Arg.isInfinity())
      return IlogbErrorKinds.IEK_Inf.getValue();
    return Arg.exponent;
  }
    
  /*friend int ilogb(const APFloat &Arg)*/
  
  /// \brief Returns: X * 2^Exp for integral exponents.
  /*friend APFloat scalbn(APFloat X, int Exp, roundingMode)*/
  
  /*friend APFloat frexp(const APFloat &X, int &Exp, roundingMode)*/
/*private:*/
  
  /// \name Simple Queries
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::significandParts">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*in-out*/,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 878,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 875,
   FQN="llvm::APFloat::significandParts", NM="_ZN4llvm7APFloat16significandPartsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat16significandPartsEv")
  //</editor-fold>
  private ulong$ptr/*uint64_t P*/ significandParts() {
    if ($greater_uint(partCount(), 1)) {
      return significand.parts;
    } else {
      return new ulong$ptr$inout(significand) {       
        @Override protected /*ulong*/long $star$impl() { return significand.part; }

        @Override protected /*ulong*/long $set$impl(/*ulong*/long value) { 
          return significand.part = value;
        }
      };
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::significandParts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 872,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 869,
   FQN="llvm::APFloat::significandParts", NM="_ZNK4llvm7APFloat16significandPartsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat16significandPartsEv")
  //</editor-fold>
  /*friend*/public /*const*/ulong$ptr/*uint64_t P*/ significandParts$Const() /*const*/ {
    return ((/*const_cast*/APFloat /*P*/ )(this)).significandParts();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::partCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 845,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 842,
   FQN="llvm::APFloat::partCount", NM="_ZNK4llvm7APFloat9partCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat9partCountEv")
  //</editor-fold>
  /*friend*/public /*uint*/int partCount() /*const*/ {
    return partCountForBits(semantics.precision + 1);
  }

  
  /// @}
  
  /// \name Significand operations.
  /// @{
  
  /* Add the significand of the RHS.  Returns the carry flag.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::addSignificand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 907,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 904,
   FQN="llvm::APFloat::addSignificand", NM="_ZN4llvm7APFloat14addSignificandERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat14addSignificandERKS0_")
  //</editor-fold>
  private long/*uint64_t*/ addSignificand(final /*const*/ APFloat /*&*/ rhs) {
    ulong$ptr/*uint64_t P*/ parts = create_ulong$ptr();
    
    parts = $tryClone(significandParts());
    assert (semantics == rhs.semantics);
    assert (exponent == rhs.exponent);
    
    return APInt.tcAdd(parts, rhs.significandParts$Const(), $int2ulong(0), partCount());
  }

  
  /* Subtract the significand of the RHS with a borrow flag.  Returns
  the borrow flag.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::subtractSignificand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 922,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 919,
   FQN="llvm::APFloat::subtractSignificand", NM="_ZN4llvm7APFloat19subtractSignificandERKS0_y",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat19subtractSignificandERKS0_y")
  //</editor-fold>
  private long/*uint64_t*/ subtractSignificand(final /*const*/ APFloat /*&*/ rhs, long/*uint64_t*/ borrow) {
    ulong$ptr/*uint64_t P*/ parts = create_ulong$ptr();
    
    parts = $tryClone(significandParts());
    assert (semantics == rhs.semantics);
    assert (exponent == rhs.exponent);
    
    return APInt.tcSubtract(parts, rhs.significandParts$Const(), borrow, 
        partCount());
  }

  
  /* Add or subtract two normal numbers.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::addOrSubtractSignificand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1448,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1445,
   FQN="llvm::APFloat::addOrSubtractSignificand", NM="_ZN4llvm7APFloat24addOrSubtractSignificandERKS0_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat24addOrSubtractSignificandERKS0_b")
  //</editor-fold>
  private lostFraction addOrSubtractSignificand(final /*const*/ APFloat /*&*/ rhs, boolean subtract) {
    long/*uint64_t*/ carry;
    lostFraction lost_fraction;
    int bits;
    
    /* Determine if the operation on the absolute values is effectively
    an addition or subtraction.  */
    subtract ^= ((/*static_cast*/boolean)(($bool2uint(sign ^ rhs.sign) != 0)));
    
    /* Are we bigger exponent-wise than the RHS?  */
    bits = exponent - rhs.exponent;
    
    /* Subtraction is more subtle than one might naively expect.  */
    if (subtract) {
      APFloat temp_rhs/*J*/= new APFloat(rhs);
      boolean reverse;
      if (bits == 0) {
        reverse = compareAbsoluteValue(temp_rhs) == cmpResult.cmpLessThan;
        lost_fraction = lostFraction.lfExactlyZero;
      } else if (bits > 0) {
        lost_fraction = temp_rhs.shiftSignificandRight(bits - 1);
        shiftSignificandLeft(1);
        reverse = false;
      } else {
        lost_fraction = shiftSignificandRight(-bits - 1);
        temp_rhs.shiftSignificandLeft(1);
        reverse = true;
      }
      if (reverse) {
        carry = temp_rhs.subtractSignificand(/*Deref*/this, ((lost_fraction != lostFraction.lfExactlyZero) ? 1 : 0));
        copySignificand(temp_rhs);
        sign = !sign;
      } else {
        carry = subtractSignificand(temp_rhs, ((lost_fraction != lostFraction.lfExactlyZero) ? 1 : 0));
      }

      /* Invert the lost fraction - it was on the RHS and
      subtracted.  */
      if (lost_fraction == lostFraction.lfLessThanHalf) {
        lost_fraction = lostFraction.lfMoreThanHalf;
      } else if (lost_fraction == lostFraction.lfMoreThanHalf) {
        lost_fraction = lostFraction.lfLessThanHalf;
      }
  
      /* The code above is intended to ensure that no borrow is
      necessary.  */
      assert (!(carry != 0));
      ///*J:(void)*/carry;
    } else {
      if (bits > 0) {
        APFloat temp_rhs/*J*/= new APFloat(rhs);
        
        lost_fraction = temp_rhs.shiftSignificandRight(bits);
        carry = addSignificand(temp_rhs);
      } else {
        lost_fraction = shiftSignificandRight(-bits);
        carry = addSignificand(rhs);
      }
      
      /* We have a guard bit; generating a carry cannot happen.  */
      assert (!(carry != 0));
      ///*J:(void)*/carry;
    }
    
    return lost_fraction;
  }

  
  /* Multiply the significand of the RHS.  If ADDEND is non-NULL, add it
  on to the full-precision result of the multiplication.  Returns the
  lost fraction.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::multiplySignificand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 939,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 936,
   FQN="llvm::APFloat::multiplySignificand", NM="_ZN4llvm7APFloat19multiplySignificandERKS0_PS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat19multiplySignificandERKS0_PS1_")
  //</editor-fold>
  private lostFraction multiplySignificand(final /*const*/ APFloat /*&*/ rhs, /*const*/ APFloat /*P*/ addend) {
    /*uint*/int omsb; // One, not zero, based MSB.
    /*uint*/int partsCount;
    /*uint*/int newPartsCount;
    /*uint*/int precision;
    ulong$ptr/*uint64_t P*/ lhsSignificand = create_ulong$ptr();
    long/*uint64_t*/ scratch[/*4*/] = new$ulong(4);
    ulong$ptr/*uint64_t P*/ fullSignificand = create_ulong$ptr();
    lostFraction lost_fraction;
    bool$ptr ignored = create_bool$ptr();
    assert (semantics == rhs.semantics);
    
    precision = semantics.precision;
    
    // Allocate space for twice as many bits as the original significand, plus one
    // extra bit for the addition to overflow into.
    newPartsCount = partCountForBits(precision * 2 + 1);
    if ($greater_uint(newPartsCount, 4)) {
      fullSignificand = create_ulong$ptr(new$ulong(newPartsCount));
    } else {
      fullSignificand = $tryClone(create_ulong$ptr(scratch));
    }

    lhsSignificand = $tryClone(significandParts());
    partsCount = partCount();
  
    APInt.tcFullMultiply(fullSignificand, lhsSignificand, 
        rhs.significandParts$Const(), partsCount, partsCount);
    
    lost_fraction = lostFraction.lfExactlyZero;
    omsb = APInt.tcMSB(fullSignificand, newPartsCount) + 1;
    exponent += rhs.exponent;
    
    // Assume the operands involved in the multiplication are single-precision
    // FP, and the two multiplicants are:
    //   *this = a23 . a22 ... a0 * 2^e1
    //     rhs = b23 . b22 ... b0 * 2^e2
    // the result of multiplication is:
    //   *this = c48 c47 c46 . c45 ... c0 * 2^(e1+e2)
    // Note that there are three significant bits at the left-hand side of the 
    // radix point: two for the multiplication, and an overflow bit for the
    // addition (that will always be zero at this point). Move the radix point
    // toward left by two bits, and adjust exponent accordingly.
    exponent += 2;
    if ((addend != null) && addend.isNonZero()) {
      // The intermediate result of the multiplication has "2 * precision" 
      // signicant bit; adjust the addend to be consistent with mul result.
      //
      Significand savedSignificand = new Significand(significand);
      /*const*/ fltSemantics /*P*/ savedSemantics = semantics;
      fltSemantics extendedSemantics/*J*/= new fltSemantics();
      /*opStatus*//*uint*/int status;
      /*uint*/int extendedPrecision;
      
      // Normalize our MSB to one below the top bit to allow for overflow.
      extendedPrecision = 2 * precision + 1;
      if (omsb != extendedPrecision - 1) {
        assert ($greater_uint(extendedPrecision, omsb));
        APInt.tcShiftLeft(fullSignificand, newPartsCount, 
            (extendedPrecision - 1) - omsb);
        exponent -= (extendedPrecision - 1) - omsb;
      }
      
      /* Create new semantics.  */
      extendedSemantics.$assign($Deref(semantics));
      extendedSemantics.precision = extendedPrecision;
      if (newPartsCount == 1) {
        significand.part = fullSignificand.$at(0);
      } else {
        significand.parts = $tryClone(fullSignificand);
      }
      semantics = $AddrOf(extendedSemantics);
      
      APFloat extendedAddend/*J*/= new APFloat($Deref(addend));
      status = extendedAddend.convert(extendedSemantics, roundingMode.rmTowardZero, $AddrOf(ignored));
      assert (status == opStatus.opOK);
      ///*J:(void)*/status;
      
      // Shift the significand of the addend right by one bit. This guarantees
      // that the high bit of the significand is zero (same as fullSignificand),
      // so the addition will overflow (if it does overflow at all) into the top bit.
      lost_fraction = extendedAddend.shiftSignificandRight(1);
      assert (lost_fraction == lostFraction.lfExactlyZero) : "Lost precision while shifting addend for fused-multiply-add.";
      
      lost_fraction = addOrSubtractSignificand(extendedAddend, false);
      
      /* Restore our state.  */
      if (newPartsCount == 1) {
        fullSignificand.$set(0, significand.part);
      }
      significand.$assign(savedSignificand);
      semantics = savedSemantics;
      
      omsb = APInt.tcMSB(fullSignificand, newPartsCount) + 1;
    }
    
    // Convert the result having "2 * precision" significant-bits back to the one
    // having "precision" significant-bits. First, move the radix point from 
    // poision "2*precision - 1" to "precision - 1". The exponent need to be
    // adjusted by "2*precision - 1" - "precision - 1" = "precision".
    exponent -= precision + 1;
    
    // In case MSB resides at the left-hand side of radix point, shift the
    // mantissa right by some amount to make sure the MSB reside right before
    // the radix point (i.e. "MSB . rest-significant-bits").
    //
    // Note that the result is not normalized when "omsb < precision". So, the
    // caller needs to call APFloat::normalize() if normalized value is expected.
    if ($greater_uint(omsb, precision)) {
      /*uint*/int bits;
      /*uint*/int significantParts;
      lostFraction lf;
      
      bits = omsb - precision;
      significantParts = partCountForBits(omsb);
      lf = shiftRight(fullSignificand, significantParts, bits);
      lost_fraction = combineLostFractions(lf, lost_fraction);
      exponent += bits;
    }
    
    APInt.tcAssign(lhsSignificand, fullSignificand, partsCount);
    if ($greater_uint(newPartsCount, 4)) {
      /*delete[]*/Destructors.$destroyArray(fullSignificand);
    }
    
    return lost_fraction;
  }

  
  /* Multiply the significands of LHS and RHS to DST.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::divideSignificand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1069,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1066,
   FQN="llvm::APFloat::divideSignificand", NM="_ZN4llvm7APFloat17divideSignificandERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat17divideSignificandERKS0_")
  //</editor-fold>
  private lostFraction divideSignificand(final /*const*/ APFloat /*&*/ rhs) {
    /*uint*/int bit;
    /*uint*/int i;
    /*uint*/int partsCount;
    /*const*/ulong$ptr/*uint64_t P*/ rhsSignificand;
    ulong$ptr/*uint64_t P*/ lhsSignificand = create_ulong$ptr();
    ulong$ptr/*uint64_t P*/ dividend = create_ulong$ptr();
    ulong$ptr/*uint64_t P*/ divisor = create_ulong$ptr();
    long/*uint64_t*/ scratch[/*4*/] = new$ulong(4);
    lostFraction lost_fraction;
    assert (semantics == rhs.semantics);
    
    lhsSignificand = $tryClone(significandParts());
    rhsSignificand = $tryClone(rhs.significandParts$Const());
    partsCount = partCount();
    if ($greater_uint(partsCount, 2)) {
      dividend = create_ulong$ptr(new$ulong(partsCount * 2));
    } else {
      dividend = $tryClone(create_ulong$ptr(scratch));
    }

    divisor = $tryClone(dividend.$add(partsCount));
  
    /* Copy the dividend and divisor as they will be modified in-place.  */
    for (i = 0; $less_uint(i, partsCount); i++) {
      dividend.$set(i, lhsSignificand.$at(i));
      divisor.$set(i, rhsSignificand.$at(i));
      lhsSignificand.$set(i, $int2ulong(0));
    }
    
    exponent -= rhs.exponent;
    
    /*uint*/int precision = semantics.precision;
    
    /* Normalize the divisor.  */
    bit = precision - APInt.tcMSB(divisor, partsCount) - 1;
    if ((bit != 0)) {
      exponent += bit;
      APInt.tcShiftLeft(divisor, partsCount, bit);
    }
    
    /* Normalize the dividend.  */
    bit = precision - APInt.tcMSB(dividend, partsCount) - 1;
    if ((bit != 0)) {
      exponent -= bit;
      APInt.tcShiftLeft(dividend, partsCount, bit);
    }
    
    /* Ensure the dividend >= divisor initially for the loop below.
    Incidentally, this means that the division loop below is
    guaranteed to set the integer bit to one.  */
    if (APInt.tcCompare(dividend, divisor, partsCount) < 0) {
      exponent--;
      APInt.tcShiftLeft(dividend, partsCount, 1);
      assert (APInt.tcCompare(dividend, divisor, partsCount) >= 0);
    }
    
    /* Long division.  */
    for (bit = precision; (bit != 0); bit -= 1) {
      if (APInt.tcCompare(dividend, divisor, partsCount) >= 0) {
        APInt.tcSubtract(dividend, divisor, $int2ulong(0), partsCount);
        APInt.tcSetBit(lhsSignificand, bit - 1);
      }
      
      APInt.tcShiftLeft(dividend, partsCount, 1);
    }
    
    /* Figure out the lost fraction.  */
    int cmp = APInt.tcCompare(dividend, divisor, partsCount);
    if (cmp > 0) {
      lost_fraction = lostFraction.lfMoreThanHalf;
    } else if (cmp == 0) {
      lost_fraction = lostFraction.lfExactlyHalf;
    } else if (APInt.tcIsZero(dividend, partsCount)) {
      lost_fraction = lostFraction.lfExactlyZero;
    } else {
      lost_fraction = lostFraction.lfLessThanHalf;
    }
    if ($greater_uint(partsCount, 2)) {
      /*delete[]*/Destructors.$destroyArray(dividend);
    }
    
    return lost_fraction;
  }

  
  /* Increment an fcNormal floating point number's significand.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::incrementSignificand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 894,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 891,
   FQN="llvm::APFloat::incrementSignificand", NM="_ZN4llvm7APFloat20incrementSignificandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat20incrementSignificandEv")
  //</editor-fold>
  private void incrementSignificand() {
    long/*uint64_t*/ carry;
    
    carry = APInt.tcIncrement(significandParts(), partCount());
    
    /* Our callers should never cause us to overflow.  */
    assert (carry == $int2ullong(0));
    ///*J:(void)*/carry;
  }

  
  /* Constructors.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::initialize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 580,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 577,
   FQN="llvm::APFloat::initialize", NM="_ZN4llvm7APFloat10initializeEPKNS_12fltSemanticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat10initializeEPKNS_12fltSemanticsE")
  //</editor-fold>
  private void initialize(/*const*/ fltSemantics /*P*/ ourSemantics) {
    /*uint*/int count;
    
    semantics = ourSemantics;
    count = partCount();
    if ($greater_uint(count, 1)) {
      significand.parts = create_ulong$ptr(new$ulong(count));
    }
  }

  
  /* Shift the significand left BITS bits, subtract BITS from its exponent.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::shiftSignificandLeft">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1178,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1175,
   FQN="llvm::APFloat::shiftSignificandLeft", NM="_ZN4llvm7APFloat20shiftSignificandLeftEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat20shiftSignificandLeftEj")
  //</editor-fold>
  private void shiftSignificandLeft(/*uint*/int bits) {
    assert ($less_uint(bits, semantics.precision));
    if ((bits != 0)) {
      /*uint*/int partsCount = partCount();
      
      APInt.tcShiftLeft(significandParts(), partsCount, bits);
      exponent -= bits;
      assert (!APInt.tcIsZero(significandParts(), partsCount));
    }
  }

  
  /* Note that a zero result is NOT normalized to fcZero.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::shiftSignificandRight">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*removed conversion in assert*/,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1166,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1163,
   FQN="llvm::APFloat::shiftSignificandRight", NM="_ZN4llvm7APFloat21shiftSignificandRightEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat21shiftSignificandRightEj")
  //</editor-fold>
  private lostFraction shiftSignificandRight(/*uint*/int bits) {
    /* Our exponent should not overflow.  */
    assert ((short)/*$uint2short*/((/*$short2uint*/(exponent) + bits)) >= exponent);
    
    exponent += bits;
    
    return shiftRight(significandParts(), partCount(), bits);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::significandLSB">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1159,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1156,
   FQN="llvm::APFloat::significandLSB", NM="_ZNK4llvm7APFloat14significandLSBEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat14significandLSBEv")
  //</editor-fold>
  private /*uint*/int significandLSB() /*const*/ {
    return APInt.tcLSB(significandParts$Const(), partCount());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::significandMSB">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1153,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1150,
   FQN="llvm::APFloat::significandMSB", NM="_ZNK4llvm7APFloat14significandMSBEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat14significandMSBEv")
  //</editor-fold>
  private /*uint*/int significandMSB() /*const*/ {
    return APInt.tcMSB(significandParts$Const(), partCount());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::zeroSignificand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 887,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 884,
   FQN="llvm::APFloat::zeroSignificand", NM="_ZN4llvm7APFloat15zeroSignificandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat15zeroSignificandEv")
  //</editor-fold>
  private void zeroSignificand() {
    APInt.tcSet(significandParts(), $int2ulong(0), partCount());
  }

  /// Return true if the significand excluding the integral bit is all ones.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::isSignificandAllOnes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 721,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 718,
   FQN="llvm::APFloat::isSignificandAllOnes", NM="_ZNK4llvm7APFloat20isSignificandAllOnesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat20isSignificandAllOnesEv")
  //</editor-fold>
  private boolean isSignificandAllOnes() /*const*/ {
    // Test if the significand excluding the integral bit is all ones. This allows
    // us to test for binade boundaries.
    /*const*/ulong$ptr/*uint64_t P*/ Parts = $tryClone(significandParts$Const());
    /*const*//*uint*/int PartCount = partCount();
    for (/*uint*/int i = 0; $less_uint(i, PartCount - 1); i++)  {
      if (((~Parts.$at(i)) != 0)) {
        return false;
      }
    }

    // Set the unused high bits to all ones when we compare.
    /*const*//*uint*/int NumHighBits = PartCount * integerPartWidth - semantics.precision + 1;
    assert ($lesseq_uint(NumHighBits, integerPartWidth)) : "Can not have more high bits to fill than integerPartWidth";
    /*const*/long/*uint64_t*/ HighBitFill = ~((long/*uint64_t*/)($int2ulong(0))) << (integerPartWidth - NumHighBits);
    if (((~(Parts.$at(PartCount - 1) | HighBitFill)) != 0)) {
      return false;
    }
    
    return true;
  }

  /// Return true if the significand excluding the integral bit is all zeros.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::isSignificandAllZeros">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 743,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 740,
   FQN="llvm::APFloat::isSignificandAllZeros", NM="_ZNK4llvm7APFloat21isSignificandAllZerosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat21isSignificandAllZerosEv")
  //</editor-fold>
  private boolean isSignificandAllZeros() /*const*/ {
    // Test if the significand excluding the integral bit is all zeros. This
    // allows us to test for binade boundaries.
    /*const*/ulong$ptr/*uint64_t P*/ Parts = $tryClone(significandParts$Const());
    /*const*//*uint*/int PartCount = partCount();
    
    for (/*uint*/int i = 0; $less_uint(i, PartCount - 1); i++)  {
      if ((Parts.$at(i) != 0)) {
        return false;
      }
    }

    /*const*//*uint*/int NumHighBits = PartCount * integerPartWidth - semantics.precision + 1;
    assert ($lesseq_uint(NumHighBits, integerPartWidth)) : "Can not have more high bits to clear than integerPartWidth";
    /*const*/long/*uint64_t*/ HighBitMask = ~((long/*uint64_t*/)($int2ulong(0))) >>> NumHighBits;
    if (((Parts.$at(PartCount - 1) & HighBitMask) != 0)) {
      return false;
    }
  
    return true;
  }

  
  /// @}
  
  /// \name Arithmetic on special values.
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::addOrSubtractSpecials">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1391,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1388,
   FQN="llvm::APFloat::addOrSubtractSpecials", NM="_ZN4llvm7APFloat21addOrSubtractSpecialsERKS0_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat21addOrSubtractSpecialsERKS0_b")
  //</editor-fold>
  private /*APFloat::opStatus*//*uint*/int addOrSubtractSpecials(final /*const*/ APFloat /*&*/ rhs, boolean subtract) {
    switch (((category).getValue() * 4 + (rhs.category).getValue())) {
     default:
      throw new llvm_unreachable(null);
     case fcNaN * 4 + fcZero:
     case fcNaN * 4 + fcNormal:
     case fcNaN * 4 + fcInfinity:
     case fcNaN * 4 + fcNaN:
     case fcNormal * 4 + fcZero:
     case fcInfinity * 4 + fcNormal:
     case fcInfinity * 4 + fcZero:
      return opStatus.opOK;
     case fcZero * 4 + fcNaN:
     case fcNormal * 4 + fcNaN:
     case fcInfinity * 4 + fcNaN:
      // We need to be sure to flip the sign here for subtraction because we
      // don't have a separate negate operation so -NaN becomes 0 - NaN here.
      sign = $uint2uint_1bit($bool2uint(rhs.sign) ^ (subtract ? 1 : 0));
      category = fltCategory.fcNaN;
      copySignificand(rhs);
      return opStatus.opOK;
     case fcNormal * 4 + fcInfinity:
     case fcZero * 4 + fcInfinity:
      category = fltCategory.fcInfinity;
      sign = $uint2uint_1bit($bool2uint(rhs.sign) ^ (subtract ? 1 : 0));
      return opStatus.opOK;
     case fcZero * 4 + fcNormal:
      assign(rhs);
      sign = $uint2uint_1bit($bool2uint(rhs.sign) ^ (subtract ? 1 : 0));
      return opStatus.opOK;
     case fcZero * 4 + fcZero:
      /* Sign depends on rounding mode; handled by caller.  */
      return opStatus.opOK;
     case fcInfinity * 4 + fcInfinity:
      /* Differently signed infinities can only be validly
      subtracted.  */
      if (($bool2uint(sign ^ rhs.sign) != 0) != subtract) {
        makeNaN();
        return opStatus.opInvalidOp;
      }

      return opStatus.opOK;
     case fcNormal * 4 + fcNormal:
      return opStatus.opDivByZero;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::divideSpecials">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1564,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1561,
   FQN="llvm::APFloat::divideSpecials", NM="_ZN4llvm7APFloat14divideSpecialsERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat14divideSpecialsERKS0_")
  //</editor-fold>
  private /*APFloat::opStatus*//*uint*/int divideSpecials(final /*const*/ APFloat /*&*/ rhs) {
    switch (((category).getValue() * 4 + (rhs.category).getValue())) {
     default:
      throw new llvm_unreachable(null);
     case fcZero * 4 + fcNaN:
     case fcNormal * 4 + fcNaN:
     case fcInfinity * 4 + fcNaN:
      category = fltCategory.fcNaN;
      copySignificand(rhs);
     case fcNaN * 4 + fcZero:
     case fcNaN * 4 + fcNormal:
     case fcNaN * 4 + fcInfinity:
     case fcNaN * 4 + fcNaN:
      sign = false;
     case fcInfinity * 4 + fcZero:
     case fcInfinity * 4 + fcNormal:
     case fcZero * 4 + fcInfinity:
     case fcZero * 4 + fcNormal:
      return opStatus.opOK;
     case fcNormal * 4 + fcInfinity:
      category = fltCategory.fcZero;
      return opStatus.opOK;
     case fcNormal * 4 + fcZero:
      category = fltCategory.fcInfinity;
      return opStatus.opDivByZero;
     case fcInfinity * 4 + fcInfinity:
     case fcZero * 4 + fcZero:
      makeNaN();
      return opStatus.opInvalidOp;
     case fcNormal * 4 + fcNormal:
      return opStatus.opOK;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::multiplySpecials">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1520,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1517,
   FQN="llvm::APFloat::multiplySpecials", NM="_ZN4llvm7APFloat16multiplySpecialsERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat16multiplySpecialsERKS0_")
  //</editor-fold>
  private /*APFloat::opStatus*//*uint*/int multiplySpecials(final /*const*/ APFloat /*&*/ rhs) {
    switch (((category).getValue() * 4 + (rhs.category).getValue())) {
     default:
      throw new llvm_unreachable(null);
     case fcNaN * 4 + fcZero:
     case fcNaN * 4 + fcNormal:
     case fcNaN * 4 + fcInfinity:
     case fcNaN * 4 + fcNaN:
      sign = false;
      return opStatus.opOK;
     case fcZero * 4 + fcNaN:
     case fcNormal * 4 + fcNaN:
     case fcInfinity * 4 + fcNaN:
      sign = false;
      category = fltCategory.fcNaN;
      copySignificand(rhs);
      return opStatus.opOK;
     case fcNormal * 4 + fcInfinity:
     case fcInfinity * 4 + fcNormal:
     case fcInfinity * 4 + fcInfinity:
      category = fltCategory.fcInfinity;
      return opStatus.opOK;
     case fcZero * 4 + fcNormal:
     case fcNormal * 4 + fcZero:
     case fcZero * 4 + fcZero:
      category = fltCategory.fcZero;
      return opStatus.opOK;
     case fcZero * 4 + fcInfinity:
     case fcInfinity * 4 + fcZero:
      makeNaN();
      return opStatus.opInvalidOp;
     case fcNormal * 4 + fcNormal:
      return opStatus.opOK;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::modSpecials">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1605,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1602,
   FQN="llvm::APFloat::modSpecials", NM="_ZN4llvm7APFloat11modSpecialsERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat11modSpecialsERKS0_")
  //</editor-fold>
  private /*APFloat::opStatus*//*uint*/int modSpecials(final /*const*/ APFloat /*&*/ rhs) {
    switch (((category).getValue() * 4 + (rhs.category).getValue())) {
     default:
      throw new llvm_unreachable(null);
     case fcNaN * 4 + fcZero:
     case fcNaN * 4 + fcNormal:
     case fcNaN * 4 + fcInfinity:
     case fcNaN * 4 + fcNaN:
     case fcZero * 4 + fcInfinity:
     case fcZero * 4 + fcNormal:
     case fcNormal * 4 + fcInfinity:
      return opStatus.opOK;
     case fcZero * 4 + fcNaN:
     case fcNormal * 4 + fcNaN:
     case fcInfinity * 4 + fcNaN:
      sign = false;
      category = fltCategory.fcNaN;
      copySignificand(rhs);
      return opStatus.opOK;
     case fcNormal * 4 + fcZero:
     case fcInfinity * 4 + fcZero:
     case fcInfinity * 4 + fcNormal:
     case fcInfinity * 4 + fcInfinity:
     case fcZero * 4 + fcZero:
      makeNaN();
      return opStatus.opInvalidOp;
     case fcNormal * 4 + fcNormal:
      return opStatus.opOK;
    }
  }

  
  /// @}
  
  /// \name Special value setters.
  /// @{
  
  /// Make this number the largest magnitude normal number in the given
  /// semantics.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::makeLargest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3401,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3398,
   FQN="llvm::APFloat::makeLargest", NM="_ZN4llvm7APFloat11makeLargestEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat11makeLargestEb")
  //</editor-fold>
  private void makeLargest() {
    makeLargest(false);
  }
  private void makeLargest(boolean Negative/*= false*/) {
    // We want (in interchange format):
    //   sign = {Negative}
    //   exponent = 1..10
    //   significand = 1..1
    category = fltCategory.fcNormal;
    sign = Negative;
    exponent = semantics.maxExponent;
    
    // Use memset to set all but the highest integerPart to all ones.
    ulong$ptr/*uint64_t P*/ significand = $tryClone(significandParts());
    /*uint*/int PartCount = partCount();
    memset(significand, 0xFF, $sizeof_ULong() * (PartCount - 1));
    
    // Set the high integerPart especially setting all unused top bits for
    // internal consistency.
    /*const*//*uint*/int NumUnusedHighBits = PartCount * integerPartWidth - semantics.precision;
    significand.$set(PartCount - 1, ($less_uint(NumUnusedHighBits, integerPartWidth)) ? (~((long/*uint64_t*/)($int2ulong(0))) >>> NumUnusedHighBits) : $int2ullong(0));
  }

  
  /// Make this number the smallest magnitude denormal number in the given
  /// semantics.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::makeSmallest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3426,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3423,
   FQN="llvm::APFloat::makeSmallest", NM="_ZN4llvm7APFloat12makeSmallestEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat12makeSmallestEb")
  //</editor-fold>
  private void makeSmallest() {
    makeSmallest(false);
  }
  private void makeSmallest(boolean Negative/*= false*/) {
    // We want (in interchange format):
    //   sign = {Negative}
    //   exponent = 0..0
    //   significand = 0..01
    category = fltCategory.fcNormal;
    sign = Negative;
    exponent = semantics.minExponent;
    APInt.tcSet(significandParts(), $int2ulong(1), partCount());
  }

  
  /* Make this number a NaN, with an arbitrary but deterministic value
  for the significand.  If double or longer, this is a signalling NaN,
  which may not be ideal.  If float, this is QNaN(0).  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::makeNaN">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 623,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 620,
   FQN="llvm::APFloat::makeNaN", NM="_ZN4llvm7APFloat7makeNaNEbbPKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat7makeNaNEbbPKNS_5APIntE")
  //</editor-fold>
  private void makeNaN() {
    makeNaN(false, false, (/*const*/ APInt /*P*/ )null);
  }
  private void makeNaN(boolean SNaN/*= false*/) {
    makeNaN(SNaN, false, (/*const*/ APInt /*P*/ )null);
  }
  private void makeNaN(boolean SNaN/*= false*/, boolean Negative/*= false*/) {
    makeNaN(SNaN, Negative, (/*const*/ APInt /*P*/ )null);
  }
  private void makeNaN(boolean SNaN/*= false*/, boolean Negative/*= false*/, /*const*/ APInt /*P*/ fill/*= null*/) {
    category = fltCategory.fcNaN;
    sign = Negative;
    
    ulong$ptr/*uint64_t P*/ significand = $tryClone(significandParts());
    /*uint*/int numParts = partCount();
    
    // Set the significand bits to the fill.
    if (!(fill != null) || $less_uint(fill.getNumWords(), numParts)) {
      APInt.tcSet(significand, $int2ulong(0), numParts);
    }
    if ((fill != null)) {
      APInt.tcAssign(significand, fill.getRawData(), 
          std.min_uint(fill.getNumWords(), numParts));

      // Zero out the excess bits of the significand.
      /*uint*/int bitsToPreserve = semantics.precision - 1;
      /*uint*/int part = $div_uint(bitsToPreserve, 64);
      bitsToPreserve = $rem_uint(bitsToPreserve, 64);
      significand.$set$andassign(part, ((1L/*ULL*/ << bitsToPreserve) - $int2ullong(1)));
      for (part++; part != numParts; ++part)  {
        significand.$set(part, $int2ulong(0));
      }
    }
    
    /*uint*/int QNaNBit = semantics.precision - 2;
    if (SNaN) {
      // We always have to clear the QNaN bit to make it an SNaN.
      APInt.tcClearBit(significand, QNaNBit);
      
      // If there are no bits set in the payload, we have to set
      // *something* to make it a NaN instead of an infinity;
      // conventionally, this is the next bit down from the QNaN bit.
      if (APInt.tcIsZero(significand, numParts)) {
        APInt.tcSetBit(significand, QNaNBit - 1);
      }
    } else {
      // We always have to set the QNaN bit to make it a QNaN.
      APInt.tcSetBit(significand, QNaNBit);
    }
    
    // For x87 extended precision, we want to make a NaN, not a
    // pseudo-NaN.  Maybe we should expose the ability to make
    // pseudo-NaNs?
    if (semantics == $AddrOf(APFloat.x87DoubleExtended)) {
      APInt.tcSetBit(significand, QNaNBit + 1);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::makeNaN">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 670,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 667,
   FQN="llvm::APFloat::makeNaN", NM="_ZN4llvm7APFloat7makeNaNERKNS_12fltSemanticsEbbPKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat7makeNaNERKNS_12fltSemanticsEbbPKNS_5APIntE")
  //</editor-fold>
  private static APFloat makeNaN(final /*const*/ fltSemantics /*&*/ Sem, boolean SNaN, boolean Negative, 
         /*const*/ APInt /*P*/ fill) {
    APFloat value/*J*/= new APFloat(Sem, uninitializedTag.uninitialized);
    value.makeNaN(SNaN, Negative, fill);
    return value;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::makeInf">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3933,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3930,
   FQN="llvm::APFloat::makeInf", NM="_ZN4llvm7APFloat7makeInfEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat7makeInfEb")
  //</editor-fold>
  private void makeInf() {
    makeInf(false);
  }
  private void makeInf(boolean Negative/*= false*/) {
    category = fltCategory.fcInfinity;
    sign = Negative;
    exponent = $int2short(semantics.maxExponent + 1);
    APInt.tcSet(significandParts(), $int2ulong(0), partCount());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::makeZero">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3941,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3938,
   FQN="llvm::APFloat::makeZero", NM="_ZN4llvm7APFloat8makeZeroEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat8makeZeroEb")
  //</editor-fold>
  private void makeZero() {
    makeZero(false);
  }
  private void makeZero(boolean Negative/*= false*/) {
    category = fltCategory.fcZero;
    sign = Negative;
    exponent = $int2short(semantics.minExponent - 1);
    APInt.tcSet(significandParts(), $int2ulong(0), partCount());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::makeQuiet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3949,
   FQN="llvm::APFloat::makeQuiet", NM="_ZN4llvm7APFloat9makeQuietEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat9makeQuietEv")
  //</editor-fold>
  /*friend*/public void makeQuiet() {
    assert (isNaN());
    APInt.tcSetBit(significandParts(), semantics.precision - 2);
  }
  
  
  /// @}
  
  /// \name Miscellany
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::convertFromStringSpecials">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 2640,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 2637,
   FQN="llvm::APFloat::convertFromStringSpecials", NM="_ZN4llvm7APFloat25convertFromStringSpecialsENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat25convertFromStringSpecialsENS_9StringRefE")
  //</editor-fold>
  private boolean convertFromStringSpecials(StringRef str) {
    if (str.equals(/*STRINGREF_STR*/"inf") || str.equals(/*STRINGREF_STR*/"INFINITY")) {
      makeInf(false);
      return true;
    }
    if (str.equals(/*STRINGREF_STR*/"-inf") || str.equals(/*STRINGREF_STR*/"-INFINITY")) {
      makeInf(true);
      return true;
    }
    if (str.equals(/*STRINGREF_STR*/"nan") || str.equals(/*STRINGREF_STR*/"NaN")) {
      makeNaN(false, false);
      return true;
    }
    if (str.equals(/*STRINGREF_STR*/"-nan") || str.equals(/*STRINGREF_STR*/"-NaN")) {
      makeNaN(false, true);
      return true;
    }
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::normalize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1283,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1280,
   FQN="llvm::APFloat::normalize", NM="_ZN4llvm7APFloat9normalizeENS0_12roundingModeENS_12lostFractionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat9normalizeENS0_12roundingModeENS_12lostFractionE")
  //</editor-fold>
  /*friend*/public /*APFloat::opStatus*//*uint*/int normalize(roundingMode rounding_mode, 
           lostFraction lost_fraction) {
    /*uint*/int omsb; /* One, not zero, based MSB.  */
    int exponentChange;
    if (!isFiniteNonZero()) {
      return opStatus.opOK;
    }
    
    /* Before rounding normalize the exponent of fcNormal numbers.  */
    omsb = significandMSB() + 1;
    if ((omsb != 0)) {
      /* OMSB is numbered from 1.  We want to place it in the integer
      bit numbered PRECISION if possible, with a compensating change in
      the exponent.  */
      exponentChange = omsb - semantics.precision;
      
      /* If the resulting exponent is too high, overflow according to
      the rounding mode.  */
      if (exponent + exponentChange > semantics.maxExponent) {
        return handleOverflow(rounding_mode);
      }
      
      /* Subnormal numbers have exponent minExponent, and their MSB
      is forced based on that.  */
      if (exponent + exponentChange < semantics.minExponent) {
        exponentChange = semantics.minExponent - exponent;
      }
      
      /* Shifting left is easy as we don't lose precision.  */
      if (exponentChange < 0) {
        assert (lost_fraction == lostFraction.lfExactlyZero);
        
        shiftSignificandLeft(-exponentChange);
        
        return opStatus.opOK;
      }
      if (exponentChange > 0) {
        lostFraction lf;
        
        /* Shift right and capture any new lost fraction.  */
        lf = shiftSignificandRight(exponentChange);
        
        lost_fraction = combineLostFractions(lf, lost_fraction);
        
        /* Keep OMSB up-to-date.  */
        if ($greater_uint(omsb, (/*uint*/int)exponentChange)) {
          omsb -= exponentChange;
        } else {
          omsb = 0;
        }
      }
    }
    
    /* Now round the number according to rounding_mode given the lost
    fraction.  */
    
    /* As specified in IEEE 754, since we do not trap we do not report
    underflow for exact results.  */
    if (lost_fraction == lostFraction.lfExactlyZero) {
      /* Canonicalize zeroes.  */
      if (omsb == 0) {
        category = fltCategory.fcZero;
      }
      
      return opStatus.opOK;
    }
    
    /* Increment the significand if we're rounding away from zero.  */
    if (roundAwayFromZero(rounding_mode, lost_fraction, 0)) {
      if (omsb == 0) {
        exponent = semantics.minExponent;
      }
      
      incrementSignificand();
      omsb = significandMSB() + 1;
      
      /* Did the significand increment overflow?  */
      if (omsb == (/*uint*/int)semantics.precision + 1) {
        /* Renormalize by incrementing the exponent and shifting our
        significand right one.  However if we already have the
        maximum exponent we overflow to infinity.  */
        if (exponent == semantics.maxExponent) {
          category = fltCategory.fcInfinity;
          
          return (/*opStatus*//*uint*/int)(opStatus.opOverflow | opStatus.opInexact);
        }
        
        shiftSignificandRight(1);
        
        return opStatus.opInexact;
      }
    }
    
    /* The normal case - we were and are not denormal, and any
    significand increment above didn't overflow.  */
    if (omsb == semantics.precision) {
      return opStatus.opInexact;
    }
    
    /* We have a non-zero denormal.  */
    assert ($less_uint(omsb, semantics.precision));
    
    /* Canonicalize zeroes.  */
    if (omsb == 0) {
      category = fltCategory.fcZero;
    }
    
    /* The fcZero case is a denormal that underflowed to zero.  */
    return (/*opStatus*//*uint*/int)(opStatus.opUnderflow | opStatus.opInexact);
  }

  
  /* Normalized addition or subtraction.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::addOrSubtract">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1665,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1662,
   FQN="llvm::APFloat::addOrSubtract", NM="_ZN4llvm7APFloat13addOrSubtractERKS0_NS0_12roundingModeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat13addOrSubtractERKS0_NS0_12roundingModeEb")
  //</editor-fold>
  private /*APFloat::opStatus*//*uint*/int addOrSubtract(final /*const*/ APFloat /*&*/ rhs, roundingMode rounding_mode, 
               boolean subtract) {
    /*opStatus*//*uint*/int fs;
    
    fs = addOrSubtractSpecials(rhs, subtract);
    
    /* This return code means it was not a simple case.  */
    if (fs == opStatus.opDivByZero) {
      lostFraction lost_fraction;
      
      lost_fraction = addOrSubtractSignificand(rhs, subtract);
      fs = normalize(rounding_mode, lost_fraction);
      
      /* Can only be zero if we lost no fraction.  */
      assert (category != fltCategory.fcZero || lost_fraction == lostFraction.lfExactlyZero);
    }

    /* If two numbers add (exactly) to zero, IEEE 754 decrees it is a
    positive zero unless rounding to minus infinity, except that
    adding two like-signed zeroes gives that zero.  */
    if (category == fltCategory.fcZero) {
      if (rhs.category != fltCategory.fcZero || (sign == rhs.sign) == subtract) {
        sign = (rounding_mode == roundingMode.rmTowardNegative);
      }
    }
    
    return fs;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::compareAbsoluteValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1193,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1190,
   FQN="llvm::APFloat::compareAbsoluteValue", NM="_ZNK4llvm7APFloat20compareAbsoluteValueERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat20compareAbsoluteValueERKS0_")
  //</editor-fold>
  private APFloat.cmpResult compareAbsoluteValue(final /*const*/ APFloat /*&*/ rhs) /*const*/ {
    int compare;
    assert (semantics == rhs.semantics);
    assert (isFiniteNonZero());
    assert (rhs.isFiniteNonZero());
    
    compare = exponent - rhs.exponent;
    
    /* If exponents are equal, do an unsigned bignum comparison of the
    significands.  */
    if (compare == 0) {
      compare = APInt.tcCompare(significandParts$Const(), rhs.significandParts$Const(), 
          partCount());
    }
    if (compare > 0) {
      return cmpResult.cmpGreaterThan;
    } else if (compare < 0) {
      return cmpResult.cmpLessThan;
    } else {
      return cmpResult.cmpEqual;
    }
  }

  
  /* Handle overflow.  Sign is preserved.  We either become infinity or
  the largest finite number.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::handleOverflow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1220,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1217,
   FQN="llvm::APFloat::handleOverflow", NM="_ZN4llvm7APFloat14handleOverflowENS0_12roundingModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat14handleOverflowENS0_12roundingModeE")
  //</editor-fold>
  private /*APFloat::opStatus*//*uint*/int handleOverflow(roundingMode rounding_mode) {
    /* Infinity?  */
    if (rounding_mode == roundingMode.rmNearestTiesToEven
       || rounding_mode == roundingMode.rmNearestTiesToAway
       || (rounding_mode == roundingMode.rmTowardPositive && !sign)
       || (rounding_mode == roundingMode.rmTowardNegative && sign)) {
      category = fltCategory.fcInfinity;
      return (/*opStatus*//*uint*/int)(opStatus.opOverflow | opStatus.opInexact);
    }
    
    /* Otherwise we become the largest finite number.  */
    category = fltCategory.fcNormal;
    exponent = semantics.maxExponent;
    APInt.tcSetLeastSignificantBits(significandParts(), partCount(), 
        semantics.precision);
    
    return opStatus.opInexact;
  }

  
  /* Returns TRUE if, when truncating the current number, with BIT the
  new LSB, with the given lost fraction and rounding mode, the result
  would need to be rounded away from zero (i.e., by increasing the
  signficand).  This routine must work for fcZero of both signs, and
  fcNormal numbers.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::roundAwayFromZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 1246,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 1243,
   FQN="llvm::APFloat::roundAwayFromZero", NM="_ZNK4llvm7APFloat17roundAwayFromZeroENS0_12roundingModeENS_12lostFractionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat17roundAwayFromZeroENS0_12roundingModeENS_12lostFractionEj")
  //</editor-fold>
  private boolean roundAwayFromZero(roundingMode rounding_mode, 
                   lostFraction lost_fraction, 
                   /*uint*/int bit) /*const*/ {
    /* NaNs and infinities should not have lost fractions.  */
    assert (isFiniteNonZero() || category == fltCategory.fcZero);
    
    /* Current callers never pass this so we don't handle it.  */
    assert (lost_fraction != lostFraction.lfExactlyZero);
    switch (rounding_mode) {
     case rmNearestTiesToAway:
      return lost_fraction == lostFraction.lfExactlyHalf || lost_fraction == lostFraction.lfMoreThanHalf;
     case rmNearestTiesToEven:
      if (lost_fraction == lostFraction.lfMoreThanHalf) {
        return true;
      }
      
      /* Our zeroes don't have a significand to test.  */
      if (lost_fraction == lostFraction.lfExactlyHalf && category != fltCategory.fcZero) {
        return (APInt.tcExtractBit(significandParts$Const(), bit) != 0);
      }
      
      return false;
     case rmTowardZero:
      return false;
     case rmTowardPositive:
      return !sign;
     case rmTowardNegative:
      return sign;
    }
    throw new llvm_unreachable("Invalid rounding mode found");
  }

  
  /* Convert a floating point number to an integer according to the
  rounding mode.  If the rounded integer value is out of range this
  returns an invalid operation exception and the contents of the
  destination parts are unspecified.  If the rounded value is in
  range but the floating point number is not the exact integer, the C
  standard doesn't require an inexact exception to be raised.  IEEE
  854 does require it so we do that.
  
  Note that for conversions to integer type the C standard requires
  round-to-zero to always be used.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::convertToSignExtendedInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 2099,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 2096,
   FQN="llvm::APFloat::convertToSignExtendedInteger", NM="_ZNK4llvm7APFloat28convertToSignExtendedIntegerEPyjbNS0_12roundingModeEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat28convertToSignExtendedIntegerEPyjbNS0_12roundingModeEPb")
  //</editor-fold>
  private /*APFloat::opStatus*//*uint*/int convertToSignExtendedInteger(ulong$ptr/*uint64_t P*/ parts, /*uint*/int width, 
                              boolean isSigned, 
                              roundingMode rounding_mode, 
                              bool$ptr/*bool P*/ isExact) /*const*/ {
    lostFraction lost_fraction;
    /*const*/ulong$ptr/*uint64_t P*/ src;
    /*uint*/int dstPartsCount;
    /*uint*/int truncatedBits;
    
    isExact.$set(false);
    
    /* Handle the three special cases first.  */
    if (category == fltCategory.fcInfinity || category == fltCategory.fcNaN) {
      return opStatus.opInvalidOp;
    }
    
    dstPartsCount = partCountForBits(width);
    if (category == fltCategory.fcZero) {
      APInt.tcSet(parts, $int2ulong(0), dstPartsCount);
      // Negative zero can't be represented as an int.
      isExact.$set(!sign);
      return opStatus.opOK;
    }
    
    src = $tryClone(significandParts$Const());
    
    /* Step 1: place our absolute value, with any fraction truncated, in
    the destination.  */
    if (exponent < 0) {
      /* Our absolute value is less than one; truncate everything.  */
      APInt.tcSet(parts, $int2ulong(0), dstPartsCount);
      /* For exponent -1 the integer bit represents .5, look at that.
      For smaller exponents leftmost truncated bit is 0. */
      truncatedBits = semantics.precision - 1/*U*/ - $short2uint(exponent);
    } else {
      /* We want the most significant (exponent + 1) bits; the rest are
      truncated.  */
      /*uint*/int bits = $short2uint(exponent) + 1/*U*/;
      
      /* Hopelessly large in magnitude?  */
      if ($greater_uint(bits, width)) {
        return opStatus.opInvalidOp;
      }
      if ($less_uint(bits, semantics.precision)) {
        /* We truncate (semantics->precision - bits) bits.  */
        truncatedBits = semantics.precision - bits;
        APInt.tcExtract(parts, dstPartsCount, src, bits, truncatedBits);
      } else {
        /* We want at least as many bits as are available.  */
        APInt.tcExtract(parts, dstPartsCount, src, semantics.precision, 0);
        APInt.tcShiftLeft(parts, dstPartsCount, bits - semantics.precision);
        truncatedBits = 0;
      }
    }
    
    /* Step 2: work out any lost fraction, and increment the absolute
    value if we would round away from zero.  */
    if ((truncatedBits != 0)) {
      lost_fraction = lostFractionThroughTruncation(src, partCount(), 
          truncatedBits);
      if (lost_fraction != lostFraction.lfExactlyZero
         && roundAwayFromZero(rounding_mode, lost_fraction, truncatedBits)) {
        if ((APInt.tcIncrement(parts, dstPartsCount) != 0)) {
          return opStatus.opInvalidOp; /* Overflow.  */
        }
      }
    } else {
      lost_fraction = lostFraction.lfExactlyZero;
    }
    
    /* Step 3: check if we fit in the destination.  */
    /*uint*/int omsb = APInt.tcMSB(parts, dstPartsCount) + 1;
    if (sign) {
      if (!isSigned) {
        /* Negative numbers cannot be represented as unsigned.  */
        if (omsb != 0) {
          return opStatus.opInvalidOp;
        }
      } else {
        /* It takes omsb bits to represent the unsigned integer value.
        We lose a bit for the sign, but care is needed as the
        maximally negative integer is a special case.  */
        if (omsb == width && APInt.tcLSB(parts, dstPartsCount) + 1 != omsb) {
          return opStatus.opInvalidOp;
        }
        
        /* This case can happen because of rounding.  */
        if ($greater_uint(omsb, width)) {
          return opStatus.opInvalidOp;
        }
      }
      
      APInt.tcNegate(parts, dstPartsCount);
    } else {
      if ($greatereq_uint(omsb, width + ((!isSigned) ? 1 : 0))) {
        return opStatus.opInvalidOp;
      }
    }
    if (lost_fraction == lostFraction.lfExactlyZero) {
      isExact.$set(true);
      return opStatus.opOK;
    } else {
      return opStatus.opInexact;
    }
  }

  
  /* Convert an unsigned integer SRC to a floating point number,
  rounding according to ROUNDING_MODE.  The sign of the floating
  point number is not modified.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::convertFromUnsignedParts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 2261,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 2258,
   FQN="llvm::APFloat::convertFromUnsignedParts", NM="_ZN4llvm7APFloat24convertFromUnsignedPartsEPKyjNS0_12roundingModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat24convertFromUnsignedPartsEPKyjNS0_12roundingModeE")
  //</editor-fold>
  private /*APFloat::opStatus*//*uint*/int convertFromUnsignedParts(/*const*/ulong$ptr/*uint64_t P*/ src, 
                          /*uint*/int srcCount, 
                          roundingMode rounding_mode) {
    /*uint*/int omsb;
    /*uint*/int precision;
    /*uint*/int dstCount;
    ulong$ptr/*uint64_t P*/ dst = create_ulong$ptr();
    lostFraction lost_fraction;
    
    category = fltCategory.fcNormal;
    omsb = APInt.tcMSB(src, srcCount) + 1;
    dst = $tryClone(significandParts());
    dstCount = partCount();
    precision = semantics.precision;
    
    /* We want the most significant PRECISION bits of SRC.  There may not
    be that many; extract what we can.  */
    if ($lesseq_uint(precision, omsb)) {
      exponent = $uint2short(omsb - 1);
      lost_fraction = lostFractionThroughTruncation(src, srcCount, 
          omsb - precision);
      APInt.tcExtract(dst, dstCount, src, precision, omsb - precision);
    } else {
      exponent = $uint2short(precision - 1);
      lost_fraction = lostFraction.lfExactlyZero;
      APInt.tcExtract(dst, dstCount, src, omsb, 0);
    }
    
    return normalize(rounding_mode, lost_fraction);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::convertFromHexadecimalString">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 2357,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 2354,
   FQN="llvm::APFloat::convertFromHexadecimalString", NM="_ZN4llvm7APFloat28convertFromHexadecimalStringENS_9StringRefENS0_12roundingModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat28convertFromHexadecimalStringENS_9StringRefENS0_12roundingModeE")
  //</editor-fold>
  private /*APFloat::opStatus*//*uint*/int convertFromHexadecimalString(StringRef s, roundingMode rounding_mode) {
    lostFraction lost_fraction = lostFraction.lfExactlyZero;
    
    category = fltCategory.fcNormal;
    zeroSignificand();
    exponent = 0;
    
    ulong$ptr/*uint64_t P*/ significand = $tryClone(significandParts());
    /*uint*/int partsCount = partCount();
    /*uint*/int bitPos = partsCount * integerPartWidth;
    boolean computedTrailingFraction = false;
    
    // Skip leading zeroes and any (hexa)decimal point.
    char$ptr begin = $tryClone(s.begin());
    char$ptr end = $tryClone(s.end());
    char$ptr dot = $tryClone(end);
    char$ptr p = $tryClone(skipLeadingZeroesAndAnyDot(begin, end, dot/*.$addr()*/));
    char$ptr firstSignificantDigit = $tryClone(p);
    while ($noteq_ptr(p, end)) {
      long/*uint64_t*/ hex_value;
      if (p.$star() == $$DOT) {
        assert ($eq_ptr(dot, end)) : "String contains multiple dots";
        dot = $tryClone(p.$postInc());
        continue;
      }
      
      hex_value = $uint2ulong(hexDigitValue(p.$star()));
      if (hex_value == $uint2ullong(-1/*U*/)) {
        break;
      }
      
      p.$postInc();
      
      // Store the number while we have space.
      if ((bitPos != 0)) {
        bitPos -= 4;
        hex_value <<= $rem_uint(bitPos, integerPartWidth);
        significand.$set$orassign($div_uint(bitPos, integerPartWidth), hex_value);
      } else if (!computedTrailingFraction) {
        lost_fraction = trailingHexadecimalFraction(p, end, $ulong2uint(hex_value));
        computedTrailingFraction = true;
      }
    }
    
    /* Hex floats require an exponent but not a hexadecimal point.  */
    assert ($noteq_ptr(p, end)) : "Hex strings require an exponent";
    assert ((p.$star() == $$p || p.$star() == $$P)) : "Invalid character in significand";
    assert ($noteq_ptr(p, begin)) : "Significand has no digits";
    assert (($eq_ptr(dot, end) || p.$sub(begin) != 1)) : "Significand has no digits";
    
    /* Ignore the exponent if we are zero.  */
    if ($noteq_ptr(p, firstSignificantDigit)) {
      int expAdjustment;
      
      /* Implicit hexadecimal point?  */
      if ($eq_ptr(dot, end)) {
        dot = $tryClone(p);
      }
      
      /* Calculate the exponent adjustment implicit in the number of
      significant digits.  */
      expAdjustment = ((/*static_cast*/int)(dot.$sub(firstSignificantDigit)));
      if (expAdjustment < 0) {
        expAdjustment++;
      }
      expAdjustment = expAdjustment * 4 - 1;
      
      /* Adjust for writing the significand starting at the most
      significant nibble.  */
      expAdjustment += semantics.precision;
      expAdjustment -= partsCount * integerPartWidth;
      
      /* Adjust for the given exponent.  */
      exponent = $int2short(totalExponent(p.$add(1), end, expAdjustment));
    }
    
    return normalize(rounding_mode, lost_fraction);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::convertFromDecimalString">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 2522,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 2519,
   FQN="llvm::APFloat::convertFromDecimalString", NM="_ZN4llvm7APFloat24convertFromDecimalStringENS_9StringRefENS0_12roundingModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat24convertFromDecimalStringENS_9StringRefENS0_12roundingModeE")
  //</editor-fold>
  private /*APFloat::opStatus*//*uint*/int convertFromDecimalString(StringRef str, roundingMode rounding_mode) {
    decimalInfo D/*J*/= new decimalInfo();
    /*opStatus*//*uint*/int fs;
    
    /* Scan the text.  */
    char$ptr p = $tryClone(str.begin());
    interpretDecimal(p, str.end(), $AddrOf(D));
    
    /* Handle the quick cases.  First the case of no significant digits,
    i.e. zero, and then exponents that are obviously too large or too
    small.  Writing L for log 10 / log 2, a number d.ddddd*10^exp
    definitely overflows if
    
    (exp - 1) * L >= maxExponent
    
    and definitely underflows to zero where
    
    (exp + 1) * L <= minExponent - precision
    
    With integer arithmetic the tightest bounds for L are
    
    93/28 < L < 196/59            [ numerator <= 256 ]
    42039/12655 < L < 28738/8651  [ numerator <= 65536 ]
    */
    
    // Test if we have a zero number allowing for strings with no null terminators
    // and zero decimals with non-zero exponents.
    // 
    // We computed firstSigDigit by ignoring all zeros and dots. Thus if
    // D->firstSigDigit equals str.end(), every digit must be a zero and there can
    // be at most one dot. On the other hand, if we have a zero with a non-zero
    // exponent, then we know that D.firstSigDigit will be non-numeric.
    if ($eq_ptr(D.firstSigDigit, str.end()) || $greatereq_uint(decDigitValue($char2uint(D.firstSigDigit.$star())), 10/*U*/)) {
      category = fltCategory.fcZero;
      fs = opStatus.opOK;
      /* Check whether the normalized exponent is high enough to overflow
      max during the log-rebasing in the max-exponent check below. */
    } else if (D.normalizedExponent - 1 > INT_MAX / 42039) {
      fs = handleOverflow(rounding_mode);
      /* If it wasn't, then it also wasn't high enough to overflow max
      during the log-rebasing in the min-exponent check.  Check that it
      won't overflow min in either check, then perform the min-exponent
      check. */
    } else if (D.normalizedExponent - 1 < INT_MIN / 42039
       || (D.normalizedExponent + 1) * 28738
       <= 8651 * (semantics.minExponent - (int)semantics.precision)) {
      /* Underflow to zero and round.  */
      category = fltCategory.fcNormal;
      zeroSignificand();
      fs = normalize(rounding_mode, lostFraction.lfLessThanHalf);
      /* We can finally safely perform the max-exponent check. */
    } else if ((D.normalizedExponent - 1) * 42039
       >= 12655 * semantics.maxExponent) {
      /* Overflow and round.  */
      fs = handleOverflow(rounding_mode);
    } else {
      ulong$ptr/*uint64_t P*/ decSignificand;
      /*uint*/int partCount;
      
      /* A tight upper bound on number of bits required to hold an
      N-digit decimal integer is N * 196 / 59.  Allocate enough space
      to hold the full significand, and an extra part required by
      tcMultiplyPart.  */
      partCount = ((/*static_cast*//*uint*/int)(D.lastSigDigit.$sub(D.firstSigDigit))) + 1;
      partCount = partCountForBits(1 + $div_uint(196 * partCount, 59));
      decSignificand = create_ulong$ptr(new$ulong(partCount + 1));
      partCount = 0;
      
      /* Convert to binary efficiently - we do almost all multiplication
      in an integerPart.  When this would overflow do we do a single
      bignum multiplication, and then revert again to multiplication
      in an integerPart.  */
      do {
        long/*uint64_t*/ decValue;
        long/*uint64_t*/ val;
        long/*uint64_t*/ multiplier;
        
        val = $int2ulong(0);
        multiplier = $int2ulong(1);
        
        do {
          if (p.$star() == $$DOT) {
            p.$postInc();
            if ($eq_ptr(p, str.end())) {
              break;
            }
          }
          decValue = $uint2ulong(decDigitValue($char2uint(p.$postInc().$star())));
          assert ($less_ulong_uint(decValue, 10/*U*/)) : "Invalid character in significand";
          multiplier *= $int2ullong(10);
          val = val * $int2ullong(10) + decValue;
          /* The maximum number that can be multiplied by ten with any
          digit added without overflowing an integerPart.  */
        } while (p.$lesseq(D.lastSigDigit) && $lesseq_ulong_ullong(multiplier, $div_ullong((~(long/*uint64_t*/)$int2ulong(0) - $int2ullong(9)), $int2ullong(10))));
        
        /* Multiply out the current part.  */
        APInt.tcMultiplyPart(decSignificand, decSignificand, multiplier, val, 
            partCount, partCount + 1, false);
        
        /* If we used another part (likely but not guaranteed), increase
        the count.  */
        if ((decSignificand.$at(partCount) != 0)) {
          partCount++;
        }
      } while (p.$lesseq(D.lastSigDigit));
      
      category = fltCategory.fcNormal;
      fs = roundSignificandWithExponent(decSignificand, partCount, 
          D.exponent, rounding_mode);
      
      /*delete[]*/Destructors.$destroyArray(decSignificand);
    }
    
    return fs;
  }

  
  /* Does the hard work of outputting the correctly rounded hexadecimal
  form of a normal floating point number with the specified number of
  hexadecimal digits.  If HEXDIGITS is zero the minimum number of
  digits necessary to print the value precisely is output.  */
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::convertNormalToHexString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 2765,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 2762,
   FQN="llvm::APFloat::convertNormalToHexString", NM="_ZNK4llvm7APFloat24convertNormalToHexStringEPcjbNS0_12roundingModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat24convertNormalToHexStringEPcjbNS0_12roundingModeE")
  //</editor-fold>
  private char$ptr/*char P*/ convertNormalToHexString(char$ptr/*char P*/ dst, /*uint*/int hexDigits, 
                          boolean upperCase, 
                          roundingMode rounding_mode) /*const*/ {
    /*uint*/int count;
    /*uint*/int valueBits;
    /*uint*/int shift;
    /*uint*/int partsCount;
    /*uint*/int outputDigits;
    /*const*/char$ptr/*char P*/ hexDigitChars = create_char$ptr();
    /*const*/ulong$ptr/*uint64_t P*/ significand;
    char$ptr/*char P*/ p = create_char$ptr();
    boolean roundUp;
    
    dst.$postInc().$set($$0);
    dst.$postInc().$set(upperCase ? $$X : $$x);
    
    roundUp = false;
    hexDigitChars = $tryClone(upperCase ? hexDigitsUpper : hexDigitsLower);
    
    significand = $tryClone(significandParts$Const());
    partsCount = partCount();
    
    /* +3 because the first digit only uses the single integer bit, so
    we have 3 virtual zero most-significant-bits.  */
    valueBits = semantics.precision + 3;
    shift = integerPartWidth - $rem_uint(valueBits, integerPartWidth);
    
    /* The natural number of digits required ignoring trailing
    insignificant zeroes.  */
    outputDigits = $div_uint((valueBits - significandLSB() + 3), 4);
    
    /* hexDigits of zero means use the required number for the
    precision.  Otherwise, see if we are truncating.  If we are,
    find out if we need to round away from zero.  */
    if ((hexDigits != 0)) {
      if ($less_uint(hexDigits, outputDigits)) {
        /* We are dropping non-zero bits, so need to check how to round.
        "bits" is the number of dropped bits.  */
        /*uint*/int bits;
        lostFraction fraction;
        
        bits = valueBits - hexDigits * 4;
        fraction = lostFractionThroughTruncation(significand, partsCount, bits);
        roundUp = roundAwayFromZero(rounding_mode, fraction, bits);
      }
      outputDigits = hexDigits;
    }
    
    /* Write the digits consecutively, and start writing in the location
    of the hexadecimal point.  We move the most significant digit
    left and add the hexadecimal point later.  */
    p = $tryClone(dst.$preInc());
    
    count = $div_uint((valueBits + integerPartWidth - 1), integerPartWidth);
    while ((outputDigits != 0) && (count != 0)) {
      long/*uint64_t*/ part;
      
      /* Put the most significant integerPartWidth bits in "part".  */
      if (--count == partsCount) {
        part = $int2ulong(0); /* An imaginary higher zero part.  */
      } else {
        part = significand.$at(count) << shift;
      }
      if ((count != 0) && (shift != 0)) {
        part |= significand.$at(count - 1) >>> (integerPartWidth - shift);
      }
      
      /* Convert as much of "part" to hexdigits as we can.  */
      /*uint*/int curDigits = $div_uint(integerPartWidth, 4);
      if ($greater_uint(curDigits, outputDigits)) {
        curDigits = outputDigits;
      }
      dst.$inc(partAsHex(dst, part, curDigits, hexDigitChars));
      outputDigits -= curDigits;
    }
    if (roundUp) {
      char$ptr/*char P*/ q = $tryClone(dst);
      
      /* Note that hexDigitChars has a trailing '0'.  */
      do {
        q.$postDec();
        q.$set(hexDigitChars.$at(hexDigitValue(q.$star()) + 1));
      } while (q.$star() == $$0);
      assert (q.$greatereq(p));
    } else {
      /* Add trailing zeroes.  */
      memset(dst, $$0, outputDigits);
      dst.$inc(outputDigits);
    }
    
    /* Move the most significant digit to before the point, and if there
    is something after the decimal point add it.  This must come
    after rounding above.  */
    p.$set(-1, p.$at(0));
    if ($eq_ptr(dst.$sub(1), p)) {
      dst.$postDec();
    } else {
      p.$set(0, $$DOT);
    }
    
    /* Finally output the exponent.  */
    dst.$postInc().$set(upperCase ? $$P : $$p);
    
    return writeSignedDecimal(dst, exponent);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::roundSignificandWithExponent">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 2437,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 2434,
   FQN="llvm::APFloat::roundSignificandWithExponent", NM="_ZN4llvm7APFloat28roundSignificandWithExponentEPKyjiNS0_12roundingModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat28roundSignificandWithExponentEPKyjiNS0_12roundingModeE")
  //</editor-fold>
  private /*APFloat::opStatus*//*uint*/int roundSignificandWithExponent(/*const*/ulong$ptr/*uint64_t P*/ decSigParts, 
                              /*uint*/int sigPartCount, int exp, 
                              roundingMode rounding_mode) {
    /*uint*/int parts;
    /*uint*/int pow5PartCount;
    fltSemantics calcSemantics = new fltSemantics(32767, -32767, 0, 0);
    /*uint64_t*/ulong$ptr pow5Parts/*[600]*/ = create_ulong$ptr(new$ulong(600));
    boolean isNearest;
    
    isNearest = (rounding_mode == roundingMode.rmNearestTiesToEven
       || rounding_mode == roundingMode.rmNearestTiesToAway);
    
    parts = partCountForBits(semantics.precision + 11);
    
    /* Calculate pow(5, abs(exp)).  */
    pow5PartCount = powerOf5(pow5Parts, exp >= 0 ? exp : -exp);
    
    for (;; parts *= 2) {
      /*opStatus*//*uint*/int sigStatus;
      /*opStatus*//*uint*/int powStatus;
      /*uint*/int excessPrecision;
      /*uint*/int truncatedBits;
      
      calcSemantics.precision = parts * integerPartWidth - 1;
      excessPrecision = calcSemantics.precision - semantics.precision;
      truncatedBits = excessPrecision;
      
      APFloat decSig = APFloat.getZero(calcSemantics, sign);
      APFloat pow5/*J*/= new APFloat(calcSemantics);
      
      sigStatus = decSig.convertFromUnsignedParts(decSigParts, sigPartCount, 
          roundingMode.rmNearestTiesToEven);
      powStatus = pow5.convertFromUnsignedParts(pow5Parts, pow5PartCount, 
          roundingMode.rmNearestTiesToEven);
      /* Add exp, as 10^n = 5^n * 2^n.  */
      decSig.exponent += exp;
      
      lostFraction calcLostFraction;
      long/*uint64_t*/ HUerr;
      long/*uint64_t*/ HUdistance;
      /*uint*/int powHUerr;
      if (exp >= 0) {
        /* multiplySignificand leaves the precision-th bit set to 1.  */
        calcLostFraction = decSig.multiplySignificand(pow5, (/*const*/ APFloat /*P*/ )null);
        powHUerr = ((powStatus != opStatus.opOK) ? 1 : 0);
      } else {
        calcLostFraction = decSig.divideSignificand(pow5);
        /* Denormal numbers have less precision.  */
        if (decSig.exponent < semantics.minExponent) {
          excessPrecision += (semantics.minExponent - decSig.exponent);
          truncatedBits = excessPrecision;
          if ($greater_uint(excessPrecision, calcSemantics.precision)) {
            excessPrecision = calcSemantics.precision;
          }
        }
        /* Extra half-ulp lost in reciprocal of exponent.  */
        powHUerr = (powStatus == opStatus.opOK && calcLostFraction == lostFraction.lfExactlyZero) ? 0 : 2;
      }
      
      /* Both multiplySignificand and divideSignificand return the
      result with the integer bit set.  */
      assert (APInt.tcExtractBit(decSig.significandParts(), calcSemantics.precision - 1) == 1);
      
      HUerr = $uint2ulong(HUerrBound(calcLostFraction != lostFraction.lfExactlyZero, ((sigStatus != opStatus.opOK) ? 1 : 0), 
          powHUerr));
      HUdistance = $int2ullong(2) * ulpsFromBoundary(decSig.significandParts(), 
          excessPrecision, isNearest);
      
      /* Are we guaranteed to round correctly if we truncate?  */
      if ($greatereq_ulong(HUdistance, HUerr)) {
        APInt.tcExtract(significandParts(), partCount(), decSig.significandParts(), 
            calcSemantics.precision - excessPrecision, 
            excessPrecision);
        /* Take the exponent of decSig.  If we tcExtract-ed less bits
        above we must adjust our exponent to compensate for the
        implicit right shift.  */
        exponent = $uint2short(($short2uint(decSig.exponent) + semantics.precision
           - (calcSemantics.precision - excessPrecision)));
        calcLostFraction = lostFractionThroughTruncation(decSig.significandParts(), 
            decSig.partCount(), 
            truncatedBits);
        return normalize(rounding_mode, calcLostFraction);
      }
    }
  }

  
  /// @}
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::convertHalfAPFloatToAPInt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3071,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3068,
   FQN="llvm::APFloat::convertHalfAPFloatToAPInt", NM="_ZNK4llvm7APFloat25convertHalfAPFloatToAPIntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat25convertHalfAPFloatToAPIntEv")
  //</editor-fold>
  private APInt convertHalfAPFloatToAPInt() /*const*/ {
    assert (semantics == (/*const*/ fltSemantics /*P*/ )$AddrOf(IEEEhalf));
    assert (partCount() == 1);
    
    /*uint32_t*/int myexponent;
    /*uint32_t*/int mysignificand;
    if (isFiniteNonZero()) {
      myexponent = exponent + 15; //bias
      mysignificand = (/*uint32_t*/int)$ulong2uint(significandParts$Const().$star());
      if (myexponent == 1 && !((mysignificand & 0x400) != 0)) {
        myexponent = 0; // denormal
      }
    } else if (category == fltCategory.fcZero) {
      myexponent = 0;
      mysignificand = 0;
    } else if (category == fltCategory.fcInfinity) {
      myexponent = 0x1f;
      mysignificand = 0;
    } else {
      assert (category == fltCategory.fcNaN) : "Unknown category!";
      myexponent = 0x1f;
      mysignificand = (/*uint32_t*/int)$ulong2uint(significandParts$Const().$star());
    }

    return new APInt(16, $uint2ulong(((($bool2uint(sign) & 1) << 15) | ((myexponent & 0x1f) << 10)
           | (mysignificand & 0x3ff))));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::convertFloatAPFloatToAPInt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3042,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3039,
   FQN="llvm::APFloat::convertFloatAPFloatToAPInt", NM="_ZNK4llvm7APFloat26convertFloatAPFloatToAPIntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat26convertFloatAPFloatToAPIntEv")
  //</editor-fold>
  private APInt convertFloatAPFloatToAPInt() /*const*/ {
    assert (semantics == (/*const*/ fltSemantics /*P*/ )$AddrOf(IEEEsingle));
    assert (partCount() == 1);
    
    /*uint32_t*/int myexponent;
    /*uint32_t*/int mysignificand;
    if (isFiniteNonZero()) {
      myexponent = exponent + 127; //bias
      mysignificand = (/*uint32_t*/int)$ulong2uint(significandParts$Const().$star());
      if (myexponent == 1 && !((mysignificand & 0x800000) != 0)) {
        myexponent = 0; // denormal
      }
    } else if (category == fltCategory.fcZero) {
      myexponent = 0;
      mysignificand = 0;
    } else if (category == fltCategory.fcInfinity) {
      myexponent = 0xff;
      mysignificand = 0;
    } else {
      assert (category == fltCategory.fcNaN) : "Unknown category!";
      myexponent = 0xff;
      mysignificand = (/*uint32_t*/int)$ulong2uint(significandParts$Const().$star());
    }

    return new APInt(32, $uint2ulong(((($bool2uint(sign) & 1) << 31) | ((myexponent & 0xff) << 23)
           | (mysignificand & 0x7fffff))));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::convertDoubleAPFloatToAPInt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3012,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3009,
   FQN="llvm::APFloat::convertDoubleAPFloatToAPInt", NM="_ZNK4llvm7APFloat27convertDoubleAPFloatToAPIntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat27convertDoubleAPFloatToAPIntEv")
  //</editor-fold>
  private APInt convertDoubleAPFloatToAPInt() /*const*/ {
    assert (semantics == (/*const*/ fltSemantics /*P*/ )$AddrOf(IEEEdouble));
    assert (partCount() == 1);
    
    long/*uint64_t*/ myexponent;
    long/*uint64_t*/ mysignificand;
    if (isFiniteNonZero()) {
      myexponent = $int2ulong(exponent + 1023); //bias
      mysignificand = significandParts$Const().$star();
      if (myexponent == $int2ullong(1) && !((mysignificand & 0x10000000000000L/*LL*/) != 0)) {
        myexponent = $int2ulong(0); // denormal
      }
    } else if (category == fltCategory.fcZero) {
      myexponent = $int2ulong(0);
      mysignificand = $int2ulong(0);
    } else if (category == fltCategory.fcInfinity) {
      myexponent = $int2ulong(0x7ff);
      mysignificand = $int2ulong(0);
    } else {
      assert (category == fltCategory.fcNaN) : "Unknown category!";
      myexponent = $int2ulong(0x7ff);
      mysignificand = significandParts$Const().$star();
    }

    return new APInt(64, ((((long/*uint64_t*/)$int2ulong(($bool2uint(sign) & 1)) << 63)
           | ((myexponent & $int2ullong(0x7ff)) << 52)
           | (mysignificand & 0xfffffffffffffL/*LL*/))));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::convertQuadrupleAPFloatToAPInt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 2976,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 2973,
   FQN="llvm::APFloat::convertQuadrupleAPFloatToAPInt", NM="_ZNK4llvm7APFloat30convertQuadrupleAPFloatToAPIntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat30convertQuadrupleAPFloatToAPIntEv")
  //</editor-fold>
  private APInt convertQuadrupleAPFloatToAPInt() /*const*/ {
    assert (semantics == (/*const*/ fltSemantics /*P*/ )$AddrOf(IEEEquad));
    assert (partCount() == 2);
    
    long/*uint64_t*/ myexponent;
    long/*uint64_t*/ mysignificand;
    long/*uint64_t*/ mysignificand2;
    if (isFiniteNonZero()) {
      myexponent = $int2ulong(exponent + 16383); //bias
      mysignificand = significandParts$Const().$at(0);
      mysignificand2 = significandParts$Const().$at(1);
      if (myexponent == $int2ullong(1) && !((mysignificand2 & 0x1000000000000L/*LL*/) != 0)) {
        myexponent = $int2ulong(0); // denormal
      }
    } else if (category == fltCategory.fcZero) {
      myexponent = $int2ulong(0);
      mysignificand = mysignificand2 = $int2ulong(0);
    } else if (category == fltCategory.fcInfinity) {
      myexponent = $int2ulong(0x7fff);
      mysignificand = mysignificand2 = $int2ulong(0);
    } else {
      assert (category == fltCategory.fcNaN) : "Unknown category!";
      myexponent = $int2ulong(0x7fff);
      mysignificand = significandParts$Const().$at(0);
      mysignificand2 = significandParts$Const().$at(1);
    }

    long/*uint64_t*/ words[/*2*/] = new$ulong(2);
    words[0] = mysignificand;
    words[1] = ((long/*uint64_t*/)$int2ulong(($bool2uint(sign) & 1)) << 63)
       | ((myexponent & $int2ullong(0x7fff)) << 48)
       | (mysignificand2 & 0xffffffffffffL/*LL*/);
  
    return new APInt(128, new ArrayRefULong(words));
  }

  
  // Conversion from APFloat to/from host float/double.  It may eventually be
  // possible to eliminate these and have everybody deal with APFloats, but that
  // will take a while.  This approach will not easily extend to long double.
  // Current implementation requires integerPartWidth==64, which is correct at
  // the moment but could be made more general.

  // Denormals have exponent minExponent in APFloat, but minExponent-1 in
  // the actual IEEE respresentations.  We compensate for that here.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::convertF80LongDoubleAPFloatToAPInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 2893,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 2890,
   FQN="llvm::APFloat::convertF80LongDoubleAPFloatToAPInt", NM="_ZNK4llvm7APFloat34convertF80LongDoubleAPFloatToAPIntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat34convertF80LongDoubleAPFloatToAPIntEv")
  //</editor-fold>
  private APInt convertF80LongDoubleAPFloatToAPInt() /*const*/ {
    assert (semantics == (/*const*/ fltSemantics /*P*/ )$AddrOf(x87DoubleExtended));
    assert (partCount() == 2);
    
    long/*uint64_t*/ myexponent;
    long/*uint64_t*/ mysignificand;
    if (isFiniteNonZero()) {
      myexponent = $int2ulong(exponent + 16383); //bias
      mysignificand = significandParts$Const().$at(0);
      if (myexponent == $int2ullong(1) && !((mysignificand & 0x8000000000000000L/*ULL*/) != 0)) {
        myexponent = $int2ulong(0); // denormal
      }
    } else if (category == fltCategory.fcZero) {
      myexponent = $int2ulong(0);
      mysignificand = $int2ulong(0);
    } else if (category == fltCategory.fcInfinity) {
      myexponent = $int2ulong(0x7fff);
      mysignificand = 0x8000000000000000L/*ULL*/;
    } else {
      assert (category == fltCategory.fcNaN) : "Unknown category";
      myexponent = $int2ulong(0x7fff);
      mysignificand = significandParts$Const().$at(0);
    }
    
    long/*uint64_t*/ words[/*2*/] = new$ulong(2);
    words[0] = mysignificand;
    words[1] = ((long/*uint64_t*/)$int2ulong(($bool2uint(sign) & 1)) << 15)
       | (myexponent & 0x7fffL/*LL*/);
    return new APInt(80, new ArrayRefULong(words));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::convertPPCDoubleDoubleAPFloatToAPInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 2925,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 2922,
   FQN="llvm::APFloat::convertPPCDoubleDoubleAPFloatToAPInt", NM="_ZNK4llvm7APFloat36convertPPCDoubleDoubleAPFloatToAPIntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZNK4llvm7APFloat36convertPPCDoubleDoubleAPFloatToAPIntEv")
  //</editor-fold>
  private APInt convertPPCDoubleDoubleAPFloatToAPInt() /*const*/ {
    assert (semantics == (/*const*/ fltSemantics /*P*/ )$AddrOf(PPCDoubleDouble));
    assert (partCount() == 2);
    
    long/*uint64_t*/ words[/*2*/] = new$ulong(2);
    /*opStatus*//*uint*/int fs;
    bool$ptr losesInfo = create_bool$ptr();
    
    // Convert number to double.  To avoid spurious underflows, we re-
    // normalize against the "double" minExponent first, and only *then*
    // truncate the mantissa.  The result of that second conversion
    // may be inexact, but should never underflow.
    // Declare fltSemantics before APFloat that uses it (and
    // saves pointer to it) to ensure correct destruction order.
    fltSemantics extendedSemantics = new fltSemantics($Deref(semantics));
    extendedSemantics.minExponent = IEEEdouble.minExponent;
    APFloat extended/*J*/= new APFloat(/*Deref*/this);
    fs = extended.convert(extendedSemantics, roundingMode.rmNearestTiesToEven, $AddrOf(losesInfo));
    assert (fs == opStatus.opOK && !losesInfo.$star());
    ///*J:(void)*/fs;
    
    APFloat u/*J*/= new APFloat(extended);
    fs = u.convert(IEEEdouble, roundingMode.rmNearestTiesToEven, $AddrOf(losesInfo));
    assert (fs == opStatus.opOK || fs == opStatus.opInexact);
    ///*J:(void)*/fs;
    words[0] = u.convertDoubleAPFloatToAPInt().getRawData().$star();
    
    // If conversion was exact or resulted in a special case, we're done;
    // just set the second double to zero.  Otherwise, re-convert back to
    // the extended format and compute the difference.  This now should
    // convert exactly to double.
    if (u.isFiniteNonZero() && losesInfo.$star()) {
      fs = u.convert(extendedSemantics, roundingMode.rmNearestTiesToEven, $AddrOf(losesInfo));
      assert (fs == opStatus.opOK && !losesInfo.$star());
      ///*J:(void)*/fs;
      
      APFloat v/*J*/= new APFloat(extended);
      v.subtract(u, roundingMode.rmNearestTiesToEven);
      fs = v.convert(IEEEdouble, roundingMode.rmNearestTiesToEven, $AddrOf(losesInfo));
      assert (fs == opStatus.opOK && !losesInfo.$star());
      ///*J:(void)*/fs;
      words[1] = v.convertDoubleAPFloatToAPInt().getRawData().$star();
    } else {
      words[1] = $int2ulong(0);
    }

    return new APInt(128, new ArrayRefULong(words));
  }
  
  
  /// Treat api as containing the bits of a floating point number.  Currently
  /// we infer the floating point type from the size of the APInt.  The
  /// isIEEE argument distinguishes between PPC128 and IEEE128 (not meaningful
  /// when the size is anything else).
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::initFromAPInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3355,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3352,
   FQN="llvm::APFloat::initFromAPInt", NM="_ZN4llvm7APFloat13initFromAPIntEPKNS_12fltSemanticsERKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat13initFromAPIntEPKNS_12fltSemanticsERKNS_5APIntE")
  //</editor-fold>
  private void initFromAPInt(/*const*/ fltSemantics /*P*/ Sem, final /*const*/ APInt /*&*/ api) {
    if (Sem == $AddrOf(IEEEhalf)) {
      initFromHalfAPInt(api);
      /*JAVA:return*/return;
    }
    if (Sem == $AddrOf(IEEEsingle)) {
      initFromFloatAPInt(api);
      /*JAVA:return*/return;
    }
    if (Sem == $AddrOf(IEEEdouble)) {
      initFromDoubleAPInt(api);
      /*JAVA:return*/return;
    }
    if (Sem == $AddrOf(x87DoubleExtended)) {
      initFromF80LongDoubleAPInt(api);
      /*JAVA:return*/return;
    }
    if (Sem == $AddrOf(IEEEquad)) {
      initFromQuadrupleAPInt(api);
      /*JAVA:return*/return;
    }
    if (Sem == $AddrOf(PPCDoubleDouble)) {
      initFromPPCDoubleDoubleAPInt(api);
      /*JAVA:return*/return;
    }
    throw new llvm_unreachable(null);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::initFromHalfAPInt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3318,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3315,
   FQN="llvm::APFloat::initFromHalfAPInt", NM="_ZN4llvm7APFloat17initFromHalfAPIntERKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat17initFromHalfAPIntERKNS_5APIntE")
  //</editor-fold>
  private void initFromHalfAPInt(final /*const*/ APInt /*&*/ api) {
    assert (api.getBitWidth() == 16);
    /*uint32_t*/int i = (/*uint32_t*/int)$ulong2uint(api.getRawData().$star());
    /*uint32_t*/int myexponent = (i >>> 10) & 0x1f;
    /*uint32_t*/int mysignificand = i & 0x3ff;
    
    initialize($AddrOf(APFloat.IEEEhalf));
    assert (partCount() == 1);
    
    sign = $uint2uint_1bit(i >>> 15);
    if (myexponent == 0 && mysignificand == 0) {
      // exponent, significand meaningless
      category = fltCategory.fcZero;
    } else if (myexponent == 0x1f && mysignificand == 0) {
      // exponent, significand meaningless
      category = fltCategory.fcInfinity;
    } else if (myexponent == 0x1f && mysignificand != 0) {
      // sign, exponent, significand meaningless
      category = fltCategory.fcNaN;
      significandParts().$set($uint2ulong(mysignificand));
    } else {
      category = fltCategory.fcNormal;
      exponent = $uint2short(myexponent - 15); //bias
      significandParts().$set($uint2ulong(mysignificand));
      if (myexponent == 0) { // denormal
        exponent = -14;
      } else {
        significandParts().$set$orassign(0, $int2ullong(0x400)); // integer bit
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::initFromFloatAPInt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3285,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3282,
   FQN="llvm::APFloat::initFromFloatAPInt", NM="_ZN4llvm7APFloat18initFromFloatAPIntERKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat18initFromFloatAPIntERKNS_5APIntE")
  //</editor-fold>
  private void initFromFloatAPInt(final /*const*/ APInt /*&*/ api) {
    assert (api.getBitWidth() == 32);
    /*uint32_t*/int i = (/*uint32_t*/int)$ulong2uint(api.getRawData().$star());
    /*uint32_t*/int myexponent = (i >>> 23) & 0xff;
    /*uint32_t*/int mysignificand = i & 0x7fffff;
    
    initialize($AddrOf(APFloat.IEEEsingle));
    assert (partCount() == 1);
    
    sign = $uint2uint_1bit(i >>> 31);
    if (myexponent == 0 && mysignificand == 0) {
      // exponent, significand meaningless
      category = fltCategory.fcZero;
    } else if (myexponent == 0xff && mysignificand == 0) {
      // exponent, significand meaningless
      category = fltCategory.fcInfinity;
    } else if (myexponent == 0xff && mysignificand != 0) {
      // sign, exponent, significand meaningless
      category = fltCategory.fcNaN;
      significandParts().$set($uint2ulong(mysignificand));
    } else {
      category = fltCategory.fcNormal;
      exponent = $uint2short(myexponent - 127); //bias
      significandParts().$set($uint2ulong(mysignificand));
      if (myexponent == 0) { // denormal
        exponent = -126;
      } else {
        significandParts().$set$orassign(0, $int2ullong(0x800000)); // integer bit
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::initFromDoubleAPInt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3252,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3249,
   FQN="llvm::APFloat::initFromDoubleAPInt", NM="_ZN4llvm7APFloat19initFromDoubleAPIntERKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat19initFromDoubleAPIntERKNS_5APIntE")
  //</editor-fold>
  private void initFromDoubleAPInt(final /*const*/ APInt /*&*/ api) {
    assert (api.getBitWidth() == 64);
    long/*uint64_t*/ i = api.getRawData().$star();
    long/*uint64_t*/ myexponent = (i >>> 52) & $int2ullong(0x7ff);
    long/*uint64_t*/ mysignificand = i & 0xfffffffffffffL/*LL*/;
    
    initialize($AddrOf(APFloat.IEEEdouble));
    assert (partCount() == 1);
    
    sign = $uint2uint_1bit(((/*static_cast*//*uint*/int)($ulong2uint(i >>> 63))));
    if (myexponent == $int2ullong(0) && mysignificand == $int2ullong(0)) {
      // exponent, significand meaningless
      category = fltCategory.fcZero;
    } else if (myexponent == $int2ullong(0x7ff) && mysignificand == $int2ullong(0)) {
      // exponent, significand meaningless
      category = fltCategory.fcInfinity;
    } else if (myexponent == $int2ullong(0x7ff) && mysignificand != $int2ullong(0)) {
      // exponent meaningless
      category = fltCategory.fcNaN;
      significandParts().$set(mysignificand);
    } else {
      category = fltCategory.fcNormal;
      exponent = $ullong2short(myexponent - $int2ullong(1023));
      significandParts().$set(mysignificand);
      if (myexponent == $int2ullong(0)) { // denormal
        exponent = -1022;
      } else {
        significandParts().$set$orassign(0, 0x10000000000000L/*LL*/); // integer bit
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::initFromQuadrupleAPInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3212,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3209,
   FQN="llvm::APFloat::initFromQuadrupleAPInt", NM="_ZN4llvm7APFloat22initFromQuadrupleAPIntERKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat22initFromQuadrupleAPIntERKNS_5APIntE")
  //</editor-fold>
  private void initFromQuadrupleAPInt(final /*const*/ APInt /*&*/ api) {
    assert (api.getBitWidth() == 128);
    long/*uint64_t*/ i1 = api.getRawData().$at(0);
    long/*uint64_t*/ i2 = api.getRawData().$at(1);
    long/*uint64_t*/ myexponent = (i2 >>> 48) & $int2ullong(0x7fff);
    long/*uint64_t*/ mysignificand = i1;
    long/*uint64_t*/ mysignificand2 = i2 & 0xffffffffffffL/*LL*/;
    
    initialize($AddrOf(APFloat.IEEEquad));
    assert (partCount() == 2);
    
    sign = $uint2uint_1bit(((/*static_cast*//*uint*/int)($ulong2uint(i2 >>> 63))));
    if (myexponent == $int2ullong(0)
       && (mysignificand == $int2ullong(0) && mysignificand2 == $int2ullong(0))) {
      // exponent, significand meaningless
      category = fltCategory.fcZero;
    } else if (myexponent == $int2ullong(0x7fff)
       && (mysignificand == $int2ullong(0) && mysignificand2 == $int2ullong(0))) {
      // exponent, significand meaningless
      category = fltCategory.fcInfinity;
    } else if (myexponent == $int2ullong(0x7fff)
       && (mysignificand != $int2ullong(0) || mysignificand2 != $int2ullong(0))) {
      // exponent meaningless
      category = fltCategory.fcNaN;
      significandParts().$set(0, mysignificand);
      significandParts().$set(1, mysignificand2);
    } else {
      category = fltCategory.fcNormal;
      exponent = $ullong2short(myexponent - $int2ullong(16383));
      significandParts().$set(0, mysignificand);
      significandParts().$set(1, mysignificand2);
      if (myexponent == $int2ullong(0)) { // denormal
        exponent = -16382;
      } else {
        significandParts().$set$orassign(1, 0x1000000000000L/*LL*/); // integer bit
      }
    }
  }

  
  /// Integer bit is explicit in this format.  Intel hardware (387 and later)
  /// does not support these bit patterns:
  ///  exponent = all 1's, integer bit 0, significand 0 ("pseudoinfinity")
  ///  exponent = all 1's, integer bit 0, significand nonzero ("pseudoNaN")
  ///  exponent = 0, integer bit 1 ("pseudodenormal")
  ///  exponent!=0 nor all 1's, integer bit 0 ("unnormal")
  /// At the moment, the first two are treated as NaNs, the second two as Normal.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::initFromF80LongDoubleAPInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3152,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3149,
   FQN="llvm::APFloat::initFromF80LongDoubleAPInt", NM="_ZN4llvm7APFloat26initFromF80LongDoubleAPIntERKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat26initFromF80LongDoubleAPIntERKNS_5APIntE")
  //</editor-fold>
  private void initFromF80LongDoubleAPInt(final /*const*/ APInt /*&*/ api) {
    assert (api.getBitWidth() == 80);
    long/*uint64_t*/ i1 = api.getRawData().$at(0);
    long/*uint64_t*/ i2 = api.getRawData().$at(1);
    long/*uint64_t*/ myexponent = (i2 & $int2ullong(0x7fff));
    long/*uint64_t*/ mysignificand = i1;
    
    initialize($AddrOf(APFloat.x87DoubleExtended));
    assert (partCount() == 2);
    
    sign = $uint2uint_1bit(((/*static_cast*//*uint*/int)($ulong2uint(i2 >>> 15))));
    if (myexponent == $int2ullong(0) && mysignificand == $int2ullong(0)) {
      // exponent, significand meaningless
      category = fltCategory.fcZero;
    } else if (myexponent == $int2ullong(0x7fff) && mysignificand == 0x8000000000000000L/*ULL*/) {
      // exponent, significand meaningless
      category = fltCategory.fcInfinity;
    } else if (myexponent == $int2ullong(0x7fff) && mysignificand != 0x8000000000000000L/*ULL*/) {
      // exponent meaningless
      category = fltCategory.fcNaN;
      significandParts().$set(0, mysignificand);
      significandParts().$set(1, $int2ulong(0));
    } else {
      category = fltCategory.fcNormal;
      exponent = $ullong2short(myexponent - $int2ullong(16383));
      significandParts().$set(0, mysignificand);
      significandParts().$set(1, $int2ulong(0));
      if (myexponent == $int2ullong(0)) { // denormal
        exponent = -16382;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::initFromPPCDoubleDoubleAPInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3186,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 3183,
   FQN="llvm::APFloat::initFromPPCDoubleDoubleAPInt", NM="_ZN4llvm7APFloat28initFromPPCDoubleDoubleAPIntERKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat28initFromPPCDoubleDoubleAPIntERKNS_5APIntE")
  //</editor-fold>
  private void initFromPPCDoubleDoubleAPInt(final /*const*/ APInt /*&*/ api) {
    assert (api.getBitWidth() == 128);
    long/*uint64_t*/ i1 = api.getRawData().$at(0);
    long/*uint64_t*/ i2 = api.getRawData().$at(1);
    /*opStatus*//*uint*/int fs;
    bool$ptr losesInfo = create_bool$ptr();
    
    // Get the first double and convert to our format.
    initFromDoubleAPInt(new APInt(64, i1));
    fs = convert(PPCDoubleDouble, roundingMode.rmNearestTiesToEven, $AddrOf(losesInfo));
    assert (fs == opStatus.opOK && !losesInfo.$star());
    ///*J:(void)*/fs;
    
    // Unless we have a special case, add in second double.
    if (isFiniteNonZero()) {
      APFloat v/*J*/= new APFloat(IEEEdouble, new APInt(64, i2));
      fs = v.convert(PPCDoubleDouble, roundingMode.rmNearestTiesToEven, $AddrOf(losesInfo));
      assert (fs == opStatus.opOK && !losesInfo.$star());
      ///*J:(void)*/fs;
      
      add(v, roundingMode.rmNearestTiesToEven);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::assign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 598,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 595,
   FQN="llvm::APFloat::assign", NM="_ZN4llvm7APFloat6assignERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat6assignERKS0_")
  //</editor-fold>
  private void assign(final /*const*/ APFloat /*&*/ rhs) {
    assert (semantics == rhs.semantics);
    
    sign = rhs.sign;
    category = rhs.category;
    exponent = rhs.exponent;
    if (isFiniteNonZero() || category == fltCategory.fcNaN) {
      copySignificand(rhs);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::copySignificand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 610,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 607,
   FQN="llvm::APFloat::copySignificand", NM="_ZN4llvm7APFloat15copySignificandERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat15copySignificandERKS0_")
  //</editor-fold>
  private void copySignificand(final /*const*/ APFloat /*&*/ rhs) {
    assert (isFiniteNonZero() || category == fltCategory.fcNaN);
    assert ($greatereq_uint(rhs.partCount(), partCount()));
    
    APInt.tcAssign(significandParts(), rhs.significandParts$Const(), 
        partCount());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::freeSignificand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 591,
   old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 588,
   FQN="llvm::APFloat::freeSignificand", NM="_ZN4llvm7APFloat15freeSignificandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat15freeSignificandEv")
  //</editor-fold>
  private void freeSignificand() {
    if (needsCleanup()) {
      /*delete[]*/Destructors.$destroyArray(significand.parts);
    }
  }

  
  /// The semantics that this value obeys.
  /*friend*/public /*const*/ fltSemantics /*P*/ semantics;
  
  /// A binary fraction with an explicit integer bit.
  ///
  /// The significand must be at least one bit wider than the target precision.
  //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::Significand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 627,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 631,
   FQN="llvm::APFloat::Significand", NM="_ZN4llvm7APFloat11SignificandE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat11SignificandE")
  //</editor-fold>
  private static class/*union*/ Significand {
    public long/*uint64_t*/ part;
    public ulong$ptr/*uint64_t P*/ parts;
    //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::Significand::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*fixed assign*/,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 627,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 631,
     FQN="llvm::APFloat::Significand::operator=", NM="_ZN4llvm7APFloat11SignificandaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat11SignificandaSERKS1_")
    //</editor-fold>
    public /*inline*/ Significand /*&*/ $assign(final /*const*/ Significand /*&*/ $Prm0) {
      this.part = $Prm0.part;
      this.parts = $tryClone($Prm0.parts);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::Significand::Significand">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 627,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 631,
     FQN="llvm::APFloat::Significand::Significand", NM="_ZN4llvm7APFloat11SignificandC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat11SignificandC1Ev")
    //</editor-fold>
    public /*inline*/ Significand() {
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::APFloat::Significand::Significand">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 627,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 631,
     FQN="llvm::APFloat::Significand::Significand", NM="_ZN4llvm7APFloat11SignificandC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7APFloat11SignificandC1ERKS1_")
    //</editor-fold>
    public /*inline*/ Significand(final /*const*/ Significand /*&*/ $Prm0) {
    }

    
    @Override public String toString() {
      return "" + "part=" + part // NOI18N
                + ", parts=" + parts; // NOI18N
    }
  };
  private  Significand significand;
  
  /// The signed unbiased exponent of the value.
  /*friend*/public short exponent;
  
  /// What kind of floating point number this is.
  ///
  /// Only 2 bits are required, but VisualStudio incorrectly sign extends it.
  /// Using the extra bit keeps it from failing under VisualStudio.
  /*friend*/public fltCategory category /*: 3*/;
  
  /// Sign bit of the number.
  /*friend*/public /*JBIT unsigned int*/ boolean sign /*: 1*/;
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override public APFloat move() { return new APFloat(JD$Move.INSTANCE, this); }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    String txt = "";
    try {
      SmallString buf = new SmallString(64);
      __toString(buf);
      txt = buf.toJavaString();
    } catch (Throwable e) {
      txt = "<ERROR>";
    }  
    return "[" + txt + "]: semantics=" + semantics // NOI18N
              + ", significand=" + significand // NOI18N
              + ", exponent=" + exponent // NOI18N
              + ", category=" + category // NOI18N
              + ", sign=" + sign; // NOI18N
  }
}
