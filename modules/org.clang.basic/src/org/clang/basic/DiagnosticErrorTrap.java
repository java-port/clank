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

package org.clang.basic;

import org.clank.support.*;
import org.clang.basic.*;


/// \brief RAII class that determines when any errors have occurred
/// between the time the instance was created and the time it was
/// queried.
//<editor-fold defaultstate="collapsed" desc="clang::DiagnosticErrorTrap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 829,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 822,
 FQN="clang::DiagnosticErrorTrap", NM="_ZN5clang19DiagnosticErrorTrapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang19DiagnosticErrorTrapE")
//</editor-fold>
public class DiagnosticErrorTrap {
  private DiagnosticsEngine /*&*/ Diag;
  private /*uint*/int NumErrors;
  private /*uint*/int NumUnrecoverableErrors;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticErrorTrap::DiagnosticErrorTrap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 835,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 828,
   FQN="clang::DiagnosticErrorTrap::DiagnosticErrorTrap", NM="_ZN5clang19DiagnosticErrorTrapC1ERNS_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang19DiagnosticErrorTrapC1ERNS_17DiagnosticsEngineE")
  //</editor-fold>
  public /*explicit*/ DiagnosticErrorTrap(DiagnosticsEngine /*&*/ Diag) {
    /* : Diag(Diag)*/ 
    //START JInit
    this.Diag = Diag;
    //END JInit
    reset();
  }

  
  /// \brief Determine whether any errors have occurred since this
  /// object instance was created.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticErrorTrap::hasErrorOccurred">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 840,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 833,
   FQN="clang::DiagnosticErrorTrap::hasErrorOccurred", NM="_ZNK5clang19DiagnosticErrorTrap16hasErrorOccurredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang19DiagnosticErrorTrap16hasErrorOccurredEv")
  //</editor-fold>
  public boolean hasErrorOccurred() /*const*/ {
    return Diag.TrapNumErrorsOccurred > NumErrors;
  }

  
  /// \brief Determine whether any unrecoverable errors have occurred since this
  /// object instance was created.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticErrorTrap::hasUnrecoverableErrorOccurred">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 846,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 839,
   FQN="clang::DiagnosticErrorTrap::hasUnrecoverableErrorOccurred", NM="_ZNK5clang19DiagnosticErrorTrap29hasUnrecoverableErrorOccurredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang19DiagnosticErrorTrap29hasUnrecoverableErrorOccurredEv")
  //</editor-fold>
  public boolean hasUnrecoverableErrorOccurred() /*const*/ {
    return Diag.TrapNumUnrecoverableErrorsOccurred > NumUnrecoverableErrors;
  }

  
  /// \brief Set to initial state of "no errors occurred".
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticErrorTrap::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 851,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 844,
   FQN="clang::DiagnosticErrorTrap::reset", NM="_ZN5clang19DiagnosticErrorTrap5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang19DiagnosticErrorTrap5resetEv")
  //</editor-fold>
  public void reset() {
    NumErrors = Diag.TrapNumErrorsOccurred;
    NumUnrecoverableErrors = Diag.TrapNumUnrecoverableErrorsOccurred;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticErrorTrap::DiagnosticErrorTrap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 829,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 822,
   FQN="clang::DiagnosticErrorTrap::DiagnosticErrorTrap", NM="_ZN5clang19DiagnosticErrorTrapC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang19DiagnosticErrorTrapC1ERKS0_")
  //</editor-fold>
  public /*inline*/ DiagnosticErrorTrap(/*const*/ DiagnosticErrorTrap /*&*/ $Prm0) {
    /* : Diag(.Diag), NumErrors(.NumErrors), NumUnrecoverableErrors(.NumUnrecoverableErrors)*/ 
    //START JInit
    this./*&*/Diag=/*&*/$Prm0.Diag;
    this.NumErrors = $Prm0.NumErrors;
    this.NumUnrecoverableErrors = $Prm0.NumUnrecoverableErrors;
    //END JInit
  }  
}
