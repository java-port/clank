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

import org.clank.support.Native;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.NativeCloneable;
import org.clank.support.NativePointer;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.junit.Test;

/**
 *
 * @author petrk
 */
public class StdAlgoTest extends JavaTestBase {
  
  private static class Data implements Native.ComparableLower, NativeCloneable<Data> {
    
    public final int value;
    
    public Data(int value) {
      this.value = value;
    }

    @Override
    public boolean $less(Object obj) {
      return value < ((Data) obj).value;
    }

    @Override
    public Data clone() {
      return new Data(this.value);
    }
    
    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }
  
  @Test
  public void testSetIntersection() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vector<Data> vec1 = new std.vector<>(new Data(0));
    std.vector<Data> vec2 = new std.vector<>(new Data(0));
    std.vector<Data> result = new std.vector<>(new Data(0));
    
    vec1.push_back(new Data(1));
    vec1.push_back(new Data(3));
    vec1.push_back(new Data(5));
    
    EXPECT_EQ(3, std.distance(vec1.rbegin(), vec1.rend()));
    
    vec2.push_back(new Data(3));
    vec2.push_back(new Data(4));
    vec2.push_back(new Data(5));
    vec2.push_back(new Data(6));
    
    std.set_intersection(vec1.begin(), vec1.end(), vec2.begin(), vec2.end(), std.back_inserter(result));
    
    EXPECT_EQ(2, result.size());
    EXPECT_EQ(3, result.$at(0).value);
    EXPECT_EQ(5, result.$at(1).value);
  }
  
  @Test
  public void testReverseIteratorSub() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vector<Data> vec1 = new std.vector<>(()->new Data(0));
    vec1.push_back(new Data(1));
    vec1.push_back(new Data(2));
    vec1.push_back(new Data(3));
    std.vector<Data> vec2 = new std.vector<>(()->new Data(0));
    vec2.append(vec1.rbegin(), vec1.rend());
    ASSERT_EQ("[3, 2, 1]", asString(vec2));
  }
  
  @Test
  public void testStrncpy() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    byte buffer[] = NativePointer.new$char(64, "Hello, World!");
    char$ptr bufPtr = create_const_char$ptr(buffer);
    ASSERT_EQ("Hello, World!", Native.$toString(bufPtr));
    std.strncpy(bufPtr, "Hello", 5);
    ASSERT_EQ("Hello, World!", Native.$toString(bufPtr));
    std.strncpy(bufPtr, "Hello", 6);
    ASSERT_EQ("Hello", Native.$toString(bufPtr));
  }
  
  @Test
  public void testSscanf() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    /*char*/byte sentence[/*24*/] = new$char(24, "Rudolph is 12 years old");
    /*char*/byte str[/*20*/] = new$char(20);
    int$ptr i = create_int$ptr();

    std.sscanf(create_char$ptr(sentence), $("%s %*s %d"), create_char$ptr(str), $AddrOf(i));
    ASSERT_EQ("Rudolph", Native.$toString(create_char$ptr(str)));
    ASSERT_EQ(12, i.$star());
  }
}
