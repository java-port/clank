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
import static org.clank.support.Casts.*;
import org.clank.java.signal.sigaction;
import static org.clank.java.signal_defines.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.support.impl.*;
import org.llvm.support.sys.*;
import org.llvm.support.sys.sys.ThreadLocal;


//<editor-fold defaultstate="collapsed" desc="static type CrashRecoveryContextStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.support.impl.CrashRecoveryContextStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZL10NumSignals;_ZL11PrevActions;_ZL21gCrashRecoveryEnabled;_ZL23tlIsRecoveringFromCrash;_ZL26CrashRecoverySignalHandleri;_ZL26RunSafelyOnThread_DispatchPv;_ZL26gCrashRecoveryContextMutex;_ZL27hasThreadBackgroundPriorityv;_ZL27setThreadBackgroundPriorityv;_ZL7Signals;_ZN12_GLOBAL__N_1L14CurrentContextE; -static-type=CrashRecoveryContextStatics -package=org.llvm.support.impl")
//</editor-fold>
public final class CrashRecoveryContextStatics {

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CurrentContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 23,
 FQN="(anonymous namespace)::CurrentContext", NM="_ZN12_GLOBAL__N_1L14CurrentContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZN12_GLOBAL__N_1L14CurrentContextE")
//</editor-fold>
public static ManagedStatic<ThreadLocal</*const*/ CrashRecoveryContextImpl>> CurrentContext/*J*/= new ManagedStatic<ThreadLocal</*const*/ CrashRecoveryContextImpl>>(
        new ManagedStaticInfoImpl<ThreadLocal</*const*/ CrashRecoveryContextImpl>>(){
          @Override
          protected ThreadLocal<CrashRecoveryContextImpl> create() {
            return new ThreadLocal<>();
          }
        });
//<editor-fold defaultstate="collapsed" desc="gCrashRecoveryContextMutex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 75,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 76,
 FQN="gCrashRecoveryContextMutex", NM="_ZL26gCrashRecoveryContextMutex",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZL26gCrashRecoveryContextMutex")
//</editor-fold>
public static ManagedStatic<sys.Mutex> gCrashRecoveryContextMutex/*J*/= new ManagedStatic<sys.Mutex>(
        new ManagedStaticInfoImpl<sys.Mutex>(){
          @Override
          protected sys.Mutex create() {
            return new sys.Mutex();
          }
        });
//<editor-fold defaultstate="collapsed" desc="gCrashRecoveryEnabled">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 76,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 77,
 FQN="gCrashRecoveryEnabled", NM="_ZL21gCrashRecoveryEnabled",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZL21gCrashRecoveryEnabled")
//</editor-fold>
public static boolean gCrashRecoveryEnabled = false;
//<editor-fold defaultstate="collapsed" desc="tlIsRecoveringFromCrash">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 78,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 79,
 FQN="tlIsRecoveringFromCrash", NM="_ZL23tlIsRecoveringFromCrash",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZL23tlIsRecoveringFromCrash")
//</editor-fold>
public static ManagedStatic<ThreadLocal</*const*/ CrashRecoveryContext>> tlIsRecoveringFromCrash/*J*/= new ManagedStatic<ThreadLocal</*const*/ CrashRecoveryContext>>(
        new ManagedStaticInfoImpl<ThreadLocal</*const*/ CrashRecoveryContext>>(){
          @Override
          protected ThreadLocal<CrashRecoveryContext> create() {
            return new ThreadLocal<>();
          }
        });
//<editor-fold defaultstate="collapsed" desc="Signals">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 244,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 245,
 FQN="Signals", NM="_ZL7Signals",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZL7Signals")
//</editor-fold>
public static /*const*/int Signals[/*6*/] = new$int(6, SIGABRT, SIGBUS, SIGFPE, SIGILL, SIGSEGV, SIGTRAP);
//<editor-fold defaultstate="collapsed" desc="NumSignals">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 246,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 247,
 FQN="NumSignals", NM="_ZL10NumSignals",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZL10NumSignals")
//</editor-fold>
public static /*const*//*uint*/int NumSignals = array_lengthof(Signals);
//<editor-fold defaultstate="collapsed" desc="PrevActions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 247,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 248,
 FQN="PrevActions", NM="_ZL11PrevActions",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZL11PrevActions")
//</editor-fold>
public static  sigaction PrevActions[/*6*/]/*J*/= new$T(new  sigaction [6], ()->new  sigaction());
//<editor-fold defaultstate="collapsed" desc="CrashRecoverySignalHandler">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 249,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 250,
 FQN="CrashRecoverySignalHandler", NM="_ZL26CrashRecoverySignalHandleri",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZL26CrashRecoverySignalHandleri")
//</editor-fold>
public static void CrashRecoverySignalHandler(int Signal) {
  throw new UnsupportedOperationException("EmptyBody");
}


// FIXME: Portability.
//<editor-fold defaultstate="collapsed" desc="setThreadBackgroundPriority">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 338,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 346,
 FQN="setThreadBackgroundPriority", NM="_ZL27setThreadBackgroundPriorityv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZL27setThreadBackgroundPriorityv")
//</editor-fold>
public static void setThreadBackgroundPriority() {
}

//<editor-fold defaultstate="collapsed" desc="hasThreadBackgroundPriority">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 344,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 352,
 FQN="hasThreadBackgroundPriority", NM="_ZL27hasThreadBackgroundPriorityv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZL27hasThreadBackgroundPriorityv")
//</editor-fold>
public static boolean hasThreadBackgroundPriority() {
  return false;
}

//<editor-fold defaultstate="collapsed" desc="RunSafelyOnThread_Dispatch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", line = 361,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp", old_line = 369,
 FQN="RunSafelyOnThread_Dispatch", NM="_ZL26RunSafelyOnThread_DispatchPv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CrashRecoveryContext.cpp -nm=_ZL26RunSafelyOnThread_DispatchPv")
//</editor-fold>
public static void RunSafelyOnThread_Dispatch(Object/*void P*/ UserData) {
  RunSafelyOnThreadInfo /*P*/ Info = reinterpret_cast(RunSafelyOnThreadInfo /*P*/ .class, UserData);
  if (Info.UseBackgroundPriority) {
    setThreadBackgroundPriority();
  }
  
  Info.Result = Info.CRC.RunSafely(/*FuncArg*/Info.Fn);
}

} // END OF class CrashRecoveryContextStatics
