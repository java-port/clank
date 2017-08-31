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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.clang.basic.*;
import org.clang.basic.target.*;
import org.clang.lex.*;
import org.llvm.adt.IntrusiveRefCntPtr;
import org.llvm.adt.StringRef;


/// \brief Simple wrapper class for chaining listeners.
//<editor-fold defaultstate="collapsed" desc="clang::ChainedASTReaderListener">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 218,
 FQN="clang::ChainedASTReaderListener", NM="_ZN5clang24ChainedASTReaderListenerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang24ChainedASTReaderListenerE")
//</editor-fold>
public class ChainedASTReaderListener extends /*public*/ ASTReaderListener implements Destructors.ClassWithDestructor {
  private std.unique_ptr<ASTReaderListener> First;
  private std.unique_ptr<ASTReaderListener> Second;
/*public:*/
  /// Takes ownership of \p First and \p Second.
  //<editor-fold defaultstate="collapsed" desc="clang::ChainedASTReaderListener::ChainedASTReaderListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 224,
   FQN="clang::ChainedASTReaderListener::ChainedASTReaderListener", NM="_ZN5clang24ChainedASTReaderListenerC1ESt10unique_ptrINS_17ASTReaderListenerESt14default_deleteIS2_EES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang24ChainedASTReaderListenerC1ESt10unique_ptrINS_17ASTReaderListenerESt14default_deleteIS2_EES5_")
  //</editor-fold>
  public ChainedASTReaderListener(std.unique_ptr<ASTReaderListener> First, 
      std.unique_ptr<ASTReaderListener> Second) {
    // : ASTReaderListener(), First(std::move(First)), Second(std::move(Second)) 
    //START JInit
    super();
    this.First = new std.unique_ptr<ASTReaderListener>(JD$Move.INSTANCE, std.move(First));
    this.Second = new std.unique_ptr<ASTReaderListener>(JD$Move.INSTANCE, std.move(Second));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ChainedASTReaderListener::takeFirst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 228,
   FQN="clang::ChainedASTReaderListener::takeFirst", NM="_ZN5clang24ChainedASTReaderListener9takeFirstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang24ChainedASTReaderListener9takeFirstEv")
  //</editor-fold>
  public std.unique_ptr<ASTReaderListener> takeFirst() {
    return new std.unique_ptr<ASTReaderListener>(JD$Move.INSTANCE, std.move(First));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChainedASTReaderListener::takeSecond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 229,
   FQN="clang::ChainedASTReaderListener::takeSecond", NM="_ZN5clang24ChainedASTReaderListener10takeSecondEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang24ChainedASTReaderListener10takeSecondEv")
  //</editor-fold>
  public std.unique_ptr<ASTReaderListener> takeSecond() {
    return new std.unique_ptr<ASTReaderListener>(JD$Move.INSTANCE, std.move(Second));
  }

  
  
  //===----------------------------------------------------------------------===//
  // ChainedASTReaderListener implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ChainedASTReaderListener::ReadFullVersionInformation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 73,
   FQN="clang::ChainedASTReaderListener::ReadFullVersionInformation", NM="_ZN5clang24ChainedASTReaderListener26ReadFullVersionInformationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang24ChainedASTReaderListener26ReadFullVersionInformationEN4llvm9StringRefE")
  //</editor-fold>
  @Override public boolean ReadFullVersionInformation(StringRef FullVersion)/* override*/ {
    return First.$arrow().ReadFullVersionInformation(new StringRef(FullVersion))
       || Second.$arrow().ReadFullVersionInformation(new StringRef(FullVersion));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChainedASTReaderListener::ReadModuleName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 78,
   FQN="clang::ChainedASTReaderListener::ReadModuleName", NM="_ZN5clang24ChainedASTReaderListener14ReadModuleNameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang24ChainedASTReaderListener14ReadModuleNameEN4llvm9StringRefE")
  //</editor-fold>
  @Override public void ReadModuleName(StringRef ModuleName)/* override*/ {
    First.$arrow().ReadModuleName(new StringRef(ModuleName));
    Second.$arrow().ReadModuleName(new StringRef(ModuleName));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChainedASTReaderListener::ReadModuleMapFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 82,
   FQN="clang::ChainedASTReaderListener::ReadModuleMapFile", NM="_ZN5clang24ChainedASTReaderListener17ReadModuleMapFileEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang24ChainedASTReaderListener17ReadModuleMapFileEN4llvm9StringRefE")
  //</editor-fold>
  @Override public void ReadModuleMapFile(StringRef ModuleMapPath)/* override*/ {
    First.$arrow().ReadModuleMapFile(new StringRef(ModuleMapPath));
    Second.$arrow().ReadModuleMapFile(new StringRef(ModuleMapPath));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChainedASTReaderListener::ReadLanguageOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 86,
   FQN="clang::ChainedASTReaderListener::ReadLanguageOptions", NM="_ZN5clang24ChainedASTReaderListener19ReadLanguageOptionsERKNS_11LangOptionsEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang24ChainedASTReaderListener19ReadLanguageOptionsERKNS_11LangOptionsEbb")
  //</editor-fold>
  @Override public boolean ReadLanguageOptions(final /*const*/ LangOptions /*&*/ LangOpts, 
                     boolean Complain, 
                     boolean AllowCompatibleDifferences)/* override*/ {
    return First.$arrow().ReadLanguageOptions(LangOpts, Complain, 
        AllowCompatibleDifferences)
       || Second.$arrow().ReadLanguageOptions(LangOpts, Complain, 
        AllowCompatibleDifferences);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChainedASTReaderListener::ReadTargetOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 95,
   FQN="clang::ChainedASTReaderListener::ReadTargetOptions", NM="_ZN5clang24ChainedASTReaderListener17ReadTargetOptionsERKNS_13TargetOptionsEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang24ChainedASTReaderListener17ReadTargetOptionsERKNS_13TargetOptionsEbb")
  //</editor-fold>
  @Override public boolean ReadTargetOptions(final /*const*/ TargetOptions /*&*/ TargetOpts, boolean Complain, 
                   boolean AllowCompatibleDifferences)/* override*/ {
    return First.$arrow().ReadTargetOptions(TargetOpts, Complain, 
        AllowCompatibleDifferences)
       || Second.$arrow().ReadTargetOptions(TargetOpts, Complain, 
        AllowCompatibleDifferences);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChainedASTReaderListener::ReadDiagnosticOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 103,
   FQN="clang::ChainedASTReaderListener::ReadDiagnosticOptions", NM="_ZN5clang24ChainedASTReaderListener21ReadDiagnosticOptionsEN4llvm18IntrusiveRefCntPtrINS_17DiagnosticOptionsEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang24ChainedASTReaderListener21ReadDiagnosticOptionsEN4llvm18IntrusiveRefCntPtrINS_17DiagnosticOptionsEEEb")
  //</editor-fold>
  @Override public boolean ReadDiagnosticOptions(IntrusiveRefCntPtr<DiagnosticOptions> DiagOpts, boolean Complain)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(First.$arrow().ReadDiagnosticOptions($c$.track(new IntrusiveRefCntPtr<DiagnosticOptions>(DiagOpts)), Complain)
         || Second.$arrow().ReadDiagnosticOptions($c$.track(new IntrusiveRefCntPtr<DiagnosticOptions>(DiagOpts)), Complain));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChainedASTReaderListener::ReadFileSystemOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 108,
   FQN="clang::ChainedASTReaderListener::ReadFileSystemOptions", NM="_ZN5clang24ChainedASTReaderListener21ReadFileSystemOptionsERKNS_17FileSystemOptionsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang24ChainedASTReaderListener21ReadFileSystemOptionsERKNS_17FileSystemOptionsEb")
  //</editor-fold>
  @Override public boolean ReadFileSystemOptions(final /*const*/ FileSystemOptions /*&*/ FSOpts, 
                       boolean Complain)/* override*/ {
    return First.$arrow().ReadFileSystemOptions(FSOpts, Complain)
       || Second.$arrow().ReadFileSystemOptions(FSOpts, Complain);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ChainedASTReaderListener::ReadHeaderSearchOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 115,
   FQN="clang::ChainedASTReaderListener::ReadHeaderSearchOptions", NM="_ZN5clang24ChainedASTReaderListener23ReadHeaderSearchOptionsERKNS_19HeaderSearchOptionsEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang24ChainedASTReaderListener23ReadHeaderSearchOptionsERKNS_19HeaderSearchOptionsEN4llvm9StringRefEb")
  //</editor-fold>
  @Override public boolean ReadHeaderSearchOptions(final /*const*/ HeaderSearchOptions /*&*/ HSOpts, StringRef SpecificModuleCachePath, 
                         boolean Complain)/* override*/ {
    return First.$arrow().ReadHeaderSearchOptions(HSOpts, new StringRef(SpecificModuleCachePath), 
        Complain)
       || Second.$arrow().ReadHeaderSearchOptions(HSOpts, new StringRef(SpecificModuleCachePath), 
        Complain);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChainedASTReaderListener::ReadPreprocessorOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 123,
   FQN="clang::ChainedASTReaderListener::ReadPreprocessorOptions", NM="_ZN5clang24ChainedASTReaderListener23ReadPreprocessorOptionsERKNS_19PreprocessorOptionsEbRSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang24ChainedASTReaderListener23ReadPreprocessorOptionsERKNS_19PreprocessorOptionsEbRSs")
  //</editor-fold>
  @Override public boolean ReadPreprocessorOptions(final /*const*/ PreprocessorOptions /*&*/ PPOpts, boolean Complain, 
                         final std.string/*&*/ SuggestedPredefines)/* override*/ {
    return First.$arrow().ReadPreprocessorOptions(PPOpts, Complain, 
        SuggestedPredefines)
       || Second.$arrow().ReadPreprocessorOptions(PPOpts, Complain, SuggestedPredefines);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ChainedASTReaderListener::ReadCounter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 130,
   FQN="clang::ChainedASTReaderListener::ReadCounter", NM="_ZN5clang24ChainedASTReaderListener11ReadCounterERKNS_13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang24ChainedASTReaderListener11ReadCounterERKNS_13serialization10ModuleFileEj")
  //</editor-fold>
  @Override public void ReadCounter(final /*const*/ ModuleFile /*&*/ M, 
             /*uint*/int Value)/* override*/ {
    First.$arrow().ReadCounter(M, Value);
    Second.$arrow().ReadCounter(M, Value);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChainedASTReaderListener::needsInputFileVisitation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 135,
   FQN="clang::ChainedASTReaderListener::needsInputFileVisitation", NM="_ZN5clang24ChainedASTReaderListener24needsInputFileVisitationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang24ChainedASTReaderListener24needsInputFileVisitationEv")
  //</editor-fold>
  @Override public boolean needsInputFileVisitation()/* override*/ {
    return First.$arrow().needsInputFileVisitation()
       || Second.$arrow().needsInputFileVisitation();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChainedASTReaderListener::needsSystemInputFileVisitation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 139,
   FQN="clang::ChainedASTReaderListener::needsSystemInputFileVisitation", NM="_ZN5clang24ChainedASTReaderListener30needsSystemInputFileVisitationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang24ChainedASTReaderListener30needsSystemInputFileVisitationEv")
  //</editor-fold>
  @Override public boolean needsSystemInputFileVisitation()/* override*/ {
    return First.$arrow().needsSystemInputFileVisitation()
       || Second.$arrow().needsSystemInputFileVisitation();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChainedASTReaderListener::visitModuleFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 143,
   FQN="clang::ChainedASTReaderListener::visitModuleFile", NM="_ZN5clang24ChainedASTReaderListener15visitModuleFileEN4llvm9StringRefENS_13serialization10ModuleKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang24ChainedASTReaderListener15visitModuleFileEN4llvm9StringRefENS_13serialization10ModuleKindE")
  //</editor-fold>
  @Override public void visitModuleFile(StringRef Filename, 
                 ModuleKind Kind)/* override*/ {
    First.$arrow().visitModuleFile(new StringRef(Filename), Kind);
    Second.$arrow().visitModuleFile(new StringRef(Filename), Kind);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChainedASTReaderListener::visitInputFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 148,
   FQN="clang::ChainedASTReaderListener::visitInputFile", NM="_ZN5clang24ChainedASTReaderListener14visitInputFileEN4llvm9StringRefEbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang24ChainedASTReaderListener14visitInputFileEN4llvm9StringRefEbbb")
  //</editor-fold>
  @Override public boolean visitInputFile(StringRef Filename, 
                boolean isSystem, 
                boolean isOverridden, 
                boolean isExplicitModule)/* override*/ {
    boolean Continue = false;
    if (First.$arrow().needsInputFileVisitation()
       && (!isSystem || First.$arrow().needsSystemInputFileVisitation())) {
      Continue |= First.$arrow().visitInputFile(new StringRef(Filename), isSystem, isOverridden, 
          isExplicitModule);
    }
    if (Second.$arrow().needsInputFileVisitation()
       && (!isSystem || Second.$arrow().needsSystemInputFileVisitation())) {
      Continue |= Second.$arrow().visitInputFile(new StringRef(Filename), isSystem, isOverridden, 
          isExplicitModule);
    }
    return Continue;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChainedASTReaderListener::readModuleFileExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 164,
   FQN="clang::ChainedASTReaderListener::readModuleFileExtension", NM="_ZN5clang24ChainedASTReaderListener23readModuleFileExtensionERKNS_27ModuleFileExtensionMetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang24ChainedASTReaderListener23readModuleFileExtensionERKNS_27ModuleFileExtensionMetadataE")
  //</editor-fold>
  @Override public void readModuleFileExtension(final /*const*/ ModuleFileExtensionMetadata /*&*/ Metadata)/* override*/ {
    First.$arrow().readModuleFileExtension(Metadata);
    Second.$arrow().readModuleFileExtension(Metadata);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChainedASTReaderListener::~ChainedASTReaderListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 218,
   FQN="clang::ChainedASTReaderListener::~ChainedASTReaderListener", NM="_ZN5clang24ChainedASTReaderListenerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang24ChainedASTReaderListenerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Second.$destroy();
    First.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "First=" + First // NOI18N
              + ", Second=" + Second // NOI18N
              + super.toString(); // NOI18N
  }
}
