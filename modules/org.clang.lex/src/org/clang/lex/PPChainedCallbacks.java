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

import org.clang.lex.llvm.ModuleIdPath;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;


/// \brief Simple wrapper class for chaining callbacks.
//<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 324,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 323,
 FQN="clang::PPChainedCallbacks", NM="_ZN5clang18PPChainedCallbacksE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacksE")
//</editor-fold>
public class PPChainedCallbacks extends /*public*/ PPCallbacks implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp", line = 14,
   FQN="clang::PPChainedCallbacks::anchor", NM="_ZN5clang18PPChainedCallbacks6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

  private std.unique_ptr<PPCallbacks> First;
  private std.unique_ptr<PPCallbacks> Second;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::PPChainedCallbacks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 329,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 328,
   FQN="clang::PPChainedCallbacks::PPChainedCallbacks", NM="_ZN5clang18PPChainedCallbacksC1ESt10unique_ptrINS_11PPCallbacksESt14default_deleteIS2_EES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacksC1ESt10unique_ptrINS_11PPCallbacksESt14default_deleteIS2_EES5_")
  //</editor-fold>
  public PPChainedCallbacks(std.unique_ptr<PPCallbacks> _First, 
      std.unique_ptr<PPCallbacks> _Second) {
    /* : PPCallbacks(), First(std::move(_First)), Second(std::move(_Second))*/ 
    //START JInit
    super();
    this.First = new std.unique_ptr<PPCallbacks>(JD$Move.INSTANCE, std.move(_First));
    this.Second = new std.unique_ptr<PPCallbacks>(JD$Move.INSTANCE, std.move(_Second));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::FileChanged">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 333,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 332,
   FQN="clang::PPChainedCallbacks::FileChanged", NM="_ZN5clang18PPChainedCallbacks11FileChangedENS_14SourceLocationENS_11PPCallbacks16FileChangeReasonENS_6SrcMgr18CharacteristicKindENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks11FileChangedENS_14SourceLocationENS_11PPCallbacks16FileChangeReasonENS_6SrcMgr18CharacteristicKindENS_6FileIDE")
  //</editor-fold>
  @Override public void FileChanged(SourceLocation Loc, FileChangeReason Reason, 
             SrcMgr.CharacteristicKind FileType, 
             FileID PrevFID)/* override*/ {
    First.$arrow().FileChanged(/*NO_COPY*/Loc, Reason, FileType, /*NO_COPY*/PrevFID);
    Second.$arrow().FileChanged(/*NO_COPY*/Loc, Reason, FileType, /*NO_COPY*/PrevFID);
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  @Override public void FileGuarded(FileEntry guardedFile, IdentifierInfo IfDefMacro, SourceLocation IfDefMacroLocation, IdentifierInfo DefMacro, SourceLocation DefinedMacroLocation) {
    First.$arrow().FileGuarded(guardedFile, IfDefMacro, IfDefMacroLocation, DefMacro, DefinedMacroLocation);
    Second.$arrow().FileGuarded(guardedFile, IfDefMacro, IfDefMacroLocation, DefMacro, DefinedMacroLocation);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::FileSkipped">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 340,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 339,
   FQN="clang::PPChainedCallbacks::FileSkipped", NM="_ZN5clang18PPChainedCallbacks11FileSkippedERKNS_9FileEntryERKNS_5TokenENS_6SrcMgr18CharacteristicKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks11FileSkippedERKNS_9FileEntryERKNS_5TokenENS_6SrcMgr18CharacteristicKindE")
  //</editor-fold>
  @Override public void FileSkipped(/*const*/ FileEntry /*&*/ SkippedFile, 
             /*const*/ Token /*&*/ FilenameTok, 
             SrcMgr.CharacteristicKind FileType)/* override*/ {
    First.$arrow().FileSkipped(SkippedFile, FilenameTok, FileType);
    Second.$arrow().FileSkipped(SkippedFile, FilenameTok, FileType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::FileNotFound">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 347,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 346,
   FQN="clang::PPChainedCallbacks::FileNotFound", NM="_ZN5clang18PPChainedCallbacks12FileNotFoundEN4llvm9StringRefERNS1_15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks12FileNotFoundEN4llvm9StringRefERNS1_15SmallVectorImplIcEE")
  //</editor-fold>
  @Override public boolean FileNotFound(StringRef FileName, 
              SmallString/*&*/ RecoveryPath,
              vector<DirectoryLookup> SearchedDirs,
              int SearchedFromIndex)/* override*/ {
    return First.$arrow().FileNotFound(/*NO_COPY*/FileName, RecoveryPath, SearchedDirs, SearchedFromIndex)
       || Second.$arrow().FileNotFound(/*NO_COPY*/FileName, RecoveryPath, SearchedDirs, SearchedFromIndex);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::InclusionDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 353,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 352,
   FQN="clang::PPChainedCallbacks::InclusionDirective", NM="_ZN5clang18PPChainedCallbacks18InclusionDirectiveENS_14SourceLocationERKNS_5TokenEN4llvm9StringRefEbNS_15CharSourceRangeEPKNS_9FileEntryES6_S6_PKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks18InclusionDirectiveENS_14SourceLocationERKNS_5TokenEN4llvm9StringRefEbNS_15CharSourceRangeEPKNS_9FileEntryES6_S6_PKNS_6ModuleE")
  //</editor-fold>
  @Override public void InclusionDirective(SourceLocation HashLoc, SourceLocation EodLoc, 
                    /*const*/ Token /*&*/ IncludeTok, 
                    StringRef FileName, boolean IsAngled, 
                    CharSourceRange FilenameRange, /*const*/ FileEntry /*P*/ File, 
                    StringRef SearchPath, StringRef RelativePath, 
                    /*const*/ Module /*P*/ Imported)/* override*/ {
    First.$arrow().InclusionDirective(/*NO_COPY*/HashLoc, /*NO_COPY*/EodLoc, IncludeTok, FileName, IsAngled, 
        /*NO_COPY*/FilenameRange, File, /*NO_COPY*/SearchPath, /*NO_COPY*/RelativePath, 
        Imported);
    Second.$arrow().InclusionDirective(/*NO_COPY*/HashLoc, /*NO_COPY*/EodLoc, IncludeTok, FileName, IsAngled, 
        /*NO_COPY*/FilenameRange, File, /*NO_COPY*/SearchPath, /*NO_COPY*/RelativePath, 
        Imported);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::moduleImport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 366,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 365,
   FQN="clang::PPChainedCallbacks::moduleImport", NM="_ZN5clang18PPChainedCallbacks12moduleImportENS_14SourceLocationEN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoES1_EEEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks12moduleImportENS_14SourceLocationEN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoES1_EEEPKNS_6ModuleE")
  //</editor-fold>
  @Override public void moduleImport(SourceLocation ImportLoc, ModuleIdPath Path, 
              /*const*/ Module /*P*/ Imported)/* override*/ {
    First.$arrow().moduleImport(/*NO_COPY*/ImportLoc, /*NO_COPY*/Path, Imported);
    Second.$arrow().moduleImport(/*NO_COPY*/ImportLoc, /*NO_COPY*/Path, Imported);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::EndOfMainFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 372,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 371,
   FQN="clang::PPChainedCallbacks::EndOfMainFile", NM="_ZN5clang18PPChainedCallbacks13EndOfMainFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks13EndOfMainFileEv")
  //</editor-fold>
  @Override public void EndOfMainFile()/* override*/ {
    First.$arrow().EndOfMainFile();
    Second.$arrow().EndOfMainFile();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::Ident">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 377,
   FQN="clang::PPChainedCallbacks::Ident", NM="_ZN5clang18PPChainedCallbacks5IdentENS_14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks5IdentENS_14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  @Override public void Ident(SourceLocation Loc, StringRef str)/* override*/ {
    First.$arrow().Ident(/*NO_COPY*/Loc, /*NO_COPY*/str);
    Second.$arrow().Ident(/*NO_COPY*/Loc, /*NO_COPY*/str);
  }

  // JAVA: was it forgotten in C++?
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  @Override public void PragmaDirective(SourceLocation Loc, PragmaIntroducerKind Introducer)/* override*/ {
    First.$arrow().PragmaDirective(Loc, Introducer);
    Second.$arrow().PragmaDirective(Loc, Introducer);
  }

  // JAVA: our Callback invoked when read #pragma once directive.
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  @Override public void PragmaOnceDirective(Token once)/* override*/ {
    First.$arrow().PragmaOnceDirective(once);
    Second.$arrow().PragmaOnceDirective(once);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::PragmaComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 382,
   FQN="clang::PPChainedCallbacks::PragmaComment", NM="_ZN5clang18PPChainedCallbacks13PragmaCommentENS_14SourceLocationEPKNS_14IdentifierInfoEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks13PragmaCommentENS_14SourceLocationEPKNS_14IdentifierInfoEN4llvm9StringRefE")
  //</editor-fold>
  @Override public void PragmaComment(SourceLocation Loc, /*const*/ IdentifierInfo /*P*/ Kind, 
               StringRef Str)/* override*/ {
    First.$arrow().PragmaComment(/*NO_COPY*/Loc, Kind, /*NO_COPY*/Str);
    Second.$arrow().PragmaComment(/*NO_COPY*/Loc, Kind, /*NO_COPY*/Str);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::PragmaDetectMismatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 388,
   FQN="clang::PPChainedCallbacks::PragmaDetectMismatch", NM="_ZN5clang18PPChainedCallbacks20PragmaDetectMismatchENS_14SourceLocationEN4llvm9StringRefES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks20PragmaDetectMismatchENS_14SourceLocationEN4llvm9StringRefES3_")
  //</editor-fold>
  @Override public void PragmaDetectMismatch(SourceLocation Loc, StringRef Name, 
                      StringRef Value)/* override*/ {
    First.$arrow().PragmaDetectMismatch(/*NO_COPY*/Loc, /*NO_COPY*/Name, /*NO_COPY*/Value);
    Second.$arrow().PragmaDetectMismatch(/*NO_COPY*/Loc, /*NO_COPY*/Name, /*NO_COPY*/Value);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::PragmaMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 394,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 393,
   FQN="clang::PPChainedCallbacks::PragmaMessage", NM="_ZN5clang18PPChainedCallbacks13PragmaMessageENS_14SourceLocationEN4llvm9StringRefENS_11PPCallbacks17PragmaMessageKindES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks13PragmaMessageENS_14SourceLocationEN4llvm9StringRefENS_11PPCallbacks17PragmaMessageKindES3_")
  //</editor-fold>
  @Override public void PragmaMessage(SourceLocation Loc, StringRef Namespace, 
               PragmaMessageKind Kind, StringRef Str)/* override*/ {
    First.$arrow().PragmaMessage(/*NO_COPY*/Loc, /*NO_COPY*/Namespace, Kind, /*NO_COPY*/Str);
    Second.$arrow().PragmaMessage(/*NO_COPY*/Loc, /*NO_COPY*/Namespace, Kind, /*NO_COPY*/Str);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::PragmaDiagnosticPush">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 400,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 399,
   FQN="clang::PPChainedCallbacks::PragmaDiagnosticPush", NM="_ZN5clang18PPChainedCallbacks20PragmaDiagnosticPushENS_14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks20PragmaDiagnosticPushENS_14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  @Override public void PragmaDiagnosticPush(SourceLocation Loc, StringRef Namespace)/* override*/ {
    First.$arrow().PragmaDiagnosticPush(/*NO_COPY*/Loc, /*NO_COPY*/Namespace);
    Second.$arrow().PragmaDiagnosticPush(/*NO_COPY*/Loc, /*NO_COPY*/Namespace);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::PragmaDiagnosticPop">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 405,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 404,
   FQN="clang::PPChainedCallbacks::PragmaDiagnosticPop", NM="_ZN5clang18PPChainedCallbacks19PragmaDiagnosticPopENS_14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks19PragmaDiagnosticPopENS_14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  @Override public void PragmaDiagnosticPop(SourceLocation Loc, StringRef Namespace)/* override*/ {
    First.$arrow().PragmaDiagnosticPop(/*NO_COPY*/Loc, /*NO_COPY*/Namespace);
    Second.$arrow().PragmaDiagnosticPop(/*NO_COPY*/Loc, /*NO_COPY*/Namespace);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::PragmaDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 410,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 409,
   FQN="clang::PPChainedCallbacks::PragmaDiagnostic", NM="_ZN5clang18PPChainedCallbacks16PragmaDiagnosticENS_14SourceLocationEN4llvm9StringRefENS_4diag8SeverityES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks16PragmaDiagnosticENS_14SourceLocationEN4llvm9StringRefENS_4diag8SeverityES3_")
  //</editor-fold>
  @Override public void PragmaDiagnostic(SourceLocation Loc, StringRef Namespace, 
                  diag.Severity mapping, StringRef Str)/* override*/ {
    First.$arrow().PragmaDiagnostic(/*NO_COPY*/Loc, /*NO_COPY*/Namespace, mapping, /*NO_COPY*/Str);
    Second.$arrow().PragmaDiagnostic(/*NO_COPY*/Loc, /*NO_COPY*/Namespace, mapping, /*NO_COPY*/Str);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::PragmaOpenCLExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 416,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 415,
   FQN="clang::PPChainedCallbacks::PragmaOpenCLExtension", NM="_ZN5clang18PPChainedCallbacks21PragmaOpenCLExtensionENS_14SourceLocationEPKNS_14IdentifierInfoES1_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks21PragmaOpenCLExtensionENS_14SourceLocationEPKNS_14IdentifierInfoES1_j")
  //</editor-fold>
  @Override public void PragmaOpenCLExtension(SourceLocation NameLoc, /*const*/ IdentifierInfo /*P*/ Name, 
                       SourceLocation StateLoc, /*uint*/int State)/* override*/ {
    First.$arrow().PragmaOpenCLExtension(/*NO_COPY*/NameLoc, Name, /*NO_COPY*/StateLoc, State);
    Second.$arrow().PragmaOpenCLExtension(/*NO_COPY*/NameLoc, Name, /*NO_COPY*/StateLoc, State);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::PragmaWarning">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 422,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 421,
   FQN="clang::PPChainedCallbacks::PragmaWarning", NM="_ZN5clang18PPChainedCallbacks13PragmaWarningENS_14SourceLocationEN4llvm9StringRefENS2_8ArrayRefIiEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks13PragmaWarningENS_14SourceLocationEN4llvm9StringRefENS2_8ArrayRefIiEE")
  //</editor-fold>
  @Override public void PragmaWarning(SourceLocation Loc, StringRef WarningSpec, 
               ArrayRefInt Ids)/* override*/ {
    First.$arrow().PragmaWarning(/*NO_COPY*/Loc, /*NO_COPY*/WarningSpec, /*NO_COPY*/Ids);
    Second.$arrow().PragmaWarning(/*NO_COPY*/Loc, /*NO_COPY*/WarningSpec, /*NO_COPY*/Ids);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::PragmaWarningPush">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 428,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 427,
   FQN="clang::PPChainedCallbacks::PragmaWarningPush", NM="_ZN5clang18PPChainedCallbacks17PragmaWarningPushENS_14SourceLocationEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks17PragmaWarningPushENS_14SourceLocationEi")
  //</editor-fold>
  @Override public void PragmaWarningPush(SourceLocation Loc, int Level)/* override*/ {
    First.$arrow().PragmaWarningPush(/*NO_COPY*/Loc, Level);
    Second.$arrow().PragmaWarningPush(/*NO_COPY*/Loc, Level);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::PragmaWarningPop">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 433,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 432,
   FQN="clang::PPChainedCallbacks::PragmaWarningPop", NM="_ZN5clang18PPChainedCallbacks16PragmaWarningPopENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks16PragmaWarningPopENS_14SourceLocationE")
  //</editor-fold>
  @Override public void PragmaWarningPop(SourceLocation Loc)/* override*/ {
    First.$arrow().PragmaWarningPop(/*NO_COPY*/Loc);
    Second.$arrow().PragmaWarningPop(/*NO_COPY*/Loc);
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  @Override public /*virtual*/ boolean UserDiagnostic(SourceLocation HashLoc, SourceLocation EodLoc,
          /*const*/Token /*&*/ Tok, StringRef Msg, boolean isWarning) {
    boolean UserDiagnostic1 = First.$arrow().UserDiagnostic(HashLoc, EodLoc, Tok, Msg, isWarning);
    boolean UserDiagnostic2 = Second.$arrow().UserDiagnostic(HashLoc, EodLoc, Tok, Msg, isWarning);
    return UserDiagnostic1 || UserDiagnostic2;
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::MacroExpands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 438,
   FQN="clang::PPChainedCallbacks::MacroExpands", NM="_ZN5clang18PPChainedCallbacks12MacroExpandsERKNS_5TokenERKNS_15MacroDefinitionENS_11SourceRangeEPKNS_9MacroArgsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks12MacroExpandsERKNS_5TokenERKNS_15MacroDefinitionENS_11SourceRangeEPKNS_9MacroArgsE")
  //</editor-fold>
  @Override public void MacroExpands(/*const*/ Token /*&*/ MacroNameTok, /*const*/ MacroDefinition /*&*/ MD, 
              SourceRange Range, /*const*/ MacroArgs /*P*/ Args)/* override*/ {
    First.$arrow().MacroExpands(MacroNameTok, MD, /*NO_COPY*/Range, Args);
    Second.$arrow().MacroExpands(MacroNameTok, MD, /*NO_COPY*/Range, Args);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::MacroDefined">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 444,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 443,
   FQN="clang::PPChainedCallbacks::MacroDefined", NM="_ZN5clang18PPChainedCallbacks12MacroDefinedERKNS_5TokenEPKNS_14MacroDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks12MacroDefinedERKNS_5TokenEPKNS_14MacroDirectiveE")
  //</editor-fold>
  @Override public void MacroDefined(SourceLocation HashLoc, SourceLocation EodLoc,
          /*const*/ Token /*&*/ MacroNameTok, /*const*/ MacroDirective /*P*/ MD)/* override*/ {
    First.$arrow().MacroDefined(HashLoc, EodLoc, MacroNameTok, MD);
    Second.$arrow().MacroDefined(HashLoc, EodLoc, MacroNameTok, MD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::MacroUndefined">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 449,
   FQN="clang::PPChainedCallbacks::MacroUndefined", NM="_ZN5clang18PPChainedCallbacks14MacroUndefinedERKNS_5TokenERKNS_15MacroDefinitionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks14MacroUndefinedERKNS_5TokenERKNS_15MacroDefinitionE")
  //</editor-fold>
  @Override public void MacroUndefined(SourceLocation HashLoc, SourceLocation EodLoc, 
          /*const*/ Token /*&*/ MacroNameTok, 
          /*const*/ MacroDefinition /*&*/ MD)/* override*/ {
    First.$arrow().MacroUndefined(HashLoc, EodLoc, MacroNameTok, MD);
    Second.$arrow().MacroUndefined(HashLoc, EodLoc, MacroNameTok, MD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::Defined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 455,
   FQN="clang::PPChainedCallbacks::Defined", NM="_ZN5clang18PPChainedCallbacks7DefinedERKNS_5TokenERKNS_15MacroDefinitionENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks7DefinedERKNS_5TokenERKNS_15MacroDefinitionENS_11SourceRangeE")
  //</editor-fold>
  @Override public void Defined(/*const*/ Token /*&*/ MacroNameTok, /*const*/ MacroDefinition /*&*/ MD, 
         SourceRange Range)/* override*/ {
    First.$arrow().Defined(MacroNameTok, MD, /*NO_COPY*/Range);
    Second.$arrow().Defined(MacroNameTok, MD, /*NO_COPY*/Range);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::SourceRangeSkipped">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 461,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 460,
   FQN="clang::PPChainedCallbacks::SourceRangeSkipped", NM="_ZN5clang18PPChainedCallbacks18SourceRangeSkippedENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks18SourceRangeSkippedENS_11SourceRangeE")
  //</editor-fold>
  @Override public void SourceRangeSkipped(SourceRange Range)/* override*/ {
    First.$arrow().SourceRangeSkipped(/*NO_COPY*/Range);
    Second.$arrow().SourceRangeSkipped(/*NO_COPY*/Range);
  }

  
  /// \brief Hook called whenever an \#if is seen.
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::If">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 467,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 466,
   FQN="clang::PPChainedCallbacks::If", NM="_ZN5clang18PPChainedCallbacks2IfENS_14SourceLocationENS_11SourceRangeENS_11PPCallbacks18ConditionValueKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks2IfENS_14SourceLocationENS_11SourceRangeENS_11PPCallbacks18ConditionValueKindE")
  //</editor-fold>
  @Override public void If(SourceLocation HashLoc, SourceLocation EodLoc, 
          SourceLocation Loc, SourceRange ConditionRange, 
          ConditionValueKind ConditionValue)/* override*/ {
    First.$arrow().If(/*NO_COPY*/HashLoc, /*NO_COPY*/EodLoc, /*NO_COPY*/Loc, /*NO_COPY*/ConditionRange, ConditionValue);
    Second.$arrow().If(/*NO_COPY*/HashLoc, /*NO_COPY*/EodLoc, /*NO_COPY*/Loc, /*NO_COPY*/ConditionRange, ConditionValue);
  }

  
  /// \brief Hook called whenever an \#elif is seen.
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::Elif">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 474,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 473,
   FQN="clang::PPChainedCallbacks::Elif", NM="_ZN5clang18PPChainedCallbacks4ElifENS_14SourceLocationENS_11SourceRangeENS_11PPCallbacks18ConditionValueKindES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks4ElifENS_14SourceLocationENS_11SourceRangeENS_11PPCallbacks18ConditionValueKindES1_")
  //</editor-fold>
  @Override public void Elif(SourceLocation HashLoc, SourceLocation EodLoc, 
          SourceLocation Loc, SourceRange ConditionRange, 
          ConditionValueKind ConditionValue, SourceLocation IfLoc)/* override*/ {
    First.$arrow().Elif(/*NO_COPY*/HashLoc, /*NO_COPY*/EodLoc, /*NO_COPY*/Loc, /*NO_COPY*/ConditionRange, ConditionValue, /*NO_COPY*/IfLoc);
    Second.$arrow().Elif(/*NO_COPY*/HashLoc, /*NO_COPY*/EodLoc, /*NO_COPY*/Loc, /*NO_COPY*/ConditionRange, ConditionValue, /*NO_COPY*/IfLoc);
  }

  
  /// \brief Hook called whenever an \#ifdef is seen.
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::Ifdef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 481,
   FQN="clang::PPChainedCallbacks::Ifdef", NM="_ZN5clang18PPChainedCallbacks5IfdefENS_14SourceLocationERKNS_5TokenERKNS_15MacroDefinitionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks5IfdefENS_14SourceLocationERKNS_5TokenERKNS_15MacroDefinitionE")
  //</editor-fold>
  @Override public void Ifdef(SourceLocation HashLoc, SourceLocation EodLoc,
          SourceLocation Loc, /*const*/ Token /*&*/ MacroNameTok, 
          /*const*/ MacroDefinition /*&*/ MD)/* override*/ {
    First.$arrow().Ifdef(HashLoc, EodLoc, /*NO_COPY*/Loc, MacroNameTok, MD);
    Second.$arrow().Ifdef(HashLoc, EodLoc, /*NO_COPY*/Loc, MacroNameTok, MD);
  }

  
  /// \brief Hook called whenever an \#ifndef is seen.
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::Ifndef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 488,
   FQN="clang::PPChainedCallbacks::Ifndef", NM="_ZN5clang18PPChainedCallbacks6IfndefENS_14SourceLocationERKNS_5TokenERKNS_15MacroDefinitionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks6IfndefENS_14SourceLocationERKNS_5TokenERKNS_15MacroDefinitionE")
  //</editor-fold>
  @Override public void Ifndef(SourceLocation HashLoc, SourceLocation EodLoc, 
          SourceLocation Loc, /*const*/ Token /*&*/ MacroNameTok, 
        /*const*/ MacroDefinition /*&*/ MD)/* override*/ {
    First.$arrow().Ifndef(HashLoc, EodLoc, /*NO_COPY*/Loc, MacroNameTok, MD);
    Second.$arrow().Ifndef(HashLoc, EodLoc, /*NO_COPY*/Loc, MacroNameTok, MD);
  }

  
  /// \brief Hook called whenever an \#else is seen.
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::Else">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 495,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 494,
   FQN="clang::PPChainedCallbacks::Else", NM="_ZN5clang18PPChainedCallbacks4ElseENS_14SourceLocationES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks4ElseENS_14SourceLocationES1_")
  //</editor-fold>
  @Override public void Else(SourceLocation HashLoc, SourceLocation EodLoc,
          SourceLocation Loc, SourceLocation IfLoc)/* override*/ {
    First.$arrow().Else(HashLoc, EodLoc, /*NO_COPY*/Loc, /*NO_COPY*/IfLoc);
    Second.$arrow().Else(HashLoc, EodLoc, /*NO_COPY*/Loc, /*NO_COPY*/IfLoc);
  }

  
  /// \brief Hook called whenever an \#endif is seen.
  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::Endif">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 501,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 500,
   FQN="clang::PPChainedCallbacks::Endif", NM="_ZN5clang18PPChainedCallbacks5EndifENS_14SourceLocationES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacks5EndifENS_14SourceLocationES1_")
  //</editor-fold>
  @Override public void Endif(SourceLocation HashLoc, SourceLocation EodLoc,
          SourceLocation Loc, SourceLocation IfLoc)/* override*/ {
    First.$arrow().Endif(HashLoc, EodLoc, /*NO_COPY*/Loc, /*NO_COPY*/IfLoc);
    Second.$arrow().Endif(HashLoc, EodLoc, /*NO_COPY*/Loc, /*NO_COPY*/IfLoc);
  }

  // JAVA: default implementation of Java specific method
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  @Override public void DeepFileInclusion(SourceLocation HashLoc, SourceLocation EodLoc,
          Token IncludeTok, StringRef FileName, boolean IsAngled, CharSourceRange FilenameRange) {
    First.$arrow().DeepFileInclusion(HashLoc, EodLoc, IncludeTok, FileName, IsAngled, FilenameRange);
    Second.$arrow().DeepFileInclusion(HashLoc, EodLoc, IncludeTok, FileName, IsAngled, FilenameRange);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PPChainedCallbacks::~PPChainedCallbacks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 324,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 323,
   FQN="clang::PPChainedCallbacks::~PPChainedCallbacks", NM="_ZN5clang18PPChainedCallbacksD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang18PPChainedCallbacksD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Second.$destroy();
    First.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "First=" + First // NOI18N
              + ", Second=" + Second // NOI18N
              + super.toString(); // NOI18N
  }
}
