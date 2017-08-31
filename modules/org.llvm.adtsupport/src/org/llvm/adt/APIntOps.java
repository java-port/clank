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
import org.llvm.adt.*;


//<editor-fold defaultstate="collapsed" desc="static type APIntOps">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -java-types-map=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -namespace=llvm::APIntOps")
//</editor-fold>
public final class APIntOps {


/// \brief Determine the smaller of two APInts considered to be signed.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::smin">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1747,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1734,
 FQN = "llvm::APIntOps::smin", NM = "_ZN4llvm8APIntOps4sminERKNS_5APIntES3_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps4sminERKNS_5APIntES3_")
//</editor-fold>
public static /*inline*/ APInt smin(/*const*/APInt /*&*/ A, /*const*/APInt /*&*/ B) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Determine the larger of two APInts considered to be signed.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::smax">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1750,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1737,
 FQN = "llvm::APIntOps::smax", NM = "_ZN4llvm8APIntOps4smaxERKNS_5APIntES3_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps4smaxERKNS_5APIntES3_")
//</editor-fold>
public static /*inline*/ APInt smax(/*const*/APInt /*&*/ A, /*const*/APInt /*&*/ B) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Determine the smaller of two APInts considered to be signed.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::umin">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1753,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1740,
 FQN = "llvm::APIntOps::umin", NM = "_ZN4llvm8APIntOps4uminERKNS_5APIntES3_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps4uminERKNS_5APIntES3_")
//</editor-fold>
public static /*inline*/ APInt umin(/*const*/APInt /*&*/ A, /*const*/APInt /*&*/ B) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Determine the larger of two APInts considered to be unsigned.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::umax">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1756,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1743,
 FQN = "llvm::APIntOps::umax", NM = "_ZN4llvm8APIntOps4umaxERKNS_5APIntES3_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps4umaxERKNS_5APIntES3_")
//</editor-fold>
public static /*inline*/ APInt umax(/*const*/APInt /*&*/ A, /*const*/APInt /*&*/ B) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Check if the specified APInt has a N-bits unsigned integer value.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::isIntN">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1759,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1746,
 FQN = "llvm::APIntOps::isIntN", NM = "_ZN4llvm8APIntOps6isIntNEjRKNS_5APIntE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps6isIntNEjRKNS_5APIntE")
//</editor-fold>
public static /*inline*/ boolean isIntN(/*uint*/int N, /*const*/APInt /*&*/ APIVal) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Check if the specified APInt has a N-bits signed integer value.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::isSignedIntN">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1762,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1749,
 FQN = "llvm::APIntOps::isSignedIntN", NM = "_ZN4llvm8APIntOps12isSignedIntNEjRKNS_5APIntE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps12isSignedIntNEjRKNS_5APIntE")
//</editor-fold>
public static /*inline*/ boolean isSignedIntN(/*uint*/int N, /*const*/APInt /*&*/ APIVal) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \returns true if the argument APInt value is a sequence of ones starting at
/// the least significant bit with the remainder zero.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::isMask">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1768,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1755,
 FQN = "llvm::APIntOps::isMask", NM = "_ZN4llvm8APIntOps6isMaskEjRKNS_5APIntE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps6isMaskEjRKNS_5APIntE")
//</editor-fold>
public static /*inline*/ boolean isMask(/*uint*/int numBits, /*const*/APInt /*&*/ APIVal) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Return true if the argument APInt value contains a sequence of ones
/// with the remainder zero.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::isShiftedMask">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1775,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1762,
 FQN = "llvm::APIntOps::isShiftedMask", NM = "_ZN4llvm8APIntOps13isShiftedMaskEjRKNS_5APIntE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps13isShiftedMaskEjRKNS_5APIntE")
//</editor-fold>
public static /*inline*/ boolean isShiftedMask(/*uint*/int numBits, /*const*/APInt /*&*/ APIVal) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Returns a byte-swapped representation of the specified APInt Value.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::byteSwap">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1780,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1767,
 FQN = "llvm::APIntOps::byteSwap", NM = "_ZN4llvm8APIntOps8byteSwapERKNS_5APIntE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps8byteSwapERKNS_5APIntE")
//</editor-fold>
public static /*inline*/ APInt byteSwap(/*const*/APInt /*&*/ APIVal) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Returns the floor log base 2 of the specified APInt value.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::logBase2">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1783,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1770,
 FQN = "llvm::APIntOps::logBase2", NM = "_ZN4llvm8APIntOps8logBase2ERKNS_5APIntE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps8logBase2ERKNS_5APIntE")
//</editor-fold>
public static /*inline*/ /*uint*/int logBase2(/*const*/APInt /*&*/ APIVal) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Compute GCD of two APInt values.
///
/// This function returns the greatest common divisor of the two APInt values
/// using Euclid's algorithm.
///
/// \returns the greatest common divisor of Val1 and Val2
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::GreatestCommonDivisor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 817,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 809,
 FQN = "llvm::APIntOps::GreatestCommonDivisor", NM = "_ZN4llvm8APIntOps21GreatestCommonDivisorERKNS_5APIntES3_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps21GreatestCommonDivisorERKNS_5APIntES3_")
//</editor-fold>
public static APInt GreatestCommonDivisor(/*const*/APInt /*&*/ API1, /*const*/APInt /*&*/ API2) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Converts the given APInt to a double value.
///
/// Treats the APInt as an unsigned value for conversion purposes.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::RoundAPIntToDouble">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1796,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1783,
 FQN = "llvm::APIntOps::RoundAPIntToDouble", NM = "_ZN4llvm8APIntOps18RoundAPIntToDoubleERKNS_5APIntE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps18RoundAPIntToDoubleERKNS_5APIntE")
//</editor-fold>
public static /*inline*/ double RoundAPIntToDouble(/*const*/APInt /*&*/ APIVal) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Converts the given APInt to a double value.
///
/// Treats the APInt as a signed value for conversion purposes.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::RoundSignedAPIntToDouble">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1803,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1790,
 FQN = "llvm::APIntOps::RoundSignedAPIntToDouble", NM = "_ZN4llvm8APIntOps24RoundSignedAPIntToDoubleERKNS_5APIntE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps24RoundSignedAPIntToDoubleERKNS_5APIntE")
//</editor-fold>
public static /*inline*/ double RoundSignedAPIntToDouble(/*const*/APInt /*&*/ APIVal) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Converts the given APInt to a float vlalue.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::RoundAPIntToFloat">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1808,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1795,
 FQN = "llvm::APIntOps::RoundAPIntToFloat", NM = "_ZN4llvm8APIntOps17RoundAPIntToFloatERKNS_5APIntE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps17RoundAPIntToFloatERKNS_5APIntE")
//</editor-fold>
public static /*inline*/ float RoundAPIntToFloat(/*const*/APInt /*&*/ APIVal) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Converts the given APInt to a float value.
///
/// Treast the APInt as a signed value for conversion purposes.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::RoundSignedAPIntToFloat">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1815,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1802,
 FQN = "llvm::APIntOps::RoundSignedAPIntToFloat", NM = "_ZN4llvm8APIntOps23RoundSignedAPIntToFloatERKNS_5APIntE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps23RoundSignedAPIntToFloatERKNS_5APIntE")
//</editor-fold>
public static /*inline*/ float RoundSignedAPIntToFloat(/*const*/APInt /*&*/ APIVal) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Converts the given double value into a APInt.
///
/// This function convert a double value to an APInt value.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::RoundDoubleToAPInt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 828,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 820,
 FQN = "llvm::APIntOps::RoundDoubleToAPInt", NM = "_ZN4llvm8APIntOps18RoundDoubleToAPIntEdj",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps18RoundDoubleToAPIntEdj")
//</editor-fold>
public static APInt RoundDoubleToAPInt(double Double, /*uint*/int width) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Converts a float value into a APInt.
///
/// Converts a float value into an APInt value.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::RoundFloatToAPInt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1827,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1814,
 FQN = "llvm::APIntOps::RoundFloatToAPInt", NM = "_ZN4llvm8APIntOps17RoundFloatToAPIntEfj",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps17RoundFloatToAPIntEfj")
//</editor-fold>
public static /*inline*/ APInt RoundFloatToAPInt(float Float, /*uint*/int width) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Arithmetic right-shift function.
///
/// Arithmetic right-shift the APInt by shiftAmt.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::ashr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1834,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1821,
 FQN = "llvm::APIntOps::ashr", NM = "_ZN4llvm8APIntOps4ashrERKNS_5APIntEj",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps4ashrERKNS_5APIntEj")
//</editor-fold>
public static /*inline*/ APInt ashr(/*const*/APInt /*&*/ LHS, /*uint*/int shiftAmt) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Logical right-shift function.
///
/// Logical right-shift the APInt by shiftAmt.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::lshr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1841,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1828,
 FQN = "llvm::APIntOps::lshr", NM = "_ZN4llvm8APIntOps4lshrERKNS_5APIntEj",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps4lshrERKNS_5APIntEj")
//</editor-fold>
public static /*inline*/ APInt lshr(/*const*/APInt /*&*/ LHS, /*uint*/int shiftAmt) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Left-shift function.
///
/// Left-shift the APInt by shiftAmt.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::shl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1848,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1835,
 FQN = "llvm::APIntOps::shl", NM = "_ZN4llvm8APIntOps3shlERKNS_5APIntEj",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps3shlERKNS_5APIntEj")
//</editor-fold>
public static /*inline*/ APInt shl(/*const*/APInt /*&*/ LHS, /*uint*/int shiftAmt) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Signed division function for APInt.
///
/// Signed divide APInt LHS by APInt RHS.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::sdiv">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1855,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1842,
 FQN = "llvm::APIntOps::sdiv", NM = "_ZN4llvm8APIntOps4sdivERKNS_5APIntES3_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps4sdivERKNS_5APIntES3_")
//</editor-fold>
public static /*inline*/ APInt sdiv(/*const*/APInt /*&*/ LHS, /*const*/APInt /*&*/ RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Unsigned division function for APInt.
///
/// Unsigned divide APInt LHS by APInt RHS.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::udiv">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1860,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1847,
 FQN = "llvm::APIntOps::udiv", NM = "_ZN4llvm8APIntOps4udivERKNS_5APIntES3_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps4udivERKNS_5APIntES3_")
//</editor-fold>
public static /*inline*/ APInt udiv(/*const*/APInt /*&*/ LHS, /*const*/APInt /*&*/ RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Function for signed remainder operation.
///
/// Signed remainder operation on APInt.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::srem">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1865,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1852,
 FQN = "llvm::APIntOps::srem", NM = "_ZN4llvm8APIntOps4sremERKNS_5APIntES3_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps4sremERKNS_5APIntES3_")
//</editor-fold>
public static /*inline*/ APInt srem(/*const*/APInt /*&*/ LHS, /*const*/APInt /*&*/ RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Function for unsigned remainder operation.
///
/// Unsigned remainder operation on APInt.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::urem">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1870,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1857,
 FQN = "llvm::APIntOps::urem", NM = "_ZN4llvm8APIntOps4uremERKNS_5APIntES3_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps4uremERKNS_5APIntES3_")
//</editor-fold>
public static /*inline*/ APInt urem(/*const*/APInt /*&*/ LHS, /*const*/APInt /*&*/ RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Function for multiplication operation.
///
/// Performs multiplication on APInt values.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::mul">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1875,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1862,
 FQN = "llvm::APIntOps::mul", NM = "_ZN4llvm8APIntOps3mulERKNS_5APIntES3_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps3mulERKNS_5APIntES3_")
//</editor-fold>
public static /*inline*/ APInt mul(/*const*/APInt /*&*/ LHS, /*const*/APInt /*&*/ RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Function for addition operation.
///
/// Performs addition on APInt values.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::add">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1880,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1867,
 FQN = "llvm::APIntOps::add", NM = "_ZN4llvm8APIntOps3addERKNS_5APIntES3_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps3addERKNS_5APIntES3_")
//</editor-fold>
public static /*inline*/ APInt add(/*const*/APInt /*&*/ LHS, /*const*/APInt /*&*/ RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Function for subtraction operation.
///
/// Performs subtraction on APInt values.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::sub">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1885,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1872,
 FQN = "llvm::APIntOps::sub", NM = "_ZN4llvm8APIntOps3subERKNS_5APIntES3_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps3subERKNS_5APIntES3_")
//</editor-fold>
public static /*inline*/ APInt sub(/*const*/APInt /*&*/ LHS, /*const*/APInt /*&*/ RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Bitwise AND function for APInt.
///
/// Performs bitwise AND operation on APInt LHS and
/// APInt RHS.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::And">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1891,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1878,
 FQN = "llvm::APIntOps::And", NM = "_ZN4llvm8APIntOps3AndERKNS_5APIntES3_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps3AndERKNS_5APIntES3_")
//</editor-fold>
public static /*inline*/ APInt And(/*const*/APInt /*&*/ LHS, /*const*/APInt /*&*/ RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Bitwise OR function for APInt.
///
/// Performs bitwise OR operation on APInt LHS and APInt RHS.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::Or">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1896,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1883,
 FQN = "llvm::APIntOps::Or", NM = "_ZN4llvm8APIntOps2OrERKNS_5APIntES3_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps2OrERKNS_5APIntES3_")
//</editor-fold>
public static /*inline*/ APInt Or(/*const*/APInt /*&*/ LHS, /*const*/APInt /*&*/ RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Bitwise XOR function for APInt.
///
/// Performs bitwise XOR operation on APInt.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::Xor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1901,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1888,
 FQN = "llvm::APIntOps::Xor", NM = "_ZN4llvm8APIntOps3XorERKNS_5APIntES3_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps3XorERKNS_5APIntES3_")
//</editor-fold>
public static /*inline*/ APInt Xor(/*const*/APInt /*&*/ LHS, /*const*/APInt /*&*/ RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Bitwise complement function.
///
/// Performs a bitwise complement operation on APInt.
//<editor-fold defaultstate="collapsed" desc="llvm::APIntOps::Not">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1906,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1893,
 FQN = "llvm::APIntOps::Not", NM = "_ZN4llvm8APIntOps3NotERKNS_5APIntE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm8APIntOps3NotERKNS_5APIntE")
//</editor-fold>
public static /*inline*/ APInt Not(/*const*/APInt /*&*/ APIVal) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class APIntOps
