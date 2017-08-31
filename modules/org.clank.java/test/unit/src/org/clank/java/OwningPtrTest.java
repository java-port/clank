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

import org.clank.java.std_ptr.unique_ptr;
import org.clank.java.std_ptr.unique_ptr_null_eq;
import org.clank.support.Destructors;
import org.clank.support.Native;
import org.clank.support.NativeTrace;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vvoskres
 */
public class OwningPtrTest extends org.clank.java.JavaTestBase {
  
  public OwningPtrTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
    System.setProperty("cnd.mode.unittest", "true");
  }

  @BeforeClass
  public static void startUpClass() {
    // set to false to prevent printing stacks
    System.setProperty(NativeTrace.CHECK_STD_ACCESS_DESTROYED_PROP, "false");
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
    super.tearDown();
  }

  /**
   * Test of $destroy method, of class OwningPtr.
   */
  @Test
  public void test$destroy() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    Destructable obj = new Destructable();
    unique_ptr instance = new unique_ptr(obj);
    instance.$destroy();
    try {      
      obj.method();
      fail("Must be unreachable.");
    } catch (IllegalStateException e) {
      // OK
    }
    // the checks below are for debug mode only
    if (!NativeTrace.isDebugMode()) {
      NativeTrace.clearFirstException();
      return;
    }
    try {
      instance.take();
      fail("Must be unreachable.");
    } catch (IllegalStateException e) {
      // OK
    }
    try {
      instance.$arrow();
      fail("Must be unreachable.");
    } catch (IllegalStateException e) {
      // OK
    }
    try {
      instance.$destroy();
      fail("Must be unreachable.");
    } catch (IllegalStateException e) {
      // OK
    }
    try {
      instance.$star();
      fail("Must be unreachable.");
    } catch (IllegalStateException e) {
      // OK
    }
    try {
      instance.get();
      fail("Must be unreachable.");
    } catch (IllegalStateException e) {
      // OK
    }
    try {
      instance.reset();
      fail("Must be unreachable.");
    } catch (IllegalStateException e) {
      // OK
    }
    try {
      instance.reset(obj);
      fail("Must be unreachable.");
    } catch (IllegalStateException e) {
      // OK
    }
    try {
      instance.swap(new unique_ptr(obj));
      fail("Must be unreachable.");
    } catch (IllegalStateException e) {
      // OK
    }
    NativeTrace.clearFirstException();
    assertFalse(instance.$bool());
    assertTrue(instance.$not());
  }

  /**
   * Test of reset method, of class OwningPtr.
   */
  @Test
  public void testReset_0args() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    final Destructable obj = new Destructable();
    unique_ptr instance = new unique_ptr(obj);
    assertNotNull(instance.get());
    instance.reset();
    try {
      obj.method();
      fail("Must be unreachable.");
    } catch (IllegalStateException e) {
      // OK
    }    
    assertNull(instance.get());
  }

  /**
   * Test of reset method, of class OwningPtr.
   */
  @Test
  public void testReset_GenericType() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    final Destructable obj = new Destructable();
    final TestObjectComparableAndDestructable P = new TestObjectComparableAndDestructable(false);
    unique_ptr instance = new unique_ptr(obj);
    assertNotNull(instance.get());
    instance.reset(P);
    try {
      obj.method();
      fail("Must be unreachable.");
    } catch (IllegalStateException e) {
      // OK
    }
    assertNotNull(instance.get());
    assertSame(instance.get(), P);
  }

  /**
   * Test of take method, of class OwningPtr.
   */
  @Test
  public void testTake() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    TestObjectComparable expResult = new TestObjectComparable(false);
    unique_ptr instance = new unique_ptr(expResult);
    Object result = instance.take();
    assertSame(expResult, result);
    assertNull(instance.get());
  }

  /**
   * Test of $star method, of class OwningPtr.
   */
  @Test
  public void test$star() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    unique_ptr instance = new unique_ptr();
    Object expResult = new Integer(10);
    try {
      Object result = instance.$star();
      fail("Must be unreachable.");
    } catch (NullPointerException e) {
      // OK
    }
    instance.reset(expResult);
    Object result = instance.$star();
    assertEquals(expResult, result);
  }

  /**
   * Test of $arrow method, of class OwningPtr.
   */
  @Test
  public void test$arrow() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    unique_ptr instance = new unique_ptr();
    Object expResult = new Integer(10);
    try {
      Object result = instance.$arrow();
      fail("Must be unreachable.");
    } catch (NullPointerException e) {
      // OK
    }
    instance.reset(expResult);
    Object result = instance.$arrow();
    assertEquals(expResult, result);
  }

  /**
   * Test of get method, of class OwningPtr.
   */
  @Test
  public void testGet() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    Object expResult = new Object();
    unique_ptr instance = new unique_ptr(expResult);
    Object result = instance.get();
    assertEquals(expResult, result);
  }

  /**
   * Test of $boolean method, of class OwningPtr.
   */
  @Test
  public void test$bool() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    unique_ptr instance = new unique_ptr();
    boolean expResult = false;
    boolean result = instance.$bool();
    assertEquals(instance.$bool(), !instance.$not());
    instance.reset(new TestObjectComparable(false));
    assertTrue(instance.$bool());
    // TODO review the generated test code and remove the default call to fail.
  }
  
  @Test
  public void test$boolean_comparable_with_null() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    unique_ptr_null_eq instance = new unique_ptr_null_eq();
    boolean expResult = false;
    boolean result = instance.$bool();
    assertEquals(instance.$bool(), !instance.$not());
    instance.reset(new TestObjectComparable(true));
    assertFalse(instance.$bool());
  }
  /**
   * Test of $not method, of class OwningPtr.
   */
  @Test
  public void test$not() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    unique_ptr instance = new unique_ptr();
    instance.reset(new TestObjectComparable(false));
    assertFalse(instance.$not());
  }
  
  @Test
  public void test$not_comparable_with_null() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    unique_ptr_null_eq instance = new unique_ptr_null_eq();
    instance.reset(new TestObjectComparable(true));
    assertTrue(instance.$not());
  }
  
  /**
   * Test of swap method, of class OwningPtr.
   */
  @Test
  public void testSwap() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    Object i1 = new Object();
    Object i2 = new Object();
    unique_ptr instance1 = new unique_ptr(i1);
    unique_ptr instance2 = new unique_ptr(i2);
    instance1.swap(instance2);
    assertSame(instance1.get(), i2);
    assertSame(instance2.get(), i1);
  }
    
  private static final class TestObjectComparable implements Native.NativeComparable {
    private final boolean equalToNull;

    public TestObjectComparable(boolean equalToNull) {
      this.equalToNull = equalToNull;
    }

    @Override
    public boolean $eq(Object obj) {
      if (obj == null) {
        return equalToNull;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      final TestObjectComparable other = (TestObjectComparable) obj;
      return this.equalToNull == other.equalToNull;
    }

    @Override
    public boolean $noteq(Object other) {
      return !$eq(other);
    }

    @Override
    public boolean equals(Object obj) {
      return $eq(obj);
    }
  }
  
  private static final class Destructable implements Destructors.ClassWithDestructor {
    private boolean destroyed = false;
    
    @Override
    public void $destroy() {
      checkAlive();
      destroyed = true;
    }  

    private void checkAlive() {
      if (destroyed) {
        throw new IllegalStateException("Already destroyed");
      }
    }
    
    public boolean method() {
      checkAlive();
      return true;
    }
  }
  
  private static final class TestObjectComparableAndDestructable implements Native.NativeComparable, Destructors.ClassWithDestructor {
    private final boolean equalToNull;
    private boolean destroyed = false;

    public TestObjectComparableAndDestructable(boolean equalToNull) {
      this.equalToNull = equalToNull;
    }

    @Override
    public boolean $eq(Object obj) {
      checkAlive();
      if (obj == null) {
        return equalToNull;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      final TestObjectComparableAndDestructable other = (TestObjectComparableAndDestructable) obj;
      return this.equalToNull == other.equalToNull;
    }

    @Override
    public boolean $noteq(Object other) {
      return !$eq(other);
    }

    @Override
    public void $destroy() {
      checkAlive();
      destroyed = true;
    }
    
    @Override
    public boolean equals(Object obj) {
      return $eq(obj);
    }    

    private void checkAlive() {
      if (destroyed) {
        throw new IllegalStateException("Already destroyed");
      }
    }
  }

}
