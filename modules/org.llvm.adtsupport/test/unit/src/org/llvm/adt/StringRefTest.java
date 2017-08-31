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

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import org.clank.java.std;
import static org.clank.support.NativePointer.*;
import org.clank.support.NativeTrace;
import org.junit.Test;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
/**
 *
 * @author Vladimir Voskresensky
 */
public class StringRefTest extends ADTSupportTestBase {
  private final byte[] TEST_STR;
  private final StringRef TEST_STR_REF;
  {
    byte[] str = null;
    StringRef strRef = null;
    try {
      str = "check_this__text\0".getBytes("utf-8");
      strRef = new StringRef(create_char$ptr(str));
    } catch (UnsupportedEncodingException ex) {
      NativeTrace.printStackTraceOnce(ex, Level.SEVERE, false);
    }
    TEST_STR = str;
    assert NativeTrace.registerArrayWithImmutableContent(TEST_STR, "StringRefTest.TEST_STR");
    TEST_STR_REF = strRef;
  }
  
  
  @Test
  public void testFind() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    for (int i = 0; i < TEST_STR.length; i++) {
      long indexFromRef = TEST_STR_REF.find("__", i);
      long indexFromBytes = StringRef.find("__", TEST_STR, i, TEST_STR.length-i);
      ASSERT_TRUE(indexFromRef == indexFromBytes, "[" + i + "] Must be the same index " + indexFromBytes + " vs. " + indexFromRef);
    }
  }
  
  @Test 
  public void testToNullTerminatedStringRef() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String path = "/net/volvo/export/devarea/sputnik-trunk/modules/org.clang.lex/build/test/unit/work/PreprocessorPTHTest/test_include_pth_c_1/test_include_pth_c_1.tmp";
    checkConversion(path, true);
    checkConversion(path, false);
  }

  @Test 
  public void testFind_UChar() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    // #258316: ArrayIndexOutOfBoundsException: -2
    // problems with uchar values
    byte[] bytes = new byte[] {-1, -2, -3, 0};
    char$ptr bytesPtr = create_char$ptr(bytes);
    StringRef bytesStr = new StringRef(bytesPtr);
    int find_first_of_string = bytesStr.find_first_of("\n\015");
    ASSERT_EQ(StringRef.npos, find_first_of_string);
    int find_first_of = bytesStr.find_first_of(TEST_STR_REF);
    ASSERT_EQ(StringRef.npos, find_first_of);
    int find_first_not_of = bytesStr.find_first_not_of(TEST_STR_REF);
    ASSERT_EQ(0, find_first_not_of);
    int find_last_not_of = bytesStr.find_last_not_of(TEST_STR_REF);
    ASSERT_EQ(2, find_last_not_of);
    int find_last_of = bytesStr.find_last_of(TEST_STR_REF);
    ASSERT_EQ(StringRef.npos, find_last_of);
    int find_last_of_self = bytesStr.find_last_of(bytesStr);
    ASSERT_EQ(bytesStr.size()-1, find_last_of_self);
  }
  
  @Test
  public void testAppendEmptyToStdString() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.string buffer = new std.string();
    StringRef sRef = StringRef.R$EMPTY;
    $addassign_string_StringRef(buffer, sRef);
    $addassign_string_StringRef(buffer, sRef);
    EXPECT_EQ(std.string.EMPTY, buffer);
    buffer = new std.string();
    sRef = new StringRef();
    $addassign_string_StringRef(buffer, sRef);
    $addassign_string_StringRef(buffer, sRef);
    EXPECT_EQ(std.string.EMPTY, buffer);
    buffer = new std.string();
    sRef = new StringRef("");
    $addassign_string_StringRef(buffer, sRef);
    $addassign_string_StringRef(buffer, sRef);
    EXPECT_EQ(std.string.EMPTY, buffer);
  }
  
  @Test
  public void testAppendToStdString() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.string buffer = new std.string();
    $addassign_string_StringRef(buffer, StringRef.R$0);
    $addassign_string_StringRef(buffer, StringRef.R$1);
    EXPECT_EQ(new std.string("01"), buffer);
    buffer = new std.string();
    $addassign_string_StringRef(buffer, StringRef.R$DOT_DOT);
    $addassign_string_StringRef(buffer, StringRef.R$EMPTY);
    $addassign_string_StringRef(buffer, StringRef.R$DOT);
    EXPECT_EQ(new std.string("..."), buffer);
  }
  
  private void checkConversion(String path, boolean asUTF8) {
    char$ptr pathPtr = asUTF8 ? create_char$ptr_utf8(path) : create_char$ptr(path);
    std.string OutputFile = new std.string(pathPtr);
    ASSERT_EQ(OutputFile.size(), OutputFile.length());
    StringRef OutputPath = new StringRef(OutputFile);
    Twine TwinePath = new Twine(OutputPath);
    SmallString Buffer = new SmallString(128);
    StringRef P = TwinePath.toNullTerminatedStringRef(Buffer);
    String strResult = Native.$toString(P.begin());
    ASSERT_EQ(path, strResult);
  }
}
