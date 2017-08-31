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
import org.clank.support.aliases.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.ADTFunctionPointers.fatal_error_handler_t;
import static org.llvm.support.impl.ErrorHandlingStatics.*;
import org.llvm.support.sys.*;


//<editor-fold defaultstate="collapsed" desc="static type ErrorHandlingLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -file-filter=${LLVM_SRC}/llvm/include/llvm/Support/ErrorHandling.h#46;${LLVM_SRC}/llvm/include/llvm/Support/ErrorHandling.h#50;${LLVM_SRC}/llvm/include/llvm/Support/ErrorHandling.h#72;${LLVM_SRC}/llvm/include/llvm/Support/ErrorHandling.h#74;${LLVM_SRC}/llvm/include/llvm/Support/ErrorHandling.h#76;${LLVM_SRC}/llvm/include/llvm/Support/ErrorHandling.h#78;${LLVM_SRC}/llvm/include/llvm/Support/ErrorHandling.h#84; -static-type=ErrorHandlingLlvmGlobals")
//</editor-fold>
public final class ErrorHandlingLlvmGlobals {


/// install_fatal_error_handler - Installs a new error handler to be used
/// whenever a serious (non-recoverable) error is encountered by LLVM.
///
/// If no error handler is installed the default is to print the error message
/// to stderr, and call exit(1).  If an error handler is installed then it is
/// the handler's responsibility to log the message, it will no longer be
/// printed to stderr.  If the error handler returns, then exit(1) will be
/// called.
///
/// It is dangerous to naively use an error handler which throws an exception.
/// Even though some applications desire to gracefully recover from arbitrary
/// faults, blindly throwing exceptions through unfamiliar code isn't a way to
/// achieve this.
///
/// \param user_data - An argument which will be passed to the install error
/// handler.
//<editor-fold defaultstate="collapsed" desc="llvm::install_fatal_error_handler">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 47,
 FQN = "llvm::install_fatal_error_handler", NM = "_ZN4llvm27install_fatal_error_handlerEPFvPvRKSsbES0_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm27install_fatal_error_handlerEPFvPvRKSsbES0_")
//</editor-fold>
public static void install_fatal_error_handler(fatal_error_handler_t handler) {
  install_fatal_error_handler(handler, 
                           (Object/*void P*/ )null);
}
public static void install_fatal_error_handler(fatal_error_handler_t handler, 
                           Object/*void P*/ user_data/*= null*/) {
  MutexGuard Lock = null;
  try {
    Lock/*J*/= new MutexGuard(ErrorHandlerMutex.$star());
    assert (!(ErrorHandler != null)) : "Error handler already registered!\n";
    ErrorHandler = $tryClone(handler);
    ErrorHandlerUserData = $tryClone(user_data);
  } finally {
    if (Lock != null) { Lock.$destroy(); }
  }
}


/// Restores default error handling behaviour.
//<editor-fold defaultstate="collapsed" desc="llvm::remove_fatal_error_handler">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 55,
 FQN = "llvm::remove_fatal_error_handler", NM = "_ZN4llvm26remove_fatal_error_handlerEv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm26remove_fatal_error_handlerEv")
//</editor-fold>
public static void remove_fatal_error_handler() {
  MutexGuard Lock = null;
  try {
    Lock/*J*/= new MutexGuard(ErrorHandlerMutex.$star());
    ErrorHandler = null;
    ErrorHandlerUserData = null;
  } finally {
    if (Lock != null) { Lock.$destroy(); }
  }
}


/// Reports a serious error, calling any installed error handler. These
/// functions are intended to be used for error conditions which are outside
/// the control of the compiler (I/O errors, invalid user input, etc.)
///
/// If no error handler is installed the default is to print the message to
/// standard error, followed by a newline.
/// After the error handler is called this function will call exit(1), it 
/// does not return.
//<editor-fold defaultstate="collapsed" desc="llvm::report_fatal_error">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 61,
 FQN = "llvm::report_fatal_error", NM = "_ZN4llvm18report_fatal_errorEPKcb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm18report_fatal_errorEPKcb")
//</editor-fold>
public static void report_fatal_error(/*const*/char$ptr/*char P*/ Reason) {
  report_fatal_error(Reason, true);
}
public static void report_fatal_error(/*const*/char$ptr/*char P*/ Reason, boolean GenCrashDiag/*= true*/) {
  report_fatal_error(new Twine(Reason), GenCrashDiag);
}

//<editor-fold defaultstate="collapsed" desc="llvm::report_fatal_error">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 65,
 FQN = "llvm::report_fatal_error", NM = "_ZN4llvm18report_fatal_errorERKSsb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm18report_fatal_errorERKSsb")
//</editor-fold>
public static void report_fatal_error(/*const*/std.string/*&*/ Reason) {
  report_fatal_error(Reason, true);
}
public static void report_fatal_error(/*const*/std.string/*&*/ Reason, boolean GenCrashDiag/*= true*/) {
  report_fatal_error(new Twine(Reason), GenCrashDiag);
}

//<editor-fold defaultstate="collapsed" desc="llvm::report_fatal_error">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 69,
 FQN = "llvm::report_fatal_error", NM = "_ZN4llvm18report_fatal_errorENS_9StringRefEb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm18report_fatal_errorENS_9StringRefEb")
//</editor-fold>
public static void report_fatal_error(StringRef Reason) {
  report_fatal_error(Reason, true);
}
public static void report_fatal_error(StringRef Reason, boolean GenCrashDiag/*= true*/) {
  report_fatal_error(new Twine(Reason), GenCrashDiag);
}

//<editor-fold defaultstate="collapsed" desc="llvm::report_fatal_error">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 73,
 FQN = "llvm::report_fatal_error", NM = "_ZN4llvm18report_fatal_errorERKNS_5TwineEb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm18report_fatal_errorERKNS_5TwineEb")
//</editor-fold>
public static void report_fatal_error(/*const*/ Twine /*&*/ Reason) {
  report_fatal_error(Reason, true);
}
public static void report_fatal_error(/*const*/ Twine /*&*/ Reason, boolean GenCrashDiag/*= true*/) {
  fatal_error_handler_t handler = null;
  Object/*void P*/ handlerData = null;
  {
    MutexGuard Lock = null;
    try {
      // Only acquire the mutex while reading the handler, so as not to invoke a
      // user-supplied callback under a lock.
      Lock/*J*/= new MutexGuard(ErrorHandlerMutex.$star());
      handler = $tryClone(ErrorHandler);
      handlerData = $tryClone(ErrorHandlerUserData);
    } finally {
      if (Lock != null) { Lock.$destroy(); }
    }
  }
  if ((handler != null)) {
    handler.$call(handlerData, Reason.str(), GenCrashDiag);
  } else {
    SmallString/*64*/ Buffer = null;
    raw_svector_ostream OS = null;
    try {
      // Blast the result out to stderr.  We don't try hard to make sure this
      // succeeds (e.g. handling EINTR) and we can't use errs() here because
      // raw ostreams can call report_fatal_error.
      Buffer/*J*/= new SmallString/*64*/(64);
      OS/*J*/= new raw_svector_ostream(Buffer);
      $out_raw_ostream_Twine(OS.$out($("LLVM ERROR: ")), Reason).$out($LF);
      StringRef MessageStr = OS.str();
      long written = /*::*/write(2, MessageStr.data(), MessageStr.size());
      //(void)written; // If something went wrong, we deliberately just give up.
    } finally {
      if (OS != null) { OS.$destroy(); }
      if (Buffer != null) { Buffer.$destroy(); }
    }
  }
  
  // If we reached here, we are failing ungracefully. Run the interrupt handlers
  // to make sure any special cleanups get done, in particular that we remove
  // files registered with RemoveFileOnSignal.
  sys.RunInterruptHandlers();
  
  exit(1);
}


/// This function calls abort(), and prints the optional message to stderr.
/// Use the llvm_unreachable macro (that adds location info), instead of
/// calling this function directly.
//<editor-fold defaultstate="collapsed" desc="llvm::llvm_unreachable_internal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 106,
 FQN = "llvm::llvm_unreachable_internal", NM = "_ZN4llvm25llvm_unreachable_internalEPKcS1_j",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm25llvm_unreachable_internalEPKcS1_j")
//</editor-fold>
public static void llvm_unreachable_internal() {
  llvm_unreachable_internal((/*const*/char$ptr/*char P*/ )null, (/*const*/char$ptr/*char P*/ )null, 
                         0);
}
public static void llvm_unreachable_internal(/*const*/char$ptr/*char P*/ msg/*= null*/) {
  llvm_unreachable_internal(msg, (/*const*/char$ptr/*char P*/ )null, 
                         0);
}
public static void llvm_unreachable_internal(/*const*/char$ptr/*char P*/ msg/*= null*/, /*const*/char$ptr/*char P*/ file/*= null*/) {
  llvm_unreachable_internal(msg, file, 
                         0);
}
public static void llvm_unreachable_internal(/*const*/char$ptr/*char P*/ msg/*= null*/, /*const*/char$ptr/*char P*/ file/*= null*/, 
                         /*uint*/int line/*= 0*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class ErrorHandlingLlvmGlobals
