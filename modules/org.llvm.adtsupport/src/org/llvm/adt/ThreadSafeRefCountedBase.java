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
import org.clank.support.*;
import org.llvm.adt.*;

/*template <class Derived> TEMPLATE*/

/// \brief A thread-safe version of \c llvm::RefCountedBase.
///
/// A generic base class for objects that wish to have their lifetimes managed
/// using reference counts. Classes subclass \c ThreadSafeRefCountedBase to
/// obtain such functionality, and are typically handled with
/// \c IntrusiveRefCntPtr "smart pointers" which automatically handle the
/// management of reference counts.
//<editor-fold defaultstate="collapsed" desc="llvm::ThreadSafeRefCountedBase">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 99,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 100,
 FQN = "llvm::ThreadSafeRefCountedBase", NM = "_ZN4llvm24ThreadSafeRefCountedBaseE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm24ThreadSafeRefCountedBaseE")
//</editor-fold>
public abstract class ThreadSafeRefCountedBase</*class*/ Derived>  implements RefCountedBaseImplementation, Destructors.ClassWithDestructor {
  private /*mutable */std.atomicInt RefCount;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ThreadSafeRefCountedBase::ThreadSafeRefCountedBase<Derived>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 104,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 105,
   FQN = "llvm::ThreadSafeRefCountedBase::ThreadSafeRefCountedBase<Derived>", NM = "_ZN4llvm24ThreadSafeRefCountedBaseC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm24ThreadSafeRefCountedBaseC1Ev")
  //</editor-fold>
  protected ThreadSafeRefCountedBase() {
    /* : RefCount(0)*/ 
    //START JInit
    this.RefCount = new std.atomicInt(0);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ThreadSafeRefCountedBase::Retain">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 107,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 108,
   FQN = "llvm::ThreadSafeRefCountedBase::Retain", NM = "_ZNK4llvm24ThreadSafeRefCountedBase6RetainEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZNK4llvm24ThreadSafeRefCountedBase6RetainEv")
  //</editor-fold>
  public final void Retain() /*const*/ {
    RefCount.$preInc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ThreadSafeRefCountedBase::Release">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 109,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 110,
   FQN = "llvm::ThreadSafeRefCountedBase::Release", NM = "_ZNK4llvm24ThreadSafeRefCountedBase7ReleaseEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZNK4llvm24ThreadSafeRefCountedBase7ReleaseEv")
  //</editor-fold>
  public final void Release() /*const*/ {
    int NewRefCount = RefCount.$preDec();
    assert (NewRefCount >= 0) : "Reference count was already zero.";
    if (NewRefCount == 0) {
      /*delete*/Destructors.$destroy(((/*static_cast*//*const*/ Derived /*P*/ )(this)));
    }
  }

  @Override
  public void $destroy() {
    assert RefCount.$int() == 0 ;
    RefCount.$destroy();
  }
  
  public String toString() {
    return "" + "RefCount=" + RefCount; // NOI18N
  }
}
