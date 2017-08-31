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
package org.clang.format.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.io.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.format.*;
import org.clang.format.java.FormatFunctionPointers.*;


//<editor-fold defaultstate="collapsed" desc="static type WhitespaceManagerFormatStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.format.impl.WhitespaceManagerFormatStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=Tpl__ZN5clang6formatL11AlignTokensERKNS0_11FormatStyleEOT_RN4llvm11SmallVectorINS0_17WhitespaceManager6ChangeELj16EEE;Tpl__ZN5clang6formatL18AlignTokenSequenceEjjjOT_RN4llvm11SmallVectorINS0_17WhitespaceManager6ChangeELj16EEE; -static-type=WhitespaceManagerFormatStatics -package=org.clang.format.impl")
//</editor-fold>
public final class WhitespaceManagerFormatStatics {


// Align a single sequence of tokens, see AlignTokens below.
/*template <typename F> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::format::AlignTokenSequence">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 165,
 FQN="clang::format::AlignTokenSequence", NM="Tpl__ZN5clang6formatL18AlignTokenSequenceEjjjOT_RN4llvm11SmallVectorINS0_17WhitespaceManager6ChangeELj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=Tpl__ZN5clang6formatL18AlignTokenSequenceEjjjOT_RN4llvm11SmallVectorINS0_17WhitespaceManager6ChangeELj16EEE")
//</editor-fold>
public static </*typename*/ F extends Change2Bool> void AlignTokenSequence(/*uint*/int Start, /*uint*/int End, /*uint*/int Column, final F /*&&*/Matches, 
                  final SmallVector<WhitespaceManager.Change> /*&*/ Changes) {
  boolean FoundMatchOnLine = false;
  int Shift = 0;
  for (/*uint*/int i = Start; i != End; ++i) {
    if ($greater_uint(Changes.$at(i).NewlinesBefore, 0)) {
      FoundMatchOnLine = false;
      Shift = 0;
    }
    
    // If this is the first matching token to be aligned, remember by how many
    // spaces it has to be shifted, so the rest of the changes on the line are
    // shifted by the same amount
    if (!FoundMatchOnLine && Matches.$call(Changes.$at(i))) {
      FoundMatchOnLine = true;
      Shift = Column - Changes.$at(i).StartOfTokenColumn;
      Changes.$at(i).Spaces += Shift;
    }
    assert (Shift >= 0);
    Changes.$at(i).StartOfTokenColumn += Shift;
    if (i + 1 != Changes.size()) {
      Changes.$at(i + 1).PreviousEndOfTokenColumn += Shift;
    }
  }
}


// Walk through all of the changes and find sequences of matching tokens to
// align. To do so, keep track of the lines and whether or not a matching token
// was found on a line. If a matching token is found, extend the current
// sequence. If the current line cannot be part of a sequence, e.g. because
// there is an empty line before it or it contains only non-matching tokens,
// finalize the previous sequence.
/*template <typename F> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::format::AlignTokens">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 199,
 FQN="clang::format::AlignTokens", NM="Tpl__ZN5clang6formatL11AlignTokensERKNS0_11FormatStyleEOT_RN4llvm11SmallVectorINS0_17WhitespaceManager6ChangeELj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=Tpl__ZN5clang6formatL11AlignTokensERKNS0_11FormatStyleEOT_RN4llvm11SmallVectorINS0_17WhitespaceManager6ChangeELj16EEE")
//</editor-fold>
public static </*typename*/ F extends Change2Bool> void AlignTokens(final /*const*/ FormatStyle /*&*/ Style, final F /*&&*/Matches, 
           final SmallVector<WhitespaceManager.Change> /*&*/ Changes) {
  final /*uint*/uint$ref MinColumn = create_uint$ref(0);
  final /*uint*/uint$ref MaxColumn = create_uint$ref(UINT_MAX);
  
  // Line number of the start and the end of the current token sequence.
  final /*uint*/uint$ref StartOfSequence = create_uint$ref(0);
  final /*uint*/uint$ref EndOfSequence = create_uint$ref(0);
  
  // Keep track of the nesting level of matching tokens, i.e. the number of
  // surrounding (), [], or {}. We will only align a sequence of matching
  // token that share the same scope depth.
  //
  // FIXME: This could use FormatToken::NestingLevel information, but there is
  // an outstanding issue wrt the brace scopes.
  /*uint*/int NestingLevelOfLastMatch = 0;
  /*uint*/int NestingLevel = 0;
  
  // Keep track of the number of commas before the matching tokens, we will only
  // align a sequence of matching tokens if they are preceded by the same number
  // of commas.
  /*uint*/int CommasBeforeLastMatch = 0;
  /*uint*/int CommasBeforeMatch = 0;
  
  // Whether a matching token has been found on the current line.
  boolean FoundMatchOnLine = false;
  
  // Aligns a sequence of matching tokens, on the MinColumn column.
  //
  // Sequences start from the first matching token to align, and end at the
  // first token of the first line that doesn't need to be aligned.
  //
  // We need to adjust the StartOfTokenColumn of each Change that is on a line
  // containing any matching token to be aligned and located after such token.
  Void2Void AlignCurrentSequence = /*[&]*/() -> {
        if ($greater_uint(StartOfSequence.$deref(), 0) && $less_uint(StartOfSequence.$deref(), EndOfSequence)) {
          AlignTokenSequence(StartOfSequence.$deref(), EndOfSequence.$deref(), MinColumn.$deref(), Matches, 
              Changes);
        }
        MinColumn.$set(0);
        MaxColumn.$set(UINT_MAX);
        StartOfSequence.$set(0);
        EndOfSequence.$set(0);
      };
  
  for (/*uint*/int i = 0, e = Changes.size(); i != e; ++i) {
    if (Changes.$at(i).NewlinesBefore != 0) {
      CommasBeforeMatch = 0;
      EndOfSequence.$set(i);
      // If there is a blank line, or if the last line didn't contain any
      // matching token, the sequence ends here.
      if ($greater_uint(Changes.$at(i).NewlinesBefore, 1) || !FoundMatchOnLine) {
        AlignCurrentSequence.$call();
      }
      
      FoundMatchOnLine = false;
    }
    if (Changes.$at(i).Kind == tok.TokenKind.comma) {
      ++CommasBeforeMatch;
    } else if (Changes.$at(i).Kind == tok.TokenKind.r_brace
       || Changes.$at(i).Kind == tok.TokenKind.r_paren
       || Changes.$at(i).Kind == tok.TokenKind.r_square) {
      --NestingLevel;
    } else if (Changes.$at(i).Kind == tok.TokenKind.l_brace
       || Changes.$at(i).Kind == tok.TokenKind.l_paren
       || Changes.$at(i).Kind == tok.TokenKind.l_square) {
      // We want sequences to skip over child scopes if possible, but not the
      // other way around.
      NestingLevelOfLastMatch = std.min_uint(NestingLevelOfLastMatch, NestingLevel);
      ++NestingLevel;
    }
    if (Native.$not(Matches.$call(Changes.$at(i)))) {
      continue;
    }
    
    // If there is more than one matching token per line, or if the number of
    // preceding commas, or the scope depth, do not match anymore, end the
    // sequence.
    if (FoundMatchOnLine || CommasBeforeMatch != CommasBeforeLastMatch
       || NestingLevel != NestingLevelOfLastMatch) {
      AlignCurrentSequence.$call();
    }
    
    CommasBeforeLastMatch = CommasBeforeMatch;
    NestingLevelOfLastMatch = NestingLevel;
    FoundMatchOnLine = true;
    if (StartOfSequence.$deref() == 0) {
      StartOfSequence.$set(i);
    }
    
    /*uint*/int ChangeMinColumn = Changes.$at(i).StartOfTokenColumn;
    int LineLengthAfter = -Changes.$at(i).Spaces;
    for (/*uint*/int j = i; j != e && Changes.$at(j).NewlinesBefore == 0; ++j)  {
      LineLengthAfter += Changes.$at(j).Spaces + Changes.$at(j).TokenLength;
    }
    /*uint*/int ChangeMaxColumn = Style.ColumnLimit - LineLengthAfter;
    
    // If we are restricted by the maximum column width, end the sequence.
    if ($greater_uint(ChangeMinColumn, MaxColumn.$deref()) || $less_uint(ChangeMaxColumn, MinColumn)
       || CommasBeforeLastMatch != CommasBeforeMatch) {
      AlignCurrentSequence.$call();
      StartOfSequence.$set(i);
    }
    
    MinColumn.$set(std.max(MinColumn.$deref(), ChangeMinColumn));
    MaxColumn.$set(std.min_uint(MaxColumn.$deref(), ChangeMaxColumn));
  }
  
  EndOfSequence.$set(Changes.size());
  AlignCurrentSequence.$call();
}

} // END OF class WhitespaceManagerFormatStatics
