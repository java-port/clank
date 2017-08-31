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

/**
 *
 * @author Vladimir Voskresensky
 */
public final class BitFieldsUtils {

  private BitFieldsUtils() {
  }
  
  public static int setLastBits32(int flagsField, final int LastBits, final int Value) {
    assert LastBits <= 32 : LastBits;
    int LHSMask = LastBits == 32 ? 0 : (~0) << LastBits;
    assert (Value & LHSMask) == 0 : "using more than " + LastBits + " in " + Integer.toBinaryString(Value);
    flagsField = setLastMaskedBits32(flagsField, LHSMask, Value);
    assert getLastBits32(flagsField, LastBits) == Value : Value + " vs " + getLastBits32(flagsField, LastBits);
    return flagsField;
  }
  
  public static long setLastBits64(long flagsField, final int LastBits, final long Value) {
    assert LastBits <= 64 : LastBits;
    long LHSMask = LastBits == 64 ? 0L : (~0L) << LastBits;
    assert (Value & LHSMask) == 0L : "using more than " + LastBits + " in " + Long.toBinaryString(Value);
    flagsField = setLastMaskedBits64(flagsField, LHSMask, Value);
    assert getLastBits64(flagsField, LastBits) == Value : Value + " vs " + getLastBits64(flagsField, LastBits);
    return flagsField;
  }

  public static int setLastMaskedBits32(int flagsField, final int ClearOldValueMask, final int Value) {
    assert (Value & ClearOldValueMask) == 0 : "using more bits than in " + ClearOldValueMask + " for " + Integer.toBinaryString(Value);
    flagsField = (flagsField & ClearOldValueMask) | Value;
    assert getLastMaskedBits32(flagsField, ~ClearOldValueMask) == Value : Value + " vs " + getLastMaskedBits32(flagsField, ~ClearOldValueMask);
    return flagsField;
  }

  public static long setLastMaskedBits64(long flagsField, final long ClearOldValueMask, final long Value) {
    assert (Value & ClearOldValueMask) == 0 : "using more bits than in " + ClearOldValueMask + " for " + Long.toBinaryString(Value);
    flagsField = (flagsField & ClearOldValueMask) | Value;
    assert getLastMaskedBits64(flagsField, ~ClearOldValueMask) == Value : Value + " vs " + getLastMaskedBits64(flagsField, ~ClearOldValueMask);
    return flagsField;
  }

  public static int setMiddleBits32(int flagsField, final int FirstBitIndex, final int BitsNum, final int Value) {
    final int lastBits = FirstBitIndex - BitsNum;
    assert lastBits >= 0 : " FirstBitIndex " + FirstBitIndex + " less than BitsNum " + BitsNum;
    // keep the value after middle part
    int afterLastBitsValue = (lastBits == 0) ? 0 : getLastBits32(flagsField, lastBits);
    flagsField = setLastBits32(flagsField, FirstBitIndex, Value << lastBits) | afterLastBitsValue;
    assert getMiddleBits32(flagsField, FirstBitIndex, BitsNum) == Value : Value + " vs " + getMiddleBits32(flagsField, FirstBitIndex, BitsNum);
    return flagsField;
  }

  public static long setMiddleBits64(long flagsField, final int FirstBitIndex, final int BitsNum, final long Value) {
    final int lastBits = FirstBitIndex - BitsNum;
    assert lastBits >= 0 : " FirstBitIndex " + FirstBitIndex + " less than BitsNum " + BitsNum;
    // keep the value after middle part
    long afterLastBitsValue = (lastBits == 0) ? 0L : getLastBits64(flagsField, lastBits);
    flagsField = setLastBits64(flagsField, FirstBitIndex, Value << lastBits) | afterLastBitsValue;
    assert getMiddleBits64(flagsField, FirstBitIndex, BitsNum) == Value : Value + " vs " + getMiddleBits64(flagsField, FirstBitIndex, BitsNum);
    return flagsField;
  }
  
  public static int setBit32(int flagsField, int Bit, boolean val) {
    assert Bit <= 32 : Bit;
    int Mask = (1 << Bit);
    flagsField = setMaskedBit32(flagsField, Mask, val);
    assert getBit32(flagsField, Bit) == val : val + " vs " + getBit32(flagsField, Bit);
    return flagsField;
  }

  public static long setBit64(long flagsField, int Bit, boolean val) {
    assert Bit <= 64 : Bit;
    long Mask = (1L << Bit);
    flagsField = setMaskedBit64(flagsField, Mask, val);
    assert getBit64(flagsField, Bit) == val : val + " vs " + getBit64(flagsField, Bit);
    return flagsField;
  }

  public static int setMaskedBit32(int flagsField, int Mask, boolean val) {
    assert (Mask & (Mask - 1)) == 0 : "must have only one bit" + Integer.toBinaryString(Mask);
    if (val) {
      flagsField |= Mask; 
    } else {
      flagsField &= ~Mask;
    }
    assert getMaskedBit32(flagsField, Mask) == val : val + " vs " + getMaskedBit32(flagsField, Mask);
    return flagsField;
  }

  public static long setMaskedBit64(long flagsField, long Mask, boolean val) {
    assert (Mask & (Mask - 1L)) == 0 : "must have only one bit" + Long.toBinaryString(Mask);
    if (val) {
      flagsField |= Mask; 
    } else {
      flagsField &= ~Mask;
    }
    assert getMaskedBit64(flagsField, Mask) == val : val + " vs " + getMaskedBit64(flagsField, Mask);
    return flagsField;
  }

  public static int getLastBits32(int flagsField, int LastBits) {
    assert LastBits <= 32 : LastBits;
    int Mask = LastBits == 32 ? ~0 : (1 << LastBits) - 1;
    return getLastMaskedBits32(flagsField, Mask);
  }

  public static long getLastBits64(long flagsField, int LastBits) {
    assert LastBits <= 64 : LastBits;
    long Mask = LastBits == 64 ? ~0L : (1L << LastBits) - 1L;
    return getLastMaskedBits64(flagsField, Mask);
  }

  public static int getLastMaskedBits32(int flagsField, int MaskForLastBits) {
    return (flagsField & MaskForLastBits);
  }

  public static long getLastMaskedBits64(long flagsField, long MaskForLastBits) {
    return (flagsField & MaskForLastBits);
  }

  public static int getMiddleBits32(int flagsField, int FirstBitIndex, int BitsNum) {
    final int BitsAfter = FirstBitIndex - BitsNum;
    assert BitsAfter >= 0 : (" FirstBitIndex " + FirstBitIndex + " less than BitsNum " + BitsNum);
    int Value = getLastBits32(flagsField >>> BitsAfter, BitsNum);
    return Value;
  }
  
  public static long getMiddleBits64(long flagsField, int FirstBitIndex, int BitsNum) {
    final int BitsAfter = FirstBitIndex - BitsNum;
    assert BitsAfter >= 0 : (" FirstBitIndex " + FirstBitIndex + " less than BitsNum " + BitsNum);
    long Value = getLastBits64(flagsField >>> BitsAfter, BitsNum);
    return Value;
  }
  
  public static boolean getBit32(int flagsField, int Bit) {
    assert Bit <= 32 : Bit;
    int Mask = (1 << Bit);
    return (flagsField & Mask) == Mask;
  }
  
  public static boolean getBit64(long flagsField, int Bit) {
    assert Bit <= 64 : Bit;
    long Mask = (1L << Bit);
    return (flagsField & Mask) == Mask;
  }
  
  public static boolean getMaskedBit32(int flagsField, int Mask) {
    assert (Mask & (Mask - 1)) == 0 : "must have only one bit" + Integer.toBinaryString(Mask);
    return (flagsField & Mask) == Mask;
  }
  
  public static boolean getMaskedBit64(long flagsField, long Mask) {
    assert (Mask & (Mask - 1L)) == 0 : "must have only one bit" + Long.toBinaryString(Mask);
    return (flagsField & Mask) == Mask;
  }
}
