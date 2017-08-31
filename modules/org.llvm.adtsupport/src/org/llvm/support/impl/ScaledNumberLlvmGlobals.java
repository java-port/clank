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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import org.llvm.cl.*;
import static org.llvm.support.impl.CommandLineStatics.*;
import org.clank.java.stdimpl.aliases.*;
import org.llvm.support.impl.*;
import org.llvm.support.sys.*;
import org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.adt.*;
import org.llvm.support.ScaledNumber;
import org.llvm.support.ScaledNumberULLong;
import org.llvm.support.raw_ostream;


//<editor-fold defaultstate="collapsed" desc="static type ScaledNumberLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.support.impl.ScaledNumberLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmdvERKNS_12ScaledNumberIT_EES4_;Tpl__ZN4llvmeqERKNS_12ScaledNumberIT_EEi;Tpl__ZN4llvmeqERKNS_12ScaledNumberIT_EEj;Tpl__ZN4llvmeqERKNS_12ScaledNumberIT_EEx;Tpl__ZN4llvmeqERKNS_12ScaledNumberIT_EEy;Tpl__ZN4llvmeqEiRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmeqEjRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmeqExRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmeqEyRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmgeERKNS_12ScaledNumberIT_EEi;Tpl__ZN4llvmgeERKNS_12ScaledNumberIT_EEj;Tpl__ZN4llvmgeERKNS_12ScaledNumberIT_EEx;Tpl__ZN4llvmgeERKNS_12ScaledNumberIT_EEy;Tpl__ZN4llvmgeEiRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmgeEjRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmgeExRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmgeEyRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmgtERKNS_12ScaledNumberIT_EEi;Tpl__ZN4llvmgtERKNS_12ScaledNumberIT_EEj;Tpl__ZN4llvmgtERKNS_12ScaledNumberIT_EEx;Tpl__ZN4llvmgtERKNS_12ScaledNumberIT_EEy;Tpl__ZN4llvmgtEiRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmgtEjRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmgtExRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmgtEyRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmleERKNS_12ScaledNumberIT_EEi;Tpl__ZN4llvmleERKNS_12ScaledNumberIT_EEj;Tpl__ZN4llvmleERKNS_12ScaledNumberIT_EEx;Tpl__ZN4llvmleERKNS_12ScaledNumberIT_EEy;Tpl__ZN4llvmleEiRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmleEjRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmleExRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmleEyRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmlsERKNS_12ScaledNumberIT_EEs;Tpl__ZN4llvmlsERNS_11raw_ostreamERKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmltERKNS_12ScaledNumberIT_EEi;Tpl__ZN4llvmltERKNS_12ScaledNumberIT_EEj;Tpl__ZN4llvmltERKNS_12ScaledNumberIT_EEx;Tpl__ZN4llvmltERKNS_12ScaledNumberIT_EEy;Tpl__ZN4llvmltEiRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmltEjRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmltExRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmltEyRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmmiERKNS_12ScaledNumberIT_EES4_;Tpl__ZN4llvmmlERKNS_12ScaledNumberIT_EES4_;Tpl__ZN4llvmneERKNS_12ScaledNumberIT_EEi;Tpl__ZN4llvmneERKNS_12ScaledNumberIT_EEj;Tpl__ZN4llvmneERKNS_12ScaledNumberIT_EEx;Tpl__ZN4llvmneERKNS_12ScaledNumberIT_EEy;Tpl__ZN4llvmneEiRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmneEjRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmneExRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmneEyRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmplERKNS_12ScaledNumberIT_EES4_;Tpl__ZN4llvmrsERKNS_12ScaledNumberIT_EEs; -static-type=ScaledNumberLlvmGlobals -package=org.llvm.support.impl")
//</editor-fold>
public final class ScaledNumberLlvmGlobals {

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator+">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 724,
 FQN="llvm::operator+", NM="Tpl__ZN4llvmplERKNS_12ScaledNumberIT_EES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmplERKNS_12ScaledNumberIT_EES4_")
//</editor-fold>
public static </*class*/ DigitsT> ScaledNumber<DigitsT> $add_ScaledNumber$DigitsT$C(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator-">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 725,
 FQN="llvm::operator-", NM="Tpl__ZN4llvmmiERKNS_12ScaledNumberIT_EES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmmiERKNS_12ScaledNumberIT_EES4_")
//</editor-fold>
public static </*class*/ DigitsT> ScaledNumber<DigitsT> $sub_ScaledNumber$DigitsT$C(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator*">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 726,
 FQN="llvm::operator*", NM="Tpl__ZN4llvmmlERKNS_12ScaledNumberIT_EES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmmlERKNS_12ScaledNumberIT_EES4_")
//</editor-fold>
public static </*class*/ DigitsT> ScaledNumber<DigitsT> $star_ScaledNumber$DigitsT$C(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator/">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 727,
 FQN="llvm::operator/", NM="Tpl__ZN4llvmdvERKNS_12ScaledNumberIT_EES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmdvERKNS_12ScaledNumberIT_EES4_")
//</editor-fold>
public static </*class*/ DigitsT> ScaledNumber<DigitsT> $slash_ScaledNumber$DigitsT$C(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}
public static ScaledNumberULLong $slash_ScaledNumber$DigitsT$C(final /*const*/ ScaledNumberULLong /*&*/ L, final /*const*/ ScaledNumberULLong /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 731,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", old_line = 730,
 FQN="llvm::operator<<", NM="Tpl__ZN4llvmlsERKNS_12ScaledNumberIT_EEs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmlsERKNS_12ScaledNumberIT_EEs")
//</editor-fold>
public static </*class*/ DigitsT> ScaledNumber<DigitsT> $out_ScaledNumber$DigitsT$C_short(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, 
                                 short/*int16_t*/ Shift) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator>>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 737,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", old_line = 736,
 FQN="llvm::operator>>", NM="Tpl__ZN4llvmrsERKNS_12ScaledNumberIT_EEs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmrsERKNS_12ScaledNumberIT_EEs")
//</editor-fold>
public static </*class*/ DigitsT> ScaledNumber<DigitsT> $in_ScaledNumber$DigitsT$C_short(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, 
                                short/*int16_t*/ Shift) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 743,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", old_line = 742,
 FQN="llvm::operator<<", NM="Tpl__ZN4llvmlsERNS_11raw_ostreamERKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmlsERNS_11raw_ostreamERKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> raw_ostream /*&*/ $out_raw_ostream_ScaledNumber$DigitsT$C(final raw_ostream /*&*/ OS, final /*const*/ ScaledNumber<DigitsT> /*&*/ X) {
  throw new UnsupportedOperationException("EmptyBody");
}
public static raw_ostream /*&*/ $out_raw_ostream_ScaledNumber$DigitsT$C(final raw_ostream /*&*/ OS, final /*const*/ ScaledNumberULLong /*&*/ X) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 761,
 FQN="llvm::operator<", NM="Tpl__ZN4llvmltERKNS_12ScaledNumberIT_EEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmltERKNS_12ScaledNumberIT_EEy")
//</editor-fold>
public static </*class*/ DigitsT> boolean $less_ScaledNumber$DigitsT$C_ulong(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*uint64_t*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 761,
 FQN="llvm::operator<", NM="Tpl__ZN4llvmltEyRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmltEyRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $less_ulong_ScaledNumber$DigitsT$C(long/*uint64_t*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 761,
 FQN="llvm::operator<", NM="Tpl__ZN4llvmltERKNS_12ScaledNumberIT_EEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmltERKNS_12ScaledNumberIT_EEj")
//</editor-fold>
public static </*class*/ DigitsT> boolean $less_ScaledNumber$DigitsT$C_uint(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, /*uint32_t*/int R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 761,
 FQN="llvm::operator<", NM="Tpl__ZN4llvmltEjRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmltEjRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $less_uint_ScaledNumber$DigitsT$C(/*uint32_t*/int L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 761,
 FQN="llvm::operator<", NM="Tpl__ZN4llvmltERKNS_12ScaledNumberIT_EEx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmltERKNS_12ScaledNumberIT_EEx")
//</editor-fold>
public static </*class*/ DigitsT> boolean $less_ScaledNumber$DigitsT$C_long(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*int64_t*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 761,
 FQN="llvm::operator<", NM="Tpl__ZN4llvmltExRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmltExRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $less_long_ScaledNumber$DigitsT$C(long/*int64_t*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 761,
 FQN="llvm::operator<", NM="Tpl__ZN4llvmltERKNS_12ScaledNumberIT_EEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmltERKNS_12ScaledNumberIT_EEi")
//</editor-fold>
public static </*class*/ DigitsT> boolean $less_ScaledNumber$DigitsT$C_int(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, int/*int32_t*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 761,
 FQN="llvm::operator<", NM="Tpl__ZN4llvmltEiRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmltEiRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $less_int_ScaledNumber$DigitsT$C(int/*int32_t*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 762,
 FQN="llvm::operator>", NM="Tpl__ZN4llvmgtERKNS_12ScaledNumberIT_EEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmgtERKNS_12ScaledNumberIT_EEy")
//</editor-fold>
public static </*class*/ DigitsT> boolean $greater_ScaledNumber$DigitsT$C_ulong(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*uint64_t*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 762,
 FQN="llvm::operator>", NM="Tpl__ZN4llvmgtEyRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmgtEyRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $greater_ulong_ScaledNumber$DigitsT$C(long/*uint64_t*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 762,
 FQN="llvm::operator>", NM="Tpl__ZN4llvmgtERKNS_12ScaledNumberIT_EEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmgtERKNS_12ScaledNumberIT_EEj")
//</editor-fold>
public static </*class*/ DigitsT> boolean $greater_ScaledNumber$DigitsT$C_uint(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, /*uint32_t*/int R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 762,
 FQN="llvm::operator>", NM="Tpl__ZN4llvmgtEjRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmgtEjRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $greater_uint_ScaledNumber$DigitsT$C(/*uint32_t*/int L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 762,
 FQN="llvm::operator>", NM="Tpl__ZN4llvmgtERKNS_12ScaledNumberIT_EEx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmgtERKNS_12ScaledNumberIT_EEx")
//</editor-fold>
public static </*class*/ DigitsT> boolean $greater_ScaledNumber$DigitsT$C_long(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*int64_t*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 762,
 FQN="llvm::operator>", NM="Tpl__ZN4llvmgtExRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmgtExRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $greater_long_ScaledNumber$DigitsT$C(long/*int64_t*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 762,
 FQN="llvm::operator>", NM="Tpl__ZN4llvmgtERKNS_12ScaledNumberIT_EEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmgtERKNS_12ScaledNumberIT_EEi")
//</editor-fold>
public static </*class*/ DigitsT> boolean $greater_ScaledNumber$DigitsT$C_int(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, int/*int32_t*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 762,
 FQN="llvm::operator>", NM="Tpl__ZN4llvmgtEiRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmgtEiRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $greater_int_ScaledNumber$DigitsT$C(int/*int32_t*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 763,
 FQN="llvm::operator==", NM="Tpl__ZN4llvmeqERKNS_12ScaledNumberIT_EEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmeqERKNS_12ScaledNumberIT_EEy")
//</editor-fold>
public static </*class*/ DigitsT> boolean $eq_ScaledNumber$DigitsT$C_ulong(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*uint64_t*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 763,
 FQN="llvm::operator==", NM="Tpl__ZN4llvmeqEyRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmeqEyRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $eq_ulong_ScaledNumber$DigitsT$C(long/*uint64_t*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 763,
 FQN="llvm::operator==", NM="Tpl__ZN4llvmeqERKNS_12ScaledNumberIT_EEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmeqERKNS_12ScaledNumberIT_EEj")
//</editor-fold>
public static </*class*/ DigitsT> boolean $eq_ScaledNumber$DigitsT$C_uint(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, /*uint32_t*/int R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 763,
 FQN="llvm::operator==", NM="Tpl__ZN4llvmeqEjRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmeqEjRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $eq_uint_ScaledNumber$DigitsT$C(/*uint32_t*/int L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 763,
 FQN="llvm::operator==", NM="Tpl__ZN4llvmeqERKNS_12ScaledNumberIT_EEx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmeqERKNS_12ScaledNumberIT_EEx")
//</editor-fold>
public static </*class*/ DigitsT> boolean $eq_ScaledNumber$DigitsT$C_long(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*int64_t*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 763,
 FQN="llvm::operator==", NM="Tpl__ZN4llvmeqExRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmeqExRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $eq_long_ScaledNumber$DigitsT$C(long/*int64_t*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 763,
 FQN="llvm::operator==", NM="Tpl__ZN4llvmeqERKNS_12ScaledNumberIT_EEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmeqERKNS_12ScaledNumberIT_EEi")
//</editor-fold>
public static </*class*/ DigitsT> boolean $eq_ScaledNumber$DigitsT$C_int(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, int/*int32_t*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 763,
 FQN="llvm::operator==", NM="Tpl__ZN4llvmeqEiRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmeqEiRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $eq_int_ScaledNumber$DigitsT$C(int/*int32_t*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 764,
 FQN="llvm::operator!=", NM="Tpl__ZN4llvmneERKNS_12ScaledNumberIT_EEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmneERKNS_12ScaledNumberIT_EEy")
//</editor-fold>
public static </*class*/ DigitsT> boolean $noteq_ScaledNumber$DigitsT$C_ulong(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*uint64_t*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 764,
 FQN="llvm::operator!=", NM="Tpl__ZN4llvmneEyRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmneEyRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $noteq_ulong_ScaledNumber$DigitsT$C(long/*uint64_t*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 764,
 FQN="llvm::operator!=", NM="Tpl__ZN4llvmneERKNS_12ScaledNumberIT_EEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmneERKNS_12ScaledNumberIT_EEj")
//</editor-fold>
public static </*class*/ DigitsT> boolean $noteq_ScaledNumber$DigitsT$C_uint(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, /*uint32_t*/int R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 764,
 FQN="llvm::operator!=", NM="Tpl__ZN4llvmneEjRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmneEjRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $noteq_uint_ScaledNumber$DigitsT$C(/*uint32_t*/int L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 764,
 FQN="llvm::operator!=", NM="Tpl__ZN4llvmneERKNS_12ScaledNumberIT_EEx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmneERKNS_12ScaledNumberIT_EEx")
//</editor-fold>
public static </*class*/ DigitsT> boolean $noteq_ScaledNumber$DigitsT$C_long(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*int64_t*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 764,
 FQN="llvm::operator!=", NM="Tpl__ZN4llvmneExRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmneExRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $noteq_long_ScaledNumber$DigitsT$C(long/*int64_t*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 764,
 FQN="llvm::operator!=", NM="Tpl__ZN4llvmneERKNS_12ScaledNumberIT_EEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmneERKNS_12ScaledNumberIT_EEi")
//</editor-fold>
public static </*class*/ DigitsT> boolean $noteq_ScaledNumber$DigitsT$C_int(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, int/*int32_t*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 764,
 FQN="llvm::operator!=", NM="Tpl__ZN4llvmneEiRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmneEiRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $noteq_int_ScaledNumber$DigitsT$C(int/*int32_t*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 765,
 FQN="llvm::operator<=", NM="Tpl__ZN4llvmleERKNS_12ScaledNumberIT_EEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmleERKNS_12ScaledNumberIT_EEy")
//</editor-fold>
public static </*class*/ DigitsT> boolean $lesseq_ScaledNumber$DigitsT$C_ulong(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*uint64_t*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 765,
 FQN="llvm::operator<=", NM="Tpl__ZN4llvmleEyRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmleEyRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $lesseq_ulong_ScaledNumber$DigitsT$C(long/*uint64_t*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 765,
 FQN="llvm::operator<=", NM="Tpl__ZN4llvmleERKNS_12ScaledNumberIT_EEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmleERKNS_12ScaledNumberIT_EEj")
//</editor-fold>
public static </*class*/ DigitsT> boolean $lesseq_ScaledNumber$DigitsT$C_uint(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, /*uint32_t*/int R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 765,
 FQN="llvm::operator<=", NM="Tpl__ZN4llvmleEjRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmleEjRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $lesseq_uint_ScaledNumber$DigitsT$C(/*uint32_t*/int L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 765,
 FQN="llvm::operator<=", NM="Tpl__ZN4llvmleERKNS_12ScaledNumberIT_EEx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmleERKNS_12ScaledNumberIT_EEx")
//</editor-fold>
public static </*class*/ DigitsT> boolean $lesseq_ScaledNumber$DigitsT$C_long(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*int64_t*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 765,
 FQN="llvm::operator<=", NM="Tpl__ZN4llvmleExRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmleExRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $lesseq_long_ScaledNumber$DigitsT$C(long/*int64_t*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 765,
 FQN="llvm::operator<=", NM="Tpl__ZN4llvmleERKNS_12ScaledNumberIT_EEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmleERKNS_12ScaledNumberIT_EEi")
//</editor-fold>
public static </*class*/ DigitsT> boolean $lesseq_ScaledNumber$DigitsT$C_int(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, int/*int32_t*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 765,
 FQN="llvm::operator<=", NM="Tpl__ZN4llvmleEiRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmleEiRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $lesseq_int_ScaledNumber$DigitsT$C(int/*int32_t*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator>=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 766,
 FQN="llvm::operator>=", NM="Tpl__ZN4llvmgeERKNS_12ScaledNumberIT_EEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmgeERKNS_12ScaledNumberIT_EEy")
//</editor-fold>
public static </*class*/ DigitsT> boolean $greatereq_ScaledNumber$DigitsT$C_ulong(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*uint64_t*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator>=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 766,
 FQN="llvm::operator>=", NM="Tpl__ZN4llvmgeEyRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmgeEyRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $greatereq_ulong_ScaledNumber$DigitsT$C(long/*uint64_t*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator>=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 766,
 FQN="llvm::operator>=", NM="Tpl__ZN4llvmgeERKNS_12ScaledNumberIT_EEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmgeERKNS_12ScaledNumberIT_EEj")
//</editor-fold>
public static </*class*/ DigitsT> boolean $greatereq_ScaledNumber$DigitsT$C_uint(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, /*uint32_t*/int R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator>=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 766,
 FQN="llvm::operator>=", NM="Tpl__ZN4llvmgeEjRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmgeEjRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $greatereq_uint_ScaledNumber$DigitsT$C(/*uint32_t*/int L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator>=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 766,
 FQN="llvm::operator>=", NM="Tpl__ZN4llvmgeERKNS_12ScaledNumberIT_EEx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmgeERKNS_12ScaledNumberIT_EEx")
//</editor-fold>
public static </*class*/ DigitsT> boolean $greatereq_ScaledNumber$DigitsT$C_long(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*int64_t*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator>=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 766,
 FQN="llvm::operator>=", NM="Tpl__ZN4llvmgeExRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmgeExRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $greatereq_long_ScaledNumber$DigitsT$C(long/*int64_t*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator>=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 766,
 FQN="llvm::operator>=", NM="Tpl__ZN4llvmgeERKNS_12ScaledNumberIT_EEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmgeERKNS_12ScaledNumberIT_EEi")
//</editor-fold>
public static </*class*/ DigitsT> boolean $greatereq_ScaledNumber$DigitsT$C_int(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, int/*int32_t*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator>=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 766,
 FQN="llvm::operator>=", NM="Tpl__ZN4llvmgeEiRKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmgeEiRKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> boolean $greatereq_int_ScaledNumber$DigitsT$C(int/*int32_t*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class ScaledNumberLlvmGlobals
