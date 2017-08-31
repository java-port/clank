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

package org.llvm.ir;

import org.clank.support.*;
import org.llvm.llvmc.*;
import org.llvm.ir.*;


/// \brief This is the base abstract class for diagnostic reporting in
/// the backend.
/// The print method must be overloaded by the subclasses to print a
/// user-friendly message in the client of the backend (let us call it a
/// frontend).
//<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 87,
 FQN="llvm::DiagnosticInfo", NM="_ZN4llvm14DiagnosticInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm14DiagnosticInfoE")
//</editor-fold>
public abstract class DiagnosticInfo implements Destructors.ClassWithDestructor, LLVMOpaqueDiagnosticInfo {
/*private:*/
  /// Kind defines the kind of report this is about.
  private /*const*/int Kind;
  /// Severity gives the severity of the diagnostic.
  private /*const*/ DiagnosticSeverity Severity;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfo::DiagnosticInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 95,
   FQN="llvm::DiagnosticInfo::DiagnosticInfo", NM="_ZN4llvm14DiagnosticInfoC1EiNS_18DiagnosticSeverityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm14DiagnosticInfoC1EiNS_18DiagnosticSeverityE")
  //</editor-fold>
  public DiagnosticInfo(/* DiagnosticKind */ int Kind, DiagnosticSeverity Severity) {
    // : Kind(Kind), Severity(Severity)
    //START JInit
    this.Kind = Kind;
    this.Severity = Severity;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfo::~DiagnosticInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 98,
   FQN="llvm::DiagnosticInfo::~DiagnosticInfo", NM="_ZN4llvm14DiagnosticInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm14DiagnosticInfoD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
  }


  /* DiagnosticKind */
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfo::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 100,
   FQN="llvm::DiagnosticInfo::getKind", NM="_ZNK4llvm14DiagnosticInfo7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm14DiagnosticInfo7getKindEv")
  //</editor-fold>
  public int getKind() /*const*/ {
    return Kind;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfo::getSeverity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 101,
   FQN="llvm::DiagnosticInfo::getSeverity", NM="_ZNK4llvm14DiagnosticInfo11getSeverityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm14DiagnosticInfo11getSeverityEv")
  //</editor-fold>
  public DiagnosticSeverity getSeverity() /*const*/ {
    return Severity;
  }


  /// Print using the given \p DP a user-friendly message.
  /// This is the default message that will be printed to the user.
  /// It is used when the frontend does not directly take advantage
  /// of the information contained in fields of the subclasses.
  /// The printed message must not end with '.' nor start with a severity
  /// keyword.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfo::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 109,
   FQN="llvm::DiagnosticInfo::print", NM="_ZNK4llvm14DiagnosticInfo5printERNS_17DiagnosticPrinterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm14DiagnosticInfo5printERNS_17DiagnosticPrinterE")
  //</editor-fold>
  public abstract /*virtual*/ void print(final DiagnosticPrinter /*&*/ DP) /*const*//* = 0*/;


  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", Severity=" + Severity; // NOI18N
  }
}