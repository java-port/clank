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

package org.llvm.support.sys;

import org.clank.support.*;
import static org.llvm.support.AdtsupportLlvmGlobals.llvm_is_multithreaded;

/*template <bool mt_only> TEMPLATE*/

/// SmartMutex - A mutex with a compile time constant parameter that
/// indicates whether this mutex should become a no-op when we're not
/// running in multithreaded mode.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::SmartMutex">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Mutex.h", line = 90,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Mutex.h", old_line = 88,
 FQN = "llvm::sys::SmartMutex", NM = "_ZN4llvm3sys10SmartMutexE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Mutex.cpp -nm=_ZN4llvm3sys10SmartMutexE")
//</editor-fold>
public class SmartMutex  implements Destructors.ClassWithDestructor {
  private MutexImpl impl;
  private final boolean mt_only;
  private /*uint*/int acquired;
  private boolean recursive;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::SmartMutex::SmartMutex<mt_only>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Mutex.h", line = 96,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Mutex.h", old_line = 94,
   FQN = "llvm::sys::SmartMutex::SmartMutex<mt_only>", NM = "_ZN4llvm3sys10SmartMutexC1Eb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Mutex.cpp -nm=_ZN4llvm3sys10SmartMutexC1Eb")
  //</editor-fold>
  public /*explicit*/ SmartMutex(boolean mt_only) {
    this(mt_only, true);
  }
  public /*explicit*/ SmartMutex(boolean mt_only, boolean rec) {
    /* : impl(rec), acquired(0), recursive(rec)*/ 
    //START JInit
    this.impl = new MutexImpl(rec);
    this.acquired = 0;
    this.recursive = rec;
    //END JInit
    this.mt_only = mt_only;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::SmartMutex::lock">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Mutex.h", line = 99,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Mutex.h", old_line = 97,
   FQN = "llvm::sys::SmartMutex::lock", NM = "_ZN4llvm3sys10SmartMutex4lockEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Mutex.cpp -nm=_ZN4llvm3sys10SmartMutex4lockEv")
  //</editor-fold>
  public boolean lock() {
    if (!mt_only || llvm_is_multithreaded()) {
      return impl.acquire();
    } else {
      // Single-threaded debugging code.  This would be racy in
      // multithreaded mode, but provides not sanity checks in single
      // threaded mode.
      assert ((recursive || acquired == 0)) : "Lock already acquired!!";
      ++acquired;
      return true;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::SmartMutex::unlock">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Mutex.h", line = 112,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Mutex.h", old_line = 110,
   FQN = "llvm::sys::SmartMutex::unlock", NM = "_ZN4llvm3sys10SmartMutex6unlockEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Mutex.cpp -nm=_ZN4llvm3sys10SmartMutex6unlockEv")
  //</editor-fold>
  public boolean unlock() {
    if (!mt_only || llvm_is_multithreaded()) {
      return impl.release();
    } else {
      // Single-threaded debugging code.  This would be racy in
      // multithreaded mode, but provides not sanity checks in single
      // threaded mode.
      assert (((recursive && (acquired != 0)) || (acquired == 1))) : "Lock not acquired before release!";
      --acquired;
      return true;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::SmartMutex::try_lock">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Mutex.h", line = 126,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Mutex.h", old_line = 124,
   FQN = "llvm::sys::SmartMutex::try_lock", NM = "_ZN4llvm3sys10SmartMutex8try_lockEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Mutex.cpp -nm=_ZN4llvm3sys10SmartMutex8try_lockEv")
  //</editor-fold>
  public boolean try_lock() {
    if (!mt_only || llvm_is_multithreaded()) {
      return impl.tryacquire();
    } else {
      return true;
    }
  }

/*private:*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::sys::SmartMutex::SmartMutex<mt_only>">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Mutex.h", line = 131,
//   FQN="llvm::sys::SmartMutex::SmartMutex<mt_only>", NM="_ZN4llvm3sys10SmartMutexC1ERKNS0_10SmartMutexIXT_EEE",
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/Mutex.cpp -nm=_ZN4llvm3sys10SmartMutexC1ERKNS0_10SmartMutexIXT_EEE")
//  //</editor-fold>
//  private SmartMutex(/*const*/SmartMutex/*<mt_only>*//*&*/ original) {
//    throw new UnsupportedOperationException("Deleted!");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::sys::SmartMutex::operator=">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Mutex.h", line = 132,
//   FQN="llvm::sys::SmartMutex::operator=", NM="_ZN4llvm3sys10SmartMutexaSERKNS0_10SmartMutexIXT_EEE",
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/Mutex.cpp -nm=_ZN4llvm3sys10SmartMutexaSERKNS0_10SmartMutexIXT_EEE")
//  //</editor-fold>
//  private void $assign(/*const*/SmartMutex/*<mt_only>*//*&*/ $Prm0) {
//    throw new UnsupportedOperationException("Deleted!");
//  }

  @Override
  public void $destroy() {
    Native.destroy(impl);
  }
  
  @Converted(kind = Converted.Kind.DUMMY)
  public boolean mt_only() {
    return mt_only;
  }
  
  public String toString() {
    return "" + "impl=" + impl // NOI18N
              + ", acquired=" + acquired // NOI18N
              + ", recursive=" + recursive; // NOI18N
  }
}
