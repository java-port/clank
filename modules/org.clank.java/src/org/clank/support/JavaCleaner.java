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
/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2016 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 */

package org.clank.support;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.clank.java.std;
import org.clank.support.Destructors.ClassWithDestructor;

/**
 *
 * @author Petr Kudryavtsev <petrk@netbeans.org>
 * @author Vladimir Voskresensky
 */
public final class JavaCleaner {
  
  //////////////////////////////////////////////////////////////////////////////
  // Support for cleaning parameters passed into constructors
  //
  // It relies on JLS 15.7.4 - Argument Lists are Evaluated Left-to-Right
  
  public static JavaCleaner JC$Push() {
    List<JavaCleaner> cleanersStack = cleanersStackStorage.get();
    JavaCleaner cleaner = JavaCleaner.create();
    cleanersStack.add(cleaner);
    return cleaner;
  }
  
  public static void JC$Pop() {
    List<JavaCleaner> cleanersStack = cleanersStackStorage.get();
    JavaCleaner cleaner = cleanersStack.remove(cleanersStack.size() - 1);
    cleaner.clean();
  }
  
  public static JavaCleaner JC$Top() {
    List<JavaCleaner> cleanersStack = cleanersStackStorage.get();
    return cleanersStack.get(cleanersStack.size() - 1);
  }
  
  private static final ThreadLocal<List<JavaCleaner>> cleanersStackStorage = new ThreadLocal<List<JavaCleaner>>() {
    @Override
    protected List<JavaCleaner> initialValue() {
      return new ArrayList<>(2);
    }    
  };
  
  //////////////////////////////////////////////////////////////////////////////
  // JavaCleaner acquiring
  
  // Pool of reusable cleaners
  // TODO: ThreadLocal to reduce contention?
  private static final ThreadLocal<Pool> reusableCleaners = new ThreadLocal<Pool>() {

    @Override
    protected Pool initialValue() {
      Pool pool = new Pool();
      return pool;
    }    
  };
  
  /*package*/ static JavaCleaner create() {
    if (NativeTrace.REUSE_JAVA_CLEANER) {
      return reusableCleaners.get().takeOrCreate();
    } else {
      return new JavaCleaner(false);
    }
  }
   
  private static void release(JavaCleaner cleaner) {
    assert NativeTrace.REUSE_JAVA_CLEANER;
    reusableCleaners.get().release(cleaner);
  }
    
  private final List<Object> temporaries = new ArrayList(4);
  /*package*/Exception releaseStack = null;
  
  /*package*/ JavaCleaner(boolean reusable) {
    trackInstance(reusable);
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // JavaCleaner
  
  /**
   * Tracks temporaries which must be destroyed in future. 
   * See CXXBindTemporary in C++ AST.
   * 
   * @param <T>
   * @param temporary object to destroy
   * @return temporary itself
   */
  public <T> std.unique_ptr_with_deleter<T> track(std.unique_ptr_with_deleter<T> temporary)  {
    trackImpl(temporary);
    return temporary;
  }

  /**
   * Tracks temporaries which must be destroyed in future. 
   * See CXXBindTemporary in C++ AST.
   * 
   * @param <T>
   * @param temporary object to destroy
   * @return temporary itself
   */
  public <T> std.unique_ptr_array<T> track(std.unique_ptr_array<T> temporary)  {
    trackImpl(temporary);
    return temporary;
  }

  /**
   * Tracks temporaries which must be destroyed in future. 
   * See CXXBindTemporary in C++ AST.
   * 
   * @param <T>
   * @param temporary object to destroy
   * @return temporary itself
   */
  public <T> std.unique_ptr<T> track(std.unique_ptr<T> temporary)  {
    trackImpl(temporary);
    return temporary;
  }

  /**
   * Tracks temporaries which must be destroyed in future. 
   * See CXXBindTemporary in C++ AST.
   * 
   * @param <T>
   * @param temporary object to destroy
   * @return temporary itself
   */
  public <T> T track(T temporary)  {
    trackImpl(temporary);
    return temporary;
  }
  public <T> T[] track(T temporary[])  {
    trackArraryImpl(temporary);
    return temporary;
  }
  
  /**
   * Destroys tracked temporaries. See ExprWithCleanups in C++ AST.
   * 
   * @param <T>
   * @param exprValue value which must be forwarded
   * @return passed value (exprValue)
   */
  public <T> T clean(T exprValue) {
    doClean();
    return exprValue;
  }

  // Clean specialization for byte
  public byte clean(byte exprValue) {
    doClean();
    return exprValue;
  }
  
  // Clean specialization for char
  public char clean(char exprValue) {
    doClean();
    return exprValue;
  }
  
  // Clean specialization for short
  public short clean(short exprValue) {
    doClean();
    return exprValue;
  }
  
  // Clean specialization for int
  public int clean(int exprValue) {
    doClean();
    return exprValue;
  }
  
  // Clean specialization for long
  public long clean(long exprValue) {
    doClean();
    return exprValue;
  }
  
  // Clean specialization for double
  public double clean(double exprValue) {
    doClean();
    return exprValue;
  }
  
  // Clean specialization for boolean
  public boolean clean(boolean exprValue) {
    doClean();
    return exprValue;
  }

  // Clean specialization for void
  public void clean() {
    doClean();
  }
  
  /**
   * Forwards parameter without any side effects
   * 
   * @param <T>
   * @param exprValue
   * @return exprValue
   */
  public <T> T forward(T exprValue) {
    return exprValue;
  }

  // Forward specialization for byte
  public byte forward(byte exprValue) {
    return exprValue;
  }
  
  // Forward specialization for char
  public char forward(char exprValue) {
    return exprValue;
  }
  
  // Forward specialization for short
  public short forward(short exprValue) {
    return exprValue;
  }
  
  // Forward specialization for int
  public int forward(int exprValue) {
    return exprValue;
  }
  
  // Forward specialization for long
  public long forward(long exprValue) {
    return exprValue;
  }
  
  // Forward specialization for float
  public float forward(float exprValue) {
    return exprValue;
  }
  
  // Forward specialization for double
  public double forward(double exprValue) {
    return exprValue;
  }
  
  // Forward specialization for boolean
  public boolean forward(boolean exprValue) {
    return exprValue;
  }
  
  /**
   * Ensures that all objects were destroyed (clean() methods placed correctly).
   */
  public final void $destroy() {
    if (NativeTrace.isDebugMode()) {
      for (Object tmp : temporaries) {
//        ((JavaCleanerWrapper)tmp).trackStack.printStackTrace();
        String toString = NativeTrace.getIdentityStr(tmp);
//        if (tmp != null) {
//          try {
//            toString = toString + tmp.toString();
//          } catch (Throwable e) {
//            toString = "StackOverflow on toString " + toString;
//          }
//        }
        // we don't print here extra stacks, because it's often create too much noise
        // also $destroy is called from 'finally' sections which are called when 
        // another exception can be on it's way, so we don't use 'assert' or 
        // NativeTrace.printStackTrace here to not put incorrect val in 'first' exception
        Exception ex = new Exception("JAVACLEANER ERROR: Uncleaned object " + 
                "(If in finally then check exception thrown in try/catch) ");
        NativeTrace.registerCleanupException(ex);
        NativeTrace.printDebuggingStackFrames("JAVACLEANER ERROR: Uncleaned object " + 
                "(If in finally then check exception thrown in try/catch) " + toString);
//        NativeTrace.printStackTraceOnce(new Exception("Uncleaned object " + toString));
//        assert false : "Not all registered objects were destroyed!" + tmp;        
      }
    }
    if (NativeTrace.REUSE_JAVA_CLEANER) {
      release(this);
    }
  }
  
//<editor-fold defaultstate="collapsed" desc="Implementation">
  private void doClean() {
    for (Object temporary : temporaries) {
      Destructors.$destroy(temporary);
    }
    temporaries.clear();
  }
//</editor-fold>
  
  //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static long reusableInstances = 0;
  private static long instances = 0;

  private static void trackInstance(boolean reusable) {
    if (NativeTrace.STATISTICS) {
      instances++;
      if (reusable) {
        reusableInstances++;
      }
    }
  }

  /*package*/ static void clearStatistics() {
    instances = 0;
    reusableInstances = 0;
  }

  /*package*/ static long printStatistics(PrintWriter out) {
    out.printf("%22s created:\t%s%n", JavaCleaner.class.getSimpleName(), NativeTrace.formatNumber(instances));
    out.printf("%22s +reused:\t%s%n", JavaCleaner.class.getSimpleName(), NativeTrace.formatNumber(reusableInstances));
    NativeTrace.dumpStatisticValue(JavaCleaner.class.getSimpleName(), instances);    
    return instances;
  }    
  
  private static final class Pool {
    private final static int MAX_INDEX = 31;
    int size;
    JavaCleaner[] array;
    
    Pool() {
      this.size = 0;
      this.array = new JavaCleaner[MAX_INDEX + 1];
    }
    
    JavaCleaner takeOrCreate() {
      JavaCleaner out = (size == 0) ? new JavaCleaner(true) : array[size--];
      if (size < 0) {
        size = size;
      }      
      assert out.temporaries.isEmpty() : "must be empty in the beginning " + out.temporaries;
      return out;
    }
    
    void release(JavaCleaner released) {
      if (size < 0) {
        size = size;
      }
      assert size >= 0;
      assert released.temporaries.isEmpty() : "must be empty on release " + released.temporaries;
      if (NativeTrace.isDebugMode()) {
        for (int i = 0; i < size; i++) {
          assert array[i] != released;
        }
      }      
      if (size < MAX_INDEX) {
        array[++size] = released;
      }
    }
    
    void clear() {
      for (int i = 0; i < array.length; i++) {
        array[i] = null;
      }
      this.size = 0;
    }
  }
  private final static class JavaTemporaryArrayWrapper implements ClassWithDestructor {
    private final Object[] wrapped;

    public JavaTemporaryArrayWrapper(Object[] array) {
      this.wrapped = array;
    }
    
    @Override
    public void $destroy() {
      Destructors.$destroyArray((Object[])wrapped);
    }
  }
  
  private final static class JavaCleanerWrapper implements ClassWithDestructor {
    private final Object wrapped;
    private final Exception trackStack;
    private final boolean array;
    public JavaCleanerWrapper(Object wrapped, boolean array) {
      this.wrapped = wrapped;
      trackStack = new Exception("Non Freed " + wrapped);
      this.array = array;
    }

    @Override
    public String toString() {
      String out = "Wrap{"+(array ? Arrays.toString((Object[])wrapped) : wrapped.toString()) +"}";
      return out;
    }

    @Override
    public void $destroy() {
      if (array) {
        Destructors.$destroyArray((Object[])wrapped);
      } else {
        Destructors.$destroy(wrapped);
      }
    }
            
  }
  
  private void trackImpl(Object temporary) {
    assert temporary != null;
    assert temporary instanceof ClassWithDestructor : "Why registering temporary without destructor?" + temporary.getClass().getName();
    if (RECORD_TRACK && NativeTrace.isDebugMode()) {
      temporaries.add(new JavaCleanerWrapper(temporary, false));
    } else {      
      temporaries.add(temporary);
    }
  } 
  
  private <T> void trackArraryImpl(T temporary[]) {
    assert temporary != null;
    assert temporary.length > 0;
    if (RECORD_TRACK && NativeTrace.isDebugMode()) {
      temporaries.add(new JavaCleanerWrapper(temporary, true));
    } else {      
      temporaries.add(new JavaTemporaryArrayWrapper(temporary));
    }
  } 
  
  private static final boolean RECORD_TRACK = false;
}