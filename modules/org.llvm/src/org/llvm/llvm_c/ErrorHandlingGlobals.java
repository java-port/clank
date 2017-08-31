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
package org.llvm.llvm_c;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.Error;
import org.llvm.object.*;;


//<editor-fold defaultstate="collapsed" desc="static type ErrorHandlingGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.llvm_c.ErrorHandlingGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_Z26LLVMEnablePrettyStackTrace;_Z26LLVMResetFatalErrorHandler;_Z28LLVMInstallFatalErrorHandler; -static-type=ErrorHandlingGlobals -package=org.llvm.llvm_c")
//</editor-fold>
public final class ErrorHandlingGlobals {


/**
* Install a fatal error handler. By default, if LLVM detects a fatal error, it
* will call exit(1). This may not be appropriate in many contexts. For example,
* doing exit(1) will bypass many crash reporting/tracing system tools. This
* function allows you to install a callback that will be invoked prior to the
* call to exit(1).
*/
//<editor-fold defaultstate="collapsed" desc="LLVMInstallFatalErrorHandler">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 133,
 FQN="LLVMInstallFatalErrorHandler", NM="_Z28LLVMInstallFatalErrorHandler",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_Z28LLVMInstallFatalErrorHandler")
//</editor-fold>
public static void LLVMInstallFatalErrorHandler(ConstCharPtr2Void Handler) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Reset the fatal error handler. This resets LLVM's fatal error handling
* behavior to the default.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMResetFatalErrorHandler">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 138,
 FQN="LLVMResetFatalErrorHandler", NM="_Z26LLVMResetFatalErrorHandler",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_Z26LLVMResetFatalErrorHandler")
//</editor-fold>
public static void LLVMResetFatalErrorHandler() {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Enable LLVM's built-in stack trace code. This intercepts the OS's crash
* signals and prints which component of LLVM you were in at the time if the
* crash.
*/

/**
* Enable LLVM's built-in stack trace code. This intercepts the OS's crash
* signals and prints which component of LLVM you were in at the time if the
* crash.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMEnablePrettyStackTrace">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", line = 186,
 FQN="LLVMEnablePrettyStackTrace", NM="_Z26LLVMEnablePrettyStackTrace",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_Z26LLVMEnablePrettyStackTrace")
//</editor-fold>
public static void LLVMEnablePrettyStackTrace() {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class ErrorHandlingGlobals
