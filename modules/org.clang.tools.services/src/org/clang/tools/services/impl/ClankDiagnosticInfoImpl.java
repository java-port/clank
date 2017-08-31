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

package org.clang.tools.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import org.clang.basic.CharSourceRange;
import org.clang.basic.Diagnostic;
import org.clang.basic.DiagnosticIDs;
import org.clang.basic.DiagnosticsEngine;
import org.clang.basic.FileID;
import org.clang.basic.FixItHint;
import org.clank.support.aliases.*;
import static org.clang.basic.JavaBasicGlobals.$second_offset;
import org.clang.basic.LangOptions;
import org.clang.basic.PresumedLoc;
import org.clang.basic.SourceLocation;
import org.clang.basic.SourceManager;
import org.clang.basic.SourceRange;
import org.clang.basic.java.diagJava;
import org.clang.basic.llvm.DenseMapInfoFileID;
import org.clang.lex.Lexer;
import org.clang.tools.services.ClankDiagnosticEnhancedFix;
import org.clang.tools.services.ClankDiagnosticInfo;
import org.clang.tools.services.support.ClangUtilities;
import org.clank.java.std;
import org.clank.java.std_pair;
import org.clank.support.JavaDifferentiators;
import org.clank.support.Native;
import static org.clank.support.Native.$noteq_iter;
import static org.clank.support.Native.$tryClone;
import org.llvm.adt.SmallString;
import org.llvm.adt.aliases.ArrayRef;
import org.llvm.adt.aliases.SmallDenseMap;
import org.llvm.adt.aliases.SmallVector;
import org.llvm.adt.aliases.SmallVectorImpl;

/**
 *
 * @author masha
 */
class ClankDiagnosticInfoImpl implements ClankDiagnosticInfo {

//  private final DiagnosticsEngine.Level DiagLevel;
  private final String sourceFileName;
  private final String id;
  private final String category;
  private final int[] startOffsets;
  private final int[] endOffsets;
  private final String msg;
  private final Collection<ClankDiagnosticEnhancedFix> fixes = new ArrayList<>();
  private final ArrayList<ClankDiagnosticInfo> notes = new ArrayList<>();
  private final Severity severity;
  private String msgPrefix = "";
  private ClankDiagnosticInfo parent = null;
  private final LangOptions /*&*/ LangOpts;

  ClankDiagnosticInfoImpl(DiagnosticsEngine.Level DiagLevel, Diagnostic Info, LangOptions /*&*/ LangOpts) {
//    this.DiagLevel = DiagLevel;
    SmallString out = new SmallString(1024);
    Info.FormatDiagnostic(out);
    //  String Loc = "";
    this.LangOpts = LangOpts;
    this.severity = Severity.valueOf(DiagLevel.getValue());
    this.id  = diagJava.$name(Info.getID());
    this.category = DiagnosticIDs.getCategoryNameFromID(DiagnosticIDs.getCategoryNumberForDiag(Info.getID())).toJavaString();
    if (!Info.hasSourceManager()) {
      startOffsets = new int[]{0};
      endOffsets = new int[]{0};
      msg = "NO Source Manager";
      sourceFileName = null;
      return;
    }
    String fileName = "";

    SourceManager SM = Info.getSourceManager();
    PresumedLoc presumedLoc = SM.getPresumedLoc(Info.getLocation());
    String Loc = "";
    if (presumedLoc.isValid()) {
      //    line = presumedLoc.getLine();
      //  col = presumedLoc.getColumn();
      fileName = Native.$toString(presumedLoc.getFilename());
      Loc = " " + fileName + " " + presumedLoc.getLine() + ":" + presumedLoc.getColumn() + "\n";
    }
    sourceFileName = fileName;
   ArrayRef<CharSourceRange> Ranges = Info.getRanges();
          // Get the ranges into a local array we can hack on.
      SmallVector<CharSourceRange/*,20*/> MutableRanges/*J*/= new SmallVector<CharSourceRange/*,20*/>(20, Ranges.begin(), 
          Ranges.end(), new CharSourceRange());
      

    SmallVector<CharSourceRange/*,4*/> SpellingRanges/*J*/ = new SmallVector<CharSourceRange/*,4*/>(4, new CharSourceRange());
    mapDiagnosticRanges(/*NO_COPY*/new SourceLocation(Info.getLocation()), /*NO_COPY*/ new ArrayRef<CharSourceRange>(MutableRanges), SpellingRanges, /*AddrOf*/ SM);
    int[] startOffsets_ = new int[SpellingRanges.size()];
    int[] endOffsets_ = new int[SpellingRanges.size()];
    if (SpellingRanges.empty()) {
      std_pair.pairTypeUInt<FileID> decomposedExpansionLoc = SM.getDecomposedExpansionLoc(Info.getLocation());
      startOffsets_ = new int[]{decomposedExpansionLoc.second};
//      long/*<FileID, uint>*/ decomposedLocEnd = SM.getDecomposedLoc(EndLocRawEncoding);
      endOffsets_ = new int[]{decomposedExpansionLoc.second + 1};
//      startOffsets_ = new int[]{begOffset};
//      endOffsets_ = new int[]{startOffsets_[0] + 1};      
    } else {
      startOffsets_ = new int[SpellingRanges.size()];
      endOffsets_ = new int[SpellingRanges.size()];
      int i = 0;
      for (type$ptr<CharSourceRange> I = SpellingRanges.begin(), E = SpellingRanges.end(); $noteq_iter(I, E); I.$preInc())  {
        startOffsets_[i] = SM.getDecomposedExpansionLoc(I.$star().getBegin()).second;
        endOffsets_[i] = SM.getDecomposedExpansionLoc(I.$star().getEnd()).second;        
        if (I.$star().isTokenRange()) {
          endOffsets_[i] +=  Lexer.MeasureTokenLength(/*NO_COPY*/I.$star().getEnd(), SM, LangOpts);
        }
        i++;        
      }
    }
    //OLD implementation: doesn;t work for JConvert test file : Annotation.cpp and therefore had to use copy of mapDiagnosticRanges
//    ArrayRef<CharSourceRange> ranges = Info.getRanges();
//    int[] startOffsets_ = new int[ranges.size()];
//    int[] endOffsets_= new int[ranges.size()];
//    ArrayList<CharSourceRange> sortedRanges = new ArrayList<>();
//    for (CharSourceRange range : ranges) {
//      if (!range.isValid()) {//ignore invalid ranges
//        continue;
//      }
//      sortedRanges.add(range);
//    }
//    Collections.sort(sortedRanges, new Comparator<CharSourceRange>() {
//      @Override
//      public int compare(CharSourceRange o1, CharSourceRange o2) {
//        int x = o1.$getBegin();
//        int y  = o2.$getBegin();
//        return (x < y) ? -1 : ((x == y) ? 0 : 1);
//      }
//    });
//      
//    long/*<FileID, uint>*/ decomposedLocBegin = SM.getDecomposedLoc(Info.getLocation().getRawEncoding());
//    int begOffset = $second_offset(decomposedLocBegin);
//    int EndLocRawEncoding = Info.getLocation().getRawEncoding();
//    if (sortedRanges.isEmpty()) {
//      std_pair.pairTypeUInt<FileID> decomposedExpansionLoc = SM.getDecomposedExpansionLoc(Info.getLocation());
//      startOffsets_ = new int[]{decomposedExpansionLoc.second};
////      long/*<FileID, uint>*/ decomposedLocEnd = SM.getDecomposedLoc(EndLocRawEncoding);
//      endOffsets_ = new int[]{decomposedExpansionLoc.second + 1};
////      startOffsets_ = new int[]{begOffset};
////      endOffsets_ = new int[]{startOffsets_[0] + 1};      
//    } else {
//
//      for (int i = 0; i < sortedRanges.size(); i++) {
//        CharSourceRange range = sortedRanges.get(i);
//        SourceLocation StartLocation = range.getBegin();
//        SourceLocation EndLocation = range.getEnd();
//        long/*startoffset,endoffset*/ sourceLocationToOffsets = sourceLocationToOffsets(SM, StartLocation, EndLocation);
//        startOffsets_[i] = std_pair.$first_int(sourceLocationToOffsets);
//        if (range.isValid()) {
//          EndLocRawEncoding = range.$getEnd();
//          if (range.isTokenRange()) {
//            // need to adjust end location by token length
//            int TokSize = Lexer.MeasureTokenLength(EndLocRawEncoding, SM, LangOpts);
//            EndLocRawEncoding = SourceLocation.$getLocWithOffset(EndLocRawEncoding, TokSize);
//      }
//    }
//        int endOffset;
//        if (SourceLocation.isMacroID(EndLocRawEncoding)) {
//          // need to adjust to the end of macro expansion
//          long/*<SourceLocation, SourceLocation>*/ curExpansionRange = SM.getExpansionRange(EndLocRawEncoding);
//          long/*<FileID, uint>*/ decomposedRangeEnd = SM.getDecomposedLoc($second_SourceLocation(curExpansionRange));
//          // end offset is start of the last token in expRange, so add TokSize
//          int TokSize = Lexer.MeasureTokenLength($second_SourceLocation(curExpansionRange), SM, LangOpts);
//          endOffset = $second_offset(decomposedRangeEnd);
//          endOffset += TokSize;
//        } else {
//          long/*<FileID, uint>*/ decomposedLocEnd = SM.getDecomposedLoc(EndLocRawEncoding);
//          endOffset = $second_offset(decomposedLocEnd);
//        }
//        endOffsets_[i] = endOffset;
//      }
//    }
    Level level = ClangUtilities.toLoggerLevel(DiagLevel);
    final boolean hasFix = !Info.getFixItHints().empty();
    msg = new std.string(out.data()).toJavaString();
    startOffsets = startOffsets_;

    endOffsets = endOffsets_;
    for (FixItHint fixItHint : Info.getFixItHints()) {
      ClankDiagnosticEnhancedFixImpl fixImpl = new ClankDiagnosticEnhancedFixImpl(msg, Info.getSourceManager(), LangOpts, fixItHint);
      fixes.add(fixImpl);
    }
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getCategory() {
    return category;
  }

  @Override
  public String getMessage() {
    return msgPrefix + msg;
  }

  @Override
  public Severity getSeverity() {
    return severity;
  }

  @Override
  public int[] getStartOffsets() {
    return startOffsets;
  }

  @Override
  public int[] getEndOffsets() {
    return endOffsets;
  }

  @Override
  public boolean hasFixes() {
    return !fixes.isEmpty();
  }

  @Override
  public Collection<ClankDiagnosticEnhancedFix> fixes() {
    return fixes;
  }

  void addNote(ClankDiagnosticInfoImpl note) {
    //note can be a fix
    if (note.hasFixes() && note.getStartOffsets()[0] == getStartOffsets()[0]) {
      this.fixes.addAll(note.fixes);
    } else {
      note.msgPrefix = "(" + (notes.size() + 1) + ") ";
      note.parent = this;
      notes.add(note);
    }
  }

  @Override
  public boolean hasNotes() {
    return !notes.isEmpty();
  }

  @Override
  public ArrayList<ClankDiagnosticInfo> notes() {
    return notes;
  }

  @Override
  public String getSourceFileName() {
    return sourceFileName;
  }

  @Override
  public ClankDiagnosticInfo getParent() {
    return parent;
  }

  private static long sourceLocationToOffsets(SourceManager SM, SourceLocation startLoc, SourceLocation endLocation) {
    long/*<FileID, uint>*/ decomposedLocBegin = SM.getDecomposedLoc(startLoc.getRawEncoding());
    int begOffset = $second_offset(decomposedLocBegin);
    int endOffset = $second_offset(SM.getDecomposedLoc(endLocation.getRawEncoding()));
//    int EndLocRawEncoding = endLocation.getRawEncoding();
//    boolean isValid = SM.getPresumedLoc(startLoc).isValid();
//    if (isValid) {
//      // use end of file name as the end of include directive
//      // instead of EOD which can be after comments
//      EndLocRawEncoding = FilenameRange.$getEnd();
//      if (FilenameRange.isTokenRange()) {
//        // need to adjust end location by token length
//        int TokSize = Lexer.MeasureTokenLength(EndLocRawEncoding, SM, PP.getLangOpts());
//        EndLocRawEncoding = SourceLocation.$getLocWithOffset(EndLocRawEncoding, TokSize);
//      }
//    }
//    int endOffset;
//    if (SourceLocation.isMacroID(EndLocRawEncoding)) {
//      // need to adjust to the end of macro expansion
//      long/*<SourceLocation, SourceLocation>*/ curExpansionRange = SM.getExpansionRange(EndLocRawEncoding);
//      long/*<FileID, uint>*/ decomposedRangeEnd = SM.getDecomposedLoc($second_SourceLocation(curExpansionRange));
//      // end offset is start of the last token in expRange, so add TokSize
//      int TokSize = Lexer.MeasureTokenLength($second_SourceLocation(curExpansionRange), SM, PP.getLangOpts());
//      endOffset = $second_offset(decomposedRangeEnd);
//      endOffset += TokSize;
//    } else {
//      long/*<FileID, uint>*/ decomposedLocEnd = SM.getDecomposedLoc(EndLocRawEncoding);
//      endOffset = $second_offset(decomposedLocEnd);
//    }
//  }

    return std_pair.wrap_uint_uint_pair(begOffset, endOffset);
  }

  public static void mapDiagnosticRanges(SourceLocation CaretLoc,
          ArrayRef<CharSourceRange> Ranges,
          SmallVectorImpl<CharSourceRange> /*&*/ SpellingRanges,
          /*const*/ SourceManager /*P*/ SM) {
    FileID CaretLocFileID = SM.getFileID(/*NO_COPY*/CaretLoc);

    for (type$ptr</*const*/ CharSourceRange> /*P*/ I = $tryClone(Ranges.begin()), /*P*/ E = Ranges.end(); I.$noteq(E); I.$preInc()) {
      if (I.$star().isInvalid()) {
        continue;
      }

      SourceLocation Begin = I.$star().getBegin(), End = I.$star().getEnd();
      boolean IsTokenRange = I.$star().isTokenRange();

      FileID BeginFileID = SM.getFileID(/*NO_COPY*/Begin);
      FileID EndFileID = SM.getFileID(/*NO_COPY*/End);

      // Find the common parent for the beginning and end of the range.
      // First, crawl the expansion chain for the beginning of the range.
      SmallDenseMap<FileID, SourceLocation> BeginLocsMap/*J*/ = new SmallDenseMap<FileID, SourceLocation>(DenseMapInfoFileID.$Info(), new SourceLocation());
      while (Begin.isMacroID() && BeginFileID.$noteq(EndFileID)) {
        BeginLocsMap.$at_T1$C$R(BeginFileID).$assign(Begin);
        Begin.$assignMove(SM.getImmediateExpansionRange(/*NO_COPY*/Begin).first);
        BeginFileID.$assignMove(SM.getFileID(/*NO_COPY*/Begin));
      }

      // Then, crawl the expansion chain for the end of the range.
      if (BeginFileID.$noteq(EndFileID)) {
        while (End.isMacroID() && !(BeginLocsMap.count(EndFileID) != 0)) {
          End.$assignMove(SM.getImmediateExpansionRange(/*NO_COPY*/End).second);
          EndFileID.$assignMove(SM.getFileID(/*NO_COPY*/End));
        }
        if (End.isMacroID()) {
          Begin.$assign(BeginLocsMap.$at_T1$C$R(EndFileID));
          BeginFileID.$assign(EndFileID);
        }
      }

      // Do the backtracking.
      SmallVector<FileID> CommonArgExpansions/*J*/ = new SmallVector<FileID>(4, new FileID());
      computeCommonMacroArgExpansionFileIDs(new SourceLocation(Begin), new SourceLocation(End), SM, CommonArgExpansions);
      Begin.$assignMove(retrieveMacroLocation(new SourceLocation(Begin), new FileID(BeginFileID), new FileID(CaretLocFileID),
              CommonArgExpansions, /*IsBegin=*/ true, SM));
      End.$assignMove(retrieveMacroLocation(new SourceLocation(End), new FileID(BeginFileID), new FileID(CaretLocFileID),
              CommonArgExpansions, /*IsBegin=*/ false, SM));
      if (Begin.isInvalid() || End.isInvalid()) {
        continue;
      }

      // Return the spelling location of the beginning and end of the range.
      Begin.$assignMove(SM.getSpellingLoc(/*NO_COPY*/Begin));
      End.$assignMove(SM.getSpellingLoc(/*NO_COPY*/End));

      SpellingRanges.push_back(new CharSourceRange(new SourceRange(/*NO_COPY*/Begin, /*NO_COPY*/ End),
              IsTokenRange));
    }
  }

  public static void computeCommonMacroArgExpansionFileIDs(SourceLocation Begin, SourceLocation End, /*const*/ SourceManager /*P*/ SM,
          SmallVectorImpl<FileID> /*&*/ CommonArgExpansions) {
    SmallVector<FileID> BeginArgExpansions/*J*/ = new SmallVector<FileID>(4, new FileID());
    SmallVector<FileID> EndArgExpansions/*J*/ = new SmallVector<FileID>(4, new FileID());
    getMacroArgExpansionFileIDs(new SourceLocation(Begin), BeginArgExpansions, /*IsBegin=*/ true, SM);
    getMacroArgExpansionFileIDs(new SourceLocation(End), EndArgExpansions, /*IsBegin=*/ false, SM);
    std.sort(BeginArgExpansions.begin(), BeginArgExpansions.end());
    std.sort(EndArgExpansions.begin(), EndArgExpansions.end());
    std.set_intersection(BeginArgExpansions.begin(), BeginArgExpansions.end(),
            EndArgExpansions.begin(), EndArgExpansions.end(),
            std.back_inserter(CommonArgExpansions));
  }

  public static void getMacroArgExpansionFileIDs(SourceLocation Loc,
          SmallVectorImpl<FileID> /*&*/ IDs,
          boolean IsBegin, /*const*/ SourceManager /*P*/ SM) {
    while (Loc.isMacroID()) {
      if (SM.isMacroArgExpansion(/*NO_COPY*/Loc)) {
        IDs.push_back(SM.getFileID(/*NO_COPY*/Loc));
        Loc.$assignMove(SM.getImmediateSpellingLoc(/*NO_COPY*/Loc));
      } else {
        std_pair.pair<SourceLocation, SourceLocation> ExpRange = SM.getImmediateExpansionRange(/*NO_COPY*/Loc);
        Loc.$assign(IsBegin ? ExpRange.first : ExpRange.second);
      }
    }
  }

  public static SourceLocation retrieveMacroLocation(SourceLocation Loc, FileID MacroFileID,
          FileID CaretFileID,
          /*const*/ SmallVectorImpl<FileID> /*&*/ CommonArgExpansions,
          boolean IsBegin, /*const*/ SourceManager /*P*/ SM) {
    assert (SM.getFileID(/*NO_COPY*/Loc).$eq(MacroFileID));
    if (MacroFileID.$eq(CaretFileID)) {
      return new SourceLocation(JavaDifferentiators.JD$Move.INSTANCE, Loc);
    }
    if (!Loc.isMacroID()) {
      return new SourceLocation();
    }

    SourceLocation MacroLocation/*J*/ = new SourceLocation(), MacroArgLocation/*J*/ = new SourceLocation();
    if (SM.isMacroArgExpansion(/*NO_COPY*/Loc)) {
      // Only look at the immediate spelling location of this macro argument if
      // the other location in the source range is also present in that expansion.
      if (std.binary_search(CommonArgExpansions.begin$Const(),
              CommonArgExpansions.end$Const(), MacroFileID)) {
        MacroLocation.$assignMove(SM.getImmediateSpellingLoc(/*NO_COPY*/Loc));
      }
      MacroArgLocation.$assignMove(IsBegin ? new SourceLocation(JavaDifferentiators.JD$Move.INSTANCE, SM.getImmediateExpansionRange(/*NO_COPY*/Loc).first) : new SourceLocation(JavaDifferentiators.JD$Move.INSTANCE, SM.getImmediateExpansionRange(/*NO_COPY*/Loc).second));
    } else {
      MacroLocation.$assignMove(IsBegin ? new SourceLocation(JavaDifferentiators.JD$Move.INSTANCE, SM.getImmediateExpansionRange(/*NO_COPY*/Loc).first) : new SourceLocation(JavaDifferentiators.JD$Move.INSTANCE, SM.getImmediateExpansionRange(/*NO_COPY*/Loc).second));
      MacroArgLocation.$assignMove(SM.getImmediateSpellingLoc(/*NO_COPY*/Loc));
    }
    if (MacroLocation.isValid()) {
      MacroFileID.$assignMove(SM.getFileID(/*NO_COPY*/MacroLocation));
      MacroLocation.$assignMove(
              retrieveMacroLocation(new SourceLocation(MacroLocation), new FileID(MacroFileID), new FileID(CaretFileID),
                      CommonArgExpansions, IsBegin, SM)
      );
      if (MacroLocation.isValid()) {
        return MacroLocation;
      }
    }

    MacroFileID.$assignMove(SM.getFileID(/*NO_COPY*/MacroArgLocation));
    return retrieveMacroLocation(new SourceLocation(MacroArgLocation), new FileID(MacroFileID), new FileID(CaretFileID),
            CommonArgExpansions, IsBegin, SM);
  }
}
