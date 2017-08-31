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

package org.clang.tools.services.support;

import org.clang.basic.CharSourceRange;
import org.clang.basic.BasicClangGlobals;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.FileEntry;
import org.clang.basic.FileID;
import org.clang.basic.IdentifierInfo;
import org.clang.basic.Module;
import org.clang.basic.SourceLocation;
import org.clang.basic.SourceManager;
import org.clang.basic.SourceRange;
import org.clang.basic.SrcMgr;
import org.clang.basic.tok;
import org.clang.lex.DirectoryLookup;
import org.clang.lex.Lexer;
import org.clang.lex.MacroArgs;
import org.clang.lex.MacroDefinition;
import org.clang.lex.MacroDirective;
import org.clang.lex.MacroInfo;
import org.clang.lex.PPCallbacks;
import org.clang.lex.Preprocessor;
import org.clang.lex.llvm.SmallVectorToken;
import org.clang.lex.Token;
import org.clang.tools.services.impl.PreprocessorSupport;
import org.clank.java.std;
import static org.clank.java.std.*;
import org.clank.support.Casts;
import org.clank.support.Native;
import static org.clank.support.NativePointer.$;
import org.clank.support.NativeTrace;
import org.clank.support.aliases.char$ptr;
import org.llvm.adt.SmallString;
import org.llvm.support.raw_ostream;
import org.llvm.adt.StringRef;
import org.llvm.adt.aliases.SmallVector;
import org.llvm.support.MemoryBuffer;

/**
 *
 * @author Vladimir Voskresensky
 */
public class FileInfoCallback extends PPCallbacks {  
  private final static int MAX_GENERATED_TOKENS = Integer.getInteger("apt.limit.tokens", 8000000); // NOI18N
  
  // divider to estimate proportion between file size and expected num of tokens
  /*package*/ static final int FILE_SIZE_TO_TOKENS_RATIO = Integer.parseInt(System.getProperty("clank.services.file.tokens.ratio", "8"));
  // limit for intial capacity of tokens buffer
  /*package*/ static final int MAX_INITIAL_TOKENS_CAPACITY =
      Integer.parseInt(System.getProperty("clank.services.max.tokens.capacity",
                      Integer.toString(1024*1024*4/*4M Tokens*/)));
  /*package*/ static final int MIN_INITIAL_TOKENS_CAPACITY =
      Integer.parseInt(System.getProperty("clank.services.min.tokens.capacity",
                      Integer.toString(1024*16/*16K tokens*/)));

  protected static final boolean TRACE = Boolean.parseBoolean(System.getProperty("clank.callback.trace", "false")); //NativeTrace.DEBUG;
  protected static final boolean TRACE_TOKEN = Boolean.parseBoolean(System.getProperty("clank.callback.trace.token", "false")); //NativeTrace.DEBUG;
  private static final boolean TRACE_ALL_TOKENS = Boolean.parseBoolean(System.getProperty("clank.callback.trace.all.token", "false")); //NativeTrace.DEBUG;  
  
  protected final raw_ostream traceOS;
  private FileEntry MainFile = null;
  private SourceManager SM;
  private Preprocessor PP;
  private final std.vector<FileInfo> includeStack = new std.vector<>(16, (FileInfo)null);
  private final SmallVector<SmallVectorToken> poolOfTokens;
  // current
  private FileInfo curStackElement = null;
  private SmallVectorToken curStackElementTokens = null;
  private int curStackElementTokensCount = 0;
  private int curStackElementLocForStartOfFile = -1;
  private boolean curStackElementSawErrorDirective = false;

  private InclusionDirectiveInfo curInclusionDirectiveInfo = null;

  public FileInfoCallback(raw_ostream traceOS) {
    // Pools must be initialized with null default value
    // to have pure assign in array's cell instead of $assign call
    // so, client is responsible to clean up elements before pushing back into pool
    this.poolOfTokens = new SmallVector<>(0, null);
    poolOfTokens.reserve(32);
    this.traceOS = traceOS;
  }

  public void prepareEnterMainSourceFile(Preprocessor PP) {
    this.PP = PP;
    this.SM = PP.getSourceManager();
    includeStack.clear();
    curStackElement = null;
    curStackElementTokens = null;
    curStackElementTokensCount = 0;
    curStackElementSawErrorDirective = false;
    updatePreprocessorStates();
    // at the beginning we start PP in Keep comments for normal text mode
    // to have correct state inside lexer of the main file
    PP.SetCommentRetentionState(true, false);
  }

  protected final Preprocessor getPreprocessor() {
    return PP;
  }
  
  protected final SourceManager getSourceManager() {
    return SM;
  }
  
  protected final boolean isAfterErrorDirective() {
    return curStackElementSawErrorDirective;
  }
  
  protected void recoverFromErrorDirective() {
    // do nothing
  }
  
  // Our hooks for derived classes
  /// \brief Callback invoked whenever an inclusion directive results in a
  /// file-not-found error.
  ///
  /// \param curFile The current file
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
  protected boolean onNotFoundInclusionDirective(FileInfo curFile, StringRef FileName, SmallString RecoveryPath,
          vector<DirectoryLookup> SearchedDirs, int SearchedFromIndex) {
      return false;
  }

  /// \brief Callback invoked whenever an inclusion directive of
  /// any kind (\c \#include, \c \#import, etc.) has been processed, regardless
  /// of whether the inclusion will actually result in an inclusion.
  protected void onInclusionDirective(FileInfo curFile,
      InclusionDirectiveInfo directive) {
  }

  /// \brief Callback invoked whenever an inclusion directive of
  /// any kind (\c \#include, \c \#import, etc.) has been entered
  protected void onEnter(FileInfo enteredFrom, FileInfo enteredTo) {

  }

  /// \brief Callback invoked whenever an inclusion directive of
  /// any kind (\c \#include, \c \#import, etc.) has been skipped 
  // i.e. by guard or pragma once
  protected void onSkippedInclusionDirective(FileInfo curFile,
      InclusionDirectiveInfo directive) {
  }

  /// \brief Callback invoked whenever an inclusion directive of
  /// any kind (\c \#include, \c \#import, etc.) has been exited back
  protected void onExit(FileInfo exitedFrom, FileInfo exitedTo) {
  }

  /// \brief Callback invoked whenever an #error/#warning directive is met
  protected void onUserDiagnosticDirective(FileInfo curStackElement,
      UserDiagnosticDirectiveInfo directive) {
  }

  private boolean needPPDirectivesState = false;
  protected boolean needPPDirectives() {
    return false;
  }

  private boolean needTokensState = false;
  protected boolean needTokens() {
    return false;
  }

  private boolean needSkippedRangesState = false;
  protected boolean needSkippedRanges() {
    return false;
  }

  private boolean needMacroExpansionState = false;
  protected boolean needMacroExpansion() {
    return false;
  }

  private boolean needCommentsState = false;
  protected boolean needComments() {
    return false;
  }

  private boolean needMacroCommentsState = false;
  protected boolean needMacroComments() {
    return false;
  }

  private boolean isStoppedState = false;
  protected boolean isStopped() {
    return isStoppedState;
  }
  
  protected void onDeepInclusion() {
  }
  
  public FileInfoCallback copy() {
    throw new UnsupportedOperationException("This callback doesn't support cloning");
  }
  
  /// Implementation of PPCallbacks methods

  @Override
  public final boolean FileNotFound(StringRef FileName, SmallString RecoveryPath,
          vector<DirectoryLookup> SearchedDirs, int SearchedFromIndex) {
    if (TRACE) {
      traceOS.$out("FileNotFound in ").$out(getTraceName(curStackElement)).$out("\n").flush();
    }
    if (NativeTrace.VERBOSE_MODE || NativeTrace.SERVICE_STATISTICS) {
      FileInfo.NrNotFoundFiles.incrementAndGet();
    }
    
    return onNotFoundInclusionDirective(curStackElement, FileName, RecoveryPath, SearchedDirs, SearchedFromIndex);
  }

  @Override
  public final /*virtual*/ void InclusionDirective(SourceLocation HashLoc, SourceLocation EodLoc,
      /*const*/Token /*&*/ IncludeTok, StringRef FileName, boolean IsAngled,
      CharSourceRange FilenameRange, /*const*/FileEntry /*P*/ File,
      StringRef SearchPath, StringRef RelativePath, /*const*/Module /*P*/ Imported) {
    long/*<FileID, uint>*/ decomposedLocBegin = SM.getDecomposedLoc(HashLoc.getRawEncoding());
    int begOffset = $second_offset(decomposedLocBegin);
    int EndLocRawEncoding = EodLoc.getRawEncoding();
    if (FilenameRange.isValid()) {
      // use end of file name as the end of include directive
      // instead of EOD which can be after comments
      EndLocRawEncoding = FilenameRange.$getEnd();
      if (FilenameRange.isTokenRange()) {
        // need to adjust end location by token length
        int TokSize = Lexer.MeasureTokenLength(EndLocRawEncoding, SM, PP.getLangOpts());
        EndLocRawEncoding = SourceLocation.$getLocWithOffset(EndLocRawEncoding, TokSize);
      }
    }
    int endOffset;
    if (SourceLocation.isMacroID(EndLocRawEncoding)) {
      // need to adjust to the end of macro expansion
      long/*<SourceLocation, SourceLocation>*/ curExpansionRange = SM.getExpansionRange(EndLocRawEncoding);
      long/*<FileID, uint>*/ decomposedRangeEnd = SM.getDecomposedLoc($second_SourceLocation(curExpansionRange));
      // end offset is start of the last token in expRange, so add TokSize
      int TokSize = Lexer.MeasureTokenLength($second_SourceLocation(curExpansionRange), SM, PP.getLangOpts());
      endOffset = $second_offset(decomposedRangeEnd);
      endOffset += TokSize;
    } else {
      long/*<FileID, uint>*/ decomposedLocEnd = SM.getDecomposedLoc(EndLocRawEncoding);
      endOffset = $second_offset(decomposedLocEnd);
    }
    curInclusionDirectiveInfo = new InclusionDirectiveInfo(begOffset, endOffset, IsAngled, File, FileName, SearchPath);
    if (TRACE) {
      std.pairTypeUInt<FileID>  HashLocInfo = SM.getDecomposedLoc(HashLoc);
      std.pairTypeUInt<FileID>  EodLocInfo = SM.getDecomposedLoc(EodLoc);
      traceOS.$out("InclusionDirective in ").$out(getTraceName(curStackElement)).$out("\n");
      traceOS.$out("#include ");
      if (File != null) {
        traceOS.$out(File.getName());
      } else {
        traceOS.$out("<NOT_FOUND>");
      }
      traceOS.$out(" at [").$out_int(HashLocInfo.second).$out(", ").$out_int(EodLocInfo.second);
      traceOS.$out("]\n").flush();
    }
    assert curStackElement != null;
    if (needPPDirectivesState) {
      curStackElement.onPPDirective(curInclusionDirectiveInfo);
    }
    onInclusionDirective(curStackElement, curInclusionDirectiveInfo);
  }

  @Override
  public final void FileGuarded(/*const*/FileEntry /*P*/ guardedFile, IdentifierInfo IfDefMacro, SourceLocation IfDefMacroLocation,
        IdentifierInfo DefMacro, SourceLocation DefinedMacroLocation) {
    if (TRACE) {
      traceOS.$out("FileGuarded called in ").$out(getTraceName(curStackElement)).$out("\n");
      traceOS.$out("\tGuarded:").$out(guardedFile.getName()).$out("\n").flush();
    }
    assert curStackElement != null;
    if (needPPDirectivesState) {
      curStackElement.onGuardPositionDetected(IfDefMacro, IfDefMacroLocation.getRawEncoding(), DefMacro, DefinedMacroLocation.getRawEncoding());
    }
  }

  @Override
  public final void FileSkipped(FileEntry SkippedFile, Token FilenameTok,
      SrcMgr.CharacteristicKind FileType) {
    if (TRACE) {
      traceOS.$out("FileSkipped in ").$out(getTraceName(curStackElement)).$out("\n");
      traceOS.$out("\tSkipped:").$out(SkippedFile.getName()).$out("\n").flush();
    }
    if (NativeTrace.VERBOSE_MODE || NativeTrace.SERVICE_STATISTICS) {
      FileInfo.NrSkippedByGuardsFiles.incrementAndGet();
    }
    assert (curInclusionDirectiveInfo != null) : "can not skip file without seeing include directive " + getTraceName(curStackElement);
    onSkippedInclusionDirective(curStackElement, curInclusionDirectiveInfo);
    curInclusionDirectiveInfo = null;
  }

  @Override
  public final /*virtual*/ void FileChanged(SourceLocation Loc, FileChangeReason Reason,
      SrcMgr.CharacteristicKind FileType, FileID ExitedFID/*= FileID()*/) {
    try {
      if (TRACE) {
        traceOS.$out("FileChanged ").$out(Reason.name()).$out(" in ");
        traceOS.$out(getTraceName(curStackElement));
        traceOS.$out("\n").flush();
      }
      assert SM != null;
      if (MainFile == null) {
        if (!includeStack.empty()) {
          traceOS.$out("FileChanged: not empty include stack before Entered Main File\n").flush();
          return;
        }
        FileID mainFileID = SM.getMainFileID();
        SourceLocation MainFileLoc = SM.getLocForStartOfFile(mainFileID);
        if (BasicClangGlobals.$eq_SourceLocation$C(Loc, MainFileLoc) && Reason == PPCallbacks.FileChangeReason.EnterFile) {
          MainFile = SM.getFileEntryForID(mainFileID);
          FileEnterImpl(MainFile, mainFileID.$ID(), FileType, true);
        }
      } else {
        if (includeStack.empty()) {
          traceOS.$out("FileChanged:empty stack (before Entered Main File?)\n").flush();
          return;
        }
        if (Reason == PPCallbacks.FileChangeReason.EnterFile) {
          long/*<FileID, uint>*/ LocInfo = SM.getDecomposedLoc(Loc.getRawEncoding());
          /*FileID*/int DestFID = BasicClangGlobals.$first_FileID(LocInfo);
          FileEntry DestFE = SM.getFileEntryForID(DestFID);
          // skip lines like in preprocessed files, i.e. 
          // where EnterFile is emulated by index "1" after file name
          // # 1 "/usr/include/_G_config.h" 1 3 4 
          // filter out all such EnterFile which doesn't correspond to start of 
          // entered file
          /*SourceLocation*/int FileLoc = SM.getLocForStartOfFile(DestFID);
          if (BasicClangGlobals.$eq_SourceLocation$C(Loc.getRawEncoding(), FileLoc)) {
            // enter new lexed file
            FileEnterImpl(DestFE, DestFID, FileType, false);
          }
        } else if (Reason == PPCallbacks.FileChangeReason.ExitFile) {
          if (!ExitedFID.isInvalid()) {
            // end of lexed file
            FileEntry ExitedFE = SM.getFileEntryForID(ExitedFID);
            FileExitImpl(ExitedFE, ExitedFID.$ID(), false);
          }
        }
      }
    } finally {
      curInclusionDirectiveInfo = null;
    }
  }

  @Override
  public final void EndOfMainFile() {
    assert SM != null;
    FileExitImpl(MainFile, SM.getMainFileID().$ID(), true);
    if (!includeStack.empty()) {
      traceOS.$out("Extra entries after EndOfMainFile \n").flush();
      for (std.vector.iterator<FileInfo> B = includeStack.begin(),
                                    E = includeStack.end(); std.$noteq___normal_iterator(B, E); B.$preInc()) {
        traceOS.$out("\t").$out(B.$star().getName()).$out("\n").flush();
      }
    }
    MainFile = null;
    curStackElement = null;
    curStackElementTokens = null;
    curStackElementTokensCount = 0;
    curInclusionDirectiveInfo = null;
    if (NativeTrace.VERBOSE_MODE) {
      if (FileInfo.MaxPoolOfVectorTokensSize < poolOfTokens.size()) {
        FileInfo.MaxPoolOfVectorTokensSize = poolOfTokens.size();
      }
      Object[] $array = poolOfTokens.$array();
      long TotalCapacity = 0;
      for (int i = 0; i < poolOfTokens.size(); i++) {
        TotalCapacity += ((SmallVectorToken)$array[i]).capacity();
      }
      if (FileInfo.MaxNrOfTokensInPoolOnEndOfMainFile < TotalCapacity) {
        FileInfo.MaxNrOfTokensInPoolOnEndOfMainFile = TotalCapacity;
      }
    }
  }


  @Override
  public final /*virtual*/ void MacroExpands(/*const*/Token /*&*/ MacroNameTok, /*const*/MacroDefinition /*P*/ MD, SourceRange Range, /*const*/MacroArgs /*P*/ Args) {
    assert SM != null;
    assert (MainFile == null) == (curStackElement == null) : MainFile + " vs. " + curStackElement;
    assert (curStackElement == null) == (includeStack.empty()) : curStackElement + " vs. " + includeStack.size();
    if (needMacroExpansionState && curStackElement != null) {
      if (!SourceLocation.isFileID(Range.$getBegin()) || !SourceLocation.isFileID(Range.$getEnd())) {
        // TODO: for now skip expansion ranges inside other expansions
        return;
      }
      IdentifierInfo II = MacroNameTok.getIdentifierInfo();
      assert II != null : "only identifiers are expandable " + MacroNameTok;
      /*uint*/int macroNameLength = MacroNameTok.getLength();
      long/*<FileID, uint>*/ decomposedLocBegin = SM.getDecomposedLoc(Range.$getBegin());
      int EndLocRawEncoding = Range.$getEnd();
      // need to adjust end location by token length
      int TokSize = Lexer.MeasureTokenLength(EndLocRawEncoding, SM, PP.getLangOpts());
      EndLocRawEncoding = SourceLocation.$getLocWithOffset(EndLocRawEncoding, TokSize);
      long/*<FileID, uint>*/ decomposedLocEnd = SM.getDecomposedLoc(EndLocRawEncoding);
      /*uint*/int begOffset = $second_offset(decomposedLocBegin);
      /*uint*/int endOffset = $second_offset(decomposedLocEnd);
      if (TRACE) {
        traceOS.$out("MacroExpands ").$out(getTraceName(curStackElement)).$out(" [").$out_uint(begOffset).$out("-").$out_uint(endOffset).$out("]\n").flush();
      }
      MacroExpansionInfo info = curStackElement.onMacroExpands(begOffset, endOffset, macroNameLength, Range, MD, II);
      MacroInfo macroInfo = MD.getMacroInfo();
      if (macroInfo != null && macroInfo.isFunctionLike() && Args != null) {
        Token UnexpArgTokens[] = Args.$UnexpArgTokens();
        for (int argNum = 0; argNum < macroInfo.getNumArgs(); ++argNum) {
          int firstTokNum = Args.getUnexpArgument(argNum);
          int argLen = MacroArgs.getArgLength(UnexpArgTokens, firstTokNum);
          for (int i = firstTokNum; i < firstTokNum + argLen; ++i) {
            Token argTok = UnexpArgTokens[i];
            tryMarkMacroIdentifier(argTok); 
          }
        }
      }
      if (needTokensState && (curStackElementTokensCount < MAX_GENERATED_TOKENS)) {
        // FIXME: we put here fake annotation token to "record" macro expansion
        // directly in the token stream
        $macroExpansionToken.startToken();
        $macroExpansionToken.setKind(tok.TokenKind.annot_typename);
        $macroExpansionToken.setAnnotationRange(Range);
        $macroExpansionToken.setAnnotationValue(info);
        curStackElementTokens.push_back($macroExpansionToken);
        curStackElementTokensCount++;
        $macroExpansionToken.$destroy();
      }
    }
  }
  private final Token $macroExpansionToken = new Token(); // JAVA: PERF: reuse token instance

  @Override
  public final void MacroDefined(SourceLocation HashLoc, SourceLocation EodLoc, Token MacroNameTok, MacroDirective MD) {
    MacroInfo macroInfo = MD.getMacroInfo();
    if (needPPDirectivesState) {
      long/*<FileID, uint>*/ decomposedLocBegin = SM.getDecomposedLoc(HashLoc.getRawEncoding());
      long/*<FileID, uint>*/ decomposedLocEnd = SM.getDecomposedLoc(EodLoc.getRawEncoding());
      int begOffset = $second_offset(decomposedLocBegin);
      int endOffset = $second_offset(decomposedLocEnd);
      if (TRACE) {
        traceOS.$out("MacroDefined ").$out(getTraceName(curStackElement)).$out(" [").$out_uint(begOffset).$out("-").$out_uint(endOffset).$out("]\n").flush();
      }
      IdentifierInfo[] args = null;
      boolean isVariadic = false;
      if (macroInfo.isFunctionLike()) {
        args = macroInfo.$args();
        isVariadic = macroInfo.isVariadic();
      }
      assert curStackElement != null;
      MacroDefinitionInfo MDI = new MacroDefinitionInfo(curStackElement, begOffset, endOffset, MacroNameTok, args, isVariadic, true);
      curStackElement.onPPDirective(MDI);
    }
    if (needMacroExpansionState) {
      for (int i = 0; i < macroInfo.getNumTokens(); ++i) {
        Token bodyToken = macroInfo.getReplacementToken(i);
        tryMarkMacroIdentifier(bodyToken);
      }
    }
  }

  @Override
  public final void MacroUndefined(SourceLocation HashLoc, SourceLocation EodLoc, Token MacroNameTok, MacroDefinition MD) {
    if (needPPDirectivesState) {
      long/*<FileID, uint>*/ decomposedLocBegin = SM.getDecomposedLoc(HashLoc.getRawEncoding());
      long/*<FileID, uint>*/ decomposedLocEnd = SM.getDecomposedLoc(EodLoc.getRawEncoding());
      int begOffset = $second_offset(decomposedLocBegin);
      int endOffset = $second_offset(decomposedLocEnd);
      if (TRACE) {
        traceOS.$out("MacroUndefined ").$out(getTraceName(curStackElement)).$out(" [").$out_uint(begOffset).$out("-").$out_uint(endOffset).$out("]\n").flush();
      }
      assert curStackElement != null;
      MacroDefinitionInfo MDI = new MacroDefinitionInfo(curStackElement, begOffset, endOffset, MacroNameTok, null, false, false);
      curStackElement.onPPDirective(MDI);
    }
    if (needMacroExpansionState) {
      if (MD.$bool()) {
        curStackElement.onMacroUsage(MacroNameTok, MD);
      }
    }
  }

  @Override
  public /*virtual*/ void Defined(/*const*/Token /*&*/ MacroNameTok, /*const*/MacroDefinition /*P*/ MD, SourceRange Range) {
    // track macro usages like
    // #if defined MACRO
    // #if defined(MACRO)
    // #if !defined MACRO
    // #if !defined(MACRO)
    if (needMacroExpansionState) {
      if (MD.$bool()) { 
        // when MACRO exists, track it's usage in directive
        curStackElement.onMacroUsage(MacroNameTok, MD);
      }
    }
  }
  
  /// \brief Hook called whenever an \#if is seen.
  /// \param Loc the source location of the directive.
  /// \param ConditionRange The SourceRange of the expression being tested.
  /// \param ConditionValue The evaluated value of the condition.
  @Override
  public final void If(SourceLocation HashLoc, SourceLocation EodLoc, 
          SourceLocation Loc, SourceRange ConditionRange, ConditionValueKind ConditionValue) {
    if (!needSkippedRangesState) {
      return;
    }

    long/*<FileID, uint>*/ decomposedLocBegin = SM.getDecomposedLoc(HashLoc.getRawEncoding());
    long/*<FileID, uint>*/ decomposedLocEnd = SM.getDecomposedLoc(EodLoc.getRawEncoding());
    long/*<FileID, uint>*/ decomposedIfLoc = SM.getDecomposedLoc(Loc.getRawEncoding());
    int begOffset = $second_offset(decomposedLocBegin);
    int endOffset = $second_offset(decomposedLocEnd);
    int ifOffset = $second_offset(decomposedIfLoc);
    if (TRACE) {
      traceOS.$out("If ").$out(getTraceName(curStackElement)).
          $out(" #ifLoc=").$out_uint(ifOffset).$out(" ").$out(getConditionValueKindText(ConditionValue)).
          $out(" [").$out_uint(begOffset).$out("-").$out_uint(endOffset).$out("]\n").flush();
    }
    curStackElement.onIf(begOffset, endOffset, ifOffset, ConditionValue);
  }

  /// \brief Hook called whenever an \#ifdef is seen.
  /// \param Loc the source location of the directive.
  /// \param MacroNameTok Information on the token being tested.
  /// \param MD The MacroDefinition if the name was a macro, null otherwise.
  @Override
  public final void Ifdef(SourceLocation HashLoc, SourceLocation EodLoc,
      SourceLocation Loc, Token MacroNameTok, MacroDefinition MD) {
    if (needSkippedRangesState) {
      long/*<FileID, uint>*/ decomposedLocBegin = SM.getDecomposedLoc(HashLoc.getRawEncoding());
      long/*<FileID, uint>*/ decomposedLocEnd = SM.getDecomposedLoc(EodLoc.getRawEncoding());
      long/*<FileID, uint>*/ decomposedIfLoc = SM.getDecomposedLoc(Loc.getRawEncoding());
      int begOffset = $second_offset(decomposedLocBegin);
      int endOffset = $second_offset(decomposedLocEnd);
      int ifOffset = $second_offset(decomposedIfLoc);
      if (TRACE) {
        traceOS.$out("Ifdef ").$out(getTraceName(curStackElement)).
            $out(" #ifLoc=").$out_uint(ifOffset).$out(" ").$out(MD.$bool() ? "true" : "false").
            $out(" [").$out_uint(begOffset).$out("-").$out_uint(endOffset).$out("]\n").flush();
      }
      curStackElement.onIf(begOffset, endOffset, ifOffset, MD.$bool() ? ConditionValueKind.CVK_True : ConditionValueKind.CVK_False);
    }
    if (needMacroExpansionState) {
      curStackElement.onMacroUsage(MacroNameTok, MD);
    }
  }

  /// \brief Hook called whenever an \#ifndef is seen.
  /// \param Loc the source location of the directive.
  /// \param MacroNameTok Information on the token being tested.
  /// \param MD The MacroDefinition if the name was a macro, null otherwise.
  @Override
  public final void Ifndef(SourceLocation HashLoc, SourceLocation EodLoc,
      SourceLocation Loc, Token MacroNameTok, MacroDefinition MD) {
    if (needSkippedRangesState) {
      long/*<FileID, uint>*/ decomposedLocBegin = SM.getDecomposedLoc(HashLoc.getRawEncoding());
      long/*<FileID, uint>*/ decomposedLocEnd = SM.getDecomposedLoc(EodLoc.getRawEncoding());
      long/*<FileID, uint>*/ decomposedIfLoc = SM.getDecomposedLoc(Loc.getRawEncoding());
      int begOffset = $second_offset(decomposedLocBegin);
      int endOffset = $second_offset(decomposedLocEnd);
      int ifOffset = $second_offset(decomposedIfLoc);
      if (TRACE) {
        traceOS.$out("Ifndef ").$out(getTraceName(curStackElement)).
            $out(" #ifLoc=").$out_uint(ifOffset).$out(" ").$out(!MD.$bool() ? "true" : "false").
            $out(" [").$out_uint(begOffset).$out("-").$out_uint(endOffset).$out("]\n").flush();
      }
      curStackElement.onIf(begOffset, endOffset, ifOffset, !MD.$bool() ? ConditionValueKind.CVK_True : ConditionValueKind.CVK_False);
    }
    if (needMacroExpansionState) {
      curStackElement.onMacroUsage(MacroNameTok, MD);
    }
  }

  /// \brief Hook called whenever an \#elif is seen.
  /// \param Loc the source location of the directive.
  /// \param ConditionRange The SourceRange of the expression being tested.
  /// \param ConditionValue The evaluated value of the condition.
  /// \param IfLoc the source location of the \#if/\#ifdef/\#ifndef directive.
  @Override
  public final void Elif(SourceLocation HashLoc, SourceLocation EodLoc,
      SourceLocation Loc, SourceRange ConditionRange, ConditionValueKind ConditionValue, SourceLocation IfLoc) {
    if (!needSkippedRangesState) {
      return;
    }

    long/*<FileID, uint>*/ decomposedLocBegin = SM.getDecomposedLoc(HashLoc.getRawEncoding());
    long/*<FileID, uint>*/ decomposedLocEnd = SM.getDecomposedLoc(EodLoc.getRawEncoding());
    long/*<FileID, uint>*/ decomposedIfLoc = SM.getDecomposedLoc(IfLoc.getRawEncoding());
    int begOffset = $second_offset(decomposedLocBegin);
    int endOffset = $second_offset(decomposedLocEnd);
    int ifOffset = $second_offset(decomposedIfLoc);
    if (TRACE) {
      traceOS.$out("Elif ").$out(getTraceName(curStackElement)).
          $out(" #ifLoc=").$out_uint(ifOffset).$out(" ").$out(getConditionValueKindText(ConditionValue)).
          $out(" [").$out_uint(begOffset).$out("-").$out_uint(endOffset).$out("]\n").flush();
    }
    curStackElement.onElif(begOffset, endOffset, ifOffset, ConditionValue);
  }

  /// \brief Hook called whenever an \#else is seen.
  /// \param Loc the source location of the directive.
  /// \param IfLoc the source location of the \#if/\#ifdef/\#ifndef directive.
  @Override
  public final void Else(SourceLocation HashLoc, SourceLocation EodLoc,
      SourceLocation Loc, SourceLocation IfLoc) {
    if (!needSkippedRangesState) {
      return;
    }

    long/*<FileID, uint>*/ decomposedLocBegin = SM.getDecomposedLoc(HashLoc.getRawEncoding());
    long/*<FileID, uint>*/ decomposedLocEnd = SM.getDecomposedLoc(EodLoc.getRawEncoding());
    long/*<FileID, uint>*/ decomposedIfLoc = SM.getDecomposedLoc(IfLoc.getRawEncoding());
    int begOffset = $second_offset(decomposedLocBegin);
    int endOffset = $second_offset(decomposedLocEnd);
    int ifOffset = $second_offset(decomposedIfLoc);
    if (TRACE) {
      traceOS.$out("Else ").$out(getTraceName(curStackElement)).
          $out(" #ifLoc=").$out_uint(ifOffset).$out(" ").
          $out(" [").$out_uint(begOffset).$out("-").$out_uint(endOffset).$out("]\n").flush();
    }
    curStackElement.onElse(begOffset, endOffset, ifOffset);
  }

  /// \brief Hook called whenever an \#endif is seen.
  /// \param Loc the source location of the directive.
  /// \param IfLoc the source location of the \#if/\#ifdef/\#ifndef directive.
  @Override
  public final void Endif(SourceLocation HashLoc, SourceLocation EodLoc,
      SourceLocation Loc, SourceLocation IfLoc) {
    if (!needSkippedRangesState) {
      return;
    }
    long/*<FileID, uint>*/ decomposedLocBegin = SM.getDecomposedLoc(HashLoc.getRawEncoding());
    long/*<FileID, uint>*/ decomposedLocEnd = SM.getDecomposedLoc(EodLoc.getRawEncoding());
    long/*<FileID, uint>*/ decomposedIfLoc = SM.getDecomposedLoc(IfLoc.getRawEncoding());
    int begOffset = $second_offset(decomposedLocBegin);
    int endOffset = $second_offset(decomposedLocEnd);
    int ifOffset = $second_offset(decomposedIfLoc);
    if (TRACE) {
      traceOS.$out("Endif ").$out(getTraceName(curStackElement)).
          $out(" #ifLoc=").$out_uint(ifOffset).$out(" ").
          $out(" [").$out_uint(begOffset).$out("-").$out_uint(endOffset).$out("]\n").flush();
    }
    if (CATCH_IZ_255337) {
      if (begOffset == 4973714 || begOffset == 4973715 || begOffset == 4973716) {
        //pairTypeUInt<FileID> decomposedHashLoc = SM.getDecomposedLoc(HashLoc);
        /*FileID*/int fid = BasicClangGlobals.$first_FileID(decomposedLocBegin);
        MemoryBuffer mb = SM.getBuffer(fid);
        char$ptr p = mb.getBufferStart();
        p = p.$add(begOffset);
        String textAfter = Native.$toString(p, 10);
        p.$dec(100);
        String textBefore = Native.$toString(p, 100);
        new Exception("IZ 255337: dead block end = " + (begOffset-1) + //NOI18N
                "\n MemoryBuffer class: " + mb.getClass().getName() + //NOI18N
                "\n MemoryBuffer size: " + mb.getBufferSize() + " vs. " + mb.getBuffer().size() + " vs. " + curStackElement.getFileSize() + //NOI18N
                "\n has nonASCII ? " + hasNonASCII(mb) + //NOI18N
                "\n text=\n[" + textBefore + "]^[" + textAfter + "]\n").printStackTrace(System.err); //NOI18N
      }
    }
    if (NativeTrace.isDebugMode()) {        
        /*FileID*/int hashFID = BasicClangGlobals.$first_FileID(decomposedLocBegin);
        /*FileID*/int eodFID = BasicClangGlobals.$first_FileID(decomposedLocEnd);
        /*FileID*/int ifFID = BasicClangGlobals.$first_FileID(decomposedLocEnd);
        if (hashFID != eodFID) {
          // start and end of pp-directives are in different files??
          MemoryBuffer mb = SM.getBuffer(hashFID);
          char$ptr p = mb.getBufferStart();
          String textBefore = "<skip>";
          boolean traceFile = NativeTrace.isCheckingFile(mb.getBufferIdentifier());
          if (traceFile) {
            textBefore = Native.$toString(p, begOffset);
          }
          int Len = mb.getBufferSize();
          String textAfter = "<skip>";
          if (traceFile) {
            textAfter = Native.$toString(p.$add(begOffset), Len-begOffset-1);
          }
          NativeTrace.assertTrueInConsole(false, "#FID=" + hashFID + ";eodFID=" + eodFID + ";ifFID=" + ifFID + "\n#="+HashLoc + ";eod="+EodLoc+";#if="+IfLoc +
                  "\n MemoryBuffer class: " + mb.getClass().getName() + //NOI18N
                  "\n MemoryBuffer size: " + mb.getBufferSize() + " vs. " + mb.getBuffer().size() + " vs. FileEntry.size=" + curStackElement.getFileSize() + //NOI18N
                  "\n has nonASCII ? " + hasNonASCII(mb) + //NOI18N
                  "\n text=\n[" + textBefore + "]^[" + textAfter + "]\n"); //NOI18N
        }
    }
    curStackElement.onEndif(begOffset, endOffset, ifOffset);
  }

  private static boolean hasNonASCII(MemoryBuffer mb) {
    char$ptr p = Native.$tryClone(mb.getBufferStart());
    char$ptr e = mb.getBufferEnd();
    while (p.$less(e)) {
      byte c = p.$star();
      if (!BasicClangGlobals.isASCII(c)) {
        return true;
      }
      p.$inc(1);
    }
    return false;
  }
  
  private static final boolean CATCH_IZ_255337 = Boolean.getBoolean("cnd.catch.iz.255337"); //NOI18N
          
  /// #error or #warning
  @Override
  public final boolean UserDiagnostic(SourceLocation HashLoc, SourceLocation EodLoc,
      Token Tok, StringRef Msg, boolean isWarning) {
    try {
      if (!needSkippedRangesState) {
        return super.UserDiagnostic(HashLoc, EodLoc, Tok, Msg, isWarning);
      }
      long/*<FileID, uint>*/ decomposedLocBegin = SM.getDecomposedLoc(HashLoc.getRawEncoding());
      long/*<FileID, uint>*/ decomposedLocEnd = SM.getDecomposedLoc(EodLoc.getRawEncoding());
      int begOffset = $second_offset(decomposedLocBegin);
      int endOffset = $second_offset(decomposedLocEnd);
      if (TRACE) {
        traceOS.$out("UserDiagnostic ").$out(getTraceName(curStackElement)).$out(" [").$out_uint(begOffset).$out("-").$out_uint(endOffset).$out("]\n").flush();
      }
      assert curStackElement != null;
      UserDiagnosticDirectiveInfo UDI = new UserDiagnosticDirectiveInfo(begOffset, endOffset, Msg, isWarning);
      if (needPPDirectivesState) {
        curStackElement.onPPDirective(UDI);
      }
      if (!isWarning) {
        curStackElement.onUserErrorDiagnostic(begOffset, endOffset);
        curStackElementSawErrorDirective = curStackElement.sawErrorDirective;
      }
      onUserDiagnosticDirective(curStackElement, UDI);
      return true;
    } finally {
      if (!isWarning) {
        recoverFromErrorDirective();
      }
    }
  }

  @Override
  public void PragmaOnceDirective(Token once) {
    curStackElement.onPragmaOnceDetected(once);
  }

  @Override
  public final void SourceRangeSkipped(SourceRange Range) {
    assert SM != null;
    assert (MainFile == null) == (curStackElement == null) : MainFile + " vs. " + curStackElement;
    assert (curStackElement == null) == (includeStack.empty()) : curStackElement + " vs. " + includeStack.size();
    if (needSkippedRangesState && curStackElement != null) {
      long/*<FileID, uint>*/ decomposedLocBegin = SM.getDecomposedLoc(Range.$getBegin());
      long/*<FileID, uint>*/ decomposedLocEnd = SM.getDecomposedLoc(Range.$getEnd());
      int begOffset = $second_offset(decomposedLocBegin);
      int endOffset = $second_offset(decomposedLocEnd);
      if (TRACE) {
        traceOS.$out("SourceRangeSkipped ").$out(getTraceName(curStackElement)).$out(" [").$out_uint(begOffset).$out("-").$out_uint(endOffset).$out("]\n").flush();
      }
      curStackElement.onSourceRangeSkipped(begOffset, endOffset);
    }
  }

  @Override
  public final void DeepFileInclusion(SourceLocation HashLoc, SourceLocation EodLoc, Token IncludeTok, StringRef FileName, boolean IsAngled, CharSourceRange FilenameRange) {
    onDeepInclusion();
  }

  /// End of Implementation of PPCallbacks methods
  
  private static String getTraceName(FileEntry FE, int/*FileID*/ FID) {
    return FE == null ? ("" + FID) : new std.string(FE.getName()).toJavaString();
  }

  private static String getTraceName(FileInfo FileInfo) {
    if (FileInfo == null) {
      return "null";
    }
    if (FileInfo.isFile()) {
      return (FileInfo.isMainFile() ? "[MainFile] " : "") + Casts.toJavaString(FileInfo.getName());
    }
    return "" + FileInfo.getFileID();
  }

  private void FileEnterImpl(FileEntry enteredFile, int/*FileID*/ enteredFID, SrcMgr.CharacteristicKind FileType, boolean startOfMainFile) {
    if (FileID.isInvalid(enteredFID)) {
        traceOS.$out("Invalid file is passed to onFileEnter ").$out(getTraceName(enteredFile, enteredFID)).$out("\n").flush();
        return;
    }
    if (TRACE) {
      traceOS.$out("onFileEnter ").$out(startOfMainFile ? "Main " : "").$out("File ").$out(getTraceName(enteredFile, enteredFID)).$out("\n").flush();
    }
    if (!startOfMainFile) {
      if (includeStack.empty()) {
        traceOS.$out("No entries on InclusionDirective ").$out(getTraceName(enteredFile, enteredFID)).$out("\n").flush();
        return;
      }
      // notify current file about enter inner include
      assert curStackElement == includeStack.back();
      curStackElement.enterInnerInclude();
    }
    /*SourceLocation*/int StartOfFile = SM.getLocForStartOfFile(enteredFID);
    // push included on stack
    FileInfo enterFrom = curStackElement;
    curStackElement = new FileInfo(PP, enteredFile, enteredFID, StartOfFile, FileType, startOfMainFile, curIndex++, curInclusionDirectiveInfo);
    curStackElement.enter();
    includeStack.push_back(curStackElement);
    curStackElementLocForStartOfFile = StartOfFile;
    curStackElementSawErrorDirective = false;
    curStackElementTokens = null;
    curStackElementTokensCount = 0;
    onEnter(enterFrom, curStackElement);
    updatePreprocessorStates();
    if (needTokensState) {
      curStackElement.prepareTokens(poolOfTokens);
      curStackElementTokens = curStackElement.tokens;
      if (curStackElementTokens != null) {
        curStackElementTokensCount = curStackElementTokens.size();
      }
    }
  }

  private void FileExitImpl(FileEntry exitedFile, int/*FileID*/ exitedFID, boolean EndOfMainFile) {
    if (FileID.isInvalid(exitedFID)) {
      traceOS.$out("Invalid file is passed to onFileExit ").$out(getTraceName(exitedFile, exitedFID)).$out("\n").flush();
      return;
    }
    if (TRACE) {
      traceOS.$out("onFileExit ").$out(EndOfMainFile ? "Main " : "").$out("File ").$out(getTraceName(exitedFile, exitedFID)).$out("\n").flush();
    }
    if (includeStack.empty()) {
      traceOS.$out("No entries on exitAndPopFile ").$out(getTraceName(exitedFile, exitedFID)).$out("\n").flush();
      return;
    }
    // pop included file
    FileInfo exitedFrom = curStackElement;
    assert curStackElement == includeStack.back();
//    if (std.strcmp(file.getName(),expectedFile.getName()) != 0) {
    if (curStackElement.getFileID() != exitedFID) {
      traceOS.$out("onFileExit ").$out("" + curStackElement);
      traceOS.$out(" vs ").$out(getTraceName(exitedFile, exitedFID)).$out("\n").flush();
      return;
    }
    includeStack.pop_back();
    curStackElement.exit();
    FileInfo exitedTo = EndOfMainFile ? null : includeStack.back();
    onExit(exitedFrom, exitedTo);
    // we can reuse tokens
    curStackElement.releaseTokensIfPossible(poolOfTokens);
    curStackElementTokens = null;
    curStackElementTokensCount = 0;
    curStackElement = null;
    curStackElementLocForStartOfFile = -1;
    curStackElementSawErrorDirective = false;
    if (!EndOfMainFile) {
      if (includeStack.empty()) {
        traceOS.$out("No parent entries for FileChanged:ExitFile \n").flush();
        return;
      }
      // init current context
      curStackElement = exitedTo;
      curStackElementTokens = curStackElement.tokens;
      if (curStackElementTokens != null) {
        curStackElementTokensCount = curStackElementTokens.size();
      }
      curStackElementLocForStartOfFile = curStackElement.StartOfFile;
      curStackElementSawErrorDirective = curStackElement.sawErrorDirective;
      updatePreprocessorStates();
    }
  }

  private void updatePreprocessorStates() {
    needPPDirectivesState = needPPDirectives();
    needTokensState = needTokens();
    needSkippedRangesState = needSkippedRanges();
    needMacroExpansionState = needMacroExpansion();
    needCommentsState = needComments();
    needMacroCommentsState = needMacroComments();
    isStoppedState = isStopped();
    if (isStoppedState) {
      PP.cutOffCurFilePreprocessing();
    } else {
      if (PreprocessorSupport.ALLOW_TO_SKIP_TOKENS_BETWEEN_DIRECTIVES) {
        PP.SetSkipTokensBetweenDirectives(!needTokensState);
      }
      if (needTokensState || needMacroExpansionState) {
        PP.SetCommentRetentionState(needCommentsState, needMacroCommentsState); // see #255481 (inaccuracy in Python)
        PP.SetMacroExpansionOnlyInDirectives(false);
      } else {
        PP.SetCommentRetentionState(false, false);
        PP.SetMacroExpansionOnlyInDirectives(true);
      }
    }
  }

  public final void onToken(Token Tok) {
    assert SM != null;
    if (TRACE_ALL_TOKENS) {
      if (!needTokensState) {
        traceOS.$out($("needTokens FALSE for ")).$out("=>");
      }
      PP.DumpToken(Tok, true, traceOS);
      traceOS.$out($("\n"));
    }    
    if (needTokensState && !isAfterErrorDirective()) {
      if (curStackElementTokensCount >= MAX_GENERATED_TOKENS) {
        // when limit was reached, exit if not EOF 
        return;
      }
      assert curStackElementTokens != null;
      assert (MainFile == null) == (curStackElementTokens == null) : MainFile + " vs. " + curStackElementTokens;
      assert (curStackElementTokens == null) == (includeStack.empty()) : curStackElementTokens + " vs. " + includeStack.size();
      assert curStackElementTokensCount == curStackElementTokens.size() : curStackElementTokensCount + " vs. " + curStackElementTokens.size();
      if (NativeTrace.isDebugMode()) {
        int rawLocation = Tok.$getLocation();
        int tokOffset;
        if (SourceLocation.isFileID(rawLocation)) {
          // this is file's location, let's try to prevent decomposition
          assert SourceLocation.getOffset(rawLocation) == rawLocation;
          tokOffset = rawLocation - curStackElementLocForStartOfFile;
          assert tokOffset == $second_offset(SM.getDecomposedExpansionLoc(rawLocation)) : tokOffset + " vs. " + $second_offset(SM.getDecomposedExpansionLoc(rawLocation));
        } else {
          // decompose location
          tokOffset = $second_offset(SM.getDecomposedExpansionLoc(rawLocation));
        }
        assert Tok.isNot(tok.TokenKind.eod) : "unexpected EOD: " + SM.getBufferName(rawLocation) + ":" + tokOffset;
//      curStackElementTokenExpansionPos.push_back(tokOffset);
      }
      // no need to copy, it's done by SmallVectorToken
      curStackElementTokens.push_back(Tok);
      curStackElementTokensCount++;
      if (TRACE_TOKEN) {
        PP.DumpToken(Tok, true, traceOS);
        traceOS.$out($("\n"));
      }
      assert curStackElementTokensCount == curStackElementTokens.size() : 
          curStackElementTokensCount + " vs. " + curStackElementTokens.size();      
    }
  }
  
  private void tryMarkMacroIdentifier(Token possibleMacroToken) {
    if (possibleMacroToken != null && possibleMacroToken.isAnyIdentifier()) {
      IdentifierInfo identInfo = possibleMacroToken.getIdentifierInfo();
      if (identInfo != null && identInfo.hasMacroDefinition()) {
        MacroDefinition MD = PP.getMacroDefinition(identInfo);
        if (MD.$bool()) {
          curStackElement.onMacroUsage(possibleMacroToken, MD);
        }
      }
    }
  }

  // TODO: pragma once
  // TOOD: #error "msg"

  private int curIndex = 0;

  protected static class PreprocessorDirectiveInfo {
    private final /*uint*/int HashOffset;
    private final /*uint*/int EodOffset;
    private Object clientAnnotation;

    private PreprocessorDirectiveInfo(/*uint*/int HashOffset, /*uint*/int EodOffset) {
      this.HashOffset = HashOffset;
      this.EodOffset =  EodOffset;
    }

    public final int getHashOffset() {
      return HashOffset;
    }

    public final int getEodOffset() {
      return EodOffset;
    }

    public final void setAnnotation(Object annotation) {
      assert this.clientAnnotation == null : "replacing? " + this.clientAnnotation;
      this.clientAnnotation = annotation;
    }

    public final Object getAnnotation() {
      return clientAnnotation;
    }

    @Override
    public String toString() {
      return "[" + HashOffset + "-" + EodOffset + "]" +
          (clientAnnotation != null ? (" annotation=" + clientAnnotation.getClass().getSimpleName()) : "");
    }
  }

  protected final static class UserDiagnosticDirectiveInfo extends PreprocessorDirectiveInfo {
    private final boolean isWarning;
    private final StringRef Msg;

    private UserDiagnosticDirectiveInfo(/*uint*/int HashOffset, /*uint*/int EodOffset,
        StringRef Msg, boolean isWarning) {
      super(HashOffset, EodOffset);
      this.Msg = new StringRef(Msg);
      this.isWarning = isWarning;
    }

    public StringRef getMessage() {
      return Msg;
    }

    public boolean isWarning() {
      return isWarning;
    }
  }

  protected final static class InclusionDirectiveInfo extends PreprocessorDirectiveInfo {
    private final boolean IsAngled;
    private final /*const*/FileEntry /*P*/ File;
    private final StringRef FileName;
    private final StringRef SearchPath;

    private InclusionDirectiveInfo(/*uint*/int HashOffset, /*uint*/int EodOffset,
                    boolean IsAngled, /*const*/FileEntry /*P*/ File,
                    StringRef FileName, StringRef SearchPath) {
      super(HashOffset, EodOffset);
      this.IsAngled = IsAngled;
      this.File = File;
      this.FileName = new StringRef(FileName);
      this.SearchPath = new StringRef(SearchPath);
    }

    public StringRef getSearchPath() {
      return SearchPath;
    }

    public StringRef getFileNameSpelling() {
      return FileName;
    }

    public boolean isAngled() {
      return IsAngled;
    }

    public FileEntry getFileEntry() {
      return File;
    }

    @Override
    public String toString() {
      return super.toString() + " InclusionDirectiveInfo{" + "IsAngled=" + IsAngled + ",\n"
          + " File=" + File + ",\n"
          + " FileName=" + FileName + ",\n"
          + " SearchPath=" + SearchPath + ",\n"
          + '}';
    }


  }

  protected final static class MacroDefinitionInfo extends PreprocessorDirectiveInfo {
    private final IdentifierInfo MacroName;
    private final /*SourceLocation*/int MacroNameLocation;
    private final boolean defined;
    private final IdentifierInfo[] arguments;
    private final boolean isVariadic;
    private final FileInfo fileOwner;

    private MacroDefinitionInfo(FileInfo owner, /*uint*/int HashOffset, /*uint*/int EodOffset,
        Token MacroNameTok, IdentifierInfo[] args, boolean lastArgIsVariadic, boolean defined) {
      super(HashOffset, EodOffset);
      this.fileOwner = owner;
      this.MacroName = MacroNameTok.getIdentifierInfo();
      assert this.MacroName != null : "where is macro name? " + MacroNameTok;
      this.MacroNameLocation = MacroNameTok.$getLocation();
      this.arguments = args;
      this.isVariadic = lastArgIsVariadic;
      this.defined = defined;
    }

    public boolean isDefined() {
      return defined;
    }

    public FileInfo getFileOwner() {
      return fileOwner;
    }
    
    public IdentifierInfo getMacroName() {
      return MacroName;
    }

    public /*SourceLocation*/int getMacroNameLocation() {
      return MacroNameLocation;
    }

    public boolean isFunctionLike() {
      return arguments != null;
    }

    public IdentifierInfo[] getArguments() {
      return this.arguments;
    }

    public boolean isVariadic() {
      return this.isVariadic;
    }

    @Override
    public String toString() {
      return super.toString() + " MacroDefinitionInfo{NameAt=" + SourceLocation.getFromRawEncoding(MacroNameLocation) 
          + "\nMacroName=" + MacroName + ",\n"
          + " defined=" + defined + '}';
    }
  }

  public static class MacroUsageInfo {
    // referenced token 
    private final /*SourceLocation*/int macroUsageLocation;
    private final /*uint*/int macroTokenLength;
    // referenced macro definition
    private final MacroDefinition MD;
    private final IdentifierInfo UsedMacroName;
    
    /*package*/ MacroUsageInfo(/*SourceLocation*/int macroUsageLocation, /*uint*/int macroTokenLength, 
            MacroDefinition MD, IdentifierInfo MacroName) {
      this.macroUsageLocation = macroUsageLocation;
      this.macroTokenLength =  macroTokenLength;
      this.MD = MD;
      this.UsedMacroName = MacroName;
    }

    public final /*SourceLocation*/int getUsedMacroNameLocation() {
      return macroUsageLocation;
    }

    public final int getUsedMacroNameLength() {
      return macroTokenLength;
    }

    public MacroDefinition getReferencedMacroDefinition() {
      return MD;
    }
    
    public IdentifierInfo getUsedMacroName() {
      return UsedMacroName;
    }
    
    @Override
    public String toString() {
      return super.toString() + " MacroUsageInfo{" + SourceLocation.getFromRawEncoding(macroUsageLocation) 
          + "\nUsedMacroName=" + UsedMacroName + '}';
    }    
  }

  public static class MacroExpansionInfo {
    private final /*uint*/int startOffset;
    private final /*uint*/int endOffset;
    private final /*uint*/int macroNameLength;
    private final long/*<SourceLocation, SourceLocation>*/ curExpansionRange;
    // referenced macro definition
    private final MacroDefinition MD;
    private final IdentifierInfo ExpandedMacroName;

    /*package*/ MacroExpansionInfo(/*uint*/int StartOffset, /*uint*/int EndOffset, /*uint*/int macroNameLength,
            SourceRange ExpansionRange, MacroDefinition MD, IdentifierInfo II) {
      this.startOffset = StartOffset;
      this.endOffset =  EndOffset;
      this.macroNameLength = macroNameLength;
      this.curExpansionRange = wrap_SourceLocation_SourceLocation(ExpansionRange.$getBegin(), ExpansionRange.$getEnd());
      this.MD = MD;
      assert II != null;
      this.ExpandedMacroName = II;
    }

    public final int getStartOffset() {
      return startOffset;
    }

    public final int getEndOffset() {
      return endOffset;
    }

    public final int getMacroNameLength() {
      return macroNameLength;
    }

    public long/*<SourceLocation, SourceLocation>*/ $getExpansionRange() {
      return curExpansionRange;
    }

    public MacroDefinition getReferencedMacroDefinition() {
      return MD;
    }

    public IdentifierInfo getExpandedMacroName() {
      return ExpandedMacroName;
    }

    public SourceRange getExpansionRange() {
      return new SourceRange($first_SourceLocation(curExpansionRange), $second_SourceLocation(curExpansionRange));
    }

    @Override
    public String toString() {
      return "ExpansionInfo [" + startOffset + "-" + endOffset + ";" + getExpansionRange() + "]";
    }
  }
  
  public static final class FileGuardInfo {
    private final IdentifierInfo IfDefMacro;
    private final /*SourceLocation*/int IfDefMacroLocation;
    private final IdentifierInfo DefMacro;
    private final /*SourceLocation*/int DefinedMacroLocation;

    /*package*/ FileGuardInfo(IdentifierInfo IfDefMacro, /*SourceLocation*/ int IfDefMacroLocation, 
            IdentifierInfo DefMacro, /*SourceLocation*/ int DefinedMacroLocation) {
      this.IfDefMacro = IfDefMacro;
      this.IfDefMacroLocation = IfDefMacroLocation;
      this.DefMacro = DefMacro;
      this.DefinedMacroLocation = DefinedMacroLocation;
    }

    public IdentifierInfo getIfDefMacro() {
      return IfDefMacro;
    }

    public /*SourceLocation*/int getIfDefMacroLocation() {
      return IfDefMacroLocation;
    }

    public IdentifierInfo getDefinedMacro() {
      return DefMacro;
    }

    public /*SourceLocation*/int getDefinedMacroLocation() {
      return DefinedMacroLocation;
    }

    @Override
    public String toString() {
      return "FileGuardInfo{" + "IfDefMacro=" + IfDefMacro + // NOI18N
              ", IfDefMacroLocation=" + SourceLocation.getFromRawEncoding(IfDefMacroLocation) + // NOI18N
              ", DefMacro=" + DefMacro + // NOI18N
              ", DefinedMacroLocation=" + SourceLocation.getFromRawEncoding(DefinedMacroLocation) + '}'; // NOI18N
    }
  }

  private static String getConditionValueKindText(ConditionValueKind kind) {
    switch (kind) {
      case CVK_True:
        return "true";
      case CVK_False:
        return "false";
    }
    return  "unevaluated";
  }
}
