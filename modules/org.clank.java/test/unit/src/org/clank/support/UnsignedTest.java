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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.clank.support;

import org.junit.Test;
import static org.clank.support.Unsigned.*;
/**
 *
 * @author Vladimir Voskresensky
 */
public class UnsignedTest extends org.clank.java.JavaTestBase {
    private static final int INT_HIGH_BIT = 1 << (Integer.SIZE - 1);
    

    public UnsignedTest() {
    }
    
    public static void main(String[] args) throws Exception {
        UnsignedTest instance = new UnsignedTest();
        instance.testUnsigned();
    }

    @Test
    public void testUnsigned() throws Exception {
        if (markAsSkippedIfNeed(TestState.Successful)) { return; }
        assert INT_HIGH_BIT < 0 : "HIGH_BIT must be negative " + INT_HIGH_BIT;
        int[][] tests = new int[][] {
            {0, 0, 0},
            {0, 1, -1},
            {1, 10, -1}
        };
        for (int[] test : tests) {
            int value1 = test[0];
            assert value1 >= 0 : "value1 must be >= 0:  " + value1;
            int value2 = test[1];
            assert value2 >= 0 : "value1 must be >= 0:  " + value2;
            int negAsBigUnsigned1 = value1 | INT_HIGH_BIT;
            assert negAsBigUnsigned1 <= 0 : "big value 1 must be >= 0: " + negAsBigUnsigned1;
            int negAsBigUnsigned2 = value2 | INT_HIGH_BIT;
            assert negAsBigUnsigned2 <= 0 : "big value 2 must be >= 0: " + negAsBigUnsigned2;
            int sign = Integer.signum(test[2]);
            final int result = Integer.signum($compare_uint(value1, value2));
            assert result == sign : "wrong result when comparing [" + value1 + " vs " + value2 + "] = " + result;
            final int reverseResult = Integer.signum($compare_uint(value2, value1));
            assert reverseResult == (-sign) : "wrong result when comparing [" + value2 + " vs " + value1 + "] = " + reverseResult;
            // now check that values with set high bit are in fact considered as unsigned, so they have to be bigger than 0 or positives
            int bigResult = Integer.signum($compare_uint(negAsBigUnsigned1, negAsBigUnsigned2));
            assert bigResult == sign : "wrong result when comparing big [" + value1 + " vs " + value2 + "] = " + bigResult;
            int reverseBigResult = Integer.signum($compare_uint(negAsBigUnsigned2, negAsBigUnsigned1));
            assert reverseBigResult == (-sign) : "wrong result when comparing big [" + value2 + " vs " + value1 + "] = " + reverseBigResult;
            int resultWhenFirstIsBig = Integer.signum($compare_uint(negAsBigUnsigned1, value1));
            assert resultWhenFirstIsBig == 1 : "unsigned are always bigger than positives [" + Long.toString(negAsBigUnsigned1) + " vs " + value1 + "] = " + resultWhenFirstIsBig;
            int resultWhenSecondIsBig = Integer.signum($compare_uint(value1, negAsBigUnsigned1));
            assert resultWhenSecondIsBig == -1 : "unsigned are always bigger than positives [" + negAsBigUnsigned1 + " vs " + value1 + "] = " + resultWhenSecondIsBig;
        }
    }

    @Test
    public void testConversion() throws Exception {
      if (markAsSkippedIfNeed(TestState.Successful)) { return; }
      assert $int2uchar(-1) == $int2uchar(255);
      assert $uchar2int($int2uchar(-1)) == $uchar2int($int2uchar(255));
      assert Integer.toBinaryString($uchar2int($int2uchar(-1))).
              equals(Integer.toBinaryString($uchar2int($int2uchar(255))));
      assert $uchar2int($int2uchar(128)) == 128;
      assert Integer.toBinaryString(128).equals(Integer.toBinaryString($uchar2int($int2uchar(128))));
      long longFromMAX_INT = $uint2long(Integer.MAX_VALUE);
      long longFromMIN_INT = $uint2long(Integer.MIN_VALUE);
      long longFromZero_INT = $uint2long(0);
      assert longFromMAX_INT > 0;
      assert longFromMIN_INT > 0;
      assert longFromZero_INT == 0;
      assert longFromZero_INT < longFromMAX_INT;
      assert longFromMAX_INT < longFromMIN_INT;
      assert $long2uint(longFromMAX_INT) == Integer.MAX_VALUE;
      assert $long2uint(longFromMIN_INT) == Integer.MIN_VALUE;
      assert $long2uint(longFromZero_INT) == 0;
      assert $uint2long(10 - 12) > Integer.MAX_VALUE;
    }
    
    /**
     * Test of compare method, of class 
     */
//    @org.junit.Test
//    public void testCompare() {
//  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
//        System.out.println("compare");
//        int u1 = 0;
//        int u2 = 0;
//        int expResult = 0;
//        int result = compare(u1, u2);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
