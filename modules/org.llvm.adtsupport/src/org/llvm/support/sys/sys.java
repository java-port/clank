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
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import org.clank.java.*;
import static org.clank.java.built_in.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.java.std.*;
import org.clank.support.NativeCallback.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import static org.llvm.adt.ADTAliases.$noteq_reverse_iterator$C;
import org.llvm.adt.aliases.ArrayRef;
import org.llvm.adt.aliases.StringMapBool;
import org.llvm.support.ManagedStaticInfo;
import org.llvm.support.ErrorOr;
import org.llvm.support.sys.impl.HostSysGlobals;
import org.llvm.support.unix.impl.HostStatics;
import org.llvm.support.unix.impl.SignalsStatics;
import static org.llvm.support.unix.impl.SignalsStatics.*;

//<editor-fold defaultstate="collapsed" desc="static type sys">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -java-types-map=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TargetInfo.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -namespace=llvm::sys")
//</editor-fold>
public final class sys {

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::AtomicIncrement">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Atomic.cpp", line = 60,
   FQN = "llvm::sys::AtomicIncrement", NM = "_ZN4llvm3sys15AtomicIncrementEPVj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Atomic.cpp -nm=_ZN4llvm3sys15AtomicIncrementEPVj")
  //</editor-fold>  
  public static int AtomicIncrement(AtomicInteger Value) {
    return Value.incrementAndGet();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::AtomicDecrement">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Atomic.cpp", line = 73,
   FQN = "llvm::sys::AtomicDecrement", NM = "_ZN4llvm3sys15AtomicDecrementEPVj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Atomic.cpp -nm=_ZN4llvm3sys15AtomicDecrementEPVj")
  //</editor-fold>    
  public static int AtomicDecrement(AtomicInteger Value) {
    return Value.decrementAndGet();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::AtomicAdd">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Atomic.cpp", line = 86,
   FQN = "llvm::sys::AtomicAdd", NM = "_ZN4llvm3sys9AtomicAddEPVjj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Atomic.cpp -nm=_ZN4llvm3sys9AtomicAddEPVjj")
  //</editor-fold>    
  public static int AtomicAdd(AtomicInteger Value, /*uint*/int add) {
    return Value.addAndGet(add);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::AtomicMul">
  @Converted(kind = Converted.Kind.MANUAL_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Atomic.cpp", line = 99,
   FQN = "llvm::sys::AtomicMul", NM = "_ZN4llvm3sys9AtomicMulEPVjj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Atomic.cpp -nm=_ZN4llvm3sys9AtomicMulEPVjj")
  //</editor-fold>    
  public static int AtomicMul(AtomicInteger Value, /*uint*/int V) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::AtomicDiv">
  @Converted(kind = Converted.Kind.MANUAL_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Atomic.cpp", line = 109,
   FQN = "llvm::sys::AtomicDiv", NM = "_ZN4llvm3sys9AtomicDivEPVjj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Atomic.cpp -nm=_ZN4llvm3sys9AtomicDivEPVjj")
  //</editor-fold>    
  public static void AtomicDiv(AtomicInteger Value, /*uint*/int V) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
    
/// This is the OS-specific separator for PATH like environment variables:
/// a colon on Unix or a semicolon on Windows.
public static final byte EnvPathSeparator = $(File.pathSeparatorChar);

/// This function runs all the registered interrupt handlers, including the
/// removal of files registered by RemoveFileOnSignal.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::RunInterruptHandlers">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 212,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", old_line = 211,
 FQN = "llvm::sys::RunInterruptHandlers", NM = "_ZN4llvm3sys20RunInterruptHandlersEv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -nm=_ZN4llvm3sys20RunInterruptHandlersEv")
//</editor-fold>
public static void RunInterruptHandlers() {
  SmartScopedLock/*true*/ Guard = null;
  try {
    Guard/*J*/= new SmartScopedLock/*true*/(true, SignalsMutex);
    RemoveFilesToRemove();
  } finally {
    if (Guard != null) { Guard.$destroy(); }
  }
}

/// This function registers signal handlers to ensure that if a signal gets
/// delivered that the named file is removed.
/// @brief Remove a file if a fatal signal occurs.

// RemoveFileOnSignal - The public API
//<editor-fold defaultstate="collapsed" desc="llvm::sys::RemoveFileOnSignal">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 226,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", old_line = 225,
 FQN = "llvm::sys::RemoveFileOnSignal", NM = "_ZN4llvm3sys18RemoveFileOnSignalENS_9StringRefEPSs",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -nm=_ZN4llvm3sys18RemoveFileOnSignalENS_9StringRefEPSs")
//</editor-fold>
public static boolean RemoveFileOnSignal(StringRef Filename) {
  return RemoveFileOnSignal(Filename, 
                  (std.string/*P*/ )null);
}
public static boolean RemoveFileOnSignal(StringRef Filename, 
                  std.string/*P*/ ErrMsg/*= null*/) {
  {
    SmartScopedLock/*true*/ Guard = null;
    try {
      Guard/*J*/= new SmartScopedLock/*true*/(true, SignalsMutex);
      std.vectorString/*&*/ FilesToRemoveRef = FilesToRemove;
      std.string/*P*/ OldPtr = FilesToRemoveRef.empty() ? null : $AddrOf(FilesToRemoveRef.$at(0));
      FilesToRemoveRef.push_back(Filename.$string());
      
      // We want to call 'c_str()' on every std::string in this vector so that if
      // the underlying implementation requires a re-allocation, it happens here
      // rather than inside of the signal handler. If we see the vector grow, we
      // have to call it on every entry. If it remains in place, we only need to
      // call it on the latest one.
      if (OldPtr == $AddrOf(FilesToRemoveRef.$at(0))) {
        FilesToRemoveRef.back().c_str();
      } else {
        for (/*uint*/int i = 0, e = FilesToRemoveRef.size(); i != e; ++i)  {
          FilesToRemoveRef.$at(i).c_str();
        }
      }
    } finally {
      if (Guard != null) { Guard.$destroy(); }
    }
  }
  
  RegisterHandlers();
  return false;
}


/// This function removes a file from the list of files to be removed on
/// signal delivery.

// DontRemoveFileOnSignal - The public API
//<editor-fold defaultstate="collapsed" desc="llvm::sys::DontRemoveFileOnSignal">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 284,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", old_line = 238,
 FQN="llvm::sys::DontRemoveFileOnSignal", NM="_ZN4llvm3sys22DontRemoveFileOnSignalENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -nm=_ZN4llvm3sys22DontRemoveFileOnSignalENS_9StringRefE")
//</editor-fold>
public static void DontRemoveFileOnSignal(StringRef Filename) {
  SmartScopedLock/*true*/ Guard = null;
  try {
    Guard/*J*/= new SmartScopedLock/*true*/(true, SignalsStatics.SignalsMutex);
    std.reverse_iterator<std.string/*&*/ > RI = std.find(FilesToRemove.rbegin(), FilesToRemove.rend(), Filename);
    std.vectorString.iterator I = FilesToRemove.end();
    if ($noteq_reverse_iterator$C(RI, FilesToRemove.rend())) {
      final std.vectorString.iterator base = ((std.vectorString.iterator) RI.base());
      I.$assignMove(FilesToRemove.erase(base.$sub(1)));
    }
  } finally {
    if (Guard != null) { Guard.$destroy(); }
  }
}


/// When an error signal (such as SIBABRT or SIGSEGV) is delivered to the
/// process, print a stack trace and then exit.
/// @brief Print a stack trace if a fatal signal occurs.

/// PrintStackTraceOnErrorSignal - When an error signal (such as SIGABRT or
/// SIGSEGV) is delivered to the process, print a stack trace and then exit.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::PrintStackTraceOnErrorSignal">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 485,
 FQN = "llvm::sys::PrintStackTraceOnErrorSignal", NM = "_ZN4llvm3sys28PrintStackTraceOnErrorSignalEv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -filter=llvm::sys::PrintStackTraceOnErrorSignal")
//</editor-fold>
public static void PrintStackTraceOnErrorSignal() {
  AddSignalHandler(SignalsStatics::PrintStackTraceSignalHandler, null);
}
public static void PrintStackTraceOnErrorSignal(StringRef obj) {
  AddSignalHandler(SignalsStatics::PrintStackTraceSignalHandler, obj);
}


/// \brief Print the stack trace using the given \c FILE object.

// PrintStackTrace - In the case of a program crash or fault, print out a stack
// trace so that the user has an indication of why and where we died.
//
// On glibc systems we have the 'backtrace' function, which works nicely, but
// doesn't demangle symbols.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::PrintStackTrace">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 418,
 FQN = "llvm::sys::PrintStackTrace", NM = "_ZN4llvm3sys15PrintStackTraceEP8_IO_FILE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -filter=llvm::sys::PrintStackTrace")
//</editor-fold>
public static void PrintStackTrace(FILE /*P*/ FD) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// AddSignalHandler - Add a function to be called when an abort/kill signal
/// is delivered to the process.  The handler can have a cookie passed to it
/// to identify what instance of the handler it is.

/// AddSignalHandler - Add a function to be called when a signal is delivered
/// to the process.  The handler can have a cookie passed to it to identify
/// what instance of the handler it is.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::AddSignalHandler">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 250,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", old_line = 270,
 FQN = "llvm::sys::AddSignalHandler", NM = "_ZN4llvm3sys16AddSignalHandlerEPFvPvES1_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -nm=_ZN4llvm3sys16AddSignalHandlerEPFvPvES1_")
//</editor-fold>
public static void AddSignalHandler(VoidPtr2Void FnPtr, Object/*void P*/ Cookie) {
  CallBacksToRun.push_back(std.make_pair_Ptr_Ptr(FnPtr, Cookie));
  RegisterHandlers();
}


/// This function registers a function to be called when the user "interrupts"
/// the program (typically by pressing ctrl-c).  When the user interrupts the
/// program, the specified interrupt function is called instead of the program
/// being killed, and the interrupt function automatically disabled.  Note
/// that interrupt functions are not allowed to call any non-reentrant
/// functions.  An null interrupt function pointer disables the current
/// installed function.  Note also that the handler may be executed on a
/// different thread on some platforms.
/// @brief Register a function to be called when ctrl-c is pressed.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::SetInterruptFunction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", line = 217,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Signals.inc", old_line = 216,
 FQN = "llvm::sys::SetInterruptFunction", NM = "_ZN4llvm3sys20SetInterruptFunctionEPFvvE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Signals.cpp -nm=_ZN4llvm3sys20SetInterruptFunctionEPFvvE")
//</editor-fold>
public static void SetInterruptFunction(Void2Void IF) {
  throw new UnsupportedOperationException("EmptyBody");
}  
  
//<editor-fold defaultstate="collapsed" desc="llvm::sys::StrError">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Errno.cpp", line = 32,
 FQN = "llvm::sys::StrError", NM = "_ZN4llvm3sys8StrErrorEv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Errno.cpp -nm=_ZN4llvm3sys8StrErrorEv")
//</editor-fold>
public static std.string StrError() {
  return StrError(errno());
}

// HAVE_ERRNO_H
//<editor-fold defaultstate="collapsed" desc="llvm::sys::StrError">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Errno.cpp", line = 37,
 FQN = "llvm::sys::StrError", NM = "_ZN4llvm3sys8StrErrorEi",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Errno.cpp -nm=_ZN4llvm3sys8StrErrorEi")
//</editor-fold>
public static std.string StrError(int errnum) {
  std.string str = null;
  try {
    if (errnum == 0) {
      return std.string.EMPTY;
    }
    /*const*/int MaxErrStrLen = 2000;
    /*char*/char$ptr buffer = create_char$ptr(new$char(2000));
    buffer.$set(0, $('\0'));
    str/*J*/= new std.string();
    strerror_r(errnum, buffer, MaxErrStrLen - 1);
    str.$assign(buffer);
    return str;
  } finally {
    if (str != null) { str.$destroy(); }
  }
}

/// \brief Find the first executable file \p Name in \p Paths.
///
/// This does not perform hashing as a shell would but instead stats each PATH
/// entry individually so should generally be avoided. Core LLVM library
/// functions and options should instead require fully specified paths.
///
/// \param Name name of the executable to find. If it contains any system
///   slashes, it will be returned as is.
/// \param Paths optional list of paths to search for \p Name. If empty it
///   will use the system PATH environment instead.
///
/// \returns The fully qualified path to the first \p Name in \p Paths if it
///   exists. \p Name if \p Name has slashes in it. Otherwise an error.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::findProgramByName">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", line = 71,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", old_line = 58,
 FQN = "llvm::sys::findProgramByName", NM = "_ZN4llvm3sys17findProgramByNameENS_9StringRefENS_8ArrayRefIS1_EE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvm3sys17findProgramByNameENS_9StringRefENS_8ArrayRefIS1_EE")
//</editor-fold>
public static ErrorOr<std.string> findProgramByName(StringRef Name) {
  return findProgramByName(Name, 
                 new ArrayRef<StringRef>());
}
public static ErrorOr<std.string> findProgramByName(StringRef Name, 
                 ArrayRef<StringRef> Paths/*= ArrayRef<StringRef>()*/) {
  return /*delegate*/org.llvm.support.sys.impl.ProgramSysGlobals.
    findProgramByName(Name, 
                 Paths);
}

private static int getPageSize() {
  return std.getpagesize();
}

public static error_code ChangeStdinToBinary(){
  // Do nothing, as Unix doesn't differentiate between text and binary.
  return error_code.success();
}

public static error_code ChangeStdoutToBinary(){
  // Do nothing, as Unix doesn't differentiate between text and binary.
  return error_code.success();
}

public static error_code ChangeStderrToBinary(){
  // Do nothing, as Unix doesn't differentiate between text and binary.
  return error_code.success();
}

/// This function executes the program using the arguments provided.  The
/// invoked program will inherit the stdin, stdout, and stderr file
/// descriptors, the environment and other configuration settings of the
/// invoking program.
/// This function waits for the program to finish, so should be avoided in
/// library functions that aren't expected to block. Consider using
/// ExecuteNoWait() instead.
/// @returns an integer result code indicating the status of the program.
/// A zero or positive value indicates the result code of the program.
/// -1 indicates failure to execute
/// -2 indicates a crash during execution or timeout
//<editor-fold defaultstate="collapsed" desc="llvm::sys::ExecuteAndWait">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Program.cpp", line = 30,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Program.cpp", old_line = 29,
 FQN = "llvm::sys::ExecuteAndWait", NM = "_ZN4llvm3sys14ExecuteAndWaitENS_9StringRefEPPKcS4_PPKS1_jjPSsPb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvm3sys14ExecuteAndWaitENS_9StringRefEPPKcS4_PPKS1_jjPSsPb")
//</editor-fold>
public static int ExecuteAndWait(StringRef Program, /*const*/type$ptr<char$ptr>/*char PP*/ args) {
  return ExecuteAndWait(Program, args, (/*const*/type$ptr<char$ptr>/*char PP*/ )null, 
              (/*const*/ type$ptr<StringRef> /*P*/ /*P*/ )null, 0, 
              0, (std.string/*P*/ )null, 
              (bool$ptr/*bool P*/ )null);
}
public static int ExecuteAndWait(StringRef Program, /*const*/type$ptr<char$ptr>/*char PP*/ args, /*const*/type$ptr<char$ptr>/*char PP*/ envp/*= null*/) {
  return ExecuteAndWait(Program, args, envp, 
              (/*const*/ type$ptr<StringRef> /*P*/ /*P*/ )null, 0, 
              0, (std.string/*P*/ )null, 
              (bool$ptr/*bool P*/ )null);
}
public static int ExecuteAndWait(StringRef Program, /*const*/type$ptr<char$ptr>/*char PP*/ args, /*const*/type$ptr<char$ptr>/*char PP*/ envp/*= null*/, 
              /*const*/ type$ptr<StringRef> /*P*/ /*P*/ redirects/*= null*/) {
  return ExecuteAndWait(Program, args, envp, 
              redirects, 0, 
              0, (std.string/*P*/ )null, 
              (bool$ptr/*bool P*/ )null);
}
public static int ExecuteAndWait(StringRef Program, /*const*/type$ptr<char$ptr>/*char PP*/ args, /*const*/type$ptr<char$ptr>/*char PP*/ envp/*= null*/, 
              /*const*/ type$ptr<StringRef> /*P*/ /*P*/ redirects/*= null*/, /*uint*/int secondsToWait/*= 0*/) {
  return ExecuteAndWait(Program, args, envp, 
              redirects, secondsToWait, 
              0, (std.string/*P*/ )null, 
              (bool$ptr/*bool P*/ )null);
}
public static int ExecuteAndWait(StringRef Program, /*const*/type$ptr<char$ptr>/*char PP*/ args, /*const*/type$ptr<char$ptr>/*char PP*/ envp/*= null*/, 
              /*const*/ type$ptr<StringRef> /*P*/ /*P*/ redirects/*= null*/, /*uint*/int secondsToWait/*= 0*/, 
              /*uint*/int memoryLimit/*= 0*/) {
  return ExecuteAndWait(Program, args, envp, 
              redirects, secondsToWait, 
              memoryLimit, (std.string/*P*/ )null, 
              (bool$ptr/*bool P*/ )null);
}
public static int ExecuteAndWait(StringRef Program, /*const*/type$ptr<char$ptr>/*char PP*/ args, /*const*/type$ptr<char$ptr>/*char PP*/ envp/*= null*/, 
              /*const*/ type$ptr<StringRef> /*P*/ /*P*/ redirects/*= null*/, /*uint*/int secondsToWait/*= 0*/, 
              /*uint*/int memoryLimit/*= 0*/, std.string/*P*/ ErrMsg/*= null*/) {
  return ExecuteAndWait(Program, args, envp, 
              redirects, secondsToWait, 
              memoryLimit, ErrMsg, 
              (bool$ptr/*bool P*/ )null);
}
public static int ExecuteAndWait(StringRef Program, /*const*/type$ptr<char$ptr>/*char PP*/ args, /*const*/type$ptr<char$ptr>/*char PP*/ envp/*= null*/, 
              /*const*/ type$ptr<StringRef> /*P*/ /*P*/ redirects/*= null*/, /*uint*/int secondsToWait/*= 0*/, 
              /*uint*/int memoryLimit/*= 0*/, std.string/*P*/ ErrMsg/*= null*/, 
              bool$ptr/*bool P*/ ExecutionFailed/*= null*/) {
  return /*delegate*/org.llvm.support.sys.impl.ProgramSysGlobals.
    ExecuteAndWait(Program, args, envp, 
              redirects, secondsToWait, 
              memoryLimit, ErrMsg, 
              ExecutionFailed);
}

/// Return true if the given arguments fit within system-specific
/// argument length limits.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::argumentsFitWithinSystemLimits">
  @Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", line = 443,
   FQN = "llvm::sys::argumentsFitWithinSystemLimits", NM = "_ZN4llvm3sys30argumentsFitWithinSystemLimitsENS_8ArrayRefIPKcEE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvm3sys30argumentsFitWithinSystemLimitsENS_8ArrayRefIPKcEE")
  //</editor-fold>
public static boolean argumentsFitWithinSystemLimits(ArrayRef</*const*/char$ptr/*char P*/ > Args) {
  return /*delegate*/ org.llvm.support.sys.impl.ProgramSysGlobals.argumentsFitWithinSystemLimits(Args);
}
  
/// Saves the UTF8-encoded \p contents string into the file \p FileName
/// using a specific encoding.
///
/// This write file function adds the possibility to choose which encoding
/// to use when writing a text file. On Windows, this is important when
/// writing files with internationalization support with an encoding that is
/// different from the one used in LLVM (UTF-8). We use this when writing
/// response files, since GCC tools on MinGW only understand legacy code
/// pages, and VisualStudio tools only understand UTF-16.
/// For UNIX, using different encodings is silently ignored, since all tools
/// work well with UTF-8.
/// This function assumes that you only use UTF-8 *text* data and will convert
/// it to your desired encoding before writing to the file.
///
/// FIXME: We use EM_CurrentCodePage to write response files for GNU tools in
/// a MinGW/MinGW-w64 environment, which has serious flaws but currently is
/// our best shot to make gcc/ld understand international characters. This
/// should be changed as soon as binutils fix this to support UTF16 on mingw.
///
/// \returns non-zero error_code if failed
//<editor-fold defaultstate="collapsed" desc="llvm::sys::writeFileWithEncoding">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", line = 432,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", old_line = 426,
   FQN = "llvm::sys::writeFileWithEncoding", NM = "_ZN4llvm3sys21writeFileWithEncodingENS_9StringRefES1_NS0_21WindowsEncodingMethodE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvm3sys21writeFileWithEncodingENS_9StringRefES1_NS0_21WindowsEncodingMethodE")
  //</editor-fold>
public static std.error_code writeFileWithEncoding(StringRef FileName, StringRef Contents) {
  return /*delegate*/ org.llvm.support.sys.impl.ProgramSysGlobals.writeFileWithEncoding(FileName, Contents);
}
public static std.error_code writeFileWithEncoding(StringRef FileName, StringRef Contents, 
                     WindowsEncodingMethod Encoding/*= WEM_UTF8*/) {
  return /*delegate*/org.llvm.support.sys.impl.ProgramSysGlobals.writeFileWithEncoding(FileName, Contents, Encoding);
}

/// Return true if the given arguments fit within system-specific
/// argument length limits.
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", line = 449,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", old_line = 443,
   FQN = "llvm::sys::writeFileWithEncoding", NM = "_ZN4llvm3sys21writeFileWithEncodingENS_9StringRefES1_NS0_21WindowsEncodingMethodE")
public static boolean commandLineFitsWithinSystemLimits(StringRef Program, ArrayRef<char$ptr> Args) {
  return true;
}

/// SwapByteOrder_16 - This function returns a byte-swapped representation of
/// the 16-bit argument.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::SwapByteOrder_16">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 28,
 FQN="llvm::sys::SwapByteOrder_16", NM="_ZN4llvm3sys16SwapByteOrder_16Et",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZN4llvm3sys16SwapByteOrder_16Et")
//</editor-fold>
public static /*inline*/ char/*uint16_t*/ SwapByteOrder_16(char/*uint16_t*/ value) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    SwapByteOrder_16(value);
}


/// SwapByteOrder_32 - This function returns a byte-swapped representation of
/// the 32-bit argument.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::SwapByteOrder_32">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 42,
 FQN="llvm::sys::SwapByteOrder_32", NM="_ZN4llvm3sys16SwapByteOrder_32Ej",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZN4llvm3sys16SwapByteOrder_32Ej")
//</editor-fold>
public static /*inline*/ /*uint32_t*/int SwapByteOrder_32(/*uint32_t*/int value) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    SwapByteOrder_32(value);
}


/// SwapByteOrder_64 - This function returns a byte-swapped representation of
/// the 64-bit argument.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::SwapByteOrder_64">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 58,
 FQN = "llvm::sys::SwapByteOrder_64", NM = "_ZN4llvm3sys16SwapByteOrder_64Ey",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZN4llvm3sys16SwapByteOrder_64Ey")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ SwapByteOrder_64(long/*uint64_t*/ value) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    SwapByteOrder_64(value);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 70,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZN4llvm3sys15getSwappedBytesEh")
//</editor-fold>
public static /*inline*/ /*uchar*/byte getSwappedBytes_uchar(/*uchar*/byte C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes_uchar(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 71,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEa",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZN4llvm3sys15getSwappedBytesEa")
//</editor-fold>
public static /*inline*/ /*schar*/byte getSwappedBytes_schar(/*schar*/byte C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes_schar(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 72,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZN4llvm3sys15getSwappedBytesEc")
//</editor-fold>
public static /*inline*/ /*char*/byte getSwappedBytes_char(/*char*/byte C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes_char(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 74,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZN4llvm3sys15getSwappedBytesEt")
//</editor-fold>
public static /*inline*/ /*ushort*/char getSwappedBytes_ushort(/*ushort*/char C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes_ushort(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 75,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZN4llvm3sys15getSwappedBytesEs")
//</editor-fold>
public static /*inline*/ short getSwappedBytes_short(short C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes_short(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 77,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZN4llvm3sys15getSwappedBytesEj")
//</editor-fold>
public static /*inline*/ /*uint*/int getSwappedBytes_uint(/*uint*/int C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes_uint(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 78,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZN4llvm3sys15getSwappedBytesEi")
//</editor-fold>
public static /*inline*/ int getSwappedBytes_int(int C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes_int(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 81,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 84,
 FQN = "llvm::sys::getSwappedBytes", NM = "_ZN4llvm3sys15getSwappedBytesEm",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZN4llvm3sys15getSwappedBytesEm")
//</editor-fold>
public static /*inline*/ /*ulong*/long getSwappedBytes_ulong(/*ulong*/long C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes_ulong(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 82,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", old_line = 85,
 FQN = "llvm::sys::getSwappedBytes", NM = "_ZN4llvm3sys15getSwappedBytesEl",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZN4llvm3sys15getSwappedBytesEl")
//</editor-fold>
public static /*inline*/ long getSwappedBytes_long(long C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes_long(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 90,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZN4llvm3sys15getSwappedBytesEy")
//</editor-fold>
public static /*inline*/ /*ullong*/long getSwappedBytes_ullong(/*ullong*/long C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes_ullong(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getSwappedBytes">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 93,
 FQN="llvm::sys::getSwappedBytes", NM="_ZN4llvm3sys15getSwappedBytesEx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZN4llvm3sys15getSwappedBytesEx")
//</editor-fold>
public static /*inline*/ /*llong*/long getSwappedBytes_llong(/*llong*/long C) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    getSwappedBytes_llong(C);
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::sys::swapByteOrder">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/SwapByteOrder.h", line = 98,
 FQN="llvm::sys::swapByteOrder", NM="_ZN4llvm3sys13swapByteOrderERT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZN4llvm3sys13swapByteOrderERT_")
//</editor-fold>
public static /*inline*/ </*typename*/ T> T/*JAVA added return type*/ swapByteOrder(T /*&*/ Value) {
  return /*delegate*/org.llvm.support.sys.impl.SwapByteOrderSysGlobals.
    swapByteOrder(Value);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::operator+">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 371,
 FQN = "llvm::sys::operator+", NM = "_ZN4llvm3sysplERKNS0_9TimeValueES3_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sysplERKNS0_9TimeValueES3_")
//</editor-fold>
public static /*inline*/ TimeValue $add_TimeValue(/*const*/ TimeValue /*&*/ tv1, /*const*/ TimeValue /*&*/ tv2) {
  TimeValue sum/*J*/= new TimeValue(tv1.seconds_ + tv2.seconds_, tv1.nanos_ + tv2.nanos_);
  sum.normalize();
  return sum;
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::operator-">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/TimeValue.h", line = 377,
 FQN = "llvm::sys::operator-", NM = "_ZN4llvm3sysmiERKNS0_9TimeValueES3_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TimeValue.cpp -nm=_ZN4llvm3sysmiERKNS0_9TimeValueES3_")
//</editor-fold>
public static /*inline*/ TimeValue $sub_TimeValue(/*const*/ TimeValue /*&*/ tv1, /*const*/ TimeValue /*&*/ tv2) {
  TimeValue difference/*J*/= new TimeValue(tv1.seconds_ - tv2.seconds_, tv1.nanos_ - tv2.nanos_);
  difference.normalize();
  return difference;
}

public static /*const*/boolean IsBigEndianHost = false;

public static /*const*/boolean IsLittleEndianHost = !IsBigEndianHost;

/// getDefaultTargetTriple() - Return the default target triple the compiler
/// has been configured to produce code for.
///
/// The target triple is a string in the format of:
///   CPU_TYPE-VENDOR-OPERATING_SYSTEM
/// or
///   CPU_TYPE-VENDOR-KERNEL-OPERATING_SYSTEM
//<editor-fold defaultstate="collapsed" desc="llvm::sys::getDefaultTargetTriple">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Host.inc", line = 37,
 FQN = "llvm::sys::getDefaultTargetTriple", NM = "_ZN4llvm3sys22getDefaultTargetTripleEv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN4llvm3sys22getDefaultTargetTripleEv")
//</editor-fold>
public static std.string getDefaultTargetTriple() {
  return HostStatics.getDefaultTargetTriple();
}



/// getProcessTriple() - Return an appropriate target triple for generating
/// code to be loaded into the current process, e.g. when using the JIT.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::getProcessTriple">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", line = 919,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", old_line = 765,
 FQN = "llvm::sys::getProcessTriple", NM = "_ZN4llvm3sys16getProcessTripleEv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN4llvm3sys16getProcessTripleEv")
//</editor-fold>
public static std.string getProcessTriple() {
  return HostSysGlobals.getProcessTriple();
}


/// getHostCPUName - Get the LLVM name for the host CPU. The particular format
/// of the name is target dependent, and suitable for passing as -mcpu to the
/// target which matches the host.
///
/// \return - The host CPU name, or empty if the CPU could not be determined.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::getHostCPUName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Host.h", line = 58,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", old_line = 215,
 FQN="llvm::sys::getHostCPUName", NM="_ZN4llvm3sys14getHostCPUNameEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN4llvm3sys14getHostCPUNameEv")
//</editor-fold>
public static StringRef getHostCPUName() {
  return HostSysGlobals.getHostCPUName();
}


/// getHostCPUFeatures - Get the LLVM names for the host CPU features.
/// The particular format of the names are target dependent, and suitable for
/// passing as -mattr to the target which matches the host.
///
/// \param Features - A string mapping feature names to either
/// true (if enabled) or false (if disabled). This routine makes no guarantees
/// about exactly which features may appear in this map, except that they are
/// all valid LLVM feature names.
///
/// \return - True on success.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::getHostCPUFeatures">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", line = 744,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", old_line = 760,
 FQN = "llvm::sys::getHostCPUFeatures", NM = "_ZN4llvm3sys18getHostCPUFeaturesERNS_9StringMapIbNS_15MallocAllocatorEEE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN4llvm3sys18getHostCPUFeaturesERNS_9StringMapIbNS_15MallocAllocatorEEE")
//</editor-fold>
public static boolean getHostCPUFeatures(StringMapBool/*&*/ Features) {
  return HostSysGlobals.getHostCPUFeatures(Features);
}

public static final ManagedStaticInfo<SmartMutex/*true*/> StaticSmartMutexTrue = new ManagedStaticInfoImpl<SmartMutex/*true*/>() {

  @Override
  protected SmartMutex/*true*/ create() {
    return new SmartMutex(true);
  }
  
};
      
public static final ManagedStaticInfo<std.string> StaticStdString = new ManagedStaticInfoImpl<std.string>() {

  @Override
  protected std.string create() {
    return new std.string();
  }
};

public static final ManagedStaticInfo<vectorCharPtr> StaticStdVectorCharPtr = new ManagedStaticInfoImpl<vectorCharPtr>() {

  @Override
  protected vectorCharPtr create() {
    return new vectorCharPtr();
  }
};

  public static void RunningOnValgrind() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

/// Mutex - A standard, always enforced mutex.
/*typedef SmartMutex<false> Mutex*/
//<editor-fold defaultstate="collapsed" desc="llvm::sys::Mutex">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/Mutex.h", line = 136,
 FQN = "llvm::sys::Mutex", NM = "_ZN4llvm3sys5MutexE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::sys::Mutex",
 notes = Converted.Notes.FAILED)
//</editor-fold>
public static final class Mutex extends SmartMutex/*<false>*/ {

    public Mutex() {
      this(true);
    }
  
    public Mutex(boolean rec) {
      super(false, rec);
    }
}


/*typedef SmartScopedLock<false> ScopedLock*/
public final class ScopedLock extends SmartScopedLock/*<false>*//*<false>*/{ 
  public ScopedLock(SmartMutex/*<mt_only>*/ /*&*/ m) {
    super(false, m);
    assert m.mt_only() == false;
  }
};

//<editor-fold defaultstate="collapsed" desc="llvm::sys::operator<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/UnicodeCharRanges.h", line = 32,
 FQN = "llvm::sys::operator<", NM = "_ZN4llvm3sysltEjNS0_16UnicodeCharRangeE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm3sysltEjNS0_16UnicodeCharRangeE")
//</editor-fold>
public static /*inline*/ boolean $less_uint32_t_UnicodeCharRange(int/*uint32_t*/ Value, UnicodeCharRange Range) {
  return Value < Range.Lower;
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::operator<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/UnicodeCharRanges.h", line = 35,
 FQN = "llvm::sys::operator<", NM = "_ZN4llvm3sysltENS0_16UnicodeCharRangeEj",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm3sysltENS0_16UnicodeCharRangeEj")
//</editor-fold>
public static /*inline*/ boolean $less_UnicodeCharRange_uint32_t(UnicodeCharRange Range, int/*uint32_t*/ Value) {
  return Range.Upper < Value;
}

// ThreadLocalImpl - Common base class of all ThreadLocal instantiations.
// YOU SHOULD NEVER USE THIS DIRECTLY.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::ThreadLocalImpl">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/ThreadLocal.h", line = 25,
 FQN = "llvm::sys::ThreadLocalImpl", NM = "_ZN4llvm3sys15ThreadLocalImplE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ThreadLocal.cpp -nm=_ZN4llvm3sys15ThreadLocalImplE")
//</editor-fold>
public static class ThreadLocalImpl implements Destructors.ClassWithDestructor {
  /*typedef uint64_t ThreadLocalDataTy*/;
  /// \brief Platform-specific thread local data.
  ///
  /// This is embedded in the class and we avoid malloc'ing/free'ing it,
  /// to make this class more safe for use along with CrashRecoveryContext.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::ThreadLocalImpl::<anonymous>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ThreadLocal.h", line = 31,
   FQN = "llvm::sys::ThreadLocalImpl::(anonymous)", NM = "_ZN4llvm3sys15ThreadLocalImplE_Unnamed_union1",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ThreadLocal.cpp -nm=_ZN4llvm3sys15ThreadLocalImplE_Unnamed_union1")
  //</editor-fold>
  private static class/*union*/ Unnamed_union1 {
    public /*char*/byte data[/*8*/] = new /*char*/byte [8];
    public long/*uint64_t*/ align_data;
  };
  private Unnamed_union1 Unnamed_field = new Unnamed_union1();
  private final java.lang.ThreadLocal<Object> data = new java.lang.ThreadLocal<Object>();
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::ThreadLocalImpl::ThreadLocalImpl">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/ThreadLocal.inc", line = 28,
   FQN = "llvm::sys::ThreadLocalImpl::ThreadLocalImpl", NM = "_ZN4llvm3sys15ThreadLocalImplC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ThreadLocal.cpp -nm=_ZN4llvm3sys15ThreadLocalImplC1Ev")
  //</editor-fold>
  public ThreadLocalImpl() {
    /* : data(implicit char [8]())*/ 
    //START JInit
    this.Unnamed_field.data = /*implicit*/ /*char*/new byte [8];
    //END JInit
    /*typedef int SIZE_TOO_BIG[1]*/
//    final class SIZE_TOO_BIG extends int [1]{ };
//    uint$ptr/*uint P*/ key = $tryClone(reinterpret_cast(uint$ptr/*uint P*/ .class, /*AddrOf*/Unnamed_field.data));
//    int errorcode = pthread_key_create(key, null);
//    assert (errorcode == 0);
//    (void)errorcode;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::ThreadLocalImpl::~ThreadLocalImpl">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/ThreadLocal.inc", line = 36,
   FQN = "llvm::sys::ThreadLocalImpl::~ThreadLocalImpl", NM = "_ZN4llvm3sys15ThreadLocalImplD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ThreadLocal.cpp -nm=_ZN4llvm3sys15ThreadLocalImplD0Ev")
  //</editor-fold>
  public void $destroy() {
    data.remove();
//    uint$ptr/*uint P*/ key = $tryClone(reinterpret_cast(uint$ptr/*uint P*/ .class, /*AddrOf*/Unnamed_field.data));
//    int errorcode = pthread_key_delete(key.$star());
//    assert (errorcode == 0);
//    (void)errorcode;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::ThreadLocalImpl::setInstance">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/ThreadLocal.inc", line = 43,
   FQN = "llvm::sys::ThreadLocalImpl::setInstance", NM = "_ZN4llvm3sys15ThreadLocalImpl11setInstanceEPKv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ThreadLocal.cpp -nm=_ZN4llvm3sys15ThreadLocalImpl11setInstanceEPKv")
  //</editor-fold>
  public void setInstance(/*const*/Object/*void P*/ d) {
    data.set(d);
//    uint$ptr/*uint P*/ key = $tryClone(reinterpret_cast(uint$ptr/*uint P*/ .class, /*AddrOf*/Unnamed_field.data));
//    int errorcode = pthread_setspecific(key.$star(), d);
//    assert (errorcode == 0);
//    (void)errorcode;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::ThreadLocalImpl::getInstance">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/ThreadLocal.inc", line = 50,
   FQN = "llvm::sys::ThreadLocalImpl::getInstance", NM = "_ZN4llvm3sys15ThreadLocalImpl11getInstanceEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ThreadLocal.cpp -nm=_ZN4llvm3sys15ThreadLocalImpl11getInstanceEv")
  //</editor-fold>
  public /*const*/Object/*void P*/ getInstance() {
    return data.get();
//    uint$ptr/*uint P*/ key = $tryClone(reinterpret_cast(uint$ptr/*uint P*/ .class, /*AddrOf*/Unnamed_field.data));
//    return pthread_getspecific(key.$star());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::ThreadLocalImpl::removeInstance">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/ThreadLocal.inc", line = 55,
   FQN = "llvm::sys::ThreadLocalImpl::removeInstance", NM = "_ZN4llvm3sys15ThreadLocalImpl14removeInstanceEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ThreadLocal.cpp -nm=_ZN4llvm3sys15ThreadLocalImpl14removeInstanceEv")
  //</editor-fold>
  public void removeInstance() {
    setInstance(null);
  }
}

/// ThreadLocal - A class used to abstract thread-local storage.  It holds,
/// for each thread, a pointer a single object of type T.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::ThreadLocal">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ThreadLocal.h", line = 45,
 FQN = "llvm::sys::ThreadLocal", NM = "_ZN4llvm3sys11ThreadLocalE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ThreadLocal.cpp -nm=_ZN4llvm3sys11ThreadLocalE")
//</editor-fold>
public static class ThreadLocal</*class*/ T>  extends /*public*/ ThreadLocalImpl implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::ThreadLocal::ThreadLocal<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ThreadLocal.h", line = 48,
   FQN = "llvm::sys::ThreadLocal::ThreadLocal<T>", NM = "_ZN4llvm3sys11ThreadLocalC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ThreadLocal.cpp -nm=_ZN4llvm3sys11ThreadLocalC1Ev")
  //</editor-fold>
  public ThreadLocal() {
    /* : ThreadLocalImpl()*/ 
    //START JInit
    super();
    //END JInit
  }

  
  /// get - Fetches a pointer to the object associated with the current
  /// thread.  If no object has yet been associated, it returns NULL;
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::ThreadLocal::get">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ThreadLocal.h", line = 52,
   FQN = "llvm::sys::ThreadLocal::get", NM = "_ZN4llvm3sys11ThreadLocal3getEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ThreadLocal.cpp -nm=_ZN4llvm3sys11ThreadLocal3getEv")
  //</editor-fold>
  public T /*P*/ get() {
    return (/*static_cast*/T /*P*/ )(getInstance());
  }

  
  // set - Associates a pointer to an object with the current thread.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::ThreadLocal::set">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ThreadLocal.h", line = 55,
   FQN = "llvm::sys::ThreadLocal::set", NM = "_ZN4llvm3sys11ThreadLocal3setEPT_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ThreadLocal.cpp -nm=_ZN4llvm3sys11ThreadLocal3setEPT_")
  //</editor-fold>
  public void set(T /*P*/ d) {
    setInstance(d);
  }

  
  // erase - Removes the pointer associated with the current thread.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::ThreadLocal::erase">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ThreadLocal.h", line = 58,
   FQN = "llvm::sys::ThreadLocal::erase", NM = "_ZN4llvm3sys11ThreadLocal5eraseEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ThreadLocal.cpp -nm=_ZN4llvm3sys11ThreadLocal5eraseEv")
  //</editor-fold>
  public void erase() {
    removeInstance();
  }
}

/// This class provides an abstraction for a timeout around an operation
/// that must complete in a given amount of time. Failure to complete before
/// the timeout is an unrecoverable situation and no mechanisms to attempt
/// to handle it are provided.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::Watchdog">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Watchdog.h", line = 26,
 FQN = "llvm::sys::Watchdog", NM = "_ZN4llvm3sys8WatchdogE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Watchdog.cpp -nm=_ZN4llvm3sys8WatchdogE")
//</editor-fold>
public static class Watchdog implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Watchdog::Watchdog">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Watchdog.inc", line = 20,
   FQN = "llvm::sys::Watchdog::Watchdog", NM = "_ZN4llvm3sys8WatchdogC1Ej",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Watchdog.cpp -nm=_ZN4llvm3sys8WatchdogC1Ej")
  //</editor-fold>
  public Watchdog(/*uint*/int seconds) {
    alarm(seconds);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Watchdog::~Watchdog">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Watchdog.inc", line = 26,
   FQN = "llvm::sys::Watchdog::~Watchdog", NM = "_ZN4llvm3sys8WatchdogD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Watchdog.cpp -nm=_ZN4llvm3sys8WatchdogD0Ev")
  //</editor-fold>
  public void $destroy() {
    alarm(0);
  }

/*private:*/
  // Noncopyable.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Watchdog::Watchdog">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Watchdog.h", line = 32,
   FQN = "llvm::sys::Watchdog::Watchdog", NM = "_ZN4llvm3sys8WatchdogC1ERKS1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Watchdog.cpp -nm=_ZN4llvm3sys8WatchdogC1ERKS1_")
  //</editor-fold>
  private Watchdog(/*const*/Watchdog /*&*/ other) {
    throw new UnsupportedOperationException("LLVM_DELETED_FUNCTION");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Watchdog::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Watchdog.h", line = 33,
   FQN = "llvm::sys::Watchdog::operator=", NM = "_ZN4llvm3sys8WatchdogaSERKS1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Watchdog.cpp -nm=_ZN4llvm3sys8WatchdogaSERKS1_")
  //</editor-fold>
  private Watchdog /*&*/ $assign(/*const*/Watchdog /*&*/ other) {
    throw new UnsupportedOperationException("LLVM_DELETED_FUNCTION");
  }

}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::MemoryFence">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Atomic.cpp", line = 29,
 FQN = "llvm::sys::MemoryFence", NM = "_ZN4llvm3sys11MemoryFenceEv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Atomic.cpp -nm=_ZN4llvm3sys11MemoryFenceEv")
//</editor-fold>
public static void MemoryFence() {
  __sync_synchronize();
}

} // END OF class sys
