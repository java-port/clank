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
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;


//<editor-fold defaultstate="collapsed" desc="static type FormatLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.support.impl.FormatLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=Tpl__ZN4llvm6formatEPKcDpRKT_;_ZN4llvm10format_hexEyjb;_ZN4llvm12left_justifyENS_9StringRefEj;_ZN4llvm13right_justifyENS_9StringRefEj;_ZN4llvm14format_decimalExj;_ZN4llvm20format_hex_no_prefixEyjb; -static-type=FormatLlvmGlobals -package=org.llvm.support.impl")
//</editor-fold>
public final class FormatLlvmGlobals {


/// These are helper functions used to produce formatted output.  They use
/// template type deduction to construct the appropriate instance of the
/// format_object class to simplify their construction.
///
/// This is typically used like:
/// \code
///   OS << format("%0.4f", myfloat) << '\n';
/// \endcode
/*template <typename ... Ts> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::format">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 111,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", old_line = 110,
 FQN="llvm::format", NM="Tpl__ZN4llvm6formatEPKcDpRKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=Tpl__ZN4llvm6formatEPKcDpRKT_")
//</editor-fold>
public static /*inline*/ format_object format(/*const*/char$ptr/*char P*/ Fmt, /*const*/ Object /*&*/ ... Vals) {
  return new format_object(Fmt, Vals);
}


/// left_justify - append spaces after string so total output is
/// \p Width characters.  If \p Str is larger that \p Width, full string
/// is written with no padding.
//<editor-fold defaultstate="collapsed" desc="llvm::left_justify">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 130,
 FQN="llvm::left_justify", NM="_ZN4llvm12left_justifyENS_9StringRefEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm12left_justifyENS_9StringRefEj")
//</editor-fold>
public static /*inline*/ FormattedString left_justify(StringRef Str, /*uint*/int Width) {
  return new FormattedString(new StringRef(Str), Width, false);
}


/// right_justify - add spaces before string so total output is
/// \p Width characters.  If \p Str is larger that \p Width, full string
/// is written with no padding.
//<editor-fold defaultstate="collapsed" desc="llvm::right_justify">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 137,
 FQN="llvm::right_justify", NM="_ZN4llvm13right_justifyENS_9StringRefEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm13right_justifyENS_9StringRefEj")
//</editor-fold>
public static /*inline*/ FormattedString right_justify(StringRef Str, /*uint*/int Width) {
  return new FormattedString(new StringRef(Str), Width, true);
}


/// format_hex - Output \p N as a fixed width hexadecimal. If number will not
/// fit in width, full number is still printed.  Examples:
///   OS << format_hex(255, 4)              => 0xff
///   OS << format_hex(255, 4, true)        => 0xFF
///   OS << format_hex(255, 6)              => 0x00ff
///   OS << format_hex(255, 2)              => 0xff
//<editor-fold defaultstate="collapsed" desc="llvm::format_hex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 164,
 FQN="llvm::format_hex", NM="_ZN4llvm10format_hexEyjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm10format_hexEyjb")
//</editor-fold>
public static /*inline*/ FormattedNumber format_hex(long/*uint64_t*/ N, /*uint*/int Width) {
  return format_hex(N, Width, 
          false);
}
public static /*inline*/ FormattedNumber format_hex(long/*uint64_t*/ N, /*uint*/int Width, 
          boolean Upper/*= false*/) {
  assert ($lesseq_uint(Width, 18)) : "hex width must be <= 18";
  return new FormattedNumber(N, 0, Width, true, Upper, true);
}


/// format_hex_no_prefix - Output \p N as a fixed width hexadecimal. Does not
/// prepend '0x' to the outputted string.  If number will not fit in width,
/// full number is still printed.  Examples:
///   OS << format_hex_no_prefix(255, 2)              => ff
///   OS << format_hex_no_prefix(255, 2, true)        => FF
///   OS << format_hex_no_prefix(255, 4)              => 00ff
///   OS << format_hex_no_prefix(255, 1)              => ff
//<editor-fold defaultstate="collapsed" desc="llvm::format_hex_no_prefix">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 177,
 FQN="llvm::format_hex_no_prefix", NM="_ZN4llvm20format_hex_no_prefixEyjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm20format_hex_no_prefixEyjb")
//</editor-fold>
public static /*inline*/ FormattedNumber format_hex_no_prefix(long/*uint64_t*/ N, /*uint*/int Width) {
  return format_hex_no_prefix(N, Width, 
                    false);
}
public static /*inline*/ FormattedNumber format_hex_no_prefix(long/*uint64_t*/ N, /*uint*/int Width, 
                    boolean Upper/*= false*/) {
  assert ($lesseq_uint(Width, 16)) : "hex width must be <= 16";
  return new FormattedNumber(N, 0, Width, true, Upper, false);
}


/// format_decimal - Output \p N as a right justified, fixed-width decimal. If
/// number will not fit in width, full number is still printed.  Examples:
///   OS << format_decimal(0, 5)     => "    0"
///   OS << format_decimal(255, 5)   => "  255"
///   OS << format_decimal(-1, 3)    => " -1"
///   OS << format_decimal(12345, 3) => "12345"
//<editor-fold defaultstate="collapsed" desc="llvm::format_decimal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 189,
 FQN="llvm::format_decimal", NM="_ZN4llvm14format_decimalExj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm14format_decimalExj")
//</editor-fold>
public static /*inline*/ FormattedNumber format_decimal(long/*int64_t*/ N, /*uint*/int Width) {
  return new FormattedNumber($int2ulong(0), N, Width, false, false, false);
}

} // END OF class FormatLlvmGlobals
