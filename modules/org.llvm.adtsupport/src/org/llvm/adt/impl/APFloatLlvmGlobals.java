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
package org.llvm.adt.impl;

import org.clank.java.std;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.JD$Move;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import static org.llvm.adt.HashingGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type APFloatLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.adt.impl.APFloatLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm10hash_valueERKNS_7APFloatE;_ZN4llvm3absENS_7APFloatE;_ZN4llvm5frexpERKNS_7APFloatERiNS0_12roundingModeE;_ZN4llvm5ilogbERKNS_7APFloatE;_ZN4llvm6maxnumERKNS_7APFloatES2_;_ZN4llvm6minnumERKNS_7APFloatES2_;_ZN4llvm6scalbnENS_7APFloatEiNS0_12roundingModeE; -static-type=APFloatLlvmGlobals -package=org.llvm.adt.impl")
//</editor-fold>
public final class APFloatLlvmGlobals {


/// \brief Overload to compute a hash code for an APFloat value.
///
/// Note that the use of hash codes for floating point values is in general
/// frought with peril. Equality is hard to define for these values. For
/// example, should negative and positive zero hash to different codes? Are
/// they equal or not? This hash value implementation specifically
/// emphasizes producing different codes for different inputs in order to
/// be used in canonicalization and memoization. As such, equality is
/// bitwiseIsEqual, and 0 != -0.
//<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 2869,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 2866,
 FQN="llvm::hash_value", NM="_ZN4llvm10hash_valueERKNS_7APFloatE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm10hash_valueERKNS_7APFloatE")
//</editor-fold>
public static hash_code hash_value(final /*const*/ APFloat /*&*/ Arg) {
  if (!Arg.isFiniteNonZero()) {
    return hash_combine((byte/*uint8_t*/)Arg.category.getValue(), 
        // NaN has no sign, fix it at zero.
        Arg.isNaN() ? (byte/*uint8_t*/)$int2uchar(0) : (byte/*uint8_t*/)$uint2uchar(Arg.sign), 
        Arg.semantics.precision);
  }

  // Normal floats need their exponent and significand hashed.
  return hash_combine((byte/*uint8_t*/)Arg.category.getValue(), (byte/*uint8_t*/)$uint2uchar(Arg.sign), 
      Arg.semantics.precision, Arg.exponent, 
      hash_combine_range(Arg.significandParts$Const(), 
          Arg.significandParts$Const().$add(Arg.partCount())));
}


/// \brief Returns the exponent of the internal representation of the APFloat.
///
/// Because the radix of APFloat is 2, this is equivalent to floor(log2(x)).
/// For special APFloat values, this returns special error codes:
///
///   NaN -> \c IEK_NaN
///   0   -> \c IEK_Zero
///   Inf -> \c IEK_Inf
///
//<editor-fold defaultstate="collapsed" desc="llvm::ilogb">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3954,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 514,
 FQN="llvm::ilogb", NM="_ZN4llvm5ilogbERKNS_7APFloatE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm5ilogbERKNS_7APFloatE")
//</editor-fold>
public static int ilogb(final /*const*/ APFloat /*&*/ Arg) {
  if (Arg.isNaN()) {
    return APFloat.IlogbErrorKinds.IEK_NaN.getValue();
  }
  if (Arg.isZero()) {
    return APFloat.IlogbErrorKinds.IEK_Zero.getValue();
  }
  if (Arg.isInfinity()) {
    return APFloat.IlogbErrorKinds.IEK_Inf.getValue();
  }
  if (!Arg.isDenormal()) {
    return Arg.exponent;
  }
  
  APFloat Normalized/*J*/= new APFloat(Arg);
  int SignificandBits = Arg.getSemantics().precision - 1;
  
  Normalized.exponent += SignificandBits;
  Normalized.normalize(APFloat.roundingMode.rmNearestTiesToEven, lostFraction.lfExactlyZero);
  return Normalized.exponent - SignificandBits;
}


/// \brief Returns: X * 2^Exp for integral exponents.
//<editor-fold defaultstate="collapsed" desc="llvm::scalbn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3972,
 FQN="llvm::scalbn", NM="_ZN4llvm6scalbnENS_7APFloatEiNS0_12roundingModeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm6scalbnENS_7APFloatEiNS0_12roundingModeE")
//</editor-fold>
public static APFloat scalbn(APFloat X, int Exp, APFloat.roundingMode RoundingMode) {
  short MaxExp = X.getSemantics().maxExponent;
  short MinExp = X.getSemantics().minExponent;
  
  // If Exp is wildly out-of-scale, simply adding it to X.exponent will
  // overflow; clamp it to a safe range before adding, but ensure that the range
  // is large enough that the clamp does not change the result. The range we
  // need to support is the difference between the largest possible exponent and
  // the normalized exponent of half the smallest denormal.
  int SignificandBits = X.getSemantics().precision - 1;
  int MaxIncrement = MaxExp - (MinExp - SignificandBits) + 1;
  
  // Clamp to one past the range ends to let normalize handle overlflow.
  X.exponent += std.min(std.max(Exp, -MaxIncrement - 1), MaxIncrement);
  X.normalize(RoundingMode, lostFraction.lfExactlyZero);
  if (X.isNaN()) {
    X.makeQuiet();
  }
  return new APFloat(JD$Move.INSTANCE, X);
}


/// \brief Equivalent of C standard library function.
///
/// While the C standard says Exp is an unspecified value for infinity and nan,
/// this returns INT_MAX for infinities, and INT_MIN for NaNs.
//<editor-fold defaultstate="collapsed" desc="llvm::frexp">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3993,
 FQN="llvm::frexp", NM="_ZN4llvm5frexpERKNS_7APFloatERiNS0_12roundingModeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm5frexpERKNS_7APFloatERiNS0_12roundingModeE")
//</editor-fold>
public static APFloat frexp(final /*const*/ APFloat /*&*/ Val, final int$ref/*int &*/ Exp, APFloat.roundingMode RM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Returns the absolute value of the argument.
//<editor-fold defaultstate="collapsed" desc="llvm::abs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 660,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 657,
 FQN="llvm::abs", NM="_ZN4llvm3absENS_7APFloatE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm3absENS_7APFloatE")
//</editor-fold>
public static /*inline*/ APFloat abs(APFloat X) {
  X.clearSign();
  return new APFloat(JD$Move.INSTANCE, X);
}


/// Implements IEEE minNum semantics. Returns the smaller of the 2 arguments if
/// both are not NaN. If either argument is a NaN, returns the other argument.
//<editor-fold defaultstate="collapsed" desc="llvm::minnum">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 667,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 664,
 FQN="llvm::minnum", NM="_ZN4llvm6minnumERKNS_7APFloatES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm6minnumERKNS_7APFloatES2_")
//</editor-fold>
public static /*inline*/ APFloat minnum(final /*const*/ APFloat /*&*/ A, final /*const*/ APFloat /*&*/ B)/* __attribute__((pure))*/ {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Implements IEEE maxNum semantics. Returns the larger of the 2 arguments if
/// both are not NaN. If either argument is a NaN, returns the other argument.
//<editor-fold defaultstate="collapsed" desc="llvm::maxnum">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 678,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 675,
 FQN="llvm::maxnum", NM="_ZN4llvm6maxnumERKNS_7APFloatES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm6maxnumERKNS_7APFloatES2_")
//</editor-fold>
public static /*inline*/ APFloat maxnum(final /*const*/ APFloat /*&*/ A, final /*const*/ APFloat /*&*/ B)/* __attribute__((pure))*/ {
  if (A.isNaN()) {
    return new APFloat(B);
  }
  if (B.isNaN()) {
    return new APFloat(A);
  }
  return new APFloat((A.compare(B) == APFloat.cmpResult.cmpLessThan) ? B : A);
}

} // END OF class APFloatLlvmGlobals
