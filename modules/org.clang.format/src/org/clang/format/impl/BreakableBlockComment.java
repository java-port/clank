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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.format.*;
import static org.clang.format.impl.EncodingStatics.*;
import static org.clang.format.impl.BreakableTokenFormatStatics.*;

//<editor-fold defaultstate="collapsed" desc="clang::format::BreakableBlockComment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.h", line = 157,
 FQN="clang::format::BreakableBlockComment", NM="_ZN5clang6format21BreakableBlockCommentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format21BreakableBlockCommentE")
//</editor-fold>
public class BreakableBlockComment extends /*public*/ BreakableToken implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Creates a breakable token for a block comment.
  ///
  /// \p StartColumn specifies the column in which the comment will start
  /// after formatting, while \p OriginalStartColumn specifies in which
  /// column the comment started before formatting.
  /// If the comment starts a line after formatting, set \p FirstInLine to true.
  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableBlockComment::BreakableBlockComment">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 252,
   FQN="clang::format::BreakableBlockComment::BreakableBlockComment", NM="_ZN5clang6format21BreakableBlockCommentC1ERKNS0_11FormatTokenEjjjbbNS0_8encoding8EncodingERKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format21BreakableBlockCommentC1ERKNS0_11FormatTokenEjjjbbNS0_8encoding8EncodingERKNS0_11FormatStyleE")
  //</editor-fold>
  public BreakableBlockComment(final /*const*/ FormatToken /*&*/ Token, /*uint*/int IndentLevel, /*uint*/int StartColumn, 
      /*uint*/int OriginalStartColumn, boolean FirstInLine, boolean InPPDirective, 
      /*enum_conversion.properties: ADD FQN MAPPING FOR ENUM[encoding::Encoding] using FQN clang::format::encoding::Encoding*/Encoding $Encoding, final /*const*/ FormatStyle /*&*/ Style) {
    // : BreakableToken(Token, IndentLevel, InPPDirective, Encoding, Style), Lines(), LeadingWhitespace(), StartOfLineColumn(), Decoration() 
    //START JInit
    super(Token, IndentLevel, InPPDirective, $Encoding, Style);
    this.Lines = new SmallVector<StringRef>(16, new StringRef());
    this.LeadingWhitespace = new SmallVectorUInt(16, 0);
    this.StartOfLineColumn = new SmallVectorInt/*16*/(16);
    this.Decoration = new StringRef();
    //END JInit
    StringRef TokenText/*J*/= new StringRef(Token.TokenText);
    assert (TokenText.startswith(/*STRINGREF_STR*/"/*") && TokenText.endswith(/*STRINGREF_STR*/"*/"));
    TokenText.substr(2, TokenText.size() - 4).split(Lines, /*STRINGREF_STR*/"\n");
    
    int IndentDelta = StartColumn - OriginalStartColumn;
    LeadingWhitespace.resize(Lines.size());
    StartOfLineColumn.resize(Lines.size());
    StartOfLineColumn.$set(0, StartColumn + 2);
    for (/*size_t*/int i = 1; $less_uint(i, Lines.size()); ++i)  {
      adjustWhitespace(i, IndentDelta);
    }
    
    Decoration.$assignMove(/*STRINGREF_STR*/"* ");
    if (Lines.size() == 1 && !FirstInLine) {
      // Comments for which FirstInLine is false can start on arbitrary column,
      // and available horizontal space can be too small to align consecutive
      // lines with the first one.
      // FIXME: We could, probably, align them to current indentation level, but
      // now we just wrap them without stars.
      Decoration.$assignMove(/*STRINGREF_STR*/$EMPTY);
    }
    for (/*size_t*/int i = 1, e = Lines.size(); $less_uint(i, e) && !Decoration.empty(); ++i) {
      // If the last line is empty, the closing "*/" will have a star.
      if (i + 1 == e && Lines.$at(i).empty()) {
        break;
      }
      if (!Lines.$at(i).empty() && i + 1 != e && Decoration.startswith(/*NO_COPY*/Lines.$at(i))) {
        continue;
      }
      while (!Lines.$at(i).startswith(/*NO_COPY*/Decoration)) {
        Decoration.$assignMove(Decoration.substr(0, Decoration.size() - 1));
      }
    }
    
    LastLineNeedsDecoration = true;
    IndentAtLineBreak = StartOfLineColumn.$at(0) + 1;
    for (/*size_t*/int i = 1; $less_uint(i, Lines.size()); ++i) {
      if (Lines.$at(i).empty()) {
        if (i + 1 == Lines.size()) {
          // Empty last line means that we already have a star as a part of the
          // trailing */. We also need to preserve whitespace, so that */ is
          // correctly indented.
          LastLineNeedsDecoration = false;
        } else if (Decoration.empty()) {
          // For all other lines, set the start column to 0 if they're empty, so
          // we do not insert trailing whitespace anywhere.
          StartOfLineColumn.$set(i, 0);
        }
        continue;
      }
      
      // The first line already excludes the star.
      // For all other lines, adjust the line to exclude the star and
      // (optionally) the first whitespace.
      /*uint*/int DecorationSize = Decoration.startswith(/*NO_COPY*/Lines.$at(i)) ? Lines.$at(i).size() : Decoration.size();
      StartOfLineColumn.$set(i, StartOfLineColumn.$at(i) + DecorationSize);
      Lines.$at(i).$assignMove(Lines.$at(i).substr(DecorationSize));
      LeadingWhitespace.$set(i, LeadingWhitespace.$at(i) + DecorationSize);
      if (!Decoration.startswith(/*NO_COPY*/Lines.$at(i))) {
        IndentAtLineBreak
           = std.min(IndentAtLineBreak, std.max(0, StartOfLineColumn.$at(i)));
      }
    }
    IndentAtLineBreak = std.max(IndentAtLineBreak, Decoration.size());
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"format-token-breaker")) {
        {
          llvm.dbgs().$out(/*KEEP_STR*/"IndentAtLineBreak ").$out_uint(IndentAtLineBreak).$out(/*KEEP_STR*/$LF);
          for (/*size_t*/int i = 0; $less_uint(i, Lines.size()); ++i) {
            llvm.dbgs().$out_uint(i).$out(/*KEEP_STR*/" |").$out(/*NO_COPY*/Lines.$at(i)).$out(/*KEEP_STR*/"| ").$out_uint(LeadingWhitespace.$at(i)).$out(/*KEEP_STR*/$LF);
          }
        }
        ;
      }
    } while (false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableBlockComment::getLineCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 364,
   FQN="clang::format::BreakableBlockComment::getLineCount", NM="_ZNK5clang6format21BreakableBlockComment12getLineCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZNK5clang6format21BreakableBlockComment12getLineCountEv")
  //</editor-fold>
  @Override public /*uint*/int getLineCount() /*const*//* override*/ {
    return Lines.size();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableBlockComment::getLineLengthAfterSplit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 366,
   FQN="clang::format::BreakableBlockComment::getLineLengthAfterSplit", NM="_ZNK5clang6format21BreakableBlockComment23getLineLengthAfterSplitEjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZNK5clang6format21BreakableBlockComment23getLineLengthAfterSplitEjjj")
  //</editor-fold>
  @Override public /*uint*/int getLineLengthAfterSplit(/*uint*/int LineIndex, /*uint*/int Offset, /*size_t*/int Length) /*const*//* override*/ {
    /*uint*/int ContentStartColumn = getContentStartColumn(LineIndex, Offset);
    return ContentStartColumn
       + EncodingStatics.columnWidthWithTabs(Lines.$at$Const(LineIndex).substr(Offset, Length), 
        ContentStartColumn, Style.TabWidth, 
        Encoding)
      // The last line gets a "*/" postfix.
       + (LineIndex + 1 == Lines.size() ? 2 : 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableBlockComment::getSplit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 377,
   FQN="clang::format::BreakableBlockComment::getSplit", NM="_ZNK5clang6format21BreakableBlockComment8getSplitEjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZNK5clang6format21BreakableBlockComment8getSplitEjjj")
  //</editor-fold>
  @Override public std.pairUIntUInt getSplit(/*uint*/int LineIndex, /*uint*/int TailOffset, 
          /*uint*/int ColumnLimit) /*const*//* override*/ {
    return getCommentSplit(Lines.$at$Const(LineIndex).substr(TailOffset), 
        getContentStartColumn(LineIndex, TailOffset), 
        ColumnLimit, Style.TabWidth, Encoding);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableBlockComment::insertBreak">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 385,
   FQN="clang::format::BreakableBlockComment::insertBreak", NM="_ZN5clang6format21BreakableBlockComment11insertBreakEjjSt4pairIjjERNS0_17WhitespaceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format21BreakableBlockComment11insertBreakEjjSt4pairIjjERNS0_17WhitespaceManagerE")
  //</editor-fold>
  @Override public void insertBreak(/*uint*/int LineIndex, /*uint*/int TailOffset, 
             std.pairUIntUInt Split, 
             final WhitespaceManager /*&*/ Whitespaces)/* override*/ {
    StringRef Text = Lines.$at(LineIndex).substr(TailOffset);
    StringRef Prefix = new StringRef(Decoration);
    if (LineIndex + 1 == Lines.size()
       && Text.size() == Split.first + Split.second) {
      // For the last line we need to break before "*/", but not to add "* ".
      Prefix.$assignMove(/*STRINGREF_STR*/$EMPTY);
    }
    
    /*uint*/int BreakOffsetInToken = Text.data().$sub(Tok.TokenText.data()) + Split.first;
    /*uint*/int CharsToRemove = Split.second;
    assert ($greatereq_uint(IndentAtLineBreak, Decoration.size()));
    Whitespaces.replaceWhitespaceInToken(Tok, BreakOffsetInToken, CharsToRemove, new StringRef(/*KEEP_STR*/$EMPTY), new StringRef(Prefix), InPPDirective, 1, 
        IndentLevel, IndentAtLineBreak - Decoration.size());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableBlockComment::replaceWhitespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 405,
   FQN="clang::format::BreakableBlockComment::replaceWhitespace", NM="_ZN5clang6format21BreakableBlockComment17replaceWhitespaceEjjSt4pairIjjERNS0_17WhitespaceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format21BreakableBlockComment17replaceWhitespaceEjjSt4pairIjjERNS0_17WhitespaceManagerE")
  //</editor-fold>
  @Override public void replaceWhitespace(/*uint*/int LineIndex, 
                   /*uint*/int TailOffset, std.pairUIntUInt Split, 
                   final WhitespaceManager /*&*/ Whitespaces)/* override*/ {
    StringRef Text = Lines.$at(LineIndex).substr(TailOffset);
    /*uint*/int BreakOffsetInToken = Text.data().$sub(Tok.TokenText.data()) + Split.first;
    /*uint*/int CharsToRemove = Split.second;
    Whitespaces.replaceWhitespaceInToken(Tok, BreakOffsetInToken, CharsToRemove, new StringRef(/*KEEP_STR*/$EMPTY), new StringRef(/*KEEP_STR*/$EMPTY), /*InPPDirective=*/ false, 
        /*Newlines=*/ 0, /*IndentLevel=*/ 0, /*Spaces=*/ 1);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableBlockComment::replaceWhitespaceBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 417,
   FQN="clang::format::BreakableBlockComment::replaceWhitespaceBefore", NM="_ZN5clang6format21BreakableBlockComment23replaceWhitespaceBeforeEjRNS0_17WhitespaceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format21BreakableBlockComment23replaceWhitespaceBeforeEjRNS0_17WhitespaceManagerE")
  //</editor-fold>
  @Override public void replaceWhitespaceBefore(/*uint*/int LineIndex, final WhitespaceManager /*&*/ Whitespaces)/* override*/ {
    if (LineIndex == 0) {
      return;
    }
    StringRef Prefix = new StringRef(Decoration);
    if (Lines.$at(LineIndex).empty()) {
      if (LineIndex + 1 == Lines.size()) {
        if (!LastLineNeedsDecoration) {
          // If the last line was empty, we don't need a prefix, as the */ will
          // line up with the decoration (if it exists).
          Prefix.$assignMove(/*STRINGREF_STR*/$EMPTY);
        }
      } else if (!Decoration.empty()) {
        // For other empty lines, if we do have a decoration, adapt it to not
        // contain a trailing whitespace.
        Prefix.$assignMove(Prefix.substr(0, 1));
      }
    } else {
      if (StartOfLineColumn.$at(LineIndex) == 1) {
        // This line starts immediately after the decorating *.
        Prefix.$assignMove(Prefix.substr(0, 1));
      }
    }
    
    /*uint*/int WhitespaceOffsetInToken = Lines.$at(LineIndex).data().$sub(Tok.TokenText.data())
       - LeadingWhitespace.$at(LineIndex);
    Whitespaces.replaceWhitespaceInToken(Tok, WhitespaceOffsetInToken, LeadingWhitespace.$at(LineIndex), new StringRef(/*KEEP_STR*/$EMPTY), new StringRef(Prefix), 
        InPPDirective, 1, IndentLevel, 
        StartOfLineColumn.$at(LineIndex) - Prefix.size());
  }

/*private:*/
  // Rearranges the whitespace between Lines[LineIndex-1] and Lines[LineIndex],
  // so that all whitespace between the lines is accounted to Lines[LineIndex]
  // as leading whitespace:
  // - Lines[LineIndex] points to the text after that whitespace
  // - Lines[LineIndex-1] shrinks by its trailing whitespace
  // - LeadingWhitespace[LineIndex] is updated with the complete whitespace
  //   between the end of the text of Lines[LineIndex-1] and Lines[LineIndex]
  //
  // Sets StartOfLineColumn to the intended column in which the text at
  // Lines[LineIndex] starts (note that the decoration, if present, is not
  // considered part of the text).
  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableBlockComment::adjustWhitespace">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 326,
   FQN="clang::format::BreakableBlockComment::adjustWhitespace", NM="_ZN5clang6format21BreakableBlockComment16adjustWhitespaceEji",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format21BreakableBlockComment16adjustWhitespaceEji")
  //</editor-fold>
  private void adjustWhitespace(/*uint*/int LineIndex, 
                  int IndentDelta) {
    // When in a preprocessor directive, the trailing backslash in a block comment
    // is not needed, but can serve a purpose of uniformity with necessary escaped
    // newlines outside the comment. In this case we remove it here before
    // trimming the trailing whitespace. The backslash will be re-added later when
    // inserting a line break.
    /*size_t*/int EndOfPreviousLine = Lines.$at(LineIndex - 1).size();
    if (InPPDirective && Lines.$at(LineIndex - 1).endswith(/*STRINGREF_STR*/"\\")) {
      --EndOfPreviousLine;
    }
    
    // Calculate the end of the non-whitespace text in the previous line.
    EndOfPreviousLine
       = Lines.$at(LineIndex - 1).find_last_not_of(/*STRINGREF_STR*/FormatStatics.Blanks, EndOfPreviousLine);
    if (EndOfPreviousLine == StringRef.npos) {
      EndOfPreviousLine = 0;
    } else {
      ++EndOfPreviousLine;
    }
    // Calculate the start of the non-whitespace text in the current line.
    /*size_t*/int StartOfLine = Lines.$at(LineIndex).find_first_not_of(/*STRINGREF_STR*/FormatStatics.Blanks);
    if (StartOfLine == StringRef.npos) {
      StartOfLine = Lines.$at(LineIndex).rtrim(/*STRINGREF_STR*/"\015\n").size();
    }
    
    StringRef Whitespace = Lines.$at(LineIndex).substr(0, StartOfLine);
    // Adjust Lines to only contain relevant text.
    Lines.$at(LineIndex - 1).$assignMove(Lines.$at(LineIndex - 1).substr(0, EndOfPreviousLine));
    Lines.$at(LineIndex).$assignMove(Lines.$at(LineIndex).substr(StartOfLine));
    // Adjust LeadingWhitespace to account all whitespace between the lines
    // to the current line.
    LeadingWhitespace.$set(LineIndex, 
      Lines.$at(LineIndex).begin().$sub(Lines.$at(LineIndex - 1).end()));
    
    // Adjust the start column uniformly across all lines.
    StartOfLineColumn.$set(LineIndex, 
      EncodingStatics.columnWidthWithTabs(new StringRef(Whitespace), 0, Style.TabWidth, Encoding)
       + IndentDelta);
  }

  
  // Returns the column at which the text in line LineIndex starts, when broken
  // at TailOffset. Note that the decoration (if present) is not considered part
  // of the text.
  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableBlockComment::getContentStartColumn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 450,
   FQN="clang::format::BreakableBlockComment::getContentStartColumn", NM="_ZNK5clang6format21BreakableBlockComment21getContentStartColumnEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZNK5clang6format21BreakableBlockComment21getContentStartColumnEjj")
  //</editor-fold>
  private /*uint*/int getContentStartColumn(/*uint*/int LineIndex, 
                       /*uint*/int TailOffset) /*const*/ {
    // If we break, we always break at the predefined indent.
    if (TailOffset != 0) {
      return IndentAtLineBreak;
    }
    return std.max(0, StartOfLineColumn.$at$Const(LineIndex));
  }

  
  // Contains the text of the lines of the block comment, excluding the leading
  // /* in the first line and trailing */ in the last line, and excluding all
  // trailing whitespace between the lines. Note that the decoration (if
  // present) is also not considered part of the text.
  private SmallVector<StringRef> Lines;
  
  // LeadingWhitespace[i] is the number of characters regarded as whitespace in
  // front of Lines[i]. Note that this can include "* " sequences, which we
  // regard as whitespace when all lines have a "*" prefix.
  private SmallVectorUInt LeadingWhitespace;
  
  // StartOfLineColumn[i] is the target column at which Line[i] should be.
  // Note that this excludes a leading "* " or "*" in case all lines have
  // a "*" prefix.
  // The first line's target column is always positive. The remaining lines'
  // target columns are relative to the first line to allow correct indentation
  // of comments in \c WhitespaceManager. Thus they can be negative as well (in
  // case the first line needs to be unindented more than there's actual
  // whitespace in another line).
  private SmallVectorInt/*16*/ StartOfLineColumn;
  
  // The column at which the text of a broken line should start.
  // Note that an optional decoration would go before that column.
  // IndentAtLineBreak is a uniform position for all lines in a block comment,
  // regardless of their relative position.
  // FIXME: Revisit the decision to do this; the main reason was to support
  // patterns like
  // /**************//**
  //  * Comment
  // We could also support such patterns by special casing the first line
  // instead.
  private /*uint*/int IndentAtLineBreak;
  
  // This is to distinguish between the case when the last line was empty and
  // the case when it started with a decoration ("*" or "* ").
  private boolean LastLineNeedsDecoration;
  
  // Either "* " if all lines begin with a "*", or empty.
  private StringRef Decoration;
  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableBlockComment::~BreakableBlockComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.h", line = 157,
   FQN="clang::format::BreakableBlockComment::~BreakableBlockComment", NM="_ZN5clang6format21BreakableBlockCommentD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format21BreakableBlockCommentD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    StartOfLineColumn.$destroy();
    LeadingWhitespace.$destroy();
    Lines.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Lines=" + Lines // NOI18N
              + ", LeadingWhitespace=" + LeadingWhitespace // NOI18N
              + ", StartOfLineColumn=" + StartOfLineColumn // NOI18N
              + ", IndentAtLineBreak=" + IndentAtLineBreak // NOI18N
              + ", LastLineNeedsDecoration=" + LastLineNeedsDecoration // NOI18N
              + ", Decoration=" + Decoration // NOI18N
              + super.toString(); // NOI18N
  }
}
