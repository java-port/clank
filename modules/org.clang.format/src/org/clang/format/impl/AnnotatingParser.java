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
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.format.*;
import static org.clang.basic.BasicClangGlobals.*;


/// \brief A parser that gathers additional information about tokens.
///
/// The \c TokenAnnotator tries to match parenthesis and square brakets and
/// store a parenthesis levels. It also tries to resolve matching "<" and ">"
/// into template parameter lists.
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 33,
 FQN="clang::format::(anonymous namespace)::AnnotatingParser", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParserE")
//</editor-fold>
public class AnnotatingParser implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::AnnotatingParser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 35,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::AnnotatingParser", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParserC1ERKNS0_11FormatStyleERNS0_13AnnotatedLineERKNS0_18AdditionalKeywordsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParserC1ERKNS0_11FormatStyleERNS0_13AnnotatedLineERKNS0_18AdditionalKeywordsE")
  //</editor-fold>
  public AnnotatingParser(final /*const*/ FormatStyle /*&*/ Style, final AnnotatedLine /*&*/ Line, 
      final /*const*/ AdditionalKeywords /*&*/ Keywords) {
    // : Contexts(), Style(Style), Line(Line), CurrentToken(Line.First), AutoFound(false), Keywords(Keywords), NonTemplateLess() 
    //START JInit
    this.Contexts = new SmallVector<Context>(8, new Context());
    this./*&*/Style=/*&*/Style;
    this./*&*/Line=/*&*/Line;
    this.CurrentToken = Line.First;
    this.AutoFound = false;
    this./*&*/Keywords=/*&*/Keywords;
    this.NonTemplateLess = new SmallPtrSet<FormatToken /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
    //END JInit
    Contexts.push_back(new Context(tok.TokenKind.unknown, 1, /*IsExpression=*/ false));
    resetTokenMetadata(CurrentToken);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::parseAngle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 44,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::parseAngle", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser10parseAngleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser10parseAngleEv")
  //</editor-fold>
  private boolean parseAngle() {
    ScopedContextCreator ContextCreator = null;
    try {
      if (!(CurrentToken != null) || !(CurrentToken.Previous != null)) {
        return false;
      }
      if ((NonTemplateLess.count(CurrentToken.Previous) != 0)) {
        return false;
      }
      
      final /*const*/ FormatToken /*&*/ Previous = /*Deref*/CurrentToken.Previous;
      if ((Previous.Previous != null)) {
        if (Previous.Previous.Tok.isLiteral()) {
          return false;
        }
        if (Previous.Previous.is_TokenKind(tok.TokenKind.r_paren) && $greater_uint(Contexts.size(), 1)
           && (!(Previous.Previous.MatchingParen != null)
           || !Previous.Previous.MatchingParen.is_TokenType(TokenType.TT_OverloadedOperatorLParen))) {
          return false;
        }
      }
      
      FormatToken /*P*/ Left = CurrentToken.Previous;
      Left.ParentBracket = Contexts.back().ContextKind;
      ContextCreator/*J*/= new ScopedContextCreator(/*Deref*/this, tok.TokenKind.less, 12);
      
      // If this angle is in the context of an expression, we need to be more
      // hesitant to detect it as opening template parameters.
      boolean InExprContext = Contexts.back().IsExpression;
      
      Contexts.back().IsExpression = false;
      // If there's a template keyword before the opening angle bracket, this is a
      // template parameter, not an argument.
      Contexts.back().InTemplateArgument
         = (Left.Previous != null) && Left.Previous.Tok.isNot(tok.TokenKind.kw_template);
      if (Style.Language == FormatStyle.LanguageKind.LK_Java
         && CurrentToken.is_TokenKind(tok.TokenKind.question)) {
        next();
      }
      while ((CurrentToken != null)) {
        if (CurrentToken.is_TokenKind(tok.TokenKind.greater)) {
          Left.MatchingParen = CurrentToken;
          CurrentToken.MatchingParen = Left;
          CurrentToken.Type = TokenType.TT_TemplateCloser;
          next();
          return true;
        }
        if (CurrentToken.is_TokenKind(tok.TokenKind.question)
           && Style.Language == FormatStyle.LanguageKind.LK_Java) {
          next();
          continue;
        }
        if (CurrentToken.isOneOf(tok.TokenKind.r_paren, tok.TokenKind.r_square, tok.TokenKind.r_brace)
           || (CurrentToken.isOneOf(tok.TokenKind.colon, tok.TokenKind.question) && InExprContext)) {
          return false;
        }
        // If a && or || is found and interpreted as a binary operator, this set
        // of angles is likely part of something like "a < b && c > d". If the
        // angles are inside an expression, the ||/&& might also be a binary
        // operator that was misinterpreted because we are parsing template
        // parameters.
        // FIXME: This is getting out of hand, write a decent parser.
        if (CurrentToken.Previous.isOneOf(tok.TokenKind.pipepipe, tok.TokenKind.ampamp)
           && CurrentToken.Previous.is_TokenType(TokenType.TT_BinaryOperator)
           && Contexts.$at(Contexts.size() - 2).IsExpression
           && !Line.startsWith(tok.TokenKind.kw_template)) {
          return false;
        }
        updateParameterCount(Left, CurrentToken);
        if (!consumeToken()) {
          return false;
        }
      }
      return false;
    } finally {
      if (ContextCreator != null) { ContextCreator.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::parseParens">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 112,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::parseParens", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser11parseParensEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser11parseParensEb")
  //</editor-fold>
  private boolean parseParens() {
    return parseParens(false);
  }
  private boolean parseParens(boolean LookForDecls/*= false*/) {
    ScopedContextCreator ContextCreator = null;
    try {
      if (!(CurrentToken != null)) {
        return false;
      }
      FormatToken /*P*/ Left = CurrentToken.Previous;
      Left.ParentBracket = Contexts.back().ContextKind;
      ContextCreator/*J*/= new ScopedContextCreator(/*Deref*/this, tok.TokenKind.l_paren, 1);
      
      // FIXME: This is a bit of a hack. Do better.
      Contexts.back().ColonIsForRangeExpr
         = Contexts.size() == 2 && Contexts.$at(0).ColonIsForRangeExpr;
      
      boolean StartsObjCMethodExpr = false;
      if (CurrentToken.is_TokenKind(tok.TokenKind.caret)) {
        // (^ can start a block type.
        Left.Type = TokenType.TT_ObjCBlockLParen;
      } else {
        FormatToken /*P*/ MaybeSel = Left.Previous;
        if ((MaybeSel != null)) {
          // @selector( starts a selector.
          if (MaybeSel.isObjCAtKeyword(tok.ObjCKeywordKind.objc_selector) && (MaybeSel.Previous != null)
             && MaybeSel.Previous.is_TokenKind(tok.TokenKind.at)) {
            StartsObjCMethodExpr = true;
          }
        }
      }
      if (Left.is_TokenType(TokenType.TT_OverloadedOperatorLParen)) {
        Contexts.back().IsExpression = false;
      } else if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript
         && Line.startsWith(Keywords.kw_type, tok.TokenKind.identifier)) {
        // type X = (...);
        Contexts.back().IsExpression = false;
      } else if ((Left.Previous != null)
         && (Left.Previous.isOneOf(tok.TokenKind.kw_static_assert, tok.TokenKind.kw_decltype, 
          tok.TokenKind.kw_if, tok.TokenKind.kw_while, tok.TokenKind.l_paren, 
          tok.TokenKind.comma)
         || Left.Previous.is_TokenType(TokenType.TT_BinaryOperator))) {
        // static_assert, if and while usually contain expressions.
        Contexts.back().IsExpression = true;
      } else if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript && (Left.Previous != null)
         && (Left.Previous.is(Keywords.kw_function)
         || (Left.Previous.endsSequence(tok.TokenKind.identifier, 
          Keywords.kw_function)))) {
        // function(...) or function f(...)
        Contexts.back().IsExpression = false;
      } else if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript && (Left.Previous != null)
         && Left.Previous.is_TokenType(TokenType.TT_JsTypeColon)) {
        // let x: (SomeType);
        Contexts.back().IsExpression = false;
      } else if ((Left.Previous != null) && Left.Previous.is_TokenKind(tok.TokenKind.r_square)
         && (Left.Previous.MatchingParen != null)
         && Left.Previous.MatchingParen.is_TokenType(TokenType.TT_LambdaLSquare)) {
        // This is a parameter list of a lambda expression.
        Contexts.back().IsExpression = false;
      } else if (Line.InPPDirective
         && (!(Left.Previous != null) || !Left.Previous.is_TokenKind(tok.TokenKind.identifier))) {
        Contexts.back().IsExpression = true;
      } else if (Contexts.$at(Contexts.size() - 2).CaretFound) {
        // This is the parameter list of an ObjC block.
        Contexts.back().IsExpression = false;
      } else if ((Left.Previous != null) && Left.Previous.is_TokenKind(tok.TokenKind.kw___attribute)) {
        Left.Type = TokenType.TT_AttributeParen;
      } else if ((Left.Previous != null) && Left.Previous.is_TokenType(TokenType.TT_ForEachMacro)) {
        // The first argument to a foreach macro is a declaration.
        Contexts.back().IsForEachMacro = true;
        Contexts.back().IsExpression = false;
      } else if ((Left.Previous != null) && (Left.Previous.MatchingParen != null)
         && Left.Previous.MatchingParen.is_TokenType(TokenType.TT_ObjCBlockLParen)) {
        Contexts.back().IsExpression = false;
      } else if (!Line.MustBeDeclaration && !Line.InPPDirective) {
        boolean IsForOrCatch = (Left.Previous != null) && Left.Previous.isOneOf(tok.TokenKind.kw_for, tok.TokenKind.kw_catch);
        Contexts.back().IsExpression = !IsForOrCatch;
      }
      if (StartsObjCMethodExpr) {
        Contexts.back().ColonIsObjCMethodExpr = true;
        Left.Type = TokenType.TT_ObjCMethodExpr;
      }
      
      boolean MightBeFunctionType = !Contexts.$at(Contexts.size() - 2).IsExpression;
      boolean ProbablyFunctionType = CurrentToken.isOneOf(tok.TokenKind.star, tok.TokenKind.amp);
      boolean HasMultipleLines = false;
      boolean HasMultipleParametersOnALine = false;
      boolean MightBeObjCForRangeLoop = (Left.Previous != null) && Left.Previous.is_TokenKind(tok.TokenKind.kw_for);
      while ((CurrentToken != null)) {
        // LookForDecls is set when "if (" has been seen. Check for
        // 'identifier' '*' 'identifier' followed by not '=' -- this
        // '*' has to be a binary operator but determineStarAmpUsage() will
        // categorize it as an unary operator, so set the right type here.
        if (LookForDecls && (CurrentToken.Next != null)) {
          FormatToken /*P*/ Prev = CurrentToken.getPreviousNonComment();
          if ((Prev != null)) {
            FormatToken /*P*/ PrevPrev = Prev.getPreviousNonComment();
            FormatToken /*P*/ Next = CurrentToken.Next;
            if ((PrevPrev != null) && PrevPrev.is_TokenKind(tok.TokenKind.identifier)
               && Prev.isOneOf(tok.TokenKind.star, tok.TokenKind.amp, tok.TokenKind.ampamp)
               && CurrentToken.is_TokenKind(tok.TokenKind.identifier) && Next.isNot(tok.TokenKind.equal)) {
              Prev.Type = TokenType.TT_BinaryOperator;
              LookForDecls = false;
            }
          }
        }
        if (CurrentToken.Previous.is_TokenType(TokenType.TT_PointerOrReference)
           && CurrentToken.Previous.Previous.isOneOf(tok.TokenKind.l_paren, 
            tok.TokenKind.coloncolon)) {
          ProbablyFunctionType = true;
        }
        if (CurrentToken.is_TokenKind(tok.TokenKind.comma)) {
          MightBeFunctionType = false;
        }
        if (CurrentToken.Previous.is_TokenType(TokenType.TT_BinaryOperator)) {
          Contexts.back().IsExpression = true;
        }
        if (CurrentToken.is_TokenKind(tok.TokenKind.r_paren)) {
          if (MightBeFunctionType && ProbablyFunctionType && (CurrentToken.Next != null)
             && (CurrentToken.Next.is_TokenKind(tok.TokenKind.l_paren)
             || (CurrentToken.Next.is_TokenKind(tok.TokenKind.l_square) && Line.MustBeDeclaration))) {
            Left.Type = TokenType.TT_FunctionTypeLParen;
          }
          Left.MatchingParen = CurrentToken;
          CurrentToken.MatchingParen = Left;
          if ((CurrentToken.Next != null) && CurrentToken.Next.is_TokenKind(tok.TokenKind.l_brace)
             && (Left.Previous != null) && Left.Previous.is_TokenKind(tok.TokenKind.l_paren)) {
            // Detect the case where macros are used to generate lambdas or
            // function bodies, e.g.:
            //   auto my_lambda = MARCO((Type *type, int i) { .. body .. });
            for (FormatToken /*P*/ Tok = Left; Tok != CurrentToken; Tok = Tok.Next) {
              if (Tok.is_TokenType(TokenType.TT_BinaryOperator)
                 && Tok.isOneOf(tok.TokenKind.star, tok.TokenKind.amp, tok.TokenKind.ampamp)) {
                Tok.Type = TokenType.TT_PointerOrReference;
              }
            }
          }
          if (StartsObjCMethodExpr) {
            CurrentToken.Type = TokenType.TT_ObjCMethodExpr;
            if ((Contexts.back().FirstObjCSelectorName != null)) {
              Contexts.back().FirstObjCSelectorName.LongestObjCSelectorName
                 = Contexts.back().LongestObjCSelectorName;
            }
          }
          if (Left.is_TokenType(TokenType.TT_AttributeParen)) {
            CurrentToken.Type = TokenType.TT_AttributeParen;
          }
          if ((Left.Previous != null) && Left.Previous.is_TokenType(TokenType.TT_JavaAnnotation)) {
            CurrentToken.Type = TokenType.TT_JavaAnnotation;
          }
          if ((Left.Previous != null) && Left.Previous.is_TokenType(TokenType.TT_LeadingJavaAnnotation)) {
            CurrentToken.Type = TokenType.TT_LeadingJavaAnnotation;
          }
          if (!HasMultipleLines) {
            Left.PackingKind = ParameterPackingKind.PPK_Inconclusive;
          } else if (HasMultipleParametersOnALine) {
            Left.PackingKind = ParameterPackingKind.PPK_BinPacked;
          } else {
            Left.PackingKind = ParameterPackingKind.PPK_OnePerLine;
          }
          
          next();
          return true;
        }
        if (CurrentToken.isOneOf(tok.TokenKind.r_square, tok.TokenKind.r_brace)) {
          return false;
        }
        if (CurrentToken.is_TokenKind(tok.TokenKind.l_brace)) {
          Left.Type = TokenType.TT_Unknown; // Not TT_ObjCBlockLParen
        }
        if (CurrentToken.is_TokenKind(tok.TokenKind.comma) && (CurrentToken.Next != null)
           && !CurrentToken.Next.HasUnescapedNewline
           && !CurrentToken.Next.isTrailingComment()) {
          HasMultipleParametersOnALine = true;
        }
        if (CurrentToken.isOneOf(tok.TokenKind.kw_const, tok.TokenKind.kw_auto)
           || CurrentToken.isSimpleTypeSpecifier()) {
          Contexts.back().IsExpression = false;
        }
        if (CurrentToken.isOneOf(tok.TokenKind.semi, tok.TokenKind.colon)) {
          MightBeObjCForRangeLoop = false;
        }
        if (MightBeObjCForRangeLoop && CurrentToken.is(Keywords.kw_in)) {
          CurrentToken.Type = TokenType.TT_ObjCForIn;
        }
        // When we discover a 'new', we set CanBeExpression to 'false' in order to
        // parse the type correctly. Reset that after a comma.
        if (CurrentToken.is_TokenKind(tok.TokenKind.comma)) {
          Contexts.back().CanBeExpression = true;
        }
        
        FormatToken /*P*/ Tok = CurrentToken;
        if (!consumeToken()) {
          return false;
        }
        updateParameterCount(Left, Tok);
        if ((CurrentToken != null) && CurrentToken.HasUnescapedNewline) {
          HasMultipleLines = true;
        }
      }
      return false;
    } finally {
      if (ContextCreator != null) { ContextCreator.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::parseSquare">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 298,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::parseSquare", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser11parseSquareEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser11parseSquareEv")
  //</editor-fold>
  private boolean parseSquare() {
    ScopedContextCreator ContextCreator = null;
    try {
      if (!(CurrentToken != null)) {
        return false;
      }
      
      // A '[' could be an index subscript (after an identifier or after
      // ')' or ']'), it could be the start of an Objective-C method
      // expression, or it could the start of an Objective-C array literal.
      FormatToken /*P*/ Left = CurrentToken.Previous;
      Left.ParentBracket = Contexts.back().ContextKind;
      FormatToken /*P*/ Parent = Left.getPreviousNonComment();
      boolean StartsObjCMethodExpr = Style.Language == FormatStyle.LanguageKind.LK_Cpp
         && Contexts.back().CanBeExpression && Left.isNot(TokenType.TT_LambdaLSquare)
         && CurrentToken.isNot(tok.TokenKind.l_brace)
         && (!(Parent != null)
         || Parent.isOneOf(tok.TokenKind.colon, tok.TokenKind.l_square, tok.TokenKind.l_paren, 
          tok.TokenKind.kw_return, tok.TokenKind.kw_throw)
         || Parent.isUnaryOperator()
         || Parent.isOneOf(TokenType.TT_ObjCForIn, TokenType.TT_CastRParen)
         || getBinOpPrecedence(Parent.Tok.getKind(), true, true).getValue() > prec.Level.Unknown.getValue());
      boolean ColonFound = false;
      
      /*uint*/int BindingIncrease = 1;
      if (Left.is_TokenType(TokenType.TT_Unknown)) {
        if (StartsObjCMethodExpr) {
          Left.Type = TokenType.TT_ObjCMethodExpr;
        } else if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript && (Parent != null)
           && Contexts.back().ContextKind == tok.TokenKind.l_brace
           && Parent.isOneOf(tok.TokenKind.l_brace, tok.TokenKind.comma)) {
          Left.Type = TokenType.TT_JsComputedPropertyName;
        } else if (Style.Language == FormatStyle.LanguageKind.LK_Proto
           || ((Parent != null)
           && Parent.isOneOf(TokenType.TT_BinaryOperator, TokenType.TT_TemplateCloser, tok.TokenKind.at, 
            tok.TokenKind.comma, tok.TokenKind.l_paren, tok.TokenKind.l_square, 
            tok.TokenKind.question, tok.TokenKind.colon, tok.TokenKind.kw_return, 
            // Should only be relevant to JavaScript:
            tok.TokenKind.kw_default))) {
          Left.Type = TokenType.TT_ArrayInitializerLSquare;
        } else {
          BindingIncrease = 10;
          Left.Type = TokenType.TT_ArraySubscriptLSquare;
        }
      }
      
      ContextCreator/*J*/= new ScopedContextCreator(/*Deref*/this, tok.TokenKind.l_square, BindingIncrease);
      Contexts.back().IsExpression = true;
      Contexts.back().ColonIsObjCMethodExpr = StartsObjCMethodExpr;
      while ((CurrentToken != null)) {
        if (CurrentToken.is_TokenKind(tok.TokenKind.r_square)) {
          if ((CurrentToken.Next != null) && CurrentToken.Next.is_TokenKind(tok.TokenKind.l_paren)
             && Left.is_TokenType(TokenType.TT_ObjCMethodExpr)) {
            // An ObjC method call is rarely followed by an open parenthesis.
            // FIXME: Do we incorrectly label ":" with this?
            StartsObjCMethodExpr = false;
            Left.Type = TokenType.TT_Unknown;
          }
          if (StartsObjCMethodExpr && CurrentToken.Previous != Left) {
            CurrentToken.Type = TokenType.TT_ObjCMethodExpr;
            // determineStarAmpUsage() thinks that '*' '[' is allocating an
            // array of pointers, but if '[' starts a selector then '*' is a
            // binary operator.
            if ((Parent != null) && Parent.is_TokenType(TokenType.TT_PointerOrReference)) {
              Parent.Type = TokenType.TT_BinaryOperator;
            }
          }
          Left.MatchingParen = CurrentToken;
          CurrentToken.MatchingParen = Left;
          if ((Contexts.back().FirstObjCSelectorName != null)) {
            Contexts.back().FirstObjCSelectorName.LongestObjCSelectorName
               = Contexts.back().LongestObjCSelectorName;
            if ($greater_uint(Left.BlockParameterCount, 1)) {
              Contexts.back().FirstObjCSelectorName.LongestObjCSelectorName = 0;
            }
          }
          next();
          return true;
        }
        if (CurrentToken.isOneOf(tok.TokenKind.r_paren, tok.TokenKind.r_brace)) {
          return false;
        }
        if (CurrentToken.is_TokenKind(tok.TokenKind.colon)) {
          if (Left.is_TokenType(TokenType.TT_ArraySubscriptLSquare)) {
            Left.Type = TokenType.TT_ObjCMethodExpr;
            StartsObjCMethodExpr = true;
            Contexts.back().ColonIsObjCMethodExpr = true;
            if ((Parent != null) && Parent.is_TokenKind(tok.TokenKind.r_paren)) {
              Parent.Type = TokenType.TT_CastRParen;
            }
          }
          ColonFound = true;
        }
        if (CurrentToken.is_TokenKind(tok.TokenKind.comma) && Left.is_TokenType(TokenType.TT_ObjCMethodExpr)
           && !ColonFound) {
          Left.Type = TokenType.TT_ArrayInitializerLSquare;
        }
        FormatToken /*P*/ Tok = CurrentToken;
        if (!consumeToken()) {
          return false;
        }
        updateParameterCount(Left, Tok);
      }
      return false;
    } finally {
      if (ContextCreator != null) { ContextCreator.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::parseBrace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 397,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::parseBrace", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser10parseBraceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser10parseBraceEv")
  //</editor-fold>
  private boolean parseBrace() {
    if ((CurrentToken != null)) {
      ScopedContextCreator ContextCreator = null;
      try {
        FormatToken /*P*/ Left = CurrentToken.Previous;
        Left.ParentBracket = Contexts.back().ContextKind;
        if (Contexts.back().CaretFound) {
          Left.Type = TokenType.TT_ObjCBlockLBrace;
        }
        Contexts.back().CaretFound = false;
        
        ContextCreator/*J*/= new ScopedContextCreator(/*Deref*/this, tok.TokenKind.l_brace, 1);
        Contexts.back().ColonIsDictLiteral = true;
        if (Left.BlockKind == BraceBlockKind.BK_BracedInit) {
          Contexts.back().IsExpression = true;
        }
        while ((CurrentToken != null)) {
          if (CurrentToken.is_TokenKind(tok.TokenKind.r_brace)) {
            Left.MatchingParen = CurrentToken;
            CurrentToken.MatchingParen = Left;
            next();
            return true;
          }
          if (CurrentToken.isOneOf(tok.TokenKind.r_paren, tok.TokenKind.r_square)) {
            return false;
          }
          updateParameterCount(Left, CurrentToken);
          if (CurrentToken.isOneOf(tok.TokenKind.colon, tok.TokenKind.l_brace)) {
            FormatToken /*P*/ Previous = CurrentToken.getPreviousNonComment();
            if (((CurrentToken.is_TokenKind(tok.TokenKind.colon)
               && (!Contexts.back().ColonIsDictLiteral
               || Style.Language != FormatStyle.LanguageKind.LK_Cpp))
               || Style.Language == FormatStyle.LanguageKind.LK_Proto)
               && ((Previous.Tok.getIdentifierInfo() != null)
               || Previous.is_TokenKind(tok.TokenKind.string_literal))) {
              Previous.Type = TokenType.TT_SelectorName;
            }
            if (CurrentToken.is_TokenKind(tok.TokenKind.colon)
               || Style.Language == FormatStyle.LanguageKind.LK_JavaScript) {
              Left.Type = TokenType.TT_DictLiteral;
            }
          }
          if (!consumeToken()) {
            return false;
          }
        }
      } finally {
        if (ContextCreator != null) { ContextCreator.$destroy(); }
      }
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::updateParameterCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 441,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::updateParameterCount", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser20updateParameterCountEPNS0_11FormatTokenES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser20updateParameterCountEPNS0_11FormatTokenES4_")
  //</editor-fold>
  private void updateParameterCount(FormatToken /*P*/ Left, FormatToken /*P*/ Current) {
    if (Current.is_TokenKind(tok.TokenKind.l_brace) && Current.BlockKind == BraceBlockKind.BK_Block) {
      ++Left.BlockParameterCount;
    }
    if (Current.is_TokenKind(tok.TokenKind.comma)) {
      ++Left.ParameterCount;
      if (!Left.Role.$bool()) {
        Left.Role.reset(new CommaSeparatedList(Style));
      }
      Left.Role.$arrow().CommaFound(Current);
    } else if (Left.ParameterCount == 0 && Current.isNot(tok.TokenKind.comment)) {
      Left.ParameterCount = 1;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::parseConditional">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 454,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::parseConditional", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser16parseConditionalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser16parseConditionalEv")
  //</editor-fold>
  private boolean parseConditional() {
    while ((CurrentToken != null)) {
      if (CurrentToken.is_TokenKind(tok.TokenKind.colon)) {
        CurrentToken.Type = TokenType.TT_ConditionalExpr;
        next();
        return true;
      }
      if (!consumeToken()) {
        return false;
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::parseTemplateDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 467,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::parseTemplateDeclaration", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser24parseTemplateDeclarationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser24parseTemplateDeclarationEv")
  //</editor-fold>
  private boolean parseTemplateDeclaration() {
    if ((CurrentToken != null) && CurrentToken.is_TokenKind(tok.TokenKind.less)) {
      CurrentToken.Type = TokenType.TT_TemplateOpener;
      next();
      if (!parseAngle()) {
        return false;
      }
      if ((CurrentToken != null)) {
        CurrentToken.Previous.ClosesTemplateDeclaration = true;
      }
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::consumeToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 480,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::consumeToken", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser12consumeTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser12consumeTokenEv")
  //</editor-fold>
  private boolean consumeToken() {
    FormatToken /*P*/ Tok = CurrentToken;
    next();
    switch (Tok.Tok.getKind()) {
     case tok.TokenKind.plus:
     case tok.TokenKind.minus:
      if (!(Tok.Previous != null) && Line.MustBeDeclaration) {
        Tok.Type = TokenType.TT_ObjCMethodSpecifier;
      }
      break;
     case tok.TokenKind.colon:
      if (!(Tok.Previous != null)) {
        return false;
      }
      // Colons from ?: are handled in parseConditional().
      if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript) {
        if (Contexts.back().ColonIsForRangeExpr // colon in for loop
           || (Contexts.size() == 1 // switch/case labels
           && !Line.First.isOneOf(tok.TokenKind.kw_enum, tok.TokenKind.kw_case))
           || Contexts.back().ContextKind == tok.TokenKind.l_paren // function params
           || Contexts.back().ContextKind == tok.TokenKind.l_square // array type
           || (Contexts.size() == 1
           && Line.MustBeDeclaration)) { // method/property declaration
          Tok.Type = TokenType.TT_JsTypeColon;
          break;
        }
      }
      if (Contexts.back().ColonIsDictLiteral
         || Style.Language == FormatStyle.LanguageKind.LK_Proto) {
        Tok.Type = TokenType.TT_DictLiteral;
      } else if (Contexts.back().ColonIsObjCMethodExpr
         || Line.startsWith(TokenType.TT_ObjCMethodSpecifier)) {
        Tok.Type = TokenType.TT_ObjCMethodExpr;
        Tok.Previous.Type = TokenType.TT_SelectorName;
        if ($greater_uint(Tok.Previous.ColumnWidth
          , Contexts.back().LongestObjCSelectorName)) {
          Contexts.back().LongestObjCSelectorName = Tok.Previous.ColumnWidth;
        }
        if (!(Contexts.back().FirstObjCSelectorName != null)) {
          Contexts.back().FirstObjCSelectorName = Tok.Previous;
        }
      } else if (Contexts.back().ColonIsForRangeExpr) {
        Tok.Type = TokenType.TT_RangeBasedForLoopColon;
      } else if ((CurrentToken != null) && CurrentToken.is_TokenKind(tok.TokenKind.numeric_constant)) {
        Tok.Type = TokenType.TT_BitFieldColon;
      } else if (Contexts.size() == 1
         && !Line.First.isOneOf(tok.TokenKind.kw_enum, tok.TokenKind.kw_case)) {
        if (Tok.Previous.isOneOf(tok.TokenKind.r_paren, tok.TokenKind.kw_noexcept)) {
          Tok.Type = TokenType.TT_CtorInitializerColon;
        } else {
          Tok.Type = TokenType.TT_InheritanceColon;
        }
      } else if (Tok.Previous.is_TokenKind(tok.TokenKind.identifier) && (Tok.Next != null)
         && Tok.Next.isOneOf(tok.TokenKind.r_paren, tok.TokenKind.comma)) {
        // This handles a special macro in ObjC code where selectors including
        // the colon are passed as macro arguments.
        Tok.Type = TokenType.TT_ObjCMethodExpr;
      } else if (Contexts.back().ContextKind == tok.TokenKind.l_paren) {
        Tok.Type = TokenType.TT_InlineASMColon;
      }
      break;
     case tok.TokenKind.pipe:
     case tok.TokenKind.amp:
      // | and & in declarations/type expressions represent union and
      // intersection types, respectively.
      if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript
         && !Contexts.back().IsExpression) {
        Tok.Type = TokenType.TT_JsTypeOperator;
      }
      break;
     case tok.TokenKind.kw_if:
     case tok.TokenKind.kw_while:
      if ((CurrentToken != null) && CurrentToken.is_TokenKind(tok.TokenKind.l_paren)) {
        next();
        if (!parseParens(/*LookForDecls=*/ true)) {
          return false;
        }
      }
      break;
     case tok.TokenKind.kw_for:
      if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript && (Tok.Previous != null)
         && Tok.Previous.is_TokenKind(tok.TokenKind.period)) {
        break;
      }
      Contexts.back().ColonIsForRangeExpr = true;
      next();
      if (!parseParens()) {
        return false;
      }
      break;
     case tok.TokenKind.l_paren:
      // When faced with 'operator()()', the kw_operator handler incorrectly
      // marks the first l_paren as a OverloadedOperatorLParen. Here, we make
      // the first two parens OverloadedOperators and the second l_paren an
      // OverloadedOperatorLParen.
      if ((Tok.Previous != null)
         && Tok.Previous.is_TokenKind(tok.TokenKind.r_paren)
         && (Tok.Previous.MatchingParen != null)
         && Tok.Previous.MatchingParen.is_TokenType(TokenType.TT_OverloadedOperatorLParen)) {
        Tok.Previous.Type = TokenType.TT_OverloadedOperator;
        Tok.Previous.MatchingParen.Type = TokenType.TT_OverloadedOperator;
        Tok.Type = TokenType.TT_OverloadedOperatorLParen;
      }
      if (!parseParens()) {
        return false;
      }
      if (Line.MustBeDeclaration && Contexts.size() == 1
         && !Contexts.back().IsExpression && !Line.startsWith(TokenType.TT_ObjCProperty)
         && (!(Tok.Previous != null)
         || !Tok.Previous.isOneOf(tok.TokenKind.kw_decltype, tok.TokenKind.kw___attribute, 
          TokenType.TT_LeadingJavaAnnotation))) {
        Line.MightBeFunctionDecl = true;
      }
      break;
     case tok.TokenKind.l_square:
      if (!parseSquare()) {
        return false;
      }
      break;
     case tok.TokenKind.l_brace:
      if (!parseBrace()) {
        return false;
      }
      break;
     case tok.TokenKind.less:
      if (parseAngle()) {
        Tok.Type = TokenType.TT_TemplateOpener;
      } else {
        Tok.Type = TokenType.TT_BinaryOperator;
        NonTemplateLess.insert(Tok);
        CurrentToken = Tok;
        next();
      }
      break;
     case tok.TokenKind.r_paren:
     case tok.TokenKind.r_square:
      return false;
     case tok.TokenKind.r_brace:
      // Lines can start with '}'.
      if ((Tok.Previous != null)) {
        return false;
      }
      break;
     case tok.TokenKind.greater:
      Tok.Type = TokenType.TT_BinaryOperator;
      break;
     case tok.TokenKind.kw_operator:
      while ((CurrentToken != null)
         && !CurrentToken.isOneOf(tok.TokenKind.l_paren, tok.TokenKind.semi, tok.TokenKind.r_paren)) {
        if (CurrentToken.isOneOf(tok.TokenKind.star, tok.TokenKind.amp)) {
          CurrentToken.Type = TokenType.TT_PointerOrReference;
        }
        consumeToken();
        if ((CurrentToken != null)
           && CurrentToken.Previous.isOneOf(TokenType.TT_BinaryOperator, tok.TokenKind.comma)) {
          CurrentToken.Previous.Type = TokenType.TT_OverloadedOperator;
        }
      }
      if ((CurrentToken != null)) {
        CurrentToken.Type = TokenType.TT_OverloadedOperatorLParen;
        if (CurrentToken.Previous.is_TokenType(TokenType.TT_BinaryOperator)) {
          CurrentToken.Previous.Type = TokenType.TT_OverloadedOperator;
        }
      }
      break;
     case tok.TokenKind.question:
      if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript && (Tok.Next != null)
         && Tok.Next.isOneOf(tok.TokenKind.semi, tok.TokenKind.comma, tok.TokenKind.colon, tok.TokenKind.r_paren, 
          tok.TokenKind.r_brace)) {
        // Question marks before semicolons, colons, etc. indicate optional
        // types (fields, parameters), e.g.
        //   function(x?: string, y?) {...}
        //   class X { y?; }
        Tok.Type = TokenType.TT_JsTypeOptionalQuestion;
        break;
      }
      // Declarations cannot be conditional expressions, this can only be part
      // of a type declaration.
      if (Line.MustBeDeclaration && !Contexts.back().IsExpression
         && Style.Language == FormatStyle.LanguageKind.LK_JavaScript) {
        break;
      }
      parseConditional();
      break;
     case tok.TokenKind.kw_template:
      parseTemplateDeclaration();
      break;
     case tok.TokenKind.comma:
      if (Contexts.back().InCtorInitializer) {
        Tok.Type = TokenType.TT_CtorInitializerComma;
      } else if ((Contexts.back().FirstStartOfName != null)
         && (Contexts.size() == 1 || Line.startsWith(tok.TokenKind.kw_for))) {
        Contexts.back().FirstStartOfName.PartOfMultiVariableDeclStmt = true;
        Line.IsMultiVariableDeclStmt = true;
      }
      if (Contexts.back().IsForEachMacro) {
        Contexts.back().IsExpression = true;
      }
      break;
     default:
      break;
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::parseIncludeDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 667,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::parseIncludeDirective", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser21parseIncludeDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser21parseIncludeDirectiveEv")
  //</editor-fold>
  private void parseIncludeDirective() {
    if ((CurrentToken != null) && CurrentToken.is_TokenKind(tok.TokenKind.less)) {
      next();
      while ((CurrentToken != null)) {
        if (CurrentToken.isNot(tok.TokenKind.comment) || (CurrentToken.Next != null)) {
          CurrentToken.Type = TokenType.TT_ImplicitStringLiteral;
        }
        next();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::parseWarningOrError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 678,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::parseWarningOrError", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser19parseWarningOrErrorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser19parseWarningOrErrorEv")
  //</editor-fold>
  private void parseWarningOrError() {
    next();
    // We still want to format the whitespace left of the first token of the
    // warning or error.
    next();
    while ((CurrentToken != null)) {
      CurrentToken.Type = TokenType.TT_ImplicitStringLiteral;
      next();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::parsePragma">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 689,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::parsePragma", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser11parsePragmaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser11parsePragmaEv")
  //</editor-fold>
  private void parsePragma() {
    next(); // Consume "pragma".
    if ((CurrentToken != null)
       && CurrentToken.isOneOf(Keywords.kw_mark, Keywords.kw_option)) {
      boolean IsMark = CurrentToken.is(Keywords.kw_mark);
      next(); // Consume "mark".
      next(); // Consume first token (so we fix leading whitespace).
      while ((CurrentToken != null)) {
        if (IsMark || CurrentToken.Previous.is_TokenType(TokenType.TT_BinaryOperator)) {
          CurrentToken.Type = TokenType.TT_ImplicitStringLiteral;
        }
        next();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::parsePreprocessorDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 704,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::parsePreprocessorDirective", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser26parsePreprocessorDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser26parsePreprocessorDirectiveEv")
  //</editor-fold>
  private LineType parsePreprocessorDirective() {
    boolean IsFirstToken = CurrentToken.IsFirst;
    LineType Type = LineType.LT_PreprocessorDirective;
    next();
    if (!(CurrentToken != null)) {
      return Type;
    }
    if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript && IsFirstToken) {
      // JavaScript files can contain shebang lines of the form:
      // #!/usr/bin/env node
      // Treat these like C++ #include directives.
      while ((CurrentToken != null)) {
        // Tokens cannot be comments here.
        CurrentToken.Type = TokenType.TT_ImplicitStringLiteral;
        next();
      }
      return LineType.LT_ImportStatement;
    }
    if (CurrentToken.Tok.is(tok.TokenKind.numeric_constant)) {
      CurrentToken.SpacesRequiredBefore = 1;
      return Type;
    }
    // Hashes in the middle of a line can lead to any strange token
    // sequence.
    if (!(CurrentToken.Tok.getIdentifierInfo() != null)) {
      return Type;
    }
    switch (CurrentToken.Tok.getIdentifierInfo().getPPKeywordID()) {
     case tok.PPKeywordKind.pp_include:
     case tok.PPKeywordKind.pp_include_next:
     case tok.PPKeywordKind.pp_import:
      next();
      parseIncludeDirective();
      Type = LineType.LT_ImportStatement;
      break;
     case tok.PPKeywordKind.pp_error:
     case tok.PPKeywordKind.pp_warning:
      parseWarningOrError();
      break;
     case tok.PPKeywordKind.pp_pragma:
      parsePragma();
      break;
     case tok.PPKeywordKind.pp_if:
     case tok.PPKeywordKind.pp_elif:
      Contexts.back().IsExpression = true;
      parseLine();
      break;
     default:
      break;
    }
    while ((CurrentToken != null)) {
      next();
    }
    return Type;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::parseLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 760,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::parseLine", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser9parseLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser9parseLineEv")
  //</editor-fold>
  public LineType parseLine() {
    NonTemplateLess.clear();
    if (CurrentToken.is_TokenKind(tok.TokenKind.hash)) {
      return parsePreprocessorDirective();
    }
    
    // Directly allow to 'import <string-literal>' to support protocol buffer
    // definitions (code.google.com/p/protobuf) or missing "#" (either way we
    // should not break the line).
    IdentifierInfo /*P*/ Info = CurrentToken.Tok.getIdentifierInfo();
    if ((Style.Language == FormatStyle.LanguageKind.LK_Java
       && CurrentToken.is(Keywords.kw_package))
       || ((Info != null) && Info.getPPKeywordID() == tok.PPKeywordKind.pp_import
       && (CurrentToken.Next != null)
       && CurrentToken.Next.isOneOf(tok.TokenKind.string_literal, tok.TokenKind.identifier, 
        tok.TokenKind.kw_static))) {
      next();
      parseIncludeDirective();
      return LineType.LT_ImportStatement;
    }
    
    // If this line starts and ends in '<' and '>', respectively, it is likely
    // part of "#define <a/b.h>".
    if (CurrentToken.is_TokenKind(tok.TokenKind.less) && Line.Last.is_TokenKind(tok.TokenKind.greater)) {
      parseIncludeDirective();
      return LineType.LT_ImportStatement;
    }
    
    // In .proto files, top-level options are very similar to import statements
    // and should not be line-wrapped.
    if (Style.Language == FormatStyle.LanguageKind.LK_Proto && Line.Level == 0
       && CurrentToken.is(Keywords.kw_option)) {
      next();
      if ((CurrentToken != null) && CurrentToken.is_TokenKind(tok.TokenKind.identifier)) {
        return LineType.LT_ImportStatement;
      }
    }
    
    boolean KeywordVirtualFound = false;
    boolean ImportStatement = false;
    
    // import {...} from '...';
    if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript
       && CurrentToken.is(Keywords.kw_import)) {
      ImportStatement = true;
    }
    while ((CurrentToken != null)) {
      if (CurrentToken.is_TokenKind(tok.TokenKind.kw_virtual)) {
        KeywordVirtualFound = true;
      }
      if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript) {
        // export {...} from '...';
        // An export followed by "from 'some string';" is a re-export from
        // another module identified by a URI and is treated as a
        // LT_ImportStatement (i.e. prevent wraps on it for long URIs).
        // Just "export {...};" or "export class ..." should not be treated as
        // an import in this sense.
        if (Line.First.is_TokenKind(tok.TokenKind.kw_export)
           && CurrentToken.is(Keywords.kw_from) && (CurrentToken.Next != null)
           && CurrentToken.Next.isStringLiteral()) {
          ImportStatement = true;
        }
        if (isClosureImportStatement(/*Deref*/CurrentToken)) {
          ImportStatement = true;
        }
      }
      if (!consumeToken()) {
        return LineType.LT_Invalid;
      }
    }
    if (KeywordVirtualFound) {
      return LineType.LT_VirtualFunctionDecl;
    }
    if (ImportStatement) {
      return LineType.LT_ImportStatement;
    }
    if (Line.startsWith(TokenType.TT_ObjCMethodSpecifier)) {
      if ((Contexts.back().FirstObjCSelectorName != null)) {
        Contexts.back().FirstObjCSelectorName.LongestObjCSelectorName
           = Contexts.back().LongestObjCSelectorName;
      }
      return LineType.LT_ObjCMethodDecl;
    }
    
    return LineType.LT_Other;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::isClosureImportStatement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 840,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::isClosureImportStatement", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser24isClosureImportStatementERKNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser24isClosureImportStatementERKNS0_11FormatTokenE")
  //</editor-fold>
  private boolean isClosureImportStatement(final /*const*/ FormatToken /*&*/ Tok) {
    // FIXME: Closure-library specific stuff should not be hard-coded but be
    // configurable.
    return $eq_StringRef(/*NO_COPY*/Tok.TokenText, /*STRINGREF_STR*/"goog") && (Tok.Next != null) && Tok.Next.is_TokenKind(tok.TokenKind.period)
       && (Tok.Next.Next != null) && ($eq_StringRef(/*NO_COPY*/Tok.Next.Next.TokenText, /*STRINGREF_STR*/"module")
       || $eq_StringRef(/*NO_COPY*/Tok.Next.Next.TokenText, /*STRINGREF_STR*/"provide")
       || $eq_StringRef(/*NO_COPY*/Tok.Next.Next.TokenText, /*STRINGREF_STR*/"require")
       || $eq_StringRef(/*NO_COPY*/Tok.Next.Next.TokenText, /*STRINGREF_STR*/"setTestOnly")
       || $eq_StringRef(/*NO_COPY*/Tok.Next.Next.TokenText, /*STRINGREF_STR*/"forwardDeclare"))
       && (Tok.Next.Next.Next != null) && Tok.Next.Next.Next.is_TokenKind(tok.TokenKind.l_paren);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::resetTokenMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 852,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::resetTokenMetadata", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser18resetTokenMetadataEPNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser18resetTokenMetadataEPNS0_11FormatTokenE")
  //</editor-fold>
  private void resetTokenMetadata(FormatToken /*P*/ Token) {
    if (!(Token != null)) {
      return;
    }
    
    // Reset token type in case we have already looked at it and then
    // recovered from an error (e.g. failure to find the matching >).
    if (!CurrentToken.isOneOf(TokenType.TT_LambdaLSquare, TokenType.TT_ForEachMacro, 
        TokenType.TT_FunctionLBrace, TokenType.TT_ImplicitStringLiteral, 
        TokenType.TT_InlineASMBrace, TokenType.TT_JsFatArrow, TokenType.TT_LambdaArrow, 
        TokenType.TT_RegexLiteral)) {
      CurrentToken.Type = TokenType.TT_Unknown;
    }
    CurrentToken.Role.reset();
    CurrentToken.MatchingParen = null;
    CurrentToken.FakeLParens.clear();
    CurrentToken.FakeRParens = 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::next">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 869,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::next", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser4nextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser4nextEv")
  //</editor-fold>
  private void next() {
    if ((CurrentToken != null)) {
      CurrentToken.NestingLevel = Contexts.size() - 1;
      CurrentToken.BindingStrength = Contexts.back().BindingStrength;
      modifyContext(/*Deref*/CurrentToken);
      determineTokenType(/*Deref*/CurrentToken);
      CurrentToken = CurrentToken.Next;
    }
    
    resetTokenMetadata(CurrentToken);
  }

  
  /// \brief A struct to hold information valid in a specific context, e.g.
  /// a pair of parenthesis.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::Context">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 883,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::Context", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser7ContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser7ContextE")
  //</editor-fold>
  private static class/*struct*/ Context implements Native.NativePOD<Context> {
    //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::Context::Context">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 884,
     FQN="clang::format::(anonymous namespace)::AnnotatingParser::Context::Context", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser7ContextC1ENS_3tok9TokenKindEjb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser7ContextC1ENS_3tok9TokenKindEjb")
    //</editor-fold>
    public Context(/*tok.TokenKind*/char ContextKind, /*uint*/int BindingStrength, 
        boolean IsExpression) {
      // : ContextKind(ContextKind), BindingStrength(BindingStrength), IsExpression(IsExpression), LongestObjCSelectorName(0), ColonIsForRangeExpr(false), ColonIsDictLiteral(false), ColonIsObjCMethodExpr(false), FirstObjCSelectorName(null), FirstStartOfName(null), CanBeExpression(true), InTemplateArgument(false), InCtorInitializer(false), CaretFound(false), IsForEachMacro(false) 
      //START JInit
      this.ContextKind = ContextKind;
      this.BindingStrength = BindingStrength;
      this.IsExpression = IsExpression;
      /*InClass*/this.LongestObjCSelectorName = 0;
      /*InClass*/this.ColonIsForRangeExpr = false;
      /*InClass*/this.ColonIsDictLiteral = false;
      /*InClass*/this.ColonIsObjCMethodExpr = false;
      /*InClass*/this.FirstObjCSelectorName = null;
      /*InClass*/this.FirstStartOfName = null;
      /*InClass*/this.CanBeExpression = true;
      /*InClass*/this.InTemplateArgument = false;
      /*InClass*/this.InCtorInitializer = false;
      /*InClass*/this.CaretFound = false;
      /*InClass*/this.IsForEachMacro = false;
      //END JInit
    }

    
    public /*tok.TokenKind*/char ContextKind;
    public /*uint*/int BindingStrength;
    public boolean IsExpression;
    public /*uint*/int LongestObjCSelectorName/* = 0*/;
    public boolean ColonIsForRangeExpr/* = false*/;
    public boolean ColonIsDictLiteral/* = false*/;
    public boolean ColonIsObjCMethodExpr/* = false*/;
    public FormatToken /*P*/ FirstObjCSelectorName/* = null*/;
    public FormatToken /*P*/ FirstStartOfName/* = null*/;
    public boolean CanBeExpression/* = true*/;
    public boolean InTemplateArgument/* = false*/;
    public boolean InCtorInitializer/* = false*/;
    public boolean CaretFound/* = false*/;
    public boolean IsForEachMacro/* = false*/;
    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    private Context() { }

    @Override
    public Context $assign(Context value) {
      this.ContextKind = value.ContextKind;
      this.BindingStrength = value.BindingStrength;
      this.IsExpression = value.IsExpression;
      this.LongestObjCSelectorName = value.LongestObjCSelectorName;
      this.ColonIsForRangeExpr = value.ColonIsForRangeExpr;
      this.ColonIsDictLiteral = value.ColonIsDictLiteral;
      this.ColonIsObjCMethodExpr = value.ColonIsObjCMethodExpr;
      this.FirstObjCSelectorName = value.FirstObjCSelectorName;
      this.FirstStartOfName = value.FirstStartOfName;
      this.CanBeExpression = value.CanBeExpression;
      this.InTemplateArgument = value.InTemplateArgument;
      this.InCtorInitializer = value.InCtorInitializer;
      this.CaretFound = value.CaretFound;
      this.IsForEachMacro = value.IsForEachMacro;
      return this;
    }

    @Override
    public Context clone() {
      Context res = new Context();
      res.$assign(this);
      return res;
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "ContextKind=" + $ushort2uint(ContextKind) // NOI18N
                + ", BindingStrength=" + BindingStrength // NOI18N
                + ", IsExpression=" + IsExpression // NOI18N
                + ", LongestObjCSelectorName=" + LongestObjCSelectorName // NOI18N
                + ", ColonIsForRangeExpr=" + ColonIsForRangeExpr // NOI18N
                + ", ColonIsDictLiteral=" + ColonIsDictLiteral // NOI18N
                + ", ColonIsObjCMethodExpr=" + ColonIsObjCMethodExpr // NOI18N
                + ", FirstObjCSelectorName=" + FirstObjCSelectorName // NOI18N
                + ", FirstStartOfName=" + FirstStartOfName // NOI18N
                + ", CanBeExpression=" + CanBeExpression // NOI18N
                + ", InTemplateArgument=" + InTemplateArgument // NOI18N
                + ", InCtorInitializer=" + InCtorInitializer // NOI18N
                + ", CaretFound=" + CaretFound // NOI18N
                + ", IsForEachMacro=" + IsForEachMacro; // NOI18N
    }
  };
  
  /// \brief Puts a new \c Context onto the stack \c Contexts for the lifetime
  /// of each instance.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::ScopedContextCreator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 907,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::ScopedContextCreator", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser20ScopedContextCreatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser20ScopedContextCreatorE")
  //</editor-fold>
  private static class/*struct*/ ScopedContextCreator implements Destructors.ClassWithDestructor {
    public final AnnotatingParser /*&*/ P;
    
    //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::ScopedContextCreator::ScopedContextCreator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 910,
     FQN="clang::format::(anonymous namespace)::AnnotatingParser::ScopedContextCreator::ScopedContextCreator", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser20ScopedContextCreatorC1ERS2_NS_3tok9TokenKindEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser20ScopedContextCreatorC1ERS2_NS_3tok9TokenKindEj")
    //</editor-fold>
    public ScopedContextCreator(final AnnotatingParser /*&*/ P, /*tok.TokenKind*/char ContextKind, 
        /*uint*/int Increase) {
      // : P(P) 
      //START JInit
      this./*&*/P=/*&*/P;
      //END JInit
      P.Contexts.push_back(new Context(ContextKind, 
              P.Contexts.back().BindingStrength + Increase, 
              P.Contexts.back().IsExpression));
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::ScopedContextCreator::~ScopedContextCreator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 918,
     FQN="clang::format::(anonymous namespace)::AnnotatingParser::ScopedContextCreator::~ScopedContextCreator", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser20ScopedContextCreatorD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser20ScopedContextCreatorD0Ev")
    //</editor-fold>
    public void $destroy() {
      P.Contexts.pop_back();
    }

    
    @Override public String toString() {
      return "" + "P=" + "[AnnotatingParser]"; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::modifyContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 921,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::modifyContext", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser13modifyContextERKNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser13modifyContextERKNS0_11FormatTokenE")
  //</editor-fold>
  private void modifyContext(final /*const*/ FormatToken /*&*/ Current) {
    if (Current.getPrecedence() == prec.Level.Assignment
       && !Line.First.isOneOf(tok.TokenKind.kw_template, tok.TokenKind.kw_using, tok.TokenKind.kw_return)
      // Type aliases use `type X = ...;` in TypeScript.
       && !(Style.Language == FormatStyle.LanguageKind.LK_JavaScript
       && Line.startsWith(Keywords.kw_type, tok.TokenKind.identifier))
       && (!(Current.Previous != null) || Current.Previous.isNot(tok.TokenKind.kw_operator))) {
      Contexts.back().IsExpression = true;
      if (!Line.startsWith(TokenType.TT_UnaryOperator)) {
        for (FormatToken /*P*/ Previous = Current.Previous;
             (Previous != null) && (Previous.Previous != null)
           && !Previous.Previous.isOneOf(tok.TokenKind.comma, tok.TokenKind.semi);
             Previous = Previous.Previous) {
          if (Previous.isOneOf(tok.TokenKind.r_square, tok.TokenKind.r_paren)) {
            Previous = Previous.MatchingParen;
            if (!(Previous != null)) {
              break;
            }
          }
          if (Previous.opensScope()) {
            break;
          }
          if (Previous.isOneOf(TokenType.TT_BinaryOperator, TokenType.TT_UnaryOperator)
             && Previous.isOneOf(tok.TokenKind.star, tok.TokenKind.amp, tok.TokenKind.ampamp)
             && (Previous.Previous != null) && Previous.Previous.isNot(tok.TokenKind.equal)) {
            Previous.Type = TokenType.TT_PointerOrReference;
          }
        }
      }
    } else if (Current.is_TokenKind(tok.TokenKind.lessless)
       && (!(Current.Previous != null) || !Current.Previous.is_TokenKind(tok.TokenKind.kw_operator))) {
      Contexts.back().IsExpression = true;
    } else if (Current.isOneOf(tok.TokenKind.kw_return, tok.TokenKind.kw_throw)) {
      Contexts.back().IsExpression = true;
    } else if (Current.is_TokenType(TokenType.TT_TrailingReturnArrow)) {
      Contexts.back().IsExpression = false;
    } else if (Current.is_TokenType(TokenType.TT_LambdaArrow) || Current.is(Keywords.kw_assert)) {
      Contexts.back().IsExpression = Style.Language == FormatStyle.LanguageKind.LK_Java;
    } else if ((Current.Previous != null)
       && Current.Previous.is_TokenType(TokenType.TT_CtorInitializerColon)) {
      Contexts.back().IsExpression = true;
      Contexts.back().InCtorInitializer = true;
    } else if (Current.isOneOf(tok.TokenKind.r_paren, tok.TokenKind.greater, tok.TokenKind.comma)) {
      for (FormatToken /*P*/ Previous = Current.Previous;
           (Previous != null) && Previous.isOneOf(tok.TokenKind.star, tok.TokenKind.amp);
           Previous = Previous.Previous)  {
        Previous.Type = TokenType.TT_PointerOrReference;
      }
      if (Line.MustBeDeclaration && !Contexts.front().InCtorInitializer) {
        Contexts.back().IsExpression = false;
      }
    } else if (Current.is_TokenKind(tok.TokenKind.kw_new)) {
      Contexts.back().CanBeExpression = false;
    } else if (Current.isOneOf(tok.TokenKind.semi, tok.TokenKind.exclaim)) {
      // This should be the condition or increment in a for-loop.
      Contexts.back().IsExpression = true;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::determineTokenType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 975,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::determineTokenType", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser18determineTokenTypeERNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser18determineTokenTypeERNS0_11FormatTokenE")
  //</editor-fold>
  private void determineTokenType(final FormatToken /*&*/ Current) {
    if (!Current.is_TokenType(TokenType.TT_Unknown)) {
      // The token type is already known.
      return;
    }
    
    // Line.MightBeFunctionDecl can only be true after the parentheses of a
    // function declaration have been found. In this case, 'Current' is a
    // trailing token of this declaration and thus cannot be a name.
    if (Current.is(Keywords.kw_instanceof)) {
      Current.Type = TokenType.TT_BinaryOperator;
    } else if (isStartOfName(Current)
       && (!Line.MightBeFunctionDecl || Current.NestingLevel != 0)) {
      Contexts.back().FirstStartOfName = /*AddrOf*/Current;
      Current.Type = TokenType.TT_StartOfName;
    } else if (Current.isOneOf(tok.TokenKind.kw_auto, tok.TokenKind.kw___auto_type)) {
      AutoFound = true;
    } else if (Current.is_TokenKind(tok.TokenKind.arrow)
       && Style.Language == FormatStyle.LanguageKind.LK_Java) {
      Current.Type = TokenType.TT_LambdaArrow;
    } else if (Current.is_TokenKind(tok.TokenKind.arrow) && AutoFound && Line.MustBeDeclaration
       && Current.NestingLevel == 0) {
      Current.Type = TokenType.TT_TrailingReturnArrow;
    } else if (Current.isOneOf(tok.TokenKind.star, tok.TokenKind.amp, tok.TokenKind.ampamp)) {
      Current.Type
         = determineStarAmpUsage(Current, Contexts.back().CanBeExpression
             && Contexts.back().IsExpression, 
          Contexts.back().InTemplateArgument);
    } else if (Current.isOneOf(tok.TokenKind.minus, tok.TokenKind.plus, tok.TokenKind.caret)) {
      Current.Type = determinePlusMinusCaretUsage(Current);
      if (Current.is_TokenType(TokenType.TT_UnaryOperator) && Current.is_TokenKind(tok.TokenKind.caret)) {
        Contexts.back().CaretFound = true;
      }
    } else if (Current.isOneOf(tok.TokenKind.minusminus, tok.TokenKind.plusplus)) {
      Current.Type = determineIncrementUsage(Current);
    } else if (Current.isOneOf(tok.TokenKind.exclaim, tok.TokenKind.tilde)) {
      Current.Type = TokenType.TT_UnaryOperator;
    } else if (Current.is_TokenKind(tok.TokenKind.question)) {
      if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript
         && Line.MustBeDeclaration && !Contexts.back().IsExpression) {
        // In JavaScript, `interface X { foo?(): bar; }` is an optional method
        // on the interface, not a ternary expression.
        Current.Type = TokenType.TT_JsTypeOptionalQuestion;
      } else {
        Current.Type = TokenType.TT_ConditionalExpr;
      }
    } else if (Current.isBinaryOperator()
       && (!(Current.Previous != null) || Current.Previous.isNot(tok.TokenKind.l_square))) {
      Current.Type = TokenType.TT_BinaryOperator;
    } else if (Current.is_TokenKind(tok.TokenKind.comment)) {
      if (Current.TokenText.startswith(/*STRINGREF_STR*/"/*")) {
        if (Current.TokenText.endswith(/*STRINGREF_STR*/"*/")) {
          Current.Type = TokenType.TT_BlockComment;
        } else {
          // The lexer has for some reason determined a comment here. But we
          // cannot really handle it, if it isn't properly terminated.
          Current.Tok.setKind(tok.TokenKind.unknown);
        }
      } else {
        Current.Type = TokenType.TT_LineComment;
      }
    } else if (Current.is_TokenKind(tok.TokenKind.r_paren)) {
      if (rParenEndsCast(Current)) {
        Current.Type = TokenType.TT_CastRParen;
      }
      if ((Current.MatchingParen != null) && (Current.Next != null)
         && !Current.Next.isBinaryOperator()
         && !Current.Next.isOneOf(tok.TokenKind.semi, tok.TokenKind.colon, tok.TokenKind.l_brace, 
          tok.TokenKind.period, tok.TokenKind.arrow, tok.TokenKind.coloncolon)) {
        {
          FormatToken /*P*/ BeforeParen = Current.MatchingParen.Previous;
          if ((BeforeParen != null)) {
            if (BeforeParen.is_TokenKind(tok.TokenKind.identifier)
               && $eq_StringRef(/*NO_COPY*/BeforeParen.TokenText, new StringRef(BeforeParen.TokenText.upper()))
               && (!(BeforeParen.Previous != null)
               || BeforeParen.Previous.ClosesTemplateDeclaration)) {
              Current.Type = TokenType.TT_FunctionAnnotationRParen;
            }
          }
        }
      }
    } else if (Current.is_TokenKind(tok.TokenKind.at) && (Current.Next != null)) {
      if (Current.Next.isStringLiteral()) {
        Current.Type = TokenType.TT_ObjCStringLiteral;
      } else {
        switch (Current.Next.Tok.getObjCKeywordID()) {
         case tok.ObjCKeywordKind.objc_interface:
         case tok.ObjCKeywordKind.objc_implementation:
         case tok.ObjCKeywordKind.objc_protocol:
          Current.Type = TokenType.TT_ObjCDecl;
          break;
         case tok.ObjCKeywordKind.objc_property:
          Current.Type = TokenType.TT_ObjCProperty;
          break;
         default:
          break;
        }
      }
    } else if (Current.is_TokenKind(tok.TokenKind.period)) {
      FormatToken /*P*/ PreviousNoComment = Current.getPreviousNonComment();
      if ((PreviousNoComment != null)
         && PreviousNoComment.isOneOf(tok.TokenKind.comma, tok.TokenKind.l_brace)) {
        Current.Type = TokenType.TT_DesignatedInitializerPeriod;
      } else if (Style.Language == FormatStyle.LanguageKind.LK_Java && (Current.Previous != null)
         && Current.Previous.isOneOf(TokenType.TT_JavaAnnotation, 
          TokenType.TT_LeadingJavaAnnotation)) {
        Current.Type = Current.Previous.Type;
      }
    } else if (Current.isOneOf(tok.TokenKind.identifier, tok.TokenKind.kw_const)
       && (Current.Previous != null)
       && !Current.Previous.isOneOf(tok.TokenKind.equal, tok.TokenKind.at)
       && Line.MightBeFunctionDecl && Contexts.size() == 1) {
      // Line.MightBeFunctionDecl can only be true after the parentheses of a
      // function declaration have been found.
      Current.Type = TokenType.TT_TrailingAnnotation;
    } else if ((Style.Language == FormatStyle.LanguageKind.LK_Java
       || Style.Language == FormatStyle.LanguageKind.LK_JavaScript)
       && (Current.Previous != null)) {
      if (Current.Previous.is_TokenKind(tok.TokenKind.at)
         && Current.isNot(Keywords.kw_interface)) {
        final /*const*/ FormatToken /*&*/ AtToken = /*Deref*/Current.Previous;
        /*const*/ FormatToken /*P*/ Previous = AtToken.getPreviousNonComment();
        if (!(Previous != null) || Previous.is_TokenType(TokenType.TT_LeadingJavaAnnotation)) {
          Current.Type = TokenType.TT_LeadingJavaAnnotation;
        } else {
          Current.Type = TokenType.TT_JavaAnnotation;
        }
      } else if (Current.Previous.is_TokenKind(tok.TokenKind.period)
         && Current.Previous.isOneOf(TokenType.TT_JavaAnnotation, 
          TokenType.TT_LeadingJavaAnnotation)) {
        Current.Type = Current.Previous.Type;
      }
    }
  }

  
  /// \brief Take a guess at whether \p Tok starts a name of a function or
  /// variable declaration.
  ///
  /// This is a heuristic based on whether \p Tok is an identifier following
  /// something that is likely a type.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::isStartOfName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1104,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::isStartOfName", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser13isStartOfNameERKNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser13isStartOfNameERKNS0_11FormatTokenE")
  //</editor-fold>
  private boolean isStartOfName(final /*const*/ FormatToken /*&*/ Tok) {
    if (Tok.isNot(tok.TokenKind.identifier) || !(Tok.Previous != null)) {
      return false;
    }
    if (Tok.Previous.isOneOf(TokenType.TT_LeadingJavaAnnotation, Keywords.kw_instanceof)) {
      return false;
    }
    if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript
       && Tok.Previous.is(Keywords.kw_in)) {
      return false;
    }
    
    // Skip "const" as it does not have an influence on whether this is a name.
    FormatToken /*P*/ PreviousNotConst = Tok.Previous;
    while ((PreviousNotConst != null) && PreviousNotConst.is_TokenKind(tok.TokenKind.kw_const)) {
      PreviousNotConst = PreviousNotConst.Previous;
    }
    if (!(PreviousNotConst != null)) {
      return false;
    }
    
    boolean IsPPKeyword = PreviousNotConst.is_TokenKind(tok.TokenKind.identifier)
       && (PreviousNotConst.Previous != null)
       && PreviousNotConst.Previous.is_TokenKind(tok.TokenKind.hash);
    if (PreviousNotConst.is_TokenType(TokenType.TT_TemplateCloser)) {
      return (PreviousNotConst != null) && (PreviousNotConst.MatchingParen != null)
         && (PreviousNotConst.MatchingParen.Previous != null)
         && PreviousNotConst.MatchingParen.Previous.isNot(tok.TokenKind.period)
         && PreviousNotConst.MatchingParen.Previous.isNot(tok.TokenKind.kw_template);
    }
    if (PreviousNotConst.is_TokenKind(tok.TokenKind.r_paren) && (PreviousNotConst.MatchingParen != null)
       && (PreviousNotConst.MatchingParen.Previous != null)
       && PreviousNotConst.MatchingParen.Previous.is_TokenKind(tok.TokenKind.kw_decltype)) {
      return true;
    }
    
    return (!IsPPKeyword
       && PreviousNotConst.isOneOf(tok.TokenKind.identifier, tok.TokenKind.kw_auto))
       || PreviousNotConst.is_TokenType(TokenType.TT_PointerOrReference)
       || PreviousNotConst.isSimpleTypeSpecifier();
  }

  
  /// \brief Determine whether ')' is ending a cast.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::rParenEndsCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1144,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::rParenEndsCast", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser14rParenEndsCastERKNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser14rParenEndsCastERKNS0_11FormatTokenE")
  //</editor-fold>
  private boolean rParenEndsCast(final /*const*/ FormatToken /*&*/ Tok) {
    // C-style casts are only used in C++ and Java.
    if (Style.Language != FormatStyle.LanguageKind.LK_Cpp
       && Style.Language != FormatStyle.LanguageKind.LK_Java) {
      return false;
    }
    
    // Empty parens aren't casts and there are no casts at the end of the line.
    if (Tok.Previous == Tok.MatchingParen || !(Tok.Next != null) || !(Tok.MatchingParen != null)) {
      return false;
    }
    
    FormatToken /*P*/ LeftOfParens = Tok.MatchingParen.getPreviousNonComment();
    if ((LeftOfParens != null)) {
      // If there is a closing parenthesis left of the current parentheses,
      // look past it as these might be chained casts.
      if (LeftOfParens.is_TokenKind(tok.TokenKind.r_paren)) {
        if (!(LeftOfParens.MatchingParen != null)
           || !(LeftOfParens.MatchingParen.Previous != null)) {
          return false;
        }
        LeftOfParens = LeftOfParens.MatchingParen.Previous;
      }
      
      // If there is an identifier (or with a few exceptions a keyword) right
      // before the parentheses, this is unlikely to be a cast.
      if ((LeftOfParens.Tok.getIdentifierInfo() != null)
         && !LeftOfParens.isOneOf(Keywords.kw_in, tok.TokenKind.kw_return, tok.TokenKind.kw_case, 
          tok.TokenKind.kw_delete)) {
        return false;
      }
      
      // Certain other tokens right before the parentheses are also signals that
      // this cannot be a cast.
      if (LeftOfParens.isOneOf(tok.TokenKind.at, tok.TokenKind.r_square, TokenType.TT_OverloadedOperator, 
          TokenType.TT_TemplateCloser, tok.TokenKind.ellipsis)) {
        return false;
      }
    }
    if (Tok.Next.is_TokenKind(tok.TokenKind.question)) {
      return false;
    }
    
    // As Java has no function types, a "(" after the ")" likely means that this
    // is a cast.
    if (Style.Language == FormatStyle.LanguageKind.LK_Java && Tok.Next.is_TokenKind(tok.TokenKind.l_paren)) {
      return true;
    }
    
    // If a (non-string) literal follows, this is likely a cast.
    if (Tok.Next.isNot(tok.TokenKind.string_literal)
       && (Tok.Next.Tok.isLiteral()
       || Tok.Next.isOneOf(tok.TokenKind.kw_sizeof, tok.TokenKind.kw_alignof))) {
      return true;
    }
    
    // Heuristically try to determine whether the parentheses contain a type.
    boolean ParensAreType = !(Tok.Previous != null)
       || Tok.Previous.isOneOf(TokenType.TT_PointerOrReference, TokenType.TT_TemplateCloser)
       || Tok.Previous.isSimpleTypeSpecifier();
    boolean ParensCouldEndDecl = Tok.Next.isOneOf(tok.TokenKind.equal, tok.TokenKind.semi, tok.TokenKind.l_brace, tok.TokenKind.greater);
    if (ParensAreType && !ParensCouldEndDecl) {
      return true;
    }
    
    // At this point, we heuristically assume that there are no casts at the
    // start of the line. We assume that we have found most cases where there
    // are by the logic above, e.g. "(void)x;".
    if (!(LeftOfParens != null)) {
      return false;
    }
    
    // If the following token is an identifier or 'this', this is a cast. All
    // cases where this can be something else are handled above.
    if (Tok.Next.isOneOf(tok.TokenKind.identifier, tok.TokenKind.kw_this)) {
      return true;
    }
    if (!(Tok.Next.Next != null)) {
      return false;
    }
    
    // If the next token after the parenthesis is a unary operator, assume
    // that this is cast, unless there are unexpected tokens inside the
    // parenthesis.
    boolean NextIsUnary = Tok.Next.isUnaryOperator() || Tok.Next.isOneOf(tok.TokenKind.amp, tok.TokenKind.star);
    if (!NextIsUnary || Tok.Next.is_TokenKind(tok.TokenKind.plus)
       || !Tok.Next.Next.isOneOf(tok.TokenKind.identifier, tok.TokenKind.numeric_constant)) {
      return false;
    }
    // Search for unexpected tokens.
    for (FormatToken /*P*/ Prev = Tok.Previous; Prev != Tok.MatchingParen;
         Prev = Prev.Previous) {
      if (!Prev.isOneOf(tok.TokenKind.kw_const, tok.TokenKind.identifier, tok.TokenKind.coloncolon)) {
        return false;
      }
    }
    return true;
  }

  
  /// \brief Return the type of the given token assuming it is * or &.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::determineStarAmpUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1235,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::determineStarAmpUsage", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser21determineStarAmpUsageERKNS0_11FormatTokenEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser21determineStarAmpUsageERKNS0_11FormatTokenEbb")
  //</editor-fold>
  private TokenType determineStarAmpUsage(final /*const*/ FormatToken /*&*/ Tok, boolean IsExpression, 
                       boolean InTemplateArgument) {
    if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript) {
      return TokenType.TT_BinaryOperator;
    }
    
    /*const*/ FormatToken /*P*/ PrevToken = Tok.getPreviousNonComment();
    if (!(PrevToken != null)) {
      return TokenType.TT_UnaryOperator;
    }
    
    /*const*/ FormatToken /*P*/ NextToken = Tok.getNextNonComment();
    if (!(NextToken != null)
       || NextToken.isOneOf(tok.TokenKind.arrow, Keywords.kw_final, 
        Keywords.kw_override)
       || (NextToken.is_TokenKind(tok.TokenKind.l_brace) && !(NextToken.getNextNonComment() != null))) {
      return TokenType.TT_PointerOrReference;
    }
    if (PrevToken.is_TokenKind(tok.TokenKind.coloncolon)) {
      return TokenType.TT_PointerOrReference;
    }
    if (PrevToken.isOneOf(tok.TokenKind.l_paren, tok.TokenKind.l_square, tok.TokenKind.l_brace, 
        tok.TokenKind.comma, tok.TokenKind.semi, tok.TokenKind.kw_return, tok.TokenKind.colon, 
        tok.TokenKind.equal, tok.TokenKind.kw_delete, tok.TokenKind.kw_sizeof)
       || PrevToken.isOneOf(TokenType.TT_BinaryOperator, TokenType.TT_ConditionalExpr, 
        TokenType.TT_UnaryOperator, TokenType.TT_CastRParen)) {
      return TokenType.TT_UnaryOperator;
    }
    if (NextToken.is_TokenKind(tok.TokenKind.l_square) && NextToken.isNot(TokenType.TT_LambdaLSquare)) {
      return TokenType.TT_PointerOrReference;
    }
    if (NextToken.is_TokenKind(tok.TokenKind.kw_operator) && !IsExpression) {
      return TokenType.TT_PointerOrReference;
    }
    if (NextToken.isOneOf(tok.TokenKind.comma, tok.TokenKind.semi)) {
      return TokenType.TT_PointerOrReference;
    }
    if (PrevToken.is_TokenKind(tok.TokenKind.r_paren) && (PrevToken.MatchingParen != null)
       && (PrevToken.MatchingParen.Previous != null)
       && PrevToken.MatchingParen.Previous.isOneOf(tok.TokenKind.kw_typeof, 
        tok.TokenKind.kw_decltype)) {
      return TokenType.TT_PointerOrReference;
    }
    if (PrevToken.Tok.isLiteral()
       || PrevToken.isOneOf(tok.TokenKind.r_paren, tok.TokenKind.r_square, tok.TokenKind.kw_true, 
        tok.TokenKind.kw_false, tok.TokenKind.r_brace)
       || NextToken.Tok.isLiteral()
       || NextToken.isOneOf(tok.TokenKind.kw_true, tok.TokenKind.kw_false)
       || NextToken.isUnaryOperator()
      // If we know we're in a template argument, there are no named
      // declarations. Thus, having an identifier on the right-hand side
      // indicates a binary operator.
       || (InTemplateArgument && NextToken.Tok.isAnyIdentifier())) {
      return TokenType.TT_BinaryOperator;
    }
    
    // "&&(" is quite unlikely to be two successive unary "&".
    if (Tok.is_TokenKind(tok.TokenKind.ampamp) && (NextToken != null) && NextToken.is_TokenKind(tok.TokenKind.l_paren)) {
      return TokenType.TT_BinaryOperator;
    }
    
    // This catches some cases where evaluation order is used as control flow:
    //   aaa && aaa->f();
    /*const*/ FormatToken /*P*/ NextNextToken = NextToken.getNextNonComment();
    if ((NextNextToken != null) && NextNextToken.is_TokenKind(tok.TokenKind.arrow)) {
      return TokenType.TT_BinaryOperator;
    }
    
    // It is very unlikely that we are going to find a pointer or reference type
    // definition on the RHS of an assignment.
    if (IsExpression && !Contexts.back().CaretFound) {
      return TokenType.TT_BinaryOperator;
    }
    
    return TokenType.TT_PointerOrReference;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::determinePlusMinusCaretUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1304,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::determinePlusMinusCaretUsage", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser28determinePlusMinusCaretUsageERKNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser28determinePlusMinusCaretUsageERKNS0_11FormatTokenE")
  //</editor-fold>
  private TokenType determinePlusMinusCaretUsage(final /*const*/ FormatToken /*&*/ Tok) {
    /*const*/ FormatToken /*P*/ PrevToken = Tok.getPreviousNonComment();
    if (!(PrevToken != null) || PrevToken.is_TokenType(TokenType.TT_CastRParen)) {
      return TokenType.TT_UnaryOperator;
    }
    
    // Use heuristics to recognize unary operators.
    if (PrevToken.isOneOf(tok.TokenKind.equal, tok.TokenKind.l_paren, tok.TokenKind.comma, tok.TokenKind.l_square, 
        tok.TokenKind.question, tok.TokenKind.colon, tok.TokenKind.kw_return, 
        tok.TokenKind.kw_case, tok.TokenKind.at, tok.TokenKind.l_brace)) {
      return TokenType.TT_UnaryOperator;
    }
    
    // There can't be two consecutive binary operators.
    if (PrevToken.is_TokenType(TokenType.TT_BinaryOperator)) {
      return TokenType.TT_UnaryOperator;
    }
    
    // Fall back to marking the token as binary operator.
    return TokenType.TT_BinaryOperator;
  }

  
  /// \brief Determine whether ++/-- are pre- or post-increments/-decrements.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::determineIncrementUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1324,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::determineIncrementUsage", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParser23determineIncrementUsageERKNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParser23determineIncrementUsageERKNS0_11FormatTokenE")
  //</editor-fold>
  private TokenType determineIncrementUsage(final /*const*/ FormatToken /*&*/ Tok) {
    /*const*/ FormatToken /*P*/ PrevToken = Tok.getPreviousNonComment();
    if (!(PrevToken != null) || PrevToken.is_TokenType(TokenType.TT_CastRParen)) {
      return TokenType.TT_UnaryOperator;
    }
    if (PrevToken.isOneOf(tok.TokenKind.r_paren, tok.TokenKind.r_square, tok.TokenKind.identifier)) {
      return TokenType.TT_TrailingUnaryOperator;
    }
    
    return TokenType.TT_UnaryOperator;
  }

  
  private SmallVector<Context> Contexts;
  
  private final /*const*/ FormatStyle /*&*/ Style;
  private final AnnotatedLine /*&*/ Line;
  private FormatToken /*P*/ CurrentToken;
  private boolean AutoFound;
  private final /*const*/ AdditionalKeywords /*&*/ Keywords;
  
  // Set of "<" tokens that do not open a template parameter list. If parseAngle
  // determines that a specific token can't be a template opener, it will make
  // same decision irrespective of the decisions for tokens leading up to it.
  // Store this information to prevent this from causing exponential runtime.
  private SmallPtrSet<FormatToken /*P*/ > NonTemplateLess;
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::AnnotatingParser::~AnnotatingParser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 33,
   FQN="clang::format::(anonymous namespace)::AnnotatingParser::~AnnotatingParser", NM="_ZN5clang6format12_GLOBAL__N_116AnnotatingParserD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116AnnotatingParserD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    NonTemplateLess.$destroy();
    Contexts.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Contexts=" + "[SmallVector$Context]" // NOI18N
              + ", Style=" + Style // NOI18N
              + ", Line=" + Line // NOI18N
              + ", CurrentToken=" + CurrentToken // NOI18N
              + ", AutoFound=" + AutoFound // NOI18N
              + ", Keywords=" + Keywords // NOI18N
              + ", NonTemplateLess=" + NonTemplateLess; // NOI18N
  }
}
