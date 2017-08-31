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

import org.clank.support.NativeCloneable;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author petrk
 */
public class StdUnorderedMapTest extends JavaTestBase {
  
  public static class IntKeyAndValue implements NativeCloneable<IntKeyAndValue> {
    static final std.hash<IntKeyAndValue> HashFun = (IntKeyAndValue key)->(key.field % 16);
    static final std.binary_functionBoolean<IntKeyAndValue> EqualFun = (IntKeyAndValue key1, IntKeyAndValue key2)->key1.field == key2.field;
    
    public final int field;
    
    public IntKeyAndValue() {
      this(0);
    }

    public IntKeyAndValue(int field) {
      this.field = field;
    }

    @Override
    public int hashCode() {
      int hash = 7;
      hash = 37 * hash + this.field;
      return hash;
    }

    @Override
    public IntKeyAndValue clone() {
      return new IntKeyAndValue(this.field);
    }
    
    @Override
    public boolean equals(Object obj) {
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      final IntKeyAndValue other = (IntKeyAndValue) obj;
      if (this.field != other.field) {
        return false;
      }
      return true;
    }
  }
  
  protected std.unordered_mapTypeType<IntKeyAndValue, IntKeyAndValue> Map;
  
  protected IntKeyAndValue getKey() {
    return getKey(0);
  }
  protected IntKeyAndValue getKey(int i) {
    return new IntKeyAndValue(i);
  }
  
  protected IntKeyAndValue getValue() {
    return getValue(0);
  }
  protected IntKeyAndValue getValue(int i) {
    return new IntKeyAndValue(i);
  }  
  
  @Before
  public void before() {
    this.Map = new std.unordered_mapTypeType(
            IntKeyAndValue.HashFun, // hash<K>
            IntKeyAndValue.EqualFun, // equal_to<K>
            ()->new IntKeyAndValue(0) // Supplier<V>
    );
  }
  
  // Empty map tests
  @Test
  public void EmptyIntMapTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    // Size tests
    EXPECT_EQ(0, this.Map.size());
    EXPECT_TRUE(this.Map.empty());

    // Iterator tests
    EXPECT_TRUE(this.Map.begin().$eq(this.Map.end()));

    // Lookup tests
    EXPECT_FALSE(this.Map.count(this.getKey()));
    EXPECT_TRUE(this.Map.find(this.getKey()).$eq(this.Map.end()));

    EXPECT_EQ(this.getKey(), this.Map.$at(this.getKey()));    
  }

  // A map with a single entry
  @Test
  public void SingleEntryMapTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    this.Map.ref$at(this.getKey()).$set(this.getValue());

    // Size tests
    EXPECT_EQ(1, this.Map.size());
    EXPECT_FALSE(this.Map.begin().$eq(this.Map.end()));
    EXPECT_FALSE(this.Map.empty());

    // Iterator tests
    std.unordered_mapTypeType.iterator<IntKeyAndValue, IntKeyAndValue> it = this.Map.begin();
    EXPECT_EQ(this.getKey(), it.$star().first);
    EXPECT_EQ(this.getValue(), it.$star().second);
    it.$preInc();
    EXPECT_TRUE(it.$eq(this.Map.end()));

    // Lookup tests
    EXPECT_TRUE(this.Map.count(this.getKey()));
    EXPECT_TRUE(this.Map.find(this.getKey()).$eq(this.Map.begin()));
    EXPECT_EQ(this.getValue(), this.Map.$at(this.getKey()));
  }  
  
  // Test clear() method
  @Test
  public void ClearTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    this.Map.ref$at(this.getKey()).$set(this.getValue());
    this.Map.clear();

    EXPECT_EQ(0, this.Map.size());
    EXPECT_TRUE(this.Map.empty());
    EXPECT_TRUE(this.Map.begin().$eq(this.Map.end()));
  }    
  
  // Test erase(iterator) method
  @Test
  public void EraseTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    this.Map.ref$at(this.getKey()).$set(this.getValue());
    this.Map.erase(this.Map.begin());

    EXPECT_EQ(0, this.Map.size());
    EXPECT_TRUE(this.Map.empty());
    EXPECT_TRUE(this.Map.begin().$eq(this.Map.end()));
  } 
  
  // Test erase(value) method
  @Test
  public void EraseTest2() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    this.Map.ref$at(this.getKey()).$set(this.getValue());
    this.Map.erase(this.getKey());

    EXPECT_EQ(0, this.Map.size());
    EXPECT_TRUE(this.Map.empty());
    EXPECT_TRUE(this.Map.begin().$eq(this.Map.end()));
  }     
  
  // Test insert() method
  @Test
  public void InsertTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    this.Map.insert(std.make_pair(this.getKey(), this.getValue()));
    EXPECT_EQ(1, this.Map.size());
    EXPECT_EQ(this.getValue(), this.Map.$at(this.getKey()));
  }       

  // Test copy constructor method
  @Test
  public void CopyConstructorTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    this.Map.ref$at(this.getKey()).$set(this.getValue());
    std.unordered_mapTypeType<IntKeyAndValue, IntKeyAndValue> copyMap = new std.unordered_mapTypeType(this.Map);

    EXPECT_EQ(1, copyMap.size());
    EXPECT_EQ(this.getValue(), copyMap.$at(this.getKey()));
  }        
  
  // Test assignment operator method
  @Test
  public void AssignmentTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    this.Map.ref$at(this.getKey()).$set(this.getValue());
    std.unordered_mapTypeType<IntKeyAndValue, IntKeyAndValue> copyMap = new std.unordered_mapTypeType(IntKeyAndValue.HashFun, IntKeyAndValue.EqualFun, ()->new IntKeyAndValue());
    copyMap.$assign(Map);

    EXPECT_EQ(1, copyMap.size());
    EXPECT_EQ(this.getValue(), copyMap.$at(this.getKey()));
  }      
  
  // Test swap method
  @Test
  public void SwapTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    this.Map.ref$at(this.getKey()).$set(this.getValue());
    std.unordered_mapTypeType<IntKeyAndValue, IntKeyAndValue> otherMap = new std.unordered_mapTypeType(IntKeyAndValue.HashFun, IntKeyAndValue.EqualFun, ()->new IntKeyAndValue());

    this.Map.swap(otherMap);
    EXPECT_EQ(0, this.Map.size());
    EXPECT_TRUE(this.Map.empty());
    EXPECT_EQ(1, otherMap.size());
    EXPECT_EQ(this.getValue(), otherMap.$at(this.getKey()));

    this.Map.swap(otherMap);
    EXPECT_EQ(0, otherMap.size());
    EXPECT_TRUE(otherMap.empty());
    EXPECT_EQ(1, this.Map.size());
    EXPECT_EQ(this.getValue(), this.Map.$at(this.getKey()));

    // Make this more interesting by inserting 100 numbers into the map.
    for (int i = 0; i < 100; ++i)
      this.Map.ref$at(this.getKey(i)).$set(this.getValue(i));

    this.Map.swap(otherMap);
    EXPECT_EQ(0, this.Map.size());
    EXPECT_TRUE(this.Map.empty());
    EXPECT_EQ(100, otherMap.size());
    for (int i = 0; i < 100; ++i)
      EXPECT_EQ(this.getValue(i), otherMap.$at(this.getKey(i)));

    this.Map.swap(otherMap);
    EXPECT_EQ(0, otherMap.size());
    EXPECT_TRUE(otherMap.empty());
    EXPECT_EQ(100, this.Map.size());
    for (int i = 0; i < 100; ++i)
      EXPECT_EQ(this.getValue(i), this.Map.$at(this.getKey(i)));
  }
  
  // A more complex iteration test
  @Test
  public void IterationTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    boolean visited[] = new boolean[100];
    Map<IntKeyAndValue, Integer> visitedIndex = new HashMap<>();

    // Insert 100 numbers into the map
    for (int i = 0; i < 100; ++i) {
      visited[i] = false;
      visitedIndex.put(this.getKey(i), i);

      this.Map.ref$at(this.getKey(i)).$set(this.getValue(i));
    }

    // Iterate over all numbers and mark each one found.
    for (std.unordered_mapTypeType.iterator<IntKeyAndValue, IntKeyAndValue> it = this.Map.begin();
         it.$noteq(this.Map.end()); it.$preInc())
      visited[visitedIndex.get(it.$star().first)] = true;

    // Ensure every number was visited.
    for (int i = 0; i < 100; ++i)
      ASSERT_TRUE(visited[i], "Entry #" + i + " was never visited");
  }    
  
  @Test
  public void ErasureTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    Map.insert(std.make_pair_T_T(getKey(1), getValue(1)));
    Map.insert(std.make_pair_T_T(getKey(2), getValue(2)));
    Map.insert(std.make_pair_T_T(getKey(3), getValue(3)));
    Map.insert(std.make_pair_T_T(getKey(4), getValue(4)));
    Map.insert(std.make_pair_T_T(getKey(5), getValue(5)));
    Map.insert(std.make_pair_T_T(getKey(6), getValue(6)));
    for (std.unordered_mapTypeType.iterator<IntKeyAndValue, IntKeyAndValue> it = this.Map.begin();
         it.$noteq(this.Map.end());) {
      if ((it.$arrow().first.field % 2) == 1) {
        it = this.Map.erase(it);
      } else {
        it.$preInc();
      }
    }
    StringBuilder sb = new StringBuilder();
    boolean addSpace = false;
    for (std.pairTypeType<IntKeyAndValue, IntKeyAndValue> p : this.Map) {
      if (addSpace) {
        sb.append(" ");
      }
      sb.append(p.second.field);
      addSpace = true;
    }
    EXPECT_EQ("2 4 6", sb.toString());
  }
}
