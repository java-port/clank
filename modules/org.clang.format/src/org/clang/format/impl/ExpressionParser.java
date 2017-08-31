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
import org.clang.basic.*;
import org.clang.format.*;
import static org.clang.format.impl.FormatStatics.*;


/// \brief Parses binary expressions by inserting fake parenthesis based on
/// operator precedence.
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::ExpressionParser">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1354,
 FQN="clang::format::(anonymous namespace)::ExpressionParser", NM="_ZN5clang6format12_GLOBAL__N_116ExpressionParserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116ExpressionParserE")
//</editor-fold>
public class ExpressionParser {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::ExpressionParser::ExpressionParser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1356,
   FQN="clang::format::(anonymous namespace)::ExpressionParser::ExpressionParser", NM="_ZN5clang6format12_GLOBAL__N_116ExpressionParserC1ERKNS0_11FormatStyleERKNS0_18AdditionalKeywordsERNS0_13AnnotatedLineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116ExpressionParserC1ERKNS0_11FormatStyleERKNS0_18AdditionalKeywordsERNS0_13AnnotatedLineE")
  //</editor-fold>
  public ExpressionParser(final /*const*/ FormatStyle /*&*/ Style, final /*const*/ AdditionalKeywords /*&*/ Keywords, 
      final AnnotatedLine /*&*/ Line) {
    // : Style(Style), Keywords(Keywords), Current(Line.First) 
    //START JInit
    this./*&*/Style=/*&*/Style;
    this./*&*/Keywords=/*&*/Keywords;
    this.Current = Line.First;
    //END JInit
  }

  
  /// \brief Parse expressions with the given operatore precedence.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::ExpressionParser::parse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1361,
   FQN="clang::format::(anonymous namespace)::ExpressionParser::parse", NM="_ZN5clang6format12_GLOBAL__N_116ExpressionParser5parseEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116ExpressionParser5parseEi")
  //</editor-fold>
  public void parse() {
    parse(0);
  }
  public void parse(int Precedence/*= 0*/) {
    // Skip 'return' and ObjC selector colons as they are not part of a binary
    // expression.
    while ((Current != null) && (Current.is_TokenKind(tok.TokenKind.kw_return)
       || (Current.is_TokenKind(tok.TokenKind.colon)
       && Current.isOneOf(TokenType.TT_ObjCMethodExpr, TokenType.TT_DictLiteral)))) {
      next();
    }
    if (!(Current != null) || Precedence > PrecedenceArrowAndPeriod) {
      return;
    }
    
    // Conditional expressions need to be parsed separately for proper nesting.
    if (Precedence == prec.Level.Conditional.getValue()) {
      parseConditionalExpr();
      return;
    }
    
    // Parse unary operators, which all have a higher precedence than binary
    // operators.
    if (Precedence == PrecedenceUnaryOperator) {
      parseUnaryOperator();
      return;
    }
    
    FormatToken /*P*/ Start = Current;
    FormatToken /*P*/ LatestOperator = null;
    /*uint*/int OperatorIndex = 0;
    while ((Current != null)) {
      // Consume operators with higher precedence.
      parse(Precedence + 1);
      
      int CurrentPrecedence = getCurrentPrecedence();
      if ((Current != null) && Current.is_TokenType(TokenType.TT_SelectorName)
         && Precedence == CurrentPrecedence) {
        if ((LatestOperator != null)) {
          addFakeParenthesis(Start, prec.Level.valueOf(Precedence));
        }
        Start = Current;
      }
      
      // At the end of the line or when an operator with higher precedence is
      // found, insert fake parenthesis and return.
      if (!(Current != null) || (Current.closesScope() && (Current.MatchingParen != null))
         || (CurrentPrecedence != -1 && CurrentPrecedence < Precedence)
         || (CurrentPrecedence == prec.Level.Conditional.getValue()
         && Precedence == prec.Level.Assignment.getValue() && Current.is_TokenKind(tok.TokenKind.colon))) {
        break;
      }
      
      // Consume scopes: (), [], <> and {}
      if (Current.opensScope()) {
        while ((Current != null) && !Current.closesScope()) {
          next();
          parse();
        }
        next();
      } else {
        // Operator found.
        if (CurrentPrecedence == Precedence) {
          if ((LatestOperator != null)) {
            LatestOperator.NextOperator = Current;
          }
          LatestOperator = Current;
          Current.OperatorIndex = OperatorIndex;
          ++OperatorIndex;
        }
        next(/*SkipPastLeadingComments=*/ Precedence > 0);
      }
    }
    if ((LatestOperator != null) && ((Current != null) || Precedence > 0)) {
      // LatestOperator->LastOperator = true;
      if (Precedence == PrecedenceArrowAndPeriod) {
        // Call expressions don't have a binary operator precedence.
        addFakeParenthesis(Start, prec.Level.Unknown);
      } else {
        addFakeParenthesis(Start, prec.Level.valueOf(Precedence));
      }
    }
  }

/*private:*/
  /// \brief Gets the precedence (+1) of the given token for binary operators
  /// and other tokens that we treat like binary operators.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::ExpressionParser::getCurrentPrecedence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1445,
   FQN="clang::format::(anonymous namespace)::ExpressionParser::getCurrentPrecedence", NM="_ZN5clang6format12_GLOBAL__N_116ExpressionParser20getCurrentPrecedenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116ExpressionParser20getCurrentPrecedenceEv")
  //</editor-fold>
  private int getCurrentPrecedence() {
    if ((Current != null)) {
      /*const*/ FormatToken /*P*/ NextNonComment = Current.getNextNonComment();
      if (Current.is_TokenType(TokenType.TT_ConditionalExpr)) {
        return prec.Level.Conditional.getValue();
      }
      if ((NextNonComment != null) && NextNonComment.is_TokenKind(tok.TokenKind.colon)
         && NextNonComment.is_TokenType(TokenType.TT_DictLiteral)) {
        return prec.Level.Comma.getValue();
      }
      if (Current.is_TokenType(TokenType.TT_LambdaArrow)) {
        return prec.Level.Comma.getValue();
      }
      if (Current.is_TokenType(TokenType.TT_JsFatArrow)) {
        return prec.Level.Assignment.getValue();
      }
      if (Current.isOneOf(tok.TokenKind.semi, TokenType.TT_InlineASMColon, TokenType.TT_SelectorName, 
          TokenType.TT_JsComputedPropertyName)
         || (Current.is_TokenKind(tok.TokenKind.comment) && (NextNonComment != null)
         && NextNonComment.is_TokenType(TokenType.TT_SelectorName))) {
        return 0;
      }
      if (Current.is_TokenType(TokenType.TT_RangeBasedForLoopColon)) {
        return prec.Level.Comma.getValue();
      }
      if ((Style.Language == FormatStyle.LanguageKind.LK_Java
         || Style.Language == FormatStyle.LanguageKind.LK_JavaScript)
         && Current.is(Keywords.kw_instanceof)) {
        return prec.Level.Relational.getValue();
      }
      if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript
         && Current.is(Keywords.kw_in)) {
        return prec.Level.Relational.getValue();
      }
      if (Current.is_TokenType(TokenType.TT_BinaryOperator) || Current.is_TokenKind(tok.TokenKind.comma)) {
        return Current.getPrecedence().getValue();
      }
      if (Current.isOneOf(tok.TokenKind.period, tok.TokenKind.arrow)) {
        return PrecedenceArrowAndPeriod;
      }
      if ((Style.Language == FormatStyle.LanguageKind.LK_Java
         || Style.Language == FormatStyle.LanguageKind.LK_JavaScript)
         && Current.isOneOf(Keywords.kw_extends, Keywords.kw_implements, 
          Keywords.kw_throws)) {
        return 0;
      }
    }
    return -1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::ExpressionParser::addFakeParenthesis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1484,
   FQN="clang::format::(anonymous namespace)::ExpressionParser::addFakeParenthesis", NM="_ZN5clang6format12_GLOBAL__N_116ExpressionParser18addFakeParenthesisEPNS0_11FormatTokenENS_4prec5LevelE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116ExpressionParser18addFakeParenthesisEPNS0_11FormatTokenENS_4prec5LevelE")
  //</editor-fold>
  private void addFakeParenthesis(FormatToken /*P*/ Start, prec.Level Precedence) {
    Start.FakeLParens.push_back(Precedence);
    if (Precedence.getValue() > prec.Level.Unknown.getValue()) {
      Start.StartsBinaryExpression = true;
    }
    if ((Current != null)) {
      FormatToken /*P*/ Previous = Current.Previous;
      while (Previous.is_TokenKind(tok.TokenKind.comment) && (Previous.Previous != null)) {
        Previous = Previous.Previous;
      }
      ++Previous.FakeRParens;
      if (Precedence.getValue() > prec.Level.Unknown.getValue()) {
        Previous.EndsBinaryExpression = true;
      }
    }
  }

  
  /// \brief Parse unary operator expressions and surround them with fake
  /// parentheses if appropriate.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::ExpressionParser::parseUnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1500,
   FQN="clang::format::(anonymous namespace)::ExpressionParser::parseUnaryOperator", NM="_ZN5clang6format12_GLOBAL__N_116ExpressionParser18parseUnaryOperatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116ExpressionParser18parseUnaryOperatorEv")
  //</editor-fold>
  private void parseUnaryOperator() {
    if (!(Current != null) || Current.isNot(TokenType.TT_UnaryOperator)) {
      parse(PrecedenceArrowAndPeriod);
      return;
    }
    
    FormatToken /*P*/ Start = Current;
    next();
    parseUnaryOperator();
    
    // The actual precedence doesn't matter.
    addFakeParenthesis(Start, prec.Level.Unknown);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::ExpressionParser::parseConditionalExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1514,
   FQN="clang::format::(anonymous namespace)::ExpressionParser::parseConditionalExpr", NM="_ZN5clang6format12_GLOBAL__N_116ExpressionParser20parseConditionalExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116ExpressionParser20parseConditionalExprEv")
  //</editor-fold>
  private void parseConditionalExpr() {
    while ((Current != null) && Current.isTrailingComment()) {
      next();
    }
    FormatToken /*P*/ Start = Current;
    parse(prec.Level.LogicalOr.getValue());
    if (!(Current != null) || !Current.is_TokenKind(tok.TokenKind.question)) {
      return;
    }
    next();
    parse(prec.Level.Assignment.getValue());
    if (!(Current != null) || Current.isNot(TokenType.TT_ConditionalExpr)) {
      return;
    }
    next();
    parse(prec.Level.Assignment.getValue());
    addFakeParenthesis(Start, prec.Level.Conditional);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::ExpressionParser::next">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1531,
   FQN="clang::format::(anonymous namespace)::ExpressionParser::next", NM="_ZN5clang6format12_GLOBAL__N_116ExpressionParser4nextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format12_GLOBAL__N_116ExpressionParser4nextEb")
  //</editor-fold>
  private void next() {
    next(true);
  }
  private void next(boolean SkipPastLeadingComments/*= true*/) {
    if ((Current != null)) {
      Current = Current.Next;
    }
    while ((Current != null)
       && (Current.NewlinesBefore == 0 || SkipPastLeadingComments)
       && Current.isTrailingComment()) {
      Current = Current.Next;
    }
  }

  
  private final /*const*/ FormatStyle /*&*/ Style;
  private final /*const*/ AdditionalKeywords /*&*/ Keywords;
  private FormatToken /*P*/ Current;
  
  @Override public String toString() {
    return "" + "Style=" + Style // NOI18N
              + ", Keywords=" + Keywords // NOI18N
              + ", Current=" + Current; // NOI18N
  }
}
