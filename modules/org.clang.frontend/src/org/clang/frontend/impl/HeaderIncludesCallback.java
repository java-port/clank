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
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.frontend.*;
import static org.clang.frontend.impl.HeaderIncludeGenStatics.PrintHeaderInfo;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HeaderIncludesCallback">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/HeaderIncludeGen.cpp", line = 20,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/HeaderIncludeGen.cpp", old_line = 19,
 FQN="(anonymous namespace)::HeaderIncludesCallback", NM="_ZN12_GLOBAL__N_122HeaderIncludesCallbackE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/HeaderIncludeGen.cpp -nm=_ZN12_GLOBAL__N_122HeaderIncludesCallbackE")
//</editor-fold>
public class HeaderIncludesCallback extends /*public*/ PPCallbacks implements Destructors.ClassWithDestructor {
  private SourceManager /*&*/ SM;
  private raw_ostream /*P*/ OutputFile;
  private /*const*/ DependencyOutputOptions /*&*/ DepOpts;
  private /*uint*/int CurrentIncludeDepth;
  private boolean HasProcessedPredefines;
  private boolean OwnsOutputFile;
  private boolean ShowAllHeaders;
  private boolean ShowDepth;
  private boolean MSStyle;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HeaderIncludesCallback::HeaderIncludesCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/HeaderIncludeGen.cpp", line = 32,
   FQN="(anonymous namespace)::HeaderIncludesCallback::HeaderIncludesCallback", NM="_ZN12_GLOBAL__N_122HeaderIncludesCallbackC1EPKN5clang12PreprocessorEbPN4llvm11raw_ostreamERKNS1_23DependencyOutputOptionsEbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/HeaderIncludeGen.cpp -nm=_ZN12_GLOBAL__N_122HeaderIncludesCallbackC1EPKN5clang12PreprocessorEbPN4llvm11raw_ostreamERKNS1_23DependencyOutputOptionsEbbb")
  //</editor-fold>
  public HeaderIncludesCallback(/*const*/ Preprocessor /*P*/ PP, boolean ShowAllHeaders_, 
      raw_ostream /*P*/ OutputFile_, 
      /*const*/ DependencyOutputOptions /*&*/ DepOpts, 
      boolean OwnsOutputFile_, boolean ShowDepth_, boolean MSStyle_) {
    // : PPCallbacks(), SM(PP->getSourceManager()), OutputFile(OutputFile_), DepOpts(DepOpts), CurrentIncludeDepth(0), HasProcessedPredefines(false), OwnsOutputFile(OwnsOutputFile_), ShowAllHeaders(ShowAllHeaders_), ShowDepth(ShowDepth_), MSStyle(MSStyle_) 
    //START JInit
    super();
    this./*&*/SM=/*&*/PP.getSourceManager();
    this.OutputFile = OutputFile_;
    this./*&*/DepOpts=/*&*/DepOpts;
    this.CurrentIncludeDepth = 0;
    this.HasProcessedPredefines = false;
    this.OwnsOutputFile = OwnsOutputFile_;
    this.ShowAllHeaders = ShowAllHeaders_;
    this.ShowDepth = ShowDepth_;
    this.MSStyle = MSStyle_;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HeaderIncludesCallback::~HeaderIncludesCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/HeaderIncludeGen.cpp", line = 41,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/HeaderIncludeGen.cpp", old_line = 38,
   FQN="(anonymous namespace)::HeaderIncludesCallback::~HeaderIncludesCallback", NM="_ZN12_GLOBAL__N_122HeaderIncludesCallbackD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/HeaderIncludeGen.cpp -nm=_ZN12_GLOBAL__N_122HeaderIncludesCallbackD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    if (OwnsOutputFile) {
      if (OutputFile != null) { OutputFile.$destroy();};
    }
    super.$destroy();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HeaderIncludesCallback::FileChanged">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/HeaderIncludeGen.cpp", line = 114,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/HeaderIncludeGen.cpp", old_line = 116,
   FQN="(anonymous namespace)::HeaderIncludesCallback::FileChanged", NM="_ZN12_GLOBAL__N_122HeaderIncludesCallback11FileChangedEN5clang14SourceLocationENS1_11PPCallbacks16FileChangeReasonENS1_6SrcMgr18CharacteristicKindENS1_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/HeaderIncludeGen.cpp -nm=_ZN12_GLOBAL__N_122HeaderIncludesCallback11FileChangedEN5clang14SourceLocationENS1_11PPCallbacks16FileChangeReasonENS1_6SrcMgr18CharacteristicKindENS1_6FileIDE")
  //</editor-fold>
  @Override public void FileChanged(SourceLocation Loc, 
             FileChangeReason Reason, 
             SrcMgr.CharacteristicKind NewFileType, 
             FileID PrevFID)/* override*/ {
    // Unless we are exiting a #include, make sure to skip ahead to the line the
    // #include directive was at.
    PresumedLoc UserLoc = SM.getPresumedLoc(/*NO_COPY*/Loc);
    if (UserLoc.isInvalid()) {
      return;
    }
    
    // Adjust the current include depth.
    if (Reason == PPCallbacks.FileChangeReason.EnterFile) {
      ++CurrentIncludeDepth;
    } else if (Reason == PPCallbacks.FileChangeReason.ExitFile) {
      if ((CurrentIncludeDepth != 0)) {
        --CurrentIncludeDepth;
      }
      
      // We track when we are done with the predefines by watching for the first
      // place where we drop back to a nesting depth of 1.
      if (CurrentIncludeDepth == 1 && !HasProcessedPredefines) {
        if (!DepOpts.ShowIncludesPretendHeader.empty()) {
          PrintHeaderInfo(OutputFile, new StringRef(DepOpts.ShowIncludesPretendHeader), 
              ShowDepth, 2, MSStyle);
        }
        HasProcessedPredefines = true;
      }
      
      return;
    } else {
      return;
    }
    
    // Show the header if we are (a) past the predefines, or (b) showing all
    // headers and in the predefines at a depth past the initial file and command
    // line buffers.
    boolean ShowHeader = (HasProcessedPredefines
       || (ShowAllHeaders && $greater_uint(CurrentIncludeDepth, 2)));
    /*uint*/int IncludeDepth = CurrentIncludeDepth;
    if (!HasProcessedPredefines) {
      --IncludeDepth; // Ignore indent from <built-in>.
    } else if (!DepOpts.ShowIncludesPretendHeader.empty()) {
      ++IncludeDepth; // Pretend inclusion by ShowIncludesPretendHeader.
    }
    
    // Dump the header include information we are past the predefines buffer or
    // are showing all headers and this isn't the magic implicit <command line>
    // header.
    // FIXME: Identify headers in a more robust way than comparing their name to
    // "<command line>" and "<built-in>" in a bunch of places.
    if (ShowHeader && Reason == PPCallbacks.FileChangeReason.EnterFile
       && $noteq_StringRef(/*STRINGREF_STR*/UserLoc.getFilename(), /*STRINGREF_STR*/"<command line>")) {
      PrintHeaderInfo(OutputFile, new StringRef(UserLoc.getFilename()), ShowDepth, IncludeDepth, 
          MSStyle);
    }
  }

  
  @Override public String toString() {
    return "" + "SM=" + SM // NOI18N
              + ", OutputFile=" + OutputFile // NOI18N
              + ", DepOpts=" + DepOpts // NOI18N
              + ", CurrentIncludeDepth=" + CurrentIncludeDepth // NOI18N
              + ", HasProcessedPredefines=" + HasProcessedPredefines // NOI18N
              + ", OwnsOutputFile=" + OwnsOutputFile // NOI18N
              + ", ShowAllHeaders=" + ShowAllHeaders // NOI18N
              + ", ShowDepth=" + ShowDepth // NOI18N
              + ", MSStyle=" + MSStyle // NOI18N
              + super.toString(); // NOI18N
  }
}
