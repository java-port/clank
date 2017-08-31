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

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.support.impl.*;
import static org.llvm.support.impl.CrashRecoveryContextStatics.CurrentContext;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CrashRecoveryContextImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 26,
 FQN="(anonymous namespace)::CrashRecoveryContextImpl", NM="_ZN12_GLOBAL__N_124CrashRecoveryContextImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN12_GLOBAL__N_124CrashRecoveryContextImplE")
//</editor-fold>
public class/*struct*/ CrashRecoveryContextImpl implements Destructors.ClassWithDestructor {
  // When threads are disabled, this links up all active
  // CrashRecoveryContextImpls.  When threads are enabled there's one thread
  // per CrashRecoveryContext and CurrentContext is a thread-local, so only one
  // CrashRecoveryContextImpl is active per thread and this is always null.
  public /*const*/ CrashRecoveryContextImpl /*P*/ Next;
  
  public CrashRecoveryContext /*P*/ CRC;
  public int JumpBuffer[/*10*/] = new$int(-1);
  public /*JBIT volatile unsigned int*/ boolean Failed /*: 1*/;
  public /*JBIT unsigned int*/ boolean SwitchedThread /*: 1*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CrashRecoveryContextImpl::CrashRecoveryContextImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 39,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 40,
   FQN="(anonymous namespace)::CrashRecoveryContextImpl::CrashRecoveryContextImpl", NM="_ZN12_GLOBAL__N_124CrashRecoveryContextImplC1EPN4llvm20CrashRecoveryContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN12_GLOBAL__N_124CrashRecoveryContextImplC1EPN4llvm20CrashRecoveryContextE")
  //</editor-fold>
  public CrashRecoveryContextImpl(CrashRecoveryContext /*P*/ CRC) {
    // : CRC(CRC), Failed(false), SwitchedThread(false) 
    //START JInit
    this.CRC = CRC;
    this.Failed = false;
    this.SwitchedThread = false;
    //END JInit
    Next = CurrentContext.$arrow().get();
    CurrentContext.$arrow().set(this);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CrashRecoveryContextImpl::~CrashRecoveryContextImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 45,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 46,
   FQN="(anonymous namespace)::CrashRecoveryContextImpl::~CrashRecoveryContextImpl", NM="_ZN12_GLOBAL__N_124CrashRecoveryContextImplD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN12_GLOBAL__N_124CrashRecoveryContextImplD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (!SwitchedThread) {
      CurrentContext.$arrow().set(Next);
    }
  }

  
  /// \brief Called when the separate crash-recovery thread was finished, to
  /// indicate that we don't need to clear the thread-local CurrentContext.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CrashRecoveryContextImpl::setSwitchedThread">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 52,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 53,
   FQN="(anonymous namespace)::CrashRecoveryContextImpl::setSwitchedThread", NM="_ZN12_GLOBAL__N_124CrashRecoveryContextImpl17setSwitchedThreadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN12_GLOBAL__N_124CrashRecoveryContextImpl17setSwitchedThreadEv")
  //</editor-fold>
  public void setSwitchedThread() {
    SwitchedThread = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CrashRecoveryContextImpl::HandleCrash">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 58,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 59,
   FQN="(anonymous namespace)::CrashRecoveryContextImpl::HandleCrash", NM="_ZN12_GLOBAL__N_124CrashRecoveryContextImpl11HandleCrashEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN12_GLOBAL__N_124CrashRecoveryContextImpl11HandleCrashEv")
  //</editor-fold>
  public void HandleCrash() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Next=" + Next // NOI18N
              + ", CRC=" + "[CrashRecoveryContext]" // NOI18N
              + ", JumpBuffer=" + JumpBuffer // NOI18N
              + ", Failed=" + Failed // NOI18N
              + ", SwitchedThread=" + SwitchedThread; // NOI18N
  }
}
