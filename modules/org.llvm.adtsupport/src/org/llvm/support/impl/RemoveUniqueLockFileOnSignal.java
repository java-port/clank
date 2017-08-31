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

package org.llvm.support.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.support.sys.*;
import org.llvm.adt.*;

/// An RAII helper object ensure that the unique lock file is removed.
///
/// Ensures that if there is an error or a signal before we finish acquiring the
/// lock, the unique file will be removed. And if we successfully take the lock,
/// the signal handler is left in place so that signals while the lock is held
/// will remove the unique lock file. The caller should ensure there is a
/// matching call to sys::DontRemoveFileOnSignal when the lock is released.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RemoveUniqueLockFileOnSignal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp", line = 122,
 FQN="(anonymous namespace)::RemoveUniqueLockFileOnSignal", NM="_ZN12_GLOBAL__N_128RemoveUniqueLockFileOnSignalE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp -nm=_ZN12_GLOBAL__N_128RemoveUniqueLockFileOnSignalE")
//</editor-fold>
public class RemoveUniqueLockFileOnSignal implements Destructors.ClassWithDestructor {
  private StringRef Filename;
  private boolean RemoveImmediately;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RemoveUniqueLockFileOnSignal::RemoveUniqueLockFileOnSignal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp", line = 126,
   FQN="(anonymous namespace)::RemoveUniqueLockFileOnSignal::RemoveUniqueLockFileOnSignal", NM="_ZN12_GLOBAL__N_128RemoveUniqueLockFileOnSignalC1EN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp -nm=_ZN12_GLOBAL__N_128RemoveUniqueLockFileOnSignalC1EN4llvm9StringRefE")
  //</editor-fold>
  public RemoveUniqueLockFileOnSignal(StringRef Name) {
    // : Filename(Name), RemoveImmediately(true) 
    //START JInit
    this.Filename = new StringRef(Name);
    this.RemoveImmediately = true;
    //END JInit
    sys.RemoveFileOnSignal(new StringRef(Filename), (std.string/*P*/ )null);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RemoveUniqueLockFileOnSignal::~RemoveUniqueLockFileOnSignal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp", line = 130,
   FQN="(anonymous namespace)::RemoveUniqueLockFileOnSignal::~RemoveUniqueLockFileOnSignal", NM="_ZN12_GLOBAL__N_128RemoveUniqueLockFileOnSignalD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp -nm=_ZN12_GLOBAL__N_128RemoveUniqueLockFileOnSignalD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (!RemoveImmediately) {
      // Leave the signal handler enabled. It will be removed when the lock is
      // released.
      return;
    }
    fs.remove(new Twine(Filename));
    sys.DontRemoveFileOnSignal(new StringRef(Filename));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RemoveUniqueLockFileOnSignal::lockAcquired">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp", line = 139,
   FQN="(anonymous namespace)::RemoveUniqueLockFileOnSignal::lockAcquired", NM="_ZN12_GLOBAL__N_128RemoveUniqueLockFileOnSignal12lockAcquiredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp -nm=_ZN12_GLOBAL__N_128RemoveUniqueLockFileOnSignal12lockAcquiredEv")
  //</editor-fold>
  public void lockAcquired() {
    RemoveImmediately = false;
  }

  
  @Override public String toString() {
    return "" + "Filename=" + Filename // NOI18N
              + ", RemoveImmediately=" + RemoveImmediately; // NOI18N
  }
}
