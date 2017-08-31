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

import org.clank.java.std.Compare;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.create_type$ptr;
import org.junit.Test;

/**
 *
 * @author petrk
 */
public class StdSortTest extends JavaTestBase {
  
  private static final Compare<Integer> INC_COMPARATOR = new Compare<Integer>() {
    @Override
    public boolean compare(Integer a, Integer b) {
      return a < b;
    }  
  };
  
  private static final Compare<Integer> DEC_COMPARATOR = new Compare<Integer>() {

    @Override
    public boolean compare(Integer a, Integer b) {
      return a > b;
    } 
      
  };  
  
  
  @Test
  public void testIncreasing() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    Integer array[] = new Integer[]{5, 7, 4, 2, 8, 6, 1, 9, 0, 3};
    std.vector<Integer> vector = new std.vector(create_type$ptr(array), create_type$ptr(array, array.length), null);
    std.sort(vector.begin(), vector.end(), INC_COMPARATOR);
    EXPECT_EQ("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", printResult(vector.begin(), vector.end()));
  }
  
  @Test
  public void testDecreasing() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    Integer array[] = new Integer[]{5, 7, 4, 2, 8, 6, 1, 9, 0, 3};
    std.vector<Integer> vector = new std.vector(create_type$ptr(array), create_type$ptr(array, array.length), null);
    std.sort(vector.begin(), vector.end(), DEC_COMPARATOR);
    EXPECT_EQ("[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]", printResult(vector.begin(), vector.end()));
  }    
  
  private <T> String printResult(type$iterator<?, T> first, type$iterator<?, T> last) {
    StringBuilder sb = new StringBuilder("[");
    boolean firstElement = true;
    while (first.$noteq(last)) {
      if (!firstElement) {
        sb.append(", ");
      }
      sb.append(first.$star());
      first.$preInc();
      firstElement = false;
    }
    sb.append("]");
    return sb.toString();
  }
}

