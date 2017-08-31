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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import static org.clank.java.pthread.*;
import static org.clank.java.std.*;
import org.llvm.support.sys.*;

/// @brief Platform agnostic Mutex class.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::MutexImpl">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Mutex.h", line = 26,
 FQN="llvm::sys::MutexImpl", NM="_ZN4llvm3sys9MutexImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Mutex.cpp -nm=_ZN4llvm3sys9MutexImplE")
//</editor-fold>
public class MutexImpl implements Destructors.ClassWithDestructor {
/*public:*/
  /// @name Constructors
  /// @{
  
  /// Initializes the lock but doesn't acquire it. if \p recursive is set
  /// to false, the lock will not be recursive which makes it cheaper but
  /// also more likely to deadlock (same thread can't acquire more than
  /// once).
  /// @brief Default Constructor.
  
  // Construct a Mutex using pthread calls
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::MutexImpl::MutexImpl">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Mutex.cpp", line = 44,
   FQN = "llvm::sys::MutexImpl::MutexImpl", NM = "_ZN4llvm3sys9MutexImplC1Eb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Mutex.cpp -nm=_ZN4llvm3sys9MutexImplC1Eb")
  //</editor-fold>
  public MutexImpl() {
    this(true);
  }
  public MutexImpl(boolean recursive/*= true*/) {
    /* : data_(null)*/ 
    //START JInit
    this.data_ = null;
    //END JInit
    // Declare the pthread_mutex data structures
    pthread_mutex_t/*P*/ mutex = create_pthread_mutex(); //((/*static_cast*/pthread_mutex_t/*P*/ )(malloc(sizeof(pthread_mutex_t))));
    pthread_mutexattr_t attr/*J*/= new pthread_mutexattr_t();
    
    // Initialize the mutex attributes
    int errorcode = pthread_mutexattr_init($AddrOf(attr));
    assert (errorcode == 0);
    //(void)errorcode;
    
    // Initialize the mutex as a recursive mutex, if requested, or normal
    // otherwise.
    int kind = recursive ? PTHREAD_MUTEX_RECURSIVE : PTHREAD_MUTEX_NORMAL;
    errorcode = pthread_mutexattr_settype($AddrOf(attr), kind);
    assert (errorcode == 0);
    
    // Initialize the mutex
    errorcode = pthread_mutex_init(mutex, $AddrOf(attr));
    assert (errorcode == 0);
    
    // Destroy the attributes
    errorcode = pthread_mutexattr_destroy($AddrOf(attr));
    assert (errorcode == 0);
    
    // Assign the data member
    data_ = mutex;
  }

  
  /// Releases and removes the lock
  /// @brief Destructor
  
  // Destruct a Mutex
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::MutexImpl::~MutexImpl">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Mutex.cpp", line = 75,
   FQN = "llvm::sys::MutexImpl::~MutexImpl", NM = "_ZN4llvm3sys9MutexImplD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Mutex.cpp -nm=_ZN4llvm3sys9MutexImplD0Ev")
  //</editor-fold>
  public void $destroy() {
    pthread_mutex_t/*P*/ mutex = ((/*static_cast*/pthread_mutex_t/*P*/ )(data_));
    assert (mutex != null);
    pthread_mutex_destroy(mutex);
    free(mutex);
  }

/*public:*/
  
  /// @}
  /// @name Methods
  /// @{
  
  /// Attempts to unconditionally acquire the lock. If the lock is held by
  /// another thread, this method will wait until it can acquire the lock.
  /// @returns false if any kind of error occurs, true otherwise.
  /// @brief Unconditionally acquire the lock.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::MutexImpl::acquire">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Mutex.cpp", line = 83,
   FQN = "llvm::sys::MutexImpl::acquire", NM = "_ZN4llvm3sys9MutexImpl7acquireEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Mutex.cpp -nm=_ZN4llvm3sys9MutexImpl7acquireEv")
  //</editor-fold>
  public boolean acquire() {
    pthread_mutex_t/*P*/ mutex = ((/*static_cast*/pthread_mutex_t/*P*/ )(data_));
    assert (mutex != null);
    
    int errorcode = pthread_mutex_lock(mutex);
    return errorcode == 0;
  }

  
  /// Attempts to release the lock. If the lock is held by the current
  /// thread, the lock is released allowing other threads to acquire the
  /// lock.
  /// @returns false if any kind of error occurs, true otherwise.
  /// @brief Unconditionally release the lock.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::MutexImpl::release">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Mutex.cpp", line = 93,
   FQN = "llvm::sys::MutexImpl::release", NM = "_ZN4llvm3sys9MutexImpl7releaseEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Mutex.cpp -nm=_ZN4llvm3sys9MutexImpl7releaseEv")
  //</editor-fold>
  public boolean release() {
    pthread_mutex_t/*P*/ mutex = ((/*static_cast*/pthread_mutex_t/*P*/ )(data_));
    assert (mutex != null);
    
    int errorcode = pthread_mutex_unlock(mutex);
    return errorcode == 0;
  }

  
  /// Attempts to acquire the lock without blocking. If the lock is not
  /// available, this function returns false quickly (without blocking). If
  /// the lock is available, it is acquired.
  /// @returns false if any kind of error occurs or the lock is not
  /// available, true otherwise.
  /// @brief Try to acquire the lock.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::MutexImpl::tryacquire">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Mutex.cpp", line = 103,
   FQN = "llvm::sys::MutexImpl::tryacquire", NM = "_ZN4llvm3sys9MutexImpl10tryacquireEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Mutex.cpp -nm=_ZN4llvm3sys9MutexImpl10tryacquireEv")
  //</editor-fold>
  public boolean tryacquire() {
    pthread_mutex_t/*P*/ mutex = ((/*static_cast*/pthread_mutex_t/*P*/ )(data_));
    assert (mutex != null);
    
    int errorcode = pthread_mutex_trylock(mutex);
    return errorcode == 0;
  }

/*private:*/
  
  //@}
  /// @name Platform Dependent Data
  /// @{
  private pthread_mutex_t/*void P*/ data_; ///< We don't know what the data will be
/*private:*/
  
  /// @}
  /// @name Do Not Implement
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::MutexImpl::MutexImpl">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Mutex.h", line = 81,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Mutex.h", old_line = 79,
   FQN = "llvm::sys::MutexImpl::MutexImpl", NM = "_ZN4llvm3sys9MutexImplC1ERKS1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Mutex.cpp -nm=_ZN4llvm3sys9MutexImplC1ERKS1_")
  //</editor-fold>
  private MutexImpl(/*const*/ MutexImpl /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::MutexImpl::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Mutex.h", line = 82,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Mutex.h", old_line = 80,
   FQN = "llvm::sys::MutexImpl::operator=", NM = "_ZN4llvm3sys9MutexImplaSERKS1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Mutex.cpp -nm=_ZN4llvm3sys9MutexImplaSERKS1_")
  //</editor-fold>
  private void $assign(/*const*/ MutexImpl /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  public String toString() {
    return "" + "data_=" + data_; // NOI18N
  }
/// @}
}
