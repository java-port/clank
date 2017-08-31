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

import org.clank.support.aliases.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author petrk
 */
public class PointersTest3 extends org.clank.java.JavaTestBase {

  private StringBuilder cout;

  @Before
  public void before() {
    cout = new StringBuilder();
  }

  private char$ptr createCharArray(int size) {
    char$memory array = new char$mem(new byte[size]);
    char$ptr arr = new char$ptr$heavy(array);
    for (int i = 0; i < size; i++) {
      arr.$set(i, (byte) (i % 2));
    }
    return arr;
  }

  private void dumpArray(int$ptr arr, int size) {
    cout.append("Integers: ").append(arr.$at(0));
    for (int i = 1; i < size; i++) {
      cout.append(", ").append(arr.$at(i));
    }
    cout.append("\n");
  }

  private void dumpArray(uint$ptr arr, int size) {
    cout.append("Unsigned integers: ").append(arr.$at(0));
    for (int i = 1; i < size; i++) {
      cout.append(", ").append(Unsigned.$uint2long(arr.$at(i)));
    }
    cout.append("\n");
  }

  private void dumpArray(char$ptr arr, int size) {
    cout.append("Chars: ").append(arr.$at(0));
    for (int i = 1; i < size; i++) {
      cout.append(", ").append((int) arr.$at(i));
    }
    cout.append("\n");
  }

  @Test
  public void testHeavyReinterpretChar2Int() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    final String GOLDEN_DATA = "Chars: 0, 1, 0, 1, 0, 1, 0, 1\n"
                             + "Integers: 16777472, 16777472\n"
                             + "Chars: 0, 1, 0, 2, 0, 2, 0, 1\n"
                             + "Integers: 33554688, 16777728\n";
    final int CHR_ARR_SIZE = 8;
    final int INT_ARR_SIZE = CHR_ARR_SIZE / NativeType.BYTES_IN_INT;

    char$ptr arr = createCharArray(CHR_ARR_SIZE);
    dumpArray(arr, CHR_ARR_SIZE);

    int$ptr intarr = Casts.reinterpret_cast(int$ptr.class, arr);
    dumpArray(intarr, INT_ARR_SIZE);

    int$ptr intVal = Casts.reinterpret_cast(int$ptr.class, arr.$add(2));
    intVal.$set(33554944);

    dumpArray(arr, CHR_ARR_SIZE);
    dumpArray(intarr, INT_ARR_SIZE);

    ASSERT_EQ(GOLDEN_DATA, cout.toString());
  }

  @Test
  public void testHeavyReinterpretUInt2Char() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    final String GOLDEN_DATA = "Unsigned integers: 16777472, 16777472, 2147549185, 2147549185\n" +
                               "Chars: 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, -128, 1, 0, 1, -128\n" +
                               "Unsigned integers: 16777600, 16777600, 65537, 65537\n" +
                               "Chars: -128, 1, 0, 1, -128, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0\n";
    final int UINT_ARR_SIZE = 4;
    final int CHR_ARR_SIZE = UINT_ARR_SIZE * NativeType.BYTES_IN_UINT;
    
    uint$ptr uintPtr = new uint$ptr$heavy(new int[]{16777472, 16777472, -2147418111, -2147418111});
    dumpArray(uintPtr, UINT_ARR_SIZE);

    char$ptr charPtr = Casts.reinterpret_cast(char$ptr.class, uintPtr);
    dumpArray(charPtr, CHR_ARR_SIZE);
    
    charPtr.$set(0, (byte) -128);
    charPtr.$set(4, (byte) -128);
    charPtr.$set(11, (byte) 0);
    charPtr.$set(15, (byte) 0);
    
    dumpArray(uintPtr, UINT_ARR_SIZE);
    dumpArray(charPtr, CHR_ARR_SIZE);

    ASSERT_EQ(GOLDEN_DATA, cout.toString());
  }
}


/*
#include <iostream>

#define CHR_ARR_SIZE 8
#define INT_ARR_SIZE (CHR_ARR_SIZE / sizeof(int))

char* createCharArrray() {
  char *arr = new char[CHR_ARR_SIZE];
  for (int i = 0; i < CHR_ARR_SIZE; i++) {
    arr[i] = (i % 2);
  }
  return arr;
}

void dumpArray(int *arr) {
  std::cout << "Integers: " << arr[0];
  for (int i = 1; i < INT_ARR_SIZE; i++) {
    std::cout << ", " << arr[i];
  }
  std::cout << std::endl;
}

void dumpArray(char *arr) {
  std::cout << "Chars: " << (int)arr[0];
  for (int i = 1; i < CHR_ARR_SIZE; i++) {
    std::cout << ", " << (int)arr[i];
  }
  std::cout << std::endl;
}


int main() {
  char *arr = createCharArrray();
  dumpArray(arr);
  
  int *intarr = reinterpret_cast<int*>(arr);
  dumpArray(intarr);
  
  int *intVal = reinterpret_cast<int*>(&arr[2]);
  *intVal = 33554944;

  dumpArray(arr);
  dumpArray(intarr);
  
  return 0;
} 
*/
