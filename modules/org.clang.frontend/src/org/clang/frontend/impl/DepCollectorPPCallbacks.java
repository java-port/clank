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

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.frontend.*;
import org.llvm.support.sys.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DepCollectorPPCallbacks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 34,
 FQN="(anonymous namespace)::DepCollectorPPCallbacks", NM="_ZN12_GLOBAL__N_123DepCollectorPPCallbacksE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN12_GLOBAL__N_123DepCollectorPPCallbacksE")
//</editor-fold>
public class/*struct*/ DepCollectorPPCallbacks extends /*public*/ PPCallbacks implements Destructors.ClassWithDestructor {
  public DependencyCollector /*&*/ DepCollector;
  public SourceManager /*&*/ SM;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DepCollectorPPCallbacks::DepCollectorPPCallbacks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 37,
   FQN="(anonymous namespace)::DepCollectorPPCallbacks::DepCollectorPPCallbacks", NM="_ZN12_GLOBAL__N_123DepCollectorPPCallbacksC1ERN5clang19DependencyCollectorERNS1_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN12_GLOBAL__N_123DepCollectorPPCallbacksC1ERN5clang19DependencyCollectorERNS1_13SourceManagerE")
  //</editor-fold>
  public DepCollectorPPCallbacks(DependencyCollector /*&*/ L, SourceManager /*&*/ SM) {
    // : PPCallbacks(), DepCollector(L), SM(SM) 
    //START JInit
    super();
    this./*&*/DepCollector=/*&*/L;
    this./*&*/SM=/*&*/SM;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DepCollectorPPCallbacks::FileChanged">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 40,
   FQN="(anonymous namespace)::DepCollectorPPCallbacks::FileChanged", NM="_ZN12_GLOBAL__N_123DepCollectorPPCallbacks11FileChangedEN5clang14SourceLocationENS1_11PPCallbacks16FileChangeReasonENS1_6SrcMgr18CharacteristicKindENS1_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN12_GLOBAL__N_123DepCollectorPPCallbacks11FileChangedEN5clang14SourceLocationENS1_11PPCallbacks16FileChangeReasonENS1_6SrcMgr18CharacteristicKindENS1_6FileIDE")
  //</editor-fold>
  @Override public void FileChanged(SourceLocation Loc, FileChangeReason Reason, 
             SrcMgr.CharacteristicKind FileType, 
             FileID PrevFID)/* override*/ {
    if (Reason != PPCallbacks.FileChangeReason.EnterFile) {
      return;
    }
    
    // Dependency generation really does want to go all the way to the
    // file entry for a source location to find out what is depended on.
    // We do not want #line markers to affect dependency generation!
    /*const*/ FileEntry /*P*/ FE = SM.getFileEntryForID(SM.getFileID(SM.getExpansionLoc(/*NO_COPY*/Loc)));
    if (!(FE != null)) {
      return;
    }
    
    StringRef Filename = path.remove_leading_dotslash(new StringRef(FE.getName()));
    
    DepCollector.maybeAddDependency(new StringRef(Filename), /*FromModule*/ false, 
        FileType != SrcMgr.CharacteristicKind.C_User, 
        /*IsModuleFile*/ false, /*IsMissing*/ false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DepCollectorPPCallbacks::InclusionDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 62,
   FQN="(anonymous namespace)::DepCollectorPPCallbacks::InclusionDirective", NM="_ZN12_GLOBAL__N_123DepCollectorPPCallbacks18InclusionDirectiveEN5clang14SourceLocationERKNS1_5TokenEN4llvm9StringRefEbNS1_15CharSourceRangeEPKNS1_9FileEntryES7_S7_PKNS1_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN12_GLOBAL__N_123DepCollectorPPCallbacks18InclusionDirectiveEN5clang14SourceLocationERKNS1_5TokenEN4llvm9StringRefEbNS1_15CharSourceRangeEPKNS1_9FileEntryES7_S7_PKNS1_6ModuleE")
  //</editor-fold>
  @Override public void InclusionDirective(SourceLocation HashLoc, /*JAVA*/SourceLocation EodLoc, /*const*/ Token /*&*/ IncludeTok, 
                    StringRef FileName, boolean IsAngled, 
                    CharSourceRange FilenameRange, /*const*/ FileEntry /*P*/ File, 
                    StringRef SearchPath, StringRef RelativePath, 
                    /*const*/ Module /*P*/ Imported)/* override*/ {
    if (!(File != null)) {
      DepCollector.maybeAddDependency(new StringRef(FileName), /*FromModule*/ false, 
          /*IsSystem*/ false, /*IsModuleFile*/ false, 
          /*IsMissing*/ true);
    }
    // Files that actually exist are handled by FileChanged.
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DepCollectorPPCallbacks::EndOfMainFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 74,
   FQN="(anonymous namespace)::DepCollectorPPCallbacks::EndOfMainFile", NM="_ZN12_GLOBAL__N_123DepCollectorPPCallbacks13EndOfMainFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN12_GLOBAL__N_123DepCollectorPPCallbacks13EndOfMainFileEv")
  //</editor-fold>
  @Override public void EndOfMainFile()/* override*/ {
    DepCollector.finishedMainFile();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DepCollectorPPCallbacks::~DepCollectorPPCallbacks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 34,
   FQN="(anonymous namespace)::DepCollectorPPCallbacks::~DepCollectorPPCallbacks", NM="_ZN12_GLOBAL__N_123DepCollectorPPCallbacksD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN12_GLOBAL__N_123DepCollectorPPCallbacksD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "DepCollector=" + DepCollector // NOI18N
              + ", SM=" + SM // NOI18N
              + super.toString(); // NOI18N
  }
}
