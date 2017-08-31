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

import java.util.concurrent.atomic.AtomicLong;
import org.clang.basic.FileEntry;
import org.clang.basic.IdentifierInfo;
import org.clang.basic.SourceManager;
import org.clang.basic.SourceRange;
import org.clang.basic.SrcMgr;
import org.clang.lex.MacroDefinition;
import org.clang.lex.PPCallbacks;
import org.clang.lex.java.PTHManagerDriver;
import org.clang.lex.Preprocessor;
import org.clang.lex.llvm.SmallVectorToken;
import org.clang.lex.Token;
import org.clank.java.std;
import org.clank.support.Casts;
import org.clank.support.NativePointer;
import org.clank.support.NativeTrace;
import static org.clank.java.std_pair.*;
import org.clank.support.aliases.char$ptr;
import org.llvm.adt.aliases.SmallVector;
import org.llvm.adt.aliases.StringMap;
import org.llvm.adt.aliases.StringMapEntry;
import org.llvm.support.llvm;

/**
 *
 * @author Vladimir Voskresensky
 */
public final class FileInfo {
  private static final SmallVector<?> EMPTY = new SmallVector(0);
  private final char$ptr file;
  private final int includeIndex;
  SmallVectorToken tokens = null;
  boolean sawErrorDirective = false;
  private final SkippedRangeBuilder skipRangeBuilder;
  private int[] skippedRanges;
  private final int fileID;
  private final SrcMgr.CharacteristicKind FileType;
  private final Preprocessor PP;
  private final SourceManager srcMgr;
  private final int includeLocStartOffset;
  private final int includeLocEndOffset;
  final int StartOfFile;
  private final boolean mainFile;
  private final int initialTokensNr;
  private final long FileSize;
  private SmallVector<FileInfoCallback.PreprocessorDirectiveInfo> pp_directives;
  private SmallVector<FileInfoCallback.MacroExpansionInfo> macroExpansions;
  private SmallVector<FileInfoCallback.MacroUsageInfo> macroUsages;
  // #include directive associated with this file info
  private final FileInfoCallback.InclusionDirectiveInfo inclusionDirective;
  
  private SmallVector<FileInfoCallback.FileGuardInfo> fileGuards;

  /*package*/FileInfo(Preprocessor PP, FileEntry enteredFile, /*FileID*/ int FID, /*SourceLocation*/ int StartOfFile, SrcMgr.CharacteristicKind FileType, boolean startOfMainFile, int index, FileInfoCallback.InclusionDirectiveInfo InclusionDirectiveInfo) {
    assert PP != null : "No Preprocessor for " + FID + " " + enteredFile;
    this.PP = PP;
    this.srcMgr = PP.getSourceManager();
    if (enteredFile == null) {
      this.file = NativePointer.$EMPTY;
      this.FileSize = 0;
    } else {
      this.file = enteredFile.getName();
      this.FileSize = enteredFile.getSize();
    }
    this.StartOfFile = StartOfFile;
    assert this.StartOfFile == srcMgr.getLocForStartOfFile(FID);
    // calculate initial tokens capacity based on file size
    int tokNr = (int) (FileSize / FileInfoCallback.FILE_SIZE_TO_TOKENS_RATIO);
    if (tokNr > FileInfoCallback.MAX_INITIAL_TOKENS_CAPACITY) {
      tokNr = FileInfoCallback.MAX_INITIAL_TOKENS_CAPACITY;
    } else if (tokNr < FileInfoCallback.MIN_INITIAL_TOKENS_CAPACITY) {
      // we use pool now, so we can create each new with good size
      // to prevent further relocation/grow
      tokNr = FileInfoCallback.MIN_INITIAL_TOKENS_CAPACITY;
    }
    this.initialTokensNr = tokNr;
    this.includeIndex = index;
    this.skipRangeBuilder = new SkippedRangeBuilder(file);
    this.fileID = FID;
    this.FileType = FileType;
    if (InclusionDirectiveInfo == null) {
      /*<FileID, uint>*/
      long decomposedLoc = srcMgr.getDecomposedIncludedLoc(fileID);
      this.includeLocStartOffset = $second_uint(decomposedLoc);
      this.includeLocEndOffset = this.includeLocStartOffset;
    } else {
      this.includeLocStartOffset = InclusionDirectiveInfo.getHashOffset();
      this.includeLocEndOffset = InclusionDirectiveInfo.getEodOffset();
    }
    this.mainFile = startOfMainFile;
    this.inclusionDirective = InclusionDirectiveInfo;
    this.pp_directives = (SmallVector<FileInfoCallback.PreprocessorDirectiveInfo>)EMPTY;
    this.macroExpansions = (SmallVector<FileInfoCallback.MacroExpansionInfo>)EMPTY;
    this.macroUsages = (SmallVector<FileInfoCallback.MacroUsageInfo>)EMPTY;
    this.fileGuards = (SmallVector<FileInfoCallback.FileGuardInfo>)EMPTY;
  } /*FileID*/ /*SourceLocation*/ // calculate initial tokens capacity based on file size
  // we use pool now, so we can create each new with good size
  // to prevent further relocation/grow
  /*<FileID, uint>*/

  void enterInnerInclude() {
  }

  void enter() {
  }

  /*package*/ long getFileSize() {
    return FileSize;
  }

  void releaseTokensIfPossible(SmallVector<SmallVectorToken> poolOfTokens) {
    if (tokens != null) {
      // push back cleaned tokens to prevent cleaning pool of tokens itself
      // on end of main file
      if (NativeTrace.isDebugMode()) {
        for (int i = 0; i < poolOfTokens.size(); i++) {
          SmallVectorToken toks = poolOfTokens.$at(i);
          assert (toks != tokens) : "tokens already in pool at " + i;
        }
      }
      tokens.clear();
      poolOfTokens.push_back(tokens);
      tokens = null;
    }
  }

  void prepareTokens(SmallVector<SmallVectorToken> poolOfTokens) {
    if (poolOfTokens.empty()) {
      if (NativeTrace.VERBOSE_MODE || NativeTrace.SERVICE_STATISTICS) {
        NrNewVectorTokens.incrementAndGet();
        NrNewTokensCreated.addAndGet(initialTokensNr);
      }
      tokens = new SmallVectorToken(initialTokensNr, null);
    } else {
      tokens = poolOfTokens.pop_back_val();
      if (NativeTrace.VERBOSE_MODE || NativeTrace.SERVICE_STATISTICS) {
        NrReusedVectorTokens.incrementAndGet();
        if (tokens.capacity() >= initialTokensNr) {
          NrReusedVectorTokensWithoutGrow.incrementAndGet();
        }
      }
      tokens.reserve(initialTokensNr);
    }
    assert tokens != null;
    assert tokens.size() == 0 : "" + tokens.size();
  }
  static long MaxNrOfTokensInPoolOnEndOfMainFile = 0;
  static int MaxPoolOfVectorTokensSize = 0;
  private static final AtomicLong NrNewVectorTokens = new AtomicLong(0);
  private static final AtomicLong NrNewTokensCreated = new AtomicLong(0);
  private static final AtomicLong NrReusedVectorTokens = new AtomicLong(0);
  private static final AtomicLong NrReusedVectorTokensWithoutGrow = new AtomicLong(0);
  private static final AtomicLong TotalLexedSize = new AtomicLong(0);
  private static long AllFilesSizeOnce = 0;
  private static long AllHeadersFilesSizeOnce = 0;
  private static long AllSourceFilesSizeOnce = 0;
  private static final AtomicLong AllTokensNr = new AtomicLong(0);
  private static final AtomicLong FilesLessThan10KTokens = new AtomicLong(0);
  private static final AtomicLong HugeTokenInFile = new AtomicLong(0);
  private static final AtomicLong NrExits = new AtomicLong(0);
  private static final AtomicLong NrHits = new AtomicLong(0);
  private static final AtomicLong NrMisses = new AtomicLong(0);
  private static final StringMap<MyFileData/*, BumpPtrAllocator*/> FilesCache = new StringMap<MyFileData/*, BumpPtrAllocator*/>(1024 * 64, null);

  static final class InitialSkippedState {

    private static final int ALL_INCLUDED = 1;
    private static final int NOT_ALL_INCLUDED = 2;
  }

  private static final class MyFileData {

    private final long Size;
    private final int State;
    private final int NrTokens;
    private int NrInclusions;

    private MyFileData(long FileSize, boolean emptySkip, int nrTokens) {
      this.Size = FileSize;
      this.NrTokens = nrTokens;
      if (emptySkip) {
        State = InitialSkippedState.ALL_INCLUDED;
      } else {
        State = InitialSkippedState.NOT_ALL_INCLUDED;
      }
    }
  }
  private static int NrFilesWithInitialAllIncludedOnFirstLex = 0;
  private static int NrFilesWithInitialAllIncludedOnFirstLexButLexedAgain = 0;
  private static long TotalSizeWhichCanBeSkipedForInitialAllIncluded = 0;
  private static int NrFilesWithInitial_NOT_AllIncludedOnFirstLexButLexedAgain = 0;
  private static long TotalSizeWhichCanBeSkipedForInitial_NOT_AllIncluded = 0;
  static final AtomicLong NrSkippedByGuardsFiles = new AtomicLong(0);
  static final AtomicLong NrNotFoundFiles = new AtomicLong(0);

  void exit() {
    skippedRanges = skipRangeBuilder.build();
    collectStatsOnExit();
  }

  private static final boolean TRACE_MAIN_FILE_INFO_ONLY = (NativeTrace.TRACE_FILE_INFO_EXIT < 0);
  private static final int TRACE_FILE_INFO_EXIT_ABS = (NativeTrace.TRACE_FILE_INFO_EXIT >= 0) ? NativeTrace.TRACE_FILE_INFO_EXIT : -NativeTrace.TRACE_FILE_INFO_EXIT;
  private void collectStatsOnExit() {
    if (TRACE_FILE_INFO_EXIT_ABS > 0) {
      // trace file info
      if (this.file != null && this.file != NativePointer.$EMPTY && (!TRACE_MAIN_FILE_INFO_ONLY || this.isMainFile())) {
        if (this.isMainFile()) {
          llvm.errs().$out("EXIT TU ");
        }
        llvm.errs().$out("FileID=").$out_int(fileID).$out(";includeIndex=").$out_int(includeIndex).$out(";").$out(this.file);
        // Lexed tokens info
        if (TRACE_FILE_INFO_EXIT_ABS > 1) {
          llvm.errs().$out("\nTokens: ").$out_int(getNrTokens());
        }
        // trace skip ranges info
        if (TRACE_FILE_INFO_EXIT_ABS > 2) {
          llvm.errs().$out("\nSkip=").$out(skipRangeBuilder.toString(false));
        }
        llvm.errs().$out("\n").flush();
      }
    }
    
    if (NativeTrace.VERBOSE_MODE || NativeTrace.SERVICE_STATISTICS) {
      int nrTokens = getNrTokens();
      if (this.file != null && this.file != NativePointer.$EMPTY ) {
        StringMapEntry<MyFileData> Entry;
        synchronized (FilesCache) {
          Entry = FilesCache.GetOrCreateValue(this.file, std.strlen(this.file));
        }
        synchronized (Entry) {
          if (Entry.second == null) {
            // just created
            AllFilesSizeOnce += FileSize;
            if (this.mainFile) {
              AllSourceFilesSizeOnce += FileSize;
            } else {
              AllHeadersFilesSizeOnce += FileSize;
            }
            boolean allIncluded = skippedRanges.length == 0;
            Entry.second = new MyFileData(FileSize, allIncluded, nrTokens);
            if (allIncluded) {
              NrFilesWithInitialAllIncludedOnFirstLex++;
            }
          } else if (Entry.second.State == InitialSkippedState.ALL_INCLUDED) {
            // how many can be skipped
            NrFilesWithInitialAllIncludedOnFirstLexButLexedAgain++;
            TotalSizeWhichCanBeSkipedForInitialAllIncluded += FileSize;
          } else {
            // how many can not be skipped
            NrFilesWithInitial_NOT_AllIncludedOnFirstLexButLexedAgain++;
            TotalSizeWhichCanBeSkipedForInitial_NOT_AllIncluded += FileSize;
          }
          Entry.second.NrInclusions++;
        }
      }
      TotalLexedSize.addAndGet(FileSize);
      AllTokensNr.addAndGet(nrTokens);
      NrExits.incrementAndGet();
      if (initialTokensNr >= nrTokens) {
        NrHits.incrementAndGet();
      } else {
        if (FileInfoCallback.TRACE) {
          llvm.errs().$out("Inited as ").$out_int(initialTokensNr).$out(" got ").$out_int(nrTokens).$out("\n").flush();
        }
        NrMisses.incrementAndGet();
      }
      if (nrTokens < 10000) {
        FilesLessThan10KTokens.incrementAndGet();
      }
      if (HugeTokenInFile.get() < nrTokens) {
        HugeTokenInFile.set(nrTokens);
        if (FileInfoCallback.TRACE) {
          printTokenStats();
        }
      }
    }    
  }
  
  public static void clearTokenStats() {
    MaxNrOfTokensInPoolOnEndOfMainFile = 0;
    MaxPoolOfVectorTokensSize = 0;
    NrNewVectorTokens.set(0);
    NrNewTokensCreated.set(0);
    NrReusedVectorTokens.set(0);
    NrReusedVectorTokensWithoutGrow.set(0);
    TotalLexedSize.set(0);
    AllFilesSizeOnce = 0;
    AllHeadersFilesSizeOnce = 0;
    AllSourceFilesSizeOnce = 0;
    AllTokensNr.set(0);
    FilesLessThan10KTokens.set(0);
    HugeTokenInFile.set(0);
    NrExits.set(0);
    NrHits.set(0);
    NrMisses.set(0);
    FilesCache.clear();

    NrFilesWithInitialAllIncludedOnFirstLex = 0;
    NrFilesWithInitialAllIncludedOnFirstLexButLexedAgain = 0;
    TotalSizeWhichCanBeSkipedForInitialAllIncluded = 0;
    NrFilesWithInitial_NOT_AllIncludedOnFirstLexButLexedAgain = 0;
    TotalSizeWhichCanBeSkipedForInitial_NOT_AllIncluded = 0;
    NrSkippedByGuardsFiles.set(0);
    NrNotFoundFiles.set(0);
    
    PTHManagerDriver.clearStatistics();
  }
  
  public static void printTokenStats() {
    if (AllFilesSizeOnce == 0) {
      return;
    }
    long TokensDensity = (AllTokensNr.longValue() == 0L) ? 0L : TotalLexedSize.longValue() / AllTokensNr.longValue();
    llvm.errs().$out("Less Than 10K Tokens In ").$out(NativeTrace.formatNumber(FilesLessThan10KTokens.longValue())).
            $out("; Max Tokens: ").$out(NativeTrace.formatNumber(HugeTokenInFile.longValue())).
            $out("; Initial Capacity Hits: ").$out(NativeTrace.formatNumber(NrHits.longValue())).
            $out("; Initial Capacity Misses: ").$out(NativeTrace.formatNumber(NrMisses.longValue())).
            $out("\nAll Tokens: ").$out(NativeTrace.formatNumber(AllTokensNr.longValue())).
            $out("\nNum Lexed Files: ").$out(NativeTrace.formatNumber(NrExits.longValue())).
            $out("\nNum Unique Files: ").$out(NativeTrace.formatNumber(FilesCache.size())).
            $out(" (").$out_long(NrExits.longValue() / FilesCache.size()).$out(" times less)").
            $out("\nTotal Lexed Files Size: ").$out(NativeTrace.formatNumber(TotalLexedSize.longValue())).
            $out("\nTotal Size of Unique Files: ").$out(NativeTrace.formatNumber(AllFilesSizeOnce)).
            $out(" (").$out_long(TotalLexedSize.longValue() / AllFilesSizeOnce).$out(" times less)").
            $out("\n        Size of Main Files: ").$out(NativeTrace.formatNumber(AllSourceFilesSizeOnce)).
            $out("\n      Size of Header Files: ").$out(NativeTrace.formatNumber(AllHeadersFilesSizeOnce)).
            $out("\nAllToks/NumFiles: ").$out_int((int) (AllTokensNr.longValue() / NrExits.longValue())).
            $out("; FileSize/AllToks: ").$out_int((int) TokensDensity).
            $out("\nFirst skipRanges was empty in ").$out(NativeTrace.formatNumber(NrFilesWithInitialAllIncludedOnFirstLex)).$out(" unique files").
            $out("\nTotal Nr of extra Lexed \"Lex-once Files\": ").$out(NativeTrace.formatNumber(NrFilesWithInitialAllIncludedOnFirstLexButLexedAgain)).
            $out("\nTotal Size of extra Lexed \"Lex-once Files\": ").$out(NativeTrace.formatNumber(TotalSizeWhichCanBeSkipedForInitialAllIncluded)).
            $out("\nTotal Nr of extra Lexed NOT \"Lex-once Files\": ").$out(NativeTrace.formatNumber(NrFilesWithInitial_NOT_AllIncludedOnFirstLexButLexedAgain)).
            $out("\nTotal Size of extra Lexed NOT \"Lex-once Files\": ").$out(NativeTrace.formatNumber(TotalSizeWhichCanBeSkipedForInitial_NOT_AllIncluded)).
            $out("\nNum Files skipped by guards: ").$out(NativeTrace.formatNumber(NrSkippedByGuardsFiles.longValue())).
            $out("\nNum Unresolved files: ").$out(NativeTrace.formatNumber(NrNotFoundFiles.longValue())).
            $out("\n\t").$out("New Vector Tokens created ").$out(NativeTrace.formatNumber(NrNewVectorTokens.longValue())).
            $out("(with total initial amount ").$out(NativeTrace.formatNumber(NrNewTokensCreated.longValue())).$out(" elements)").
            $out("\n\tVector Tokens reused ").$out(NativeTrace.formatNumber(NrReusedVectorTokens.longValue())).
            $out("(without grow ").$out(NativeTrace.formatNumber(NrReusedVectorTokensWithoutGrow.longValue())).$out(" times)").
            $out("\n\tMax pool size ").$out(NativeTrace.formatNumber(MaxPoolOfVectorTokensSize)).
            $out(" with Max Total Capacity ").$out(NativeTrace.formatNumber(MaxNrOfTokensInPoolOnEndOfMainFile)).$out(" tokens").
            $out("\n").flush();
    PTHManagerDriver.printStats();
  }

  public boolean isMainFile() {
    return mainFile;
  }

  public FileInfoCallback.InclusionDirectiveInfo getInclusionDirective() {
    return inclusionDirective;
  }

  public int[] getSkippedRanges() {
    return skippedRanges;
  }

  public SmallVector<FileInfoCallback.PreprocessorDirectiveInfo> getPreprocessorDirectives() {
    return pp_directives;
  }

  public SmallVector<FileInfoCallback.MacroExpansionInfo> getMacroExpansions() {
    return macroExpansions;
  }

  public SmallVector<FileInfoCallback.MacroUsageInfo> getMacroUsages() {
    return macroUsages;
  }

  public SmallVector<FileInfoCallback.FileGuardInfo> getFileGuardsInfo() {
    return fileGuards;
  }

  public SourceManager getSourceManager() {
    return srcMgr;
  }

  public Preprocessor getPreprocessor() {
    return PP;
  }

  public SrcMgr.CharacteristicKind getFileType() {
    return FileType;
  }

  public boolean isFile() {
    return file != NativePointer.$EMPTY;
  }

  public char$ptr getName() {
    return file;
  }

  public int getFileID() {
    return fileID;
  }

  public int getIncludeIndex() {
    return includeIndex;
  }

  public boolean hasTokens() {
    return tokens != null;
  }

  public int getNrTokens() {
    return tokens == null ? 0 : tokens.size();
  }

  public SmallVectorToken getTokens() {
    return tokens;
  }

  public int getIncludeStartOffset() {
    return includeLocStartOffset;
  }

  public int getIncludeEndOffset() {
    return includeLocEndOffset;
  }

  @Override
  public String toString() {
    return "file=" + fileID + ":" + Casts.toJavaString(file);
  }

  void onPPDirective(FileInfoCallback.PreprocessorDirectiveInfo pp) {
    preparedPPDirectives();
    pp_directives.push_back(pp);
  }

  FileInfoCallback.MacroExpansionInfo onMacroExpands(int begin, int end, int macroNamelength, SourceRange Range, 
          MacroDefinition MD, IdentifierInfo II) {
    prepareMacroExpansions();
    FileInfoCallback.MacroExpansionInfo macroExpansionInfo = new FileInfoCallback.MacroExpansionInfo(begin, end, macroNamelength, Range, MD, II);
    macroExpansions.push_back(macroExpansionInfo);
    return macroExpansionInfo;
  }

  void onSourceRangeSkipped(int begin, int end) {
//    int b = $long2uint(begin);
//    int e = $long2uint(end);
//    skipRangeBuilder.addBlockImpl(b, e);
  }

  void onIf(int begin, int end, int ifOffset, PPCallbacks.ConditionValueKind ConditionValue) {
    skipRangeBuilder.startIf(begin, end, ifOffset, ConditionValue);
  }

  void onMacroUsage(Token MacroNameTok, MacroDefinition MD) {
    if (MD.$bool()) {
      prepareMacroUsages();
      IdentifierInfo UsedMacroName = MacroNameTok.getIdentifierInfo();
      assert UsedMacroName != null : "no name for " + MacroNameTok;
      macroUsages.push_back(new FileInfoCallback.MacroUsageInfo(MacroNameTok.$getLocation(), MacroNameTok.getLength(), MD, UsedMacroName));
    }
  }

  void onElif(int begin, int end, int ifOffset, PPCallbacks.ConditionValueKind ConditionValue) {
    skipRangeBuilder.handleElif(begin, end, ifOffset, ConditionValue);
  }

  void onElse(int begin, int end, int ifOffset) {
    skipRangeBuilder.handleElse(begin, end, ifOffset);
  }

  void onEndif(int begin, int end, int ifOffset) {
    skipRangeBuilder.handleEndif(begin, end, ifOffset);
  }

  void onUserErrorDiagnostic(int begin, int end) {
    skipRangeBuilder.handleErrorDiagnostic(begin, end);
    this.sawErrorDirective = true;
  }

  void onGuardPositionDetected(IdentifierInfo IfDefMacro, /*SourceLocation*/ int IfDefMacroLocation, IdentifierInfo DefMacro, /*SourceLocation*/ int DefinedMacroLocation) {
    prepareFileGuards();
    fileGuards.push_back(new FileInfoCallback.FileGuardInfo(IfDefMacro, IfDefMacroLocation, DefMacro, DefinedMacroLocation));
  }

  void onPragmaOnceDetected(Token once) {
    prepareFileGuards();
    fileGuards.push_back(new FileInfoCallback.FileGuardInfo(once.getIdentifierInfo(), once.$getLocation(), null, -1));
  }
  
  private void prepareFileGuards() {
    if (fileGuards == EMPTY) {
      fileGuards = new SmallVector<>(1, null);
    }
  }

  private void prepareMacroUsages() {
    if (macroUsages == EMPTY) {
      macroUsages = new SmallVector<>(4, null);
    }
  }

  private void prepareMacroExpansions() {
    if (macroExpansions == EMPTY) {
      macroExpansions = new SmallVector<>(4, null);
    }
  }

  private void preparedPPDirectives() {
    if (pp_directives == EMPTY) {
      this.pp_directives = new SmallVector<>(4, null);
    }
  }
}
