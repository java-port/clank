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
import static org.clank.java.signal.sigaction;
import static org.clank.java.signal.sigemptyset;
import static org.clank.support.Native.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.support.impl.*;
import org.llvm.support.sys.*;
import static org.llvm.support.impl.CrashRecoveryContextStatics.*;


/// \brief Crash recovery helper object.
///
/// This class implements support for running operations in a safe context so
/// that crashes (memory errors, stack overflow, assertion violations) can be
/// detected and control restored to the crashing thread. Crash detection is
/// purely "best effort", the exact set of failures which can be recovered from
/// is platform dependent.
///
/// Clients make use of this code by first calling
/// CrashRecoveryContext::Enable(), and then executing unsafe operations via a
/// CrashRecoveryContext object. For example:
///
///    void actual_work(void *);
///
///    void foo() {
///      CrashRecoveryContext CRC;
///
///      if (!CRC.RunSafely(actual_work, 0)) {
///         ... a crash was detected, report error to user ...
///      }
///
///      ... no crash was detected ...
///    }
//<editor-fold defaultstate="collapsed" desc="llvm::CrashRecoveryContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/CrashRecoveryContext.h", line = 41,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CrashRecoveryContext.h", old_line = 42,
 FQN="llvm::CrashRecoveryContext", NM="_ZN4llvm20CrashRecoveryContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN4llvm20CrashRecoveryContextE")
//</editor-fold>
public class CrashRecoveryContext implements Destructors.ClassWithDestructor {
  private Object/*void P*/ Impl;
  private CrashRecoveryContextCleanup /*P*/ head;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CrashRecoveryContext::CrashRecoveryContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CrashRecoveryContext.h", line = 46,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CrashRecoveryContext.h", old_line = 47,
   FQN="llvm::CrashRecoveryContext::CrashRecoveryContext", NM="_ZN4llvm20CrashRecoveryContextC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN4llvm20CrashRecoveryContextC1Ev")
  //</editor-fold>
  public CrashRecoveryContext() {
    // : Impl(null), head(null) 
    //START JInit
    this.Impl = null;
    this.head = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CrashRecoveryContext::~CrashRecoveryContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 83,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 84,
   FQN="llvm::CrashRecoveryContext::~CrashRecoveryContext", NM="_ZN4llvm20CrashRecoveryContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN4llvm20CrashRecoveryContextD0Ev")
  //</editor-fold>
  public void $destroy() {
    // Reclaim registered resources.
    CrashRecoveryContextCleanup /*P*/ i = head;
    /*const*/ CrashRecoveryContext /*P*/ PC = tlIsRecoveringFromCrash.$arrow().get();
    tlIsRecoveringFromCrash.$arrow().set(this);
    while ((i != null)) {
      CrashRecoveryContextCleanup /*P*/ tmp = i;
      i = tmp.next;
      tmp.cleanupFired = true;
      tmp.recoverResources();
      if (tmp != null) { tmp.$destroy();};
    }
    tlIsRecoveringFromCrash.$arrow().set(PC);
    
    CrashRecoveryContextImpl /*P*/ CRCI = (CrashRecoveryContextImpl /*P*/ )Impl;
    if (CRCI != null) { CRCI.$destroy();};
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::CrashRecoveryContext::registerCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 116,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 117,
   FQN="llvm::CrashRecoveryContext::registerCleanup", NM="_ZN4llvm20CrashRecoveryContext15registerCleanupEPNS_27CrashRecoveryContextCleanupE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN4llvm20CrashRecoveryContext15registerCleanupEPNS_27CrashRecoveryContextCleanupE")
  //</editor-fold>
  public void registerCleanup(CrashRecoveryContextCleanup /*P*/ cleanup) {
    if (!(cleanup != null)) {
      return;
    }
    if ((head != null)) {
      head.prev = cleanup;
    }
    cleanup.next = head;
    head = cleanup;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CrashRecoveryContext::unregisterCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 126,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 127,
   FQN="llvm::CrashRecoveryContext::unregisterCleanup", NM="_ZN4llvm20CrashRecoveryContext17unregisterCleanupEPNS_27CrashRecoveryContextCleanupE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN4llvm20CrashRecoveryContext17unregisterCleanupEPNS_27CrashRecoveryContextCleanupE")
  //</editor-fold>
  public void unregisterCleanup(CrashRecoveryContextCleanup /*P*/ cleanup) {
    if (!(cleanup != null)) {
      return;
    }
    if (cleanup == head) {
      head = cleanup.next;
      if ((head != null)) {
        head.prev = null;
      }
    } else {
      cleanup.prev.next = cleanup.next;
      if ((cleanup.next != null)) {
        cleanup.next.prev = cleanup.prev;
      }
    }
    if (cleanup != null) { cleanup.$destroy();};
  }

  
  /// \brief Enable crash recovery.
  //<editor-fold defaultstate="collapsed" desc="llvm::CrashRecoveryContext::Enable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 281,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 282,
   FQN="llvm::CrashRecoveryContext::Enable", NM="_ZN4llvm20CrashRecoveryContext6EnableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN4llvm20CrashRecoveryContext6EnableEv")
  //</editor-fold>
  public static void Enable() {
    SmartScopedLock/*<false>*/ L = null;
    try {
      L/*J*/= new SmartScopedLock/*<false>*/(false, gCrashRecoveryContextMutex.$star());
      if (gCrashRecoveryEnabled) {
        return;
      }
      
      gCrashRecoveryEnabled = true;
      
      // Setup the signal handler.
       sigaction Handler/*J*/= new  sigaction();
      Handler._funcptr._handler = /*$tryClone(*//*FuncRef*/CrashRecoveryContextStatics::CrashRecoverySignalHandler/*)*/;
      Handler.sa_flags = 0;
      sigemptyset($AddrOf(Handler.sa_mask));
      
      for (/*uint*/int i = 0; i != NumSignals; ++i) {
        sigaction(Signals[i], $AddrOf(Handler), $AddrOf(PrevActions[i]));
      }
    } finally {
      if (L != null) { L.$destroy(); }
    }
  }

  
  /// \brief Disable crash recovery.
  //<editor-fold defaultstate="collapsed" desc="llvm::CrashRecoveryContext::Disable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 300,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 301,
   FQN="llvm::CrashRecoveryContext::Disable", NM="_ZN4llvm20CrashRecoveryContext7DisableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN4llvm20CrashRecoveryContext7DisableEv")
  //</editor-fold>
  public static void Disable() {
    SmartScopedLock/*<false>*/ L = null;
    try {
      L/*J*/= new SmartScopedLock/*<false>*/(false, gCrashRecoveryContextMutex.$star());
      if (!gCrashRecoveryEnabled) {
        return;
      }
      
      gCrashRecoveryEnabled = false;
      
      // Restore the previous signal handlers.
      for (/*uint*/int i = 0; i != NumSignals; ++i)  {
        sigaction(Signals[i], $AddrOf(PrevActions[i]), ( sigaction /*P*/ )null);
      }
    } finally {
      if (L != null) { L.$destroy(); }
    }
  }

  
  /// \brief Return the active context, if the code is currently executing in a
  /// thread which is in a protected context.
  //<editor-fold defaultstate="collapsed" desc="llvm::CrashRecoveryContext::GetCurrent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 105,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 106,
   FQN="llvm::CrashRecoveryContext::GetCurrent", NM="_ZN4llvm20CrashRecoveryContext10GetCurrentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN4llvm20CrashRecoveryContext10GetCurrentEv")
  //</editor-fold>
  public static CrashRecoveryContext /*P*/ GetCurrent() {
    if (!gCrashRecoveryEnabled) {
      return null;
    }
    
    /*const*/ CrashRecoveryContextImpl /*P*/ CRCI = CurrentContext.$arrow().get();
    if (!(CRCI != null)) {
      return null;
    }
    
    return CRCI.CRC;
  }

  
  /// \brief Return true if the current thread is recovering from a
  /// crash.
  //<editor-fold defaultstate="collapsed" desc="llvm::CrashRecoveryContext::isRecoveringFromCrash">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 101,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 102,
   FQN="llvm::CrashRecoveryContext::isRecoveringFromCrash", NM="_ZN4llvm20CrashRecoveryContext21isRecoveringFromCrashEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN4llvm20CrashRecoveryContext21isRecoveringFromCrashEv")
  //</editor-fold>
  public static boolean isRecoveringFromCrash() {
    return tlIsRecoveringFromCrash.$arrow().get() != null;
  }

  
  /// \brief Execute the provide callback function (with the given arguments) in
  /// a protected context.
  ///
  /// \return True if the function completed successfully, and false if the
  /// function crashed (or HandleCrash was called explicitly). Clients should
  /// make as little assumptions as possible about the program state when
  /// RunSafely has returned false.
  //<editor-fold defaultstate="collapsed" desc="llvm::CrashRecoveryContext::RunSafely">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 315,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 316,
   FQN="llvm::CrashRecoveryContext::RunSafely", NM="_ZN4llvm20CrashRecoveryContext9RunSafelyENS_12function_refIFvvEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN4llvm20CrashRecoveryContext9RunSafelyENS_12function_refIFvvEEE")
  //</editor-fold>
  public boolean RunSafely(Void2Void Fn) {
    // If crash recovery is disabled, do nothing.
    if (CrashRecoveryContextStatics.gCrashRecoveryEnabled) {
      assert (!(Impl != null)) : "Crash recovery context already initialized!";
      CrashRecoveryContextImpl /*P*/ CRCI = new CrashRecoveryContextImpl(this);
      Impl = CRCI;
//      if (_setjmp(CRCI.JumpBuffer) != 0) {
//        return false;
//      }
    }

    try {
      Fn.$call();
    } catch (Throwable e) {
      //
      NativeTrace.registerReason(e);
    }
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CrashRecoveryContext::RunSafely">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CrashRecoveryContext.h", line = 74,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CrashRecoveryContext.h", old_line = 76,
   FQN="llvm::CrashRecoveryContext::RunSafely", NM="_ZN4llvm20CrashRecoveryContext9RunSafelyEPFvPvES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN4llvm20CrashRecoveryContext9RunSafelyEPFvPvES1_")
  //</editor-fold>
  public boolean RunSafely(VoidPtr2Void Fn, Object/*void P*/ UserData) {
    return RunSafely(/*FuncArg*//*[&, &Fn, &UserData]*/ () -> {
              Fn.$call(UserData);
            });
  }

  
  /// \brief Execute the provide callback function (with the given arguments) in
  /// a protected context which is run in another thread (optionally with a
  /// requested stack size).
  ///
  /// See RunSafely() and llvm_execute_on_thread().
  ///
  /// On Darwin, if PRIO_DARWIN_BG is set on the calling thread, it will be
  /// propagated to the new thread as well.
  //<editor-fold defaultstate="collapsed" desc="llvm::CrashRecoveryContext::RunSafelyOnThread">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 370,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 378,
   FQN="llvm::CrashRecoveryContext::RunSafelyOnThread", NM="_ZN4llvm20CrashRecoveryContext17RunSafelyOnThreadENS_12function_refIFvvEEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN4llvm20CrashRecoveryContext17RunSafelyOnThreadENS_12function_refIFvvEEEj")
  //</editor-fold>
  public boolean RunSafelyOnThread(Void2Void Fn) {
    return RunSafelyOnThread(Fn, 
                   0);
  }
  public boolean RunSafelyOnThread(Void2Void Fn, 
                   /*uint*/int RequestedStackSize/*= 0*/) {
    boolean UseBackgroundPriority = CrashRecoveryContextStatics.hasThreadBackgroundPriority();
    RunSafelyOnThreadInfo Info = new RunSafelyOnThreadInfo(Fn, this, UseBackgroundPriority, false);
    AdtsupportLlvmGlobals.llvm_execute_on_thread(/*FuncRef*/CrashRecoveryContextStatics::RunSafelyOnThread_Dispatch, $AddrOf(Info), RequestedStackSize);
    {
      CrashRecoveryContextImpl /*P*/ CRC = (CrashRecoveryContextImpl /*P*/ )Impl;
      if ((CRC != null)) {
        CRC.setSwitchedThread();
      }
    }
    return Info.Result;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CrashRecoveryContext::RunSafelyOnThread">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CrashRecoveryContext.h", line = 87,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CrashRecoveryContext.h", old_line = 89,
   FQN="llvm::CrashRecoveryContext::RunSafelyOnThread", NM="_ZN4llvm20CrashRecoveryContext17RunSafelyOnThreadEPFvPvES1_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN4llvm20CrashRecoveryContext17RunSafelyOnThreadEPFvPvES1_j")
  //</editor-fold>
  public boolean RunSafelyOnThread(VoidPtr2Void Fn, Object/*void P*/ UserData) {
    return RunSafelyOnThread(Fn, UserData, 
                   0);
  }
  public boolean RunSafelyOnThread(VoidPtr2Void Fn, Object/*void P*/ UserData, 
                   /*uint*/int RequestedStackSize/*= 0*/) {
    return RunSafelyOnThread(/*FuncArg*//*[&, &Fn, &UserData]*/ () -> {
              Fn.$call(UserData);
            }, RequestedStackSize);
  }

  
  /// \brief Explicitly trigger a crash recovery in the current process, and
  /// return failure from RunSafely(). This function does not return.
  //<editor-fold defaultstate="collapsed" desc="llvm::CrashRecoveryContext::HandleCrash">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 331,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 332,
   FQN="llvm::CrashRecoveryContext::HandleCrash", NM="_ZN4llvm20CrashRecoveryContext11HandleCrashEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN4llvm20CrashRecoveryContext11HandleCrashEv")
  //</editor-fold>
  public void HandleCrash() {
    CrashRecoveryContextImpl /*P*/ CRCI = (CrashRecoveryContextImpl /*P*/ )Impl;
    assert ((CRCI != null)) : "Crash recovery context never initialized!";
    CRCI.HandleCrash();
  }

  
  @Override public String toString() {
    return "" + "Impl=" + NativeTrace.getIdentityStr(Impl) // NOI18N
              + ", head=" + head; // NOI18N
  }
}
