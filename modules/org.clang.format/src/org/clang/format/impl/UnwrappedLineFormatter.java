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

import java.util.Comparator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.format.*;
import static org.clang.format.impl.FormatStatics.*;

//<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineFormatter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.h", line = 31,
 FQN="clang::format::UnwrappedLineFormatter", NM="_ZN5clang6format22UnwrappedLineFormatterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format22UnwrappedLineFormatterE")
//</editor-fold>
public class UnwrappedLineFormatter implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineFormatter::UnwrappedLineFormatter">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.h", line = 33,
   FQN="clang::format::UnwrappedLineFormatter::UnwrappedLineFormatter", NM="_ZN5clang6format22UnwrappedLineFormatterC1EPNS0_20ContinuationIndenterEPNS0_17WhitespaceManagerERKNS0_11FormatStyleERKNS0_18AdditionalKeywordsEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format22UnwrappedLineFormatterC1EPNS0_20ContinuationIndenterEPNS0_17WhitespaceManagerERKNS0_11FormatStyleERKNS0_18AdditionalKeywordsEPb")
  //</editor-fold>
  public UnwrappedLineFormatter(ContinuationIndenter /*P*/ Indenter, 
      WhitespaceManager /*P*/ Whitespaces, 
      final /*const*/ FormatStyle /*&*/ Style, 
      final /*const*/ AdditionalKeywords /*&*/ Keywords, 
      bool$ptr/*bool P*/ IncompleteFormat) {
    // : PenaltyCache(), Indenter(Indenter), Whitespaces(Whitespaces), Style(Style), Keywords(Keywords), IncompleteFormat(IncompleteFormat) 
    //START JInit
    this.PenaltyCache = new std.mapTypeUInt<std.pairTypeUInt</*const*/ SmallVectorImpl<AnnotatedLine /*P*/ > /*P*/ >>(
            new Comparator<std.pairTypeUInt</*const*/ SmallVectorImpl<AnnotatedLine /*P*/ > /*P*/ >>(){
      @Override
      public int compare(std_pair.pairTypeUInt<SmallVectorImpl<AnnotatedLine>> o1, std_pair.pairTypeUInt<SmallVectorImpl<AnnotatedLine>> o2) {
        int res = System.identityHashCode(o1.first) - System.identityHashCode(o2.first);
        if (res == 0) {
          return o1.second - o2.second;
        }
        return res;
      }
    },
            0);
    this.Indenter = Indenter;
    this.Whitespaces = Whitespaces;
    this./*&*/Style=/*&*/Style;
    this./*&*/Keywords=/*&*/Keywords;
    this.IncompleteFormat = $tryClone(IncompleteFormat);
    //END JInit
  }

  
  /// \brief Format the current block and return the penalty.
  
  /// \brief Format the current block and return the penalty.
  // anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineFormatter::format">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 796,
   FQN="clang::format::UnwrappedLineFormatter::format", NM="_ZN5clang6format22UnwrappedLineFormatter6formatERKN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEEbib",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format22UnwrappedLineFormatter6formatERKN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEEbib")
  //</editor-fold>
  public /*uint*/int format(final /*const*/ SmallVectorImpl<AnnotatedLine /*P*/ > /*&*/ Lines) {
    return format(Lines, 
        false, 0, 
        false);
  }
  public /*uint*/int format(final /*const*/ SmallVectorImpl<AnnotatedLine /*P*/ > /*&*/ Lines, 
        boolean DryRun/*= false*/) {
    return format(Lines, 
        DryRun, 0, 
        false);
  }
  public /*uint*/int format(final /*const*/ SmallVectorImpl<AnnotatedLine /*P*/ > /*&*/ Lines, 
        boolean DryRun/*= false*/, int AdditionalIndent/*= 0*/) {
    return format(Lines, 
        DryRun, AdditionalIndent, 
        false);
  }
  public /*uint*/int format(final /*const*/ SmallVectorImpl<AnnotatedLine /*P*/ > /*&*/ Lines, 
        boolean DryRun/*= false*/, int AdditionalIndent/*= 0*/, 
        boolean FixBadIndentation/*= false*/) {
    LevelIndentTracker IndentTracker = null;
    try {
      LineJoiner Joiner/*J*/= new LineJoiner(Style, Keywords, Lines);
      
      // Try to look up already computed penalty in DryRun-mode.
      std.pairTypeUInt</*const*/ SmallVectorImpl<AnnotatedLine /*P*/ > /*P*/ > CacheKey/*J*/= new std.pairPtrUInt</*const*/ SmallVectorImpl<AnnotatedLine /*P*/ > /*P*/ >(JD$T$RR_T1$RR.INSTANCE, /*AddrOf*/Lines, AdditionalIndent);
      std.mapTypeUInt.iterator</*const*/std.pairTypeUInt</*const*/ SmallVectorImpl<AnnotatedLine /*P*/ > /*P*/ >> CacheIt = PenaltyCache.find(CacheKey);
      if (DryRun && CacheIt.$noteq(PenaltyCache.end())) {
        return CacheIt.$arrow().second;
      }
      assert (!Lines.empty());
      /*uint*/int Penalty = 0;
      IndentTracker/*J*/= new LevelIndentTracker(Style, Keywords, Lines.$at$Const(0).Level, 
          AdditionalIndent);
      /*const*/ AnnotatedLine /*P*/ PreviousLine = null;
      /*const*/ AnnotatedLine /*P*/ NextLine = null;
      
      // The minimum level of consecutive lines that have been formatted.
      /*uint*/int RangeMinLevel = UINT_MAX;
      
      for (/*const*/ AnnotatedLine /*P*/ Line = Joiner.getNextMergedLine(DryRun, IndentTracker);
           (Line != null); Line = NextLine) {
        final /*const*/ AnnotatedLine /*&*/ TheLine = /*Deref*/Line;
        /*uint*/int Indent = IndentTracker.getIndent();
        
        // We continue formatting unchanged lines to adjust their indent, e.g. if a
        // scope was added. However, we need to carefully stop doing this when we
        // exit the scope of affected lines to prevent indenting a the entire
        // remaining file if it currently missing a closing brace.
        boolean ContinueFormatting = $greater_uint(TheLine.Level, RangeMinLevel)
           || (TheLine.Level == RangeMinLevel && !TheLine.startsWith(tok.TokenKind.r_brace));
        
        boolean FixIndentation = (FixBadIndentation || ContinueFormatting)
           && Indent != TheLine.First.OriginalColumn;
        boolean ShouldFormat = TheLine.Affected || FixIndentation;
        // We cannot format this line; if the reason is that the line had a
        // parsing error, remember that.
        if (ShouldFormat && TheLine.Type == LineType.LT_Invalid && Native.$bool(IncompleteFormat)) {
          IncompleteFormat.$set(true);
        }
        if (ShouldFormat && TheLine.Type != LineType.LT_Invalid) {
          if (!DryRun) {
            formatFirstToken(/*Deref*/TheLine.First, PreviousLine, TheLine.Level, Indent, 
                TheLine.InPPDirective);
          }
          
          NextLine = Joiner.getNextMergedLine(DryRun, IndentTracker);
          /*uint*/int ColumnLimit = getColumnLimit(TheLine.InPPDirective, NextLine);
          boolean FitsIntoOneLine = $lesseq_uint(TheLine.Last.TotalLength + Indent, ColumnLimit)
             || (TheLine.Type == LineType.LT_ImportStatement
             && (Style.Language != FormatStyle.LanguageKind.LK_JavaScript
             || !Style.JavaScriptWrapImports));
          if (Style.ColumnLimit == 0) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track(new NoColumnLimitLineFormatter(Indenter, Whitespaces, Style, this)).
                  formatLine(TheLine, Indent, DryRun));
            } finally {
              $c$.$destroy();
            }
          } else if (FitsIntoOneLine) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean(Penalty += $c$.track(new NoLineBreakFormatter(Indenter, Whitespaces, Style, this)).
                  formatLine(TheLine, Indent, DryRun));
            } finally {
              $c$.$destroy();
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean(Penalty += $c$.track(new OptimizingLineFormatter(Indenter, Whitespaces, Style, this)).
                  formatLine(TheLine, Indent, DryRun));
            } finally {
              $c$.$destroy();
            }
          }
          RangeMinLevel = std.min_uint(RangeMinLevel, TheLine.Level);
        } else {
          // If no token in the current line is affected, we still need to format
          // affected children.
          if (TheLine.ChildrenAffected) {
            for (/*const*/ FormatToken /*P*/ Tok = TheLine.First; (Tok != null); Tok = Tok.Next)  {
              if (!Tok.Children.empty()) {
                format(Tok.Children, DryRun);
              }
            }
          }
          
          // Adapt following lines on the current indent level to the same level
          // unless the current \c AnnotatedLine is not at the beginning of a line.
          boolean StartsNewLine = $greater_uint(TheLine.First.NewlinesBefore, 0) || TheLine.First.IsFirst;
          if (StartsNewLine) {
            IndentTracker.adjustToUnmodifiedLine(TheLine);
          }
          if (!DryRun) {
            boolean ReformatLeadingWhitespace = StartsNewLine && (((PreviousLine != null) && PreviousLine.Affected)
               || TheLine.LeadingEmptyLinesAffected);
            // Format the first token.
            if (ReformatLeadingWhitespace) {
              formatFirstToken(/*Deref*/TheLine.First, PreviousLine, TheLine.Level, 
                  TheLine.First.OriginalColumn, 
                  TheLine.InPPDirective);
            } else {
              Whitespaces.addUntouchableToken(/*Deref*/TheLine.First, 
                  TheLine.InPPDirective);
            }
            
            // Notify the WhitespaceManager about the unchanged whitespace.
            for (FormatToken /*P*/ Tok = TheLine.First.Next; (Tok != null); Tok = Tok.Next)  {
              Whitespaces.addUntouchableToken(/*Deref*/Tok, TheLine.InPPDirective);
            }
          }
          NextLine = Joiner.getNextMergedLine(DryRun, IndentTracker);
          RangeMinLevel = UINT_MAX;
        }
        if (!DryRun) {
          markFinalized(TheLine.First);
        }
        PreviousLine = /*AddrOf*/TheLine;
      }
      PenaltyCache.$set(CacheKey, Penalty);
      return Penalty;
    } finally {
      if (IndentTracker != null) { IndentTracker.$destroy(); }
    }
  }


/*private:*/
  /// \brief Add a new line and the required indent before the first Token
  /// of the \c UnwrappedLine if there was no structural parsing error.
  /// \brief Add a new line and the required indent before the first Token
  /// of the \c UnwrappedLine if there was no structural parsing error.
  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineFormatter::formatFirstToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 906,
   FQN="clang::format::UnwrappedLineFormatter::formatFirstToken", NM="_ZN5clang6format22UnwrappedLineFormatter16formatFirstTokenERNS0_11FormatTokenEPKNS0_13AnnotatedLineEjjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format22UnwrappedLineFormatter16formatFirstTokenERNS0_11FormatTokenEPKNS0_13AnnotatedLineEjjb")
  //</editor-fold>
  private void formatFirstToken(final FormatToken /*&*/ RootToken, 
                  /*const*/ AnnotatedLine /*P*/ PreviousLine, 
                  /*uint*/int IndentLevel, 
                  /*uint*/int Indent, 
                  boolean InPPDirective) {
    if (RootToken.is_TokenKind(tok.TokenKind.eof)) {
      /*uint*/int Newlines = std.min_uint(RootToken.NewlinesBefore, 1/*U*/);
      Whitespaces.replaceWhitespace(RootToken, Newlines, /*IndentLevel=*/ 0, 
          /*Spaces=*/ 0, /*TargetColumn=*/ 0);
      return;
    }
    /*uint*/int Newlines = std.min_uint(RootToken.NewlinesBefore, Style.MaxEmptyLinesToKeep + 1);
    // Remove empty lines before "}" where applicable.
    if (RootToken.is_TokenKind(tok.TokenKind.r_brace)
       && (!(RootToken.Next != null)
       || (RootToken.Next.is_TokenKind(tok.TokenKind.semi) && !(RootToken.Next.Next != null)))) {
      Newlines = std.min_uint(Newlines, 1/*U*/);
    }
    if (Newlines == 0 && !RootToken.IsFirst) {
      Newlines = 1;
    }
    if (RootToken.IsFirst && !RootToken.HasUnescapedNewline) {
      Newlines = 0;
    }
    
    // Remove empty lines after "{".
    if (!Style.KeepEmptyLinesAtTheStartOfBlocks && (PreviousLine != null)
       && PreviousLine.Last.is_TokenKind(tok.TokenKind.l_brace)
       && PreviousLine.First.isNot(tok.TokenKind.kw_namespace)
       && !startsExternCBlock(/*Deref*/PreviousLine)) {
      Newlines = 1;
    }
    
    // Insert extra new line before access specifiers.
    if ((PreviousLine != null) && PreviousLine.Last.isOneOf(tok.TokenKind.semi, tok.TokenKind.r_brace)
       && RootToken.isAccessSpecifier() && RootToken.NewlinesBefore == 1) {
      ++Newlines;
    }
    
    // Remove empty lines after access specifiers.
    if ((PreviousLine != null) && PreviousLine.First.isAccessSpecifier()
       && (!PreviousLine.InPPDirective || !RootToken.HasUnescapedNewline)) {
      Newlines = std.min_uint(1/*U*/, Newlines);
    }
    
    Whitespaces.replaceWhitespace(RootToken, Newlines, IndentLevel, Indent, 
        Indent, InPPDirective
           && !RootToken.HasUnescapedNewline);
  }


  
  /// \brief Returns the column limit for a line, taking into account whether we
  /// need an escaped newline due to a continued preprocessor directive.
  
  /// \brief Returns the column limit for a line, taking into account whether we
  /// need an escaped newline due to a continued preprocessor directive.
  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineFormatter::getColumnLimit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 951,
   FQN="clang::format::UnwrappedLineFormatter::getColumnLimit", NM="_ZNK5clang6format22UnwrappedLineFormatter14getColumnLimitEbPKNS0_13AnnotatedLineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZNK5clang6format22UnwrappedLineFormatter14getColumnLimitEbPKNS0_13AnnotatedLineE")
  //</editor-fold>
  private /*uint*/int getColumnLimit(boolean InPPDirective, 
                /*const*/ AnnotatedLine /*P*/ NextLine) /*const*/ {
    // In preprocessor directives reserve two chars for trailing " \" if the
    // next line continues the preprocessor directive.
    boolean ContinuesPPDirective = InPPDirective
      // If there is no next line, this is likely a child line and the parent
      // continues the preprocessor directive.
       && (!(NextLine != null)
       || (NextLine.InPPDirective
      // If there is an unescaped newline between this line and the next, the
      // next line starts a new preprocessor directive.
       && !NextLine.First.HasUnescapedNewline));
    return Style.ColumnLimit - (ContinuesPPDirective ? 2 : 0);
  }


  
  // Cache to store the penalty of formatting a vector of AnnotatedLines
  // starting from a specific additional offset. Improves performance if there
  // are many nested blocks.
  private std.mapTypeUInt<std.pairTypeUInt</*const*/ SmallVectorImpl<AnnotatedLine /*P*/ > /*P*/ >> PenaltyCache;
  
  private ContinuationIndenter /*P*/ Indenter;
  private WhitespaceManager /*P*/ Whitespaces;
  private final /*const*/ FormatStyle /*&*/ Style;
  private final /*const*/ AdditionalKeywords /*&*/ Keywords;
  private bool$ptr/*bool P*/ IncompleteFormat;
  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineFormatter::~UnwrappedLineFormatter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.h", line = 31,
   FQN="clang::format::UnwrappedLineFormatter::~UnwrappedLineFormatter", NM="_ZN5clang6format22UnwrappedLineFormatterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format22UnwrappedLineFormatterD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    PenaltyCache.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "PenaltyCache=" + PenaltyCache // NOI18N
              + ", Indenter=" + Indenter // NOI18N
              + ", Whitespaces=" + "[WhitespaceManager]" // NOI18N
              + ", Style=" + Style // NOI18N
              + ", Keywords=" + Keywords // NOI18N
              + ", IncompleteFormat=" + IncompleteFormat; // NOI18N
  }
}
