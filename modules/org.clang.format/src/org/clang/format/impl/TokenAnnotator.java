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
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.format.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.format.impl.FormatStatics.*;


/// \brief Determines extra information about the tokens comprising an
/// \c UnwrappedLine.
//<editor-fold defaultstate="collapsed" desc="clang::format::TokenAnnotator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.h", line = 137,
 FQN="clang::format::TokenAnnotator", NM="_ZN5clang6format14TokenAnnotatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format14TokenAnnotatorE")
//</editor-fold>
public class TokenAnnotator {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::TokenAnnotator::TokenAnnotator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.h", line = 139,
   FQN="clang::format::TokenAnnotator::TokenAnnotator", NM="_ZN5clang6format14TokenAnnotatorC1ERKNS0_11FormatStyleERKNS0_18AdditionalKeywordsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format14TokenAnnotatorC1ERKNS0_11FormatStyleERKNS0_18AdditionalKeywordsE")
  //</editor-fold>
  public TokenAnnotator(final /*const*/ FormatStyle /*&*/ Style, final /*const*/ AdditionalKeywords /*&*/ Keywords) {
    // : Style(Style), Keywords(Keywords) 
    //START JInit
    this./*&*/Style=/*&*/Style;
    this./*&*/Keywords=/*&*/Keywords;
    //END JInit
  }

  
  /// \brief Adapts the indent levels of comment lines to the indent of the
  /// subsequent line.
  // FIXME: Can/should this be done in the UnwrappedLineParser?
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::format::TokenAnnotator::setCommentLineLevels">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1547,
   FQN="clang::format::TokenAnnotator::setCommentLineLevels", NM="_ZN5clang6format14TokenAnnotator20setCommentLineLevelsERN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format14TokenAnnotator20setCommentLineLevelsERN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEE")
  //</editor-fold>
  public void setCommentLineLevels(final SmallVectorImpl<AnnotatedLine /*P*/ > /*&*/ Lines) {
    /*const*/ AnnotatedLine /*P*/ NextNonCommentLine = null;
    for (std.reverse_iterator<AnnotatedLine /*P*/ > I = Lines.rbegin(), 
        E = Lines.rend();
         $noteq_reverse_iterator$C(I, E); I.$preInc()) {
      if ((NextNonCommentLine != null) && (I.$star()).First.is_TokenKind(tok.TokenKind.comment)
         && (I.$star()).First.Next == null) {
        (I.$star()).Level = NextNonCommentLine.Level;
      } else {
        NextNonCommentLine = (I.$star()).First.isNot(tok.TokenKind.r_brace) ? (I.$star()) : null;
      }
      
      setCommentLineLevels((I.$star()).Children);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::TokenAnnotator::annotate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1563,
   FQN="clang::format::TokenAnnotator::annotate", NM="_ZN5clang6format14TokenAnnotator8annotateERNS0_13AnnotatedLineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format14TokenAnnotator8annotateERNS0_13AnnotatedLineE")
  //</editor-fold>
  public void annotate(final AnnotatedLine /*&*/ Line) {
    AnnotatingParser Parser = null;
    try {
      for (type$ptr<AnnotatedLine /*P*/ /*P*/> I = $tryClone(Line.Children.begin()), 
          /*P*/ E = $tryClone(Line.Children.end());
           $noteq_ptr(I, E); I.$preInc()) {
        annotate(/*Deref*/I.$star());
      }
      Parser/*J*/= new AnnotatingParser(Style, Line, Keywords);
      Line.Type = Parser.parseLine();
      if (Line.Type == LineType.LT_Invalid) {
        return;
      }
      
      ExpressionParser ExprParser/*J*/= new ExpressionParser(Style, Keywords, Line);
      ExprParser.parse();
      if (Line.startsWith(TokenType.TT_ObjCMethodSpecifier)) {
        Line.Type = LineType.LT_ObjCMethodDecl;
      } else if (Line.startsWith(TokenType.TT_ObjCDecl)) {
        Line.Type = LineType.LT_ObjCDecl;
      } else if (Line.startsWith(TokenType.TT_ObjCProperty)) {
        Line.Type = LineType.LT_ObjCProperty;
      }
      
      Line.First.SpacesRequiredBefore = 1;
      Line.First.CanBreakBefore = Line.First.MustBreakBefore;
    } finally {
      if (Parser != null) { Parser.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::TokenAnnotator::calculateFormattingInformation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1688,
   FQN="clang::format::TokenAnnotator::calculateFormattingInformation", NM="_ZN5clang6format14TokenAnnotator30calculateFormattingInformationERNS0_13AnnotatedLineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format14TokenAnnotator30calculateFormattingInformationERNS0_13AnnotatedLineE")
  //</editor-fold>
  public void calculateFormattingInformation(final AnnotatedLine /*&*/ Line) {
    for (type$ptr<AnnotatedLine /*P*/ /*P*/> I = $tryClone(Line.Children.begin()), 
        /*P*/ E = $tryClone(Line.Children.end());
         $noteq_ptr(I, E); I.$preInc()) {
      calculateFormattingInformation(/*Deref*/I.$star());
    }
    
    Line.First.TotalLength
       = Line.First.IsMultiline ? Style.ColumnLimit : Line.First.ColumnWidth;
    if (!(Line.First.Next != null)) {
      return;
    }
    FormatToken /*P*/ Current = Line.First.Next;
    boolean InFunctionDecl = Line.MightBeFunctionDecl;
    while ((Current != null)) {
      if (isFunctionDeclarationName(/*Deref*/Current, Line)) {
        Current.Type = TokenType.TT_FunctionDeclarationName;
      }
      if (Current.is_TokenType(TokenType.TT_LineComment)) {
        if (Current.Previous.BlockKind == BraceBlockKind.BK_BracedInit
           && Current.Previous.opensScope()) {
          Current.SpacesRequiredBefore = Style.Cpp11BracedListStyle ? 0 : 1;
        } else {
          Current.SpacesRequiredBefore = Style.SpacesBeforeTrailingComments;
        }
        
        // If we find a trailing comment, iterate backwards to determine whether
        // it seems to relate to a specific parameter. If so, break before that
        // parameter to avoid changing the comment's meaning. E.g. don't move 'b'
        // to the previous line in:
        //   SomeFunction(a,
        //                b, // comment
        //                c);
        if (!Current.HasUnescapedNewline) {
          for (FormatToken /*P*/ Parameter = Current.Previous; (Parameter != null);
               Parameter = Parameter.Previous) {
            if (Parameter.isOneOf(tok.TokenKind.comment, tok.TokenKind.r_brace)) {
              break;
            }
            if ((Parameter.Previous != null) && Parameter.Previous.is_TokenKind(tok.TokenKind.comma)) {
              if (!Parameter.Previous.is_TokenType(TokenType.TT_CtorInitializerComma)
                 && Parameter.HasUnescapedNewline) {
                Parameter.MustBreakBefore = true;
              }
              break;
            }
          }
        }
      } else if (Current.SpacesRequiredBefore == 0
         && spaceRequiredBefore(Line, /*Deref*/Current)) {
        Current.SpacesRequiredBefore = 1;
      }
      
      Current.MustBreakBefore
         = Current.MustBreakBefore || mustBreakBefore(Line, /*Deref*/Current);
      if (!Current.MustBreakBefore && InFunctionDecl
         && Current.is_TokenType(TokenType.TT_FunctionDeclarationName)) {
        Current.MustBreakBefore = mustBreakForReturnType(Line);
      }
      
      Current.CanBreakBefore
         = Current.MustBreakBefore || canBreakBefore(Line, /*Deref*/Current);
      /*uint*/int ChildSize = 0;
      if (Current.Previous.Children.size() == 1) {
        final FormatToken /*&*/ LastOfChild = /*Deref*/Current.Previous.Children.$at(0).Last;
        ChildSize = LastOfChild.isTrailingComment() ? Style.ColumnLimit : LastOfChild.TotalLength + 1;
      }
      /*const*/ FormatToken /*P*/ Prev = Current.Previous;
      if (Current.MustBreakBefore || $greater_uint(Prev.Children.size(), 1)
         || (Prev.Children.size() == 1
         && Prev.Children.$at$Const(0).First.MustBreakBefore)
         || Current.IsMultiline) {
        Current.TotalLength = Prev.TotalLength + Style.ColumnLimit;
      } else {
        Current.TotalLength = Prev.TotalLength + Current.ColumnWidth
           + ChildSize + Current.SpacesRequiredBefore;
      }
      if (Current.is_TokenType(TokenType.TT_CtorInitializerColon)) {
        InFunctionDecl = false;
      }
      
      // FIXME: Only calculate this if CanBreakBefore is true once static
      // initializers etc. are sorted out.
      // FIXME: Move magic numbers to a better place.
      Current.SplitPenalty = 20 * Current.BindingStrength
         + splitPenalty(Line, /*Deref*/Current, InFunctionDecl);
      
      Current = Current.Next;
    }
    
    calculateUnbreakableTailLengths(Line);
    for (Current = Line.First; Current != null; Current = Current.Next) {
      if (Current.Role.$bool()) {
        Current.Role.$arrow().precomputeFormattingInfos(Current);
      }
    }
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"format-token-annotator")) {
        {
          printDebugInfo(Line);
        }
        ;
      }
    } while (false);
  }

/*private:*/
  /// \brief Calculate the penalty for splitting before \c Tok.
  //<editor-fold defaultstate="collapsed" desc="clang::format::TokenAnnotator::splitPenalty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1798,
   FQN="clang::format::TokenAnnotator::splitPenalty", NM="_ZN5clang6format14TokenAnnotator12splitPenaltyERKNS0_13AnnotatedLineERKNS0_11FormatTokenEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format14TokenAnnotator12splitPenaltyERKNS0_13AnnotatedLineERKNS0_11FormatTokenEb")
  //</editor-fold>
  private /*uint*/int splitPenalty(final /*const*/ AnnotatedLine /*&*/ Line, 
              final /*const*/ FormatToken /*&*/ Tok, 
              boolean InFunctionDecl) {
    final /*const*/ FormatToken /*&*/ Left = /*Deref*/Tok.Previous;
    final /*const*/ FormatToken /*&*/ Right = Tok;
    if (Left.is_TokenKind(tok.TokenKind.semi)) {
      return 0;
    }
    if (Style.Language == FormatStyle.LanguageKind.LK_Java) {
      if (Right.isOneOf(Keywords.kw_extends, Keywords.kw_throws)) {
        return 1;
      }
      if (Right.is(Keywords.kw_implements)) {
        return 2;
      }
      if (Left.is_TokenKind(tok.TokenKind.comma) && Left.NestingLevel == 0) {
        return 3;
      }
    } else if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript) {
      if (Right.is(Keywords.kw_function) && Left.isNot(tok.TokenKind.comma)) {
        return 100;
      }
      if (Left.is_TokenType(TokenType.TT_JsTypeColon)) {
        return 35;
      }
    }
    if (Left.is_TokenKind(tok.TokenKind.comma) || (Right.is_TokenKind(tok.TokenKind.identifier) && (Right.Next != null)
       && Right.Next.is_TokenType(TokenType.TT_DictLiteral))) {
      return 1;
    }
    if (Right.is_TokenKind(tok.TokenKind.l_square)) {
      if (Style.Language == FormatStyle.LanguageKind.LK_Proto) {
        return 1;
      }
      if (Left.is_TokenKind(tok.TokenKind.r_square)) {
        return 200;
      }
      // Slightly prefer formatting local lambda definitions like functions.
      if (Right.is_TokenType(TokenType.TT_LambdaLSquare) && Left.is_TokenKind(tok.TokenKind.equal)) {
        return 35;
      }
      if (!Right.isOneOf(TokenType.TT_ObjCMethodExpr, TokenType.TT_LambdaLSquare, 
          TokenType.TT_ArrayInitializerLSquare)) {
        return 500;
      }
    }
    if (Right.isOneOf(TokenType.TT_StartOfName, TokenType.TT_FunctionDeclarationName)
       || Right.is_TokenKind(tok.TokenKind.kw_operator)) {
      if (Line.startsWith(tok.TokenKind.kw_for) && Right.PartOfMultiVariableDeclStmt) {
        return 3;
      }
      if (Left.is_TokenType(TokenType.TT_StartOfName)) {
        return 110;
      }
      if (InFunctionDecl && Right.NestingLevel == 0) {
        return Style.PenaltyReturnTypeOnItsOwnLine;
      }
      return 200;
    }
    if (Right.is_TokenType(TokenType.TT_PointerOrReference)) {
      return 190;
    }
    if (Right.is_TokenType(TokenType.TT_LambdaArrow)) {
      return 110;
    }
    if (Left.is_TokenKind(tok.TokenKind.equal) && Right.is_TokenKind(tok.TokenKind.l_brace)) {
      return 150;
    }
    if (Left.is_TokenType(TokenType.TT_CastRParen)) {
      return 100;
    }
    if (Left.is_TokenKind(tok.TokenKind.coloncolon)
       || (Right.is_TokenKind(tok.TokenKind.period) && Style.Language == FormatStyle.LanguageKind.LK_Proto)) {
      return 500;
    }
    if (Left.isOneOf(tok.TokenKind.kw_class, tok.TokenKind.kw_struct)) {
      return 5000;
    }
    if (Left.is_TokenKind(tok.TokenKind.comment)) {
      return 1000;
    }
    if (Left.isOneOf(TokenType.TT_RangeBasedForLoopColon, TokenType.TT_InheritanceColon)) {
      return 2;
    }
    if (Right.isMemberAccess()) {
      // Breaking before the "./->" of a chained call/member access is reasonably
      // cheap, as formatting those with one call per line is generally
      // desirable. In particular, it should be cheaper to break before the call
      // than it is to break inside a call's parameters, which could lead to weird
      // "hanging" indents. The exception is the very last "./->" to support this
      // frequent pattern:
      //
      //   aaaaaaaa.aaaaaaaa.bbbbbbb().ccccccccccccccccccccc(
      //       dddddddd);
      //
      // which might otherwise be blown up onto many lines. Here, clang-format
      // won't produce "hanging" indents anyway as there is no other trailing
      // call.
      //
      // Also apply higher penalty is not a call as that might lead to a wrapping
      // like:
      //
      //   aaaaaaa
      //       .aaaaaaaaa.bbbbbbbb(cccccccc);
      return !(Right.NextOperator != null) || !Right.NextOperator.Previous.closesScope() ? 150 : 35;
    }
    if (Right.is_TokenType(TokenType.TT_TrailingAnnotation)
       && (!(Right.Next != null) || Right.Next.isNot(tok.TokenKind.l_paren))) {
      // Moving trailing annotations to the next line is fine for ObjC method
      // declarations.
      if (Line.startsWith(TokenType.TT_ObjCMethodSpecifier)) {
        return 10;
      }
      // Generally, breaking before a trailing annotation is bad unless it is
      // function-like. It seems to be especially preferable to keep standard
      // annotations (i.e. "const", "final" and "override") on the same line.
      // Use a slightly higher penalty after ")" so that annotations like
      // "const override" are kept together.
      boolean is_short_annotation = $less_uint(Right.TokenText.size(), 10);
      return (Left.is_TokenKind(tok.TokenKind.r_paren) ? 100 : 120) + (is_short_annotation ? 50 : 0);
    }
    
    // In for-loops, prefer breaking at ',' and ';'.
    if (Line.startsWith(tok.TokenKind.kw_for) && Left.is_TokenKind(tok.TokenKind.equal)) {
      return 4;
    }
    
    // In Objective-C method expressions, prefer breaking before "param:" over
    // breaking after it.
    if (Right.is_TokenType(TokenType.TT_SelectorName)) {
      return 0;
    }
    if (Left.is_TokenKind(tok.TokenKind.colon) && Left.is_TokenType(TokenType.TT_ObjCMethodExpr)) {
      return Line.MightBeFunctionDecl ? 50 : 500;
    }
    if (Left.is_TokenKind(tok.TokenKind.l_paren) && InFunctionDecl
       && Style.AlignAfterOpenBracket != FormatStyle.BracketAlignmentStyle.BAS_DontAlign) {
      return 100;
    }
    if (Left.is_TokenKind(tok.TokenKind.l_paren) && (Left.Previous != null)
       && Left.Previous.isOneOf(tok.TokenKind.kw_if, tok.TokenKind.kw_for)) {
      return 1000;
    }
    if (Left.is_TokenKind(tok.TokenKind.equal) && InFunctionDecl) {
      return 110;
    }
    if (Right.is_TokenKind(tok.TokenKind.r_brace)) {
      return 1;
    }
    if (Left.is_TokenType(TokenType.TT_TemplateOpener)) {
      return 100;
    }
    if (Left.opensScope()) {
      if (Style.AlignAfterOpenBracket == FormatStyle.BracketAlignmentStyle.BAS_DontAlign) {
        return 0;
      }
      return $greater_uint(Left.ParameterCount, 1) ? Style.PenaltyBreakBeforeFirstCallParameter : 19;
    }
    if (Left.is_TokenType(TokenType.TT_JavaAnnotation)) {
      return 50;
    }
    if (Right.is_TokenKind(tok.TokenKind.lessless)) {
      if (Left.is_TokenKind(tok.TokenKind.string_literal)
         && ((Right.NextOperator != null) || Right.OperatorIndex != 1)) {
        StringRef Content = new StringRef(Left.TokenText);
        if (Content.startswith(/*STRINGREF_STR*/"\"")) {
          Content.$assignMove(Content.drop_front(1));
        }
        if (Content.endswith(/*STRINGREF_STR*/"\"")) {
          Content.$assignMove(Content.drop_back(1));
        }
        Content.$assignMove(Content.trim());
        if ($greater_uint(Content.size(), 1)
           && (Content.back() == $$COLON || Content.back() == $$EQ)) {
          return 25;
        }
      }
      return 1; // Breaking at a << is really cheap.
    }
    if (Left.is_TokenType(TokenType.TT_ConditionalExpr)) {
      return prec.Level.Conditional.getValue();
    }
    prec.Level Level = Left.getPrecedence();
    if (Level != prec.Level.Unknown) {
      return Level.getValue();
    }
    Level = Right.getPrecedence();
    if (Level != prec.Level.Unknown) {
      return Level.getValue();
    }
    
    return 3;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::TokenAnnotator::spaceRequiredBetween">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1965,
   FQN="clang::format::TokenAnnotator::spaceRequiredBetween", NM="_ZN5clang6format14TokenAnnotator20spaceRequiredBetweenERKNS0_13AnnotatedLineERKNS0_11FormatTokenES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format14TokenAnnotator20spaceRequiredBetweenERKNS0_13AnnotatedLineERKNS0_11FormatTokenES7_")
  //</editor-fold>
  private boolean spaceRequiredBetween(final /*const*/ AnnotatedLine /*&*/ Line, 
                      final /*const*/ FormatToken /*&*/ Left, 
                      final /*const*/ FormatToken /*&*/ Right) {
    if (Left.is_TokenKind(tok.TokenKind.kw_return) && Right.isNot(tok.TokenKind.semi)) {
      return true;
    }
    if (Style.ObjCSpaceAfterProperty && Line.Type == LineType.LT_ObjCProperty
       && Left.Tok.getObjCKeywordID() == tok.ObjCKeywordKind.objc_property) {
      return true;
    }
    if (Right.is_TokenKind(tok.TokenKind.hashhash)) {
      return Left.is_TokenKind(tok.TokenKind.hash);
    }
    if (Left.isOneOf(tok.TokenKind.hashhash, tok.TokenKind.hash)) {
      return Right.is_TokenKind(tok.TokenKind.hash);
    }
    if (Left.is_TokenKind(tok.TokenKind.l_paren) && Right.is_TokenKind(tok.TokenKind.r_paren)) {
      return Style.SpaceInEmptyParentheses;
    }
    if (Left.is_TokenKind(tok.TokenKind.l_paren) || Right.is_TokenKind(tok.TokenKind.r_paren)) {
      return (Right.is_TokenType(TokenType.TT_CastRParen)
         || ((Left.MatchingParen != null) && Left.MatchingParen.is_TokenType(TokenType.TT_CastRParen))) ? Style.SpacesInCStyleCastParentheses : Style.SpacesInParentheses;
    }
    if (Right.isOneOf(tok.TokenKind.semi, tok.TokenKind.comma)) {
      return false;
    }
    if (Right.is_TokenKind(tok.TokenKind.less)
       && (Left.is_TokenKind(tok.TokenKind.kw_template)
       || (Line.Type == LineType.LT_ObjCDecl && Style.ObjCSpaceBeforeProtocolList))) {
      return true;
    }
    if (Left.isOneOf(tok.TokenKind.exclaim, tok.TokenKind.tilde)) {
      return false;
    }
    if (Left.is_TokenKind(tok.TokenKind.at)
       && Right.isOneOf(tok.TokenKind.identifier, tok.TokenKind.string_literal, tok.TokenKind.char_constant, 
        tok.TokenKind.numeric_constant, tok.TokenKind.l_paren, tok.TokenKind.l_brace, 
        tok.TokenKind.kw_true, tok.TokenKind.kw_false)) {
      return false;
    }
    if (Left.is_TokenKind(tok.TokenKind.colon)) {
      return !Left.is_TokenType(TokenType.TT_ObjCMethodExpr);
    }
    if (Left.is_TokenKind(tok.TokenKind.coloncolon)) {
      return false;
    }
    if (Left.is_TokenKind(tok.TokenKind.less) || Right.isOneOf(tok.TokenKind.greater, tok.TokenKind.less)) {
      return false;
    }
    if (Right.is_TokenKind(tok.TokenKind.ellipsis)) {
      return Left.Tok.isLiteral() || (Left.is_TokenKind(tok.TokenKind.identifier) && (Left.Previous != null)
         && Left.Previous.is_TokenKind(tok.TokenKind.kw_case));
    }
    if (Left.is_TokenKind(tok.TokenKind.l_square) && Right.is_TokenKind(tok.TokenKind.amp)) {
      return false;
    }
    if (Right.is_TokenType(TokenType.TT_PointerOrReference)) {
      return (Left.is_TokenKind(tok.TokenKind.r_paren) && Line.MightBeFunctionDecl)
         || (Left.Tok.isLiteral() || (Left.is_TokenKind(tok.TokenKind.kw_const) && (Left.Previous != null)
         && Left.Previous.is_TokenKind(tok.TokenKind.r_paren))
         || (!Left.isOneOf(TokenType.TT_PointerOrReference, tok.TokenKind.l_paren)
         && (Style.PointerAlignment != FormatStyle.PointerAlignmentStyle.PAS_Left
         || Line.IsMultiVariableDeclStmt)));
    }
    if (Right.is_TokenType(TokenType.TT_FunctionTypeLParen) && Left.isNot(tok.TokenKind.l_paren)
       && (!Left.is_TokenType(TokenType.TT_PointerOrReference)
       || (Style.PointerAlignment != FormatStyle.PointerAlignmentStyle.PAS_Right
       && !Line.IsMultiVariableDeclStmt))) {
      return true;
    }
    if (Left.is_TokenType(TokenType.TT_PointerOrReference)) {
      return Right.Tok.isLiteral()
         || Right.isOneOf(TokenType.TT_BlockComment, Keywords.kw_final, 
          Keywords.kw_override)
         || (Right.is_TokenKind(tok.TokenKind.l_brace) && Right.BlockKind == BraceBlockKind.BK_Block)
         || (!Right.isOneOf(TokenType.TT_PointerOrReference, TokenType.TT_ArraySubscriptLSquare, 
          tok.TokenKind.l_paren)
         && (Style.PointerAlignment != FormatStyle.PointerAlignmentStyle.PAS_Right
         && !Line.IsMultiVariableDeclStmt)
         && (Left.Previous != null)
         && !Left.Previous.isOneOf(tok.TokenKind.l_paren, tok.TokenKind.coloncolon));
    }
    if (Right.is_TokenKind(tok.TokenKind.star) && Left.is_TokenKind(tok.TokenKind.l_paren)) {
      return false;
    }
    if (Left.is_TokenKind(tok.TokenKind.l_square)) {
      return (Left.is_TokenType(TokenType.TT_ArrayInitializerLSquare)
         && Style.SpacesInContainerLiterals && Right.isNot(tok.TokenKind.r_square))
         || (Left.is_TokenType(TokenType.TT_ArraySubscriptLSquare) && Style.SpacesInSquareBrackets
         && Right.isNot(tok.TokenKind.r_square));
    }
    if (Right.is_TokenKind(tok.TokenKind.r_square)) {
      return (Right.MatchingParen != null)
         && ((Style.SpacesInContainerLiterals
         && Right.MatchingParen.is_TokenType(TokenType.TT_ArrayInitializerLSquare))
         || (Style.SpacesInSquareBrackets
         && Right.MatchingParen.is_TokenType(TokenType.TT_ArraySubscriptLSquare)));
    }
    if (Right.is_TokenKind(tok.TokenKind.l_square)
       && !Right.isOneOf(TokenType.TT_ObjCMethodExpr, TokenType.TT_LambdaLSquare)
       && !Left.isOneOf(tok.TokenKind.numeric_constant, TokenType.TT_DictLiteral)) {
      return false;
    }
    if (Left.is_TokenKind(tok.TokenKind.l_brace) && Right.is_TokenKind(tok.TokenKind.r_brace)) {
      return !Left.Children.empty(); // No spaces in "{}".
    }
    if ((Left.is_TokenKind(tok.TokenKind.l_brace) && Left.BlockKind != BraceBlockKind.BK_Block)
       || (Right.is_TokenKind(tok.TokenKind.r_brace) && (Right.MatchingParen != null)
       && Right.MatchingParen.BlockKind != BraceBlockKind.BK_Block)) {
      return !Style.Cpp11BracedListStyle;
    }
    if (Left.is_TokenType(TokenType.TT_BlockComment)) {
      return !Left.TokenText.endswith(/*STRINGREF_STR*/"=*/");
    }
    if (Right.is_TokenKind(tok.TokenKind.l_paren)) {
      if (Left.is_TokenKind(tok.TokenKind.r_paren) && Left.is_TokenType(TokenType.TT_AttributeParen)) {
        return true;
      }
      return Line.Type == LineType.LT_ObjCDecl || Left.is_TokenKind(tok.TokenKind.semi)
         || (Style.SpaceBeforeParens != FormatStyle.SpaceBeforeParensOptions.SBPO_Never
         && (Left.isOneOf(tok.TokenKind.kw_if, tok.PPKeywordKind.pp_elif, tok.TokenKind.kw_for, tok.TokenKind.kw_while, 
          tok.TokenKind.kw_switch, tok.TokenKind.kw_case, TokenType.TT_ForEachMacro, 
          TokenType.TT_ObjCForIn)
         || (Left.isOneOf(tok.TokenKind.kw_try, Keywords.kw___except, tok.TokenKind.kw_catch, 
          tok.TokenKind.kw_new, tok.TokenKind.kw_delete)
         && (!(Left.Previous != null) || Left.Previous.isNot(tok.TokenKind.period)))))
         || (Style.SpaceBeforeParens == FormatStyle.SpaceBeforeParensOptions.SBPO_Always
         && (Left.is_TokenKind(tok.TokenKind.identifier) || Left.isFunctionLikeKeyword()
         || Left.is_TokenKind(tok.TokenKind.r_paren))
         && Line.Type != LineType.LT_PreprocessorDirective);
    }
    if (Left.is_TokenKind(tok.TokenKind.at) && Right.Tok.getObjCKeywordID() != tok.ObjCKeywordKind.objc_not_keyword) {
      return false;
    }
    if (Right.is_TokenType(TokenType.TT_UnaryOperator)) {
      return !Left.isOneOf(tok.TokenKind.l_paren, tok.TokenKind.l_square, tok.TokenKind.at)
         && (Left.isNot(tok.TokenKind.colon) || Left.isNot(TokenType.TT_ObjCMethodExpr));
    }
    if ((Left.isOneOf(tok.TokenKind.identifier, tok.TokenKind.greater, tok.TokenKind.r_square, 
        tok.TokenKind.r_paren)
       || Left.isSimpleTypeSpecifier())
       && Right.is_TokenKind(tok.TokenKind.l_brace) && (Right.getNextNonComment() != null)
       && Right.BlockKind != BraceBlockKind.BK_Block) {
      return false;
    }
    if (Left.is_TokenKind(tok.TokenKind.period) || Right.is_TokenKind(tok.TokenKind.period)) {
      return false;
    }
    if (Right.is_TokenKind(tok.TokenKind.hash) && Left.is_TokenKind(tok.TokenKind.identifier) && $eq_StringRef(/*NO_COPY*/Left.TokenText, /*STRINGREF_STR*/"L")) {
      return false;
    }
    if (Left.is_TokenType(TokenType.TT_TemplateCloser) && (Left.MatchingParen != null)
       && (Left.MatchingParen.Previous != null)
       && Left.MatchingParen.Previous.is_TokenKind(tok.TokenKind.period)) {
      // A.<B>DoSomething();
      return false;
    }
    if (Left.is_TokenType(TokenType.TT_TemplateCloser) && Right.is_TokenKind(tok.TokenKind.l_square)) {
      return false;
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::TokenAnnotator::spaceRequiredBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 2097,
   FQN="clang::format::TokenAnnotator::spaceRequiredBefore", NM="_ZN5clang6format14TokenAnnotator19spaceRequiredBeforeERKNS0_13AnnotatedLineERKNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format14TokenAnnotator19spaceRequiredBeforeERKNS0_13AnnotatedLineERKNS0_11FormatTokenE")
  //</editor-fold>
  private boolean spaceRequiredBefore(final /*const*/ AnnotatedLine /*&*/ Line, 
                     final /*const*/ FormatToken /*&*/ Right) {
    final /*const*/ FormatToken /*&*/ Left = /*Deref*/Right.Previous;
    if ((Right.Tok.getIdentifierInfo() != null) && (Left.Tok.getIdentifierInfo() != null)) {
      return true; // Never ever merge two identifiers.
    }
    if (Style.Language == FormatStyle.LanguageKind.LK_Cpp) {
      if (Left.is_TokenKind(tok.TokenKind.kw_operator)) {
        return Right.is_TokenKind(tok.TokenKind.coloncolon);
      }
    } else if (Style.Language == FormatStyle.LanguageKind.LK_Proto) {
      if (Right.is_TokenKind(tok.TokenKind.period)
         && Left.isOneOf(Keywords.kw_optional, Keywords.kw_required, 
          Keywords.kw_repeated, Keywords.kw_extend)) {
        return true;
      }
      if (Right.is_TokenKind(tok.TokenKind.l_paren)
         && Left.isOneOf(Keywords.kw_returns, Keywords.kw_option)) {
        return true;
      }
    } else if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript) {
      if (Left.is_TokenType(TokenType.TT_JsFatArrow)) {
        return true;
      }
      if (Right.is_TokenKind(tok.TokenKind.star)
         && Left.isOneOf(Keywords.kw_function, Keywords.kw_yield)) {
        return false;
      }
      if (Left.isOneOf(Keywords.kw_let, Keywords.kw_var, Keywords.kw_in, 
          Keywords.kw_of, tok.TokenKind.kw_const)
         && (!(Left.Previous != null) || !Left.Previous.is_TokenKind(tok.TokenKind.period))) {
        return true;
      }
      if (Left.is_TokenKind(tok.TokenKind.kw_default) && (Left.Previous != null)
         && Left.Previous.is_TokenKind(tok.TokenKind.kw_export)) {
        return true;
      }
      if (Left.is(Keywords.kw_is) && Right.is_TokenKind(tok.TokenKind.l_brace)) {
        return true;
      }
      if (Right.isOneOf(TokenType.TT_JsTypeColon, TokenType.TT_JsTypeOptionalQuestion)) {
        return false;
      }
      if (Left.is_TokenType(TokenType.TT_JsTypeOperator) || Right.is_TokenType(TokenType.TT_JsTypeOperator)) {
        return false;
      }
      if ((Left.is_TokenKind(tok.TokenKind.l_brace) || Right.is_TokenKind(tok.TokenKind.r_brace))
         && Line.First.isOneOf(Keywords.kw_import, tok.TokenKind.kw_export)) {
        return false;
      }
      if (Left.is_TokenKind(tok.TokenKind.ellipsis)) {
        return false;
      }
      if (Left.is_TokenType(TokenType.TT_TemplateCloser)
         && !Right.isOneOf(tok.TokenKind.equal, tok.TokenKind.l_brace, tok.TokenKind.comma, tok.TokenKind.l_square, 
          Keywords.kw_implements, Keywords.kw_extends)) {
        // Type assertions ('<type>expr') are not followed by whitespace. Other
        // locations that should have whitespace following are identified by the
        // above set of follower tokens.
        return false;
      }
      // Postfix non-null assertion operator, as in `foo!.bar()`.
      if (Right.is_TokenKind(tok.TokenKind.exclaim) && (Left.isOneOf(tok.TokenKind.identifier, tok.TokenKind.r_paren, 
          tok.TokenKind.r_square, tok.TokenKind.r_brace)
         || Left.Tok.isLiteral())) {
        return false;
      }
    } else if (Style.Language == FormatStyle.LanguageKind.LK_Java) {
      if (Left.is_TokenKind(tok.TokenKind.r_square) && Right.is_TokenKind(tok.TokenKind.l_brace)) {
        return true;
      }
      if (Left.is(Keywords.kw_synchronized) && Right.is_TokenKind(tok.TokenKind.l_paren)) {
        return Style.SpaceBeforeParens != FormatStyle.SpaceBeforeParensOptions.SBPO_Never;
      }
      if ((Left.isOneOf(tok.TokenKind.kw_static, tok.TokenKind.kw_public, tok.TokenKind.kw_private, 
          tok.TokenKind.kw_protected)
         || Left.isOneOf(Keywords.kw_final, Keywords.kw_abstract, 
          Keywords.kw_native))
         && Right.is_TokenType(TokenType.TT_TemplateOpener)) {
        return true;
      }
    }
    if (Left.is_TokenType(TokenType.TT_ImplicitStringLiteral)) {
      return $noteq_SourceLocation$C(Right.WhitespaceRange.getBegin(), Right.WhitespaceRange.getEnd());
    }
    if (Line.Type == LineType.LT_ObjCMethodDecl) {
      if (Left.is_TokenType(TokenType.TT_ObjCMethodSpecifier)) {
        return true;
      }
      if (Left.is_TokenKind(tok.TokenKind.r_paren) && Right.is_TokenKind(tok.TokenKind.identifier)) {
        // Don't space between ')' and <id>
        return false;
      }
    }
    if (Line.Type == LineType.LT_ObjCProperty
       && (Right.is_TokenKind(tok.TokenKind.equal) || Left.is_TokenKind(tok.TokenKind.equal))) {
      return false;
    }
    if (Right.isOneOf(TokenType.TT_TrailingReturnArrow, TokenType.TT_LambdaArrow)
       || Left.isOneOf(TokenType.TT_TrailingReturnArrow, TokenType.TT_LambdaArrow)) {
      return true;
    }
    if (Right.is_TokenType(TokenType.TT_OverloadedOperatorLParen)) {
      return Style.SpaceBeforeParens == FormatStyle.SpaceBeforeParensOptions.SBPO_Always;
    }
    if (Left.is_TokenKind(tok.TokenKind.comma)) {
      return true;
    }
    if (Right.is_TokenKind(tok.TokenKind.comma)) {
      return false;
    }
    if (Right.isOneOf(TokenType.TT_CtorInitializerColon, TokenType.TT_ObjCBlockLParen)) {
      return true;
    }
    if (Right.is_TokenKind(tok.TokenKind.colon)) {
      if (Line.First.isOneOf(tok.TokenKind.kw_case, tok.TokenKind.kw_default)
         || !(Right.getNextNonComment() != null) || Right.getNextNonComment().is_TokenKind(tok.TokenKind.semi)) {
        return false;
      }
      if (Right.is_TokenType(TokenType.TT_ObjCMethodExpr)) {
        return false;
      }
      if (Left.is_TokenKind(tok.TokenKind.question)) {
        return false;
      }
      if (Right.is_TokenType(TokenType.TT_InlineASMColon) && Left.is_TokenKind(tok.TokenKind.coloncolon)) {
        return false;
      }
      if (Right.is_TokenType(TokenType.TT_DictLiteral)) {
        return Style.SpacesInContainerLiterals;
      }
      return true;
    }
    if (Left.is_TokenType(TokenType.TT_UnaryOperator)) {
      return Right.is_TokenType(TokenType.TT_BinaryOperator);
    }
    
    // If the next token is a binary operator or a selector name, we have
    // incorrectly classified the parenthesis as a cast. FIXME: Detect correctly.
    if (Left.is_TokenType(TokenType.TT_CastRParen)) {
      return Style.SpaceAfterCStyleCast
         || Right.isOneOf(TokenType.TT_BinaryOperator, TokenType.TT_SelectorName);
    }
    if (Left.is_TokenKind(tok.TokenKind.greater) && Right.is_TokenKind(tok.TokenKind.greater)) {
      return Right.is_TokenType(TokenType.TT_TemplateCloser) && Left.is_TokenType(TokenType.TT_TemplateCloser)
         && (Style.Standard != FormatStyle.LanguageStandard.LS_Cpp11 || Style.SpacesInAngles);
    }
    if (Right.isOneOf(tok.TokenKind.arrow, tok.TokenKind.period, tok.TokenKind.arrowstar, tok.TokenKind.periodstar)
       || Left.isOneOf(tok.TokenKind.arrow, tok.TokenKind.period, tok.TokenKind.arrowstar, tok.TokenKind.periodstar)) {
      return false;
    }
    if (!Style.SpaceBeforeAssignmentOperators
       && Right.getPrecedence() == prec.Level.Assignment) {
      return false;
    }
    if (Right.is_TokenKind(tok.TokenKind.coloncolon) && !Left.isOneOf(tok.TokenKind.l_brace, tok.TokenKind.comment)) {
      return (Left.is_TokenType(TokenType.TT_TemplateOpener)
         && Style.Standard == FormatStyle.LanguageStandard.LS_Cpp03)
         || !(Left.isOneOf(tok.TokenKind.identifier, tok.TokenKind.l_paren, tok.TokenKind.r_paren, 
          tok.TokenKind.l_square)
         || Left.isOneOf(TokenType.TT_TemplateCloser, TokenType.TT_TemplateOpener));
    }
    if ((Left.is_TokenType(TokenType.TT_TemplateOpener)) != (Right.is_TokenType(TokenType.TT_TemplateCloser))) {
      return Style.SpacesInAngles;
    }
    if ((Right.is_TokenType(TokenType.TT_BinaryOperator) && !Left.is_TokenKind(tok.TokenKind.l_paren))
       || (Left.isOneOf(TokenType.TT_BinaryOperator, TokenType.TT_ConditionalExpr)
       && !Right.is_TokenKind(tok.TokenKind.r_paren))) {
      return true;
    }
    if (Left.is_TokenType(TokenType.TT_TemplateCloser) && Right.is_TokenKind(tok.TokenKind.l_paren)
       && Right.isNot(TokenType.TT_FunctionTypeLParen)) {
      return Style.SpaceBeforeParens == FormatStyle.SpaceBeforeParensOptions.SBPO_Always;
    }
    if (Right.is_TokenType(TokenType.TT_TemplateOpener) && Left.is_TokenKind(tok.TokenKind.r_paren)
       && (Left.MatchingParen != null) && Left.MatchingParen.is_TokenType(TokenType.TT_OverloadedOperatorLParen)) {
      return false;
    }
    if (Right.is_TokenKind(tok.TokenKind.less) && Left.isNot(tok.TokenKind.l_paren)
       && Line.startsWith(tok.TokenKind.hash)) {
      return true;
    }
    if (Right.is_TokenType(TokenType.TT_TrailingUnaryOperator)) {
      return false;
    }
    if (Left.is_TokenType(TokenType.TT_RegexLiteral)) {
      return false;
    }
    return spaceRequiredBetween(Line, Left, Right);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::TokenAnnotator::mustBreakBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 2251,
   FQN="clang::format::TokenAnnotator::mustBreakBefore", NM="_ZN5clang6format14TokenAnnotator15mustBreakBeforeERKNS0_13AnnotatedLineERKNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format14TokenAnnotator15mustBreakBeforeERKNS0_13AnnotatedLineERKNS0_11FormatTokenE")
  //</editor-fold>
  private boolean mustBreakBefore(final /*const*/ AnnotatedLine /*&*/ Line, 
                 final /*const*/ FormatToken /*&*/ Right) {
    final /*const*/ FormatToken /*&*/ Left = /*Deref*/Right.Previous;
    if ($greater_uint(Right.NewlinesBefore, 1) && $greater_uint(Style.MaxEmptyLinesToKeep, 0)) {
      return true;
    }
    if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript) {
      // FIXME: This might apply to other languages and token kinds.
      if (Right.is_TokenKind(tok.TokenKind.string_literal) && Left.is_TokenKind(tok.TokenKind.plus) && (Left.Previous != null)
         && Left.Previous.is_TokenKind(tok.TokenKind.string_literal)) {
        return true;
      }
      if (Left.is_TokenType(TokenType.TT_DictLiteral) && Left.is_TokenKind(tok.TokenKind.l_brace) && Line.Level == 0
         && (Left.Previous != null) && Left.Previous.is_TokenKind(tok.TokenKind.equal)
         && Line.First.isOneOf(tok.TokenKind.identifier, Keywords.kw_import, tok.TokenKind.kw_export, 
          tok.TokenKind.kw_const)
        // kw_var/kw_let are pseudo-tokens that are tok::identifier, so match
        // above.
         && !Line.First.isOneOf(Keywords.kw_var, Keywords.kw_let)) {
        // Object literals on the top level of a file are treated as "enum-style".
        // Each key/value pair is put on a separate line, instead of bin-packing.
        return true;
      }
      if (Left.is_TokenKind(tok.TokenKind.l_brace) && Line.Level == 0
         && (Line.startsWith(tok.TokenKind.kw_enum)
         || Line.startsWith(tok.TokenKind.kw_export, tok.TokenKind.kw_enum))) {
        // JavaScript top-level enum key/value pairs are put on separate lines
        // instead of bin-packing.
        return true;
      }
      if (Right.is_TokenKind(tok.TokenKind.r_brace) && Left.is_TokenKind(tok.TokenKind.l_brace)
         && !Left.Children.empty()) {
        // Support AllowShortFunctionsOnASingleLine for JavaScript.
        return Style.AllowShortFunctionsOnASingleLine == FormatStyle.ShortFunctionStyle.SFS_None
           || Style.AllowShortFunctionsOnASingleLine == FormatStyle.ShortFunctionStyle.SFS_Empty
           || (Left.NestingLevel == 0 && Line.Level == 0
           && Style.AllowShortFunctionsOnASingleLine
           == FormatStyle.ShortFunctionStyle.SFS_Inline);
      }
    } else if (Style.Language == FormatStyle.LanguageKind.LK_Java) {
      if (Right.is_TokenKind(tok.TokenKind.plus) && Left.is_TokenKind(tok.TokenKind.string_literal) && (Right.Next != null)
         && Right.Next.is_TokenKind(tok.TokenKind.string_literal)) {
        return true;
      }
    }
    
    // If the last token before a '}' is a comma or a trailing comment, the
    // intention is to insert a line break after it in order to make shuffling
    // around entries easier.
    /*const*/ FormatToken /*P*/ BeforeClosingBrace = null;
    if (Left.isOneOf(tok.TokenKind.l_brace, TokenType.TT_ArrayInitializerLSquare)
       && Left.BlockKind != BraceBlockKind.BK_Block && (Left.MatchingParen != null)) {
      BeforeClosingBrace = Left.MatchingParen.Previous;
    } else if ((Right.MatchingParen != null)
       && Right.MatchingParen.isOneOf(tok.TokenKind.l_brace, 
        TokenType.TT_ArrayInitializerLSquare)) {
      BeforeClosingBrace = /*AddrOf*/Left;
    }
    if ((BeforeClosingBrace != null) && (BeforeClosingBrace.is_TokenKind(tok.TokenKind.comma)
       || BeforeClosingBrace.isTrailingComment())) {
      return true;
    }
    if (Right.is_TokenKind(tok.TokenKind.comment)) {
      return Left.BlockKind != BraceBlockKind.BK_BracedInit
         && Left.isNot(TokenType.TT_CtorInitializerColon)
         && ($greater_uint(Right.NewlinesBefore, 0) && Right.HasUnescapedNewline);
    }
    if (Left.isTrailingComment()) {
      return true;
    }
    if (Left.isStringLiteral()
       && (Right.isStringLiteral() || Right.is_TokenType(TokenType.TT_ObjCStringLiteral))) {
      return true;
    }
    if (Right.Previous.IsUnterminatedLiteral) {
      return true;
    }
    if (Right.is_TokenKind(tok.TokenKind.lessless) && (Right.Next != null)
       && Right.Previous.is_TokenKind(tok.TokenKind.string_literal)
       && Right.Next.is_TokenKind(tok.TokenKind.string_literal)) {
      return true;
    }
    if (Right.Previous.ClosesTemplateDeclaration
       && (Right.Previous.MatchingParen != null)
       && Right.Previous.MatchingParen.NestingLevel == 0
       && Style.AlwaysBreakTemplateDeclarations) {
      return true;
    }
    if ((Right.isOneOf(TokenType.TT_CtorInitializerComma, TokenType.TT_CtorInitializerColon))
       && Style.BreakConstructorInitializersBeforeComma
       && !Style.ConstructorInitializerAllOnOneLineOrOnePerLine) {
      return true;
    }
    if (Right.is_TokenKind(tok.TokenKind.string_literal) && Right.TokenText.startswith(/*STRINGREF_STR*/"R\"")) {
      // Raw string literals are special wrt. line breaks. The author has made a
      // deliberate choice and might have aligned the contents of the string
      // literal accordingly. Thus, we try keep existing line breaks.
      return $greater_uint(Right.NewlinesBefore, 0);
    }
    if (Right.Previous.is_TokenKind(tok.TokenKind.l_brace) && Right.NestingLevel == 1
       && Style.Language == FormatStyle.LanguageKind.LK_Proto) {
      // Don't put enums onto single lines in protocol buffers.
      return true;
    }
    if (Right.is_TokenType(TokenType.TT_InlineASMBrace)) {
      return Right.HasUnescapedNewline;
    }
    if (isAllmanBrace(Left) || isAllmanBrace(Right)) {
      return (Line.startsWith(tok.TokenKind.kw_enum) && Style.BraceWrapping.AfterEnum)
         || (Line.startsWith(tok.TokenKind.kw_class) && Style.BraceWrapping.AfterClass)
         || (Line.startsWith(tok.TokenKind.kw_struct) && Style.BraceWrapping.AfterStruct);
    }
    if (Left.is_TokenType(TokenType.TT_ObjCBlockLBrace) && !Style.AllowShortBlocksOnASingleLine) {
      return true;
    }
    if ((Style.Language == FormatStyle.LanguageKind.LK_Java
       || Style.Language == FormatStyle.LanguageKind.LK_JavaScript)
       && Left.is_TokenType(TokenType.TT_LeadingJavaAnnotation)
       && Right.isNot(TokenType.TT_LeadingJavaAnnotation) && Right.isNot(tok.TokenKind.l_paren)
       && (Line.Last.is_TokenKind(tok.TokenKind.l_brace) || Style.BreakAfterJavaFieldAnnotations)) {
      return true;
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::TokenAnnotator::canBreakBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 2359,
   FQN="clang::format::TokenAnnotator::canBreakBefore", NM="_ZN5clang6format14TokenAnnotator14canBreakBeforeERKNS0_13AnnotatedLineERKNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format14TokenAnnotator14canBreakBeforeERKNS0_13AnnotatedLineERKNS0_11FormatTokenE")
  //</editor-fold>
  private boolean canBreakBefore(final /*const*/ AnnotatedLine /*&*/ Line, 
                final /*const*/ FormatToken /*&*/ Right) {
    final /*const*/ FormatToken /*&*/ Left = /*Deref*/Right.Previous;
    
    // Language-specific stuff.
    if (Style.Language == FormatStyle.LanguageKind.LK_Java) {
      if (Left.isOneOf(Keywords.kw_throws, Keywords.kw_extends, 
          Keywords.kw_implements)) {
        return false;
      }
      if (Right.isOneOf(Keywords.kw_throws, Keywords.kw_extends, 
          Keywords.kw_implements)) {
        return true;
      }
    } else if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript) {
      if (Left.is_TokenKind(tok.TokenKind.kw_return)) {
        return false; // Otherwise a semicolon is inserted.
      }
      if (Left.is_TokenType(TokenType.TT_JsFatArrow) && Right.is_TokenKind(tok.TokenKind.l_brace)) {
        return false;
      }
      if (Left.is_TokenType(TokenType.TT_JsTypeColon)) {
        return true;
      }
      if (Right.NestingLevel == 0 && Right.is(Keywords.kw_is)) {
        return false;
      }
      if (Left.is(Keywords.kw_in)) {
        return Style.BreakBeforeBinaryOperators == FormatStyle.BinaryOperatorStyle.BOS_None;
      }
      if (Right.is(Keywords.kw_in)) {
        return Style.BreakBeforeBinaryOperators != FormatStyle.BinaryOperatorStyle.BOS_None;
      }
      if (Right.is(Keywords.kw_as)) {
        return false; // must not break before as in 'x as type' casts
      }
    }
    if (Left.is_TokenKind(tok.TokenKind.at)) {
      return false;
    }
    if (Left.Tok.getObjCKeywordID() == tok.ObjCKeywordKind.objc_interface) {
      return false;
    }
    if (Left.isOneOf(TokenType.TT_JavaAnnotation, TokenType.TT_LeadingJavaAnnotation)) {
      return !Right.is_TokenKind(tok.TokenKind.l_paren);
    }
    if (Right.is_TokenType(TokenType.TT_PointerOrReference)) {
      return Line.IsMultiVariableDeclStmt
         || (Style.PointerAlignment == FormatStyle.PointerAlignmentStyle.PAS_Right
         && (!(Right.Next != null) || Right.Next.isNot(TokenType.TT_FunctionDeclarationName)));
    }
    if (Right.isOneOf(TokenType.TT_StartOfName, TokenType.TT_FunctionDeclarationName)
       || Right.is_TokenKind(tok.TokenKind.kw_operator)) {
      return true;
    }
    if (Left.is_TokenType(TokenType.TT_PointerOrReference)) {
      return false;
    }
    if (Right.isTrailingComment()) {
      // We rely on MustBreakBefore being set correctly here as we should not
      // change the "binding" behavior of a comment.
      // The first comment in a braced lists is always interpreted as belonging to
      // the first list element. Otherwise, it should be placed outside of the
      // list.
      return Left.BlockKind == BraceBlockKind.BK_BracedInit;
    }
    if (Left.is_TokenKind(tok.TokenKind.question) && Right.is_TokenKind(tok.TokenKind.colon)) {
      return false;
    }
    if (Right.is_TokenType(TokenType.TT_ConditionalExpr) || Right.is_TokenKind(tok.TokenKind.question)) {
      return Style.BreakBeforeTernaryOperators;
    }
    if (Left.is_TokenType(TokenType.TT_ConditionalExpr) || Left.is_TokenKind(tok.TokenKind.question)) {
      return !Style.BreakBeforeTernaryOperators;
    }
    if (Right.is_TokenType(TokenType.TT_InheritanceColon)) {
      return true;
    }
    if (Right.is_TokenKind(tok.TokenKind.colon)
       && !Right.isOneOf(TokenType.TT_CtorInitializerColon, TokenType.TT_InlineASMColon)) {
      return false;
    }
    if (Left.is_TokenKind(tok.TokenKind.colon) && (Left.isOneOf(TokenType.TT_DictLiteral, TokenType.TT_ObjCMethodExpr))) {
      return true;
    }
    if (Right.is_TokenType(TokenType.TT_SelectorName) || (Right.is_TokenKind(tok.TokenKind.identifier) && (Right.Next != null)
       && Right.Next.is_TokenType(TokenType.TT_ObjCMethodExpr))) {
      return Left.isNot(tok.TokenKind.period); // FIXME: Properly parse ObjC calls.
    }
    if (Left.is_TokenKind(tok.TokenKind.r_paren) && Line.Type == LineType.LT_ObjCProperty) {
      return true;
    }
    if (Left.ClosesTemplateDeclaration || Left.is_TokenType(TokenType.TT_FunctionAnnotationRParen)) {
      return true;
    }
    if (Right.isOneOf(TokenType.TT_RangeBasedForLoopColon, TokenType.TT_OverloadedOperatorLParen, 
        TokenType.TT_OverloadedOperator)) {
      return false;
    }
    if (Left.is_TokenType(TokenType.TT_RangeBasedForLoopColon)) {
      return true;
    }
    if (Right.is_TokenType(TokenType.TT_RangeBasedForLoopColon)) {
      return false;
    }
    if (Left.isOneOf(TokenType.TT_TemplateCloser, TokenType.TT_UnaryOperator)
       || Left.is_TokenKind(tok.TokenKind.kw_operator)) {
      return false;
    }
    if (Left.is_TokenKind(tok.TokenKind.equal) && !Right.isOneOf(tok.TokenKind.kw_default, tok.TokenKind.kw_delete)
       && Line.Type == LineType.LT_VirtualFunctionDecl && Left.NestingLevel == 0) {
      return false;
    }
    if (Left.is_TokenKind(tok.TokenKind.l_paren) && Left.is_TokenType(TokenType.TT_AttributeParen)) {
      return false;
    }
    if (Left.is_TokenKind(tok.TokenKind.l_paren) && (Left.Previous != null)
       && (Left.Previous.isOneOf(TokenType.TT_BinaryOperator, TokenType.TT_CastRParen))) {
      return false;
    }
    if (Right.is_TokenType(TokenType.TT_ImplicitStringLiteral)) {
      return false;
    }
    if (Right.is_TokenKind(tok.TokenKind.r_paren) || Right.is_TokenType(TokenType.TT_TemplateCloser)) {
      return false;
    }
    if (Right.is_TokenKind(tok.TokenKind.r_square) && (Right.MatchingParen != null)
       && Right.MatchingParen.is_TokenType(TokenType.TT_LambdaLSquare)) {
      return false;
    }
    
    // We only break before r_brace if there was a corresponding break before
    // the l_brace, which is tracked by BreakBeforeClosingBrace.
    if (Right.is_TokenKind(tok.TokenKind.r_brace)) {
      return (Right.MatchingParen != null) && Right.MatchingParen.BlockKind == BraceBlockKind.BK_Block;
    }
    
    // Allow breaking after a trailing annotation, e.g. after a method
    // declaration.
    if (Left.is_TokenType(TokenType.TT_TrailingAnnotation)) {
      return !Right.isOneOf(tok.TokenKind.l_brace, tok.TokenKind.semi, tok.TokenKind.equal, tok.TokenKind.l_paren, 
          tok.TokenKind.less, tok.TokenKind.coloncolon);
    }
    if (Right.is_TokenKind(tok.TokenKind.kw___attribute)) {
      return true;
    }
    if (Left.is_TokenKind(tok.TokenKind.identifier) && Right.is_TokenKind(tok.TokenKind.string_literal)) {
      return true;
    }
    if (Right.is_TokenKind(tok.TokenKind.identifier) && (Right.Next != null) && Right.Next.is_TokenType(TokenType.TT_DictLiteral)) {
      return true;
    }
    if (Left.is_TokenType(TokenType.TT_CtorInitializerComma)
       && Style.BreakConstructorInitializersBeforeComma) {
      return false;
    }
    if (Right.is_TokenType(TokenType.TT_CtorInitializerComma)
       && Style.BreakConstructorInitializersBeforeComma) {
      return true;
    }
    if ((Left.is_TokenKind(tok.TokenKind.greater) && Right.is_TokenKind(tok.TokenKind.greater))
       || (Left.is_TokenKind(tok.TokenKind.less) && Right.is_TokenKind(tok.TokenKind.less))) {
      return false;
    }
    if (Right.is_TokenType(TokenType.TT_BinaryOperator)
       && Style.BreakBeforeBinaryOperators != FormatStyle.BinaryOperatorStyle.BOS_None
       && (Style.BreakBeforeBinaryOperators == FormatStyle.BinaryOperatorStyle.BOS_All
       || Right.getPrecedence() != prec.Level.Assignment)) {
      return true;
    }
    if (Left.is_TokenType(TokenType.TT_ArrayInitializerLSquare)) {
      return true;
    }
    if (Right.is_TokenKind(tok.TokenKind.kw_typename) && Left.isNot(tok.TokenKind.kw_const)) {
      return true;
    }
    if ((Left.isBinaryOperator() || Left.is_TokenType(TokenType.TT_BinaryOperator))
       && !Left.isOneOf(tok.TokenKind.arrowstar, tok.TokenKind.lessless)
       && Style.BreakBeforeBinaryOperators != FormatStyle.BinaryOperatorStyle.BOS_All
       && (Style.BreakBeforeBinaryOperators == FormatStyle.BinaryOperatorStyle.BOS_None
       || Left.getPrecedence() == prec.Level.Assignment)) {
      return true;
    }
    return Left.isOneOf(tok.TokenKind.comma, tok.TokenKind.coloncolon, tok.TokenKind.semi, tok.TokenKind.l_brace, 
        tok.TokenKind.kw_class, tok.TokenKind.kw_struct, tok.TokenKind.comment)
       || Right.isMemberAccess()
       || Right.isOneOf(TokenType.TT_TrailingReturnArrow, TokenType.TT_LambdaArrow, tok.TokenKind.lessless, 
        tok.TokenKind.colon, tok.TokenKind.l_square, tok.TokenKind.at)
       || (Left.is_TokenKind(tok.TokenKind.r_paren)
       && Right.isOneOf(tok.TokenKind.identifier, tok.TokenKind.kw_const))
       || (Left.is_TokenKind(tok.TokenKind.l_paren) && !Right.is_TokenKind(tok.TokenKind.r_paren));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::TokenAnnotator::mustBreakForReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1665,
   FQN="clang::format::TokenAnnotator::mustBreakForReturnType", NM="_ZNK5clang6format14TokenAnnotator22mustBreakForReturnTypeERKNS0_13AnnotatedLineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format14TokenAnnotator22mustBreakForReturnTypeERKNS0_13AnnotatedLineE")
  //</editor-fold>
  private boolean mustBreakForReturnType(final /*const*/ AnnotatedLine /*&*/ Line) /*const*/ {
    assert (Line.MightBeFunctionDecl);
    if ((Style.AlwaysBreakAfterReturnType == FormatStyle.ReturnTypeBreakingStyle.RTBS_TopLevel
       || Style.AlwaysBreakAfterReturnType
       == FormatStyle.ReturnTypeBreakingStyle.RTBS_TopLevelDefinitions)
       && $greater_uint(Line.Level, 0)) {
      return false;
    }
    switch (Style.AlwaysBreakAfterReturnType) {
     case RTBS_None:
      return false;
     case RTBS_All:
     case RTBS_TopLevel:
      return true;
     case RTBS_AllDefinitions:
     case RTBS_TopLevelDefinitions:
      return Line.mightBeFunctionDefinition();
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::TokenAnnotator::printDebugInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 2511,
   FQN="clang::format::TokenAnnotator::printDebugInfo", NM="_ZN5clang6format14TokenAnnotator14printDebugInfoERKNS0_13AnnotatedLineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format14TokenAnnotator14printDebugInfoERKNS0_13AnnotatedLineE")
  //</editor-fold>
  private void printDebugInfo(final /*const*/ AnnotatedLine /*&*/ Line) {
    llvm.errs().$out(/*KEEP_STR*/"AnnotatedTokens:\n");
    /*const*/ FormatToken /*P*/ Tok = Line.First;
    while ((Tok != null)) {
      llvm.errs().$out(/*KEEP_STR*/" M=").$out_int((Tok.MustBreakBefore ? 1 : 0)).$out(
          /*KEEP_STR*/" C="
      ).$out_int((Tok.CanBreakBefore ? 1 : 0)).$out(
          /*KEEP_STR*/" T="
      ).$out(getTokenTypeName(Tok.Type)).$out(
          /*KEEP_STR*/" S="
      ).$out_uint(Tok.SpacesRequiredBefore).$out(
          /*KEEP_STR*/" B="
      ).$out_uint(Tok.BlockParameterCount).$out(
          /*KEEP_STR*/" P="
      ).$out_uint(Tok.SplitPenalty).$out(/*KEEP_STR*/" Name=").$out(Tok.Tok.getName()).$out(
          /*KEEP_STR*/" L="
      ).$out_uint(Tok.TotalLength).$out(/*KEEP_STR*/" PPK=").$out_int(Tok.PackingKind.getValue()).$out(
          /*KEEP_STR*/" FakeLParens="
      );
      for (/*uint*/int i = 0, e = Tok.FakeLParens.size(); i != e; ++i)  {
        llvm.errs().$out_int(Tok.FakeLParens.$at$Const(i).getValue()).$out(/*KEEP_STR*/$SLASH);
      }
      llvm.errs().$out(/*KEEP_STR*/" FakeRParens=").$out_uint(Tok.FakeRParens).$out(/*KEEP_STR*/$LF);
      if (!(Tok.Next != null)) {
        assert (Tok == Line.Last);
      }
      Tok = Tok.Next;
    }
    llvm.errs().$out(/*KEEP_STR*/"----\n");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::TokenAnnotator::calculateUnbreakableTailLengths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1782,
   FQN="clang::format::TokenAnnotator::calculateUnbreakableTailLengths", NM="_ZN5clang6format14TokenAnnotator31calculateUnbreakableTailLengthsERNS0_13AnnotatedLineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format14TokenAnnotator31calculateUnbreakableTailLengthsERNS0_13AnnotatedLineE")
  //</editor-fold>
  private void calculateUnbreakableTailLengths(final AnnotatedLine /*&*/ Line) {
    /*uint*/int UnbreakableTailLength = 0;
    FormatToken /*P*/ Current = Line.Last;
    while ((Current != null)) {
      Current.UnbreakableTailLength = UnbreakableTailLength;
      if (Current.CanBreakBefore
         || Current.isOneOf(tok.TokenKind.comment, tok.TokenKind.string_literal)) {
        UnbreakableTailLength = 0;
      } else {
        UnbreakableTailLength += Current.ColumnWidth + Current.SpacesRequiredBefore;
      }
      Current = Current.Previous;
    }
  }

  
  private final /*const*/ FormatStyle /*&*/ Style;
  
  private final /*const*/ AdditionalKeywords /*&*/ Keywords;
  
  @Override public String toString() {
    return "" + "Style=" + Style // NOI18N
              + ", Keywords=" + Keywords; // NOI18N
  }
}
