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

package org.llvm.support.unix.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.io.*;
import static org.clank.java.signal.*;
import static org.clank.support.Native.*;
import org.llvm.support.sys.SmartMutex;


//<editor-fold defaultstate="collapsed" desc="static type SignalsStatics">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 cmd="jclank.sh -java-types-map=${SPUTNIK}/contrib/JConvert/llvmToClankType -java-imports=${SPUTNIK}/contrib/JConvert/llvmToClankImports -print -empty-body ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -file-filter=${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc#42;${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc#44;${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc#47;${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc#49;${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc#50;${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc#55;${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc#58;${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc#62;${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc#77;${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc#79;${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc#80;${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc#80;${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc#86;${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc#104;${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc#112;${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc#125;${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc#153;${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc#327; -static-type=SignalsStatics")
//</editor-fold>
public final class SignalsStatics {


// SignalHandler - The signal handler that runs.
//<editor-fold defaultstate="collapsed" desc="SignalHandler">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 167,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", old_line = 163,
 FQN = "SignalHandler", NM = "_ZL13SignalHandleri",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -nm=_ZL13SignalHandleri")
//</editor-fold>
public static void SignalHandler(int Sig) {
  throw new UnsupportedOperationException("EmptyBody");
}
private static final NativeCallback.Int2Void SignalHandlerCallback = new NativeCallback.Int2Void() {
  @Override
  public void $call(int Sig) {
    SignalHandler(Sig);
  }

  @Override
  public String toString() {
    return "SignalHandler Int2Void callback";
  }
};

// defined below.
//<editor-fold defaultstate="collapsed" desc="SignalsMutex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 53,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", old_line = 54,
 FQN = "SignalsMutex", NM = "_ZL12SignalsMutex",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -nm=_ZL12SignalsMutex")
//</editor-fold>
public static final SmartMutex/*<true>*/ SignalsMutex/*J*/= new SmartMutex/*<true>*/(true);

/// InterruptFunction - The function to call if ctrl-c is pressed.
//<editor-fold defaultstate="collapsed" desc="InterruptFunction">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 56,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", old_line = 57,
 FQN = "InterruptFunction", NM = "_ZL17InterruptFunction",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -nm=_ZL17InterruptFunction")
//</editor-fold>
public static NativeCallback.Void2Void /*P*/ InterruptFunction = null;
//<editor-fold defaultstate="collapsed" desc="FilesToRemove">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 58,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", old_line = 59,
 FQN = "FilesToRemove", NM = "_ZL13FilesToRemove",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -nm=_ZL13FilesToRemove")
//</editor-fold>
public static final std.vectorString FilesToRemove/*J*/= new std.vectorString(std.string.EMPTY);
//<editor-fold defaultstate="collapsed" desc="CallBacksToRun">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 60,
 FQN = "CallBacksToRun", NM = "_ZL14CallBacksToRun",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -filter=CallBacksToRun")
//</editor-fold>
public static final std.vector<std.pair<NativeCallback.VoidPtr2Void, Object/*void P*/ > > CallBacksToRun/*J*/= new std.vector<std.pair<NativeCallback.VoidPtr2Void, Object/*void P*/ > >(new std.pairPtrPtr((NativeCallback.VoidPtr2Void)null, (Object/*void P*/)null));

// IntSigs - Signals that represent requested termination. There's no bug
// or failure, or if there is, it's not our direct responsibility. For whatever
// reason, our continued execution is no longer desirable.
//<editor-fold defaultstate="collapsed" desc="IntSigs">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 63,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", old_line = 66,
 FQN = "IntSigs", NM = "_ZL7IntSigs",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -nm=_ZL7IntSigs")
//</editor-fold>
private static final /*const*/int IntSigs[/*6*/] = new /*const*/int [/*6*/] {
  SIGHUP, SIGINT, SIGPIPE, SIGTERM, SIGUSR1, SIGUSR2
};

// KillSigs - Signals that represent that we have a bug, and our prompt
// termination has been ordered.
//<editor-fold defaultstate="collapsed" desc="KillSigs">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 69,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", old_line = 72,
 FQN = "KillSigs", NM = "_ZL8KillSigs",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -nm=_ZL8KillSigs")
//</editor-fold>
private static final /*const*/int KillSigs[/*11*/] = new /*const*/int [/*11*/] {
  SIGILL, SIGTRAP, SIGABRT, SIGFPE, SIGBUS, SIGSEGV, SIGQUIT, 
  SIGSYS, 
  SIGXCPU, 
  SIGXFSZ, 
  SIGEMT
};

//<editor-fold defaultstate="collapsed" desc="NumRegisteredSignals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 85,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", old_line = 88,
 FQN = "NumRegisteredSignals", NM = "_ZL20NumRegisteredSignals",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -nm=_ZL20NumRegisteredSignals")
//</editor-fold>
public static /*uint*/int NumRegisteredSignals = 0;
//<editor-fold defaultstate="collapsed" desc="<anonymous>">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 86,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", old_line = 89,
 FQN = "(anonymous)", NM = "_Unnamed_struct12",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -nm=_Unnamed_struct12")
//</editor-fold>
public static class/*struct*/ RegisteredSignalInfoTy {
  public  sigaction SA;
  public int SigNo;
  //<editor-fold defaultstate="collapsed" desc="<anonymous struct>::">
  @Converted(kind = Converted.Kind.MANUAL_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 86,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", old_line = 89,
   FQN = "(anonymous struct)::", NM = "_Unnamed_struct12",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -nm=_Unnamed_struct12")
  //</editor-fold>
  public /*inline*/RegisteredSignalInfoTy () {
    /* : SA()*/ 
    this.SA = new sigaction();
  }

}
//<editor-fold defaultstate="collapsed" desc="RegisteredSignalInfo">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 86,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", old_line = 89,
 FQN = "RegisteredSignalInfo", NM = "_ZL20RegisteredSignalInfo",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -nm=_ZL20RegisteredSignalInfo")
//</editor-fold>
public static RegisteredSignalInfoTy RegisteredSignalInfo[/*17*/]/*J*/= new  RegisteredSignalInfoTy[17];
static {
  for (int i = 0; i < RegisteredSignalInfo.length; i++) {
    RegisteredSignalInfo[i] = new RegisteredSignalInfoTy();
  }
}
//<editor-fold defaultstate="collapsed" desc="RegisterHandler">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 92,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", old_line = 95,
 FQN = "RegisterHandler", NM = "_ZL15RegisterHandleri",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -nm=_ZL15RegisterHandleri")
//</editor-fold>
public static void RegisterHandler(int Signal) {
  assert (NumRegisteredSignals < RegisteredSignalInfo.length) : "Out of space for signal handlers!";
  
  sigaction NewHandler/*J*/= new  sigaction();
  
  NewHandler._funcptr._handler = SignalHandlerCallback;
  NewHandler.sa_flags = SA_NODEFER | SA_RESETHAND;
  sigemptyset($AddrOf(NewHandler.sa_mask));
  
  // Install the new handler, save the old one in RegisteredSignalInfo.
  sigaction(Signal, $AddrOf(NewHandler), 
      $AddrOf(RegisteredSignalInfo[(int)NumRegisteredSignals].SA));
  RegisteredSignalInfo[(int)NumRegisteredSignals].SigNo = Signal;
  ++NumRegisteredSignals;
}
        
//<editor-fold defaultstate="collapsed" desc="RegisterHandlers">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 109,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", old_line = 113,
 FQN = "RegisterHandlers", NM = "_ZL16RegisterHandlersv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -nm=_ZL16RegisterHandlersv")
//</editor-fold>
public static void RegisterHandlers() {
  // If the handlers are already registered, we're done.
  if (NumRegisteredSignals != 0) {
    return;
  }
  
  for (int S : IntSigs)  {
    RegisterHandler(S);
  }
  for (int S : KillSigs)  {
    RegisterHandler(S);
  }
}

//<editor-fold defaultstate="collapsed" desc="UnregisterHandlers">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 123,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", old_line = 121,
 FQN = "UnregisterHandlers", NM = "_ZL18UnregisterHandlersv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -nm=_ZL18UnregisterHandlersv")
//</editor-fold>
public static void UnregisterHandlers() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// RemoveFilesToRemove - Process the FilesToRemove list. This function
/// should be called with the SignalsMutex lock held.
/// NB: This must be an async signal safe function. It cannot allocate or free
/// memory, even in debug builds.
//<editor-fold defaultstate="collapsed" desc="RemoveFilesToRemove">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 136,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", old_line = 134,
 FQN = "RemoveFilesToRemove", NM = "_ZL19RemoveFilesToRemovev",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -nm=_ZL19RemoveFilesToRemovev")
//</editor-fold>
public static void RemoveFilesToRemove() {
  // We avoid iterators in case of debug iterators that allocate or release
  // memory.
  for (/*uint*/int i = 0, e = FilesToRemove.size(); i != e; ++i) {
    // We rely on a std::string implementation for which repeated calls to
    // 'c_str()' don't allocate memory. We pre-call 'c_str()' on all of these
    // strings to try to ensure this is safe.
    /*const*/char$ptr/*char P*/ path = $tryClone(FilesToRemove.$at(i).c_str());
    
    // Get the status so we can determine if it's a file or directory. If we
    // can't stat the file, ignore it.
     stat buf/*J*/= new  stat();
    if (stat(path, $AddrOf(buf)) != 0) {
      continue;
    }
    
    // If this is not a regular file, ignore it. We want to prevent removal of
    // special files like /dev/null, even if the compiler is being run with the
    // super-user permissions.
    if (!((((buf.st_mode)) & 0170000) == (0100000))) {
      continue;
    }
    
    // Otherwise, remove the file. We ignore any errors here as there is nothing
    // else we can do.
    unlink(path);
  }
}

//<editor-fold defaultstate="collapsed" desc="PrintStackTraceSignalHandler">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 378,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", old_line = 479,
 FQN = "PrintStackTraceSignalHandler", NM = "_ZL28PrintStackTraceSignalHandlerPv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -nm=_ZL28PrintStackTraceSignalHandlerPv")
//</editor-fold>
public static void PrintStackTraceSignalHandler(Object/*void P*/ $Prm0) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class SignalsStatics
