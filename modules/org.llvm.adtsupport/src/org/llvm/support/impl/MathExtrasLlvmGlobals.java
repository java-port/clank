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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.support.sys.*;


//<editor-fold defaultstate="collapsed" desc="static type MathExtrasLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.support.impl.MathExtrasLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=Tpl__ZN4llvm11findLastSetET_NS_12ZeroBehaviorE;Tpl__ZN4llvm11reverseBitsET_;Tpl__ZN4llvm12SignExtend32Ej;Tpl__ZN4llvm12SignExtend64Ey;Tpl__ZN4llvm12findFirstSetET_NS_12ZeroBehaviorE;Tpl__ZN4llvm12isShiftedIntEx;Tpl__ZN4llvm13SaturatingAddET_S0_PbR_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE;Tpl__ZN4llvm13isShiftedUIntEy;Tpl__ZN4llvm15countPopulationET_;Tpl__ZN4llvm16countLeadingOnesET_NS_12ZeroBehaviorE;Tpl__ZN4llvm17countLeadingZerosET_NS_12ZeroBehaviorE;Tpl__ZN4llvm17countTrailingOnesET_NS_12ZeroBehaviorE;Tpl__ZN4llvm18AbsoluteDifferenceET_S0_R_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE;Tpl__ZN4llvm18SaturatingMultiplyET_S0_PbR_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE;Tpl__ZN4llvm18countTrailingZerosET_NS_12ZeroBehaviorE;Tpl__ZN4llvm21SaturatingMultiplyAddET_S0_S0_PbR_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE;Tpl__ZN4llvm5isIntEx;Tpl__ZN4llvm6isUIntEy;_ZN4llvm11BitsToFloatEj;_ZN4llvm11ByteSwap_16Et;_ZN4llvm11ByteSwap_32Ej;_ZN4llvm11ByteSwap_64Ey;_ZN4llvm11FloatToBitsEf;_ZN4llvm12BitsToDoubleEy;_ZN4llvm12DoubleToBitsEd;_ZN4llvm12Log2_32_CeilEj;_ZN4llvm12Log2_64_CeilEy;_ZN4llvm12NextPowerOf2Ey;_ZN4llvm12SignExtend32Ejj;_ZN4llvm12SignExtend64Eyj;_ZN4llvm13PowerOf2FloorEy;_ZN4llvm13isPowerOf2_32Ej;_ZN4llvm13isPowerOf2_64Ey;_ZN4llvm16isShiftedMask_32Ej;_ZN4llvm16isShiftedMask_64Ey;_ZN4llvm17OffsetToAlignmentEyy;_ZN4llvm19alignmentAdjustmentEPKvj;_ZN4llvm23GreatestCommonDivisor64Eyy;_ZN4llvm4Log2Ed;_ZN4llvm5Hi_32Ey;_ZN4llvm5Lo_32Ey;_ZN4llvm5isIntILj16EEEbx;_ZN4llvm5isIntILj32EEEbx;_ZN4llvm5isIntILj8EEEbx;_ZN4llvm6isIntNEjx;_ZN4llvm6isUIntILj16EEEby;_ZN4llvm6isUIntILj32EEEby;_ZN4llvm6isUIntILj8EEEby;_ZN4llvm7Log2_32Ej;_ZN4llvm7Log2_64Ey;_ZN4llvm7Make_64Ejj;_ZN4llvm7alignToEyyy;_ZN4llvm7isUIntNEjy;_ZN4llvm7maxIntNEx;_ZN4llvm7minIntNEx;_ZN4llvm8MinAlignEyy;_ZN4llvm8maxUIntNEy;_ZN4llvm9alignAddrEPKvj;_ZN4llvm9alignDownEyyy;_ZN4llvm9isMask_32Ej;_ZN4llvm9isMask_64Ey; -static-type=MathExtrasLlvmGlobals -package=org.llvm.support.impl")
//</editor-fold>
public final class MathExtrasLlvmGlobals {

// namespace detail

/// \brief Count number of 0's from the least significant bit to the most
///   stopping at the first 1.
///
/// Only unsigned integral types are allowed.
///
/// \param ZB the behavior on an input of 0. Only ZB_Width and ZB_Undefined are
///   valid arguments.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::countTrailingZeros">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 111,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 108,
 FQN="llvm::countTrailingZeros", NM="Tpl__ZN4llvm18countTrailingZerosET_NS_12ZeroBehaviorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=Tpl__ZN4llvm18countTrailingZerosET_NS_12ZeroBehaviorE")
//</editor-fold>
public static </*typename*/ T> /*uint*/int countTrailingZeros(T Val) {
  return countTrailingZeros(Val, ZeroBehavior.ZB_Width);
}
public static </*typename*/ T> /*uint*/int countTrailingZeros(T Val, ZeroBehavior ZB/*= ZB_Width*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

// namespace detail

/// \brief Count number of 0's from the most significant bit to the least
///   stopping at the first 1.
///
/// Only unsigned integral types are allowed.
///
/// \param ZB the behavior on an input of 0. Only ZB_Width and ZB_Undefined are
///   valid arguments.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::countLeadingZeros">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 180,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 177,
 FQN="llvm::countLeadingZeros", NM="Tpl__ZN4llvm17countLeadingZerosET_NS_12ZeroBehaviorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=Tpl__ZN4llvm17countLeadingZerosET_NS_12ZeroBehaviorE")
//</editor-fold>
public static /*size_t*/int countLeadingZeros(long/*uint64_t*/ Val) {
  return countLeadingZeros(Val, ZeroBehavior.ZB_Width);
}
public static /*inline*/ /*uint*/int countLeadingZeros(long/*uint64_t*/ Val, ZeroBehavior ZB) {
  if (ZB != ZeroBehavior.ZB_Undefined && Val == 0)
    return 64;
  return Long.numberOfLeadingZeros(Val);
}

public static /*size_t*/int countLeadingZeros(int/*uint32_t*/ Val) {
  return countLeadingZeros(Val, ZeroBehavior.ZB_Width);
}
public static /*inline*/ /*uint*/int countLeadingZeros(int/*uint32_t*/ Val, ZeroBehavior ZB) {
  if (ZB != ZeroBehavior.ZB_Undefined && Val == 0)
    return 32;
  return Integer.numberOfLeadingZeros(Val);
}
public static /*size_t*/int countLeadingZeros(short Val) {
  return countLeadingZeros(Val, ZeroBehavior.ZB_Width);
}
public static /*inline*/ /*uint*/int countLeadingZeros(short/*uint32_t*/ Val, ZeroBehavior ZB) {
  if (ZB != ZeroBehavior.ZB_Undefined && Val == 0)
    return 16;
  throw new UnsupportedOperationException();
}
public static /*size_t*/int countLeadingZeros_uint64_t_ZeroBehavior(long/*uint64_t*/ Val) {
  return countLeadingZeros_uint64_t_ZeroBehavior(Val, ZeroBehavior.ZB_Width);
}
public static /*inline*/ /*uint*/int countLeadingZeros_uint64_t_ZeroBehavior(long/*uint64_t*/ Val, ZeroBehavior ZB) {
  return countLeadingZeros(Val, ZB);
}


/// \brief Get the index of the first set bit starting from the least
///   significant bit.
///
/// Only unsigned integral types are allowed.
///
/// \param ZB the behavior on an input of 0. Only ZB_Max and ZB_Undefined are
///   valid arguments.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::findFirstSet">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 194,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 192,
 FQN="llvm::findFirstSet", NM="Tpl__ZN4llvm12findFirstSetET_NS_12ZeroBehaviorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=Tpl__ZN4llvm12findFirstSetET_NS_12ZeroBehaviorE")
//</editor-fold>
public static </*typename*/ T> T findFirstSet(T Val) {
  return findFirstSet(Val, ZeroBehavior.ZB_Max);
}
public static </*typename*/ T> T findFirstSet(T Val, ZeroBehavior ZB/*= ZB_Max*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Get the index of the last set bit starting from the least
///   significant bit.
///
/// Only unsigned integral types are allowed.
///
/// \param ZB the behavior on an input of 0. Only ZB_Max and ZB_Undefined are
///   valid arguments.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::findLastSet">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 208,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 206,
 FQN="llvm::findLastSet", NM="Tpl__ZN4llvm11findLastSetET_NS_12ZeroBehaviorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=Tpl__ZN4llvm11findLastSetET_NS_12ZeroBehaviorE")
//</editor-fold>
public static </*typename*/ T> T findLastSet(T Val) {
  return findLastSet(Val, ZeroBehavior.ZB_Max);
}
public static </*typename*/ T> T findLastSet(T Val, ZeroBehavior ZB/*= ZB_Max*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Reverse the bits in \p Val.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::reverseBits">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 233,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 230,
 FQN="llvm::reverseBits", NM="Tpl__ZN4llvm11reverseBitsET_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=Tpl__ZN4llvm11reverseBitsET_")
//</editor-fold>
public static </*typename*/ T> T reverseBits(T Val) {
  throw new UnsupportedOperationException("EmptyBody");
}


// NOTE: The following support functions use the _32/_64 extensions instead of
// type overloading so that signed and unsigned integers can be used without
// ambiguity.

/// Hi_32 - This function returns the high 32 bits of a 64 bit value.
//<editor-fold defaultstate="collapsed" desc="llvm::Hi_32">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 248,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 246,
 FQN="llvm::Hi_32", NM="_ZN4llvm5Hi_32Ey",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm5Hi_32Ey")
//</editor-fold>
public static /*inline*/ /*uint32_t*/int Hi_32(long/*uint64_t*/ Value) {
  return ((/*static_cast*//*uint32_t*/int)($ulong2uint(Value >>> 32)));
}


/// Lo_32 - This function returns the low 32 bits of a 64 bit value.
//<editor-fold defaultstate="collapsed" desc="llvm::Lo_32">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 253,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 251,
 FQN="llvm::Lo_32", NM="_ZN4llvm5Lo_32Ey",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm5Lo_32Ey")
//</editor-fold>
public static /*inline*/ /*uint32_t*/int Lo_32(long/*uint64_t*/ Value) {
  return ((/*static_cast*//*uint32_t*/int)($ulong2uint(Value)));
}


/// Make_64 - This functions makes a 64-bit integer from a high / low pair of
///           32-bit integers.
//<editor-fold defaultstate="collapsed" desc="llvm::Make_64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 259,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 257,
 FQN="llvm::Make_64", NM="_ZN4llvm7Make_64Ejj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm7Make_64Ejj")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ Make_64(/*uint32_t*/int High, /*uint32_t*/int Low) {
  return ((long/*uint64_t*/)$uint2ulong(High) << 32) | (long/*uint64_t*/)$uint2ulong(Low);
}


/// isInt - Checks if an integer fits into the given bit width.
/*template <unsigned int N> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::isInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 265,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 262,
 FQN="llvm::isInt", NM="Tpl__ZN4llvm5isIntEx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=Tpl__ZN4llvm5isIntEx")
//</editor-fold>
public static /*inline*/ boolean isInt(int N, long/*int64_t*/ x) {
  return $greatereq_uint(N, 64) || (-(1L/*LL*/ << (N - 1)) <= x && x < (1L/*LL*/ << (N - 1)));
}

// Template specializations to get better code for common cases.
//<editor-fold defaultstate="collapsed" desc="llvm::isInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 269,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 267,
 FQN="llvm::isInt", NM="_ZN4llvm5isIntILj8EEEbx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm5isIntILj8EEEbx")
//</editor-fold>
public static /*inline*/ boolean isInt(long/*int64_t*/ x) {
  return ((/*static_cast*/byte/*int8_t*/)(x)) == x;
}


/// isShiftedInt<N,S> - Checks if a signed integer is an N bit number shifted
///                     left by S.
/*template <unsigned int N, unsigned int S> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::isShiftedInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 285,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 282,
 FQN="llvm::isShiftedInt", NM="Tpl__ZN4llvm12isShiftedIntEx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=Tpl__ZN4llvm12isShiftedIntEx")
//</editor-fold>
public static /*inline*/ boolean isShiftedInt(/*uint*/int N, /*uint*/int S, long/*int64_t*/ x) {
  static_assert($greater_uint(N, 0), $("isShiftedInt<0> doesn't make sense (refers to a 0-bit number."));
  static_assert($lesseq_uint(N + S, 64), $("isShiftedInt<N, S> with N + S > 64 is too wide."));
  return Native.$bool(isInt(N + S, x)) && ($rem_ullong(x, (1L/*ULL*/ << S)) == $int2ullong(0));
}


/// isUInt - Checks if an unsigned integer fits into the given bit width.
/*template <unsigned int N> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::isUInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 294,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 288,
 FQN="llvm::isUInt", NM="Tpl__ZN4llvm6isUIntEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=Tpl__ZN4llvm6isUIntEy")
//</editor-fold>
public static /*inline*/ boolean isUInt(/*uint*/int N, long/*uint64_t*/ x) {
  static_assert($greater_uint(N, 0), $("isUInt<0> doesn't make sense."));
  return $greatereq_uint(N, 64) || $less_ulong_ullong(x, (1L/*ULL*/ << (N)));
}


// Template specializations to get better code for common cases.
//<editor-fold defaultstate="collapsed" desc="llvm::isUInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 300,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 293,
 FQN="llvm::isUInt", NM="_ZN4llvm6isUIntILj8EEEby",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm6isUIntILj8EEEby")
//</editor-fold>
public static /*inline*/ boolean isUInt(long/*uint64_t*/ x) {
  throw new UnsupportedOperationException("Use fast specializations llvm.isUint8/16/24/32 or general llvm.isUIntN(N, x)");
}
// Template specializations to get better code for common cases.
//<editor-fold defaultstate="collapsed" desc="llvm::isUInt">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 300,
 FQN = "llvm::isUInt", NM = "_ZN4llvm6isUIntILj8EEEby",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm6isUIntILj8EEEby")
//</editor-fold>
public static /*inline*/ boolean isUInt8(long/*uint64_t*/ x) {
  return (x & 0xFFFFFFFFFFFFFF00L) == 0L;
}
public static /*inline*/ boolean isUInt16(long/*uint64_t*/ x) {
  return (x & 0xFFFFFFFFFFFF0000L) == 0L;
}
public static /*inline*/ boolean isUInt24(long/*uint64_t*/ x) {
  return (x & 0xFFFFFFFFFF000000L) == 0L;
}
public static /*inline*/ boolean isUInt32(long/*uint64_t*/ x) {
  return (x & 0xFFFFFFFF00000000L) == 0L;
}

/// Checks if a unsigned integer is an N bit number shifted left by S.
/*template <unsigned int N, unsigned int S> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::isShiftedUInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 315,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 308,
 FQN="llvm::isShiftedUInt", NM="Tpl__ZN4llvm13isShiftedUIntEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=Tpl__ZN4llvm13isShiftedUIntEy")
//</editor-fold>
public static /*inline*/ boolean isShiftedUInt(/*uint*/int N, /*uint*/int S, long/*uint64_t*/ x) {
  static_assert($greater_uint(N, 0), $("isShiftedUInt<0> doesn't make sense (refers to a 0-bit number)"));
  static_assert($lesseq_uint(N + S, 64), $("isShiftedUInt<N, S> with N + S > 64 is too wide."));
  // Per the two static_asserts above, S must be strictly less than 64.  So
  // 1 << S is not undefined behavior.
  return Native.$bool(isUInt(N + S, x)) && ($rem_ulong_ullong(x, (1L/*ULL*/ << S)) == $int2ullong(0));
}


/// Gets the maximum value for a N-bit unsigned integer.
//<editor-fold defaultstate="collapsed" desc="llvm::maxUIntN">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 326,
 FQN="llvm::maxUIntN", NM="_ZN4llvm8maxUIntNEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm8maxUIntNEy")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ maxUIntN(long/*uint64_t*/ N) {
  assert ($greater_ulong_ullong(N, $int2ullong(0)) && $lesseq_ulong_ullong(N, $int2ullong(64))) : "integer width out of range";
  
  // uint64_t(1) << 64 is undefined behavior, so we can't do
  //   (uint64_t(1) << N) - 1
  // without checking first that N != 64.  But this works and doesn't have a
  // branch.
  return UINT64_MAX >>> ($int2ullong(64) - N);
}


/// Gets the minimum value for a N-bit signed integer.
//<editor-fold defaultstate="collapsed" desc="llvm::minIntN">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 337,
 FQN="llvm::minIntN", NM="_ZN4llvm7minIntNEx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm7minIntNEx")
//</editor-fold>
public static /*inline*/ long/*int64_t*/ minIntN(long/*int64_t*/ N) {
  assert (N > 0 && N <= 64) : "integer width out of range";
  
  return -(1L/*ULL*/ << (N - 1));
}


/// Gets the maximum value for a N-bit signed integer.
//<editor-fold defaultstate="collapsed" desc="llvm::maxIntN">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 344,
 FQN="llvm::maxIntN", NM="_ZN4llvm7maxIntNEx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm7maxIntNEx")
//</editor-fold>
public static /*inline*/ long/*int64_t*/ maxIntN(long/*int64_t*/ N) {
  assert (N > 0 && N <= 64) : "integer width out of range";
  
  // This relies on two's complement wraparound when N == 64, so we convert to
  // int64_t only at the very end to avoid UB.
  return (1L/*ULL*/ << (N - 1)) - $int2ullong(1);
}


/// isUIntN - Checks if an unsigned integer fits into the given (dynamic)
/// bit width.
//<editor-fold defaultstate="collapsed" desc="llvm::isUIntN">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 354,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 315,
 FQN="llvm::isUIntN", NM="_ZN4llvm7isUIntNEjy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm7isUIntNEjy")
//</editor-fold>
public static /*inline*/ boolean isUIntN(/*uint*/int N, long/*uint64_t*/ x) {
  return $greatereq_uint(N, 64) || $lesseq_ulong(x, maxUIntN($uint2ulong(N)));
}


/// isIntN - Checks if an signed integer fits into the given (dynamic)
/// bit width.
//<editor-fold defaultstate="collapsed" desc="llvm::isIntN">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 360,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 321,
 FQN="llvm::isIntN", NM="_ZN4llvm6isIntNEjx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm6isIntNEjx")
//</editor-fold>
public static /*inline*/ boolean isIntN(/*uint*/int N, long/*int64_t*/ x) {
  return $greatereq_uint(N, 64) || (minIntN($uint2long(N)) <= x && x <= maxIntN($uint2long(N)));
}


/// isMask_32 - This function returns true if the argument is a non-empty
/// sequence of ones starting at the least significant bit with the remainder
/// zero (32 bit version).  Ex. isMask_32(0x0000FFFFU) == true.
//<editor-fold defaultstate="collapsed" desc="llvm::isMask_32">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 367,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 328,
 FQN="llvm::isMask_32", NM="_ZN4llvm9isMask_32Ej",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm9isMask_32Ej")
//</editor-fold>
public static /*inline*/ boolean isMask_32(/*uint32_t*/int Value) {
  return (Value != 0) && ((Value + 1) & Value) == 0;
}


/// isMask_64 - This function returns true if the argument is a non-empty
/// sequence of ones starting at the least significant bit with the remainder
/// zero (64 bit version).
//<editor-fold defaultstate="collapsed" desc="llvm::isMask_64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 374,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 335,
 FQN="llvm::isMask_64", NM="_ZN4llvm9isMask_64Ey",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm9isMask_64Ey")
//</editor-fold>
public static /*inline*/ boolean isMask_64(long/*uint64_t*/ Value) {
  return (Value != 0) && ((Value + $int2ullong(1)) & Value) == $int2ullong(0);
}


/// isShiftedMask_32 - This function returns true if the argument contains a
/// non-empty sequence of ones with the remainder zero (32 bit version.)
/// Ex. isShiftedMask_32(0x0000FF00U) == true.
//<editor-fold defaultstate="collapsed" desc="llvm::isShiftedMask_32">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 381,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 342,
 FQN="llvm::isShiftedMask_32", NM="_ZN4llvm16isShiftedMask_32Ej",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm16isShiftedMask_32Ej")
//</editor-fold>
public static /*inline*/ boolean isShiftedMask_32(/*uint32_t*/int Value) {
  return (Value != 0) && isMask_32((Value - 1) | Value);
}


/// isShiftedMask_64 - This function returns true if the argument contains a
/// non-empty sequence of ones with the remainder zero (64 bit version.)
//<editor-fold defaultstate="collapsed" desc="llvm::isShiftedMask_64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 387,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 348,
 FQN="llvm::isShiftedMask_64", NM="_ZN4llvm16isShiftedMask_64Ey",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm16isShiftedMask_64Ey")
//</editor-fold>
public static /*inline*/ boolean isShiftedMask_64(long/*uint64_t*/ Value) {
  return (Value != 0) && isMask_64((Value - $int2ullong(1)) | Value);
}


/// isPowerOf2_32 - This function returns true if the argument is a power of
/// two > 0. Ex. isPowerOf2_32(0x00100000U) == true (32 bit edition.)
//<editor-fold defaultstate="collapsed" desc="llvm::isPowerOf2_32">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 393,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 354,
 FQN="llvm::isPowerOf2_32", NM="_ZN4llvm13isPowerOf2_32Ej",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm13isPowerOf2_32Ej")
//</editor-fold>
public static /*inline*/ boolean isPowerOf2_32(/*uint32_t*/int Value) {
  return (Value != 0) && !((Value & (Value - 1)) != 0);
}


/// isPowerOf2_64 - This function returns true if the argument is a power of two
/// > 0 (64 bit edition.)
//<editor-fold defaultstate="collapsed" desc="llvm::isPowerOf2_64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 399,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 360,
 FQN="llvm::isPowerOf2_64", NM="_ZN4llvm13isPowerOf2_64Ey",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm13isPowerOf2_64Ey")
//</editor-fold>
public static /*inline*/ boolean isPowerOf2_64(long/*uint64_t*/ Value) {
  return (Value != 0) && !((Value & (Value - ((long/*int64_t*/)(1L/*L*/)))) != 0);
}


/// ByteSwap_16 - This function returns a byte-swapped representation of the
/// 16-bit argument, Value.
//<editor-fold defaultstate="collapsed" desc="llvm::ByteSwap_16">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 405,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 366,
 FQN="llvm::ByteSwap_16", NM="_ZN4llvm11ByteSwap_16Et",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm11ByteSwap_16Et")
//</editor-fold>
public static /*inline*/ /*uint16_t*/char ByteSwap_16(/*uint16_t*/char Value) {
  return sys.SwapByteOrder_16(Value);
}


/// ByteSwap_32 - This function returns a byte-swapped representation of the
/// 32-bit argument, Value.
//<editor-fold defaultstate="collapsed" desc="llvm::ByteSwap_32">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 411,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 372,
 FQN="llvm::ByteSwap_32", NM="_ZN4llvm11ByteSwap_32Ej",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm11ByteSwap_32Ej")
//</editor-fold>
public static /*inline*/ /*uint32_t*/int ByteSwap_32(/*uint32_t*/int Value) {
  return sys.SwapByteOrder_32(Value);
}


/// ByteSwap_64 - This function returns a byte-swapped representation of the
/// 64-bit argument, Value.
//<editor-fold defaultstate="collapsed" desc="llvm::ByteSwap_64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 417,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 378,
 FQN="llvm::ByteSwap_64", NM="_ZN4llvm11ByteSwap_64Ey",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm11ByteSwap_64Ey")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ ByteSwap_64(long/*uint64_t*/ Value) {
  return sys.SwapByteOrder_64(Value);
}


/// \brief Count the number of ones from the most significant bit to the first
/// zero bit.
///
/// Ex. CountLeadingOnes(0xFF0FFF00) == 8.
/// Only unsigned integral types are allowed.
///
/// \param ZB the behavior on an input of all ones. Only ZB_Width and
/// ZB_Undefined are valid arguments.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::countLeadingOnes">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 430,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 390,
 FQN="llvm::countLeadingOnes", NM="Tpl__ZN4llvm16countLeadingOnesET_NS_12ZeroBehaviorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=Tpl__ZN4llvm16countLeadingOnesET_NS_12ZeroBehaviorE")
//</editor-fold>
public static </*typename*/ T> /*uint*/int countLeadingOnes(T Value) {
  return countLeadingOnes(Value, ZeroBehavior.ZB_Width);
}
public static </*typename*/ T> /*uint*/int countLeadingOnes(T Value, ZeroBehavior ZB/*= ZB_Width*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Count the number of ones from the least significant bit to the first
/// zero bit.
///
/// Ex. countTrailingOnes(0x00FF00FF) == 8.
/// Only unsigned integral types are allowed.
///
/// \param ZB the behavior on an input of all ones. Only ZB_Width and
/// ZB_Undefined are valid arguments.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::countTrailingOnes">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 446,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 406,
 FQN="llvm::countTrailingOnes", NM="Tpl__ZN4llvm17countTrailingOnesET_NS_12ZeroBehaviorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=Tpl__ZN4llvm17countTrailingOnesET_NS_12ZeroBehaviorE")
//</editor-fold>
public static </*typename*/ T> /*uint*/int countTrailingOnes(T Value) {
  return countTrailingOnes(Value, ZeroBehavior.ZB_Width);
}
public static </*typename*/ T> /*uint*/int countTrailingOnes(T Value, ZeroBehavior ZB/*= ZB_Width*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

// namespace detail

/// \brief Count the number of set bits in a value.
/// Ex. countPopulation(0xF000F000) = 8
/// Returns 0 if the word is zero.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::countPopulation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 488,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 448,
 FQN="llvm::countPopulation", NM="Tpl__ZN4llvm15countPopulationET_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=Tpl__ZN4llvm15countPopulationET_")
//</editor-fold>
public static /*inline*/ </*typename*/ T> /*uint*/int countPopulation(T Value) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Log2 - This function returns the log base 2 of the specified value
//<editor-fold defaultstate="collapsed" desc="llvm::Log2">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 496,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 457,
 FQN="llvm::Log2", NM="_ZN4llvm4Log2Ed",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm4Log2Ed")
//</editor-fold>
public static /*inline*/ double Log2(double Value) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Log2_32 - This function returns the floor log base 2 of the specified value,
/// -1 if the value is zero. (32 bit edition.)
/// Ex. Log2_32(32) == 5, Log2_32(1) == 0, Log2_32(0) == -1, Log2_32(6) == 2
//<editor-fold defaultstate="collapsed" desc="llvm::Log2_32">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 507,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 468,
 FQN="llvm::Log2_32", NM="_ZN4llvm7Log2_32Ej",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm7Log2_32Ej")
//</editor-fold>
public static /*inline*/ /*uint*/int Log2_32(/*uint32_t*/int Value) {
  return 31 - countLeadingZeros(Value);
}


/// Log2_64 - This function returns the floor log base 2 of the specified value,
/// -1 if the value is zero. (64 bit edition.)
//<editor-fold defaultstate="collapsed" desc="llvm::Log2_64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 513,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 474,
 FQN="llvm::Log2_64", NM="_ZN4llvm7Log2_64Ey",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm7Log2_64Ey")
//</editor-fold>
public static /*inline*/ /*uint*/int Log2_64(long/*uint64_t*/ Value) {
  return 63 - countLeadingZeros(Value);
}


/// Log2_32_Ceil - This function returns the ceil log base 2 of the specified
/// value, 32 if the value is zero. (32 bit edition).
/// Ex. Log2_32_Ceil(32) == 5, Log2_32_Ceil(1) == 0, Log2_32_Ceil(6) == 3
//<editor-fold defaultstate="collapsed" desc="llvm::Log2_32_Ceil">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 520,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 481,
 FQN="llvm::Log2_32_Ceil", NM="_ZN4llvm12Log2_32_CeilEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm12Log2_32_CeilEj")
//</editor-fold>
public static /*inline*/ /*uint*/int Log2_32_Ceil(/*uint32_t*/int Value) {
  return 32 - countLeadingZeros(Value - 1);
}


/// Log2_64_Ceil - This function returns the ceil log base 2 of the specified
/// value, 64 if the value is zero. (64 bit edition.)
//<editor-fold defaultstate="collapsed" desc="llvm::Log2_64_Ceil">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 526,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 487,
 FQN="llvm::Log2_64_Ceil", NM="_ZN4llvm12Log2_64_CeilEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm12Log2_64_CeilEy")
//</editor-fold>
public static /*inline*/ /*uint*/int Log2_64_Ceil(long/*uint64_t*/ Value) {
  return 64 - countLeadingZeros(Value - $int2ullong(1));
}


/// GreatestCommonDivisor64 - Return the greatest common divisor of the two
/// values using Euclid's algorithm.
//<editor-fold defaultstate="collapsed" desc="llvm::GreatestCommonDivisor64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 532,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 493,
 FQN="llvm::GreatestCommonDivisor64", NM="_ZN4llvm23GreatestCommonDivisor64Eyy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm23GreatestCommonDivisor64Eyy")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ GreatestCommonDivisor64(long/*uint64_t*/ A, long/*uint64_t*/ B) {
  while ((B != 0)) {
    long/*uint64_t*/ T = B;
    B = $rem_ulong(A, B);
    A = T;
  }
  return A;
}


/// BitsToDouble - This function takes a 64-bit integer and returns the bit
/// equivalent double.
//<editor-fold defaultstate="collapsed" desc="llvm::BitsToDouble">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 543,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 504,
 FQN="llvm::BitsToDouble", NM="_ZN4llvm12BitsToDoubleEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm12BitsToDoubleEy")
//</editor-fold>
public static /*inline*/ double BitsToDouble(long/*uint64_t*/ Bits) {
  //<editor-fold defaultstate="collapsed" desc="">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 544,
   FQN="", NM="_ZN4llvm12BitsToDoubleEy_Unnamed_union",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm12BitsToDoubleEy_Unnamed_union")
  //</editor-fold>
   class/*union*/ Unnamed_union {
    public long/*uint64_t*/ L;
    public double D;
    //<editor-fold defaultstate="collapsed" desc="llvm::BitsToDouble(uint64_t)::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 544,
     FQN="llvm::BitsToDouble(uint64_t)::(anonymous union)::", NM="_ZZN4llvm12BitsToDoubleEyENUt_C1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZZN4llvm12BitsToDoubleEyENUt_C1Ev")
    //</editor-fold>
    public /*inline*/ Unnamed_union() {
    }

    
    @Override public String toString() {
      return "" + "L=" + L // NOI18N
                + ", D=" + D; // NOI18N
    }
  }Unnamed_union T/*J*/= new Unnamed_union();
  T.L = Bits;
  return T.D;
}


/// BitsToFloat - This function takes a 32-bit integer and returns the bit
/// equivalent float.
//<editor-fold defaultstate="collapsed" desc="llvm::BitsToFloat">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 554,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 515,
 FQN="llvm::BitsToFloat", NM="_ZN4llvm11BitsToFloatEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm11BitsToFloatEj")
//</editor-fold>
public static /*inline*/ float BitsToFloat(/*uint32_t*/int Bits) {
  //<editor-fold defaultstate="collapsed" desc="">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 555,
   FQN="", NM="_ZN4llvm11BitsToFloatEj_Unnamed_union",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm11BitsToFloatEj_Unnamed_union")
  //</editor-fold>
   class/*union*/ Unnamed_union {
    public /*uint32_t*/int I;
    public float F;
    //<editor-fold defaultstate="collapsed" desc="llvm::BitsToFloat(uint32_t)::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 555,
     FQN="llvm::BitsToFloat(uint32_t)::(anonymous union)::", NM="_ZZN4llvm11BitsToFloatEjENUt_C1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZZN4llvm11BitsToFloatEjENUt_C1Ev")
    //</editor-fold>
    public /*inline*/ Unnamed_union() {
    }

    
    @Override public String toString() {
      return "" + "I=" + I // NOI18N
                + ", F=" + F; // NOI18N
    }
  }Unnamed_union T/*J*/= new Unnamed_union();
  T.I = Bits;
  return T.F;
}


/// DoubleToBits - This function takes a double and returns the bit
/// equivalent 64-bit integer.  Note that copying doubles around
/// changes the bits of NaNs on some hosts, notably x86, so this
/// routine cannot be used if these bits are needed.
//<editor-fold defaultstate="collapsed" desc="llvm::DoubleToBits">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 567,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 528,
 FQN="llvm::DoubleToBits", NM="_ZN4llvm12DoubleToBitsEd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm12DoubleToBitsEd")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ DoubleToBits(double Double) {
  //<editor-fold defaultstate="collapsed" desc="">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 568,
   FQN="", NM="_ZN4llvm12DoubleToBitsEd_Unnamed_union",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm12DoubleToBitsEd_Unnamed_union")
  //</editor-fold>
   class/*union*/ Unnamed_union {
    public long/*uint64_t*/ L;
    public double D;
    //<editor-fold defaultstate="collapsed" desc="llvm::DoubleToBits(double)::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 568,
     FQN="llvm::DoubleToBits(double)::(anonymous union)::", NM="_ZZN4llvm12DoubleToBitsEdENUt_C1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZZN4llvm12DoubleToBitsEdENUt_C1Ev")
    //</editor-fold>
    public /*inline*/ Unnamed_union() {
    }

    
    @Override public String toString() {
      return "" + "L=" + L // NOI18N
                + ", D=" + D; // NOI18N
    }
  }Unnamed_union T/*J*/= new Unnamed_union();
  T.D = Double;
  return T.L;
}


/// FloatToBits - This function takes a float and returns the bit
/// equivalent 32-bit integer.  Note that copying floats around
/// changes the bits of NaNs on some hosts, notably x86, so this
/// routine cannot be used if these bits are needed.
//<editor-fold defaultstate="collapsed" desc="llvm::FloatToBits">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 580,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 541,
 FQN="llvm::FloatToBits", NM="_ZN4llvm11FloatToBitsEf",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm11FloatToBitsEf")
//</editor-fold>
public static /*inline*/ /*uint32_t*/int FloatToBits(float Float) {
  //<editor-fold defaultstate="collapsed" desc="">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 581,
   FQN="", NM="_ZN4llvm11FloatToBitsEf_Unnamed_union",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm11FloatToBitsEf_Unnamed_union")
  //</editor-fold>
   class/*union*/ Unnamed_union {
    public /*uint32_t*/int I;
    public float F;
    //<editor-fold defaultstate="collapsed" desc="llvm::FloatToBits(float)::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 581,
     FQN="llvm::FloatToBits(float)::(anonymous union)::", NM="_ZZN4llvm11FloatToBitsEfENUt_C1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZZN4llvm11FloatToBitsEfENUt_C1Ev")
    //</editor-fold>
    public /*inline*/ Unnamed_union() {
    }

    
    @Override public String toString() {
      return "" + "I=" + I // NOI18N
                + ", F=" + F; // NOI18N
    }
  }Unnamed_union T/*J*/= new Unnamed_union();
  T.F = Float;
  return T.I;
}


/// MinAlign - A and B are either alignments or offsets.  Return the minimum
/// alignment that may be assumed after adding the two together.
//<editor-fold defaultstate="collapsed" desc="llvm::MinAlign">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 591,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 552,
 FQN="llvm::MinAlign", NM="_ZN4llvm8MinAlignEyy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm8MinAlignEyy")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ MinAlign(long/*uint64_t*/ A, long/*uint64_t*/ B) {
  // The largest power of 2 that divides both A and B.
  //
  // Replace "-Value" by "1+~Value" in the following commented code to avoid
  // MSVC warning C4146
  //    return (A | B) & -(A | B);
  return (A | B) & ($int2ullong(1) + ~(A | B));
}


/// \brief Aligns \c Addr to \c Alignment bytes, rounding up.
///
/// Alignment should be a power of two.  This method rounds up, so
/// alignAddr(7, 4) == 8 and alignAddr(8, 4) == 8.
//<editor-fold defaultstate="collapsed" desc="llvm::alignAddr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 604,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 565,
 FQN="llvm::alignAddr", NM="_ZN4llvm9alignAddrEPKvj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm9alignAddrEPKvj")
//</editor-fold>
public static /*inline*/ Object/*uintptr_t*/ alignAddr(/*const*/Object/*void P*/ Addr, /*size_t*/int Alignment) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Returns the necessary adjustment for aligning \c Ptr to \c Alignment
/// bytes, rounding up.
//<editor-fold defaultstate="collapsed" desc="llvm::alignmentAdjustment">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 615,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 576,
 FQN="llvm::alignmentAdjustment", NM="_ZN4llvm19alignmentAdjustmentEPKvj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm19alignmentAdjustmentEPKvj")
//</editor-fold>
public static /*inline*/ /*size_t*/int alignmentAdjustment(/*const*/Object/*void P*/ Ptr, /*size_t*/int Alignment) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// NextPowerOf2 - Returns the next power of two (in 64-bits)
/// that is strictly greater than A.  Returns zero on overflow.
//<editor-fold defaultstate="collapsed" desc="llvm::NextPowerOf2">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 621,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 582,
 FQN="llvm::NextPowerOf2", NM="_ZN4llvm12NextPowerOf2Ey",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm12NextPowerOf2Ey")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ NextPowerOf2(long/*uint64_t*/ A) {
  A |= (A >>> 1);
  A |= (A >>> 2);
  A |= (A >>> 4);
  A |= (A >>> 8);
  A |= (A >>> 16);
  A |= (A >>> 32);
  return A + $int2ullong(1);
}


/// Returns the power of two which is less than or equal to the given value.
/// Essentially, it is a floor operation across the domain of powers of two.
//<editor-fold defaultstate="collapsed" desc="llvm::PowerOf2Floor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 633,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 594,
 FQN="llvm::PowerOf2Floor", NM="_ZN4llvm13PowerOf2FloorEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm13PowerOf2FloorEy")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ PowerOf2Floor(long/*uint64_t*/ A) {
  if (!(A != 0)) {
    return $int2ulong(0);
  }
  return 1L/*ULL*/ << (63 - countLeadingZeros(A, ZeroBehavior.ZB_Undefined));
}


/// Returns the next integer (mod 2**64) that is greater than or equal to
/// \p Value and is a multiple of \p Align. \p Align must be non-zero.
///
/// If non-zero \p Skew is specified, the return value will be a minimal
/// integer that is greater than or equal to \p Value and equal to
/// \p Align * N + \p Skew for some integer N. If \p Skew is larger than
/// \p Align, its value is adjusted to '\p Skew mod \p Align'.
///
/// Examples:
/// \code
///   alignTo(5, 8) = 8
///   alignTo(17, 8) = 24
///   alignTo(~0LL, 8) = 0
///   alignTo(321, 255) = 510
///
///   alignTo(5, 8, 7) = 7
///   alignTo(17, 8, 1) = 17
///   alignTo(~0LL, 8, 3) = 3
///   alignTo(321, 255, 42) = 552
/// \endcode
//<editor-fold defaultstate="collapsed" desc="llvm::alignTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 658,
 FQN="llvm::alignTo", NM="_ZN4llvm7alignToEyyy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm7alignToEyyy")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ alignTo(long/*uint64_t*/ Value, long/*uint64_t*/ Align) {
  return alignTo(Value, Align, $int2ulong(0));
}
public static /*inline*/ long/*uint64_t*/ alignTo(long/*uint64_t*/ Value, long/*uint64_t*/ Align, long/*uint64_t*/ Skew/*= 0*/) {
  Skew = $rem_ulong(Skew, Align);
  return $div_ullong_ulong((Value + Align - $int2ullong(1) - Skew), Align) * Align + Skew;
}


/// Returns the largest uint64_t less than or equal to \p Value and is
/// \p Skew mod \p Align. \p Align must be non-zero
//<editor-fold defaultstate="collapsed" desc="llvm::alignDown">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 665,
 FQN="llvm::alignDown", NM="_ZN4llvm9alignDownEyyy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm9alignDownEyyy")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ alignDown(long/*uint64_t*/ Value, long/*uint64_t*/ Align) {
  return alignDown(Value, Align, $int2ulong(0));
}
public static /*inline*/ long/*uint64_t*/ alignDown(long/*uint64_t*/ Value, long/*uint64_t*/ Align, long/*uint64_t*/ Skew/*= 0*/) {
  Skew = $rem_ulong(Skew, Align);
  return $div_ullong_ulong((Value - Skew), Align) * Align + Skew;
}


/// Returns the offset to the next integer (mod 2**64) that is greater than
/// or equal to \p Value and is a multiple of \p Align. \p Align must be
/// non-zero.
//<editor-fold defaultstate="collapsed" desc="llvm::OffsetToAlignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 673,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 628,
 FQN="llvm::OffsetToAlignment", NM="_ZN4llvm17OffsetToAlignmentEyy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm17OffsetToAlignmentEyy")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ OffsetToAlignment(long/*uint64_t*/ Value, long/*uint64_t*/ Align) {
  return alignTo(Value, Align) - Value;
}


/// Sign-extend the number in the bottom B bits of X to a 32-bit integer.
/// Requires 0 < B <= 32.
/*template <unsigned int B> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::SignExtend32">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 679,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 634,
 FQN="llvm::SignExtend32", NM="Tpl__ZN4llvm12SignExtend32Ej",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=Tpl__ZN4llvm12SignExtend32Ej")
//</editor-fold>
public static /*inline*/ int/*int32_t*/ SignExtend32$T(/*uint*/int B, /*uint32_t*/int X) {
  static_assert($greater_uint(B, 0), $("Bit width can't be 0."));
  static_assert($lesseq_uint(B, 32), $("Bit width out of range."));
  return ((int/*int32_t*/)(X << (32 - B))) >> (32 - B);
}


/// Sign-extend the number in the bottom B bits of X to a 32-bit integer.
/// Requires 0 < B < 32.
//<editor-fold defaultstate="collapsed" desc="llvm::SignExtend32">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 687,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 640,
 FQN="llvm::SignExtend32", NM="_ZN4llvm12SignExtend32Ejj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm12SignExtend32Ejj")
//</editor-fold>
public static /*inline*/ int/*int32_t*/ SignExtend32(/*uint32_t*/int X, /*uint*/int B) {
  assert ($greater_uint(B, 0)) : "Bit width can't be 0.";
  assert ($lesseq_uint(B, 32)) : "Bit width out of range.";
  return ((int/*int32_t*/)(X << (32 - B))) >> (32 - B);
}


/// Sign-extend the number in the bottom B bits of X to a 64-bit integer.
/// Requires 0 < B < 64.
/*template <unsigned int B> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::SignExtend64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 695,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 646,
 FQN="llvm::SignExtend64", NM="Tpl__ZN4llvm12SignExtend64Ey",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=Tpl__ZN4llvm12SignExtend64Ey")
//</editor-fold>
public static /*inline*/ long/*int64_t*/ SignExtend64$T(/*uint*/int B, long/*uint64_t*/ x) {
  static_assert($greater_uint(B, 0), $("Bit width can't be 0."));
  static_assert($lesseq_uint(B, 64), $("Bit width out of range."));
  return ((long/*int64_t*/)(x << (64 - B))) >> (64 - B);
}


/// Sign-extend the number in the bottom B bits of X to a 64-bit integer.
/// Requires 0 < B < 64.
//<editor-fold defaultstate="collapsed" desc="llvm::SignExtend64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 703,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 652,
 FQN="llvm::SignExtend64", NM="_ZN4llvm12SignExtend64Eyj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm12SignExtend64Eyj")
//</editor-fold>
public static /*inline*/ long/*int64_t*/ SignExtend64(long/*uint64_t*/ X, /*uint*/int B) {
  assert ($greater_uint(B, 0)) : "Bit width can't be 0.";
  assert ($lesseq_uint(B, 64)) : "Bit width out of range.";
  return ((long/*int64_t*/)(X << (64 - B))) >> (64 - B);
}


/// Subtract two unsigned integers, X and Y, of type T and return the absolute
/// value of the result.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::AbsoluteDifference">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 712,
 FQN="llvm::AbsoluteDifference", NM="Tpl__ZN4llvm18AbsoluteDifferenceET_S0_R_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=Tpl__ZN4llvm18AbsoluteDifferenceET_S0_R_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE")
//</editor-fold>
public static </*typename*/ T> /*std::enable_if<std::is_unsigned<T>::value, T>::type*/T AbsoluteDifference$Unsigned(T X, T Y) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Add two unsigned integers, X and Y, of type T.  Clamp the result to the
/// maximum representable value of T on overflow.  ResultOverflowed indicates if
/// the result is larger than the maximum representable value of type T.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::SaturatingAdd">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 721,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 660,
 FQN="llvm::SaturatingAdd", NM="Tpl__ZN4llvm13SaturatingAddET_S0_PbR_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=Tpl__ZN4llvm13SaturatingAddET_S0_PbR_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE")
//</editor-fold>
public static </*typename*/ T> /*std::enable_if<std::is_unsigned<T>::value, T>::type*/T SaturatingAdd$Unsigned(T X, T Y) {
  return SaturatingAdd$Unsigned(X, Y, (bool$ptr/*bool P*/ )null);
}
public static </*typename*/ T> /*std::enable_if<std::is_unsigned<T>::value, T>::type*/T SaturatingAdd$Unsigned(T X, T Y, bool$ptr/*bool P*/ ResultOverflowed/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Multiply two unsigned integers, X and Y, of type T.  Clamp the result to the
/// maximum representable value of T on overflow.  ResultOverflowed indicates if
/// the result is larger than the maximum representable value of type T.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::SaturatingMultiply">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 738,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 678,
 FQN="llvm::SaturatingMultiply", NM="Tpl__ZN4llvm18SaturatingMultiplyET_S0_PbR_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=Tpl__ZN4llvm18SaturatingMultiplyET_S0_PbR_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE")
//</editor-fold>
public static </*typename*/ T> /*std::enable_if<std::is_unsigned<T>::value, T>::type*/T SaturatingMultiply$Unsigned(T X, T Y) {
  return SaturatingMultiply$Unsigned(X, Y, (bool$ptr/*bool P*/ )null);
}
public static </*typename*/ T> /*std::enable_if<std::is_unsigned<T>::value, T>::type*/T SaturatingMultiply$Unsigned(T X, T Y, bool$ptr/*bool P*/ ResultOverflowed/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Multiply two unsigned integers, X and Y, and add the unsigned integer, A to
/// the product. Clamp the result to the maximum representable value of T on
/// overflow. ResultOverflowed indicates if the result is larger than the
/// maximum representable value of type T.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::SaturatingMultiplyAdd">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 784,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 726,
 FQN="llvm::SaturatingMultiplyAdd", NM="Tpl__ZN4llvm21SaturatingMultiplyAddET_S0_S0_PbR_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=Tpl__ZN4llvm21SaturatingMultiplyAddET_S0_S0_PbR_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE")
//</editor-fold>
public static </*typename*/ T> /*std::enable_if<std::is_unsigned<T>::value, T>::type*/T SaturatingMultiplyAdd$Unsigned(T X, T Y, T A) {
  return SaturatingMultiplyAdd$Unsigned(X, Y, A, (bool$ptr/*bool P*/ )null);
}
public static </*typename*/ T> /*std::enable_if<std::is_unsigned<T>::value, T>::type*/T SaturatingMultiplyAdd$Unsigned(T X, T Y, T A, bool$ptr/*bool P*/ ResultOverflowed/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class MathExtrasLlvmGlobals
