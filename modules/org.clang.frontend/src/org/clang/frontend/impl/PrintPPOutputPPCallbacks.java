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
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;
import static org.clang.frontend.impl.PrintPreprocessedOutputStatics.*;
import org.clang.frontend.java.impl.PrintPPOutputHelper;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 80,
 FQN="(anonymous namespace)::PrintPPOutputPPCallbacks", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacksE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacksE")
//</editor-fold>
public class PrintPPOutputPPCallbacks extends /*public*/ PPCallbacks implements Destructors.ClassWithDestructor {
  private Preprocessor /*&*/ PP;
  private SourceManager /*&*/ SM;
  private TokenConcatenation ConcatInfo;
/*public:*/
  public raw_ostream /*&*/ OS;
/*private:*/
  private /*uint*/int CurLine;
  
  private boolean EmittedTokensOnThisLine;
  private boolean EmittedDirectiveOnThisLine;
  private SrcMgr.CharacteristicKind FileType;
  private SmallString/*512*/ CurFilename;
  private boolean Initialized;
  private boolean DisableLineMarkers;
  private boolean DumpDefines;
  private boolean UseLineDirectives;
  private boolean IsFirstFileEntered;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::PrintPPOutputPPCallbacks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 99,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::PrintPPOutputPPCallbacks", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacksC1ERN5clang12PreprocessorERN4llvm11raw_ostreamEbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacksC1ERN5clang12PreprocessorERN4llvm11raw_ostreamEbbb")
  //</editor-fold>
  public PrintPPOutputPPCallbacks(Preprocessor /*&*/ pp, raw_ostream /*&*/ os, boolean lineMarkers, 
      boolean defines, boolean UseLineDirectives) {
    // : PPCallbacks(), PP(pp), SM(PP.getSourceManager()), ConcatInfo(PP), OS(os), CurFilename(), DisableLineMarkers(lineMarkers), DumpDefines(defines), UseLineDirectives(UseLineDirectives) 
    //START JInit
    super();
    this./*&*/PP=/*&*/pp;
    this./*&*/SM=/*&*/PP.getSourceManager();
    this.ConcatInfo = new TokenConcatenation(PP);
    this./*&*/OS=/*&*/os;
    this.CurFilename = new SmallString/*512*/(512);
    this.DisableLineMarkers = lineMarkers;
    this.DumpDefines = defines;
    this.UseLineDirectives = UseLineDirectives;
    //END JInit
    CurLine = 0;
    CurFilename.$addassign(/*STRINGREF_STR*/"<uninit>");
    EmittedTokensOnThisLine = false;
    EmittedDirectiveOnThisLine = false;
    FileType = SrcMgr.CharacteristicKind.C_User;
    Initialized = false;
    IsFirstFileEntered = false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::setEmittedTokensOnThisLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 113,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::setEmittedTokensOnThisLine", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks26setEmittedTokensOnThisLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks26setEmittedTokensOnThisLineEv")
  //</editor-fold>
  public void setEmittedTokensOnThisLine() {
    EmittedTokensOnThisLine = true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::hasEmittedTokensOnThisLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 114,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::hasEmittedTokensOnThisLine", NM="_ZNK12_GLOBAL__N_124PrintPPOutputPPCallbacks26hasEmittedTokensOnThisLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZNK12_GLOBAL__N_124PrintPPOutputPPCallbacks26hasEmittedTokensOnThisLineEv")
  //</editor-fold>
  public boolean hasEmittedTokensOnThisLine() /*const*/ {
    return EmittedTokensOnThisLine;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::setEmittedDirectiveOnThisLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 116,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::setEmittedDirectiveOnThisLine", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks29setEmittedDirectiveOnThisLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks29setEmittedDirectiveOnThisLineEv")
  //</editor-fold>
  public void setEmittedDirectiveOnThisLine() {
    EmittedDirectiveOnThisLine = true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::hasEmittedDirectiveOnThisLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 117,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::hasEmittedDirectiveOnThisLine", NM="_ZNK12_GLOBAL__N_124PrintPPOutputPPCallbacks29hasEmittedDirectiveOnThisLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZNK12_GLOBAL__N_124PrintPPOutputPPCallbacks29hasEmittedDirectiveOnThisLineEv")
  //</editor-fold>
  public boolean hasEmittedDirectiveOnThisLine() /*const*/ {
    return EmittedDirectiveOnThisLine;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::startNewLineIfNeeded">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 231,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::startNewLineIfNeeded", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks20startNewLineIfNeededEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks20startNewLineIfNeededEb")
  //</editor-fold>
  public boolean startNewLineIfNeeded() {
    return startNewLineIfNeeded(true);
  }
  public boolean startNewLineIfNeeded(boolean ShouldUpdateCurrentLine/*= true*/) {
    if (EmittedTokensOnThisLine || EmittedDirectiveOnThisLine) {
      OS.$out_char($$LF);
      EmittedTokensOnThisLine = false;
      EmittedDirectiveOnThisLine = false;
      if (ShouldUpdateCurrentLine) {
        ++CurLine;
      }
      return true;
    }
    
    return false;
  }

  
  
  /// FileChanged - Whenever the preprocessor enters or exits a #include file
  /// it invokes this handler.  Update our conception of the current source
  /// position.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::FileChanged">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 248,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::FileChanged", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks11FileChangedEN5clang14SourceLocationENS1_11PPCallbacks16FileChangeReasonENS1_6SrcMgr18CharacteristicKindENS1_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks11FileChangedEN5clang14SourceLocationENS1_11PPCallbacks16FileChangeReasonENS1_6SrcMgr18CharacteristicKindENS1_6FileIDE")
  //</editor-fold>
  @Override public void FileChanged(SourceLocation Loc, 
             FileChangeReason Reason, 
             SrcMgr.CharacteristicKind NewFileType, 
             FileID PrevFID)/* override*/ {
    // Unless we are exiting a #include, make sure to skip ahead to the line the
    // #include directive was at.
    SourceManager /*&*/ SourceMgr = SM;
    
    PresumedLoc UserLoc = SourceMgr.getPresumedLoc(/*NO_COPY*/Loc);
    if (UserLoc.isInvalid()) {
      return;
    }
    
    /*uint*/int NewLine = UserLoc.getLine();
    if (Reason == PPCallbacks.FileChangeReason.EnterFile) {
      SourceLocation IncludeLoc = UserLoc.getIncludeLoc();
      if (IncludeLoc.isValid()) {
        MoveToLine(/*NO_COPY*/IncludeLoc);
      }
    } else if (Reason == PPCallbacks.FileChangeReason.SystemHeaderPragma) {
      // GCC emits the # directive for this directive on the line AFTER the
      // directive and emits a bunch of spaces that aren't needed. This is because
      // otherwise we will emit a line marker for THIS line, which requires an
      // extra blank line after the directive to avoid making all following lines
      // off by one. We can do better by simply incrementing NewLine here.
      NewLine += 1;
    }
    
    CurLine = NewLine;
    
    CurFilename.clear();
    CurFilename.$addassign(/*STRINGREF_STR*/UserLoc.getFilename());
    FileType = NewFileType;
    if (DisableLineMarkers) {
      startNewLineIfNeeded(/*ShouldUpdateCurrentLine=*/ false);
      return;
    }
    if (!Initialized) {
      WriteLineInfo(CurLine);
      Initialized = true;
    }
    
    // Do not emit an enter marker for the main file (which we expect is the first
    // entered file). This matches gcc, and improves compatibility with some tools
    // which track the # line markers as a way to determine when the preprocessed
    // output is in the context of the main file.
    if (Reason == PPCallbacks.FileChangeReason.EnterFile && !IsFirstFileEntered) {
      IsFirstFileEntered = true;
      return;
    }
    switch (Reason) {
     case EnterFile:
      WriteLineInfo(CurLine, $(" 1"), 2);
      break;
     case ExitFile:
      WriteLineInfo(CurLine, $(" 2"), 2);
      break;
     case SystemHeaderPragma:
     case RenameFile:
      WriteLineInfo(CurLine);
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::InclusionDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*eod*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 314,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::InclusionDirective", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks18InclusionDirectiveEN5clang14SourceLocationERKNS1_5TokenEN4llvm9StringRefEbNS1_15CharSourceRangeEPKNS1_9FileEntryES7_S7_PKNS1_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks18InclusionDirectiveEN5clang14SourceLocationERKNS1_5TokenEN4llvm9StringRefEbNS1_15CharSourceRangeEPKNS1_9FileEntryES7_S7_PKNS1_6ModuleE")
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
    // When preprocessing, turn implicit imports into @imports.
    // FIXME: This is a stop-gap until a more comprehensive "preprocessing with
    // modules" solution is introduced.
    if ((Imported != null)) {
      startNewLineIfNeeded();
      MoveToLine(/*NO_COPY*/HashLoc);
      if (PP.getLangOpts().ObjC2) {
        OS.$out(/*KEEP_STR*/"@import ").$out(Imported.getFullModuleName()).$out(/*KEEP_STR*/$SEMI).$out(
            /*KEEP_STR*/" /* clang -E: implicit import for \""
        ).$out(File.getName()).$out(
            /*KEEP_STR*/"\" */"
        );
      } else {
        // FIXME: Preseve whether this was a
        // #include/#include_next/#include_macros/#import.
        OS.$out(/*KEEP_STR*/"#include ").$out_char(
            (IsAngled ? $$LT : $$DBL_QUOTE)
        ).$out(
            /*NO_COPY*/FileName
        ).$out_char(
            (IsAngled ? $$GT : $$DBL_QUOTE)
        ).$out(
            /*KEEP_STR*/" /* clang -E: implicit import for module "
        ).$out(
            Imported.getFullModuleName()
        ).$out(/*KEEP_STR*/" */");
      }
      // Since we want a newline after the @import, but not a #<line>, start a new
      // line immediately.
      EmittedTokensOnThisLine = true;
      startNewLineIfNeeded();
    }
  }

  
  /// Ident - Handle #ident directives when read by the preprocessor.
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::Ident">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 352,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", old_line = 340,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::Ident", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks5IdentEN5clang14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks5IdentEN5clang14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  @Override public void Ident(SourceLocation Loc, StringRef S)/* override*/ {
    MoveToLine(/*NO_COPY*/Loc);
    
    OS.write($("#ident "), strlen(/*KEEP_STR*/"#ident "));
    OS.write(S.begin(), S.size());
    EmittedTokensOnThisLine = true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::PragmaMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 396,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", old_line = 386,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::PragmaMessage", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks13PragmaMessageEN5clang14SourceLocationEN4llvm9StringRefENS1_11PPCallbacks17PragmaMessageKindES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks13PragmaMessageEN5clang14SourceLocationEN4llvm9StringRefENS1_11PPCallbacks17PragmaMessageKindES4_")
  //</editor-fold>
  @Override public void PragmaMessage(SourceLocation Loc, 
               StringRef Namespace, 
               PragmaMessageKind Kind, 
               StringRef Str)/* override*/ {
    startNewLineIfNeeded();
    MoveToLine(/*NO_COPY*/Loc);
    OS.$out(/*KEEP_STR*/"#pragma ");
    if (!Namespace.empty()) {
      OS.$out(/*NO_COPY*/Namespace).$out_char($$SPACE);
    }
    switch (Kind) {
     case PMK_Message:
      OS.$out(/*KEEP_STR*/"message(\"");
      break;
     case PMK_Warning:
      OS.$out(/*KEEP_STR*/"warning \"");
      break;
     case PMK_Error:
      OS.$out(/*KEEP_STR*/"error \"");
      break;
    }
    
    outputPrintable(OS, /*NO_COPY*/Str);
    OS.$out_char($$DBL_QUOTE);
    if (Kind == PragmaMessageKind.PMK_Message) {
      OS.$out_char($$RPAREN);
    }
    setEmittedDirectiveOnThisLine();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::PragmaDebug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 424,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", old_line = 414,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::PragmaDebug", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks11PragmaDebugEN5clang14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks11PragmaDebugEN5clang14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  @Override public void PragmaDebug(SourceLocation Loc, 
             StringRef DebugType)/* override*/ {
    startNewLineIfNeeded();
    MoveToLine(/*NO_COPY*/Loc);
    
    OS.$out(/*KEEP_STR*/"#pragma clang __debug ");
    OS.$out(/*NO_COPY*/DebugType);
    
    setEmittedDirectiveOnThisLine();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::PragmaDiagnosticPush">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 435,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", old_line = 425,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::PragmaDiagnosticPush", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks20PragmaDiagnosticPushEN5clang14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks20PragmaDiagnosticPushEN5clang14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  @Override public void PragmaDiagnosticPush(SourceLocation Loc, StringRef Namespace)/* override*/ {
    startNewLineIfNeeded();
    MoveToLine(/*NO_COPY*/Loc);
    OS.$out(/*KEEP_STR*/"#pragma ").$out(/*NO_COPY*/Namespace).$out(/*KEEP_STR*/" diagnostic push");
    setEmittedDirectiveOnThisLine();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::PragmaDiagnosticPop">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 443,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", old_line = 433,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::PragmaDiagnosticPop", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks19PragmaDiagnosticPopEN5clang14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks19PragmaDiagnosticPopEN5clang14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  @Override public void PragmaDiagnosticPop(SourceLocation Loc, StringRef Namespace)/* override*/ {
    startNewLineIfNeeded();
    MoveToLine(/*NO_COPY*/Loc);
    OS.$out(/*KEEP_STR*/"#pragma ").$out(/*NO_COPY*/Namespace).$out(/*KEEP_STR*/" diagnostic pop");
    setEmittedDirectiveOnThisLine();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::PragmaDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 451,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", old_line = 441,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::PragmaDiagnostic", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks16PragmaDiagnosticEN5clang14SourceLocationEN4llvm9StringRefENS1_4diag8SeverityES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks16PragmaDiagnosticEN5clang14SourceLocationEN4llvm9StringRefENS1_4diag8SeverityES4_")
  //</editor-fold>
  @Override public void PragmaDiagnostic(SourceLocation Loc, 
                  StringRef Namespace, 
                  diag.Severity Map, 
                  StringRef Str)/* override*/ {
    startNewLineIfNeeded();
    MoveToLine(/*NO_COPY*/Loc);
    OS.$out(/*KEEP_STR*/"#pragma ").$out(/*NO_COPY*/Namespace).$out(/*KEEP_STR*/" diagnostic ");
    switch (Map) {
     case Remark:
      OS.$out(/*KEEP_STR*/"remark");
      break;
     case Warning:
      OS.$out(/*KEEP_STR*/$warning);
      break;
     case Error:
      OS.$out(/*KEEP_STR*/$error);
      break;
     case Ignored:
      OS.$out(/*KEEP_STR*/"ignored");
      break;
     case Fatal:
      OS.$out(/*KEEP_STR*/"fatal");
      break;
    }
    OS.$out(/*KEEP_STR*/" \"").$out(/*NO_COPY*/Str).$out_char($$DBL_QUOTE);
    setEmittedDirectiveOnThisLine();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::PragmaWarning">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 479,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", old_line = 469,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::PragmaWarning", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks13PragmaWarningEN5clang14SourceLocationEN4llvm9StringRefENS3_8ArrayRefIiEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks13PragmaWarningEN5clang14SourceLocationEN4llvm9StringRefENS3_8ArrayRefIiEE")
  //</editor-fold>
  @Override public void PragmaWarning(SourceLocation Loc, 
               StringRef WarningSpec, 
               ArrayRefInt Ids)/* override*/ {
    startNewLineIfNeeded();
    MoveToLine(/*NO_COPY*/Loc);
    OS.$out(/*KEEP_STR*/"#pragma warning(").$out(/*NO_COPY*/WarningSpec).$out_char($$COLON);
    for (int$ptr I = $tryClone(Ids.begin()), /*P*/ E = $tryClone(Ids.end()); $noteq_ptr(I, E); I.$preInc())  {
      OS.$out_char($$SPACE).$out_int(I.$star());
    }
    OS.$out_char($$RPAREN);
    setEmittedDirectiveOnThisLine();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::PragmaWarningPush">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 491,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", old_line = 481,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::PragmaWarningPush", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks17PragmaWarningPushEN5clang14SourceLocationEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks17PragmaWarningPushEN5clang14SourceLocationEi")
  //</editor-fold>
  @Override public void PragmaWarningPush(SourceLocation Loc, 
                   int Level)/* override*/ {
    startNewLineIfNeeded();
    MoveToLine(/*NO_COPY*/Loc);
    OS.$out(/*KEEP_STR*/"#pragma warning(push");
    if (Level >= 0) {
      OS.$out(/*KEEP_STR*/$COMMA_SPACE).$out_int(Level);
    }
    OS.$out_char($$RPAREN);
    setEmittedDirectiveOnThisLine();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::PragmaWarningPop">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 502,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", old_line = 492,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::PragmaWarningPop", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks16PragmaWarningPopEN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks16PragmaWarningPopEN5clang14SourceLocationE")
  //</editor-fold>
  @Override public void PragmaWarningPop(SourceLocation Loc)/* override*/ {
    startNewLineIfNeeded();
    MoveToLine(/*NO_COPY*/Loc);
    OS.$out(/*KEEP_STR*/"#pragma warning(pop)");
    setEmittedDirectiveOnThisLine();
  }

  
  
  /// HandleFirstTokOnLine - When emitting a preprocessed file in -E mode, this
  /// is called for the first token on each new line.  If this really is the start
  /// of a new logical line, handle it and return true, otherwise return false.
  /// This may not be the start of a logical line because the "start of line"
  /// marker is set for spelling lines, not expansion ones.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::HandleFirstTokOnLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 514,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", old_line = 504,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::HandleFirstTokOnLine", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks20HandleFirstTokOnLineERN5clang5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks20HandleFirstTokOnLineERN5clang5TokenE")
  //</editor-fold>
  public boolean HandleFirstTokOnLine(Token /*&*/ Tok) {
    // Figure out what line we went to and insert the appropriate number of
    // newline characters.
    if (!MoveToLine(Tok.getLocation())) {
      return false;
    }
    
    // Print out space characters so that the first token on a line is
    // indented for easy reading.
    /*uint*/int ColNo = SM.getExpansionColumnNumber(Tok.getLocation());
    
    // The first token on a line can have a column number of 1, yet still expect
    // leading white space, if a macro expansion in column 1 starts with an empty
    // macro argument, or an empty nested macro expansion. In this case, move the
    // token to column 2.
    if (ColNo == 1 && Tok.hasLeadingSpace()) {
      ColNo = 2;
    }
    
    // This hack prevents stuff like:
    // #define HASH #
    // HASH define foo bar
    // From having the # character end up at column 1, which makes it so it
    // is not handled as a #define next time through the preprocessor if in
    // -fpreprocessed mode.
    if ($lesseq_uint(ColNo, 1) && Tok.is(tok.TokenKind.hash)) {
      OS.$out_char($$SPACE);
    }
    
    // Otherwise, indent the appropriate number of spaces.
    for (; $greater_uint(ColNo, 1); --ColNo)  {
      OS.$out_char($$SPACE);
    }
    
    return true;
  }

  
  /// Move to the line of the provided source location. This will
  /// return true if the output stream required adjustment or if
  /// the requested location is on the first line.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::MoveToLine">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*int-based method*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 149,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::MoveToLine", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks10MoveToLineEN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks10MoveToLineEN5clang14SourceLocationE")
  //</editor-fold>
  public boolean MoveToLine(SourceLocation Loc) {
    return MoveToLine(Loc.getRawEncoding());
  }
  public boolean MoveToLine(/*SourceLocation*/int Loc) {
    PresumedLoc PLoc = SM.getPresumedLoc(/*NO_COPY*/Loc);
    if (PLoc.isInvalid()) {
      return false;
    }
    return MoveToLineNo(PLoc.getLine()) || (PLoc.getLine() == 1);
  }

  
  /// MoveToLine - Move the output to the source line specified by the location
  /// object.  We can do this by emitting some number of \n's, or be emitting a
  /// #line directive.  This returns false if already at the specified line, true
  /// if some newlines were emitted.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::MoveToLine">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*private vs public; check >= 0*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 206,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::MoveToLine", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks10MoveToLineEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks10MoveToLineEj")
  //</editor-fold>
  /*!!!*/private boolean MoveToLineNo(/*uint*/int LineNo) { /*JAVA:method was renamed and hidden due to collision with above one*/
    // If this line is "close enough" to the original line, just print newlines,
    // otherwise print a #line directive.
    if ((/*JAVA FIX*/$lesseq_uint(0, LineNo - CurLine)) && $lesseq_uint(LineNo - CurLine, 8)) {
      if (LineNo - CurLine == 1) {
        OS.$out_char($$LF);
      } else if (LineNo == CurLine) {
        return false; // Spelling line moved, but expansion line didn't.
      } else {
        /*const*/char$ptr/*char P*/ NewLines = $LFLFLFLFLFLFLFLF;
        OS.write(NewLines, LineNo - CurLine);
      }
    } else if (!DisableLineMarkers) {
      // Emit a #line or line marker.
      WriteLineInfo(LineNo, (/*const*/char$ptr/*char P*/ )null, 0);
    } else {
      // Okay, we're in -P mode, which turns off line markers.  However, we still
      // need to emit a newline between tokens on different lines.
      startNewLineIfNeeded(/*ShouldUpdateCurrentLine=*/ false);
    }
    
    CurLine = LineNo;
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::AvoidConcat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 157,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::AvoidConcat", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks11AvoidConcatERKN5clang5TokenES4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks11AvoidConcatERKN5clang5TokenES4_S4_")
  //</editor-fold>
  public boolean AvoidConcat(/*const*/ Token /*&*/ PrevPrevTok, /*const*/ Token /*&*/ PrevTok, 
             /*const*/ Token /*&*/ Tok) {
    return ConcatInfo.AvoidConcat(PrevPrevTok, PrevTok, Tok);
  }

  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::WriteLineInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 176,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::WriteLineInfo", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks13WriteLineInfoEjPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks13WriteLineInfoEjPKcj")
  //</editor-fold>
  public void WriteLineInfo(/*uint*/int LineNo) {
    WriteLineInfo(LineNo, 
               (/*const*/char$ptr/*char P*/ )null, 
               0);
  }
  public void WriteLineInfo(/*uint*/int LineNo, 
               /*const*/char$ptr/*char P*/ Extra/*= null*/) {
    WriteLineInfo(LineNo, 
               Extra, 
               0);
  }
  public void WriteLineInfo(/*uint*/int LineNo, 
               /*const*/char$ptr/*char P*/ Extra/*= null*/, 
               /*uint*/int ExtraLen/*= 0*/) {
    startNewLineIfNeeded(/*ShouldUpdateCurrentLine=*/ false);
    
    // Emit #line directives or GNU line markers depending on what mode we're in.
    if (UseLineDirectives) {
      OS.$out(/*KEEP_STR*/"#line").$out_char($$SPACE).$out_uint(LineNo).$out_char($$SPACE).$out_char($$DBL_QUOTE);
      OS.write_escaped(CurFilename.$StringRef());
      OS.$out_char($$DBL_QUOTE);
    } else {
      OS.$out_char($$HASH).$out_char($$SPACE).$out_uint(LineNo).$out_char($$SPACE).$out_char($$DBL_QUOTE);
      OS.write_escaped(CurFilename.$StringRef());
      OS.$out_char($$DBL_QUOTE);
      if ((ExtraLen != 0)) {
        OS.write(Extra, ExtraLen);
      }
      if (FileType == SrcMgr.CharacteristicKind.C_System) {
        OS.write($(" 3"), 2);
      } else if (FileType == SrcMgr.CharacteristicKind.C_ExternCSystem) {
        OS.write($(" 3 4"), 4);
      }
    }
    OS.$out_char($$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::LineMarkersAreDisabled">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 163,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::LineMarkersAreDisabled", NM="_ZNK12_GLOBAL__N_124PrintPPOutputPPCallbacks22LineMarkersAreDisabledEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZNK12_GLOBAL__N_124PrintPPOutputPPCallbacks22LineMarkersAreDisabledEv")
  //</editor-fold>
  public boolean LineMarkersAreDisabled() /*const*/ {
    return DisableLineMarkers;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::HandleNewlinesInToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 547,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", old_line = 537,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::HandleNewlinesInToken", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks21HandleNewlinesInTokenEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks21HandleNewlinesInTokenEPKcj")
  //</editor-fold>
  public void HandleNewlinesInToken(/*const*/char$ptr/*char P*/ TokStr, 
                       /*uint*/int Len) {
    /*uint*/int NumNewlines = 0;
    for (; (Len != 0); --Len , TokStr.$preInc()) {
      if (TokStr.$star() != $$LF
         && TokStr.$star() != $$CR) {
        continue;
      }
      
      ++NumNewlines;
      
      // If we have \n\r or \r\n, skip both and count as one line.
      if (Len != 1
         && (TokStr.$at(1) == $$LF || TokStr.$at(1) == $$CR)
         && TokStr.$at(0) != TokStr.$at(1)) {
        TokStr.$preInc();
        --Len;
      }
    }
    if (NumNewlines == 0) {
      return;
    }
    
    CurLine += NumNewlines;
  }

  
  /// MacroDefined - This hook is called whenever a macro definition is seen.
  
  /// MacroDefined - This hook is called whenever a macro definition is seen.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::MacroDefined">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Hash/Eod*/,
   optimized = Converted.Optimization.VALUE_TYPE,       
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 361,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", old_line = 349,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::MacroDefined", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks12MacroDefinedERKN5clang5TokenEPKNS1_14MacroDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks12MacroDefinedERKN5clang5TokenEPKNS1_14MacroDirectiveE")
  //</editor-fold>
  @Override public void MacroDefined(SourceLocation HashLoc, SourceLocation EodLoc, /*const*/ Token /*&*/ MacroNameTok, 
              /*const*/ MacroDirective /*P*/ MD)/* override*/ {
    /*const*/ MacroInfo /*P*/ MI = MD.getMacroInfo$Const();
    // Only print out macro definitions in -dD mode.
    if (!DumpDefines
      // Ignore __FILE__ etc.
       || MI.isBuiltinMacro()) {
      return;
    }
    
    MoveToLine(MI.$getDefinitionLoc());
    PrintMacroDefinition(/*Deref*/MacroNameTok.getIdentifierInfo(), /*Deref*/MI, PP, OS);
    setEmittedDirectiveOnThisLine();
  }

  
  /// MacroUndefined - This hook is called whenever a macro #undef is seen.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::MacroUndefined">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Hash/Eod*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 374,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", old_line = 362,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::MacroUndefined", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks14MacroUndefinedERKN5clang5TokenERKNS1_15MacroDefinitionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacks14MacroUndefinedERKN5clang5TokenERKNS1_15MacroDefinitionE")
  //</editor-fold>
  @Override public void MacroUndefined(SourceLocation HashLoc, SourceLocation EodLoc, /*const*/ Token /*&*/ MacroNameTok, 
                /*const*/ MacroDefinition /*&*/ MD)/* override*/ {
    // Only print out macro definitions in -dD mode.
    if (!DumpDefines) {
      return;
    }
    
    MoveToLine(MacroNameTok.getLocation());
    OS.$out(/*KEEP_STR*/"#undef ").$out(MacroNameTok.getIdentifierInfo().getName());
    setEmittedDirectiveOnThisLine();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrintPPOutputPPCallbacks::~PrintPPOutputPPCallbacks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 80,
   FQN="(anonymous namespace)::PrintPPOutputPPCallbacks::~PrintPPOutputPPCallbacks", NM="_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacksD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_124PrintPPOutputPPCallbacksD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    CurFilename.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" /* STACKOVERFLOW: NEVER PRINT Preprocessor + ", PP=" + PP // NOI18N*/
              /* STACKOVERFLOW: NEVER PRINT SourceManager + ", SM=" + SM // NOI18N*/
              + ", ConcatInfo=" + ConcatInfo // NOI18N
              + ", OS=" + OS // NOI18N
              + ", CurLine=" + CurLine // NOI18N
              + ", EmittedTokensOnThisLine=" + EmittedTokensOnThisLine // NOI18N
              + ", EmittedDirectiveOnThisLine=" + EmittedDirectiveOnThisLine // NOI18N
              + ", FileType=" + FileType // NOI18N
              + ", CurFilename=" + CurFilename // NOI18N
              + ", Initialized=" + Initialized // NOI18N
              + ", DisableLineMarkers=" + DisableLineMarkers // NOI18N
              + ", DumpDefines=" + DumpDefines // NOI18N
              + ", UseLineDirectives=" + UseLineDirectives // NOI18N
              + ", IsFirstFileEntered=" + IsFirstFileEntered // NOI18N
              + super.toString(); // NOI18N
  }
  
  // private caches to eleminate allocations in heap
  PrintPPOutputHelper $getPrintPPOutputHelper() {
    assert (!PrintPPOutputHelperInUse) && (PrintPPOutputHelperInUse = true);
    return $PrintPPOutputHelper;
  }
  
  void $releasePrintPPOutputHelper(PrintPPOutputHelper helper) {
    assert helper == $PrintPPOutputHelper;
    assert PrintPPOutputHelperInUse;
    assert (PrintPPOutputHelperInUse = false) || true;
    $PrintPPOutputHelper.release();
  }
  private final PrintPPOutputHelper $PrintPPOutputHelper = new PrintPPOutputHelper();
  private boolean PrintPPOutputHelperInUse = false;  
}
