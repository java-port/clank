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

import org.clank.support.*;
import org.llvm.adt.*;

/*template <class Derived> TEMPLATE*/

//===----------------------------------------------------------------------===//
/// RefCountedBase - A generic base class for objects that wish to
///  have their lifetimes managed using reference counts. Classes
///  subclass RefCountedBase to obtain such functionality, and are
///  typically handled with IntrusiveRefCntPtr "smart pointers" (see below)
///  which automatically handle the management of reference counts.
///  Objects that subclass RefCountedBase should not be allocated on
///  the stack, as invoking "delete" (which is called when the
///  reference count hits 0) on such objects is an error.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="llvm::RefCountedBase">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 43,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 44,
 FQN = "llvm::RefCountedBase", NM = "_ZN4llvm14RefCountedBaseE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm14RefCountedBaseE")
//</editor-fold>
public class RefCountedBase</*class*/ Derived> implements RefCountedBaseImplementation {
  private /*mutable *//*uint*/int ref_cnt;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::RefCountedBase::RefCountedBase<Derived>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 48,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 49,
   FQN = "llvm::RefCountedBase::RefCountedBase<Derived>", NM = "_ZN4llvm14RefCountedBaseC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm14RefCountedBaseC1Ev")
  //</editor-fold>
  public RefCountedBase() {
    $RefCountedBase();
  }
  public void $RefCountedBase() {
    /* : ref_cnt(0)*/ 
    //START JInit
    this.ref_cnt = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RefCountedBase::RefCountedBase<Derived>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 49,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 50,
   FQN = "llvm::RefCountedBase::RefCountedBase<Derived>", NM = "_ZN4llvm14RefCountedBaseC1ERKNS_14RefCountedBaseIT_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm14RefCountedBaseC1ERKNS_14RefCountedBaseIT_EE")
  //</editor-fold>
  public RefCountedBase(/*const*/RefCountedBase<Derived> /*&*/ $Prm0) {
    /* : ref_cnt(0)*/ 
    //START JInit
    this.ref_cnt = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RefCountedBase::Retain">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 51,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 52,
   FQN = "llvm::RefCountedBase::Retain", NM = "_ZNK4llvm14RefCountedBase6RetainEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZNK4llvm14RefCountedBase6RetainEv")
  //</editor-fold>
  public final void Retain() /*const*/ {
    ++ref_cnt;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RefCountedBase::Release">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 52,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 53,
   FQN = "llvm::RefCountedBase::Release", NM = "_ZNK4llvm14RefCountedBase7ReleaseEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZNK4llvm14RefCountedBase7ReleaseEv")
  //</editor-fold>
  public final void Release() /*const*/ {
    //((ref_cnt > 0 && "Reference count is already zero.") ? (/*static_cast*/void)(0) : __assert_fail("ref_cnt > 0 && \"Reference count is already zero.\"", ${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", 53, __PRETTY_FUNCTION__));
    if (--ref_cnt == 0) {
      DoDestroy();
    }
  }

  public void $destroy() {
    
  }

  protected void DoDestroy() {    
    /*delete*/
    Destructors.$destroy((/*static_cast*//*const*/Derived /*P*/) (this));
  }
}
