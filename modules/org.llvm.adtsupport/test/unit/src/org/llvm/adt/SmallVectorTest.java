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
import static org.clank.java.stdimpl.StdString.npos;
import org.clank.support.*;
import static org.clank.support.Casts.reinterpret_cast;
import static org.clank.support.Native.$Clone;
import org.clank.support.aliases.*;
import static org.clank.support.literal_constants.$;
import org.junit.Before;
import org.junit.Test;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;

/*template <typename VectorT> TEMPLATE*/

// Test fixture class
//<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::SmallVectorTest">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp", line = 91,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp -filter=__anonymous_namespace::SmallVectorTest")
//</editor-fold>
public class SmallVectorTest/*<typename VectorT>*/  extends /*public*/  ADTSupportTestBase implements Destructors.ClassWithDestructor {

  /// A helper class that counts the total number of constructor and
  /// destructor calls.
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::Constructable">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp", line = 26,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp -filter=__anonymous_namespace::Constructable")
  //</editor-fold>
  public static class Constructable implements Native.NativeComparable<Constructable>, NativeCloneable<Constructable>, Destructors.ClassWithDestructor {
  /*private:*/
    private static int numConstructorCalls;
    private static int numDestructorCalls;
    private static int numAssignmentCalls;
    private int value;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::Constructable::Constructable">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp", line = 35,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp -filter=__anonymous_namespace::Constructable::Constructable")
    //</editor-fold>
    public Constructable() {
      /* : value(0)*/ 
      //START JInit
      this.value = 0;
      //END JInit
      ++numConstructorCalls;
    }

    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::Constructable::Constructable">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp", line = 39,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp -filter=__anonymous_namespace::Constructable::Constructable")
    //</editor-fold>
    public Constructable(int val) {
      /* : value(val)*/ 
      //START JInit
      this.value = val;
      //END JInit
      ++numConstructorCalls;
    }

    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::Constructable::Constructable">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp", line = 43,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp -filter=__anonymous_namespace::Constructable::Constructable")
    //</editor-fold>
    public Constructable(/*const*/Constructable /*&*/ src) {
      value = src.value;
      ++numConstructorCalls;
    }

    @Override
    public Constructable clone() {
      return new Constructable(value);
    }

    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::Constructable::~Constructable">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp", line = 48,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp -filter=__anonymous_namespace::Constructable::~Constructable")
    //</editor-fold>
    public void $destroy() {
      ++numDestructorCalls;
    }

    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::Constructable::operator=">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp", line = 52,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp -filter=__anonymous_namespace::Constructable::operator=")
    //</editor-fold>
    public Constructable /*&*/ $assign(/*const*/Constructable /*&*/ src) {
      value = src.value;
      ++numAssignmentCalls;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::Constructable::getValue">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp", line = 58,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp -filter=__anonymous_namespace::Constructable::getValue")
    //</editor-fold>
    public int getValue() /*const*/ {
      return Math.abs(value);
    }

    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::Constructable::reset">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp", line = 62,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp -filter=__anonymous_namespace::Constructable::reset")
    //</editor-fold>
    public static void reset() {
      numConstructorCalls = 0;
      numDestructorCalls = 0;
      numAssignmentCalls = 0;
    }

    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::Constructable::getNumConstructorCalls">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp", line = 68,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp -filter=__anonymous_namespace::Constructable::getNumConstructorCalls")
    //</editor-fold>
    public static int getNumConstructorCalls() {
      return numConstructorCalls;
    }

    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::Constructable::getNumDestructorCalls">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp", line = 72,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp -filter=__anonymous_namespace::Constructable::getNumDestructorCalls")
    //</editor-fold>
    public static int getNumDestructorCalls() {
      return numDestructorCalls;
    }

    /*friend bool operator==(const Constructable &c0, const Constructable &c1) */;
    /*friend bool operator!=(const Constructable &c0, const Constructable &c1) __attribute__((unused)) */;

    @Override
    public boolean $noteq(Constructable other) {
      return other.value != this.value;
    }

    @Override
    public boolean $eq(Constructable other) {
      return other.value == this.value;
    }
  }  

  @Override
  public void $destroy() {
    // do nothing
  }

/*protected:*/
  protected SmallVector<Constructable> theVector = new SmallVector<>(1);
  protected SmallVector<Constructable> otherVector = new SmallVector<>(1);
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::SmallVectorTest::SetUp">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp", line = 97,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp -filter=__anonymous_namespace::SmallVectorTest::SetUp")
  //</editor-fold>
  
  @Before
  public void SetUp() {
    Constructable.reset();
  }

  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::SmallVectorTest::assertEmpty">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp", line = 101,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp -filter=__anonymous_namespace::SmallVectorTest::assertEmpty")
  //</editor-fold>
  protected void assertEmpty(SmallVector<Constructable> /*&*/ v) {
      // Size tests
      EXPECT_EQ(0, v.size());
      EXPECT_TRUE(v.empty());

      // Iterator tests
      EXPECT_TRUE(v.begin().$eq(v.end()));
  }

  
  // Assert that theVector contains the specified values, in order.
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::SmallVectorTest::assertValuesInOrder">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp", line = 111,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp -filter=__anonymous_namespace::SmallVectorTest::assertValuesInOrder")
  //</editor-fold>
  protected void assertValuesInOrder(SmallVector<Constructable> /*&*/ v, /*size_t*/int size, int ... values) {
    EXPECT_EQ((int)size, v.size());
    
    for (int i = 0; i < size; ++i) {
      int value = values[(int) i];
      EXPECT_EQ(value, v.$at(i).getValue());
    }
  }

  
  // Generate a sequence of values to initialize the vector.
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::SmallVectorTest::makeSequence">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp", line = 125,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/SmallVectorTest.cpp -filter=__anonymous_namespace::SmallVectorTest::makeSequence")
  //</editor-fold>
  protected void makeSequence(SmallVector<Constructable> /*&*/ v, int start, int end) {
    for (int i = start; i <= end; ++i) {
      v.push_back(new Constructable(i));
    }
  }

  // New vector test.
  @Test 
  public void EmptyVectorTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
//    SCOPED_TRACE("EmptyVectorTest");
    this.assertEmpty(this.theVector);
    EXPECT_TRUE(this.theVector.rbegin().$eq(this.theVector.rend()));
    EXPECT_EQ(0, Constructable.getNumConstructorCalls());
    EXPECT_EQ(0, Constructable.getNumDestructorCalls());    
  }

  // Simple insertions and deletions.
  @Test 
  public void PushPopTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    // Track whether the vector will potentially have to grow.
    boolean RequiresGrowth = this.theVector.capacity() < 3;

    // Push an element
    this.theVector.push_back(new Constructable(1));

    // Size tests
    this.assertValuesInOrder(this.theVector, 1, 1);
    EXPECT_FALSE(this.theVector.begin().$eq(this.theVector.end()));
    EXPECT_FALSE(this.theVector.empty());

    // Push another element
    this.theVector.push_back(new Constructable(2));
    this.assertValuesInOrder(this.theVector, 2, 1, 2);

    // Insert at beginning
    this.theVector.insert(this.theVector.begin(), this.theVector.$at(1));
    this.assertValuesInOrder(this.theVector, 3, 2, 1, 2);

    // Pop one element
    this.theVector.pop_back();
    this.assertValuesInOrder(this.theVector, 2, 2, 1);

    // Pop remaining elements
    this.theVector.pop_back();
    this.theVector.pop_back();
    this.assertEmpty(this.theVector);

    // Check number of constructor calls. Should be 2 for each list element,
    // one for the argument to push_back, one for the argument to insert,
    // and one for the list element itself.
//    if (!RequiresGrowth) {
//      EXPECT_EQ(5, Constructable.getNumConstructorCalls());
//      EXPECT_EQ(5, Constructable.getNumDestructorCalls());
//    } else {
//      // If we had to grow the vector, these only have a lower bound, but should
//      // always be equal.
//      EXPECT_LE(5, Constructable.getNumConstructorCalls());
//      EXPECT_EQ(Constructable.getNumConstructorCalls(),
//                Constructable.getNumDestructorCalls());
//    }    
  }  
  
  @Test 
  public void ClearTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    //SCOPED_TRACE("ClearTest");

    this.theVector.reserve(2);
    this.makeSequence(this.theVector, 1, 2);
    this.theVector.clear();

    this.assertEmpty(this.theVector);
//    EXPECT_EQ(4, Constructable::getNumConstructorCalls());
//    EXPECT_EQ(4, Constructable::getNumDestructorCalls());
  }  

  // Resize smaller test.
  @Test
  public void ResizeShrinkTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    this.theVector.reserve(3);
    this.makeSequence(this.theVector, 1, 3);
    this.theVector.resize(1);

    this.assertValuesInOrder(this.theVector, 1, 1);
//  EXPECT_EQ(6, Constructable::getNumConstructorCalls());
//  EXPECT_EQ(5, Constructable::getNumDestructorCalls());
 
  }
  
  // Resize bigger test.
  @Test
  public void ResizeGrowTest() {  
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    //SCOPED_TRACE("ResizeGrowTest");

    this.theVector.resize(2);

    // The extra constructor/destructor calls come from the temporary object used
    // to initialize the contents of the resized array (via copy construction).
//    EXPECT_EQ(3, Constructable::getNumConstructorCalls());
//    EXPECT_EQ(1, Constructable::getNumDestructorCalls());
    EXPECT_EQ(2, this.theVector.size());    
  }
  
  // Resize with fill value.
  @Test
  public void ResizeFillTest() { 
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    //SCOPED_TRACE("ResizeFillTest");
    
    this.theVector.resize(3, new Constructable(77));
    this.assertValuesInOrder(this.theVector, 3, 77, 77, 77);    
  }  

  // Overflow past fixed size.
  @Test
  public void OverflowTest() { 
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    //SCOPED_TRACE("OverflowTest");

    // Push more elements than the fixed size.
    this.makeSequence(this.theVector, 1, 10);

    // Test size and values.
    EXPECT_EQ(10, this.theVector.size());
    for (int i = 0; i < 10; ++i) {
      EXPECT_EQ(i+1, this.theVector.$at(i).getValue());
    }

    // Now resize back to fixed size.
    this.theVector.resize(1);

    this.assertValuesInOrder(this.theVector, 1, 1);
  }

  // Iteration tests.
  @Test
  public void IterationTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    this.makeSequence(this.theVector, 1, 2);

    // Forward Iteration
    type$ptr<Constructable> it = this.theVector.begin();
    EXPECT_TRUE(it.$star().$eq(this.theVector.front()));
    EXPECT_TRUE(it.$star().$eq(this.theVector.$at(0)));
    EXPECT_EQ(1, it.$star().getValue());
    it.$preInc();
    EXPECT_TRUE(it.$star().$eq(this.theVector.$at(1)));
    EXPECT_TRUE(it.$star().$eq(this.theVector.back()));
    EXPECT_EQ(2, it.$star().getValue());
    it.$preInc();
    EXPECT_TRUE(it.$eq(this.theVector.end()));
    it.$preDec();
    EXPECT_TRUE(it.$star().$eq(this.theVector.$at(1)));
    EXPECT_EQ(2, it.$star().getValue());
    it.$preDec();
    EXPECT_TRUE(it.$star().$eq(this.theVector.$at(0)));
    EXPECT_EQ(1, it.$star().getValue());

    // Reverse Iteration
    std.reverse_iterator<Constructable> rit = this.theVector.rbegin();
    EXPECT_TRUE(rit.$star().$eq(this.theVector.$at(1)));
    EXPECT_EQ(2, rit.$star().getValue());
    rit.$preInc();
    EXPECT_TRUE(rit.$star().$eq(this.theVector.$at(0)));
    EXPECT_EQ(1, rit.$star().getValue());
    rit.$preInc();
    EXPECT_TRUE(rit.$eq(this.theVector.rend()));
    rit.$preDec();
    EXPECT_TRUE(rit.$star().$eq(this.theVector.$at(0)));
    EXPECT_EQ(1, rit.$star().getValue());
    rit.$preDec();
    EXPECT_TRUE(rit.$star().$eq(this.theVector.$at(1)));
    EXPECT_EQ(2, rit.$star().getValue());    
  }

  // Swap test.
  @Test
  public void SwapTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    //SCOPED_TRACE("SwapTest");

    this.makeSequence(this.theVector, 1, 2);
    this.theVector.swap(this.otherVector);

    this.assertEmpty(this.theVector);
    this.assertValuesInOrder(this.otherVector, 2, 1, 2);    
  }  
  
  // Swap test 2.
  @Test
  public void SwapTest2() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    // Tests swap with std.swap
    this.makeSequence(this.theVector, 1, 2);
    std.swap(this.theVector, this.otherVector);
    this.assertEmpty(this.theVector);
    this.assertValuesInOrder(this.otherVector, 2, 1, 2);    
  }    
  
  // Append test
  @Test
  public void AppendTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    //SCOPED_TRACE("AppendTest");

    this.makeSequence(this.otherVector, 2, 3);

    this.theVector.push_back(new Constructable(1));
    this.theVector.append_T(this.otherVector.begin(), this.otherVector.end());

    this.assertValuesInOrder(this.theVector, 3, 1, 2, 3);    
  }  
  
  // Append repeated test
  @Test
  public void AppendRepeatedTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    //SCOPED_TRACE("AppendRepeatedTest");

    this.theVector.push_back(new Constructable(1));
    this.theVector.append(2, new Constructable(77));
    this.assertValuesInOrder(this.theVector, 3, 1, 77, 77);    
  }
  
  // Assign test
  @Test
  public void AssignTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    //SCOPED_TRACE("AssignTest");

    this.theVector.push_back(new Constructable(1));
    this.theVector.assign(2, new Constructable(77));
    this.assertValuesInOrder(this.theVector, 2, 77, 77);
  }  

  // Erase a single element
  @Test
  public void EraseTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    //SCOPED_TRACE("EraseTest");

    this.makeSequence(this.theVector, 1, 3);
    EXPECT_EQ(3, Constructable.getNumConstructorCalls());
    EXPECT_EQ(0, Constructable.getNumDestructorCalls());       
    this.theVector.erase(this.theVector.begin());
    this.assertValuesInOrder(this.theVector, 2, 2, 3);
    EXPECT_EQ(3, Constructable.getNumConstructorCalls());
    EXPECT_EQ(0, Constructable.getNumDestructorCalls());       
  }    

  // Erase a single element
  @Test
  public void EraseTest2() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    //SCOPED_TRACE("EraseTest");

    this.makeSequence(this.theVector, 1, 3);
    EXPECT_EQ(3, Constructable.getNumConstructorCalls());
    EXPECT_EQ(0, Constructable.getNumDestructorCalls());       
    this.theVector.erase(this.theVector.$at(2));
    this.assertValuesInOrder(this.theVector, 2, 1, 2);
    EXPECT_EQ(3, Constructable.getNumConstructorCalls());
    EXPECT_EQ(0, Constructable.getNumDestructorCalls());      
    this.theVector.erase(this.theVector.$at(0));
    this.assertValuesInOrder(this.theVector, 1, 2);
    EXPECT_EQ(3, Constructable.getNumConstructorCalls());
    EXPECT_EQ(0, Constructable.getNumDestructorCalls());
  }    

  // Search a single element
  @Test
  public void SearchTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }

    this.makeSequence(this.theVector, 1, 3);
    EXPECT_TRUE(this.theVector.contains(this.theVector.$at(0)));
    EXPECT_TRUE(this.theVector.contains(this.theVector.$at(1)));
    EXPECT_TRUE(this.theVector.contains(this.theVector.$at(2)));
    EXPECT_FALSE(this.theVector.contains(new Constructable(0)));
    EXPECT_FALSE(this.theVector.contains(new Constructable(1)));
    EXPECT_FALSE(this.theVector.contains(new Constructable(2)));
  }    

  // Search a single element
  @Test
  public void SearchTest2() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }

    this.makeSequence(this.theVector, 1, 3);
    EXPECT_TRUE(this.theVector.find(this.theVector.$at(0)) == 0);
    EXPECT_TRUE(this.theVector.find(this.theVector.$at(1)) == 1);
    EXPECT_TRUE(this.theVector.find(this.theVector.$at(2)) == 2);
    EXPECT_TRUE(this.theVector.find(new Constructable(0)) == npos);
    EXPECT_TRUE(this.theVector.find(new Constructable(1)) == npos);
    EXPECT_TRUE(this.theVector.find(new Constructable(2)) == npos);
  }    

  // Erase a range of elements
  @Test
  public void EraseRangeTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    //SCOPED_TRACE("EraseRangeTest");

    this.makeSequence(this.theVector, 1, 3);
    this.theVector.erase(this.theVector.begin(), this.theVector.begin().$add(2));
    this.assertValuesInOrder(this.theVector, 1, 3);    
  }
  
  // Insert a single element.
  @Test
  public void InsertTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    //SCOPED_TRACE("InsertTest");

    this.makeSequence(this.theVector, 1, 3);
    type$ptr<Constructable> I =
      this.theVector.insert(this.theVector.begin().$add(1), new Constructable(77));
    EXPECT_EQ_ITER(this.theVector.begin().$add(1), I);
    this.assertValuesInOrder(this.theVector, 4, 1, 77, 2, 3);    
  }

  // Insert repeated elements.
  @Test
  public void InsertRepeatedTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    //SCOPED_TRACE("InsertRepeatedTest");

    this.makeSequence(this.theVector, 10, 15);
    type$ptr<Constructable> I =
      this.theVector.insert(this.theVector.begin().$add(1), 2, new Constructable(16));
    EXPECT_EQ_ITER(this.theVector.begin().$add(1), I);
    this.assertValuesInOrder(this.theVector, 8,
                        10, 16, 16, 11, 12, 13, 14, 15);

    // Insert at end.
    I = this.theVector.insert(this.theVector.end(), 2, new Constructable(16));
    EXPECT_EQ_ITER(this.theVector.begin().$add(8), I);
    this.assertValuesInOrder(this.theVector, 10,
                        10, 16, 16, 11, 12, 13, 14, 15, 16, 16);

    // Empty insert.
    EXPECT_EQ_ITER(this.theVector.end(),
              this.theVector.insert(this.theVector.end(),
                                     0, new Constructable(42)));
    EXPECT_EQ_ITER(this.theVector.begin().$add(1),
              this.theVector.insert(this.theVector.begin().$add(1),
                                     0, new Constructable(42)));    
  }  
  
  @Test
  public void InsertRangeTest() {  
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    //SCOPED_TRACE("InsertRangeTest");

    Constructable Arr[] = new Constructable[] 
      { new Constructable(77), new Constructable(77), new Constructable(77) };

    this.makeSequence(this.theVector, 1, 3);
    type$ptr<Constructable> I =
      this.theVector.insert(this.theVector.begin().$add(1), NativePointer.create_type$ptr(Arr), NativePointer.create_type$ptr(Arr).$add(3));
    EXPECT_EQ_ITER(this.theVector.begin().$add(1), I);
    this.assertValuesInOrder(this.theVector, 6, 1, 77, 77, 77, 2, 3);

    // Insert at end.
    I = this.theVector.insert(this.theVector.end(), NativePointer.create_type$ptr(Arr), NativePointer.create_type$ptr(Arr).$add(3));
    EXPECT_EQ_ITER(this.theVector.begin().$add(6), I);
    this.assertValuesInOrder(this.theVector, 9,
                              1, 77, 77, 77, 2, 3, 77, 77, 77);

    // Empty insert.
    EXPECT_EQ_ITER(this.theVector.end(),
              this.theVector.insert(this.theVector.end(),
                                     this.theVector.begin(),
                                     this.theVector.begin()));
    EXPECT_EQ_ITER(this.theVector.begin().$add(1),
              this.theVector.insert(this.theVector.begin().$add(1),
                                     this.theVector.begin(),
                                     this.theVector.begin()));    
  }
  
  // Comparison tests.
  @Test
  public void ComparisonTest() {  
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    //SCOPED_TRACE("ComparisonTest");
    
    this.makeSequence(this.theVector, 1, 3);
    this.makeSequence(this.otherVector, 1, 3);

    EXPECT_TRUE(this.theVector.$eq(this.otherVector));
    EXPECT_FALSE(this.theVector.$noteq(this.otherVector));

    this.otherVector.clear();
    this.makeSequence(this.otherVector, 2, 4);

    EXPECT_FALSE(this.theVector.$eq(this.otherVector));
    EXPECT_TRUE(this.theVector.$noteq(this.otherVector));    
  }  
  
  // Direct array access.
  @Test
  public void DirectVectorTest() {  
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ(0, this.theVector.size());
    this.theVector.reserve(4);
    EXPECT_LE(4, this.theVector.capacity());
    //EXPECT_EQ(0, Constructable::getNumConstructorCalls());
    this.theVector.end().$set(0, new Constructable(1));
    this.theVector.end().$set(1, new Constructable(2));
    this.theVector.end().$set(2, new Constructable(3));
    this.theVector.end().$set(3, new Constructable(4));;
    this.theVector.set_size(4);
    EXPECT_EQ(4, this.theVector.size());
    //EXPECT_EQ(4, Constructable::getNumConstructorCalls());
    EXPECT_EQ(1, this.theVector.$at(0).getValue());
    EXPECT_EQ(2, this.theVector.$at(1).getValue());
    EXPECT_EQ(3, this.theVector.$at(2).getValue());
    EXPECT_EQ(4, this.theVector.$at(3).getValue());    
  }  
  
  @Test
  public void HanldeNullRanges() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    type$iterator begin = null;
    type$iterator end = null;
    SmallVector<Constructable> aVector = new SmallVector<>(1, begin, end);
    aVector.append_T(begin, end);
    // now have at least non-empty vector
    EXPECT_EQ(0, aVector.size());
    aVector.resize(1);
    EXPECT_EQ(1, aVector.size());
    aVector.insert(aVector.begin(), begin, end);
  }
  
  @Test 
  public void testFromSerializedULongStream() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    SmallVectorImplULong serializedStream = new SmallVectorULong(0);
    // leading garbage
    serializedStream.append(1, 1L);
    serializedStream.append(1, 2L);
    serializedStream.append(1, 3L);
    // emulate serialization like in ASTWriter::AddString
    final int strStart = serializedStream.size();
    final String GOLDEN = "A_B_C_D_E_F_G_H";
    char$ptr Str = $(GOLDEN);
    char$ptr From = $Clone(Str);
    char$ptr To = From.$add(std.strlen(Str));
    serializedStream.insert_iterator$T_T(serializedStream.begin().$add(strStart), From, To);
    final int StrLen = serializedStream.size() - strStart;
    // trailing garbage
    serializedStream.append(1, 4L);
    serializedStream.append(1, 5L);
    
    
    // emulate deserialization like in ASTReader::ReadString
    int Index = strStart;
    
    int ZeroLen = 0;
    final ulong$ptr fromULong = serializedStream.data().$add(Index);
    final ulong$ptr toULong = serializedStream.data().$add(Index).$add(ZeroLen);
    std.string EmptyTextFromChar = new std.string(fromULong, toULong);
    EXPECT_EQ("", EmptyTextFromChar);
    
    final int Len = StrLen;
    final ulong$ptr from = serializedStream.data().$add(Index);
    final ulong$ptr to = serializedStream.data().$add(Index).$add(Len);
    std.string NonEmptyText = new std.string(from, to);
    EXPECT_EQ(StrLen, NonEmptyText.size());
    EXPECT_EQ(GOLDEN, NonEmptyText);
  }
  
}
