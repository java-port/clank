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
package org.clank.support;

import org.clank.support.aliases.*;

/**
 * Lightest implementation of pointer to T
 */
@Converted(kind = Converted.Kind.DUMMY)
public final class type$ptr$single<T> implements type$ptr<T>, type$ref<T> {
  
  // Marker that this pointer is the "end" pointer:
  // [&Obj, &Obj + 1]
  //        ^
  //   this is "end" pointer
  private final static class End {
    private final Object val;
    private End(Object val) { this.val = val; }
  }

  private Object val;

  public type$ptr$single() {
    this((T) null);
  }

  public type$ptr$single(T val) {
    this.val = val;
    trackInstance();
  }

  ////////////////////////////////////////////////////////////////////////////
  // common operations

  @Override
  public boolean $bool() {
    return val != null;
  }
  
  @Override
  public boolean $isNull() {
    assert !isEnd() : "Why checking 'end' pointer on nullness?";
    return val == null;
  }

  @Override
  public T $deref() {
    assert !isEnd() : "Why accessing value of 'end' pointer?";
    return $star();
  }

  @Override
  public T $star() {
    assert !isEnd() : "Why accessing value of 'end' pointer?";
    return (T) val;
  }

  @Override
  public T $set(T value) {
    assert !isEnd() : "Why accessing value of 'end' pointer?";
    return (T)(val = (value instanceof void$ptr) ? Native.$tryAssign(val, value, false) : value);
  }

  @Override
  public T $at(int index) {
    if (index != 0) {
      throw new IllegalArgumentException("Index must be zero to access to the single variable!");
    }
    assert !isEnd() : "Why accessing value of 'end' pointer?";
    return (T) val;
  }

  @Override
  public T $set(int index, T value) {
    if (index != 0) {
      throw new IllegalArgumentException("Index must be zero to access to the single variable!");
    }
    assert !isEnd() : "Why accessing value of 'end' pointer?";
    return (T)(val = (value instanceof void$ptr) ? Native.$tryAssign(val, value, false) : value);
  }

  @Override
  public type$ptr<T> $assign(type$ptr<T> value) {
    throw new UnsupportedOperationException("Use $set(value.$star()) instead!");
  }

  @Override
  public type$ref<T> star$ref() {
    return this;
  }

  @Override
  public type$ptr<T> deref$ptr() {
    return this;
  }
  
  @Override
  public int $sub(type$ptr<T> ptr) {
    if ($eq(ptr)) {
      return 0;
    } else if (isDualPtr(ptr)) {
      return isEnd() ? 1 : -1;
    }
    throw new UnsupportedOperationException("Not supported.");
  }
  
  @Override
  public boolean $eq(Object p) {
    if (p == this) {
      return true;
    }
    if (!(p instanceof type$ptr$single)) {
      return false;
    }
    type$ptr$single other = (type$ptr$single) p;
    return other.isEnd() == this.isEnd() && other.getTrueVal() == this.getTrueVal();
  }

  @Override
  public boolean $noteq(Object p) {
    return !$eq(p);
  }

  @Override
  public int $hashcode() {
    return System.identityHashCode(getTrueVal());
  }

  @Override
  public type$ptr<T> $inc(int amount) {
    if (amount == 0) {
      return this;
    } else if (amount == 1 && !isEnd()) {
      this.val = new End((T) this.val);
      return this;
    } else if (amount == -1 && isEnd()) {
      this.val = getTrueVal();
      return this;
    }
    throw new UnsupportedOperationException("Not supported.");
  }

  @Override
  public type$ptr<T> $dec(int amount) {
    return $inc(-amount);
  }

  @Override
  public type$ptr<T> $add(int amount) {
    if (amount == 0) {
      return clone();
    } else if (amount == 1 && !isEnd()) {
      type$ptr$single<T> cloned = clone();
      cloned.val = new End((T) this.val);
      return cloned;
    } else if (amount == -1 && isEnd()) {
      type$ptr$single<T> cloned = clone();
      cloned.val = getTrueVal();
      return cloned;
    }
    throw new UnsupportedOperationException("Not supported.");
  }

  @Override
  public type$ptr<T> $sub(int amount) {
    return $add(-amount);
  }

  @Override
  public type$ptr$single<T> clone() {
    return new type$ptr$single(this.val);
  }

  @Override
  public type$ptr$single<T> const_clone() {
    return clone();
  }

  @Override
  public boolean isComparableTo(void$ptr other) {
    return false;
  }

  @Override
  public type$ptr<type$ptr<T>> $addr() {
    throw new UnsupportedOperationException("Not supported.");
  }
  
  @Override
  public type$memory<type$ptr<T>> getSelfMemory() {
    throw new UnsupportedOperationException("Not supported.");
  }

  @Override
  public int getSelfIndex() {
    throw new UnsupportedOperationException("Not supported.");
  }
  
  @Override
  public type$ptr<T> $preInc() {
    return $inc(1);
  }

  @Override
  public type$ptr<T> $preDec() {
    return $dec(1);
  }

  @Override
  public type$ptr<T> $postInc() {
    type$ptr<T> prev = clone();
    $inc(1);
    return prev;
  }

  @Override
  public type$ptr<T> $postDec() {
    type$ptr<T> prev = clone();
    $dec(1);
    return prev;
  }

  @Override
  public boolean $less(Object obj) {
    type$ptr$single other = (type$ptr$single)obj;
    if (val == null) {
      return other.val != null;
    } else if (other.val == null) {
      return false;
    } else if (other.val == val) {
      return false;
    }
    throw new UnsupportedOperationException("Not supported.");
  }

  @Override
  public boolean $lesseq(Object obj) {
    throw new UnsupportedOperationException("Not supported.");
  }

  @Override
  public boolean $greater(Object obj) {
    throw new UnsupportedOperationException("Not supported.");
  }

  @Override
  public boolean $greatereq(Object obj) {
    throw new UnsupportedOperationException("Not supported.");
  }

  @Override
  public String toString() {
    return "type$ptr$single{" + val + "}";
  }

  ////////////////////////////////////////////////////////////////////////////
  // utility methods
  
  private boolean isEnd() {
    return val instanceof End;
  }
  
  private T getTrueVal() {
    return (T) (isEnd() ? ((End) val).val : val);
  }
  
  private boolean isDualPtr(type$ptr<T> other) {
    if (other instanceof type$ptr$single) {
      type$ptr$single<T> ptr = (type$ptr$single<T>) other;
      return isEnd() != ptr.isEnd() && getTrueVal() == ptr.getTrueVal();
    }
    return false;
  }

  ////////////////////////////////////////////////////////////////////////////
  // statistics
  private static long instances = 0;

  public static void trackInstance() {
    if (NativeTrace.STATISTICS) {
      instances++;
    }
  }

  public static void clearStatistics() {
    instances = 0;
  }

  public static long printStatistics(java.io.PrintWriter out) {
    out.printf("%22s created:\t%s%n", type$ptr$single.class.getSimpleName(), NativeTrace.formatNumber(instances));
    return instances;
  }

  ///////////////////////////////////////////////////////////////////////////
  // performance access operations
  @Override
  public int $index() {
    throw new UnsupportedOperationException("Not supported; create array based instance instead");
  }

  @Override
  public T[] $array() {
    throw new UnsupportedOperationException("Not supported; create array based instance instead");
  }

}
