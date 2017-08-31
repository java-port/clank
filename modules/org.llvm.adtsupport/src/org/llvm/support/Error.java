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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;


/// Lightweight error class with error context and mandatory checking.
///
/// Instances of this class wrap a ErrorInfoBase pointer. Failure states
/// are represented by setting the pointer to a ErrorInfoBase subclass
/// instance containing information describing the failure. Success is
/// represented by a null pointer value.
///
/// Instances of Error also contains a 'Checked' flag, which must be set
/// before the destructor is called, otherwise the destructor will trigger a
/// runtime error. This enforces at runtime the requirement that all Error
/// instances be checked or returned to the caller.
///
/// There are two ways to set the checked flag, depending on what state the
/// Error instance is in. For Error instances indicating success, it
/// is sufficient to invoke the boolean conversion operator. E.g.:
///
///   Error foo(<...>);
///
///   if (auto E = foo(<...>))
///     return E; // <- Return E if it is in the error state.
///   // We have verified that E was in the success state. It can now be safely
///   // destroyed.
///
/// A success value *can not* be dropped. For example, just calling 'foo(<...>)'
/// without testing the return value will raise a runtime error, even if foo
/// returns success.
///
/// For Error instances representing failure, you must use either the
/// handleErrors or handleAllErrors function with a typed handler. E.g.:
///
///   class MyErrorInfo : public ErrorInfo<MyErrorInfo> {
///     // Custom error info.
///   };
///
///   Error foo(<...>) { return make_error<MyErrorInfo>(...); }
///
///   auto E = foo(<...>); // <- foo returns failure with MyErrorInfo.
///   auto NewE =
///     handleErrors(E,
///       [](const MyErrorInfo &M) {
///         // Deal with the error.
///       },
///       [](std::unique_ptr<OtherError> M) -> Error {
///         if (canHandle(*M)) {
///           // handle error.
///           return Error::success();
///         }
///         // Couldn't handle this error instance. Pass it up the stack.
///         return Error(std::move(M));
///       );
///   // Note - we must check or return NewE in case any of the handlers
///   // returned a new error.
///
/// The handleAllErrors function is identical to handleErrors, except
/// that it has a void return type, and requires all errors to be handled and
/// no new errors be returned. It prevents errors (assuming they can all be
/// handled) from having to be bubbled all the way to the top-level.
///
/// *All* Error instances must be checked before destruction, even if
/// they're moved-assigned or constructed from Success values that have already
/// been checked. This enforces checking through all levels of the call stack.
//<editor-fold defaultstate="collapsed" desc="llvm::Error">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 134,
 FQN="llvm::Error", NM="_ZN4llvm5ErrorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm5ErrorE")
//</editor-fold>
public class Error implements Destructors.ClassWithDestructor, Native.Native$Bool {
  
  // ErrorList needs to be able to yank ErrorInfoBase pointers out of this
  // class to add to the error list.
  /*friend  class ErrorList*/
  
  // handleErrors needs to be able to set the Checked flag.
  /*friend template <typename ... HandlerTs> Error handleErrors(Error E, HandlerTs &&Handlers...)*/
/*public:*/
  /// Create a success value. Prefer using 'Error::success()' for readability
  /// where possible.
  //<editor-fold defaultstate="collapsed" desc="llvm::Error::Error">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 151,
   FQN="llvm::Error::Error", NM="_ZN4llvm5ErrorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm5ErrorC1Ev")
  //</editor-fold>
  public Error() {
    // : PayloadAndCheckedBit() 
    //START JInit
    this.PayloadAndCheckedBit = new PointerIntPair<ErrorInfoBase /*P*/ >();
    //END JInit
    setPtr((ErrorInfoBase /*P*/ )null);
    setChecked(false);
  }

  
  /// Create a success value. This is equivalent to calling the default
  /// constructor, but should be preferred for readability where possible.
  //<editor-fold defaultstate="collapsed" desc="llvm::Error::success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 158,
   FQN="llvm::Error::success", NM="_ZN4llvm5Error7successEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm5Error7successEv")
  //</editor-fold>
  public static Error success() {
    return new Error();
  }

  
  // Errors are not copy-constructable.
  //<editor-fold defaultstate="collapsed" desc="llvm::Error::Error">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 161,
   FQN="llvm::Error::Error", NM="_ZN4llvm5ErrorC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm5ErrorC1ERKS0_")
  //</editor-fold>
  public Error(final /*const*/ Error /*&*/ Other) { throw new UnsupportedOperationException("Deleted");}

  
  /// Move-construct an error value. The newly constructed error is considered
  /// unchecked, even if the source error had been checked. The original error
  /// becomes a checked Success value, regardless of its original state.
  //<editor-fold defaultstate="collapsed" desc="llvm::Error::Error">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 166,
   FQN="llvm::Error::Error", NM="_ZN4llvm5ErrorC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm5ErrorC1EOS0_")
  //</editor-fold>
  public Error(JD$Move _dparam, final Error /*&&*/Other) {
    // : PayloadAndCheckedBit() 
    //START JInit
    this.PayloadAndCheckedBit = new PointerIntPair<ErrorInfoBase /*P*/ >();
    //END JInit
    setChecked(true);
    /*Deref*/this.$assignMove(std.move(Other));
  }

  
  /// Create an error value. Prefer using the 'make_error' function, but
  /// this constructor can be useful when "re-throwing" errors from handlers.
  //<editor-fold defaultstate="collapsed" desc="llvm::Error::Error">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 173,
   FQN="llvm::Error::Error", NM="_ZN4llvm5ErrorC1ESt10unique_ptrINS_13ErrorInfoBaseESt14default_deleteIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm5ErrorC1ESt10unique_ptrINS_13ErrorInfoBaseESt14default_deleteIS2_EE")
  //</editor-fold>
  public Error(std.unique_ptr<ErrorInfoBase> Payload) {
    // : PayloadAndCheckedBit() 
    //START JInit
    this.PayloadAndCheckedBit = new PointerIntPair<ErrorInfoBase /*P*/ >();
    //END JInit
    setPtr(Payload.release());
    setChecked(false);
  }

  
  // Errors are not copy-assignable.
  //<editor-fold defaultstate="collapsed" desc="llvm::Error::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 179,
   FQN="llvm::Error::operator=", NM="_ZN4llvm5ErroraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm5ErroraSERKS0_")
  //</editor-fold>
  public Error /*&*/ $assign(final /*const*/ Error /*&*/ Other) { throw new UnsupportedOperationException("Deleted");}

  
  /// Move-assign an error value. The current error must represent success, you
  /// you cannot overwrite an unhandled error. The current error is then
  /// considered unchecked. The source error becomes a checked success value,
  /// regardless of its original state.
  //<editor-fold defaultstate="collapsed" desc="llvm::Error::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 185,
   FQN="llvm::Error::operator=", NM="_ZN4llvm5ErroraSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm5ErroraSEOS0_")
  //</editor-fold>
  public Error /*&*/ $assignMove(final Error /*&&*/Other) {
    // Don't allow overwriting of unchecked values.
    assertIsChecked();
    setPtr(Other.getPtr());
    
    // This Error is unchecked, even if the source error was checked.
    setChecked(false);
    
    // Null out Other's payload and set its checked bit.
    Other.setPtr((ErrorInfoBase /*P*/ )null);
    Other.setChecked(true);
    
    return /*Deref*/this;
  }

  
  /// Destroy a Error. Fails with a call to abort() if the error is
  /// unchecked.
  //<editor-fold defaultstate="collapsed" desc="llvm::Error::~Error">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 202,
   FQN="llvm::Error::~Error", NM="_ZN4llvm5ErrorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm5ErrorD0Ev")
  //</editor-fold>
  public void $destroy() {
    assertIsChecked();
    if (getPtr() != null) { getPtr().$destroy();};
  }

  
  /// Bool conversion. Returns true if this Error is in a failure state,
  /// and false if it is in an accept state. If the error is in a Success state
  /// it will be considered checked.
  //<editor-fold defaultstate="collapsed" desc="llvm::Error::operator bool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 210,
   FQN="llvm::Error::operator bool", NM="_ZN4llvm5ErrorcvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm5ErrorcvbEv")
  //</editor-fold>
  public boolean $bool() {
    setChecked(getPtr() == (ErrorInfoBase /*P*/ )null);
    return getPtr() != null;
  }

  
  /// Check whether one error is a subclass of another.
  /*template <typename ErrT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Error::isA">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 216,
   FQN="llvm::Error::isA", NM="Tpl__ZNK4llvm5Error3isAEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZNK4llvm5Error3isAEv")
  //</editor-fold>
  public </*typename*/ ErrT> boolean isA(Class<ErrT> cls) /*const*/ {
    return Native.$bool(getPtr()) && Native.$bool(getPtr().isA(cls));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Error::assertIsChecked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 221,
   FQN="llvm::Error::assertIsChecked", NM="_ZN4llvm5Error15assertIsCheckedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm5Error15assertIsCheckedEv")
  //</editor-fold>
  private void assertIsChecked() {
    if (!getChecked() || (getPtr() != null)) {
      dbgs().$out(/*KEEP_STR*/"Program aborted due to an unhandled Error:\n");
      if ((getPtr() != null)) {
        getPtr().log(dbgs());
      } else {
        dbgs().$out(
            /*KEEP_STR*/"Error value was Success. (Note: Success values must still be checked prior to being destroyed).\n"
        );
      }
      abort();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Error::getPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 236,
   FQN="llvm::Error::getPtr", NM="_ZNK4llvm5Error6getPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm5Error6getPtrEv")
  //</editor-fold>
  /*friend*/public/*private*/ ErrorInfoBase /*P*/ getPtr() /*const*/ {
    return PayloadAndCheckedBit.getPointer();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Error::setPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 244,
   FQN="llvm::Error::setPtr", NM="_ZN4llvm5Error6setPtrEPNS_13ErrorInfoBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm5Error6setPtrEPNS_13ErrorInfoBaseE")
  //</editor-fold>
  private void setPtr(ErrorInfoBase /*P*/ EI) {
    PayloadAndCheckedBit.setPointer(EI);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Error::getChecked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 252,
   FQN="llvm::Error::getChecked", NM="_ZNK4llvm5Error10getCheckedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm5Error10getCheckedEv")
  //</editor-fold>
  private boolean getChecked() /*const*/ {
    return (PayloadAndCheckedBit.getInt() != 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Error::setChecked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 260,
   FQN="llvm::Error::setChecked", NM="_ZN4llvm5Error10setCheckedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm5Error10setCheckedEb")
  //</editor-fold>
  private void setChecked(boolean V) {
    PayloadAndCheckedBit.setInt((V ? 1 : 0));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Error::takePayload">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 266,
   FQN="llvm::Error::takePayload", NM="_ZN4llvm5Error11takePayloadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm5Error11takePayloadEv")
  //</editor-fold>
  /*friend*/public/*private*/ std.unique_ptr<ErrorInfoBase> takePayload() {
    std.unique_ptr<ErrorInfoBase> Tmp = null;
    try {
      Tmp/*J*/= new std.unique_ptr<ErrorInfoBase>(getPtr());
      setPtr((ErrorInfoBase /*P*/ )null);
      setChecked(true);
      return new std.unique_ptr<ErrorInfoBase>(JD$Move.INSTANCE, Tmp);
    } finally {
      if (Tmp != null) { Tmp.$destroy(); }
    }
  }

  private PointerIntPair<ErrorInfoBase /*P*/ > PayloadAndCheckedBit;
  
  @Override public String toString() {
    return "" + "PayloadAndCheckedBit=" + PayloadAndCheckedBit; // NOI18N
  }
}
