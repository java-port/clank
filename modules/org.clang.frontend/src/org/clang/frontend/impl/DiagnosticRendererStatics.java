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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.basic.llvm.DenseMapInfoFileID;
import org.clang.frontend.impl.*;
import org.clang.edit.*;


//<editor-fold defaultstate="collapsed" desc="static type DiagnosticRendererStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZL11mergeFixitsN4llvm8ArrayRefIN5clang9FixItHintEEERKNS1_13SourceManagerERKNS1_11LangOptionsERNS_15SmallVectorImplIS2_EE;_ZL19mapDiagnosticRangesN5clang14SourceLocationEN4llvm8ArrayRefINS_15CharSourceRangeEEERNS1_15SmallVectorImplIS3_EEPKNS_13SourceManagerE;_ZL21retrieveMacroLocationN5clang14SourceLocationENS_6FileIDES1_RKN4llvm15SmallVectorImplIS1_EEbPKNS_13SourceManagerE;_ZL27getMacroArgExpansionFileIDsN5clang14SourceLocationERN4llvm15SmallVectorImplINS_6FileIDEEEbPKNS_13SourceManagerE;_ZL28checkLocForMacroArgExpansionN5clang14SourceLocationERKNS_13SourceManagerES0_;_ZL30checkRangeForMacroArgExpansionN5clang15CharSourceRangeERKNS_13SourceManagerENS_14SourceLocationE;_ZL31checkRangesForMacroArgExpansionN5clang14SourceLocationEN4llvm8ArrayRefINS_15CharSourceRangeEEERKNS_13SourceManagerE;_ZL37computeCommonMacroArgExpansionFileIDsN5clang14SourceLocationES0_PKNS_13SourceManagerERN4llvm15SmallVectorImplINS_6FileIDEEE; -static-type=DiagnosticRendererStatics -package=org.clang.frontend.impl")
//</editor-fold>
public final class DiagnosticRendererStatics {

//<editor-fold defaultstate="collapsed" desc="mergeFixits">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 50,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 92,
 FQN="mergeFixits", NM="_ZL11mergeFixitsN4llvm8ArrayRefIN5clang9FixItHintEEERKNS1_13SourceManagerERKNS1_11LangOptionsERNS_15SmallVectorImplIS2_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZL11mergeFixitsN4llvm8ArrayRefIN5clang9FixItHintEEERKNS1_13SourceManagerERKNS1_11LangOptionsERNS_15SmallVectorImplIS2_EE")
//</editor-fold>
public static void mergeFixits(ArrayRef<FixItHint> FixItHints, 
           /*const*/ SourceManager /*&*/ SM, /*const*/ LangOptions /*&*/ LangOpts, 
           SmallVectorImpl<FixItHint> /*&*/ MergedFixits) {
  Commit commit = null;
  EditedSource Editor = null;
  try {
    commit/*J*/= new Commit(SM, LangOpts);
    for (type$ptr<FixItHint> I = $tryClone(FixItHints.begin()), /*P*/ E = $tryClone(FixItHints.end()); $noteq_ptr(I, E); I.$preInc()) {
      /*const*/ FixItHint /*&*/ Hint = I.$star();
      if (Hint.CodeToInsert.empty()) {
        if (Hint.InsertFromRange.isValid()) {
          commit.insertFromRange(Hint.RemoveRange.getBegin(), 
              new CharSourceRange(Hint.InsertFromRange), /*afterToken=*/ false, 
              Hint.BeforePreviousInsertions);
        } else {
          commit.remove(new CharSourceRange(Hint.RemoveRange));
        }
      } else {
        if (Hint.RemoveRange.isTokenRange()
           || $noteq_SourceLocation$C(Hint.RemoveRange.getBegin(), Hint.RemoveRange.getEnd())) {
          commit.replace(new CharSourceRange(Hint.RemoveRange), new StringRef(Hint.CodeToInsert));
        } else {
          commit.insert(Hint.RemoveRange.getBegin(), new StringRef(Hint.CodeToInsert), 
              /*afterToken=*/ false, Hint.BeforePreviousInsertions);
        }
      }
    }
    
    Editor/*J*/= new EditedSource(SM, LangOpts);
    if (Editor.commit(commit)) {
      FixitReceiver Rec = null;
      try {
        Rec/*J*/= new FixitReceiver(MergedFixits);
        Editor.applyRewrites(Rec);
      } finally {
        if (Rec != null) { Rec.$destroy(); }
      }
    }
  } finally {
    if (Editor != null) { Editor.$destroy(); }
    if (commit != null) { commit.$destroy(); }
  }
}


/// A recursive function to trace all possible backtrace locations
/// to match the \p CaretLocFileID.
//<editor-fold defaultstate="collapsed" desc="retrieveMacroLocation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 270,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 311,
 FQN="retrieveMacroLocation", NM="_ZL21retrieveMacroLocationN5clang14SourceLocationENS_6FileIDES1_RKN4llvm15SmallVectorImplIS1_EEbPKNS_13SourceManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZL21retrieveMacroLocationN5clang14SourceLocationENS_6FileIDES1_RKN4llvm15SmallVectorImplIS1_EEbPKNS_13SourceManagerE")
//</editor-fold>
public static SourceLocation retrieveMacroLocation(SourceLocation Loc, FileID MacroFileID, 
                     FileID CaretFileID, 
                     /*const*/ SmallVectorImpl<FileID> /*&*/ CommonArgExpansions, 
                     boolean IsBegin, /*const*/ SourceManager /*P*/ SM) {
  assert (SM.getFileID(/*NO_COPY*/Loc).$eq(MacroFileID));
  if (MacroFileID.$eq(CaretFileID)) {
    return new SourceLocation(JD$Move.INSTANCE, Loc);
  }
  if (!Loc.isMacroID()) {
    return new SourceLocation();
  }
  
  SourceLocation MacroLocation/*J*/= new SourceLocation(), MacroArgLocation/*J*/= new SourceLocation();
  if (SM.isMacroArgExpansion(/*NO_COPY*/Loc)) {
    // Only look at the immediate spelling location of this macro argument if
    // the other location in the source range is also present in that expansion.
    if (std.binary_search(CommonArgExpansions.begin$Const(), 
        CommonArgExpansions.end$Const(), MacroFileID)) {
      MacroLocation.$assignMove(SM.getImmediateSpellingLoc(/*NO_COPY*/Loc));
    }
    MacroArgLocation.$assignMove(IsBegin ? new SourceLocation(JD$Move.INSTANCE, SM.getImmediateExpansionRange(/*NO_COPY*/Loc).first) : new SourceLocation(JD$Move.INSTANCE, SM.getImmediateExpansionRange(/*NO_COPY*/Loc).second));
  } else {
    MacroLocation.$assignMove(IsBegin ? new SourceLocation(JD$Move.INSTANCE, SM.getImmediateExpansionRange(/*NO_COPY*/Loc).first) : new SourceLocation(JD$Move.INSTANCE, SM.getImmediateExpansionRange(/*NO_COPY*/Loc).second));
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


/// Walk up the chain of macro expansions and collect the FileIDs identifying the
/// expansions.
//<editor-fold defaultstate="collapsed" desc="getMacroArgExpansionFileIDs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 313,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 354,
 FQN="getMacroArgExpansionFileIDs", NM="_ZL27getMacroArgExpansionFileIDsN5clang14SourceLocationERN4llvm15SmallVectorImplINS_6FileIDEEEbPKNS_13SourceManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZL27getMacroArgExpansionFileIDsN5clang14SourceLocationERN4llvm15SmallVectorImplINS_6FileIDEEEbPKNS_13SourceManagerE")
//</editor-fold>
public static void getMacroArgExpansionFileIDs(SourceLocation Loc, 
                           SmallVectorImpl<FileID> /*&*/ IDs, 
                           boolean IsBegin, /*const*/ SourceManager /*P*/ SM) {
  while (Loc.isMacroID()) {
    if (SM.isMacroArgExpansion(/*NO_COPY*/Loc)) {
      IDs.push_back(SM.getFileID(/*NO_COPY*/Loc));
      Loc.$assignMove(SM.getImmediateSpellingLoc(/*NO_COPY*/Loc));
    } else {
      pair<SourceLocation, SourceLocation> ExpRange = SM.getImmediateExpansionRange(/*NO_COPY*/Loc);
      Loc.$assign(IsBegin ? ExpRange.first : ExpRange.second);
    }
  }
}


/// Collect the expansions of the begin and end locations and compute the set
/// intersection. Produces a sorted vector of FileIDs in CommonArgExpansions.
//<editor-fold defaultstate="collapsed" desc="computeCommonMacroArgExpansionFileIDs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 329,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 370,
 FQN="computeCommonMacroArgExpansionFileIDs", NM="_ZL37computeCommonMacroArgExpansionFileIDsN5clang14SourceLocationES0_PKNS_13SourceManagerERN4llvm15SmallVectorImplINS_6FileIDEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZL37computeCommonMacroArgExpansionFileIDsN5clang14SourceLocationES0_PKNS_13SourceManagerERN4llvm15SmallVectorImplINS_6FileIDEEE")
//</editor-fold>
public static void computeCommonMacroArgExpansionFileIDs(SourceLocation Begin, SourceLocation End, /*const*/ SourceManager /*P*/ SM, 
                                     SmallVectorImpl<FileID> /*&*/ CommonArgExpansions) {
  SmallVector<FileID> BeginArgExpansions/*J*/= new SmallVector<FileID>(4, new FileID());
  SmallVector<FileID> EndArgExpansions/*J*/= new SmallVector<FileID>(4, new FileID());
  getMacroArgExpansionFileIDs(new SourceLocation(Begin), BeginArgExpansions, /*IsBegin=*/ true, SM);
  getMacroArgExpansionFileIDs(new SourceLocation(End), EndArgExpansions, /*IsBegin=*/ false, SM);
  std.sort(BeginArgExpansions.begin(), BeginArgExpansions.end());
  std.sort(EndArgExpansions.begin(), EndArgExpansions.end());
  std.set_intersection(BeginArgExpansions.begin(), BeginArgExpansions.end(), 
      EndArgExpansions.begin(), EndArgExpansions.end(), 
      std.back_inserter(CommonArgExpansions));
}


// Helper function to fix up source ranges.  It takes in an array of ranges,
// and outputs an array of ranges where we want to draw the range highlighting
// around the location specified by CaretLoc.
//
// To find locations which correspond to the caret, we crawl the macro caller
// chain for the beginning and end of each range.  If the caret location
// is in a macro expansion, we search each chain for a location
// in the same expansion as the caret; otherwise, we crawl to the top of
// each chain. Two locations are part of the same macro expansion
// iff the FileID is the same.
//<editor-fold defaultstate="collapsed" desc="mapDiagnosticRanges">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 353,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 394,
 FQN="mapDiagnosticRanges", NM="_ZL19mapDiagnosticRangesN5clang14SourceLocationEN4llvm8ArrayRefINS_15CharSourceRangeEEERNS1_15SmallVectorImplIS3_EEPKNS_13SourceManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZL19mapDiagnosticRangesN5clang14SourceLocationEN4llvm8ArrayRefINS_15CharSourceRangeEEERNS1_15SmallVectorImplIS3_EEPKNS_13SourceManagerE")
//</editor-fold>
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
    SmallDenseMap<FileID, SourceLocation> BeginLocsMap/*J*/= new SmallDenseMap<FileID, SourceLocation>(DenseMapInfoFileID.$Info(), new SourceLocation());
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
    SmallVector<FileID> CommonArgExpansions/*J*/= new SmallVector<FileID>(4, new FileID());
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
    
    SpellingRanges.push_back(new CharSourceRange(new SourceRange(/*NO_COPY*/Begin, /*NO_COPY*/End), 
            IsTokenRange));
  }
}


/// Check that the macro argument location of Loc starts with ArgumentLoc.
/// The starting location of the macro expansions is used to differeniate
/// different macro expansions.
//<editor-fold defaultstate="collapsed" desc="checkLocForMacroArgExpansion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 450,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 490,
 FQN="checkLocForMacroArgExpansion", NM="_ZL28checkLocForMacroArgExpansionN5clang14SourceLocationERKNS_13SourceManagerES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZL28checkLocForMacroArgExpansionN5clang14SourceLocationERKNS_13SourceManagerES0_")
//</editor-fold>
public static boolean checkLocForMacroArgExpansion(SourceLocation Loc, 
                            /*const*/ SourceManager /*&*/ SM, 
                            SourceLocation ArgumentLoc) {
  SourceLocation MacroLoc/*J*/= new SourceLocation();
  if (SM.isMacroArgExpansion(/*NO_COPY*/Loc, /*AddrOf*/MacroLoc)) {
    if ($eq_SourceLocation$C(ArgumentLoc, MacroLoc)) {
      return true;
    }
  }
  
  return false;
}


/// Check if all the locations in the range have the same macro argument
/// expansion, and that that expansion starts with ArgumentLoc.
//<editor-fold defaultstate="collapsed" desc="checkRangeForMacroArgExpansion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 463,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 503,
 FQN="checkRangeForMacroArgExpansion", NM="_ZL30checkRangeForMacroArgExpansionN5clang15CharSourceRangeERKNS_13SourceManagerENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZL30checkRangeForMacroArgExpansionN5clang15CharSourceRangeERKNS_13SourceManagerENS_14SourceLocationE")
//</editor-fold>
public static boolean checkRangeForMacroArgExpansion(CharSourceRange Range, 
                              /*const*/ SourceManager /*&*/ SM, 
                              SourceLocation ArgumentLoc) {
  SourceLocation BegLoc = Range.getBegin(), EndLoc = Range.getEnd();
  while ($noteq_SourceLocation$C(BegLoc, EndLoc)) {
    if (!checkLocForMacroArgExpansion(new SourceLocation(BegLoc), SM, new SourceLocation(ArgumentLoc))) {
      return false;
    }
    BegLoc.getLocWithOffset(1);
  }
  
  return checkLocForMacroArgExpansion(new SourceLocation(BegLoc), SM, new SourceLocation(ArgumentLoc));
}


/// A helper function to check if the current ranges are all inside the same
/// macro argument expansion as Loc.
//<editor-fold defaultstate="collapsed" desc="checkRangesForMacroArgExpansion">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 478,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 518,
 FQN="checkRangesForMacroArgExpansion", NM="_ZL31checkRangesForMacroArgExpansionN5clang14SourceLocationEN4llvm8ArrayRefINS_15CharSourceRangeEEERKNS_13SourceManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZL31checkRangesForMacroArgExpansionN5clang14SourceLocationEN4llvm8ArrayRefINS_15CharSourceRangeEEERKNS_13SourceManagerE")
//</editor-fold>
public static boolean checkRangesForMacroArgExpansion(SourceLocation Loc, 
                               ArrayRef<CharSourceRange> Ranges, 
                               /*const*/ SourceManager /*&*/ SM) {
  assert (Loc.isMacroID()) : "Must be a macro expansion!";
  
  SmallVector<CharSourceRange/*,4*/> SpellingRanges/*J*/= new SmallVector<CharSourceRange/*,4*/>(4, new CharSourceRange());
  mapDiagnosticRanges(/*NO_COPY*/Loc, /*NO_COPY*/Ranges, SpellingRanges, /*AddrOf*/SM);
  
  /// Count all valid ranges.
  /*uint*/int ValidCount = 0;
  for (CharSourceRange I : Ranges)  {
    if (I.isValid()) {
      ValidCount++;
    }
  }
  if ($greater_uint(ValidCount, SpellingRanges.size())) {
    return false;
  }
  
  /// To store the source location of the argument location.
  SourceLocation ArgumentLoc/*J*/= new SourceLocation();
  
  /// Set the ArgumentLoc to the beginning location of the expansion of Loc
  /// so to check if the ranges expands to the same beginning location.
  if (!SM.isMacroArgExpansion(/*NO_COPY*/Loc, /*AddrOf*/ArgumentLoc)) {
    return false;
  }
  
  for (type$ptr<CharSourceRange> /*P*/ I = SpellingRanges.begin(), /*P*/ E = SpellingRanges.end(); I.$noteq(E); I.$preInc()) {
    if (!checkRangeForMacroArgExpansion(new CharSourceRange(/*Deref*/I.$star()), SM, new SourceLocation(ArgumentLoc))) {
      return false;
    }
  }
  
  return true;
}

} // END OF class DiagnosticRendererStatics
