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

package org.clang.lex;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.*;


/// PreprocessorOptions - This class is used for passing the various options
/// used in preprocessor initialization to InitializePreprocessor().
//<editor-fold defaultstate="collapsed" desc="clang::PreprocessorOptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorOptions.h", line = 44,
 FQN="clang::PreprocessorOptions", NM="_ZN5clang19PreprocessorOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang19PreprocessorOptionsE")
//</editor-fold>
public class PreprocessorOptions extends /*public*/ RefCountedBase<PreprocessorOptions> implements Destructors.ClassWithDestructor {
/*public:*/
  public std.vector<std.pairTypeBool<std.string>> Macros;
  public std.vectorString Includes;
  public std.vectorString MacroIncludes;
  
  /// \brief Initialize the preprocessor with the compiler and target specific
  /// predefines.
  public /*JBIT unsigned int*/ boolean UsePredefines /*: 1*/;
  
  /// \brief Whether we should maintain a detailed record of all macro
  /// definitions and expansions.
  public /*JBIT unsigned int*/ boolean DetailedRecord /*: 1*/;
  
  /// The implicit PCH included at the start of the translation unit, or empty.
  public std.string ImplicitPCHInclude;
  
  /// \brief Headers that will be converted to chained PCHs in memory.
  public std.vectorString ChainedIncludes;
  
  /// \brief When true, disables most of the normal validation performed on
  /// precompiled headers.
  public boolean DisablePCHValidation;
  
  /// \brief When true, a PCH with compiler errors will not be rejected.
  public boolean AllowPCHWithCompilerErrors;
  
  /// \brief Dump declarations that are deserialized from PCH, for testing.
  public boolean DumpDeserializedPCHDecls;
  
  /// \brief This is a set of names for decls that we do not want to be
  /// deserialized, and we emit an error if they are; for testing purposes.
  public std.setType<std.string> DeserializedPCHDeclsToErrorOn;
  
  /// \brief If non-zero, the implicit PCH include is actually a precompiled
  /// preamble that covers this number of bytes in the main source file.
  ///
  /// The boolean indicates whether the preamble ends at the start of a new
  /// line.
  public std.pairUIntBool PrecompiledPreambleBytes;
  
  /// The implicit PTH input included at the start of the translation unit, or
  /// empty.
  public std.string ImplicitPTHInclude;
  
  /// If given, a PTH cache file to use for speeding up header parsing.
  public std.string TokenCache;
  
  /// \brief True if the SourceManager should report the original file name for
  /// contents of files that were remapped to other files. Defaults to true.
  public boolean RemappedFilesKeepOriginalName;
  
  /// \brief The set of file remappings, which take existing files on
  /// the system (the first part of each pair) and gives them the
  /// contents of other files on the system (the second part of each
  /// pair).
  public std.vector<std.pair<std.string, std.string>> RemappedFiles;
  
  /// \brief The set of file-to-buffer remappings, which take existing files
  /// on the system (the first part of each pair) and gives them the contents
  /// of the specified memory buffer (the second part of each pair).
  public std.vector<std.pair<std.string, MemoryBuffer /*P*/ >> RemappedFileBuffers;
  
  /// \brief Whether the compiler instance should retain (i.e., not free)
  /// the buffers associated with remapped files.
  ///
  /// This flag defaults to false; it can be set true only through direct
  /// manipulation of the compiler invocation object, in cases where the 
  /// compiler invocation and its buffers will be reused.
  public boolean RetainRemappedFileBuffers;
  
  /// \brief The Objective-C++ ARC standard library that we should support,
  /// by providing appropriate definitions to retrofit the standard library
  /// with support for lifetime-qualified pointers.
  public ObjCXXARCStandardLibraryKind ObjCXXARCStandardLibrary;
  
  /// \brief Records the set of modules
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorOptions::FailedModulesSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorOptions.h", line = 121,
   FQN="clang::PreprocessorOptions::FailedModulesSet", NM="_ZN5clang19PreprocessorOptions16FailedModulesSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang19PreprocessorOptions16FailedModulesSetE")
  //</editor-fold>
  public static class FailedModulesSet extends /*public*/ RefCountedBase<FailedModulesSet> implements Destructors.ClassWithDestructor {
    private StringSet/*<MallocAllocator>*/ Failed;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorOptions::FailedModulesSet::hasAlreadyFailed">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorOptions.h", line = 125,
     FQN="clang::PreprocessorOptions::FailedModulesSet::hasAlreadyFailed", NM="_ZN5clang19PreprocessorOptions16FailedModulesSet16hasAlreadyFailedEN4llvm9StringRefE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang19PreprocessorOptions16FailedModulesSet16hasAlreadyFailedEN4llvm9StringRefE")
    //</editor-fold>
    public boolean hasAlreadyFailed(StringRef module) {
      return Failed.count(/*NO_COPY*/module) > 0;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorOptions::FailedModulesSet::addFailed">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorOptions.h", line = 129,
     FQN="clang::PreprocessorOptions::FailedModulesSet::addFailed", NM="_ZN5clang19PreprocessorOptions16FailedModulesSet9addFailedEN4llvm9StringRefE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang19PreprocessorOptions16FailedModulesSet9addFailedEN4llvm9StringRefE")
    //</editor-fold>
    public void addFailed(StringRef module) {
      Failed.insert(/*NO_COPY*/module);
    }
    
    //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorOptions::FailedModulesSet::FailedModulesSet">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorOptions.h", line = 121,
     FQN="clang::PreprocessorOptions::FailedModulesSet::FailedModulesSet", NM="_ZN5clang19PreprocessorOptions16FailedModulesSetC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang19PreprocessorOptions16FailedModulesSetC1Ev")
    //</editor-fold>
    public /*inline*/ FailedModulesSet() {
      /* : RefCountedBase<FailedModulesSet>(), Failed()*/ 
      //START JInit
      super();
      this.Failed = new StringSet/*<MallocAllocator>*/();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorOptions::FailedModulesSet::~FailedModulesSet">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorOptions.h", line = 121,
     FQN="clang::PreprocessorOptions::FailedModulesSet::~FailedModulesSet", NM="_ZN5clang19PreprocessorOptions16FailedModulesSetD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang19PreprocessorOptions16FailedModulesSetD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Failed.$destroy();
      super.$destroy();
      //END JDestroy
    }

    
    public String toString() {
      return "" + "Failed=" + Failed // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  /// \brief The set of modules that failed to build.
  ///
  /// This pointer will be shared among all of the compiler instances created
  /// to (re)build modules, so that once a module fails to build anywhere,
  /// other instances will see that the module has failed and won't try to
  /// build it again.
  public IntrusiveRefCntPtr<FailedModulesSet> FailedModules;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorOptions::PreprocessorOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorOptions.h", line = 143,
   FQN="clang::PreprocessorOptions::PreprocessorOptions", NM="_ZN5clang19PreprocessorOptionsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang19PreprocessorOptionsC1Ev")
  //</editor-fold>
  public PreprocessorOptions() {
    /* : RefCountedBase<PreprocessorOptions>(), Macros(), Includes(), MacroIncludes(), UsePredefines(true), DetailedRecord(false), ImplicitPCHInclude(), ChainedIncludes(), DisablePCHValidation(false), AllowPCHWithCompilerErrors(false), DumpDeserializedPCHDecls(false), DeserializedPCHDeclsToErrorOn(), PrecompiledPreambleBytes(0, true), ImplicitPTHInclude(), TokenCache(), RemappedFilesKeepOriginalName(true), RemappedFiles(), RemappedFileBuffers(), RetainRemappedFileBuffers(false), ObjCXXARCStandardLibrary(ARCXX_nolib), FailedModules()*/ 
    //START JInit
    super();
    this.Macros = new std.vector<std.pairTypeBool<std.string>>(new std.pairTypeBool<std.string>(new std.string(), false));
    this.Includes = new std.vectorString(std.string.EMPTY);
    this.MacroIncludes = new std.vectorString(std.string.EMPTY);
    this.UsePredefines = true;
    this.DetailedRecord = false;
    this.ImplicitPCHInclude = new std.string();
    this.ChainedIncludes = new std.vectorString(std.string.EMPTY);
    this.DisablePCHValidation = false;
    this.AllowPCHWithCompilerErrors = false;
    this.DumpDeserializedPCHDecls = false;
    this.DeserializedPCHDeclsToErrorOn = new std.setType<std.string>();
    this.PrecompiledPreambleBytes = new std.pairUIntBool(0, true);
    this.ImplicitPTHInclude = new std.string();
    this.TokenCache = new std.string();
    this.RemappedFilesKeepOriginalName = true;
    this.RemappedFiles = new std.vector<std.pair<std.string, std.string>>(new std.pairTypeType<std.string, std.string>(new std.string(), new std.string()));
    this.RemappedFileBuffers = new std.vector<std.pair<std.string, MemoryBuffer /*P*/ >>(new std.pairTypePtr<std.string, MemoryBuffer /*P*/ >(new std.string(), null));
    this.RetainRemappedFileBuffers = false;
    this.ObjCXXARCStandardLibrary = ObjCXXARCStandardLibraryKind.ARCXX_nolib;
    this.FailedModules = new IntrusiveRefCntPtr<FailedModulesSet>();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorOptions::addMacroDef">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorOptions.h", line = 152,
   FQN="clang::PreprocessorOptions::addMacroDef", NM="_ZN5clang19PreprocessorOptions11addMacroDefEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang19PreprocessorOptions11addMacroDefEN4llvm9StringRefE")
  //</editor-fold>
  public void addMacroDef(StringRef Name) {
    Macros.emplace_back(std.make_pair_T_bool(Name.str(), false));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorOptions::addMacroUndef">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorOptions.h", line = 153,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorOptions.h", old_line = 155,
   FQN="clang::PreprocessorOptions::addMacroUndef", NM="_ZN5clang19PreprocessorOptions13addMacroUndefEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang19PreprocessorOptions13addMacroUndefEN4llvm9StringRefE")
  //</editor-fold>
  public void addMacroUndef(StringRef Name) {
    Macros.emplace_back(std.make_pair_T_bool(Name.str(), true));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorOptions::addRemappedFile">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorOptions.h", line = 154,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorOptions.h", old_line = 158,
   FQN="clang::PreprocessorOptions::addRemappedFile", NM="_ZN5clang19PreprocessorOptions15addRemappedFileEN4llvm9StringRefES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang19PreprocessorOptions15addRemappedFileEN4llvm9StringRefES2_")
  //</editor-fold>
  public void addRemappedFile(StringRef From, StringRef To) {
    RemappedFiles.emplace_back(std.make_pair(From.str(), To.str()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorOptions::addRemappedFile">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorOptions.h", line = 158,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorOptions.h", old_line = 162,
   FQN="clang::PreprocessorOptions::addRemappedFile", NM="_ZN5clang19PreprocessorOptions15addRemappedFileEN4llvm9StringRefEPNS1_12MemoryBufferE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang19PreprocessorOptions15addRemappedFileEN4llvm9StringRefEPNS1_12MemoryBufferE")
  //</editor-fold>
  public void addRemappedFile(StringRef From, MemoryBuffer /*P*/ To) {
    RemappedFileBuffers.emplace_back(std.make_pair(From.str(), To));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorOptions::clearRemappedFiles">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorOptions.h", line = 162,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorOptions.h", old_line = 166,
   FQN="clang::PreprocessorOptions::clearRemappedFiles", NM="_ZN5clang19PreprocessorOptions18clearRemappedFilesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang19PreprocessorOptions18clearRemappedFilesEv")
  //</editor-fold>
  public void clearRemappedFiles() {
    RemappedFiles.clear();
    RemappedFileBuffers.clear();
  }

  
  /// \brief Reset any options that are not considered when building a
  /// module.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorOptions::resetNonModularOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorOptions.h", line = 169,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorOptions.h", old_line = 173,
   FQN="clang::PreprocessorOptions::resetNonModularOptions", NM="_ZN5clang19PreprocessorOptions22resetNonModularOptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang19PreprocessorOptions22resetNonModularOptionsEv")
  //</editor-fold>
  public void resetNonModularOptions() {
    Includes.clear();
    MacroIncludes.clear();
    ChainedIncludes.clear();
    DumpDeserializedPCHDecls = false;
    ImplicitPCHInclude.clear();
    ImplicitPTHInclude.clear();
    TokenCache.clear();
    RetainRemappedFileBuffers = true;
    PrecompiledPreambleBytes.first = 0;
    PrecompiledPreambleBytes.second = false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorOptions::~PreprocessorOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorOptions.h", line = 44,
   FQN="clang::PreprocessorOptions::~PreprocessorOptions", NM="_ZN5clang19PreprocessorOptionsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang19PreprocessorOptionsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    FailedModules.$destroy();
    RemappedFileBuffers.$destroy();
    RemappedFiles.$destroy();
    TokenCache.$destroy();
    ImplicitPTHInclude.$destroy();
    DeserializedPCHDeclsToErrorOn.$destroy();
    ChainedIncludes.$destroy();
    ImplicitPCHInclude.$destroy();
    MacroIncludes.$destroy();
    Includes.$destroy();
    Macros.$destroy();
    super.$destroy();
    //END JDestroy
  }


  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorOptions::PreprocessorOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorOptions.h", line = 44,
   FQN="clang::PreprocessorOptions::PreprocessorOptions", NM="_ZN5clang19PreprocessorOptionsC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang19PreprocessorOptionsC1ERKS0_")
  //</editor-fold>
  public /*inline*/ PreprocessorOptions(/*const*/ PreprocessorOptions /*&*/ $Prm0) {
    /* : RefCountedBase<PreprocessorOptions>(), Macros(.Macros), Includes(.Includes), MacroIncludes(.MacroIncludes), UsePredefines(.UsePredefines), DetailedRecord(.DetailedRecord), ImplicitPCHInclude(.ImplicitPCHInclude), ChainedIncludes(.ChainedIncludes), DisablePCHValidation(.DisablePCHValidation), AllowPCHWithCompilerErrors(.AllowPCHWithCompilerErrors), DumpDeserializedPCHDecls(.DumpDeserializedPCHDecls), DeserializedPCHDeclsToErrorOn(.DeserializedPCHDeclsToErrorOn), PrecompiledPreambleBytes(.PrecompiledPreambleBytes), ImplicitPTHInclude(.ImplicitPTHInclude), TokenCache(.TokenCache), RemappedFilesKeepOriginalName(.RemappedFilesKeepOriginalName), RemappedFiles(.RemappedFiles), RemappedFileBuffers(.RemappedFileBuffers), RetainRemappedFileBuffers(.RetainRemappedFileBuffers), ObjCXXARCStandardLibrary(.ObjCXXARCStandardLibrary), FailedModules(.FailedModules)*/ 
    //START JInit
    super($Prm0);
    this.Macros = new std.vector<std.pairTypeBool<std.string>>($Prm0.Macros);
    this.Includes = new std.vectorString($Prm0.Includes);
    this.MacroIncludes = new std.vectorString($Prm0.MacroIncludes);
    this.UsePredefines = $Prm0.UsePredefines;
    this.DetailedRecord = $Prm0.DetailedRecord;
    this.ImplicitPCHInclude = new std.string($Prm0.ImplicitPCHInclude);
    this.ChainedIncludes = new std.vectorString($Prm0.ChainedIncludes);
    this.DisablePCHValidation = $Prm0.DisablePCHValidation;
    this.AllowPCHWithCompilerErrors = $Prm0.AllowPCHWithCompilerErrors;
    this.DumpDeserializedPCHDecls = $Prm0.DumpDeserializedPCHDecls;
    this.DeserializedPCHDeclsToErrorOn = new std.setType<std.string>($Prm0.DeserializedPCHDeclsToErrorOn);
    this.PrecompiledPreambleBytes = new std.pairUIntBool($Prm0.PrecompiledPreambleBytes);
    this.ImplicitPTHInclude = new std.string($Prm0.ImplicitPTHInclude);
    this.TokenCache = new std.string($Prm0.TokenCache);
    this.RemappedFilesKeepOriginalName = $Prm0.RemappedFilesKeepOriginalName;
    this.RemappedFiles = new std.vector<std.pair<std.string, std.string>>($Prm0.RemappedFiles);
    this.RemappedFileBuffers = new std.vector<std.pair<std.string, MemoryBuffer /*P*/ >>($Prm0.RemappedFileBuffers);
    this.RetainRemappedFileBuffers = $Prm0.RetainRemappedFileBuffers;
    this.ObjCXXARCStandardLibrary = $Prm0.ObjCXXARCStandardLibrary;
    this.FailedModules = new IntrusiveRefCntPtr<FailedModulesSet>($Prm0.FailedModules);
    //END JInit
  }


  public String toString() {
    return "" + "Macros=" + Macros // NOI18N
              + ", Includes=" + Includes // NOI18N
              + ", MacroIncludes=" + MacroIncludes // NOI18N
              + ", UsePredefines=" + UsePredefines // NOI18N
              + ", DetailedRecord=" + DetailedRecord // NOI18N
              + ", ImplicitPCHInclude=" + ImplicitPCHInclude // NOI18N
              + ", ChainedIncludes=" + ChainedIncludes // NOI18N
              + ", DisablePCHValidation=" + DisablePCHValidation // NOI18N
              + ", AllowPCHWithCompilerErrors=" + AllowPCHWithCompilerErrors // NOI18N
              + ", DumpDeserializedPCHDecls=" + DumpDeserializedPCHDecls // NOI18N
              + ", DeserializedPCHDeclsToErrorOn=" + DeserializedPCHDeclsToErrorOn // NOI18N
              + ", PrecompiledPreambleBytes=" + PrecompiledPreambleBytes // NOI18N
              + ", ImplicitPTHInclude=" + ImplicitPTHInclude // NOI18N
              + ", TokenCache=" + TokenCache // NOI18N
              + ", RemappedFilesKeepOriginalName=" + RemappedFilesKeepOriginalName // NOI18N
              + ", RemappedFiles=" + RemappedFiles // NOI18N
              + ", RemappedFileBuffers=" + RemappedFileBuffers // NOI18N
              + ", RetainRemappedFileBuffers=" + RetainRemappedFileBuffers // NOI18N
              + ", ObjCXXARCStandardLibrary=" + ObjCXXARCStandardLibrary // NOI18N
              + ", FailedModules=" + FailedModules // NOI18N
              + super.toString(); // NOI18N
  }
}
