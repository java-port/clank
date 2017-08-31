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

package org.clang.staticanalyzer.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import static org.clang.basic.BasicClangGlobals.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangDiagPathDiagConsumer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 89,
 FQN="(anonymous namespace)::ClangDiagPathDiagConsumer", NM="_ZN12_GLOBAL__N_125ClangDiagPathDiagConsumerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_125ClangDiagPathDiagConsumerE")
//</editor-fold>
public class ClangDiagPathDiagConsumer extends /*public*/ PathDiagnosticConsumer implements Destructors.ClassWithDestructor {
  private final DiagnosticsEngine /*&*/ Diag;
  private boolean IncludePath;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangDiagPathDiagConsumer::ClangDiagPathDiagConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 93,
   FQN="(anonymous namespace)::ClangDiagPathDiagConsumer::ClangDiagPathDiagConsumer", NM="_ZN12_GLOBAL__N_125ClangDiagPathDiagConsumerC1ERN5clang17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_125ClangDiagPathDiagConsumerC1ERN5clang17DiagnosticsEngineE")
  //</editor-fold>
  public ClangDiagPathDiagConsumer(final DiagnosticsEngine /*&*/ Diag) {
    // : PathDiagnosticConsumer(), Diag(Diag), IncludePath(false) 
    //START JInit
    super();
    this./*&*/Diag=/*&*/Diag;
    this.IncludePath = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangDiagPathDiagConsumer::~ClangDiagPathDiagConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 95,
   FQN="(anonymous namespace)::ClangDiagPathDiagConsumer::~ClangDiagPathDiagConsumer", NM="_ZN12_GLOBAL__N_125ClangDiagPathDiagConsumerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_125ClangDiagPathDiagConsumerD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangDiagPathDiagConsumer::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 96,
   FQN="(anonymous namespace)::ClangDiagPathDiagConsumer::getName", NM="_ZNK12_GLOBAL__N_125ClangDiagPathDiagConsumer7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK12_GLOBAL__N_125ClangDiagPathDiagConsumer7getNameEv")
  //</editor-fold>
  @Override public StringRef getName() /*const*//* override*/ {
    return new StringRef(/*KEEP_STR*/"ClangDiags");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangDiagPathDiagConsumer::supportsLogicalOpControlFlow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 98,
   FQN="(anonymous namespace)::ClangDiagPathDiagConsumer::supportsLogicalOpControlFlow", NM="_ZNK12_GLOBAL__N_125ClangDiagPathDiagConsumer28supportsLogicalOpControlFlowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK12_GLOBAL__N_125ClangDiagPathDiagConsumer28supportsLogicalOpControlFlowEv")
  //</editor-fold>
  @Override public boolean supportsLogicalOpControlFlow() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangDiagPathDiagConsumer::supportsCrossFileDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 99,
   FQN="(anonymous namespace)::ClangDiagPathDiagConsumer::supportsCrossFileDiagnostics", NM="_ZNK12_GLOBAL__N_125ClangDiagPathDiagConsumer28supportsCrossFileDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK12_GLOBAL__N_125ClangDiagPathDiagConsumer28supportsCrossFileDiagnosticsEv")
  //</editor-fold>
  @Override public boolean supportsCrossFileDiagnostics() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangDiagPathDiagConsumer::getGenerationScheme">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 101,
   FQN="(anonymous namespace)::ClangDiagPathDiagConsumer::getGenerationScheme", NM="_ZNK12_GLOBAL__N_125ClangDiagPathDiagConsumer19getGenerationSchemeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK12_GLOBAL__N_125ClangDiagPathDiagConsumer19getGenerationSchemeEv")
  //</editor-fold>
  @Override public PathDiagnosticConsumer.PathGenerationScheme getGenerationScheme() /*const*//* override*/ {
    return IncludePath ? PathGenerationScheme.Minimal : PathGenerationScheme.None;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangDiagPathDiagConsumer::enablePaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 105,
   FQN="(anonymous namespace)::ClangDiagPathDiagConsumer::enablePaths", NM="_ZN12_GLOBAL__N_125ClangDiagPathDiagConsumer11enablePathsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_125ClangDiagPathDiagConsumer11enablePathsEv")
  //</editor-fold>
  public void enablePaths() {
    IncludePath = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangDiagPathDiagConsumer::FlushDiagnosticsImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 109,
   FQN="(anonymous namespace)::ClangDiagPathDiagConsumer::FlushDiagnosticsImpl", NM="_ZN12_GLOBAL__N_125ClangDiagPathDiagConsumer20FlushDiagnosticsImplERSt6vectorIPKN5clang4ento14PathDiagnosticESaIS6_EEPNS3_22PathDiagnosticConsumer9FilesMadeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN12_GLOBAL__N_125ClangDiagPathDiagConsumer20FlushDiagnosticsImplERSt6vectorIPKN5clang4ento14PathDiagnosticESaIS6_EEPNS3_22PathDiagnosticConsumer9FilesMadeE")
  //</editor-fold>
  @Override public void FlushDiagnosticsImpl(final std.vector</*const*/ PathDiagnostic /*P*/ > /*&*/ Diags, 
                      PathDiagnosticConsumer.FilesMade /*P*/ filesMade)/* override*/ {
    /*uint*/int WarnID = Diag.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Warning, /*KEEP_STR*/"%0");
    /*uint*/int NoteID = Diag.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Note, /*KEEP_STR*/"%0");

    for (std.vector.iterator</*const*/ PathDiagnostic /*P*/> I = Diags.begin(), 
        E = Diags.end(); $noteq___normal_iterator$C(I, E); I.$preInc()) {
      PathPieces FlatPath = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*const*/ PathDiagnostic /*P*/ PD = I.$star();
        SourceLocation WarnLoc = new SourceLocation(JD$Move.INSTANCE, PD.getLocation().asLocation());
        $c$.clean($out_DiagnosticBuilder$C_ArrayRef$SourceRange($out_DiagnosticBuilder$C_StringRef($c$.track(Diag.Report(/*NO_COPY*/WarnLoc, WarnID)), PD.getShortDescription()), 
            PD._path.back$Const().$arrow().getRanges()));
        if (!IncludePath) {
          continue;
        }
        
        FlatPath = PD._path.flatten(/*ShouldFlattenMacros=*/ true);
        for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> PI = new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(FlatPath.begin()), 
            PE = new std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>>(FlatPath.end());
             PI.$noteq(PE); PI.$preInc()) {
          SourceLocation NoteLoc = new SourceLocation(JD$Move.INSTANCE, (PI.$star()).$arrow().getLocation().asLocation());
          $c$.clean($out_DiagnosticBuilder$C_ArrayRef$SourceRange($out_DiagnosticBuilder$C_StringRef($c$.track(Diag.Report(/*NO_COPY*/NoteLoc, NoteID)), (PI.$star()).$arrow().getString()), 
              (PI.$star()).$arrow().getRanges()));
        }
      } finally {
        if (FlatPath != null) { FlatPath.$destroy(); }
        $c$.$destroy();
      }
    }
  }

  
  @Override public String toString() {
    return "" + "Diag=" + "[DiagnosticsEngine]" // NOI18N
              + ", IncludePath=" + IncludePath // NOI18N
              + super.toString(); // NOI18N
  }
}
