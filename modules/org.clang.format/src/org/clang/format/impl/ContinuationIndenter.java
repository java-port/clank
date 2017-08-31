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
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.format.*;
import static org.clang.format.impl.EncodingStatics.*;
import static org.clang.format.impl.FormatStatics.*;

//<editor-fold defaultstate="collapsed" desc="clang::format::ContinuationIndenter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.h", line = 35,
 FQN="clang::format::ContinuationIndenter", NM="_ZN5clang6format20ContinuationIndenterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format20ContinuationIndenterE")
//</editor-fold>
public class ContinuationIndenter implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Constructs a \c ContinuationIndenter to format \p Line starting in
  /// column \p FirstIndent.
  //<editor-fold defaultstate="collapsed" desc="clang::format::ContinuationIndenter::ContinuationIndenter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 65,
   FQN="clang::format::ContinuationIndenter::ContinuationIndenter", NM="_ZN5clang6format20ContinuationIndenterC1ERKNS0_11FormatStyleERKNS0_18AdditionalKeywordsERKNS_13SourceManagerERNS0_17WhitespaceManagerENS0_8encoding8EncodingEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format20ContinuationIndenterC1ERKNS0_11FormatStyleERKNS0_18AdditionalKeywordsERKNS_13SourceManagerERNS0_17WhitespaceManagerENS0_8encoding8EncodingEb")
  //</editor-fold>
  public ContinuationIndenter(final /*const*/ FormatStyle /*&*/ Style, 
      final /*const*/ AdditionalKeywords /*&*/ Keywords, 
      final /*const*/ SourceManager /*&*/ SourceMgr, 
      final WhitespaceManager /*&*/ Whitespaces, 
      /*enum_conversion.properties: ADD FQN MAPPING FOR ENUM[encoding::Encoding] using FQN clang::format::encoding::Encoding*/Encoding $Encoding, 
      boolean BinPackInconclusiveFunctions) {
    // : Style(Style), Keywords(Keywords), SourceMgr(SourceMgr), Whitespaces(Whitespaces), Encoding(Encoding), BinPackInconclusiveFunctions(BinPackInconclusiveFunctions), CommentPragmasRegex(Style.CommentPragmas) 
    //START JInit
    this.Style = new FormatStyle(Style);
    this./*&*/Keywords=/*&*/Keywords;
    this./*&*/SourceMgr=/*&*/SourceMgr;
    this./*&*/Whitespaces=/*&*/Whitespaces;
    this.Encoding = $Encoding;
    this.BinPackInconclusiveFunctions = BinPackInconclusiveFunctions;
    this.CommentPragmasRegex = new Regex(new StringRef(Style.CommentPragmas));
    //END JInit
  }

  
  /// \brief Get the initial state, i.e. the state after placing \p Line's
  /// first token at \p FirstIndent.
  //<editor-fold defaultstate="collapsed" desc="clang::format::ContinuationIndenter::getInitialState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 76,
   FQN="clang::format::ContinuationIndenter::getInitialState", NM="_ZN5clang6format20ContinuationIndenter15getInitialStateEjPKNS0_13AnnotatedLineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format20ContinuationIndenter15getInitialStateEjPKNS0_13AnnotatedLineEb")
  //</editor-fold>
  public LineState getInitialState(/*uint*/int FirstIndent, 
                 /*const*/ AnnotatedLine /*P*/ Line, 
                 boolean DryRun) {
    LineState State = null;
    try {
      State/*J*/= new LineState();
      State.FirstIndent = FirstIndent;
      State.Column = FirstIndent;
      State.Line = Line;
      State.NextToken = Line.First;
      State.Stack.push_back_T$RR(new ParenState(FirstIndent, Line.Level, FirstIndent, 
              /*AvoidBinPacking=*/ false, 
              /*NoLineBreak=*/ false));
      State.LineContainsContinuedForLoopSection = false;
      State.StartOfStringLiteral = 0;
      State.StartOfLineLevel = 0;
      State.LowestLevelOnLine = 0;
      State.IgnoreStackForComparison = false;
      
      // The first token has already been indented and thus consumed.
      moveStateToNextToken(State, DryRun, /*Newline=*/ false);
      return new LineState(JD$Move.INSTANCE, State);
    } finally {
      if (State != null) { State.$destroy(); }
    }
  }

  
  // FIXME: canBreak and mustBreak aren't strictly indentation-related. Find a
  // better home.
  /// \brief Returns \c true, if a line break after \p State is allowed.
  //<editor-fold defaultstate="collapsed" desc="clang::format::ContinuationIndenter::canBreak">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 98,
   FQN="clang::format::ContinuationIndenter::canBreak", NM="_ZN5clang6format20ContinuationIndenter8canBreakERKNS0_9LineStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format20ContinuationIndenter8canBreakERKNS0_9LineStateE")
  //</editor-fold>
  public boolean canBreak(final /*const*/ LineState /*&*/ State) {
    final /*const*/ FormatToken /*&*/ Current = /*Deref*/State.NextToken;
    final /*const*/ FormatToken /*&*/ Previous = /*Deref*/Current.Previous;
    assert (/*AddrOf*/Previous == Current.Previous);
    if (!Current.CanBreakBefore
       && !(State.Stack.back$Const().BreakBeforeClosingBrace
       && Current.closesBlockOrBlockTypeList(Style))) {
      return false;
    }
    // The opening "{" of a braced list has to be on the same line as the first
    // element if it is nested in another braced init list or function call.
    if (!Current.MustBreakBefore && Previous.is_TokenKind(tok.TokenKind.l_brace)
       && Previous.isNot(TokenType.TT_DictLiteral) && Previous.BlockKind == BraceBlockKind.BK_BracedInit
       && (Previous.Previous != null)
       && Previous.Previous.isOneOf(tok.TokenKind.l_brace, tok.TokenKind.l_paren, tok.TokenKind.comma)) {
      return false;
    }
    // This prevents breaks like:
    //   ...
    //   SomeParameter, OtherParameter).DoSomething(
    //   ...
    // As they hide "DoSomething" and are generally bad for readability.
    if (Previous.opensScope() && Previous.isNot(tok.TokenKind.l_brace)
       && $less_uint(State.LowestLevelOnLine, State.StartOfLineLevel)
       && $less_uint(State.LowestLevelOnLine, Current.NestingLevel)) {
      return false;
    }
    if (Current.isMemberAccess() && State.Stack.back$Const().ContainsUnwrappedBuilder) {
      return false;
    }
    
    // Don't create a 'hanging' indent if there are multiple blocks in a single
    // statement.
    if (Previous.is_TokenKind(tok.TokenKind.l_brace) && $greater_uint(State.Stack.size(), 1)
       && State.Stack.$at$Const(State.Stack.size() - 2).NestedBlockInlined
       && State.Stack.$at$Const(State.Stack.size() - 2).HasMultipleNestedBlocks) {
      return false;
    }
    
    // Don't break after very short return types (e.g. "void") as that is often
    // unexpected.
    if (Current.is_TokenType(TokenType.TT_FunctionDeclarationName) && $less_uint(State.Column, 6)) {
      if (Style.AlwaysBreakAfterReturnType == FormatStyle.ReturnTypeBreakingStyle.RTBS_None) {
        return false;
      }
    }
    
    return !State.Stack.back$Const().NoLineBreak;
  }

  
  /// \brief Returns \c true, if a line break after \p State is mandatory.
  //<editor-fold defaultstate="collapsed" desc="clang::format::ContinuationIndenter::mustBreak">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 142,
   FQN="clang::format::ContinuationIndenter::mustBreak", NM="_ZN5clang6format20ContinuationIndenter9mustBreakERKNS0_9LineStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format20ContinuationIndenter9mustBreakERKNS0_9LineStateE")
  //</editor-fold>
  public boolean mustBreak(final /*const*/ LineState /*&*/ State) {
    final /*const*/ FormatToken /*&*/ Current = /*Deref*/State.NextToken;
    final /*const*/ FormatToken /*&*/ Previous = /*Deref*/Current.Previous;
    if (Current.MustBreakBefore || Current.is_TokenType(TokenType.TT_InlineASMColon)) {
      return true;
    }
    if (State.Stack.back$Const().BreakBeforeClosingBrace
       && Current.closesBlockOrBlockTypeList(Style)) {
      return true;
    }
    if (Previous.is_TokenKind(tok.TokenKind.semi) && State.LineContainsContinuedForLoopSection) {
      return true;
    }
    if ((startsNextParameter(Current, Style) || Previous.is_TokenKind(tok.TokenKind.semi)
       || (Previous.is_TokenType(TokenType.TT_TemplateCloser) && Current.is_TokenType(TokenType.TT_StartOfName)
       && Style.Language == FormatStyle.LanguageKind.LK_Cpp
      // FIXME: This is a temporary workaround for the case where clang-format
      // sets BreakBeforeParameter to avoid bin packing and this creates a
      // completely unnecessary line break after a template type that isn't
      // line-wrapped.
       && (Previous.NestingLevel == 1 || Style.BinPackParameters))
       || (Style.BreakBeforeTernaryOperators && Current.is_TokenType(TokenType.TT_ConditionalExpr)
       && Previous.isNot(tok.TokenKind.question))
       || (!Style.BreakBeforeTernaryOperators
       && Previous.is_TokenType(TokenType.TT_ConditionalExpr)))
       && State.Stack.back$Const().BreakBeforeParameter && !Current.isTrailingComment()
       && !Current.isOneOf(tok.TokenKind.r_paren, tok.TokenKind.r_brace)) {
      return true;
    }
    if (((Previous.is_TokenType(TokenType.TT_DictLiteral) && Previous.is_TokenKind(tok.TokenKind.l_brace))
       || (Previous.is_TokenType(TokenType.TT_ArrayInitializerLSquare)
       && $greater_uint(Previous.ParameterCount, 1)))
       && $greater_uint(Style.ColumnLimit, 0)
       && $greater_uint(getLengthToMatchingParen(Previous) + State.Column - 1
      , getColumnLimit(State))) {
      return true;
    }
    if (Current.is_TokenType(TokenType.TT_CtorInitializerColon)
       && ($greater_uint(State.Column + State.Line.Last.TotalLength - Current.TotalLength + 2
      , getColumnLimit(State))
       || State.Stack.back$Const().BreakBeforeParameter)
       && ((Style.AllowShortFunctionsOnASingleLine != FormatStyle.ShortFunctionStyle.SFS_All)
       || Style.BreakConstructorInitializersBeforeComma || Style.ColumnLimit != 0)) {
      return true;
    }
    if (Current.is_TokenType(TokenType.TT_SelectorName) && State.Stack.back$Const().ObjCSelectorNameFound
       && State.Stack.back$Const().BreakBeforeParameter) {
      return true;
    }
    
    /*uint*/int NewLineColumn = getNewLineColumn(State);
    if (Current.isMemberAccess() && Style.ColumnLimit != 0
       && $greater_uint(State.Column + getLengthToNextOperator(Current), Style.ColumnLimit)
       && ($greater_uint(State.Column, NewLineColumn)
       || $less_uint(Current.NestingLevel, State.StartOfLineLevel))) {
      return true;
    }
    if ($lesseq_uint(State.Column, NewLineColumn)) {
      return false;
    }
    if (Style.AlwaysBreakBeforeMultilineStrings
       && (NewLineColumn == State.FirstIndent + Style.ContinuationIndentWidth
       || Previous.is_TokenKind(tok.TokenKind.comma) || $less_uint(Current.NestingLevel, 2))
       && !Previous.isOneOf(tok.TokenKind.kw_return, tok.TokenKind.lessless, tok.TokenKind.at)
       && !Previous.isOneOf(TokenType.TT_InlineASMColon, TokenType.TT_ConditionalExpr)
       && nextIsMultilineString(State)) {
      return true;
    }
    
    // Using CanBreakBefore here and below takes care of the decision whether the
    // current style uses wrapping before or after operators for the given
    // operator.
    if (Previous.is_TokenType(TokenType.TT_BinaryOperator) && Current.CanBreakBefore) {
      // If we need to break somewhere inside the LHS of a binary expression, we
      // should also break after the operator. Otherwise, the formatting would
      // hide the operator precedence, e.g. in:
      //   if (aaaaaaaaaaaaaa ==
      //           bbbbbbbbbbbbbb && c) {..
      // For comparisons, we only apply this rule, if the LHS is a binary
      // expression itself as otherwise, the line breaks seem superfluous.
      // We need special cases for ">>" which we have split into two ">" while
      // lexing in order to make template parsing easier.
      boolean IsComparison = (Previous.getPrecedence() == prec.Level.Relational
         || Previous.getPrecedence() == prec.Level.Equality)
         && (Previous.Previous != null)
         && Previous.Previous.isNot(TokenType.TT_BinaryOperator); // For >>.
      boolean LHSIsBinaryExpr = (Previous.Previous != null) && Previous.Previous.EndsBinaryExpression;
      if ((!IsComparison || LHSIsBinaryExpr) && !Current.isTrailingComment()
         && Previous.getPrecedence() != prec.Level.Assignment
         && State.Stack.back$Const().BreakBeforeParameter) {
        return true;
      }
    } else if (Current.is_TokenType(TokenType.TT_BinaryOperator) && Current.CanBreakBefore
       && State.Stack.back$Const().BreakBeforeParameter) {
      return true;
    }
    
    // Same as above, but for the first "<<" operator.
    if (Current.is_TokenKind(tok.TokenKind.lessless) && Current.isNot(TokenType.TT_OverloadedOperator)
       && State.Stack.back$Const().BreakBeforeParameter
       && State.Stack.back$Const().FirstLessLess == 0) {
      return true;
    }
    if (Current.NestingLevel == 0 && !Current.isTrailingComment()) {
      // Always break after "template <...>" and leading annotations. This is only
      // for cases where the entire line does not fit on a single line as a
      // different LineFormatter would be used otherwise.
      if (Previous.ClosesTemplateDeclaration) {
        return true;
      }
      if (Previous.is_TokenType(TokenType.TT_FunctionAnnotationRParen)) {
        return true;
      }
      if (Previous.is_TokenType(TokenType.TT_LeadingJavaAnnotation) && Current.isNot(tok.TokenKind.l_paren)
         && Current.isNot(TokenType.TT_LeadingJavaAnnotation)) {
        return true;
      }
    }
    
    // If the return type spans multiple lines, wrap before the function name.
    if ((Current.is_TokenType(TokenType.TT_FunctionDeclarationName)
       || (Current.is_TokenKind(tok.TokenKind.kw_operator) && !Previous.is_TokenKind(tok.TokenKind.coloncolon)))
       && !Previous.is_TokenKind(tok.TokenKind.kw_template) && State.Stack.back$Const().BreakBeforeParameter) {
      return true;
    }
    if (startsSegmentOfBuilderTypeCall(Current)
       && (State.Stack.back$Const().CallContinuation != 0
       || State.Stack.back$Const().BreakBeforeParameter)) {
      return true;
    }
    
    // The following could be precomputed as they do not depend on the state.
    // However, as they should take effect only if the UnwrappedLine does not fit
    // into the ColumnLimit, they are checked here in the ContinuationIndenter.
    if (Style.ColumnLimit != 0 && Previous.BlockKind == BraceBlockKind.BK_Block
       && Previous.is_TokenKind(tok.TokenKind.l_brace) && !Current.isOneOf(tok.TokenKind.r_brace, tok.TokenKind.comment)) {
      return true;
    }
    if (Current.is_TokenKind(tok.TokenKind.lessless)
       && ((Previous.is_TokenKind(tok.TokenKind.identifier) && $eq_StringRef(/*NO_COPY*/Previous.TokenText, /*STRINGREF_STR*/"endl"))
       || (Previous.Tok.isLiteral() && (Previous.TokenText.endswith(/*STRINGREF_STR*/"\\n\"")
       || $eq_StringRef(/*NO_COPY*/Previous.TokenText, /*STRINGREF_STR*/"'\\n'"))))) {
      return true;
    }
    
    return false;
  }

  
  /// \brief Appends the next token to \p State and updates information
  /// necessary for indentation.
  ///
  /// Puts the token on the current line if \p Newline is \c false and adds a
  /// line break and necessary indentation otherwise.
  ///
  /// If \p DryRun is \c false, also creates and stores the required
  /// \c Replacement.
  //<editor-fold defaultstate="collapsed" desc="clang::format::ContinuationIndenter::addTokenToState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 277,
   FQN="clang::format::ContinuationIndenter::addTokenToState", NM="_ZN5clang6format20ContinuationIndenter15addTokenToStateERNS0_9LineStateEbbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format20ContinuationIndenter15addTokenToStateERNS0_9LineStateEbbj")
  //</editor-fold>
  public /*uint*/int addTokenToState(final LineState /*&*/ State, boolean Newline, 
                 boolean DryRun) {
    return addTokenToState(State, Newline, 
                 DryRun, 
                 0);
  }
  public /*uint*/int addTokenToState(final LineState /*&*/ State, boolean Newline, 
                 boolean DryRun, 
                 /*uint*/int ExtraSpaces/*= 0*/) {
    final /*const*/ FormatToken /*&*/ Current = /*Deref*/State.NextToken;
    assert (!State.Stack.empty());
    if ((Current.is_TokenType(TokenType.TT_ImplicitStringLiteral)
       && (Current.Previous.Tok.getIdentifierInfo() == null
       || Current.Previous.Tok.getIdentifierInfo().getPPKeywordID()
       == tok.PPKeywordKind.pp_not_keyword))) {
      /*uint*/int EndColumn = SourceMgr.getSpellingColumnNumber(Current.WhitespaceRange.getEnd());
      if (Current.LastNewlineOffset != 0) {
        // If there is a newline within this token, the final column will solely
        // determined by the current end column.
        State.Column = EndColumn;
      } else {
        /*uint*/int StartColumn = SourceMgr.getSpellingColumnNumber(Current.WhitespaceRange.getBegin());
        assert ($greatereq_uint(EndColumn, StartColumn));
        State.Column += EndColumn - StartColumn;
      }
      moveStateToNextToken(State, DryRun, /*Newline=*/ false);
      return 0;
    }
    
    /*uint*/int Penalty = 0;
    if (Newline) {
      Penalty = addTokenOnNewLine(State, DryRun);
    } else {
      addTokenOnCurrentLine(State, DryRun, ExtraSpaces);
    }
    
    return moveStateToNextToken(State, DryRun, Newline) + Penalty;
  }

  
  /// \brief Get the column limit for this line. This is the style's column
  /// limit, potentially reduced for preprocessor definitions.
  //<editor-fold defaultstate="collapsed" desc="clang::format::ContinuationIndenter::getColumnLimit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 1230,
   FQN="clang::format::ContinuationIndenter::getColumnLimit", NM="_ZNK5clang6format20ContinuationIndenter14getColumnLimitERKNS0_9LineStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZNK5clang6format20ContinuationIndenter14getColumnLimitERKNS0_9LineStateE")
  //</editor-fold>
  public /*uint*/int getColumnLimit(final /*const*/ LineState /*&*/ State) /*const*/ {
    // In preprocessor directives reserve two chars for trailing " \"
    return Style.ColumnLimit - (State.Line.InPPDirective ? 2 : 0);
  }

/*private:*/
  /// \brief Mark the next token as consumed in \p State and modify its stacks
  /// accordingly.
  //<editor-fold defaultstate="collapsed" desc="clang::format::ContinuationIndenter::moveStateToNextToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 708,
   FQN="clang::format::ContinuationIndenter::moveStateToNextToken", NM="_ZN5clang6format20ContinuationIndenter20moveStateToNextTokenERNS0_9LineStateEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format20ContinuationIndenter20moveStateToNextTokenERNS0_9LineStateEbb")
  //</editor-fold>
  private /*uint*/int moveStateToNextToken(final LineState /*&*/ State, 
                      boolean DryRun, boolean Newline) {
    assert Native.$bool(State.Stack.size());
    final /*const*/ FormatToken /*&*/ Current = /*Deref*/State.NextToken;
    if (Current.is_TokenType(TokenType.TT_InheritanceColon)) {
      State.Stack.back().AvoidBinPacking = true;
    }
    if (Current.is_TokenKind(tok.TokenKind.lessless) && Current.isNot(TokenType.TT_OverloadedOperator)) {
      if (State.Stack.back().FirstLessLess == 0) {
        State.Stack.back().FirstLessLess = State.Column;
      } else {
        State.Stack.back().LastOperatorWrapped = Newline;
      }
    }
    if ((Current.is_TokenType(TokenType.TT_BinaryOperator) && Current.isNot(tok.TokenKind.lessless))
       || Current.is_TokenType(TokenType.TT_ConditionalExpr)) {
      State.Stack.back().LastOperatorWrapped = Newline;
    }
    if (Current.is_TokenType(TokenType.TT_ArraySubscriptLSquare)
       && State.Stack.back().StartOfArraySubscripts == 0) {
      State.Stack.back().StartOfArraySubscripts = State.Column;
    }
    if (Style.BreakBeforeTernaryOperators && Current.is_TokenKind(tok.TokenKind.question)) {
      State.Stack.back().QuestionColumn = State.Column;
    }
    if (!Style.BreakBeforeTernaryOperators && Current.isNot(tok.TokenKind.colon)) {
      /*const*/ FormatToken /*P*/ Previous = Current.Previous;
      while ((Previous != null) && Previous.isTrailingComment()) {
        Previous = Previous.Previous;
      }
      if ((Previous != null) && Previous.is_TokenKind(tok.TokenKind.question)) {
        State.Stack.back().QuestionColumn = State.Column;
      }
    }
    if (!Current.opensScope() && !Current.closesScope()) {
      State.LowestLevelOnLine
         = std.min_uint(State.LowestLevelOnLine, Current.NestingLevel);
    }
    if (Current.isMemberAccess()) {
      State.Stack.back().StartOfFunctionCall
         = !(Current.NextOperator != null) ? 0 : State.Column;
    }
    if (Current.is_TokenType(TokenType.TT_SelectorName)) {
      State.Stack.back().ObjCSelectorNameFound = true;
      if (Style.IndentWrappedFunctionNames) {
        State.Stack.back().Indent
           = State.FirstIndent + Style.ContinuationIndentWidth;
      }
    }
    if (Current.is_TokenType(TokenType.TT_CtorInitializerColon)) {
      // Indent 2 from the column, so:
      // SomeClass::SomeClass()
      //     : First(...), ...
      //       Next(...)
      //       ^ line up here.
      State.Stack.back().Indent
         = State.Column + (Style.BreakConstructorInitializersBeforeComma ? 0 : 2);
      State.Stack.back().NestedBlockIndent = State.Stack.back().Indent;
      if (Style.ConstructorInitializerAllOnOneLineOrOnePerLine) {
        State.Stack.back().AvoidBinPacking = true;
      }
      State.Stack.back().BreakBeforeParameter = false;
    }
    if (Current.isOneOf(TokenType.TT_BinaryOperator, TokenType.TT_ConditionalExpr) && Newline) {
      State.Stack.back().NestedBlockIndent
         = State.Column + Current.ColumnWidth + 1;
    }
    
    // Insert scopes created by fake parenthesis.
    /*const*/ FormatToken /*P*/ Previous = Current.getPreviousNonComment();
    
    // Add special behavior to support a format commonly used for JavaScript
    // closures:
    //   SomeFunction(function() {
    //     foo();
    //     bar();
    //   }, a, b, c);
    if (Current.isNot(tok.TokenKind.comment) && (Previous != null)
       && Previous.isOneOf(tok.TokenKind.l_brace, TokenType.TT_ArrayInitializerLSquare)
       && !Previous.is_TokenType(TokenType.TT_DictLiteral) && $greater_uint(State.Stack.size(), 1)) {
      if (State.Stack.$at(State.Stack.size() - 2).NestedBlockInlined && Newline) {
        for (/*uint*/int i = 0, e = State.Stack.size() - 1; i != e; ++i)  {
          State.Stack.$at(i).NoLineBreak = true;
        }
      }
      State.Stack.$at(State.Stack.size() - 2).NestedBlockInlined = false;
    }
    if ((Previous != null) && (Previous.isOneOf(tok.TokenKind.l_paren, tok.TokenKind.comma, tok.TokenKind.colon)
       || Previous.isOneOf(TokenType.TT_BinaryOperator, TokenType.TT_ConditionalExpr))
       && !Previous.isOneOf(TokenType.TT_DictLiteral, TokenType.TT_ObjCMethodExpr)) {
      State.Stack.back().NestedBlockInlined
         = !Newline
         && (Previous.isNot(tok.TokenKind.l_paren) || $greater_uint(Previous.ParameterCount, 1));
    }
    
    moveStatePastFakeLParens(State, Newline);
    moveStatePastScopeOpener(State, Newline);
    moveStatePastScopeCloser(State);
    moveStatePastFakeRParens(State);
    if (Current.isStringLiteral() && State.StartOfStringLiteral == 0) {
      State.StartOfStringLiteral = State.Column;
    }
    if (Current.is_TokenType(TokenType.TT_ObjCStringLiteral) && State.StartOfStringLiteral == 0) {
      State.StartOfStringLiteral = State.Column + 1;
    } else if (!Current.isOneOf(tok.TokenKind.comment, tok.TokenKind.identifier, tok.TokenKind.hash)
       && !Current.isStringLiteral()) {
      State.StartOfStringLiteral = 0;
    }
    
    State.Column += Current.ColumnWidth;
    State.NextToken = State.NextToken.Next;
    /*uint*/int Penalty = breakProtrudingToken(Current, State, DryRun);
    if ($greater_uint(State.Column, getColumnLimit(State))) {
      /*uint*/int ExcessCharacters = State.Column - getColumnLimit(State);
      Penalty += Style.PenaltyExcessCharacter * ExcessCharacters;
    }
    if (Current.Role.$bool()) {
      Current.Role.$arrow().formatFromToken(State, this, DryRun);
    }
    // If the previous has a special role, let it consume tokens as appropriate.
    // It is necessary to start at the previous token for the only implemented
    // role (comma separated list). That way, the decision whether or not to break
    // after the "{" is already done and both options are tried and evaluated.
    // FIXME: This is ugly, find a better way.
    if ((Previous != null) && Previous.Role.$bool()) {
      Penalty += Previous.Role.$arrow().formatAfterToken(State, this, DryRun);
    }
    
    return Penalty;
  }

  
  /// \brief Update 'State' according to the next token's fake left parentheses.
  //<editor-fold defaultstate="collapsed" desc="clang::format::ContinuationIndenter::moveStatePastFakeLParens">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 825,
   FQN="clang::format::ContinuationIndenter::moveStatePastFakeLParens", NM="_ZN5clang6format20ContinuationIndenter24moveStatePastFakeLParensERNS0_9LineStateEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format20ContinuationIndenter24moveStatePastFakeLParensERNS0_9LineStateEb")
  //</editor-fold>
  private void moveStatePastFakeLParens(final LineState /*&*/ State, 
                          boolean Newline) {
    final /*const*/ FormatToken /*&*/ Current = /*Deref*/State.NextToken;
    /*const*/ FormatToken /*P*/ Previous = Current.getPreviousNonComment();
    
    // Don't add extra indentation for the first fake parenthesis after
    // 'return', assignments or opening <({[. The indentation for these cases
    // is special cased.
    boolean SkipFirstExtraIndent = ((Previous != null) && (Previous.opensScope()
       || Previous.isOneOf(tok.TokenKind.semi, tok.TokenKind.kw_return)
       || (Previous.getPrecedence() == prec.Level.Assignment
       && Style.AlignOperands)
       || Previous.is_TokenType(TokenType.TT_ObjCMethodExpr)));
    for (std.reverse_iterator</*const*/ prec.Level> I = Current.FakeLParens.rbegin$Const(), 
        E = Current.FakeLParens.rend$Const();
         $noteq_reverse_iterator$C(I, E); I.$preInc()) {
      ParenState NewParenState = new ParenState(State.Stack.back());
      NewParenState.ContainsLineBreak = false;
      
      // Indent from 'LastSpace' unless these are fake parentheses encapsulating
      // a builder type call after 'return' or, if the alignment after opening
      // brackets is disabled.
      if (!Current.isTrailingComment()
         && (Style.AlignOperands || I.$star().getValue() < prec.Level.Assignment.getValue())
         && (!(Previous != null) || Previous.isNot(tok.TokenKind.kw_return)
         || (Style.Language != FormatStyle.LanguageKind.LK_Java && I.$star().getValue() > 0))
         && (Style.AlignAfterOpenBracket != FormatStyle.BracketAlignmentStyle.BAS_DontAlign
         || I.$star() != prec.Level.Comma || Current.NestingLevel == 0)) {
        NewParenState.Indent
           = std.max(std.max(State.Column, NewParenState.Indent), 
            State.Stack.back().LastSpace);
      }
      
      // Don't allow the RHS of an operator to be split over multiple lines unless
      // there is a line-break right after the operator.
      // Exclude relational operators, as there, it is always more desirable to
      // have the LHS 'left' of the RHS.
      if ((Previous != null) && Previous.getPrecedence() != prec.Level.Assignment
         && Previous.isOneOf(TokenType.TT_BinaryOperator, TokenType.TT_ConditionalExpr)
         && Previous.getPrecedence() != prec.Level.Relational) {
        boolean BreakBeforeOperator = Previous.is_TokenKind(tok.TokenKind.lessless)
           || (Previous.is_TokenType(TokenType.TT_BinaryOperator)
           && Style.BreakBeforeBinaryOperators != FormatStyle.BinaryOperatorStyle.BOS_None)
           || (Previous.is_TokenType(TokenType.TT_ConditionalExpr)
           && Style.BreakBeforeTernaryOperators);
        if ((!Newline && !BreakBeforeOperator)
           || (!State.Stack.back().LastOperatorWrapped && BreakBeforeOperator)) {
          NewParenState.NoLineBreak = true;
        }
      }
      
      // Do not indent relative to the fake parentheses inserted for "." or "->".
      // This is a special case to make the following to statements consistent:
      //   OuterFunction(InnerFunctionCall( // break
      //       ParameterToInnerFunction));
      //   OuterFunction(SomeObject.InnerFunctionCall( // break
      //       ParameterToInnerFunction));
      if (I.$star().getValue() > prec.Level.Unknown.getValue()) {
        NewParenState.LastSpace = std.max(NewParenState.LastSpace, State.Column);
      }
      if (I.$star() != prec.Level.Conditional && !Current.is_TokenType(TokenType.TT_UnaryOperator)
         && Style.AlignAfterOpenBracket != FormatStyle.BracketAlignmentStyle.BAS_DontAlign) {
        NewParenState.StartOfFunctionCall = State.Column;
      }
      
      // Always indent conditional expressions. Never indent expression where
      // the 'operator' is ',', ';' or an assignment (i.e. *I <=
      // prec::Assignment) as those have different indentation rules. Indent
      // other expression, unless the indentation needs to be skipped.
      if (I.$star() == prec.Level.Conditional
         || (!SkipFirstExtraIndent && I.$star().getValue() > prec.Level.Assignment.getValue()
         && !Current.isTrailingComment())) {
        NewParenState.Indent += Style.ContinuationIndentWidth;
      }
      if (((Previous != null) && !Previous.opensScope()) || I.$star() != prec.Level.Comma) {
        NewParenState.BreakBeforeParameter = false;
      }
      State.Stack.push_back_T$C$R(NewParenState);
      SkipFirstExtraIndent = false;
    }
  }

  /// \brief Update 'State' according to the next token's fake r_parens.
  //<editor-fold defaultstate="collapsed" desc="clang::format::ContinuationIndenter::moveStatePastFakeRParens">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 904,
   FQN="clang::format::ContinuationIndenter::moveStatePastFakeRParens", NM="_ZN5clang6format20ContinuationIndenter24moveStatePastFakeRParensERNS0_9LineStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format20ContinuationIndenter24moveStatePastFakeRParensERNS0_9LineStateE")
  //</editor-fold>
  private void moveStatePastFakeRParens(final LineState /*&*/ State) {
    for (/*uint*/int i = 0, e = State.NextToken.FakeRParens; i != e; ++i) {
      /*uint*/int VariablePos = State.Stack.back().VariablePos;
      if (State.Stack.size() == 1) {
        // Do not pop the last element.
        break;
      }
      State.Stack.pop_back();
      State.Stack.back().VariablePos = VariablePos;
    }
  }

  
  /// \brief Update 'State' according to the next token being one of "(<{[".
  //<editor-fold defaultstate="collapsed" desc="clang::format::ContinuationIndenter::moveStatePastScopeOpener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 916,
   FQN="clang::format::ContinuationIndenter::moveStatePastScopeOpener", NM="_ZN5clang6format20ContinuationIndenter24moveStatePastScopeOpenerERNS0_9LineStateEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format20ContinuationIndenter24moveStatePastScopeOpenerERNS0_9LineStateEb")
  //</editor-fold>
  private void moveStatePastScopeOpener(final LineState /*&*/ State, 
                          boolean Newline) {
    final /*const*/ FormatToken /*&*/ Current = /*Deref*/State.NextToken;
    if (!Current.opensScope()) {
      return;
    }
    if ((Current.MatchingParen != null) && Current.BlockKind == BraceBlockKind.BK_Block) {
      moveStateToNewBlock(State);
      return;
    }
    
    /*uint*/int NewIndent;
    /*uint*/int NewIndentLevel = State.Stack.back().IndentLevel;
    /*uint*/int LastSpace = State.Stack.back().LastSpace;
    boolean AvoidBinPacking;
    boolean BreakBeforeParameter = false;
    /*uint*/int NestedBlockIndent = std.max(State.Stack.back().StartOfFunctionCall, 
        State.Stack.back().NestedBlockIndent);
    if (Current.isOneOf(tok.TokenKind.l_brace, TokenType.TT_ArrayInitializerLSquare)) {
      if (Current.opensBlockOrBlockTypeList(Style)) {
        NewIndent = State.Stack.back().NestedBlockIndent + Style.IndentWidth;
        NewIndent = std.min_uint(State.Column + 2, NewIndent);
        ++NewIndentLevel;
      } else {
        NewIndent = State.Stack.back().LastSpace + Style.ContinuationIndentWidth;
      }
      /*const*/ FormatToken /*P*/ NextNoComment = Current.getNextNonComment();
      boolean EndsInComma = (Current.MatchingParen != null)
         && (Current.MatchingParen.Previous != null)
         && Current.MatchingParen.Previous.is_TokenKind(tok.TokenKind.comma);
      AvoidBinPacking
         = (Current.is_TokenType(TokenType.TT_ArrayInitializerLSquare) && EndsInComma)
         || Current.is_TokenType(TokenType.TT_DictLiteral)
         || Style.Language == FormatStyle.LanguageKind.LK_Proto || !Style.BinPackArguments
         || ((NextNoComment != null) && NextNoComment.is_TokenType(TokenType.TT_DesignatedInitializerPeriod));
      if ($greater_uint(Current.ParameterCount, 1)) {
        NestedBlockIndent = std.max(NestedBlockIndent, State.Column + 1);
      }
    } else {
      NewIndent = Style.ContinuationIndentWidth
         + std.max(State.Stack.back().LastSpace, 
          State.Stack.back().StartOfFunctionCall);
      
      // Ensure that different different brackets force relative alignment, e.g.:
      // void SomeFunction(vector<  // break
      //                       int> v);
      // FIXME: We likely want to do this for more combinations of brackets.
      // Verify that it is wanted for ObjC, too.
      if (Current.Tok.getKind() == tok.TokenKind.less
         && Current.ParentBracket == tok.TokenKind.l_paren) {
        NewIndent = std.max(NewIndent, State.Stack.back().Indent);
        LastSpace = std.max(LastSpace, State.Stack.back().Indent);
      }
      
      AvoidBinPacking
         = (State.Line.MustBeDeclaration && !Style.BinPackParameters)
         || (!State.Line.MustBeDeclaration && !Style.BinPackArguments)
         || (Style.ExperimentalAutoDetectBinPacking
         && (Current.PackingKind == ParameterPackingKind.PPK_OnePerLine
         || (!BinPackInconclusiveFunctions
         && Current.PackingKind == ParameterPackingKind.PPK_Inconclusive)));
      if (Current.is_TokenType(TokenType.TT_ObjCMethodExpr) && (Current.MatchingParen != null)) {
        if ((Style.ColumnLimit != 0)) {
          // If this '[' opens an ObjC call, determine whether all parameters fit
          // into one line and put one per line if they don't.
          if ($greater_uint(getLengthToMatchingParen(Current) + State.Column
            , getColumnLimit(State))) {
            BreakBeforeParameter = true;
          }
        } else {
          // For ColumnLimit = 0, we have to figure out whether there is or has to
          // be a line break within this call.
          for (/*const*/ FormatToken /*P*/ Tok = /*AddrOf*/Current;
               (Tok != null) && Tok != Current.MatchingParen; Tok = Tok.Next) {
            if (Tok.MustBreakBefore
               || (Tok.CanBreakBefore && $greater_uint(Tok.NewlinesBefore, 0))) {
              BreakBeforeParameter = true;
              break;
            }
          }
        }
      }
    }
    // Generally inherit NoLineBreak from the current scope to nested scope.
    // However, don't do this for non-empty nested blocks, dict literals and
    // array literals as these follow different indentation rules.
    boolean NoLineBreak = Current.Children.empty()
       && !Current.isOneOf(TokenType.TT_DictLiteral, TokenType.TT_ArrayInitializerLSquare)
       && (State.Stack.back().NoLineBreak
       || (Current.is_TokenType(TokenType.TT_TemplateOpener)
       && State.Stack.back().ContainsUnwrappedBuilder));
    State.Stack.push_back_T$RR(new ParenState(NewIndent, NewIndentLevel, LastSpace, 
            AvoidBinPacking, NoLineBreak));
    State.Stack.back().NestedBlockIndent = NestedBlockIndent;
    State.Stack.back().BreakBeforeParameter = BreakBeforeParameter;
    State.Stack.back().HasMultipleNestedBlocks = $greater_uint(Current.BlockParameterCount, 1);
  }

  /// \brief Update 'State' according to the next token being one of ")>}]".
  //<editor-fold defaultstate="collapsed" desc="clang::format::ContinuationIndenter::moveStatePastScopeCloser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 1013,
   FQN="clang::format::ContinuationIndenter::moveStatePastScopeCloser", NM="_ZN5clang6format20ContinuationIndenter24moveStatePastScopeCloserERNS0_9LineStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format20ContinuationIndenter24moveStatePastScopeCloserERNS0_9LineStateE")
  //</editor-fold>
  private void moveStatePastScopeCloser(final LineState /*&*/ State) {
    final /*const*/ FormatToken /*&*/ Current = /*Deref*/State.NextToken;
    if (!Current.closesScope()) {
      return;
    }
    
    // If we encounter a closing ), ], } or >, we can remove a level from our
    // stacks.
    if ($greater_uint(State.Stack.size(), 1)
       && (Current.isOneOf(tok.TokenKind.r_paren, tok.TokenKind.r_square)
       || (Current.is_TokenKind(tok.TokenKind.r_brace) && State.NextToken != State.Line.First)
       || State.NextToken.is_TokenType(TokenType.TT_TemplateCloser))) {
      State.Stack.pop_back();
    }
    if (Current.is_TokenKind(tok.TokenKind.r_square)) {
      // If this ends the array subscript expr, reset the corresponding value.
      /*const*/ FormatToken /*P*/ NextNonComment = Current.getNextNonComment();
      if ((NextNonComment != null) && NextNonComment.isNot(tok.TokenKind.l_square)) {
        State.Stack.back().StartOfArraySubscripts = 0;
      }
    }
  }

  /// \brief Update 'State' with the next token opening a nested block.
  //<editor-fold defaultstate="collapsed" desc="clang::format::ContinuationIndenter::moveStateToNewBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 1034,
   FQN="clang::format::ContinuationIndenter::moveStateToNewBlock", NM="_ZN5clang6format20ContinuationIndenter19moveStateToNewBlockERNS0_9LineStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format20ContinuationIndenter19moveStateToNewBlockERNS0_9LineStateE")
  //</editor-fold>
  private void moveStateToNewBlock(final LineState /*&*/ State) {
    /*uint*/int NestedBlockIndent = State.Stack.back().NestedBlockIndent;
    // ObjC block sometimes follow special indentation rules.
    /*uint*/int NewIndent = NestedBlockIndent + (State.NextToken.is_TokenType(TokenType.TT_ObjCBlockLBrace) ? Style.ObjCBlockIndentWidth : Style.IndentWidth);
    State.Stack.push_back_T$RR(new ParenState(NewIndent, /*NewIndentLevel=*/ State.Stack.back().IndentLevel + 1, 
            State.Stack.back().LastSpace, /*AvoidBinPacking=*/ true, 
            /*NoLineBreak=*/ false));
    State.Stack.back().NestedBlockIndent = NestedBlockIndent;
    State.Stack.back().BreakBeforeParameter = true;
  }

  
  /// \brief If the current token sticks out over the end of the line, break
  /// it if possible.
  ///
  /// \returns An extra penalty if a token was broken, otherwise 0.
  ///
  /// The returned penalty will cover the cost of the additional line breaks and
  /// column limit violation in all lines except for the last one. The penalty
  /// for the column limit violation in the last line (and in single line
  /// tokens) is handled in \c addNextStateToQueue.
  //<editor-fold defaultstate="collapsed" desc="clang::format::ContinuationIndenter::breakProtrudingToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 1068,
   FQN="clang::format::ContinuationIndenter::breakProtrudingToken", NM="_ZN5clang6format20ContinuationIndenter20breakProtrudingTokenERKNS0_11FormatTokenERNS0_9LineStateEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format20ContinuationIndenter20breakProtrudingTokenERKNS0_11FormatTokenERNS0_9LineStateEb")
  //</editor-fold>
  private /*uint*/int breakProtrudingToken(final /*const*/ FormatToken /*&*/ Current, 
                      final LineState /*&*/ State, 
                      boolean DryRun) {
    std.unique_ptr<BreakableToken> Token = null;
    try {
      // Don't break multi-line tokens other than block comments. Instead, just
      // update the state.
      if (Current.isNot(TokenType.TT_BlockComment) && Current.IsMultiline) {
        return addMultilineToken(Current, State);
      }
      
      // Don't break implicit string literals or import statements.
      if (Current.is_TokenType(TokenType.TT_ImplicitStringLiteral)
         || State.Line.Type == LineType.LT_ImportStatement) {
        return 0;
      }
      if (!Current.isStringLiteral() && !Current.is_TokenKind(tok.TokenKind.comment)) {
        return 0;
      }
      
      Token/*J*/= new std.unique_ptr<BreakableToken>();
      /*uint*/int StartColumn = State.Column - Current.ColumnWidth;
      /*uint*/int ColumnLimit = getColumnLimit(State);
      if (Current.isStringLiteral()) {
        // FIXME: String literal breaking is currently disabled for Java and JS, as
        // it requires strings to be merged using "+" which we don't support.
        if (Style.Language == FormatStyle.LanguageKind.LK_Java
           || Style.Language == FormatStyle.LanguageKind.LK_JavaScript
           || !Style.BreakStringLiterals) {
          return 0;
        }
        
        // Don't break string literals inside preprocessor directives (except for
        // #define directives, as their contents are stored in separate lines and
        // are not affected by this check).
        // This way we avoid breaking code with line directives and unknown
        // preprocessor directives that contain long string literals.
        if (State.Line.Type == LineType.LT_PreprocessorDirective) {
          return 0;
        }
        // Exempts unterminated string literals from line breaking. The user will
        // likely want to terminate the string before any line breaking is done.
        if (Current.IsUnterminatedLiteral) {
          return 0;
        }
        
        StringRef Text = new StringRef(Current.TokenText);
        StringRef Prefix/*J*/= new StringRef();
        StringRef Postfix/*J*/= new StringRef();
        boolean IsNSStringLiteral = false;
        // FIXME: Handle whitespace between '_T', '(', '"..."', and ')'.
        // FIXME: Store Prefix and Suffix (or PrefixLength and SuffixLength to
        // reduce the overhead) for each FormatToken, which is a string, so that we
        // don't run multiple checks here on the hot path.
        if (Text.startswith(/*STRINGREF_STR*/"\"") && (Current.Previous != null)
           && Current.Previous.is_TokenKind(tok.TokenKind.at)) {
          IsNSStringLiteral = true;
          Prefix.$assignMove(/*STRINGREF_STR*/"@\"");
        }
        if ((Text.endswith(/*NO_COPY*/Postfix.$assignMove(/*STRINGREF_STR*/$DBL_QUOTE))
           && (IsNSStringLiteral || Text.startswith(/*NO_COPY*/Prefix.$assignMove(/*STRINGREF_STR*/$DBL_QUOTE))
           || Text.startswith(/*NO_COPY*/Prefix.$assignMove(/*STRINGREF_STR*/"u\"")) || Text.startswith(/*NO_COPY*/Prefix.$assignMove(/*STRINGREF_STR*/"U\""))
           || Text.startswith(/*NO_COPY*/Prefix.$assignMove(/*STRINGREF_STR*/"u8\""))
           || Text.startswith(/*NO_COPY*/Prefix.$assignMove(/*STRINGREF_STR*/"L\""))))
           || (Text.startswith(/*NO_COPY*/Prefix.$assignMove(/*STRINGREF_STR*/"_T(\"")) && Text.endswith(/*NO_COPY*/Postfix.$assignMove(/*STRINGREF_STR*/"\")")))) {
          Token.reset(new BreakableStringLiteral(Current, State.Line.Level, StartColumn, new StringRef(Prefix), new StringRef(Postfix), 
                  State.Line.InPPDirective, Encoding, Style));
        } else {
          return 0;
        }
      } else if (Current.is_TokenType(TokenType.TT_BlockComment)) {
        if (!Current.isTrailingComment() || !Style.ReflowComments
           || CommentPragmasRegex.find(/*match(*/Current.TokenText.substr(2))) {
          return addMultilineToken(Current, State);
        }
        Token.reset(new BreakableBlockComment(Current, State.Line.Level, StartColumn, Current.OriginalColumn, 
                !(Current.Previous != null), State.Line.InPPDirective, Encoding, Style));
      } else if (Current.is_TokenType(TokenType.TT_LineComment)
         && (Current.Previous == null
         || Current.Previous.isNot(TokenType.TT_ImplicitStringLiteral))) {
        if (!Style.ReflowComments
           || CommentPragmasRegex.find(/*match(*/Current.TokenText.substr(2))) {
          return 0;
        }
        Token.reset(new BreakableLineComment(Current, State.Line.Level, 
                StartColumn, /*InPPDirective=*/ false, 
                Encoding, Style));
        // We don't insert backslashes when breaking line comments.
        ColumnLimit = Style.ColumnLimit;
      } else {
        return 0;
      }
      if ($greatereq_uint(Current.UnbreakableTailLength, ColumnLimit)) {
        return 0;
      }
      
      /*uint*/int RemainingSpace = ColumnLimit - Current.UnbreakableTailLength;
      boolean BreakInserted = false;
      /*uint*/int Penalty = 0;
      /*uint*/int RemainingTokenColumns = 0;
      for (/*uint*/int LineIndex = 0, EndIndex = Token.$arrow().getLineCount();
           LineIndex != EndIndex; ++LineIndex) {
        if (!DryRun) {
          Token.$arrow().replaceWhitespaceBefore(LineIndex, Whitespaces);
        }
        /*uint*/int TailOffset = 0;
        RemainingTokenColumns
           = Token.$arrow().getLineLengthAfterSplit(LineIndex, TailOffset, StringRef.npos);
        while ($greater_uint(RemainingTokenColumns, RemainingSpace)) {
          std.pairUIntUInt Split = Token.$arrow().getSplit(LineIndex, TailOffset, ColumnLimit);
          if (Split.first == StringRef.npos) {
            // The last line's penalty is handled in addNextStateToQueue().
            if ($less_uint(LineIndex, EndIndex - 1)) {
              Penalty += Style.PenaltyExcessCharacter
                 * (RemainingTokenColumns - RemainingSpace);
            }
            break;
          }
          assert (Split.first != 0);
          /*uint*/int NewRemainingTokenColumns = Token.$arrow().getLineLengthAfterSplit(LineIndex, TailOffset + Split.first + Split.second, StringRef.npos);
          
          // We can remove extra whitespace instead of breaking the line.
          if ($lesseq_uint(RemainingTokenColumns + 1 - Split.second, RemainingSpace)) {
            RemainingTokenColumns = 0;
            if (!DryRun) {
              Token.$arrow().replaceWhitespace(LineIndex, TailOffset, new std.pairUIntUInt(Split), Whitespaces);
            }
            break;
          }
          
          // When breaking before a tab character, it may be moved by a few columns,
          // but will still be expanded to the next tab stop, so we don't save any
          // columns.
          if (NewRemainingTokenColumns == RemainingTokenColumns) {
            break;
          }
          assert ($less_uint(NewRemainingTokenColumns, RemainingTokenColumns));
          if (!DryRun) {
            Token.$arrow().insertBreak(LineIndex, TailOffset, new std.pairUIntUInt(Split), Whitespaces);
          }
          Penalty += Current.SplitPenalty;
          /*uint*/int ColumnsUsed = Token.$arrow().getLineLengthAfterSplit(LineIndex, TailOffset, Split.first);
          if ($greater_uint(ColumnsUsed, ColumnLimit)) {
            Penalty += Style.PenaltyExcessCharacter * (ColumnsUsed - ColumnLimit);
          }
          TailOffset += Split.first + Split.second;
          RemainingTokenColumns = NewRemainingTokenColumns;
          BreakInserted = true;
        }
      }
      
      State.Column = RemainingTokenColumns;
      if (BreakInserted) {
        // If we break the token inside a parameter list, we need to break before
        // the next parameter on all levels, so that the next parameter is clearly
        // visible. Line comments already introduce a break.
        if (Current.isNot(TokenType.TT_LineComment)) {
          for (/*uint*/int i = 0, e = State.Stack.size(); i != e; ++i)  {
            State.Stack.$at(i).BreakBeforeParameter = true;
          }
        }
        
        Penalty += Current.isStringLiteral() ? Style.PenaltyBreakString : Style.PenaltyBreakComment;
        
        State.Stack.back().LastSpace = StartColumn;
      }
      return Penalty;
    } finally {
      if (Token != null) { Token.$destroy(); }
    }
  }

  
  /// \brief Appends the next token to \p State and updates information
  /// necessary for indentation.
  ///
  /// Puts the token on the current line.
  ///
  /// If \p DryRun is \c false, also creates and stores the required
  /// \c Replacement.
  //<editor-fold defaultstate="collapsed" desc="clang::format::ContinuationIndenter::addTokenOnCurrentLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 312,
   FQN="clang::format::ContinuationIndenter::addTokenOnCurrentLine", NM="_ZN5clang6format20ContinuationIndenter21addTokenOnCurrentLineERNS0_9LineStateEbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format20ContinuationIndenter21addTokenOnCurrentLineERNS0_9LineStateEbj")
  //</editor-fold>
  private void addTokenOnCurrentLine(final LineState /*&*/ State, boolean DryRun, 
                       /*uint*/int ExtraSpaces) {
    final FormatToken /*&*/ Current = /*Deref*/State.NextToken;
    final /*const*/ FormatToken /*&*/ Previous = /*Deref*/State.NextToken.Previous;
    if (Current.is_TokenKind(tok.TokenKind.equal)
       && (State.Line.First.is_TokenKind(tok.TokenKind.kw_for) || Current.NestingLevel == 0)
       && State.Stack.back().VariablePos == 0) {
      State.Stack.back().VariablePos = State.Column;
      // Move over * and & if they are bound to the variable name.
      /*const*/ FormatToken /*P*/ Tok = /*AddrOf*/Previous;
      while ((Tok != null) && $greatereq_uint(State.Stack.back().VariablePos, Tok.ColumnWidth)) {
        State.Stack.back().VariablePos -= Tok.ColumnWidth;
        if (Tok.SpacesRequiredBefore != 0) {
          break;
        }
        Tok = Tok.Previous;
      }
      if (Previous.PartOfMultiVariableDeclStmt) {
        State.Stack.back().LastSpace = State.Stack.back().VariablePos;
      }
    }
    
    /*uint*/int Spaces = Current.SpacesRequiredBefore + ExtraSpaces;
    if (!DryRun) {
      Whitespaces.replaceWhitespace(Current, /*Newlines=*/ 0, /*IndentLevel=*/ 0, 
          Spaces, State.Column + Spaces);
    }
    if (Current.is_TokenType(TokenType.TT_SelectorName)
       && !State.Stack.back().ObjCSelectorNameFound) {
      /*uint*/int MinIndent = std.max(State.FirstIndent + Style.ContinuationIndentWidth, 
          State.Stack.back().Indent);
      /*uint*/int FirstColonPos = State.Column + Spaces + Current.ColumnWidth;
      if (Current.LongestObjCSelectorName == 0) {
        State.Stack.back().AlignColons = false;
      } else if ($greater_uint(MinIndent + Current.LongestObjCSelectorName, FirstColonPos)) {
        State.Stack.back().ColonPos = MinIndent + Current.LongestObjCSelectorName;
      } else {
        State.Stack.back().ColonPos = FirstColonPos;
      }
    }
    
    // In "AlwaysBreak" mode, enforce wrapping directly after the parenthesis by
    // disallowing any further line breaks if there is no line break after the
    // opening parenthesis. Don't break if it doesn't conserve columns.
    if (Style.AlignAfterOpenBracket == FormatStyle.BracketAlignmentStyle.BAS_AlwaysBreak
       && Previous.isOneOf(tok.TokenKind.l_paren, TokenType.TT_TemplateOpener, tok.TokenKind.l_square)
       && $greater_uint(State.Column, getNewLineColumn(State))
       && (!(Previous.Previous != null)
       || !Previous.Previous.isOneOf(tok.TokenKind.kw_for, tok.TokenKind.kw_while, 
        tok.TokenKind.kw_switch))
      // Don't do this for simple (no expressions) one-argument function calls
      // as that feels like needlessly wasting whitespace, e.g.:
      //
      //   caaaaaaaaaaaall(
      //       caaaaaaaaaaaall(
      //           caaaaaaaaaaaall(
      //               caaaaaaaaaaaaaaaaaaaaaaall(aaaaaaaaaaaaaa, aaaaaaaaa))));
       && $greater_uint(Current.FakeLParens.size(), 0)
       && Current.FakeLParens.back().getValue() > prec.Level.Unknown.getValue()) {
      State.Stack.back().NoLineBreak = true;
    }
    if (Style.AlignAfterOpenBracket != FormatStyle.BracketAlignmentStyle.BAS_DontAlign
       && Previous.opensScope() && Previous.isNot(TokenType.TT_ObjCMethodExpr)
       && (Current.isNot(TokenType.TT_LineComment) || Previous.BlockKind == BraceBlockKind.BK_BracedInit)) {
      State.Stack.back().Indent = State.Column + Spaces;
    }
    if (State.Stack.back().AvoidBinPacking && startsNextParameter(Current, Style)) {
      State.Stack.back().NoLineBreak = true;
    }
    if (startsSegmentOfBuilderTypeCall(Current)
       && $greater_uint(State.Column, getNewLineColumn(State))) {
      State.Stack.back().ContainsUnwrappedBuilder = true;
    }
    if (Current.is_TokenType(TokenType.TT_LambdaArrow) && Style.Language == FormatStyle.LanguageKind.LK_Java) {
      State.Stack.back().NoLineBreak = true;
    }
    if (Current.isMemberAccess() && Previous.is_TokenKind(tok.TokenKind.r_paren)
       && ((Previous.MatchingParen != null)
       && ($greater_uint(Previous.TotalLength - Previous.MatchingParen.TotalLength, 10)))) {
      // If there is a function call with long parameters, break before trailing
      // calls. This prevents things like:
      //   EXPECT_CALL(SomeLongParameter).Times(
      //       2);
      // We don't want to do this for short parameters as they can just be
      // indexes.
      State.Stack.back().NoLineBreak = true;
    }
    
    State.Column += Spaces;
    if (Current.isNot(tok.TokenKind.comment) && Previous.is_TokenKind(tok.TokenKind.l_paren)
       && (Previous.Previous != null)
       && Previous.Previous.isOneOf(tok.TokenKind.kw_if, tok.TokenKind.kw_for)) {
      // Treat the condition inside an if as if it was a second function
      // parameter, i.e. let nested calls have a continuation indent.
      State.Stack.back().LastSpace = State.Column;
      State.Stack.back().NestedBlockIndent = State.Column;
    } else if (!Current.isOneOf(tok.TokenKind.comment, tok.TokenKind.caret)
       && ((Previous.is_TokenKind(tok.TokenKind.comma)
       && !Previous.is_TokenType(TokenType.TT_OverloadedOperator))
       || (Previous.is_TokenKind(tok.TokenKind.colon) && Previous.is_TokenType(TokenType.TT_ObjCMethodExpr)))) {
      State.Stack.back().LastSpace = State.Column;
    } else if ((Previous.isOneOf(TokenType.TT_BinaryOperator, TokenType.TT_ConditionalExpr, 
        TokenType.TT_CtorInitializerColon))
       && ((Previous.getPrecedence() != prec.Level.Assignment
       && (Previous.isNot(tok.TokenKind.lessless) || Previous.OperatorIndex != 0
       || (Previous.NextOperator != null)))
       || Current.StartsBinaryExpression)) {
      // Indent relative to the RHS of the expression unless this is a simple
      // assignment without binary expression on the RHS. Also indent relative to
      // unary operators and the colons of constructor initializers.
      State.Stack.back().LastSpace = State.Column;
    } else if (Previous.is_TokenType(TokenType.TT_InheritanceColon)) {
      State.Stack.back().Indent = State.Column;
      State.Stack.back().LastSpace = State.Column;
    } else if (Previous.opensScope()) {
      // If a function has a trailing call, indent all parameters from the
      // opening parenthesis. This avoids confusing indents like:
      //   OuterFunction(InnerFunctionCall( // break
      //       ParameterToInnerFunction))   // break
      //       .SecondInnerFunctionCall();
      boolean HasTrailingCall = false;
      if ((Previous.MatchingParen != null)) {
        /*const*/ FormatToken /*P*/ Next = Previous.MatchingParen.getNextNonComment();
        HasTrailingCall = (Next != null) && Next.isMemberAccess();
      }
      if (HasTrailingCall && $greater_uint(State.Stack.size(), 1)
         && State.Stack.$at(State.Stack.size() - 2).CallContinuation == 0) {
        State.Stack.back().LastSpace = State.Column;
      }
    }
  }

  
  /// \brief Appends the next token to \p State and updates information
  /// necessary for indentation.
  ///
  /// Adds a line break and necessary indentation.
  ///
  /// If \p DryRun is \c false, also creates and stores the required
  /// \c Replacement.
  //<editor-fold defaultstate="collapsed" desc="clang::format::ContinuationIndenter::addTokenOnNewLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 439,
   FQN="clang::format::ContinuationIndenter::addTokenOnNewLine", NM="_ZN5clang6format20ContinuationIndenter17addTokenOnNewLineERNS0_9LineStateEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format20ContinuationIndenter17addTokenOnNewLineERNS0_9LineStateEb")
  //</editor-fold>
  private /*uint*/int addTokenOnNewLine(final LineState /*&*/ State, 
                   boolean DryRun) {
    final FormatToken /*&*/ Current = /*Deref*/State.NextToken;
    final /*const*/ FormatToken /*&*/ Previous = /*Deref*/State.NextToken.Previous;
    
    // Extra penalty that needs to be added because of the way certain line
    // breaks are chosen.
    /*uint*/int Penalty = 0;
    
    /*const*/ FormatToken /*P*/ PreviousNonComment = Current.getPreviousNonComment();
    /*const*/ FormatToken /*P*/ NextNonComment = Previous.getNextNonComment();
    if (!(NextNonComment != null)) {
      NextNonComment = /*AddrOf*/Current;
    }
    // The first line break on any NestingLevel causes an extra penalty in order
    // prefer similar line breaks.
    if (!State.Stack.back().ContainsLineBreak) {
      Penalty += 15;
    }
    State.Stack.back().ContainsLineBreak = true;
    
    Penalty += State.NextToken.SplitPenalty;
    
    // Breaking before the first "<<" is generally not desirable if the LHS is
    // short. Also always add the penalty if the LHS is split over mutliple lines
    // to avoid unnecessary line breaks that just work around this penalty.
    if (NextNonComment.is_TokenKind(tok.TokenKind.lessless)
       && State.Stack.back().FirstLessLess == 0
       && ($lesseq_uint(State.Column, $div_uint(Style.ColumnLimit, 3))
       || State.Stack.back().BreakBeforeParameter)) {
      Penalty += Style.PenaltyBreakFirstLessLess;
    }
    
    State.Column = getNewLineColumn(State);
    
    // Indent nested blocks relative to this column, unless in a very specific
    // JavaScript special case where:
    //
    //   var loooooong_name =
    //       function() {
    //     // code
    //   }
    //
    // is common and should be formatted like a free-standing function. The same
    // goes for wrapping before the lambda return type arrow.
    if (!Current.is_TokenType(TokenType.TT_LambdaArrow)
       && (Style.Language != FormatStyle.LanguageKind.LK_JavaScript
       || Current.NestingLevel != 0 || !(PreviousNonComment != null)
       || !PreviousNonComment.is_TokenKind(tok.TokenKind.equal)
       || !Current.isOneOf(Keywords.kw_async, Keywords.kw_function))) {
      State.Stack.back().NestedBlockIndent = State.Column;
    }
    if (NextNonComment.isMemberAccess()) {
      if (State.Stack.back().CallContinuation == 0) {
        State.Stack.back().CallContinuation = State.Column;
      }
    } else if (NextNonComment.is_TokenType(TokenType.TT_SelectorName)) {
      if (!State.Stack.back().ObjCSelectorNameFound) {
        if (NextNonComment.LongestObjCSelectorName == 0) {
          State.Stack.back().AlignColons = false;
        } else {
          State.Stack.back().ColonPos
             = (Style.IndentWrappedFunctionNames ? std.max(State.Stack.back().Indent, 
              State.FirstIndent + Style.ContinuationIndentWidth) : State.Stack.back().Indent)
             + NextNonComment.LongestObjCSelectorName;
        }
      } else if (State.Stack.back().AlignColons
         && $lesseq_uint(State.Stack.back().ColonPos, NextNonComment.ColumnWidth)) {
        State.Stack.back().ColonPos = State.Column + NextNonComment.ColumnWidth;
      }
    } else if ((PreviousNonComment != null) && PreviousNonComment.is_TokenKind(tok.TokenKind.colon)
       && PreviousNonComment.isOneOf(TokenType.TT_ObjCMethodExpr, TokenType.TT_DictLiteral)) {
      // FIXME: This is hacky, find a better way. The problem is that in an ObjC
      // method expression, the block should be aligned to the line starting it,
      // e.g.:
      //   [aaaaaaaaaaaaaaa aaaaaaaaa: \\ break for some reason
      //                        ^(int *i) {
      //                            // ...
      //                        }];
      // Thus, we set LastSpace of the next higher NestingLevel, to which we move
      // when we consume all of the "}"'s FakeRParens at the "{".
      if ($greater_uint(State.Stack.size(), 1)) {
        State.Stack.$at(State.Stack.size() - 2).LastSpace
           = std.max(State.Stack.back().LastSpace, State.Stack.back().Indent)
           + Style.ContinuationIndentWidth;
      }
    }
    if ((Previous.isOneOf(tok.TokenKind.comma, tok.TokenKind.semi)
       && !State.Stack.back().AvoidBinPacking)
       || Previous.is_TokenType(TokenType.TT_BinaryOperator)) {
      State.Stack.back().BreakBeforeParameter = false;
    }
    if (Previous.isOneOf(TokenType.TT_TemplateCloser, TokenType.TT_JavaAnnotation)
       && Current.NestingLevel == 0) {
      State.Stack.back().BreakBeforeParameter = false;
    }
    if (NextNonComment.is_TokenKind(tok.TokenKind.question)
       || ((PreviousNonComment != null) && PreviousNonComment.is_TokenKind(tok.TokenKind.question))) {
      State.Stack.back().BreakBeforeParameter = true;
    }
    if (Current.is_TokenType(TokenType.TT_BinaryOperator) && Current.CanBreakBefore) {
      State.Stack.back().BreakBeforeParameter = false;
    }
    if (!DryRun) {
      /*uint*/int Newlines = std.max(1/*U*/, std.min_uint(Current.NewlinesBefore, Style.MaxEmptyLinesToKeep + 1));
      Whitespaces.replaceWhitespace(Current, Newlines, 
          State.Stack.back().IndentLevel, State.Column, 
          State.Column, State.Line.InPPDirective);
    }
    if (!Current.isTrailingComment()) {
      State.Stack.back().LastSpace = State.Column;
    }
    if (Current.is_TokenKind(tok.TokenKind.lessless)) {
      // If we are breaking before a "<<", we always want to indent relative to
      // RHS. This is necessary only for "<<", as we special-case it and don't
      // always indent relative to the RHS.
      State.Stack.back().LastSpace += 3; // 3 -> width of "<< ".
    }
    
    State.StartOfLineLevel = Current.NestingLevel;
    State.LowestLevelOnLine = Current.NestingLevel;
    
    // Any break on this level means that the parent level has been broken
    // and we need to avoid bin packing there.
    boolean NestedBlockSpecialCase = Style.Language != FormatStyle.LanguageKind.LK_Cpp
       && Current.is_TokenKind(tok.TokenKind.r_brace) && $greater_uint(State.Stack.size(), 1)
       && State.Stack.$at(State.Stack.size() - 2).NestedBlockInlined;
    if (!NestedBlockSpecialCase) {
      for (/*uint*/int i = 0, e = State.Stack.size() - 1; i != e; ++i)  {
        State.Stack.$at(i).BreakBeforeParameter = true;
      }
    }
    if ((PreviousNonComment != null)
       && !PreviousNonComment.isOneOf(tok.TokenKind.comma, tok.TokenKind.semi)
       && (PreviousNonComment.isNot(TokenType.TT_TemplateCloser)
       || Current.NestingLevel != 0)
       && !PreviousNonComment.isOneOf(TokenType.TT_BinaryOperator, TokenType.TT_FunctionAnnotationRParen, TokenType.TT_JavaAnnotation, 
        TokenType.TT_LeadingJavaAnnotation)
       && Current.isNot(TokenType.TT_BinaryOperator) && !PreviousNonComment.opensScope()) {
      State.Stack.back().BreakBeforeParameter = true;
    }
    
    // If we break after { or the [ of an array initializer, we should also break
    // before the corresponding } or ].
    if ((PreviousNonComment != null)
       && (PreviousNonComment.isOneOf(tok.TokenKind.l_brace, TokenType.TT_ArrayInitializerLSquare))) {
      State.Stack.back().BreakBeforeClosingBrace = true;
    }
    if (State.Stack.back().AvoidBinPacking) {
      // If we are breaking after '(', '{', '<', this is not bin packing
      // unless AllowAllParametersOfDeclarationOnNextLine is false or this is a
      // dict/object literal.
      if (!Previous.isOneOf(tok.TokenKind.l_paren, tok.TokenKind.l_brace, TokenType.TT_BinaryOperator)
         || (!Style.AllowAllParametersOfDeclarationOnNextLine
         && State.Line.MustBeDeclaration)
         || Previous.is_TokenType(TokenType.TT_DictLiteral)) {
        State.Stack.back().BreakBeforeParameter = true;
      }
    }
    
    return Penalty;
  }

  
  /// \brief Calculate the new column for a line wrap before the next token.
  //<editor-fold defaultstate="collapsed" desc="clang::format::ContinuationIndenter::getNewLineColumn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 596,
   FQN="clang::format::ContinuationIndenter::getNewLineColumn", NM="_ZN5clang6format20ContinuationIndenter16getNewLineColumnERKNS0_9LineStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format20ContinuationIndenter16getNewLineColumnERKNS0_9LineStateE")
  //</editor-fold>
  private /*uint*/int getNewLineColumn(final /*const*/ LineState /*&*/ State) {
    if (!(State.NextToken != null) || !(State.NextToken.Previous != null)) {
      return 0;
    }
    final FormatToken /*&*/ Current = /*Deref*/State.NextToken;
    final /*const*/ FormatToken /*&*/ Previous = /*Deref*/Current.Previous;
    // If we are continuing an expression, we want to use the continuation indent.
    /*uint*/int ContinuationIndent = std.max(State.Stack.back$Const().LastSpace, State.Stack.back$Const().Indent)
       + Style.ContinuationIndentWidth;
    /*const*/ FormatToken /*P*/ PreviousNonComment = Current.getPreviousNonComment();
    /*const*/ FormatToken /*P*/ NextNonComment = Previous.getNextNonComment();
    if (!(NextNonComment != null)) {
      NextNonComment = /*AddrOf*/Current;
    }
    
    // Java specific bits.
    if (Style.Language == FormatStyle.LanguageKind.LK_Java
       && Current.isOneOf(Keywords.kw_implements, Keywords.kw_extends)) {
      return std.max(State.Stack.back$Const().LastSpace, 
          State.Stack.back$Const().Indent + Style.ContinuationIndentWidth);
    }
    if (NextNonComment.is_TokenKind(tok.TokenKind.l_brace) && NextNonComment.BlockKind == BraceBlockKind.BK_Block) {
      return Current.NestingLevel == 0 ? State.FirstIndent : State.Stack.back$Const().Indent;
    }
    if (Current.isOneOf(tok.TokenKind.r_brace, tok.TokenKind.r_square) && $greater_uint(State.Stack.size(), 1)) {
      if (Current.closesBlockOrBlockTypeList(Style)) {
        return State.Stack.$at$Const(State.Stack.size() - 2).NestedBlockIndent;
      }
      if ((Current.MatchingParen != null)
         && Current.MatchingParen.BlockKind == BraceBlockKind.BK_BracedInit) {
        return State.Stack.$at$Const(State.Stack.size() - 2).LastSpace;
      }
      return State.FirstIndent;
    }
    if (Current.is_TokenKind(tok.TokenKind.identifier) && (Current.Next != null)
       && Current.Next.is_TokenType(TokenType.TT_DictLiteral)) {
      return State.Stack.back$Const().Indent;
    }
    if (NextNonComment.isStringLiteral() && State.StartOfStringLiteral != 0) {
      return State.StartOfStringLiteral;
    }
    if (NextNonComment.is_TokenType(TokenType.TT_ObjCStringLiteral)
       && State.StartOfStringLiteral != 0) {
      return State.StartOfStringLiteral - 1;
    }
    if (NextNonComment.is_TokenKind(tok.TokenKind.lessless)
       && State.Stack.back$Const().FirstLessLess != 0) {
      return State.Stack.back$Const().FirstLessLess;
    }
    if (NextNonComment.isMemberAccess()) {
      if (State.Stack.back$Const().CallContinuation == 0) {
        return ContinuationIndent;
      }
      return State.Stack.back$Const().CallContinuation;
    }
    if (State.Stack.back$Const().QuestionColumn != 0
       && ((NextNonComment.is_TokenKind(tok.TokenKind.colon)
       && NextNonComment.is_TokenType(TokenType.TT_ConditionalExpr))
       || Previous.is_TokenType(TokenType.TT_ConditionalExpr))) {
      return State.Stack.back$Const().QuestionColumn;
    }
    if (Previous.is_TokenKind(tok.TokenKind.comma) && State.Stack.back$Const().VariablePos != 0) {
      return State.Stack.back$Const().VariablePos;
    }
    if (((PreviousNonComment != null)
       && (PreviousNonComment.ClosesTemplateDeclaration
       || PreviousNonComment.isOneOf(TokenType.TT_AttributeParen, TokenType.TT_FunctionAnnotationRParen, TokenType.TT_JavaAnnotation, 
        TokenType.TT_LeadingJavaAnnotation)))
       || (!Style.IndentWrappedFunctionNames
       && NextNonComment.isOneOf(tok.TokenKind.kw_operator, TokenType.TT_FunctionDeclarationName))) {
      return std.max(State.Stack.back$Const().LastSpace, State.Stack.back$Const().Indent);
    }
    if (NextNonComment.is_TokenType(TokenType.TT_SelectorName)) {
      if (!State.Stack.back$Const().ObjCSelectorNameFound) {
        if (NextNonComment.LongestObjCSelectorName == 0) {
          return State.Stack.back$Const().Indent;
        }
        return (Style.IndentWrappedFunctionNames ? std.max(State.Stack.back$Const().Indent, 
            State.FirstIndent + Style.ContinuationIndentWidth) : State.Stack.back$Const().Indent)
           + NextNonComment.LongestObjCSelectorName
           - NextNonComment.ColumnWidth;
      }
      if (!State.Stack.back$Const().AlignColons) {
        return State.Stack.back$Const().Indent;
      }
      if ($greater_uint(State.Stack.back$Const().ColonPos, NextNonComment.ColumnWidth)) {
        return State.Stack.back$Const().ColonPos - NextNonComment.ColumnWidth;
      }
      return State.Stack.back$Const().Indent;
    }
    if (NextNonComment.is_TokenType(TokenType.TT_ArraySubscriptLSquare)) {
      if (State.Stack.back$Const().StartOfArraySubscripts != 0) {
        return State.Stack.back$Const().StartOfArraySubscripts;
      }
      return ContinuationIndent;
    }
    
    // This ensure that we correctly format ObjC methods calls without inputs,
    // i.e. where the last element isn't selector like: [callee method];
    if (NextNonComment.is_TokenKind(tok.TokenKind.identifier) && NextNonComment.FakeRParens == 0
       && (NextNonComment.Next != null) && NextNonComment.Next.is_TokenType(TokenType.TT_ObjCMethodExpr)) {
      return State.Stack.back$Const().Indent;
    }
    if (NextNonComment.isOneOf(TokenType.TT_StartOfName, TokenType.TT_PointerOrReference)
       || Previous.isOneOf(tok.TokenKind.coloncolon, tok.TokenKind.equal, TokenType.TT_JsTypeColon)) {
      return ContinuationIndent;
    }
    if ((PreviousNonComment != null) && PreviousNonComment.is_TokenKind(tok.TokenKind.colon)
       && PreviousNonComment.isOneOf(TokenType.TT_ObjCMethodExpr, TokenType.TT_DictLiteral)) {
      return ContinuationIndent;
    }
    if (NextNonComment.is_TokenType(TokenType.TT_CtorInitializerColon)) {
      return State.FirstIndent + Style.ConstructorInitializerIndentWidth;
    }
    if (NextNonComment.is_TokenType(TokenType.TT_CtorInitializerComma)) {
      return State.Stack.back$Const().Indent;
    }
    if (Previous.is_TokenKind(tok.TokenKind.r_paren) && !Current.isBinaryOperator()
       && !Current.isOneOf(tok.TokenKind.colon, tok.TokenKind.comment)) {
      return ContinuationIndent;
    }
    if (State.Stack.back$Const().Indent == State.FirstIndent && (PreviousNonComment != null)
       && PreviousNonComment.isNot(tok.TokenKind.r_brace)) {
      // Ensure that we fall back to the continuation indent width instead of
      // just flushing continuations left.
      return State.Stack.back$Const().Indent + Style.ContinuationIndentWidth;
    }
    return State.Stack.back$Const().Indent;
  }

  
  /// \brief Adds a multiline token to the \p State.
  ///
  /// \returns Extra penalty for the first line of the literal: last line is
  /// handled in \c addNextStateToQueue, and the penalty for other lines doesn't
  /// matter, as we don't change them.
  //<editor-fold defaultstate="collapsed" desc="clang::format::ContinuationIndenter::addMultilineToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 1049,
   FQN="clang::format::ContinuationIndenter::addMultilineToken", NM="_ZN5clang6format20ContinuationIndenter17addMultilineTokenERKNS0_11FormatTokenERNS0_9LineStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format20ContinuationIndenter17addMultilineTokenERKNS0_11FormatTokenERNS0_9LineStateE")
  //</editor-fold>
  private /*uint*/int addMultilineToken(final /*const*/ FormatToken /*&*/ Current, 
                   final LineState /*&*/ State) {
    if (!Current.IsMultiline) {
      return 0;
    }
    
    // Break before further function parameters on all levels.
    for (/*uint*/int i = 0, e = State.Stack.size(); i != e; ++i)  {
      State.Stack.$at(i).BreakBeforeParameter = true;
    }
    
    /*uint*/int ColumnsUsed = State.Column;
    // We can only affect layout of the first and the last line, so the penalty
    // for all other lines is constant, and we ignore it.
    State.Column = Current.LastLineColumnWidth;
    if ($greater_uint(ColumnsUsed, getColumnLimit(State))) {
      return Style.PenaltyExcessCharacter * (ColumnsUsed - getColumnLimit(State));
    }
    return 0;
  }

  
  /// \brief Returns \c true if the next token starts a multiline string
  /// literal.
  ///
  /// This includes implicitly concatenated strings, strings that will be broken
  /// by clang-format and string literals with escaped newlines.
  //<editor-fold defaultstate="collapsed" desc="clang::format::ContinuationIndenter::nextIsMultilineString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 1235,
   FQN="clang::format::ContinuationIndenter::nextIsMultilineString", NM="_ZN5clang6format20ContinuationIndenter21nextIsMultilineStringERKNS0_9LineStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format20ContinuationIndenter21nextIsMultilineStringERKNS0_9LineStateE")
  //</editor-fold>
  private boolean nextIsMultilineString(final /*const*/ LineState /*&*/ State) {
    final /*const*/ FormatToken /*&*/ Current = /*Deref*/State.NextToken;
    if (!Current.isStringLiteral() || Current.is_TokenType(TokenType.TT_ImplicitStringLiteral)) {
      return false;
    }
    // We never consider raw string literals "multiline" for the purpose of
    // AlwaysBreakBeforeMultilineStrings implementation as they are special-cased
    // (see TokenAnnotator::mustBreakBefore().
    if (Current.TokenText.startswith(/*STRINGREF_STR*/"R\"")) {
      return false;
    }
    if (Current.IsMultiline) {
      return true;
    }
    if ((Current.getNextNonComment() != null)
       && Current.getNextNonComment().isStringLiteral()) {
      return true; // Implicit concatenation.
    }
    if (Style.ColumnLimit != 0
       && $greater_uint(State.Column + Current.ColumnWidth + Current.UnbreakableTailLength
      , Style.ColumnLimit)) {
      return true; // String will be split.
    }
    return false;
  }

  
  private FormatStyle Style;
  private final /*const*/ AdditionalKeywords /*&*/ Keywords;
  private final /*const*/ SourceManager /*&*/ SourceMgr;
  private final WhitespaceManager /*&*/ Whitespaces;
  private /*enum_conversion.properties: ADD FQN MAPPING FOR ENUM[encoding::Encoding] using FQN clang::format::encoding::Encoding*/Encoding Encoding;
  private boolean BinPackInconclusiveFunctions;
  private Regex CommentPragmasRegex;
  //<editor-fold defaultstate="collapsed" desc="clang::format::ContinuationIndenter::~ContinuationIndenter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.h", line = 35,
   FQN="clang::format::ContinuationIndenter::~ContinuationIndenter", NM="_ZN5clang6format20ContinuationIndenterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format20ContinuationIndenterD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    CommentPragmasRegex.$destroy();
    Style.$destroy();
    //END JDestroy
  }


  
  @Override public String toString() {
    return "" + "Style=" + Style // NOI18N
              + ", Keywords=" + Keywords // NOI18N
              + ", SourceMgr=" + "[SourceManager]" // NOI18N
              + ", Whitespaces=" + "[WhitespaceManager]" // NOI18N
              + ", Encoding=" + Encoding // NOI18N
              + ", BinPackInconclusiveFunctions=" + BinPackInconclusiveFunctions // NOI18N
              + ", CommentPragmasRegex=" + CommentPragmasRegex; // NOI18N
  }
}
