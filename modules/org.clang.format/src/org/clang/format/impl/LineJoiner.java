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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.io.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.format.*;
import static org.clang.format.impl.FormatStatics.*;

//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LineJoiner">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 129,
 FQN="clang::format::(anonymous namespace)::LineJoiner", NM="_ZN5clang6format12_GLOBAL__N_110LineJoinerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_110LineJoinerE")
//</editor-fold>
public class LineJoiner {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LineJoiner::LineJoiner">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 131,
   FQN="clang::format::(anonymous namespace)::LineJoiner::LineJoiner", NM="_ZN5clang6format12_GLOBAL__N_110LineJoinerC1ERKNS0_11FormatStyleERKNS0_18AdditionalKeywordsERKN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_110LineJoinerC1ERKNS0_11FormatStyleERKNS0_18AdditionalKeywordsERKN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEE")
  //</editor-fold>
  public LineJoiner(final /*const*/ FormatStyle /*&*/ Style, final /*const*/ AdditionalKeywords /*&*/ Keywords, 
      final /*const*/ SmallVectorImpl<AnnotatedLine /*P*/ > /*&*/ Lines) {
    // : Style(Style), Keywords(Keywords), End(Lines.end()), Next(Lines.begin()) 
    //START JInit
    this./*&*/Style=/*&*/Style;
    this./*&*/Keywords=/*&*/Keywords;
    this.End = $tryClone(Lines.end$Const());
    this.Next = $tryClone(Lines.begin$Const());
    //END JInit
  }

  
  /// \brief Returns the next line, merging multiple lines into one if possible.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LineJoiner::getNextMergedLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 137,
   FQN="clang::format::(anonymous namespace)::LineJoiner::getNextMergedLine", NM="_ZN5clang6format12_GLOBAL__N_110LineJoiner17getNextMergedLineEbRNS1_18LevelIndentTrackerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_110LineJoiner17getNextMergedLineEbRNS1_18LevelIndentTrackerE")
  //</editor-fold>
  public /*const*/ AnnotatedLine /*P*/ getNextMergedLine(boolean DryRun, 
                   final LevelIndentTracker /*&*/ IndentTracker) {
    if ($eq_ptr(Next, End)) {
      return null;
    }
    /*const*/ AnnotatedLine /*P*/ Current = Next.$star();
    IndentTracker.nextLine(/*Deref*/Current);
    /*uint*/int MergedLines = tryFitMultipleLinesInOne(IndentTracker.getIndent(), Next, End);
    if ($greater_uint(MergedLines, 0) && Style.ColumnLimit == 0) {
      // Disallow line merging if there is a break at the start of one of the
      // input lines.
      for (/*uint*/int i = 0; $less_uint(i, MergedLines); ++i)  {
        if ($greater_uint(Next.$at(i + 1).First.NewlinesBefore, 0)) {
          MergedLines = 0;
        }
      }
    }
    if (!DryRun) {
      for (/*uint*/int i = 0; $less_uint(i, MergedLines); ++i)  {
        join(/*Deref*/Next.$at(i), /*Deref*/Next.$at(i + 1));
      }
    }
    Next = $tryClone(Next.$add(MergedLines).$add(1));
    return Current;
  }

/*private:*/
  /// \brief Calculates how many lines can be merged into 1 starting at \p I.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LineJoiner::tryFitMultipleLinesInOne">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 160,
   FQN="clang::format::(anonymous namespace)::LineJoiner::tryFitMultipleLinesInOne", NM="_ZN5clang6format12_GLOBAL__N_110LineJoiner24tryFitMultipleLinesInOneEjPKPNS0_13AnnotatedLineES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_110LineJoiner24tryFitMultipleLinesInOneEjPKPNS0_13AnnotatedLineES6_")
  //</editor-fold>
  private /*uint*/int tryFitMultipleLinesInOne(/*uint*/int Indent, 
                          type$ptr<AnnotatedLine /*P*/ /*P*/> I, 
                          type$ptr<AnnotatedLine /*P*/ /*P*/> E) {
    // Can't join the last line with anything.
    if ($eq_ptr(I.$add(1), E)) {
      return 0;
    }
    // We can never merge stuff if there are trailing line comments.
    /*const*/ AnnotatedLine /*P*/ TheLine = I.$star();
    if (TheLine.Last.is_TokenType(TokenType.TT_LineComment)) {
      return 0;
    }
    if (I.$at(1).Type == LineType.LT_Invalid || I.$at(1).First.MustBreakBefore) {
      return 0;
    }
    if (TheLine.InPPDirective
       && (!I.$at(1).InPPDirective || I.$at(1).First.HasUnescapedNewline)) {
      return 0;
    }
    if ($greater_uint(Style.ColumnLimit, 0) && $greater_uint(Indent, Style.ColumnLimit)) {
      return 0;
    }
    
    /*uint*/int Limit = Style.ColumnLimit == 0 ? UINT_MAX : Style.ColumnLimit - Indent;
    // If we already exceed the column limit, we set 'Limit' to 0. The different
    // tryMerge..() functions can then decide whether to still do merging.
    Limit = $greater_uint(TheLine.Last.TotalLength, Limit) ? 0 : Limit - TheLine.Last.TotalLength;
    
    // FIXME: TheLine->Level != 0 might or might not be the right check to do.
    // If necessary, change to something smarter.
    boolean MergeShortFunctions = Style.AllowShortFunctionsOnASingleLine == FormatStyle.ShortFunctionStyle.SFS_All
       || (Style.AllowShortFunctionsOnASingleLine.getValue() >= FormatStyle.ShortFunctionStyle.SFS_Empty.getValue()
       && I.$at(1).First.is_TokenKind(tok.TokenKind.r_brace))
       || (Style.AllowShortFunctionsOnASingleLine == FormatStyle.ShortFunctionStyle.SFS_Inline
       && TheLine.Level != 0);
    if (TheLine.Last.is_TokenType(TokenType.TT_FunctionLBrace)
       && TheLine.First != TheLine.Last) {
      return MergeShortFunctions ? tryMergeSimpleBlock(I, E, Limit) : 0;
    }
    if (TheLine.Last.is_TokenKind(tok.TokenKind.l_brace)) {
      return !Style.BraceWrapping.AfterFunction ? tryMergeSimpleBlock(I, E, Limit) : 0;
    }
    if (I.$at(1).First.is_TokenType(TokenType.TT_FunctionLBrace)
       && Style.BraceWrapping.AfterFunction) {
      if (I.$at(1).Last.is_TokenType(TokenType.TT_LineComment)) {
        return 0;
      }
      
      // Check for Limit <= 2 to account for the " {".
      if ($lesseq_uint(Limit, 2) || (Style.ColumnLimit == 0 && containsMustBreak(TheLine))) {
        return 0;
      }
      Limit -= 2;
      
      /*uint*/int MergedLines = 0;
      if (MergeShortFunctions) {
        MergedLines = tryMergeSimpleBlock(I.$add(1), E, Limit);
        // If we managed to merge the block, count the function header, which is
        // on a separate line.
        if ($greater_uint(MergedLines, 0)) {
          ++MergedLines;
        }
      }
      return MergedLines;
    }
    if (TheLine.First.is_TokenKind(tok.TokenKind.kw_if)) {
      return Style.AllowShortIfStatementsOnASingleLine ? tryMergeSimpleControlStatement(I, E, Limit) : 0;
    }
    if (TheLine.First.isOneOf(tok.TokenKind.kw_for, tok.TokenKind.kw_while)) {
      return Style.AllowShortLoopsOnASingleLine ? tryMergeSimpleControlStatement(I, E, Limit) : 0;
    }
    if (TheLine.First.isOneOf(tok.TokenKind.kw_case, tok.TokenKind.kw_default)) {
      return Style.AllowShortCaseLabelsOnASingleLine ? tryMergeShortCaseLabels(I, E, Limit) : 0;
    }
    if (TheLine.InPPDirective
       && (TheLine.First.HasUnescapedNewline || TheLine.First.IsFirst)) {
      return tryMergeSimplePPDirective(I, E, Limit);
    }
    return 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LineJoiner::tryMergeSimplePPDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 248,
   FQN="clang::format::(anonymous namespace)::LineJoiner::tryMergeSimplePPDirective", NM="_ZN5clang6format12_GLOBAL__N_110LineJoiner25tryMergeSimplePPDirectiveEPKPNS0_13AnnotatedLineES6_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_110LineJoiner25tryMergeSimplePPDirectiveEPKPNS0_13AnnotatedLineES6_j")
  //</editor-fold>
  private /*uint*/int tryMergeSimplePPDirective(type$ptr<AnnotatedLine /*P*/ /*P*/> I, 
                           type$ptr<AnnotatedLine /*P*/ /*P*/> E, 
                           /*uint*/int Limit) {
    if (Limit == 0) {
      return 0;
    }
    if ($noteq_ptr(I.$add(2), E) && I.$at(2).InPPDirective && !I.$at(2).First.HasUnescapedNewline) {
      return 0;
    }
    if ($greater_uint(1 + I.$at(1).Last.TotalLength, Limit)) {
      return 0;
    }
    return 1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LineJoiner::tryMergeSimpleControlStatement">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 261,
   FQN="clang::format::(anonymous namespace)::LineJoiner::tryMergeSimpleControlStatement", NM="_ZN5clang6format12_GLOBAL__N_110LineJoiner30tryMergeSimpleControlStatementEPKPNS0_13AnnotatedLineES6_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_110LineJoiner30tryMergeSimpleControlStatementEPKPNS0_13AnnotatedLineES6_j")
  //</editor-fold>
  private /*uint*/int tryMergeSimpleControlStatement(type$ptr<AnnotatedLine /*P*/ /*P*/> I, 
                                type$ptr<AnnotatedLine /*P*/ /*P*/> E, /*uint*/int Limit) {
    if (Limit == 0) {
      return 0;
    }
    if (Style.BraceWrapping.AfterControlStatement
       && (I.$at(1).First.is_TokenKind(tok.TokenKind.l_brace) && !Style.AllowShortBlocksOnASingleLine)) {
      return 0;
    }
    if (I.$at(1).InPPDirective != (I.$star()).InPPDirective
       || (I.$at(1).InPPDirective && I.$at(1).First.HasUnescapedNewline)) {
      return 0;
    }
    Limit = limitConsideringMacros(I.$add(1), E, Limit);
    final AnnotatedLine /*&*/ Line = /*Deref*/I.$star();
    if (Line.Last.isNot(tok.TokenKind.r_paren)) {
      return 0;
    }
    if ($greater_uint(1 + I.$at(1).Last.TotalLength, Limit)) {
      return 0;
    }
    if (I.$at(1).First.isOneOf(tok.TokenKind.semi, tok.TokenKind.kw_if, tok.TokenKind.kw_for, tok.TokenKind.kw_while) || I.$at(1).First.isOneOf( 
        TokenType.TT_LineComment)) {
      return 0;
    }
    // Only inline simple if's (no nested if or else).
    if ($noteq_ptr(I.$add(2), E) && Line.startsWith(tok.TokenKind.kw_if)
       && I.$at(2).First.is_TokenKind(tok.TokenKind.kw_else)) {
      return 0;
    }
    return 1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LineJoiner::tryMergeShortCaseLabels">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 288,
   FQN="clang::format::(anonymous namespace)::LineJoiner::tryMergeShortCaseLabels", NM="_ZN5clang6format12_GLOBAL__N_110LineJoiner23tryMergeShortCaseLabelsEPKPNS0_13AnnotatedLineES6_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_110LineJoiner23tryMergeShortCaseLabelsEPKPNS0_13AnnotatedLineES6_j")
  //</editor-fold>
  private /*uint*/int tryMergeShortCaseLabels(type$ptr<AnnotatedLine /*P*/ /*P*/> I, 
                         type$ptr<AnnotatedLine /*P*/ /*P*/> E, 
                         /*uint*/int Limit) {
    if (Limit == 0 || $eq_ptr(I.$add(1), E)
       || I.$at(1).First.isOneOf(tok.TokenKind.kw_case, tok.TokenKind.kw_default)) {
      return 0;
    }
    /*uint*/int NumStmts = 0;
    /*uint*/int Length = 0;
    boolean InPPDirective = I.$at(0).InPPDirective;
    for (; $less_uint(NumStmts, 3); ++NumStmts) {
      if ($eq_ptr(I.$add(1).$add(NumStmts), E)) {
        break;
      }
      /*const*/ AnnotatedLine /*P*/ Line = I.$at(1 + NumStmts);
      if (Line.InPPDirective != InPPDirective) {
        break;
      }
      if (Line.First.isOneOf(tok.TokenKind.kw_case, tok.TokenKind.kw_default, tok.TokenKind.r_brace)) {
        break;
      }
      if (Line.First.isOneOf(tok.TokenKind.kw_if, tok.TokenKind.kw_for, tok.TokenKind.kw_switch, 
          tok.TokenKind.kw_while, tok.TokenKind.comment)
         || Line.Last.is_TokenKind(tok.TokenKind.comment)) {
        return 0;
      }
      Length += I.$at(1 + NumStmts).Last.TotalLength + 1; // 1 for the space.
    }
    if (NumStmts == 0 || NumStmts == 3 || $greater_uint(Length, Limit)) {
      return 0;
    }
    return NumStmts;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LineJoiner::tryMergeSimpleBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 317,
   FQN="clang::format::(anonymous namespace)::LineJoiner::tryMergeSimpleBlock", NM="_ZN5clang6format12_GLOBAL__N_110LineJoiner19tryMergeSimpleBlockEPKPNS0_13AnnotatedLineES6_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_110LineJoiner19tryMergeSimpleBlockEPKPNS0_13AnnotatedLineES6_j")
  //</editor-fold>
  private /*uint*/int tryMergeSimpleBlock(type$ptr<AnnotatedLine /*P*/ /*P*/> I, 
                     type$ptr<AnnotatedLine /*P*/ /*P*/> E, 
                     /*uint*/int Limit) {
    final AnnotatedLine /*&*/ Line = /*Deref*/I.$star();
    
    // Don't merge ObjC @ keywords and methods.
    // FIXME: If an option to allow short exception handling clauses on a single
    // line is added, change this to not return for @try and friends.
    if (Style.Language != FormatStyle.LanguageKind.LK_Java
       && Line.First.isOneOf(tok.TokenKind.at, tok.TokenKind.minus, tok.TokenKind.plus)) {
      return 0;
    }
    
    // Check that the current line allows merging. This depends on whether we
    // are in a control flow statements as well as several style flags.
    if (Line.First.isOneOf(tok.TokenKind.kw_else, tok.TokenKind.kw_case)
       || ((Line.First.Next != null) && Line.First.Next.is_TokenKind(tok.TokenKind.kw_else))) {
      return 0;
    }
    if (Line.First.isOneOf(tok.TokenKind.kw_if, tok.TokenKind.kw_while, tok.TokenKind.kw_do, tok.TokenKind.kw_try, 
        tok.TokenKind.kw___try, tok.TokenKind.kw_catch, tok.TokenKind.kw___finally, 
        tok.TokenKind.kw_for, tok.TokenKind.r_brace) || Line.First.is(Keywords.kw___except)) {
      if (!Style.AllowShortBlocksOnASingleLine) {
        return 0;
      }
      if (!Style.AllowShortIfStatementsOnASingleLine
         && Line.startsWith(tok.TokenKind.kw_if)) {
        return 0;
      }
      if (!Style.AllowShortLoopsOnASingleLine
         && Line.First.isOneOf(tok.TokenKind.kw_while, tok.TokenKind.kw_do, tok.TokenKind.kw_for)) {
        return 0;
      }
      // FIXME: Consider an option to allow short exception handling clauses on
      // a single line.
      // FIXME: This isn't covered by tests.
      // FIXME: For catch, __except, __finally the first token on the line
      // is '}', so this isn't correct here.
      if (Line.First.isOneOf(tok.TokenKind.kw_try, tok.TokenKind.kw___try, tok.TokenKind.kw_catch) ||
          Line.First.isOneOf(Keywords.kw___except, tok.TokenKind.kw___finally)) {
        return 0;
      }
    }
    
    FormatToken /*P*/ Tok = I.$at(1).First;
    if (Tok.is_TokenKind(tok.TokenKind.r_brace) && !Tok.MustBreakBefore
       && (Tok.getNextNonComment() == null
       || Tok.getNextNonComment().is_TokenKind(tok.TokenKind.semi))) {
      // We merge empty blocks even if the line exceeds the column limit.
      Tok.SpacesRequiredBefore = 0;
      Tok.CanBreakBefore = true;
      return 1;
    } else if (Limit != 0 && !Line.startsWith(tok.TokenKind.kw_namespace)
       && !startsExternCBlock(Line)) {
      // We don't merge short records.
      if (Line.First.isOneOf(tok.TokenKind.kw_class, tok.TokenKind.kw_union, tok.TokenKind.kw_struct) ||
          Line.First.is(Keywords.kw_interface)) {
        return 0;
      }
      
      // Check that we still have three lines and they fit into the limit.
      if ($eq_ptr(I.$add(2), E) || I.$at(2).Type == LineType.LT_Invalid) {
        return 0;
      }
      Limit = limitConsideringMacros(I.$add(2), E, Limit);
      if (!nextTwoLinesFitInto(I, Limit)) {
        return 0;
      }
      
      // Second, check that the next line does not contain any braces - if it
      // does, readability declines when putting it into a single line.
      if (I.$at(1).Last.is_TokenType(TokenType.TT_LineComment)) {
        return 0;
      }
      do {
        if (Tok.is_TokenKind(tok.TokenKind.l_brace) && Tok.BlockKind != BraceBlockKind.BK_BracedInit) {
          return 0;
        }
        Tok = Tok.Next;
      } while ((Tok != null));
      
      // Last, check that the third line starts with a closing brace.
      Tok = I.$at(2).First;
      if (Tok.isNot(tok.TokenKind.r_brace)) {
        return 0;
      }
      
      // Don't merge "if (a) { .. } else {".
      if ((Tok.Next != null) && Tok.Next.is_TokenKind(tok.TokenKind.kw_else)) {
        return 0;
      }
      
      return 2;
    }
    return 0;
  }

  
  /// Returns the modified column limit for \p I if it is inside a macro and
  /// needs a trailing '\'.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LineJoiner::limitConsideringMacros">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 405,
   FQN="clang::format::(anonymous namespace)::LineJoiner::limitConsideringMacros", NM="_ZN5clang6format12_GLOBAL__N_110LineJoiner22limitConsideringMacrosEPKPNS0_13AnnotatedLineES6_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_110LineJoiner22limitConsideringMacrosEPKPNS0_13AnnotatedLineES6_j")
  //</editor-fold>
  private /*uint*/int limitConsideringMacros(type$ptr<AnnotatedLine /*P*/ /*P*/> I, 
                        type$ptr<AnnotatedLine /*P*/ /*P*/> E, 
                        /*uint*/int Limit) {
    if (I.$at(0).InPPDirective && $noteq_ptr(I.$add(1), E)
       && !I.$at(1).First.HasUnescapedNewline && !I.$at(1).First.is_TokenKind(tok.TokenKind.eof)) {
      return $less_uint(Limit, 2) ? 0 : Limit - 2;
    }
    return Limit;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LineJoiner::nextTwoLinesFitInto">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 416,
   FQN="clang::format::(anonymous namespace)::LineJoiner::nextTwoLinesFitInto", NM="_ZN5clang6format12_GLOBAL__N_110LineJoiner19nextTwoLinesFitIntoEPKPNS0_13AnnotatedLineEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_110LineJoiner19nextTwoLinesFitIntoEPKPNS0_13AnnotatedLineEj")
  //</editor-fold>
  private boolean nextTwoLinesFitInto(type$ptr<AnnotatedLine /*P*/ /*P*/> I, 
                     /*uint*/int Limit) {
    if (I.$at(1).First.MustBreakBefore || I.$at(2).First.MustBreakBefore) {
      return false;
    }
    return $lesseq_uint(1 + I.$at(1).Last.TotalLength + 1 + I.$at(2).Last.TotalLength, Limit);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LineJoiner::containsMustBreak">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 423,
   FQN="clang::format::(anonymous namespace)::LineJoiner::containsMustBreak", NM="_ZN5clang6format12_GLOBAL__N_110LineJoiner17containsMustBreakEPKNS0_13AnnotatedLineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_110LineJoiner17containsMustBreakEPKNS0_13AnnotatedLineE")
  //</editor-fold>
  private boolean containsMustBreak(/*const*/ AnnotatedLine /*P*/ Line) {
    for (/*const*/ FormatToken /*P*/ Tok = Line.First; (Tok != null); Tok = Tok.Next) {
      if (Tok.MustBreakBefore) {
        return true;
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LineJoiner::join">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 431,
   FQN="clang::format::(anonymous namespace)::LineJoiner::join", NM="_ZN5clang6format12_GLOBAL__N_110LineJoiner4joinERNS0_13AnnotatedLineERKS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_110LineJoiner4joinERNS0_13AnnotatedLineERKS3_")
  //</editor-fold>
  private void join(final AnnotatedLine /*&*/ A, final /*const*/ AnnotatedLine /*&*/ B) {
    assert (!(A.Last.Next != null));
    assert (!(B.First.Previous != null));
    if (B.Affected) {
      A.Affected = true;
    }
    A.Last.Next = B.First;
    B.First.Previous = A.Last;
    B.First.CanBreakBefore = true;
    /*uint*/int LengthA = A.Last.TotalLength + B.First.SpacesRequiredBefore;
    for (FormatToken /*P*/ Tok = B.First; (Tok != null); Tok = Tok.Next) {
      Tok.TotalLength += LengthA;
      A.Last = Tok;
    }
  }

  
  private final /*const*/ FormatStyle /*&*/ Style;
  private final /*const*/ AdditionalKeywords /*&*/ Keywords;
  private type$ptr<AnnotatedLine /*P*/ /*P*/> End;
  
  private type$ptr<AnnotatedLine /*P*/ /*P*/> Next;
  
  @Override public String toString() {
    return "" + "Style=" + Style // NOI18N
              + ", Keywords=" + Keywords // NOI18N
              + ", End=" + End // NOI18N
              + ", Next=" + Next; // NOI18N
  }
}
