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

import java.util.HashMap;
import java.util.Map;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;
import org.junit.Test;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;

/*template <typename T> TEMPLATE*/

// Test fixture, with helper functions implemented by forwarding to global
// function overloads selected by component types of the type parameter. This
// allows all of the map implementations to be tested with shared
// implementations of helper routines.
//<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::DenseMapTest">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp", line = 78,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp -filter=__anonymous_namespace::DenseMapTest")
  //</editor-fold>
public class DenseMapTest extends /*public*/ /*::*/ADTSupportTestBase implements Destructors.ClassWithDestructor {

  /// \brief A test class that tries to check that construction and destruction
  /// occur correctly.
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::CtorTester">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp", line = 35,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp -filter=__anonymous_namespace::CtorTester")
  //</editor-fold>
  public static class CtorTester implements Destructors.ClassWithDestructor, Native.NativeComparable<CtorTester>, Native.NativePOD<CtorTester> {
    private static std.setPtr<CtorTester /*P*/ > Constructed/*J*/= new std.setPtr<CtorTester /*P*/ >();
    private int Value;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::CtorTester::CtorTester">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp", line = 40,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp -filter=__anonymous_namespace::CtorTester::CtorTester")
    //</editor-fold>
    public /*explicit*/ CtorTester() {
      this(0);
    }
    public /*explicit*/ CtorTester(int/*uint32_t*/ Value/*= 0*/) {
      /* : Value(Value)*/ 
      //START JInit
      this.Value = Value;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::CtorTester::CtorTester">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp", line = 46,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp -filter=__anonymous_namespace::CtorTester::CtorTester")
    //</editor-fold>
    public CtorTester(/*const*/CtorTester /*&*/ Arg) {
      /* : Value(Arg.Value)*/ 
      //START JInit
      this.Value = Arg.Value;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::CtorTester::~CtorTester">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp", line = 49,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp -filter=__anonymous_namespace::CtorTester::~CtorTester")
    //</editor-fold>
    public void $destroy() {
    }

    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::CtorTester::operator /*uint*/int">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp", line = 52,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp -filter=__anonymous_namespace::CtorTester::operator /*uint*/int")
    //</editor-fold>
    public long/*uint32_t*/ $long() /*const*/ {
      return Value;
    }

    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::CtorTester::getValue">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp", line = 54,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp -filter=__anonymous_namespace::CtorTester::getValue")
    //</editor-fold>
    public int getValue() /*const*/ {
      return Value;
    }

    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::CtorTester::operator==">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp", line = 55,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp -filter=__anonymous_namespace::CtorTester::operator==")
    //</editor-fold>
    public boolean $eq(/*const*/CtorTester /*&*/ RHS) /*const*/ {
      return Value == RHS.Value;
    }
    
    @Override
    public boolean $noteq(CtorTester other) {
      return !$eq(other);
    }

    ////////////////////////////////////////////////////////////////////////////
    // For test purposes
    
    @Override
    public int hashCode() {
      return (int)CtorTesterMapInfo.INSTANCE.getHashValue(this);
    }

    @Override
    public boolean equals(Object obj) {
      return CtorTesterMapInfo.INSTANCE.isEqual(this, (CtorTester)obj);
    }

    @Override
    public CtorTester $assign(CtorTester value) {
      this.Value = value.Value;
      return this;
    }

    @Override
    public CtorTester clone() {
      return new CtorTester(this);
    }
  }  

  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::CtorTesterMapInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp", line = 60,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp -filter=__anonymous_namespace::CtorTesterMapInfo")
  //</editor-fold>
  public static class/*struct*/ CtorTesterMapInfo implements DenseMapInfo<CtorTester> {
    
    public static final CtorTesterMapInfo INSTANCE = new CtorTesterMapInfo();
    
    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::CtorTesterMapInfo::getEmptyKey">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp", line = 61,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp -filter=__anonymous_namespace::CtorTesterMapInfo::getEmptyKey")
    //</editor-fold>
    @Override
    public /*inline*/ Object getEmptyKey() {
      return Empty;
    }
    private static final CtorTester Empty = new CtorTester(-1);

    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::CtorTesterMapInfo::getTombstoneKey">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp", line = 62,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp -filter=__anonymous_namespace::CtorTesterMapInfo::getTombstoneKey")
    //</editor-fold>
    @Override
    public /*inline*/ Object getTombstoneKey() {
      return Tombstone;
    }
    private static final CtorTester Tombstone = new CtorTester(-2);

    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::CtorTesterMapInfo::getHashValue">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp", line = 63,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp -filter=__anonymous_namespace::CtorTesterMapInfo::getHashValue")
    //</editor-fold>
    @Override
    public /*uint*/int getHashValue(/*const*/CtorTester /*&*/ Val) {
      assert Val != Empty : "must not be called for emptyKey";
      assert Val != Tombstone : "must not be called for tombstoneKey";      
      return ((CtorTester) Val).getValue() * 37/*U*/;
    }

    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::CtorTesterMapInfo::isEqual">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp", line = 66,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp -filter=__anonymous_namespace::CtorTesterMapInfo::isEqual")
    //</editor-fold>
    @Override
    public boolean isEqual(/*const*/CtorTester /*&*/ LHS, /*const*/CtorTester /*&*/ RHS) {
      assert LHS != Empty : "LHS: must not be called for emptyKey";
      assert LHS != Tombstone : "LHS: must not be called for tombstoneKey";    
      assert RHS != Empty : "RHS: must not be called for emptyKey";
      assert RHS != Tombstone : "RHS: must not be called for tombstoneKey";        
      return Native.$eq((CtorTester)LHS, (CtorTester)RHS);
    }

    @Override
    public boolean isKeyPointerLike() {
      return false;
    }
  }
    
  CtorTester getTestKey(int i, CtorTester obj) { return new CtorTester(i); }
  
  CtorTester getTestValue(int i, CtorTester obj) { return new CtorTester(42 + i); }
  
  
/*protected:*/
  protected DenseMap<CtorTester, CtorTester> Map = new DenseMap<CtorTester, CtorTester>(new CtorTesterMapInfo(), new CtorTester());
  protected static CtorTester /*P*/ /*const*/ dummy_key_ptr = null;
  protected static CtorTester /*P*/ /*const*/ dummy_value_ptr = null;
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::DenseMapTest::getKey">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp", line = 86,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp -filter=__anonymous_namespace::DenseMapTest::getKey")
  //</editor-fold>
  protected CtorTester getKey() {
    return getKey(0);
  }
  protected CtorTester getKey(int i/*= 0*/) {
    return getTestKey(i, dummy_key_ptr);
  }

  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::DenseMapTest::getValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp", line = 89,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp -filter=__anonymous_namespace::DenseMapTest::getValue")
  //</editor-fold>
  protected  CtorTester getValue() {
    return getValue(0);
  }
  protected  CtorTester getValue(int i/*= 0*/) {
    return getTestValue(i, dummy_value_ptr);
  }

  @Override
  public void $destroy() {
    // do nothing
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
    EXPECT_FALSE(this.Map.count(this.getKey()) != 0);
    EXPECT_TRUE(this.Map.find(this.getKey()).$eq(this.Map.end()));

    EXPECT_EQ(new CtorTester(), this.Map.lookup(this.getKey()));    
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
    DenseMapIterator<CtorTester, CtorTester> it = this.Map.begin();
    EXPECT_EQ(this.getKey(), it.$star().first);
    EXPECT_EQ(this.getValue(), it.$star().second);
    it.$preInc();
    EXPECT_TRUE(it.$eq(this.Map.end()));

    // Lookup tests
    EXPECT_TRUE(this.Map.count(this.getKey()) != 0);
    EXPECT_TRUE(this.Map.find(this.getKey()).$eq(this.Map.begin()));
    EXPECT_EQ(this.getValue(), this.Map.lookup(this.getKey()));
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
    DenseMap<CtorTester, CtorTester> copyMap = new DenseMap<CtorTester, CtorTester>(this.Map);

    EXPECT_EQ(1, copyMap.size());
    EXPECT_EQ(this.getValue(), copyMap.$at(this.getKey()));
  }        
  
  // Test assignment operator method
  @Test
  public void AssignmentTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    this.Map.ref$at(this.getKey()).$set(this.getValue());
    DenseMap<CtorTester, CtorTester> copyMap = new DenseMap<CtorTester, CtorTester>(new CtorTesterMapInfo(), new CtorTester());
    copyMap.$assign(Map);

    EXPECT_EQ(1, copyMap.size());
    EXPECT_EQ(this.getValue(), copyMap.$at(this.getKey()));
  }      
  
  // Test swap method
  @Test
  public void SwapTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    this.Map.ref$at(this.getKey()).$set(this.getValue());
    DenseMap<CtorTester, CtorTester> otherMap = new DenseMap<CtorTester, CtorTester>(new CtorTesterMapInfo(), new CtorTester());

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
    boolean visited[] = new$bool(100);
    Map<CtorTester, Integer> visitedIndex = new HashMap<>();

    // Insert 100 numbers into the map
    for (int i = 0; i < 100; ++i) {
      visited[i] = false;
      visitedIndex.put(this.getKey(i), i);

      this.Map.ref$at(this.getKey(i)).$set(this.getValue(i));
    }

    // Iterate over all numbers and mark each one found.
    for (DenseMapIterator<CtorTester, CtorTester> it = this.Map.begin();
         it.$noteq(this.Map.end()); it.$preInc())
      visited[visitedIndex.get(it.$star().first)] = true;

    // Ensure every number was visited.
    for (int i = 0; i < 100; ++i)
      ASSERT_TRUE(visited[i], "Entry #" + i + " was never visited");
  }  

  
  // Key traits that allows lookup with either an unsigned or char* key;
  // In the latter case, "a" == 0, "b" == 1 and so on.
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::TestDenseMapInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp", line = 294,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp -filter=__anonymous_namespace::TestDenseMapInfo")
  //</editor-fold>
  private static class/*struct*/ TestDenseMapInfoWithAltLongKeys implements DenseMapInfo<Long> {
    private static final Long emptyKey = new Long(~0l);
    private static final Long tombstoneKey = new Long(~0l/*U*/ - 1l);
    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::TestDenseMapInfo::getEmptyKey">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp", line = 295,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp -filter=__anonymous_namespace::TestDenseMapInfo::getEmptyKey")
    //</editor-fold>
    @Override
    public /*inline*/ /*uint*/Long getEmptyKey() {
      return emptyKey;
    }

    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::TestDenseMapInfo::getTombstoneKey">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp", line = 296,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp -filter=__anonymous_namespace::TestDenseMapInfo::getTombstoneKey")
    //</editor-fold>
    @Override
    public /*inline*/ /*uint*/Long getTombstoneKey() {
      return tombstoneKey;
    }

    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::TestDenseMapInfo::getHashValue">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp", line = 297,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp -filter=__anonymous_namespace::TestDenseMapInfo::getHashValue")
    //</editor-fold>
    @Override
    public /*uint*/int getHashValue(/*const*/Long/*uint &*/ Val) {
      assert Val != emptyKey : "must not be called for emptyKey";
      assert Val != tombstoneKey : "must not be called for tombstoneKey";          
      return ((Number)Val).intValue() * 37/*U*/;
    }
    @Override
    public /*uint*/int getHashValueAlt(/*const*/Object/*uint &*/ Val) {
      assert Val != emptyKey : "must not be called for emptyKey";
      assert Val != tombstoneKey : "must not be called for tombstoneKey";          
      return (/*uint*/int)(((char$ptr)Val).$at(0) - ($('a'))) * 37/*U*/;
    }

    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::TestDenseMapInfo::isEqual">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp", line = 301,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/DenseMapTest.cpp -filter=__anonymous_namespace::TestDenseMapInfo::isEqual")
    //</editor-fold>
    @Override
    public boolean isEqual(/*const*/Long/*uint &*/ LHS, /*const*/Long/*uint &*/ RHS) {
      assert LHS != emptyKey : "LHS: must not be called for emptyKey";
      assert LHS != tombstoneKey : "LHS: must not be called for tombstoneKey";    
      assert RHS != emptyKey : "RHS: must not be called for emptyKey";
      assert RHS != tombstoneKey : "RHS: must not be called for tombstoneKey";       
      return ((Long)LHS).equals(RHS);
    }
    @Override
    public boolean isEqualAlt(/*const*/Object/*uint &*/ LHS, /*const*/Long/*uint &*/ RHS) {
      assert LHS != emptyKey : "LHS: must not be called for emptyKey";
      assert LHS != tombstoneKey : "LHS: must not be called for tombstoneKey";    
      assert RHS != emptyKey : "RHS: must not be called for emptyKey";
      assert RHS != tombstoneKey : "RHS: must not be called for tombstoneKey"; 
      return Long.valueOf((/*uint*/int)(((char$ptr)LHS).$at(0) - $('a'))).equals(RHS);
    }

    @Override
    public boolean isKeyPointerLike() {
      return true;
    }
  }

  
  // find_as() tests
  @Test
  public void FindAsTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    DenseMapTypeUInt<Long> map = new DenseMapTypeUInt<>(new TestDenseMapInfoWithAltLongKeys(), 0);
    map.ref$at(0l).$set(1);
    map.ref$at(1l).$set(2);
    map.ref$at(2l).$set(3);

    // Size tests
    EXPECT_EQ(3, map.size());

    // Normal lookup tests
    EXPECT_EQ(true, map.count(1l) != 0);
    EXPECT_EQ(1, map.find(0l).$star().second);
    EXPECT_EQ(2, map.find(1l).$star().second);
    EXPECT_EQ(3, map.find(2l).$star().second);
    EXPECT_TRUE(map.find(3l).$eq(map.end()));

    // find_as() tests
    EXPECT_EQ(1, map.find_as(NativePointer.$("a")).$star().second);
    EXPECT_EQ(2, map.find_as(NativePointer.$("b")).$star().second);
    EXPECT_EQ(3, map.find_as(NativePointer.$("c")).$star().second);
    EXPECT_TRUE(map.find_as(NativePointer.$("d")).$eq(map.end()));    
  } 
}
