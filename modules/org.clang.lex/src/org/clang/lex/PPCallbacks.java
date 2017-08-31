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
import org.clank.support.*;
import static org.clank.java.std.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;


/// \brief This interface provides a way to observe the actions of the
/// preprocessor as it does its thing.
///
/// Clients can define their hooks here to implement preprocessor level tools.
//<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 38,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 37,
 FQN="clang::PPCallbacks", NM="_ZN5clang11PPCallbacksE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacksE")
//</editor-fold>
public class PPCallbacks implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::~PPCallbacks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", line = 28,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", old_line = 27,
   FQN="clang::PPCallbacks::~PPCallbacks", NM="_ZN5clang11PPCallbacksD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacksD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::FileChangeReason">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 42,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 41,
   FQN="clang::PPCallbacks::FileChangeReason", NM="_ZN5clang11PPCallbacks16FileChangeReasonE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks16FileChangeReasonE")
  //</editor-fold>
  public enum FileChangeReason implements Native.ComparableLower {
    EnterFile(0),
    ExitFile(EnterFile.getValue() + 1),
    SystemHeaderPragma(ExitFile.getValue() + 1),
    RenameFile(SystemHeaderPragma.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static FileChangeReason valueOf(int val) {
      FileChangeReason out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final FileChangeReason[] VALUES;
      private static final FileChangeReason[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (FileChangeReason kind : FileChangeReason.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new FileChangeReason[min < 0 ? (1-min) : 0];
        VALUES = new FileChangeReason[max >= 0 ? (1+max) : 0];
        for (FileChangeReason kind : FileChangeReason.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private FileChangeReason(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((FileChangeReason)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((FileChangeReason)obj).value);}
    //</editor-fold>
  };
  
  private static final FileID NoFileID = new FileID();
  
  /// \brief Callback invoked whenever a source file is entered or exited.
  ///
  /// \param Loc Indicates the new location.
  /// \param PrevFID the file that was exited if \p Reason is ExitFile.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::FileChanged">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 50,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 49,
   FQN="clang::PPCallbacks::FileChanged", NM="_ZN5clang11PPCallbacks11FileChangedENS_14SourceLocationENS0_16FileChangeReasonENS_6SrcMgr18CharacteristicKindENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks11FileChangedENS_14SourceLocationENS0_16FileChangeReasonENS_6SrcMgr18CharacteristicKindENS_6FileIDE")
  //</editor-fold>
  public /*virtual*/ final void FileChanged(SourceLocation Loc, FileChangeReason Reason, 
          SrcMgr.CharacteristicKind FileType) {
    FileChanged(Loc, Reason, 
            FileType, 
            NoFileID);
  }
  public /*virtual*/ void FileChanged(SourceLocation Loc, FileChangeReason Reason, 
          SrcMgr.CharacteristicKind FileType, 
          FileID PrevFID/*= FileID()*/) {
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public /*virtual*/ void FileGuarded(/*const*/FileEntry /*P*/ guardedFile,
          IdentifierInfo IfDefMacro, SourceLocation IfDefMacroLocation,
        IdentifierInfo DefMacro, SourceLocation DefinedMacroLocation) {
  }

  /// \brief Callback invoked whenever a source file is skipped as the result
  /// of header guard optimization.
  ///
  /// \param SkippedFile The file that is skipped instead of entering \#include
  ///
  /// \param FilenameTok The file name token in \#include "FileName" directive
  /// or macro expanded file name token from \#include MACRO(PARAMS) directive.
  /// Note that FilenameTok contains corresponding quotes/angles symbols.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::FileSkipped">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 63,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 61,
   FQN="clang::PPCallbacks::FileSkipped", NM="_ZN5clang11PPCallbacks11FileSkippedERKNS_9FileEntryERKNS_5TokenENS_6SrcMgr18CharacteristicKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks11FileSkippedERKNS_9FileEntryERKNS_5TokenENS_6SrcMgr18CharacteristicKindE")
  //</editor-fold>
  public /*virtual*/ void FileSkipped(/*const*/ FileEntry /*&*/ SkippedFile, 
             /*const*/ Token /*&*/ FilenameTok, 
             SrcMgr.CharacteristicKind FileType) {
  }

  
  /// \brief Callback invoked whenever an inclusion directive results in a
  /// file-not-found error.
  ///
  /// \param FileName The name of the file being included, as written in the 
  /// source code.
  ///
  /// \param RecoveryPath If this client indicates that it can recover from 
  /// this missing file, the client should set this as an additional header
  /// search patch.
  ///
  /// \returns true to indicate that the preprocessor should attempt to recover
  /// by adding \p RecoveryPath as a header search path.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::FileNotFound">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 80,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 78,
   FQN="clang::PPCallbacks::FileNotFound", NM="_ZN5clang11PPCallbacks12FileNotFoundEN4llvm9StringRefERNS1_15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks12FileNotFoundEN4llvm9StringRefERNS1_15SmallVectorImplIcEE")
  //</editor-fold>
  public /*virtual*/ boolean FileNotFound(StringRef FileName, 
          SmallString/*&*/ RecoveryPath,
          /*MANUAL_SEMANTIC*/vector<DirectoryLookup> SearchedDirs, int SearchedFromIndex) {
    return false;
  }

  
  /// \brief Callback invoked whenever an inclusion directive of
  /// any kind (\c \#include, \c \#import, etc.) has been processed, regardless
  /// of whether the inclusion will actually result in an inclusion.
  ///
  /// \param HashLoc The location of the '#' that starts the inclusion 
  /// directive.
  ///
  /// \param IncludeTok The token that indicates the kind of inclusion 
  /// directive, e.g., 'include' or 'import'.
  ///
  /// \param FileName The name of the file being included, as written in the 
  /// source code.
  ///
  /// \param IsAngled Whether the file name was enclosed in angle brackets;
  /// otherwise, it was enclosed in quotes.
  ///
  /// \param FilenameRange The character range of the quotes or angle brackets
  /// for the written file name.
  ///
  /// \param File The actual file that may be included by this inclusion 
  /// directive.
  ///
  /// \param SearchPath Contains the search path which was used to find the file
  /// in the file system. If the file was found via an absolute include path,
  /// SearchPath will be empty. For framework includes, the SearchPath and
  /// RelativePath will be split up. For example, if an include of "Some/Some.h"
  /// is found via the framework path
  /// "path/to/Frameworks/Some.framework/Headers/Some.h", SearchPath will be
  /// "path/to/Frameworks/Some.framework/Headers" and RelativePath will be
  /// "Some.h".
  ///
  /// \param RelativePath The path relative to SearchPath, at which the include
  /// file was found. This is equal to FileName except for framework includes.
  ///
  /// \param Imported The module, whenever an inclusion directive was
  /// automatically turned into a module import or null otherwise.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::InclusionDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 122,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 120,
   FQN="clang::PPCallbacks::InclusionDirective", NM="_ZN5clang11PPCallbacks18InclusionDirectiveENS_14SourceLocationERKNS_5TokenEN4llvm9StringRefEbNS_15CharSourceRangeEPKNS_9FileEntryES6_S6_PKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks18InclusionDirectiveENS_14SourceLocationERKNS_5TokenEN4llvm9StringRefEbNS_15CharSourceRangeEPKNS_9FileEntryES6_S6_PKNS_6ModuleE")
  //</editor-fold>
  public /*virtual*/ void InclusionDirective(SourceLocation HashLoc, /*JAVA*/SourceLocation EodLoc, 
          /*const*/ Token /*&*/ IncludeTok,
          StringRef FileName, 
          boolean IsAngled, 
          CharSourceRange FilenameRange,
          /*const*/ FileEntry /*P*/ File, 
          StringRef SearchPath, 
          StringRef RelativePath, 
          /*const*/ Module /*P*/ Imported) {
  }
  
  
  /// \brief Callback invoked whenever there was an explicit module-import
  /// syntax.
  ///
  /// \param ImportLoc The location of import directive token.
  ///
  /// \param Path The identifiers (and their locations) of the module
  /// "path", e.g., "std.vector" would be split into "std" and "vector".
  ///
  /// \param Imported The imported module; can be null if importing failed.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::moduleImport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 143,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 141,
   FQN="clang::PPCallbacks::moduleImport", NM="_ZN5clang11PPCallbacks12moduleImportENS_14SourceLocationEN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoES1_EEEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks12moduleImportENS_14SourceLocationEN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoES1_EEEPKNS_6ModuleE")
  //</editor-fold>
  public /*virtual*/ void moduleImport(SourceLocation ImportLoc, 
          ModuleIdPath Path, 
          /*const*/ Module /*P*/ Imported) {
  }

  
  /// \brief Callback invoked when the end of the main file is reached.
  ///
  /// No subsequent callbacks will be made.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::EndOfMainFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 151,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 149,
   FQN="clang::PPCallbacks::EndOfMainFile", NM="_ZN5clang11PPCallbacks13EndOfMainFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks13EndOfMainFileEv")
  //</editor-fold>
  public /*virtual*/ void EndOfMainFile() {
  }

  
  /// \brief Callback invoked when a \#ident or \#sccs directive is read.
  /// \param Loc The location of the directive.
  /// \param str The text of the directive.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::Ident">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 158,
   FQN="clang::PPCallbacks::Ident", NM="_ZN5clang11PPCallbacks5IdentENS_14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks5IdentENS_14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  public /*virtual*/ void Ident(SourceLocation Loc, StringRef str) {
  }

  
  /// \brief Callback invoked when start reading any pragma directive.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::PragmaDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 162,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 160,
   FQN="clang::PPCallbacks::PragmaDirective", NM="_ZN5clang11PPCallbacks15PragmaDirectiveENS_14SourceLocationENS_20PragmaIntroducerKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks15PragmaDirectiveENS_14SourceLocationENS_20PragmaIntroducerKindE")
  //</editor-fold>
  public /*virtual*/ void PragmaDirective(SourceLocation Loc, 
          PragmaIntroducerKind Introducer) {
  }

  /// \brief JAVA: our Callback invoked when read #pragma once directive.
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public /*virtual*/ void PragmaOnceDirective(Token once) {
  }

  /// \brief Callback invoked when a \#pragma comment directive is read.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::PragmaComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 167,
   FQN="clang::PPCallbacks::PragmaComment", NM="_ZN5clang11PPCallbacks13PragmaCommentENS_14SourceLocationEPKNS_14IdentifierInfoEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks13PragmaCommentENS_14SourceLocationEPKNS_14IdentifierInfoEN4llvm9StringRefE")
  //</editor-fold>
  public /*virtual*/ void PragmaComment(SourceLocation Loc, /*const*/ IdentifierInfo /*P*/ Kind, 
               StringRef Str) {
  }

  
  /// \brief Callback invoked when a \#pragma detect_mismatch directive is
  /// read.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::PragmaDetectMismatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 173,
   FQN="clang::PPCallbacks::PragmaDetectMismatch", NM="_ZN5clang11PPCallbacks20PragmaDetectMismatchENS_14SourceLocationEN4llvm9StringRefES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks20PragmaDetectMismatchENS_14SourceLocationEN4llvm9StringRefES3_")
  //</editor-fold>
  public /*virtual*/ void PragmaDetectMismatch(SourceLocation Loc, StringRef Name, 
                      StringRef Value) {
  }

  
  /// \brief Callback invoked when a \#pragma clang __debug directive is read.
  /// \param Loc The location of the debug directive.
  /// \param DebugType The identifier following __debug.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::PragmaDebug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 180,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 179,
   FQN="clang::PPCallbacks::PragmaDebug", NM="_ZN5clang11PPCallbacks11PragmaDebugENS_14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks11PragmaDebugENS_14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  public /*virtual*/ void PragmaDebug(SourceLocation Loc, StringRef DebugType) {
  }

  
  /// \brief Determines the kind of \#pragma invoking a call to PragmaMessage.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::PragmaMessageKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 184,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 183,
   FQN="clang::PPCallbacks::PragmaMessageKind", NM="_ZN5clang11PPCallbacks17PragmaMessageKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks17PragmaMessageKindE")
  //</editor-fold>
  public enum PragmaMessageKind implements Native.ComparableLower {
    /// \brief \#pragma message has been invoked.
    PMK_Message(0),
    
    /// \brief \#pragma GCC warning has been invoked.
    PMK_Warning(PMK_Message.getValue() + 1),
    
    /// \brief \#pragma GCC error has been invoked.
    PMK_Error(PMK_Warning.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static PragmaMessageKind valueOf(int val) {
      PragmaMessageKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final PragmaMessageKind[] VALUES;
      private static final PragmaMessageKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (PragmaMessageKind kind : PragmaMessageKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new PragmaMessageKind[min < 0 ? (1-min) : 0];
        VALUES = new PragmaMessageKind[max >= 0 ? (1+max) : 0];
        for (PragmaMessageKind kind : PragmaMessageKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private PragmaMessageKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((PragmaMessageKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((PragmaMessageKind)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Callback invoked when a \#pragma message directive is read.
  /// \param Loc The location of the message directive.
  /// \param Namespace The namespace of the message directive.
  /// \param Kind The type of the message directive.
  /// \param Str The text of the message directive.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::PragmaMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 200,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 199,
   FQN="clang::PPCallbacks::PragmaMessage", NM="_ZN5clang11PPCallbacks13PragmaMessageENS_14SourceLocationEN4llvm9StringRefENS0_17PragmaMessageKindES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks13PragmaMessageENS_14SourceLocationEN4llvm9StringRefENS0_17PragmaMessageKindES3_")
  //</editor-fold>
  public /*virtual*/ void PragmaMessage(SourceLocation Loc, StringRef Namespace, 
               PragmaMessageKind Kind, StringRef Str) {
  }

  
  /// \brief Callback invoked when a \#pragma gcc diagnostic push directive
  /// is read.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::PragmaDiagnosticPush">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 206,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 205,
   FQN="clang::PPCallbacks::PragmaDiagnosticPush", NM="_ZN5clang11PPCallbacks20PragmaDiagnosticPushENS_14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks20PragmaDiagnosticPushENS_14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  public /*virtual*/ void PragmaDiagnosticPush(SourceLocation Loc, 
                      StringRef Namespace) {
  }

  
  /// \brief Callback invoked when a \#pragma gcc diagnostic pop directive
  /// is read.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::PragmaDiagnosticPop">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 212,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 211,
   FQN="clang::PPCallbacks::PragmaDiagnosticPop", NM="_ZN5clang11PPCallbacks19PragmaDiagnosticPopENS_14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks19PragmaDiagnosticPopENS_14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  public /*virtual*/ void PragmaDiagnosticPop(SourceLocation Loc, 
                     StringRef Namespace) {
  }

  
  /// \brief Callback invoked when a \#pragma gcc diagnostic directive is read.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::PragmaDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 217,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 216,
   FQN="clang::PPCallbacks::PragmaDiagnostic", NM="_ZN5clang11PPCallbacks16PragmaDiagnosticENS_14SourceLocationEN4llvm9StringRefENS_4diag8SeverityES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks16PragmaDiagnosticENS_14SourceLocationEN4llvm9StringRefENS_4diag8SeverityES3_")
  //</editor-fold>
  public /*virtual*/ void PragmaDiagnostic(SourceLocation Loc, StringRef Namespace, 
                  diag.Severity mapping, StringRef Str) {
  }

  
  /// \brief Called when an OpenCL extension is either disabled or
  /// enabled with a pragma.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::PragmaOpenCLExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 222,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 221,
   FQN="clang::PPCallbacks::PragmaOpenCLExtension", NM="_ZN5clang11PPCallbacks21PragmaOpenCLExtensionENS_14SourceLocationEPKNS_14IdentifierInfoES1_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks21PragmaOpenCLExtensionENS_14SourceLocationEPKNS_14IdentifierInfoES1_j")
  //</editor-fold>
  public /*virtual*/ void PragmaOpenCLExtension(SourceLocation NameLoc, 
                       /*const*/ IdentifierInfo /*P*/ Name, 
                       SourceLocation StateLoc, /*uint*/int State) {
  }

  
  /// \brief Callback invoked when a \#pragma warning directive is read.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::PragmaWarning">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 228,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 227,
   FQN="clang::PPCallbacks::PragmaWarning", NM="_ZN5clang11PPCallbacks13PragmaWarningENS_14SourceLocationEN4llvm9StringRefENS2_8ArrayRefIiEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks13PragmaWarningENS_14SourceLocationEN4llvm9StringRefENS2_8ArrayRefIiEE")
  //</editor-fold>
  public /*virtual*/ void PragmaWarning(SourceLocation Loc, StringRef WarningSpec, 
               ArrayRefInt Ids) {
  }

  
  /// \brief Callback invoked when a \#pragma warning(push) directive is read.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::PragmaWarningPush">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 233,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 232,
   FQN="clang::PPCallbacks::PragmaWarningPush", NM="_ZN5clang11PPCallbacks17PragmaWarningPushENS_14SourceLocationEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks17PragmaWarningPushENS_14SourceLocationEi")
  //</editor-fold>
  public /*virtual*/ void PragmaWarningPush(SourceLocation Loc, int Level) {
  }

  
  /// \brief Callback invoked when a \#pragma warning(pop) directive is read.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::PragmaWarningPop">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 237,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 236,
   FQN="clang::PPCallbacks::PragmaWarningPop", NM="_ZN5clang11PPCallbacks16PragmaWarningPopENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks16PragmaWarningPopENS_14SourceLocationE")
  //</editor-fold>
  public /*virtual*/ void PragmaWarningPop(SourceLocation Loc) {
  }

  /**
   * #error or #warning
   * @param HashLoc
   * @param EodLoc
   * @param Tok
   * @param Msg
   * @param isWarning
   * @return true to indicate that the preprocessor should attempt to recover
  */
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public /*virtual*/ boolean UserDiagnostic(SourceLocation HashLoc, SourceLocation EodLoc,
          /*const*/Token /*&*/ Tok, StringRef Msg, boolean isWarning) {
    return true;
  }

  /// \brief Called by Preprocessor::HandleMacroExpandedIdentifier when a
  /// macro invocation is found.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::MacroExpands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 242,
   FQN="clang::PPCallbacks::MacroExpands", NM="_ZN5clang11PPCallbacks12MacroExpandsERKNS_5TokenERKNS_15MacroDefinitionENS_11SourceRangeEPKNS_9MacroArgsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks12MacroExpandsERKNS_5TokenERKNS_15MacroDefinitionENS_11SourceRangeEPKNS_9MacroArgsE")
  //</editor-fold>
  public /*virtual*/ void MacroExpands(/*const*/ Token /*&*/ MacroNameTok, 
          /*const*/ MacroDefinition /*&*/ MD, SourceRange Range, 
          /*const*/MacroArgs /*P*/ Args) {
  }

  
  /// \brief Hook called whenever a macro definition is seen.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::MacroDefined">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 247,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 246,
   FQN="clang::PPCallbacks::MacroDefined", NM="_ZN5clang11PPCallbacks12MacroDefinedERKNS_5TokenEPKNS_14MacroDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks12MacroDefinedERKNS_5TokenEPKNS_14MacroDirectiveE")
  //</editor-fold>
  public /*virtual*/ void MacroDefined(SourceLocation HashLoc, SourceLocation EodLoc, /*MANUAL_SEMANTIC*/
          /*const*/ Token /*&*/ MacroNameTok, 
          /*const*/ MacroDirective /*P*/ MD) {
  }

  
  /// \brief Hook called whenever a macro \#undef is seen.
  ///
  /// MD is released immediately following this callback.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::MacroUndefined">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 254,
   FQN="clang::PPCallbacks::MacroUndefined", NM="_ZN5clang11PPCallbacks14MacroUndefinedERKNS_5TokenERKNS_15MacroDefinitionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks14MacroUndefinedERKNS_5TokenERKNS_15MacroDefinitionE")
  //</editor-fold>
  public /*virtual*/ void MacroUndefined(SourceLocation HashLoc, SourceLocation EodLoc, /*MANUAL_SEMANTIC*/
          /*const*/Token /*&*/ MacroNameTok, 
          /*const*/ MacroDefinition /*&*/ MD) {
  }

  
  /// \brief Hook called whenever the 'defined' operator is seen.
  /// \param MD The MacroDirective if the name was a macro, null otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::Defined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 260,
   FQN="clang::PPCallbacks::Defined", NM="_ZN5clang11PPCallbacks7DefinedERKNS_5TokenERKNS_15MacroDefinitionENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks7DefinedERKNS_5TokenERKNS_15MacroDefinitionENS_11SourceRangeE")
  //</editor-fold>
  public /*virtual*/ void Defined(/*const*/ Token /*&*/ MacroNameTok, /*const*/ MacroDefinition /*&*/ MD, 
          SourceRange Range) {
  }

  
  /// \brief Hook called when a source range is skipped.
  /// \param Range The SourceRange that was skipped. The range begins at the
  /// \#if/\#else directive and ends after the \#endif/\#else directive.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::SourceRangeSkipped">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 267,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 266,
   FQN="clang::PPCallbacks::SourceRangeSkipped", NM="_ZN5clang11PPCallbacks18SourceRangeSkippedENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks18SourceRangeSkippedENS_11SourceRangeE")
  //</editor-fold>
  public /*virtual*/ void SourceRangeSkipped(SourceRange Range) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::ConditionValueKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 270,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 269,
   FQN="clang::PPCallbacks::ConditionValueKind", NM="_ZN5clang11PPCallbacks18ConditionValueKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks18ConditionValueKindE")
  //</editor-fold>
  public enum ConditionValueKind implements Native.ComparableLower {
    CVK_NotEvaluated(0),
    CVK_False(CVK_NotEvaluated.getValue() + 1),
    CVK_True(CVK_False.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ConditionValueKind valueOf(int val) {
      ConditionValueKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ConditionValueKind[] VALUES;
      private static final ConditionValueKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ConditionValueKind kind : ConditionValueKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ConditionValueKind[min < 0 ? (1-min) : 0];
        VALUES = new ConditionValueKind[max >= 0 ? (1+max) : 0];
        for (ConditionValueKind kind : ConditionValueKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ConditionValueKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ConditionValueKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ConditionValueKind)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Hook called whenever an \#if is seen.
  /// \param Loc the source location of the directive.
  /// \param ConditionRange The SourceRange of the expression being tested.
  /// \param ConditionValue The evaluated value of the condition.
  ///
  // FIXME: better to pass in a list (or tree!) of Tokens.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::If">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 280,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 279,
   FQN = "clang::PPCallbacks::If", NM = "_ZN5clang11PPCallbacks2IfENS_14SourceLocationENS_11SourceRangeENS0_18ConditionValueKindE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCallbacks.cpp -nm=_ZN5clang11PPCallbacks2IfENS_14SourceLocationENS_11SourceRangeENS0_18ConditionValueKindE")
  //</editor-fold>
  public /*virtual*/ void If(SourceLocation HashLoc, SourceLocation EodLoc, /*MANUAL_SEMANTIC*/
          SourceLocation Loc, SourceRange ConditionRange, 
          ConditionValueKind ConditionValue) {
  }

  
  /// \brief Hook called whenever an \#elif is seen.
  /// \param Loc the source location of the directive.
  /// \param ConditionRange The SourceRange of the expression being tested.
  /// \param ConditionValue The evaluated value of the condition.
  /// \param IfLoc the source location of the \#if/\#ifdef/\#ifndef directive.
  // FIXME: better to pass in a list (or tree!) of Tokens.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::Elif">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 290,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 289,
   FQN="clang::PPCallbacks::Elif", NM="_ZN5clang11PPCallbacks4ElifENS_14SourceLocationENS_11SourceRangeENS0_18ConditionValueKindES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks4ElifENS_14SourceLocationENS_11SourceRangeENS0_18ConditionValueKindES1_")
  //</editor-fold>
  public /*virtual*/ void Elif(SourceLocation HashLoc, SourceLocation EodLoc, /*MANUAL_SEMANTIC*/
          SourceLocation Loc, SourceRange ConditionRange, 
          ConditionValueKind ConditionValue, SourceLocation IfLoc) {
  }

  
  /// \brief Hook called whenever an \#ifdef is seen.
  /// \param Loc the source location of the directive.
  /// \param MacroNameTok Information on the token being tested.
  /// \param MD The MacroDefinition if the name was a macro, null otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::Ifdef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 298,
   FQN="clang::PPCallbacks::Ifdef", NM="_ZN5clang11PPCallbacks5IfdefENS_14SourceLocationERKNS_5TokenERKNS_15MacroDefinitionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks5IfdefENS_14SourceLocationERKNS_5TokenERKNS_15MacroDefinitionE")
  //</editor-fold>
  public /*virtual*/ void Ifdef(SourceLocation HashLoc, SourceLocation EodLoc, /*MANUAL_SEMANTIC*/
          SourceLocation Loc, /*const*/Token /*&*/ MacroNameTok, 
          /*const*/ MacroDefinition /*&*/ MD) {
  }

  
  /// \brief Hook called whenever an \#ifndef is seen.
  /// \param Loc the source location of the directive.
  /// \param MacroNameTok Information on the token being tested.
  /// \param MD The MacroDefiniton if the name was a macro, null otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::Ifndef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 306,
   FQN="clang::PPCallbacks::Ifndef", NM="_ZN5clang11PPCallbacks6IfndefENS_14SourceLocationERKNS_5TokenERKNS_15MacroDefinitionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks6IfndefENS_14SourceLocationERKNS_5TokenERKNS_15MacroDefinitionE")
  //</editor-fold>
  public /*virtual*/ void Ifndef(SourceLocation HashLoc, SourceLocation EodLoc,
          SourceLocation Loc, /*const*/Token /*&*/ MacroNameTok, /*const*/MacroDefinition /*P*/ MD) {
  }

  
  /// \brief Hook called whenever an \#else is seen.
  /// \param Loc the source location of the directive.
  /// \param IfLoc the source location of the \#if/\#ifdef/\#ifndef directive.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::Else">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 313,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 312,
   FQN="clang::PPCallbacks::Else", NM="_ZN5clang11PPCallbacks4ElseENS_14SourceLocationES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks4ElseENS_14SourceLocationES1_")
  //</editor-fold>
  public /*virtual*/ void Else(SourceLocation HashLoc, SourceLocation EodLoc, /*MANUAL_SEMANTIC*/
          SourceLocation Loc, SourceLocation IfLoc) {
  }

  
  /// \brief Hook called whenever an \#endif is seen.
  /// \param Loc the source location of the directive.
  /// \param IfLoc the source location of the \#if/\#ifdef/\#ifndef directive.
  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::Endif">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 319,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 318,
   FQN="clang::PPCallbacks::Endif", NM="_ZN5clang11PPCallbacks5EndifENS_14SourceLocationES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacks5EndifENS_14SourceLocationES1_")
  //</editor-fold>
  public /*virtual*/ void Endif(SourceLocation HashLoc, SourceLocation EodLoc, /*MANUAL_SEMANTIC*/
          SourceLocation Loc, SourceLocation IfLoc) {
  }
  
  // JAVA: notification about too deep inclusion (duplicates corresponding diagnostic)
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public void DeepFileInclusion(SourceLocation HashLoc, SourceLocation EodLoc, 
          Token IncludeTok, StringRef FileName, boolean IsAngled, CharSourceRange FilenameRange) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::PPCallbacks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", line = 38,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPCallbacks.h", old_line = 37,
   FQN="clang::PPCallbacks::PPCallbacks", NM="_ZN5clang11PPCallbacksC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang11PPCallbacksC1Ev")
  //</editor-fold>
  public /*inline*/ PPCallbacks()/* throw()*/ {
  }
  
  
  public String toString() {
    return ""; // NOI18N
  }
}
