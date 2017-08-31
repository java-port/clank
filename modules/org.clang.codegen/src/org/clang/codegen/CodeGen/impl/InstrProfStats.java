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

package org.clang.codegen.CodeGen.impl;

import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;


/// This class records statistics on instrumentation based profiling.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::InstrProfStats">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 182,
 FQN="clang::CodeGen::InstrProfStats", NM="_ZN5clang7CodeGen14InstrProfStatsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen14InstrProfStatsE")
//</editor-fold>
public class InstrProfStats {
  private /*uint32_t*/int VisitedInMainFile;
  private /*uint32_t*/int MissingInMainFile;
  private /*uint32_t*/int Visited;
  private /*uint32_t*/int Missing;
  private /*uint32_t*/int Mismatched;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::InstrProfStats::InstrProfStats">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 190,
   FQN="clang::CodeGen::InstrProfStats::InstrProfStats", NM="_ZN5clang7CodeGen14InstrProfStatsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen14InstrProfStatsC1Ev")
  //</editor-fold>
  public InstrProfStats() {
    // : VisitedInMainFile(0), MissingInMainFile(0), Visited(0), Missing(0), Mismatched(0) 
    //START JInit
    this.VisitedInMainFile = 0;
    this.MissingInMainFile = 0;
    this.Visited = 0;
    this.Missing = 0;
    this.Mismatched = 0;
    //END JInit
  }

  /// Record that we've visited a function and whether or not that function was
  /// in the main source file.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::InstrProfStats::addVisited">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 195,
   FQN="clang::CodeGen::InstrProfStats::addVisited", NM="_ZN5clang7CodeGen14InstrProfStats10addVisitedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen14InstrProfStats10addVisitedEb")
  //</editor-fold>
  public void addVisited(boolean MainFile) {
    if (MainFile) {
      ++VisitedInMainFile;
    }
    ++Visited;
  }

  /// Record that a function we've visited has no profile data.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::InstrProfStats::addMissing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 201,
   FQN="clang::CodeGen::InstrProfStats::addMissing", NM="_ZN5clang7CodeGen14InstrProfStats10addMissingEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen14InstrProfStats10addMissingEb")
  //</editor-fold>
  public void addMissing(boolean MainFile) {
    if (MainFile) {
      ++MissingInMainFile;
    }
    ++Missing;
  }

  /// Record that a function we've visited has mismatched profile data.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::InstrProfStats::addMismatched">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 207,
   FQN="clang::CodeGen::InstrProfStats::addMismatched", NM="_ZN5clang7CodeGen14InstrProfStats13addMismatchedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen14InstrProfStats13addMismatchedEb")
  //</editor-fold>
  public void addMismatched(boolean MainFile) {
    ++Mismatched;
  }

  /// Whether or not the stats we've gathered indicate any potential problems.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::InstrProfStats::hasDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 209,
   FQN="clang::CodeGen::InstrProfStats::hasDiagnostics", NM="_ZN5clang7CodeGen14InstrProfStats14hasDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen14InstrProfStats14hasDiagnosticsEv")
  //</editor-fold>
  public boolean hasDiagnostics() {
    return (Missing != 0) || (Mismatched != 0);
  }

  /// Report potential problems we've found to \c Diags.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::InstrProfStats::reportDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 360,
   FQN="clang::CodeGen::InstrProfStats::reportDiagnostics", NM="_ZN5clang7CodeGen14InstrProfStats17reportDiagnosticsERNS_17DiagnosticsEngineEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen14InstrProfStats17reportDiagnosticsERNS_17DiagnosticsEngineEN4llvm9StringRefE")
  //</editor-fold>
  public void reportDiagnostics(final DiagnosticsEngine /*&*/ Diags, 
                   StringRef MainFile) {
    if (!hasDiagnostics()) {
      return;
    }
    if ($greater_uint(VisitedInMainFile, 0) && VisitedInMainFile == MissingInMainFile) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        if (MainFile.empty()) {
          MainFile.$assignMove(/*STRINGREF_STR*/"<stdin>");
        }
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.warn_profile_data_unprofiled)), /*NO_COPY*/MainFile));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($c$.track(Diags.Report(diag.warn_profile_data_out_of_date)), Visited), Missing), 
            Mismatched));
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  @Override public String toString() {
    return "" + "VisitedInMainFile=" + VisitedInMainFile // NOI18N
              + ", MissingInMainFile=" + MissingInMainFile // NOI18N
              + ", Visited=" + Visited // NOI18N
              + ", Missing=" + Missing // NOI18N
              + ", Mismatched=" + Mismatched; // NOI18N
  }
}
