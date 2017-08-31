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

import org.clank.java.*;
import static org.clank.java.std.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.llvm.support.llvm.*;


// Test fixture
//<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::StringMapTest">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/unittests/ADT/StringMapTest.cpp", line = 18,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/StringMapTest.cpp -filter=__anonymous_namespace::StringMapTest")
//</editor-fold>
public class StringMapTest extends ADTSupportTestBase implements Destructors.ClassWithDestructor {
  
  protected static /*const*//*char*/char$ptr testKey = NativePointer.$("key");
  protected static /*const*/int/*uint32_t*/ testValue = 1/*U*/;
  protected static /*const*/char$ptr/*char P*/ testKeyFirst = testKey;
  protected static /*size_t*/int testKeyLength = std.strlen(testKey);
  protected static /*const*/std.string testKeyStr/*J*/= new std.string(testKey);   
  
  /*protected:*/
  protected StringMapUInt/*<BumpPtrAllocator &>*/ testMap;

  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::StringMapTest::assertEmptyMap">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/StringMapTest.cpp", line = 28,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/StringMapTest.cpp -filter=__anonymous_namespace::StringMapTest::assertEmptyMap")
    //</editor-fold>
  public void assertEmptyMap() {
    // Size tests
    EXPECT_EQ(0, testMap.size());
    EXPECT_TRUE(testMap.empty());

    // Iterator tests
    EXPECT_TRUE(testMap.begin().$eq(testMap.end()));

    // Lookup tests
    EXPECT_EQ(0, testMap.count(new StringRef(testKey)));
    EXPECT_EQ(0, testMap.count(new StringRef(testKeyFirst, testKeyLength)));
    EXPECT_EQ(0, testMap.count(new StringRef(testKeyStr)));
    EXPECT_TRUE(testMap.find(new StringRef(testKey)).$eq(testMap.end()));
    EXPECT_TRUE(testMap.find(new StringRef(testKeyFirst, testKeyLength)).$eq(testMap.end()));
    EXPECT_TRUE(testMap.find(new StringRef(testKeyStr)).$eq(testMap.end()));
  }

  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::StringMapTest::assertSingleItemMap">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/StringMapTest.cpp", line = 46,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/StringMapTest.cpp -filter=__anonymous_namespace::StringMapTest::assertSingleItemMap")
    //</editor-fold>
  protected void assertSingleItemMap() {
    // Size tests
    EXPECT_EQ(1, testMap.size());
    EXPECT_FALSE(testMap.begin().$eq(testMap.end()));
    EXPECT_FALSE(testMap.empty());

    // Iterator tests
    StringMapIteratorUInt it = testMap.begin();
    EXPECT_STREQ(testKey, it.$arrow().first().data());
    EXPECT_EQ(testValue, it.$arrow().second);
    it.$preInc();
    EXPECT_TRUE(it.$eq(testMap.end()));

    // Lookup tests
    EXPECT_EQ(1, testMap.count(new StringRef(testKey)));
    EXPECT_EQ(1, testMap.count(new StringRef(testKeyFirst, testKeyLength)));
    EXPECT_EQ(1, testMap.count(new StringRef(testKeyStr)));
    EXPECT_TRUE(testMap.find(new StringRef(testKey)).$eq(testMap.begin()));
    EXPECT_TRUE(testMap.find(new StringRef(testKeyFirst, testKeyLength)).$eq(
                testMap.begin()));
    EXPECT_TRUE(testMap.find(new StringRef(testKeyStr)).$eq(testMap.begin()));
  }

  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::StringMapTest::~StringMapTest">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/StringMapTest.cpp", line = 18,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/StringMapTest.cpp -filter=__anonymous_namespace::StringMapTest::~StringMapTest")
    //</editor-fold>
  @Override public /*inline*/ void $destroy() {}

  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::StringMapTest::StringMapTest">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/StringMapTest.cpp", line = 18,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/StringMapTest.cpp -filter=__anonymous_namespace::StringMapTest::StringMapTest")
//    //</editor-fold>
  public /*inline*/ StringMapTest() {
    /* : Test(), testMap()*/ 
    //START JInit
    super();
//    this.testMap = new StringMap<Long,/*uint32_t*/ BumpPtrAllocator>(Long.class);
    //END JInit
  }
  
  @Before 
  public void setUp() {
    this.testMap = new StringMapUInt/*<BumpPtrAllocator &>*/(0);
  }
  
  @Test
  public void EmptyMapTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    assertEmptyMap();
  }

  @Test
  public void SingleEntryMapTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    testMap.ref$at(new StringRef(testKey)).$set(testValue);
    assertSingleItemMap();
  }  
  
  // Test clear() method.
  @Test
  public void ClearTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    testMap.ref$at(new StringRef(testKey)).$set(testValue);
    testMap.clear();
    assertEmptyMap();
  }
  
  // Test erase(iterator) method.
  @Test
  public void EraseIteratorTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    testMap.ref$at(new StringRef(testKey)).$set(testValue);
    testMap.erase(testMap.begin());
    assertEmptyMap();
  }  
  
  // Test erase(value) method.
  @Test
  public void EraseValueTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    testMap.ref$at(new StringRef(testKey)).$set(testValue);
    testMap.erase(new StringRef(testKey));
    assertEmptyMap();
  }  
  
  // Test inserting two values and erasing one.
  @Test
  public void InsertAndEraseTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    testMap.ref$at(new StringRef(testKey)).$set(testValue);
    testMap.ref$at(new StringRef("otherKey")).$set(2);
    testMap.erase(new StringRef("otherKey"));
    assertSingleItemMap();
  }    
  
  // Test inserting two values and erasing one.
  @Test
  public void SmallFullMapTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
//  // StringMap has a tricky corner case when the map is small (<8 buckets) and
//  // it fills up through a balanced pattern of inserts and erases. This can
//  // lead to inf-loops in some cases (PR13148) so we test it explicitly here.    
    StringMapInt/*<BumpPtrAllocator &>*/ Map = new StringMapInt(2, 0);

    Map.ref$at(new StringRef("eins")).$set(1);
    Map.ref$at(new StringRef("zwei")).$set(2);
    Map.ref$at(new StringRef("drei")).$set(3);
    Map.erase(new StringRef("drei"));
    Map.erase(new StringRef("eins"));
    Map.ref$at(new StringRef("veir")).$set(4);   
    Map.ref$at(new StringRef("funf")).$set(5);    

    EXPECT_EQ(3, Map.size());
    EXPECT_EQ(0, Map.lookup(new StringRef("eins")));
    EXPECT_EQ(2, Map.lookup(new StringRef("zwei")));
    EXPECT_EQ(0, Map.lookup(new StringRef("drei")));
    EXPECT_EQ(4, Map.lookup(new StringRef("veir")));
    EXPECT_EQ(5, Map.lookup(new StringRef("funf")));
  }      
  
  // A more complex iteration test.
  @Test
  public void IterationTest() {  
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    boolean visited[] = new$bool(100);
    
    // Insert 100 numbers into the map
    for (int i = 0; i < 100; ++i) {
      StringBuilder ss = new StringBuilder();
      ss.append("key_").append(i);
      testMap.ref$at(new StringRef(ss.toString())).$set(i);
      visited[i] = false;
    }    
    
    // Iterate over all numbers and mark each one found.
    for (StringMapIteratorUInt it = testMap.begin();
        it.$noteq(testMap.end()); it.$preInc()) {
      StringBuilder ss = new StringBuilder();
      ss.append("key_").append(it.$arrow().second);      
      ASSERT_STREQ(ss.toString(), it.$arrow().first().data());
      visited[(int)it.$arrow().second] = true;
    }

    // Ensure every number was visited.
    for (int i = 0; i < 100; ++i) {
      assertTrue("Entry #" + i + " was never visited", visited[i]);
    }    
  }

  // Test StringMapEntry::Create() method.
  @Test
  public void StringMapEntryTest() {  
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    StringMapEntry<Long> entry =
        StringMapEntry.<Long>Create(
            testKeyFirst, testKeyLength, HashString(testKeyFirst, testKeyLength), 1l);
    EXPECT_STREQ(testKey, entry.first().data());
    EXPECT_EQ(1l, entry.second);
    free(entry);    
  }  
  
  // Test insert() method.
  @Test
  public void InsertTest() {  
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    /*SCOPED_TRACE("InsertTest");*/
    testMap.insert(
        StringMapEntryUInt.Create(
            testKeyFirst, testKeyLength, HashString(testKeyFirst, testKeyLength), 
            testMap.getAllocator(), 1));
    assertSingleItemMap();
  }     
}
