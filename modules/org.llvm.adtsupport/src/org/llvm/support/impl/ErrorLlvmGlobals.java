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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.support.impl.*;
import org.llvm.support.Error;
import static org.llvm.support.impl.ErrorStatics.ErrorErrorCat;


//<editor-fold defaultstate="collapsed" desc="static type ErrorLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.support.impl.ErrorLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm10make_errorEDpOT0_;Tpl__ZN4llvm12handleErrorsENS_5ErrorEDpOT_;Tpl__ZN4llvm15handleAllErrorsENS_5ErrorEDpOT_;Tpl__ZN4llvm15handleErrorImplESt10unique_ptrINS_13ErrorInfoBaseESt14default_deleteIS1_EEOT_DpOT0_;Tpl__ZN4llvm17errorOrToExpectedEONS_7ErrorOrIT_EE;Tpl__ZN4llvm17expectedToErrorOrEONS_8ExpectedIT_EE;_ZN4llvm10joinErrorsENS_5ErrorES0_;_ZN4llvm12consumeErrorENS_5ErrorE;_ZN4llvm15handleAllErrorsENS_5ErrorE;_ZN4llvm15handleErrorImplESt10unique_ptrINS_13ErrorInfoBaseESt14default_deleteIS1_EE;_ZN4llvm16errorCodeToErrorESt10error_code;_ZN4llvm16errorToErrorCodeENS_5ErrorE;_ZN4llvm18report_fatal_errorENS_5ErrorEb;_ZN4llvm21logAllUnhandledErrorsENS_5ErrorERNS_11raw_ostreamENS_5TwineE;_ZN4llvm22inconvertibleErrorCodeEv;_ZN4llvm8toStringB5cxx11ENS_5ErrorE; -static-type=ErrorLlvmGlobals -package=org.llvm.support.impl")
//</editor-fold>
public final class ErrorLlvmGlobals {


// handleErrors needs to be able to set the Checked flag.
/*template <typename ... HandlerTs> TEMPLATE*/

/// Pass the ErrorInfo(s) contained in E to their respective handlers. Any
/// unhandled errors (or Errors returned by handlers) are re-concatenated and
/// returned.
/// Because this function returns an error, its result must also be checked
/// or returned. If you intend to handle all errors use handleAllErrors
/// (which returns void, and will abort() on unhandled errors) instead.
//<editor-fold defaultstate="collapsed" desc="llvm::handleErrors">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 498,
 FQN="llvm::handleErrors", NM="Tpl__ZN4llvm12handleErrorsENS_5ErrorEDpOT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm12handleErrorsENS_5ErrorEDpOT_")
//</editor-fold>
public static </*typename*/ /*...*/ HandlerTs> Error handleErrors(Error E, HandlerTs /*&&*/...Hs) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Make a Error instance representing failure using the given error info
/// type.
/*template <typename ErrT, typename ... ArgTs> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::make_error">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 282,
 FQN="llvm::make_error", NM="Tpl__ZN4llvm10make_errorEDpOT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm10make_errorEDpOT0_")
//</editor-fold>
public static </*typename*/ ErrT, /*typename*/ /*...*/ ArgTs> Error make_error(ArgTs /*&&*/...Args) {
  throw new UnsupportedOperationException("EmptyBody");
}


// joinErrors is implemented in terms of join.

/// Concatenate errors. The resulting Error is unchecked, and contains the
/// ErrorInfo(s), if any, contained in E1, followed by the
/// ErrorInfo(s), if any, contained in E2.
//<editor-fold defaultstate="collapsed" desc="llvm::joinErrors">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 372,
 FQN="llvm::joinErrors", NM="_ZN4llvm10joinErrorsENS_5ErrorES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm10joinErrorsENS_5ErrorES0_")
//</editor-fold>
public static /*inline*/ Error joinErrors(Error E1, Error E2) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::handleErrorImpl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 477,
 FQN="llvm::handleErrorImpl", NM="_ZN4llvm15handleErrorImplESt10unique_ptrINS_13ErrorInfoBaseESt14default_deleteIS1_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm15handleErrorImplESt10unique_ptrINS_13ErrorInfoBaseESt14default_deleteIS1_EE")
//</editor-fold>
public static /*inline*/ Error handleErrorImpl(std.unique_ptr<ErrorInfoBase> Payload) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename HandlerT, typename ... HandlerTs> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::handleErrorImpl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 482,
 FQN="llvm::handleErrorImpl", NM="Tpl__ZN4llvm15handleErrorImplESt10unique_ptrINS_13ErrorInfoBaseESt14default_deleteIS1_EEOT_DpOT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm15handleErrorImplESt10unique_ptrINS_13ErrorInfoBaseESt14default_deleteIS1_EEOT_DpOT0_")
//</editor-fold>
public static </*typename*/ HandlerT, /*typename*/ /*...*/ HandlerTs> Error handleErrorImpl$T(std.unique_ptr<ErrorInfoBase> Payload, 
                 final HandlerT /*&&*/Handler, HandlerTs /*&&*/...Handlers) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Behaves the same as handleErrors, except that it requires that all
/// errors be handled by the given handlers. If any unhandled error remains
/// after the handlers have run, abort() will be called.
/*template <typename ... HandlerTs> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::handleAllErrors">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 521,
 FQN="llvm::handleAllErrors", NM="Tpl__ZN4llvm15handleAllErrorsENS_5ErrorEDpOT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm15handleAllErrorsENS_5ErrorEDpOT_")
//</editor-fold>
public static </*typename*/ /*...*/ HandlerTs> void handleAllErrors$T(Error E, HandlerTs /*&&*/...Handlers) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Check that E is a non-error, then drop it.
//<editor-fold defaultstate="collapsed" desc="llvm::handleAllErrors">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 528,
 FQN="llvm::handleAllErrors", NM="_ZN4llvm15handleAllErrorsENS_5ErrorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm15handleAllErrorsENS_5ErrorE")
//</editor-fold>
public static /*inline*/ void handleAllErrors(Error E) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Log all errors (if any) in E to OS. If there are any errors, ErrorBanner
/// will be printed before the first one is logged. A newline will be printed
/// after each error.
///
/// This is useful in the base level of your program to allow clean termination
/// (allowing clean deallocation of resources, etc.), while reporting error
/// information to the user.
//<editor-fold defaultstate="collapsed" desc="llvm::logAllUnhandledErrors">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/Error.cpp", line = 57,
 FQN="llvm::logAllUnhandledErrors", NM="_ZN4llvm21logAllUnhandledErrorsENS_5ErrorERNS_11raw_ostreamENS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm21logAllUnhandledErrorsENS_5ErrorERNS_11raw_ostreamENS_5TwineE")
//</editor-fold>
public static void logAllUnhandledErrors(Error E, final raw_ostream /*&*/ OS, Twine ErrorBanner) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Write all error messages (if any) in E to a string. The newline character
/// is used to separate error messages.
//<editor-fold defaultstate="collapsed" desc="llvm::toString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 544,
 FQN="llvm::toString", NM="_ZN4llvm8toStringENS_5ErrorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm8toStringENS_5ErrorE")
//</editor-fold>
public static /*inline*/ std.string __toString(Error E) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Consume a Error without doing anything. This method should be used
/// only where an error can be considered a reasonable and expected return
/// value.
///
/// Uses of this method are potentially indicative of design problems: If it's
/// legitimate to do nothing while processing an "error", the error-producer
/// might be more clearly refactored to return an Optional<T>.
//<editor-fold defaultstate="collapsed" desc="llvm::consumeError">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 559,
 FQN="llvm::consumeError", NM="_ZN4llvm12consumeErrorENS_5ErrorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm12consumeErrorENS_5ErrorE")
//</editor-fold>
public static /*inline*/ void consumeError(Error Err) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::errorCodeToError">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/Error.cpp", line = 78,
 FQN="llvm::errorCodeToError", NM="_ZN4llvm16errorCodeToErrorESt10error_code",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm16errorCodeToErrorESt10error_code")
//</editor-fold>
public static Error errorCodeToError(std.error_code EC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// The value returned by this function can be returned from convertToErrorCode
/// for Error values where no sensible translation to std::error_code exists.
/// It should only be used in this situation, and should never be used where a
/// sensible conversion to std::error_code is available, as attempts to convert
/// to/from this error will result in a fatal error. (i.e. it is a programmatic
///error to try to convert such a value).
//<editor-fold defaultstate="collapsed" desc="llvm::inconvertibleErrorCode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Error.cpp", line = 73,
 FQN="llvm::inconvertibleErrorCode", NM="_ZN4llvm22inconvertibleErrorCodeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm22inconvertibleErrorCodeEv")
//</editor-fold>
public static std.error_code inconvertibleErrorCode() {
  return new std.error_code(((/*static_cast*/int)ErrorErrorCode.InconvertibleError.getValue()), 
      ErrorErrorCat.$star());
}


/// Helper for converting an ECError to a std::error_code.
///
/// This method requires that Err be Error() or an ECError, otherwise it
/// will trigger a call to abort().
//<editor-fold defaultstate="collapsed" desc="llvm::errorToErrorCode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/Error.cpp", line = 84,
 FQN="llvm::errorToErrorCode", NM="_ZN4llvm16errorToErrorCodeENS_5ErrorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm16errorToErrorCodeENS_5ErrorE")
//</editor-fold>
public static std.error_code errorToErrorCode(Error Err) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Convert an ErrorOr<T> to an Expected<T>.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::errorOrToExpected">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 865,
 FQN="llvm::errorOrToExpected", NM="Tpl__ZN4llvm17errorOrToExpectedEONS_7ErrorOrIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm17errorOrToExpectedEONS_7ErrorOrIT_EE")
//</editor-fold>
public static </*typename*/ T> Expected<T> errorOrToExpected(final ErrorOr<T> /*&&*/EO) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Convert an Expected<T> to an ErrorOr<T>.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::expectedToErrorOr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 872,
 FQN="llvm::expectedToErrorOr", NM="Tpl__ZN4llvm17expectedToErrorOrEONS_8ExpectedIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm17expectedToErrorOrEONS_8ExpectedIT_EE")
//</editor-fold>
public static </*typename*/ T> ErrorOr<T> expectedToErrorOr(final Expected<T> /*&&*/E) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Report a serious error, calling any installed error handler. See
/// ErrorHandling.h.
//<editor-fold defaultstate="collapsed" desc="llvm::report_fatal_error">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/Error.cpp", line = 103,
 FQN="llvm::report_fatal_error", NM="_ZN4llvm18report_fatal_errorENS_5ErrorEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm18report_fatal_errorENS_5ErrorEb")
//</editor-fold>
public static void report_fatal_error(Error Err) {
  report_fatal_error(Err, true);
}
public static void report_fatal_error(Error Err, boolean GenCrashDiag/*= true*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class ErrorLlvmGlobals
