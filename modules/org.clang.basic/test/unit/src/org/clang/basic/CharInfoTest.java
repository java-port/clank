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

package org.clang.basic;

import static org.clang.basic.charinfo.*;
import org.junit.Test;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import static org.clang.basic.BasicClangGlobals.*;

//<editor-fold defaultstate="collapsed" desc="static type CharInfoTest">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp -test=CharInfoTest")
//</editor-fold>
public final class CharInfoTest extends ADTSupportTestBase {

//JAVA: using namespace llvm
//JAVA: using namespace clang

// Check that the CharInfo table has been constructed reasonably.

@Test
//<editor-fold defaultstate="collapsed" desc="CharInfoTest_validateInfoTable_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp", line = 17,
 FQN="CharInfoTest_validateInfoTable_Test::TestBody", NM="_ZN35CharInfoTest_validateInfoTable_Test8TestBodyEv",
 cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp -nm=_ZN35CharInfoTest_validateInfoTable_Test8TestBodyEv")
//</editor-fold>
public void test_validateInfoTable() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    //JAVA: using namespace charinfo;
    EXPECT_EQ((/*uint*/int)CHAR_SPACE,InfoTable[(/*uint*/int)' ']);
    EXPECT_EQ((/*uint*/int)CHAR_HORZ_WS,InfoTable[(/*uint*/int)'\t']);
    EXPECT_EQ((/*uint*/int)CHAR_HORZ_WS,InfoTable[(/*uint*/int)'\f']);
    // ??
    EXPECT_EQ((/*uint*/int)CHAR_HORZ_WS,InfoTable[(/*uint*/int)'\013'/*\v*/]);
    // ??
    EXPECT_EQ((/*uint*/int)CHAR_VERT_WS,InfoTable[(/*uint*/int)'\n']);
    EXPECT_EQ((/*uint*/int)CHAR_VERT_WS,InfoTable[(/*uint*/int)'\r']);
    EXPECT_EQ((/*uint*/int)CHAR_UNDER,InfoTable[(/*uint*/int)'_']);
    EXPECT_EQ((/*uint*/int)CHAR_PERIOD,InfoTable[(/*uint*/int)'.']);
    
    for (/*uint*/int i = $$a; $lesseq_uint(i, $$f); ++i) {
    EXPECT_EQ((/*uint*/int)CHAR_XLOWER,InfoTable[i]);
    EXPECT_EQ((/*uint*/int)CHAR_XUPPER,InfoTable[i + 'A' - 'a']);
    }
    
    for (/*uint*/int i = $$g; $lesseq_uint(i, $$z); ++i) {
    EXPECT_EQ((/*uint*/int)CHAR_LOWER,InfoTable[i]);
    EXPECT_EQ((/*uint*/int)CHAR_UPPER,InfoTable[i + 'A' - 'a']);
    }
    
    for (/*uint*/int i = $$0; $lesseq_uint(i, $$9); ++i)  {
    EXPECT_EQ((/*uint*/int)CHAR_DIGIT,InfoTable[i]);
    }
  } finally {
    $c$.$destroy();
  }
}


// Check various predicates.

@Test
//<editor-fold defaultstate="collapsed" desc="CharInfoTest_isASCII_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp", line = 43,
 FQN="CharInfoTest_isASCII_Test::TestBody", NM="_ZN25CharInfoTest_isASCII_Test8TestBodyEv",
 cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp -nm=_ZN25CharInfoTest_isASCII_Test8TestBodyEv")
//</editor-fold>
public void test_isASCII() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_TRUE(isASCII('\0'));
    EXPECT_TRUE(isASCII('\n'));
    EXPECT_TRUE(isASCII(' '));
    EXPECT_TRUE(isASCII('a'));
    EXPECT_TRUE(isASCII(((char)0x7f)));
    EXPECT_FALSE(isASCII(((char)0x80)));
    EXPECT_FALSE(isASCII(((char)0xc2)));
    EXPECT_FALSE(isASCII(((char)0xff)));
}


@Test
//<editor-fold defaultstate="collapsed" desc="CharInfoTest_isIdentifierHead_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp", line = 54,
 FQN="CharInfoTest_isIdentifierHead_Test::TestBody", NM="_ZN34CharInfoTest_isIdentifierHead_Test8TestBodyEv",
 cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp -nm=_ZN34CharInfoTest_isIdentifierHead_Test8TestBodyEv")
//</editor-fold>
public void test_isIdentifierHead() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_TRUE(isIdentifierHead('a'));
    EXPECT_TRUE(isIdentifierHead('A'));
    EXPECT_TRUE(isIdentifierHead('z'));
    EXPECT_TRUE(isIdentifierHead('Z'));
    EXPECT_TRUE(isIdentifierHead('_'));
    EXPECT_FALSE(isIdentifierHead('0'));
    EXPECT_FALSE(isIdentifierHead('.'));
    EXPECT_FALSE(isIdentifierHead('`'));
    EXPECT_FALSE(isIdentifierHead('\0'));
    EXPECT_FALSE(isIdentifierHead('$'));
    EXPECT_TRUE(isIdentifierHead('$', true));
    EXPECT_FALSE(isIdentifierHead(((char)0x80)));
    EXPECT_FALSE(isIdentifierHead(((char)0xc2)));
    EXPECT_FALSE(isIdentifierHead(((char)0xff)));
}


@Test
//<editor-fold defaultstate="collapsed" desc="CharInfoTest_isIdentifierBody_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp", line = 74,
 FQN="CharInfoTest_isIdentifierBody_Test::TestBody", NM="_ZN34CharInfoTest_isIdentifierBody_Test8TestBodyEv",
 cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp -nm=_ZN34CharInfoTest_isIdentifierBody_Test8TestBodyEv")
//</editor-fold>
public void test_isIdentifierBody() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_TRUE(isIdentifierBody('a'));
    EXPECT_TRUE(isIdentifierBody('A'));
    EXPECT_TRUE(isIdentifierBody('z'));
    EXPECT_TRUE(isIdentifierBody('Z'));
    EXPECT_TRUE(isIdentifierBody('_'));
    EXPECT_TRUE(isIdentifierBody('0'));
    EXPECT_FALSE(isIdentifierBody('.'));
    EXPECT_FALSE(isIdentifierBody('`'));
    EXPECT_FALSE(isIdentifierBody('\0'));
    EXPECT_FALSE(isIdentifierBody('$'));
    EXPECT_TRUE(isIdentifierBody('$', true));
    EXPECT_FALSE(isIdentifierBody(((char)0x80)));
    EXPECT_FALSE(isIdentifierBody(((char)0xc2)));
    EXPECT_FALSE(isIdentifierBody(((char)0xff)));
}


@Test
//<editor-fold defaultstate="collapsed" desc="CharInfoTest_isHorizontalWhitespace_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp", line = 94,
 FQN="CharInfoTest_isHorizontalWhitespace_Test::TestBody", NM="_ZN40CharInfoTest_isHorizontalWhitespace_Test8TestBodyEv",
 cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp -nm=_ZN40CharInfoTest_isHorizontalWhitespace_Test8TestBodyEv")
//</editor-fold>
public void test_isHorizontalWhitespace() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_FALSE(isHorizontalWhitespace('a'));
    EXPECT_FALSE(isHorizontalWhitespace('_'));
    EXPECT_FALSE(isHorizontalWhitespace('0'));
    EXPECT_FALSE(isHorizontalWhitespace('.'));
    EXPECT_FALSE(isHorizontalWhitespace('`'));
    EXPECT_FALSE(isHorizontalWhitespace('\0'));
    EXPECT_FALSE(isHorizontalWhitespace(((char)0x7f)));
    EXPECT_TRUE(isHorizontalWhitespace(' '));
    EXPECT_TRUE(isHorizontalWhitespace('\t'));
    EXPECT_TRUE(isHorizontalWhitespace('\f'));
    // ??
    EXPECT_TRUE(isHorizontalWhitespace('\013'/*\v*/));
    // ??
    EXPECT_FALSE(isHorizontalWhitespace('\n'));
    EXPECT_FALSE(isHorizontalWhitespace('\r'));
    EXPECT_FALSE(isHorizontalWhitespace(((char)0x80)));
    EXPECT_FALSE(isHorizontalWhitespace(((char)0xc2)));
    EXPECT_FALSE(isHorizontalWhitespace(((char)0xff)));
}


@Test
//<editor-fold defaultstate="collapsed" desc="CharInfoTest_isVerticalWhitespace_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp", line = 116,
 FQN="CharInfoTest_isVerticalWhitespace_Test::TestBody", NM="_ZN38CharInfoTest_isVerticalWhitespace_Test8TestBodyEv",
 cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp -nm=_ZN38CharInfoTest_isVerticalWhitespace_Test8TestBodyEv")
//</editor-fold>
public void test_isVerticalWhitespace() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_FALSE(isVerticalWhitespace('a'));
    EXPECT_FALSE(isVerticalWhitespace('_'));
    EXPECT_FALSE(isVerticalWhitespace('0'));
    EXPECT_FALSE(isVerticalWhitespace('.'));
    EXPECT_FALSE(isVerticalWhitespace('`'));
    EXPECT_FALSE(isVerticalWhitespace('\0'));
    EXPECT_FALSE(isVerticalWhitespace(((char)0x7f)));
    EXPECT_FALSE(isVerticalWhitespace(' '));
    EXPECT_FALSE(isVerticalWhitespace('\t'));
    EXPECT_FALSE(isVerticalWhitespace('\f'));
    // ??
    EXPECT_FALSE(isVerticalWhitespace('\013'/*\v*/));
    // ??
    EXPECT_TRUE(isVerticalWhitespace('\n'));
    EXPECT_TRUE(isVerticalWhitespace('\r'));
    EXPECT_FALSE(isVerticalWhitespace(((char)0x80)));
    EXPECT_FALSE(isVerticalWhitespace(((char)0xc2)));
    EXPECT_FALSE(isVerticalWhitespace(((char)0xff)));
}


@Test
//<editor-fold defaultstate="collapsed" desc="CharInfoTest_isWhitespace_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp", line = 138,
 FQN="CharInfoTest_isWhitespace_Test::TestBody", NM="_ZN30CharInfoTest_isWhitespace_Test8TestBodyEv",
 cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp -nm=_ZN30CharInfoTest_isWhitespace_Test8TestBodyEv")
//</editor-fold>
public void test_isWhitespace() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_FALSE(isWhitespace('a'));
    EXPECT_FALSE(isWhitespace('_'));
    EXPECT_FALSE(isWhitespace('0'));
    EXPECT_FALSE(isWhitespace('.'));
    EXPECT_FALSE(isWhitespace('`'));
    EXPECT_FALSE(isWhitespace('\0'));
    EXPECT_FALSE(isWhitespace(((char)0x7f)));
    EXPECT_TRUE(isWhitespace(' '));
    EXPECT_TRUE(isWhitespace('\t'));
    EXPECT_TRUE(isWhitespace('\f'));
    EXPECT_TRUE(isWhitespace('\013'/*\v*/));
    EXPECT_TRUE(isWhitespace('\n'));
    EXPECT_TRUE(isWhitespace('\r'));
    EXPECT_FALSE(isWhitespace(((char)0x80)));
    EXPECT_FALSE(isWhitespace(((char)0xc2)));
    EXPECT_FALSE(isWhitespace(((char)0xff)));
}


@Test
//<editor-fold defaultstate="collapsed" desc="CharInfoTest_isDigit_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp", line = 160,
 FQN="CharInfoTest_isDigit_Test::TestBody", NM="_ZN25CharInfoTest_isDigit_Test8TestBodyEv",
 cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp -nm=_ZN25CharInfoTest_isDigit_Test8TestBodyEv")
//</editor-fold>
public void test_isDigit() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_TRUE(isDigit('0'));
    EXPECT_TRUE(isDigit('9'));
    EXPECT_FALSE(isDigit('a'));
    EXPECT_FALSE(isDigit('A'));
    EXPECT_FALSE(isDigit('z'));
    EXPECT_FALSE(isDigit('Z'));
    EXPECT_FALSE(isDigit('.'));
    EXPECT_FALSE(isDigit('_'));
    EXPECT_FALSE(isDigit('/'));
    EXPECT_FALSE(isDigit('\0'));
    EXPECT_FALSE(isDigit(((char)0x80)));
    EXPECT_FALSE(isDigit(((char)0xc2)));
    EXPECT_FALSE(isDigit(((char)0xff)));
}


@Test
//<editor-fold defaultstate="collapsed" desc="CharInfoTest_isHexDigit_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp", line = 181,
 FQN="CharInfoTest_isHexDigit_Test::TestBody", NM="_ZN28CharInfoTest_isHexDigit_Test8TestBodyEv",
 cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp -nm=_ZN28CharInfoTest_isHexDigit_Test8TestBodyEv")
//</editor-fold>
public void test_isHexDigit() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_TRUE(isHexDigit('0'));
    EXPECT_TRUE(isHexDigit('9'));
    EXPECT_TRUE(isHexDigit('a'));
    EXPECT_TRUE(isHexDigit('A'));
    EXPECT_FALSE(isHexDigit('z'));
    EXPECT_FALSE(isHexDigit('Z'));
    EXPECT_FALSE(isHexDigit('.'));
    EXPECT_FALSE(isHexDigit('_'));
    EXPECT_FALSE(isHexDigit('/'));
    EXPECT_FALSE(isHexDigit('\0'));
    EXPECT_FALSE(isHexDigit(((char)0x80)));
    EXPECT_FALSE(isHexDigit(((char)0xc2)));
    EXPECT_FALSE(isHexDigit(((char)0xff)));
}


@Test
//<editor-fold defaultstate="collapsed" desc="CharInfoTest_isLetter_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp", line = 202,
 FQN="CharInfoTest_isLetter_Test::TestBody", NM="_ZN26CharInfoTest_isLetter_Test8TestBodyEv",
 cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp -nm=_ZN26CharInfoTest_isLetter_Test8TestBodyEv")
//</editor-fold>
public void test_isLetter() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_FALSE(isLetter('0'));
    EXPECT_FALSE(isLetter('9'));
    EXPECT_TRUE(isLetter('a'));
    EXPECT_TRUE(isLetter('A'));
    EXPECT_TRUE(isLetter('z'));
    EXPECT_TRUE(isLetter('Z'));
    EXPECT_FALSE(isLetter('.'));
    EXPECT_FALSE(isLetter('_'));
    EXPECT_FALSE(isLetter('/'));
    EXPECT_FALSE(isLetter('('));
    EXPECT_FALSE(isLetter('\0'));
    EXPECT_FALSE(isLetter(((char)0x80)));
    EXPECT_FALSE(isLetter(((char)0xc2)));
    EXPECT_FALSE(isLetter(((char)0xff)));
}


@Test
//<editor-fold defaultstate="collapsed" desc="CharInfoTest_isLowercase_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp", line = 224,
 FQN="CharInfoTest_isLowercase_Test::TestBody", NM="_ZN29CharInfoTest_isLowercase_Test8TestBodyEv",
 cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp -nm=_ZN29CharInfoTest_isLowercase_Test8TestBodyEv")
//</editor-fold>
public void test_isLowercase() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_FALSE(isLowercase('0'));
    EXPECT_FALSE(isLowercase('9'));
    EXPECT_TRUE(isLowercase('a'));
    EXPECT_FALSE(isLowercase('A'));
    EXPECT_TRUE(isLowercase('z'));
    EXPECT_FALSE(isLowercase('Z'));
    EXPECT_FALSE(isLowercase('.'));
    EXPECT_FALSE(isLowercase('_'));
    EXPECT_FALSE(isLowercase('/'));
    EXPECT_FALSE(isLowercase('('));
    EXPECT_FALSE(isLowercase('\0'));
    EXPECT_FALSE(isLowercase(((char)0x80)));
    EXPECT_FALSE(isLowercase(((char)0xc2)));
    EXPECT_FALSE(isLowercase(((char)0xff)));
}


@Test
//<editor-fold defaultstate="collapsed" desc="CharInfoTest_isUppercase_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp", line = 246,
 FQN="CharInfoTest_isUppercase_Test::TestBody", NM="_ZN29CharInfoTest_isUppercase_Test8TestBodyEv",
 cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp -nm=_ZN29CharInfoTest_isUppercase_Test8TestBodyEv")
//</editor-fold>
public void test_isUppercase() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_FALSE(isUppercase('0'));
    EXPECT_FALSE(isUppercase('9'));
    EXPECT_FALSE(isUppercase('a'));
    EXPECT_TRUE(isUppercase('A'));
    EXPECT_FALSE(isUppercase('z'));
    EXPECT_TRUE(isUppercase('Z'));
    EXPECT_FALSE(isUppercase('.'));
    EXPECT_FALSE(isUppercase('_'));
    EXPECT_FALSE(isUppercase('/'));
    EXPECT_FALSE(isUppercase('('));
    EXPECT_FALSE(isUppercase('\0'));
    EXPECT_FALSE(isUppercase(((char)0x80)));
    EXPECT_FALSE(isUppercase(((char)0xc2)));
    EXPECT_FALSE(isUppercase(((char)0xff)));
}


@Test
//<editor-fold defaultstate="collapsed" desc="CharInfoTest_isAlphanumeric_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp", line = 268,
 FQN="CharInfoTest_isAlphanumeric_Test::TestBody", NM="_ZN32CharInfoTest_isAlphanumeric_Test8TestBodyEv",
 cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp -nm=_ZN32CharInfoTest_isAlphanumeric_Test8TestBodyEv")
//</editor-fold>
public void test_isAlphanumeric() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_TRUE(isAlphanumeric('0'));
    EXPECT_TRUE(isAlphanumeric('9'));
    EXPECT_TRUE(isAlphanumeric('a'));
    EXPECT_TRUE(isAlphanumeric('A'));
    EXPECT_TRUE(isAlphanumeric('z'));
    EXPECT_TRUE(isAlphanumeric('Z'));
    EXPECT_FALSE(isAlphanumeric('.'));
    EXPECT_FALSE(isAlphanumeric('_'));
    EXPECT_FALSE(isAlphanumeric('/'));
    EXPECT_FALSE(isAlphanumeric('('));
    EXPECT_FALSE(isAlphanumeric('\0'));
    EXPECT_FALSE(isAlphanumeric(((char)0x80)));
    EXPECT_FALSE(isAlphanumeric(((char)0xc2)));
    EXPECT_FALSE(isAlphanumeric(((char)0xff)));
}


@Test
//<editor-fold defaultstate="collapsed" desc="CharInfoTest_isPunctuation_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp", line = 290,
 FQN="CharInfoTest_isPunctuation_Test::TestBody", NM="_ZN31CharInfoTest_isPunctuation_Test8TestBodyEv",
 cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp -nm=_ZN31CharInfoTest_isPunctuation_Test8TestBodyEv")
//</editor-fold>
public void test_isPunctuation() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_FALSE(isPunctuation('0'));
    EXPECT_FALSE(isPunctuation('9'));
    EXPECT_FALSE(isPunctuation('a'));
    EXPECT_FALSE(isPunctuation('A'));
    EXPECT_FALSE(isPunctuation('z'));
    EXPECT_FALSE(isPunctuation('Z'));
    EXPECT_TRUE(isPunctuation('.'));
    EXPECT_TRUE(isPunctuation('_'));
    EXPECT_TRUE(isPunctuation('/'));
    EXPECT_TRUE(isPunctuation('('));
    EXPECT_FALSE(isPunctuation(' '));
    EXPECT_FALSE(isPunctuation('\n'));
    EXPECT_FALSE(isPunctuation('\0'));
    EXPECT_FALSE(isPunctuation(((char)0x80)));
    EXPECT_FALSE(isPunctuation(((char)0xc2)));
    EXPECT_FALSE(isPunctuation(((char)0xff)));
}


@Test
//<editor-fold defaultstate="collapsed" desc="CharInfoTest_isPrintable_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp", line = 315,
 FQN="CharInfoTest_isPrintable_Test::TestBody", NM="_ZN29CharInfoTest_isPrintable_Test8TestBodyEv",
 cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp -nm=_ZN29CharInfoTest_isPrintable_Test8TestBodyEv")
//</editor-fold>
public void test_isPrintable() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_TRUE(isPrintable('0'));
    EXPECT_TRUE(isPrintable('9'));
    EXPECT_TRUE(isPrintable('a'));
    EXPECT_TRUE(isPrintable('A'));
    EXPECT_TRUE(isPrintable('z'));
    EXPECT_TRUE(isPrintable('Z'));
    EXPECT_TRUE(isPrintable('.'));
    EXPECT_TRUE(isPrintable('_'));
    EXPECT_TRUE(isPrintable('/'));
    EXPECT_TRUE(isPrintable('('));
    EXPECT_TRUE(isPrintable(' '));
    EXPECT_FALSE(isPrintable('\t'));
    EXPECT_FALSE(isPrintable('\n'));
    EXPECT_FALSE(isPrintable('\0'));
    EXPECT_FALSE(isPrintable(((char)0x80)));
    EXPECT_FALSE(isPrintable(((char)0xc2)));
    EXPECT_FALSE(isPrintable(((char)0xff)));
}


@Test
//<editor-fold defaultstate="collapsed" desc="CharInfoTest_isPreprocessingNumberBody_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp", line = 341,
 FQN="CharInfoTest_isPreprocessingNumberBody_Test::TestBody", NM="_ZN43CharInfoTest_isPreprocessingNumberBody_Test8TestBodyEv",
 cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp -nm=_ZN43CharInfoTest_isPreprocessingNumberBody_Test8TestBodyEv")
//</editor-fold>
public void test_isPreprocessingNumberBody() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_TRUE(isPreprocessingNumberBody('0'));
    EXPECT_TRUE(isPreprocessingNumberBody('9'));
    EXPECT_TRUE(isPreprocessingNumberBody('a'));
    EXPECT_TRUE(isPreprocessingNumberBody('A'));
    EXPECT_TRUE(isPreprocessingNumberBody('z'));
    EXPECT_TRUE(isPreprocessingNumberBody('Z'));
    EXPECT_TRUE(isPreprocessingNumberBody('.'));
    EXPECT_TRUE(isPreprocessingNumberBody('_'));
    EXPECT_FALSE(isPreprocessingNumberBody('/'));
    EXPECT_FALSE(isPreprocessingNumberBody('('));
    EXPECT_FALSE(isPreprocessingNumberBody('\0'));
    EXPECT_FALSE(isPreprocessingNumberBody(((char)0x80)));
    EXPECT_FALSE(isPreprocessingNumberBody(((char)0xc2)));
    EXPECT_FALSE(isPreprocessingNumberBody(((char)0xff)));
}


@Test
//<editor-fold defaultstate="collapsed" desc="CharInfoTest_isRawStringDelimBody_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp", line = 362,
 FQN="CharInfoTest_isRawStringDelimBody_Test::TestBody", NM="_ZN38CharInfoTest_isRawStringDelimBody_Test8TestBodyEv",
 cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp -nm=_ZN38CharInfoTest_isRawStringDelimBody_Test8TestBodyEv")
//</editor-fold>
public void test_isRawStringDelimBody() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_TRUE(isRawStringDelimBody('0'));
    EXPECT_TRUE(isRawStringDelimBody('9'));
    EXPECT_TRUE(isRawStringDelimBody('a'));
    EXPECT_TRUE(isRawStringDelimBody('A'));
    EXPECT_TRUE(isRawStringDelimBody('z'));
    EXPECT_TRUE(isRawStringDelimBody('Z'));
    EXPECT_TRUE(isRawStringDelimBody('.'));
    EXPECT_TRUE(isRawStringDelimBody('_'));
    EXPECT_TRUE(isRawStringDelimBody('/'));
    EXPECT_FALSE(isRawStringDelimBody('('));
    EXPECT_FALSE(isRawStringDelimBody('\0'));
    EXPECT_FALSE(isRawStringDelimBody(((char)0x80)));
    EXPECT_FALSE(isRawStringDelimBody(((char)0xc2)));
    EXPECT_FALSE(isRawStringDelimBody(((char)0xff)));
}


@Test
//<editor-fold defaultstate="collapsed" desc="CharInfoTest_toLowercase_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp", line = 383,
 FQN="CharInfoTest_toLowercase_Test::TestBody", NM="_ZN29CharInfoTest_toLowercase_Test8TestBodyEv",
 cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp -nm=_ZN29CharInfoTest_toLowercase_Test8TestBodyEv")
//</editor-fold>
public void test_toLowercase() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ('0',toLowercase('0'));
    EXPECT_EQ('9',toLowercase('9'));
    EXPECT_EQ('a',toLowercase('a'));
    EXPECT_EQ('a',toLowercase('A'));
    EXPECT_EQ('z',toLowercase('z'));
    EXPECT_EQ('z',toLowercase('Z'));
    EXPECT_EQ('.',toLowercase('.'));
    EXPECT_EQ('_',toLowercase('_'));
    EXPECT_EQ('/',toLowercase('/'));
    EXPECT_EQ('\0',toLowercase('\0'));
  } finally {
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="CharInfoTest_toUppercase_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp", line = 400,
 FQN="CharInfoTest_toUppercase_Test::TestBody", NM="_ZN29CharInfoTest_toUppercase_Test8TestBodyEv",
 cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp -nm=_ZN29CharInfoTest_toUppercase_Test8TestBodyEv")
//</editor-fold>
public void test_toUppercase() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ('0',toUppercase('0'));
    EXPECT_EQ('9',toUppercase('9'));
    EXPECT_EQ('A',toUppercase('a'));
    EXPECT_EQ('A',toUppercase('A'));
    EXPECT_EQ('Z',toUppercase('z'));
    EXPECT_EQ('Z',toUppercase('Z'));
    EXPECT_EQ('.',toUppercase('.'));
    EXPECT_EQ('_',toUppercase('_'));
    EXPECT_EQ('/',toUppercase('/'));
    EXPECT_EQ('\0',toUppercase('\0'));
  } finally {
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="CharInfoTest_isValidIdentifier_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp", line = 417,
 FQN="CharInfoTest_isValidIdentifier_Test::TestBody", NM="_ZN35CharInfoTest_isValidIdentifier_Test8TestBodyEv",
 cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/CharInfoTest.cpp -nm=_ZN35CharInfoTest_isValidIdentifier_Test8TestBodyEv")
//</editor-fold>
public void test_isValidIdentifier() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/""));
    
    // 1 character
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"."));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"\n"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/" "));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"\200"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"\302"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"\377"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"$"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"1"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"_"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"a"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"z"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"A"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"Z"));
    
    // 2 characters, '_' suffix
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"._"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"\n_"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/" _"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"\200_"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"\302_"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"\377_"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"$_"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"1_"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"__"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"a_"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"z_"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"A_"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"Z_"));
    
    // 2 characters, '_' prefix
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"_."));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"_\n"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"_ "));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"_\200"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"_\302"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"_\377"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"_$"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"_1"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"__"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"_a"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"_z"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"_A"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"_Z"));
    
    // 3 characters, '__' prefix
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"__."));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"__\n"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"__ "));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"__\200"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"__\302"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"__\377"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"__$"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"__1"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"___"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"__a"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"__z"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"__A"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"__Z"));
    
    // 3 characters, '_' prefix and suffix
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"_._"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"_\n_"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"_ _"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"_\200_"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"_\302_"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"_\377_"));
    EXPECT_FALSE(isValidIdentifier(/*STRINGREF_STR*/"_$_"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"_1_"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"___"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"_a_"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"_z_"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"_A_"));
    EXPECT_TRUE(isValidIdentifier(/*STRINGREF_STR*/"_Z_"));
}

} // END OF class CharInfoTest
