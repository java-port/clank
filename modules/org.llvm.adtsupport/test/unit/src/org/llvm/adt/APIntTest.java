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

import org.clank.java.std;
import static org.clank.java.std_defines.UINT32_MAX;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.junit.*;
import org.llvm.adt.aliases.ArrayRefULong;
import static org.llvm.support.llvm.integerPartWidth;

/**
 *
 * @author Vladimir Voskresensky
 */
//<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::LexerTest::CheckLex">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/unittests/ADT/APIntTest.cpp", line = 20,
 cmd = "jclank.sh --test -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/APIntTest.cpp -filter=(anonymous namespace)::APIntTest")
//</editor-fold>
public class APIntTest extends ADTSupportTestBase {
  @Test
 public void SignedUnsignedToString() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    APSInt Val = new APSInt(64);
    Val.$assign(-1L);
    std.string Signed = Val.__toString(10, true);
    std.string UnSigned = Val.__toString(10, false);
    ASSERT_EQ("-1", Signed);
    ASSERT_EQ("18446744073709551615", UnSigned);
  }
  
  @Test
 public void NoOverflowForBigUnsignLong() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    // check no overflow when try to construct 18446744073709551615 = 1844674407370955161 * 10 + 5
    
    APSInt Val = new APSInt(64);
    Val.$assign(1844674407370955161L);
    
    int radix = 10;
    APInt RadixVal/*J*/= new APInt(Val.getBitWidth(), radix);
    APInt CharVal/*J*/= new APInt(Val.getBitWidth(), 0);
    APInt OldVal = new APInt(Val);
    boolean OverflowOccurred = false;
    
    // Add the digit to the value in the appropriate radix.  If adding in digits
    // made the value smaller, then this overflowed.

    CharVal.$assign(5);

    OldVal.$assign(Val);

    // Multiply by radix, did overflow occur on the multiply?
    Val.$starassign(RadixVal);
    OverflowOccurred |= Val.udiv(RadixVal).$noteq(OldVal);

    // Add value, did overflow occur on the value?
    //   (a + b) ult b  <=> overflow
    Val.$addassign(CharVal);
    OverflowOccurred |= Val.ult(CharVal);
    
    ASSERT_FALSE(OverflowOccurred, "This overflow must not happen");
  }
  
  // Test that APInt shift left works when bitwidth > 64 and shiftamt == 0
  @Test
  public void ShiftLeftByZero() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    APInt One = APInt.getNullValue(65).$add(1);
    APInt Shl = One.shl(0);
    EXPECT_TRUE(Shl.$at(0));
    EXPECT_FALSE(Shl.$at(1));
  }

  @Test
  public void i128_NegativeCount() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    APInt Minus3 = new APInt(JD$UInt_ULong.INSTANCE, 128, -3, true);
    EXPECT_EQ(126, Minus3.countLeadingOnes());
    EXPECT_EQ(-3l, Minus3.getSExtValue());

    APInt Minus1 = new APInt(JD$UInt_ULong.INSTANCE, 128, -1, true);
    EXPECT_EQ(0, Minus1.countLeadingZeros());
    EXPECT_EQ(128, Minus1.countLeadingOnes());
    EXPECT_EQ(128, Minus1.getActiveBits());
    EXPECT_EQ(0, Minus1.countTrailingZeros());
    EXPECT_EQ(128, Minus1.countTrailingOnes());
    EXPECT_EQ(128, Minus1.countPopulation());
    EXPECT_EQ(-1l, Minus1.getSExtValue());
  }

  @Test
  public void i33_Count() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    APInt i33minus2 = new APInt(JD$UInt_ULong.INSTANCE, 33, -2, true);
    EXPECT_EQ(0, i33minus2.countLeadingZeros());
    EXPECT_EQ(32, i33minus2.countLeadingOnes());
    EXPECT_EQ(33, i33minus2.getActiveBits());
    EXPECT_EQ(1, i33minus2.countTrailingZeros());
    EXPECT_EQ(32, i33minus2.countPopulation());
    EXPECT_EQ(-2l, i33minus2.getSExtValue());
    EXPECT_EQ((-2l)&((1l << 33) -1), i33minus2.getZExtValue());
  }

  @Test
  public void i65_Count() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    APInt i65 = new APInt(JD$UInt_ULong.INSTANCE, 65, 0, true);
    EXPECT_EQ(65, i65.countLeadingZeros());
    EXPECT_EQ(0, i65.countLeadingOnes());
    EXPECT_EQ(0, i65.getActiveBits());
    EXPECT_EQ(1, i65.getActiveWords());
    EXPECT_EQ(65, i65.countTrailingZeros());
    EXPECT_EQ(0, i65.countPopulation());

    APInt i65minus = new APInt(JD$UInt_ULong.INSTANCE, 65, 0, true);
    i65minus.setBit(64);
    EXPECT_EQ(0, i65minus.countLeadingZeros());
    EXPECT_EQ(1, i65minus.countLeadingOnes());
    EXPECT_EQ(65, i65minus.getActiveBits());
    EXPECT_EQ(64, i65minus.countTrailingZeros());
    EXPECT_EQ(1, i65minus.countPopulation());
  }

  @Test
  public void i128_PositiveCount() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    APInt u128max = APInt.getAllOnesValue(128);
    EXPECT_EQ(128, u128max.countLeadingOnes());
    EXPECT_EQ(0, u128max.countLeadingZeros());
    EXPECT_EQ(128, u128max.getActiveBits());
    EXPECT_EQ(0, u128max.countTrailingZeros());
    EXPECT_EQ(128, u128max.countTrailingOnes());
    EXPECT_EQ(128, u128max.countPopulation());

    APInt u64max = new APInt(JD$UInt_ULong.INSTANCE, 128, -1, false);
    EXPECT_EQ(64, u64max.countLeadingZeros());
    EXPECT_EQ(0, u64max.countLeadingOnes());
    EXPECT_EQ(64, u64max.getActiveBits());
    EXPECT_EQ(0, u64max.countTrailingZeros());
    EXPECT_EQ(64, u64max.countTrailingOnes());
    EXPECT_EQ(64, u64max.countPopulation());
    EXPECT_EQ(~0l, u64max.getZExtValue());

    APInt zero = new APInt(JD$UInt_ULong.INSTANCE, 128, 0, true);
    EXPECT_EQ(128, zero.countLeadingZeros());
    EXPECT_EQ(0, zero.countLeadingOnes());
    EXPECT_EQ(0, zero.getActiveBits());
    EXPECT_EQ(128, zero.countTrailingZeros());
    EXPECT_EQ(0, zero.countTrailingOnes());
    EXPECT_EQ(0, zero.countPopulation());
    EXPECT_EQ(0l, zero.getSExtValue());
    EXPECT_EQ(0l, zero.getZExtValue());

    APInt one = new APInt(JD$UInt_ULong.INSTANCE, 128, 1, true);
    EXPECT_EQ(127, one.countLeadingZeros());
    EXPECT_EQ(0, one.countLeadingOnes());
    EXPECT_EQ(1, one.getActiveBits());
    EXPECT_EQ(0, one.countTrailingZeros());
    EXPECT_EQ(1, one.countTrailingOnes());
    EXPECT_EQ(1, one.countPopulation());
    EXPECT_EQ(1l, one.getSExtValue());
    EXPECT_EQ(1l, one.getZExtValue());
  }

  @Test
  public void i1() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    APInt neg_two = new APInt(JD$UInt_ULong.INSTANCE, 1, (-2), true);
    APInt neg_one = new APInt(JD$UInt_ULong.INSTANCE, 1, (-1), true);
    APInt zero = new APInt(1, 0);
    APInt one = new APInt(1, 1);
    APInt two = new APInt(1, 2);

    EXPECT_EQ(0l, neg_two.getSExtValue());
    EXPECT_EQ(-1l, neg_one.getSExtValue());
    EXPECT_EQ(1l, neg_one.getZExtValue());
    EXPECT_EQ(0l, zero.getZExtValue());
    EXPECT_EQ(-1l, one.getSExtValue());
    EXPECT_EQ(1l, one.getZExtValue());
    EXPECT_EQ(0l, two.getZExtValue());
    EXPECT_EQ(0l, two.getSExtValue());

    // Basic equalities for 1-bit values.
    EXPECT_EQ(zero, two);
    EXPECT_EQ(zero, neg_two);
    EXPECT_EQ(one, neg_one);
    EXPECT_EQ(two, neg_two);

    // Additions.
    EXPECT_EQ(two, one.$add(one));
    EXPECT_EQ(zero, neg_one.$add(one));
    EXPECT_EQ(neg_two, neg_one.$add(neg_one));

    // Subtractions.
    EXPECT_EQ(neg_two, neg_one.$sub(one));
    EXPECT_EQ(two, one.$sub(neg_one));
    EXPECT_EQ(zero, one.$sub(one));

    // Shifts.
    EXPECT_EQ(zero, one.$out(one));
    EXPECT_EQ(one, one.$out(zero));
    EXPECT_EQ(zero, one.shl(1));
    EXPECT_EQ(one, one.shl(0));
    EXPECT_EQ(zero, one.lshr(1));
    EXPECT_EQ(zero, one.ashr(1));

    // Rotates.
    EXPECT_EQ(one, one.rotl(0));
    EXPECT_EQ(one, one.rotl(1));
    EXPECT_EQ(one, one.rotr(0));
    EXPECT_EQ(one, one.rotr(1));

    // Multiplies.
    EXPECT_EQ(neg_one, neg_one.$star(one));
    EXPECT_EQ(neg_one, one.$star(neg_one));
    EXPECT_EQ(one, neg_one.$star(neg_one));
    EXPECT_EQ(one, one.$star(one));

    // Divides.
    EXPECT_EQ(neg_one, one.sdiv(neg_one));
    EXPECT_EQ(neg_one, neg_one.sdiv(one));
    EXPECT_EQ(one, neg_one.sdiv(neg_one));
    EXPECT_EQ(one, one.sdiv(one));

    EXPECT_EQ(neg_one, one.udiv(neg_one));
    EXPECT_EQ(neg_one, neg_one.udiv(one));
    EXPECT_EQ(one, neg_one.udiv(neg_one));
    EXPECT_EQ(one, one.udiv(one));

    // Remainders.
    EXPECT_EQ(zero, neg_one.srem(one));
    EXPECT_EQ(zero, neg_one.urem(one));
    EXPECT_EQ(zero, one.srem(neg_one));

    // sdivrem
    {
    APInt q = new APInt(8, 0);
    APInt r = new APInt(8, 0);
    APInt one_ = new APInt(8, 1);
    APInt two_ = new APInt(8, 2);
    APInt nine = new APInt(8, 9);
    APInt four = new APInt(8, 4);

    EXPECT_EQ(nine.srem(two_), one_);
    EXPECT_EQ(nine.srem(two_.$sub()), one_);
    EXPECT_EQ((nine.$sub()).srem(two_), one_.$sub());
    EXPECT_EQ((nine.$sub()).srem(two_.$sub()), one_.$sub());

    APInt.sdivrem(nine, two_, q, r);
    EXPECT_EQ(four, q);
    EXPECT_EQ(one_, r);
    APInt.sdivrem(nine.$sub(), two_, q, r);
    EXPECT_EQ(four.$sub(), q);
    EXPECT_EQ(one_.$sub(), r);
    APInt.sdivrem(nine, two_.$sub(), q, r);
    EXPECT_EQ(four.$sub(), q);
    EXPECT_EQ(one_, r);
    APInt.sdivrem(nine.$sub(), two_.$sub(), q, r);
    EXPECT_EQ(four, q);
    EXPECT_EQ(one_.$sub(), r);
    }
  }

  @Test
  public void fromString() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ(new APInt(32, 0), new APInt(32, "0", 2));
    EXPECT_EQ(new APInt(32, 1), new APInt(32,   "1", 2));
    EXPECT_EQ(new APInt(32, 2), new APInt(32,  "10", 2));
    EXPECT_EQ(new APInt(32, 3), new APInt(32,  "11", 2));
    EXPECT_EQ(new APInt(32, 4), new APInt(32, "100", 2));

    EXPECT_EQ(new APInt(32, 0), new APInt(32,   "+0", 2));
    EXPECT_EQ(new APInt(32, 1), new APInt(32,   "+1", 2));
    EXPECT_EQ(new APInt(32, 2), new APInt(32,  "+10", 2));
    EXPECT_EQ(new APInt(32, 3), new APInt(32,  "+11", 2));
    EXPECT_EQ(new APInt(32, 4), new APInt(32, "+100", 2));

    EXPECT_EQ(new APInt(32, -0l), new APInt(32,   "-0", 2));
    EXPECT_EQ(new APInt(32, -1l), new APInt(32,   "-1", 2));
    EXPECT_EQ(new APInt(32, -2l), new APInt(32,  "-10", 2));
    EXPECT_EQ(new APInt(32, -3l), new APInt(32,  "-11", 2));
    EXPECT_EQ(new APInt(32, -4l), new APInt(32, "-100", 2));


    EXPECT_EQ(new APInt(32,  0), new APInt(32,  "0",  8));
    EXPECT_EQ(new APInt(32,  1), new APInt(32,  "1",  8));
    EXPECT_EQ(new APInt(32,  7), new APInt(32,  "7",  8));
    EXPECT_EQ(new APInt(32,  8), new APInt(32,  "10", 8));
    EXPECT_EQ(new APInt(32, 15), new APInt(32,  "17", 8));
    EXPECT_EQ(new APInt(32, 16), new APInt(32,  "20", 8));

    EXPECT_EQ(new APInt(32,  +0), new APInt(32,  "+0",  8));
    EXPECT_EQ(new APInt(32,  +1), new APInt(32,  "+1",  8));
    EXPECT_EQ(new APInt(32,  +7), new APInt(32,  "+7",  8));
    EXPECT_EQ(new APInt(32,  +8), new APInt(32,  "+10", 8));
    EXPECT_EQ(new APInt(32, +15), new APInt(32,  "+17", 8));
    EXPECT_EQ(new APInt(32, +16), new APInt(32,  "+20", 8));

    EXPECT_EQ(new APInt(32, -0l), new APInt(32,  "-0",  8));
    EXPECT_EQ(new APInt(32, -1l), new APInt(32,  "-1",  8));
    EXPECT_EQ(new APInt(32, -7l), new APInt(32,  "-7",  8));
    EXPECT_EQ(new APInt(32, -8l), new APInt(32,  "-10", 8));
    EXPECT_EQ(new APInt(32, -15l), new APInt(32,  "-17", 8));
    EXPECT_EQ(new APInt(32, -16l), new APInt(32,  "-20", 8));


    EXPECT_EQ(new APInt(32,  0), new APInt(32,  "0", 10));
    EXPECT_EQ(new APInt(32,  1), new APInt(32,  "1", 10));
    EXPECT_EQ(new APInt(32,  9), new APInt(32,  "9", 10));
    EXPECT_EQ(new APInt(32, 10), new APInt(32, "10", 10));
    EXPECT_EQ(new APInt(32, 19), new APInt(32, "19", 10));
    EXPECT_EQ(new APInt(32, 20), new APInt(32, "20", 10));

    EXPECT_EQ(new APInt(32, -0l), new APInt(32,  "-0", 10));
    EXPECT_EQ(new APInt(32, -1l), new APInt(32,  "-1", 10));
    EXPECT_EQ(new APInt(32, -9l), new APInt(32,  "-9", 10));
    EXPECT_EQ(new APInt(32, -10l), new APInt(32, "-10", 10));
    EXPECT_EQ(new APInt(32, -19l), new APInt(32, "-19", 10));
    EXPECT_EQ(new APInt(32, -20l), new APInt(32, "-20", 10));


    EXPECT_EQ(new APInt(32,  0), new APInt(32,  "0", 16));
    EXPECT_EQ(new APInt(32,  1), new APInt(32,  "1", 16));
    EXPECT_EQ(new APInt(32, 15), new APInt(32,  "F", 16));
    EXPECT_EQ(new APInt(32, 16), new APInt(32, "10", 16));
    EXPECT_EQ(new APInt(32, 31), new APInt(32, "1F", 16));
    EXPECT_EQ(new APInt(32, 32), new APInt(32, "20", 16));

    EXPECT_EQ(new APInt(32, -0l), new APInt(32,  "-0", 16));
    EXPECT_EQ(new APInt(32, -1l), new APInt(32,  "-1", 16));
    EXPECT_EQ(new APInt(32, -15l), new APInt(32,  "-F", 16));
    EXPECT_EQ(new APInt(32, -16l), new APInt(32, "-10", 16));
    EXPECT_EQ(new APInt(32, -31l), new APInt(32, "-1F", 16));
    EXPECT_EQ(new APInt(32, -32l), new APInt(32, "-20", 16));

    EXPECT_EQ(new APInt(32,  0), new APInt(32,  "0", 36));
    EXPECT_EQ(new APInt(32,  1), new APInt(32,  "1", 36));
    EXPECT_EQ(new APInt(32, 35), new APInt(32,  "Z", 36));
    EXPECT_EQ(new APInt(32, 36), new APInt(32, "10", 36));
    EXPECT_EQ(new APInt(32, 71), new APInt(32, "1Z", 36));
    EXPECT_EQ(new APInt(32, 72), new APInt(32, "20", 36));

    EXPECT_EQ(new APInt(32, -0l), new APInt(32,  "-0", 36));
    EXPECT_EQ(new APInt(32, -1l), new APInt(32,  "-1", 36));
    EXPECT_EQ(new APInt(32, -35l), new APInt(32,  "-Z", 36));
    EXPECT_EQ(new APInt(32, -36l), new APInt(32, "-10", 36));
    EXPECT_EQ(new APInt(32, -71l), new APInt(32, "-1Z", 36));
    EXPECT_EQ(new APInt(32, -72l), new APInt(32, "-20", 36));
  }

  @Test
  public void FromArray() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ(new APInt(32, 1l), new APInt(32, new ArrayRefULong(1L)));
  }

  @Test
  public void StringBitsNeeded2() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ(1, APInt.getBitsNeeded(  "0", 2));
    EXPECT_EQ(1, APInt.getBitsNeeded(  "1", 2));
    EXPECT_EQ(2, APInt.getBitsNeeded( "10", 2));
    EXPECT_EQ(2, APInt.getBitsNeeded( "11", 2));
    EXPECT_EQ(3, APInt.getBitsNeeded("100", 2));

    EXPECT_EQ(1, APInt.getBitsNeeded(  "+0", 2));
    EXPECT_EQ(1, APInt.getBitsNeeded(  "+1", 2));
    EXPECT_EQ(2, APInt.getBitsNeeded( "+10", 2));
    EXPECT_EQ(2, APInt.getBitsNeeded( "+11", 2));
    EXPECT_EQ(3, APInt.getBitsNeeded("+100", 2));

    EXPECT_EQ(2, APInt.getBitsNeeded(  "-0", 2));
    EXPECT_EQ(2, APInt.getBitsNeeded(  "-1", 2));
    EXPECT_EQ(3, APInt.getBitsNeeded( "-10", 2));
    EXPECT_EQ(3, APInt.getBitsNeeded( "-11", 2));
    EXPECT_EQ(4, APInt.getBitsNeeded("-100", 2));
  }

  @Test
  public void StringBitsNeeded8() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ(3, APInt.getBitsNeeded( "0", 8));
    EXPECT_EQ(3, APInt.getBitsNeeded( "7", 8));
    EXPECT_EQ(6, APInt.getBitsNeeded("10", 8));
    EXPECT_EQ(6, APInt.getBitsNeeded("17", 8));
    EXPECT_EQ(6, APInt.getBitsNeeded("20", 8));

    EXPECT_EQ(3, APInt.getBitsNeeded( "+0", 8));
    EXPECT_EQ(3, APInt.getBitsNeeded( "+7", 8));
    EXPECT_EQ(6, APInt.getBitsNeeded("+10", 8));
    EXPECT_EQ(6, APInt.getBitsNeeded("+17", 8));
    EXPECT_EQ(6, APInt.getBitsNeeded("+20", 8));

    EXPECT_EQ(4, APInt.getBitsNeeded( "-0", 8));
    EXPECT_EQ(4, APInt.getBitsNeeded( "-7", 8));
    EXPECT_EQ(7, APInt.getBitsNeeded("-10", 8));
    EXPECT_EQ(7, APInt.getBitsNeeded("-17", 8));
    EXPECT_EQ(7, APInt.getBitsNeeded("-20", 8));
  }

  @Test
  public void StringBitsNeeded10() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ(1, APInt.getBitsNeeded( "0", 10));
    EXPECT_EQ(2, APInt.getBitsNeeded( "3", 10));
    EXPECT_EQ(4, APInt.getBitsNeeded( "9", 10));
    EXPECT_EQ(4, APInt.getBitsNeeded("10", 10));
    EXPECT_EQ(5, APInt.getBitsNeeded("19", 10));
    EXPECT_EQ(5, APInt.getBitsNeeded("20", 10));

    EXPECT_EQ(1, APInt.getBitsNeeded( "+0", 10));
    EXPECT_EQ(4, APInt.getBitsNeeded( "+9", 10));
    EXPECT_EQ(4, APInt.getBitsNeeded("+10", 10));
    EXPECT_EQ(5, APInt.getBitsNeeded("+19", 10));
    EXPECT_EQ(5, APInt.getBitsNeeded("+20", 10));

    EXPECT_EQ(2, APInt.getBitsNeeded( "-0", 10));
    EXPECT_EQ(5, APInt.getBitsNeeded( "-9", 10));
    EXPECT_EQ(5, APInt.getBitsNeeded("-10", 10));
    EXPECT_EQ(6, APInt.getBitsNeeded("-19", 10));
    EXPECT_EQ(6, APInt.getBitsNeeded("-20", 10));
  }

  @Test
  public void StringBitsNeeded16() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ(4, APInt.getBitsNeeded( "0", 16));
    EXPECT_EQ(4, APInt.getBitsNeeded( "F", 16));
    EXPECT_EQ(8, APInt.getBitsNeeded("10", 16));
    EXPECT_EQ(8, APInt.getBitsNeeded("1F", 16));
    EXPECT_EQ(8, APInt.getBitsNeeded("20", 16));

    EXPECT_EQ(4, APInt.getBitsNeeded( "+0", 16));
    EXPECT_EQ(4, APInt.getBitsNeeded( "+F", 16));
    EXPECT_EQ(8, APInt.getBitsNeeded("+10", 16));
    EXPECT_EQ(8, APInt.getBitsNeeded("+1F", 16));
    EXPECT_EQ(8, APInt.getBitsNeeded("+20", 16));

    EXPECT_EQ(5, APInt.getBitsNeeded( "-0", 16));
    EXPECT_EQ(5, APInt.getBitsNeeded( "-F", 16));
    EXPECT_EQ(9, APInt.getBitsNeeded("-10", 16));
    EXPECT_EQ(9, APInt.getBitsNeeded("-1F", 16));
    EXPECT_EQ(9, APInt.getBitsNeeded("-20", 16));
  }

  @Test
  public void toStringTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    SmallString S = new SmallString(16);
    boolean isSigned;

    new APInt(8, 0).__toString(S, 2, true, true);
    EXPECT_EQ(S.str().str(), "0b0");
    S.clear();
    new APInt(8, 0).__toString(S, 8, true, true);
    EXPECT_EQ(S.str().str(), "00");
    S.clear();
    new APInt(8, 0).__toString(S, 10, true, true);
    EXPECT_EQ(S.str().str(), "0");
    S.clear();
    new APInt(8, 0).__toString(S, 16, true, true);
    EXPECT_EQ(S.str().str(), "0x0");
    S.clear();
    new APInt(8, 0).__toString(S, 36, true, false);
    EXPECT_EQ(S.str().str(), "0");
    S.clear();

    isSigned = false;
    new APInt(JD$UInt_ULong.INSTANCE, 8, 255, isSigned).__toString(S, 2, isSigned, true);
    EXPECT_EQ(S.str().str(), "0b11111111");
    S.clear();
    new APInt(JD$UInt_ULong.INSTANCE, 8, 255, isSigned).__toString(S, 8, isSigned, true);
    EXPECT_EQ(S.str().str(), "0377");
    S.clear();
    new APInt(JD$UInt_ULong.INSTANCE, 8, 255, isSigned).__toString(S, 10, isSigned, true);
    EXPECT_EQ(S.str().str(), "255");
    S.clear();
    new APInt(JD$UInt_ULong.INSTANCE, 8, 255, isSigned).__toString(S, 16, isSigned, true);
    EXPECT_EQ(S.str().str(), "0xFF");
    S.clear();
    new APInt(JD$UInt_ULong.INSTANCE, 8, 255, isSigned).__toString(S, 36, isSigned, false);
    EXPECT_EQ(S.str().str(), "73");
    S.clear();

    isSigned = true;
    new APInt(JD$UInt_ULong.INSTANCE, 8, 255, isSigned).__toString(S, 2, isSigned, true);
    EXPECT_EQ(S.str().str(), "-0b1");
    S.clear();
    new APInt(JD$UInt_ULong.INSTANCE, 8, 255, isSigned).__toString(S, 8, isSigned, true);
    EXPECT_EQ(S.str().str(), "-01");
    S.clear();
    new APInt(JD$UInt_ULong.INSTANCE, 8, 255, isSigned).__toString(S, 10, isSigned, true);
    EXPECT_EQ(S.str().str(), "-1");
    S.clear();
    new APInt(JD$UInt_ULong.INSTANCE, 8, 255, isSigned).__toString(S, 16, isSigned, true);
    EXPECT_EQ(S.str().str(), "-0x1");
    S.clear();
    new APInt(JD$UInt_ULong.INSTANCE, 8, 255, isSigned).__toString(S, 36, isSigned, false);
    EXPECT_EQ(S.str().str(), "-1");
    S.clear();
    isSigned = true;
    long maxLong = 0x8000000000000000L;
    assert maxLong == Long.MIN_VALUE;
    new APInt(JD$UInt_ULong.INSTANCE, 64, maxLong, isSigned).__toString(S, 10, isSigned, false);
    EXPECT_EQ(S.str().str(), "" + maxLong);
    S.clear();
  }
  
  @Test
  public void Log2() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ(new APInt(15, 7).logBase2(), 2);
    EXPECT_EQ(new APInt(15, 7).ceilLogBase2(), 3);
    EXPECT_EQ(new APInt(15, 7).exactLogBase2(), -1);
    EXPECT_EQ(new APInt(15, 8).logBase2(), 3);
    EXPECT_EQ(new APInt(15, 8).ceilLogBase2(), 3);
    EXPECT_EQ(new APInt(15, 8).exactLogBase2(), 3);
    EXPECT_EQ(new APInt(15, 9).logBase2(), 3);
    EXPECT_EQ(new APInt(15, 9).ceilLogBase2(), 4);
    EXPECT_EQ(new APInt(15, 9).exactLogBase2(), -1);
  }

  @Test
  public void magic() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ(new APInt(32, 3).magic().m, new APInt(32, "55555556", 16));
    EXPECT_EQ(new APInt(32, 3).magic().s, 0);
    EXPECT_EQ(new APInt(32, 5).magic().m, new APInt(32, "66666667", 16));
    EXPECT_EQ(new APInt(32, 5).magic().s, 1);
    EXPECT_EQ(new APInt(32, 7).magic().m, new APInt(32, "92492493", 16));
    EXPECT_EQ(new APInt(32, 7).magic().s, 2);
  }
  
  @Test
  public void magicu() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ(new APInt(32, 3).magicu().m, new APInt(32, "AAAAAAAB", 16));
    EXPECT_EQ(new APInt(32, 3).magicu().s, 1);
    EXPECT_EQ(new APInt(32, 5).magicu().m, new APInt(32, "CCCCCCCD", 16));
    EXPECT_EQ(new APInt(32, 5).magicu().s, 2);
    EXPECT_EQ(new APInt(32, 7).magicu().m, new APInt(32, "24924925", 16));
    EXPECT_EQ(new APInt(32, 7).magicu().s, 3);
    EXPECT_EQ(new APInt(64, 25).magicu(1).m, new APInt(64, "A3D70A3D70A3D70B", 16));
    EXPECT_EQ(new APInt(64, 25).magicu(1).s, 4);
  }

  @Test
  public void Rotate() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ(new APInt(8, 1),  new APInt(8, 1).rotl(0));
    EXPECT_EQ(new APInt(8, 2),  new APInt(8, 1).rotl(1));
    EXPECT_EQ(new APInt(8, 4),  new APInt(8, 1).rotl(2));
    EXPECT_EQ(new APInt(8, 16), new APInt(8, 1).rotl(4));
    EXPECT_EQ(new APInt(8, 1),  new APInt(8, 1).rotl(8));

    EXPECT_EQ(new APInt(8, 16), new APInt(8, 16).rotl(0));
    EXPECT_EQ(new APInt(8, 32), new APInt(8, 16).rotl(1));
    EXPECT_EQ(new APInt(8, 64), new APInt(8, 16).rotl(2));
    EXPECT_EQ(new APInt(8, 1),  new APInt(8, 16).rotl(4));
    EXPECT_EQ(new APInt(8, 16), new APInt(8, 16).rotl(8));

    EXPECT_EQ(new APInt(8, 16), new APInt(8, 16).rotr(0));
    EXPECT_EQ(new APInt(8, 8),  new APInt(8, 16).rotr(1));
    EXPECT_EQ(new APInt(8, 4),  new APInt(8, 16).rotr(2));
    EXPECT_EQ(new APInt(8, 1),  new APInt(8, 16).rotr(4));
    EXPECT_EQ(new APInt(8, 16), new APInt(8, 16).rotr(8));

    EXPECT_EQ(new APInt(8, 1),   new APInt(8, 1).rotr(0));
    EXPECT_EQ(new APInt(8, 128), new APInt(8, 1).rotr(1));
    EXPECT_EQ(new APInt(8, 64),  new APInt(8, 1).rotr(2));
    EXPECT_EQ(new APInt(8, 16),  new APInt(8, 1).rotr(4));
    EXPECT_EQ(new APInt(8, 1),   new APInt(8, 1).rotr(8));

    APInt Big = new APInt(256, "00004000800000000000000000003fff8000000000000000", 16);
    APInt Rot = new APInt(256, "3fff80000000000000000000000000000000000040008000", 16);
    EXPECT_EQ(Rot, Big.rotr(144));
  }

  @Test
  public void Splat() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    APInt ValA = new APInt(8, 0x01);
    EXPECT_EQ(ValA, APInt.getSplat(8, ValA));
    EXPECT_EQ(new APInt(64, 0x0101010101010101l), APInt.getSplat(64, ValA));

    APInt ValB = new APInt(3, 5);
    EXPECT_EQ(new APInt(4, 0xD), APInt.getSplat(4, ValB));
    EXPECT_EQ(new APInt(15, 0xDB6D), APInt.getSplat(15, ValB));
  }

  @Test
  public void tcDecrement() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    // Test single word decrement.

    // No out borrow.
    {
      ulong$ptr singleWord = NativePointer.create_ulong$ptr(~0l << (integerPartWidth - 1));
      long carry = APInt.tcDecrement(singleWord, 1);
      EXPECT_EQ(carry, 0l);
      EXPECT_EQ(singleWord.$star(), ~0l >>> 1);
    }

    // With out borrow.
    {
      ulong$ptr singleWord = NativePointer.create_ulong$ptr(0);
      long carry = APInt.tcDecrement(singleWord, 1);
      EXPECT_EQ(carry, 1l);
      EXPECT_EQ(singleWord.$star(), ~0l);
    }

    // Test multiword decrement.

    // No across word borrow, no out borrow.
    {
      ulong$ptr test = NativePointer.create_ulong$ptr(new long[]{0x1, 0x1, 0x1, 0x1});
      ulong$ptr expected = NativePointer.create_ulong$ptr(new long[]{0x0, 0x1, 0x1, 0x1});
      APInt.tcDecrement(test, 4);
      EXPECT_EQ(APInt.tcCompare(test, expected, 4), 0);
    }

    // 1 across word borrow, no out borrow.
    {
      ulong$ptr test = NativePointer.create_ulong$ptr(new long[]{0x0, 0xF, 0x1, 0x1});
      ulong$ptr expected = NativePointer.create_ulong$ptr(new long[]{~0l, 0xE, 0x1, 0x1});
      long carry = APInt.tcDecrement(test, 4);
      EXPECT_EQ(carry, 0l);
      EXPECT_EQ(APInt.tcCompare(test, expected, 4), 0);
    }

    // 2 across word borrow, no out borrow.
    {
      ulong$ptr test = NativePointer.create_ulong$ptr(new long[]{0x0, 0x0, 0xC, 0x1});
      ulong$ptr expected = NativePointer.create_ulong$ptr(new long[]{~0l, ~0l, 0xB, 0x1});
      long carry = APInt.tcDecrement(test, 4);
      EXPECT_EQ(carry, 0l);
      EXPECT_EQ(APInt.tcCompare(test, expected, 4), 0);
    }

    // 3 across word borrow, no out borrow.
    {
      ulong$ptr test = NativePointer.create_ulong$ptr(new long[]{0x0, 0x0, 0x0, 0x1});
      ulong$ptr expected = NativePointer.create_ulong$ptr(new long[]{~0l, ~0l, ~0l, 0x0});
      long carry = APInt.tcDecrement(test, 4);
      EXPECT_EQ(carry, 0l);
      EXPECT_EQ(APInt.tcCompare(test, expected, 4), 0);
    }

    // 3 across word borrow, with out borrow.
    {
      ulong$ptr test = NativePointer.create_ulong$ptr(new long[]{0x0, 0x0, 0x0, 0x0});
      ulong$ptr expected = NativePointer.create_ulong$ptr(new long[]{~0l, ~0l, ~0l, ~0l});
      long carry = APInt.tcDecrement(test, 4);
      EXPECT_EQ(carry, 1l);
      EXPECT_EQ(APInt.tcCompare(test, expected, 4), 0);
    }
  }

  @Test
  public void arrayAccess() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    // Single word check.
    long E1 = 0x2CA7F46BF6569915l;
    APInt A1 = new APInt(64, E1);
    for (int i = 0, e = 64; i < e; ++i) {
      EXPECT_EQ((E1 & (1l << i)) != 0,
                A1.$at(i));
    }

    // Multiword check.
    long E2[] = new long[]{
      0xEB6EB136591CBA21l,
      0x7B9358BD6A33F10Al,
      0x7E7FFA5EADD8846l,
      0x305F341CA00B613Dl
    };
    APInt A2 = new APInt(integerPartWidth*4, new ArrayRefULong(E2));
    for (int i = 0; i < 4; ++i) {
      for (int j = 0; j < integerPartWidth; ++j) {
        EXPECT_EQ((E2[i] & (1l << j)) != 0,
                  A2.$at(i*integerPartWidth + j));
      }
    }
  }

  @Test
  public void LargeAPIntConstruction() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    // Check that we can properly construct very large APInt. It is very
    // unlikely that people will ever do this, but it is a legal input,
    // so we should not crash on it.
    APInt A9 = new APInt(UINT32_MAX, 0);
    EXPECT_FALSE(A9.getBoolValue());
  }

  @Test
  public void nearestLogBase2() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    // Single word check.

    // Test round up.
    long I1 = 0x1800001;
    APInt A1 = new APInt(64, I1);
    EXPECT_EQ(A1.nearestLogBase2(), A1.ceilLogBase2());

    // Test round down.
    long I2 = 0x1000011;
    APInt A2 = new APInt(64, I2);
    EXPECT_EQ(A2.nearestLogBase2(), A2.logBase2());

    // Test ties round up.
    long I3 = 0x1800000;
    APInt A3 = new APInt(64, I3);
    EXPECT_EQ(A3.nearestLogBase2(), A3.ceilLogBase2());

    // Multiple word check.

    // Test round up.
    long I4[] = new long[]{0x0, 0xF, 0x18, 0x0};
    APInt A4 = new APInt(integerPartWidth*4, new ArrayRefULong(I4));
    EXPECT_EQ(A4.nearestLogBase2(), A4.ceilLogBase2());

    // Test round down.
    long I5[] = new long[]{0x0, 0xF, 0x10, 0x0};
    APInt A5 = new APInt(integerPartWidth*4, new ArrayRefULong(I5));
    EXPECT_EQ(A5.nearestLogBase2(), A5.logBase2());

    // Test ties round up.
    long I6[] = new long[]{0x0, 0x0, 0x0, 0x18};
    APInt A6 = new APInt(integerPartWidth*4, new ArrayRefULong(I6));
    EXPECT_EQ(A6.nearestLogBase2(), A6.ceilLogBase2());

    // Test BitWidth == 1 special cases.
    APInt A7 = new APInt(1, 1);
    EXPECT_EQ(A7.nearestLogBase2(), 0);
    APInt A8 = new APInt(1, 0);
    EXPECT_EQ(A8.nearestLogBase2(), UINT32_MAX);

    // Test the zero case when we have a bit width large enough such
    // that the bit width is larger than UINT32_MAX-1.
    APInt A9 = new APInt(UINT32_MAX, 0);
    EXPECT_EQ(A9.nearestLogBase2(), UINT32_MAX);
  }

  @Test
  public void SelfMoveAssignment() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    APInt X = new APInt(32, 0xdeadbeefl);
    X.$assignMove(std.move(X));
    EXPECT_EQ(32, X.getBitWidth());
    EXPECT_EQ(0xdeadbeefl, X.getLimitedValue());

    long Bits[] = new long[]{0xdeadbeefdeadbeefl, 0xdeadbeefdeadbeefl};
    APInt Y = new APInt(128, new ArrayRefULong(Bits));
    Y.$assignMove(std.move(Y));
    EXPECT_EQ(128, Y.getBitWidth());
    EXPECT_EQ(~0l, Y.getLimitedValue());
    ulong$ptr Raw = Y.getRawData();
    EXPECT_EQ(2, Y.getNumWords());
    EXPECT_EQ(0xdeadbeefdeadbeefl, Raw.$at(0));
    EXPECT_EQ(0xdeadbeefdeadbeefl, Raw.$at(1));
  }
  
  @Test
  public void GetMaxValues() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.string Signed64 = GetMaxValueImpl(64, true);
    std.string USigned64 = GetMaxValueImpl(64, false);
    std.string Signed128 = GetMaxValueImpl(128, true);
    std.string USigne128 = GetMaxValueImpl(128, false);
  }
  
  @Test 
  public void testFromToString() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String STR_VAL_1 = "100000000000000000000000000000";
    APInt val1 = new APInt(128, STR_VAL_1, 10);
    String strVal_Out = val1.__toString(10).toJavaString();
    EXPECT_EQ(STR_VAL_1, strVal_Out);
    String STR_VAL_2 = "FFFFFF00000000000000000000000000";
    APInt val2 = new APInt(128, STR_VAL_2, 16);
    String strVal2_Out = val2.__toString(16, false).toJavaString();
    EXPECT_EQ(STR_VAL_2, strVal2_Out);
    APInt Lhs = new APInt(128, 0xFFFFFF);
    String significandStr = Lhs.__toString(16, false).toJavaString();
    EXPECT_EQ("FFFFFF", significandStr);
    // 0xFFFFFF << (26*4) => STR_VAL_2
    Lhs = Lhs.shl(26*4);
    String significandStrShifted = Lhs.__toString(16, false).toJavaString();
    EXPECT_EQ(STR_VAL_2, significandStrShifted);
  }
  
  @Test 
  public void testUnsignedDiv() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    // test Unsigned division of values from the testFromToString
    String STR_VAL_1 = "100000000000000000000000000000";
    APInt val1 = new APInt(128, STR_VAL_1, 10);
    String strVal_Out = val1.__toString(10).toJavaString();
    EXPECT_EQ(STR_VAL_1, strVal_Out);
    String STR_VAL_2 = "FFFFFF00000000000000000000000000";
    APInt val2 = new APInt(128, STR_VAL_2, 16);
    String strVal2_Out = val2.__toString(16, false).toJavaString();
    EXPECT_EQ(STR_VAL_2, strVal2_Out);
    APInt significand = new APInt(128, 0xFFFFFF);
    String significandStr = significand.__toString(16, false).toJavaString();
    EXPECT_EQ("FFFFFF", significandStr);
    significand = significand.shl(26*4);
    String significandStrShifted = significand.__toString(16, false).toJavaString();
    EXPECT_EQ(STR_VAL_2, significandStrShifted);
    APInt udiv = significand.udiv(val1);
    String udivStr = udiv.__toString(10).toJavaString();
    EXPECT_EQ("3402823466", udivStr);
  }
  
  @Test
  public void testToFromDoubleBits() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    double D = 12345.6789;
    APInt doubleToBits = APInt.doubleToBits(D);
    String str = doubleToBits.__toString().toJavaString();
    EXPECT_EQ("4668012723080132769", str);
    double bitsToDouble = doubleToBits.bitsToDouble();
    EXPECT_EQ("" + D, "" + bitsToDouble);
  }
  
  @Test
  public void testToFromFloatBits() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    float F = 1234567.8f;
    APInt floatToBits = APInt.floatToBits(F);
    String str = floatToBits.__toString().toJavaString();
    EXPECT_EQ("1234613310", str);
    float bitsToFloat = floatToBits.bitsToFloat();
    EXPECT_EQ("" + F, "" + bitsToFloat);
  }
  
  private std.string GetMaxValueImpl(int TypeWidth, boolean isSigned) {
    APInt MaxVal = isSigned ? APInt.getSignedMaxValue(TypeWidth) : APInt.getMaxValue(TypeWidth);
    return MaxVal.__toString(10, isSigned);
  }
  
  
}
