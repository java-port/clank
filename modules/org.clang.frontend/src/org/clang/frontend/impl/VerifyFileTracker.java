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
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.frontend.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifyFileTracker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 51,
 FQN="(anonymous namespace)::VerifyFileTracker", NM="_ZN12_GLOBAL__N_117VerifyFileTrackerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN12_GLOBAL__N_117VerifyFileTrackerE")
//</editor-fold>
public class VerifyFileTracker extends /*public*/ PPCallbacks implements Destructors.ClassWithDestructor {
  private VerifyDiagnosticConsumer /*&*/ Verify;
  private SourceManager /*&*/ SM;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifyFileTracker::VerifyFileTracker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 56,
   FQN="(anonymous namespace)::VerifyFileTracker::VerifyFileTracker", NM="_ZN12_GLOBAL__N_117VerifyFileTrackerC1ERN5clang24VerifyDiagnosticConsumerERNS1_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN12_GLOBAL__N_117VerifyFileTrackerC1ERN5clang24VerifyDiagnosticConsumerERNS1_13SourceManagerE")
  //</editor-fold>
  public VerifyFileTracker(VerifyDiagnosticConsumer /*&*/ Verify, SourceManager /*&*/ SM) {
    // : PPCallbacks(), Verify(Verify), SM(SM) 
    //START JInit
    super();
    this./*&*/Verify=/*&*/Verify;
    this./*&*/SM=/*&*/SM;
    //END JInit
  }

  
  /// \brief Hook into the preprocessor and update the list of parsed
  /// files when the preprocessor indicates a new file is entered.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifyFileTracker::FileChanged">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 61,
   FQN="(anonymous namespace)::VerifyFileTracker::FileChanged", NM="_ZN12_GLOBAL__N_117VerifyFileTracker11FileChangedEN5clang14SourceLocationENS1_11PPCallbacks16FileChangeReasonENS1_6SrcMgr18CharacteristicKindENS1_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN12_GLOBAL__N_117VerifyFileTracker11FileChangedEN5clang14SourceLocationENS1_11PPCallbacks16FileChangeReasonENS1_6SrcMgr18CharacteristicKindENS1_6FileIDE")
  //</editor-fold>
  @Override public void FileChanged(SourceLocation Loc, FileChangeReason Reason, 
             SrcMgr.CharacteristicKind FileType, 
             FileID PrevFID)/* override*/ {
    Verify.UpdateParsedFileStatus(SM, SM.getFileID(/*NO_COPY*/Loc), 
        VerifyDiagnosticConsumer.ParsedStatus.IsParsed);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifyFileTracker::~VerifyFileTracker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 51,
   FQN="(anonymous namespace)::VerifyFileTracker::~VerifyFileTracker", NM="_ZN12_GLOBAL__N_117VerifyFileTrackerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN12_GLOBAL__N_117VerifyFileTrackerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Verify=" + Verify // NOI18N
              /* STACKOVERFLOW: NEVER PRINT SourceManager + ", SM=" + SM // NOI18N*/
              + super.toString(); // NOI18N
  }
}
