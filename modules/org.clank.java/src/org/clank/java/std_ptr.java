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
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.create_type$ptr;

/**
 *
 * @author Vladimir Voskresensky
 */
public interface std_ptr {

public interface deleter<T> {
  void $call(T __ptr);
}

public class default_delete<T> implements deleter<T> {
    @Override
    public void $call(T __ptr) {
      Native.destroy(__ptr);
    }
}

public static class unique_ptrT$ArrayT1<T0, T1> {

  public unique_ptrT$ArrayT1() {
  }
}


//===----------------------------------------------------------------------===//
/// shared_ptr as copy of IntrusiveRefCntPtr
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 109,
 cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -filter=llvm::IntrusiveRefCntPtr")
//</editor-fold>
public class shared_ptr</*typename*/ T> extends NativeTrace.CreateDestroy$Tracker implements Destructors.ClassWithDestructor, Native.NativeComparable<shared_ptr<T>>, Native.Native$Bool, NativeCloneable<shared_ptr>, NativeMoveable<shared_ptr>  {
  
  private T /*P*/ Obj;
  private AtomicInteger _M_refcount;
  /*typedef IntrusiveRefCntPtr<T> this_type*/
  //public final class this_type extends IntrusiveRefCntPtr<T>{ };
/*public:*/
  /*typedef T element_type*/
  //public final class element_type extends T{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::IntrusiveRefCntPtr<T>">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 116,
   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -filter=llvm::IntrusiveRefCntPtr::IntrusiveRefCntPtr<T>")
  //</editor-fold>
  public /*explicit*/ shared_ptr() {
    super(null);
    /* : Obj(0)*/ 
    //START JInit
    //this.Obj = new T /*P*/ (0);
    Obj = null;
    //END JInit
    _M_refcount = null;
    trackInstance();
  }

  //<editor-fold defaultstate="collapsed" desc="std::shared_ptr::shared_ptr<_Tp>">
  @Converted(kind = Converted.Kind.AUTO, source = "/usr/include/c++/4.9/bits/shared_ptr.h", line = 265,
   FQN="std::shared_ptr::shared_ptr<_Tp>", NM="_ZNSt10shared_ptrC1EDn",
   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZNSt10shared_ptrC1EDn")
  //</editor-fold>
  public /*explicit*/ shared_ptr(JD$NullPtr _dparam, /*nullptr_t*/Object __p) {
    this((T)__p);
    assert __p == null : "only for nullptr_t";
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::IntrusiveRefCntPtr<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 118,
   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -filter=llvm::IntrusiveRefCntPtr::IntrusiveRefCntPtr<T>")
  //</editor-fold>
  public shared_ptr(T /*P*/ obj) {
    /* : Obj(obj)*/ 
    super(obj);
    //START JInit
    this.Obj = obj;
    //END JInit
    retain();
    trackInstance();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::IntrusiveRefCntPtr<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 122,
   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -filter=llvm::IntrusiveRefCntPtr::IntrusiveRefCntPtr<T>")
  //</editor-fold>
  public <Tp1> shared_ptr(JD$Shared_ptr$_Tp1$C _dparam, /*const*/shared_ptr<Tp1> /*&*/ S) {
    this((shared_ptr<T>)S);
  }
  public shared_ptr(/*const*/shared_ptr<T> /*&*/ S) {
    /* : Obj(S.Obj)*/ 
    super(S.Obj);
    assert S.checkAlive();
    //START JInit
    this.Obj = S.Obj;
    _M_refcount = S._M_refcount;
    //END JInit
    retain();
    trackInstance();
  }
  
  public shared_ptr(JD$Move $Prm, shared_ptr<T> /*&&*/ S) {
    super(S.Obj);
    assert S.checkAlive();
    Obj = null;
    _M_refcount = null;
    swap(S);
    trackInstance();
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 143,
   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -filter=llvm::IntrusiveRefCntPtr::operator=")
  //</editor-fold>
  public shared_ptr<T> /*&*/ $assign(shared_ptr<T> S) {
    assert S.checkAlive();
    if (is$destroyed()) {
      // can be reused from collections
      assert Obj == null;
      clear$destroyed();
    }
    if (this != S) {
      release();
      Obj = S.Obj;
      _M_refcount = S._M_refcount;
      retain();
    }
    return /*Deref*/this;
  }
  
  public shared_ptr<T> /*&*/ $assignMove(shared_ptr<T> S) {
    assert S.checkAlive();
    if (is$destroyed()) {
      // can be reused from collections
      assert Obj == null;
      clear$destroyed();
    }
    //__shared_ptr(std::move(__r)).swap(*this);
    //return *this;    
    shared_ptr<T> tmp = new shared_ptr(JD$Move.INSTANCE, S);
    try {
      tmp.swap(this);
      return /*Deref*/this;
    } finally {
      tmp.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::~IntrusiveRefCntPtr<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 148,
   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -filter=llvm::IntrusiveRefCntPtr::~IntrusiveRefCntPtr<T>")
  //</editor-fold>
  public void $destroy() {
    assert checkAlive();
    release();
    Obj = null;
    super.set$destroyed();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::operator*">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 150,
   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -filter=llvm::IntrusiveRefCntPtr::operator*")
  //</editor-fold>
  public T /*&*/ $star() /*const*/ {
    assert checkAlive();
    return /*Deref*/Obj;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::operator->">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 152,
   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -filter=llvm::IntrusiveRefCntPtr::operator->")
  //</editor-fold>
  public T /*P*/ $arrow() /*const*/ {
    assert checkAlive();
    return Obj;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::getPtr">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 154,
   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -filter=llvm::IntrusiveRefCntPtr::getPtr")
  //</editor-fold>
  public T /*P*/ getPtr() /*const*/ {
    assert checkAlive();
    return Obj;
  }
  
  public boolean $bool() {
    assert checkAlive();
    return Obj != null;
  }

//  /*typedef T *(IntrusiveRefCntPtr<T>::*unspecified_bool_type)() __attribute__((cdecl)) const*/
//  public final class unspecified_bool_type extends T * (IntrusiveRefCntPtr<T>/*::**/)()/* __attribute__((cdecl))*/ /*const*/{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::operator type-parameter-0-0 * (IntrusiveRefCntPtr<T>/*::**/)(void)/* __attribute__((cdecl))*/ /*const*/">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 157,
   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -filter=llvm::IntrusiveRefCntPtr::operator type-parameter-0-0 * (IntrusiveRefCntPtr<T>/*::**/)(void)/* __attribute__((cdecl))*/ /*const*/")
  //</editor-fold>
  public T $Void2RetType() {
    assert checkAlive();
    return Obj == null ? null : Obj;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::swap">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 161,
   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -filter=llvm::IntrusiveRefCntPtr::swap")
  //</editor-fold>
  public void swap(shared_ptr<T> /*&*/ other) {
    assert other.checkAlive();
    assert checkAlive();
    T /*P*/ tmp = other.Obj;
    AtomicInteger _M_refcount_Tmp = other._M_refcount;
    other.Obj = this.Obj;
    other._M_refcount = this._M_refcount;
    this.Obj = tmp;
    this._M_refcount = _M_refcount_Tmp;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::reset">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 167,
   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -filter=llvm::IntrusiveRefCntPtr::reset")
  //</editor-fold>
  public void reset() {
    assert checkAlive();
    release();
    Obj = null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::resetWithoutRelease">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 172,
   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -filter=llvm::IntrusiveRefCntPtr::resetWithoutRelease")
  //</editor-fold>
  public void resetWithoutRelease() {
    assert checkAlive();
    Obj = null;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::retain">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 177,
   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -filter=llvm::IntrusiveRefCntPtr::retain")
  //</editor-fold>
  private void retain() {
    assert checkAlive();
    if (Obj != null) {
      if (_M_refcount == null) {
        _M_refcount = new AtomicInteger(0);
      }
      _M_refcount.incrementAndGet();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::release">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 178,
   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -filter=llvm::IntrusiveRefCntPtr::release")
  //</editor-fold>
  private void release() {
    assert checkAlive();
    if (Obj != null) {
      assert _M_refcount != null;
      if (_M_refcount.decrementAndGet() == 0) {
        Destructors.$destroy(Obj);
        Obj = null;
        _M_refcount = null;
      }
    }
  }

  @Override
  public String toString() {
    return "shared_ptr{counter=" + _M_refcount + (is$destroyed()?"DESTROYED;":"") + ", Obj=" + Obj + '}';
  }

  public T get() {
    assert checkAlive();
    return Obj;
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static long instances = 0;
  private static void trackInstance() {
    if (NativeTrace.STATISTICS) instances++;
  }

  public static void clearStatistics() {
    instances = 0;
  }

  public static long printStatistics(java.io.PrintWriter out) {
    out.printf("%22s created:\t%s%n", shared_ptr.class.getSimpleName(), NativeTrace.formatNumber(instances));
    NativeTrace.dumpStatisticValue(shared_ptr.class.getSimpleName(), instances);
    return instances;        
  }  

  @Override
  public boolean $eq(shared_ptr<T> other) {
    assert other.checkAlive();
    if (other == null) {
      return Native.$eq(this.Obj, null);
    }
    return Native.$eq(this.Obj, other.Obj);
  }
  
  @Override
  public shared_ptr<T> clone() {
    if (Obj != null) {
      throw new IllegalStateException("Expected Only empty shared_ptr to be cloned by collections defaultValue! May be push vs. push_RR mistake?");
    }
    return new shared_ptr<>();
  }
  
  @Override
  public shared_ptr<T> move() {
    return new shared_ptr<>(JD$Move.INSTANCE, this);
  }
  
  private boolean checkAlive() {
    if (should$check()) {
      check$Alive();
    }
    return true;
  }  
}

/// OwningPtr smart pointer - OwningPtr mimics a built-in pointer except that it
/// guarantees deletion of the object pointed to, either on destruction of the
/// OwningPtr or via an explicit reset().  Once created, ownership of the
/// pointee object can be taken away from OwningPtr by using the take method.
//<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr">
@Converted(kind = Converted.Kind.MANUAL, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 28,
 cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr")
//</editor-fold>
public static class unique_ptr<T> extends NativeTrace.CreateDestroy$Tracker implements Destructors.ClassWithDestructor, Native.Native$Bool, 
        NativeMoveable<unique_ptr<T>>, NativeCloneable<unique_ptr<T>>, NativeComparable<unique_ptr<T>>, NativeSwappable {
  public static <T> unique_ptr_array<T> $unique_ptr_array(/*const*/unique_ptr_array<T> /*&&*/$Prm0) {
    assert $Prm0.checkAlive();
    return new unique_ptr_array($Prm0.release());
  };
  
  public static <T> unique_ptr<T> $unique_ptr(/*const*/unique_ptr<T> /*&&*/$Prm0) {
    assert $Prm0.checkAlive();
    return new unique_ptr($Prm0.release());
  };

  public static <T> unique_ptr_with_deleter<T> $unique_ptr_with_deleter(/*const*/unique_ptr_with_deleter<T> /*&&*/$Prm0) {
    assert $Prm0.checkAlive();
    return new unique_ptr_with_deleter($Prm0.release(), $Prm0._Dp);
  };

  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::operator=">
  @Converted(kind = Converted.Kind.MANUAL, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 30,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::operator=")
  //</editor-fold>
  private unique_ptr<T> /*&*/$assign(/*const*/unique_ptr<T> /*&*/$Prm0) {
    throw new AssertionError("LLVM_DELETED_FUNCTION");
  };

  protected T /*P*/Ptr;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::OwningPtr<T>">
  @Converted(kind = Converted.Kind.MANUAL, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 33,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::OwningPtr<T>")
  //</editor-fold>
  public /*explicit*/ unique_ptr() {
    this((T)null);
  }
  public /*explicit*/ unique_ptr(T /*P*/P/*= 0*/) {
    /* : Ptr(P)*/ 
    super(P);
    //START JInit
    this.Ptr = P;
    //END JInit
    assert P == null || Native.$noteq(P, null) : "this object is $eq to null, use OwningPtrNullEq instead";
    trackInstance();
  }
  
  //<editor-fold defaultstate="collapsed" desc="std::unique_ptr::unique_ptr<_Tp, _Dp>">
  @Converted(kind = Converted.Kind.MANUAL, source = "/usr/include/c++/4.9/bits/unique_ptr.h", line = 200,
   FQN="std::unique_ptr::unique_ptr<_Tp, _Dp>", NM="_ZNSt10unique_ptrC1EDn",
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -nm=_ZNSt10unique_ptrC1EDn")
  //</editor-fold>
  public /*explicit*/ unique_ptr(JD$NullPtr _dparam, /*nullptr_t*/Object __p) {
    this((T)__p);
    assert __p == null : "only for nullptr_t";
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::OwningPtr<T>">
  @Converted(kind = Converted.Kind.MANUAL, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 29,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::OwningPtr<T>")
  //</editor-fold>
  public <X> unique_ptr(/*const*/unique_ptr<? extends X> /*&*/$Prm0) {
    super($Prm0.Ptr);
    assert $Prm0.checkAlive();
    this.Ptr = (T) $Prm0.release();
    trackInstance();
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::OwningPtr<T>">
  @Converted(kind = Converted.Kind.MANUAL, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 29,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::OwningPtr<T>")
  //</editor-fold>
  public <X> unique_ptr(JD$Unique_ptr$_Up$_Ep _dparam, /*const*/unique_ptr<? extends X> /*&*/$Prm0) {
    super($Prm0.Ptr);
    assert $Prm0.checkAlive();
    this.Ptr = (T) $Prm0.release();
    trackInstance();
  };
  
  public <X> unique_ptr(JD$Move _dparam, /*const*/unique_ptr<X> /*&&*/$Prm0) {
    this((T)$Prm0.release());
    assert $Prm0.checkAlive();
  };

  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::~OwningPtr<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 44,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::~OwningPtr<T>")
  //</editor-fold>
  public void $destroy() {
    assert checkAlive();
    if (Ptr != null) /*delete*/Destructors.$destroy(Ptr);
    Ptr = null;
    super.set$destroyed();
  }
  
  // Assignment.
  public unique_ptr<T> /*&*/$assignMove(unique_ptr<T>/*&&*/ $Prm0) {
    assert $Prm0.checkAlive();
    reset($Prm0.release());
    //get_deleter() = std::forward<deleter_type>(__u.get_deleter());
    return this;
  };
  
  //<editor-fold defaultstate="collapsed" desc="std::unique_ptr::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   FQN="std::unique_ptr::operator=", NM="_ZNSt10unique_ptraSEDn",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNSt10unique_ptraSEDn")
  //</editor-fold>
  public unique_ptr<T> /*&*/$assign_nullptr_t(Object obj) {
    assert obj == null : "Operator can be used only to assign nullptr_t!";
    reset();
    return this;
  };
  
  public unique_ptr<T> /*&*/$assign$ConvertibleNotArray(Object obj) {
    assert obj == null : "Operator can be used only to assign nullptr_t!";
    reset();
    return this;
  };
  
  //<editor-fold defaultstate="collapsed" desc="std::unique_ptr<raw_ostream, default_delete<raw_ostream> >::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "/usr/gcc-sfe/4.9/include/c++/4.9.4/bits/unique_ptr.h", line = 264,
   FQN="std::unique_ptr<raw_ostream, default_delete<raw_ostream> >::operator=", NM="_ZNSt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS1_EEaSINS0_14raw_fd_ostreamES2_IS6_EEENSt9enable_ifIXsr6__and_ISt14is_convertibleINS_IT_T0_E7pointerEPS1_ESt6__not_ISt8is_arrayISA_EEEE5valueERS4_E4typeEOSC_R_ZTSRSt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNSt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS1_EEaSINS0_14raw_fd_ostreamES2_IS6_EEENSt9enable_ifIXsr6__and_ISt14is_convertibleINS_IT_T0_E7pointerEPS1_ESt6__not_ISt8is_arrayISA_EEEE5valueERS4_E4typeEOSC_R_ZTSRSt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS1_EE")
  //</editor-fold>
  public unique_ptr<T> $assign$ConvertibleNotArray(final unique_ptr<? extends T> /*&*/ $Prm0) {
    assert $Prm0.checkAlive();
    reset($Prm0.release());
    //get_deleter().$assignMove(new $default_delete(std.<$default_delete>forward_type$_Tp(__u.get_deleter())));
    return /*Deref*/this;
  }  
  
  public T release() {
    assert checkAlive();
    T result = get();
    Ptr = null;
    return result;
  }
  
  /// reset - Change the current pointee to the specified pointer.  Note that
  /// calling this with any pointer (including a null pointer) deletes the
  /// current pointer.
  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::reset">
  @Converted(kind = Converted.Kind.MANUAL, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 51,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::reset")
  //</editor-fold>
  public void reset() {
    reset(null);
  }
  public <Derived extends T> void reset(Derived /*P*/P/*= 0*/) {
    assert checkAlive();
    if (P == Ptr) {
      return;
    }
    T /*P*/Tmp = Ptr;
    Ptr = P;
    assert P == null || Native.$noteq(P, null) : "this object is $eq to null, use OwningPtrNullEq instead";
    if (Tmp != null) /*delete*/Destructors.$destroy(Tmp);
  }

  
  /// take - Reset the owning pointer to null and return its pointer.  This does
  /// not delete the pointer before returning it.
  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::take">
  @Converted(kind = Converted.Kind.MANUAL, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 60,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::take")
  //</editor-fold>
  public T /*P*/take() {
    assert checkAlive();
    T /*P*/Tmp = Ptr;
    Ptr = null;
    return Tmp;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::operator*">
  @Converted(kind = Converted.Kind.MANUAL, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 66,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::operator*")
  //</editor-fold>
  public T /*&*/$star() /*const*/ {
    assert checkAlive();
    if (Ptr == null) {
      throw new NullPointerException("Cannot dereference null pointer");
    }
    return /*Deref*/Ptr;
  }

  @Override
  public unique_ptr<T> clone() {
    assert checkAlive();
    if (Ptr != null) {
      throw new IllegalStateException("Expected Only empty unique_ptr to be cloned by collections defaultValue! May be push vs. push_RR mistake?");
    }
    return new unique_ptr<>();
  }

  @Override
  public unique_ptr<T> move() {
    assert checkAlive();
    return new unique_ptr<>(JD$Move.INSTANCE, this);
  }
  
  public type$ref<T> /*&*/star$ref() /*const*/ {
    assert checkAlive();
    if (Ptr == null) {
      throw new NullPointerException("Cannot dereference null pointer");
    }
    return new type$ref<T>() {

        @Override
        public T $deref() {
            assert checkAlive();
            return Ptr;
        }

        @Override
        public T $set(T value) {
            assert checkAlive();
            Ptr = Native.$tryAssign(Ptr, value, false);
            return Ptr;
        }

        @Override
        public type$ptr<T> deref$ptr() {
            assert checkAlive();
            throw new UnsupportedOperationException("Not implemented yet!");
        }
    };
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::operator->">
  @Converted(kind = Converted.Kind.AUTO, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 71,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::operator->")
  //</editor-fold>
  public T /*P*/$arrow() /*const*/ {
    assert checkAlive();
    if (Ptr == null) {
      throw new NullPointerException("Cannot dereference null pointer");
    }
    return Ptr;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::get">
  @Converted(kind = Converted.Kind.AUTO, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 72,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::get")
  //</editor-fold>
  public T /*P*/get() /*const*/ {
    assert checkAlive();
    return Ptr;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::operator boolean">
  @Converted(kind = Converted.Kind.MANUAL, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 73,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::operator boolean")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    if (is$destroyed()) return false;
    return Ptr != null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::operator!">
  @Converted(kind = Converted.Kind.MANUAL, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 74,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::operator!")
  //</editor-fold>
  public boolean $not() /*const*/ {
    if (is$destroyed()) return true;
    return Ptr == null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::isValid">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/OwningPtr.h", line = 75,
    cmd = "jclank.sh ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::isValid")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    assert checkAlive();
    return Ptr != null;
  }
    
  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::swap">
  @Converted(kind = Converted.Kind.AUTO, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 76,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::swap")
  //</editor-fold>
  public void swap(unique_ptr<T> /*&*/RHS) {
    assert RHS.checkAlive();
    assert checkAlive();
    T /*P*/Tmp = RHS.Ptr;
    RHS.Ptr = Ptr;
    Ptr = Tmp;
  }

  @Override
  public boolean $eq(unique_ptr<T> other) {
    assert other.checkAlive();
    assert checkAlive();
    if (other == null) {
      return Native.$eq(this.Ptr, null, true);
    }
    return Native.$eq(this.Ptr, other.Ptr);
  }

  @Override
  public void swap(NativeSwappable RHS) {
    swap((unique_ptr)RHS);
  }
  
  @Override
  public String toString() {
    return "unique_ptr{" + "destroyed=" + is$destroyed() + ", Ptr=" + Ptr + '}';
  } 
  
  protected final boolean checkAlive() {
    if (should$check()) {
      super.check$Alive();
    }
    return true;
  }  
  
  public static <T> unique_ptr<T> $Default() {
    return DEFAULT;
  }
  private static final unique_ptr DEFAULT = new unique_ptr();
  
  //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static long instances = 0;
  private static void trackInstance() {
    if (NativeTrace.STATISTICS) instances++;
  }

  public static void clearStatistics() {
    instances = 0;
  }

  public static long printStatistics(java.io.PrintWriter out) {
    out.printf("%22s created:\t%s%n", unique_ptr.class.getSimpleName()+"(+derived)", NativeTrace.formatNumber(instances));
    NativeTrace.dumpStatisticValue(unique_ptr.class.getSimpleName(), instances);
    return instances;        
  }   
  }

public static <T> boolean $eq_shared_ptr(shared_ptr<T> primary, shared_ptr<T> second) {
  return $eq_shared_ptr$C(primary, second);
}
public static <T> boolean $eq_shared_ptr$C(shared_ptr<T> primary, shared_ptr<T> second) {
  if (primary == second) {
    return true;
  }
  return primary.$eq(second);
}

public static <T> boolean $eq_unique_ptr(unique_ptr<T> primary, unique_ptr<T> second) {
  return $eq_unique_ptr$C(primary, second);
}
public static <T> boolean $eq_unique_ptr$C(unique_ptr<T> primary, unique_ptr<T> second) {
  if (primary == second) {
    return true;
  }
  return primary.$eq(second);
}

public static <T> boolean $eq_unique_ptr(unique_ptr_with_deleter<T> primary, unique_ptr_with_deleter<T> second) {
  return $eq_unique_ptr$C(primary, second);
}
public static <T> boolean $eq_unique_ptr$C(unique_ptr_with_deleter<T> primary, unique_ptr_with_deleter<T> second) {
  if (primary == second) {
    return true;
  }
  return primary.$eq(second);
}
  
public static class unique_ptr_with_deleter<T> extends unique_ptr<T> {
  
  private final deleter<T> _Dp;
  
  public /*explicit*/ unique_ptr_with_deleter(JD$NullPtr _dparam, /*nullptr_t*/Object __p) {
    this((T)__p);
    assert __p == null : "only for nullptr_t";
  }
  public /*explicit*/ unique_ptr_with_deleter(JD$Unique_ptr$_Up$_Ep _dparam, /*nullptr_t*/Object __p) {
    this((T)__p);
    assert __p == null : "only for nullptr_t";
  }  
  public unique_ptr_with_deleter() {
    this._Dp = new default_delete<>();
    trackInstance();
  }

  public unique_ptr_with_deleter(T P) {
    super(P);
    this._Dp = new default_delete<>();
    trackInstance();
  }
  
  public unique_ptr_with_deleter(T P, deleter<T> _Dp) {
    super(P);
    this._Dp = _Dp;
    trackInstance();
  }

  public unique_ptr_with_deleter(unique_ptr $Prm0) {
    super($Prm0);
    assert $Prm0.getClass() == unique_ptr_with_deleter.class : "Copy constructor called for different class!";
    this._Dp = ((unique_ptr_with_deleter<T>)$Prm0)._Dp;
    trackInstance();
  }

  public unique_ptr_with_deleter(JD$Move _dparam, unique_ptr<T> $Prm0) {
    super(_dparam, $Prm0);
    assert $Prm0.getClass() == unique_ptr_with_deleter.class : "Move constructor called for different class!";
    this._Dp = ((unique_ptr_with_deleter<T>)$Prm0)._Dp;
    trackInstance();
  }

  @Override
  public unique_ptr<T> $assignMove(unique_ptr<T> __u) {
    super.$assignMove(__u);
    assert __u.getClass() == unique_ptr_with_deleter.class : "Move constructor called for different class!";
    assert this._Dp.getClass() == ((unique_ptr_with_deleter<T>)__u)._Dp.getClass() : "Moving to the ptr with differnet deleter!";
    return this;
  }

  @Override
  public void $destroy() {
    checkAlive();
    _Dp.$call(get());
    Ptr = null;
    super.set$destroyed();
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static long instances = 0;
  private static void trackInstance() {
    if (NativeTrace.STATISTICS) instances++;
  }

  public static void clearStatistics() {
    instances = 0;
  }

  public static long printStatistics(java.io.PrintWriter out) {
    out.printf("%22s created:%s%n", unique_ptr_with_deleter.class.getSimpleName(), NativeTrace.formatNumber(instances));
    NativeTrace.dumpStatisticValue(unique_ptr_with_deleter.class.getSimpleName(), instances);
    return instances;
  }   
}

public static class unique_ptr_array<T> extends unique_ptr<T[]> {
  
  public /*explicit*/ unique_ptr_array(JD$NullPtr _dparam, /*nullptr_t*/Object __p) {
    this((T[])__p);
    assert __p == null : "only for nullptr_t";
  }  
  public unique_ptr_array() {
    trackInstance();
  }

  public unique_ptr_array(T P[]) {
    super(P);
    trackInstance();
  }

  public unique_ptr_array(unique_ptr $Prm0) {
    super($Prm0);
    assert $Prm0.getClass() == unique_ptr_array.class : "Copy constructor called for different class!";
    trackInstance();
  }

  public unique_ptr_array(JD$Move _dparam, unique_ptr_array<T[]> $Prm0) {
    super(_dparam, $Prm0);
    assert $Prm0.getClass() == unique_ptr_array.class : "Move constructor called for different class!";
    trackInstance();
  }

  public unique_ptr_array(JD$Move _dparam, unique_ptr<T[]> $Prm0) {
    super(_dparam, $Prm0);
    assert $Prm0.getClass() == unique_ptr_array.class : "Move constructor called for different class!";
    trackInstance();
  }

  @Override
  public unique_ptr_array<T> $assignMove(unique_ptr<T[]> __u) {
    super.$assignMove(__u);
    assert __u.getClass() == unique_ptr_array.class : "Move constructor called for different class!";
    return this;
  }
  
  /// Access an element of owned array.
  public T $set(int i, T val) {
    // seems that arrays here can be treated as pointer-like
    get()[i] = Native.$tryAssign(get()[i], val, true); 
    return get()[i];
  }
  
  public type$ptr<T> ptr$at(int i) {
    return create_type$ptr(get(), i);
  }
  
  public T $at(int i) {
    return get()[i];
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static long instances = 0;
  private static void trackInstance() {
    if (NativeTrace.STATISTICS) instances++;
  }

  public static void clearStatistics() {
    instances = 0;
  }

  public static long printStatistics(java.io.PrintWriter out) {
    out.printf("%22s created:%s%n", unique_ptr_array.class.getSimpleName(), NativeTrace.formatNumber(instances));
    NativeTrace.dumpStatisticValue(unique_ptr_array.class.getSimpleName(), instances);
    return instances;
  }   
}

/// OwningPtr smart pointer - OwningPtr mimics a built-in pointer except that it
/// guarantees deletion of the object pointed to, either on destruction of the
/// OwningPtr or via an explicit reset().  Once created, ownership of the
/// pointee object can be taken away from OwningPtr by using the take method.
///
/// VV: This is the wrapper for pointers which can be compared to 'null', 
/// otherwise use lightweight OwningPtr 
/// 
//<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr">
@Converted(kind = Converted.Kind.MANUAL, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 28,
 cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr")
//</editor-fold>
public static class unique_ptr_null_eq<T extends NativeComparable> extends NativeTrace.CreateDestroy$Tracker implements Destructors.ClassWithDestructor, Native.Native$Bool   {
  
  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::OwningPtr<T>">
  @Converted(kind = Converted.Kind.MANUAL, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 29,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::OwningPtr<T>")
  //</editor-fold>
  private unique_ptr_null_eq(/*const*/unique_ptr_null_eq<T> /*&*/$Prm0) {
    throw new AssertionError("LLVM_DELETED_FUNCTION");
  };

  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::operator=">
  @Converted(kind = Converted.Kind.MANUAL, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 30,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::operator=")
  //</editor-fold>
  private unique_ptr_null_eq<T> /*&*/$assign(/*const*/unique_ptr_null_eq<T> /*&*/$Prm0) {
    throw new AssertionError("LLVM_DELETED_FUNCTION");
  };

  private T /*P*/Ptr;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::OwningPtr<T>">
  @Converted(kind = Converted.Kind.MANUAL, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 33,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::OwningPtr<T>")
  //</editor-fold>
  public /*explicit*/ unique_ptr_null_eq() {
    this((T)null);
  }
  public /*explicit*/ unique_ptr_null_eq(JD$NullPtr _dparam, /*nullptr_t*/Object __p) {
    this((T)__p);
    assert __p == null : "only for nullptr_t";
  }  
  public /*explicit*/ unique_ptr_null_eq(T /*P*/P/*= 0*/) {
    /* : Ptr(P)*/ 
    super(P);
    //START JInit
    this.Ptr = P;
    //END JInit
    assert P == null || Native.$eq(P, null) : "this object is not $eq to null, use OwningPtr instead";
    trackInstance();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::~OwningPtr<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 44,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::~OwningPtr<T>")
  //</editor-fold>
  public void $destroy() {
    assert checkAlive();
    if (Ptr != null) /*delete*/Destructors.$destroy(Ptr);
    Ptr = null;
    super.set$destroyed();
  }

  
  /// reset - Change the current pointee to the specified pointer.  Note that
  /// calling this with any pointer (including a null pointer) deletes the
  /// current pointer.
  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::reset">
  @Converted(kind = Converted.Kind.MANUAL, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 51,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::reset")
  //</editor-fold>
  public void reset() {
    reset(null);
  }
  public void reset(T /*P*/P/*= 0*/) {
    assert checkAlive();
    if (P == Ptr) {
      return;
    }
    assert P == null || Native.$eq(P, null) : "this object is not $eq to null, use OwningPtr instead";
    T /*P*/Tmp = Ptr;
    Ptr = P;
    if (Tmp != null) /*delete*/Destructors.$destroy(Tmp);
  }

  
  /// take - Reset the owning pointer to null and return its pointer.  This does
  /// not delete the pointer before returning it.
  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::take">
  @Converted(kind = Converted.Kind.MANUAL, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 60,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::take")
  //</editor-fold>
  public T /*P*/take() {
    assert checkAlive();
    T /*P*/Tmp = Ptr;
    Ptr = null;
    return Tmp;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::operator*">
  @Converted(kind = Converted.Kind.MANUAL, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 66,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::operator*")
  //</editor-fold>
  public T /*&*/$star() /*const*/ {
    assert checkAlive();
    if (Ptr == null) {
      throw new NullPointerException("Cannot dereference null pointer");
    }
    return /*Deref*/Ptr;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::operator->">
  @Converted(kind = Converted.Kind.AUTO, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 71,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::operator->")
  //</editor-fold>
  public T /*P*/$arrow() /*const*/ {
    assert checkAlive();
    if (Ptr == null) {
      throw new NullPointerException("Cannot dereference null pointer");
    }
    return Ptr;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::get">
  @Converted(kind = Converted.Kind.AUTO, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 72,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::get")
  //</editor-fold>
  public T /*P*/get() /*const*/ {
    assert checkAlive();
    return Ptr;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::operator boolean">
  @Converted(kind = Converted.Kind.MANUAL, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 73,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::operator boolean")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    if (is$destroyed()) return false;
    return (Ptr == null) ? false : $noteq(Ptr, null);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::operator!">
  @Converted(kind = Converted.Kind.MANUAL, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 74,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::operator!")
  //</editor-fold>
  public boolean $not() /*const*/ {
    if (is$destroyed()) return true;
    return (Ptr == null) ? true : $eq(Ptr, null);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::isValid">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/OwningPtr.h", line = 75,
    cmd = "jclank.sh ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::isValid")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    assert checkAlive();
    return (Ptr == null) ? false : $noteq(Ptr, null);
  }
    
  //<editor-fold defaultstate="collapsed" desc="llvm::OwningPtr::swap">
  @Converted(kind = Converted.Kind.AUTO, source = "$LLVM_SRC/llvm/include/llvm/ADT/OwningPtr.h", line = 76,
   cmd="jclank.sh $LLVM_SRC/llvm/lib/Support/MemoryBuffer.cpp -filter=llvm::OwningPtr::swap")
  //</editor-fold>
  public void swap(unique_ptr_null_eq<T> /*&*/RHS) {
    assert RHS.checkAlive();
    assert checkAlive();
    T /*P*/Tmp = RHS.Ptr;
    RHS.Ptr = Ptr;
    Ptr = Tmp;
  }
  
  private boolean checkAlive() {
    if (should$check()) {
      check$Alive();
    }
    return true;
  }

  @Override
  public String toString() {
    return "unique_ptr_null_eq{" + "destroyed=" + is$destroyed() + ", Ptr=" + Ptr + '}';
  } 
  
  //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static long instances = 0;
  private static void trackInstance() {
    if (NativeTrace.STATISTICS) instances++;
  }

  public static void clearStatistics() {
    instances = 0;
  }

  public static long printStatistics(java.io.PrintWriter out) {
    out.printf("%22s created:\t%s%n", unique_ptr_null_eq.class.getSimpleName(), NativeTrace.formatNumber(instances));
    NativeTrace.dumpStatisticValue(unique_ptr_null_eq.class.getSimpleName(), instances);
    return instances;        
  }   
}

/**
 *  @brief  A simple smart pointer providing strict ownership semantics.
 *
 *  The Standard says:
 *  <pre>
 *  An @c auto_ptr owns the object it holds a pointer to.  Copying
 *  an @c auto_ptr copies the pointer and transfers ownership to the
 *  destination.  If more than one @c auto_ptr owns the same object
 *  at the same time the behavior of the program is undefined.
 *
 *  The uses of @c auto_ptr include providing temporary
 *  exception-safety for dynamically allocated memory, passing
 *  ownership of dynamically allocated memory to a function, and
 *  returning dynamically allocated memory from a function.  @c
 *  auto_ptr does not meet the CopyConstructible and Assignable
 *  requirements for Standard Library <a
 *  href="tables.html#65">container</a> elements and thus
 *  instantiating a Standard Library container with an @c auto_ptr
 *  results in undefined behavior.
 *  </pre>
 *  Quoted from [20.4.5]/3.
 *
 *  Good examples of what can and cannot be done with auto_ptr can
 *  be found in the libstdc++ testsuite.
 *
 *  _GLIBCXX_RESOLVE_LIB_DEFECTS
 *  127.  auto_ptr<> conversion issues
 *  These resolutions have all been incorporated.
 * 
 *  JAVA: extends unique_ptr for now
 */
public static class auto_ptr<T> extends unique_ptr<T> {
  public auto_ptr() {
    super();
  }

  public auto_ptr(T P) {
    super(P);
  }

  public auto_ptr(JD$NullPtr _dparam, Object __p) {
    super(_dparam, __p);
  }

  public auto_ptr(auto_ptr<? extends T> $Prm0) {
    super($Prm0);
  }

  public auto_ptr(JD$Move _dparam, auto_ptr<T> $Prm0) {
    super(_dparam, $Prm0);
  } 
  
  /**
   *  @brief  %auto_ptr assignment operator.
   *  @param  __a  Another %auto_ptr of the same type.
   *
   *  This object now @e owns the object previously owned by @a __a,
   *  which has given up ownership.  The object that this one @e
   *  used to own and track has been deleted.
   */
  public auto_ptr<T> $assign(auto_ptr<T> __a) {
    reset(__a.release());
    return this;
  }
}

}
