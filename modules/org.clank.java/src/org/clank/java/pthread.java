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

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static org.clank.java.errno_codes.*;
import static org.clank.java.io.*;
import org.clank.support.aliases.*;

public final class pthread implements pthread_defines {
        
  private pthread() {
  }
  
  public static final class pthread_mutex_t {
    private boolean initialized = false;
    private pthread_mutexattr_t attr = null;
    private final Lock lock = new ReentrantLock(true);
    
    private pthread_mutex_t() {
    }
    
    private void init(pthread_mutexattr_t attr) {
      assert attr.initialized;
      initialized = true;
      this.attr = new pthread_mutexattr_t(attr);
    }
    
    private void destroy() {
      initialized = false;
      attr = null;
    }
  }
  
  public static pthread_mutex_t create_pthread_mutex() {
    return new pthread_mutex_t();
  }
  
  /*
   * attributes for mutex, dynamically allocated by library
   */  
  public static final class pthread_mutexattr_t {
    private boolean initialized = false;
    private int type = PTHREAD_MUTEX_DEFAULT;
    private int shared = _DEFAULT_TYPE;

    public pthread_mutexattr_t() {
    }

    private pthread_mutexattr_t(pthread_mutexattr_t other) {
      assert (other.initialized);
      this.shared = other.shared;
      this.type = other.type;
    }

    
    private void init() {
      initialized = true;
      type = PTHREAD_MUTEX_DEFAULT;
      shared = _DEFAULT_TYPE;
    }
    
    private void destroy() {
      initialized = false;
    }
  }
  
  /**
   * The pthread_mutexattr_destroy() function shall destroy a mutex attributes
   * object; the object becomes, in effect, uninitialized. An implementation may
   * cause pthread_mutexattr_destroy() to set the object referenced by attr to
   * an invalid value. A destroyed attr attributes object can be reinitialized
   * using pthread_mutexattr_init(); the results of otherwise referencing the
   * object after it has been destroyed are undefined.
   *
   * The pthread_mutexattr_init() function shall initialize a mutex attributes
   * object attr with the default value for all of the attributes defined by the
   * implementation.
   *
   * Results are undefined if pthread_mutexattr_init() is called specifying an
   * already initialized attr attributes object.
   *
   * After a mutex attributes object has been used to initialize one or more
   * mutexes, any function affecting the attributes object (including
   * destruction) shall not affect any previously initialized mutexes. 
   * 
   * Return Value
   *
   * Upon successful completion, pthread_mutexattr_destroy() and
   * pthread_mutexattr_init() shall return zero; otherwise, an error number
   * shall be returned to indicate the error.
   *
   * Errors
   * 
   * The pthread_mutexattr_destroy() function may fail if:
   * 
   * EINVAL
   *     The value specified by attr is invalid.
   * 
   * The pthread_mutexattr_init() function shall fail if:
   * 
   * ENOMEM
   *     Insufficient memory exists to initialize the mutex attributes object.
   * 
   * These functions shall not return an error code of [EINTR]. 
   * 
   * @param attr
   * @return 
   */
  public static int pthread_mutexattr_init(pthread_mutexattr_t attr) {
    if (attr == null || attr.initialized) {
      return setErrno(EINVAL);
    }
    attr.init();
    return setErrno(0);
  }
  
  public static int pthread_mutexattr_destroy(pthread_mutexattr_t attr) {
    if (attr == null || !attr.initialized) {
      return setErrno(EINVAL);
    }
    attr.destroy();
    return setErrno(0);
  }
  
  /**
   * The pthread_mutexattr_gettype() and pthread_mutexattr_settype() functions,
   * respectively, shall get and set the mutex type attribute. This attribute is
   * set in the type parameter to these functions. The default value of the type
   * attribute is PTHREAD_MUTEX_DEFAULT.
   *
   * The type of mutex is contained in the type attribute of the mutex
   * attributes. Valid mutex types include:
   *
   * PTHREAD_MUTEX_NORMAL
   * This type of mutex does not detect deadlock. A thread attempting to relock
   * this mutex without first unlocking it shall deadlock. Attempting to unlock
   * a mutex locked by a different thread results in undefined behavior.
   * Attempting to unlock an unlocked mutex results in undefined behavior.
   * 
   * PTHREAD_MUTEX_ERRORCHECK
   * This type of mutex provides error checking. A thread attempting to relock
   * this mutex without first unlocking it shall return with an error. A thread
   * attempting to unlock a mutex which another thread has locked shall return
   * with an error. A thread attempting to unlock an unlocked mutex shall return
   * with an error. 
   * 
   * PTHREAD_MUTEX_RECURSIVE
   * A thread attempting to relock this mutex without first unlocking it shall
   * succeed in locking the mutex. The relocking deadlock which can occur with
   * mutexes of type PTHREAD_MUTEX_NORMAL cannot occur with this type of mutex.
   * Multiple locks of this mutex shall require the same number of unlocks to
   * release the mutex before another thread can acquire the mutex. A thread
   * attempting to unlock a mutex which another thread has locked shall return
   * with an error. A thread attempting to unlock an unlocked mutex shall return
   * with an error. 
   * 
   * PTHREAD_MUTEX_DEFAULT
   * Attempting to recursively lock a mutex of this type results in undefined
   * behavior. Attempting to unlock a mutex of this type which was not locked by
   * the calling thread results in undefined behavior. Attempting to unlock a
   * mutex of this type which is not locked results in undefined behavior. An
   * implementation may map this mutex to one of the other mutex types.
   *
   * Return Value
   *
   * Upon successful completion, the pthread_mutexattr_gettype() function shall
   * return zero and store the value of the type attribute of attr into the
   * object referenced by the type parameter. Otherwise, an error shall be
   * returned to indicate the error.
   *
   * If successful, the pthread_mutexattr_settype() function shall return zero;
   * otherwise, an error number shall be returned to indicate the error.
   * 
   * Errors
   * 
   * The pthread_mutexattr_settype() function shall fail if:
   * 
   * EINVAL
   *     The value type is invalid.
   * 
   * The pthread_mutexattr_gettype() and pthread_mutexattr_settype() functions may fail if:
   * 
   * EINVAL
   *     The value specified by attr is invalid.
   * 
   * These functions shall not return an error code of [EINTR]. 
   * 
   * @param attr
   * @param type
   * @return 
   */
  public static int pthread_mutexattr_gettype(pthread_mutexattr_t attr, int$ref out) {
    if (attr == null || out == null || !attr.initialized) {
      return setErrno(EINVAL);
    }
    out.$set(attr.type);
    return setErrno(0);
  }
  
  public static int pthread_mutexattr_settype(pthread_mutexattr_t attr, int type) {
    if (attr == null || !attr.initialized) {
      return setErrno(EINVAL);
    }
    switch (type) {
      case PTHREAD_MUTEX_RECURSIVE:
      case PTHREAD_MUTEX_ERRORCHECK:
      case PTHREAD_MUTEX_NORMAL:
        attr.type = type;
        break;
      default:
        return setErrno(EINVAL);
    }
    return setErrno(0);
  }

  /**
   * The pthread_mutexattr_getpshared() function shall obtain the value of the
   * process-shared attribute from the attributes object referenced by attr. The
   * pthread_mutexattr_setpshared() function shall set the process-shared
   * attribute in an initialized attributes object referenced by attr.
   *
   * The process-shared attribute is set to PTHREAD_PROCESS_SHARED to permit a
   * mutex to be operated upon by any thread that has access to the memory where
   * the mutex is allocated, even if the mutex is allocated in memory that is
   * shared by multiple processes. If the process-shared attribute is
   * PTHREAD_PROCESS_PRIVATE, the mutex shall only be operated upon by threads
   * created within the same process as the thread that initialized the mutex;
   * if threads of differing processes attempt to operate on such a mutex, the
   * behavior is undefined. The default value of the attribute shall be
   * PTHREAD_PROCESS_PRIVATE. 
   * 
   * Return Value
   * Upon successful completion, pthread_mutexattr_setpshared() shall return
   * zero; otherwise, an error number shall be returned to indicate the error.
   *
   * Upon successful completion, pthread_mutexattr_getpshared() shall return
   * zero and store the value of the process-shared attribute of attr into the
   * object referenced by the pshared parameter. Otherwise, an error number
   * shall be returned to indicate the error.
   *
   * Errors
   * 
   * The pthread_mutexattr_getpshared() and pthread_mutexattr_setpshared() functions may fail if:
   * 
   * EINVAL
   *     The value specified by attr is invalid.
   * 
   * The pthread_mutexattr_setpshared() function may fail if:
   * 
   * EINVAL
   *     The new value specified for the attribute is outside the range of legal values for that attribute.
   * 
   * These functions shall not return an error code of [EINTR]. 
   * 
   * @param attr
   * @param out
   * @return 
   */
  public static int pthread_mutexattr_getpshared(pthread_mutexattr_t attr, int$ref out) {
    if (attr == null || out == null || !attr.initialized) {
      return setErrno(EINVAL);
    }
    out.$set(attr.shared);
    return setErrno(0);
  }  
  public static int pthread_mutexattr_setpshared(pthread_mutexattr_t attr, int type) {
    if (attr == null || !attr.initialized) {
      return setErrno(EINVAL);
    }
    switch (type) {
      case PTHREAD_PROCESS_SHARED:
      case PTHREAD_PROCESS_PRIVATE:
        attr.shared = type;
        break;
      default:
        return setErrno(EINVAL);
    }
    return setErrno(0);
  }

  /**
   * The pthread_mutex_destroy() function shall destroy the mutex object
   * referenced by mutex; the mutex object becomes, in effect, uninitialized. An
   * implementation may cause pthread_mutex_destroy() to set the object
   * referenced by mutex to an invalid value. A destroyed mutex object can be
   * reinitialized using pthread_mutex_init(); the results of otherwise
   * referencing the object after it has been destroyed are undefined.
   *
   * It shall be safe to destroy an initialized mutex that is unlocked.
   * Attempting to destroy a locked mutex results in undefined behavior.
   *
   * The pthread_mutex_init() function shall initialize the mutex referenced by
   * mutex with attributes specified by attr. If attr is NULL, the default mutex
   * attributes are used; the effect shall be the same as passing the address of
   * a default mutex attributes object. Upon successful initialization, the
   * state of the mutex becomes initialized and unlocked.
   *
   * Only mutex itself may be used for performing synchronization. The result of
   * referring to copies of mutex in calls to pthread_mutex_lock(),
   * pthread_mutex_trylock(), pthread_mutex_unlock(), and
   * pthread_mutex_destroy() is undefined.
   *
   * Attempting to initialize an already initialized mutex results in undefined
   * behavior.
   *
   * In cases where default mutex attributes are appropriate, the macro
   * PTHREAD_MUTEX_INITIALIZER can be used to initialize mutexes that are
   * statically allocated. The effect shall be equivalent to dynamic
   * initialization by a call to pthread_mutex_init() with parameter attr
   * specified as NULL, except that no error checks are performed. 
   * 
   * Return Value
   * If successful, the pthread_mutex_destroy() and pthread_mutex_init()
   * functions shall return zero; otherwise, an error number shall be returned
   * to indicate the error.
   *
   * The [EBUSY] and [EINVAL] error checks, if implemented, act as if they were
   * performed immediately at the beginning of processing for the function and
   * shall cause an error return prior to modifying the state of the mutex
   * specified by mutex.
   * 
   * The pthread_mutex_destroy() function may fail if:
   * 
   * EBUSY
   *     The implementation has detected an attempt to destroy the object 
   *      referenced by mutex while it is locked or referenced (for example, 
   *      while being used in a pthread_cond_timedwait() or pthread_cond_wait()) 
   *      by another thread. 
   * EINVAL
   *     The value specified by mutex is invalid.
   * 
   * The pthread_mutex_init() function shall fail if:
   * 
   * EAGAIN
   *     The system lacked the necessary resources (other than memory) to 
   *      initialize another mutex. 
   * ENOMEM
   *     Insufficient memory exists to initialize the mutex. 
   * EPERM
   *     The caller does not have the privilege to perform the operation.
   * 
   * The pthread_mutex_init() function may fail if:
   * 
   * EBUSY
   *     The implementation has detected an attempt to reinitialize the object 
   * referenced by mutex, a previously initialized, but not yet destroyed, mutex. 
   * EINVAL
   *     The value specified by attr is invalid.
   * 
   * These functions shall not return an error code of [EINTR]. 
   * 
   * @param mutex
   * @param attr
   * @return 
   */
  public static int pthread_mutex_init(pthread_mutex_t mutex, pthread_mutexattr_t attr) {
    if (mutex == null) {
      return setErrno(EINVAL);
    }
    if (mutex.initialized) {
      return setErrno(EBUSY);
    }
    mutex.init(attr);
    return setErrno(0);
  }
  public static int pthread_mutex_destroy(pthread_mutex_t mutex) {
    if (mutex == null || !mutex.initialized) {
      return setErrno(EINVAL);
    }
    mutex.destroy();
    return setErrno(0);
  }  
  
  /**
   * The mutex object referenced by mutex shall be locked by calling
   * pthread_mutex_lock(). If the mutex is already locked, the calling thread
   * shall block until the mutex becomes available. This operation shall return
   * with the mutex object referenced by mutex in the locked state with the
   * calling thread as its owner.
   *
   * If the mutex type is PTHREAD_MUTEX_NORMAL, deadlock detection shall not be
   * provided. Attempting to relock the mutex causes deadlock. If a thread
   * attempts to unlock a mutex that it has not locked or a mutex which is
   * unlocked, undefined behavior results.
   *
   * If the mutex type is PTHREAD_MUTEX_ERRORCHECK, then error checking shall be
   * provided. If a thread attempts to relock a mutex that it has already
   * locked, an error shall be returned. If a thread attempts to unlock a mutex
   * that it has not locked or a mutex which is unlocked, an error shall be
   * returned.
   *
   * If the mutex type is PTHREAD_MUTEX_RECURSIVE, then the mutex shall maintain
   * the concept of a lock count. When a thread successfully acquires a mutex
   * for the first time, the lock count shall be set to one. Every time a thread
   * relocks this mutex, the lock count shall be incremented by one. Each time
   * the thread unlocks the mutex, the lock count shall be decremented by one.
   * When the lock count reaches zero, the mutex shall become available for
   * other threads to acquire. If a thread attempts to unlock a mutex that it
   * has not locked or a mutex which is unlocked, an error shall be returned.
   *
   * If the mutex type is PTHREAD_MUTEX_DEFAULT, attempting to recursively lock
   * the mutex results in undefined behavior. Attempting to unlock the mutex if
   * it was not locked by the calling thread results in undefined behavior.
   * Attempting to unlock the mutex if it is not locked results in undefined
   * behavior.
   *
   * The pthread_mutex_trylock() function shall be equivalent to
   * pthread_mutex_lock(), except that if the mutex object referenced by mutex
   * is currently locked (by any thread, including the current thread), the call
   * shall return immediately. If the mutex type is PTHREAD_MUTEX_RECURSIVE and
   * the mutex is currently owned by the calling thread, the mutex lock count
   * shall be incremented by one and the pthread_mutex_trylock() function shall
   * immediately return success.
   *
   * The pthread_mutex_unlock() function shall release the mutex object
   * referenced by mutex. The manner in which a mutex is released is dependent
   * upon the mutex's type attribute. If there are threads blocked on the mutex
   * object referenced by mutex when pthread_mutex_unlock() is called, resulting
   * in the mutex becoming available, the scheduling policy shall determine
   * which thread shall acquire the mutex.
   *
   * (In the case of PTHREAD_MUTEX_RECURSIVE mutexes, the mutex shall become
   * available when the count reaches zero and the calling thread no longer has
   * any locks on this mutex.)
   *
   * If a signal is delivered to a thread waiting for a mutex, upon return from
   * the signal handler the thread shall resume waiting for the mutex as if it
   * was not interrupted. 
   * 
   * Return Value
   * If successful, the pthread_mutex_lock() and pthread_mutex_unlock()
   * functions shall return zero; otherwise, an error number shall be returned
   * to indicate the error.
   *
   * The pthread_mutex_trylock() function shall return zero if a lock on the
   * mutex object referenced by mutex is acquired. Otherwise, an error number is
   * returned to indicate the error.
   *
   * Errors
   * 
   * The pthread_mutex_lock() and pthread_mutex_trylock() functions shall fail if:
   * 
   * EINVAL
   *     The mutex was created with the protocol attribute having the value 
   *      PTHREAD_PRIO_PROTECT and the calling thread's priority is 
   *      higher than the mutex's current priority ceiling.
   * 
   * The pthread_mutex_trylock() function shall fail if:
   * 
   * EBUSY
   *     The mutex could not be acquired because it was already locked.
   * 
   * The pthread_mutex_lock(), pthread_mutex_trylock(), 
   *    and pthread_mutex_unlock() functions may fail if:
   * 
   * EINVAL
   *     The value specified by mutex does not refer to an initialized mutex object. 
   * EAGAIN
   *     The mutex could not be acquired because the maximum number of recursive 
   *      locks for mutex has been exceeded.
   * 
   * The pthread_mutex_lock() function may fail if:
   * 
   * EDEADLK
   *     The current thread already owns the mutex.
   * 
   * The pthread_mutex_unlock() function may fail if:
   * 
   * EPERM
   *     The current thread does not own the mutex.
   * 
   * These functions shall not return an error code of [EINTR]. 
   * 
   * @param mutex
   * @return 
   */
  public static int pthread_mutex_lock(pthread_mutex_t mutex) {
    if (mutex == null || !mutex.initialized) {
      return setErrno(EINVAL);
    }
    mutex.lock.lock();
    return setErrno(0);
  }  
  public static int pthread_mutex_trylock(pthread_mutex_t mutex) {
    if (mutex == null || !mutex.initialized) {
      return setErrno(EINVAL);
    }
    if (!mutex.lock.tryLock()) {
      return setErrno(EBUSY);
    }
    return setErrno(0);
  }  
  public static int pthread_mutex_unlock(pthread_mutex_t mutex) {
    if (mutex == null || !mutex.initialized) {
      return setErrno(EINVAL);
    }
    mutex.lock.unlock();
    return setErrno(0);
  }  
  
}
