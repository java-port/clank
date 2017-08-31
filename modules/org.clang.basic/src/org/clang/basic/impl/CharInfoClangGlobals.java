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
package org.clang.basic.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;

import static org.clang.basic.charinfo.*;


//<editor-fold defaultstate="collapsed" desc="static type CharInfoClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL10isHexDigitEh;_ZN5clangL11isLowercaseEh;_ZN5clangL11isPrintableEh;_ZN5clangL11isUppercaseEh;_ZN5clangL11toLowercaseEc;_ZN5clangL11toUppercaseEc;_ZN5clangL12isWhitespaceEh;_ZN5clangL13isPunctuationEh;_ZN5clangL14isAlphanumericEh;_ZN5clangL16isIdentifierBodyEhb;_ZN5clangL16isIdentifierHeadEhb;_ZN5clangL17isValidIdentifierEN4llvm9StringRefE;_ZN5clangL20isRawStringDelimBodyEh;_ZN5clangL20isVerticalWhitespaceEh;_ZN5clangL22isHorizontalWhitespaceEh;_ZN5clangL25isPreprocessingNumberBodyEh;_ZN5clangL7isASCIIEc;_ZN5clangL7isDigitEh;_ZN5clangL8isLetterEh; -static-type=CharInfoClangGlobals -package=org.clang.basic.impl")
//</editor-fold>
public final class CharInfoClangGlobals {

// end namespace charinfo

/// Returns true if this is an ASCII character.
//<editor-fold defaultstate="collapsed" desc="clang::isASCII">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 43,
 FQN="clang::isASCII", NM="_ZN5clangL7isASCIIEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL7isASCIIEc")
//</editor-fold>
public static /*inline*/ boolean isASCII(/*char*/byte c)/* __attribute__((const))*/ {
  return $uchar2int(((/*static_cast*//*uchar*/byte)(c))) <= 127;
}
/// Returns true if this is an ASCII character.
//<editor-fold defaultstate="collapsed" desc="clang::isASCII">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 43,
 FQN="clang::isASCII", NM="_ZN5clangL7isASCIIEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL7isASCIIEc")
//</editor-fold>
public static /*inline*/ boolean isASCII(/*char*/char c)/* __attribute__((const))*/ {
  return c <= 127;
}


/// Returns true if this is a valid first character of a C identifier,
/// which is [a-zA-Z_].
//<editor-fold defaultstate="collapsed" desc="clang::isIdentifierHead">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 49,
 FQN="clang::isIdentifierHead", NM="_ZN5clangL16isIdentifierHeadEhb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL16isIdentifierHeadEhb")
//</editor-fold>
public static /*inline*/ boolean isIdentifierHead(/*uchar*/byte c)/* __attribute__((pure))*/ {
  return isIdentifierHead(c, 
                false);
}
public static /*inline*/ boolean isIdentifierHead(/*uchar*/byte c, 
                boolean AllowDollar/*= false*/)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  if ((($ushort2int(InfoTable[$uchar2int(c)]) & (CHAR_UPPER | CHAR_LOWER | CHAR_UNDER)) != 0)) {
    return true;
  }
  return AllowDollar && $uchar2int(c) == $$DOLLAR;
}
public static /*inline*/ boolean isIdentifierHead(/*uchar*/char c)/* __attribute__((pure))*/ {
  return isIdentifierHead(c, 
                false);
}
public static /*inline*/ boolean isIdentifierHead(/*uchar*/char c, 
                boolean AllowDollar/*= false*/)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  if ((($ushort2int(InfoTable[$uchar2int(c)]) & (CHAR_UPPER | CHAR_LOWER | CHAR_UNDER)) != 0)) {
    return true;
  }
  return AllowDollar && $uchar2int(c) == $$DOLLAR;
}


/// Returns true if this is a body character of a C identifier,
/// which is [a-zA-Z0-9_].
//<editor-fold defaultstate="collapsed" desc="clang::isIdentifierBody">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 59,
 FQN="clang::isIdentifierBody", NM="_ZN5clangL16isIdentifierBodyEhb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL16isIdentifierBodyEhb")
//</editor-fold>
public static /*inline*/ boolean isIdentifierBody(/*uchar*/byte c)/* __attribute__((pure))*/ {
  return isIdentifierBody(c, 
                false);
}
public static /*inline*/ boolean isIdentifierBody(/*uchar*/byte c, 
                boolean AllowDollar/*= false*/)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  if ((($ushort2int(InfoTable[$uchar2int(c)]) & (CHAR_UPPER | CHAR_LOWER | CHAR_DIGIT | CHAR_UNDER)) != 0)) {
    return true;
  }
  return AllowDollar && $uchar2int(c) == $$DOLLAR;
}
public static /*inline*/ boolean isIdentifierBody(/*uchar*/char c)/* __attribute__((pure))*/ {
  return isIdentifierBody(c, 
                false);
}
public static /*inline*/ boolean isIdentifierBody(/*uchar*/char c, 
                boolean AllowDollar/*= false*/)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  if ((($ushort2int(InfoTable[$uchar2int(c)]) & (CHAR_UPPER | CHAR_LOWER | CHAR_DIGIT | CHAR_UNDER)) != 0)) {
    return true;
  }
  return AllowDollar && $uchar2int(c) == $$DOLLAR;
}


/// Returns true if this character is horizontal ASCII whitespace:
/// ' ', '\\t', '\\f', '\\v'.
///
/// Note that this returns false for '\\0'.
//<editor-fold defaultstate="collapsed" desc="clang::isHorizontalWhitespace">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 71,
 FQN="clang::isHorizontalWhitespace", NM="_ZN5clangL22isHorizontalWhitespaceEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL22isHorizontalWhitespaceEh")
//</editor-fold>
public static /*inline*/ boolean isHorizontalWhitespace(/*uchar*/byte c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & (CHAR_HORZ_WS | CHAR_SPACE)) != 0;
}
public static /*inline*/ boolean isHorizontalWhitespace(/*uchar*/char c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & (CHAR_HORZ_WS | CHAR_SPACE)) != 0;
}


/// Returns true if this character is vertical ASCII whitespace: '\\n', '\\r'.
///
/// Note that this returns false for '\\0'.
//<editor-fold defaultstate="collapsed" desc="clang::isVerticalWhitespace">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 79,
 FQN="clang::isVerticalWhitespace", NM="_ZN5clangL20isVerticalWhitespaceEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL20isVerticalWhitespaceEh")
//</editor-fold>
public static /*inline*/ boolean isVerticalWhitespace(/*uchar*/byte c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & CHAR_VERT_WS) != 0;
}
public static /*inline*/ boolean isVerticalWhitespace(/*uchar*/char c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & CHAR_VERT_WS) != 0;
}


/// Return true if this character is horizontal or vertical ASCII whitespace:
/// ' ', '\\t', '\\f', '\\v', '\\n', '\\r'.
///
/// Note that this returns false for '\\0'.
//<editor-fold defaultstate="collapsed" desc="clang::isWhitespace">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 88,
 FQN="clang::isWhitespace", NM="_ZN5clangL12isWhitespaceEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL12isWhitespaceEh")
//</editor-fold>
public static /*inline*/ boolean isWhitespace(/*uchar*/byte c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & (CHAR_HORZ_WS | CHAR_VERT_WS | CHAR_SPACE)) != 0;
}
public static /*inline*/ boolean isWhitespace(/*uchar*/char c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & (CHAR_HORZ_WS | CHAR_VERT_WS | CHAR_SPACE)) != 0;
}


/// Return true if this character is an ASCII digit: [0-9]
//<editor-fold defaultstate="collapsed" desc="clang::isDigit">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 94,
 FQN="clang::isDigit", NM="_ZN5clangL7isDigitEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL7isDigitEh")
//</editor-fold>
public static /*inline*/ boolean isDigit(/*uchar*/byte c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & CHAR_DIGIT) != 0;
}
public static /*inline*/ boolean isDigit(/*uchar*/char c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & CHAR_DIGIT) != 0;
}


/// Return true if this character is a lowercase ASCII letter: [a-z]
//<editor-fold defaultstate="collapsed" desc="clang::isLowercase">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 100,
 FQN="clang::isLowercase", NM="_ZN5clangL11isLowercaseEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL11isLowercaseEh")
//</editor-fold>
public static /*inline*/ boolean isLowercase(/*uchar*/byte c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & CHAR_LOWER) != 0;
}
public static /*inline*/ boolean isLowercase(/*uchar*/char c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & CHAR_LOWER) != 0;
}


/// Return true if this character is an uppercase ASCII letter: [A-Z]
//<editor-fold defaultstate="collapsed" desc="clang::isUppercase">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 106,
 FQN="clang::isUppercase", NM="_ZN5clangL11isUppercaseEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL11isUppercaseEh")
//</editor-fold>
public static /*inline*/ boolean isUppercase(/*uchar*/byte c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & CHAR_UPPER) != 0;
}
public static /*inline*/ boolean isUppercase(/*uchar*/char c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & CHAR_UPPER) != 0;
}


/// Return true if this character is an ASCII letter: [a-zA-Z]
//<editor-fold defaultstate="collapsed" desc="clang::isLetter">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 112,
 FQN="clang::isLetter", NM="_ZN5clangL8isLetterEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL8isLetterEh")
//</editor-fold>
public static /*inline*/ boolean isLetter(/*uchar*/byte c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & (CHAR_UPPER | CHAR_LOWER)) != 0;
}
public static /*inline*/ boolean isLetter(/*uchar*/char c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & (CHAR_UPPER | CHAR_LOWER)) != 0;
}


/// Return true if this character is an ASCII letter or digit: [a-zA-Z0-9]
//<editor-fold defaultstate="collapsed" desc="clang::isAlphanumeric">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 118,
 FQN="clang::isAlphanumeric", NM="_ZN5clangL14isAlphanumericEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL14isAlphanumericEh")
//</editor-fold>
public static /*inline*/ boolean isAlphanumeric(/*uchar*/byte c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & (CHAR_DIGIT | CHAR_UPPER | CHAR_LOWER)) != 0;
}
public static /*inline*/ boolean isAlphanumeric(/*uchar*/char c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & (CHAR_DIGIT | CHAR_UPPER | CHAR_LOWER)) != 0;
}


/// Return true if this character is an ASCII hex digit: [0-9a-fA-F]
//<editor-fold defaultstate="collapsed" desc="clang::isHexDigit">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 124,
 FQN="clang::isHexDigit", NM="_ZN5clangL10isHexDigitEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL10isHexDigitEh")
//</editor-fold>
public static /*inline*/ boolean isHexDigit(/*uchar*/byte c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & (CHAR_DIGIT | CHAR_XLETTER)) != 0;
}
public static /*inline*/ boolean isHexDigit(/*uchar*/char c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & (CHAR_DIGIT | CHAR_XLETTER)) != 0;
}


/// Return true if this character is an ASCII punctuation character.
///
/// Note that '_' is both a punctuation character and an identifier character!
//<editor-fold defaultstate="collapsed" desc="clang::isPunctuation">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 132,
 FQN="clang::isPunctuation", NM="_ZN5clangL13isPunctuationEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL13isPunctuationEh")
//</editor-fold>
public static /*inline*/ boolean isPunctuation(/*uchar*/byte c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & (CHAR_UNDER | CHAR_PERIOD | CHAR_RAWDEL | CHAR_PUNCT)) != 0;
}
public static /*inline*/ boolean isPunctuation(/*uchar*/char c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & (CHAR_UNDER | CHAR_PERIOD | CHAR_RAWDEL | CHAR_PUNCT)) != 0;
}


/// Return true if this character is an ASCII printable character; that is, a
/// character that should take exactly one column to print in a fixed-width
/// terminal.
//<editor-fold defaultstate="collapsed" desc="clang::isPrintable">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 140,
 FQN="clang::isPrintable", NM="_ZN5clangL11isPrintableEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL11isPrintableEh")
//</editor-fold>
public static /*inline*/ boolean isPrintable(/*uchar*/byte c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & (CHAR_UPPER | CHAR_LOWER | CHAR_PERIOD | CHAR_PUNCT
     | CHAR_DIGIT | CHAR_UNDER | CHAR_RAWDEL | CHAR_SPACE)) != 0;
}
public static /*inline*/ boolean isPrintable(/*uchar*/char c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & (CHAR_UPPER | CHAR_LOWER | CHAR_PERIOD | CHAR_PUNCT
     | CHAR_DIGIT | CHAR_UNDER | CHAR_RAWDEL | CHAR_SPACE)) != 0;
}


/// Return true if this is the body character of a C preprocessing number,
/// which is [a-zA-Z0-9_.].
//<editor-fold defaultstate="collapsed" desc="clang::isPreprocessingNumberBody">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 148,
 FQN="clang::isPreprocessingNumberBody", NM="_ZN5clangL25isPreprocessingNumberBodyEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL25isPreprocessingNumberBodyEh")
//</editor-fold>
public static /*inline*/ boolean isPreprocessingNumberBody(/*uchar*/byte c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)])
     & (CHAR_UPPER | CHAR_LOWER | CHAR_DIGIT | CHAR_UNDER | CHAR_PERIOD)) != 0;
}
public static /*inline*/ boolean isPreprocessingNumberBody(/*uchar*/char c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)])
     & (CHAR_UPPER | CHAR_LOWER | CHAR_DIGIT | CHAR_UNDER | CHAR_PERIOD)) != 0;
}


/// Return true if this is the body character of a C++ raw string delimiter.
//<editor-fold defaultstate="collapsed" desc="clang::isRawStringDelimBody">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 155,
 FQN="clang::isRawStringDelimBody", NM="_ZN5clangL20isRawStringDelimBodyEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL20isRawStringDelimBodyEh")
//</editor-fold>
public static /*inline*/ boolean isRawStringDelimBody(/*uchar*/byte c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & (CHAR_UPPER | CHAR_LOWER | CHAR_PERIOD
     | CHAR_DIGIT | CHAR_UNDER | CHAR_RAWDEL)) != 0;
}
public static /*inline*/ boolean isRawStringDelimBody(/*uchar*/char c)/* __attribute__((pure))*/ {
  //JAVA: using namespace charinfo;
  return ($ushort2int(InfoTable[$uchar2int(c)]) & (CHAR_UPPER | CHAR_LOWER | CHAR_PERIOD
     | CHAR_DIGIT | CHAR_UNDER | CHAR_RAWDEL)) != 0;
}


/// Converts the given ASCII character to its lowercase equivalent.
///
/// If the character is not an uppercase character, it is returned as is.
//<editor-fold defaultstate="collapsed" desc="clang::toLowercase">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 165,
 FQN="clang::toLowercase", NM="_ZN5clangL11toLowercaseEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL11toLowercaseEc")
//</editor-fold>
public static /*inline*/ /*char*/byte toLowercase(/*char*/byte c)/* __attribute__((pure))*/ {
  if (isUppercase(c)) {
    return (/*char*/byte) (c + $$a - $$A);
  }
  return c;
}
public static /*inline*/ /*char*/byte toLowercase(/*char*/char c)/* __attribute__((pure))*/ {
  if (isUppercase(c)) {
    return (/*char*/byte) (c + $$a - $$A);
  }
  return (/*char*/byte)c;
}


/// Converts the given ASCII character to its uppercase equivalent.
///
/// If the character is not a lowercase character, it is returned as is.
//<editor-fold defaultstate="collapsed" desc="clang::toUppercase">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 174,
 FQN="clang::toUppercase", NM="_ZN5clangL11toUppercaseEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL11toUppercaseEc")
//</editor-fold>
public static /*inline*/ /*char*/byte toUppercase(/*char*/byte c)/* __attribute__((pure))*/ {
  if (isLowercase(c)) {
    return (/*char*/byte) (c + $$A - $$a);
  }
  return c;
}
public static /*inline*/ /*char*/byte toUppercase(/*char*/char c)/* __attribute__((pure))*/ {
  if (isLowercase(c)) {
    return (/*char*/byte) (c + $$A - $$a);
  }
  return (/*char*/byte)c;
}


/// Return true if this is a valid ASCII identifier.
///
/// Note that this is a very simple check; it does not accept '$' or UCNs as
/// valid identifier characters.
//<editor-fold defaultstate="collapsed" desc="clang::isValidIdentifier">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 185,
 FQN="clang::isValidIdentifier", NM="_ZN5clangL17isValidIdentifierEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL17isValidIdentifierEN4llvm9StringRefE")
//</editor-fold>
public static /*inline*/ boolean isValidIdentifier(StringRef S)/* __attribute__((pure))*/ {
  if (S.empty() || !isIdentifierHead(S.$at(0))) {
    return false;
  }
  
  for (char$ptr I = $tryClone(S.begin()), /*P*/ E = S.end(); $noteq_ptr(I, E); I.$preInc())  {
    if (!isIdentifierBody(I.$star())) {
      return false;
    }
  }
  
  return true;
}
public static /*inline*/ boolean isValidIdentifier(String S)/* __attribute__((pure))*/ {
  if (S.length() == 0 || !isIdentifierHead(S.charAt(0))) {
    return false;
  }
  
  for (int I = 1, E = S.length(); I != E; I++) {
    if (!isIdentifierBody(S.charAt(I))) {
      return false;
    }
  }  
  return true;
}

} // END OF class CharInfoClangGlobals
