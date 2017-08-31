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


/// This class wraps a std::error_code in a Error.
///
/// This is useful if you're writing an interface that returns a Error
/// (or Expected) and you want to call code that still returns
/// std::error_codes.
//<editor-fold defaultstate="collapsed" desc="llvm::ECError">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 831,
 FQN="llvm::ECError", NM="_ZN4llvm7ECErrorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm7ECErrorE")
//</editor-fold>
public class ECError extends /*public*/ ErrorInfo<ECError> implements Destructors.ClassWithDestructor {
  /*friend Error errorCodeToError(std::error_code)*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ECError::setErrorCode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 834,
   FQN="llvm::ECError::setErrorCode", NM="_ZN4llvm7ECError12setErrorCodeESt10error_code",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm7ECError12setErrorCodeESt10error_code")
  //</editor-fold>
  public void setErrorCode(std.error_code EC) {
    this.EC.$assign(EC);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ECError::convertToErrorCode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 835,
   FQN="llvm::ECError::convertToErrorCode", NM="_ZNK4llvm7ECError18convertToErrorCodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm7ECError18convertToErrorCodeEv")
  //</editor-fold>
  @Override public std.error_code convertToErrorCode() /*const*//* override*/ {
    return new std.error_code(EC);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ECError::log">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 836,
   FQN="llvm::ECError::log", NM="_ZNK4llvm7ECError3logERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm7ECError3logERNS_11raw_ostreamE")
  //</editor-fold>
  @Override public void log(final raw_ostream /*&*/ OS) /*const*//* override*/ {
    OS.$out(EC.message());
  }

  
  // Used by ErrorInfo::classID.
  public static /*char*/byte ID;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ECError::ECError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 842,
   FQN="llvm::ECError::ECError", NM="_ZN4llvm7ECErrorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm7ECErrorC1Ev")
  //</editor-fold>
  protected ECError() {
    // : ErrorInfo<ECError>(), EC()/* = default*/ 
    //START JInit
    super();
    this.EC = new std.error_code();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ECError::ECError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 843,
   FQN="llvm::ECError::ECError", NM="_ZN4llvm7ECErrorC1ESt10error_code",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm7ECErrorC1ESt10error_code")
  //</editor-fold>
  protected ECError(std.error_code EC) {
    // : ErrorInfo<ECError>(), EC(EC) 
    //START JInit
    super();
    this.EC = new std.error_code(EC);
    //END JInit
  }

  protected std.error_code EC;
  //<editor-fold defaultstate="collapsed" desc="llvm::ECError::~ECError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 831,
   FQN="llvm::ECError::~ECError", NM="_ZN4llvm7ECErrorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm7ECErrorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ECError::ECError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 831,
   FQN="llvm::ECError::ECError", NM="_ZN4llvm7ECErrorC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm7ECErrorC1EOS0_")
  //</editor-fold>
  public /*inline*/ ECError(JD$Move _dparam, final ECError /*&&*/$Prm0) {
    // : ErrorInfo<ECError>(static_cast<ECError &&>()), EC(static_cast<ECError &&>().EC) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    this.EC = new std.error_code(JD$Move.INSTANCE, $Prm0.EC);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "EC=" + EC // NOI18N
              + super.toString(); // NOI18N
  }
}
