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

package org.llvm.support;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.support.*;


/// \brief Simple representation of a scaled number.
///
/// ScaledNumber is a number represented by digits and a scale.  It uses simple
/// saturation arithmetic and every operation is well-defined for every value.
/// It's somewhat similar in behaviour to a soft-float, but is *not* a
/// replacement for one.  If you're doing numerics, look at \a APFloat instead.
/// Nevertheless, we've found these semantics useful for modelling certain cost
/// metrics.
///
/// The number is split into a signed scale and unsigned digits.  The number
/// represented is \c getDigits()*2^getScale().  In this way, the digits are
/// much like the mantissa in the x87 long double, but there is no canonical
/// form so the same number can be represented by many bit representations.
///
/// ScaledNumber is templated on the underlying integer type for digits, which
/// is expected to be unsigned.
///
/// Unlike APFloat, ScaledNumber does not model architecture floating point
/// behaviour -- while this might make it a little faster and easier to reason
/// about, it certainly makes it more dangerous for general numerics.
///
/// ScaledNumber is totally ordered.  However, there is no canonical form, so
/// there are multiple representations of most scalars.  E.g.:
///
///     ScaledNumber(8u, 0) == ScaledNumber(4u, 1)
///     ScaledNumber(4u, 1) == ScaledNumber(2u, 2)
///     ScaledNumber(2u, 2) == ScaledNumber(1u, 3)
///
/// ScaledNumber implements most arithmetic operations.  Precision is kept
/// where possible.  Uses simple saturation arithmetic, so that operations
/// saturate to 0.0 or getLargest() rather than under or overflowing.  It has
/// some extra arithmetic for unit inversion.  0.0/0.0 is defined to be 0.0.
/// Any other division by 0.0 is defined to be getLargest().
///
/// As a convenience for modifying the exponent, left and right shifting are
/// both implemented, and both interpret negative shifts as positive shifts in
/// the opposite direction.
///
/// Scales are limited to the range accepted by x87 long double.  This makes
/// it trivial to add functionality to convert to APFloat (this is already
/// relied on for the implementation of printing).
///
/// Possible (and conflicting) future directions:
///
///  1. Turn this into a wrapper around \a APFloat.
///  2. Share the algorithm implementations with \a APFloat.
///  3. Allow \a ScaledNumber to represent a signed number.
/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 493,
 FQN="llvm::ScaledNumber", NM="_ZN4llvm12ScaledNumberE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumberE")
//</editor-fold>
public class ScaledNumber</*class*/ DigitsT>  extends /**/ ScaledNumberBase implements Native.NativeComparable<ScaledNumber> {
/*public:*/
  //static { static_assert(Native.$not(std.numeric_limits.<DigitsT>is_signed), $("only unsigned floats supported")); };
  
  // JAVA: typedef DigitsT DigitsType
//  public final class DigitsType extends DigitsT{ };
/*private:*/
  // JAVA: typedef std::numeric_limits<DigitsType> DigitsLimits
//  public final class DigitsLimits extends std.numeric_limits<DigitsT>{ };
  
  //private static /*const*/int Width = $sizeof_T() * 8;
  //static { static_assert(Width <= 64, $("invalid integer width for digits")); };
/*private:*/
  private DigitsT Digits;
  private short/*int16_t*/ Scale;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::ScaledNumber<DigitsT>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 511,
   FQN="llvm::ScaledNumber::ScaledNumber<DigitsT>", NM="_ZN4llvm12ScaledNumberC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumberC1Ev")
  //</editor-fold>
  public ScaledNumber() {
    // : Digits(0), Scale(0) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::ScaledNumber<DigitsT>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 513,
   FQN="llvm::ScaledNumber::ScaledNumber<DigitsT>", NM="_ZN4llvm12ScaledNumberC1ET_s",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumberC1ET_s")
  //</editor-fold>
  public ScaledNumber(DigitsT Digits, short/*int16_t*/ Scale) {
    // : Digits(Digits), Scale(Scale) 
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::ScaledNumber<DigitsT>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 517,
   FQN="llvm::ScaledNumber::ScaledNumber<DigitsT>", NM="_ZN4llvm12ScaledNumberC1ERKSt4pairIT_sE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumberC1ERKSt4pairIT_sE")
  //</editor-fold>
  private ScaledNumber(final /*const*/ std.pairTypeShort<DigitsT/*, short int16_t*/> /*&*/ X) {
    // : Digits(X.first), Scale(X.second) 
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::getZero">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 521,
   FQN="llvm::ScaledNumber::getZero", NM="_ZN4llvm12ScaledNumber7getZeroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumber7getZeroEv")
  //</editor-fold>
  public static </*class*/ DigitsT> ScaledNumber<DigitsT> getZero() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::getOne">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 522,
   FQN="llvm::ScaledNumber::getOne", NM="_ZN4llvm12ScaledNumber6getOneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumber6getOneEv")
  //</editor-fold>
  public static </*class*/ DigitsT> ScaledNumber<DigitsT> getOne() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::getLargest">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 523,
   FQN="llvm::ScaledNumber::getLargest", NM="_ZN4llvm12ScaledNumber10getLargestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumber10getLargestEv")
  //</editor-fold>
  public static </*class*/ DigitsT> ScaledNumber<DigitsT> getLargest() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::get">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 526,
   FQN="llvm::ScaledNumber::get", NM="_ZN4llvm12ScaledNumber3getEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumber3getEy")
  //</editor-fold>
  public static </*class*/ DigitsT> ScaledNumber<DigitsT> get(long/*uint64_t*/ N) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::getInverse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 527,
   FQN="llvm::ScaledNumber::getInverse", NM="_ZN4llvm12ScaledNumber10getInverseEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumber10getInverseEy")
  //</editor-fold>
  public static </*class*/ DigitsT> ScaledNumber<DigitsT> getInverse(long/*uint64_t*/ N) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::getFraction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 530,
   FQN="llvm::ScaledNumber::getFraction", NM="_ZN4llvm12ScaledNumber11getFractionET_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumber11getFractionET_S1_")
  //</editor-fold>
  public static </*class*/ DigitsT> ScaledNumber<DigitsT> getFraction(DigitsT N, DigitsT D) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::getScale">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 534,
   FQN="llvm::ScaledNumber::getScale", NM="_ZNK4llvm12ScaledNumber8getScaleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumber8getScaleEv")
  //</editor-fold>
  public short/*int16_t*/ getScale() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::getDigits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 535,
   FQN="llvm::ScaledNumber::getDigits", NM="_ZNK4llvm12ScaledNumber9getDigitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumber9getDigitsEv")
  //</editor-fold>
  public DigitsT getDigits() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Convert to the given integer type.
  ///
  /// Convert to \c IntT using simple saturating arithmetic, truncating if
  /// necessary.
  /*template <class IntT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::toInt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 779,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", old_line = 780,
   FQN="llvm::ScaledNumber::toInt", NM="Tpl__ZNK4llvm12ScaledNumber5toIntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZNK4llvm12ScaledNumber5toIntEv")
  //</editor-fold>
  public </*class*/ IntT> IntT toInt() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::isZero">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 543,
   FQN="llvm::ScaledNumber::isZero", NM="_ZNK4llvm12ScaledNumber6isZeroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumber6isZeroEv")
  //</editor-fold>
  public boolean isZero() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::isLargest">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 544,
   FQN="llvm::ScaledNumber::isLargest", NM="_ZNK4llvm12ScaledNumber9isLargestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumber9isLargestEv")
  //</editor-fold>
  public boolean isLargest() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::isOne">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 545,
   FQN="llvm::ScaledNumber::isOne", NM="_ZNK4llvm12ScaledNumber5isOneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumber5isOneEv")
  //</editor-fold>
  public boolean isOne() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief The log base 2, rounded.
  ///
  /// Get the lg of the scalar.  lg 0 is defined to be INT32_MIN.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::lg">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 554,
   FQN="llvm::ScaledNumber::lg", NM="_ZNK4llvm12ScaledNumber2lgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumber2lgEv")
  //</editor-fold>
  public int/*int32_t*/ lg() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief The log base 2, rounded towards INT32_MIN.
  ///
  /// Get the lg floor.  lg 0 is defined to be INT32_MIN.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::lgFloor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 559,
   FQN="llvm::ScaledNumber::lgFloor", NM="_ZNK4llvm12ScaledNumber7lgFloorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumber7lgFloorEv")
  //</editor-fold>
  public int/*int32_t*/ lgFloor() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief The log base 2, rounded towards INT32_MAX.
  ///
  /// Get the lg ceiling.  lg 0 is defined to be INT32_MIN.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::lgCeiling">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 564,
   FQN="llvm::ScaledNumber::lgCeiling", NM="_ZNK4llvm12ScaledNumber9lgCeilingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumber9lgCeilingEv")
  //</editor-fold>
  public int/*int32_t*/ lgCeiling() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 568,
   FQN="llvm::ScaledNumber::operator==", NM="_ZNK4llvm12ScaledNumbereqERKNS_12ScaledNumberIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumbereqERKNS_12ScaledNumberIT_EE")
  //</editor-fold>
  public boolean $eq(final /*const*/ ScaledNumber<DigitsT> /*&*/ X) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::operator<">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 569,
   FQN="llvm::ScaledNumber::operator<", NM="_ZNK4llvm12ScaledNumberltERKNS_12ScaledNumberIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumberltERKNS_12ScaledNumberIT_EE")
  //</editor-fold>
  public boolean $less(final /*const*/ ScaledNumber<DigitsT> /*&*/ X) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::operator!=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 570,
   FQN="llvm::ScaledNumber::operator!=", NM="_ZNK4llvm12ScaledNumberneERKNS_12ScaledNumberIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumberneERKNS_12ScaledNumberIT_EE")
  //</editor-fold>
  public boolean $noteq(final /*const*/ ScaledNumber<DigitsT> /*&*/ X) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::operator>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 571,
   FQN="llvm::ScaledNumber::operator>", NM="_ZNK4llvm12ScaledNumbergtERKNS_12ScaledNumberIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumbergtERKNS_12ScaledNumberIT_EE")
  //</editor-fold>
  public boolean $greater(final /*const*/ ScaledNumber<DigitsT> /*&*/ X) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::operator<=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 572,
   FQN="llvm::ScaledNumber::operator<=", NM="_ZNK4llvm12ScaledNumberleERKNS_12ScaledNumberIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumberleERKNS_12ScaledNumberIT_EE")
  //</editor-fold>
  public boolean $lesseq(final /*const*/ ScaledNumber<DigitsT> /*&*/ X) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::operator>=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 573,
   FQN="llvm::ScaledNumber::operator>=", NM="_ZNK4llvm12ScaledNumbergeERKNS_12ScaledNumberIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumbergeERKNS_12ScaledNumberIT_EE")
  //</editor-fold>
  public boolean $greatereq(final /*const*/ ScaledNumber<DigitsT> /*&*/ X) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::operator!">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 575,
   FQN="llvm::ScaledNumber::operator!", NM="_ZNK4llvm12ScaledNumberntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumberntEv")
  //</editor-fold>
  public boolean $not() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Convert to a decimal representation in a string.
  ///
  /// Convert to a string.  Uses scientific notation for very large/small
  /// numbers.  Scientific notation is used roughly for numbers outside of the
  /// range 2^-64 through 2^64.
  ///
  /// \c Precision indicates the number of decimal digits of precision to use;
  /// 0 requests the maximum available.
  ///
  /// As a special case to make debugging easier, if the number is small enough
  /// to convert without scientific notation and has more than \c Precision
  /// digits before the decimal place, it's printed accurately to the first
  /// digit past zero.  E.g., assuming 10 digits of precision:
  ///
  ///     98765432198.7654... => 98765432198.8
  ///      8765432198.7654... =>  8765432198.8
  ///       765432198.7654... =>   765432198.8
  ///        65432198.7654... =>    65432198.77
  ///         5432198.7654... =>     5432198.765
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::toString">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 596,
   FQN="llvm::ScaledNumber::toString", NM="_ZN4llvm12ScaledNumber8toStringEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumber8toStringEj")
  //</editor-fold>
  public std.string __toString() {
    return __toString(DefaultPrecision);
  }
  public std.string __toString(/*uint*/int Precision/*= DefaultPrecision*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Print a decimal representation.
  ///
  /// Print a string.  See toString for documentation.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 603,
   FQN="llvm::ScaledNumber::print", NM="_ZNK4llvm12ScaledNumber5printERNS_11raw_ostreamEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumber5printERNS_11raw_ostreamEj")
  //</editor-fold>
  public raw_ostream /*&*/ print(final raw_ostream /*&*/ OS) /*const*/ {
    return print(OS, 
       DefaultPrecision);
  }
  public raw_ostream /*&*/ print(final raw_ostream /*&*/ OS, 
       /*uint*/int Precision/*= DefaultPrecision*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 607,
   FQN="llvm::ScaledNumber::dump", NM="_ZNK4llvm12ScaledNumber4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumber4dumpEv")
  //</editor-fold>
  public void dump() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::operator+=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 609,
   FQN="llvm::ScaledNumber::operator+=", NM="_ZN4llvm12ScaledNumberpLERKNS_12ScaledNumberIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumberpLERKNS_12ScaledNumberIT_EE")
  //</editor-fold>
  public ScaledNumber<DigitsT> /*&*/ $addassign(final /*const*/ ScaledNumber<DigitsT> /*&*/ X) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::operator-=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 617,
   FQN="llvm::ScaledNumber::operator-=", NM="_ZN4llvm12ScaledNumbermIERKNS_12ScaledNumberIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumbermIERKNS_12ScaledNumberIT_EE")
  //</editor-fold>
  public ScaledNumber<DigitsT> /*&*/ $minusassign(final /*const*/ ScaledNumber<DigitsT> /*&*/ X) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::operator*=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 800,
   FQN="llvm::ScaledNumber::operator*=", NM="_ZN4llvm12ScaledNumbermLERKNS_12ScaledNumberIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumbermLERKNS_12ScaledNumberIT_EE")
  //</editor-fold>
  public ScaledNumber<DigitsT> /*&*/ $starassign(final /*const*/ ScaledNumber<DigitsT> /*&*/ X) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::operator/=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 817,
   FQN="llvm::ScaledNumber::operator/=", NM="_ZN4llvm12ScaledNumberdVERKNS_12ScaledNumberIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumberdVERKNS_12ScaledNumberIT_EE")
  //</editor-fold>
  public ScaledNumber<DigitsT> /*&*/ $slashassign(final /*const*/ ScaledNumber<DigitsT> /*&*/ X) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::operator<<=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 624,
   FQN="llvm::ScaledNumber::operator<<=", NM="_ZN4llvm12ScaledNumberlSEs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumberlSEs")
  //</editor-fold>
  public ScaledNumber<DigitsT> /*&*/ $lshiftassign(short/*int16_t*/ Shift) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::operator>>=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 628,
   FQN="llvm::ScaledNumber::operator>>=", NM="_ZN4llvm12ScaledNumberrSEs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumberrSEs")
  //</editor-fold>
  public ScaledNumber<DigitsT> /*&*/ $rshiftassign(short/*int16_t*/ Shift) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::shiftLeft">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 834,
   FQN="llvm::ScaledNumber::shiftLeft", NM="_ZN4llvm12ScaledNumber9shiftLeftEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumber9shiftLeftEi")
  //</editor-fold>
  private void shiftLeft(int/*int32_t*/ Shift) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::shiftRight">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 864,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", old_line = 865,
   FQN="llvm::ScaledNumber::shiftRight", NM="_ZN4llvm12ScaledNumber10shiftRightEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumber10shiftRightEi")
  //</editor-fold>
  private void shiftRight(int/*int32_t*/ Shift) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Adjust two floats to have matching exponents.
  ///
  /// Adjust \c this and \c X to have matching exponents.  Returns the new \c X
  /// by value.  Does nothing if \a isZero() for either.
  ///
  /// The value that compares smaller will lose precision, and possibly become
  /// \a isZero().
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::matchScales">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 644,
   FQN="llvm::ScaledNumber::matchScales", NM="_ZN4llvm12ScaledNumber11matchScalesENS_12ScaledNumberIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumber11matchScalesENS_12ScaledNumberIT_EE")
  //</editor-fold>
  private ScaledNumber<DigitsT> matchScales(ScaledNumber<DigitsT> X) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  /// \brief Scale a large number accurately.
  ///
  /// Scale N (multiply it by this).  Uses full precision multiplication, even
  /// if Width is smaller than 64, so information is not lost.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::scale">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 770,
   FQN="llvm::ScaledNumber::scale", NM="_ZNK4llvm12ScaledNumber5scaleEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumber5scaleEy")
  //</editor-fold>
  public long/*uint64_t*/ scale_ulong(long/*uint64_t*/ N) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::scaleByInverse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 655,
   FQN="llvm::ScaledNumber::scaleByInverse", NM="_ZNK4llvm12ScaledNumber14scaleByInverseEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumber14scaleByInverseEy")
  //</editor-fold>
  public long/*uint64_t*/ scaleByInverse_ulong(long/*uint64_t*/ N) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::scale">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 660,
   FQN="llvm::ScaledNumber::scale", NM="_ZNK4llvm12ScaledNumber5scaleEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumber5scaleEx")
  //</editor-fold>
  public long/*int64_t*/ scale_long(long/*int64_t*/ N) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::scaleByInverse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 664,
   FQN="llvm::ScaledNumber::scaleByInverse", NM="_ZNK4llvm12ScaledNumber14scaleByInverseEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumber14scaleByInverseEx")
  //</editor-fold>
  public long/*int64_t*/ scaleByInverse_long(long/*int64_t*/ N) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::compare">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 669,
   FQN="llvm::ScaledNumber::compare", NM="_ZNK4llvm12ScaledNumber7compareERKNS_12ScaledNumberIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumber7compareERKNS_12ScaledNumberIT_EE")
  //</editor-fold>
  public int compare(final /*const*/ ScaledNumber<DigitsT> /*&*/ X) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::compareTo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 672,
   FQN="llvm::ScaledNumber::compareTo", NM="_ZNK4llvm12ScaledNumber9compareToEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumber9compareToEy")
  //</editor-fold>
  public int compareTo_ulong(long/*uint64_t*/ N) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::compareTo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 675,
   FQN="llvm::ScaledNumber::compareTo", NM="_ZNK4llvm12ScaledNumber9compareToEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumber9compareToEx")
  //</editor-fold>
  public int compareTo_long(long/*int64_t*/ N) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::invert">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 677,
   FQN="llvm::ScaledNumber::invert", NM="_ZN4llvm12ScaledNumber6invertEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumber6invertEv")
  //</editor-fold>
  public ScaledNumber<DigitsT> /*&*/ invert() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::inverse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 678,
   FQN="llvm::ScaledNumber::inverse", NM="_ZNK4llvm12ScaledNumber7inverseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZNK4llvm12ScaledNumber7inverseEv")
  //</editor-fold>
  public ScaledNumber<DigitsT> inverse() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::getProduct">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 681,
   FQN="llvm::ScaledNumber::getProduct", NM="_ZN4llvm12ScaledNumber10getProductET_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumber10getProductET_S1_")
  //</editor-fold>
  private static </*class*/ DigitsT> ScaledNumber<DigitsT> getProduct(DigitsT LHS, DigitsT RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::getQuotient">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 684,
   FQN="llvm::ScaledNumber::getQuotient", NM="_ZN4llvm12ScaledNumber11getQuotientET_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumber11getQuotientET_S1_")
  //</editor-fold>
  private static </*class*/ DigitsT> ScaledNumber<DigitsT> getQuotient(DigitsT Dividend, DigitsT Divisor) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::countLeadingZerosWidth">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 688,
   FQN="llvm::ScaledNumber::countLeadingZerosWidth", NM="_ZN4llvm12ScaledNumber22countLeadingZerosWidthET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumber22countLeadingZerosWidthET_")
  //</editor-fold>
  private static </*class*/ DigitsT> int countLeadingZerosWidth(DigitsT Digits) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Adjust a number to width, rounding up if necessary.
  ///
  /// Should only be called for \c Shift close to zero.
  ///
  /// \pre Shift >= MinScale && Shift + 64 <= MaxScale.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::adjustToWidth">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 701,
   FQN="llvm::ScaledNumber::adjustToWidth", NM="_ZN4llvm12ScaledNumber13adjustToWidthEyi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumber13adjustToWidthEyi")
  //</editor-fold>
  private static </*class*/ DigitsT> ScaledNumber<DigitsT> adjustToWidth(long/*uint64_t*/ N, int/*int32_t*/ Shift) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ScaledNumber::getRounded">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 709,
   FQN="llvm::ScaledNumber::getRounded", NM="_ZN4llvm12ScaledNumber10getRoundedENS_12ScaledNumberIT_EEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvm12ScaledNumber10getRoundedENS_12ScaledNumberIT_EEb")
  //</editor-fold>
  private static </*class*/ DigitsT> ScaledNumber<DigitsT> getRounded(ScaledNumber<DigitsT> P, boolean Round) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Digits=" + Digits // NOI18N
              + ", Scale=" + Scale // NOI18N
              + super.toString(); // NOI18N
  }
}
