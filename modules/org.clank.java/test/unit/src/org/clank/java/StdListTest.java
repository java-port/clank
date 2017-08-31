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
import org.clank.support.JavaDifferentiators.JD$Move;
import org.clank.support.Native;
import org.clank.support.Native.NativePOD;
import org.clank.support.NativeMoveable;
import org.clank.support.NativeSwappable;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Vladimir Voskresensky
 */
public class StdListTest extends JavaTestBase {
  private static boolean FROZEN_MODIFICATIONS_AND_CREATIONS = false;
  private static class ListData implements Native.ComparableLower, NativePOD<ListData>, NativeMoveable<ListData>, NativeSwappable {
    private static final int MOVED_MARKER = Integer.MIN_VALUE;
    
    public int value;
    
    public ListData(int value) {
      assert !FROZEN_MODIFICATIONS_AND_CREATIONS;
      this.value = value;
    }

    public ListData(JD$Move _dparm, ListData $Prm0) {
      assert !FROZEN_MODIFICATIONS_AND_CREATIONS;
      this.value = $Prm0.value;
      $Prm0.value = MOVED_MARKER;
    }

    @Override
    public boolean $less(Object obj) {
      return value < ((ListData) obj).value;
    }

    @Override
    public ListData clone() {
      assert !FROZEN_MODIFICATIONS_AND_CREATIONS;
      return new ListData(this.value);
    }

    @Override
    public ListData move() {
      assert !FROZEN_MODIFICATIONS_AND_CREATIONS;
      return new ListData(this.value);
    }
    
    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @Override
    public void swap(NativeSwappable RHS) {
      assert !FROZEN_MODIFICATIONS_AND_CREATIONS;
      ListData other = (ListData)RHS;
      int aValue = this.value;
      this.value = other.value;
      other.value = aValue;
    }

    @Override
    public ListData $assign(ListData $Prm0) {
      assert !FROZEN_MODIFICATIONS_AND_CREATIONS;
      this.value = $Prm0.value;
      return this;
    }
    
    @Override
    public ListData $assignMove(ListData $Prm0) {
      assert !FROZEN_MODIFICATIONS_AND_CREATIONS;
      this.value = $Prm0.value;
      $Prm0.value = MOVED_MARKER;
      return this;
    }
  }  

  @Before
  @Override
  public void SetUp() {
    FROZEN_MODIFICATIONS_AND_CREATIONS = false;
  }
  
  @Test
  public void testSortList() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.list<ListData> list = new std.list<>(new ListData(0));
    list.push_back(new ListData(2));
    list.push_back(new ListData(1));
    EXPECT_EQ(2, list.size());
    EXPECT_EQ(2, list.front().value);
    EXPECT_EQ(1, list.back().value);    
    FROZEN_MODIFICATIONS_AND_CREATIONS = true;
    list.sort(new Compare<ListData>() {
      @Override
      public boolean compare(ListData a, ListData b) {
        return a.$less(b);
      }
    });
    EXPECT_EQ(2, list.size());
    EXPECT_EQ(1, list.front().value);
    EXPECT_EQ(2, list.back().value);
  }
  
  @Test
  public void testIterateAndModifyList() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.list<ListData> list = new std.list<>(new ListData(0));
    list.push_back(new ListData(1));
    list.push_back(new ListData(2));
    list.push_back(new ListData(3));
    int iteration = -1;
    for (std.list.iterator<ListData> I = list.begin(), E = list.end(); I.$noteq(E);) {
      iteration++;
      ListData atI = I.$star();
      std.list.iterator<ListData> NextI = new std.list.iterator<>(I);
      NextI.$preInc();
      if (iteration == 0) {
        EXPECT_EQ(1, atI.value);
        // on the first iteration we remove middle element and continue from zero
        EXPECT_EQ(3, list.size());
        EXPECT_EQ(2, NextI.$arrow().value);
        list.erase(new std.list.iterator<>(NextI));
        EXPECT_EQ(2, list.size());
        EXPECT_EQ(1, list.front().value);
        EXPECT_EQ(3, list.back().value);
        // end doesn't move in std::list even after erase
        ASSERT_TRUE(E.$eq(list.end()));
        continue;
      } else if (iteration == 1) {
        EXPECT_EQ(1, atI.value);
        // on the second iterator we just advance to the last element in list
        EXPECT_EQ(2, list.size());
        EXPECT_EQ(1, list.front().value);
        EXPECT_EQ(3, list.back().value);
        I.$preInc();
        ASSERT_TRUE(NextI.$eq(I));
        NextI.$preInc();
        ASSERT_TRUE(NextI.$eq(E));
        ASSERT_TRUE(E.$eq(NextI));
        continue;
      } else if (iteration == 2) {
        EXPECT_EQ(3, atI.value);
        // now let's push_back one more element
        ASSERT_TRUE(NextI.$eq(E));
        ASSERT_TRUE(E.$eq(NextI));
        I.$preInc();
        ASSERT_TRUE(E.$eq(I));
        ASSERT_TRUE(I.$eq(E));
        EXPECT_EQ(2, list.size());
        list.push_back(new ListData(4));
        EXPECT_EQ(3, list.size());
        continue;
      }
      I.$preInc();
    }
    EXPECT_EQ(3, list.size());
    EXPECT_EQ(2, iteration);
  }
  
  @Test
  public void testForEachAndModifyList() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.list<ListData> list = new std.list<>(new ListData(0));    
    list.push_back(new ListData(1));
    list.push_back(new ListData(2));
    list.push_back(new ListData(3));
    int iteration = -1;
    for (ListData atI : list) {
      iteration++;
      if (iteration == 0) {
        EXPECT_EQ(1, atI.value);
        // on the first iteration we remove middle element and continue from zero
        list.erase(list.begin().$preInc());
        EXPECT_EQ(2, list.size());
        EXPECT_EQ(1, list.front().value);
        EXPECT_EQ(3, list.back().value);
      } else if (iteration == 1) {
        EXPECT_EQ(3, atI.value);
        // on the second iterator we add two more elements
        EXPECT_EQ(2, list.size());
        EXPECT_EQ(1, list.front().value);
        EXPECT_EQ(3, list.back().value);
        list.push_back(new ListData(4));
        list.push_back(new ListData(5));
      } else if (iteration == 2) {
        // added elements have to be visible 
        EXPECT_EQ(4, atI.value);
      } else if (iteration == 3) {
        // added elements have to be visible 
        EXPECT_EQ(5, atI.value);
      }
    }    
    EXPECT_EQ(3, iteration);
  }
}
