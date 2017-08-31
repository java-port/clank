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
import org.llvm.support.*;


/// Base class for error info classes. Do not extend this directly: Extend
/// the ErrorInfo template subclass instead.
//<editor-fold defaultstate="collapsed" desc="llvm::ErrorInfoBase">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 33,
 FQN="llvm::ErrorInfoBase", NM="_ZN4llvm13ErrorInfoBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm13ErrorInfoBaseE")
//</editor-fold>
public abstract class ErrorInfoBase implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorInfoBase::~ErrorInfoBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 35,
   FQN="llvm::ErrorInfoBase::~ErrorInfoBase", NM="_ZN4llvm13ErrorInfoBaseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm13ErrorInfoBaseD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Print an error message to an output stream.
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorInfoBase::log">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 38,
   FQN="llvm::ErrorInfoBase::log", NM="_ZNK4llvm13ErrorInfoBase3logERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm13ErrorInfoBase3logERNS_11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void log(raw_ostream /*&*/ OS) /*const*//* = 0*/;

  
  /// Return the error message as a string.
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorInfoBase::message">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 41,
   FQN="llvm::ErrorInfoBase::message", NM="_ZNK4llvm13ErrorInfoBase7messageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm13ErrorInfoBase7messageEv")
  //</editor-fold>
  public /*virtual*/ std.string message() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Convert this error to a std::error_code.
  ///
  /// This is a temporary crutch to enable interaction with code still
  /// using std::error_code. It will be removed in the future.
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorInfoBase::convertToErrorCode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 52,
   FQN="llvm::ErrorInfoBase::convertToErrorCode", NM="_ZNK4llvm13ErrorInfoBase18convertToErrorCodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm13ErrorInfoBase18convertToErrorCodeEv")
  //</editor-fold>
  public abstract /*virtual*/ std.error_code convertToErrorCode() /*const*//* = 0*/;

  
  // Check whether this instance is a subclass of the class identified by
  // ClassID.
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorInfoBase::isA">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 56,
   FQN="llvm::ErrorInfoBase::isA", NM="_ZNK4llvm13ErrorInfoBase3isAEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm13ErrorInfoBase3isAEPKv")
  //</editor-fold>
  public /*virtual*/ boolean isA(/*const*/Object/*void P*//*const*/ ClassID) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Check whether this instance is a subclass of ErrorInfoT.
  /*template <typename ErrorInfoT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorInfoBase::isA">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 61,
   FQN="llvm::ErrorInfoBase::isA", NM="Tpl__ZNK4llvm13ErrorInfoBase3isAEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZNK4llvm13ErrorInfoBase3isAEv")
  //</editor-fold>
  public </*typename*/ ErrorInfoT> boolean isA() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Returns the class ID for this type.
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorInfoBase::classID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 66,
   FQN="llvm::ErrorInfoBase::classID", NM="_ZN4llvm13ErrorInfoBase7classIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm13ErrorInfoBase7classIDEv")
  //</editor-fold>
  public static /*const*/Object/*void P*/ classID() {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorInfoBase::anchor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/Error.cpp", line = 51,
   FQN="llvm::ErrorInfoBase::anchor", NM="_ZN4llvm13ErrorInfoBase6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm13ErrorInfoBase6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  private static /*char*/byte ID = 0;
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorInfoBase::ErrorInfoBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 33,
   FQN="llvm::ErrorInfoBase::ErrorInfoBase", NM="_ZN4llvm13ErrorInfoBaseC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm13ErrorInfoBaseC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ErrorInfoBase(/*const*/ ErrorInfoBase /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorInfoBase::ErrorInfoBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 33,
   FQN="llvm::ErrorInfoBase::ErrorInfoBase", NM="_ZN4llvm13ErrorInfoBaseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm13ErrorInfoBaseC1Ev")
  //</editor-fold>
  public /*inline*/ ErrorInfoBase() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
