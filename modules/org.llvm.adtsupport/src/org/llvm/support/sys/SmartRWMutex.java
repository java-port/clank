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
import static org.clank.support.Unsigned.*;
import org.llvm.support.AdtsupportLlvmGlobals;


/// SmartMutex - An R/W mutex with a compile time constant parameter that
/// indicates whether this mutex should become a no-op when we're not
/// running in multithreaded mode.
/*template <bool mt_only> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::sys::SmartRWMutex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/RWMutex.h", line = 89,
 FQN="llvm::sys::SmartRWMutex", NM="_ZN4llvm3sys12SmartRWMutexE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp -nm=_ZN4llvm3sys12SmartRWMutexE")
//</editor-fold>
public class SmartRWMutex implements Destructors.ClassWithDestructor {
  /*template parameter*/ private final boolean mt_only;

  private RWMutexImpl impl;
  private /*uint*/int readers;
  private /*uint*/int writers;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::SmartRWMutex::SmartRWMutex<mt_only>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/RWMutex.h", line = 94,
   FQN="llvm::sys::SmartRWMutex::SmartRWMutex<mt_only>", NM="_ZN4llvm3sys12SmartRWMutexC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp -nm=_ZN4llvm3sys12SmartRWMutexC1Ev")
  //</editor-fold>
  public /*explicit*/ SmartRWMutex(boolean mt_only) {
    // : impl(), readers(0), writers(0)
    //START JInit
    /*template parameter*/ this.mt_only = mt_only;
    this.impl = new RWMutexImpl();
    this.readers = 0;
    this.writers = 0;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::sys::SmartRWMutex::lock_shared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/RWMutex.h", line = 96,
   FQN="llvm::sys::SmartRWMutex::lock_shared", NM="_ZN4llvm3sys12SmartRWMutex11lock_sharedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp -nm=_ZN4llvm3sys12SmartRWMutex11lock_sharedEv")
  //</editor-fold>
  public boolean lock_shared() {
    if (!mt_only || AdtsupportLlvmGlobals.llvm_is_multithreaded()) {
      return impl.reader_acquire();
    }

    // Single-threaded debugging code.  This would be racy in multithreaded
    // mode, but provides not sanity checks in single threaded mode.
    ++readers;
    return true;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::sys::SmartRWMutex::unlock_shared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/RWMutex.h", line = 106,
   FQN="llvm::sys::SmartRWMutex::unlock_shared", NM="_ZN4llvm3sys12SmartRWMutex13unlock_sharedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp -nm=_ZN4llvm3sys12SmartRWMutex13unlock_sharedEv")
  //</editor-fold>
  public boolean unlock_shared() {
    if (!mt_only || AdtsupportLlvmGlobals.llvm_is_multithreaded()) {
      return impl.reader_release();
    }

    // Single-threaded debugging code.  This would be racy in multithreaded
    // mode, but provides not sanity checks in single threaded mode.
    assert Native.$bool($greater_uint_int(readers, 0)) : "Reader lock not acquired before release!";
    --readers;
    return true;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::sys::SmartRWMutex::lock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/RWMutex.h", line = 117,
   FQN="llvm::sys::SmartRWMutex::lock", NM="_ZN4llvm3sys12SmartRWMutex4lockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp -nm=_ZN4llvm3sys12SmartRWMutex4lockEv")
  //</editor-fold>
  public boolean lock() {
    if (!mt_only || AdtsupportLlvmGlobals.llvm_is_multithreaded()) {
      return impl.writer_acquire();
    }

    // Single-threaded debugging code.  This would be racy in multithreaded
    // mode, but provides not sanity checks in single threaded mode.
    assert Native.$bool(writers == 0) : "Writer lock already acquired!";
    ++writers;
    return true;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::sys::SmartRWMutex::unlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/RWMutex.h", line = 128,
   FQN="llvm::sys::SmartRWMutex::unlock", NM="_ZN4llvm3sys12SmartRWMutex6unlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp -nm=_ZN4llvm3sys12SmartRWMutex6unlockEv")
  //</editor-fold>
  public boolean unlock() {
    if (!mt_only || AdtsupportLlvmGlobals.llvm_is_multithreaded()) {
      return impl.writer_release();
    }

    // Single-threaded debugging code.  This would be racy in multithreaded
    // mode, but provides not sanity checks in single threaded mode.
    assert Native.$bool(writers == 1) : "Writer lock not acquired before release!";
    --writers;
    return true;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::SmartRWMutex::SmartRWMutex<mt_only>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/RWMutex.h", line = 140,
   FQN="llvm::sys::SmartRWMutex::SmartRWMutex<mt_only>", NM="_ZN4llvm3sys12SmartRWMutexC1ERKNS0_12SmartRWMutexIXT_EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp -nm=_ZN4llvm3sys12SmartRWMutexC1ERKNS0_12SmartRWMutexIXT_EEE")
  //</editor-fold>
  private SmartRWMutex(final /*const*/SmartRWMutex /*&*/ original) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::sys::SmartRWMutex::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/RWMutex.h", line = 141,
   FQN="llvm::sys::SmartRWMutex::operator=", NM="_ZN4llvm3sys12SmartRWMutexaSERKNS0_12SmartRWMutexIXT_EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp -nm=_ZN4llvm3sys12SmartRWMutexaSERKNS0_12SmartRWMutexIXT_EEE")
  //</editor-fold>
  private void $assign(final /*const*/SmartRWMutex /*&*/ $Prm0) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $destroy() {
    assert this.readers == 0;
    assert this.writers == 0;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "impl=" + impl // NOI18N
              + ", readers=" + readers // NOI18N
              + ", writers=" + writers; // NOI18N
  }
}
