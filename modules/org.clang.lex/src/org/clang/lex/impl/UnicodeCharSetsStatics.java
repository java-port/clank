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
package org.clang.lex.impl;

import org.clank.support.*;
import org.llvm.support.sys.UnicodeCharRange;


//<editor-fold defaultstate="collapsed" desc="static type UnicodeCharSetsStatics">
@Converted(kind = Converted.Kind.AUTO, cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType -java-types-map=${SPUTNIK}/contrib/JConvert/llvmToClankType -print ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZL22C99AllowedIDCharRanges;_ZL24CXX03AllowedIDCharRanges;_ZL32C99DisallowedInitialIDCharRanges;_ZL32C11DisallowedInitialIDCharRanges;_ZL27UnicodeWhitespaceCharRanges;_ZL22C11AllowedIDCharRanges; -static-type=UnicodeCharSetsStatics")
//</editor-fold>
public final class UnicodeCharSetsStatics {


// C11 D.1, C++11 [charname.allowed]
//<editor-fold defaultstate="collapsed" desc="C11AllowedIDCharRanges">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/UnicodeCharSets.h", line = 15,
 FQN = "C11AllowedIDCharRanges", NM = "_ZL22C11AllowedIDCharRanges",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZL22C11AllowedIDCharRanges")
//</editor-fold>
public final static /*const*/UnicodeCharRange C11AllowedIDCharRanges[/*45*/] = new /*const*/UnicodeCharRange [/*45*/] {
  // 1
  new UnicodeCharRange(0x00A8, 0x00A8), new UnicodeCharRange(0x00AA, 0x00AA), new UnicodeCharRange(0x00AD, 0x00AD), 
  new UnicodeCharRange(0x00AF, 0x00AF), new UnicodeCharRange(0x00B2, 0x00B5), new UnicodeCharRange(0x00B7, 0x00BA), 
  new UnicodeCharRange(0x00BC, 0x00BE), new UnicodeCharRange(0x00C0, 0x00D6), new UnicodeCharRange(0x00D8, 0x00F6), 
  new UnicodeCharRange(0x00F8, 0x00FF), // 2
  new UnicodeCharRange(0x0100, 0x167F), new UnicodeCharRange(0x1681, 0x180D), new UnicodeCharRange(0x180F, 0x1FFF), // 3
  new UnicodeCharRange(0x200B, 0x200D), new UnicodeCharRange(0x202A, 0x202E), new UnicodeCharRange(0x203F, 0x2040), 
  new UnicodeCharRange(0x2054, 0x2054), new UnicodeCharRange(0x2060, 0x206F), // 4
  new UnicodeCharRange(0x2070, 0x218F), new UnicodeCharRange(0x2460, 0x24FF), new UnicodeCharRange(0x2776, 0x2793), 
  new UnicodeCharRange(0x2C00, 0x2DFF), new UnicodeCharRange(0x2E80, 0x2FFF), // 5
  new UnicodeCharRange(0x3004, 0x3007), new UnicodeCharRange(0x3021, 0x302F), new UnicodeCharRange(0x3031, 0x303F), // 6
  new UnicodeCharRange(0x3040, 0xD7FF), // 7
  new UnicodeCharRange(0xF900, 0xFD3D), new UnicodeCharRange(0xFD40, 0xFDCF), new UnicodeCharRange(0xFDF0, 0xFE44), 
  new UnicodeCharRange(0xFE47, 0xFFFD), // 8
  new UnicodeCharRange(0x10000, 0x1FFFD), new UnicodeCharRange(0x20000, 0x2FFFD), new UnicodeCharRange(0x30000, 0x3FFFD), 
  new UnicodeCharRange(0x40000, 0x4FFFD), new UnicodeCharRange(0x50000, 0x5FFFD), new UnicodeCharRange(0x60000, 0x6FFFD), 
  new UnicodeCharRange(0x70000, 0x7FFFD), new UnicodeCharRange(0x80000, 0x8FFFD), new UnicodeCharRange(0x90000, 0x9FFFD), 
  new UnicodeCharRange(0xA0000, 0xAFFFD), new UnicodeCharRange(0xB0000, 0xBFFFD), new UnicodeCharRange(0xC0000, 0xCFFFD), 
  new UnicodeCharRange(0xD0000, 0xDFFFD), new UnicodeCharRange(0xE0000, 0xEFFFD)
};

// C++03 [extendid]
// Note that this is not the same as C++98, but we don't distinguish C++98
// and C++03 in Clang.
//<editor-fold defaultstate="collapsed" desc="CXX03AllowedIDCharRanges">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/UnicodeCharSets.h", line = 47,
 FQN = "CXX03AllowedIDCharRanges", NM = "_ZL24CXX03AllowedIDCharRanges",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZL24CXX03AllowedIDCharRanges")
//</editor-fold>
public final static /*const*/UnicodeCharRange CXX03AllowedIDCharRanges[/*173*/] = new /*const*/UnicodeCharRange [/*173*/] {
  // Latin
  new UnicodeCharRange(0x00C0, 0x00D6), new UnicodeCharRange(0x00D8, 0x00F6), new UnicodeCharRange(0x00F8, 0x01F5), 
  new UnicodeCharRange(0x01FA, 0x0217), new UnicodeCharRange(0x0250, 0x02A8), 
  // Greek
  new UnicodeCharRange(0x0384, 0x0384), new UnicodeCharRange(0x0388, 0x038A), new UnicodeCharRange(0x038C, 0x038C), 
  new UnicodeCharRange(0x038E, 0x03A1), new UnicodeCharRange(0x03A3, 0x03CE), new UnicodeCharRange(0x03D0, 0x03D6), 
  new UnicodeCharRange(0x03DA, 0x03DA), new UnicodeCharRange(0x03DC, 0x03DC), new UnicodeCharRange(0x03DE, 0x03DE), 
  new UnicodeCharRange(0x03E0, 0x03E0), new UnicodeCharRange(0x03E2, 0x03F3), 
  // Cyrillic
  new UnicodeCharRange(0x0401, 0x040D), new UnicodeCharRange(0x040F, 0x044F), new UnicodeCharRange(0x0451, 0x045C), 
  new UnicodeCharRange(0x045E, 0x0481), new UnicodeCharRange(0x0490, 0x04C4), new UnicodeCharRange(0x04C7, 0x04C8), 
  new UnicodeCharRange(0x04CB, 0x04CC), new UnicodeCharRange(0x04D0, 0x04EB), new UnicodeCharRange(0x04EE, 0x04F5), 
  new UnicodeCharRange(0x04F8, 0x04F9), 
  // Armenian
  new UnicodeCharRange(0x0531, 0x0556), new UnicodeCharRange(0x0561, 0x0587), 
  // Hebrew
  new UnicodeCharRange(0x05D0, 0x05EA), new UnicodeCharRange(0x05F0, 0x05F4), 
  // Arabic
  new UnicodeCharRange(0x0621, 0x063A), new UnicodeCharRange(0x0640, 0x0652), new UnicodeCharRange(0x0670, 0x06B7), 
  new UnicodeCharRange(0x06BA, 0x06BE), new UnicodeCharRange(0x06C0, 0x06CE), new UnicodeCharRange(0x06E5, 0x06E7), 
  // Devanagari
  new UnicodeCharRange(0x0905, 0x0939), new UnicodeCharRange(0x0958, 0x0962), 
  // Bengali
  new UnicodeCharRange(0x0985, 0x098C), new UnicodeCharRange(0x098F, 0x0990), new UnicodeCharRange(0x0993, 0x09A8), 
  new UnicodeCharRange(0x09AA, 0x09B0), new UnicodeCharRange(0x09B2, 0x09B2), new UnicodeCharRange(0x09B6, 0x09B9), 
  new UnicodeCharRange(0x09DC, 0x09DD), new UnicodeCharRange(0x09DF, 0x09E1), new UnicodeCharRange(0x09F0, 0x09F1), 
  // Gurmukhi
  new UnicodeCharRange(0x0A05, 0x0A0A), new UnicodeCharRange(0x0A0F, 0x0A10), new UnicodeCharRange(0x0A13, 0x0A28), 
  new UnicodeCharRange(0x0A2A, 0x0A30), new UnicodeCharRange(0x0A32, 0x0A33), new UnicodeCharRange(0x0A35, 0x0A36), 
  new UnicodeCharRange(0x0A38, 0x0A39), new UnicodeCharRange(0x0A59, 0x0A5C), new UnicodeCharRange(0x0A5E, 0x0A5E), 
  // Gujarti
  new UnicodeCharRange(0x0A85, 0x0A8B), new UnicodeCharRange(0x0A8D, 0x0A8D), new UnicodeCharRange(0x0A8F, 0x0A91), 
  new UnicodeCharRange(0x0A93, 0x0AA8), new UnicodeCharRange(0x0AAA, 0x0AB0), new UnicodeCharRange(0x0AB2, 0x0AB3), 
  new UnicodeCharRange(0x0AB5, 0x0AB9), new UnicodeCharRange(0x0AE0, 0x0AE0), 
  // Oriya
  new UnicodeCharRange(0x0B05, 0x0B0C), new UnicodeCharRange(0x0B0F, 0x0B10), new UnicodeCharRange(0x0B13, 0x0B28), 
  new UnicodeCharRange(0x0B2A, 0x0B30), new UnicodeCharRange(0x0B32, 0x0B33), new UnicodeCharRange(0x0B36, 0x0B39), 
  new UnicodeCharRange(0x0B5C, 0x0B5D), new UnicodeCharRange(0x0B5F, 0x0B61), 
  // Tamil
  new UnicodeCharRange(0x0B85, 0x0B8A), new UnicodeCharRange(0x0B8E, 0x0B90), new UnicodeCharRange(0x0B92, 0x0B95), 
  new UnicodeCharRange(0x0B99, 0x0B9A), new UnicodeCharRange(0x0B9C, 0x0B9C), new UnicodeCharRange(0x0B9E, 0x0B9F), 
  new UnicodeCharRange(0x0BA3, 0x0BA4), new UnicodeCharRange(0x0BA8, 0x0BAA), new UnicodeCharRange(0x0BAE, 0x0BB5), 
  new UnicodeCharRange(0x0BB7, 0x0BB9), 
  // Telugu
  new UnicodeCharRange(0x0C05, 0x0C0C), new UnicodeCharRange(0x0C0E, 0x0C10), new UnicodeCharRange(0x0C12, 0x0C28), 
  new UnicodeCharRange(0x0C2A, 0x0C33), new UnicodeCharRange(0x0C35, 0x0C39), new UnicodeCharRange(0x0C60, 0x0C61), 
  // Kannada
  new UnicodeCharRange(0x0C85, 0x0C8C), new UnicodeCharRange(0x0C8E, 0x0C90), new UnicodeCharRange(0x0C92, 0x0CA8), 
  new UnicodeCharRange(0x0CAA, 0x0CB3), new UnicodeCharRange(0x0CB5, 0x0CB9), new UnicodeCharRange(0x0CE0, 0x0CE1), 
  // Malayam
  new UnicodeCharRange(0x0D05, 0x0D0C), new UnicodeCharRange(0x0D0E, 0x0D10), new UnicodeCharRange(0x0D12, 0x0D28), 
  new UnicodeCharRange(0x0D2A, 0x0D39), new UnicodeCharRange(0x0D60, 0x0D61), 
  // Thai
  new UnicodeCharRange(0x0E01, 0x0E30), new UnicodeCharRange(0x0E32, 0x0E33), new UnicodeCharRange(0x0E40, 0x0E46), 
  new UnicodeCharRange(0x0E4F, 0x0E5B), 
  // Lao
  new UnicodeCharRange(0x0E81, 0x0E82), new UnicodeCharRange(0x0E84, 0x0E84), new UnicodeCharRange(0x0E87, 0x0E87), 
  new UnicodeCharRange(0x0E88, 0x0E88), new UnicodeCharRange(0x0E8A, 0x0E8A), new UnicodeCharRange(0x0E8D, 0x0E8D), 
  new UnicodeCharRange(0x0E94, 0x0E97), new UnicodeCharRange(0x0E99, 0x0E9F), new UnicodeCharRange(0x0EA1, 0x0EA3), 
  new UnicodeCharRange(0x0EA5, 0x0EA5), new UnicodeCharRange(0x0EA7, 0x0EA7), new UnicodeCharRange(0x0EAA, 0x0EAA), 
  new UnicodeCharRange(0x0EAB, 0x0EAB), new UnicodeCharRange(0x0EAD, 0x0EB0), new UnicodeCharRange(0x0EB2, 0x0EB2), 
  new UnicodeCharRange(0x0EB3, 0x0EB3), new UnicodeCharRange(0x0EBD, 0x0EBD), new UnicodeCharRange(0x0EC0, 0x0EC4), 
  new UnicodeCharRange(0x0EC6, 0x0EC6), 
  // Georgian
  new UnicodeCharRange(0x10A0, 0x10C5), new UnicodeCharRange(0x10D0, 0x10F6), 
  // Hangul
  new UnicodeCharRange(0x1100, 0x1159), new UnicodeCharRange(0x1161, 0x11A2), new UnicodeCharRange(0x11A8, 0x11F9), 
  // Latin (2)
  new UnicodeCharRange(0x1E00, 0x1E9A), new UnicodeCharRange(0x1EA0, 0x1EF9), 
  // Greek (2)
  new UnicodeCharRange(0x1F00, 0x1F15), new UnicodeCharRange(0x1F18, 0x1F1D), new UnicodeCharRange(0x1F20, 0x1F45), 
  new UnicodeCharRange(0x1F48, 0x1F4D), new UnicodeCharRange(0x1F50, 0x1F57), new UnicodeCharRange(0x1F59, 0x1F59), 
  new UnicodeCharRange(0x1F5B, 0x1F5B), new UnicodeCharRange(0x1F5D, 0x1F5D), new UnicodeCharRange(0x1F5F, 0x1F7D), 
  new UnicodeCharRange(0x1F80, 0x1FB4), new UnicodeCharRange(0x1FB6, 0x1FBC), new UnicodeCharRange(0x1FC2, 0x1FC4), 
  new UnicodeCharRange(0x1FC6, 0x1FCC), new UnicodeCharRange(0x1FD0, 0x1FD3), new UnicodeCharRange(0x1FD6, 0x1FDB), 
  new UnicodeCharRange(0x1FE0, 0x1FEC), new UnicodeCharRange(0x1FF2, 0x1FF4), new UnicodeCharRange(0x1FF6, 0x1FFC), 
  // Hiragana
  new UnicodeCharRange(0x3041, 0x3094), new UnicodeCharRange(0x309B, 0x309E), 
  // Katakana
  new UnicodeCharRange(0x30A1, 0x30FE), 
  // Bopmofo [sic]
  new UnicodeCharRange(0x3105, 0x312C), 
  // CJK Unified Ideographs
  new UnicodeCharRange(0x4E00, 0x9FA5), new UnicodeCharRange(0xF900, 0xFA2D), new UnicodeCharRange(0xFB1F, 0xFB36), 
  new UnicodeCharRange(0xFB38, 0xFB3C), new UnicodeCharRange(0xFB3E, 0xFB3E), new UnicodeCharRange(0xFB40, 0xFB41), 
  new UnicodeCharRange(0xFB42, 0xFB44), new UnicodeCharRange(0xFB46, 0xFBB1), new UnicodeCharRange(0xFBD3, 0xFD3F), 
  new UnicodeCharRange(0xFD50, 0xFD8F), new UnicodeCharRange(0xFD92, 0xFDC7), new UnicodeCharRange(0xFDF0, 0xFDFB), 
  new UnicodeCharRange(0xFE70, 0xFE72), new UnicodeCharRange(0xFE74, 0xFE74), new UnicodeCharRange(0xFE76, 0xFEFC), 
  new UnicodeCharRange(0xFF21, 0xFF3A), new UnicodeCharRange(0xFF41, 0xFF5A), new UnicodeCharRange(0xFF66, 0xFFBE), 
  new UnicodeCharRange(0xFFC2, 0xFFC7), new UnicodeCharRange(0xFFCA, 0xFFCF), new UnicodeCharRange(0xFFD2, 0xFFD7), 
  new UnicodeCharRange(0xFFDA, 0xFFDC)
};

// C99 Annex D
//<editor-fold defaultstate="collapsed" desc="C99AllowedIDCharRanges">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/UnicodeCharSets.h", line = 166,
 FQN = "C99AllowedIDCharRanges", NM = "_ZL22C99AllowedIDCharRanges",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZL22C99AllowedIDCharRanges")
//</editor-fold>
public static /*const*/ UnicodeCharRange C99AllowedIDCharRanges[/*246*/] = new /*const*/ UnicodeCharRange [/*246*/] {
  // Latin (1)
  new UnicodeCharRange(0x00AA, 0x00AA), 
  
  // Special characters (1)
  new UnicodeCharRange(0x00B5, 0x00B5), new UnicodeCharRange(0x00B7, 0x00B7), 
  
  // Latin (2)
  new UnicodeCharRange(0x00BA, 0x00BA), new UnicodeCharRange(0x00C0, 0x00D6), new UnicodeCharRange(0x00D8, 0x00F6), 
  new UnicodeCharRange(0x00F8, 0x01F5), new UnicodeCharRange(0x01FA, 0x0217), new UnicodeCharRange(0x0250, 0x02A8), 
  
  // Special characters (2)
  new UnicodeCharRange(0x02B0, 0x02B8), new UnicodeCharRange(0x02BB, 0x02BB), new UnicodeCharRange(0x02BD, 0x02C1), 
  new UnicodeCharRange(0x02D0, 0x02D1), new UnicodeCharRange(0x02E0, 0x02E4), new UnicodeCharRange(0x037A, 0x037A), 
  
  // Greek (1)
  new UnicodeCharRange(0x0386, 0x0386), new UnicodeCharRange(0x0388, 0x038A), new UnicodeCharRange(0x038C, 0x038C), 
  new UnicodeCharRange(0x038E, 0x03A1), new UnicodeCharRange(0x03A3, 0x03CE), new UnicodeCharRange(0x03D0, 0x03D6), 
  new UnicodeCharRange(0x03DA, 0x03DA), new UnicodeCharRange(0x03DC, 0x03DC), new UnicodeCharRange(0x03DE, 0x03DE), 
  new UnicodeCharRange(0x03E0, 0x03E0), new UnicodeCharRange(0x03E2, 0x03F3), 
  
  // Cyrillic
  new UnicodeCharRange(0x0401, 0x040C), new UnicodeCharRange(0x040E, 0x044F), new UnicodeCharRange(0x0451, 0x045C), 
  new UnicodeCharRange(0x045E, 0x0481), new UnicodeCharRange(0x0490, 0x04C4), new UnicodeCharRange(0x04C7, 0x04C8), 
  new UnicodeCharRange(0x04CB, 0x04CC), new UnicodeCharRange(0x04D0, 0x04EB), new UnicodeCharRange(0x04EE, 0x04F5), 
  new UnicodeCharRange(0x04F8, 0x04F9), 
  
  // Armenian (1)
  new UnicodeCharRange(0x0531, 0x0556), 
  
  // Special characters (3)
  new UnicodeCharRange(0x0559, 0x0559), 
  
  // Armenian (2)
  new UnicodeCharRange(0x0561, 0x0587), 
  
  // Hebrew
  new UnicodeCharRange(0x05B0, 0x05B9), new UnicodeCharRange(0x05BB, 0x05BD), new UnicodeCharRange(0x05BF, 0x05BF), 
  new UnicodeCharRange(0x05C1, 0x05C2), new UnicodeCharRange(0x05D0, 0x05EA), new UnicodeCharRange(0x05F0, 0x05F2), 
  
  // Arabic (1)
  new UnicodeCharRange(0x0621, 0x063A), new UnicodeCharRange(0x0640, 0x0652), 
  
  // Digits (1)
  new UnicodeCharRange(0x0660, 0x0669), 
  
  // Arabic (2)
  new UnicodeCharRange(0x0670, 0x06B7), new UnicodeCharRange(0x06BA, 0x06BE), new UnicodeCharRange(0x06C0, 0x06CE), 
  new UnicodeCharRange(0x06D0, 0x06DC), new UnicodeCharRange(0x06E5, 0x06E8), new UnicodeCharRange(0x06EA, 0x06ED), 
  
  // Digits (2)
  new UnicodeCharRange(0x06F0, 0x06F9), 
  
  // Devanagari and Special characeter 0x093D.
  new UnicodeCharRange(0x0901, 0x0903), new UnicodeCharRange(0x0905, 0x0939), new UnicodeCharRange(0x093D, 0x094D), 
  new UnicodeCharRange(0x0950, 0x0952), new UnicodeCharRange(0x0958, 0x0963), 
  
  // Digits (3)
  new UnicodeCharRange(0x0966, 0x096F), 
  
  // Bengali (1)
  new UnicodeCharRange(0x0981, 0x0983), new UnicodeCharRange(0x0985, 0x098C), new UnicodeCharRange(0x098F, 0x0990), 
  new UnicodeCharRange(0x0993, 0x09A8), new UnicodeCharRange(0x09AA, 0x09B0), new UnicodeCharRange(0x09B2, 0x09B2), 
  new UnicodeCharRange(0x09B6, 0x09B9), new UnicodeCharRange(0x09BE, 0x09C4), new UnicodeCharRange(0x09C7, 0x09C8), 
  new UnicodeCharRange(0x09CB, 0x09CD), new UnicodeCharRange(0x09DC, 0x09DD), new UnicodeCharRange(0x09DF, 0x09E3), 
  
  // Digits (4)
  new UnicodeCharRange(0x09E6, 0x09EF), 
  
  // Bengali (2)
  new UnicodeCharRange(0x09F0, 0x09F1), 
  
  // Gurmukhi (1)
  new UnicodeCharRange(0x0A02, 0x0A02), new UnicodeCharRange(0x0A05, 0x0A0A), new UnicodeCharRange(0x0A0F, 0x0A10), 
  new UnicodeCharRange(0x0A13, 0x0A28), new UnicodeCharRange(0x0A2A, 0x0A30), new UnicodeCharRange(0x0A32, 0x0A33), 
  new UnicodeCharRange(0x0A35, 0x0A36), new UnicodeCharRange(0x0A38, 0x0A39), new UnicodeCharRange(0x0A3E, 0x0A42), 
  new UnicodeCharRange(0x0A47, 0x0A48), new UnicodeCharRange(0x0A4B, 0x0A4D), new UnicodeCharRange(0x0A59, 0x0A5C), 
  new UnicodeCharRange(0x0A5E, 0x0A5E), 
  
  // Digits (5)
  new UnicodeCharRange(0x0A66, 0x0A6F), 
  
  // Gurmukhi (2)
  new UnicodeCharRange(0x0A74, 0x0A74), 
  
  // Gujarti
  new UnicodeCharRange(0x0A81, 0x0A83), new UnicodeCharRange(0x0A85, 0x0A8B), new UnicodeCharRange(0x0A8D, 0x0A8D), 
  new UnicodeCharRange(0x0A8F, 0x0A91), new UnicodeCharRange(0x0A93, 0x0AA8), new UnicodeCharRange(0x0AAA, 0x0AB0), 
  new UnicodeCharRange(0x0AB2, 0x0AB3), new UnicodeCharRange(0x0AB5, 0x0AB9), new UnicodeCharRange(0x0ABD, 0x0AC5), 
  new UnicodeCharRange(0x0AC7, 0x0AC9), new UnicodeCharRange(0x0ACB, 0x0ACD), new UnicodeCharRange(0x0AD0, 0x0AD0), 
  new UnicodeCharRange(0x0AE0, 0x0AE0), 
  
  // Digits (6)
  new UnicodeCharRange(0x0AE6, 0x0AEF), 
  
  // Oriya and Special character 0x0B3D
  new UnicodeCharRange(0x0B01, 0x0B03), new UnicodeCharRange(0x0B05, 0x0B0C), new UnicodeCharRange(0x0B0F, 0x0B10), 
  new UnicodeCharRange(0x0B13, 0x0B28), new UnicodeCharRange(0x0B2A, 0x0B30), new UnicodeCharRange(0x0B32, 0x0B33), 
  new UnicodeCharRange(0x0B36, 0x0B39), new UnicodeCharRange(0x0B3D, 0x0B43), new UnicodeCharRange(0x0B47, 0x0B48), 
  new UnicodeCharRange(0x0B4B, 0x0B4D), new UnicodeCharRange(0x0B5C, 0x0B5D), new UnicodeCharRange(0x0B5F, 0x0B61), 
  
  // Digits (7)
  new UnicodeCharRange(0x0B66, 0x0B6F), 
  
  // Tamil
  new UnicodeCharRange(0x0B82, 0x0B83), new UnicodeCharRange(0x0B85, 0x0B8A), new UnicodeCharRange(0x0B8E, 0x0B90), 
  new UnicodeCharRange(0x0B92, 0x0B95), new UnicodeCharRange(0x0B99, 0x0B9A), new UnicodeCharRange(0x0B9C, 0x0B9C), 
  new UnicodeCharRange(0x0B9E, 0x0B9F), new UnicodeCharRange(0x0BA3, 0x0BA4), new UnicodeCharRange(0x0BA8, 0x0BAA), 
  new UnicodeCharRange(0x0BAE, 0x0BB5), new UnicodeCharRange(0x0BB7, 0x0BB9), new UnicodeCharRange(0x0BBE, 0x0BC2), 
  new UnicodeCharRange(0x0BC6, 0x0BC8), new UnicodeCharRange(0x0BCA, 0x0BCD), 
  
  // Digits (8)
  new UnicodeCharRange(0x0BE7, 0x0BEF), 
  
  // Telugu
  new UnicodeCharRange(0x0C01, 0x0C03), new UnicodeCharRange(0x0C05, 0x0C0C), new UnicodeCharRange(0x0C0E, 0x0C10), 
  new UnicodeCharRange(0x0C12, 0x0C28), new UnicodeCharRange(0x0C2A, 0x0C33), new UnicodeCharRange(0x0C35, 0x0C39), 
  new UnicodeCharRange(0x0C3E, 0x0C44), new UnicodeCharRange(0x0C46, 0x0C48), new UnicodeCharRange(0x0C4A, 0x0C4D), 
  new UnicodeCharRange(0x0C60, 0x0C61), 
  
  // Digits (9)
  new UnicodeCharRange(0x0C66, 0x0C6F), 
  
  // Kannada
  new UnicodeCharRange(0x0C82, 0x0C83), new UnicodeCharRange(0x0C85, 0x0C8C), new UnicodeCharRange(0x0C8E, 0x0C90), 
  new UnicodeCharRange(0x0C92, 0x0CA8), new UnicodeCharRange(0x0CAA, 0x0CB3), new UnicodeCharRange(0x0CB5, 0x0CB9), 
  new UnicodeCharRange(0x0CBE, 0x0CC4), new UnicodeCharRange(0x0CC6, 0x0CC8), new UnicodeCharRange(0x0CCA, 0x0CCD), 
  new UnicodeCharRange(0x0CDE, 0x0CDE), new UnicodeCharRange(0x0CE0, 0x0CE1), 
  
  // Digits (10)
  new UnicodeCharRange(0x0CE6, 0x0CEF), 
  
  // Malayam
  new UnicodeCharRange(0x0D02, 0x0D03), new UnicodeCharRange(0x0D05, 0x0D0C), new UnicodeCharRange(0x0D0E, 0x0D10), 
  new UnicodeCharRange(0x0D12, 0x0D28), new UnicodeCharRange(0x0D2A, 0x0D39), new UnicodeCharRange(0x0D3E, 0x0D43), 
  new UnicodeCharRange(0x0D46, 0x0D48), new UnicodeCharRange(0x0D4A, 0x0D4D), new UnicodeCharRange(0x0D60, 0x0D61), 
  
  // Digits (11)
  new UnicodeCharRange(0x0D66, 0x0D6F), 
  
  // Thai...including Digits { 0x0E50, 0x0E59 }
  new UnicodeCharRange(0x0E01, 0x0E3A), new UnicodeCharRange(0x0E40, 0x0E5B), 
  
  // Lao (1)
  new UnicodeCharRange(0x0E81, 0x0E82), new UnicodeCharRange(0x0E84, 0x0E84), new UnicodeCharRange(0x0E87, 0x0E88), 
  new UnicodeCharRange(0x0E8A, 0x0E8A), new UnicodeCharRange(0x0E8D, 0x0E8D), new UnicodeCharRange(0x0E94, 0x0E97), 
  new UnicodeCharRange(0x0E99, 0x0E9F), new UnicodeCharRange(0x0EA1, 0x0EA3), new UnicodeCharRange(0x0EA5, 0x0EA5), 
  new UnicodeCharRange(0x0EA7, 0x0EA7), new UnicodeCharRange(0x0EAA, 0x0EAB), new UnicodeCharRange(0x0EAD, 0x0EAE), 
  new UnicodeCharRange(0x0EB0, 0x0EB9), new UnicodeCharRange(0x0EBB, 0x0EBD), new UnicodeCharRange(0x0EC0, 0x0EC4), 
  new UnicodeCharRange(0x0EC6, 0x0EC6), new UnicodeCharRange(0x0EC8, 0x0ECD), 
  
  // Digits (12)
  new UnicodeCharRange(0x0ED0, 0x0ED9), 
  
  // Lao (2)
  new UnicodeCharRange(0x0EDC, 0x0EDD), 
  
  // Tibetan (1)
  new UnicodeCharRange(0x0F00, 0x0F00), new UnicodeCharRange(0x0F18, 0x0F19), 
  
  // Digits (13)
  new UnicodeCharRange(0x0F20, 0x0F33), 
  
  // Tibetan (2)
  new UnicodeCharRange(0x0F35, 0x0F35), new UnicodeCharRange(0x0F37, 0x0F37), new UnicodeCharRange(0x0F39, 0x0F39), 
  new UnicodeCharRange(0x0F3E, 0x0F47), new UnicodeCharRange(0x0F49, 0x0F69), new UnicodeCharRange(0x0F71, 0x0F84), 
  new UnicodeCharRange(0x0F86, 0x0F8B), new UnicodeCharRange(0x0F90, 0x0F95), new UnicodeCharRange(0x0F97, 0x0F97), 
  new UnicodeCharRange(0x0F99, 0x0FAD), new UnicodeCharRange(0x0FB1, 0x0FB7), new UnicodeCharRange(0x0FB9, 0x0FB9), 
  
  // Georgian
  new UnicodeCharRange(0x10A0, 0x10C5), new UnicodeCharRange(0x10D0, 0x10F6), 
  
  // Latin (3)
  new UnicodeCharRange(0x1E00, 0x1E9B), new UnicodeCharRange(0x1EA0, 0x1EF9), 
  
  // Greek (2)
  new UnicodeCharRange(0x1F00, 0x1F15), new UnicodeCharRange(0x1F18, 0x1F1D), new UnicodeCharRange(0x1F20, 0x1F45), 
  new UnicodeCharRange(0x1F48, 0x1F4D), new UnicodeCharRange(0x1F50, 0x1F57), new UnicodeCharRange(0x1F59, 0x1F59), 
  new UnicodeCharRange(0x1F5B, 0x1F5B), new UnicodeCharRange(0x1F5D, 0x1F5D), new UnicodeCharRange(0x1F5F, 0x1F7D), 
  new UnicodeCharRange(0x1F80, 0x1FB4), new UnicodeCharRange(0x1FB6, 0x1FBC), 
  
  // Special characters (4)
  new UnicodeCharRange(0x1FBE, 0x1FBE), 
  
  // Greek (3)
  new UnicodeCharRange(0x1FC2, 0x1FC4), new UnicodeCharRange(0x1FC6, 0x1FCC), new UnicodeCharRange(0x1FD0, 0x1FD3), 
  new UnicodeCharRange(0x1FD6, 0x1FDB), new UnicodeCharRange(0x1FE0, 0x1FEC), new UnicodeCharRange(0x1FF2, 0x1FF4), 
  new UnicodeCharRange(0x1FF6, 0x1FFC), 
  
  // Special characters (5)
  new UnicodeCharRange(0x203F, 0x2040), 
  
  // Latin (4)
  new UnicodeCharRange(0x207F, 0x207F), 
  
  // Special characters (6)
  new UnicodeCharRange(0x2102, 0x2102), new UnicodeCharRange(0x2107, 0x2107), new UnicodeCharRange(0x210A, 0x2113), 
  new UnicodeCharRange(0x2115, 0x2115), new UnicodeCharRange(0x2118, 0x211D), new UnicodeCharRange(0x2124, 0x2124), 
  new UnicodeCharRange(0x2126, 0x2126), new UnicodeCharRange(0x2128, 0x2128), new UnicodeCharRange(0x212A, 0x2131), 
  new UnicodeCharRange(0x2133, 0x2138), new UnicodeCharRange(0x2160, 0x2182), new UnicodeCharRange(0x3005, 0x3007), 
  new UnicodeCharRange(0x3021, 0x3029), 
  
  // Hiragana
  new UnicodeCharRange(0x3041, 0x3093), new UnicodeCharRange(0x309B, 0x309C), 
  
  // Katakana
  new UnicodeCharRange(0x30A1, 0x30F6), new UnicodeCharRange(0x30FB, 0x30FC), 
  
  // Bopmofo [sic]
  new UnicodeCharRange(0x3105, 0x312C), 
  
  // CJK Unified Ideographs
  new UnicodeCharRange(0x4E00, 0x9FA5), 
  
  // Hangul,
  new UnicodeCharRange(0xAC00, 0xD7A3)
};

// C11 D.2, C++11 [charname.disallowed]
//<editor-fold defaultstate="collapsed" desc="C11DisallowedInitialIDCharRanges">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/UnicodeCharSets.h", line = 385,
 FQN = "C11DisallowedInitialIDCharRanges", NM = "_ZL32C11DisallowedInitialIDCharRanges",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZL32C11DisallowedInitialIDCharRanges")
//</editor-fold>
public final static /*const*/UnicodeCharRange C11DisallowedInitialIDCharRanges[/*4*/] = new /*const*/UnicodeCharRange [/*4*/] {
  new UnicodeCharRange(0x0300, 0x036F), new UnicodeCharRange(0x1DC0, 0x1DFF), new UnicodeCharRange(0x20D0, 0x20FF), 
  new UnicodeCharRange(0xFE20, 0xFE2F)
};

// C99 6.4.2.1p3: The initial character [of an identifier] shall not be a
// universal character name designating a digit.
// C99 Annex D defines these characters as "Digits".
//<editor-fold defaultstate="collapsed" desc="C99DisallowedInitialIDCharRanges">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/UnicodeCharSets.h", line = 393,
 FQN = "C99DisallowedInitialIDCharRanges", NM = "_ZL32C99DisallowedInitialIDCharRanges",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZL32C99DisallowedInitialIDCharRanges")
//</editor-fold>
public final static /*const*/UnicodeCharRange C99DisallowedInitialIDCharRanges[/*14*/] = new /*const*/UnicodeCharRange [/*14*/] {
  new UnicodeCharRange(0x0660, 0x0669), new UnicodeCharRange(0x06F0, 0x06F9), new UnicodeCharRange(0x0966, 0x096F), 
  new UnicodeCharRange(0x09E6, 0x09EF), new UnicodeCharRange(0x0A66, 0x0A6F), new UnicodeCharRange(0x0AE6, 0x0AEF), 
  new UnicodeCharRange(0x0B66, 0x0B6F), new UnicodeCharRange(0x0BE7, 0x0BEF), new UnicodeCharRange(0x0C66, 0x0C6F), 
  new UnicodeCharRange(0x0CE6, 0x0CEF), new UnicodeCharRange(0x0D66, 0x0D6F), new UnicodeCharRange(0x0E50, 0x0E59), 
  new UnicodeCharRange(0x0ED0, 0x0ED9), new UnicodeCharRange(0x0F20, 0x0F33)
};

// Unicode v6.2, chapter 6.2, table 6-2.
//<editor-fold defaultstate="collapsed" desc="UnicodeWhitespaceCharRanges">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/UnicodeCharSets.h", line = 402,
 FQN = "UnicodeWhitespaceCharRanges", NM = "_ZL27UnicodeWhitespaceCharRanges",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZL27UnicodeWhitespaceCharRanges")
//</editor-fold>
public final static /*const*/UnicodeCharRange UnicodeWhitespaceCharRanges[/*9*/] = new /*const*/UnicodeCharRange [/*9*/] {
  new UnicodeCharRange(0x0085, 0x0085), new UnicodeCharRange(0x00A0, 0x00A0), new UnicodeCharRange(0x1680, 0x1680), 
  new UnicodeCharRange(0x180E, 0x180E), new UnicodeCharRange(0x2000, 0x200A), new UnicodeCharRange(0x2028, 0x2029), 
  new UnicodeCharRange(0x202F, 0x202F), new UnicodeCharRange(0x205F, 0x205F), new UnicodeCharRange(0x3000, 0x3000)
};
} // END OF class UnicodeCharSetsStatics
