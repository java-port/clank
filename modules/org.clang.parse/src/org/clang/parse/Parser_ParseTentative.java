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
package org.clang.parse;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.sema.*;
import org.clang.parse.*;
import org.clang.parse.impl.*;
import static org.clang.parse.Parser.*;


//<editor-fold defaultstate="collapsed" desc="static type Parser_ParseTentative">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType -split-class=clang::Parser@this -extends=Parser_ParseTemplate ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser11isCXXTypeIdENS0_25TentativeCXXTypeIdContextERb;_ZN5clang6Parser18TryParseDeclaratorEbb;_ZN5clang6Parser18TryParseOperatorIdEv;_ZN5clang6Parser21isTentativelyDeclaredEPNS_14IdentifierInfoE;_ZN5clang6Parser22TryParsePtrOperatorSeqEv;_ZN5clang6Parser22isCXXSimpleDeclarationEb;_ZN5clang6Parser23TryParseTypeofSpecifierEv;_ZN5clang6Parser23isCXXFunctionDeclaratorEPb;_ZN5clang6Parser25TryParseBracketDeclaratorEv;_ZN5clang6Parser25TryParseSimpleDeclarationEb;_ZN5clang6Parser25isCXX11AttributeSpecifierEbb;_ZN5clang6Parser25isCXXDeclarationSpecifierENS0_8TPResultEPb;_ZN5clang6Parser25isCXXDeclarationStatementEv;_ZN5clang6Parser26TryParseFunctionDeclaratorEv;_ZN5clang6Parser26TryParseInitDeclaratorListEv;_ZN5clang6Parser26TryParseProtocolQualifiersEv;_ZN5clang6Parser30TryConsumeDeclarationSpecifierEv;_ZN5clang6Parser30isCXXDeclarationSpecifierATypeEv;_ZN5clang6Parser33isExpressionOrTypeSpecifierSimpleENS_3tok9TokenKindE;_ZN5clang6Parser34TryParseParameterDeclarationClauseEPbb;_ZN5clang6Parser40isCXXConditionDeclarationOrInitStatementEb; -static-type=Parser_ParseTentative -package=org.clang.parse")
//</editor-fold>
public class Parser_ParseTentative extends Parser_ParseTemplate {
private final /*split clang::Parser*/ Parser $this() { return (Parser)this; }


/// isCXXDeclarationStatement - C++-specialized function that disambiguates
/// between a declaration or an expression statement, when parsing function
/// bodies. Returns true for declaration, false for expression.

/// isCXXDeclarationStatement - C++-specialized function that disambiguates
/// between a declaration or an expression statement, when parsing function
/// bodies. Returns true for declaration, false for expression.
///
///         declaration-statement:
///           block-declaration
///
///         block-declaration:
///           simple-declaration
///           asm-definition
///           namespace-alias-definition
///           using-declaration
///           using-directive
/// [C++0x]   static_assert-declaration
///
///         asm-definition:
///           'asm' '(' string-literal ')' ';'
///
///         namespace-alias-definition:
///           'namespace' identifier = qualified-namespace-specifier ';'
///
///         using-declaration:
///           'using' typename[opt] '::'[opt] nested-name-specifier
///                 unqualified-id ';'
///           'using' '::' unqualified-id ;
///
///         using-directive:
///           'using' 'namespace' '::'[opt] nested-name-specifier[opt]
///                 namespace-name ';'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isCXXDeclarationStatement">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 50,
   FQN="clang::Parser::isCXXDeclarationStatement", NM="_ZN5clang6Parser25isCXXDeclarationStatementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser25isCXXDeclarationStatementEv")
  //</editor-fold>
  protected /*private*/ boolean isCXXDeclarationStatement() {
    switch ($this().Tok.getKind()) {
     case tok.TokenKind.kw_asm:
     case tok.TokenKind.kw_namespace:
     case tok.TokenKind.kw_using:
     case tok.TokenKind.kw_static_assert:
     case tok.TokenKind.kw__Static_assert:
      // static_assert-declaration
      return true;
     default:
      // simple-declaration
      return $this().isCXXSimpleDeclaration(/*AllowForRangeDecl=*/ false);
    }
  }


/// isCXXSimpleDeclaration - C++-specialized function that disambiguates
/// between a simple-declaration or an expression-statement.
/// If during the disambiguation process a parsing error is encountered,
/// the function returns true to let the declaration parsing code handle it.
/// Returns false if the statement is disambiguated as expression.

/// isCXXSimpleDeclaration - C++-specialized function that disambiguates
/// between a simple-declaration or an expression-statement.
/// If during the disambiguation process a parsing error is encountered,
/// the function returns true to let the declaration parsing code handle it.
/// Returns false if the statement is disambiguated as expression.
///
/// simple-declaration:
///   decl-specifier-seq init-declarator-list[opt] ';'
///
/// (if AllowForRangeDecl specified)
/// for ( for-range-declaration : for-range-initializer ) statement
/// for-range-declaration: 
///    attribute-specifier-seqopt type-specifier-seq declarator
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isCXXSimpleDeclaration">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 82,
   FQN="clang::Parser::isCXXSimpleDeclaration", NM="_ZN5clang6Parser22isCXXSimpleDeclarationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser22isCXXSimpleDeclarationEb")
  //</editor-fold>
  protected /*private*/ boolean isCXXSimpleDeclaration(boolean AllowForRangeDecl) {
    // C++ 6.8p1:
    // There is an ambiguity in the grammar involving expression-statements and
    // declarations: An expression-statement with a function-style explicit type
    // conversion (5.2.3) as its leftmost subexpression can be indistinguishable
    // from a declaration where the first declarator starts with a '('. In those
    // cases the statement is a declaration. [Note: To disambiguate, the whole
    // statement might have to be examined to determine if it is an
    // expression-statement or a declaration].
    
    // C++ 6.8p3:
    // The disambiguation is purely syntactic; that is, the meaning of the names
    // occurring in such a statement, beyond whether they are type-names or not,
    // is not generally used in or changed by the disambiguation. Class
    // templates are instantiated as necessary to determine if a qualified name
    // is a type-name. Disambiguation precedes parsing, and a statement
    // disambiguated as a declaration may be an ill-formed declaration.
    
    // We don't have to parse all of the decl-specifier-seq part. There's only
    // an ambiguity if the first decl-specifier is
    // simple-type-specifier/typename-specifier followed by a '(', which may
    // indicate a function-style cast expression.
    // isCXXDeclarationSpecifier will return TPResult::Ambiguous only in such
    // a case.
    bool$ptr InvalidAsDeclaration = create_bool$ptr(false);
    TPResult TPR = $this().isCXXDeclarationSpecifier(TPResult.False, 
        $AddrOf(InvalidAsDeclaration));
    if (TPR != TPResult.Ambiguous) {
      return TPR != TPResult.False; // Returns true for TPResult::True or
      // TPResult::Error.
    }
    
    // FIXME: TryParseSimpleDeclaration doesn't look past the first initializer,
    // and so gets some cases wrong. We can't carry on if we've already seen
    // something which makes this statement invalid as a declaration in this case,
    // since it can cause us to misparse valid code. Revisit this once
    // TryParseInitDeclaratorList is fixed.
    if (InvalidAsDeclaration.$star()) {
      return false;
    }
    {
      RevertingTentativeParsingAction PA = null;
      try {
        PA/*J*/= new RevertingTentativeParsingAction(/*Deref*/$this());
        TPR = $this().TryParseSimpleDeclaration(AllowForRangeDecl);
      } finally {
        if (PA != null) { PA.$destroy(); }
      }
    }
    
    // In case of an error, let the declaration parsing code handle it.
    if (TPR == TPResult.Error) {
      return true;
    }
    
    // Declarations take precedence over expressions.
    if (TPR == TPResult.Ambiguous) {
      TPR = TPResult.True;
    }
    assert (TPR == TPResult.True || TPR == TPResult.False);
    return TPR == TPResult.True;
  }


/// isCXXFunctionDeclarator - Disambiguates between a function declarator or
/// a constructor-style initializer, when parsing declaration statements.
/// Returns true for function declarator and false for constructor-style
/// initializer. Sets 'IsAmbiguous' to true to indicate that this declaration 
/// might be a constructor-style initializer.
/// If during the disambiguation process a parsing error is encountered,
/// the function returns true to let the declaration parsing code handle it.

/// isCXXFunctionDeclarator - Disambiguates between a function declarator or
/// a constructor-style initializer, when parsing declaration statements.
/// Returns true for function declarator and false for constructor-style
/// initializer.
/// If during the disambiguation process a parsing error is encountered,
/// the function returns true to let the declaration parsing code handle it.
///
/// '(' parameter-declaration-clause ')' cv-qualifier-seq[opt]
///         exception-specification[opt]
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isCXXFunctionDeclarator">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 1657,
   FQN="clang::Parser::isCXXFunctionDeclarator", NM="_ZN5clang6Parser23isCXXFunctionDeclaratorEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser23isCXXFunctionDeclaratorEPb")
  //</editor-fold>
  protected /*private*/ boolean isCXXFunctionDeclarator() {
    return $this().isCXXFunctionDeclarator((bool$ptr/*bool P*/ )null);
  }
  protected /*private*/ boolean isCXXFunctionDeclarator(bool$ptr/*bool P*/ IsAmbiguous/*= null*/) {
    RevertingTentativeParsingAction PA = null;
    try {
      
      // C++ 8.2p1:
      // The ambiguity arising from the similarity between a function-style cast and
      // a declaration mentioned in 6.8 can also occur in the context of a
      // declaration. In that context, the choice is between a function declaration
      // with a redundant set of parentheses around a parameter name and an object
      // declaration with a function-style cast as the initializer. Just as for the
      // ambiguities mentioned in 6.8, the resolution is to consider any construct
      // that could possibly be a declaration a declaration.
      PA/*J*/= new RevertingTentativeParsingAction(/*Deref*/$this());
      
      $this().ConsumeParen();
      bool$ptr InvalidAsDeclaration = create_bool$ptr(false);
      TPResult TPR = $this().TryParseParameterDeclarationClause($AddrOf(InvalidAsDeclaration));
      if (TPR == TPResult.Ambiguous) {
        if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
          TPR = TPResult.False;
        } else {
          final /*const*/ Token /*&*/ Next = $this().NextToken();
          if (Next.isOneOf$T(tok.TokenKind.amp, tok.TokenKind.ampamp, tok.TokenKind.kw_const, tok.TokenKind.kw_volatile, 
              tok.TokenKind.kw_throw, tok.TokenKind.kw_noexcept, tok.TokenKind.l_square, 
              tok.TokenKind.l_brace, tok.TokenKind.kw_try, tok.TokenKind.equal, tok.TokenKind.arrow)
             || ($this().isCXX11VirtSpecifier(Next).getValue() != 0)) {
            // The next token cannot appear after a constructor-style initializer,
            // and can appear next in a function definition. This must be a function
            // declarator.
            TPR = TPResult.True;
          } else if (InvalidAsDeclaration.$star()) {
            // Use the absence of 'typename' as a tie-breaker.
            TPR = TPResult.False;
          }
        }
      }
      if ((IsAmbiguous != null) && TPR == TPResult.Ambiguous) {
        IsAmbiguous.$set(true);
      }
      
      // In case of an error, let the declaration parsing code handle it.
      return TPR != TPResult.False;
    } finally {
      if (PA != null) { PA.$destroy(); }
    }
  }

/// \brief Disambiguates between the different kinds of things that can happen
/// after 'if (' or 'switch ('. This could be one of two different kinds of
/// declaration (depending on whether there is a ';' later) or an expression.

/// \brief Disambiguates between a declaration in a condition, a
/// simple-declaration in an init-statement, and an expression for
/// a condition of a if/switch statement.
///
///       condition:
///         expression
///         type-specifier-seq declarator '=' assignment-expression
/// [C++11] type-specifier-seq declarator '=' initializer-clause
/// [C++11] type-specifier-seq declarator braced-init-list
/// [GNU]   type-specifier-seq declarator simple-asm-expr[opt] attributes[opt]
///             '=' assignment-expression
///       simple-declaration:
///         decl-specifier-seq init-declarator-list[opt] ';'
///
/// Note that, unlike isCXXSimpleDeclaration, we must disambiguate all the way
/// to the ';' to disambiguate cases like 'int(x))' (an expression) from
/// 'int(x);' (a simple-declaration in an init-statement).
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isCXXConditionDeclarationOrInitStatement">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 411,
   FQN="clang::Parser::isCXXConditionDeclarationOrInitStatement", NM="_ZN5clang6Parser40isCXXConditionDeclarationOrInitStatementEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser40isCXXConditionDeclarationOrInitStatementEb")
  //</editor-fold>
  protected /*private*/ Parser.ConditionOrInitStatement isCXXConditionDeclarationOrInitStatement(boolean CanBeInitStatement) {
    RevertingTentativeParsingAction PA = null;
    try {
      ConditionDeclarationOrInitStatementState State/*J*/= new ConditionDeclarationOrInitStatementState(/*Deref*/$this(), CanBeInitStatement);
      if (State.update($this().isCXXDeclarationSpecifier())) {
        return State.result();
      }
      
      // It might be a declaration; we need tentative parsing.
      PA/*J*/= new RevertingTentativeParsingAction(/*Deref*/$this());
      
      // FIXME: A tag definition unambiguously tells us this is an init-statement.
      if (State.update($this().TryConsumeDeclarationSpecifier())) {
        return State.result();
      }
      assert ($this().Tok.is(tok.TokenKind.l_paren)) : "Expected '('";
      while (true) {
        // Consume a declarator.
        if (State.update($this().TryParseDeclarator(false/*mayBeAbstract*/))) {
          return State.result();
        }
        
        // Attributes, asm label, or an initializer imply this is not an expression.
        // FIXME: Disambiguate properly after an = instead of assuming that it's a
        // valid declaration.
        if ($this().Tok.isOneOf$T(tok.TokenKind.equal, tok.TokenKind.kw_asm, tok.TokenKind.kw___attribute)
           || ($this().getLangOpts().CPlusPlus11 && $this().Tok.is(tok.TokenKind.l_brace))) {
          State.markNotExpression();
          return State.result();
        }
        
        // At this point, it can't be a condition any more, because a condition
        // must have a brace-or-equal-initializer.
        if (State.markNotCondition()) {
          return State.result();
        }
        
        // A parenthesized initializer could be part of an expression or a
        // simple-declaration.
        if ($this().Tok.is(tok.TokenKind.l_paren)) {
          $this().ConsumeParen();
          $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
        }
        if (!$this().TryConsumeToken(tok.TokenKind.comma)) {
          break;
        }
      }
      
      // We reached the end. If it can now be some kind of decl, then it is.
      if (State.CanBeCondition && $this().Tok.is(tok.TokenKind.r_paren)) {
        return ConditionOrInitStatement.ConditionDecl;
      } else if (State.CanBeInitStatement && $this().Tok.is(tok.TokenKind.semi)) {
        return ConditionOrInitStatement.InitStmtDecl;
      } else {
        return ConditionOrInitStatement.Expression;
      }
    } finally {
      if (PA != null) { PA.$destroy(); }
    }
  }


/// \brief Determine whether the next set of tokens contains a type-id.
///
/// The context parameter states what context we're parsing right
/// now, which affects how this routine copes with the token
/// following the type-id. If the context is TypeIdInParens, we have
/// already parsed the '(' and we will cease lookahead when we hit
/// the corresponding ')'. If the context is
/// TypeIdAsTemplateArgument, we've already parsed the '<' or ','
/// before this template argument, and will cease lookahead when we
/// hit a '>', '>>' (in C++0x), or ','. Returns true for a type-id
/// and false for an expression.  If during the disambiguation
/// process a parsing error is encountered, the function returns
/// true to let the declaration parsing code handle it.
///
/// type-id:
///   type-specifier-seq abstract-declarator[opt]
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isCXXTypeId">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 482,
   FQN="clang::Parser::isCXXTypeId", NM="_ZN5clang6Parser11isCXXTypeIdENS0_25TentativeCXXTypeIdContextERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser11isCXXTypeIdENS0_25TentativeCXXTypeIdContextERb")
  //</editor-fold>
  protected /*private*/ boolean isCXXTypeId(TentativeCXXTypeIdContext Context, final bool$ref/*bool &*/ isAmbiguous) {
    RevertingTentativeParsingAction PA = null;
    try {
      
      isAmbiguous.$set(false);
      
      // C++ 8.2p2:
      // The ambiguity arising from the similarity between a function-style cast and
      // a type-id can occur in different contexts. The ambiguity appears as a
      // choice between a function-style cast expression and a declaration of a
      // type. The resolution is that any construct that could possibly be a type-id
      // in its syntactic context shall be considered a type-id.
      TPResult TPR = $this().isCXXDeclarationSpecifier();
      if (TPR != TPResult.Ambiguous) {
        return TPR != TPResult.False; // Returns true for TPResult::True or
        // TPResult::Error.
      }
      
      // FIXME: Add statistics about the number of ambiguous statements encountered
      // and how they were resolved (number of declarations+number of expressions).
      
      // Ok, we have a simple-type-specifier/typename-specifier followed by a '('.
      // We need tentative parsing...
      PA/*J*/= new RevertingTentativeParsingAction(/*Deref*/$this());
      
      // type-specifier-seq
      $this().TryConsumeDeclarationSpecifier();
      assert ($this().Tok.is(tok.TokenKind.l_paren)) : "Expected '('";
      
      // declarator
      TPR = $this().TryParseDeclarator(true/*mayBeAbstract*/, false/*mayHaveIdentifier*/);
      
      // In case of an error, let the declaration parsing code handle it.
      if (TPR == TPResult.Error) {
        TPR = TPResult.True;
      }
      if (TPR == TPResult.Ambiguous) {
        // We are supposed to be inside parens, so if after the abstract declarator
        // we encounter a ')' this is a type-id, otherwise it's an expression.
        if (Context == TentativeCXXTypeIdContext.TypeIdInParens && $this().Tok.is(tok.TokenKind.r_paren)) {
          TPR = TPResult.True;
          isAmbiguous.$set(true);
          // We are supposed to be inside a template argument, so if after
          // the abstract declarator we encounter a '>', '>>' (in C++0x), or
          // ',', this is a type-id. Otherwise, it's an expression.
        } else if (Context == TentativeCXXTypeIdContext.TypeIdAsTemplateArgument
           && ($this().Tok.isOneOf(tok.TokenKind.greater, tok.TokenKind.comma)
           || ($this().getLangOpts().CPlusPlus11 && $this().Tok.is(tok.TokenKind.greatergreater)))) {
          TPR = TPResult.True;
          isAmbiguous.$set(true);
        } else {
          TPR = TPResult.False;
        }
      }
      assert (TPR == TPResult.True || TPR == TPResult.False);
      return TPR == TPResult.True;
    } finally {
      if (PA != null) { PA.$destroy(); }
    }
  }


/// \brief Based only on the given token kind, determine whether we know that
/// we're at the start of an expression or a type-specifier-seq (which may
/// be an expression, in C++).
///
/// This routine does not attempt to resolve any of the trick cases, e.g.,
/// those involving lookup of identifiers.
///
/// \returns \c TPR_true if this token starts an expression, \c TPR_false if
/// this token starts a type-specifier-seq, or \c TPR_ambiguous if it cannot
/// tell.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isExpressionOrTypeSpecifierSimple">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 952,
   FQN="clang::Parser::isExpressionOrTypeSpecifierSimple", NM="_ZN5clang6Parser33isExpressionOrTypeSpecifierSimpleENS_3tok9TokenKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser33isExpressionOrTypeSpecifierSimpleENS_3tok9TokenKindE")
  //</editor-fold>
  protected /*private*/ Parser.TPResult isExpressionOrTypeSpecifierSimple(/*tok.TokenKind*/char Kind) {
    switch (Kind) {
     case tok.TokenKind.numeric_constant:
     case tok.TokenKind.char_constant:
     case tok.TokenKind.wide_char_constant:
     case tok.TokenKind.utf8_char_constant:
     case tok.TokenKind.utf16_char_constant:
     case tok.TokenKind.utf32_char_constant:
     case tok.TokenKind.string_literal:
     case tok.TokenKind.wide_string_literal:
     case tok.TokenKind.utf8_string_literal:
     case tok.TokenKind.utf16_string_literal:
     case tok.TokenKind.utf32_string_literal:
     case tok.TokenKind.l_square:
     case tok.TokenKind.l_paren:
     case tok.TokenKind.amp:
     case tok.TokenKind.ampamp:
     case tok.TokenKind.star:
     case tok.TokenKind.plus:
     case tok.TokenKind.plusplus:
     case tok.TokenKind.minus:
     case tok.TokenKind.minusminus:
     case tok.TokenKind.tilde:
     case tok.TokenKind.exclaim:
     case tok.TokenKind.kw_sizeof:
     case tok.TokenKind.kw___func__:
     case tok.TokenKind.kw_const_cast:
     case tok.TokenKind.kw_delete:
     case tok.TokenKind.kw_dynamic_cast:
     case tok.TokenKind.kw_false:
     case tok.TokenKind.kw_new:
     case tok.TokenKind.kw_operator:
     case tok.TokenKind.kw_reinterpret_cast:
     case tok.TokenKind.kw_static_cast:
     case tok.TokenKind.kw_this:
     case tok.TokenKind.kw_throw:
     case tok.TokenKind.kw_true:
     case tok.TokenKind.kw_typeid:
     case tok.TokenKind.kw_alignof:
     case tok.TokenKind.kw_noexcept:
     case tok.TokenKind.kw_nullptr:
     case tok.TokenKind.kw__Alignof:
     case tok.TokenKind.kw___null:
     case tok.TokenKind.kw___alignof:
     case tok.TokenKind.kw___builtin_choose_expr:
     case tok.TokenKind.kw___builtin_offsetof:
     case tok.TokenKind.kw___builtin_va_arg:
     case tok.TokenKind.kw___imag:
     case tok.TokenKind.kw___real:
     case tok.TokenKind.kw___FUNCTION__:
     case tok.TokenKind.kw___FUNCDNAME__:
     case tok.TokenKind.kw___FUNCSIG__:
     case tok.TokenKind.kw_L__FUNCTION__:
     case tok.TokenKind.kw___PRETTY_FUNCTION__:
     case tok.TokenKind.kw___uuidof:
     case tok.TokenKind.kw___builtin_types_compatible_p:
     case tok.TokenKind.kw___is_interface_class:
     case tok.TokenKind.kw___is_sealed:
     case tok.TokenKind.kw___is_destructible:
     case tok.TokenKind.kw___is_nothrow_destructible:
     case tok.TokenKind.kw___is_nothrow_assignable:
     case tok.TokenKind.kw___is_constructible:
     case tok.TokenKind.kw___is_nothrow_constructible:
     case tok.TokenKind.kw___is_assignable:
     case tok.TokenKind.kw___has_nothrow_assign:
     case tok.TokenKind.kw___has_nothrow_move_assign:
     case tok.TokenKind.kw___has_nothrow_copy:
     case tok.TokenKind.kw___has_nothrow_constructor:
     case tok.TokenKind.kw___has_trivial_assign:
     case tok.TokenKind.kw___has_trivial_move_assign:
     case tok.TokenKind.kw___has_trivial_copy:
     case tok.TokenKind.kw___has_trivial_constructor:
     case tok.TokenKind.kw___has_trivial_move_constructor:
     case tok.TokenKind.kw___has_trivial_destructor:
     case tok.TokenKind.kw___has_virtual_destructor:
     case tok.TokenKind.kw___is_abstract:
     case tok.TokenKind.kw___is_base_of:
     case tok.TokenKind.kw___is_class:
     case tok.TokenKind.kw___is_convertible_to:
     case tok.TokenKind.kw___is_empty:
     case tok.TokenKind.kw___is_enum:
     case tok.TokenKind.kw___is_final:
     case tok.TokenKind.kw___is_literal:
     case tok.TokenKind.kw___is_pod:
     case tok.TokenKind.kw___is_polymorphic:
     case tok.TokenKind.kw___is_trivial:
     case tok.TokenKind.kw___is_union:
     case tok.TokenKind.kw___is_trivially_constructible:
     case tok.TokenKind.kw___is_trivially_copyable:
     case tok.TokenKind.kw___is_trivially_assignable:
     case tok.TokenKind.kw___is_arithmetic:
     case tok.TokenKind.kw___is_floating_point:
     case tok.TokenKind.kw___is_integral:
     case tok.TokenKind.kw___is_complete_type:
     case tok.TokenKind.kw___is_void:
     case tok.TokenKind.kw___is_array:
     case tok.TokenKind.kw___is_function:
     case tok.TokenKind.kw___is_reference:
     case tok.TokenKind.kw___is_lvalue_reference:
     case tok.TokenKind.kw___is_rvalue_reference:
     case tok.TokenKind.kw___is_fundamental:
     case tok.TokenKind.kw___is_object:
     case tok.TokenKind.kw___is_scalar:
     case tok.TokenKind.kw___is_compound:
     case tok.TokenKind.kw___is_pointer:
     case tok.TokenKind.kw___is_member_object_pointer:
     case tok.TokenKind.kw___is_member_function_pointer:
     case tok.TokenKind.kw___is_member_pointer:
     case tok.TokenKind.kw___is_const:
     case tok.TokenKind.kw___is_volatile:
     case tok.TokenKind.kw___is_standard_layout:
     case tok.TokenKind.kw___is_signed:
     case tok.TokenKind.kw___is_unsigned:
     case tok.TokenKind.kw___is_same:
     case tok.TokenKind.kw___is_convertible:
      return TPResult.True;
     case tok.TokenKind.kw_char:
     case tok.TokenKind.kw_const:
     case tok.TokenKind.kw_double:
     case tok.TokenKind.kw___float128:
     case tok.TokenKind.kw_enum:
     case tok.TokenKind.kw_half:
     case tok.TokenKind.kw_float:
     case tok.TokenKind.kw_int:
     case tok.TokenKind.kw_long:
     case tok.TokenKind.kw___int64:
     case tok.TokenKind.kw___int128:
     case tok.TokenKind.kw_restrict:
     case tok.TokenKind.kw_short:
     case tok.TokenKind.kw_signed:
     case tok.TokenKind.kw_struct:
     case tok.TokenKind.kw_union:
     case tok.TokenKind.kw_unsigned:
     case tok.TokenKind.kw_void:
     case tok.TokenKind.kw_volatile:
     case tok.TokenKind.kw__Bool:
     case tok.TokenKind.kw__Complex:
     case tok.TokenKind.kw_class:
     case tok.TokenKind.kw_typename:
     case tok.TokenKind.kw_wchar_t:
     case tok.TokenKind.kw_char16_t:
     case tok.TokenKind.kw_char32_t:
     case tok.TokenKind.kw__Decimal32:
     case tok.TokenKind.kw__Decimal64:
     case tok.TokenKind.kw__Decimal128:
     case tok.TokenKind.kw___interface:
     case tok.TokenKind.kw___thread:
     case tok.TokenKind.kw_thread_local:
     case tok.TokenKind.kw__Thread_local:
     case tok.TokenKind.kw_typeof:
     case tok.TokenKind.kw___underlying_type:
     case tok.TokenKind.kw___cdecl:
     case tok.TokenKind.kw___stdcall:
     case tok.TokenKind.kw___fastcall:
     case tok.TokenKind.kw___thiscall:
     case tok.TokenKind.kw___vectorcall:
     case tok.TokenKind.kw___unaligned:
     case tok.TokenKind.kw___vector:
     case tok.TokenKind.kw___pixel:
     case tok.TokenKind.kw___bool:
     case tok.TokenKind.kw__Atomic:
     case tok.TokenKind.kw_image1d_t:
     case tok.TokenKind.kw_image1d_array_t:
     case tok.TokenKind.kw_image1d_buffer_t:
     case tok.TokenKind.kw_image2d_t:
     case tok.TokenKind.kw_image2d_array_t:
     case tok.TokenKind.kw_image2d_depth_t:
     case tok.TokenKind.kw_image2d_array_depth_t:
     case tok.TokenKind.kw_image2d_msaa_t:
     case tok.TokenKind.kw_image2d_array_msaa_t:
     case tok.TokenKind.kw_image2d_msaa_depth_t:
     case tok.TokenKind.kw_image2d_array_msaa_depth_t:
     case tok.TokenKind.kw_image3d_t:
     case tok.TokenKind.kw___unknown_anytype:
      return TPResult.False;
     default:
      break;
    }
    
    return TPResult.Ambiguous;
  }


/// isCXXDeclarationSpecifier - Returns TPResult::True if it is a
/// declaration specifier, TPResult::False if it is not,
/// TPResult::Ambiguous if it could be either a decl-specifier or a
/// function-style cast, and TPResult::Error if a parsing error was
/// encountered. If it could be a braced C++11 function-style cast, returns
/// BracedCastResult.
/// Doesn't consume tokens.
/// isCXXDeclarationSpecifier - Returns TPResult::True if it is a declaration
/// specifier, TPResult::False if it is not, TPResult::Ambiguous if it could
/// be either a decl-specifier or a function-style cast, and TPResult::Error
/// if a parsing error was found and reported.
///
/// If HasMissingTypename is provided, a name with a dependent scope specifier
/// will be treated as ambiguous if the 'typename' keyword is missing. If this
/// happens, *HasMissingTypename will be set to 'true'. This will also be used
/// as an indicator that undeclared identifiers (which will trigger a later
/// parse error) should be treated as types. Returns TPResult::Ambiguous in
/// such cases.
///
///         decl-specifier:
///           storage-class-specifier
///           type-specifier
///           function-specifier
///           'friend'
///           'typedef'
/// [C++11]   'constexpr'
/// [GNU]     attributes declaration-specifiers[opt]
///
///         storage-class-specifier:
///           'register'
///           'static'
///           'extern'
///           'mutable'
///           'auto'
/// [GNU]     '__thread'
/// [C++11]   'thread_local'
/// [C11]     '_Thread_local'
///
///         function-specifier:
///           'inline'
///           'virtual'
///           'explicit'
///
///         typedef-name:
///           identifier
///
///         type-specifier:
///           simple-type-specifier
///           class-specifier
///           enum-specifier
///           elaborated-type-specifier
///           typename-specifier
///           cv-qualifier
///
///         simple-type-specifier:
///           '::'[opt] nested-name-specifier[opt] type-name
///           '::'[opt] nested-name-specifier 'template'
///                 simple-template-id                              [TODO]
///           'char'
///           'wchar_t'
///           'bool'
///           'short'
///           'int'
///           'long'
///           'signed'
///           'unsigned'
///           'float'
///           'double'
///           'void'
/// [GNU]     typeof-specifier
/// [GNU]     '_Complex'
/// [C++11]   'auto'
/// [GNU]     '__auto_type'
/// [C++11]   'decltype' ( expression )
/// [C++1y]   'decltype' ( 'auto' )
///
///         type-name:
///           class-name
///           enum-name
///           typedef-name
///
///         elaborated-type-specifier:
///           class-key '::'[opt] nested-name-specifier[opt] identifier
///           class-key '::'[opt] nested-name-specifier[opt] 'template'[opt]
///               simple-template-id
///           'enum' '::'[opt] nested-name-specifier[opt] identifier
///
///         enum-name:
///           identifier
///
///         enum-specifier:
///           'enum' identifier[opt] '{' enumerator-list[opt] '}'
///           'enum' identifier[opt] '{' enumerator-list ',' '}'
///
///         class-specifier:
///           class-head '{' member-specification[opt] '}'
///
///         class-head:
///           class-key identifier[opt] base-clause[opt]
///           class-key nested-name-specifier identifier base-clause[opt]
///           class-key nested-name-specifier[opt] simple-template-id
///               base-clause[opt]
///
///         class-key:
///           'class'
///           'struct'
///           'union'
///
///         cv-qualifier:
///           'const'
///           'volatile'
/// [GNU]     restrict
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isCXXDeclarationSpecifier">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*GO TO SPECIAL C&P SECTION*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 1205,
   FQN="clang::Parser::isCXXDeclarationSpecifier", NM="_ZN5clang6Parser25isCXXDeclarationSpecifierENS0_8TPResultEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser25isCXXDeclarationSpecifierENS0_8TPResultEPb")
  //</editor-fold>
  protected /*private*/ Parser.TPResult isCXXDeclarationSpecifier() {
    return $this().isCXXDeclarationSpecifier(TPResult.False, 
                           (bool$ptr/*bool P*/ )null);
  }
  protected /*private*/ Parser.TPResult isCXXDeclarationSpecifier(Parser.TPResult BracedCastResult/*= TPResult::False*/) {
    return $this().isCXXDeclarationSpecifier(BracedCastResult, 
                           (bool$ptr/*bool P*/ )null);
  }
  protected /*private*/ Parser.TPResult isCXXDeclarationSpecifier(Parser.TPResult BracedCastResult/*= TPResult::False*/, 
                           bool$ptr/*bool P*/ HasMissingTypename/*= null*/) {
    switch ($this().Tok.getKind()) {
     case tok.TokenKind.identifier:
      {
        // Check for need to substitute AltiVec __vector keyword
        // for "vector" identifier.
        if ($this().TryAltiVecVectorToken()) {
          return TPResult.True;
        }
        
        final /*const*/ Token /*&*/ Next = $this().NextToken();
        // In 'foo bar', 'foo' is always a type name outside of Objective-C.
        if (!$this().getLangOpts().ObjC1 && Next.is(tok.TokenKind.identifier)) {
          return TPResult.True;
        }
        if (Next.isNot(tok.TokenKind.coloncolon) && Next.isNot(tok.TokenKind.less)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Determine whether this is a valid expression. If not, we will hit
            // a parse error one way or another. In that case, tell the caller that
            // this is ambiguous. Typo-correct to type and expression keywords and
            // to types and identifiers, in order to try to recover from errors.
            switch (AnnotatedNameKind.valueOf($c$.clean($this().TryAnnotateName(false/* no nested name specifier */, 
                $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new TentativeParseCCC(Next)))))).getValue()))) {
             case ANK_Error:
              return TPResult.Error;
             case ANK_TentativeDecl:
              return TPResult.False;
             case ANK_TemplateName:
              // A bare type template-name which can't be a template template
              // argument is an error, and was probably intended to be a type.
              return $this().GreaterThanIsOperator ? TPResult.True : TPResult.False;
             case ANK_Unresolved:
              return (HasMissingTypename != null) ? TPResult.Ambiguous : TPResult.False;
             case ANK_Success:
              break;
            }
            assert ($this().Tok.isNot(tok.TokenKind.identifier)) : "TryAnnotateName succeeded without producing an annotation";
          } finally {
            $c$.$destroy();
          }
        } else {
          // This might possibly be a type with a dependent scope specifier and
          // a missing 'typename' keyword. Don't use TryAnnotateName in this case,
          // since it will annotate as a primary expression, and we want to use the
          // "missing 'typename'" logic.
          if ($this().TryAnnotateTypeOrScopeToken()) {
            return TPResult.Error;
          }
          // If annotation failed, assume it's a non-type.
          // FIXME: If this happens due to an undeclared identifier, treat it as
          // ambiguous.
          if ($this().Tok.is(tok.TokenKind.identifier)) {
            return TPResult.False;
          }
        }
        
        // We annotated this token as something. Recurse to handle whatever we got.
        return $this().isCXXDeclarationSpecifier(BracedCastResult, HasMissingTypename);
      }
     case tok.TokenKind.kw_typename: // typename T::type
      // Annotate typenames and C++ scope specifiers.  If we get one, just
      // recurse to handle whatever we get.
      if ($this().TryAnnotateTypeOrScopeToken()) {
        return TPResult.Error;
      }
      return $this().isCXXDeclarationSpecifier(BracedCastResult, HasMissingTypename);
     case tok.TokenKind.coloncolon:
      { // ::foo::bar
        final /*const*/ Token /*&*/ Next = $this().NextToken();
        if (Next.isOneOf(tok.TokenKind.kw_new,  // ::new
            tok.TokenKind.kw_delete)) { // ::delete
          return TPResult.False;
        }
      }
     case tok.TokenKind.kw___super:
     case tok.TokenKind.kw_decltype:
      // Annotate typenames and C++ scope specifiers.  If we get one, just
      // recurse to handle whatever we get.
      if ($this().TryAnnotateTypeOrScopeToken()) {
        return TPResult.Error;
      }
      return $this().isCXXDeclarationSpecifier(BracedCastResult, HasMissingTypename);
     case tok.TokenKind.kw_friend:
     case tok.TokenKind.kw_typedef:
     case tok.TokenKind.kw_constexpr:
     case tok.TokenKind.kw_concept:
     case tok.TokenKind.kw_register:
     case tok.TokenKind.kw_static:
     case tok.TokenKind.kw_extern:
     case tok.TokenKind.kw_mutable:
     case tok.TokenKind.kw_auto:
     case tok.TokenKind.kw___thread:
     case tok.TokenKind.kw_thread_local:
     case tok.TokenKind.kw__Thread_local:
     case tok.TokenKind.kw_inline:
     case tok.TokenKind.kw_virtual:
     case tok.TokenKind.kw_explicit:
     case tok.TokenKind.kw___module_private__:
     case tok.TokenKind.kw___unknown_anytype:
     case tok.TokenKind.kw_class:
     case tok.TokenKind.kw_struct:
     case tok.TokenKind.kw_union:
     case tok.TokenKind.kw___interface:
     case tok.TokenKind.kw_enum:
     case tok.TokenKind.kw_const:
     case tok.TokenKind.kw_volatile:
     case tok.TokenKind.kw_restrict:
     case tok.TokenKind.kw__Complex:
     case tok.TokenKind.kw___attribute:
     case tok.TokenKind.kw___auto_type:
      
      // GNU
      return TPResult.True;
     case tok.TokenKind.kw___declspec:
     case tok.TokenKind.kw___cdecl:
     case tok.TokenKind.kw___stdcall:
     case tok.TokenKind.kw___fastcall:
     case tok.TokenKind.kw___thiscall:
     case tok.TokenKind.kw___vectorcall:
     case tok.TokenKind.kw___w64:
     case tok.TokenKind.kw___sptr:
     case tok.TokenKind.kw___uptr:
     case tok.TokenKind.kw___ptr64:
     case tok.TokenKind.kw___ptr32:
     case tok.TokenKind.kw___forceinline:
     case tok.TokenKind.kw___unaligned:
     case tok.TokenKind.kw__Nonnull:
     case tok.TokenKind.kw__Nullable:
     case tok.TokenKind.kw__Null_unspecified:
     case tok.TokenKind.kw___kindof:
      
      // Microsoft
      return TPResult.True;
     case tok.TokenKind.kw___pascal:
      
      // Borland
      return TPResult.True;
     case tok.TokenKind.kw___vector:
      
      // AltiVec
      return TPResult.True;
     case tok.TokenKind.annot_template_id:
      {
        CXXScopeSpec SS = null;
        try {
          TemplateIdAnnotation /*P*/ TemplateId = $this().takeTemplateIdAnnotation($this().Tok);
          if (TemplateId.Kind != TemplateNameKind.TNK_Type_template) {
            return TPResult.False;
          }
          SS/*J*/= new CXXScopeSpec();
          $this().AnnotateTemplateIdTokenAsType();
          assert ($this().Tok.is(tok.TokenKind.annot_typename));
          /*goto case_typename;*/ // JAVA: moved out of try/finally and copy&pasted to simplify logic
        } finally {
          if (SS != null) { SS.$destroy(); }
        }
        // JAVA this is out of try/finally, beacuse case tok.TokenKind.annot_template_id: is in 
        // own compound statements. It means temporary SS must be destroyed before goto jump which was moved here
        //// GO TO REPLACEMENT ///////////////////////////
          /*goto case_typename;*/
          // JAVA: COPIED HERE FROM annot_typename INSTEAD OF GO TO
          // In Objective-C, we might have a protocol-qualified type.
          if ($this().getLangOpts().ObjC1 && $this().NextToken().is(tok.TokenKind.less)) {
            RevertingTentativeParsingAction PA = null;
            try {
              // Tentatively parse the protocol qualifiers.
              PA/*J*/= new RevertingTentativeParsingAction(/*Deref*/$this());
              $this().ConsumeToken(); // The type token

              TPResult TPR = $this().TryParseProtocolQualifiers();
              boolean isFollowedByParen = $this().Tok.is(tok.TokenKind.l_paren);
              boolean isFollowedByBrace = $this().Tok.is(tok.TokenKind.l_brace);
              if (TPR == TPResult.Error) {
                return TPResult.Error;
              }
              if (isFollowedByParen) {
                return TPResult.Ambiguous;
              }
              if ($this().getLangOpts().CPlusPlus11 && isFollowedByBrace) {
                return BracedCastResult;
              }

              return TPResult.True;
            } finally {
              if (PA != null) { PA.$destroy(); }
            }
          }  
          // JAVA: COPIED HERE FROM annot_decltype INSTEAD OF GO TO
          if ($this().NextToken().is(tok.TokenKind.l_paren)) {
            return TPResult.Ambiguous;
          }

          // This is a function-style cast in all cases we disambiguate other than
          // one:
          //   struct S {
          //     enum E : int { a = 4 }; // enum
          //     enum E : int { 4 };     // bit-field
          //   };
          if ($this().getLangOpts().CPlusPlus11 && $this().NextToken().is(tok.TokenKind.l_brace)) {
            return BracedCastResult;
          }
          if ($this().isStartOfObjCClassMessageMissingOpenBracket()) {
            return TPResult.False;
          }

          return TPResult.True;   
        //// END OF GO TO REPLACEMENT ///////////////////////////
      }
     case tok.TokenKind.annot_cxxscope: // foo::bar or ::foo::bar, but already parsed
      // We've already annotated a scope; try to annotate a type.
      if ($this().TryAnnotateTypeOrScopeToken()) {
        return TPResult.Error;
      }
      if (!$this().Tok.is(tok.TokenKind.annot_typename)) {
        // If the next token is an identifier or a type qualifier, then this
        // can't possibly be a valid expression either.
        if ($this().Tok.is(tok.TokenKind.annot_cxxscope) && $this().NextToken().is(tok.TokenKind.identifier)) {
          CXXScopeSpec SS = null;
          try {
            SS/*J*/= new CXXScopeSpec();
            $this().Actions.RestoreNestedNameSpecifierAnnotation($this().Tok.getAnnotationValue(), 
                $this().Tok.getAnnotationRange(), 
                SS);
            if ((SS.getScopeRep() != null) && SS.getScopeRep().isDependent()) {
              RevertingTentativeParsingAction PA = null;
              try {
                PA/*J*/= new RevertingTentativeParsingAction(/*Deref*/$this());
                $this().ConsumeToken();
                $this().ConsumeToken();
                boolean isIdentifier = $this().Tok.is(tok.TokenKind.identifier);
                TPResult TPR = TPResult.False;
                if (!isIdentifier) {
                  TPR = $this().isCXXDeclarationSpecifier(BracedCastResult, 
                      HasMissingTypename);
                }
                if (isIdentifier
                   || TPR == TPResult.True || TPR == TPResult.Error) {
                  return TPResult.Error;
                }
                if ((HasMissingTypename != null)) {
                  // We can't tell whether this is a missing 'typename' or a valid
                  // expression.
                  HasMissingTypename.$set(true);
                  return TPResult.Ambiguous;
                }
              } finally {
                if (PA != null) { PA.$destroy(); }
              }
              // FIXME: Fails to either revert or commit the tentative parse!
            } else {
              // Try to resolve the name. If it doesn't exist, assume it was
              // intended to name a type and keep disambiguating.
              switch (AnnotatedNameKind.valueOf($this().TryAnnotateName(false/* SS is not dependent */).getValue())) {
               case ANK_Error:
                return TPResult.Error;
               case ANK_TentativeDecl:
                return TPResult.False;
               case ANK_TemplateName:
                // A bare type template-name which can't be a template template
                // argument is an error, and was probably intended to be a type.
                return $this().GreaterThanIsOperator ? TPResult.True : TPResult.False;
               case ANK_Unresolved:
                return (HasMissingTypename != null) ? TPResult.Ambiguous : TPResult.False;
               case ANK_Success:
                // Annotated it, check again.
                assert ($this().Tok.isNot(tok.TokenKind.annot_cxxscope) || $this().NextToken().isNot(tok.TokenKind.identifier));
                return $this().isCXXDeclarationSpecifier(BracedCastResult, 
                    HasMissingTypename);
              }
            }
          } finally {
            if (SS != null) { SS.$destroy(); }
          }
        }
        return TPResult.False;
      }
     case tok.TokenKind.annot_typename:
     /*case_typename:*/ // WE COPIED ALL CODE FROM THIS SECTION AND THE SECTION UNDER annot_decltype into 'goto case_typename'
      // In Objective-C, we might have a protocol-qualified type.
      if ($this().getLangOpts().ObjC1 && $this().NextToken().is(tok.TokenKind.less)) {
        RevertingTentativeParsingAction PA = null;
        try {
          // Tentatively parse the protocol qualifiers.
          PA/*J*/= new RevertingTentativeParsingAction(/*Deref*/$this());
          $this().ConsumeToken(); // The type token
          
          TPResult TPR = $this().TryParseProtocolQualifiers();
          boolean isFollowedByParen = $this().Tok.is(tok.TokenKind.l_paren);
          boolean isFollowedByBrace = $this().Tok.is(tok.TokenKind.l_brace);
          if (TPR == TPResult.Error) {
            return TPResult.Error;
          }
          if (isFollowedByParen) {
            return TPResult.Ambiguous;
          }
          if ($this().getLangOpts().CPlusPlus11 && isFollowedByBrace) {
            return BracedCastResult;
          }
          
          return TPResult.True;
        } finally {
          if (PA != null) { PA.$destroy(); }
        }
      }
     case tok.TokenKind.kw_char:
     case tok.TokenKind.kw_wchar_t:
     case tok.TokenKind.kw_char16_t:
     case tok.TokenKind.kw_char32_t:
     case tok.TokenKind.kw_bool:
     case tok.TokenKind.kw_short:
     case tok.TokenKind.kw_int:
     case tok.TokenKind.kw_long:
     case tok.TokenKind.kw___int64:
     case tok.TokenKind.kw___int128:
     case tok.TokenKind.kw_signed:
     case tok.TokenKind.kw_unsigned:
     case tok.TokenKind.kw_half:
     case tok.TokenKind.kw_float:
     case tok.TokenKind.kw_double:
     case tok.TokenKind.kw___float128:
     case tok.TokenKind.kw_void:
     case tok.TokenKind.annot_decltype: // WE COPIED ALL CODE FROM THIS SECTION AND THE SECTION ABOVE (annot_typename) into 'goto case_typename'
      if ($this().NextToken().is(tok.TokenKind.l_paren)) {
        return TPResult.Ambiguous;
      }
      
      // This is a function-style cast in all cases we disambiguate other than
      // one:
      //   struct S {
      //     enum E : int { a = 4 }; // enum
      //     enum E : int { 4 };     // bit-field
      //   };
      if ($this().getLangOpts().CPlusPlus11 && $this().NextToken().is(tok.TokenKind.l_brace)) {
        return BracedCastResult;
      }
      if ($this().isStartOfObjCClassMessageMissingOpenBracket()) {
        return TPResult.False;
      }
      
      return TPResult.True;
     case tok.TokenKind.kw_typeof:
      {
        RevertingTentativeParsingAction PA = null;
        try {
          if ($this().NextToken().isNot(tok.TokenKind.l_paren)) {
            return TPResult.True;
          }
          
          PA/*J*/= new RevertingTentativeParsingAction(/*Deref*/$this());
          
          TPResult TPR = $this().TryParseTypeofSpecifier();
          boolean isFollowedByParen = $this().Tok.is(tok.TokenKind.l_paren);
          boolean isFollowedByBrace = $this().Tok.is(tok.TokenKind.l_brace);
          if (TPR == TPResult.Error) {
            return TPResult.Error;
          }
          if (isFollowedByParen) {
            return TPResult.Ambiguous;
          }
          if ($this().getLangOpts().CPlusPlus11 && isFollowedByBrace) {
            return BracedCastResult;
          }
          
          return TPResult.True;
        } finally {
          if (PA != null) { PA.$destroy(); }
        }
      }
     case tok.TokenKind.kw___underlying_type:
      
      // C++0x type traits support
      return TPResult.True;
     case tok.TokenKind.kw__Atomic:
      
      // C11 _Atomic
      return TPResult.True;
     default:
      return TPResult.False;
    }
  }


/// Given that isCXXDeclarationSpecifier returns \c TPResult::True or
/// \c TPResult::Ambiguous, determine whether the decl-specifier would be
/// a type-specifier other than a cv-qualifier.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isCXXDeclarationSpecifierAType">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 1554,
   FQN="clang::Parser::isCXXDeclarationSpecifierAType", NM="_ZN5clang6Parser30isCXXDeclarationSpecifierATypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser30isCXXDeclarationSpecifierATypeEv")
  //</editor-fold>
  protected /*private*/ boolean isCXXDeclarationSpecifierAType() {
    switch ($this().Tok.getKind()) {
     case tok.TokenKind.annot_decltype:
     case tok.TokenKind.annot_template_id:
     case tok.TokenKind.annot_typename:
     case tok.TokenKind.kw_typeof:
     case tok.TokenKind.kw___underlying_type:
      // typename-specifier
      return true;
     case tok.TokenKind.kw_class:
     case tok.TokenKind.kw_struct:
     case tok.TokenKind.kw_union:
     case tok.TokenKind.kw___interface:
     case tok.TokenKind.kw_enum:
      
      // elaborated-type-specifier
      return true;
     case tok.TokenKind.kw_char:
     case tok.TokenKind.kw_wchar_t:
     case tok.TokenKind.kw_char16_t:
     case tok.TokenKind.kw_char32_t:
     case tok.TokenKind.kw_bool:
     case tok.TokenKind.kw_short:
     case tok.TokenKind.kw_int:
     case tok.TokenKind.kw_long:
     case tok.TokenKind.kw___int64:
     case tok.TokenKind.kw___int128:
     case tok.TokenKind.kw_signed:
     case tok.TokenKind.kw_unsigned:
     case tok.TokenKind.kw_half:
     case tok.TokenKind.kw_float:
     case tok.TokenKind.kw_double:
     case tok.TokenKind.kw___float128:
     case tok.TokenKind.kw_void:
     case tok.TokenKind.kw___unknown_anytype:
     case tok.TokenKind.kw___auto_type:
      
      // simple-type-specifier
      return true;
     case tok.TokenKind.kw_auto:
      return $this().getLangOpts().CPlusPlus11;
     case tok.TokenKind.kw__Atomic:
      // "_Atomic foo"
      return $this().NextToken().is(tok.TokenKind.l_paren);
     default:
      return false;
    }
  }


/// \brief Determine whether an identifier has been tentatively declared as a
/// non-type. Such tentative declarations should not be found to name a type
/// during a tentative parse, but also should not be annotated as a non-type.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isTentativelyDeclared">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*fixed compare of std.find return value*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 1072,
   FQN="clang::Parser::isTentativelyDeclared", NM="_ZN5clang6Parser21isTentativelyDeclaredEPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser21isTentativelyDeclaredEPNS_14IdentifierInfoE")
  //</editor-fold>
  protected /*private*/ boolean isTentativelyDeclared(IdentifierInfo /*P*/ II) {
    return $noteq_ptr(std.find($this().TentativelyDeclaredIdentifiers.begin(), 
        $this().TentativelyDeclaredIdentifiers.end(), II, true),
       $this().TentativelyDeclaredIdentifiers.end());
  }


// "Tentative parsing" functions, used for disambiguation. If a parsing error
// is encountered they will return TPResult::Error.
// Returning TPResult::True/False indicates that the ambiguity was
// resolved and tentative parsing may stop. TPResult::Ambiguous indicates
// that more tentative parsing is necessary for disambiguation.
// They all consume tokens, so backtracking should be used after calling them.

/// simple-declaration:
///   decl-specifier-seq init-declarator-list[opt] ';'
///
/// (if AllowForRangeDecl specified)
/// for ( for-range-declaration : for-range-initializer ) statement
/// for-range-declaration: 
///    attribute-specifier-seqopt type-specifier-seq declarator
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TryParseSimpleDeclaration">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 232,
   FQN="clang::Parser::TryParseSimpleDeclaration", NM="_ZN5clang6Parser25TryParseSimpleDeclarationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser25TryParseSimpleDeclarationEb")
  //</editor-fold>
  protected /*private*/ Parser.TPResult TryParseSimpleDeclaration(boolean AllowForRangeDecl) {
    if ($this().TryConsumeDeclarationSpecifier() == TPResult.Error) {
      return TPResult.Error;
    }
    
    // Two decl-specifiers in a row conclusively disambiguate this as being a
    // simple-declaration. Don't bother calling isCXXDeclarationSpecifier in the
    // overwhelmingly common case that the next token is a '('.
    if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
      TPResult TPR = $this().isCXXDeclarationSpecifier();
      if (TPR == TPResult.Ambiguous) {
        return TPResult.True;
      }
      if (TPR == TPResult.True || TPR == TPResult.Error) {
        return TPR;
      }
      assert (TPR == TPResult.False);
    }
    
    TPResult TPR = $this().TryParseInitDeclaratorList();
    if (TPR != TPResult.Ambiguous) {
      return TPR;
    }
    if ($this().Tok.isNot(tok.TokenKind.semi) && (!AllowForRangeDecl || $this().Tok.isNot(tok.TokenKind.colon))) {
      return TPResult.False;
    }
    
    return TPResult.Ambiguous;
  }


/// [GNU] typeof-specifier:
///         'typeof' '(' expressions ')'
///         'typeof' '(' type-name ')'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TryParseTypeofSpecifier">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 1610,
   FQN="clang::Parser::TryParseTypeofSpecifier", NM="_ZN5clang6Parser23TryParseTypeofSpecifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser23TryParseTypeofSpecifierEv")
  //</editor-fold>
  protected /*private*/ Parser.TPResult TryParseTypeofSpecifier() {
    assert ($this().Tok.is(tok.TokenKind.kw_typeof)) : "Expected 'typeof'!";
    $this().ConsumeToken();
    assert ($this().Tok.is(tok.TokenKind.l_paren)) : "Expected '('";
    // Parse through the parens after 'typeof'.
    $this().ConsumeParen();
    if (!$this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi)) {
      return TPResult.Error;
    }
    
    return TPResult.Ambiguous;
  }


/// [ObjC] protocol-qualifiers:
////         '<' identifier-list '>'
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TryParseProtocolQualifiers">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 1625,
   FQN="clang::Parser::TryParseProtocolQualifiers", NM="_ZN5clang6Parser26TryParseProtocolQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser26TryParseProtocolQualifiersEv")
  //</editor-fold>
  protected /*private*/ Parser.TPResult TryParseProtocolQualifiers() {
    assert ($this().Tok.is(tok.TokenKind.less)) : "Expected '<' for qualifier list";
    $this().ConsumeToken();
    do {
      if ($this().Tok.isNot(tok.TokenKind.identifier)) {
        return TPResult.Error;
      }
      $this().ConsumeToken();
      if ($this().Tok.is(tok.TokenKind.comma)) {
        $this().ConsumeToken();
        continue;
      }
      if ($this().Tok.is(tok.TokenKind.greater)) {
        $this().ConsumeToken();
        return TPResult.Ambiguous;
      }
    } while (false);
    
    return TPResult.Error;
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::TryParsePtrOperatorSeq">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 693,
   FQN="clang::Parser::TryParsePtrOperatorSeq", NM="_ZN5clang6Parser22TryParsePtrOperatorSeqEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser22TryParsePtrOperatorSeqEv")
  //</editor-fold>
  protected /*private*/ Parser.TPResult TryParsePtrOperatorSeq() {
    while (true) {
      if ($this().Tok.isOneOf(tok.TokenKind.coloncolon, tok.TokenKind.identifier)) {
        if ($this().TryAnnotateCXXScopeToken(true)) {
          return TPResult.Error;
        }
      }
      if ($this().Tok.isOneOf$T(tok.TokenKind.star, tok.TokenKind.amp, tok.TokenKind.caret, tok.TokenKind.ampamp)
         || ($this().Tok.is(tok.TokenKind.annot_cxxscope) && $this().NextToken().is(tok.TokenKind.star))) {
        // ptr-operator
        $this().ConsumeToken();
        while ($this().Tok.isOneOf$T(tok.TokenKind.kw_const, tok.TokenKind.kw_volatile, tok.TokenKind.kw_restrict, 
            tok.TokenKind.kw__Nonnull, tok.TokenKind.kw__Nullable, 
            tok.TokenKind.kw__Null_unspecified)) {
          $this().ConsumeToken();
        }
      } else {
        return TPResult.True;
      }
    }
  }


///         operator-function-id:
///           'operator' operator
///
///         operator: one of
///           new  delete  new[]  delete[]  +  -  *  /  %  ^  [...]
///
///         conversion-function-id:
///           'operator' conversion-type-id
///
///         conversion-type-id:
///           type-specifier-seq conversion-declarator[opt]
///
///         conversion-declarator:
///           ptr-operator conversion-declarator[opt]
///
///         literal-operator-id:
///           'operator' string-literal identifier
///           'operator' user-defined-string-literal
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TryParseOperatorId">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 731,
   FQN="clang::Parser::TryParseOperatorId", NM="_ZN5clang6Parser18TryParseOperatorIdEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser18TryParseOperatorIdEv")
  //</editor-fold>
  protected /*private*/ Parser.TPResult TryParseOperatorId() {
    assert ($this().Tok.is(tok.TokenKind.kw_operator));
    $this().ConsumeToken();
    
    // Maybe this is an operator-function-id.
    switch ($this().Tok.getKind()) {
     case tok.TokenKind.kw_new:
     case tok.TokenKind.kw_delete:
      $this().ConsumeToken();
      if ($this().Tok.is(tok.TokenKind.l_square) && $this().NextToken().is(tok.TokenKind.r_square)) {
        $this().ConsumeBracket();
        $this().ConsumeBracket();
      }
      return TPResult.True;
     case tok.TokenKind.plus:
     case tok.TokenKind.minus:
     case tok.TokenKind.star:
     case tok.TokenKind.slash:
     case tok.TokenKind.percent:
     case tok.TokenKind.caret:
     case tok.TokenKind.amp:
     case tok.TokenKind.pipe:
     case tok.TokenKind.tilde:
     case tok.TokenKind.exclaim:
     case tok.TokenKind.equal:
     case tok.TokenKind.less:
     case tok.TokenKind.greater:
     case tok.TokenKind.plusequal:
     case tok.TokenKind.minusequal:
     case tok.TokenKind.starequal:
     case tok.TokenKind.slashequal:
     case tok.TokenKind.percentequal:
     case tok.TokenKind.caretequal:
     case tok.TokenKind.ampequal:
     case tok.TokenKind.pipeequal:
     case tok.TokenKind.lessless:
     case tok.TokenKind.greatergreater:
     case tok.TokenKind.lesslessequal:
     case tok.TokenKind.greatergreaterequal:
     case tok.TokenKind.equalequal:
     case tok.TokenKind.exclaimequal:
     case tok.TokenKind.lessequal:
     case tok.TokenKind.greaterequal:
     case tok.TokenKind.ampamp:
     case tok.TokenKind.pipepipe:
     case tok.TokenKind.plusplus:
     case tok.TokenKind.minusminus:
     case tok.TokenKind.comma:
     case tok.TokenKind.arrowstar:
     case tok.TokenKind.arrow:
     case tok.TokenKind.kw_co_await:
      $this().ConsumeToken();
      return TPResult.True;
     case tok.TokenKind.l_square:
      if ($this().NextToken().is(tok.TokenKind.r_square)) {
        $this().ConsumeBracket();
        $this().ConsumeBracket();
        return TPResult.True;
      }
      break;
     case tok.TokenKind.l_paren:
      if ($this().NextToken().is(tok.TokenKind.r_paren)) {
        $this().ConsumeParen();
        $this().ConsumeParen();
        return TPResult.True;
      }
      break;
     default:
      break;
    }
    
    // Maybe this is a literal-operator-id.
    if ($this().getLangOpts().CPlusPlus11 && $this().isTokenStringLiteral()) {
      boolean FoundUDSuffix = false;
      do {
        FoundUDSuffix |= $this().Tok.hasUDSuffix();
        $this().ConsumeStringToken();
      } while ($this().isTokenStringLiteral());
      if (!FoundUDSuffix) {
        if ($this().Tok.is(tok.TokenKind.identifier)) {
          $this().ConsumeToken();
        } else {
          return TPResult.Error;
        }
      }
      return TPResult.True;
    }
    
    // Maybe this is a conversion-function-id.
    boolean AnyDeclSpecifiers = false;
    while (true) {
      TPResult TPR = $this().isCXXDeclarationSpecifier();
      if (TPR == TPResult.Error) {
        return TPR;
      }
      if (TPR == TPResult.False) {
        if (!AnyDeclSpecifiers) {
          return TPResult.Error;
        }
        break;
      }
      if ($this().TryConsumeDeclarationSpecifier() == TPResult.Error) {
        return TPResult.Error;
      }
      AnyDeclSpecifiers = true;
    }
    return $this().TryParsePtrOperatorSeq();
  }


/// Tentatively parse an init-declarator-list in order to disambiguate it from
/// an expression.
///
///       init-declarator-list:
///         init-declarator
///         init-declarator-list ',' init-declarator
///
///       init-declarator:
///         declarator initializer[opt]
/// [GNU]   declarator simple-asm-expr[opt] attributes[opt] initializer[opt]
///
///       initializer:
///         brace-or-equal-initializer
///         '(' expression-list ')'
///
///       brace-or-equal-initializer:
///         '=' initializer-clause
/// [C++11] braced-init-list
///
///       initializer-clause:
///         assignment-expression
///         braced-init-list
///
///       braced-init-list:
///         '{' initializer-list ','[opt] '}'
///         '{' '}'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TryParseInitDeclaratorList">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 285,
   FQN="clang::Parser::TryParseInitDeclaratorList", NM="_ZN5clang6Parser26TryParseInitDeclaratorListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser26TryParseInitDeclaratorListEv")
  //</editor-fold>
  protected /*private*/ Parser.TPResult TryParseInitDeclaratorList() {
    while (true) {
      // declarator
      TPResult TPR = $this().TryParseDeclarator(false/*mayBeAbstract*/);
      if (TPR != TPResult.Ambiguous) {
        return TPR;
      }
      
      // [GNU] simple-asm-expr[opt] attributes[opt]
      if ($this().Tok.isOneOf(tok.TokenKind.kw_asm, tok.TokenKind.kw___attribute)) {
        return TPResult.True;
      }
      
      // initializer[opt]
      if ($this().Tok.is(tok.TokenKind.l_paren)) {
        // Parse through the parens.
        $this().ConsumeParen();
        if (!$this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi)) {
          return TPResult.Error;
        }
      } else if ($this().Tok.is(tok.TokenKind.l_brace)) {
        // A left-brace here is sufficient to disambiguate the parse; an
        // expression can never be followed directly by a braced-init-list.
        return TPResult.True;
      } else if ($this().Tok.is(tok.TokenKind.equal) || $this().isTokIdentifier_in()) {
        // MSVC and g++ won't examine the rest of declarators if '=' is
        // encountered; they just conclude that we have a declaration.
        // EDG parses the initializer completely, which is the proper behavior
        // for this case.
        //
        // At present, Clang follows MSVC and g++, since the parser does not have
        // the ability to parse an expression fully without recording the
        // results of that parse.
        // FIXME: Handle this case correctly.
        //
        // Also allow 'in' after an Objective-C declaration as in:
        // for (int (^b)(void) in array). Ideally this should be done in the
        // context of parsing for-init-statement of a foreach statement only. But,
        // in any other context 'in' is invalid after a declaration and parser
        // issues the error regardless of outcome of this decision.
        // FIXME: Change if above assumption does not hold.
        return TPResult.True;
      }
      if (!$this().TryConsumeToken(tok.TokenKind.comma)) {
        break;
      }
    }
    
    return TPResult.Ambiguous;
  }


///         declarator:
///           direct-declarator
///           ptr-operator declarator
///
///         direct-declarator:
///           declarator-id
///           direct-declarator '(' parameter-declaration-clause ')'
///                 cv-qualifier-seq[opt] exception-specification[opt]
///           direct-declarator '[' constant-expression[opt] ']'
///           '(' declarator ')'
/// [GNU]     '(' attributes declarator ')'
///
///         abstract-declarator:
///           ptr-operator abstract-declarator[opt]
///           direct-abstract-declarator
///           ...
///
///         direct-abstract-declarator:
///           direct-abstract-declarator[opt]
///           '(' parameter-declaration-clause ')' cv-qualifier-seq[opt]
///                 exception-specification[opt]
///           direct-abstract-declarator[opt] '[' constant-expression[opt] ']'
///           '(' abstract-declarator ')'
///
///         ptr-operator:
///           '*' cv-qualifier-seq[opt]
///           '&'
/// [C++0x]   '&&'                                                        [TODO]
///           '::'[opt] nested-name-specifier '*' cv-qualifier-seq[opt]
///
///         cv-qualifier-seq:
///           cv-qualifier cv-qualifier-seq[opt]
///
///         cv-qualifier:
///           'const'
///           'volatile'
///
///         declarator-id:
///           '...'[opt] id-expression
///
///         id-expression:
///           unqualified-id
///           qualified-id                                                [TODO]
///
///         unqualified-id:
///           identifier
///           operator-function-id
///           conversion-function-id
///           literal-operator-id
///           '~' class-name                                              [TODO]
///           '~' decltype-specifier                                      [TODO]
///           template-id                                                 [TODO]
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TryParseDeclarator">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 860,
   FQN="clang::Parser::TryParseDeclarator", NM="_ZN5clang6Parser18TryParseDeclaratorEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser18TryParseDeclaratorEbb")
  //</editor-fold>
  protected /*private*/ Parser.TPResult TryParseDeclarator(boolean mayBeAbstract) {
    return $this().TryParseDeclarator(mayBeAbstract, 
                    true);
  }
  protected /*private*/ Parser.TPResult TryParseDeclarator(boolean mayBeAbstract, 
                    boolean mayHaveIdentifier/*= true*/) {
    // declarator:
    //   direct-declarator
    //   ptr-operator declarator
    if ($this().TryParsePtrOperatorSeq() == TPResult.Error) {
      return TPResult.Error;
    }
    
    // direct-declarator:
    // direct-abstract-declarator:
    if ($this().Tok.is(tok.TokenKind.ellipsis)) {
      $this().ConsumeToken();
    }
    if (($this().Tok.isOneOf(tok.TokenKind.identifier, tok.TokenKind.kw_operator)
       || ($this().Tok.is(tok.TokenKind.annot_cxxscope) && ($this().NextToken().is(tok.TokenKind.identifier)
       || $this().NextToken().is(tok.TokenKind.kw_operator))))
       && mayHaveIdentifier) {
      // declarator-id
      if ($this().Tok.is(tok.TokenKind.annot_cxxscope)) {
        $this().ConsumeToken();
      } else if ($this().Tok.is(tok.TokenKind.identifier)) {
        $this().TentativelyDeclaredIdentifiers.push_back($this().Tok.getIdentifierInfo());
      }
      if ($this().Tok.is(tok.TokenKind.kw_operator)) {
        if ($this().TryParseOperatorId() == TPResult.Error) {
          return TPResult.Error;
        }
      } else {
        $this().ConsumeToken();
      }
    } else if ($this().Tok.is(tok.TokenKind.l_paren)) {
      $this().ConsumeParen();
      if (mayBeAbstract
         && ($this().Tok.is(tok.TokenKind.r_paren) // 'int()' is a function.
        // 'int(...)' is a function.
         || ($this().Tok.is(tok.TokenKind.ellipsis) && $this().NextToken().is(tok.TokenKind.r_paren))
         || $this().isDeclarationSpecifier())) { // 'int(int)' is a function.
  // '(' parameter-declaration-clause ')' cv-qualifier-seq[opt]
  //        exception-specification[opt]
        TPResult TPR = $this().TryParseFunctionDeclarator();
        if (TPR != TPResult.Ambiguous) {
          return TPR;
        }
      } else {
        // '(' declarator ')'
        // '(' attributes declarator ')'
        // '(' abstract-declarator ')'
        if ($this().Tok.isOneOf$T(tok.TokenKind.kw___attribute, tok.TokenKind.kw___declspec, tok.TokenKind.kw___cdecl, 
            tok.TokenKind.kw___stdcall, tok.TokenKind.kw___fastcall, tok.TokenKind.kw___thiscall, 
            tok.TokenKind.kw___vectorcall)) {
          return TPResult.True; // attributes indicate declaration
        }
        TPResult TPR = $this().TryParseDeclarator(mayBeAbstract, mayHaveIdentifier);
        if (TPR != TPResult.Ambiguous) {
          return TPR;
        }
        if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
          return TPResult.False;
        }
        $this().ConsumeParen();
      }
    } else if (!mayBeAbstract) {
      return TPResult.False;
    }
    while (true) {
      TPResult TPR/*J*/= TPResult.Ambiguous;
      
      // abstract-declarator: ...
      if ($this().Tok.is(tok.TokenKind.ellipsis)) {
        $this().ConsumeToken();
      }
      if ($this().Tok.is(tok.TokenKind.l_paren)) {
        // Check whether we have a function declarator or a possible ctor-style
        // initializer that follows the declarator. Note that ctor-style
        // initializers are not possible in contexts where abstract declarators
        // are allowed.
        if (!mayBeAbstract && !$this().isCXXFunctionDeclarator()) {
          break;
        }
        
        // direct-declarator '(' parameter-declaration-clause ')'
        //        cv-qualifier-seq[opt] exception-specification[opt]
        $this().ConsumeParen();
        TPR = $this().TryParseFunctionDeclarator();
      } else if ($this().Tok.is(tok.TokenKind.l_square)) {
        // direct-declarator '[' constant-expression[opt] ']'
        // direct-abstract-declarator[opt] '[' constant-expression[opt] ']'
        TPR = $this().TryParseBracketDeclarator();
      } else {
        break;
      }
      if (TPR != TPResult.Ambiguous) {
        return TPR;
      }
    }
    
    return TPResult.Ambiguous;
  }


/// parameter-declaration-clause:
///   parameter-declaration-list[opt] '...'[opt]
///   parameter-declaration-list ',' '...'
///
/// parameter-declaration-list:
///   parameter-declaration
///   parameter-declaration-list ',' parameter-declaration
///
/// parameter-declaration:
///   attribute-specifier-seq[opt] decl-specifier-seq declarator attributes[opt]
///   attribute-specifier-seq[opt] decl-specifier-seq declarator attributes[opt]
///     '=' assignment-expression
///   attribute-specifier-seq[opt] decl-specifier-seq abstract-declarator[opt]
///     attributes[opt]
///   attribute-specifier-seq[opt] decl-specifier-seq abstract-declarator[opt]
///     attributes[opt] '=' assignment-expression
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TryParseParameterDeclarationClause">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 1716,
   FQN="clang::Parser::TryParseParameterDeclarationClause", NM="_ZN5clang6Parser34TryParseParameterDeclarationClauseEPbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser34TryParseParameterDeclarationClauseEPbb")
  //</editor-fold>
  protected /*private*/ Parser.TPResult TryParseParameterDeclarationClause() {
    return $this().TryParseParameterDeclarationClause((bool$ptr/*bool P*/ )null, 
                                    false);
  }
  protected /*private*/ Parser.TPResult TryParseParameterDeclarationClause(bool$ptr/*bool P*/ InvalidAsDeclaration/*= null*/) {
    return $this().TryParseParameterDeclarationClause(InvalidAsDeclaration, 
                                    false);
  }
  protected /*private*/ Parser.TPResult TryParseParameterDeclarationClause(bool$ptr/*bool P*/ InvalidAsDeclaration/*= null*/, 
                                    boolean VersusTemplateArgument/*= false*/) {
    if ($this().Tok.is(tok.TokenKind.r_paren)) {
      return TPResult.Ambiguous;
    }
    
    //   parameter-declaration-list[opt] '...'[opt]
    //   parameter-declaration-list ',' '...'
    //
    // parameter-declaration-list:
    //   parameter-declaration
    //   parameter-declaration-list ',' parameter-declaration
    //
    while (true) {
      ParsedAttributes attrs = null;
      try {
        // '...'[opt]
        if ($this().Tok.is(tok.TokenKind.ellipsis)) {
          $this().ConsumeToken();
          if ($this().Tok.is(tok.TokenKind.r_paren)) {
            return TPResult.True; // '...)' is a sign of a function declarator.
          } else {
            return TPResult.False;
          }
        }
        
        // An attribute-specifier-seq here is a sign of a function declarator.
        if (($this().isCXX11AttributeSpecifier(/*Disambiguate*/ false, 
            /*OuterMightBeMessageSend*/ true).getValue() != 0)) {
          return TPResult.True;
        }
        
        attrs/*J*/= new ParsedAttributes($this().AttrFactory);
        $this().MaybeParseMicrosoftAttributes(attrs);
        
        // decl-specifier-seq
        // A parameter-declaration's initializer must be preceded by an '=', so
        // decl-specifier-seq '{' is not a parameter in C++11.
        TPResult TPR = $this().isCXXDeclarationSpecifier(TPResult.False, 
            InvalidAsDeclaration);
        if (VersusTemplateArgument && TPR == TPResult.True) {
          // Consume the decl-specifier-seq. We have to look past it, since a
          // type-id might appear here in a template argument.
          boolean SeenType = false;
          do {
            SeenType |= $this().isCXXDeclarationSpecifierAType();
            if ($this().TryConsumeDeclarationSpecifier() == TPResult.Error) {
              return TPResult.Error;
            }
            
            // If we see a parameter name, this can't be a template argument.
            if (SeenType && $this().Tok.is(tok.TokenKind.identifier)) {
              return TPResult.True;
            }
            
            TPR = $this().isCXXDeclarationSpecifier(TPResult.False, 
                InvalidAsDeclaration);
            if (TPR == TPResult.Error) {
              return TPR;
            }
          } while (TPR != TPResult.False);
        } else if (TPR == TPResult.Ambiguous) {
          // Disambiguate what follows the decl-specifier.
          if ($this().TryConsumeDeclarationSpecifier() == TPResult.Error) {
            return TPResult.Error;
          }
        } else {
          return TPR;
        }
        
        // declarator
        // abstract-declarator[opt]
        TPR = $this().TryParseDeclarator(true/*mayBeAbstract*/);
        if (TPR != TPResult.Ambiguous) {
          return TPR;
        }
        
        // [GNU] attributes[opt]
        if ($this().Tok.is(tok.TokenKind.kw___attribute)) {
          return TPResult.True;
        }
        
        // If we're disambiguating a template argument in a default argument in
        // a class definition versus a parameter declaration, an '=' here
        // disambiguates the parse one way or the other.
        // If this is a parameter, it must have a default argument because
        //   (a) the previous parameter did, and
        //   (b) this must be the first declaration of the function, so we can't
        //       inherit any default arguments from elsewhere.
        // If we see an ')', then we've reached the end of a
        // parameter-declaration-clause, and the last param is missing its default
        // argument.
        if (VersusTemplateArgument) {
          return $this().Tok.isOneOf(tok.TokenKind.equal, tok.TokenKind.r_paren) ? TPResult.True : TPResult.False;
        }
        if ($this().Tok.is(tok.TokenKind.equal)) {
          // '=' assignment-expression
          // Parse through assignment-expression.
          // FIXME: assignment-expression may contain an unparenthesized comma.
          if (!$this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.r_paren, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch))) {
            return TPResult.Error;
          }
        }
        if ($this().Tok.is(tok.TokenKind.ellipsis)) {
          $this().ConsumeToken();
          if ($this().Tok.is(tok.TokenKind.r_paren)) {
            return TPResult.True; // '...)' is a sign of a function declarator.
          } else {
            return TPResult.False;
          }
        }
        if (!$this().TryConsumeToken(tok.TokenKind.comma)) {
          break;
        }
      } finally {
        if (attrs != null) { attrs.$destroy(); }
      }
    }
    
    return TPResult.Ambiguous;
  }


/// TryParseFunctionDeclarator - We parsed a '(' and we want to try to continue
/// parsing as a function declarator.
/// If TryParseFunctionDeclarator fully parsed the function declarator, it will
/// return TPResult::Ambiguous, otherwise it will return either False() or
/// Error().
///
/// '(' parameter-declaration-clause ')' cv-qualifier-seq[opt]
///         exception-specification[opt]
///
/// exception-specification:
///   'throw' '(' type-id-list[opt] ')'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TryParseFunctionDeclarator">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 1838,
   FQN="clang::Parser::TryParseFunctionDeclarator", NM="_ZN5clang6Parser26TryParseFunctionDeclaratorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser26TryParseFunctionDeclaratorEv")
  //</editor-fold>
  protected /*private*/ Parser.TPResult TryParseFunctionDeclarator() {
    
    // The '(' is already parsed.
    TPResult TPR = $this().TryParseParameterDeclarationClause();
    if (TPR == TPResult.Ambiguous && $this().Tok.isNot(tok.TokenKind.r_paren)) {
      TPR = TPResult.False;
    }
    if (TPR == TPResult.False || TPR == TPResult.Error) {
      return TPR;
    }
    
    // Parse through the parens.
    if (!$this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi)) {
      return TPResult.Error;
    }
    
    // cv-qualifier-seq
    while ($this().Tok.isOneOf$T(tok.TokenKind.kw_const, tok.TokenKind.kw_volatile, tok.TokenKind.kw_restrict)) {
      $this().ConsumeToken();
    }
    
    // ref-qualifier[opt]
    if ($this().Tok.isOneOf(tok.TokenKind.amp, tok.TokenKind.ampamp)) {
      $this().ConsumeToken();
    }
    
    // exception-specification
    if ($this().Tok.is(tok.TokenKind.kw_throw)) {
      $this().ConsumeToken();
      if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
        return TPResult.Error;
      }
      
      // Parse through the parens after 'throw'.
      $this().ConsumeParen();
      if (!$this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi)) {
        return TPResult.Error;
      }
    }
    if ($this().Tok.is(tok.TokenKind.kw_noexcept)) {
      $this().ConsumeToken();
      // Possibly an expression as well.
      if ($this().Tok.is(tok.TokenKind.l_paren)) {
        // Find the matching rparen.
        $this().ConsumeParen();
        if (!$this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi)) {
          return TPResult.Error;
        }
      }
    }
    
    return TPResult.Ambiguous;
  }


/// '[' constant-expression[opt] ']'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TryParseBracketDeclarator">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 1888,
   FQN="clang::Parser::TryParseBracketDeclarator", NM="_ZN5clang6Parser25TryParseBracketDeclaratorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser25TryParseBracketDeclaratorEv")
  //</editor-fold>
  protected /*private*/ Parser.TPResult TryParseBracketDeclarator() {
    $this().ConsumeBracket();
    if (!$this().SkipUntil(tok.TokenKind.r_square, SkipUntilFlags.StopAtSemi)) {
      return TPResult.Error;
    }
    
    return TPResult.Ambiguous;
  }


/// Try to consume a token sequence that we've already identified as
/// (potentially) starting a decl-specifier.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TryConsumeDeclarationSpecifier">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 148,
   FQN="clang::Parser::TryConsumeDeclarationSpecifier", NM="_ZN5clang6Parser30TryConsumeDeclarationSpecifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser30TryConsumeDeclarationSpecifierEv")
  //</editor-fold>
  protected /*private*/ Parser.TPResult TryConsumeDeclarationSpecifier() {
    switch ($this().Tok.getKind()) {
     case tok.TokenKind.kw__Atomic:
      if ($this().NextToken().isNot(tok.TokenKind.l_paren)) {
        $this().ConsumeToken();
        break;
      }
     case tok.TokenKind.kw_typeof:
     case tok.TokenKind.kw___attribute:
     case tok.TokenKind.kw___underlying_type:
      {
        $this().ConsumeToken();
        if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
          return TPResult.Error;
        }
        $this().ConsumeParen();
        if (!$this().SkipUntil(tok.TokenKind.r_paren)) {
          return TPResult.Error;
        }
        break;
      }
     case tok.TokenKind.kw_class:
     case tok.TokenKind.kw_struct:
     case tok.TokenKind.kw_union:
     case tok.TokenKind.kw___interface:
     case tok.TokenKind.kw_enum:
      // elaborated-type-specifier:
      //     class-key attribute-specifier-seq[opt]
      //         nested-name-specifier[opt] identifier
      //     class-key nested-name-specifier[opt] template[opt] simple-template-id
      //     enum nested-name-specifier[opt] identifier
      //
      // FIXME: We don't support class-specifiers nor enum-specifiers here.
      $this().ConsumeToken();
      
      // Skip attributes.
      while ($this().Tok.isOneOf$T(tok.TokenKind.l_square, tok.TokenKind.kw___attribute, tok.TokenKind.kw___declspec, 
          tok.TokenKind.kw_alignas)) {
        if ($this().Tok.is(tok.TokenKind.l_square)) {
          $this().ConsumeBracket();
          if (!$this().SkipUntil(tok.TokenKind.r_square)) {
            return TPResult.Error;
          }
        } else {
          $this().ConsumeToken();
          if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
            return TPResult.Error;
          }
          $this().ConsumeParen();
          if (!$this().SkipUntil(tok.TokenKind.r_paren)) {
            return TPResult.Error;
          }
        }
      }
      if ($this().Tok.isOneOf$T(tok.TokenKind.identifier, tok.TokenKind.coloncolon, tok.TokenKind.kw_decltype, 
          tok.TokenKind.annot_template_id)
         && $this().TryAnnotateCXXScopeToken()) {
        return TPResult.Error;
      }
      if ($this().Tok.is(tok.TokenKind.annot_cxxscope)) {
        $this().ConsumeToken();
      }
      if ($this().Tok.isNot(tok.TokenKind.identifier) && $this().Tok.isNot(tok.TokenKind.annot_template_id)) {
        return TPResult.Error;
      }
      $this().ConsumeToken();
      break;
     case tok.TokenKind.annot_cxxscope:
      $this().ConsumeToken();
     default:
      // Fall through.
      $this().ConsumeToken();
      if ($this().getLangOpts().ObjC1 && $this().Tok.is(tok.TokenKind.less)) {
        return $this().TryParseProtocolQualifiers();
      }
      break;
    }
    
    return TPResult.Ambiguous;
  }


/// \brief Returns true if this is a C++11 attribute-specifier. Per
/// C++11 [dcl.attr.grammar]p6, two consecutive left square bracket tokens
/// always introduce an attribute. In Objective-C++11, this rule does not
/// apply if either '[' begins a message-send.
///
/// If Disambiguate is true, we try harder to determine whether a '[[' starts
/// an attribute-specifier, and return CAK_InvalidAttributeSpecifier if not.
///
/// If OuterMightBeMessageSend is true, we assume the outer '[' is either an
/// Obj-C message send or the start of an attribute. Otherwise, we assume it
/// is not an Obj-C message send.
///
/// C++11 [dcl.attr.grammar]:
///
///     attribute-specifier:
///         '[' '[' attribute-list ']' ']'
///         alignment-specifier
///
///     attribute-list:
///         attribute[opt]
///         attribute-list ',' attribute[opt]
///         attribute '...'
///         attribute-list ',' attribute '...'
///
///     attribute:
///         attribute-token attribute-argument-clause[opt]
///
///     attribute-token:
///         identifier
///         identifier '::' identifier
///
///     attribute-argument-clause:
///         '(' balanced-token-seq ')'
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isCXX11AttributeSpecifier">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 574,
   FQN="clang::Parser::isCXX11AttributeSpecifier", NM="_ZN5clang6Parser25isCXX11AttributeSpecifierEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser25isCXX11AttributeSpecifierEbb")
  //</editor-fold>
  protected /*private*/ Parser.CXX11AttributeKind isCXX11AttributeSpecifier() {
    return $this().isCXX11AttributeSpecifier(false, 
                           false);
  }
  protected /*private*/ Parser.CXX11AttributeKind isCXX11AttributeSpecifier(boolean Disambiguate/*= false*/) {
    return $this().isCXX11AttributeSpecifier(Disambiguate, 
                           false);
  }
  protected /*private*/ Parser.CXX11AttributeKind isCXX11AttributeSpecifier(boolean Disambiguate/*= false*/, 
                           boolean OuterMightBeMessageSend/*= false*/) {
    RevertingTentativeParsingAction PA = null;
    LambdaIntroducer Intro = null;
    try {
      if ($this().Tok.is(tok.TokenKind.kw_alignas)) {
        return CXX11AttributeKind.CAK_AttributeSpecifier;
      }
      if ($this().Tok.isNot(tok.TokenKind.l_square) || $this().NextToken().isNot(tok.TokenKind.l_square)) {
        return CXX11AttributeKind.CAK_NotAttributeSpecifier;
      }
      
      // No tentative parsing if we don't need to look for ']]' or a lambda.
      if (!Disambiguate && !$this().getLangOpts().ObjC1) {
        return CXX11AttributeKind.CAK_AttributeSpecifier;
      }
      
      PA/*J*/= new RevertingTentativeParsingAction(/*Deref*/$this());
      
      // Opening brackets were checked for above.
      $this().ConsumeBracket();
      
      // Outside Obj-C++11, treat anything with a matching ']]' as an attribute.
      if (!$this().getLangOpts().ObjC1) {
        $this().ConsumeBracket();
        
        boolean IsAttribute = $this().SkipUntil(tok.TokenKind.r_square);
        IsAttribute &= $this().Tok.is(tok.TokenKind.r_square);
        
        return IsAttribute ? CXX11AttributeKind.CAK_AttributeSpecifier : CXX11AttributeKind.CAK_InvalidAttributeSpecifier;
      }
      
      // In Obj-C++11, we need to distinguish four situations:
      //  1a) int x[[attr]];                     C++11 attribute.
      //  1b) [[attr]];                          C++11 statement attribute.
      //   2) int x[[obj](){ return 1; }()];     Lambda in array size/index.
      //  3a) int x[[obj get]];                  Message send in array size/index.
      //  3b) [[Class alloc] init];              Message send in message send.
      //   4) [[obj]{ return self; }() doStuff]; Lambda in message send.
      // (1) is an attribute, (2) is ill-formed, and (3) and (4) are accepted.
      
      // If we have a lambda-introducer, then this is definitely not a message send.
      // FIXME: If this disambiguation is too slow, fold the tentative lambda parse
      // into the tentative attribute parse below.
      Intro/*J*/= new LambdaIntroducer();
      if (!$this().TryParseLambdaIntroducer(Intro)) {
        // A lambda cannot end with ']]', and an attribute must.
        boolean IsAttribute = $this().Tok.is(tok.TokenKind.r_square);
        if (IsAttribute) {
          // Case 1: C++11 attribute.
          return CXX11AttributeKind.CAK_AttributeSpecifier;
        }
        if (OuterMightBeMessageSend) {
          // Case 4: Lambda in message send.
          return CXX11AttributeKind.CAK_NotAttributeSpecifier;
        }
        
        // Case 2: Lambda in array size / index.
        return CXX11AttributeKind.CAK_InvalidAttributeSpecifier;
      }
      
      $this().ConsumeBracket();
      
      // If we don't have a lambda-introducer, then we have an attribute or a
      // message-send.
      boolean IsAttribute = true;
      while ($this().Tok.isNot(tok.TokenKind.r_square)) {
        if ($this().Tok.is(tok.TokenKind.comma)) {
          // Case 1: Stray commas can only occur in attributes.
          return CXX11AttributeKind.CAK_AttributeSpecifier;
        }
        
        // Parse the attribute-token, if present.
        // C++11 [dcl.attr.grammar]:
        //   If a keyword or an alternative token that satisfies the syntactic
        //   requirements of an identifier is contained in an attribute-token,
        //   it is considered an identifier.
        SourceLocation Loc/*J*/= new SourceLocation();
        if (!($this().TryParseCXX11AttributeIdentifier(Loc) != null)) {
          IsAttribute = false;
          break;
        }
        if ($this().Tok.is(tok.TokenKind.coloncolon)) {
          $this().ConsumeToken();
          if (!($this().TryParseCXX11AttributeIdentifier(Loc) != null)) {
            IsAttribute = false;
            break;
          }
        }
        
        // Parse the attribute-argument-clause, if present.
        if ($this().Tok.is(tok.TokenKind.l_paren)) {
          $this().ConsumeParen();
          if (!$this().SkipUntil(tok.TokenKind.r_paren)) {
            IsAttribute = false;
            break;
          }
        }
        
        $this().TryConsumeToken(tok.TokenKind.ellipsis);
        if (!$this().TryConsumeToken(tok.TokenKind.comma)) {
          break;
        }
      }
      
      // An attribute must end ']]'.
      if (IsAttribute) {
        if ($this().Tok.is(tok.TokenKind.r_square)) {
          $this().ConsumeBracket();
          IsAttribute = $this().Tok.is(tok.TokenKind.r_square);
        } else {
          IsAttribute = false;
        }
      }
      if (IsAttribute) {
        // Case 1: C++11 statement attribute.
        return CXX11AttributeKind.CAK_AttributeSpecifier;
      }
      
      // Case 3: Message send.
      return CXX11AttributeKind.CAK_NotAttributeSpecifier;
    } finally {
      if (Intro != null) { Intro.$destroy(); }
      if (PA != null) { PA.$destroy(); }
    }
  }

} // END OF class Parser_ParseTentative
