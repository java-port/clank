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

import org.clang.basic.*;
import org.clang.basic.spi.PreprocessorImplementation;
import org.clank.support.*;


/// \brief Abstract interface, implemented by clients of the front-end, which
/// formats and prints fully processed diagnostics.
//<editor-fold defaultstate="collapsed" desc="clang::DiagnosticConsumer">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1314,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1307,
 FQN="clang::DiagnosticConsumer", NM="_ZN5clang18DiagnosticConsumerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang18DiagnosticConsumerE")
//</editor-fold>
public class DiagnosticConsumer implements Destructors.ClassWithDestructor {
/*protected:*/
  protected /*uint*/int NumWarnings; ///< Number of warnings reported
  protected /*uint*/int NumErrors; ///< Number of errors reported
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticConsumer::DiagnosticConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1320,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1313,
   FQN="clang::DiagnosticConsumer::DiagnosticConsumer", NM="_ZN5clang18DiagnosticConsumerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang18DiagnosticConsumerC1Ev")
  //</editor-fold>
  public DiagnosticConsumer() {
    /* : NumWarnings(0), NumErrors(0)*/ 
    //START JInit
    this.NumWarnings = 0;
    this.NumErrors = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticConsumer::getNumErrors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1322,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1315,
   FQN="clang::DiagnosticConsumer::getNumErrors", NM="_ZNK5clang18DiagnosticConsumer12getNumErrorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang18DiagnosticConsumer12getNumErrorsEv")
  //</editor-fold>
  public /*uint*/int getNumErrors() /*const*/ {
    return NumErrors;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticConsumer::getNumWarnings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1323,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1316,
   FQN="clang::DiagnosticConsumer::getNumWarnings", NM="_ZNK5clang18DiagnosticConsumer14getNumWarningsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang18DiagnosticConsumer14getNumWarningsEv")
  //</editor-fold>
  public /*uint*/int getNumWarnings() /*const*/ {
    return NumWarnings;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticConsumer::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1324,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1317,
   FQN="clang::DiagnosticConsumer::clear", NM="_ZN5clang18DiagnosticConsumer5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang18DiagnosticConsumer5clearEv")
  //</editor-fold>
  public /*virtual*/ void clear() {
    NumWarnings = NumErrors = 0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticConsumer::~DiagnosticConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 397,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 396,
   FQN="clang::DiagnosticConsumer::~DiagnosticConsumer", NM="_ZN5clang18DiagnosticConsumerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang18DiagnosticConsumerD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  /// \brief Callback to inform the diagnostic client that processing
  /// of a source file is beginning.
  ///
  /// Note that diagnostics may be emitted outside the processing of a source
  /// file, for example during the parsing of command line options. However,
  /// diagnostics with source range information are required to only be emitted
  /// in between BeginSourceFile() and EndSourceFile().
  ///
  /// \param LangOpts The language options for the source file being processed.
  /// \param PP The preprocessor object being used for the source; this is 
  /// optional, e.g., it may not be present when processing AST source files.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticConsumer::BeginSourceFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1339,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1332,
   FQN="clang::DiagnosticConsumer::BeginSourceFile", NM="_ZN5clang18DiagnosticConsumer15BeginSourceFileERKNS_11LangOptionsEPKNS_12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang18DiagnosticConsumer15BeginSourceFileERKNS_11LangOptionsEPKNS_12PreprocessorE")
  //</editor-fold>
  public /*virtual*/ void BeginSourceFile(/*const*/LangOptions /*&*/ LangOpts) {
    BeginSourceFile(LangOpts, (/*const*/PreprocessorImplementation /*P*/ )null);
  }
  public /*virtual*/ void BeginSourceFile(/*const*//*const*/LangOptions /*&*/ LangOpts, /*const*/PreprocessorImplementation /*P*/ PP) {
  }

  
  /// \brief Callback to inform the diagnostic client that processing
  /// of a source file has ended.
  ///
  /// The diagnostic client should assume that any objects made available via
  /// BeginSourceFile() are inaccessible.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticConsumer::EndSourceFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1347,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1340,
   FQN="clang::DiagnosticConsumer::EndSourceFile", NM="_ZN5clang18DiagnosticConsumer13EndSourceFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang18DiagnosticConsumer13EndSourceFileEv")
  //</editor-fold>
  public /*virtual*/ void EndSourceFile() {
  }

  
  /// \brief Callback to inform the diagnostic client that processing of all
  /// source files has ended.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticConsumer::finish">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1351,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1344,
   FQN="clang::DiagnosticConsumer::finish", NM="_ZN5clang18DiagnosticConsumer6finishEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang18DiagnosticConsumer6finishEv")
  //</editor-fold>
  public /*virtual*/ void finish() {
  }

  
  /// \brief Indicates whether the diagnostics handled by this
  /// DiagnosticConsumer should be included in the number of diagnostics
  /// reported by DiagnosticsEngine.
  ///
  /// The default implementation returns true.
  
  /// IncludeInDiagnosticCounts - This method (whose default implementation
  ///  returns true) indicates whether the diagnostics handled by this
  ///  DiagnosticConsumer should be included in the number of diagnostics
  ///  reported by DiagnosticsEngine.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticConsumer::IncludeInDiagnosticCounts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 981,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 980,
   FQN="clang::DiagnosticConsumer::IncludeInDiagnosticCounts", NM="_ZNK5clang18DiagnosticConsumer25IncludeInDiagnosticCountsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang18DiagnosticConsumer25IncludeInDiagnosticCountsEv")
  //</editor-fold>
  public boolean IncludeInDiagnosticCounts() /*const*/ {
    return true;
  }

  
  /// \brief Handle this diagnostic, reporting it to the user or
  /// capturing it to a log as needed.
  ///
  /// The default implementation just keeps track of the total number of
  /// warnings and errors.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticConsumer::HandleDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 399,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 398,
   FQN="clang::DiagnosticConsumer::HandleDiagnostic", NM="_ZN5clang18DiagnosticConsumer16HandleDiagnosticENS_17DiagnosticsEngine5LevelERKNS_10DiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang18DiagnosticConsumer16HandleDiagnosticENS_17DiagnosticsEngine5LevelERKNS_10DiagnosticE")
  //</editor-fold>
  public void HandleDiagnostic(DiagnosticsEngine.Level DiagLevel, /*const*/Diagnostic /*&*/ Info) {
    if (!IncludeInDiagnosticCounts()) {
      return;
    }
    if (DiagLevel == DiagnosticsEngine.Level.Warning) {
      ++NumWarnings;
    } else if (DiagLevel.getValue() >= DiagnosticsEngine.Level.Error.getValue()) {
      ++NumErrors;
    }
  }

}
