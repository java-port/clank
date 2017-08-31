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

import java.util.HashSet;
import java.util.Set;
import org.clank.java.std;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;
import org.junit.Test;
import org.llvm.adt.aliases.*;

/**
 *
 * @author Petr Kudryavtsev <petrk@netbeans.org>
 */
public class SmallPtrSetTest extends ADTSupportTestBase {
  
  public SmallPtrSetTest() {
  }

  
  @Test
  public void GrowthTest() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  int i;
  int buf[] = new$int(8);
  for(i=0; i<8; ++i) buf[i]=0;


  SmallPtrSet<int$ptr> s = new SmallPtrSet<>(DenseMapInfoVoid$Ptr.$Info(), 4);
  
  s.insert(create_int$ptr(buf, 0));
  s.insert(create_int$ptr(buf, 1));
  s.insert(create_int$ptr(buf, 2));
  s.insert(create_int$ptr(buf, 3));
  EXPECT_EQ(4, s.size());

  i = 0;
  for(SmallPtrSetIterator<int$ptr> I=s.begin(), E=s.end(); I.$noteq(E); I.$preInc(), ++i)
      I.$star().$set$postInc(0);
  EXPECT_EQ(4, i);
  for(i=0; i<8; ++i)
      EXPECT_EQ(i<4?1:0,buf[i]);

  s.insert(create_int$ptr(buf, 4));
  s.insert(create_int$ptr(buf, 5));
  s.insert(create_int$ptr(buf, 6));
  s.insert(create_int$ptr(buf, 7));

  i = 0;
  for(SmallPtrSetIterator<int$ptr> I=s.begin(), E=s.end(); I.$noteq(E); I.$preInc(), ++i)
      I.$star().$set$postInc(0);
  EXPECT_EQ(8, i);
  s.erase(create_int$ptr(buf, 4));
  s.erase(create_int$ptr(buf, 5));
  s.erase(create_int$ptr(buf, 6));
  s.erase(create_int$ptr(buf, 7));
  EXPECT_EQ(4, s.size());

  i = 0;
  for(SmallPtrSetIterator<int$ptr> I=s.begin(), E=s.end(); I.$noteq(E); I.$preInc(), ++i)
      I.$star().$set$postInc(0);
  EXPECT_EQ(4, i);
  for(i=0; i<8; ++i)
      EXPECT_EQ(i<4?3:1,buf[i]);

  s.clear();
  for(i=0; i<8; ++i) buf[i]=0;
  for(i=0; i<128; ++i) s.insert(create_int$ptr(buf, i%8)); // test repeated entires
  EXPECT_EQ(8, s.size());
  for(SmallPtrSetIterator<int$ptr> I=s.begin(), E=s.end(); I.$noteq(E); I.$preInc(), ++i)
      I.$star().$set$postInc(0);
  for(i=0; i<8; ++i)
      EXPECT_EQ(1,buf[i]);    
  }
  
  @Test
  public void SwapTest() {  
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    int buf[] = new$int(10);

    SmallPtrSet<int$ptr> a = new SmallPtrSet<>(DenseMapInfoVoid$Ptr.$Info(), 2);
    SmallPtrSet<int$ptr> b = new SmallPtrSet<>(DenseMapInfoVoid$Ptr.$Info(), 2);

    a.insert(create_int$ptr(buf, 0));
    a.insert(create_int$ptr(buf, 1));
    b.insert(create_int$ptr(buf, 2));

    std.swap(a, b);

    EXPECT_EQ(1, a.size());
    EXPECT_EQ(2, b.size());
    EXPECT_TRUE(a.count(create_int$ptr(buf, 2)) != 0);
    EXPECT_TRUE(b.count(create_int$ptr(buf, 0)) != 0);
    EXPECT_TRUE(b.count(create_int$ptr(buf, 1)) != 0);

    b.insert(create_int$ptr(buf, 3));
    std.swap(a, b);

    EXPECT_EQ(3, a.size());
    EXPECT_EQ(1, b.size());
    EXPECT_TRUE(a.count(create_int$ptr(buf, 0)) != 0);
    EXPECT_TRUE(a.count(create_int$ptr(buf, 1)) != 0);
    EXPECT_TRUE(a.count(create_int$ptr(buf, 3)) != 0);
    EXPECT_TRUE(b.count(create_int$ptr(buf, 2)) != 0);

    std.swap(a, b);

    EXPECT_EQ(1, a.size());
    EXPECT_EQ(3, b.size());
    EXPECT_TRUE(a.count(create_int$ptr(buf, 2)) != 0);
    EXPECT_TRUE(b.count(create_int$ptr(buf, 0)) != 0);
    EXPECT_TRUE(b.count(create_int$ptr(buf, 1)) != 0);
    EXPECT_TRUE(b.count(create_int$ptr(buf, 3)) != 0);

    a.insert(create_int$ptr(buf, 4));
    a.insert(create_int$ptr(buf, 5));
    a.insert(create_int$ptr(buf, 6));

    std.swap(b, a);

    EXPECT_EQ(3, a.size());
    EXPECT_EQ(4, b.size());
    EXPECT_TRUE(b.count(create_int$ptr(buf, 2)) != 0);
    EXPECT_TRUE(b.count(create_int$ptr(buf, 4)) != 0);
    EXPECT_TRUE(b.count(create_int$ptr(buf, 5)) != 0);
    EXPECT_TRUE(b.count(create_int$ptr(buf, 6)) != 0);
    EXPECT_TRUE(a.count(create_int$ptr(buf, 0)) != 0);
    EXPECT_TRUE(a.count(create_int$ptr(buf, 1)) != 0);
    EXPECT_TRUE(a.count(create_int$ptr(buf, 3)) != 0);    
  }
  
  @Test
  public void SwapTest2() {  
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    int buf[] = new$int(10);

    SmallPtrSet<int$ptr> a = new SmallPtrSet<>(DenseMapInfoVoid$Ptr.$Info(), 2);
    SmallPtrSet<int$ptr> b = new SmallPtrSet<>(DenseMapInfoVoid$Ptr.$Info(), 2);
    
    a.insert(create_int$ptr(buf, 0));
    a.insert(create_int$ptr(buf, 1));
    b.insert(create_int$ptr(buf, 2));

    a.swap(b);

    EXPECT_EQ(1, a.size());
    EXPECT_EQ(2, b.size());
    EXPECT_TRUE(a.count(create_int$ptr(buf, 2)) != 0);
    EXPECT_TRUE(b.count(create_int$ptr(buf, 0)) != 0);
    EXPECT_TRUE(b.count(create_int$ptr(buf, 1)) != 0);

    b.insert(create_int$ptr(buf, 3));
    a.swap(b);

    EXPECT_EQ(3, a.size());
    EXPECT_EQ(1, b.size());
    EXPECT_TRUE(a.count(create_int$ptr(buf, 0)) != 0);
    EXPECT_TRUE(a.count(create_int$ptr(buf, 1)) != 0);
    EXPECT_TRUE(a.count(create_int$ptr(buf, 3)) != 0);
    EXPECT_TRUE(b.count(create_int$ptr(buf, 2)) != 0);

    a.swap(b);

    EXPECT_EQ(1, a.size());
    EXPECT_EQ(3, b.size());
    EXPECT_TRUE(a.count(create_int$ptr(buf, 2)) != 0);
    EXPECT_TRUE(b.count(create_int$ptr(buf, 0)) != 0);
    EXPECT_TRUE(b.count(create_int$ptr(buf, 1)) != 0);
    EXPECT_TRUE(b.count(create_int$ptr(buf, 3)) != 0);

    a.insert(create_int$ptr(buf, 4));
    a.insert(create_int$ptr(buf, 5));
    a.insert(create_int$ptr(buf, 6));

    b.swap(a);

    EXPECT_EQ(3, a.size());
    EXPECT_EQ(4, b.size());
    EXPECT_TRUE(b.count(create_int$ptr(buf, 2)) != 0);
    EXPECT_TRUE(b.count(create_int$ptr(buf, 4)) != 0);
    EXPECT_TRUE(b.count(create_int$ptr(buf, 5)) != 0);
    EXPECT_TRUE(b.count(create_int$ptr(buf, 6)) != 0);
    EXPECT_TRUE(a.count(create_int$ptr(buf, 0)) != 0);
    EXPECT_TRUE(a.count(create_int$ptr(buf, 1)) != 0);
    EXPECT_TRUE(a.count(create_int$ptr(buf, 3)) != 0);    
  }  
  
  private static final class TestItem {
    int var;
    
    public TestItem(int var) {
      this.var = var;
    }

    @Override
    public String toString() {
      return "" + var;
    }
  }
  
  @Test
  public void testBug267711() { 
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    TestItem first = new TestItem(1);
    TestItem second = new TestItem(2);
    TestItem third = new TestItem(3);
    SmallPtrSet<TestItem> set = new SmallPtrSet<>(new DenseMapInfo$LikePtr(new TestItem(-1), new TestItem(-2)), 2);
    for (int i = 0; i < 16; ++i) {
      set.insert(new TestItem(i));
    }
    EXPECT_EQ(16, set.size());
    Set<Integer> values = new HashSet<Integer>();
    for (SmallPtrSetIterator<TestItem> I = set.begin(), E = set.end(); I.$noteq(E); I.$preInc()) {
      EXPECT_TRUE(I.$star().var >= 0 && I.$star().var < 16);
      values.add(I.$star().var);
    }
    EXPECT_EQ(16, values.size());
  }
}
