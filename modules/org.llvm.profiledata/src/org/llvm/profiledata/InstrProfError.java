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

package org.llvm.profiledata;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.support.Error;

//<editor-fold defaultstate="collapsed" desc="llvm::InstrProfError">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 303,
 FQN="llvm::InstrProfError", NM="_ZN4llvm14InstrProfErrorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm14InstrProfErrorE")
//</editor-fold>
public class InstrProfError extends /*public*/ ErrorInfo<InstrProfError> implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfError::InstrProfError">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 305,
   FQN="llvm::InstrProfError::InstrProfError", NM="_ZN4llvm14InstrProfErrorC1ENS_15instrprof_errorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm14InstrProfErrorC1ENS_15instrprof_errorE")
  //</editor-fold>
  public InstrProfError(instrprof_error Err) {
    // : ErrorInfo<InstrProfError>(), Err(Err) 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfError::message">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 120,
   FQN="llvm::InstrProfError::message", NM="_ZNK4llvm14InstrProfError7messageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZNK4llvm14InstrProfError7messageEv")
  //</editor-fold>
  @Override public std.string message() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfError::log">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 311,
   FQN="llvm::InstrProfError::log", NM="_ZNK4llvm14InstrProfError3logERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZNK4llvm14InstrProfError3logERNS_11raw_ostreamE")
  //</editor-fold>
  @Override public void log(final raw_ostream /*&*/ OS) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfError::convertToErrorCode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 313,
   FQN="llvm::InstrProfError::convertToErrorCode", NM="_ZNK4llvm14InstrProfError18convertToErrorCodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZNK4llvm14InstrProfError18convertToErrorCodeEv")
  //</editor-fold>
  @Override public std.error_code convertToErrorCode() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfError::get">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 317,
   FQN="llvm::InstrProfError::get", NM="_ZNK4llvm14InstrProfError3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZNK4llvm14InstrProfError3getEv")
  //</editor-fold>
  public instrprof_error get() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Consume an Error and return the raw enum value contained within it. The
  /// Error must either be a success value, or contain a single InstrProfError.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfError::take">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 321,
   FQN="llvm::InstrProfError::take", NM="_ZN4llvm14InstrProfError4takeENS_5ErrorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm14InstrProfError4takeENS_5ErrorE")
  //</editor-fold>
  public static instrprof_error take(Error E) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  public static /*char*/byte ID = 0;
/*private:*/
  private instrprof_error Err;
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfError::~InstrProfError">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 303,
   FQN="llvm::InstrProfError::~InstrProfError", NM="_ZN4llvm14InstrProfErrorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm14InstrProfErrorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Err=" + Err // NOI18N
              + super.toString(); // NOI18N
  }
}
