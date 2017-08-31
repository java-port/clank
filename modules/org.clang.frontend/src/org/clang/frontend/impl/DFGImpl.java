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

package org.clang.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.frontend.*;
import org.llvm.support.sys.*;
import static org.clang.frontend.impl.DependencyFileStatics.*;

/// Private implementation for DependencyFileGenerator
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DFGImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 153,
 FQN="(anonymous namespace)::DFGImpl", NM="_ZN12_GLOBAL__N_17DFGImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN12_GLOBAL__N_17DFGImplE")
//</editor-fold>
public class DFGImpl extends /*public*/ PPCallbacks implements Destructors.ClassWithDestructor {
  private std.vectorString Files;
  private StringSet/*<MallocAllocator>*/ FilesSet;
  private /*const*/ Preprocessor /*P*/ PP;
  private std.string OutputFile;
  private std.vectorString Targets;
  private boolean IncludeSystemHeaders;
  private boolean PhonyTarget;
  private boolean AddMissingHeaderDeps;
  private boolean SeenMissingHeader;
  private boolean IncludeModuleFiles;
  private DependencyOutputFormat OutputFormat;
/*private:*/
  
  /// FileMatchesDepCriteria - Determine whether the given Filename should be
  /// considered as a dependency.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DFGImpl::FileMatchesDepCriteria">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 260,
   FQN="(anonymous namespace)::DFGImpl::FileMatchesDepCriteria", NM="_ZN12_GLOBAL__N_17DFGImpl22FileMatchesDepCriteriaEPKcN5clang6SrcMgr18CharacteristicKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN12_GLOBAL__N_17DFGImpl22FileMatchesDepCriteriaEPKcN5clang6SrcMgr18CharacteristicKindE")
  //</editor-fold>
  private boolean FileMatchesDepCriteria(/*const*/char$ptr/*char P*/ Filename, 
                        SrcMgr.CharacteristicKind FileType) {
    if (isSpecialFilename(new StringRef(Filename))) {
      return false;
    }
    if (IncludeSystemHeaders) {
      return true;
    }
    
    return FileType == SrcMgr.CharacteristicKind.C_User;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DFGImpl::OutputDependencyFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 391,
   FQN="(anonymous namespace)::DFGImpl::OutputDependencyFile", NM="_ZN12_GLOBAL__N_17DFGImpl20OutputDependencyFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN12_GLOBAL__N_17DFGImpl20OutputDependencyFileEv")
  //</editor-fold>
  private void OutputDependencyFile() {
    raw_fd_ostream OS = null;
    try {
      if (SeenMissingHeader) {
        fs.remove(new Twine(OutputFile));
        return;
      }
      
      std.error_code EC/*J*/= new std.error_code();
      OS/*J*/= new raw_fd_ostream(new StringRef(OutputFile), EC, fs.OpenFlags.F_Text);
      if (EC.$bool()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(PP.getDiagnostics().Report(diag.err_fe_error_opening)), new StringRef(OutputFile)), 
              new StringRef(EC.message())));
          return;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Write out the dependency targets, trying to avoid overly long
      // lines when possible. We try our best to emit exactly the same
      // dependency file as GCC (4.2), assuming the included files are the
      // same.
      /*const*//*uint*/int MaxColumns = 75;
      /*uint*/int Columns = 0;
      
      for (std.vectorString.iterator I = Targets.begin(), E = Targets.end(); $noteq___normal_iterator$C(I, E); I.$preInc()) {
        /*uint*/int N = I.$arrow().length();
        if (Columns == 0) {
          Columns += N;
        } else if ($greater_uint(Columns + N + 2, MaxColumns)) {
          Columns = N + 2;
          OS.$out(/*KEEP_STR*/" \\\n  ");
        } else {
          Columns += N + 1;
          OS.$out_char($$SPACE);
        }
        // Targets already quoted as needed.
        OS.$out(I.$star());
      }
      
      OS.$out_char($$COLON);
      Columns += 1;
      
      // Now add each dependency in the order it was seen, but avoiding
      // duplicates.
      for (std.vectorString.iterator I = Files.begin(), 
          E = Files.end(); $noteq___normal_iterator$C(I, E); I.$preInc()) {
        // Start a new line if this would exceed the column limit. Make
        // sure to leave space for a trailing " \" in case we need to
        // break the line on the next iteration.
        /*uint*/int N = I.$arrow().length();
        if ($greater_uint(Columns + (N + 1) + 2, MaxColumns)) {
          OS.$out(/*KEEP_STR*/" \\\n ");
          Columns = 2;
        }
        OS.$out_char($$SPACE);
        PrintFilename(OS, new StringRef(I.$star()), OutputFormat);
        Columns += N + 1;
      }
      OS.$out_char($$LF);
      
      // Create phony targets if requested.
      if (PhonyTarget && !Files.empty()) {
        // Skip the first entry, this is always the input file itself.
        for (std.vectorString.iterator I = Files.begin().$add(1), 
            E = Files.end(); $noteq___normal_iterator$C(I, E); I.$preInc()) {
          OS.$out_char($$LF);
          PrintFilename(OS, new StringRef(I.$star()), OutputFormat);
          OS.$out(/*KEEP_STR*/$COLON_LF);
        }
      }
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DFGImpl::DFGImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 172,
   FQN="(anonymous namespace)::DFGImpl::DFGImpl", NM="_ZN12_GLOBAL__N_17DFGImplC1EPKN5clang12PreprocessorERKNS1_23DependencyOutputOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN12_GLOBAL__N_17DFGImplC1EPKN5clang12PreprocessorERKNS1_23DependencyOutputOptionsE")
  //</editor-fold>
  public DFGImpl(/*const*/ Preprocessor /*P*/ _PP, /*const*/ DependencyOutputOptions /*&*/ Opts) {
    // : PPCallbacks(), Files(), FilesSet(), PP(_PP), OutputFile(Opts.OutputFile), Targets(Opts.Targets), IncludeSystemHeaders(Opts.IncludeSystemHeaders), PhonyTarget(Opts.UsePhonyTargets), AddMissingHeaderDeps(Opts.AddMissingHeaderDeps), SeenMissingHeader(false), IncludeModuleFiles(Opts.IncludeModuleFiles), OutputFormat(Opts.OutputFormat) 
    //START JInit
    super();
    this.Files = new std.vectorString(std.string.EMPTY);
    this.FilesSet = new StringSet/*<MallocAllocator>*/();
    this.PP = _PP;
    this.OutputFile = new std.string(Opts.OutputFile);
    this.Targets = new std.vectorString(Opts.Targets);
    this.IncludeSystemHeaders = Opts.IncludeSystemHeaders;
    this.PhonyTarget = Opts.UsePhonyTargets;
    this.AddMissingHeaderDeps = Opts.AddMissingHeaderDeps;
    this.SeenMissingHeader = false;
    this.IncludeModuleFiles = Opts.IncludeModuleFiles;
    this.OutputFormat = Opts.OutputFormat;
    //END JInit
    for (/*const*/std.string/*&*/ ExtraDep : Opts.ExtraDeps) {
      AddFilename(new StringRef(ExtraDep));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DFGImpl::FileChanged">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 271,
   FQN="(anonymous namespace)::DFGImpl::FileChanged", NM="_ZN12_GLOBAL__N_17DFGImpl11FileChangedEN5clang14SourceLocationENS1_11PPCallbacks16FileChangeReasonENS1_6SrcMgr18CharacteristicKindENS1_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN12_GLOBAL__N_17DFGImpl11FileChangedEN5clang14SourceLocationENS1_11PPCallbacks16FileChangeReasonENS1_6SrcMgr18CharacteristicKindENS1_6FileIDE")
  //</editor-fold>
  @Override public void FileChanged(SourceLocation Loc, 
             FileChangeReason Reason, 
             SrcMgr.CharacteristicKind FileType, 
             FileID PrevFID)/* override*/ {
    if (Reason != PPCallbacks.FileChangeReason.EnterFile) {
      return;
    }
    
    // Dependency generation really does want to go all the way to the
    // file entry for a source location to find out what is depended on.
    // We do not want #line markers to affect dependency generation!
    SourceManager /*&*/ SM = PP.getSourceManager();
    
    /*const*/ FileEntry /*P*/ FE = SM.getFileEntryForID(SM.getFileID(SM.getExpansionLoc(/*NO_COPY*/Loc)));
    if (!(FE != null)) {
      return;
    }
    
    StringRef Filename = new StringRef(FE.getName());
    if (!FileMatchesDepCriteria(Filename.data(), FileType)) {
      return;
    }
    
    AddFilename(path.remove_leading_dotslash(new StringRef(Filename)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DFGImpl::InclusionDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 294,
   FQN="(anonymous namespace)::DFGImpl::InclusionDirective", NM="_ZN12_GLOBAL__N_17DFGImpl18InclusionDirectiveEN5clang14SourceLocationERKNS1_5TokenEN4llvm9StringRefEbNS1_15CharSourceRangeEPKNS1_9FileEntryES7_S7_PKNS1_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN12_GLOBAL__N_17DFGImpl18InclusionDirectiveEN5clang14SourceLocationERKNS1_5TokenEN4llvm9StringRefEbNS1_15CharSourceRangeEPKNS1_9FileEntryES7_S7_PKNS1_6ModuleE")
  //</editor-fold>
  @Override public void InclusionDirective(SourceLocation HashLoc, /*JAVA*/SourceLocation EodLoc, 
                    /*const*/ Token /*&*/ IncludeTok, 
                    StringRef FileName, 
                    boolean IsAngled, 
                    CharSourceRange FilenameRange, 
                    /*const*/ FileEntry /*P*/ File, 
                    StringRef SearchPath, 
                    StringRef RelativePath, 
                    /*const*/ Module /*P*/ Imported)/* override*/ {
    if (!(File != null)) {
      if (AddMissingHeaderDeps) {
        AddFilename(new StringRef(FileName));
      } else {
        SeenMissingHeader = true;
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DFGImpl::EndOfMainFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 194,
   FQN="(anonymous namespace)::DFGImpl::EndOfMainFile", NM="_ZN12_GLOBAL__N_17DFGImpl13EndOfMainFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN12_GLOBAL__N_17DFGImpl13EndOfMainFileEv")
  //</editor-fold>
  @Override public void EndOfMainFile()/* override*/ {
    OutputDependencyFile();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DFGImpl::AddFilename">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 311,
   FQN="(anonymous namespace)::DFGImpl::AddFilename", NM="_ZN12_GLOBAL__N_17DFGImpl11AddFilenameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN12_GLOBAL__N_17DFGImpl11AddFilenameEN4llvm9StringRefE")
  //</editor-fold>
  public void AddFilename(StringRef Filename) {
    if (FilesSet.insert(/*NO_COPY*/Filename).second) {
      Files.push_back_T$RR(Filename.$string());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DFGImpl::includeSystemHeaders">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 199,
   FQN="(anonymous namespace)::DFGImpl::includeSystemHeaders", NM="_ZNK12_GLOBAL__N_17DFGImpl20includeSystemHeadersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZNK12_GLOBAL__N_17DFGImpl20includeSystemHeadersEv")
  //</editor-fold>
  public boolean includeSystemHeaders() /*const*/ {
    return IncludeSystemHeaders;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DFGImpl::includeModuleFiles">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 200,
   FQN="(anonymous namespace)::DFGImpl::includeModuleFiles", NM="_ZNK12_GLOBAL__N_17DFGImpl18includeModuleFilesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZNK12_GLOBAL__N_17DFGImpl18includeModuleFilesEv")
  //</editor-fold>
  public boolean includeModuleFiles() /*const*/ {
    return IncludeModuleFiles;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DFGImpl::~DFGImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 153,
   FQN="(anonymous namespace)::DFGImpl::~DFGImpl", NM="_ZN12_GLOBAL__N_17DFGImplD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN12_GLOBAL__N_17DFGImplD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Targets.$destroy();
    OutputFile.$destroy();
    FilesSet.$destroy();
    Files.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Files=" + Files // NOI18N
              + ", FilesSet=" + FilesSet // NOI18N
              /* STACKOVERFLOW: NEVER PRINT Preprocessor + ", PP=" + PP // NOI18N */
              + ", OutputFile=" + OutputFile // NOI18N
              + ", Targets=" + Targets // NOI18N
              + ", IncludeSystemHeaders=" + IncludeSystemHeaders // NOI18N
              + ", PhonyTarget=" + PhonyTarget // NOI18N
              + ", AddMissingHeaderDeps=" + AddMissingHeaderDeps // NOI18N
              + ", SeenMissingHeader=" + SeenMissingHeader // NOI18N
              + ", IncludeModuleFiles=" + IncludeModuleFiles // NOI18N
              + ", OutputFormat=" + OutputFormat // NOI18N
              + super.toString(); // NOI18N
  }
}
