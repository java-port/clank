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

/// @brief Platform agnostic RWMutex class.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::RWMutexImpl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/RWMutex.h", line = 26,
 FQN="llvm::sys::RWMutexImpl", NM="_ZN4llvm3sys11RWMutexImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp -nm=_ZN4llvm3sys11RWMutexImplE")
//</editor-fold>
public class RWMutexImpl implements Destructors.ClassWithDestructor {
/// @name Constructors
  /// @{
  /*public:*/
  
  /// Initializes the lock but doesn't acquire it.
  /// @brief Default Constructor.
  
  // Construct a RWMutex using pthread calls
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::RWMutexImpl::RWMutexImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp", line = 46,
   FQN="llvm::sys::RWMutexImpl::RWMutexImpl", NM="_ZN4llvm3sys11RWMutexImplC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp -nm=_ZN4llvm3sys11RWMutexImplC1Ev")
  //</editor-fold>
  public RWMutexImpl() {
    // : data_(null) 
    NativeTrace.traceNotImplemented("RWMutexImpl");
  }

  
  /// Releases and removes the lock
  /// @brief Destructor
  
  // Destruct a RWMutex
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::RWMutexImpl::~RWMutexImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp", line = 68,
   FQN="llvm::sys::RWMutexImpl::~RWMutexImpl", NM="_ZN4llvm3sys11RWMutexImplD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp -nm=_ZN4llvm3sys11RWMutexImplD0Ev")
  //</editor-fold>
  public void $destroy() {
    NativeTrace.traceNotImplemented("RWMutexImpl.$destroy");
  }


  /// @}
  /// @name Methods
  /// @{
  /*public:*/
  
  /// Attempts to unconditionally acquire the lock in reader mode. If the
  /// lock is held by a writer, this method will wait until it can acquire
  /// the lock.
  /// @returns false if any kind of error occurs, true otherwise.
  /// @brief Unconditionally acquire the lock in reader mode.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::RWMutexImpl::reader_acquire">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp", line = 76,
   FQN="llvm::sys::RWMutexImpl::reader_acquire", NM="_ZN4llvm3sys11RWMutexImpl14reader_acquireEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp -nm=_ZN4llvm3sys11RWMutexImpl14reader_acquireEv")
  //</editor-fold>
  public boolean reader_acquire() {
    NativeTrace.traceNotImplemented("RWMutexImpl.reader_acquire");
    return true;
  }

  
  /// Attempts to release the lock in reader mode.
  /// @returns false if any kind of error occurs, true otherwise.
  /// @brief Unconditionally release the lock in reader mode.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::RWMutexImpl::reader_release">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp", line = 86,
   FQN="llvm::sys::RWMutexImpl::reader_release", NM="_ZN4llvm3sys11RWMutexImpl14reader_releaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp -nm=_ZN4llvm3sys11RWMutexImpl14reader_releaseEv")
  //</editor-fold>
  public boolean reader_release() {
    NativeTrace.traceNotImplemented("RWMutexImpl.reader_release");
    return true;
  }

  
  /// Attempts to unconditionally acquire the lock in reader mode. If the
  /// lock is held by any readers, this method will wait until it can
  /// acquire the lock.
  /// @returns false if any kind of error occurs, true otherwise.
  /// @brief Unconditionally acquire the lock in writer mode.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::RWMutexImpl::writer_acquire">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp", line = 96,
   FQN="llvm::sys::RWMutexImpl::writer_acquire", NM="_ZN4llvm3sys11RWMutexImpl14writer_acquireEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp -nm=_ZN4llvm3sys11RWMutexImpl14writer_acquireEv")
  //</editor-fold>
  public boolean writer_acquire() {
    NativeTrace.traceNotImplemented("RWMutexImpl.writer_acquire");
    return true;
  }

  
  /// Attempts to release the lock in writer mode.
  /// @returns false if any kind of error occurs, true otherwise.
  /// @brief Unconditionally release the lock in write mode.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::RWMutexImpl::writer_release">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp", line = 106,
   FQN="llvm::sys::RWMutexImpl::writer_release", NM="_ZN4llvm3sys11RWMutexImpl14writer_releaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp -nm=_ZN4llvm3sys11RWMutexImpl14writer_releaseEv")
  //</editor-fold>
  public boolean writer_release() {
    NativeTrace.traceNotImplemented("RWMutexImpl.writer_release");
    return true;
  }


  //@}
  /// @name Platform Dependent Data
  /// @{
  /*private:*/
  private Object/*void P*/ data_; ///< We don't know what the data will be

  /// @}
  /// @name Do Not Implement
  /// @{
  /*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::RWMutexImpl::RWMutexImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/RWMutex.h", line = 81,
   FQN="llvm::sys::RWMutexImpl::RWMutexImpl", NM="_ZN4llvm3sys11RWMutexImplC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp -nm=_ZN4llvm3sys11RWMutexImplC1ERKS1_")
  //</editor-fold>
  protected/*private*/ RWMutexImpl(final /*const*/ RWMutexImpl /*&*/ original) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::RWMutexImpl::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/RWMutex.h", line = 82,
   FQN="llvm::sys::RWMutexImpl::operator=", NM="_ZN4llvm3sys11RWMutexImplaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/RWMutex.cpp -nm=_ZN4llvm3sys11RWMutexImplaSERKS1_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ RWMutexImpl /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  @Override public String toString() {
    return "" + "data_=" + NativeTrace.getIdentityStr(data_); // NOI18N
  }
/// @}
}
