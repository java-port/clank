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

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vladimir Voskresensky
 */
public class BitFields32UtilsTest extends org.clank.java.JavaTestBase {
  
  public BitFields32UtilsTest() {
  }

  @Test
  public void testSetLastBits32() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    int Value = 0x0;
    int values[] = new int[] {0x1, 0x2, 0x3, 0x4, 0x5, 0x6, 0x7, 0x8};
    for (int FirstBitIndex = 4; FirstBitIndex <= 32; FirstBitIndex+=4) {
      int cur = values[FirstBitIndex/4-1];
      Value = BitFieldsUtils.setLastBits32(Value, FirstBitIndex, cur);
      assertEquals(cur, Value);
    }
  }

  @Test
  public void testSetMiddleBits32_FF() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    int flagsField = 0xFF00FF00;
    for (int FirstBitIndex = 4; FirstBitIndex <= 32; FirstBitIndex+=4) {
      flagsField = BitFieldsUtils.setMiddleBits32(flagsField, FirstBitIndex, 4, 0xF);
    }
    assertEquals(0xFFFFFFFF, flagsField);
  }

  @Test
  public void testSetMiddleBits32_00() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    int flagsField = 0xFF00FF00;
    for (int FirstBitIndex = 4; FirstBitIndex <= 32; FirstBitIndex+=4) {
      flagsField = BitFieldsUtils.setMiddleBits32(flagsField, FirstBitIndex, 4, 0x0);
    }
    assertEquals(0x00000000, flagsField);
  }

  @Test
  public void testSetBit32() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    int flagsField = new Random().nextInt();
    for (int Bit = 1; Bit <= 32; Bit++) {
      boolean result = BitFieldsUtils.getBit32(flagsField, Bit);
      int changedVal = BitFieldsUtils.setBit32(flagsField, Bit, !result);
      assertFalse(flagsField + ":" + Bit + " vs. " + changedVal, flagsField == changedVal);
      assertTrue(flagsField + ":" + Bit + " vs. " + (changedVal - flagsField) + " vs. " + (1 << Bit), ((changedVal - flagsField) == (1 << Bit)) || ((changedVal - flagsField) == -(1 << Bit)));
      changedVal = BitFieldsUtils.setBit32(changedVal, Bit, result);
      assertTrue(flagsField + ":" + Bit + " vs. " + changedVal, flagsField == changedVal);
    }    
  }

  @Test
  public void testGetMiddleBits32_F() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    int flagsField = 0xFFFFFFFF;
    for (int FirstBitIndex = 4; FirstBitIndex <= 32; FirstBitIndex+=4) {
      int Val = BitFieldsUtils.getMiddleBits32(flagsField, FirstBitIndex, 4);
      assertEquals(0xF, Val);
    }
  }

  @Test
  public void testGetMiddleBits32_0() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    int flagsField = 0x0;
    for (int FirstBitIndex = 4; FirstBitIndex <= 32; FirstBitIndex+=4) {
      int Val = BitFieldsUtils.getMiddleBits32(flagsField, FirstBitIndex, 4);
      assertEquals(0x0, Val);
    }
  }

  @Test
  public void testGetMiddleBits32_12345678() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    int flagsField = 0x87654321;    
    int expected[] = new int[] {0x1, 0x2, 0x3, 0x4, 0x5, 0x6, 0x7, 0x8};
    for (int FirstBitIndex = 4; FirstBitIndex <= 32; FirstBitIndex+=4) {
      int Val = BitFieldsUtils.getMiddleBits32(flagsField, FirstBitIndex, 4);
      assertEquals(expected[FirstBitIndex/4-1], Val);
    }
  }

  @Test
  public void testGetLastBits32_0() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    int flagsField = 0x0;    
    for (int FirstBitIndex = 4; FirstBitIndex <= 32; FirstBitIndex+=4) {
      int Val = BitFieldsUtils.getLastBits32(flagsField, FirstBitIndex);
      assertEquals(0x0, Val);
    }
  }

  @Test
  public void testGetLastBits32_12345678() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    int flagsField = 0x87654321;    
    int expected[] = new int[] {0x1, 0x21, 0x321, 0x4321, 0x54321, 0x654321, 0x7654321, 0x87654321};
    for (int FirstBitIndex = 4; FirstBitIndex <= 32; FirstBitIndex+=4) {
      int Val = BitFieldsUtils.getLastBits32(flagsField, FirstBitIndex);
      assertEquals(expected[FirstBitIndex/4-1], Val);
    }
  }

  @Test
  public void testGetBit32_true() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    int flagsField = ~0;
    boolean expResult = true;
    for (int Bit = 1; Bit <= 32; Bit++) {
      boolean result = BitFieldsUtils.getBit32(flagsField, Bit);
      assertEquals(expResult, result);
    }
  }
  
  @Test
  public void testGetBit32_false() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    int flagsField = 0;
    boolean expResult = false;
    for (int Bit = 1; Bit <= 32; Bit++) {
      boolean result = BitFieldsUtils.getBit32(flagsField, Bit);
      assertEquals(expResult, result);
    }
  }
  
}
