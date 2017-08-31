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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.support.sys.*;

/// Instances of this class acquire a given Mutex Lock when constructed and
/// hold that lock until destruction. The intention is to instantiate one of
/// these on the stack at the top of some scope to be assured that C++
/// destruction of the object will always release the Mutex and thus avoid
/// a host of nasty multi-threading problems in the face of exceptions, etc.
/// @brief Guard a section of code with a Mutex.
//<editor-fold defaultstate="collapsed" desc="llvm::MutexGuard">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MutexGuard.h", line = 27,
 FQN="llvm::MutexGuard", NM="_ZN4llvm10MutexGuardE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_ZN4llvm10MutexGuardE")
//</editor-fold>
public class MutexGuard implements Destructors.ClassWithDestructor {
  private SmartMutex/*&*/ M;
  //<editor-fold defaultstate="collapsed" desc="llvm::MutexGuard::MutexGuard">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MutexGuard.h", line = 29,
   FQN="llvm::MutexGuard::MutexGuard", NM="_ZN4llvm10MutexGuardC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_ZN4llvm10MutexGuardC1ERKS0_")
  //</editor-fold>
  private MutexGuard(/*const*/ MutexGuard /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::MutexGuard::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MutexGuard.h", line = 30,
   FQN="llvm::MutexGuard::operator=", NM="_ZN4llvm10MutexGuardaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_ZN4llvm10MutexGuardaSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/ MutexGuard /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MutexGuard::MutexGuard">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MutexGuard.h", line = 32,
   FQN="llvm::MutexGuard::MutexGuard", NM="_ZN4llvm10MutexGuardC1ERNS_3sys10SmartMutexILb0EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_ZN4llvm10MutexGuardC1ERNS_3sys10SmartMutexILb0EEE")
  //</editor-fold>
  public MutexGuard(SmartMutex/*&*/ m) {
    // : M(m) 
    //START JInit
    this./*&*/M=/*&*/m;
    //END JInit
    M.lock();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MutexGuard::~MutexGuard">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MutexGuard.h", line = 33,
   FQN="llvm::MutexGuard::~MutexGuard", NM="_ZN4llvm10MutexGuardD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_ZN4llvm10MutexGuardD0Ev")
  //</editor-fold>
  public void $destroy() {
    M.unlock();
  }

  /// holds - Returns true if this locker instance holds the specified lock.
  /// This is mostly used in assertions to validate that the correct mutex
  /// is held.
  //<editor-fold defaultstate="collapsed" desc="llvm::MutexGuard::holds">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MutexGuard.h", line = 37,
   FQN="llvm::MutexGuard::holds", NM="_ZNK4llvm10MutexGuard5holdsERKNS_3sys10SmartMutexILb0EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_ZNK4llvm10MutexGuard5holdsERKNS_3sys10SmartMutexILb0EEE")
  //</editor-fold>
  public boolean holds(/*const*/SmartMutex/*&*/ lock) /*const*/ {
    return $AddrOf(M) == $AddrOf(lock);
  }

  
  @Override public String toString() {
    return "" + "M=" + M; // NOI18N
  }
}
