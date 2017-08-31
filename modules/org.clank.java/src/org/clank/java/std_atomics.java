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

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.clank.support.Destructors;

/**
 *
 * @author petrk
 */
public abstract class std_atomics extends io {
  
  /// Enumeration for memory_order
  public static enum memory_order {
    memory_order_relaxed,
    memory_order_consume,
    memory_order_acquire,
    memory_order_release,
    memory_order_acq_rel,
    memory_order_seq_cst
  }
  
  /**
   *  @brief Generic atomic type, primary class template.
   *
   *  @tparam _Tp  Type to be made atomic, must be trivally copyable.
   */
  public static final class atomic<_Tp> implements Destructors.ClassWithDestructor {

    @Override
    public void $destroy() {
      throw new UnsupportedOperationException("Not supported yet.");
    }
//    private:
//      _Tp _M_i;
//
//    public:
//      atomic() noexcept = default;
//      ~atomic() noexcept = default;
//      atomic(const atomic&) = delete;
//      atomic& operator=(const atomic&) = delete;
//      atomic& operator=(const atomic&) volatile = delete;
//
//      constexpr atomic(_Tp __i) noexcept : _M_i(__i) { }
//
//      operator _Tp() const noexcept
//      { return load(); }
//
//      operator _Tp() const volatile noexcept
//      { return load(); }
//
//      _Tp
//      operator=(_Tp __i) noexcept 
//      { store(__i); return __i; }
//
//      _Tp
//      operator=(_Tp __i) volatile noexcept 
//      { store(__i); return __i; }
//
//      bool
//      is_lock_free() const noexcept
//      { return __atomic_is_lock_free(sizeof(_M_i), nullptr); }
//
//      bool
//      is_lock_free() const volatile noexcept
//      { return __atomic_is_lock_free(sizeof(_M_i), nullptr); }
//
//      void
//      store(_Tp __i, memory_order _m = memory_order_seq_cst) noexcept
//      { __atomic_store(&_M_i, &__i, _m); }
//
//      void
//      store(_Tp __i, memory_order _m = memory_order_seq_cst) volatile noexcept
//      { __atomic_store(&_M_i, &__i, _m); }
//
//      _Tp
//      load(memory_order _m = memory_order_seq_cst) const noexcept
//      { 
//        _Tp tmp;
//	__atomic_load(&_M_i, &tmp, _m); 
//	return tmp;
//      }
//
//      _Tp
//      load(memory_order _m = memory_order_seq_cst) const volatile noexcept
//      { 
//        _Tp tmp;
//	__atomic_load(&_M_i, &tmp, _m); 
//	return tmp;
//      }
//
//      _Tp
//      exchange(_Tp __i, memory_order _m = memory_order_seq_cst) noexcept
//      { 
//        _Tp tmp;
//	__atomic_exchange(&_M_i, &__i, &tmp, _m); 
//	return tmp;
//      }
//
//      _Tp
//      exchange(_Tp __i, 
//	       memory_order _m = memory_order_seq_cst) volatile noexcept
//      { 
//        _Tp tmp;
//	__atomic_exchange(&_M_i, &__i, &tmp, _m); 
//	return tmp;
//      }
//
//      bool
//      compare_exchange_weak(_Tp& __e, _Tp __i, memory_order __s, 
//			    memory_order __f) noexcept
//      {
//	return __atomic_compare_exchange(&_M_i, &__e, &__i, true, __s, __f); 
//      }
//
//      bool
//      compare_exchange_weak(_Tp& __e, _Tp __i, memory_order __s, 
//			    memory_order __f) volatile noexcept
//      {
//	return __atomic_compare_exchange(&_M_i, &__e, &__i, true, __s, __f); 
//      }
//
//      bool
//      compare_exchange_weak(_Tp& __e, _Tp __i,
//			    memory_order __m = memory_order_seq_cst) noexcept
//      { return compare_exchange_weak(__e, __i, __m, __m); }
//
//      bool
//      compare_exchange_weak(_Tp& __e, _Tp __i,
//		     memory_order __m = memory_order_seq_cst) volatile noexcept
//      { return compare_exchange_weak(__e, __i, __m, __m); }
//
//      bool
//      compare_exchange_strong(_Tp& __e, _Tp __i, memory_order __s, 
//			      memory_order __f) noexcept
//      {
//	return __atomic_compare_exchange(&_M_i, &__e, &__i, false, __s, __f); 
//      }
//
//      bool
//      compare_exchange_strong(_Tp& __e, _Tp __i, memory_order __s, 
//			      memory_order __f) volatile noexcept
//      {
//	return __atomic_compare_exchange(&_M_i, &__e, &__i, false, __s, __f); 
//      }
//
//      bool
//      compare_exchange_strong(_Tp& __e, _Tp __i,
//			       memory_order __m = memory_order_seq_cst) noexcept
//      { return compare_exchange_strong(__e, __i, __m, __m); }
//
//      bool
//      compare_exchange_strong(_Tp& __e, _Tp __i,
//		     memory_order __m = memory_order_seq_cst) volatile noexcept
//      { return compare_exchange_strong(__e, __i, __m, __m); }
  }
  
  public static final class atomicInt implements Destructors.ClassWithDestructor {
    
    private final AtomicInteger delegate;

    public atomicInt() {
      this.delegate = new AtomicInteger();
    }
    
    public atomicInt(int initialValue) {
      this.delegate = new AtomicInteger(initialValue);
    }
    
    private atomicInt(atomicInt other) {
      throw new UnsupportedOperationException("DELETED!");
    }
    
    public int $preInc() {
      return delegate.incrementAndGet();
    }
    
    public int $preDec() {
      return delegate.decrementAndGet();
    }

    public int load(memory_order memory_order) {
      return delegate.get();
    }

    public std.atomicInt $assign(int Val) {
      delegate.set(Val);
      return this;
    }

    public void store(int Val, memory_order memory_order) {
      delegate.set(Val);
    }

    public int fetch_add(int i, memory_order memory_order) {
      return delegate.addAndGet(i);
    }

    public int fetch_sub(int i, memory_order memory_order) {
      return delegate.addAndGet(-i);
    }
    
    @Override
    public String toString() {
      return "[" + delegate.get() + "]";
    }

    public int $int() {
      return this.delegate.get();
    }
    
    @Override
    public void $destroy() { }
  }
  
  public static final class atomicLong implements Destructors.ClassWithDestructor {
    
    private final AtomicLong delegate;

    public atomicLong() {
      this.delegate = new AtomicLong();
    }
    
    public atomicLong(long initialValue) {
      this.delegate = new AtomicLong(initialValue);
    }
    
    private atomicLong(atomicInt other) {
      throw new UnsupportedOperationException("DELETED!");
    }
    
    public long $preInc() {
      return delegate.incrementAndGet();
    }
    
    public long $preDec() {
      return delegate.decrementAndGet();
    }
    
    public long $postInc() {
      long val = delegate.get();
      delegate.incrementAndGet();
      return val;
    }


    public long load(memory_order memory_order) {
      return delegate.get();
    }

    public std.atomicLong $assign(long Val) {
      delegate.set(Val);
      return this;
    }

    public void store(long Val, memory_order memory_order) {
      delegate.set(Val);
    }

    public long fetch_add(long i, memory_order memory_order) {
      return delegate.addAndGet(i);
    }

    public long fetch_sub(long i, memory_order memory_order) {
      return delegate.addAndGet(-i);
    }
    
    public long $long() {
      return delegate.get();
    }
    
    @Override
    public String toString() {
      return "[" + delegate.get() + "]";
    }

    @Override
    public void $destroy() {}
  }
  
  public static final class atomicUInt implements Destructors.ClassWithDestructor {
    
    private final AtomicInteger delegate;

    public atomicUInt() {
      this.delegate = new AtomicInteger();
    }
    
    public atomicUInt(/*uint*/int initialValue) {
      this.delegate = new AtomicInteger(initialValue);
    }
    
    private atomicUInt(atomicUInt other) {
      throw new UnsupportedOperationException("DELETED!");
    }
    
    public /*uint*/int $preInc() {
      return delegate.incrementAndGet();
    }
    
    public /*uint*/int $preDec() {
      return delegate.decrementAndGet();
    }
    
    public /*uint*/int $postInc() {
      /*uint*/int val = delegate.get();
      delegate.incrementAndGet();
      return val;
    }

    public /*uint*/int $postInc(/*dummy*/int delta) {
      /*uint*/int val = delegate.getAndAdd(delta);
      return val;
    }

    public void set(/*uint*/int val) {
      delegate.set(val);
    }
    
    @Override
    public String toString() {
      return "[" + delegate.get() + "]";
    }

    @Override
    public void $destroy() {}

    public /*uint*/int $uint() {
      return delegate.get();
    }
    
    public /*uint*/int load(memory_order memory_order) {
      return delegate.get();
    }

    public std.atomicUInt $assign(/*uint*/int Val) {
      delegate.set(Val);
      return this;
    }

    public void store(/*uint*/int Val, memory_order memory_order) {
      delegate.set(Val);
    }

    public /*uint*/int fetch_add(int i, memory_order memory_order) {
      return delegate.addAndGet(i);
    }

    public /*uint*/int fetch_sub(int i, memory_order memory_order) {
      return delegate.addAndGet(-i);
    }
  }
}
