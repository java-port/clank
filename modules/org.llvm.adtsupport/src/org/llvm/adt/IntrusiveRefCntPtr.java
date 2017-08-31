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

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clank.support.Native.NativePOD;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.support.*;
import org.llvm.adt.*;

/*template <typename T> TEMPLATE*/

//===----------------------------------------------------------------------===//
/// IntrusiveRefCntPtr - A template class that implements a "smart pointer"
///  that assumes the wrapped object has a reference count associated
///  with it that can be managed via calls to
///  IntrusivePtrAddRef/IntrusivePtrRelease.  The smart pointers
///  manage reference counts via the RAII idiom: upon creation of
///  smart pointer the reference count of the wrapped object is
///  incremented and upon destruction of the smart pointer the
///  reference count is decremented.  This class also safely handles
///  wrapping NULL pointers.
///
/// Reference counting is implemented via calls to
///  Obj->Retain()/Obj->Release(). Release() is required to destroy
///  the object when the reference count reaches zero. Inheriting from
///  RefCountedBase/RefCountedBaseVPTR takes care of this
///  automatically.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 134,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 135,
 FQN = "llvm::IntrusiveRefCntPtr", NM = "_ZN4llvm18IntrusiveRefCntPtrE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm18IntrusiveRefCntPtrE")
//</editor-fold>
public class IntrusiveRefCntPtr</*typename*/ T>  extends NativeTrace.CreateDestroy$Tracker implements Destructors.ClassWithDestructor, NativeMoveable<IntrusiveRefCntPtr<T>>, NativePOD<IntrusiveRefCntPtr<T>>, Native.Native$Bool, simplify_type  {
  private T /*P*/ Obj;
/*public:*/
  /*typedef T element_type*/
//  public final class element_type extends T{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::IntrusiveRefCntPtr<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 141,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 142,
   FQN = "llvm::IntrusiveRefCntPtr::IntrusiveRefCntPtr<T>", NM = "_ZN4llvm18IntrusiveRefCntPtrC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm18IntrusiveRefCntPtrC1Ev")
  //</editor-fold>
  public /*explicit*/ IntrusiveRefCntPtr() {
    super(null);
    /* : Obj(null)*/ 
    //START JInit
    this.Obj = null;
    //END JInit    
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::IntrusiveRefCntPtr<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 143,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 144,
   FQN = "llvm::IntrusiveRefCntPtr::IntrusiveRefCntPtr<T>", NM = "_ZN4llvm18IntrusiveRefCntPtrC1EPT_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm18IntrusiveRefCntPtrC1EPT_")
  //</editor-fold>
  public IntrusiveRefCntPtr(T /*P*/ obj) {
    super(obj);
    /* : Obj(obj)*/ 
    //START JInit
    this.Obj = obj;
    //END JInit
    retain();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::IntrusiveRefCntPtr<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 147,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 148,
   FQN = "llvm::IntrusiveRefCntPtr::IntrusiveRefCntPtr<T>", NM = "_ZN4llvm18IntrusiveRefCntPtrC1ERKNS_18IntrusiveRefCntPtrIT_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm18IntrusiveRefCntPtrC1ERKNS_18IntrusiveRefCntPtrIT_EE")
  //</editor-fold>
  public <X> IntrusiveRefCntPtr(/*const*/ IntrusiveRefCntPtr<X> /*&*/ S) {
    /* : Obj(S.Obj)*/ 
    super(S.Obj);
    assert S.checkAlive();
    //START JInit
    this.Obj = (T)S.Obj;
    //END JInit
    retain();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::IntrusiveRefCntPtr<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 151,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 152,
   FQN = "llvm::IntrusiveRefCntPtr::IntrusiveRefCntPtr<T>", NM = "_ZN4llvm18IntrusiveRefCntPtrC1EONS_18IntrusiveRefCntPtrIT_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm18IntrusiveRefCntPtrC1EONS_18IntrusiveRefCntPtrIT_EE")
  //</editor-fold>
  public <X> IntrusiveRefCntPtr(JD$Move _dparam, IntrusiveRefCntPtr<X> /*&&*/S) {
    /* : Obj(S.Obj)*/ 
    super(S.Obj);
    assert S.checkAlive();
    //START JInit
    this.Obj = (T)S.Obj;
    //END JInit
    S.Obj = null;
  }

  
//  /*template <class X> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::IntrusiveRefCntPtr<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 157,
   FQN="llvm::IntrusiveRefCntPtr::IntrusiveRefCntPtr<T>", NM="_ZN4llvm18IntrusiveRefCntPtrC1EONS_18IntrusiveRefCntPtrIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm18IntrusiveRefCntPtrC1EONS_18IntrusiveRefCntPtrIT_EE")
  //</editor-fold>
  public </*class*/ X> IntrusiveRefCntPtr(JD$MoveDerived _dparam, IntrusiveRefCntPtr<X> /*&&*/S) {
    /* : Obj(S.get())*/ 
    super(S.Obj);
    assert S.checkAlive();
    //START JInit
    this.Obj = (T) S.get();
    //END JInit
    S.Obj = null;
  }
  
  /*template <class X> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::IntrusiveRefCntPtr<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 161,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 160,
   FQN="llvm::IntrusiveRefCntPtr::IntrusiveRefCntPtr<T>", NM="Tpl__ZN4llvm18IntrusiveRefCntPtrC1ERKNS_18IntrusiveRefCntPtrIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=Tpl__ZN4llvm18IntrusiveRefCntPtrC1ERKNS_18IntrusiveRefCntPtrIT_EE")
  //</editor-fold>
  public </*class*/ X> IntrusiveRefCntPtr(JD$IntrusiveRefCntPtr$X$C _dparam, final /*const*/ IntrusiveRefCntPtr<X> /*&*/ S) {
    // : Obj(S.get()) 
    super(S.Obj);
    assert S.checkAlive();
    //START JInit
    this.Obj = (T)/*ParenListExpr*/S.get();
    //END JInit
    retain();
  }
  
  /*template <class X> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::IntrusiveRefCntPtr<T>">
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 161,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 160,
   FQN="llvm::IntrusiveRefCntPtr::IntrusiveRefCntPtr<T>", NM="Tpl__ZN4llvm18IntrusiveRefCntPtrC1ERKNS_18IntrusiveRefCntPtrIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=Tpl__ZN4llvm18IntrusiveRefCntPtrC1ERKNS_18IntrusiveRefCntPtrIT_EE")
  //</editor-fold>
  public </*class*/ X> IntrusiveRefCntPtr(JD$IntrusiveRefCntPtr$X _dparam, IntrusiveRefCntPtr<X> /*&*/S) {
    this(JD$IntrusiveRefCntPtr$X$C.INSTANCE, S);
  }

  //  /*template <class X> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::IntrusiveRefCntPtr<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 162,
   FQN="llvm::IntrusiveRefCntPtr::IntrusiveRefCntPtr<T>", NM="_ZN4llvm18IntrusiveRefCntPtrC1ERKNS_18IntrusiveRefCntPtrIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm18IntrusiveRefCntPtrC1ERKNS_18IntrusiveRefCntPtrIT_EE")
  //</editor-fold>
  public </*class*/ X> IntrusiveRefCntPtr(JD$CopyDerived _dparam, /*const*/ IntrusiveRefCntPtr<X> /*&*/ S) {
    /* : Obj(S.get())*/ 
    super(S.Obj);
    assert S.checkAlive();
    //START JInit
    this.Obj = (T) S.get();
    //END JInit
    retain();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 166,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 167,
   FQN = "llvm::IntrusiveRefCntPtr::operator=", NM = "_ZN4llvm18IntrusiveRefCntPtraSENS_18IntrusiveRefCntPtrIT_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm18IntrusiveRefCntPtraSENS_18IntrusiveRefCntPtrIT_EE")
  //</editor-fold>
  public IntrusiveRefCntPtr<T> /*&*/ $assign(IntrusiveRefCntPtr<T> S) {
    assert S.checkAlive();
    if (is$destroyed()) {
      // can be reused from collections
      assert Obj == null;
      clear$destroyed();
    }
    swap(S);
    return /*Deref*/this;
  }

  public IntrusiveRefCntPtr<T> /*&*/ $assignMove(IntrusiveRefCntPtr<T> S) {
    assert S.checkAlive();
    if (is$destroyed()) {
      // can be reused from collections
      assert Obj == null;
      clear$destroyed();
    }
    // release possible reference ???
    release();
    this.Obj = (T)S.Obj;
    //END JInit
    S.Obj = null;
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::~IntrusiveRefCntPtr<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 171,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 172,
   FQN = "llvm::IntrusiveRefCntPtr::~IntrusiveRefCntPtr<T>", NM = "_ZN4llvm18IntrusiveRefCntPtrD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm18IntrusiveRefCntPtrD0Ev")
  //</editor-fold>
  public void $destroy() {
    assert checkAlive();
    release();
    Obj = null;
    super.set$destroyed();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::operator*">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 173,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 174,
   FQN = "llvm::IntrusiveRefCntPtr::operator*", NM = "_ZNK4llvm18IntrusiveRefCntPtrdeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZNK4llvm18IntrusiveRefCntPtrdeEv")
  //</editor-fold>
  public T /*&*/ $star() /*const*/ {
    assert checkAlive();
    return $Deref(Obj);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::operator->">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 175,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 176,
   FQN = "llvm::IntrusiveRefCntPtr::operator->", NM = "_ZNK4llvm18IntrusiveRefCntPtrptEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZNK4llvm18IntrusiveRefCntPtrptEv")
  //</editor-fold>
  public T /*P*/ $arrow() /*const*/ {
    assert checkAlive();
    return Obj;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::get">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 177,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 178,
   FQN = "llvm::IntrusiveRefCntPtr::get", NM = "_ZNK4llvm18IntrusiveRefCntPtr3getEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZNK4llvm18IntrusiveRefCntPtr3getEv")
  //</editor-fold>
  public T /*P*/ get() /*const*/ {
    assert checkAlive();
    return Obj;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::operator bool">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 180,
   FQN="llvm::IntrusiveRefCntPtr::operator bool", NM="_ZNK4llvm18IntrusiveRefCntPtrcvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZNK4llvm18IntrusiveRefCntPtrcvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    assert checkAlive();
    return Obj != null;
  }

//  /*typedef T *(IntrusiveRefCntPtr<T>::*unspecified_bool_type)() __attribute__((cdecl)) const*/
//  public final class unspecified_bool_type extends T * (IntrusiveRefCntPtr<T>/*::**/)()/* __attribute__((cdecl))*/ /*const*/{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::operator type-parameter-0-0 * (IntrusiveRefCntPtr<T>/*::**/)(void)/* __attribute__((cdecl))*/ /*const*/">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 157,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -filter=llvm::IntrusiveRefCntPtr::operator type-parameter-0-0 * (IntrusiveRefCntPtr<T>/*::**/)(void)/* __attribute__((cdecl))*/ /*const*/")
  //</editor-fold>
  public T $Void2RetType() {
    assert checkAlive();
    return Obj == null ? null : Obj;
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::swap">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 181,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 182,
   FQN = "llvm::IntrusiveRefCntPtr::swap", NM = "_ZN4llvm18IntrusiveRefCntPtr4swapERNS_18IntrusiveRefCntPtrIT_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm18IntrusiveRefCntPtr4swapERNS_18IntrusiveRefCntPtrIT_EE")
  //</editor-fold>
  public void swap(IntrusiveRefCntPtr<T> /*&*/ other) {
    assert other.checkAlive();
    assert checkAlive();
    T /*P*/ tmp = other.Obj;
    other.Obj = Obj;
    Obj = tmp;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::reset">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 187,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 188,
   FQN = "llvm::IntrusiveRefCntPtr::reset", NM = "_ZN4llvm18IntrusiveRefCntPtr5resetEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm18IntrusiveRefCntPtr5resetEv")
  //</editor-fold>
  public void reset() {
    assert checkAlive();
    release();
    Obj = null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::resetWithoutRelease">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 192,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 193,
   FQN = "llvm::IntrusiveRefCntPtr::resetWithoutRelease", NM = "_ZN4llvm18IntrusiveRefCntPtr19resetWithoutReleaseEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm18IntrusiveRefCntPtr19resetWithoutReleaseEv")
  //</editor-fold>
  public void resetWithoutRelease() {
    assert checkAlive();
    Obj = null;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::retain">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 197,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 198,
   FQN = "llvm::IntrusiveRefCntPtr::retain", NM = "_ZN4llvm18IntrusiveRefCntPtr6retainEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm18IntrusiveRefCntPtr6retainEv")
  //</editor-fold>
  private void retain() {
    assert checkAlive();
    if (Obj != null) {
      IntrusiveRefCntPtrInfo.<T>retain(Obj);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IntrusiveRefCntPtr::release">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 198,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 199,
   FQN = "llvm::IntrusiveRefCntPtr::release", NM = "_ZN4llvm18IntrusiveRefCntPtr7releaseEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm18IntrusiveRefCntPtr7releaseEv")
  //</editor-fold>
  private void release() {
    assert checkAlive();
    if (Obj != null) {
      IntrusiveRefCntPtrInfo.<T>release(Obj);
    }
  }

  
  /*friend template <typename X> class IntrusiveRefCntPtr*/
  
  public String toString() {
    return "IntrusiveRefCntPtr{" + (is$destroyed() ? "DESTROYED;" : "") + "Obj=" + NativeTrace.getIdentityStr(Obj)+"}"; // NOI18N
  }

  @Override public Object getSimplifiedValue(Object $This) {
    assert checkAlive();
    assert $This == this : "must be called on itself " + $This + " vs. " + this;
    return llvm.getSimplifiedValue(Obj);
  }

  @Override
  public IntrusiveRefCntPtr<T> move() {
    assert checkAlive();
    return new IntrusiveRefCntPtr<>(JD$Move.INSTANCE, this);
  }

  @Override
  public boolean $eq(IntrusiveRefCntPtr<T> other) {
    assert other.checkAlive();
    assert checkAlive();
    return other != null && (other.Obj == this.Obj);
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  @Override
  public IntrusiveRefCntPtr<T> clone() {
    assert checkAlive();
    assert checkValidClone();
    if (this.Obj == null) {
      return new IntrusiveRefCntPtr<>(this);
    } else {
      // use move?
//      return new IntrusiveRefCntPtr<>(JD$Move.INSTANCE, this);
      return new IntrusiveRefCntPtr<>(this);
    }
  }
  
  private boolean checkValidClone() {
    if (this.Obj != null) {
      // this is possible as push into collections
    }
    return true;
  }
  
  private boolean checkAlive() {
    if (should$check()) {
      check$Alive();
    }
    return true;
  }  
  
  public boolean test$isDestroyed() {
    return super.is$destroyed();
  }
}
