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

package org.clang.serialization;

import org.clank.java.*;
import org.clank.support.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.basic.target.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.lex.*;


/// \brief Abstract interface for callback invocations by the ASTReader.
///
/// While reading an AST file, the ASTReader will call the methods of the
/// listener to pass on specific information. Some of the listener methods can
/// return true to indicate to the ASTReader that the information (and
/// consequently the AST file) is invalid.
//<editor-fold defaultstate="collapsed" desc="clang::ASTReaderListener">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 104,
 FQN="clang::ASTReaderListener", NM="_ZN5clang17ASTReaderListenerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang17ASTReaderListenerE")
//</editor-fold>
public class ASTReaderListener implements Destructors.ClassWithDestructor {
/*public:*/
  
  //===----------------------------------------------------------------------===//
  // PCH validator implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReaderListener::~ASTReaderListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 174,
   FQN="clang::ASTReaderListener::~ASTReaderListener", NM="_ZN5clang17ASTReaderListenerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang17ASTReaderListenerD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  /// \brief Receives the full Clang version information.
  ///
  /// \returns true to indicate that the version is invalid. Subclasses should
  /// generally defer to this implementation.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReaderListener::ReadFullVersionInformation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 112,
   FQN="clang::ASTReaderListener::ReadFullVersionInformation", NM="_ZN5clang17ASTReaderListener26ReadFullVersionInformationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang17ASTReaderListener26ReadFullVersionInformationEN4llvm9StringRefE")
  //</editor-fold>
  public /*virtual*/ boolean ReadFullVersionInformation(StringRef FullVersion) {
    return $noteq_StringRef(/*NO_COPY*/FullVersion, new StringRef(getClangFullRepositoryVersion()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReaderListener::ReadModuleName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 116,
   FQN="clang::ASTReaderListener::ReadModuleName", NM="_ZN5clang17ASTReaderListener14ReadModuleNameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang17ASTReaderListener14ReadModuleNameEN4llvm9StringRefE")
  //</editor-fold>
  public /*virtual*/ void ReadModuleName(StringRef ModuleName) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReaderListener::ReadModuleMapFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 117,
   FQN="clang::ASTReaderListener::ReadModuleMapFile", NM="_ZN5clang17ASTReaderListener17ReadModuleMapFileEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang17ASTReaderListener17ReadModuleMapFileEN4llvm9StringRefE")
  //</editor-fold>
  public /*virtual*/ void ReadModuleMapFile(StringRef ModuleMapPath) {
  }

  
  /// \brief Receives the language options.
  ///
  /// \returns true to indicate the options are invalid or false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReaderListener::ReadLanguageOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 122,
   FQN="clang::ASTReaderListener::ReadLanguageOptions", NM="_ZN5clang17ASTReaderListener19ReadLanguageOptionsERKNS_11LangOptionsEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang17ASTReaderListener19ReadLanguageOptionsERKNS_11LangOptionsEbb")
  //</editor-fold>
  public /*virtual*/ boolean ReadLanguageOptions(final /*const*/ LangOptions /*&*/ LangOpts, 
                     boolean Complain, 
                     boolean AllowCompatibleDifferences) {
    return false;
  }

  
  /// \brief Receives the target options.
  ///
  /// \returns true to indicate the target options are invalid, or false
  /// otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReaderListener::ReadTargetOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 132,
   FQN="clang::ASTReaderListener::ReadTargetOptions", NM="_ZN5clang17ASTReaderListener17ReadTargetOptionsERKNS_13TargetOptionsEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang17ASTReaderListener17ReadTargetOptionsERKNS_13TargetOptionsEbb")
  //</editor-fold>
  public /*virtual*/ boolean ReadTargetOptions(final /*const*/ TargetOptions /*&*/ TargetOpts, boolean Complain, 
                   boolean AllowCompatibleDifferences) {
    return false;
  }

  
  /// \brief Receives the diagnostic options.
  ///
  /// \returns true to indicate the diagnostic options are invalid, or false
  /// otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReaderListener::ReadDiagnosticOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 141,
   FQN="clang::ASTReaderListener::ReadDiagnosticOptions", NM="_ZN5clang17ASTReaderListener21ReadDiagnosticOptionsEN4llvm18IntrusiveRefCntPtrINS_17DiagnosticOptionsEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang17ASTReaderListener21ReadDiagnosticOptionsEN4llvm18IntrusiveRefCntPtrINS_17DiagnosticOptionsEEEb")
  //</editor-fold>
  public /*virtual*/ boolean ReadDiagnosticOptions(IntrusiveRefCntPtr<DiagnosticOptions> DiagOpts, 
                       boolean Complain) {
    return false;
  }

  
  /// \brief Receives the file system options.
  ///
  /// \returns true to indicate the file system options are invalid, or false
  /// otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReaderListener::ReadFileSystemOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 151,
   FQN="clang::ASTReaderListener::ReadFileSystemOptions", NM="_ZN5clang17ASTReaderListener21ReadFileSystemOptionsERKNS_17FileSystemOptionsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang17ASTReaderListener21ReadFileSystemOptionsERKNS_17FileSystemOptionsEb")
  //</editor-fold>
  public /*virtual*/ boolean ReadFileSystemOptions(final /*const*/ FileSystemOptions /*&*/ FSOpts, 
                       boolean Complain) {
    return false;
  }

  
  /// \brief Receives the header search options.
  ///
  /// \returns true to indicate the header search options are invalid, or false
  /// otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReaderListener::ReadHeaderSearchOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 160,
   FQN="clang::ASTReaderListener::ReadHeaderSearchOptions", NM="_ZN5clang17ASTReaderListener23ReadHeaderSearchOptionsERKNS_19HeaderSearchOptionsEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang17ASTReaderListener23ReadHeaderSearchOptionsERKNS_19HeaderSearchOptionsEN4llvm9StringRefEb")
  //</editor-fold>
  public /*virtual*/ boolean ReadHeaderSearchOptions(final /*const*/ HeaderSearchOptions /*&*/ HSOpts, 
                         StringRef SpecificModuleCachePath, 
                         boolean Complain) {
    return false;
  }

  
  /// \brief Receives the preprocessor options.
  ///
  /// \param SuggestedPredefines Can be filled in with the set of predefines
  /// that are suggested by the preprocessor options. Typically only used when
  /// loading a precompiled header.
  ///
  /// \returns true to indicate the preprocessor options are invalid, or false
  /// otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReaderListener::ReadPreprocessorOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 174,
   FQN="clang::ASTReaderListener::ReadPreprocessorOptions", NM="_ZN5clang17ASTReaderListener23ReadPreprocessorOptionsERKNS_19PreprocessorOptionsEbRSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang17ASTReaderListener23ReadPreprocessorOptionsERKNS_19PreprocessorOptionsEbRSs")
  //</editor-fold>
  public /*virtual*/ boolean ReadPreprocessorOptions(final /*const*/ PreprocessorOptions /*&*/ PPOpts, 
                         boolean Complain, 
                         final std.string/*&*/ SuggestedPredefines) {
    return false;
  }

  
  /// \brief Receives __COUNTER__ value.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReaderListener::ReadCounter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 181,
   FQN="clang::ASTReaderListener::ReadCounter", NM="_ZN5clang17ASTReaderListener11ReadCounterERKNS_13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang17ASTReaderListener11ReadCounterERKNS_13serialization10ModuleFileEj")
  //</editor-fold>
  public /*virtual*/ void ReadCounter(final /*const*/ ModuleFile /*&*/ M, 
             /*uint*/int Value) {
  }

  
  /// This is called for each AST file loaded.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReaderListener::visitModuleFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 185,
   FQN="clang::ASTReaderListener::visitModuleFile", NM="_ZN5clang17ASTReaderListener15visitModuleFileEN4llvm9StringRefENS_13serialization10ModuleKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang17ASTReaderListener15visitModuleFileEN4llvm9StringRefENS_13serialization10ModuleKindE")
  //</editor-fold>
  public /*virtual*/ void visitModuleFile(StringRef Filename, 
                 ModuleKind Kind) {
  }

  
  /// \brief Returns true if this \c ASTReaderListener wants to receive the
  /// input files of the AST file via \c visitInputFile, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReaderListener::needsInputFileVisitation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 190,
   FQN="clang::ASTReaderListener::needsInputFileVisitation", NM="_ZN5clang17ASTReaderListener24needsInputFileVisitationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang17ASTReaderListener24needsInputFileVisitationEv")
  //</editor-fold>
  public /*virtual*/ boolean needsInputFileVisitation() {
    return false;
  }

  /// \brief Returns true if this \c ASTReaderListener wants to receive the
  /// system input files of the AST file via \c visitInputFile, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReaderListener::needsSystemInputFileVisitation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 193,
   FQN="clang::ASTReaderListener::needsSystemInputFileVisitation", NM="_ZN5clang17ASTReaderListener30needsSystemInputFileVisitationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang17ASTReaderListener30needsSystemInputFileVisitationEv")
  //</editor-fold>
  public /*virtual*/ boolean needsSystemInputFileVisitation() {
    return false;
  }

  /// \brief if \c needsInputFileVisitation returns true, this is called for
  /// each non-system input file of the AST File. If
  /// \c needsSystemInputFileVisitation is true, then it is called for all
  /// system input files as well.
  ///
  /// \returns true to continue receiving the next input file, false to stop.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReaderListener::visitInputFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 200,
   FQN="clang::ASTReaderListener::visitInputFile", NM="_ZN5clang17ASTReaderListener14visitInputFileEN4llvm9StringRefEbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang17ASTReaderListener14visitInputFileEN4llvm9StringRefEbbb")
  //</editor-fold>
  public /*virtual*/ boolean visitInputFile(StringRef Filename, boolean isSystem, 
                boolean isOverridden, boolean isExplicitModule) {
    return true;
  }

  
  /// \brief Returns true if this \c ASTReaderListener wants to receive the
  /// imports of the AST file via \c visitImport, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReaderListener::needsImportVisitation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 207,
   FQN="clang::ASTReaderListener::needsImportVisitation", NM="_ZNK5clang17ASTReaderListener21needsImportVisitationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang17ASTReaderListener21needsImportVisitationEv")
  //</editor-fold>
  public /*virtual*/ boolean needsImportVisitation() /*const*/ {
    return false;
  }

  /// \brief If needsImportVisitation returns \c true, this is called for each
  /// AST file imported by this AST file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReaderListener::visitImport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 210,
   FQN="clang::ASTReaderListener::visitImport", NM="_ZN5clang17ASTReaderListener11visitImportEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang17ASTReaderListener11visitImportEN4llvm9StringRefE")
  //</editor-fold>
  public /*virtual*/ void visitImport(StringRef Filename) {
  }

  
  /// Indicates that a particular module file extension has been read.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReaderListener::readModuleFileExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 213,
   FQN="clang::ASTReaderListener::readModuleFileExtension", NM="_ZN5clang17ASTReaderListener23readModuleFileExtensionERKNS_27ModuleFileExtensionMetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang17ASTReaderListener23readModuleFileExtensionERKNS_27ModuleFileExtensionMetadataE")
  //</editor-fold>
  public /*virtual*/ void readModuleFileExtension(final /*const*/ ModuleFileExtensionMetadata /*&*/ Metadata) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReaderListener::ASTReaderListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 104,
   FQN="clang::ASTReaderListener::ASTReaderListener", NM="_ZN5clang17ASTReaderListenerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang17ASTReaderListenerC1Ev")
  //</editor-fold>
  public /*inline*/ ASTReaderListener() {
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
