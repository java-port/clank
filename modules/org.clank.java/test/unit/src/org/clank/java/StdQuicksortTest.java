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


package org.clank.java;

import java.util.Arrays;
import java.util.Comparator;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.type$ptr;
import org.junit.Test;

/**
 *
 * @author Petr Kudryavtsev <petrk@netbeans.org>
 */
public class StdQuicksortTest extends JavaTestBase {
  
  private static final Comparator<Integer> INC_COMPARATOR = new Comparator<Integer>() {

    @Override
    public int compare(Integer o1, Integer o2) {
      return o1 - o2;
    }
      
  };
  
  private static final Comparator<Integer> DEC_COMPARATOR = new Comparator<Integer>() {

    @Override
    public int compare(Integer o1, Integer o2) {
      return o2 - o1;
    }
      
  };  
  
  private static final std.Compare<Integer> INC_COMPARE = new std.Compare<Integer>() {

    @Override
    public boolean compare(Integer o1, Integer o2) {
      return o1 < o2;
    }
      
  };
  
  private static final std.Compare<Integer> DEC_COMPARE = new std.Compare<Integer>() {

    @Override
    public boolean compare(Integer o1, Integer o2) {
      return o2 < o1;
    }
      
  };  
  
  
  @Test
  public void testOneElement() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    Integer array[] = new Integer[]{5};
    std.qsort(create_type$ptr(array), array.length, -1, INC_COMPARATOR);
    EXPECT_EQ("[5]", Arrays.toString(array));
  }
  
  @Test
  public void testOneElement2() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    Integer array[] = new Integer[]{5};
    final type$ptr<Integer> ptr = create_type$ptr(array);
    std.stable_sort(ptr, ptr.$add(array.length), INC_COMPARE);
    EXPECT_EQ("[5]", Arrays.toString(array));
  }
  
  @Test
  public void testFewElements() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    // in StdQuicksort MAX_THRESH is 4, make sure sort works
    Integer array[] = new Integer[]{5, 7};
    std.qsort(create_type$ptr(array), array.length, -1, INC_COMPARATOR);
    EXPECT_EQ("[5, 7]", Arrays.toString(array));
    array = new Integer[]{7, 5};
    std.qsort(create_type$ptr(array), array.length, -1, INC_COMPARATOR);
    EXPECT_EQ("[5, 7]", Arrays.toString(array));
    array = new Integer[]{5, 7, 4};
    std.qsort(create_type$ptr(array), array.length, -1, INC_COMPARATOR);
    EXPECT_EQ("[4, 5, 7]", Arrays.toString(array));
    array = new Integer[]{5, 7, 4, 2};
    std.qsort(create_type$ptr(array), array.length, -1, INC_COMPARATOR);
    EXPECT_EQ("[2, 4, 5, 7]", Arrays.toString(array));
    array = new Integer[]{5, 7, 4, 2, 8};
    std.qsort(create_type$ptr(array), array.length, -1, INC_COMPARATOR);
    EXPECT_EQ("[2, 4, 5, 7, 8]", Arrays.toString(array));
  }
  
  @Test
  public void testFewElements2() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    // in StdQuicksort MAX_THRESH is 4, make sure sort works
    Integer array[] = new Integer[]{5, 7};
    type$ptr<Integer> ptr = create_type$ptr(array);
    std.stable_sort(ptr, ptr.$add(array.length), INC_COMPARE);
    EXPECT_EQ("[5, 7]", Arrays.toString(array));
    array = new Integer[]{7, 5};
    ptr = create_type$ptr(array);
    std.stable_sort(ptr, ptr.$add(array.length), INC_COMPARE);
    EXPECT_EQ("[5, 7]", Arrays.toString(array));
    array = new Integer[]{5, 7, 4};
    ptr = create_type$ptr(array);
    std.stable_sort(ptr, ptr.$add(array.length), INC_COMPARE);
    EXPECT_EQ("[4, 5, 7]", Arrays.toString(array));
    array = new Integer[]{5, 7, 4, 2};
    ptr = create_type$ptr(array);
    std.stable_sort(ptr, ptr.$add(array.length), INC_COMPARE);
    EXPECT_EQ("[2, 4, 5, 7]", Arrays.toString(array));
    array = new Integer[]{5, 7, 4, 2, 8};
    ptr = create_type$ptr(array);
    std.stable_sort(ptr, ptr.$add(array.length), INC_COMPARE);
    EXPECT_EQ("[2, 4, 5, 7, 8]", Arrays.toString(array));
  }
  
  @Test
  public void testIncreasing() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    Integer array[] = new Integer[]{5, 7, 4, 2, 8, 6, 1, 9, 0, 3};
    std.qsort(create_type$ptr(array), array.length, -1, INC_COMPARATOR);
    EXPECT_EQ("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", Arrays.toString(array));
  }

  @Test
  public void testIncreasing2() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    Integer array[] = new Integer[]{5, 7, 4, 2, 8, 6, 1, 9, 0, 3};
    type$ptr<Integer> ptr = create_type$ptr(array);
    std.stable_sort(ptr, ptr.$add(array.length), INC_COMPARE);
    EXPECT_EQ("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", Arrays.toString(array));
  }
  
  @Test
  public void testDecreasing() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    Integer array[] = new Integer[]{5, 7, 4, 2, 8, 6, 1, 9, 0, 3};
    std.qsort(create_type$ptr(array), array.length, -1, DEC_COMPARATOR);
    EXPECT_EQ("[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]", Arrays.toString(array));
  }    

  @Test
  public void testDecreasing2() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    Integer array[] = new Integer[]{5, 7, 4, 2, 8, 6, 1, 9, 0, 3};
    type$ptr<Integer> ptr = create_type$ptr(array);
    std.stable_sort(ptr, ptr.$add(array.length), DEC_COMPARE);    
    EXPECT_EQ("[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]", Arrays.toString(array));
  }    
}
