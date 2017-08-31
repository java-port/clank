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

package org.llvm.support;

import org.clank.support.*;

/// A pared-down imitation of std::unique_lock from C++11. Contrary to the
/// name, it's really more of a wrapper for a lock. It may or may not have
/// an associated mutex, which is guaranteed to be locked upon creation
/// and unlocked after destruction. unique_lock can also unlock the mutex
/// and re-lock it freely during its lifetime.
/// @brief Guard a section of code with a mutex.
/*template <typename MutexT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::unique_lock">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/UniqueLock.h", line = 27,
 FQN="llvm::unique_lock", NM="_ZN4llvm11unique_lockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm11unique_lockE")
//</editor-fold>
public class unique_lock</*typename*/ MutexT>  implements Destructors.ClassWithDestructor {
  private MutexT /*P*/ M;
  private boolean locked;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::unique_lock::unique_lock<MutexT>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/UniqueLock.h", line = 32,
   FQN="llvm::unique_lock::unique_lock<MutexT>", NM="_ZN4llvm11unique_lockC1ERKNS_11unique_lockIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm11unique_lockC1ERKNS_11unique_lockIT_EE")
  //</editor-fold>
  protected/*private*/ unique_lock(final /*const*/ unique_lock<MutexT> /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::unique_lock::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/UniqueLock.h", line = 33,
   FQN="llvm::unique_lock::operator=", NM="_ZN4llvm11unique_lockaSERKNS_11unique_lockIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm11unique_lockaSERKNS_11unique_lockIT_EE")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ unique_lock<MutexT> /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::unique_lock::unique_lock<MutexT>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/UniqueLock.h", line = 35,
   FQN="llvm::unique_lock::unique_lock<MutexT>", NM="_ZN4llvm11unique_lockC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm11unique_lockC1Ev")
  //</editor-fold>
  public unique_lock() {
    // : M(null), locked(false) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::unique_lock::unique_lock<MutexT>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/UniqueLock.h", line = 36,
   FQN="llvm::unique_lock::unique_lock<MutexT>", NM="_ZN4llvm11unique_lockC1ERT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm11unique_lockC1ERT_")
  //</editor-fold>
  public /*explicit*/ unique_lock(final MutexT /*&*/ m) {
    // : M(&m), locked(true) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::unique_lock::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/UniqueLock.h", line = 38,
   FQN="llvm::unique_lock::operator=", NM="_ZN4llvm11unique_lockaSEONS_11unique_lockIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm11unique_lockaSEONS_11unique_lockIT_EE")
  //</editor-fold>
  public void $assignMove(final unique_lock<MutexT> /*&&*/o) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::unique_lock::~unique_lock<MutexT>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/UniqueLock.h", line = 47,
   FQN="llvm::unique_lock::~unique_lock<MutexT>", NM="_ZN4llvm11unique_lockD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm11unique_lockD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::unique_lock::lock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/UniqueLock.h", line = 49,
   FQN="llvm::unique_lock::lock", NM="_ZN4llvm11unique_lock4lockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm11unique_lock4lockEv")
  //</editor-fold>
  public void lock() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::unique_lock::unlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/UniqueLock.h", line = 56,
   FQN="llvm::unique_lock::unlock", NM="_ZN4llvm11unique_lock6unlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm11unique_lock6unlockEv")
  //</editor-fold>
  public void unlock() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::unique_lock::owns_lock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/UniqueLock.h", line = 63,
   FQN="llvm::unique_lock::owns_lock", NM="_ZN4llvm11unique_lock9owns_lockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm11unique_lock9owns_lockEv")
  //</editor-fold>
  public boolean owns_lock() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "M=" + M // NOI18N
              + ", locked=" + locked; // NOI18N
  }
}
