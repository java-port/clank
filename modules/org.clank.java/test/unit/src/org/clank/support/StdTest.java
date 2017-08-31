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

package org.clank.support;

import java.io.UnsupportedEncodingException;
import org.clank.java.std;
import static org.clank.java.std.*;
import org.clank.support.JavaDifferentiators.JD$FAKE;
import static org.clank.support.Native.$toString;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import org.clank.support.aliases.*;
import org.junit.Assert;
import org.junit.Test;
/**
 *
 * @author Vladimir Voskresensky
 */
public class StdTest extends org.clank.java.JavaTestBase {

  public StdTest() {
  }
  
  @Test
  public void testReverse() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String STRING_1 = "1234567890";
    String REVERSED_1 = new StringBuilder(STRING_1).reverse().toString();
    EXPECT_EQ("0987654321", REVERSED_1);
    String STRING_2 = "abcde";
    String REVERSED_2 = new StringBuilder(STRING_2).reverse().toString();
    EXPECT_EQ("edcba", REVERSED_2);
    String strings[] = new String[] { 
      STRING_1, REVERSED_1, 
      STRING_2, REVERSED_2
    };
    for (int i = 0; i < strings.length; i+=2) {
      String STRING = strings[i];
      String REVERSED = strings[i+1];
      byte[] bytes = UTF_8.encode(STRING);
      char$ptr first = create_char$ptr(bytes);
      int StrLen = strlen(STRING);
      char$ptr last = first.$add(StrLen);
      std.reverse(first, last);
      EXPECT_EQ(REVERSED, Casts.toJavaString(first, StrLen));
      std.reverse((char$iterator)first, (char$iterator)last);
      EXPECT_EQ(STRING, Casts.toJavaString(first, StrLen));
    }
  }
  
  @Test
  public void testRotate() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String PREFIX = "First";
    String POSTFIX = "Last";
    String origin = PREFIX + POSTFIX;
    byte[] bytes = UTF_8.encode(origin);
    char$ptr first = create_char$ptr(bytes);
    char$ptr middle = first.$add(strlen(PREFIX));
    char$ptr last = first.$add(strlen(origin));
    std.rotate(first, middle, last);
    Assert.assertEquals($toString(first), POSTFIX + PREFIX);
  }
  
  @Test
  public void testUppberLowerBoounds() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    final Integer[] integers = new Integer[] { 10, 10, 10, 20, 20, 20, 30, 30};
    type$ptr<Integer> vals = create_type$ptr(integers);
    std.vector<Integer> ints = new std.vector(vals, vals.$add(integers.length), null);
    Native.ComparatorLower comparatorLower = new Native.ComparatorLower() {
      @Override
      public boolean $less(Object one, Object other) {
        long LHS = ((Number) one).longValue();
        long RHS = ((Number) other).longValue();
        return LHS < RHS;
      }
    };
    std.vector.iterator lower = std.lower_bound(ints.begin(), ints.end(), Integer.valueOf(20), comparatorLower);
    std.vector.iterator upper = std.upper_bound(ints.begin(), ints.end(), 20, comparatorLower);    
    type$iterator lower_bound = std.lower_bound(integers, Integer.valueOf(20), comparatorLower);
    Assert.assertEquals(6, upper.$sub(ints.begin()));
    Assert.assertEquals(3, lower.$sub(ints.begin()));
    int i = 10;
  }
  
  private static final long Value = 0x1234567890ABCDEFL;
  @Test
  public void testLongToBytes() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    checkLongToChar$Ptr(0, 4, 4, Value);
    checkLongToChar$Ptr(0, 0, 4, Value);    
    checkLongToChar$Ptr(0, 0, 8, Value);    
  }

  private void checkLongToChar$Ptr(int bufferStartIdx, int startIdx, int size, long Value) {
    char$ptr buffer = NativePointer.create_char$ptr(NativePointer.new$char(NativeType.BYTES_IN_LONG));
    copy_long_to_char$ptr(buffer, bufferStartIdx, Value, startIdx, size);
    String golden = Long.toHexString(Value).substring(startIdx*2, 2*(startIdx + size));
    StringBuilder out = new StringBuilder();
    for (int st = bufferStartIdx, end = bufferStartIdx+size; st < end; st++) {
      out.append(String.format("%x", buffer.$at(st)));
    }
    Assert.assertEquals(golden, out.toString());
  }
  
  @Test 
  public void testNativeLess() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    int I_10 = 10;
    int I_100 = 100;
    long L_10 = 10;
    long L_100 = 100;
    Assert.assertTrue(Native.$less(I_10, L_100));
    Assert.assertFalse(Native.$less(L_100, I_10));
    checkLessAsNumbers(L_10, L_100);
    checkLessAsNumbers(I_10, I_100);
    checkLessAsNumbers(I_10, L_100);
    checkLessAsNumbers(L_10, I_100);
  }
  
  @Test
  public void testSizeof() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    Assert.assertEquals(NativeType.BYTES_IN_INT, sizeof((int)1));
    Assert.assertEquals(1, sizeof$str(""));//one symbol \0
    Assert.assertEquals(sizeof$ptr(), sizeof($(""))); // pointer to string is Pointer
    Assert.assertEquals(sizeof$ptr(), sizeof(create_char$null$ptr()));
    
//    // we are trying to find who calls char$ptr$CharSequence.$sizeof
//    // so there should be exception printed in console
//    Assert.assertNull(NativeTrace.getFirstException());
//    char$ptr p2 = $("12345");
//    sizeof(p2);
//    Assert.assertNotNull(NativeTrace.getFirstException());    
//    NativeTrace.clearFirstException();
    
    Assert.assertEquals(sizeof$ptr(), sizeof(create_char$ptr_utf8("12345")));
    Assert.assertEquals(6, sizeof$str("12345"));
  }
  
  @Test 
  public void testCharPtrCmp() throws UnsupportedEncodingException {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String USR_INCLUDE = "/usr/include";
    String USR_INCLUDE_FREETYPE = USR_INCLUDE + "/freetype";
    byte[] bytes1 = (USR_INCLUDE + "\0").getBytes("UTF8");
    byte[] bytes2 = (USR_INCLUDE_FREETYPE + "\0").getBytes("UTF8");
    assert NativeTrace.registerArrayWithImmutableContent(bytes1, "testCharPtrCmp.bytes1");
    assert NativeTrace.registerArrayWithImmutableContent(bytes2, "testCharPtrCmp.bytes2");
    char$ptr ptr1 = NativePointer.create_char$ptr(bytes1, 0);
    char$ptr ptr2 = NativePointer.create_char$ptr(bytes2, 0);
    Assert.assertTrue(USR_INCLUDE + " vs. " + ptr1, std.memcmp_null_termed(USR_INCLUDE, 0, bytes1, 0, USR_INCLUDE.length()) == 0);
    Assert.assertTrue(USR_INCLUDE + " vs. " + ptr1, std.memcmp(bytes1, 0, USR_INCLUDE, USR_INCLUDE.length()) == 0);

    Assert.assertTrue(USR_INCLUDE + " vs. " + ptr2, std.memcmp_null_termed(USR_INCLUDE, 0, bytes2, 0, USR_INCLUDE.length()) < 0);
    Assert.assertTrue(USR_INCLUDE + " vs. " + ptr2, std.memcmp(bytes2, 0, USR_INCLUDE, USR_INCLUDE.length()) == 0);

    Assert.assertTrue(USR_INCLUDE_FREETYPE + " vs. " + ptr2, std.memcmp_null_termed(USR_INCLUDE_FREETYPE, 0, bytes2, 0, USR_INCLUDE_FREETYPE.length()) == 0);
    Assert.assertTrue(USR_INCLUDE_FREETYPE + " vs. " + ptr2, std.memcmp(bytes2, 0, USR_INCLUDE_FREETYPE, USR_INCLUDE_FREETYPE.length()) == 0);

    Assert.assertTrue(USR_INCLUDE_FREETYPE + " vs. " + ptr1, std.memcmp_null_termed(USR_INCLUDE_FREETYPE, 0, bytes1, 0, USR_INCLUDE_FREETYPE.length()) > 0);
    Assert.assertTrue(USR_INCLUDE_FREETYPE + " vs. " + ptr1, std.memcmp(bytes1, 0, USR_INCLUDE_FREETYPE, USR_INCLUDE_FREETYPE.length()) < 0);
    
    Assert.assertTrue(ptr1 + " vs. " + ptr2, std.memcmp(bytes1, 0, bytes2, 0, bytes1.length-1) == 0);
    Assert.assertTrue(ptr2 + " vs. " + ptr1, std.memcmp(bytes2, 0, bytes1, 0, bytes1.length-1) == 0);
    
    // check that substring of bytes1 is less than full bytes2
    Assert.assertTrue(ptr1 + " vs. " + ptr2, std.memcmp_null_termed(bytes1, 0, bytes2, 0, bytes1.length-1) < 0);
    // check is substring of bytes2 is equal to full bytes1
    Assert.assertTrue(USR_INCLUDE + " vs. " + ptr2, std.memcmp_null_termed(bytes2, 0, bytes1, 0, bytes1.length-1) == 0);
    
    // compare with empty strings
    byte[] nulls = new byte[] { $$TERM };
    Assert.assertTrue(USR_INCLUDE + " vs. " + ptr2, std.memcmp_null_termed("", 0, nulls, 0, 0) == 0);
    Assert.assertTrue(USR_INCLUDE + " vs. " + ptr2, std.memcmp_null_termed("", 0, bytes1, 0, 0) < 0);
    
    Assert.assertFalse("must be different " + ptr1 + " vs. " + ptr2, Native.$eq_ptr(ptr1, ptr2));
    Assert.assertFalse("must be different " + ptr2 + " vs. " + ptr1, Native.$eq_ptr(ptr2, ptr1));
    
    // check valid recognition of UTF Byte Order Mark (BOM)
    byte[] bytes = new byte[] {(byte)-1, (byte)-2, (byte)-1 };
    char$ptr bytes$ptr = create_char$ptr(bytes);
    Assert.assertTrue(std.memcmp(bytes$ptr,0,"\376\377\376", 1, 2) == 0);
    Assert.assertTrue(std.memcmp(bytes$ptr,1,"\376\377\376", 0, 2) == 0);
  }
  
  @Test public void testStdDistanceNullNull() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    Assert.assertEquals(0, std.distance((type$ptr)null, (type$ptr)null));
    Assert.assertEquals(0, std.distance((abstract_iterator)null, (abstract_iterator)null));
    Assert.assertEquals(0, std.distance((abstract_iterator)null, (abstract_iterator)null, JD$FAKE.TRAILING));
  }
  
  private void checkLessAsNumbers(Comparable LHS, Comparable RHS) {
    Assert.assertTrue(Native.$less(LHS, RHS));
    Assert.assertFalse(Native.$less(RHS, LHS));
  }
}
